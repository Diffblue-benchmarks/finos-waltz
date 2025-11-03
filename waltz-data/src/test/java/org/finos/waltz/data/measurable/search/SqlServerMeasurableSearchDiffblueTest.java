package org.finos.waltz.data.measurable.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class SqlServerMeasurableSearchDiffblueTest {
  /**
   * Test {@link SqlServerMeasurableSearch#searchFullText(DSLContext, EntitySearchOptions)}.
   * <ul>
   *   <li>Given {@link Timestamp} {@link Timestamp#getTime()} return ten.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlServerMeasurableSearch#searchFullText(DSLContext, EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test searchFullText(DSLContext, EntitySearchOptions); given Timestamp getTime() return ten; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SqlServerMeasurableSearch.searchFullText(DSLContext, EntitySearchOptions)"})
  void testSearchFullText_givenTimestampGetTimeReturnTen_thenReturnSizeIsTwo() throws SQLException {
    // Arrange
    SqlServerMeasurableSearch sqlServerMeasurableSearch = new SqlServerMeasurableSearch();
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.entityLifecycleStatuses()).thenReturn(new ArrayList<>());
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<Measurable> actualSearchFullTextResult = sqlServerMeasurableSearch.searchFullText(dsl, options);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"measurable\".\"id\", \"measurable\".\"parent_id\", \"measurable\".\"name\", \"measurable\".\"concrete\", \"measurable\".\"description\", \"measurable\".\"external_id\", \"measurable\".\"last_updated_at\", \"measurable\".\"last_updated_by\", \"measurable\".\"provenance\", \"measurable\".\"measurable_category_id\", \"measurable\".\"external_parent_id\", \"measurable\".\"entity_lifecycle_status\", \"measurable\".\"organisational_unit_id\", \"measurable\".\"position\" from \"measurable\" where ((CONTAINS(*, '\"search*\" AND \"query*\"')) and \"measurable\".\"entity_lifecycle_status\" in ()) limit ?"));
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
