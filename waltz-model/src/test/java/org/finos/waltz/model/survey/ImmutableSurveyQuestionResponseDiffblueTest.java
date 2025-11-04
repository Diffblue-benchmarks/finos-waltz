package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionResponseDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#booleanResponse(Optional)}
   */
  @Test
  void testBuilderBooleanResponse() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    // Act and Assert
    assertSame(builderResult, builderResult.booleanResponse(booleanResponse));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#booleanResponse(Optional)}
   */
  @Test
  void testBuilderBooleanResponse2() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    builderResult.entityResponse(mock(EntityReference.class));
    Optional<Boolean> booleanResponse = Optional.of(true);

    // Act and Assert
    assertSame(builderResult, builderResult.booleanResponse(booleanResponse));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#booleanResponse(boolean)}
   */
  @Test
  void testBuilderBooleanResponse3() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.booleanResponse(true));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#booleanResponse(boolean)}
   */
  @Test
  void testBuilderBooleanResponse4() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    builderResult.entityResponse(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.booleanResponse(true));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#comment(Optional)}
   */
  @Test
  void testBuilderComment() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<String> comment = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.comment(comment));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#comment(Optional)}
   */
  @Test
  void testBuilderComment2() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    builderResult.entityResponse(mock(EntityReference.class));
    Optional<String> comment = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.comment(comment));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#from(SurveyQuestionResponse)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    SurveyQuestionResponse instance = mock(SurveyQuestionResponse.class);
    when(instance.questionId()).thenReturn(1L);
    Optional<Boolean> ofResult = Optional.of(true);
    when(instance.booleanResponse()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult2);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.dateResponse()).thenReturn(ofResult3);
    Optional<List<EntityReference>> ofResult4 = Optional.of(new ArrayList<>());
    when(instance.entityListResponse()).thenReturn(ofResult4);
    Optional<EntityReference> ofResult5 = Optional.of(mock(EntityReference.class));
    when(instance.entityResponse()).thenReturn(ofResult5);
    Optional<List<String>> ofResult6 = Optional.of(new ArrayList<>());
    when(instance.listResponse()).thenReturn(ofResult6);
    Optional<Double> ofResult7 = Optional.<Double>of(10.0d);
    when(instance.numberResponse()).thenReturn(ofResult7);
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.stringResponse()).thenReturn(ofResult8);

    // Act
    ImmutableSurveyQuestionResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).booleanResponse();
    verify(instance).comment();
    verify(instance).dateResponse();
    verify(instance).entityListResponse();
    verify(instance).entityResponse();
    verify(instance).listResponse();
    verify(instance).numberResponse();
    verify(instance).questionId();
    verify(instance).stringResponse();
    assertEquals(1L, actualFromResult.build().questionId().longValue());
    assertEquals(1L, builderResult.build().questionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#from(SurveyQuestionResponse)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    SurveyQuestionResponse instance = mock(SurveyQuestionResponse.class);
    when(instance.questionId()).thenReturn(1L);
    Optional<Boolean> ofResult = Optional.of(true);
    when(instance.booleanResponse()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult2);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.dateResponse()).thenReturn(ofResult3);
    Optional<List<EntityReference>> ofResult4 = Optional.of(new ArrayList<>());
    when(instance.entityListResponse()).thenReturn(ofResult4);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.entityResponse()).thenReturn(emptyResult);
    Optional<List<String>> ofResult5 = Optional.of(new ArrayList<>());
    when(instance.listResponse()).thenReturn(ofResult5);
    Optional<Double> ofResult6 = Optional.<Double>of(10.0d);
    when(instance.numberResponse()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.stringResponse()).thenReturn(ofResult7);

    // Act
    ImmutableSurveyQuestionResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).booleanResponse();
    verify(instance).comment();
    verify(instance).dateResponse();
    verify(instance).entityListResponse();
    verify(instance).entityResponse();
    verify(instance).listResponse();
    verify(instance).numberResponse();
    verify(instance).questionId();
    verify(instance).stringResponse();
    assertEquals(1L, actualFromResult.build().questionId().longValue());
    assertEquals(1L, builderResult.build().questionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#from(SurveyQuestionResponse)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    SurveyQuestionResponse instance = mock(SurveyQuestionResponse.class);
    when(instance.questionId()).thenReturn(1L);
    Optional<Boolean> emptyResult = Optional.empty();
    when(instance.booleanResponse()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.dateResponse()).thenReturn(ofResult2);
    Optional<List<EntityReference>> ofResult3 = Optional.of(new ArrayList<>());
    when(instance.entityListResponse()).thenReturn(ofResult3);
    Optional<EntityReference> ofResult4 = Optional.of(mock(EntityReference.class));
    when(instance.entityResponse()).thenReturn(ofResult4);
    Optional<List<String>> ofResult5 = Optional.of(new ArrayList<>());
    when(instance.listResponse()).thenReturn(ofResult5);
    Optional<Double> ofResult6 = Optional.<Double>of(10.0d);
    when(instance.numberResponse()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.stringResponse()).thenReturn(ofResult7);

    // Act
    ImmutableSurveyQuestionResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).booleanResponse();
    verify(instance).comment();
    verify(instance).dateResponse();
    verify(instance).entityListResponse();
    verify(instance).entityResponse();
    verify(instance).listResponse();
    verify(instance).numberResponse();
    verify(instance).questionId();
    verify(instance).stringResponse();
    assertEquals(1L, actualFromResult.build().questionId().longValue());
    assertEquals(1L, builderResult.build().questionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#from(SurveyQuestionResponse)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    SurveyQuestionResponse instance = mock(SurveyQuestionResponse.class);
    when(instance.questionId()).thenReturn(1L);
    Optional<Boolean> ofResult = Optional.of(true);
    when(instance.booleanResponse()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.comment()).thenReturn(emptyResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.dateResponse()).thenReturn(ofResult2);
    Optional<List<EntityReference>> ofResult3 = Optional.of(new ArrayList<>());
    when(instance.entityListResponse()).thenReturn(ofResult3);
    Optional<EntityReference> ofResult4 = Optional.of(mock(EntityReference.class));
    when(instance.entityResponse()).thenReturn(ofResult4);
    Optional<List<String>> ofResult5 = Optional.of(new ArrayList<>());
    when(instance.listResponse()).thenReturn(ofResult5);
    Optional<Double> ofResult6 = Optional.<Double>of(10.0d);
    when(instance.numberResponse()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.stringResponse()).thenReturn(ofResult7);

    // Act
    ImmutableSurveyQuestionResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).booleanResponse();
    verify(instance).comment();
    verify(instance).dateResponse();
    verify(instance).entityListResponse();
    verify(instance).entityResponse();
    verify(instance).listResponse();
    verify(instance).numberResponse();
    verify(instance).questionId();
    verify(instance).stringResponse();
    assertEquals(1L, actualFromResult.build().questionId().longValue());
    assertEquals(1L, builderResult.build().questionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#from(SurveyQuestionResponse)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    SurveyQuestionResponse instance = mock(SurveyQuestionResponse.class);
    when(instance.questionId()).thenReturn(1L);
    Optional<Boolean> ofResult = Optional.of(true);
    when(instance.booleanResponse()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult2);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.dateResponse()).thenReturn(emptyResult);
    Optional<List<EntityReference>> ofResult3 = Optional.of(new ArrayList<>());
    when(instance.entityListResponse()).thenReturn(ofResult3);
    Optional<EntityReference> ofResult4 = Optional.of(mock(EntityReference.class));
    when(instance.entityResponse()).thenReturn(ofResult4);
    Optional<List<String>> ofResult5 = Optional.of(new ArrayList<>());
    when(instance.listResponse()).thenReturn(ofResult5);
    Optional<Double> ofResult6 = Optional.<Double>of(10.0d);
    when(instance.numberResponse()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.stringResponse()).thenReturn(ofResult7);

    // Act
    ImmutableSurveyQuestionResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).booleanResponse();
    verify(instance).comment();
    verify(instance).dateResponse();
    verify(instance).entityListResponse();
    verify(instance).entityResponse();
    verify(instance).listResponse();
    verify(instance).numberResponse();
    verify(instance).questionId();
    verify(instance).stringResponse();
    assertEquals(1L, actualFromResult.build().questionId().longValue());
    assertEquals(1L, builderResult.build().questionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#from(SurveyQuestionResponse)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    SurveyQuestionResponse instance = mock(SurveyQuestionResponse.class);
    when(instance.questionId()).thenReturn(1L);
    Optional<Boolean> ofResult = Optional.of(true);
    when(instance.booleanResponse()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult2);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.dateResponse()).thenReturn(ofResult3);
    Optional<List<EntityReference>> emptyResult = Optional.empty();
    when(instance.entityListResponse()).thenReturn(emptyResult);
    Optional<EntityReference> ofResult4 = Optional.of(mock(EntityReference.class));
    when(instance.entityResponse()).thenReturn(ofResult4);
    Optional<List<String>> ofResult5 = Optional.of(new ArrayList<>());
    when(instance.listResponse()).thenReturn(ofResult5);
    Optional<Double> ofResult6 = Optional.<Double>of(10.0d);
    when(instance.numberResponse()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.stringResponse()).thenReturn(ofResult7);

    // Act
    ImmutableSurveyQuestionResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).booleanResponse();
    verify(instance).comment();
    verify(instance).dateResponse();
    verify(instance).entityListResponse();
    verify(instance).entityResponse();
    verify(instance).listResponse();
    verify(instance).numberResponse();
    verify(instance).questionId();
    verify(instance).stringResponse();
    assertEquals(1L, actualFromResult.build().questionId().longValue());
    assertEquals(1L, builderResult.build().questionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#numberResponse(double)}
   */
  @Test
  void testBuilderNumberResponse() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.numberResponse(10.0d));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#numberResponse(double)}
   */
  @Test
  void testBuilderNumberResponse2() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    builderResult.entityResponse(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.numberResponse(10.0d));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#numberResponse(Optional)}
   */
  @Test
  void testBuilderNumberResponse3() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Double> numberResponse = Optional.<Double>of(10.0d);

    // Act and Assert
    assertSame(builderResult, builderResult.numberResponse(numberResponse));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#numberResponse(Optional)}
   */
  @Test
  void testBuilderNumberResponse4() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    builderResult.entityResponse(mock(EntityReference.class));
    Optional<Double> numberResponse = Optional.<Double>of(10.0d);

    // Act and Assert
    assertSame(builderResult, builderResult.numberResponse(numberResponse));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#questionId(Long)}
   */
  @Test
  void testBuilderQuestionId() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();

    // Act
    ImmutableSurveyQuestionResponse.Builder actualQuestionIdResult = builderResult.questionId(1L);

    // Assert
    assertEquals(1L, actualQuestionIdResult.build().questionId().longValue());
    assertEquals(1L, builderResult.build().questionId().longValue());
    assertSame(builderResult, actualQuestionIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#questionId(Long)}
   */
  @Test
  void testBuilderQuestionId2() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    builderResult.entityResponse(mock(EntityReference.class));

    // Act
    ImmutableSurveyQuestionResponse.Builder actualQuestionIdResult = builderResult.questionId(1L);

    // Assert
    assertEquals(1L, actualQuestionIdResult.build().questionId().longValue());
    assertEquals(1L, builderResult.build().questionId().longValue());
    assertSame(builderResult, actualQuestionIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#stringResponse(Optional)}
   */
  @Test
  void testBuilderStringResponse() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<String> stringResponse = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.stringResponse(stringResponse));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Builder#stringResponse(Optional)}
   */
  @Test
  void testBuilderStringResponse2() {
    // Arrange
    ImmutableSurveyQuestionResponse.Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    builderResult.entityResponse(mock(EntityReference.class));
    Optional<String> stringResponse = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.stringResponse(stringResponse));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse#copyOf(SurveyQuestionResponse)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyQuestionResponse instance = mock(SurveyQuestionResponse.class);
    when(instance.questionId()).thenReturn(1L);
    Optional<Boolean> ofResult = Optional.of(true);
    when(instance.booleanResponse()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult2);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.dateResponse()).thenReturn(ofResult3);
    Optional<List<EntityReference>> ofResult4 = Optional.of(new ArrayList<>());
    when(instance.entityListResponse()).thenReturn(ofResult4);
    Optional<EntityReference> ofResult5 = Optional.of(mock(EntityReference.class));
    when(instance.entityResponse()).thenReturn(ofResult5);
    Optional<List<String>> ofResult6 = Optional.of(new ArrayList<>());
    when(instance.listResponse()).thenReturn(ofResult6);
    Optional<Double> ofResult7 = Optional.<Double>of(10.0d);
    when(instance.numberResponse()).thenReturn(ofResult7);
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.stringResponse()).thenReturn(ofResult8);

    // Act
    ImmutableSurveyQuestionResponse actualCopyOfResult = ImmutableSurveyQuestionResponse.copyOf(instance);

    // Assert
    verify(instance).booleanResponse();
    verify(instance).comment();
    verify(instance).dateResponse();
    verify(instance).entityListResponse();
    verify(instance).entityResponse();
    verify(instance).listResponse();
    verify(instance).numberResponse();
    verify(instance).questionId();
    verify(instance).stringResponse();
    assertEquals(1L, actualCopyOfResult.questionId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse#copyOf(SurveyQuestionResponse)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SurveyQuestionResponse instance = mock(SurveyQuestionResponse.class);
    when(instance.questionId()).thenReturn(1L);
    Optional<Boolean> ofResult = Optional.of(true);
    when(instance.booleanResponse()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult2);
    Optional<LocalDate> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.dateResponse()).thenReturn(ofResult3);
    Optional<List<EntityReference>> ofResult4 = Optional.of(new ArrayList<>());
    when(instance.entityListResponse()).thenReturn(ofResult4);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.entityResponse()).thenReturn(emptyResult);
    Optional<List<String>> ofResult5 = Optional.of(new ArrayList<>());
    when(instance.listResponse()).thenReturn(ofResult5);
    Optional<Double> ofResult6 = Optional.<Double>of(10.0d);
    when(instance.numberResponse()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.stringResponse()).thenReturn(ofResult7);

    // Act
    ImmutableSurveyQuestionResponse actualCopyOfResult = ImmutableSurveyQuestionResponse.copyOf(instance);

    // Assert
    verify(instance).booleanResponse();
    verify(instance).comment();
    verify(instance).dateResponse();
    verify(instance).entityListResponse();
    verify(instance).entityResponse();
    verify(instance).listResponse();
    verify(instance).numberResponse();
    verify(instance).questionId();
    verify(instance).stringResponse();
    assertEquals(1L, actualCopyOfResult.questionId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse#copyOf(SurveyQuestionResponse)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    SurveyQuestionResponse instance = mock(SurveyQuestionResponse.class);
    when(instance.questionId()).thenReturn(1L);
    Optional<Boolean> emptyResult = Optional.empty();
    when(instance.booleanResponse()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.dateResponse()).thenReturn(ofResult2);
    Optional<List<EntityReference>> ofResult3 = Optional.of(new ArrayList<>());
    when(instance.entityListResponse()).thenReturn(ofResult3);
    Optional<EntityReference> ofResult4 = Optional.of(mock(EntityReference.class));
    when(instance.entityResponse()).thenReturn(ofResult4);
    Optional<List<String>> ofResult5 = Optional.of(new ArrayList<>());
    when(instance.listResponse()).thenReturn(ofResult5);
    Optional<Double> ofResult6 = Optional.<Double>of(10.0d);
    when(instance.numberResponse()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.stringResponse()).thenReturn(ofResult7);

    // Act
    ImmutableSurveyQuestionResponse actualCopyOfResult = ImmutableSurveyQuestionResponse.copyOf(instance);

    // Assert
    verify(instance).booleanResponse();
    verify(instance).comment();
    verify(instance).dateResponse();
    verify(instance).entityListResponse();
    verify(instance).entityResponse();
    verify(instance).listResponse();
    verify(instance).numberResponse();
    verify(instance).questionId();
    verify(instance).stringResponse();
    assertEquals(1L, actualCopyOfResult.questionId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse#copyOf(SurveyQuestionResponse)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    SurveyQuestionResponse instance = mock(SurveyQuestionResponse.class);
    when(instance.questionId()).thenReturn(1L);
    Optional<Boolean> ofResult = Optional.of(true);
    when(instance.booleanResponse()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.comment()).thenReturn(emptyResult);
    Optional<LocalDate> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.dateResponse()).thenReturn(ofResult2);
    Optional<List<EntityReference>> ofResult3 = Optional.of(new ArrayList<>());
    when(instance.entityListResponse()).thenReturn(ofResult3);
    Optional<EntityReference> ofResult4 = Optional.of(mock(EntityReference.class));
    when(instance.entityResponse()).thenReturn(ofResult4);
    Optional<List<String>> ofResult5 = Optional.of(new ArrayList<>());
    when(instance.listResponse()).thenReturn(ofResult5);
    Optional<Double> ofResult6 = Optional.<Double>of(10.0d);
    when(instance.numberResponse()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.stringResponse()).thenReturn(ofResult7);

    // Act
    ImmutableSurveyQuestionResponse actualCopyOfResult = ImmutableSurveyQuestionResponse.copyOf(instance);

    // Assert
    verify(instance).booleanResponse();
    verify(instance).comment();
    verify(instance).dateResponse();
    verify(instance).entityListResponse();
    verify(instance).entityResponse();
    verify(instance).listResponse();
    verify(instance).numberResponse();
    verify(instance).questionId();
    verify(instance).stringResponse();
    assertEquals(1L, actualCopyOfResult.questionId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse#fromJson(ImmutableSurveyQuestionResponse.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyQuestionResponse.Json json = new ImmutableSurveyQuestionResponse.Json();
    json.setQuestionId(1L);

    // Act and Assert
    assertEquals(1L, ImmutableSurveyQuestionResponse.fromJson(json).questionId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Json#booleanResponse()}
   */
  @Test
  void testJsonBooleanResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyQuestionResponse.Json()).booleanResponse());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionResponse.Json#comment()}
   */
  @Test
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestionResponse.Json()).comment());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Json#dateResponse()}
   */
  @Test
  void testJsonDateResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyQuestionResponse.Json()).dateResponse());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Json#entityListResponse()}
   */
  @Test
  void testJsonEntityListResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyQuestionResponse.Json()).entityListResponse());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Json#entityResponse()}
   */
  @Test
  void testJsonEntityResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyQuestionResponse.Json()).entityResponse());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Json#listResponse()}
   */
  @Test
  void testJsonListResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyQuestionResponse.Json()).listResponse());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyQuestionResponse.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyQuestionResponse.Json actualJson = new ImmutableSurveyQuestionResponse.Json();

    // Assert
    assertNull(actualJson.questionId);
    assertFalse(actualJson.booleanResponse.isPresent());
    assertFalse(actualJson.comment.isPresent());
    assertFalse(actualJson.dateResponse.isPresent());
    assertFalse(actualJson.entityListResponse.isPresent());
    assertFalse(actualJson.entityResponse.isPresent());
    assertFalse(actualJson.listResponse.isPresent());
    assertFalse(actualJson.numberResponse.isPresent());
    assertFalse(actualJson.stringResponse.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Json#numberResponse()}
   */
  @Test
  void testJsonNumberResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyQuestionResponse.Json()).numberResponse());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionResponse.Json#questionId()}
   */
  @Test
  void testJsonQuestionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestionResponse.Json()).questionId());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponse.Json#stringResponse()}
   */
  @Test
  void testJsonStringResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyQuestionResponse.Json()).stringResponse());
  }
}
