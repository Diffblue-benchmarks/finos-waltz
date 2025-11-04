package org.finos.waltz.data.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.app_group.AppGroupEntry;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.schema.tables.records.ApplicationGroupOuEntryRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertReturningStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AppGroupOrganisationalUnitDaoDiffblueTest {
  /**
   * Method under test:
   * {@link AppGroupOrganisationalUnitDao#getEntriesForGroup(long)}
   */
  @Test
  void testGetEntriesForGroup() throws SQLException {
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<AppGroupEntry> actualEntriesForGroup = (new AppGroupOrganisationalUnitDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getEntriesForGroup(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"organisational_unit\".\"id\", \"organisational_unit\".\"name\", \"organisational_unit\".\"description\", \"application_group_ou_entry\".\"provenance\", \"application_group_ou_entry\".\"is_readonly\" from \"organisational_unit\" join \"application_group_ou_entry\" on \"application_group_ou_entry\".\"org_unit_id\" = \"organisational_unit\".\"id\" where \"application_group_ou_entry\".\"group_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(5));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualEntriesForGroup.size());
    AppGroupEntry getResult = actualEntriesForGroup.get(0);
    assertTrue(getResult instanceof ImmutableAppGroupEntry);
    AppGroupEntry getResult2 = actualEntriesForGroup.get(1);
    assertTrue(getResult2 instanceof ImmutableAppGroupEntry);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.provenance());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ORG_UNIT, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(getResult.isReadOnly());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test:
   * {@link AppGroupOrganisationalUnitDao#getEntriesForGroup(long)}
   */
  @Test
  void testGetEntriesForGroup2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<AppGroupEntry> actualEntriesForGroup = (new AppGroupOrganisationalUnitDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getEntriesForGroup(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"organisational_unit\".\"id\", \"organisational_unit\".\"name\", \"organisational_unit\".\"description\", \"application_group_ou_entry\".\"provenance\", \"application_group_ou_entry\".\"is_readonly\" from \"organisational_unit\" join \"application_group_ou_entry\" on \"application_group_ou_entry\".\"org_unit_id\" = \"organisational_unit\".\"id\" where \"application_group_ou_entry\".\"group_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualEntriesForGroup.isEmpty());
  }

  /**
   * Method under test:
   * {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}
   */
  @Test
  void testRemoveOrgUnit() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualRemoveOrgUnitResult = (new AppGroupOrganisationalUnitDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).removeOrgUnit(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"application_group_ou_entry\" where (\"application_group_ou_entry\".\"group_id\" = ? and \"application_group_ou_entry\".\"org_unit_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveOrgUnitResult);
  }

  /**
   * Method under test:
   * {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}
   */
  @Test
  void testRemoveOrgUnit2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);
    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteUsingStep<ApplicationGroupOuEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupOuEntryRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualRemoveOrgUnitResult = (new AppGroupOrganisationalUnitDao(dsl)).removeOrgUnit(2L, 1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(3, actualRemoveOrgUnitResult);
  }

  /**
   * Method under test:
   * {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}
   */
  @Test
  void testRemoveOrgUnit3() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);
    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteUsingStep<ApplicationGroupOuEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupOuEntryRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualRemoveOrgUnitResult = (new AppGroupOrganisationalUnitDao(dsl)).removeOrgUnit(3L, 1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(3, actualRemoveOrgUnitResult);
  }

  /**
   * Method under test:
   * {@link AppGroupOrganisationalUnitDao#removeOrgUnit(long, long)}
   */
  @Test
  void testRemoveOrgUnit4() throws DataAccessException {
    // Arrange
    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(3);
    DeleteConditionStep<ApplicationGroupOuEntryRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteUsingStep<ApplicationGroupOuEntryRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<ApplicationGroupOuEntryRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualRemoveOrgUnitResult = (new AppGroupOrganisationalUnitDao(dsl)).removeOrgUnit(4L, 1L);

    // Assert
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(3, actualRemoveOrgUnitResult);
  }

  /**
   * Method under test:
   * {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}
   */
  @Test
  void testAddOrgUnit() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualAddOrgUnitResult = (new AppGroupOrganisationalUnitDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).addOrgUnit(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "insert into \"application_group_ou_entry\" (\"group_id\", \"org_unit_id\") select \"t\".\"group_id\", \"t\".\"org_unit_id\" from (select ? \"group_id\", ? \"org_unit_id\" where not exists (select 1 \"one\" from \"application_group_ou_entry\" where (\"application_group_ou_entry\".\"group_id\" = ? and \"application_group_ou_entry\".\"org_unit_id\" = ?))) \"t\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualAddOrgUnitResult);
  }

  /**
   * Method under test:
   * {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}
   */
  @Test
  void testAddOrgUnit2() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupOuEntryRecord> insertReturningStep = mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);
    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);
    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetStep<ApplicationGroupOuEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupOuEntryRecord>>any())).thenReturn(insertSetStep);

    // Act
    int actualAddOrgUnitResult = (new AppGroupOrganisationalUnitDao(dsl)).addOrgUnit(2L, 1L);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddOrgUnitResult);
  }

  /**
   * Method under test:
   * {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}
   */
  @Test
  void testAddOrgUnit3() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupOuEntryRecord> insertReturningStep = mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);
    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);
    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetStep<ApplicationGroupOuEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupOuEntryRecord>>any())).thenReturn(insertSetStep);

    // Act
    int actualAddOrgUnitResult = (new AppGroupOrganisationalUnitDao(dsl)).addOrgUnit(3L, 1L);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddOrgUnitResult);
  }

  /**
   * Method under test:
   * {@link AppGroupOrganisationalUnitDao#addOrgUnit(long, long)}
   */
  @Test
  void testAddOrgUnit4() throws DataAccessException {
    // Arrange
    InsertReturningStep<ApplicationGroupOuEntryRecord> insertReturningStep = mock(InsertReturningStep.class);
    when(insertReturningStep.execute()).thenReturn(3);
    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyIgnore()).thenReturn(insertReturningStep);
    InsertSetMoreStep<ApplicationGroupOuEntryRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetStep<ApplicationGroupOuEntryRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<ApplicationGroupOuEntryRecord>>any())).thenReturn(insertSetStep);

    // Act
    int actualAddOrgUnitResult = (new AppGroupOrganisationalUnitDao(dsl)).addOrgUnit(4L, 1L);

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep).onDuplicateKeyIgnore();
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertReturningStep).execute();
    assertEquals(3, actualAddOrgUnitResult);
  }
}
