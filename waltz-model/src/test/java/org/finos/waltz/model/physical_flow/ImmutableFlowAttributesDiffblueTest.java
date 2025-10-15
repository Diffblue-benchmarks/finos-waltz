package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.physical_flow.ImmutableFlowAttributes.Builder;
import org.finos.waltz.model.physical_flow.ImmutableFlowAttributes.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowAttributesDiffblueTest {
  /**
   * Test Builder {@link Builder#basisOffset(int)}.
   *
   * <p>Method under test: {@link Builder#basisOffset(int)}
   */
  @Test
  @DisplayName("Test Builder basisOffset(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.basisOffset(int)"})
  void testBuilderBasisOffset() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();

    // Act
    Builder actualBasisOffsetResult = builderResult.basisOffset(1);

    // Assert
    assertSame(builderResult, actualBasisOffsetResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#name(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowAttributes Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.name(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBasisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");
    Builder actualExternalIdResult =
        actualBasisOffsetResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualExternalIdResult2 = actualExternalIdResult.externalId(externalId);
    FrequencyKindValue frequency = FrequencyKindValue.of("42");
    Builder actualNameResult = actualExternalIdResult2.frequency(frequency).name("Name");
    TransportKindValue transport = TransportKindValue.of("42");
    ImmutableFlowAttributes actualImmutableFlowAttributes =
        actualNameResult.transport(transport).build();

    // Assert
    CriticalityValue criticalityResult = actualImmutableFlowAttributes.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualImmutableFlowAttributes.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualImmutableFlowAttributes.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualImmutableFlowAttributes.name());
    assertEquals(
        "The characteristics of someone or something", actualImmutableFlowAttributes.description());
    assertEquals(1, actualImmutableFlowAttributes.basisOffset());
    assertSame(criticality, criticalityResult);
    assertSame(frequency, frequencyResult);
    assertSame(transport, transportResult);
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
    Builder builderResult = ImmutableFlowAttributes.builder();

    // Act
    Builder actualCriticalityResult = builderResult.criticality(CriticalityValue.of("42"));

    // Assert
    assertSame(builderResult, actualCriticalityResult);
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#frequency(FrequencyKindValue)}.
   *
   * <ul>
   *   <li>When {@link FrequencyKindValue} with value is {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#frequency(FrequencyKindValue)}
   */
  @Test
  @DisplayName(
      "Test Builder frequency(FrequencyKindValue); when FrequencyKindValue with value is '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.frequency(FrequencyKindValue)"})
  void testBuilderFrequency_whenFrequencyKindValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();

    // Act
    Builder actualFrequencyResult = builderResult.frequency(FrequencyKindValue.of("42"));

    // Assert
    assertSame(builderResult, actualFrequencyResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();

    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes instance = nameResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutableFlowAttributes actualImmutableFlowAttributes =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableFlowAttributes);
    ImmutableFlowAttributes actualImmutableFlowAttributes2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowAttributes2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider2() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();

    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name(null);
    ImmutableFlowAttributes instance = nameResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutableFlowAttributes actualImmutableFlowAttributes =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableFlowAttributes);
    ImmutableFlowAttributes actualImmutableFlowAttributes2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowAttributes2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();

    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes instance = nameResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutableFlowAttributes actualImmutableFlowAttributes =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableFlowAttributes);
    ImmutableFlowAttributes actualImmutableFlowAttributes2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowAttributes2);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(FlowAttributes)} with {@code FlowAttributes}.
   *
   * <p>Method under test: {@link Builder#from(FlowAttributes)}
   */
  @Test
  @DisplayName("Test Builder from(FlowAttributes) with 'FlowAttributes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowAttributes)"})
  void testBuilderFromWithFlowAttributes() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();

    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes instance = nameResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutableFlowAttributes actualImmutableFlowAttributes = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowAttributes);
    ImmutableFlowAttributes actualImmutableFlowAttributes2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowAttributes2);
  }

  /**
   * Test Builder {@link Builder#from(FlowAttributes)} with {@code FlowAttributes}.
   *
   * <p>Method under test: {@link Builder#from(FlowAttributes)}
   */
  @Test
  @DisplayName("Test Builder from(FlowAttributes) with 'FlowAttributes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowAttributes)"})
  void testBuilderFromWithFlowAttributes2() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();

    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult.criticality(CriticalityValue.of("42")).description(null).externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes instance = nameResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutableFlowAttributes actualImmutableFlowAttributes = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowAttributes);
    ImmutableFlowAttributes actualImmutableFlowAttributes2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowAttributes2);
  }

  /**
   * Test Builder {@link Builder#from(FlowAttributes)} with {@code FlowAttributes}.
   *
   * <p>Method under test: {@link Builder#from(FlowAttributes)}
   */
  @Test
  @DisplayName("Test Builder from(FlowAttributes) with 'FlowAttributes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowAttributes)"})
  void testBuilderFromWithFlowAttributes3() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();

    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name(null);
    ImmutableFlowAttributes instance = nameResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutableFlowAttributes actualImmutableFlowAttributes = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowAttributes);
    ImmutableFlowAttributes actualImmutableFlowAttributes2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowAttributes2);
  }

  /**
   * Test Builder {@link Builder#transport(TransportKindValue)}.
   *
   * <ul>
   *   <li>When {@link TransportKindValue} with value is {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#transport(TransportKindValue)}
   */
  @Test
  @DisplayName(
      "Test Builder transport(TransportKindValue); when TransportKindValue with value is '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.transport(TransportKindValue)"})
  void testBuilderTransport_whenTransportKindValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();

    // Act
    Builder actualTransportResult = builderResult.transport(TransportKindValue.of("42"));

    // Assert
    assertSame(builderResult, actualTransportResult);
  }

  /**
   * Test {@link ImmutableFlowAttributes#copyOf(FlowAttributes)}.
   *
   * <ul>
   *   <li>Then return criticality value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#copyOf(FlowAttributes)}
   */
  @Test
  @DisplayName("Test copyOf(FlowAttributes); then return criticality value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowAttributes ImmutableFlowAttributes.copyOf(FlowAttributes)"})
  void testCopyOf_thenReturnCriticalityValueIs42() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        basisOffsetResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder nameResult = externalIdResult.frequency(frequency).name("Name");
    TransportKindValue transport = TransportKindValue.of("42");
    ImmutableFlowAttributes instance = nameResult.transport(transport).build();

    // Act
    ImmutableFlowAttributes actualCopyOfResult = ImmutableFlowAttributes.copyOf(instance);

    // Assert
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.basisOffset());
    assertSame(criticality, criticalityResult);
    assertSame(frequency, frequencyResult);
    assertSame(transport, transportResult);
  }

  /**
   * Test {@link ImmutableFlowAttributes#equals(Object)}, and {@link
   * ImmutableFlowAttributes#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowAttributes#equals(Object)}
   *   <li>{@link ImmutableFlowAttributes#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowAttributes.equals(Object)",
    "int ImmutableFlowAttributes.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult2 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult2 = externalIdResult2.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes immutableFlowAttributes2 =
        nameResult2.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    assertEquals(immutableFlowAttributes, immutableFlowAttributes2);
    assertEquals(immutableFlowAttributes.hashCode(), immutableFlowAttributes2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowAttributes#equals(Object)}, and {@link
   * ImmutableFlowAttributes#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowAttributes#equals(Object)}
   *   <li>{@link ImmutableFlowAttributes#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowAttributes.equals(Object)",
    "int ImmutableFlowAttributes.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    assertEquals(immutableFlowAttributes, immutableFlowAttributes);
    int expectedHashCodeResult = immutableFlowAttributes.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowAttributes.hashCode());
  }

  /**
   * Test {@link ImmutableFlowAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowAttributes.equals(Object)",
    "int ImmutableFlowAttributes.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(6);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult2 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult2 = externalIdResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    // Act and Assert
    assertNotEquals(
        immutableFlowAttributes, nameResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableFlowAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowAttributes.equals(Object)",
    "int ImmutableFlowAttributes.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("Value"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult2 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult2 = externalIdResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    // Act and Assert
    assertNotEquals(
        immutableFlowAttributes, nameResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableFlowAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowAttributes.equals(Object)",
    "int ImmutableFlowAttributes.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("External Id");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult2 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult2 = externalIdResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    // Act and Assert
    assertNotEquals(
        immutableFlowAttributes, nameResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableFlowAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowAttributes.equals(Object)",
    "int ImmutableFlowAttributes.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("Value")).name("Name");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult2 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult2 = externalIdResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    // Act and Assert
    assertNotEquals(
        immutableFlowAttributes, nameResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableFlowAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowAttributes.equals(Object)",
    "int ImmutableFlowAttributes.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("42");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult2 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult2 = externalIdResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    // Act and Assert
    assertNotEquals(
        immutableFlowAttributes, nameResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableFlowAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowAttributes.equals(Object)",
    "int ImmutableFlowAttributes.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("Value")).build();

    Builder basisOffsetResult2 = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult2 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult2 = externalIdResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    // Act and Assert
    assertNotEquals(
        immutableFlowAttributes, nameResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutableFlowAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowAttributes.equals(Object)",
    "int ImmutableFlowAttributes.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    // Act and Assert
    assertNotEquals(nameResult.transport(TransportKindValue.of("42")).build(), null);
  }

  /**
   * Test {@link ImmutableFlowAttributes#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowAttributes.equals(Object)",
    "int ImmutableFlowAttributes.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    // Act and Assert
    assertNotEquals(
        nameResult.transport(TransportKindValue.of("42")).build(),
        "Different type to ImmutableFlowAttributes");
  }

  /**
   * Test {@link ImmutableFlowAttributes#externalId()}.
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableFlowAttributes.externalId()"})
  void testExternalId() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    // Act
    Optional<String> actualExternalIdResult =
        nameResult.transport(TransportKindValue.of("42")).build().externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowAttributes#basisOffset()}
   *   <li>{@link ImmutableFlowAttributes#criticality()}
   *   <li>{@link ImmutableFlowAttributes#description()}
   *   <li>{@link ImmutableFlowAttributes#frequency()}
   *   <li>{@link ImmutableFlowAttributes#name()}
   *   <li>{@link ImmutableFlowAttributes#transport()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableFlowAttributes.basisOffset()",
    "CriticalityValue ImmutableFlowAttributes.criticality()",
    "String ImmutableFlowAttributes.description()",
    "FrequencyKindValue ImmutableFlowAttributes.frequency()",
    "String ImmutableFlowAttributes.name()",
    "TransportKindValue ImmutableFlowAttributes.transport()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        basisOffsetResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder nameResult = externalIdResult.frequency(frequency).name("Name");
    TransportKindValue transport = TransportKindValue.of("42");
    ImmutableFlowAttributes immutableFlowAttributes = nameResult.transport(transport).build();

    // Act
    int actualBasisOffsetResult = immutableFlowAttributes.basisOffset();
    CriticalityValue actualCriticalityResult = immutableFlowAttributes.criticality();
    String actualDescriptionResult = immutableFlowAttributes.description();
    FrequencyKindValue actualFrequencyResult = immutableFlowAttributes.frequency();
    String actualNameResult = immutableFlowAttributes.name();
    TransportKindValue actualTransportResult = immutableFlowAttributes.transport();

    // Assert
    assertEquals("42", actualCriticalityResult.value());
    assertEquals("42", actualFrequencyResult.value());
    assertEquals("42", actualTransportResult.value());
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1, actualBasisOffsetResult);
    assertSame(criticality, actualCriticalityResult);
    assertSame(frequency, actualFrequencyResult);
    assertSame(transport, actualTransportResult);
  }

  /**
   * Test Json {@link Json#basisOffset()}.
   *
   * <p>Method under test: {@link Json#basisOffset()}
   */
  @Test
  @DisplayName("Test Json basisOffset()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.basisOffset()"})
  void testJsonBasisOffset() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().basisOffset());
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
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json {@link Json#frequency()}.
   *
   * <p>Method under test: {@link Json#frequency()}
   */
  @Test
  @DisplayName("Test Json frequency()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FrequencyKindValue Json.frequency()"})
  void testJsonFrequency() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().frequency());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
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
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.criticality);
    assertNull(actualJson.frequency);
    assertNull(actualJson.transport);
    assertEquals(0, actualJson.basisOffset);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.basisOffsetIsSet);
  }

  /**
   * Test Json {@link Json#setBasisOffset(int)}.
   *
   * <p>Method under test: {@link Json#setBasisOffset(int)}
   */
  @Test
  @DisplayName("Test Json setBasisOffset(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setBasisOffset(int)"})
  void testJsonSetBasisOffset() {
    // Arrange
    Json json = new Json();

    // Act
    json.setBasisOffset(1);

    // Assert
    assertEquals(1, json.basisOffset);
    assertTrue(json.basisOffsetIsSet);
  }

  /**
   * Test Json {@link Json#transport()}.
   *
   * <p>Method under test: {@link Json#transport()}
   */
  @Test
  @DisplayName("Test Json transport()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TransportKindValue Json.transport()"})
  void testJsonTransport() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().transport());
  }

  /**
   * Test {@link ImmutableFlowAttributes#toString()}.
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableFlowAttributes.toString()"})
  void testToString() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    // Act and Assert
    assertEquals(
        "FlowAttributes{externalId=42, name=Name, transport=42, frequency=42, criticality=42, basisOffset=1}",
        nameResult.transport(TransportKindValue.of("42")).build().toString());
  }

  /**
   * Test {@link ImmutableFlowAttributes#toString()}.
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableFlowAttributes.toString()"})
  void testToString2() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name(null);

    // Act and Assert
    assertEquals(
        "FlowAttributes{externalId=42, transport=42, frequency=42, criticality=42, basisOffset=1}",
        nameResult.transport(TransportKindValue.of("42")).build().toString());
  }

  /**
   * Test {@link ImmutableFlowAttributes#withBasisOffset(int)}.
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#withBasisOffset(int)}
   */
  @Test
  @DisplayName("Test withBasisOffset(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowAttributes ImmutableFlowAttributes.withBasisOffset(int)"})
  void testWithBasisOffset() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(42);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutableFlowAttributes actualWithBasisOffsetResult =
        immutableFlowAttributes.withBasisOffset(42);

    // Assert
    assertSame(immutableFlowAttributes, actualWithBasisOffsetResult);
  }

  /**
   * Test {@link ImmutableFlowAttributes#withBasisOffset(int)}.
   *
   * <ul>
   *   <li>Then return criticality value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#withBasisOffset(int)}
   */
  @Test
  @DisplayName("Test withBasisOffset(int); then return criticality value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowAttributes ImmutableFlowAttributes.withBasisOffset(int)"})
  void testWithBasisOffset_thenReturnCriticalityValueIs42() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        basisOffsetResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder nameResult = externalIdResult.frequency(frequency).name("Name");
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutableFlowAttributes actualWithBasisOffsetResult =
        nameResult.transport(transport).build().withBasisOffset(42);

    // Assert
    CriticalityValue criticalityResult = actualWithBasisOffsetResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualWithBasisOffsetResult.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualWithBasisOffsetResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualWithBasisOffsetResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithBasisOffsetResult.description());
    assertEquals(42, actualWithBasisOffsetResult.basisOffset());
    assertSame(criticality, criticalityResult);
    assertSame(frequency, frequencyResult);
    assertSame(transport, transportResult);
  }

  /**
   * Test {@link ImmutableFlowAttributes#withCriticality(CriticalityValue)}.
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#withCriticality(CriticalityValue)}
   */
  @Test
  @DisplayName("Test withCriticality(CriticalityValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowAttributes ImmutableFlowAttributes.withCriticality(CriticalityValue)"
  })
  void testWithCriticality() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutableFlowAttributes actualWithCriticalityResult =
        immutableFlowAttributes.withCriticality(CriticalityValue.of("42"));

    // Assert
    assertEquals(immutableFlowAttributes, actualWithCriticalityResult);
  }

  /**
   * Test {@link ImmutableFlowAttributes#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowAttributes ImmutableFlowAttributes.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutableFlowAttributes actualWithDescriptionResult =
        immutableFlowAttributes.withDescription("42");

    // Assert
    assertEquals(immutableFlowAttributes, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableFlowAttributes#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowAttributes ImmutableFlowAttributes.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult.criticality(CriticalityValue.of("42")).description("42").externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutableFlowAttributes actualWithDescriptionResult =
        immutableFlowAttributes.withDescription("42");

    // Assert
    assertSame(immutableFlowAttributes, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableFlowAttributes#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowAttributes ImmutableFlowAttributes.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableFlowAttributes actualWithExternalIdResult =
        immutableFlowAttributes.withExternalId(optional);

    // Assert
    assertSame(immutableFlowAttributes, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableFlowAttributes#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return criticality value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; when of 'foo'; then return criticality value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowAttributes ImmutableFlowAttributes.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnCriticalityValueIs42() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        basisOffsetResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder nameResult = externalIdResult.frequency(frequency).name("Name");
    TransportKindValue transport = TransportKindValue.of("42");
    ImmutableFlowAttributes immutableFlowAttributes = nameResult.transport(transport).build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableFlowAttributes actualWithExternalIdResult =
        immutableFlowAttributes.withExternalId(optional);

    // Assert
    CriticalityValue criticalityResult = actualWithExternalIdResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualWithExternalIdResult.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualWithExternalIdResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1, actualWithExternalIdResult.basisOffset());
    assertSame(criticality, criticalityResult);
    assertSame(frequency, frequencyResult);
    assertSame(transport, transportResult);
  }

  /**
   * Test {@link ImmutableFlowAttributes#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowAttributes ImmutableFlowAttributes.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutableFlowAttributes actualWithExternalIdResult =
        immutableFlowAttributes.withExternalId("42");

    // Assert
    assertSame(immutableFlowAttributes, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableFlowAttributes#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return criticality value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return criticality value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowAttributes ImmutableFlowAttributes.withExternalId(String)"})
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnCriticalityValueIs42() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        basisOffsetResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder nameResult = externalIdResult.frequency(frequency).name("Name");
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutableFlowAttributes actualWithExternalIdResult =
        nameResult.transport(transport).build().withExternalId("0123456789ABCDEF");

    // Assert
    CriticalityValue criticalityResult = actualWithExternalIdResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualWithExternalIdResult.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualWithExternalIdResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1, actualWithExternalIdResult.basisOffset());
    assertSame(criticality, criticalityResult);
    assertSame(frequency, frequencyResult);
    assertSame(transport, transportResult);
  }

  /**
   * Test {@link ImmutableFlowAttributes#withFrequency(FrequencyKindValue)}.
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#withFrequency(FrequencyKindValue)}
   */
  @Test
  @DisplayName("Test withFrequency(FrequencyKindValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowAttributes ImmutableFlowAttributes.withFrequency(FrequencyKindValue)"
  })
  void testWithFrequency() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutableFlowAttributes actualWithFrequencyResult =
        immutableFlowAttributes.withFrequency(FrequencyKindValue.of("42"));

    // Assert
    assertEquals(immutableFlowAttributes, actualWithFrequencyResult);
  }

  /**
   * Test {@link ImmutableFlowAttributes#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowAttributes ImmutableFlowAttributes.withName(String)"})
  void testWithName() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("42");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutableFlowAttributes actualWithNameResult = immutableFlowAttributes.withName("42");

    // Assert
    assertSame(immutableFlowAttributes, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableFlowAttributes#withName(String)}.
   *
   * <ul>
   *   <li>Then return criticality value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return criticality value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowAttributes ImmutableFlowAttributes.withName(String)"})
  void testWithName_thenReturnCriticalityValueIs42() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        basisOffsetResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder nameResult = externalIdResult.frequency(frequency).name("Name");
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutableFlowAttributes actualWithNameResult =
        nameResult.transport(transport).build().withName("42");

    // Assert
    CriticalityValue criticalityResult = actualWithNameResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualWithNameResult.frequency();
    assertEquals("42", frequencyResult.value());
    assertEquals("42", actualWithNameResult.name());
    TransportKindValue transportResult = actualWithNameResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1, actualWithNameResult.basisOffset());
    assertSame(criticality, criticalityResult);
    assertSame(frequency, frequencyResult);
    assertSame(transport, transportResult);
  }

  /**
   * Test {@link ImmutableFlowAttributes#withTransport(TransportKindValue)}.
   *
   * <p>Method under test: {@link ImmutableFlowAttributes#withTransport(TransportKindValue)}
   */
  @Test
  @DisplayName("Test withTransport(TransportKindValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowAttributes ImmutableFlowAttributes.withTransport(TransportKindValue)"
  })
  void testWithTransport() {
    // Arrange
    Builder basisOffsetResult = ImmutableFlowAttributes.builder().basisOffset(1);

    Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult = externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes immutableFlowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutableFlowAttributes actualWithTransportResult =
        immutableFlowAttributes.withTransport(TransportKindValue.of("42"));

    // Assert
    assertEquals(immutableFlowAttributes, actualWithTransportResult);
  }
}
