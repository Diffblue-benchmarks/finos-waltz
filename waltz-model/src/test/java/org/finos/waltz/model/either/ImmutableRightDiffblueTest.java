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
import org.finos.waltz.model.either.ImmutableRight.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRightDiffblueTest {
  /**
   * Test Builder {@link Builder#from(Right)}.
   * <ul>
   *   <li>Given {@code Right}.</li>
   *   <li>Then builder build right is {@code Right}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Right)}
   */
  @Test
  @DisplayName("Test Builder from(Right); given 'Right'; then builder build right is 'Right'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Right)"})
  void testBuilderFrom_givenRight_thenBuilderBuildRightIsRight() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();
    Right<Object, Object> instance = mock(Right.class);
    when(instance.right()).thenReturn("Right");

    // Act
    Builder<Object, Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).right();
    ImmutableRight<Object, Object> buildResult = builderResult.build();
    assertEquals("Right", buildResult.right());
    assertFalse(buildResult.isLeft());
    assertTrue(buildResult.isRight());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Right)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Right)}
   */
  @Test
  @DisplayName("Test Builder from(Right); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Right)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();
    Right<Object, Object> instance = mock(Right.class);
    when(instance.right()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).right();
  }

  /**
   * Test Builder {@link Builder#right(Object)}.
   * <p>
   * Method under test: {@link Builder#right(Object)}
   */
  @Test
  @DisplayName("Test Builder right(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.right(Object)"})
  void testBuilderRight() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableRight.builder();

    // Act
    Builder<Object, Object> actualRightResult = builderResult.right("Right");

    // Assert
    ImmutableRight<Object, Object> buildResult = builderResult.build();
    assertEquals("Right", buildResult.right());
    assertFalse(buildResult.isLeft());
    assertTrue(buildResult.isRight());
    assertSame(builderResult, actualRightResult);
  }
}
