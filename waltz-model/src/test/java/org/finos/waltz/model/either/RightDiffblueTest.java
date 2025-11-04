package org.finos.waltz.model.either;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class RightDiffblueTest {
  /**
   * Method under test: {@link Right#left()}
   */
  @Test
  void testLeft() {
    // Arrange
    Right<Object, Object> right = mock(Right.class);
    when(right.left()).thenReturn("Left");

    // Act
    right.left();

    // Assert
    verify(right).left();
  }

  /**
   * Method under test: {@link Right#isRight()}
   */
  @Test
  void testIsRight() {
    // Arrange
    Right<Object, Object> right = mock(Right.class);
    when(right.isRight()).thenReturn(true);

    // Act
    right.isRight();

    // Assert
    verify(right).isRight();
  }

  /**
   * Method under test: {@link Right#isRight()}
   */
  @Test
  void testIsRight2() {
    // Arrange
    Right<Object, Object> right = mock(Right.class);
    when(right.isRight()).thenReturn(false);

    // Act
    right.isRight();

    // Assert
    verify(right).isRight();
  }

  /**
   * Method under test: {@link Right#isLeft()}
   */
  @Test
  void testIsLeft() {
    // Arrange
    Right<Object, Object> right = mock(Right.class);
    when(right.isLeft()).thenReturn(true);

    // Act
    right.isLeft();

    // Assert
    verify(right).isLeft();
  }

  /**
   * Method under test: {@link Right#isLeft()}
   */
  @Test
  void testIsLeft2() {
    // Arrange
    Right<Object, Object> right = mock(Right.class);
    when(right.isLeft()).thenReturn(false);

    // Act
    right.isLeft();

    // Assert
    verify(right).isLeft();
  }
}
