package org.finos.waltz.data.svg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.finos.waltz.model.svg.ImmutableSvgDiagram;
import org.finos.waltz.model.svg.SvgDiagram;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SvgDiagramDaoDiffblueTest {
  /**
   * Test {@link SvgDiagramDao#getById(long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#getInt(int)} return one.</li>
   *   <li>Then return {@link ImmutableSvgDiagram}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SvgDiagramDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); given ResultSet getInt(int) return one; then return ImmutableSvgDiagram")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SvgDiagram SvgDiagramDao.getById(long)"})
  void testGetById_givenResultSetGetIntReturnOne_thenReturnImmutableSvgDiagram() throws SQLException {
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
    SvgDiagramDao svgDiagramDao = new SvgDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    SvgDiagram actualById = svgDiagramDao.getById(1L);

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
    assertTrue(svgDiagramDao.findAll().isEmpty());
  }
}
