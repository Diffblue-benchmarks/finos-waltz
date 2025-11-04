package org.finos.waltz.data.server_information;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.LifecycleStatus;
import org.finos.waltz.model.server_information.ServerInformation;
import org.jooq.Batch;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.InsertValuesStep11;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServerInformationDaoDiffblueTest {
  /**
   * Method under test: {@link ServerInformationDao#findByAssetCode(String)}
   */
  @Test
  void testFindByAssetCode() throws SQLException {
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

    // Act
    List<ServerInformation> actualFindByAssetCodeResult = (new ServerInformationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByAssetCode("Asset Code");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"server_information\".\"id\", \"server_information\".\"hostname\", \"server_information\".\"operating_system\", \"server_information\".\"location\", \"server_information\".\"operating_system_version\", \"server_information\".\"country\", \"server_information\".\"is_virtual\", \"server_information\".\"provenance\", \"server_information\".\"os_end_of_life_date\", \"server_information\".\"hw_end_of_life_date\", \"server_information\".\"lifecycle_status\", \"server_information\".\"external_id\", \"server_usage\".\"server_id\", \"server_usage\".\"entity_kind\", \"server_usage\".\"entity_id\", \"server_usage\".\"environment\", \"server_usage\".\"last_updated_at\", \"server_usage\".\"last_updated_by\", \"server_usage\".\"provenance\", \"server_usage\".\"id\", \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"server_information\" join \"server_usage\" on (\"server_usage\".\"server_id\" = \"server_information\".\"id\" and \"server_usage\".\"entity_kind\" = ?) join \"application\" on \"application\".\"id\" = \"server_usage\".\"entity_id\" where \"application\".\"asset_code\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByAssetCodeResult.isEmpty());
  }

  /**
   * Method under test: {@link ServerInformationDao#findByAppId(long)}
   */
  @Test
  void testFindByAppId() throws SQLException {
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<ServerInformation> actualFindByAppIdResult = (new ServerInformationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByAppId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"server_information\".\"id\", \"server_information\".\"hostname\", \"server_information\".\"operating_system\", \"server_information\".\"location\", \"server_information\".\"operating_system_version\", \"server_information\".\"country\", \"server_information\".\"is_virtual\", \"server_information\".\"provenance\", \"server_information\".\"os_end_of_life_date\", \"server_information\".\"hw_end_of_life_date\", \"server_information\".\"lifecycle_status\", \"server_information\".\"external_id\" from \"server_information\" join \"server_usage\" on (\"server_usage\".\"server_id\" = \"server_information\".\"id\" and \"server_usage\".\"entity_kind\" = ?) where \"server_usage\".\"entity_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("APPLICATION"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByAppIdResult.isEmpty());
  }

  /**
   * Method under test: {@link ServerInformationDao#getById(long)}
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

    // Act
    ServerInformation actualById = (new ServerInformationDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"server_information\".\"id\", \"server_information\".\"hostname\", \"server_information\".\"operating_system\", \"server_information\".\"location\", \"server_information\".\"operating_system_version\", \"server_information\".\"country\", \"server_information\".\"is_virtual\", \"server_information\".\"provenance\", \"server_information\".\"os_end_of_life_date\", \"server_information\".\"hw_end_of_life_date\", \"server_information\".\"lifecycle_status\", \"server_information\".\"external_id\" from \"server_information\" where \"server_information\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }

  /**
   * Method under test: {@link ServerInformationDao#getByExternalId(String)}
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

    // Act
    ServerInformation actualByExternalId = (new ServerInformationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"server_information\".\"id\", \"server_information\".\"hostname\", \"server_information\".\"operating_system\", \"server_information\".\"location\", \"server_information\".\"operating_system_version\", \"server_information\".\"country\", \"server_information\".\"is_virtual\", \"server_information\".\"provenance\", \"server_information\".\"os_end_of_life_date\", \"server_information\".\"hw_end_of_life_date\", \"server_information\".\"lifecycle_status\", \"server_information\".\"external_id\" from \"server_information\" where \"server_information\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByExternalId);
  }

  /**
   * Method under test: {@link ServerInformationDao#getByHostname(String)}
   */
  @Test
  void testGetByHostname() throws SQLException {
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

    // Act
    ServerInformation actualByHostname = (new ServerInformationDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getByHostname("localhost");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"server_information\".\"id\", \"server_information\".\"hostname\", \"server_information\".\"operating_system\", \"server_information\".\"location\", \"server_information\".\"operating_system_version\", \"server_information\".\"country\", \"server_information\".\"is_virtual\", \"server_information\".\"provenance\", \"server_information\".\"os_end_of_life_date\", \"server_information\".\"hw_end_of_life_date\", \"server_information\".\"lifecycle_status\", \"server_information\".\"external_id\" from \"server_information\" where \"server_information\".\"hostname\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("localhost"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByHostname);
  }

  /**
   * Method under test: {@link ServerInformationDao#bulkSave(List)}
   */
  @Test
  void testBulkSave() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    ServerInformationDao serverInformationDao = new ServerInformationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int[] actualBulkSaveResult = serverInformationDao.bulkSave(new ArrayList<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualBulkSaveResult);
  }

  /**
   * Method under test: {@link ServerInformationDao#bulkSave(List)}
   */
  @Test
  void testBulkSave2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    ServerInformationDao serverInformationDao = new ServerInformationDao(dsl);

    // Act
    int[] actualBulkSaveResult = serverInformationDao.bulkSave(new ArrayList<>());

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualBulkSaveResult);
  }

  /**
   * Method under test: {@link ServerInformationDao#bulkSave(List)}
   */
  @Test
  void testBulkSave3() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    InsertValuesStep11<Record, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object> insertValuesStep11 = mock(
        InsertValuesStep11.class);
    when(insertValuesStep11.values(Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any(),
        Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any(),
        Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any()))
            .thenReturn(mock(InsertValuesStep11.class));
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<Record>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any()))
            .thenReturn(insertValuesStep11);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    ServerInformationDao serverInformationDao = new ServerInformationDao(dsl);
    ServerInformation serverInformation = mock(ServerInformation.class);
    Optional<String> ofResult = Optional.of("foo");
    when(serverInformation.externalId()).thenReturn(ofResult);
    when(serverInformation.provenance()).thenReturn("Provenance");
    when(serverInformation.country()).thenReturn("GB");
    when(serverInformation.hostname()).thenReturn("localhost");
    when(serverInformation.location()).thenReturn("Location");
    when(serverInformation.operatingSystem()).thenReturn("Operating System");
    when(serverInformation.operatingSystemVersion()).thenReturn("1.0.2");
    when(serverInformation.hardwareEndOfLifeDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(serverInformation.operatingSystemEndOfLifeDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(serverInformation.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(serverInformation.virtual()).thenReturn(true);

    ArrayList<ServerInformation> servers = new ArrayList<>();
    servers.add(serverInformation);

    // Act
    int[] actualBulkSaveResult = serverInformationDao.bulkSave(servers);

    // Assert
    verify(serverInformation).externalId();
    verify(serverInformation).country();
    verify(serverInformation).hardwareEndOfLifeDate();
    verify(serverInformation).hostname();
    verify(serverInformation).lifecycleStatus();
    verify(serverInformation).location();
    verify(serverInformation).operatingSystem();
    verify(serverInformation).operatingSystemEndOfLifeDate();
    verify(serverInformation).operatingSystemVersion();
    verify(serverInformation).provenance();
    verify(serverInformation).virtual();
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    verify(dsl).insertInto(isA(Table.class), isA(Field.class), isA(Field.class), isA(Field.class), isA(Field.class),
        isA(Field.class), isA(Field.class), isA(Field.class), isA(Field.class), isA(Field.class), isA(Field.class),
        isA(Field.class));
    verify(insertValuesStep11).values(isA(Object.class), isA(Object.class), isA(Object.class), isA(Object.class),
        isA(Object.class), isA(Object.class), isA(Object.class), isA(Object.class), isA(Object.class),
        isA(Object.class), isA(Object.class));
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualBulkSaveResult);
  }

  /**
   * Method under test: {@link ServerInformationDao#bulkSave(List)}
   */
  @Test
  void testBulkSave4() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    InsertValuesStep11<Record, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object> insertValuesStep11 = mock(
        InsertValuesStep11.class);
    when(insertValuesStep11.values(Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any(),
        Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any(),
        Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any()))
            .thenReturn(mock(InsertValuesStep11.class));
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<Record>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any()))
            .thenReturn(insertValuesStep11);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    ServerInformationDao serverInformationDao = new ServerInformationDao(dsl);
    ServerInformation serverInformation = mock(ServerInformation.class);
    Optional<String> ofResult = Optional.of("foo");
    when(serverInformation.externalId()).thenReturn(ofResult);
    when(serverInformation.provenance()).thenReturn("Provenance");
    when(serverInformation.country()).thenReturn("GB");
    when(serverInformation.hostname()).thenReturn("localhost");
    when(serverInformation.location()).thenReturn("Location");
    when(serverInformation.operatingSystem()).thenReturn("Operating System");
    when(serverInformation.operatingSystemVersion()).thenReturn("1.0.2");
    when(serverInformation.hardwareEndOfLifeDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(serverInformation.operatingSystemEndOfLifeDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(serverInformation.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(serverInformation.virtual()).thenReturn(true);
    ServerInformation serverInformation2 = mock(ServerInformation.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(serverInformation2.externalId()).thenReturn(ofResult2);
    when(serverInformation2.provenance()).thenReturn("Provenance");
    when(serverInformation2.country()).thenReturn("GB");
    when(serverInformation2.hostname()).thenReturn("localhost");
    when(serverInformation2.location()).thenReturn("Location");
    when(serverInformation2.operatingSystem()).thenReturn("Operating System");
    when(serverInformation2.operatingSystemVersion()).thenReturn("1.0.2");
    when(serverInformation2.hardwareEndOfLifeDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(serverInformation2.operatingSystemEndOfLifeDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(serverInformation2.lifecycleStatus()).thenReturn(LifecycleStatus.ACTIVE);
    when(serverInformation2.virtual()).thenReturn(true);

    ArrayList<ServerInformation> servers = new ArrayList<>();
    servers.add(serverInformation2);
    servers.add(serverInformation);

    // Act
    int[] actualBulkSaveResult = serverInformationDao.bulkSave(servers);

    // Assert
    verify(serverInformation2).externalId();
    verify(serverInformation).externalId();
    verify(serverInformation2).country();
    verify(serverInformation).country();
    verify(serverInformation2).hardwareEndOfLifeDate();
    verify(serverInformation).hardwareEndOfLifeDate();
    verify(serverInformation2).hostname();
    verify(serverInformation).hostname();
    verify(serverInformation2).lifecycleStatus();
    verify(serverInformation).lifecycleStatus();
    verify(serverInformation2).location();
    verify(serverInformation).location();
    verify(serverInformation2).operatingSystem();
    verify(serverInformation).operatingSystem();
    verify(serverInformation2).operatingSystemEndOfLifeDate();
    verify(serverInformation).operatingSystemEndOfLifeDate();
    verify(serverInformation2).operatingSystemVersion();
    verify(serverInformation).operatingSystemVersion();
    verify(serverInformation2).provenance();
    verify(serverInformation).provenance();
    verify(serverInformation2).virtual();
    verify(serverInformation).virtual();
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    verify(dsl, atLeast(1)).insertInto(isA(Table.class), isA(Field.class), isA(Field.class), isA(Field.class),
        isA(Field.class), isA(Field.class), isA(Field.class), isA(Field.class), isA(Field.class), isA(Field.class),
        isA(Field.class), isA(Field.class));
    verify(insertValuesStep11, atLeast(1)).values(isA(Object.class), isA(Object.class), isA(Object.class),
        isA(Object.class), isA(Object.class), isA(Object.class), isA(Object.class), isA(Object.class),
        isA(Object.class), isA(Object.class), isA(Object.class));
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualBulkSaveResult);
  }
}
