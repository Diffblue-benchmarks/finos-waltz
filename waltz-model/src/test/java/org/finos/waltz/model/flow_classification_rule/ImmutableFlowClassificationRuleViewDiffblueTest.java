package org.finos.waltz.model.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.ImmutableDataType;
import org.finos.waltz.model.flow_classification.FlowClassification;
import org.finos.waltz.model.flow_classification.ImmutableFlowClassification;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleView.Builder;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleView.Json;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationRuleViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessmentRatings(Iterable)}.
   *
   * <ul>
   *   <li>Then return build assessmentRatings Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAssessmentRatings(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllAssessmentRatings(Iterable); then return build assessmentRatings Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAssessmentRatings(Iterable)"})
  void testBuilderAddAllAssessmentRatings_thenReturnBuildAssessmentRatingsEmpty() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act and Assert
    ImmutableFlowClassificationRuleView immutableFlowClassificationRuleView =
        builderResult.addAllAssessmentRatings(new ArrayList<>()).build();
    Set<AssessmentRating> assessmentRatingsResult =
        immutableFlowClassificationRuleView.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, immutableFlowClassificationRuleView.dataTypes());
    assertSame(
        assessmentRatingsResult, immutableFlowClassificationRuleView.flowClassificationRules());
    assertSame(assessmentRatingsResult, immutableFlowClassificationRuleView.flowClassifications());
    assertSame(
        assessmentRatingsResult,
        immutableFlowClassificationRuleView.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, immutableFlowClassificationRuleView.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#addAssessmentRatings(AssessmentRating)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addAssessmentRatings(AssessmentRating)}
   */
  @Test
  @DisplayName("Test Builder addAssessmentRatings(AssessmentRating) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAssessmentRatings(AssessmentRating)"})
  void testBuilderAddAssessmentRatingsWithElement() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    Builder actualAddAssessmentRatingsResult =
        builderResult.addAssessmentRatings(
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

    // Assert
    assertEquals(1, builderResult.build().assessmentRatings().size());
    assertSame(builderResult, actualAddAssessmentRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addAssessmentRatings(AssessmentRating[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addAssessmentRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test Builder addAssessmentRatings(AssessmentRating[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAssessmentRatings(AssessmentRating[])"})
  void testBuilderAddAssessmentRatingsWithElements() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    Builder actualAddAssessmentRatingsResult =
        builderResult.addAssessmentRatings(
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

    // Assert
    assertEquals(1, builderResult.build().assessmentRatings().size());
    assertSame(builderResult, actualAddAssessmentRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addDataTypes(DataType)} with {@code element}.
   *
   * <ul>
   *   <li>Then builder build dataTypes size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addDataTypes(DataType)}
   */
  @Test
  @DisplayName(
      "Test Builder addDataTypes(DataType) with 'element'; then builder build dataTypes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDataTypes(DataType)"})
  void testBuilderAddDataTypesWithElement_thenBuilderBuildDataTypesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddDataTypesResult =
        builderResult.addDataTypes(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Assert
    assertEquals(1, builderResult.build().dataTypes().size());
    assertSame(builderResult, actualAddDataTypesResult);
  }

  /**
   * Test Builder {@link Builder#addDataTypes(DataType[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then builder build dataTypes size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addDataTypes(DataType[])}
   */
  @Test
  @DisplayName(
      "Test Builder addDataTypes(DataType[]) with 'elements'; then builder build dataTypes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDataTypes(DataType[])"})
  void testBuilderAddDataTypesWithElements_thenBuilderBuildDataTypesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddDataTypesResult =
        builderResult.addDataTypes(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Assert
    assertEquals(1, builderResult.build().dataTypes().size());
    assertSame(builderResult, actualAddDataTypesResult);
  }

  /**
   * Test Builder {@link Builder#addFlowClassificationRules(FlowClassificationRule)} with {@code
   * element}.
   *
   * <p>Method under test: {@link Builder#addFlowClassificationRules(FlowClassificationRule)}
   */
  @Test
  @DisplayName("Test Builder addFlowClassificationRules(FlowClassificationRule) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addFlowClassificationRules(FlowClassificationRule)"})
  void testBuilderAddFlowClassificationRulesWithElement() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddFlowClassificationRulesResult =
        builderResult.addFlowClassificationRules(new ImmutableFlowClassificationRule.Json());

    // Assert
    assertEquals(1, builderResult.build().flowClassificationRules().size());
    assertSame(builderResult, actualAddFlowClassificationRulesResult);
  }

  /**
   * Test Builder {@link Builder#addFlowClassificationRules(FlowClassificationRule[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link Builder#addFlowClassificationRules(FlowClassificationRule[])}
   */
  @Test
  @DisplayName("Test Builder addFlowClassificationRules(FlowClassificationRule[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addFlowClassificationRules(FlowClassificationRule[])"})
  void testBuilderAddFlowClassificationRulesWithElements() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddFlowClassificationRulesResult =
        builderResult.addFlowClassificationRules(new ImmutableFlowClassificationRule.Json());

    // Assert
    assertEquals(1, builderResult.build().flowClassificationRules().size());
    assertSame(builderResult, actualAddFlowClassificationRulesResult);
  }

  /**
   * Test Builder {@link Builder#addFlowClassifications(FlowClassification)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addFlowClassifications(FlowClassification)}
   */
  @Test
  @DisplayName("Test Builder addFlowClassifications(FlowClassification) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addFlowClassifications(FlowClassification)"})
  void testBuilderAddFlowClassificationsWithElement() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddFlowClassificationsResult =
        builderResult.addFlowClassifications(
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

    // Assert
    assertEquals(1, builderResult.build().flowClassifications().size());
    assertSame(builderResult, actualAddFlowClassificationsResult);
  }

  /**
   * Test Builder {@link Builder#addFlowClassifications(FlowClassification[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link Builder#addFlowClassifications(FlowClassification[])}
   */
  @Test
  @DisplayName("Test Builder addFlowClassifications(FlowClassification[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addFlowClassifications(FlowClassification[])"})
  void testBuilderAddFlowClassificationsWithElements() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddFlowClassificationsResult =
        builderResult.addFlowClassifications(
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

    // Assert
    assertEquals(1, builderResult.build().flowClassifications().size());
    assertSame(builderResult, actualAddFlowClassificationsResult);
  }

  /**
   * Test Builder {@link Builder#addPrimaryAssessmentDefinitions(AssessmentDefinition)} with {@code
   * element}.
   *
   * <p>Method under test: {@link Builder#addPrimaryAssessmentDefinitions(AssessmentDefinition)}
   */
  @Test
  @DisplayName("Test Builder addPrimaryAssessmentDefinitions(AssessmentDefinition) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPrimaryAssessmentDefinitions(AssessmentDefinition)"})
  void testBuilderAddPrimaryAssessmentDefinitionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

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

    // Act
    Builder actualAddPrimaryAssessmentDefinitionsResult =
        builderResult.addPrimaryAssessmentDefinitions(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals(1, builderResult.build().primaryAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPrimaryAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addPrimaryAssessmentDefinitions(AssessmentDefinition[])} with
   * {@code elements}.
   *
   * <p>Method under test: {@link Builder#addPrimaryAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName(
      "Test Builder addPrimaryAssessmentDefinitions(AssessmentDefinition[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPrimaryAssessmentDefinitions(AssessmentDefinition[])"})
  void testBuilderAddPrimaryAssessmentDefinitionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

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

    // Act
    Builder actualAddPrimaryAssessmentDefinitionsResult =
        builderResult.addPrimaryAssessmentDefinitions(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals(1, builderResult.build().primaryAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPrimaryAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingSchemeItems(RatingSchemeItem)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addRatingSchemeItems(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder addRatingSchemeItems(RatingSchemeItem) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingSchemeItems(RatingSchemeItem)"})
  void testBuilderAddRatingSchemeItemsWithElement() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult =
        builderResult.addRatingSchemeItems(
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

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingSchemeItems(RatingSchemeItem[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test Builder addRatingSchemeItems(RatingSchemeItem[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingSchemeItems(RatingSchemeItem[])"})
  void testBuilderAddRatingSchemeItemsWithElements() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult =
        builderResult.addRatingSchemeItems(
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

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#assessmentRatings(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return build assessmentRatings Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#assessmentRatings(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder assessmentRatings(Iterable); when ArrayList(); then return build assessmentRatings Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessmentRatings(Iterable)"})
  void testBuilderAssessmentRatings_whenArrayList_thenReturnBuildAssessmentRatingsEmpty() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act and Assert
    ImmutableFlowClassificationRuleView immutableFlowClassificationRuleView =
        builderResult.assessmentRatings(new ArrayList<>()).build();
    Set<AssessmentRating> assessmentRatingsResult =
        immutableFlowClassificationRuleView.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, immutableFlowClassificationRuleView.dataTypes());
    assertSame(
        assessmentRatingsResult, immutableFlowClassificationRuleView.flowClassificationRules());
    assertSame(assessmentRatingsResult, immutableFlowClassificationRuleView.flowClassifications());
    assertSame(
        assessmentRatingsResult,
        immutableFlowClassificationRuleView.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, immutableFlowClassificationRuleView.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowClassificationRuleView Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableFlowClassificationRuleView.builder().build().assessmentRatings().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleView)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(FlowClassificationRuleView)}
   */
  @Test
  @DisplayName(
      "Test Builder from(FlowClassificationRuleView); when builder build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleView)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(ImmutableFlowClassificationRuleView.builder().build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#copyOf(FlowClassificationRuleView)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return assessmentRatings Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleView#copyOf(FlowClassificationRuleView)}
   */
  @Test
  @DisplayName(
      "Test copyOf(FlowClassificationRuleView); when builder build; then return assessmentRatings Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.copyOf(FlowClassificationRuleView)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnAssessmentRatingsEmpty() {
    // Arrange
    ImmutableFlowClassificationRuleView instance =
        ImmutableFlowClassificationRuleView.builder().build();

    // Act
    ImmutableFlowClassificationRuleView actualCopyOfResult =
        ImmutableFlowClassificationRuleView.copyOf(instance);

    // Assert
    Set<AssessmentRating> assessmentRatingsResult = actualCopyOfResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualCopyOfResult.dataTypes());
    assertSame(assessmentRatingsResult, actualCopyOfResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualCopyOfResult.flowClassifications());
    assertSame(assessmentRatingsResult, actualCopyOfResult.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}, and {@link
   * ImmutableFlowClassificationRuleView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleView#equals(Object)}
   *   <li>{@link ImmutableFlowClassificationRuleView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleView.equals(Object)",
    "int ImmutableFlowClassificationRuleView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableFlowClassificationRuleView immutableFlowClassificationRuleView =
        ImmutableFlowClassificationRuleView.builder().build();
    ImmutableFlowClassificationRuleView immutableFlowClassificationRuleView2 =
        ImmutableFlowClassificationRuleView.builder().build();

    // Act and Assert
    assertEquals(immutableFlowClassificationRuleView, immutableFlowClassificationRuleView2);
    assertEquals(
        immutableFlowClassificationRuleView.hashCode(),
        immutableFlowClassificationRuleView2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}, and {@link
   * ImmutableFlowClassificationRuleView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleView#equals(Object)}
   *   <li>{@link ImmutableFlowClassificationRuleView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleView.equals(Object)",
    "int ImmutableFlowClassificationRuleView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableFlowClassificationRuleView immutableFlowClassificationRuleView =
        ImmutableFlowClassificationRuleView.builder().build();

    // Act and Assert
    assertEquals(immutableFlowClassificationRuleView, immutableFlowClassificationRuleView);
    int expectedHashCodeResult = immutableFlowClassificationRuleView.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowClassificationRuleView.hashCode());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleView.equals(Object)",
    "int ImmutableFlowClassificationRuleView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

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
    builderResult.addFlowClassificationRules(
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

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableFlowClassificationRuleView.builder().build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleView.equals(Object)",
    "int ImmutableFlowClassificationRuleView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    builderResult.addAssessmentRatings(
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

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableFlowClassificationRuleView.builder().build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleView.equals(Object)",
    "int ImmutableFlowClassificationRuleView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();

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
    builderResult.addPrimaryAssessmentDefinitions(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableFlowClassificationRuleView.builder().build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleView.equals(Object)",
    "int ImmutableFlowClassificationRuleView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    builderResult.addRatingSchemeItems(
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

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableFlowClassificationRuleView.builder().build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleView.equals(Object)",
    "int ImmutableFlowClassificationRuleView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    builderResult.addDataTypes(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableFlowClassificationRuleView.builder().build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleView.equals(Object)",
    "int ImmutableFlowClassificationRuleView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleView.builder();
    builderResult.addFlowClassifications(
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

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableFlowClassificationRuleView.builder().build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleView.equals(Object)",
    "int ImmutableFlowClassificationRuleView.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableFlowClassificationRuleView.builder().build(), null);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleView.equals(Object)",
    "int ImmutableFlowClassificationRuleView.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableFlowClassificationRuleView.builder().build(),
        "Different type to ImmutableFlowClassificationRuleView");
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) DataTypes is {@code null}.
   *   <li>Then return dataTypes Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) DataTypes is 'null'; then return dataTypes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonDataTypesIsNull_thenReturnDataTypesEmpty() {
    // Arrange
    LinkedHashSet<FlowClassificationRule> flowClassificationRules = new LinkedHashSet<>();

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
    flowClassificationRules.add(
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

    LinkedHashSet<AssessmentRating> assessmentRatings = new LinkedHashSet<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
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

    LinkedHashSet<AssessmentDefinition> primaryAssessmentDefinitions = new LinkedHashSet<>();

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
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
    primaryAssessmentDefinitions.add(
        provenanceResult2
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(
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

    LinkedHashSet<FlowClassification> flowClassifications = new LinkedHashSet<>();
    flowClassifications.add(
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

    Json json = new Json();
    json.setFlowClassificationRules(flowClassificationRules);
    json.setAssessmentRatings(assessmentRatings);
    json.setPrimaryAssessmentDefinitions(primaryAssessmentDefinitions);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setDataTypes(null);
    json.setFlowClassifications(flowClassifications);

    // Act
    ImmutableFlowClassificationRuleView actualFromJsonResult =
        ImmutableFlowClassificationRuleView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.flowClassificationRules().size());
    assertEquals(1, actualFromJsonResult.flowClassifications().size());
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
    assertTrue(actualFromJsonResult.dataTypes().isEmpty());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return dataTypes size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return dataTypes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.fromJson(Json)"
  })
  void testFromJson_thenReturnDataTypesSizeIsOne() {
    // Arrange
    LinkedHashSet<FlowClassificationRule> flowClassificationRules = new LinkedHashSet<>();

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
    flowClassificationRules.add(
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

    LinkedHashSet<AssessmentRating> assessmentRatings = new LinkedHashSet<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
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

    LinkedHashSet<AssessmentDefinition> primaryAssessmentDefinitions = new LinkedHashSet<>();

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
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
    primaryAssessmentDefinitions.add(
        provenanceResult2
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(
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

    LinkedHashSet<DataType> dataTypes = new LinkedHashSet<>();
    dataTypes.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());

    LinkedHashSet<FlowClassification> flowClassifications = new LinkedHashSet<>();
    flowClassifications.add(
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

    Json json = new Json();
    json.setFlowClassificationRules(flowClassificationRules);
    json.setAssessmentRatings(assessmentRatings);
    json.setPrimaryAssessmentDefinitions(primaryAssessmentDefinitions);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setDataTypes(dataTypes);
    json.setFlowClassifications(flowClassifications);

    // Act
    ImmutableFlowClassificationRuleView actualFromJsonResult =
        ImmutableFlowClassificationRuleView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.dataTypes().size());
    assertEquals(1, actualFromJsonResult.flowClassificationRules().size());
    assertEquals(1, actualFromJsonResult.flowClassifications().size());
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return flowClassificationRules size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return flowClassificationRules size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.fromJson(Json)"
  })
  void testFromJson_thenReturnFlowClassificationRulesSizeIsTwo() {
    // Arrange
    LinkedHashSet<FlowClassificationRule> flowClassificationRules = new LinkedHashSet<>();

    ImmutableFlowClassificationRule.Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(2L)
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
    flowClassificationRules.add(
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

    ImmutableFlowClassificationRule.Builder provenanceResult2 =
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

    ImmutableFlowClassificationRule.Builder subjectOrgUnitReferenceResult2 =
        provenanceResult2.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableFlowClassificationRule.Builder subjectReferenceResult2 =
        subjectOrgUnitReferenceResult2.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    flowClassificationRules.add(
        subjectReferenceResult2
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

    LinkedHashSet<AssessmentRating> assessmentRatings = new LinkedHashSet<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
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

    LinkedHashSet<AssessmentDefinition> primaryAssessmentDefinitions = new LinkedHashSet<>();

    ImmutableAssessmentDefinition.Builder provenanceResult3 =
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
    primaryAssessmentDefinitions.add(
        provenanceResult3
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(
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

    LinkedHashSet<DataType> dataTypes = new LinkedHashSet<>();
    dataTypes.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());

    LinkedHashSet<FlowClassification> flowClassifications = new LinkedHashSet<>();
    flowClassifications.add(
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

    Json json = new Json();
    json.setFlowClassificationRules(flowClassificationRules);
    json.setAssessmentRatings(assessmentRatings);
    json.setPrimaryAssessmentDefinitions(primaryAssessmentDefinitions);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setDataTypes(dataTypes);
    json.setFlowClassifications(flowClassifications);

    // Act
    ImmutableFlowClassificationRuleView actualFromJsonResult =
        ImmutableFlowClassificationRuleView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.dataTypes().size());
    assertEquals(1, actualFromJsonResult.flowClassifications().size());
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
    assertEquals(2, actualFromJsonResult.flowClassificationRules().size());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return flowClassifications Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return flowClassifications Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.fromJson(Json)"
  })
  void testFromJson_thenReturnFlowClassificationsEmpty() {
    // Arrange
    LinkedHashSet<FlowClassificationRule> flowClassificationRules = new LinkedHashSet<>();

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
    flowClassificationRules.add(
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

    LinkedHashSet<AssessmentRating> assessmentRatings = new LinkedHashSet<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
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

    LinkedHashSet<AssessmentDefinition> primaryAssessmentDefinitions = new LinkedHashSet<>();

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
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
    primaryAssessmentDefinitions.add(
        provenanceResult2
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(
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

    LinkedHashSet<DataType> dataTypes = new LinkedHashSet<>();
    dataTypes.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());

    Json json = new Json();
    json.setFlowClassificationRules(flowClassificationRules);
    json.setAssessmentRatings(assessmentRatings);
    json.setPrimaryAssessmentDefinitions(primaryAssessmentDefinitions);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setDataTypes(dataTypes);
    json.setFlowClassifications(null);

    // Act
    ImmutableFlowClassificationRuleView actualFromJsonResult =
        ImmutableFlowClassificationRuleView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.dataTypes().size());
    assertEquals(1, actualFromJsonResult.flowClassificationRules().size());
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
    assertTrue(actualFromJsonResult.flowClassifications().isEmpty());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) RatingSchemeItems is {@code null}.
   *   <li>Then return ratingSchemeItems Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) RatingSchemeItems is 'null'; then return ratingSchemeItems Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.fromJson(Json)"
  })
  void testFromJson_whenJsonRatingSchemeItemsIsNull_thenReturnRatingSchemeItemsEmpty() {
    // Arrange
    LinkedHashSet<FlowClassificationRule> flowClassificationRules = new LinkedHashSet<>();

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
    flowClassificationRules.add(
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

    LinkedHashSet<AssessmentRating> assessmentRatings = new LinkedHashSet<>();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    assessmentRatings.add(
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

    LinkedHashSet<AssessmentDefinition> primaryAssessmentDefinitions = new LinkedHashSet<>();

    ImmutableAssessmentDefinition.Builder provenanceResult2 =
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
    primaryAssessmentDefinitions.add(
        provenanceResult2
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    LinkedHashSet<DataType> dataTypes = new LinkedHashSet<>();
    dataTypes.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());

    LinkedHashSet<FlowClassification> flowClassifications = new LinkedHashSet<>();
    flowClassifications.add(
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

    Json json = new Json();
    json.setFlowClassificationRules(flowClassificationRules);
    json.setAssessmentRatings(assessmentRatings);
    json.setPrimaryAssessmentDefinitions(primaryAssessmentDefinitions);
    json.setRatingSchemeItems(null);
    json.setDataTypes(dataTypes);
    json.setFlowClassifications(flowClassifications);

    // Act
    ImmutableFlowClassificationRuleView actualFromJsonResult =
        ImmutableFlowClassificationRuleView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.dataTypes().size());
    assertEquals(1, actualFromJsonResult.flowClassificationRules().size());
    assertEquals(1, actualFromJsonResult.flowClassifications().size());
    assertTrue(actualFromJsonResult.ratingSchemeItems().isEmpty());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return assessmentRatings Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return assessmentRatings Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnAssessmentRatingsEmpty() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableFlowClassificationRuleView actualFromJsonResult =
        ImmutableFlowClassificationRuleView.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessmentRatings().isEmpty());
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, actualFromJsonResult.dataTypes());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.flowClassificationRules());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.flowClassifications());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.primaryAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleView#toString()}
   *   <li>{@link ImmutableFlowClassificationRuleView#assessmentRatings()}
   *   <li>{@link ImmutableFlowClassificationRuleView#dataTypes()}
   *   <li>{@link ImmutableFlowClassificationRuleView#flowClassificationRules()}
   *   <li>{@link ImmutableFlowClassificationRuleView#flowClassifications()}
   *   <li>{@link ImmutableFlowClassificationRuleView#primaryAssessmentDefinitions()}
   *   <li>{@link ImmutableFlowClassificationRuleView#ratingSchemeItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableFlowClassificationRuleView.assessmentRatings()",
    "Set ImmutableFlowClassificationRuleView.dataTypes()",
    "Set ImmutableFlowClassificationRuleView.flowClassificationRules()",
    "Set ImmutableFlowClassificationRuleView.flowClassifications()",
    "Set ImmutableFlowClassificationRuleView.primaryAssessmentDefinitions()",
    "Set ImmutableFlowClassificationRuleView.ratingSchemeItems()",
    "String ImmutableFlowClassificationRuleView.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableFlowClassificationRuleView immutableFlowClassificationRuleView =
        ImmutableFlowClassificationRuleView.builder().build();

    // Act
    String actualToStringResult = immutableFlowClassificationRuleView.toString();
    Set<AssessmentRating> actualAssessmentRatingsResult =
        immutableFlowClassificationRuleView.assessmentRatings();
    Set<DataType> actualDataTypesResult = immutableFlowClassificationRuleView.dataTypes();
    Set<FlowClassificationRule> actualFlowClassificationRulesResult =
        immutableFlowClassificationRuleView.flowClassificationRules();
    Set<FlowClassification> actualFlowClassificationsResult =
        immutableFlowClassificationRuleView.flowClassifications();
    Set<AssessmentDefinition> actualPrimaryAssessmentDefinitionsResult =
        immutableFlowClassificationRuleView.primaryAssessmentDefinitions();
    Set<RatingSchemeItem> actualRatingSchemeItemsResult =
        immutableFlowClassificationRuleView.ratingSchemeItems();

    // Assert
    assertEquals(
        "FlowClassificationRuleView{flowClassificationRules=[], assessmentRatings=[], primaryAssessmentDefinitions=[],"
            + " ratingSchemeItems=[], dataTypes=[], flowClassifications=[]}",
        actualToStringResult);
    assertTrue(actualAssessmentRatingsResult.isEmpty());
    assertSame(actualAssessmentRatingsResult, actualDataTypesResult);
    assertSame(actualAssessmentRatingsResult, actualFlowClassificationRulesResult);
    assertSame(actualAssessmentRatingsResult, actualFlowClassificationsResult);
    assertSame(actualAssessmentRatingsResult, actualPrimaryAssessmentDefinitionsResult);
    assertSame(actualAssessmentRatingsResult, actualRatingSchemeItemsResult);
  }

  /**
   * Test Json {@link Json#assessmentRatings()}.
   *
   * <p>Method under test: {@link Json#assessmentRatings()}
   */
  @Test
  @DisplayName("Test Json assessmentRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.assessmentRatings()"})
  void testJsonAssessmentRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assessmentRatings());
  }

  /**
   * Test Json {@link Json#dataTypes()}.
   *
   * <p>Method under test: {@link Json#dataTypes()}
   */
  @Test
  @DisplayName("Test Json dataTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.dataTypes()"})
  void testJsonDataTypes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dataTypes());
  }

  /**
   * Test Json {@link Json#flowClassificationRules()}.
   *
   * <p>Method under test: {@link Json#flowClassificationRules()}
   */
  @Test
  @DisplayName("Test Json flowClassificationRules()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.flowClassificationRules()"})
  void testJsonFlowClassificationRules() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().flowClassificationRules());
  }

  /**
   * Test Json {@link Json#flowClassifications()}.
   *
   * <p>Method under test: {@link Json#flowClassifications()}
   */
  @Test
  @DisplayName("Test Json flowClassifications()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.flowClassifications()"})
  void testJsonFlowClassifications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().flowClassifications());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertTrue(actualJson.assessmentRatings.isEmpty());
    assertTrue(actualJson.dataTypes.isEmpty());
    assertTrue(actualJson.flowClassificationRules.isEmpty());
    assertTrue(actualJson.flowClassifications.isEmpty());
    assertTrue(actualJson.primaryAssessmentDefinitions.isEmpty());
    assertTrue(actualJson.ratingSchemeItems.isEmpty());
  }

  /**
   * Test Json {@link Json#primaryAssessmentDefinitions()}.
   *
   * <p>Method under test: {@link Json#primaryAssessmentDefinitions()}
   */
  @Test
  @DisplayName("Test Json primaryAssessmentDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.primaryAssessmentDefinitions()"})
  void testJsonPrimaryAssessmentDefinitions() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().primaryAssessmentDefinitions());
  }

  /**
   * Test Json {@link Json#ratingSchemeItems()}.
   *
   * <p>Method under test: {@link Json#ratingSchemeItems()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.ratingSchemeItems()"})
  void testJsonRatingSchemeItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#withAssessmentRatings(AssessmentRating[])} with
   * {@code AssessmentRating[]}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleView#withAssessmentRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test withAssessmentRatings(AssessmentRating[]) with 'AssessmentRating[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.withAssessmentRatings(AssessmentRating[])"
  })
  void testWithAssessmentRatingsWithAssessmentRating() {
    // Arrange
    ImmutableFlowClassificationRuleView immutableFlowClassificationRuleView =
        ImmutableFlowClassificationRuleView.builder().build();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    ImmutableFlowClassificationRuleView actualWithAssessmentRatingsResult =
        immutableFlowClassificationRuleView.withAssessmentRatings(
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

    // Assert
    assertEquals(1, actualWithAssessmentRatingsResult.assessmentRatings().size());
    Set<DataType> dataTypesResult = actualWithAssessmentRatingsResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualWithAssessmentRatingsResult.flowClassificationRules());
    assertSame(dataTypesResult, actualWithAssessmentRatingsResult.flowClassifications());
    assertSame(dataTypesResult, actualWithAssessmentRatingsResult.primaryAssessmentDefinitions());
    assertSame(dataTypesResult, actualWithAssessmentRatingsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#withDataTypes(DataType[])} with {@code
   * DataType[]}.
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleView#withDataTypes(DataType[])}
   */
  @Test
  @DisplayName("Test withDataTypes(DataType[]) with 'DataType[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.withDataTypes(DataType[])"
  })
  void testWithDataTypesWithDataType() {
    // Arrange
    ImmutableFlowClassificationRuleView immutableFlowClassificationRuleView =
        ImmutableFlowClassificationRuleView.builder().build();

    // Act
    ImmutableFlowClassificationRuleView actualWithDataTypesResult =
        immutableFlowClassificationRuleView.withDataTypes(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Assert
    assertEquals(1, actualWithDataTypesResult.dataTypes().size());
    Set<AssessmentRating> assessmentRatingsResult = actualWithDataTypesResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualWithDataTypesResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualWithDataTypesResult.flowClassifications());
    assertSame(assessmentRatingsResult, actualWithDataTypesResult.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualWithDataTypesResult.ratingSchemeItems());
  }

  /**
   * Test {@link
   * ImmutableFlowClassificationRuleView#withFlowClassificationRules(FlowClassificationRule[])} with
   * {@code FlowClassificationRule[]}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleView#withFlowClassificationRules(FlowClassificationRule[])}
   */
  @Test
  @DisplayName(
      "Test withFlowClassificationRules(FlowClassificationRule[]) with 'FlowClassificationRule[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.withFlowClassificationRules(FlowClassificationRule[])"
  })
  void testWithFlowClassificationRulesWithFlowClassificationRule() {
    // Arrange
    ImmutableFlowClassificationRuleView immutableFlowClassificationRuleView =
        ImmutableFlowClassificationRuleView.builder().build();

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

    // Act
    ImmutableFlowClassificationRuleView actualWithFlowClassificationRulesResult =
        immutableFlowClassificationRuleView.withFlowClassificationRules(
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

    // Assert
    assertEquals(1, actualWithFlowClassificationRulesResult.flowClassificationRules().size());
    Set<AssessmentRating> assessmentRatingsResult =
        actualWithFlowClassificationRulesResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualWithFlowClassificationRulesResult.dataTypes());
    assertSame(
        assessmentRatingsResult, actualWithFlowClassificationRulesResult.flowClassifications());
    assertSame(
        assessmentRatingsResult,
        actualWithFlowClassificationRulesResult.primaryAssessmentDefinitions());
    assertSame(
        assessmentRatingsResult, actualWithFlowClassificationRulesResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#withFlowClassifications(FlowClassification[])}
   * with {@code FlowClassification[]}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleView#withFlowClassifications(FlowClassification[])}
   */
  @Test
  @DisplayName("Test withFlowClassifications(FlowClassification[]) with 'FlowClassification[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.withFlowClassifications(FlowClassification[])"
  })
  void testWithFlowClassificationsWithFlowClassification() {
    // Arrange
    ImmutableFlowClassificationRuleView immutableFlowClassificationRuleView =
        ImmutableFlowClassificationRuleView.builder().build();

    // Act
    ImmutableFlowClassificationRuleView actualWithFlowClassificationsResult =
        immutableFlowClassificationRuleView.withFlowClassifications(
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

    // Assert
    assertEquals(1, actualWithFlowClassificationsResult.flowClassifications().size());
    Set<AssessmentRating> assessmentRatingsResult =
        actualWithFlowClassificationsResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualWithFlowClassificationsResult.dataTypes());
    assertSame(
        assessmentRatingsResult, actualWithFlowClassificationsResult.flowClassificationRules());
    assertSame(
        assessmentRatingsResult,
        actualWithFlowClassificationsResult.primaryAssessmentDefinitions());
    assertSame(assessmentRatingsResult, actualWithFlowClassificationsResult.ratingSchemeItems());
  }

  /**
   * Test {@link
   * ImmutableFlowClassificationRuleView#withPrimaryAssessmentDefinitions(AssessmentDefinition[])}
   * with {@code AssessmentDefinition[]}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleView#withPrimaryAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName(
      "Test withPrimaryAssessmentDefinitions(AssessmentDefinition[]) with 'AssessmentDefinition[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.withPrimaryAssessmentDefinitions(AssessmentDefinition[])"
  })
  void testWithPrimaryAssessmentDefinitionsWithAssessmentDefinition() {
    // Arrange
    ImmutableFlowClassificationRuleView immutableFlowClassificationRuleView =
        ImmutableFlowClassificationRuleView.builder().build();

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

    // Act
    ImmutableFlowClassificationRuleView actualWithPrimaryAssessmentDefinitionsResult =
        immutableFlowClassificationRuleView.withPrimaryAssessmentDefinitions(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals(
        1, actualWithPrimaryAssessmentDefinitionsResult.primaryAssessmentDefinitions().size());
    Set<AssessmentRating> assessmentRatingsResult =
        actualWithPrimaryAssessmentDefinitionsResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualWithPrimaryAssessmentDefinitionsResult.dataTypes());
    assertSame(
        assessmentRatingsResult,
        actualWithPrimaryAssessmentDefinitionsResult.flowClassificationRules());
    assertSame(
        assessmentRatingsResult,
        actualWithPrimaryAssessmentDefinitionsResult.flowClassifications());
    assertSame(
        assessmentRatingsResult, actualWithPrimaryAssessmentDefinitionsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleView#withRatingSchemeItems(RatingSchemeItem[])} with
   * {@code RatingSchemeItem[]}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleView#withRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test withRatingSchemeItems(RatingSchemeItem[]) with 'RatingSchemeItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleView ImmutableFlowClassificationRuleView.withRatingSchemeItems(RatingSchemeItem[])"
  })
  void testWithRatingSchemeItemsWithRatingSchemeItem() {
    // Arrange
    ImmutableFlowClassificationRuleView immutableFlowClassificationRuleView =
        ImmutableFlowClassificationRuleView.builder().build();

    // Act
    ImmutableFlowClassificationRuleView actualWithRatingSchemeItemsResult =
        immutableFlowClassificationRuleView.withRatingSchemeItems(
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

    // Assert
    assertEquals(1, actualWithRatingSchemeItemsResult.ratingSchemeItems().size());
    Set<AssessmentRating> assessmentRatingsResult =
        actualWithRatingSchemeItemsResult.assessmentRatings();
    assertTrue(assessmentRatingsResult.isEmpty());
    assertSame(assessmentRatingsResult, actualWithRatingSchemeItemsResult.dataTypes());
    assertSame(
        assessmentRatingsResult, actualWithRatingSchemeItemsResult.flowClassificationRules());
    assertSame(assessmentRatingsResult, actualWithRatingSchemeItemsResult.flowClassifications());
    assertSame(
        assessmentRatingsResult, actualWithRatingSchemeItemsResult.primaryAssessmentDefinitions());
  }
}
