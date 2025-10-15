package org.finos.waltz.model.either;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.either.ImmutableRight.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRightDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRight Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder<Object, Object> actualBuilderResult = ImmutableRight.builder();
    ImmutableRight<Object, Object> actualImmutableRight =
        actualBuilderResult.right("Right").build();

    // Assert
    assertEquals("Right", actualImmutableRight.right());
    assertFalse(actualImmutableRight.isLeft());
    assertTrue(actualImmutableRight.isRight());
  }

  /**
   * Test Builder {@link Builder#from(Right)}.
   *
   * <ul>
   *   <li>Then builder build is builder right {@code Right} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(Right)}
   */
  @Test
  @DisplayName("Test Builder from(Right); then builder build is builder right 'Right' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Right)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderRightRightBuild() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();

    Builder<Object, Object> builderResult2 = ImmutableRight.builder();
    ImmutableRight<Object, Object> instance = builderResult2.right("Right").build();

    // Act
    Builder<Object, Object> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRight<Object, Object> actualImmutableRight = builderResult.build();
    assertEquals(instance, actualImmutableRight);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#right(Object)}.
   *
   * <ul>
   *   <li>When {@code Right}.
   *   <li>Then builder build right is {@code Right}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#right(Object)}
   */
  @Test
  @DisplayName("Test Builder right(Object); when 'Right'; then builder build right is 'Right'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.right(Object)"})
  void testBuilderRight_whenRight_thenBuilderBuildRightIsRight() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();

    // Act
    Builder<Object, Object> actualRightResult = builderResult.right("Right");

    // Assert
    ImmutableRight<Object, Object> immutableRight = builderResult.build();
    assertEquals("Right", immutableRight.right());
    assertFalse(immutableRight.isLeft());
    assertTrue(immutableRight.isRight());
    assertSame(builderResult, actualRightResult);
  }

  /**
   * Test {@link ImmutableRight#copyOf(Right)}.
   *
   * <ul>
   *   <li>When builder right {@code Right} build.
   *   <li>Then return {@code Right}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRight#copyOf(Right)}
   */
  @Test
  @DisplayName("Test copyOf(Right); when builder right 'Right' build; then return 'Right'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRight ImmutableRight.copyOf(Right)"})
  void testCopyOf_whenBuilderRightRightBuild_thenReturnRight() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();
    ImmutableRight<Object, Object> instance = builderResult.right("Right").build();

    // Act
    ImmutableRight<Object, Object> actualCopyOfResult = ImmutableRight.copyOf(instance);

    // Assert
    assertEquals("Right", actualCopyOfResult.right());
    assertFalse(actualCopyOfResult.isLeft());
    assertTrue(actualCopyOfResult.isRight());
  }

  /**
   * Test {@link ImmutableRight#equals(Object)}, and {@link ImmutableRight#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRight#equals(Object)}
   *   <li>{@link ImmutableRight#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRight.equals(Object)", "int ImmutableRight.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();
    ImmutableRight<Object, Object> immutableRight = builderResult.right("Right").build();

    Builder<Object, Object> builderResult2 = ImmutableRight.builder();
    ImmutableRight<Object, Object> immutableRight2 = builderResult2.right("Right").build();

    // Act and Assert
    assertEquals(immutableRight, immutableRight2);
    assertEquals(immutableRight.hashCode(), immutableRight2.hashCode());
  }

  /**
   * Test {@link ImmutableRight#equals(Object)}, and {@link ImmutableRight#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRight#equals(Object)}
   *   <li>{@link ImmutableRight#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRight.equals(Object)", "int ImmutableRight.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();
    ImmutableRight<Object, Object> immutableRight = builderResult.right("Right").build();

    // Act and Assert
    assertEquals(immutableRight, immutableRight);
    int expectedHashCodeResult = immutableRight.hashCode();
    assertEquals(expectedHashCodeResult, immutableRight.hashCode());
  }

  /**
   * Test {@link ImmutableRight#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRight#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRight.equals(Object)", "int ImmutableRight.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();
    ImmutableRight<Object, Object> immutableRight = builderResult.right(1).build();

    Builder<Object, Object> builderResult2 = ImmutableRight.builder();

    // Act and Assert
    assertNotEquals(immutableRight, builderResult2.right("Right").build());
  }

  /**
   * Test {@link ImmutableRight#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRight#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRight.equals(Object)", "int ImmutableRight.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();

    Builder<Object, Object> builderResult2 = ImmutableRight.builder();
    ImmutableRight<Object, Object> immutableRight =
        builderResult.right(builderResult2.right("Right").build()).build();

    Builder<Object, Object> builderResult3 = ImmutableRight.builder();

    // Act and Assert
    assertNotEquals(immutableRight, builderResult3.right("Right").build());
  }

  /**
   * Test {@link ImmutableRight#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRight#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRight.equals(Object)", "int ImmutableRight.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();

    // Act and Assert
    assertNotEquals(builderResult.right("Right").build(), null);
  }

  /**
   * Test {@link ImmutableRight#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRight#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRight.equals(Object)", "int ImmutableRight.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();

    // Act and Assert
    assertNotEquals(builderResult.right("Right").build(), "Different type to ImmutableRight");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRight#toString()}
   *   <li>{@link ImmutableRight#right()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ImmutableRight.right()", "String ImmutableRight.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();
    ImmutableRight<Object, Object> immutableRight = builderResult.right("Right").build();

    // Act
    String actualToStringResult = immutableRight.toString();

    // Assert
    assertEquals("Right", immutableRight.right());
    assertEquals("Right{right=Right}", actualToStringResult);
  }

  /**
   * Test {@link ImmutableRight#withRight(Object)}.
   *
   * <ul>
   *   <li>Given builder right forty-two build.
   *   <li>Then return builder right forty-two build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRight#withRight(Object)}
   */
  @Test
  @DisplayName(
      "Test withRight(Object); given builder right forty-two build; then return builder right forty-two build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRight ImmutableRight.withRight(Object)"})
  void testWithRight_givenBuilderRightFortyTwoBuild_thenReturnBuilderRightFortyTwoBuild() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();
    ImmutableRight<Object, Object> immutableRight = builderResult.right(42).build();

    // Act
    ImmutableRight<Object, Object> actualWithRightResult = immutableRight.withRight(42);

    // Assert
    assertSame(immutableRight, actualWithRightResult);
  }

  /**
   * Test {@link ImmutableRight#withRight(Object)}.
   *
   * <ul>
   *   <li>Given builder right {@code Right} build.
   *   <li>When {@code Value}.
   *   <li>Then return right is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRight#withRight(Object)}
   */
  @Test
  @DisplayName(
      "Test withRight(Object); given builder right 'Right' build; when 'Value'; then return right is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRight ImmutableRight.withRight(Object)"})
  void testWithRight_givenBuilderRightRightBuild_whenValue_thenReturnRightIsValue() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();

    // Act
    ImmutableRight<Object, Object> actualWithRightResult =
        builderResult.right("Right").build().withRight("Value");

    // Assert
    assertEquals("Value", actualWithRightResult.right());
    assertFalse(actualWithRightResult.isLeft());
    assertTrue(actualWithRightResult.isRight());
  }
}
