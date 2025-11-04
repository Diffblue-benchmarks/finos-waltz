package org.finos.waltz.service.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.assessment_definition.AssessmentDefinitionDao;
import org.finos.waltz.data.assessment_rating.AssessmentRatingDao;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.flow_classification_rule.FlowClassificationDao;
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRule;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleView;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowClassificationRuleViewServiceDiffblueTest {
  /**
   * Method under test:
   * {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  void testGetViewForSelector() {
    // Arrange
    FlowClassificationRuleService flowClassificationRuleService = mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(Mockito.<EntityKind>any(),
        Mockito.<Optional<EntityReference>>any())).thenReturn(new HashSet<>());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new ArrayList<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    // Act
    FlowClassificationRuleView actualViewForSelector = (new FlowClassificationRuleViewService(
        flowClassificationRuleService, assessmentDefinitionDao, assessmentRatingDao, ratingSchemeDAO, dataTypeDao,
        flowClassificationDao)).getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao).findPrimaryDefinitionsForKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE),
        isA(Optional.class));
    verify(assessmentRatingDao).findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    Set<AssessmentRating> assessmentRatingsResult = actualViewForSelector.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualViewForSelector.dataTypes());
    assertSame(assessmentRatingsResult, actualViewForSelector.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualViewForSelector.flowClassifications());
    assertSame(assessmentRatingsResult, actualViewForSelector.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualViewForSelector.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  void testGetViewForSelector2() {
    // Arrange
    FlowClassificationRule flowClassificationRule = mock(FlowClassificationRule.class);
    when(flowClassificationRule.dataTypeId()).thenReturn(1L);

    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();
    flowClassificationRuleSet.add(flowClassificationRule);
    FlowClassificationRuleService flowClassificationRuleService = mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(flowClassificationRuleSet);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(Mockito.<EntityKind>any(),
        Mockito.<Optional<EntityReference>>any())).thenReturn(new HashSet<>());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new ArrayList<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    // Act
    FlowClassificationRuleView actualViewForSelector = (new FlowClassificationRuleViewService(
        flowClassificationRuleService, assessmentDefinitionDao, assessmentRatingDao, ratingSchemeDAO, dataTypeDao,
        flowClassificationDao)).getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao).findPrimaryDefinitionsForKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE),
        isA(Optional.class));
    verify(assessmentRatingDao).findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(flowClassificationRule).dataTypeId();
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    assertEquals(1, actualViewForSelector.flowClassificationRules().size());
    Set<AssessmentRating> assessmentRatingsResult = actualViewForSelector.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualViewForSelector.dataTypes());
    assertSame(assessmentRatingsResult, actualViewForSelector.flowClassifications());
    assertSame(assessmentRatingsResult, actualViewForSelector.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualViewForSelector.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  void testGetViewForSelector3() {
    // Arrange
    FlowClassificationRule flowClassificationRule = mock(FlowClassificationRule.class);
    when(flowClassificationRule.dataTypeId()).thenReturn(1L);
    FlowClassificationRule flowClassificationRule2 = mock(FlowClassificationRule.class);
    when(flowClassificationRule2.dataTypeId()).thenReturn(1L);

    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();
    flowClassificationRuleSet.add(flowClassificationRule2);
    flowClassificationRuleSet.add(flowClassificationRule);
    FlowClassificationRuleService flowClassificationRuleService = mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(flowClassificationRuleSet);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(Mockito.<EntityKind>any(),
        Mockito.<Optional<EntityReference>>any())).thenReturn(new HashSet<>());
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new ArrayList<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    // Act
    FlowClassificationRuleView actualViewForSelector = (new FlowClassificationRuleViewService(
        flowClassificationRuleService, assessmentDefinitionDao, assessmentRatingDao, ratingSchemeDAO, dataTypeDao,
        flowClassificationDao)).getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao).findPrimaryDefinitionsForKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE),
        isA(Optional.class));
    verify(assessmentRatingDao).findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(flowClassificationRule2).dataTypeId();
    verify(flowClassificationRule).dataTypeId();
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    Set<AssessmentRating> assessmentRatingsResult = actualViewForSelector.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertEquals(flowClassificationRuleSet, actualViewForSelector.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualViewForSelector.dataTypes());
    assertSame(assessmentRatingsResult, actualViewForSelector.flowClassifications());
    assertSame(assessmentRatingsResult, actualViewForSelector.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualViewForSelector.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  void testGetViewForSelector4() {
    // Arrange
    FlowClassificationRule flowClassificationRule = mock(FlowClassificationRule.class);
    when(flowClassificationRule.dataTypeId()).thenReturn(1L);
    FlowClassificationRule flowClassificationRule2 = mock(FlowClassificationRule.class);
    when(flowClassificationRule2.dataTypeId()).thenReturn(1L);

    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();
    flowClassificationRuleSet.add(flowClassificationRule2);
    flowClassificationRuleSet.add(flowClassificationRule);
    FlowClassificationRuleService flowClassificationRuleService = mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(flowClassificationRuleSet);
    AssessmentDefinition assessmentDefinition = mock(AssessmentDefinition.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(assessmentDefinition.id()).thenReturn(ofResult);

    HashSet<AssessmentDefinition> assessmentDefinitionSet = new HashSet<>();
    assessmentDefinitionSet.add(assessmentDefinition);
    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(Mockito.<EntityKind>any(),
        Mockito.<Optional<EntityReference>>any())).thenReturn(assessmentDefinitionSet);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new ArrayList<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    // Act
    FlowClassificationRuleView actualViewForSelector = (new FlowClassificationRuleViewService(
        flowClassificationRuleService, assessmentDefinitionDao, assessmentRatingDao, ratingSchemeDAO, dataTypeDao,
        flowClassificationDao)).getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao).findPrimaryDefinitionsForKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE),
        isA(Optional.class));
    verify(assessmentRatingDao).findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(assessmentDefinition).id();
    verify(flowClassificationRule2).dataTypeId();
    verify(flowClassificationRule).dataTypeId();
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    assertEquals(1, actualViewForSelector.primaryAssessmentDefinitions().size());
    Set<AssessmentRating> assessmentRatingsResult = actualViewForSelector.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertEquals(flowClassificationRuleSet, actualViewForSelector.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualViewForSelector.dataTypes());
    assertSame(assessmentRatingsResult, actualViewForSelector.flowClassifications());
    assertSame(assessmentRatingsResult, actualViewForSelector.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  void testGetViewForSelector5() {
    // Arrange
    FlowClassificationRule flowClassificationRule = mock(FlowClassificationRule.class);
    when(flowClassificationRule.dataTypeId()).thenReturn(1L);
    FlowClassificationRule flowClassificationRule2 = mock(FlowClassificationRule.class);
    when(flowClassificationRule2.dataTypeId()).thenReturn(1L);

    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();
    flowClassificationRuleSet.add(flowClassificationRule2);
    flowClassificationRuleSet.add(flowClassificationRule);
    FlowClassificationRuleService flowClassificationRuleService = mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(flowClassificationRuleSet);
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
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(Mockito.<EntityKind>any(),
        Mockito.<Optional<EntityReference>>any())).thenReturn(assessmentDefinitionSet);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new ArrayList<>());
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    // Act
    FlowClassificationRuleView actualViewForSelector = (new FlowClassificationRuleViewService(
        flowClassificationRuleService, assessmentDefinitionDao, assessmentRatingDao, ratingSchemeDAO, dataTypeDao,
        flowClassificationDao)).getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao).findPrimaryDefinitionsForKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE),
        isA(Optional.class));
    verify(assessmentRatingDao).findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(assessmentDefinition2).id();
    verify(assessmentDefinition).id();
    verify(flowClassificationRule2).dataTypeId();
    verify(flowClassificationRule).dataTypeId();
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    Set<AssessmentRating> assessmentRatingsResult = actualViewForSelector.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertEquals(flowClassificationRuleSet, actualViewForSelector.flowClassificationRules());
    assertEquals(assessmentDefinitionSet, actualViewForSelector.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualViewForSelector.dataTypes());
    assertSame(assessmentRatingsResult, actualViewForSelector.flowClassifications());
    assertSame(assessmentRatingsResult, actualViewForSelector.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  void testGetViewForSelector6() {
    // Arrange
    FlowClassificationRule flowClassificationRule = mock(FlowClassificationRule.class);
    when(flowClassificationRule.dataTypeId()).thenReturn(1L);
    FlowClassificationRule flowClassificationRule2 = mock(FlowClassificationRule.class);
    when(flowClassificationRule2.dataTypeId()).thenReturn(1L);

    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();
    flowClassificationRuleSet.add(flowClassificationRule2);
    flowClassificationRuleSet.add(flowClassificationRule);
    FlowClassificationRuleService flowClassificationRuleService = mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(flowClassificationRuleSet);
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
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(Mockito.<EntityKind>any(),
        Mockito.<Optional<EntityReference>>any())).thenReturn(assessmentDefinitionSet);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.ratingId()).thenReturn(1L);
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();
    assessmentRatingList.add(assessmentRating);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentRatingList);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    // Act
    FlowClassificationRuleView actualViewForSelector = (new FlowClassificationRuleViewService(
        flowClassificationRuleService, assessmentDefinitionDao, assessmentRatingDao, ratingSchemeDAO, dataTypeDao,
        flowClassificationDao)).getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao).findPrimaryDefinitionsForKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE),
        isA(Optional.class));
    verify(assessmentRatingDao).findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(assessmentDefinition2).id();
    verify(assessmentDefinition).id();
    verify(assessmentRating).assessmentDefinitionId();
    verify(assessmentRating).ratingId();
    verify(flowClassificationRule2).dataTypeId();
    verify(flowClassificationRule).dataTypeId();
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    assertEquals(1, actualViewForSelector.assessmentRatings().size());
    Set<DataType> dataTypesResult = actualViewForSelector.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertEquals(flowClassificationRuleSet, actualViewForSelector.flowClassificationRules());
    assertEquals(assessmentDefinitionSet, actualViewForSelector.primaryAssessmentDefinitions());
    assertSame(dataTypesResult, actualViewForSelector.flowClassifications());
    assertSame(dataTypesResult, actualViewForSelector.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  void testGetViewForSelector7() {
    // Arrange
    FlowClassificationRule flowClassificationRule = mock(FlowClassificationRule.class);
    when(flowClassificationRule.dataTypeId()).thenReturn(1L);
    FlowClassificationRule flowClassificationRule2 = mock(FlowClassificationRule.class);
    when(flowClassificationRule2.dataTypeId()).thenReturn(1L);

    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();
    flowClassificationRuleSet.add(flowClassificationRule2);
    flowClassificationRuleSet.add(flowClassificationRule);
    FlowClassificationRuleService flowClassificationRuleService = mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(flowClassificationRuleSet);
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
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(Mockito.<EntityKind>any(),
        Mockito.<Optional<EntityReference>>any())).thenReturn(assessmentDefinitionSet);
    AssessmentRating assessmentRating = mock(AssessmentRating.class);
    when(assessmentRating.ratingId()).thenReturn(1L);
    when(assessmentRating.assessmentDefinitionId()).thenReturn(1L);
    AssessmentRating assessmentRating2 = mock(AssessmentRating.class);
    when(assessmentRating2.ratingId()).thenReturn(1L);
    when(assessmentRating2.assessmentDefinitionId()).thenReturn(1L);

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();
    assessmentRatingList.add(assessmentRating2);
    assessmentRatingList.add(assessmentRating);
    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentRatingList);
    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    // Act
    FlowClassificationRuleView actualViewForSelector = (new FlowClassificationRuleViewService(
        flowClassificationRuleService, assessmentDefinitionDao, assessmentRatingDao, ratingSchemeDAO, dataTypeDao,
        flowClassificationDao)).getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao).findPrimaryDefinitionsForKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE),
        isA(Optional.class));
    verify(assessmentRatingDao).findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(assessmentDefinition2).id();
    verify(assessmentDefinition).id();
    verify(assessmentRating2).assessmentDefinitionId();
    verify(assessmentRating).assessmentDefinitionId();
    verify(assessmentRating2).ratingId();
    verify(assessmentRating).ratingId();
    verify(flowClassificationRule2).dataTypeId();
    verify(flowClassificationRule).dataTypeId();
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    assertEquals(2, actualViewForSelector.assessmentRatings().size());
    Set<DataType> dataTypesResult = actualViewForSelector.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertEquals(flowClassificationRuleSet, actualViewForSelector.flowClassificationRules());
    assertEquals(assessmentDefinitionSet, actualViewForSelector.primaryAssessmentDefinitions());
    assertSame(dataTypesResult, actualViewForSelector.flowClassifications());
    assertSame(dataTypesResult, actualViewForSelector.ratingSchemeItems());
  }
}
