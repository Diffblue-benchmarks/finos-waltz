package org.finos.waltz.service.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.physical_specification_definition.PhysicalSpecDefinitionDao;
import org.finos.waltz.data.physical_specification_definition.PhysicalSpecDefinitionFieldDao;
import org.finos.waltz.data.physical_specification_definition.PhysicalSpecDefinitionSampleFileDao;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.ReleaseLifecycleStatusChangeCommand;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinition;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionChangeCommand;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionType;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalSpecDefinitionServiceDiffblueTest {
  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionService#create(String, long, PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  void testCreate() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.create(Mockito.<PhysicalSpecDefinition>any())).thenReturn(1L);
    PhysicalSpecDefinitionService physicalSpecDefinitionService = new PhysicalSpecDefinitionService(changeLogService,
        physicalSpecDefinitionDao, mock(PhysicalSpecDefinitionFieldDao.class),
        mock(PhysicalSpecDefinitionSampleFileDao.class));
    PhysicalSpecDefinitionChangeCommand command = mock(PhysicalSpecDefinitionChangeCommand.class);
    Optional<String> ofResult = Optional.of("foo");
    when(command.delimiter()).thenReturn(ofResult);
    when(command.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);
    when(command.version()).thenReturn("1.0.2");
    when(command.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);

    // Act
    long actualCreateResult = physicalSpecDefinitionService.create("janedoe", 1L, command);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(physicalSpecDefinitionDao).create(isA(PhysicalSpecDefinition.class));
    verify(command).delimiter();
    verify(command, atLeast(1)).status();
    verify(command).type();
    verify(command, atLeast(1)).version();
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionService#create(String, long, PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  void testCreate2() {
    // Arrange
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.create(Mockito.<PhysicalSpecDefinition>any()))
        .thenThrow(new IllegalStateException("userName cannot be null"));
    PhysicalSpecDefinitionService physicalSpecDefinitionService = new PhysicalSpecDefinitionService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        physicalSpecDefinitionDao, mock(PhysicalSpecDefinitionFieldDao.class),
        mock(PhysicalSpecDefinitionSampleFileDao.class));
    PhysicalSpecDefinitionChangeCommand command = mock(PhysicalSpecDefinitionChangeCommand.class);
    Optional<String> ofResult = Optional.of("foo");
    when(command.delimiter()).thenReturn(ofResult);
    when(command.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);
    when(command.version()).thenReturn("1.0.2");
    when(command.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> physicalSpecDefinitionService.create("janedoe", 1L, command));
    verify(physicalSpecDefinitionDao).create(isA(PhysicalSpecDefinition.class));
    verify(command).delimiter();
    verify(command, atLeast(1)).status();
    verify(command).type();
    verify(command).version();
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionService#create(String, long, PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  void testCreate3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.create(Mockito.<PhysicalSpecDefinition>any())).thenReturn(1L);
    PhysicalSpecDefinitionService physicalSpecDefinitionService = new PhysicalSpecDefinitionService(changeLogService,
        physicalSpecDefinitionDao, mock(PhysicalSpecDefinitionFieldDao.class),
        mock(PhysicalSpecDefinitionSampleFileDao.class));
    PhysicalSpecDefinitionChangeCommand command = mock(PhysicalSpecDefinitionChangeCommand.class);
    Optional<String> ofResult = Optional.of("foo");
    when(command.delimiter()).thenReturn(ofResult);
    when(command.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);
    when(command.version()).thenReturn("1.0.2");
    when(command.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);

    // Act
    long actualCreateResult = physicalSpecDefinitionService.create("janedoe", 1L, command);

    // Assert
    verify(physicalSpecDefinitionDao).create(isA(PhysicalSpecDefinition.class));
    verify(command).delimiter();
    verify(command, atLeast(1)).status();
    verify(command).type();
    verify(command, atLeast(1)).version();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionService#create(String, long, PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  void testCreate4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.markExistingActiveAsDeprecated(anyLong(), Mockito.<String>any())).thenReturn(1);
    when(physicalSpecDefinitionDao.create(Mockito.<PhysicalSpecDefinition>any())).thenReturn(1L);
    PhysicalSpecDefinitionService physicalSpecDefinitionService = new PhysicalSpecDefinitionService(changeLogService,
        physicalSpecDefinitionDao, mock(PhysicalSpecDefinitionFieldDao.class),
        mock(PhysicalSpecDefinitionSampleFileDao.class));
    PhysicalSpecDefinitionChangeCommand command = mock(PhysicalSpecDefinitionChangeCommand.class);
    Optional<String> ofResult = Optional.of("foo");
    when(command.delimiter()).thenReturn(ofResult);
    when(command.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);
    when(command.version()).thenReturn("1.0.2");
    when(command.status()).thenReturn(ReleaseLifecycleStatus.ACTIVE);

    // Act
    long actualCreateResult = physicalSpecDefinitionService.create("janedoe", 1L, command);

    // Assert
    verify(physicalSpecDefinitionDao).create(isA(PhysicalSpecDefinition.class));
    verify(physicalSpecDefinitionDao).markExistingActiveAsDeprecated(eq(1L), eq("janedoe"));
    verify(command).delimiter();
    verify(command, atLeast(1)).status();
    verify(command).type();
    verify(command, atLeast(1)).version();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionService#create(String, long, PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  void testCreate5() {
    // Arrange
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.markExistingActiveAsDeprecated(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalStateException("userName cannot be null"));
    PhysicalSpecDefinitionService physicalSpecDefinitionService = new PhysicalSpecDefinitionService(
        mock(ChangeLogService.class), physicalSpecDefinitionDao, mock(PhysicalSpecDefinitionFieldDao.class),
        mock(PhysicalSpecDefinitionSampleFileDao.class));
    PhysicalSpecDefinitionChangeCommand command = mock(PhysicalSpecDefinitionChangeCommand.class);
    when(command.status()).thenReturn(ReleaseLifecycleStatus.ACTIVE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> physicalSpecDefinitionService.create("janedoe", 1L, command));
    verify(physicalSpecDefinitionDao).markExistingActiveAsDeprecated(eq(1L), eq("janedoe"));
    verify(command).status();
  }

  /**
   * Method under test: {@link PhysicalSpecDefinitionService#delete(String, long)}
   */
  @Test
  void testDelete() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    PhysicalSpecDefinition physicalSpecDefinition = mock(PhysicalSpecDefinition.class);
    when(physicalSpecDefinition.specificationId()).thenReturn(1L);
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.delete(anyLong())).thenReturn(1);
    when(physicalSpecDefinitionDao.getById(anyLong())).thenReturn(physicalSpecDefinition);
    PhysicalSpecDefinitionFieldDao physicalSpecDefinitionFieldDao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(physicalSpecDefinitionFieldDao.deleteForSpecDefinition(anyLong())).thenReturn(1);
    PhysicalSpecDefinitionSampleFileDao physicalSpecDefinitionSampleFileDao = mock(
        PhysicalSpecDefinitionSampleFileDao.class);
    when(physicalSpecDefinitionSampleFileDao.deleteForSpecDefinition(anyLong())).thenReturn(1);

    // Act
    int actualDeleteResult = (new PhysicalSpecDefinitionService(changeLogService, physicalSpecDefinitionDao,
        physicalSpecDefinitionFieldDao, physicalSpecDefinitionSampleFileDao)).delete("janedoe", 1L);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(physicalSpecDefinitionDao).delete(eq(1L));
    verify(physicalSpecDefinitionDao).getById(eq(1L));
    verify(physicalSpecDefinitionFieldDao).deleteForSpecDefinition(eq(1L));
    verify(physicalSpecDefinitionSampleFileDao).deleteForSpecDefinition(eq(1L));
    verify(physicalSpecDefinition).specificationId();
    assertEquals(3, actualDeleteResult);
  }

  /**
   * Method under test: {@link PhysicalSpecDefinitionService#delete(String, long)}
   */
  @Test
  void testDelete2() {
    // Arrange
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.delete(anyLong())).thenReturn(1);
    when(physicalSpecDefinitionDao.getById(anyLong())).thenReturn(mock(PhysicalSpecDefinition.class));
    PhysicalSpecDefinitionFieldDao physicalSpecDefinitionFieldDao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(physicalSpecDefinitionFieldDao.deleteForSpecDefinition(anyLong())).thenReturn(1);
    PhysicalSpecDefinitionSampleFileDao physicalSpecDefinitionSampleFileDao = mock(
        PhysicalSpecDefinitionSampleFileDao.class);
    when(physicalSpecDefinitionSampleFileDao.deleteForSpecDefinition(anyLong()))
        .thenThrow(new IllegalStateException("userName cannot be null"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new PhysicalSpecDefinitionService(
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            physicalSpecDefinitionDao, physicalSpecDefinitionFieldDao, physicalSpecDefinitionSampleFileDao))
                .delete("janedoe", 1L));
    verify(physicalSpecDefinitionDao).delete(eq(1L));
    verify(physicalSpecDefinitionDao).getById(eq(1L));
    verify(physicalSpecDefinitionFieldDao).deleteForSpecDefinition(eq(1L));
    verify(physicalSpecDefinitionSampleFileDao).deleteForSpecDefinition(eq(1L));
  }

  /**
   * Method under test: {@link PhysicalSpecDefinitionService#delete(String, long)}
   */
  @Test
  void testDelete3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    PhysicalSpecDefinition physicalSpecDefinition = mock(PhysicalSpecDefinition.class);
    when(physicalSpecDefinition.specificationId()).thenReturn(1L);
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.delete(anyLong())).thenReturn(1);
    when(physicalSpecDefinitionDao.getById(anyLong())).thenReturn(physicalSpecDefinition);
    PhysicalSpecDefinitionFieldDao physicalSpecDefinitionFieldDao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(physicalSpecDefinitionFieldDao.deleteForSpecDefinition(anyLong())).thenReturn(1);
    PhysicalSpecDefinitionSampleFileDao physicalSpecDefinitionSampleFileDao = mock(
        PhysicalSpecDefinitionSampleFileDao.class);
    when(physicalSpecDefinitionSampleFileDao.deleteForSpecDefinition(anyLong())).thenReturn(1);

    // Act
    int actualDeleteResult = (new PhysicalSpecDefinitionService(changeLogService, physicalSpecDefinitionDao,
        physicalSpecDefinitionFieldDao, physicalSpecDefinitionSampleFileDao)).delete("janedoe", 1L);

    // Assert
    verify(physicalSpecDefinitionDao).delete(eq(1L));
    verify(physicalSpecDefinitionDao).getById(eq(1L));
    verify(physicalSpecDefinitionFieldDao).deleteForSpecDefinition(eq(1L));
    verify(physicalSpecDefinitionSampleFileDao).deleteForSpecDefinition(eq(1L));
    verify(physicalSpecDefinition).specificationId();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(3, actualDeleteResult);
  }

  /**
   * Method under test: {@link PhysicalSpecDefinitionService#delete(String, long)}
   */
  @Test
  void testDelete4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalStateException("userName cannot be null"));
    PhysicalSpecDefinition physicalSpecDefinition = mock(PhysicalSpecDefinition.class);
    when(physicalSpecDefinition.specificationId()).thenReturn(1L);
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.delete(anyLong())).thenReturn(1);
    when(physicalSpecDefinitionDao.getById(anyLong())).thenReturn(physicalSpecDefinition);
    PhysicalSpecDefinitionFieldDao physicalSpecDefinitionFieldDao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(physicalSpecDefinitionFieldDao.deleteForSpecDefinition(anyLong())).thenReturn(1);
    PhysicalSpecDefinitionSampleFileDao physicalSpecDefinitionSampleFileDao = mock(
        PhysicalSpecDefinitionSampleFileDao.class);
    when(physicalSpecDefinitionSampleFileDao.deleteForSpecDefinition(anyLong())).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new PhysicalSpecDefinitionService(changeLogService, physicalSpecDefinitionDao,
            physicalSpecDefinitionFieldDao, physicalSpecDefinitionSampleFileDao)).delete("janedoe", 1L));
    verify(physicalSpecDefinitionDao).delete(eq(1L));
    verify(physicalSpecDefinitionDao).getById(eq(1L));
    verify(physicalSpecDefinitionFieldDao).deleteForSpecDefinition(eq(1L));
    verify(physicalSpecDefinitionSampleFileDao).deleteForSpecDefinition(eq(1L));
    verify(physicalSpecDefinition).specificationId();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionService#findForSpecification(long)}
   */
  @Test
  void testFindForSpecification() {
    // Arrange
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    ArrayList<PhysicalSpecDefinition> physicalSpecDefinitionList = new ArrayList<>();
    when(physicalSpecDefinitionDao.findForSpecification(anyLong())).thenReturn(physicalSpecDefinitionList);

    // Act
    List<PhysicalSpecDefinition> actualFindForSpecificationResult = (new PhysicalSpecDefinitionService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        physicalSpecDefinitionDao, mock(PhysicalSpecDefinitionFieldDao.class),
        mock(PhysicalSpecDefinitionSampleFileDao.class))).findForSpecification(1L);

    // Assert
    verify(physicalSpecDefinitionDao).findForSpecification(eq(1L));
    assertTrue(actualFindForSpecificationResult.isEmpty());
    assertSame(physicalSpecDefinitionList, actualFindForSpecificationResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionService#findForSpecification(long)}
   */
  @Test
  void testFindForSpecification2() {
    // Arrange
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.findForSpecification(anyLong())).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new PhysicalSpecDefinitionService(
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            physicalSpecDefinitionDao, mock(PhysicalSpecDefinitionFieldDao.class),
            mock(PhysicalSpecDefinitionSampleFileDao.class))).findForSpecification(1L));
    verify(physicalSpecDefinitionDao).findForSpecification(eq(1L));
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionService#updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  void testUpdateStatus() {
    // Arrange
    PhysicalSpecDefinition physicalSpecDefinition = mock(PhysicalSpecDefinition.class);
    when(physicalSpecDefinition.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.getById(anyLong())).thenReturn(physicalSpecDefinition);
    PhysicalSpecDefinitionService physicalSpecDefinitionService = new PhysicalSpecDefinitionService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        physicalSpecDefinitionDao, mock(PhysicalSpecDefinitionFieldDao.class),
        mock(PhysicalSpecDefinitionSampleFileDao.class));
    ReleaseLifecycleStatusChangeCommand command = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(command.newStatus()).thenReturn(ReleaseLifecycleStatus.DRAFT);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> physicalSpecDefinitionService.updateStatus("janedoe", 1L, command));
    verify(physicalSpecDefinitionDao).getById(eq(1L));
    verify(command).newStatus();
    verify(physicalSpecDefinition).status();
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionService#updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  void testUpdateStatus2() {
    // Arrange
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.getById(anyLong())).thenReturn(mock(PhysicalSpecDefinition.class));
    PhysicalSpecDefinitionService physicalSpecDefinitionService = new PhysicalSpecDefinitionService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        physicalSpecDefinitionDao, mock(PhysicalSpecDefinitionFieldDao.class),
        mock(PhysicalSpecDefinitionSampleFileDao.class));
    ReleaseLifecycleStatusChangeCommand command = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(command.newStatus()).thenThrow(new IllegalStateException("userName cannot be null"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> physicalSpecDefinitionService.updateStatus("janedoe", 1L, command));
    verify(physicalSpecDefinitionDao).getById(eq(1L));
    verify(command).newStatus();
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionService#updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  void testUpdateStatus3() {
    // Arrange
    PhysicalSpecDefinition physicalSpecDefinition = mock(PhysicalSpecDefinition.class);
    when(physicalSpecDefinition.status()).thenReturn(null);
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.getById(anyLong())).thenReturn(physicalSpecDefinition);
    PhysicalSpecDefinitionService physicalSpecDefinitionService = new PhysicalSpecDefinitionService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        physicalSpecDefinitionDao, mock(PhysicalSpecDefinitionFieldDao.class),
        mock(PhysicalSpecDefinitionSampleFileDao.class));
    ReleaseLifecycleStatusChangeCommand command = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(command.newStatus()).thenReturn(ReleaseLifecycleStatus.DRAFT);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> physicalSpecDefinitionService.updateStatus("janedoe", 1L, command));
    verify(physicalSpecDefinitionDao).getById(eq(1L));
    verify(command).newStatus();
    verify(physicalSpecDefinition).status();
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionService#updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  void testUpdateStatus4() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    PhysicalSpecDefinition physicalSpecDefinition = mock(PhysicalSpecDefinition.class);
    when(physicalSpecDefinition.specificationId()).thenReturn(1L);
    when(physicalSpecDefinition.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.markExistingActiveAsDeprecated(anyLong(), Mockito.<String>any())).thenReturn(1);
    when(
        physicalSpecDefinitionDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any(), Mockito.<String>any()))
            .thenReturn(1);
    when(physicalSpecDefinitionDao.getById(anyLong())).thenReturn(physicalSpecDefinition);
    PhysicalSpecDefinitionService physicalSpecDefinitionService = new PhysicalSpecDefinitionService(changeLogService,
        physicalSpecDefinitionDao, mock(PhysicalSpecDefinitionFieldDao.class),
        mock(PhysicalSpecDefinitionSampleFileDao.class));
    ReleaseLifecycleStatusChangeCommand command = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(command.newStatus()).thenReturn(ReleaseLifecycleStatus.ACTIVE);

    // Act
    boolean actualUpdateStatusResult = physicalSpecDefinitionService.updateStatus("janedoe", 1L, command);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(physicalSpecDefinitionDao).getById(eq(1L));
    verify(physicalSpecDefinitionDao).markExistingActiveAsDeprecated(eq(1L), eq("janedoe"));
    verify(physicalSpecDefinitionDao).updateStatus(eq(1L), eq(ReleaseLifecycleStatus.ACTIVE), eq("janedoe"));
    verify(command, atLeast(1)).newStatus();
    verify(physicalSpecDefinition, atLeast(1)).specificationId();
    verify(physicalSpecDefinition).status();
    assertTrue(actualUpdateStatusResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionService#updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  void testUpdateStatus5() {
    // Arrange
    PhysicalSpecDefinition physicalSpecDefinition = mock(PhysicalSpecDefinition.class);
    when(physicalSpecDefinition.specificationId()).thenThrow(new IllegalStateException("userName cannot be null"));
    when(physicalSpecDefinition.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.getById(anyLong())).thenReturn(physicalSpecDefinition);
    PhysicalSpecDefinitionService physicalSpecDefinitionService = new PhysicalSpecDefinitionService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        physicalSpecDefinitionDao, mock(PhysicalSpecDefinitionFieldDao.class),
        mock(PhysicalSpecDefinitionSampleFileDao.class));
    ReleaseLifecycleStatusChangeCommand command = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(command.newStatus()).thenReturn(ReleaseLifecycleStatus.ACTIVE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> physicalSpecDefinitionService.updateStatus("janedoe", 1L, command));
    verify(physicalSpecDefinitionDao).getById(eq(1L));
    verify(command, atLeast(1)).newStatus();
    verify(physicalSpecDefinition).specificationId();
    verify(physicalSpecDefinition).status();
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionService#updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  void testUpdateStatus6() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    PhysicalSpecDefinition physicalSpecDefinition = mock(PhysicalSpecDefinition.class);
    when(physicalSpecDefinition.specificationId()).thenReturn(1L);
    when(physicalSpecDefinition.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.markExistingActiveAsDeprecated(anyLong(), Mockito.<String>any())).thenReturn(1);
    when(
        physicalSpecDefinitionDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any(), Mockito.<String>any()))
            .thenReturn(1);
    when(physicalSpecDefinitionDao.getById(anyLong())).thenReturn(physicalSpecDefinition);
    PhysicalSpecDefinitionService physicalSpecDefinitionService = new PhysicalSpecDefinitionService(changeLogService,
        physicalSpecDefinitionDao, mock(PhysicalSpecDefinitionFieldDao.class),
        mock(PhysicalSpecDefinitionSampleFileDao.class));
    ReleaseLifecycleStatusChangeCommand command = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(command.newStatus()).thenReturn(ReleaseLifecycleStatus.ACTIVE);

    // Act
    boolean actualUpdateStatusResult = physicalSpecDefinitionService.updateStatus("janedoe", 1L, command);

    // Assert
    verify(physicalSpecDefinitionDao).getById(eq(1L));
    verify(physicalSpecDefinitionDao).markExistingActiveAsDeprecated(eq(1L), eq("janedoe"));
    verify(physicalSpecDefinitionDao).updateStatus(eq(1L), eq(ReleaseLifecycleStatus.ACTIVE), eq("janedoe"));
    verify(command, atLeast(1)).newStatus();
    verify(physicalSpecDefinition, atLeast(1)).specificationId();
    verify(physicalSpecDefinition).status();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateStatusResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionService#updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  void testUpdateStatus7() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    PhysicalSpecDefinition physicalSpecDefinition = mock(PhysicalSpecDefinition.class);
    when(physicalSpecDefinition.specificationId()).thenReturn(1L);
    when(physicalSpecDefinition.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.markExistingActiveAsDeprecated(anyLong(), Mockito.<String>any())).thenReturn(1);
    when(
        physicalSpecDefinitionDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any(), Mockito.<String>any()))
            .thenReturn(2);
    when(physicalSpecDefinitionDao.getById(anyLong())).thenReturn(physicalSpecDefinition);
    PhysicalSpecDefinitionService physicalSpecDefinitionService = new PhysicalSpecDefinitionService(changeLogService,
        physicalSpecDefinitionDao, mock(PhysicalSpecDefinitionFieldDao.class),
        mock(PhysicalSpecDefinitionSampleFileDao.class));
    ReleaseLifecycleStatusChangeCommand command = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(command.newStatus()).thenReturn(ReleaseLifecycleStatus.ACTIVE);

    // Act
    boolean actualUpdateStatusResult = physicalSpecDefinitionService.updateStatus("janedoe", 1L, command);

    // Assert
    verify(physicalSpecDefinitionDao).getById(eq(1L));
    verify(physicalSpecDefinitionDao).markExistingActiveAsDeprecated(eq(1L), eq("janedoe"));
    verify(physicalSpecDefinitionDao).updateStatus(eq(1L), eq(ReleaseLifecycleStatus.ACTIVE), eq("janedoe"));
    verify(command, atLeast(1)).newStatus();
    verify(physicalSpecDefinition, atLeast(1)).specificationId();
    verify(physicalSpecDefinition).status();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualUpdateStatusResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionService#updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  void testUpdateStatus8() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalStateException("userName cannot be null"));
    PhysicalSpecDefinition physicalSpecDefinition = mock(PhysicalSpecDefinition.class);
    when(physicalSpecDefinition.specificationId()).thenReturn(1L);
    when(physicalSpecDefinition.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.markExistingActiveAsDeprecated(anyLong(), Mockito.<String>any())).thenReturn(1);
    when(
        physicalSpecDefinitionDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any(), Mockito.<String>any()))
            .thenReturn(1);
    when(physicalSpecDefinitionDao.getById(anyLong())).thenReturn(physicalSpecDefinition);
    PhysicalSpecDefinitionService physicalSpecDefinitionService = new PhysicalSpecDefinitionService(changeLogService,
        physicalSpecDefinitionDao, mock(PhysicalSpecDefinitionFieldDao.class),
        mock(PhysicalSpecDefinitionSampleFileDao.class));
    ReleaseLifecycleStatusChangeCommand command = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(command.newStatus()).thenReturn(ReleaseLifecycleStatus.ACTIVE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> physicalSpecDefinitionService.updateStatus("janedoe", 1L, command));
    verify(physicalSpecDefinitionDao).getById(eq(1L));
    verify(physicalSpecDefinitionDao).markExistingActiveAsDeprecated(eq(1L), eq("janedoe"));
    verify(physicalSpecDefinitionDao).updateStatus(eq(1L), eq(ReleaseLifecycleStatus.ACTIVE), eq("janedoe"));
    verify(command, atLeast(1)).newStatus();
    verify(physicalSpecDefinition, atLeast(1)).specificationId();
    verify(physicalSpecDefinition).status();
    verify(changeLogService).write(isA(ChangeLog.class));
  }
}
