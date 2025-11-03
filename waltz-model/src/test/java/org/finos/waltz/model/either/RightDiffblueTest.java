package org.finos.waltz.model.either;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RightDiffblueTest {
  /**
   * Test {@link Right#isRight()}.
   * <ul>
   *   <li>Given {@link Right} {@link Right#isRight()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Right#isRight()}
   */
  @Test
  @DisplayName("Test isRight(); given Right isRight() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Right.isRight()"})
  void testIsRight_givenRightIsRightReturnFalse() {
    // Arrange
    Right<Object, Object> right = mock(Right.class);
    when(right.isRight()).thenReturn(false);

    // Act
    right.isRight();

    // Assert
    verify(right).isRight();
  }

  /**
   * Test {@link Right#isRight()}.
   * <ul>
   *   <li>Given {@link Right} {@link Right#isRight()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Right#isRight()}
   */
  @Test
  @DisplayName("Test isRight(); given Right isRight() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Right.isRight()"})
  void testIsRight_givenRightIsRightReturnTrue() {
    // Arrange
    Right<Object, Object> right = mock(Right.class);
    when(right.isRight()).thenReturn(true);

    // Act
    right.isRight();

    // Assert
    verify(right).isRight();
  }

  /**
   * Test {@link Right#isLeft()}.
   * <ul>
   *   <li>Given {@link Right} {@link Right#isLeft()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Right#isLeft()}
   */
  @Test
  @DisplayName("Test isLeft(); given Right isLeft() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Right.isLeft()"})
  void testIsLeft_givenRightIsLeftReturnFalse() {
    // Arrange
    Right<Object, Object> right = mock(Right.class);
    when(right.isLeft()).thenReturn(false);

    // Act
    right.isLeft();

    // Assert
    verify(right).isLeft();
  }

  /**
   * Test {@link Right#isLeft()}.
   * <ul>
   *   <li>Given {@link Right} {@link Right#isLeft()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Right#isLeft()}
   */
  @Test
  @DisplayName("Test isLeft(); given Right isLeft() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Right.isLeft()"})
  void testIsLeft_givenRightIsLeftReturnTrue() {
    // Arrange
    Right<Object, Object> right = mock(Right.class);
    when(right.isLeft()).thenReturn(true);

    // Act
    right.isLeft();

    // Assert
    verify(right).isLeft();
  }
}
