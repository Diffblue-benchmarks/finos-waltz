package org.finos.waltz.data.process_diagram;

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
import java.sql.Timestamp;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagram;
import org.finos.waltz.model.process_diagram.ProcessDiagram;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProcessDiagramDaoDiffblueTest {
  /**
   * Test {@link ProcessDiagramDao#getDiagramById(long)}.
   * <ul>
   *   <li>Given {@link Timestamp} {@link Timestamp#getTime()} return ten.</li>
   *   <li>Then return createdBy is {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessDiagramDao#getDiagramById(long)}
   */
  @Test
  @DisplayName("Test getDiagramById(long); given Timestamp getTime() return ten; then return createdBy is 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProcessDiagram ProcessDiagramDao.getDiagramById(long)"})
  void testGetDiagramById_givenTimestampGetTimeReturnTen_thenReturnCreatedByIsString() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
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
    ProcessDiagram actualDiagramById = (new ProcessDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getDiagramById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"process_diagram\".\"id\", \"process_diagram\".\"name\", \"process_diagram\".\"description\", \"process_diagram\".\"diagram_kind\", \"process_diagram\".\"layout_data\", \"process_diagram\".\"last_updated_at\", \"process_diagram\".\"last_updated_by\", \"process_diagram\".\"created_at\", \"process_diagram\".\"created_by\", \"process_diagram\".\"external_id\", \"process_diagram\".\"provenance\" from \"process_diagram\" where \"process_diagram\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertTrue(actualDiagramById instanceof ImmutableProcessDiagram);
    assertEquals("String", actualDiagramById.createdBy());
    assertEquals("String", actualDiagramById.description());
    assertEquals("String", actualDiagramById.lastUpdatedBy());
    assertEquals("String", actualDiagramById.name());
    assertEquals("String", actualDiagramById.provenance());
  }

  /**
   * Test {@link ProcessDiagramDao#getDiagramById(long)}.
   * <ul>
   *   <li>Then return createdBy is {@code WALTZ_SPARX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessDiagramDao#getDiagramById(long)}
   */
  @Test
  @DisplayName("Test getDiagramById(long); then return createdBy is 'WALTZ_SPARX'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProcessDiagram ProcessDiagramDao.getDiagramById(long)"})
  void testGetDiagramById_thenReturnCreatedByIsWaltzSparx() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("WALTZ_SPARX");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
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
    ProcessDiagram actualDiagramById = (new ProcessDiagramDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getDiagramById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"process_diagram\".\"id\", \"process_diagram\".\"name\", \"process_diagram\".\"description\", \"process_diagram\".\"diagram_kind\", \"process_diagram\".\"layout_data\", \"process_diagram\".\"last_updated_at\", \"process_diagram\".\"last_updated_by\", \"process_diagram\".\"created_at\", \"process_diagram\".\"created_by\", \"process_diagram\".\"external_id\", \"process_diagram\".\"provenance\" from \"process_diagram\" where \"process_diagram\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertTrue(actualDiagramById instanceof ImmutableProcessDiagram);
    assertEquals("WALTZ_SPARX", actualDiagramById.createdBy());
    assertEquals("WALTZ_SPARX", actualDiagramById.description());
    assertEquals("WALTZ_SPARX", actualDiagramById.lastUpdatedBy());
    assertEquals("WALTZ_SPARX", actualDiagramById.name());
    assertEquals("WALTZ_SPARX", actualDiagramById.provenance());
  }

  /**
   * Test {@link ProcessDiagramDao#getDiagramByExternalId(String)}.
   * <ul>
   *   <li>Then return createdBy is {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessDiagramDao#getDiagramByExternalId(String)}
   */
  @Test
  @DisplayName("Test getDiagramByExternalId(String); then return createdBy is 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProcessDiagram ProcessDiagramDao.getDiagramByExternalId(String)"})
  void testGetDiagramByExternalId_thenReturnCreatedByIsString() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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
    ProcessDiagram actualDiagramByExternalId = (new ProcessDiagramDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getDiagramByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"process_diagram\".\"id\", \"process_diagram\".\"name\", \"process_diagram\".\"description\", \"process_diagram\".\"diagram_kind\", \"process_diagram\".\"layout_data\", \"process_diagram\".\"last_updated_at\", \"process_diagram\".\"last_updated_by\", \"process_diagram\".\"created_at\", \"process_diagram\".\"created_by\", \"process_diagram\".\"external_id\", \"process_diagram\".\"provenance\" from \"process_diagram\" where \"process_diagram\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertTrue(actualDiagramByExternalId instanceof ImmutableProcessDiagram);
    assertEquals("String", actualDiagramByExternalId.createdBy());
    assertEquals("String", actualDiagramByExternalId.description());
    assertEquals("String", actualDiagramByExternalId.lastUpdatedBy());
    assertEquals("String", actualDiagramByExternalId.name());
    assertEquals("String", actualDiagramByExternalId.provenance());
  }

  /**
   * Test {@link ProcessDiagramDao#getDiagramByExternalId(String)}.
   * <ul>
   *   <li>Then return createdBy is {@code WALTZ_SPARX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessDiagramDao#getDiagramByExternalId(String)}
   */
  @Test
  @DisplayName("Test getDiagramByExternalId(String); then return createdBy is 'WALTZ_SPARX'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProcessDiagram ProcessDiagramDao.getDiagramByExternalId(String)"})
  void testGetDiagramByExternalId_thenReturnCreatedByIsWaltzSparx() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.getTime()).thenReturn(10L);
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("WALTZ_SPARX");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
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
    ProcessDiagram actualDiagramByExternalId = (new ProcessDiagramDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getDiagramByExternalId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"process_diagram\".\"id\", \"process_diagram\".\"name\", \"process_diagram\".\"description\", \"process_diagram\".\"diagram_kind\", \"process_diagram\".\"layout_data\", \"process_diagram\".\"last_updated_at\", \"process_diagram\".\"last_updated_by\", \"process_diagram\".\"created_at\", \"process_diagram\".\"created_by\", \"process_diagram\".\"external_id\", \"process_diagram\".\"provenance\" from \"process_diagram\" where \"process_diagram\".\"external_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).getTime();
    assertTrue(actualDiagramByExternalId instanceof ImmutableProcessDiagram);
    assertEquals("WALTZ_SPARX", actualDiagramByExternalId.createdBy());
    assertEquals("WALTZ_SPARX", actualDiagramByExternalId.description());
    assertEquals("WALTZ_SPARX", actualDiagramByExternalId.lastUpdatedBy());
    assertEquals("WALTZ_SPARX", actualDiagramByExternalId.name());
    assertEquals("WALTZ_SPARX", actualDiagramByExternalId.provenance());
  }
}
