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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MariaMeasurableSearchDiffblueTest {
  /**
   * Method under test:
   * {@link MariaMeasurableSearch#searchFullText(DSLContext, EntitySearchOptions)}
   */
  @Test
  void testSearchFullText() throws SQLException {
    // Arrange
    MariaMeasurableSearch mariaMeasurableSearch = new MariaMeasurableSearch();
    ResultSetMetaData resultSetMetaData = mock(ResultSetMetaData.class);
    when(resultSetMetaData.getPrecision(anyInt())).thenReturn(1);
    when(resultSetMetaData.getScale(anyInt())).thenReturn(1);
    when(resultSetMetaData.getColumnTypeName(anyInt())).thenReturn("Column Type Name");
    when(resultSetMetaData.getColumnLabel(anyInt())).thenReturn("Column Label");
    when(resultSetMetaData.getColumnName(anyInt())).thenReturn("Column Name");
    when(resultSetMetaData.getColumnCount()).thenReturn(3);
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(resultSetMetaData);
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.entityLifecycleStatuses()).thenReturn(new ArrayList<>());
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<Measurable> actualSearchFullTextResult = mariaMeasurableSearch.searchFullText(dsl, options);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement).setInt(eq(2), eq(1));
    verify(preparedStatement, atLeast(1)).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(4));
    verify(resultSet, atLeast(1)).getInt(eq(14));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(7));
    verify(resultSet, atLeast(1)).next();
    verify(resultSetMetaData).getColumnCount();
    verify(resultSetMetaData, atLeast(1)).getColumnLabel(anyInt());
    verify(resultSetMetaData, atLeast(1)).getColumnName(anyInt());
    verify(resultSetMetaData, atLeast(1)).getColumnTypeName(anyInt());
    verify(resultSetMetaData, atLeast(1)).getPrecision(anyInt());
    verify(resultSetMetaData, atLeast(1)).getScale(anyInt());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).limit();
    verify(options, atLeast(1)).searchQuery();
    assertEquals(1, actualSearchFullTextResult.size());
    Measurable getResult = actualSearchFullTextResult.get(0);
    assertTrue(getResult instanceof ImmutableMeasurable);
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
  }
}
