package org.finos.waltz.data.server_information.search;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
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
import java.util.List;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.server_information.ServerInformation;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SqlServerServerInformationSearchDiffblueTest {
  /**
   * Method under test:
   * {@link SqlServerServerInformationSearch#searchFullText(DSLContext, EntitySearchOptions)}
   */
  @Test
  void testSearchFullText() throws SQLException {
    // Arrange
    SqlServerServerInformationSearch sqlServerServerInformationSearch = new SqlServerServerInformationSearch();
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<ServerInformation> actualSearchFullTextResult = sqlServerServerInformationSearch.searchFullText(dsl, options);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"server_information\".\"id\", \"server_information\".\"hostname\", \"server_information\".\"operating_system\", \"server_information\".\"location\", \"server_information\".\"operating_system_version\", \"server_information\".\"country\", \"server_information\".\"is_virtual\", \"server_information\".\"provenance\", \"server_information\".\"os_end_of_life_date\", \"server_information\".\"hw_end_of_life_date\", \"server_information\".\"lifecycle_status\", \"server_information\".\"external_id\" from \"server_information\" where (CONTAINS(*, '\"Search*\" AND \"Query*\"')) limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
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
