package org.finos.waltz.service.physical_specification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
import org.finos.waltz.data.physical_specification.search.PhysicalSpecificationSearchDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ImmutableSetAttributeCommand;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.SetAttributeCommand;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.command.CommandResponse;
import org.finos.waltz.model.command.ImmutableCommandResponse;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification.Builder;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecificationDeleteCommand;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.model.physical_specification.PhysicalSpecificationDeleteCommand;
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
class PhysicalSpecificationServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private PhysicalSpecificationDao physicalSpecificationDao;

  @Mock private PhysicalSpecificationSearchDao physicalSpecificationSearchDao;

  @InjectMocks private PhysicalSpecificationService physicalSpecificationService;

  /**
   * Test {@link PhysicalSpecificationService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecificationService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PhysicalSpecificationService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenReturnEmpty() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act
    Set<PhysicalSpecification> actualFindByEntityReferenceResult =
        physicalSpecificationService.findByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(specificationDao).findByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecificationService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecificationService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findByEntityReference(EntityReference); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PhysicalSpecificationService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenThrowUnsupportedOperationException() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new UnsupportedOperationException());
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            physicalSpecificationService.findByEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(specificationDao).findByEntityReference(isA(EntityReference.class));
  }

  /**
   * Test {@link PhysicalSpecificationService#getById(long)}.
   *
   * <ul>
   *   <li>Then owningEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then owningEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhysicalSpecification PhysicalSpecificationService.getById(long)"})
  void testGetById_thenOwningEntityReturnImmutableEntityReference() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);

    Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");
    DataFormatKindValue format = DataFormatKindValue.of("42");

    Builder nameResult =
        externalIdResult
            .format(format)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(specificationDao.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act
    PhysicalSpecification actualById = physicalSpecificationService.getById(1L);

    // Assert
    verify(specificationDao).getById(1L);
    assertTrue(actualById.owningEntity() instanceof ImmutableEntityReference);
    assertTrue(actualById instanceof ImmutablePhysicalSpecification);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertFalse(actualById.isReadOnly());
    assertFalse(actualById.isRemoved());
    assertSame(format, actualById.format());
  }

  /**
   * Test {@link PhysicalSpecificationService#getById(long)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhysicalSpecification PhysicalSpecificationService.getById(long)"})
  void testGetById_thenThrowUnsupportedOperationException() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.getById(anyLong())).thenThrow(new UnsupportedOperationException());
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> physicalSpecificationService.getById(1L));
    verify(specificationDao).getById(1L);
  }

  /**
   * Test {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<PhysicalSpecification> physicalSpecificationSet = new HashSet<>();
    when(specificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(physicalSpecificationSet);
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
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
    Collection<PhysicalSpecification> actualFindBySelectorResult =
        physicalSpecificationService.findBySelector(options);

    // Assert
    verify(specificationDao).findBySelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult instanceof Set);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalSpecificationSet, actualFindBySelectorResult);
  }

  /**
   * Test {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenBuilderAddOmitApplicationKindsInHouse_thenCallsFilters() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<PhysicalSpecification> physicalSpecificationSet = new HashSet<>();
    when(specificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(physicalSpecificationSet);
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.filters()).thenReturn(builderResult.build());
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    Collection<PhysicalSpecification> actualFindBySelectorResult =
        physicalSpecificationService.findBySelector(options);

    // Assert
    verify(specificationDao).findBySelector(isA(Select.class));
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult instanceof Set);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalSpecificationSet, actualFindBySelectorResult);
  }

  /**
   * Test {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder build.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions); given builder build; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenBuilderBuild_thenCallsFilters() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<PhysicalSpecification> physicalSpecificationSet = new HashSet<>();
    when(specificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(physicalSpecificationSet);
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    Collection<PhysicalSpecification> actualFindBySelectorResult =
        physicalSpecificationService.findBySelector(options);

    // Assert
    verify(specificationDao).findBySelector(isA(Select.class));
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult instanceof Set);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalSpecificationSet, actualFindBySelectorResult);
  }

  /**
   * Test {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given HashSet() add 'PENDING'; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenHashSetAddPending_thenCallsFilters() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    HashSet<PhysicalSpecification> physicalSpecificationSet = new HashSet<>();
    when(specificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(physicalSpecificationSet);
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    Collection<PhysicalSpecification> actualFindBySelectorResult =
        physicalSpecificationService.findBySelector(options);

    // Assert
    verify(specificationDao).findBySelector(isA(Select.class));
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult instanceof Set);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalSpecificationSet, actualFindBySelectorResult);
  }

  /**
   * Test {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code REMOVED}.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given HashSet() add 'REMOVED'; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenHashSetAddRemoved_thenCallsFilters() {
    // Arrange
    HashSet<PhysicalSpecification> physicalSpecificationSet = new HashSet<>();
    when(physicalSpecificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(physicalSpecificationSet);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
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
    Collection<PhysicalSpecification> actualFindBySelectorResult =
        physicalSpecificationService.findBySelector(options);

    // Assert
    verify(physicalSpecificationDao).findBySelector(isA(Select.class));
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindBySelectorResult instanceof Set);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalSpecificationSet, actualFindBySelectorResult);
  }

  /**
   * Test {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_thenThrowUnsupportedOperationException() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new UnsupportedOperationException());
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.REMOVED);

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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            physicalSpecificationService.findBySelector(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(specificationDao).findBySelector(isA(Select.class));
  }

  /**
   * Test {@link
   * PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}.
   *
   * <p>Method under test: {@link
   * PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}
   */
  @Test
  @DisplayName("Test markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommandResponse PhysicalSpecificationService.markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)"
  })
  void testMarkRemovedIfUnused() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.getById(anyLong())).thenThrow(new UnsupportedOperationException());
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            physicalSpecificationService.markRemovedIfUnused(
                ImmutablePhysicalSpecificationDeleteCommand.builder().specificationId(1L).build(),
                "janedoe"));
    verify(specificationDao).getById(1L);
  }

  /**
   * Test {@link
   * PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}.
   *
   * <p>Method under test: {@link
   * PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}
   */
  @Test
  @DisplayName("Test markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommandResponse PhysicalSpecificationService.markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)"
  })
  void testMarkRemovedIfUnused2() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.markRemovedIfUnused(anyLong()))
        .thenThrow(new UnsupportedOperationException());

    Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(specificationDao.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            physicalSpecificationService.markRemovedIfUnused(
                ImmutablePhysicalSpecificationDeleteCommand.builder().specificationId(1L).build(),
                "janedoe"));
    verify(specificationDao).getById(1L);
    verify(specificationDao).markRemovedIfUnused(1L);
  }

  /**
   * Test {@link
   * PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}.
   *
   * <p>Method under test: {@link
   * PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}
   */
  @Test
  @DisplayName("Test markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommandResponse PhysicalSpecificationService.markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)"
  })
  void testMarkRemovedIfUnused3() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new UnsupportedOperationException());
    when(physicalSpecificationDao.markRemovedIfUnused(anyLong())).thenReturn(1);

    Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationDao.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    PhysicalSpecificationDeleteCommand command = mock(PhysicalSpecificationDeleteCommand.class);
    when(command.specificationId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecificationService.markRemovedIfUnused(command, "janedoe"));
    verify(physicalSpecificationDao).getById(1L);
    verify(physicalSpecificationDao).markRemovedIfUnused(1L);
    verify(command, atLeast(1)).specificationId();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link
   * PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}
   */
  @Test
  @DisplayName(
      "Test markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommandResponse PhysicalSpecificationService.markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)"
  })
  void testMarkRemovedIfUnused_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
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

    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.markRemovedIfUnused(anyLong())).thenReturn(1);

    Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(specificationDao.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));
    ImmutablePhysicalSpecificationDeleteCommand command =
        ImmutablePhysicalSpecificationDeleteCommand.builder().specificationId(1L).build();

    // Act
    CommandResponse<PhysicalSpecificationDeleteCommand> actualMarkRemovedIfUnusedResult =
        physicalSpecificationService.markRemovedIfUnused(command, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(specificationDao).getById(1L);
    verify(specificationDao).markRemovedIfUnused(1L);
    EntityReference entityReferenceResult = actualMarkRemovedIfUnusedResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualMarkRemovedIfUnusedResult instanceof ImmutableCommandResponse);
    PhysicalSpecificationDeleteCommand originalCommandResult =
        actualMarkRemovedIfUnusedResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutablePhysicalSpecificationDeleteCommand);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, originalCommandResult.specificationId());
    assertEquals(EntityKind.PHYSICAL_SPECIFICATION, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualMarkRemovedIfUnusedResult.outcome());
    assertSame(command, originalCommandResult);
  }

  /**
   * Test {@link
   * PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}
   */
  @Test
  @DisplayName(
      "Test markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String); given UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommandResponse PhysicalSpecificationService.markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)"
  })
  void testMarkRemovedIfUnused_givenUnsupportedOperationException() {
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
    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService,
            mock(PhysicalSpecificationDao.class),
            mock(PhysicalSpecificationSearchDao.class));

    PhysicalSpecificationDeleteCommand command = mock(PhysicalSpecificationDeleteCommand.class);
    when(command.specificationId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecificationService.markRemovedIfUnused(command, "janedoe"));
    verify(command).specificationId();
  }

  /**
   * Test {@link
   * PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}.
   *
   * <ul>
   *   <li>Then return outcome is {@code FAILURE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}
   */
  @Test
  @DisplayName(
      "Test markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String); then return outcome is 'FAILURE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommandResponse PhysicalSpecificationService.markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)"
  })
  void testMarkRemovedIfUnused_thenReturnOutcomeIsFailure() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.markRemovedIfUnused(anyLong())).thenReturn(0);

    Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(specificationDao.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());
    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            mock(ChangeLogService.class),
            specificationDao,
            mock(PhysicalSpecificationSearchDao.class));
    ImmutablePhysicalSpecificationDeleteCommand command =
        ImmutablePhysicalSpecificationDeleteCommand.builder().specificationId(1L).build();

    // Act
    CommandResponse<PhysicalSpecificationDeleteCommand> actualMarkRemovedIfUnusedResult =
        physicalSpecificationService.markRemovedIfUnused(command, "janedoe");

    // Assert
    verify(specificationDao).getById(1L);
    verify(specificationDao).markRemovedIfUnused(1L);
    EntityReference entityReferenceResult = actualMarkRemovedIfUnusedResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualMarkRemovedIfUnusedResult instanceof ImmutableCommandResponse);
    PhysicalSpecificationDeleteCommand originalCommandResult =
        actualMarkRemovedIfUnusedResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutablePhysicalSpecificationDeleteCommand);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, originalCommandResult.specificationId());
    assertEquals(EntityKind.PHYSICAL_SPECIFICATION, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.FAILURE, actualMarkRemovedIfUnusedResult.outcome());
    assertSame(command, originalCommandResult);
  }

  /**
   * Test {@link
   * PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}.
   *
   * <ul>
   *   <li>Then return outcome is {@code SUCCESS}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)}
   */
  @Test
  @DisplayName(
      "Test markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String); then return outcome is 'SUCCESS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CommandResponse PhysicalSpecificationService.markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)"
  })
  void testMarkRemovedIfUnused_thenReturnOutcomeIsSuccess() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.markRemovedIfUnused(anyLong())).thenReturn(1);

    Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(specificationDao.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));
    ImmutablePhysicalSpecificationDeleteCommand command =
        ImmutablePhysicalSpecificationDeleteCommand.builder().specificationId(1L).build();

    // Act
    CommandResponse<PhysicalSpecificationDeleteCommand> actualMarkRemovedIfUnusedResult =
        physicalSpecificationService.markRemovedIfUnused(command, "janedoe");

    // Assert
    verify(specificationDao).getById(1L);
    verify(specificationDao).markRemovedIfUnused(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    EntityReference entityReferenceResult = actualMarkRemovedIfUnusedResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualMarkRemovedIfUnusedResult instanceof ImmutableCommandResponse);
    PhysicalSpecificationDeleteCommand originalCommandResult =
        actualMarkRemovedIfUnusedResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutablePhysicalSpecificationDeleteCommand);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, originalCommandResult.specificationId());
    assertEquals(EntityKind.PHYSICAL_SPECIFICATION, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualMarkRemovedIfUnusedResult.outcome());
    assertSame(command, originalCommandResult);
  }

  /**
   * Test {@link PhysicalSpecificationService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecificationService.search(EntitySearchOptions)"})
  void testSearch_thenReturnEmpty() {
    // Arrange
    PhysicalSpecificationSearchDao specificationSearchDao =
        mock(PhysicalSpecificationSearchDao.class);
    when(specificationSearchDao.search(Mockito.<EntitySearchOptions>any()))
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, mock(PhysicalSpecificationDao.class), specificationSearchDao);

    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<PhysicalSpecification> actualSearchResult =
        physicalSpecificationService.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(specificationSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecificationService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecificationService.search(EntitySearchOptions)"})
  void testSearch_thenThrowUnsupportedOperationException() {
    // Arrange
    PhysicalSpecificationSearchDao specificationSearchDao =
        mock(PhysicalSpecificationSearchDao.class);
    when(specificationSearchDao.search(Mockito.<EntitySearchOptions>any()))
        .thenThrow(new UnsupportedOperationException());
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, mock(PhysicalSpecificationDao.class), specificationSearchDao);

    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            physicalSpecificationService.search(
                builderResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .searchQuery("Search Query")
                    .userId("42")
                    .build()));
    verify(specificationSearchDao).search(isA(EntitySearchOptions.class));
  }

  /**
   * Test {@link PhysicalSpecificationService#findByIds(Collection)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#findByIds(Collection)}
   */
  @Test
  @DisplayName(
      "Test findByIds(Collection); given zero; when ArrayList() add zero; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationService.findByIds(Collection)"})
  void testFindByIds_givenZero_whenArrayListAddZero_thenReturnArrayList() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    ArrayList<PhysicalSpecification> physicalSpecificationList = new ArrayList<>();
    when(specificationDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(physicalSpecificationList);
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    Collection<PhysicalSpecification> actualFindByIdsResult =
        physicalSpecificationService.findByIds(ids);

    // Assert
    verify(specificationDao).findByIds(isA(Collection.class));
    assertTrue(actualFindByIdsResult instanceof List);
    assertTrue(actualFindByIdsResult.isEmpty());
    assertSame(physicalSpecificationList, actualFindByIdsResult);
  }

  /**
   * Test {@link PhysicalSpecificationService#findByIds(Collection)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationService.findByIds(Collection)"})
  void testFindByIds_thenReturnArrayList() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    ArrayList<PhysicalSpecification> physicalSpecificationList = new ArrayList<>();
    when(specificationDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(physicalSpecificationList);
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Collection<PhysicalSpecification> actualFindByIdsResult =
        physicalSpecificationService.findByIds(ids);

    // Assert
    verify(specificationDao).findByIds(isA(Collection.class));
    assertTrue(actualFindByIdsResult instanceof List);
    assertTrue(actualFindByIdsResult.isEmpty());
    assertSame(physicalSpecificationList, actualFindByIdsResult);
  }

  /**
   * Test {@link PhysicalSpecificationService#findByIds(Collection)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationService.findByIds(Collection)"})
  void testFindByIds_thenThrowUnsupportedOperationException() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.findByIds(Mockito.<Collection<Long>>any()))
        .thenThrow(new UnsupportedOperationException());
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> physicalSpecificationService.findByIds(ids));
    verify(specificationDao).findByIds(isA(Collection.class));
  }

  /**
   * Test {@link PhysicalSpecificationService#findByIds(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection); when ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationService.findByIds(Collection)"})
  void testFindByIds_whenArrayList_thenReturnList() {
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
    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService,
            mock(PhysicalSpecificationDao.class),
            mock(PhysicalSpecificationSearchDao.class));

    // Act
    Collection<PhysicalSpecification> actualFindByIdsResult =
        physicalSpecificationService.findByIds(new ArrayList<>());

    // Assert
    assertTrue(actualFindByIdsResult instanceof List);
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecificationService#findByIds(Collection)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection); when 'null'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationService.findByIds(Collection)"})
  void testFindByIds_whenNull_thenReturnList() {
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
    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService,
            mock(PhysicalSpecificationDao.class),
            mock(PhysicalSpecificationSearchDao.class));

    // Act
    Collection<PhysicalSpecification> actualFindByIdsResult =
        physicalSpecificationService.findByIds(null);

    // Assert
    assertTrue(actualFindByIdsResult instanceof List);
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecificationService#findByExternalId(String)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#findByExternalId(String)}
   */
  @Test
  @DisplayName("Test findByExternalId(String); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationService.findByExternalId(String)"})
  void testFindByExternalId_thenReturnList() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    ArrayList<PhysicalSpecification> physicalSpecificationList = new ArrayList<>();
    when(specificationDao.findByExternalId(Mockito.<String>any()))
        .thenReturn(physicalSpecificationList);
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act
    Collection<PhysicalSpecification> actualFindByExternalIdResult =
        physicalSpecificationService.findByExternalId("42");

    // Assert
    verify(specificationDao).findByExternalId("42");
    assertTrue(actualFindByExternalIdResult instanceof List);
    assertTrue(actualFindByExternalIdResult.isEmpty());
    assertSame(physicalSpecificationList, actualFindByExternalIdResult);
  }

  /**
   * Test {@link PhysicalSpecificationService#findByExternalId(String)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#findByExternalId(String)}
   */
  @Test
  @DisplayName("Test findByExternalId(String); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalSpecificationService.findByExternalId(String)"})
  void testFindByExternalId_thenThrowUnsupportedOperationException() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.findByExternalId(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecificationService.findByExternalId("42"));
    verify(specificationDao).findByExternalId("42");
  }

  /**
   * Test {@link PhysicalSpecificationService#updateExternalId(Long, String)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#updateExternalId(Long, String)}
   */
  @Test
  @DisplayName("Test updateExternalId(Long, String); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationService.updateExternalId(Long, String)"})
  void testUpdateExternalId_thenReturnOne() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.updateExternalId(anyLong(), Mockito.<String>any())).thenReturn(1);
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act
    int actualUpdateExternalIdResult = physicalSpecificationService.updateExternalId(1L, "42");

    // Assert
    verify(specificationDao).updateExternalId(1L, "42");
    assertEquals(1, actualUpdateExternalIdResult);
  }

  /**
   * Test {@link PhysicalSpecificationService#updateExternalId(Long, String)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#updateExternalId(Long, String)}
   */
  @Test
  @DisplayName("Test updateExternalId(Long, String); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationService.updateExternalId(Long, String)"})
  void testUpdateExternalId_thenThrowUnsupportedOperationException() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.updateExternalId(anyLong(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecificationService.updateExternalId(1L, "42"));
    verify(specificationDao).updateExternalId(1L, "42");
  }

  /**
   * Test {@link PhysicalSpecificationService#isUsed(Long)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalSpecificationDao} {@link PhysicalSpecificationDao#isUsed(long)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#isUsed(Long)}
   */
  @Test
  @DisplayName(
      "Test isUsed(Long); given PhysicalSpecificationDao isUsed(long) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalSpecificationService.isUsed(Long)"})
  void testIsUsed_givenPhysicalSpecificationDaoIsUsedReturnFalse_thenReturnFalse() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.isUsed(anyLong())).thenReturn(false);
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act
    boolean actualIsUsedResult = physicalSpecificationService.isUsed(1L);

    // Assert
    verify(specificationDao).isUsed(1L);
    assertFalse(actualIsUsedResult);
  }

  /**
   * Test {@link PhysicalSpecificationService#isUsed(Long)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalSpecificationDao} {@link PhysicalSpecificationDao#isUsed(long)}
   *       return {@code true}.
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#isUsed(Long)}
   */
  @Test
  @DisplayName(
      "Test isUsed(Long); given PhysicalSpecificationDao isUsed(long) return 'true'; when one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalSpecificationService.isUsed(Long)"})
  void testIsUsed_givenPhysicalSpecificationDaoIsUsedReturnTrue_whenOne_thenReturnTrue() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.isUsed(anyLong())).thenReturn(true);
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act
    boolean actualIsUsedResult = physicalSpecificationService.isUsed(1L);

    // Assert
    verify(specificationDao).isUsed(1L);
    assertTrue(actualIsUsedResult);
  }

  /**
   * Test {@link PhysicalSpecificationService#isUsed(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#isUsed(Long)}
   */
  @Test
  @DisplayName("Test isUsed(Long); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalSpecificationService.isUsed(Long)"})
  void testIsUsed_thenThrowUnsupportedOperationException() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.isUsed(anyLong())).thenThrow(new UnsupportedOperationException());
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> physicalSpecificationService.isUsed(1L));
    verify(specificationDao).isUsed(1L);
  }

  /**
   * Test {@link PhysicalSpecificationService#create(ImmutablePhysicalSpecification)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalSpecificationDao} {@link
   *       PhysicalSpecificationDao#create(PhysicalSpecification)} return one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecificationService#create(ImmutablePhysicalSpecification)}
   */
  @Test
  @DisplayName(
      "Test create(ImmutablePhysicalSpecification); given PhysicalSpecificationDao create(PhysicalSpecification) return one; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long PhysicalSpecificationService.create(ImmutablePhysicalSpecification)"})
  void testCreate_givenPhysicalSpecificationDaoCreateReturnOne_thenReturnLongValueIsOne() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.create(Mockito.<PhysicalSpecification>any())).thenReturn(1L);
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act
    Long actualCreateResult = physicalSpecificationService.create(null);

    // Assert
    verify(specificationDao).create(isNull());
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Test {@link PhysicalSpecificationService#create(ImmutablePhysicalSpecification)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecificationService#create(ImmutablePhysicalSpecification)}
   */
  @Test
  @DisplayName(
      "Test create(ImmutablePhysicalSpecification); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long PhysicalSpecificationService.create(ImmutablePhysicalSpecification)"})
  void testCreate_thenThrowUnsupportedOperationException() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.create(Mockito.<PhysicalSpecification>any()))
        .thenThrow(new UnsupportedOperationException());
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> physicalSpecificationService.create(null));
    verify(specificationDao).create(isNull());
  }

  /**
   * Test {@link PhysicalSpecificationService#makeActive(Long, String)}.
   *
   * <p>Method under test: {@link PhysicalSpecificationService#makeActive(Long, String)}
   */
  @Test
  @DisplayName("Test makeActive(Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationService.makeActive(Long, String)"})
  void testMakeActive() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.makeActive(Mockito.<Long>any()))
        .thenThrow(new UnsupportedOperationException());
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecificationService.makeActive(1L, "janedoe"));
    verify(specificationDao).makeActive(1L);
  }

  /**
   * Test {@link PhysicalSpecificationService#makeActive(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>When {@code janedoe}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#makeActive(Long, String)}
   */
  @Test
  @DisplayName(
      "Test makeActive(Long, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; when 'janedoe'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationService.makeActive(Long, String)"})
  void testMakeActive_givenChangeLogDaoWriteReturn19088743_whenJanedoe_thenCallsWrite() {
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

    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.makeActive(Mockito.<Long>any())).thenReturn(1);

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act
    int actualMakeActiveResult = physicalSpecificationService.makeActive(1L, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(specificationDao).makeActive(1L);
    assertEquals(1, actualMakeActiveResult);
  }

  /**
   * Test {@link PhysicalSpecificationService#makeActive(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#makeActive(Long, String)}
   */
  @Test
  @DisplayName(
      "Test makeActive(Long, String); given ChangeLogService write(ChangeLog) return '19088743'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationService.makeActive(Long, String)"})
  void testMakeActive_givenChangeLogServiceWriteReturn19088743_thenReturnOne() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.makeActive(Mockito.<Long>any())).thenReturn(1);

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act
    int actualMakeActiveResult = physicalSpecificationService.makeActive(1L, "janedoe");

    // Assert
    verify(specificationDao).makeActive(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualMakeActiveResult);
  }

  /**
   * Test {@link PhysicalSpecificationService#makeActive(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#makeActive(Long, String)}
   */
  @Test
  @DisplayName(
      "Test makeActive(Long, String); given ChangeLogService write(ChangeLog) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationService.makeActive(Long, String)"})
  void testMakeActive_givenChangeLogServiceWriteThrowUnsupportedOperationException() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new UnsupportedOperationException());
    when(physicalSpecificationDao.makeActive(Mockito.<Long>any())).thenReturn(1);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecificationService.makeActive(1L, "janedoe"));
    verify(physicalSpecificationDao).makeActive(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link PhysicalSpecificationService#makeActive(Long, String)}.
   *
   * <ul>
   *   <li>Then return minus two.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#makeActive(Long, String)}
   */
  @Test
  @DisplayName("Test makeActive(Long, String); then return minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecificationService.makeActive(Long, String)"})
  void testMakeActive_thenReturnMinusTwo() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.makeActive(Mockito.<Long>any())).thenReturn(-2);
    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            mock(ChangeLogService.class),
            specificationDao,
            mock(PhysicalSpecificationSearchDao.class));

    // Act
    int actualMakeActiveResult = physicalSpecificationService.makeActive(1L, "janedoe");

    // Assert
    verify(specificationDao).makeActive(1L);
    assertEquals(-2, actualMakeActiveResult);
  }

  /**
   * Test {@link PhysicalSpecificationService#propagateDataTypesToLogicalFlows(String, long)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecificationService#propagateDataTypesToLogicalFlows(String, long)}
   */
  @Test
  @DisplayName("Test propagateDataTypesToLogicalFlows(String, long); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalSpecificationService.propagateDataTypesToLogicalFlows(String, long)"
  })
  void testPropagateDataTypesToLogicalFlows_thenReturnOne() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.propagateDataTypesToLogicalFlows(Mockito.<String>any(), anyLong()))
        .thenReturn(1);
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act
    int actualPropagateDataTypesToLogicalFlowsResult =
        physicalSpecificationService.propagateDataTypesToLogicalFlows("janedoe", 1L);

    // Assert
    verify(specificationDao).propagateDataTypesToLogicalFlows("janedoe", 1L);
    assertEquals(1, actualPropagateDataTypesToLogicalFlowsResult);
  }

  /**
   * Test {@link PhysicalSpecificationService#propagateDataTypesToLogicalFlows(String, long)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecificationService#propagateDataTypesToLogicalFlows(String, long)}
   */
  @Test
  @DisplayName(
      "Test propagateDataTypesToLogicalFlows(String, long); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalSpecificationService.propagateDataTypesToLogicalFlows(String, long)"
  })
  void testPropagateDataTypesToLogicalFlows_thenThrowUnsupportedOperationException() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.propagateDataTypesToLogicalFlows(Mockito.<String>any(), anyLong()))
        .thenThrow(new UnsupportedOperationException());
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecificationService.propagateDataTypesToLogicalFlows("janedoe", 1L));
    verify(specificationDao).propagateDataTypesToLogicalFlows("janedoe", 1L);
  }

  /**
   * Test {@link PhysicalSpecificationService#updateAttribute(String, SetAttributeCommand)}.
   *
   * <p>Method under test: {@link PhysicalSpecificationService#updateAttribute(String,
   * SetAttributeCommand)}
   */
  @Test
  @DisplayName("Test updateAttribute(String, SetAttributeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalSpecificationService.updateAttribute(String, SetAttributeCommand)"
  })
  void testUpdateAttribute() {
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
    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService,
            mock(PhysicalSpecificationDao.class),
            mock(PhysicalSpecificationSearchDao.class));

    ImmutableSetAttributeCommand.Builder builderResult = ImmutableSetAttributeCommand.builder();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            physicalSpecificationService.updateAttribute(
                "janedoe",
                builderResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .name("Name")
                    .value("42")
                    .build()));
  }

  /**
   * Test {@link PhysicalSpecificationService#updateAttribute(String, SetAttributeCommand)}.
   *
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException()}.
   *   <li>Then calls {@link SetAttributeCommand#name()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecificationService#updateAttribute(String,
   * SetAttributeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateAttribute(String, SetAttributeCommand); given UnsupportedOperationException(); then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalSpecificationService.updateAttribute(String, SetAttributeCommand)"
  })
  void testUpdateAttribute_givenUnsupportedOperationException_thenCallsName() {
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
    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService,
            mock(PhysicalSpecificationDao.class),
            mock(PhysicalSpecificationSearchDao.class));

    SetAttributeCommand command = mock(SetAttributeCommand.class);
    when(command.name()).thenThrow(new UnsupportedOperationException());
    when(command.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> physicalSpecificationService.updateAttribute("janedoe", command));
    verify(command).name();
    verify(command).entityReference();
  }
}
