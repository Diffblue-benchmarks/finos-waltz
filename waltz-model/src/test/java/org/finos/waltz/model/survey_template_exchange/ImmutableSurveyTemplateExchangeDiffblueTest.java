package org.finos.waltz.model.survey_template_exchange;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.SurveyQuestionFieldType;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyTemplateExchange.Builder;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyTemplateExchange.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyTemplateExchangeDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllQuestions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllQuestions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllQuestions(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllQuestions(Iterable)"})
  void testBuilderAddAllQuestions_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    // Act
    Builder actualAddAllQuestionsResult = builderResult.addAllQuestions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllQuestionsResult);
  }

  /**
   * Test Builder {@link Builder#addQuestions(SurveyQuestionModel)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableSurveyQuestionModel.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addQuestions(SurveyQuestionModel)}
   */
  @Test
  @DisplayName(
      "Test Builder addQuestions(SurveyQuestionModel) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addQuestions(SurveyQuestionModel)"})
  void testBuilderAddQuestionsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    // Act
    Builder actualAddQuestionsResult =
        builderResult.addQuestions(new ImmutableSurveyQuestionModel.Json());

    // Assert
    assertSame(builderResult, actualAddQuestionsResult);
  }

  /**
   * Test Builder {@link Builder#addQuestions(SurveyQuestionModel[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableSurveyQuestionModel.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addQuestions(SurveyQuestionModel[])}
   */
  @Test
  @DisplayName(
      "Test Builder addQuestions(SurveyQuestionModel[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addQuestions(SurveyQuestionModel[])"})
  void testBuilderAddQuestionsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    // Act
    Builder actualAddQuestionsResult =
        builderResult.addQuestions(new ImmutableSurveyQuestionModel.Json());

    // Assert
    assertSame(builderResult, actualAddQuestionsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplateExchange Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSurveyTemplateExchange.builder();
    ImmutableSurveyTemplateModel template =
        ImmutableSurveyTemplateModel.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .issuanceRole("Issuance Role")
            .name("Name")
            .ownerEmployeeId("42")
            .targetEntityKind(EntityKind.ALL)
            .build();
    ImmutableSurveyTemplateExchange actualImmutableSurveyTemplateExchange =
        actualBuilderResult.template(template).build();

    // Assert
    assertTrue(actualImmutableSurveyTemplateExchange.questions().isEmpty());
    assertSame(template, actualImmutableSurveyTemplateExchange.template());
  }

  /**
   * Test Builder {@link Builder#from(SurveyTemplateExchange)}.
   *
   * <p>Method under test: {@link Builder#from(SurveyTemplateExchange)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyTemplateExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyTemplateExchange)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    Builder builderResult2 = ImmutableSurveyTemplateExchange.builder();
    ImmutableSurveyTemplateExchange instance =
        builderResult2
            .template(
                ImmutableSurveyTemplateModel.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .ownerEmployeeId("42")
                    .targetEntityKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyTemplateExchange actualImmutableSurveyTemplateExchange = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateExchange);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyTemplateExchange)}.
   *
   * <ul>
   *   <li>Then return build questions size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyTemplateExchange)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyTemplateExchange); then return build questions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyTemplateExchange)"})
  void testBuilderFrom_thenReturnBuildQuestionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    Builder builderResult2 = ImmutableSurveyTemplateExchange.builder();

    ImmutableSurveyQuestionModel.Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    builderResult2.addQuestions(
        positionResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .questionText("Question Text")
            .sectionName("Section Name")
            .build());

    // Act and Assert
    List<SurveyQuestionModel> questionsResult =
        builderResult
            .from(
                builderResult2
                    .template(
                        ImmutableSurveyTemplateModel.builder()
                            .description("The characteristics of someone or something")
                            .externalId("42")
                            .issuanceRole("Issuance Role")
                            .name("Name")
                            .ownerEmployeeId("42")
                            .targetEntityKind(EntityKind.ALL)
                            .build())
                    .build())
            .build()
            .questions();
    assertEquals(1, questionsResult.size());
    SurveyQuestionModel getResult = questionsResult.get(0);
    assertTrue(getResult.qualifierEntity() instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableSurveyQuestionModel);
    assertEquals("42", getResult.parentExternalId());
    assertEquals("Help Text", getResult.helpText());
    assertEquals("Inclusion Predicate", getResult.inclusionPredicate());
    assertEquals("Label", getResult.label());
    assertEquals("Question Text", getResult.questionText());
    assertEquals("Section Name", getResult.sectionName());
    assertEquals(1, getResult.position());
    assertEquals(SurveyQuestionFieldType.APPLICATION, getResult.fieldType());
    assertTrue(getResult.dropdownEntries().isEmpty());
    assertTrue(getResult.allowComment());
    assertTrue(getResult.isMandatory());
  }

  /**
   * Test Builder {@link Builder#questions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#questions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder questions(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.questions(Iterable)"})
  void testBuilderQuestions_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    // Act
    Builder actualQuestionsResult = builderResult.questions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualQuestionsResult);
  }

  /**
   * Test Builder {@link Builder#template(SurveyTemplateModel)}.
   *
   * <ul>
   *   <li>When {@link ImmutableSurveyTemplateModel.Json} (default constructor).
   *   <li>Then builder build template is {@link ImmutableSurveyTemplateModel.Json} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#template(SurveyTemplateModel)}
   */
  @Test
  @DisplayName(
      "Test Builder template(SurveyTemplateModel); when Json (default constructor); then builder build template is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.template(SurveyTemplateModel)"})
  void testBuilderTemplate_whenJson_thenBuilderBuildTemplateIsJson() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();
    ImmutableSurveyTemplateModel.Json template = new ImmutableSurveyTemplateModel.Json();

    // Act
    Builder actualTemplateResult = builderResult.template(template);

    // Assert
    assertSame(template, builderResult.build().template());
    assertSame(builderResult, actualTemplateResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateExchange#copyOf(SurveyTemplateExchange)}.
   *
   * <ul>
   *   <li>Then template return {@link ImmutableSurveyTemplateModel}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateExchange#copyOf(SurveyTemplateExchange)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyTemplateExchange); then template return ImmutableSurveyTemplateModel")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateExchange ImmutableSurveyTemplateExchange.copyOf(SurveyTemplateExchange)"
  })
  void testCopyOf_thenTemplateReturnImmutableSurveyTemplateModel() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();
    ImmutableSurveyTemplateExchange instance =
        builderResult
            .template(
                ImmutableSurveyTemplateModel.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .ownerEmployeeId("42")
                    .targetEntityKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    ImmutableSurveyTemplateExchange actualCopyOfResult =
        ImmutableSurveyTemplateExchange.copyOf(instance);

    // Assert
    SurveyTemplateModel templateResult = actualCopyOfResult.template();
    assertTrue(templateResult instanceof ImmutableSurveyTemplateModel);
    assertEquals("42", templateResult.ownerEmployeeId());
    assertEquals("Issuance Role", templateResult.issuanceRole());
    assertEquals("Name", templateResult.name());
    assertEquals("The characteristics of someone or something", templateResult.description());
    assertEquals(EntityKind.ALL, templateResult.targetEntityKind());
    assertTrue(actualCopyOfResult.questions().isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyTemplateExchange#equals(Object)}, and {@link
   * ImmutableSurveyTemplateExchange#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyTemplateExchange#equals(Object)}
   *   <li>{@link ImmutableSurveyTemplateExchange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateExchange.equals(Object)",
    "int ImmutableSurveyTemplateExchange.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();
    ImmutableSurveyTemplateExchange immutableSurveyTemplateExchange =
        builderResult
            .template(
                ImmutableSurveyTemplateModel.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .ownerEmployeeId("42")
                    .targetEntityKind(EntityKind.ALL)
                    .build())
            .build();

    Builder builderResult2 = ImmutableSurveyTemplateExchange.builder();
    ImmutableSurveyTemplateExchange immutableSurveyTemplateExchange2 =
        builderResult2
            .template(
                ImmutableSurveyTemplateModel.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .ownerEmployeeId("42")
                    .targetEntityKind(EntityKind.ALL)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableSurveyTemplateExchange, immutableSurveyTemplateExchange2);
    assertEquals(
        immutableSurveyTemplateExchange.hashCode(), immutableSurveyTemplateExchange2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyTemplateExchange#equals(Object)}, and {@link
   * ImmutableSurveyTemplateExchange#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyTemplateExchange#equals(Object)}
   *   <li>{@link ImmutableSurveyTemplateExchange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateExchange.equals(Object)",
    "int ImmutableSurveyTemplateExchange.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();
    ImmutableSurveyTemplateExchange immutableSurveyTemplateExchange =
        builderResult
            .template(
                ImmutableSurveyTemplateModel.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .ownerEmployeeId("42")
                    .targetEntityKind(EntityKind.ALL)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableSurveyTemplateExchange, immutableSurveyTemplateExchange);
    int expectedHashCodeResult = immutableSurveyTemplateExchange.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyTemplateExchange.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyTemplateExchange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateExchange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateExchange.equals(Object)",
    "int ImmutableSurveyTemplateExchange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    ImmutableSurveyQuestionModel.Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    builderResult.addQuestions(
        positionResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .questionText("Question Text")
            .sectionName("Section Name")
            .build());
    ImmutableSurveyTemplateExchange immutableSurveyTemplateExchange =
        builderResult
            .template(
                ImmutableSurveyTemplateModel.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .ownerEmployeeId("42")
                    .targetEntityKind(EntityKind.ALL)
                    .build())
            .build();

    Builder builderResult2 = ImmutableSurveyTemplateExchange.builder();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplateExchange,
        builderResult2
            .template(
                ImmutableSurveyTemplateModel.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .ownerEmployeeId("42")
                    .targetEntityKind(EntityKind.ALL)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplateExchange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateExchange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateExchange.equals(Object)",
    "int ImmutableSurveyTemplateExchange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();
    ImmutableSurveyTemplateExchange immutableSurveyTemplateExchange =
        builderResult
            .template(
                ImmutableSurveyTemplateModel.builder()
                    .description("The characteristics of someone or something")
                    .externalId("Name")
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .ownerEmployeeId("42")
                    .targetEntityKind(EntityKind.ALL)
                    .build())
            .build();

    Builder builderResult2 = ImmutableSurveyTemplateExchange.builder();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplateExchange,
        builderResult2
            .template(
                ImmutableSurveyTemplateModel.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .ownerEmployeeId("42")
                    .targetEntityKind(EntityKind.ALL)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplateExchange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateExchange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateExchange.equals(Object)",
    "int ImmutableSurveyTemplateExchange.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .template(
                ImmutableSurveyTemplateModel.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .ownerEmployeeId("42")
                    .targetEntityKind(EntityKind.ALL)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyTemplateExchange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateExchange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateExchange.equals(Object)",
    "int ImmutableSurveyTemplateExchange.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .template(
                ImmutableSurveyTemplateModel.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .ownerEmployeeId("42")
                    .targetEntityKind(EntityKind.ALL)
                    .build())
            .build(),
        "Different type to ImmutableSurveyTemplateExchange");
  }

  /**
   * Test {@link ImmutableSurveyTemplateExchange#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableSurveyQuestionModel.Json}
   *       (default constructor).
   *   <li>Then return questions size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateExchange#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return questions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateExchange ImmutableSurveyTemplateExchange.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_thenReturnQuestionsSizeIsOne() {
    // Arrange
    ArrayList<SurveyQuestionModel> questions = new ArrayList<>();
    ImmutableSurveyQuestionModel.Json json = new ImmutableSurveyQuestionModel.Json();
    questions.add(json);

    Json json2 = new Json();
    json2.setTemplate(new ImmutableSurveyTemplateModel.Json());
    json2.setQuestions(questions);

    // Act
    ImmutableSurveyTemplateExchange actualFromJsonResult =
        ImmutableSurveyTemplateExchange.fromJson(json2);

    // Assert
    List<SurveyQuestionModel> questionsResult = actualFromJsonResult.questions();
    assertEquals(1, questionsResult.size());
    assertSame(json, questionsResult.get(0));
  }

  /**
   * Test {@link ImmutableSurveyTemplateExchange#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link Json} (default constructor) Template is {@link
   *       ImmutableSurveyTemplateModel.Json} (default constructor).
   *   <li>Then return questions Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateExchange#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList(); when Json (default constructor) Template is Json (default constructor); then return questions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateExchange ImmutableSurveyTemplateExchange.fromJson(Json)"
  })
  void testFromJson_givenArrayList_whenJsonTemplateIsJson_thenReturnQuestionsEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableSurveyTemplateModel.Json template = new ImmutableSurveyTemplateModel.Json();
    json.setTemplate(template);
    json.setQuestions(new ArrayList<>());

    // Act
    ImmutableSurveyTemplateExchange actualFromJsonResult =
        ImmutableSurveyTemplateExchange.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.questions().isEmpty());
    assertSame(template, actualFromJsonResult.template());
  }

  /**
   * Test {@link ImmutableSurveyTemplateExchange#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Questions is {@code null}.
   *   <li>Then return questions Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateExchange#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Questions is 'null'; then return questions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateExchange ImmutableSurveyTemplateExchange.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonQuestionsIsNull_thenReturnQuestionsEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableSurveyTemplateModel.Json template = new ImmutableSurveyTemplateModel.Json();
    json.setTemplate(template);
    json.setQuestions(null);

    // Act
    ImmutableSurveyTemplateExchange actualFromJsonResult =
        ImmutableSurveyTemplateExchange.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.questions().isEmpty());
    assertSame(template, actualFromJsonResult.template());
  }

  /**
   * Test {@link ImmutableSurveyTemplateExchange#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return questions size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateExchange#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return questions size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateExchange ImmutableSurveyTemplateExchange.fromJson(Json)"
  })
  void testFromJson_thenReturnQuestionsSizeIsTwo() {
    // Arrange
    ArrayList<SurveyQuestionModel> questions = new ArrayList<>();

    ImmutableSurveyQuestionModel.Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    questions.add(
        positionResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .questionText("Question Text")
            .sectionName("Section Name")
            .build());
    ImmutableSurveyQuestionModel.Json json = new ImmutableSurveyQuestionModel.Json();
    questions.add(json);

    Json json2 = new Json();
    json2.setTemplate(new ImmutableSurveyTemplateModel.Json());
    json2.setQuestions(questions);

    // Act
    ImmutableSurveyTemplateExchange actualFromJsonResult =
        ImmutableSurveyTemplateExchange.fromJson(json2);

    // Assert
    List<SurveyQuestionModel> questionsResult = actualFromJsonResult.questions();
    assertEquals(2, questionsResult.size());
    assertTrue(questionsResult.get(0) instanceof ImmutableSurveyQuestionModel);
    SurveyQuestionModel getResult = questionsResult.get(1);
    assertTrue(getResult instanceof ImmutableSurveyQuestionModel.Json);
    assertSame(json, getResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyTemplateExchange#toString()}
   *   <li>{@link ImmutableSurveyTemplateExchange#questions()}
   *   <li>{@link ImmutableSurveyTemplateExchange#template()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableSurveyTemplateExchange.questions()",
    "SurveyTemplateModel ImmutableSurveyTemplateExchange.template()",
    "String ImmutableSurveyTemplateExchange.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();
    ImmutableSurveyTemplateExchange immutableSurveyTemplateExchange =
        builderResult
            .template(
                ImmutableSurveyTemplateModel.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .ownerEmployeeId("42")
                    .targetEntityKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableSurveyTemplateExchange.toString();
    List<SurveyQuestionModel> actualQuestionsResult = immutableSurveyTemplateExchange.questions();

    // Assert
    assertTrue(immutableSurveyTemplateExchange.template() instanceof ImmutableSurveyTemplateModel);
    assertEquals(
        "SurveyTemplateExchange{template=SurveyTemplateModel{name=Name, externalId=42, targetEntityKind=ALL,"
            + " issuanceRole=Issuance Role, ownerEmployeeId=42}, questions=[]}",
        actualToStringResult);
    assertTrue(actualQuestionsResult.isEmpty());
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
    assertNull(actualJson.template);
    assertTrue(actualJson.questions.isEmpty());
  }

  /**
   * Test Json {@link Json#questions()}.
   *
   * <p>Method under test: {@link Json#questions()}
   */
  @Test
  @DisplayName("Test Json questions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.questions()"})
  void testJsonQuestions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().questions());
  }

  /**
   * Test Json {@link Json#template()}.
   *
   * <p>Method under test: {@link Json#template()}
   */
  @Test
  @DisplayName("Test Json template()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyTemplateModel Json.template()"})
  void testJsonTemplate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().template());
  }

  /**
   * Test {@link ImmutableSurveyTemplateExchange#withQuestions(SurveyQuestionModel[])} with {@code
   * SurveyQuestionModel[]}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyTemplateExchange#withQuestions(SurveyQuestionModel[])}
   */
  @Test
  @DisplayName("Test withQuestions(SurveyQuestionModel[]) with 'SurveyQuestionModel[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateExchange ImmutableSurveyTemplateExchange.withQuestions(SurveyQuestionModel[])"
  })
  void testWithQuestionsWithSurveyQuestionModel() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();
    ImmutableSurveyTemplateExchange immutableSurveyTemplateExchange =
        builderResult
            .template(
                ImmutableSurveyTemplateModel.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .ownerEmployeeId("42")
                    .targetEntityKind(EntityKind.ALL)
                    .build())
            .build();

    ImmutableSurveyQuestionModel.Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);

    // Act
    ImmutableSurveyTemplateExchange actualWithQuestionsResult =
        immutableSurveyTemplateExchange.withQuestions(
            positionResult
                .qualifierEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .questionText("Question Text")
                .sectionName("Section Name")
                .build());

    // Assert
    List<SurveyQuestionModel> questionsResult = actualWithQuestionsResult.questions();
    assertEquals(1, questionsResult.size());
    assertTrue(questionsResult.get(0) instanceof ImmutableSurveyQuestionModel);
    SurveyTemplateModel templateResult = actualWithQuestionsResult.template();
    assertTrue(templateResult instanceof ImmutableSurveyTemplateModel);
    assertEquals("42", templateResult.ownerEmployeeId());
    assertEquals("Issuance Role", templateResult.issuanceRole());
    assertEquals("Name", templateResult.name());
    assertEquals("The characteristics of someone or something", templateResult.description());
    assertEquals(EntityKind.ALL, templateResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateExchange#withTemplate(SurveyTemplateModel)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateExchange#withTemplate(SurveyTemplateModel)}
   */
  @Test
  @DisplayName("Test withTemplate(SurveyTemplateModel)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateExchange ImmutableSurveyTemplateExchange.withTemplate(SurveyTemplateModel)"
  })
  void testWithTemplate() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateExchange.builder();
    ImmutableSurveyTemplateExchange immutableSurveyTemplateExchange =
        builderResult
            .template(
                ImmutableSurveyTemplateModel.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .ownerEmployeeId("42")
                    .targetEntityKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    ImmutableSurveyTemplateExchange actualWithTemplateResult =
        immutableSurveyTemplateExchange.withTemplate(
            ImmutableSurveyTemplateModel.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .issuanceRole("Issuance Role")
                .name("Name")
                .ownerEmployeeId("42")
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Assert
    assertEquals(immutableSurveyTemplateExchange, actualWithTemplateResult);
  }
}
