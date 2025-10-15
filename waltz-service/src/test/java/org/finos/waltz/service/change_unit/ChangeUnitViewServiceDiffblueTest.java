package org.finos.waltz.service.change_unit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.FreshnessIndicator;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.change_unit.ChangeAction;
import org.finos.waltz.model.change_unit.ChangeUnit;
import org.finos.waltz.model.change_unit.ExecutionStatus;
import org.finos.waltz.model.change_unit.ImmutableChangeUnit;
import org.finos.waltz.model.change_unit.PhysicalFlowChangeUnitViewItem;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.model.physical_flow.CriticalityValue;
import org.finos.waltz.model.physical_flow.FrequencyKindValue;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlow;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlow.Builder;
import org.finos.waltz.model.physical_flow.PhysicalFlow;
import org.finos.waltz.model.physical_flow.TransportKindValue;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.service.assessment_rating.AssessmentRatingService;
import org.finos.waltz.service.logical_flow.LogicalFlowService;
import org.finos.waltz.service.physical_flow.PhysicalFlowService;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ChangeUnitViewServiceDiffblueTest {
  @Mock private AssessmentRatingService assessmentRatingService;

  @Mock private ChangeUnitService changeUnitService;

  @InjectMocks private ChangeUnitViewService changeUnitViewService;

  @Mock private LogicalFlowService logicalFlowService;

  @Mock private PhysicalFlowService physicalFlowService;

  @Mock private PhysicalSpecificationService physicalSpecificationService;

  @Mock private RatingSchemeService ratingSchemeService;

  /**
   * Test {@link ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}.
   *
   * <p>Method under test: {@link
   * ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}
   */
  @Test
  @DisplayName("Test findPhysicalFlowChangeUnitsByChangeSetId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ChangeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(long)"})
  void testFindPhysicalFlowChangeUnitsByChangeSetId() {
    // Arrange
    when(physicalFlowService.findBySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowService.findAllByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(changeUnitService.findByChangeSetId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    Set<PhysicalFlowChangeUnitViewItem> actualFindPhysicalFlowChangeUnitsByChangeSetIdResult =
        changeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(1L);

    // Assert
    verify(assessmentRatingService)
        .findByTargetKindForRelatedSelector(
            eq(EntityKind.CHANGE_UNIT), isA(IdSelectionOptions.class));
    verify(changeUnitService).findByChangeSetId(1L);
    verify(logicalFlowService).findAllByFlowIds(isA(Collection.class));
    verify(physicalFlowService).findBySelector(isA(IdSelectionOptions.class));
    verify(physicalSpecificationService).findByIds(isA(Collection.class));
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertTrue(actualFindPhysicalFlowChangeUnitsByChangeSetIdResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}.
   *
   * <p>Method under test: {@link
   * ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}
   */
  @Test
  @DisplayName("Test findPhysicalFlowChangeUnitsByChangeSetId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ChangeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(long)"})
  void testFindPhysicalFlowChangeUnitsByChangeSetId2() {
    // Arrange
    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    physicalFlowList.add(specificationIdResult.transport(TransportKindValue.of("42")).build());
    when(physicalFlowService.findBySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(physicalFlowList);
    when(logicalFlowService.findAllByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(changeUnitService.findByChangeSetId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    Set<PhysicalFlowChangeUnitViewItem> actualFindPhysicalFlowChangeUnitsByChangeSetIdResult =
        changeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(1L);

    // Assert
    verify(assessmentRatingService)
        .findByTargetKindForRelatedSelector(
            eq(EntityKind.CHANGE_UNIT), isA(IdSelectionOptions.class));
    verify(changeUnitService).findByChangeSetId(1L);
    verify(logicalFlowService).findAllByFlowIds(isA(Collection.class));
    verify(physicalFlowService).findBySelector(isA(IdSelectionOptions.class));
    verify(physicalSpecificationService).findByIds(isA(Collection.class));
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertTrue(actualFindPhysicalFlowChangeUnitsByChangeSetIdResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}.
   *
   * <p>Method under test: {@link
   * ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}
   */
  @Test
  @DisplayName("Test findPhysicalFlowChangeUnitsByChangeSetId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ChangeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(long)"})
  void testFindPhysicalFlowChangeUnitsByChangeSetId3() {
    // Arrange
    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    physicalFlowList.add(specificationIdResult.transport(TransportKindValue.of("42")).build());

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    physicalFlowList.add(specificationIdResult2.transport(TransportKindValue.of("42")).build());
    when(physicalFlowService.findBySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(physicalFlowList);
    when(logicalFlowService.findAllByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(changeUnitService.findByChangeSetId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    Set<PhysicalFlowChangeUnitViewItem> actualFindPhysicalFlowChangeUnitsByChangeSetIdResult =
        changeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(1L);

    // Assert
    verify(assessmentRatingService)
        .findByTargetKindForRelatedSelector(
            eq(EntityKind.CHANGE_UNIT), isA(IdSelectionOptions.class));
    verify(changeUnitService).findByChangeSetId(1L);
    verify(logicalFlowService).findAllByFlowIds(isA(Collection.class));
    verify(physicalFlowService).findBySelector(isA(IdSelectionOptions.class));
    verify(physicalSpecificationService).findByIds(isA(Collection.class));
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertTrue(actualFindPhysicalFlowChangeUnitsByChangeSetIdResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}.
   *
   * <p>Method under test: {@link
   * ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}
   */
  @Test
  @DisplayName("Test findPhysicalFlowChangeUnitsByChangeSetId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ChangeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(long)"})
  void testFindPhysicalFlowChangeUnitsByChangeSetId4() {
    // Arrange
    when(physicalFlowService.findBySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<LogicalFlow> logicalFlowList = new ArrayList<>();

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    logicalFlowList.add(
        sourceResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(logicalFlowService.findAllByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(logicalFlowList);
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(changeUnitService.findByChangeSetId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    Set<PhysicalFlowChangeUnitViewItem> actualFindPhysicalFlowChangeUnitsByChangeSetIdResult =
        changeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(1L);

    // Assert
    verify(assessmentRatingService)
        .findByTargetKindForRelatedSelector(
            eq(EntityKind.CHANGE_UNIT), isA(IdSelectionOptions.class));
    verify(changeUnitService).findByChangeSetId(1L);
    verify(logicalFlowService).findAllByFlowIds(isA(Collection.class));
    verify(physicalFlowService).findBySelector(isA(IdSelectionOptions.class));
    verify(physicalSpecificationService).findByIds(isA(Collection.class));
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertTrue(actualFindPhysicalFlowChangeUnitsByChangeSetIdResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}.
   *
   * <p>Method under test: {@link
   * ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}
   */
  @Test
  @DisplayName("Test findPhysicalFlowChangeUnitsByChangeSetId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ChangeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(long)"})
  void testFindPhysicalFlowChangeUnitsByChangeSetId5() {
    // Arrange
    when(physicalFlowService.findBySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowService.findAllByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(ratingSchemeItemList);
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(changeUnitService.findByChangeSetId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    Set<PhysicalFlowChangeUnitViewItem> actualFindPhysicalFlowChangeUnitsByChangeSetIdResult =
        changeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(1L);

    // Assert
    verify(assessmentRatingService)
        .findByTargetKindForRelatedSelector(
            eq(EntityKind.CHANGE_UNIT), isA(IdSelectionOptions.class));
    verify(changeUnitService).findByChangeSetId(1L);
    verify(logicalFlowService).findAllByFlowIds(isA(Collection.class));
    verify(physicalFlowService).findBySelector(isA(IdSelectionOptions.class));
    verify(physicalSpecificationService).findByIds(isA(Collection.class));
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertTrue(actualFindPhysicalFlowChangeUnitsByChangeSetIdResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}.
   *
   * <p>Method under test: {@link
   * ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}
   */
  @Test
  @DisplayName("Test findPhysicalFlowChangeUnitsByChangeSetId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ChangeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(long)"})
  void testFindPhysicalFlowChangeUnitsByChangeSetId6() {
    // Arrange
    when(physicalFlowService.findBySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowService.findAllByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(new ArrayList<>());

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(assessmentRatingList);
    when(physicalSpecificationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(changeUnitService.findByChangeSetId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    Set<PhysicalFlowChangeUnitViewItem> actualFindPhysicalFlowChangeUnitsByChangeSetIdResult =
        changeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(1L);

    // Assert
    verify(assessmentRatingService)
        .findByTargetKindForRelatedSelector(
            eq(EntityKind.CHANGE_UNIT), isA(IdSelectionOptions.class));
    verify(changeUnitService).findByChangeSetId(1L);
    verify(logicalFlowService).findAllByFlowIds(isA(Collection.class));
    verify(physicalFlowService).findBySelector(isA(IdSelectionOptions.class));
    verify(physicalSpecificationService).findByIds(isA(Collection.class));
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertTrue(actualFindPhysicalFlowChangeUnitsByChangeSetIdResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}.
   *
   * <p>Method under test: {@link
   * ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}
   */
  @Test
  @DisplayName("Test findPhysicalFlowChangeUnitsByChangeSetId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ChangeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(long)"})
  void testFindPhysicalFlowChangeUnitsByChangeSetId7() {
    // Arrange
    when(physicalFlowService.findBySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowService.findAllByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(new ArrayList<>());

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    ImmutableAssessmentRating.Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(assessmentRatingList);
    when(physicalSpecificationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(changeUnitService.findByChangeSetId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    Set<PhysicalFlowChangeUnitViewItem> actualFindPhysicalFlowChangeUnitsByChangeSetIdResult =
        changeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(1L);

    // Assert
    verify(assessmentRatingService)
        .findByTargetKindForRelatedSelector(
            eq(EntityKind.CHANGE_UNIT), isA(IdSelectionOptions.class));
    verify(changeUnitService).findByChangeSetId(1L);
    verify(logicalFlowService).findAllByFlowIds(isA(Collection.class));
    verify(physicalFlowService).findBySelector(isA(IdSelectionOptions.class));
    verify(physicalSpecificationService).findByIds(isA(Collection.class));
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertTrue(actualFindPhysicalFlowChangeUnitsByChangeSetIdResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}.
   *
   * <p>Method under test: {@link
   * ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}
   */
  @Test
  @DisplayName("Test findPhysicalFlowChangeUnitsByChangeSetId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ChangeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(long)"})
  void testFindPhysicalFlowChangeUnitsByChangeSetId8() {
    // Arrange
    when(physicalFlowService.findBySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowService.findAllByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<PhysicalSpecification> physicalSpecificationList = new ArrayList<>();

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    physicalSpecificationList.add(
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
    when(physicalSpecificationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(physicalSpecificationList);
    when(changeUnitService.findByChangeSetId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    Set<PhysicalFlowChangeUnitViewItem> actualFindPhysicalFlowChangeUnitsByChangeSetIdResult =
        changeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(1L);

    // Assert
    verify(assessmentRatingService)
        .findByTargetKindForRelatedSelector(
            eq(EntityKind.CHANGE_UNIT), isA(IdSelectionOptions.class));
    verify(changeUnitService).findByChangeSetId(1L);
    verify(logicalFlowService).findAllByFlowIds(isA(Collection.class));
    verify(physicalFlowService).findBySelector(isA(IdSelectionOptions.class));
    verify(physicalSpecificationService).findByIds(isA(Collection.class));
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertTrue(actualFindPhysicalFlowChangeUnitsByChangeSetIdResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}.
   *
   * <p>Method under test: {@link
   * ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}
   */
  @Test
  @DisplayName("Test findPhysicalFlowChangeUnitsByChangeSetId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ChangeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(long)"})
  void testFindPhysicalFlowChangeUnitsByChangeSetId9() {
    // Arrange
    when(physicalFlowService.findBySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowService.findAllByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<ChangeUnit> changeUnitList = new ArrayList<>();

    ImmutableChangeUnit.Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    changeUnitList.add(
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
    when(changeUnitService.findByChangeSetId(anyLong())).thenReturn(changeUnitList);

    // Act
    Set<PhysicalFlowChangeUnitViewItem> actualFindPhysicalFlowChangeUnitsByChangeSetIdResult =
        changeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(1L);

    // Assert
    verify(assessmentRatingService)
        .findByTargetKindForRelatedSelector(
            eq(EntityKind.CHANGE_UNIT), isA(IdSelectionOptions.class));
    verify(changeUnitService).findByChangeSetId(1L);
    verify(logicalFlowService).findAllByFlowIds(isA(Collection.class));
    verify(physicalFlowService).findBySelector(isA(IdSelectionOptions.class));
    verify(physicalSpecificationService).findByIds(isA(Collection.class));
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertTrue(actualFindPhysicalFlowChangeUnitsByChangeSetIdResult.isEmpty());
  }

  /**
   * Test {@link ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}.
   *
   * <p>Method under test: {@link
   * ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}
   */
  @Test
  @DisplayName("Test findPhysicalFlowChangeUnitsByChangeSetId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ChangeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(long)"})
  void testFindPhysicalFlowChangeUnitsByChangeSetId10() {
    // Arrange
    when(physicalFlowService.findBySelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(logicalFlowService.findAllByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(new ArrayList<>());
    when(assessmentRatingService.findByTargetKindForRelatedSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(new ArrayList<>());
    when(physicalSpecificationService.findByIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<ChangeUnit> changeUnitList = new ArrayList<>();

    ImmutableChangeUnit.Builder provenanceResult =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    changeUnitList.add(
        provenanceResult
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());

    ImmutableChangeUnit.Builder provenanceResult2 =
        ImmutableChangeUnit.builder()
            .action(ChangeAction.ACTIVATE)
            .changeSetId(1L)
            .description("The characteristics of someone or something")
            .executionStatus(ExecutionStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance");
    changeUnitList.add(
        provenanceResult2
            .subjectEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .subjectInitialStatus(EntityLifecycleStatus.ACTIVE)
            .build());
    when(changeUnitService.findByChangeSetId(anyLong())).thenReturn(changeUnitList);

    // Act
    Set<PhysicalFlowChangeUnitViewItem> actualFindPhysicalFlowChangeUnitsByChangeSetIdResult =
        changeUnitViewService.findPhysicalFlowChangeUnitsByChangeSetId(1L);

    // Assert
    verify(assessmentRatingService)
        .findByTargetKindForRelatedSelector(
            eq(EntityKind.CHANGE_UNIT), isA(IdSelectionOptions.class));
    verify(changeUnitService).findByChangeSetId(1L);
    verify(logicalFlowService).findAllByFlowIds(isA(Collection.class));
    verify(physicalFlowService).findBySelector(isA(IdSelectionOptions.class));
    verify(physicalSpecificationService).findByIds(isA(Collection.class));
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertTrue(actualFindPhysicalFlowChangeUnitsByChangeSetIdResult.isEmpty());
  }
}
