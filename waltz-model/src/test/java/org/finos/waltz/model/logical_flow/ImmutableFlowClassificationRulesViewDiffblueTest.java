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
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.ImmutableDataType;
import org.finos.waltz.model.flow_classification.FlowClassification;
import org.finos.waltz.model.flow_classification.ImmutableFlowClassification;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRule;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRule;
import org.finos.waltz.model.logical_flow.ImmutableFlowClassificationRulesView.Builder;
import org.finos.waltz.model.logical_flow.ImmutableFlowClassificationRulesView.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationRulesViewDiffblueTest {
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
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    Builder actualAddAllDataTypesResult = builderResult.addAllDataTypes(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllDataTypesResult);
  }

  /**
   * Test Builder {@link Builder#addAllFlowClassificationRules(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllFlowClassificationRules(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllFlowClassificationRules(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllFlowClassificationRules(Iterable)"})
  void testBuilderAddAllFlowClassificationRules_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    Builder actualAddAllFlowClassificationRulesResult =
        builderResult.addAllFlowClassificationRules(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllFlowClassificationRulesResult);
  }

  /**
   * Test Builder {@link Builder#addAllFlowClassifications(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllFlowClassifications(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllFlowClassifications(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllFlowClassifications(Iterable)"})
  void testBuilderAddAllFlowClassifications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    Builder actualAddAllFlowClassificationsResult =
        builderResult.addAllFlowClassifications(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllFlowClassificationsResult);
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
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

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
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

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
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

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
    Builder actualAddFlowClassificationRulesResult =
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
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

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
    Builder actualAddFlowClassificationRulesResult =
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
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

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
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

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
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowClassificationRulesView Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableFlowClassificationRulesView.builder().build().dataTypes().isEmpty());
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
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    Builder actualDataTypesResult = builderResult.dataTypes(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDataTypesResult);
  }

  /**
   * Test Builder {@link Builder#flowClassificationRules(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#flowClassificationRules(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder flowClassificationRules(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flowClassificationRules(Iterable)"})
  void testBuilderFlowClassificationRules_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    Builder actualFlowClassificationRulesResult =
        builderResult.flowClassificationRules(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualFlowClassificationRulesResult);
  }

  /**
   * Test Builder {@link Builder#flowClassifications(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#flowClassifications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder flowClassifications(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flowClassifications(Iterable)"})
  void testBuilderFlowClassifications_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    Builder actualFlowClassificationsResult = builderResult.flowClassifications(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualFlowClassificationsResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRulesView)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(FlowClassificationRulesView)}
   */
  @Test
  @DisplayName(
      "Test Builder from(FlowClassificationRulesView); when builder build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRulesView)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(ImmutableFlowClassificationRulesView.builder().build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#copyOf(FlowClassificationRulesView)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return dataTypes Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRulesView#copyOf(FlowClassificationRulesView)}
   */
  @Test
  @DisplayName(
      "Test copyOf(FlowClassificationRulesView); when builder build; then return dataTypes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.copyOf(FlowClassificationRulesView)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnDataTypesEmpty() {
    // Arrange
    ImmutableFlowClassificationRulesView instance =
        ImmutableFlowClassificationRulesView.builder().build();

    // Act
    ImmutableFlowClassificationRulesView actualCopyOfResult =
        ImmutableFlowClassificationRulesView.copyOf(instance);

    // Assert
    Set<DataType> dataTypesResult = actualCopyOfResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualCopyOfResult.flowClassificationRules());
    assertSame(dataTypesResult, actualCopyOfResult.flowClassifications());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#equals(Object)}, and {@link
   * ImmutableFlowClassificationRulesView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRulesView#equals(Object)}
   *   <li>{@link ImmutableFlowClassificationRulesView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRulesView.equals(Object)",
    "int ImmutableFlowClassificationRulesView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableFlowClassificationRulesView immutableFlowClassificationRulesView =
        ImmutableFlowClassificationRulesView.builder().build();
    ImmutableFlowClassificationRulesView immutableFlowClassificationRulesView2 =
        ImmutableFlowClassificationRulesView.builder().build();

    // Act and Assert
    assertEquals(immutableFlowClassificationRulesView, immutableFlowClassificationRulesView2);
    assertEquals(
        immutableFlowClassificationRulesView.hashCode(),
        immutableFlowClassificationRulesView2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#equals(Object)}, and {@link
   * ImmutableFlowClassificationRulesView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRulesView#equals(Object)}
   *   <li>{@link ImmutableFlowClassificationRulesView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRulesView.equals(Object)",
    "int ImmutableFlowClassificationRulesView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableFlowClassificationRulesView immutableFlowClassificationRulesView =
        ImmutableFlowClassificationRulesView.builder().build();

    // Act and Assert
    assertEquals(immutableFlowClassificationRulesView, immutableFlowClassificationRulesView);
    int expectedHashCodeResult = immutableFlowClassificationRulesView.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowClassificationRulesView.hashCode());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRulesView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRulesView.equals(Object)",
    "int ImmutableFlowClassificationRulesView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();

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
    assertNotEquals(builderResult.build(), ImmutableFlowClassificationRulesView.builder().build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRulesView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRulesView.equals(Object)",
    "int ImmutableFlowClassificationRulesView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();
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
    assertNotEquals(builderResult.build(), ImmutableFlowClassificationRulesView.builder().build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRulesView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRulesView.equals(Object)",
    "int ImmutableFlowClassificationRulesView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRulesView.builder();
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
    assertNotEquals(builderResult.build(), ImmutableFlowClassificationRulesView.builder().build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRulesView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRulesView.equals(Object)",
    "int ImmutableFlowClassificationRulesView.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableFlowClassificationRulesView.builder().build(), null);
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRulesView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRulesView.equals(Object)",
    "int ImmutableFlowClassificationRulesView.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableFlowClassificationRulesView.builder().build(),
        "Different type to ImmutableFlowClassificationRulesView");
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) DataTypes is {@code null}.
   *   <li>Then return dataTypes Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRulesView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) DataTypes is 'null'; then return dataTypes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonDataTypesIsNull_thenReturnDataTypesEmpty() {
    // Arrange
    Json json = new Json();
    json.setFlowClassificationRules(new HashSet<>());
    json.setFlowClassifications(new HashSet<>());
    json.setDataTypes(null);

    // Act
    ImmutableFlowClassificationRulesView actualFromJsonResult =
        ImmutableFlowClassificationRulesView.fromJson(json);

    // Assert
    Set<DataType> dataTypesResult = actualFromJsonResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualFromJsonResult.flowClassificationRules());
    assertSame(dataTypesResult, actualFromJsonResult.flowClassifications());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return flowClassificationRules is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRulesView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return flowClassificationRules is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.fromJson(Json)"
  })
  void testFromJson_thenReturnFlowClassificationRulesIsLinkedHashSet() {
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
    json.setFlowClassifications(flowClassifications);
    json.setDataTypes(dataTypes);

    // Act
    ImmutableFlowClassificationRulesView actualFromJsonResult =
        ImmutableFlowClassificationRulesView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.dataTypes().size());
    assertEquals(1, actualFromJsonResult.flowClassifications().size());
    assertEquals(flowClassificationRules, actualFromJsonResult.flowClassificationRules());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return flowClassificationRules size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRulesView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return flowClassificationRules size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.fromJson(Json)"
  })
  void testFromJson_thenReturnFlowClassificationRulesSizeIsOne() {
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
    json.setFlowClassifications(flowClassifications);
    json.setDataTypes(dataTypes);

    // Act
    ImmutableFlowClassificationRulesView actualFromJsonResult =
        ImmutableFlowClassificationRulesView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.dataTypes().size());
    assertEquals(1, actualFromJsonResult.flowClassificationRules().size());
    assertEquals(1, actualFromJsonResult.flowClassifications().size());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) FlowClassificationRules is {@code null}.
   *   <li>Then return dataTypes Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRulesView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) FlowClassificationRules is 'null'; then return dataTypes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.fromJson(Json)"
  })
  void testFromJson_whenJsonFlowClassificationRulesIsNull_thenReturnDataTypesEmpty() {
    // Arrange
    Json json = new Json();
    json.setFlowClassificationRules(null);
    json.setFlowClassifications(new HashSet<>());
    json.setDataTypes(new HashSet<>());

    // Act
    ImmutableFlowClassificationRulesView actualFromJsonResult =
        ImmutableFlowClassificationRulesView.fromJson(json);

    // Assert
    Set<DataType> dataTypesResult = actualFromJsonResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualFromJsonResult.flowClassificationRules());
    assertSame(dataTypesResult, actualFromJsonResult.flowClassifications());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) FlowClassifications is {@code null}.
   *   <li>Then return dataTypes Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRulesView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) FlowClassifications is 'null'; then return dataTypes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.fromJson(Json)"
  })
  void testFromJson_whenJsonFlowClassificationsIsNull_thenReturnDataTypesEmpty() {
    // Arrange
    Json json = new Json();
    json.setFlowClassificationRules(new HashSet<>());
    json.setFlowClassifications(null);
    json.setDataTypes(new HashSet<>());

    // Act
    ImmutableFlowClassificationRulesView actualFromJsonResult =
        ImmutableFlowClassificationRulesView.fromJson(json);

    // Assert
    Set<DataType> dataTypesResult = actualFromJsonResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualFromJsonResult.flowClassificationRules());
    assertSame(dataTypesResult, actualFromJsonResult.flowClassifications());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return flowClassificationRules is {@link Json} (default constructor) {@link
   *       Json#flowClassifications}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRulesView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return flowClassificationRules is Json (default constructor) flowClassifications")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnFlowClassificationRulesIsJsonFlowClassifications() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableFlowClassificationRulesView actualFromJsonResult =
        ImmutableFlowClassificationRulesView.fromJson(json);

    // Assert
    Set<FlowClassification> flowClassificationSet = json.flowClassifications;
    assertSame(flowClassificationSet, actualFromJsonResult.flowClassificationRules());
    assertSame(flowClassificationSet, actualFromJsonResult.flowClassifications());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRulesView#toString()}
   *   <li>{@link ImmutableFlowClassificationRulesView#dataTypes()}
   *   <li>{@link ImmutableFlowClassificationRulesView#flowClassificationRules()}
   *   <li>{@link ImmutableFlowClassificationRulesView#flowClassifications()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableFlowClassificationRulesView.dataTypes()",
    "Set ImmutableFlowClassificationRulesView.flowClassificationRules()",
    "Set ImmutableFlowClassificationRulesView.flowClassifications()",
    "String ImmutableFlowClassificationRulesView.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableFlowClassificationRulesView immutableFlowClassificationRulesView =
        ImmutableFlowClassificationRulesView.builder().build();

    // Act
    String actualToStringResult = immutableFlowClassificationRulesView.toString();
    Set<DataType> actualDataTypesResult = immutableFlowClassificationRulesView.dataTypes();
    Set<FlowClassificationRule> actualFlowClassificationRulesResult =
        immutableFlowClassificationRulesView.flowClassificationRules();
    Set<FlowClassification> actualFlowClassificationsResult =
        immutableFlowClassificationRulesView.flowClassifications();

    // Assert
    assertEquals(
        "FlowClassificationRulesView{flowClassificationRules=[], flowClassifications=[], dataTypes=[]}",
        actualToStringResult);
    assertTrue(actualDataTypesResult.isEmpty());
    assertSame(actualDataTypesResult, actualFlowClassificationRulesResult);
    assertSame(actualDataTypesResult, actualFlowClassificationsResult);
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
    assertTrue(actualJson.dataTypes.isEmpty());
    assertTrue(actualJson.flowClassificationRules.isEmpty());
    assertTrue(actualJson.flowClassifications.isEmpty());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#withDataTypes(DataType[])} with {@code
   * DataType[]}.
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRulesView#withDataTypes(DataType[])}
   */
  @Test
  @DisplayName("Test withDataTypes(DataType[]) with 'DataType[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.withDataTypes(DataType[])"
  })
  void testWithDataTypesWithDataType() {
    // Arrange
    ImmutableFlowClassificationRulesView immutableFlowClassificationRulesView =
        ImmutableFlowClassificationRulesView.builder().build();

    // Act
    ImmutableFlowClassificationRulesView actualWithDataTypesResult =
        immutableFlowClassificationRulesView.withDataTypes(
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
    Set<FlowClassificationRule> flowClassificationRulesResult =
        actualWithDataTypesResult.flowClassificationRules();
    assertTrue(flowClassificationRulesResult.isEmpty());
    assertSame(flowClassificationRulesResult, actualWithDataTypesResult.flowClassifications());
  }

  /**
   * Test {@link
   * ImmutableFlowClassificationRulesView#withFlowClassificationRules(FlowClassificationRule[])}
   * with {@code FlowClassificationRule[]}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRulesView#withFlowClassificationRules(FlowClassificationRule[])}
   */
  @Test
  @DisplayName(
      "Test withFlowClassificationRules(FlowClassificationRule[]) with 'FlowClassificationRule[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.withFlowClassificationRules(FlowClassificationRule[])"
  })
  void testWithFlowClassificationRulesWithFlowClassificationRule() {
    // Arrange
    ImmutableFlowClassificationRulesView immutableFlowClassificationRulesView =
        ImmutableFlowClassificationRulesView.builder().build();

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
    ImmutableFlowClassificationRulesView actualWithFlowClassificationRulesResult =
        immutableFlowClassificationRulesView.withFlowClassificationRules(
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
    Set<DataType> dataTypesResult = actualWithFlowClassificationRulesResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualWithFlowClassificationRulesResult.flowClassifications());
  }

  /**
   * Test {@link ImmutableFlowClassificationRulesView#withFlowClassifications(FlowClassification[])}
   * with {@code FlowClassification[]}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRulesView#withFlowClassifications(FlowClassification[])}
   */
  @Test
  @DisplayName("Test withFlowClassifications(FlowClassification[]) with 'FlowClassification[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRulesView ImmutableFlowClassificationRulesView.withFlowClassifications(FlowClassification[])"
  })
  void testWithFlowClassificationsWithFlowClassification() {
    // Arrange
    ImmutableFlowClassificationRulesView immutableFlowClassificationRulesView =
        ImmutableFlowClassificationRulesView.builder().build();

    // Act
    ImmutableFlowClassificationRulesView actualWithFlowClassificationsResult =
        immutableFlowClassificationRulesView.withFlowClassifications(
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
    Set<DataType> dataTypesResult = actualWithFlowClassificationsResult.dataTypes();
    assertTrue(dataTypesResult.isEmpty());
    assertSame(dataTypesResult, actualWithFlowClassificationsResult.flowClassificationRules());
  }
}
