package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.application.AssessmentsView;
import org.finos.waltz.model.application.ImmutableAssessmentsView;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.datatype.ImmutableDataType;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator;
import org.finos.waltz.model.flow_classification.FlowClassification;
import org.finos.waltz.model.flow_classification.ImmutableFlowClassification;
import org.finos.waltz.model.logical_flow.ImmutableDataTypeDecoratorView.Builder;
import org.finos.waltz.model.logical_flow.ImmutableDataTypeDecoratorView.Json;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDecoratorViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllClassifications(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllClassifications(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllClassifications(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllClassifications(Iterable)"})
  void testBuilderAddAllClassifications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act
    Builder actualAddAllClassificationsResult =
        builderResult.addAllClassifications(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllClassificationsResult);
  }

  /**
   * Test Builder {@link Builder#addAllDataTypeDecorators(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllDataTypeDecorators(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllDataTypeDecorators(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllDataTypeDecorators(Iterable)"})
  void testBuilderAddAllDataTypeDecorators_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act
    Builder actualAddAllDataTypeDecoratorsResult =
        builderResult.addAllDataTypeDecorators(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllDataTypeDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addAllDataTypes(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllDataTypes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDataTypes(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllDataTypes(Iterable)"})
  void testBuilderAddAllDataTypes_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act
    Builder actualAddAllDataTypesResult = builderResult.addAllDataTypes(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllDataTypesResult);
  }

  /**
   * Test Builder {@link Builder#addClassifications(FlowClassification)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addClassifications(FlowClassification)}
   */
  @Test
  @DisplayName(
      "Test Builder addClassifications(FlowClassification) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addClassifications(FlowClassification)"})
  void testBuilderAddClassificationsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act
    Builder actualAddClassificationsResult =
        builderResult.addClassifications(
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
    assertSame(builderResult, actualAddClassificationsResult);
  }

  /**
   * Test Builder {@link Builder#addClassifications(FlowClassification[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addClassifications(FlowClassification[])}
   */
  @Test
  @DisplayName(
      "Test Builder addClassifications(FlowClassification[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addClassifications(FlowClassification[])"})
  void testBuilderAddClassificationsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act
    Builder actualAddClassificationsResult =
        builderResult.addClassifications(
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
    assertSame(builderResult, actualAddClassificationsResult);
  }

  /**
   * Test Builder {@link Builder#addDataTypeDecorators(DataTypeDecorator)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addDataTypeDecorators(DataTypeDecorator)}
   */
  @Test
  @DisplayName(
      "Test Builder addDataTypeDecorators(DataTypeDecorator) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDataTypeDecorators(DataTypeDecorator)"})
  void testBuilderAddDataTypeDecoratorsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

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
    Builder actualAddDataTypeDecoratorsResult =
        builderResult.addDataTypeDecorators(
            ratingResult.targetInboundRating(targetInboundRating).build());

    // Assert
    assertSame(builderResult, actualAddDataTypeDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addDataTypeDecorators(DataTypeDecorator[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addDataTypeDecorators(DataTypeDecorator[])}
   */
  @Test
  @DisplayName(
      "Test Builder addDataTypeDecorators(DataTypeDecorator[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDataTypeDecorators(DataTypeDecorator[])"})
  void testBuilderAddDataTypeDecoratorsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

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
    Builder actualAddDataTypeDecoratorsResult =
        builderResult.addDataTypeDecorators(
            ratingResult.targetInboundRating(targetInboundRating).build());

    // Assert
    assertSame(builderResult, actualAddDataTypeDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addDataTypes(DataType)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addDataTypes(DataType)}
   */
  @Test
  @DisplayName("Test Builder addDataTypes(DataType) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDataTypes(DataType)"})
  void testBuilderAddDataTypesWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

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
    assertSame(builderResult, actualAddDataTypesResult);
  }

  /**
   * Test Builder {@link Builder#addDataTypes(DataType[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addDataTypes(DataType[])}
   */
  @Test
  @DisplayName("Test Builder addDataTypes(DataType[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDataTypes(DataType[])"})
  void testBuilderAddDataTypesWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

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
    assertSame(builderResult, actualAddDataTypesResult);
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
  @MethodsUnderTest({"ImmutableDataTypeDecoratorView Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    ImmutableFlowClassificationRulesView flowClassificationRules =
        ImmutableFlowClassificationRulesView.builder().build();
    ImmutableAssessmentsView primaryAssessments = ImmutableAssessmentsView.builder().build();

    // Act
    ImmutableDataTypeDecoratorView actualImmutableDataTypeDecoratorView =
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(flowClassificationRules)
            .primaryAssessments(primaryAssessments)
            .build();

    // Assert
    assertTrue(actualImmutableDataTypeDecoratorView.classifications().isEmpty());
    assertSame(primaryAssessments, actualImmutableDataTypeDecoratorView.primaryAssessments());
    assertSame(
        flowClassificationRules, actualImmutableDataTypeDecoratorView.flowClassificationRules());
  }

  /**
   * Test Builder {@link Builder#classifications(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#classifications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder classifications(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.classifications(Iterable)"})
  void testBuilderClassifications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act
    Builder actualClassificationsResult = builderResult.classifications(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualClassificationsResult);
  }

  /**
   * Test Builder {@link Builder#dataTypeDecorators(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dataTypeDecorators(Iterable)}
   */
  @Test
  @DisplayName("Test Builder dataTypeDecorators(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dataTypeDecorators(Iterable)"})
  void testBuilderDataTypeDecorators_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act
    Builder actualDataTypeDecoratorsResult = builderResult.dataTypeDecorators(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDataTypeDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#dataTypes(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dataTypes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder dataTypes(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dataTypes(Iterable)"})
  void testBuilderDataTypes_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act
    Builder actualDataTypesResult = builderResult.dataTypes(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDataTypesResult);
  }

  /**
   * Test Builder {@link Builder#flowClassificationRules(FlowClassificationRulesView)}.
   *
   * <p>Method under test: {@link Builder#flowClassificationRules(FlowClassificationRulesView)}
   */
  @Test
  @DisplayName("Test Builder flowClassificationRules(FlowClassificationRulesView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flowClassificationRules(FlowClassificationRulesView)"})
  void testBuilderFlowClassificationRules() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act
    Builder actualFlowClassificationRulesResult =
        builderResult.flowClassificationRules(new ImmutableFlowClassificationRulesView.Json());

    // Assert
    assertSame(builderResult, actualFlowClassificationRulesResult);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorView)}.
   *
   * <p>Method under test: {@link Builder#from(DataTypeDecoratorView)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorView)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();
    ImmutableDataTypeDecoratorView instance =
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDataTypeDecoratorView actualImmutableDataTypeDecoratorView = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeDecoratorView);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#primaryAssessments(AssessmentsView)}.
   *
   * <p>Method under test: {@link Builder#primaryAssessments(AssessmentsView)}
   */
  @Test
  @DisplayName("Test Builder primaryAssessments(AssessmentsView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.primaryAssessments(AssessmentsView)"})
  void testBuilderPrimaryAssessments() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

    // Act
    Builder actualPrimaryAssessmentsResult =
        builderResult.primaryAssessments(mock(AssessmentsView.class));

    // Assert
    assertSame(builderResult, actualPrimaryAssessmentsResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#copyOf(DataTypeDecoratorView)}.
   *
   * <ul>
   *   <li>Then primaryAssessments return {@link ImmutableAssessmentsView}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorView#copyOf(DataTypeDecoratorView)}
   */
  @Test
  @DisplayName(
      "Test copyOf(DataTypeDecoratorView); then primaryAssessments return ImmutableAssessmentsView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorView ImmutableDataTypeDecoratorView.copyOf(DataTypeDecoratorView)"
  })
  void testCopyOf_thenPrimaryAssessmentsReturnImmutableAssessmentsView() {
    // Arrange
    ImmutableDataTypeDecoratorView instance =
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build();

    // Act
    ImmutableDataTypeDecoratorView actualCopyOfResult =
        ImmutableDataTypeDecoratorView.copyOf(instance);

    // Assert
    AssessmentsView primaryAssessmentsResult = actualCopyOfResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    FlowClassificationRulesView flowClassificationRulesResult =
        actualCopyOfResult.flowClassificationRules();
    assertTrue(flowClassificationRulesResult instanceof ImmutableFlowClassificationRulesView);
    assertTrue(primaryAssessmentsResult.ratingSchemeItemsById().isEmpty());
    Set<FlowClassification> classificationsResult = actualCopyOfResult.classifications();
    assertTrue(classificationsResult.isEmpty());
    assertSame(classificationsResult, primaryAssessmentsResult.assessmentDefinitions());
    assertSame(classificationsResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(classificationsResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(classificationsResult, flowClassificationRulesResult.dataTypes());
    assertSame(classificationsResult, flowClassificationRulesResult.flowClassificationRules());
    assertSame(classificationsResult, flowClassificationRulesResult.flowClassifications());
    assertSame(classificationsResult, actualCopyOfResult.dataTypeDecorators());
    assertSame(classificationsResult, actualCopyOfResult.dataTypes());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#equals(Object)}, and {@link
   * ImmutableDataTypeDecoratorView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeDecoratorView#equals(Object)}
   *   <li>{@link ImmutableDataTypeDecoratorView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorView.equals(Object)",
    "int ImmutableDataTypeDecoratorView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableDataTypeDecoratorView immutableDataTypeDecoratorView =
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build();
    ImmutableDataTypeDecoratorView immutableDataTypeDecoratorView2 =
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build();

    // Act and Assert
    assertEquals(immutableDataTypeDecoratorView, immutableDataTypeDecoratorView2);
    assertEquals(
        immutableDataTypeDecoratorView.hashCode(), immutableDataTypeDecoratorView2.hashCode());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#equals(Object)}, and {@link
   * ImmutableDataTypeDecoratorView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeDecoratorView#equals(Object)}
   *   <li>{@link ImmutableDataTypeDecoratorView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorView.equals(Object)",
    "int ImmutableDataTypeDecoratorView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableDataTypeDecoratorView immutableDataTypeDecoratorView =
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build();

    // Act and Assert
    assertEquals(immutableDataTypeDecoratorView, immutableDataTypeDecoratorView);
    int expectedHashCodeResult = immutableDataTypeDecoratorView.hashCode();
    assertEquals(expectedHashCodeResult, immutableDataTypeDecoratorView.hashCode());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorView.equals(Object)",
    "int ImmutableDataTypeDecoratorView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();

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
    builderResult.addDataTypeDecorators(
        ratingResult.targetInboundRating(targetInboundRating).build());
    ImmutableDataTypeDecoratorView immutableDataTypeDecoratorView =
        builderResult
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecoratorView,
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorView.equals(Object)",
    "int ImmutableDataTypeDecoratorView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();
    builderResult.addDataTypes(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    ImmutableDataTypeDecoratorView immutableDataTypeDecoratorView =
        builderResult
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecoratorView,
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorView.equals(Object)",
    "int ImmutableDataTypeDecoratorView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorView.builder();
    builderResult.addClassifications(
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
    ImmutableDataTypeDecoratorView immutableDataTypeDecoratorView =
        builderResult
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecoratorView,
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorView.equals(Object)",
    "int ImmutableDataTypeDecoratorView.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorView.equals(Object)",
    "int ImmutableDataTypeDecoratorView.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build(),
        "Different type to ImmutableDataTypeDecoratorView");
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) DataTypes is {@code null}.
   *   <li>Then return dataTypes Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) DataTypes is 'null'; then return dataTypes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorView ImmutableDataTypeDecoratorView.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonDataTypesIsNull_thenReturnDataTypesEmpty() {
    // Arrange
    LinkedHashSet<DataTypeDecorator> dataTypeDecorators = new LinkedHashSet<>();

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
    dataTypeDecorators.add(ratingResult.targetInboundRating(targetInboundRating).build());

    LinkedHashSet<FlowClassification> classifications = new LinkedHashSet<>();
    classifications.add(
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
    json.setDataTypeDecorators(dataTypeDecorators);
    json.setDataTypes(null);
    json.setClassifications(classifications);
    json.setPrimaryAssessments(ImmutableAssessmentsView.builder().build());
    json.setFlowClassificationRules(ImmutableFlowClassificationRulesView.builder().build());

    // Act
    ImmutableDataTypeDecoratorView actualFromJsonResult =
        ImmutableDataTypeDecoratorView.fromJson(json);

    // Assert
    AssessmentsView primaryAssessmentsResult = actualFromJsonResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    FlowClassificationRulesView flowClassificationRulesResult =
        actualFromJsonResult.flowClassificationRules();
    assertTrue(flowClassificationRulesResult instanceof ImmutableFlowClassificationRulesView);
    Set<DataType> dataTypesResult = actualFromJsonResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, primaryAssessmentsResult.assessmentDefinitions());
    assertSame(dataTypesResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(dataTypesResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(dataTypesResult, flowClassificationRulesResult.dataTypes());
    assertSame(dataTypesResult, flowClassificationRulesResult.flowClassificationRules());
    assertSame(dataTypesResult, flowClassificationRulesResult.flowClassifications());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return dataTypeDecorators size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return dataTypeDecorators size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorView ImmutableDataTypeDecoratorView.fromJson(Json)"
  })
  void testFromJson_thenReturnDataTypeDecoratorsSizeIsTwo() {
    // Arrange
    LinkedHashSet<DataTypeDecorator> dataTypeDecorators = new LinkedHashSet<>();

    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
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
    dataTypeDecorators.add(ratingResult.targetInboundRating(targetInboundRating).build());

    ImmutableDataTypeDecorator.Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableDataTypeDecorator.Builder provenanceResult2 =
        decoratorEntityResult2
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
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    ImmutableDataTypeDecorator.Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    dataTypeDecorators.add(ratingResult2.targetInboundRating(targetInboundRating2).build());

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

    LinkedHashSet<FlowClassification> classifications = new LinkedHashSet<>();
    classifications.add(
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
    json.setDataTypeDecorators(dataTypeDecorators);
    json.setDataTypes(dataTypes);
    json.setClassifications(classifications);
    json.setPrimaryAssessments(ImmutableAssessmentsView.builder().build());
    json.setFlowClassificationRules(ImmutableFlowClassificationRulesView.builder().build());

    // Act
    ImmutableDataTypeDecoratorView actualFromJsonResult =
        ImmutableDataTypeDecoratorView.fromJson(json);

    // Assert
    AssessmentsView primaryAssessmentsResult = actualFromJsonResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    FlowClassificationRulesView flowClassificationRulesResult =
        actualFromJsonResult.flowClassificationRules();
    assertTrue(flowClassificationRulesResult instanceof ImmutableFlowClassificationRulesView);
    assertEquals(2, actualFromJsonResult.dataTypeDecorators().size());
    Set<DataType> dataTypesResult = flowClassificationRulesResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, primaryAssessmentsResult.assessmentDefinitions());
    assertSame(dataTypesResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(dataTypesResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(dataTypesResult, flowClassificationRulesResult.flowClassificationRules());
    assertSame(dataTypesResult, flowClassificationRulesResult.flowClassifications());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return flowClassificationRules dataTypes Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return flowClassificationRules dataTypes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorView ImmutableDataTypeDecoratorView.fromJson(Json)"
  })
  void testFromJson_thenReturnFlowClassificationRulesDataTypesEmpty() {
    // Arrange
    LinkedHashSet<DataTypeDecorator> dataTypeDecorators = new LinkedHashSet<>();

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
    dataTypeDecorators.add(ratingResult.targetInboundRating(targetInboundRating).build());

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

    LinkedHashSet<FlowClassification> classifications = new LinkedHashSet<>();
    classifications.add(
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
    json.setDataTypeDecorators(dataTypeDecorators);
    json.setDataTypes(dataTypes);
    json.setClassifications(classifications);
    json.setPrimaryAssessments(ImmutableAssessmentsView.builder().build());
    json.setFlowClassificationRules(ImmutableFlowClassificationRulesView.builder().build());

    // Act
    ImmutableDataTypeDecoratorView actualFromJsonResult =
        ImmutableDataTypeDecoratorView.fromJson(json);

    // Assert
    AssessmentsView primaryAssessmentsResult = actualFromJsonResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    FlowClassificationRulesView flowClassificationRulesResult =
        actualFromJsonResult.flowClassificationRules();
    assertTrue(flowClassificationRulesResult instanceof ImmutableFlowClassificationRulesView);
    Set<DataType> dataTypesResult = flowClassificationRulesResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, primaryAssessmentsResult.assessmentDefinitions());
    assertSame(dataTypesResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(dataTypesResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(dataTypesResult, flowClassificationRulesResult.flowClassificationRules());
    assertSame(dataTypesResult, flowClassificationRulesResult.flowClassifications());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Classifications is {@link HashSet#HashSet()}.
   *   <li>Then return classifications Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Classifications is HashSet(); then return classifications Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorView ImmutableDataTypeDecoratorView.fromJson(Json)"
  })
  void testFromJson_whenJsonClassificationsIsHashSet_thenReturnClassificationsEmpty() {
    // Arrange
    LinkedHashSet<DataTypeDecorator> dataTypeDecorators = new LinkedHashSet<>();

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
    dataTypeDecorators.add(ratingResult.targetInboundRating(targetInboundRating).build());

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
    json.setDataTypeDecorators(dataTypeDecorators);
    json.setDataTypes(dataTypes);
    json.setClassifications(new HashSet<>());
    json.setPrimaryAssessments(ImmutableAssessmentsView.builder().build());
    json.setFlowClassificationRules(ImmutableFlowClassificationRulesView.builder().build());

    // Act
    ImmutableDataTypeDecoratorView actualFromJsonResult =
        ImmutableDataTypeDecoratorView.fromJson(json);

    // Assert
    AssessmentsView primaryAssessmentsResult = actualFromJsonResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    FlowClassificationRulesView flowClassificationRulesResult =
        actualFromJsonResult.flowClassificationRules();
    assertTrue(flowClassificationRulesResult instanceof ImmutableFlowClassificationRulesView);
    Set<FlowClassification> classificationsResult = actualFromJsonResult.classifications();
    assertTrue(classificationsResult.isEmpty());
    assertSame(classificationsResult, primaryAssessmentsResult.assessmentDefinitions());
    assertSame(classificationsResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(classificationsResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(classificationsResult, flowClassificationRulesResult.dataTypes());
    assertSame(classificationsResult, flowClassificationRulesResult.flowClassificationRules());
    assertSame(classificationsResult, flowClassificationRulesResult.flowClassifications());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Classifications is {@code null}.
   *   <li>Then return classifications Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Classifications is 'null'; then return classifications Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorView ImmutableDataTypeDecoratorView.fromJson(Json)"
  })
  void testFromJson_whenJsonClassificationsIsNull_thenReturnClassificationsEmpty() {
    // Arrange
    LinkedHashSet<DataTypeDecorator> dataTypeDecorators = new LinkedHashSet<>();

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
    dataTypeDecorators.add(ratingResult.targetInboundRating(targetInboundRating).build());

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
    json.setDataTypeDecorators(dataTypeDecorators);
    json.setDataTypes(dataTypes);
    json.setClassifications(null);
    json.setPrimaryAssessments(ImmutableAssessmentsView.builder().build());
    json.setFlowClassificationRules(ImmutableFlowClassificationRulesView.builder().build());

    // Act
    ImmutableDataTypeDecoratorView actualFromJsonResult =
        ImmutableDataTypeDecoratorView.fromJson(json);

    // Assert
    AssessmentsView primaryAssessmentsResult = actualFromJsonResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    FlowClassificationRulesView flowClassificationRulesResult =
        actualFromJsonResult.flowClassificationRules();
    assertTrue(flowClassificationRulesResult instanceof ImmutableFlowClassificationRulesView);
    Set<FlowClassification> classificationsResult = actualFromJsonResult.classifications();
    assertTrue(classificationsResult.isEmpty());
    assertSame(classificationsResult, primaryAssessmentsResult.assessmentDefinitions());
    assertSame(classificationsResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(classificationsResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(classificationsResult, flowClassificationRulesResult.dataTypes());
    assertSame(classificationsResult, flowClassificationRulesResult.flowClassificationRules());
    assertSame(classificationsResult, flowClassificationRulesResult.flowClassifications());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeDecoratorView#toString()}
   *   <li>{@link ImmutableDataTypeDecoratorView#classifications()}
   *   <li>{@link ImmutableDataTypeDecoratorView#dataTypeDecorators()}
   *   <li>{@link ImmutableDataTypeDecoratorView#dataTypes()}
   *   <li>{@link ImmutableDataTypeDecoratorView#flowClassificationRules()}
   *   <li>{@link ImmutableDataTypeDecoratorView#primaryAssessments()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableDataTypeDecoratorView.classifications()",
    "Set ImmutableDataTypeDecoratorView.dataTypeDecorators()",
    "Set ImmutableDataTypeDecoratorView.dataTypes()",
    "FlowClassificationRulesView ImmutableDataTypeDecoratorView.flowClassificationRules()",
    "AssessmentsView ImmutableDataTypeDecoratorView.primaryAssessments()",
    "String ImmutableDataTypeDecoratorView.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableDataTypeDecoratorView immutableDataTypeDecoratorView =
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build();

    // Act
    String actualToStringResult = immutableDataTypeDecoratorView.toString();
    Set<FlowClassification> actualClassificationsResult =
        immutableDataTypeDecoratorView.classifications();
    Set<DataTypeDecorator> actualDataTypeDecoratorsResult =
        immutableDataTypeDecoratorView.dataTypeDecorators();
    Set<DataType> actualDataTypesResult = immutableDataTypeDecoratorView.dataTypes();
    FlowClassificationRulesView actualFlowClassificationRulesResult =
        immutableDataTypeDecoratorView.flowClassificationRules();

    // Assert
    assertTrue(
        immutableDataTypeDecoratorView.primaryAssessments() instanceof ImmutableAssessmentsView);
    assertTrue(actualFlowClassificationRulesResult instanceof ImmutableFlowClassificationRulesView);
    assertEquals(
        "DataTypeDecoratorView{dataTypeDecorators=[], dataTypes=[], classifications=[], primaryAssessments"
            + "=AssessmentsView{assessmentRatings=[], ratingSchemeItems=[], assessmentDefinitions=[], ratingSchemeItemsById"
            + "={}}, flowClassificationRules=FlowClassificationRulesView{flowClassificationRules=[], flowClassifications=[],"
            + " dataTypes=[]}}",
        actualToStringResult);
    assertTrue(actualClassificationsResult.isEmpty());
    assertSame(actualClassificationsResult, actualDataTypeDecoratorsResult);
    assertSame(actualClassificationsResult, actualDataTypesResult);
  }

  /**
   * Test Json {@link Json#classifications()}.
   *
   * <p>Method under test: {@link Json#classifications()}
   */
  @Test
  @DisplayName("Test Json classifications()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.classifications()"})
  void testJsonClassifications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().classifications());
  }

  /**
   * Test Json {@link Json#dataTypeDecorators()}.
   *
   * <p>Method under test: {@link Json#dataTypeDecorators()}
   */
  @Test
  @DisplayName("Test Json dataTypeDecorators()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.dataTypeDecorators()"})
  void testJsonDataTypeDecorators() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dataTypeDecorators());
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
  @MethodsUnderTest({"FlowClassificationRulesView Json.flowClassificationRules()"})
  void testJsonFlowClassificationRules() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().flowClassificationRules());
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
    assertNull(actualJson.primaryAssessments);
    assertNull(actualJson.flowClassificationRules);
    assertTrue(actualJson.classifications.isEmpty());
    assertTrue(actualJson.dataTypeDecorators.isEmpty());
    assertTrue(actualJson.dataTypes.isEmpty());
  }

  /**
   * Test Json {@link Json#primaryAssessments()}.
   *
   * <p>Method under test: {@link Json#primaryAssessments()}
   */
  @Test
  @DisplayName("Test Json primaryAssessments()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssessmentsView Json.primaryAssessments()"})
  void testJsonPrimaryAssessments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().primaryAssessments());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#withClassifications(FlowClassification[])} with
   * {@code FlowClassification[]}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorView#withClassifications(FlowClassification[])}
   */
  @Test
  @DisplayName("Test withClassifications(FlowClassification[]) with 'FlowClassification[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorView ImmutableDataTypeDecoratorView.withClassifications(FlowClassification[])"
  })
  void testWithClassificationsWithFlowClassification() {
    // Arrange
    ImmutableDataTypeDecoratorView immutableDataTypeDecoratorView =
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build();

    // Act
    ImmutableDataTypeDecoratorView actualWithClassificationsResult =
        immutableDataTypeDecoratorView.withClassifications(
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
    AssessmentsView primaryAssessmentsResult = actualWithClassificationsResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    FlowClassificationRulesView flowClassificationRulesResult =
        actualWithClassificationsResult.flowClassificationRules();
    assertTrue(flowClassificationRulesResult instanceof ImmutableFlowClassificationRulesView);
    assertEquals(1, actualWithClassificationsResult.classifications().size());
    assertTrue(primaryAssessmentsResult.ratingSchemeItemsById().isEmpty());
    Set<DataTypeDecorator> dataTypeDecoratorsResult =
        actualWithClassificationsResult.dataTypeDecorators();
    assertTrue(dataTypeDecoratorsResult.isEmpty());
    assertSame(dataTypeDecoratorsResult, primaryAssessmentsResult.assessmentDefinitions());
    assertSame(dataTypeDecoratorsResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(dataTypeDecoratorsResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(dataTypeDecoratorsResult, flowClassificationRulesResult.dataTypes());
    assertSame(dataTypeDecoratorsResult, flowClassificationRulesResult.flowClassificationRules());
    assertSame(dataTypeDecoratorsResult, flowClassificationRulesResult.flowClassifications());
    assertSame(dataTypeDecoratorsResult, actualWithClassificationsResult.dataTypes());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#withDataTypeDecorators(DataTypeDecorator[])} with
   * {@code DataTypeDecorator[]}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorView#withDataTypeDecorators(DataTypeDecorator[])}
   */
  @Test
  @DisplayName("Test withDataTypeDecorators(DataTypeDecorator[]) with 'DataTypeDecorator[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorView ImmutableDataTypeDecoratorView.withDataTypeDecorators(DataTypeDecorator[])"
  })
  void testWithDataTypeDecoratorsWithDataTypeDecorator() {
    // Arrange
    ImmutableDataTypeDecoratorView immutableDataTypeDecoratorView =
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build();

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
    ImmutableDataTypeDecoratorView actualWithDataTypeDecoratorsResult =
        immutableDataTypeDecoratorView.withDataTypeDecorators(
            ratingResult.targetInboundRating(targetInboundRating).build());

    // Assert
    AssessmentsView primaryAssessmentsResult =
        actualWithDataTypeDecoratorsResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    FlowClassificationRulesView flowClassificationRulesResult =
        actualWithDataTypeDecoratorsResult.flowClassificationRules();
    assertTrue(flowClassificationRulesResult instanceof ImmutableFlowClassificationRulesView);
    assertEquals(1, actualWithDataTypeDecoratorsResult.dataTypeDecorators().size());
    assertTrue(primaryAssessmentsResult.ratingSchemeItemsById().isEmpty());
    Set<FlowClassification> classificationsResult =
        actualWithDataTypeDecoratorsResult.classifications();
    assertTrue(classificationsResult.isEmpty());
    assertSame(classificationsResult, primaryAssessmentsResult.assessmentDefinitions());
    assertSame(classificationsResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(classificationsResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(classificationsResult, flowClassificationRulesResult.dataTypes());
    assertSame(classificationsResult, flowClassificationRulesResult.flowClassificationRules());
    assertSame(classificationsResult, flowClassificationRulesResult.flowClassifications());
    assertSame(classificationsResult, actualWithDataTypeDecoratorsResult.dataTypes());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#withDataTypes(DataType[])} with {@code DataType[]}.
   *
   * <p>Method under test: {@link ImmutableDataTypeDecoratorView#withDataTypes(DataType[])}
   */
  @Test
  @DisplayName("Test withDataTypes(DataType[]) with 'DataType[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorView ImmutableDataTypeDecoratorView.withDataTypes(DataType[])"
  })
  void testWithDataTypesWithDataType() {
    // Arrange
    ImmutableDataTypeDecoratorView immutableDataTypeDecoratorView =
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build();

    // Act
    ImmutableDataTypeDecoratorView actualWithDataTypesResult =
        immutableDataTypeDecoratorView.withDataTypes(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Assert
    AssessmentsView primaryAssessmentsResult = actualWithDataTypesResult.primaryAssessments();
    assertTrue(primaryAssessmentsResult instanceof ImmutableAssessmentsView);
    FlowClassificationRulesView flowClassificationRulesResult =
        actualWithDataTypesResult.flowClassificationRules();
    assertTrue(flowClassificationRulesResult instanceof ImmutableFlowClassificationRulesView);
    assertEquals(1, actualWithDataTypesResult.dataTypes().size());
    assertTrue(primaryAssessmentsResult.ratingSchemeItemsById().isEmpty());
    Set<FlowClassification> classificationsResult = actualWithDataTypesResult.classifications();
    assertTrue(classificationsResult.isEmpty());
    assertSame(classificationsResult, primaryAssessmentsResult.assessmentDefinitions());
    assertSame(classificationsResult, primaryAssessmentsResult.assessmentRatings());
    assertSame(classificationsResult, primaryAssessmentsResult.ratingSchemeItems());
    assertSame(classificationsResult, flowClassificationRulesResult.dataTypes());
    assertSame(classificationsResult, flowClassificationRulesResult.flowClassificationRules());
    assertSame(classificationsResult, flowClassificationRulesResult.flowClassifications());
    assertSame(classificationsResult, actualWithDataTypesResult.dataTypeDecorators());
  }

  /**
   * Test {@link
   * ImmutableDataTypeDecoratorView#withFlowClassificationRules(FlowClassificationRulesView)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorView#withFlowClassificationRules(FlowClassificationRulesView)}
   */
  @Test
  @DisplayName("Test withFlowClassificationRules(FlowClassificationRulesView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorView ImmutableDataTypeDecoratorView.withFlowClassificationRules(FlowClassificationRulesView)"
  })
  void testWithFlowClassificationRules() {
    // Arrange
    ImmutableDataTypeDecoratorView immutableDataTypeDecoratorView =
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build();

    // Act
    ImmutableDataTypeDecoratorView actualWithFlowClassificationRulesResult =
        immutableDataTypeDecoratorView.withFlowClassificationRules(
            ImmutableFlowClassificationRulesView.builder().build());

    // Assert
    assertEquals(immutableDataTypeDecoratorView, actualWithFlowClassificationRulesResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorView#withPrimaryAssessments(AssessmentsView)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorView#withPrimaryAssessments(AssessmentsView)}
   */
  @Test
  @DisplayName("Test withPrimaryAssessments(AssessmentsView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorView ImmutableDataTypeDecoratorView.withPrimaryAssessments(AssessmentsView)"
  })
  void testWithPrimaryAssessments() {
    // Arrange
    ImmutableDataTypeDecoratorView immutableDataTypeDecoratorView =
        ImmutableDataTypeDecoratorView.builder()
            .flowClassificationRules(ImmutableFlowClassificationRulesView.builder().build())
            .primaryAssessments(ImmutableAssessmentsView.builder().build())
            .build();

    // Act
    ImmutableDataTypeDecoratorView actualWithPrimaryAssessmentsResult =
        immutableDataTypeDecoratorView.withPrimaryAssessments(
            ImmutableAssessmentsView.builder().build());

    // Assert
    assertEquals(immutableDataTypeDecoratorView, actualWithPrimaryAssessmentsResult);
  }
}
