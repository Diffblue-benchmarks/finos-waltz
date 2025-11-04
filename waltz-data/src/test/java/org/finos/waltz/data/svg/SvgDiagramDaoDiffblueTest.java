package org.finos.waltz.data.svg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.svg.ImmutableSvgDiagram;
import org.finos.waltz.model.svg.SvgDiagram;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SvgDiagramDaoDiffblueTest {
  /**
   * Method under test: {@link SvgDiagramDao#getById(long)}
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
    SvgDiagram actualById = (new SvgDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"svg_diagram\".\"id\", \"svg_diagram\".\"name\", \"svg_diagram\".\"group\", \"svg_diagram\".\"priority\", \"svg_diagram\".\"description\", \"svg_diagram\".\"svg\", \"svg_diagram\".\"key_property\", \"svg_diagram\".\"product\", \"svg_diagram\".\"display_width_percent\", \"svg_diagram\".\"display_height_percent\" from \"svg_diagram\" where \"svg_diagram\".\"id\" = ?"));
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

  /**
   * Method under test: {@link SvgDiagramDao#getById(long)}
   */
  @Test
  void testGetById2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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
    SvgDiagram actualById = (new SvgDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"svg_diagram\".\"id\", \"svg_diagram\".\"name\", \"svg_diagram\".\"group\", \"svg_diagram\".\"priority\", \"svg_diagram\".\"description\", \"svg_diagram\".\"svg\", \"svg_diagram\".\"key_property\", \"svg_diagram\".\"product\", \"svg_diagram\".\"display_width_percent\", \"svg_diagram\".\"display_height_percent\" from \"svg_diagram\" where \"svg_diagram\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(anyInt());
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualById instanceof ImmutableSvgDiagram);
    assertEquals("String", actualById.description());
    assertEquals("String", actualById.name());
    assertEquals("String", actualById.group());
    assertEquals("String", actualById.keyProperty());
    assertEquals("String", actualById.product());
    assertEquals("String", actualById.svg());
    assertEquals(1, actualById.displayHeightPercent().intValue());
    assertEquals(1, actualById.displayWidthPercent().intValue());
    assertEquals(1, actualById.priority());
  }

  /**
   * Method under test: {@link SvgDiagramDao#findByGroups(String[])}
   */
  @Test
  void testFindByGroups() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    List<SvgDiagram> actualFindByGroupsResult = (new SvgDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findByGroups(new String[]{"Groups"});

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"svg_diagram\".\"id\", \"svg_diagram\".\"name\", \"svg_diagram\".\"group\", \"svg_diagram\".\"priority\", \"svg_diagram\".\"description\", \"svg_diagram\".\"svg\", \"svg_diagram\".\"key_property\", \"svg_diagram\".\"product\", \"svg_diagram\".\"display_width_percent\", \"svg_diagram\".\"display_height_percent\" from \"svg_diagram\" where \"svg_diagram\".\"group\" in (?) order by \"svg_diagram\".\"priority\" asc"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("Groups"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(anyInt());
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindByGroupsResult.size());
    SvgDiagram getResult = actualFindByGroupsResult.get(0);
    assertTrue(getResult instanceof ImmutableSvgDiagram);
    SvgDiagram getResult2 = actualFindByGroupsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableSvgDiagram);
    assertEquals("String", getResult.description());
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.group());
    assertEquals("String", getResult.keyProperty());
    assertEquals("String", getResult.product());
    assertEquals("String", getResult.svg());
    assertEquals(1, getResult.displayHeightPercent().intValue());
    assertEquals(1, getResult.displayWidthPercent().intValue());
    assertEquals(1, getResult.priority());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link SvgDiagramDao#findByGroups(String[])}
   */
  @Test
  void testFindByGroups2() throws SQLException {
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
    List<SvgDiagram> actualFindByGroupsResult = (new SvgDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findByGroups(new String[]{"Groups"});

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"svg_diagram\".\"id\", \"svg_diagram\".\"name\", \"svg_diagram\".\"group\", \"svg_diagram\".\"priority\", \"svg_diagram\".\"description\", \"svg_diagram\".\"svg\", \"svg_diagram\".\"key_property\", \"svg_diagram\".\"product\", \"svg_diagram\".\"display_width_percent\", \"svg_diagram\".\"display_height_percent\" from \"svg_diagram\" where \"svg_diagram\".\"group\" in (?) order by \"svg_diagram\".\"priority\" asc"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("Groups"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByGroupsResult.isEmpty());
  }

  /**
   * Method under test: {@link SvgDiagramDao#findAll()}
   */
  @Test
  void testFindAll() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
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
    Set<SvgDiagram> actualFindAllResult = (new SvgDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"svg_diagram\".\"id\", \"svg_diagram\".\"name\", \"svg_diagram\".\"group\", \"svg_diagram\".\"priority\", \"svg_diagram\".\"description\", \"svg_diagram\".\"svg\", \"svg_diagram\".\"key_property\", \"svg_diagram\".\"product\", \"svg_diagram\".\"display_width_percent\", \"svg_diagram\".\"display_height_percent\" from \"svg_diagram\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(anyInt());
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1, actualFindAllResult.size());
  }

  /**
   * Method under test: {@link SvgDiagramDao#findAll()}
   */
  @Test
  void testFindAll2() throws SQLException {
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
    Set<SvgDiagram> actualFindAllResult = (new SvgDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"svg_diagram\".\"id\", \"svg_diagram\".\"name\", \"svg_diagram\".\"group\", \"svg_diagram\".\"priority\", \"svg_diagram\".\"description\", \"svg_diagram\".\"svg\", \"svg_diagram\".\"key_property\", \"svg_diagram\".\"product\", \"svg_diagram\".\"display_width_percent\", \"svg_diagram\".\"display_height_percent\" from \"svg_diagram\""));
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
   * Method under test: {@link SvgDiagramDao#remove(long)}
   */
  @Test
  void testRemove() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Boolean actualRemoveResult = (new SvgDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).remove(1L);

    // Assert
    verify(connection).prepareStatement(eq("delete from \"svg_diagram\" where \"svg_diagram\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }
}
