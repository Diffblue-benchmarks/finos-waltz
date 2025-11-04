package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowParsedDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowParsed#builder()}
   *   <li>{@link ImmutablePhysicalFlowParsed#basisOffset(Integer)}
   *   <li>{@link ImmutablePhysicalFlowParsed#criticality(CriticalityValue)}
   *   <li>{@link ImmutablePhysicalFlowParsed#dataType(EntityReference)}
   *   <li>{@link ImmutablePhysicalFlowParsed#externalId(String)}
   *   <li>{@link ImmutablePhysicalFlowParsed#format(DataFormatKindValue)}
   *   <li>{@link ImmutablePhysicalFlowParsed#frequency(FrequencyKindValue)}
   *   <li>{@link ImmutablePhysicalFlowParsed#owner(EntityReference)}
   *   <li>{@link ImmutablePhysicalFlowParsed#source(EntityReference)}
   *   <li>{@link ImmutablePhysicalFlowParsed#specDescription(String)}
   *   <li>{@link ImmutablePhysicalFlowParsed#specExternalId(String)}
   *   <li>{@link ImmutablePhysicalFlowParsed#target(EntityReference)}
   *   <li>{@link ImmutablePhysicalFlowParsed#transport(TransportKindValue)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePhysicalFlowParsed.Builder actualBasisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);
    ImmutablePhysicalFlowParsed.Builder actualExternalIdResult = actualBasisOffsetResult
        .criticality(CriticalityValue.of("42"))
        .dataType(null)
        .externalId("42");
    ImmutablePhysicalFlowParsed.Builder actualFormatResult = actualExternalIdResult
        .format(DataFormatKindValue.of("42"));
    ImmutablePhysicalFlowParsed.Builder actualTargetResult = actualFormatResult.frequency(FrequencyKindValue.of("42"))
        .owner(null)
        .source(null)
        .specDescription("Spec Description")
        .specExternalId("42")
        .target(null);

    // Assert
    assertSame(actualTargetResult, actualTargetResult.transport(TransportKindValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed.Builder#description(String)}
   */
  @Test
  void testBuilderDescription() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed.Builder#description(String)}
   */
  @Test
  void testBuilderDescription2() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();
    builderResult.source(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed.Builder#from(PhysicalFlowParsed)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);

    // Act
    ImmutablePhysicalFlowParsed.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    ImmutablePhysicalFlowParsed buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult.source());
    assertNull(buildResult.target());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult4, buildResult.format());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed.Builder#from(PhysicalFlowParsed)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    when(instance.format()).thenReturn(DataFormatKindValue.of("42"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed.Builder#from(PhysicalFlowParsed)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn(null);
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);

    // Act
    ImmutablePhysicalFlowParsed.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    ImmutablePhysicalFlowParsed buildResult = builderResult.build();
    assertEquals("42", buildResult.specExternalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.externalId());
    assertNull(buildResult.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult.source());
    assertNull(buildResult.target());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult4, buildResult.format());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed.Builder#from(PhysicalFlowParsed)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(mock(EntityReference.class));
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);

    // Act
    ImmutablePhysicalFlowParsed.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    ImmutablePhysicalFlowParsed buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.owner());
    assertNull(buildResult.source());
    assertNull(buildResult.target());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult4, buildResult.format());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed.Builder#from(PhysicalFlowParsed)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    when(instance.frequency()).thenReturn(null);
    TransportKindValue ofResult = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult2 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult2);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult3 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult3);

    // Act
    ImmutablePhysicalFlowParsed.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    ImmutablePhysicalFlowParsed buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult.source());
    assertNull(buildResult.target());
    assertNull(buildResult.frequency());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertSame(ofResult2, buildResult.criticality());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult, buildResult.transport());
    assertSame(ofResult3, buildResult.format());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed.Builder#from(PhysicalFlowParsed)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    when(instance.transport()).thenReturn(null);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult2 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult2);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult3 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult3);

    // Act
    ImmutablePhysicalFlowParsed.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    ImmutablePhysicalFlowParsed buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult.source());
    assertNull(buildResult.target());
    assertNull(buildResult.transport());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertSame(ofResult2, buildResult.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult3, buildResult.format());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed.Builder#from(PhysicalFlowParsed)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(null);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);

    // Act
    ImmutablePhysicalFlowParsed.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    ImmutablePhysicalFlowParsed buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.basisOffset());
    assertNull(buildResult.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult.source());
    assertNull(buildResult.target());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult4, buildResult.format());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed.Builder#from(PhysicalFlowParsed)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn(null);
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);

    // Act
    ImmutablePhysicalFlowParsed.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    ImmutablePhysicalFlowParsed buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.specDescription());
    assertNull(buildResult.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult.source());
    assertNull(buildResult.target());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult4, buildResult.format());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed.Builder#from(PhysicalFlowParsed)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn(null);
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);

    // Act
    ImmutablePhysicalFlowParsed.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    ImmutablePhysicalFlowParsed buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.specExternalId());
    assertNull(buildResult.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult.source());
    assertNull(buildResult.target());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult4, buildResult.format());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed.Builder#from(PhysicalFlowParsed)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    when(instance.criticality()).thenReturn(null);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult3 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult3);

    // Act
    ImmutablePhysicalFlowParsed.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    ImmutablePhysicalFlowParsed buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult.source());
    assertNull(buildResult.target());
    assertNull(buildResult.criticality());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult3, buildResult.format());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed.Builder#from(PhysicalFlowParsed)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);

    // Act
    ImmutablePhysicalFlowParsed.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    ImmutablePhysicalFlowParsed buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.dataType());
    assertNull(buildResult.source());
    assertNull(buildResult.target());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult4, buildResult.format());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed.Builder#from(PhysicalFlowParsed)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(mock(EntityReference.class));
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);

    // Act
    ImmutablePhysicalFlowParsed.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    ImmutablePhysicalFlowParsed buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult.target());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult4, buildResult.format());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed.Builder#from(PhysicalFlowParsed)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);

    // Act
    ImmutablePhysicalFlowParsed.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    ImmutablePhysicalFlowParsed buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult.source());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult4, buildResult.format());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed.Builder#from(PhysicalFlowParsed)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    when(instance.format()).thenReturn(null);

    // Act
    ImmutablePhysicalFlowParsed.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    ImmutablePhysicalFlowParsed buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult.source());
    assertNull(buildResult.target());
    assertNull(buildResult.format());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.transport());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParsed.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParsed.Builder#name(String)}
   */
  @Test
  void testBuilderName2() {
    // Arrange
    ImmutablePhysicalFlowParsed.Builder builderResult = ImmutablePhysicalFlowParsed.builder();
    builderResult.source(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed#copyOf(PhysicalFlowParsed)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);

    // Act
    ImmutablePhysicalFlowParsed actualCopyOfResult = ImmutablePhysicalFlowParsed.copyOf(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.specExternalId());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    DataFormatKindValue formatResult = actualCopyOfResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Spec Description", actualCopyOfResult.specDescription());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.dataType());
    assertNull(actualCopyOfResult.owner());
    assertNull(actualCopyOfResult.source());
    assertNull(actualCopyOfResult.target());
    assertEquals(1, actualCopyOfResult.basisOffset().intValue());
    assertSame(ofResult3, criticalityResult);
    assertSame(ofResult, frequencyResult);
    assertSame(ofResult2, transportResult);
    assertSame(ofResult4, formatResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed#copyOf(PhysicalFlowParsed)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(mock(EntityReference.class));
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);

    // Act
    ImmutablePhysicalFlowParsed actualCopyOfResult = ImmutablePhysicalFlowParsed.copyOf(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.specExternalId());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    DataFormatKindValue formatResult = actualCopyOfResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Spec Description", actualCopyOfResult.specDescription());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.owner());
    assertNull(actualCopyOfResult.source());
    assertNull(actualCopyOfResult.target());
    assertEquals(1, actualCopyOfResult.basisOffset().intValue());
    assertSame(ofResult3, criticalityResult);
    assertSame(ofResult, frequencyResult);
    assertSame(ofResult2, transportResult);
    assertSame(ofResult4, formatResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed#copyOf(PhysicalFlowParsed)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    when(instance.frequency()).thenReturn(null);
    TransportKindValue ofResult = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult2 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult2);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult3 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult3);

    // Act
    ImmutablePhysicalFlowParsed actualCopyOfResult = ImmutablePhysicalFlowParsed.copyOf(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.specExternalId());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    DataFormatKindValue formatResult = actualCopyOfResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Spec Description", actualCopyOfResult.specDescription());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.dataType());
    assertNull(actualCopyOfResult.owner());
    assertNull(actualCopyOfResult.source());
    assertNull(actualCopyOfResult.target());
    assertNull(actualCopyOfResult.frequency());
    assertEquals(1, actualCopyOfResult.basisOffset().intValue());
    assertSame(ofResult2, criticalityResult);
    assertSame(ofResult, transportResult);
    assertSame(ofResult3, formatResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed#copyOf(PhysicalFlowParsed)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    when(instance.transport()).thenReturn(null);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult2 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult2);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult3 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult3);

    // Act
    ImmutablePhysicalFlowParsed actualCopyOfResult = ImmutablePhysicalFlowParsed.copyOf(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.specExternalId());
    DataFormatKindValue formatResult = actualCopyOfResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Spec Description", actualCopyOfResult.specDescription());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.dataType());
    assertNull(actualCopyOfResult.owner());
    assertNull(actualCopyOfResult.source());
    assertNull(actualCopyOfResult.target());
    assertNull(actualCopyOfResult.transport());
    assertEquals(1, actualCopyOfResult.basisOffset().intValue());
    assertSame(ofResult2, criticalityResult);
    assertSame(ofResult, frequencyResult);
    assertSame(ofResult3, formatResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed#copyOf(PhysicalFlowParsed)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    when(instance.criticality()).thenReturn(null);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult3 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult3);

    // Act
    ImmutablePhysicalFlowParsed actualCopyOfResult = ImmutablePhysicalFlowParsed.copyOf(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.specExternalId());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    DataFormatKindValue formatResult = actualCopyOfResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Spec Description", actualCopyOfResult.specDescription());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.dataType());
    assertNull(actualCopyOfResult.owner());
    assertNull(actualCopyOfResult.source());
    assertNull(actualCopyOfResult.target());
    assertNull(actualCopyOfResult.criticality());
    assertEquals(1, actualCopyOfResult.basisOffset().intValue());
    assertSame(ofResult, frequencyResult);
    assertSame(ofResult2, transportResult);
    assertSame(ofResult3, formatResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed#copyOf(PhysicalFlowParsed)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);

    // Act
    ImmutablePhysicalFlowParsed actualCopyOfResult = ImmutablePhysicalFlowParsed.copyOf(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.specExternalId());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    DataFormatKindValue formatResult = actualCopyOfResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Spec Description", actualCopyOfResult.specDescription());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.dataType());
    assertNull(actualCopyOfResult.source());
    assertNull(actualCopyOfResult.target());
    assertEquals(1, actualCopyOfResult.basisOffset().intValue());
    assertSame(ofResult3, criticalityResult);
    assertSame(ofResult, frequencyResult);
    assertSame(ofResult2, transportResult);
    assertSame(ofResult4, formatResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed#copyOf(PhysicalFlowParsed)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(mock(EntityReference.class));
    when(instance.target()).thenReturn(null);
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);

    // Act
    ImmutablePhysicalFlowParsed actualCopyOfResult = ImmutablePhysicalFlowParsed.copyOf(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.specExternalId());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    DataFormatKindValue formatResult = actualCopyOfResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Spec Description", actualCopyOfResult.specDescription());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.dataType());
    assertNull(actualCopyOfResult.owner());
    assertNull(actualCopyOfResult.target());
    assertEquals(1, actualCopyOfResult.basisOffset().intValue());
    assertSame(ofResult3, criticalityResult);
    assertSame(ofResult, frequencyResult);
    assertSame(ofResult2, transportResult);
    assertSame(ofResult4, formatResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed#copyOf(PhysicalFlowParsed)}
   */
  @Test
  void testCopyOf8() {
    // Arrange
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);

    // Act
    ImmutablePhysicalFlowParsed actualCopyOfResult = ImmutablePhysicalFlowParsed.copyOf(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.specExternalId());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    DataFormatKindValue formatResult = actualCopyOfResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Spec Description", actualCopyOfResult.specDescription());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.dataType());
    assertNull(actualCopyOfResult.owner());
    assertNull(actualCopyOfResult.source());
    assertEquals(1, actualCopyOfResult.basisOffset().intValue());
    assertSame(ofResult3, criticalityResult);
    assertSame(ofResult, frequencyResult);
    assertSame(ofResult2, transportResult);
    assertSame(ofResult4, formatResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed#copyOf(PhysicalFlowParsed)}
   */
  @Test
  void testCopyOf9() {
    // Arrange
    PhysicalFlowParsed instance = mock(PhysicalFlowParsed.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.dataType()).thenReturn(null);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult3);
    when(instance.name()).thenReturn("Name");
    when(instance.owner()).thenReturn(null);
    when(instance.source()).thenReturn(null);
    when(instance.target()).thenReturn(null);
    when(instance.format()).thenReturn(null);

    // Act
    ImmutablePhysicalFlowParsed actualCopyOfResult = ImmutablePhysicalFlowParsed.copyOf(instance);

    // Assert
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).dataType();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).format();
    verify(instance).frequency();
    verify(instance).name();
    verify(instance).owner();
    verify(instance).source();
    verify(instance).specDescription();
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.specExternalId());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Spec Description", actualCopyOfResult.specDescription());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.dataType());
    assertNull(actualCopyOfResult.owner());
    assertNull(actualCopyOfResult.source());
    assertNull(actualCopyOfResult.target());
    assertNull(actualCopyOfResult.format());
    assertEquals(1, actualCopyOfResult.basisOffset().intValue());
    assertSame(ofResult3, criticalityResult);
    assertSame(ofResult, frequencyResult);
    assertSame(ofResult2, transportResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowParsed#fromJson(ImmutablePhysicalFlowParsed.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutablePhysicalFlowParsed.Json json = new ImmutablePhysicalFlowParsed.Json();
    json.setSource(null);
    json.setTarget(null);
    json.setOwner(null);
    json.setFormat(null);
    json.setName("description");
    json.setSpecDescription(null);
    json.setSpecExternalId(null);
    json.setBasisOffset(null);
    json.setCriticality(null);
    json.setDescription("Json");
    json.setExternalId(null);
    json.setFrequency(null);
    json.setTransport(null);
    json.setDataType(null);

    // Act
    ImmutablePhysicalFlowParsed actualFromJsonResult = ImmutablePhysicalFlowParsed.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("description", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.basisOffset());
    assertNull(actualFromJsonResult.externalId());
    assertNull(actualFromJsonResult.specDescription());
    assertNull(actualFromJsonResult.specExternalId());
    assertNull(actualFromJsonResult.dataType());
    assertNull(actualFromJsonResult.owner());
    assertNull(actualFromJsonResult.source());
    assertNull(actualFromJsonResult.target());
    assertNull(actualFromJsonResult.criticality());
    assertNull(actualFromJsonResult.frequency());
    assertNull(actualFromJsonResult.transport());
    assertNull(actualFromJsonResult.format());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParsed.Json#basisOffset()}
   */
  @Test
  void testJsonBasisOffset() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowParsed.Json()).basisOffset());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParsed.Json#criticality()}
   */
  @Test
  void testJsonCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowParsed.Json()).criticality());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParsed.Json#dataType()}
   */
  @Test
  void testJsonDataType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowParsed.Json()).dataType());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParsed.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowParsed.Json()).description());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParsed.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowParsed.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParsed.Json#format()}
   */
  @Test
  void testJsonFormat() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowParsed.Json()).format());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParsed.Json#frequency()}
   */
  @Test
  void testJsonFrequency() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowParsed.Json()).frequency());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutablePhysicalFlowParsed.Json}
   *   <li>{@link ImmutablePhysicalFlowParsed.Json#setBasisOffset(Integer)}
   *   <li>{@link ImmutablePhysicalFlowParsed.Json#setCriticality(CriticalityValue)}
   *   <li>{@link ImmutablePhysicalFlowParsed.Json#setDataType(EntityReference)}
   *   <li>{@link ImmutablePhysicalFlowParsed.Json#setDescription(String)}
   *   <li>{@link ImmutablePhysicalFlowParsed.Json#setExternalId(String)}
   *   <li>{@link ImmutablePhysicalFlowParsed.Json#setFormat(DataFormatKindValue)}
   *   <li>{@link ImmutablePhysicalFlowParsed.Json#setFrequency(FrequencyKindValue)}
   *   <li>{@link ImmutablePhysicalFlowParsed.Json#setName(String)}
   *   <li>{@link ImmutablePhysicalFlowParsed.Json#setOwner(EntityReference)}
   *   <li>{@link ImmutablePhysicalFlowParsed.Json#setSource(EntityReference)}
   *   <li>{@link ImmutablePhysicalFlowParsed.Json#setSpecDescription(String)}
   *   <li>{@link ImmutablePhysicalFlowParsed.Json#setSpecExternalId(String)}
   *   <li>{@link ImmutablePhysicalFlowParsed.Json#setTarget(EntityReference)}
   *   <li>{@link ImmutablePhysicalFlowParsed.Json#setTransport(TransportKindValue)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutablePhysicalFlowParsed.Json actualJson = new ImmutablePhysicalFlowParsed.Json();
    actualJson.setBasisOffset(1);
    actualJson.setCriticality(CriticalityValue.of("42"));
    actualJson.setDataType(null);
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setExternalId("42");
    actualJson.setFormat(DataFormatKindValue.of("42"));
    actualJson.setFrequency(FrequencyKindValue.of("42"));
    actualJson.setName("Name");
    actualJson.setOwner(null);
    actualJson.setSource(null);
    actualJson.setSpecDescription("Spec Description");
    actualJson.setSpecExternalId("42");
    actualJson.setTarget(null);
    actualJson.setTransport(TransportKindValue.of("42"));

    // Assert
    assertEquals("42", actualJson.criticality.value());
    assertEquals("42", actualJson.frequency.value());
    assertEquals("42", actualJson.transport.value());
    assertEquals("42", actualJson.format.value());
    assertEquals(1, actualJson.basisOffset.intValue());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParsed.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowParsed.Json()).name());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParsed.Json#owner()}
   */
  @Test
  void testJsonOwner() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowParsed.Json()).owner());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParsed.Json#source()}
   */
  @Test
  void testJsonSource() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowParsed.Json()).source());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParsed.Json#specDescription()}
   */
  @Test
  void testJsonSpecDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowParsed.Json()).specDescription());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParsed.Json#specExternalId()}
   */
  @Test
  void testJsonSpecExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowParsed.Json()).specExternalId());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParsed.Json#target()}
   */
  @Test
  void testJsonTarget() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowParsed.Json()).target());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowParsed.Json#transport()}
   */
  @Test
  void testJsonTransport() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowParsed.Json()).transport());
  }
}
