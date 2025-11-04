package org.finos.waltz.data.cost;

import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.cost.CostKindWithYears;
import org.finos.waltz.model.cost.EntityCostKind;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CostKindDaoDiffblueTest {
  /**
   * Method under test: {@link CostKindDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
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
    Set<CostKindWithYears> actualFindAllResult = (new CostKindDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"cost_kind\".\"id\", \"cost_kind\".\"name\", \"cost_kind\".\"description\", \"cost_kind\".\"is_default\", \"cost_kind\".\"external_id\", \"cost_kind\".\"subject_kind\", \"cost\".\"year\" from \"cost_kind\" left outer join \"cost\" on \"cost_kind\".\"id\" = \"cost\".\"cost_kind_id\" where 1 = 1 order by \"cost\".\"year\" desc"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Method under test: {@link CostKindDao#findCostKindsBySubjectKind(EntityKind)}
   */
  @Test
  void testFindCostKindsBySubjectKind() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
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
    Set<CostKindWithYears> actualFindCostKindsBySubjectKindResult = (new CostKindDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findCostKindsBySubjectKind(EntityKind.ALL);

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"cost_kind\".\"id\", \"cost_kind\".\"name\", \"cost_kind\".\"description\", \"cost_kind\".\"is_default\", \"cost_kind\".\"external_id\", \"cost_kind\".\"subject_kind\", \"cost\".\"year\" from \"cost_kind\" left outer join \"cost\" on \"cost_kind\".\"id\" = \"cost\".\"cost_kind_id\" where \"cost_kind\".\"subject_kind\" = ? order by \"cost\".\"year\" desc"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("ALL"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindCostKindsBySubjectKindResult.isEmpty());
  }

  /**
   * Method under test: {@link CostKindDao#getById(Long)}
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
    EntityCostKind actualById = (new CostKindDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"cost_kind\".\"id\", \"cost_kind\".\"name\", \"cost_kind\".\"description\", \"cost_kind\".\"is_default\", \"cost_kind\".\"external_id\", \"cost_kind\".\"subject_kind\" from \"cost_kind\" where \"cost_kind\".\"id\" = ?"));
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
}
