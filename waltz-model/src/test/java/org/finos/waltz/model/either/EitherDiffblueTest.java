package org.finos.waltz.model.either;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EitherDiffblueTest {
  /**
   * Test {@link Either#left(Object)} with {@code Object}.
   * <p>
   * Method under test: {@link Either#left(Object)}
   */
  @Test
  @DisplayName("Test left(Object) with 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Either Either.left(Object)"})
  void testLeftWithObject() {
    // Arrange and Act
    Either<Object, Object> actualLeftResult = Either.left("Left");

    // Assert
    assertTrue(actualLeftResult instanceof ImmutableLeft);
    assertEquals("Left", actualLeftResult.left());
    assertFalse(actualLeftResult.isRight());
    assertTrue(actualLeftResult.isLeft());
  }

  /**
   * Test {@link Either#right(Object)} with {@code Object}.
   * <p>
   * Method under test: {@link Either#right(Object)}
   */
  @Test
  @DisplayName("Test right(Object) with 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Either Either.right(Object)"})
  void testRightWithObject() {
    // Arrange and Act
    Either<Object, Object> actualRightResult = Either.right("Right");

    // Assert
    assertTrue(actualRightResult instanceof ImmutableRight);
    assertEquals("Right", actualRightResult.right());
    assertFalse(actualRightResult.isLeft());
    assertTrue(actualRightResult.isRight());
  }
}
