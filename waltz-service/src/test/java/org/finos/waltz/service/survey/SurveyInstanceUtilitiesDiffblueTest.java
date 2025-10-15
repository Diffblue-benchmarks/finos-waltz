package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
   *   <li>Given {@code BOOLEAN}.
   *   <li>When {@link SurveyQuestion} {@link SurveyQuestion#fieldType()} return {@code BOOLEAN}.
   *   <li>Then return {@link Optional#get()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceUtilities#getVal(SurveyQuestion,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName(
      "Test getVal(SurveyQuestion, SurveyQuestionResponse); given 'BOOLEAN'; when SurveyQuestion fieldType() return 'BOOLEAN'; then return get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SurveyInstanceUtilities.getVal(SurveyQuestion, SurveyQuestionResponse)"
  })
  void testGetVal_givenBoolean_whenSurveyQuestionFieldTypeReturnBoolean_thenReturnGet() {
    // Arrange
    SurveyQuestion question = mock(SurveyQuestion.class);
    when(question.fieldType()).thenReturn(SurveyQuestionFieldType.BOOLEAN);

    SurveyQuestionResponse resp = mock(SurveyQuestionResponse.class);
    Optional<Boolean> ofResult = Optional.of(true);
    when(resp.booleanResponse()).thenReturn(ofResult);

    // Act
    Optional<?> actualVal = SurveyInstanceUtilities.getVal(question, resp);

    // Assert
    verify(question).fieldType();
    verify(resp).booleanResponse();
    assertTrue(actualVal.isPresent());
    assertTrue((Boolean) actualVal.get());
  }

  /**
   * Test {@link SurveyInstanceUtilities#getVal(SurveyQuestion, SurveyQuestionResponse)}.
   *
   * <ul>
   *   <li>Given {@code DATE}.
   *   <li>Then return {@link Optional#get()} toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceUtilities#getVal(SurveyQuestion,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName(
      "Test getVal(SurveyQuestion, SurveyQuestionResponse); given 'DATE'; then return get() toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SurveyInstanceUtilities.getVal(SurveyQuestion, SurveyQuestionResponse)"
  })
  void testGetVal_givenDate_thenReturnGetToStringIs19700101() {
    // Arrange
    SurveyQuestion question = mock(SurveyQuestion.class);
    when(question.fieldType()).thenReturn(SurveyQuestionFieldType.DATE);

    SurveyQuestionResponse resp = mock(SurveyQuestionResponse.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    Optional<LocalDate> ofResult2 = Optional.of(ofResult);
    when(resp.dateResponse()).thenReturn(ofResult2);

    // Act
    Optional<?> actualVal = SurveyInstanceUtilities.getVal(question, resp);

    // Assert
    verify(question).fieldType();
    verify(resp).dateResponse();
    Object getResult = actualVal.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(actualVal.isPresent());
    assertSame(ofResult, getResult);
  }

  /**
   * Test {@link SurveyInstanceUtilities#getVal(SurveyQuestion, SurveyQuestionResponse)}.
   *
   * <ul>
   *   <li>Given {@code DROPDOWN_MULTI_SELECT}.
   *   <li>Then calls {@link SurveyQuestionResponse#listResponse()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceUtilities#getVal(SurveyQuestion,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName(
      "Test getVal(SurveyQuestion, SurveyQuestionResponse); given 'DROPDOWN_MULTI_SELECT'; then calls listResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SurveyInstanceUtilities.getVal(SurveyQuestion, SurveyQuestionResponse)"
  })
  void testGetVal_givenDropdownMultiSelect_thenCallsListResponse() {
    // Arrange
    SurveyQuestion question = mock(SurveyQuestion.class);
    when(question.fieldType()).thenReturn(SurveyQuestionFieldType.DROPDOWN_MULTI_SELECT);

    SurveyQuestionResponse resp = mock(SurveyQuestionResponse.class);
    ArrayList<String> stringList = new ArrayList<>();
    Optional<List<String>> ofResult = Optional.of(stringList);
    when(resp.listResponse()).thenReturn(ofResult);

    // Act
    Optional<?> actualVal = SurveyInstanceUtilities.getVal(question, resp);

    // Assert
    verify(question).fieldType();
    verify(resp).listResponse();
    Object getResult = actualVal.get();
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(actualVal.isPresent());
    assertSame(stringList, getResult);
  }

  /**
   * Test {@link SurveyInstanceUtilities#getVal(SurveyQuestion, SurveyQuestionResponse)}.
   *
   * <ul>
   *   <li>Given {@code MEASURABLE_MULTI_SELECT}.
   *   <li>Then calls {@link SurveyQuestionResponse#entityListResponse()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceUtilities#getVal(SurveyQuestion,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName(
      "Test getVal(SurveyQuestion, SurveyQuestionResponse); given 'MEASURABLE_MULTI_SELECT'; then calls entityListResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SurveyInstanceUtilities.getVal(SurveyQuestion, SurveyQuestionResponse)"
  })
  void testGetVal_givenMeasurableMultiSelect_thenCallsEntityListResponse() {
    // Arrange
    SurveyQuestion question = mock(SurveyQuestion.class);
    when(question.fieldType()).thenReturn(SurveyQuestionFieldType.MEASURABLE_MULTI_SELECT);

    SurveyQuestionResponse resp = mock(SurveyQuestionResponse.class);
    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    Optional<List<EntityReference>> ofResult = Optional.of(entityReferenceList);
    when(resp.entityListResponse()).thenReturn(ofResult);

    // Act
    Optional<?> actualVal = SurveyInstanceUtilities.getVal(question, resp);

    // Assert
    verify(question).fieldType();
    verify(resp).entityListResponse();
    Object getResult = actualVal.get();
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(actualVal.isPresent());
    assertSame(entityReferenceList, getResult);
  }

  /**
   * Test {@link SurveyInstanceUtilities#getVal(SurveyQuestion, SurveyQuestionResponse)}.
   *
   * <ul>
   *   <li>Given {@code NUMBER}.
   *   <li>Then return {@link Optional#get()} doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceUtilities#getVal(SurveyQuestion,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName(
      "Test getVal(SurveyQuestion, SurveyQuestionResponse); given 'NUMBER'; then return get() doubleValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SurveyInstanceUtilities.getVal(SurveyQuestion, SurveyQuestionResponse)"
  })
  void testGetVal_givenNumber_thenReturnGetDoubleValueIsTen() {
    // Arrange
    SurveyQuestion question = mock(SurveyQuestion.class);
    when(question.fieldType()).thenReturn(SurveyQuestionFieldType.NUMBER);

    SurveyQuestionResponse resp = mock(SurveyQuestionResponse.class);
    Optional<Double> ofResult = Optional.of(10.0d);
    when(resp.numberResponse()).thenReturn(ofResult);

    // Act
    Optional<?> actualVal = SurveyInstanceUtilities.getVal(question, resp);

    // Assert
    verify(question).fieldType();
    verify(resp).numberResponse();
    assertEquals(10.0d, ((Double) actualVal.get()).doubleValue());
    assertTrue(actualVal.isPresent());
  }

  /**
   * Test {@link SurveyInstanceUtilities#getVal(SurveyQuestion, SurveyQuestionResponse)}.
   *
   * <ul>
   *   <li>Given {@code TEXT}.
   *   <li>When {@link SurveyQuestion} {@link SurveyQuestion#fieldType()} return {@code TEXT}.
   *   <li>Then return {@link Optional#get()} is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceUtilities#getVal(SurveyQuestion,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName(
      "Test getVal(SurveyQuestion, SurveyQuestionResponse); given 'TEXT'; when SurveyQuestion fieldType() return 'TEXT'; then return get() is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SurveyInstanceUtilities.getVal(SurveyQuestion, SurveyQuestionResponse)"
  })
  void testGetVal_givenText_whenSurveyQuestionFieldTypeReturnText_thenReturnGetIsFoo() {
    // Arrange
    SurveyQuestion question = mock(SurveyQuestion.class);
    when(question.fieldType()).thenReturn(SurveyQuestionFieldType.TEXT);

    SurveyQuestionResponse resp = mock(SurveyQuestionResponse.class);
    Optional<String> ofResult = Optional.of("foo");
    when(resp.stringResponse()).thenReturn(ofResult);

    // Act
    Optional<?> actualVal = SurveyInstanceUtilities.getVal(question, resp);

    // Assert
    verify(question).fieldType();
    verify(resp).stringResponse();
    assertEquals("foo", actualVal.get());
    assertTrue(actualVal.isPresent());
  }

  /**
   * Test {@link SurveyInstanceUtilities#getVal(SurveyQuestion, SurveyQuestionResponse)}.
   *
   * <ul>
   *   <li>When {@link SurveyQuestion}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceUtilities#getVal(SurveyQuestion,
   * SurveyQuestionResponse)}
   */
  @Test
  @DisplayName(
      "Test getVal(SurveyQuestion, SurveyQuestionResponse); when SurveyQuestion; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional SurveyInstanceUtilities.getVal(SurveyQuestion, SurveyQuestionResponse)"
  })
  void testGetVal_whenSurveyQuestion_thenReturnNotPresent() {
    // Arrange and Act
    Optional<?> actualVal = SurveyInstanceUtilities.getVal(mock(SurveyQuestion.class), null);

    // Assert
    assertFalse(actualVal.isPresent());
  }
}
