package org.finos.waltz.data.involvement_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.finos.waltz.model.involvement_group.ImmutableInvolvementGroup;
import org.finos.waltz.model.involvement_group.ImmutableInvolvementGroupCreateCommand;
import org.finos.waltz.model.involvement_group.ImmutableInvolvementGroupCreateCommand.Builder;
import org.finos.waltz.model.involvement_group.InvolvementGroupCreateCommand;
import org.finos.waltz.schema.tables.records.InvolvementGroupRecord;
import org.jooq.DSLContext;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.TransactionalRunnable;
import org.jooq.exception.DataAccessException;
import org.jooq.exception.MappingException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InvolvementGroupDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private InvolvementGroupDao involvementGroupDao;

  /**
   * Test {@link InvolvementGroupDao#createInvolvementGroup(InvolvementGroupCreateCommand)}.
   *
   * <p>Method under test: {@link
   * InvolvementGroupDao#createInvolvementGroup(InvolvementGroupCreateCommand)}
   */
  @Test
  @DisplayName("Test createInvolvementGroup(InvolvementGroupCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long InvolvementGroupDao.createInvolvementGroup(InvolvementGroupCreateCommand)"
  })
  void testCreateInvolvementGroup() throws DataAccessException {
    // Arrange
    InsertResultStep<InvolvementGroupRecord> insertResultStep = mock(InsertResultStep.class);
    InvolvementGroupRecord involvementGroupRecord =
        new InvolvementGroupRecord(1L, "Name", "42", "Provenance");
    when(insertResultStep.fetchOne()).thenReturn(involvementGroupRecord);

    InsertSetMoreStep<InvolvementGroupRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<InvolvementGroupRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<InvolvementGroupRecord>>any()))
        .thenReturn(insertSetStep);

    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act
    Long actualCreateInvolvementGroupResult =
        involvementGroupDao.createInvolvementGroup(
            involvementGroupResult.addAllInvolvementKindIds(new ArrayList<>()).build());

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateInvolvementGroupResult.longValue());
  }

  /**
   * Test {@link InvolvementGroupDao#createInvolvementGroup(InvolvementGroupCreateCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementGroupRecord#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InvolvementGroupDao#createInvolvementGroup(InvolvementGroupCreateCommand)}
   */
  @Test
  @DisplayName("Test createInvolvementGroup(InvolvementGroupCreateCommand); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long InvolvementGroupDao.createInvolvementGroup(InvolvementGroupCreateCommand)"
  })
  void testCreateInvolvementGroup_thenCallsGetId() throws DataAccessException {
    // Arrange
    InvolvementGroupRecord involvementGroupRecord = mock(InvolvementGroupRecord.class);
    when(involvementGroupRecord.getId()).thenReturn(1L);

    InsertResultStep<InvolvementGroupRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(involvementGroupRecord);

    InsertSetMoreStep<InvolvementGroupRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<InvolvementGroupRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<InvolvementGroupRecord>>any()))
        .thenReturn(insertSetStep);

    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act
    Long actualCreateInvolvementGroupResult =
        involvementGroupDao.createInvolvementGroup(
            involvementGroupResult.addAllInvolvementKindIds(new ArrayList<>()).build());

    // Assert
    verify(involvementGroupRecord).getId();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertEquals(1L, actualCreateInvolvementGroupResult.longValue());
  }

  /**
   * Test {@link InvolvementGroupDao#createInvolvementGroup(InvolvementGroupCreateCommand)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InvolvementGroupDao#createInvolvementGroup(InvolvementGroupCreateCommand)}
   */
  @Test
  @DisplayName("Test createInvolvementGroup(InvolvementGroupCreateCommand); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long InvolvementGroupDao.createInvolvementGroup(InvolvementGroupCreateCommand)"
  })
  void testCreateInvolvementGroup_thenReturnNull() throws DataAccessException {
    // Arrange
    InsertResultStep<InvolvementGroupRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(new InvolvementGroupRecord());

    InsertSetMoreStep<InvolvementGroupRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetStep<InvolvementGroupRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);
    when(dSLContext.insertInto(Mockito.<Table<InvolvementGroupRecord>>any()))
        .thenReturn(insertSetStep);

    Builder builderResult = ImmutableInvolvementGroupCreateCommand.builder();

    Builder involvementGroupResult =
        builderResult.involvementGroup(
            ImmutableInvolvementGroup.builder()
                .externalId("42")
                .id(1L)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Act
    Long actualCreateInvolvementGroupResult =
        involvementGroupDao.createInvolvementGroup(
            involvementGroupResult.addAllInvolvementKindIds(new ArrayList<>()).build());

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetStep).set(isA(Record.class));
    assertNull(actualCreateInvolvementGroupResult);
  }

  /**
   * Test {@link InvolvementGroupDao#findAllInvolvementsByGroupId(DSLContext)}.
   *
   * <p>Method under test: {@link InvolvementGroupDao#findAllInvolvementsByGroupId(DSLContext)}
   */
  @Test
  @DisplayName("Test findAllInvolvementsByGroupId(DSLContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map InvolvementGroupDao.findAllInvolvementsByGroupId(DSLContext)"})
  void testFindAllInvolvementsByGroupId() throws MappingException {
    // Arrange
    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchGroups(
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Map<Long, List<Long>> actualFindAllInvolvementsByGroupIdResult =
        InvolvementGroupDao.findAllInvolvementsByGroupId(dSLContext);

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectJoinStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllInvolvementsByGroupIdResult.isEmpty());
  }

  /**
   * Test {@link InvolvementGroupDao#updateInvolvements(Long, Set)}.
   *
   * <ul>
   *   <li>Given minus one.
   *   <li>When {@link HashSet#HashSet()} add minus one.
   *   <li>Then calls {@link PreparedStatement#addBatch()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementGroupDao#updateInvolvements(Long, Set)}
   */
  @Test
  @DisplayName(
      "Test updateInvolvements(Long, Set); given minus one; when HashSet() add minus one; then calls addBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvolvementGroupDao.updateInvolvements(Long, Set)"})
  void testUpdateInvolvements_givenMinusOne_whenHashSetAddMinusOne_thenCallsAddBatch()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    InvolvementGroupDao involvementGroupDao = new InvolvementGroupDao(dsl);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(0L);
    involvementKindIds.add(-1L);

    // Act
    involvementGroupDao.updateInvolvements(1L, involvementKindIds);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link InvolvementGroupDao#updateInvolvements(Long, Set)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#addBatch()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementGroupDao#updateInvolvements(Long, Set)}
   */
  @Test
  @DisplayName("Test updateInvolvements(Long, Set); then calls addBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvolvementGroupDao.updateInvolvements(Long, Set)"})
  void testUpdateInvolvements_thenCallsAddBatch() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    InvolvementGroupDao involvementGroupDao = new InvolvementGroupDao(dsl);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(1L);

    // Act
    involvementGroupDao.updateInvolvements(1L, involvementKindIds);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link InvolvementGroupDao#updateInvolvements(Long, Set)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#addBatch()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementGroupDao#updateInvolvements(Long, Set)}
   */
  @Test
  @DisplayName("Test updateInvolvements(Long, Set); then calls addBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvolvementGroupDao.updateInvolvements(Long, Set)"})
  void testUpdateInvolvements_thenCallsAddBatch2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    InvolvementGroupDao involvementGroupDao = new InvolvementGroupDao(dsl);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(0L);
    involvementKindIds.add(1L);

    // Act
    involvementGroupDao.updateInvolvements(1L, involvementKindIds);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link InvolvementGroupDao#updateInvolvements(Long, Set)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#transaction(TransactionalRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementGroupDao#updateInvolvements(Long, Set)}
   */
  @Test
  @DisplayName("Test updateInvolvements(Long, Set); then calls transaction(TransactionalRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvolvementGroupDao.updateInvolvements(Long, Set)"})
  void testUpdateInvolvements_thenCallsTransaction() {
    // Arrange
    doNothing().when(dSLContext).transaction(Mockito.<TransactionalRunnable>any());

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(1L);

    // Act
    involvementGroupDao.updateInvolvements(1L, involvementKindIds);

    // Assert
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link InvolvementGroupDao#updateInvolvements(Long, Set)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#transaction(TransactionalRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementGroupDao#updateInvolvements(Long, Set)}
   */
  @Test
  @DisplayName("Test updateInvolvements(Long, Set); then calls transaction(TransactionalRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvolvementGroupDao.updateInvolvements(Long, Set)"})
  void testUpdateInvolvements_thenCallsTransaction2() {
    // Arrange
    doNothing().when(dSLContext).transaction(Mockito.<TransactionalRunnable>any());

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(0L);
    involvementKindIds.add(1L);

    // Act
    involvementGroupDao.updateInvolvements(1L, involvementKindIds);

    // Assert
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link InvolvementGroupDao#updateInvolvements(Long, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then calls {@link Connection#commit()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementGroupDao#updateInvolvements(Long, Set)}
   */
  @Test
  @DisplayName("Test updateInvolvements(Long, Set); when HashSet(); then calls commit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvolvementGroupDao.updateInvolvements(Long, Set)"})
  void testUpdateInvolvements_whenHashSet_thenCallsCommit() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    InvolvementGroupDao involvementGroupDao = new InvolvementGroupDao(dsl);

    // Act
    involvementGroupDao.updateInvolvements(1L, new HashSet<>());

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "delete from \"involvement_group_entry\" where \"involvement_group_entry\".\"involvement_group_id\" = ?");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link InvolvementGroupDao#updateInvolvements(Long, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then calls {@link DSLContext#transaction(TransactionalRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementGroupDao#updateInvolvements(Long, Set)}
   */
  @Test
  @DisplayName(
      "Test updateInvolvements(Long, Set); when HashSet(); then calls transaction(TransactionalRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvolvementGroupDao.updateInvolvements(Long, Set)"})
  void testUpdateInvolvements_whenHashSet_thenCallsTransaction() {
    // Arrange
    doNothing().when(dSLContext).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    involvementGroupDao.updateInvolvements(1L, new HashSet<>());

    // Assert
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
  }
}
