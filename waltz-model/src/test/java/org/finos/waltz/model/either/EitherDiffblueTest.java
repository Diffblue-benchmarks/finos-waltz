package org.finos.waltz.model.either;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EitherDiffblueTest {
  /**
   * Method under test: {@link Either#left(Object)}
   */
  @Test
  void testLeft() {
    // Arrange and Act
    Either<Object, Object> actualLeftResult = Either.left("Left");

    // Assert
    assertTrue(actualLeftResult instanceof ImmutableLeft);
    assertEquals("Left", actualLeftResult.left());
    assertFalse(actualLeftResult.isRight());
    assertTrue(actualLeftResult.isLeft());
  }

  /**
   * Method under test: {@link Either#map(Function, Function)}
   */
  @Test
  void testMap() {
    // Arrange
    Either<Object, Object> either = mock(Either.class);
    when(either.map(Mockito.<Function<Object, Object>>any(), Mockito.<Function<Object, Object>>any()))
        .thenReturn("Map");

    // Act
    either.<Object>map(mock(Function.class), mock(Function.class));

    // Assert
    verify(either).map(isA(Function.class), isA(Function.class));
  }

  /**
   * Method under test: {@link Either#right(Object)}
   */
  @Test
  void testRight() {
    // Arrange and Act
    Either<Object, Object> actualRightResult = Either.right("Right");

    // Assert
    assertTrue(actualRightResult instanceof ImmutableRight);
    assertEquals("Right", actualRightResult.right());
    assertFalse(actualRightResult.isLeft());
    assertTrue(actualRightResult.isRight());
  }
}
