package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SurveyInstanceStateTransitionDiffblueTest {
  /**
   * Test {@link SurveyInstanceStateTransition#SurveyInstanceStateTransition(SurveyInstanceAction,
   * SurveyInstanceStatus, BiFunction)}.
   *
   * <p>Method under test: {@link
   * SurveyInstanceStateTransition#SurveyInstanceStateTransition(SurveyInstanceAction,
   * SurveyInstanceStatus, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test new SurveyInstanceStateTransition(SurveyInstanceAction, SurveyInstanceStatus, BiFunction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SurveyInstanceStateTransition.<init>(SurveyInstanceAction, SurveyInstanceStatus, BiFunction)"
  })
  void testNewSurveyInstanceStateTransition() {
    // Arrange
    BiFunction<SurveyInstancePermissions, SurveyInstance, Boolean> predicate =
        mock(BiFunction.class);

    // Act
    SurveyInstanceStateTransition actualSurveyInstanceStateTransition =
        new SurveyInstanceStateTransition(
            SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED, predicate);

    // Assert
    assertEquals(SurveyInstanceAction.SUBMITTING, actualSurveyInstanceStateTransition.getAction());
    assertEquals(
        SurveyInstanceStatus.NOT_STARTED, actualSurveyInstanceStateTransition.getFutureStatus());
    assertSame(predicate, actualSurveyInstanceStateTransition.getPredicate());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SurveyInstanceStateTransition#getAction()}
   *   <li>{@link SurveyInstanceStateTransition#getFutureStatus()}
   *   <li>{@link SurveyInstanceStateTransition#getPredicate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceAction SurveyInstanceStateTransition.getAction()",
    "SurveyInstanceStatus SurveyInstanceStateTransition.getFutureStatus()",
    "BiFunction SurveyInstanceStateTransition.getPredicate()"
  })
  void testGettersAndSetters() {
    // Arrange
    SurveyInstanceStateTransition transitionResult =
        SurveyInstanceStateTransition.transition(
            SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED);

    // Act
    SurveyInstanceAction actualAction = transitionResult.getAction();
    SurveyInstanceStatus actualFutureStatus = transitionResult.getFutureStatus();
    transitionResult.getPredicate();

    // Assert
    assertEquals(SurveyInstanceAction.SUBMITTING, actualAction);
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualFutureStatus);
  }

  /**
   * Test {@link SurveyInstanceStateTransition#transition(SurveyInstanceAction,
   * SurveyInstanceStatus)} with {@code action}, {@code futureStatus}.
   *
   * <p>Method under test: {@link SurveyInstanceStateTransition#transition(SurveyInstanceAction,
   * SurveyInstanceStatus)}
   */
  @Test
  @DisplayName(
      "Test transition(SurveyInstanceAction, SurveyInstanceStatus) with 'action', 'futureStatus'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStateTransition SurveyInstanceStateTransition.transition(SurveyInstanceAction, SurveyInstanceStatus)"
  })
  void testTransitionWithActionFutureStatus() {
    // Arrange and Act
    SurveyInstanceStateTransition actualTransitionResult =
        SurveyInstanceStateTransition.transition(
            SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED);

    // Assert
    assertEquals(SurveyInstanceAction.SUBMITTING, actualTransitionResult.getAction());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualTransitionResult.getFutureStatus());
  }

  /**
   * Test {@link SurveyInstanceStateTransition#transition(SurveyInstanceAction,
   * SurveyInstanceStatus, BiFunction)} with {@code action}, {@code futureStatus}, {@code
   * predicate}.
   *
   * <p>Method under test: {@link SurveyInstanceStateTransition#transition(SurveyInstanceAction,
   * SurveyInstanceStatus, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test transition(SurveyInstanceAction, SurveyInstanceStatus, BiFunction) with 'action', 'futureStatus', 'predicate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStateTransition SurveyInstanceStateTransition.transition(SurveyInstanceAction, SurveyInstanceStatus, BiFunction)"
  })
  void testTransitionWithActionFutureStatusPredicate() {
    // Arrange
    BiFunction<SurveyInstancePermissions, SurveyInstance, Boolean> predicate =
        mock(BiFunction.class);

    // Act
    SurveyInstanceStateTransition actualTransitionResult =
        SurveyInstanceStateTransition.transition(
            SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED, predicate);

    // Assert
    assertEquals(SurveyInstanceAction.SUBMITTING, actualTransitionResult.getAction());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualTransitionResult.getFutureStatus());
    assertSame(predicate, actualTransitionResult.getPredicate());
  }

  /**
   * Test {@link SurveyInstanceStateTransition#equals(Object)}, and {@link
   * SurveyInstanceStateTransition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SurveyInstanceStateTransition#equals(Object)}
   *   <li>{@link SurveyInstanceStateTransition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceStateTransition.equals(Object)",
    "int SurveyInstanceStateTransition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SurveyInstanceStateTransition transitionResult =
        SurveyInstanceStateTransition.transition(
            SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED);
    SurveyInstanceStateTransition transitionResult2 =
        SurveyInstanceStateTransition.transition(
            SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED);

    // Act and Assert
    assertEquals(transitionResult, transitionResult2);
    assertEquals(transitionResult.hashCode(), transitionResult2.hashCode());
  }

  /**
   * Test {@link SurveyInstanceStateTransition#equals(Object)}, and {@link
   * SurveyInstanceStateTransition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SurveyInstanceStateTransition#equals(Object)}
   *   <li>{@link SurveyInstanceStateTransition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceStateTransition.equals(Object)",
    "int SurveyInstanceStateTransition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SurveyInstanceStateTransition transitionResult =
        SurveyInstanceStateTransition.transition(
            SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED);

    // Act and Assert
    assertEquals(transitionResult, transitionResult);
    int expectedHashCodeResult = transitionResult.hashCode();
    assertEquals(expectedHashCodeResult, transitionResult.hashCode());
  }

  /**
   * Test {@link SurveyInstanceStateTransition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceStateTransition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceStateTransition.equals(Object)",
    "int SurveyInstanceStateTransition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        SurveyInstanceStateTransition.transition(
            SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED),
        1);
  }

  /**
   * Test {@link SurveyInstanceStateTransition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceStateTransition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceStateTransition.equals(Object)",
    "int SurveyInstanceStateTransition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SurveyInstanceStateTransition transitionResult =
        SurveyInstanceStateTransition.transition(
            SurveyInstanceAction.REJECTING, SurveyInstanceStatus.NOT_STARTED);

    // Act and Assert
    assertNotEquals(
        transitionResult,
        SurveyInstanceStateTransition.transition(
            SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
  }

  /**
   * Test {@link SurveyInstanceStateTransition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceStateTransition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceStateTransition.equals(Object)",
    "int SurveyInstanceStateTransition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SurveyInstanceStateTransition transitionResult =
        SurveyInstanceStateTransition.transition(
            SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.IN_PROGRESS);

    // Act and Assert
    assertNotEquals(
        transitionResult,
        SurveyInstanceStateTransition.transition(
            SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
  }

  /**
   * Test {@link SurveyInstanceStateTransition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceStateTransition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceStateTransition.equals(Object)",
    "int SurveyInstanceStateTransition.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        SurveyInstanceStateTransition.transition(
            SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED),
        null);
  }

  /**
   * Test {@link SurveyInstanceStateTransition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceStateTransition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SurveyInstanceStateTransition.equals(Object)",
    "int SurveyInstanceStateTransition.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        SurveyInstanceStateTransition.transition(
            SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED),
        "Different type to SurveyInstanceStateTransition");
  }
}
