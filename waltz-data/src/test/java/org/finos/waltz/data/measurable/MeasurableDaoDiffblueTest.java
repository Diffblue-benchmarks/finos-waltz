package org.finos.waltz.data.measurable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable.MeasurableHierarchy;
import org.finos.waltz.schema.tables.records.MeasurableRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableDaoDiffblueTest {
  /**
   * Method under test: {@link MeasurableDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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

    // Act
    List<Measurable> actualFindAllResult = (new MeasurableDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\" from \"measurable\" where \"measurable\".\"entity_lifecycle_status\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("ACTIVE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getInt(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertEquals(2, actualFindAllResult.size());
    Measurable getResult = actualFindAllResult.get(0);
    assertTrue(getResult instanceof ImmutableMeasurable);
    Measurable getResult2 = actualFindAllResult.get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurable);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.lastUpdatedBy());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(1L, getResult.categoryId());
    assertEquals(EntityKind.MEASURABLE, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(getResult.concrete());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link MeasurableDao#findAll()}
   */
  @Test
  void testFindAll2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("ACTIVE");
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

    // Act
    List<Measurable> actualFindAllResult = (new MeasurableDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\" from \"measurable\" where \"measurable\".\"entity_lifecycle_status\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("ACTIVE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getInt(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertEquals(2, actualFindAllResult.size());
    Measurable getResult = actualFindAllResult.get(0);
    assertTrue(getResult instanceof ImmutableMeasurable);
    Measurable getResult2 = actualFindAllResult.get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurable);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("ACTIVE", getResult.description());
    assertEquals("ACTIVE", getResult.lastUpdatedBy());
    assertEquals("ACTIVE", getResult.name());
    assertEquals("ACTIVE", getResult.provenance());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(1L, getResult.categoryId());
    assertEquals(EntityKind.MEASURABLE, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(getResult.concrete());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link MeasurableDao#getById(long)}
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
    Measurable actualById = (new MeasurableDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\" from \"measurable\" where \"measurable\".\"id\" = ?"));
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
   * Method under test: {@link MeasurableDao#getById(long)}
   */
  @Test
  void testGetById2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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
    Measurable actualById = (new MeasurableDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\" from \"measurable\" where \"measurable\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(4));
    verify(resultSet).getInt(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp).getTime();
    assertTrue(actualById instanceof ImmutableMeasurable);
    LocalDateTime lastUpdatedAtResult = actualById.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("String", actualById.description());
    assertEquals("String", actualById.lastUpdatedBy());
    assertEquals("String", actualById.name());
    assertEquals("String", actualById.provenance());
    assertEquals(1, actualById.position());
    assertEquals(1L, actualById.organisationalUnitId().longValue());
    assertEquals(1L, actualById.categoryId());
    assertEquals(EntityKind.MEASURABLE, actualById.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualById.entityLifecycleStatus());
    assertTrue(actualById.concrete());
  }

  /**
   * Method under test: {@link MeasurableDao#getById(long)}
   */
  @Test
  void testGetById3() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("ACTIVE");
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
    Measurable actualById = (new MeasurableDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\" from \"measurable\" where \"measurable\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(4));
    verify(resultSet).getInt(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp).getTime();
    assertTrue(actualById instanceof ImmutableMeasurable);
    LocalDateTime lastUpdatedAtResult = actualById.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("ACTIVE", actualById.description());
    assertEquals("ACTIVE", actualById.lastUpdatedBy());
    assertEquals("ACTIVE", actualById.name());
    assertEquals("ACTIVE", actualById.provenance());
    assertEquals(1, actualById.position());
    assertEquals(1L, actualById.organisationalUnitId().longValue());
    assertEquals(1L, actualById.categoryId());
    assertEquals(EntityKind.MEASURABLE, actualById.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualById.entityLifecycleStatus());
    assertTrue(actualById.concrete());
  }

  /**
   * Method under test: {@link MeasurableDao#findByExternalId(String)}
   */
  @Test
  void testFindByExternalId() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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

    // Act
    Collection<Measurable> actualFindByExternalIdResult = (new MeasurableDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\" from \"measurable\" where \"measurable\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getInt(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertTrue(actualFindByExternalIdResult instanceof List);
    assertEquals(2, actualFindByExternalIdResult.size());
    Measurable getResult = ((List<Measurable>) actualFindByExternalIdResult).get(0);
    assertTrue(getResult instanceof ImmutableMeasurable);
    Measurable getResult2 = ((List<Measurable>) actualFindByExternalIdResult).get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurable);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.lastUpdatedBy());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(1L, getResult.categoryId());
    assertEquals(EntityKind.MEASURABLE, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(getResult.concrete());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link MeasurableDao#findByExternalId(String)}
   */
  @Test
  void testFindByExternalId2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("ACTIVE");
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

    // Act
    Collection<Measurable> actualFindByExternalIdResult = (new MeasurableDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\" from \"measurable\" where \"measurable\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getInt(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertTrue(actualFindByExternalIdResult instanceof List);
    assertEquals(2, actualFindByExternalIdResult.size());
    Measurable getResult = ((List<Measurable>) actualFindByExternalIdResult).get(0);
    assertTrue(getResult instanceof ImmutableMeasurable);
    Measurable getResult2 = ((List<Measurable>) actualFindByExternalIdResult).get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurable);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("ACTIVE", getResult.description());
    assertEquals("ACTIVE", getResult.lastUpdatedBy());
    assertEquals("ACTIVE", getResult.name());
    assertEquals("ACTIVE", getResult.provenance());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(1L, getResult.categoryId());
    assertEquals(EntityKind.MEASURABLE, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(getResult.concrete());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test:
   * {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  void testUpdateConcreteFlag() throws SQLException {
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

    // Act
    boolean actualUpdateConcreteFlagResult = (new MeasurableDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateConcreteFlag(1L, true, "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"measurable\" set \"measurable\".\"concrete\" = ?, \"measurable\".\"last_updated_at\" = ?, \"measurable\".\"last_updated_by\" = ? where \"measurable\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(true));
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement).setString(eq(3), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateConcreteFlagResult);
  }

  /**
   * Method under test:
   * {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  void testUpdateConcreteFlag2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateConcreteFlagResult = (new MeasurableDao(dsl)).updateConcreteFlag(1L, true, "42");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateConcreteFlagResult);
  }

  /**
   * Method under test:
   * {@link MeasurableDao#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  void testUpdateConcreteFlag3() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException("foo"));
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new MeasurableDao(dsl)).updateConcreteFlag(1L, true, "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Method under test: {@link MeasurableDao#updateName(long, String, String)}
   */
  @Test
  void testUpdateName() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualUpdateNameResult = (new MeasurableDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateName(1L, "42", "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"measurable\" set \"measurable\".\"name\" = ?, \"measurable\".\"last_updated_at\" = ?, \"measurable\".\"last_updated_by\" = ? where \"measurable\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Method under test: {@link MeasurableDao#updateName(long, String, String)}
   */
  @Test
  void testUpdateName2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateNameResult = (new MeasurableDao(dsl)).updateName(1L, "42", "42");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Method under test: {@link MeasurableDao#updateName(long, String, String)}
   */
  @Test
  void testUpdateName3() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException("foo"));
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new MeasurableDao(dsl)).updateName(1L, "42", "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link MeasurableDao#updateDescription(long, String, String)}
   */
  @Test
  void testUpdateDescription() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualUpdateDescriptionResult = (new MeasurableDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateDescription(1L, "42", "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"measurable\" set \"measurable\".\"description\" = ?, \"measurable\".\"last_updated_at\" = ?, \"measurable\".\"last_updated_by\" = ? where \"measurable\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link MeasurableDao#updateDescription(long, String, String)}
   */
  @Test
  void testUpdateDescription2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateDescriptionResult = (new MeasurableDao(dsl)).updateDescription(1L, "42", "42");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link MeasurableDao#updateDescription(long, String, String)}
   */
  @Test
  void testUpdateDescription3() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException("foo"));
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new MeasurableDao(dsl)).updateDescription(1L, "42", "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Method under test:
   * {@link MeasurableDao#updateExternalId(long, String, String)}
   */
  @Test
  void testUpdateExternalId() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualUpdateExternalIdResult = (new MeasurableDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateExternalId(1L, "42", "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"measurable\" set \"measurable\".\"external_id\" = ?, \"measurable\".\"last_updated_at\" = ?, \"measurable\".\"last_updated_by\" = ? where \"measurable\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(4), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("42"));
    verify(preparedStatement).setTimestamp(eq(2), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateExternalIdResult);
  }

  /**
   * Method under test:
   * {@link MeasurableDao#updateExternalId(long, String, String)}
   */
  @Test
  void testUpdateExternalId2() throws DataAccessException {
    // Arrange
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    boolean actualUpdateExternalIdResult = (new MeasurableDao(dsl)).updateExternalId(1L, "42", "42");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertTrue(actualUpdateExternalIdResult);
  }

  /**
   * Method under test:
   * {@link MeasurableDao#updateExternalId(long, String, String)}
   */
  @Test
  void testUpdateExternalId3() {
    // Arrange
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException("foo"));
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new MeasurableDao(dsl)).updateExternalId(1L, "42", "42"));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
  }

  /**
   * Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  void testCreate() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new MeasurableDao(dsl)).create(null));
    verify(dsl).insertInto(isA(Table.class));
  }

  /**
   * Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  void testCreate2() throws DataAccessException {
    // Arrange
    InsertResultStep<MeasurableRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(new MeasurableRecord());
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) any())).thenReturn(insertResultStep);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep3);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep4);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep5);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep6);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep8 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep7);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep9 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep8);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep10 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep10.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep9);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep11 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep11.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep10);
    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep11);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);
    Measurable measurable = mock(Measurable.class);
    when(measurable.position()).thenReturn(1);
    when(measurable.concrete()).thenReturn(true);
    when(measurable.description()).thenReturn("The characteristics of someone or something");
    when(measurable.lastUpdatedBy()).thenReturn("2020-03-01");
    when(measurable.name()).thenReturn("Name");
    Optional<String> ofResult = Optional.of("foo");
    when(measurable.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(measurable.externalParentId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(measurable.parentId()).thenReturn(ofResult3);
    when(measurable.categoryId()).thenReturn(1L);
    when(measurable.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Long actualCreateResult = measurableDao.create(measurable);

    // Assert
    verify(measurable).description();
    verify(measurable).externalId();
    verify(measurable).externalParentId();
    verify(measurable).lastUpdatedAt();
    verify(measurable).lastUpdatedBy();
    verify(measurable).name();
    verify(measurable).parentId();
    verify(measurable).position();
    verify(measurable).categoryId();
    verify(measurable).concrete();
    verify(dsl).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) any());
    verify(insertSetMoreStep11).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep10).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep9).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    assertNull(actualCreateResult);
  }

  /**
   * Method under test: {@link MeasurableDao#create(Measurable)}
   */
  @Test
  void testCreate3() {
    // Arrange
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(mock(InsertSetMoreStep.class));
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep2);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep3);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep4);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep5);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep6);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep8 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep7);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep9 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep8);
    InsertSetMoreStep<MeasurableRecord> insertSetMoreStep10 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep10.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep9);
    InsertSetStep<MeasurableRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(insertSetMoreStep10);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<MeasurableRecord>>any())).thenReturn(insertSetStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);
    Measurable measurable = mock(Measurable.class);
    when(measurable.position()).thenThrow(new IllegalArgumentException("waltz"));
    when(measurable.concrete()).thenReturn(true);
    when(measurable.description()).thenReturn("The characteristics of someone or something");
    when(measurable.lastUpdatedBy()).thenReturn("2020-03-01");
    when(measurable.name()).thenReturn("Name");
    Optional<String> ofResult = Optional.of("foo");
    when(measurable.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(measurable.externalParentId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(measurable.parentId()).thenReturn(ofResult3);
    when(measurable.categoryId()).thenReturn(1L);
    when(measurable.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.create(measurable));
    verify(measurable).description();
    verify(measurable).externalId();
    verify(measurable).externalParentId();
    verify(measurable).lastUpdatedAt();
    verify(measurable).lastUpdatedBy();
    verify(measurable).name();
    verify(measurable).parentId();
    verify(measurable).position();
    verify(measurable).categoryId();
    verify(measurable).concrete();
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep10).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep9).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
  }

  /**
   * Method under test: {@link MeasurableDao#updateParentId(Long, Long, String)}
   */
  @Test
  void testUpdateParentId() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualUpdateParentIdResult = (new MeasurableDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .updateParentId(1L, 1L, "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"measurable\" set \"measurable\".\"parent_id\" = ?, \"measurable\".\"external_parent_id\" = (select \"measurable\".\"external_id\" from \"measurable\" where \"measurable\".\"id\" = ?), \"measurable\".\"last_updated_at\" = ?, \"measurable\".\"last_updated_by\" = ? where \"measurable\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(4), eq("42"));
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualUpdateParentIdResult);
  }

  /**
   * Method under test: {@link MeasurableDao#moveChildren(Long, Long, String)}
   */
  @Test
  void testMoveChildren() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    boolean actualMoveChildrenResult = (new MeasurableDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .moveChildren(1L, 1L, "42");

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"measurable\" set \"measurable\".\"parent_id\" = ?, \"measurable\".\"external_parent_id\" = (select \"measurable\".\"external_id\" from \"measurable\" where \"measurable\".\"id\" = ?), \"measurable\".\"last_updated_at\" = ?, \"measurable\".\"last_updated_by\" = ? where \"measurable\".\"parent_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(eq(4), eq("42"));
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualMoveChildrenResult);
  }

  /**
   * Method under test: {@link MeasurableDao#findByCategoryId(Long)}
   */
  @Test
  void testFindByCategoryId() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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
    List<Measurable> actualFindByCategoryIdResult = (new MeasurableDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByCategoryId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\" from \"measurable\" where (\"measurable\".\"measurable_category_id\" = ? and \"measurable\".\"entity_lifecycle_status\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("ACTIVE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getInt(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertEquals(2, actualFindByCategoryIdResult.size());
    Measurable getResult = actualFindByCategoryIdResult.get(0);
    assertTrue(getResult instanceof ImmutableMeasurable);
    Measurable getResult2 = actualFindByCategoryIdResult.get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurable);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.lastUpdatedBy());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(1L, getResult.categoryId());
    assertEquals(EntityKind.MEASURABLE, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(getResult.concrete());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link MeasurableDao#findByCategoryId(Long)}
   */
  @Test
  void testFindByCategoryId2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("ACTIVE");
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
    List<Measurable> actualFindByCategoryIdResult = (new MeasurableDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByCategoryId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\" from \"measurable\" where (\"measurable\".\"measurable_category_id\" = ? and \"measurable\".\"entity_lifecycle_status\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("ACTIVE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getInt(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertEquals(2, actualFindByCategoryIdResult.size());
    Measurable getResult = actualFindByCategoryIdResult.get(0);
    assertTrue(getResult instanceof ImmutableMeasurable);
    Measurable getResult2 = actualFindByCategoryIdResult.get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurable);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("ACTIVE", getResult.description());
    assertEquals("ACTIVE", getResult.lastUpdatedBy());
    assertEquals("ACTIVE", getResult.name());
    assertEquals("ACTIVE", getResult.provenance());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(1L, getResult.categoryId());
    assertEquals(EntityKind.MEASURABLE, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(getResult.concrete());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link MeasurableDao#findByCategoryId(Long, Set)}
   */
  @Test
  void testFindByCategoryId3() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    MeasurableDao measurableDao = new MeasurableDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<Measurable> actualFindByCategoryIdResult = measurableDao.findByCategoryId(1L, new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\" from \"measurable\" where (\"measurable\".\"measurable_category_id\" = ? and \"measurable\".\"entity_lifecycle_status\" in ())"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getInt(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertEquals(2, actualFindByCategoryIdResult.size());
    Measurable getResult = actualFindByCategoryIdResult.get(0);
    assertTrue(getResult instanceof ImmutableMeasurable);
    Measurable getResult2 = actualFindByCategoryIdResult.get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurable);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.lastUpdatedBy());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(1L, getResult.categoryId());
    assertEquals(EntityKind.MEASURABLE, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(getResult.concrete());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link MeasurableDao#findByCategoryId(Long, Set)}
   */
  @Test
  void testFindByCategoryId4() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("ACTIVE");
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    MeasurableDao measurableDao = new MeasurableDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<Measurable> actualFindByCategoryIdResult = measurableDao.findByCategoryId(1L, new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\" from \"measurable\" where (\"measurable\".\"measurable_category_id\" = ? and \"measurable\".\"entity_lifecycle_status\" in ())"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getInt(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertEquals(2, actualFindByCategoryIdResult.size());
    Measurable getResult = actualFindByCategoryIdResult.get(0);
    assertTrue(getResult instanceof ImmutableMeasurable);
    Measurable getResult2 = actualFindByCategoryIdResult.get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurable);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("ACTIVE", getResult.description());
    assertEquals("ACTIVE", getResult.lastUpdatedBy());
    assertEquals("ACTIVE", getResult.name());
    assertEquals("ACTIVE", getResult.provenance());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(1L, getResult.categoryId());
    assertEquals(EntityKind.MEASURABLE, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(getResult.concrete());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link MeasurableDao#findByParentId(Long)}
   */
  @Test
  void testFindByParentId() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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
    List<Measurable> actualFindByParentIdResult = (new MeasurableDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByParentId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\" from \"measurable\" where (\"measurable\".\"parent_id\" = ? and \"measurable\".\"entity_lifecycle_status\" = ?) order by \"measurable\".\"position\", \"measurable\".\"name\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("ACTIVE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getInt(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertEquals(2, actualFindByParentIdResult.size());
    Measurable getResult = actualFindByParentIdResult.get(0);
    assertTrue(getResult instanceof ImmutableMeasurable);
    Measurable getResult2 = actualFindByParentIdResult.get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurable);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.lastUpdatedBy());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(1L, getResult.categoryId());
    assertEquals(EntityKind.MEASURABLE, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(getResult.concrete());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link MeasurableDao#findByParentId(Long)}
   */
  @Test
  void testFindByParentId2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("ACTIVE");
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
    List<Measurable> actualFindByParentIdResult = (new MeasurableDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByParentId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\" from \"measurable\" where (\"measurable\".\"parent_id\" = ? and \"measurable\".\"entity_lifecycle_status\" = ?) order by \"measurable\".\"position\", \"measurable\".\"name\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("ACTIVE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getInt(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertEquals(2, actualFindByParentIdResult.size());
    Measurable getResult = actualFindByParentIdResult.get(0);
    assertTrue(getResult instanceof ImmutableMeasurable);
    Measurable getResult2 = actualFindByParentIdResult.get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurable);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("ACTIVE", getResult.description());
    assertEquals("ACTIVE", getResult.lastUpdatedBy());
    assertEquals("ACTIVE", getResult.name());
    assertEquals("ACTIVE", getResult.provenance());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(1L, getResult.categoryId());
    assertEquals(EntityKind.MEASURABLE, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(getResult.concrete());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test:
   * {@link MeasurableDao#findExternalIdToIdMapByCategoryId(Long)}
   */
  @Test
  void testFindExternalIdToIdMapByCategoryId() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(0L);
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
    Map<String, Long> actualFindExternalIdToIdMapByCategoryIdResult = (new MeasurableDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findExternalIdToIdMapByCategoryId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"external_id\", \"measurable\".\"id\" from \"measurable\" where (\"measurable\".\"measurable_category_id\" = ? and \"measurable\".\"external_id\" is not null)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(eq(2));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindExternalIdToIdMapByCategoryIdResult.size());
    assertNull(actualFindExternalIdToIdMapByCategoryIdResult.get("String"));
  }

  /**
   * Method under test: {@link MeasurableDao#findByOrgUnitId(Long)}
   */
  @Test
  void testFindByOrgUnitId() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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
    Collection<Measurable> actualFindByOrgUnitIdResult = (new MeasurableDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByOrgUnitId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\" from \"measurable\" where \"measurable\".\"organisational_unit_id\" in (select \"entity_hierarchy\".\"id\" from \"entity_hierarchy\" where (\"entity_hierarchy\".\"ancestor_id\" in (?) and \"entity_hierarchy\".\"kind\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("ORG_UNIT"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getInt(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertTrue(actualFindByOrgUnitIdResult instanceof List);
    assertEquals(2, actualFindByOrgUnitIdResult.size());
    Measurable getResult = ((List<Measurable>) actualFindByOrgUnitIdResult).get(0);
    assertTrue(getResult instanceof ImmutableMeasurable);
    Measurable getResult2 = ((List<Measurable>) actualFindByOrgUnitIdResult).get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurable);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.lastUpdatedBy());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.provenance());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(1L, getResult.categoryId());
    assertEquals(EntityKind.MEASURABLE, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(getResult.concrete());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link MeasurableDao#findByOrgUnitId(Long)}
   */
  @Test
  void testFindByOrgUnitId2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("ACTIVE");
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
    Collection<Measurable> actualFindByOrgUnitIdResult = (new MeasurableDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByOrgUnitId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\" from \"measurable\" where \"measurable\".\"organisational_unit_id\" in (select \"entity_hierarchy\".\"id\" from \"entity_hierarchy\" where (\"entity_hierarchy\".\"ancestor_id\" in (?) and \"entity_hierarchy\".\"kind\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("ORG_UNIT"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getInt(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertTrue(actualFindByOrgUnitIdResult instanceof List);
    assertEquals(2, actualFindByOrgUnitIdResult.size());
    Measurable getResult = ((List<Measurable>) actualFindByOrgUnitIdResult).get(0);
    assertTrue(getResult instanceof ImmutableMeasurable);
    Measurable getResult2 = ((List<Measurable>) actualFindByOrgUnitIdResult).get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurable);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00:00.010", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1970-01-01", lastUpdatedAtResult.toLocalDate().toString());
    assertEquals("ACTIVE", getResult.description());
    assertEquals("ACTIVE", getResult.lastUpdatedBy());
    assertEquals("ACTIVE", getResult.name());
    assertEquals("ACTIVE", getResult.provenance());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.organisationalUnitId().longValue());
    assertEquals(1L, getResult.categoryId());
    assertEquals(EntityKind.MEASURABLE, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(getResult.concrete());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link MeasurableDao#reorder(long, List, String)}
   */
  @Test
  void testReorder() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    MeasurableDao measurableDao = new MeasurableDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualReorderResult = measurableDao.reorder(1L, new ArrayList<>(), "42");

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(0, actualReorderResult);
  }

  /**
   * Method under test: {@link MeasurableDao#reorder(long, List, String)}
   */
  @Test
  void testReorder2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    // Act
    int actualReorderResult = measurableDao.reorder(1L, new ArrayList<>(), "42");

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    assertEquals(0, actualReorderResult);
  }

  /**
   * Method under test: {@link MeasurableDao#reorder(long, List, String)}
   */
  @Test
  void testReorder3() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.and(Mockito.<Condition>any())).thenReturn(mock(UpdateConditionStep.class));
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    int actualReorderResult = measurableDao.reorder(1L, ids, "42");

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    verify(dsl).update(isA(Table.class));
    verify(updateConditionStep).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(0, actualReorderResult);
  }

  /**
   * Method under test: {@link MeasurableDao#reorder(long, List, String)}
   */
  @Test
  void testReorder4() {
    // Arrange
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.and(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException("foo"));
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableDao.reorder(1L, ids, "42"));
    verify(dsl).update(isA(Table.class));
    verify(updateConditionStep).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
  }

  /**
   * Method under test: {@link MeasurableDao#reorder(long, List, String)}
   */
  @Test
  void testReorder5() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    UpdateConditionStep<MeasurableRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.and(Mockito.<Condition>any())).thenReturn(mock(UpdateConditionStep.class));
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep);
    UpdateSetMoreStep<MeasurableRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep2);
    UpdateSetFirstStep<MeasurableRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any())).thenReturn(updateSetMoreStep3);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<MeasurableRecord>>any())).thenReturn(updateSetFirstStep);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    MeasurableDao measurableDao = new MeasurableDao(dsl);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    int actualReorderResult = measurableDao.reorder(1L, ids, "42");

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    verify(dsl, atLeast(1)).update(isA(Table.class));
    verify(updateConditionStep, atLeast(1)).and(Mockito.<Condition>any());
    verify(updateSetFirstStep, atLeast(1)).set(isA(Field.class), Mockito.<Object>any());
    verify(updateSetMoreStep3, atLeast(1)).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2, atLeast(1)).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep, atLeast(1)).where(isA(Condition.class));
    assertEquals(0, actualReorderResult);
  }

  /**
   * Method under test: {@link MeasurableDao#findHierarchyForCategory(long)}
   */
  @Test
  void testFindHierarchyForCategory() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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
    Set<MeasurableHierarchy> actualFindHierarchyForCategoryResult = (new MeasurableDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findHierarchyForCategory(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"parent\".\"id\", \"parent\".\"name\", \"entity_hierarchy\".\"level\" from \"measurable\" join \"entity_hierarchy\" on (\"measurable\".\"id\" = \"entity_hierarchy\".\"id\" and \"entity_hierarchy\".\"kind\" = ?) join \"measurable\" \"parent\" on \"entity_hierarchy\".\"ancestor_id\" = \"parent\".\"id\" where \"measurable\".\"measurable_category_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("MEASURABLE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(4));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindHierarchyForCategoryResult.size());
  }

  /**
   * Method under test: {@link MeasurableDao#findHierarchyForCategory(long)}
   */
  @Test
  void testFindHierarchyForCategory2() throws SQLException {
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
    Set<MeasurableHierarchy> actualFindHierarchyForCategoryResult = (new MeasurableDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findHierarchyForCategory(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"parent\".\"id\", \"parent\".\"name\", \"entity_hierarchy\".\"level\" from \"measurable\" join \"entity_hierarchy\" on (\"measurable\".\"id\" = \"entity_hierarchy\".\"id\" and \"entity_hierarchy\".\"kind\" = ?) join \"measurable\" \"parent\" on \"entity_hierarchy\".\"ancestor_id\" = \"parent\".\"id\" where \"measurable\".\"measurable_category_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("MEASURABLE"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindHierarchyForCategoryResult.isEmpty());
  }

  /**
   * Method under test: {@link MeasurableDao#findHierarchyForCategory(long)}
   */
  @Test
  void testFindHierarchyForCategory3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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
    Set<MeasurableHierarchy> actualFindHierarchyForCategoryResult = (new MeasurableDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findHierarchyForCategory(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"parent\".\"id\", \"parent\".\"name\", \"entity_hierarchy\".\"level\" from \"measurable\" join \"entity_hierarchy\" on (\"measurable\".\"id\" = \"entity_hierarchy\".\"id\" and \"entity_hierarchy\".\"kind\" = ?) join \"measurable\" \"parent\" on \"entity_hierarchy\".\"ancestor_id\" = \"parent\".\"id\" where \"measurable\".\"measurable_category_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("MEASURABLE"));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(4));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet).getString(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindHierarchyForCategoryResult.size());
  }
}
