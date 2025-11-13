package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FreshnessIndicator;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_rating.AssessmentRating;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowView.Builder;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlowView.Json;
import org.finos.waltz.model.physical_flow.CriticalityValue;
import org.finos.waltz.model.physical_flow.FrequencyKindValue;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlow;
import org.finos.waltz.model.physical_flow.PhysicalFlow;
import org.finos.waltz.model.physical_flow.TransportKindValue;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllLogicalFlowAssessmentDefinitions(Iterable)}.
   *
   * <p>Method under test: {@link Builder#addAllLogicalFlowAssessmentDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllLogicalFlowAssessmentDefinitions(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllLogicalFlowAssessmentDefinitions(Iterable)"})
  void testBuilderAddAllLogicalFlowAssessmentDefinitions() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    ImmutableLogicalFlowView immutableLogicalFlowView =
        builderResult.addAllLogicalFlowAssessmentDefinitions(new ArrayList<>()).build();
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult =
        immutableLogicalFlowView.logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        immutableLogicalFlowView.logicalFlowDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, immutableLogicalFlowView.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, immutableLogicalFlowView.logicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        immutableLogicalFlowView.physicalFlowAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, immutableLogicalFlowView.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, immutableLogicalFlowView.physicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        immutableLogicalFlowView.physicalSpecificationAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        immutableLogicalFlowView.physicalSpecificationDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        immutableLogicalFlowView.physicalSpecificationRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, immutableLogicalFlowView.physicalSpecifications());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, immutableLogicalFlowView.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#addLogicalFlowAssessmentDefinitions(AssessmentDefinition)} with
   * {@code element}.
   *
   * <p>Method under test: {@link Builder#addLogicalFlowAssessmentDefinitions(AssessmentDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder addLogicalFlowAssessmentDefinitions(AssessmentDefinition) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addLogicalFlowAssessmentDefinitions(AssessmentDefinition)"})
  void testBuilderAddLogicalFlowAssessmentDefinitionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

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
    Builder actualAddLogicalFlowAssessmentDefinitionsResult =
        builderResult.addLogicalFlowAssessmentDefinitions(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals(1, builderResult.build().logicalFlowAssessmentDefinitions().size());
    assertSame(builderResult, actualAddLogicalFlowAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addLogicalFlowAssessmentDefinitions(AssessmentDefinition[])} with
   * {@code elements}.
   *
   * <p>Method under test: {@link
   * Builder#addLogicalFlowAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName(
      "Test Builder addLogicalFlowAssessmentDefinitions(AssessmentDefinition[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addLogicalFlowAssessmentDefinitions(AssessmentDefinition[])"})
  void testBuilderAddLogicalFlowAssessmentDefinitionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

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
    Builder actualAddLogicalFlowAssessmentDefinitionsResult =
        builderResult.addLogicalFlowAssessmentDefinitions(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals(1, builderResult.build().logicalFlowAssessmentDefinitions().size());
    assertSame(builderResult, actualAddLogicalFlowAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addLogicalFlowDataTypeDecorators(DataTypeDecorator)} with {@code
   * element}.
   *
   * <p>Method under test: {@link Builder#addLogicalFlowDataTypeDecorators(DataTypeDecorator)}
   */
  @Test
  @DisplayName("Test Builder addLogicalFlowDataTypeDecorators(DataTypeDecorator) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addLogicalFlowDataTypeDecorators(DataTypeDecorator)"})
  void testBuilderAddLogicalFlowDataTypeDecoratorsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutableDataTypeDecorator.Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableDataTypeDecorator.Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    ImmutableDataTypeDecorator.Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    Builder actualAddLogicalFlowDataTypeDecoratorsResult =
        builderResult.addLogicalFlowDataTypeDecorators(
            ratingResult.targetInboundRating(targetInboundRating).build());

    // Assert
    assertEquals(1, builderResult.build().logicalFlowDataTypeDecorators().size());
    assertSame(builderResult, actualAddLogicalFlowDataTypeDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addLogicalFlowDataTypeDecorators(DataTypeDecorator[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link Builder#addLogicalFlowDataTypeDecorators(DataTypeDecorator[])}
   */
  @Test
  @DisplayName("Test Builder addLogicalFlowDataTypeDecorators(DataTypeDecorator[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addLogicalFlowDataTypeDecorators(DataTypeDecorator[])"})
  void testBuilderAddLogicalFlowDataTypeDecoratorsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutableDataTypeDecorator.Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableDataTypeDecorator.Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    ImmutableDataTypeDecorator.Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    Builder actualAddLogicalFlowDataTypeDecoratorsResult =
        builderResult.addLogicalFlowDataTypeDecorators(
            ratingResult.targetInboundRating(targetInboundRating).build());

    // Assert
    assertEquals(1, builderResult.build().logicalFlowDataTypeDecorators().size());
    assertSame(builderResult, actualAddLogicalFlowDataTypeDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addLogicalFlowRatings(AssessmentRating)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addLogicalFlowRatings(AssessmentRating)}
   */
  @Test
  @DisplayName("Test Builder addLogicalFlowRatings(AssessmentRating) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addLogicalFlowRatings(AssessmentRating)"})
  void testBuilderAddLogicalFlowRatingsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    Builder actualAddLogicalFlowRatingsResult =
        builderResult.addLogicalFlowRatings(
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
    assertEquals(1, builderResult.build().logicalFlowRatings().size());
    assertSame(builderResult, actualAddLogicalFlowRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addLogicalFlowRatings(AssessmentRating[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addLogicalFlowRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test Builder addLogicalFlowRatings(AssessmentRating[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addLogicalFlowRatings(AssessmentRating[])"})
  void testBuilderAddLogicalFlowRatingsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    Builder actualAddLogicalFlowRatingsResult =
        builderResult.addLogicalFlowRatings(
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
    assertEquals(1, builderResult.build().logicalFlowRatings().size());
    assertSame(builderResult, actualAddLogicalFlowRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addLogicalFlows(LogicalFlow)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addLogicalFlows(LogicalFlow)}
   */
  @Test
  @DisplayName("Test Builder addLogicalFlows(LogicalFlow) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addLogicalFlows(LogicalFlow)"})
  void testBuilderAddLogicalFlowsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddLogicalFlowsResult =
        builderResult.addLogicalFlows(new ImmutableLogicalFlow.Json());

    // Assert
    assertEquals(1, builderResult.build().logicalFlows().size());
    assertSame(builderResult, actualAddLogicalFlowsResult);
  }

  /**
   * Test Builder {@link Builder#addLogicalFlows(LogicalFlow[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addLogicalFlows(LogicalFlow[])}
   */
  @Test
  @DisplayName("Test Builder addLogicalFlows(LogicalFlow[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addLogicalFlows(LogicalFlow[])"})
  void testBuilderAddLogicalFlowsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualAddLogicalFlowsResult =
        builderResult.addLogicalFlows(new ImmutableLogicalFlow.Json());

    // Assert
    assertEquals(1, builderResult.build().logicalFlows().size());
    assertSame(builderResult, actualAddLogicalFlowsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalFlowAssessmentDefinitions(AssessmentDefinition)} with
   * {@code element}.
   *
   * <p>Method under test: {@link
   * Builder#addPhysicalFlowAssessmentDefinitions(AssessmentDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder addPhysicalFlowAssessmentDefinitions(AssessmentDefinition) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPhysicalFlowAssessmentDefinitions(AssessmentDefinition)"})
  void testBuilderAddPhysicalFlowAssessmentDefinitionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

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
    Builder actualAddPhysicalFlowAssessmentDefinitionsResult =
        builderResult.addPhysicalFlowAssessmentDefinitions(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals(1, builderResult.build().physicalFlowAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPhysicalFlowAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalFlowAssessmentDefinitions(AssessmentDefinition[])} with
   * {@code elements}.
   *
   * <p>Method under test: {@link
   * Builder#addPhysicalFlowAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName(
      "Test Builder addPhysicalFlowAssessmentDefinitions(AssessmentDefinition[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.addPhysicalFlowAssessmentDefinitions(AssessmentDefinition[])"
  })
  void testBuilderAddPhysicalFlowAssessmentDefinitionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

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
    Builder actualAddPhysicalFlowAssessmentDefinitionsResult =
        builderResult.addPhysicalFlowAssessmentDefinitions(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals(1, builderResult.build().physicalFlowAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPhysicalFlowAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalFlowRatings(AssessmentRating)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addPhysicalFlowRatings(AssessmentRating)}
   */
  @Test
  @DisplayName("Test Builder addPhysicalFlowRatings(AssessmentRating) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPhysicalFlowRatings(AssessmentRating)"})
  void testBuilderAddPhysicalFlowRatingsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    Builder actualAddPhysicalFlowRatingsResult =
        builderResult.addPhysicalFlowRatings(
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
    assertEquals(1, builderResult.build().physicalFlowRatings().size());
    assertSame(builderResult, actualAddPhysicalFlowRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalFlowRatings(AssessmentRating[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addPhysicalFlowRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test Builder addPhysicalFlowRatings(AssessmentRating[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPhysicalFlowRatings(AssessmentRating[])"})
  void testBuilderAddPhysicalFlowRatingsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    Builder actualAddPhysicalFlowRatingsResult =
        builderResult.addPhysicalFlowRatings(
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
    assertEquals(1, builderResult.build().physicalFlowRatings().size());
    assertSame(builderResult, actualAddPhysicalFlowRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalFlows(PhysicalFlow)} with {@code element}.
   *
   * <ul>
   *   <li>Then builder build physicalFlows size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addPhysicalFlows(PhysicalFlow)}
   */
  @Test
  @DisplayName(
      "Test Builder addPhysicalFlows(PhysicalFlow) with 'element'; then builder build physicalFlows size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPhysicalFlows(PhysicalFlow)"})
  void testBuilderAddPhysicalFlowsWithElement_thenBuilderBuildPhysicalFlowsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutablePhysicalFlow.Builder basisOffsetResult =
        ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalFlow.Builder createdResult = basisOffsetResult.created(created);

    ImmutablePhysicalFlow.Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    ImmutablePhysicalFlow.Builder specificationIdResult =
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

    // Act
    Builder actualAddPhysicalFlowsResult =
        builderResult.addPhysicalFlows(
            specificationIdResult.transport(TransportKindValue.of("42")).build());

    // Assert
    assertEquals(1, builderResult.build().physicalFlows().size());
    assertSame(builderResult, actualAddPhysicalFlowsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalFlows(PhysicalFlow[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then builder build physicalFlows size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addPhysicalFlows(PhysicalFlow[])}
   */
  @Test
  @DisplayName(
      "Test Builder addPhysicalFlows(PhysicalFlow[]) with 'elements'; then builder build physicalFlows size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPhysicalFlows(PhysicalFlow[])"})
  void testBuilderAddPhysicalFlowsWithElements_thenBuilderBuildPhysicalFlowsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutablePhysicalFlow.Builder basisOffsetResult =
        ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalFlow.Builder createdResult = basisOffsetResult.created(created);

    ImmutablePhysicalFlow.Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    ImmutablePhysicalFlow.Builder specificationIdResult =
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

    // Act
    Builder actualAddPhysicalFlowsResult =
        builderResult.addPhysicalFlows(
            specificationIdResult.transport(TransportKindValue.of("42")).build());

    // Assert
    assertEquals(1, builderResult.build().physicalFlows().size());
    assertSame(builderResult, actualAddPhysicalFlowsResult);
  }

  /**
   * Test Builder {@link
   * Builder#addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition)} with {@code
   * element}.
   *
   * <p>Method under test: {@link
   * Builder#addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition)"
  })
  void testBuilderAddPhysicalSpecificationAssessmentDefinitionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

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
    Builder actualAddPhysicalSpecificationAssessmentDefinitionsResult =
        builderResult.addPhysicalSpecificationAssessmentDefinitions(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals(1, builderResult.build().physicalSpecificationAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPhysicalSpecificationAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link
   * Builder#addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link
   * Builder#addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName(
      "Test Builder addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.addPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[])"
  })
  void testBuilderAddPhysicalSpecificationAssessmentDefinitionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

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
    Builder actualAddPhysicalSpecificationAssessmentDefinitionsResult =
        builderResult.addPhysicalSpecificationAssessmentDefinitions(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals(1, builderResult.build().physicalSpecificationAssessmentDefinitions().size());
    assertSame(builderResult, actualAddPhysicalSpecificationAssessmentDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator)} with
   * {@code element}.
   *
   * <p>Method under test: {@link
   * Builder#addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator)}
   */
  @Test
  @DisplayName(
      "Test Builder addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator)"
  })
  void testBuilderAddPhysicalSpecificationDataTypeDecoratorsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutableDataTypeDecorator.Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableDataTypeDecorator.Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    ImmutableDataTypeDecorator.Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    Builder actualAddPhysicalSpecificationDataTypeDecoratorsResult =
        builderResult.addPhysicalSpecificationDataTypeDecorators(
            ratingResult.targetInboundRating(targetInboundRating).build());

    // Assert
    assertEquals(1, builderResult.build().physicalSpecificationDataTypeDecorators().size());
    assertSame(builderResult, actualAddPhysicalSpecificationDataTypeDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[])}
   * with {@code elements}.
   *
   * <p>Method under test: {@link
   * Builder#addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[])}
   */
  @Test
  @DisplayName(
      "Test Builder addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.addPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[])"
  })
  void testBuilderAddPhysicalSpecificationDataTypeDecoratorsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutableDataTypeDecorator.Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableDataTypeDecorator.Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    ImmutableDataTypeDecorator.Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    Builder actualAddPhysicalSpecificationDataTypeDecoratorsResult =
        builderResult.addPhysicalSpecificationDataTypeDecorators(
            ratingResult.targetInboundRating(targetInboundRating).build());

    // Assert
    assertEquals(1, builderResult.build().physicalSpecificationDataTypeDecorators().size());
    assertSame(builderResult, actualAddPhysicalSpecificationDataTypeDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalSpecificationRatings(AssessmentRating)} with {@code
   * element}.
   *
   * <p>Method under test: {@link Builder#addPhysicalSpecificationRatings(AssessmentRating)}
   */
  @Test
  @DisplayName("Test Builder addPhysicalSpecificationRatings(AssessmentRating) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPhysicalSpecificationRatings(AssessmentRating)"})
  void testBuilderAddPhysicalSpecificationRatingsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    Builder actualAddPhysicalSpecificationRatingsResult =
        builderResult.addPhysicalSpecificationRatings(
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
    assertEquals(1, builderResult.build().physicalSpecificationRatings().size());
    assertSame(builderResult, actualAddPhysicalSpecificationRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalSpecificationRatings(AssessmentRating[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link Builder#addPhysicalSpecificationRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test Builder addPhysicalSpecificationRatings(AssessmentRating[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPhysicalSpecificationRatings(AssessmentRating[])"})
  void testBuilderAddPhysicalSpecificationRatingsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    Builder actualAddPhysicalSpecificationRatingsResult =
        builderResult.addPhysicalSpecificationRatings(
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
    assertEquals(1, builderResult.build().physicalSpecificationRatings().size());
    assertSame(builderResult, actualAddPhysicalSpecificationRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalSpecifications(PhysicalSpecification)} with {@code
   * element}.
   *
   * <p>Method under test: {@link Builder#addPhysicalSpecifications(PhysicalSpecification)}
   */
  @Test
  @DisplayName("Test Builder addPhysicalSpecifications(PhysicalSpecification) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPhysicalSpecifications(PhysicalSpecification)"})
  void testBuilderAddPhysicalSpecificationsWithElement() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult2
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

    // Act
    Builder actualAddPhysicalSpecificationsResult =
        builderResult.addPhysicalSpecifications(
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

    // Assert
    assertEquals(1, builderResult.build().physicalSpecifications().size());
    assertSame(builderResult, actualAddPhysicalSpecificationsResult);
  }

  /**
   * Test Builder {@link Builder#addPhysicalSpecifications(PhysicalSpecification[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link Builder#addPhysicalSpecifications(PhysicalSpecification[])}
   */
  @Test
  @DisplayName("Test Builder addPhysicalSpecifications(PhysicalSpecification[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPhysicalSpecifications(PhysicalSpecification[])"})
  void testBuilderAddPhysicalSpecificationsWithElements() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult2
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

    // Act
    Builder actualAddPhysicalSpecificationsResult =
        builderResult.addPhysicalSpecifications(
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

    // Assert
    assertEquals(1, builderResult.build().physicalSpecifications().size());
    assertSame(builderResult, actualAddPhysicalSpecificationsResult);
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
    Builder builderResult = ImmutableLogicalFlowView.builder();

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
    Builder builderResult = ImmutableLogicalFlowView.builder();

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
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalFlowView Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableLogicalFlowView.builder().build().logicalFlowAssessmentDefinitions().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowView)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LogicalFlowView)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowView); when builder build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowView)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act
    Builder actualFromResult = builderResult.from(ImmutableLogicalFlowView.builder().build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#logicalFlowAssessmentDefinitions(Iterable)}.
   *
   * <p>Method under test: {@link Builder#logicalFlowAssessmentDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder logicalFlowAssessmentDefinitions(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.logicalFlowAssessmentDefinitions(Iterable)"})
  void testBuilderLogicalFlowAssessmentDefinitions() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    // Act and Assert
    ImmutableLogicalFlowView immutableLogicalFlowView =
        builderResult.logicalFlowAssessmentDefinitions(new ArrayList<>()).build();
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult =
        immutableLogicalFlowView.logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        immutableLogicalFlowView.logicalFlowDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, immutableLogicalFlowView.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, immutableLogicalFlowView.logicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        immutableLogicalFlowView.physicalFlowAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, immutableLogicalFlowView.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, immutableLogicalFlowView.physicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        immutableLogicalFlowView.physicalSpecificationAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        immutableLogicalFlowView.physicalSpecificationDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        immutableLogicalFlowView.physicalSpecificationRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, immutableLogicalFlowView.physicalSpecifications());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, immutableLogicalFlowView.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return logicalFlowAssessmentDefinitions Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#copyOf(LogicalFlowView)}
   */
  @Test
  @DisplayName(
      "Test copyOf(LogicalFlowView); when builder build; then return logicalFlowAssessmentDefinitions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalFlowView ImmutableLogicalFlowView.copyOf(LogicalFlowView)"})
  void testCopyOf_whenBuilderBuild_thenReturnLogicalFlowAssessmentDefinitionsEmpty() {
    // Arrange
    ImmutableLogicalFlowView instance = ImmutableLogicalFlowView.builder().build();

    // Act
    ImmutableLogicalFlowView actualCopyOfResult = ImmutableLogicalFlowView.copyOf(instance);

    // Assert
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult =
        actualCopyOfResult.logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.logicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualCopyOfResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlowRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualCopyOfResult.physicalSpecificationAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualCopyOfResult.physicalSpecificationDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecificationRatings());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.physicalSpecifications());
    assertSame(logicalFlowAssessmentDefinitionsResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}, and {@link
   * ImmutableLogicalFlowView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowView#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowView.equals(Object)",
    "int ImmutableLogicalFlowView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableLogicalFlowView immutableLogicalFlowView = ImmutableLogicalFlowView.builder().build();
    ImmutableLogicalFlowView immutableLogicalFlowView2 = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertEquals(immutableLogicalFlowView, immutableLogicalFlowView2);
    assertEquals(immutableLogicalFlowView.hashCode(), immutableLogicalFlowView2.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}, and {@link
   * ImmutableLogicalFlowView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowView#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowView.equals(Object)",
    "int ImmutableLogicalFlowView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableLogicalFlowView immutableLogicalFlowView = ImmutableLogicalFlowView.builder().build();

    // Act and Assert
    assertEquals(immutableLogicalFlowView, immutableLogicalFlowView);
    int expectedHashCodeResult = immutableLogicalFlowView.hashCode();
    assertEquals(expectedHashCodeResult, immutableLogicalFlowView.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowView.equals(Object)",
    "int ImmutableLogicalFlowView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult2
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
    builderResult.addLogicalFlows(
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

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableLogicalFlowView.builder().build());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowView.equals(Object)",
    "int ImmutableLogicalFlowView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutablePhysicalFlow.Builder basisOffsetResult =
        ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalFlow.Builder createdResult = basisOffsetResult.created(created);

    ImmutablePhysicalFlow.Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    ImmutablePhysicalFlow.Builder specificationIdResult =
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
    builderResult.addPhysicalFlows(
        specificationIdResult.transport(TransportKindValue.of("42")).build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableLogicalFlowView.builder().build());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowView.equals(Object)",
    "int ImmutableLogicalFlowView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult2
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
    builderResult.addPhysicalSpecifications(
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

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableLogicalFlowView.builder().build());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowView.equals(Object)",
    "int ImmutableLogicalFlowView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();
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
    assertNotEquals(builderResult.build(), ImmutableLogicalFlowView.builder().build());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowView.equals(Object)",
    "int ImmutableLogicalFlowView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutableDataTypeDecorator.Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableDataTypeDecorator.Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    ImmutableDataTypeDecorator.Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    builderResult.addLogicalFlowDataTypeDecorators(
        ratingResult.targetInboundRating(targetInboundRating).build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableLogicalFlowView.builder().build());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowView.equals(Object)",
    "int ImmutableLogicalFlowView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutableDataTypeDecorator.Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableDataTypeDecorator.Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    ImmutableDataTypeDecorator.Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    builderResult.addPhysicalSpecificationDataTypeDecorators(
        ratingResult.targetInboundRating(targetInboundRating).build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableLogicalFlowView.builder().build());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowView.equals(Object)",
    "int ImmutableLogicalFlowView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

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
    builderResult.addLogicalFlowAssessmentDefinitions(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableLogicalFlowView.builder().build());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowView.equals(Object)",
    "int ImmutableLogicalFlowView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

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
    builderResult.addPhysicalFlowAssessmentDefinitions(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableLogicalFlowView.builder().build());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowView.equals(Object)",
    "int ImmutableLogicalFlowView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

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
    builderResult.addPhysicalSpecificationAssessmentDefinitions(
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableLogicalFlowView.builder().build());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowView.equals(Object)",
    "int ImmutableLogicalFlowView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    builderResult.addLogicalFlowRatings(
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
    assertNotEquals(builderResult.build(), ImmutableLogicalFlowView.builder().build());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowView.equals(Object)",
    "int ImmutableLogicalFlowView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    builderResult.addPhysicalFlowRatings(
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
    assertNotEquals(builderResult.build(), ImmutableLogicalFlowView.builder().build());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowView.equals(Object)",
    "int ImmutableLogicalFlowView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowView.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    builderResult.addPhysicalSpecificationRatings(
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
    assertNotEquals(builderResult.build(), ImmutableLogicalFlowView.builder().build());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowView.equals(Object)",
    "int ImmutableLogicalFlowView.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableLogicalFlowView.builder().build(), null);
  }

  /**
   * Test {@link ImmutableLogicalFlowView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowView.equals(Object)",
    "int ImmutableLogicalFlowView.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLogicalFlowView.builder().build(), "Different type to ImmutableLogicalFlowView");
  }

  /**
   * Test {@link ImmutableLogicalFlowView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return logicalFlows is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return logicalFlows is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalFlowView ImmutableLogicalFlowView.fromJson(Json)"})
  void testFromJson_thenReturnLogicalFlowsIsHashSet() {
    // Arrange
    HashSet<LogicalFlow> logicalFlows = new HashSet<>();

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("at")
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
    logicalFlows.add(
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

    ImmutableLogicalFlow.Builder builderResult2 = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutableLogicalFlow.Builder provenanceResult2 =
        builderResult2
            .created(created2)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult2 =
        provenanceResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    logicalFlows.add(
        sourceResult2
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

    Json json = new Json();
    json.setLogicalFlows(logicalFlows);

    // Act
    ImmutableLogicalFlowView actualFromJsonResult = ImmutableLogicalFlowView.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.logicalFlowAssessmentDefinitions().isEmpty());
    assertEquals(logicalFlows, actualFromJsonResult.logicalFlows());
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, actualFromJsonResult.logicalFlowDataTypeDecorators());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.logicalFlowRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlowAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlowRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlows());
    assertSame(
        ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationDataTypeDecorators());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecifications());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return logicalFlows size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return logicalFlows size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalFlowView ImmutableLogicalFlowView.fromJson(Json)"})
  void testFromJson_thenReturnLogicalFlowsSizeIsOne() {
    // Arrange
    HashSet<LogicalFlow> logicalFlows = new HashSet<>();

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
    logicalFlows.add(
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

    Json json = new Json();
    json.setLogicalFlows(logicalFlows);

    // Act
    ImmutableLogicalFlowView actualFromJsonResult = ImmutableLogicalFlowView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.logicalFlows().size());
    assertTrue(actualFromJsonResult.logicalFlowAssessmentDefinitions().isEmpty());
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, actualFromJsonResult.logicalFlowDataTypeDecorators());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.logicalFlowRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlowAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlowRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalFlows());
    assertSame(
        ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationAssessmentDefinitions());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationDataTypeDecorators());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecificationRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.physicalSpecifications());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return logicalFlowDataTypeDecorators is {@link Json} (default constructor) {@link
   *       Json#logicalFlows}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return logicalFlowDataTypeDecorators is Json (default constructor) logicalFlows")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalFlowView ImmutableLogicalFlowView.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnLogicalFlowDataTypeDecoratorsIsJsonLogicalFlows() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableLogicalFlowView actualFromJsonResult = ImmutableLogicalFlowView.fromJson(json);

    // Assert
    Set<LogicalFlow> logicalFlowSet = json.logicalFlows;
    assertSame(logicalFlowSet, actualFromJsonResult.logicalFlowDataTypeDecorators());
    assertSame(logicalFlowSet, actualFromJsonResult.logicalFlowRatings());
    assertSame(logicalFlowSet, actualFromJsonResult.physicalFlowAssessmentDefinitions());
    assertSame(logicalFlowSet, actualFromJsonResult.physicalFlowRatings());
    assertSame(logicalFlowSet, actualFromJsonResult.physicalFlows());
    assertSame(logicalFlowSet, actualFromJsonResult.physicalSpecificationAssessmentDefinitions());
    assertSame(logicalFlowSet, actualFromJsonResult.physicalSpecificationDataTypeDecorators());
    assertSame(logicalFlowSet, actualFromJsonResult.physicalSpecificationRatings());
    assertSame(logicalFlowSet, actualFromJsonResult.physicalSpecifications());
    assertSame(logicalFlowSet, actualFromJsonResult.ratingSchemeItems());
    Set<RatingSchemeItem> expectedLogicalFlowsResult = json.ratingSchemeItems;
    assertSame(expectedLogicalFlowsResult, actualFromJsonResult.logicalFlows());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowView#toString()}
   *   <li>{@link ImmutableLogicalFlowView#logicalFlowAssessmentDefinitions()}
   *   <li>{@link ImmutableLogicalFlowView#logicalFlowDataTypeDecorators()}
   *   <li>{@link ImmutableLogicalFlowView#logicalFlowRatings()}
   *   <li>{@link ImmutableLogicalFlowView#logicalFlows()}
   *   <li>{@link ImmutableLogicalFlowView#physicalFlowAssessmentDefinitions()}
   *   <li>{@link ImmutableLogicalFlowView#physicalFlowRatings()}
   *   <li>{@link ImmutableLogicalFlowView#physicalFlows()}
   *   <li>{@link ImmutableLogicalFlowView#physicalSpecificationAssessmentDefinitions()}
   *   <li>{@link ImmutableLogicalFlowView#physicalSpecificationDataTypeDecorators()}
   *   <li>{@link ImmutableLogicalFlowView#physicalSpecificationRatings()}
   *   <li>{@link ImmutableLogicalFlowView#physicalSpecifications()}
   *   <li>{@link ImmutableLogicalFlowView#ratingSchemeItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableLogicalFlowView.logicalFlowAssessmentDefinitions()",
    "Set ImmutableLogicalFlowView.logicalFlowDataTypeDecorators()",
    "Set ImmutableLogicalFlowView.logicalFlowRatings()",
    "Set ImmutableLogicalFlowView.logicalFlows()",
    "Set ImmutableLogicalFlowView.physicalFlowAssessmentDefinitions()",
    "Set ImmutableLogicalFlowView.physicalFlowRatings()",
    "Set ImmutableLogicalFlowView.physicalFlows()",
    "Set ImmutableLogicalFlowView.physicalSpecificationAssessmentDefinitions()",
    "Set ImmutableLogicalFlowView.physicalSpecificationDataTypeDecorators()",
    "Set ImmutableLogicalFlowView.physicalSpecificationRatings()",
    "Set ImmutableLogicalFlowView.physicalSpecifications()",
    "Set ImmutableLogicalFlowView.ratingSchemeItems()",
    "String ImmutableLogicalFlowView.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableLogicalFlowView immutableLogicalFlowView = ImmutableLogicalFlowView.builder().build();

    // Act
    String actualToStringResult = immutableLogicalFlowView.toString();
    Set<AssessmentDefinition> actualLogicalFlowAssessmentDefinitionsResult =
        immutableLogicalFlowView.logicalFlowAssessmentDefinitions();
    Set<DataTypeDecorator> actualLogicalFlowDataTypeDecoratorsResult =
        immutableLogicalFlowView.logicalFlowDataTypeDecorators();
    Set<AssessmentRating> actualLogicalFlowRatingsResult =
        immutableLogicalFlowView.logicalFlowRatings();
    Set<LogicalFlow> actualLogicalFlowsResult = immutableLogicalFlowView.logicalFlows();
    Set<AssessmentDefinition> actualPhysicalFlowAssessmentDefinitionsResult =
        immutableLogicalFlowView.physicalFlowAssessmentDefinitions();
    Set<AssessmentRating> actualPhysicalFlowRatingsResult =
        immutableLogicalFlowView.physicalFlowRatings();
    Set<PhysicalFlow> actualPhysicalFlowsResult = immutableLogicalFlowView.physicalFlows();
    Set<AssessmentDefinition> actualPhysicalSpecificationAssessmentDefinitionsResult =
        immutableLogicalFlowView.physicalSpecificationAssessmentDefinitions();
    Set<DataTypeDecorator> actualPhysicalSpecificationDataTypeDecoratorsResult =
        immutableLogicalFlowView.physicalSpecificationDataTypeDecorators();
    Set<AssessmentRating> actualPhysicalSpecificationRatingsResult =
        immutableLogicalFlowView.physicalSpecificationRatings();
    Set<PhysicalSpecification> actualPhysicalSpecificationsResult =
        immutableLogicalFlowView.physicalSpecifications();
    Set<RatingSchemeItem> actualRatingSchemeItemsResult =
        immutableLogicalFlowView.ratingSchemeItems();

    // Assert
    assertEquals(
        "LogicalFlowView{logicalFlows=[], physicalFlows=[], physicalSpecifications=[], ratingSchemeItems=[],"
            + " logicalFlowDataTypeDecorators=[], physicalSpecificationDataTypeDecorators=[], logicalFlowAssessment"
            + "Definitions=[], physicalFlowAssessmentDefinitions=[], physicalSpecificationAssessmentDefinitions=[],"
            + " logicalFlowRatings=[], physicalFlowRatings=[], physicalSpecificationRatings=[]}",
        actualToStringResult);
    assertTrue(actualLogicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(
        actualLogicalFlowAssessmentDefinitionsResult, actualLogicalFlowDataTypeDecoratorsResult);
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualLogicalFlowRatingsResult);
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualLogicalFlowsResult);
    assertSame(
        actualLogicalFlowAssessmentDefinitionsResult,
        actualPhysicalFlowAssessmentDefinitionsResult);
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualPhysicalFlowRatingsResult);
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualPhysicalFlowsResult);
    assertSame(
        actualLogicalFlowAssessmentDefinitionsResult,
        actualPhysicalSpecificationAssessmentDefinitionsResult);
    assertSame(
        actualLogicalFlowAssessmentDefinitionsResult,
        actualPhysicalSpecificationDataTypeDecoratorsResult);
    assertSame(
        actualLogicalFlowAssessmentDefinitionsResult, actualPhysicalSpecificationRatingsResult);
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualPhysicalSpecificationsResult);
    assertSame(actualLogicalFlowAssessmentDefinitionsResult, actualRatingSchemeItemsResult);
  }

  /**
   * Test Json {@link Json#logicalFlowAssessmentDefinitions()}.
   *
   * <p>Method under test: {@link Json#logicalFlowAssessmentDefinitions()}
   */
  @Test
  @DisplayName("Test Json logicalFlowAssessmentDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.logicalFlowAssessmentDefinitions()"})
  void testJsonLogicalFlowAssessmentDefinitions() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().logicalFlowAssessmentDefinitions());
  }

  /**
   * Test Json {@link Json#logicalFlowDataTypeDecorators()}.
   *
   * <p>Method under test: {@link Json#logicalFlowDataTypeDecorators()}
   */
  @Test
  @DisplayName("Test Json logicalFlowDataTypeDecorators()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.logicalFlowDataTypeDecorators()"})
  void testJsonLogicalFlowDataTypeDecorators() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().logicalFlowDataTypeDecorators());
  }

  /**
   * Test Json {@link Json#logicalFlowRatings()}.
   *
   * <p>Method under test: {@link Json#logicalFlowRatings()}
   */
  @Test
  @DisplayName("Test Json logicalFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.logicalFlowRatings()"})
  void testJsonLogicalFlowRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().logicalFlowRatings());
  }

  /**
   * Test Json {@link Json#logicalFlows()}.
   *
   * <p>Method under test: {@link Json#logicalFlows()}
   */
  @Test
  @DisplayName("Test Json logicalFlows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.logicalFlows()"})
  void testJsonLogicalFlows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().logicalFlows());
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
    assertTrue(actualJson.logicalFlowAssessmentDefinitions.isEmpty());
    assertTrue(actualJson.logicalFlowDataTypeDecorators.isEmpty());
    assertTrue(actualJson.logicalFlowRatings.isEmpty());
    assertTrue(actualJson.logicalFlows.isEmpty());
    assertTrue(actualJson.physicalFlowAssessmentDefinitions.isEmpty());
    assertTrue(actualJson.physicalFlowRatings.isEmpty());
    assertTrue(actualJson.physicalFlows.isEmpty());
    assertTrue(actualJson.physicalSpecificationAssessmentDefinitions.isEmpty());
    assertTrue(actualJson.physicalSpecificationDataTypeDecorators.isEmpty());
    assertTrue(actualJson.physicalSpecificationRatings.isEmpty());
    assertTrue(actualJson.physicalSpecifications.isEmpty());
    assertTrue(actualJson.ratingSchemeItems.isEmpty());
  }

  /**
   * Test Json {@link Json#physicalFlowAssessmentDefinitions()}.
   *
   * <p>Method under test: {@link Json#physicalFlowAssessmentDefinitions()}
   */
  @Test
  @DisplayName("Test Json physicalFlowAssessmentDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.physicalFlowAssessmentDefinitions()"})
  void testJsonPhysicalFlowAssessmentDefinitions() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().physicalFlowAssessmentDefinitions());
  }

  /**
   * Test Json {@link Json#physicalFlowRatings()}.
   *
   * <p>Method under test: {@link Json#physicalFlowRatings()}
   */
  @Test
  @DisplayName("Test Json physicalFlowRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.physicalFlowRatings()"})
  void testJsonPhysicalFlowRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().physicalFlowRatings());
  }

  /**
   * Test Json {@link Json#physicalFlows()}.
   *
   * <p>Method under test: {@link Json#physicalFlows()}
   */
  @Test
  @DisplayName("Test Json physicalFlows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.physicalFlows()"})
  void testJsonPhysicalFlows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().physicalFlows());
  }

  /**
   * Test Json {@link Json#physicalSpecificationAssessmentDefinitions()}.
   *
   * <p>Method under test: {@link Json#physicalSpecificationAssessmentDefinitions()}
   */
  @Test
  @DisplayName("Test Json physicalSpecificationAssessmentDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.physicalSpecificationAssessmentDefinitions()"})
  void testJsonPhysicalSpecificationAssessmentDefinitions() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new Json().physicalSpecificationAssessmentDefinitions());
  }

  /**
   * Test Json {@link Json#physicalSpecificationDataTypeDecorators()}.
   *
   * <p>Method under test: {@link Json#physicalSpecificationDataTypeDecorators()}
   */
  @Test
  @DisplayName("Test Json physicalSpecificationDataTypeDecorators()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.physicalSpecificationDataTypeDecorators()"})
  void testJsonPhysicalSpecificationDataTypeDecorators() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new Json().physicalSpecificationDataTypeDecorators());
  }

  /**
   * Test Json {@link Json#physicalSpecificationRatings()}.
   *
   * <p>Method under test: {@link Json#physicalSpecificationRatings()}
   */
  @Test
  @DisplayName("Test Json physicalSpecificationRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.physicalSpecificationRatings()"})
  void testJsonPhysicalSpecificationRatings() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().physicalSpecificationRatings());
  }

  /**
   * Test Json {@link Json#physicalSpecifications()}.
   *
   * <p>Method under test: {@link Json#physicalSpecifications()}
   */
  @Test
  @DisplayName("Test Json physicalSpecifications()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.physicalSpecifications()"})
  void testJsonPhysicalSpecifications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().physicalSpecifications());
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
   * Test {@link
   * ImmutableLogicalFlowView#withLogicalFlowAssessmentDefinitions(AssessmentDefinition[])} with
   * {@code AssessmentDefinition[]}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowView#withLogicalFlowAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName(
      "Test withLogicalFlowAssessmentDefinitions(AssessmentDefinition[]) with 'AssessmentDefinition[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowView ImmutableLogicalFlowView.withLogicalFlowAssessmentDefinitions(AssessmentDefinition[])"
  })
  void testWithLogicalFlowAssessmentDefinitionsWithAssessmentDefinition() {
    // Arrange
    ImmutableLogicalFlowView immutableLogicalFlowView = ImmutableLogicalFlowView.builder().build();

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
    ImmutableLogicalFlowView actualWithLogicalFlowAssessmentDefinitionsResult =
        immutableLogicalFlowView.withLogicalFlowAssessmentDefinitions(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals(
        1,
        actualWithLogicalFlowAssessmentDefinitionsResult.logicalFlowAssessmentDefinitions().size());
    Set<DataTypeDecorator> logicalFlowDataTypeDecoratorsResult =
        actualWithLogicalFlowAssessmentDefinitionsResult.logicalFlowDataTypeDecorators();
    assertTrue(logicalFlowDataTypeDecoratorsResult.isEmpty());
    assertSame(
        logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.logicalFlowRatings());
    assertSame(
        logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.logicalFlows());
    assertSame(
        logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.physicalFlowAssessmentDefinitions());
    assertSame(
        logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.physicalFlowRatings());
    assertSame(
        logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.physicalFlows());
    assertSame(
        logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult
            .physicalSpecificationAssessmentDefinitions());
    assertSame(
        logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.physicalSpecificationDataTypeDecorators());
    assertSame(
        logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.physicalSpecificationRatings());
    assertSame(
        logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.physicalSpecifications());
    assertSame(
        logicalFlowDataTypeDecoratorsResult,
        actualWithLogicalFlowAssessmentDefinitionsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withLogicalFlowDataTypeDecorators(DataTypeDecorator[])}
   * with {@code DataTypeDecorator[]}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowView#withLogicalFlowDataTypeDecorators(DataTypeDecorator[])}
   */
  @Test
  @DisplayName(
      "Test withLogicalFlowDataTypeDecorators(DataTypeDecorator[]) with 'DataTypeDecorator[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowView ImmutableLogicalFlowView.withLogicalFlowDataTypeDecorators(DataTypeDecorator[])"
  })
  void testWithLogicalFlowDataTypeDecoratorsWithDataTypeDecorator() {
    // Arrange
    ImmutableLogicalFlowView immutableLogicalFlowView = ImmutableLogicalFlowView.builder().build();

    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableDataTypeDecorator.Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    ImmutableDataTypeDecorator.Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    ImmutableLogicalFlowView actualWithLogicalFlowDataTypeDecoratorsResult =
        immutableLogicalFlowView.withLogicalFlowDataTypeDecorators(
            ratingResult.targetInboundRating(targetInboundRating).build());

    // Assert
    assertEquals(
        1, actualWithLogicalFlowDataTypeDecoratorsResult.logicalFlowDataTypeDecorators().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult =
        actualWithLogicalFlowDataTypeDecoratorsResult.logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.logicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.logicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.physicalFlowAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.physicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.physicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.physicalSpecificationDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.physicalSpecificationRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.physicalSpecifications());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowDataTypeDecoratorsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withLogicalFlowRatings(AssessmentRating[])} with {@code
   * AssessmentRating[]}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowView#withLogicalFlowRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test withLogicalFlowRatings(AssessmentRating[]) with 'AssessmentRating[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowView ImmutableLogicalFlowView.withLogicalFlowRatings(AssessmentRating[])"
  })
  void testWithLogicalFlowRatingsWithAssessmentRating() {
    // Arrange
    ImmutableLogicalFlowView immutableLogicalFlowView = ImmutableLogicalFlowView.builder().build();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    ImmutableLogicalFlowView actualWithLogicalFlowRatingsResult =
        immutableLogicalFlowView.withLogicalFlowRatings(
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
    assertEquals(1, actualWithLogicalFlowRatingsResult.logicalFlowRatings().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult =
        actualWithLogicalFlowRatingsResult.logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowRatingsResult.logicalFlowDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowRatingsResult.logicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowRatingsResult.physicalFlowAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowRatingsResult.physicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowRatingsResult.physicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowRatingsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowRatingsResult.physicalSpecificationDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowRatingsResult.physicalSpecificationRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowRatingsResult.physicalSpecifications());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowRatingsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withLogicalFlows(LogicalFlow[])} with {@code
   * LogicalFlow[]}.
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#withLogicalFlows(LogicalFlow[])}
   */
  @Test
  @DisplayName("Test withLogicalFlows(LogicalFlow[]) with 'LogicalFlow[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowView ImmutableLogicalFlowView.withLogicalFlows(LogicalFlow[])"
  })
  void testWithLogicalFlowsWithLogicalFlow() {
    // Arrange
    ImmutableLogicalFlowView immutableLogicalFlowView = ImmutableLogicalFlowView.builder().build();

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

    // Act
    ImmutableLogicalFlowView actualWithLogicalFlowsResult =
        immutableLogicalFlowView.withLogicalFlows(
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

    // Assert
    assertEquals(1, actualWithLogicalFlowsResult.logicalFlows().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult =
        actualWithLogicalFlowsResult.logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowsResult.logicalFlowDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowsResult.logicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowsResult.physicalFlowAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowsResult.physicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowsResult.physicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowsResult.physicalSpecificationDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowsResult.physicalSpecificationRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithLogicalFlowsResult.physicalSpecifications());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, actualWithLogicalFlowsResult.ratingSchemeItems());
  }

  /**
   * Test {@link
   * ImmutableLogicalFlowView#withPhysicalFlowAssessmentDefinitions(AssessmentDefinition[])} with
   * {@code AssessmentDefinition[]}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowView#withPhysicalFlowAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName(
      "Test withPhysicalFlowAssessmentDefinitions(AssessmentDefinition[]) with 'AssessmentDefinition[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowView ImmutableLogicalFlowView.withPhysicalFlowAssessmentDefinitions(AssessmentDefinition[])"
  })
  void testWithPhysicalFlowAssessmentDefinitionsWithAssessmentDefinition() {
    // Arrange
    ImmutableLogicalFlowView immutableLogicalFlowView = ImmutableLogicalFlowView.builder().build();

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
    ImmutableLogicalFlowView actualWithPhysicalFlowAssessmentDefinitionsResult =
        immutableLogicalFlowView.withPhysicalFlowAssessmentDefinitions(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals(
        1,
        actualWithPhysicalFlowAssessmentDefinitionsResult
            .physicalFlowAssessmentDefinitions()
            .size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult =
        actualWithPhysicalFlowAssessmentDefinitionsResult.logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.logicalFlowDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.logicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.logicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.physicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.physicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult
            .physicalSpecificationAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult
            .physicalSpecificationDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.physicalSpecificationRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.physicalSpecifications());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowAssessmentDefinitionsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withPhysicalFlowRatings(AssessmentRating[])} with {@code
   * AssessmentRating[]}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowView#withPhysicalFlowRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName("Test withPhysicalFlowRatings(AssessmentRating[]) with 'AssessmentRating[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowView ImmutableLogicalFlowView.withPhysicalFlowRatings(AssessmentRating[])"
  })
  void testWithPhysicalFlowRatingsWithAssessmentRating() {
    // Arrange
    ImmutableLogicalFlowView immutableLogicalFlowView = ImmutableLogicalFlowView.builder().build();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    ImmutableLogicalFlowView actualWithPhysicalFlowRatingsResult =
        immutableLogicalFlowView.withPhysicalFlowRatings(
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
    assertEquals(1, actualWithPhysicalFlowRatingsResult.physicalFlowRatings().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult =
        actualWithPhysicalFlowRatingsResult.logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowRatingsResult.logicalFlowDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowRatingsResult.logicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, actualWithPhysicalFlowRatingsResult.logicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowRatingsResult.physicalFlowAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowRatingsResult.physicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowRatingsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowRatingsResult.physicalSpecificationDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowRatingsResult.physicalSpecificationRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowRatingsResult.physicalSpecifications());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowRatingsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withPhysicalFlows(PhysicalFlow[])} with {@code
   * PhysicalFlow[]}.
   *
   * <p>Method under test: {@link ImmutableLogicalFlowView#withPhysicalFlows(PhysicalFlow[])}
   */
  @Test
  @DisplayName("Test withPhysicalFlows(PhysicalFlow[]) with 'PhysicalFlow[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowView ImmutableLogicalFlowView.withPhysicalFlows(PhysicalFlow[])"
  })
  void testWithPhysicalFlowsWithPhysicalFlow() {
    // Arrange
    ImmutableLogicalFlowView immutableLogicalFlowView = ImmutableLogicalFlowView.builder().build();

    ImmutablePhysicalFlow.Builder basisOffsetResult =
        ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalFlow.Builder createdResult = basisOffsetResult.created(created);

    ImmutablePhysicalFlow.Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    ImmutablePhysicalFlow.Builder specificationIdResult =
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

    // Act
    ImmutableLogicalFlowView actualWithPhysicalFlowsResult =
        immutableLogicalFlowView.withPhysicalFlows(
            specificationIdResult.transport(TransportKindValue.of("42")).build());

    // Assert
    assertEquals(1, actualWithPhysicalFlowsResult.physicalFlows().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult =
        actualWithPhysicalFlowsResult.logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowsResult.logicalFlowDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, actualWithPhysicalFlowsResult.logicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, actualWithPhysicalFlowsResult.logicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowsResult.physicalFlowAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowsResult.physicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowsResult.physicalSpecificationDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowsResult.physicalSpecificationRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalFlowsResult.physicalSpecifications());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, actualWithPhysicalFlowsResult.ratingSchemeItems());
  }

  /**
   * Test {@link
   * ImmutableLogicalFlowView#withPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[])}
   * with {@code AssessmentDefinition[]}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowView#withPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[])}
   */
  @Test
  @DisplayName(
      "Test withPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[]) with 'AssessmentDefinition[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowView ImmutableLogicalFlowView.withPhysicalSpecificationAssessmentDefinitions(AssessmentDefinition[])"
  })
  void testWithPhysicalSpecificationAssessmentDefinitionsWithAssessmentDefinition() {
    // Arrange
    ImmutableLogicalFlowView immutableLogicalFlowView = ImmutableLogicalFlowView.builder().build();

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
    ImmutableLogicalFlowView actualWithPhysicalSpecificationAssessmentDefinitionsResult =
        immutableLogicalFlowView.withPhysicalSpecificationAssessmentDefinitions(
            provenanceResult
                .qualifierReference(qualifierReference)
                .ratingSchemeId(1L)
                .visibility(AssessmentVisibility.PRIMARY)
                .build());

    // Assert
    assertEquals(
        1,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult
            .physicalSpecificationAssessmentDefinitions()
            .size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult =
        actualWithPhysicalSpecificationAssessmentDefinitionsResult
            .logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.logicalFlowDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.logicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.logicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult
            .physicalFlowAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.physicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.physicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult
            .physicalSpecificationDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.physicalSpecificationRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.physicalSpecifications());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationAssessmentDefinitionsResult.ratingSchemeItems());
  }

  /**
   * Test {@link
   * ImmutableLogicalFlowView#withPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[])} with
   * {@code DataTypeDecorator[]}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowView#withPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[])}
   */
  @Test
  @DisplayName(
      "Test withPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[]) with 'DataTypeDecorator[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowView ImmutableLogicalFlowView.withPhysicalSpecificationDataTypeDecorators(DataTypeDecorator[])"
  })
  void testWithPhysicalSpecificationDataTypeDecoratorsWithDataTypeDecorator() {
    // Arrange
    ImmutableLogicalFlowView immutableLogicalFlowView = ImmutableLogicalFlowView.builder().build();

    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableDataTypeDecorator.Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    ImmutableDataTypeDecorator.Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    // Act
    ImmutableLogicalFlowView actualWithPhysicalSpecificationDataTypeDecoratorsResult =
        immutableLogicalFlowView.withPhysicalSpecificationDataTypeDecorators(
            ratingResult.targetInboundRating(targetInboundRating).build());

    // Assert
    assertEquals(
        1,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult
            .physicalSpecificationDataTypeDecorators()
            .size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult =
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.logicalFlowDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.logicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.logicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult
            .physicalFlowAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.physicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.physicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult
            .physicalSpecificationAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.physicalSpecificationRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.physicalSpecifications());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationDataTypeDecoratorsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withPhysicalSpecificationRatings(AssessmentRating[])} with
   * {@code AssessmentRating[]}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowView#withPhysicalSpecificationRatings(AssessmentRating[])}
   */
  @Test
  @DisplayName(
      "Test withPhysicalSpecificationRatings(AssessmentRating[]) with 'AssessmentRating[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowView ImmutableLogicalFlowView.withPhysicalSpecificationRatings(AssessmentRating[])"
  })
  void testWithPhysicalSpecificationRatingsWithAssessmentRating() {
    // Arrange
    ImmutableLogicalFlowView immutableLogicalFlowView = ImmutableLogicalFlowView.builder().build();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    ImmutableLogicalFlowView actualWithPhysicalSpecificationRatingsResult =
        immutableLogicalFlowView.withPhysicalSpecificationRatings(
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
    assertEquals(
        1, actualWithPhysicalSpecificationRatingsResult.physicalSpecificationRatings().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult =
        actualWithPhysicalSpecificationRatingsResult.logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.logicalFlowDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.logicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.logicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.physicalFlowAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.physicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.physicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.physicalSpecificationDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.physicalSpecifications());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationRatingsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withPhysicalSpecifications(PhysicalSpecification[])} with
   * {@code PhysicalSpecification[]}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowView#withPhysicalSpecifications(PhysicalSpecification[])}
   */
  @Test
  @DisplayName(
      "Test withPhysicalSpecifications(PhysicalSpecification[]) with 'PhysicalSpecification[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowView ImmutableLogicalFlowView.withPhysicalSpecifications(PhysicalSpecification[])"
  })
  void testWithPhysicalSpecificationsWithPhysicalSpecification() {
    // Arrange
    ImmutableLogicalFlowView immutableLogicalFlowView = ImmutableLogicalFlowView.builder().build();

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

    // Act
    ImmutableLogicalFlowView actualWithPhysicalSpecificationsResult =
        immutableLogicalFlowView.withPhysicalSpecifications(
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

    // Assert
    assertEquals(1, actualWithPhysicalSpecificationsResult.physicalSpecifications().size());
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult =
        actualWithPhysicalSpecificationsResult.logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationsResult.logicalFlowDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationsResult.logicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationsResult.logicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationsResult.physicalFlowAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationsResult.physicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationsResult.physicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationsResult.physicalSpecificationDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationsResult.physicalSpecificationRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithPhysicalSpecificationsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableLogicalFlowView#withRatingSchemeItems(RatingSchemeItem[])} with {@code
   * RatingSchemeItem[]}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowView#withRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test withRatingSchemeItems(RatingSchemeItem[]) with 'RatingSchemeItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowView ImmutableLogicalFlowView.withRatingSchemeItems(RatingSchemeItem[])"
  })
  void testWithRatingSchemeItemsWithRatingSchemeItem() {
    // Arrange
    ImmutableLogicalFlowView immutableLogicalFlowView = ImmutableLogicalFlowView.builder().build();

    // Act
    ImmutableLogicalFlowView actualWithRatingSchemeItemsResult =
        immutableLogicalFlowView.withRatingSchemeItems(
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
    Set<AssessmentDefinition> logicalFlowAssessmentDefinitionsResult =
        actualWithRatingSchemeItemsResult.logicalFlowAssessmentDefinitions();
    assertTrue(logicalFlowAssessmentDefinitionsResult.isEmpty());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithRatingSchemeItemsResult.logicalFlowDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithRatingSchemeItemsResult.logicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, actualWithRatingSchemeItemsResult.logicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithRatingSchemeItemsResult.physicalFlowAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithRatingSchemeItemsResult.physicalFlowRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult, actualWithRatingSchemeItemsResult.physicalFlows());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithRatingSchemeItemsResult.physicalSpecificationAssessmentDefinitions());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithRatingSchemeItemsResult.physicalSpecificationDataTypeDecorators());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithRatingSchemeItemsResult.physicalSpecificationRatings());
    assertSame(
        logicalFlowAssessmentDefinitionsResult,
        actualWithRatingSchemeItemsResult.physicalSpecifications());
  }
}
