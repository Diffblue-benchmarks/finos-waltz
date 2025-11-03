package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.function.BiFunction;
import org.finos.waltz.model.survey.ImmutableSurveyInstancePermissions.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

class SurveyInstanceStateMachineDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SurveyInstanceStateMachine#SurveyInstanceStateMachine(SurveyInstanceStatus, MultiValueMap)}
   *   <li>{@link SurveyInstanceStateMachine#getCurrent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SurveyInstanceStateMachine.<init>(SurveyInstanceStatus, MultiValueMap)",
      "SurveyInstanceStatus SurveyInstanceStateMachine.getCurrent()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(SurveyInstanceStatus.NOT_STARTED,
        (new SurveyInstanceStateMachine(SurveyInstanceStatus.NOT_STARTED, new LinkedMultiValueMap<>())).getCurrent());
  }

  /**
   * Test {@link SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)}.
   * <ul>
   *   <li>Given {@link BiFunction} {@link BiFunction#apply(Object, Object)} return {@code false}.</li>
   *   <li>Then calls {@link BiFunction#apply(Object, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName("Test nextPossibleStatus(SurveyInstancePermissions, SurveyInstance); given BiFunction apply(Object, Object) return 'false'; then calls apply(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SurveyInstanceStateMachine.nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)"})
  void testNextPossibleStatus_givenBiFunctionApplyReturnFalse_thenCallsApply() {
    // Arrange
    BiFunction<SurveyInstancePermissions, SurveyInstance, Boolean> predicate = mock(BiFunction.class);
    when(predicate.apply(Mockito.<SurveyInstancePermissions>any(), Mockito.<SurveyInstance>any())).thenReturn(false);
    SurveyInstanceStateTransition transitionResult = SurveyInstanceStateTransition
        .transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED, predicate);

    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED, transitionResult);
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    Json permissions = new Json();

    // Act
    List<SurveyInstanceStatus> actualNextPossibleStatusResult = surveyInstanceStateMachine
        .nextPossibleStatus(permissions, new ImmutableSurveyInstance.Json());

    // Assert
    verify(predicate).apply(isA(SurveyInstancePermissions.class), isA(SurveyInstance.class));
    assertTrue(actualNextPossibleStatusResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName("Test nextPossibleStatus(SurveyInstancePermissions, SurveyInstance); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SurveyInstanceStateMachine.nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)"})
  void testNextPossibleStatus_thenReturnEmpty() {
    // Arrange
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, new LinkedMultiValueMap<>());
    Json permissions = new Json();

    // Act and Assert
    assertTrue(
        surveyInstanceStateMachine.nextPossibleStatus(permissions, new ImmutableSurveyInstance.Json()).isEmpty());
  }

  /**
   * Test {@link SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName("Test nextPossibleStatus(SurveyInstancePermissions, SurveyInstance); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SurveyInstanceStateMachine.nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)"})
  void testNextPossibleStatus_thenReturnSizeIsOne() {
    // Arrange
    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    Json permissions = new Json();

    // Act
    List<SurveyInstanceStatus> actualNextPossibleStatusResult = surveyInstanceStateMachine
        .nextPossibleStatus(permissions, new ImmutableSurveyInstance.Json());

    // Assert
    assertEquals(1, actualNextPossibleStatusResult.size());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualNextPossibleStatusResult.get(0));
  }

  /**
   * Test {@link SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName("Test nextPossibleStatus(SurveyInstancePermissions, SurveyInstance); then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SurveyInstanceStateMachine.nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)"})
  void testNextPossibleStatus_thenReturnSizeIsTwo() {
    // Arrange
    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
    transitions.add(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    Json permissions = new Json();

    // Act
    List<SurveyInstanceStatus> actualNextPossibleStatusResult = surveyInstanceStateMachine
        .nextPossibleStatus(permissions, new ImmutableSurveyInstance.Json());

    // Assert
    assertEquals(2, actualNextPossibleStatusResult.size());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualNextPossibleStatusResult.get(0));
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualNextPossibleStatusResult.get(1));
  }

  /**
   * Test {@link SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions, SurveyInstance)}.
   * <ul>
   *   <li>Given {@link BiFunction} {@link BiFunction#apply(Object, Object)} return {@code false}.</li>
   *   <li>Then calls {@link BiFunction#apply(Object, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName("Test nextPossibleActions(SurveyInstancePermissions, SurveyInstance); given BiFunction apply(Object, Object) return 'false'; then calls apply(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SurveyInstanceStateMachine.nextPossibleActions(SurveyInstancePermissions, SurveyInstance)"})
  void testNextPossibleActions_givenBiFunctionApplyReturnFalse_thenCallsApply() {
    // Arrange
    BiFunction<SurveyInstancePermissions, SurveyInstance, Boolean> predicate = mock(BiFunction.class);
    when(predicate.apply(Mockito.<SurveyInstancePermissions>any(), Mockito.<SurveyInstance>any())).thenReturn(false);
    SurveyInstanceStateTransition transitionResult = SurveyInstanceStateTransition
        .transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED, predicate);

    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED, transitionResult);
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    Json permissions = new Json();

    // Act
    List<SurveyInstanceAction> actualNextPossibleActionsResult = surveyInstanceStateMachine
        .nextPossibleActions(permissions, new ImmutableSurveyInstance.Json());

    // Assert
    verify(predicate).apply(isA(SurveyInstancePermissions.class), isA(SurveyInstance.class));
    assertTrue(actualNextPossibleActionsResult.isEmpty());
  }

  /**
   * Test {@link SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions, SurveyInstance)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName("Test nextPossibleActions(SurveyInstancePermissions, SurveyInstance); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SurveyInstanceStateMachine.nextPossibleActions(SurveyInstancePermissions, SurveyInstance)"})
  void testNextPossibleActions_thenReturnEmpty() {
    // Arrange
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, new LinkedMultiValueMap<>());
    Json permissions = new Json();

    // Act and Assert
    assertTrue(
        surveyInstanceStateMachine.nextPossibleActions(permissions, new ImmutableSurveyInstance.Json()).isEmpty());
  }

  /**
   * Test {@link SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions, SurveyInstance)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName("Test nextPossibleActions(SurveyInstancePermissions, SurveyInstance); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SurveyInstanceStateMachine.nextPossibleActions(SurveyInstancePermissions, SurveyInstance)"})
  void testNextPossibleActions_thenReturnSizeIsOne() {
    // Arrange
    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    Json permissions = new Json();

    // Act
    List<SurveyInstanceAction> actualNextPossibleActionsResult = surveyInstanceStateMachine
        .nextPossibleActions(permissions, new ImmutableSurveyInstance.Json());

    // Assert
    assertEquals(1, actualNextPossibleActionsResult.size());
    assertEquals(SurveyInstanceAction.SUBMITTING, actualNextPossibleActionsResult.get(0));
  }

  /**
   * Test {@link SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions, SurveyInstance)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName("Test nextPossibleActions(SurveyInstancePermissions, SurveyInstance); then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SurveyInstanceStateMachine.nextPossibleActions(SurveyInstancePermissions, SurveyInstance)"})
  void testNextPossibleActions_thenReturnSizeIsTwo() {
    // Arrange
    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
    transitions.add(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    Json permissions = new Json();

    // Act
    List<SurveyInstanceAction> actualNextPossibleActionsResult = surveyInstanceStateMachine
        .nextPossibleActions(permissions, new ImmutableSurveyInstance.Json());

    // Assert
    assertEquals(2, actualNextPossibleActionsResult.size());
    assertEquals(SurveyInstanceAction.SUBMITTING, actualNextPossibleActionsResult.get(0));
    assertEquals(SurveyInstanceAction.SUBMITTING, actualNextPossibleActionsResult.get(1));
  }

  /**
   * Test {@link SurveyInstanceStateMachine#process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)}.
   * <p>
   * Method under test: {@link SurveyInstanceStateMachine#process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName("Test process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "SurveyInstanceStatus SurveyInstanceStateMachine.process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)"})
  void testProcess() {
    // Arrange
    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.REJECTING, SurveyInstanceStatus.NOT_STARTED));
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    Json permissions = new Json();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceStateMachine
        .process(SurveyInstanceAction.SUBMITTING, permissions, new ImmutableSurveyInstance.Json()));
  }

  /**
   * Test {@link SurveyInstanceStateMachine#process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)}.
   * <ul>
   *   <li>Given {@link BiFunction} {@link BiFunction#apply(Object, Object)} return {@code false}.</li>
   *   <li>Then calls {@link BiFunction#apply(Object, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SurveyInstanceStateMachine#process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName("Test process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance); given BiFunction apply(Object, Object) return 'false'; then calls apply(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "SurveyInstanceStatus SurveyInstanceStateMachine.process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)"})
  void testProcess_givenBiFunctionApplyReturnFalse_thenCallsApply() {
    // Arrange
    BiFunction<SurveyInstancePermissions, SurveyInstance, Boolean> predicate = mock(BiFunction.class);
    when(predicate.apply(Mockito.<SurveyInstancePermissions>any(), Mockito.<SurveyInstance>any())).thenReturn(false);
    SurveyInstanceStateTransition transitionResult = SurveyInstanceStateTransition
        .transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED, predicate);

    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED, transitionResult);
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    Json permissions = new Json();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceStateMachine
        .process(SurveyInstanceAction.SUBMITTING, permissions, new ImmutableSurveyInstance.Json()));
    verify(predicate).apply(isA(SurveyInstancePermissions.class), isA(SurveyInstance.class));
  }

  /**
   * Test {@link SurveyInstanceStateMachine#process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)}.
   * <ul>
   *   <li>Then return {@code NOT_STARTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SurveyInstanceStateMachine#process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName("Test process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance); then return 'NOT_STARTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "SurveyInstanceStatus SurveyInstanceStateMachine.process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)"})
  void testProcess_thenReturnNotStarted() {
    // Arrange
    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions = new LinkedMultiValueMap<>();
    transitions.add(SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, transitions);
    Json permissions = new Json();

    // Act and Assert
    assertEquals(SurveyInstanceStatus.NOT_STARTED, surveyInstanceStateMachine.process(SurveyInstanceAction.SUBMITTING,
        permissions, new ImmutableSurveyInstance.Json()));
  }

  /**
   * Test {@link SurveyInstanceStateMachine#process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SurveyInstanceStateMachine#process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName("Test process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "SurveyInstanceStatus SurveyInstanceStateMachine.process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)"})
  void testProcess_thenThrowIllegalArgumentException() {
    // Arrange
    SurveyInstanceStateMachine surveyInstanceStateMachine = new SurveyInstanceStateMachine(
        SurveyInstanceStatus.NOT_STARTED, new LinkedMultiValueMap<>());
    Json permissions = new Json();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyInstanceStateMachine
        .process(SurveyInstanceAction.SUBMITTING, permissions, new ImmutableSurveyInstance.Json()));
  }
}
