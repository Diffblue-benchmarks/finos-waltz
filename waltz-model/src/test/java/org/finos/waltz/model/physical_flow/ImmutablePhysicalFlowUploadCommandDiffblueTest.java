package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.DescriptionProvider;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowUploadCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#builder()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#externalId(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#specDescription(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#specExternalId(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand.Builder actualSpecDescriptionResult = ImmutablePhysicalFlowUploadCommand
        .builder()
        .externalId("42")
        .specDescription("Spec Description");

    // Assert
    assertSame(actualSpecDescriptionResult, actualSpecDescriptionResult.specExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#basisOffset(String)}
   */
  @Test
  void testBuilderBasisOffset() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.basisOffset("Basis Offset"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#criticality(String)}
   */
  @Test
  void testBuilderCriticality() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.criticality("Criticality"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#dataType(String)}
   */
  @Test
  void testBuilderDataType() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataType("Data Type"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#description(String)}
   */
  @Test
  void testBuilderDescription() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#format(String)}
   */
  @Test
  void testBuilderFormat() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.format("Format"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#frequency(String)}
   */
  @Test
  void testBuilderFrequency() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.frequency("Frequency"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutablePhysicalFlowUploadCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutablePhysicalFlowUploadCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#from(PhysicalFlowUploadCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
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
    ImmutablePhysicalFlowUploadCommand.Builder actualFromResult = builderResult.from(instance);

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
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#from(PhysicalFlowUploadCommand)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
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
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#from(PhysicalFlowUploadCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
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
    ImmutablePhysicalFlowUploadCommand.Builder actualFromResult = builderResult.from(instance);

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
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#from(PhysicalFlowUploadCommand)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
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
    ImmutablePhysicalFlowUploadCommand.Builder actualFromResult = builderResult.from(instance);

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
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#from(PhysicalFlowUploadCommand)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
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
    ImmutablePhysicalFlowUploadCommand.Builder actualFromResult = builderResult.from(instance);

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
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#from(PhysicalFlowUploadCommand)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
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
    ImmutablePhysicalFlowUploadCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#owner(String)}
   */
  @Test
  void testBuilderOwner() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.owner("Owner"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#source(String)}
   */
  @Test
  void testBuilderSource() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.source("Source"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#target(String)}
   */
  @Test
  void testBuilderTarget() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.target("Target"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Builder#transport(String)}
   */
  @Test
  void testBuilderTransport() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand.Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.transport("Transport"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand#copyOf(PhysicalFlowUploadCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
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
    ImmutablePhysicalFlowUploadCommand actualCopyOfResult = ImmutablePhysicalFlowUploadCommand.copyOf(instance);

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
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.specExternalId());
    assertEquals("Basis Offset", actualCopyOfResult.basisOffset());
    assertEquals("Criticality", actualCopyOfResult.criticality());
    assertEquals("Data Type", actualCopyOfResult.dataType());
    assertEquals("Format", actualCopyOfResult.format());
    assertEquals("Frequency", actualCopyOfResult.frequency());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Owner", actualCopyOfResult.owner());
    assertEquals("Source", actualCopyOfResult.source());
    assertEquals("Spec Description", actualCopyOfResult.specDescription());
    assertEquals("Target", actualCopyOfResult.target());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Transport", actualCopyOfResult.transport());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Json#basisOffset()}
   */
  @Test
  void testJsonBasisOffset() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowUploadCommand.Json()).basisOffset());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Json#criticality()}
   */
  @Test
  void testJsonCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowUploadCommand.Json()).criticality());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowUploadCommand.Json#dataType()}
   */
  @Test
  void testJsonDataType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowUploadCommand.Json()).dataType());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowUploadCommand.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowUploadCommand.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowUploadCommand.Json#format()}
   */
  @Test
  void testJsonFormat() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowUploadCommand.Json()).format());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Json#frequency()}
   */
  @Test
  void testJsonFrequency() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowUploadCommand.Json()).frequency());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutablePhysicalFlowUploadCommand.Json}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand.Json#setBasisOffset(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand.Json#setCriticality(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand.Json#setDataType(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand.Json#setDescription(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand.Json#setExternalId(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand.Json#setFormat(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand.Json#setFrequency(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand.Json#setName(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand.Json#setOwner(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand.Json#setSource(String)}
   *   <li>
   * {@link ImmutablePhysicalFlowUploadCommand.Json#setSpecDescription(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand.Json#setSpecExternalId(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand.Json#setTarget(String)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand.Json#setTransport(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand.Json actualJson = new ImmutablePhysicalFlowUploadCommand.Json();
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
   * Method under test: {@link ImmutablePhysicalFlowUploadCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowUploadCommand.Json()).name());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowUploadCommand.Json#owner()}
   */
  @Test
  void testJsonOwner() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowUploadCommand.Json()).owner());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowUploadCommand.Json#source()}
   */
  @Test
  void testJsonSource() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowUploadCommand.Json()).source());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Json#specDescription()}
   */
  @Test
  void testJsonSpecDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowUploadCommand.Json()).specDescription());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Json#specExternalId()}
   */
  @Test
  void testJsonSpecExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowUploadCommand.Json()).specExternalId());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlowUploadCommand.Json#target()}
   */
  @Test
  void testJsonTarget() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlowUploadCommand.Json()).target());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowUploadCommand.Json#transport()}
   */
  @Test
  void testJsonTransport() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowUploadCommand.Json()).transport());
  }
}
