package org.finos.waltz.model.either;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.either.ImmutableRight.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RightDiffblueTest {
  /**
   * Test {@link Right#left()}.
   *
   * <p>Method under test: {@link Right#left()}
   */
  @Test
  @DisplayName("Test left()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Right.left()"})
  void testLeft() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builderResult.right("Right").build().left());
  }

  /**
   * Test {@link Right#isRight()}.
   *
   * <p>Method under test: {@link Right#isRight()}
   */
  @Test
  @DisplayName("Test isRight()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Right.isRight()"})
  void testIsRight() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();

    // Act and Assert
    assertTrue(builderResult.right("Right").build().isRight());
  }

  /**
   * Test {@link Right#isLeft()}.
   *
   * <p>Method under test: {@link Right#isLeft()}
   */
  @Test
  @DisplayName("Test isLeft()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Right.isLeft()"})
  void testIsLeft() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();

    // Act and Assert
    assertFalse(builderResult.right("Right").build().isLeft());
  }
}
