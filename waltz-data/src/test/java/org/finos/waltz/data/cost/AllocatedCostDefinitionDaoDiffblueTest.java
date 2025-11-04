package org.finos.waltz.data.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
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
import java.util.Set;
import org.finos.waltz.model.cost.AllocatedCostDefinition;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AllocatedCostDefinitionDaoDiffblueTest {
  /**
   * Method under test: {@link AllocatedCostDefinitionDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<AllocatedCostDefinition> actualFindAllResult = (new AllocatedCostDefinitionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"acd\".\"id\", \"acd\".\"allocation_scheme_id\", \"acd\".\"source_cost_kind_id\", \"acd\".\"target_cost_kind_id\", \"allocScheme\".\"name\", \"srcCostKind\".\"name\", \"trgCostKind\".\"name\" from \"allocated_cost_definition\" \"acd\" join \"allocation_scheme\" \"allocScheme\" on \"acd\".\"allocation_scheme_id\" = \"allocScheme\".\"id\" join \"cost_kind\" \"srcCostKind\" on \"acd\".\"source_cost_kind_id\" = \"srcCostKind\".\"id\" join \"cost_kind\" \"trgCostKind\" on \"acd\".\"target_cost_kind_id\" = \"trgCostKind\".\"id\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindAllResult.size());
  }
}
