package org.finos.waltz.data.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRule;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowClassificationRuleDaoDiffblueTest {
  /**
   * Test {@link FlowClassificationRuleDao#getById(long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlowClassificationRuleDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FlowClassificationRule FlowClassificationRuleDao.getById(long)"})
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
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    FlowClassificationRule actualById = flowClassificationRuleDao.getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select case when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"organisational_unit\".\"name\" from \"organisational_unit\" where \"organisational_unit\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"flow_classification_rule\".\"parent_id\") end, case when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") end, \"organisational_unit\".\"id\", \"organisational_unit\".\"name\", \"flow_classification_rule\".\"id\", \"flow_classification_rule\".\"parent_kind\", \"flow_classification_rule\".\"parent_id\", \"flow_classification_rule\".\"subject_entity_id\", \"flow_classification_rule\".\"data_type_id\", \"flow_classification_rule\".\"flow_classification_id\", \"flow_classification_rule\".\"description\", \"flow_classification_rule\".\"external_id\", \"flow_classification_rule\".\"last_updated_at\", \"flow_classification_rule\".\"last_updated_by\", \"flow_classification_rule\".\"provenance\", \"flow_classification_rule\".\"is_readonly\", \"flow_classification_rule\".\"subject_entity_kind\", \"flow_classification_rule\".\"message\", \"flow_classification_rule\".\"message_severity\", \"flow_classification_rule\".\"direction\" from \"flow_classification_rule\" left outer join \"application\" \"subject_app\" on (\"subject_app\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"application\" \"subject_euda\" on (\"subject_euda\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"organisational_unit\" on (\"organisational_unit\".\"id\" = \"subject_app\".\"organisational_unit_id\" or \"organisational_unit\".\"id\" = \"subject_euda\".\"organisational_unit_id\") where \"flow_classification_rule\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(11), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
    assertEquals(1, flowClassificationRuleDao.cleanupOrphans().size());
  }
}
