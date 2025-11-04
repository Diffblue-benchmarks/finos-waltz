package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ImmutableCopySurveyResponsesCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#addAllQuestionIds(Iterable)}
   */
  @Test
  void testBuilderAddAllQuestionIds() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllQuestionIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#addAllQuestionIds(Iterable)}
   */
  @Test
  void testBuilderAddAllQuestionIds2() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableCopySurveyResponsesCommand.Builder actualAddAllQuestionIdsResult = builderResult
        .addAllQuestionIds(elements);

    // Assert
    List<Long> questionIdsResult = builderResult.build().questionIds();
    assertEquals(1, questionIdsResult.size());
    assertEquals(1L, questionIdsResult.get(0).longValue());
    assertSame(builderResult, actualAddAllQuestionIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#addAllTargetSurveyInstanceIds(Iterable)}
   */
  @Test
  void testBuilderAddAllTargetSurveyInstanceIds() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllTargetSurveyInstanceIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#addAllTargetSurveyInstanceIds(Iterable)}
   */
  @Test
  void testBuilderAddAllTargetSurveyInstanceIds2() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableCopySurveyResponsesCommand.Builder actualAddAllTargetSurveyInstanceIdsResult = builderResult
        .addAllTargetSurveyInstanceIds(elements);

    // Assert
    Set<Long> targetSurveyInstanceIdsResult = builderResult.build().targetSurveyInstanceIds();
    assertEquals(1, targetSurveyInstanceIdsResult.size());
    assertTrue(targetSurveyInstanceIdsResult.contains(1L));
    assertSame(builderResult, actualAddAllTargetSurveyInstanceIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#addQuestionIds(long)}
   */
  @Test
  void testBuilderAddQuestionIds() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act
    ImmutableCopySurveyResponsesCommand.Builder actualAddQuestionIdsResult = builderResult.addQuestionIds(1L);

    // Assert
    List<Long> questionIdsResult = builderResult.build().questionIds();
    assertEquals(1, questionIdsResult.size());
    assertEquals(1L, questionIdsResult.get(0).longValue());
    assertSame(builderResult, actualAddQuestionIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#addQuestionIds(long[])}
   */
  @Test
  void testBuilderAddQuestionIds2() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act
    ImmutableCopySurveyResponsesCommand.Builder actualAddQuestionIdsResult = builderResult.addQuestionIds(1L, 0L, 1L,
        0L);

    // Assert
    List<Long> questionIdsResult = builderResult.build().questionIds();
    assertEquals(4, questionIdsResult.size());
    assertEquals(0L, questionIdsResult.get(1).longValue());
    assertEquals(0L, questionIdsResult.get(3).longValue());
    assertEquals(1L, questionIdsResult.get(0).longValue());
    assertEquals(1L, questionIdsResult.get(2).longValue());
    assertSame(builderResult, actualAddQuestionIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#addTargetSurveyInstanceIds(long)}
   */
  @Test
  void testBuilderAddTargetSurveyInstanceIds() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act
    ImmutableCopySurveyResponsesCommand.Builder actualAddTargetSurveyInstanceIdsResult = builderResult
        .addTargetSurveyInstanceIds(1L);

    // Assert
    Set<Long> targetSurveyInstanceIdsResult = builderResult.build().targetSurveyInstanceIds();
    assertEquals(1, targetSurveyInstanceIdsResult.size());
    assertTrue(targetSurveyInstanceIdsResult.contains(1L));
    assertSame(builderResult, actualAddTargetSurveyInstanceIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#addTargetSurveyInstanceIds(long[])}
   */
  @Test
  void testBuilderAddTargetSurveyInstanceIds2() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act
    ImmutableCopySurveyResponsesCommand.Builder actualAddTargetSurveyInstanceIdsResult = builderResult
        .addTargetSurveyInstanceIds(1L, 0L, 1L, 0L);

    // Assert
    Set<Long> targetSurveyInstanceIdsResult = builderResult.build().targetSurveyInstanceIds();
    assertEquals(2, targetSurveyInstanceIdsResult.size());
    assertTrue(targetSurveyInstanceIdsResult.contains(0L));
    assertTrue(targetSurveyInstanceIdsResult.contains(1L));
    assertSame(builderResult, actualAddTargetSurveyInstanceIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableCopySurveyResponsesCommand actualBuildResult = ImmutableCopySurveyResponsesCommand.builder().build();

    // Assert
    assertFalse(actualBuildResult.overrideExistingResponses());
    assertTrue(actualBuildResult.questionIds().isEmpty());
    assertTrue(actualBuildResult.targetSurveyInstanceIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#from(CopySurveyResponsesCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();
    CopySurveyResponsesCommand instance = mock(CopySurveyResponsesCommand.class);
    when(instance.questionIds()).thenReturn(new ArrayList<>());
    when(instance.targetSurveyInstanceIds()).thenReturn(new HashSet<>());
    when(instance.overrideExistingResponses()).thenReturn(true);

    // Act
    ImmutableCopySurveyResponsesCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).overrideExistingResponses();
    verify(instance).questionIds();
    verify(instance).targetSurveyInstanceIds();
    assertTrue(builderResult.build().overrideExistingResponses());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#from(CopySurveyResponsesCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(14L);
    CopySurveyResponsesCommand instance = mock(CopySurveyResponsesCommand.class);
    when(instance.questionIds()).thenReturn(resultLongList);
    when(instance.targetSurveyInstanceIds()).thenReturn(new HashSet<>());
    when(instance.overrideExistingResponses()).thenReturn(true);

    // Act
    ImmutableCopySurveyResponsesCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).overrideExistingResponses();
    verify(instance).questionIds();
    verify(instance).targetSurveyInstanceIds();
    ImmutableCopySurveyResponsesCommand buildResult = builderResult.build();
    List<Long> questionIdsResult = buildResult.questionIds();
    assertEquals(1, questionIdsResult.size());
    assertEquals(14L, questionIdsResult.get(0).longValue());
    assertTrue(buildResult.overrideExistingResponses());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#from(CopySurveyResponsesCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(14L);
    CopySurveyResponsesCommand instance = mock(CopySurveyResponsesCommand.class);
    when(instance.questionIds()).thenReturn(new ArrayList<>());
    when(instance.targetSurveyInstanceIds()).thenReturn(resultLongSet);
    when(instance.overrideExistingResponses()).thenReturn(true);

    // Act
    ImmutableCopySurveyResponsesCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).overrideExistingResponses();
    verify(instance).questionIds();
    verify(instance).targetSurveyInstanceIds();
    ImmutableCopySurveyResponsesCommand buildResult = builderResult.build();
    Set<Long> targetSurveyInstanceIdsResult = buildResult.targetSurveyInstanceIds();
    assertEquals(1, targetSurveyInstanceIdsResult.size());
    assertTrue(targetSurveyInstanceIdsResult.contains(14L));
    assertTrue(buildResult.overrideExistingResponses());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#overrideExistingResponses(boolean)}
   */
  @Test
  void testBuilderOverrideExistingResponses() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act
    ImmutableCopySurveyResponsesCommand.Builder actualOverrideExistingResponsesResult = builderResult
        .overrideExistingResponses(true);

    // Assert
    assertTrue(builderResult.build().overrideExistingResponses());
    assertSame(builderResult, actualOverrideExistingResponsesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#questionIds(Iterable)}
   */
  @Test
  void testBuilderQuestionIds() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.questionIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#questionIds(Iterable)}
   */
  @Test
  void testBuilderQuestionIds2() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableCopySurveyResponsesCommand.Builder actualQuestionIdsResult = builderResult.questionIds(elements);

    // Assert
    List<Long> questionIdsResult = builderResult.build().questionIds();
    assertEquals(1, questionIdsResult.size());
    assertEquals(1L, questionIdsResult.get(0).longValue());
    assertSame(builderResult, actualQuestionIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#targetSurveyInstanceIds(Iterable)}
   */
  @Test
  void testBuilderTargetSurveyInstanceIds() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetSurveyInstanceIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Builder#targetSurveyInstanceIds(Iterable)}
   */
  @Test
  void testBuilderTargetSurveyInstanceIds2() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Builder builderResult = ImmutableCopySurveyResponsesCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableCopySurveyResponsesCommand.Builder actualTargetSurveyInstanceIdsResult = builderResult
        .targetSurveyInstanceIds(elements);

    // Assert
    Set<Long> targetSurveyInstanceIdsResult = builderResult.build().targetSurveyInstanceIds();
    assertEquals(1, targetSurveyInstanceIdsResult.size());
    assertTrue(targetSurveyInstanceIdsResult.contains(1L));
    assertSame(builderResult, actualTargetSurveyInstanceIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand#copyOf(CopySurveyResponsesCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CopySurveyResponsesCommand instance = mock(CopySurveyResponsesCommand.class);
    when(instance.questionIds()).thenReturn(new ArrayList<>());
    when(instance.targetSurveyInstanceIds()).thenReturn(new HashSet<>());
    when(instance.overrideExistingResponses()).thenReturn(true);

    // Act
    ImmutableCopySurveyResponsesCommand actualCopyOfResult = ImmutableCopySurveyResponsesCommand.copyOf(instance);

    // Assert
    verify(instance).overrideExistingResponses();
    verify(instance).questionIds();
    verify(instance).targetSurveyInstanceIds();
    assertTrue(actualCopyOfResult.questionIds().isEmpty());
    assertTrue(actualCopyOfResult.targetSurveyInstanceIds().isEmpty());
    assertTrue(actualCopyOfResult.overrideExistingResponses());
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand#copyOf(CopySurveyResponsesCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(14L);
    CopySurveyResponsesCommand instance = mock(CopySurveyResponsesCommand.class);
    when(instance.questionIds()).thenReturn(resultLongList);
    when(instance.targetSurveyInstanceIds()).thenReturn(new HashSet<>());
    when(instance.overrideExistingResponses()).thenReturn(true);

    // Act
    ImmutableCopySurveyResponsesCommand actualCopyOfResult = ImmutableCopySurveyResponsesCommand.copyOf(instance);

    // Assert
    verify(instance).overrideExistingResponses();
    verify(instance).questionIds();
    verify(instance).targetSurveyInstanceIds();
    List<Long> questionIdsResult = actualCopyOfResult.questionIds();
    assertEquals(1, questionIdsResult.size());
    assertEquals(14L, questionIdsResult.get(0).longValue());
    assertTrue(actualCopyOfResult.targetSurveyInstanceIds().isEmpty());
    assertTrue(actualCopyOfResult.overrideExistingResponses());
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand#copyOf(CopySurveyResponsesCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    resultLongList.add(14L);
    CopySurveyResponsesCommand instance = mock(CopySurveyResponsesCommand.class);
    when(instance.questionIds()).thenReturn(resultLongList);
    when(instance.targetSurveyInstanceIds()).thenReturn(new HashSet<>());
    when(instance.overrideExistingResponses()).thenReturn(true);

    // Act
    ImmutableCopySurveyResponsesCommand actualCopyOfResult = ImmutableCopySurveyResponsesCommand.copyOf(instance);

    // Assert
    verify(instance).overrideExistingResponses();
    verify(instance).questionIds();
    verify(instance).targetSurveyInstanceIds();
    assertTrue(actualCopyOfResult.targetSurveyInstanceIds().isEmpty());
    assertTrue(actualCopyOfResult.overrideExistingResponses());
    assertEquals(resultLongList, actualCopyOfResult.questionIds());
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand#copyOf(CopySurveyResponsesCommand)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(14L);
    CopySurveyResponsesCommand instance = mock(CopySurveyResponsesCommand.class);
    when(instance.questionIds()).thenReturn(new ArrayList<>());
    when(instance.targetSurveyInstanceIds()).thenReturn(resultLongSet);
    when(instance.overrideExistingResponses()).thenReturn(true);

    // Act
    ImmutableCopySurveyResponsesCommand actualCopyOfResult = ImmutableCopySurveyResponsesCommand.copyOf(instance);

    // Assert
    verify(instance).overrideExistingResponses();
    verify(instance).questionIds();
    verify(instance).targetSurveyInstanceIds();
    Set<Long> targetSurveyInstanceIdsResult = actualCopyOfResult.targetSurveyInstanceIds();
    assertEquals(1, targetSurveyInstanceIdsResult.size());
    assertTrue(actualCopyOfResult.questionIds().isEmpty());
    assertTrue(targetSurveyInstanceIdsResult.contains(14L));
    assertTrue(actualCopyOfResult.overrideExistingResponses());
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand#copyOf(CopySurveyResponsesCommand)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    CopySurveyResponsesCommand instance = mock(CopySurveyResponsesCommand.class);
    when(instance.questionIds()).thenReturn(new ArrayList<>());
    when(instance.targetSurveyInstanceIds()).thenReturn(new HashSet<>());
    when(instance.overrideExistingResponses()).thenReturn(false);

    // Act
    ImmutableCopySurveyResponsesCommand actualCopyOfResult = ImmutableCopySurveyResponsesCommand.copyOf(instance);

    // Assert
    verify(instance).overrideExistingResponses();
    verify(instance).questionIds();
    verify(instance).targetSurveyInstanceIds();
    assertFalse(actualCopyOfResult.overrideExistingResponses());
    assertTrue(actualCopyOfResult.questionIds().isEmpty());
    assertTrue(actualCopyOfResult.targetSurveyInstanceIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand#copyOf(CopySurveyResponsesCommand)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(Long.MAX_VALUE);
    resultLongSet.add(14L);
    resultLongSet.add(14L);
    CopySurveyResponsesCommand instance = mock(CopySurveyResponsesCommand.class);
    when(instance.questionIds()).thenReturn(new ArrayList<>());
    when(instance.targetSurveyInstanceIds()).thenReturn(resultLongSet);
    when(instance.overrideExistingResponses()).thenReturn(true);

    // Act
    ImmutableCopySurveyResponsesCommand actualCopyOfResult = ImmutableCopySurveyResponsesCommand.copyOf(instance);

    // Assert
    verify(instance).overrideExistingResponses();
    verify(instance).questionIds();
    verify(instance).targetSurveyInstanceIds();
    assertTrue(actualCopyOfResult.questionIds().isEmpty());
    assertTrue(actualCopyOfResult.overrideExistingResponses());
    assertEquals(resultLongSet, actualCopyOfResult.targetSurveyInstanceIds());
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand#fromJson(ImmutableCopySurveyResponsesCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Json json = new ImmutableCopySurveyResponsesCommand.Json();

    // Act
    ImmutableCopySurveyResponsesCommand actualFromJsonResult = ImmutableCopySurveyResponsesCommand.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.overrideExistingResponses());
    List<Long> questionIdsResult = actualFromJsonResult.questionIds();
    assertTrue(questionIdsResult.isEmpty());
    Set<Long> targetSurveyInstanceIdsResult = actualFromJsonResult.targetSurveyInstanceIds();
    assertTrue(targetSurveyInstanceIdsResult.isEmpty());
    assertSame(json.questionIds, questionIdsResult);
    assertSame(json.targetSurveyInstanceIds, targetSurveyInstanceIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand#fromJson(ImmutableCopySurveyResponsesCommand.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    HashSet<Long> targetSurveyInstanceIds = new HashSet<>();
    targetSurveyInstanceIds.add(1L);

    ImmutableCopySurveyResponsesCommand.Json json = new ImmutableCopySurveyResponsesCommand.Json();
    json.setTargetSurveyInstanceIds(targetSurveyInstanceIds);

    // Act
    ImmutableCopySurveyResponsesCommand actualFromJsonResult = ImmutableCopySurveyResponsesCommand.fromJson(json);

    // Assert
    Set<Long> targetSurveyInstanceIdsResult = actualFromJsonResult.targetSurveyInstanceIds();
    assertEquals(1, targetSurveyInstanceIdsResult.size());
    assertFalse(actualFromJsonResult.overrideExistingResponses());
    List<Long> questionIdsResult = actualFromJsonResult.questionIds();
    assertTrue(questionIdsResult.isEmpty());
    assertTrue(targetSurveyInstanceIdsResult.contains(1L));
    assertSame(json.questionIds, questionIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand#fromJson(ImmutableCopySurveyResponsesCommand.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    HashSet<Long> targetSurveyInstanceIds = new HashSet<>();
    targetSurveyInstanceIds.add(3L);
    targetSurveyInstanceIds.add(1L);

    ImmutableCopySurveyResponsesCommand.Json json = new ImmutableCopySurveyResponsesCommand.Json();
    json.setTargetSurveyInstanceIds(targetSurveyInstanceIds);

    // Act
    ImmutableCopySurveyResponsesCommand actualFromJsonResult = ImmutableCopySurveyResponsesCommand.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.overrideExistingResponses());
    List<Long> questionIdsResult = actualFromJsonResult.questionIds();
    assertTrue(questionIdsResult.isEmpty());
    assertEquals(targetSurveyInstanceIds, actualFromJsonResult.targetSurveyInstanceIds());
    assertSame(json.questionIds, questionIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand#fromJson(ImmutableCopySurveyResponsesCommand.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ArrayList<Long> questionIds = new ArrayList<>();
    questionIds.add(1L);

    ImmutableCopySurveyResponsesCommand.Json json = new ImmutableCopySurveyResponsesCommand.Json();
    json.setQuestionIds(questionIds);

    // Act
    ImmutableCopySurveyResponsesCommand actualFromJsonResult = ImmutableCopySurveyResponsesCommand.fromJson(json);

    // Assert
    List<Long> questionIdsResult = actualFromJsonResult.questionIds();
    assertEquals(1, questionIdsResult.size());
    assertEquals(1L, questionIdsResult.get(0).longValue());
    assertFalse(actualFromJsonResult.overrideExistingResponses());
    Set<Long> targetSurveyInstanceIdsResult = actualFromJsonResult.targetSurveyInstanceIds();
    assertTrue(targetSurveyInstanceIdsResult.isEmpty());
    assertSame(json.targetSurveyInstanceIds, targetSurveyInstanceIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand#fromJson(ImmutableCopySurveyResponsesCommand.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    ArrayList<Long> questionIds = new ArrayList<>();
    questionIds.add(3L);
    questionIds.add(1L);

    ImmutableCopySurveyResponsesCommand.Json json = new ImmutableCopySurveyResponsesCommand.Json();
    json.setQuestionIds(questionIds);

    // Act
    ImmutableCopySurveyResponsesCommand actualFromJsonResult = ImmutableCopySurveyResponsesCommand.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.overrideExistingResponses());
    Set<Long> targetSurveyInstanceIdsResult = actualFromJsonResult.targetSurveyInstanceIds();
    assertTrue(targetSurveyInstanceIdsResult.isEmpty());
    assertEquals(questionIds, actualFromJsonResult.questionIds());
    assertSame(json.targetSurveyInstanceIds, targetSurveyInstanceIdsResult);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableCopySurveyResponsesCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableCopySurveyResponsesCommand.Json actualJson = new ImmutableCopySurveyResponsesCommand.Json();

    // Assert
    assertFalse(actualJson.overrideExistingResponses);
    assertFalse(actualJson.overrideExistingResponsesIsSet);
    assertTrue(actualJson.questionIds.isEmpty());
    assertTrue(actualJson.targetSurveyInstanceIds.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Json#overrideExistingResponses()}
   */
  @Test
  void testJsonOverrideExistingResponses() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableCopySurveyResponsesCommand.Json()).overrideExistingResponses());
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Json#questionIds()}
   */
  @Test
  void testJsonQuestionIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableCopySurveyResponsesCommand.Json()).questionIds());
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Json#setOverrideExistingResponses(boolean)}
   */
  @Test
  void testJsonSetOverrideExistingResponses() {
    // Arrange
    ImmutableCopySurveyResponsesCommand.Json json = new ImmutableCopySurveyResponsesCommand.Json();

    // Act
    json.setOverrideExistingResponses(true);

    // Assert
    assertTrue(json.overrideExistingResponses);
    assertTrue(json.overrideExistingResponsesIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableCopySurveyResponsesCommand.Json#targetSurveyInstanceIds()}
   */
  @Test
  void testJsonTargetSurveyInstanceIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableCopySurveyResponsesCommand.Json()).targetSurveyInstanceIds());
  }
}
