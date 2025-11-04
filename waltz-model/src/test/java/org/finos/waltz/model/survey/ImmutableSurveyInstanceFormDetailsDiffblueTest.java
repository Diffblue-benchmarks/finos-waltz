package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.core.util.COWArrayList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceFormDetailsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#activeQuestions(Iterable)}
   */
  @Test
  void testBuilderActiveQuestions() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.activeQuestions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#addActiveQuestions(SurveyQuestion)}
   */
  @Test
  void testBuilderAddActiveQuestions() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();
    ImmutableSurveyQuestion.Json element = new ImmutableSurveyQuestion.Json();

    // Act
    ImmutableSurveyInstanceFormDetails.Builder actualAddActiveQuestionsResult = builderResult
        .addActiveQuestions(element);

    // Assert
    List<SurveyQuestion> activeQuestionsResult = builderResult.build().activeQuestions();
    assertEquals(1, activeQuestionsResult.size());
    assertSame(element, activeQuestionsResult.get(0));
    assertSame(builderResult, actualAddActiveQuestionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#addActiveQuestions(SurveyQuestion)}
   */
  @Test
  void testBuilderAddActiveQuestions2() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    ImmutableSurveyQuestion.Json element = new ImmutableSurveyQuestion.Json();
    Optional<EntityReference> qualifierEntity = Optional.of(mock(EntityReference.class));
    element.setQualifierEntity(qualifierEntity);

    // Act
    ImmutableSurveyInstanceFormDetails.Builder actualAddActiveQuestionsResult = builderResult
        .addActiveQuestions(element);

    // Assert
    List<SurveyQuestion> activeQuestionsResult = builderResult.build().activeQuestions();
    assertEquals(1, activeQuestionsResult.size());
    assertSame(element, activeQuestionsResult.get(0));
    assertSame(builderResult, actualAddActiveQuestionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#addActiveQuestions(SurveyQuestion[])}
   */
  @Test
  void testBuilderAddActiveQuestions3() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();
    ImmutableSurveyQuestion.Json json = new ImmutableSurveyQuestion.Json();

    // Act
    ImmutableSurveyInstanceFormDetails.Builder actualAddActiveQuestionsResult = builderResult.addActiveQuestions(json);

    // Assert
    List<SurveyQuestion> activeQuestionsResult = builderResult.build().activeQuestions();
    assertEquals(1, activeQuestionsResult.size());
    assertSame(json, activeQuestionsResult.get(0));
    assertSame(builderResult, actualAddActiveQuestionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#addActiveQuestions(SurveyQuestion[])}
   */
  @Test
  void testBuilderAddActiveQuestions4() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    ImmutableSurveyQuestion.Json json = new ImmutableSurveyQuestion.Json();
    Optional<EntityReference> qualifierEntity = Optional.of(mock(EntityReference.class));
    json.setQualifierEntity(qualifierEntity);

    // Act
    ImmutableSurveyInstanceFormDetails.Builder actualAddActiveQuestionsResult = builderResult.addActiveQuestions(json);

    // Assert
    List<SurveyQuestion> activeQuestionsResult = builderResult.build().activeQuestions();
    assertEquals(1, activeQuestionsResult.size());
    assertSame(json, activeQuestionsResult.get(0));
    assertSame(builderResult, actualAddActiveQuestionsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#addAllActiveQuestions(Iterable)}
   */
  @Test
  void testBuilderAddAllActiveQuestions() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllActiveQuestions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#addAllMissingMandatoryQuestionIds(Iterable)}
   */
  @Test
  void testBuilderAddAllMissingMandatoryQuestionIds() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllMissingMandatoryQuestionIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#addAllMissingMandatoryQuestionIds(Iterable)}
   */
  @Test
  void testBuilderAddAllMissingMandatoryQuestionIds2() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSurveyInstanceFormDetails.Builder actualAddAllMissingMandatoryQuestionIdsResult = builderResult
        .addAllMissingMandatoryQuestionIds(elements);

    // Assert
    Set<Long> missingMandatoryQuestionIdsResult = builderResult.build().missingMandatoryQuestionIds();
    assertEquals(1, missingMandatoryQuestionIdsResult.size());
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
    assertSame(builderResult, actualAddAllMissingMandatoryQuestionIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#addAllMissingMandatoryQuestionIds(Iterable)}
   */
  @Test
  void testBuilderAddAllMissingMandatoryQuestionIds3() {
    // Arrange
    ImmutableSurveyQuestion.Json element = new ImmutableSurveyQuestion.Json();
    Optional<EntityReference> qualifierEntity = Optional.of(mock(EntityReference.class));
    element.setQualifierEntity(qualifierEntity);
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();
    builderResult.addActiveQuestions(element);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllMissingMandatoryQuestionIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#addMissingMandatoryQuestionIds(long)}
   */
  @Test
  void testBuilderAddMissingMandatoryQuestionIds() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act
    ImmutableSurveyInstanceFormDetails.Builder actualAddMissingMandatoryQuestionIdsResult = builderResult
        .addMissingMandatoryQuestionIds(1L);

    // Assert
    Set<Long> missingMandatoryQuestionIdsResult = builderResult.build().missingMandatoryQuestionIds();
    assertEquals(1, missingMandatoryQuestionIdsResult.size());
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
    assertSame(builderResult, actualAddMissingMandatoryQuestionIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#addMissingMandatoryQuestionIds(long)}
   */
  @Test
  void testBuilderAddMissingMandatoryQuestionIds2() {
    // Arrange
    ImmutableSurveyQuestion.Json element = new ImmutableSurveyQuestion.Json();
    Optional<EntityReference> qualifierEntity = Optional.of(mock(EntityReference.class));
    element.setQualifierEntity(qualifierEntity);
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();
    builderResult.addActiveQuestions(element);

    // Act
    ImmutableSurveyInstanceFormDetails.Builder actualAddMissingMandatoryQuestionIdsResult = builderResult
        .addMissingMandatoryQuestionIds(1L);

    // Assert
    Set<Long> missingMandatoryQuestionIdsResult = builderResult.build().missingMandatoryQuestionIds();
    assertEquals(1, missingMandatoryQuestionIdsResult.size());
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
    assertSame(builderResult, actualAddMissingMandatoryQuestionIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#addMissingMandatoryQuestionIds(long[])}
   */
  @Test
  void testBuilderAddMissingMandatoryQuestionIds3() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act
    ImmutableSurveyInstanceFormDetails.Builder actualAddMissingMandatoryQuestionIdsResult = builderResult
        .addMissingMandatoryQuestionIds(1L, -1L, 1L, -1L);

    // Assert
    Set<Long> missingMandatoryQuestionIdsResult = builderResult.build().missingMandatoryQuestionIds();
    assertEquals(2, missingMandatoryQuestionIdsResult.size());
    assertTrue(missingMandatoryQuestionIdsResult.contains(-1L));
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
    assertSame(builderResult, actualAddMissingMandatoryQuestionIdsResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyInstanceFormDetails.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSurveyInstanceFormDetails actualBuildResult = ImmutableSurveyInstanceFormDetails.builder().build();

    // Assert
    assertTrue(actualBuildResult.activeQuestions().isEmpty());
    assertTrue(actualBuildResult.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#from(SurveyInstanceFormDetails)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();
    SurveyInstanceFormDetails instance = mock(SurveyInstanceFormDetails.class);
    when(instance.activeQuestions()).thenReturn(new ArrayList<>());
    when(instance.missingMandatoryQuestionIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableSurveyInstanceFormDetails.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).activeQuestions();
    verify(instance).missingMandatoryQuestionIds();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#from(SurveyInstanceFormDetails)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();
    ImmutableSurveyQuestion.Json json = new ImmutableSurveyQuestion.Json();
    surveyQuestionList.add(json);
    SurveyInstanceFormDetails instance = mock(SurveyInstanceFormDetails.class);
    when(instance.activeQuestions()).thenReturn(surveyQuestionList);
    when(instance.missingMandatoryQuestionIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableSurveyInstanceFormDetails.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).activeQuestions();
    verify(instance).missingMandatoryQuestionIds();
    List<SurveyQuestion> activeQuestionsResult = builderResult.build().activeQuestions();
    assertEquals(1, activeQuestionsResult.size());
    assertSame(json, activeQuestionsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#from(SurveyInstanceFormDetails)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    SurveyInstanceFormDetails instance = mock(SurveyInstanceFormDetails.class);
    when(instance.activeQuestions()).thenReturn(new ArrayList<>());
    when(instance.missingMandatoryQuestionIds()).thenReturn(resultLongSet);

    // Act
    ImmutableSurveyInstanceFormDetails.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).activeQuestions();
    verify(instance).missingMandatoryQuestionIds();
    Set<Long> missingMandatoryQuestionIdsResult = builderResult.build().missingMandatoryQuestionIds();
    assertEquals(1, missingMandatoryQuestionIdsResult.size());
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#missingMandatoryQuestionIds(Iterable)}
   */
  @Test
  void testBuilderMissingMandatoryQuestionIds() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.missingMandatoryQuestionIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#missingMandatoryQuestionIds(Iterable)}
   */
  @Test
  void testBuilderMissingMandatoryQuestionIds2() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSurveyInstanceFormDetails.Builder actualMissingMandatoryQuestionIdsResult = builderResult
        .missingMandatoryQuestionIds(elements);

    // Assert
    Set<Long> missingMandatoryQuestionIdsResult = builderResult.build().missingMandatoryQuestionIds();
    assertEquals(1, missingMandatoryQuestionIdsResult.size());
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
    assertSame(builderResult, actualMissingMandatoryQuestionIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Builder#missingMandatoryQuestionIds(Iterable)}
   */
  @Test
  void testBuilderMissingMandatoryQuestionIds3() {
    // Arrange
    ImmutableSurveyQuestion.Json element = new ImmutableSurveyQuestion.Json();
    Optional<EntityReference> qualifierEntity = Optional.of(mock(EntityReference.class));
    element.setQualifierEntity(qualifierEntity);
    ImmutableSurveyInstanceFormDetails.Builder builderResult = ImmutableSurveyInstanceFormDetails.builder();
    builderResult.addActiveQuestions(element);

    // Act and Assert
    assertSame(builderResult, builderResult.missingMandatoryQuestionIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails#copyOf(SurveyInstanceFormDetails)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstanceFormDetails instance = mock(SurveyInstanceFormDetails.class);
    when(instance.activeQuestions()).thenReturn(new ArrayList<>());
    when(instance.missingMandatoryQuestionIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableSurveyInstanceFormDetails actualCopyOfResult = ImmutableSurveyInstanceFormDetails.copyOf(instance);

    // Assert
    verify(instance).activeQuestions();
    verify(instance).missingMandatoryQuestionIds();
    assertTrue(actualCopyOfResult.activeQuestions().isEmpty());
    assertTrue(actualCopyOfResult.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails#copyOf(SurveyInstanceFormDetails)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();
    surveyQuestionList.add(new ImmutableSurveyQuestion.Json());
    SurveyInstanceFormDetails instance = mock(SurveyInstanceFormDetails.class);
    when(instance.activeQuestions()).thenReturn(surveyQuestionList);
    when(instance.missingMandatoryQuestionIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableSurveyInstanceFormDetails actualCopyOfResult = ImmutableSurveyInstanceFormDetails.copyOf(instance);

    // Assert
    verify(instance).activeQuestions();
    verify(instance).missingMandatoryQuestionIds();
    assertTrue(actualCopyOfResult.missingMandatoryQuestionIds().isEmpty());
    assertEquals(surveyQuestionList, actualCopyOfResult.activeQuestions());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails#copyOf(SurveyInstanceFormDetails)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();
    surveyQuestionList.add(new ImmutableSurveyQuestion.Json());
    surveyQuestionList.add(new ImmutableSurveyQuestion.Json());
    SurveyInstanceFormDetails instance = mock(SurveyInstanceFormDetails.class);
    when(instance.activeQuestions()).thenReturn(surveyQuestionList);
    when(instance.missingMandatoryQuestionIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableSurveyInstanceFormDetails actualCopyOfResult = ImmutableSurveyInstanceFormDetails.copyOf(instance);

    // Assert
    verify(instance).activeQuestions();
    verify(instance).missingMandatoryQuestionIds();
    assertTrue(actualCopyOfResult.missingMandatoryQuestionIds().isEmpty());
    assertEquals(surveyQuestionList, actualCopyOfResult.activeQuestions());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails#copyOf(SurveyInstanceFormDetails)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    SurveyInstanceFormDetails instance = mock(SurveyInstanceFormDetails.class);
    when(instance.activeQuestions()).thenReturn(new ArrayList<>());
    when(instance.missingMandatoryQuestionIds()).thenReturn(resultLongSet);

    // Act
    ImmutableSurveyInstanceFormDetails actualCopyOfResult = ImmutableSurveyInstanceFormDetails.copyOf(instance);

    // Assert
    verify(instance).activeQuestions();
    verify(instance).missingMandatoryQuestionIds();
    Set<Long> missingMandatoryQuestionIdsResult = actualCopyOfResult.missingMandatoryQuestionIds();
    assertEquals(1, missingMandatoryQuestionIdsResult.size());
    assertTrue(actualCopyOfResult.activeQuestions().isEmpty());
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails#copyOf(SurveyInstanceFormDetails)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(0L);
    resultLongSet.add(1L);
    SurveyInstanceFormDetails instance = mock(SurveyInstanceFormDetails.class);
    when(instance.activeQuestions()).thenReturn(new ArrayList<>());
    when(instance.missingMandatoryQuestionIds()).thenReturn(resultLongSet);

    // Act
    ImmutableSurveyInstanceFormDetails actualCopyOfResult = ImmutableSurveyInstanceFormDetails.copyOf(instance);

    // Assert
    verify(instance).activeQuestions();
    verify(instance).missingMandatoryQuestionIds();
    assertTrue(actualCopyOfResult.activeQuestions().isEmpty());
    assertEquals(resultLongSet, actualCopyOfResult.missingMandatoryQuestionIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails#fromJson(ImmutableSurveyInstanceFormDetails.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Json json = new ImmutableSurveyInstanceFormDetails.Json();

    // Act
    ImmutableSurveyInstanceFormDetails actualFromJsonResult = ImmutableSurveyInstanceFormDetails.fromJson(json);

    // Assert
    List<SurveyQuestion> activeQuestionsResult = actualFromJsonResult.activeQuestions();
    assertTrue(activeQuestionsResult.isEmpty());
    Set<Long> missingMandatoryQuestionIdsResult = actualFromJsonResult.missingMandatoryQuestionIds();
    assertTrue(missingMandatoryQuestionIdsResult.isEmpty());
    assertSame(json.activeQuestions, activeQuestionsResult);
    assertSame(json.missingMandatoryQuestionIds, missingMandatoryQuestionIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails#fromJson(ImmutableSurveyInstanceFormDetails.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableSurveyInstanceFormDetails.Json json = new ImmutableSurveyInstanceFormDetails.Json();
    json.setActiveQuestions(null);
    json.setMissingMandatoryQuestionIds(null);

    // Act
    ImmutableSurveyInstanceFormDetails actualFromJsonResult = ImmutableSurveyInstanceFormDetails.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.activeQuestions().isEmpty());
    assertTrue(actualFromJsonResult.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails#fromJson(ImmutableSurveyInstanceFormDetails.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<Long> missingMandatoryQuestionIds = new LinkedHashSet<>();
    missingMandatoryQuestionIds.add(1L);

    ImmutableSurveyInstanceFormDetails.Json json = new ImmutableSurveyInstanceFormDetails.Json();
    json.setActiveQuestions(null);
    json.setMissingMandatoryQuestionIds(missingMandatoryQuestionIds);

    // Act
    ImmutableSurveyInstanceFormDetails actualFromJsonResult = ImmutableSurveyInstanceFormDetails.fromJson(json);

    // Assert
    Set<Long> missingMandatoryQuestionIdsResult = actualFromJsonResult.missingMandatoryQuestionIds();
    assertEquals(1, missingMandatoryQuestionIdsResult.size());
    assertTrue(actualFromJsonResult.activeQuestions().isEmpty());
    assertTrue(missingMandatoryQuestionIdsResult.contains(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails#fromJson(ImmutableSurveyInstanceFormDetails.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ArrayList<SurveyQuestion> activeQuestions = new ArrayList<>();
    activeQuestions.add(new ImmutableSurveyQuestion.Json());

    ImmutableSurveyInstanceFormDetails.Json json = new ImmutableSurveyInstanceFormDetails.Json();
    json.setActiveQuestions(activeQuestions);
    json.setMissingMandatoryQuestionIds(null);

    // Act
    ImmutableSurveyInstanceFormDetails actualFromJsonResult = ImmutableSurveyInstanceFormDetails.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.missingMandatoryQuestionIds().isEmpty());
    assertEquals(activeQuestions, actualFromJsonResult.activeQuestions());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails#fromJson(ImmutableSurveyInstanceFormDetails.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    COWArrayList<SurveyQuestion> activeQuestions = mock(COWArrayList.class);

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();
    when(activeQuestions.iterator()).thenReturn(surveyQuestionList.iterator());

    ImmutableSurveyInstanceFormDetails.Json json = new ImmutableSurveyInstanceFormDetails.Json();
    json.setActiveQuestions(activeQuestions);
    json.setMissingMandatoryQuestionIds(null);

    // Act
    ImmutableSurveyInstanceFormDetails actualFromJsonResult = ImmutableSurveyInstanceFormDetails.fromJson(json);

    // Assert
    verify(activeQuestions).iterator();
    assertTrue(actualFromJsonResult.activeQuestions().isEmpty());
    assertTrue(actualFromJsonResult.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails#fromJson(ImmutableSurveyInstanceFormDetails.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();
    surveyQuestionList.add(new ImmutableSurveyQuestion.Json());
    surveyQuestionList.add(new ImmutableSurveyQuestion.Json());
    COWArrayList<SurveyQuestion> activeQuestions = mock(COWArrayList.class);
    when(activeQuestions.iterator()).thenReturn(surveyQuestionList.iterator());

    ImmutableSurveyInstanceFormDetails.Json json = new ImmutableSurveyInstanceFormDetails.Json();
    json.setActiveQuestions(activeQuestions);
    json.setMissingMandatoryQuestionIds(null);

    // Act
    ImmutableSurveyInstanceFormDetails actualFromJsonResult = ImmutableSurveyInstanceFormDetails.fromJson(json);

    // Assert
    verify(activeQuestions).iterator();
    assertTrue(actualFromJsonResult.missingMandatoryQuestionIds().isEmpty());
    assertEquals(surveyQuestionList, actualFromJsonResult.activeQuestions());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails#fromJson(ImmutableSurveyInstanceFormDetails.Json)}
   */
  @Test
  void testFromJson7() {
    // Arrange
    LinkedHashSet<Long> missingMandatoryQuestionIds = new LinkedHashSet<>();
    missingMandatoryQuestionIds.add(-1L);
    missingMandatoryQuestionIds.add(1L);

    ImmutableSurveyInstanceFormDetails.Json json = new ImmutableSurveyInstanceFormDetails.Json();
    json.setActiveQuestions(null);
    json.setMissingMandatoryQuestionIds(missingMandatoryQuestionIds);

    // Act
    ImmutableSurveyInstanceFormDetails actualFromJsonResult = ImmutableSurveyInstanceFormDetails.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.activeQuestions().isEmpty());
    assertEquals(missingMandatoryQuestionIds, actualFromJsonResult.missingMandatoryQuestionIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Json#activeQuestions()}
   */
  @Test
  void testJsonActiveQuestions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceFormDetails.Json()).activeQuestions());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceFormDetails.Json#missingMandatoryQuestionIds()}
   */
  @Test
  void testJsonMissingMandatoryQuestionIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceFormDetails.Json()).missingMandatoryQuestionIds());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyInstanceFormDetails.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyInstanceFormDetails.Json actualJson = new ImmutableSurveyInstanceFormDetails.Json();

    // Assert
    assertTrue(actualJson.activeQuestions.isEmpty());
    assertTrue(actualJson.missingMandatoryQuestionIds.isEmpty());
  }
}
