package org.finos.waltz.data.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.schema.tables.records.LogicalFlowRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LogicalFlowDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private LogicalFlowDao logicalFlowDao;

  /**
   * Test {@link LogicalFlowDao#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    List<LogicalFlow> actualFindByEntityReferenceResult =
        logicalFlowDao.findByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDao#findBySourcesAndTargets(List)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#findBySourcesAndTargets(List)}
   */
  @Test
  @DisplayName(
      "Test findBySourcesAndTargets(List); given DSLContext; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowDao.findBySourcesAndTargets(List)"})
  void testFindBySourcesAndTargets_givenDSLContext_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(logicalFlowDao.findBySourcesAndTargets(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link LogicalFlowDao#findBySourcesAndTargets(List)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#select(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#findBySourcesAndTargets(List)}
   */
  @Test
  @DisplayName("Test findBySourcesAndTargets(List); then calls select(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowDao.findBySourcesAndTargets(List)"})
  void testFindBySourcesAndTargets_thenCallsSelect() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    ArrayList<Tuple2<EntityReference, EntityReference>> sourceAndTargets = new ArrayList<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Tuple2<EntityReference, EntityReference> tuple2 =
        new Tuple2<>(immutableEntityReference, immutableEntityReference2);
    sourceAndTargets.add(tuple2);

    // Act
    List<LogicalFlow> actualFindBySourcesAndTargetsResult =
        logicalFlowDao.findBySourcesAndTargets(sourceAndTargets);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindBySourcesAndTargetsResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDao#findBySourcesAndTargets(List)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#select(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#findBySourcesAndTargets(List)}
   */
  @Test
  @DisplayName("Test findBySourcesAndTargets(List); then calls select(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowDao.findBySourcesAndTargets(List)"})
  void testFindBySourcesAndTargets_thenCallsSelect2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    ArrayList<Tuple2<EntityReference, EntityReference>> sourceAndTargets = new ArrayList<>();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Tuple2<EntityReference, EntityReference> tuple2 =
        new Tuple2<>(immutableEntityReference, immutableEntityReference2);
    sourceAndTargets.add(tuple2);
    ImmutableEntityReference immutableEntityReference3 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableEntityReference immutableEntityReference4 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Tuple2<EntityReference, EntityReference> tuple22 =
        new Tuple2<>(immutableEntityReference3, immutableEntityReference4);
    sourceAndTargets.add(tuple22);

    // Act
    List<LogicalFlow> actualFindBySourcesAndTargetsResult =
        logicalFlowDao.findBySourcesAndTargets(sourceAndTargets);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindBySourcesAndTargetsResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDao#removeFlow(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#removeFlow(Long, String)}
   */
  @Test
  @DisplayName(
      "Test removeFlow(Long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowDao.removeFlow(Long, String)"})
  void testRemoveFlow_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualRemoveFlowResult = new LogicalFlowDao(dsl).removeFlow(1L, "User");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"logical_flow\" set \"logical_flow\".\"entity_lifecycle_status\" = cast(? as varchar), \"logical_flow\".\"is_removed\" = cast(? as bit(1)), \"logical_flow\".\"last_updated_at\" = cast(? as datetime), \"logical_flow\".\"last_updated_by\" = cast(? as varchar) where \"logical_flow\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(2, true);
    verify(preparedStatement).setLong(5, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveFlowResult);
  }

  /**
   * Test {@link LogicalFlowDao#removeFlow(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#removeFlow(Long, String)}
   */
  @Test
  @DisplayName(
      "Test removeFlow(Long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowDao.removeFlow(Long, String)"})
  void testRemoveFlow_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualRemoveFlowResult = new LogicalFlowDao(dsl).removeFlow(1L, "User");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"logical_flow\" set \"logical_flow\".\"entity_lifecycle_status\" = ?, \"logical_flow\".\"is_removed\" = ?, \"logical_flow\".\"last_updated_at\" = ?, \"logical_flow\".\"last_updated_by\" = ? where \"logical_flow\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(2, true);
    verify(preparedStatement).setLong(5, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveFlowResult);
  }

  /**
   * Test {@link LogicalFlowDao#removeFlow(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#removeFlow(Long, String)}
   */
  @Test
  @DisplayName(
      "Test removeFlow(Long, String); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowDao.removeFlow(Long, String)"})
  void testRemoveFlow_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<LogicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetFirstStep<LogicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);
    when(dSLContext.update(Mockito.<Table<LogicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualRemoveFlowResult = logicalFlowDao.removeFlow(1L, "User");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualRemoveFlowResult);
  }

  /**
   * Test {@link LogicalFlowDao#addFlows(Set, String)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#addFlows(Set, String)}
   */
  @Test
  @DisplayName("Test addFlows(Set, String); when HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LogicalFlowDao.addFlows(Set, String)"})
  void testAddFlows_whenHashSet_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    Set<LogicalFlow> actualAddFlowsResult = logicalFlowDao.addFlows(new HashSet<>(), "User");

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualAddFlowsResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDao#restoreFlow(long, String)} with {@code logicalFlowId}, {@code
   * username}.
   *
   * <p>Method under test: {@link LogicalFlowDao#restoreFlow(long, String)}
   */
  @Test
  @DisplayName("Test restoreFlow(long, String) with 'logicalFlowId', 'username'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LogicalFlowDao.restoreFlow(long, String)"})
  void testRestoreFlowWithLogicalFlowIdUsername() throws DataAccessException {
    // Arrange
    UpdateConditionStep<LogicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(0);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetFirstStep<LogicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);
    when(dSLContext.update(Mockito.<Table<LogicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualRestoreFlowResult = logicalFlowDao.restoreFlow(1L, "janedoe");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertFalse(actualRestoreFlowResult);
  }

  /**
   * Test {@link LogicalFlowDao#restoreFlow(long, String)} with {@code logicalFlowId}, {@code
   * username}.
   *
   * <p>Method under test: {@link LogicalFlowDao#restoreFlow(long, String)}
   */
  @Test
  @DisplayName("Test restoreFlow(long, String) with 'logicalFlowId', 'username'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LogicalFlowDao.restoreFlow(long, String)"})
  void testRestoreFlowWithLogicalFlowIdUsername2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualRestoreFlowResult = new LogicalFlowDao(dsl).restoreFlow(1L, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"logical_flow\" set \"logical_flow\".\"entity_lifecycle_status\" = ?, \"logical_flow\".\"is_removed\" = ?, \"logical_flow\".\"last_updated_by\" = ?, \"logical_flow\".\"last_updated_at\" = ? where \"logical_flow\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(2, false);
    verify(preparedStatement).setLong(5, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRestoreFlowResult);
  }

  /**
   * Test {@link LogicalFlowDao#restoreFlow(long, String)} with {@code logicalFlowId}, {@code
   * username}.
   *
   * <p>Method under test: {@link LogicalFlowDao#restoreFlow(long, String)}
   */
  @Test
  @DisplayName("Test restoreFlow(long, String) with 'logicalFlowId', 'username'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LogicalFlowDao.restoreFlow(long, String)"})
  void testRestoreFlowWithLogicalFlowIdUsername3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    boolean actualRestoreFlowResult = new LogicalFlowDao(dsl).restoreFlow(1L, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"logical_flow\" set \"logical_flow\".\"entity_lifecycle_status\" = cast(? as varchar), \"logical_flow\".\"is_removed\" = cast(? as bit(1)), \"logical_flow\".\"last_updated_by\" = cast(? as varchar), \"logical_flow\".\"last_updated_at\" = cast(? as datetime) where \"logical_flow\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(2, false);
    verify(preparedStatement).setLong(5, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRestoreFlowResult);
  }

  /**
   * Test {@link LogicalFlowDao#restoreFlow(long, String)} with {@code logicalFlowId}, {@code
   * username}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#restoreFlow(long, String)}
   */
  @Test
  @DisplayName(
      "Test restoreFlow(long, String) with 'logicalFlowId', 'username'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LogicalFlowDao.restoreFlow(long, String)"})
  void testRestoreFlowWithLogicalFlowIdUsername_thenReturnTrue() throws DataAccessException {
    // Arrange
    UpdateConditionStep<LogicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep4 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    UpdateSetFirstStep<LogicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep4);
    when(dSLContext.update(Mockito.<Table<LogicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualRestoreFlowResult = logicalFlowDao.restoreFlow(1L, "janedoe");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertTrue(actualRestoreFlowResult);
  }

  /**
   * Test {@link LogicalFlowDao#updateReadOnly(long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#updateReadOnly(long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateReadOnly(long, boolean, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long LogicalFlowDao.updateReadOnly(long, boolean, String)"})
  void testUpdateReadOnly_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    long actualUpdateReadOnlyResult = new LogicalFlowDao(dsl).updateReadOnly(1L, true, "User");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"logical_flow\" set \"logical_flow\".\"is_readonly\" = cast(? as bit(1)), \"logical_flow\".\"last_updated_at\" = cast(? as datetime), \"logical_flow\".\"last_updated_by\" = cast(? as varchar) where \"logical_flow\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement).setString(3, "User");
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualUpdateReadOnlyResult);
  }

  /**
   * Test {@link LogicalFlowDao#updateReadOnly(long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#updateReadOnly(long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateReadOnly(long, boolean, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long LogicalFlowDao.updateReadOnly(long, boolean, String)"})
  void testUpdateReadOnly_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    long actualUpdateReadOnlyResult = new LogicalFlowDao(dsl).updateReadOnly(1L, true, "User");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"logical_flow\" set \"logical_flow\".\"is_readonly\" = ?, \"logical_flow\".\"last_updated_at\" = ?, \"logical_flow\".\"last_updated_by\" = ? where \"logical_flow\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement).setLong(4, 1L);
    verify(preparedStatement).setString(3, "User");
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0L, actualUpdateReadOnlyResult);
  }

  /**
   * Test {@link LogicalFlowDao#updateReadOnly(long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#updateReadOnly(long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateReadOnly(long, boolean, String); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long LogicalFlowDao.updateReadOnly(long, boolean, String)"})
  void testUpdateReadOnly_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<LogicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<LogicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);
    when(dSLContext.update(Mockito.<Table<LogicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    long actualUpdateReadOnlyResult = logicalFlowDao.updateReadOnly(1L, true, "User");

    // Assert
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1L, actualUpdateReadOnlyResult);
  }

  /**
   * Test {@link LogicalFlowDao#findAllActive()}.
   *
   * <p>Method under test: {@link LogicalFlowDao#findAllActive()}
   */
  @Test
  @DisplayName("Test findAllActive()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowDao.findAllActive()"})
  void testFindAllActive() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    List<LogicalFlow> actualFindAllActiveResult = logicalFlowDao.findAllActive();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindAllActiveResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDao#findActiveByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#findActiveByFlowIds(Collection)}
   */
  @Test
  @DisplayName("Test findActiveByFlowIds(Collection); given one; when ArrayList() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowDao.findActiveByFlowIds(Collection)"})
  void testFindActiveByFlowIds_givenOne_whenArrayListAddOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    ArrayList<Long> dataFlowIds = new ArrayList<>();
    dataFlowIds.add(1L);
    dataFlowIds.add(2L);

    // Act
    List<LogicalFlow> actualFindActiveByFlowIdsResult =
        logicalFlowDao.findActiveByFlowIds(dataFlowIds);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindActiveByFlowIdsResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDao#findActiveByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#findActiveByFlowIds(Collection)}
   */
  @Test
  @DisplayName("Test findActiveByFlowIds(Collection); given two; when ArrayList() add two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowDao.findActiveByFlowIds(Collection)"})
  void testFindActiveByFlowIds_givenTwo_whenArrayListAddTwo() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    ArrayList<Long> dataFlowIds = new ArrayList<>();
    dataFlowIds.add(2L);

    // Act
    List<LogicalFlow> actualFindActiveByFlowIdsResult =
        logicalFlowDao.findActiveByFlowIds(dataFlowIds);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindActiveByFlowIdsResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDao#findActiveByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#findActiveByFlowIds(Collection)}
   */
  @Test
  @DisplayName("Test findActiveByFlowIds(Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowDao.findActiveByFlowIds(Collection)"})
  void testFindActiveByFlowIds_whenArrayList() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    List<LogicalFlow> actualFindActiveByFlowIdsResult =
        logicalFlowDao.findActiveByFlowIds(new ArrayList<>());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindActiveByFlowIdsResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDao#findAllByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#findAllByFlowIds(Collection)}
   */
  @Test
  @DisplayName("Test findAllByFlowIds(Collection); given one; when ArrayList() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowDao.findAllByFlowIds(Collection)"})
  void testFindAllByFlowIds_givenOne_whenArrayListAddOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    ArrayList<Long> dataFlowIds = new ArrayList<>();
    dataFlowIds.add(1L);
    dataFlowIds.add(2L);

    // Act
    List<LogicalFlow> actualFindAllByFlowIdsResult = logicalFlowDao.findAllByFlowIds(dataFlowIds);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindAllByFlowIdsResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDao#findAllByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#findAllByFlowIds(Collection)}
   */
  @Test
  @DisplayName("Test findAllByFlowIds(Collection); given two; when ArrayList() add two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowDao.findAllByFlowIds(Collection)"})
  void testFindAllByFlowIds_givenTwo_whenArrayListAddTwo() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    ArrayList<Long> dataFlowIds = new ArrayList<>();
    dataFlowIds.add(2L);

    // Act
    List<LogicalFlow> actualFindAllByFlowIdsResult = logicalFlowDao.findAllByFlowIds(dataFlowIds);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindAllByFlowIdsResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDao#findAllByFlowIds(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#findAllByFlowIds(Collection)}
   */
  @Test
  @DisplayName("Test findAllByFlowIds(Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalFlowDao.findAllByFlowIds(Collection)"})
  void testFindAllByFlowIds_whenArrayList() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep3);

    // Act
    List<LogicalFlow> actualFindAllByFlowIdsResult =
        logicalFlowDao.findAllByFlowIds(new ArrayList<>());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindAllByFlowIdsResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDao#cleanupOrphans()}.
   *
   * <p>Method under test: {@link LogicalFlowDao#cleanupOrphans()}
   */
  @Test
  @DisplayName("Test cleanupOrphans()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer LogicalFlowDao.cleanupOrphans()"})
  void testCleanupOrphans() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<Field<Object>>any())).thenReturn(new ArrayList<>());

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    UpdateConditionStep<LogicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<LogicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);
    when(dSLContext.update(Mockito.<Table<LogicalFlowRecord>>any())).thenReturn(updateSetFirstStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    Integer actualCleanupOrphansResult = logicalFlowDao.cleanupOrphans();

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(selectConditionStep).fetch(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualCleanupOrphansResult.intValue());
  }

  /**
   * Test {@link LogicalFlowDao#cleanupSelfReferencingFlows()}.
   *
   * <p>Method under test: {@link LogicalFlowDao#cleanupSelfReferencingFlows()}
   */
  @Test
  @DisplayName("Test cleanupSelfReferencingFlows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LogicalFlowDao.cleanupSelfReferencingFlows()"})
  void testCleanupSelfReferencingFlows() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<Field<Object>>any())).thenReturn(new ArrayList<>());

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    UpdateConditionStep<LogicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<LogicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<LogicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);
    when(dSLContext.update(Mockito.<Table<LogicalFlowRecord>>any())).thenReturn(updateSetFirstStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    int actualCleanupSelfReferencingFlowsResult = logicalFlowDao.cleanupSelfReferencingFlows();

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(selectConditionStep).fetch(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualCleanupSelfReferencingFlowsResult);
  }

  /**
   * Test {@link LogicalFlowDao#calculateAmendedFlowOperations(Set, String)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>When {@link HashSet#HashSet()} add {@code ADD}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#calculateAmendedFlowOperations(Set, String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedFlowOperations(Set, String); given 'ADD'; when HashSet() add 'ADD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LogicalFlowDao.calculateAmendedFlowOperations(Set, String)"})
  void testCalculateAmendedFlowOperations_givenAdd_whenHashSetAddAdd() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    HashSet<Operation> operationsForFlow = new HashSet<>();
    operationsForFlow.add(Operation.ADD);

    // Act
    Set<Operation> actualCalculateAmendedFlowOperationsResult =
        logicalFlowDao.calculateAmendedFlowOperations(operationsForFlow, "janedoe");

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertEquals(3, actualCalculateAmendedFlowOperationsResult.size());
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Test {@link LogicalFlowDao#calculateAmendedFlowOperations(Set, String)}.
   *
   * <ul>
   *   <li>Given {@code ATTEST}.
   *   <li>Then return size is four.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#calculateAmendedFlowOperations(Set, String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedFlowOperations(Set, String); given 'ATTEST'; then return size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LogicalFlowDao.calculateAmendedFlowOperations(Set, String)"})
  void testCalculateAmendedFlowOperations_givenAttest_thenReturnSizeIsFour()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    HashSet<Operation> operationsForFlow = new HashSet<>();
    operationsForFlow.add(Operation.ATTEST);
    operationsForFlow.add(Operation.ADD);

    // Act
    Set<Operation> actualCalculateAmendedFlowOperationsResult =
        logicalFlowDao.calculateAmendedFlowOperations(operationsForFlow, "janedoe");

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertEquals(4, actualCalculateAmendedFlowOperationsResult.size());
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.ATTEST));
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Test {@link LogicalFlowDao#calculateAmendedFlowOperations(Set, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#calculateAmendedFlowOperations(Set, String)}
   */
  @Test
  @DisplayName(
      "Test calculateAmendedFlowOperations(Set, String); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LogicalFlowDao.calculateAmendedFlowOperations(Set, String)"})
  void testCalculateAmendedFlowOperations_thenCallsPrepareStatement() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    LogicalFlowDao logicalFlowDao = new LogicalFlowDao(dsl);

    // Act
    Set<Operation> actualCalculateAmendedFlowOperationsResult =
        logicalFlowDao.calculateAmendedFlowOperations(new HashSet<>(), "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "select 1 \"one\" where exists (select \"user_role\".\"role\" from \"user_role\" where (\"user_role\".\"role\" = ? and \"user_role\".\"user_name\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateAmendedFlowOperationsResult.size());
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.UPDATE));
  }

  /**
   * Test {@link LogicalFlowDao#calculateAmendedFlowOperations(Set, String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#calculateAmendedFlowOperations(Set, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedFlowOperations(Set, String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LogicalFlowDao.calculateAmendedFlowOperations(Set, String)"})
  void testCalculateAmendedFlowOperations_thenReturnEmpty() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(false);

    // Act
    Set<Operation> actualCalculateAmendedFlowOperationsResult =
        logicalFlowDao.calculateAmendedFlowOperations(new HashSet<>(), "janedoe");

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertTrue(actualCalculateAmendedFlowOperationsResult.isEmpty());
  }

  /**
   * Test {@link LogicalFlowDao#calculateAmendedFlowOperations(Set, String)}.
   *
   * <ul>
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link LogicalFlowDao#calculateAmendedFlowOperations(Set, String)}
   */
  @Test
  @DisplayName("Test calculateAmendedFlowOperations(Set, String); then return size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LogicalFlowDao.calculateAmendedFlowOperations(Set, String)"})
  void testCalculateAmendedFlowOperations_thenReturnSizeIsThree() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchExists(Mockito.<Select<?>>any())).thenReturn(true);

    // Act
    Set<Operation> actualCalculateAmendedFlowOperationsResult =
        logicalFlowDao.calculateAmendedFlowOperations(new HashSet<>(), "janedoe");

    // Assert
    verify(dSLContext).fetchExists(isA(Select.class));
    assertEquals(3, actualCalculateAmendedFlowOperationsResult.size());
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.ADD));
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.REMOVE));
    assertTrue(actualCalculateAmendedFlowOperationsResult.contains(Operation.UPDATE));
  }
}
