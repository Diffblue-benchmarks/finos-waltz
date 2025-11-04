package org.finos.waltz.service.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.common.exception.ModifyingReadOnlyRecordException;
import org.finos.waltz.common.exception.NotFoundException;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.SetAttributeCommand;
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowDeleteCommandResponse;
import org.finos.waltz.model.physical_flow.PhysicalFlow;
import org.finos.waltz.model.physical_flow.PhysicalFlowCreateCommand;
import org.finos.waltz.model.physical_flow.PhysicalFlowDeleteCommand;
import org.finos.waltz.model.physical_flow.PhysicalFlowDeleteCommandResponse;
import org.finos.waltz.model.physical_flow.PhysicalFlowInfo;
import org.finos.waltz.model.physical_flow.PhysicalFlowSpecDefinitionChangeCommand;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.data_type.DataTypeDecoratorService;
import org.finos.waltz.service.external_identifier.ExternalIdentifierService;
import org.finos.waltz.service.logical_flow.LogicalFlowService;
import org.finos.waltz.service.permission.permission_checker.FlowPermissionChecker;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalFlowServiceDiffblueTest {
  /**
   * Method under test:
   * {@link PhysicalFlowService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();
    when(physicalDataFlowDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(physicalFlowList);

    // Act
    List<PhysicalFlow> actualFindByEntityReferenceResult = (new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), physicalDataFlowDao, mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class)))
            .findByEntityReference(mock(EntityReference.class));

    // Assert
    verify(physicalDataFlowDao).findByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(physicalFlowList, actualFindByEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference2() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException("ref cannot be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PhysicalFlowService(mock(ChangeLogService.class), mock(LogicalFlowService.class),
            physicalDataFlowDao, mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
            mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class)))
                .findByEntityReference(mock(EntityReference.class)));
    verify(physicalDataFlowDao).findByEntityReference(isA(EntityReference.class));
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#findByProducerEntityReference(EntityReference)}
   */
  @Test
  void testFindByProducerEntityReference() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();
    when(physicalDataFlowDao.findByProducer(Mockito.<EntityReference>any())).thenReturn(physicalFlowList);

    // Act
    List<PhysicalFlow> actualFindByProducerEntityReferenceResult = (new PhysicalFlowService(
        mock(ChangeLogService.class), mock(LogicalFlowService.class), physicalDataFlowDao,
        mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
        mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class)))
            .findByProducerEntityReference(mock(EntityReference.class));

    // Assert
    verify(physicalDataFlowDao).findByProducer(isA(EntityReference.class));
    assertTrue(actualFindByProducerEntityReferenceResult.isEmpty());
    assertSame(physicalFlowList, actualFindByProducerEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#findByProducerEntityReference(EntityReference)}
   */
  @Test
  void testFindByProducerEntityReference2() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.findByProducer(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException("ref cannot be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PhysicalFlowService(mock(ChangeLogService.class), mock(LogicalFlowService.class),
            physicalDataFlowDao, mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
            mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class)))
                .findByProducerEntityReference(mock(EntityReference.class)));
    verify(physicalDataFlowDao).findByProducer(isA(EntityReference.class));
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#findByConsumerEntityReference(EntityReference)}
   */
  @Test
  void testFindByConsumerEntityReference() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();
    when(physicalDataFlowDao.findByConsumer(Mockito.<EntityReference>any())).thenReturn(physicalFlowList);

    // Act
    List<PhysicalFlow> actualFindByConsumerEntityReferenceResult = (new PhysicalFlowService(
        mock(ChangeLogService.class), mock(LogicalFlowService.class), physicalDataFlowDao,
        mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
        mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class)))
            .findByConsumerEntityReference(mock(EntityReference.class));

    // Assert
    verify(physicalDataFlowDao).findByConsumer(isA(EntityReference.class));
    assertTrue(actualFindByConsumerEntityReferenceResult.isEmpty());
    assertSame(physicalFlowList, actualFindByConsumerEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#findByConsumerEntityReference(EntityReference)}
   */
  @Test
  void testFindByConsumerEntityReference2() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.findByConsumer(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException("ref cannot be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PhysicalFlowService(mock(ChangeLogService.class), mock(LogicalFlowService.class),
            physicalDataFlowDao, mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
            mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class)))
                .findByConsumerEntityReference(mock(EntityReference.class)));
    verify(physicalDataFlowDao).findByConsumer(isA(EntityReference.class));
  }

  /**
   * Method under test: {@link PhysicalFlowService#findBySpecificationId(long)}
   */
  @Test
  void testFindBySpecificationId() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();
    when(physicalDataFlowDao.findBySpecificationId(anyLong())).thenReturn(physicalFlowList);

    // Act
    List<PhysicalFlow> actualFindBySpecificationIdResult = (new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), physicalDataFlowDao, mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class)))
            .findBySpecificationId(1L);

    // Assert
    verify(physicalDataFlowDao).findBySpecificationId(eq(1L));
    assertTrue(actualFindBySpecificationIdResult.isEmpty());
    assertSame(physicalFlowList, actualFindBySpecificationIdResult);
  }

  /**
   * Method under test: {@link PhysicalFlowService#findBySpecificationId(long)}
   */
  @Test
  void testFindBySpecificationId2() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.findBySpecificationId(anyLong())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PhysicalFlowService(mock(ChangeLogService.class), mock(LogicalFlowService.class),
            physicalDataFlowDao, mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
            mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class))).findBySpecificationId(1L));
    verify(physicalDataFlowDao).findBySpecificationId(eq(1L));
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();
    when(physicalDataFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(physicalFlowList);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), physicalDataFlowDao, mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<PhysicalFlow> actualFindBySelectorResult = physicalFlowService.findBySelector(idSelectionOptions);

    // Assert
    verify(physicalDataFlowDao).findBySelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    assertTrue(actualFindBySelectorResult instanceof List);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalFlowList, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector2() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();
    when(physicalDataFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(physicalFlowList);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), physicalDataFlowDao, mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<PhysicalFlow> actualFindBySelectorResult = physicalFlowService.findBySelector(idSelectionOptions);

    // Assert
    verify(physicalDataFlowDao).findBySelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    assertTrue(actualFindBySelectorResult instanceof List);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalFlowList, actualFindBySelectorResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySelector3() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();
    when(physicalDataFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(physicalFlowList);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), physicalDataFlowDao, mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_SET);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<PhysicalFlow> actualFindBySelectorResult = physicalFlowService.findBySelector(idSelectionOptions);

    // Assert
    verify(physicalDataFlowDao).findBySelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    assertTrue(actualFindBySelectorResult instanceof List);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalFlowList, actualFindBySelectorResult);
  }

  /**
   * Method under test: {@link PhysicalFlowService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.getById(anyLong())).thenReturn(null);

    // Act
    PhysicalFlow actualById = (new PhysicalFlowService(mock(ChangeLogService.class), mock(LogicalFlowService.class),
        physicalDataFlowDao, mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
        mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class))).getById(1L);

    // Assert
    verify(physicalDataFlowDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link PhysicalFlowService#getById(long)}
   */
  @Test
  void testGetById2() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.getById(anyLong())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PhysicalFlowService(mock(ChangeLogService.class), mock(LogicalFlowService.class),
            physicalDataFlowDao, mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
            mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class))).getById(1L));
    verify(physicalDataFlowDao).getById(eq(1L));
  }

  /**
   * Method under test: {@link PhysicalFlowService#findByExternalId(String)}
   */
  @Test
  void testFindByExternalId() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();
    when(physicalDataFlowDao.findByExternalId(Mockito.<String>any())).thenReturn(physicalFlowList);

    // Act
    List<PhysicalFlow> actualFindByExternalIdResult = (new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), physicalDataFlowDao, mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class)))
            .findByExternalId("42");

    // Assert
    verify(physicalDataFlowDao).findByExternalId(eq("42"));
    assertTrue(actualFindByExternalIdResult.isEmpty());
    assertSame(physicalFlowList, actualFindByExternalIdResult);
  }

  /**
   * Method under test: {@link PhysicalFlowService#findByExternalId(String)}
   */
  @Test
  void testFindByExternalId2() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.findByExternalId(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PhysicalFlowService(mock(ChangeLogService.class), mock(LogicalFlowService.class),
            physicalDataFlowDao, mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
            mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class))).findByExternalId("42"));
    verify(physicalDataFlowDao).findByExternalId(eq("42"));
  }

  /**
   * Method under test: {@link PhysicalFlowService#merge(long, long, String)}
   */
  @Test
  void testMerge() {
    // Arrange
    ExternalIdentifierService externalIdentifierService = mock(ExternalIdentifierService.class);
    when(externalIdentifierService.merge(Mockito.<EntityReference>any(), Mockito.<EntityReference>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("kind", "An error occurred"));

    // Act and Assert
    assertThrows(ModifyingReadOnlyRecordException.class,
        () -> (new PhysicalFlowService(mock(ChangeLogService.class), mock(LogicalFlowService.class),
            mock(PhysicalFlowDao.class), mock(PhysicalSpecificationService.class), externalIdentifierService,
            mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class))).merge(1L, 1L, "janedoe"));
    verify(externalIdentifierService).merge(isA(EntityReference.class), isA(EntityReference.class));
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}
   */
  @Test
  void testDelete() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.getByIdAndIsRemoved(anyLong(), anyBoolean())).thenReturn(null);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), physicalDataFlowDao, mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    PhysicalFlowDeleteCommand command = mock(PhysicalFlowDeleteCommand.class);
    when(command.flowId()).thenReturn(1L);

    // Act
    PhysicalFlowDeleteCommandResponse actualDeleteResult = physicalFlowService.delete(command, "janedoe");

    // Assert
    verify(physicalDataFlowDao).getByIdAndIsRemoved(eq(1L), eq(false));
    verify(command, atLeast(1)).flowId();
    EntityReference entityReferenceResult = actualDeleteResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualDeleteResult instanceof ImmutablePhysicalFlowDeleteCommandResponse);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.PHYSICAL_FLOW, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.FAILURE, actualDeleteResult.outcome());
    assertFalse(actualDeleteResult.isLastPhysicalFlow());
    assertFalse(actualDeleteResult.isSpecificationUnused());
    assertSame(command, actualDeleteResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}
   */
  @Test
  void testDelete2() {
    // Arrange
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    PhysicalFlowDeleteCommand command = mock(PhysicalFlowDeleteCommand.class);
    when(command.flowId()).thenThrow(new IllegalArgumentException("command cannot be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> physicalFlowService.delete(command, "janedoe"));
    verify(command).flowId();
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}
   */
  @Test
  void testDelete3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing().when(changeLogService)
        .writeChangeLogEntries(Mockito.<PhysicalFlow>any(), Mockito.<String>any(), Mockito.<String>any(),
            Mockito.<Operation>any());
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    when(physicalFlow.logicalFlowId()).thenReturn(1L);
    when(physicalFlow.specificationId()).thenReturn(1L);
    when(physicalFlow.entityReference()).thenReturn(null);
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.hasPhysicalFlows(anyLong())).thenReturn(true);
    when(physicalDataFlowDao.delete(anyLong())).thenReturn(1);
    when(physicalDataFlowDao.getByIdAndIsRemoved(anyLong(), anyBoolean())).thenReturn(physicalFlow);
    PhysicalSpecificationService physicalSpecificationService = mock(PhysicalSpecificationService.class);
    when(physicalSpecificationService.isUsed(Mockito.<Long>any())).thenReturn(true);
    ExternalIdentifierService externalIdentifierService = mock(ExternalIdentifierService.class);
    when(externalIdentifierService.delete(Mockito.<EntityReference>any())).thenReturn(1);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(changeLogService, mock(LogicalFlowService.class),
        physicalDataFlowDao, physicalSpecificationService, externalIdentifierService,
        mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    PhysicalFlowDeleteCommand command = mock(PhysicalFlowDeleteCommand.class);
    when(command.flowId()).thenReturn(1L);

    // Act
    PhysicalFlowDeleteCommandResponse actualDeleteResult = physicalFlowService.delete(command, "janedoe");

    // Assert
    verify(physicalDataFlowDao).delete(eq(1L));
    verify(physicalDataFlowDao).getByIdAndIsRemoved(eq(1L), eq(false));
    verify(physicalDataFlowDao).hasPhysicalFlows(eq(1L));
    verify(physicalFlow).entityReference();
    verify(physicalFlow).logicalFlowId();
    verify(physicalFlow).specificationId();
    verify(command, atLeast(1)).flowId();
    verify(changeLogService).writeChangeLogEntries(isA(PhysicalFlow.class), eq("janedoe"), eq(" removed"),
        eq(Operation.REMOVE));
    verify(externalIdentifierService).delete(isNull());
    verify(physicalSpecificationService).isUsed(eq(1L));
    EntityReference entityReferenceResult = actualDeleteResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualDeleteResult instanceof ImmutablePhysicalFlowDeleteCommandResponse);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.PHYSICAL_FLOW, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualDeleteResult.outcome());
    assertFalse(actualDeleteResult.isLastPhysicalFlow());
    assertFalse(actualDeleteResult.isSpecificationUnused());
    assertSame(command, actualDeleteResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}
   */
  @Test
  void testDelete4() {
    // Arrange
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    when(physicalFlow.entityReference()).thenReturn(null);
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.delete(anyLong())).thenReturn(1);
    when(physicalDataFlowDao.getByIdAndIsRemoved(anyLong(), anyBoolean())).thenReturn(physicalFlow);
    ExternalIdentifierService externalIdentifierService = mock(ExternalIdentifierService.class);
    when(externalIdentifierService.delete(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException("command cannot be null"));
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), physicalDataFlowDao, mock(PhysicalSpecificationService.class),
        externalIdentifierService, mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    PhysicalFlowDeleteCommand command = mock(PhysicalFlowDeleteCommand.class);
    when(command.flowId()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> physicalFlowService.delete(command, "janedoe"));
    verify(physicalDataFlowDao).delete(eq(1L));
    verify(physicalDataFlowDao).getByIdAndIsRemoved(eq(1L), eq(false));
    verify(physicalFlow).entityReference();
    verify(command, atLeast(1)).flowId();
    verify(externalIdentifierService).delete(isNull());
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}
   */
  @Test
  void testDelete5() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing().when(changeLogService)
        .writeChangeLogEntries(Mockito.<PhysicalFlow>any(), Mockito.<String>any(), Mockito.<String>any(),
            Mockito.<Operation>any());
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    when(physicalFlow.logicalFlowId()).thenReturn(1L);
    when(physicalFlow.specificationId()).thenReturn(1L);
    when(physicalFlow.entityReference()).thenReturn(null);
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.hasPhysicalFlows(anyLong())).thenReturn(false);
    when(physicalDataFlowDao.delete(anyLong())).thenReturn(1);
    when(physicalDataFlowDao.getByIdAndIsRemoved(anyLong(), anyBoolean())).thenReturn(physicalFlow);
    PhysicalSpecificationService physicalSpecificationService = mock(PhysicalSpecificationService.class);
    when(physicalSpecificationService.isUsed(Mockito.<Long>any())).thenReturn(true);
    ExternalIdentifierService externalIdentifierService = mock(ExternalIdentifierService.class);
    when(externalIdentifierService.delete(Mockito.<EntityReference>any())).thenReturn(1);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(changeLogService, mock(LogicalFlowService.class),
        physicalDataFlowDao, physicalSpecificationService, externalIdentifierService,
        mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    PhysicalFlowDeleteCommand command = mock(PhysicalFlowDeleteCommand.class);
    when(command.flowId()).thenReturn(1L);

    // Act
    PhysicalFlowDeleteCommandResponse actualDeleteResult = physicalFlowService.delete(command, "janedoe");

    // Assert
    verify(physicalDataFlowDao).delete(eq(1L));
    verify(physicalDataFlowDao).getByIdAndIsRemoved(eq(1L), eq(false));
    verify(physicalDataFlowDao).hasPhysicalFlows(eq(1L));
    verify(physicalFlow).entityReference();
    verify(physicalFlow).logicalFlowId();
    verify(physicalFlow).specificationId();
    verify(command, atLeast(1)).flowId();
    verify(changeLogService).writeChangeLogEntries(isA(PhysicalFlow.class), eq("janedoe"), eq(" removed"),
        eq(Operation.REMOVE));
    verify(externalIdentifierService).delete(isNull());
    verify(physicalSpecificationService).isUsed(eq(1L));
    EntityReference entityReferenceResult = actualDeleteResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualDeleteResult instanceof ImmutablePhysicalFlowDeleteCommandResponse);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.PHYSICAL_FLOW, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualDeleteResult.outcome());
    assertFalse(actualDeleteResult.isSpecificationUnused());
    assertTrue(actualDeleteResult.isLastPhysicalFlow());
    assertSame(command, actualDeleteResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}
   */
  @Test
  void testDelete6() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.delete(anyLong())).thenReturn(0);
    when(physicalDataFlowDao.getByIdAndIsRemoved(anyLong(), anyBoolean())).thenReturn(mock(PhysicalFlow.class));
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), physicalDataFlowDao, mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    PhysicalFlowDeleteCommand command = mock(PhysicalFlowDeleteCommand.class);
    when(command.flowId()).thenReturn(1L);

    // Act
    PhysicalFlowDeleteCommandResponse actualDeleteResult = physicalFlowService.delete(command, "janedoe");

    // Assert
    verify(physicalDataFlowDao).delete(eq(1L));
    verify(physicalDataFlowDao).getByIdAndIsRemoved(eq(1L), eq(false));
    verify(command, atLeast(1)).flowId();
    EntityReference entityReferenceResult = actualDeleteResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualDeleteResult instanceof ImmutablePhysicalFlowDeleteCommandResponse);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.PHYSICAL_FLOW, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.FAILURE, actualDeleteResult.outcome());
    assertFalse(actualDeleteResult.isLastPhysicalFlow());
    assertFalse(actualDeleteResult.isSpecificationUnused());
    assertSame(command, actualDeleteResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}
   */
  @Test
  void testDelete7() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing().when(changeLogService)
        .writeChangeLogEntries(Mockito.<PhysicalFlow>any(), Mockito.<String>any(), Mockito.<String>any(),
            Mockito.<Operation>any());
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    when(physicalFlow.logicalFlowId()).thenReturn(1L);
    when(physicalFlow.specificationId()).thenReturn(1L);
    when(physicalFlow.entityReference()).thenReturn(null);
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.hasPhysicalFlows(anyLong())).thenReturn(true);
    when(physicalDataFlowDao.delete(anyLong())).thenReturn(1);
    when(physicalDataFlowDao.getByIdAndIsRemoved(anyLong(), anyBoolean())).thenReturn(physicalFlow);
    PhysicalSpecificationService physicalSpecificationService = mock(PhysicalSpecificationService.class);
    when(physicalSpecificationService.isUsed(Mockito.<Long>any())).thenReturn(false);
    ExternalIdentifierService externalIdentifierService = mock(ExternalIdentifierService.class);
    when(externalIdentifierService.delete(Mockito.<EntityReference>any())).thenReturn(1);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(changeLogService, mock(LogicalFlowService.class),
        physicalDataFlowDao, physicalSpecificationService, externalIdentifierService,
        mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    PhysicalFlowDeleteCommand command = mock(PhysicalFlowDeleteCommand.class);
    when(command.flowId()).thenReturn(1L);

    // Act
    PhysicalFlowDeleteCommandResponse actualDeleteResult = physicalFlowService.delete(command, "janedoe");

    // Assert
    verify(physicalDataFlowDao).delete(eq(1L));
    verify(physicalDataFlowDao).getByIdAndIsRemoved(eq(1L), eq(false));
    verify(physicalDataFlowDao).hasPhysicalFlows(eq(1L));
    verify(physicalFlow).entityReference();
    verify(physicalFlow).logicalFlowId();
    verify(physicalFlow).specificationId();
    verify(command, atLeast(1)).flowId();
    verify(changeLogService).writeChangeLogEntries(isA(PhysicalFlow.class), eq("janedoe"), eq(" removed"),
        eq(Operation.REMOVE));
    verify(externalIdentifierService).delete(isNull());
    verify(physicalSpecificationService).isUsed(eq(1L));
    EntityReference entityReferenceResult = actualDeleteResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualDeleteResult instanceof ImmutablePhysicalFlowDeleteCommandResponse);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.PHYSICAL_FLOW, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualDeleteResult.outcome());
    assertFalse(actualDeleteResult.isLastPhysicalFlow());
    assertTrue(actualDeleteResult.isSpecificationUnused());
    assertSame(command, actualDeleteResult.originalCommand());
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}
   */
  @Test
  void testCreate() {
    // Arrange
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    when(logicalFlowService.getById(anyLong())).thenReturn(null);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class), logicalFlowService,
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
        mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    PhysicalFlowCreateCommand command = mock(PhysicalFlowCreateCommand.class);
    when(command.logicalFlowId()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> physicalFlowService.create(command, "janedoe"));
    verify(command).logicalFlowId();
    verify(logicalFlowService).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}
   */
  @Test
  void testCreate2() {
    // Arrange
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    PhysicalFlowCreateCommand command = mock(PhysicalFlowCreateCommand.class);
    when(command.logicalFlowId()).thenThrow(new IllegalArgumentException("command cannot be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> physicalFlowService.create(command, "janedoe"));
    verify(command).logicalFlowId();
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}
   */
  @Test
  void testCreate3() {
    // Arrange
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    when(logicalFlow.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    when(logicalFlowService.getById(anyLong())).thenReturn(logicalFlow);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class), logicalFlowService,
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
        mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    PhysicalFlowCreateCommand command = mock(PhysicalFlowCreateCommand.class);
    when(command.specification()).thenThrow(new IllegalArgumentException("command cannot be null"));
    when(command.logicalFlowId()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> physicalFlowService.create(command, "janedoe"));
    verify(logicalFlow).entityLifecycleStatus();
    verify(command).logicalFlowId();
    verify(command).specification();
    verify(logicalFlowService).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}
   */
  @Test
  void testCreate4() {
    // Arrange
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    when(logicalFlow.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.REMOVED);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    when(logicalFlowService.restoreFlow(anyLong(), Mockito.<String>any())).thenReturn(true);
    when(logicalFlowService.getById(anyLong())).thenReturn(logicalFlow);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class), logicalFlowService,
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
        mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    PhysicalFlowCreateCommand command = mock(PhysicalFlowCreateCommand.class);
    when(command.specification()).thenThrow(new IllegalArgumentException("command cannot be null"));
    when(command.logicalFlowId()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> physicalFlowService.create(command, "janedoe"));
    verify(logicalFlow).entityLifecycleStatus();
    verify(command).logicalFlowId();
    verify(command).specification();
    verify(logicalFlowService).getById(eq(1L));
    verify(logicalFlowService).restoreFlow(eq(1L), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}
   */
  @Test
  void testCreate5() {
    // Arrange
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    when(logicalFlow.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.REMOVED);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    when(logicalFlowService.restoreFlow(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("command cannot be null"));
    when(logicalFlowService.getById(anyLong())).thenReturn(logicalFlow);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class), logicalFlowService,
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
        mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    PhysicalFlowCreateCommand command = mock(PhysicalFlowCreateCommand.class);
    when(command.logicalFlowId()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> physicalFlowService.create(command, "janedoe"));
    verify(logicalFlow).entityLifecycleStatus();
    verify(command).logicalFlowId();
    verify(logicalFlowService).getById(eq(1L));
    verify(logicalFlowService).restoreFlow(eq(1L), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#updateSpecDefinitionId(String, long, PhysicalFlowSpecDefinitionChangeCommand)}
   */
  @Test
  void testUpdateSpecDefinitionId() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing().when(changeLogService)
        .writeChangeLogEntries(Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<String>any(),
            Mockito.<Operation>any());
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.updateSpecDefinition(Mockito.<String>any(), anyLong(), anyLong())).thenReturn(1);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(changeLogService, mock(LogicalFlowService.class),
        physicalDataFlowDao, mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
        mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    PhysicalFlowSpecDefinitionChangeCommand command = mock(PhysicalFlowSpecDefinitionChangeCommand.class);
    when(command.newSpecDefinitionId()).thenReturn(1L);

    // Act
    int actualUpdateSpecDefinitionIdResult = physicalFlowService.updateSpecDefinitionId("janedoe", 1L, command);

    // Assert
    verify(physicalDataFlowDao).updateSpecDefinition(eq("janedoe"), eq(1L), eq(1L));
    verify(command, atLeast(1)).newSpecDefinitionId();
    verify(changeLogService).writeChangeLogEntries(isA(EntityReference.class), eq("janedoe"),
        eq("Physical flow id: 1 specification definition id changed to: 1"), eq(Operation.UPDATE));
    assertEquals(1, actualUpdateSpecDefinitionIdResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#updateSpecDefinitionId(String, long, PhysicalFlowSpecDefinitionChangeCommand)}
   */
  @Test
  void testUpdateSpecDefinitionId2() {
    // Arrange
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    PhysicalFlowSpecDefinitionChangeCommand command = mock(PhysicalFlowSpecDefinitionChangeCommand.class);
    when(command.newSpecDefinitionId()).thenThrow(new IllegalArgumentException("userName cannot be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> physicalFlowService.updateSpecDefinitionId("janedoe", 1L, command));
    verify(command).newSpecDefinitionId();
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#updateSpecDefinitionId(String, long, PhysicalFlowSpecDefinitionChangeCommand)}
   */
  @Test
  void testUpdateSpecDefinitionId3() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.updateSpecDefinition(Mockito.<String>any(), anyLong(), anyLong())).thenReturn(-2);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), physicalDataFlowDao, mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    PhysicalFlowSpecDefinitionChangeCommand command = mock(PhysicalFlowSpecDefinitionChangeCommand.class);
    when(command.newSpecDefinitionId()).thenReturn(1L);

    // Act
    int actualUpdateSpecDefinitionIdResult = physicalFlowService.updateSpecDefinitionId("janedoe", 1L, command);

    // Assert
    verify(physicalDataFlowDao).updateSpecDefinition(eq("janedoe"), eq(1L), eq(1L));
    verify(command).newSpecDefinitionId();
    assertEquals(-2, actualUpdateSpecDefinitionIdResult);
  }

  /**
   * Method under test: {@link PhysicalFlowService#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.cleanupOrphans()).thenReturn(1);

    // Act
    int actualCleanupOrphansResult = (new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), physicalDataFlowDao, mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class)))
            .cleanupOrphans();

    // Assert
    verify(physicalDataFlowDao).cleanupOrphans();
    assertEquals(1, actualCleanupOrphansResult);
  }

  /**
   * Method under test: {@link PhysicalFlowService#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans2() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.cleanupOrphans()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PhysicalFlowService(mock(ChangeLogService.class), mock(LogicalFlowService.class),
            physicalDataFlowDao, mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
            mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class))).cleanupOrphans());
    verify(physicalDataFlowDao).cleanupOrphans();
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#updateAttribute(String, SetAttributeCommand)}
   */
  @Test
  void testUpdateAttribute() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.getById(anyLong())).thenReturn(null);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), physicalDataFlowDao, mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    SetAttributeCommand command = mock(SetAttributeCommand.class);
    when(command.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(NotFoundException.class, () -> physicalFlowService.updateAttribute("janedoe", command));
    verify(physicalDataFlowDao).getById(eq(1L));
    verify(entityReference).id();
    verify(command).entityReference();
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#updateAttribute(String, SetAttributeCommand)}
   */
  @Test
  void testUpdateAttribute2() {
    // Arrange
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    when(physicalFlow.isReadOnly()).thenReturn(true);
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.getById(anyLong())).thenReturn(physicalFlow);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), physicalDataFlowDao, mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    SetAttributeCommand command = mock(SetAttributeCommand.class);
    when(command.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(ModifyingReadOnlyRecordException.class, () -> physicalFlowService.updateAttribute("janedoe", command));
    verify(physicalDataFlowDao).getById(eq(1L));
    verify(entityReference).id();
    verify(command).entityReference();
    verify(physicalFlow).isReadOnly();
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#updateAttribute(String, SetAttributeCommand)}
   */
  @Test
  void testUpdateAttribute3() {
    // Arrange
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    when(physicalFlow.isReadOnly()).thenReturn(false);
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.getById(anyLong())).thenReturn(physicalFlow);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), physicalDataFlowDao, mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    SetAttributeCommand command = mock(SetAttributeCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> physicalFlowService.updateAttribute("janedoe", command));
    verify(physicalDataFlowDao).getById(eq(1L));
    verify(entityReference).id();
    verify(command, atLeast(1)).name();
    verify(command).entityReference();
    verify(physicalFlow).isReadOnly();
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#updateAttribute(String, SetAttributeCommand)}
   */
  @Test
  void testUpdateAttribute4() {
    // Arrange
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    when(physicalFlow.isReadOnly()).thenReturn(false);
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.getById(anyLong())).thenReturn(physicalFlow);
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), physicalDataFlowDao, mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    SetAttributeCommand command = mock(SetAttributeCommand.class);
    when(command.name()).thenThrow(new IllegalArgumentException("foo"));
    when(command.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> physicalFlowService.updateAttribute("janedoe", command));
    verify(physicalDataFlowDao).getById(eq(1L));
    verify(entityReference).id();
    verify(command).name();
    verify(command).entityReference();
    verify(physicalFlow).isReadOnly();
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#findUnderlyingPhysicalFlows(Long)}
   */
  @Test
  void testFindUnderlyingPhysicalFlows() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    HashSet<PhysicalFlowInfo> physicalFlowInfoSet = new HashSet<>();
    when(physicalDataFlowDao.findUnderlyingPhysicalFlows(Mockito.<Long>any())).thenReturn(physicalFlowInfoSet);

    // Act
    Collection<PhysicalFlowInfo> actualFindUnderlyingPhysicalFlowsResult = (new PhysicalFlowService(
        mock(ChangeLogService.class), mock(LogicalFlowService.class), physicalDataFlowDao,
        mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
        mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class))).findUnderlyingPhysicalFlows(1L);

    // Assert
    verify(physicalDataFlowDao).findUnderlyingPhysicalFlows(eq(1L));
    assertTrue(actualFindUnderlyingPhysicalFlowsResult instanceof Set);
    assertTrue(actualFindUnderlyingPhysicalFlowsResult.isEmpty());
    assertSame(physicalFlowInfoSet, actualFindUnderlyingPhysicalFlowsResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#findUnderlyingPhysicalFlows(Long)}
   */
  @Test
  void testFindUnderlyingPhysicalFlows2() {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.findUnderlyingPhysicalFlows(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PhysicalFlowService(mock(ChangeLogService.class), mock(LogicalFlowService.class),
            physicalDataFlowDao, mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
            mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class))).findUnderlyingPhysicalFlows(1L));
    verify(physicalDataFlowDao).findUnderlyingPhysicalFlows(eq(1L));
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#checkLogicalFlowPermission(EntityReference, String)}
   */
  @Test
  void testCheckLogicalFlowPermission() throws InsufficientPrivelegeException {
    // Arrange
    FlowPermissionChecker flowPermissionChecker = mock(FlowPermissionChecker.class);
    doNothing().when(flowPermissionChecker)
        .verifyEditPerms(Mockito.<Set<Operation>>any(), Mockito.<EntityKind>any(), Mockito.<String>any());
    when(flowPermissionChecker.findPermissionsForFlow(Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), flowPermissionChecker);
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);

    // Act
    physicalFlowService.checkLogicalFlowPermission(ref, "janedoe");

    // Assert
    verify(ref).id();
    verify(flowPermissionChecker).findPermissionsForFlow(eq(1L), eq("janedoe"));
    verify(flowPermissionChecker).verifyEditPerms(isA(Set.class), eq(EntityKind.PHYSICAL_FLOW), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#checkHasPermission(long, String)}
   */
  @Test
  void testCheckHasPermission() throws InsufficientPrivelegeException {
    // Arrange
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.getById(anyLong())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PhysicalFlowService(mock(ChangeLogService.class), mock(LogicalFlowService.class),
            physicalDataFlowDao, mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
            mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class))).checkHasPermission(1L,
                "janedoe"));
    verify(physicalDataFlowDao).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#checkHasPermission(long, String)}
   */
  @Test
  void testCheckHasPermission2() throws InsufficientPrivelegeException {
    // Arrange
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    when(physicalFlow.logicalFlowId()).thenReturn(1L);
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.getById(anyLong())).thenReturn(physicalFlow);
    FlowPermissionChecker flowPermissionChecker = mock(FlowPermissionChecker.class);
    doNothing().when(flowPermissionChecker)
        .verifyEditPerms(Mockito.<Set<Operation>>any(), Mockito.<EntityKind>any(), Mockito.<String>any());
    when(flowPermissionChecker.findPermissionsForFlow(Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    (new PhysicalFlowService(mock(ChangeLogService.class), mock(LogicalFlowService.class), physicalDataFlowDao,
        mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
        mock(DataTypeDecoratorService.class), flowPermissionChecker)).checkHasPermission(1L, "janedoe");

    // Assert
    verify(physicalDataFlowDao).getById(eq(1L));
    verify(physicalFlow).logicalFlowId();
    verify(flowPermissionChecker).findPermissionsForFlow(eq(1L), eq("janedoe"));
    verify(flowPermissionChecker).verifyEditPerms(isA(Set.class), eq(EntityKind.PHYSICAL_FLOW), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link PhysicalFlowService#checkHasPermission(long, String)}
   */
  @Test
  void testCheckHasPermission3() throws InsufficientPrivelegeException {
    // Arrange
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    when(physicalFlow.logicalFlowId()).thenReturn(1L);
    PhysicalFlowDao physicalDataFlowDao = mock(PhysicalFlowDao.class);
    when(physicalDataFlowDao.getById(anyLong())).thenReturn(physicalFlow);
    FlowPermissionChecker flowPermissionChecker = mock(FlowPermissionChecker.class);
    when(flowPermissionChecker.findPermissionsForFlow(Mockito.<Long>any(), Mockito.<String>any()))
        .thenThrow(new ModifyingReadOnlyRecordException("kind", "An error occurred"));

    // Act and Assert
    assertThrows(ModifyingReadOnlyRecordException.class,
        () -> (new PhysicalFlowService(mock(ChangeLogService.class), mock(LogicalFlowService.class),
            physicalDataFlowDao, mock(PhysicalSpecificationService.class), mock(ExternalIdentifierService.class),
            mock(DataTypeDecoratorService.class), flowPermissionChecker)).checkHasPermission(1L, "janedoe"));
    verify(physicalDataFlowDao).getById(eq(1L));
    verify(physicalFlow).logicalFlowId();
    verify(flowPermissionChecker).findPermissionsForFlow(eq(1L), eq("janedoe"));
  }
}
