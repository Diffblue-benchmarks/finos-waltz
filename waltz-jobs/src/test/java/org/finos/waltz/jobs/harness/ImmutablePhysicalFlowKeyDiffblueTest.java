package org.finos.waltz.jobs.harness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.harness.ImmutablePhysicalFlowKey.Builder;
import org.finos.waltz.jobs.harness.PhysicalFlowHarness.PhysicalFlowKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowKeyDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#flowDescription(String)}
   *   <li>{@link Builder#flowExtId(String)}
   *   <li>{@link Builder#flowName(String)}
   *   <li>{@link Builder#specDescription(String)}
   *   <li>{@link Builder#specExtId(String)}
   *   <li>{@link Builder#specName(String)}
   *   <li>{@link Builder#transport(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowKey Builder.build()",
    "Builder Builder.flowDescription(String)",
    "Builder Builder.flowExtId(String)",
    "Builder Builder.flowName(String)",
    "Builder Builder.specDescription(String)",
    "Builder Builder.specExtId(String)",
    "Builder Builder.specName(String)",
    "Builder Builder.transport(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutablePhysicalFlowKey actualImmutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Assert
    assertEquals("42", actualImmutablePhysicalFlowKey.flowExtId());
    assertEquals("42", actualImmutablePhysicalFlowKey.specExtId());
    assertEquals("Flow Description", actualImmutablePhysicalFlowKey.flowDescription());
    assertEquals("Flow Name", actualImmutablePhysicalFlowKey.flowName());
    assertEquals("Spec Description", actualImmutablePhysicalFlowKey.specDescription());
    assertEquals("Spec Name", actualImmutablePhysicalFlowKey.specName());
    assertEquals("Transport", actualImmutablePhysicalFlowKey.transport());
    assertEquals(1L, actualImmutablePhysicalFlowKey.lfId());
    assertEquals(1L, actualImmutablePhysicalFlowKey.pfId());
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    ImmutablePhysicalFlowKey instance =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowKey actualImmutablePhysicalFlowKey = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowKey);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    ImmutablePhysicalFlowKey instance =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription(null)
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowKey actualImmutablePhysicalFlowKey = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowKey);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    ImmutablePhysicalFlowKey instance =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId(null)
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowKey actualImmutablePhysicalFlowKey = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowKey);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom4() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    ImmutablePhysicalFlowKey instance =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName(null)
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowKey actualImmutablePhysicalFlowKey = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowKey);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom5() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    ImmutablePhysicalFlowKey instance =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription(null)
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowKey actualImmutablePhysicalFlowKey = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowKey);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom6() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    ImmutablePhysicalFlowKey instance =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId(null)
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowKey actualImmutablePhysicalFlowKey = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowKey);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom7() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    ImmutablePhysicalFlowKey instance =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName(null)
            .transport("Transport")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowKey actualImmutablePhysicalFlowKey = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowKey);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowKey)}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowKey)"})
  void testBuilderFrom8() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();
    ImmutablePhysicalFlowKey instance =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport(null)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowKey actualImmutablePhysicalFlowKey = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowKey);
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
    Builder builderResult = ImmutablePhysicalFlowKey.builder();

    // Act
    Builder actualLfIdResult = builderResult.lfId(1L);

    // Assert
    assertSame(builderResult, actualLfIdResult);
  }

  /**
   * Test Builder {@link Builder#pfId(long)}.
   *
   * <p>Method under test: {@link Builder#pfId(long)}
   */
  @Test
  @DisplayName("Test Builder pfId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.pfId(long)"})
  void testBuilderPfId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowKey.builder();

    // Act
    Builder actualPfIdResult = builderResult.pfId(1L);

    // Assert
    assertSame(builderResult, actualPfIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#copyOf(PhysicalFlowKey)}.
   *
   * <ul>
   *   <li>Then return flowExtId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#copyOf(PhysicalFlowKey)}
   */
  @Test
  @DisplayName("Test copyOf(PhysicalFlowKey); then return flowExtId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.copyOf(PhysicalFlowKey)"})
  void testCopyOf_thenReturnFlowExtIdIs42() {
    // Arrange
    ImmutablePhysicalFlowKey instance =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowKey actualCopyOfResult = ImmutablePhysicalFlowKey.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.flowExtId());
    assertEquals("42", actualCopyOfResult.specExtId());
    assertEquals("Flow Description", actualCopyOfResult.flowDescription());
    assertEquals("Flow Name", actualCopyOfResult.flowName());
    assertEquals("Spec Description", actualCopyOfResult.specDescription());
    assertEquals("Spec Name", actualCopyOfResult.specName());
    assertEquals("Transport", actualCopyOfResult.transport());
    assertEquals(1L, actualCopyOfResult.lfId());
    assertEquals(1L, actualCopyOfResult.pfId());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#equals(Object)}, and {@link
   * ImmutablePhysicalFlowKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowKey#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowKey.equals(Object)",
    "int ImmutablePhysicalFlowKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey2 =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act and Assert
    assertEquals(immutablePhysicalFlowKey, immutablePhysicalFlowKey2);
    assertEquals(immutablePhysicalFlowKey.hashCode(), immutablePhysicalFlowKey2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#equals(Object)}, and {@link
   * ImmutablePhysicalFlowKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowKey#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowKey.equals(Object)",
    "int ImmutablePhysicalFlowKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act and Assert
    assertEquals(immutablePhysicalFlowKey, immutablePhysicalFlowKey);
    int expectedHashCodeResult = immutablePhysicalFlowKey.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalFlowKey.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowKey.equals(Object)",
    "int ImmutablePhysicalFlowKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("lfId")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowKey,
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowKey.equals(Object)",
    "int ImmutablePhysicalFlowKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("Flow Ext Id")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowKey,
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowKey.equals(Object)",
    "int ImmutablePhysicalFlowKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("lfId")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowKey,
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowKey.equals(Object)",
    "int ImmutablePhysicalFlowKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(2L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowKey,
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowKey.equals(Object)",
    "int ImmutablePhysicalFlowKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(2L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowKey,
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowKey.equals(Object)",
    "int ImmutablePhysicalFlowKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("lfId")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowKey,
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowKey.equals(Object)",
    "int ImmutablePhysicalFlowKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("Spec Ext Id")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowKey,
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowKey.equals(Object)",
    "int ImmutablePhysicalFlowKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("lfId")
            .transport("Transport")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowKey,
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowKey.equals(Object)",
    "int ImmutablePhysicalFlowKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("lfId")
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowKey,
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowKey.equals(Object)",
    "int ImmutablePhysicalFlowKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowKey.equals(Object)",
    "int ImmutablePhysicalFlowKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build(),
        "Different type to ImmutablePhysicalFlowKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowKey#toString()}
   *   <li>{@link ImmutablePhysicalFlowKey#flowDescription()}
   *   <li>{@link ImmutablePhysicalFlowKey#flowExtId()}
   *   <li>{@link ImmutablePhysicalFlowKey#flowName()}
   *   <li>{@link ImmutablePhysicalFlowKey#lfId()}
   *   <li>{@link ImmutablePhysicalFlowKey#pfId()}
   *   <li>{@link ImmutablePhysicalFlowKey#specDescription()}
   *   <li>{@link ImmutablePhysicalFlowKey#specExtId()}
   *   <li>{@link ImmutablePhysicalFlowKey#specName()}
   *   <li>{@link ImmutablePhysicalFlowKey#transport()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutablePhysicalFlowKey.flowDescription()",
    "String ImmutablePhysicalFlowKey.flowExtId()",
    "String ImmutablePhysicalFlowKey.flowName()",
    "long ImmutablePhysicalFlowKey.lfId()",
    "long ImmutablePhysicalFlowKey.pfId()",
    "String ImmutablePhysicalFlowKey.specDescription()",
    "String ImmutablePhysicalFlowKey.specExtId()",
    "String ImmutablePhysicalFlowKey.specName()",
    "String ImmutablePhysicalFlowKey.toString()",
    "String ImmutablePhysicalFlowKey.transport()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act
    String actualToStringResult = immutablePhysicalFlowKey.toString();
    String actualFlowDescriptionResult = immutablePhysicalFlowKey.flowDescription();
    String actualFlowExtIdResult = immutablePhysicalFlowKey.flowExtId();
    String actualFlowNameResult = immutablePhysicalFlowKey.flowName();
    long actualLfIdResult = immutablePhysicalFlowKey.lfId();
    long actualPfIdResult = immutablePhysicalFlowKey.pfId();
    String actualSpecDescriptionResult = immutablePhysicalFlowKey.specDescription();
    String actualSpecExtIdResult = immutablePhysicalFlowKey.specExtId();
    String actualSpecNameResult = immutablePhysicalFlowKey.specName();

    // Assert
    assertEquals("42", actualFlowExtIdResult);
    assertEquals("42", actualSpecExtIdResult);
    assertEquals("Flow Description", actualFlowDescriptionResult);
    assertEquals("Flow Name", actualFlowNameResult);
    assertEquals(
        "PhysicalFlowKey{lfId=1, pfId=1, flowName=Flow Name, transport=Transport, flowExtId=42, specName=Spec"
            + " Name, specExtId=42, specDescription=Spec Description, flowDescription=Flow Description}",
        actualToStringResult);
    assertEquals("Spec Description", actualSpecDescriptionResult);
    assertEquals("Spec Name", actualSpecNameResult);
    assertEquals("Transport", immutablePhysicalFlowKey.transport());
    assertEquals(1L, actualLfIdResult);
    assertEquals(1L, actualPfIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withFlowDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withFlowDescription(String)}
   */
  @Test
  @DisplayName("Test withFlowDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withFlowDescription(String)"
  })
  void testWithFlowDescription() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("42")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowKey actualWithFlowDescriptionResult =
        immutablePhysicalFlowKey.withFlowDescription("42");

    // Assert
    assertSame(immutablePhysicalFlowKey, actualWithFlowDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withFlowDescription(String)}.
   *
   * <ul>
   *   <li>Then return flowDescription is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withFlowDescription(String)}
   */
  @Test
  @DisplayName("Test withFlowDescription(String); then return flowDescription is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withFlowDescription(String)"
  })
  void testWithFlowDescription_thenReturnFlowDescriptionIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowKey actualWithFlowDescriptionResult =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build()
            .withFlowDescription("42");

    // Assert
    assertEquals("42", actualWithFlowDescriptionResult.flowDescription());
    assertEquals("42", actualWithFlowDescriptionResult.flowExtId());
    assertEquals("42", actualWithFlowDescriptionResult.specExtId());
    assertEquals("Flow Name", actualWithFlowDescriptionResult.flowName());
    assertEquals("Spec Description", actualWithFlowDescriptionResult.specDescription());
    assertEquals("Spec Name", actualWithFlowDescriptionResult.specName());
    assertEquals("Transport", actualWithFlowDescriptionResult.transport());
    assertEquals(1L, actualWithFlowDescriptionResult.lfId());
    assertEquals(1L, actualWithFlowDescriptionResult.pfId());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withFlowExtId(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withFlowExtId(String)}
   */
  @Test
  @DisplayName("Test withFlowExtId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withFlowExtId(String)"})
  void testWithFlowExtId() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowKey actualWithFlowExtIdResult =
        immutablePhysicalFlowKey.withFlowExtId("42");

    // Assert
    assertSame(immutablePhysicalFlowKey, actualWithFlowExtIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withFlowExtId(String)}.
   *
   * <ul>
   *   <li>Then return flowExtId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withFlowExtId(String)}
   */
  @Test
  @DisplayName("Test withFlowExtId(String); then return flowExtId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withFlowExtId(String)"})
  void testWithFlowExtId_thenReturnFlowExtIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowKey actualWithFlowExtIdResult =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("Flow Ext Id")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build()
            .withFlowExtId("42");

    // Assert
    assertEquals("42", actualWithFlowExtIdResult.flowExtId());
    assertEquals("42", actualWithFlowExtIdResult.specExtId());
    assertEquals("Flow Description", actualWithFlowExtIdResult.flowDescription());
    assertEquals("Flow Name", actualWithFlowExtIdResult.flowName());
    assertEquals("Spec Description", actualWithFlowExtIdResult.specDescription());
    assertEquals("Spec Name", actualWithFlowExtIdResult.specName());
    assertEquals("Transport", actualWithFlowExtIdResult.transport());
    assertEquals(1L, actualWithFlowExtIdResult.lfId());
    assertEquals(1L, actualWithFlowExtIdResult.pfId());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withFlowName(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withFlowName(String)}
   */
  @Test
  @DisplayName("Test withFlowName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withFlowName(String)"})
  void testWithFlowName() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("42")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowKey actualWithFlowNameResult = immutablePhysicalFlowKey.withFlowName("42");

    // Assert
    assertSame(immutablePhysicalFlowKey, actualWithFlowNameResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withFlowName(String)}.
   *
   * <ul>
   *   <li>Then return flowExtId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withFlowName(String)}
   */
  @Test
  @DisplayName("Test withFlowName(String); then return flowExtId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withFlowName(String)"})
  void testWithFlowName_thenReturnFlowExtIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowKey actualWithFlowNameResult =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build()
            .withFlowName("42");

    // Assert
    assertEquals("42", actualWithFlowNameResult.flowExtId());
    assertEquals("42", actualWithFlowNameResult.flowName());
    assertEquals("42", actualWithFlowNameResult.specExtId());
    assertEquals("Flow Description", actualWithFlowNameResult.flowDescription());
    assertEquals("Spec Description", actualWithFlowNameResult.specDescription());
    assertEquals("Spec Name", actualWithFlowNameResult.specName());
    assertEquals("Transport", actualWithFlowNameResult.transport());
    assertEquals(1L, actualWithFlowNameResult.lfId());
    assertEquals(1L, actualWithFlowNameResult.pfId());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withLfId(long)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withLfId(long)}
   */
  @Test
  @DisplayName("Test withLfId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withLfId(long)"})
  void testWithLfId() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(42L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowKey actualWithLfIdResult = immutablePhysicalFlowKey.withLfId(42L);

    // Assert
    assertSame(immutablePhysicalFlowKey, actualWithLfIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withLfId(long)}.
   *
   * <ul>
   *   <li>Then return flowExtId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withLfId(long)}
   */
  @Test
  @DisplayName("Test withLfId(long); then return flowExtId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withLfId(long)"})
  void testWithLfId_thenReturnFlowExtIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowKey actualWithLfIdResult =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build()
            .withLfId(42L);

    // Assert
    assertEquals("42", actualWithLfIdResult.flowExtId());
    assertEquals("42", actualWithLfIdResult.specExtId());
    assertEquals("Flow Description", actualWithLfIdResult.flowDescription());
    assertEquals("Flow Name", actualWithLfIdResult.flowName());
    assertEquals("Spec Description", actualWithLfIdResult.specDescription());
    assertEquals("Spec Name", actualWithLfIdResult.specName());
    assertEquals("Transport", actualWithLfIdResult.transport());
    assertEquals(1L, actualWithLfIdResult.pfId());
    assertEquals(42L, actualWithLfIdResult.lfId());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withPfId(long)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withPfId(long)}
   */
  @Test
  @DisplayName("Test withPfId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withPfId(long)"})
  void testWithPfId() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(42L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowKey actualWithPfIdResult = immutablePhysicalFlowKey.withPfId(42L);

    // Assert
    assertSame(immutablePhysicalFlowKey, actualWithPfIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withPfId(long)}.
   *
   * <ul>
   *   <li>Then return flowExtId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withPfId(long)}
   */
  @Test
  @DisplayName("Test withPfId(long); then return flowExtId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withPfId(long)"})
  void testWithPfId_thenReturnFlowExtIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowKey actualWithPfIdResult =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build()
            .withPfId(42L);

    // Assert
    assertEquals("42", actualWithPfIdResult.flowExtId());
    assertEquals("42", actualWithPfIdResult.specExtId());
    assertEquals("Flow Description", actualWithPfIdResult.flowDescription());
    assertEquals("Flow Name", actualWithPfIdResult.flowName());
    assertEquals("Spec Description", actualWithPfIdResult.specDescription());
    assertEquals("Spec Name", actualWithPfIdResult.specName());
    assertEquals("Transport", actualWithPfIdResult.transport());
    assertEquals(1L, actualWithPfIdResult.lfId());
    assertEquals(42L, actualWithPfIdResult.pfId());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withSpecDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withSpecDescription(String)}
   */
  @Test
  @DisplayName("Test withSpecDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withSpecDescription(String)"
  })
  void testWithSpecDescription() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("42")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowKey actualWithSpecDescriptionResult =
        immutablePhysicalFlowKey.withSpecDescription("42");

    // Assert
    assertSame(immutablePhysicalFlowKey, actualWithSpecDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withSpecDescription(String)}.
   *
   * <ul>
   *   <li>Then return flowExtId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withSpecDescription(String)}
   */
  @Test
  @DisplayName("Test withSpecDescription(String); then return flowExtId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withSpecDescription(String)"
  })
  void testWithSpecDescription_thenReturnFlowExtIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowKey actualWithSpecDescriptionResult =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build()
            .withSpecDescription("42");

    // Assert
    assertEquals("42", actualWithSpecDescriptionResult.flowExtId());
    assertEquals("42", actualWithSpecDescriptionResult.specDescription());
    assertEquals("42", actualWithSpecDescriptionResult.specExtId());
    assertEquals("Flow Description", actualWithSpecDescriptionResult.flowDescription());
    assertEquals("Flow Name", actualWithSpecDescriptionResult.flowName());
    assertEquals("Spec Name", actualWithSpecDescriptionResult.specName());
    assertEquals("Transport", actualWithSpecDescriptionResult.transport());
    assertEquals(1L, actualWithSpecDescriptionResult.lfId());
    assertEquals(1L, actualWithSpecDescriptionResult.pfId());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withSpecExtId(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withSpecExtId(String)}
   */
  @Test
  @DisplayName("Test withSpecExtId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withSpecExtId(String)"})
  void testWithSpecExtId() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowKey actualWithSpecExtIdResult =
        immutablePhysicalFlowKey.withSpecExtId("42");

    // Assert
    assertSame(immutablePhysicalFlowKey, actualWithSpecExtIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withSpecExtId(String)}.
   *
   * <ul>
   *   <li>Then return flowExtId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withSpecExtId(String)}
   */
  @Test
  @DisplayName("Test withSpecExtId(String); then return flowExtId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withSpecExtId(String)"})
  void testWithSpecExtId_thenReturnFlowExtIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowKey actualWithSpecExtIdResult =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("Spec Ext Id")
            .specName("Spec Name")
            .transport("Transport")
            .build()
            .withSpecExtId("42");

    // Assert
    assertEquals("42", actualWithSpecExtIdResult.flowExtId());
    assertEquals("42", actualWithSpecExtIdResult.specExtId());
    assertEquals("Flow Description", actualWithSpecExtIdResult.flowDescription());
    assertEquals("Flow Name", actualWithSpecExtIdResult.flowName());
    assertEquals("Spec Description", actualWithSpecExtIdResult.specDescription());
    assertEquals("Spec Name", actualWithSpecExtIdResult.specName());
    assertEquals("Transport", actualWithSpecExtIdResult.transport());
    assertEquals(1L, actualWithSpecExtIdResult.lfId());
    assertEquals(1L, actualWithSpecExtIdResult.pfId());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withSpecName(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withSpecName(String)}
   */
  @Test
  @DisplayName("Test withSpecName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withSpecName(String)"})
  void testWithSpecName() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("42")
            .transport("Transport")
            .build();

    // Act
    ImmutablePhysicalFlowKey actualWithSpecNameResult = immutablePhysicalFlowKey.withSpecName("42");

    // Assert
    assertSame(immutablePhysicalFlowKey, actualWithSpecNameResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withSpecName(String)}.
   *
   * <ul>
   *   <li>Then return flowExtId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withSpecName(String)}
   */
  @Test
  @DisplayName("Test withSpecName(String); then return flowExtId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withSpecName(String)"})
  void testWithSpecName_thenReturnFlowExtIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowKey actualWithSpecNameResult =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build()
            .withSpecName("42");

    // Assert
    assertEquals("42", actualWithSpecNameResult.flowExtId());
    assertEquals("42", actualWithSpecNameResult.specExtId());
    assertEquals("42", actualWithSpecNameResult.specName());
    assertEquals("Flow Description", actualWithSpecNameResult.flowDescription());
    assertEquals("Flow Name", actualWithSpecNameResult.flowName());
    assertEquals("Spec Description", actualWithSpecNameResult.specDescription());
    assertEquals("Transport", actualWithSpecNameResult.transport());
    assertEquals(1L, actualWithSpecNameResult.lfId());
    assertEquals(1L, actualWithSpecNameResult.pfId());
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withTransport(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withTransport(String)}
   */
  @Test
  @DisplayName("Test withTransport(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withTransport(String)"})
  void testWithTransport() {
    // Arrange
    ImmutablePhysicalFlowKey immutablePhysicalFlowKey =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("42")
            .build();

    // Act
    ImmutablePhysicalFlowKey actualWithTransportResult =
        immutablePhysicalFlowKey.withTransport("42");

    // Assert
    assertSame(immutablePhysicalFlowKey, actualWithTransportResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowKey#withTransport(String)}.
   *
   * <ul>
   *   <li>Then return flowExtId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowKey#withTransport(String)}
   */
  @Test
  @DisplayName("Test withTransport(String); then return flowExtId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalFlowKey ImmutablePhysicalFlowKey.withTransport(String)"})
  void testWithTransport_thenReturnFlowExtIdIs42() {
    // Arrange and Act
    ImmutablePhysicalFlowKey actualWithTransportResult =
        ImmutablePhysicalFlowKey.builder()
            .flowDescription("Flow Description")
            .flowExtId("42")
            .flowName("Flow Name")
            .lfId(1L)
            .pfId(1L)
            .specDescription("Spec Description")
            .specExtId("42")
            .specName("Spec Name")
            .transport("Transport")
            .build()
            .withTransport("42");

    // Assert
    assertEquals("42", actualWithTransportResult.flowExtId());
    assertEquals("42", actualWithTransportResult.specExtId());
    assertEquals("42", actualWithTransportResult.transport());
    assertEquals("Flow Description", actualWithTransportResult.flowDescription());
    assertEquals("Flow Name", actualWithTransportResult.flowName());
    assertEquals("Spec Description", actualWithTransportResult.specDescription());
    assertEquals("Spec Name", actualWithTransportResult.specName());
    assertEquals(1L, actualWithTransportResult.lfId());
    assertEquals(1L, actualWithTransportResult.pfId());
  }
}
