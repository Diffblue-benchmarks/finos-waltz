package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyQuestion;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionResponse;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionResponse.Builder;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyQuestionFieldType;
import org.finos.waltz.model.survey.SurveyQuestionResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SurveyInstanceUtilitiesDiffblueTest {
  /**
   * Test {@link SurveyInstanceUtilities#getVal(SurveyQuestion, SurveyQuestionResponse)}.
   *
   * <p>Method under test: {@link SurveyInstanceUtilities#getVal(SurveyQuestion,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test getVal(SurveyQuestion, SurveyQuestionResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SurveyInstanceUtilities.getVal(SurveyQuestion, SurveyQuestionResponse)"
  })
  void testGetVal() {
    // Arrange
    ImmutableSurveyQuestion.Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion question =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference2);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyQuestionResponse resp =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act
    Optional<?> actualVal = SurveyInstanceUtilities.getVal(question, resp);

    // Assert
    assertEquals(qualifierEntity, actualVal);
  }

  /**
   * Test {@link SurveyInstanceUtilities#getVal(SurveyQuestion, SurveyQuestionResponse)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code String Response}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceUtilities#getVal(SurveyQuestion,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName(
      "Test getVal(SurveyQuestion, SurveyQuestionResponse); then return get() is 'String Response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SurveyInstanceUtilities.getVal(SurveyQuestion, SurveyQuestionResponse)"
  })
  void testGetVal_thenReturnGetIsStringResponse() {
    // Arrange
    ImmutableSurveyQuestion.Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.DROPDOWN)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion question =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference2);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyQuestionResponse resp =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act
    Optional<?> actualVal = SurveyInstanceUtilities.getVal(question, resp);

    // Assert
    assertEquals("String Response", actualVal.get());
    assertTrue(actualVal.isPresent());
  }

  /**
   * Test {@link SurveyInstanceUtilities#getVal(SurveyQuestion, SurveyQuestionResponse)}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceUtilities#getVal(SurveyQuestion,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName(
      "Test getVal(SurveyQuestion, SurveyQuestionResponse); then return get() toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SurveyInstanceUtilities.getVal(SurveyQuestion, SurveyQuestionResponse)"
  })
  void testGetVal_thenReturnGetToStringIs19700101() {
    // Arrange
    ImmutableSurveyQuestion.Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.DATE)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion question =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);
    LocalDate dateResponse = LocalDate.of(1970, 1, 1);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(dateResponse);

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference2);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyQuestionResponse resp =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act
    Optional<?> actualVal = SurveyInstanceUtilities.getVal(question, resp);

    // Assert
    Object getResult = actualVal.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(actualVal.isPresent());
    assertSame(dateResponse, getResult);
  }

  /**
   * Test {@link SurveyInstanceUtilities#getVal(SurveyQuestion, SurveyQuestionResponse)}.
   *
   * <ul>
   *   <li>Then return of {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceUtilities#getVal(SurveyQuestion,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test getVal(SurveyQuestion, SurveyQuestionResponse); then return of 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SurveyInstanceUtilities.getVal(SurveyQuestion, SurveyQuestionResponse)"
  })
  void testGetVal_thenReturnOfTrue() {
    // Arrange
    ImmutableSurveyQuestion.Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.BOOLEAN)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    ImmutableSurveyQuestion question =
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build();

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference2);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyQuestionResponse resp =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act
    Optional<?> actualVal = SurveyInstanceUtilities.getVal(question, resp);

    // Assert
    assertEquals(booleanResponse, actualVal);
  }

  /**
   * Test {@link SurveyInstanceUtilities#getVal(SurveyQuestion, SurveyQuestionResponse)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceUtilities#getVal(SurveyQuestion,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName(
      "Test getVal(SurveyQuestion, SurveyQuestionResponse); when 'null'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SurveyInstanceUtilities.getVal(SurveyQuestion, SurveyQuestionResponse)"
  })
  void testGetVal_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<?> actualVal = SurveyInstanceUtilities.getVal(null, null);

    // Assert
    assertFalse(actualVal.isPresent());
  }
}
