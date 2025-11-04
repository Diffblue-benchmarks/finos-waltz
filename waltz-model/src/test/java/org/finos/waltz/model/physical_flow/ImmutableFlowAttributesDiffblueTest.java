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
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.junit.jupiter.api.Test;

class ImmutableFlowAttributesDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowAttributes#builder()}
   *   <li>{@link ImmutableFlowAttributes#description(String)}
   *   <li>{@link ImmutableFlowAttributes#externalId(String)}
   *   <li>{@link ImmutableFlowAttributes#name(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableFlowAttributes.Builder actualExternalIdResult = ImmutableFlowAttributes.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableFlowAttributes.Builder actualExternalIdResult2 = actualExternalIdResult.externalId(externalId);

    // Assert
    assertSame(actualExternalIdResult2, actualExternalIdResult2.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableFlowAttributes.Builder#basisOffset(int)}
   */
  @Test
  void testBuilderBasisOffset() {
    // Arrange
    ImmutableFlowAttributes.Builder builderResult = ImmutableFlowAttributes.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.basisOffset(1));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowAttributes.Builder#criticality(CriticalityValue)}
   */
  @Test
  void testBuilderCriticality() {
    // Arrange
    ImmutableFlowAttributes.Builder builderResult = ImmutableFlowAttributes.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.criticality(CriticalityValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowAttributes.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableFlowAttributes.Builder builderResult = ImmutableFlowAttributes.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowAttributes.Builder#frequency(FrequencyKindValue)}
   */
  @Test
  void testBuilderFrequency() {
    // Arrange
    ImmutableFlowAttributes.Builder builderResult = ImmutableFlowAttributes.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.frequency(FrequencyKindValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowAttributes.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowAttributes.Builder builderResult = ImmutableFlowAttributes.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableFlowAttributes.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowAttributes.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFlowAttributes.Builder builderResult = ImmutableFlowAttributes.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableFlowAttributes.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowAttributes.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFlowAttributes.Builder builderResult = ImmutableFlowAttributes.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableFlowAttributes.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowAttributes.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFlowAttributes.Builder builderResult = ImmutableFlowAttributes.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableFlowAttributes.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowAttributes.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableFlowAttributes.Builder builderResult = ImmutableFlowAttributes.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowAttributes.Builder#from(FlowAttributes)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableFlowAttributes.Builder builderResult = ImmutableFlowAttributes.builder();
    FlowAttributes instance = mock(FlowAttributes.class);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    CriticalityValue ofResult4 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult4);

    // Act
    ImmutableFlowAttributes.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).transport();
    ImmutableFlowAttributes buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.basisOffset());
    assertSame(ofResult4, buildResult.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.transport());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowAttributes.Builder#from(FlowAttributes)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableFlowAttributes.Builder builderResult = ImmutableFlowAttributes.builder();
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
   * Method under test:
   * {@link ImmutableFlowAttributes.Builder#from(FlowAttributes)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableFlowAttributes.Builder builderResult = ImmutableFlowAttributes.builder();
    FlowAttributes instance = mock(FlowAttributes.class);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn(null);
    when(instance.name()).thenReturn("Name");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    CriticalityValue ofResult4 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult4);

    // Act
    ImmutableFlowAttributes.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).transport();
    ImmutableFlowAttributes buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.basisOffset());
    assertSame(ofResult4, buildResult.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.transport());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowAttributes.Builder#from(FlowAttributes)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableFlowAttributes.Builder builderResult = ImmutableFlowAttributes.builder();
    FlowAttributes instance = mock(FlowAttributes.class);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn(null);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    CriticalityValue ofResult4 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult4);

    // Act
    ImmutableFlowAttributes.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).transport();
    ImmutableFlowAttributes buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.name());
    assertEquals(1, buildResult.basisOffset());
    assertSame(ofResult4, buildResult.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.transport());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowAttributes.Builder#from(FlowAttributes)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableFlowAttributes.Builder builderResult = ImmutableFlowAttributes.builder();
    FlowAttributes instance = mock(FlowAttributes.class);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);

    // Act
    ImmutableFlowAttributes.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).transport();
    ImmutableFlowAttributes buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.basisOffset());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.transport());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowAttributes.Builder#transport(TransportKindValue)}
   */
  @Test
  void testBuilderTransport() {
    // Arrange
    ImmutableFlowAttributes.Builder builderResult = ImmutableFlowAttributes.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.transport(TransportKindValue.of("42")));
  }

  /**
   * Method under test: {@link ImmutableFlowAttributes#copyOf(FlowAttributes)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowAttributes instance = mock(FlowAttributes.class);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    CriticalityValue ofResult4 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult4);

    // Act
    ImmutableFlowAttributes actualCopyOfResult = ImmutableFlowAttributes.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).transport();
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.basisOffset());
    assertSame(ofResult4, criticalityResult);
    assertSame(ofResult, frequencyResult);
    assertSame(ofResult2, transportResult);
  }

  /**
   * Method under test: {@link ImmutableFlowAttributes#copyOf(FlowAttributes)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    FlowAttributes instance = mock(FlowAttributes.class);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);

    // Act
    ImmutableFlowAttributes actualCopyOfResult = ImmutableFlowAttributes.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).transport();
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.basisOffset());
    assertSame(ofResult3, criticalityResult);
    assertSame(ofResult, frequencyResult);
    assertSame(ofResult2, transportResult);
  }

  /**
   * Method under test: {@link ImmutableFlowAttributes.Json#basisOffset()}
   */
  @Test
  void testJsonBasisOffset() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowAttributes.Json()).basisOffset());
  }

  /**
   * Method under test: {@link ImmutableFlowAttributes.Json#criticality()}
   */
  @Test
  void testJsonCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowAttributes.Json()).criticality());
  }

  /**
   * Method under test: {@link ImmutableFlowAttributes.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowAttributes.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableFlowAttributes.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowAttributes.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableFlowAttributes.Json#frequency()}
   */
  @Test
  void testJsonFrequency() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowAttributes.Json()).frequency());
  }

  /**
   * Method under test: {@link ImmutableFlowAttributes.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowAttributes.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableFlowAttributes.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableFlowAttributes.Json actualJson = new ImmutableFlowAttributes.Json();

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
   * Method under test: {@link ImmutableFlowAttributes.Json#setBasisOffset(int)}
   */
  @Test
  void testJsonSetBasisOffset() {
    // Arrange
    ImmutableFlowAttributes.Json json = new ImmutableFlowAttributes.Json();

    // Act
    json.setBasisOffset(1);

    // Assert
    assertEquals(1, json.basisOffset);
    assertTrue(json.basisOffsetIsSet);
  }

  /**
   * Method under test: {@link ImmutableFlowAttributes.Json#transport()}
   */
  @Test
  void testJsonTransport() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowAttributes.Json()).transport());
  }
}
