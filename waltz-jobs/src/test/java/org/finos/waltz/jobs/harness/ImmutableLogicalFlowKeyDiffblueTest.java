package org.finos.waltz.jobs.harness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.harness.ImmutableLogicalFlowKey.Builder;
import org.finos.waltz.jobs.harness.PhysicalFlowHarness.LogicalFlowKey;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowKeyDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalFlowKey Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualLfIdResult = ImmutableLogicalFlowKey.builder().lfId(1L);
    ImmutableEntityReference src =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualSrcResult = actualLfIdResult.src(src);
    ImmutableEntityReference trg =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableLogicalFlowKey actualImmutableLogicalFlowKey = actualSrcResult.trg(trg).build();

    // Assert
    assertEquals(1L, actualImmutableLogicalFlowKey.lfId());
    assertSame(src, actualImmutableLogicalFlowKey.src());
    assertSame(trg, actualImmutableLogicalFlowKey.trg());
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowKey)}.
   *
   * <p>Method under test: {@link Builder#from(LogicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowKey)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowKey.builder();

    Builder lfIdResult = ImmutableLogicalFlowKey.builder().lfId(1L);

    Builder srcResult =
        lfIdResult.src(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableLogicalFlowKey instance =
        srcResult
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLogicalFlowKey actualImmutableLogicalFlowKey = builderResult.build();
    assertEquals(instance, actualImmutableLogicalFlowKey);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#lfId(long)}.
   *
   * <p>Method under test: {@link Builder#lfId(long)}
   */
  @Test
  @DisplayName("Test Builder lfId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lfId(long)"})
  void testBuilderLfId() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowKey.builder();

    // Act
    Builder actualLfIdResult = builderResult.lfId(1L);

    // Assert
    assertSame(builderResult, actualLfIdResult);
  }

  /**
   * Test Builder {@link Builder#src(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#src(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder src(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.src(EntityReference)"})
  void testBuilderSrc_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowKey.builder();

    // Act
    Builder actualSrcResult = builderResult.src(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualSrcResult);
  }

  /**
   * Test Builder {@link Builder#trg(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#trg(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder trg(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.trg(EntityReference)"})
  void testBuilderTrg_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowKey.builder();

    // Act
    Builder actualTrgResult = builderResult.trg(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualTrgResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowKey#copyOf(LogicalFlowKey)}.
   *
   * <ul>
   *   <li>Then src return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowKey#copyOf(LogicalFlowKey)}
   */
  @Test
  @DisplayName("Test copyOf(LogicalFlowKey); then src return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalFlowKey ImmutableLogicalFlowKey.copyOf(LogicalFlowKey)"})
  void testCopyOf_thenSrcReturnImmutableEntityReference() {
    // Arrange
    Builder lfIdResult = ImmutableLogicalFlowKey.builder().lfId(1L);

    Builder srcResult =
        lfIdResult.src(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableLogicalFlowKey instance =
        srcResult
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLogicalFlowKey actualCopyOfResult = ImmutableLogicalFlowKey.copyOf(instance);

    // Assert
    EntityReference srcResult2 = actualCopyOfResult.src();
    assertTrue(srcResult2 instanceof ImmutableEntityReference);
    EntityReference trgResult = actualCopyOfResult.trg();
    assertTrue(trgResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", srcResult2.description());
    assertEquals(1L, actualCopyOfResult.lfId());
    assertEquals(1L, srcResult2.id());
    assertEquals(EntityKind.ALL, srcResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, srcResult2.entityLifecycleStatus());
    assertEquals(srcResult2, trgResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowKey#equals(Object)}, and {@link
   * ImmutableLogicalFlowKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowKey#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowKey.equals(Object)",
    "int ImmutableLogicalFlowKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder lfIdResult = ImmutableLogicalFlowKey.builder().lfId(1L);

    Builder srcResult =
        lfIdResult.src(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableLogicalFlowKey immutableLogicalFlowKey =
        srcResult
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder lfIdResult2 = ImmutableLogicalFlowKey.builder().lfId(1L);

    Builder srcResult2 =
        lfIdResult2.src(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableLogicalFlowKey immutableLogicalFlowKey2 =
        srcResult2
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableLogicalFlowKey, immutableLogicalFlowKey2);
    assertEquals(immutableLogicalFlowKey.hashCode(), immutableLogicalFlowKey2.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowKey#equals(Object)}, and {@link
   * ImmutableLogicalFlowKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowKey#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowKey.equals(Object)",
    "int ImmutableLogicalFlowKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder lfIdResult = ImmutableLogicalFlowKey.builder().lfId(1L);

    Builder srcResult =
        lfIdResult.src(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableLogicalFlowKey immutableLogicalFlowKey =
        srcResult
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableLogicalFlowKey, immutableLogicalFlowKey);
    int expectedHashCodeResult = immutableLogicalFlowKey.hashCode();
    assertEquals(expectedHashCodeResult, immutableLogicalFlowKey.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowKey.equals(Object)",
    "int ImmutableLogicalFlowKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder lfIdResult = ImmutableLogicalFlowKey.builder().lfId(2L);

    Builder srcResult =
        lfIdResult.src(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableLogicalFlowKey immutableLogicalFlowKey =
        srcResult
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder lfIdResult2 = ImmutableLogicalFlowKey.builder().lfId(1L);

    Builder srcResult2 =
        lfIdResult2.src(
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
        immutableLogicalFlowKey,
        srcResult2
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowKey.equals(Object)",
    "int ImmutableLogicalFlowKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder lfIdResult = ImmutableLogicalFlowKey.builder().lfId(1L);

    Builder srcResult =
        lfIdResult.src(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableLogicalFlowKey immutableLogicalFlowKey =
        srcResult
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder lfIdResult2 = ImmutableLogicalFlowKey.builder().lfId(1L);

    Builder srcResult2 =
        lfIdResult2.src(
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
        immutableLogicalFlowKey,
        srcResult2
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowKey.equals(Object)",
    "int ImmutableLogicalFlowKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder lfIdResult = ImmutableLogicalFlowKey.builder().lfId(1L);

    Builder srcResult =
        lfIdResult.src(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableLogicalFlowKey immutableLogicalFlowKey =
        srcResult
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder lfIdResult2 = ImmutableLogicalFlowKey.builder().lfId(1L);

    Builder srcResult2 =
        lfIdResult2.src(
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
        immutableLogicalFlowKey,
        srcResult2
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowKey.equals(Object)",
    "int ImmutableLogicalFlowKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder lfIdResult = ImmutableLogicalFlowKey.builder().lfId(1L);

    Builder srcResult =
        lfIdResult.src(
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
        srcResult
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableLogicalFlowKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowKey.equals(Object)",
    "int ImmutableLogicalFlowKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder lfIdResult = ImmutableLogicalFlowKey.builder().lfId(1L);

    Builder srcResult =
        lfIdResult.src(
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
        srcResult
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableLogicalFlowKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowKey#toString()}
   *   <li>{@link ImmutableLogicalFlowKey#lfId()}
   *   <li>{@link ImmutableLogicalFlowKey#src()}
   *   <li>{@link ImmutableLogicalFlowKey#trg()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableLogicalFlowKey.lfId()",
    "EntityReference ImmutableLogicalFlowKey.src()",
    "String ImmutableLogicalFlowKey.toString()",
    "EntityReference ImmutableLogicalFlowKey.trg()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder lfIdResult = ImmutableLogicalFlowKey.builder().lfId(1L);

    Builder srcResult =
        lfIdResult.src(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableLogicalFlowKey immutableLogicalFlowKey =
        srcResult
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableLogicalFlowKey.toString();
    long actualLfIdResult = immutableLogicalFlowKey.lfId();
    EntityReference actualSrcResult = immutableLogicalFlowKey.src();
    EntityReference actualTrgResult = immutableLogicalFlowKey.trg();

    // Assert
    assertTrue(actualSrcResult instanceof ImmutableEntityReference);
    assertTrue(actualTrgResult instanceof ImmutableEntityReference);
    assertEquals(
        "LogicalFlowKey{lfId=1, src=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, trg"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}}",
        actualToStringResult);
    assertEquals(1L, actualLfIdResult);
    assertEquals(actualSrcResult, actualTrgResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowKey#withLfId(long)}.
   *
   * <p>Method under test: {@link ImmutableLogicalFlowKey#withLfId(long)}
   */
  @Test
  @DisplayName("Test withLfId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalFlowKey ImmutableLogicalFlowKey.withLfId(long)"})
  void testWithLfId() {
    // Arrange
    Builder lfIdResult = ImmutableLogicalFlowKey.builder().lfId(42L);

    Builder srcResult =
        lfIdResult.src(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableLogicalFlowKey immutableLogicalFlowKey =
        srcResult
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLogicalFlowKey actualWithLfIdResult = immutableLogicalFlowKey.withLfId(42L);

    // Assert
    assertSame(immutableLogicalFlowKey, actualWithLfIdResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowKey#withLfId(long)}.
   *
   * <ul>
   *   <li>Then src return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowKey#withLfId(long)}
   */
  @Test
  @DisplayName("Test withLfId(long); then src return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalFlowKey ImmutableLogicalFlowKey.withLfId(long)"})
  void testWithLfId_thenSrcReturnImmutableEntityReference() {
    // Arrange
    Builder lfIdResult = ImmutableLogicalFlowKey.builder().lfId(1L);

    Builder srcResult =
        lfIdResult.src(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableLogicalFlowKey actualWithLfIdResult =
        srcResult
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withLfId(42L);

    // Assert
    EntityReference srcResult2 = actualWithLfIdResult.src();
    assertTrue(srcResult2 instanceof ImmutableEntityReference);
    EntityReference trgResult = actualWithLfIdResult.trg();
    assertTrue(trgResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", srcResult2.description());
    assertEquals(1L, srcResult2.id());
    assertEquals(42L, actualWithLfIdResult.lfId());
    assertEquals(EntityKind.ALL, srcResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, srcResult2.entityLifecycleStatus());
    assertEquals(srcResult2, trgResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowKey#withSrc(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableLogicalFlowKey#withSrc(EntityReference)}
   */
  @Test
  @DisplayName("Test withSrc(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalFlowKey ImmutableLogicalFlowKey.withSrc(EntityReference)"})
  void testWithSrc() {
    // Arrange
    Builder lfIdResult = ImmutableLogicalFlowKey.builder().lfId(1L);

    Builder srcResult =
        lfIdResult.src(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableLogicalFlowKey immutableLogicalFlowKey =
        srcResult
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLogicalFlowKey actualWithSrcResult =
        immutableLogicalFlowKey.withSrc(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableLogicalFlowKey, actualWithSrcResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowKey#withTrg(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableLogicalFlowKey#withTrg(EntityReference)}
   */
  @Test
  @DisplayName("Test withTrg(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalFlowKey ImmutableLogicalFlowKey.withTrg(EntityReference)"})
  void testWithTrg() {
    // Arrange
    Builder lfIdResult = ImmutableLogicalFlowKey.builder().lfId(1L);

    Builder srcResult =
        lfIdResult.src(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableLogicalFlowKey immutableLogicalFlowKey =
        srcResult
            .trg(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableLogicalFlowKey actualWithTrgResult =
        immutableLogicalFlowKey.withTrg(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableLogicalFlowKey, actualWithTrgResult);
  }
}
