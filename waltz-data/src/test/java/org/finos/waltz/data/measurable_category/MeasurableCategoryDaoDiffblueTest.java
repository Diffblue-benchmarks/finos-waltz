package org.finos.waltz.data.measurable_category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategory;
import org.finos.waltz.model.measurable_category.MeasurableCategory;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableCategoryDaoDiffblueTest {
  /**
   * Test {@link MeasurableCategoryDao#getById(long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurableCategoryDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurableCategory MeasurableCategoryDao.getById(long)"})
  void testGetById_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
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
   * Test {@link MeasurableCategoryDao#getById(long)}.
   * <ul>
   *   <li>Then {@link MeasurableCategoryDao#MeasurableCategoryDao(DSLContext)} with dsl is {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} findAll {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurableCategoryDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then MeasurableCategoryDao(DSLContext) with dsl is DefaultDSLContext(Connection, SQLDialect) findAll List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurableCategory MeasurableCategoryDao.getById(long)"})
  void testGetById_thenMeasurableCategoryDaoWithDslIsDefaultDSLContextFindAllList() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
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
    MeasurableCategoryDao measurableCategoryDao = new MeasurableCategoryDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    MeasurableCategory actualById = measurableCategoryDao.getById(1L);

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
    Collection<MeasurableCategory> findAllResult = measurableCategoryDao.findAll();
    assertTrue(findAllResult instanceof List);
    assertTrue(actualById instanceof ImmutableMeasurableCategory);
    assertEquals("String", actualById.description());
    assertEquals("String", actualById.icon());
    assertEquals("String", actualById.lastUpdatedBy());
    assertEquals("String", actualById.name());
    assertEquals("String", actualById.ratingEditorRole());
    assertEquals(1, actualById.position());
    assertEquals(1L, actualById.ratingSchemeId());
    assertEquals(EntityKind.MEASURABLE_CATEGORY, actualById.kind());
    assertTrue(findAllResult.isEmpty());
    assertTrue(actualById.allowPrimaryRatings());
    assertTrue(actualById.editable());
    assertTrue(actualById.isDeprecated());
  }
}
