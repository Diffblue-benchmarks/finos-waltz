package org.finos.waltz.model.either;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.either.ImmutableLeft.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLeftDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLeft Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder<Object, Object> actualBuilderResult = ImmutableLeft.builder();
    ImmutableLeft<Object, Object> actualImmutableLeft = actualBuilderResult.left("Left").build();

    // Assert
    assertEquals("Left", actualImmutableLeft.left());
    assertFalse(actualImmutableLeft.isRight());
    assertTrue(actualImmutableLeft.isLeft());
  }

  /**
   * Test Builder {@link Builder#from(Left)}.
   *
   * <ul>
   *   <li>When builder left {@code Left} build.
   *   <li>Then builder build is builder left {@code Left} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(Left)}
   */
  @Test
  @DisplayName(
      "Test Builder from(Left); when builder left 'Left' build; then builder build is builder left 'Left' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Left)"})
  void testBuilderFrom_whenBuilderLeftLeftBuild_thenBuilderBuildIsBuilderLeftLeftBuild() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();

    Builder<Object, Object> builderResult2 = ImmutableLeft.builder();
    ImmutableLeft<Object, Object> instance = builderResult2.left("Left").build();

    // Act
    Builder<Object, Object> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLeft<Object, Object> actualImmutableLeft = builderResult.build();
    assertEquals(instance, actualImmutableLeft);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#left(Object)}.
   *
   * <ul>
   *   <li>When {@code Left}.
   *   <li>Then builder build left is {@code Left}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#left(Object)}
   */
  @Test
  @DisplayName("Test Builder left(Object); when 'Left'; then builder build left is 'Left'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.left(Object)"})
  void testBuilderLeft_whenLeft_thenBuilderBuildLeftIsLeft() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();

    // Act
    Builder<Object, Object> actualLeftResult = builderResult.left("Left");

    // Assert
    ImmutableLeft<Object, Object> immutableLeft = builderResult.build();
    assertEquals("Left", immutableLeft.left());
    assertFalse(immutableLeft.isRight());
    assertTrue(immutableLeft.isLeft());
    assertSame(builderResult, actualLeftResult);
  }

  /**
   * Test {@link ImmutableLeft#copyOf(Left)}.
   *
   * <ul>
   *   <li>When builder left {@code Left} build.
   *   <li>Then return {@code Left}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLeft#copyOf(Left)}
   */
  @Test
  @DisplayName("Test copyOf(Left); when builder left 'Left' build; then return 'Left'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLeft ImmutableLeft.copyOf(Left)"})
  void testCopyOf_whenBuilderLeftLeftBuild_thenReturnLeft() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();
    ImmutableLeft<Object, Object> instance = builderResult.left("Left").build();

    // Act
    ImmutableLeft<Object, Object> actualCopyOfResult = ImmutableLeft.copyOf(instance);

    // Assert
    assertEquals("Left", actualCopyOfResult.left());
    assertFalse(actualCopyOfResult.isRight());
    assertTrue(actualCopyOfResult.isLeft());
  }

  /**
   * Test {@link ImmutableLeft#equals(Object)}, and {@link ImmutableLeft#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLeft#equals(Object)}
   *   <li>{@link ImmutableLeft#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLeft.equals(Object)", "int ImmutableLeft.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();
    ImmutableLeft<Object, Object> immutableLeft = builderResult.left("Left").build();

    Builder<Object, Object> builderResult2 = ImmutableLeft.builder();
    ImmutableLeft<Object, Object> immutableLeft2 = builderResult2.left("Left").build();

    // Act and Assert
    assertEquals(immutableLeft, immutableLeft2);
    assertEquals(immutableLeft.hashCode(), immutableLeft2.hashCode());
  }

  /**
   * Test {@link ImmutableLeft#equals(Object)}, and {@link ImmutableLeft#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLeft#equals(Object)}
   *   <li>{@link ImmutableLeft#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLeft.equals(Object)", "int ImmutableLeft.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();
    ImmutableLeft<Object, Object> immutableLeft = builderResult.left("Left").build();

    // Act and Assert
    assertEquals(immutableLeft, immutableLeft);
    int expectedHashCodeResult = immutableLeft.hashCode();
    assertEquals(expectedHashCodeResult, immutableLeft.hashCode());
  }

  /**
   * Test {@link ImmutableLeft#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLeft#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLeft.equals(Object)", "int ImmutableLeft.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();
    ImmutableLeft<Object, Object> immutableLeft = builderResult.left(1).build();

    Builder<Object, Object> builderResult2 = ImmutableLeft.builder();

    // Act and Assert
    assertNotEquals(immutableLeft, builderResult2.left("Left").build());
  }

  /**
   * Test {@link ImmutableLeft#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLeft#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLeft.equals(Object)", "int ImmutableLeft.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();

    Builder<Object, Object> builderResult2 = ImmutableLeft.builder();
    ImmutableLeft<Object, Object> immutableLeft =
        builderResult.left(builderResult2.left("Left").build()).build();

    Builder<Object, Object> builderResult3 = ImmutableLeft.builder();

    // Act and Assert
    assertNotEquals(immutableLeft, builderResult3.left("Left").build());
  }

  /**
   * Test {@link ImmutableLeft#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLeft#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLeft.equals(Object)", "int ImmutableLeft.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();

    // Act and Assert
    assertNotEquals(builderResult.left("Left").build(), null);
  }

  /**
   * Test {@link ImmutableLeft#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLeft#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLeft.equals(Object)", "int ImmutableLeft.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();

    // Act and Assert
    assertNotEquals(builderResult.left("Left").build(), "Different type to ImmutableLeft");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLeft#toString()}
   *   <li>{@link ImmutableLeft#left()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ImmutableLeft.left()", "String ImmutableLeft.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();
    ImmutableLeft<Object, Object> immutableLeft = builderResult.left("Left").build();

    // Act
    String actualToStringResult = immutableLeft.toString();

    // Assert
    assertEquals("Left", immutableLeft.left());
    assertEquals("Left{left=Left}", actualToStringResult);
  }

  /**
   * Test {@link ImmutableLeft#withLeft(Object)}.
   *
   * <ul>
   *   <li>Given builder left {@code left} build.
   *   <li>When {@code left}.
   *   <li>Then return builder left {@code left} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLeft#withLeft(Object)}
   */
  @Test
  @DisplayName(
      "Test withLeft(Object); given builder left 'left' build; when 'left'; then return builder left 'left' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLeft ImmutableLeft.withLeft(Object)"})
  void testWithLeft_givenBuilderLeftLeftBuild_whenLeft_thenReturnBuilderLeftLeftBuild() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();
    ImmutableLeft<Object, Object> immutableLeft = builderResult.left("left").build();

    // Act
    ImmutableLeft<Object, Object> actualWithLeftResult = immutableLeft.withLeft("left");

    // Assert
    assertSame(immutableLeft, actualWithLeftResult);
  }

  /**
   * Test {@link ImmutableLeft#withLeft(Object)}.
   *
   * <ul>
   *   <li>Given builder left {@code Left} build.
   *   <li>When {@code Value}.
   *   <li>Then return left is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLeft#withLeft(Object)}
   */
  @Test
  @DisplayName(
      "Test withLeft(Object); given builder left 'Left' build; when 'Value'; then return left is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLeft ImmutableLeft.withLeft(Object)"})
  void testWithLeft_givenBuilderLeftLeftBuild_whenValue_thenReturnLeftIsValue() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();

    // Act
    ImmutableLeft<Object, Object> actualWithLeftResult =
        builderResult.left("Left").build().withLeft("Value");

    // Assert
    assertEquals("Value", actualWithLeftResult.left());
    assertFalse(actualWithLeftResult.isRight());
    assertTrue(actualWithLeftResult.isLeft());
  }
}
