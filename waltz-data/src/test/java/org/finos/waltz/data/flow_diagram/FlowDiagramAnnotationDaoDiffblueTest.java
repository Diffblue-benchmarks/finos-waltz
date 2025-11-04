package org.finos.waltz.data.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.flow_diagram.FlowDiagramAnnotation;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowDiagramAnnotationDaoDiffblueTest {
  /**
   * Method under test: {@link FlowDiagramAnnotationDao#findByDiagramId(long)}
   */
  @Test
  void testFindByDiagramId() throws SQLException {
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
    List<FlowDiagramAnnotation> actualFindByDiagramIdResult = (new FlowDiagramAnnotationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByDiagramId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"flow_diagram_annotation\".\"annotation_id\", \"flow_diagram_annotation\".\"diagram_id\", \"flow_diagram_annotation\".\"entity_id\", \"flow_diagram_annotation\".\"entity_kind\", \"flow_diagram_annotation\".\"note\" from \"flow_diagram_annotation\" where \"flow_diagram_annotation\".\"diagram_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByDiagramIdResult.isEmpty());
  }

  /**
   * Method under test: {@link FlowDiagramAnnotationDao#createAnnotations(List)}
   */
  @Test
  void testCreateAnnotations() {
    // Arrange
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = new FlowDiagramAnnotationDao(
        new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, flowDiagramAnnotationDao.createAnnotations(new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link FlowDiagramAnnotationDao#createAnnotations(List)}
   */
  @Test
  void testCreateAnnotations2() {
    // Arrange
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = new FlowDiagramAnnotationDao(
        new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, flowDiagramAnnotationDao.createAnnotations(new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link FlowDiagramAnnotationDao#deleteForDiagram(long)}
   */
  @Test
  void testDeleteForDiagram() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteForDiagramResult = (new FlowDiagramAnnotationDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).deleteForDiagram(1L);

    // Assert
    verify(connection).prepareStatement(
        eq("delete from \"flow_diagram_annotation\" where \"flow_diagram_annotation\".\"diagram_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForDiagramResult);
  }

  /**
   * Method under test: {@link FlowDiagramAnnotationDao#clone(long, Long)}
   */
  @Test
  void testClone() throws SQLException {
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
    (new FlowDiagramAnnotationDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).clone(1L, 1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"flow_diagram_annotation\".\"annotation_id\", \"flow_diagram_annotation\".\"diagram_id\", \"flow_diagram_annotation\".\"entity_id\", \"flow_diagram_annotation\".\"entity_kind\", \"flow_diagram_annotation\".\"note\" from \"flow_diagram_annotation\" where \"flow_diagram_annotation\".\"diagram_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
  }
}
