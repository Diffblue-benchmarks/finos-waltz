package org.finos.waltz.service.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentGroupedEntities;
import org.finos.waltz.model.assessment_rating.ImmutableRatingEntityList;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.user.UserPreferenceService;
import org.jooq.Condition;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AssessmentRatingViewServiceDiffblueTest {
  /**
   * Method under test:
   * {@link AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}
   */
  @Test
  void testFindGroupedByDefinitionAndOutcomes() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findGroupedByDefinitionAndOutcome(Mockito.<Condition>any())).thenReturn(new HashSet<>());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(new HashSet<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingViewService assessmentRatingViewService = new AssessmentRatingViewService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService,
        new UserPreferenceService(mock(UserPreferenceDao.class)));

    // Act
    Collection<AssessmentGroupedEntities> actualFindGroupedByDefinitionAndOutcomesResult = assessmentRatingViewService
        .findGroupedByDefinitionAndOutcomes(EntityKind.ALL, new ArrayList<>());

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findGroupedByDefinitionAndOutcome(isA(Condition.class));
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult instanceof Set);
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}
   */
  @Test
  void testFindGroupedByDefinitionAndOutcomes2() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findGroupedByDefinitionAndOutcome(Mockito.<Condition>any())).thenReturn(new HashSet<>());
    AssessmentDefinition assessmentDefinition = mock(AssessmentDefinition.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(assessmentDefinition.id()).thenReturn(ofResult);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(assessmentDefinition);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(assessmentDefinitionSet);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingViewService assessmentRatingViewService = new AssessmentRatingViewService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService,
        new UserPreferenceService(mock(UserPreferenceDao.class)));

    // Act
    Collection<AssessmentGroupedEntities> actualFindGroupedByDefinitionAndOutcomesResult = assessmentRatingViewService
        .findGroupedByDefinitionAndOutcomes(EntityKind.ALL, new ArrayList<>());

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findGroupedByDefinitionAndOutcome(isA(Condition.class));
    verify(assessmentDefinition).id();
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult instanceof Set);
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}
   */
  @Test
  void testFindGroupedByDefinitionAndOutcomes3() {
    // Arrange
    HashSet<Tuple2<Long, Set<ImmutableRatingEntityList>>> tuple2Set = new HashSet<>();
    tuple2Set.add(new Tuple2<>(1L, new HashSet<>()));
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findGroupedByDefinitionAndOutcome(Mockito.<Condition>any())).thenReturn(tuple2Set);
    AssessmentDefinition assessmentDefinition = mock(AssessmentDefinition.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(assessmentDefinition.id()).thenReturn(ofResult);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(assessmentDefinition);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(assessmentDefinitionSet);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingViewService assessmentRatingViewService = new AssessmentRatingViewService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService,
        new UserPreferenceService(mock(UserPreferenceDao.class)));

    // Act
    Collection<AssessmentGroupedEntities> actualFindGroupedByDefinitionAndOutcomesResult = assessmentRatingViewService
        .findGroupedByDefinitionAndOutcomes(EntityKind.ALL, new ArrayList<>());

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findGroupedByDefinitionAndOutcome(isA(Condition.class));
    verify(assessmentDefinition).id();
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult instanceof Set);
    assertEquals(1, actualFindGroupedByDefinitionAndOutcomesResult.size());
  }

  /**
   * Method under test:
   * {@link AssessmentRatingViewService#findGroupedByDefinitionAndOutcomes(EntityKind, List)}
   */
  @Test
  void testFindGroupedByDefinitionAndOutcomes4() {
    // Arrange
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findGroupedByDefinitionAndOutcome(Mockito.<Condition>any())).thenReturn(new HashSet<>());
    AssessmentDefinition assessmentDefinition = mock(AssessmentDefinition.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(assessmentDefinition.id()).thenReturn(ofResult);
    AssessmentDefinition assessmentDefinition2 = mock(AssessmentDefinition.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(assessmentDefinition2.id()).thenReturn(ofResult2);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(assessmentDefinition2);
    assessmentDefinitionSet.add(assessmentDefinition);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findAll()).thenReturn(assessmentDefinitionSet);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    AssessmentRatingViewService assessmentRatingViewService = new AssessmentRatingViewService(assessmentRatingDao,
        assessmentDefinitionDao, ratingSchemeDAO, changeLogService,
        new UserPreferenceService(mock(UserPreferenceDao.class)));

    // Act
    Collection<AssessmentGroupedEntities> actualFindGroupedByDefinitionAndOutcomesResult = assessmentRatingViewService
        .findGroupedByDefinitionAndOutcomes(EntityKind.ALL, new ArrayList<>());

    // Assert
    verify(assessmentDefinitionDao).findAll();
    verify(assessmentRatingDao).findGroupedByDefinitionAndOutcome(isA(Condition.class));
    verify(assessmentDefinition2).id();
    verify(assessmentDefinition).id();
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult instanceof Set);
    assertTrue(actualFindGroupedByDefinitionAndOutcomesResult.isEmpty());
  }
}
