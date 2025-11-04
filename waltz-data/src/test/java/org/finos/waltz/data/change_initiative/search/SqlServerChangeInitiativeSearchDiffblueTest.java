package org.finos.waltz.data.change_initiative.search;

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
import org.finos.waltz.model.change_initiative.ChangeInitiative;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SqlServerChangeInitiativeSearchDiffblueTest {
  /**
   * Method under test:
   * {@link SqlServerChangeInitiativeSearch#searchFullText(DSLContext, EntitySearchOptions)}
   */
  @Test
  void testSearchFullText() throws SQLException {
    // Arrange
    SqlServerChangeInitiativeSearch sqlServerChangeInitiativeSearch = new SqlServerChangeInitiativeSearch();
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
    List<ChangeInitiative> actualSearchFullTextResult = sqlServerChangeInitiativeSearch.searchFullText(dsl, options);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"change_initiative\".\"id\", \"change_initiative\".\"parent_id\", \"change_initiative\".\"external_id\", \"change_initiative\".\"name\", \"change_initiative\".\"kind\", \"change_initiative\".\"lifecycle_phase\", \"change_initiative\".\"description\", \"change_initiative\".\"last_update\", \"change_initiative\".\"start_date\", \"change_initiative\".\"end_date\", \"change_initiative\".\"provenance\", \"change_initiative\".\"organisational_unit_id\" from \"change_initiative\" where (CONTAINS(*, '\"Search*\" AND \"Query*\"')) limit ?"));
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
