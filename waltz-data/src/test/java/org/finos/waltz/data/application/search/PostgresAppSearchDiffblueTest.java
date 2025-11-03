package org.finos.waltz.data.application.search;

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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PostgresAppSearchDiffblueTest {
  /**
   * Test {@link PostgresAppSearch#searchFullText(DSLContext, EntitySearchOptions)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getBoolean(int)} return {@code true}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PostgresAppSearch#searchFullText(DSLContext, EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test searchFullText(DSLContext, EntitySearchOptions); given ResultSet getBoolean(int) return 'true'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PostgresAppSearch.searchFullText(DSLContext, EntitySearchOptions)"})
  void testSearchFullText_givenResultSetGetBooleanReturnTrue_thenReturnSizeIsTwo() throws SQLException {
    // Arrange
    PostgresAppSearch postgresAppSearch = new PostgresAppSearch();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getDouble(anyInt())).thenReturn(10.0d);
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
    when(options.entityLifecycleStatuses()).thenReturn(new ArrayList<>());
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<Application> actualSearchFullTextResult = postgresAppSearch.searchFullText(dsl, options);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\", ts_rank_cd(to_tsvector(lower(\"application\".\"description\") || ' ' || coalesce(lower(\"application\".\"parent_asset_code\"), '')), plainto_tsquery('search query')) from \"application\" where (ts_rank_cd(to_tsvector(lower(\"application\".\"description\") || ' ' || coalesce(lower(\"application\".\"parent_asset_code\"), '')), plainto_tsquery('search query')) > ? and \"application\".\"entity_lifecycle_status\" in ()) order by ts_rank_cd(to_tsvector(lower(\"application\".\"description\") || ' ' || coalesce(lower(\"application\".\"parent_asset_code\"), '')), plainto_tsquery('search query')) desc limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setDouble(eq(1), eq(4.9E-324d));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(14));
    verify(resultSet, atLeast(1)).getDouble(eq(19));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    verify(options).entityLifecycleStatuses();
    verify(options).limit();
    verify(options).searchQuery();
    assertEquals(2, actualSearchFullTextResult.size());
    Application getResult = actualSearchFullTextResult.get(0);
    assertTrue(getResult instanceof ImmutableApplication);
    Application getResult2 = actualSearchFullTextResult.get(1);
    assertTrue(getResult2 instanceof ImmutableApplication);
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link PostgresAppSearch#searchFullText(DSLContext, EntitySearchOptions)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getDouble(int)} return {@link Double#MIN_VALUE}.</li>
   *   <li>Then calls {@link ResultSet#wasNull()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PostgresAppSearch#searchFullText(DSLContext, EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test searchFullText(DSLContext, EntitySearchOptions); given ResultSet getDouble(int) return MIN_VALUE; then calls wasNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PostgresAppSearch.searchFullText(DSLContext, EntitySearchOptions)"})
  void testSearchFullText_givenResultSetGetDoubleReturnMin_value_thenCallsWasNull() throws SQLException {
    // Arrange
    PostgresAppSearch postgresAppSearch = new PostgresAppSearch();
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getDouble(anyInt())).thenReturn(Double.MIN_VALUE);
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
    when(options.entityLifecycleStatuses()).thenReturn(new ArrayList<>());
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<Application> actualSearchFullTextResult = postgresAppSearch.searchFullText(dsl, options);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"id\", \"application\".\"name\", \"application\".\"description\", \"application\".\"asset_code\", \"application\".\"created_at\", \"application\".\"updated_at\", \"application\".\"organisational_unit_id\", \"application\".\"kind\", \"application\".\"lifecycle_phase\", \"application\".\"parent_asset_code\", \"application\".\"overall_rating\", \"application\".\"provenance\", \"application\".\"business_criticality\", \"application\".\"is_removed\", \"application\".\"entity_lifecycle_status\", \"application\".\"planned_retirement_date\", \"application\".\"actual_retirement_date\", \"application\".\"commission_date\", ts_rank_cd(to_tsvector(lower(\"application\".\"description\") || ' ' || coalesce(lower(\"application\".\"parent_asset_code\"), '')), plainto_tsquery('search query')) from \"application\" where (ts_rank_cd(to_tsvector(lower(\"application\".\"description\") || ' ' || coalesce(lower(\"application\".\"parent_asset_code\"), '')), plainto_tsquery('search query')) > ? and \"application\".\"entity_lifecycle_status\" in ()) order by ts_rank_cd(to_tsvector(lower(\"application\".\"description\") || ' ' || coalesce(lower(\"application\".\"parent_asset_code\"), '')), plainto_tsquery('search query')) desc limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setDouble(eq(1), eq(4.9E-324d));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(14));
    verify(resultSet, atLeast(1)).getDouble(eq(19));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    verify(options).entityLifecycleStatuses();
    verify(options).limit();
    verify(options).searchQuery();
    assertEquals(2, actualSearchFullTextResult.size());
    Application getResult = actualSearchFullTextResult.get(0);
    assertTrue(getResult instanceof ImmutableApplication);
    Application getResult2 = actualSearchFullTextResult.get(1);
    assertTrue(getResult2 instanceof ImmutableApplication);
    assertEquals(getResult, getResult2);
  }
}
