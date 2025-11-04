package org.finos.waltz.data.licence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.licence.ImmutableLicence;
import org.finos.waltz.model.licence.Licence;
import org.finos.waltz.model.licence.SaveLicenceCommand;
import org.finos.waltz.model.tally.ImmutableTally;
import org.finos.waltz.model.tally.Tally;
import org.finos.waltz.schema.tables.records.LicenceRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.exception.NoDataFoundException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LicenceDaoDiffblueTest {
  /**
   * Method under test: {@link LicenceDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<Licence> actualFindAllResult = (new LicenceDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"licence\".\"id\", \"licence\".\"name\", \"licence\".\"description\", \"licence\".\"external_id\", \"licence\".\"created_by\", \"licence\".\"created_at\", \"licence\".\"last_updated_by\", \"licence\".\"last_updated_at\", \"licence\".\"provenance\" from \"licence\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindAllResult.size());
    Licence getResult = actualFindAllResult.get(0);
    assertTrue(getResult instanceof ImmutableLicence);
    Licence getResult2 = actualFindAllResult.get(1);
    assertTrue(getResult2 instanceof ImmutableLicence);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link LicenceDao#getById(long)}
   */
  @Test
  void testGetById() throws SQLException {
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

    // Act and Assert
    assertThrows(NoDataFoundException.class,
        () -> (new LicenceDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L));
    verify(connection).prepareStatement(eq(
        "select \"licence\".\"id\", \"licence\".\"name\", \"licence\".\"description\", \"licence\".\"external_id\", \"licence\".\"created_by\", \"licence\".\"created_at\", \"licence\".\"last_updated_by\", \"licence\".\"last_updated_at\", \"licence\".\"provenance\" from \"licence\" where \"licence\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test: {@link LicenceDao#getById(long)}
   */
  @Test
  void testGetById2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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
    Licence actualById = (new LicenceDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"licence\".\"id\", \"licence\".\"name\", \"licence\".\"description\", \"licence\".\"external_id\", \"licence\".\"created_by\", \"licence\".\"created_at\", \"licence\".\"last_updated_by\", \"licence\".\"last_updated_at\", \"licence\".\"provenance\" from \"licence\" where \"licence\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertTrue(actualById instanceof ImmutableLicence);
    assertEquals("String", actualById.description());
    assertEquals("String", actualById.name());
    assertEquals("String", actualById.provenance());
  }

  /**
   * Method under test: {@link LicenceDao#getByExternalId(String)}
   */
  @Test
  void testGetByExternalId() throws SQLException {
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

    // Act and Assert
    assertThrows(NoDataFoundException.class,
        () -> (new LicenceDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getByExternalId("42"));
    verify(connection).prepareStatement(eq(
        "select \"licence\".\"id\", \"licence\".\"name\", \"licence\".\"description\", \"licence\".\"external_id\", \"licence\".\"created_by\", \"licence\".\"created_at\", \"licence\".\"last_updated_by\", \"licence\".\"last_updated_at\", \"licence\".\"provenance\" from \"licence\" where \"licence\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
  }

  /**
   * Method under test: {@link LicenceDao#getByExternalId(String)}
   */
  @Test
  void testGetByExternalId2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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

    // Act
    Licence actualByExternalId = (new LicenceDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"licence\".\"id\", \"licence\".\"name\", \"licence\".\"description\", \"licence\".\"external_id\", \"licence\".\"created_by\", \"licence\".\"created_at\", \"licence\".\"last_updated_by\", \"licence\".\"last_updated_at\", \"licence\".\"provenance\" from \"licence\" where \"licence\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertTrue(actualByExternalId instanceof ImmutableLicence);
    assertEquals("String", actualByExternalId.description());
    assertEquals("String", actualByExternalId.name());
    assertEquals("String", actualByExternalId.provenance());
  }

  /**
   * Method under test: {@link LicenceDao#countApplications()}
   */
  @Test
  void testCountApplications() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<Tally<Long>> actualCountApplicationsResult = (new LicenceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).countApplications();

    // Assert
    verify(connection).prepareStatement(eq(
        "select licence_id, count(licence_id) \"count\" from (select distinct \"software_usage\".\"application_id\", \"software_version_licence\".\"licence_id\" from \"software_version_licence\" join \"software_usage\" on \"software_usage\".\"software_version_id\" = \"software_version_licence\".\"software_version_id\") \"appLicences\" where (1 = 1) group by licence_id"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualCountApplicationsResult.size());
    Tally<Long> getResult = actualCountApplicationsResult.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    Tally<Long> getResult2 = actualCountApplicationsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTally);
    assertEquals(1.0d, getResult.count());
    assertEquals(1L, getResult.id().longValue());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link LicenceDao#save(SaveLicenceCommand, String)}
   */
  @Test
  void testSave() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.newRecord(Mockito.<Table<LicenceRecord>>any())).thenThrow(new NoDataFoundException("An error occurred"));

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> (new LicenceDao(dsl)).save(null, "janedoe"));
    verify(dsl).newRecord(isA(Table.class));
  }

  /**
   * Method under test: {@link LicenceDao#save(SaveLicenceCommand, String)}
   */
  @Test
  void testSave2() {
    // Arrange
    LicenceRecord licenceRecord = mock(LicenceRecord.class);
    doThrow(new NoDataFoundException("An error occurred")).when(licenceRecord).setCreatedAt(Mockito.<Timestamp>any());
    doNothing().when(licenceRecord).setDescription(Mockito.<String>any());
    doNothing().when(licenceRecord).setLastUpdatedAt(Mockito.<Timestamp>any());
    doNothing().when(licenceRecord).setLastUpdatedBy(Mockito.<String>any());
    doNothing().when(licenceRecord).setName(Mockito.<String>any());
    doNothing().when(licenceRecord).setProvenance(Mockito.<String>any());
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.newRecord(Mockito.<Table<LicenceRecord>>any())).thenReturn(licenceRecord);
    LicenceDao licenceDao = new LicenceDao(dsl);
    SaveLicenceCommand cmd = mock(SaveLicenceCommand.class);
    when(cmd.description()).thenReturn("The characteristics of someone or something");
    when(cmd.name()).thenReturn("Name");
    Optional<Long> emptyResult = Optional.empty();
    when(cmd.id()).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> licenceDao.save(cmd, "janedoe"));
    verify(cmd).description();
    verify(cmd).id();
    verify(cmd).name();
    verify(licenceRecord).setCreatedAt(isA(Timestamp.class));
    verify(licenceRecord).setDescription(eq("The characteristics of someone or something"));
    verify(licenceRecord).setLastUpdatedAt(isA(Timestamp.class));
    verify(licenceRecord).setLastUpdatedBy(eq("janedoe"));
    verify(licenceRecord).setName(eq("Name"));
    verify(licenceRecord).setProvenance(eq("waltz"));
    verify(dsl).newRecord(isA(Table.class));
  }

  /**
   * Method under test: {@link LicenceDao#remove(long)}
   */
  @Test
  void testRemove() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualRemoveResult = (new LicenceDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).remove(1L);

    // Assert
    verify(connection).prepareStatement(eq("delete from \"licence\" where \"licence\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link LicenceDao#remove(long)}
   */
  @Test
  void testRemove2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<LicenceRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<LicenceRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<LicenceRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    boolean actualRemoveResult = (new LicenceDao(dsl)).remove(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test: {@link LicenceDao#remove(long)}
   */
  @Test
  void testRemove3() {
    // Arrange
    DeleteUsingStep<LicenceRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenThrow(new NoDataFoundException("An error occurred"));
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<LicenceRecord>>any())).thenReturn(deleteUsingStep);

    // Act and Assert
    assertThrows(NoDataFoundException.class, () -> (new LicenceDao(dsl)).remove(1L));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(dsl).deleteFrom(isA(Table.class));
  }
}
