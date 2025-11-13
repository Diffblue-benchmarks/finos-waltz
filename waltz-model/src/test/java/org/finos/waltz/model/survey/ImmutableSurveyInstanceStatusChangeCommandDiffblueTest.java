package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceStatusChangeCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceStatusChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceStatusChangeCommandDiffblueTest {
  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#action()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#action()}
   */
  @Test
  @DisplayName("Test action()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyInstanceAction ImmutableSurveyInstanceStatusChangeCommand.action()"})
  void testAction() {
    // Arrange, Act and Assert
    assertEquals(
        SurveyInstanceAction.SUBMITTING,
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build()
            .action());
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
    Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand.builder();

    // Act
    Builder actualActionResult = builderResult.action(SurveyInstanceAction.SUBMITTING);

    // Assert
    assertEquals(SurveyInstanceAction.SUBMITTING, builderResult.build().action());
    assertSame(builderResult, actualActionResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#newApprovalDueDate(LocalDate)}
   *   <li>{@link Builder#newDueDate(LocalDate)}
   *   <li>{@link Builder#reason(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceStatusChangeCommand Builder.build()",
    "Builder Builder.newApprovalDueDate(LocalDate)",
    "Builder Builder.newDueDate(LocalDate)",
    "Builder Builder.reason(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualNewApprovalDueDateResult =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1));
    Optional<? extends LocalDate> newApprovalDueDate = Optional.of(LocalDate.of(1970, 1, 1));
    Builder actualNewDueDateResult =
        actualNewApprovalDueDateResult
            .newApprovalDueDate(newApprovalDueDate)
            .newDueDate(LocalDate.of(1970, 1, 1));
    Optional<? extends LocalDate> newDueDate = Optional.of(LocalDate.of(1970, 1, 1));
    Builder actualReasonResult = actualNewDueDateResult.newDueDate(newDueDate).reason("Just cause");
    Optional<String> reason = Optional.of("42");

    // Assert
    assertEquals(
        SurveyInstanceAction.SUBMITTING, actualReasonResult.reason(reason).build().action());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceStatusChangeCommand)}.
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceStatusChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceStatusChangeCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand.builder();
    ImmutableSurveyInstanceStatusChangeCommand instance =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyInstanceStatusChangeCommand actualImmutableSurveyInstanceStatusChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceStatusChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newApprovalDueDate(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#newApprovalDueDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder newApprovalDueDate(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newApprovalDueDate(Optional)"})
  void testBuilderNewApprovalDueDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand.builder();
    Optional<? extends LocalDate> newApprovalDueDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    Builder actualNewApprovalDueDateResult = builderResult.newApprovalDueDate(newApprovalDueDate);

    // Assert
    assertSame(builderResult, actualNewApprovalDueDateResult);
  }

  /**
   * Test Builder {@link Builder#newDueDate(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#newDueDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder newDueDate(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.newDueDate(Optional)"})
  void testBuilderNewDueDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand.builder();
    Optional<? extends LocalDate> newDueDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    Builder actualNewDueDateResult = builderResult.newDueDate(newDueDate);

    // Assert
    assertSame(builderResult, actualNewDueDateResult);
  }

  /**
   * Test Builder {@link Builder#reason(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#reason(Optional)}
   */
  @Test
  @DisplayName("Test Builder reason(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.reason(Optional)"})
  void testBuilderReasonWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceStatusChangeCommand.builder();
    Optional<String> reason = Optional.of("42");

    // Act
    Builder actualReasonResult = builderResult.reason(reason);

    // Assert
    assertSame(builderResult, actualReasonResult);
  }

  /**
   * Test {@link
   * ImmutableSurveyInstanceStatusChangeCommand#copyOf(SurveyInstanceStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Then return action is {@code SUBMITTING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceStatusChangeCommand#copyOf(SurveyInstanceStatusChangeCommand)}
   */
  @Test
  @DisplayName("Test copyOf(SurveyInstanceStatusChangeCommand); then return action is 'SUBMITTING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceStatusChangeCommand ImmutableSurveyInstanceStatusChangeCommand.copyOf(SurveyInstanceStatusChangeCommand)"
  })
  void testCopyOf_thenReturnActionIsSubmitting() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand instance =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();

    // Act and Assert
    assertEquals(
        SurveyInstanceAction.SUBMITTING,
        ImmutableSurveyInstanceStatusChangeCommand.copyOf(instance).action());
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#equals(Object)}, and {@link
   * ImmutableSurveyInstanceStatusChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceStatusChangeCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceStatusChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceStatusChangeCommand.equals(Object)",
    "int ImmutableSurveyInstanceStatusChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand immutableSurveyInstanceStatusChangeCommand =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    ImmutableSurveyInstanceStatusChangeCommand immutableSurveyInstanceStatusChangeCommand2 =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();

    // Act and Assert
    assertEquals(
        immutableSurveyInstanceStatusChangeCommand, immutableSurveyInstanceStatusChangeCommand2);
    assertEquals(
        immutableSurveyInstanceStatusChangeCommand.hashCode(),
        immutableSurveyInstanceStatusChangeCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#equals(Object)}, and {@link
   * ImmutableSurveyInstanceStatusChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceStatusChangeCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceStatusChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceStatusChangeCommand.equals(Object)",
    "int ImmutableSurveyInstanceStatusChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand immutableSurveyInstanceStatusChangeCommand =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();

    // Act and Assert
    assertEquals(
        immutableSurveyInstanceStatusChangeCommand, immutableSurveyInstanceStatusChangeCommand);
    int expectedHashCodeResult = immutableSurveyInstanceStatusChangeCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyInstanceStatusChangeCommand.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceStatusChangeCommand.equals(Object)",
    "int ImmutableSurveyInstanceStatusChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand immutableSurveyInstanceStatusChangeCommand =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.REJECTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceStatusChangeCommand,
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceStatusChangeCommand.equals(Object)",
    "int ImmutableSurveyInstanceStatusChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand immutableSurveyInstanceStatusChangeCommand =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.now())
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceStatusChangeCommand,
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceStatusChangeCommand.equals(Object)",
    "int ImmutableSurveyInstanceStatusChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand immutableSurveyInstanceStatusChangeCommand =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.now())
            .reason("Just cause")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceStatusChangeCommand,
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceStatusChangeCommand.equals(Object)",
    "int ImmutableSurveyInstanceStatusChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand immutableSurveyInstanceStatusChangeCommand =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Reason")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceStatusChangeCommand,
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceStatusChangeCommand.equals(Object)",
    "int ImmutableSurveyInstanceStatusChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceStatusChangeCommand.equals(Object)",
    "int ImmutableSurveyInstanceStatusChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build(),
        "Different type to ImmutableSurveyInstanceStatusChangeCommand");
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Reason is {@code null}.
   *   <li>Then return action is {@code SUBMITTING}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Reason is 'null'; then return action is 'SUBMITTING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceStatusChangeCommand ImmutableSurveyInstanceStatusChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonReasonIsNull_thenReturnActionIsSubmitting() {
    // Arrange
    Json json = new Json();
    json.setAction(SurveyInstanceAction.SUBMITTING);
    json.setReason(null);
    Optional<LocalDate> newDueDate = Optional.of(LocalDate.of(1970, 1, 1));
    json.setNewDueDate(newDueDate);
    Optional<LocalDate> newApprovalDueDate = Optional.of(LocalDate.of(1970, 1, 1));
    json.setNewApprovalDueDate(newApprovalDueDate);

    // Act
    ImmutableSurveyInstanceStatusChangeCommand actualFromJsonResult =
        ImmutableSurveyInstanceStatusChangeCommand.fromJson(json);

    // Assert
    assertEquals(SurveyInstanceAction.SUBMITTING, actualFromJsonResult.action());
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   *   <li>When {@link Json} (default constructor) NewApprovalDueDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of '42'; when Json (default constructor) NewApprovalDueDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceStatusChangeCommand ImmutableSurveyInstanceStatusChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenOf42_whenJsonNewApprovalDueDateIsNull() {
    // Arrange
    Json json = new Json();
    json.setAction(SurveyInstanceAction.SUBMITTING);
    Optional<String> reason = Optional.of("42");
    json.setReason(reason);
    Optional<LocalDate> newDueDate = Optional.of(LocalDate.of(1970, 1, 1));
    json.setNewDueDate(newDueDate);
    json.setNewApprovalDueDate(null);

    // Act
    ImmutableSurveyInstanceStatusChangeCommand actualFromJsonResult =
        ImmutableSurveyInstanceStatusChangeCommand.fromJson(json);

    // Assert
    assertEquals(SurveyInstanceAction.SUBMITTING, actualFromJsonResult.action());
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   *   <li>When {@link Json} (default constructor) NewDueDate is {@code null}.
   *   <li>Then return action is {@code SUBMITTING}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of '42'; when Json (default constructor) NewDueDate is 'null'; then return action is 'SUBMITTING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceStatusChangeCommand ImmutableSurveyInstanceStatusChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenOf42_whenJsonNewDueDateIsNull_thenReturnActionIsSubmitting() {
    // Arrange
    Json json = new Json();
    json.setAction(SurveyInstanceAction.SUBMITTING);
    Optional<String> reason = Optional.of("42");
    json.setReason(reason);
    json.setNewDueDate(null);
    Optional<LocalDate> newApprovalDueDate = Optional.of(LocalDate.of(1970, 1, 1));
    json.setNewApprovalDueDate(newApprovalDueDate);

    // Act
    ImmutableSurveyInstanceStatusChangeCommand actualFromJsonResult =
        ImmutableSurveyInstanceStatusChangeCommand.fromJson(json);

    // Assert
    assertEquals(SurveyInstanceAction.SUBMITTING, actualFromJsonResult.action());
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   *   <li>When {@link Json} (default constructor) Reason is of {@code 42}.
   *   <li>Then return action is {@code SUBMITTING}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of '42'; when Json (default constructor) Reason is of '42'; then return action is 'SUBMITTING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceStatusChangeCommand ImmutableSurveyInstanceStatusChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenOf42_whenJsonReasonIsOf42_thenReturnActionIsSubmitting() {
    // Arrange
    Json json = new Json();
    json.setAction(SurveyInstanceAction.SUBMITTING);
    Optional<String> reason = Optional.of("42");
    json.setReason(reason);
    Optional<LocalDate> newDueDate = Optional.of(LocalDate.of(1970, 1, 1));
    json.setNewDueDate(newDueDate);
    Optional<LocalDate> newApprovalDueDate = Optional.of(LocalDate.of(1970, 1, 1));
    json.setNewApprovalDueDate(newApprovalDueDate);

    // Act
    ImmutableSurveyInstanceStatusChangeCommand actualFromJsonResult =
        ImmutableSurveyInstanceStatusChangeCommand.fromJson(json);

    // Assert
    assertEquals(SurveyInstanceAction.SUBMITTING, actualFromJsonResult.action());
  }

  /**
   * Test Json {@link Json#action()}.
   *
   * <p>Method under test: {@link Json#action()}
   */
  @Test
  @DisplayName("Test Json action()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyInstanceAction Json.action()"})
  void testJsonAction() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().action());
  }

  /**
   * Test Json {@link Json#newApprovalDueDate()}.
   *
   * <p>Method under test: {@link Json#newApprovalDueDate()}
   */
  @Test
  @DisplayName("Test Json newApprovalDueDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.newApprovalDueDate()"})
  void testJsonNewApprovalDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().newApprovalDueDate());
  }

  /**
   * Test Json {@link Json#newDueDate()}.
   *
   * <p>Method under test: {@link Json#newDueDate()}
   */
  @Test
  @DisplayName("Test Json newDueDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.newDueDate()"})
  void testJsonNewDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().newDueDate());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.action);
    assertFalse(actualJson.newApprovalDueDate.isPresent());
    assertFalse(actualJson.newDueDate.isPresent());
    assertFalse(actualJson.reason.isPresent());
  }

  /**
   * Test Json {@link Json#reason()}.
   *
   * <p>Method under test: {@link Json#reason()}
   */
  @Test
  @DisplayName("Test Json reason()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.reason()"})
  void testJsonReason() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().reason());
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#newApprovalDueDate()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#newApprovalDueDate()}
   */
  @Test
  @DisplayName("Test newApprovalDueDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyInstanceStatusChangeCommand.newApprovalDueDate()"})
  void testNewApprovalDueDate() {
    // Arrange
    LocalDate newApprovalDueDate = LocalDate.of(1970, 1, 1);

    // Act
    Optional<LocalDate> actualNewApprovalDueDateResult =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(newApprovalDueDate)
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build()
            .newApprovalDueDate();

    // Assert
    LocalDate getResult = actualNewApprovalDueDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(actualNewApprovalDueDateResult.isPresent());
    assertSame(newApprovalDueDate, getResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#newDueDate()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#newDueDate()}
   */
  @Test
  @DisplayName("Test newDueDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyInstanceStatusChangeCommand.newDueDate()"})
  void testNewDueDate() {
    // Arrange
    LocalDate newDueDate = LocalDate.of(1970, 1, 1);

    // Act
    Optional<LocalDate> actualNewDueDateResult =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(newDueDate)
            .reason("Just cause")
            .build()
            .newDueDate();

    // Assert
    LocalDate getResult = actualNewDueDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(actualNewDueDateResult.isPresent());
    assertSame(newDueDate, getResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#reason()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#reason()}
   */
  @Test
  @DisplayName("Test reason()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyInstanceStatusChangeCommand.reason()"})
  void testReason() {
    // Arrange and Act
    Optional<String> actualReasonResult =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build()
            .reason();

    // Assert
    assertEquals("Just cause", actualReasonResult.get());
    assertTrue(actualReasonResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyInstanceStatusChangeCommand.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "SurveyInstanceStatusChangeCommand{action=SUBMITTING, reason=Just cause, newDueDate=1970-01-01,"
            + " newApprovalDueDate=1970-01-01}",
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#withAction(SurveyInstanceAction)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceStatusChangeCommand#withAction(SurveyInstanceAction)}
   */
  @Test
  @DisplayName("Test withAction(SurveyInstanceAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceStatusChangeCommand ImmutableSurveyInstanceStatusChangeCommand.withAction(SurveyInstanceAction)"
  })
  void testWithAction() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand immutableSurveyInstanceStatusChangeCommand =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();

    // Act
    ImmutableSurveyInstanceStatusChangeCommand actualWithActionResult =
        immutableSurveyInstanceStatusChangeCommand.withAction(SurveyInstanceAction.SUBMITTING);

    // Assert
    assertSame(immutableSurveyInstanceStatusChangeCommand, actualWithActionResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#withAction(SurveyInstanceAction)}.
   *
   * <ul>
   *   <li>Then return action is {@code SUBMITTING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceStatusChangeCommand#withAction(SurveyInstanceAction)}
   */
  @Test
  @DisplayName("Test withAction(SurveyInstanceAction); then return action is 'SUBMITTING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceStatusChangeCommand ImmutableSurveyInstanceStatusChangeCommand.withAction(SurveyInstanceAction)"
  })
  void testWithAction_thenReturnActionIsSubmitting() {
    // Arrange, Act and Assert
    assertEquals(
        SurveyInstanceAction.SUBMITTING,
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.REJECTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build()
            .withAction(SurveyInstanceAction.SUBMITTING)
            .action());
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#withNewApprovalDueDate(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceStatusChangeCommand#withNewApprovalDueDate(Optional)}
   */
  @Test
  @DisplayName("Test withNewApprovalDueDate(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceStatusChangeCommand ImmutableSurveyInstanceStatusChangeCommand.withNewApprovalDueDate(Optional)"
  })
  void testWithNewApprovalDueDateWithOptional() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand immutableSurveyInstanceStatusChangeCommand =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends LocalDate> optional = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    ImmutableSurveyInstanceStatusChangeCommand actualWithNewApprovalDueDateResult =
        immutableSurveyInstanceStatusChangeCommand.withNewApprovalDueDate(optional);

    // Assert
    assertEquals(immutableSurveyInstanceStatusChangeCommand, actualWithNewApprovalDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#withNewApprovalDueDate(LocalDate)} with
   * {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceStatusChangeCommand#withNewApprovalDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withNewApprovalDueDate(LocalDate) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceStatusChangeCommand ImmutableSurveyInstanceStatusChangeCommand.withNewApprovalDueDate(LocalDate)"
  })
  void testWithNewApprovalDueDateWithValue() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand immutableSurveyInstanceStatusChangeCommand =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();

    // Act
    ImmutableSurveyInstanceStatusChangeCommand actualWithNewApprovalDueDateResult =
        immutableSurveyInstanceStatusChangeCommand.withNewApprovalDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyInstanceStatusChangeCommand, actualWithNewApprovalDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#withNewDueDate(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceStatusChangeCommand#withNewDueDate(Optional)}
   */
  @Test
  @DisplayName("Test withNewDueDate(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceStatusChangeCommand ImmutableSurveyInstanceStatusChangeCommand.withNewDueDate(Optional)"
  })
  void testWithNewDueDateWithOptional() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand immutableSurveyInstanceStatusChangeCommand =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<? extends LocalDate> optional = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    ImmutableSurveyInstanceStatusChangeCommand actualWithNewDueDateResult =
        immutableSurveyInstanceStatusChangeCommand.withNewDueDate(optional);

    // Assert
    assertEquals(immutableSurveyInstanceStatusChangeCommand, actualWithNewDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#withNewDueDate(LocalDate)} with {@code
   * value}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceStatusChangeCommand#withNewDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withNewDueDate(LocalDate) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceStatusChangeCommand ImmutableSurveyInstanceStatusChangeCommand.withNewDueDate(LocalDate)"
  })
  void testWithNewDueDateWithValue() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand immutableSurveyInstanceStatusChangeCommand =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();

    // Act
    ImmutableSurveyInstanceStatusChangeCommand actualWithNewDueDateResult =
        immutableSurveyInstanceStatusChangeCommand.withNewDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyInstanceStatusChangeCommand, actualWithNewDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#withReason(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#withReason(Optional)}
   */
  @Test
  @DisplayName("Test withReason(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceStatusChangeCommand ImmutableSurveyInstanceStatusChangeCommand.withReason(Optional)"
  })
  void testWithReasonWithOptional() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand immutableSurveyInstanceStatusChangeCommand =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("42")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyInstanceStatusChangeCommand actualWithReasonResult =
        immutableSurveyInstanceStatusChangeCommand.withReason(optional);

    // Assert
    assertSame(immutableSurveyInstanceStatusChangeCommand, actualWithReasonResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#withReason(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then return action is {@code SUBMITTING}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#withReason(Optional)}
   */
  @Test
  @DisplayName("Test withReason(Optional) with 'optional'; then return action is 'SUBMITTING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceStatusChangeCommand ImmutableSurveyInstanceStatusChangeCommand.withReason(Optional)"
  })
  void testWithReasonWithOptional_thenReturnActionIsSubmitting() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand immutableSurveyInstanceStatusChangeCommand =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act and Assert
    assertEquals(
        SurveyInstanceAction.SUBMITTING,
        immutableSurveyInstanceStatusChangeCommand.withReason(optional).action());
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#withReason(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#withReason(String)}
   */
  @Test
  @DisplayName("Test withReason(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceStatusChangeCommand ImmutableSurveyInstanceStatusChangeCommand.withReason(String)"
  })
  void testWithReasonWithValue() {
    // Arrange
    ImmutableSurveyInstanceStatusChangeCommand immutableSurveyInstanceStatusChangeCommand =
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("42")
            .build();

    // Act
    ImmutableSurveyInstanceStatusChangeCommand actualWithReasonResult =
        immutableSurveyInstanceStatusChangeCommand.withReason("42");

    // Assert
    assertSame(immutableSurveyInstanceStatusChangeCommand, actualWithReasonResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceStatusChangeCommand#withReason(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return action is {@code SUBMITTING}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceStatusChangeCommand#withReason(String)}
   */
  @Test
  @DisplayName("Test withReason(String) with 'value'; then return action is 'SUBMITTING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceStatusChangeCommand ImmutableSurveyInstanceStatusChangeCommand.withReason(String)"
  })
  void testWithReasonWithValue_thenReturnActionIsSubmitting() {
    // Arrange, Act and Assert
    assertEquals(
        SurveyInstanceAction.SUBMITTING,
        ImmutableSurveyInstanceStatusChangeCommand.builder()
            .action(SurveyInstanceAction.SUBMITTING)
            .newApprovalDueDate(LocalDate.of(1970, 1, 1))
            .newDueDate(LocalDate.of(1970, 1, 1))
            .reason("Just cause")
            .build()
            .withReason("42")
            .action());
  }
}
