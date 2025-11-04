package org.finos.waltz.data.assessment_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.schema.tables.records.AssessmentDefinitionRecord;
import org.jooq.Condition;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AssessmentDefinitionDaoDiffblueTest {
  /**
   * Method under test: {@link AssessmentDefinitionDao#getById(long)}
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
    AssessmentDefinition actualById = (new AssessmentDefinitionDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"assessment_definition\".\"id\", \"assessment_definition\".\"name\", \"assessment_definition\".\"external_id\", \"assessment_definition\".\"rating_scheme_id\", \"assessment_definition\".\"entity_kind\", \"assessment_definition\".\"description\", \"assessment_definition\".\"permitted_role\", \"assessment_definition\".\"last_updated_at\", \"assessment_definition\".\"last_updated_by\", \"assessment_definition\".\"is_readonly\", \"assessment_definition\".\"provenance\", \"assessment_definition\".\"visibility\", \"assessment_definition\".\"definition_group\", \"assessment_definition\".\"qualifier_kind\", \"assessment_definition\".\"qualifier_id\", \"assessment_definition\".\"cardinality\" from \"assessment_definition\" where \"assessment_definition\".\"id\" = ?"));
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
   * Method under test: {@link AssessmentDefinitionDao#findAll()}
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
    Set<AssessmentDefinition> actualFindAllResult = (new AssessmentDefinitionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"assessment_definition\".\"id\", \"assessment_definition\".\"name\", \"assessment_definition\".\"external_id\", \"assessment_definition\".\"rating_scheme_id\", \"assessment_definition\".\"entity_kind\", \"assessment_definition\".\"description\", \"assessment_definition\".\"permitted_role\", \"assessment_definition\".\"last_updated_at\", \"assessment_definition\".\"last_updated_by\", \"assessment_definition\".\"is_readonly\", \"assessment_definition\".\"provenance\", \"assessment_definition\".\"visibility\", \"assessment_definition\".\"definition_group\", \"assessment_definition\".\"qualifier_kind\", \"assessment_definition\".\"qualifier_id\", \"assessment_definition\".\"cardinality\" from \"assessment_definition\" where 1 = 1"));
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
   * Method under test:
   * {@link AssessmentDefinitionDao#findByEntityKind(EntityKind)}
   */
  @Test
  void testFindByEntityKind() throws SQLException {
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
    Set<AssessmentDefinition> actualFindByEntityKindResult = (new AssessmentDefinitionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByEntityKind(EntityKind.ALL);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"assessment_definition\".\"id\", \"assessment_definition\".\"name\", \"assessment_definition\".\"external_id\", \"assessment_definition\".\"rating_scheme_id\", \"assessment_definition\".\"entity_kind\", \"assessment_definition\".\"description\", \"assessment_definition\".\"permitted_role\", \"assessment_definition\".\"last_updated_at\", \"assessment_definition\".\"last_updated_by\", \"assessment_definition\".\"is_readonly\", \"assessment_definition\".\"provenance\", \"assessment_definition\".\"visibility\", \"assessment_definition\".\"definition_group\", \"assessment_definition\".\"qualifier_kind\", \"assessment_definition\".\"qualifier_id\", \"assessment_definition\".\"cardinality\" from \"assessment_definition\" where \"assessment_definition\".\"entity_kind\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("ALL"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByEntityKindResult.isEmpty());
  }

  /**
   * Method under test: {@link AssessmentDefinitionDao#remove(long)}
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
    int actualRemoveResult = (new AssessmentDefinitionDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .remove(1L);

    // Assert
    verify(connection)
        .prepareStatement(eq("delete from \"assessment_definition\" where \"assessment_definition\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveResult);
  }

  /**
   * Method under test: {@link AssessmentDefinitionDao#remove(long)}
   */
  @Test
  void testRemove2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<AssessmentDefinitionRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<AssessmentDefinitionRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<AssessmentDefinitionRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualRemoveResult = (new AssessmentDefinitionDao(dsl)).remove(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualRemoveResult);
  }

  /**
   * Method under test: {@link AssessmentDefinitionDao#remove(long)}
   */
  @Test
  void testRemove3() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualRemoveResult = (new AssessmentDefinitionDao(new DefaultDSLContext(connection, SQLDialect.POSTGRES)))
        .remove(1L);

    // Assert
    verify(connection)
        .prepareStatement(eq("delete from \"assessment_definition\" where \"assessment_definition\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveResult);
  }

  /**
   * Method under test: {@link AssessmentDefinitionDao#remove(long)}
   */
  @Test
  void testRemove4() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualRemoveResult = (new AssessmentDefinitionDao(new DefaultDSLContext(connection, SQLDialect.SQLITE)))
        .remove(1L);

    // Assert
    verify(connection).prepareStatement(eq("delete from assessment_definition where assessment_definition.id = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveResult);
  }

  /**
   * Method under test: {@link AssessmentDefinitionDao#findFavourites(Set, Set)}
   */
  @Test
  void testFindFavourites() throws SQLException {
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
    AssessmentDefinitionDao assessmentDefinitionDao = new AssessmentDefinitionDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    HashSet<Long> included = new HashSet<>();

    // Act
    Set<AssessmentDefinition> actualFindFavouritesResult = assessmentDefinitionDao.findFavourites(included,
        new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"assessment_definition\".\"id\", \"assessment_definition\".\"name\", \"assessment_definition\".\"external_id\", \"assessment_definition\".\"rating_scheme_id\", \"assessment_definition\".\"entity_kind\", \"assessment_definition\".\"description\", \"assessment_definition\".\"permitted_role\", \"assessment_definition\".\"last_updated_at\", \"assessment_definition\".\"last_updated_by\", \"assessment_definition\".\"is_readonly\", \"assessment_definition\".\"provenance\", \"assessment_definition\".\"visibility\", \"assessment_definition\".\"definition_group\", \"assessment_definition\".\"qualifier_kind\", \"assessment_definition\".\"qualifier_id\", \"assessment_definition\".\"cardinality\" from \"assessment_definition\" where (\"assessment_definition\".\"id\" in () or (\"assessment_definition\".\"visibility\" = ? and \"assessment_definition\".\"id\" not in ()))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("PRIMARY"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindFavouritesResult.isEmpty());
  }
}
