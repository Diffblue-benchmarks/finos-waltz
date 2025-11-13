package org.finos.waltz.model.data_type_usage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.data_type_usage.ImmutableDataTypeUsage.Builder;
import org.finos.waltz.model.data_type_usage.ImmutableDataTypeUsage.Json;
import org.finos.waltz.model.usage_info.ImmutableUsageInfo;
import org.finos.waltz.model.usage_info.UsageInfo;
import org.finos.waltz.model.usage_info.UsageKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeUsageDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeUsage Builder.build()",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualProvenanceResult =
        actualDataTypeIdResult.entityReference(entityReference).provenance("Provenance");
    ImmutableUsageInfo usage =
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build();
    ImmutableDataTypeUsage actualImmutableDataTypeUsage =
        actualProvenanceResult.usage(usage).build();

    // Assert
    assertEquals("Provenance", actualImmutableDataTypeUsage.provenance());
    assertEquals(1L, actualImmutableDataTypeUsage.dataTypeId().longValue());
    assertSame(entityReference, actualImmutableDataTypeUsage.entityReference());
    assertSame(usage, actualImmutableDataTypeUsage.usage());
  }

  /**
   * Test Builder {@link Builder#dataTypeId(Long)}.
   *
   * <p>Method under test: {@link Builder#dataTypeId(Long)}
   */
  @Test
  @DisplayName("Test Builder dataTypeId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dataTypeId(Long)"})
  void testBuilderDataTypeId() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsage.builder();

    // Act
    Builder actualDataTypeIdResult = builderResult.dataTypeId(1L);

    // Assert
    assertSame(builderResult, actualDataTypeIdResult);
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsage.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeUsage)} with {@code DataTypeUsage}.
   *
   * <p>Method under test: {@link Builder#from(DataTypeUsage)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeUsage) with 'DataTypeUsage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataTypeUsage)"})
  void testBuilderFromWithDataTypeUsage() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsage.builder();

    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    ImmutableDataTypeUsage instance =
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDataTypeUsage actualImmutableDataTypeUsage = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeUsage);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsage.builder();

    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    ImmutableDataTypeUsage instance =
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build();

    // Act and Assert
    ImmutableDataTypeUsage actualImmutableDataTypeUsage =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableDataTypeUsage);
    ImmutableDataTypeUsage actualImmutableDataTypeUsage2 = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeUsage2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsage.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#usage(UsageInfo)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#usage(UsageInfo)}
   */
  @Test
  @DisplayName("Test Builder usage(UsageInfo); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.usage(UsageInfo)"})
  void testBuilderUsage_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsage.builder();

    // Act
    Builder actualUsageResult =
        builderResult.usage(
            ImmutableUsageInfo.builder()
                .description("The characteristics of someone or something")
                .isSelected(true)
                .kind(UsageKind.CONSUMER)
                .build());

    // Assert
    assertSame(builderResult, actualUsageResult);
  }

  /**
   * Test {@link ImmutableDataTypeUsage#copyOf(DataTypeUsage)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsage#copyOf(DataTypeUsage)}
   */
  @Test
  @DisplayName("Test copyOf(DataTypeUsage); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeUsage ImmutableDataTypeUsage.copyOf(DataTypeUsage)"})
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    ImmutableDataTypeUsage instance =
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build();

    // Act
    ImmutableDataTypeUsage actualCopyOfResult = ImmutableDataTypeUsage.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    UsageInfo usageResult = actualCopyOfResult.usage();
    assertTrue(usageResult instanceof ImmutableUsageInfo);
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("The characteristics of someone or something", usageResult.description());
    assertEquals(1L, actualCopyOfResult.dataTypeId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(UsageKind.CONSUMER, usageResult.kind());
    assertTrue(usageResult.isSelected());
  }

  /**
   * Test {@link ImmutableDataTypeUsage#equals(Object)}, and {@link
   * ImmutableDataTypeUsage#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeUsage#equals(Object)}
   *   <li>{@link ImmutableDataTypeUsage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeUsage.equals(Object)",
    "int ImmutableDataTypeUsage.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    ImmutableDataTypeUsage immutableDataTypeUsage =
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build();

    Builder dataTypeIdResult2 = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult2 =
        dataTypeIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    ImmutableDataTypeUsage immutableDataTypeUsage2 =
        provenanceResult2
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableDataTypeUsage, immutableDataTypeUsage2);
    assertEquals(immutableDataTypeUsage.hashCode(), immutableDataTypeUsage2.hashCode());
  }

  /**
   * Test {@link ImmutableDataTypeUsage#equals(Object)}, and {@link
   * ImmutableDataTypeUsage#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeUsage#equals(Object)}
   *   <li>{@link ImmutableDataTypeUsage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeUsage.equals(Object)",
    "int ImmutableDataTypeUsage.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    ImmutableDataTypeUsage immutableDataTypeUsage =
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableDataTypeUsage, immutableDataTypeUsage);
    int expectedHashCodeResult = immutableDataTypeUsage.hashCode();
    assertEquals(expectedHashCodeResult, immutableDataTypeUsage.hashCode());
  }

  /**
   * Test {@link ImmutableDataTypeUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeUsage.equals(Object)",
    "int ImmutableDataTypeUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(2L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    ImmutableDataTypeUsage immutableDataTypeUsage =
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build();

    Builder dataTypeIdResult2 = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult2 =
        dataTypeIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableDataTypeUsage,
        provenanceResult2
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeUsage.equals(Object)",
    "int ImmutableDataTypeUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    ImmutableDataTypeUsage immutableDataTypeUsage =
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build();

    Builder dataTypeIdResult2 = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult2 =
        dataTypeIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableDataTypeUsage,
        provenanceResult2
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeUsage.equals(Object)",
    "int ImmutableDataTypeUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("The characteristics of someone or something");
    ImmutableDataTypeUsage immutableDataTypeUsage =
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build();

    Builder dataTypeIdResult2 = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult2 =
        dataTypeIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableDataTypeUsage,
        provenanceResult2
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeUsage.equals(Object)",
    "int ImmutableDataTypeUsage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    ImmutableDataTypeUsage immutableDataTypeUsage =
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("Provenance")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build();

    Builder dataTypeIdResult2 = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult2 =
        dataTypeIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        immutableDataTypeUsage,
        provenanceResult2
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeUsage.equals(Object)",
    "int ImmutableDataTypeUsage.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableDataTypeUsage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeUsage.equals(Object)",
    "int ImmutableDataTypeUsage.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");

    // Act and Assert
    assertNotEquals(
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build(),
        "Different type to ImmutableDataTypeUsage");
  }

  /**
   * Test {@link ImmutableDataTypeUsage#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return provenance is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsage#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return provenance is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeUsage ImmutableDataTypeUsage.fromJson(Json)"})
  void testFromJson_thenReturnProvenanceIsJson() {
    // Arrange
    Json json = new Json();
    json.setProvenance("Json");
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setDataTypeId(1L);
    json.setUsage(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act
    ImmutableDataTypeUsage actualFromJsonResult = ImmutableDataTypeUsage.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.provenance());
    assertEquals(1L, actualFromJsonResult.dataTypeId().longValue());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    UsageInfo expectedUsageResult = json.usage;
    assertSame(expectedUsageResult, actualFromJsonResult.usage());
  }

  /**
   * Test {@link ImmutableDataTypeUsage#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Provenance is {@code null}.
   *   <li>Then return provenance is {@code waltz}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsage#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Provenance is 'null'; then return provenance is 'waltz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeUsage ImmutableDataTypeUsage.fromJson(Json)"})
  void testFromJson_whenJsonProvenanceIsNull_thenReturnProvenanceIsWaltz() {
    // Arrange
    Json json = new Json();
    json.setProvenance(null);
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setDataTypeId(1L);
    json.setUsage(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act
    ImmutableDataTypeUsage actualFromJsonResult = ImmutableDataTypeUsage.fromJson(json);

    // Assert
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertEquals(1L, actualFromJsonResult.dataTypeId().longValue());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
    UsageInfo expectedUsageResult = json.usage;
    assertSame(expectedUsageResult, actualFromJsonResult.usage());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeUsage#toString()}
   *   <li>{@link ImmutableDataTypeUsage#dataTypeId()}
   *   <li>{@link ImmutableDataTypeUsage#entityReference()}
   *   <li>{@link ImmutableDataTypeUsage#provenance()}
   *   <li>{@link ImmutableDataTypeUsage#usage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableDataTypeUsage.dataTypeId()",
    "EntityReference ImmutableDataTypeUsage.entityReference()",
    "String ImmutableDataTypeUsage.provenance()",
    "String ImmutableDataTypeUsage.toString()",
    "UsageInfo ImmutableDataTypeUsage.usage()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    ImmutableDataTypeUsage immutableDataTypeUsage =
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableDataTypeUsage.toString();
    Long actualDataTypeIdResult = immutableDataTypeUsage.dataTypeId();
    EntityReference actualEntityReferenceResult = immutableDataTypeUsage.entityReference();
    String actualProvenanceResult = immutableDataTypeUsage.provenance();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(immutableDataTypeUsage.usage() instanceof ImmutableUsageInfo);
    assertEquals(
        "DataTypeUsage{provenance=Provenance, entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, dataTypeId=1, usage=UsageInfo{kind=CONSUMER, isSelected=true, description=The characteristics"
            + " of someone or something}}",
        actualToStringResult);
    assertEquals("Provenance", actualProvenanceResult);
    assertEquals(1L, actualDataTypeIdResult.longValue());
  }

  /**
   * Test Json {@link Json#dataTypeId()}.
   *
   * <p>Method under test: {@link Json#dataTypeId()}
   */
  @Test
  @DisplayName("Test Json dataTypeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.dataTypeId()"})
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dataTypeId());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   *
   * <p>Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityReference());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDataTypeId(Long)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setProvenance(String)}
   *   <li>{@link Json#setUsage(UsageInfo)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDataTypeId(Long)",
    "void Json.setEntityReference(EntityReference)",
    "void Json.setProvenance(String)",
    "void Json.setUsage(UsageInfo)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDataTypeId(1L);
    actualJson.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setProvenance("Provenance");
    actualJson.setUsage(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Assert
    assertEquals(1L, actualJson.dataTypeId.longValue());
  }

  /**
   * Test Json {@link Json#provenance()}.
   *
   * <p>Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().provenance());
  }

  /**
   * Test Json {@link Json#usage()}.
   *
   * <p>Method under test: {@link Json#usage()}
   */
  @Test
  @DisplayName("Test Json usage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UsageInfo Json.usage()"})
  void testJsonUsage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().usage());
  }

  /**
   * Test {@link ImmutableDataTypeUsage#withDataTypeId(Long)}.
   *
   * <p>Method under test: {@link ImmutableDataTypeUsage#withDataTypeId(Long)}
   */
  @Test
  @DisplayName("Test withDataTypeId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeUsage ImmutableDataTypeUsage.withDataTypeId(Long)"})
  void testWithDataTypeId() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    ImmutableDataTypeUsage immutableDataTypeUsage =
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build();

    // Act
    ImmutableDataTypeUsage actualWithDataTypeIdResult = immutableDataTypeUsage.withDataTypeId(1L);

    // Assert
    assertSame(immutableDataTypeUsage, actualWithDataTypeIdResult);
  }

  /**
   * Test {@link ImmutableDataTypeUsage#withDataTypeId(Long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsage#withDataTypeId(Long)}
   */
  @Test
  @DisplayName("Test withDataTypeId(Long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeUsage ImmutableDataTypeUsage.withDataTypeId(Long)"})
  void testWithDataTypeId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");

    // Act
    ImmutableDataTypeUsage actualWithDataTypeIdResult =
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build()
            .withDataTypeId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithDataTypeIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    UsageInfo usageResult = actualWithDataTypeIdResult.usage();
    assertTrue(usageResult instanceof ImmutableUsageInfo);
    assertEquals("Provenance", actualWithDataTypeIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("The characteristics of someone or something", usageResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(42L, actualWithDataTypeIdResult.dataTypeId().longValue());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(UsageKind.CONSUMER, usageResult.kind());
    assertTrue(usageResult.isSelected());
  }

  /**
   * Test {@link ImmutableDataTypeUsage#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableDataTypeUsage#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeUsage ImmutableDataTypeUsage.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    ImmutableDataTypeUsage immutableDataTypeUsage =
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build();

    // Act
    ImmutableDataTypeUsage actualWithEntityReferenceResult =
        immutableDataTypeUsage.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableDataTypeUsage, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableDataTypeUsage#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableDataTypeUsage#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeUsage ImmutableDataTypeUsage.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("42");
    ImmutableDataTypeUsage immutableDataTypeUsage =
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build();

    // Act
    ImmutableDataTypeUsage actualWithProvenanceResult = immutableDataTypeUsage.withProvenance("42");

    // Assert
    assertSame(immutableDataTypeUsage, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableDataTypeUsage#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsage#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeUsage ImmutableDataTypeUsage.withProvenance(String)"})
  void testWithProvenance_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");

    // Act
    ImmutableDataTypeUsage actualWithProvenanceResult =
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build()
            .withProvenance("42");

    // Assert
    EntityReference entityReferenceResult = actualWithProvenanceResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    UsageInfo usageResult = actualWithProvenanceResult.usage();
    assertTrue(usageResult instanceof ImmutableUsageInfo);
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("The characteristics of someone or something", usageResult.description());
    assertEquals(1L, actualWithProvenanceResult.dataTypeId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(UsageKind.CONSUMER, usageResult.kind());
    assertTrue(usageResult.isSelected());
  }

  /**
   * Test {@link ImmutableDataTypeUsage#withUsage(UsageInfo)}.
   *
   * <p>Method under test: {@link ImmutableDataTypeUsage#withUsage(UsageInfo)}
   */
  @Test
  @DisplayName("Test withUsage(UsageInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeUsage ImmutableDataTypeUsage.withUsage(UsageInfo)"})
  void testWithUsage() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDataTypeUsage.builder().dataTypeId(1L);

    Builder provenanceResult =
        dataTypeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance");
    ImmutableDataTypeUsage immutableDataTypeUsage =
        provenanceResult
            .usage(
                ImmutableUsageInfo.builder()
                    .description("The characteristics of someone or something")
                    .isSelected(true)
                    .kind(UsageKind.CONSUMER)
                    .build())
            .build();

    // Act
    ImmutableDataTypeUsage actualWithUsageResult =
        immutableDataTypeUsage.withUsage(
            ImmutableUsageInfo.builder()
                .description("The characteristics of someone or something")
                .isSelected(true)
                .kind(UsageKind.CONSUMER)
                .build());

    // Assert
    assertEquals(immutableDataTypeUsage, actualWithUsageResult);
  }
}
