package org.finos.waltz.model.either;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LeftDiffblueTest {
  /**
   * Test {@link Left#isRight()}.
   * <ul>
   *   <li>Given {@link Left} {@link Left#isRight()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Left#isRight()}
   */
  @Test
  @DisplayName("Test isRight(); given Left isRight() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Left.isRight()"})
  void testIsRight_givenLeftIsRightReturnFalse() {
    // Arrange
    Left<Object, Object> left = mock(Left.class);
    when(left.isRight()).thenReturn(false);

    // Act
    left.isRight();

    // Assert
    verify(left).isRight();
  }

  /**
   * Test {@link Left#isRight()}.
   * <ul>
   *   <li>Given {@link Left} {@link Left#isRight()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Left#isRight()}
   */
  @Test
  @DisplayName("Test isRight(); given Left isRight() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Left.isRight()"})
  void testIsRight_givenLeftIsRightReturnTrue() {
    // Arrange
    Left<Object, Object> left = mock(Left.class);
    when(left.isRight()).thenReturn(true);

    // Act
    left.isRight();

    // Assert
    verify(left).isRight();
  }

  /**
   * Test {@link Left#isLeft()}.
   * <ul>
   *   <li>Given {@link Left} {@link Left#isLeft()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Left#isLeft()}
   */
  @Test
  @DisplayName("Test isLeft(); given Left isLeft() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Left.isLeft()"})
  void testIsLeft_givenLeftIsLeftReturnFalse() {
    // Arrange
    Left<Object, Object> left = mock(Left.class);
    when(left.isLeft()).thenReturn(false);

    // Act
    left.isLeft();

    // Assert
    verify(left).isLeft();
  }

  /**
   * Test {@link Left#isLeft()}.
   * <ul>
   *   <li>Given {@link Left} {@link Left#isLeft()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Left#isLeft()}
   */
  @Test
  @DisplayName("Test isLeft(); given Left isLeft() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Left.isLeft()"})
  void testIsLeft_givenLeftIsLeftReturnTrue() {
    // Arrange
    Left<Object, Object> left = mock(Left.class);
    when(left.isLeft()).thenReturn(true);

    // Act
    left.isLeft();

    // Assert
    verify(left).isLeft();
  }
}
