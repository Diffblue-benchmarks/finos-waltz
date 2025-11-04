package org.finos.waltz.data.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.entity_hierarchy.EntityHierarchy;
import org.finos.waltz.model.flow_classification_rule.DiscouragedSource;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRule;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleUpdateCommand;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleVantagePoint;
import org.finos.waltz.model.flow_classification_rule.ImmutableDiscouragedSource;
import org.finos.waltz.schema.tables.records.FlowClassificationRuleRecord;
import org.finos.waltz.schema.tables.records.LogicalFlowDecoratorRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.UpdateConditionStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowClassificationRuleDaoDiffblueTest {
  /**
   * Method under test: {@link FlowClassificationRuleDao#findAll()}
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<FlowClassificationRule> actualFindAllResult = (new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAll();

    // Assert
    verify(connection).prepareStatement(eq(
        "select case when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"organisational_unit\".\"name\" from \"organisational_unit\" where \"organisational_unit\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"flow_classification_rule\".\"parent_id\") end, case when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") end, \"organisational_unit\".\"id\", \"organisational_unit\".\"name\", \"flow_classification_rule\".\"id\", \"flow_classification_rule\".\"parent_kind\", \"flow_classification_rule\".\"parent_id\", \"flow_classification_rule\".\"subject_entity_id\", \"flow_classification_rule\".\"data_type_id\", \"flow_classification_rule\".\"flow_classification_id\", \"flow_classification_rule\".\"description\", \"flow_classification_rule\".\"external_id\", \"flow_classification_rule\".\"last_updated_at\", \"flow_classification_rule\".\"last_updated_by\", \"flow_classification_rule\".\"provenance\", \"flow_classification_rule\".\"is_readonly\", \"flow_classification_rule\".\"subject_entity_kind\", \"flow_classification_rule\".\"message\", \"flow_classification_rule\".\"message_severity\", \"flow_classification_rule\".\"direction\" from \"flow_classification_rule\" left outer join \"application\" \"subject_app\" on (\"subject_app\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"application\" \"subject_euda\" on (\"subject_euda\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"organisational_unit\" on (\"organisational_unit\".\"id\" = \"subject_app\".\"organisational_unit_id\" or \"organisational_unit\".\"id\" = \"subject_euda\".\"organisational_unit_id\")"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Method under test: {@link FlowClassificationRuleDao#getById(long)}
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    FlowClassificationRule actualById = (new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

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
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#findByEntityKind(EntityKind)}
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
    List<FlowClassificationRule> actualFindByEntityKindResult = (new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByEntityKind(EntityKind.ALL);

    // Assert
    verify(connection).prepareStatement(eq(
        "select case when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"organisational_unit\".\"name\" from \"organisational_unit\" where \"organisational_unit\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"flow_classification_rule\".\"parent_id\") end, case when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") end, \"organisational_unit\".\"id\", \"organisational_unit\".\"name\", \"flow_classification_rule\".\"id\", \"flow_classification_rule\".\"parent_kind\", \"flow_classification_rule\".\"parent_id\", \"flow_classification_rule\".\"subject_entity_id\", \"flow_classification_rule\".\"data_type_id\", \"flow_classification_rule\".\"flow_classification_id\", \"flow_classification_rule\".\"description\", \"flow_classification_rule\".\"external_id\", \"flow_classification_rule\".\"last_updated_at\", \"flow_classification_rule\".\"last_updated_by\", \"flow_classification_rule\".\"provenance\", \"flow_classification_rule\".\"is_readonly\", \"flow_classification_rule\".\"subject_entity_kind\", \"flow_classification_rule\".\"message\", \"flow_classification_rule\".\"message_severity\", \"flow_classification_rule\".\"direction\" from \"flow_classification_rule\" left outer join \"application\" \"subject_app\" on (\"subject_app\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"application\" \"subject_euda\" on (\"subject_euda\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"organisational_unit\" on (\"organisational_unit\".\"id\" = \"subject_app\".\"organisational_unit_id\" or \"organisational_unit\".\"id\" = \"subject_euda\".\"organisational_unit_id\") where \"flow_classification_rule\".\"parent_kind\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByEntityKindResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() throws SQLException {
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
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<FlowClassificationRule> actualFindByEntityReferenceResult = flowClassificationRuleDao
        .findByEntityReference(ref);

    // Assert
    verify(connection).prepareStatement(eq(
        "select case when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"organisational_unit\".\"name\" from \"organisational_unit\" where \"organisational_unit\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"flow_classification_rule\".\"parent_id\") end, case when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") end, \"organisational_unit\".\"id\", \"organisational_unit\".\"name\", \"flow_classification_rule\".\"id\", \"flow_classification_rule\".\"parent_kind\", \"flow_classification_rule\".\"parent_id\", \"flow_classification_rule\".\"subject_entity_id\", \"flow_classification_rule\".\"data_type_id\", \"flow_classification_rule\".\"flow_classification_id\", \"flow_classification_rule\".\"description\", \"flow_classification_rule\".\"external_id\", \"flow_classification_rule\".\"last_updated_at\", \"flow_classification_rule\".\"last_updated_by\", \"flow_classification_rule\".\"provenance\", \"flow_classification_rule\".\"is_readonly\", \"flow_classification_rule\".\"subject_entity_kind\", \"flow_classification_rule\".\"message\", \"flow_classification_rule\".\"message_severity\", \"flow_classification_rule\".\"direction\" from \"flow_classification_rule\" left outer join \"application\" \"subject_app\" on (\"subject_app\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"application\" \"subject_euda\" on (\"subject_euda\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"organisational_unit\" on (\"organisational_unit\".\"id\" = \"subject_app\".\"organisational_unit_id\" or \"organisational_unit\".\"id\" = \"subject_euda\".\"organisational_unit_id\") where (\"flow_classification_rule\".\"parent_kind\" = ? and \"flow_classification_rule\".\"parent_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(12), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#findByApplicationId(long)}
   */
  @Test
  void testFindByApplicationId() throws SQLException {
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
    List<FlowClassificationRule> actualFindByApplicationIdResult = (new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findByApplicationId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select case when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"organisational_unit\".\"name\" from \"organisational_unit\" where \"organisational_unit\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"flow_classification_rule\".\"parent_id\") end, case when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") end, \"organisational_unit\".\"id\", \"organisational_unit\".\"name\", \"flow_classification_rule\".\"id\", \"flow_classification_rule\".\"parent_kind\", \"flow_classification_rule\".\"parent_id\", \"flow_classification_rule\".\"subject_entity_id\", \"flow_classification_rule\".\"data_type_id\", \"flow_classification_rule\".\"flow_classification_id\", \"flow_classification_rule\".\"description\", \"flow_classification_rule\".\"external_id\", \"flow_classification_rule\".\"last_updated_at\", \"flow_classification_rule\".\"last_updated_by\", \"flow_classification_rule\".\"provenance\", \"flow_classification_rule\".\"is_readonly\", \"flow_classification_rule\".\"subject_entity_kind\", \"flow_classification_rule\".\"message\", \"flow_classification_rule\".\"message_severity\", \"flow_classification_rule\".\"direction\" from \"flow_classification_rule\" left outer join \"application\" \"subject_app\" on (\"subject_app\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"application\" \"subject_euda\" on (\"subject_euda\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"organisational_unit\" on (\"organisational_unit\".\"id\" = \"subject_app\".\"organisational_unit_id\" or \"organisational_unit\".\"id\" = \"subject_euda\".\"organisational_unit_id\") where (\"flow_classification_rule\".\"subject_entity_id\" = ? and \"flow_classification_rule\".\"subject_entity_kind\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(11), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByApplicationIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#update(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  void testUpdate() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    FlowClassificationRuleUpdateCommand command = mock(FlowClassificationRuleUpdateCommand.class);
    when(command.message()).thenReturn("Not all who wander are lost");
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.classificationId()).thenReturn(1L);
    when(command.severity()).thenReturn(MessageSeverity.NONE);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(command.id()).thenReturn(ofResult);

    // Act
    int actualUpdateResult = flowClassificationRuleDao.update(command);

    // Assert
    verify(connection).prepareStatement(eq(
        "update \"flow_classification_rule\" set \"flow_classification_rule\".\"flow_classification_id\" = ?, \"flow_classification_rule\".\"description\" = ?, \"flow_classification_rule\".\"direction\" = (select \"flow_classification\".\"direction\" from \"flow_classification\" where \"flow_classification\".\"id\" = ?), \"flow_classification_rule\".\"message_severity\" = ?, \"flow_classification_rule\".\"message\" = ? where \"flow_classification_rule\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(command).description();
    verify(command, atLeast(1)).id();
    verify(command, atLeast(1)).classificationId();
    verify(command).message();
    verify(command, atLeast(1)).severity();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Method under test: {@link FlowClassificationRuleDao#remove(long)}
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
    int actualRemoveResult = (new FlowClassificationRuleDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .remove(1L);

    // Assert
    verify(connection)
        .prepareStatement(eq("delete from \"flow_classification_rule\" where \"flow_classification_rule\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveResult);
  }

  /**
   * Method under test: {@link FlowClassificationRuleDao#remove(long)}
   */
  @Test
  void testRemove2() throws DataAccessException {
    // Arrange
    DeleteConditionStep<FlowClassificationRuleRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteUsingStep<FlowClassificationRuleRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<FlowClassificationRuleRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    int actualRemoveResult = (new FlowClassificationRuleDao(dsl)).remove(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(1, actualRemoveResult);
  }

  /**
   * Method under test: {@link FlowClassificationRuleDao#remove(long)}
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
    int actualRemoveResult = (new FlowClassificationRuleDao(new DefaultDSLContext(connection, SQLDialect.POSTGRES)))
        .remove(1L);

    // Assert
    verify(connection)
        .prepareStatement(eq("delete from \"flow_classification_rule\" where \"flow_classification_rule\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveResult);
  }

  /**
   * Method under test: {@link FlowClassificationRuleDao#remove(long)}
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
    int actualRemoveResult = (new FlowClassificationRuleDao(new DefaultDSLContext(connection, SQLDialect.SQLITE)))
        .remove(1L);

    // Assert
    verify(connection)
        .prepareStatement(eq("delete from flow_classification_rule where flow_classification_rule.id = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveResult);
  }

  /**
   * Method under test: {@link FlowClassificationRuleDao#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
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
    Set<EntityReference> actualCleanupOrphansResult = (new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).cleanupOrphans();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(1, actualCleanupOrphansResult.size());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set, Set, Set)}
   */
  @Test
  void testFindExpandedFlowClassificationRuleVantagePoints() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));
    HashSet<Long> orgVantagePointIds = new HashSet<>();
    HashSet<Long> appVantagePointIds = new HashSet<>();

    // Act
    List<FlowClassificationRuleVantagePoint> actualFindExpandedFlowClassificationRuleVantagePointsResult = flowClassificationRuleDao
        .findExpandedFlowClassificationRuleVantagePoints(FlowDirection.INBOUND, orgVantagePointIds, appVantagePointIds,
            new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select coalesce(\"ehOrgUnit\".\"id\", \"flow_classification_rule\".\"parent_id\"), \"flow_classification_rule\".\"parent_kind\", coalesce(\"ehOrgUnit\".\"level\", ?) \"parentLevel\", \"ehDataType\".\"id\", coalesce(\"ehDataType\".\"level\", ?) \"dataTypeLevel\", \"flow_classification_rule\".\"subject_entity_id\", \"flow_classification_rule\".\"subject_entity_kind\", \"flow_classification\".\"code\", \"flow_classification_rule\".\"id\", \"flow_classification_rule\".\"message\", \"flow_classification_rule\".\"message_severity\" from \"flow_classification_rule\" join \"flow_classification\" on (\"flow_classification\".\"direction\" = ? and \"flow_classification_rule\".\"flow_classification_id\" = \"flow_classification\".\"id\") left outer join \"entity_hierarchy\" \"ehDataType\" on (\"ehDataType\".\"kind\" = ? and \"ehDataType\".\"ancestor_id\" = \"flow_classification_rule\".\"data_type_id\") left outer join \"entity_hierarchy\" \"ehOrgUnit\" on (\"flow_classification_rule\".\"parent_kind\" = ? and \"ehOrgUnit\".\"kind\" = ? and \"ehOrgUnit\".\"ancestor_id\" = \"flow_classification_rule\".\"parent_id\" and \"ehOrgUnit\".\"id\" in ()) where ((\"flow_classification_rule\".\"parent_kind\" = ? and \"flow_classification_rule\".\"parent_id\" in ()) or (\"flow_classification_rule\".\"parent_kind\" = ? and \"flow_classification_rule\".\"parent_id\" in ()) or (\"flow_classification_rule\".\"parent_kind\" = ? and \"ehOrgUnit\".\"id\" in ()))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(0));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindExpandedFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection)}
   */
  @Test
  void testFindFlowClassificationRuleVantagePoints() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<FlowClassificationRuleVantagePoint> actualFindFlowClassificationRuleVantagePointsResult = (new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99)))
            .findFlowClassificationRuleVantagePoints(FlowDirection.INBOUND);

    // Assert
    verify(connection).prepareStatement(eq(
        "select coalesce(\"ehOrgUnit\".\"id\", \"flow_classification_rule\".\"parent_id\"), \"flow_classification_rule\".\"parent_kind\", coalesce(\"ehOrgUnit\".\"level\", ?) \"parentLevel\", \"ehDataType\".\"id\", coalesce(\"ehDataType\".\"level\", ?) \"dataTypeLevel\", \"flow_classification_rule\".\"subject_entity_id\", \"flow_classification_rule\".\"subject_entity_kind\", \"flow_classification\".\"code\", \"flow_classification_rule\".\"id\", \"flow_classification_rule\".\"message\", \"flow_classification_rule\".\"message_severity\" from \"flow_classification_rule\" left outer join \"entity_hierarchy\" \"ehOrgUnit\" on (\"ehOrgUnit\".\"ancestor_id\" = \"flow_classification_rule\".\"parent_id\" and \"ehOrgUnit\".\"kind\" = ? and \"ehOrgUnit\".\"id\" = \"ehOrgUnit\".\"ancestor_id\") left outer join \"entity_hierarchy\" \"ehDataType\" on (\"ehDataType\".\"ancestor_id\" = \"flow_classification_rule\".\"data_type_id\" and \"ehDataType\".\"kind\" = ? and \"ehDataType\".\"id\" = \"ehDataType\".\"ancestor_id\") join \"flow_classification\" on \"flow_classification_rule\".\"flow_classification_id\" = \"flow_classification\".\"id\" where \"flow_classification\".\"direction\" = ? order by \"flow_classification_rule\".\"parent_kind\", \"parentLevel\" desc, \"dataTypeLevel\" desc, coalesce(\"ehOrgUnit\".\"id\", \"flow_classification_rule\".\"parent_id\"), \"ehDataType\".\"id\", \"flow_classification_rule\".\"subject_entity_id\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(0));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection, Set)}
   */
  @Test
  void testFindFlowClassificationRuleVantagePoints2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<FlowClassificationRuleVantagePoint> actualFindFlowClassificationRuleVantagePointsResult = flowClassificationRuleDao
        .findFlowClassificationRuleVantagePoints(FlowDirection.INBOUND, new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select coalesce(\"ehOrgUnit\".\"id\", \"flow_classification_rule\".\"parent_id\"), \"flow_classification_rule\".\"parent_kind\", coalesce(\"ehOrgUnit\".\"level\", ?) \"parentLevel\", \"ehDataType\".\"id\", coalesce(\"ehDataType\".\"level\", ?) \"dataTypeLevel\", \"flow_classification_rule\".\"subject_entity_id\", \"flow_classification_rule\".\"subject_entity_kind\", \"flow_classification\".\"code\", \"flow_classification_rule\".\"id\", \"flow_classification_rule\".\"message\", \"flow_classification_rule\".\"message_severity\" from \"flow_classification_rule\" left outer join \"entity_hierarchy\" \"ehOrgUnit\" on (\"ehOrgUnit\".\"ancestor_id\" = \"flow_classification_rule\".\"parent_id\" and \"ehOrgUnit\".\"kind\" = ? and \"ehOrgUnit\".\"id\" = \"ehOrgUnit\".\"ancestor_id\") left outer join \"entity_hierarchy\" \"ehDataType\" on (\"ehDataType\".\"ancestor_id\" = \"flow_classification_rule\".\"data_type_id\" and \"ehDataType\".\"kind\" = ? and \"ehDataType\".\"id\" = \"ehDataType\".\"ancestor_id\") join \"flow_classification\" on \"flow_classification_rule\".\"flow_classification_id\" = \"flow_classification\".\"id\" where (\"flow_classification\".\"direction\" = ? and (\"flow_classification_rule\".\"data_type_id\" in () or \"flow_classification_rule\".\"data_type_id\" is null)) order by \"flow_classification_rule\".\"parent_kind\", \"parentLevel\" desc, \"dataTypeLevel\" desc, coalesce(\"ehOrgUnit\".\"id\", \"flow_classification_rule\".\"parent_id\"), \"ehDataType\".\"id\", \"flow_classification_rule\".\"subject_entity_id\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(0));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection, EntityHierarchy, Set)}
   */
  @Test
  void testFindFlowClassificationRuleVantagePoints3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<FlowClassificationRuleVantagePoint> actualFindFlowClassificationRuleVantagePointsResult = flowClassificationRuleDao
        .findFlowClassificationRuleVantagePoints(FlowDirection.INBOUND, null, new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select coalesce(\"ehOrgUnit\".\"id\", \"flow_classification_rule\".\"parent_id\"), \"flow_classification_rule\".\"parent_kind\", coalesce(\"ehOrgUnit\".\"level\", ?) \"parentLevel\", \"ehDataType\".\"id\", coalesce(\"ehDataType\".\"level\", ?) \"dataTypeLevel\", \"flow_classification_rule\".\"subject_entity_id\", \"flow_classification_rule\".\"subject_entity_kind\", \"flow_classification\".\"code\", \"flow_classification_rule\".\"id\", \"flow_classification_rule\".\"message\", \"flow_classification_rule\".\"message_severity\" from \"flow_classification_rule\" left outer join \"entity_hierarchy\" \"ehOrgUnit\" on (\"ehOrgUnit\".\"ancestor_id\" = \"flow_classification_rule\".\"parent_id\" and \"ehOrgUnit\".\"kind\" = ? and \"ehOrgUnit\".\"id\" = \"ehOrgUnit\".\"ancestor_id\") left outer join \"entity_hierarchy\" \"ehDataType\" on (\"ehDataType\".\"ancestor_id\" = \"flow_classification_rule\".\"data_type_id\" and \"ehDataType\".\"kind\" = ? and \"ehDataType\".\"id\" = \"ehDataType\".\"ancestor_id\") join \"flow_classification\" on \"flow_classification_rule\".\"flow_classification_id\" = \"flow_classification\".\"id\" where (\"flow_classification\".\"direction\" = ? and (\"flow_classification_rule\".\"data_type_id\" in () or \"flow_classification_rule\".\"data_type_id\" is null)) order by \"flow_classification_rule\".\"parent_kind\", \"parentLevel\" desc, \"dataTypeLevel\" desc, coalesce(\"ehOrgUnit\".\"id\", \"flow_classification_rule\".\"parent_id\"), \"ehDataType\".\"id\", \"flow_classification_rule\".\"subject_entity_id\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setInt(anyInt(), eq(0));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#findDiscouragedSourcesBySelector(Condition)}
   */
  @Test
  void testFindDiscouragedSourcesBySelector() throws SQLException {
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
    List<DiscouragedSource> actualFindDiscouragedSourcesBySelectorResult = (new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99)))
            .findDiscouragedSourcesBySelector(ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"supplier\".\"id\", \"supplier\".\"name\", \"logical_flow_decorator\".\"decorator_entity_id\", count(\"logical_flow\".\"id\") from \"application\" \"supplier\" join \"logical_flow\" on (\"logical_flow\".\"source_entity_id\" = \"supplier\".\"id\" and \"logical_flow\".\"source_entity_kind\" = ?) join \"logical_flow_decorator\" on \"logical_flow_decorator\".\"logical_flow_id\" = \"logical_flow\".\"id\" join \"application\" \"consumer\" on (\"logical_flow\".\"target_entity_id\" = \"consumer\".\"id\" and \"logical_flow\".\"target_entity_kind\" = ?) where (\"application\".\"entity_lifecycle_status\" = ? and \"logical_flow\".\"entity_lifecycle_status\" <> ? and \"logical_flow\".\"is_removed\" = false and \"consumer\".\"is_removed\" = false and \"supplier\".\"is_removed\" = false and \"logical_flow_decorator\".\"decorator_entity_kind\" = ? and \"logical_flow_decorator\".\"rating\" in (?, ?)) group by \"supplier\".\"id\", \"supplier\".\"name\", \"logical_flow_decorator\".\"decorator_entity_id\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getInt(eq(4));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindDiscouragedSourcesBySelectorResult.size());
    DiscouragedSource getResult = actualFindDiscouragedSourcesBySelectorResult.get(0);
    EntityReference sourceReferenceResult = getResult.sourceReference();
    assertTrue(sourceReferenceResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableDiscouragedSource);
    DiscouragedSource getResult2 = actualFindDiscouragedSourcesBySelectorResult.get(1);
    assertTrue(getResult2 instanceof ImmutableDiscouragedSource);
    assertNull(sourceReferenceResult.description());
    assertEquals(1, getResult.count());
    assertEquals(1L, sourceReferenceResult.id());
    assertEquals(1L, getResult.dataTypeId());
    assertEquals(EntityKind.APPLICATION, sourceReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceReferenceResult.entityLifecycleStatus());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#findDiscouragedSourcesBySelector(Condition)}
   */
  @Test
  void testFindDiscouragedSourcesBySelector2() throws SQLException {
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
    List<DiscouragedSource> actualFindDiscouragedSourcesBySelectorResult = (new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99)))
            .findDiscouragedSourcesBySelector(ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"supplier\".\"id\", \"supplier\".\"name\", \"logical_flow_decorator\".\"decorator_entity_id\", count(\"logical_flow\".\"id\") from \"application\" \"supplier\" join \"logical_flow\" on (\"logical_flow\".\"source_entity_id\" = \"supplier\".\"id\" and \"logical_flow\".\"source_entity_kind\" = ?) join \"logical_flow_decorator\" on \"logical_flow_decorator\".\"logical_flow_id\" = \"logical_flow\".\"id\" join \"application\" \"consumer\" on (\"logical_flow\".\"target_entity_id\" = \"consumer\".\"id\" and \"logical_flow\".\"target_entity_kind\" = ?) where (\"application\".\"entity_lifecycle_status\" = ? and \"logical_flow\".\"entity_lifecycle_status\" <> ? and \"logical_flow\".\"is_removed\" = false and \"consumer\".\"is_removed\" = false and \"supplier\".\"is_removed\" = false and \"logical_flow_decorator\".\"decorator_entity_kind\" = ? and \"logical_flow_decorator\".\"rating\" in (?, ?)) group by \"supplier\".\"id\", \"supplier\".\"name\", \"logical_flow_decorator\".\"decorator_entity_id\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindDiscouragedSourcesBySelectorResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#findClassificationRules(Condition)}
   */
  @Test
  void testFindClassificationRules() throws SQLException {
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
    Set<FlowClassificationRule> actualFindClassificationRulesResult = (new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findClassificationRules(ApplicationDao.IS_ACTIVE);

    // Assert
    verify(connection).prepareStatement(eq(
        "select case when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"organisational_unit\".\"name\" from \"organisational_unit\" where \"organisational_unit\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"flow_classification_rule\".\"parent_id\") end, case when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") end, \"organisational_unit\".\"id\", \"organisational_unit\".\"name\", \"flow_classification_rule\".\"id\", \"flow_classification_rule\".\"parent_kind\", \"flow_classification_rule\".\"parent_id\", \"flow_classification_rule\".\"subject_entity_id\", \"flow_classification_rule\".\"data_type_id\", \"flow_classification_rule\".\"flow_classification_id\", \"flow_classification_rule\".\"description\", \"flow_classification_rule\".\"external_id\", \"flow_classification_rule\".\"last_updated_at\", \"flow_classification_rule\".\"last_updated_by\", \"flow_classification_rule\".\"provenance\", \"flow_classification_rule\".\"is_readonly\", \"flow_classification_rule\".\"subject_entity_kind\", \"flow_classification_rule\".\"message\", \"flow_classification_rule\".\"message_severity\", \"flow_classification_rule\".\"direction\" from \"flow_classification_rule\" left outer join \"application\" \"subject_app\" on (\"subject_app\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"application\" \"subject_euda\" on (\"subject_euda\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"organisational_unit\" on (\"organisational_unit\".\"id\" = \"subject_app\".\"organisational_unit_id\" or \"organisational_unit\".\"id\" = \"subject_euda\".\"organisational_unit_id\") where \"application\".\"entity_lifecycle_status\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindClassificationRulesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#updatePointToPointFlowClassificationRules(FlowDirection)}
   */
  @Test
  void testUpdatePointToPointFlowClassificationRules() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
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
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualUpdatePointToPointFlowClassificationRulesResult = (new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99)))
            .updatePointToPointFlowClassificationRules(FlowDirection.INBOUND);

    // Assert
    verify(connection).createStatement();
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"id\", \"child_dt\".\"id\", \"flow_classification\".\"code\", \"flow_classification_rule\".\"id\" from \"flow_classification_rule\" join \"data_type\" \"parent_dt\" on \"flow_classification_rule\".\"data_type_id\" = \"parent_dt\".\"id\" join \"entity_hierarchy\" on (\"parent_dt\".\"id\" = \"entity_hierarchy\".\"ancestor_id\" and \"entity_hierarchy\".\"kind\" = ?) join \"data_type\" \"child_dt\" on \"entity_hierarchy\".\"id\" = \"child_dt\".\"id\" join \"logical_flow\" on (\"flow_classification_rule\".\"subject_entity_id\" = \"logical_flow\".\"source_entity_id\" and \"logical_flow\".\"source_entity_kind\" = \"flow_classification_rule\".\"subject_entity_kind\" and \"logical_flow\".\"target_entity_kind\" = \"flow_classification_rule\".\"parent_kind\" and \"logical_flow\".\"target_entity_id\" = \"flow_classification_rule\".\"parent_id\") join \"logical_flow_decorator\" on (\"logical_flow\".\"id\" = \"logical_flow_decorator\".\"logical_flow_id\" and \"child_dt\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\" and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?) join \"entity_hierarchy\" \"level\" on (\"level\".\"id\" = \"parent_dt\".\"id\" and \"level\".\"id\" = \"level\".\"ancestor_id\" and \"level\".\"kind\" = ?) join \"flow_classification\" on \"flow_classification_rule\".\"flow_classification_id\" = \"flow_classification\".\"id\" where (\"flow_classification\".\"code\" <> \"logical_flow_decorator\".\"rating\" and \"flow_classification\".\"direction\" = ?) order by \"level\".\"level\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(statement).addBatch(eq(
        "update \"logical_flow_decorator\" set \"logical_flow_decorator\".\"rating\" = 'String', \"logical_flow_decorator\".\"flow_classification_rule_id\" = 1 where (\"logical_flow_decorator\".\"id\" = 1 and \"logical_flow_decorator\".\"decorator_entity_id\" = 1 and \"logical_flow_decorator\".\"decorator_entity_kind\" = 'DATA_TYPE')"));
    verify(preparedStatement).close();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(statement).getWarnings();
    assertEquals(0, actualUpdatePointToPointFlowClassificationRulesResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#updatePointToPointFlowClassificationRules(FlowDirection)}
   */
  @Test
  void testUpdatePointToPointFlowClassificationRules2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("");
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
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualUpdatePointToPointFlowClassificationRulesResult = (new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99)))
            .updatePointToPointFlowClassificationRules(FlowDirection.INBOUND);

    // Assert
    verify(connection).createStatement();
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"id\", \"child_dt\".\"id\", \"flow_classification\".\"code\", \"flow_classification_rule\".\"id\" from \"flow_classification_rule\" join \"data_type\" \"parent_dt\" on \"flow_classification_rule\".\"data_type_id\" = \"parent_dt\".\"id\" join \"entity_hierarchy\" on (\"parent_dt\".\"id\" = \"entity_hierarchy\".\"ancestor_id\" and \"entity_hierarchy\".\"kind\" = ?) join \"data_type\" \"child_dt\" on \"entity_hierarchy\".\"id\" = \"child_dt\".\"id\" join \"logical_flow\" on (\"flow_classification_rule\".\"subject_entity_id\" = \"logical_flow\".\"source_entity_id\" and \"logical_flow\".\"source_entity_kind\" = \"flow_classification_rule\".\"subject_entity_kind\" and \"logical_flow\".\"target_entity_kind\" = \"flow_classification_rule\".\"parent_kind\" and \"logical_flow\".\"target_entity_id\" = \"flow_classification_rule\".\"parent_id\") join \"logical_flow_decorator\" on (\"logical_flow\".\"id\" = \"logical_flow_decorator\".\"logical_flow_id\" and \"child_dt\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\" and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?) join \"entity_hierarchy\" \"level\" on (\"level\".\"id\" = \"parent_dt\".\"id\" and \"level\".\"id\" = \"level\".\"ancestor_id\" and \"level\".\"kind\" = ?) join \"flow_classification\" on \"flow_classification_rule\".\"flow_classification_id\" = \"flow_classification\".\"id\" where (\"flow_classification\".\"code\" <> \"logical_flow_decorator\".\"rating\" and \"flow_classification\".\"direction\" = ?) order by \"level\".\"level\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(statement).addBatch(eq(
        "update \"logical_flow_decorator\" set \"logical_flow_decorator\".\"rating\" = '', \"logical_flow_decorator\".\"flow_classification_rule_id\" = 1 where (\"logical_flow_decorator\".\"id\" = 1 and \"logical_flow_decorator\".\"decorator_entity_id\" = 1 and \"logical_flow_decorator\".\"decorator_entity_kind\" = 'DATA_TYPE')"));
    verify(preparedStatement).close();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(statement).getWarnings();
    assertEquals(0, actualUpdatePointToPointFlowClassificationRulesResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#updatePointToPointFlowClassificationRules(FlowDirection)}
   */
  @Test
  void testUpdatePointToPointFlowClassificationRules3() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.wasNull()).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(0L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualUpdatePointToPointFlowClassificationRulesResult = (new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99)))
            .updatePointToPointFlowClassificationRules(FlowDirection.INBOUND);

    // Assert
    verify(connection).createStatement();
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"id\", \"child_dt\".\"id\", \"flow_classification\".\"code\", \"flow_classification_rule\".\"id\" from \"flow_classification_rule\" join \"data_type\" \"parent_dt\" on \"flow_classification_rule\".\"data_type_id\" = \"parent_dt\".\"id\" join \"entity_hierarchy\" on (\"parent_dt\".\"id\" = \"entity_hierarchy\".\"ancestor_id\" and \"entity_hierarchy\".\"kind\" = ?) join \"data_type\" \"child_dt\" on \"entity_hierarchy\".\"id\" = \"child_dt\".\"id\" join \"logical_flow\" on (\"flow_classification_rule\".\"subject_entity_id\" = \"logical_flow\".\"source_entity_id\" and \"logical_flow\".\"source_entity_kind\" = \"flow_classification_rule\".\"subject_entity_kind\" and \"logical_flow\".\"target_entity_kind\" = \"flow_classification_rule\".\"parent_kind\" and \"logical_flow\".\"target_entity_id\" = \"flow_classification_rule\".\"parent_id\") join \"logical_flow_decorator\" on (\"logical_flow\".\"id\" = \"logical_flow_decorator\".\"logical_flow_id\" and \"child_dt\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\" and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?) join \"entity_hierarchy\" \"level\" on (\"level\".\"id\" = \"parent_dt\".\"id\" and \"level\".\"id\" = \"level\".\"ancestor_id\" and \"level\".\"kind\" = ?) join \"flow_classification\" on \"flow_classification_rule\".\"flow_classification_id\" = \"flow_classification\".\"id\" where (\"flow_classification\".\"code\" <> \"logical_flow_decorator\".\"rating\" and \"flow_classification\".\"direction\" = ?) order by \"level\".\"level\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(resultSet, atLeast(1)).wasNull();
    verify(statement).addBatch(eq(
        "update \"logical_flow_decorator\" set \"logical_flow_decorator\".\"rating\" = 'String', \"logical_flow_decorator\".\"flow_classification_rule_id\" = null where (\"logical_flow_decorator\".\"id\" = null and \"logical_flow_decorator\".\"decorator_entity_id\" = null and \"logical_flow_decorator\".\"decorator_entity_kind\" = 'DATA_TYPE')"));
    verify(preparedStatement).close();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(statement).getWarnings();
    assertEquals(0, actualUpdatePointToPointFlowClassificationRulesResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#updatePointToPointFlowClassificationRules(FlowDirection)}
   */
  @Test
  void testUpdatePointToPointFlowClassificationRules4() throws SQLException {
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
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualUpdatePointToPointFlowClassificationRulesResult = (new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99)))
            .updatePointToPointFlowClassificationRules(FlowDirection.INBOUND);

    // Assert
    verify(connection).createStatement();
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"id\", \"child_dt\".\"id\", \"flow_classification\".\"code\", \"flow_classification_rule\".\"id\" from \"flow_classification_rule\" join \"data_type\" \"parent_dt\" on \"flow_classification_rule\".\"data_type_id\" = \"parent_dt\".\"id\" join \"entity_hierarchy\" on (\"parent_dt\".\"id\" = \"entity_hierarchy\".\"ancestor_id\" and \"entity_hierarchy\".\"kind\" = ?) join \"data_type\" \"child_dt\" on \"entity_hierarchy\".\"id\" = \"child_dt\".\"id\" join \"logical_flow\" on (\"flow_classification_rule\".\"subject_entity_id\" = \"logical_flow\".\"source_entity_id\" and \"logical_flow\".\"source_entity_kind\" = \"flow_classification_rule\".\"subject_entity_kind\" and \"logical_flow\".\"target_entity_kind\" = \"flow_classification_rule\".\"parent_kind\" and \"logical_flow\".\"target_entity_id\" = \"flow_classification_rule\".\"parent_id\") join \"logical_flow_decorator\" on (\"logical_flow\".\"id\" = \"logical_flow_decorator\".\"logical_flow_id\" and \"child_dt\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\" and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?) join \"entity_hierarchy\" \"level\" on (\"level\".\"id\" = \"parent_dt\".\"id\" and \"level\".\"id\" = \"level\".\"ancestor_id\" and \"level\".\"kind\" = ?) join \"flow_classification\" on \"flow_classification_rule\".\"flow_classification_id\" = \"flow_classification\".\"id\" where (\"flow_classification\".\"code\" <> \"logical_flow_decorator\".\"rating\" and \"flow_classification\".\"direction\" = ?) order by \"level\".\"level\""));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(statement).getWarnings();
    assertEquals(0, actualUpdatePointToPointFlowClassificationRulesResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#findCompanionEntityRules(long)}
   */
  @Test
  void testFindCompanionEntityRules() throws SQLException {
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
    Set<FlowClassificationRule> actualFindCompanionEntityRulesResult = (new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findCompanionEntityRules(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select case when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"organisational_unit\".\"name\" from \"organisational_unit\" where \"organisational_unit\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"flow_classification_rule\".\"parent_id\") end, case when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") end, \"organisational_unit\".\"id\", \"organisational_unit\".\"name\", \"flow_classification_rule\".\"id\", \"flow_classification_rule\".\"parent_kind\", \"flow_classification_rule\".\"parent_id\", \"flow_classification_rule\".\"subject_entity_id\", \"flow_classification_rule\".\"data_type_id\", \"flow_classification_rule\".\"flow_classification_id\", \"flow_classification_rule\".\"description\", \"flow_classification_rule\".\"external_id\", \"flow_classification_rule\".\"last_updated_at\", \"flow_classification_rule\".\"last_updated_by\", \"flow_classification_rule\".\"provenance\", \"flow_classification_rule\".\"is_readonly\", \"flow_classification_rule\".\"subject_entity_kind\", \"flow_classification_rule\".\"message\", \"flow_classification_rule\".\"message_severity\", \"flow_classification_rule\".\"direction\" from \"flow_classification_rule\" left outer join \"application\" \"subject_app\" on (\"subject_app\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"application\" \"subject_euda\" on (\"subject_euda\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"organisational_unit\" on (\"organisational_unit\".\"id\" = \"subject_app\".\"organisational_unit_id\" or \"organisational_unit\".\"id\" = \"subject_euda\".\"organisational_unit_id\") join (select \"flow_classification_rule\".\"subject_entity_id\", \"flow_classification_rule\".\"subject_entity_kind\" from \"flow_classification_rule\" where \"flow_classification_rule\".\"id\" = ?) \"alias_51821639\" on (\"flow_classification_rule\".\"subject_entity_id\" = \"alias_51821639\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = \"alias_51821639\".\"subject_entity_kind\" and \"flow_classification_rule\".\"id\" <> ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindCompanionEntityRulesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#findCompanionDataTypeRules(long)}
   */
  @Test
  void testFindCompanionDataTypeRules() throws SQLException {
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
    Set<FlowClassificationRule> actualFindCompanionDataTypeRulesResult = (new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findCompanionDataTypeRules(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select case when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"organisational_unit\".\"name\" from \"organisational_unit\" where \"organisational_unit\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"flow_classification_rule\".\"parent_id\") end, case when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") end, \"organisational_unit\".\"id\", \"organisational_unit\".\"name\", \"flow_classification_rule\".\"id\", \"flow_classification_rule\".\"parent_kind\", \"flow_classification_rule\".\"parent_id\", \"flow_classification_rule\".\"subject_entity_id\", \"flow_classification_rule\".\"data_type_id\", \"flow_classification_rule\".\"flow_classification_id\", \"flow_classification_rule\".\"description\", \"flow_classification_rule\".\"external_id\", \"flow_classification_rule\".\"last_updated_at\", \"flow_classification_rule\".\"last_updated_by\", \"flow_classification_rule\".\"provenance\", \"flow_classification_rule\".\"is_readonly\", \"flow_classification_rule\".\"subject_entity_kind\", \"flow_classification_rule\".\"message\", \"flow_classification_rule\".\"message_severity\", \"flow_classification_rule\".\"direction\" from \"flow_classification_rule\" left outer join \"application\" \"subject_app\" on (\"subject_app\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"application\" \"subject_euda\" on (\"subject_euda\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"organisational_unit\" on (\"organisational_unit\".\"id\" = \"subject_app\".\"organisational_unit_id\" or \"organisational_unit\".\"id\" = \"subject_euda\".\"organisational_unit_id\") where (\"flow_classification_rule\".\"data_type_id\" in (select \"entity_hierarchy\".\"ancestor_id\" from \"flow_classification_rule\" join \"entity_hierarchy\" on (\"flow_classification_rule\".\"data_type_id\" = \"entity_hierarchy\".\"id\" and \"entity_hierarchy\".\"kind\" = ?) where \"flow_classification_rule\".\"id\" = ?) and \"flow_classification_rule\".\"id\" <> ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindCompanionDataTypeRulesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#findAppliedClassificationRulesForFlow(Long)}
   */
  @Test
  void testFindAppliedClassificationRulesForFlow() throws SQLException {
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
    Set<FlowClassificationRule> actualFindAppliedClassificationRulesForFlowResult = (new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAppliedClassificationRulesForFlow(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select case when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"organisational_unit\".\"name\" from \"organisational_unit\" where \"organisational_unit\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"flow_classification_rule\".\"parent_id\") end, case when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") end, \"organisational_unit\".\"id\", \"organisational_unit\".\"name\", \"flow_classification_rule\".\"id\", \"flow_classification_rule\".\"parent_kind\", \"flow_classification_rule\".\"parent_id\", \"flow_classification_rule\".\"subject_entity_id\", \"flow_classification_rule\".\"data_type_id\", \"flow_classification_rule\".\"flow_classification_id\", \"flow_classification_rule\".\"description\", \"flow_classification_rule\".\"external_id\", \"flow_classification_rule\".\"last_updated_at\", \"flow_classification_rule\".\"last_updated_by\", \"flow_classification_rule\".\"provenance\", \"flow_classification_rule\".\"is_readonly\", \"flow_classification_rule\".\"subject_entity_kind\", \"flow_classification_rule\".\"message\", \"flow_classification_rule\".\"message_severity\", \"flow_classification_rule\".\"direction\" from \"flow_classification_rule\" left outer join \"application\" \"subject_app\" on (\"subject_app\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"application\" \"subject_euda\" on (\"subject_euda\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"organisational_unit\" on (\"organisational_unit\".\"id\" = \"subject_app\".\"organisational_unit_id\" or \"organisational_unit\".\"id\" = \"subject_euda\".\"organisational_unit_id\") join \"logical_flow_decorator\" on \"logical_flow_decorator\".\"flow_classification_rule_id\" = \"flow_classification_rule\".\"id\" where \"logical_flow_decorator\".\"logical_flow_id\" = ? union select case when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"organisational_unit\".\"name\" from \"organisational_unit\" where \"organisational_unit\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"parent_id\") when \"flow_classification_rule\".\"parent_kind\" = ? then (select \"application_group\".\"name\" from \"application_group\" where \"application_group\".\"id\" = \"flow_classification_rule\".\"parent_id\") end, case when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"application\".\"name\" from \"application\" where \"application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"actor\".\"name\" from \"actor\" where \"actor\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") when \"flow_classification_rule\".\"subject_entity_kind\" = ? then (select \"end_user_application\".\"name\" from \"end_user_application\" where \"end_user_application\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\") end, \"organisational_unit\".\"id\", \"organisational_unit\".\"name\", \"flow_classification_rule\".\"id\", \"flow_classification_rule\".\"parent_kind\", \"flow_classification_rule\".\"parent_id\", \"flow_classification_rule\".\"subject_entity_id\", \"flow_classification_rule\".\"data_type_id\", \"flow_classification_rule\".\"flow_classification_id\", \"flow_classification_rule\".\"description\", \"flow_classification_rule\".\"external_id\", \"flow_classification_rule\".\"last_updated_at\", \"flow_classification_rule\".\"last_updated_by\", \"flow_classification_rule\".\"provenance\", \"flow_classification_rule\".\"is_readonly\", \"flow_classification_rule\".\"subject_entity_kind\", \"flow_classification_rule\".\"message\", \"flow_classification_rule\".\"message_severity\", \"flow_classification_rule\".\"direction\" from \"flow_classification_rule\" left outer join \"application\" \"subject_app\" on (\"subject_app\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"application\" \"subject_euda\" on (\"subject_euda\".\"id\" = \"flow_classification_rule\".\"subject_entity_id\" and \"flow_classification_rule\".\"subject_entity_kind\" = ?) left outer join \"organisational_unit\" on (\"organisational_unit\".\"id\" = \"subject_app\".\"organisational_unit_id\" or \"organisational_unit\".\"id\" = \"subject_euda\".\"organisational_unit_id\") join \"logical_flow_decorator\" on \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\" = \"flow_classification_rule\".\"id\" where \"logical_flow_decorator\".\"logical_flow_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAppliedClassificationRulesForFlowResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#updateDecoratorsWithClassifications(Set)}
   */
  @Test
  void testUpdateDecoratorsWithClassifications() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    int actualUpdateDecoratorsWithClassificationsResult = flowClassificationRuleDao
        .updateDecoratorsWithClassifications(new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(0, actualUpdateDecoratorsWithClassificationsResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#updateDecoratorsWithClassifications(Set)}
   */
  @Test
  void testUpdateDecoratorsWithClassifications2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    // Act
    int actualUpdateDecoratorsWithClassificationsResult = flowClassificationRuleDao
        .updateDecoratorsWithClassifications(new HashSet<>());

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    assertEquals(0, actualUpdateDecoratorsWithClassificationsResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#updateDecoratorsWithClassifications(Set)}
   */
  @Test
  void testUpdateDecoratorsWithClassifications3() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    HashSet<UpdateConditionStep<LogicalFlowDecoratorRecord>> updateStmts = new HashSet<>();
    updateStmts.add(mock(UpdateConditionStep.class));

    // Act
    int actualUpdateDecoratorsWithClassificationsResult = flowClassificationRuleDao
        .updateDecoratorsWithClassifications(updateStmts);

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    assertEquals(0, actualUpdateDecoratorsWithClassificationsResult);
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleDao#updateDecoratorsWithClassifications(Set)}
   */
  @Test
  void testUpdateDecoratorsWithClassifications4() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    HashSet<UpdateConditionStep<LogicalFlowDecoratorRecord>> updateStmts = new HashSet<>();
    updateStmts.add(mock(UpdateConditionStep.class));
    updateStmts.add(mock(UpdateConditionStep.class));

    // Act
    int actualUpdateDecoratorsWithClassificationsResult = flowClassificationRuleDao
        .updateDecoratorsWithClassifications(updateStmts);

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    assertEquals(0, actualUpdateDecoratorsWithClassificationsResult);
  }
}
