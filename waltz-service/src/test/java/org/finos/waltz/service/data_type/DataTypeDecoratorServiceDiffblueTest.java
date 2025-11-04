package org.finos.waltz.service.data_type;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.any;
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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.datatype_decorator.DataTypeDecoratorDaoSelectorFactory;
import org.finos.waltz.data.datatype_decorator.LogicalFlowDecoratorDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.AssessmentsView;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.datatype.DataTypeDecoratorRatingCharacteristics;
import org.finos.waltz.model.datatype.DataTypeUsageCharacteristics;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator;
import org.finos.waltz.model.datatype.ImmutableDataTypeUsageCharacteristics;
import org.finos.waltz.model.flow_classification.FlowClassification;
import org.finos.waltz.model.logical_flow.DataTypeDecoratorView;
import org.finos.waltz.model.logical_flow.FlowClassificationRulesView;
import org.finos.waltz.model.logical_flow.ImmutableDataTypeDecoratorView;
import org.finos.waltz.schema.tables.records.LogicalFlowDecoratorRecord;
import org.finos.waltz.service.assessment_definition.AssessmentDefinitionService;
import org.finos.waltz.service.assessment_rating.AssessmentRatingService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.data_flow_decorator.LogicalFlowDecoratorRatingsCalculator;
import org.finos.waltz.service.data_flow_decorator.LogicalFlowDecoratorService;
import org.finos.waltz.service.flow_classification_rule.FlowClassificationRuleService;
import org.finos.waltz.service.flow_classification_rule.FlowClassificationService;
import org.finos.waltz.service.logical_flow.LogicalFlowService;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.usage_info.DataTypeUsageService;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataTypeDecoratorServiceDiffblueTest {
  /**
   * Method under test:
   * {@link DataTypeDecoratorService#getByEntityRefAndDataTypeId(EntityReference, long)}
   */
  @Test
  void testGetByEntityRefAndDataTypeId() throws SQLException {
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
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(connection, SQLDialect.SQL99)));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(mock(ChangeLogService.class),
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference reference = mock(EntityReference.class);
    when(reference.id()).thenReturn(1L);
    when(reference.kind()).thenReturn(EntityKind.ALL);

    // Act
    DataTypeDecorator actualByEntityRefAndDataTypeId = dataTypeDecoratorService.getByEntityRefAndDataTypeId(reference,
        1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\", \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\", \"logical_flow_decorator\".\"provenance\", \"logical_flow_decorator\".\"last_updated_at\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"flow_classification_rule_id\", \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\", \"logical_flow_decorator\".\"target_inbound_rating\", case when \"logical_flow_decorator\".\"decorator_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\") end from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ? and \"logical_flow_decorator\".\"decorator_entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(reference).id();
    verify(reference).kind();
    assertNull(actualByEntityRefAndDataTypeId);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#getByEntityRefAndDataTypeId(EntityReference, long)}
   */
  @Test
  void testGetByEntityRefAndDataTypeId2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(timestamp.toLocalDateTime()).thenReturn(ofResult.atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(connection, SQLDialect.SQL99)));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(mock(ChangeLogService.class),
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference reference = mock(EntityReference.class);
    when(reference.id()).thenReturn(1L);
    when(reference.kind()).thenReturn(EntityKind.ALL);

    // Act
    DataTypeDecorator actualByEntityRefAndDataTypeId = dataTypeDecoratorService.getByEntityRefAndDataTypeId(reference,
        1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\", \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\", \"logical_flow_decorator\".\"provenance\", \"logical_flow_decorator\".\"last_updated_at\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"flow_classification_rule_id\", \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\", \"logical_flow_decorator\".\"target_inbound_rating\", case when \"logical_flow_decorator\".\"decorator_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\") end from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ? and \"logical_flow_decorator\".\"decorator_entity_id\" = ?)"));
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(9));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(6));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp).toLocalDateTime();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(reference).id();
    verify(reference).kind();
    EntityReference entityReferenceResult = actualByEntityRefAndDataTypeId.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    EntityReference decoratorEntityResult = actualByEntityRefAndDataTypeId.decoratorEntity();
    assertTrue(decoratorEntityResult instanceof ImmutableEntityReference);
    assertTrue(actualByEntityRefAndDataTypeId instanceof ImmutableDataTypeDecorator);
    LocalDateTime lastUpdatedAtResult = actualByEntityRefAndDataTypeId.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("String", actualByEntityRefAndDataTypeId.lastUpdatedBy());
    assertEquals("String", actualByEntityRefAndDataTypeId.provenance());
    assertNull(entityReferenceResult.description());
    assertNull(decoratorEntityResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, decoratorEntityResult.id());
    assertEquals(1L, actualByEntityRefAndDataTypeId.dataFlowId());
    assertEquals(1L, actualByEntityRefAndDataTypeId.dataTypeId());
    assertEquals(EntityKind.DATA_TYPE, decoratorEntityResult.kind());
    assertEquals(EntityKind.LOGICAL_DATA_FLOW, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult.entityLifecycleStatus());
    assertTrue(actualByEntityRefAndDataTypeId.isReadonly());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#getByEntityRefAndDataTypeId(EntityReference, long)}
   */
  @Test
  void testGetByEntityRefAndDataTypeId3() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.getByEntityIdAndDataTypeId(anyLong(), anyLong())).thenReturn(null);
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any())).thenReturn(logicalFlowDecoratorDao);
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(mock(ChangeLogService.class),
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference reference = mock(EntityReference.class);
    when(reference.id()).thenReturn(1L);
    when(reference.kind()).thenReturn(EntityKind.ALL);

    // Act
    DataTypeDecorator actualByEntityRefAndDataTypeId = dataTypeDecoratorService.getByEntityRefAndDataTypeId(reference,
        1L);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(logicalFlowDecoratorDao).getByEntityIdAndDataTypeId(eq(1L), eq(1L));
    verify(reference).id();
    verify(reference).kind();
    assertNull(actualByEntityRefAndDataTypeId);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#findByEntityId(EntityReference)}
   */
  @Test
  void testFindByEntityId() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(timestamp.toLocalDateTime()).thenReturn(ofResult.atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(connection, SQLDialect.SQL99)));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(mock(ChangeLogService.class),
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference reference = mock(EntityReference.class);
    when(reference.id()).thenReturn(1L);
    when(reference.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<DataTypeDecorator> actualFindByEntityIdResult = dataTypeDecoratorService.findByEntityId(reference);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\", \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\", \"logical_flow_decorator\".\"provenance\", \"logical_flow_decorator\".\"last_updated_at\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"flow_classification_rule_id\", \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\", \"logical_flow_decorator\".\"target_inbound_rating\", case when \"logical_flow_decorator\".\"decorator_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\") end from \"logical_flow_decorator\" where \"logical_flow_decorator\".\"logical_flow_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(9));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(6));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(reference).id();
    verify(reference).kind();
    assertEquals(2, actualFindByEntityIdResult.size());
    DataTypeDecorator getResult = actualFindByEntityIdResult.get(0);
    EntityReference entityReferenceResult = getResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    EntityReference decoratorEntityResult = getResult.decoratorEntity();
    assertTrue(decoratorEntityResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableDataTypeDecorator);
    DataTypeDecorator getResult2 = actualFindByEntityIdResult.get(1);
    assertTrue(getResult2 instanceof ImmutableDataTypeDecorator);
    LocalDateTime lastUpdatedAtResult = getResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("String", getResult.lastUpdatedBy());
    assertEquals("String", getResult.provenance());
    assertNull(entityReferenceResult.description());
    assertNull(decoratorEntityResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, decoratorEntityResult.id());
    assertEquals(1L, getResult.dataFlowId());
    assertEquals(1L, getResult.dataTypeId());
    assertEquals(EntityKind.DATA_TYPE, decoratorEntityResult.kind());
    assertEquals(EntityKind.LOGICAL_DATA_FLOW, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, decoratorEntityResult.entityLifecycleStatus());
    assertTrue(getResult.isReadonly());
    assertEquals(getResult, getResult2);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind, IdSelectionOptions)}
   */
  @Test
  void testFindByEntityIdSelector() {
    // Arrange
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new DataTypeDecoratorService(mock(ChangeLogService.class), mock(LogicalFlowDecoratorService.class),
            dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class), mock(LogicalFlowService.class),
            mock(LogicalFlowDecoratorRatingsCalculator.class), mock(DataTypeUsageService.class),
            mock(DataTypeService.class), mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationService.class),
            mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class),
            mock(RatingSchemeService.class), mock(FlowClassificationService.class),
            mock(FlowClassificationRuleService.class))).findByEntityIdSelector(EntityKind.ALL,
                mock(IdSelectionOptions.class)));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}
   */
  @Test
  void testAddDecorators() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99)));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(changeLogService,
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    int[] actualAddDecoratorsResult = dataTypeDecoratorService.addDecorators("janedoe", entityReference,
        new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertNull(actualAddDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}
   */
  @Test
  void testAddDecorators2() throws SQLException {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(connection, SQLDialect.SQL99)));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(changeLogService,
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    int[] actualAddDecoratorsResult = dataTypeDecoratorService.addDecorators("janedoe", entityReference,
        new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualAddDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}
   */
  @Test
  void testAddDecorators3() throws DataAccessException {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[]{1, -1, 1, -1});
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.batch((Query[]) any())).thenReturn(batch);
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(changeLogService,
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    int[] actualAddDecoratorsResult = dataTypeDecoratorService.addDecorators("janedoe", entityReference,
        new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(batch).execute();
    verify(dsl).batch((Query[]) any());
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualAddDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}
   */
  @Test
  void testAddDecorators4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[]{2, 1, 2, 1});
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any())).thenReturn(logicalFlowDecoratorDao);
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(changeLogService,
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    int[] actualAddDecoratorsResult = dataTypeDecoratorService.addDecorators("janedoe", entityReference,
        new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertArrayEquals(new int[]{2, 1, 2, 1}, actualAddDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}
   */
  @Test
  void testAddDecorators5() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[]{2, 1, 2, 1});
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any())).thenReturn(logicalFlowDecoratorDao);
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(changeLogService,
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(15L);

    // Act
    int[] actualAddDecoratorsResult = dataTypeDecoratorService.addDecorators("janedoe", entityReference, dataTypeIds);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertArrayEquals(new int[]{2, 1, 2, 1}, actualAddDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}
   */
  @Test
  void testAddDecorators6() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[]{2, 1, 2, 1});
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any())).thenReturn(logicalFlowDecoratorDao);
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(changeLogService,
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(-3L);
    dataTypeIds.add(15L);

    // Act
    int[] actualAddDecoratorsResult = dataTypeDecoratorService.addDecorators("janedoe", entityReference, dataTypeIds);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertArrayEquals(new int[]{2, 1, 2, 1}, actualAddDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}
   */
  @Test
  void testAddDecorators7() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[]{2, 1, 2, 1});
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any())).thenReturn(logicalFlowDecoratorDao);
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(changeLogService,
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new UnsupportedOperationException("userName cannot be null"));
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(15L);

    // Act
    int[] actualAddDecoratorsResult = dataTypeDecoratorService.addDecorators("janedoe", entityReference, dataTypeIds);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(logicalFlowDecoratorDao).addDecorators((Collection<DataTypeDecorator>) isNull());
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertArrayEquals(new int[]{2, 1, 2, 1}, actualAddDecoratorsResult);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#removeDataTypeDecorator(String, EntityReference, Set)}
   */
  @Test
  void testRemoveDataTypeDecorator() throws SQLException {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(connection, SQLDialect.SQL99)));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(changeLogService,
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    int actualRemoveDataTypeDecoratorResult = dataTypeDecoratorService.removeDataTypeDecorator("janedoe",
        entityReference, new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "delete from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ? and \"logical_flow_decorator\".\"decorator_entity_id\" in () and \"logical_flow_decorator\".\"is_readonly\" = false)"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(preparedStatement).setString(eq(2), eq("DATA_TYPE"));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(0, actualRemoveDataTypeDecoratorResult);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#removeDataTypeDecorator(String, EntityReference, Set)}
   */
  @Test
  void testRemoveDataTypeDecorator2() throws DataAccessException {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);
    DeleteUsingStep<LogicalFlowDecoratorRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<LogicalFlowDecoratorRecord>>any())).thenReturn(deleteUsingStep);
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(changeLogService,
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    int actualRemoveDataTypeDecoratorResult = dataTypeDecoratorService.removeDataTypeDecorator("janedoe",
        entityReference, new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualRemoveDataTypeDecoratorResult);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#removeDataTypeDecorator(String, EntityReference, Set)}
   */
  @Test
  void testRemoveDataTypeDecorator3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.removeDataTypes(Mockito.<EntityReference>any(), Mockito.<Collection<Long>>any()))
        .thenReturn(1);
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any())).thenReturn(logicalFlowDecoratorDao);
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(changeLogService,
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    int actualRemoveDataTypeDecoratorResult = dataTypeDecoratorService.removeDataTypeDecorator("janedoe",
        entityReference, new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(logicalFlowDecoratorDao).removeDataTypes(isA(EntityReference.class), isA(Collection.class));
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualRemoveDataTypeDecoratorResult);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#findByFlowIds(Collection, EntityKind)}
   */
  @Test
  void testFindByFlowIds() {
    // Arrange
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(mock(ChangeLogService.class),
        mock(LogicalFlowDecoratorService.class), mock(DataTypeDecoratorDaoSelectorFactory.class),
        mock(LogicalFlowDao.class), mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));

    // Act and Assert
    assertTrue(dataTypeDecoratorService.findByFlowIds(new ArrayList<>(), EntityKind.ALL).isEmpty());
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#findByFlowIds(Collection, EntityKind)}
   */
  @Test
  void testFindByFlowIds2() {
    // Arrange, Act and Assert
    assertTrue((new DataTypeDecoratorService(mock(ChangeLogService.class), mock(LogicalFlowDecoratorService.class),
        mock(DataTypeDecoratorDaoSelectorFactory.class), mock(LogicalFlowDao.class), mock(LogicalFlowService.class),
        mock(LogicalFlowDecoratorRatingsCalculator.class), mock(DataTypeUsageService.class),
        mock(DataTypeService.class), mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationService.class),
        mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class),
        mock(FlowClassificationService.class), mock(FlowClassificationRuleService.class)))
            .findByFlowIds(null, EntityKind.PHYSICAL_SPECIFICATION)
            .isEmpty());
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#findByFlowIds(Collection, EntityKind)}
   */
  @Test
  void testFindByFlowIds3() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
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
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(connection, SQLDialect.SQL99)));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(mock(ChangeLogService.class),
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Set<DataTypeDecorator> actualFindByFlowIdsResult = dataTypeDecoratorService.findByFlowIds(ids, EntityKind.ALL);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\", \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\", \"logical_flow_decorator\".\"provenance\", \"logical_flow_decorator\".\"last_updated_at\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"flow_classification_rule_id\", \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\", \"logical_flow_decorator\".\"target_inbound_rating\", case when \"logical_flow_decorator\".\"decorator_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\") end from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" in (1))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(9));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(6));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    assertEquals(1, actualFindByFlowIdsResult.size());
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#findDatatypeUsageCharacteristics(EntityReference)}
   */
  @Test
  void testFindDatatypeUsageCharacteristics() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(connection, SQLDialect.SQL99)));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(mock(ChangeLogService.class),
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Collection<DataTypeUsageCharacteristics> actualFindDatatypeUsageCharacteristicsResult = dataTypeDecoratorService
        .findDatatypeUsageCharacteristics(ref);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"provenance\", count(distinct case when \"physical_spec_data_type\".\"data_type_id\" is not null then \"physical_flow\".\"id\" end) \"numberOfFlowsSharingDatatype\" from \"logical_flow\" join \"logical_flow_decorator\" on (\"logical_flow\".\"id\" = \"logical_flow_decorator\".\"logical_flow_id\" and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?) left outer join \"physical_flow\" on (\"physical_flow\".\"logical_flow_id\" = \"logical_flow\".\"id\" and \"physical_flow\".\"is_removed\" = false and \"physical_flow\".\"entity_lifecycle_status\" <> ?) left outer join \"physical_spec_data_type\" on (\"physical_flow\".\"specification_id\" = \"physical_spec_data_type\".\"specification_id\" and \"physical_spec_data_type\".\"data_type_id\" = \"logical_flow_decorator\".\"decorator_entity_id\") where \"logical_flow\".\"id\" = ? group by \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"provenance\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(2));
    verify(resultSet, atLeast(1)).getInt(eq(5));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(ref).id();
    verify(ref).kind();
    assertTrue(actualFindDatatypeUsageCharacteristicsResult instanceof List);
    assertEquals(2, actualFindDatatypeUsageCharacteristicsResult.size());
    DataTypeUsageCharacteristics getResult = ((List<DataTypeUsageCharacteristics>) actualFindDatatypeUsageCharacteristicsResult)
        .get(0);
    assertTrue(getResult instanceof ImmutableDataTypeUsageCharacteristics);
    DataTypeUsageCharacteristics getResult2 = ((List<DataTypeUsageCharacteristics>) actualFindDatatypeUsageCharacteristicsResult)
        .get(1);
    assertTrue(getResult2 instanceof ImmutableDataTypeUsageCharacteristics);
    assertEquals("Warning:\n"
        + "- Cannot be removed as used in 1 physical flows. The data type mappings on these must be removed"
        + " first\n" + "- Marked as readonly - <span title='last edited by / provenance' class='text-muted'>String /"
        + " String</span>\n", getResult.warningMessageForEditors());
    assertEquals(
        "Warning:\n" + "- Marked as readonly - <span title='last edited by / provenance' class='text-muted'>String /"
            + " String</span>\n",
        getResult.warningMessageForViewers());
    assertEquals(1L, getResult.dataTypeId());
    assertFalse(getResult.isRemovable());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#findDatatypeUsageCharacteristics(EntityReference)}
   */
  @Test
  void testFindDatatypeUsageCharacteristics2() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getInt(anyInt())).thenReturn(-1);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(connection, SQLDialect.SQL99)));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(mock(ChangeLogService.class),
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Collection<DataTypeUsageCharacteristics> actualFindDatatypeUsageCharacteristicsResult = dataTypeDecoratorService
        .findDatatypeUsageCharacteristics(ref);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"provenance\", count(distinct case when \"physical_spec_data_type\".\"data_type_id\" is not null then \"physical_flow\".\"id\" end) \"numberOfFlowsSharingDatatype\" from \"logical_flow\" join \"logical_flow_decorator\" on (\"logical_flow\".\"id\" = \"logical_flow_decorator\".\"logical_flow_id\" and \"logical_flow_decorator\".\"decorator_entity_kind\" = ?) left outer join \"physical_flow\" on (\"physical_flow\".\"logical_flow_id\" = \"logical_flow\".\"id\" and \"physical_flow\".\"is_removed\" = false and \"physical_flow\".\"entity_lifecycle_status\" <> ?) left outer join \"physical_spec_data_type\" on (\"physical_flow\".\"specification_id\" = \"physical_spec_data_type\".\"specification_id\" and \"physical_spec_data_type\".\"data_type_id\" = \"logical_flow_decorator\".\"decorator_entity_id\") where \"logical_flow\".\"id\" = ? group by \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"provenance\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(3), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(2));
    verify(resultSet, atLeast(1)).getInt(eq(5));
    verify(resultSet, atLeast(1)).getLong(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(ref).id();
    verify(ref).kind();
    assertTrue(actualFindDatatypeUsageCharacteristicsResult instanceof List);
    assertEquals(2, actualFindDatatypeUsageCharacteristicsResult.size());
    DataTypeUsageCharacteristics getResult = ((List<DataTypeUsageCharacteristics>) actualFindDatatypeUsageCharacteristicsResult)
        .get(0);
    assertTrue(getResult instanceof ImmutableDataTypeUsageCharacteristics);
    DataTypeUsageCharacteristics getResult2 = ((List<DataTypeUsageCharacteristics>) actualFindDatatypeUsageCharacteristicsResult)
        .get(1);
    assertTrue(getResult2 instanceof ImmutableDataTypeUsageCharacteristics);
    assertEquals(
        "Warning:\n" + "- Marked as readonly - <span title='last edited by / provenance' class='text-muted'>String /"
            + " String</span>\n",
        getResult.warningMessageForEditors());
    assertEquals(
        "Warning:\n" + "- Marked as readonly - <span title='last edited by / provenance' class='text-muted'>String /"
            + " String</span>\n",
        getResult.warningMessageForViewers());
    assertEquals(1L, getResult.dataTypeId());
    assertFalse(getResult.isRemovable());
    assertEquals(getResult, getResult2);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}
   */
  @Test
  void testGetDecoratorView() {
    // Arrange
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99)));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(mock(ChangeLogService.class),
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class), mock(FlowClassificationService.class),
        mock(FlowClassificationRuleService.class));
    EntityReference parentEntityRef = mock(EntityReference.class);
    when(parentEntityRef.id()).thenThrow(new UnsupportedOperationException("entityReference"));
    when(parentEntityRef.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeDecoratorService.getDecoratorView(parentEntityRef));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(parentEntityRef).id();
    verify(parentEntityRef, atLeast(1)).kind();
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}
   */
  @Test
  void testGetDecoratorView2() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(connection, SQLDialect.SQL99)));
    DataTypeService dataTypeService = mock(DataTypeService.class);
    when(dataTypeService.findByIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(new HashSet<>());
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(Mockito.<EntityKind>any(),
        Mockito.<IdSelectionOptions>any())).thenReturn(mock(AssessmentsView.class));
    FlowClassificationService flowClassificationService = mock(FlowClassificationService.class);
    when(flowClassificationService.findAll()).thenReturn(new HashSet<>());
    FlowClassificationRuleService flowClassificationRuleService = mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.getFlowClassificationsViewForFlow(anyLong()))
        .thenReturn(mock(FlowClassificationRulesView.class));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(mock(ChangeLogService.class),
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), dataTypeService, mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), assessmentRatingService, mock(AssessmentDefinitionService.class),
        mock(RatingSchemeService.class), flowClassificationService, flowClassificationRuleService);
    EntityReference parentEntityRef = mock(EntityReference.class);
    when(parentEntityRef.id()).thenReturn(1L);
    when(parentEntityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    DataTypeDecoratorView actualDecoratorView = dataTypeDecoratorService.getDecoratorView(parentEntityRef);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\", \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\", \"logical_flow_decorator\".\"provenance\", \"logical_flow_decorator\".\"last_updated_at\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"flow_classification_rule_id\", \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\", \"logical_flow_decorator\".\"target_inbound_rating\", case when \"logical_flow_decorator\".\"decorator_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\") end from \"logical_flow_decorator\" where \"logical_flow_decorator\".\"logical_flow_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(9));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(6));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(parentEntityRef, atLeast(1)).id();
    verify(parentEntityRef, atLeast(1)).kind();
    verify(assessmentRatingService).getPrimaryAssessmentsViewForKindAndSelector(
        eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(IdSelectionOptions.class));
    verify(dataTypeService).findByIdSelector(isA(IdSelectionOptions.class));
    verify(flowClassificationRuleService).getFlowClassificationsViewForFlow(eq(1L));
    verify(flowClassificationService).findAll();
    assertTrue(actualDecoratorView instanceof ImmutableDataTypeDecoratorView);
    assertEquals(1, actualDecoratorView.dataTypeDecorators().size());
    Set<FlowClassification> classificationsResult = actualDecoratorView.classifications();
    assertTrue(classificationsResult.isEmpty());
    assertSame(classificationsResult, actualDecoratorView.dataTypes());
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}
   */
  @Test
  void testGetDecoratorView3() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.getTimestamp(anyInt())).thenReturn(timestamp);
    when(resultSet.getLong(anyInt())).thenReturn(1L);
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(connection, SQLDialect.SQL99)));
    DataTypeService dataTypeService = mock(DataTypeService.class);
    when(dataTypeService.findByIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(new HashSet<>());
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(Mockito.<EntityKind>any(),
        Mockito.<IdSelectionOptions>any())).thenReturn(mock(AssessmentsView.class));
    FlowClassificationRuleService flowClassificationRuleService = mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.getFlowClassificationsViewForFlow(anyLong()))
        .thenThrow(new UnsupportedOperationException("entityReference"));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(mock(ChangeLogService.class),
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), dataTypeService, mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), assessmentRatingService, mock(AssessmentDefinitionService.class),
        mock(RatingSchemeService.class), mock(FlowClassificationService.class), flowClassificationRuleService);
    EntityReference parentEntityRef = mock(EntityReference.class);
    when(parentEntityRef.id()).thenReturn(1L);
    when(parentEntityRef.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeDecoratorService.getDecoratorView(parentEntityRef));
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\", \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\", \"logical_flow_decorator\".\"provenance\", \"logical_flow_decorator\".\"last_updated_at\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"flow_classification_rule_id\", \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\", \"logical_flow_decorator\".\"target_inbound_rating\", case when \"logical_flow_decorator\".\"decorator_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\") end from \"logical_flow_decorator\" where \"logical_flow_decorator\".\"logical_flow_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet, atLeast(1)).getBoolean(eq(9));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet, atLeast(1)).getTimestamp(eq(6));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp, atLeast(1)).toLocalDateTime();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(parentEntityRef, atLeast(1)).id();
    verify(parentEntityRef, atLeast(1)).kind();
    verify(assessmentRatingService).getPrimaryAssessmentsViewForKindAndSelector(
        eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(IdSelectionOptions.class));
    verify(dataTypeService).findByIdSelector(isA(IdSelectionOptions.class));
    verify(flowClassificationRuleService).getFlowClassificationsViewForFlow(eq(1L));
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}
   */
  @Test
  void testGetDecoratorView4() throws SQLException {
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
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(connection, SQLDialect.SQL99)));
    DataTypeService dataTypeService = mock(DataTypeService.class);
    when(dataTypeService.findByIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(new HashSet<>());
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(Mockito.<EntityKind>any(),
        Mockito.<IdSelectionOptions>any())).thenReturn(mock(AssessmentsView.class));
    FlowClassificationService flowClassificationService = mock(FlowClassificationService.class);
    when(flowClassificationService.findAll()).thenReturn(new HashSet<>());
    FlowClassificationRuleService flowClassificationRuleService = mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.getFlowClassificationsViewForFlow(anyLong()))
        .thenReturn(mock(FlowClassificationRulesView.class));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(mock(ChangeLogService.class),
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), dataTypeService, mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), assessmentRatingService, mock(AssessmentDefinitionService.class),
        mock(RatingSchemeService.class), flowClassificationService, flowClassificationRuleService);
    EntityReference parentEntityRef = mock(EntityReference.class);
    when(parentEntityRef.id()).thenReturn(1L);
    when(parentEntityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    DataTypeDecoratorView actualDecoratorView = dataTypeDecoratorService.getDecoratorView(parentEntityRef);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\", \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\", \"logical_flow_decorator\".\"provenance\", \"logical_flow_decorator\".\"last_updated_at\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"flow_classification_rule_id\", \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\", \"logical_flow_decorator\".\"target_inbound_rating\", case when \"logical_flow_decorator\".\"decorator_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\") end from \"logical_flow_decorator\" where \"logical_flow_decorator\".\"logical_flow_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(parentEntityRef, atLeast(1)).id();
    verify(parentEntityRef, atLeast(1)).kind();
    verify(assessmentRatingService).getPrimaryAssessmentsViewForKindAndSelector(
        eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(IdSelectionOptions.class));
    verify(dataTypeService).findByIdSelector(isA(IdSelectionOptions.class));
    verify(flowClassificationRuleService).getFlowClassificationsViewForFlow(eq(1L));
    verify(flowClassificationService).findAll();
    assertTrue(actualDecoratorView instanceof ImmutableDataTypeDecoratorView);
    Set<FlowClassification> classificationsResult = actualDecoratorView.classifications();
    assertTrue(classificationsResult.isEmpty());
    assertSame(classificationsResult, actualDecoratorView.dataTypeDecorators());
    assertSame(classificationsResult, actualDecoratorView.dataTypes());
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}
   */
  @Test
  void testGetDecoratorView5() throws SQLException {
    // Arrange
    Timestamp timestamp = mock(Timestamp.class);
    when(timestamp.toLocalDateTime()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getBoolean(anyInt())).thenReturn(true);
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
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory = mock(
        DataTypeDecoratorDaoSelectorFactory.class);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(connection, SQLDialect.SQL99)));
    DataTypeService dataTypeService = mock(DataTypeService.class);
    when(dataTypeService.findByIdSelector(Mockito.<IdSelectionOptions>any())).thenReturn(new HashSet<>());
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(Mockito.<EntityKind>any(),
        Mockito.<IdSelectionOptions>any())).thenReturn(mock(AssessmentsView.class));
    FlowClassificationService flowClassificationService = mock(FlowClassificationService.class);
    when(flowClassificationService.findAll()).thenReturn(new HashSet<>());
    FlowClassificationRuleService flowClassificationRuleService = mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.getFlowClassificationsViewForFlow(anyLong()))
        .thenReturn(mock(FlowClassificationRulesView.class));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(mock(ChangeLogService.class),
        mock(LogicalFlowDecoratorService.class), dataTypeDecoratorDaoSelectorFactory, mock(LogicalFlowDao.class),
        mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
        mock(DataTypeUsageService.class), dataTypeService, mock(PhysicalSpecificationDao.class),
        mock(PhysicalSpecificationService.class), assessmentRatingService, mock(AssessmentDefinitionService.class),
        mock(RatingSchemeService.class), flowClassificationService, flowClassificationRuleService);
    EntityReference parentEntityRef = mock(EntityReference.class);
    when(parentEntityRef.id()).thenReturn(1L);
    when(parentEntityRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    DataTypeDecoratorView actualDecoratorView = dataTypeDecoratorService.getDecoratorView(parentEntityRef);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"logical_flow_decorator\".\"logical_flow_id\", \"logical_flow_decorator\".\"decorator_entity_kind\", \"logical_flow_decorator\".\"decorator_entity_id\", \"logical_flow_decorator\".\"rating\", \"logical_flow_decorator\".\"provenance\", \"logical_flow_decorator\".\"last_updated_at\", \"logical_flow_decorator\".\"last_updated_by\", \"logical_flow_decorator\".\"id\", \"logical_flow_decorator\".\"is_readonly\", \"logical_flow_decorator\".\"flow_classification_rule_id\", \"logical_flow_decorator\".\"inbound_flow_classification_rule_id\", \"logical_flow_decorator\".\"target_inbound_rating\", case when \"logical_flow_decorator\".\"decorator_entity_kind\" = ? then (select \"data_type\".\"name\" from \"data_type\" where \"data_type\".\"id\" = \"logical_flow_decorator\".\"decorator_entity_id\") end from \"logical_flow_decorator\" where \"logical_flow_decorator\".\"logical_flow_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("DATA_TYPE"));
    verify(resultSet).close();
    verify(resultSet).getBoolean(eq(9));
    verify(resultSet, atLeast(1)).getLong(anyInt());
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(anyInt());
    verify(resultSet).getTimestamp(eq(6));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(timestamp).toLocalDateTime();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(eq(EntityKind.ALL));
    verify(parentEntityRef, atLeast(1)).id();
    verify(parentEntityRef, atLeast(1)).kind();
    verify(assessmentRatingService).getPrimaryAssessmentsViewForKindAndSelector(
        eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(IdSelectionOptions.class));
    verify(dataTypeService).findByIdSelector(isA(IdSelectionOptions.class));
    verify(flowClassificationRuleService).getFlowClassificationsViewForFlow(eq(1L));
    verify(flowClassificationService).findAll();
    assertTrue(actualDecoratorView instanceof ImmutableDataTypeDecoratorView);
    assertEquals(1, actualDecoratorView.dataTypeDecorators().size());
    Set<FlowClassification> classificationsResult = actualDecoratorView.classifications();
    assertTrue(classificationsResult.isEmpty());
    assertSame(classificationsResult, actualDecoratorView.dataTypes());
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference, EntityReference)}
   */
  @Test
  void testFindDatatypeRatingCharacteristicsForSourceAndTarget() {
    // Arrange
    LogicalFlowDecoratorRatingsCalculator ratingsCalculator = mock(LogicalFlowDecoratorRatingsCalculator.class);
    HashSet<DataTypeDecoratorRatingCharacteristics> dataTypeDecoratorRatingCharacteristicsSet = new HashSet<>();
    when(ratingsCalculator.calculate(Mockito.<EntityReference>any(), Mockito.<EntityReference>any(),
        Mockito.<Optional<Collection<Long>>>any())).thenReturn(dataTypeDecoratorRatingCharacteristicsSet);

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualFindDatatypeRatingCharacteristicsForSourceAndTargetResult = (new DataTypeDecoratorService(
        mock(ChangeLogService.class), mock(LogicalFlowDecoratorService.class),
        mock(DataTypeDecoratorDaoSelectorFactory.class), mock(LogicalFlowDao.class), mock(LogicalFlowService.class),
        ratingsCalculator, mock(DataTypeUsageService.class), mock(DataTypeService.class),
        mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationService.class),
        mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class),
        mock(FlowClassificationService.class), mock(FlowClassificationRuleService.class)))
            .findDatatypeRatingCharacteristicsForSourceAndTarget(null, null);

    // Assert
    verify(ratingsCalculator).calculate(isNull(), isNull(), isA(Optional.class));
    assertTrue(actualFindDatatypeRatingCharacteristicsForSourceAndTargetResult.isEmpty());
    assertSame(dataTypeDecoratorRatingCharacteristicsSet,
        actualFindDatatypeRatingCharacteristicsForSourceAndTargetResult);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference, EntityReference)}
   */
  @Test
  void testFindDatatypeRatingCharacteristicsForSourceAndTarget2() {
    // Arrange
    LogicalFlowDecoratorRatingsCalculator ratingsCalculator = mock(LogicalFlowDecoratorRatingsCalculator.class);
    when(ratingsCalculator.calculate(Mockito.<EntityReference>any(), Mockito.<EntityReference>any(),
        Mockito.<Optional<Collection<Long>>>any())).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new DataTypeDecoratorService(mock(ChangeLogService.class),
        mock(LogicalFlowDecoratorService.class), mock(DataTypeDecoratorDaoSelectorFactory.class),
        mock(LogicalFlowDao.class), mock(LogicalFlowService.class), ratingsCalculator, mock(DataTypeUsageService.class),
        mock(DataTypeService.class), mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationService.class),
        mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class),
        mock(FlowClassificationService.class), mock(FlowClassificationRuleService.class)))
            .findDatatypeRatingCharacteristicsForSourceAndTarget(null, null));
    verify(ratingsCalculator).calculate(isNull(), isNull(), isA(Optional.class));
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testFindDatatypeRatingCharacteristicsForSourceAndTarget3() {
    // Arrange
    LogicalFlowDecoratorRatingsCalculator ratingsCalculator = mock(LogicalFlowDecoratorRatingsCalculator.class);
    HashSet<DataTypeDecoratorRatingCharacteristics> dataTypeDecoratorRatingCharacteristicsSet = new HashSet<>();
    when(ratingsCalculator.calculate(Mockito.<EntityReference>any(), Mockito.<EntityReference>any(),
        Mockito.<Optional<Collection<Long>>>any())).thenReturn(dataTypeDecoratorRatingCharacteristicsSet);
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(mock(ChangeLogService.class),
        mock(LogicalFlowDecoratorService.class), mock(DataTypeDecoratorDaoSelectorFactory.class),
        mock(LogicalFlowDao.class), mock(LogicalFlowService.class), ratingsCalculator, mock(DataTypeUsageService.class),
        mock(DataTypeService.class), mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationService.class),
        mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class),
        mock(FlowClassificationService.class), mock(FlowClassificationRuleService.class));
    Optional<Collection<Long>> dataTypeIds = Optional.of(new ArrayList<>());

    // Act
    Set<DataTypeDecoratorRatingCharacteristics> actualFindDatatypeRatingCharacteristicsForSourceAndTargetResult = dataTypeDecoratorService
        .findDatatypeRatingCharacteristicsForSourceAndTarget(null, null, dataTypeIds);

    // Assert
    verify(ratingsCalculator).calculate(isNull(), isNull(), isA(Optional.class));
    assertTrue(actualFindDatatypeRatingCharacteristicsForSourceAndTargetResult.isEmpty());
    assertSame(dataTypeDecoratorRatingCharacteristicsSet,
        actualFindDatatypeRatingCharacteristicsForSourceAndTargetResult);
  }

  /**
   * Method under test:
   * {@link DataTypeDecoratorService#findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference, EntityReference, Optional)}
   */
  @Test
  void testFindDatatypeRatingCharacteristicsForSourceAndTarget4() {
    // Arrange
    LogicalFlowDecoratorRatingsCalculator ratingsCalculator = mock(LogicalFlowDecoratorRatingsCalculator.class);
    when(ratingsCalculator.calculate(Mockito.<EntityReference>any(), Mockito.<EntityReference>any(),
        Mockito.<Optional<Collection<Long>>>any())).thenThrow(new UnsupportedOperationException("foo"));
    DataTypeDecoratorService dataTypeDecoratorService = new DataTypeDecoratorService(mock(ChangeLogService.class),
        mock(LogicalFlowDecoratorService.class), mock(DataTypeDecoratorDaoSelectorFactory.class),
        mock(LogicalFlowDao.class), mock(LogicalFlowService.class), ratingsCalculator, mock(DataTypeUsageService.class),
        mock(DataTypeService.class), mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationService.class),
        mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class),
        mock(FlowClassificationService.class), mock(FlowClassificationRuleService.class));
    Optional<Collection<Long>> dataTypeIds = Optional.of(new ArrayList<>());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> dataTypeDecoratorService.findDatatypeRatingCharacteristicsForSourceAndTarget(null, null, dataTypeIds));
    verify(ratingsCalculator).calculate(isNull(), isNull(), isA(Optional.class));
  }
}
