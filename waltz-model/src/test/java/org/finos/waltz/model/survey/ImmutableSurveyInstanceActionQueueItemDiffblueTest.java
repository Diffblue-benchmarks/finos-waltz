package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceActionQueueItem.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceActionQueueItemDiffblueTest {
  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#actionParams()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#actionParams()}
   */
  @Test
  @DisplayName("Test actionParams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyInstanceActionQueueItem.actionParams()"})
  void testActionParams() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    // Act and Assert
    assertEquals(
        actionParams,
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build()
            .actionParams());
  }

  /**
   * Test Builder {@link Builder#action(SurveyInstanceAction)}.
   *
   * <p>Method under test: {@link Builder#action(SurveyInstanceAction)}
   */
  @Test
  @DisplayName("Test Builder action(SurveyInstanceAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.action(SurveyInstanceAction)"})
  void testBuilderAction() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act
    Builder actualActionResult = builderResult.action(SurveyInstanceAction.SUBMITTING);

    // Assert
    assertSame(builderResult, actualActionResult);
  }

  /**
   * Test Builder {@link Builder#actionParams(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#actionParams(Optional)}
   */
  @Test
  @DisplayName("Test Builder actionParams(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.actionParams(Optional)"})
  void testBuilderActionParamsWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    // Act
    Builder actualActionParamsResult = builderResult.actionParams(actionParams);

    // Assert
    assertSame(builderResult, actualActionParamsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#actionParams(SurveyInstanceActionParams)}
   *   <li>{@link Builder#actionedAt(LocalDateTime)}
   *   <li>{@link Builder#message(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.actionParams(SurveyInstanceActionParams)",
    "Builder Builder.actionedAt(LocalDateTime)",
    "ImmutableSurveyInstanceActionQueueItem Builder.build()",
    "Builder Builder.message(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualActionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    Builder actualActionParamsResult = actualActionResult.actionParams(actionParams);
    LocalDateTime actionedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualIdResult =
        actualActionParamsResult
            .actionParams(
                ImmutableSurveyInstanceActionParams.builder()
                    .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                    .newDueDate(LocalDate.of(1970, 1, 1))
                    .reason("Just cause")
                    .build())
            .actionedAt(actionedAt)
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    LocalDateTime submittedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableSurveyInstanceActionQueueItem actualImmutableSurveyInstanceActionQueueItem =
        actualIdResult
            .id(id)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(submittedAt)
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Assert
    assertEquals(
        "Not all who wander are lost", actualImmutableSurveyInstanceActionQueueItem.message());
    assertEquals("Provenance", actualImmutableSurveyInstanceActionQueueItem.provenance());
    assertEquals("Submitted By", actualImmutableSurveyInstanceActionQueueItem.submittedBy());
    assertEquals(1L, actualImmutableSurveyInstanceActionQueueItem.surveyInstanceId().longValue());
    assertEquals(
        SurveyInstanceAction.SUBMITTING, actualImmutableSurveyInstanceActionQueueItem.action());
    assertEquals(
        SurveyInstanceActionStatus.PENDING, actualImmutableSurveyInstanceActionQueueItem.status());
    assertEquals(
        SurveyInstanceStatus.NOT_STARTED,
        actualImmutableSurveyInstanceActionQueueItem.initialState());
    assertSame(actionedAt, actualImmutableSurveyInstanceActionQueueItem.actionedAt());
    assertSame(submittedAt, actualImmutableSurveyInstanceActionQueueItem.submittedAt());
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem instance =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    ImmutableSurveyInstanceActionQueueItem actualImmutableSurveyInstanceActionQueueItem =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyInstanceActionQueueItem);
    ImmutableSurveyInstanceActionQueueItem actualImmutableSurveyInstanceActionQueueItem2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceActionQueueItem2);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceActionQueueItem)} with {@code
   * SurveyInstanceActionQueueItem}.
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceActionQueueItem)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyInstanceActionQueueItem) with 'SurveyInstanceActionQueueItem'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceActionQueueItem)"})
  void testBuilderFromWithSurveyInstanceActionQueueItem() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem instance =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    ImmutableSurveyInstanceActionQueueItem actualImmutableSurveyInstanceActionQueueItem =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyInstanceActionQueueItem);
    ImmutableSurveyInstanceActionQueueItem actualImmutableSurveyInstanceActionQueueItem2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceActionQueueItem2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceActionQueueItem)} with {@code
   * SurveyInstanceActionQueueItem}.
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceActionQueueItem)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyInstanceActionQueueItem) with 'SurveyInstanceActionQueueItem'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceActionQueueItem)"})
  void testBuilderFromWithSurveyInstanceActionQueueItem2() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    Optional<? extends SurveyInstanceActionParams> actionParams = Optional.empty();
    ImmutableSurveyInstanceActionQueueItem instance =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    ImmutableSurveyInstanceActionQueueItem actualImmutableSurveyInstanceActionQueueItem =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyInstanceActionQueueItem);
    ImmutableSurveyInstanceActionQueueItem actualImmutableSurveyInstanceActionQueueItem2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceActionQueueItem2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceActionQueueItem)} with {@code
   * SurveyInstanceActionQueueItem}.
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceActionQueueItem)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyInstanceActionQueueItem) with 'SurveyInstanceActionQueueItem'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceActionQueueItem)"})
  void testBuilderFromWithSurveyInstanceActionQueueItem3() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem instance =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message(null)
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    ImmutableSurveyInstanceActionQueueItem actualImmutableSurveyInstanceActionQueueItem =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyInstanceActionQueueItem);
    ImmutableSurveyInstanceActionQueueItem actualImmutableSurveyInstanceActionQueueItem2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceActionQueueItem2);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#initialState(SurveyInstanceStatus)}.
   *
   * <p>Method under test: {@link Builder#initialState(SurveyInstanceStatus)}
   */
  @Test
  @DisplayName("Test Builder initialState(SurveyInstanceStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.initialState(SurveyInstanceStatus)"})
  void testBuilderInitialState() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act
    Builder actualInitialStateResult = builderResult.initialState(SurveyInstanceStatus.NOT_STARTED);

    // Assert
    assertSame(builderResult, actualInitialStateResult);
  }

  /**
   * Test Builder {@link Builder#provenance(String)}.
   *
   * <ul>
   *   <li>When {@code Provenance}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#provenance(String)}
   */
  @Test
  @DisplayName("Test Builder provenance(String); when 'Provenance'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.provenance(String)"})
  void testBuilderProvenance_whenProvenance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act
    Builder actualProvenanceResult = builderResult.provenance("Provenance");

    // Assert
    assertSame(builderResult, actualProvenanceResult);
  }

  /**
   * Test Builder {@link Builder#status(SurveyInstanceActionStatus)}.
   *
   * <p>Method under test: {@link Builder#status(SurveyInstanceActionStatus)}
   */
  @Test
  @DisplayName("Test Builder status(SurveyInstanceActionStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.status(SurveyInstanceActionStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act
    Builder actualStatusResult = builderResult.status(SurveyInstanceActionStatus.PENDING);

    // Assert
    assertSame(builderResult, actualStatusResult);
  }

  /**
   * Test Builder {@link Builder#submittedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link Builder#submittedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test Builder submittedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.submittedAt(LocalDateTime)"})
  void testBuilderSubmittedAt() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act
    Builder actualSubmittedAtResult =
        builderResult.submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(builderResult, actualSubmittedAtResult);
  }

  /**
   * Test Builder {@link Builder#submittedBy(String)}.
   *
   * <ul>
   *   <li>When {@code Submitted By}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#submittedBy(String)}
   */
  @Test
  @DisplayName("Test Builder submittedBy(String); when 'Submitted By'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.submittedBy(String)"})
  void testBuilderSubmittedBy_whenSubmittedBy_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act
    Builder actualSubmittedByResult = builderResult.submittedBy("Submitted By");

    // Assert
    assertSame(builderResult, actualSubmittedByResult);
  }

  /**
   * Test Builder {@link Builder#surveyInstanceId(Long)}.
   *
   * <p>Method under test: {@link Builder#surveyInstanceId(Long)}
   */
  @Test
  @DisplayName("Test Builder surveyInstanceId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.surveyInstanceId(Long)"})
  void testBuilderSurveyInstanceId() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceActionQueueItem.builder();

    // Act
    Builder actualSurveyInstanceIdResult = builderResult.surveyInstanceId(1L);

    // Assert
    assertSame(builderResult, actualSurveyInstanceIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#copyOf(SurveyInstanceActionQueueItem)}.
   *
   * <ul>
   *   <li>Then return actionedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceActionQueueItem#copyOf(SurveyInstanceActionQueueItem)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyInstanceActionQueueItem); then return actionedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.copyOf(SurveyInstanceActionQueueItem)"
  })
  void testCopyOf_thenReturnActionedAtToLocalTimeToStringIs0000() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    ImmutableSurveyInstanceActionQueueItem instance =
        actionResult
            .actionParams(actionParams)
            .actionedAt(ofResult.atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(ofResult2.atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceActionQueueItem actualCopyOfResult =
        ImmutableSurveyInstanceActionQueueItem.copyOf(instance);

    // Assert
    LocalDateTime actionedAtResult = actualCopyOfResult.actionedAt();
    LocalTime toLocalTimeResult = actionedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = actionedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime submittedAtResult = actualCopyOfResult.submittedAt();
    LocalDate toLocalDateResult2 = submittedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Submitted By", actualCopyOfResult.submittedBy());
    assertEquals(1L, actualCopyOfResult.surveyInstanceId().longValue());
    assertEquals(SurveyInstanceAction.SUBMITTING, actualCopyOfResult.action());
    assertEquals(SurveyInstanceActionStatus.PENDING, actualCopyOfResult.status());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.initialState());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
    assertSame(ofResult, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}, and {@link
   * ImmutableSurveyInstanceActionQueueItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionQueueItem.equals(Object)",
    "int ImmutableSurveyInstanceActionQueueItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    Builder actionResult2 =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams2 =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams2 =
        Optional.of(immutableSurveyInstanceActionParams2);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem2 =
        actionResult2
            .actionParams(actionParams2)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyInstanceActionQueueItem, immutableSurveyInstanceActionQueueItem2);
    assertEquals(
        immutableSurveyInstanceActionQueueItem.hashCode(),
        immutableSurveyInstanceActionQueueItem2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}, and {@link
   * ImmutableSurveyInstanceActionQueueItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionQueueItem.equals(Object)",
    "int ImmutableSurveyInstanceActionQueueItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyInstanceActionQueueItem, immutableSurveyInstanceActionQueueItem);
    int expectedHashCodeResult = immutableSurveyInstanceActionQueueItem.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyInstanceActionQueueItem.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionQueueItem.equals(Object)",
    "int ImmutableSurveyInstanceActionQueueItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.REJECTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    Builder actionResult2 =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams2 =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams2 =
        Optional.of(immutableSurveyInstanceActionParams2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceActionQueueItem,
        actionResult2
            .actionParams(actionParams2)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionQueueItem.equals(Object)",
    "int ImmutableSurveyInstanceActionQueueItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.now())
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    Builder actionResult2 =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams2 =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams2 =
        Optional.of(immutableSurveyInstanceActionParams2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceActionQueueItem,
        actionResult2
            .actionParams(actionParams2)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionQueueItem.equals(Object)",
    "int ImmutableSurveyInstanceActionQueueItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.now().atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    Builder actionResult2 =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams2 =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams2 =
        Optional.of(immutableSurveyInstanceActionParams2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceActionQueueItem,
        actionResult2
            .actionParams(actionParams2)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionQueueItem.equals(Object)",
    "int ImmutableSurveyInstanceActionQueueItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(2L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    Builder actionResult2 =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams2 =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams2 =
        Optional.of(immutableSurveyInstanceActionParams2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceActionQueueItem,
        actionResult2
            .actionParams(actionParams2)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionQueueItem.equals(Object)",
    "int ImmutableSurveyInstanceActionQueueItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.IN_PROGRESS)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    Builder actionResult2 =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams2 =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams2 =
        Optional.of(immutableSurveyInstanceActionParams2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceActionQueueItem,
        actionResult2
            .actionParams(actionParams2)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionQueueItem.equals(Object)",
    "int ImmutableSurveyInstanceActionQueueItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Submitted By")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    Builder actionResult2 =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams2 =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams2 =
        Optional.of(immutableSurveyInstanceActionParams2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceActionQueueItem,
        actionResult2
            .actionParams(actionParams2)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionQueueItem.equals(Object)",
    "int ImmutableSurveyInstanceActionQueueItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Submitted By")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    Builder actionResult2 =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams2 =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams2 =
        Optional.of(immutableSurveyInstanceActionParams2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceActionQueueItem,
        actionResult2
            .actionParams(actionParams2)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionQueueItem.equals(Object)",
    "int ImmutableSurveyInstanceActionQueueItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.IN_PROGRESS)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    Builder actionResult2 =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams2 =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams2 =
        Optional.of(immutableSurveyInstanceActionParams2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceActionQueueItem,
        actionResult2
            .actionParams(actionParams2)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionQueueItem.equals(Object)",
    "int ImmutableSurveyInstanceActionQueueItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.now().atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    Builder actionResult2 =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams2 =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams2 =
        Optional.of(immutableSurveyInstanceActionParams2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceActionQueueItem,
        actionResult2
            .actionParams(actionParams2)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionQueueItem.equals(Object)",
    "int ImmutableSurveyInstanceActionQueueItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Provenance")
            .surveyInstanceId(1L)
            .build();

    Builder actionResult2 =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams2 =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams2 =
        Optional.of(immutableSurveyInstanceActionParams2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceActionQueueItem,
        actionResult2
            .actionParams(actionParams2)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionQueueItem.equals(Object)",
    "int ImmutableSurveyInstanceActionQueueItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(2L)
            .build();

    Builder actionResult2 =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams2 =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams2 =
        Optional.of(immutableSurveyInstanceActionParams2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceActionQueueItem,
        actionResult2
            .actionParams(actionParams2)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionQueueItem.equals(Object)",
    "int ImmutableSurveyInstanceActionQueueItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    // Act and Assert
    assertNotEquals(
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceActionQueueItem.equals(Object)",
    "int ImmutableSurveyInstanceActionQueueItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    // Act and Assert
    assertNotEquals(
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build(),
        "Different type to ImmutableSurveyInstanceActionQueueItem");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#action()}
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#actionedAt()}
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#initialState()}
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#message()}
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#provenance()}
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#status()}
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#submittedAt()}
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#submittedBy()}
   *   <li>{@link ImmutableSurveyInstanceActionQueueItem#surveyInstanceId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyInstanceAction ImmutableSurveyInstanceActionQueueItem.action()",
    "LocalDateTime ImmutableSurveyInstanceActionQueueItem.actionedAt()",
    "SurveyInstanceStatus ImmutableSurveyInstanceActionQueueItem.initialState()",
    "String ImmutableSurveyInstanceActionQueueItem.message()",
    "String ImmutableSurveyInstanceActionQueueItem.provenance()",
    "SurveyInstanceActionStatus ImmutableSurveyInstanceActionQueueItem.status()",
    "LocalDateTime ImmutableSurveyInstanceActionQueueItem.submittedAt()",
    "String ImmutableSurveyInstanceActionQueueItem.submittedBy()",
    "Long ImmutableSurveyInstanceActionQueueItem.surveyInstanceId()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(ofResult.atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(ofResult2.atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act
    SurveyInstanceAction actualActionResult = immutableSurveyInstanceActionQueueItem.action();
    LocalDateTime actualActionedAtResult = immutableSurveyInstanceActionQueueItem.actionedAt();
    SurveyInstanceStatus actualInitialStateResult =
        immutableSurveyInstanceActionQueueItem.initialState();
    String actualMessageResult = immutableSurveyInstanceActionQueueItem.message();
    String actualProvenanceResult = immutableSurveyInstanceActionQueueItem.provenance();
    SurveyInstanceActionStatus actualStatusResult = immutableSurveyInstanceActionQueueItem.status();
    LocalDateTime actualSubmittedAtResult = immutableSurveyInstanceActionQueueItem.submittedAt();
    String actualSubmittedByResult = immutableSurveyInstanceActionQueueItem.submittedBy();

    // Assert
    LocalTime toLocalTimeResult = actualActionedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = actualActionedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDate toLocalDateResult2 = actualSubmittedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("Not all who wander are lost", actualMessageResult);
    assertEquals("Provenance", actualProvenanceResult);
    assertEquals("Submitted By", actualSubmittedByResult);
    assertEquals(1L, immutableSurveyInstanceActionQueueItem.surveyInstanceId().longValue());
    assertEquals(SurveyInstanceAction.SUBMITTING, actualActionResult);
    assertEquals(SurveyInstanceActionStatus.PENDING, actualStatusResult);
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualInitialStateResult);
    assertSame(toLocalTimeResult, actualSubmittedAtResult.toLocalTime());
    assertSame(ofResult, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#id()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyInstanceActionQueueItem.id()"})
  void testId() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    // Act
    Optional<Long> actualIdResult =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyInstanceActionQueueItem.toString()"})
  void testToString() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    // Act and Assert
    assertEquals(
        "SurveyInstanceActionQueueItem{id=1, action=SUBMITTING, surveyInstanceId=1, actionParams=SurveyInstan"
            + "ceActionParams{reason=Just cause, newDueDate=1970-01-01, newApprovalDueDate=1970-01-01}, initialState"
            + "=NOT_STARTED, submittedAt=1970-01-01T00:00, submittedBy=Submitted By, actionedAt=1970-01-01T00:00,"
            + " status=PENDING, message=Not all who wander are lost, provenance=Provenance}",
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyInstanceActionQueueItem.toString()"})
  void testToString2() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    Optional<? extends SurveyInstanceActionParams> actionParams = Optional.empty();

    // Act and Assert
    assertEquals(
        "SurveyInstanceActionQueueItem{id=1, action=SUBMITTING, surveyInstanceId=1, initialState=NOT_STARTED,"
            + " submittedAt=1970-01-01T00:00, submittedBy=Submitted By, actionedAt=1970-01-01T00:00, status=PENDING,"
            + " message=Not all who wander are lost, provenance=Provenance}",
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyInstanceActionQueueItem.toString()"})
  void testToString3() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    // Act and Assert
    assertEquals(
        "SurveyInstanceActionQueueItem{id=1, action=SUBMITTING, surveyInstanceId=1, actionParams=SurveyInstan"
            + "ceActionParams{reason=Just cause, newDueDate=1970-01-01, newApprovalDueDate=1970-01-01}, initialState"
            + "=NOT_STARTED, submittedAt=1970-01-01T00:00, submittedBy=Submitted By, actionedAt=1970-01-01T00:00,"
            + " status=PENDING, provenance=Provenance}",
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message(null)
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withAction(SurveyInstanceAction)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceActionQueueItem#withAction(SurveyInstanceAction)}
   */
  @Test
  @DisplayName("Test withAction(SurveyInstanceAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withAction(SurveyInstanceAction)"
  })
  void testWithAction() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithActionResult =
        immutableSurveyInstanceActionQueueItem.withAction(SurveyInstanceAction.SUBMITTING);

    // Assert
    assertSame(immutableSurveyInstanceActionQueueItem, actualWithActionResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withActionParams(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#withActionParams(Optional)}
   */
  @Test
  @DisplayName("Test withActionParams(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withActionParams(Optional)"
  })
  void testWithActionParamsWithOptional() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams2 =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> optional =
        Optional.of(immutableSurveyInstanceActionParams2);

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithActionParamsResult =
        immutableSurveyInstanceActionQueueItem.withActionParams(optional);

    // Assert
    assertEquals(immutableSurveyInstanceActionQueueItem, actualWithActionParamsResult);
  }

  /**
   * Test {@link
   * ImmutableSurveyInstanceActionQueueItem#withActionParams(SurveyInstanceActionParams)} with
   * {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceActionQueueItem#withActionParams(SurveyInstanceActionParams)}
   */
  @Test
  @DisplayName("Test withActionParams(SurveyInstanceActionParams) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withActionParams(SurveyInstanceActionParams)"
  })
  void testWithActionParamsWithValue() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithActionParamsResult =
        immutableSurveyInstanceActionQueueItem.withActionParams(
            ImmutableSurveyInstanceActionParams.builder()
                .newApprovalDueDate(LocalDate.of(1970, 1, 1))
                .newDueDate(LocalDate.of(1970, 1, 1))
                .reason("Just cause")
                .build());

    // Assert
    assertEquals(immutableSurveyInstanceActionQueueItem, actualWithActionParamsResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withAction(SurveyInstanceAction)}.
   *
   * <ul>
   *   <li>Then return actionedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceActionQueueItem#withAction(SurveyInstanceAction)}
   */
  @Test
  @DisplayName(
      "Test withAction(SurveyInstanceAction); then return actionedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withAction(SurveyInstanceAction)"
  })
  void testWithAction_thenReturnActionedAtToLocalTimeToStringIs0000() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.REJECTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithActionResult =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build()
            .withAction(SurveyInstanceAction.SUBMITTING);

    // Assert
    LocalDateTime actionedAtResult = actualWithActionResult.actionedAt();
    LocalTime toLocalTimeResult = actionedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", actionedAtResult.toLocalDate().toString());
    LocalDateTime submittedAtResult = actualWithActionResult.submittedAt();
    assertEquals("1970-01-01", submittedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withActionedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceActionQueueItem#withActionedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withActionedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withActionedAt(LocalDateTime)"
  })
  void testWithActionedAt() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithActionedAtResult =
        immutableSurveyInstanceActionQueueItem.withActionedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableSurveyInstanceActionQueueItem, actualWithActionedAtResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithIdResult =
        immutableSurveyInstanceActionQueueItem.withId(optional);

    // Assert
    assertSame(immutableSurveyInstanceActionQueueItem, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return actionedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return actionedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnActionedAtToLocalTimeToStringIs0000() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(2L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithIdResult =
        immutableSurveyInstanceActionQueueItem.withId(optional);

    // Assert
    LocalDateTime actionedAtResult = actualWithIdResult.actionedAt();
    LocalTime toLocalTimeResult = actionedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", actionedAtResult.toLocalDate().toString());
    LocalDateTime submittedAtResult = actualWithIdResult.submittedAt();
    assertEquals("1970-01-01", submittedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithIdResult =
        immutableSurveyInstanceActionQueueItem.withId(1L);

    // Assert
    assertSame(immutableSurveyInstanceActionQueueItem, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return actionedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then return actionedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withId(long)"
  })
  void testWithIdWithValue_whenFortyTwo_thenReturnActionedAtToLocalTimeToStringIs0000() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithIdResult =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build()
            .withId(42L);

    // Assert
    LocalDateTime actionedAtResult = actualWithIdResult.actionedAt();
    LocalTime toLocalTimeResult = actionedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", actionedAtResult.toLocalDate().toString());
    LocalDateTime submittedAtResult = actualWithIdResult.submittedAt();
    assertEquals("1970-01-01", submittedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withInitialState(SurveyInstanceStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceActionQueueItem#withInitialState(SurveyInstanceStatus)}
   */
  @Test
  @DisplayName("Test withInitialState(SurveyInstanceStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withInitialState(SurveyInstanceStatus)"
  })
  void testWithInitialState() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithInitialStateResult =
        immutableSurveyInstanceActionQueueItem.withInitialState(SurveyInstanceStatus.NOT_STARTED);

    // Assert
    assertSame(immutableSurveyInstanceActionQueueItem, actualWithInitialStateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withInitialState(SurveyInstanceStatus)}.
   *
   * <ul>
   *   <li>Then return actionedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceActionQueueItem#withInitialState(SurveyInstanceStatus)}
   */
  @Test
  @DisplayName(
      "Test withInitialState(SurveyInstanceStatus); then return actionedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withInitialState(SurveyInstanceStatus)"
  })
  void testWithInitialState_thenReturnActionedAtToLocalTimeToStringIs0000() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithInitialStateResult =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.IN_PROGRESS)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build()
            .withInitialState(SurveyInstanceStatus.NOT_STARTED);

    // Assert
    LocalDateTime actionedAtResult = actualWithInitialStateResult.actionedAt();
    LocalTime toLocalTimeResult = actionedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", actionedAtResult.toLocalDate().toString());
    LocalDateTime submittedAtResult = actualWithInitialStateResult.submittedAt();
    assertEquals("1970-01-01", submittedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withMessage(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withMessage(String)"
  })
  void testWithMessage() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("42")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithMessageResult =
        immutableSurveyInstanceActionQueueItem.withMessage("42");

    // Assert
    assertSame(immutableSurveyInstanceActionQueueItem, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withMessage(String)}.
   *
   * <ul>
   *   <li>Then return actionedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String); then return actionedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withMessage(String)"
  })
  void testWithMessage_thenReturnActionedAtToLocalTimeToStringIs0000() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithMessageResult =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build()
            .withMessage("42");

    // Assert
    LocalDateTime actionedAtResult = actualWithMessageResult.actionedAt();
    LocalTime toLocalTimeResult = actionedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", actionedAtResult.toLocalDate().toString());
    LocalDateTime submittedAtResult = actualWithMessageResult.submittedAt();
    assertEquals("1970-01-01", submittedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("42")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithProvenanceResult =
        immutableSurveyInstanceActionQueueItem.withProvenance("42");

    // Assert
    assertSame(immutableSurveyInstanceActionQueueItem, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return actionedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#withProvenance(String)}
   */
  @Test
  @DisplayName(
      "Test withProvenance(String); then return actionedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withProvenance(String)"
  })
  void testWithProvenance_thenReturnActionedAtToLocalTimeToStringIs0000() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithProvenanceResult =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build()
            .withProvenance("42");

    // Assert
    LocalDateTime actionedAtResult = actualWithProvenanceResult.actionedAt();
    LocalTime toLocalTimeResult = actionedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", actionedAtResult.toLocalDate().toString());
    LocalDateTime submittedAtResult = actualWithProvenanceResult.submittedAt();
    assertEquals("1970-01-01", submittedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withStatus(SurveyInstanceActionStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceActionQueueItem#withStatus(SurveyInstanceActionStatus)}
   */
  @Test
  @DisplayName("Test withStatus(SurveyInstanceActionStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withStatus(SurveyInstanceActionStatus)"
  })
  void testWithStatus() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithStatusResult =
        immutableSurveyInstanceActionQueueItem.withStatus(SurveyInstanceActionStatus.PENDING);

    // Assert
    assertSame(immutableSurveyInstanceActionQueueItem, actualWithStatusResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withStatus(SurveyInstanceActionStatus)}.
   *
   * <ul>
   *   <li>Then return actionedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceActionQueueItem#withStatus(SurveyInstanceActionStatus)}
   */
  @Test
  @DisplayName(
      "Test withStatus(SurveyInstanceActionStatus); then return actionedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withStatus(SurveyInstanceActionStatus)"
  })
  void testWithStatus_thenReturnActionedAtToLocalTimeToStringIs0000() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithStatusResult =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.IN_PROGRESS)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build()
            .withStatus(SurveyInstanceActionStatus.PENDING);

    // Assert
    LocalDateTime actionedAtResult = actualWithStatusResult.actionedAt();
    LocalTime toLocalTimeResult = actionedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", actionedAtResult.toLocalDate().toString());
    LocalDateTime submittedAtResult = actualWithStatusResult.submittedAt();
    assertEquals("1970-01-01", submittedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withSubmittedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceActionQueueItem#withSubmittedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withSubmittedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withSubmittedAt(LocalDateTime)"
  })
  void testWithSubmittedAt() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithSubmittedAtResult =
        immutableSurveyInstanceActionQueueItem.withSubmittedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableSurveyInstanceActionQueueItem, actualWithSubmittedAtResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withSubmittedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#withSubmittedBy(String)}
   */
  @Test
  @DisplayName("Test withSubmittedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withSubmittedBy(String)"
  })
  void testWithSubmittedBy() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("42")
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithSubmittedByResult =
        immutableSurveyInstanceActionQueueItem.withSubmittedBy("42");

    // Assert
    assertSame(immutableSurveyInstanceActionQueueItem, actualWithSubmittedByResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withSubmittedBy(String)}.
   *
   * <ul>
   *   <li>Then return actionedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#withSubmittedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withSubmittedBy(String); then return actionedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withSubmittedBy(String)"
  })
  void testWithSubmittedBy_thenReturnActionedAtToLocalTimeToStringIs0000() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithSubmittedByResult =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build()
            .withSubmittedBy("42");

    // Assert
    LocalDateTime actionedAtResult = actualWithSubmittedByResult.actionedAt();
    LocalTime toLocalTimeResult = actionedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", actionedAtResult.toLocalDate().toString());
    LocalDateTime submittedAtResult = actualWithSubmittedByResult.submittedAt();
    assertEquals("1970-01-01", submittedAtResult.toLocalDate().toString());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withSurveyInstanceId(Long)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#withSurveyInstanceId(Long)}
   */
  @Test
  @DisplayName("Test withSurveyInstanceId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withSurveyInstanceId(Long)"
  })
  void testWithSurveyInstanceId() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);
    ImmutableSurveyInstanceActionQueueItem immutableSurveyInstanceActionQueueItem =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithSurveyInstanceIdResult =
        immutableSurveyInstanceActionQueueItem.withSurveyInstanceId(1L);

    // Assert
    assertSame(immutableSurveyInstanceActionQueueItem, actualWithSurveyInstanceIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceActionQueueItem#withSurveyInstanceId(Long)}.
   *
   * <ul>
   *   <li>Then return actionedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceActionQueueItem#withSurveyInstanceId(Long)}
   */
  @Test
  @DisplayName(
      "Test withSurveyInstanceId(Long); then return actionedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceActionQueueItem ImmutableSurveyInstanceActionQueueItem.withSurveyInstanceId(Long)"
  })
  void testWithSurveyInstanceId_thenReturnActionedAtToLocalTimeToStringIs0000() {
    // Arrange
    Builder actionResult =
        ImmutableSurveyInstanceActionQueueItem.builder().action(SurveyInstanceAction.SUBMITTING);
    ImmutableSurveyInstanceActionParams immutableSurveyInstanceActionParams =
        ImmutableSurveyInstanceActionParams.builder()
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends SurveyInstanceActionParams> actionParams =
        Optional.of(immutableSurveyInstanceActionParams);

    // Act
    ImmutableSurveyInstanceActionQueueItem actualWithSurveyInstanceIdResult =
        actionResult
            .actionParams(actionParams)
            .actionedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .id(1L)
            .initialState(SurveyInstanceStatus.NOT_STARTED)
            .message("Not all who wander are lost")
            .provenance("Provenance")
            .status(SurveyInstanceActionStatus.PENDING)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By")
            .surveyInstanceId(1L)
            .build()
            .withSurveyInstanceId(42L);

    // Assert
    LocalDateTime actionedAtResult = actualWithSurveyInstanceIdResult.actionedAt();
    LocalTime toLocalTimeResult = actionedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    assertEquals("1970-01-01", actionedAtResult.toLocalDate().toString());
    LocalDateTime submittedAtResult = actualWithSurveyInstanceIdResult.submittedAt();
    assertEquals("1970-01-01", submittedAtResult.toLocalDate().toString());
    assertEquals(42L, actualWithSurveyInstanceIdResult.surveyInstanceId().longValue());
    assertSame(toLocalTimeResult, submittedAtResult.toLocalTime());
  }
}
