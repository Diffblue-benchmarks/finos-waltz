package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyInstance.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstance.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceDiffblueTest {
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
    Builder builderResult = ImmutableSurveyInstance.builder();

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
   *   <li>{@link Builder#approvedAt(LocalDateTime)}
   *   <li>{@link Builder#approvedBy(String)}
   *   <li>{@link Builder#issuedOn(LocalDate)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#name(String)}
   *   <li>{@link Builder#originalInstanceId(Long)}
   *   <li>{@link Builder#owningRole(String)}
   *   <li>{@link Builder#qualifierEntity(EntityReference)}
   *   <li>{@link Builder#submittedAt(LocalDateTime)}
   *   <li>{@link Builder#submittedBy(String)}
   *   <li>{@link Builder#surveyEntityExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.approvedAt(LocalDateTime)",
    "Builder Builder.approvedBy(String)",
    "ImmutableSurveyInstance Builder.build()",
    "Builder Builder.issuedOn(LocalDate)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.name(String)",
    "Builder Builder.originalInstanceId(Long)",
    "Builder Builder.owningRole(String)",
    "Builder Builder.qualifierEntity(EntityReference)",
    "Builder Builder.submittedAt(LocalDateTime)",
    "Builder Builder.submittedBy(String)",
    "Builder Builder.surveyEntityExternalId(String)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDateTime approvedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    // Act
    Builder actualIdResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(approvalDueDate)
            .approvedAt(approvedAt)
            .approvedBy("Approved By")
            .dueDate(dueDate)
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    Builder actualOwningRoleResult =
        actualIdResult
            .id(id)
            .issuedOn(issuedOn)
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(1L)
            .owningRole("Owning Role");
    ImmutableEntityReference qualifierEntity =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    LocalDateTime submittedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualSubmittedByResult =
        actualOwningRoleResult
            .qualifierEntity(qualifierEntity)
            .status(SurveyInstanceStatus.NOT_STARTED)
            .submittedAt(submittedAt)
            .submittedBy("Submitted By");
    ImmutableEntityReference surveyEntity =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableSurveyInstance actualImmutableSurveyInstance =
        actualSubmittedByResult
            .surveyEntity(surveyEntity)
            .surveyEntityExternalId("42")
            .surveyRunId(1L)
            .build();

    // Assert
    LocalDate approvalDueDateResult = actualImmutableSurveyInstance.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualImmutableSurveyInstance.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualImmutableSurveyInstance.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("42", actualImmutableSurveyInstance.surveyEntityExternalId());
    assertEquals("Approved By", actualImmutableSurveyInstance.approvedBy());
    assertEquals("Name", actualImmutableSurveyInstance.name());
    assertEquals("Owning Role", actualImmutableSurveyInstance.owningRole());
    assertEquals("Submitted By", actualImmutableSurveyInstance.submittedBy());
    assertEquals(1L, actualImmutableSurveyInstance.originalInstanceId().longValue());
    assertEquals(1L, actualImmutableSurveyInstance.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualImmutableSurveyInstance.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualImmutableSurveyInstance.status());
    assertSame(approvedAt, actualImmutableSurveyInstance.approvedAt());
    assertSame(submittedAt, actualImmutableSurveyInstance.submittedAt());
    assertSame(qualifierEntity, actualImmutableSurveyInstance.qualifierEntity());
    assertSame(surveyEntity, actualImmutableSurveyInstance.surveyEntity());
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
    Builder builderResult = ImmutableSurveyInstance.builder();

    // Act
    Builder actualDueDateResult = builderResult.dueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertSame(builderResult, actualDueDateResult);
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
    Builder builderResult = ImmutableSurveyInstance.builder();

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
    ImmutableSurveyInstance instance =
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
            .build();

    // Act and Assert
    ImmutableSurveyInstance actualImmutableSurveyInstance =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyInstance);
    ImmutableSurveyInstance actualImmutableSurveyInstance2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstance2);
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
  void testBuilderFromWithIdProvider2() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

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
            .originalInstanceId(null)
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
    ImmutableSurveyInstance instance =
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
            .build();

    // Act and Assert
    ImmutableSurveyInstance actualImmutableSurveyInstance =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyInstance);
    ImmutableSurveyInstance actualImmutableSurveyInstance2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstance2);
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
  void testBuilderFromWithIdProvider3() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy(null)
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
    ImmutableSurveyInstance instance =
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
            .build();

    // Act and Assert
    ImmutableSurveyInstance actualImmutableSurveyInstance =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyInstance);
    ImmutableSurveyInstance actualImmutableSurveyInstance2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstance2);
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
  void testBuilderFromWithIdProvider4() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name(null)
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
    ImmutableSurveyInstance instance =
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
            .build();

    // Act and Assert
    ImmutableSurveyInstance actualImmutableSurveyInstance =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyInstance);
    ImmutableSurveyInstance actualImmutableSurveyInstance2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstance2);
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
  void testBuilderFromWithIdProvider5() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

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
            .owningRole(null);

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
    ImmutableSurveyInstance instance =
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
            .build();

    // Act and Assert
    ImmutableSurveyInstance actualImmutableSurveyInstance =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyInstance);
    ImmutableSurveyInstance actualImmutableSurveyInstance2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstance2);
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
    Builder builderResult = ImmutableSurveyInstance.builder();

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
    Builder builderResult = ImmutableSurveyInstance.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstance)} with {@code SurveyInstance}.
   *
   * <p>Method under test: {@link Builder#from(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstance) with 'SurveyInstance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstance)"})
  void testBuilderFromWithSurveyInstance() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

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
    ImmutableSurveyInstance instance =
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
            .build();

    // Act and Assert
    ImmutableSurveyInstance actualImmutableSurveyInstance = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyInstance);
    ImmutableSurveyInstance actualImmutableSurveyInstance2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstance2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstance)} with {@code SurveyInstance}.
   *
   * <p>Method under test: {@link Builder#from(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstance) with 'SurveyInstance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstance)"})
  void testBuilderFromWithSurveyInstance2() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

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
            .originalInstanceId(null)
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
    ImmutableSurveyInstance instance =
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
            .build();

    // Act and Assert
    ImmutableSurveyInstance actualImmutableSurveyInstance = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyInstance);
    ImmutableSurveyInstance actualImmutableSurveyInstance2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstance2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstance)} with {@code SurveyInstance}.
   *
   * <p>Method under test: {@link Builder#from(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstance) with 'SurveyInstance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstance)"})
  void testBuilderFromWithSurveyInstance3() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy(null)
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
    ImmutableSurveyInstance instance =
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
            .build();

    // Act and Assert
    ImmutableSurveyInstance actualImmutableSurveyInstance = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyInstance);
    ImmutableSurveyInstance actualImmutableSurveyInstance2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstance2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstance)} with {@code SurveyInstance}.
   *
   * <p>Method under test: {@link Builder#from(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstance) with 'SurveyInstance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstance)"})
  void testBuilderFromWithSurveyInstance4() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name(null)
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
    ImmutableSurveyInstance instance =
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
            .build();

    // Act and Assert
    ImmutableSurveyInstance actualImmutableSurveyInstance = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyInstance);
    ImmutableSurveyInstance actualImmutableSurveyInstance2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstance2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstance)} with {@code SurveyInstance}.
   *
   * <p>Method under test: {@link Builder#from(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstance) with 'SurveyInstance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstance)"})
  void testBuilderFromWithSurveyInstance5() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

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
            .owningRole(null);

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
    ImmutableSurveyInstance instance =
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
            .build();

    // Act and Assert
    ImmutableSurveyInstance actualImmutableSurveyInstance = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyInstance);
    ImmutableSurveyInstance actualImmutableSurveyInstance2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstance2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstance)} with {@code SurveyInstance}.
   *
   * <p>Method under test: {@link Builder#from(SurveyInstance)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstance) with 'SurveyInstance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstance)"})
  void testBuilderFromWithSurveyInstance6() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

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
            .submittedBy(null);
    ImmutableSurveyInstance instance =
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
            .build();

    // Act and Assert
    ImmutableSurveyInstance actualImmutableSurveyInstance = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyInstance);
    ImmutableSurveyInstance actualImmutableSurveyInstance2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstance2);
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
    Builder builderResult = ImmutableSurveyInstance.builder();

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
    Builder builderResult = ImmutableSurveyInstance.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#status(SurveyInstanceStatus)}.
   *
   * <p>Method under test: {@link Builder#status(SurveyInstanceStatus)}
   */
  @Test
  @DisplayName("Test Builder status(SurveyInstanceStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.status(SurveyInstanceStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

    // Act
    Builder actualStatusResult = builderResult.status(SurveyInstanceStatus.NOT_STARTED);

    // Assert
    assertSame(builderResult, actualStatusResult);
  }

  /**
   * Test Builder {@link Builder#surveyEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#surveyEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder surveyEntity(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.surveyEntity(EntityReference)"})
  void testBuilderSurveyEntity_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstance.builder();

    // Act
    Builder actualSurveyEntityResult =
        builderResult.surveyEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualSurveyEntityResult);
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
    Builder builderResult = ImmutableSurveyInstance.builder();

    // Act
    Builder actualSurveyRunIdResult = builderResult.surveyRunId(1L);

    // Assert
    assertSame(builderResult, actualSurveyRunIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#copyOf(SurveyInstance)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#copyOf(SurveyInstance)}
   */
  @Test
  @DisplayName("Test copyOf(SurveyInstance); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.copyOf(SurveyInstance)"})
  void testCopyOf_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(approvalDueDate)
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(dueDate)
            .id(1L)
            .issuedOn(issuedOn)
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
    ImmutableSurveyInstance instance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualCopyOfResult = ImmutableSurveyInstance.copyOf(instance);

    // Assert
    EntityReference qualifierEntityResult = actualCopyOfResult.qualifierEntity();
    assertTrue(qualifierEntityResult instanceof ImmutableEntityReference);
    EntityReference surveyEntityResult = actualCopyOfResult.surveyEntity();
    assertTrue(surveyEntityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualCopyOfResult.surveyEntityExternalId());
    assertEquals("Approved By", actualCopyOfResult.approvedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    assertEquals("Submitted By", actualCopyOfResult.submittedBy());
    assertEquals(1L, actualCopyOfResult.originalInstanceId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualCopyOfResult.status());
    assertEquals(qualifierEntityResult, surveyEntityResult);
    assertSame(approvalDueDate, actualCopyOfResult.approvalDueDate());
    assertSame(dueDate, actualCopyOfResult.dueDate());
    assertSame(issuedOn, actualCopyOfResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}, and {@link
   * ImmutableSurveyInstance#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstance#equals(Object)}
   *   <li>{@link ImmutableSurveyInstance#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    ImmutableSurveyInstance immutableSurveyInstance2 =
        submittedByResult2
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
            .build();

    // Act and Assert
    assertEquals(immutableSurveyInstance, immutableSurveyInstance2);
    assertEquals(immutableSurveyInstance.hashCode(), immutableSurveyInstance2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}, and {@link
   * ImmutableSurveyInstance#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstance#equals(Object)}
   *   <li>{@link ImmutableSurveyInstance#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act and Assert
    assertEquals(immutableSurveyInstance, immutableSurveyInstance);
    int expectedHashCodeResult = immutableSurveyInstance.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyInstance.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.now())
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.now().atStartOfDay())
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("approvalDueDate")
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.now())
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(2L)
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.now())
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ACTOR)
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("approvalDueDate")
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
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
            .originalInstanceId(2L)
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
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
            .owningRole("approvalDueDate");

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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
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
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(SurveyInstanceStatus.NOT_STARTED)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By");
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
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
            .status(SurveyInstanceStatus.IN_PROGRESS)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By");
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
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
            .submittedAt(LocalDate.now().atStartOfDay())
            .submittedBy("Submitted By");
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
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
            .submittedBy("approvalDueDate");
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
        submittedByResult
            .surveyEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .surveyEntityExternalId("42")
            .surveyRunId(1L)
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .surveyEntityExternalId("Survey Entity External Id")
            .surveyRunId(1L)
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .surveyRunId(2L)
            .build();

    Builder owningRoleResult2 =
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

    Builder submittedByResult2 =
        owningRoleResult2
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
    assertNotEquals(
        immutableSurveyInstance,
        submittedByResult2
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
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
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
    assertNotEquals(
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
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstance.equals(Object)",
    "int ImmutableSurveyInstance.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
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
    assertNotEquals(
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
            .build(),
        "Different type to ImmutableSurveyInstance");
  }

  /**
   * Test {@link ImmutableSurveyInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return approvedBy is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Id is 'null'; then return approvedBy is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonIdIsNull_thenReturnApprovedByIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setSurveyRunId(1L);
    json.setSurveyEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setQualifierEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSurveyEntityExternalId("Json");
    json.setStatus(SurveyInstanceStatus.NOT_STARTED);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setApprovalDueDate(LocalDate.of(1970, 1, 1));
    json.setSubmittedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setSubmittedBy("Json");
    json.setApprovedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setApprovedBy("Json");
    json.setOriginalInstanceId(1L);
    json.setOwningRole("Json");
    json.setName("Json");
    json.setKind(EntityKind.ALL);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);

    // Act
    ImmutableSurveyInstance actualFromJsonResult = ImmutableSurveyInstance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.approvedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.owningRole());
    assertEquals("Json", actualFromJsonResult.submittedBy());
    assertEquals("Json", actualFromJsonResult.surveyEntityExternalId());
    assertEquals(1L, actualFromJsonResult.originalInstanceId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertSame(issuedOn, actualFromJsonResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) ApprovedBy is {@code null}.
   *   <li>Then return approvedBy is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) ApprovedBy is 'null'; then return approvedBy is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.fromJson(Json)"})
  void testFromJson_givenOfFortyTwo_whenJsonApprovedByIsNull_thenReturnApprovedByIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setSurveyRunId(1L);
    json.setSurveyEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setQualifierEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSurveyEntityExternalId("Json");
    json.setStatus(SurveyInstanceStatus.NOT_STARTED);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setApprovalDueDate(LocalDate.of(1970, 1, 1));
    json.setSubmittedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setSubmittedBy("Json");
    json.setApprovedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setApprovedBy(null);
    json.setOriginalInstanceId(1L);
    json.setOwningRole("Json");
    json.setName("Json");
    json.setKind(EntityKind.ALL);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);

    // Act
    ImmutableSurveyInstance actualFromJsonResult = ImmutableSurveyInstance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.owningRole());
    assertEquals("Json", actualFromJsonResult.submittedBy());
    assertEquals("Json", actualFromJsonResult.surveyEntityExternalId());
    assertNull(actualFromJsonResult.approvedBy());
    assertEquals(1L, actualFromJsonResult.originalInstanceId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertSame(issuedOn, actualFromJsonResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) Id is of forty-two.
   *   <li>Then return approvedBy is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) Id is of forty-two; then return approvedBy is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.fromJson(Json)"})
  void testFromJson_givenOfFortyTwo_whenJsonIdIsOfFortyTwo_thenReturnApprovedByIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setSurveyRunId(1L);
    json.setSurveyEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setQualifierEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSurveyEntityExternalId("Json");
    json.setStatus(SurveyInstanceStatus.NOT_STARTED);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setApprovalDueDate(LocalDate.of(1970, 1, 1));
    json.setSubmittedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setSubmittedBy("Json");
    json.setApprovedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setApprovedBy("Json");
    json.setOriginalInstanceId(1L);
    json.setOwningRole("Json");
    json.setName("Json");
    json.setKind(EntityKind.ALL);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);

    // Act
    ImmutableSurveyInstance actualFromJsonResult = ImmutableSurveyInstance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.approvedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.owningRole());
    assertEquals("Json", actualFromJsonResult.submittedBy());
    assertEquals("Json", actualFromJsonResult.surveyEntityExternalId());
    assertEquals(1L, actualFromJsonResult.originalInstanceId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertSame(issuedOn, actualFromJsonResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) IssuedOn is {@code null}.
   *   <li>Then return approvedBy is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) IssuedOn is 'null'; then return approvedBy is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.fromJson(Json)"})
  void testFromJson_givenOfFortyTwo_whenJsonIssuedOnIsNull_thenReturnApprovedByIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setSurveyRunId(1L);
    json.setSurveyEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setQualifierEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSurveyEntityExternalId("Json");
    json.setStatus(SurveyInstanceStatus.NOT_STARTED);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setApprovalDueDate(LocalDate.of(1970, 1, 1));
    json.setSubmittedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setSubmittedBy("Json");
    json.setApprovedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setApprovedBy("Json");
    json.setOriginalInstanceId(1L);
    json.setOwningRole("Json");
    json.setName("Json");
    json.setKind(EntityKind.ALL);
    json.setIssuedOn(null);

    // Act
    ImmutableSurveyInstance actualFromJsonResult = ImmutableSurveyInstance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.approvedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.owningRole());
    assertEquals("Json", actualFromJsonResult.submittedBy());
    assertEquals("Json", actualFromJsonResult.surveyEntityExternalId());
    assertEquals(1L, actualFromJsonResult.originalInstanceId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
  }

  /**
   * Test {@link ImmutableSurveyInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) Kind is {@code null}.
   *   <li>Then return kind is {@code SURVEY_INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) Kind is 'null'; then return kind is 'SURVEY_INSTANCE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.fromJson(Json)"})
  void testFromJson_givenOfFortyTwo_whenJsonKindIsNull_thenReturnKindIsSurveyInstance() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setSurveyRunId(1L);
    json.setSurveyEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setQualifierEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSurveyEntityExternalId("Json");
    json.setStatus(SurveyInstanceStatus.NOT_STARTED);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setApprovalDueDate(LocalDate.of(1970, 1, 1));
    json.setSubmittedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setSubmittedBy("Json");
    json.setApprovedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setApprovedBy("Json");
    json.setOriginalInstanceId(1L);
    json.setOwningRole("Json");
    json.setName("Json");
    json.setKind(null);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);

    // Act
    ImmutableSurveyInstance actualFromJsonResult = ImmutableSurveyInstance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.approvedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.owningRole());
    assertEquals("Json", actualFromJsonResult.submittedBy());
    assertEquals("Json", actualFromJsonResult.surveyEntityExternalId());
    assertEquals(1L, actualFromJsonResult.originalInstanceId().longValue());
    assertEquals(EntityKind.SURVEY_INSTANCE, actualFromJsonResult.kind());
    assertSame(issuedOn, actualFromJsonResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) Name is {@code null}.
   *   <li>Then return name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) Name is 'null'; then return name is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.fromJson(Json)"})
  void testFromJson_givenOfFortyTwo_whenJsonNameIsNull_thenReturnNameIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setSurveyRunId(1L);
    json.setSurveyEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setQualifierEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSurveyEntityExternalId("Json");
    json.setStatus(SurveyInstanceStatus.NOT_STARTED);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setApprovalDueDate(LocalDate.of(1970, 1, 1));
    json.setSubmittedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setSubmittedBy("Json");
    json.setApprovedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setApprovedBy("Json");
    json.setOriginalInstanceId(1L);
    json.setOwningRole("Json");
    json.setName(null);
    json.setKind(EntityKind.ALL);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);

    // Act
    ImmutableSurveyInstance actualFromJsonResult = ImmutableSurveyInstance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.approvedBy());
    assertEquals("Json", actualFromJsonResult.owningRole());
    assertEquals("Json", actualFromJsonResult.submittedBy());
    assertEquals("Json", actualFromJsonResult.surveyEntityExternalId());
    assertNull(actualFromJsonResult.name());
    assertEquals(1L, actualFromJsonResult.originalInstanceId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertSame(issuedOn, actualFromJsonResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link Json} (default constructor) OwningRole is {@code null}.
   *   <li>Then return owningRole is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of forty-two; when Json (default constructor) OwningRole is 'null'; then return owningRole is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.fromJson(Json)"})
  void testFromJson_givenOfFortyTwo_whenJsonOwningRoleIsNull_thenReturnOwningRoleIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setSurveyRunId(1L);
    json.setSurveyEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setQualifierEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSurveyEntityExternalId("Json");
    json.setStatus(SurveyInstanceStatus.NOT_STARTED);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setApprovalDueDate(LocalDate.of(1970, 1, 1));
    json.setSubmittedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setSubmittedBy("Json");
    json.setApprovedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setApprovedBy("Json");
    json.setOriginalInstanceId(1L);
    json.setOwningRole(null);
    json.setName("Json");
    json.setKind(EntityKind.ALL);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);

    // Act
    ImmutableSurveyInstance actualFromJsonResult = ImmutableSurveyInstance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.approvedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.submittedBy());
    assertEquals("Json", actualFromJsonResult.surveyEntityExternalId());
    assertNull(actualFromJsonResult.owningRole());
    assertEquals(1L, actualFromJsonResult.originalInstanceId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertSame(issuedOn, actualFromJsonResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return surveyEntityExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return surveyEntityExternalId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.fromJson(Json)"})
  void testFromJson_thenReturnSurveyEntityExternalIdIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setSurveyRunId(1L);
    json.setSurveyEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setQualifierEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSurveyEntityExternalId(null);
    json.setStatus(SurveyInstanceStatus.NOT_STARTED);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setApprovalDueDate(LocalDate.of(1970, 1, 1));
    json.setSubmittedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setSubmittedBy("Json");
    json.setApprovedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setApprovedBy("Json");
    json.setOriginalInstanceId(1L);
    json.setOwningRole("Json");
    json.setName("Json");
    json.setKind(EntityKind.ALL);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);

    // Act
    ImmutableSurveyInstance actualFromJsonResult = ImmutableSurveyInstance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.approvedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.owningRole());
    assertEquals("Json", actualFromJsonResult.submittedBy());
    assertNull(actualFromJsonResult.surveyEntityExternalId());
    assertEquals(1L, actualFromJsonResult.originalInstanceId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertSame(issuedOn, actualFromJsonResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) OriginalInstanceId is {@code null}.
   *   <li>Then return originalInstanceId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) OriginalInstanceId is 'null'; then return originalInstanceId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.fromJson(Json)"})
  void testFromJson_whenJsonOriginalInstanceIdIsNull_thenReturnOriginalInstanceIdIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setSurveyRunId(1L);
    json.setSurveyEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setQualifierEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSurveyEntityExternalId("Json");
    json.setStatus(SurveyInstanceStatus.NOT_STARTED);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setApprovalDueDate(LocalDate.of(1970, 1, 1));
    json.setSubmittedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setSubmittedBy("Json");
    json.setApprovedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setApprovedBy("Json");
    json.setOriginalInstanceId(null);
    json.setOwningRole("Json");
    json.setName("Json");
    json.setKind(EntityKind.ALL);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);

    // Act
    ImmutableSurveyInstance actualFromJsonResult = ImmutableSurveyInstance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.approvedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.owningRole());
    assertEquals("Json", actualFromJsonResult.submittedBy());
    assertEquals("Json", actualFromJsonResult.surveyEntityExternalId());
    assertNull(actualFromJsonResult.originalInstanceId());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertSame(issuedOn, actualFromJsonResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) SubmittedBy is {@code null}.
   *   <li>Then return submittedBy is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) SubmittedBy is 'null'; then return submittedBy is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.fromJson(Json)"})
  void testFromJson_whenJsonSubmittedByIsNull_thenReturnSubmittedByIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setSurveyRunId(1L);
    json.setSurveyEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setQualifierEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSurveyEntityExternalId("Json");
    json.setStatus(SurveyInstanceStatus.NOT_STARTED);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setApprovalDueDate(LocalDate.of(1970, 1, 1));
    json.setSubmittedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setSubmittedBy(null);
    json.setApprovedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setApprovedBy("Json");
    json.setOriginalInstanceId(1L);
    json.setOwningRole("Json");
    json.setName("Json");
    json.setKind(EntityKind.ALL);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);
    json.setIssuedOn(issuedOn);

    // Act
    ImmutableSurveyInstance actualFromJsonResult = ImmutableSurveyInstance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.approvedBy());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.owningRole());
    assertEquals("Json", actualFromJsonResult.surveyEntityExternalId());
    assertNull(actualFromJsonResult.submittedBy());
    assertEquals(1L, actualFromJsonResult.originalInstanceId().longValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertSame(issuedOn, actualFromJsonResult.issuedOn());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstance#approvalDueDate()}
   *   <li>{@link ImmutableSurveyInstance#approvedAt()}
   *   <li>{@link ImmutableSurveyInstance#approvedBy()}
   *   <li>{@link ImmutableSurveyInstance#dueDate()}
   *   <li>{@link ImmutableSurveyInstance#name()}
   *   <li>{@link ImmutableSurveyInstance#originalInstanceId()}
   *   <li>{@link ImmutableSurveyInstance#owningRole()}
   *   <li>{@link ImmutableSurveyInstance#qualifierEntity()}
   *   <li>{@link ImmutableSurveyInstance#status()}
   *   <li>{@link ImmutableSurveyInstance#submittedAt()}
   *   <li>{@link ImmutableSurveyInstance#submittedBy()}
   *   <li>{@link ImmutableSurveyInstance#surveyEntity()}
   *   <li>{@link ImmutableSurveyInstance#surveyEntityExternalId()}
   *   <li>{@link ImmutableSurveyInstance#surveyRunId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalDate ImmutableSurveyInstance.approvalDueDate()",
    "LocalDateTime ImmutableSurveyInstance.approvedAt()",
    "String ImmutableSurveyInstance.approvedBy()",
    "LocalDate ImmutableSurveyInstance.dueDate()",
    "String ImmutableSurveyInstance.name()",
    "Long ImmutableSurveyInstance.originalInstanceId()",
    "String ImmutableSurveyInstance.owningRole()",
    "EntityReference ImmutableSurveyInstance.qualifierEntity()",
    "SurveyInstanceStatus ImmutableSurveyInstance.status()",
    "LocalDateTime ImmutableSurveyInstance.submittedAt()",
    "String ImmutableSurveyInstance.submittedBy()",
    "EntityReference ImmutableSurveyInstance.surveyEntity()",
    "String ImmutableSurveyInstance.surveyEntityExternalId()",
    "Long ImmutableSurveyInstance.surveyRunId()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(approvalDueDate)
            .approvedAt(ofResult.atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(dueDate)
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(1L)
            .owningRole("Owning Role");

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

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
            .submittedAt(ofResult2.atStartOfDay())
            .submittedBy("Submitted By");
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    LocalDate actualApprovalDueDateResult = immutableSurveyInstance.approvalDueDate();
    LocalDateTime actualApprovedAtResult = immutableSurveyInstance.approvedAt();
    String actualApprovedByResult = immutableSurveyInstance.approvedBy();
    LocalDate actualDueDateResult = immutableSurveyInstance.dueDate();
    String actualNameResult = immutableSurveyInstance.name();
    Long actualOriginalInstanceIdResult = immutableSurveyInstance.originalInstanceId();
    String actualOwningRoleResult = immutableSurveyInstance.owningRole();
    EntityReference actualQualifierEntityResult = immutableSurveyInstance.qualifierEntity();
    SurveyInstanceStatus actualStatusResult = immutableSurveyInstance.status();
    LocalDateTime actualSubmittedAtResult = immutableSurveyInstance.submittedAt();
    String actualSubmittedByResult = immutableSurveyInstance.submittedBy();
    EntityReference actualSurveyEntityResult = immutableSurveyInstance.surveyEntity();
    String actualSurveyEntityExternalIdResult = immutableSurveyInstance.surveyEntityExternalId();
    Long actualSurveyRunIdResult = immutableSurveyInstance.surveyRunId();

    // Assert
    assertTrue(actualQualifierEntityResult instanceof ImmutableEntityReference);
    assertTrue(actualSurveyEntityResult instanceof ImmutableEntityReference);
    LocalTime toLocalTimeResult = actualApprovedAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = actualApprovedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDate toLocalDateResult2 = actualSubmittedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("1970-01-01", actualApprovalDueDateResult.toString());
    assertEquals("1970-01-01", actualDueDateResult.toString());
    assertEquals("42", actualSurveyEntityExternalIdResult);
    assertEquals("Approved By", actualApprovedByResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Owning Role", actualOwningRoleResult);
    assertEquals("Submitted By", actualSubmittedByResult);
    assertEquals(1L, actualOriginalInstanceIdResult.longValue());
    assertEquals(1L, actualSurveyRunIdResult.longValue());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualStatusResult);
    assertEquals(actualQualifierEntityResult, actualSurveyEntityResult);
    assertSame(toLocalTimeResult, actualSubmittedAtResult.toLocalTime());
    assertSame(ofResult, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
    assertSame(approvalDueDate, actualApprovalDueDateResult);
    assertSame(dueDate, actualDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#id()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyInstance.id()"})
  void testId() {
    // Arrange
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

    // Act
    Optional<Long> actualIdResult =
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
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyInstance#issuedOn()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#issuedOn()}
   */
  @Test
  @DisplayName("Test issuedOn()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate ImmutableSurveyInstance.issuedOn()"})
  void testIssuedOn() {
    // Arrange
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(issuedOn)
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

    // Act
    LocalDate actualIssuedOnResult =
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
   * Test Json {@link Json#approvedAt()}.
   *
   * <p>Method under test: {@link Json#approvedAt()}
   */
  @Test
  @DisplayName("Test Json approvedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.approvedAt()"})
  void testJsonApprovedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().approvedAt());
  }

  /**
   * Test Json {@link Json#approvedBy()}.
   *
   * <p>Method under test: {@link Json#approvedBy()}
   */
  @Test
  @DisplayName("Test Json approvedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.approvedBy()"})
  void testJsonApprovedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().approvedBy());
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
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
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
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
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
    assertNull(actualJson.originalInstanceId);
    assertNull(actualJson.surveyRunId);
    assertNull(actualJson.approvedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.owningRole);
    assertNull(actualJson.submittedBy);
    assertNull(actualJson.surveyEntityExternalId);
    assertNull(actualJson.approvalDueDate);
    assertNull(actualJson.dueDate);
    assertNull(actualJson.issuedOn);
    assertNull(actualJson.approvedAt);
    assertNull(actualJson.submittedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.qualifierEntity);
    assertNull(actualJson.surveyEntity);
    assertNull(actualJson.status);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#originalInstanceId()}.
   *
   * <p>Method under test: {@link Json#originalInstanceId()}
   */
  @Test
  @DisplayName("Test Json originalInstanceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.originalInstanceId()"})
  void testJsonOriginalInstanceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().originalInstanceId());
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
   * Test Json {@link Json#qualifierEntity()}.
   *
   * <p>Method under test: {@link Json#qualifierEntity()}
   */
  @Test
  @DisplayName("Test Json qualifierEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.qualifierEntity()"})
  void testJsonQualifierEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().qualifierEntity());
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
   * Test Json {@link Json#submittedAt()}.
   *
   * <p>Method under test: {@link Json#submittedAt()}
   */
  @Test
  @DisplayName("Test Json submittedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.submittedAt()"})
  void testJsonSubmittedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().submittedAt());
  }

  /**
   * Test Json {@link Json#submittedBy()}.
   *
   * <p>Method under test: {@link Json#submittedBy()}
   */
  @Test
  @DisplayName("Test Json submittedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.submittedBy()"})
  void testJsonSubmittedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().submittedBy());
  }

  /**
   * Test Json {@link Json#surveyEntity()}.
   *
   * <p>Method under test: {@link Json#surveyEntity()}
   */
  @Test
  @DisplayName("Test Json surveyEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.surveyEntity()"})
  void testJsonSurveyEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().surveyEntity());
  }

  /**
   * Test Json {@link Json#surveyEntityExternalId()}.
   *
   * <p>Method under test: {@link Json#surveyEntityExternalId()}
   */
  @Test
  @DisplayName("Test Json surveyEntityExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.surveyEntityExternalId()"})
  void testJsonSurveyEntityExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().surveyEntityExternalId());
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
   * Test {@link ImmutableSurveyInstance#kind()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableSurveyInstance.kind()"})
  void testKind() {
    // Arrange
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
    assertEquals(
        EntityKind.ALL,
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
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableSurveyInstance#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyInstance.toString()"})
  void testToString() {
    // Arrange
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
    assertEquals(
        "SurveyInstance{id=1, surveyRunId=1, surveyEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, qualifierEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, surveyEntit"
            + "yExternalId=42, status=NOT_STARTED, dueDate=1970-01-01, approvalDueDate=1970-01-01, submittedAt=1970"
            + "-01-01T00:00, submittedBy=Submitted By, approvedAt=1970-01-01T00:00, approvedBy=Approved By,"
            + " originalInstanceId=1, owningRole=Owning Role, name=Name, kind=ALL, issuedOn=1970-01-01}",
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
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyInstance#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyInstance.toString()"})
  void testToString2() {
    // Arrange
    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy(null)
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
    assertEquals(
        "SurveyInstance{id=1, surveyRunId=1, surveyEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, qualifierEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, surveyEntit"
            + "yExternalId=42, status=NOT_STARTED, dueDate=1970-01-01, approvalDueDate=1970-01-01, submittedAt=1970"
            + "-01-01T00:00, submittedBy=Submitted By, approvedAt=1970-01-01T00:00, originalInstanceId=1, owningRole=Owning"
            + " Role, name=Name, kind=ALL, issuedOn=1970-01-01}",
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
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyInstance#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyInstance.toString()"})
  void testToString3() {
    // Arrange
    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name(null)
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
    assertEquals(
        "SurveyInstance{id=1, surveyRunId=1, surveyEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, qualifierEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, surveyEntit"
            + "yExternalId=42, status=NOT_STARTED, dueDate=1970-01-01, approvalDueDate=1970-01-01, submittedAt=1970"
            + "-01-01T00:00, submittedBy=Submitted By, approvedAt=1970-01-01T00:00, approvedBy=Approved By,"
            + " originalInstanceId=1, owningRole=Owning Role, kind=ALL, issuedOn=1970-01-01}",
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
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyInstance#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyInstance.toString()"})
  void testToString4() {
    // Arrange
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
            .originalInstanceId(null)
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
    assertEquals(
        "SurveyInstance{id=1, surveyRunId=1, surveyEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, qualifierEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, surveyEntit"
            + "yExternalId=42, status=NOT_STARTED, dueDate=1970-01-01, approvalDueDate=1970-01-01, submittedAt=1970"
            + "-01-01T00:00, submittedBy=Submitted By, approvedAt=1970-01-01T00:00, approvedBy=Approved By,"
            + " owningRole=Owning Role, name=Name, kind=ALL, issuedOn=1970-01-01}",
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
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyInstance#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyInstance.toString()"})
  void testToString5() {
    // Arrange
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
            .owningRole(null);

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
    assertEquals(
        "SurveyInstance{id=1, surveyRunId=1, surveyEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, qualifierEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, surveyEntit"
            + "yExternalId=42, status=NOT_STARTED, dueDate=1970-01-01, approvalDueDate=1970-01-01, submittedAt=1970"
            + "-01-01T00:00, submittedBy=Submitted By, approvedAt=1970-01-01T00:00, approvedBy=Approved By,"
            + " originalInstanceId=1, name=Name, kind=ALL, issuedOn=1970-01-01}",
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
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyInstance#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyInstance.toString()"})
  void testToString6() {
    // Arrange
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
            .submittedBy(null);

    // Act and Assert
    assertEquals(
        "SurveyInstance{id=1, surveyRunId=1, surveyEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, qualifierEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, surveyEntit"
            + "yExternalId=42, status=NOT_STARTED, dueDate=1970-01-01, approvalDueDate=1970-01-01, submittedAt=1970"
            + "-01-01T00:00, approvedAt=1970-01-01T00:00, approvedBy=Approved By, originalInstanceId=1, owningRole=Owning"
            + " Role, name=Name, kind=ALL, issuedOn=1970-01-01}",
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
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyInstance#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyInstance.toString()"})
  void testToString7() {
    // Arrange
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
    assertEquals(
        "SurveyInstance{id=1, surveyRunId=1, surveyEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, qualifierEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, status=NOT_STARTED,"
            + " dueDate=1970-01-01, approvalDueDate=1970-01-01, submittedAt=1970-01-01T00:00, submittedBy=Submitted"
            + " By, approvedAt=1970-01-01T00:00, approvedBy=Approved By, originalInstanceId=1, owningRole=Owning Role,"
            + " name=Name, kind=ALL, issuedOn=1970-01-01}",
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
            .surveyEntityExternalId(null)
            .surveyRunId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyInstance#withApprovalDueDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withApprovalDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withApprovalDueDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstance ImmutableSurveyInstance.withApprovalDueDate(LocalDate)"
  })
  void testWithApprovalDueDate() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithApprovalDueDateResult =
        immutableSurveyInstance.withApprovalDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyInstance, actualWithApprovalDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withApprovedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withApprovedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withApprovedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstance ImmutableSurveyInstance.withApprovedAt(LocalDateTime)"
  })
  void testWithApprovedAt() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithApprovedAtResult =
        immutableSurveyInstance.withApprovedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableSurveyInstance, actualWithApprovedAtResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withApprovedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withApprovedBy(String)}
   */
  @Test
  @DisplayName("Test withApprovedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withApprovedBy(String)"})
  void testWithApprovedBy() {
    // Arrange
    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("42")
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithApprovedByResult =
        immutableSurveyInstance.withApprovedBy("42");

    // Assert
    assertSame(immutableSurveyInstance, actualWithApprovedByResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withApprovedBy(String)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withApprovedBy(String)}
   */
  @Test
  @DisplayName("Test withApprovedBy(String); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withApprovedBy(String)"})
  void testWithApprovedBy_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(approvalDueDate)
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(dueDate)
            .id(1L)
            .issuedOn(issuedOn)
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

    // Act
    ImmutableSurveyInstance actualWithApprovedByResult =
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
            .build()
            .withApprovedBy("42");

    // Assert
    EntityReference qualifierEntityResult = actualWithApprovedByResult.qualifierEntity();
    assertTrue(qualifierEntityResult instanceof ImmutableEntityReference);
    EntityReference surveyEntityResult = actualWithApprovedByResult.surveyEntity();
    assertTrue(surveyEntityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithApprovedByResult.approvedBy());
    assertEquals("42", actualWithApprovedByResult.surveyEntityExternalId());
    assertEquals("Name", actualWithApprovedByResult.name());
    assertEquals("Owning Role", actualWithApprovedByResult.owningRole());
    assertEquals("Submitted By", actualWithApprovedByResult.submittedBy());
    assertEquals(1L, actualWithApprovedByResult.originalInstanceId().longValue());
    assertEquals(1L, actualWithApprovedByResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualWithApprovedByResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualWithApprovedByResult.status());
    assertEquals(qualifierEntityResult, surveyEntityResult);
    assertSame(approvalDueDate, actualWithApprovedByResult.approvalDueDate());
    assertSame(dueDate, actualWithApprovedByResult.dueDate());
    assertSame(issuedOn, actualWithApprovedByResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#withDueDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withDueDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withDueDate(LocalDate)"})
  void testWithDueDate() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithDueDateResult =
        immutableSurveyInstance.withDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyInstance, actualWithDueDateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSurveyInstance actualWithIdResult = immutableSurveyInstance.withId(optional);

    // Assert
    assertSame(immutableSurveyInstance, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withId(Optional)"})
  void testWithIdWithOptional_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(approvalDueDate)
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(dueDate)
            .id(1L)
            .issuedOn(issuedOn)
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableSurveyInstance actualWithIdResult = immutableSurveyInstance.withId(optional);

    // Assert
    EntityReference qualifierEntityResult = actualWithIdResult.qualifierEntity();
    assertTrue(qualifierEntityResult instanceof ImmutableEntityReference);
    EntityReference surveyEntityResult = actualWithIdResult.surveyEntity();
    assertTrue(surveyEntityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithIdResult.surveyEntityExternalId());
    assertEquals("Approved By", actualWithIdResult.approvedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Owning Role", actualWithIdResult.owningRole());
    assertEquals("Submitted By", actualWithIdResult.submittedBy());
    assertEquals(1L, actualWithIdResult.originalInstanceId().longValue());
    assertEquals(1L, actualWithIdResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualWithIdResult.status());
    assertEquals(qualifierEntityResult, surveyEntityResult);
    assertSame(approvalDueDate, actualWithIdResult.approvalDueDate());
    assertSame(dueDate, actualWithIdResult.dueDate());
    assertSame(issuedOn, actualWithIdResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithIdResult = immutableSurveyInstance.withId(1L);

    // Assert
    assertSame(immutableSurveyInstance, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withId(long)"})
  void testWithIdWithValue_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(approvalDueDate)
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(dueDate)
            .id(1L)
            .issuedOn(issuedOn)
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

    // Act
    ImmutableSurveyInstance actualWithIdResult =
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
            .build()
            .withId(42L);

    // Assert
    EntityReference qualifierEntityResult = actualWithIdResult.qualifierEntity();
    assertTrue(qualifierEntityResult instanceof ImmutableEntityReference);
    EntityReference surveyEntityResult = actualWithIdResult.surveyEntity();
    assertTrue(surveyEntityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithIdResult.surveyEntityExternalId());
    assertEquals("Approved By", actualWithIdResult.approvedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Owning Role", actualWithIdResult.owningRole());
    assertEquals("Submitted By", actualWithIdResult.submittedBy());
    assertEquals(1L, actualWithIdResult.originalInstanceId().longValue());
    assertEquals(1L, actualWithIdResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualWithIdResult.status());
    assertEquals(qualifierEntityResult, surveyEntityResult);
    assertSame(approvalDueDate, actualWithIdResult.approvalDueDate());
    assertSame(dueDate, actualWithIdResult.dueDate());
    assertSame(issuedOn, actualWithIdResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#withIssuedOn(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withIssuedOn(LocalDate)}
   */
  @Test
  @DisplayName("Test withIssuedOn(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withIssuedOn(LocalDate)"})
  void testWithIssuedOn() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithIssuedOnResult =
        immutableSurveyInstance.withIssuedOn(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyInstance, actualWithIssuedOnResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithKindResult = immutableSurveyInstance.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableSurveyInstance, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withKind(EntityKind)"})
  void testWithKind_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(approvalDueDate)
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(dueDate)
            .id(1L)
            .issuedOn(issuedOn)
            .kind(EntityKind.ACTOR)
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

    // Act
    ImmutableSurveyInstance actualWithKindResult =
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
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    EntityReference qualifierEntityResult = actualWithKindResult.qualifierEntity();
    assertTrue(qualifierEntityResult instanceof ImmutableEntityReference);
    EntityReference surveyEntityResult = actualWithKindResult.surveyEntity();
    assertTrue(surveyEntityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithKindResult.surveyEntityExternalId());
    assertEquals("Approved By", actualWithKindResult.approvedBy());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Owning Role", actualWithKindResult.owningRole());
    assertEquals("Submitted By", actualWithKindResult.submittedBy());
    assertEquals(1L, actualWithKindResult.originalInstanceId().longValue());
    assertEquals(1L, actualWithKindResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualWithKindResult.status());
    assertEquals(qualifierEntityResult, surveyEntityResult);
    assertSame(approvalDueDate, actualWithKindResult.approvalDueDate());
    assertSame(dueDate, actualWithKindResult.dueDate());
    assertSame(issuedOn, actualWithKindResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withName(String)"})
  void testWithName() {
    // Arrange
    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("42")
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithNameResult = immutableSurveyInstance.withName("42");

    // Assert
    assertSame(immutableSurveyInstance, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withName(String)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withName(String)"})
  void testWithName_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(approvalDueDate)
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(dueDate)
            .id(1L)
            .issuedOn(issuedOn)
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

    // Act
    ImmutableSurveyInstance actualWithNameResult =
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
            .build()
            .withName("42");

    // Assert
    EntityReference qualifierEntityResult = actualWithNameResult.qualifierEntity();
    assertTrue(qualifierEntityResult instanceof ImmutableEntityReference);
    EntityReference surveyEntityResult = actualWithNameResult.surveyEntity();
    assertTrue(surveyEntityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithNameResult.name());
    assertEquals("42", actualWithNameResult.surveyEntityExternalId());
    assertEquals("Approved By", actualWithNameResult.approvedBy());
    assertEquals("Owning Role", actualWithNameResult.owningRole());
    assertEquals("Submitted By", actualWithNameResult.submittedBy());
    assertEquals(1L, actualWithNameResult.originalInstanceId().longValue());
    assertEquals(1L, actualWithNameResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualWithNameResult.status());
    assertEquals(qualifierEntityResult, surveyEntityResult);
    assertSame(approvalDueDate, actualWithNameResult.approvalDueDate());
    assertSame(dueDate, actualWithNameResult.dueDate());
    assertSame(issuedOn, actualWithNameResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#withOriginalInstanceId(Long)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withOriginalInstanceId(Long)}
   */
  @Test
  @DisplayName("Test withOriginalInstanceId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstance ImmutableSurveyInstance.withOriginalInstanceId(Long)"
  })
  void testWithOriginalInstanceId() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithOriginalInstanceIdResult =
        immutableSurveyInstance.withOriginalInstanceId(1L);

    // Assert
    assertSame(immutableSurveyInstance, actualWithOriginalInstanceIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withOriginalInstanceId(Long)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withOriginalInstanceId(Long)}
   */
  @Test
  @DisplayName(
      "Test withOriginalInstanceId(Long); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstance ImmutableSurveyInstance.withOriginalInstanceId(Long)"
  })
  void testWithOriginalInstanceId_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(approvalDueDate)
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(dueDate)
            .id(1L)
            .issuedOn(issuedOn)
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

    // Act
    ImmutableSurveyInstance actualWithOriginalInstanceIdResult =
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
            .build()
            .withOriginalInstanceId(42L);

    // Assert
    EntityReference qualifierEntityResult = actualWithOriginalInstanceIdResult.qualifierEntity();
    assertTrue(qualifierEntityResult instanceof ImmutableEntityReference);
    EntityReference surveyEntityResult = actualWithOriginalInstanceIdResult.surveyEntity();
    assertTrue(surveyEntityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithOriginalInstanceIdResult.surveyEntityExternalId());
    assertEquals("Approved By", actualWithOriginalInstanceIdResult.approvedBy());
    assertEquals("Name", actualWithOriginalInstanceIdResult.name());
    assertEquals("Owning Role", actualWithOriginalInstanceIdResult.owningRole());
    assertEquals("Submitted By", actualWithOriginalInstanceIdResult.submittedBy());
    assertEquals(1L, actualWithOriginalInstanceIdResult.surveyRunId().longValue());
    assertEquals(42L, actualWithOriginalInstanceIdResult.originalInstanceId().longValue());
    assertEquals(EntityKind.ALL, actualWithOriginalInstanceIdResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualWithOriginalInstanceIdResult.status());
    assertEquals(qualifierEntityResult, surveyEntityResult);
    assertSame(approvalDueDate, actualWithOriginalInstanceIdResult.approvalDueDate());
    assertSame(dueDate, actualWithOriginalInstanceIdResult.dueDate());
    assertSame(issuedOn, actualWithOriginalInstanceIdResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#withOwningRole(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withOwningRole(String)}
   */
  @Test
  @DisplayName("Test withOwningRole(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withOwningRole(String)"})
  void testWithOwningRole() {
    // Arrange
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
            .owningRole("42");

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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithOwningRoleResult =
        immutableSurveyInstance.withOwningRole("42");

    // Assert
    assertSame(immutableSurveyInstance, actualWithOwningRoleResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withOwningRole(String)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withOwningRole(String)}
   */
  @Test
  @DisplayName("Test withOwningRole(String); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withOwningRole(String)"})
  void testWithOwningRole_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(approvalDueDate)
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(dueDate)
            .id(1L)
            .issuedOn(issuedOn)
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

    // Act
    ImmutableSurveyInstance actualWithOwningRoleResult =
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
            .build()
            .withOwningRole("42");

    // Assert
    EntityReference qualifierEntityResult = actualWithOwningRoleResult.qualifierEntity();
    assertTrue(qualifierEntityResult instanceof ImmutableEntityReference);
    EntityReference surveyEntityResult = actualWithOwningRoleResult.surveyEntity();
    assertTrue(surveyEntityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithOwningRoleResult.owningRole());
    assertEquals("42", actualWithOwningRoleResult.surveyEntityExternalId());
    assertEquals("Approved By", actualWithOwningRoleResult.approvedBy());
    assertEquals("Name", actualWithOwningRoleResult.name());
    assertEquals("Submitted By", actualWithOwningRoleResult.submittedBy());
    assertEquals(1L, actualWithOwningRoleResult.originalInstanceId().longValue());
    assertEquals(1L, actualWithOwningRoleResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualWithOwningRoleResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualWithOwningRoleResult.status());
    assertEquals(qualifierEntityResult, surveyEntityResult);
    assertSame(approvalDueDate, actualWithOwningRoleResult.approvalDueDate());
    assertSame(dueDate, actualWithOwningRoleResult.dueDate());
    assertSame(issuedOn, actualWithOwningRoleResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#withQualifierEntity(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withQualifierEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test withQualifierEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstance ImmutableSurveyInstance.withQualifierEntity(EntityReference)"
  })
  void testWithQualifierEntity() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithQualifierEntityResult =
        immutableSurveyInstance.withQualifierEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableSurveyInstance, actualWithQualifierEntityResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withStatus(SurveyInstanceStatus)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withStatus(SurveyInstanceStatus)}
   */
  @Test
  @DisplayName("Test withStatus(SurveyInstanceStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstance ImmutableSurveyInstance.withStatus(SurveyInstanceStatus)"
  })
  void testWithStatus() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithStatusResult =
        immutableSurveyInstance.withStatus(SurveyInstanceStatus.NOT_STARTED);

    // Assert
    assertSame(immutableSurveyInstance, actualWithStatusResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withStatus(SurveyInstanceStatus)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withStatus(SurveyInstanceStatus)}
   */
  @Test
  @DisplayName(
      "Test withStatus(SurveyInstanceStatus); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstance ImmutableSurveyInstance.withStatus(SurveyInstanceStatus)"
  })
  void testWithStatus_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(approvalDueDate)
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(dueDate)
            .id(1L)
            .issuedOn(issuedOn)
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
            .status(SurveyInstanceStatus.IN_PROGRESS)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By");

    // Act
    ImmutableSurveyInstance actualWithStatusResult =
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
            .build()
            .withStatus(SurveyInstanceStatus.NOT_STARTED);

    // Assert
    EntityReference qualifierEntityResult = actualWithStatusResult.qualifierEntity();
    assertTrue(qualifierEntityResult instanceof ImmutableEntityReference);
    EntityReference surveyEntityResult = actualWithStatusResult.surveyEntity();
    assertTrue(surveyEntityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithStatusResult.surveyEntityExternalId());
    assertEquals("Approved By", actualWithStatusResult.approvedBy());
    assertEquals("Name", actualWithStatusResult.name());
    assertEquals("Owning Role", actualWithStatusResult.owningRole());
    assertEquals("Submitted By", actualWithStatusResult.submittedBy());
    assertEquals(1L, actualWithStatusResult.originalInstanceId().longValue());
    assertEquals(1L, actualWithStatusResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualWithStatusResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualWithStatusResult.status());
    assertEquals(qualifierEntityResult, surveyEntityResult);
    assertSame(approvalDueDate, actualWithStatusResult.approvalDueDate());
    assertSame(dueDate, actualWithStatusResult.dueDate());
    assertSame(issuedOn, actualWithStatusResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#withSubmittedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withSubmittedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withSubmittedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstance ImmutableSurveyInstance.withSubmittedAt(LocalDateTime)"
  })
  void testWithSubmittedAt() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithSubmittedAtResult =
        immutableSurveyInstance.withSubmittedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableSurveyInstance, actualWithSubmittedAtResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withSubmittedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withSubmittedBy(String)}
   */
  @Test
  @DisplayName("Test withSubmittedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withSubmittedBy(String)"})
  void testWithSubmittedBy() {
    // Arrange
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
            .submittedBy("42");
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithSubmittedByResult =
        immutableSurveyInstance.withSubmittedBy("42");

    // Assert
    assertSame(immutableSurveyInstance, actualWithSubmittedByResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withSubmittedBy(String)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withSubmittedBy(String)}
   */
  @Test
  @DisplayName("Test withSubmittedBy(String); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withSubmittedBy(String)"})
  void testWithSubmittedBy_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(approvalDueDate)
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(dueDate)
            .id(1L)
            .issuedOn(issuedOn)
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

    // Act
    ImmutableSurveyInstance actualWithSubmittedByResult =
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
            .build()
            .withSubmittedBy("42");

    // Assert
    EntityReference qualifierEntityResult = actualWithSubmittedByResult.qualifierEntity();
    assertTrue(qualifierEntityResult instanceof ImmutableEntityReference);
    EntityReference surveyEntityResult = actualWithSubmittedByResult.surveyEntity();
    assertTrue(surveyEntityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithSubmittedByResult.submittedBy());
    assertEquals("42", actualWithSubmittedByResult.surveyEntityExternalId());
    assertEquals("Approved By", actualWithSubmittedByResult.approvedBy());
    assertEquals("Name", actualWithSubmittedByResult.name());
    assertEquals("Owning Role", actualWithSubmittedByResult.owningRole());
    assertEquals(1L, actualWithSubmittedByResult.originalInstanceId().longValue());
    assertEquals(1L, actualWithSubmittedByResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualWithSubmittedByResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualWithSubmittedByResult.status());
    assertEquals(qualifierEntityResult, surveyEntityResult);
    assertSame(approvalDueDate, actualWithSubmittedByResult.approvalDueDate());
    assertSame(dueDate, actualWithSubmittedByResult.dueDate());
    assertSame(issuedOn, actualWithSubmittedByResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#withSurveyEntity(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withSurveyEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test withSurveyEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstance ImmutableSurveyInstance.withSurveyEntity(EntityReference)"
  })
  void testWithSurveyEntity() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithSurveyEntityResult =
        immutableSurveyInstance.withSurveyEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableSurveyInstance, actualWithSurveyEntityResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withSurveyEntityExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withSurveyEntityExternalId(String)}
   */
  @Test
  @DisplayName("Test withSurveyEntityExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstance ImmutableSurveyInstance.withSurveyEntityExternalId(String)"
  })
  void testWithSurveyEntityExternalId() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithSurveyEntityExternalIdResult =
        immutableSurveyInstance.withSurveyEntityExternalId("42");

    // Assert
    assertSame(immutableSurveyInstance, actualWithSurveyEntityExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withSurveyEntityExternalId(String)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withSurveyEntityExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withSurveyEntityExternalId(String); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstance ImmutableSurveyInstance.withSurveyEntityExternalId(String)"
  })
  void testWithSurveyEntityExternalId_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(approvalDueDate)
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(dueDate)
            .id(1L)
            .issuedOn(issuedOn)
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

    // Act
    ImmutableSurveyInstance actualWithSurveyEntityExternalIdResult =
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
            .surveyEntityExternalId("Survey Entity External Id")
            .surveyRunId(1L)
            .build()
            .withSurveyEntityExternalId("42");

    // Assert
    EntityReference qualifierEntityResult =
        actualWithSurveyEntityExternalIdResult.qualifierEntity();
    assertTrue(qualifierEntityResult instanceof ImmutableEntityReference);
    EntityReference surveyEntityResult = actualWithSurveyEntityExternalIdResult.surveyEntity();
    assertTrue(surveyEntityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithSurveyEntityExternalIdResult.surveyEntityExternalId());
    assertEquals("Approved By", actualWithSurveyEntityExternalIdResult.approvedBy());
    assertEquals("Name", actualWithSurveyEntityExternalIdResult.name());
    assertEquals("Owning Role", actualWithSurveyEntityExternalIdResult.owningRole());
    assertEquals("Submitted By", actualWithSurveyEntityExternalIdResult.submittedBy());
    assertEquals(1L, actualWithSurveyEntityExternalIdResult.originalInstanceId().longValue());
    assertEquals(1L, actualWithSurveyEntityExternalIdResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualWithSurveyEntityExternalIdResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualWithSurveyEntityExternalIdResult.status());
    assertEquals(qualifierEntityResult, surveyEntityResult);
    assertSame(approvalDueDate, actualWithSurveyEntityExternalIdResult.approvalDueDate());
    assertSame(dueDate, actualWithSurveyEntityExternalIdResult.dueDate());
    assertSame(issuedOn, actualWithSurveyEntityExternalIdResult.issuedOn());
  }

  /**
   * Test {@link ImmutableSurveyInstance#withSurveyRunId(Long)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withSurveyRunId(Long)}
   */
  @Test
  @DisplayName("Test withSurveyRunId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withSurveyRunId(Long)"})
  void testWithSurveyRunId() {
    // Arrange
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
    ImmutableSurveyInstance immutableSurveyInstance =
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
            .build();

    // Act
    ImmutableSurveyInstance actualWithSurveyRunIdResult =
        immutableSurveyInstance.withSurveyRunId(1L);

    // Assert
    assertSame(immutableSurveyInstance, actualWithSurveyRunIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstance#withSurveyRunId(Long)}.
   *
   * <ul>
   *   <li>Then qualifierEntity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstance#withSurveyRunId(Long)}
   */
  @Test
  @DisplayName("Test withSurveyRunId(Long); then qualifierEntity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstance ImmutableSurveyInstance.withSurveyRunId(Long)"})
  void testWithSurveyRunId_thenQualifierEntityReturnImmutableEntityReference() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(approvalDueDate)
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(dueDate)
            .id(1L)
            .issuedOn(issuedOn)
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

    // Act
    ImmutableSurveyInstance actualWithSurveyRunIdResult =
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
            .build()
            .withSurveyRunId(42L);

    // Assert
    EntityReference qualifierEntityResult = actualWithSurveyRunIdResult.qualifierEntity();
    assertTrue(qualifierEntityResult instanceof ImmutableEntityReference);
    EntityReference surveyEntityResult = actualWithSurveyRunIdResult.surveyEntity();
    assertTrue(surveyEntityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithSurveyRunIdResult.surveyEntityExternalId());
    assertEquals("Approved By", actualWithSurveyRunIdResult.approvedBy());
    assertEquals("Name", actualWithSurveyRunIdResult.name());
    assertEquals("Owning Role", actualWithSurveyRunIdResult.owningRole());
    assertEquals("Submitted By", actualWithSurveyRunIdResult.submittedBy());
    assertEquals(1L, actualWithSurveyRunIdResult.originalInstanceId().longValue());
    assertEquals(42L, actualWithSurveyRunIdResult.surveyRunId().longValue());
    assertEquals(EntityKind.ALL, actualWithSurveyRunIdResult.kind());
    assertEquals(SurveyInstanceStatus.NOT_STARTED, actualWithSurveyRunIdResult.status());
    assertEquals(qualifierEntityResult, surveyEntityResult);
    assertSame(approvalDueDate, actualWithSurveyRunIdResult.approvalDueDate());
    assertSame(dueDate, actualWithSurveyRunIdResult.dueDate());
    assertSame(issuedOn, actualWithSurveyRunIdResult.issuedOn());
  }
}
