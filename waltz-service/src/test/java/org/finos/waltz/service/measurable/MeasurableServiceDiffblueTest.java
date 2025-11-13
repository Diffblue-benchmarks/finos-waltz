package org.finos.waltz.service.measurable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.measurable.search.MeasurableSearchDao;
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
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable.MeasurableHierarchy;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MeasurableServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private EntityReferenceNameResolver entityReferenceNameResolver;

  @Mock private MeasurableDao measurableDao;

  @Mock private MeasurableSearchDao measurableSearchDao;

  @InjectMocks private MeasurableService measurableService;

  /**
   * Test {@link MeasurableService#findAll()}.
   *
   * <p>Method under test: {@link MeasurableService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableService.findAll()"})
  void testFindAll() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findAll()).thenReturn(new ArrayList<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    List<Measurable> actualFindAllResult = measurableService.findAll();

    // Assert
    verify(measurableDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByMeasurableIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableService.findByMeasurableIdSelector(IdSelectionOptions)"})
  void testFindByMeasurableIdSelector() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
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
    List<Measurable> actualFindByMeasurableIdSelectorResult =
        measurableService.findByMeasurableIdSelector(options);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByMeasurableIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableService.findByMeasurableIdSelector(IdSelectionOptions)"})
  void testFindByMeasurableIdSelector2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.AGGREGATE_OVERLAY_DIAGRAM)
                .name("Name")
                .build());

    // Act
    List<Measurable> actualFindByMeasurableIdSelectorResult =
        measurableService.findByMeasurableIdSelector(options);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isNull());
    verify(options).entityReference();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByMeasurableIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableService.findByMeasurableIdSelector(IdSelectionOptions)"})
  void testFindByMeasurableIdSelector3() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.INTERNALLY_HOSTED);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(options.joiningEntityKind()).thenReturn(emptyResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(immutableSelectionFilters);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    List<Measurable> actualFindByMeasurableIdSelectorResult =
        measurableService.findByMeasurableIdSelector(options);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options, atLeast(1)).scope();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByMeasurableIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableService.findByMeasurableIdSelector(IdSelectionOptions)"})
  void testFindByMeasurableIdSelector4() {
    // Arrange
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.CHANGE_INITIATIVE)
                .name("Name")
                .build());
    Optional.empty();

    // Act
    List<Measurable> actualFindByMeasurableIdSelectorResult =
        measurableService.findByMeasurableIdSelector(options);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByMeasurableIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableService.findByMeasurableIdSelector(IdSelectionOptions)"})
  void testFindByMeasurableIdSelector5() {
    // Arrange
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.CHANGE_INITIATIVE)
                .name("Name")
                .build());
    Optional.empty();

    // Act
    List<Measurable> actualFindByMeasurableIdSelectorResult =
        measurableService.findByMeasurableIdSelector(options);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByMeasurableIdSelector(IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableService.findByMeasurableIdSelector(IdSelectionOptions)"})
  void testFindByMeasurableIdSelector_givenHashSetAddPending() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
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
    List<Measurable> actualFindByMeasurableIdSelectorResult =
        measurableService.findByMeasurableIdSelector(options);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByMeasurableIdSelector(IdSelectionOptions); given HashSet() add 'REMOVED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableService.findByMeasurableIdSelector(IdSelectionOptions)"})
  void testFindByMeasurableIdSelector_givenHashSetAddRemoved() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
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
    List<Measurable> actualFindByMeasurableIdSelectorResult =
        measurableService.findByMeasurableIdSelector(options);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code REMOVED}.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByMeasurableIdSelector(IdSelectionOptions); given HashSet() add 'REMOVED'; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableService.findByMeasurableIdSelector(IdSelectionOptions)"})
  void testFindByMeasurableIdSelector_givenHashSetAddRemoved_thenCallsFilters() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(options.joiningEntityKind()).thenReturn(emptyResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    List<Measurable> actualFindByMeasurableIdSelectorResult =
        measurableService.findByMeasurableIdSelector(options);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options, atLeast(1)).scope();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByMeasurableIdSelector(IdSelectionOptions); then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableService.findByMeasurableIdSelector(IdSelectionOptions)"})
  void testFindByMeasurableIdSelector_thenCallsFilters() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> emptyResult = Optional.empty();
    when(options.joiningEntityKind()).thenReturn(emptyResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    List<Measurable> actualFindByMeasurableIdSelectorResult =
        measurableService.findByMeasurableIdSelector(options);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options, atLeast(1)).scope();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByRatingIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link MeasurableService#findByRatingIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByRatingIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableService.findByRatingIdSelector(IdSelectionOptions)"})
  void testFindByRatingIdSelector() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByRatingIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

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
    Set<Measurable> actualFindByRatingIdSelectorResult =
        measurableService.findByRatingIdSelector(options);

    // Assert
    verify(measurableDao).findByRatingIdSelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByRatingIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByRatingIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link MeasurableService#findByRatingIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByRatingIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableService.findByRatingIdSelector(IdSelectionOptions)"})
  void testFindByRatingIdSelector2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByRatingIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Set<Measurable> actualFindByRatingIdSelectorResult =
        measurableService.findByRatingIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableDao).findByRatingIdSelector(isA(Select.class));
    assertTrue(actualFindByRatingIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByRatingIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code INTERNALLY_HOSTED}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#findByRatingIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByRatingIdSelector(IdSelectionOptions); given builder addOmitApplicationKinds 'INTERNALLY_HOSTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableService.findByRatingIdSelector(IdSelectionOptions)"})
  void testFindByRatingIdSelector_givenBuilderAddOmitApplicationKindsInternallyHosted() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByRatingIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.INTERNALLY_HOSTED);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(immutableSelectionFilters);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    Set<Measurable> actualFindByRatingIdSelectorResult =
        measurableService.findByRatingIdSelector(options);

    // Assert
    verify(measurableDao).findByRatingIdSelector(isA(Select.class));
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options, atLeast(1)).scope();
    assertTrue(actualFindByRatingIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByRatingIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#findByRatingIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByRatingIdSelector(IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableService.findByRatingIdSelector(IdSelectionOptions)"})
  void testFindByRatingIdSelector_givenHashSetAddPending() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByRatingIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    Set<Measurable> actualFindByRatingIdSelectorResult =
        measurableService.findByRatingIdSelector(options);

    // Assert
    verify(measurableDao).findByRatingIdSelector(isA(Select.class));
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options, atLeast(1)).scope();
    assertTrue(actualFindByRatingIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByRatingIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given of {@code ALL}.
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#findByRatingIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByRatingIdSelector(IdSelectionOptions); given of 'ALL'; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableService.findByRatingIdSelector(IdSelectionOptions)"})
  void testFindByRatingIdSelector_givenOfAll_thenCallsEntityLifecycleStatuses() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByRatingIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    Set<Measurable> actualFindByRatingIdSelectorResult =
        measurableService.findByRatingIdSelector(options);

    // Assert
    verify(measurableDao).findByRatingIdSelector(isA(Select.class));
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options, atLeast(1)).scope();
    assertTrue(actualFindByRatingIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByCategoryId(Long)} with {@code categoryId}.
   *
   * <p>Method under test: {@link MeasurableService#findByCategoryId(Long)}
   */
  @Test
  @DisplayName("Test findByCategoryId(Long) with 'categoryId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableService.findByCategoryId(Long)"})
  void testFindByCategoryIdWithCategoryId() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    List<Measurable> actualFindByCategoryIdResult = measurableService.findByCategoryId(1L);

    // Assert
    verify(measurableDao).findByCategoryId(1L);
    assertTrue(actualFindByCategoryIdResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByCategoryId(Long, Set)} with {@code categoryId}, {@code
   * statuses}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#findByCategoryId(Long, Set)}
   */
  @Test
  @DisplayName(
      "Test findByCategoryId(Long, Set) with 'categoryId', 'statuses'; given 'ACTIVE'; when HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableService.findByCategoryId(Long, Set)"})
  void testFindByCategoryIdWithCategoryIdStatuses_givenActive_whenHashSetAddActive() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByCategoryId(
            Mockito.<Long>any(), Mockito.<Set<EntityLifecycleStatus>>any()))
        .thenReturn(new ArrayList<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    HashSet<EntityLifecycleStatus> statuses = new HashSet<>();
    statuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    List<Measurable> actualFindByCategoryIdResult =
        measurableService.findByCategoryId(1L, statuses);

    // Assert
    verify(measurableDao).findByCategoryId(eq(1L), isA(Set.class));
    assertTrue(actualFindByCategoryIdResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByCategoryId(Long, Set)} with {@code categoryId}, {@code
   * statuses}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   *   <li>When {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#findByCategoryId(Long, Set)}
   */
  @Test
  @DisplayName(
      "Test findByCategoryId(Long, Set) with 'categoryId', 'statuses'; given 'PENDING'; when HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableService.findByCategoryId(Long, Set)"})
  void testFindByCategoryIdWithCategoryIdStatuses_givenPending_whenHashSetAddPending() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByCategoryId(
            Mockito.<Long>any(), Mockito.<Set<EntityLifecycleStatus>>any()))
        .thenReturn(new ArrayList<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    HashSet<EntityLifecycleStatus> statuses = new HashSet<>();
    statuses.add(EntityLifecycleStatus.PENDING);
    statuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    List<Measurable> actualFindByCategoryIdResult =
        measurableService.findByCategoryId(1L, statuses);

    // Assert
    verify(measurableDao).findByCategoryId(eq(1L), isA(Set.class));
    assertTrue(actualFindByCategoryIdResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByCategoryId(Long, Set)} with {@code categoryId}, {@code
   * statuses}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#findByCategoryId(Long, Set)}
   */
  @Test
  @DisplayName("Test findByCategoryId(Long, Set) with 'categoryId', 'statuses'; when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableService.findByCategoryId(Long, Set)"})
  void testFindByCategoryIdWithCategoryIdStatuses_whenHashSet() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByCategoryId(
            Mockito.<Long>any(), Mockito.<Set<EntityLifecycleStatus>>any()))
        .thenReturn(new ArrayList<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    List<Measurable> actualFindByCategoryIdResult =
        measurableService.findByCategoryId(1L, new HashSet<>());

    // Assert
    verify(measurableDao).findByCategoryId(eq(1L), isA(Set.class));
    assertTrue(actualFindByCategoryIdResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByParentId(Long)}.
   *
   * <p>Method under test: {@link MeasurableService#findByParentId(Long)}
   */
  @Test
  @DisplayName("Test findByParentId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MeasurableService.findByParentId(Long)"})
  void testFindByParentId() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByParentId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    List<Measurable> actualFindByParentIdResult = measurableService.findByParentId(1L);

    // Assert
    verify(measurableDao).findByParentId(1L);
    assertTrue(actualFindByParentIdResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findExternalIdToIdMapByCategoryId(Long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#findExternalIdToIdMapByCategoryId(Long)}
   */
  @Test
  @DisplayName("Test findExternalIdToIdMapByCategoryId(Long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MeasurableService.findExternalIdToIdMapByCategoryId(Long)"})
  void testFindExternalIdToIdMapByCategoryId_thenReturnEmpty() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findExternalIdToIdMapByCategoryId(Mockito.<Long>any()))
        .thenReturn(new HashMap<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    Map<String, Long> actualFindExternalIdToIdMapByCategoryIdResult =
        measurableService.findExternalIdToIdMapByCategoryId(1L);

    // Assert
    verify(measurableDao).findExternalIdToIdMapByCategoryId(1L);
    assertTrue(actualFindExternalIdToIdMapByCategoryIdResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#search(EntitySearchOptions)} with {@code options}.
   *
   * <p>Method under test: {@link MeasurableService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions) with 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableService.search(EntitySearchOptions)"})
  void testSearchWithOptions() {
    // Arrange
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(measurableList);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    Collection<Measurable> actualSearchResult =
        measurableService.search((EntitySearchOptions) null);

    // Assert
    verify(measurableSearchDao).search(isNull());
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(measurableList, actualSearchResult);
  }

  /**
   * Test {@link MeasurableService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#search(String)}
   */
  @Test
  @DisplayName("Test search(String) with 'query'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableService.search(String)"})
  void testSearchWithQuery_thenReturnArrayList() {
    // Arrange
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(measurableList);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    Collection<Measurable> actualSearchResult = measurableService.search("Query");

    // Assert
    verify(measurableSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(measurableList, actualSearchResult);
  }

  /**
   * Test {@link MeasurableService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#search(String)}
   */
  @Test
  @DisplayName("Test search(String) with 'query'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableService.search(String)"})
  void testSearchWithQuery_whenEmptyString() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    Collection<Measurable> actualSearchResult = measurableService.search("");

    // Assert
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link MeasurableService#findByExternalId(String)}.
   *
   * <p>Method under test: {@link MeasurableService#findByExternalId(String)}
   */
  @Test
  @DisplayName("Test findByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableService.findByExternalId(String)"})
  void testFindByExternalId() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableDao.findByExternalId(Mockito.<String>any())).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    Collection<Measurable> actualFindByExternalIdResult = measurableService.findByExternalId("42");

    // Assert
    verify(measurableDao).findByExternalId("42");
    assertTrue(actualFindByExternalIdResult instanceof List);
    assertTrue(actualFindByExternalIdResult.isEmpty());
    assertSame(measurableList, actualFindByExternalIdResult);
  }

  /**
   * Test {@link MeasurableService#getById(long)}.
   *
   * <p>Method under test: {@link MeasurableService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Measurable MeasurableService.getById(long)"})
  void testGetById() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    Measurable actualById = measurableService.getById(1L);

    // Assert
    verify(measurableDao).getById(1L);
    assertTrue(actualById instanceof ImmutableMeasurable);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(0, actualById.position());
    assertEquals(1L, actualById.organisationalUnitId().longValue());
    assertEquals(1L, actualById.categoryId());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualById.entityLifecycleStatus());
    assertTrue(actualById.concrete());
    assertSame(ofResult, actualById.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link MeasurableService#findByOrgUnitId(Long)}.
   *
   * <p>Method under test: {@link MeasurableService#findByOrgUnitId(Long)}
   */
  @Test
  @DisplayName("Test findByOrgUnitId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableService.findByOrgUnitId(Long)"})
  void testFindByOrgUnitId() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    ArrayList<Measurable> measurableList = new ArrayList<>();
    when(measurableDao.findByOrgUnitId(Mockito.<Long>any())).thenReturn(measurableList);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    Collection<Measurable> actualFindByOrgUnitIdResult = measurableService.findByOrgUnitId(1L);

    // Assert
    verify(measurableDao).findByOrgUnitId(1L);
    assertTrue(actualFindByOrgUnitIdResult instanceof List);
    assertTrue(actualFindByOrgUnitIdResult.isEmpty());
    assertSame(measurableList, actualFindByOrgUnitIdResult);
  }

  /**
   * Test {@link MeasurableService#updateConcreteFlag(Long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateConcreteFlag(Long, boolean, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateConcreteFlag(Long, boolean, String)"})
  void testUpdateConcreteFlag_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateConcreteFlag(Mockito.<Long>any(), anyBoolean(), Mockito.<String>any()))
        .thenReturn(true);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

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

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateConcreteFlagResult = measurableService.updateConcreteFlag(1L, true, "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).getById(1L);
    verify(measurableDao).updateConcreteFlag(1L, true, "42");
    assertTrue(actualUpdateConcreteFlagResult);
  }

  /**
   * Test {@link MeasurableService#updateConcreteFlag(Long, boolean, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityReferenceNameResolver} {@link
   *       EntityReferenceNameResolver#resolve(EntityReference)} return empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test updateConcreteFlag(Long, boolean, String); given EntityReferenceNameResolver resolve(EntityReference) return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateConcreteFlag(Long, boolean, String)"})
  void testUpdateConcreteFlag_givenEntityReferenceNameResolverResolveReturnEmpty() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateConcreteFlag(Mockito.<Long>any(), anyBoolean(), Mockito.<String>any()))
        .thenReturn(true);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(emptyResult);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateConcreteFlagResult = measurableService.updateConcreteFlag(1L, true, "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).getById(1L);
    verify(measurableDao).updateConcreteFlag(1L, true, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateConcreteFlagResult);
  }

  /**
   * Test {@link MeasurableService#updateConcreteFlag(Long, boolean, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  @DisplayName("Test updateConcreteFlag(Long, boolean, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateConcreteFlag(Long, boolean, String)"})
  void testUpdateConcreteFlag_thenReturnFalse() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateConcreteFlag(Mockito.<Long>any(), anyBoolean(), Mockito.<String>any()))
        .thenReturn(false);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateConcreteFlagResult = measurableService.updateConcreteFlag(1L, true, "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).getById(1L);
    verify(measurableDao).updateConcreteFlag(1L, true, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualUpdateConcreteFlagResult);
  }

  /**
   * Test {@link MeasurableService#updateConcreteFlag(Long, boolean, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateConcreteFlag(Long, boolean, String)}
   */
  @Test
  @DisplayName("Test updateConcreteFlag(Long, boolean, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateConcreteFlag(Long, boolean, String)"})
  void testUpdateConcreteFlag_thenReturnTrue() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateConcreteFlag(Mockito.<Long>any(), anyBoolean(), Mockito.<String>any()))
        .thenReturn(true);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateConcreteFlagResult = measurableService.updateConcreteFlag(1L, true, "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).getById(1L);
    verify(measurableDao).updateConcreteFlag(1L, true, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateConcreteFlagResult);
  }

  /**
   * Test {@link MeasurableService#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateName(long, String, String)"})
  void testUpdateName_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

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

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateNameResult = measurableService.updateName(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).getById(1L);
    verify(measurableDao).updateName(1L, "42", "42");
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Test {@link MeasurableService#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityReferenceNameResolver} {@link
   *       EntityReferenceNameResolver#resolve(EntityReference)} return empty.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given EntityReferenceNameResolver resolve(EntityReference) return empty; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateName(long, String, String)"})
  void testUpdateName_givenEntityReferenceNameResolverResolveReturnEmpty_thenReturnTrue() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(emptyResult);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateNameResult = measurableService.updateName(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).getById(1L);
    verify(measurableDao).updateName(1L, "42", "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Test {@link MeasurableService#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link MeasurableDao} {@link MeasurableDao#updateName(long, String, String)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given MeasurableDao updateName(long, String, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateName(long, String, String)"})
  void testUpdateName_givenMeasurableDaoUpdateNameReturnFalse_thenReturnFalse() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(false);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateNameResult = measurableService.updateName(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).getById(1L);
    verify(measurableDao).updateName(1L, "42", "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Test {@link MeasurableService#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link MeasurableDao} {@link MeasurableDao#updateName(long, String, String)} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given MeasurableDao updateName(long, String, String) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateName(long, String, String)"})
  void testUpdateName_givenMeasurableDaoUpdateNameReturnTrue_thenReturnTrue() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateNameResult = measurableService.updateName(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).getById(1L);
    verify(measurableDao).updateName(1L, "42", "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Test {@link MeasurableService#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateDescription(long, String, String)"})
  void testUpdateDescription_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

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

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateDescriptionResult = measurableService.updateDescription(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).getById(1L);
    verify(measurableDao).updateDescription(1L, "42", "42");
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link MeasurableService#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityReferenceNameResolver} {@link
   *       EntityReferenceNameResolver#resolve(EntityReference)} return empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given EntityReferenceNameResolver resolve(EntityReference) return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateDescription(long, String, String)"})
  void testUpdateDescription_givenEntityReferenceNameResolverResolveReturnEmpty() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(emptyResult);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateDescriptionResult = measurableService.updateDescription(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).getById(1L);
    verify(measurableDao).updateDescription(1L, "42", "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link MeasurableService#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName("Test updateDescription(long, String, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateDescription(long, String, String)"})
  void testUpdateDescription_thenReturnFalse() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(false);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateDescriptionResult = measurableService.updateDescription(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).getById(1L);
    verify(measurableDao).updateDescription(1L, "42", "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link MeasurableService#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName("Test updateDescription(long, String, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateDescription(long, String, String)"})
  void testUpdateDescription_thenReturnTrue() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateDescriptionResult = measurableService.updateDescription(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).getById(1L);
    verify(measurableDao).updateDescription(1L, "42", "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link MeasurableService#updateExternalId(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateExternalId(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateExternalId(long, String, String)"})
  void testUpdateExternalId_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateExternalId(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

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

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateExternalIdResult = measurableService.updateExternalId(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).getById(1L);
    verify(measurableDao).updateExternalId(1L, "42", "42");
    assertTrue(actualUpdateExternalIdResult);
  }

  /**
   * Test {@link MeasurableService#updateExternalId(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityReferenceNameResolver} {@link
   *       EntityReferenceNameResolver#resolve(EntityReference)} return empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateExternalId(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String, String); given EntityReferenceNameResolver resolve(EntityReference) return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateExternalId(long, String, String)"})
  void testUpdateExternalId_givenEntityReferenceNameResolverResolveReturnEmpty() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateExternalId(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(emptyResult);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateExternalIdResult = measurableService.updateExternalId(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).getById(1L);
    verify(measurableDao).updateExternalId(1L, "42", "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateExternalIdResult);
  }

  /**
   * Test {@link MeasurableService#updateExternalId(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link MeasurableDao} {@link MeasurableDao#updateExternalId(long, String, String)}
   *       return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateExternalId(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String, String); given MeasurableDao updateExternalId(long, String, String) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateExternalId(long, String, String)"})
  void testUpdateExternalId_givenMeasurableDaoUpdateExternalIdReturnTrue_thenReturnTrue() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateExternalId(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateExternalIdResult = measurableService.updateExternalId(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).getById(1L);
    verify(measurableDao).updateExternalId(1L, "42", "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateExternalIdResult);
  }

  /**
   * Test {@link MeasurableService#updateExternalId(long, String, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateExternalId(long, String, String)}
   */
  @Test
  @DisplayName("Test updateExternalId(long, String, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateExternalId(long, String, String)"})
  void testUpdateExternalId_thenReturnFalse() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateExternalId(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(false);
    when(measurableDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateExternalIdResult = measurableService.updateExternalId(1L, "42", "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).getById(1L);
    verify(measurableDao).updateExternalId(1L, "42", "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualUpdateExternalIdResult);
  }

  /**
   * Test {@link MeasurableService#create(Measurable, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#create(Measurable, String)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.create(Measurable, String)"})
  void testCreate_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.create(Mockito.<Measurable>any())).thenReturn(1L);

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

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao,
            mock(MeasurableSearchDao.class),
            mock(EntityReferenceNameResolver.class),
            changeLogService);

    // Act
    boolean actualCreateResult =
        measurableService.create(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build(),
            "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).create(isA(Measurable.class));
    assertFalse(actualCreateResult);
  }

  /**
   * Test {@link MeasurableService#create(Measurable, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#create(Measurable, String)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable, String); given ChangeLogService write(ChangeLog) return '19088743'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.create(Measurable, String)"})
  void testCreate_givenChangeLogServiceWriteReturn19088743_thenReturnFalse() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.create(Mockito.<Measurable>any())).thenReturn(1L);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao,
            mock(MeasurableSearchDao.class),
            mock(EntityReferenceNameResolver.class),
            changeLogService);

    // Act
    boolean actualCreateResult =
        measurableService.create(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build(),
            "42");

    // Assert
    verify(measurableDao).create(isA(Measurable.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualCreateResult);
  }

  /**
   * Test {@link MeasurableService#create(Measurable, String)}.
   *
   * <ul>
   *   <li>Given {@link MeasurableDao} {@link MeasurableDao#create(Measurable)} return fifteen.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#create(Measurable, String)}
   */
  @Test
  @DisplayName(
      "Test create(Measurable, String); given MeasurableDao create(Measurable) return fifteen; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.create(Measurable, String)"})
  void testCreate_givenMeasurableDaoCreateReturnFifteen_thenReturnTrue() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.create(Mockito.<Measurable>any())).thenReturn(15L);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao,
            mock(MeasurableSearchDao.class),
            mock(EntityReferenceNameResolver.class),
            changeLogService);

    // Act
    boolean actualCreateResult =
        measurableService.create(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build(),
            "42");

    // Assert
    verify(measurableDao).create(isA(Measurable.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualCreateResult);
  }

  /**
   * Test {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test deleteByIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableService.deleteByIdSelector(IdSelectionOptions)"})
  void testDeleteByIdSelector() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.deleteByIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    int actualDeleteByIdSelectorResult =
        measurableService.deleteByIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableDao).deleteByIdSelector(isA(Select.class));
    assertEquals(1, actualDeleteByIdSelectorResult);
  }

  /**
   * Test {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test deleteByIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableService.deleteByIdSelector(IdSelectionOptions)"})
  void testDeleteByIdSelector2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.deleteByIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.AGGREGATE_OVERLAY_DIAGRAM)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    int actualDeleteByIdSelectorResult =
        measurableService.deleteByIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableDao).deleteByIdSelector(isNull());
    assertEquals(1, actualDeleteByIdSelectorResult);
  }

  /**
   * Test {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test deleteByIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableService.deleteByIdSelector(IdSelectionOptions)"})
  void testDeleteByIdSelector3() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.deleteByIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    int actualDeleteByIdSelectorResult =
        measurableService.deleteByIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableDao).deleteByIdSelector(isA(Select.class));
    assertEquals(1, actualDeleteByIdSelectorResult);
  }

  /**
   * Test {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When builder addEntityLifecycleStatuses {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test deleteByIdSelector(IdSelectionOptions); given 'ACTIVE'; when builder addEntityLifecycleStatuses 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableService.deleteByIdSelector(IdSelectionOptions)"})
  void testDeleteByIdSelector_givenActive_whenBuilderAddEntityLifecycleStatusesActive() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.deleteByIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    int actualDeleteByIdSelectorResult =
        measurableService.deleteByIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableDao).deleteByIdSelector(isA(Select.class));
    assertEquals(1, actualDeleteByIdSelectorResult);
  }

  /**
   * Test {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code EXTERNALLY_HOSTED}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test deleteByIdSelector(IdSelectionOptions); given 'EXTERNALLY_HOSTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableService.deleteByIdSelector(IdSelectionOptions)"})
  void testDeleteByIdSelector_givenExternallyHosted() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.deleteByIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.EXTERNALLY_HOSTED);
    ImmutableSelectionFilters filters = builderResult.build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    int actualDeleteByIdSelectorResult =
        measurableService.deleteByIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableDao).deleteByIdSelector(isA(Select.class));
    assertEquals(1, actualDeleteByIdSelectorResult);
  }

  /**
   * Test {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code REMOVED}.
   *   <li>When builder addEntityLifecycleStatuses {@code REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#deleteByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test deleteByIdSelector(IdSelectionOptions); given 'REMOVED'; when builder addEntityLifecycleStatuses 'REMOVED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MeasurableService.deleteByIdSelector(IdSelectionOptions)"})
  void testDeleteByIdSelector_givenRemoved_whenBuilderAddEntityLifecycleStatusesRemoved() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.deleteByIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.REMOVED);

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    int actualDeleteByIdSelectorResult =
        measurableService.deleteByIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableDao).deleteByIdSelector(isA(Select.class));
    assertEquals(1, actualDeleteByIdSelectorResult);
  }

  /**
   * Test {@link MeasurableService#updateParentId(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>When {@code 42}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateParentId(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test updateParentId(Long, Long, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; when '42'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateParentId(Long, Long, String)"})
  void testUpdateParentId_givenChangeLogDaoWriteReturn19088743_when42_thenCallsWrite() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateParentId(
            Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(true);

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

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

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateParentIdResult = measurableService.updateParentId(1L, 1L, "42");

    // Assert
    verify(nameResolver, atLeast(1)).resolve(isA(EntityReference.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).updateParentId(1L, 1L, "42");
    assertTrue(actualUpdateParentIdResult);
  }

  /**
   * Test {@link MeasurableService#updateParentId(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityReferenceNameResolver} {@link
   *       EntityReferenceNameResolver#resolve(EntityReference)} return empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateParentId(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test updateParentId(Long, Long, String); given EntityReferenceNameResolver resolve(EntityReference) return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateParentId(Long, Long, String)"})
  void testUpdateParentId_givenEntityReferenceNameResolverResolveReturnEmpty() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateParentId(
            Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(true);

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(emptyResult);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateParentIdResult = measurableService.updateParentId(1L, 1L, "42");

    // Assert
    verify(nameResolver, atLeast(1)).resolve(isA(EntityReference.class));
    verify(measurableDao).updateParentId(1L, 1L, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateParentIdResult);
  }

  /**
   * Test {@link MeasurableService#updateParentId(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link MeasurableDao} {@link MeasurableDao#updateParentId(Long, Long, String)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateParentId(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test updateParentId(Long, Long, String); given MeasurableDao updateParentId(Long, Long, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateParentId(Long, Long, String)"})
  void testUpdateParentId_givenMeasurableDaoUpdateParentIdReturnFalse_thenReturnFalse() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateParentId(
            Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(false);

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateParentIdResult = measurableService.updateParentId(1L, 1L, "42");

    // Assert
    verify(nameResolver, atLeast(1)).resolve(isA(EntityReference.class));
    verify(measurableDao).updateParentId(1L, 1L, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualUpdateParentIdResult);
  }

  /**
   * Test {@link MeasurableService#updateParentId(Long, Long, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateParentId(Long, Long, String)}
   */
  @Test
  @DisplayName("Test updateParentId(Long, Long, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateParentId(Long, Long, String)"})
  void testUpdateParentId_thenReturnTrue() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateParentId(
            Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(true);

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateParentIdResult = measurableService.updateParentId(1L, 1L, "42");

    // Assert
    verify(nameResolver, atLeast(1)).resolve(isA(EntityReference.class));
    verify(measurableDao).updateParentId(1L, 1L, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateParentIdResult);
  }

  /**
   * Test {@link MeasurableService#updateParentId(Long, Long, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#updateParentId(Long, Long, String)}
   */
  @Test
  @DisplayName("Test updateParentId(Long, Long, String); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.updateParentId(Long, Long, String)"})
  void testUpdateParentId_whenNull_thenReturnTrue() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.updateParentId(
            Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(true);

    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao, mock(MeasurableSearchDao.class), nameResolver, changeLogService);

    // Act
    boolean actualUpdateParentIdResult = measurableService.updateParentId(1L, null, "42");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(measurableDao).updateParentId(eq(1L), isNull(), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateParentIdResult);
  }

  /**
   * Test {@link MeasurableService#reorder(long, List, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#reorder(long, List, String)}
   */
  @Test
  @DisplayName(
      "Test reorder(long, List, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.reorder(long, List, String)"})
  void testReorder_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.reorder(anyLong(), Mockito.<List<Long>>any(), Mockito.<String>any()))
        .thenReturn(1);

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

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao,
            mock(MeasurableSearchDao.class),
            mock(EntityReferenceNameResolver.class),
            changeLogService);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    boolean actualReorderResult = measurableService.reorder(1L, ids, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).reorder(eq(1L), isA(List.class), eq("42"));
    assertTrue(actualReorderResult);
  }

  /**
   * Test {@link MeasurableService#reorder(long, List, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#reorder(long, List, String)}
   */
  @Test
  @DisplayName(
      "Test reorder(long, List, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.reorder(long, List, String)"})
  void testReorder_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.reorder(anyLong(), Mockito.<List<Long>>any(), Mockito.<String>any()))
        .thenReturn(1);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao,
            mock(MeasurableSearchDao.class),
            mock(EntityReferenceNameResolver.class),
            changeLogService);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    boolean actualReorderResult = measurableService.reorder(1L, ids, "42");

    // Assert
    verify(measurableDao).reorder(eq(1L), isA(List.class), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualReorderResult);
  }

  /**
   * Test {@link MeasurableService#reorder(long, List, String)}.
   *
   * <ul>
   *   <li>Given minus five.
   *   <li>When {@link ArrayList#ArrayList()} add minus five.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#reorder(long, List, String)}
   */
  @Test
  @DisplayName(
      "Test reorder(long, List, String); given minus five; when ArrayList() add minus five; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.reorder(long, List, String)"})
  void testReorder_givenMinusFive_whenArrayListAddMinusFive_thenCallsWrite() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.reorder(anyLong(), Mockito.<List<Long>>any(), Mockito.<String>any()))
        .thenReturn(1);

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

    MeasurableService measurableService =
        new MeasurableService(
            measurableDao,
            mock(MeasurableSearchDao.class),
            mock(EntityReferenceNameResolver.class),
            changeLogService);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(-5L);
    ids.add(1L);

    // Act
    boolean actualReorderResult = measurableService.reorder(1L, ids, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).reorder(eq(1L), isA(List.class), eq("42"));
    assertTrue(actualReorderResult);
  }

  /**
   * Test {@link MeasurableService#reorder(long, List, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#reorder(long, List, String)}
   */
  @Test
  @DisplayName("Test reorder(long, List, String); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.reorder(long, List, String)"})
  void testReorder_whenArrayList() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act and Assert
    assertTrue(measurableService.reorder(1L, new ArrayList<>(), "42"));
  }

  /**
   * Test {@link MeasurableService#reorder(long, List, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#reorder(long, List, String)}
   */
  @Test
  @DisplayName("Test reorder(long, List, String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.reorder(long, List, String)"})
  void testReorder_whenNull() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act and Assert
    assertTrue(measurableService.reorder(1L, null, "42"));
  }

  /**
   * Test {@link MeasurableService#writeAuditMessage(Long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#writeAuditMessage(Long, String, String)}
   */
  @Test
  @DisplayName(
      "Test writeAuditMessage(Long, String, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MeasurableService.writeAuditMessage(Long, String, String)"})
  void testWriteAuditMessage_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
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
    MeasurableService measurableService =
        new MeasurableService(
            mock(MeasurableDao.class),
            mock(MeasurableSearchDao.class),
            mock(EntityReferenceNameResolver.class),
            changeLogService);

    // Act
    measurableService.writeAuditMessage(1L, "42", "Msg");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
  }

  /**
   * Test {@link MeasurableService#writeAuditMessage(Long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#writeAuditMessage(Long, String, String)}
   */
  @Test
  @DisplayName(
      "Test writeAuditMessage(Long, String, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MeasurableService.writeAuditMessage(Long, String, String)"})
  void testWriteAuditMessage_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableService measurableService =
        new MeasurableService(
            mock(MeasurableDao.class),
            mock(MeasurableSearchDao.class),
            mock(EntityReferenceNameResolver.class),
            changeLogService);

    // Act
    measurableService.writeAuditMessage(1L, "42", "Msg");

    // Assert
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link MeasurableService#moveChildren(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link MeasurableDao} {@link MeasurableDao#moveChildren(Long, Long, String)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#moveChildren(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test moveChildren(Long, Long, String); given MeasurableDao moveChildren(Long, Long, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.moveChildren(Long, Long, String)"})
  void testMoveChildren_givenMeasurableDaoMoveChildrenReturnFalse_thenReturnFalse() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.moveChildren(
            Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(false);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    boolean actualMoveChildrenResult = measurableService.moveChildren(1L, 1L, "42");

    // Assert
    verify(measurableDao).moveChildren(1L, 1L, "42");
    assertFalse(actualMoveChildrenResult);
  }

  /**
   * Test {@link MeasurableService#moveChildren(Long, Long, String)}.
   *
   * <ul>
   *   <li>Given {@link MeasurableDao} {@link MeasurableDao#moveChildren(Long, Long, String)} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableService#moveChildren(Long, Long, String)}
   */
  @Test
  @DisplayName(
      "Test moveChildren(Long, Long, String); given MeasurableDao moveChildren(Long, Long, String) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableService.moveChildren(Long, Long, String)"})
  void testMoveChildren_givenMeasurableDaoMoveChildrenReturnTrue_thenReturnTrue() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.moveChildren(
            Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(true);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    boolean actualMoveChildrenResult = measurableService.moveChildren(1L, 1L, "42");

    // Assert
    verify(measurableDao).moveChildren(1L, 1L, "42");
    assertTrue(actualMoveChildrenResult);
  }

  /**
   * Test {@link MeasurableService#findHierarchyForCategory(long)}.
   *
   * <p>Method under test: {@link MeasurableService#findHierarchyForCategory(long)}
   */
  @Test
  @DisplayName("Test findHierarchyForCategory(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableService.findHierarchyForCategory(long)"})
  void testFindHierarchyForCategory() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService);

    // Act
    Set<MeasurableHierarchy> actualFindHierarchyForCategoryResult =
        measurableService.findHierarchyForCategory(1L);

    // Assert
    verify(measurableDao).findHierarchyForCategory(1L);
    assertTrue(actualFindHierarchyForCategoryResult.isEmpty());
  }
}
