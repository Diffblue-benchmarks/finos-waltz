package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class SurveyInstanceStateTransitionDiffblueTest {
  /**
   * Method under test:
   * {@link SurveyInstanceStateTransition#transition(SurveyInstanceAction, SurveyInstanceStatus)}
   */
  @Test
  void testTransition() {
    // Arrange and Act
    SurveyInstanceStateTransition actualTransitionResult = SurveyInstanceStateTransition
        .transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED);

    // Assert
    assertEquals(SurveyInstanceAction.SUBMITTING, actualTransitionResult.getAction());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualTransitionResult.getFutureStatus());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceStateTransition#transition(SurveyInstanceAction, SurveyInstanceStatus, BiFunction)}
   */
  @Test
  void testTransition2() {
    // Arrange
    BiFunction<SurveyInstancePermissions, SurveyInstance, Boolean> predicate = mock(BiFunction.class);

    // Act
    SurveyInstanceStateTransition actualTransitionResult = SurveyInstanceStateTransition
        .transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED, predicate);

    // Assert
    assertEquals(SurveyInstanceAction.SUBMITTING, actualTransitionResult.getAction());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualTransitionResult.getFutureStatus());
    assertSame(predicate, actualTransitionResult.getPredicate());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SurveyInstanceStateTransition#equals(Object)}
   *   <li>{@link SurveyInstanceStateTransition#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SurveyInstanceStateTransition transitionResult = SurveyInstanceStateTransition
        .transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED);
    SurveyInstanceStateTransition transitionResult2 = SurveyInstanceStateTransition
        .transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED);

    // Act and Assert
    assertEquals(transitionResult, transitionResult2);
    int expectedHashCodeResult = transitionResult.hashCode();
    assertEquals(expectedHashCodeResult, transitionResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SurveyInstanceStateTransition#equals(Object)}
   *   <li>{@link SurveyInstanceStateTransition#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SurveyInstanceStateTransition transitionResult = SurveyInstanceStateTransition
        .transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED, mock(BiFunction.class));
    SurveyInstanceStateTransition transitionResult2 = SurveyInstanceStateTransition
        .transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED);

    // Act and Assert
    assertEquals(transitionResult, transitionResult2);
    int expectedHashCodeResult = transitionResult.hashCode();
    assertEquals(expectedHashCodeResult, transitionResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SurveyInstanceStateTransition#equals(Object)}
   *   <li>{@link SurveyInstanceStateTransition#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SurveyInstanceStateTransition transitionResult = SurveyInstanceStateTransition
        .transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED);

    // Act and Assert
    assertEquals(transitionResult, transitionResult);
    int expectedHashCodeResult = transitionResult.hashCode();
    assertEquals(expectedHashCodeResult, transitionResult.hashCode());
  }

  /**
   * Method under test: {@link SurveyInstanceStateTransition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SurveyInstanceStateTransition transitionResult = SurveyInstanceStateTransition
        .transition(SurveyInstanceAction.REJECTING, SurveyInstanceStatus.NOT_STARTED);

    // Act and Assert
    assertNotEquals(transitionResult,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
  }

  /**
   * Method under test: {@link SurveyInstanceStateTransition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SurveyInstanceStateTransition transitionResult = SurveyInstanceStateTransition
        .transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.IN_PROGRESS);

    // Act and Assert
    assertNotEquals(transitionResult,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
  }

  /**
   * Method under test: {@link SurveyInstanceStateTransition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED),
        null);
  }

  /**
   * Method under test: {@link SurveyInstanceStateTransition#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED),
        "Different type to SurveyInstanceStateTransition");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SurveyInstanceStateTransition#getAction()}
   *   <li>{@link SurveyInstanceStateTransition#getFutureStatus()}
   *   <li>{@link SurveyInstanceStateTransition#getPredicate()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    SurveyInstanceStateTransition transitionResult = SurveyInstanceStateTransition
        .transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED);

    // Act
    SurveyInstanceAction actualAction = transitionResult.getAction();
    SurveyInstanceStatus actualFutureStatus = transitionResult.getFutureStatus();
    transitionResult.getPredicate();

    // Assert
    assertEquals(SurveyInstanceAction.SUBMITTING, actualAction);
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualFutureStatus);
  }

  /**
   * Method under test:
   * {@link SurveyInstanceStateTransition#SurveyInstanceStateTransition(SurveyInstanceAction, SurveyInstanceStatus, BiFunction)}
   */
  @Test
  void testNewSurveyInstanceStateTransition() {
    // Arrange
    BiFunction<SurveyInstancePermissions, SurveyInstance, Boolean> predicate = mock(BiFunction.class);

    // Act
    SurveyInstanceStateTransition actualSurveyInstanceStateTransition = new SurveyInstanceStateTransition(
        SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED, predicate);

    // Assert
    assertEquals(SurveyInstanceAction.SUBMITTING, actualSurveyInstanceStateTransition.getAction());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualSurveyInstanceStateTransition.getFutureStatus());
    assertSame(predicate, actualSurveyInstanceStateTransition.getPredicate());
  }
}
