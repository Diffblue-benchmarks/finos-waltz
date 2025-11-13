package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceFormDetails.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceFormDetails.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceFormDetailsDiffblueTest {
  /**
   * Test Builder {@link Builder#activeQuestions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#activeQuestions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder activeQuestions(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.activeQuestions(Iterable)"})
  void testBuilderActiveQuestions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act
    Builder actualActiveQuestionsResult = builderResult.activeQuestions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualActiveQuestionsResult);
  }

  /**
   * Test Builder {@link Builder#addActiveQuestions(SurveyQuestion)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addActiveQuestions(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test Builder addActiveQuestions(SurveyQuestion) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addActiveQuestions(SurveyQuestion)"})
  void testBuilderAddActiveQuestionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();
    ImmutableSurveyQuestion.Json element = new ImmutableSurveyQuestion.Json();

    // Act
    Builder actualAddActiveQuestionsResult = builderResult.addActiveQuestions(element);

    // Assert
    List<SurveyQuestion> activeQuestionsResult = builderResult.build().activeQuestions();
    assertEquals(1, activeQuestionsResult.size());
    assertSame(element, activeQuestionsResult.get(0));
    assertSame(builderResult, actualAddActiveQuestionsResult);
  }

  /**
   * Test Builder {@link Builder#addActiveQuestions(SurveyQuestion[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addActiveQuestions(SurveyQuestion[])}
   */
  @Test
  @DisplayName("Test Builder addActiveQuestions(SurveyQuestion[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addActiveQuestions(SurveyQuestion[])"})
  void testBuilderAddActiveQuestionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();
    ImmutableSurveyQuestion.Json json = new ImmutableSurveyQuestion.Json();

    // Act
    Builder actualAddActiveQuestionsResult = builderResult.addActiveQuestions(json);

    // Assert
    List<SurveyQuestion> activeQuestionsResult = builderResult.build().activeQuestions();
    assertEquals(1, activeQuestionsResult.size());
    assertSame(json, activeQuestionsResult.get(0));
    assertSame(builderResult, actualAddActiveQuestionsResult);
  }

  /**
   * Test Builder {@link Builder#addAllActiveQuestions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllActiveQuestions(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllActiveQuestions(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllActiveQuestions(Iterable)"})
  void testBuilderAddAllActiveQuestions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act
    Builder actualAddAllActiveQuestionsResult =
        builderResult.addAllActiveQuestions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllActiveQuestionsResult);
  }

  /**
   * Test Builder {@link Builder#addAllMissingMandatoryQuestionIds(Iterable)}.
   *
   * <p>Method under test: {@link Builder#addAllMissingMandatoryQuestionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllMissingMandatoryQuestionIds(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllMissingMandatoryQuestionIds(Iterable)"})
  void testBuilderAddAllMissingMandatoryQuestionIds() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllMissingMandatoryQuestionIdsResult =
        builderResult.addAllMissingMandatoryQuestionIds(elements);

    // Assert
    assertEquals(elements, builderResult.build().missingMandatoryQuestionIds());
    assertSame(builderResult, actualAddAllMissingMandatoryQuestionIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllMissingMandatoryQuestionIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllMissingMandatoryQuestionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllMissingMandatoryQuestionIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllMissingMandatoryQuestionIds(Iterable)"})
  void testBuilderAddAllMissingMandatoryQuestionIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act
    Builder actualAddAllMissingMandatoryQuestionIdsResult =
        builderResult.addAllMissingMandatoryQuestionIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllMissingMandatoryQuestionIdsResult);
  }

  /**
   * Test Builder {@link Builder#addMissingMandatoryQuestionIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addMissingMandatoryQuestionIds(long)}
   */
  @Test
  @DisplayName("Test Builder addMissingMandatoryQuestionIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMissingMandatoryQuestionIds(long)"})
  void testBuilderAddMissingMandatoryQuestionIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act
    Builder actualAddMissingMandatoryQuestionIdsResult =
        builderResult.addMissingMandatoryQuestionIds(1L);

    // Assert
    Set<Long> missingMandatoryQuestionIdsResult =
        builderResult.build().missingMandatoryQuestionIds();
    assertEquals(1, missingMandatoryQuestionIdsResult.size());
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
    assertSame(builderResult, actualAddMissingMandatoryQuestionIdsResult);
  }

  /**
   * Test Builder {@link Builder#addMissingMandatoryQuestionIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addMissingMandatoryQuestionIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addMissingMandatoryQuestionIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addMissingMandatoryQuestionIds(long[])"})
  void testBuilderAddMissingMandatoryQuestionIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act
    Builder actualAddMissingMandatoryQuestionIdsResult =
        builderResult.addMissingMandatoryQuestionIds(1L, -1L, 1L, -1L);

    // Assert
    Set<Long> missingMandatoryQuestionIdsResult =
        builderResult.build().missingMandatoryQuestionIds();
    assertEquals(2, missingMandatoryQuestionIdsResult.size());
    assertTrue(missingMandatoryQuestionIdsResult.contains(-1L));
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
    assertSame(builderResult, actualAddMissingMandatoryQuestionIdsResult);
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
  @MethodsUnderTest({"ImmutableSurveyInstanceFormDetails Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSurveyInstanceFormDetails actualImmutableSurveyInstanceFormDetails =
        ImmutableSurveyInstanceFormDetails.builder().build();

    // Assert
    assertTrue(actualImmutableSurveyInstanceFormDetails.activeQuestions().isEmpty());
    assertTrue(actualImmutableSurveyInstanceFormDetails.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceFormDetails)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then return build missingMandatoryQuestionIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceFormDetails)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyInstanceFormDetails); given zero; then return build missingMandatoryQuestionIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceFormDetails)"})
  void testBuilderFrom_givenZero_thenReturnBuildMissingMandatoryQuestionIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    Builder builderResult2 = ImmutableSurveyInstanceFormDetails.builder();
    builderResult2.addMissingMandatoryQuestionIds(0L);

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
    builderResult2.addActiveQuestions(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    ImmutableSurveyInstanceFormDetails instance = builderResult2.build();

    // Act and Assert
    ImmutableSurveyInstanceFormDetails immutableSurveyInstanceFormDetails =
        builderResult.from(instance).build();
    List<SurveyQuestion> activeQuestionsResult =
        immutableSurveyInstanceFormDetails.activeQuestions();
    assertEquals(1, activeQuestionsResult.size());
    SurveyQuestion getResult = activeQuestionsResult.get(0);
    assertTrue(getResult instanceof ImmutableSurveyQuestion);
    assertEquals("Question Text", getResult.questionText());
    assertEquals(1, getResult.position().intValue());
    Set<Long> missingMandatoryQuestionIdsResult =
        immutableSurveyInstanceFormDetails.missingMandatoryQuestionIds();
    assertEquals(1, missingMandatoryQuestionIdsResult.size());
    assertEquals(1L, getResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, getResult.fieldType());
    assertFalse(getResult.isMandatory());
    assertTrue(missingMandatoryQuestionIdsResult.contains(0L));
    assertTrue(getResult.allowComment());
    ImmutableSurveyInstanceFormDetails actualImmutableSurveyInstanceFormDetails =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceFormDetails);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceFormDetails)}.
   *
   * <ul>
   *   <li>Then return build missingMandatoryQuestionIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceFormDetails)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyInstanceFormDetails); then return build missingMandatoryQuestionIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceFormDetails)"})
  void testBuilderFrom_thenReturnBuildMissingMandatoryQuestionIdsEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    Builder builderResult2 = ImmutableSurveyInstanceFormDetails.builder();

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
    builderResult2.addActiveQuestions(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    ImmutableSurveyInstanceFormDetails instance = builderResult2.build();

    // Act and Assert
    ImmutableSurveyInstanceFormDetails immutableSurveyInstanceFormDetails =
        builderResult.from(instance).build();
    List<SurveyQuestion> activeQuestionsResult =
        immutableSurveyInstanceFormDetails.activeQuestions();
    assertEquals(1, activeQuestionsResult.size());
    SurveyQuestion getResult = activeQuestionsResult.get(0);
    assertTrue(getResult instanceof ImmutableSurveyQuestion);
    assertEquals("Question Text", getResult.questionText());
    assertEquals(1, getResult.position().intValue());
    assertEquals(1L, getResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, getResult.fieldType());
    assertFalse(getResult.isMandatory());
    assertTrue(immutableSurveyInstanceFormDetails.missingMandatoryQuestionIds().isEmpty());
    assertTrue(getResult.allowComment());
    ImmutableSurveyInstanceFormDetails actualImmutableSurveyInstanceFormDetails =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceFormDetails);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceFormDetails)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyInstanceFormDetails)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyInstanceFormDetails); when builder build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceFormDetails)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();
    ImmutableSurveyInstanceFormDetails instance =
        ImmutableSurveyInstanceFormDetails.builder().build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyInstanceFormDetails actualImmutableSurveyInstanceFormDetails =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceFormDetails);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#missingMandatoryQuestionIds(Iterable)}.
   *
   * <p>Method under test: {@link Builder#missingMandatoryQuestionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder missingMandatoryQuestionIds(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.missingMandatoryQuestionIds(Iterable)"})
  void testBuilderMissingMandatoryQuestionIds() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualMissingMandatoryQuestionIdsResult =
        builderResult.missingMandatoryQuestionIds(elements);

    // Assert
    assertEquals(elements, builderResult.build().missingMandatoryQuestionIds());
    assertSame(builderResult, actualMissingMandatoryQuestionIdsResult);
  }

  /**
   * Test Builder {@link Builder#missingMandatoryQuestionIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#missingMandatoryQuestionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder missingMandatoryQuestionIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.missingMandatoryQuestionIds(Iterable)"})
  void testBuilderMissingMandatoryQuestionIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act
    Builder actualMissingMandatoryQuestionIdsResult =
        builderResult.missingMandatoryQuestionIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualMissingMandatoryQuestionIdsResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#copyOf(SurveyInstanceFormDetails)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return activeQuestions Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceFormDetails#copyOf(SurveyInstanceFormDetails)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyInstanceFormDetails); when builder build; then return activeQuestions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.copyOf(SurveyInstanceFormDetails)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnActiveQuestionsEmpty() {
    // Arrange
    ImmutableSurveyInstanceFormDetails instance =
        ImmutableSurveyInstanceFormDetails.builder().build();

    // Act
    ImmutableSurveyInstanceFormDetails actualCopyOfResult =
        ImmutableSurveyInstanceFormDetails.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.activeQuestions().isEmpty());
    assertTrue(actualCopyOfResult.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#equals(Object)}, and {@link
   * ImmutableSurveyInstanceFormDetails#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceFormDetails#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceFormDetails#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceFormDetails.equals(Object)",
    "int ImmutableSurveyInstanceFormDetails.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceFormDetails immutableSurveyInstanceFormDetails =
        ImmutableSurveyInstanceFormDetails.builder().build();
    ImmutableSurveyInstanceFormDetails immutableSurveyInstanceFormDetails2 =
        ImmutableSurveyInstanceFormDetails.builder().build();

    // Act and Assert
    assertEquals(immutableSurveyInstanceFormDetails, immutableSurveyInstanceFormDetails2);
    assertEquals(
        immutableSurveyInstanceFormDetails.hashCode(),
        immutableSurveyInstanceFormDetails2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#equals(Object)}, and {@link
   * ImmutableSurveyInstanceFormDetails#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceFormDetails#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceFormDetails#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceFormDetails.equals(Object)",
    "int ImmutableSurveyInstanceFormDetails.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceFormDetails immutableSurveyInstanceFormDetails =
        ImmutableSurveyInstanceFormDetails.builder().build();

    // Act and Assert
    assertEquals(immutableSurveyInstanceFormDetails, immutableSurveyInstanceFormDetails);
    int expectedHashCodeResult = immutableSurveyInstanceFormDetails.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyInstanceFormDetails.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceFormDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceFormDetails.equals(Object)",
    "int ImmutableSurveyInstanceFormDetails.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

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
    builderResult.addActiveQuestions(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableSurveyInstanceFormDetails.builder().build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceFormDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceFormDetails.equals(Object)",
    "int ImmutableSurveyInstanceFormDetails.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();
    builderResult.addMissingMandatoryQuestionIds(1L);

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableSurveyInstanceFormDetails.builder().build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceFormDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceFormDetails.equals(Object)",
    "int ImmutableSurveyInstanceFormDetails.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableSurveyInstanceFormDetails.builder().build(), null);
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceFormDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceFormDetails.equals(Object)",
    "int ImmutableSurveyInstanceFormDetails.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyInstanceFormDetails.builder().build(),
        "Different type to ImmutableSurveyInstanceFormDetails");
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableSurveyQuestion.Json} (default
   *       constructor).
   *   <li>Then return activeQuestions size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return activeQuestions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_thenReturnActiveQuestionsSizeIsOne() {
    // Arrange
    ArrayList<SurveyQuestion> activeQuestions = new ArrayList<>();
    ImmutableSurveyQuestion.Json json = new ImmutableSurveyQuestion.Json();
    activeQuestions.add(json);

    LinkedHashSet<Long> missingMandatoryQuestionIds = new LinkedHashSet<>();
    missingMandatoryQuestionIds.add(1L);

    Json json2 = new Json();
    json2.setActiveQuestions(activeQuestions);
    json2.setMissingMandatoryQuestionIds(missingMandatoryQuestionIds);

    // Act
    ImmutableSurveyInstanceFormDetails actualFromJsonResult =
        ImmutableSurveyInstanceFormDetails.fromJson(json2);

    // Assert
    List<SurveyQuestion> activeQuestionsResult = actualFromJsonResult.activeQuestions();
    assertEquals(1, activeQuestionsResult.size());
    assertSame(json, activeQuestionsResult.get(0));
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return activeQuestions size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return activeQuestions size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.fromJson(Json)"
  })
  void testFromJson_thenReturnActiveQuestionsSizeIsTwo() {
    // Arrange
    ArrayList<SurveyQuestion> activeQuestions = new ArrayList<>();

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
    activeQuestions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    ImmutableSurveyQuestion.Json json = new ImmutableSurveyQuestion.Json();
    activeQuestions.add(json);

    LinkedHashSet<Long> missingMandatoryQuestionIds = new LinkedHashSet<>();
    missingMandatoryQuestionIds.add(1L);

    Json json2 = new Json();
    json2.setActiveQuestions(activeQuestions);
    json2.setMissingMandatoryQuestionIds(missingMandatoryQuestionIds);

    // Act
    ImmutableSurveyInstanceFormDetails actualFromJsonResult =
        ImmutableSurveyInstanceFormDetails.fromJson(json2);

    // Assert
    List<SurveyQuestion> activeQuestionsResult = actualFromJsonResult.activeQuestions();
    assertEquals(2, activeQuestionsResult.size());
    assertTrue(activeQuestionsResult.get(0) instanceof ImmutableSurveyQuestion);
    SurveyQuestion getResult = activeQuestionsResult.get(1);
    assertTrue(getResult instanceof ImmutableSurveyQuestion.Json);
    assertSame(json, getResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return missingMandatoryQuestionIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return missingMandatoryQuestionIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.fromJson(Json)"
  })
  void testFromJson_thenReturnMissingMandatoryQuestionIdsSizeIsOne() {
    // Arrange
    LinkedHashSet<Long> missingMandatoryQuestionIds = new LinkedHashSet<>();
    missingMandatoryQuestionIds.add(1L);

    Json json = new Json();
    json.setActiveQuestions(null);
    json.setMissingMandatoryQuestionIds(missingMandatoryQuestionIds);

    // Act
    ImmutableSurveyInstanceFormDetails actualFromJsonResult =
        ImmutableSurveyInstanceFormDetails.fromJson(json);

    // Assert
    Set<Long> missingMandatoryQuestionIdsResult =
        actualFromJsonResult.missingMandatoryQuestionIds();
    assertEquals(1, missingMandatoryQuestionIdsResult.size());
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return missingMandatoryQuestionIds size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return missingMandatoryQuestionIds size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.fromJson(Json)"
  })
  void testFromJson_thenReturnMissingMandatoryQuestionIdsSizeIsTwo() {
    // Arrange
    ArrayList<SurveyQuestion> activeQuestions = new ArrayList<>();

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
    activeQuestions.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());
    ImmutableSurveyQuestion.Json json = new ImmutableSurveyQuestion.Json();
    activeQuestions.add(json);

    LinkedHashSet<Long> missingMandatoryQuestionIds = new LinkedHashSet<>();
    missingMandatoryQuestionIds.add(0L);
    missingMandatoryQuestionIds.add(1L);

    Json json2 = new Json();
    json2.setActiveQuestions(activeQuestions);
    json2.setMissingMandatoryQuestionIds(missingMandatoryQuestionIds);

    // Act
    ImmutableSurveyInstanceFormDetails actualFromJsonResult =
        ImmutableSurveyInstanceFormDetails.fromJson(json2);

    // Assert
    List<SurveyQuestion> activeQuestionsResult = actualFromJsonResult.activeQuestions();
    assertEquals(2, activeQuestionsResult.size());
    assertTrue(activeQuestionsResult.get(0) instanceof ImmutableSurveyQuestion);
    SurveyQuestion getResult = activeQuestionsResult.get(1);
    assertTrue(getResult instanceof ImmutableSurveyQuestion.Json);
    Set<Long> missingMandatoryQuestionIdsResult =
        actualFromJsonResult.missingMandatoryQuestionIds();
    assertEquals(2, missingMandatoryQuestionIdsResult.size());
    assertTrue(missingMandatoryQuestionIdsResult.contains(0L));
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
    assertSame(json, getResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) MissingMandatoryQuestionIds is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) MissingMandatoryQuestionIds is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.fromJson(Json)"
  })
  void testFromJson_whenJsonMissingMandatoryQuestionIdsIsNull() {
    // Arrange
    ArrayList<SurveyQuestion> activeQuestions = new ArrayList<>();
    ImmutableSurveyQuestion.Json json = new ImmutableSurveyQuestion.Json();
    activeQuestions.add(json);

    Json json2 = new Json();
    json2.setActiveQuestions(activeQuestions);
    json2.setMissingMandatoryQuestionIds(null);

    // Act
    ImmutableSurveyInstanceFormDetails actualFromJsonResult =
        ImmutableSurveyInstanceFormDetails.fromJson(json2);

    // Assert
    List<SurveyQuestion> activeQuestionsResult = actualFromJsonResult.activeQuestions();
    assertEquals(1, activeQuestionsResult.size());
    assertTrue(actualFromJsonResult.missingMandatoryQuestionIds().isEmpty());
    assertSame(json, activeQuestionsResult.get(0));
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return activeQuestions Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return activeQuestions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnActiveQuestionsEmpty() {
    // Arrange and Act
    ImmutableSurveyInstanceFormDetails actualFromJsonResult =
        ImmutableSurveyInstanceFormDetails.fromJson(new Json());

    // Assert
    assertTrue(actualFromJsonResult.activeQuestions().isEmpty());
    assertTrue(actualFromJsonResult.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceFormDetails#toString()}
   *   <li>{@link ImmutableSurveyInstanceFormDetails#activeQuestions()}
   *   <li>{@link ImmutableSurveyInstanceFormDetails#missingMandatoryQuestionIds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableSurveyInstanceFormDetails.activeQuestions()",
    "Set ImmutableSurveyInstanceFormDetails.missingMandatoryQuestionIds()",
    "String ImmutableSurveyInstanceFormDetails.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyInstanceFormDetails immutableSurveyInstanceFormDetails =
        ImmutableSurveyInstanceFormDetails.builder().build();

    // Act
    String actualToStringResult = immutableSurveyInstanceFormDetails.toString();
    List<SurveyQuestion> actualActiveQuestionsResult =
        immutableSurveyInstanceFormDetails.activeQuestions();
    Set<Long> actualMissingMandatoryQuestionIdsResult =
        immutableSurveyInstanceFormDetails.missingMandatoryQuestionIds();

    // Assert
    assertEquals(
        "SurveyInstanceFormDetails{activeQuestions=[], missingMandatoryQuestionIds=[]}",
        actualToStringResult);
    assertTrue(actualActiveQuestionsResult.isEmpty());
    assertTrue(actualMissingMandatoryQuestionIdsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#activeQuestions()}.
   *
   * <p>Method under test: {@link Json#activeQuestions()}
   */
  @Test
  @DisplayName("Test Json activeQuestions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.activeQuestions()"})
  void testJsonActiveQuestions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().activeQuestions());
  }

  /**
   * Test Json {@link Json#missingMandatoryQuestionIds()}.
   *
   * <p>Method under test: {@link Json#missingMandatoryQuestionIds()}
   */
  @Test
  @DisplayName("Test Json missingMandatoryQuestionIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.missingMandatoryQuestionIds()"})
  void testJsonMissingMandatoryQuestionIds() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().missingMandatoryQuestionIds());
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
    assertTrue(actualJson.activeQuestions.isEmpty());
    assertTrue(actualJson.missingMandatoryQuestionIds.isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#withActiveQuestions(SurveyQuestion[])} with
   * {@code SurveyQuestion[]}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceFormDetails#withActiveQuestions(SurveyQuestion[])}
   */
  @Test
  @DisplayName("Test withActiveQuestions(SurveyQuestion[]) with 'SurveyQuestion[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.withActiveQuestions(SurveyQuestion[])"
  })
  void testWithActiveQuestionsWithSurveyQuestion() {
    // Arrange
    ImmutableSurveyInstanceFormDetails immutableSurveyInstanceFormDetails =
        ImmutableSurveyInstanceFormDetails.builder().build();

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

    // Act
    ImmutableSurveyInstanceFormDetails actualWithActiveQuestionsResult =
        immutableSurveyInstanceFormDetails.withActiveQuestions(
            positionResult
                .qualifierEntity(qualifierEntity)
                .questionText("Question Text")
                .sectionName("Section Name")
                .surveyTemplateId(1L)
                .build());

    // Assert
    List<SurveyQuestion> activeQuestionsResult = actualWithActiveQuestionsResult.activeQuestions();
    assertEquals(1, activeQuestionsResult.size());
    SurveyQuestion getResult = activeQuestionsResult.get(0);
    assertTrue(getResult instanceof ImmutableSurveyQuestion);
    assertEquals("Question Text", getResult.questionText());
    assertEquals(1, getResult.position().intValue());
    assertEquals(1L, getResult.surveyTemplateId().longValue());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(SurveyQuestionFieldType.APPLICATION, getResult.fieldType());
    assertFalse(getResult.isMandatory());
    assertTrue(actualWithActiveQuestionsResult.missingMandatoryQuestionIds().isEmpty());
    assertTrue(getResult.allowComment());
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#withMissingMandatoryQuestionIds(Iterable)} with
   * {@code Iterable}.
   *
   * <ul>
   *   <li>Then return activeQuestions Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceFormDetails#withMissingMandatoryQuestionIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withMissingMandatoryQuestionIds(Iterable) with 'Iterable'; then return activeQuestions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.withMissingMandatoryQuestionIds(Iterable)"
  })
  void testWithMissingMandatoryQuestionIdsWithIterable_thenReturnActiveQuestionsEmpty() {
    // Arrange
    ImmutableSurveyInstanceFormDetails immutableSurveyInstanceFormDetails =
        ImmutableSurveyInstanceFormDetails.builder().build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSurveyInstanceFormDetails actualWithMissingMandatoryQuestionIdsResult =
        immutableSurveyInstanceFormDetails.withMissingMandatoryQuestionIds(elements);

    // Assert
    assertTrue(actualWithMissingMandatoryQuestionIdsResult.activeQuestions().isEmpty());
    assertEquals(
        elements, actualWithMissingMandatoryQuestionIdsResult.missingMandatoryQuestionIds());
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#withMissingMandatoryQuestionIds(long[])} with
   * {@code long[]}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceFormDetails#withMissingMandatoryQuestionIds(long[])}
   */
  @Test
  @DisplayName("Test withMissingMandatoryQuestionIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.withMissingMandatoryQuestionIds(long[])"
  })
  void testWithMissingMandatoryQuestionIdsWithLong() {
    // Arrange and Act
    ImmutableSurveyInstanceFormDetails actualWithMissingMandatoryQuestionIdsResult =
        ImmutableSurveyInstanceFormDetails.builder()
            .build()
            .withMissingMandatoryQuestionIds(1L, -1L, 1L, -1L);

    // Assert
    Set<Long> missingMandatoryQuestionIdsResult =
        actualWithMissingMandatoryQuestionIdsResult.missingMandatoryQuestionIds();
    assertEquals(2, missingMandatoryQuestionIdsResult.size());
    assertTrue(actualWithMissingMandatoryQuestionIdsResult.activeQuestions().isEmpty());
    assertTrue(missingMandatoryQuestionIdsResult.contains(-1L));
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
  }
}
