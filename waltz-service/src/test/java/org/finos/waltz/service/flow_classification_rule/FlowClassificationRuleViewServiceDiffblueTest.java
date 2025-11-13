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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
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
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating.Builder;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.ImmutableDataType;
import org.finos.waltz.model.flow_classification.FlowClassification;
import org.finos.waltz.model.flow_classification.ImmutableFlowClassification;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRule;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleView;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRule;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleView;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlowClassificationRuleViewServiceDiffblueTest {
  /**
   * Test {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRuleView FlowClassificationRuleViewService.getViewForSelector(IdSelectionOptions)"
  })
  void testGetViewForSelector() {
    // Arrange
    FlowClassificationRuleService flowClassificationRuleService =
        mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    FlowClassificationRuleViewService flowClassificationRuleViewService =
        new FlowClassificationRuleViewService(
            flowClassificationRuleService,
            assessmentDefinitionDao,
            assessmentRatingDao,
            ratingSchemeDAO,
            dataTypeDao,
            flowClassificationDao);

    // Act
    FlowClassificationRuleView actualViewForSelector =
        flowClassificationRuleViewService.getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(assessmentRatingDao)
        .findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
  }

  /**
   * Test {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRuleView FlowClassificationRuleViewService.getViewForSelector(IdSelectionOptions)"
  })
  void testGetViewForSelector2() {
    // Arrange
    FlowClassificationRuleService flowClassificationRuleService =
        mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    Builder commentResult =
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
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentRatingList);

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    FlowClassificationRuleViewService flowClassificationRuleViewService =
        new FlowClassificationRuleViewService(
            flowClassificationRuleService,
            assessmentDefinitionDao,
            assessmentRatingDao,
            ratingSchemeDAO,
            dataTypeDao,
            flowClassificationDao);

    // Act
    FlowClassificationRuleView actualViewForSelector =
        flowClassificationRuleViewService.getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(assessmentRatingDao)
        .findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
  }

  /**
   * Test {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRuleView FlowClassificationRuleViewService.getViewForSelector(IdSelectionOptions)"
  })
  void testGetViewForSelector3() {
    // Arrange
    FlowClassificationRuleService flowClassificationRuleService =
        mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    Builder commentResult =
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

    Builder commentResult2 =
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
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentRatingList);

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    FlowClassificationRuleViewService flowClassificationRuleViewService =
        new FlowClassificationRuleViewService(
            flowClassificationRuleService,
            assessmentDefinitionDao,
            assessmentRatingDao,
            ratingSchemeDAO,
            dataTypeDao,
            flowClassificationDao);

    // Act
    FlowClassificationRuleView actualViewForSelector =
        flowClassificationRuleViewService.getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(assessmentRatingDao)
        .findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
  }

  /**
   * Test {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewForSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRuleView FlowClassificationRuleViewService.getViewForSelector(IdSelectionOptions)"
  })
  void testGetViewForSelector4() {
    // Arrange
    FlowClassificationRuleService flowClassificationRuleService =
        mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());

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

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentDefinitionSet);

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    Builder commentResult =
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
            .id(2L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());

    Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(2L)
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
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentRatingList);

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    FlowClassificationRuleViewService flowClassificationRuleViewService =
        new FlowClassificationRuleViewService(
            flowClassificationRuleService,
            assessmentDefinitionDao,
            assessmentRatingDao,
            ratingSchemeDAO,
            dataTypeDao,
            flowClassificationDao);

    // Act
    FlowClassificationRuleView actualViewForSelector =
        flowClassificationRuleViewService.getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(assessmentRatingDao)
        .findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    assertEquals(2, actualViewForSelector.assessmentRatings().size());
    Set<DataType> dataTypesResult = actualViewForSelector.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualViewForSelector.flowClassificationRules());
    assertSame(dataTypesResult, actualViewForSelector.flowClassifications());
    assertSame(dataTypesResult, actualViewForSelector.ratingSchemeItems());
  }

  /**
   * Test {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return assessmentRatings size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewForSelector(IdSelectionOptions); then return assessmentRatings size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRuleView FlowClassificationRuleViewService.getViewForSelector(IdSelectionOptions)"
  })
  void testGetViewForSelector_thenReturnAssessmentRatingsSizeIsOne() {
    // Arrange
    FlowClassificationRuleService flowClassificationRuleService =
        mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());

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

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentDefinitionSet);

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    Builder commentResult =
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
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentRatingList);

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    FlowClassificationRuleViewService flowClassificationRuleViewService =
        new FlowClassificationRuleViewService(
            flowClassificationRuleService,
            assessmentDefinitionDao,
            assessmentRatingDao,
            ratingSchemeDAO,
            dataTypeDao,
            flowClassificationDao);

    // Act
    FlowClassificationRuleView actualViewForSelector =
        flowClassificationRuleViewService.getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(assessmentRatingDao)
        .findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    assertEquals(1, actualViewForSelector.assessmentRatings().size());
    Set<DataType> dataTypesResult = actualViewForSelector.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualViewForSelector.flowClassificationRules());
    assertSame(dataTypesResult, actualViewForSelector.flowClassifications());
    assertSame(dataTypesResult, actualViewForSelector.ratingSchemeItems());
  }

  /**
   * Test {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return assessmentRatings size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewForSelector(IdSelectionOptions); then return assessmentRatings size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRuleView FlowClassificationRuleViewService.getViewForSelector(IdSelectionOptions)"
  })
  void testGetViewForSelector_thenReturnAssessmentRatingsSizeIsOne2() {
    // Arrange
    FlowClassificationRuleService flowClassificationRuleService =
        mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());

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

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentDefinitionSet);

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    Builder commentResult =
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

    Builder commentResult2 =
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
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentRatingList);

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    FlowClassificationRuleViewService flowClassificationRuleViewService =
        new FlowClassificationRuleViewService(
            flowClassificationRuleService,
            assessmentDefinitionDao,
            assessmentRatingDao,
            ratingSchemeDAO,
            dataTypeDao,
            flowClassificationDao);

    // Act
    FlowClassificationRuleView actualViewForSelector =
        flowClassificationRuleViewService.getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(assessmentRatingDao)
        .findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    assertEquals(1, actualViewForSelector.assessmentRatings().size());
    Set<DataType> dataTypesResult = actualViewForSelector.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualViewForSelector.flowClassificationRules());
    assertSame(dataTypesResult, actualViewForSelector.flowClassifications());
    assertSame(dataTypesResult, actualViewForSelector.ratingSchemeItems());
  }

  /**
   * Test {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return assessmentRatings size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewForSelector(IdSelectionOptions); then return assessmentRatings size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRuleView FlowClassificationRuleViewService.getViewForSelector(IdSelectionOptions)"
  })
  void testGetViewForSelector_thenReturnAssessmentRatingsSizeIsTwo() {
    // Arrange
    FlowClassificationRuleService flowClassificationRuleService =
        mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());

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

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentDefinitionSet);

    ArrayList<AssessmentRating> assessmentRatingList = new ArrayList<>();

    Builder commentResult =
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

    Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatingList.add(
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(2L)
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
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentRatingList);

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    FlowClassificationRuleViewService flowClassificationRuleViewService =
        new FlowClassificationRuleViewService(
            flowClassificationRuleService,
            assessmentDefinitionDao,
            assessmentRatingDao,
            ratingSchemeDAO,
            dataTypeDao,
            flowClassificationDao);

    // Act
    FlowClassificationRuleView actualViewForSelector =
        flowClassificationRuleViewService.getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(assessmentRatingDao)
        .findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    assertEquals(2, actualViewForSelector.assessmentRatings().size());
    Set<DataType> dataTypesResult = actualViewForSelector.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualViewForSelector.flowClassificationRules());
    assertSame(dataTypesResult, actualViewForSelector.flowClassifications());
    assertSame(dataTypesResult, actualViewForSelector.ratingSchemeItems());
  }

  /**
   * Test {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return dataTypes size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewForSelector(IdSelectionOptions); then return dataTypes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRuleView FlowClassificationRuleViewService.getViewForSelector(IdSelectionOptions)"
  })
  void testGetViewForSelector_thenReturnDataTypesSizeIsOne() {
    // Arrange
    FlowClassificationRuleService flowClassificationRuleService =
        mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());

    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(dataTypeList);

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    FlowClassificationRuleViewService flowClassificationRuleViewService =
        new FlowClassificationRuleViewService(
            flowClassificationRuleService,
            assessmentDefinitionDao,
            assessmentRatingDao,
            ratingSchemeDAO,
            dataTypeDao,
            flowClassificationDao);

    // Act
    FlowClassificationRuleView actualViewForSelector =
        flowClassificationRuleViewService.getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(assessmentRatingDao)
        .findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    assertEquals(1, actualViewForSelector.dataTypes().size());
  }

  /**
   * Test {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return dataTypes size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewForSelector(IdSelectionOptions); then return dataTypes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRuleView FlowClassificationRuleViewService.getViewForSelector(IdSelectionOptions)"
  })
  void testGetViewForSelector_thenReturnDataTypesSizeIsOne2() {
    // Arrange
    FlowClassificationRuleService flowClassificationRuleService =
        mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());

    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(dataTypeList);

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    FlowClassificationRuleViewService flowClassificationRuleViewService =
        new FlowClassificationRuleViewService(
            flowClassificationRuleService,
            assessmentDefinitionDao,
            assessmentRatingDao,
            ratingSchemeDAO,
            dataTypeDao,
            flowClassificationDao);

    // Act
    FlowClassificationRuleView actualViewForSelector =
        flowClassificationRuleViewService.getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(assessmentRatingDao)
        .findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    assertEquals(1, actualViewForSelector.dataTypes().size());
  }

  /**
   * Test {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return flowClassificationRules size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewForSelector(IdSelectionOptions); then return flowClassificationRules size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRuleView FlowClassificationRuleViewService.getViewForSelector(IdSelectionOptions)"
  })
  void testGetViewForSelector_thenReturnFlowClassificationRulesSizeIsOne() {
    // Arrange
    HashSet<FlowClassificationRule> flowClassificationRuleSet = new HashSet<>();

    ImmutableFlowClassificationRule.Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowClassificationRuleSet.add(
        subjectReferenceResult
            .vantagePointReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    FlowClassificationRuleService flowClassificationRuleService =
        mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(flowClassificationRuleSet);

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    FlowClassificationRuleViewService flowClassificationRuleViewService =
        new FlowClassificationRuleViewService(
            flowClassificationRuleService,
            assessmentDefinitionDao,
            assessmentRatingDao,
            ratingSchemeDAO,
            dataTypeDao,
            flowClassificationDao);

    // Act
    FlowClassificationRuleView actualViewForSelector =
        flowClassificationRuleViewService.getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(assessmentRatingDao)
        .findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    assertEquals(1, actualViewForSelector.flowClassificationRules().size());
  }

  /**
   * Test {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return flowClassifications size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewForSelector(IdSelectionOptions); then return flowClassifications size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRuleView FlowClassificationRuleViewService.getViewForSelector(IdSelectionOptions)"
  })
  void testGetViewForSelector_thenReturnFlowClassificationsSizeIsOne() {
    // Arrange
    FlowClassificationRuleService flowClassificationRuleService =
        mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    HashSet<FlowClassification> flowClassificationSet = new HashSet<>();
    flowClassificationSet.add(
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build());

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(flowClassificationSet);

    FlowClassificationRuleViewService flowClassificationRuleViewService =
        new FlowClassificationRuleViewService(
            flowClassificationRuleService,
            assessmentDefinitionDao,
            assessmentRatingDao,
            ratingSchemeDAO,
            dataTypeDao,
            flowClassificationDao);

    // Act
    FlowClassificationRuleView actualViewForSelector =
        flowClassificationRuleViewService.getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(assessmentRatingDao)
        .findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    assertEquals(1, actualViewForSelector.flowClassifications().size());
  }

  /**
   * Test {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return primaryAssessmentDefinitions size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewForSelector(IdSelectionOptions); then return primaryAssessmentDefinitions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRuleView FlowClassificationRuleViewService.getViewForSelector(IdSelectionOptions)"
  })
  void testGetViewForSelector_thenReturnPrimaryAssessmentDefinitionsSizeIsOne() {
    // Arrange
    FlowClassificationRuleService flowClassificationRuleService =
        mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());

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

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(assessmentDefinitionSet);

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(new HashSet<>());

    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    FlowClassificationRuleViewService flowClassificationRuleViewService =
        new FlowClassificationRuleViewService(
            flowClassificationRuleService,
            assessmentDefinitionDao,
            assessmentRatingDao,
            ratingSchemeDAO,
            dataTypeDao,
            flowClassificationDao);

    // Act
    FlowClassificationRuleView actualViewForSelector =
        flowClassificationRuleViewService.getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(assessmentRatingDao)
        .findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    assertEquals(1, actualViewForSelector.primaryAssessmentDefinitions().size());
  }

  /**
   * Test {@link FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return ratingSchemeItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleViewService#getViewForSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewForSelector(IdSelectionOptions); then return ratingSchemeItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FlowClassificationRuleView FlowClassificationRuleViewService.getViewForSelector(IdSelectionOptions)"
  })
  void testGetViewForSelector_thenReturnRatingSchemeItemsSizeIsOne() {
    // Arrange
    FlowClassificationRuleService flowClassificationRuleService =
        mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.findClassificationRules(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());

    AssessmentDefinitionDao assessmentDefinitionDao = mock(AssessmentDefinitionDao.class);
    when(assessmentDefinitionDao.findPrimaryDefinitionsForKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
        .thenReturn(new HashSet<>());

    AssessmentRatingDao assessmentRatingDao = mock(AssessmentRatingDao.class);
    when(assessmentRatingDao.findByEntityKind(
            Mockito.<EntityKind>any(), Mockito.<Optional<EntityReference>>any()))
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

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);
    when(ratingSchemeDAO.findRatingSchemeItemsByIds(Mockito.<Set<Long>>any()))
        .thenReturn(ratingSchemeItemSet);

    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    FlowClassificationRuleViewService flowClassificationRuleViewService =
        new FlowClassificationRuleViewService(
            flowClassificationRuleService,
            assessmentDefinitionDao,
            assessmentRatingDao,
            ratingSchemeDAO,
            dataTypeDao,
            flowClassificationDao);

    // Act
    FlowClassificationRuleView actualViewForSelector =
        flowClassificationRuleViewService.getViewForSelector(null);

    // Assert
    verify(assessmentDefinitionDao)
        .findPrimaryDefinitionsForKind(
            eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(assessmentRatingDao)
        .findByEntityKind(eq(EntityKind.FLOW_CLASSIFICATION_RULE), isA(Optional.class));
    verify(dataTypeDao).findByIds(isA(Collection.class));
    verify(flowClassificationDao).findAll();
    verify(ratingSchemeDAO).findRatingSchemeItemsByIds(isA(Set.class));
    verify(flowClassificationRuleService).findClassificationRules(isNull());
    assertTrue(actualViewForSelector instanceof ImmutableFlowClassificationRuleView);
    assertEquals(1, actualViewForSelector.ratingSchemeItems().size());
  }
}
