package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

class SurveyInstanceStateMachineDiffblueTest {
  /**
   * Method under test:
   * {@link SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  void testNextPossibleStatus() {
    // Arrange
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, new LinkedMultiValueMap<>());
    ImmutableSurveyInstancePermissions.Json permissions = new ImmutableSurveyInstancePermissions.Json();

    // Act and Assert
    assertTrue(
        surveyInstanceStateMachine.nextPossibleStatus(permissions, new ImmutableSurveyInstance.Json()).isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  void testNextPossibleStatus2() {
    // Arrange
    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    ImmutableSurveyInstancePermissions.Json permissions = new ImmutableSurveyInstancePermissions.Json();

    // Act
    List<SurveyInstanceStatus> actualNextPossibleStatusResult = surveyInstanceStateMachine
        .nextPossibleStatus(permissions, new ImmutableSurveyInstance.Json());

    // Assert
    assertEquals(1, actualNextPossibleStatusResult.size());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualNextPossibleStatusResult.get(0));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  void testNextPossibleStatus3() {
    // Arrange
    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
    transitions.add(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    ImmutableSurveyInstancePermissions.Json permissions = new ImmutableSurveyInstancePermissions.Json();

    // Act
    List<SurveyInstanceStatus> actualNextPossibleStatusResult = surveyInstanceStateMachine
        .nextPossibleStatus(permissions, new ImmutableSurveyInstance.Json());

    // Assert
    assertEquals(2, actualNextPossibleStatusResult.size());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualNextPossibleStatusResult.get(0));
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualNextPossibleStatusResult.get(1));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  void testNextPossibleStatus4() {
    // Arrange
    BiFunction<SurveyInstancePermissions, SurveyInstance, Boolean> predicate = mock(BiFunction.class);
    when(predicate.apply(Mockito.<SurveyInstancePermissions>any(), Mockito.<SurveyInstance>any())).thenReturn(false);
    SurveyInstanceStateTransition transitionResult = SurveyInstanceStateTransition
        .transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED, predicate);

    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED, transitionResult);
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    ImmutableSurveyInstancePermissions.Json permissions = new ImmutableSurveyInstancePermissions.Json();

    // Act
    List<SurveyInstanceStatus> actualNextPossibleStatusResult = surveyInstanceStateMachine
        .nextPossibleStatus(permissions, new ImmutableSurveyInstance.Json());

    // Assert
    verify(predicate).apply(isA(SurveyInstancePermissions.class), isA(SurveyInstance.class));
    assertTrue(actualNextPossibleStatusResult.isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SurveyInstanceStateMachine#SurveyInstanceStateMachine(SurveyInstanceStatus, MultiValueMap)}
   *   <li>{@link SurveyInstanceStateMachine#getCurrent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(SurveyInstanceStatus.NOT_STARTED,
        (new SurveyInstanceStateMachine(SurveyInstanceStatus.NOT_STARTED, new LinkedMultiValueMap<>())).getCurrent());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  void testNextPossibleActions() {
    // Arrange
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, new LinkedMultiValueMap<>());
    ImmutableSurveyInstancePermissions.Json permissions = new ImmutableSurveyInstancePermissions.Json();

    // Act and Assert
    assertTrue(
        surveyInstanceStateMachine.nextPossibleActions(permissions, new ImmutableSurveyInstance.Json()).isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  void testNextPossibleActions2() {
    // Arrange
    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    ImmutableSurveyInstancePermissions.Json permissions = new ImmutableSurveyInstancePermissions.Json();

    // Act
    List<SurveyInstanceAction> actualNextPossibleActionsResult = surveyInstanceStateMachine
        .nextPossibleActions(permissions, new ImmutableSurveyInstance.Json());

    // Assert
    assertEquals(1, actualNextPossibleActionsResult.size());
    assertEquals(SurveyInstanceAction.SUBMITTING, actualNextPossibleActionsResult.get(0));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  void testNextPossibleActions3() {
    // Arrange
    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
    transitions.add(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    ImmutableSurveyInstancePermissions.Json permissions = new ImmutableSurveyInstancePermissions.Json();

    // Act
    List<SurveyInstanceAction> actualNextPossibleActionsResult = surveyInstanceStateMachine
        .nextPossibleActions(permissions, new ImmutableSurveyInstance.Json());

    // Assert
    assertEquals(2, actualNextPossibleActionsResult.size());
    assertEquals(SurveyInstanceAction.SUBMITTING, actualNextPossibleActionsResult.get(0));
    assertEquals(SurveyInstanceAction.SUBMITTING, actualNextPossibleActionsResult.get(1));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  void testNextPossibleActions4() {
    // Arrange
    BiFunction<SurveyInstancePermissions, SurveyInstance, Boolean> predicate = mock(BiFunction.class);
    when(predicate.apply(Mockito.<SurveyInstancePermissions>any(), Mockito.<SurveyInstance>any())).thenReturn(false);
    SurveyInstanceStateTransition transitionResult = SurveyInstanceStateTransition
        .transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED, predicate);

    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED, transitionResult);
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    ImmutableSurveyInstancePermissions.Json permissions = new ImmutableSurveyInstancePermissions.Json();

    // Act
    List<SurveyInstanceAction> actualNextPossibleActionsResult = surveyInstanceStateMachine
        .nextPossibleActions(permissions, new ImmutableSurveyInstance.Json());

    // Assert
    verify(predicate).apply(isA(SurveyInstancePermissions.class), isA(SurveyInstance.class));
    assertTrue(actualNextPossibleActionsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyInstanceStateMachine#process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  void testProcess() {
    // Arrange
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, new LinkedMultiValueMap<>());
    ImmutableSurveyInstancePermissions.Json permissions = new ImmutableSurveyInstancePermissions.Json();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceStateMachine
        .process(SurveyInstanceAction.SUBMITTING, permissions, new ImmutableSurveyInstance.Json()));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceStateMachine#process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  void testProcess2() {
    // Arrange
    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    ImmutableSurveyInstancePermissions.Json permissions = new ImmutableSurveyInstancePermissions.Json();

    // Act and Assert
    assertEquals(SurveyInstanceStatus.NOT_STARTED, surveyInstanceStateMachine.process(SurveyInstanceAction.SUBMITTING,
        permissions, new ImmutableSurveyInstance.Json()));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceStateMachine#process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  void testProcess3() {
    // Arrange
    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.REJECTING, SurveyInstanceStatus.NOT_STARTED));
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    ImmutableSurveyInstancePermissions.Json permissions = new ImmutableSurveyInstancePermissions.Json();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceStateMachine
        .process(SurveyInstanceAction.SUBMITTING, permissions, new ImmutableSurveyInstance.Json()));
  }

  /**
   * Method under test:
   * {@link SurveyInstanceStateMachine#process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  void testProcess4() {
    // Arrange
    BiFunction<SurveyInstancePermissions, SurveyInstance, Boolean> predicate = mock(BiFunction.class);
    when(predicate.apply(Mockito.<SurveyInstancePermissions>any(), Mockito.<SurveyInstance>any())).thenReturn(false);
    SurveyInstanceStateTransition transitionResult = SurveyInstanceStateTransition
        .transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED, predicate);

    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED, transitionResult);
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    ImmutableSurveyInstancePermissions.Json permissions = new ImmutableSurveyInstancePermissions.Json();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceStateMachine
        .process(SurveyInstanceAction.SUBMITTING, permissions, new ImmutableSurveyInstance.Json()));
    verify(predicate).apply(isA(SurveyInstancePermissions.class), isA(SurveyInstance.class));
  }
}
