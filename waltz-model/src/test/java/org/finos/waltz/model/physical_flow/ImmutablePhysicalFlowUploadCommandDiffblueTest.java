package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowUploadCommand.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowUploadCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowUploadCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#basisOffset(String)}.
   *
   * <ul>
   *   <li>When {@code Basis Offset}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#basisOffset(String)}
   */
  @Test
  @DisplayName("Test Builder basisOffset(String); when 'Basis Offset'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.basisOffset(String)"})
  void testBuilderBasisOffset_whenBasisOffset_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act
    Builder actualBasisOffsetResult = builderResult.basisOffset("Basis Offset");

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
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#specDescription(String)}
   *   <li>{@link Builder#specExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand Builder.build()",
    "Builder Builder.externalId(String)",
    "Builder Builder.specDescription(String)",
    "Builder Builder.specExternalId(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand actualImmutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Assert
    assertEquals("42", actualImmutablePhysicalFlowUploadCommand.externalId());
    assertEquals("42", actualImmutablePhysicalFlowUploadCommand.specExternalId());
    assertEquals("Basis Offset", actualImmutablePhysicalFlowUploadCommand.basisOffset());
    assertEquals("Criticality", actualImmutablePhysicalFlowUploadCommand.criticality());
    assertEquals("Data Type", actualImmutablePhysicalFlowUploadCommand.dataType());
    assertEquals("Format", actualImmutablePhysicalFlowUploadCommand.format());
    assertEquals("Frequency", actualImmutablePhysicalFlowUploadCommand.frequency());
    assertEquals("Name", actualImmutablePhysicalFlowUploadCommand.name());
    assertEquals("Owner", actualImmutablePhysicalFlowUploadCommand.owner());
    assertEquals("Source", actualImmutablePhysicalFlowUploadCommand.source());
    assertEquals("Spec Description", actualImmutablePhysicalFlowUploadCommand.specDescription());
    assertEquals("Target", actualImmutablePhysicalFlowUploadCommand.target());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutablePhysicalFlowUploadCommand.description());
    assertEquals("Transport", actualImmutablePhysicalFlowUploadCommand.transport());
  }

  /**
   * Test Builder {@link Builder#criticality(String)}.
   *
   * <ul>
   *   <li>When {@code Criticality}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#criticality(String)}
   */
  @Test
  @DisplayName("Test Builder criticality(String); when 'Criticality'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.criticality(String)"})
  void testBuilderCriticality_whenCriticality_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act
    Builder actualCriticalityResult = builderResult.criticality("Criticality");

    // Assert
    assertSame(builderResult, actualCriticalityResult);
  }

  /**
   * Test Builder {@link Builder#dataType(String)}.
   *
   * <ul>
   *   <li>When {@code Data Type}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dataType(String)}
   */
  @Test
  @DisplayName("Test Builder dataType(String); when 'Data Type'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dataType(String)"})
  void testBuilderDataType_whenDataType_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act
    Builder actualDataTypeResult = builderResult.dataType("Data Type");

    // Assert
    assertSame(builderResult, actualDataTypeResult);
  }

  /**
   * Test Builder {@link Builder#description(String)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.description(String)"})
  void testBuilderDescription_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act
    Builder actualDescriptionResult =
        builderResult.description("The characteristics of someone or something");

    // Assert
    assertSame(builderResult, actualDescriptionResult);
  }

  /**
   * Test Builder {@link Builder#format(String)}.
   *
   * <ul>
   *   <li>When {@code Format}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#format(String)}
   */
  @Test
  @DisplayName("Test Builder format(String); when 'Format'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.format(String)"})
  void testBuilderFormat_whenFormat_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act
    Builder actualFormatResult = builderResult.format("Format");

    // Assert
    assertSame(builderResult, actualFormatResult);
  }

  /**
   * Test Builder {@link Builder#frequency(String)}.
   *
   * <ul>
   *   <li>When {@code Frequency}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#frequency(String)}
   */
  @Test
  @DisplayName("Test Builder frequency(String); when 'Frequency'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.frequency(String)"})
  void testBuilderFrequency_whenFrequency_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act
    Builder actualFrequencyResult = builderResult.frequency("Frequency");

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
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
    ImmutablePhysicalFlowUploadCommand instance =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutablePhysicalFlowUploadCommand actualImmutablePhysicalFlowUploadCommand =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowUploadCommand);
    assertSame(builderResult, actualFromResult);
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
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test Builder {@link Builder#from(PhysicalFlowUploadCommand)} with {@code
   * PhysicalFlowUploadCommand}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowUploadCommand) with 'PhysicalFlowUploadCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowUploadCommand)"})
  void testBuilderFromWithPhysicalFlowUploadCommand() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
    ImmutablePhysicalFlowUploadCommand instance =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowUploadCommand actualImmutablePhysicalFlowUploadCommand =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowUploadCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowUploadCommand)} with {@code
   * PhysicalFlowUploadCommand}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowUploadCommand) with 'PhysicalFlowUploadCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowUploadCommand)"})
  void testBuilderFromWithPhysicalFlowUploadCommand2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
    ImmutablePhysicalFlowUploadCommand instance =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId(null)
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowUploadCommand actualImmutablePhysicalFlowUploadCommand =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowUploadCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowUploadCommand)} with {@code
   * PhysicalFlowUploadCommand}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowUploadCommand) with 'PhysicalFlowUploadCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowUploadCommand)"})
  void testBuilderFromWithPhysicalFlowUploadCommand3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
    ImmutablePhysicalFlowUploadCommand instance =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription(null)
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowUploadCommand actualImmutablePhysicalFlowUploadCommand =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowUploadCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowUploadCommand)} with {@code
   * PhysicalFlowUploadCommand}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowUploadCommand) with 'PhysicalFlowUploadCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowUploadCommand)"})
  void testBuilderFromWithPhysicalFlowUploadCommand4() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();
    ImmutablePhysicalFlowUploadCommand instance =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId(null)
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowUploadCommand actualImmutablePhysicalFlowUploadCommand =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowUploadCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#owner(String)}.
   *
   * <ul>
   *   <li>When {@code Owner}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#owner(String)}
   */
  @Test
  @DisplayName("Test Builder owner(String); when 'Owner'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.owner(String)"})
  void testBuilderOwner_whenOwner_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act
    Builder actualOwnerResult = builderResult.owner("Owner");

    // Assert
    assertSame(builderResult, actualOwnerResult);
  }

  /**
   * Test Builder {@link Builder#source(String)}.
   *
   * <ul>
   *   <li>When {@code Source}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#source(String)}
   */
  @Test
  @DisplayName("Test Builder source(String); when 'Source'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.source(String)"})
  void testBuilderSource_whenSource_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act
    Builder actualSourceResult = builderResult.source("Source");

    // Assert
    assertSame(builderResult, actualSourceResult);
  }

  /**
   * Test Builder {@link Builder#target(String)}.
   *
   * <ul>
   *   <li>When {@code Target}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#target(String)}
   */
  @Test
  @DisplayName("Test Builder target(String); when 'Target'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.target(String)"})
  void testBuilderTarget_whenTarget_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act
    Builder actualTargetResult = builderResult.target("Target");

    // Assert
    assertSame(builderResult, actualTargetResult);
  }

  /**
   * Test Builder {@link Builder#transport(String)}.
   *
   * <ul>
   *   <li>When {@code Transport}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#transport(String)}
   */
  @Test
  @DisplayName("Test Builder transport(String); when 'Transport'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.transport(String)"})
  void testBuilderTransport_whenTransport_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowUploadCommand.builder();

    // Act
    Builder actualTransportResult = builderResult.transport("Transport");

    // Assert
    assertSame(builderResult, actualTransportResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#copyOf(PhysicalFlowUploadCommand)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowUploadCommand#copyOf(PhysicalFlowUploadCommand)}
   */
  @Test
  @DisplayName("Test copyOf(PhysicalFlowUploadCommand); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.copyOf(PhysicalFlowUploadCommand)"
  })
  void testCopyOf_thenReturnExternalIdIs42() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand instance =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommand actualCopyOfResult =
        ImmutablePhysicalFlowUploadCommand.copyOf(instance);

    // Assert
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
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}, and {@link
   * ImmutablePhysicalFlowUploadCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand2 =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act and Assert
    assertEquals(immutablePhysicalFlowUploadCommand, immutablePhysicalFlowUploadCommand2);
    assertEquals(
        immutablePhysicalFlowUploadCommand.hashCode(),
        immutablePhysicalFlowUploadCommand2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}, and {@link
   * ImmutablePhysicalFlowUploadCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act and Assert
    assertEquals(immutablePhysicalFlowUploadCommand, immutablePhysicalFlowUploadCommand);
    int expectedHashCodeResult = immutablePhysicalFlowUploadCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalFlowUploadCommand.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Source")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowUploadCommand,
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Source")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowUploadCommand,
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Source")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowUploadCommand,
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("Source")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowUploadCommand,
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("Source")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowUploadCommand,
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Source")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowUploadCommand,
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Source")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowUploadCommand,
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Source")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowUploadCommand,
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Source")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowUploadCommand,
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Target")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowUploadCommand,
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Source")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowUploadCommand,
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("Source")
            .target("Target")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowUploadCommand,
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Source")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowUploadCommand,
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Source")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowUploadCommand,
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowUploadCommand.equals(Object)",
    "int ImmutablePhysicalFlowUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build(),
        "Different type to ImmutablePhysicalFlowUploadCommand");
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) SpecDescription is {@code Json}.
   *   <li>Then return externalId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) SpecDescription is 'Json'; then return externalId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonSpecDescriptionIsJson_thenReturnExternalIdIsJson() {
    // Arrange
    Json json = new Json();
    json.setSource("Json");
    json.setTarget("Json");
    json.setOwner("Json");
    json.setName("Json");
    json.setFormat("Json");
    json.setSpecDescription("Json");
    json.setSpecExternalId("Json");
    json.setBasisOffset("Json");
    json.setCriticality("Json");
    json.setDescription("Json");
    json.setExternalId("Json");
    json.setFrequency("Json");
    json.setTransport("Json");
    json.setDataType("Json");

    // Act
    ImmutablePhysicalFlowUploadCommand actualFromJsonResult =
        ImmutablePhysicalFlowUploadCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.basisOffset());
    assertEquals("Json", actualFromJsonResult.criticality());
    assertEquals("Json", actualFromJsonResult.dataType());
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.format());
    assertEquals("Json", actualFromJsonResult.frequency());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.owner());
    assertEquals("Json", actualFromJsonResult.source());
    assertEquals("Json", actualFromJsonResult.specDescription());
    assertEquals("Json", actualFromJsonResult.specExternalId());
    assertEquals("Json", actualFromJsonResult.target());
    assertEquals("Json", actualFromJsonResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) ExternalId is {@code null}.
   *   <li>Then return externalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) ExternalId is 'null'; then return externalId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonExternalIdIsNull_thenReturnExternalIdIsNull() {
    // Arrange
    Json json = new Json();
    json.setSource("Json");
    json.setTarget("Json");
    json.setOwner("Json");
    json.setName("Json");
    json.setFormat("Json");
    json.setSpecDescription("Json");
    json.setSpecExternalId("Json");
    json.setBasisOffset("Json");
    json.setCriticality("Json");
    json.setDescription("Json");
    json.setExternalId(null);
    json.setFrequency("Json");
    json.setTransport("Json");
    json.setDataType("Json");

    // Act
    ImmutablePhysicalFlowUploadCommand actualFromJsonResult =
        ImmutablePhysicalFlowUploadCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.basisOffset());
    assertEquals("Json", actualFromJsonResult.criticality());
    assertEquals("Json", actualFromJsonResult.dataType());
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.format());
    assertEquals("Json", actualFromJsonResult.frequency());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.owner());
    assertEquals("Json", actualFromJsonResult.source());
    assertEquals("Json", actualFromJsonResult.specDescription());
    assertEquals("Json", actualFromJsonResult.specExternalId());
    assertEquals("Json", actualFromJsonResult.target());
    assertEquals("Json", actualFromJsonResult.transport());
    assertNull(actualFromJsonResult.externalId());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) SpecDescription is {@code null}.
   *   <li>Then return specDescription is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) SpecDescription is 'null'; then return specDescription is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.fromJson(Json)"
  })
  void testFromJson_whenJsonSpecDescriptionIsNull_thenReturnSpecDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setSource("Json");
    json.setTarget("Json");
    json.setOwner("Json");
    json.setName("Json");
    json.setFormat("Json");
    json.setSpecDescription(null);
    json.setSpecExternalId("Json");
    json.setBasisOffset("Json");
    json.setCriticality("Json");
    json.setDescription("Json");
    json.setExternalId("Json");
    json.setFrequency("Json");
    json.setTransport("Json");
    json.setDataType("Json");

    // Act
    ImmutablePhysicalFlowUploadCommand actualFromJsonResult =
        ImmutablePhysicalFlowUploadCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.basisOffset());
    assertEquals("Json", actualFromJsonResult.criticality());
    assertEquals("Json", actualFromJsonResult.dataType());
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.format());
    assertEquals("Json", actualFromJsonResult.frequency());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.owner());
    assertEquals("Json", actualFromJsonResult.source());
    assertEquals("Json", actualFromJsonResult.specExternalId());
    assertEquals("Json", actualFromJsonResult.target());
    assertEquals("Json", actualFromJsonResult.transport());
    assertNull(actualFromJsonResult.specDescription());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) SpecExternalId is {@code null}.
   *   <li>Then return specExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) SpecExternalId is 'null'; then return specExternalId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.fromJson(Json)"
  })
  void testFromJson_whenJsonSpecExternalIdIsNull_thenReturnSpecExternalIdIsNull() {
    // Arrange
    Json json = new Json();
    json.setSource("Json");
    json.setTarget("Json");
    json.setOwner("Json");
    json.setName("Json");
    json.setFormat("Json");
    json.setSpecDescription("Json");
    json.setSpecExternalId(null);
    json.setBasisOffset("Json");
    json.setCriticality("Json");
    json.setDescription("Json");
    json.setExternalId("Json");
    json.setFrequency("Json");
    json.setTransport("Json");
    json.setDataType("Json");

    // Act
    ImmutablePhysicalFlowUploadCommand actualFromJsonResult =
        ImmutablePhysicalFlowUploadCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.basisOffset());
    assertEquals("Json", actualFromJsonResult.criticality());
    assertEquals("Json", actualFromJsonResult.dataType());
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.format());
    assertEquals("Json", actualFromJsonResult.frequency());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.owner());
    assertEquals("Json", actualFromJsonResult.source());
    assertEquals("Json", actualFromJsonResult.specDescription());
    assertEquals("Json", actualFromJsonResult.target());
    assertEquals("Json", actualFromJsonResult.transport());
    assertNull(actualFromJsonResult.specExternalId());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#toString()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#basisOffset()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#criticality()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#dataType()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#description()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#externalId()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#format()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#frequency()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#name()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#owner()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#source()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#specDescription()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#specExternalId()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#target()}
   *   <li>{@link ImmutablePhysicalFlowUploadCommand#transport()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutablePhysicalFlowUploadCommand.basisOffset()",
    "String ImmutablePhysicalFlowUploadCommand.criticality()",
    "String ImmutablePhysicalFlowUploadCommand.dataType()",
    "String ImmutablePhysicalFlowUploadCommand.description()",
    "String ImmutablePhysicalFlowUploadCommand.externalId()",
    "String ImmutablePhysicalFlowUploadCommand.format()",
    "String ImmutablePhysicalFlowUploadCommand.frequency()",
    "String ImmutablePhysicalFlowUploadCommand.name()",
    "String ImmutablePhysicalFlowUploadCommand.owner()",
    "String ImmutablePhysicalFlowUploadCommand.source()",
    "String ImmutablePhysicalFlowUploadCommand.specDescription()",
    "String ImmutablePhysicalFlowUploadCommand.specExternalId()",
    "String ImmutablePhysicalFlowUploadCommand.target()",
    "String ImmutablePhysicalFlowUploadCommand.toString()",
    "String ImmutablePhysicalFlowUploadCommand.transport()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    String actualToStringResult = immutablePhysicalFlowUploadCommand.toString();
    String actualBasisOffsetResult = immutablePhysicalFlowUploadCommand.basisOffset();
    String actualCriticalityResult = immutablePhysicalFlowUploadCommand.criticality();
    String actualDataTypeResult = immutablePhysicalFlowUploadCommand.dataType();
    String actualDescriptionResult = immutablePhysicalFlowUploadCommand.description();
    String actualExternalIdResult = immutablePhysicalFlowUploadCommand.externalId();
    String actualFormatResult = immutablePhysicalFlowUploadCommand.format();
    String actualFrequencyResult = immutablePhysicalFlowUploadCommand.frequency();
    String actualNameResult = immutablePhysicalFlowUploadCommand.name();
    String actualOwnerResult = immutablePhysicalFlowUploadCommand.owner();
    String actualSourceResult = immutablePhysicalFlowUploadCommand.source();
    String actualSpecDescriptionResult = immutablePhysicalFlowUploadCommand.specDescription();
    String actualSpecExternalIdResult = immutablePhysicalFlowUploadCommand.specExternalId();
    String actualTargetResult = immutablePhysicalFlowUploadCommand.target();

    // Assert
    assertEquals("42", actualExternalIdResult);
    assertEquals("42", actualSpecExternalIdResult);
    assertEquals("Basis Offset", actualBasisOffsetResult);
    assertEquals("Criticality", actualCriticalityResult);
    assertEquals("Data Type", actualDataTypeResult);
    assertEquals("Format", actualFormatResult);
    assertEquals("Frequency", actualFrequencyResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Owner", actualOwnerResult);
    assertEquals(
        "PhysicalFlowUploadCommand{source=Source, target=Target, owner=Owner, name=Name, format=Format,"
            + " specDescription=Spec Description, specExternalId=42, basisOffset=Basis Offset, criticality=Criticality,"
            + " description=The characteristics of someone or something, externalId=42, frequency=Frequency,"
            + " transport=Transport, dataType=Data Type}",
        actualToStringResult);
    assertEquals("Source", actualSourceResult);
    assertEquals("Spec Description", actualSpecDescriptionResult);
    assertEquals("Target", actualTargetResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals("Transport", immutablePhysicalFlowUploadCommand.transport());
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
  @MethodsUnderTest({"String Json.basisOffset()"})
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
  @MethodsUnderTest({"String Json.criticality()"})
  void testJsonCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().criticality());
  }

  /**
   * Test Json {@link Json#dataType()}.
   *
   * <p>Method under test: {@link Json#dataType()}
   */
  @Test
  @DisplayName("Test Json dataType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.dataType()"})
  void testJsonDataType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dataType());
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
  @MethodsUnderTest({"String Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json {@link Json#format()}.
   *
   * <p>Method under test: {@link Json#format()}
   */
  @Test
  @DisplayName("Test Json format()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.format()"})
  void testJsonFormat() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().format());
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
  @MethodsUnderTest({"String Json.frequency()"})
  void testJsonFrequency() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().frequency());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setBasisOffset(String)",
    "void Json.setCriticality(String)",
    "void Json.setDataType(String)",
    "void Json.setDescription(String)",
    "void Json.setExternalId(String)",
    "void Json.setFormat(String)",
    "void Json.setFrequency(String)",
    "void Json.setName(String)",
    "void Json.setOwner(String)",
    "void Json.setSource(String)",
    "void Json.setSpecDescription(String)",
    "void Json.setSpecExternalId(String)",
    "void Json.setTarget(String)",
    "void Json.setTransport(String)"
  })
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
   * Test Json {@link Json#owner()}.
   *
   * <p>Method under test: {@link Json#owner()}
   */
  @Test
  @DisplayName("Test Json owner()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.owner()"})
  void testJsonOwner() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().owner());
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
  @MethodsUnderTest({"String Json.source()"})
  void testJsonSource() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().source());
  }

  /**
   * Test Json {@link Json#specDescription()}.
   *
   * <p>Method under test: {@link Json#specDescription()}
   */
  @Test
  @DisplayName("Test Json specDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.specDescription()"})
  void testJsonSpecDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().specDescription());
  }

  /**
   * Test Json {@link Json#specExternalId()}.
   *
   * <p>Method under test: {@link Json#specExternalId()}
   */
  @Test
  @DisplayName("Test Json specExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.specExternalId()"})
  void testJsonSpecExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().specExternalId());
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
  @MethodsUnderTest({"String Json.target()"})
  void testJsonTarget() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().target());
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
  @MethodsUnderTest({"String Json.transport()"})
  void testJsonTransport() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withBasisOffset(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withBasisOffset(String)}
   */
  @Test
  @DisplayName("Test withBasisOffset(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withBasisOffset(String)"
  })
  void testWithBasisOffset() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("42")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommand actualWithBasisOffsetResult =
        immutablePhysicalFlowUploadCommand.withBasisOffset("42");

    // Assert
    assertSame(immutablePhysicalFlowUploadCommand, actualWithBasisOffsetResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withBasisOffset(String)}.
   *
   * <ul>
   *   <li>Then return basisOffset is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withBasisOffset(String)}
   */
  @Test
  @DisplayName("Test withBasisOffset(String); then return basisOffset is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withBasisOffset(String)"
  })
  void testWithBasisOffset_thenReturnBasisOffsetIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand actualWithBasisOffsetResult =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build()
            .withBasisOffset("42");

    // Assert
    assertEquals("42", actualWithBasisOffsetResult.basisOffset());
    assertEquals("42", actualWithBasisOffsetResult.externalId());
    assertEquals("42", actualWithBasisOffsetResult.specExternalId());
    assertEquals("Criticality", actualWithBasisOffsetResult.criticality());
    assertEquals("Data Type", actualWithBasisOffsetResult.dataType());
    assertEquals("Format", actualWithBasisOffsetResult.format());
    assertEquals("Frequency", actualWithBasisOffsetResult.frequency());
    assertEquals("Name", actualWithBasisOffsetResult.name());
    assertEquals("Owner", actualWithBasisOffsetResult.owner());
    assertEquals("Source", actualWithBasisOffsetResult.source());
    assertEquals("Spec Description", actualWithBasisOffsetResult.specDescription());
    assertEquals("Target", actualWithBasisOffsetResult.target());
    assertEquals(
        "The characteristics of someone or something", actualWithBasisOffsetResult.description());
    assertEquals("Transport", actualWithBasisOffsetResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withCriticality(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withCriticality(String)}
   */
  @Test
  @DisplayName("Test withCriticality(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withCriticality(String)"
  })
  void testWithCriticality() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("42")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommand actualWithCriticalityResult =
        immutablePhysicalFlowUploadCommand.withCriticality("42");

    // Assert
    assertSame(immutablePhysicalFlowUploadCommand, actualWithCriticalityResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withCriticality(String)}.
   *
   * <ul>
   *   <li>Then return criticality is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withCriticality(String)}
   */
  @Test
  @DisplayName("Test withCriticality(String); then return criticality is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withCriticality(String)"
  })
  void testWithCriticality_thenReturnCriticalityIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand actualWithCriticalityResult =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build()
            .withCriticality("42");

    // Assert
    assertEquals("42", actualWithCriticalityResult.criticality());
    assertEquals("42", actualWithCriticalityResult.externalId());
    assertEquals("42", actualWithCriticalityResult.specExternalId());
    assertEquals("Basis Offset", actualWithCriticalityResult.basisOffset());
    assertEquals("Data Type", actualWithCriticalityResult.dataType());
    assertEquals("Format", actualWithCriticalityResult.format());
    assertEquals("Frequency", actualWithCriticalityResult.frequency());
    assertEquals("Name", actualWithCriticalityResult.name());
    assertEquals("Owner", actualWithCriticalityResult.owner());
    assertEquals("Source", actualWithCriticalityResult.source());
    assertEquals("Spec Description", actualWithCriticalityResult.specDescription());
    assertEquals("Target", actualWithCriticalityResult.target());
    assertEquals(
        "The characteristics of someone or something", actualWithCriticalityResult.description());
    assertEquals("Transport", actualWithCriticalityResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withDataType(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withDataType(String)}
   */
  @Test
  @DisplayName("Test withDataType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withDataType(String)"
  })
  void testWithDataType() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("42")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommand actualWithDataTypeResult =
        immutablePhysicalFlowUploadCommand.withDataType("42");

    // Assert
    assertSame(immutablePhysicalFlowUploadCommand, actualWithDataTypeResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withDataType(String)}.
   *
   * <ul>
   *   <li>Then return dataType is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withDataType(String)}
   */
  @Test
  @DisplayName("Test withDataType(String); then return dataType is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withDataType(String)"
  })
  void testWithDataType_thenReturnDataTypeIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand actualWithDataTypeResult =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build()
            .withDataType("42");

    // Assert
    assertEquals("42", actualWithDataTypeResult.dataType());
    assertEquals("42", actualWithDataTypeResult.externalId());
    assertEquals("42", actualWithDataTypeResult.specExternalId());
    assertEquals("Basis Offset", actualWithDataTypeResult.basisOffset());
    assertEquals("Criticality", actualWithDataTypeResult.criticality());
    assertEquals("Format", actualWithDataTypeResult.format());
    assertEquals("Frequency", actualWithDataTypeResult.frequency());
    assertEquals("Name", actualWithDataTypeResult.name());
    assertEquals("Owner", actualWithDataTypeResult.owner());
    assertEquals("Source", actualWithDataTypeResult.source());
    assertEquals("Spec Description", actualWithDataTypeResult.specDescription());
    assertEquals("Target", actualWithDataTypeResult.target());
    assertEquals(
        "The characteristics of someone or something", actualWithDataTypeResult.description());
    assertEquals("Transport", actualWithDataTypeResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("42")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommand actualWithDescriptionResult =
        immutablePhysicalFlowUploadCommand.withDescription("42");

    // Assert
    assertSame(immutablePhysicalFlowUploadCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withDescription(String)"
  })
  void testWithDescription_thenReturnDescriptionIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand actualWithDescriptionResult =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build()
            .withDescription("42");

    // Assert
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals("42", actualWithDescriptionResult.externalId());
    assertEquals("42", actualWithDescriptionResult.specExternalId());
    assertEquals("Basis Offset", actualWithDescriptionResult.basisOffset());
    assertEquals("Criticality", actualWithDescriptionResult.criticality());
    assertEquals("Data Type", actualWithDescriptionResult.dataType());
    assertEquals("Format", actualWithDescriptionResult.format());
    assertEquals("Frequency", actualWithDescriptionResult.frequency());
    assertEquals("Name", actualWithDescriptionResult.name());
    assertEquals("Owner", actualWithDescriptionResult.owner());
    assertEquals("Source", actualWithDescriptionResult.source());
    assertEquals("Spec Description", actualWithDescriptionResult.specDescription());
    assertEquals("Target", actualWithDescriptionResult.target());
    assertEquals("Transport", actualWithDescriptionResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withExternalId(String)"
  })
  void testWithExternalId() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommand actualWithExternalIdResult =
        immutablePhysicalFlowUploadCommand.withExternalId("42");

    // Assert
    assertSame(immutablePhysicalFlowUploadCommand, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return externalId is {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String); when '0123456789ABCDEF'; then return externalId is '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withExternalId(String)"
  })
  void testWithExternalId_when0123456789abcdef_thenReturnExternalIdIs0123456789abcdef() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand actualWithExternalIdResult =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualWithExternalIdResult.externalId());
    assertEquals("42", actualWithExternalIdResult.specExternalId());
    assertEquals("Basis Offset", actualWithExternalIdResult.basisOffset());
    assertEquals("Criticality", actualWithExternalIdResult.criticality());
    assertEquals("Data Type", actualWithExternalIdResult.dataType());
    assertEquals("Format", actualWithExternalIdResult.format());
    assertEquals("Frequency", actualWithExternalIdResult.frequency());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Owner", actualWithExternalIdResult.owner());
    assertEquals("Source", actualWithExternalIdResult.source());
    assertEquals("Spec Description", actualWithExternalIdResult.specDescription());
    assertEquals("Target", actualWithExternalIdResult.target());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals("Transport", actualWithExternalIdResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withFormat(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withFormat(String)}
   */
  @Test
  @DisplayName("Test withFormat(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withFormat(String)"
  })
  void testWithFormat() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("42")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommand actualWithFormatResult =
        immutablePhysicalFlowUploadCommand.withFormat("42");

    // Assert
    assertSame(immutablePhysicalFlowUploadCommand, actualWithFormatResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withFormat(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withFormat(String)}
   */
  @Test
  @DisplayName("Test withFormat(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withFormat(String)"
  })
  void testWithFormat_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand actualWithFormatResult =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build()
            .withFormat("42");

    // Assert
    assertEquals("42", actualWithFormatResult.externalId());
    assertEquals("42", actualWithFormatResult.format());
    assertEquals("42", actualWithFormatResult.specExternalId());
    assertEquals("Basis Offset", actualWithFormatResult.basisOffset());
    assertEquals("Criticality", actualWithFormatResult.criticality());
    assertEquals("Data Type", actualWithFormatResult.dataType());
    assertEquals("Frequency", actualWithFormatResult.frequency());
    assertEquals("Name", actualWithFormatResult.name());
    assertEquals("Owner", actualWithFormatResult.owner());
    assertEquals("Source", actualWithFormatResult.source());
    assertEquals("Spec Description", actualWithFormatResult.specDescription());
    assertEquals("Target", actualWithFormatResult.target());
    assertEquals(
        "The characteristics of someone or something", actualWithFormatResult.description());
    assertEquals("Transport", actualWithFormatResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withFrequency(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withFrequency(String)}
   */
  @Test
  @DisplayName("Test withFrequency(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withFrequency(String)"
  })
  void testWithFrequency() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("42")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommand actualWithFrequencyResult =
        immutablePhysicalFlowUploadCommand.withFrequency("42");

    // Assert
    assertSame(immutablePhysicalFlowUploadCommand, actualWithFrequencyResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withFrequency(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withFrequency(String)}
   */
  @Test
  @DisplayName("Test withFrequency(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withFrequency(String)"
  })
  void testWithFrequency_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand actualWithFrequencyResult =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build()
            .withFrequency("42");

    // Assert
    assertEquals("42", actualWithFrequencyResult.externalId());
    assertEquals("42", actualWithFrequencyResult.frequency());
    assertEquals("42", actualWithFrequencyResult.specExternalId());
    assertEquals("Basis Offset", actualWithFrequencyResult.basisOffset());
    assertEquals("Criticality", actualWithFrequencyResult.criticality());
    assertEquals("Data Type", actualWithFrequencyResult.dataType());
    assertEquals("Format", actualWithFrequencyResult.format());
    assertEquals("Name", actualWithFrequencyResult.name());
    assertEquals("Owner", actualWithFrequencyResult.owner());
    assertEquals("Source", actualWithFrequencyResult.source());
    assertEquals("Spec Description", actualWithFrequencyResult.specDescription());
    assertEquals("Target", actualWithFrequencyResult.target());
    assertEquals(
        "The characteristics of someone or something", actualWithFrequencyResult.description());
    assertEquals("Transport", actualWithFrequencyResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("42")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommand actualWithNameResult =
        immutablePhysicalFlowUploadCommand.withName("42");

    // Assert
    assertSame(immutablePhysicalFlowUploadCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withName(String)"
  })
  void testWithName_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand actualWithNameResult =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.externalId());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("42", actualWithNameResult.specExternalId());
    assertEquals("Basis Offset", actualWithNameResult.basisOffset());
    assertEquals("Criticality", actualWithNameResult.criticality());
    assertEquals("Data Type", actualWithNameResult.dataType());
    assertEquals("Format", actualWithNameResult.format());
    assertEquals("Frequency", actualWithNameResult.frequency());
    assertEquals("Owner", actualWithNameResult.owner());
    assertEquals("Source", actualWithNameResult.source());
    assertEquals("Spec Description", actualWithNameResult.specDescription());
    assertEquals("Target", actualWithNameResult.target());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals("Transport", actualWithNameResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withOwner(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withOwner(String)}
   */
  @Test
  @DisplayName("Test withOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withOwner(String)"
  })
  void testWithOwner() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("42")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommand actualWithOwnerResult =
        immutablePhysicalFlowUploadCommand.withOwner("42");

    // Assert
    assertSame(immutablePhysicalFlowUploadCommand, actualWithOwnerResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withOwner(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withOwner(String)}
   */
  @Test
  @DisplayName("Test withOwner(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withOwner(String)"
  })
  void testWithOwner_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand actualWithOwnerResult =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build()
            .withOwner("42");

    // Assert
    assertEquals("42", actualWithOwnerResult.externalId());
    assertEquals("42", actualWithOwnerResult.owner());
    assertEquals("42", actualWithOwnerResult.specExternalId());
    assertEquals("Basis Offset", actualWithOwnerResult.basisOffset());
    assertEquals("Criticality", actualWithOwnerResult.criticality());
    assertEquals("Data Type", actualWithOwnerResult.dataType());
    assertEquals("Format", actualWithOwnerResult.format());
    assertEquals("Frequency", actualWithOwnerResult.frequency());
    assertEquals("Name", actualWithOwnerResult.name());
    assertEquals("Source", actualWithOwnerResult.source());
    assertEquals("Spec Description", actualWithOwnerResult.specDescription());
    assertEquals("Target", actualWithOwnerResult.target());
    assertEquals(
        "The characteristics of someone or something", actualWithOwnerResult.description());
    assertEquals("Transport", actualWithOwnerResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withSource(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withSource(String)}
   */
  @Test
  @DisplayName("Test withSource(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withSource(String)"
  })
  void testWithSource() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("42")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommand actualWithSourceResult =
        immutablePhysicalFlowUploadCommand.withSource("42");

    // Assert
    assertSame(immutablePhysicalFlowUploadCommand, actualWithSourceResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withSource(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withSource(String)}
   */
  @Test
  @DisplayName("Test withSource(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withSource(String)"
  })
  void testWithSource_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand actualWithSourceResult =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build()
            .withSource("42");

    // Assert
    assertEquals("42", actualWithSourceResult.externalId());
    assertEquals("42", actualWithSourceResult.source());
    assertEquals("42", actualWithSourceResult.specExternalId());
    assertEquals("Basis Offset", actualWithSourceResult.basisOffset());
    assertEquals("Criticality", actualWithSourceResult.criticality());
    assertEquals("Data Type", actualWithSourceResult.dataType());
    assertEquals("Format", actualWithSourceResult.format());
    assertEquals("Frequency", actualWithSourceResult.frequency());
    assertEquals("Name", actualWithSourceResult.name());
    assertEquals("Owner", actualWithSourceResult.owner());
    assertEquals("Spec Description", actualWithSourceResult.specDescription());
    assertEquals("Target", actualWithSourceResult.target());
    assertEquals(
        "The characteristics of someone or something", actualWithSourceResult.description());
    assertEquals("Transport", actualWithSourceResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withSpecDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withSpecDescription(String)}
   */
  @Test
  @DisplayName("Test withSpecDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withSpecDescription(String)"
  })
  void testWithSpecDescription() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("42")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommand actualWithSpecDescriptionResult =
        immutablePhysicalFlowUploadCommand.withSpecDescription("42");

    // Assert
    assertSame(immutablePhysicalFlowUploadCommand, actualWithSpecDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withSpecDescription(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withSpecDescription(String)}
   */
  @Test
  @DisplayName("Test withSpecDescription(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withSpecDescription(String)"
  })
  void testWithSpecDescription_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand actualWithSpecDescriptionResult =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build()
            .withSpecDescription("42");

    // Assert
    assertEquals("42", actualWithSpecDescriptionResult.externalId());
    assertEquals("42", actualWithSpecDescriptionResult.specDescription());
    assertEquals("42", actualWithSpecDescriptionResult.specExternalId());
    assertEquals("Basis Offset", actualWithSpecDescriptionResult.basisOffset());
    assertEquals("Criticality", actualWithSpecDescriptionResult.criticality());
    assertEquals("Data Type", actualWithSpecDescriptionResult.dataType());
    assertEquals("Format", actualWithSpecDescriptionResult.format());
    assertEquals("Frequency", actualWithSpecDescriptionResult.frequency());
    assertEquals("Name", actualWithSpecDescriptionResult.name());
    assertEquals("Owner", actualWithSpecDescriptionResult.owner());
    assertEquals("Source", actualWithSpecDescriptionResult.source());
    assertEquals("Target", actualWithSpecDescriptionResult.target());
    assertEquals(
        "The characteristics of someone or something",
        actualWithSpecDescriptionResult.description());
    assertEquals("Transport", actualWithSpecDescriptionResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withSpecExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withSpecExternalId(String)}
   */
  @Test
  @DisplayName("Test withSpecExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withSpecExternalId(String)"
  })
  void testWithSpecExternalId() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommand actualWithSpecExternalIdResult =
        immutablePhysicalFlowUploadCommand.withSpecExternalId("42");

    // Assert
    assertSame(immutablePhysicalFlowUploadCommand, actualWithSpecExternalIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withSpecExternalId(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withSpecExternalId(String)}
   */
  @Test
  @DisplayName("Test withSpecExternalId(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withSpecExternalId(String)"
  })
  void testWithSpecExternalId_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand actualWithSpecExternalIdResult =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("Spec External Id")
            .target("Target")
            .transport("Transport")
            .build()
            .withSpecExternalId("42");

    // Assert
    assertEquals("42", actualWithSpecExternalIdResult.externalId());
    assertEquals("42", actualWithSpecExternalIdResult.specExternalId());
    assertEquals("Basis Offset", actualWithSpecExternalIdResult.basisOffset());
    assertEquals("Criticality", actualWithSpecExternalIdResult.criticality());
    assertEquals("Data Type", actualWithSpecExternalIdResult.dataType());
    assertEquals("Format", actualWithSpecExternalIdResult.format());
    assertEquals("Frequency", actualWithSpecExternalIdResult.frequency());
    assertEquals("Name", actualWithSpecExternalIdResult.name());
    assertEquals("Owner", actualWithSpecExternalIdResult.owner());
    assertEquals("Source", actualWithSpecExternalIdResult.source());
    assertEquals("Spec Description", actualWithSpecExternalIdResult.specDescription());
    assertEquals("Target", actualWithSpecExternalIdResult.target());
    assertEquals(
        "The characteristics of someone or something",
        actualWithSpecExternalIdResult.description());
    assertEquals("Transport", actualWithSpecExternalIdResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withTarget(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withTarget(String)}
   */
  @Test
  @DisplayName("Test withTarget(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withTarget(String)"
  })
  void testWithTarget() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("42")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommand actualWithTargetResult =
        immutablePhysicalFlowUploadCommand.withTarget("42");

    // Assert
    assertSame(immutablePhysicalFlowUploadCommand, actualWithTargetResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withTarget(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withTarget(String)}
   */
  @Test
  @DisplayName("Test withTarget(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withTarget(String)"
  })
  void testWithTarget_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand actualWithTargetResult =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build()
            .withTarget("42");

    // Assert
    assertEquals("42", actualWithTargetResult.externalId());
    assertEquals("42", actualWithTargetResult.specExternalId());
    assertEquals("42", actualWithTargetResult.target());
    assertEquals("Basis Offset", actualWithTargetResult.basisOffset());
    assertEquals("Criticality", actualWithTargetResult.criticality());
    assertEquals("Data Type", actualWithTargetResult.dataType());
    assertEquals("Format", actualWithTargetResult.format());
    assertEquals("Frequency", actualWithTargetResult.frequency());
    assertEquals("Name", actualWithTargetResult.name());
    assertEquals("Owner", actualWithTargetResult.owner());
    assertEquals("Source", actualWithTargetResult.source());
    assertEquals("Spec Description", actualWithTargetResult.specDescription());
    assertEquals(
        "The characteristics of someone or something", actualWithTargetResult.description());
    assertEquals("Transport", actualWithTargetResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withTransport(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withTransport(String)}
   */
  @Test
  @DisplayName("Test withTransport(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withTransport(String)"
  })
  void testWithTransport() {
    // Arrange
    ImmutablePhysicalFlowUploadCommand immutablePhysicalFlowUploadCommand =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("42")
            .build();

    // Act
    ImmutablePhysicalFlowUploadCommand actualWithTransportResult =
        immutablePhysicalFlowUploadCommand.withTransport("42");

    // Assert
    assertSame(immutablePhysicalFlowUploadCommand, actualWithTransportResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowUploadCommand#withTransport(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowUploadCommand#withTransport(String)}
   */
  @Test
  @DisplayName("Test withTransport(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowUploadCommand ImmutablePhysicalFlowUploadCommand.withTransport(String)"
  })
  void testWithTransport_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowUploadCommand actualWithTransportResult =
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build()
            .withTransport("42");

    // Assert
    assertEquals("42", actualWithTransportResult.externalId());
    assertEquals("42", actualWithTransportResult.specExternalId());
    assertEquals("42", actualWithTransportResult.transport());
    assertEquals("Basis Offset", actualWithTransportResult.basisOffset());
    assertEquals("Criticality", actualWithTransportResult.criticality());
    assertEquals("Data Type", actualWithTransportResult.dataType());
    assertEquals("Format", actualWithTransportResult.format());
    assertEquals("Frequency", actualWithTransportResult.frequency());
    assertEquals("Name", actualWithTransportResult.name());
    assertEquals("Owner", actualWithTransportResult.owner());
    assertEquals("Source", actualWithTransportResult.source());
    assertEquals("Spec Description", actualWithTransportResult.specDescription());
    assertEquals("Target", actualWithTransportResult.target());
    assertEquals(
        "The characteristics of someone or something", actualWithTransportResult.description());
  }
}
