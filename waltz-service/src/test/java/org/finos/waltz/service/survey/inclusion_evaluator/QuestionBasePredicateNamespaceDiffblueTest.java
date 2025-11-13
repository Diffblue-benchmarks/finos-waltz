package org.finos.waltz.service.survey.inclusion_evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.jexl3.internal.Engine;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyQuestion;
import org.finos.waltz.model.survey.ImmutableSurveyQuestion.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionResponse;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyQuestionFieldType;
import org.finos.waltz.model.survey.SurveyQuestionResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class QuestionBasePredicateNamespaceDiffblueTest {
  /**
   * Test {@link QuestionBasePredicateNamespace#QuestionBasePredicateNamespace(List, Map)}.
   *
   * <ul>
   *   <li>Then return val {@code 42} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * QuestionBasePredicateNamespace#QuestionBasePredicateNamespace(List, Map)}
   */
  @Test
  @DisplayName("Test new QuestionBasePredicateNamespace(List, Map); then return val '42' is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QuestionBasePredicateNamespace.<init>(List, Map)"})
  void testNewQuestionBasePredicateNamespace_thenReturnVal42IsNull() {
    // Arrange
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    Builder positionResult =
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
    questions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    // Act
    QuestionBasePredicateNamespace actualQuestionBasePredicateNamespace =
        new QuestionBasePredicateNamespace(questions, new HashMap<>());

    // Assert
    assertNull(actualQuestionBasePredicateNamespace.val("42"));
    assertEquals(0.0d, actualQuestionBasePredicateNamespace.numberValue("42"));
    assertFalse(actualQuestionBasePredicateNamespace.isChecked("42"));
  }

  /**
   * Test {@link QuestionBasePredicateNamespace#QuestionBasePredicateNamespace(List, Map)}.
   *
   * <ul>
   *   <li>Then return val {@code 42} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * QuestionBasePredicateNamespace#QuestionBasePredicateNamespace(List, Map)}
   */
  @Test
  @DisplayName("Test new QuestionBasePredicateNamespace(List, Map); then return val '42' is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QuestionBasePredicateNamespace.<init>(List, Map)"})
  void testNewQuestionBasePredicateNamespace_thenReturnVal42IsNull2() {
    // Arrange
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    Builder positionResult =
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
    questions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    Builder positionResult2 =
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
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);
    questions.add(
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    // Act
    QuestionBasePredicateNamespace actualQuestionBasePredicateNamespace =
        new QuestionBasePredicateNamespace(questions, new HashMap<>());

    // Assert
    assertNull(actualQuestionBasePredicateNamespace.val("42"));
    assertEquals(0.0d, actualQuestionBasePredicateNamespace.numberValue("42"));
    assertFalse(actualQuestionBasePredicateNamespace.isChecked("42"));
  }

  /**
   * Test {@link QuestionBasePredicateNamespace#isChecked(String, boolean)} with {@code qExtId},
   * {@code defaultValue}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionBasePredicateNamespace#isChecked(String, boolean)}
   */
  @Test
  @DisplayName("Test isChecked(String, boolean) with 'qExtId', 'defaultValue'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionBasePredicateNamespace.isChecked(String, boolean)"})
  void testIsCheckedWithQExtIdDefaultValue_thenReturnTrue() {
    // Arrange
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    Builder positionResult =
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
    questions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    QuestionBasePredicateNamespace questionBasePredicateNamespace =
        new QuestionBasePredicateNamespace(questions, new HashMap<>());

    // Act and Assert
    assertTrue(questionBasePredicateNamespace.isChecked("42", true));
  }

  /**
   * Test {@link QuestionBasePredicateNamespace#isChecked(String, boolean)} with {@code qExtId},
   * {@code defaultValue}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionBasePredicateNamespace#isChecked(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test isChecked(String, boolean) with 'qExtId', 'defaultValue'; when 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionBasePredicateNamespace.isChecked(String, boolean)"})
  void testIsCheckedWithQExtIdDefaultValue_whenFalse_thenReturnFalse() {
    // Arrange
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    Builder positionResult =
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
    questions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    QuestionBasePredicateNamespace questionBasePredicateNamespace =
        new QuestionBasePredicateNamespace(questions, new HashMap<>());

    // Act and Assert
    assertFalse(questionBasePredicateNamespace.isChecked("42", false));
  }

  /**
   * Test {@link QuestionBasePredicateNamespace#isChecked(String)} with {@code qExtId}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionBasePredicateNamespace#isChecked(String)}
   */
  @Test
  @DisplayName("Test isChecked(String) with 'qExtId'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionBasePredicateNamespace.isChecked(String)"})
  void testIsCheckedWithQExtId_thenReturnFalse() {
    // Arrange
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    Builder positionResult =
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
    questions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    QuestionBasePredicateNamespace questionBasePredicateNamespace =
        new QuestionBasePredicateNamespace(questions, new HashMap<>());

    // Act and Assert
    assertFalse(questionBasePredicateNamespace.isChecked("42"));
  }

  /**
   * Test {@link QuestionBasePredicateNamespace#isChecked(String)} with {@code qExtId}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionBasePredicateNamespace#isChecked(String)}
   */
  @Test
  @DisplayName("Test isChecked(String) with 'qExtId'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionBasePredicateNamespace.isChecked(String)"})
  void testIsCheckedWithQExtId_thenReturnTrue() {
    // Arrange
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    Builder positionResult =
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
    questions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
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

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);
    responsesByQuestionId.put(
        1L,
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build());

    QuestionBasePredicateNamespace questionBasePredicateNamespace =
        new QuestionBasePredicateNamespace(questions, responsesByQuestionId);

    // Act and Assert
    assertTrue(questionBasePredicateNamespace.isChecked("42"));
  }

  /**
   * Test {@link QuestionBasePredicateNamespace#numberValue(String, double)} with {@code qExtId},
   * {@code defaultValue}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link QuestionBasePredicateNamespace#numberValue(String, double)}
   */
  @Test
  @DisplayName("Test numberValue(String, double) with 'qExtId', 'defaultValue'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double QuestionBasePredicateNamespace.numberValue(String, double)"})
  void testNumberValueWithQExtIdDefaultValue_thenReturnTen() {
    // Arrange
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    Builder positionResult =
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
    questions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    QuestionBasePredicateNamespace questionBasePredicateNamespace =
        new QuestionBasePredicateNamespace(questions, new HashMap<>());

    // Act and Assert
    assertEquals(10.0d, questionBasePredicateNamespace.numberValue("42", 10.0d));
  }

  /**
   * Test {@link QuestionBasePredicateNamespace#numberValue(String)} with {@code qExtId}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link QuestionBasePredicateNamespace#numberValue(String)}
   */
  @Test
  @DisplayName("Test numberValue(String) with 'qExtId'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double QuestionBasePredicateNamespace.numberValue(String)"})
  void testNumberValueWithQExtId_thenReturnZero() {
    // Arrange
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    Builder positionResult =
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
    questions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    QuestionBasePredicateNamespace questionBasePredicateNamespace =
        new QuestionBasePredicateNamespace(questions, new HashMap<>());

    // Act and Assert
    assertEquals(0.0d, questionBasePredicateNamespace.numberValue("42"));
  }

  /**
   * Test {@link QuestionBasePredicateNamespace#ditto(String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionBasePredicateNamespace#ditto(String)}
   */
  @Test
  @DisplayName("Test ditto(String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionBasePredicateNamespace.ditto(String)"})
  void testDitto_thenReturnFalse() {
    // Arrange
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("42")
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
    questions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    QuestionBasePredicateNamespace questionBasePredicateNamespace =
        new QuestionBasePredicateNamespace(questions, new HashMap<>());
    questionBasePredicateNamespace.usingEvaluator(new Engine());

    // Act and Assert
    assertFalse(questionBasePredicateNamespace.ditto("42"));
  }

  /**
   * Test {@link QuestionBasePredicateNamespace#ditto(String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionBasePredicateNamespace#ditto(String)}
   */
  @Test
  @DisplayName("Test ditto(String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QuestionBasePredicateNamespace.ditto(String)"})
  void testDitto_thenReturnTrue() {
    // Arrange
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("")
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
    questions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    QuestionBasePredicateNamespace questionBasePredicateNamespace =
        new QuestionBasePredicateNamespace(questions, new HashMap<>());
    questionBasePredicateNamespace.usingEvaluator(new Engine());

    // Act and Assert
    assertTrue(questionBasePredicateNamespace.ditto("42"));
  }

  /**
   * Test {@link QuestionBasePredicateNamespace#val(String, Object)} with {@code qExtId}, {@code
   * defaultValue}.
   *
   * <ul>
   *   <li>Then return {@code Default Value}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionBasePredicateNamespace#val(String, Object)}
   */
  @Test
  @DisplayName(
      "Test val(String, Object) with 'qExtId', 'defaultValue'; then return 'Default Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object QuestionBasePredicateNamespace.val(String, Object)"})
  void testValWithQExtIdDefaultValue_thenReturnDefaultValue() {
    // Arrange
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    Builder positionResult =
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
    questions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    QuestionBasePredicateNamespace questionBasePredicateNamespace =
        new QuestionBasePredicateNamespace(questions, new HashMap<>());

    // Act and Assert
    assertEquals("Default Value", questionBasePredicateNamespace.val("42", "Default Value"));
  }

  /**
   * Test {@link QuestionBasePredicateNamespace#val(String, Object)} with {@code qExtId}, {@code
   * defaultValue}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionBasePredicateNamespace#val(String, Object)}
   */
  @Test
  @DisplayName(
      "Test val(String, Object) with 'qExtId', 'defaultValue'; then return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object QuestionBasePredicateNamespace.val(String, Object)"})
  void testValWithQExtIdDefaultValue_thenReturnImmutableEntityReference() {
    // Arrange
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    Builder positionResult =
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
    questions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
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

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);
    responsesByQuestionId.put(
        1L,
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build());

    QuestionBasePredicateNamespace questionBasePredicateNamespace =
        new QuestionBasePredicateNamespace(questions, responsesByQuestionId);

    // Act
    Object actualValResult = questionBasePredicateNamespace.val("42", "Default Value");

    // Assert
    assertTrue(actualValResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something",
        ((ImmutableEntityReference) actualValResult).description());
    assertEquals(1L, ((ImmutableEntityReference) actualValResult).id());
    assertEquals(EntityKind.ALL, ((ImmutableEntityReference) actualValResult).kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        ((ImmutableEntityReference) actualValResult).entityLifecycleStatus());
  }

  /**
   * Test {@link QuestionBasePredicateNamespace#val(String)} with {@code qExtId}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionBasePredicateNamespace#val(String)}
   */
  @Test
  @DisplayName("Test val(String) with 'qExtId'; then return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object QuestionBasePredicateNamespace.val(String)"})
  void testValWithQExtId_thenReturnImmutableEntityReference() {
    // Arrange
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    Builder positionResult =
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
    questions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();

    ImmutableSurveyQuestionResponse.Builder builderResult =
        ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    ImmutableSurveyQuestionResponse.Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    ImmutableSurveyQuestionResponse.Builder entityListResponseResult =
        dateResponseResult.entityListResponse(new ArrayList<>());
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

    ImmutableSurveyQuestionResponse.Builder entityResponseResult =
        entityListResponseResult.entityResponse(entityResponse);
    responsesByQuestionId.put(
        1L,
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build());

    QuestionBasePredicateNamespace questionBasePredicateNamespace =
        new QuestionBasePredicateNamespace(questions, responsesByQuestionId);

    // Act
    Object actualValResult = questionBasePredicateNamespace.val("42");

    // Assert
    assertTrue(actualValResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something",
        ((ImmutableEntityReference) actualValResult).description());
    assertEquals(1L, ((ImmutableEntityReference) actualValResult).id());
    assertEquals(EntityKind.ALL, ((ImmutableEntityReference) actualValResult).kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        ((ImmutableEntityReference) actualValResult).entityLifecycleStatus());
  }

  /**
   * Test {@link QuestionBasePredicateNamespace#val(String)} with {@code qExtId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionBasePredicateNamespace#val(String)}
   */
  @Test
  @DisplayName("Test val(String) with 'qExtId'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object QuestionBasePredicateNamespace.val(String)"})
  void testValWithQExtId_thenReturnNull() {
    // Arrange
    ArrayList<SurveyQuestion> questions = new ArrayList<>();

    Builder positionResult =
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
    questions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    QuestionBasePredicateNamespace questionBasePredicateNamespace =
        new QuestionBasePredicateNamespace(questions, new HashMap<>());

    // Act and Assert
    assertNull(questionBasePredicateNamespace.val("42"));
  }
}
