package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowUploadCommand.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowUploadCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowUploadCommandDiffblueTest {
  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#builder()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#externalId(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#specDescription(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#specExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutablePhysicalFlowUploadCommand Builder.build()", "Builder Builder.externalId(String)",
      "Builder Builder.specDescription(String)", "Builder Builder.specExternalId(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualSpecDescriptionResult = ImmutablePhysicalFlowUploadCommand.builder()
        .externalId("42")
        .specDescription("Spec Description");

    // Assert
    assertSame(actualSpecDescriptionResult, actualSpecDescriptionResult.specExternalId("42"));
  }

  /**
   * Test Builder {@link Builder#basisOffset(String)}.
   * <p>
   * Method under test: {@link Builder#basisOffset(String)}
   */
  @Test
  @DisplayName("Test Builder basisOffset(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.basisOffset(String)"})
  void testBuilderBasisOffset() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.basisOffset("Basis Offset"));
  }

  /**
   * Test Builder {@link Builder#criticality(String)}.
   * <p>
   * Method under test: {@link Builder#criticality(String)}
   */
  @Test
  @DisplayName("Test Builder criticality(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.criticality(String)"})
  void testBuilderCriticality() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.criticality("Criticality"));
  }

  /**
   * Test Builder {@link Builder#dataType(String)}.
   * <p>
   * Method under test: {@link Builder#dataType(String)}
   */
  @Test
  @DisplayName("Test Builder dataType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dataType(String)"})
  void testBuilderDataType() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataType("Data Type"));
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
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
  }

  /**
   * Test Builder {@link Builder#format(String)}.
   * <p>
   * Method under test: {@link Builder#format(String)}
   */
  @Test
  @DisplayName("Test Builder format(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.format(String)"})
  void testBuilderFormat() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.format("Format"));
  }

  /**
   * Test Builder {@link Builder#frequency(String)}.
   * <p>
   * Method under test: {@link Builder#frequency(String)}
   */
  @Test
  @DisplayName("Test Builder frequency(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.frequency(String)"})
  void testBuilderFrequency() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.frequency("Frequency"));
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
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
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
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowUploadCommand)} with {@code PhysicalFlowUploadCommand}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowUploadCommand) with 'PhysicalFlowUploadCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowUploadCommand)"})
  void testBuilderFromWithPhysicalFlowUploadCommand() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
    PhysicalFlowUploadCommand instance = mock(PhysicalFlowUploadCommand.class);
    when(instance.specDescription()).thenReturn(null);
    when(instance.specExternalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");
    when(instance.basisOffset()).thenReturn("Basis Offset");
    when(instance.frequency()).thenReturn("Frequency");
    when(instance.target()).thenReturn("Target");
    when(instance.transport()).thenReturn("Transport");
    when(instance.externalId()).thenReturn("42");
    when(instance.source()).thenReturn("Source");
    when(instance.criticality()).thenReturn("Criticality");
    when(instance.format()).thenReturn("Format");
    when(instance.dataType()).thenReturn("Data Type");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.owner()).thenReturn("Owner");

    // Act
    builderResult.from(instance);

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
    ImmutablePhysicalFlowUploadCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("Basis Offset", buildResult.basisOffset());
    assertEquals("Criticality", buildResult.criticality());
    assertEquals("Data Type", buildResult.dataType());
    assertEquals("Format", buildResult.format());
    assertEquals("Frequency", buildResult.frequency());
    assertEquals("Name", buildResult.name());
    assertEquals("Owner", buildResult.owner());
    assertEquals("Source", buildResult.source());
    assertEquals("Target", buildResult.target());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("Transport", buildResult.transport());
    assertNull(buildResult.specDescription());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowUploadCommand)} with {@code PhysicalFlowUploadCommand}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowUploadCommand) with 'PhysicalFlowUploadCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowUploadCommand)"})
  void testBuilderFromWithPhysicalFlowUploadCommand2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
    PhysicalFlowUploadCommand instance = mock(PhysicalFlowUploadCommand.class);
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn(null);
    when(instance.name()).thenReturn("Name");
    when(instance.basisOffset()).thenReturn("Basis Offset");
    when(instance.frequency()).thenReturn("Frequency");
    when(instance.target()).thenReturn("Target");
    when(instance.transport()).thenReturn("Transport");
    when(instance.externalId()).thenReturn("42");
    when(instance.source()).thenReturn("Source");
    when(instance.criticality()).thenReturn("Criticality");
    when(instance.format()).thenReturn("Format");
    when(instance.dataType()).thenReturn("Data Type");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.owner()).thenReturn("Owner");

    // Act
    builderResult.from(instance);

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
    ImmutablePhysicalFlowUploadCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Basis Offset", buildResult.basisOffset());
    assertEquals("Criticality", buildResult.criticality());
    assertEquals("Data Type", buildResult.dataType());
    assertEquals("Format", buildResult.format());
    assertEquals("Frequency", buildResult.frequency());
    assertEquals("Name", buildResult.name());
    assertEquals("Owner", buildResult.owner());
    assertEquals("Source", buildResult.source());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Target", buildResult.target());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("Transport", buildResult.transport());
    assertNull(buildResult.specExternalId());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowUploadCommand)} with {@code PhysicalFlowUploadCommand}.
   * <ul>
   *   <li>Then builder build externalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowUploadCommand) with 'PhysicalFlowUploadCommand'; then builder build externalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowUploadCommand)"})
  void testBuilderFromWithPhysicalFlowUploadCommand_thenBuilderBuildExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
    PhysicalFlowUploadCommand instance = mock(PhysicalFlowUploadCommand.class);
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");
    when(instance.basisOffset()).thenReturn("Basis Offset");
    when(instance.frequency()).thenReturn("Frequency");
    when(instance.target()).thenReturn("Target");
    when(instance.transport()).thenReturn("Transport");
    when(instance.externalId()).thenReturn("42");
    when(instance.source()).thenReturn("Source");
    when(instance.criticality()).thenReturn("Criticality");
    when(instance.format()).thenReturn("Format");
    when(instance.dataType()).thenReturn("Data Type");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.owner()).thenReturn("Owner");

    // Act
    builderResult.from(instance);

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
    ImmutablePhysicalFlowUploadCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.specExternalId());
    assertEquals("Basis Offset", buildResult.basisOffset());
    assertEquals("Criticality", buildResult.criticality());
    assertEquals("Data Type", buildResult.dataType());
    assertEquals("Format", buildResult.format());
    assertEquals("Frequency", buildResult.frequency());
    assertEquals("Name", buildResult.name());
    assertEquals("Owner", buildResult.owner());
    assertEquals("Source", buildResult.source());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Target", buildResult.target());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("Transport", buildResult.transport());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowUploadCommand)} with {@code PhysicalFlowUploadCommand}.
   * <ul>
   *   <li>Then builder build externalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowUploadCommand) with 'PhysicalFlowUploadCommand'; then builder build externalId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowUploadCommand)"})
  void testBuilderFromWithPhysicalFlowUploadCommand_thenBuilderBuildExternalIdIsNull() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
    PhysicalFlowUploadCommand instance = mock(PhysicalFlowUploadCommand.class);
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");
    when(instance.basisOffset()).thenReturn("Basis Offset");
    when(instance.frequency()).thenReturn("Frequency");
    when(instance.target()).thenReturn("Target");
    when(instance.transport()).thenReturn("Transport");
    when(instance.externalId()).thenReturn(null);
    when(instance.source()).thenReturn("Source");
    when(instance.criticality()).thenReturn("Criticality");
    when(instance.format()).thenReturn("Format");
    when(instance.dataType()).thenReturn("Data Type");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.owner()).thenReturn("Owner");

    // Act
    builderResult.from(instance);

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
    ImmutablePhysicalFlowUploadCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.specExternalId());
    assertEquals("Basis Offset", buildResult.basisOffset());
    assertEquals("Criticality", buildResult.criticality());
    assertEquals("Data Type", buildResult.dataType());
    assertEquals("Format", buildResult.format());
    assertEquals("Frequency", buildResult.frequency());
    assertEquals("Name", buildResult.name());
    assertEquals("Owner", buildResult.owner());
    assertEquals("Source", buildResult.source());
    assertEquals("Spec Description", buildResult.specDescription());
    assertEquals("Target", buildResult.target());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("Transport", buildResult.transport());
    assertNull(buildResult.externalId());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowUploadCommand)} with {@code PhysicalFlowUploadCommand}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowUploadCommand) with 'PhysicalFlowUploadCommand'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowUploadCommand)"})
  void testBuilderFromWithPhysicalFlowUploadCommand_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
    PhysicalFlowUploadCommand instance = mock(PhysicalFlowUploadCommand.class);
    when(instance.specDescription()).thenReturn("Spec Description");
    when(instance.specExternalId()).thenReturn("42");
    when(instance.name()).thenReturn("Name");
    when(instance.basisOffset()).thenReturn("Basis Offset");
    when(instance.frequency()).thenReturn("Frequency");
    when(instance.target()).thenReturn("Target");
    when(instance.transport()).thenReturn("Transport");
    when(instance.externalId()).thenReturn("42");
    when(instance.source()).thenReturn("Source");
    when(instance.criticality()).thenReturn("Criticality");
    when(instance.format()).thenReturn("Format");
    when(instance.dataType()).thenReturn("Data Type");
    when(instance.description()).thenReturn(null);
    when(instance.owner()).thenReturn("Owner");

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
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowUploadCommand)} with {@code PhysicalFlowUploadCommand}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowUploadCommand) with 'PhysicalFlowUploadCommand'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowUploadCommand)"})
  void testBuilderFromWithPhysicalFlowUploadCommand_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
    PhysicalFlowUploadCommand instance = mock(PhysicalFlowUploadCommand.class);
    when(instance.specExternalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");
    when(instance.basisOffset()).thenReturn("Basis Offset");
    when(instance.frequency()).thenReturn("Frequency");
    when(instance.target()).thenReturn("Target");
    when(instance.transport()).thenReturn("Transport");
    when(instance.externalId()).thenReturn("42");
    when(instance.source()).thenReturn("Source");
    when(instance.criticality()).thenReturn("Criticality");
    when(instance.format()).thenReturn("Format");
    when(instance.dataType()).thenReturn("Data Type");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.owner()).thenReturn("Owner");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
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
    verify(instance).specExternalId();
    verify(instance).target();
    verify(instance).transport();
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
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#owner(String)}.
   * <p>
   * Method under test: {@link Builder#owner(String)}
   */
  @Test
  @DisplayName("Test Builder owner(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.owner(String)"})
  void testBuilderOwner() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.owner("Owner"));
  }

  /**
   * Test Builder {@link Builder#source(String)}.
   * <p>
   * Method under test: {@link Builder#source(String)}
   */
  @Test
  @DisplayName("Test Builder source(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.source(String)"})
  void testBuilderSource() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.source("Source"));
  }

  /**
   * Test Builder {@link Builder#target(String)}.
   * <p>
   * Method under test: {@link Builder#target(String)}
   */
  @Test
  @DisplayName("Test Builder target(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.target(String)"})
  void testBuilderTarget() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.target("Target"));
  }

  /**
   * Test Builder {@link Builder#transport(String)}.
   * <p>
   * Method under test: {@link Builder#transport(String)}
   */
  @Test
  @DisplayName("Test Builder transport(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.transport(String)"})
  void testBuilderTransport() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.transport("Transport"));
  }

  /**
   * Test Json {@link Json#basisOffset()}.
   * <p>
   * Method under test: {@link Json#basisOffset()}
   */
  @Test
  @DisplayName("Test Json basisOffset()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.basisOffset()"})
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
  @MethodsUnderTest({"String Json.criticality()"})
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
  @MethodsUnderTest({"String Json.dataType()"})
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
  @MethodsUnderTest({"String Json.format()"})
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
  @MethodsUnderTest({"String Json.frequency()"})
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
   *   <li>{@link Json#setBasisOffset(String)}
   *   <li>{@link Json#setCriticality(String)}
   *   <li>{@link Json#setDataType(String)}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setExternalId(String)}
   *   <li>{@link Json#setFormat(String)}
   *   <li>{@link Json#setFrequency(String)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setOwner(String)}
   *   <li>{@link Json#setSource(String)}
   *   <li>{@link Json#setSpecDescription(String)}
   *   <li>{@link Json#setSpecExternalId(String)}
   *   <li>{@link Json#setTarget(String)}
   *   <li>{@link Json#setTransport(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setBasisOffset(String)", "void Json.setCriticality(String)",
      "void Json.setDataType(String)", "void Json.setDescription(String)", "void Json.setExternalId(String)",
      "void Json.setFormat(String)", "void Json.setFrequency(String)", "void Json.setName(String)",
      "void Json.setOwner(String)", "void Json.setSource(String)", "void Json.setSpecDescription(String)",
      "void Json.setSpecExternalId(String)", "void Json.setTarget(String)", "void Json.setTransport(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setBasisOffset("Basis Offset");
    actualJson.setCriticality("Criticality");
    actualJson.setDataType("Data Type");
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setExternalId("42");
    actualJson.setFormat("Format");
    actualJson.setFrequency("Frequency");
    actualJson.setName("Name");
    actualJson.setOwner("Owner");
    actualJson.setSource("Source");
    actualJson.setSpecDescription("Spec Description");
    actualJson.setSpecExternalId("42");
    actualJson.setTarget("Target");
    actualJson.setTransport("Transport");

    // Assert
    assertEquals("42", actualJson.externalId);
    assertEquals("42", actualJson.specExternalId);
    assertEquals("Basis Offset", actualJson.basisOffset);
    assertEquals("Criticality", actualJson.criticality);
    assertEquals("Data Type", actualJson.dataType);
    assertEquals("Format", actualJson.format);
    assertEquals("Frequency", actualJson.frequency);
    assertEquals("Name", actualJson.name);
    assertEquals("Owner", actualJson.owner);
    assertEquals("Source", actualJson.source);
    assertEquals("Spec Description", actualJson.specDescription);
    assertEquals("Target", actualJson.target);
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals("Transport", actualJson.transport);
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
  @MethodsUnderTest({"String Json.owner()"})
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
  @MethodsUnderTest({"String Json.source()"})
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
  @MethodsUnderTest({"String Json.target()"})
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
  @MethodsUnderTest({"String Json.transport()"})
  void testJsonTransport() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).transport());
  }
}
