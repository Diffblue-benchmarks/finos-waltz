package org.finos.waltz.data.measurable.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyDouble;
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
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable.Measurable;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PostgresMeasurableSearchDiffblueTest {
  /**
   * Test {@link PostgresMeasurableSearch#searchFullText(DSLContext, EntitySearchOptions)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBoolean(int)} return {@code true}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PostgresMeasurableSearch#searchFullText(DSLContext, EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test searchFullText(DSLContext, EntitySearchOptions); given ResultSet getBoolean(int) return 'true'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PostgresMeasurableSearch.searchFullText(DSLContext, EntitySearchOptions)"})
  void testSearchFullText_givenResultSetGetBooleanReturnTrue_thenReturnSizeIsTwo() throws SQLException {
    // Arrange
    PostgresMeasurableSearch postgresMeasurableSearch = new PostgresMeasurableSearch();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getDouble(anyInt())).thenReturn(10.0d);
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
    doNothing().when(preparedStatement).setDouble(anyInt(), anyDouble());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");
    when(options.entityLifecycleStatuses()).thenReturn(new ArrayList<>());

    // Act
    List<Measurable> actualSearchFullTextResult = postgresMeasurableSearch.searchFullText(dsl, options);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\", ts_rank_cd(to_tsvector(lower(\"measurable\".\"description\")), plainto_tsquery('search query')) from \"measurable\" where (ts_rank_cd(to_tsvector(lower(\"measurable\".\"description\")), plainto_tsquery('search query')) > ? and \"measurable\".\"entity_lifecycle_status\" in ()) order by ts_rank_cd(to_tsvector(lower(\"measurable\".\"description\")), plainto_tsquery('search query')) desc limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setDouble(eq(1), eq(4.9E-324d));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getDouble(eq(15));
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
    verify(options).entityLifecycleStatuses();
    verify(options).limit();
    verify(options).searchQuery();
    assertEquals(2, actualSearchFullTextResult.size());
    Measurable getResult = actualSearchFullTextResult.get(0);
    assertTrue(getResult instanceof ImmutableMeasurable);
    Measurable getResult2 = actualSearchFullTextResult.get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurable);
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
   * Test {@link PostgresMeasurableSearch#searchFullText(DSLContext, EntitySearchOptions)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getDouble(int)} return {@link Double#MIN_VALUE}.</li>
   *   <li>Then calls {@link ResultSet#wasNull()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PostgresMeasurableSearch#searchFullText(DSLContext, EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test searchFullText(DSLContext, EntitySearchOptions); given ResultSet getDouble(int) return MIN_VALUE; then calls wasNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PostgresMeasurableSearch.searchFullText(DSLContext, EntitySearchOptions)"})
  void testSearchFullText_givenResultSetGetDoubleReturnMin_value_thenCallsWasNull() throws SQLException {
    // Arrange
    PostgresMeasurableSearch postgresMeasurableSearch = new PostgresMeasurableSearch();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getDouble(anyInt())).thenReturn(Double.MIN_VALUE);
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
    doNothing().when(preparedStatement).setDouble(anyInt(), anyDouble());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");
    when(options.entityLifecycleStatuses()).thenReturn(new ArrayList<>());

    // Act
    List<Measurable> actualSearchFullTextResult = postgresMeasurableSearch.searchFullText(dsl, options);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\", ts_rank_cd(to_tsvector(lower(\"measurable\".\"description\")), plainto_tsquery('search query')) from \"measurable\" where (ts_rank_cd(to_tsvector(lower(\"measurable\".\"description\")), plainto_tsquery('search query')) > ? and \"measurable\".\"entity_lifecycle_status\" in ()) order by ts_rank_cd(to_tsvector(lower(\"measurable\".\"description\")), plainto_tsquery('search query')) desc limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setDouble(eq(1), eq(4.9E-324d));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getDouble(eq(15));
    verify(resultSet, atLeast(1)).getInt(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    verify(options).entityLifecycleStatuses();
    verify(options).limit();
    verify(options).searchQuery();
    assertEquals(2, actualSearchFullTextResult.size());
    Measurable getResult = actualSearchFullTextResult.get(0);
    assertTrue(getResult instanceof ImmutableMeasurable);
    Measurable getResult2 = actualSearchFullTextResult.get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurable);
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
}
