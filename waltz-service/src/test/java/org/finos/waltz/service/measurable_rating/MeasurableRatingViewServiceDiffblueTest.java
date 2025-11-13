package org.finos.waltz.service.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.allocation.Allocation;
import org.finos.waltz.model.allocation.ImmutableAllocation;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.model.allocation_scheme.ImmutableAllocationScheme;
import org.finos.waltz.model.application.AssessmentsView;
import org.finos.waltz.model.application.ImmutableAssessmentsView;
import org.finos.waltz.model.application.ImmutableMeasurableRatingsView;
import org.finos.waltz.model.application.MeasurableRatingsView;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable.ImmutableMeasurableHierarchy;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable.MeasurableHierarchy;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategory;
import org.finos.waltz.model.measurable_category.MeasurableCategory;
import org.finos.waltz.model.measurable_rating.AllocationsView;
import org.finos.waltz.model.measurable_rating.DecommissionsView;
import org.finos.waltz.model.measurable_rating.ImmutableAllocationsView;
import org.finos.waltz.model.measurable_rating.ImmutableDecommissionsView;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRating;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingCategoryView;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingView;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.measurable_rating.MeasurableRatingCategoryView;
import org.finos.waltz.model.measurable_rating.MeasurableRatingView;
import org.finos.waltz.model.measurable_rating_planned_decommission.ImmutableMeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_planned_decommission.ImmutableMeasurableRatingPlannedDecommissionInfo;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionInfo;
import org.finos.waltz.model.measurable_rating_replacement.ImmutableMeasurableRatingReplacement;
import org.finos.waltz.model.measurable_rating_replacement.MeasurableRatingReplacement;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.service.allocation.AllocationService;
import org.finos.waltz.service.allocation_schemes.AllocationSchemeService;
import org.finos.waltz.service.assessment_definition.AssessmentDefinitionService;
import org.finos.waltz.service.assessment_rating.AssessmentRatingService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.measurable_category.MeasurableCategoryService;
import org.finos.waltz.service.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionService;
import org.finos.waltz.service.measurable_rating_replacement.MeasurableRatingReplacementService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
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
class MeasurableRatingViewServiceDiffblueTest {
  @Mock private AllocationSchemeService allocationSchemeService;

  @Mock private AllocationService allocationService;

  @Mock private AssessmentDefinitionService assessmentDefinitionService;

  @Mock private AssessmentRatingService assessmentRatingService;

  @Mock private MeasurableCategoryService measurableCategoryService;

  @Mock private MeasurableDao measurableDao;

  @Mock
  private MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService;

  @Mock private MeasurableRatingReplacementService measurableRatingReplacementService;

  @Mock private MeasurableRatingService measurableRatingService;

  @InjectMocks private MeasurableRatingViewService measurableRatingViewService;

  @Mock private MeasurableService measurableService;

  @Mock private RatingSchemeDAO ratingSchemeDAO;

  @Mock private RatingSchemeService ratingSchemeService;

