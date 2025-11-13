package org.finos.waltz.data.involvement_kind;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKind;
import org.finos.waltz.model.involvement_kind.InvolvementKind;
import org.finos.waltz.model.involvement_kind.InvolvementKindChangeCommand;
import org.finos.waltz.model.involvement_kind.InvolvementKindCreateCommand;
import org.finos.waltz.schema.tables.records.InvolvementKindRecord;
import org.jooq.CommonTableExpression;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.GroupField;
import org.jooq.Record;
import org.jooq.Record4;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinPartitionByStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
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
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   *   <li>Then calls {@link DSLContext#select(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given DSLContext select(SelectFieldOrAsterisk[]) throw NoDataFoundException(); then calls select(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementKindDao.findAll()"})
  void testFindAll_givenDSLContextSelectThrowNoDataFoundException_thenCallsSelect() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NoDataFoundException());

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.findAll());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
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

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<InvolvementKind> actualFindAllResult = new InvolvementKindDao(dsl).findAll();

    // Assert
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link InvolvementKindDao#findAll()}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#fetch(RecordMapper)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   *   <li>Then calls {@link DSLContext#select(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given SelectJoinStep fetch(RecordMapper) throw NoDataFoundException(); then calls select(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementKindDao.findAll()"})
  void testFindAll_givenSelectJoinStepFetchThrowNoDataFoundException_thenCallsSelect()
      throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new NoDataFoundException());

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
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   *   <li>Then calls {@link DefaultDSLContext#select(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given SelectSelectStep from(TableLike) throw NoDataFoundException(); then calls select(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementKindDao.findAll()"})
  void testFindAll_givenSelectSelectStepFromThrowNoDataFoundException_thenCallsSelect() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenThrow(new NoDataFoundException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new InvolvementKindDao(dsl).findAll());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   *   <li>Then calls {@link DSLContext#select(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given DSLContext select(SelectFieldOrAsterisk[]) throw NoDataFoundException(); then calls select(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getById(long)"})
  void testGetById_givenDSLContextSelectThrowNoDataFoundException_thenCallsSelect() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NoDataFoundException());

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOne(RecordMapper)}
   *       throw {@link NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given SelectConditionStep fetchOne(RecordMapper) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getById(long)"})
  void testGetById_givenSelectConditionStepFetchOneThrowNoDataFoundException()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new NoDataFoundException());

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
   * Test {@link InvolvementKindDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   *   <li>Then calls {@link SelectJoinStep#where(Condition)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given SelectJoinStep where(Condition) throw NoDataFoundException(); then calls where(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getById(long)"})
  void testGetById_givenSelectJoinStepWhereThrowNoDataFoundException_thenCallsWhere() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new NoDataFoundException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new InvolvementKindDao(dsl).getById(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#getById(long)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   *   <li>Then calls {@link DefaultDSLContext#select(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#getById(long)}
   */
  @Test
  @DisplayName(
      "Test getById(long); given SelectSelectStep from(TableLike) throw NoDataFoundException(); then calls select(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getById(long)"})
  void testGetById_givenSelectSelectStepFromThrowNoDataFoundException_thenCallsSelect() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenThrow(new NoDataFoundException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new InvolvementKindDao(dsl).getById(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#getById(long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableInvolvementKind}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then return ImmutableInvolvementKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getById(long)"})
  void testGetById_thenReturnImmutableInvolvementKind() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    InvolvementKind actualById = new InvolvementKindDao(dsl).getById(1L);

    // Assert
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualById instanceof ImmutableInvolvementKind);
    LocalDateTime lastUpdatedAtResult = actualById.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Name", actualById.name());
    assertEquals("Permitted Role", actualById.permittedRole());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityKind.ALL, actualById.subjectKind());
    assertTrue(actualById.transitive());
    assertTrue(actualById.userSelectable());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#newRecord(Table)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(InvolvementKindCreateCommand, String); given DSLContext newRecord(Table) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long InvolvementKindDao.create(InvolvementKindCreateCommand, String)"})
  void testCreate_givenDSLContextNewRecordThrowNoDataFoundException() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<InvolvementKindRecord>>any()))
        .thenThrow(new NoDataFoundException());

    // Act and Assert
    assertThrows(
        NoDataFoundException.class,
        () -> involvementKindDao.create(mock(InvolvementKindCreateCommand.class), "janedoe"));
    verify(dSLContext).newRecord(isA(Table.class));
  }

  /**
   * Test {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(InvolvementKindCreateCommand, String); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long InvolvementKindDao.create(InvolvementKindCreateCommand, String)"})
  void testCreate_givenDefaultDSLContextWithDialectIsSql99() {
    // Arrange
    InvolvementKindDao involvementKindDao =
        new InvolvementKindDao(new DefaultDSLContext(SQLDialect.SQL99));

    InvolvementKindCreateCommand command = mock(InvolvementKindCreateCommand.class);
    when(command.permittedRole()).thenThrow(new NoDataFoundException());
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
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getGeneratedKeys()} return
   *       {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(InvolvementKindCreateCommand, String); given PreparedStatement getGeneratedKeys() return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long InvolvementKindDao.create(InvolvementKindCreateCommand, String)"})
  void testCreate_givenPreparedStatementGetGeneratedKeysReturnNull_thenReturnNull()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getGeneratedKeys()).thenReturn(null);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), anyInt()))
        .thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.DERBY);
    InvolvementKindDao involvementKindDao = new InvolvementKindDao(dsl);

    InvolvementKindCreateCommand command = mock(InvolvementKindCreateCommand.class);
    when(command.permittedRole()).thenReturn("Permitted Role");
    Optional<String> ofResult = Optional.of("42");
    when(command.externalId()).thenReturn(ofResult);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    when(command.subjectKind()).thenReturn(EntityKind.ALL);

    // Act
    Long actualCreateResult = involvementKindDao.create(command, "janedoe");

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"involvement_kind\" (\"description\", \"last_updated_at\", \"last_updated_by\", \"external_id\", \"subject_kind\", \"name\", \"permitted_role\") values (cast(? as varchar(32672)), cast(? as timestamp), cast(? as varchar(32672)), cast(? as varchar(32672)), cast(? as varchar(32672)), cast(? as varchar(32672)), cast(? as varchar(32672)))",
            1);
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getGeneratedKeys();
    verify(preparedStatement).getWarnings();
    verify(command).description();
    verify(command).externalId();
    verify(command).name();
    verify(command).permittedRole();
    verify(command).subjectKind();
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}.
   *
   * <ul>
   *   <li>Then return longValue is minus one.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(InvolvementKindCreateCommand, String); then return longValue is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long InvolvementKindDao.create(InvolvementKindCreateCommand, String)"})
  void testCreate_thenReturnLongValueIsMinusOne() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    InvolvementKindDao involvementKindDao = new InvolvementKindDao(dsl);

    InvolvementKindCreateCommand command = mock(InvolvementKindCreateCommand.class);
    when(command.permittedRole()).thenReturn("Permitted Role");
    Optional<String> ofResult = Optional.of("42");
    when(command.externalId()).thenReturn(ofResult);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.name()).thenReturn("Name");
    when(command.subjectKind()).thenReturn(EntityKind.ALL);

    // Act
    Long actualCreateResult = involvementKindDao.create(command, "janedoe");

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(command).description();
    verify(command).externalId();
    verify(command).name();
    verify(command).permittedRole();
    verify(command).subjectKind();
    assertEquals(-1L, actualCreateResult.longValue());
  }

  /**
   * Test {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}.
   *
   * <ul>
   *   <li>When {@link InvolvementKindCreateCommand} {@link
   *       InvolvementKindCreateCommand#description()} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(InvolvementKindCreateCommand, String); when InvolvementKindCreateCommand description() throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long InvolvementKindDao.create(InvolvementKindCreateCommand, String)"})
  void testCreate_whenInvolvementKindCreateCommandDescriptionThrowNoDataFoundException() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<InvolvementKindRecord>>any()))
        .thenReturn(new InvolvementKindRecord());

    InvolvementKindCreateCommand command = mock(InvolvementKindCreateCommand.class);
    when(command.description()).thenThrow(new NoDataFoundException());
    when(command.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.create(command, "janedoe"));
    verify(command).description();
    verify(command).name();
    verify(dSLContext).newRecord(isA(Table.class));
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
    InvolvementKindDao involvementKindDao =
        new InvolvementKindDao(new DefaultDSLContext(SQLDialect.SQL99));

    InvolvementKindChangeCommand command = mock(InvolvementKindChangeCommand.class);
    when(command.id()).thenThrow(new NoDataFoundException());
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
   * Test {@link InvolvementKindDao#update(InvolvementKindChangeCommand)}.
   *
   * <ul>
   *   <li>When {@link InvolvementKindChangeCommand} {@link
   *       InvolvementKindChangeCommand#lastUpdate()} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#update(InvolvementKindChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(InvolvementKindChangeCommand); when InvolvementKindChangeCommand lastUpdate() throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindDao.update(InvolvementKindChangeCommand)"})
  void testUpdate_whenInvolvementKindChangeCommandLastUpdateThrowNoDataFoundException() {
    // Arrange
    InvolvementKindDao involvementKindDao =
        new InvolvementKindDao(new DefaultDSLContext(SQLDialect.SQL99));

    InvolvementKindChangeCommand command = mock(InvolvementKindChangeCommand.class);
    when(command.lastUpdate()).thenThrow(new NoDataFoundException());

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.update(command));
    verify(command).lastUpdate();
  }

  /**
   * Test {@link InvolvementKindDao#deleteIfNotUsed(long)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#deleteFrom(Table)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName(
      "Test deleteIfNotUsed(long); given DSLContext deleteFrom(Table) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed_givenDSLContextDeleteFromThrowNoDataFoundException() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<InvolvementKindRecord>>any()))
        .thenThrow(new NoDataFoundException());

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new InvolvementKindDao(dsl).deleteIfNotUsed(1L));
    verify(dsl).deleteFrom(isA(Table.class));
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
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#and(Condition)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName(
      "Test deleteIfNotUsed(long); given DeleteConditionStep and(Condition) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed_givenDeleteConditionStepAndThrowNoDataFoundException() {
    // Arrange
    DeleteConditionStep<InvolvementKindRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any())).thenThrow(new NoDataFoundException());

    DeleteUsingStep<InvolvementKindRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<InvolvementKindRecord>>any())).thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new InvolvementKindDao(dsl).deleteIfNotUsed(1L));
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<InvolvementKindRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualDeleteIfNotUsedResult = new InvolvementKindDao(dsl).deleteIfNotUsed(1L);

    // Assert
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualDeleteIfNotUsedResult);
  }

  /**
   * Test {@link InvolvementKindDao#deleteIfNotUsed(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName(
      "Test deleteIfNotUsed(long); given DeleteConditionStep execute() throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed_givenDeleteConditionStepExecuteThrowNoDataFoundException()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<InvolvementKindRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenThrow(new NoDataFoundException());

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
   *   <li>Given {@link DeleteUsingStep} {@link DeleteUsingStep#where(Condition)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#deleteIfNotUsed(long)}
   */
  @Test
  @DisplayName(
      "Test deleteIfNotUsed(long); given DeleteUsingStep where(Condition) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InvolvementKindDao.deleteIfNotUsed(long)"})
  void testDeleteIfNotUsed_givenDeleteUsingStepWhereThrowNoDataFoundException() {
    // Arrange
    DeleteUsingStep<InvolvementKindRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenThrow(new NoDataFoundException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<InvolvementKindRecord>>any())).thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new InvolvementKindDao(dsl).deleteIfNotUsed(1L));
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStats()}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#with(CommonTableExpression[])}
   *       throw {@link NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStats()}
   */
  @Test
  @DisplayName(
      "Test loadUsageStats(); given DefaultDSLContext with(CommonTableExpression[]) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set InvolvementKindDao.loadUsageStats()"})
  void testLoadUsageStats_givenDefaultDSLContextWithThrowNoDataFoundException() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.with((CommonTableExpression[]) Mockito.any())).thenThrow(new NoDataFoundException());

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new InvolvementKindDao(dsl).loadUsageStats());
    verify(dsl).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStats()}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinPartitionByStep} {@link SelectJoinPartitionByStep#on(Condition)}
   *       throw {@link NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStats()}
   */
  @Test
  @DisplayName(
      "Test loadUsageStats(); given SelectJoinPartitionByStep on(Condition) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set InvolvementKindDao.loadUsageStats()"})
  void testLoadUsageStats_givenSelectJoinPartitionByStepOnThrowNoDataFoundException() {
    // Arrange
    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new NoDataFoundException());

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

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new InvolvementKindDao(dsl).loadUsageStats());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStats()}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#leftJoin(TableLike)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStats()}
   */
  @Test
  @DisplayName(
      "Test loadUsageStats(); given SelectJoinStep leftJoin(TableLike) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set InvolvementKindDao.loadUsageStats()"})
  void testLoadUsageStats_givenSelectJoinStepLeftJoinThrowNoDataFoundException() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new NoDataFoundException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new InvolvementKindDao(dsl).loadUsageStats());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStats()}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStats()}
   */
  @Test
  @DisplayName(
      "Test loadUsageStats(); given SelectSelectStep from(TableLike) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set InvolvementKindDao.loadUsageStats()"})
  void testLoadUsageStats_givenSelectSelectStepFromThrowNoDataFoundException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenThrow(new NoDataFoundException());

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new InvolvementKindDao(dsl).loadUsageStats());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStats()}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#select(SelectFieldOrAsterisk[])}
   *       throw {@link NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStats()}
   */
  @Test
  @DisplayName(
      "Test loadUsageStats(); given SelectSelectStep select(SelectFieldOrAsterisk[]) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set InvolvementKindDao.loadUsageStats()"})
  void testLoadUsageStats_givenSelectSelectStepSelectThrowNoDataFoundException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NoDataFoundException());

    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new InvolvementKindDao(dsl).loadUsageStats());
    verify(selectSelectStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStats()}.
   *
   * <ul>
   *   <li>Given {@link WithStep} {@link WithStep#select(SelectFieldOrAsterisk[])} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   *   <li>Then calls {@link WithStep#select(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStats()}
   */
  @Test
  @DisplayName(
      "Test loadUsageStats(); given WithStep select(SelectFieldOrAsterisk[]) throw NoDataFoundException(); then calls select(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set InvolvementKindDao.loadUsageStats()"})
  void testLoadUsageStats_givenWithStepSelectThrowNoDataFoundException_thenCallsSelect() {
    // Arrange
    WithStep withStep = mock(WithStep.class);
    when(withStep.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NoDataFoundException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.with((CommonTableExpression[]) Mockito.any())).thenReturn(withStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> new InvolvementKindDao(dsl).loadUsageStats());
    verify(withStep).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl).with((CommonTableExpression[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStats()}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#with(CommonTableExpression[])}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStats()}
   */
  @Test
  @DisplayName("Test loadUsageStats(); then calls with(CommonTableExpression[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set InvolvementKindDao.loadUsageStats()"})
  void testLoadUsageStats_thenCallsWith() throws DataAccessException {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.fetch()).thenThrow(new NoDataFoundException());

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
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#select(SelectFieldOrAsterisk[])}
   *       throw {@link NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStatsForKind(Long)}
   */
  @Test
  @DisplayName(
      "Test loadUsageStatsForKind(Long); given DefaultDSLContext select(SelectFieldOrAsterisk[]) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKindUsageStat InvolvementKindDao.loadUsageStatsForKind(Long)"})
  void testLoadUsageStatsForKind_givenDefaultDSLContextSelectThrowNoDataFoundException() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenThrow(new NoDataFoundException());

    // Act and Assert
    assertThrows(
        NoDataFoundException.class, () -> new InvolvementKindDao(dsl).loadUsageStatsForKind(1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStatsForKind(Long)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStatsForKind(Long)}
   */
  @Test
  @DisplayName(
      "Test loadUsageStatsForKind(Long); given SelectJoinStep where(Condition) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKindUsageStat InvolvementKindDao.loadUsageStatsForKind(Long)"})
  void testLoadUsageStatsForKind_givenSelectJoinStepWhereThrowNoDataFoundException() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new NoDataFoundException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NoDataFoundException.class, () -> new InvolvementKindDao(dsl).loadUsageStatsForKind(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStatsForKind(Long)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStatsForKind(Long)}
   */
  @Test
  @DisplayName(
      "Test loadUsageStatsForKind(Long); given SelectSelectStep from(TableLike) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKindUsageStat InvolvementKindDao.loadUsageStatsForKind(Long)"})
  void testLoadUsageStatsForKind_givenSelectSelectStepFromThrowNoDataFoundException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenThrow(new NoDataFoundException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NoDataFoundException.class, () -> new InvolvementKindDao(dsl).loadUsageStatsForKind(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStatsForKind(Long)}.
   *
   * <ul>
   *   <li>Then calls {@link SelectHavingStep#fetch()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStatsForKind(Long)}
   */
  @Test
  @DisplayName("Test loadUsageStatsForKind(Long); then calls fetch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKindUsageStat InvolvementKindDao.loadUsageStatsForKind(Long)"})
  void testLoadUsageStatsForKind_thenCallsFetch() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectHavingStep<Record4<Object, Object, Object, Object>> selectHavingStep =
        mock(SelectHavingStep.class);
    when(selectHavingStep.fetch()).thenThrow(new NoDataFoundException());

    SelectConditionStep<Record4<Object, Object, Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record4<Object, Object, Object, Object>> selectJoinStep2 =
        mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep2 =
        mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep2);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NoDataFoundException.class, () -> new InvolvementKindDao(dsl).loadUsageStatsForKind(1L));
    verify(selectHavingStep).fetch();
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep2).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dsl)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
  }

  /**
   * Test {@link InvolvementKindDao#loadUsageStatsForKind(Long)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#select(SelectFieldOrAsterisk[])}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#loadUsageStatsForKind(Long)}
   */
  @Test
  @DisplayName("Test loadUsageStatsForKind(Long); then calls select(SelectFieldOrAsterisk[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKindUsageStat InvolvementKindDao.loadUsageStatsForKind(Long)"})
  void testLoadUsageStatsForKind_thenCallsSelect() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new NoDataFoundException());

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
  void testGetByExternalId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOneInto(Mockito.<Class<InvolvementKindRecord>>any()))
        .thenThrow(new NoDataFoundException());

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
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#getByExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test getByExternalId(String); given DSLContext select(SelectFieldOrAsterisk[]) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getByExternalId(String)"})
  void testGetByExternalId_givenDSLContextSelectThrowNoDataFoundException() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new NoDataFoundException());

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> involvementKindDao.getByExternalId("42"));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
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

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NoDataFoundException.class, () -> new InvolvementKindDao(dsl).getByExternalId("42"));
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
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

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NoDataFoundException.class, () -> new InvolvementKindDao(dsl).getByExternalId(null));
    verify(selectConditionStep).fetchOneInto(isA(Class.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#getByExternalId(String)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#getByExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test getByExternalId(String); given SelectJoinStep where(Condition) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getByExternalId(String)"})
  void testGetByExternalId_givenSelectJoinStepWhereThrowNoDataFoundException() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new NoDataFoundException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NoDataFoundException.class, () -> new InvolvementKindDao(dsl).getByExternalId("42"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link InvolvementKindDao#getByExternalId(String)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       NoDataFoundException#NoDataFoundException()}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementKindDao#getByExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test getByExternalId(String); given SelectSelectStep from(TableLike) throw NoDataFoundException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvolvementKind InvolvementKindDao.getByExternalId(String)"})
  void testGetByExternalId_givenSelectSelectStepFromThrowNoDataFoundException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenThrow(new NoDataFoundException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        NoDataFoundException.class, () -> new InvolvementKindDao(dsl).getByExternalId("42"));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }
}
