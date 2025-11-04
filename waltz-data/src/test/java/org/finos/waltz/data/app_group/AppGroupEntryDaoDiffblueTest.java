package org.finos.waltz.data.app_group;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
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
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.TransactionalRunnable;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AppGroupEntryDaoDiffblueTest {
  /**
   * Method under test: {@link AppGroupEntryDao#findEntriesForGroup(long)}
   */
  @Test
  void testFindEntriesForGroup() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<AppGroupEntry> actualFindEntriesForGroupResult = (new AppGroupEntryDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findEntriesForGroup(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"id\", \"application\".\"name\", \"application_group_entry\".\"is_readonly\", \"application_group_entry\".\"provenance\" from \"application\" join \"application_group_entry\" on \"application_group_entry\".\"application_id\" = \"application\".\"id\" where (\"application_group_entry\".\"group_id\" = ? and \"application\".\"entity_lifecycle_status\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("ACTIVE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(3));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindEntriesForGroupResult.size());
    AppGroupEntry getResult = actualFindEntriesForGroupResult.get(0);
    assertTrue(getResult instanceof ImmutableAppGroupEntry);
    AppGroupEntry getResult2 = actualFindEntriesForGroupResult.get(1);
    assertTrue(getResult2 instanceof ImmutableAppGroupEntry);
    assertEquals("String", getResult.provenance());
    assertNull(getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.APPLICATION, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(getResult.isReadOnly());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link AppGroupEntryDao#addApplication(long, long)}
   */
  @Test
  void testAddApplication() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualAddApplicationResult = (new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .addApplication(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"application_group_entry\" (\"group_id\", \"application_id\") select \"t\".\"group_id\", \"t\".\"application_id\" from (select ? \"group_id\", ? \"application_id\" where not exists (select 1 \"one\" from \"application_group_entry\" where (\"application_group_entry\".\"group_id\" = ? and \"application_group_entry\".\"application_id\" = ?))) \"t\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualAddApplicationResult);
  }

  /**
   * Method under test: {@link AppGroupEntryDao#addApplication(long, long)}
   */
  @Test
  void testAddApplication2() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupEntryRecord> insertReturningStep = mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);
    InsertSetMoreStep<ApplicationGroupEntryRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);
    InsertSetMoreStep<ApplicationGroupEntryRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetStep<ApplicationGroupEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupEntryRecord>>any())).thenReturn(insertSetStep);

    // Act
    int actualAddApplicationResult = (new AppGroupEntryDao(dsl)).addApplication(1L, 1L);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddApplicationResult);
  }

  /**
   * Method under test: {@link AppGroupEntryDao#addApplication(long, long)}
   */
  @Test
  void testAddApplication3() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupEntryRecord> insertReturningStep = mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);
    InsertSetMoreStep<ApplicationGroupEntryRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);
    InsertSetMoreStep<ApplicationGroupEntryRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetStep<ApplicationGroupEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupEntryRecord>>any())).thenReturn(insertSetStep);

    // Act
    int actualAddApplicationResult = (new AppGroupEntryDao(dsl)).addApplication(2L, 1L);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddApplicationResult);
  }

  /**
   * Method under test: {@link AppGroupEntryDao#addApplication(long, long)}
   */
  @Test
  void testAddApplication4() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupEntryRecord> insertReturningStep = mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);
    InsertSetMoreStep<ApplicationGroupEntryRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);
    InsertSetMoreStep<ApplicationGroupEntryRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetStep<ApplicationGroupEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupEntryRecord>>any())).thenReturn(insertSetStep);

    // Act
    int actualAddApplicationResult = (new AppGroupEntryDao(dsl)).addApplication(3L, 1L);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddApplicationResult);
  }

  /**
   * Method under test: {@link AppGroupEntryDao#addApplication(long, long)}
   */
  @Test
  void testAddApplication5() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupEntryRecord> insertReturningStep = mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);
    InsertSetMoreStep<ApplicationGroupEntryRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);
    InsertSetMoreStep<ApplicationGroupEntryRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetStep<ApplicationGroupEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupEntryRecord>>any())).thenReturn(insertSetStep);

    // Act
    int actualAddApplicationResult = (new AppGroupEntryDao(dsl)).addApplication(4L, 1L);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddApplicationResult);
  }

  /**
   * Method under test: {@link AppGroupEntryDao#addApplications(long, Collection)}
   */
  @Test
  void testAddApplications() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int[] actualAddApplicationsResult = appGroupEntryDao.addApplications(1L, new ArrayList<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualAddApplicationsResult);
  }

  /**
   * Method under test: {@link AppGroupEntryDao#addApplications(long, Collection)}
   */
  @Test
  void testAddApplications2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch((Query[]) any())).thenReturn(batch);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    // Act
    int[] actualAddApplicationsResult = appGroupEntryDao.addApplications(1L, new ArrayList<>());

    // Assert
    verify(batch).execute();
    verify(dsl).batch((Query[]) any());
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualAddApplicationsResult);
  }

  /**
   * Method under test: {@link AppGroupEntryDao#addApplications(long, Collection)}
   */
  @Test
  void testAddApplications3() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch((Query[]) any())).thenReturn(batch);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);

    // Act
    int[] actualAddApplicationsResult = appGroupEntryDao.addApplications(1L, applicationIds);

    // Assert
    verify(batch).execute();
    verify(dsl).batch((Query[]) any());
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualAddApplicationsResult);
  }

  /**
   * Method under test: {@link AppGroupEntryDao#addApplications(long, Collection)}
   */
  @Test
  void testAddApplications4() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch((Query[]) any())).thenReturn(batch);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(0L);
    applicationIds.add(1L);

    // Act
    int[] actualAddApplicationsResult = appGroupEntryDao.addApplications(1L, applicationIds);

    // Assert
    verify(batch).execute();
    verify(dsl).batch((Query[]) any());
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualAddApplicationsResult);
  }

  /**
   * Method under test: {@link AppGroupEntryDao#removeApplication(long, long)}
   */
  @Test
  void testRemoveApplication() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualRemoveApplicationResult = (new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .removeApplication(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"application_group_entry\" where (\"application_group_entry\".\"group_id\" = ? and \"application_group_entry\".\"application_id\" = ? and \"application_group_entry\".\"is_readonly\" = false)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveApplicationResult);
  }

  /**
   * Method under test: {@link AppGroupEntryDao#removeApplication(long, long)}
   */
  @Test
  void testRemoveApplication2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteUsingStep<ApplicationGroupEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupEntryRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualRemoveApplicationResult = (new AppGroupEntryDao(dsl)).removeApplication(1L, 1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(3, actualRemoveApplicationResult);
  }

  /**
   * Method under test: {@link AppGroupEntryDao#removeApplication(long, long)}
   */
  @Test
  void testRemoveApplication3() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteUsingStep<ApplicationGroupEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupEntryRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualRemoveApplicationResult = (new AppGroupEntryDao(dsl)).removeApplication(2L, 1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(3, actualRemoveApplicationResult);
  }

  /**
   * Method under test: {@link AppGroupEntryDao#removeApplication(long, long)}
   */
  @Test
  void testRemoveApplication4() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteUsingStep<ApplicationGroupEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupEntryRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualRemoveApplicationResult = (new AppGroupEntryDao(dsl)).removeApplication(3L, 1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(3, actualRemoveApplicationResult);
  }

  /**
   * Method under test: {@link AppGroupEntryDao#removeApplication(long, long)}
   */
  @Test
  void testRemoveApplication5() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteUsingStep<ApplicationGroupEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupEntryRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualRemoveApplicationResult = (new AppGroupEntryDao(dsl)).removeApplication(4L, 1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(3, actualRemoveApplicationResult);
  }

  /**
   * Method under test: {@link AppGroupEntryDao#removeApplications(long, List)}
   */
  @Test
  void testRemoveApplications() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualRemoveApplicationsResult = appGroupEntryDao.removeApplications(1L, new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"application_group_entry\" where (\"application_group_entry\".\"group_id\" = ? and \"application_group_entry\".\"application_id\" in () and \"application_group_entry\".\"is_readonly\" = false)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveApplicationsResult);
  }

  /**
   * Method under test: {@link AppGroupEntryDao#removeApplications(long, List)}
   */
  @Test
  void testRemoveApplications2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
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
   * Method under test: {@link AppGroupEntryDao#removeApplications(long, List)}
   */
  @Test
  void testRemoveApplications3() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
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
   * Method under test: {@link AppGroupEntryDao#removeApplications(long, List)}
   */
  @Test
  void testRemoveApplications4() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<ApplicationGroupEntryRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
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
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  void testReplaceGroupApplicationEntries() throws SQLException {
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
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    appGroupEntryDao.replaceGroupApplicationEntries(new HashSet<>());

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement(
        eq("delete from \"application_group_entry\" where \"application_group_entry\".\"group_id\" in ()"));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  void testReplaceGroupApplicationEntries2() throws SQLException {
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
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.CUBRID));

    // Act
    appGroupEntryDao.replaceGroupApplicationEntries(new HashSet<>());

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement(eq("delete from \"application_group_entry\" where 1 = 0"));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  void testReplaceGroupApplicationEntries3() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    // Act
    appGroupEntryDao.replaceGroupApplicationEntries(new HashSet<>());

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  void testReplaceGroupApplicationEntries4() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(new Tuple2<>(1L, new HashSet<>()));

    // Act
    appGroupEntryDao.replaceGroupApplicationEntries(entriesForGroups);

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  void testReplaceGroupApplicationEntries5() throws SQLException {
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
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(new Tuple2<>(1L, new HashSet<>()));

    // Act
    appGroupEntryDao.replaceGroupApplicationEntries(entriesForGroups);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement(
        eq("delete from \"application_group_entry\" where \"application_group_entry\".\"group_id\" in (?)"));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  void testReplaceGroupApplicationEntries6() throws SQLException {
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
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.CUBRID));

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(new Tuple2<>(1L, new HashSet<>()));

    // Act
    appGroupEntryDao.replaceGroupApplicationEntries(entriesForGroups);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement(eq(
        "delete from \"application_group_entry\" where \"application_group_entry\".\"group_id\" in (cast(? as bigint))"));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  void testReplaceGroupApplicationEntries7() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
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
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    AppGroupEntry appGroupEntry = mock(AppGroupEntry.class);
    when(appGroupEntry.id()).thenReturn(1L);
    when(appGroupEntry.isReadOnly()).thenReturn(true);
    when(appGroupEntry.provenance()).thenReturn("Provenance");

    HashSet<AppGroupEntry> appGroupEntrySet = new HashSet<>();
    appGroupEntrySet.add(appGroupEntry);
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
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(4), eq("Provenance"));
    verify(preparedStatement).setTimestamp(eq(5), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(appGroupEntry).id();
    verify(appGroupEntry).isReadOnly();
    verify(appGroupEntry).provenance();
  }

  /**
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  void testReplaceGroupApplicationEntries8() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
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
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.CUBRID));
    AppGroupEntry appGroupEntry = mock(AppGroupEntry.class);
    when(appGroupEntry.id()).thenReturn(1L);
    when(appGroupEntry.isReadOnly()).thenReturn(true);
    when(appGroupEntry.provenance()).thenReturn("Provenance");

    HashSet<AppGroupEntry> appGroupEntrySet = new HashSet<>();
    appGroupEntrySet.add(appGroupEntry);
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
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(4), eq("Provenance"));
    verify(preparedStatement).setTimestamp(eq(5), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(appGroupEntry).id();
    verify(appGroupEntry).isReadOnly();
    verify(appGroupEntry).provenance();
  }

  /**
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupApplicationEntries(Set)}
   */
  @Test
  void testReplaceGroupApplicationEntries9() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
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
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    AppGroupEntry appGroupEntry = mock(AppGroupEntry.class);
    when(appGroupEntry.id()).thenReturn(1L);
    when(appGroupEntry.isReadOnly()).thenReturn(true);
    when(appGroupEntry.provenance()).thenReturn("Provenance");

    HashSet<AppGroupEntry> appGroupEntrySet = new HashSet<>();
    appGroupEntrySet.add(appGroupEntry);
    Tuple2<Long, Set<AppGroupEntry>> tuple2 = new Tuple2<>(1L, appGroupEntrySet);

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(new Tuple2<>(1L, new HashSet<>()));
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
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(4), eq("Provenance"));
    verify(preparedStatement).setTimestamp(eq(5), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(appGroupEntry).id();
    verify(appGroupEntry).isReadOnly();
    verify(appGroupEntry).provenance();
  }

  /**
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}
   */
  @Test
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
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    appGroupEntryDao.replaceGroupChangeInitiativeEntries(new HashSet<>());

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement(eq(
        "delete from \"entity_relationship\" where (\"entity_relationship\".\"id_a\" in () and \"entity_relationship\".\"kind_a\" = ? and \"entity_relationship\".\"kind_b\" = ?)"));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}
   */
  @Test
  void testReplaceGroupChangeInitiativeEntries2() throws SQLException {
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
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.CUBRID));

    // Act
    appGroupEntryDao.replaceGroupChangeInitiativeEntries(new HashSet<>());

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement(eq(
        "delete from \"entity_relationship\" where (1 = 0 and \"entity_relationship\".\"kind_a\" = cast(? as varchar) and \"entity_relationship\".\"kind_b\" = cast(? as varchar))"));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}
   */
  @Test
  void testReplaceGroupChangeInitiativeEntries3() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    // Act
    appGroupEntryDao.replaceGroupChangeInitiativeEntries(new HashSet<>());

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}
   */
  @Test
  void testReplaceGroupChangeInitiativeEntries4() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(dsl);

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(new Tuple2<>(1L, new HashSet<>()));

    // Act
    appGroupEntryDao.replaceGroupChangeInitiativeEntries(entriesForGroups);

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}
   */
  @Test
  void testReplaceGroupChangeInitiativeEntries5() throws SQLException {
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
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(new Tuple2<>(1L, new HashSet<>()));

    // Act
    appGroupEntryDao.replaceGroupChangeInitiativeEntries(entriesForGroups);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement(eq(
        "delete from \"entity_relationship\" where (\"entity_relationship\".\"id_a\" in (?) and \"entity_relationship\".\"kind_a\" = ? and \"entity_relationship\".\"kind_b\" = ?)"));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}
   */
  @Test
  void testReplaceGroupChangeInitiativeEntries6() throws SQLException {
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
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.CUBRID));

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(new Tuple2<>(1L, new HashSet<>()));

    // Act
    appGroupEntryDao.replaceGroupChangeInitiativeEntries(entriesForGroups);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement(eq(
        "delete from \"entity_relationship\" where (\"entity_relationship\".\"id_a\" in (cast(? as bigint)) and \"entity_relationship\".\"kind_a\" = cast(? as varchar) and \"entity_relationship\".\"kind_b\" = cast(? as varchar))"));
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}
   */
  @Test
  void testReplaceGroupChangeInitiativeEntries7() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
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
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    AppGroupEntry appGroupEntry = mock(AppGroupEntry.class);
    when(appGroupEntry.id()).thenReturn(1L);
    when(appGroupEntry.provenance()).thenReturn("Provenance");

    HashSet<AppGroupEntry> appGroupEntrySet = new HashSet<>();
    appGroupEntrySet.add(appGroupEntry);
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
    verify(appGroupEntry).id();
    verify(appGroupEntry).provenance();
  }

  /**
   * Method under test:
   * {@link AppGroupEntryDao#replaceGroupChangeInitiativeEntries(Set)}
   */
  @Test
  void testReplaceGroupChangeInitiativeEntries8() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
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
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    AppGroupEntry appGroupEntry = mock(AppGroupEntry.class);
    when(appGroupEntry.id()).thenReturn(1L);
    when(appGroupEntry.provenance()).thenReturn("Provenance");

    HashSet<AppGroupEntry> appGroupEntrySet = new HashSet<>();
    appGroupEntrySet.add(appGroupEntry);
    Tuple2<Long, Set<AppGroupEntry>> tuple2 = new Tuple2<>(1L, appGroupEntrySet);

    HashSet<Tuple2<Long, Set<AppGroupEntry>>> entriesForGroups = new HashSet<>();
    entriesForGroups.add(new Tuple2<>(1L, new HashSet<>()));
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
    verify(appGroupEntry).id();
    verify(appGroupEntry).provenance();
  }

  /**
   * Method under test: {@link AppGroupEntryDao#fetchEntitiesForGroups(Set)}
   */
  @Test
  void testFetchEntitiesForGroups() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    AppGroupEntryDao appGroupEntryDao = new AppGroupEntryDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Map<Long, List<EntityReference>> actualFetchEntitiesForGroupsResult = appGroupEntryDao
        .fetchEntitiesForGroups(new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application_group_entry\".\"group_id\", ? \"kind\", \"application\".\"id\", \"application\".\"name\" from \"application_group_entry\" join \"application\" on \"application\".\"id\" = \"application_group_entry\".\"application_id\" where \"application_group_entry\".\"group_id\" in () union select \"application_group_ou_entry\".\"group_id\", ? \"kind\", \"organisational_unit\".\"id\", \"organisational_unit\".\"name\" from \"application_group_ou_entry\" join \"organisational_unit\" on \"organisational_unit\".\"id\" = \"application_group_ou_entry\".\"group_id\" where \"application_group_ou_entry\".\"group_id\" in () union select \"entity_relationship\".\"id_a\", ? \"kind\", \"change_initiative\".\"id\", \"change_initiative\".\"name\" from \"entity_relationship\" join \"change_initiative\" on \"change_initiative\".\"id\" = \"entity_relationship\".\"id_b\" where (\"entity_relationship\".\"kind_a\" = ? and \"entity_relationship\".\"id_a\" in ())"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFetchEntitiesForGroupsResult.isEmpty());
  }
}
