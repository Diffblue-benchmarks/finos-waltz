package org.finos.waltz.data.orphan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.orphan.ImmutableOrphanRelationship;
import org.finos.waltz.model.orphan.OrphanRelationship;
import org.finos.waltz.model.orphan.OrphanSide;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrphanDaoDiffblueTest {
  /**
   * Method under test: {@link OrphanDao#findApplicationsWithNonExistentOrgUnit()}
   */
  @Test
  void testFindApplicationsWithNonExistentOrgUnit() throws SQLException {
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
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<OrphanRelationship> actualFindApplicationsWithNonExistentOrgUnitResult = (new OrphanDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findApplicationsWithNonExistentOrgUnit();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"application\".\"id\", \"application\".\"name\", \"application\".\"organisational_unit_id\" from \"application\" where (\"application\".\"organisational_unit_id\" not in (select \"organisational_unit\".\"id\" from \"organisational_unit\") and \"application\".\"entity_lifecycle_status\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("ACTIVE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(2));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindApplicationsWithNonExistentOrgUnitResult.size());
    OrphanRelationship getResult = actualFindApplicationsWithNonExistentOrgUnitResult.get(0);
    EntityReference entityAResult = getResult.entityA();
    assertTrue(entityAResult instanceof ImmutableEntityReference);
    EntityReference entityBResult = getResult.entityB();
    assertTrue(entityBResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableOrphanRelationship);
    OrphanRelationship getResult2 = actualFindApplicationsWithNonExistentOrgUnitResult.get(1);
    assertTrue(getResult2 instanceof ImmutableOrphanRelationship);
    assertNull(entityAResult.description());
    assertNull(entityBResult.description());
    assertEquals(1L, entityAResult.id());
    assertEquals(1L, entityBResult.id());
    assertEquals(EntityKind.APPLICATION, entityAResult.kind());
    assertEquals(EntityKind.ORG_UNIT, entityBResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityAResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityBResult.entityLifecycleStatus());
    assertEquals(OrphanSide.A, getResult.orphanSide());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link OrphanDao#findOrphanMeasurableRatings()}
   */
  @Test
  void testFindOrphanMeasurableRatings() throws SQLException {
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
    List<OrphanRelationship> actualFindOrphanMeasurableRatingsResult = (new OrphanDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findOrphanMeasurableRatings();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(2, actualFindOrphanMeasurableRatingsResult.size());
    OrphanRelationship getResult = actualFindOrphanMeasurableRatingsResult.get(0);
    EntityReference entityAResult = getResult.entityA();
    assertTrue(entityAResult instanceof ImmutableEntityReference);
    EntityReference entityBResult = getResult.entityB();
    assertTrue(entityBResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableOrphanRelationship);
    OrphanRelationship getResult2 = actualFindOrphanMeasurableRatingsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableOrphanRelationship);
    assertNull(entityAResult.description());
    assertNull(entityBResult.description());
    assertEquals(1L, entityAResult.id());
    assertEquals(1L, entityBResult.id());
    assertEquals(EntityKind.APPLICATION, entityBResult.kind());
    assertEquals(EntityKind.MEASURABLE, entityAResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityAResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityBResult.entityLifecycleStatus());
    assertEquals(OrphanSide.B, getResult.orphanSide());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link OrphanDao#findOrphanMeasurableRatings()}
   */
  @Test
  void testFindOrphanMeasurableRatings2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
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
    List<OrphanRelationship> actualFindOrphanMeasurableRatingsResult = (new OrphanDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findOrphanMeasurableRatings();

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet, atLeast(1)).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet, atLeast(1)).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertEquals(1, actualFindOrphanMeasurableRatingsResult.size());
    OrphanRelationship getResult = actualFindOrphanMeasurableRatingsResult.get(0);
    EntityReference entityAResult = getResult.entityA();
    assertTrue(entityAResult instanceof ImmutableEntityReference);
    EntityReference entityBResult = getResult.entityB();
    assertTrue(entityBResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableOrphanRelationship);
    assertNull(entityAResult.description());
    assertNull(entityBResult.description());
    assertEquals(1L, entityAResult.id());
    assertEquals(1L, entityBResult.id());
    assertEquals(EntityKind.APPLICATION, entityBResult.kind());
    assertEquals(EntityKind.MEASURABLE, entityAResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityAResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityBResult.entityLifecycleStatus());
    assertEquals(OrphanSide.A, getResult.orphanSide());
  }

  /**
   * Method under test:
   * {@link OrphanDao#findOrphanFlowClassificationRulesByOrgUnit()}
   */
  @Test
  void testFindOrphanFlowClassificationRulesByOrgUnit() throws SQLException {
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
    List<OrphanRelationship> actualFindOrphanFlowClassificationRulesByOrgUnitResult = (new OrphanDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findOrphanFlowClassificationRulesByOrgUnit();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"flow_classification_rule\".\"id\", \"flow_classification_rule\".\"parent_id\" from \"flow_classification_rule\" where (\"flow_classification_rule\".\"parent_id\" not in (select \"organisational_unit\".\"id\" from \"organisational_unit\") and \"flow_classification_rule\".\"parent_kind\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("ORG_UNIT"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindOrphanFlowClassificationRulesByOrgUnitResult.size());
    OrphanRelationship getResult = actualFindOrphanFlowClassificationRulesByOrgUnitResult.get(0);
    EntityReference entityAResult = getResult.entityA();
    assertTrue(entityAResult instanceof ImmutableEntityReference);
    EntityReference entityBResult = getResult.entityB();
    assertTrue(entityBResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableOrphanRelationship);
    OrphanRelationship getResult2 = actualFindOrphanFlowClassificationRulesByOrgUnitResult.get(1);
    assertTrue(getResult2 instanceof ImmutableOrphanRelationship);
    assertNull(entityAResult.description());
    assertNull(entityBResult.description());
    assertEquals(1L, entityAResult.id());
    assertEquals(1L, entityBResult.id());
    assertEquals(EntityKind.FLOW_CLASSIFICATION_RULE, entityAResult.kind());
    assertEquals(EntityKind.ORG_UNIT, entityBResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityAResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityBResult.entityLifecycleStatus());
    assertEquals(OrphanSide.A, getResult.orphanSide());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link OrphanDao#findOrphanFlowClassificationRulesByApp()}
   */
  @Test
  void testFindOrphanFlowClassificationRulesByApp() throws SQLException {
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
    List<OrphanRelationship> actualFindOrphanFlowClassificationRulesByAppResult = (new OrphanDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findOrphanFlowClassificationRulesByApp();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"flow_classification_rule\".\"id\", \"flow_classification_rule\".\"subject_entity_id\" from \"flow_classification_rule\" where ((\"flow_classification_rule\".\"subject_entity_id\" not in (select \"application\".\"id\" from \"application\" where \"application\".\"entity_lifecycle_status\" = ?) and \"flow_classification_rule\".\"subject_entity_kind\" = ?) or (\"flow_classification_rule\".\"subject_entity_id\" not in (select \"actor\".\"id\" from \"actor\") and \"flow_classification_rule\".\"subject_entity_kind\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindOrphanFlowClassificationRulesByAppResult.size());
    OrphanRelationship getResult = actualFindOrphanFlowClassificationRulesByAppResult.get(0);
    EntityReference entityAResult = getResult.entityA();
    assertTrue(entityAResult instanceof ImmutableEntityReference);
    EntityReference entityBResult = getResult.entityB();
    assertTrue(entityBResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableOrphanRelationship);
    OrphanRelationship getResult2 = actualFindOrphanFlowClassificationRulesByAppResult.get(1);
    assertTrue(getResult2 instanceof ImmutableOrphanRelationship);
    assertNull(entityAResult.description());
    assertNull(entityBResult.description());
    assertEquals(1L, entityAResult.id());
    assertEquals(1L, entityBResult.id());
    assertEquals(EntityKind.APPLICATION, entityBResult.kind());
    assertEquals(EntityKind.FLOW_CLASSIFICATION_RULE, entityAResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityAResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityBResult.entityLifecycleStatus());
    assertEquals(OrphanSide.A, getResult.orphanSide());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test:
   * {@link OrphanDao#findOrphanFlowClassificationRulesByDataType()}
   */
  @Test
  void testFindOrphanFlowClassificationRulesByDataType() throws SQLException {
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<OrphanRelationship> actualFindOrphanFlowClassificationRulesByDataTypeResult = (new OrphanDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findOrphanFlowClassificationRulesByDataType();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"flow_classification_rule\".\"id\", \"data_type\".\"id\", \"data_type\".\"code\" from \"flow_classification_rule\" left outer join \"data_type\" on \"flow_classification_rule\".\"data_type_id\" = \"data_type\".\"id\" where \"flow_classification_rule\".\"data_type_id\" not in (select \"data_type\".\"id\" from \"data_type\")"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(3));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindOrphanFlowClassificationRulesByDataTypeResult.size());
    OrphanRelationship getResult = actualFindOrphanFlowClassificationRulesByDataTypeResult.get(0);
    EntityReference entityAResult = getResult.entityA();
    assertTrue(entityAResult instanceof ImmutableEntityReference);
    EntityReference entityBResult = getResult.entityB();
    assertTrue(entityBResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableOrphanRelationship);
    OrphanRelationship getResult2 = actualFindOrphanFlowClassificationRulesByDataTypeResult.get(1);
    assertTrue(getResult2 instanceof ImmutableOrphanRelationship);
    assertNull(entityAResult.description());
    assertNull(entityBResult.description());
    assertEquals(1L, entityAResult.id());
    assertEquals(1L, entityBResult.id());
    assertEquals(EntityKind.DATA_TYPE, entityBResult.kind());
    assertEquals(EntityKind.FLOW_CLASSIFICATION_RULE, entityAResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityAResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityBResult.entityLifecycleStatus());
    assertEquals(OrphanSide.A, getResult.orphanSide());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link OrphanDao#findOrphanChangeInitiatives()}
   */
  @Test
  void testFindOrphanChangeInitiatives() throws SQLException {
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
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<OrphanRelationship> actualFindOrphanChangeInitiativesResult = (new OrphanDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findOrphanChangeInitiatives();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"change_initiative\".\"id\", \"change_initiative\".\"parent_id\" from \"change_initiative\" where \"change_initiative\".\"parent_id\" not in (select \"change_initiative\".\"id\" from \"change_initiative\")"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindOrphanChangeInitiativesResult.size());
    OrphanRelationship getResult = actualFindOrphanChangeInitiativesResult.get(0);
    EntityReference entityAResult = getResult.entityA();
    assertTrue(entityAResult instanceof ImmutableEntityReference);
    EntityReference entityBResult = getResult.entityB();
    assertTrue(entityBResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableOrphanRelationship);
    OrphanRelationship getResult2 = actualFindOrphanChangeInitiativesResult.get(1);
    assertTrue(getResult2 instanceof ImmutableOrphanRelationship);
    assertNull(entityAResult.description());
    assertEquals(1L, entityAResult.id());
    assertEquals(EntityKind.CHANGE_INITIATIVE, entityAResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityAResult.entityLifecycleStatus());
    assertEquals(OrphanSide.A, getResult.orphanSide());
    assertEquals(entityAResult, entityBResult);
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link OrphanDao#findOrphanLogicalDataFlows()}
   */
  @Test
  void testFindOrphanLogicalDataFlows() throws SQLException {
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
    List<OrphanRelationship> actualFindOrphanLogicalDataFlowsResult = (new OrphanDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findOrphanLogicalDataFlows();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow\".\"id\", \"logical_flow\".\"source_entity_id\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_id\" not in (select \"application\".\"id\" from \"application\" where \"application\".\"entity_lifecycle_status\" = ?) and \"logical_flow\".\"entity_lifecycle_status\" <> ? and \"logical_flow\".\"source_entity_kind\" = ?) union all select \"logical_flow\".\"id\", \"logical_flow\".\"target_entity_id\" from \"logical_flow\" where (\"logical_flow\".\"target_entity_id\" not in (select \"application\".\"id\" from \"application\" where \"application\".\"entity_lifecycle_status\" = ?) and \"logical_flow\".\"entity_lifecycle_status\" <> ? and \"logical_flow\".\"target_entity_kind\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindOrphanLogicalDataFlowsResult.size());
    OrphanRelationship getResult = actualFindOrphanLogicalDataFlowsResult.get(0);
    EntityReference entityAResult = getResult.entityA();
    assertTrue(entityAResult instanceof ImmutableEntityReference);
    EntityReference entityBResult = getResult.entityB();
    assertTrue(entityBResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableOrphanRelationship);
    OrphanRelationship getResult2 = actualFindOrphanLogicalDataFlowsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableOrphanRelationship);
    assertNull(entityAResult.description());
    assertNull(entityBResult.description());
    assertEquals(1L, entityAResult.id());
    assertEquals(1L, entityBResult.id());
    assertEquals(EntityKind.APPLICATION, entityBResult.kind());
    assertEquals(EntityKind.LOGICAL_DATA_FLOW, entityAResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityAResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityBResult.entityLifecycleStatus());
    assertEquals(OrphanSide.A, getResult.orphanSide());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link OrphanDao#findOrphanAttestatations()}
   */
  @Test
  void testFindOrphanAttestatations() throws SQLException {
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
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<OrphanRelationship> actualFindOrphanAttestatationsResult = (new OrphanDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findOrphanAttestatations();

    // Assert
    verify(connection).prepareStatement(eq(
        "select distinct \"attestation_instance\".\"id\", \"attestation_instance\".\"parent_entity_id\" from \"attestation_instance\" left outer join \"application\" on (\"application\".\"id\" = \"attestation_instance\".\"parent_entity_id\" and \"attestation_instance\".\"parent_entity_kind\" = ?) where (\"attestation_instance\".\"attested_at\" is null and (\"application\".\"id\" is null or \"application\".\"entity_lifecycle_status\" = ? or \"application\".\"is_removed\" = ?))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(3), eq(true));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindOrphanAttestatationsResult.size());
    OrphanRelationship getResult = actualFindOrphanAttestatationsResult.get(0);
    EntityReference entityAResult = getResult.entityA();
    assertTrue(entityAResult instanceof ImmutableEntityReference);
    EntityReference entityBResult = getResult.entityB();
    assertTrue(entityBResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableOrphanRelationship);
    OrphanRelationship getResult2 = actualFindOrphanAttestatationsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableOrphanRelationship);
    assertNull(entityAResult.description());
    assertNull(entityBResult.description());
    assertEquals(1L, entityAResult.id());
    assertEquals(1L, entityBResult.id());
    assertEquals(EntityKind.APPLICATION, entityBResult.kind());
    assertEquals(EntityKind.ATTESTATION, entityAResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityAResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityBResult.entityLifecycleStatus());
    assertEquals(OrphanSide.A, getResult.orphanSide());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test: {@link OrphanDao#findOrphanPhysicalFlows()}
   */
  @Test
  void testFindOrphanPhysicalFlows() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<OrphanRelationship> actualFindOrphanPhysicalFlowsResult = (new OrphanDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findOrphanPhysicalFlows();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"physical_flow\".\"id\", \"physical_flow\".\"logical_flow_id\", ? from \"physical_flow\" where (\"physical_flow\".\"logical_flow_id\" not in (select \"logical_flow\".\"id\" from \"logical_flow\" where \"logical_flow\".\"entity_lifecycle_status\" <> ?) and \"physical_flow\".\"is_removed\" = ?) union all select \"physical_flow\".\"id\", \"physical_flow\".\"id\", ? from \"physical_flow\" where (\"physical_flow\".\"specification_id\" not in (select \"physical_specification\".\"id\" from \"physical_specification\" where \"physical_specification\".\"is_removed\" = ?) and \"physical_flow\".\"is_removed\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setBoolean(anyInt(), eq(false));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindOrphanPhysicalFlowsResult.isEmpty());
  }
}
