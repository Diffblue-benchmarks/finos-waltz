package org.finos.waltz.service.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.service.flow_classification_rule.FlowClassificationRuleUtilities.BucketKey;
import org.finos.waltz.service.flow_classification_rule.ImmutableBucketKey.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBucketKeyDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#dataTypeId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBucketKey Builder.build()", "Builder Builder.dataTypeId(Long)"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);
    ImmutableEntityReference vantagePoint =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableBucketKey actualImmutableBucketKey =
        actualDataTypeRankResult.vantagePoint(vantagePoint).vantagePointRank(1).build();

    // Assert
    assertEquals(1, actualImmutableBucketKey.dataTypeRank().intValue());
    assertEquals(1, actualImmutableBucketKey.vantagePointRank().intValue());
    assertEquals(1L, actualImmutableBucketKey.dataTypeId().longValue());
    assertSame(vantagePoint, actualImmutableBucketKey.vantagePoint());
  }

  /**
   * Test Builder {@link Builder#dataTypeRank(Integer)}.
   *
   * <p>Method under test: {@link Builder#dataTypeRank(Integer)}
   */
  @Test
  @DisplayName("Test Builder dataTypeRank(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dataTypeRank(Integer)"})
  void testBuilderDataTypeRank() {
    // Arrange
    Builder builderResult = ImmutableBucketKey.builder();

    // Act
    Builder actualDataTypeRankResult = builderResult.dataTypeRank(1);

    // Assert
    assertSame(builderResult, actualDataTypeRankResult);
  }

  /**
   * Test Builder {@link Builder#from(BucketKey)}.
   *
   * <p>Method under test: {@link Builder#from(BucketKey)}
   */
  @Test
  @DisplayName("Test Builder from(BucketKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BucketKey)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBucketKey.builder();

    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);
    ImmutableBucketKey instance =
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBucketKey actualImmutableBucketKey = builderResult.build();
    assertEquals(instance, actualImmutableBucketKey);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BucketKey)}.
   *
   * <p>Method under test: {@link Builder#from(BucketKey)}
   */
  @Test
  @DisplayName("Test Builder from(BucketKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BucketKey)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBucketKey.builder();

    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(null).dataTypeRank(1);
    ImmutableBucketKey instance =
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBucketKey actualImmutableBucketKey = builderResult.build();
    assertEquals(instance, actualImmutableBucketKey);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#vantagePointRank(Integer)}.
   *
   * <p>Method under test: {@link Builder#vantagePointRank(Integer)}
   */
  @Test
  @DisplayName("Test Builder vantagePointRank(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.vantagePointRank(Integer)"})
  void testBuilderVantagePointRank() {
    // Arrange
    Builder builderResult = ImmutableBucketKey.builder();

    // Act
    Builder actualVantagePointRankResult = builderResult.vantagePointRank(1);

    // Assert
    assertSame(builderResult, actualVantagePointRankResult);
  }

  /**
   * Test Builder {@link Builder#vantagePoint(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#vantagePoint(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder vantagePoint(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.vantagePoint(EntityReference)"})
  void testBuilderVantagePoint_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBucketKey.builder();

    // Act
    Builder actualVantagePointResult =
        builderResult.vantagePoint(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualVantagePointResult);
  }

  /**
   * Test {@link ImmutableBucketKey#copyOf(BucketKey)}.
   *
   * <ul>
   *   <li>Then vantagePoint return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBucketKey#copyOf(BucketKey)}
   */
  @Test
  @DisplayName("Test copyOf(BucketKey); then vantagePoint return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBucketKey ImmutableBucketKey.copyOf(BucketKey)"})
  void testCopyOf_thenVantagePointReturnImmutableEntityReference() {
    // Arrange
    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);
    ImmutableBucketKey instance =
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    ImmutableBucketKey actualCopyOfResult = ImmutableBucketKey.copyOf(instance);

    // Assert
    EntityReference vantagePointResult = actualCopyOfResult.vantagePoint();
    assertTrue(vantagePointResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", vantagePointResult.description());
    assertEquals(1, actualCopyOfResult.dataTypeRank().intValue());
    assertEquals(1, actualCopyOfResult.vantagePointRank().intValue());
    assertEquals(1L, actualCopyOfResult.dataTypeId().longValue());
    assertEquals(1L, vantagePointResult.id());
    assertEquals(EntityKind.ALL, vantagePointResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, vantagePointResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableBucketKey#equals(Object)}, and {@link ImmutableBucketKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBucketKey#equals(Object)}
   *   <li>{@link ImmutableBucketKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBucketKey.equals(Object)",
    "int ImmutableBucketKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);
    ImmutableBucketKey immutableBucketKey =
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    Builder dataTypeRankResult2 = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);
    ImmutableBucketKey immutableBucketKey2 =
        dataTypeRankResult2
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act and Assert
    assertEquals(immutableBucketKey, immutableBucketKey2);
    assertEquals(immutableBucketKey.hashCode(), immutableBucketKey2.hashCode());
  }

  /**
   * Test {@link ImmutableBucketKey#equals(Object)}, and {@link ImmutableBucketKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBucketKey#equals(Object)}
   *   <li>{@link ImmutableBucketKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBucketKey.equals(Object)",
    "int ImmutableBucketKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);
    ImmutableBucketKey immutableBucketKey =
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act and Assert
    assertEquals(immutableBucketKey, immutableBucketKey);
    int expectedHashCodeResult = immutableBucketKey.hashCode();
    assertEquals(expectedHashCodeResult, immutableBucketKey.hashCode());
  }

  /**
   * Test {@link ImmutableBucketKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBucketKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBucketKey.equals(Object)",
    "int ImmutableBucketKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(2L).dataTypeRank(1);
    ImmutableBucketKey immutableBucketKey =
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    Builder dataTypeRankResult2 = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);

    // Act and Assert
    assertNotEquals(
        immutableBucketKey,
        dataTypeRankResult2
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build());
  }

  /**
   * Test {@link ImmutableBucketKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBucketKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBucketKey.equals(Object)",
    "int ImmutableBucketKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);
    ImmutableBucketKey immutableBucketKey =
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    Builder dataTypeRankResult2 = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);

    // Act and Assert
    assertNotEquals(
        immutableBucketKey,
        dataTypeRankResult2
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build());
  }

  /**
   * Test {@link ImmutableBucketKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBucketKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBucketKey.equals(Object)",
    "int ImmutableBucketKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);

    // Act and Assert
    assertNotEquals(
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBucketKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBucketKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBucketKey.equals(Object)",
    "int ImmutableBucketKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);

    // Act and Assert
    assertNotEquals(
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build(),
        "Different type to ImmutableBucketKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBucketKey#toString()}
   *   <li>{@link ImmutableBucketKey#dataTypeId()}
   *   <li>{@link ImmutableBucketKey#dataTypeRank()}
   *   <li>{@link ImmutableBucketKey#vantagePoint()}
   *   <li>{@link ImmutableBucketKey#vantagePointRank()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableBucketKey.dataTypeId()",
    "Integer ImmutableBucketKey.dataTypeRank()",
    "String ImmutableBucketKey.toString()",
    "EntityReference ImmutableBucketKey.vantagePoint()",
    "Integer ImmutableBucketKey.vantagePointRank()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);
    ImmutableBucketKey immutableBucketKey =
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    String actualToStringResult = immutableBucketKey.toString();
    Long actualDataTypeIdResult = immutableBucketKey.dataTypeId();
    Integer actualDataTypeRankResult = immutableBucketKey.dataTypeRank();
    EntityReference actualVantagePointResult = immutableBucketKey.vantagePoint();
    Integer actualVantagePointRankResult = immutableBucketKey.vantagePointRank();

    // Assert
    assertTrue(actualVantagePointResult instanceof ImmutableEntityReference);
    assertEquals(
        "BucketKey{vantagePoint=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, dataTypeId=1}",
        actualToStringResult);
    assertEquals(1, actualDataTypeRankResult.intValue());
    assertEquals(1, actualVantagePointRankResult.intValue());
    assertEquals(1L, actualDataTypeIdResult.longValue());
  }

  /**
   * Test {@link ImmutableBucketKey#withDataTypeId(Long)}.
   *
   * <p>Method under test: {@link ImmutableBucketKey#withDataTypeId(Long)}
   */
  @Test
  @DisplayName("Test withDataTypeId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBucketKey ImmutableBucketKey.withDataTypeId(Long)"})
  void testWithDataTypeId() {
    // Arrange
    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);
    ImmutableBucketKey immutableBucketKey =
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    ImmutableBucketKey actualWithDataTypeIdResult = immutableBucketKey.withDataTypeId(1L);

    // Assert
    assertSame(immutableBucketKey, actualWithDataTypeIdResult);
  }

  /**
   * Test {@link ImmutableBucketKey#withDataTypeId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then vantagePoint return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBucketKey#withDataTypeId(Long)}
   */
  @Test
  @DisplayName(
      "Test withDataTypeId(Long); when forty-two; then vantagePoint return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBucketKey ImmutableBucketKey.withDataTypeId(Long)"})
  void testWithDataTypeId_whenFortyTwo_thenVantagePointReturnImmutableEntityReference() {
    // Arrange
    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);

    // Act
    ImmutableBucketKey actualWithDataTypeIdResult =
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build()
            .withDataTypeId(42L);

    // Assert
    EntityReference vantagePointResult = actualWithDataTypeIdResult.vantagePoint();
    assertTrue(vantagePointResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", vantagePointResult.description());
    assertEquals(1, actualWithDataTypeIdResult.dataTypeRank().intValue());
    assertEquals(1, actualWithDataTypeIdResult.vantagePointRank().intValue());
    assertEquals(1L, vantagePointResult.id());
    assertEquals(42L, actualWithDataTypeIdResult.dataTypeId().longValue());
    assertEquals(EntityKind.ALL, vantagePointResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, vantagePointResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableBucketKey#withDataTypeRank(Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBucketKey#withDataTypeRank(Integer)}
   */
  @Test
  @DisplayName("Test withDataTypeRank(Integer); when forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBucketKey ImmutableBucketKey.withDataTypeRank(Integer)"})
  void testWithDataTypeRank_whenFortyTwo() {
    // Arrange
    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);
    ImmutableBucketKey immutableBucketKey =
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    ImmutableBucketKey actualWithDataTypeRankResult = immutableBucketKey.withDataTypeRank(42);

    // Assert
    assertEquals(immutableBucketKey, actualWithDataTypeRankResult);
  }

  /**
   * Test {@link ImmutableBucketKey#withDataTypeRank(Integer)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBucketKey#withDataTypeRank(Integer)}
   */
  @Test
  @DisplayName("Test withDataTypeRank(Integer); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBucketKey ImmutableBucketKey.withDataTypeRank(Integer)"})
  void testWithDataTypeRank_whenOne() {
    // Arrange
    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);
    ImmutableBucketKey immutableBucketKey =
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    ImmutableBucketKey actualWithDataTypeRankResult = immutableBucketKey.withDataTypeRank(1);

    // Assert
    assertSame(immutableBucketKey, actualWithDataTypeRankResult);
  }

  /**
   * Test {@link ImmutableBucketKey#withVantagePoint(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableBucketKey#withVantagePoint(EntityReference)}
   */
  @Test
  @DisplayName("Test withVantagePoint(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBucketKey ImmutableBucketKey.withVantagePoint(EntityReference)"})
  void testWithVantagePoint() {
    // Arrange
    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);
    ImmutableBucketKey immutableBucketKey =
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    ImmutableBucketKey actualWithVantagePointResult =
        immutableBucketKey.withVantagePoint(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableBucketKey, actualWithVantagePointResult);
  }

  /**
   * Test {@link ImmutableBucketKey#withVantagePointRank(Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBucketKey#withVantagePointRank(Integer)}
   */
  @Test
  @DisplayName("Test withVantagePointRank(Integer); when forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBucketKey ImmutableBucketKey.withVantagePointRank(Integer)"})
  void testWithVantagePointRank_whenFortyTwo() {
    // Arrange
    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);
    ImmutableBucketKey immutableBucketKey =
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    ImmutableBucketKey actualWithVantagePointRankResult =
        immutableBucketKey.withVantagePointRank(42);

    // Assert
    assertEquals(immutableBucketKey, actualWithVantagePointRankResult);
  }

  /**
   * Test {@link ImmutableBucketKey#withVantagePointRank(Integer)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBucketKey#withVantagePointRank(Integer)}
   */
  @Test
  @DisplayName("Test withVantagePointRank(Integer); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBucketKey ImmutableBucketKey.withVantagePointRank(Integer)"})
  void testWithVantagePointRank_whenOne() {
    // Arrange
    Builder dataTypeRankResult = ImmutableBucketKey.builder().dataTypeId(1L).dataTypeRank(1);
    ImmutableBucketKey immutableBucketKey =
        dataTypeRankResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    ImmutableBucketKey actualWithVantagePointRankResult =
        immutableBucketKey.withVantagePointRank(1);

    // Assert
    assertSame(immutableBucketKey, actualWithVantagePointRankResult);
  }
}
