package org.finos.waltz.service.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import org.finos.waltz.data.assessment_definition.AssessmentDefinitionDao;
import org.finos.waltz.data.assessment_rating.AssessmentRatingDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.data.user.UserPreferenceDao;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition.Builder;
import org.finos.waltz.model.assessment_rating.AssessmentGroupedEntities;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.assessment_rating.AssessmentRatingDetail;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.assessment_rating.ImmutableRatingEntityList;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.model.user.ImmutableUserPreference;
import org.finos.waltz.model.user.UserPreference;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.user.UserPreferenceService;
import org.jooq.Condition;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AssessmentRatingViewServiceDiffblueTest {
  /**
   * Test {@link AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}
   */
  @Test
  @DisplayName("Test findGroupedByDefinitionAndOutcomes(EntityKind, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection AssessmentRatingViewService.findGroupedByDefinitionAndOutcomes(EntityKind, List)"
  })
  void testFindGroupedByDefinitionAndOutcomes() {
    // Arrange
    HashSet<Tuple2<Long, Set<ImmutableRatingEntityList>>> tuple2Set = new HashSet<>();
    Tuple2<Long, Set<ImmutableRatingEntityList>> tuple2 = new Tuple2<>(1L, new HashSet<>());
    tuple2Set.add(tuple2);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findGroupedByDefinitionAndOutcome(Mockito.<Condition>any()))
        .thenReturn(tuple2Set);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference = Optional.empty();
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(assessmentDefinitionSet);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    UserPreferenceService userPreferenceService =
        new UserPreferenceService(mock(UserPreferenceDao.class));

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Collection<AssessmentGroupedEntities> actualFindGroupedByDefinitionAndOutcomesResult =
        assessmentRatingViewService.findGroupedByDefinitionAndOutcomes(
            EntityKind.ALL, new ArrayList<>());

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findGroupedByDefinitionAndOutcome(isA(Condition.class));
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult instanceof Set);
    assertEquals(1, actualFindGroupedByDefinitionAndOutcomesResult.size());
  }

  /**
   * Test {@link AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}
   */
  @Test
  @DisplayName("Test findGroupedByDefinitionAndOutcomes(EntityKind, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection AssessmentRatingViewService.findGroupedByDefinitionAndOutcomes(EntityKind, List)"
  })
  void testFindGroupedByDefinitionAndOutcomes2() {
    // Arrange
    HashSet<Tuple2<Long, Set<ImmutableRatingEntityList>>> tuple2Set = new HashSet<>();
    Tuple2<Long, Set<ImmutableRatingEntityList>> tuple2 = new Tuple2<>(1L, new HashSet<>());
    tuple2Set.add(tuple2);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findGroupedByDefinitionAndOutcome(Mockito.<Condition>any()))
        .thenReturn(tuple2Set);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    Builder provenanceResult2 =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    Optional<? extends EntityReference> qualifierReference2 = Optional.empty();
    assessmentDefinitionSet.add(
        provenanceResult2
            .qualifierReference(qualifierReference2)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(assessmentDefinitionSet);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    UserPreferenceService userPreferenceService =
        new UserPreferenceService(mock(UserPreferenceDao.class));

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Collection<AssessmentGroupedEntities> actualFindGroupedByDefinitionAndOutcomesResult =
        assessmentRatingViewService.findGroupedByDefinitionAndOutcomes(
            EntityKind.ALL, new ArrayList<>());

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findGroupedByDefinitionAndOutcome(isA(Condition.class));
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult instanceof Set);
    assertEquals(1, actualFindGroupedByDefinitionAndOutcomesResult.size());
  }

  /**
   * Test {@link AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}
   */
  @Test
  @DisplayName("Test findGroupedByDefinitionAndOutcomes(EntityKind, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection AssessmentRatingViewService.findGroupedByDefinitionAndOutcomes(EntityKind, List)"
  })
  void testFindGroupedByDefinitionAndOutcomes3() {
    // Arrange
    ImmutableRatingEntityList.Builder builderResult = ImmutableRatingEntityList.builder();
    builderResult.addEntityReferences(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableRatingEntityList immutableRatingEntityList = builderResult.rating("Rating").build();

    HashSet<ImmutableRatingEntityList> immutableRatingEntityListSet = new HashSet<>();
    immutableRatingEntityListSet.add(immutableRatingEntityList);
    Tuple2<Long, Set<ImmutableRatingEntityList>> tuple2 =
        new Tuple2<>(1L, immutableRatingEntityListSet);

    HashSet<Tuple2<Long, Set<ImmutableRatingEntityList>>> tuple2Set = new HashSet<>();
    tuple2Set.add(tuple2);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findGroupedByDefinitionAndOutcome(Mockito.<Condition>any()))
        .thenReturn(tuple2Set);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(assessmentDefinitionSet);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    UserPreferenceService userPreferenceService =
        new UserPreferenceService(mock(UserPreferenceDao.class));

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Collection<AssessmentGroupedEntities> actualFindGroupedByDefinitionAndOutcomesResult =
        assessmentRatingViewService.findGroupedByDefinitionAndOutcomes(
            EntityKind.ALL, new ArrayList<>());

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findGroupedByDefinitionAndOutcome(isA(Condition.class));
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult instanceof Set);
    assertEquals(1, actualFindGroupedByDefinitionAndOutcomesResult.size());
  }

  /**
   * Test {@link AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}
   */
  @Test
  @DisplayName("Test findGroupedByDefinitionAndOutcomes(EntityKind, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection AssessmentRatingViewService.findGroupedByDefinitionAndOutcomes(EntityKind, List)"
  })
  void testFindGroupedByDefinitionAndOutcomes4() {
    // Arrange
    ImmutableRatingEntityList.Builder builderResult = ImmutableRatingEntityList.builder();
    builderResult.addEntityReferences(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableRatingEntityList immutableRatingEntityList = builderResult.rating("Rating").build();

    HashSet<ImmutableRatingEntityList> immutableRatingEntityListSet = new HashSet<>();
    immutableRatingEntityListSet.add(ImmutableRatingEntityList.builder().rating("Rating").build());
    immutableRatingEntityListSet.add(immutableRatingEntityList);
    Tuple2<Long, Set<ImmutableRatingEntityList>> tuple2 =
        new Tuple2<>(1L, immutableRatingEntityListSet);

    HashSet<Tuple2<Long, Set<ImmutableRatingEntityList>>> tuple2Set = new HashSet<>();
    tuple2Set.add(tuple2);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findGroupedByDefinitionAndOutcome(Mockito.<Condition>any()))
        .thenReturn(tuple2Set);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(assessmentDefinitionSet);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    UserPreferenceService userPreferenceService =
        new UserPreferenceService(mock(UserPreferenceDao.class));

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Collection<AssessmentGroupedEntities> actualFindGroupedByDefinitionAndOutcomesResult =
        assessmentRatingViewService.findGroupedByDefinitionAndOutcomes(
            EntityKind.ALL, new ArrayList<>());

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findGroupedByDefinitionAndOutcome(isA(Condition.class));
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult instanceof Set);
    assertEquals(1, actualFindGroupedByDefinitionAndOutcomesResult.size());
  }

  /**
   * Test {@link AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add builder rating {@code Rating} build.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}
   */
  @Test
  @DisplayName(
      "Test findGroupedByDefinitionAndOutcomes(EntityKind, List); given HashSet() add builder rating 'Rating' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection AssessmentRatingViewService.findGroupedByDefinitionAndOutcomes(EntityKind, List)"
  })
  void testFindGroupedByDefinitionAndOutcomes_givenHashSetAddBuilderRatingRatingBuild() {
    // Arrange
    HashSet<ImmutableRatingEntityList> immutableRatingEntityListSet = new HashSet<>();
    immutableRatingEntityListSet.add(ImmutableRatingEntityList.builder().rating("Rating").build());
    Tuple2<Long, Set<ImmutableRatingEntityList>> tuple2 =
        new Tuple2<>(1L, immutableRatingEntityListSet);

    HashSet<Tuple2<Long, Set<ImmutableRatingEntityList>>> tuple2Set = new HashSet<>();
    tuple2Set.add(tuple2);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findGroupedByDefinitionAndOutcome(Mockito.<Condition>any()))
        .thenReturn(tuple2Set);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(assessmentDefinitionSet);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    UserPreferenceService userPreferenceService =
        new UserPreferenceService(mock(UserPreferenceDao.class));

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Collection<AssessmentGroupedEntities> actualFindGroupedByDefinitionAndOutcomesResult =
        assessmentRatingViewService.findGroupedByDefinitionAndOutcomes(
            EntityKind.ALL, new ArrayList<>());

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findGroupedByDefinitionAndOutcome(isA(Condition.class));
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult instanceof Set);
    assertEquals(1, actualFindGroupedByDefinitionAndOutcomesResult.size());
  }

  /**
   * Test {@link AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}
   */
  @Test
  @DisplayName(
      "Test findGroupedByDefinitionAndOutcomes(EntityKind, List); given one; when ArrayList() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection AssessmentRatingViewService.findGroupedByDefinitionAndOutcomes(EntityKind, List)"
  })
  void testFindGroupedByDefinitionAndOutcomes_givenOne_whenArrayListAddOne() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findGroupedByDefinitionAndOutcome(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(new HashSet<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    UserPreferenceService userPreferenceService =
        new UserPreferenceService(mock(UserPreferenceDao.class));

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    ArrayList<Long> entityIds = new ArrayList<>();
    entityIds.add(1L);

    // Act
    Collection<AssessmentGroupedEntities> actualFindGroupedByDefinitionAndOutcomesResult =
        assessmentRatingViewService.findGroupedByDefinitionAndOutcomes(EntityKind.ALL, entityIds);

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findGroupedByDefinitionAndOutcome(isA(Condition.class));
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult instanceof Set);
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}
   */
  @Test
  @DisplayName(
      "Test findGroupedByDefinitionAndOutcomes(EntityKind, List); given zero; when ArrayList() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection AssessmentRatingViewService.findGroupedByDefinitionAndOutcomes(EntityKind, List)"
  })
  void testFindGroupedByDefinitionAndOutcomes_givenZero_whenArrayListAddZero() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findGroupedByDefinitionAndOutcome(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(new HashSet<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    UserPreferenceService userPreferenceService =
        new UserPreferenceService(mock(UserPreferenceDao.class));

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    ArrayList<Long> entityIds = new ArrayList<>();
    entityIds.add(0L);
    entityIds.add(1L);

    // Act
    Collection<AssessmentGroupedEntities> actualFindGroupedByDefinitionAndOutcomesResult =
        assessmentRatingViewService.findGroupedByDefinitionAndOutcomes(EntityKind.ALL, entityIds);

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findGroupedByDefinitionAndOutcome(isA(Condition.class));
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult instanceof Set);
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}
   */
  @Test
  @DisplayName("Test findGroupedByDefinitionAndOutcomes(EntityKind, List); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection AssessmentRatingViewService.findGroupedByDefinitionAndOutcomes(EntityKind, List)"
  })
  void testFindGroupedByDefinitionAndOutcomes_thenReturnEmpty() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findGroupedByDefinitionAndOutcome(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(assessmentDefinitionSet);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    UserPreferenceService userPreferenceService =
        new UserPreferenceService(mock(UserPreferenceDao.class));

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Collection<AssessmentGroupedEntities> actualFindGroupedByDefinitionAndOutcomesResult =
        assessmentRatingViewService.findGroupedByDefinitionAndOutcomes(
            EntityKind.ALL, new ArrayList<>());

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findGroupedByDefinitionAndOutcome(isA(Condition.class));
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult instanceof Set);
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}
   */
  @Test
  @DisplayName("Test findGroupedByDefinitionAndOutcomes(EntityKind, List); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection AssessmentRatingViewService.findGroupedByDefinitionAndOutcomes(EntityKind, List)"
  })
  void testFindGroupedByDefinitionAndOutcomes_thenReturnSizeIsOne() {
    // Arrange
    HashSet<Tuple2<Long, Set<ImmutableRatingEntityList>>> tuple2Set = new HashSet<>();
    Tuple2<Long, Set<ImmutableRatingEntityList>> tuple2 = new Tuple2<>(1L, new HashSet<>());
    tuple2Set.add(tuple2);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findGroupedByDefinitionAndOutcome(Mockito.<Condition>any()))
        .thenReturn(tuple2Set);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(assessmentDefinitionSet);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    UserPreferenceService userPreferenceService =
        new UserPreferenceService(mock(UserPreferenceDao.class));

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Collection<AssessmentGroupedEntities> actualFindGroupedByDefinitionAndOutcomesResult =
        assessmentRatingViewService.findGroupedByDefinitionAndOutcomes(
            EntityKind.ALL, new ArrayList<>());

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findGroupedByDefinitionAndOutcome(isA(Condition.class));
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult instanceof Set);
    assertEquals(1, actualFindGroupedByDefinitionAndOutcomesResult.size());
  }

  /**
   * Test {@link AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}
   */
  @Test
  @DisplayName("Test findGroupedByDefinitionAndOutcomes(EntityKind, List); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection AssessmentRatingViewService.findGroupedByDefinitionAndOutcomes(EntityKind, List)"
  })
  void testFindGroupedByDefinitionAndOutcomes_thenReturnSizeIsTwo() {
    // Arrange
    HashSet<ImmutableRatingEntityList> immutableRatingEntityListSet = new HashSet<>();
    immutableRatingEntityListSet.add(ImmutableRatingEntityList.builder().rating("Rating").build());
    Tuple2<Long, Set<ImmutableRatingEntityList>> tuple2 =
        new Tuple2<>(1L, immutableRatingEntityListSet);

    HashSet<Tuple2<Long, Set<ImmutableRatingEntityList>>> tuple2Set = new HashSet<>();
    Tuple2<Long, Set<ImmutableRatingEntityList>> tuple22 = new Tuple2<>(1L, new HashSet<>());
    tuple2Set.add(tuple22);
    tuple2Set.add(tuple2);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findGroupedByDefinitionAndOutcome(Mockito.<Condition>any()))
        .thenReturn(tuple2Set);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(assessmentDefinitionSet);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    UserPreferenceService userPreferenceService =
        new UserPreferenceService(mock(UserPreferenceDao.class));

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Collection<AssessmentGroupedEntities> actualFindGroupedByDefinitionAndOutcomesResult =
        assessmentRatingViewService.findGroupedByDefinitionAndOutcomes(
            EntityKind.ALL, new ArrayList<>());

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findGroupedByDefinitionAndOutcome(isA(Condition.class));
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult instanceof Set);
    assertEquals(2, actualFindGroupedByDefinitionAndOutcomesResult.size());
  }

  /**
   * Test {@link AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}
   */
  @Test
  @DisplayName(
      "Test findGroupedByDefinitionAndOutcomes(EntityKind, List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection AssessmentRatingViewService.findGroupedByDefinitionAndOutcomes(EntityKind, List)"
  })
  void testFindGroupedByDefinitionAndOutcomes_whenArrayList_thenReturnEmpty() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findGroupedByDefinitionAndOutcome(Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(new HashSet<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
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
    UserPreferenceService userPreferenceService =
        new UserPreferenceService(mock(UserPreferenceDao.class));

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Collection<AssessmentGroupedEntities> actualFindGroupedByDefinitionAndOutcomesResult =
        assessmentRatingViewService.findGroupedByDefinitionAndOutcomes(
            EntityKind.ALL, new ArrayList<>());

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findGroupedByDefinitionAndOutcome(isA(Condition.class));
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult instanceof Set);
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult.isEmpty());
  }

  /**
   * Test {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findFavouriteAssessmentsForEntityAndUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(EntityReference, String)"
  })
  void testFindFavouriteAssessmentsForEntityAndUser() {
    // Arrange
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

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(assessmentRatingList);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    UserPreferenceService userPreferenceService = new UserPreferenceService(userPreferenceDao);
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

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Set<AssessmentRatingDetail> actualFindFavouriteAssessmentsForEntityAndUserResult =
        assessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    assertTrue(actualFindFavouriteAssessmentsForEntityAndUserResult.isEmpty());
  }

  /**
   * Test {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findFavouriteAssessmentsForEntityAndUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(EntityReference, String)"
  })
  void testFindFavouriteAssessmentsForEntityAndUser2() {
    // Arrange
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

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(assessmentRatingList);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    UserPreferenceService userPreferenceService = new UserPreferenceService(userPreferenceDao);
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

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Set<AssessmentRatingDetail> actualFindFavouriteAssessmentsForEntityAndUserResult =
        assessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    assertTrue(actualFindFavouriteAssessmentsForEntityAndUserResult.isEmpty());
  }

  /**
   * Test {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findFavouriteAssessmentsForEntityAndUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(EntityReference, String)"
  })
  void testFindFavouriteAssessmentsForEntityAndUser3() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(assessmentDefinitionSet);

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    UserPreferenceService userPreferenceService = new UserPreferenceService(userPreferenceDao);
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

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Set<AssessmentRatingDetail> actualFindFavouriteAssessmentsForEntityAndUserResult =
        assessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    assertTrue(actualFindFavouriteAssessmentsForEntityAndUserResult.isEmpty());
  }

  /**
   * Test {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findFavouriteAssessmentsForEntityAndUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(EntityReference, String)"
  })
  void testFindFavouriteAssessmentsForEntityAndUser4() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(new HashSet<>());

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(
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

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(ratingSchemeItemSet);

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    UserPreferenceService userPreferenceService = new UserPreferenceService(userPreferenceDao);
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

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Set<AssessmentRatingDetail> actualFindFavouriteAssessmentsForEntityAndUserResult =
        assessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    assertTrue(actualFindFavouriteAssessmentsForEntityAndUserResult.isEmpty());
  }

  /**
   * Test {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findFavouriteAssessmentsForEntityAndUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(EntityReference, String)"
  })
  void testFindFavouriteAssessmentsForEntityAndUser5() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);
    UserPreferenceService userPreferenceService = new UserPreferenceService(userPreferenceDao);
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

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Set<AssessmentRatingDetail> actualFindFavouriteAssessmentsForEntityAndUserResult =
        assessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    assertTrue(actualFindFavouriteAssessmentsForEntityAndUserResult.isEmpty());
  }

  /**
   * Test {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findFavouriteAssessmentsForEntityAndUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(EntityReference, String)"
  })
  void testFindFavouriteAssessmentsForEntityAndUser6() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<UserPreference> userPreferenceList = new ArrayList<>();
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());
    userPreferenceList.add(ImmutableUserPreference.builder().key("Key").value("42").build());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(userPreferenceList);
    UserPreferenceService userPreferenceService = new UserPreferenceService(userPreferenceDao);
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

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Set<AssessmentRatingDetail> actualFindFavouriteAssessmentsForEntityAndUserResult =
        assessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    assertTrue(actualFindFavouriteAssessmentsForEntityAndUserResult.isEmpty());
  }

  /**
   * Test {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>Then calls {@link EntityReference#kind()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findFavouriteAssessmentsForEntityAndUser(EntityReference, String); given 'ALL'; then calls kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(EntityReference, String)"
  })
  void testFindFavouriteAssessmentsForEntityAndUser_givenAll_thenCallsKind() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    UserPreferenceService userPreferenceService = new UserPreferenceService(userPreferenceDao);
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

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Set<AssessmentRatingDetail> actualFindFavouriteAssessmentsForEntityAndUserResult =
        assessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(ref, "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    verify(ref).kind();
    assertTrue(actualFindFavouriteAssessmentsForEntityAndUserResult.isEmpty());
  }

  /**
   * Test {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then calls {@link UserPreferenceService#getPreferences(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findFavouriteAssessmentsForEntityAndUser(EntityReference, String); then calls getPreferences(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(EntityReference, String)"
  })
  void testFindFavouriteAssessmentsForEntityAndUser_thenCallsGetPreferences() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    UserPreferenceService userPreferenceService = mock(UserPreferenceService.class);
    when(userPreferenceService.getPreferences(Mockito.<String>any())).thenReturn(new ArrayList<>());
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

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Set<AssessmentRatingDetail> actualFindFavouriteAssessmentsForEntityAndUserResult =
        assessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(userPreferenceService).getPreferences("janedoe");
    assertTrue(actualFindFavouriteAssessmentsForEntityAndUserResult.isEmpty());
  }

  /**
   * Test {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then calls {@link UserPreferenceDao#getPreferencesForUser(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findFavouriteAssessmentsForEntityAndUser(EntityReference, String); then calls getPreferencesForUser(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(EntityReference, String)"
  })
  void testFindFavouriteAssessmentsForEntityAndUser_thenCallsGetPreferencesForUser() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(new HashSet<>());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    UserPreferenceDao userPreferenceDao = mock(UserPreferenceDao.class);
    when(userPreferenceDao.getPreferencesForUser(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    UserPreferenceService userPreferenceService = new UserPreferenceService(userPreferenceDao);
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

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Set<AssessmentRatingDetail> actualFindFavouriteAssessmentsForEntityAndUserResult =
        assessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(userPreferenceDao).getPreferencesForUser("janedoe");
    assertTrue(actualFindFavouriteAssessmentsForEntityAndUserResult.isEmpty());
  }

  /**
   * Test {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findFavouriteAssessmentsForEntityAndUser(EntityReference, String); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(EntityReference, String)"
  })
  void testFindFavouriteAssessmentsForEntityAndUser_thenReturnSizeIsOne() {
    // Arrange
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

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(assessmentRatingList);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(assessmentDefinitionSet);

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(
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

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(ratingSchemeItemSet);

    UserPreferenceService userPreferenceService = mock(UserPreferenceService.class);
    when(userPreferenceService.getPreferences(Mockito.<String>any())).thenReturn(new ArrayList<>());
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

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Set<AssessmentRatingDetail> actualFindFavouriteAssessmentsForEntityAndUserResult =
        assessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(userPreferenceService).getPreferences("janedoe");
    assertEquals(1, actualFindFavouriteAssessmentsForEntityAndUserResult.size());
  }

  /**
   * Test {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssessmentRatingViewService#findFavouriteAssessmentsForEntityAndUser(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findFavouriteAssessmentsForEntityAndUser(EntityReference, String); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AssessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(EntityReference, String)"
  })
  void testFindFavouriteAssessmentsForEntityAndUser_thenReturnSizeIsOne2() {
    // Arrange
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

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findForEntity(Mockito.<EntityReference>any()))
        .thenReturn(assessmentRatingList);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    assessmentDefinitionSet.add(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(assessmentDefinitionSet);

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(
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

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(ratingSchemeItemSet);

    UserPreferenceService userPreferenceService = mock(UserPreferenceService.class);
    when(userPreferenceService.getPreferences(Mockito.<String>any())).thenReturn(new ArrayList<>());
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

    AssessmentRatingViewService assessmentRatingViewService =
        new AssessmentRatingViewService(
            assessmentRatingDao,
            assessmentDefinitionDao,
            ratingSchemeDAO,
            changeLogService,
            userPreferenceService);

    // Act
    Set<AssessmentRatingDetail> actualFindFavouriteAssessmentsForEntityAndUserResult =
        assessmentRatingViewService.findFavouriteAssessmentsForEntityAndUser(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findForEntity(isA(EntityReference.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(userPreferenceService).getPreferences("janedoe");
    assertEquals(1, actualFindFavouriteAssessmentsForEntityAndUserResult.size());
  }
}
