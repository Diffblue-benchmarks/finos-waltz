package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceCreateCommand.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SurveyInstanceCreateCommandDiffblueTest {
  /**
   * Test {@link SurveyInstanceCreateCommand#name()}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceCreateCommand#name()}
   */
  @Test
  @DisplayName("Test name(); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SurveyInstanceCreateCommand.name()"})
  void testName_thenReturnName() {
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
   * Test {@link SurveyInstanceCreateCommand#status()}.
   *
   * <ul>
   *   <li>Then return {@code NOT_STARTED}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceCreateCommand#status()}
   */
  @Test
  @DisplayName("Test status(); then return 'NOT_STARTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyInstanceStatus SurveyInstanceCreateCommand.status()"})
  void testStatus_thenReturnNotStarted() {
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
   * Test {@link SurveyInstanceCreateCommand#issuedOn()}.
   *
   * <ul>
   *   <li>Then return toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceCreateCommand#issuedOn()}
   */
  @Test
  @DisplayName("Test issuedOn(); then return toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate SurveyInstanceCreateCommand.issuedOn()"})
  void testIssuedOn_thenReturnToStringIs19700101() {
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
}
