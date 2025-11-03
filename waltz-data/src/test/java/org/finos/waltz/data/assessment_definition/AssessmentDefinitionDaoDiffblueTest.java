package org.finos.waltz.data.assessment_definition;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
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
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AssessmentDefinitionDaoDiffblueTest {
  /**
   * Test {@link AssessmentDefinitionDao#getById(long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssessmentDefinitionDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentDefinition AssessmentDefinitionDao.getById(long)"})
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
}
