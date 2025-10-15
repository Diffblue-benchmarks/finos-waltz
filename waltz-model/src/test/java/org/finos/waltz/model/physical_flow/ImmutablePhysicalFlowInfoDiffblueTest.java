package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowInfo.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowInfoDiffblueTest {
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
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act
    Builder actualAddAllDataTypesResult = builderResult.addAllDataTypes(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllDataTypesResult);
  }

  /**
   * Test Builder {@link Builder#addDataTypes(EntityReference)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addDataTypes(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder addDataTypes(EntityReference) with 'element'; when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDataTypes(EntityReference)"})
  void testBuilderAddDataTypesWithElement_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act
    Builder actualAddDataTypesResult = builderResult.addDataTypes(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualAddDataTypesResult);
  }

  /**
   * Test Builder {@link Builder#addDataTypes(EntityReference[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addDataTypes(EntityReference[])}
   */
  @Test
  @DisplayName(
      "Test Builder addDataTypes(EntityReference[]) with 'elements'; when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDataTypes(EntityReference[])"})
  void testBuilderAddDataTypesWithElements_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act
    Builder actualAddDataTypesResult = builderResult.addDataTypes(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualAddDataTypesResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#physicalFlowDescription(String)}
   *   <li>{@link Builder#physicalFlowExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowInfo Builder.build()",
    "Builder Builder.physicalFlowDescription(String)",
    "Builder Builder.physicalFlowExternalId(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutablePhysicalFlowInfo.builder();
    CriticalityValue criticality = CriticalityValue.of("42");
    Builder actualCriticalityResult = actualBuilderResult.criticality(criticality);
    FrequencyKindValue frequencyKind = FrequencyKindValue.of("42");
    Builder actualFrequencyKindResult = actualCriticalityResult.frequencyKind(frequencyKind);
    ImmutableEntityReference logicalFlow =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualPhysicalFlowExternalIdResult =
        actualFrequencyKindResult
            .logicalFlow(logicalFlow)
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");
    ImmutableEntityReference source =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualSourceResult = actualPhysicalFlowExternalIdResult.source(source);
    ImmutableEntityReference specification =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualSpecificationResult = actualSourceResult.specification(specification);
    ImmutableEntityReference target =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualTargetResult = actualSpecificationResult.target(target);
    TransportKindValue transportKindValue = TransportKindValue.of("42");
    ImmutablePhysicalFlowInfo actualImmutablePhysicalFlowInfo =
        actualTargetResult.transportKindValue(transportKindValue).build();

    // Assert
    CriticalityValue criticalityResult = actualImmutablePhysicalFlowInfo.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyKindResult = actualImmutablePhysicalFlowInfo.frequencyKind();
    assertEquals("42", frequencyKindResult.value());
    assertEquals("42", actualImmutablePhysicalFlowInfo.physicalFlowExternalId());
    TransportKindValue transportKindValueResult =
        actualImmutablePhysicalFlowInfo.transportKindValue();
    assertEquals("42", transportKindValueResult.value());
    assertEquals(
        "Physical Flow Description", actualImmutablePhysicalFlowInfo.physicalFlowDescription());
    assertTrue(actualImmutablePhysicalFlowInfo.dataTypes().isEmpty());
    assertSame(logicalFlow, actualImmutablePhysicalFlowInfo.logicalFlow());
    assertSame(source, actualImmutablePhysicalFlowInfo.source());
    assertSame(specification, actualImmutablePhysicalFlowInfo.specification());
    assertSame(target, actualImmutablePhysicalFlowInfo.target());
    assertSame(criticality, criticalityResult);
    assertSame(frequencyKind, frequencyKindResult);
    assertSame(transportKindValue, transportKindValueResult);
  }

  /**
   * Test Builder {@link Builder#criticality(CriticalityValue)}.
   *
   * <ul>
   *   <li>When {@link CriticalityValue} with value is {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#criticality(CriticalityValue)}
   */
  @Test
  @DisplayName(
      "Test Builder criticality(CriticalityValue); when CriticalityValue with value is '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.criticality(CriticalityValue)"})
  void testBuilderCriticality_whenCriticalityValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act
    Builder actualCriticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    // Assert
    assertSame(builderResult, actualCriticalityResult);
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
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act
    Builder actualDataTypesResult = builderResult.dataTypes(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDataTypesResult);
  }

  /**
   * Test Builder {@link Builder#frequencyKind(FrequencyKindValue)}.
   *
   * <ul>
   *   <li>When {@link FrequencyKindValue} with value is {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#frequencyKind(FrequencyKindValue)}
   */
  @Test
  @DisplayName(
      "Test Builder frequencyKind(FrequencyKindValue); when FrequencyKindValue with value is '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.frequencyKind(FrequencyKindValue)"})
  void testBuilderFrequencyKind_whenFrequencyKindValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act
    Builder actualFrequencyKindResult = builderResult.frequencyKind(FrequencyKindValue.of("42"));

    // Assert
    assertSame(builderResult, actualFrequencyKindResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowInfo)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowInfo)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder builderResult2 = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult2.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo instance =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlowInfo actualImmutablePhysicalFlowInfo =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutablePhysicalFlowInfo);
    ImmutablePhysicalFlowInfo actualImmutablePhysicalFlowInfo2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowInfo2);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowInfo)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowInfo)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowInfo)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder builderResult2 = ImmutablePhysicalFlowInfo.builder();
    builderResult2.addDataTypes(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    Builder criticalityResult = builderResult2.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo instance =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlowInfo actualImmutablePhysicalFlowInfo =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutablePhysicalFlowInfo);
    ImmutablePhysicalFlowInfo actualImmutablePhysicalFlowInfo2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowInfo2);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowInfo)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowInfo)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowInfo)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder builderResult2 = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult2.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription(null)
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo instance =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlowInfo actualImmutablePhysicalFlowInfo =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutablePhysicalFlowInfo);
    ImmutablePhysicalFlowInfo actualImmutablePhysicalFlowInfo2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowInfo2);
  }

  /**
   * Test Builder {@link Builder#logicalFlow(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#logicalFlow(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder logicalFlow(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.logicalFlow(EntityReference)"})
  void testBuilderLogicalFlow_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act
    Builder actualLogicalFlowResult = builderResult.logicalFlow(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualLogicalFlowResult);
  }

  /**
   * Test Builder {@link Builder#source(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#source(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder source(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.source(EntityReference)"})
  void testBuilderSource_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act
    Builder actualSourceResult = builderResult.source(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualSourceResult);
  }

  /**
   * Test Builder {@link Builder#specification(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#specification(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder specification(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.specification(EntityReference)"})
  void testBuilderSpecification_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act
    Builder actualSpecificationResult = builderResult.specification(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualSpecificationResult);
  }

  /**
   * Test Builder {@link Builder#target(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#target(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder target(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.target(EntityReference)"})
  void testBuilderTarget_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act
    Builder actualTargetResult = builderResult.target(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualTargetResult);
  }

  /**
   * Test Builder {@link Builder#transportKindValue(TransportKindValue)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#transportKindValue(TransportKindValue)}
   */
  @Test
  @DisplayName("Test Builder transportKindValue(TransportKindValue); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.transportKindValue(TransportKindValue)"})
  void testBuilderTransportKindValue_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    // Act
    Builder actualTransportKindValueResult =
        builderResult.transportKindValue(TransportKindValue.of("42"));

    // Assert
    assertSame(builderResult, actualTransportKindValueResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#copyOf(PhysicalFlowInfo)}.
   *
   * <ul>
   *   <li>Then logicalFlow return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#copyOf(PhysicalFlowInfo)}
   */
  @Test
  @DisplayName("Test copyOf(PhysicalFlowInfo); then logicalFlow return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowInfo ImmutablePhysicalFlowInfo.copyOf(PhysicalFlowInfo)"
  })
  void testCopyOf_thenLogicalFlowReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder criticalityResult = builderResult.criticality(criticality);
    FrequencyKindValue frequencyKind = FrequencyKindValue.of("42");

    Builder frequencyKindResult = criticalityResult.frequencyKind(frequencyKind);

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    TransportKindValue transportKindValue = TransportKindValue.of("42");
    ImmutablePhysicalFlowInfo instance =
        targetResult.transportKindValue(transportKindValue).build();

    // Act
    ImmutablePhysicalFlowInfo actualCopyOfResult = ImmutablePhysicalFlowInfo.copyOf(instance);

    // Assert
    EntityReference logicalFlowResult = actualCopyOfResult.logicalFlow();
    assertTrue(logicalFlowResult instanceof ImmutableEntityReference);
    EntityReference sourceResult2 = actualCopyOfResult.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference specificationResult2 = actualCopyOfResult.specification();
    assertTrue(specificationResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult2 = actualCopyOfResult.target();
    assertTrue(targetResult2 instanceof ImmutableEntityReference);
    assertEquals("42", actualCopyOfResult.physicalFlowExternalId());
    assertEquals("Physical Flow Description", actualCopyOfResult.physicalFlowDescription());
    assertTrue(actualCopyOfResult.dataTypes().isEmpty());
    assertEquals(logicalFlowResult, sourceResult2);
    assertEquals(logicalFlowResult, specificationResult2);
    assertEquals(logicalFlowResult, targetResult2);
    assertSame(criticality, actualCopyOfResult.criticality());
    assertSame(frequencyKind, actualCopyOfResult.frequencyKind());
    assertSame(transportKindValue, actualCopyOfResult.transportKindValue());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#equals(Object)}, and {@link
   * ImmutablePhysicalFlowInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowInfo#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowInfo.equals(Object)",
    "int ImmutablePhysicalFlowInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    Builder builderResult2 = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult2 = builderResult2.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult2 = criticalityResult2.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult2 =
        frequencyKindResult2
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult2 =
        physicalFlowExternalIdResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult2 =
        sourceResult2.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult2 =
        specificationResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo2 =
        targetResult2.transportKindValue(TransportKindValue.of("42")).build();

    // Act and Assert
    assertEquals(immutablePhysicalFlowInfo, immutablePhysicalFlowInfo2);
    assertEquals(immutablePhysicalFlowInfo.hashCode(), immutablePhysicalFlowInfo2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#equals(Object)}, and {@link
   * ImmutablePhysicalFlowInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowInfo#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowInfo.equals(Object)",
    "int ImmutablePhysicalFlowInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    // Act and Assert
    assertEquals(immutablePhysicalFlowInfo, immutablePhysicalFlowInfo);
    int expectedHashCodeResult = immutablePhysicalFlowInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalFlowInfo.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowInfo.equals(Object)",
    "int ImmutablePhysicalFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    builderResult.addDataTypes(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    Builder builderResult2 = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult2 = builderResult2.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult2 = criticalityResult2.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult2 =
        frequencyKindResult2
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult2 =
        physicalFlowExternalIdResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult2 =
        sourceResult2.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult2 =
        specificationResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowInfo,
        targetResult2.transportKindValue(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowInfo.equals(Object)",
    "int ImmutablePhysicalFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("Value"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    Builder builderResult2 = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult2 = builderResult2.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult2 = criticalityResult2.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult2 =
        frequencyKindResult2
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult2 =
        physicalFlowExternalIdResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult2 =
        sourceResult2.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult2 =
        specificationResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowInfo,
        targetResult2.transportKindValue(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowInfo.equals(Object)",
    "int ImmutablePhysicalFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("Value"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    Builder builderResult2 = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult2 = builderResult2.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult2 = criticalityResult2.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult2 =
        frequencyKindResult2
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult2 =
        physicalFlowExternalIdResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult2 =
        sourceResult2.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult2 =
        specificationResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowInfo,
        targetResult2.transportKindValue(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowInfo.equals(Object)",
    "int ImmutablePhysicalFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    Builder builderResult2 = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult2 = builderResult2.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult2 = criticalityResult2.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult2 =
        frequencyKindResult2
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult2 =
        physicalFlowExternalIdResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult2 =
        sourceResult2.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult2 =
        specificationResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowInfo,
        targetResult2.transportKindValue(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowInfo.equals(Object)",
    "int ImmutablePhysicalFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("42")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    Builder builderResult2 = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult2 = builderResult2.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult2 = criticalityResult2.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult2 =
        frequencyKindResult2
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult2 =
        physicalFlowExternalIdResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult2 =
        sourceResult2.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult2 =
        specificationResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowInfo,
        targetResult2.transportKindValue(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowInfo.equals(Object)",
    "int ImmutablePhysicalFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("Physical Flow External Id");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    Builder builderResult2 = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult2 = builderResult2.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult2 = criticalityResult2.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult2 =
        frequencyKindResult2
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult2 =
        physicalFlowExternalIdResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult2 =
        sourceResult2.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult2 =
        specificationResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowInfo,
        targetResult2.transportKindValue(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowInfo.equals(Object)",
    "int ImmutablePhysicalFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    Builder builderResult2 = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult2 = builderResult2.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult2 = criticalityResult2.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult2 =
        frequencyKindResult2
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult2 =
        physicalFlowExternalIdResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult2 =
        sourceResult2.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult2 =
        specificationResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowInfo,
        targetResult2.transportKindValue(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowInfo.equals(Object)",
    "int ImmutablePhysicalFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    Builder builderResult2 = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult2 = builderResult2.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult2 = criticalityResult2.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult2 =
        frequencyKindResult2
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult2 =
        physicalFlowExternalIdResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult2 =
        sourceResult2.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult2 =
        specificationResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowInfo,
        targetResult2.transportKindValue(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowInfo.equals(Object)",
    "int ImmutablePhysicalFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    Builder builderResult2 = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult2 = builderResult2.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult2 = criticalityResult2.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult2 =
        frequencyKindResult2
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult2 =
        physicalFlowExternalIdResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult2 =
        sourceResult2.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult2 =
        specificationResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowInfo,
        targetResult2.transportKindValue(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowInfo.equals(Object)",
    "int ImmutablePhysicalFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("Value")).build();

    Builder builderResult2 = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult2 = builderResult2.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult2 = criticalityResult2.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult2 =
        frequencyKindResult2
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult2 =
        physicalFlowExternalIdResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult2 =
        sourceResult2.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult2 =
        specificationResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowInfo,
        targetResult2.transportKindValue(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowInfo.equals(Object)",
    "int ImmutablePhysicalFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(targetResult.transportKindValue(TransportKindValue.of("42")).build(), null);
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowInfo.equals(Object)",
    "int ImmutablePhysicalFlowInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        targetResult.transportKindValue(TransportKindValue.of("42")).build(),
        "Different type to ImmutablePhysicalFlowInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowInfo#toString()}
   *   <li>{@link ImmutablePhysicalFlowInfo#criticality()}
   *   <li>{@link ImmutablePhysicalFlowInfo#dataTypes()}
   *   <li>{@link ImmutablePhysicalFlowInfo#frequencyKind()}
   *   <li>{@link ImmutablePhysicalFlowInfo#logicalFlow()}
   *   <li>{@link ImmutablePhysicalFlowInfo#physicalFlowDescription()}
   *   <li>{@link ImmutablePhysicalFlowInfo#physicalFlowExternalId()}
   *   <li>{@link ImmutablePhysicalFlowInfo#source()}
   *   <li>{@link ImmutablePhysicalFlowInfo#specification()}
   *   <li>{@link ImmutablePhysicalFlowInfo#target()}
   *   <li>{@link ImmutablePhysicalFlowInfo#transportKindValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CriticalityValue ImmutablePhysicalFlowInfo.criticality()",
    "List ImmutablePhysicalFlowInfo.dataTypes()",
    "FrequencyKindValue ImmutablePhysicalFlowInfo.frequencyKind()",
    "EntityReference ImmutablePhysicalFlowInfo.logicalFlow()",
    "String ImmutablePhysicalFlowInfo.physicalFlowDescription()",
    "String ImmutablePhysicalFlowInfo.physicalFlowExternalId()",
    "EntityReference ImmutablePhysicalFlowInfo.source()",
    "EntityReference ImmutablePhysicalFlowInfo.specification()",
    "EntityReference ImmutablePhysicalFlowInfo.target()",
    "String ImmutablePhysicalFlowInfo.toString()",
    "TransportKindValue ImmutablePhysicalFlowInfo.transportKindValue()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder criticalityResult = builderResult.criticality(criticality);
    FrequencyKindValue frequencyKind = FrequencyKindValue.of("42");

    Builder frequencyKindResult = criticalityResult.frequencyKind(frequencyKind);

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    TransportKindValue transportKindValue = TransportKindValue.of("42");
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(transportKindValue).build();

    // Act
    String actualToStringResult = immutablePhysicalFlowInfo.toString();
    CriticalityValue actualCriticalityResult = immutablePhysicalFlowInfo.criticality();
    List<EntityReference> actualDataTypesResult = immutablePhysicalFlowInfo.dataTypes();
    FrequencyKindValue actualFrequencyKindResult = immutablePhysicalFlowInfo.frequencyKind();
    EntityReference actualLogicalFlowResult = immutablePhysicalFlowInfo.logicalFlow();
    String actualPhysicalFlowDescriptionResult =
        immutablePhysicalFlowInfo.physicalFlowDescription();
    String actualPhysicalFlowExternalIdResult = immutablePhysicalFlowInfo.physicalFlowExternalId();
    EntityReference actualSourceResult = immutablePhysicalFlowInfo.source();
    EntityReference actualSpecificationResult = immutablePhysicalFlowInfo.specification();
    EntityReference actualTargetResult = immutablePhysicalFlowInfo.target();
    TransportKindValue actualTransportKindValueResult =
        immutablePhysicalFlowInfo.transportKindValue();

    // Assert
    assertTrue(actualLogicalFlowResult instanceof ImmutableEntityReference);
    assertTrue(actualSourceResult instanceof ImmutableEntityReference);
    assertTrue(actualSpecificationResult instanceof ImmutableEntityReference);
    assertTrue(actualTargetResult instanceof ImmutableEntityReference);
    assertEquals("42", actualCriticalityResult.value());
    assertEquals("42", actualFrequencyKindResult.value());
    assertEquals("42", actualPhysicalFlowExternalIdResult);
    assertEquals("42", actualTransportKindValueResult.value());
    assertEquals("Physical Flow Description", actualPhysicalFlowDescriptionResult);
    assertEquals(
        "PhysicalFlowInfo{source=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, target"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, specification=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, logicalFlow=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, physicalFlowExternalId=42, physicalFlowDescription=Physical Flow Description, transportKindValue"
            + "=42, frequencyKind=42, criticality=42, dataTypes=[]}",
        actualToStringResult);
    assertTrue(actualDataTypesResult.isEmpty());
    assertEquals(actualLogicalFlowResult, actualSourceResult);
    assertEquals(actualLogicalFlowResult, actualSpecificationResult);
    assertEquals(actualLogicalFlowResult, actualTargetResult);
    assertSame(criticality, actualCriticalityResult);
    assertSame(frequencyKind, actualFrequencyKindResult);
    assertSame(transportKindValue, actualTransportKindValueResult);
  }

  /**
   * Test Json {@link Json#criticality()}.
   *
   * <p>Method under test: {@link Json#criticality()}
   */
  @Test
  @DisplayName("Test Json criticality()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CriticalityValue Json.criticality()"})
  void testJsonCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().criticality());
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
  @MethodsUnderTest({"List Json.dataTypes()"})
  void testJsonDataTypes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dataTypes());
  }

  /**
   * Test Json {@link Json#frequencyKind()}.
   *
   * <p>Method under test: {@link Json#frequencyKind()}
   */
  @Test
  @DisplayName("Test Json frequencyKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FrequencyKindValue Json.frequencyKind()"})
  void testJsonFrequencyKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().frequencyKind());
  }

  /**
   * Test Json {@link Json#logicalFlow()}.
   *
   * <p>Method under test: {@link Json#logicalFlow()}
   */
  @Test
  @DisplayName("Test Json logicalFlow()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.logicalFlow()"})
  void testJsonLogicalFlow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().logicalFlow());
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
    assertNull(actualJson.physicalFlowDescription);
    assertNull(actualJson.physicalFlowExternalId);
    assertNull(actualJson.logicalFlow);
    assertNull(actualJson.source);
    assertNull(actualJson.specification);
    assertNull(actualJson.target);
    assertNull(actualJson.criticality);
    assertNull(actualJson.frequencyKind);
    assertNull(actualJson.transportKindValue);
    assertTrue(actualJson.dataTypes.isEmpty());
  }

  /**
   * Test Json {@link Json#physicalFlowDescription()}.
   *
   * <p>Method under test: {@link Json#physicalFlowDescription()}
   */
  @Test
  @DisplayName("Test Json physicalFlowDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.physicalFlowDescription()"})
  void testJsonPhysicalFlowDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().physicalFlowDescription());
  }

  /**
   * Test Json {@link Json#physicalFlowExternalId()}.
   *
   * <p>Method under test: {@link Json#physicalFlowExternalId()}
   */
  @Test
  @DisplayName("Test Json physicalFlowExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.physicalFlowExternalId()"})
  void testJsonPhysicalFlowExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().physicalFlowExternalId());
  }

  /**
   * Test Json {@link Json#source()}.
   *
   * <p>Method under test: {@link Json#source()}
   */
  @Test
  @DisplayName("Test Json source()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.source()"})
  void testJsonSource() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().source());
  }

  /**
   * Test Json {@link Json#specification()}.
   *
   * <p>Method under test: {@link Json#specification()}
   */
  @Test
  @DisplayName("Test Json specification()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.specification()"})
  void testJsonSpecification() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().specification());
  }

  /**
   * Test Json {@link Json#target()}.
   *
   * <p>Method under test: {@link Json#target()}
   */
  @Test
  @DisplayName("Test Json target()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.target()"})
  void testJsonTarget() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().target());
  }

  /**
   * Test Json {@link Json#transportKindValue()}.
   *
   * <p>Method under test: {@link Json#transportKindValue()}
   */
  @Test
  @DisplayName("Test Json transportKindValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TransportKindValue Json.transportKindValue()"})
  void testJsonTransportKindValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().transportKindValue());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#withCriticality(CriticalityValue)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#withCriticality(CriticalityValue)}
   */
  @Test
  @DisplayName("Test withCriticality(CriticalityValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowInfo ImmutablePhysicalFlowInfo.withCriticality(CriticalityValue)"
  })
  void testWithCriticality() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowInfo actualWithCriticalityResult =
        immutablePhysicalFlowInfo.withCriticality(CriticalityValue.of("42"));

    // Assert
    assertEquals(immutablePhysicalFlowInfo, actualWithCriticalityResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#withDataTypes(EntityReference[])} with {@code
   * EntityReference[]}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#withDataTypes(EntityReference[])}
   */
  @Test
  @DisplayName("Test withDataTypes(EntityReference[]) with 'EntityReference[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowInfo ImmutablePhysicalFlowInfo.withDataTypes(EntityReference[])"
  })
  void testWithDataTypesWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder criticalityResult = builderResult.criticality(criticality);
    FrequencyKindValue frequencyKind = FrequencyKindValue.of("42");

    Builder frequencyKindResult = criticalityResult.frequencyKind(frequencyKind);

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    TransportKindValue transportKindValue = TransportKindValue.of("42");
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(transportKindValue).build();

    // Act
    ImmutablePhysicalFlowInfo actualWithDataTypesResult =
        immutablePhysicalFlowInfo.withDataTypes(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    EntityReference logicalFlowResult = actualWithDataTypesResult.logicalFlow();
    assertTrue(logicalFlowResult instanceof ImmutableEntityReference);
    EntityReference sourceResult2 = actualWithDataTypesResult.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference specificationResult2 = actualWithDataTypesResult.specification();
    assertTrue(specificationResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult2 = actualWithDataTypesResult.target();
    assertTrue(targetResult2 instanceof ImmutableEntityReference);
    assertEquals("42", actualWithDataTypesResult.physicalFlowExternalId());
    assertEquals("Physical Flow Description", actualWithDataTypesResult.physicalFlowDescription());
    assertEquals(1, actualWithDataTypesResult.dataTypes().size());
    assertEquals(logicalFlowResult, sourceResult2);
    assertEquals(logicalFlowResult, specificationResult2);
    assertEquals(logicalFlowResult, targetResult2);
    assertSame(criticality, actualWithDataTypesResult.criticality());
    assertSame(frequencyKind, actualWithDataTypesResult.frequencyKind());
    assertSame(transportKindValue, actualWithDataTypesResult.transportKindValue());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#withFrequencyKind(FrequencyKindValue)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#withFrequencyKind(FrequencyKindValue)}
   */
  @Test
  @DisplayName("Test withFrequencyKind(FrequencyKindValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowInfo ImmutablePhysicalFlowInfo.withFrequencyKind(FrequencyKindValue)"
  })
  void testWithFrequencyKind() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowInfo actualWithFrequencyKindResult =
        immutablePhysicalFlowInfo.withFrequencyKind(FrequencyKindValue.of("42"));

    // Assert
    assertEquals(immutablePhysicalFlowInfo, actualWithFrequencyKindResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#withLogicalFlow(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#withLogicalFlow(EntityReference)}
   */
  @Test
  @DisplayName("Test withLogicalFlow(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowInfo ImmutablePhysicalFlowInfo.withLogicalFlow(EntityReference)"
  })
  void testWithLogicalFlow() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowInfo actualWithLogicalFlowResult =
        immutablePhysicalFlowInfo.withLogicalFlow(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePhysicalFlowInfo, actualWithLogicalFlowResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#withPhysicalFlowDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#withPhysicalFlowDescription(String)}
   */
  @Test
  @DisplayName("Test withPhysicalFlowDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowInfo ImmutablePhysicalFlowInfo.withPhysicalFlowDescription(String)"
  })
  void testWithPhysicalFlowDescription() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("42")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowInfo actualWithPhysicalFlowDescriptionResult =
        immutablePhysicalFlowInfo.withPhysicalFlowDescription("42");

    // Assert
    assertSame(immutablePhysicalFlowInfo, actualWithPhysicalFlowDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#withPhysicalFlowDescription(String)}.
   *
   * <ul>
   *   <li>Then logicalFlow return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#withPhysicalFlowDescription(String)}
   */
  @Test
  @DisplayName(
      "Test withPhysicalFlowDescription(String); then logicalFlow return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowInfo ImmutablePhysicalFlowInfo.withPhysicalFlowDescription(String)"
  })
  void testWithPhysicalFlowDescription_thenLogicalFlowReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder criticalityResult = builderResult.criticality(criticality);
    FrequencyKindValue frequencyKind = FrequencyKindValue.of("42");

    Builder frequencyKindResult = criticalityResult.frequencyKind(frequencyKind);

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    TransportKindValue transportKindValue = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlowInfo actualWithPhysicalFlowDescriptionResult =
        targetResult
            .transportKindValue(transportKindValue)
            .build()
            .withPhysicalFlowDescription("42");

    // Assert
    EntityReference logicalFlowResult = actualWithPhysicalFlowDescriptionResult.logicalFlow();
    assertTrue(logicalFlowResult instanceof ImmutableEntityReference);
    EntityReference sourceResult2 = actualWithPhysicalFlowDescriptionResult.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference specificationResult2 = actualWithPhysicalFlowDescriptionResult.specification();
    assertTrue(specificationResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult2 = actualWithPhysicalFlowDescriptionResult.target();
    assertTrue(targetResult2 instanceof ImmutableEntityReference);
    assertEquals("42", actualWithPhysicalFlowDescriptionResult.physicalFlowDescription());
    assertEquals("42", actualWithPhysicalFlowDescriptionResult.physicalFlowExternalId());
    assertTrue(actualWithPhysicalFlowDescriptionResult.dataTypes().isEmpty());
    assertEquals(logicalFlowResult, sourceResult2);
    assertEquals(logicalFlowResult, specificationResult2);
    assertEquals(logicalFlowResult, targetResult2);
    assertSame(criticality, actualWithPhysicalFlowDescriptionResult.criticality());
    assertSame(frequencyKind, actualWithPhysicalFlowDescriptionResult.frequencyKind());
    assertSame(transportKindValue, actualWithPhysicalFlowDescriptionResult.transportKindValue());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#withPhysicalFlowExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#withPhysicalFlowExternalId(String)}
   */
  @Test
  @DisplayName("Test withPhysicalFlowExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowInfo ImmutablePhysicalFlowInfo.withPhysicalFlowExternalId(String)"
  })
  void testWithPhysicalFlowExternalId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowInfo actualWithPhysicalFlowExternalIdResult =
        immutablePhysicalFlowInfo.withPhysicalFlowExternalId("42");

    // Assert
    assertSame(immutablePhysicalFlowInfo, actualWithPhysicalFlowExternalIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#withPhysicalFlowExternalId(String)}.
   *
   * <ul>
   *   <li>Then logicalFlow return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#withPhysicalFlowExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withPhysicalFlowExternalId(String); then logicalFlow return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowInfo ImmutablePhysicalFlowInfo.withPhysicalFlowExternalId(String)"
  })
  void testWithPhysicalFlowExternalId_thenLogicalFlowReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder criticalityResult = builderResult.criticality(criticality);
    FrequencyKindValue frequencyKind = FrequencyKindValue.of("42");

    Builder frequencyKindResult = criticalityResult.frequencyKind(frequencyKind);

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("Physical Flow External Id");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    TransportKindValue transportKindValue = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlowInfo actualWithPhysicalFlowExternalIdResult =
        targetResult
            .transportKindValue(transportKindValue)
            .build()
            .withPhysicalFlowExternalId("42");

    // Assert
    EntityReference logicalFlowResult = actualWithPhysicalFlowExternalIdResult.logicalFlow();
    assertTrue(logicalFlowResult instanceof ImmutableEntityReference);
    EntityReference sourceResult2 = actualWithPhysicalFlowExternalIdResult.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference specificationResult2 = actualWithPhysicalFlowExternalIdResult.specification();
    assertTrue(specificationResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult2 = actualWithPhysicalFlowExternalIdResult.target();
    assertTrue(targetResult2 instanceof ImmutableEntityReference);
    assertEquals("42", actualWithPhysicalFlowExternalIdResult.physicalFlowExternalId());
    assertEquals(
        "Physical Flow Description",
        actualWithPhysicalFlowExternalIdResult.physicalFlowDescription());
    assertTrue(actualWithPhysicalFlowExternalIdResult.dataTypes().isEmpty());
    assertEquals(logicalFlowResult, sourceResult2);
    assertEquals(logicalFlowResult, specificationResult2);
    assertEquals(logicalFlowResult, targetResult2);
    assertSame(criticality, actualWithPhysicalFlowExternalIdResult.criticality());
    assertSame(frequencyKind, actualWithPhysicalFlowExternalIdResult.frequencyKind());
    assertSame(transportKindValue, actualWithPhysicalFlowExternalIdResult.transportKindValue());
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#withSource(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#withSource(EntityReference)}
   */
  @Test
  @DisplayName("Test withSource(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowInfo ImmutablePhysicalFlowInfo.withSource(EntityReference)"
  })
  void testWithSource() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowInfo actualWithSourceResult =
        immutablePhysicalFlowInfo.withSource(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePhysicalFlowInfo, actualWithSourceResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#withSpecification(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#withSpecification(EntityReference)}
   */
  @Test
  @DisplayName("Test withSpecification(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowInfo ImmutablePhysicalFlowInfo.withSpecification(EntityReference)"
  })
  void testWithSpecification() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowInfo actualWithSpecificationResult =
        immutablePhysicalFlowInfo.withSpecification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePhysicalFlowInfo, actualWithSpecificationResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#withTarget(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowInfo#withTarget(EntityReference)}
   */
  @Test
  @DisplayName("Test withTarget(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowInfo ImmutablePhysicalFlowInfo.withTarget(EntityReference)"
  })
  void testWithTarget() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowInfo actualWithTargetResult =
        immutablePhysicalFlowInfo.withTarget(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePhysicalFlowInfo, actualWithTargetResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowInfo#withTransportKindValue(TransportKindValue)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowInfo#withTransportKindValue(TransportKindValue)}
   */
  @Test
  @DisplayName("Test withTransportKindValue(TransportKindValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowInfo ImmutablePhysicalFlowInfo.withTransportKindValue(TransportKindValue)"
  })
  void testWithTransportKindValue() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowInfo.builder();

    Builder criticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    Builder frequencyKindResult = criticalityResult.frequencyKind(FrequencyKindValue.of("42"));

    Builder physicalFlowExternalIdResult =
        frequencyKindResult
            .logicalFlow(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowDescription("Physical Flow Description")
            .physicalFlowExternalId("42");

    Builder sourceResult =
        physicalFlowExternalIdResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specificationResult =
        sourceResult.specification(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder targetResult =
        specificationResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowInfo immutablePhysicalFlowInfo =
        targetResult.transportKindValue(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowInfo actualWithTransportKindValueResult =
        immutablePhysicalFlowInfo.withTransportKindValue(TransportKindValue.of("42"));

    // Assert
    assertEquals(immutablePhysicalFlowInfo, actualWithTransportKindValueResult);
  }
}
