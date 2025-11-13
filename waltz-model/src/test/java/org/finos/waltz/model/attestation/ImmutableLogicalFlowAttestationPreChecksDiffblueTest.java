package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.attestation.ImmutableLogicalFlowAttestationPreChecks.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowAttestationPreChecksDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLogicalFlowAttestationPreChecks Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableLogicalFlowAttestationPreChecks actualImmutableLogicalFlowAttestationPreChecks =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build();

    // Assert
    assertEquals(3, actualImmutableLogicalFlowAttestationPreChecks.deprecatedCount());
    assertEquals(3, actualImmutableLogicalFlowAttestationPreChecks.flowCount());
    assertEquals(3, actualImmutableLogicalFlowAttestationPreChecks.unknownCount());
    assertTrue(actualImmutableLogicalFlowAttestationPreChecks.exemptFromDeprecatedCheck());
    assertTrue(actualImmutableLogicalFlowAttestationPreChecks.exemptFromFlowCountCheck());
    assertTrue(actualImmutableLogicalFlowAttestationPreChecks.exemptFromUnknownCheck());
  }

  /**
   * Test Builder {@link Builder#deprecatedCount(int)}.
   *
   * <p>Method under test: {@link Builder#deprecatedCount(int)}
   */
  @Test
  @DisplayName("Test Builder deprecatedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.deprecatedCount(int)"})
  void testBuilderDeprecatedCount() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act
    Builder actualDeprecatedCountResult = builderResult.deprecatedCount(3);

    // Assert
    assertSame(builderResult, actualDeprecatedCountResult);
  }

  /**
   * Test Builder {@link Builder#exemptFromDeprecatedCheck(boolean)}.
   *
   * <p>Method under test: {@link Builder#exemptFromDeprecatedCheck(boolean)}
   */
  @Test
  @DisplayName("Test Builder exemptFromDeprecatedCheck(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.exemptFromDeprecatedCheck(boolean)"})
  void testBuilderExemptFromDeprecatedCheck() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act
    Builder actualExemptFromDeprecatedCheckResult = builderResult.exemptFromDeprecatedCheck(true);

    // Assert
    assertSame(builderResult, actualExemptFromDeprecatedCheckResult);
  }

  /**
   * Test Builder {@link Builder#exemptFromFlowCountCheck(boolean)}.
   *
   * <p>Method under test: {@link Builder#exemptFromFlowCountCheck(boolean)}
   */
  @Test
  @DisplayName("Test Builder exemptFromFlowCountCheck(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.exemptFromFlowCountCheck(boolean)"})
  void testBuilderExemptFromFlowCountCheck() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act
    Builder actualExemptFromFlowCountCheckResult = builderResult.exemptFromFlowCountCheck(true);

    // Assert
    assertSame(builderResult, actualExemptFromFlowCountCheckResult);
  }

  /**
   * Test Builder {@link Builder#exemptFromUnknownCheck(boolean)}.
   *
   * <p>Method under test: {@link Builder#exemptFromUnknownCheck(boolean)}
   */
  @Test
  @DisplayName("Test Builder exemptFromUnknownCheck(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.exemptFromUnknownCheck(boolean)"})
  void testBuilderExemptFromUnknownCheck() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act
    Builder actualExemptFromUnknownCheckResult = builderResult.exemptFromUnknownCheck(true);

    // Assert
    assertSame(builderResult, actualExemptFromUnknownCheckResult);
  }

  /**
   * Test Builder {@link Builder#flowCount(int)}.
   *
   * <p>Method under test: {@link Builder#flowCount(int)}
   */
  @Test
  @DisplayName("Test Builder flowCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flowCount(int)"})
  void testBuilderFlowCount() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act
    Builder actualFlowCountResult = builderResult.flowCount(3);

    // Assert
    assertSame(builderResult, actualFlowCountResult);
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowAttestationPreChecks)}.
   *
   * <p>Method under test: {@link Builder#from(LogicalFlowAttestationPreChecks)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowAttestationPreChecks)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowAttestationPreChecks)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();
    ImmutableLogicalFlowAttestationPreChecks instance =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLogicalFlowAttestationPreChecks actualImmutableLogicalFlowAttestationPreChecks =
        builderResult.build();
    assertEquals(instance, actualImmutableLogicalFlowAttestationPreChecks);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#unknownCount(int)}.
   *
   * <p>Method under test: {@link Builder#unknownCount(int)}
   */
  @Test
  @DisplayName("Test Builder unknownCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.unknownCount(int)"})
  void testBuilderUnknownCount() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act
    Builder actualUnknownCountResult = builderResult.unknownCount(3);

    // Assert
    assertSame(builderResult, actualUnknownCountResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#copyOf(LogicalFlowAttestationPreChecks)}.
   *
   * <ul>
   *   <li>Then return deprecatedCount is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowAttestationPreChecks#copyOf(LogicalFlowAttestationPreChecks)}
   */
  @Test
  @DisplayName("Test copyOf(LogicalFlowAttestationPreChecks); then return deprecatedCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowAttestationPreChecks ImmutableLogicalFlowAttestationPreChecks.copyOf(LogicalFlowAttestationPreChecks)"
  })
  void testCopyOf_thenReturnDeprecatedCountIsThree() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks instance =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build();

    // Act
    ImmutableLogicalFlowAttestationPreChecks actualCopyOfResult =
        ImmutableLogicalFlowAttestationPreChecks.copyOf(instance);

    // Assert
    assertEquals(3, actualCopyOfResult.deprecatedCount());
    assertEquals(3, actualCopyOfResult.flowCount());
    assertEquals(3, actualCopyOfResult.unknownCount());
    assertTrue(actualCopyOfResult.exemptFromDeprecatedCheck());
    assertTrue(actualCopyOfResult.exemptFromFlowCountCheck());
    assertTrue(actualCopyOfResult.exemptFromUnknownCheck());
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}, and {@link
   * ImmutableLogicalFlowAttestationPreChecks#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowAttestationPreChecks#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowAttestationPreChecks.equals(Object)",
    "int ImmutableLogicalFlowAttestationPreChecks.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks immutableLogicalFlowAttestationPreChecks =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build();
    ImmutableLogicalFlowAttestationPreChecks immutableLogicalFlowAttestationPreChecks2 =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build();

    // Act and Assert
    assertEquals(
        immutableLogicalFlowAttestationPreChecks, immutableLogicalFlowAttestationPreChecks2);
    assertEquals(
        immutableLogicalFlowAttestationPreChecks.hashCode(),
        immutableLogicalFlowAttestationPreChecks2.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}, and {@link
   * ImmutableLogicalFlowAttestationPreChecks#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}
   *   <li>{@link ImmutableLogicalFlowAttestationPreChecks#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowAttestationPreChecks.equals(Object)",
    "int ImmutableLogicalFlowAttestationPreChecks.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks immutableLogicalFlowAttestationPreChecks =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build();

    // Act and Assert
    assertEquals(
        immutableLogicalFlowAttestationPreChecks, immutableLogicalFlowAttestationPreChecks);
    int expectedHashCodeResult = immutableLogicalFlowAttestationPreChecks.hashCode();
    assertEquals(expectedHashCodeResult, immutableLogicalFlowAttestationPreChecks.hashCode());
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowAttestationPreChecks.equals(Object)",
    "int ImmutableLogicalFlowAttestationPreChecks.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks immutableLogicalFlowAttestationPreChecks =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(1)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowAttestationPreChecks,
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowAttestationPreChecks.equals(Object)",
    "int ImmutableLogicalFlowAttestationPreChecks.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks immutableLogicalFlowAttestationPreChecks =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(false)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowAttestationPreChecks,
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowAttestationPreChecks.equals(Object)",
    "int ImmutableLogicalFlowAttestationPreChecks.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks immutableLogicalFlowAttestationPreChecks =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(false)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowAttestationPreChecks,
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowAttestationPreChecks.equals(Object)",
    "int ImmutableLogicalFlowAttestationPreChecks.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks immutableLogicalFlowAttestationPreChecks =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(false)
            .flowCount(3)
            .unknownCount(3)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowAttestationPreChecks,
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowAttestationPreChecks.equals(Object)",
    "int ImmutableLogicalFlowAttestationPreChecks.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks immutableLogicalFlowAttestationPreChecks =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(1)
            .unknownCount(3)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowAttestationPreChecks,
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowAttestationPreChecks.equals(Object)",
    "int ImmutableLogicalFlowAttestationPreChecks.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks immutableLogicalFlowAttestationPreChecks =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableLogicalFlowAttestationPreChecks,
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowAttestationPreChecks.equals(Object)",
    "int ImmutableLogicalFlowAttestationPreChecks.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowAttestationPreChecks#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLogicalFlowAttestationPreChecks.equals(Object)",
    "int ImmutableLogicalFlowAttestationPreChecks.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build(),
        "Different type to ImmutableLogicalFlowAttestationPreChecks");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLogicalFlowAttestationPreChecks#toString()}
   *   <li>{@link ImmutableLogicalFlowAttestationPreChecks#deprecatedCount()}
   *   <li>{@link ImmutableLogicalFlowAttestationPreChecks#exemptFromDeprecatedCheck()}
   *   <li>{@link ImmutableLogicalFlowAttestationPreChecks#exemptFromFlowCountCheck()}
   *   <li>{@link ImmutableLogicalFlowAttestationPreChecks#exemptFromUnknownCheck()}
   *   <li>{@link ImmutableLogicalFlowAttestationPreChecks#flowCount()}
   *   <li>{@link ImmutableLogicalFlowAttestationPreChecks#unknownCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableLogicalFlowAttestationPreChecks.deprecatedCount()",
    "boolean ImmutableLogicalFlowAttestationPreChecks.exemptFromDeprecatedCheck()",
    "boolean ImmutableLogicalFlowAttestationPreChecks.exemptFromFlowCountCheck()",
    "boolean ImmutableLogicalFlowAttestationPreChecks.exemptFromUnknownCheck()",
    "int ImmutableLogicalFlowAttestationPreChecks.flowCount()",
    "String ImmutableLogicalFlowAttestationPreChecks.toString()",
    "int ImmutableLogicalFlowAttestationPreChecks.unknownCount()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks immutableLogicalFlowAttestationPreChecks =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build();

    // Act
    String actualToStringResult = immutableLogicalFlowAttestationPreChecks.toString();
    int actualDeprecatedCountResult = immutableLogicalFlowAttestationPreChecks.deprecatedCount();
    boolean actualExemptFromDeprecatedCheckResult =
        immutableLogicalFlowAttestationPreChecks.exemptFromDeprecatedCheck();
    boolean actualExemptFromFlowCountCheckResult =
        immutableLogicalFlowAttestationPreChecks.exemptFromFlowCountCheck();
    boolean actualExemptFromUnknownCheckResult =
        immutableLogicalFlowAttestationPreChecks.exemptFromUnknownCheck();
    int actualFlowCountResult = immutableLogicalFlowAttestationPreChecks.flowCount();

    // Assert
    assertEquals(
        "LogicalFlowAttestationPreChecks{flowCount=3, deprecatedCount=3, unknownCount=3, exemptFromUnknownCheck=true,"
            + " exemptFromDeprecatedCheck=true, exemptFromFlowCountCheck=true}",
        actualToStringResult);
    assertEquals(3, actualDeprecatedCountResult);
    assertEquals(3, actualFlowCountResult);
    assertEquals(3, immutableLogicalFlowAttestationPreChecks.unknownCount());
    assertTrue(actualExemptFromDeprecatedCheckResult);
    assertTrue(actualExemptFromFlowCountCheckResult);
    assertTrue(actualExemptFromUnknownCheckResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#withDeprecatedCount(int)}.
   *
   * <p>Method under test: {@link ImmutableLogicalFlowAttestationPreChecks#withDeprecatedCount(int)}
   */
  @Test
  @DisplayName("Test withDeprecatedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowAttestationPreChecks ImmutableLogicalFlowAttestationPreChecks.withDeprecatedCount(int)"
  })
  void testWithDeprecatedCount() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks immutableLogicalFlowAttestationPreChecks =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(42)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build();

    // Act
    ImmutableLogicalFlowAttestationPreChecks actualWithDeprecatedCountResult =
        immutableLogicalFlowAttestationPreChecks.withDeprecatedCount(42);

    // Assert
    assertSame(immutableLogicalFlowAttestationPreChecks, actualWithDeprecatedCountResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#withDeprecatedCount(int)}.
   *
   * <ul>
   *   <li>Then return flowCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowAttestationPreChecks#withDeprecatedCount(int)}
   */
  @Test
  @DisplayName("Test withDeprecatedCount(int); then return flowCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowAttestationPreChecks ImmutableLogicalFlowAttestationPreChecks.withDeprecatedCount(int)"
  })
  void testWithDeprecatedCount_thenReturnFlowCountIsThree() {
    // Arrange and Act
    ImmutableLogicalFlowAttestationPreChecks actualWithDeprecatedCountResult =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build()
            .withDeprecatedCount(42);

    // Assert
    assertEquals(3, actualWithDeprecatedCountResult.flowCount());
    assertEquals(3, actualWithDeprecatedCountResult.unknownCount());
    assertEquals(42, actualWithDeprecatedCountResult.deprecatedCount());
    assertTrue(actualWithDeprecatedCountResult.exemptFromDeprecatedCheck());
    assertTrue(actualWithDeprecatedCountResult.exemptFromFlowCountCheck());
    assertTrue(actualWithDeprecatedCountResult.exemptFromUnknownCheck());
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#withExemptFromDeprecatedCheck(boolean)}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowAttestationPreChecks#withExemptFromDeprecatedCheck(boolean)}
   */
  @Test
  @DisplayName("Test withExemptFromDeprecatedCheck(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowAttestationPreChecks ImmutableLogicalFlowAttestationPreChecks.withExemptFromDeprecatedCheck(boolean)"
  })
  void testWithExemptFromDeprecatedCheck() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks immutableLogicalFlowAttestationPreChecks =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build();

    // Act
    ImmutableLogicalFlowAttestationPreChecks actualWithExemptFromDeprecatedCheckResult =
        immutableLogicalFlowAttestationPreChecks.withExemptFromDeprecatedCheck(true);

    // Assert
    assertSame(immutableLogicalFlowAttestationPreChecks, actualWithExemptFromDeprecatedCheckResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#withExemptFromDeprecatedCheck(boolean)}.
   *
   * <ul>
   *   <li>Then return deprecatedCount is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowAttestationPreChecks#withExemptFromDeprecatedCheck(boolean)}
   */
  @Test
  @DisplayName("Test withExemptFromDeprecatedCheck(boolean); then return deprecatedCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowAttestationPreChecks ImmutableLogicalFlowAttestationPreChecks.withExemptFromDeprecatedCheck(boolean)"
  })
  void testWithExemptFromDeprecatedCheck_thenReturnDeprecatedCountIsThree() {
    // Arrange and Act
    ImmutableLogicalFlowAttestationPreChecks actualWithExemptFromDeprecatedCheckResult =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(false)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build()
            .withExemptFromDeprecatedCheck(true);

    // Assert
    assertEquals(3, actualWithExemptFromDeprecatedCheckResult.deprecatedCount());
    assertEquals(3, actualWithExemptFromDeprecatedCheckResult.flowCount());
    assertEquals(3, actualWithExemptFromDeprecatedCheckResult.unknownCount());
    assertTrue(actualWithExemptFromDeprecatedCheckResult.exemptFromDeprecatedCheck());
    assertTrue(actualWithExemptFromDeprecatedCheckResult.exemptFromFlowCountCheck());
    assertTrue(actualWithExemptFromDeprecatedCheckResult.exemptFromUnknownCheck());
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#withExemptFromFlowCountCheck(boolean)}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowAttestationPreChecks#withExemptFromFlowCountCheck(boolean)}
   */
  @Test
  @DisplayName("Test withExemptFromFlowCountCheck(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowAttestationPreChecks ImmutableLogicalFlowAttestationPreChecks.withExemptFromFlowCountCheck(boolean)"
  })
  void testWithExemptFromFlowCountCheck() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks immutableLogicalFlowAttestationPreChecks =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build();

    // Act
    ImmutableLogicalFlowAttestationPreChecks actualWithExemptFromFlowCountCheckResult =
        immutableLogicalFlowAttestationPreChecks.withExemptFromFlowCountCheck(true);

    // Assert
    assertSame(immutableLogicalFlowAttestationPreChecks, actualWithExemptFromFlowCountCheckResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#withExemptFromFlowCountCheck(boolean)}.
   *
   * <ul>
   *   <li>Then return deprecatedCount is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowAttestationPreChecks#withExemptFromFlowCountCheck(boolean)}
   */
  @Test
  @DisplayName("Test withExemptFromFlowCountCheck(boolean); then return deprecatedCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowAttestationPreChecks ImmutableLogicalFlowAttestationPreChecks.withExemptFromFlowCountCheck(boolean)"
  })
  void testWithExemptFromFlowCountCheck_thenReturnDeprecatedCountIsThree() {
    // Arrange and Act
    ImmutableLogicalFlowAttestationPreChecks actualWithExemptFromFlowCountCheckResult =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(false)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build()
            .withExemptFromFlowCountCheck(true);

    // Assert
    assertEquals(3, actualWithExemptFromFlowCountCheckResult.deprecatedCount());
    assertEquals(3, actualWithExemptFromFlowCountCheckResult.flowCount());
    assertEquals(3, actualWithExemptFromFlowCountCheckResult.unknownCount());
    assertTrue(actualWithExemptFromFlowCountCheckResult.exemptFromDeprecatedCheck());
    assertTrue(actualWithExemptFromFlowCountCheckResult.exemptFromFlowCountCheck());
    assertTrue(actualWithExemptFromFlowCountCheckResult.exemptFromUnknownCheck());
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#withExemptFromUnknownCheck(boolean)}.
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowAttestationPreChecks#withExemptFromUnknownCheck(boolean)}
   */
  @Test
  @DisplayName("Test withExemptFromUnknownCheck(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowAttestationPreChecks ImmutableLogicalFlowAttestationPreChecks.withExemptFromUnknownCheck(boolean)"
  })
  void testWithExemptFromUnknownCheck() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks immutableLogicalFlowAttestationPreChecks =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build();

    // Act
    ImmutableLogicalFlowAttestationPreChecks actualWithExemptFromUnknownCheckResult =
        immutableLogicalFlowAttestationPreChecks.withExemptFromUnknownCheck(true);

    // Assert
    assertSame(immutableLogicalFlowAttestationPreChecks, actualWithExemptFromUnknownCheckResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#withExemptFromUnknownCheck(boolean)}.
   *
   * <ul>
   *   <li>Then return deprecatedCount is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableLogicalFlowAttestationPreChecks#withExemptFromUnknownCheck(boolean)}
   */
  @Test
  @DisplayName("Test withExemptFromUnknownCheck(boolean); then return deprecatedCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowAttestationPreChecks ImmutableLogicalFlowAttestationPreChecks.withExemptFromUnknownCheck(boolean)"
  })
  void testWithExemptFromUnknownCheck_thenReturnDeprecatedCountIsThree() {
    // Arrange and Act
    ImmutableLogicalFlowAttestationPreChecks actualWithExemptFromUnknownCheckResult =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(false)
            .flowCount(3)
            .unknownCount(3)
            .build()
            .withExemptFromUnknownCheck(true);

    // Assert
    assertEquals(3, actualWithExemptFromUnknownCheckResult.deprecatedCount());
    assertEquals(3, actualWithExemptFromUnknownCheckResult.flowCount());
    assertEquals(3, actualWithExemptFromUnknownCheckResult.unknownCount());
    assertTrue(actualWithExemptFromUnknownCheckResult.exemptFromDeprecatedCheck());
    assertTrue(actualWithExemptFromUnknownCheckResult.exemptFromFlowCountCheck());
    assertTrue(actualWithExemptFromUnknownCheckResult.exemptFromUnknownCheck());
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#withFlowCount(int)}.
   *
   * <p>Method under test: {@link ImmutableLogicalFlowAttestationPreChecks#withFlowCount(int)}
   */
  @Test
  @DisplayName("Test withFlowCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowAttestationPreChecks ImmutableLogicalFlowAttestationPreChecks.withFlowCount(int)"
  })
  void testWithFlowCount() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks immutableLogicalFlowAttestationPreChecks =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(42)
            .unknownCount(3)
            .build();

    // Act
    ImmutableLogicalFlowAttestationPreChecks actualWithFlowCountResult =
        immutableLogicalFlowAttestationPreChecks.withFlowCount(42);

    // Assert
    assertSame(immutableLogicalFlowAttestationPreChecks, actualWithFlowCountResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#withFlowCount(int)}.
   *
   * <ul>
   *   <li>Then return deprecatedCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowAttestationPreChecks#withFlowCount(int)}
   */
  @Test
  @DisplayName("Test withFlowCount(int); then return deprecatedCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowAttestationPreChecks ImmutableLogicalFlowAttestationPreChecks.withFlowCount(int)"
  })
  void testWithFlowCount_thenReturnDeprecatedCountIsThree() {
    // Arrange and Act
    ImmutableLogicalFlowAttestationPreChecks actualWithFlowCountResult =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build()
            .withFlowCount(42);

    // Assert
    assertEquals(3, actualWithFlowCountResult.deprecatedCount());
    assertEquals(3, actualWithFlowCountResult.unknownCount());
    assertEquals(42, actualWithFlowCountResult.flowCount());
    assertTrue(actualWithFlowCountResult.exemptFromDeprecatedCheck());
    assertTrue(actualWithFlowCountResult.exemptFromFlowCountCheck());
    assertTrue(actualWithFlowCountResult.exemptFromUnknownCheck());
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#withUnknownCount(int)}.
   *
   * <p>Method under test: {@link ImmutableLogicalFlowAttestationPreChecks#withUnknownCount(int)}
   */
  @Test
  @DisplayName("Test withUnknownCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowAttestationPreChecks ImmutableLogicalFlowAttestationPreChecks.withUnknownCount(int)"
  })
  void testWithUnknownCount() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks immutableLogicalFlowAttestationPreChecks =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(42)
            .build();

    // Act
    ImmutableLogicalFlowAttestationPreChecks actualWithUnknownCountResult =
        immutableLogicalFlowAttestationPreChecks.withUnknownCount(42);

    // Assert
    assertSame(immutableLogicalFlowAttestationPreChecks, actualWithUnknownCountResult);
  }

  /**
   * Test {@link ImmutableLogicalFlowAttestationPreChecks#withUnknownCount(int)}.
   *
   * <ul>
   *   <li>Then return deprecatedCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLogicalFlowAttestationPreChecks#withUnknownCount(int)}
   */
  @Test
  @DisplayName("Test withUnknownCount(int); then return deprecatedCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLogicalFlowAttestationPreChecks ImmutableLogicalFlowAttestationPreChecks.withUnknownCount(int)"
  })
  void testWithUnknownCount_thenReturnDeprecatedCountIsThree() {
    // Arrange and Act
    ImmutableLogicalFlowAttestationPreChecks actualWithUnknownCountResult =
        ImmutableLogicalFlowAttestationPreChecks.builder()
            .deprecatedCount(3)
            .exemptFromDeprecatedCheck(true)
            .exemptFromFlowCountCheck(true)
            .exemptFromUnknownCheck(true)
            .flowCount(3)
            .unknownCount(3)
            .build()
            .withUnknownCount(42);

    // Assert
    assertEquals(3, actualWithUnknownCountResult.deprecatedCount());
    assertEquals(3, actualWithUnknownCountResult.flowCount());
    assertEquals(42, actualWithUnknownCountResult.unknownCount());
    assertTrue(actualWithUnknownCountResult.exemptFromDeprecatedCheck());
    assertTrue(actualWithUnknownCountResult.exemptFromFlowCountCheck());
    assertTrue(actualWithUnknownCountResult.exemptFromUnknownCheck());
  }
}
