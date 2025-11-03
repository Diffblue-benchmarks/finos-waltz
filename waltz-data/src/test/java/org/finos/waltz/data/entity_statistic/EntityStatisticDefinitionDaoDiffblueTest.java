package org.finos.waltz.data.entity_statistic;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
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
import java.util.List;
import org.finos.waltz.model.entity_statistic.EntityStatisticDefinition;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityStatisticDefinitionDaoDiffblueTest {
  /**
   * Test {@link EntityStatisticDefinitionDao#findRelated(long, boolean)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>When {@code true}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityStatisticDefinitionDao#findRelated(long, boolean)}
   */
  @Test
  @DisplayName("Test findRelated(long, boolean); given ResultSet next() return 'false'; when 'true'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List EntityStatisticDefinitionDao.findRelated(long, boolean)"})
  void testFindRelated_givenResultSetNextReturnFalse_whenTrue_thenReturnEmpty() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<EntityStatisticDefinition> actualFindRelatedResult = (new EntityStatisticDefinitionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findRelated(1L, true);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"esd\".\"name\", \"esd\".\"description\", \"esd\".\"type\", \"esd\".\"category\", \"esd\".\"active\", \"esd\".\"renderer\", \"esd\".\"historic_renderer\", \"esd\".\"provenance\", \"esd\".\"parent_id\", \"esd\".\"id\", \"esd\".\"entity_visibility\", \"esd\".\"rollup_visibility\", \"esd\".\"rollup_kind\", \"esd\".\"external_id\" from \"entity_statistic_definition\" \"esd\" where ((\"esd\".\"parent_id\" = ? or \"esd\".\"id\" = ? or \"esd\".\"id\" = (select \"esd\".\"parent_id\" from \"entity_statistic_definition\" \"esd\" where \"esd\".\"id\" = ?)) and \"esd\".\"active\" = ? and \"esd\".\"rollup_visibility\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindRelatedResult.isEmpty());
  }

  /**
   * Test {@link EntityStatisticDefinitionDao#getById(long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityStatisticDefinitionDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityStatisticDefinition EntityStatisticDefinitionDao.getById(long)"})
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
    EntityStatisticDefinition actualById = (new EntityStatisticDefinitionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"esd\".\"name\", \"esd\".\"description\", \"esd\".\"type\", \"esd\".\"category\", \"esd\".\"active\", \"esd\".\"renderer\", \"esd\".\"historic_renderer\", \"esd\".\"provenance\", \"esd\".\"parent_id\", \"esd\".\"id\", \"esd\".\"entity_visibility\", \"esd\".\"rollup_visibility\", \"esd\".\"rollup_kind\", \"esd\".\"external_id\" from \"entity_statistic_definition\" \"esd\" where \"esd\".\"id\" = ?"));
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
