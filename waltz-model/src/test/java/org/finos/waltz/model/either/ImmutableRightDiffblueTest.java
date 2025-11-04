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

class ImmutableRightDiffblueTest {
  /**
   * Method under test: {@link ImmutableRight.Builder#from(Right)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRight.Builder<Object, Object> builderResult = ImmutableRight.builder();
    Right<Object, Object> instance = mock(Right.class);
    when(instance.right()).thenReturn("Right");

    // Act
    ImmutableRight.Builder<Object, Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).right();
    ImmutableRight<Object, Object> buildResult = builderResult.build();
    assertEquals("Right", buildResult.right());
    assertFalse(buildResult.isLeft());
    assertTrue(buildResult.isRight());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRight.Builder#from(Right)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRight.Builder<Object, Object> builderResult = ImmutableRight.builder();
    Right<Object, Object> instance = mock(Right.class);
    when(instance.right()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).right();
  }

  /**
   * Method under test: {@link ImmutableRight.Builder#right(Object)}
   */
  @Test
  void testBuilderRight() {
    // Arrange
    ImmutableRight.Builder<Object, Object> builderResult = ImmutableRight.builder();

    // Act
    ImmutableRight.Builder<Object, Object> actualRightResult = builderResult.right("Right");

    // Assert
    ImmutableRight<Object, Object> buildResult = builderResult.build();
    assertEquals("Right", buildResult.right());
    assertFalse(buildResult.isLeft());
    assertTrue(buildResult.isRight());
    assertSame(builderResult, actualRightResult);
  }

  /**
   * Method under test: {@link ImmutableRight#copyOf(Right)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Right<Object, Object> instance = mock(Right.class);
    when(instance.right()).thenReturn("Right");

    // Act
    ImmutableRight<Object, Object> actualCopyOfResult = ImmutableRight.copyOf(instance);

    // Assert
    verify(instance).right();
    assertEquals("Right", actualCopyOfResult.right());
    assertFalse(actualCopyOfResult.isLeft());
    assertTrue(actualCopyOfResult.isRight());
  }
}
