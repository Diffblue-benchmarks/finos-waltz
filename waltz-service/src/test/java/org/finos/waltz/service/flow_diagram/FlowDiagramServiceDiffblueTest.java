package org.finos.waltz.service.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.actor.ActorDao;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.change_initiative.ChangeInitiativeDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.data_type.search.DataTypeSearchDao;
import org.finos.waltz.data.end_user_app.EndUserAppDao;
import org.finos.waltz.data.flow_diagram.FlowDiagramAnnotationDao;
import org.finos.waltz.data.flow_diagram.FlowDiagramDao;
import org.finos.waltz.data.flow_diagram.FlowDiagramEntityDao;
import org.finos.waltz.data.flow_diagram.FlowDiagramOverlayGroupDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.UpdateDescriptionCommand;
import org.finos.waltz.model.UpdateNameCommand;
import org.finos.waltz.model.actor.Actor;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.flow_diagram.FlowDiagram;
import org.finos.waltz.model.flow_diagram.FlowDiagramAnnotation;
import org.finos.waltz.model.flow_diagram.FlowDiagramEntity;
import org.finos.waltz.model.flow_diagram.FlowDiagramOverlayGroupEntry;
import org.finos.waltz.model.flow_diagram.SaveDiagramCommand;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.data_type.DataTypeService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.jooq.exception.InvalidResultException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowDiagramServiceDiffblueTest {
  /**
   * Method under test: {@link FlowDiagramService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.getById(anyLong())).thenReturn(null);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);

    // Act
    FlowDiagram actualById = (new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class)))
            .getById(1L);

    // Assert
    verify(flowDiagramDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link FlowDiagramService#getById(long)}
   */
  @Test
  void testGetById2() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.getById(anyLong())).thenThrow(new InvalidResultException("An error occurred"));
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);

    // Act and Assert
    assertThrows(InvalidResultException.class,
        () -> (new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao, flowDiagramEntityDao,
            flowDiagramAnnotationDao, new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)),
            mock(ApplicationDao.class), mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(ActorDao.class), mock(EndUserAppDao.class),
            mock(MeasurableDao.class), mock(ChangeInitiativeDao.class))).getById(1L));
    verify(flowDiagramDao).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#cloneDiagram(long, String, String)}
   */
  @Test
  void testCloneDiagram() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.clone(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(1L);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    doNothing().when(flowDiagramEntityDao).clone(anyLong(), Mockito.<Long>any());
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    doNothing().when(flowDiagramAnnotationDao).clone(anyLong(), Mockito.<Long>any());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    // Act
    Long actualCloneDiagramResult = (new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class)))
            .cloneDiagram(1L, "New Name", "42");

    // Assert
    verify(flowDiagramAnnotationDao).clone(eq(1L), eq(1L));
    verify(flowDiagramDao).clone(eq(1L), eq("New Name"), eq("42"));
    verify(flowDiagramEntityDao).clone(eq(1L), eq(1L));
    assertEquals(1L, actualCloneDiagramResult.longValue());
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#cloneDiagram(long, String, String)}
   */
  @Test
  void testCloneDiagram2() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.clone(anyLong(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(1L);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    doNothing().when(flowDiagramEntityDao).clone(anyLong(), Mockito.<Long>any());
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    doThrow(new InvalidResultException("An error occurred")).when(flowDiagramAnnotationDao)
        .clone(anyLong(), Mockito.<Long>any());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    // Act and Assert
    assertThrows(InvalidResultException.class,
        () -> (new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao, flowDiagramEntityDao,
            flowDiagramAnnotationDao, new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)),
            mock(ApplicationDao.class), mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(ActorDao.class), mock(EndUserAppDao.class),
            mock(MeasurableDao.class), mock(ChangeInitiativeDao.class))).cloneDiagram(1L, "New Name", "42"));
    verify(flowDiagramAnnotationDao).clone(eq(1L), eq(1L));
    verify(flowDiagramDao).clone(eq(1L), eq("New Name"), eq("42"));
    verify(flowDiagramEntityDao).clone(eq(1L), eq(1L));
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    ArrayList<FlowDiagram> flowDiagramList = new ArrayList<>();
    when(flowDiagramDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(flowDiagramList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);

    // Act
    List<FlowDiagram> actualFindByEntityReferenceResult = (new FlowDiagramService(changeLogService, dataTypeService,
        flowDiagramDao, flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class)))
            .findByEntityReference(mock(EntityReference.class));

    // Assert
    verify(flowDiagramDao).findByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(flowDiagramList, actualFindByEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference2() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new InvalidResultException("An error occurred"));
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);

    // Act and Assert
    assertThrows(InvalidResultException.class,
        () -> (new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao, flowDiagramEntityDao,
            flowDiagramAnnotationDao, new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)),
            mock(ApplicationDao.class), mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(ActorDao.class), mock(EndUserAppDao.class),
            mock(MeasurableDao.class), mock(ChangeInitiativeDao.class)))
                .findByEntityReference(mock(EntityReference.class)));
    verify(flowDiagramDao).findByEntityReference(isA(EntityReference.class));
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#findForSelector(IdSelectionOptions)}
   */
  @Test
  void testFindForSelector() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    ArrayList<FlowDiagram> flowDiagramList = new ArrayList<>();
    when(flowDiagramDao.findForSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(flowDiagramList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<FlowDiagram> actualFindForSelectorResult = flowDiagramService.findForSelector(options);

    // Assert
    verify(flowDiagramDao).findForSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindForSelectorResult.isEmpty());
    assertSame(flowDiagramList, actualFindForSelectorResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  void testSave() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(new ArrayList<>());
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = mock(FlowDiagramOverlayGroupDao.class);
    when(flowDiagramOverlayGroupDao.createOverlays(Mockito.<Set<FlowDiagramOverlayGroupEntry>>any())).thenReturn(1);
    when(flowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Mockito.<Long>any())).thenReturn(1);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService = new FlowDiagramOverlayGroupService(
        flowDiagramOverlayGroupDao);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)),
        flowDiagramDao, flowDiagramEntityDao, flowDiagramAnnotationDao, flowDiagramOverlayGroupService,
        mock(ApplicationDao.class), mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class),
        mock(PhysicalSpecificationDao.class), mock(ActorDao.class), mock(EndUserAppDao.class),
        mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    SaveDiagramCommand command = mock(SaveDiagramCommand.class);
    when(command.annotations()).thenReturn(new ArrayList<>());
    when(command.entities()).thenReturn(new ArrayList<>());
    when(command.overlays()).thenReturn(new HashSet<>());
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.layoutData()).thenReturn("Layout Data");
    when(command.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(command.diagramId()).thenReturn(ofResult);

    // Act
    long actualSaveResult = flowDiagramService.save(command, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(eq(1L));
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(eq(1L));
    verify(flowDiagramEntityDao).findForDiagram(eq(1L));
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).deleteOverlaysForDiagram(eq(1L));
    verify(command).description();
    verify(command).name();
    verify(command).annotations();
    verify(command).diagramId();
    verify(command, atLeast(1)).entities();
    verify(command).layoutData();
    verify(command).overlays();
    assertEquals(1L, actualSaveResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  void testSave2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(new ArrayList<>());
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    SaveDiagramCommand command = mock(SaveDiagramCommand.class);
    when(command.entities()).thenThrow(new UnsupportedOperationException("command cannot be null"));
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.layoutData()).thenReturn("Layout Data");
    when(command.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(command.diagramId()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> flowDiagramService.save(command, "janedoe"));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(eq(1L));
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).deleteForDiagram(eq(1L));
    verify(flowDiagramEntityDao).findForDiagram(eq(1L));
    verify(command).description();
    verify(command).name();
    verify(command).diagramId();
    verify(command).entities();
    verify(command).layoutData();
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  void testSave3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(new ArrayList<>());
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = mock(FlowDiagramOverlayGroupDao.class);
    when(flowDiagramOverlayGroupDao.createOverlays(Mockito.<Set<FlowDiagramOverlayGroupEntry>>any())).thenReturn(1);
    when(flowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Mockito.<Long>any())).thenReturn(1);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService = new FlowDiagramOverlayGroupService(
        flowDiagramOverlayGroupDao);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)),
        flowDiagramDao, flowDiagramEntityDao, flowDiagramAnnotationDao, flowDiagramOverlayGroupService,
        mock(ApplicationDao.class), mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class),
        mock(PhysicalSpecificationDao.class), mock(ActorDao.class), mock(EndUserAppDao.class),
        mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    SaveDiagramCommand command = mock(SaveDiagramCommand.class);
    when(command.annotations()).thenReturn(new ArrayList<>());
    when(command.entities()).thenReturn(new ArrayList<>());
    when(command.overlays()).thenReturn(new HashSet<>());
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.layoutData()).thenReturn("Layout Data");
    when(command.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(command.diagramId()).thenReturn(ofResult);

    // Act
    long actualSaveResult = flowDiagramService.save(command, "janedoe");

    // Assert
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(eq(1L));
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(eq(1L));
    verify(flowDiagramEntityDao).findForDiagram(eq(1L));
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).deleteOverlaysForDiagram(eq(1L));
    verify(command).description();
    verify(command).name();
    verify(command).annotations();
    verify(command).diagramId();
    verify(command, atLeast(1)).entities();
    verify(command).layoutData();
    verify(command).overlays();
    verify(changeLogService).write(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualSaveResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  void testSave4() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(false);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    SaveDiagramCommand command = mock(SaveDiagramCommand.class);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.layoutData()).thenReturn("Layout Data");
    when(command.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(command.diagramId()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(InvalidResultException.class, () -> flowDiagramService.save(command, "janedoe"));
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(command).description();
    verify(command).name();
    verify(command).diagramId();
    verify(command).layoutData();
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  void testSave5() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);
    FlowDiagramEntity flowDiagramEntity = mock(FlowDiagramEntity.class);
    when(flowDiagramEntity.entityReference()).thenReturn(null);
    FlowDiagramEntity flowDiagramEntity2 = mock(FlowDiagramEntity.class);
    when(flowDiagramEntity2.entityReference()).thenReturn(null);
    FlowDiagramEntity flowDiagramEntity3 = mock(FlowDiagramEntity.class);
    when(flowDiagramEntity3.entityReference()).thenThrow(new InvalidResultException("An error occurred"));

    ArrayList<FlowDiagramEntity> flowDiagramEntityList = new ArrayList<>();
    flowDiagramEntityList.add(flowDiagramEntity3);
    flowDiagramEntityList.add(flowDiagramEntity2);
    flowDiagramEntityList.add(flowDiagramEntity);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(flowDiagramEntityList);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    SaveDiagramCommand command = mock(SaveDiagramCommand.class);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.layoutData()).thenReturn("Layout Data");
    when(command.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(command.diagramId()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(InvalidResultException.class, () -> flowDiagramService.save(command, "janedoe"));
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).findForDiagram(eq(1L));
    verify(command).description();
    verify(command).name();
    verify(flowDiagramEntity3).entityReference();
    verify(command).diagramId();
    verify(command).layoutData();
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  void testSave6() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.create(Mockito.<FlowDiagram>any())).thenReturn(1L);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = mock(FlowDiagramOverlayGroupDao.class);
    when(flowDiagramOverlayGroupDao.createOverlays(Mockito.<Set<FlowDiagramOverlayGroupEntry>>any())).thenReturn(1);
    when(flowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Mockito.<Long>any())).thenReturn(1);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService = new FlowDiagramOverlayGroupService(
        flowDiagramOverlayGroupDao);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)),
        flowDiagramDao, flowDiagramEntityDao, flowDiagramAnnotationDao, flowDiagramOverlayGroupService,
        mock(ApplicationDao.class), mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class),
        mock(PhysicalSpecificationDao.class), mock(ActorDao.class), mock(EndUserAppDao.class),
        mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    SaveDiagramCommand command = mock(SaveDiagramCommand.class);
    when(command.annotations()).thenReturn(new ArrayList<>());
    when(command.entities()).thenReturn(new ArrayList<>());
    when(command.overlays()).thenReturn(new HashSet<>());
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.layoutData()).thenReturn("Layout Data");
    when(command.name()).thenReturn("Name");
    Optional<Long> emptyResult = Optional.empty();
    when(command.diagramId()).thenReturn(emptyResult);

    // Act
    long actualSaveResult = flowDiagramService.save(command, "janedoe");

    // Assert
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramDao).create(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).deleteOverlaysForDiagram(eq(1L));
    verify(command).description();
    verify(command).name();
    verify(command).annotations();
    verify(command).diagramId();
    verify(command, atLeast(1)).entities();
    verify(command).layoutData();
    verify(command).overlays();
    verify(changeLogService).write(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualSaveResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  void testSave7() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.create(Mockito.<FlowDiagram>any())).thenReturn(1L);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService = mock(FlowDiagramOverlayGroupService.class);
    when(flowDiagramOverlayGroupService.updateOverlaysForDiagram(Mockito.<Long>any(),
        Mockito.<Set<FlowDiagramOverlayGroupEntry>>any(), Mockito.<String>any())).thenReturn(1);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService,
        new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)),
        flowDiagramDao, flowDiagramEntityDao, flowDiagramAnnotationDao, flowDiagramOverlayGroupService,
        mock(ApplicationDao.class), mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class),
        mock(PhysicalSpecificationDao.class), mock(ActorDao.class), mock(EndUserAppDao.class),
        mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    SaveDiagramCommand command = mock(SaveDiagramCommand.class);
    when(command.annotations()).thenReturn(new ArrayList<>());
    when(command.entities()).thenReturn(new ArrayList<>());
    when(command.overlays()).thenReturn(new HashSet<>());
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.layoutData()).thenReturn("Layout Data");
    when(command.name()).thenReturn("Name");
    Optional<Long> emptyResult = Optional.empty();
    when(command.diagramId()).thenReturn(emptyResult);

    // Act
    long actualSaveResult = flowDiagramService.save(command, "janedoe");

    // Assert
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramDao).create(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(command).description();
    verify(command).name();
    verify(command).annotations();
    verify(command).diagramId();
    verify(command, atLeast(1)).entities();
    verify(command).layoutData();
    verify(command).overlays();
    verify(changeLogService).write(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(flowDiagramOverlayGroupService).updateOverlaysForDiagram(eq(1L), isA(Set.class), eq("janedoe"));
    assertEquals(1L, actualSaveResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#updateName(long, UpdateNameCommand, String)}
   */
  @Test
  void testUpdateName() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.updateName(anyLong(), Mockito.<String>any())).thenReturn(true);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    UpdateNameCommand command = mock(UpdateNameCommand.class);
    when(command.newName()).thenReturn("New Name");

    // Act
    boolean actualUpdateNameResult = flowDiagramService.updateName(1L, command, "janedoe");

    // Assert
    verify(flowDiagramDao).updateName(eq(1L), eq("New Name"));
    verify(command).newName();
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#updateName(long, UpdateNameCommand, String)}
   */
  @Test
  void testUpdateName2() {
    // Arrange
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    UpdateNameCommand command = mock(UpdateNameCommand.class);
    when(command.newName()).thenThrow(new InvalidResultException("An error occurred"));

    // Act and Assert
    assertThrows(InvalidResultException.class, () -> flowDiagramService.updateName(1L, command, "janedoe"));
    verify(command).newName();
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#updateName(long, UpdateNameCommand, String)}
   */
  @Test
  void testUpdateName3() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.updateName(anyLong(), Mockito.<String>any())).thenReturn(false);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    UpdateNameCommand command = mock(UpdateNameCommand.class);
    when(command.newName()).thenReturn("New Name");

    // Act
    boolean actualUpdateNameResult = flowDiagramService.updateName(1L, command, "janedoe");

    // Assert
    verify(flowDiagramDao).updateName(eq(1L), eq("New Name"));
    verify(command).newName();
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#updateDescription(long, UpdateDescriptionCommand, String)}
   */
  @Test
  void testUpdateDescription() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.updateDescription(anyLong(), Mockito.<String>any())).thenReturn(true);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    UpdateDescriptionCommand command = mock(UpdateDescriptionCommand.class);
    when(command.newDescription()).thenReturn("New Description");

    // Act
    boolean actualUpdateDescriptionResult = flowDiagramService.updateDescription(1L, command, "janedoe");

    // Assert
    verify(flowDiagramDao).updateDescription(eq(1L), eq("New Description"));
    verify(command).newDescription();
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#updateDescription(long, UpdateDescriptionCommand, String)}
   */
  @Test
  void testUpdateDescription2() {
    // Arrange
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    UpdateDescriptionCommand command = mock(UpdateDescriptionCommand.class);
    when(command.newDescription()).thenThrow(new InvalidResultException("An error occurred"));

    // Act and Assert
    assertThrows(InvalidResultException.class, () -> flowDiagramService.updateDescription(1L, command, "janedoe"));
    verify(command).newDescription();
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#updateDescription(long, UpdateDescriptionCommand, String)}
   */
  @Test
  void testUpdateDescription3() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.updateDescription(anyLong(), Mockito.<String>any())).thenReturn(false);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    UpdateDescriptionCommand command = mock(UpdateDescriptionCommand.class);
    when(command.newDescription()).thenReturn("New Description");

    // Act
    boolean actualUpdateDescriptionResult = flowDiagramService.updateDescription(1L, command, "janedoe");

    // Assert
    verify(flowDiagramDao).updateDescription(eq(1L), eq("New Description"));
    verify(command).newDescription();
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Method under test: {@link FlowDiagramService#deleteById(long, String)}
   */
  @Test
  void testDeleteById() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.deleteById(anyLong(), Mockito.<String>any())).thenReturn(true);
    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);

    // Act
    boolean actualDeleteByIdResult = (new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class)))
            .deleteById(1L, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(flowDiagramDao).deleteById(eq(1L), eq("janedoe"));
    assertTrue(actualDeleteByIdResult);
  }

  /**
   * Method under test: {@link FlowDiagramService#deleteById(long, String)}
   */
  @Test
  void testDeleteById2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.deleteById(anyLong(), Mockito.<String>any()))
        .thenThrow(new InvalidResultException("An error occurred"));
    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);

    // Act and Assert
    assertThrows(InvalidResultException.class,
        () -> (new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao, flowDiagramEntityDao,
            flowDiagramAnnotationDao, new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)),
            mock(ApplicationDao.class), mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(ActorDao.class), mock(EndUserAppDao.class),
            mock(MeasurableDao.class), mock(ChangeInitiativeDao.class))).deleteById(1L, "janedoe"));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(flowDiagramDao).deleteById(eq(1L), eq("janedoe"));
  }

  /**
   * Method under test: {@link FlowDiagramService#deleteById(long, String)}
   */
  @Test
  void testDeleteById3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.deleteById(anyLong(), Mockito.<String>any())).thenReturn(true);
    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);

    // Act
    boolean actualDeleteByIdResult = (new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class)))
            .deleteById(1L, "janedoe");

    // Assert
    verify(flowDiagramDao).deleteById(eq(1L), eq("janedoe"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualDeleteByIdResult);
  }

  /**
   * Method under test: {@link FlowDiagramService#deleteById(long, String)}
   */
  @Test
  void testDeleteById4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.deleteById(anyLong(), Mockito.<String>any())).thenReturn(false);
    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);

    // Act
    boolean actualDeleteByIdResult = (new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class)))
            .deleteById(1L, "janedoe");

    // Assert
    verify(flowDiagramDao).deleteById(eq(1L), eq("janedoe"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualDeleteByIdResult);
  }

  /**
   * Method under test: {@link FlowDiagramService#deleteById(long, String)}
   */
  @Test
  void testDeleteById5() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenThrow(new InvalidResultException("An error occurred"));
    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);

    // Act and Assert
    assertThrows(InvalidResultException.class,
        () -> (new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao, flowDiagramEntityDao,
            flowDiagramAnnotationDao, new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)),
            mock(ApplicationDao.class), mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(ActorDao.class), mock(EndUserAppDao.class),
            mock(MeasurableDao.class), mock(ChangeInitiativeDao.class))).deleteById(1L, "janedoe"));
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference, String, String)}
   */
  @Test
  void testMakeNewDiagramForEntity() {
    // Arrange
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> flowDiagramService.makeNewDiagramForEntity(ref, "42", "Dr"));
    verify(ref).kind();
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference, String, String)}
   */
  @Test
  void testMakeNewDiagramForEntity2() {
    // Arrange
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new InvalidResultException("An error occurred"));
    when(ref.kind()).thenReturn(EntityKind.ACTOR);

    // Act and Assert
    assertThrows(InvalidResultException.class, () -> flowDiagramService.makeNewDiagramForEntity(ref, "42", "Dr"));
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference, String, String)}
   */
  @Test
  void testMakeNewDiagramForEntity3() {
    // Arrange
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new InvalidResultException("An error occurred"));
    when(ref.kind()).thenReturn(EntityKind.APPLICATION);

    // Act and Assert
    assertThrows(InvalidResultException.class, () -> flowDiagramService.makeNewDiagramForEntity(ref, "42", "Dr"));
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference, String, String)}
   */
  @Test
  void testMakeNewDiagramForEntity4() {
    // Arrange
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new InvalidResultException("An error occurred"));
    when(ref.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);

    // Act and Assert
    assertThrows(InvalidResultException.class, () -> flowDiagramService.makeNewDiagramForEntity(ref, "42", "Dr"));
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference, String, String)}
   */
  @Test
  void testMakeNewDiagramForEntity5() {
    // Arrange
    Actor actor = mock(Actor.class);
    when(actor.name()).thenReturn("Name");
    when(actor.entityReference()).thenThrow(new InvalidResultException("An error occurred"));
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.getById(anyLong())).thenReturn(actor);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), actorDao,
        mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ACTOR);

    // Act and Assert
    assertThrows(InvalidResultException.class, () -> flowDiagramService.makeNewDiagramForEntity(ref, "42", ""));
    verify(actorDao).getById(eq(1L));
    verify(ref).id();
    verify(ref).kind();
    verify(actor).name();
    verify(actor).entityReference();
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference, String, String)}
   */
  @Test
  void testMakeNewDiagramForEntity6() {
    // Arrange
    Actor actor = mock(Actor.class);
    when(actor.name()).thenThrow(new InvalidResultException("An error occurred"));
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.getById(anyLong())).thenReturn(actor);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), actorDao,
        mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ACTOR);

    // Act and Assert
    assertThrows(InvalidResultException.class, () -> flowDiagramService.makeNewDiagramForEntity(ref, "42", ""));
    verify(actorDao).getById(eq(1L));
    verify(ref).id();
    verify(ref).kind();
    verify(actor).name();
  }

  /**
   * Method under test:
   * {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference, String, String)}
   */
  @Test
  void testMakeNewDiagramForEntity7() {
    // Arrange
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.getById(anyLong())).thenThrow(new InvalidResultException("An error occurred"));
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramService flowDiagramService = new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao,
        flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), applicationDao,
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.APPLICATION);

    // Act and Assert
    assertThrows(InvalidResultException.class, () -> flowDiagramService.makeNewDiagramForEntity(ref, "42", ""));
    verify(applicationDao).getById(eq(1L));
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Method under test: {@link FlowDiagramService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    ArrayList<FlowDiagram> flowDiagramList = new ArrayList<>();
    when(flowDiagramDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(flowDiagramList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);

    // Act
    Collection<FlowDiagram> actualSearchResult = (new FlowDiagramService(changeLogService, dataTypeService,
        flowDiagramDao, flowDiagramEntityDao, flowDiagramAnnotationDao,
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)), mock(ApplicationDao.class),
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(ActorDao.class), mock(EndUserAppDao.class), mock(MeasurableDao.class), mock(ChangeInitiativeDao.class)))
            .search(null);

    // Assert
    verify(flowDiagramDao).search(isNull());
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(flowDiagramList, actualSearchResult);
  }

  /**
   * Method under test: {@link FlowDiagramService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch2() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.search(Mockito.<EntitySearchOptions>any()))
        .thenThrow(new InvalidResultException("An error occurred"));
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);

    // Act and Assert
    assertThrows(InvalidResultException.class,
        () -> (new FlowDiagramService(changeLogService, dataTypeService, flowDiagramDao, flowDiagramEntityDao,
            flowDiagramAnnotationDao, new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class)),
            mock(ApplicationDao.class), mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(ActorDao.class), mock(EndUserAppDao.class),
            mock(MeasurableDao.class), mock(ChangeInitiativeDao.class))).search(null));
    verify(flowDiagramDao).search(isNull());
  }
}
