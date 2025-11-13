package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyInstance.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstancePermissions.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

class SurveyInstanceStateMachineDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SurveyInstanceStateMachine#SurveyInstanceStateMachine(SurveyInstanceStatus,
   *       MultiValueMap)}
   *   <li>{@link SurveyInstanceStateMachine#getCurrent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SurveyInstanceStateMachine.<init>(SurveyInstanceStatus, MultiValueMap)",
    "SurveyInstanceStatus SurveyInstanceStateMachine.getCurrent()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        SurveyInstanceStatus.NOT_STARTED,
        new SurveyInstanceStateMachine(
                SurveyInstanceStatus.NOT_STARTED, new LinkedMultiValueMap<>())
            .getCurrent());
  }

  /**
   * Test {@link SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions,
   * SurveyInstance)}.
   *
   * <ul>
   *   <li>Given simple {@code NOT_STARTED}.
   *   <li>When builder build.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName(
      "Test nextPossibleStatus(SurveyInstancePermissions, SurveyInstance); given simple 'NOT_STARTED'; when builder build; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyInstanceStateMachine.nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)"
  })
  void testNextPossibleStatus_givenSimpleNotStarted_whenBuilderBuild_thenReturnEmpty() {
    // Arrange
    SurveyInstanceStateMachine simpleResult =
        SurveyInstanceStateMachineFactory.simple(SurveyInstanceStatus.NOT_STARTED);
    ImmutableSurveyInstancePermissions permissions =
        ImmutableSurveyInstancePermissions.builder().build();

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(1L)
            .owningRole("Owning Role");

    Builder submittedByResult =
        owningRoleResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(SurveyInstanceStatus.NOT_STARTED)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By");

    // Act and Assert
    assertTrue(
        simpleResult
            .nextPossibleStatus(
                permissions,
                submittedByResult
                    .surveyEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .surveyEntityExternalId("42")
                    .surveyRunId(1L)
                    .build())
            .isEmpty());
  }

  /**
   * Test {@link SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions,
   * SurveyInstance)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName(
      "Test nextPossibleStatus(SurveyInstancePermissions, SurveyInstance); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyInstanceStateMachine.nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)"
  })
  void testNextPossibleStatus_thenReturnEmpty() {
    // Arrange
    SurveyInstanceStateMachine surveyInstanceStateMachine =
        new SurveyInstanceStateMachine(
            SurveyInstanceStatus.NOT_STARTED, new LinkedMultiValueMap<>());
    Json permissions = new Json();

    // Act and Assert
    assertTrue(
        surveyInstanceStateMachine
            .nextPossibleStatus(permissions, new ImmutableSurveyInstance.Json())
            .isEmpty());
  }

  /**
   * Test {@link SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions,
   * SurveyInstance)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * SurveyInstanceStateMachine#nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName(
      "Test nextPossibleStatus(SurveyInstancePermissions, SurveyInstance); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyInstanceStateMachine.nextPossibleStatus(SurveyInstancePermissions, SurveyInstance)"
  })
  void testNextPossibleStatus_thenReturnSizeIsOne() {
    // Arrange
    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions =
        new LinkedMultiValueMap<>();
    transitions.add(
        SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(
            SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
    SurveyInstanceStateMachine surveyInstanceStateMachine =
        new SurveyInstanceStateMachine(SurveyInstanceStatus.NOT_STARTED, transitions);
    Json permissions = new Json();

    // Act
    List<SurveyInstanceStatus> actualNextPossibleStatusResult =
        surveyInstanceStateMachine.nextPossibleStatus(
            permissions, new ImmutableSurveyInstance.Json());

    // Assert
    assertEquals(1, actualNextPossibleStatusResult.size());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualNextPossibleStatusResult.get(0));
  }

  /**
   * Test {@link SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions,
   * SurveyInstance)}.
   *
   * <ul>
   *   <li>Given simple {@code NOT_STARTED}.
   *   <li>When builder build.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName(
      "Test nextPossibleActions(SurveyInstancePermissions, SurveyInstance); given simple 'NOT_STARTED'; when builder build; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyInstanceStateMachine.nextPossibleActions(SurveyInstancePermissions, SurveyInstance)"
  })
  void testNextPossibleActions_givenSimpleNotStarted_whenBuilderBuild_thenReturnEmpty() {
    // Arrange
    SurveyInstanceStateMachine simpleResult =
        SurveyInstanceStateMachineFactory.simple(SurveyInstanceStatus.NOT_STARTED);
    ImmutableSurveyInstancePermissions permissions =
        ImmutableSurveyInstancePermissions.builder().build();

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(1L)
            .owningRole("Owning Role");

    Builder submittedByResult =
        owningRoleResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(SurveyInstanceStatus.NOT_STARTED)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By");

    // Act and Assert
    assertTrue(
        simpleResult
            .nextPossibleActions(
                permissions,
                submittedByResult
                    .surveyEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .surveyEntityExternalId("42")
                    .surveyRunId(1L)
                    .build())
            .isEmpty());
  }

  /**
   * Test {@link SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions,
   * SurveyInstance)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName(
      "Test nextPossibleActions(SurveyInstancePermissions, SurveyInstance); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyInstanceStateMachine.nextPossibleActions(SurveyInstancePermissions, SurveyInstance)"
  })
  void testNextPossibleActions_thenReturnEmpty() {
    // Arrange
    SurveyInstanceStateMachine surveyInstanceStateMachine =
        new SurveyInstanceStateMachine(
            SurveyInstanceStatus.NOT_STARTED, new LinkedMultiValueMap<>());
    Json permissions = new Json();

    // Act and Assert
    assertTrue(
        surveyInstanceStateMachine
            .nextPossibleActions(permissions, new ImmutableSurveyInstance.Json())
            .isEmpty());
  }

  /**
   * Test {@link SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions,
   * SurveyInstance)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * SurveyInstanceStateMachine#nextPossibleActions(SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName(
      "Test nextPossibleActions(SurveyInstancePermissions, SurveyInstance); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SurveyInstanceStateMachine.nextPossibleActions(SurveyInstancePermissions, SurveyInstance)"
  })
  void testNextPossibleActions_thenReturnSizeIsOne() {
    // Arrange
    LinkedMultiValueMap<SurveyInstanceStatus, SurveyInstanceStateTransition> transitions =
        new LinkedMultiValueMap<>();
    transitions.add(
        SurveyInstanceStatus.NOT_STARTED,
        SurveyInstanceStateTransition.transition(
            SurveyInstanceAction.SUBMITTING, SurveyInstanceStatus.NOT_STARTED));
    SurveyInstanceStateMachine surveyInstanceStateMachine =
        new SurveyInstanceStateMachine(SurveyInstanceStatus.NOT_STARTED, transitions);
    Json permissions = new Json();

    // Act
    List<SurveyInstanceAction> actualNextPossibleActionsResult =
        surveyInstanceStateMachine.nextPossibleActions(
            permissions, new ImmutableSurveyInstance.Json());

    // Assert
    assertEquals(1, actualNextPossibleActionsResult.size());
    assertEquals(SurveyInstanceAction.SUBMITTING, actualNextPossibleActionsResult.get(0));
  }

  /**
   * Test {@link SurveyInstanceStateMachine#process(SurveyInstanceAction, SurveyInstancePermissions,
   * SurveyInstance)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceStateMachine#process(SurveyInstanceAction,
   * SurveyInstancePermissions, SurveyInstance)}
   */
  @Test
  @DisplayName(
      "Test process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance); when builder build; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceStatus SurveyInstanceStateMachine.process(SurveyInstanceAction, SurveyInstancePermissions, SurveyInstance)"
  })
  void testProcess_whenBuilderBuild_thenThrowIllegalArgumentException() {
    // Arrange
    SurveyInstanceStateMachine simpleResult =
        SurveyInstanceStateMachineFactory.simple(SurveyInstanceStatus.NOT_STARTED);
    ImmutableSurveyInstancePermissions permissions =
        ImmutableSurveyInstancePermissions.builder().build();

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(1L)
            .owningRole("Owning Role");

    Builder submittedByResult =
        owningRoleResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(SurveyInstanceStatus.NOT_STARTED)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            simpleResult.process(
                SurveyInstanceAction.SUBMITTING,
                permissions,
                submittedByResult
                    .surveyEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .surveyEntityExternalId("42")
                    .surveyRunId(1L)
                    .build()));
  }
}
