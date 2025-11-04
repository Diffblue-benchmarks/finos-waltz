package org.finos.waltz.service.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.allocation.Allocation;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.model.application.AssessmentsView;
import org.finos.waltz.model.application.ImmutableAssessmentsView;
import org.finos.waltz.model.application.ImmutableMeasurableRatingsView;
import org.finos.waltz.model.application.MeasurableRatingsView;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable_category.MeasurableCategory;
import org.finos.waltz.model.measurable_rating.AllocationsView;
import org.finos.waltz.model.measurable_rating.DecommissionsView;
import org.finos.waltz.model.measurable_rating.ImmutableAllocationsView;
import org.finos.waltz.model.measurable_rating.ImmutableDecommissionsView;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingCategoryView;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingView;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.measurable_rating.MeasurableRatingCategoryView;
import org.finos.waltz.model.measurable_rating.MeasurableRatingView;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_replacement.MeasurableRatingReplacement;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.service.allocation.AllocationService;
import org.finos.waltz.service.allocation_schemes.AllocationSchemeService;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.assessment_definition.AssessmentDefinitionService;
import org.finos.waltz.service.assessment_rating.AssessmentRatingService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.measurable_category.MeasurableCategoryService;
import org.finos.waltz.service.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionService;
import org.finos.waltz.service.measurable_rating_replacement.MeasurableRatingReplacementService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableRatingViewServiceDiffblueTest {
  /**
   * Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  void testGetViewById() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getById(anyLong())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new MeasurableRatingViewService(measurableRatingService, mock(MeasurableService.class),
            mock(MeasurableDao.class), mock(MeasurableRatingPlannedDecommissionService.class),
            mock(MeasurableRatingReplacementService.class), mock(RatingSchemeService.class),
            mock(RatingSchemeDAO.class), mock(MeasurableCategoryService.class), mock(AssessmentRatingService.class),
            mock(AssessmentDefinitionService.class), mock(AllocationService.class), mock(AllocationSchemeService.class),
            mock(ApplicationService.class))).getViewById(1L));
    verify(measurableRatingService).getById(eq(1L));
  }

  /**
   * Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  void testGetViewById2() {
    // Arrange
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.measurableId()).thenReturn(1L);
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getById(anyLong())).thenReturn(measurableRating);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.getById(anyLong())).thenReturn(null);

    // Act
    MeasurableRatingView actualViewById = (new MeasurableRatingViewService(measurableRatingService, measurableService,
        mock(MeasurableDao.class), mock(MeasurableRatingPlannedDecommissionService.class),
        mock(MeasurableRatingReplacementService.class), mock(RatingSchemeService.class), mock(RatingSchemeDAO.class),
        mock(MeasurableCategoryService.class), mock(AssessmentRatingService.class),
        mock(AssessmentDefinitionService.class), mock(AllocationService.class), mock(AllocationSchemeService.class),
        mock(ApplicationService.class))).getViewById(1L);

    // Assert
    verify(measurableRating).measurableId();
    verify(measurableService).getById(eq(1L));
    verify(measurableRatingService).getById(eq(1L));
    assertTrue(actualViewById instanceof ImmutableMeasurableRatingView);
    assertNull(actualViewById.measurable());
    assertNull(actualViewById.category());
    assertNull(actualViewById.decommission());
    assertNull(actualViewById.rating());
    assertTrue(actualViewById.allocationSchemes().isEmpty());
    Set<Allocation> allocationsResult = actualViewById.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertSame(allocationsResult, actualViewById.replacements());
  }

  /**
   * Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  void testGetViewById3() {
    // Arrange
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.measurableId()).thenReturn(1L);
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getById(anyLong())).thenReturn(measurableRating);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.getById(anyLong())).thenThrow(new IllegalArgumentException("measurableRating"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new MeasurableRatingViewService(measurableRatingService, measurableService, mock(MeasurableDao.class),
            mock(MeasurableRatingPlannedDecommissionService.class), mock(MeasurableRatingReplacementService.class),
            mock(RatingSchemeService.class), mock(RatingSchemeDAO.class), mock(MeasurableCategoryService.class),
            mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), mock(AllocationService.class),
            mock(AllocationSchemeService.class), mock(ApplicationService.class))).getViewById(1L));
    verify(measurableRating).measurableId();
    verify(measurableService).getById(eq(1L));
    verify(measurableRatingService).getById(eq(1L));
  }

  /**
   * Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  void testGetViewById4() {
    // Arrange
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.rating()).thenReturn('A');
    when(measurableRating.entityReference()).thenReturn(null);
    when(measurableRating.measurableId()).thenReturn(1L);
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getById(anyLong())).thenReturn(measurableRating);
    Measurable measurable = mock(Measurable.class);
    when(measurable.categoryId()).thenReturn(1L);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.getById(anyLong())).thenReturn(measurable);
    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService = mock(
        MeasurableRatingPlannedDecommissionService.class);
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any())).thenReturn(null);
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.getById(anyLong())).thenReturn(null);
    AllocationService allocationService = mock(AllocationService.class);
    when(allocationService.findByMeasurableRatingId(anyLong())).thenReturn(new HashSet<>());
    AllocationSchemeService allocationSchemeService = mock(AllocationSchemeService.class);
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    MeasurableRatingView actualViewById = (new MeasurableRatingViewService(measurableRatingService, measurableService,
        mock(MeasurableDao.class), measurableRatingPlannedDecommissionService,
        mock(MeasurableRatingReplacementService.class), ratingSchemeService, mock(RatingSchemeDAO.class),
        measurableCategoryService, mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class),
        allocationService, allocationSchemeService, mock(ApplicationService.class))).getViewById(1L);

    // Assert
    verify(measurable, atLeast(1)).categoryId();
    verify(measurableRating).entityReference();
    verify(measurableRating).measurableId();
    verify(measurableRating).rating();
    verify(allocationService).findByMeasurableRatingId(eq(1L));
    verify(allocationSchemeService).findByCategoryId(eq(1L));
    verify(measurableService).getById(eq(1L));
    verify(measurableCategoryService).getById(eq(1L));
    verify(measurableRatingService).getById(eq(1L));
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(eq(1L));
    verify(ratingSchemeService).findRatingSchemeItemsForEntityAndCategory(isNull(), eq(1L));
    assertTrue(actualViewById instanceof ImmutableMeasurableRatingView);
    assertNull(actualViewById.category());
    assertNull(actualViewById.decommission());
    assertNull(actualViewById.rating());
    assertTrue(actualViewById.allocationSchemes().isEmpty());
    Set<Allocation> allocationsResult = actualViewById.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertSame(allocationsResult, actualViewById.replacements());
  }

  /**
   * Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  void testGetViewById5() {
    // Arrange
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.rating()).thenReturn('A');
    when(measurableRating.entityReference()).thenReturn(null);
    when(measurableRating.measurableId()).thenReturn(1L);
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getById(anyLong())).thenReturn(measurableRating);
    Measurable measurable = mock(Measurable.class);
    when(measurable.categoryId()).thenReturn(1L);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.getById(anyLong())).thenReturn(measurable);
    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService = mock(
        MeasurableRatingPlannedDecommissionService.class);
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any())).thenReturn(null);
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.getById(anyLong())).thenReturn(null);
    AllocationSchemeService allocationSchemeService = mock(AllocationSchemeService.class);
    when(allocationSchemeService.findByCategoryId(anyLong()))
        .thenThrow(new IllegalArgumentException("xs cannot be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new MeasurableRatingViewService(measurableRatingService, measurableService, mock(MeasurableDao.class),
            measurableRatingPlannedDecommissionService, mock(MeasurableRatingReplacementService.class),
            ratingSchemeService, mock(RatingSchemeDAO.class), measurableCategoryService,
            mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), mock(AllocationService.class),
            allocationSchemeService, mock(ApplicationService.class))).getViewById(1L));
    verify(measurable, atLeast(1)).categoryId();
    verify(measurableRating).entityReference();
    verify(measurableRating).measurableId();
    verify(measurableRating).rating();
    verify(allocationSchemeService).findByCategoryId(eq(1L));
    verify(measurableService).getById(eq(1L));
    verify(measurableCategoryService).getById(eq(1L));
    verify(measurableRatingService).getById(eq(1L));
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(eq(1L));
    verify(ratingSchemeService).findRatingSchemeItemsForEntityAndCategory(isNull(), eq(1L));
  }

  /**
   * Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  void testGetViewById6() {
    // Arrange
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.rating()).thenReturn('A');
    when(measurableRating.entityReference()).thenReturn(null);
    when(measurableRating.measurableId()).thenReturn(1L);
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getById(anyLong())).thenReturn(measurableRating);
    Measurable measurable = mock(Measurable.class);
    when(measurable.categoryId()).thenReturn(1L);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.getById(anyLong())).thenReturn(measurable);
    MeasurableRatingPlannedDecommission measurableRatingPlannedDecommission = mock(
        MeasurableRatingPlannedDecommission.class);
    when(measurableRatingPlannedDecommission.id()).thenReturn(1L);
    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService = mock(
        MeasurableRatingPlannedDecommissionService.class);
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenReturn(measurableRatingPlannedDecommission);
    MeasurableRatingReplacementService measurableRatingReplacementService = mock(
        MeasurableRatingReplacementService.class);
    when(measurableRatingReplacementService.findByDecommId(Mockito.<Long>any())).thenReturn(new HashSet<>());
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.getById(anyLong())).thenReturn(null);
    AllocationService allocationService = mock(AllocationService.class);
    when(allocationService.findByMeasurableRatingId(anyLong())).thenReturn(new HashSet<>());
    AllocationSchemeService allocationSchemeService = mock(AllocationSchemeService.class);
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    MeasurableRatingView actualViewById = (new MeasurableRatingViewService(measurableRatingService, measurableService,
        mock(MeasurableDao.class), measurableRatingPlannedDecommissionService, measurableRatingReplacementService,
        ratingSchemeService, mock(RatingSchemeDAO.class), measurableCategoryService,
        mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), allocationService,
        allocationSchemeService, mock(ApplicationService.class))).getViewById(1L);

    // Assert
    verify(measurable, atLeast(1)).categoryId();
    verify(measurableRating).entityReference();
    verify(measurableRating).measurableId();
    verify(measurableRating).rating();
    verify(measurableRatingPlannedDecommission).id();
    verify(allocationService).findByMeasurableRatingId(eq(1L));
    verify(allocationSchemeService).findByCategoryId(eq(1L));
    verify(measurableService).getById(eq(1L));
    verify(measurableCategoryService).getById(eq(1L));
    verify(measurableRatingService).getById(eq(1L));
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(eq(1L));
    verify(measurableRatingReplacementService).findByDecommId(eq(1L));
    verify(ratingSchemeService).findRatingSchemeItemsForEntityAndCategory(isNull(), eq(1L));
    assertTrue(actualViewById instanceof ImmutableMeasurableRatingView);
    assertNull(actualViewById.category());
    assertNull(actualViewById.rating());
    assertTrue(actualViewById.allocationSchemes().isEmpty());
    Set<Allocation> allocationsResult = actualViewById.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertSame(allocationsResult, actualViewById.replacements());
  }

  /**
   * Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  void testGetViewById7() {
    // Arrange
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.rating()).thenReturn('A');
    when(measurableRating.entityReference()).thenReturn(null);
    when(measurableRating.measurableId()).thenReturn(1L);
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getById(anyLong())).thenReturn(measurableRating);
    Measurable measurable = mock(Measurable.class);
    when(measurable.categoryId()).thenReturn(1L);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.getById(anyLong())).thenReturn(measurable);
    MeasurableRatingPlannedDecommission measurableRatingPlannedDecommission = mock(
        MeasurableRatingPlannedDecommission.class);
    when(measurableRatingPlannedDecommission.id()).thenReturn(1L);
    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService = mock(
        MeasurableRatingPlannedDecommissionService.class);
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenReturn(measurableRatingPlannedDecommission);
    MeasurableRatingReplacementService measurableRatingReplacementService = mock(
        MeasurableRatingReplacementService.class);
    when(measurableRatingReplacementService.findByDecommId(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException("xs cannot be null"));
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.getById(anyLong())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new MeasurableRatingViewService(measurableRatingService, measurableService, mock(MeasurableDao.class),
            measurableRatingPlannedDecommissionService, measurableRatingReplacementService, ratingSchemeService,
            mock(RatingSchemeDAO.class), measurableCategoryService, mock(AssessmentRatingService.class),
            mock(AssessmentDefinitionService.class), mock(AllocationService.class), mock(AllocationSchemeService.class),
            mock(ApplicationService.class))).getViewById(1L));
    verify(measurable, atLeast(1)).categoryId();
    verify(measurableRating).entityReference();
    verify(measurableRating).measurableId();
    verify(measurableRating).rating();
    verify(measurableRatingPlannedDecommission).id();
    verify(measurableService).getById(eq(1L));
    verify(measurableCategoryService).getById(eq(1L));
    verify(measurableRatingService).getById(eq(1L));
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(eq(1L));
    verify(measurableRatingReplacementService).findByDecommId(eq(1L));
    verify(ratingSchemeService).findRatingSchemeItemsForEntityAndCategory(isNull(), eq(1L));
  }

  /**
   * Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  void testGetViewById8() {
    // Arrange
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.rating()).thenReturn('A');
    when(measurableRating.entityReference()).thenReturn(null);
    when(measurableRating.measurableId()).thenReturn(1L);
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getById(anyLong())).thenReturn(measurableRating);
    Measurable measurable = mock(Measurable.class);
    when(measurable.categoryId()).thenReturn(1L);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.getById(anyLong())).thenReturn(measurable);
    MeasurableRatingPlannedDecommission measurableRatingPlannedDecommission = mock(
        MeasurableRatingPlannedDecommission.class);
    when(measurableRatingPlannedDecommission.id()).thenReturn(1L);
    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService = mock(
        MeasurableRatingPlannedDecommissionService.class);
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenReturn(measurableRatingPlannedDecommission);

    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    measurableRatingReplacementSet.add(mock(MeasurableRatingReplacement.class));
    MeasurableRatingReplacementService measurableRatingReplacementService = mock(
        MeasurableRatingReplacementService.class);
    when(measurableRatingReplacementService.findByDecommId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.getById(anyLong())).thenReturn(null);
    AllocationService allocationService = mock(AllocationService.class);
    when(allocationService.findByMeasurableRatingId(anyLong())).thenReturn(new HashSet<>());
    AllocationSchemeService allocationSchemeService = mock(AllocationSchemeService.class);
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    MeasurableRatingView actualViewById = (new MeasurableRatingViewService(measurableRatingService, measurableService,
        mock(MeasurableDao.class), measurableRatingPlannedDecommissionService, measurableRatingReplacementService,
        ratingSchemeService, mock(RatingSchemeDAO.class), measurableCategoryService,
        mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), allocationService,
        allocationSchemeService, mock(ApplicationService.class))).getViewById(1L);

    // Assert
    verify(measurable, atLeast(1)).categoryId();
    verify(measurableRating).entityReference();
    verify(measurableRating).measurableId();
    verify(measurableRating).rating();
    verify(measurableRatingPlannedDecommission).id();
    verify(allocationService).findByMeasurableRatingId(eq(1L));
    verify(allocationSchemeService).findByCategoryId(eq(1L));
    verify(measurableService).getById(eq(1L));
    verify(measurableCategoryService).getById(eq(1L));
    verify(measurableRatingService).getById(eq(1L));
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(eq(1L));
    verify(measurableRatingReplacementService).findByDecommId(eq(1L));
    verify(ratingSchemeService).findRatingSchemeItemsForEntityAndCategory(isNull(), eq(1L));
    assertTrue(actualViewById instanceof ImmutableMeasurableRatingView);
    assertNull(actualViewById.category());
    assertNull(actualViewById.rating());
    assertEquals(1, actualViewById.replacements().size());
    assertTrue(actualViewById.allocationSchemes().isEmpty());
    assertTrue(actualViewById.allocations().isEmpty());
  }

  /**
   * Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  void testGetViewById9() {
    // Arrange
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.rating()).thenReturn('A');
    when(measurableRating.entityReference()).thenReturn(null);
    when(measurableRating.measurableId()).thenReturn(1L);
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getById(anyLong())).thenReturn(measurableRating);
    Measurable measurable = mock(Measurable.class);
    when(measurable.categoryId()).thenReturn(1L);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.getById(anyLong())).thenReturn(measurable);
    MeasurableRatingPlannedDecommission measurableRatingPlannedDecommission = mock(
        MeasurableRatingPlannedDecommission.class);
    when(measurableRatingPlannedDecommission.id()).thenReturn(1L);
    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService = mock(
        MeasurableRatingPlannedDecommissionService.class);
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenReturn(measurableRatingPlannedDecommission);

    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    measurableRatingReplacementSet.add(mock(MeasurableRatingReplacement.class));
    measurableRatingReplacementSet.add(mock(MeasurableRatingReplacement.class));
    MeasurableRatingReplacementService measurableRatingReplacementService = mock(
        MeasurableRatingReplacementService.class);
    when(measurableRatingReplacementService.findByDecommId(Mockito.<Long>any()))
        .thenReturn(measurableRatingReplacementSet);
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(new ArrayList<>());
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.getById(anyLong())).thenReturn(null);
    AllocationService allocationService = mock(AllocationService.class);
    when(allocationService.findByMeasurableRatingId(anyLong())).thenReturn(new HashSet<>());
    AllocationSchemeService allocationSchemeService = mock(AllocationSchemeService.class);
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    MeasurableRatingView actualViewById = (new MeasurableRatingViewService(measurableRatingService, measurableService,
        mock(MeasurableDao.class), measurableRatingPlannedDecommissionService, measurableRatingReplacementService,
        ratingSchemeService, mock(RatingSchemeDAO.class), measurableCategoryService,
        mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), allocationService,
        allocationSchemeService, mock(ApplicationService.class))).getViewById(1L);

    // Assert
    verify(measurable, atLeast(1)).categoryId();
    verify(measurableRating).entityReference();
    verify(measurableRating).measurableId();
    verify(measurableRating).rating();
    verify(measurableRatingPlannedDecommission).id();
    verify(allocationService).findByMeasurableRatingId(eq(1L));
    verify(allocationSchemeService).findByCategoryId(eq(1L));
    verify(measurableService).getById(eq(1L));
    verify(measurableCategoryService).getById(eq(1L));
    verify(measurableRatingService).getById(eq(1L));
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(eq(1L));
    verify(measurableRatingReplacementService).findByDecommId(eq(1L));
    verify(ratingSchemeService).findRatingSchemeItemsForEntityAndCategory(isNull(), eq(1L));
    assertTrue(actualViewById instanceof ImmutableMeasurableRatingView);
    assertNull(actualViewById.category());
    assertNull(actualViewById.rating());
    assertTrue(actualViewById.allocationSchemes().isEmpty());
    assertTrue(actualViewById.allocations().isEmpty());
    assertEquals(measurableRatingReplacementSet, actualViewById.replacements());
  }

  /**
   * Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  void testGetViewById10() {
    // Arrange
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.rating()).thenReturn('A');
    when(measurableRating.entityReference()).thenReturn(null);
    when(measurableRating.measurableId()).thenReturn(1L);
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getById(anyLong())).thenReturn(measurableRating);
    Measurable measurable = mock(Measurable.class);
    when(measurable.categoryId()).thenReturn(1L);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.getById(anyLong())).thenReturn(measurable);
    MeasurableRatingPlannedDecommission measurableRatingPlannedDecommission = mock(
        MeasurableRatingPlannedDecommission.class);
    when(measurableRatingPlannedDecommission.id()).thenReturn(1L);
    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService = mock(
        MeasurableRatingPlannedDecommissionService.class);
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenReturn(measurableRatingPlannedDecommission);
    MeasurableRatingReplacementService measurableRatingReplacementService = mock(
        MeasurableRatingReplacementService.class);
    when(measurableRatingReplacementService.findByDecommId(Mockito.<Long>any())).thenReturn(new HashSet<>());
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    when(ratingSchemeItem.rating()).thenReturn("Rating");

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(ratingSchemeItem);
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(ratingSchemeItemList);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.getById(anyLong())).thenReturn(null);
    AllocationService allocationService = mock(AllocationService.class);
    when(allocationService.findByMeasurableRatingId(anyLong())).thenReturn(new HashSet<>());
    AllocationSchemeService allocationSchemeService = mock(AllocationSchemeService.class);
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    MeasurableRatingView actualViewById = (new MeasurableRatingViewService(measurableRatingService, measurableService,
        mock(MeasurableDao.class), measurableRatingPlannedDecommissionService, measurableRatingReplacementService,
        ratingSchemeService, mock(RatingSchemeDAO.class), measurableCategoryService,
        mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), allocationService,
        allocationSchemeService, mock(ApplicationService.class))).getViewById(1L);

    // Assert
    verify(measurable, atLeast(1)).categoryId();
    verify(measurableRating).entityReference();
    verify(measurableRating).measurableId();
    verify(measurableRating).rating();
    verify(measurableRatingPlannedDecommission).id();
    verify(ratingSchemeItem).rating();
    verify(allocationService).findByMeasurableRatingId(eq(1L));
    verify(allocationSchemeService).findByCategoryId(eq(1L));
    verify(measurableService).getById(eq(1L));
    verify(measurableCategoryService).getById(eq(1L));
    verify(measurableRatingService).getById(eq(1L));
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(eq(1L));
    verify(measurableRatingReplacementService).findByDecommId(eq(1L));
    verify(ratingSchemeService).findRatingSchemeItemsForEntityAndCategory(isNull(), eq(1L));
    assertTrue(actualViewById instanceof ImmutableMeasurableRatingView);
    assertNull(actualViewById.category());
    assertNull(actualViewById.rating());
    assertTrue(actualViewById.allocationSchemes().isEmpty());
    Set<Allocation> allocationsResult = actualViewById.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertSame(allocationsResult, actualViewById.replacements());
  }

  /**
   * Method under test: {@link MeasurableRatingViewService#getViewById(long)}
   */
  @Test
  void testGetViewById11() {
    // Arrange
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.rating()).thenReturn('A');
    when(measurableRating.entityReference()).thenReturn(null);
    when(measurableRating.measurableId()).thenReturn(1L);
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.getById(anyLong())).thenReturn(measurableRating);
    Measurable measurable = mock(Measurable.class);
    when(measurable.categoryId()).thenReturn(1L);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.getById(anyLong())).thenReturn(measurable);
    MeasurableRatingPlannedDecommission measurableRatingPlannedDecommission = mock(
        MeasurableRatingPlannedDecommission.class);
    when(measurableRatingPlannedDecommission.id()).thenReturn(1L);
    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService = mock(
        MeasurableRatingPlannedDecommissionService.class);
    when(measurableRatingPlannedDecommissionService.getByMeasurableRatingId(Mockito.<Long>any()))
        .thenReturn(measurableRatingPlannedDecommission);
    MeasurableRatingReplacementService measurableRatingReplacementService = mock(
        MeasurableRatingReplacementService.class);
    when(measurableRatingReplacementService.findByDecommId(Mockito.<Long>any())).thenReturn(new HashSet<>());
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    when(ratingSchemeItem.rating()).thenReturn("Rating");
    RatingSchemeItem ratingSchemeItem2 = mock(RatingSchemeItem.class);
    when(ratingSchemeItem2.rating()).thenReturn("Rating");

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(ratingSchemeItem2);
    ratingSchemeItemList.add(ratingSchemeItem);
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    when(ratingSchemeService.findRatingSchemeItemsForEntityAndCategory(Mockito.<EntityReference>any(), anyLong()))
        .thenReturn(ratingSchemeItemList);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.getById(anyLong())).thenReturn(null);
    AllocationService allocationService = mock(AllocationService.class);
    when(allocationService.findByMeasurableRatingId(anyLong())).thenReturn(new HashSet<>());
    AllocationSchemeService allocationSchemeService = mock(AllocationSchemeService.class);
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    MeasurableRatingView actualViewById = (new MeasurableRatingViewService(measurableRatingService, measurableService,
        mock(MeasurableDao.class), measurableRatingPlannedDecommissionService, measurableRatingReplacementService,
        ratingSchemeService, mock(RatingSchemeDAO.class), measurableCategoryService,
        mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), allocationService,
        allocationSchemeService, mock(ApplicationService.class))).getViewById(1L);

    // Assert
    verify(measurable, atLeast(1)).categoryId();
    verify(measurableRating).entityReference();
    verify(measurableRating).measurableId();
    verify(measurableRating).rating();
    verify(measurableRatingPlannedDecommission).id();
    verify(ratingSchemeItem2).rating();
    verify(ratingSchemeItem).rating();
    verify(allocationService).findByMeasurableRatingId(eq(1L));
    verify(allocationSchemeService).findByCategoryId(eq(1L));
    verify(measurableService).getById(eq(1L));
    verify(measurableCategoryService).getById(eq(1L));
    verify(measurableRatingService).getById(eq(1L));
    verify(measurableRatingPlannedDecommissionService).getByMeasurableRatingId(eq(1L));
    verify(measurableRatingReplacementService).findByDecommId(eq(1L));
    verify(ratingSchemeService).findRatingSchemeItemsForEntityAndCategory(isNull(), eq(1L));
    assertTrue(actualViewById instanceof ImmutableMeasurableRatingView);
    assertNull(actualViewById.category());
    assertNull(actualViewById.rating());
    assertTrue(actualViewById.allocationSchemes().isEmpty());
    Set<Allocation> allocationsResult = actualViewById.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertSame(allocationsResult, actualViewById.replacements());
  }

  /**
   * Method under test:
   * {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  void testGetViewForCategoryAndSelector() {
    // Arrange
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.getById(anyLong())).thenReturn(null);
    MeasurableRatingViewService measurableRatingViewService = new MeasurableRatingViewService(
        mock(MeasurableRatingService.class), mock(MeasurableService.class), mock(MeasurableDao.class),
        mock(MeasurableRatingPlannedDecommissionService.class), mock(MeasurableRatingReplacementService.class),
        mock(RatingSchemeService.class), mock(RatingSchemeDAO.class), measurableCategoryService,
        mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class), mock(AllocationService.class),
        mock(AllocationSchemeService.class), mock(ApplicationService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    verify(measurableCategoryService).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  void testGetViewForCategoryAndSelector2() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(),
        anyLong())).thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new ArrayList<>());
    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService = mock(
        MeasurableRatingPlannedDecommissionService.class);
    when(measurableRatingPlannedDecommissionService
        .findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService
        .findForReplacingSubjectIdSelectorAndCategory(Mockito.<GenericSelector>any(), anyLong()))
            .thenReturn(new ArrayList<>());
    MeasurableRatingReplacementService measurableRatingReplacementService = mock(
        MeasurableRatingReplacementService.class);
    when(measurableRatingReplacementService
        .findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(new HashSet<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    when(measurableCategory.ratingSchemeId()).thenReturn(1L);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong())).thenReturn(measurableCategory);
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(new ArrayList<>());
    AssessmentDefinitionService assessmentDefinitionService = mock(AssessmentDefinitionService.class);
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(new HashSet<>());
    AllocationService allocationService = mock(AllocationService.class);
    when(
        allocationService.findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(new HashSet<>());
    AllocationSchemeService allocationSchemeService = mock(AllocationSchemeService.class);
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());
    MeasurableRatingViewService measurableRatingViewService = new MeasurableRatingViewService(measurableRatingService,
        measurableService, measurableDao, measurableRatingPlannedDecommissionService,
        measurableRatingReplacementService, mock(RatingSchemeService.class), ratingSchemeDAO, measurableCategoryService,
        assessmentRatingService, assessmentDefinitionService, allocationService, allocationSchemeService,
        mock(ApplicationService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    MeasurableRatingCategoryView actualViewForCategoryAndSelector = measurableRatingViewService
        .getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(measurableCategory).ratingSchemeId();
    verify(allocationService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(eq(1L));
    verify(assessmentDefinitionService).findByEntityKind(eq(EntityKind.MEASURABLE_RATING));
    verify(assessmentRatingService).findByEntityKind(eq(EntityKind.MEASURABLE_RATING));
    verify(measurableService).findByCategoryId(eq(1L));
    verify(measurableService).findHierarchyForCategory(eq(1L));
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(eq(1L));
    verify(measurableRatingService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class),
        eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    AssessmentsView primaryAssessmentsResult = actualViewForCategoryAndSelector.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    MeasurableRatingsView measurableRatingsResult = actualViewForCategoryAndSelector.measurableRatings();
    assertTrue(measurableRatingsResult instanceof ImmutableMeasurableRatingsView);
    MeasurableRatingsView primaryRatingsResult = actualViewForCategoryAndSelector.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    AllocationsView allocationsResult = actualViewForCategoryAndSelector.allocations();
    assertTrue(allocationsResult instanceof ImmutableAllocationsView);
    DecommissionsView decommissionsResult = actualViewForCategoryAndSelector.decommissions();
    assertTrue(decommissionsResult instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, measurableRatingsResult.measurableCategories().size());
    assertTrue(primaryAssessmentsResult.ratingSchemeItemsById().isEmpty());
    Set<AllocationScheme> allocationSchemesResult = allocationsResult.allocationSchemes();
    assertTrue(allocationSchemesResult.isEmpty());
    assertSame(allocationSchemesResult, primaryAssessmentsResult.assessmentDefinitions());
    assertSame(allocationSchemesResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(allocationSchemesResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(allocationSchemesResult, primaryRatingsResult.measurableCategories());
    assertSame(allocationSchemesResult, measurableRatingsResult.measurableHierarchy());
    assertSame(allocationSchemesResult, primaryRatingsResult.measurableHierarchy());
    assertSame(allocationSchemesResult, measurableRatingsResult.measurableRatings());
    assertSame(allocationSchemesResult, primaryRatingsResult.measurableRatings());
    assertSame(allocationSchemesResult, measurableRatingsResult.measurables());
    assertSame(allocationSchemesResult, primaryRatingsResult.measurables());
    assertSame(allocationSchemesResult, measurableRatingsResult.ratingSchemeItems());
    assertSame(allocationSchemesResult, primaryRatingsResult.ratingSchemeItems());
    assertSame(allocationSchemesResult, allocationsResult.allocations());
    assertSame(allocationSchemesResult, decommissionsResult.plannedDecommissions());
    assertSame(allocationSchemesResult, decommissionsResult.plannedReplacements());
    assertSame(allocationSchemesResult, decommissionsResult.replacingDecommissions());
  }

  /**
   * Method under test:
   * {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  void testGetViewForCategoryAndSelector3() {
    // Arrange
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    measurableRatingList.add(mock(MeasurableRating.class));
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(),
        anyLong())).thenReturn(measurableRatingList);
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new ArrayList<>());
    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService = mock(
        MeasurableRatingPlannedDecommissionService.class);
    when(measurableRatingPlannedDecommissionService
        .findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService
        .findForReplacingSubjectIdSelectorAndCategory(Mockito.<GenericSelector>any(), anyLong()))
            .thenReturn(new ArrayList<>());
    MeasurableRatingReplacementService measurableRatingReplacementService = mock(
        MeasurableRatingReplacementService.class);
    when(measurableRatingReplacementService
        .findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(new HashSet<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    when(measurableCategory.ratingSchemeId()).thenReturn(1L);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong())).thenReturn(measurableCategory);
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(new ArrayList<>());
    AssessmentDefinitionService assessmentDefinitionService = mock(AssessmentDefinitionService.class);
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(new HashSet<>());
    AllocationService allocationService = mock(AllocationService.class);
    when(
        allocationService.findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(new HashSet<>());
    AllocationSchemeService allocationSchemeService = mock(AllocationSchemeService.class);
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());
    MeasurableRatingViewService measurableRatingViewService = new MeasurableRatingViewService(measurableRatingService,
        measurableService, measurableDao, measurableRatingPlannedDecommissionService,
        measurableRatingReplacementService, mock(RatingSchemeService.class), ratingSchemeDAO, measurableCategoryService,
        assessmentRatingService, assessmentDefinitionService, allocationService, allocationSchemeService,
        mock(ApplicationService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    MeasurableRatingCategoryView actualViewForCategoryAndSelector = measurableRatingViewService
        .getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(measurableCategory).ratingSchemeId();
    verify(allocationService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(eq(1L));
    verify(assessmentDefinitionService).findByEntityKind(eq(EntityKind.MEASURABLE_RATING));
    verify(assessmentRatingService).findByEntityKind(eq(EntityKind.MEASURABLE_RATING));
    verify(measurableService).findByCategoryId(eq(1L));
    verify(measurableService).findHierarchyForCategory(eq(1L));
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(eq(1L));
    verify(measurableRatingService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class),
        eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    AssessmentsView primaryAssessmentsResult = actualViewForCategoryAndSelector.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    MeasurableRatingsView measurableRatingsResult = actualViewForCategoryAndSelector.measurableRatings();
    assertTrue(measurableRatingsResult instanceof ImmutableMeasurableRatingsView);
    MeasurableRatingsView primaryRatingsResult = actualViewForCategoryAndSelector.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    AllocationsView allocationsResult = actualViewForCategoryAndSelector.allocations();
    assertTrue(allocationsResult instanceof ImmutableAllocationsView);
    DecommissionsView decommissionsResult = actualViewForCategoryAndSelector.decommissions();
    assertTrue(decommissionsResult instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, measurableRatingsResult.measurableCategories().size());
    assertEquals(1, measurableRatingsResult.measurableRatings().size());
    assertTrue(primaryAssessmentsResult.ratingSchemeItemsById().isEmpty());
    Set<AllocationScheme> allocationSchemesResult = allocationsResult.allocationSchemes();
    assertTrue(allocationSchemesResult.isEmpty());
    assertSame(allocationSchemesResult, primaryAssessmentsResult.assessmentDefinitions());
    assertSame(allocationSchemesResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(allocationSchemesResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(allocationSchemesResult, primaryRatingsResult.measurableCategories());
    assertSame(allocationSchemesResult, measurableRatingsResult.measurableHierarchy());
    assertSame(allocationSchemesResult, primaryRatingsResult.measurableHierarchy());
    assertSame(allocationSchemesResult, primaryRatingsResult.measurableRatings());
    assertSame(allocationSchemesResult, measurableRatingsResult.measurables());
    assertSame(allocationSchemesResult, primaryRatingsResult.measurables());
    assertSame(allocationSchemesResult, measurableRatingsResult.ratingSchemeItems());
    assertSame(allocationSchemesResult, primaryRatingsResult.ratingSchemeItems());
    assertSame(allocationSchemesResult, allocationsResult.allocations());
    assertSame(allocationSchemesResult, decommissionsResult.plannedDecommissions());
    assertSame(allocationSchemesResult, decommissionsResult.plannedReplacements());
    assertSame(allocationSchemesResult, decommissionsResult.replacingDecommissions());
  }

  /**
   * Method under test:
   * {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  void testGetViewForCategoryAndSelector4() {
    // Arrange
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    measurableRatingList.add(mock(MeasurableRating.class));
    measurableRatingList.add(mock(MeasurableRating.class));
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(),
        anyLong())).thenReturn(measurableRatingList);
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new ArrayList<>());
    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService = mock(
        MeasurableRatingPlannedDecommissionService.class);
    when(measurableRatingPlannedDecommissionService
        .findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService
        .findForReplacingSubjectIdSelectorAndCategory(Mockito.<GenericSelector>any(), anyLong()))
            .thenReturn(new ArrayList<>());
    MeasurableRatingReplacementService measurableRatingReplacementService = mock(
        MeasurableRatingReplacementService.class);
    when(measurableRatingReplacementService
        .findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(new HashSet<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    when(measurableCategory.ratingSchemeId()).thenReturn(1L);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong())).thenReturn(measurableCategory);
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(new ArrayList<>());
    AssessmentDefinitionService assessmentDefinitionService = mock(AssessmentDefinitionService.class);
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(new HashSet<>());
    AllocationService allocationService = mock(AllocationService.class);
    when(
        allocationService.findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(new HashSet<>());
    AllocationSchemeService allocationSchemeService = mock(AllocationSchemeService.class);
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());
    MeasurableRatingViewService measurableRatingViewService = new MeasurableRatingViewService(measurableRatingService,
        measurableService, measurableDao, measurableRatingPlannedDecommissionService,
        measurableRatingReplacementService, mock(RatingSchemeService.class), ratingSchemeDAO, measurableCategoryService,
        assessmentRatingService, assessmentDefinitionService, allocationService, allocationSchemeService,
        mock(ApplicationService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    MeasurableRatingCategoryView actualViewForCategoryAndSelector = measurableRatingViewService
        .getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(measurableCategory).ratingSchemeId();
    verify(allocationService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(eq(1L));
    verify(assessmentDefinitionService).findByEntityKind(eq(EntityKind.MEASURABLE_RATING));
    verify(assessmentRatingService).findByEntityKind(eq(EntityKind.MEASURABLE_RATING));
    verify(measurableService).findByCategoryId(eq(1L));
    verify(measurableService).findHierarchyForCategory(eq(1L));
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(eq(1L));
    verify(measurableRatingService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class),
        eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    AssessmentsView primaryAssessmentsResult = actualViewForCategoryAndSelector.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    MeasurableRatingsView measurableRatingsResult = actualViewForCategoryAndSelector.measurableRatings();
    assertTrue(measurableRatingsResult instanceof ImmutableMeasurableRatingsView);
    MeasurableRatingsView primaryRatingsResult = actualViewForCategoryAndSelector.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    AllocationsView allocationsResult = actualViewForCategoryAndSelector.allocations();
    assertTrue(allocationsResult instanceof ImmutableAllocationsView);
    DecommissionsView decommissionsResult = actualViewForCategoryAndSelector.decommissions();
    assertTrue(decommissionsResult instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, measurableRatingsResult.measurableCategories().size());
    assertEquals(2, measurableRatingsResult.measurableRatings().size());
    assertTrue(primaryAssessmentsResult.ratingSchemeItemsById().isEmpty());
    Set<AllocationScheme> allocationSchemesResult = allocationsResult.allocationSchemes();
    assertTrue(allocationSchemesResult.isEmpty());
    assertSame(allocationSchemesResult, primaryAssessmentsResult.assessmentDefinitions());
    assertSame(allocationSchemesResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(allocationSchemesResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(allocationSchemesResult, primaryRatingsResult.measurableCategories());
    assertSame(allocationSchemesResult, measurableRatingsResult.measurableHierarchy());
    assertSame(allocationSchemesResult, primaryRatingsResult.measurableHierarchy());
    assertSame(allocationSchemesResult, primaryRatingsResult.measurableRatings());
    assertSame(allocationSchemesResult, measurableRatingsResult.measurables());
    assertSame(allocationSchemesResult, primaryRatingsResult.measurables());
    assertSame(allocationSchemesResult, measurableRatingsResult.ratingSchemeItems());
    assertSame(allocationSchemesResult, primaryRatingsResult.ratingSchemeItems());
    assertSame(allocationSchemesResult, allocationsResult.allocations());
    assertSame(allocationSchemesResult, decommissionsResult.plannedDecommissions());
    assertSame(allocationSchemesResult, decommissionsResult.plannedReplacements());
    assertSame(allocationSchemesResult, decommissionsResult.replacingDecommissions());
  }

  /**
   * Method under test:
   * {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  void testGetViewForCategoryAndSelector5() {
    // Arrange
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.measurableId()).thenReturn(1L);

    HashSet<MeasurableRating> measurableRatingSet = new HashSet<>();
    measurableRatingSet.add(measurableRating);
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(),
        anyLong())).thenReturn(new ArrayList<>());
    when(measurableRatingService.findPrimaryRatingsForMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableRatingSet);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    when(measurableService.findHierarchyForCategory(anyLong())).thenReturn(new HashSet<>());
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new ArrayList<>());
    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService = mock(
        MeasurableRatingPlannedDecommissionService.class);
    when(measurableRatingPlannedDecommissionService
        .findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService
        .findForReplacingSubjectIdSelectorAndCategory(Mockito.<GenericSelector>any(), anyLong()))
            .thenReturn(new ArrayList<>());
    MeasurableRatingReplacementService measurableRatingReplacementService = mock(
        MeasurableRatingReplacementService.class);
    when(measurableRatingReplacementService
        .findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(new HashSet<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    when(measurableCategory.ratingSchemeId()).thenReturn(1L);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryService.getById(anyLong())).thenReturn(measurableCategory);
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(new ArrayList<>());
    AssessmentDefinitionService assessmentDefinitionService = mock(AssessmentDefinitionService.class);
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(new HashSet<>());
    AllocationService allocationService = mock(AllocationService.class);
    when(
        allocationService.findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(new HashSet<>());
    AllocationSchemeService allocationSchemeService = mock(AllocationSchemeService.class);
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());
    MeasurableRatingViewService measurableRatingViewService = new MeasurableRatingViewService(measurableRatingService,
        measurableService, measurableDao, measurableRatingPlannedDecommissionService,
        measurableRatingReplacementService, mock(RatingSchemeService.class), ratingSchemeDAO, measurableCategoryService,
        assessmentRatingService, assessmentDefinitionService, allocationService, allocationSchemeService,
        mock(ApplicationService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    MeasurableRatingCategoryView actualViewForCategoryAndSelector = measurableRatingViewService
        .getViewForCategoryAndSelector(idSelectionOptions, 1L);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(ratingSchemeDAO, atLeast(1)).findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any());
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(measurableCategory).ratingSchemeId();
    verify(measurableRating).measurableId();
    verify(allocationService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(eq(1L));
    verify(assessmentDefinitionService).findByEntityKind(eq(EntityKind.MEASURABLE_RATING));
    verify(assessmentRatingService).findByEntityKind(eq(EntityKind.MEASURABLE_RATING));
    verify(measurableService).findByCategoryId(eq(1L));
    verify(measurableService).findHierarchyForCategory(eq(1L));
    verify(measurableCategoryService).findAll();
    verify(measurableCategoryService).getById(eq(1L));
    verify(measurableRatingService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingService).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    verify(measurableRatingPlannedDecommissionService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class),
        eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    AssessmentsView primaryAssessmentsResult = actualViewForCategoryAndSelector.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    MeasurableRatingsView measurableRatingsResult = actualViewForCategoryAndSelector.measurableRatings();
    assertTrue(measurableRatingsResult instanceof ImmutableMeasurableRatingsView);
    MeasurableRatingsView primaryRatingsResult = actualViewForCategoryAndSelector.primaryRatings();
    assertTrue(primaryRatingsResult instanceof ImmutableMeasurableRatingsView);
    AllocationsView allocationsResult = actualViewForCategoryAndSelector.allocations();
    assertTrue(allocationsResult instanceof ImmutableAllocationsView);
    DecommissionsView decommissionsResult = actualViewForCategoryAndSelector.decommissions();
    assertTrue(decommissionsResult instanceof ImmutableDecommissionsView);
    assertTrue(actualViewForCategoryAndSelector instanceof ImmutableMeasurableRatingCategoryView);
    assertEquals(1, measurableRatingsResult.measurableCategories().size());
    assertEquals(1, primaryRatingsResult.measurableRatings().size());
    assertTrue(primaryAssessmentsResult.ratingSchemeItemsById().isEmpty());
    Set<AllocationScheme> allocationSchemesResult = allocationsResult.allocationSchemes();
    assertTrue(allocationSchemesResult.isEmpty());
    assertSame(allocationSchemesResult, primaryAssessmentsResult.assessmentDefinitions());
    assertSame(allocationSchemesResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(allocationSchemesResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(allocationSchemesResult, primaryRatingsResult.measurableCategories());
    assertSame(allocationSchemesResult, measurableRatingsResult.measurableHierarchy());
    assertSame(allocationSchemesResult, primaryRatingsResult.measurableHierarchy());
    assertSame(allocationSchemesResult, measurableRatingsResult.measurableRatings());
    assertSame(allocationSchemesResult, measurableRatingsResult.measurables());
    assertSame(allocationSchemesResult, primaryRatingsResult.measurables());
    assertSame(allocationSchemesResult, measurableRatingsResult.ratingSchemeItems());
    assertSame(allocationSchemesResult, primaryRatingsResult.ratingSchemeItems());
    assertSame(allocationSchemesResult, allocationsResult.allocations());
    assertSame(allocationSchemesResult, decommissionsResult.plannedDecommissions());
    assertSame(allocationSchemesResult, decommissionsResult.plannedReplacements());
    assertSame(allocationSchemesResult, decommissionsResult.replacingDecommissions());
  }

  /**
   * Method under test:
   * {@link MeasurableRatingViewService#getViewForCategoryAndSelector(IdSelectionOptions, long)}
   */
  @Test
  void testGetViewForCategoryAndSelector6() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(),
        anyLong())).thenReturn(new ArrayList<>());
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.findByCategoryId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    MeasurableRatingPlannedDecommissionService measurableRatingPlannedDecommissionService = mock(
        MeasurableRatingPlannedDecommissionService.class);
    when(measurableRatingPlannedDecommissionService
        .findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(new ArrayList<>());
    when(measurableRatingPlannedDecommissionService
        .findForReplacingSubjectIdSelectorAndCategory(Mockito.<GenericSelector>any(), anyLong()))
            .thenReturn(new ArrayList<>());
    MeasurableRatingReplacementService measurableRatingReplacementService = mock(
        MeasurableRatingReplacementService.class);
    when(measurableRatingReplacementService
        .findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(new HashSet<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    when(measurableCategory.ratingSchemeId()).thenReturn(1L);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.getById(anyLong())).thenReturn(measurableCategory);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating.ratingId()).thenReturn(1L);
    AssessmentRating assessmentRating2 = mock(AssessmentRating.class);
    when(assessmentRating2.assessmentDefinitionId()).thenReturn(1L);
    when(assessmentRating2.ratingId()).thenReturn(1L);
    AssessmentRating assessmentRating3 = mock(AssessmentRating.class);
    when(assessmentRating3.assessmentDefinitionId()).thenThrow(new IllegalArgumentException("options cannot be null"));
    when(assessmentRating3.ratingId()).thenThrow(new IllegalArgumentException("options cannot be null"));

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();
    assessmentRatingList.add(assessmentRating3);
    assessmentRatingList.add(assessmentRating2);
    assessmentRatingList.add(assessmentRating);
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(assessmentRatingList);
    AssessmentDefinitionService assessmentDefinitionService = mock(AssessmentDefinitionService.class);
    when(assessmentDefinitionService.findByEntityKind(Mockito.<EntityKind>any())).thenReturn(new HashSet<>());
    AllocationService allocationService = mock(AllocationService.class);
    when(
        allocationService.findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
            .thenReturn(new HashSet<>());
    AllocationSchemeService allocationSchemeService = mock(AllocationSchemeService.class);
    when(allocationSchemeService.findByCategoryId(anyLong())).thenReturn(new ArrayList<>());
    MeasurableRatingViewService measurableRatingViewService = new MeasurableRatingViewService(measurableRatingService,
        measurableService, mock(MeasurableDao.class), measurableRatingPlannedDecommissionService,
        measurableRatingReplacementService, mock(RatingSchemeService.class), ratingSchemeDAO, measurableCategoryService,
        assessmentRatingService, assessmentDefinitionService, allocationService, allocationSchemeService,
        mock(ApplicationService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> measurableRatingViewService.getViewForCategoryAndSelector(idSelectionOptions, 1L));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(assessmentRating3).assessmentDefinitionId();
    verify(assessmentRating3).ratingId();
    verify(measurableCategory).ratingSchemeId();
    verify(allocationService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(allocationSchemeService).findByCategoryId(eq(1L));
    verify(assessmentDefinitionService).findByEntityKind(eq(EntityKind.MEASURABLE_RATING));
    verify(assessmentRatingService).findByEntityKind(eq(EntityKind.MEASURABLE_RATING));
    verify(measurableService).findByCategoryId(eq(1L));
    verify(measurableCategoryService).getById(eq(1L));
    verify(measurableRatingService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    verify(measurableRatingPlannedDecommissionService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class),
        eq(1L));
    verify(measurableRatingPlannedDecommissionService)
        .findForReplacingSubjectIdSelectorAndCategory(isA(GenericSelector.class), eq(1L));
    verify(measurableRatingReplacementService).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)}
   */
  @Test
  void testGetPrimaryRatingsView() {
    // Arrange
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(new HashSet<>());
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new ArrayList<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    MeasurableRatingViewService measurableRatingViewService = new MeasurableRatingViewService(measurableRatingService,
        mock(MeasurableService.class), measurableDao, mock(MeasurableRatingPlannedDecommissionService.class),
        mock(MeasurableRatingReplacementService.class), mock(RatingSchemeService.class), ratingSchemeDAO,
        measurableCategoryService, mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class),
        mock(AllocationService.class), mock(AllocationSchemeService.class), mock(ApplicationService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    MeasurableRatingsView actualPrimaryRatingsView = measurableRatingViewService
        .getPrimaryRatingsView(idSelectionOptions);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    verify(measurableCategoryService).findAll();
    verify(measurableRatingService).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    assertTrue(actualPrimaryRatingsView instanceof ImmutableMeasurableRatingsView);
    Set<MeasurableCategory> measurableCategoriesResult = actualPrimaryRatingsView.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.measurableRatings());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.measurables());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)}
   */
  @Test
  void testGetPrimaryRatingsView2() {
    // Arrange
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.measurableId()).thenReturn(1L);

    HashSet<MeasurableRating> measurableRatingSet = new HashSet<>();
    measurableRatingSet.add(measurableRating);
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(measurableRatingSet);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new ArrayList<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    MeasurableRatingViewService measurableRatingViewService = new MeasurableRatingViewService(measurableRatingService,
        mock(MeasurableService.class), measurableDao, mock(MeasurableRatingPlannedDecommissionService.class),
        mock(MeasurableRatingReplacementService.class), mock(RatingSchemeService.class), ratingSchemeDAO,
        measurableCategoryService, mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class),
        mock(AllocationService.class), mock(AllocationSchemeService.class), mock(ApplicationService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    MeasurableRatingsView actualPrimaryRatingsView = measurableRatingViewService
        .getPrimaryRatingsView(idSelectionOptions);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    verify(measurableRating).measurableId();
    verify(measurableCategoryService).findAll();
    verify(measurableRatingService).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    assertTrue(actualPrimaryRatingsView instanceof ImmutableMeasurableRatingsView);
    assertEquals(1, actualPrimaryRatingsView.measurableRatings().size());
    Set<MeasurableCategory> measurableCategoriesResult = actualPrimaryRatingsView.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.measurables());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)}
   */
  @Test
  void testGetPrimaryRatingsView3() {
    // Arrange
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating2 = mock(MeasurableRating.class);
    when(measurableRating2.measurableId()).thenReturn(1L);

    HashSet<MeasurableRating> measurableRatingSet = new HashSet<>();
    measurableRatingSet.add(measurableRating2);
    measurableRatingSet.add(measurableRating);
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(measurableRatingSet);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new ArrayList<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    MeasurableRatingViewService measurableRatingViewService = new MeasurableRatingViewService(measurableRatingService,
        mock(MeasurableService.class), measurableDao, mock(MeasurableRatingPlannedDecommissionService.class),
        mock(MeasurableRatingReplacementService.class), mock(RatingSchemeService.class), ratingSchemeDAO,
        measurableCategoryService, mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class),
        mock(AllocationService.class), mock(AllocationSchemeService.class), mock(ApplicationService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    MeasurableRatingsView actualPrimaryRatingsView = measurableRatingViewService
        .getPrimaryRatingsView(idSelectionOptions);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    verify(measurableRating2).measurableId();
    verify(measurableRating).measurableId();
    verify(measurableCategoryService).findAll();
    verify(measurableRatingService).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    assertTrue(actualPrimaryRatingsView instanceof ImmutableMeasurableRatingsView);
    Set<MeasurableCategory> measurableCategoriesResult = actualPrimaryRatingsView.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertEquals(measurableRatingSet, actualPrimaryRatingsView.measurableRatings());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.measurables());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link MeasurableRatingViewService#getPrimaryRatingsView(IdSelectionOptions)}
   */
  @Test
  void testGetPrimaryRatingsView4() {
    // Arrange
    MeasurableRating measurableRating = mock(MeasurableRating.class);
    when(measurableRating.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating2 = mock(MeasurableRating.class);
    when(measurableRating2.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating3 = mock(MeasurableRating.class);
    when(measurableRating3.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating4 = mock(MeasurableRating.class);
    when(measurableRating4.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating5 = mock(MeasurableRating.class);
    when(measurableRating5.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating6 = mock(MeasurableRating.class);
    when(measurableRating6.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating7 = mock(MeasurableRating.class);
    when(measurableRating7.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating8 = mock(MeasurableRating.class);
    when(measurableRating8.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating9 = mock(MeasurableRating.class);
    when(measurableRating9.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating10 = mock(MeasurableRating.class);
    when(measurableRating10.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating11 = mock(MeasurableRating.class);
    when(measurableRating11.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating12 = mock(MeasurableRating.class);
    when(measurableRating12.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating13 = mock(MeasurableRating.class);
    when(measurableRating13.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating14 = mock(MeasurableRating.class);
    when(measurableRating14.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating15 = mock(MeasurableRating.class);
    when(measurableRating15.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating16 = mock(MeasurableRating.class);
    when(measurableRating16.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating17 = mock(MeasurableRating.class);
    when(measurableRating17.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating18 = mock(MeasurableRating.class);
    when(measurableRating18.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating19 = mock(MeasurableRating.class);
    when(measurableRating19.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating20 = mock(MeasurableRating.class);
    when(measurableRating20.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating21 = mock(MeasurableRating.class);
    when(measurableRating21.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating22 = mock(MeasurableRating.class);
    when(measurableRating22.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating23 = mock(MeasurableRating.class);
    when(measurableRating23.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating24 = mock(MeasurableRating.class);
    when(measurableRating24.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating25 = mock(MeasurableRating.class);
    when(measurableRating25.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating26 = mock(MeasurableRating.class);
    when(measurableRating26.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating27 = mock(MeasurableRating.class);
    when(measurableRating27.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating28 = mock(MeasurableRating.class);
    when(measurableRating28.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating29 = mock(MeasurableRating.class);
    when(measurableRating29.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating30 = mock(MeasurableRating.class);
    when(measurableRating30.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating31 = mock(MeasurableRating.class);
    when(measurableRating31.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating32 = mock(MeasurableRating.class);
    when(measurableRating32.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating33 = mock(MeasurableRating.class);
    when(measurableRating33.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating34 = mock(MeasurableRating.class);
    when(measurableRating34.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating35 = mock(MeasurableRating.class);
    when(measurableRating35.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating36 = mock(MeasurableRating.class);
    when(measurableRating36.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating37 = mock(MeasurableRating.class);
    when(measurableRating37.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating38 = mock(MeasurableRating.class);
    when(measurableRating38.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating39 = mock(MeasurableRating.class);
    when(measurableRating39.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating40 = mock(MeasurableRating.class);
    when(measurableRating40.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating41 = mock(MeasurableRating.class);
    when(measurableRating41.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating42 = mock(MeasurableRating.class);
    when(measurableRating42.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating43 = mock(MeasurableRating.class);
    when(measurableRating43.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating44 = mock(MeasurableRating.class);
    when(measurableRating44.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating45 = mock(MeasurableRating.class);
    when(measurableRating45.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating46 = mock(MeasurableRating.class);
    when(measurableRating46.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating47 = mock(MeasurableRating.class);
    when(measurableRating47.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating48 = mock(MeasurableRating.class);
    when(measurableRating48.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating49 = mock(MeasurableRating.class);
    when(measurableRating49.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating50 = mock(MeasurableRating.class);
    when(measurableRating50.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating51 = mock(MeasurableRating.class);
    when(measurableRating51.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating52 = mock(MeasurableRating.class);
    when(measurableRating52.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating53 = mock(MeasurableRating.class);
    when(measurableRating53.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating54 = mock(MeasurableRating.class);
    when(measurableRating54.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating55 = mock(MeasurableRating.class);
    when(measurableRating55.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating56 = mock(MeasurableRating.class);
    when(measurableRating56.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating57 = mock(MeasurableRating.class);
    when(measurableRating57.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating58 = mock(MeasurableRating.class);
    when(measurableRating58.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating59 = mock(MeasurableRating.class);
    when(measurableRating59.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating60 = mock(MeasurableRating.class);
    when(measurableRating60.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating61 = mock(MeasurableRating.class);
    when(measurableRating61.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating62 = mock(MeasurableRating.class);
    when(measurableRating62.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating63 = mock(MeasurableRating.class);
    when(measurableRating63.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating64 = mock(MeasurableRating.class);
    when(measurableRating64.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating65 = mock(MeasurableRating.class);
    when(measurableRating65.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating66 = mock(MeasurableRating.class);
    when(measurableRating66.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating67 = mock(MeasurableRating.class);
    when(measurableRating67.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating68 = mock(MeasurableRating.class);
    when(measurableRating68.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating69 = mock(MeasurableRating.class);
    when(measurableRating69.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating70 = mock(MeasurableRating.class);
    when(measurableRating70.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating71 = mock(MeasurableRating.class);
    when(measurableRating71.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating72 = mock(MeasurableRating.class);
    when(measurableRating72.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating73 = mock(MeasurableRating.class);
    when(measurableRating73.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating74 = mock(MeasurableRating.class);
    when(measurableRating74.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating75 = mock(MeasurableRating.class);
    when(measurableRating75.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating76 = mock(MeasurableRating.class);
    when(measurableRating76.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating77 = mock(MeasurableRating.class);
    when(measurableRating77.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating78 = mock(MeasurableRating.class);
    when(measurableRating78.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating79 = mock(MeasurableRating.class);
    when(measurableRating79.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating80 = mock(MeasurableRating.class);
    when(measurableRating80.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating81 = mock(MeasurableRating.class);
    when(measurableRating81.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating82 = mock(MeasurableRating.class);
    when(measurableRating82.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating83 = mock(MeasurableRating.class);
    when(measurableRating83.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating84 = mock(MeasurableRating.class);
    when(measurableRating84.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating85 = mock(MeasurableRating.class);
    when(measurableRating85.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating86 = mock(MeasurableRating.class);
    when(measurableRating86.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating87 = mock(MeasurableRating.class);
    when(measurableRating87.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating88 = mock(MeasurableRating.class);
    when(measurableRating88.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating89 = mock(MeasurableRating.class);
    when(measurableRating89.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating90 = mock(MeasurableRating.class);
    when(measurableRating90.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating91 = mock(MeasurableRating.class);
    when(measurableRating91.measurableId()).thenReturn(1L);
    MeasurableRating measurableRating92 = mock(MeasurableRating.class);
    when(measurableRating92.measurableId()).thenReturn(-1L);

    HashSet<MeasurableRating> measurableRatingSet = new HashSet<>();
    measurableRatingSet.add(measurableRating92);
    measurableRatingSet.add(measurableRating91);
    measurableRatingSet.add(measurableRating90);
    measurableRatingSet.add(measurableRating89);
    measurableRatingSet.add(measurableRating88);
    measurableRatingSet.add(measurableRating87);
    measurableRatingSet.add(measurableRating86);
    measurableRatingSet.add(measurableRating85);
    measurableRatingSet.add(measurableRating84);
    measurableRatingSet.add(measurableRating83);
    measurableRatingSet.add(measurableRating82);
    measurableRatingSet.add(measurableRating81);
    measurableRatingSet.add(measurableRating80);
    measurableRatingSet.add(measurableRating79);
    measurableRatingSet.add(measurableRating78);
    measurableRatingSet.add(measurableRating77);
    measurableRatingSet.add(measurableRating76);
    measurableRatingSet.add(measurableRating75);
    measurableRatingSet.add(measurableRating74);
    measurableRatingSet.add(measurableRating73);
    measurableRatingSet.add(measurableRating72);
    measurableRatingSet.add(measurableRating71);
    measurableRatingSet.add(measurableRating70);
    measurableRatingSet.add(measurableRating69);
    measurableRatingSet.add(measurableRating68);
    measurableRatingSet.add(measurableRating67);
    measurableRatingSet.add(measurableRating66);
    measurableRatingSet.add(measurableRating65);
    measurableRatingSet.add(measurableRating64);
    measurableRatingSet.add(measurableRating63);
    measurableRatingSet.add(measurableRating62);
    measurableRatingSet.add(measurableRating61);
    measurableRatingSet.add(measurableRating60);
    measurableRatingSet.add(measurableRating59);
    measurableRatingSet.add(measurableRating58);
    measurableRatingSet.add(measurableRating57);
    measurableRatingSet.add(measurableRating56);
    measurableRatingSet.add(measurableRating55);
    measurableRatingSet.add(measurableRating54);
    measurableRatingSet.add(measurableRating53);
    measurableRatingSet.add(measurableRating52);
    measurableRatingSet.add(measurableRating51);
    measurableRatingSet.add(measurableRating50);
    measurableRatingSet.add(measurableRating49);
    measurableRatingSet.add(measurableRating48);
    measurableRatingSet.add(measurableRating47);
    measurableRatingSet.add(measurableRating46);
    measurableRatingSet.add(measurableRating45);
    measurableRatingSet.add(measurableRating44);
    measurableRatingSet.add(measurableRating43);
    measurableRatingSet.add(measurableRating42);
    measurableRatingSet.add(measurableRating41);
    measurableRatingSet.add(measurableRating40);
    measurableRatingSet.add(measurableRating39);
    measurableRatingSet.add(measurableRating38);
    measurableRatingSet.add(measurableRating37);
    measurableRatingSet.add(measurableRating36);
    measurableRatingSet.add(measurableRating35);
    measurableRatingSet.add(measurableRating34);
    measurableRatingSet.add(measurableRating33);
    measurableRatingSet.add(measurableRating32);
    measurableRatingSet.add(measurableRating31);
    measurableRatingSet.add(measurableRating30);
    measurableRatingSet.add(measurableRating29);
    measurableRatingSet.add(measurableRating28);
    measurableRatingSet.add(measurableRating27);
    measurableRatingSet.add(measurableRating26);
    measurableRatingSet.add(measurableRating25);
    measurableRatingSet.add(measurableRating24);
    measurableRatingSet.add(measurableRating23);
    measurableRatingSet.add(measurableRating22);
    measurableRatingSet.add(measurableRating21);
    measurableRatingSet.add(measurableRating20);
    measurableRatingSet.add(measurableRating19);
    measurableRatingSet.add(measurableRating18);
    measurableRatingSet.add(measurableRating17);
    measurableRatingSet.add(measurableRating16);
    measurableRatingSet.add(measurableRating15);
    measurableRatingSet.add(measurableRating14);
    measurableRatingSet.add(measurableRating13);
    measurableRatingSet.add(measurableRating12);
    measurableRatingSet.add(measurableRating11);
    measurableRatingSet.add(measurableRating10);
    measurableRatingSet.add(measurableRating9);
    measurableRatingSet.add(measurableRating8);
    measurableRatingSet.add(measurableRating7);
    measurableRatingSet.add(measurableRating6);
    measurableRatingSet.add(measurableRating5);
    measurableRatingSet.add(measurableRating4);
    measurableRatingSet.add(measurableRating3);
    measurableRatingSet.add(measurableRating2);
    measurableRatingSet.add(measurableRating);
    MeasurableRatingService measurableRatingService = mock(MeasurableRatingService.class);
    when(measurableRatingService.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(measurableRatingSet);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(new ArrayList<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsForSchemeIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    when(measurableCategoryService.findAll()).thenReturn(new ArrayList<>());
    MeasurableRatingViewService measurableRatingViewService = new MeasurableRatingViewService(measurableRatingService,
        mock(MeasurableService.class), measurableDao, mock(MeasurableRatingPlannedDecommissionService.class),
        mock(MeasurableRatingReplacementService.class), mock(RatingSchemeService.class), ratingSchemeDAO,
        measurableCategoryService, mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class),
        mock(AllocationService.class), mock(AllocationSchemeService.class), mock(ApplicationService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    MeasurableRatingsView actualPrimaryRatingsView = measurableRatingViewService
        .getPrimaryRatingsView(idSelectionOptions);

    // Assert
    verify(measurableDao).findByMeasurableIdSelector(isA(Select.class));
    verify(ratingSchemeDAO).findRatingSchemeItemsForSchemeIds(isA(Set.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    verify(measurableRating92).measurableId();
    verify(measurableRating91).measurableId();
    verify(measurableRating90).measurableId();
    verify(measurableRating89).measurableId();
    verify(measurableRating88).measurableId();
    verify(measurableRating87).measurableId();
    verify(measurableRating86).measurableId();
    verify(measurableRating85).measurableId();
    verify(measurableRating84).measurableId();
    verify(measurableRating83).measurableId();
    verify(measurableRating82).measurableId();
    verify(measurableRating81).measurableId();
    verify(measurableRating80).measurableId();
    verify(measurableRating79).measurableId();
    verify(measurableRating78).measurableId();
    verify(measurableRating77).measurableId();
    verify(measurableRating76).measurableId();
    verify(measurableRating75).measurableId();
    verify(measurableRating74).measurableId();
    verify(measurableRating73).measurableId();
    verify(measurableRating72).measurableId();
    verify(measurableRating71).measurableId();
    verify(measurableRating70).measurableId();
    verify(measurableRating69).measurableId();
    verify(measurableRating68).measurableId();
    verify(measurableRating67).measurableId();
    verify(measurableRating66).measurableId();
    verify(measurableRating65).measurableId();
    verify(measurableRating64).measurableId();
    verify(measurableRating63).measurableId();
    verify(measurableRating62).measurableId();
    verify(measurableRating61).measurableId();
    verify(measurableRating60).measurableId();
    verify(measurableRating59).measurableId();
    verify(measurableRating58).measurableId();
    verify(measurableRating57).measurableId();
    verify(measurableRating56).measurableId();
    verify(measurableRating55).measurableId();
    verify(measurableRating54).measurableId();
    verify(measurableRating53).measurableId();
    verify(measurableRating52).measurableId();
    verify(measurableRating51).measurableId();
    verify(measurableRating50).measurableId();
    verify(measurableRating49).measurableId();
    verify(measurableRating48).measurableId();
    verify(measurableRating47).measurableId();
    verify(measurableRating46).measurableId();
    verify(measurableRating45).measurableId();
    verify(measurableRating44).measurableId();
    verify(measurableRating43).measurableId();
    verify(measurableRating42).measurableId();
    verify(measurableRating41).measurableId();
    verify(measurableRating40).measurableId();
    verify(measurableRating39).measurableId();
    verify(measurableRating38).measurableId();
    verify(measurableRating37).measurableId();
    verify(measurableRating36).measurableId();
    verify(measurableRating35).measurableId();
    verify(measurableRating34).measurableId();
    verify(measurableRating33).measurableId();
    verify(measurableRating32).measurableId();
    verify(measurableRating31).measurableId();
    verify(measurableRating30).measurableId();
    verify(measurableRating29).measurableId();
    verify(measurableRating28).measurableId();
    verify(measurableRating27).measurableId();
    verify(measurableRating26).measurableId();
    verify(measurableRating25).measurableId();
    verify(measurableRating24).measurableId();
    verify(measurableRating23).measurableId();
    verify(measurableRating22).measurableId();
    verify(measurableRating21).measurableId();
    verify(measurableRating20).measurableId();
    verify(measurableRating19).measurableId();
    verify(measurableRating18).measurableId();
    verify(measurableRating17).measurableId();
    verify(measurableRating16).measurableId();
    verify(measurableRating15).measurableId();
    verify(measurableRating14).measurableId();
    verify(measurableRating13).measurableId();
    verify(measurableRating12).measurableId();
    verify(measurableRating11).measurableId();
    verify(measurableRating10).measurableId();
    verify(measurableRating9).measurableId();
    verify(measurableRating8).measurableId();
    verify(measurableRating7).measurableId();
    verify(measurableRating6).measurableId();
    verify(measurableRating5).measurableId();
    verify(measurableRating4).measurableId();
    verify(measurableRating3).measurableId();
    verify(measurableRating2).measurableId();
    verify(measurableRating).measurableId();
    verify(measurableCategoryService).findAll();
    verify(measurableRatingService).findPrimaryRatingsForGenericSelector(isA(GenericSelector.class));
    assertTrue(actualPrimaryRatingsView instanceof ImmutableMeasurableRatingsView);
    Set<MeasurableCategory> measurableCategoriesResult = actualPrimaryRatingsView.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertEquals(measurableRatingSet, actualPrimaryRatingsView.measurableRatings());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.measurables());
    assertSame(measurableCategoriesResult, actualPrimaryRatingsView.ratingSchemeItems());
  }
}
