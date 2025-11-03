package org.finos.waltz.data.server_information.search;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
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
import java.util.List;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.server_information.ServerInformation;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PostgresServerInformationSearchDiffblueTest {
  /**
   * Test {@link PostgresServerInformationSearch#searchFullText(DSLContext, EntitySearchOptions)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PostgresServerInformationSearch#searchFullText(DSLContext, EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test searchFullText(DSLContext, EntitySearchOptions); given ResultSet next() return 'false'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PostgresServerInformationSearch.searchFullText(DSLContext, EntitySearchOptions)"})
  void testSearchFullText_givenResultSetNextReturnFalse_thenReturnEmpty() throws SQLException {
    // Arrange
    PostgresServerInformationSearch postgresServerInformationSearch = new PostgresServerInformationSearch();
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
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

    // Act
    List<ServerInformation> actualSearchFullTextResult = postgresServerInformationSearch.searchFullText(dsl, options);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"server_information\".\"id\", \"server_information\".\"hostname\", \"server_information\".\"operating_system\", \"server_information\".\"location\", \"server_information\".\"operating_system_version\", \"server_information\".\"country\", \"server_information\".\"is_virtual\", \"server_information\".\"provenance\", \"server_information\".\"os_end_of_life_date\", \"server_information\".\"hw_end_of_life_date\", \"server_information\".\"lifecycle_status\", \"server_information\".\"external_id\", ts_rank_cd(to_tsvector(lower(\"server_information\".\"operating_system\") || ' ' || lower(\"server_information\".\"location\")), plainto_tsquery('search query')) from \"server_information\" where ts_rank_cd(to_tsvector(lower(\"server_information\".\"operating_system\") || ' ' || lower(\"server_information\".\"location\")), plainto_tsquery('search query')) > ? order by ts_rank_cd(to_tsvector(lower(\"server_information\".\"operating_system\") || ' ' || lower(\"server_information\".\"location\")), plainto_tsquery('search query')) desc limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setDouble(eq(1), eq(4.9E-324d));
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(options).limit();
    verify(options).searchQuery();
    assertTrue(actualSearchFullTextResult.isEmpty());
  }
}
