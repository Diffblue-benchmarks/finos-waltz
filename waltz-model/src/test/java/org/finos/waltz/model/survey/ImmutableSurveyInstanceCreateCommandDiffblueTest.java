package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceCreateCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#approvalDueDate(LocalDate)}.
   *
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#approvalDueDate(LocalDate)}
   */
  @Test
  @DisplayName(
      "Test Builder approvalDueDate(LocalDate); when LocalDate with '1970' and one and one; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.approvalDueDate(LocalDate)"})
  void testBuilderApprovalDueDate_whenLocalDateWith1970AndOneAndOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();

    // Act
    Builder actualApprovalDueDateResult = builderResult.approvalDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertSame(builderResult, actualApprovalDueDateResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#issuedOn(LocalDate)}
   *   <li>{@link Builder#name(String)}
   *   <li>{@link Builder#owningRole(String)}
   *   <li>{@link Builder#status(SurveyInstanceStatus)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceCreateCommand Builder.build()",
    "Builder Builder.issuedOn(LocalDate)",
    "Builder Builder.name(String)",
    "Builder Builder.owningRole(String)",
    "Builder Builder.status(SurveyInstanceStatus)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    // Act
    Builder actualDueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .dueDate(dueDate);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    ImmutableSurveyInstanceCreateCommand actualImmutableSurveyInstanceCreateCommand =
        actualDueDateResult
            .entityReference(entityReference)
            .issuedOn(issuedOn)
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    // Assert
    LocalDate approvalDueDateResult = actualImmutableSurveyInstanceCreateCommand.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualImmutableSurveyInstanceCreateCommand.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualImmutableSurveyInstanceCreateCommand.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Name", actualImmutableSurveyInstanceCreateCommand.name());
    assertEquals("Owning Role", actualImmutableSurveyInstanceCreateCommand.owningRole());
    assertEquals(1L, actualImmutableSurveyInstanceCreateCommand.surveyRunId().longValue());
    assertEquals(
        SurveyInstanceStatus.NOT_STARTED, actualImmutableSurveyInstanceCreateCommand.status());
    assertSame(entityReference, actualImmutableSurveyInstanceCreateCommand.entityReference());
    assertSame(approvalDueDate, approvalDueDateResult);
    assertSame(dueDate, dueDateResult);
    assertSame(issuedOn, issuedOnResult);
  }

  /**
   * Test Builder {@link Builder#dueDate(LocalDate)}.
   *
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#dueDate(LocalDate)}
   */
  @Test
  @DisplayName(
      "Test Builder dueDate(LocalDate); when LocalDate with '1970' and one and one; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dueDate(LocalDate)"})
  void testBuilderDueDate_whenLocalDateWith1970AndOneAndOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();

    // Act
    Builder actualDueDateResult = builderResult.dueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertSame(builderResult, actualDueDateResult);
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceCreateCommand)}.
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceCreateCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();

    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand instance =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyInstanceCreateCommand actualImmutableSurveyInstanceCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceCreateCommand)}.
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceCreateCommand)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();

    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand instance =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole(null)
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyInstanceCreateCommand actualImmutableSurveyInstanceCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#surveyRunId(Long)}.
   *
   * <p>Method under test: {@link Builder#surveyRunId(Long)}
   */
  @Test
  @DisplayName("Test Builder surveyRunId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.surveyRunId(Long)"})
  void testBuilderSurveyRunId() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceCreateCommand.builder();

    // Act
    Builder actualSurveyRunIdResult = builderResult.surveyRunId(1L);

    // Assert
    assertSame(builderResult, actualSurveyRunIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#copyOf(SurveyInstanceCreateCommand)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceCreateCommand#copyOf(SurveyInstanceCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyInstanceCreateCommand); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceCreateCommand ImmutableSurveyInstanceCreateCommand.copyOf(SurveyInstanceCreateCommand)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .dueDate(dueDate);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    ImmutableSurveyInstanceCreateCommand instance =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(issuedOn)
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceCreateCommand actualCopyOfResult =
        ImmutableSurveyInstanceCreateCommand.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult2 = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult2.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.status());
    assertSame(approvalDueDate, approvalDueDateResult);
    assertSame(dueDate, dueDateResult2);
    assertSame(issuedOn, issuedOnResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}, and {@link
   * ImmutableSurveyInstanceCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    Builder dueDateResult2 =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand2 =
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyInstanceCreateCommand, immutableSurveyInstanceCreateCommand2);
    assertEquals(
        immutableSurveyInstanceCreateCommand.hashCode(),
        immutableSurveyInstanceCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}, and {@link
   * ImmutableSurveyInstanceCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyInstanceCreateCommand, immutableSurveyInstanceCreateCommand);
    int expectedHashCodeResult = immutableSurveyInstanceCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyInstanceCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.now())
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    Builder dueDateResult2 =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceCreateCommand,
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.now());
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    Builder dueDateResult2 =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceCreateCommand,
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    Builder dueDateResult2 =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceCreateCommand,
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.now())
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    Builder dueDateResult2 =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceCreateCommand,
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("approvalDueDate")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    Builder dueDateResult2 =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceCreateCommand,
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Name")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    Builder dueDateResult2 =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceCreateCommand,
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.IN_PROGRESS)
            .surveyRunId(1L)
            .build();

    Builder dueDateResult2 =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceCreateCommand,
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(2L)
            .build();

    Builder dueDateResult2 =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceCreateCommand,
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertNotEquals(
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceCreateCommand.equals(Object)",
    "int ImmutableSurveyInstanceCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertNotEquals(
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build(),
        "Different type to ImmutableSurveyInstanceCreateCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#toString()}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#approvalDueDate()}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#dueDate()}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#entityReference()}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#owningRole()}
   *   <li>{@link ImmutableSurveyInstanceCreateCommand#surveyRunId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalDate ImmutableSurveyInstanceCreateCommand.approvalDueDate()",
    "LocalDate ImmutableSurveyInstanceCreateCommand.dueDate()",
    "EntityReference ImmutableSurveyInstanceCreateCommand.entityReference()",
    "String ImmutableSurveyInstanceCreateCommand.owningRole()",
    "Long ImmutableSurveyInstanceCreateCommand.surveyRunId()",
    "String ImmutableSurveyInstanceCreateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .dueDate(dueDate);
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    // Act
    String actualToStringResult = immutableSurveyInstanceCreateCommand.toString();
    LocalDate actualApprovalDueDateResult = immutableSurveyInstanceCreateCommand.approvalDueDate();
    LocalDate actualDueDateResult = immutableSurveyInstanceCreateCommand.dueDate();
    EntityReference actualEntityReferenceResult =
        immutableSurveyInstanceCreateCommand.entityReference();
    String actualOwningRoleResult = immutableSurveyInstanceCreateCommand.owningRole();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("1970-01-01", actualApprovalDueDateResult.toString());
    assertEquals("1970-01-01", actualDueDateResult.toString());
    assertEquals("Owning Role", actualOwningRoleResult);
    assertEquals(
        "SurveyInstanceCreateCommand{surveyRunId=1, entityReference=EntityReference{kind=ALL, id=1, entityLif"
            + "ecycleStatus=ACTIVE}, dueDate=1970-01-01, approvalDueDate=1970-01-01, name=Name, status=NOT_STARTED,"
            + " owningRole=Owning Role, issuedOn=1970-01-01}",
        actualToStringResult);
    assertEquals(1L, immutableSurveyInstanceCreateCommand.surveyRunId().longValue());
    assertSame(approvalDueDate, actualApprovalDueDateResult);
    assertSame(dueDate, actualDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#issuedOn()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#issuedOn()}
   */
  @Test
  @DisplayName("Test issuedOn()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate ImmutableSurveyInstanceCreateCommand.issuedOn()"})
  void testIssuedOn() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    // Act
    LocalDate actualIssuedOnResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(issuedOn)
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build()
            .issuedOn();

    // Assert
    assertEquals("1970-01-01", actualIssuedOnResult.toString());
    assertSame(issuedOn, actualIssuedOnResult);
  }

  /**
   * Test Json {@link Json#approvalDueDate()}.
   *
   * <p>Method under test: {@link Json#approvalDueDate()}
   */
  @Test
  @DisplayName("Test Json approvalDueDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate Json.approvalDueDate()"})
  void testJsonApprovalDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().approvalDueDate());
  }

  /**
   * Test Json {@link Json#dueDate()}.
   *
   * <p>Method under test: {@link Json#dueDate()}
   */
  @Test
  @DisplayName("Test Json dueDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate Json.dueDate()"})
  void testJsonDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dueDate());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   *
   * <p>Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityReference());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setApprovalDueDate(LocalDate)}
   *   <li>{@link Json#setDueDate(LocalDate)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setIssuedOn(LocalDate)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setOwningRole(String)}
   *   <li>{@link Json#setStatus(SurveyInstanceStatus)}
   *   <li>{@link Json#setSurveyRunId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setApprovalDueDate(LocalDate)",
    "void Json.setDueDate(LocalDate)",
    "void Json.setEntityReference(EntityReference)",
    "void Json.setIssuedOn(LocalDate)",
    "void Json.setName(String)",
    "void Json.setOwningRole(String)",
    "void Json.setStatus(SurveyInstanceStatus)",
    "void Json.setSurveyRunId(Long)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setApprovalDueDate(LocalDate.of(1970, 1, 1));
    actualJson.setDueDate(LocalDate.of(1970, 1, 1));
    actualJson.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setIssuedOn(LocalDate.of(1970, 1, 1));
    actualJson.setName("Name");
    actualJson.setOwningRole("Owning Role");
    actualJson.setStatus(SurveyInstanceStatus.NOT_STARTED);
    actualJson.setSurveyRunId(1L);

    // Assert
    assertEquals("1970-01-01", actualJson.approvalDueDate.toString());
    assertEquals("1970-01-01", actualJson.dueDate.toString());
    assertEquals("1970-01-01", actualJson.issuedOn.toString());
    assertEquals(1L, actualJson.surveyRunId.longValue());
  }

  /**
   * Test Json {@link Json#issuedOn()}.
   *
   * <p>Method under test: {@link Json#issuedOn()}
   */
  @Test
  @DisplayName("Test Json issuedOn()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate Json.issuedOn()"})
  void testJsonIssuedOn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().issuedOn());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
  }

  /**
   * Test Json {@link Json#owningRole()}.
   *
   * <p>Method under test: {@link Json#owningRole()}
   */
  @Test
  @DisplayName("Test Json owningRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.owningRole()"})
  void testJsonOwningRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().owningRole());
  }

  /**
   * Test Json {@link Json#status()}.
   *
   * <p>Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyInstanceStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().status());
  }

  /**
   * Test Json {@link Json#surveyRunId()}.
   *
   * <p>Method under test: {@link Json#surveyRunId()}
   */
  @Test
  @DisplayName("Test Json surveyRunId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.surveyRunId()"})
  void testJsonSurveyRunId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().surveyRunId());
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#name()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#name()}
   */
  @Test
  @DisplayName("Test name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyInstanceCreateCommand.name()"})
  void testName() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertEquals(
        "Name",
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build()
            .name());
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#status()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#status()}
   */
  @Test
  @DisplayName("Test status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyInstanceStatus ImmutableSurveyInstanceCreateCommand.status()"})
  void testStatus() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertEquals(
        SurveyInstanceStatus.NOT_STARTED,
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build()
            .status());
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#withApprovalDueDate(LocalDate)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceCreateCommand#withApprovalDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withApprovalDueDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceCreateCommand ImmutableSurveyInstanceCreateCommand.withApprovalDueDate(LocalDate)"
  })
  void testWithApprovalDueDate() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceCreateCommand actualWithApprovalDueDateResult =
        immutableSurveyInstanceCreateCommand.withApprovalDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyInstanceCreateCommand, actualWithApprovalDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#withDueDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#withDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withDueDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceCreateCommand ImmutableSurveyInstanceCreateCommand.withDueDate(LocalDate)"
  })
  void testWithDueDate() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceCreateCommand actualWithDueDateResult =
        immutableSurveyInstanceCreateCommand.withDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyInstanceCreateCommand, actualWithDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceCreateCommand#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceCreateCommand ImmutableSurveyInstanceCreateCommand.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceCreateCommand actualWithEntityReferenceResult =
        immutableSurveyInstanceCreateCommand.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableSurveyInstanceCreateCommand, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#withIssuedOn(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#withIssuedOn(LocalDate)}
   */
  @Test
  @DisplayName("Test withIssuedOn(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceCreateCommand ImmutableSurveyInstanceCreateCommand.withIssuedOn(LocalDate)"
  })
  void testWithIssuedOn() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceCreateCommand actualWithIssuedOnResult =
        immutableSurveyInstanceCreateCommand.withIssuedOn(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyInstanceCreateCommand, actualWithIssuedOnResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceCreateCommand ImmutableSurveyInstanceCreateCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("42")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceCreateCommand actualWithNameResult =
        immutableSurveyInstanceCreateCommand.withName("42");

    // Assert
    assertSame(immutableSurveyInstanceCreateCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceCreateCommand ImmutableSurveyInstanceCreateCommand.withName(String)"
  })
  void testWithName_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));

    // Act
    ImmutableSurveyInstanceCreateCommand actualWithNameResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build()
            .withName("42");

    // Assert
    EntityReference entityReferenceResult = actualWithNameResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("1970-01-01", actualWithNameResult.approvalDueDate().toString());
    assertEquals("1970-01-01", actualWithNameResult.dueDate().toString());
    assertEquals("1970-01-01", actualWithNameResult.issuedOn().toString());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#withOwningRole(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#withOwningRole(String)}
   */
  @Test
  @DisplayName("Test withOwningRole(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceCreateCommand ImmutableSurveyInstanceCreateCommand.withOwningRole(String)"
  })
  void testWithOwningRole() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("42")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceCreateCommand actualWithOwningRoleResult =
        immutableSurveyInstanceCreateCommand.withOwningRole("42");

    // Assert
    assertSame(immutableSurveyInstanceCreateCommand, actualWithOwningRoleResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#withOwningRole(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#withOwningRole(String)}
   */
  @Test
  @DisplayName("Test withOwningRole(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceCreateCommand ImmutableSurveyInstanceCreateCommand.withOwningRole(String)"
  })
  void testWithOwningRole_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));

    // Act
    ImmutableSurveyInstanceCreateCommand actualWithOwningRoleResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build()
            .withOwningRole("42");

    // Assert
    EntityReference entityReferenceResult = actualWithOwningRoleResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("1970-01-01", actualWithOwningRoleResult.approvalDueDate().toString());
    assertEquals("1970-01-01", actualWithOwningRoleResult.dueDate().toString());
    assertEquals("1970-01-01", actualWithOwningRoleResult.issuedOn().toString());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#withStatus(SurveyInstanceStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceCreateCommand#withStatus(SurveyInstanceStatus)}
   */
  @Test
  @DisplayName("Test withStatus(SurveyInstanceStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceCreateCommand ImmutableSurveyInstanceCreateCommand.withStatus(SurveyInstanceStatus)"
  })
  void testWithStatus() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceCreateCommand actualWithStatusResult =
        immutableSurveyInstanceCreateCommand.withStatus(SurveyInstanceStatus.NOT_STARTED);

    // Assert
    assertSame(immutableSurveyInstanceCreateCommand, actualWithStatusResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#withStatus(SurveyInstanceStatus)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceCreateCommand#withStatus(SurveyInstanceStatus)}
   */
  @Test
  @DisplayName(
      "Test withStatus(SurveyInstanceStatus); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceCreateCommand ImmutableSurveyInstanceCreateCommand.withStatus(SurveyInstanceStatus)"
  })
  void testWithStatus_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));

    // Act
    ImmutableSurveyInstanceCreateCommand actualWithStatusResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.IN_PROGRESS)
            .surveyRunId(1L)
            .build()
            .withStatus(SurveyInstanceStatus.NOT_STARTED);

    // Assert
    EntityReference entityReferenceResult = actualWithStatusResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("1970-01-01", actualWithStatusResult.approvalDueDate().toString());
    assertEquals("1970-01-01", actualWithStatusResult.dueDate().toString());
    assertEquals("1970-01-01", actualWithStatusResult.issuedOn().toString());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#withSurveyRunId(Long)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#withSurveyRunId(Long)}
   */
  @Test
  @DisplayName("Test withSurveyRunId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceCreateCommand ImmutableSurveyInstanceCreateCommand.withSurveyRunId(Long)"
  })
  void testWithSurveyRunId() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));
    ImmutableSurveyInstanceCreateCommand immutableSurveyInstanceCreateCommand =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceCreateCommand actualWithSurveyRunIdResult =
        immutableSurveyInstanceCreateCommand.withSurveyRunId(1L);

    // Assert
    assertSame(immutableSurveyInstanceCreateCommand, actualWithSurveyRunIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceCreateCommand#withSurveyRunId(Long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceCreateCommand#withSurveyRunId(Long)}
   */
  @Test
  @DisplayName("Test withSurveyRunId(Long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceCreateCommand ImmutableSurveyInstanceCreateCommand.withSurveyRunId(Long)"
  })
  void testWithSurveyRunId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder dueDateResult =
        ImmutableSurveyInstanceCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1));

    // Act
    ImmutableSurveyInstanceCreateCommand actualWithSurveyRunIdResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .owningRole("Owning Role")
            .status(SurveyInstanceStatus.NOT_STARTED)
            .surveyRunId(1L)
            .build()
            .withSurveyRunId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithSurveyRunIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("1970-01-01", actualWithSurveyRunIdResult.approvalDueDate().toString());
    assertEquals("1970-01-01", actualWithSurveyRunIdResult.dueDate().toString());
    assertEquals("1970-01-01", actualWithSurveyRunIdResult.issuedOn().toString());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(42L, actualWithSurveyRunIdResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }
}
