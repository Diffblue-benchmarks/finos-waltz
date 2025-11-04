package org.finos.waltz.model.either;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableLeftDiffblueTest {
  /**
   * Method under test: {@link ImmutableLeft.Builder#from(Left)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLeft.Builder<Object, Object> builderResult = ImmutableLeft.builder();
    Left<Object, Object> instance = mock(Left.class);
    when(instance.left()).thenReturn("Left");

    // Act
    ImmutableLeft.Builder<Object, Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).left();
    ImmutableLeft<Object, Object> buildResult = builderResult.build();
    assertEquals("Left", buildResult.left());
    assertFalse(buildResult.isRight());
    assertTrue(buildResult.isLeft());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLeft.Builder#from(Left)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLeft.Builder<Object, Object> builderResult = ImmutableLeft.builder();
    Left<Object, Object> instance = mock(Left.class);
    when(instance.left()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).left();
  }

  /**
   * Method under test: {@link ImmutableLeft.Builder#left(Object)}
   */
  @Test
  void testBuilderLeft() {
    // Arrange
    ImmutableLeft.Builder<Object, Object> builderResult = ImmutableLeft.builder();

    // Act
    ImmutableLeft.Builder<Object, Object> actualLeftResult = builderResult.left("Left");

    // Assert
    ImmutableLeft<Object, Object> buildResult = builderResult.build();
    assertEquals("Left", buildResult.left());
    assertFalse(buildResult.isRight());
    assertTrue(buildResult.isLeft());
    assertSame(builderResult, actualLeftResult);
  }

  /**
   * Method under test: {@link ImmutableLeft#copyOf(Left)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Left<Object, Object> instance = mock(Left.class);
    when(instance.left()).thenReturn("Left");

    // Act
    ImmutableLeft<Object, Object> actualCopyOfResult = ImmutableLeft.copyOf(instance);

    // Assert
    verify(instance).left();
    assertEquals("Left", actualCopyOfResult.left());
    assertFalse(actualCopyOfResult.isRight());
    assertTrue(actualCopyOfResult.isLeft());
  }
}