  /**
   * Test {@link MeasurableRatingViewService#getViewById(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  @DisplayName("Test getViewById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingView MeasurableRatingViewService.getViewById(long)"})
  void testGetViewById() {
    // Arrange
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingService.getById(anyLong()))
        .thenReturn(
            descriptionResult
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
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    when(measurableService.getById(anyLong()))
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
    when(measurableCategoryService.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableRatingViewService.getViewById(1L));
    verify(measurableService).getById(1L);
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService).getById(1L);
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewById(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  @DisplayName("Test getViewById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingView MeasurableRatingViewService.getViewById(long)"})
  void testGetViewById2() {
    // Arrange
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingService.getById(anyLong()))
        .thenReturn(
            descriptionResult
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
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    when(measurableService.getById(anyLong()))
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
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());
    when(measurableRatingReplacementService.findByDecommId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(
            Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(allocationSchemeService.findByCategoryId(anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableRatingViewService.getViewById(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(measurableService).getById(1L);
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService).getById(1L);
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(1L);
    verify(measurableRatingReplacementService).findByDecommId(1L);
    verify(ratingSchemeService)
        .findRatingSchemeItemsForEntityAndCategory(isA(EntityReference.class), eq(1L));
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewById(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  @DisplayName("Test getViewById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingView MeasurableRatingViewService.getViewById(long)"})
  void testGetViewById3() {
    // Arrange
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingService.getById(anyLong()))
        .thenReturn(
            descriptionResult
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
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    when(measurableService.getById(anyLong()))
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
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());
    when(measurableRatingReplacementService.findByDecommId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

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
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(
            Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(ratingSchemeItemList);
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(allocationService.findByMeasurableRatingId(anyLong())).thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    MeasurableRatingView actualViewById = measurableRatingViewService.getViewById(1L);

    // Assert
    verify(allocationService).findByMeasurableRatingId(1L);
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(measurableService).getById(1L);
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService).getById(1L);
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(1L);
    verify(measurableRatingReplacementService).findByDecommId(1L);
    verify(ratingSchemeService)
        .findRatingSchemeItemsForEntityAndCategory(isA(EntityReference.class), eq(1L));
    assertTrue(actualViewById.measurable() instanceof ImmutableMeasurable);
    assertTrue(actualViewById.category() instanceof ImmutableMeasurableCategory);
    assertTrue(actualViewById.measurableRating() instanceof ImmutableMeasurableRating);
    assertTrue(actualViewById instanceof ImmutableMeasurableRatingView);
    assertTrue(
        actualViewById.decommission() instanceof ImmutableMeasurableRatingPlannedDecommission);
    assertNull(actualViewById.rating());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewById(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  @DisplayName("Test getViewById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingView MeasurableRatingViewService.getViewById(long)"})
  void testGetViewById4() {
    // Arrange
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingService.getById(anyLong()))
        .thenReturn(
            descriptionResult
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
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    when(measurableService.getById(anyLong()))
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
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());
    when(measurableRatingReplacementService.findByDecommId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

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
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(
            Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(ratingSchemeItemList);
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(allocationService.findByMeasurableRatingId(anyLong())).thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    MeasurableRatingView actualViewById = measurableRatingViewService.getViewById(1L);

    // Assert
    verify(allocationService).findByMeasurableRatingId(1L);
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(measurableService).getById(1L);
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService).getById(1L);
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(1L);
    verify(measurableRatingReplacementService).findByDecommId(1L);
    verify(ratingSchemeService)
        .findRatingSchemeItemsForEntityAndCategory(isA(EntityReference.class), eq(1L));
    assertTrue(actualViewById.measurable() instanceof ImmutableMeasurable);
    assertTrue(actualViewById.category() instanceof ImmutableMeasurableCategory);
    assertTrue(actualViewById.measurableRating() instanceof ImmutableMeasurableRating);
    assertTrue(actualViewById instanceof ImmutableMeasurableRatingView);
    assertTrue(
        actualViewById.decommission() instanceof ImmutableMeasurableRatingPlannedDecommission);
    assertNull(actualViewById.rating());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewById(long)}.
   *
   * <p>Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  @DisplayName("Test getViewById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingView MeasurableRatingViewService.getViewById(long)"})
  void testGetViewById5() {
    // Arrange
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingService.getById(anyLong()))
        .thenReturn(
            descriptionResult
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
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    when(measurableService.getById(anyLong()))
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
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());
    when(measurableRatingReplacementService.findByDecommId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(
            Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(allocationService.findByMeasurableRatingId(anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableRatingViewService.getViewById(1L));
    verify(allocationService).findByMeasurableRatingId(1L);
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(measurableService).getById(1L);
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService).getById(1L);
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(1L);
    verify(measurableRatingReplacementService).findByDecommId(1L);
    verify(ratingSchemeService)
        .findRatingSchemeItemsForEntityAndCategory(isA(EntityReference.class), eq(1L));
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewById(long)}.
   *
   * <ul>
   *   <li>Given {@link MeasurableRatingService} {@link MeasurableRatingService#getById(long)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  @DisplayName(
      "Test getViewById(long); given MeasurableRatingService getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingView MeasurableRatingViewService.getViewById(long)"})
  void testGetViewById_givenMeasurableRatingServiceGetByIdThrowIllegalArgumentException() {
    // Arrange
    when(measurableRatingService.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableRatingViewService.getViewById(1L));
    verify(measurableRatingService).getById(1L);
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewById(long)}.
   *
   * <ul>
   *   <li>Given {@link MeasurableService} {@link MeasurableService#getById(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  @DisplayName(
      "Test getViewById(long); given MeasurableService getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingView MeasurableRatingViewService.getViewById(long)"})
  void testGetViewById_givenMeasurableServiceGetByIdThrowIllegalArgumentException() {
    // Arrange
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingService.getById(anyLong()))
        .thenReturn(
            descriptionResult
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
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    when(measurableService.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> measurableRatingViewService.getViewById(1L));
    verify(measurableService).getById(1L);
    verify(measurableRatingService).getById(1L);
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewById(long)}.
   *
   * <ul>
   *   <li>Then measurable return {@link ImmutableMeasurable}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  @DisplayName("Test getViewById(long); then measurable return ImmutableMeasurable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingView MeasurableRatingViewService.getViewById(long)"})
  void testGetViewById_thenMeasurableReturnImmutableMeasurable() {
    // Arrange
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingService.getById(anyLong()))
        .thenReturn(
            descriptionResult
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
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    when(measurableService.getById(anyLong()))
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
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());
    when(measurableRatingReplacementService.findByDecommId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(
            Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(allocationService.findByMeasurableRatingId(anyLong())).thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    MeasurableRatingView actualViewById = measurableRatingViewService.getViewById(1L);

    // Assert
    verify(allocationService).findByMeasurableRatingId(1L);
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(measurableService).getById(1L);
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService).getById(1L);
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(1L);
    verify(measurableRatingReplacementService).findByDecommId(1L);
    verify(ratingSchemeService)
        .findRatingSchemeItemsForEntityAndCategory(isA(EntityReference.class), eq(1L));
    assertTrue(actualViewById.measurable() instanceof ImmutableMeasurable);
    assertTrue(actualViewById.category() instanceof ImmutableMeasurableCategory);
    assertTrue(actualViewById.measurableRating() instanceof ImmutableMeasurableRating);
    assertTrue(actualViewById instanceof ImmutableMeasurableRatingView);
    assertTrue(
        actualViewById.decommission() instanceof ImmutableMeasurableRatingPlannedDecommission);
    assertNull(actualViewById.rating());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewById(long)}.
   *
   * <ul>
   *   <li>Then return allocationSchemes is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  @DisplayName("Test getViewById(long); then return allocationSchemes is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingView MeasurableRatingViewService.getViewById(long)"})
  void testGetViewById_thenReturnAllocationSchemesIsArrayList() {
    // Arrange
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingService.getById(anyLong()))
        .thenReturn(
            descriptionResult
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
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    when(measurableService.getById(anyLong()))
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
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());
    when(measurableRatingReplacementService.findByDecommId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(
            Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(allocationService.findByMeasurableRatingId(anyLong())).thenReturn(new HashSet<>());

    ArrayList<AllocationScheme> allocationSchemeList = new ArrayList<>();
    allocationSchemeList.add(
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(allocationSchemeList);

    // Act
    MeasurableRatingView actualViewById = measurableRatingViewService.getViewById(1L);

    // Assert
    verify(allocationService).findByMeasurableRatingId(1L);
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(measurableService).getById(1L);
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService).getById(1L);
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(1L);
    verify(measurableRatingReplacementService).findByDecommId(1L);
    verify(ratingSchemeService)
        .findRatingSchemeItemsForEntityAndCategory(isA(EntityReference.class), eq(1L));
    assertTrue(actualViewById instanceof ImmutableMeasurableRatingView);
    assertEquals(allocationSchemeList, actualViewById.allocationSchemes());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewById(long)}.
   *
   * <ul>
   *   <li>Then return allocationSchemes is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  @DisplayName("Test getViewById(long); then return allocationSchemes is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingView MeasurableRatingViewService.getViewById(long)"})
  void testGetViewById_thenReturnAllocationSchemesIsArrayList2() {
    // Arrange
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingService.getById(anyLong()))
        .thenReturn(
            descriptionResult
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
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    when(measurableService.getById(anyLong()))
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
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());
    when(measurableRatingReplacementService.findByDecommId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(
            Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(allocationService.findByMeasurableRatingId(anyLong())).thenReturn(new HashSet<>());

    ArrayList<AllocationScheme> allocationSchemeList = new ArrayList<>();
    allocationSchemeList.add(
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());
    allocationSchemeList.add(
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(allocationSchemeList);

    // Act
    MeasurableRatingView actualViewById = measurableRatingViewService.getViewById(1L);

    // Assert
    verify(allocationService).findByMeasurableRatingId(1L);
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(measurableService).getById(1L);
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService).getById(1L);
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(1L);
    verify(measurableRatingReplacementService).findByDecommId(1L);
    verify(ratingSchemeService)
        .findRatingSchemeItemsForEntityAndCategory(isA(EntityReference.class), eq(1L));
    assertTrue(actualViewById instanceof ImmutableMeasurableRatingView);
    assertEquals(allocationSchemeList, actualViewById.allocationSchemes());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewById(long)}.
   *
   * <ul>
   *   <li>Then return allocations size is one.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  @DisplayName("Test getViewById(long); then return allocations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingView MeasurableRatingViewService.getViewById(long)"})
  void testGetViewById_thenReturnAllocationsSizeIsOne() {
    // Arrange
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingService.getById(anyLong()))
        .thenReturn(
            descriptionResult
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
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    when(measurableService.getById(anyLong()))
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
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());
    when(measurableRatingReplacementService.findByDecommId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(
            Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

    HashSet<Allocation> allocationSet = new HashSet<>();
    allocationSet.add(
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());
    when(allocationService.findByMeasurableRatingId(anyLong())).thenReturn(allocationSet);
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    MeasurableRatingView actualViewById = measurableRatingViewService.getViewById(1L);

    // Assert
    verify(allocationService).findByMeasurableRatingId(1L);
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(measurableService).getById(1L);
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService).getById(1L);
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(1L);
    verify(measurableRatingReplacementService).findByDecommId(1L);
    verify(ratingSchemeService)
        .findRatingSchemeItemsForEntityAndCategory(isA(EntityReference.class), eq(1L));
    assertTrue(actualViewById instanceof ImmutableMeasurableRatingView);
    assertEquals(1, actualViewById.allocations().size());
    assertTrue(actualViewById.allocationSchemes().isEmpty());
    assertTrue(actualViewById.replacements().isEmpty());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewById(long)}.
   *
   * <ul>
   *   <li>Then return replacements size is one.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  @DisplayName("Test getViewById(long); then return replacements size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingView MeasurableRatingViewService.getViewById(long)"})
  void testGetViewById_thenReturnReplacementsSizeIsOne() {
    // Arrange
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    when(measurableRatingService.getById(anyLong()))
        .thenReturn(
            descriptionResult
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
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());
    when(measurableService.getById(anyLong()))
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
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenReturn(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
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
            .lastUpdatedBy("2020-03-01");
    measurableRatingReplacementSet.add(
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
    when(measurableRatingReplacementService.findByDecommId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(
            Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(allocationService.findByMeasurableRatingId(anyLong())).thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    MeasurableRatingView actualViewById = measurableRatingViewService.getViewById(1L);

    // Assert
    verify(allocationService).findByMeasurableRatingId(1L);
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(measurableService).getById(1L);
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService).getById(1L);
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(1L);
    verify(measurableRatingReplacementService).findByDecommId(1L);
    verify(ratingSchemeService)
        .findRatingSchemeItemsForEntityAndCategory(isA(EntityReference.class), eq(1L));
    assertTrue(actualViewById instanceof ImmutableMeasurableRatingView);
    assertEquals(1, actualViewById.replacements().size());
    assertTrue(actualViewById.allocationSchemes().isEmpty());
    assertTrue(actualViewById.allocations().isEmpty());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(
        actualViewForCategoryAndSelector.measurableRatings()
            instanceof ImmutableMeasurableRatingsView);
    assertTrue(
        actualViewForCategoryAndSelector.decommissions() instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector2() {
    // Arrange
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatingList.add(
        descriptionResult
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
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(measurableRatingList);
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    MeasurableRatingsView measurableRatingsResult =
        actualViewForCategoryAndSelector.measurableRatings();
    assertTrue(measurableRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertTrue(
        actualViewForCategoryAndSelector.decommissions() instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, measurableRatingsResult.measurableRatings().size());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector3() {
    // Arrange
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatingList.add(
        descriptionResult
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
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());

    ImmutableMeasurableRating.Builder descriptionResult2 =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatingList.add(
        descriptionResult2
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
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(measurableRatingList);
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    MeasurableRatingsView measurableRatingsResult =
        actualViewForCategoryAndSelector.measurableRatings();
    assertTrue(measurableRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertTrue(
        actualViewForCategoryAndSelector.decommissions() instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, measurableRatingsResult.measurableRatings().size());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector4() {
    // Arrange
    HashSet<MeasurableRating> measurableRatingSet = new HashSet<>();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatingSet.add(
        descriptionResult
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
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableRatingSet);
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(
        actualViewForCategoryAndSelector.measurableRatings()
            instanceof ImmutableMeasurableRatingsView);
    MeasurableRatingsView primaryRatingsResult = actualViewForCategoryAndSelector.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertTrue(
        actualViewForCategoryAndSelector.decommissions() instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, primaryRatingsResult.measurableRatings().size());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector5() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(
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
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(measurableList);
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    MeasurableRatingsView measurableRatingsResult =
        actualViewForCategoryAndSelector.measurableRatings();
    assertTrue(measurableRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertTrue(
        actualViewForCategoryAndSelector.decommissions() instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, measurableRatingsResult.measurables().size());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector6() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(
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
    measurableList.add(
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
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(measurableList);
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    MeasurableRatingsView measurableRatingsResult =
        actualViewForCategoryAndSelector.measurableRatings();
    assertTrue(measurableRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertTrue(
        actualViewForCategoryAndSelector.decommissions() instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, measurableRatingsResult.measurables().size());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector7() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());

    HashSet<MeasurableHierarchy> measurableHierarchySet = new HashSet<>();
    measurableHierarchySet.add(ImmutableMeasurableHierarchy.builder().measurableId(1L).build());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(measurableHierarchySet);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    MeasurableRatingsView measurableRatingsResult =
        actualViewForCategoryAndSelector.measurableRatings();
    assertTrue(measurableRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertTrue(
        actualViewForCategoryAndSelector.decommissions() instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, measurableRatingsResult.measurableHierarchy().size());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector8() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<MeasurableRatingPlannedDecommission> measurableRatingPlannedDecommissionList =
        new ArrayList<>();
    measurableRatingPlannedDecommissionList.add(
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(measurableRatingPlannedDecommissionList);
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(
        actualViewForCategoryAndSelector.measurableRatings()
            instanceof ImmutableMeasurableRatingsView);
    DecommissionsView decommissionsResult = actualViewForCategoryAndSelector.decommissions();
    assertTrue(decommissionsResult instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, decommissionsResult.plannedDecommissions().size());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector9() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<MeasurableRatingPlannedDecommission> measurableRatingPlannedDecommissionList =
        new ArrayList<>();
    measurableRatingPlannedDecommissionList.add(
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build());
    measurableRatingPlannedDecommissionList.add(
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(measurableRatingPlannedDecommissionList);
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(
        actualViewForCategoryAndSelector.measurableRatings()
            instanceof ImmutableMeasurableRatingsView);
    DecommissionsView decommissionsResult = actualViewForCategoryAndSelector.decommissions();
    assertTrue(decommissionsResult instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, decommissionsResult.plannedDecommissions().size());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector10() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<MeasurableRatingPlannedDecommissionInfo> measurableRatingPlannedDecommissionInfoList =
        new ArrayList<>();

    ImmutableMeasurableRatingPlannedDecommissionInfo.Builder builderResult =
        ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    ImmutableMeasurableRatingPlannedDecommissionInfo.Builder decommissionResult =
        builderResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatingPlannedDecommissionInfoList.add(
        decommissionResult
            .measurableRating(
                descriptionResult
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
                    .measurableId(1L)
                    .provenance("Provenance")
                    .rating('A')
                    .ratingId(1L)
                    .build())
            .build());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(measurableRatingPlannedDecommissionInfoList);
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(
        actualViewForCategoryAndSelector.measurableRatings()
            instanceof ImmutableMeasurableRatingsView);
    DecommissionsView decommissionsResult = actualViewForCategoryAndSelector.decommissions();
    assertTrue(decommissionsResult instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, decommissionsResult.replacingDecommissions().size());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector11() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<MeasurableRatingPlannedDecommissionInfo> measurableRatingPlannedDecommissionInfoList =
        new ArrayList<>();

    ImmutableMeasurableRatingPlannedDecommissionInfo.Builder builderResult =
        ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    ImmutableMeasurableRatingPlannedDecommissionInfo.Builder decommissionResult =
        builderResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatingPlannedDecommissionInfoList.add(
        decommissionResult
            .measurableRating(
                descriptionResult
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
                    .measurableId(1L)
                    .provenance("Provenance")
                    .rating('A')
                    .ratingId(1L)
                    .build())
            .build());

    ImmutableMeasurableRatingPlannedDecommissionInfo.Builder builderResult2 =
        ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    ImmutableMeasurableRatingPlannedDecommissionInfo.Builder decommissionResult2 =
        builderResult2.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableMeasurableRating.Builder descriptionResult2 =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatingPlannedDecommissionInfoList.add(
        decommissionResult2
            .measurableRating(
                descriptionResult2
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
                    .measurableId(1L)
                    .provenance("Provenance")
                    .rating('A')
                    .ratingId(1L)
                    .build())
            .build());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(measurableRatingPlannedDecommissionInfoList);
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(
        actualViewForCategoryAndSelector.measurableRatings()
            instanceof ImmutableMeasurableRatingsView);
    DecommissionsView decommissionsResult = actualViewForCategoryAndSelector.decommissions();
    assertTrue(decommissionsResult instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, decommissionsResult.replacingDecommissions().size());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector12() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());

    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
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
            .lastUpdatedBy("2020-03-01");
    measurableRatingReplacementSet.add(
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(measurableRatingReplacementSet);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(
        actualViewForCategoryAndSelector.measurableRatings()
            instanceof ImmutableMeasurableRatingsView);
    DecommissionsView decommissionsResult = actualViewForCategoryAndSelector.decommissions();
    assertTrue(decommissionsResult instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, decommissionsResult.plannedReplacements().size());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector13() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());

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
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(ratingSchemeItemSet);
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    AssessmentsView primaryAssessmentsResult =
        actualViewForCategoryAndSelector.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    Map<Long, RatingSchemeItem> ratingSchemeItemsByIdResult =
        primaryAssessmentsResult.ratingSchemeItemsById();
    assertEquals(1, ratingSchemeItemsByIdResult.size());
    RatingSchemeItem getResult = ratingSchemeItemsByIdResult.get(1L);
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", getResult.color());
    assertEquals("Name", getResult.name());
    assertEquals("Rating Group", getResult.ratingGroup());
    assertEquals("Rating", getResult.rating());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(0, getResult.position());
    assertEquals(1, primaryAssessmentsResult.ratingSchemeItems().size());
    assertEquals(1L, getResult.ratingSchemeId());
    assertFalse(getResult.isRestricted());
    assertFalse(getResult.requiresComment());
    assertTrue(getResult.userSelectable());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector14() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());

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
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(ratingSchemeItemSet);
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    MeasurableRatingsView measurableRatingsResult =
        actualViewForCategoryAndSelector.measurableRatings();
    assertTrue(measurableRatingsResult instanceof ImmutableMeasurableRatingsView);
    MeasurableRatingsView primaryRatingsResult = actualViewForCategoryAndSelector.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, measurableRatingsResult.ratingSchemeItems().size());
    assertEquals(1, primaryRatingsResult.ratingSchemeItems().size());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector15() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

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
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(assessmentRatingList);
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(
        actualViewForCategoryAndSelector.measurableRatings()
            instanceof ImmutableMeasurableRatingsView);
    assertTrue(
        actualViewForCategoryAndSelector.decommissions() instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector16() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());

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
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(assessmentRatingList);
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(
        actualViewForCategoryAndSelector.measurableRatings()
            instanceof ImmutableMeasurableRatingsView);
    assertTrue(
        actualViewForCategoryAndSelector.decommissions() instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector17() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();

    ImmutableAssessmentDefinition.Builder provenanceResult =
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
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(assessmentDefinitionSet);
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    AssessmentsView primaryAssessmentsResult =
        actualViewForCategoryAndSelector.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    assertTrue(
        actualViewForCategoryAndSelector.measurableRatings()
            instanceof ImmutableMeasurableRatingsView);
    assertTrue(
        actualViewForCategoryAndSelector.decommissions() instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, primaryAssessmentsResult.assessmentDefinitions().size());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector18() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());

    ArrayList<AllocationScheme> allocationSchemeList = new ArrayList<>();
    allocationSchemeList.add(
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(allocationSchemeList);

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(
        actualViewForCategoryAndSelector.primaryAssessments() instanceof ImmutableAssessmentsView);
    assertTrue(
        actualViewForCategoryAndSelector.primaryRatings()
            instanceof ImmutableMeasurableRatingsView);
    assertTrue(actualViewForCategoryAndSelector.allocations() instanceof ImmutableAllocationsView);
    assertTrue(
        actualViewForCategoryAndSelector.decommissions() instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName("Test getViewForCategoryAndSelector(IdSelectionOptions, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector19() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());

    ArrayList<AllocationScheme> allocationSchemeList = new ArrayList<>();
    allocationSchemeList.add(
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());
    allocationSchemeList.add(
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(allocationSchemeList);

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(
        actualViewForCategoryAndSelector.primaryAssessments() instanceof ImmutableAssessmentsView);
    assertTrue(
        actualViewForCategoryAndSelector.primaryRatings()
            instanceof ImmutableMeasurableRatingsView);
    assertTrue(actualViewForCategoryAndSelector.allocations() instanceof ImmutableAllocationsView);
    assertTrue(
        actualViewForCategoryAndSelector.decommissions() instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <ul>
   *   <li>Given of {@code ALL}.
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName(
      "Test getViewForCategoryAndSelector(IdSelectionOptions, long); given of 'ALL'; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector_givenOfAll_thenCallsEntityLifecycleStatuses() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(idSelectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).filters();
    verify(idSelectionOptions).joiningEntityKind();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(
        actualViewForCategoryAndSelector.measurableRatings()
            instanceof ImmutableMeasurableRatingsView);
    assertTrue(
        actualViewForCategoryAndSelector.decommissions() instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <ul>
   *   <li>Given of {@code ALL}.
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName(
      "Test getViewForCategoryAndSelector(IdSelectionOptions, long); given of 'ALL'; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector_givenOfAll_thenCallsEntityLifecycleStatuses2() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(idSelectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(idSelectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).filters();
    verify(idSelectionOptions).joiningEntityKind();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(
        actualViewForCategoryAndSelector.measurableRatings()
            instanceof ImmutableMeasurableRatingsView);
    assertTrue(
        actualViewForCategoryAndSelector.decommissions() instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <ul>
   *   <li>Then return allocations allocations size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName(
      "Test getViewForCategoryAndSelector(IdSelectionOptions, long); then return allocations allocations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector_thenReturnAllocationsAllocationsSizeIsOne() {
    // Arrange
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(
            Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService.findForReplacingSubjectIdSelectorAndCategory(
            Mockito.<GenericSelector>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(measurableRatingReplacementService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    HashSet<Allocation> allocationSet = new HashSet<>();
    allocationSet.add(
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());
    when(allocationService.findForCategoryAndMeasurableRatingIdSelector(
            Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(allocationSet);
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    MeasurableRatingCategoryView actualViewForCategoryAndSelector =
        measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(allocationService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(1L);
    verify(assessmentDefinitionService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(assessmentRatingService).findByEntityKind(EntityKind.MEASURABLE_RATING);
    verify(measurableService).findByCategoryId(1L);
    verify(measurableService).findHierarchyForCategory(1L);
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(1L);
    verify(measurableRatingService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService)
        .findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(
        actualViewForCategoryAndSelector.measurableRatings()
            instanceof ImmutableMeasurableRatingsView);
    AllocationsView allocationsResult = actualViewForCategoryAndSelector.allocations();
    assertTrue(allocationsResult instanceof ImmutableAllocationsView);
    assertTrue(
        actualViewForCategoryAndSelector.decommissions() instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, allocationsResult.allocations().size());
  }

  /**
   * Test {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions,
   * long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  @DisplayName(
      "Test getViewForCategoryAndSelector(IdSelectionOptions, long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingCategoryView MeasurableRatingViewService.getViewForCategoryAndSelector(IdSelectionOptions, long)"
  })
  void testGetViewForCategoryAndSelector_thenThrowIllegalArgumentException() {
    // Arrange
    when(measurableCategoryService.getById(anyLong())).thenThrow(new IllegalArgumentException());

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    assertThrows(
        IllegalArgumentException.class,
        () -> measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L));
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    verify(measurableCategoryService).getById(1L);
  }

  /**
   * Test {@link MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)} with {@code
   * idSelectionOptions}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getPrimaryRatingsView(IdSelectionOptions) with 'idSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingsView MeasurableRatingViewService.getPrimaryRatingsView(IdSelectionOptions)"
  })
  void testGetPrimaryRatingsViewWithIdSelectionOptions() {
    // Arrange
    when(measurableRatingService.findPrimaryRatingsForGenericSelector(
            Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    MeasurableRatingsView actualPrimaryRatingsView =
        measurableRatingViewService.getPrimaryRatingsView(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    verify(measurableCategoryService).findAll();
    verify(measurableRatingService)
        .findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    assertTrue(actualPrimaryRatingsView instanceof ImmutableMeasurableRatingsView);
    Set<MeasurableCategory> measurableCategoriesResult =
        actualPrimaryRatingsView.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.measurableRatings());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.measurables());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.ratingSchemeItems());
  }

  /**
   * Test {@link MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)} with {@code
   * idSelectionOptions}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getPrimaryRatingsView(IdSelectionOptions) with 'idSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingsView MeasurableRatingViewService.getPrimaryRatingsView(IdSelectionOptions)"
  })
  void testGetPrimaryRatingsViewWithIdSelectionOptions2() {
    // Arrange
    when(measurableCategoryService.findAll()).thenThrow(new IllegalArgumentException());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableRatingViewService.getPrimaryRatingsView(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(measurableCategoryService).findAll();
  }

  /**
   * Test {@link MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)} with {@code
   * idSelectionOptions}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getPrimaryRatingsView(IdSelectionOptions) with 'idSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingsView MeasurableRatingViewService.getPrimaryRatingsView(IdSelectionOptions)"
  })
  void testGetPrimaryRatingsViewWithIdSelectionOptions3() {
    // Arrange
    HashSet<MeasurableRating> measurableRatingSet = new HashSet<>();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    measurableRatingSet.add(
        descriptionResult
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
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    when(measurableRatingService.findPrimaryRatingsForGenericSelector(
            Mockito.<GenericSelector>any()))
        .thenReturn(measurableRatingSet);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    MeasurableRatingsView actualPrimaryRatingsView =
        measurableRatingViewService.getPrimaryRatingsView(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    verify(measurableCategoryService).findAll();
    verify(measurableRatingService)
        .findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    assertTrue(actualPrimaryRatingsView instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, actualPrimaryRatingsView.measurableRatings().size());
  }

  /**
   * Test {@link MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)} with {@code
   * idSelectionOptions}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getPrimaryRatingsView(IdSelectionOptions) with 'idSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingsView MeasurableRatingViewService.getPrimaryRatingsView(IdSelectionOptions)"
  })
  void testGetPrimaryRatingsViewWithIdSelectionOptions4() {
    // Arrange
    when(measurableRatingService.findPrimaryRatingsForGenericSelector(
            Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(ratingSchemeItemSet);
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    MeasurableRatingsView actualPrimaryRatingsView =
        measurableRatingViewService.getPrimaryRatingsView(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    verify(measurableCategoryService).findAll();
    verify(measurableRatingService)
        .findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    assertTrue(actualPrimaryRatingsView instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, actualPrimaryRatingsView.ratingSchemeItems().size());
  }

  /**
   * Test {@link MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)} with {@code
   * idSelectionOptions}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getPrimaryRatingsView(IdSelectionOptions) with 'idSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingsView MeasurableRatingViewService.getPrimaryRatingsView(IdSelectionOptions)"
  })
  void testGetPrimaryRatingsViewWithIdSelectionOptions5() {
    // Arrange
    when(measurableRatingService.findPrimaryRatingsForGenericSelector(
            Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<MeasurableCategory> measurableCategoryList = new ArrayList<>();
    measurableCategoryList.add(
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
    when(measurableCategoryService.findAll()).thenReturn(measurableCategoryList);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    MeasurableRatingsView actualPrimaryRatingsView =
        measurableRatingViewService.getPrimaryRatingsView(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    verify(measurableCategoryService).findAll();
    verify(measurableRatingService)
        .findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    assertTrue(actualPrimaryRatingsView instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, actualPrimaryRatingsView.measurableCategories().size());
    Set<MeasurableHierarchy> measurableHierarchyResult =
        actualPrimaryRatingsView.measurableHierarchy();
    assertTrue(measurableHierarchyResult.isEmpty());
    assertSame(measurableHierarchyResult, actualPrimaryRatingsView.measurableRatings());
    assertSame(measurableHierarchyResult, actualPrimaryRatingsView.measurables());
    assertSame(measurableHierarchyResult, actualPrimaryRatingsView.ratingSchemeItems());
  }

  /**
   * Test {@link MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)} with {@code
   * idSelectionOptions}.
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getPrimaryRatingsView(IdSelectionOptions) with 'idSelectionOptions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingsView MeasurableRatingViewService.getPrimaryRatingsView(IdSelectionOptions)"
  })
  void testGetPrimaryRatingsViewWithIdSelectionOptions6() {
    // Arrange
    when(measurableRatingService.findPrimaryRatingsForGenericSelector(
            Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            measurableRatingViewService.getPrimaryRatingsView(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(measurableCategoryService).findAll();
    verify(measurableRatingService)
        .findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
  }

  /**
   * Test {@link MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)} with {@code
   * idSelectionOptions}.
   *
   * <ul>
   *   <li>Then return measurables size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getPrimaryRatingsView(IdSelectionOptions) with 'idSelectionOptions'; then return measurables size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingsView MeasurableRatingViewService.getPrimaryRatingsView(IdSelectionOptions)"
  })
  void testGetPrimaryRatingsViewWithIdSelectionOptions_thenReturnMeasurablesSizeIsOne() {
    // Arrange
    when(measurableRatingService.findPrimaryRatingsForGenericSelector(
            Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(
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
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableList);
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    MeasurableRatingsView actualPrimaryRatingsView =
        measurableRatingViewService.getPrimaryRatingsView(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    verify(measurableCategoryService).findAll();
    verify(measurableRatingService)
        .findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    assertTrue(actualPrimaryRatingsView instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, actualPrimaryRatingsView.measurables().size());
    Set<MeasurableCategory> measurableCategoriesResult =
        actualPrimaryRatingsView.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.measurableRatings());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.ratingSchemeItems());
  }

  /**
   * Test {@link MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)} with {@code
   * idSelectionOptions}.
   *
   * <ul>
   *   <li>Then return measurables size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getPrimaryRatingsView(IdSelectionOptions) with 'idSelectionOptions'; then return measurables size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingsView MeasurableRatingViewService.getPrimaryRatingsView(IdSelectionOptions)"
  })
  void testGetPrimaryRatingsViewWithIdSelectionOptions_thenReturnMeasurablesSizeIsOne2() {
    // Arrange
    when(measurableRatingService.findPrimaryRatingsForGenericSelector(
            Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());

    ArrayList<Measurable> measurableList = new ArrayList<>();
    measurableList.add(
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
    measurableList.add(
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
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableList);
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    MeasurableRatingsView actualPrimaryRatingsView =
        measurableRatingViewService.getPrimaryRatingsView(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    verify(measurableCategoryService).findAll();
    verify(measurableRatingService)
        .findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    assertTrue(actualPrimaryRatingsView instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, actualPrimaryRatingsView.measurables().size());
    Set<MeasurableCategory> measurableCategoriesResult =
        actualPrimaryRatingsView.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.measurableRatings());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.ratingSchemeItems());
  }
}
