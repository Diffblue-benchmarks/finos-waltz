package org.finos.waltz.service.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ImmutableUpdateDescriptionCommand;
import org.finos.waltz.model.ImmutableUpdateNameCommand;
import org.finos.waltz.model.UpdateDescriptionCommand;
import org.finos.waltz.model.UpdateNameCommand;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.flow_diagram.FlowDiagram;
import org.finos.waltz.model.flow_diagram.FlowDiagramAnnotation;
import org.finos.waltz.model.flow_diagram.FlowDiagramEntity;
import org.finos.waltz.model.flow_diagram.FlowDiagramOverlayGroupEntry;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagram;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramAnnotation;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramEntity;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramEntity.Builder;
import org.finos.waltz.model.flow_diagram.ImmutableSaveDiagramCommand;
import org.finos.waltz.model.flow_diagram.SaveDiagramCommand;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.data_type.DataTypeService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.jooq.exception.InvalidResultException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FlowDiagramServiceDiffblueTest {
  @Mock private ActorDao actorDao;

  @Mock private ApplicationDao applicationDao;

  @Mock private ChangeInitiativeDao changeInitiativeDao;

  @Mock private ChangeLogService changeLogService;

  @Mock private DataTypeService dataTypeService;

  @Mock private EndUserAppDao endUserAppDao;

  @Mock private FlowDiagramAnnotationDao flowDiagramAnnotationDao;

  @Mock private FlowDiagramDao flowDiagramDao;

  @Mock private FlowDiagramEntityDao flowDiagramEntityDao;

  @Mock private FlowDiagramOverlayGroupService flowDiagramOverlayGroupService;

  @InjectMocks private FlowDiagramService flowDiagramService;

  @Mock private LogicalFlowDao logicalFlowDao;

  @Mock private MeasurableDao measurableDao;

  @Mock private PhysicalFlowDao physicalFlowDao;

  @Mock private PhysicalSpecificationDao physicalSpecificationDao;

  /**
   * Test {@link FlowDiagramService#getById(long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableFlowDiagram}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then return ImmutableFlowDiagram")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlowDiagram FlowDiagramService.getById(long)"})
  void testGetById_thenReturnImmutableFlowDiagram() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(flowDiagramDao.getById(anyLong()))
        .thenReturn(
            ImmutableFlowDiagram.builder()
                .description("The characteristics of someone or something")
                .editorRole("Editor Role")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .layoutData("Layout Data")
                .name("Name")
                .build());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act
    FlowDiagram actualById = flowDiagramService.getById(1L);

    // Assert
    verify(flowDiagramDao).getById(1L);
    assertTrue(actualById instanceof ImmutableFlowDiagram);
    LocalDateTime lastUpdatedAtResult = actualById.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Layout Data", actualById.layoutData());
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertFalse(actualById.isRemoved());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link FlowDiagramService#getById(long)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidResultException}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then throw InvalidResultException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlowDiagram FlowDiagramService.getById(long)"})
  void testGetById_thenThrowInvalidResultException() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.getById(anyLong()))
        .thenThrow(new InvalidResultException("An error occurred"));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(InvalidResultException.class, () -> flowDiagramService.getById(1L));
    verify(flowDiagramDao).getById(1L);
  }

  /**
   * Test {@link FlowDiagramService#cloneDiagram(long, String, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#cloneDiagram(long, String, String)}
   */
  @Test
  @DisplayName("Test cloneDiagram(long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FlowDiagramService.cloneDiagram(long, String, String)"})
  void testCloneDiagram() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.clone(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new InvalidResultException("An error occurred"));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        InvalidResultException.class, () -> flowDiagramService.cloneDiagram(1L, "New Name", "42"));
    verify(flowDiagramDao).clone(1L, "New Name", "42");
  }

  /**
   * Test {@link FlowDiagramService#cloneDiagram(long, String, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#cloneDiagram(long, String, String)}
   */
  @Test
  @DisplayName("Test cloneDiagram(long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FlowDiagramService.cloneDiagram(long, String, String)"})
  void testCloneDiagram2() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.clone(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    doThrow(new InvalidResultException("An error occurred"))
        .when(flowDiagramEntityDao)
        .clone(anyLong(), Mockito.<Long>any());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        InvalidResultException.class, () -> flowDiagramService.cloneDiagram(1L, "New Name", "42"));
    verify(flowDiagramDao).clone(1L, "New Name", "42");
    verify(flowDiagramEntityDao).clone(1L, 1L);
  }

  /**
   * Test {@link FlowDiagramService#cloneDiagram(long, String, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#cloneDiagram(long, String, String)}
   */
  @Test
  @DisplayName("Test cloneDiagram(long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FlowDiagramService.cloneDiagram(long, String, String)"})
  void testCloneDiagram3() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.clone(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    doNothing().when(flowDiagramEntityDao).clone(anyLong(), Mockito.<Long>any());

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    doThrow(new InvalidResultException("An error occurred"))
        .when(flowDiagramAnnotationDao)
        .clone(anyLong(), Mockito.<Long>any());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        InvalidResultException.class, () -> flowDiagramService.cloneDiagram(1L, "New Name", "42"));
    verify(flowDiagramAnnotationDao).clone(1L, 1L);
    verify(flowDiagramDao).clone(1L, "New Name", "42");
    verify(flowDiagramEntityDao).clone(1L, 1L);
  }

  /**
   * Test {@link FlowDiagramService#cloneDiagram(long, String, String)}.
   *
   * <ul>
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#cloneDiagram(long, String, String)}
   */
  @Test
  @DisplayName("Test cloneDiagram(long, String, String); then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long FlowDiagramService.cloneDiagram(long, String, String)"})
  void testCloneDiagram_thenReturnLongValueIsOne() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.clone(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    doNothing().when(flowDiagramEntityDao).clone(anyLong(), Mockito.<Long>any());

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    doNothing().when(flowDiagramAnnotationDao).clone(anyLong(), Mockito.<Long>any());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act
    Long actualCloneDiagramResult = flowDiagramService.cloneDiagram(1L, "New Name", "42");

    // Assert
    verify(flowDiagramAnnotationDao).clone(1L, 1L);
    verify(flowDiagramDao).clone(1L, "New Name", "42");
    verify(flowDiagramEntityDao).clone(1L, 1L);
    assertEquals(1L, actualCloneDiagramResult.longValue());
  }

  /**
   * Test {@link FlowDiagramService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowDiagramService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenReturnEmpty() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act
    List<FlowDiagram> actualFindByEntityReferenceResult =
        flowDiagramService.findByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(flowDiagramDao).findByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidResultException}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then throw InvalidResultException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowDiagramService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenThrowInvalidResultException() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new InvalidResultException("An error occurred"));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        InvalidResultException.class,
        () ->
            flowDiagramService.findByEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(flowDiagramDao).findByEntityReference(isA(EntityReference.class));
  }

  /**
   * Test {@link FlowDiagramService#findForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link FlowDiagramService#findForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowDiagramService.findForSelector(IdSelectionOptions)"})
  void testFindForSelector() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<FlowDiagram> actualFindForSelectorResult =
        flowDiagramService.findForSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(flowDiagramDao).findForSelector(isA(Select.class));
    assertTrue(actualFindForSelectorResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramService#findForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HierarchyQueryScope#EXACT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#findForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForSelector(IdSelectionOptions); given EXACT; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowDiagramService.findForSelector(IdSelectionOptions)"})
  void testFindForSelector_givenExact_thenReturnEmpty() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    List<FlowDiagram> actualFindForSelectorResult = flowDiagramService.findForSelector(options);

    // Assert
    verify(flowDiagramDao).findForSelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindForSelectorResult.isEmpty());
  }

  /**
   * Test {@link FlowDiagramService#findForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidResultException}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#findForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findForSelector(IdSelectionOptions); then throw InvalidResultException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowDiagramService.findForSelector(IdSelectionOptions)"})
  void testFindForSelector_thenThrowInvalidResultException() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.findForSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new InvalidResultException("An error occurred"));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(InvalidResultException.class, () -> flowDiagramService.findForSelector(options));
    verify(flowDiagramDao).findForSelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName("Test save(SaveDiagramCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any()))
        .thenThrow(new InvalidResultException("An error occurred"));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        InvalidResultException.class,
        () ->
            flowDiagramService.save(
                ImmutableSaveDiagramCommand.builder()
                    .description("The characteristics of someone or something")
                    .diagramId(1L)
                    .layoutData("Layout Data")
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName("Test save(SaveDiagramCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave2() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.findForDiagram(anyLong()))
        .thenThrow(new InvalidResultException("An error occurred"));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        InvalidResultException.class,
        () ->
            flowDiagramService.save(
                ImmutableSaveDiagramCommand.builder()
                    .description("The characteristics of someone or something")
                    .diagramId(1L)
                    .layoutData("Layout Data")
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).findForDiagram(1L);
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName("Test save(SaveDiagramCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave3() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(new ArrayList<>());

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong()))
        .thenThrow(new InvalidResultException("An error occurred"));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        InvalidResultException.class,
        () ->
            flowDiagramService.save(
                ImmutableSaveDiagramCommand.builder()
                    .description("The characteristics of someone or something")
                    .diagramId(1L)
                    .layoutData("Layout Data")
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(1L);
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).deleteForDiagram(1L);
    verify(flowDiagramEntityDao).findForDiagram(1L);
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName("Test save(SaveDiagramCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(new ArrayList<>());

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = mock(FlowDiagramOverlayGroupDao.class);
    when(flowDiagramOverlayGroupDao.createOverlays(
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any()))
        .thenReturn(1);
    when(flowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Mockito.<Long>any())).thenReturn(1);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(flowDiagramOverlayGroupDao);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act
    long actualSaveResult =
        flowDiagramService.save(
            ImmutableSaveDiagramCommand.builder()
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(1L);
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(1L);
    verify(flowDiagramEntityDao).findForDiagram(1L);
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).deleteOverlaysForDiagram(1L);
    verify(changeLogService).write(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualSaveResult);
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName("Test save(SaveDiagramCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave5() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new InvalidResultException("An error occurred"));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(new ArrayList<>());
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        InvalidResultException.class,
        () ->
            flowDiagramService.save(
                ImmutableSaveDiagramCommand.builder()
                    .description("The characteristics of someone or something")
                    .diagramId(1L)
                    .layoutData("Layout Data")
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).findForDiagram(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName("Test save(SaveDiagramCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave6() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(new ArrayList<>());

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        mock(FlowDiagramOverlayGroupService.class);
    when(flowDiagramOverlayGroupService.updateOverlaysForDiagram(
            Mockito.<Long>any(),
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any(),
            Mockito.<String>any()))
        .thenReturn(1);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    builderResult.addEntities(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    // Act
    long actualSaveResult =
        flowDiagramService.save(
            builderResult
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(1L);
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(1L);
    verify(flowDiagramEntityDao).findForDiagram(1L);
    verify(changeLogService).write(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(flowDiagramOverlayGroupService)
        .updateOverlaysForDiagram(eq(1L), isA(Set.class), eq("janedoe"));
    assertEquals(1L, actualSaveResult);
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName("Test save(SaveDiagramCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave7() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(new ArrayList<>());

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        mock(FlowDiagramOverlayGroupService.class);
    when(flowDiagramOverlayGroupService.updateOverlaysForDiagram(
            Mockito.<Long>any(),
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any(),
            Mockito.<String>any()))
        .thenReturn(1);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    ImmutableFlowDiagramAnnotation.Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    builderResult.addAnnotations(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build());

    // Act
    long actualSaveResult =
        flowDiagramService.save(
            builderResult
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(1L);
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(1L);
    verify(flowDiagramEntityDao).findForDiagram(1L);
    verify(changeLogService).write(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(flowDiagramOverlayGroupService)
        .updateOverlaysForDiagram(eq(1L), isA(Set.class), eq("janedoe"));
    assertEquals(1L, actualSaveResult);
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName("Test save(SaveDiagramCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave8() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(new ArrayList<>());

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        mock(FlowDiagramOverlayGroupService.class);
    when(flowDiagramOverlayGroupService.updateOverlaysForDiagram(
            Mockito.<Long>any(),
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any(),
            Mockito.<String>any()))
        .thenReturn(1);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    builderResult.addEntities(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    Builder diagramIdResult2 = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    builderResult.addEntities(
        diagramIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    // Act
    long actualSaveResult =
        flowDiagramService.save(
            builderResult
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(1L);
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(1L);
    verify(flowDiagramEntityDao).findForDiagram(1L);
    verify(changeLogService).write(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(flowDiagramOverlayGroupService)
        .updateOverlaysForDiagram(eq(1L), isA(Set.class), eq("janedoe"));
    assertEquals(1L, actualSaveResult);
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName("Test save(SaveDiagramCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave9() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    ArrayList<FlowDiagramEntity> flowDiagramEntityList = new ArrayList<>();

    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    flowDiagramEntityList.add(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(flowDiagramEntityList);

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        mock(FlowDiagramOverlayGroupService.class);
    when(flowDiagramOverlayGroupService.updateOverlaysForDiagram(
            Mockito.<Long>any(),
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any(),
            Mockito.<String>any()))
        .thenReturn(1);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    Builder diagramIdResult2 = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    builderResult.addEntities(
        diagramIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    // Act
    long actualSaveResult =
        flowDiagramService.save(
            builderResult
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(1L);
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(1L);
    verify(flowDiagramEntityDao).findForDiagram(1L);
    verify(changeLogService).write(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(flowDiagramOverlayGroupService)
        .updateOverlaysForDiagram(eq(1L), isA(Set.class), eq("janedoe"));
    assertEquals(1L, actualSaveResult);
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName("Test save(SaveDiagramCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave10() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    ArrayList<FlowDiagramEntity> flowDiagramEntityList = new ArrayList<>();

    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    flowDiagramEntityList.add(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    Builder diagramIdResult2 = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    flowDiagramEntityList.add(
        diagramIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(flowDiagramEntityList);

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        mock(FlowDiagramOverlayGroupService.class);
    when(flowDiagramOverlayGroupService.updateOverlaysForDiagram(
            Mockito.<Long>any(),
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any(),
            Mockito.<String>any()))
        .thenReturn(1);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    Builder diagramIdResult3 = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    builderResult.addEntities(
        diagramIdResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    // Act
    long actualSaveResult =
        flowDiagramService.save(
            builderResult
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(1L);
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(1L);
    verify(flowDiagramEntityDao).findForDiagram(1L);
    verify(changeLogService).write(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(flowDiagramOverlayGroupService)
        .updateOverlaysForDiagram(eq(1L), isA(Set.class), eq("janedoe"));
    assertEquals(1L, actualSaveResult);
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName("Test save(SaveDiagramCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave11() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(new ArrayList<>());

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        mock(FlowDiagramOverlayGroupService.class);
    when(flowDiagramOverlayGroupService.updateOverlaysForDiagram(
            Mockito.<Long>any(),
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any(),
            Mockito.<String>any()))
        .thenReturn(1);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    ImmutableFlowDiagramAnnotation.Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    builderResult.addAnnotations(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build());

    ImmutableFlowDiagramAnnotation.Builder diagramIdResult2 =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    builderResult.addAnnotations(
        diagramIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build());

    // Act
    long actualSaveResult =
        flowDiagramService.save(
            builderResult
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(1L);
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(1L);
    verify(flowDiagramEntityDao).findForDiagram(1L);
    verify(changeLogService).write(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(flowDiagramOverlayGroupService)
        .updateOverlaysForDiagram(eq(1L), isA(Set.class), eq("janedoe"));
    assertEquals(1L, actualSaveResult);
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName("Test save(SaveDiagramCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave12() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    ArrayList<FlowDiagramEntity> flowDiagramEntityList = new ArrayList<>();

    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    flowDiagramEntityList.add(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(flowDiagramEntityList);

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        mock(FlowDiagramOverlayGroupService.class);
    when(flowDiagramOverlayGroupService.updateOverlaysForDiagram(
            Mockito.<Long>any(),
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any(),
            Mockito.<String>any()))
        .thenReturn(1);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    Builder diagramIdResult2 = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    builderResult.addEntities(
        diagramIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(2L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    // Act
    long actualSaveResult =
        flowDiagramService.save(
            builderResult
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(1L);
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(1L);
    verify(flowDiagramEntityDao).findForDiagram(1L);
    verify(changeLogService).write(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(flowDiagramOverlayGroupService)
        .updateOverlaysForDiagram(eq(1L), isA(Set.class), eq("janedoe"));
    assertEquals(1L, actualSaveResult);
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName("Test save(SaveDiagramCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave13() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(new ArrayList<>());
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(flowDiagramOverlayGroupService.updateOverlaysForDiagram(
            Mockito.<Long>any(),
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any(),
            Mockito.<String>any()))
        .thenThrow(new InvalidResultException("An error occurred"));

    // Act and Assert
    assertThrows(
        InvalidResultException.class,
        () ->
            flowDiagramService.save(
                ImmutableSaveDiagramCommand.builder()
                    .description("The characteristics of someone or something")
                    .diagramId(1L)
                    .layoutData("Layout Data")
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(1L);
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(1L);
    verify(flowDiagramEntityDao).findForDiagram(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(flowDiagramOverlayGroupService)
        .updateOverlaysForDiagram(eq(1L), isA(Set.class), eq("janedoe"));
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Collection)} return array of {@code
   *       int} with {@code 19088743} and one.
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName(
      "Test save(SaveDiagramCommand, String); given ChangeLogDao write(Collection) return array of int with '19088743' and one; then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave_givenChangeLogDaoWriteReturnArrayOfIntWith19088743AndOne_thenCallsWrite() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(new ArrayList<>());

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = mock(FlowDiagramOverlayGroupDao.class);
    when(flowDiagramOverlayGroupDao.createOverlays(
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any()))
        .thenReturn(1);
    when(flowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Mockito.<Long>any())).thenReturn(1);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(flowDiagramOverlayGroupDao);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act
    long actualSaveResult =
        flowDiagramService.save(
            ImmutableSaveDiagramCommand.builder()
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(1L);
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(1L);
    verify(flowDiagramEntityDao).findForDiagram(1L);
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).deleteOverlaysForDiagram(1L);
    assertEquals(1L, actualSaveResult);
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Collection)} return array of {@code
   *       int} with {@code 19088743} and one.
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName(
      "Test save(SaveDiagramCommand, String); given ChangeLogDao write(Collection) return array of int with '19088743' and one; then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave_givenChangeLogDaoWriteReturnArrayOfIntWith19088743AndOne_thenCallsWrite2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    ArrayList<FlowDiagramEntity> flowDiagramEntityList = new ArrayList<>();

    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    flowDiagramEntityList.add(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(flowDiagramEntityList);

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = mock(FlowDiagramOverlayGroupDao.class);
    when(flowDiagramOverlayGroupDao.createOverlays(
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any()))
        .thenReturn(1);
    when(flowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Mockito.<Long>any())).thenReturn(1);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(flowDiagramOverlayGroupDao);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act
    long actualSaveResult =
        flowDiagramService.save(
            ImmutableSaveDiagramCommand.builder()
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(1L);
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(1L);
    verify(flowDiagramEntityDao).findForDiagram(1L);
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).deleteOverlaysForDiagram(1L);
    assertEquals(1L, actualSaveResult);
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Collection)} return array of {@code
   *       int} with {@code 19088743} and one.
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName(
      "Test save(SaveDiagramCommand, String); given ChangeLogDao write(Collection) return array of int with '19088743' and one; then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave_givenChangeLogDaoWriteReturnArrayOfIntWith19088743AndOne_thenCallsWrite3() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    ArrayList<FlowDiagramEntity> flowDiagramEntityList = new ArrayList<>();

    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    flowDiagramEntityList.add(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    Builder diagramIdResult2 = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    flowDiagramEntityList.add(
        diagramIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(flowDiagramEntityList);

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    FlowDiagramOverlayGroupDao flowDiagramOverlayGroupDao = mock(FlowDiagramOverlayGroupDao.class);
    when(flowDiagramOverlayGroupDao.createOverlays(
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any()))
        .thenReturn(1);
    when(flowDiagramOverlayGroupDao.deleteOverlaysForDiagram(Mockito.<Long>any())).thenReturn(1);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(flowDiagramOverlayGroupDao);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act
    long actualSaveResult =
        flowDiagramService.save(
            ImmutableSaveDiagramCommand.builder()
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(1L);
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(1L);
    verify(flowDiagramEntityDao).findForDiagram(1L);
    verify(flowDiagramOverlayGroupDao).createOverlays(isA(Set.class));
    verify(flowDiagramOverlayGroupDao).deleteOverlaysForDiagram(1L);
    assertEquals(1L, actualSaveResult);
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link FlowDiagramDao} {@link FlowDiagramDao#update(FlowDiagram)} return {@code
   *       false}.
   *   <li>Then throw {@link InvalidResultException}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName(
      "Test save(SaveDiagramCommand, String); given FlowDiagramDao update(FlowDiagram) return 'false'; then throw InvalidResultException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave_givenFlowDiagramDaoUpdateReturnFalse_thenThrowInvalidResultException() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(false);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            mock(FlowDiagramEntityDao.class),
            mock(FlowDiagramAnnotationDao.class),
            mock(FlowDiagramOverlayGroupService.class),
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        InvalidResultException.class,
        () ->
            flowDiagramService.save(
                ImmutableSaveDiagramCommand.builder()
                    .description("The characteristics of someone or something")
                    .diagramId(1L)
                    .layoutData("Layout Data")
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link FlowDiagramOverlayGroupService} {@link
   *       FlowDiagramOverlayGroupService#updateOverlaysForDiagram(Long, Set, String)} return one.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName(
      "Test save(SaveDiagramCommand, String); given FlowDiagramOverlayGroupService updateOverlaysForDiagram(Long, Set, String) return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave_givenFlowDiagramOverlayGroupServiceUpdateOverlaysForDiagramReturnOne() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(new ArrayList<>());

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        mock(FlowDiagramOverlayGroupService.class);
    when(flowDiagramOverlayGroupService.updateOverlaysForDiagram(
            Mockito.<Long>any(),
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any(),
            Mockito.<String>any()))
        .thenReturn(1);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act
    long actualSaveResult =
        flowDiagramService.save(
            ImmutableSaveDiagramCommand.builder()
                .description("The characteristics of someone or something")
                .diagramId(1L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(1L);
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(1L);
    verify(flowDiagramEntityDao).findForDiagram(1L);
    verify(changeLogService).write(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(flowDiagramOverlayGroupService)
        .updateOverlaysForDiagram(eq(1L), isA(Set.class), eq("janedoe"));
    assertEquals(1L, actualSaveResult);
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName("Test save(SaveDiagramCommand, String); then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave_thenReturnTwo() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(new ArrayList<>());

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        mock(FlowDiagramOverlayGroupService.class);
    when(flowDiagramOverlayGroupService.updateOverlaysForDiagram(
            Mockito.<Long>any(),
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any(),
            Mockito.<String>any()))
        .thenReturn(1);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    builderResult.addEntities(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    // Act
    long actualSaveResult =
        flowDiagramService.save(
            builderResult
                .description("The characteristics of someone or something")
                .diagramId(2L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(2L);
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(2L);
    verify(flowDiagramEntityDao).findForDiagram(2L);
    verify(changeLogService).write(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(flowDiagramOverlayGroupService)
        .updateOverlaysForDiagram(eq(2L), isA(Set.class), eq("janedoe"));
    assertEquals(2L, actualSaveResult);
  }

  /**
   * Test {@link FlowDiagramService#save(SaveDiagramCommand, String)}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#save(SaveDiagramCommand, String)}
   */
  @Test
  @DisplayName("Test save(SaveDiagramCommand, String); then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long FlowDiagramService.save(SaveDiagramCommand, String)"})
  void testSave_thenReturnTwo2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.update(Mockito.<FlowDiagram>any())).thenReturn(true);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(flowDiagramEntityDao.findForDiagram(anyLong())).thenReturn(new ArrayList<>());

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.deleteForDiagram(anyLong())).thenReturn(1);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        mock(FlowDiagramOverlayGroupService.class);
    when(flowDiagramOverlayGroupService.updateOverlaysForDiagram(
            Mockito.<Long>any(),
            Mockito.<Set<FlowDiagramOverlayGroupEntry>>any(),
            Mockito.<String>any()))
        .thenReturn(1);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    ImmutableSaveDiagramCommand.Builder builderResult = ImmutableSaveDiagramCommand.builder();

    ImmutableFlowDiagramAnnotation.Builder diagramIdResult =
        ImmutableFlowDiagramAnnotation.builder().annotationId("42").diagramId(1L);
    builderResult.addAnnotations(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .note("Note")
            .build());

    // Act
    long actualSaveResult =
        flowDiagramService.save(
            builderResult
                .description("The characteristics of someone or something")
                .diagramId(2L)
                .layoutData("Layout Data")
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramAnnotationDao).deleteForDiagram(2L);
    verify(flowDiagramDao).update(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    verify(flowDiagramEntityDao).deleteForDiagram(2L);
    verify(flowDiagramEntityDao).findForDiagram(2L);
    verify(changeLogService).write(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(flowDiagramOverlayGroupService)
        .updateOverlaysForDiagram(eq(2L), isA(Set.class), eq("janedoe"));
    assertEquals(2L, actualSaveResult);
  }

  /**
   * Test {@link FlowDiagramService#updateName(long, UpdateNameCommand, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#updateName(long, UpdateNameCommand, String)}
   */
  @Test
  @DisplayName("Test updateName(long, UpdateNameCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramService.updateName(long, UpdateNameCommand, String)"})
  void testUpdateName() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.updateName(anyLong(), Mockito.<String>any()))
        .thenThrow(new InvalidResultException("An error occurred"));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        InvalidResultException.class,
        () ->
            flowDiagramService.updateName(
                1L, ImmutableUpdateNameCommand.builder().newName("New Name").build(), "janedoe"));
    verify(flowDiagramDao).updateName(1L, "New Name");
  }

  /**
   * Test {@link FlowDiagramService#updateName(long, UpdateNameCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link FlowDiagramDao} {@link FlowDiagramDao#updateName(long, String)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#updateName(long, UpdateNameCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, UpdateNameCommand, String); given FlowDiagramDao updateName(long, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramService.updateName(long, UpdateNameCommand, String)"})
  void testUpdateName_givenFlowDiagramDaoUpdateNameReturnFalse_thenReturnFalse() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.updateName(anyLong(), Mockito.<String>any())).thenReturn(false);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act
    boolean actualUpdateNameResult =
        flowDiagramService.updateName(
            1L, ImmutableUpdateNameCommand.builder().newName("New Name").build(), "janedoe");

    // Assert
    verify(flowDiagramDao).updateName(1L, "New Name");
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Test {@link FlowDiagramService#updateName(long, UpdateNameCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link FlowDiagramDao} {@link FlowDiagramDao#updateName(long, String)} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#updateName(long, UpdateNameCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, UpdateNameCommand, String); given FlowDiagramDao updateName(long, String) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramService.updateName(long, UpdateNameCommand, String)"})
  void testUpdateName_givenFlowDiagramDaoUpdateNameReturnTrue_thenReturnTrue() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.updateName(anyLong(), Mockito.<String>any())).thenReturn(true);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act
    boolean actualUpdateNameResult =
        flowDiagramService.updateName(
            1L, ImmutableUpdateNameCommand.builder().newName("New Name").build(), "janedoe");

    // Assert
    verify(flowDiagramDao).updateName(1L, "New Name");
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Test {@link FlowDiagramService#updateName(long, UpdateNameCommand, String)}.
   *
   * <ul>
   *   <li>Then calls {@link UpdateNameCommand#newName()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#updateName(long, UpdateNameCommand, String)}
   */
  @Test
  @DisplayName("Test updateName(long, UpdateNameCommand, String); then calls newName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramService.updateName(long, UpdateNameCommand, String)"})
  void testUpdateName_thenCallsNewName() {
    // Arrange
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    UpdateNameCommand command = mock(UpdateNameCommand.class);
    when(command.newName()).thenThrow(new InvalidResultException("An error occurred"));

    // Act and Assert
    assertThrows(
        InvalidResultException.class, () -> flowDiagramService.updateName(1L, command, "janedoe"));
    verify(command).newName();
  }

  /**
   * Test {@link FlowDiagramService#updateDescription(long, UpdateDescriptionCommand, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#updateDescription(long,
   * UpdateDescriptionCommand, String)}
   */
  @Test
  @DisplayName("Test updateDescription(long, UpdateDescriptionCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FlowDiagramService.updateDescription(long, UpdateDescriptionCommand, String)"
  })
  void testUpdateDescription() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.updateDescription(anyLong(), Mockito.<String>any()))
        .thenThrow(new InvalidResultException("An error occurred"));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        InvalidResultException.class,
        () ->
            flowDiagramService.updateDescription(
                1L,
                ImmutableUpdateDescriptionCommand.builder()
                    .newDescription("New Description")
                    .build(),
                "janedoe"));
    verify(flowDiagramDao).updateDescription(1L, "New Description");
  }

  /**
   * Test {@link FlowDiagramService#updateDescription(long, UpdateDescriptionCommand, String)}.
   *
   * <ul>
   *   <li>Then calls {@link UpdateDescriptionCommand#newDescription()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#updateDescription(long,
   * UpdateDescriptionCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, UpdateDescriptionCommand, String); then calls newDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FlowDiagramService.updateDescription(long, UpdateDescriptionCommand, String)"
  })
  void testUpdateDescription_thenCallsNewDescription() {
    // Arrange
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    UpdateDescriptionCommand command = mock(UpdateDescriptionCommand.class);
    when(command.newDescription()).thenThrow(new InvalidResultException("An error occurred"));

    // Act and Assert
    assertThrows(
        InvalidResultException.class,
        () -> flowDiagramService.updateDescription(1L, command, "janedoe"));
    verify(command).newDescription();
  }

  /**
   * Test {@link FlowDiagramService#updateDescription(long, UpdateDescriptionCommand, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#updateDescription(long,
   * UpdateDescriptionCommand, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, UpdateDescriptionCommand, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FlowDiagramService.updateDescription(long, UpdateDescriptionCommand, String)"
  })
  void testUpdateDescription_thenReturnFalse() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.updateDescription(anyLong(), Mockito.<String>any())).thenReturn(false);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act
    boolean actualUpdateDescriptionResult =
        flowDiagramService.updateDescription(
            1L,
            ImmutableUpdateDescriptionCommand.builder().newDescription("New Description").build(),
            "janedoe");

    // Assert
    verify(flowDiagramDao).updateDescription(1L, "New Description");
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link FlowDiagramService#updateDescription(long, UpdateDescriptionCommand, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#updateDescription(long,
   * UpdateDescriptionCommand, String)}
   */
  @Test
  @DisplayName("Test updateDescription(long, UpdateDescriptionCommand, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FlowDiagramService.updateDescription(long, UpdateDescriptionCommand, String)"
  })
  void testUpdateDescription_thenReturnTrue() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.updateDescription(anyLong(), Mockito.<String>any())).thenReturn(true);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act
    boolean actualUpdateDescriptionResult =
        flowDiagramService.updateDescription(
            1L,
            ImmutableUpdateDescriptionCommand.builder().newDescription("New Description").build(),
            "janedoe");

    // Assert
    verify(flowDiagramDao).updateDescription(1L, "New Description");
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link FlowDiagramService#deleteById(long, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#deleteById(long, String)}
   */
  @Test
  @DisplayName("Test deleteById(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramService.deleteById(long, String)"})
  void testDeleteById() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.deleteById(anyLong(), Mockito.<String>any()))
        .thenThrow(new InvalidResultException("An error occurred"));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(InvalidResultException.class, () -> flowDiagramService.deleteById(1L, "janedoe"));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(flowDiagramDao).deleteById(1L, "janedoe");
  }

  /**
   * Test {@link FlowDiagramService#deleteById(long, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#deleteById(long, String)}
   */
  @Test
  @DisplayName("Test deleteById(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramService.deleteById(long, String)"})
  void testDeleteById2() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new InvalidResultException("An error occurred"));

    // Act and Assert
    assertThrows(InvalidResultException.class, () -> flowDiagramService.deleteById(1L, "janedoe"));
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link FlowDiagramService#deleteById(long, String)}.
   *
   * <ul>
   *   <li>Given {@link FlowDiagramDao} {@link FlowDiagramDao#deleteById(long, String)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#deleteById(long, String)}
   */
  @Test
  @DisplayName(
      "Test deleteById(long, String); given FlowDiagramDao deleteById(long, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramService.deleteById(long, String)"})
  void testDeleteById_givenFlowDiagramDaoDeleteByIdReturnFalse_thenReturnFalse() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(flowDiagramDao.deleteById(anyLong(), Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualDeleteByIdResult = flowDiagramService.deleteById(1L, "janedoe");

    // Assert
    verify(flowDiagramDao).deleteById(1L, "janedoe");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualDeleteByIdResult);
  }

  /**
   * Test {@link FlowDiagramService#deleteById(long, String)}.
   *
   * <ul>
   *   <li>Given {@link FlowDiagramDao} {@link FlowDiagramDao#deleteById(long, String)} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#deleteById(long, String)}
   */
  @Test
  @DisplayName(
      "Test deleteById(long, String); given FlowDiagramDao deleteById(long, String) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramService.deleteById(long, String)"})
  void testDeleteById_givenFlowDiagramDaoDeleteByIdReturnTrue_thenReturnTrue() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.deleteById(anyLong(), Mockito.<String>any())).thenReturn(true);
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act
    boolean actualDeleteByIdResult = flowDiagramService.deleteById(1L, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(flowDiagramDao).deleteById(1L, "janedoe");
    assertTrue(actualDeleteByIdResult);
  }

  /**
   * Test {@link FlowDiagramService#deleteById(long, String)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#deleteById(long, String)}
   */
  @Test
  @DisplayName("Test deleteById(long, String); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramService.deleteById(long, String)"})
  void testDeleteById_thenThrowUnsupportedOperationException() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.deleteById(anyLong(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> flowDiagramService.deleteById(1L, "janedoe"));
    verify(flowDiagramDao).deleteById(1L, "janedoe");
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference, String, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference,
   * String, String)}
   */
  @Test
  @DisplayName("Test makeNewDiagramForEntity(EntityReference, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long FlowDiagramService.makeNewDiagramForEntity(EntityReference, String, String)"
  })
  void testMakeNewDiagramForEntity() {
    // Arrange
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            flowDiagramService.makeNewDiagramForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "42",
                "Dr"));
  }

  /**
   * Test {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference, String, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference,
   * String, String)}
   */
  @Test
  @DisplayName("Test makeNewDiagramForEntity(EntityReference, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long FlowDiagramService.makeNewDiagramForEntity(EntityReference, String, String)"
  })
  void testMakeNewDiagramForEntity2() {
    // Arrange
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.getById(anyLong())).thenThrow(new InvalidResultException("An error occurred"));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            actorDao,
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        InvalidResultException.class,
        () ->
            flowDiagramService.makeNewDiagramForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build(),
                "42",
                "Dr"));
    verify(actorDao).getById(1L);
  }

  /**
   * Test {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference, String, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference,
   * String, String)}
   */
  @Test
  @DisplayName("Test makeNewDiagramForEntity(EntityReference, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long FlowDiagramService.makeNewDiagramForEntity(EntityReference, String, String)"
  })
  void testMakeNewDiagramForEntity3() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.create(Mockito.<FlowDiagram>any()))
        .thenThrow(new InvalidResultException("An error occurred"));

    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.getById(anyLong()))
        .thenReturn(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            actorDao,
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        InvalidResultException.class,
        () ->
            flowDiagramService.makeNewDiagramForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build(),
                "42",
                "Dr"));
    verify(actorDao).getById(1L);
    verify(flowDiagramDao).create(isA(FlowDiagram.class));
  }

  /**
   * Test {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference, String, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference,
   * String, String)}
   */
  @Test
  @DisplayName("Test makeNewDiagramForEntity(EntityReference, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long FlowDiagramService.makeNewDiagramForEntity(EntityReference, String, String)"
  })
  void testMakeNewDiagramForEntity4() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.create(Mockito.<FlowDiagram>any())).thenReturn(1L);

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenThrow(new InvalidResultException("An error occurred"));

    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.getById(anyLong()))
        .thenReturn(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            actorDao,
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        InvalidResultException.class,
        () ->
            flowDiagramService.makeNewDiagramForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build(),
                "42",
                "Dr"));
    verify(actorDao).getById(1L);
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramDao).create(isA(FlowDiagram.class));
  }

  /**
   * Test {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference, String, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference,
   * String, String)}
   */
  @Test
  @DisplayName("Test makeNewDiagramForEntity(EntityReference, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long FlowDiagramService.makeNewDiagramForEntity(EntityReference, String, String)"
  })
  void testMakeNewDiagramForEntity5() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.create(Mockito.<FlowDiagram>any())).thenReturn(1L);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenThrow(new InvalidResultException("An error occurred"));

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.getById(anyLong()))
        .thenReturn(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            actorDao,
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        InvalidResultException.class,
        () ->
            flowDiagramService.makeNewDiagramForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build(),
                "42",
                "Dr"));
    verify(actorDao).getById(1L);
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramDao).create(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
  }

  /**
   * Test {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference, String, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference,
   * String, String)}
   */
  @Test
  @DisplayName("Test makeNewDiagramForEntity(EntityReference, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long FlowDiagramService.makeNewDiagramForEntity(EntityReference, String, String)"
  })
  void testMakeNewDiagramForEntity6() {
    // Arrange
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            flowDiagramService.makeNewDiagramForEntity(
                ImmutableAppGroupEntry.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .build(),
                "42",
                "Dr"));
  }

  /**
   * Test {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference, String, String)}.
   *
   * <p>Method under test: {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference,
   * String, String)}
   */
  @Test
  @DisplayName("Test makeNewDiagramForEntity(EntityReference, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long FlowDiagramService.makeNewDiagramForEntity(EntityReference, String, String)"
  })
  void testMakeNewDiagramForEntity7() {
    // Arrange
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.getById(anyLong())).thenThrow(new InvalidResultException("An error occurred"));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            actorDao,
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(
        InvalidResultException.class,
        () ->
            flowDiagramService.makeNewDiagramForEntity(
                ImmutableAppGroupEntry.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .provenance("Provenance")
                    .build(),
                "42",
                "Dr"));
    verify(actorDao).getById(1L);
  }

  /**
   * Test {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference, String, String)}.
   *
   * <ul>
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#makeNewDiagramForEntity(EntityReference,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test makeNewDiagramForEntity(EntityReference, String, String); then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long FlowDiagramService.makeNewDiagramForEntity(EntityReference, String, String)"
  })
  void testMakeNewDiagramForEntity_thenReturnLongValueIsOne() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.create(Mockito.<FlowDiagram>any())).thenReturn(1L);

    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    when(flowDiagramEntityDao.createEntities(Mockito.<List<FlowDiagramEntity>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.createAnnotations(Mockito.<List<FlowDiagramAnnotation>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.getById(anyLong()))
        .thenReturn(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            actorDao,
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act
    Long actualMakeNewDiagramForEntityResult =
        flowDiagramService.makeNewDiagramForEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build(),
            "42",
            "Dr");

    // Assert
    verify(actorDao).getById(1L);
    verify(flowDiagramAnnotationDao).createAnnotations(isA(List.class));
    verify(flowDiagramDao).create(isA(FlowDiagram.class));
    verify(flowDiagramEntityDao).createEntities(isA(List.class));
    assertEquals(1L, actualMakeNewDiagramForEntityResult.longValue());
  }

  /**
   * Test {@link FlowDiagramService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@link FlowDiagramDao} {@link FlowDiagramDao#search(EntitySearchOptions)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given FlowDiagramDao search(EntitySearchOptions) return ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FlowDiagramService.search(EntitySearchOptions)"})
  void testSearch_givenFlowDiagramDaoSearchReturnArrayList_thenReturnList() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    ArrayList<FlowDiagram> flowDiagramList = new ArrayList<>();
    when(flowDiagramDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(flowDiagramList);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act
    Collection<FlowDiagram> actualSearchResult = flowDiagramService.search(null);

    // Assert
    verify(flowDiagramDao).search(isNull());
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(flowDiagramList, actualSearchResult);
  }

  /**
   * Test {@link FlowDiagramService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidResultException}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions); then throw InvalidResultException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FlowDiagramService.search(EntitySearchOptions)"})
  void testSearch_thenThrowInvalidResultException() {
    // Arrange
    FlowDiagramDao flowDiagramDao = mock(FlowDiagramDao.class);
    when(flowDiagramDao.search(Mockito.<EntitySearchOptions>any()))
        .thenThrow(new InvalidResultException("An error occurred"));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));
    FlowDiagramEntityDao flowDiagramEntityDao = mock(FlowDiagramEntityDao.class);
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    FlowDiagramOverlayGroupService flowDiagramOverlayGroupService =
        new FlowDiagramOverlayGroupService(mock(FlowDiagramOverlayGroupDao.class));

    FlowDiagramService flowDiagramService =
        new FlowDiagramService(
            changeLogService,
            dataTypeService,
            flowDiagramDao,
            flowDiagramEntityDao,
            flowDiagramAnnotationDao,
            flowDiagramOverlayGroupService,
            mock(ApplicationDao.class),
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(ActorDao.class),
            mock(EndUserAppDao.class),
            mock(MeasurableDao.class),
            mock(ChangeInitiativeDao.class));

    // Act and Assert
    assertThrows(InvalidResultException.class, () -> flowDiagramService.search(null));
    verify(flowDiagramDao).search(isNull());
  }
}
