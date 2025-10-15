package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.model.survey.ImmutableInstancesAndRecipientsCreateCommand.Builder;
import org.finos.waltz.model.survey.ImmutableInstancesAndRecipientsCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInstancesAndRecipientsCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllExcludedRecipients(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllExcludedRecipients(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllExcludedRecipients(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllExcludedRecipients(Iterable)"})
  void testBuilderAddAllExcludedRecipients_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

    // Act
    Builder actualAddAllExcludedRecipientsResult =
        builderResult.addAllExcludedRecipients(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllExcludedRecipientsResult);
  }

  /**
   * Test Builder {@link Builder#addExcludedRecipients(SurveyInstanceRecipient)} with {@code
   * element}.
   *
   * <p>Method under test: {@link Builder#addExcludedRecipients(SurveyInstanceRecipient)}
   */
  @Test
  @DisplayName("Test Builder addExcludedRecipients(SurveyInstanceRecipient) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addExcludedRecipients(SurveyInstanceRecipient)"})
  void testBuilderAddExcludedRecipientsWithElement() {
    // Arrange
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

    // Act
    Builder actualAddExcludedRecipientsResult =
        builderResult.addExcludedRecipients(new ImmutableSurveyInstanceRecipient.Json());

    // Assert
    assertSame(builderResult, actualAddExcludedRecipientsResult);
  }

  /**
   * Test Builder {@link Builder#addExcludedRecipients(SurveyInstanceRecipient[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link Builder#addExcludedRecipients(SurveyInstanceRecipient[])}
   */
  @Test
  @DisplayName("Test Builder addExcludedRecipients(SurveyInstanceRecipient[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addExcludedRecipients(SurveyInstanceRecipient[])"})
  void testBuilderAddExcludedRecipientsWithElements() {
    // Arrange
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

    // Act
    Builder actualAddExcludedRecipientsResult =
        builderResult.addExcludedRecipients(new ImmutableSurveyInstanceRecipient.Json());

    // Assert
    assertSame(builderResult, actualAddExcludedRecipientsResult);
  }

  /**
   * Test Builder {@link Builder#approvalDueDate(LocalDate)}.
   *
   * <p>Method under test: {@link Builder#approvalDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test Builder approvalDueDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.approvalDueDate(LocalDate)"})
  void testBuilderApprovalDueDate() {
    // Arrange
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

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
   *   <li>{@link Builder#owningRole(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInstancesAndRecipientsCreateCommand Builder.build()",
    "Builder Builder.owningRole(String)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableInstancesAndRecipientsCreateCommand
        actualImmutableInstancesAndRecipientsCreateCommand =
            ImmutableInstancesAndRecipientsCreateCommand.builder()
                .approvalDueDate(approvalDueDate)
                .dueDate(dueDate)
                .owningRole("Owning Role")
                .surveyRunId(1L)
                .build();

    // Assert
    LocalDate approvalDueDateResult =
        actualImmutableInstancesAndRecipientsCreateCommand.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualImmutableInstancesAndRecipientsCreateCommand.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Owning Role", actualImmutableInstancesAndRecipientsCreateCommand.owningRole());
    assertEquals(1L, actualImmutableInstancesAndRecipientsCreateCommand.surveyRunId().longValue());
    assertTrue(actualImmutableInstancesAndRecipientsCreateCommand.excludedRecipients().isEmpty());
    assertSame(approvalDueDate, approvalDueDateResult);
    assertSame(dueDate, dueDateResult);
  }

  /**
   * Test Builder {@link Builder#dueDate(LocalDate)}.
   *
   * <p>Method under test: {@link Builder#dueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test Builder dueDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dueDate(LocalDate)"})
  void testBuilderDueDate() {
    // Arrange
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

    // Act
    Builder actualDueDateResult = builderResult.dueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertSame(builderResult, actualDueDateResult);
  }

  /**
   * Test Builder {@link Builder#excludedRecipients(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#excludedRecipients(Iterable)}
   */
  @Test
  @DisplayName("Test Builder excludedRecipients(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.excludedRecipients(Iterable)"})
  void testBuilderExcludedRecipients_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

    // Act
    Builder actualExcludedRecipientsResult = builderResult.excludedRecipients(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualExcludedRecipientsResult);
  }

  /**
   * Test Builder {@link Builder#from(InstancesAndRecipientsCreateCommand)}.
   *
   * <p>Method under test: {@link Builder#from(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(InstancesAndRecipientsCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(InstancesAndRecipientsCreateCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();
    ImmutableInstancesAndRecipientsCreateCommand instance =
        ImmutableInstancesAndRecipientsCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1))
            .owningRole("Owning Role")
            .surveyRunId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableInstancesAndRecipientsCreateCommand
        actualImmutableInstancesAndRecipientsCreateCommand = builderResult.build();
    assertEquals(instance, actualImmutableInstancesAndRecipientsCreateCommand);
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
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

    // Act
    Builder actualSurveyRunIdResult = builderResult.surveyRunId(1L);

    // Assert
    assertSame(builderResult, actualSurveyRunIdResult);
  }

  /**
   * Test {@link
   * ImmutableInstancesAndRecipientsCreateCommand#copyOf(InstancesAndRecipientsCreateCommand)}.
   *
   * <ul>
   *   <li>Then return approvalDueDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableInstancesAndRecipientsCreateCommand#copyOf(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(InstancesAndRecipientsCreateCommand); then return approvalDueDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInstancesAndRecipientsCreateCommand ImmutableInstancesAndRecipientsCreateCommand.copyOf(InstancesAndRecipientsCreateCommand)"
  })
  void testCopyOf_thenReturnApprovalDueDateToStringIs19700101() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    ImmutableInstancesAndRecipientsCreateCommand instance =
        ImmutableInstancesAndRecipientsCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .dueDate(dueDate)
            .owningRole("Owning Role")
            .surveyRunId(1L)
            .build();

    // Act
    ImmutableInstancesAndRecipientsCreateCommand actualCopyOfResult =
        ImmutableInstancesAndRecipientsCreateCommand.copyOf(instance);

    // Assert
    LocalDate approvalDueDateResult = actualCopyOfResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    assertEquals(1L, actualCopyOfResult.surveyRunId().longValue());
    assertTrue(actualCopyOfResult.excludedRecipients().isEmpty());
    assertSame(approvalDueDate, approvalDueDateResult);
    assertSame(dueDate, dueDateResult);
  }

  /**
   * Test {@link ImmutableInstancesAndRecipientsCreateCommand#equals(Object)}, and {@link
   * ImmutableInstancesAndRecipientsCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInstancesAndRecipientsCreateCommand#equals(Object)}
   *   <li>{@link ImmutableInstancesAndRecipientsCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInstancesAndRecipientsCreateCommand.equals(Object)",
    "int ImmutableInstancesAndRecipientsCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand immutableInstancesAndRecipientsCreateCommand =
        ImmutableInstancesAndRecipientsCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1))
            .owningRole("Owning Role")
            .surveyRunId(1L)
            .build();
    ImmutableInstancesAndRecipientsCreateCommand immutableInstancesAndRecipientsCreateCommand2 =
        ImmutableInstancesAndRecipientsCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1))
            .owningRole("Owning Role")
            .surveyRunId(1L)
            .build();

    // Act and Assert
    assertEquals(
        immutableInstancesAndRecipientsCreateCommand,
        immutableInstancesAndRecipientsCreateCommand2);
    assertEquals(
        immutableInstancesAndRecipientsCreateCommand.hashCode(),
        immutableInstancesAndRecipientsCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableInstancesAndRecipientsCreateCommand#equals(Object)}, and {@link
   * ImmutableInstancesAndRecipientsCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInstancesAndRecipientsCreateCommand#equals(Object)}
   *   <li>{@link ImmutableInstancesAndRecipientsCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInstancesAndRecipientsCreateCommand.equals(Object)",
    "int ImmutableInstancesAndRecipientsCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand immutableInstancesAndRecipientsCreateCommand =
        ImmutableInstancesAndRecipientsCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1))
            .owningRole("Owning Role")
            .surveyRunId(1L)
            .build();

    // Act and Assert
    assertEquals(
        immutableInstancesAndRecipientsCreateCommand, immutableInstancesAndRecipientsCreateCommand);
    int expectedHashCodeResult = immutableInstancesAndRecipientsCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableInstancesAndRecipientsCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableInstancesAndRecipientsCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInstancesAndRecipientsCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInstancesAndRecipientsCreateCommand.equals(Object)",
    "int ImmutableInstancesAndRecipientsCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableInstancesAndRecipientsCreateCommand.builder();

    ImmutableSurveyInstanceRecipient.Builder idResult =
        ImmutableSurveyInstanceRecipient.builder().id(1L);

    ImmutableSurveyInstanceRecipient.Builder personResult =
        idResult.person(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    ImmutableSurveyInstance.Builder owningRoleResult =
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

    ImmutableSurveyInstance.Builder submittedByResult =
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
    builderResult.addExcludedRecipients(
        personResult
            .surveyInstance(
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
            .build());
    ImmutableInstancesAndRecipientsCreateCommand immutableInstancesAndRecipientsCreateCommand =
        builderResult
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1))
            .owningRole("Owning Role")
            .surveyRunId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInstancesAndRecipientsCreateCommand,
        ImmutableInstancesAndRecipientsCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1))
            .owningRole("Owning Role")
            .surveyRunId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableInstancesAndRecipientsCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInstancesAndRecipientsCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInstancesAndRecipientsCreateCommand.equals(Object)",
    "int ImmutableInstancesAndRecipientsCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableInstancesAndRecipientsCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1))
            .owningRole("Owning Role")
            .surveyRunId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableInstancesAndRecipientsCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInstancesAndRecipientsCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInstancesAndRecipientsCreateCommand.equals(Object)",
    "int ImmutableInstancesAndRecipientsCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableInstancesAndRecipientsCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1))
            .owningRole("Owning Role")
            .surveyRunId(1L)
            .build(),
        "Different type to ImmutableInstancesAndRecipientsCreateCommand");
  }

  /**
   * Test {@link ImmutableInstancesAndRecipientsCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) ExcludedRecipients is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInstancesAndRecipientsCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) ExcludedRecipients is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInstancesAndRecipientsCreateCommand ImmutableInstancesAndRecipientsCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonExcludedRecipientsIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setSurveyRunId(1L);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    json.setDueDate(dueDate);
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    json.setApprovalDueDate(approvalDueDate);
    json.setOwningRole(null);
    json.setExcludedRecipients(new HashSet<>());

    // Act
    ImmutableInstancesAndRecipientsCreateCommand actualFromJsonResult =
        ImmutableInstancesAndRecipientsCreateCommand.fromJson(json);

    // Assert
    LocalDate approvalDueDateResult = actualFromJsonResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualFromJsonResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals(1L, actualFromJsonResult.surveyRunId().longValue());
    assertTrue(actualFromJsonResult.excludedRecipients().isEmpty());
    assertSame(approvalDueDate, approvalDueDateResult);
    assertSame(dueDate, dueDateResult);
  }

  /**
   * Test {@link ImmutableInstancesAndRecipientsCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) OwningRole is {@code Json}.
   *   <li>Then return owningRole is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInstancesAndRecipientsCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) OwningRole is 'Json'; then return owningRole is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInstancesAndRecipientsCreateCommand ImmutableInstancesAndRecipientsCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonOwningRoleIsJson_thenReturnOwningRoleIsJson() {
    // Arrange
    Json json = new Json();
    json.setSurveyRunId(1L);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    json.setDueDate(dueDate);
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    json.setApprovalDueDate(approvalDueDate);
    json.setOwningRole("Json");
    json.setExcludedRecipients(null);

    // Act
    ImmutableInstancesAndRecipientsCreateCommand actualFromJsonResult =
        ImmutableInstancesAndRecipientsCreateCommand.fromJson(json);

    // Assert
    LocalDate approvalDueDateResult = actualFromJsonResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualFromJsonResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Json", actualFromJsonResult.owningRole());
    assertEquals(1L, actualFromJsonResult.surveyRunId().longValue());
    assertTrue(actualFromJsonResult.excludedRecipients().isEmpty());
    assertSame(approvalDueDate, approvalDueDateResult);
    assertSame(dueDate, dueDateResult);
  }

  /**
   * Test {@link ImmutableInstancesAndRecipientsCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link
   *       ImmutableSurveyInstanceRecipient.Json} (default constructor).
   *   <li>Then return excludedRecipients size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInstancesAndRecipientsCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return excludedRecipients size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInstancesAndRecipientsCreateCommand ImmutableInstancesAndRecipientsCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnExcludedRecipientsSizeIsOne() {
    // Arrange
    LinkedHashSet<SurveyInstanceRecipient> excludedRecipients = new LinkedHashSet<>();
    excludedRecipients.add(new ImmutableSurveyInstanceRecipient.Json());

    Json json = new Json();
    json.setSurveyRunId(1L);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setApprovalDueDate(LocalDate.of(1970, 1, 1));
    json.setOwningRole(null);
    json.setExcludedRecipients(excludedRecipients);

    // Act
    ImmutableInstancesAndRecipientsCreateCommand actualFromJsonResult =
        ImmutableInstancesAndRecipientsCreateCommand.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.owningRole());
    assertEquals(1, actualFromJsonResult.excludedRecipients().size());
  }

  /**
   * Test {@link ImmutableInstancesAndRecipientsCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return approvalDueDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInstancesAndRecipientsCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given one; then return approvalDueDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInstancesAndRecipientsCreateCommand ImmutableInstancesAndRecipientsCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenOne_thenReturnApprovalDueDateToStringIs19700101() {
    // Arrange
    Json json = new Json();
    json.setSurveyRunId(1L);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    json.setDueDate(dueDate);
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    json.setApprovalDueDate(approvalDueDate);
    json.setOwningRole(null);
    json.setExcludedRecipients(null);

    // Act
    ImmutableInstancesAndRecipientsCreateCommand actualFromJsonResult =
        ImmutableInstancesAndRecipientsCreateCommand.fromJson(json);

    // Assert
    LocalDate approvalDueDateResult = actualFromJsonResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualFromJsonResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals(1L, actualFromJsonResult.surveyRunId().longValue());
    assertTrue(actualFromJsonResult.excludedRecipients().isEmpty());
    assertSame(approvalDueDate, approvalDueDateResult);
    assertSame(dueDate, dueDateResult);
  }

  /**
   * Test {@link ImmutableInstancesAndRecipientsCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return excludedRecipients is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInstancesAndRecipientsCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return excludedRecipients is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInstancesAndRecipientsCreateCommand ImmutableInstancesAndRecipientsCreateCommand.fromJson(Json)"
  })
  void testFromJson_thenReturnExcludedRecipientsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<SurveyInstanceRecipient> excludedRecipients = new LinkedHashSet<>();

    ImmutableSurveyInstanceRecipient.Builder idResult =
        ImmutableSurveyInstanceRecipient.builder().id(1L);

    ImmutableSurveyInstanceRecipient.Builder personResult =
        idResult.person(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    ImmutableSurveyInstance.Builder owningRoleResult =
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

    ImmutableSurveyInstance.Builder submittedByResult =
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
    excludedRecipients.add(
        personResult
            .surveyInstance(
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
            .build());
    excludedRecipients.add(new ImmutableSurveyInstanceRecipient.Json());

    Json json = new Json();
    json.setSurveyRunId(1L);
    json.setDueDate(LocalDate.of(1970, 1, 1));
    json.setApprovalDueDate(LocalDate.of(1970, 1, 1));
    json.setOwningRole(null);
    json.setExcludedRecipients(excludedRecipients);

    // Act
    ImmutableInstancesAndRecipientsCreateCommand actualFromJsonResult =
        ImmutableInstancesAndRecipientsCreateCommand.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.owningRole());
    assertEquals(excludedRecipients, actualFromJsonResult.excludedRecipients());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInstancesAndRecipientsCreateCommand#toString()}
   *   <li>{@link ImmutableInstancesAndRecipientsCreateCommand#approvalDueDate()}
   *   <li>{@link ImmutableInstancesAndRecipientsCreateCommand#dueDate()}
   *   <li>{@link ImmutableInstancesAndRecipientsCreateCommand#excludedRecipients()}
   *   <li>{@link ImmutableInstancesAndRecipientsCreateCommand#owningRole()}
   *   <li>{@link ImmutableInstancesAndRecipientsCreateCommand#surveyRunId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalDate ImmutableInstancesAndRecipientsCreateCommand.approvalDueDate()",
    "LocalDate ImmutableInstancesAndRecipientsCreateCommand.dueDate()",
    "Set ImmutableInstancesAndRecipientsCreateCommand.excludedRecipients()",
    "String ImmutableInstancesAndRecipientsCreateCommand.owningRole()",
    "Long ImmutableInstancesAndRecipientsCreateCommand.surveyRunId()",
    "String ImmutableInstancesAndRecipientsCreateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    ImmutableInstancesAndRecipientsCreateCommand immutableInstancesAndRecipientsCreateCommand =
        ImmutableInstancesAndRecipientsCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .dueDate(dueDate)
            .owningRole("Owning Role")
            .surveyRunId(1L)
            .build();

    // Act
    String actualToStringResult = immutableInstancesAndRecipientsCreateCommand.toString();
    LocalDate actualApprovalDueDateResult =
        immutableInstancesAndRecipientsCreateCommand.approvalDueDate();
    LocalDate actualDueDateResult = immutableInstancesAndRecipientsCreateCommand.dueDate();
    Set<SurveyInstanceRecipient> actualExcludedRecipientsResult =
        immutableInstancesAndRecipientsCreateCommand.excludedRecipients();
    String actualOwningRoleResult = immutableInstancesAndRecipientsCreateCommand.owningRole();

    // Assert
    assertEquals("1970-01-01", actualApprovalDueDateResult.toString());
    assertEquals("1970-01-01", actualDueDateResult.toString());
    assertEquals(
        "InstancesAndRecipientsCreateCommand{surveyRunId=1, dueDate=1970-01-01, approvalDueDate=1970-01-01,"
            + " owningRole=Owning Role, excludedRecipients=[]}",
        actualToStringResult);
    assertEquals("Owning Role", actualOwningRoleResult);
    assertEquals(1L, immutableInstancesAndRecipientsCreateCommand.surveyRunId().longValue());
    assertTrue(actualExcludedRecipientsResult.isEmpty());
    assertSame(approvalDueDate, actualApprovalDueDateResult);
    assertSame(dueDate, actualDueDateResult);
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
   * Test Json {@link Json#excludedRecipients()}.
   *
   * <p>Method under test: {@link Json#excludedRecipients()}
   */
  @Test
  @DisplayName("Test Json excludedRecipients()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.excludedRecipients()"})
  void testJsonExcludedRecipients() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().excludedRecipients());
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
    assertNull(actualJson.surveyRunId);
    assertNull(actualJson.owningRole);
    assertNull(actualJson.approvalDueDate);
    assertNull(actualJson.dueDate);
    assertTrue(actualJson.excludedRecipients.isEmpty());
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
   * Test {@link ImmutableInstancesAndRecipientsCreateCommand#withApprovalDueDate(LocalDate)}.
   *
   * <p>Method under test: {@link
   * ImmutableInstancesAndRecipientsCreateCommand#withApprovalDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withApprovalDueDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInstancesAndRecipientsCreateCommand ImmutableInstancesAndRecipientsCreateCommand.withApprovalDueDate(LocalDate)"
  })
  void testWithApprovalDueDate() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand immutableInstancesAndRecipientsCreateCommand =
        ImmutableInstancesAndRecipientsCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1))
            .owningRole("Owning Role")
            .surveyRunId(1L)
            .build();

    // Act
    ImmutableInstancesAndRecipientsCreateCommand actualWithApprovalDueDateResult =
        immutableInstancesAndRecipientsCreateCommand.withApprovalDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableInstancesAndRecipientsCreateCommand, actualWithApprovalDueDateResult);
  }

  /**
   * Test {@link ImmutableInstancesAndRecipientsCreateCommand#withDueDate(LocalDate)}.
   *
   * <p>Method under test: {@link
   * ImmutableInstancesAndRecipientsCreateCommand#withDueDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withDueDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInstancesAndRecipientsCreateCommand ImmutableInstancesAndRecipientsCreateCommand.withDueDate(LocalDate)"
  })
  void testWithDueDate() {
    // Arrange
    ImmutableInstancesAndRecipientsCreateCommand immutableInstancesAndRecipientsCreateCommand =
        ImmutableInstancesAndRecipientsCreateCommand.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .dueDate(LocalDate.of(1970, 1, 1))
            .owningRole("Owning Role")
            .surveyRunId(1L)
            .build();

    // Act
    ImmutableInstancesAndRecipientsCreateCommand actualWithDueDateResult =
        immutableInstancesAndRecipientsCreateCommand.withDueDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableInstancesAndRecipientsCreateCommand, actualWithDueDateResult);
  }

  /**
   * Test {@link
   * ImmutableInstancesAndRecipientsCreateCommand#withExcludedRecipients(SurveyInstanceRecipient[])}
   * with {@code SurveyInstanceRecipient[]}.
   *
   * <p>Method under test: {@link
   * ImmutableInstancesAndRecipientsCreateCommand#withExcludedRecipients(SurveyInstanceRecipient[])}
   */
  @Test
  @DisplayName(
      "Test withExcludedRecipients(SurveyInstanceRecipient[]) with 'SurveyInstanceRecipient[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInstancesAndRecipientsCreateCommand ImmutableInstancesAndRecipientsCreateCommand.withExcludedRecipients(SurveyInstanceRecipient[])"
  })
  void testWithExcludedRecipientsWithSurveyInstanceRecipient() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    ImmutableInstancesAndRecipientsCreateCommand immutableInstancesAndRecipientsCreateCommand =
        ImmutableInstancesAndRecipientsCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .dueDate(dueDate)
            .owningRole("Owning Role")
            .surveyRunId(1L)
            .build();

    ImmutableSurveyInstanceRecipient.Builder idResult =
        ImmutableSurveyInstanceRecipient.builder().id(1L);

    ImmutableSurveyInstanceRecipient.Builder personResult =
        idResult.person(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    ImmutableSurveyInstance.Builder owningRoleResult =
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

    ImmutableSurveyInstance.Builder submittedByResult =
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
    ImmutableInstancesAndRecipientsCreateCommand actualWithExcludedRecipientsResult =
        immutableInstancesAndRecipientsCreateCommand.withExcludedRecipients(
            personResult
                .surveyInstance(
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
                .build());

    // Assert
    LocalDate approvalDueDateResult = actualWithExcludedRecipientsResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualWithExcludedRecipientsResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Owning Role", actualWithExcludedRecipientsResult.owningRole());
    assertEquals(1, actualWithExcludedRecipientsResult.excludedRecipients().size());
    assertEquals(1L, actualWithExcludedRecipientsResult.surveyRunId().longValue());
    assertSame(approvalDueDate, approvalDueDateResult);
    assertSame(dueDate, dueDateResult);
  }

  /**
   * Test {@link ImmutableInstancesAndRecipientsCreateCommand#withOwningRole(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableInstancesAndRecipientsCreateCommand#withOwningRole(String)}
   */
  @Test
  @DisplayName("Test withOwningRole(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInstancesAndRecipientsCreateCommand ImmutableInstancesAndRecipientsCreateCommand.withOwningRole(String)"
  })
  void testWithOwningRole() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableInstancesAndRecipientsCreateCommand actualWithOwningRoleResult =
        ImmutableInstancesAndRecipientsCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .dueDate(dueDate)
            .owningRole("Owning Role")
            .surveyRunId(1L)
            .build()
            .withOwningRole("42");

    // Assert
    LocalDate approvalDueDateResult = actualWithOwningRoleResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualWithOwningRoleResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("42", actualWithOwningRoleResult.owningRole());
    assertEquals(1L, actualWithOwningRoleResult.surveyRunId().longValue());
    assertTrue(actualWithOwningRoleResult.excludedRecipients().isEmpty());
    assertSame(approvalDueDate, approvalDueDateResult);
    assertSame(dueDate, dueDateResult);
  }

  /**
   * Test {@link ImmutableInstancesAndRecipientsCreateCommand#withSurveyRunId(Long)}.
   *
   * <p>Method under test: {@link
   * ImmutableInstancesAndRecipientsCreateCommand#withSurveyRunId(Long)}
   */
  @Test
  @DisplayName("Test withSurveyRunId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInstancesAndRecipientsCreateCommand ImmutableInstancesAndRecipientsCreateCommand.withSurveyRunId(Long)"
  })
  void testWithSurveyRunId() {
    // Arrange
    LocalDate approvalDueDate = LocalDate.of(1970, 1, 1);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableInstancesAndRecipientsCreateCommand actualWithSurveyRunIdResult =
        ImmutableInstancesAndRecipientsCreateCommand.builder()
            .approvalDueDate(approvalDueDate)
            .dueDate(dueDate)
            .owningRole("Owning Role")
            .surveyRunId(1L)
            .build()
            .withSurveyRunId(42L);

    // Assert
    LocalDate approvalDueDateResult = actualWithSurveyRunIdResult.approvalDueDate();
    assertEquals("1970-01-01", approvalDueDateResult.toString());
    LocalDate dueDateResult = actualWithSurveyRunIdResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    assertEquals("Owning Role", actualWithSurveyRunIdResult.owningRole());
    assertEquals(42L, actualWithSurveyRunIdResult.surveyRunId().longValue());
    assertTrue(actualWithSurveyRunIdResult.excludedRecipients().isEmpty());
    assertSame(approvalDueDate, approvalDueDateResult);
    assertSame(dueDate, dueDateResult);
  }
}
