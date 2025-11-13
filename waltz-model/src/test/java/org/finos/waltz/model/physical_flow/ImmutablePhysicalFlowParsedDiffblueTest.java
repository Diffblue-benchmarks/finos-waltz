package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowParsed.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowParsed.Json;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowParsedDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#basisOffset(Integer)}
   *   <li>{@link Builder#criticality(CriticalityValue)}
   *   <li>{@link Builder#dataType(EntityReference)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#format(DataFormatKindValue)}
   *   <li>{@link Builder#frequency(FrequencyKindValue)}
   *   <li>{@link Builder#owner(EntityReference)}
   *   <li>{@link Builder#source(EntityReference)}
   *   <li>{@link Builder#specDescription(String)}
   *   <li>{@link Builder#specExternalId(String)}
   *   <li>{@link Builder#target(EntityReference)}
   *   <li>{@link Builder#transport(TransportKindValue)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.basisOffset(Integer)",
    "ImmutablePhysicalFlowParsed Builder.build()",
    "Builder Builder.criticality(CriticalityValue)",
    "Builder Builder.dataType(EntityReference)",
    "Builder Builder.externalId(String)",
    "Builder Builder.format(DataFormatKindValue)",
    "Builder Builder.frequency(FrequencyKindValue)",
    "Builder Builder.owner(EntityReference)",
    "Builder Builder.source(EntityReference)",
    "Builder Builder.specDescription(String)",
    "Builder Builder.specExternalId(String)",
    "Builder Builder.target(EntityReference)",
    "Builder Builder.transport(TransportKindValue)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBasisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");
    Builder actualCriticalityResult = actualBasisOffsetResult.criticality(criticality);
    ImmutableEntityReference dataType =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualExternalIdResult =
        actualCriticalityResult
            .dataType(dataType)
            .description("The characteristics of someone or something")
            .externalId("42");
    DataFormatKindValue format = DataFormatKindValue.of("42");
    Builder actualFormatResult = actualExternalIdResult.format(format);
    FrequencyKindValue frequency = FrequencyKindValue.of("42");
    Builder actualNameResult = actualFormatResult.frequency(frequency).name("Name");
    ImmutableEntityReference owner =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualOwnerResult = actualNameResult.owner(owner);
    ImmutableEntityReference source =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualSpecExternalIdResult =
        actualOwnerResult.source(source).specDescription("Spec Description").specExternalId("42");
    ImmutableEntityReference target =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualTargetResult = actualSpecExternalIdResult.target(target);
    TransportKindValue transport = TransportKindValue.of("42");
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed =
        actualTargetResult.transport(transport).build();

    // Assert
    CriticalityValue criticalityResult = actualImmutablePhysicalFlowParsed.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualImmutablePhysicalFlowParsed.frequency();
    assertEquals("42", frequencyResult.value());
    assertEquals("42", actualImmutablePhysicalFlowParsed.externalId());
    assertEquals("42", actualImmutablePhysicalFlowParsed.specExternalId());
    TransportKindValue transportResult = actualImmutablePhysicalFlowParsed.transport();
    assertEquals("42", transportResult.value());
    DataFormatKindValue formatResult = actualImmutablePhysicalFlowParsed.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualImmutablePhysicalFlowParsed.name());
    assertEquals("Spec Description", actualImmutablePhysicalFlowParsed.specDescription());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutablePhysicalFlowParsed.description());
    assertEquals(1, actualImmutablePhysicalFlowParsed.basisOffset().intValue());
    assertSame(dataType, actualImmutablePhysicalFlowParsed.dataType());
    assertSame(owner, actualImmutablePhysicalFlowParsed.owner());
    assertSame(source, actualImmutablePhysicalFlowParsed.source());
    assertSame(target, actualImmutablePhysicalFlowParsed.target());
    assertSame(criticality, criticalityResult);
    assertSame(frequency, frequencyResult);
    assertSame(transport, transportResult);
    assertSame(format, formatResult);
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
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();

    // Act
    Builder actualDescriptionResult =
        builderResult.description("The characteristics of someone or something");

    // Assert
    assertSame(builderResult, actualDescriptionResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed instance =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed);
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed2);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(null);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed instance =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed);
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed2);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();

    Builder criticalityResult =
        ImmutablePhysicalFlowParsed.builder().basisOffset(1).criticality(null);

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed instance =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed);
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed2);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom4() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId(null);

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed instance =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed);
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed2);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom5() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder formatResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42")
            .format(null);

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed instance =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed);
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed2);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom6() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult =
        externalIdResult.format(DataFormatKindValue.of("42")).frequency(null).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed instance =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed);
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed2);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom7() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription(null)
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed instance =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed);
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed2);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom8() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId(null);

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed instance =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed);
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed2);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParsed)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParsed)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParsed)"})
  void testBuilderFrom9() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");
    ImmutablePhysicalFlowParsed instance =
        specExternalIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .transport(null)
            .build();

    // Act and Assert
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed);
    ImmutablePhysicalFlowParsed actualImmutablePhysicalFlowParsed2 = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowParsed2);
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
    Builder builderResult = ImmutablePhysicalFlowParsed.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#copyOf(PhysicalFlowParsed)}.
   *
   * <ul>
   *   <li>Then dataType return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#copyOf(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test copyOf(PhysicalFlowParsed); then dataType return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.copyOf(PhysicalFlowParsed)"
  })
  void testCopyOf_thenDataTypeReturnImmutableEntityReference() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder criticalityResult = basisOffsetResult.criticality(criticality);

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");
    DataFormatKindValue format = DataFormatKindValue.of("42");

    Builder formatResult = externalIdResult.format(format);
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder nameResult = formatResult.frequency(frequency).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    TransportKindValue transport = TransportKindValue.of("42");
    ImmutablePhysicalFlowParsed instance = targetResult.transport(transport).build();

    // Act
    ImmutablePhysicalFlowParsed actualCopyOfResult = ImmutablePhysicalFlowParsed.copyOf(instance);

    // Assert
    EntityReference dataTypeResult = actualCopyOfResult.dataType();
    assertTrue(dataTypeResult instanceof ImmutableEntityReference);
    EntityReference ownerResult2 = actualCopyOfResult.owner();
    assertTrue(ownerResult2 instanceof ImmutableEntityReference);
    EntityReference sourceResult = actualCopyOfResult.source();
    assertTrue(sourceResult instanceof ImmutableEntityReference);
    EntityReference targetResult2 = actualCopyOfResult.target();
    assertTrue(targetResult2 instanceof ImmutableEntityReference);
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.specExternalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Spec Description", actualCopyOfResult.specDescription());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.basisOffset().intValue());
    assertEquals(dataTypeResult, ownerResult2);
    assertEquals(dataTypeResult, sourceResult);
    assertEquals(dataTypeResult, targetResult2);
    assertSame(criticality, actualCopyOfResult.criticality());
    assertSame(frequency, actualCopyOfResult.frequency());
    assertSame(transport, actualCopyOfResult.transport());
    assertSame(format, actualCopyOfResult.format());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}, and {@link
   * ImmutablePhysicalFlowParsed#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowParsed#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowParsed#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed2 =
        targetResult2.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    assertEquals(immutablePhysicalFlowParsed, immutablePhysicalFlowParsed2);
    assertEquals(immutablePhysicalFlowParsed.hashCode(), immutablePhysicalFlowParsed2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}, and {@link
   * ImmutablePhysicalFlowParsed#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowParsed#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowParsed#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act and Assert
    assertEquals(immutablePhysicalFlowParsed, immutablePhysicalFlowParsed);
    int expectedHashCodeResult = immutablePhysicalFlowParsed.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalFlowParsed.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder criticalityResult =
        ImmutablePhysicalFlowParsed.builder().basisOffset(1).criticality(null);

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowParsed, targetResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder formatResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42")
            .format(null);

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowParsed, targetResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult =
        externalIdResult.format(DataFormatKindValue.of("42")).frequency(null).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowParsed, targetResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        specExternalIdResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .transport(null)
            .build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowParsed, targetResult.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(6);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowParsed, targetResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowParsed, targetResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("42")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowParsed, targetResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("Name");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowParsed, targetResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("42");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowParsed, targetResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowParsed, targetResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowParsed, targetResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("42")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowParsed, targetResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("Name");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowParsed, targetResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    Builder basisOffsetResult2 = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult2 = basisOffsetResult2.criticality(CriticalityValue.of("42"));

    Builder externalIdResult2 =
        criticalityResult2
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult2 = externalIdResult2.format(DataFormatKindValue.of("42"));

    Builder nameResult2 = formatResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult2 =
        nameResult2.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult2 =
        ownerResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult2 =
        specExternalIdResult2.target(
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
        immutablePhysicalFlowParsed, targetResult2.transport(TransportKindValue.of("42")).build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(targetResult.transport(TransportKindValue.of("42")).build(), null);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParsed.equals(Object)",
    "int ImmutablePhysicalFlowParsed.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
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
        targetResult.transport(TransportKindValue.of("42")).build(),
        "Different type to ImmutablePhysicalFlowParsed");
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link DataFormatKindValue} with value is {@code 42}.
   *   <li>Then return externalId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given DataFormatKindValue with value is '42'; then return externalId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.fromJson(Json)"})
  void testFromJson_givenDataFormatKindValueWithValueIs42_thenReturnExternalIdIsJson() {
    // Arrange
    Json json = new Json();
    json.setSource(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTarget(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setOwner(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    DataFormatKindValue format = DataFormatKindValue.of("42");
    json.setFormat(format);
    json.setName("Json");
    json.setSpecDescription("Json");
    json.setSpecExternalId("Json");
    json.setBasisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");
    json.setCriticality(criticality);
    json.setDescription("Json");
    json.setExternalId("Json");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");
    json.setFrequency(frequency);
    TransportKindValue transport = TransportKindValue.of("42");
    json.setTransport(transport);
    json.setDataType(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutablePhysicalFlowParsed actualFromJsonResult = ImmutablePhysicalFlowParsed.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.specDescription());
    assertEquals("Json", actualFromJsonResult.specExternalId());
    assertEquals(1, actualFromJsonResult.basisOffset().intValue());
    assertSame(criticality, actualFromJsonResult.criticality());
    assertSame(frequency, actualFromJsonResult.frequency());
    assertSame(transport, actualFromJsonResult.transport());
    assertSame(format, actualFromJsonResult.format());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Format is {@code null}.
   *   <li>Then return format is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Format is 'null'; then return format is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonFormatIsNull_thenReturnFormatIsNull() {
    // Arrange
    Json json = new Json();
    json.setSource(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTarget(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setOwner(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setFormat(null);
    json.setName("Json");
    json.setSpecDescription("Json");
    json.setSpecExternalId("Json");
    json.setBasisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");
    json.setCriticality(criticality);
    json.setDescription("Json");
    json.setExternalId("Json");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");
    json.setFrequency(frequency);
    TransportKindValue transport = TransportKindValue.of("42");
    json.setTransport(transport);
    json.setDataType(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutablePhysicalFlowParsed actualFromJsonResult = ImmutablePhysicalFlowParsed.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.specDescription());
    assertEquals("Json", actualFromJsonResult.specExternalId());
    assertNull(actualFromJsonResult.format());
    assertEquals(1, actualFromJsonResult.basisOffset().intValue());
    assertSame(criticality, actualFromJsonResult.criticality());
    assertSame(frequency, actualFromJsonResult.frequency());
    assertSame(transport, actualFromJsonResult.transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) BasisOffset is {@code null}.
   *   <li>Then return basisOffset is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) BasisOffset is 'null'; then return basisOffset is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.fromJson(Json)"})
  void testFromJson_whenJsonBasisOffsetIsNull_thenReturnBasisOffsetIsNull() {
    // Arrange
    Json json = new Json();
    json.setSource(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTarget(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setOwner(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    DataFormatKindValue format = DataFormatKindValue.of("42");
    json.setFormat(format);
    json.setName("Json");
    json.setSpecDescription("Json");
    json.setSpecExternalId("Json");
    json.setBasisOffset(null);
    CriticalityValue criticality = CriticalityValue.of("42");
    json.setCriticality(criticality);
    json.setDescription("Json");
    json.setExternalId("Json");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");
    json.setFrequency(frequency);
    TransportKindValue transport = TransportKindValue.of("42");
    json.setTransport(transport);
    json.setDataType(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutablePhysicalFlowParsed actualFromJsonResult = ImmutablePhysicalFlowParsed.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.specDescription());
    assertEquals("Json", actualFromJsonResult.specExternalId());
    assertNull(actualFromJsonResult.basisOffset());
    assertSame(criticality, actualFromJsonResult.criticality());
    assertSame(frequency, actualFromJsonResult.frequency());
    assertSame(transport, actualFromJsonResult.transport());
    assertSame(format, actualFromJsonResult.format());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Criticality is {@code null}.
   *   <li>Then return criticality is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Criticality is 'null'; then return criticality is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.fromJson(Json)"})
  void testFromJson_whenJsonCriticalityIsNull_thenReturnCriticalityIsNull() {
    // Arrange
    Json json = new Json();
    json.setSource(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTarget(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setOwner(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    DataFormatKindValue format = DataFormatKindValue.of("42");
    json.setFormat(format);
    json.setName("Json");
    json.setSpecDescription("Json");
    json.setSpecExternalId("Json");
    json.setBasisOffset(1);
    json.setCriticality(null);
    json.setDescription("Json");
    json.setExternalId("Json");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");
    json.setFrequency(frequency);
    TransportKindValue transport = TransportKindValue.of("42");
    json.setTransport(transport);
    json.setDataType(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutablePhysicalFlowParsed actualFromJsonResult = ImmutablePhysicalFlowParsed.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.specDescription());
    assertEquals("Json", actualFromJsonResult.specExternalId());
    assertNull(actualFromJsonResult.criticality());
    assertEquals(1, actualFromJsonResult.basisOffset().intValue());
    assertSame(frequency, actualFromJsonResult.frequency());
    assertSame(transport, actualFromJsonResult.transport());
    assertSame(format, actualFromJsonResult.format());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) DataType is {@code null}.
   *   <li>Then owner return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) DataType is 'null'; then owner return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.fromJson(Json)"})
  void testFromJson_whenJsonDataTypeIsNull_thenOwnerReturnImmutableEntityReference() {
    // Arrange
    Json json = new Json();
    json.setSource(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTarget(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setOwner(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setFormat(DataFormatKindValue.of("42"));
    json.setName("Json");
    json.setSpecDescription("Json");
    json.setSpecExternalId("Json");
    json.setBasisOffset(1);
    json.setCriticality(CriticalityValue.of("42"));
    json.setDescription("Json");
    json.setExternalId("Json");
    json.setFrequency(FrequencyKindValue.of("42"));
    json.setTransport(TransportKindValue.of("42"));
    json.setDataType(null);

    // Act
    ImmutablePhysicalFlowParsed actualFromJsonResult = ImmutablePhysicalFlowParsed.fromJson(json);

    // Assert
    EntityReference ownerResult = actualFromJsonResult.owner();
    assertTrue(ownerResult instanceof ImmutableEntityReference);
    assertTrue(actualFromJsonResult.source() instanceof ImmutableEntityReference);
    assertTrue(actualFromJsonResult.target() instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", ownerResult.description());
    assertNull(actualFromJsonResult.dataType());
    assertEquals(1L, ownerResult.id());
    assertEquals(EntityKind.ALL, ownerResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, ownerResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ExternalId is {@code null}.
   *   <li>Then return externalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ExternalId is 'null'; then return externalId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.fromJson(Json)"})
  void testFromJson_whenJsonExternalIdIsNull_thenReturnExternalIdIsNull() {
    // Arrange
    Json json = new Json();
    json.setSource(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTarget(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setOwner(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    DataFormatKindValue format = DataFormatKindValue.of("42");
    json.setFormat(format);
    json.setName("Json");
    json.setSpecDescription("Json");
    json.setSpecExternalId("Json");
    json.setBasisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");
    json.setCriticality(criticality);
    json.setDescription("Json");
    json.setExternalId(null);
    FrequencyKindValue frequency = FrequencyKindValue.of("42");
    json.setFrequency(frequency);
    TransportKindValue transport = TransportKindValue.of("42");
    json.setTransport(transport);
    json.setDataType(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutablePhysicalFlowParsed actualFromJsonResult = ImmutablePhysicalFlowParsed.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.specDescription());
    assertEquals("Json", actualFromJsonResult.specExternalId());
    assertNull(actualFromJsonResult.externalId());
    assertEquals(1, actualFromJsonResult.basisOffset().intValue());
    assertSame(criticality, actualFromJsonResult.criticality());
    assertSame(frequency, actualFromJsonResult.frequency());
    assertSame(transport, actualFromJsonResult.transport());
    assertSame(format, actualFromJsonResult.format());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Frequency is {@code null}.
   *   <li>Then return frequency is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Frequency is 'null'; then return frequency is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.fromJson(Json)"})
  void testFromJson_whenJsonFrequencyIsNull_thenReturnFrequencyIsNull() {
    // Arrange
    Json json = new Json();
    json.setSource(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTarget(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setOwner(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    DataFormatKindValue format = DataFormatKindValue.of("42");
    json.setFormat(format);
    json.setName("Json");
    json.setSpecDescription("Json");
    json.setSpecExternalId("Json");
    json.setBasisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");
    json.setCriticality(criticality);
    json.setDescription("Json");
    json.setExternalId("Json");
    json.setFrequency(null);
    TransportKindValue transport = TransportKindValue.of("42");
    json.setTransport(transport);
    json.setDataType(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutablePhysicalFlowParsed actualFromJsonResult = ImmutablePhysicalFlowParsed.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.specDescription());
    assertEquals("Json", actualFromJsonResult.specExternalId());
    assertNull(actualFromJsonResult.frequency());
    assertEquals(1, actualFromJsonResult.basisOffset().intValue());
    assertSame(criticality, actualFromJsonResult.criticality());
    assertSame(transport, actualFromJsonResult.transport());
    assertSame(format, actualFromJsonResult.format());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) SpecDescription is {@code null}.
   *   <li>Then return specDescription is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) SpecDescription is 'null'; then return specDescription is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.fromJson(Json)"})
  void testFromJson_whenJsonSpecDescriptionIsNull_thenReturnSpecDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setSource(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTarget(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setOwner(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    DataFormatKindValue format = DataFormatKindValue.of("42");
    json.setFormat(format);
    json.setName("Json");
    json.setSpecDescription(null);
    json.setSpecExternalId("Json");
    json.setBasisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");
    json.setCriticality(criticality);
    json.setDescription("Json");
    json.setExternalId("Json");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");
    json.setFrequency(frequency);
    TransportKindValue transport = TransportKindValue.of("42");
    json.setTransport(transport);
    json.setDataType(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutablePhysicalFlowParsed actualFromJsonResult = ImmutablePhysicalFlowParsed.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.specExternalId());
    assertNull(actualFromJsonResult.specDescription());
    assertEquals(1, actualFromJsonResult.basisOffset().intValue());
    assertSame(criticality, actualFromJsonResult.criticality());
    assertSame(frequency, actualFromJsonResult.frequency());
    assertSame(transport, actualFromJsonResult.transport());
    assertSame(format, actualFromJsonResult.format());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) SpecExternalId is {@code null}.
   *   <li>Then return specExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) SpecExternalId is 'null'; then return specExternalId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.fromJson(Json)"})
  void testFromJson_whenJsonSpecExternalIdIsNull_thenReturnSpecExternalIdIsNull() {
    // Arrange
    Json json = new Json();
    json.setSource(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTarget(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setOwner(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    DataFormatKindValue format = DataFormatKindValue.of("42");
    json.setFormat(format);
    json.setName("Json");
    json.setSpecDescription("Json");
    json.setSpecExternalId(null);
    json.setBasisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");
    json.setCriticality(criticality);
    json.setDescription("Json");
    json.setExternalId("Json");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");
    json.setFrequency(frequency);
    TransportKindValue transport = TransportKindValue.of("42");
    json.setTransport(transport);
    json.setDataType(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutablePhysicalFlowParsed actualFromJsonResult = ImmutablePhysicalFlowParsed.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.specDescription());
    assertNull(actualFromJsonResult.specExternalId());
    assertEquals(1, actualFromJsonResult.basisOffset().intValue());
    assertSame(criticality, actualFromJsonResult.criticality());
    assertSame(frequency, actualFromJsonResult.frequency());
    assertSame(transport, actualFromJsonResult.transport());
    assertSame(format, actualFromJsonResult.format());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Transport is {@code null}.
   *   <li>Then return transport is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Transport is 'null'; then return transport is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.fromJson(Json)"})
  void testFromJson_whenJsonTransportIsNull_thenReturnTransportIsNull() {
    // Arrange
    Json json = new Json();
    json.setSource(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTarget(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setOwner(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    DataFormatKindValue format = DataFormatKindValue.of("42");
    json.setFormat(format);
    json.setName("Json");
    json.setSpecDescription("Json");
    json.setSpecExternalId("Json");
    json.setBasisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");
    json.setCriticality(criticality);
    json.setDescription("Json");
    json.setExternalId("Json");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");
    json.setFrequency(frequency);
    json.setTransport(null);
    json.setDataType(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutablePhysicalFlowParsed actualFromJsonResult = ImmutablePhysicalFlowParsed.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.externalId());
    assertEquals("Json", actualFromJsonResult.specDescription());
    assertEquals("Json", actualFromJsonResult.specExternalId());
    assertNull(actualFromJsonResult.transport());
    assertEquals(1, actualFromJsonResult.basisOffset().intValue());
    assertSame(criticality, actualFromJsonResult.criticality());
    assertSame(frequency, actualFromJsonResult.frequency());
    assertSame(format, actualFromJsonResult.format());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowParsed#toString()}
   *   <li>{@link ImmutablePhysicalFlowParsed#basisOffset()}
   *   <li>{@link ImmutablePhysicalFlowParsed#criticality()}
   *   <li>{@link ImmutablePhysicalFlowParsed#dataType()}
   *   <li>{@link ImmutablePhysicalFlowParsed#description()}
   *   <li>{@link ImmutablePhysicalFlowParsed#externalId()}
   *   <li>{@link ImmutablePhysicalFlowParsed#format()}
   *   <li>{@link ImmutablePhysicalFlowParsed#frequency()}
   *   <li>{@link ImmutablePhysicalFlowParsed#name()}
   *   <li>{@link ImmutablePhysicalFlowParsed#owner()}
   *   <li>{@link ImmutablePhysicalFlowParsed#source()}
   *   <li>{@link ImmutablePhysicalFlowParsed#specDescription()}
   *   <li>{@link ImmutablePhysicalFlowParsed#specExternalId()}
   *   <li>{@link ImmutablePhysicalFlowParsed#target()}
   *   <li>{@link ImmutablePhysicalFlowParsed#transport()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer ImmutablePhysicalFlowParsed.basisOffset()",
    "CriticalityValue ImmutablePhysicalFlowParsed.criticality()",
    "EntityReference ImmutablePhysicalFlowParsed.dataType()",
    "String ImmutablePhysicalFlowParsed.description()",
    "String ImmutablePhysicalFlowParsed.externalId()",
    "DataFormatKindValue ImmutablePhysicalFlowParsed.format()",
    "FrequencyKindValue ImmutablePhysicalFlowParsed.frequency()",
    "String ImmutablePhysicalFlowParsed.name()",
    "EntityReference ImmutablePhysicalFlowParsed.owner()",
    "EntityReference ImmutablePhysicalFlowParsed.source()",
    "String ImmutablePhysicalFlowParsed.specDescription()",
    "String ImmutablePhysicalFlowParsed.specExternalId()",
    "EntityReference ImmutablePhysicalFlowParsed.target()",
    "String ImmutablePhysicalFlowParsed.toString()",
    "TransportKindValue ImmutablePhysicalFlowParsed.transport()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder criticalityResult = basisOffsetResult.criticality(criticality);

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");
    DataFormatKindValue format = DataFormatKindValue.of("42");

    Builder formatResult = externalIdResult.format(format);
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder nameResult = formatResult.frequency(frequency).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    TransportKindValue transport = TransportKindValue.of("42");
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(transport).build();

    // Act
    String actualToStringResult = immutablePhysicalFlowParsed.toString();
    Integer actualBasisOffsetResult = immutablePhysicalFlowParsed.basisOffset();
    CriticalityValue actualCriticalityResult = immutablePhysicalFlowParsed.criticality();
    EntityReference actualDataTypeResult = immutablePhysicalFlowParsed.dataType();
    String actualDescriptionResult = immutablePhysicalFlowParsed.description();
    String actualExternalIdResult = immutablePhysicalFlowParsed.externalId();
    DataFormatKindValue actualFormatResult = immutablePhysicalFlowParsed.format();
    FrequencyKindValue actualFrequencyResult = immutablePhysicalFlowParsed.frequency();
    String actualNameResult = immutablePhysicalFlowParsed.name();
    EntityReference actualOwnerResult = immutablePhysicalFlowParsed.owner();
    EntityReference actualSourceResult = immutablePhysicalFlowParsed.source();
    String actualSpecDescriptionResult = immutablePhysicalFlowParsed.specDescription();
    String actualSpecExternalIdResult = immutablePhysicalFlowParsed.specExternalId();
    EntityReference actualTargetResult = immutablePhysicalFlowParsed.target();
    TransportKindValue actualTransportResult = immutablePhysicalFlowParsed.transport();

    // Assert
    assertTrue(actualDataTypeResult instanceof ImmutableEntityReference);
    assertTrue(actualOwnerResult instanceof ImmutableEntityReference);
    assertTrue(actualSourceResult instanceof ImmutableEntityReference);
    assertTrue(actualTargetResult instanceof ImmutableEntityReference);
    assertEquals("42", actualCriticalityResult.value());
    assertEquals("42", actualFrequencyResult.value());
    assertEquals("42", actualExternalIdResult);
    assertEquals("42", actualSpecExternalIdResult);
    assertEquals("42", actualTransportResult.value());
    assertEquals("42", actualFormatResult.value());
    assertEquals("Name", actualNameResult);
    assertEquals(
        "PhysicalFlowParsed{source=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, target"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, owner=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, format=42, name=Name, specDescription=Spec Description, specExternalId=42,"
            + " basisOffset=1, criticality=42, description=The characteristics of someone or something, externalId=42,"
            + " frequency=42, transport=42, dataType=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}"
            + "}",
        actualToStringResult);
    assertEquals("Spec Description", actualSpecDescriptionResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1, actualBasisOffsetResult.intValue());
    assertEquals(actualDataTypeResult, actualOwnerResult);
    assertEquals(actualDataTypeResult, actualSourceResult);
    assertEquals(actualDataTypeResult, actualTargetResult);
    assertSame(criticality, actualCriticalityResult);
    assertSame(frequency, actualFrequencyResult);
    assertSame(transport, actualTransportResult);
    assertSame(format, actualFormatResult);
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
  @MethodsUnderTest({"Integer Json.basisOffset()"})
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
   * Test Json {@link Json#dataType()}.
   *
   * <p>Method under test: {@link Json#dataType()}
   */
  @Test
  @DisplayName("Test Json dataType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.dataType()"})
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
  @MethodsUnderTest({"DataFormatKindValue Json.format()"})
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
  @MethodsUnderTest({"FrequencyKindValue Json.frequency()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setBasisOffset(Integer)",
    "void Json.setCriticality(CriticalityValue)",
    "void Json.setDataType(EntityReference)",
    "void Json.setDescription(String)",
    "void Json.setExternalId(String)",
    "void Json.setFormat(DataFormatKindValue)",
    "void Json.setFrequency(FrequencyKindValue)",
    "void Json.setName(String)",
    "void Json.setOwner(EntityReference)",
    "void Json.setSource(EntityReference)",
    "void Json.setSpecDescription(String)",
    "void Json.setSpecExternalId(String)",
    "void Json.setTarget(EntityReference)",
    "void Json.setTransport(TransportKindValue)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setBasisOffset(1);
    actualJson.setCriticality(CriticalityValue.of("42"));
    actualJson.setDataType(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setExternalId("42");
    actualJson.setFormat(DataFormatKindValue.of("42"));
    actualJson.setFrequency(FrequencyKindValue.of("42"));
    actualJson.setName("Name");
    actualJson.setOwner(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setSource(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setSpecDescription("Spec Description");
    actualJson.setSpecExternalId("42");
    actualJson.setTarget(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
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
  @MethodsUnderTest({"EntityReference Json.owner()"})
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
  @MethodsUnderTest({"EntityReference Json.source()"})
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
  @MethodsUnderTest({"EntityReference Json.target()"})
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
  @MethodsUnderTest({"TransportKindValue Json.transport()"})
  void testJsonTransport() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().transport());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withBasisOffset(Integer)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withBasisOffset(Integer)}
   */
  @Test
  @DisplayName("Test withBasisOffset(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withBasisOffset(Integer)"
  })
  void testWithBasisOffset() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowParsed actualWithBasisOffsetResult =
        immutablePhysicalFlowParsed.withBasisOffset(1);

    // Assert
    assertSame(immutablePhysicalFlowParsed, actualWithBasisOffsetResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withBasisOffset(Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then owner return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withBasisOffset(Integer)}
   */
  @Test
  @DisplayName(
      "Test withBasisOffset(Integer); when forty-two; then owner return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withBasisOffset(Integer)"
  })
  void testWithBasisOffset_whenFortyTwo_thenOwnerReturnImmutableEntityReference() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutablePhysicalFlowParsed actualWithBasisOffsetResult =
        targetResult.transport(TransportKindValue.of("42")).build().withBasisOffset(42);

    // Assert
    assertTrue(actualWithBasisOffsetResult.owner() instanceof ImmutableEntityReference);
    assertTrue(actualWithBasisOffsetResult.source() instanceof ImmutableEntityReference);
    assertTrue(actualWithBasisOffsetResult.target() instanceof ImmutableEntityReference);
    assertEquals(42, actualWithBasisOffsetResult.basisOffset().intValue());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withCriticality(CriticalityValue)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withCriticality(CriticalityValue)}
   */
  @Test
  @DisplayName("Test withCriticality(CriticalityValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withCriticality(CriticalityValue)"
  })
  void testWithCriticality() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowParsed actualWithCriticalityResult =
        immutablePhysicalFlowParsed.withCriticality(CriticalityValue.of("42"));

    // Assert
    assertEquals(immutablePhysicalFlowParsed, actualWithCriticalityResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withDataType(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withDataType(EntityReference)}
   */
  @Test
  @DisplayName("Test withDataType(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withDataType(EntityReference)"
  })
  void testWithDataType() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowParsed actualWithDataTypeResult =
        immutablePhysicalFlowParsed.withDataType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePhysicalFlowParsed, actualWithDataTypeResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("42")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowParsed actualWithDescriptionResult =
        immutablePhysicalFlowParsed.withDescription("42");

    // Assert
    assertSame(immutablePhysicalFlowParsed, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withDescription(String)}.
   *
   * <ul>
   *   <li>Then dataType return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then dataType return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withDescription(String)"
  })
  void testWithDescription_thenDataTypeReturnImmutableEntityReference() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder criticalityResult = basisOffsetResult.criticality(criticality);

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");
    DataFormatKindValue format = DataFormatKindValue.of("42");

    Builder formatResult = externalIdResult.format(format);
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder nameResult = formatResult.frequency(frequency).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlowParsed actualWithDescriptionResult =
        targetResult.transport(transport).build().withDescription("42");

    // Assert
    EntityReference dataTypeResult = actualWithDescriptionResult.dataType();
    assertTrue(dataTypeResult instanceof ImmutableEntityReference);
    EntityReference ownerResult2 = actualWithDescriptionResult.owner();
    assertTrue(ownerResult2 instanceof ImmutableEntityReference);
    EntityReference sourceResult = actualWithDescriptionResult.source();
    assertTrue(sourceResult instanceof ImmutableEntityReference);
    EntityReference targetResult2 = actualWithDescriptionResult.target();
    assertTrue(targetResult2 instanceof ImmutableEntityReference);
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals("42", actualWithDescriptionResult.externalId());
    assertEquals("42", actualWithDescriptionResult.specExternalId());
    assertEquals("Name", actualWithDescriptionResult.name());
    assertEquals("Spec Description", actualWithDescriptionResult.specDescription());
    assertEquals(1, actualWithDescriptionResult.basisOffset().intValue());
    assertEquals(dataTypeResult, ownerResult2);
    assertEquals(dataTypeResult, sourceResult);
    assertEquals(dataTypeResult, targetResult2);
    assertSame(criticality, actualWithDescriptionResult.criticality());
    assertSame(frequency, actualWithDescriptionResult.frequency());
    assertSame(transport, actualWithDescriptionResult.transport());
    assertSame(format, actualWithDescriptionResult.format());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withExternalId(String)"
  })
  void testWithExternalId() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowParsed actualWithExternalIdResult =
        immutablePhysicalFlowParsed.withExternalId("42");

    // Assert
    assertSame(immutablePhysicalFlowParsed, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then owner return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String); when '0123456789ABCDEF'; then owner return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withExternalId(String)"
  })
  void testWithExternalId_when0123456789abcdef_thenOwnerReturnImmutableEntityReference() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutablePhysicalFlowParsed actualWithExternalIdResult =
        targetResult
            .transport(TransportKindValue.of("42"))
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertTrue(actualWithExternalIdResult.owner() instanceof ImmutableEntityReference);
    assertTrue(actualWithExternalIdResult.source() instanceof ImmutableEntityReference);
    assertTrue(actualWithExternalIdResult.target() instanceof ImmutableEntityReference);
    assertEquals("0123456789ABCDEF", actualWithExternalIdResult.externalId());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withFormat(DataFormatKindValue)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withFormat(DataFormatKindValue)}
   */
  @Test
  @DisplayName("Test withFormat(DataFormatKindValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withFormat(DataFormatKindValue)"
  })
  void testWithFormat() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowParsed actualWithFormatResult =
        immutablePhysicalFlowParsed.withFormat(DataFormatKindValue.of("42"));

    // Assert
    assertEquals(immutablePhysicalFlowParsed, actualWithFormatResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withFrequency(FrequencyKindValue)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withFrequency(FrequencyKindValue)}
   */
  @Test
  @DisplayName("Test withFrequency(FrequencyKindValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withFrequency(FrequencyKindValue)"
  })
  void testWithFrequency() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowParsed actualWithFrequencyResult =
        immutablePhysicalFlowParsed.withFrequency(FrequencyKindValue.of("42"));

    // Assert
    assertEquals(immutablePhysicalFlowParsed, actualWithFrequencyResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withName(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withName(String)"})
  void testWithName() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("42");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowParsed actualWithNameResult = immutablePhysicalFlowParsed.withName("42");

    // Assert
    assertSame(immutablePhysicalFlowParsed, actualWithNameResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withName(String)}.
   *
   * <ul>
   *   <li>Then dataType return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then dataType return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withName(String)"})
  void testWithName_thenDataTypeReturnImmutableEntityReference() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder criticalityResult = basisOffsetResult.criticality(criticality);

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");
    DataFormatKindValue format = DataFormatKindValue.of("42");

    Builder formatResult = externalIdResult.format(format);
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder nameResult = formatResult.frequency(frequency).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlowParsed actualWithNameResult =
        targetResult.transport(transport).build().withName("42");

    // Assert
    EntityReference dataTypeResult = actualWithNameResult.dataType();
    assertTrue(dataTypeResult instanceof ImmutableEntityReference);
    EntityReference ownerResult2 = actualWithNameResult.owner();
    assertTrue(ownerResult2 instanceof ImmutableEntityReference);
    EntityReference sourceResult = actualWithNameResult.source();
    assertTrue(sourceResult instanceof ImmutableEntityReference);
    EntityReference targetResult2 = actualWithNameResult.target();
    assertTrue(targetResult2 instanceof ImmutableEntityReference);
    assertEquals("42", actualWithNameResult.externalId());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("42", actualWithNameResult.specExternalId());
    assertEquals("Spec Description", actualWithNameResult.specDescription());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1, actualWithNameResult.basisOffset().intValue());
    assertEquals(dataTypeResult, ownerResult2);
    assertEquals(dataTypeResult, sourceResult);
    assertEquals(dataTypeResult, targetResult2);
    assertSame(criticality, actualWithNameResult.criticality());
    assertSame(frequency, actualWithNameResult.frequency());
    assertSame(transport, actualWithNameResult.transport());
    assertSame(format, actualWithNameResult.format());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withOwner(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withOwner(EntityReference)}
   */
  @Test
  @DisplayName("Test withOwner(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withOwner(EntityReference)"
  })
  void testWithOwner() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowParsed actualWithOwnerResult =
        immutablePhysicalFlowParsed.withOwner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePhysicalFlowParsed, actualWithOwnerResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withSource(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withSource(EntityReference)}
   */
  @Test
  @DisplayName("Test withSource(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withSource(EntityReference)"
  })
  void testWithSource() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowParsed actualWithSourceResult =
        immutablePhysicalFlowParsed.withSource(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePhysicalFlowParsed, actualWithSourceResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withSpecDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withSpecDescription(String)}
   */
  @Test
  @DisplayName("Test withSpecDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withSpecDescription(String)"
  })
  void testWithSpecDescription() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("42")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowParsed actualWithSpecDescriptionResult =
        immutablePhysicalFlowParsed.withSpecDescription("42");

    // Assert
    assertSame(immutablePhysicalFlowParsed, actualWithSpecDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withSpecDescription(String)}.
   *
   * <ul>
   *   <li>Then dataType return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withSpecDescription(String)}
   */
  @Test
  @DisplayName("Test withSpecDescription(String); then dataType return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withSpecDescription(String)"
  })
  void testWithSpecDescription_thenDataTypeReturnImmutableEntityReference() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder criticalityResult = basisOffsetResult.criticality(criticality);

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");
    DataFormatKindValue format = DataFormatKindValue.of("42");

    Builder formatResult = externalIdResult.format(format);
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder nameResult = formatResult.frequency(frequency).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlowParsed actualWithSpecDescriptionResult =
        targetResult.transport(transport).build().withSpecDescription("42");

    // Assert
    EntityReference dataTypeResult = actualWithSpecDescriptionResult.dataType();
    assertTrue(dataTypeResult instanceof ImmutableEntityReference);
    EntityReference ownerResult2 = actualWithSpecDescriptionResult.owner();
    assertTrue(ownerResult2 instanceof ImmutableEntityReference);
    EntityReference sourceResult = actualWithSpecDescriptionResult.source();
    assertTrue(sourceResult instanceof ImmutableEntityReference);
    EntityReference targetResult2 = actualWithSpecDescriptionResult.target();
    assertTrue(targetResult2 instanceof ImmutableEntityReference);
    assertEquals("42", actualWithSpecDescriptionResult.externalId());
    assertEquals("42", actualWithSpecDescriptionResult.specDescription());
    assertEquals("42", actualWithSpecDescriptionResult.specExternalId());
    assertEquals("Name", actualWithSpecDescriptionResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithSpecDescriptionResult.description());
    assertEquals(1, actualWithSpecDescriptionResult.basisOffset().intValue());
    assertEquals(dataTypeResult, ownerResult2);
    assertEquals(dataTypeResult, sourceResult);
    assertEquals(dataTypeResult, targetResult2);
    assertSame(criticality, actualWithSpecDescriptionResult.criticality());
    assertSame(frequency, actualWithSpecDescriptionResult.frequency());
    assertSame(transport, actualWithSpecDescriptionResult.transport());
    assertSame(format, actualWithSpecDescriptionResult.format());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withSpecExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withSpecExternalId(String)}
   */
  @Test
  @DisplayName("Test withSpecExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withSpecExternalId(String)"
  })
  void testWithSpecExternalId() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowParsed actualWithSpecExternalIdResult =
        immutablePhysicalFlowParsed.withSpecExternalId("42");

    // Assert
    assertSame(immutablePhysicalFlowParsed, actualWithSpecExternalIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withSpecExternalId(String)}.
   *
   * <ul>
   *   <li>Then dataType return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withSpecExternalId(String)}
   */
  @Test
  @DisplayName("Test withSpecExternalId(String); then dataType return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withSpecExternalId(String)"
  })
  void testWithSpecExternalId_thenDataTypeReturnImmutableEntityReference() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder criticalityResult = basisOffsetResult.criticality(criticality);

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");
    DataFormatKindValue format = DataFormatKindValue.of("42");

    Builder formatResult = externalIdResult.format(format);
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder nameResult = formatResult.frequency(frequency).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("Spec External Id");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    TransportKindValue transport = TransportKindValue.of("42");

    // Act
    ImmutablePhysicalFlowParsed actualWithSpecExternalIdResult =
        targetResult.transport(transport).build().withSpecExternalId("42");

    // Assert
    EntityReference dataTypeResult = actualWithSpecExternalIdResult.dataType();
    assertTrue(dataTypeResult instanceof ImmutableEntityReference);
    EntityReference ownerResult2 = actualWithSpecExternalIdResult.owner();
    assertTrue(ownerResult2 instanceof ImmutableEntityReference);
    EntityReference sourceResult = actualWithSpecExternalIdResult.source();
    assertTrue(sourceResult instanceof ImmutableEntityReference);
    EntityReference targetResult2 = actualWithSpecExternalIdResult.target();
    assertTrue(targetResult2 instanceof ImmutableEntityReference);
    assertEquals("42", actualWithSpecExternalIdResult.externalId());
    assertEquals("42", actualWithSpecExternalIdResult.specExternalId());
    assertEquals("Name", actualWithSpecExternalIdResult.name());
    assertEquals("Spec Description", actualWithSpecExternalIdResult.specDescription());
    assertEquals(
        "The characteristics of someone or something",
        actualWithSpecExternalIdResult.description());
    assertEquals(1, actualWithSpecExternalIdResult.basisOffset().intValue());
    assertEquals(dataTypeResult, ownerResult2);
    assertEquals(dataTypeResult, sourceResult);
    assertEquals(dataTypeResult, targetResult2);
    assertSame(criticality, actualWithSpecExternalIdResult.criticality());
    assertSame(frequency, actualWithSpecExternalIdResult.frequency());
    assertSame(transport, actualWithSpecExternalIdResult.transport());
    assertSame(format, actualWithSpecExternalIdResult.format());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withTarget(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withTarget(EntityReference)}
   */
  @Test
  @DisplayName("Test withTarget(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withTarget(EntityReference)"
  })
  void testWithTarget() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowParsed actualWithTargetResult =
        immutablePhysicalFlowParsed.withTarget(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePhysicalFlowParsed, actualWithTargetResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParsed#withTransport(TransportKindValue)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParsed#withTransport(TransportKindValue)}
   */
  @Test
  @DisplayName("Test withTransport(TransportKindValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParsed ImmutablePhysicalFlowParsed.withTransport(TransportKindValue)"
  })
  void testWithTransport() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    Builder criticalityResult = basisOffsetResult.criticality(CriticalityValue.of("42"));

    Builder externalIdResult =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder formatResult = externalIdResult.format(DataFormatKindValue.of("42"));

    Builder nameResult = formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutablePhysicalFlowParsed immutablePhysicalFlowParsed =
        targetResult.transport(TransportKindValue.of("42")).build();

    // Act
    ImmutablePhysicalFlowParsed actualWithTransportResult =
        immutablePhysicalFlowParsed.withTransport(TransportKindValue.of("42"));

    // Assert
    assertEquals(immutablePhysicalFlowParsed, actualWithTransportResult);
  }
}
