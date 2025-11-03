package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   * Test {@link ImmutableFlowAttributes#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowAttributes#builder()}
   *   <li>{@link ImmutableFlowAttributes#description(String)}
   *   <li>{@link ImmutableFlowAttributes#externalId(String)}
   *   <li>{@link ImmutableFlowAttributes#name(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowAttributes Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.externalId(String)", "Builder Builder.name(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualExternalIdResult = ImmutableFlowAttributes.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualExternalIdResult2 = actualExternalIdResult.externalId(externalId);

    // Assert
    assertSame(actualExternalIdResult2, actualExternalIdResult2.name("Name"));
  }

  /**
   * Test Builder {@link Builder#basisOffset(int)}.
   * <p>
   * Method under test: {@link Builder#basisOffset(int)}
   */
  @Test
  @DisplayName("Test Builder basisOffset(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.basisOffset(int)"})
  void testBuilderBasisOffset() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.basisOffset(1));
  }

  /**
   * Test Builder {@link Builder#criticality(CriticalityValue)}.
   * <ul>
   *   <li>When {@link CriticalityValue} with value is {@code 42}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#criticality(CriticalityValue)}
   */
  @Test
  @DisplayName("Test Builder criticality(CriticalityValue); when CriticalityValue with value is '42'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.criticality(CriticalityValue)"})
  void testBuilderCriticality_whenCriticalityValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.criticality(CriticalityValue.of("42")));
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Test Builder {@link Builder#frequency(FrequencyKindValue)}.
   * <ul>
   *   <li>When {@link FrequencyKindValue} with value is {@code 42}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#frequency(FrequencyKindValue)}
   */
  @Test
  @DisplayName("Test Builder frequency(FrequencyKindValue); when FrequencyKindValue with value is '42'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.frequency(FrequencyKindValue)"})
  void testBuilderFrequency_whenFrequencyKindValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.frequency(FrequencyKindValue.of("42")));
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
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
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
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
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(FlowAttributes)} with {@code FlowAttributes}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowAttributes)}
   */
  @Test
  @DisplayName("Test Builder from(FlowAttributes) with 'FlowAttributes'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowAttributes)"})
  void testBuilderFromWithFlowAttributes_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();
    FlowAttributes instance = mock(FlowAttributes.class);
    when(instance.frequency()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.transport()).thenReturn(TransportKindValue.of("42"));
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).transport();
    ImmutableFlowAttributes buildResult = actualFromResult.build();
    assertEquals("Name", buildResult.name());
    ImmutableFlowAttributes buildResult2 = builderResult.build();
    assertEquals("Name", buildResult2.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", buildResult2.description());
  }

  /**
   * Test Builder {@link Builder#from(FlowAttributes)} with {@code FlowAttributes}.
   * <ul>
   *   <li>Then return build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowAttributes)}
   */
  @Test
  @DisplayName("Test Builder from(FlowAttributes) with 'FlowAttributes'; then return build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowAttributes)"})
  void testBuilderFromWithFlowAttributes_thenReturnBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();
    FlowAttributes instance = mock(FlowAttributes.class);
    when(instance.frequency()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.transport()).thenReturn(TransportKindValue.of("42"));
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn(null);
    when(instance.name()).thenReturn("Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).transport();
    ImmutableFlowAttributes buildResult = actualFromResult.build();
    assertEquals("Name", buildResult.name());
    ImmutableFlowAttributes buildResult2 = builderResult.build();
    assertEquals("Name", buildResult2.name());
    assertNull(buildResult.description());
    assertNull(buildResult2.description());
  }

  /**
   * Test Builder {@link Builder#from(FlowAttributes)} with {@code FlowAttributes}.
   * <ul>
   *   <li>Then return build name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowAttributes)}
   */
  @Test
  @DisplayName("Test Builder from(FlowAttributes) with 'FlowAttributes'; then return build name is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowAttributes)"})
  void testBuilderFromWithFlowAttributes_thenReturnBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();
    FlowAttributes instance = mock(FlowAttributes.class);
    when(instance.frequency()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.transport()).thenReturn(TransportKindValue.of("42"));
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).transport();
    ImmutableFlowAttributes buildResult = actualFromResult.build();
    assertEquals("Name", buildResult.name());
    ImmutableFlowAttributes buildResult2 = builderResult.build();
    assertEquals("Name", buildResult2.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", buildResult2.description());
  }

  /**
   * Test Builder {@link Builder#from(FlowAttributes)} with {@code FlowAttributes}.
   * <ul>
   *   <li>Then return build name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowAttributes)}
   */
  @Test
  @DisplayName("Test Builder from(FlowAttributes) with 'FlowAttributes'; then return build name is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowAttributes)"})
  void testBuilderFromWithFlowAttributes_thenReturnBuildNameIsNull() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();
    FlowAttributes instance = mock(FlowAttributes.class);
    when(instance.frequency()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.transport()).thenReturn(TransportKindValue.of("42"));
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).transport();
    ImmutableFlowAttributes buildResult = actualFromResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    ImmutableFlowAttributes buildResult2 = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult2.description());
    assertNull(buildResult.name());
    assertNull(buildResult2.name());
  }

  /**
   * Test Builder {@link Builder#from(FlowAttributes)} with {@code FlowAttributes}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowAttributes)}
   */
  @Test
  @DisplayName("Test Builder from(FlowAttributes) with 'FlowAttributes'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowAttributes)"})
  void testBuilderFromWithFlowAttributes_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();
    FlowAttributes instance = mock(FlowAttributes.class);
    when(instance.frequency()).thenThrow(new IllegalStateException("instance"));
    when(instance.transport()).thenReturn(TransportKindValue.of("42"));
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).transport();
  }

  /**
   * Test Builder {@link Builder#transport(TransportKindValue)}.
   * <ul>
   *   <li>When {@link TransportKindValue} with value is {@code 42}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#transport(TransportKindValue)}
   */
  @Test
  @DisplayName("Test Builder transport(TransportKindValue); when TransportKindValue with value is '42'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.transport(TransportKindValue)"})
  void testBuilderTransport_whenTransportKindValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowAttributes.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.transport(TransportKindValue.of("42")));
  }

  /**
   * Test Json {@link Json#basisOffset()}.
   * <p>
   * Method under test: {@link Json#basisOffset()}
   */
  @Test
  @DisplayName("Test Json basisOffset()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.basisOffset()"})
  void testJsonBasisOffset() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).basisOffset());
  }

  /**
   * Test Json {@link Json#criticality()}.
   * <p>
   * Method under test: {@link Json#criticality()}
   */
  @Test
  @DisplayName("Test Json criticality()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CriticalityValue Json.criticality()"})
  void testJsonCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).criticality());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json {@link Json#frequency()}.
   * <p>
   * Method under test: {@link Json#frequency()}
   */
  @Test
  @DisplayName("Test Json frequency()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FrequencyKindValue Json.frequency()"})
  void testJsonFrequency() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).frequency());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setBasisOffset(int)}
   */
  @Test
  @DisplayName("Test Json setBasisOffset(int)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#transport()}
   */
  @Test
  @DisplayName("Test Json transport()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportKindValue Json.transport()"})
  void testJsonTransport() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).transport());
  }
}
