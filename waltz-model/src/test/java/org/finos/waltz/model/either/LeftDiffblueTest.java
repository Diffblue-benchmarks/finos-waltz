package org.finos.waltz.model.either;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.either.ImmutableLeft.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LeftDiffblueTest {
  /**
   * Test {@link Left#right()}.
   *
   * <p>Method under test: {@link Left#right()}
   */
  @Test
  @DisplayName("Test right()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Left.right()"})
  void testRight() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builderResult.left("Left").build().right());
  }

  /**
   * Test {@link Left#isRight()}.
   *
   * <p>Method under test: {@link Left#isRight()}
   */
  @Test
  @DisplayName("Test isRight()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Left.isRight()"})
  void testIsRight() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();

    // Act and Assert
    assertFalse(builderResult.left("Left").build().isRight());
  }

  /**
   * Test {@link Left#isLeft()}.
   *
   * <p>Method under test: {@link Left#isLeft()}
   */
  @Test
  @DisplayName("Test isLeft()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Left.isLeft()"})
  void testIsLeft() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();

    // Act and Assert
    assertTrue(builderResult.left("Left").build().isLeft());
  }
}
