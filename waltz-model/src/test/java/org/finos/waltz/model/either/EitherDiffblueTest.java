package org.finos.waltz.model.either;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Function;
import org.finos.waltz.model.either.ImmutableLeft.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EitherDiffblueTest {
  /**
   * Test {@link Either#left(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link Either#left(Object)}
   */
  @Test
  @DisplayName("Test left(Object) with 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link Either#map(Function, Function)}.
   *
   * <p>Method under test: {@link Either#map(Function, Function)}
   */
  @Test
  @DisplayName("Test map(Function, Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Either.map(Function, Function)"})
  void testMap() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();
    ImmutableLeft<Object, Object> immutableLeft = builderResult.left("Left").build();

    Function<Object, Object> leftFn = mock(Function.class);
    when(leftFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Object actualMapResult = immutableLeft.map(leftFn, mock(Function.class));

    // Assert
    verify(leftFn).apply(isA(Object.class));
    assertEquals("Apply", actualMapResult);
  }

  /**
   * Test {@link Either#right(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link Either#right(Object)}
   */
  @Test
  @DisplayName("Test right(Object) with 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
