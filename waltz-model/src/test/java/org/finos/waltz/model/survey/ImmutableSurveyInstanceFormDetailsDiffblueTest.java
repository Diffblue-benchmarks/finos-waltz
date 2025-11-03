package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceFormDetails.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceFormDetails.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceFormDetailsDiffblueTest {
  /**
   * Test Builder {@link Builder#activeQuestions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#activeQuestions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder activeQuestions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.activeQuestions(Iterable)"})
  void testBuilderActiveQuestions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.activeQuestions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addActiveQuestions(SurveyQuestion)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addActiveQuestions(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test Builder addActiveQuestions(SurveyQuestion) with 'element'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Builder#addActiveQuestions(SurveyQuestion[])}
   */
  @Test
  @DisplayName("Test Builder addActiveQuestions(SurveyQuestion[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllActiveQuestions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllActiveQuestions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllActiveQuestions(Iterable)"})
  void testBuilderAddAllActiveQuestions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllActiveQuestions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllMissingMandatoryQuestionIds(Iterable)}.
   * <p>
   * Method under test: {@link Builder#addAllMissingMandatoryQuestionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllMissingMandatoryQuestionIds(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllMissingMandatoryQuestionIds(Iterable)"})
  void testBuilderAddAllMissingMandatoryQuestionIds() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllMissingMandatoryQuestionIdsResult = builderResult.addAllMissingMandatoryQuestionIds(elements);

    // Assert
    assertEquals(elements, builderResult.build().missingMandatoryQuestionIds());
    assertSame(builderResult, actualAddAllMissingMandatoryQuestionIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllMissingMandatoryQuestionIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllMissingMandatoryQuestionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllMissingMandatoryQuestionIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllMissingMandatoryQuestionIds(Iterable)"})
  void testBuilderAddAllMissingMandatoryQuestionIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllMissingMandatoryQuestionIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addMissingMandatoryQuestionIds(long)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addMissingMandatoryQuestionIds(long)}
   */
  @Test
  @DisplayName("Test Builder addMissingMandatoryQuestionIds(long) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMissingMandatoryQuestionIds(long)"})
  void testBuilderAddMissingMandatoryQuestionIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act
    Builder actualAddMissingMandatoryQuestionIdsResult = builderResult.addMissingMandatoryQuestionIds(1L);

    // Assert
    Set<Long> missingMandatoryQuestionIdsResult = builderResult.build().missingMandatoryQuestionIds();
    assertEquals(1, missingMandatoryQuestionIdsResult.size());
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
    assertSame(builderResult, actualAddMissingMandatoryQuestionIdsResult);
  }

  /**
   * Test Builder {@link Builder#addMissingMandatoryQuestionIds(long[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addMissingMandatoryQuestionIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addMissingMandatoryQuestionIds(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMissingMandatoryQuestionIds(long[])"})
  void testBuilderAddMissingMandatoryQuestionIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act
    Builder actualAddMissingMandatoryQuestionIdsResult = builderResult.addMissingMandatoryQuestionIds(1L, -1L, 1L, -1L);

    // Assert
    Set<Long> missingMandatoryQuestionIdsResult = builderResult.build().missingMandatoryQuestionIds();
    assertEquals(2, missingMandatoryQuestionIdsResult.size());
    assertTrue(missingMandatoryQuestionIdsResult.contains(-1L));
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
    assertSame(builderResult, actualAddMissingMandatoryQuestionIdsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstanceFormDetails Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSurveyInstanceFormDetails actualBuildResult = ImmutableSurveyInstanceFormDetails.builder().build();

    // Assert
    assertTrue(actualBuildResult.activeQuestions().isEmpty());
    assertTrue(actualBuildResult.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceFormDetails)}.
   * <ul>
   *   <li>Given {@link ImmutableSurveyQuestion.Json} (default constructor).</li>
   *   <li>Then return build missingMandatoryQuestionIds Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceFormDetails)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceFormDetails); given Json (default constructor); then return build missingMandatoryQuestionIds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceFormDetails)"})
  void testBuilderFrom_givenJson_thenReturnBuildMissingMandatoryQuestionIdsEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();
    Builder builderResult2 = ImmutableSurveyInstanceFormDetails.builder();
    ImmutableSurveyQuestion.Json element = new ImmutableSurveyQuestion.Json();
    builderResult2.addActiveQuestions(element);
    ImmutableSurveyInstanceFormDetails instance = builderResult2.build();

    // Act and Assert
    ImmutableSurveyInstanceFormDetails buildResult = builderResult.from(instance).build();
    List<SurveyQuestion> activeQuestionsResult = buildResult.activeQuestions();
    assertEquals(1, activeQuestionsResult.size());
    SurveyQuestion getResult = activeQuestionsResult.get(0);
    assertTrue(getResult instanceof ImmutableSurveyQuestion.Json);
    assertTrue(buildResult.missingMandatoryQuestionIds().isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(element, getResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceFormDetails)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>Then return build missingMandatoryQuestionIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceFormDetails)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceFormDetails); given zero; then return build missingMandatoryQuestionIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceFormDetails)"})
  void testBuilderFrom_givenZero_thenReturnBuildMissingMandatoryQuestionIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();
    Builder builderResult2 = ImmutableSurveyInstanceFormDetails.builder();
    builderResult2.addMissingMandatoryQuestionIds(0L);
    ImmutableSurveyQuestion.Json element = new ImmutableSurveyQuestion.Json();
    builderResult2.addActiveQuestions(element);
    ImmutableSurveyInstanceFormDetails instance = builderResult2.build();

    // Act and Assert
    ImmutableSurveyInstanceFormDetails buildResult = builderResult.from(instance).build();
    List<SurveyQuestion> activeQuestionsResult = buildResult.activeQuestions();
    assertEquals(1, activeQuestionsResult.size());
    SurveyQuestion getResult = activeQuestionsResult.get(0);
    assertTrue(getResult instanceof ImmutableSurveyQuestion.Json);
    Set<Long> missingMandatoryQuestionIdsResult = buildResult.missingMandatoryQuestionIds();
    assertEquals(1, missingMandatoryQuestionIdsResult.size());
    assertTrue(missingMandatoryQuestionIdsResult.contains(0L));
    assertEquals(instance, builderResult.build());
    assertSame(element, getResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceFormDetails)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceFormDetails)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceFormDetails); when builder build; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceFormDetails)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();
    ImmutableSurveyInstanceFormDetails instance = ImmutableSurveyInstanceFormDetails.builder().build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#missingMandatoryQuestionIds(Iterable)}.
   * <p>
   * Method under test: {@link Builder#missingMandatoryQuestionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder missingMandatoryQuestionIds(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.missingMandatoryQuestionIds(Iterable)"})
  void testBuilderMissingMandatoryQuestionIds() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualMissingMandatoryQuestionIdsResult = builderResult.missingMandatoryQuestionIds(elements);

    // Assert
    assertEquals(elements, builderResult.build().missingMandatoryQuestionIds());
    assertSame(builderResult, actualMissingMandatoryQuestionIdsResult);
  }

  /**
   * Test Builder {@link Builder#missingMandatoryQuestionIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#missingMandatoryQuestionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder missingMandatoryQuestionIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.missingMandatoryQuestionIds(Iterable)"})
  void testBuilderMissingMandatoryQuestionIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.missingMandatoryQuestionIds(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#copyOf(SurveyInstanceFormDetails)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return activeQuestions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceFormDetails#copyOf(SurveyInstanceFormDetails)}
   */
  @Test
  @DisplayName("Test copyOf(SurveyInstanceFormDetails); when builder build; then return activeQuestions Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.copyOf(SurveyInstanceFormDetails)"})
  void testCopyOf_whenBuilderBuild_thenReturnActiveQuestionsEmpty() {
    // Arrange
    ImmutableSurveyInstanceFormDetails instance = ImmutableSurveyInstanceFormDetails.builder().build();

    // Act
    ImmutableSurveyInstanceFormDetails actualCopyOfResult = ImmutableSurveyInstanceFormDetails.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.activeQuestions().isEmpty());
    assertTrue(actualCopyOfResult.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#equals(Object)}, and {@link ImmutableSurveyInstanceFormDetails#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceFormDetails#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceFormDetails#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceFormDetails.equals(Object)",
      "int ImmutableSurveyInstanceFormDetails.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceFormDetails buildResult = ImmutableSurveyInstanceFormDetails.builder().build();
    ImmutableSurveyInstanceFormDetails buildResult2 = ImmutableSurveyInstanceFormDetails.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#equals(Object)}, and {@link ImmutableSurveyInstanceFormDetails#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceFormDetails#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceFormDetails#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceFormDetails.equals(Object)",
      "int ImmutableSurveyInstanceFormDetails.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceFormDetails buildResult = ImmutableSurveyInstanceFormDetails.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceFormDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceFormDetails.equals(Object)",
      "int ImmutableSurveyInstanceFormDetails.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();
    builderResult.addActiveQuestions(new ImmutableSurveyQuestion.Json());
    ImmutableSurveyInstanceFormDetails buildResult = builderResult.build();
    ImmutableSurveyInstanceFormDetails buildResult2 = ImmutableSurveyInstanceFormDetails.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceFormDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceFormDetails.equals(Object)",
      "int ImmutableSurveyInstanceFormDetails.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();
    builderResult.addMissingMandatoryQuestionIds(1L);
    ImmutableSurveyInstanceFormDetails buildResult = builderResult.build();
    ImmutableSurveyInstanceFormDetails buildResult2 = ImmutableSurveyInstanceFormDetails.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceFormDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceFormDetails.equals(Object)",
      "int ImmutableSurveyInstanceFormDetails.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyInstanceFormDetails buildResult = ImmutableSurveyInstanceFormDetails.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceFormDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSurveyInstanceFormDetails.equals(Object)",
      "int ImmutableSurveyInstanceFormDetails.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyInstanceFormDetails buildResult = ImmutableSurveyInstanceFormDetails.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableSurveyInstanceFormDetails");
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableSurveyQuestion.Json} (default constructor).</li>
   *   <li>Then return activeQuestions is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return activeQuestions is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnActiveQuestionsIsArrayList() {
    // Arrange
    ArrayList<SurveyQuestion> activeQuestions = new ArrayList<>();
    activeQuestions.add(new ImmutableSurveyQuestion.Json());

    Json json = new Json();
    json.setActiveQuestions(activeQuestions);
    json.setMissingMandatoryQuestionIds(null);

    // Act and Assert
    assertEquals(activeQuestions, ImmutableSurveyInstanceFormDetails.fromJson(json).activeQuestions());
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableSurveyQuestion.Json} (default constructor).</li>
   *   <li>Then return activeQuestions size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return activeQuestions size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnActiveQuestionsSizeIsTwo() {
    // Arrange
    ArrayList<SurveyQuestion> activeQuestions = new ArrayList<>();
    activeQuestions.add(new ImmutableSurveyQuestion.Json());
    ImmutableSurveyQuestion.Json json = new ImmutableSurveyQuestion.Json();
    activeQuestions.add(json);

    Json json2 = new Json();
    json2.setActiveQuestions(activeQuestions);
    json2.setMissingMandatoryQuestionIds(null);

    // Act and Assert
    List<SurveyQuestion> activeQuestionsResult = ImmutableSurveyInstanceFormDetails.fromJson(json2).activeQuestions();
    assertEquals(2, activeQuestionsResult.size());
    assertSame(json, activeQuestionsResult.get(1));
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}.
   * <ul>
   *   <li>Then return missingMandatoryQuestionIds is {@link LinkedHashSet#LinkedHashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return missingMandatoryQuestionIds is LinkedHashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.fromJson(Json)"})
  void testFromJson_thenReturnMissingMandatoryQuestionIdsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<Long> missingMandatoryQuestionIds = new LinkedHashSet<>();
    missingMandatoryQuestionIds.add(-1L);
    missingMandatoryQuestionIds.add(1L);

    Json json = new Json();
    json.setActiveQuestions(null);
    json.setMissingMandatoryQuestionIds(missingMandatoryQuestionIds);

    // Act and Assert
    assertEquals(missingMandatoryQuestionIds,
        ImmutableSurveyInstanceFormDetails.fromJson(json).missingMandatoryQuestionIds());
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}.
   * <ul>
   *   <li>Then return missingMandatoryQuestionIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return missingMandatoryQuestionIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.fromJson(Json)"})
  void testFromJson_thenReturnMissingMandatoryQuestionIdsSizeIsOne() {
    // Arrange
    LinkedHashSet<Long> missingMandatoryQuestionIds = new LinkedHashSet<>();
    missingMandatoryQuestionIds.add(1L);

    Json json = new Json();
    json.setActiveQuestions(null);
    json.setMissingMandatoryQuestionIds(missingMandatoryQuestionIds);

    // Act and Assert
    Set<Long> missingMandatoryQuestionIdsResult = ImmutableSurveyInstanceFormDetails.fromJson(json)
        .missingMandatoryQuestionIds();
    assertEquals(1, missingMandatoryQuestionIdsResult.size());
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor) ActiveQuestions is {@code null}.</li>
   *   <li>Then return activeQuestions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor) ActiveQuestions is 'null'; then return activeQuestions Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.fromJson(Json)"})
  void testFromJson_whenJsonActiveQuestionsIsNull_thenReturnActiveQuestionsEmpty() {
    // Arrange
    Json json = new Json();
    json.setActiveQuestions(null);
    json.setMissingMandatoryQuestionIds(null);

    // Act
    ImmutableSurveyInstanceFormDetails actualFromJsonResult = ImmutableSurveyInstanceFormDetails.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.activeQuestions().isEmpty());
    assertTrue(actualFromJsonResult.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return activeQuestions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceFormDetails#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return activeQuestions Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnActiveQuestionsEmpty() {
    // Arrange and Act
    ImmutableSurveyInstanceFormDetails actualFromJsonResult = ImmutableSurveyInstanceFormDetails.fromJson(new Json());

    // Assert
    assertTrue(actualFromJsonResult.activeQuestions().isEmpty());
    assertTrue(actualFromJsonResult.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceFormDetails#toString()}
   *   <li>{@link ImmutableSurveyInstanceFormDetails#activeQuestions()}
   *   <li>{@link ImmutableSurveyInstanceFormDetails#missingMandatoryQuestionIds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableSurveyInstanceFormDetails.activeQuestions()",
      "Set ImmutableSurveyInstanceFormDetails.missingMandatoryQuestionIds()",
      "String ImmutableSurveyInstanceFormDetails.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyInstanceFormDetails buildResult = ImmutableSurveyInstanceFormDetails.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    List<SurveyQuestion> actualActiveQuestionsResult = buildResult.activeQuestions();
    Set<Long> actualMissingMandatoryQuestionIdsResult = buildResult.missingMandatoryQuestionIds();

    // Assert
    assertEquals("SurveyInstanceFormDetails{activeQuestions=[], missingMandatoryQuestionIds=[]}", actualToStringResult);
    assertTrue(actualActiveQuestionsResult.isEmpty());
    assertTrue(actualMissingMandatoryQuestionIdsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#activeQuestions()}.
   * <p>
   * Method under test: {@link Json#activeQuestions()}
   */
  @Test
  @DisplayName("Test Json activeQuestions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.activeQuestions()"})
  void testJsonActiveQuestions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).activeQuestions());
  }

  /**
   * Test Json {@link Json#missingMandatoryQuestionIds()}.
   * <p>
   * Method under test: {@link Json#missingMandatoryQuestionIds()}
   */
  @Test
  @DisplayName("Test Json missingMandatoryQuestionIds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.missingMandatoryQuestionIds()"})
  void testJsonMissingMandatoryQuestionIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).missingMandatoryQuestionIds());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertTrue(actualJson.activeQuestions.isEmpty());
    assertTrue(actualJson.missingMandatoryQuestionIds.isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#withActiveQuestions(SurveyQuestion[])} with {@code SurveyQuestion[]}.
   * <ul>
   *   <li>Then return activeQuestions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceFormDetails#withActiveQuestions(SurveyQuestion[])}
   */
  @Test
  @DisplayName("Test withActiveQuestions(SurveyQuestion[]) with 'SurveyQuestion[]'; then return activeQuestions size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.withActiveQuestions(SurveyQuestion[])"})
  void testWithActiveQuestionsWithSurveyQuestion_thenReturnActiveQuestionsSizeIsOne() {
    // Arrange
    ImmutableSurveyInstanceFormDetails buildResult = ImmutableSurveyInstanceFormDetails.builder().build();
    ImmutableSurveyQuestion.Json json = new ImmutableSurveyQuestion.Json();

    // Act
    ImmutableSurveyInstanceFormDetails actualWithActiveQuestionsResult = buildResult.withActiveQuestions(json);

    // Assert
    List<SurveyQuestion> activeQuestionsResult = actualWithActiveQuestionsResult.activeQuestions();
    assertEquals(1, activeQuestionsResult.size());
    assertTrue(actualWithActiveQuestionsResult.missingMandatoryQuestionIds().isEmpty());
    assertSame(json, activeQuestionsResult.get(0));
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#withMissingMandatoryQuestionIds(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then return activeQuestions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceFormDetails#withMissingMandatoryQuestionIds(Iterable)}
   */
  @Test
  @DisplayName("Test withMissingMandatoryQuestionIds(Iterable) with 'Iterable'; then return activeQuestions Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.withMissingMandatoryQuestionIds(Iterable)"})
  void testWithMissingMandatoryQuestionIdsWithIterable_thenReturnActiveQuestionsEmpty() {
    // Arrange
    ImmutableSurveyInstanceFormDetails buildResult = ImmutableSurveyInstanceFormDetails.builder().build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSurveyInstanceFormDetails actualWithMissingMandatoryQuestionIdsResult = buildResult
        .withMissingMandatoryQuestionIds(elements);

    // Assert
    assertTrue(actualWithMissingMandatoryQuestionIdsResult.activeQuestions().isEmpty());
    assertEquals(elements, actualWithMissingMandatoryQuestionIdsResult.missingMandatoryQuestionIds());
  }

  /**
   * Test {@link ImmutableSurveyInstanceFormDetails#withMissingMandatoryQuestionIds(long[])} with {@code long[]}.
   * <p>
   * Method under test: {@link ImmutableSurveyInstanceFormDetails#withMissingMandatoryQuestionIds(long[])}
   */
  @Test
  @DisplayName("Test withMissingMandatoryQuestionIds(long[]) with 'long[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableSurveyInstanceFormDetails ImmutableSurveyInstanceFormDetails.withMissingMandatoryQuestionIds(long[])"})
  void testWithMissingMandatoryQuestionIdsWithLong() {
    // Arrange
    ImmutableSurveyInstanceFormDetails buildResult = ImmutableSurveyInstanceFormDetails.builder().build();

    // Act
    ImmutableSurveyInstanceFormDetails actualWithMissingMandatoryQuestionIdsResult = buildResult
        .withMissingMandatoryQuestionIds(1L, -1L, 1L, -1L);

    // Assert
    Set<Long> missingMandatoryQuestionIdsResult = actualWithMissingMandatoryQuestionIdsResult
        .missingMandatoryQuestionIds();
    assertEquals(2, missingMandatoryQuestionIdsResult.size());
    assertTrue(actualWithMissingMandatoryQuestionIdsResult.activeQuestions().isEmpty());
    assertTrue(missingMandatoryQuestionIdsResult.contains(-1L));
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
  }
}
