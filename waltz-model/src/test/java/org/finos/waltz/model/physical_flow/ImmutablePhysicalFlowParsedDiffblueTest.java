package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowParsed.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowParsed.Json;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowParsedDiffblueTest {
  /**
   * Test {@link ImmutablePhysicalFlowParsed#builder()}.
   * <p>
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
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.basisOffset(Integer)", "ImmutablePhysicalFlowParsed Builder.build()",
      "Builder Builder.criticality(CriticalityValue)", "Builder Builder.dataType(EntityReference)",
      "Builder Builder.externalId(String)", "Builder Builder.format(DataFormatKindValue)",
      "Builder Builder.frequency(FrequencyKindValue)", "Builder Builder.owner(EntityReference)",
      "Builder Builder.source(EntityReference)", "Builder Builder.specDescription(String)",
      "Builder Builder.specExternalId(String)", "Builder Builder.target(EntityReference)",
      "Builder Builder.transport(TransportKindValue)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBasisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);
    Builder actualExternalIdResult = actualBasisOffsetResult.criticality(CriticalityValue.of("42"))
        .dataType(null)
        .externalId("42");
    Builder actualFormatResult = actualExternalIdResult.format(DataFormatKindValue.of("42"));
    Builder actualTargetResult = actualFormatResult.frequency(FrequencyKindValue.of("42"))
        .owner(null)
        .source(null)
        .specDescription("Spec Description")
        .specExternalId("42")
        .target(null);

    // Assert
    assertSame(actualTargetResult, actualTargetResult.transport(TransportKindValue.of("42")));
  }

  /**
   * Test Builder {@link Builder#description(String)}.
   * <p>
   * Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.description(String)"})
  void testBuilderDescription() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   * <ul>
   *   <li>Then return build basisOffset is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed); then return build basisOffset is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom_thenReturnBuildBasisOffsetIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowParsed buildResult = actualFromResult.build();
    assertEquals("42", buildResult.externalId());
    ImmutablePhysicalFlowParsed buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("42", buildResult2.specExternalId());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Description", buildResult2.specDescription());
    assertNull(buildResult.basisOffset());
    assertNull(buildResult2.basisOffset());
    assertNull(buildResult.dataType());
    assertNull(buildResult2.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult2.owner());
    assertNull(buildResult.source());
    assertNull(buildResult2.source());
    assertNull(buildResult.target());
    assertNull(buildResult2.target());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult3, buildResult2.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(ofResult, buildResult2.frequency());
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult2, buildResult2.transport());
    assertSame(ofResult4, buildResult.format());
    assertSame(ofResult4, buildResult2.format());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   * <ul>
   *   <li>Then return build criticality is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed); then return build criticality is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom_thenReturnBuildCriticalityIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowParsed buildResult = actualFromResult.build();
    assertEquals("42", buildResult.externalId());
    ImmutablePhysicalFlowParsed buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("42", buildResult2.specExternalId());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Description", buildResult2.specDescription());
    assertNull(buildResult.dataType());
    assertNull(buildResult2.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult2.owner());
    assertNull(buildResult.source());
    assertNull(buildResult2.source());
    assertNull(buildResult.target());
    assertNull(buildResult2.target());
    assertNull(buildResult.criticality());
    assertNull(buildResult2.criticality());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertEquals(1, buildResult2.basisOffset().intValue());
    assertSame(ofResult, buildResult.frequency());
    assertSame(ofResult, buildResult2.frequency());
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult2, buildResult2.transport());
    assertSame(ofResult3, buildResult.format());
    assertSame(ofResult3, buildResult2.format());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   * <ul>
   *   <li>Then return build externalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed); then return build externalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom_thenReturnBuildExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowParsed buildResult = actualFromResult.build();
    assertEquals("42", buildResult.externalId());
    ImmutablePhysicalFlowParsed buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("42", buildResult2.specExternalId());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Description", buildResult2.specDescription());
    assertNull(buildResult.dataType());
    assertNull(buildResult2.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult2.owner());
    assertNull(buildResult.source());
    assertNull(buildResult2.source());
    assertNull(buildResult.target());
    assertNull(buildResult2.target());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertEquals(1, buildResult2.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult3, buildResult2.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(ofResult, buildResult2.frequency());
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult2, buildResult2.transport());
    assertSame(ofResult4, buildResult.format());
    assertSame(ofResult4, buildResult2.format());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   * <ul>
   *   <li>Then return build externalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed); then return build externalId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom_thenReturnBuildExternalIdIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowParsed buildResult = actualFromResult.build();
    assertEquals("42", buildResult.specExternalId());
    ImmutablePhysicalFlowParsed buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.specExternalId());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Description", buildResult2.specDescription());
    assertNull(buildResult.externalId());
    assertNull(buildResult2.externalId());
    assertNull(buildResult.dataType());
    assertNull(buildResult2.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult2.owner());
    assertNull(buildResult.source());
    assertNull(buildResult2.source());
    assertNull(buildResult.target());
    assertNull(buildResult2.target());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertEquals(1, buildResult2.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult3, buildResult2.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(ofResult, buildResult2.frequency());
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult2, buildResult2.transport());
    assertSame(ofResult4, buildResult.format());
    assertSame(ofResult4, buildResult2.format());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   * <ul>
   *   <li>Then return build format is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed); then return build format is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom_thenReturnBuildFormatIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowParsed buildResult = actualFromResult.build();
    assertEquals("42", buildResult.externalId());
    ImmutablePhysicalFlowParsed buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("42", buildResult2.specExternalId());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Description", buildResult2.specDescription());
    assertNull(buildResult.dataType());
    assertNull(buildResult2.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult2.owner());
    assertNull(buildResult.source());
    assertNull(buildResult2.source());
    assertNull(buildResult.target());
    assertNull(buildResult2.target());
    assertNull(buildResult.format());
    assertNull(buildResult2.format());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertEquals(1, buildResult2.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult3, buildResult2.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(ofResult, buildResult2.frequency());
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult2, buildResult2.transport());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   * <ul>
   *   <li>Then return build frequency is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed); then return build frequency is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom_thenReturnBuildFrequencyIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowParsed buildResult = actualFromResult.build();
    assertEquals("42", buildResult.externalId());
    ImmutablePhysicalFlowParsed buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("42", buildResult2.specExternalId());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Description", buildResult2.specDescription());
    assertNull(buildResult.dataType());
    assertNull(buildResult2.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult2.owner());
    assertNull(buildResult.source());
    assertNull(buildResult2.source());
    assertNull(buildResult.target());
    assertNull(buildResult2.target());
    assertNull(buildResult.frequency());
    assertNull(buildResult2.frequency());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertEquals(1, buildResult2.basisOffset().intValue());
    assertSame(ofResult2, buildResult.criticality());
    assertSame(ofResult2, buildResult2.criticality());
    assertSame(ofResult, buildResult.transport());
    assertSame(ofResult, buildResult2.transport());
    assertSame(ofResult3, buildResult.format());
    assertSame(ofResult3, buildResult2.format());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   * <ul>
   *   <li>Then return build specDescription is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed); then return build specDescription is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom_thenReturnBuildSpecDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowParsed buildResult = actualFromResult.build();
    assertEquals("42", buildResult.externalId());
    ImmutablePhysicalFlowParsed buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("42", buildResult2.specExternalId());
    assertNull(buildResult.specDescription());
    assertNull(buildResult2.specDescription());
    assertNull(buildResult.dataType());
    assertNull(buildResult2.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult2.owner());
    assertNull(buildResult.source());
    assertNull(buildResult2.source());
    assertNull(buildResult.target());
    assertNull(buildResult2.target());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertEquals(1, buildResult2.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult3, buildResult2.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(ofResult, buildResult2.frequency());
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult2, buildResult2.transport());
    assertSame(ofResult4, buildResult.format());
    assertSame(ofResult4, buildResult2.format());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   * <ul>
   *   <li>Then return build specExternalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed); then return build specExternalId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom_thenReturnBuildSpecExternalIdIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowParsed buildResult = actualFromResult.build();
    assertEquals("42", buildResult.externalId());
    ImmutablePhysicalFlowParsed buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.externalId());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Description", buildResult2.specDescription());
    assertNull(buildResult.specExternalId());
    assertNull(buildResult2.specExternalId());
    assertNull(buildResult.dataType());
    assertNull(buildResult2.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult2.owner());
    assertNull(buildResult.source());
    assertNull(buildResult2.source());
    assertNull(buildResult.target());
    assertNull(buildResult2.target());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertEquals(1, buildResult2.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult3, buildResult2.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(ofResult, buildResult2.frequency());
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult2, buildResult2.transport());
    assertSame(ofResult4, buildResult.format());
    assertSame(ofResult4, buildResult2.format());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   * <ul>
   *   <li>Then return build transport is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed); then return build transport is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom_thenReturnBuildTransportIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowParsed buildResult = actualFromResult.build();
    assertEquals("42", buildResult.externalId());
    ImmutablePhysicalFlowParsed buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("42", buildResult2.specExternalId());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Description", buildResult2.specDescription());
    assertNull(buildResult.dataType());
    assertNull(buildResult2.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult2.owner());
    assertNull(buildResult.source());
    assertNull(buildResult2.source());
    assertNull(buildResult.target());
    assertNull(buildResult2.target());
    assertNull(buildResult.transport());
    assertNull(buildResult2.transport());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertEquals(1, buildResult2.basisOffset().intValue());
    assertSame(ofResult2, buildResult.criticality());
    assertSame(ofResult2, buildResult2.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(ofResult, buildResult2.frequency());
    assertSame(ofResult3, buildResult.format());
    assertSame(ofResult3, buildResult2.format());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();
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
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   * <ul>
   *   <li>When {@link PhysicalFlowParsed} {@link PhysicalFlowParsed#dataType()} return {@link EntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed); when PhysicalFlowParsed dataType() return EntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom_whenPhysicalFlowParsedDataTypeReturnEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowParsed buildResult = actualFromResult.build();
    assertEquals("42", buildResult.externalId());
    ImmutablePhysicalFlowParsed buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("42", buildResult2.specExternalId());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Description", buildResult2.specDescription());
    assertNull(buildResult.owner());
    assertNull(buildResult2.owner());
    assertNull(buildResult.source());
    assertNull(buildResult2.source());
    assertNull(buildResult.target());
    assertNull(buildResult2.target());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertEquals(1, buildResult2.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult3, buildResult2.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(ofResult, buildResult2.frequency());
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult2, buildResult2.transport());
    assertSame(ofResult4, buildResult.format());
    assertSame(ofResult4, buildResult2.format());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   * <ul>
   *   <li>When {@link PhysicalFlowParsed} {@link PhysicalFlowParsed#owner()} return {@link EntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed); when PhysicalFlowParsed owner() return EntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom_whenPhysicalFlowParsedOwnerReturnEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowParsed buildResult = actualFromResult.build();
    assertEquals("42", buildResult.externalId());
    ImmutablePhysicalFlowParsed buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("42", buildResult2.specExternalId());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Description", buildResult2.specDescription());
    assertNull(buildResult.dataType());
    assertNull(buildResult2.dataType());
    assertNull(buildResult.source());
    assertNull(buildResult2.source());
    assertNull(buildResult.target());
    assertNull(buildResult2.target());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertEquals(1, buildResult2.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult3, buildResult2.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(ofResult, buildResult2.frequency());
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult2, buildResult2.transport());
    assertSame(ofResult4, buildResult.format());
    assertSame(ofResult4, buildResult2.format());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   * <ul>
   *   <li>When {@link PhysicalFlowParsed} {@link PhysicalFlowParsed#source()} return {@link EntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed); when PhysicalFlowParsed source() return EntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom_whenPhysicalFlowParsedSourceReturnEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowParsed buildResult = actualFromResult.build();
    assertEquals("42", buildResult.externalId());
    ImmutablePhysicalFlowParsed buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("42", buildResult2.specExternalId());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Description", buildResult2.specDescription());
    assertNull(buildResult.dataType());
    assertNull(buildResult2.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult2.owner());
    assertNull(buildResult.target());
    assertNull(buildResult2.target());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertEquals(1, buildResult2.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult3, buildResult2.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(ofResult, buildResult2.frequency());
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult2, buildResult2.transport());
    assertSame(ofResult4, buildResult.format());
    assertSame(ofResult4, buildResult2.format());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   * <ul>
   *   <li>When {@link PhysicalFlowParsed} {@link PhysicalFlowParsed#target()} return {@link EntityReference}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed); when PhysicalFlowParsed target() return EntityReference")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom_whenPhysicalFlowParsedTargetReturnEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutablePhysicalFlowParsed buildResult = actualFromResult.build();
    assertEquals("42", buildResult.externalId());
    ImmutablePhysicalFlowParsed buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("42", buildResult2.specExternalId());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Spec Description", buildResult2.specDescription());
    assertNull(buildResult.dataType());
    assertNull(buildResult2.dataType());
    assertNull(buildResult.owner());
    assertNull(buildResult2.owner());
    assertNull(buildResult.source());
    assertNull(buildResult2.source());
    assertEquals(1, buildResult.basisOffset().intValue());
    assertEquals(1, buildResult2.basisOffset().intValue());
    assertSame(ofResult3, buildResult.criticality());
    assertSame(ofResult3, buildResult2.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(ofResult, buildResult2.frequency());
    assertSame(ofResult2, buildResult.transport());
    assertSame(ofResult2, buildResult2.transport());
    assertSame(ofResult4, buildResult.format());
    assertSame(ofResult4, buildResult2.format());
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Json {@link Json#basisOffset()}.
   * <p>
   * Method under test: {@link Json#basisOffset()}
   */
  @Test
  @DisplayName("Test Json basisOffset()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer Json.basisOffset()"})
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
   * Test Json {@link Json#dataType()}.
   * <p>
   * Method under test: {@link Json#dataType()}
   */
  @Test
  @DisplayName("Test Json dataType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.dataType()"})
  void testJsonDataType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dataType());
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
  @MethodsUnderTest({"String Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json {@link Json#format()}.
   * <p>
   * Method under test: {@link Json#format()}
   */
  @Test
  @DisplayName("Test Json format()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataFormatKindValue Json.format()"})
  void testJsonFormat() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).format());
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
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setBasisOffset(Integer)}
   *   <li>{@link Json#setCriticality(CriticalityValue)}
   *   <li>{@link Json#setDataType(EntityReference)}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setExternalId(String)}
   *   <li>{@link Json#setFormat(DataFormatKindValue)}
   *   <li>{@link Json#setFrequency(FrequencyKindValue)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setOwner(EntityReference)}
   *   <li>{@link Json#setSource(EntityReference)}
   *   <li>{@link Json#setSpecDescription(String)}
   *   <li>{@link Json#setSpecExternalId(String)}
   *   <li>{@link Json#setTarget(EntityReference)}
   *   <li>{@link Json#setTransport(TransportKindValue)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setBasisOffset(Integer)",
      "void Json.setCriticality(CriticalityValue)", "void Json.setDataType(EntityReference)",
      "void Json.setDescription(String)", "void Json.setExternalId(String)", "void Json.setFormat(DataFormatKindValue)",
      "void Json.setFrequency(FrequencyKindValue)", "void Json.setName(String)", "void Json.setOwner(EntityReference)",
      "void Json.setSource(EntityReference)", "void Json.setSpecDescription(String)",
      "void Json.setSpecExternalId(String)", "void Json.setTarget(EntityReference)",
      "void Json.setTransport(TransportKindValue)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
   * Test Json {@link Json#owner()}.
   * <p>
   * Method under test: {@link Json#owner()}
   */
  @Test
  @DisplayName("Test Json owner()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.owner()"})
  void testJsonOwner() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).owner());
  }

  /**
   * Test Json {@link Json#source()}.
   * <p>
   * Method under test: {@link Json#source()}
   */
  @Test
  @DisplayName("Test Json source()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.source()"})
  void testJsonSource() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).source());
  }

  /**
   * Test Json {@link Json#specDescription()}.
   * <p>
   * Method under test: {@link Json#specDescription()}
   */
  @Test
  @DisplayName("Test Json specDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.specDescription()"})
  void testJsonSpecDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).specDescription());
  }

  /**
   * Test Json {@link Json#specExternalId()}.
   * <p>
   * Method under test: {@link Json#specExternalId()}
   */
  @Test
  @DisplayName("Test Json specExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.specExternalId()"})
  void testJsonSpecExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).specExternalId());
  }

  /**
   * Test Json {@link Json#target()}.
   * <p>
   * Method under test: {@link Json#target()}
   */
  @Test
  @DisplayName("Test Json target()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.target()"})
  void testJsonTarget() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).target());
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
