package org.finos.waltz.data.aggregate_overlay_diagram;

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
import java.util.Set;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.BackingEntityWidgetDatum;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BackingEntityWidgetDaoDiffblueTest {
  /**
   * Method under test: {@link BackingEntityWidgetDao#findWidgetData(long)}
   */
  @Test
  void testFindWidgetData() throws SQLException {
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Set<BackingEntityWidgetDatum> actualFindWidgetDataResult = (new BackingEntityWidgetDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findWidgetData(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"aggregate_overlay_diagram_cell_data\".\"cell_external_id\", \"aggregate_overlay_diagram_cell_data\".\"related_entity_kind\", \"aggregate_overlay_diagram_cell_data\".\"related_entity_id\", case when \"aggregate_overlay_diagram_cell_data\".\"related_entity_kind\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"aggregate_overlay_diagram_cell_data\".\"related_entity_id\") when \"aggregate_overlay_diagram_cell_data\".\"related_entity_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"aggregate_overlay_diagram_cell_data\".\"related_entity_id\") when \"aggregate_overlay_diagram_cell_data\".\"related_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"aggregate_overlay_diagram_cell_data\".\"related_entity_id\") when \"aggregate_overlay_diagram_cell_data\".\"related_entity_kind\" = ? then (select \"person\".\"display_name\" from \"person\" where \"person\".\"id\" = \"aggregate_overlay_diagram_cell_data\".\"related_entity_id\") end \"entity_name\" from \"aggregate_overlay_diagram_cell_data\" where \"aggregate_overlay_diagram_cell_data\".\"diagram_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(5), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindWidgetDataResult.isEmpty());
  }
}
