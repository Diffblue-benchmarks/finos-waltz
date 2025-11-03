package org.finos.waltz.model.either;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.either.ImmutableLeft.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLeftDiffblueTest {
  /**
   * Test Builder {@link Builder#from(Left)}.
   * <ul>
   *   <li>Given {@code Left}.</li>
   *   <li>When {@link Left} {@link Left#left()} return {@code Left}.</li>
   *   <li>Then builder build left is {@code Left}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Left)}
   */
  @Test
  @DisplayName("Test Builder from(Left); given 'Left'; when Left left() return 'Left'; then builder build left is 'Left'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Left)"})
  void testBuilderFrom_givenLeft_whenLeftLeftReturnLeft_thenBuilderBuildLeftIsLeft() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();
    Left<Object, Object> instance = mock(Left.class);
    when(instance.left()).thenReturn("Left");

    // Act
    Builder<Object, Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).left();
    ImmutableLeft<Object, Object> buildResult = builderResult.build();
    assertEquals("Left", buildResult.left());
    assertFalse(buildResult.isRight());
    assertTrue(buildResult.isLeft());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Left)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Left)}
   */
  @Test
  @DisplayName("Test Builder from(Left); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Left)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();
    Left<Object, Object> instance = mock(Left.class);
    when(instance.left()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).left();
  }

  /**
   * Test Builder {@link Builder#left(Object)}.
   * <p>
   * Method under test: {@link Builder#left(Object)}
   */
  @Test
  @DisplayName("Test Builder left(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.left(Object)"})
  void testBuilderLeft() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableLeft.builder();

    // Act
    Builder<Object, Object> actualLeftResult = builderResult.left("Left");

    // Assert
    ImmutableLeft<Object, Object> buildResult = builderResult.build();
    assertEquals("Left", buildResult.left());
    assertFalse(buildResult.isRight());
    assertTrue(buildResult.isLeft());
    assertSame(builderResult, actualLeftResult);
  }
}
