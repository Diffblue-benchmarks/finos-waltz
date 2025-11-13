package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowCreateCommand.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowCreateCommand.Json;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllDataTypeIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDataTypeIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllDataTypeIds(Iterable)"})
  void testBuilderAddAllDataTypeIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllDataTypeIdsResult = builderResult.addAllDataTypeIds(elements);

    // Assert
    assertSame(builderResult, actualAddAllDataTypeIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllDataTypeIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDataTypeIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllDataTypeIds(Iterable)"})
  void testBuilderAddAllDataTypeIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act
    Builder actualAddAllDataTypeIdsResult = builderResult.addAllDataTypeIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllDataTypeIdsResult);
  }

  /**
   * Test Builder {@link Builder#addDataTypeIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addDataTypeIds(long)}
   */
  @Test
  @DisplayName("Test Builder addDataTypeIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDataTypeIds(long)"})
  void testBuilderAddDataTypeIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act
    Builder actualAddDataTypeIdsResult = builderResult.addDataTypeIds(1L);

    // Assert
    assertSame(builderResult, actualAddDataTypeIdsResult);
  }

  /**
   * Test Builder {@link Builder#addDataTypeIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addDataTypeIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addDataTypeIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addDataTypeIds(long[])"})
  void testBuilderAddDataTypeIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act
    Builder actualAddDataTypeIdsResult = builderResult.addDataTypeIds(1L, -5L, 1L, -5L);

    // Assert
    assertSame(builderResult, actualAddDataTypeIdsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowCreateCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutablePhysicalFlowCreateCommand.builder();
    Builder actualAddDataTypeIdsResult =
        actualBuilderResult
            .addAllDataTypeIds(new ArrayList<>())
            .addDataTypeIds(1L)
            .addDataTypeIds(1L, -5L, 1L, -5L);
    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);
    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");
    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    ImmutableFlowAttributes flowAttributes =
        nameResult.transport(TransportKindValue.of("42")).build();
    Builder actualFlowAttributesResult = actualAddDataTypeIdsResult.flowAttributes(flowAttributes);
    Builder actualLogicalFlowIdResult = actualFlowAttributesResult.logicalFlowId(1L);
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");
    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalSpecification specification =
        nameResult2
            .owningEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .build();
    ImmutablePhysicalFlowCreateCommand actualImmutablePhysicalFlowCreateCommand =
        actualLogicalFlowIdResult.specification(specification).build();

    // Assert
    assertEquals(1L, actualImmutablePhysicalFlowCreateCommand.logicalFlowId());
    Set<Long> dataTypeIdsResult = actualImmutablePhysicalFlowCreateCommand.dataTypeIds();
    assertEquals(2, dataTypeIdsResult.size());
    assertTrue(dataTypeIdsResult.contains(-5L));
    assertTrue(dataTypeIdsResult.contains(1L));
    assertSame(flowAttributes, actualImmutablePhysicalFlowCreateCommand.flowAttributes());
    assertSame(specification, actualImmutablePhysicalFlowCreateCommand.specification());
  }

  /**
   * Test Builder {@link Builder#dataTypeIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder dataTypeIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dataTypeIds(Iterable)"})
  void testBuilderDataTypeIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualDataTypeIdsResult = builderResult.dataTypeIds(elements);

    // Assert
    assertSame(builderResult, actualDataTypeIdsResult);
  }

  /**
   * Test Builder {@link Builder#dataTypeIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder dataTypeIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dataTypeIds(Iterable)"})
  void testBuilderDataTypeIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act
    Builder actualDataTypeIdsResult = builderResult.dataTypeIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDataTypeIdsResult);
  }

  /**
   * Test Builder {@link Builder#flowAttributes(FlowAttributes)}.
   *
   * <ul>
   *   <li>When {@link ImmutableFlowAttributes.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#flowAttributes(FlowAttributes)}
   */
  @Test
  @DisplayName(
      "Test Builder flowAttributes(FlowAttributes); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flowAttributes(FlowAttributes)"})
  void testBuilderFlowAttributes_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act
    Builder actualFlowAttributesResult =
        builderResult.flowAttributes(new ImmutableFlowAttributes.Json());

    // Assert
    assertSame(builderResult, actualFlowAttributesResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowCreateCommand)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowCreateCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand instance =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowCreateCommand actualImmutablePhysicalFlowCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowCreateCommand)}.
   *
   * <ul>
   *   <li>Given minus two.
   *   <li>When builder addDataTypeIds minus two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(PhysicalFlowCreateCommand); given minus two; when builder addDataTypeIds minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowCreateCommand)"})
  void testBuilderFrom_givenMinusTwo_whenBuilderAddDataTypeIdsMinusTwo() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    Builder builderResult2 = ImmutablePhysicalFlowCreateCommand.builder();
    builderResult2.addDataTypeIds(-2L);

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand instance =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowCreateCommand actualImmutablePhysicalFlowCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#logicalFlowId(long)}.
   *
   * <p>Method under test: {@link Builder#logicalFlowId(long)}
   */
  @Test
  @DisplayName("Test Builder logicalFlowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.logicalFlowId(long)"})
  void testBuilderLogicalFlowId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act
    Builder actualLogicalFlowIdResult = builderResult.logicalFlowId(1L);

    // Assert
    assertSame(builderResult, actualLogicalFlowIdResult);
  }

  /**
   * Test Builder {@link Builder#specification(PhysicalSpecification)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#specification(PhysicalSpecification)}
   */
  @Test
  @DisplayName("Test Builder specification(PhysicalSpecification); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.specification(PhysicalSpecification)"})
  void testBuilderSpecification_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    Builder actualSpecificationResult =
        builderResult.specification(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    // Assert
    assertSame(builderResult, actualSpecificationResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommand#copyOf(PhysicalFlowCreateCommand)}.
   *
   * <ul>
   *   <li>Then specification owningEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowCreateCommand#copyOf(PhysicalFlowCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(PhysicalFlowCreateCommand); then specification owningEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommand ImmutablePhysicalFlowCreateCommand.copyOf(PhysicalFlowCreateCommand)"
  })
  void testCopyOf_thenSpecificationOwningEntityReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    ImmutableFlowAttributes.Builder nameResult = externalIdResult.frequency(frequency).name("Name");
    TransportKindValue transport = TransportKindValue.of("42");

    Builder logicalFlowIdResult =
        builderResult.flowAttributes(nameResult.transport(transport).build()).logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");
    DataFormatKindValue format = DataFormatKindValue.of("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(format)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand instance =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    ImmutablePhysicalFlowCreateCommand actualCopyOfResult =
        ImmutablePhysicalFlowCreateCommand.copyOf(instance);

    // Assert
    PhysicalSpecification specificationResult = actualCopyOfResult.specification();
    assertTrue(specificationResult.owningEntity() instanceof ImmutableEntityReference);
    FlowAttributes flowAttributesResult = actualCopyOfResult.flowAttributes();
    assertTrue(flowAttributesResult instanceof ImmutableFlowAttributes);
    assertTrue(specificationResult instanceof ImmutablePhysicalSpecification);
    assertEquals("2020-03-01", specificationResult.lastUpdatedBy());
    assertEquals("Name", specificationResult.name());
    assertEquals("Name", flowAttributesResult.name());
    assertEquals("Provenance", specificationResult.provenance());
    assertEquals("The characteristics of someone or something", flowAttributesResult.description());
    assertEquals("The characteristics of someone or something", specificationResult.description());
    assertEquals(1, flowAttributesResult.basisOffset());
    assertEquals(1L, actualCopyOfResult.logicalFlowId());
    assertEquals(EntityKind.ALL, specificationResult.kind());
    assertFalse(specificationResult.isReadOnly());
    assertFalse(specificationResult.isRemoved());
    assertTrue(actualCopyOfResult.dataTypeIds().isEmpty());
    assertSame(criticality, flowAttributesResult.criticality());
    assertSame(frequency, flowAttributesResult.frequency());
    assertSame(transport, flowAttributesResult.transport());
    assertSame(format, specificationResult.format());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommand#equals(Object)}, and {@link
   * ImmutablePhysicalFlowCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowCreateCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowCreateCommand.equals(Object)",
    "int ImmutablePhysicalFlowCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand immutablePhysicalFlowCreateCommand =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult3 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult2 =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult3 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult3 =
        externalIdResult3.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult2 =
        builderResult3
            .flowAttributes(nameResult3.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult2 = logicalFlowIdResult2.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult4 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult4 =
        builderResult4
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult4 =
        externalIdResult4
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand immutablePhysicalFlowCreateCommand2 =
        addAllDataTypeIdsResult2
            .specification(
                nameResult4
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutablePhysicalFlowCreateCommand, immutablePhysicalFlowCreateCommand2);
    assertEquals(
        immutablePhysicalFlowCreateCommand.hashCode(),
        immutablePhysicalFlowCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommand#equals(Object)}, and {@link
   * ImmutablePhysicalFlowCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowCreateCommand#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowCreateCommand.equals(Object)",
    "int ImmutablePhysicalFlowCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand immutablePhysicalFlowCreateCommand =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutablePhysicalFlowCreateCommand, immutablePhysicalFlowCreateCommand);
    int expectedHashCodeResult = immutablePhysicalFlowCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalFlowCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowCreateCommand.equals(Object)",
    "int ImmutablePhysicalFlowCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();
    builderResult.addDataTypeIds(1L);

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand immutablePhysicalFlowCreateCommand =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult3 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult2 =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult3 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult3 =
        externalIdResult3.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult2 =
        builderResult3
            .flowAttributes(nameResult3.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult2 = logicalFlowIdResult2.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult4 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult4 =
        builderResult4
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult4 =
        externalIdResult4
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowCreateCommand,
        addAllDataTypeIdsResult2
            .specification(
                nameResult4
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowCreateCommand.equals(Object)",
    "int ImmutablePhysicalFlowCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(6);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand immutablePhysicalFlowCreateCommand =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult3 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult2 =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult3 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult3 =
        externalIdResult3.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult2 =
        builderResult3
            .flowAttributes(nameResult3.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult2 = logicalFlowIdResult2.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult4 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult4 =
        builderResult4
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult4 =
        externalIdResult4
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowCreateCommand,
        addAllDataTypeIdsResult2
            .specification(
                nameResult4
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowCreateCommand.equals(Object)",
    "int ImmutablePhysicalFlowCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(2L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand immutablePhysicalFlowCreateCommand =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult3 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult2 =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult3 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult3 =
        externalIdResult3.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult2 =
        builderResult3
            .flowAttributes(nameResult3.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult2 = logicalFlowIdResult2.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult4 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult4 =
        builderResult4
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult4 =
        externalIdResult4
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowCreateCommand,
        addAllDataTypeIdsResult2
            .specification(
                nameResult4
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowCreateCommand.equals(Object)",
    "int ImmutablePhysicalFlowCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder().at(LocalDate.now().atStartOfDay()).by("By").build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand immutablePhysicalFlowCreateCommand =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult3 = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult2 =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult3 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult3 =
        externalIdResult3.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult2 =
        builderResult3
            .flowAttributes(nameResult3.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult2 = logicalFlowIdResult2.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult4 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult4 =
        builderResult4
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult4 =
        externalIdResult4
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowCreateCommand,
        addAllDataTypeIdsResult2
            .specification(
                nameResult4
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowCreateCommand.equals(Object)",
    "int ImmutablePhysicalFlowCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowCreateCommand.equals(Object)",
    "int ImmutablePhysicalFlowCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build(),
        "Different type to ImmutablePhysicalFlowCreateCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowCreateCommand#toString()}
   *   <li>{@link ImmutablePhysicalFlowCreateCommand#dataTypeIds()}
   *   <li>{@link ImmutablePhysicalFlowCreateCommand#flowAttributes()}
   *   <li>{@link ImmutablePhysicalFlowCreateCommand#logicalFlowId()}
   *   <li>{@link ImmutablePhysicalFlowCreateCommand#specification()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutablePhysicalFlowCreateCommand.dataTypeIds()",
    "FlowAttributes ImmutablePhysicalFlowCreateCommand.flowAttributes()",
    "long ImmutablePhysicalFlowCreateCommand.logicalFlowId()",
    "PhysicalSpecification ImmutablePhysicalFlowCreateCommand.specification()",
    "String ImmutablePhysicalFlowCreateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand immutablePhysicalFlowCreateCommand =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutablePhysicalFlowCreateCommand.toString();
    Set<Long> actualDataTypeIdsResult = immutablePhysicalFlowCreateCommand.dataTypeIds();
    FlowAttributes actualFlowAttributesResult = immutablePhysicalFlowCreateCommand.flowAttributes();
    long actualLogicalFlowIdResult = immutablePhysicalFlowCreateCommand.logicalFlowId();

    // Assert
    assertTrue(actualFlowAttributesResult instanceof ImmutableFlowAttributes);
    assertTrue(
        immutablePhysicalFlowCreateCommand.specification()
            instanceof ImmutablePhysicalSpecification);
    assertEquals(
        "PhysicalFlowCreateCommand{specification=PhysicalSpecification{id=1, isRemoved=false, created=UserTimestamp"
            + "{at=1970-01-01T00:00, by=By, atTimestamp=1970-01-01 00:00:00.0}, externalId=42, name=Name, provenance"
            + "=Provenance, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, isReadOnly=false, owningEntity"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, format=42, kind=ALL}, logicalFlowId=1,"
            + " flowAttributes=FlowAttributes{externalId=42, name=Name, transport=42, frequency=42, criticality=42,"
            + " basisOffset=1}, dataTypeIds=[]}",
        actualToStringResult);
    assertEquals(1L, actualLogicalFlowIdResult);
    assertTrue(actualDataTypeIdsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#dataTypeIds()}.
   *
   * <p>Method under test: {@link Json#dataTypeIds()}
   */
  @Test
  @DisplayName("Test Json dataTypeIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.dataTypeIds()"})
  void testJsonDataTypeIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dataTypeIds());
  }

  /**
   * Test Json {@link Json#flowAttributes()}.
   *
   * <p>Method under test: {@link Json#flowAttributes()}
   */
  @Test
  @DisplayName("Test Json flowAttributes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlowAttributes Json.flowAttributes()"})
  void testJsonFlowAttributes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().flowAttributes());
  }

  /**
   * Test Json {@link Json#logicalFlowId()}.
   *
   * <p>Method under test: {@link Json#logicalFlowId()}
   */
  @Test
  @DisplayName("Test Json logicalFlowId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.logicalFlowId()"})
  void testJsonLogicalFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().logicalFlowId());
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
    assertNull(actualJson.flowAttributes);
    assertNull(actualJson.specification);
    assertEquals(0L, actualJson.logicalFlowId);
    assertFalse(actualJson.dataTypeIdsIsSet);
    assertFalse(actualJson.logicalFlowIdIsSet);
    assertTrue(actualJson.dataTypeIds.isEmpty());
  }

  /**
   * Test Json {@link Json#setDataTypeIds(Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   *   <li>Then {@link Json} (default constructor) {@link Json#dataTypeIds} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Json#setDataTypeIds(Set)}
   */
  @Test
  @DisplayName(
      "Test Json setDataTypeIds(Set); given one; when HashSet() add one; then Json (default constructor) dataTypeIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setDataTypeIds(Set)"})
  void testJsonSetDataTypeIds_givenOne_whenHashSetAddOne_thenJsonDataTypeIdsSizeIsOne() {
    // Arrange
    Json json = new Json();

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(1L);

    // Act
    json.setDataTypeIds(dataTypeIds);

    // Assert
    Set<Long> resultLongSet = json.dataTypeIds;
    assertEquals(1, resultLongSet.size());
    assertTrue(resultLongSet.contains(1L));
    assertTrue(json.dataTypeIdsIsSet);
  }

  /**
   * Test Json {@link Json#setDataTypeIds(Set)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   *   <li>Then {@link Json} (default constructor) {@link Json#dataTypeIds} size is two.
   * </ul>
   *
   * <p>Method under test: {@link Json#setDataTypeIds(Set)}
   */
  @Test
  @DisplayName(
      "Test Json setDataTypeIds(Set); given zero; when HashSet() add zero; then Json (default constructor) dataTypeIds size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setDataTypeIds(Set)"})
  void testJsonSetDataTypeIds_givenZero_whenHashSetAddZero_thenJsonDataTypeIdsSizeIsTwo() {
    // Arrange
    Json json = new Json();

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(0L);
    dataTypeIds.add(1L);

    // Act
    json.setDataTypeIds(dataTypeIds);

    // Assert
    Set<Long> resultLongSet = json.dataTypeIds;
    assertEquals(2, resultLongSet.size());
    assertTrue(resultLongSet.contains(0L));
    assertTrue(resultLongSet.contains(1L));
    assertTrue(json.dataTypeIdsIsSet);
  }

  /**
   * Test Json {@link Json#setDataTypeIds(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then {@link Json} (default constructor) {@link Json#dataTypeIds} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Json#setDataTypeIds(Set)}
   */
  @Test
  @DisplayName(
      "Test Json setDataTypeIds(Set); when HashSet(); then Json (default constructor) dataTypeIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setDataTypeIds(Set)"})
  void testJsonSetDataTypeIds_whenHashSet_thenJsonDataTypeIdsEmpty() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDataTypeIds(new HashSet<>());

    // Assert
    assertTrue(json.dataTypeIds.isEmpty());
    assertTrue(json.dataTypeIdsIsSet);
  }

  /**
   * Test Json {@link Json#setDataTypeIds(Set)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link Json} (default constructor) {@link Json#dataTypeIds} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Json#setDataTypeIds(Set)}
   */
  @Test
  @DisplayName(
      "Test Json setDataTypeIds(Set); when 'null'; then Json (default constructor) dataTypeIds is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setDataTypeIds(Set)"})
  void testJsonSetDataTypeIds_whenNull_thenJsonDataTypeIdsIsNull() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDataTypeIds(null);

    // Assert
    assertNull(json.dataTypeIds);
    assertFalse(json.dataTypeIdsIsSet);
  }

  /**
   * Test Json {@link Json#setLogicalFlowId(long)}.
   *
   * <p>Method under test: {@link Json#setLogicalFlowId(long)}
   */
  @Test
  @DisplayName("Test Json setLogicalFlowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setLogicalFlowId(long)"})
  void testJsonSetLogicalFlowId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setLogicalFlowId(1L);

    // Assert
    assertEquals(1L, json.logicalFlowId);
    assertTrue(json.logicalFlowIdIsSet);
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
  @MethodsUnderTest({"PhysicalSpecification Json.specification()"})
  void testJsonSpecification() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().specification());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommand#withDataTypeIds(Iterable)} with {@code
   * Iterable}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommand#withDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test withDataTypeIds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommand ImmutablePhysicalFlowCreateCommand.withDataTypeIds(Iterable)"
  })
  void testWithDataTypeIdsWithIterable() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    ImmutableFlowAttributes.Builder nameResult = externalIdResult.frequency(frequency).name("Name");
    TransportKindValue transport = TransportKindValue.of("42");

    Builder logicalFlowIdResult =
        builderResult.flowAttributes(nameResult.transport(transport).build()).logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");
    DataFormatKindValue format = DataFormatKindValue.of("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(format)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand immutablePhysicalFlowCreateCommand =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutablePhysicalFlowCreateCommand actualWithDataTypeIdsResult =
        immutablePhysicalFlowCreateCommand.withDataTypeIds(elements);

    // Assert
    PhysicalSpecification specificationResult = actualWithDataTypeIdsResult.specification();
    assertTrue(specificationResult.owningEntity() instanceof ImmutableEntityReference);
    FlowAttributes flowAttributesResult = actualWithDataTypeIdsResult.flowAttributes();
    assertTrue(flowAttributesResult instanceof ImmutableFlowAttributes);
    assertTrue(specificationResult instanceof ImmutablePhysicalSpecification);
    assertEquals("2020-03-01", specificationResult.lastUpdatedBy());
    assertEquals("Name", specificationResult.name());
    assertEquals("Name", flowAttributesResult.name());
    assertEquals("Provenance", specificationResult.provenance());
    assertEquals("The characteristics of someone or something", flowAttributesResult.description());
    assertEquals("The characteristics of someone or something", specificationResult.description());
    assertEquals(1, flowAttributesResult.basisOffset());
    assertEquals(1L, actualWithDataTypeIdsResult.logicalFlowId());
    assertEquals(EntityKind.ALL, specificationResult.kind());
    assertFalse(specificationResult.isReadOnly());
    assertFalse(specificationResult.isRemoved());
    assertEquals(elements, actualWithDataTypeIdsResult.dataTypeIds());
    assertSame(criticality, flowAttributesResult.criticality());
    assertSame(frequency, flowAttributesResult.frequency());
    assertSame(transport, flowAttributesResult.transport());
    assertSame(format, specificationResult.format());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommand#withDataTypeIds(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommand#withDataTypeIds(long[])}
   */
  @Test
  @DisplayName("Test withDataTypeIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommand ImmutablePhysicalFlowCreateCommand.withDataTypeIds(long[])"
  })
  void testWithDataTypeIdsWithLong() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    ImmutablePhysicalFlowCreateCommand actualWithDataTypeIdsResult =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build()
            .withDataTypeIds(1L, -1L, 1L, -1L);

    // Assert
    assertTrue(actualWithDataTypeIdsResult.flowAttributes() instanceof ImmutableFlowAttributes);
    assertTrue(
        actualWithDataTypeIdsResult.specification() instanceof ImmutablePhysicalSpecification);
    assertEquals(1L, actualWithDataTypeIdsResult.logicalFlowId());
    assertEquals(2, actualWithDataTypeIdsResult.dataTypeIds().size());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommand#withFlowAttributes(FlowAttributes)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowCreateCommand#withFlowAttributes(FlowAttributes)}
   */
  @Test
  @DisplayName("Test withFlowAttributes(FlowAttributes)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommand ImmutablePhysicalFlowCreateCommand.withFlowAttributes(FlowAttributes)"
  })
  void testWithFlowAttributes() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand immutablePhysicalFlowCreateCommand =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    ImmutableFlowAttributes.Builder basisOffsetResult2 =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult3 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult3 =
        externalIdResult3.frequency(FrequencyKindValue.of("42")).name("Name");

    // Act
    ImmutablePhysicalFlowCreateCommand actualWithFlowAttributesResult =
        immutablePhysicalFlowCreateCommand.withFlowAttributes(
            nameResult3.transport(TransportKindValue.of("42")).build());

    // Assert
    assertEquals(immutablePhysicalFlowCreateCommand, actualWithFlowAttributesResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommand#withLogicalFlowId(long)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommand#withLogicalFlowId(long)}
   */
  @Test
  @DisplayName("Test withLogicalFlowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommand ImmutablePhysicalFlowCreateCommand.withLogicalFlowId(long)"
  })
  void testWithLogicalFlowId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);
    CriticalityValue criticality = CriticalityValue.of("42");

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    ImmutableFlowAttributes.Builder nameResult = externalIdResult.frequency(frequency).name("Name");
    TransportKindValue transport = TransportKindValue.of("42");

    Builder logicalFlowIdResult =
        builderResult.flowAttributes(nameResult.transport(transport).build()).logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");
    DataFormatKindValue format = DataFormatKindValue.of("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(format)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    ImmutablePhysicalFlowCreateCommand actualWithLogicalFlowIdResult =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build()
            .withLogicalFlowId(42L);

    // Assert
    PhysicalSpecification specificationResult = actualWithLogicalFlowIdResult.specification();
    assertTrue(specificationResult.owningEntity() instanceof ImmutableEntityReference);
    FlowAttributes flowAttributesResult = actualWithLogicalFlowIdResult.flowAttributes();
    assertTrue(flowAttributesResult instanceof ImmutableFlowAttributes);
    assertTrue(specificationResult instanceof ImmutablePhysicalSpecification);
    assertEquals("2020-03-01", specificationResult.lastUpdatedBy());
    assertEquals("Name", specificationResult.name());
    assertEquals("Name", flowAttributesResult.name());
    assertEquals("Provenance", specificationResult.provenance());
    assertEquals("The characteristics of someone or something", flowAttributesResult.description());
    assertEquals("The characteristics of someone or something", specificationResult.description());
    assertEquals(1, flowAttributesResult.basisOffset());
    assertEquals(EntityKind.ALL, specificationResult.kind());
    assertFalse(specificationResult.isReadOnly());
    assertFalse(specificationResult.isRemoved());
    assertSame(criticality, flowAttributesResult.criticality());
    assertSame(frequency, flowAttributesResult.frequency());
    assertSame(transport, flowAttributesResult.transport());
    assertSame(format, specificationResult.format());
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommand#withLogicalFlowId(long)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowCreateCommand#withLogicalFlowId(long)}
   */
  @Test
  @DisplayName("Test withLogicalFlowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommand ImmutablePhysicalFlowCreateCommand.withLogicalFlowId(long)"
  })
  void testWithLogicalFlowId2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(42L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand immutablePhysicalFlowCreateCommand =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    ImmutablePhysicalFlowCreateCommand actualWithLogicalFlowIdResult =
        immutablePhysicalFlowCreateCommand.withLogicalFlowId(42L);

    // Assert
    assertSame(immutablePhysicalFlowCreateCommand, actualWithLogicalFlowIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowCreateCommand#withSpecification(PhysicalSpecification)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalFlowCreateCommand#withSpecification(PhysicalSpecification)}
   */
  @Test
  @DisplayName("Test withSpecification(PhysicalSpecification)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowCreateCommand ImmutablePhysicalFlowCreateCommand.withSpecification(PhysicalSpecification)"
  })
  void testWithSpecification() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    Builder addAllDataTypeIdsResult = logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand immutablePhysicalFlowCreateCommand =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult3 =
        builderResult3
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult3 =
        externalIdResult3
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    ImmutablePhysicalFlowCreateCommand actualWithSpecificationResult =
        immutablePhysicalFlowCreateCommand.withSpecification(
            nameResult3
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(immutablePhysicalFlowCreateCommand, actualWithSpecificationResult);
  }
}
