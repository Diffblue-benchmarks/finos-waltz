package org.finos.waltz.data.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.model.tally.ImmutableTally;
import org.finos.waltz.model.tally.Tally;
import org.finos.waltz.schema.tables.records.ApplicationRecord;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ApplicationDaoDiffblueTest {
  /**
   * Method under test: {@link ApplicationDao#getById(long)}
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
    Application actualById = (new ApplicationDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where \"application\".\"id\" = ?"));
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
   * Method under test: {@link ApplicationDao#getById(long)}
   */
  @Test
  void testGetById2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    Application actualById = (new ApplicationDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where \"application\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertTrue(actualById instanceof ImmutableApplication);
    Optional<String> externalIdResult = actualById.externalId();
    assertEquals("String", externalIdResult.get());
    assertEquals("String", actualById.description());
    assertEquals("String", actualById.name());
    assertEquals("String", actualById.provenance());
    assertEquals(1L, actualById.organisationalUnitId().longValue());
    assertEquals(Criticality.UNKNOWN, actualById.businessCriticality());
    assertEquals(EntityKind.APPLICATION, actualById.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualById.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualById.applicationKind());
    assertEquals(LifecyclePhase.DEVELOPMENT, actualById.lifecyclePhase());
    assertEquals(RagRating.Z, actualById.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(actualById.isRemoved());
  }

  /**
   * Method under test: {@link ApplicationDao#getById(long)}
   */
  @Test
  void testGetById3() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("IN_HOUSE");
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
    Application actualById = (new ApplicationDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where \"application\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertTrue(actualById instanceof ImmutableApplication);
    Optional<String> externalIdResult = actualById.externalId();
    assertEquals("IN_HOUSE", externalIdResult.get());
    assertEquals("IN_HOUSE", actualById.description());
    assertEquals("IN_HOUSE", actualById.name());
    assertEquals("IN_HOUSE", actualById.provenance());
    assertEquals(1L, actualById.organisationalUnitId().longValue());
    assertEquals(Criticality.UNKNOWN, actualById.businessCriticality());
    assertEquals(EntityKind.APPLICATION, actualById.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualById.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualById.applicationKind());
    assertEquals(LifecyclePhase.DEVELOPMENT, actualById.lifecyclePhase());
    assertEquals(RagRating.Z, actualById.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(actualById.isRemoved());
  }

  /**
   * Method under test: {@link ApplicationDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    List<Application> actualFindAllResult = (new ApplicationDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindAllResult.size());
    Application getResult = actualFindAllResult.get(0);
    assertTrue(getResult instanceof ImmutableApplication);
    Application getResult2 = actualFindAllResult.get(1);
    assertTrue(getResult2 instanceof ImmutableApplication);
    Optional<String> externalIdResult = getResult.externalId();
    assertEquals("String", externalIdResult.get());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(Criticality.UNKNOWN, getResult.businessCriticality());
    assertEquals(EntityKind.APPLICATION, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, getResult.applicationKind());
    assertEquals(LifecyclePhase.DEVELOPMENT, getResult.lifecyclePhase());
    assertEquals(RagRating.Z, getResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(getResult.isRemoved());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link ApplicationDao#findAll()}
   */
  @Test
  void testFindAll2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("IN_HOUSE");
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
    List<Application> actualFindAllResult = (new ApplicationDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindAllResult.size());
    Application getResult = actualFindAllResult.get(0);
    assertTrue(getResult instanceof ImmutableApplication);
    Application getResult2 = actualFindAllResult.get(1);
    assertTrue(getResult2 instanceof ImmutableApplication);
    Optional<String> externalIdResult = getResult.externalId();
    assertEquals("IN_HOUSE", externalIdResult.get());
    assertEquals("IN_HOUSE", getResult.description());
    assertEquals("IN_HOUSE", getResult.name());
    assertEquals("IN_HOUSE", getResult.provenance());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(Criticality.UNKNOWN, getResult.businessCriticality());
    assertEquals(EntityKind.APPLICATION, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, getResult.applicationKind());
    assertEquals(LifecyclePhase.DEVELOPMENT, getResult.lifecyclePhase());
    assertEquals(RagRating.Z, getResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(getResult.isRemoved());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link ApplicationDao#findByIds(Collection)}
   */
  @Test
  void testFindByIds() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<Application> actualFindByIdsResult = applicationDao.findByIds(new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where \"application\".\"id\" in ()"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindByIdsResult.size());
    Application getResult = actualFindByIdsResult.get(0);
    assertTrue(getResult instanceof ImmutableApplication);
    Application getResult2 = actualFindByIdsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableApplication);
    Optional<String> externalIdResult = getResult.externalId();
    assertEquals("String", externalIdResult.get());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(Criticality.UNKNOWN, getResult.businessCriticality());
    assertEquals(EntityKind.APPLICATION, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, getResult.applicationKind());
    assertEquals(LifecyclePhase.DEVELOPMENT, getResult.lifecyclePhase());
    assertEquals(RagRating.Z, getResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(getResult.isRemoved());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link ApplicationDao#findByIds(Collection)}
   */
  @Test
  void testFindByIds2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("IN_HOUSE");
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
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<Application> actualFindByIdsResult = applicationDao.findByIds(new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" where \"application\".\"id\" in ()"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindByIdsResult.size());
    Application getResult = actualFindByIdsResult.get(0);
    assertTrue(getResult instanceof ImmutableApplication);
    Application getResult2 = actualFindByIdsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableApplication);
    Optional<String> externalIdResult = getResult.externalId();
    assertEquals("IN_HOUSE", externalIdResult.get());
    assertEquals("IN_HOUSE", getResult.description());
    assertEquals("IN_HOUSE", getResult.name());
    assertEquals("IN_HOUSE", getResult.provenance());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(Criticality.UNKNOWN, getResult.businessCriticality());
    assertEquals(EntityKind.APPLICATION, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, getResult.applicationKind());
    assertEquals(LifecyclePhase.DEVELOPMENT, getResult.lifecyclePhase());
    assertEquals(RagRating.Z, getResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(getResult.isRemoved());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link ApplicationDao#countByOrganisationalUnit()}
   */
  @Test
  void testCountByOrganisationalUnit() throws SQLException {
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
    List<Tally<Long>> actualCountByOrganisationalUnitResult = (new ApplicationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).countByOrganisationalUnit();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"organisational_unit_id\", count(\"application\".\"organisational_unit_id\") \"count\" from \"application\" where (\"application\".\"entity_lifecycle_status\" = 'ACTIVE') group by \"application\".\"organisational_unit_id\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(2));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualCountByOrganisationalUnitResult.size());
    Tally<Long> getResult = actualCountByOrganisationalUnitResult.get(0);
    assertTrue(getResult instanceof ImmutableTally);
    Tally<Long> getResult2 = actualCountByOrganisationalUnitResult.get(1);
    assertTrue(getResult2 instanceof ImmutableTally);
    assertEquals(1.0d, getResult.count());
    assertEquals(1L, getResult.id().longValue());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link ApplicationDao#findRelatedByApplicationId(long)}
   */
  @Test
  void testFindRelatedByApplicationId() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<Application> actualFindRelatedByApplicationIdResult = (new ApplicationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findRelatedByApplicationId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"rel\".\"id\", \"rel\".\"name\", \"rel\".\"description\", \"rel\".\"asset_code\", \"rel\".\"created_at\", \"rel\".\"updated_at\", \"rel\".\"organisational_unit_id\", \"rel\".\"kind\", \"rel\".\"lifecycle_phase\", \"rel\".\"parent_asset_code\", \"rel\".\"overall_rating\", \"rel\".\"provenance\", \"rel\".\"business_criticality\", \"rel\".\"is_removed\", \"rel\".\"entity_lifecycle_status\", \"rel\".\"planned_retirement_date\", \"rel\".\"actual_retirement_date\", \"rel\".\"commission_date\" from \"application\" \"rel\" join \"application\" \"self\" on (\"rel\".\"asset_code\" = \"self\".\"asset_code\" or (\"rel\".\"parent_asset_code\" = \"self\".\"parent_asset_code\" and \"self\".\"parent_asset_code\" <> ?) or \"rel\".\"parent_asset_code\" = \"self\".\"asset_code\" or (\"rel\".\"asset_code\" = \"self\".\"parent_asset_code\" and \"self\".\"parent_asset_code\" <> ?)) where (\"self\".\"id\" = ? and \"rel\".\"entity_lifecycle_status\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindRelatedByApplicationIdResult.size());
    Application getResult = actualFindRelatedByApplicationIdResult.get(0);
    assertTrue(getResult instanceof ImmutableApplication);
    Application getResult2 = actualFindRelatedByApplicationIdResult.get(1);
    assertTrue(getResult2 instanceof ImmutableApplication);
    Optional<String> externalIdResult = getResult.externalId();
    assertEquals("String", externalIdResult.get());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(Criticality.UNKNOWN, getResult.businessCriticality());
    assertEquals(EntityKind.APPLICATION, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, getResult.applicationKind());
    assertEquals(LifecyclePhase.DEVELOPMENT, getResult.lifecyclePhase());
    assertEquals(RagRating.Z, getResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(getResult.isRemoved());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link ApplicationDao#update(Application)}
   */
  @Test
  void testUpdate() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(connection, SQLDialect.SQL99));
    Application application = mock(Application.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult);
    when(application.isRemoved()).thenReturn(true);
    when(application.provenance()).thenReturn("Provenance");
    when(application.businessCriticality()).thenReturn(Criticality.LOW);
    when(application.overallRating()).thenReturn(RagRating.R);
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.organisationalUnitId()).thenReturn(1L);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.name()).thenReturn("Name");
    Optional<ExternalIdValue> ofResult2 = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult2);
    Optional<ExternalIdValue> ofResult3 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult3);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);

    // Act
    int actualUpdateResult = applicationDao.update(application);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"application\" set \"application\".\"name\" = ?, \"application\".\"description\" = ?, \"application\".\"asset_code\" = ?, \"application\".\"organisational_unit_id\" = ?, \"application\".\"kind\" = ?, \"application\".\"lifecycle_phase\" = ?, \"application\".\"parent_asset_code\" = ?, \"application\".\"overall_rating\" = ?, \"application\".\"provenance\" = ?, \"application\".\"business_criticality\" = ?, \"application\".\"is_removed\" = ? where \"application\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(11), eq(true));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(application).description();
    verify(application).id();
    verify(application).isRemoved();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).businessCriticality();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
    verify(application).provenance();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Method under test: {@link ApplicationDao#update(Application)}
   */
  @Test
  void testUpdate2() {
    // Arrange
    ApplicationRecord applicationRecord = mock(ApplicationRecord.class);
    doNothing().when(applicationRecord).setAssetCode(Mockito.<String>any());
    doNothing().when(applicationRecord).setBusinessCriticality(Mockito.<String>any());
    doNothing().when(applicationRecord).setDescription(Mockito.<String>any());
    doNothing().when(applicationRecord).setIsRemoved(Mockito.<Boolean>any());
    doNothing().when(applicationRecord).setKind(Mockito.<String>any());
    doNothing().when(applicationRecord).setLifecyclePhase(Mockito.<String>any());
    doNothing().when(applicationRecord).setName(Mockito.<String>any());
    doNothing().when(applicationRecord).setOrganisationalUnitId(Mockito.<Long>any());
    doNothing().when(applicationRecord).setOverallRating(Mockito.<String>any());
    doNothing().when(applicationRecord).setParentAssetCode(Mockito.<String>any());
    doNothing().when(applicationRecord).setProvenance(Mockito.<String>any());
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.newRecord(Mockito.<Table<ApplicationRecord>>any())).thenReturn(applicationRecord);
    ApplicationDao applicationDao = new ApplicationDao(dsl);
    Application application = mock(Application.class);
    Optional<Long> emptyResult = Optional.empty();
    when(application.id()).thenReturn(emptyResult);
    when(application.isRemoved()).thenReturn(true);
    when(application.provenance()).thenReturn("Provenance");
    when(application.businessCriticality()).thenReturn(Criticality.LOW);
    when(application.overallRating()).thenReturn(RagRating.R);
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.organisationalUnitId()).thenReturn(1L);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.name()).thenReturn("Name");
    Optional<ExternalIdValue> ofResult = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult);
    Optional<ExternalIdValue> ofResult2 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult2);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> applicationDao.update(application));
    verify(application).description();
    verify(application).id();
    verify(application).isRemoved();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).businessCriticality();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
    verify(application).provenance();
    verify(applicationRecord).setAssetCode(eq("42"));
    verify(applicationRecord).setBusinessCriticality(eq("LOW"));
    verify(applicationRecord).setDescription(eq("The characteristics of someone or something"));
    verify(applicationRecord).setIsRemoved(eq(true));
    verify(applicationRecord).setKind(eq("IN_HOUSE"));
    verify(applicationRecord).setLifecyclePhase(eq("PRODUCTION"));
    verify(applicationRecord).setName(eq("Name"));
    verify(applicationRecord).setOrganisationalUnitId(eq(1L));
    verify(applicationRecord).setOverallRating(eq("R"));
    verify(applicationRecord).setParentAssetCode(eq("42"));
    verify(applicationRecord).setProvenance(eq("Provenance"));
    verify(dsl).newRecord(isA(Table.class));
  }

  /**
   * Method under test: {@link ApplicationDao#findByAssetCode(ExternalIdValue)}
   */
  @Test
  void testFindByAssetCode() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<Application> actualFindByAssetCodeResult = applicationDao.findByAssetCode(ExternalIdValue.of("42"));

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" left outer join \"external_identifier\" on (\"external_identifier\".\"entity_id\" = \"application\".\"id\" and \"external_identifier\".\"entity_kind\" = ?) where (\"application\".\"asset_code\" = ? or \"external_identifier\".\"external_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindByAssetCodeResult.size());
    Application getResult = actualFindByAssetCodeResult.get(0);
    assertTrue(getResult instanceof ImmutableApplication);
    Application getResult2 = actualFindByAssetCodeResult.get(1);
    assertTrue(getResult2 instanceof ImmutableApplication);
    Optional<String> externalIdResult = getResult.externalId();
    assertEquals("String", externalIdResult.get());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(Criticality.UNKNOWN, getResult.businessCriticality());
    assertEquals(EntityKind.APPLICATION, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, getResult.applicationKind());
    assertEquals(LifecyclePhase.DEVELOPMENT, getResult.lifecyclePhase());
    assertEquals(RagRating.Z, getResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(getResult.isRemoved());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link ApplicationDao#findByAssetCode(ExternalIdValue)}
   */
  @Test
  void testFindByAssetCode2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("IN_HOUSE");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<Application> actualFindByAssetCodeResult = applicationDao.findByAssetCode(ExternalIdValue.of("42"));

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\" from \"application\" left outer join \"external_identifier\" on (\"external_identifier\".\"entity_id\" = \"application\".\"id\" and \"external_identifier\".\"entity_kind\" = ?) where (\"application\".\"asset_code\" = ? or \"external_identifier\".\"external_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(2, actualFindByAssetCodeResult.size());
    Application getResult = actualFindByAssetCodeResult.get(0);
    assertTrue(getResult instanceof ImmutableApplication);
    Application getResult2 = actualFindByAssetCodeResult.get(1);
    assertTrue(getResult2 instanceof ImmutableApplication);
    Optional<String> externalIdResult = getResult.externalId();
    assertEquals("IN_HOUSE", externalIdResult.get());
    assertEquals("IN_HOUSE", getResult.description());
    assertEquals("IN_HOUSE", getResult.name());
    assertEquals("IN_HOUSE", getResult.provenance());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(Criticality.UNKNOWN, getResult.businessCriticality());
    assertEquals(EntityKind.APPLICATION, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, getResult.applicationKind());
    assertEquals(LifecyclePhase.DEVELOPMENT, getResult.lifecyclePhase());
    assertEquals(RagRating.Z, getResult.overallRating());
    assertTrue(externalIdResult.isPresent());
    assertTrue(getResult.isRemoved());
    assertEquals(getResult, getResult2);
  }
}
