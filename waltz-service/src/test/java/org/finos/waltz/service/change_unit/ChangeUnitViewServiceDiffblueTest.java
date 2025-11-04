package org.finos.waltz.service.change_unit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.change_unit.PhysicalFlowChangeUnitViewItem;
import org.finos.waltz.model.physical_flow.PhysicalFlow;
import org.finos.waltz.service.assessment_rating.AssessmentRatingService;
import org.finos.waltz.service.logical_flow.LogicalFlowService;
import org.finos.waltz.service.physical_flow.PhysicalFlowService;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChangeUnitViewServiceDiffblueTest {
  /**
   * Method under test:
   * {@link ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}
   */
  @Test
  void testFindPhysicalFlowChangeUnitsByChangeSetId() {
    // Arrange
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);
    when(physicalFlowService.findBySelector(Mockito.<IdSelectionOptions>any())).thenReturn(new ArrayList<>());
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    when(logicalFlowService.findAllByFlowIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(new ArrayList<>());
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.findByTargetKindForRelatedSelector(Mockito.<EntityKind>any(),
        Mockito.<IdSelectionOptions>any())).thenReturn(new ArrayList<>());
    PhysicalSpecificationService physicalSpecificationService = mock(PhysicalSpecificationService.class);
    when(physicalSpecificationService.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    ChangeUnitService changeUnitService = mock(ChangeUnitService.class);
    when(changeUnitService.findByChangeSetId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    Set<PhysicalFlowChangeUnitViewItem> actualFindPhysicalFlowChangeUnitsByChangeSetIdResult = (new ChangeUnitViewService(
        physicalFlowService, logicalFlowService, ratingSchemeService, assessmentRatingService,
        physicalSpecificationService, changeUnitService)).findPhysicalFlowChangeUnitsByChangeSetId(1L);

    // Assert
    verify(assessmentRatingService).findByTargetKindForRelatedSelector(eq(EntityKind.CHANGE_UNIT),
        isA(IdSelectionOptions.class));
    verify(changeUnitService).findByChangeSetId(eq(1L));
    verify(logicalFlowService).findAllByFlowIds(isA(Collection.class));
    verify(physicalFlowService).findBySelector(isA(IdSelectionOptions.class));
    verify(physicalSpecificationService).findByIds(isA(Collection.class));
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertTrue(actualFindPhysicalFlowChangeUnitsByChangeSetIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}
   */
  @Test
  void testFindPhysicalFlowChangeUnitsByChangeSetId2() {
    // Arrange
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(physicalFlow.id()).thenReturn(ofResult);
    when(physicalFlow.logicalFlowId()).thenReturn(1L);
    when(physicalFlow.specificationId()).thenReturn(1L);

    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();
    physicalFlowList.add(physicalFlow);
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);
    when(physicalFlowService.findBySelector(Mockito.<IdSelectionOptions>any())).thenReturn(physicalFlowList);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    when(logicalFlowService.findAllByFlowIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(new ArrayList<>());
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.findByTargetKindForRelatedSelector(Mockito.<EntityKind>any(),
        Mockito.<IdSelectionOptions>any())).thenReturn(new ArrayList<>());
    PhysicalSpecificationService physicalSpecificationService = mock(PhysicalSpecificationService.class);
    when(physicalSpecificationService.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    ChangeUnitService changeUnitService = mock(ChangeUnitService.class);
    when(changeUnitService.findByChangeSetId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    Set<PhysicalFlowChangeUnitViewItem> actualFindPhysicalFlowChangeUnitsByChangeSetIdResult = (new ChangeUnitViewService(
        physicalFlowService, logicalFlowService, ratingSchemeService, assessmentRatingService,
        physicalSpecificationService, changeUnitService)).findPhysicalFlowChangeUnitsByChangeSetId(1L);

    // Assert
    verify(physicalFlow).id();
    verify(physicalFlow).logicalFlowId();
    verify(physicalFlow).specificationId();
    verify(assessmentRatingService).findByTargetKindForRelatedSelector(eq(EntityKind.CHANGE_UNIT),
        isA(IdSelectionOptions.class));
    verify(changeUnitService).findByChangeSetId(eq(1L));
    verify(logicalFlowService).findAllByFlowIds(isA(Collection.class));
    verify(physicalFlowService).findBySelector(isA(IdSelectionOptions.class));
    verify(physicalSpecificationService).findByIds(isA(Collection.class));
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertTrue(actualFindPhysicalFlowChangeUnitsByChangeSetIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ChangeUnitViewService#findPhysicalFlowChangeUnitsByChangeSetId(long)}
   */
  @Test
  void testFindPhysicalFlowChangeUnitsByChangeSetId3() {
    // Arrange
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(physicalFlow.id()).thenReturn(ofResult);
    when(physicalFlow.logicalFlowId()).thenReturn(1L);
    when(physicalFlow.specificationId()).thenReturn(1L);
    PhysicalFlow physicalFlow2 = mock(PhysicalFlow.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(physicalFlow2.id()).thenReturn(ofResult2);
    when(physicalFlow2.logicalFlowId()).thenReturn(1L);
    when(physicalFlow2.specificationId()).thenReturn(1L);

    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();
    physicalFlowList.add(physicalFlow2);
    physicalFlowList.add(physicalFlow);
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);
    when(physicalFlowService.findBySelector(Mockito.<IdSelectionOptions>any())).thenReturn(physicalFlowList);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    when(logicalFlowService.findAllByFlowIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    RatingSchemeService ratingSchemeService = mock(RatingSchemeService.class);
    when(ratingSchemeService.findAllRatingSchemeItems()).thenReturn(new ArrayList<>());
    AssessmentRatingService assessmentRatingService = mock(AssessmentRatingService.class);
    when(assessmentRatingService.findByTargetKindForRelatedSelector(Mockito.<EntityKind>any(),
        Mockito.<IdSelectionOptions>any())).thenReturn(new ArrayList<>());
    PhysicalSpecificationService physicalSpecificationService = mock(PhysicalSpecificationService.class);
    when(physicalSpecificationService.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    ChangeUnitService changeUnitService = mock(ChangeUnitService.class);
    when(changeUnitService.findByChangeSetId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    Set<PhysicalFlowChangeUnitViewItem> actualFindPhysicalFlowChangeUnitsByChangeSetIdResult = (new ChangeUnitViewService(
        physicalFlowService, logicalFlowService, ratingSchemeService, assessmentRatingService,
        physicalSpecificationService, changeUnitService)).findPhysicalFlowChangeUnitsByChangeSetId(1L);

    // Assert
    verify(physicalFlow2).id();
    verify(physicalFlow).id();
    verify(physicalFlow2).logicalFlowId();
    verify(physicalFlow).logicalFlowId();
    verify(physicalFlow2).specificationId();
    verify(physicalFlow).specificationId();
    verify(assessmentRatingService).findByTargetKindForRelatedSelector(eq(EntityKind.CHANGE_UNIT),
        isA(IdSelectionOptions.class));
    verify(changeUnitService).findByChangeSetId(eq(1L));
    verify(logicalFlowService).findAllByFlowIds(isA(Collection.class));
    verify(physicalFlowService).findBySelector(isA(IdSelectionOptions.class));
    verify(physicalSpecificationService).findByIds(isA(Collection.class));
    verify(ratingSchemeService).findAllRatingSchemeItems();
    assertTrue(actualFindPhysicalFlowChangeUnitsByChangeSetIdResult.isEmpty());
  }
}
