package org.finos.waltz.data.app_group;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.app_group.AppGroupEntry;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.schema.tables.records.ApplicationGroupEntryRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertReturningStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectOrderByStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.TransactionalRunnable;
import org.jooq.exception.DataAccessException;
import org.jooq.exception.MappingException;
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
class AppGroupEntryDaoDiffblueTest {
  @InjectMocks private AppGroupEntryDao appGroupEntryDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link AppGroupEntryDao#findEntriesForGroup(long)}.
   *
   * <p>Method under test: {@link AppGroupEntryDao#findEntriesForGroup(long)}
   */
  @Test
  @DisplayName("Test findEntriesForGroup(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AppGroupEntryDao.findEntriesForGroup(long)"})
  void testFindEntriesForGroup() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep2);

    // Act
    List<AppGroupEntry> actualFindEntriesForGroupResult = appGroupEntryDao.findEntriesForGroup(1L);

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindEntriesForGroupResult.isEmpty());
  }

  /**
   * Test {@link AppGroupEntryDao#addApplication(long, long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#addApplication(long, long)}
   */
  @Test
  @DisplayName(
      "Test addApplication(long, long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.addApplication(long, long)"})
  void testAddApplication_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    int actualAddApplicationResult = new AppGroupEntryDao(dsl).addApplication(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"application_group_entry\" (\"group_id\", \"application_id\") values (cast(? as bigint), cast(? as bigint)) on duplicate key update \"application_group_entry\".\"group_id\" = \"application_group_entry\".\"group_id\"");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualAddApplicationResult);
  }

  /**
   * Test {@link AppGroupEntryDao#addApplication(long, long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code DERBY}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#addApplication(long, long)}
   */
  @Test
  @DisplayName(
      "Test addApplication(long, long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'DERBY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.addApplication(long, long)"})
  void testAddApplication_givenDefaultDSLContextWithConnectionAndDialectIsDerby()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.DERBY);

    // Act
    int actualAddApplicationResult = new AppGroupEntryDao(dsl).addApplication(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "merge into \"application_group_entry\" using SYSIBM.SYSDUMMY1 on (\"application_group_entry\".\"group_id\" = cast(? as bigint) and \"application_group_entry\".\"application_id\" = cast(? as bigint)) when not matched then insert (\"group_id\", \"application_id\") values (cast(? as bigint), cast(? as bigint))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualAddApplicationResult);
  }

  /**
   * Test {@link AppGroupEntryDao#addApplication(long, long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#addApplication(long, long)}
   */
  @Test
  @DisplayName(
      "Test addApplication(long, long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.addApplication(long, long)"})
  void testAddApplication_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    // Act
    int actualAddApplicationResult = new AppGroupEntryDao(dsl).addApplication(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"application_group_entry\" (\"group_id\", \"application_id\") select \"t\".\"group_id\", \"t\".\"application_id\" from (select cast(? as bigint) \"group_id\", cast(? as bigint) \"application_id\" from RDB$DATABASE where not exists (select 1 \"one\" from \"application_group_entry\" where (\"application_group_entry\".\"group_id\" = cast(? as bigint) and \"application_group_entry\".\"application_id\" = cast(? as bigint)))) \"t\"");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualAddApplicationResult);
  }

  /**
   * Test {@link AppGroupEntryDao#addApplication(long, long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#addApplication(long, long)}
   */
  @Test
  @DisplayName(
      "Test addApplication(long, long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.addApplication(long, long)"})
  void testAddApplication_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    int actualAddApplicationResult = new AppGroupEntryDao(dsl).addApplication(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"application_group_entry\" (\"group_id\", \"application_id\") select \"t\".\"group_id\", \"t\".\"application_id\" from (select ? \"group_id\", ? \"application_id\" where not exists (select 1 \"one\" from \"application_group_entry\" where (\"application_group_entry\".\"group_id\" = ? and \"application_group_entry\".\"application_id\" = ?))) \"t\"");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualAddApplicationResult);
  }

  /**
   * Test {@link AppGroupEntryDao#addApplication(long, long)}.
   *
   * <ul>
   *   <li>Given {@link InsertReturningStep} {@link InsertReturningStep#execute()} return three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#addApplication(long, long)}
   */
  @Test
  @DisplayName(
      "Test addApplication(long, long); given InsertReturningStep execute() return three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.addApplication(long, long)"})
  void testAddApplication_givenInsertReturningStepExecuteReturnThree_thenReturnThree()
      throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupEntryRecord> insertReturningStep =
        mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);

    InsertSetMoreStep<ApplicationGroupEntryRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);

    InsertSetMoreStep<ApplicationGroupEntryRecord> insertSetMoreStep2 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetStep<ApplicationGroupEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupEntryRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    int actualAddApplicationResult = new AppGroupEntryDao(dsl).addApplication(1L, 1L);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddApplicationResult);
  }

  /**
   * Test {@link AppGroupEntryDao#addApplication(long, long)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#addApplication(long, long)}
   */
  @Test
  @DisplayName("Test addApplication(long, long); when four; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.addApplication(long, long)"})
  void testAddApplication_whenFour_thenReturnThree() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupEntryRecord> insertReturningStep =
        mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);

    InsertSetMoreStep<ApplicationGroupEntryRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);

    InsertSetMoreStep<ApplicationGroupEntryRecord> insertSetMoreStep2 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetStep<ApplicationGroupEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupEntryRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    int actualAddApplicationResult = new AppGroupEntryDao(dsl).addApplication(4L, 1L);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddApplicationResult);
  }

  /**
   * Test {@link AppGroupEntryDao#addApplication(long, long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#addApplication(long, long)}
   */
  @Test
  @DisplayName("Test addApplication(long, long); when three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.addApplication(long, long)"})
  void testAddApplication_whenThree_thenReturnThree() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupEntryRecord> insertReturningStep =
        mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);

    InsertSetMoreStep<ApplicationGroupEntryRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);

    InsertSetMoreStep<ApplicationGroupEntryRecord> insertSetMoreStep2 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetStep<ApplicationGroupEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupEntryRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    int actualAddApplicationResult = new AppGroupEntryDao(dsl).addApplication(3L, 1L);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddApplicationResult);
  }

  /**
   * Test {@link AppGroupEntryDao#addApplication(long, long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#addApplication(long, long)}
   */
  @Test
  @DisplayName("Test addApplication(long, long); when two; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.addApplication(long, long)"})
  void testAddApplication_whenTwo_thenReturnThree() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupEntryRecord> insertReturningStep =
        mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);

    InsertSetMoreStep<ApplicationGroupEntryRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);

    InsertSetMoreStep<ApplicationGroupEntryRecord> insertSetMoreStep2 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetStep<ApplicationGroupEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupEntryRecord>>any()))
        .thenReturn(insertSetStep);

    // Act
    int actualAddApplicationResult = new AppGroupEntryDao(dsl).addApplication(2L, 1L);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddApplicationResult);
  }

  /**
   * Test {@link AppGroupEntryDao#addApplications(long, Collection)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#addApplications(long, Collection)}
   */
  @Test
  @DisplayName(
      "Test addApplications(long, Collection); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] AppGroupEntryDao.addApplications(long, Collection)"})
  void testAddApplications_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);

    // Act
    int[] actualAddApplicationsResult = appGroupEntryDao.addApplications(1L, applicationIds);

    // Assert
    verify(connection).createStatement();
    verify(statement)
        .addBatch(
            "insert into \"application_group_entry\" (\"group_id\", \"application_id\") values (1, 1) on duplicate key update \"application_group_entry\".\"group_id\" = \"application_group_entry\".\"group_id\"");
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualAddApplicationsResult);
  }

  /**
   * Test {@link AppGroupEntryDao#addApplications(long, Collection)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code DERBY}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#addApplications(long, Collection)}
   */
  @Test
  @DisplayName(
      "Test addApplications(long, Collection); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'DERBY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] AppGroupEntryDao.addApplications(long, Collection)"})
  void testAddApplications_givenDefaultDSLContextWithConnectionAndDialectIsDerby()
      throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.DERBY);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);

    // Act
    int[] actualAddApplicationsResult = appGroupEntryDao.addApplications(1L, applicationIds);

    // Assert
    verify(connection).createStatement();
    verify(statement)
        .addBatch(
            "merge into \"application_group_entry\" using SYSIBM.SYSDUMMY1 on (\"application_group_entry\".\"group_id\" = 1 and \"application_group_entry\".\"application_id\" = 1) when not matched then insert (\"group_id\", \"application_id\") values (1, 1)");
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualAddApplicationsResult);
  }

  /**
   * Test {@link AppGroupEntryDao#addApplications(long, Collection)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#addApplications(long, Collection)}
   */
  @Test
  @DisplayName(
      "Test addApplications(long, Collection); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] AppGroupEntryDao.addApplications(long, Collection)"})
  void testAddApplications_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);

    // Act
    int[] actualAddApplicationsResult = appGroupEntryDao.addApplications(1L, applicationIds);

    // Assert
    verify(connection).createStatement();
    verify(statement)
        .addBatch(
            "insert into \"application_group_entry\" (\"group_id\", \"application_id\") select \"t\".\"group_id\", \"t\".\"application_id\" from (select 1 \"group_id\", 1 \"application_id\" from RDB$DATABASE where not exists (select 1 \"one\" from \"application_group_entry\" where (\"application_group_entry\".\"group_id\" = 1 and \"application_group_entry\".\"application_id\" = 1))) \"t\"");
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualAddApplicationsResult);
  }

  /**
   * Test {@link AppGroupEntryDao#addApplications(long, Collection)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#addApplications(long, Collection)}
   */
  @Test
  @DisplayName(
      "Test addApplications(long, Collection); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] AppGroupEntryDao.addApplications(long, Collection)"})
  void testAddApplications_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);

    // Act
    int[] actualAddApplicationsResult = appGroupEntryDao.addApplications(1L, applicationIds);

    // Assert
    verify(connection).createStatement();
    verify(statement)
        .addBatch(
            "insert into \"application_group_entry\" (\"group_id\", \"application_id\") select \"t\".\"group_id\", \"t\".\"application_id\" from (select 1 \"group_id\", 1 \"application_id\" where not exists (select 1 \"one\" from \"application_group_entry\" where (\"application_group_entry\".\"group_id\" = 1 and \"application_group_entry\".\"application_id\" = 1))) \"t\"");
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualAddApplicationsResult);
  }

  /**
   * Test {@link AppGroupEntryDao#addApplications(long, Collection)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then calls {@link Statement#addBatch(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#addApplications(long, Collection)}
   */
  @Test
  @DisplayName(
      "Test addApplications(long, Collection); given zero; when ArrayList() add zero; then calls addBatch(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] AppGroupEntryDao.addApplications(long, Collection)"})
  void testAddApplications_givenZero_whenArrayListAddZero_thenCallsAddBatch() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(0L);
    applicationIds.add(1L);

    // Act
    int[] actualAddApplicationsResult = appGroupEntryDao.addApplications(1L, applicationIds);

    // Assert
    verify(connection).createStatement();
    verify(statement, atLeast(1)).addBatch(Mockito.<String>any());
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualAddApplicationsResult);
  }

  /**
   * Test {@link AppGroupEntryDao#addApplications(long, Collection)}.
   *
   * <ul>
   *   <li>Then calls {@link Batch#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#addApplications(long, Collection)}
   */
  @Test
  @DisplayName("Test addApplications(long, Collection); then calls execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] AppGroupEntryDao.addApplications(long, Collection)"})
  void testAddApplications_thenCallsExecute() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch((Query[]) Mockito.any())).thenReturn(batch);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);

    // Act
    int[] actualAddApplicationsResult = appGroupEntryDao.addApplications(1L, applicationIds);

    // Assert
    verify(batch).execute();
    verify(dsl).batch((Query[]) Mockito.any());
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualAddApplicationsResult);
  }

  /**
   * Test {@link AppGroupEntryDao#addApplications(long, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#addApplications(long, Collection)}
   */
  @Test
  @DisplayName("Test addApplications(long, Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] AppGroupEntryDao.addApplications(long, Collection)"})
  void testAddApplications_whenArrayList() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    // Act
    int[] actualAddApplicationsResult = appGroupEntryDao.addApplications(1L, new ArrayList<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualAddApplicationsResult);
  }

  /**
   * Test {@link AppGroupEntryDao#removeApplication(long, long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#removeApplication(long, long)}
   */
  @Test
  @DisplayName(
      "Test removeApplication(long, long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.removeApplication(long, long)"})
  void testRemoveApplication_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    int actualRemoveApplicationResult = new AppGroupEntryDao(dsl).removeApplication(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"application_group_entry\" where (\"application_group_entry\".\"group_id\" = cast(? as bigint) and \"application_group_entry\".\"application_id\" = cast(? as bigint) and \"application_group_entry\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveApplicationResult);
  }

  /**
   * Test {@link AppGroupEntryDao#removeApplication(long, long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#removeApplication(long, long)}
   */
  @Test
  @DisplayName(
      "Test removeApplication(long, long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.removeApplication(long, long)"})
  void testRemoveApplication_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    int actualRemoveApplicationResult = new AppGroupEntryDao(dsl).removeApplication(1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"application_group_entry\" where (\"application_group_entry\".\"group_id\" = ? and \"application_group_entry\".\"application_id\" = ? and \"application_group_entry\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveApplicationResult);
  }

  /**
   * Test {@link AppGroupEntryDao#removeApplication(long, long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#removeApplication(long, long)}
   */
  @Test
  @DisplayName(
      "Test removeApplication(long, long); given DeleteConditionStep execute() return three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.removeApplication(long, long)"})
  void testRemoveApplication_givenDeleteConditionStepExecuteReturnThree_thenReturnThree()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);

    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ApplicationGroupEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupEntryRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualRemoveApplicationResult = new AppGroupEntryDao(dsl).removeApplication(1L, 1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(3, actualRemoveApplicationResult);
  }

  /**
   * Test {@link AppGroupEntryDao#removeApplication(long, long)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#removeApplication(long, long)}
   */
  @Test
  @DisplayName("Test removeApplication(long, long); when four; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.removeApplication(long, long)"})
  void testRemoveApplication_whenFour_thenReturnThree() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);

    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ApplicationGroupEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupEntryRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualRemoveApplicationResult = new AppGroupEntryDao(dsl).removeApplication(4L, 1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(3, actualRemoveApplicationResult);
  }

  /**
   * Test {@link AppGroupEntryDao#removeApplication(long, long)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#removeApplication(long, long)}
   */
  @Test
  @DisplayName("Test removeApplication(long, long); when three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.removeApplication(long, long)"})
  void testRemoveApplication_whenThree_thenReturnThree() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);

    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ApplicationGroupEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupEntryRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualRemoveApplicationResult = new AppGroupEntryDao(dsl).removeApplication(3L, 1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(3, actualRemoveApplicationResult);
  }

  /**
   * Test {@link AppGroupEntryDao#removeApplication(long, long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#removeApplication(long, long)}
   */
  @Test
  @DisplayName("Test removeApplication(long, long); when two; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.removeApplication(long, long)"})
  void testRemoveApplication_whenTwo_thenReturnThree() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);

    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ApplicationGroupEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupEntryRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualRemoveApplicationResult = new AppGroupEntryDao(dsl).removeApplication(2L, 1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(3, actualRemoveApplicationResult);
  }

  /**
   * Test {@link AppGroupEntryDao#removeApplications(long, List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#removeApplications(long, List)}
   */
  @Test
  @DisplayName(
      "Test removeApplications(long, List); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.removeApplications(long, List)"})
  void testRemoveApplications_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    // Act
    int actualRemoveApplicationsResult = appGroupEntryDao.removeApplications(1L, new ArrayList<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"application_group_entry\" where (\"application_group_entry\".\"group_id\" = cast(? as bigint) and 1 = 0 and \"application_group_entry\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveApplicationsResult);
  }

  /**
   * Test {@link AppGroupEntryDao#removeApplications(long, List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#removeApplications(long, List)}
   */
  @Test
  @DisplayName(
      "Test removeApplications(long, List); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.removeApplications(long, List)"})
  void testRemoveApplications_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    // Act
    int actualRemoveApplicationsResult = appGroupEntryDao.removeApplications(1L, new ArrayList<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"application_group_entry\" where (\"application_group_entry\".\"group_id\" = ? and \"application_group_entry\".\"application_id\" in () and \"application_group_entry\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveApplicationsResult);
  }

  /**
   * Test {@link AppGroupEntryDao#removeApplications(long, List)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#removeApplications(long, List)}
   */
  @Test
  @DisplayName(
      "Test removeApplications(long, List); given DeleteConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.removeApplications(long, List)"})
  void testRemoveApplications_givenDeleteConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ApplicationGroupEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupEntryRecord>>any())).thenReturn(deleteUsingStep);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    // Act
    int actualRemoveApplicationsResult = appGroupEntryDao.removeApplications(1L, new ArrayList<>());

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(1, actualRemoveApplicationsResult);
  }

  /**
   * Test {@link AppGroupEntryDao#removeApplications(long, List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#removeApplications(long, List)}
   */
  @Test
  @DisplayName(
      "Test removeApplications(long, List); given one; when ArrayList() add one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.removeApplications(long, List)"})
  void testRemoveApplications_givenOne_whenArrayListAddOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ApplicationGroupEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupEntryRecord>>any())).thenReturn(deleteUsingStep);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);

    // Act
    int actualRemoveApplicationsResult = appGroupEntryDao.removeApplications(1L, applicationIds);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(1, actualRemoveApplicationsResult);
  }

  /**
   * Test {@link AppGroupEntryDao#removeApplications(long, List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#removeApplications(long, List)}
   */
  @Test
  @DisplayName(
      "Test removeApplications(long, List); given zero; when ArrayList() add zero; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AppGroupEntryDao.removeApplications(long, List)"})
  void testRemoveApplications_givenZero_whenArrayListAddZero_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<ApplicationGroupEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupEntryRecord>>any())).thenReturn(deleteUsingStep);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(0L);
    applicationIds.add(1L);

    // Act
    int actualRemoveApplicationsResult = appGroupEntryDao.removeApplications(1L, applicationIds);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(1, actualRemoveApplicationsResult);
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}.
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  @DisplayName("Test replaceGroupApplicationEntries(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupApplicationEntries(Set)"})
  void testReplaceGroupApplicationEntries() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    Tuple2<Long, Set<AppGroupEntry>> tuple2 = new Tuple2<>(1L, new HashSet<>());
    entriesForGroups.add(tuple2);

    // Act
    appGroupEntryDao.replaceGroupApplicationEntries(entriesForGroups);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "delete from \"application_group_entry\" where \"application_group_entry\".\"group_id\" in (?)");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}.
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  @DisplayName("Test replaceGroupApplicationEntries(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupApplicationEntries(Set)"})
  void testReplaceGroupApplicationEntries2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    Tuple2<Long, Set<AppGroupEntry>> tuple2 = new Tuple2<>(1L, new HashSet<>());
    entriesForGroups.add(tuple2);

    // Act
    appGroupEntryDao.replaceGroupApplicationEntries(entriesForGroups);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "delete from \"application_group_entry\" where \"application_group_entry\".\"group_id\" in (cast(? as bigint))");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupEntryDao#AppGroupEntryDao(DSLContext)} with dsl is {@link
   *       DSLContext}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  @DisplayName(
      "Test replaceGroupApplicationEntries(Set); given AppGroupEntryDao(DSLContext) with dsl is DSLContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupApplicationEntries(Set)"})
  void testReplaceGroupApplicationEntries_givenAppGroupEntryDaoWithDslIsDSLContext() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(mock(Tuple2.class));

    // Act
    appGroupEntryDao.replaceGroupApplicationEntries(entriesForGroups);

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#addBatch()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  @DisplayName("Test replaceGroupApplicationEntries(Set); then calls addBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupApplicationEntries(Set)"})
  void testReplaceGroupApplicationEntries_thenCallsAddBatch() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    HashSet<AppGroupEntry> appGroupEntrySet = new HashSet<>();
    appGroupEntrySet.add(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());
    Tuple2<Long, Set<AppGroupEntry>> tuple2 = new Tuple2<>(1L, appGroupEntrySet);

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(tuple2);

    // Act
    appGroupEntryDao.replaceGroupApplicationEntries(entriesForGroups);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(3, false);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(4, "Provenance");
    verify(preparedStatement).setTimestamp(eq(5), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#addBatch()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  @DisplayName("Test replaceGroupApplicationEntries(Set); then calls addBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupApplicationEntries(Set)"})
  void testReplaceGroupApplicationEntries_thenCallsAddBatch2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    HashSet<AppGroupEntry> appGroupEntrySet = new HashSet<>();
    appGroupEntrySet.add(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());
    Tuple2<Long, Set<AppGroupEntry>> tuple2 = new Tuple2<>(1L, appGroupEntrySet);

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(tuple2);

    // Act
    appGroupEntryDao.replaceGroupApplicationEntries(entriesForGroups);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(3, false);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(4, "Provenance");
    verify(preparedStatement).setTimestamp(eq(5), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#addBatch()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  @DisplayName("Test replaceGroupApplicationEntries(Set); then calls addBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupApplicationEntries(Set)"})
  void testReplaceGroupApplicationEntries_thenCallsAddBatch3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    HashSet<AppGroupEntry> appGroupEntrySet = new HashSet<>();
    appGroupEntrySet.add(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());
    Tuple2<Long, Set<AppGroupEntry>> tuple2 = new Tuple2<>(1L, appGroupEntrySet);

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    Tuple2<Long, Set<AppGroupEntry>> tuple22 = new Tuple2<>(1L, new HashSet<>());
    entriesForGroups.add(tuple22);
    entriesForGroups.add(tuple2);

    // Act
    appGroupEntryDao.replaceGroupApplicationEntries(entriesForGroups);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(3, false);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(4, "Provenance");
    verify(preparedStatement).setTimestamp(eq(5), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  @DisplayName("Test replaceGroupApplicationEntries(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupApplicationEntries(Set)"})
  void testReplaceGroupApplicationEntries_whenHashSet() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    // Act
    appGroupEntryDao.replaceGroupApplicationEntries(new HashSet<>());

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "delete from \"application_group_entry\" where \"application_group_entry\".\"group_id\" in ()");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  @DisplayName("Test replaceGroupApplicationEntries(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupApplicationEntries(Set)"})
  void testReplaceGroupApplicationEntries_whenHashSet2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    // Act
    appGroupEntryDao.replaceGroupApplicationEntries(new HashSet<>());

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement("delete from \"application_group_entry\" where 1 = 0");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link DSLContext#transaction(TransactionalRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  @DisplayName(
      "Test replaceGroupApplicationEntries(Set); when 'null'; then calls transaction(TransactionalRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupApplicationEntries(Set)"})
  void testReplaceGroupApplicationEntries_whenNull_thenCallsTransaction() {
    // Arrange
    doNothing().when(dSLContext).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    appGroupEntryDao.replaceGroupApplicationEntries(null);

    // Assert
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}.
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}
   */
  @Test
  @DisplayName("Test replaceGroupChangeInitiativeEntries(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupChangeInitiativeEntries(Set)"})
  void testReplaceGroupChangeInitiativeEntries() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    // Act
    appGroupEntryDao.replaceGroupChangeInitiativeEntries(new HashSet<>());

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "delete from \"entity_relationship\" where (1 = 0 and \"entity_relationship\".\"kind_a\" = cast(? as varchar) and \"entity_relationship\".\"kind_b\" = cast(? as varchar))");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}.
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}
   */
  @Test
  @DisplayName("Test replaceGroupChangeInitiativeEntries(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupChangeInitiativeEntries(Set)"})
  void testReplaceGroupChangeInitiativeEntries2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    Tuple2<Long, Set<AppGroupEntry>> tuple2 = new Tuple2<>(1L, new HashSet<>());
    entriesForGroups.add(tuple2);

    // Act
    appGroupEntryDao.replaceGroupChangeInitiativeEntries(entriesForGroups);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "delete from \"entity_relationship\" where (\"entity_relationship\".\"id_a\" in (cast(? as bigint)) and \"entity_relationship\".\"kind_a\" = cast(? as varchar) and \"entity_relationship\".\"kind_b\" = cast(? as varchar))");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}.
   *
   * <ul>
   *   <li>Given {@link AppGroupEntryDao#AppGroupEntryDao(DSLContext)} with dsl is {@link
   *       DSLContext}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}
   */
  @Test
  @DisplayName(
      "Test replaceGroupChangeInitiativeEntries(Set); given AppGroupEntryDao(DSLContext) with dsl is DSLContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupChangeInitiativeEntries(Set)"})
  void testReplaceGroupChangeInitiativeEntries_givenAppGroupEntryDaoWithDslIsDSLContext() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(mock(Tuple2.class));

    // Act
    appGroupEntryDao.replaceGroupChangeInitiativeEntries(entriesForGroups);

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#addBatch()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}
   */
  @Test
  @DisplayName("Test replaceGroupChangeInitiativeEntries(Set); then calls addBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupChangeInitiativeEntries(Set)"})
  void testReplaceGroupChangeInitiativeEntries_thenCallsAddBatch() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    HashSet<AppGroupEntry> appGroupEntrySet = new HashSet<>();
    appGroupEntrySet.add(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());
    Tuple2<Long, Set<AppGroupEntry>> tuple2 = new Tuple2<>(1L, appGroupEntrySet);

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(tuple2);

    // Act
    appGroupEntryDao.replaceGroupChangeInitiativeEntries(entriesForGroups);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(7), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#addBatch()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}
   */
  @Test
  @DisplayName("Test replaceGroupChangeInitiativeEntries(Set); then calls addBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupChangeInitiativeEntries(Set)"})
  void testReplaceGroupChangeInitiativeEntries_thenCallsAddBatch2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    HashSet<AppGroupEntry> appGroupEntrySet = new HashSet<>();
    appGroupEntrySet.add(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());
    Tuple2<Long, Set<AppGroupEntry>> tuple2 = new Tuple2<>(1L, appGroupEntrySet);

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    Tuple2<Long, Set<AppGroupEntry>> tuple22 = new Tuple2<>(1L, new HashSet<>());
    entriesForGroups.add(tuple22);
    entriesForGroups.add(tuple2);

    // Act
    appGroupEntryDao.replaceGroupChangeInitiativeEntries(entriesForGroups);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(7), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#setLong(int, long)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}
   */
  @Test
  @DisplayName("Test replaceGroupChangeInitiativeEntries(Set); then calls setLong(int, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupChangeInitiativeEntries(Set)"})
  void testReplaceGroupChangeInitiativeEntries_thenCallsSetLong() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    Tuple2<Long, Set<AppGroupEntry>> tuple2 = new Tuple2<>(1L, new HashSet<>());
    entriesForGroups.add(tuple2);

    // Act
    appGroupEntryDao.replaceGroupChangeInitiativeEntries(entriesForGroups);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "delete from \"entity_relationship\" where (\"entity_relationship\".\"id_a\" in (?) and \"entity_relationship\".\"kind_a\" = ? and \"entity_relationship\".\"kind_b\" = ?)");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}
   */
  @Test
  @DisplayName("Test replaceGroupChangeInitiativeEntries(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupChangeInitiativeEntries(Set)"})
  void testReplaceGroupChangeInitiativeEntries_whenHashSet() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    // Act
    appGroupEntryDao.replaceGroupChangeInitiativeEntries(new HashSet<>());

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "delete from \"entity_relationship\" where (\"entity_relationship\".\"id_a\" in () and \"entity_relationship\".\"kind_a\" = ? and \"entity_relationship\".\"kind_b\" = ?)");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Test {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link DSLContext#transaction(TransactionalRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}
   */
  @Test
  @DisplayName(
      "Test replaceGroupChangeInitiativeEntries(Set); when 'null'; then calls transaction(TransactionalRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppGroupEntryDao.replaceGroupChangeInitiativeEntries(Set)"})
  void testReplaceGroupChangeInitiativeEntries_whenNull_thenCallsTransaction() {
    // Arrange
    doNothing().when(dSLContext).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    appGroupEntryDao.replaceGroupChangeInitiativeEntries(null);

    // Assert
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link AppGroupEntryDao#fetchEntitiesForGroups(Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#fetchEntitiesForGroups(Set)}
   */
  @Test
  @DisplayName("Test fetchEntitiesForGroups(Set); given one; when HashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AppGroupEntryDao.fetchEntitiesForGroups(Set)"})
  void testFetchEntitiesForGroups_givenOne_whenHashSetAddOne() throws MappingException {
    // Arrange
    SelectOrderByStep<Record4<Object, Object, Object, Object>> selectOrderByStep =
        mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetchGroups(
            Mockito.<RecordMapper<Record4<Object, Object, Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record4<Object, Object, Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectOrderByStep<Record4<Object, Object, Object, Object>> selectOrderByStep2 =
        mock(SelectOrderByStep.class);
    when(selectOrderByStep2.union(Mockito.<Select<Record4<Object, Object, Object, Object>>>any()))
        .thenReturn(selectOrderByStep);

    SelectConditionStep<Record4<Object, Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.union(Mockito.<Select<Record4<Object, Object, Object, Object>>>any()))
        .thenReturn(selectOrderByStep2);

    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record4<Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    HashSet<Long> groupIds = new HashSet<>();
    groupIds.add(1L);

    // Act
    Map<Long, List<EntityReference>> actualFetchEntitiesForGroupsResult =
        appGroupEntryDao.fetchEntitiesForGroups(groupIds);

    // Assert
    verify(dSLContext, atLeast(1))
        .select(
            Mockito.<SelectField<Object>>any(),
            isA(SelectField.class),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any());
    verify(selectOrderByStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(Mockito.<TableLike<?>>any());
    verify(selectJoinStep, atLeast(1)).innerJoin(Mockito.<TableLike<?>>any());
    verify(selectOnStep, atLeast(1)).on(Mockito.<Condition>any());
    verify(selectConditionStep).union(isA(Select.class));
    verify(selectOrderByStep2).union(isA(Select.class));
    verify(selectOnConditionStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualFetchEntitiesForGroupsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupEntryDao#fetchEntitiesForGroups(Set)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#fetchEntitiesForGroups(Set)}
   */
  @Test
  @DisplayName("Test fetchEntitiesForGroups(Set); given zero; when HashSet() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AppGroupEntryDao.fetchEntitiesForGroups(Set)"})
  void testFetchEntitiesForGroups_givenZero_whenHashSetAddZero() throws MappingException {
    // Arrange
    SelectOrderByStep<Record4<Object, Object, Object, Object>> selectOrderByStep =
        mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetchGroups(
            Mockito.<RecordMapper<Record4<Object, Object, Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record4<Object, Object, Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectOrderByStep<Record4<Object, Object, Object, Object>> selectOrderByStep2 =
        mock(SelectOrderByStep.class);
    when(selectOrderByStep2.union(Mockito.<Select<Record4<Object, Object, Object, Object>>>any()))
        .thenReturn(selectOrderByStep);

    SelectConditionStep<Record4<Object, Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.union(Mockito.<Select<Record4<Object, Object, Object, Object>>>any()))
        .thenReturn(selectOrderByStep2);

    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record4<Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    HashSet<Long> groupIds = new HashSet<>();
    groupIds.add(0L);
    groupIds.add(1L);

    // Act
    Map<Long, List<EntityReference>> actualFetchEntitiesForGroupsResult =
        appGroupEntryDao.fetchEntitiesForGroups(groupIds);

    // Assert
    verify(dSLContext, atLeast(1))
        .select(
            Mockito.<SelectField<Object>>any(),
            isA(SelectField.class),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any());
    verify(selectOrderByStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(Mockito.<TableLike<?>>any());
    verify(selectJoinStep, atLeast(1)).innerJoin(Mockito.<TableLike<?>>any());
    verify(selectOnStep, atLeast(1)).on(Mockito.<Condition>any());
    verify(selectConditionStep).union(isA(Select.class));
    verify(selectOrderByStep2).union(isA(Select.class));
    verify(selectOnConditionStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualFetchEntitiesForGroupsResult.isEmpty());
  }

  /**
   * Test {@link AppGroupEntryDao#fetchEntitiesForGroups(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AppGroupEntryDao#fetchEntitiesForGroups(Set)}
   */
  @Test
  @DisplayName("Test fetchEntitiesForGroups(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AppGroupEntryDao.fetchEntitiesForGroups(Set)"})
  void testFetchEntitiesForGroups_whenHashSet() throws MappingException {
    // Arrange
    SelectOrderByStep<Record4<Object, Object, Object, Object>> selectOrderByStep =
        mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetchGroups(
            Mockito.<RecordMapper<Record4<Object, Object, Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record4<Object, Object, Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectOrderByStep<Record4<Object, Object, Object, Object>> selectOrderByStep2 =
        mock(SelectOrderByStep.class);
    when(selectOrderByStep2.union(Mockito.<Select<Record4<Object, Object, Object, Object>>>any()))
        .thenReturn(selectOrderByStep);

    SelectConditionStep<Record4<Object, Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.union(Mockito.<Select<Record4<Object, Object, Object, Object>>>any()))
        .thenReturn(selectOrderByStep2);

    SelectOnConditionStep<Record4<Object, Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record4<Object, Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record4<Object, Object, Object, Object>> selectJoinStep =
        mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record4<Object, Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Map<Long, List<EntityReference>> actualFetchEntitiesForGroupsResult =
        appGroupEntryDao.fetchEntitiesForGroups(new HashSet<>());

    // Assert
    verify(dSLContext, atLeast(1))
        .select(
            Mockito.<SelectField<Object>>any(),
            isA(SelectField.class),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any());
    verify(selectOrderByStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(Mockito.<TableLike<?>>any());
    verify(selectJoinStep, atLeast(1)).innerJoin(Mockito.<TableLike<?>>any());
    verify(selectOnStep, atLeast(1)).on(Mockito.<Condition>any());
    verify(selectConditionStep).union(isA(Select.class));
    verify(selectOrderByStep2).union(isA(Select.class));
    verify(selectOnConditionStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualFetchEntitiesForGroupsResult.isEmpty());
  }
}
