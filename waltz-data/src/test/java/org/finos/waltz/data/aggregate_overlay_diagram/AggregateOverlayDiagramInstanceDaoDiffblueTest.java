package org.finos.waltz.data.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertNull;
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
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramInstance;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AggregateOverlayDiagramInstanceDaoDiffblueTest {
  /**
   * Test {@link AggregateOverlayDiagramInstanceDao#getById(Long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggregateOverlayDiagramInstanceDao#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AggregateOverlayDiagramInstance AggregateOverlayDiagramInstanceDao.getById(Long)"})
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    AggregateOverlayDiagramInstance actualById = (new AggregateOverlayDiagramInstanceDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"aggregate_overlay_diagram_instance\".\"id\", \"aggregate_overlay_diagram_instance\".\"diagram_id\", \"aggregate_overlay_diagram_instance\".\"name\", \"aggregate_overlay_diagram_instance\".\"description\", \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\", \"aggregate_overlay_diagram_instance\".\"parent_entity_id\", \"aggregate_overlay_diagram_instance\".\"svg\", \"aggregate_overlay_diagram_instance\".\"last_updated_at\", \"aggregate_overlay_diagram_instance\".\"last_updated_by\", \"aggregate_overlay_diagram_instance\".\"provenance\", \"aggregate_overlay_diagram_instance\".\"snapshot_data\", case when \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\" = ? then (select \"organisational_unit\".\"name\" from \"organisational_unit\" where \"organisational_unit\".\"id\" = \"aggregate_overlay_diagram_instance\".\"parent_entity_id\") when \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"aggregate_overlay_diagram_instance\".\"parent_entity_id\") when \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\" = ? then (select \"measurable\".\"name\" from \"measurable\" where \"measurable\".\"id\" = \"aggregate_overlay_diagram_instance\".\"parent_entity_id\") when \"aggregate_overlay_diagram_instance\".\"parent_entity_kind\" = ? then (select \"person\".\"display_name\" from \"person\" where \"person\".\"id\" = \"aggregate_overlay_diagram_instance\".\"parent_entity_id\") end \"entity_name\" from \"aggregate_overlay_diagram_instance\" where \"aggregate_overlay_diagram_instance\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(5), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }
}
