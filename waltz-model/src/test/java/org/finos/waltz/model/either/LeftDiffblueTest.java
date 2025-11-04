package org.finos.waltz.model.either;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class LeftDiffblueTest {
  /**
   * Method under test: {@link Left#right()}
   */
  @Test
  void testRight() {
    // Arrange
    Left<Object, Object> left = mock(Left.class);
    when(left.right()).thenReturn("Right");

    // Act
    left.right();

    // Assert
    verify(left).right();
  }

  /**
   * Method under test: {@link Left#isRight()}
   */
  @Test
  void testIsRight() {
    // Arrange
    Left<Object, Object> left = mock(Left.class);
    when(left.isRight()).thenReturn(true);

    // Act
    left.isRight();

    // Assert
    verify(left).isRight();
  }

  /**
   * Method under test: {@link Left#isRight()}
   */
  @Test
  void testIsRight2() {
    // Arrange
    Left<Object, Object> left = mock(Left.class);
    when(left.isRight()).thenReturn(false);

    // Act
    left.isRight();

    // Assert
    verify(left).isRight();
  }

  /**
   * Method under test: {@link Left#isLeft()}
   */
  @Test
  void testIsLeft() {
    // Arrange
    Left<Object, Object> left = mock(Left.class);
    when(left.isLeft()).thenReturn(true);

    // Act
    left.isLeft();

    // Assert
    verify(left).isLeft();
  }

  /**
   * Method under test: {@link Left#isLeft()}
   */
  @Test
  void testIsLeft2() {
    // Arrange
    Left<Object, Object> left = mock(Left.class);
    when(left.isLeft()).thenReturn(false);

    // Act
    left.isLeft();

    // Assert
    verify(left).isLeft();
  }
}
