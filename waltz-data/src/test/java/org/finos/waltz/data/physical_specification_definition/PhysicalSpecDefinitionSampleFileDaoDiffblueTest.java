package org.finos.waltz.data.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.util.Optional;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionSampleFile;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionSampleFile;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalSpecDefinitionSampleFileDaoDiffblueTest {
  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionSampleFileDao#findForSpecDefinition(long)}
   */
  @Test
  void testFindForSpecDefinition() throws SQLException {
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
    Optional<PhysicalSpecDefinitionSampleFile> actualFindForSpecDefinitionResult = (new PhysicalSpecDefinitionSampleFileDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForSpecDefinition(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_spec_defn_sample_file\".\"id\", \"physical_spec_defn_sample_file\".\"spec_defn_id\", \"physical_spec_defn_sample_file\".\"name\", \"physical_spec_defn_sample_file\".\"file_data\" from \"physical_spec_defn_sample_file\" where \"physical_spec_defn_sample_file\".\"spec_defn_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertFalse(actualFindForSpecDefinitionResult.isPresent());
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionSampleFileDao#findForSpecDefinition(long)}
   */
  @Test
  void testFindForSpecDefinition2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
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
    Optional<PhysicalSpecDefinitionSampleFile> actualFindForSpecDefinitionResult = (new PhysicalSpecDefinitionSampleFileDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findForSpecDefinition(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_spec_defn_sample_file\".\"id\", \"physical_spec_defn_sample_file\".\"spec_defn_id\", \"physical_spec_defn_sample_file\".\"name\", \"physical_spec_defn_sample_file\".\"file_data\" from \"physical_spec_defn_sample_file\" where \"physical_spec_defn_sample_file\".\"spec_defn_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    PhysicalSpecDefinitionSampleFile getResult = actualFindForSpecDefinitionResult.get();
    assertTrue(getResult instanceof ImmutablePhysicalSpecDefinitionSampleFile);
    assertEquals("String", getResult.name());
    assertEquals("String", getResult.fileData());
    assertEquals(1L, getResult.specDefinitionId());
    assertTrue(actualFindForSpecDefinitionResult.isPresent());
  }

  /**
   * Method under test: {@link PhysicalSpecDefinitionSampleFileDao#delete(long)}
   */
  @Test
  void testDelete() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteResult = (new PhysicalSpecDefinitionSampleFileDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).delete(1L);

    // Assert
    verify(connection).prepareStatement(
        eq("delete from \"physical_spec_defn_sample_file\" where \"physical_spec_defn_sample_file\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionSampleFileDao#deleteForSpecDefinition(long)}
   */
  @Test
  void testDeleteForSpecDefinition() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualDeleteForSpecDefinitionResult = (new PhysicalSpecDefinitionSampleFileDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).deleteForSpecDefinition(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"physical_spec_defn_sample_file\" where \"physical_spec_defn_sample_file\".\"spec_defn_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteForSpecDefinitionResult);
  }
}
