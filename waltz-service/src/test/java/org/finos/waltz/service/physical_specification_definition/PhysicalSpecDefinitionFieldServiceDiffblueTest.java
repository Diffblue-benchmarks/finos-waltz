package org.finos.waltz.service.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.finos.waltz.data.physical_specification_definition.PhysicalSpecDefinitionFieldDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FieldDataType;
import org.finos.waltz.model.UpdateDescriptionCommand;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.logical_data_element.LogicalDataElementChangeCommand;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionField;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionFieldChangeCommand;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalSpecDefinitionFieldServiceDiffblueTest {
  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionFieldService#create(String, long, PhysicalSpecDefinitionFieldChangeCommand)}
   */
  @Test
  void testCreate() {
    // Arrange
    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.create(Mockito.<PhysicalSpecDefinitionField>any())).thenReturn(1L);
    PhysicalSpecDefinitionFieldService physicalSpecDefinitionFieldService = new PhysicalSpecDefinitionFieldService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        dao);
    PhysicalSpecDefinitionFieldChangeCommand command = mock(PhysicalSpecDefinitionFieldChangeCommand.class);
    when(command.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(command.logicalDataElementId()).thenReturn(ofResult);
    when(command.position()).thenReturn(1);
    when(command.type()).thenReturn(FieldDataType.DATE);
    when(command.name()).thenReturn("Name");

    // Act
    long actualCreateResult = physicalSpecDefinitionFieldService.create("janedoe", 1L, command);

    // Assert
    verify(dao).create(isA(PhysicalSpecDefinitionField.class));
    verify(command).description();
    verify(command).name();
    verify(command).logicalDataElementId();
    verify(command).position();
    verify(command).type();
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Method under test: {@link PhysicalSpecDefinitionFieldService#delete(long)}
   */
  @Test
  void testDelete() {
    // Arrange
    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.delete(anyLong())).thenReturn(1);

    // Act
    int actualDeleteResult = (new PhysicalSpecDefinitionFieldService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        dao)).delete(1L);

    // Assert
    verify(dao).delete(eq(1L));
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionFieldService#deleteForSpecDefinition(long)}
   */
  @Test
  void testDeleteForSpecDefinition() {
    // Arrange
    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.deleteForSpecDefinition(anyLong())).thenReturn(1);

    // Act
    int actualDeleteForSpecDefinitionResult = (new PhysicalSpecDefinitionFieldService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        dao)).deleteForSpecDefinition(1L);

    // Assert
    verify(dao).deleteForSpecDefinition(eq(1L));
    assertEquals(1, actualDeleteForSpecDefinitionResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionFieldService#findForSpecDefinition(long)}
   */
  @Test
  void testFindForSpecDefinition() {
    // Arrange
    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    ArrayList<PhysicalSpecDefinitionField> physicalSpecDefinitionFieldList = new ArrayList<>();
    when(dao.findForSpecDefinition(anyLong())).thenReturn(physicalSpecDefinitionFieldList);

    // Act
    List<PhysicalSpecDefinitionField> actualFindForSpecDefinitionResult = (new PhysicalSpecDefinitionFieldService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        dao)).findForSpecDefinition(1L);

    // Assert
    verify(dao).findForSpecDefinition(eq(1L));
    assertTrue(actualFindForSpecDefinitionResult.isEmpty());
    assertSame(physicalSpecDefinitionFieldList, actualFindForSpecDefinitionResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionFieldService#updateDescription(String, long, UpdateDescriptionCommand)}
   */
  @Test
  void testUpdateDescription() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.updateDescription(anyLong(), Mockito.<String>any())).thenReturn(1);
    PhysicalSpecDefinitionFieldService physicalSpecDefinitionFieldService = new PhysicalSpecDefinitionFieldService(
        changeLogService, dao);
    UpdateDescriptionCommand command = mock(UpdateDescriptionCommand.class);
    when(command.newDescription()).thenReturn("New Description");

    // Act
    int actualUpdateDescriptionResult = physicalSpecDefinitionFieldService.updateDescription("janedoe", 1L, command);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(dao).updateDescription(eq(1L), eq("New Description"));
    verify(command).newDescription();
    assertEquals(1, actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionFieldService#updateDescription(String, long, UpdateDescriptionCommand)}
   */
  @Test
  void testUpdateDescription2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.updateDescription(anyLong(), Mockito.<String>any())).thenReturn(1);
    PhysicalSpecDefinitionFieldService physicalSpecDefinitionFieldService = new PhysicalSpecDefinitionFieldService(
        changeLogService, dao);
    UpdateDescriptionCommand command = mock(UpdateDescriptionCommand.class);
    when(command.newDescription()).thenReturn("New Description");

    // Act
    int actualUpdateDescriptionResult = physicalSpecDefinitionFieldService.updateDescription("janedoe", 1L, command);

    // Assert
    verify(dao).updateDescription(eq(1L), eq("New Description"));
    verify(command).newDescription();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionFieldService#updateLogicalDataElement(String, long, LogicalDataElementChangeCommand)}
   */
  @Test
  void testUpdateLogicalDataElement() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.updateLogicalDataElement(anyLong(), Mockito.<Long>any())).thenReturn(1);
    PhysicalSpecDefinitionFieldService physicalSpecDefinitionFieldService = new PhysicalSpecDefinitionFieldService(
        changeLogService, dao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    Optional<EntityReference> ofResult = Optional.of(entityReference);
    LogicalDataElementChangeCommand command = mock(LogicalDataElementChangeCommand.class);
    when(command.newLogicalDataElement()).thenReturn(ofResult);

    // Act
    int actualUpdateLogicalDataElementResult = physicalSpecDefinitionFieldService.updateLogicalDataElement("janedoe",
        1L, command);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(dao).updateLogicalDataElement(eq(1L), eq(1L));
    verify(entityReference).id();
    verify(command, atLeast(1)).newLogicalDataElement();
    assertEquals(1, actualUpdateLogicalDataElementResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionFieldService#updateLogicalDataElement(String, long, LogicalDataElementChangeCommand)}
   */
  @Test
  void testUpdateLogicalDataElement2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.updateLogicalDataElement(anyLong(), Mockito.<Long>any())).thenReturn(1);
    PhysicalSpecDefinitionFieldService physicalSpecDefinitionFieldService = new PhysicalSpecDefinitionFieldService(
        changeLogService, dao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    Optional<EntityReference> ofResult = Optional.of(entityReference);
    LogicalDataElementChangeCommand command = mock(LogicalDataElementChangeCommand.class);
    when(command.newLogicalDataElement()).thenReturn(ofResult);

    // Act
    int actualUpdateLogicalDataElementResult = physicalSpecDefinitionFieldService.updateLogicalDataElement("janedoe",
        1L, command);

    // Assert
    verify(dao).updateLogicalDataElement(eq(1L), eq(1L));
    verify(entityReference).id();
    verify(command, atLeast(1)).newLogicalDataElement();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateLogicalDataElementResult);
  }

  /**
   * Method under test:
   * {@link PhysicalSpecDefinitionFieldService#updateLogicalDataElement(String, long, LogicalDataElementChangeCommand)}
   */
  @Test
  void testUpdateLogicalDataElement3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.updateLogicalDataElement(anyLong(), Mockito.<Long>any())).thenReturn(1);
    PhysicalSpecDefinitionFieldService physicalSpecDefinitionFieldService = new PhysicalSpecDefinitionFieldService(
        changeLogService, dao);
    LogicalDataElementChangeCommand command = mock(LogicalDataElementChangeCommand.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(command.newLogicalDataElement()).thenReturn(emptyResult);

    // Act
    int actualUpdateLogicalDataElementResult = physicalSpecDefinitionFieldService.updateLogicalDataElement("janedoe",
        1L, command);

    // Assert
    verify(dao).updateLogicalDataElement(eq(1L), isNull());
    verify(command, atLeast(1)).newLogicalDataElement();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateLogicalDataElementResult);
  }
}
