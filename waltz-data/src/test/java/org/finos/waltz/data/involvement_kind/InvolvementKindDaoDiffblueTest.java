package org.finos.waltz.data.involvement_kind;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.involvement_kind.InvolvementKind;
import org.finos.waltz.model.involvement_kind.InvolvementKindChangeCommand;
import org.finos.waltz.model.involvement_kind.InvolvementKindCreateCommand;
import org.finos.waltz.schema.tables.records.InvolvementKindRecord;
import org.jooq.CommonTableExpression;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinPartitionByStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.WithStep;
import org.jooq.exception.DataAccessException;
import org.jooq.exception.NoDataFoundException;
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
class InvolvementKindDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private InvolvementKindDao involvementKindDao;

  /**
   * Test {@link InvolvementKindDao#findAll()}.
   *
   * <p>Method under test: {@link InvolvementKindDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementKindDao.findAll()"})
  void testFindAll() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.findAll());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#findAll()}.
   *
   * <p>Method under test: {@link InvolvementKindDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementKindDao.findAll()"})
  void testFindAll2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.findAll());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link InvolvementKindDao#findAll()}.
   *
   * <p>Method under test: {@link InvolvementKindDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementKindDao.findAll()"})
  void testFindAll3() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.findAll());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link InvolvementKindDao#findAll()}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#fetch(RecordMapper)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given SelectJoinStep fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementKindDao.findAll()"})
  void testFindAll_givenSelectJoinStepFetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<InvolvementKind> actualFindAllResult = involvementKindDao.findAll();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link InvolvementKindDao#getById(long)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getById(long)"})
  void testGetById() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#getById(long)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getById(long)"})
  void testGetById2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link InvolvementKindDao#getById(long)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getById(long)"})
  void testGetById3() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementKindDao#getById(long)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectConditionStep#fetchOne(RecordMapper)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then calls fetchOne(RecordMapper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getById(long)"})
  void testGetById_thenCallsFetchOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(InvolvementKindCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long InvolvementKindDao.create(InvolvementKindCreateCommand, String)"})
  void testCreate() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<InvolvementKindRecord>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    // Act and Assert
    assertThrows(
        NoDataFoundException.class,
        () -> involvementKindDao.create(mock(InvolvementKindCreateCommand.class), "janedoe"));
    verify(dSLContext).newRecord(isA(Table.class));
  }

  /**
   * Test {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(InvolvementKindCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long InvolvementKindDao.create(InvolvementKindCreateCommand, String)"})
  void testCreate2() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<InvolvementKindRecord>>any()))
        .thenReturn(new InvolvementKindRecord());

    InvolvementKindCreateCommand command = mock(InvolvementKindCreateCommand.class);
    when(command.description()).thenThrow(new NoDataFoundException("An error occurred"));
    when(command.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.create(command, "janedoe"));
    verify(command).description();
    verify(command).name();
    verify(dSLContext).newRecord(isA(Table.class));
  }

  /**
   * Test {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   *   <li>Then calls {@link InvolvementKindCreateCommand#permittedRole()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(InvolvementKindCreateCommand, String); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'; then calls permittedRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long InvolvementKindDao.create(InvolvementKindCreateCommand, String)"})
  void testCreate_givenDefaultDSLContextWithDialectIsSql99_thenCallsPermittedRole() {
    // Arrange
    InvolvementKindDao involvementKindDao =
        new InvolvementKindDao(new DefaultDSLContext(SQLDialect.SQL99));

    InvolvementKindCreateCommand command = mock(InvolvementKindCreateCommand.class);
    when(command.permittedRole()).thenThrow(new NoDataFoundException("An error occurred"));
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    when(command.subjectKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.create(command, "janedoe"));
    verify(command).description();
    verify(command).name();
    verify(command).permittedRole();
    verify(command).subjectKind();
  }

  /**
   * Test {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementKindCreateCommand#permittedRole()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(InvolvementKindCreateCommand, String); then calls permittedRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long InvolvementKindDao.create(InvolvementKindCreateCommand, String)"})
  void testCreate_thenCallsPermittedRole() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<InvolvementKindRecord>>any()))
        .thenReturn(new InvolvementKindRecord());

    InvolvementKindCreateCommand command = mock(InvolvementKindCreateCommand.class);
    when(command.permittedRole()).thenThrow(new NoDataFoundException("An error occurred"));
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.subjectKind()).thenReturn(EntityKind.ALL);
    when(command.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.create(command, "janedoe"));
    verify(command).description();
    verify(command).name();
    verify(command).permittedRole();
    verify(command).subjectKind();
    verify(dSLContext).newRecord(isA(Table.class));
  }

  /**
   * Test {@link InvolvementKindDao#update(InvolvementKindChangeCommand)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#update(InvolvementKindChangeCommand)}
   */
  @Test
  @DisplayName("Test update(InvolvementKindChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindDao.update(InvolvementKindChangeCommand)"})
  void testUpdate() {
    // Arrange
    InvolvementKindChangeCommand command = mock(InvolvementKindChangeCommand.class);
    when(command.lastUpdate()).thenThrow(new NoDataFoundException("An error occurred"));

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.update(command));
    verify(command).lastUpdate();
  }

  /**
   * Test {@link InvolvementKindDao#update(InvolvementKindChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementKindChangeCommand#id()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#update(InvolvementKindChangeCommand)}
   */
  @Test
  @DisplayName("Test update(InvolvementKindChangeCommand); then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindDao.update(InvolvementKindChangeCommand)"})
  void testUpdate_thenCallsId() {
    // Arrange
    InvolvementKindChangeCommand command = mock(InvolvementKindChangeCommand.class);
    when(command.id()).thenThrow(new NoDataFoundException("An error occurred"));
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<UserTimestamp> ofResult = Optional.of(immutableUserTimestamp);
    when(command.lastUpdate()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.update(command));
    verify(command).id();
    verify(command).lastUpdate();
  }

  /**
   * Test {@link InvolvementKindDao#deleteIfNotUsed(long)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName("Test deleteIfNotUsed(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed() {
    // Arrange
    when(dSLContext.deleteFrom(Mockito.<Table<InvolvementKindRecord>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.deleteIfNotUsed(1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
  }

  /**
   * Test {@link InvolvementKindDao#deleteIfNotUsed(long)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName("Test deleteIfNotUsed(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed2() {
    // Arrange
    DeleteUsingStep<InvolvementKindRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));
    when(dSLContext.deleteFrom(Mockito.<Table<InvolvementKindRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.deleteIfNotUsed(1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementKindDao#deleteIfNotUsed(long)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName("Test deleteIfNotUsed(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed3() {
    // Arrange
    DeleteConditionStep<InvolvementKindRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    DeleteUsingStep<InvolvementKindRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<InvolvementKindRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.deleteIfNotUsed(1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementKindDao#deleteIfNotUsed(long)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName("Test deleteIfNotUsed(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed4() throws DataAccessException {
    // Arrange
    DeleteConditionStep<InvolvementKindRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenThrow(new NoDataFoundException("An error occurred"));

    DeleteConditionStep<InvolvementKindRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<InvolvementKindRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<InvolvementKindRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.deleteIfNotUsed(1L));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
  }

  /**
   * Test {@link InvolvementKindDao#deleteIfNotUsed(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName(
      "Test deleteIfNotUsed(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    boolean actualDeleteIfNotUsedResult = new InvolvementKindDao(dsl).deleteIfNotUsed(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"involvement_kind\" where (\"involvement_kind\".\"id\" = cast(? as bigint) and not exists (select \"involvement\".\"entity_kind\", \"involvement\".\"entity_id\", \"involvement\".\"employee_id\", \"involvement\".\"provenance\", \"involvement\".\"kind_id\", \"involvement\".\"is_readonly\" from \"involvement\" where \"involvement\".\"kind_id\" = cast(? as bigint)))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteIfNotUsedResult);
  }

  /**
   * Test {@link InvolvementKindDao#deleteIfNotUsed(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName(
      "Test deleteIfNotUsed(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualDeleteIfNotUsedResult = new InvolvementKindDao(dsl).deleteIfNotUsed(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"involvement_kind\" where (\"involvement_kind\".\"id\" = ? and not exists (select \"involvement\".\"entity_kind\", \"involvement\".\"entity_id\", \"involvement\".\"employee_id\", \"involvement\".\"provenance\", \"involvement\".\"kind_id\", \"involvement\".\"is_readonly\" from \"involvement\" where \"involvement\".\"kind_id\" = ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualDeleteIfNotUsedResult);
  }

  /**
   * Test {@link InvolvementKindDao#deleteIfNotUsed(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName(
      "Test deleteIfNotUsed(long); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<InvolvementKindRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<InvolvementKindRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<InvolvementKindRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<InvolvementKindRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteIfNotUsedResult = involvementKindDao.deleteIfNotUsed(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualDeleteIfNotUsedResult);
  }

  /**
   * Test {@link InvolvementKindDao#deleteIfNotUsed(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName(
      "Test deleteIfNotUsed(long); given DeleteConditionStep execute() return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed_givenDeleteConditionStepExecuteReturnZero_thenReturnFalse()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<InvolvementKindRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteConditionStep<InvolvementKindRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<InvolvementKindRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<InvolvementKindRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteIfNotUsedResult = involvementKindDao.deleteIfNotUsed(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualDeleteIfNotUsedResult);
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStats()}.
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStats()}
   */
  @Test
  @DisplayName("Test loadUsageStats()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set InvolvementKindDao.loadUsageStats()"})
  void testLoadUsageStats() {
    // Arrange
    when(dSLContext.with((CommonTableExpression[]) Mockito.any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.loadUsageStats());
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStats()}.
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStats()}
   */
  @Test
  @DisplayName("Test loadUsageStats()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set InvolvementKindDao.loadUsageStats()"})
  void testLoadUsageStats2() {
    // Arrange
    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NoDataFoundException("An error occurred"));
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.loadUsageStats());
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStats()}.
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStats()}
   */
  @Test
  @DisplayName("Test loadUsageStats()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set InvolvementKindDao.loadUsageStats()"})
  void testLoadUsageStats3() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.loadUsageStats());
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStats()}.
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStats()}
   */
  @Test
  @DisplayName("Test loadUsageStats()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set InvolvementKindDao.loadUsageStats()"})
  void testLoadUsageStats4() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.loadUsageStats());
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStats()}.
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStats()}
   */
  @Test
  @DisplayName("Test loadUsageStats()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set InvolvementKindDao.loadUsageStats()"})
  void testLoadUsageStats5() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.loadUsageStats());
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStats()}.
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStats()}
   */
  @Test
  @DisplayName("Test loadUsageStats()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set InvolvementKindDao.loadUsageStats()"})
  void testLoadUsageStats6() {
    // Arrange
    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.loadUsageStats());
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStats()}.
   *
   * <ul>
   *   <li>Then calls {@link SelectOnConditionStep#fetch()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStats()}
   */
  @Test
  @DisplayName("Test loadUsageStats(); then calls fetch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set InvolvementKindDao.loadUsageStats()"})
  void testLoadUsageStats_thenCallsFetch() throws DataAccessException {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.fetch()).thenThrow(new NoDataFoundException("An error occurred"));

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);
    when(dSLContext.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.loadUsageStats());
    verify(dSLContext).with((CommonTableExpression[]) Mockito.any());
    verify(selectOnConditionStep).fetch();
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStatsForKind(Long)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStatsForKind(Long)}
   */
  @Test
  @DisplayName("Test loadUsageStatsForKind(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKindUsageStat InvolvementKindDao.loadUsageStatsForKind(Long)"})
  void testLoadUsageStatsForKind() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.loadUsageStatsForKind(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStatsForKind(Long)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStatsForKind(Long)}
   */
  @Test
  @DisplayName("Test loadUsageStatsForKind(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKindUsageStat InvolvementKindDao.loadUsageStatsForKind(Long)"})
  void testLoadUsageStatsForKind2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.loadUsageStatsForKind(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStatsForKind(Long)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStatsForKind(Long)}
   */
  @Test
  @DisplayName("Test loadUsageStatsForKind(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKindUsageStat InvolvementKindDao.loadUsageStatsForKind(Long)"})
  void testLoadUsageStatsForKind3() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.loadUsageStatsForKind(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStatsForKind(Long)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectConditionStep#fetchOne(RecordMapper)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStatsForKind(Long)}
   */
  @Test
  @DisplayName("Test loadUsageStatsForKind(Long); then calls fetchOne(RecordMapper)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKindUsageStat InvolvementKindDao.loadUsageStatsForKind(Long)"})
  void testLoadUsageStatsForKind_thenCallsFetchOne() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.loadUsageStatsForKind(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementKindDao#getByExternalId(String)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#getByExternalId(String)}
   */
  @Test
  @DisplayName("Test getByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getByExternalId(String)"})
  void testGetByExternalId() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.getByExternalId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#getByExternalId(String)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#getByExternalId(String)}
   */
  @Test
  @DisplayName("Test getByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getByExternalId(String)"})
  void testGetByExternalId2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.getByExternalId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link InvolvementKindDao#getByExternalId(String)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#getByExternalId(String)}
   */
  @Test
  @DisplayName("Test getByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getByExternalId(String)"})
  void testGetByExternalId3() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.getByExternalId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementKindDao#getByExternalId(String)}.
   *
   * <p>Method under test: {@link InvolvementKindDao#getByExternalId(String)}
   */
  @Test
  @DisplayName("Test getByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getByExternalId(String)"})
  void testGetByExternalId4() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOneInto(Mockito.<Class<InvolvementKindRecord>>any()))
        .thenThrow(new NoDataFoundException("An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.getByExternalId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementKindDao#getByExternalId(String)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOneInto(Class)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#getByExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test getByExternalId(String); given SelectConditionStep fetchOneInto(Class) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getByExternalId(String)"})
  void testGetByExternalId_givenSelectConditionStepFetchOneIntoReturnNull()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOneInto(Mockito.<Class<InvolvementKindRecord>>any()))
        .thenReturn(null);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.getByExternalId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementKindDao#getByExternalId(String)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOneInto(Class)} return
   *       {@code null}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#getByExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test getByExternalId(String); given SelectConditionStep fetchOneInto(Class) return 'null'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getByExternalId(String)"})
  void testGetByExternalId_givenSelectConditionStepFetchOneIntoReturnNull_whenNull()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOneInto(Mockito.<Class<InvolvementKindRecord>>any()))
        .thenReturn(null);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.getByExternalId(null));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }
}
