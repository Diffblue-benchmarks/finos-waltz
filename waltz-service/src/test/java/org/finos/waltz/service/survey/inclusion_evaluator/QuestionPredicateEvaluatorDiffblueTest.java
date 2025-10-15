package org.finos.waltz.service.survey.inclusion_evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.jexl3.JexlException;
import org.apache.commons.jexl3.JexlException.Variable;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyQuestion;
import org.finos.waltz.model.survey.ImmutableSurveyQuestion.Builder;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyQuestionFieldType;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class QuestionPredicateEvaluatorDiffblueTest {
  /**
   * Test {@link QuestionPredicateEvaluator#eval(DSLContext, List, EntityReference, Map)}.
   *
   * <p>Method under test: {@link QuestionPredicateEvaluator#eval(DSLContext, List, EntityReference,
   * Map)}
   */
  @Test
  @DisplayName("Test eval(DSLContext, List, EntityReference, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List QuestionPredicateEvaluator.eval(DSLContext, List, EntityReference, Map)"
  })
  void testEval() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);

    ArrayList<SurveyQuestion> qs = new ArrayList<>();

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
    qs.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    List<SurveyQuestion> actualEvalResult =
        QuestionPredicateEvaluator.eval(dsl, qs, subjectRef, new HashMap<>());

    // Assert
    assertTrue(actualEvalResult.isEmpty());
  }

  /**
   * Test {@link QuestionPredicateEvaluator#eval(DSLContext, List, EntityReference, Map)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionPredicateEvaluator#eval(DSLContext, List, EntityReference,
   * Map)}
   */
  @Test
  @DisplayName("Test eval(DSLContext, List, EntityReference, Map); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List QuestionPredicateEvaluator.eval(DSLContext, List, EntityReference, Map)"
  })
  void testEval_thenReturnArrayList() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);

    ArrayList<SurveyQuestion> qs = new ArrayList<>();

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
    qs.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    List<SurveyQuestion> actualEvalResult =
        QuestionPredicateEvaluator.eval(dsl, qs, subjectRef, new HashMap<>());

    // Assert
    assertEquals(qs, actualEvalResult);
  }

  /**
   * Test {@link QuestionPredicateEvaluator#eval(DSLContext, List, EntityReference, Map)}.
   *
   * <ul>
   *   <li>Then throw {@link Variable}.
   * </ul>
   *
   * <p>Method under test: {@link QuestionPredicateEvaluator#eval(DSLContext, List, EntityReference,
   * Map)}
   */
  @Test
  @DisplayName("Test eval(DSLContext, List, EntityReference, Map); then throw Variable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List QuestionPredicateEvaluator.eval(DSLContext, List, EntityReference, Map)"
  })
  void testEval_thenThrowVariable() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);

    ArrayList<SurveyQuestion> qs = new ArrayList<>();

    Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("allowComment")
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
    qs.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertThrows(
        Variable.class,
        () -> QuestionPredicateEvaluator.eval(dsl, qs, subjectRef, new HashMap<>()));
  }

  /**
   * Test {@link QuestionPredicateEvaluator#eval(DSLContext, List, EntityReference, Map)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link QuestionPredicateEvaluator#eval(DSLContext, List, EntityReference,
   * Map)}
   */
  @Test
  @DisplayName(
      "Test eval(DSLContext, List, EntityReference, Map); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List QuestionPredicateEvaluator.eval(DSLContext, List, EntityReference, Map)"
  })
  void testEval_whenArrayList_thenReturnEmpty() {
    // Arrange
    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ArrayList<SurveyQuestion> qs = new ArrayList<>();
    ImmutableEntityReference subjectRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    List<SurveyQuestion> actualEvalResult =
        QuestionPredicateEvaluator.eval(dsl, qs, subjectRef, new HashMap<>());

    // Assert
    assertTrue(actualEvalResult.isEmpty());
  }
}
