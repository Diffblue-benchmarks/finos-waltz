package org.finos.waltz.data.measurable_category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategory;
import org.finos.waltz.model.measurable_category.MeasurableCategory;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableCategoryDaoDiffblueTest {
  /**
   * Method under test: {@link MeasurableCategoryDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(timestamp.toLocalDateTime()).thenReturn(ofResult.atStartOfDay());
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
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Collection<MeasurableCategory> actualFindAllResult = (new MeasurableCategoryDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_category\".\"id\", \"measurable_category\".\"name\", \"measurable_category\".\"description\", \"measurable_category\".\"external_id\", \"measurable_category\".\"last_updated_at\", \"measurable_category\".\"last_updated_by\", \"measurable_category\".\"rating_scheme_id\", \"measurable_category\".\"editable\", \"measurable_category\".\"rating_editor_role\", \"measurable_category\".\"constraining_assessment_definition_id\", \"measurable_category\".\"position\", \"measurable_category\".\"icon_name\", \"measurable_category\".\"allow_primary_ratings\", \"measurable_category\".\"is_deprecated\" from \"measurable_category\" where \"measurable_category\".\"is_deprecated\" = ? order by \"measurable_category\".\"name\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(false));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getInt(eq(11));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(5));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertTrue(actualFindAllResult instanceof List);
    assertEquals(2, actualFindAllResult.size());
    MeasurableCategory getResult = ((List<MeasurableCategory>) actualFindAllResult).get(0);
    assertTrue(getResult instanceof ImmutableMeasurableCategory);
    MeasurableCategory getResult2 = ((List<MeasurableCategory>) actualFindAllResult).get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurableCategory);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.icon());
    assertEquals("String", getResult.lastUpdatedBy());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.ratingEditorRole());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.ratingSchemeId());
    assertEquals(EntityKind.MEASURABLE_CATEGORY, getResult.kind());
    assertTrue(getResult.allowPrimaryRatings());
    assertTrue(getResult.editable());
    assertTrue(getResult.isDeprecated());
    assertEquals(getResult, getResult2);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link MeasurableCategoryDao#getById(long)}
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
    MeasurableCategory actualById = (new MeasurableCategoryDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_category\".\"id\", \"measurable_category\".\"name\", \"measurable_category\".\"description\", \"measurable_category\".\"external_id\", \"measurable_category\".\"last_updated_at\", \"measurable_category\".\"last_updated_by\", \"measurable_category\".\"rating_scheme_id\", \"measurable_category\".\"editable\", \"measurable_category\".\"rating_editor_role\", \"measurable_category\".\"constraining_assessment_definition_id\", \"measurable_category\".\"position\", \"measurable_category\".\"icon_name\", \"measurable_category\".\"allow_primary_ratings\", \"measurable_category\".\"is_deprecated\" from \"measurable_category\" where \"measurable_category\".\"id\" = ?"));
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
   * Method under test: {@link MeasurableCategoryDao#getById(long)}
   */
  @Test
  void testGetById2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(timestamp.toLocalDateTime()).thenReturn(ofResult.atStartOfDay());
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
    MeasurableCategory actualById = (new MeasurableCategoryDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_category\".\"id\", \"measurable_category\".\"name\", \"measurable_category\".\"description\", \"measurable_category\".\"external_id\", \"measurable_category\".\"last_updated_at\", \"measurable_category\".\"last_updated_by\", \"measurable_category\".\"rating_scheme_id\", \"measurable_category\".\"editable\", \"measurable_category\".\"rating_editor_role\", \"measurable_category\".\"constraining_assessment_definition_id\", \"measurable_category\".\"position\", \"measurable_category\".\"icon_name\", \"measurable_category\".\"allow_primary_ratings\", \"measurable_category\".\"is_deprecated\" from \"measurable_category\" where \"measurable_category\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet).getInt(eq(11));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(5));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp).toLocalDateTime();
    assertTrue(actualById instanceof ImmutableMeasurableCategory);
    LocalDateTime lastUpdatedAtResult = actualById.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("String", actualById.description());
    assertEquals("String", actualById.icon());
    assertEquals("String", actualById.lastUpdatedBy());
    assertEquals("String", actualById.name());
    assertEquals("String", actualById.ratingEditorRole());
    assertEquals(1, actualById.position());
    assertEquals(1L, actualById.ratingSchemeId());
    assertEquals(EntityKind.MEASURABLE_CATEGORY, actualById.kind());
    assertTrue(actualById.allowPrimaryRatings());
    assertTrue(actualById.editable());
    assertTrue(actualById.isDeprecated());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link MeasurableCategoryDao#findByExternalId(String)}
   */
  @Test
  void testFindByExternalId() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
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
    Set<MeasurableCategory> actualFindByExternalIdResult = (new MeasurableCategoryDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_category\".\"id\", \"measurable_category\".\"name\", \"measurable_category\".\"description\", \"measurable_category\".\"external_id\", \"measurable_category\".\"last_updated_at\", \"measurable_category\".\"last_updated_by\", \"measurable_category\".\"rating_scheme_id\", \"measurable_category\".\"editable\", \"measurable_category\".\"rating_editor_role\", \"measurable_category\".\"constraining_assessment_definition_id\", \"measurable_category\".\"position\", \"measurable_category\".\"icon_name\", \"measurable_category\".\"allow_primary_ratings\", \"measurable_category\".\"is_deprecated\" from \"measurable_category\" where \"measurable_category\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getInt(eq(11));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(5));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertEquals(1, actualFindByExternalIdResult.size());
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryDao#findCategoriesByDirectOrgUnit(long)}
   */
  @Test
  void testFindCategoriesByDirectOrgUnit() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(timestamp.toLocalDateTime()).thenReturn(ofResult.atStartOfDay());
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
    Collection<MeasurableCategory> actualFindCategoriesByDirectOrgUnitResult = (new MeasurableCategoryDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findCategoriesByDirectOrgUnit(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable_category\".\"id\", \"measurable_category\".\"name\", \"measurable_category\".\"description\", \"measurable_category\".\"external_id\", \"measurable_category\".\"last_updated_at\", \"measurable_category\".\"last_updated_by\", \"measurable_category\".\"rating_scheme_id\", \"measurable_category\".\"editable\", \"measurable_category\".\"rating_editor_role\", \"measurable_category\".\"constraining_assessment_definition_id\", \"measurable_category\".\"position\", \"measurable_category\".\"icon_name\", \"measurable_category\".\"allow_primary_ratings\", \"measurable_category\".\"is_deprecated\" from \"measurable_category\" where \"measurable_category\".\"id\" in (select distinct \"measurable\".\"measurable_category_id\" from \"measurable\" join \"organisational_unit\" on \"measurable\".\"organisational_unit_id\" = \"organisational_unit\".\"id\" join \"entity_hierarchy\" on \"organisational_unit\".\"id\" = \"entity_hierarchy\".\"id\" where (\"entity_hierarchy\".\"ancestor_id\" = ? and \"entity_hierarchy\".\"kind\" = ? and \"measurable\".\"entity_lifecycle_status\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(anyInt());
    verify(resultSet, atLeast(1)).getInt(eq(11));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(5));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    assertTrue(actualFindCategoriesByDirectOrgUnitResult instanceof List);
    assertEquals(2, actualFindCategoriesByDirectOrgUnitResult.size());
    MeasurableCategory getResult = ((List<MeasurableCategory>) actualFindCategoriesByDirectOrgUnitResult).get(0);
    assertTrue(getResult instanceof ImmutableMeasurableCategory);
    MeasurableCategory getResult2 = ((List<MeasurableCategory>) actualFindCategoriesByDirectOrgUnitResult).get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurableCategory);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.icon());
    assertEquals("String", getResult.lastUpdatedBy());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.ratingEditorRole());
    assertEquals(1, getResult.position());
    assertEquals(1L, getResult.ratingSchemeId());
    assertEquals(EntityKind.MEASURABLE_CATEGORY, getResult.kind());
    assertTrue(getResult.allowPrimaryRatings());
    assertTrue(getResult.editable());
    assertTrue(getResult.isDeprecated());
    assertEquals(getResult, getResult2);
    assertSame(ofResult, toLocalDateResult);
  }
}
