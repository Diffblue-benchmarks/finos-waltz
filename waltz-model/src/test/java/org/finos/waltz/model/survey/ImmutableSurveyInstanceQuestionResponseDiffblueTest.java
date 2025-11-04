package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceQuestionResponseDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceQuestionResponse.Builder#from(SurveyInstanceQuestionResponse)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder builderResult = ImmutableSurveyInstanceQuestionResponse.builder();
    SurveyInstanceQuestionResponse instance = mock(SurveyInstanceQuestionResponse.class);
    ImmutableSurveyQuestionResponse.Json json = new ImmutableSurveyQuestionResponse.Json();
    when(instance.questionResponse()).thenReturn(json);
    when(instance.personId()).thenReturn(1L);
    when(instance.surveyInstanceId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableSurveyInstanceQuestionResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).personId();
    verify(instance).questionResponse();
    verify(instance).surveyInstanceId();
    ImmutableSurveyInstanceQuestionResponse buildResult = builderResult.build();
    assertEquals(1L, buildResult.personId().longValue());
    assertEquals(1L, buildResult.surveyInstanceId().longValue());
    assertSame(json, buildResult.questionResponse());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceQuestionResponse.Builder#from(SurveyInstanceQuestionResponse)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder builderResult = ImmutableSurveyInstanceQuestionResponse.builder();
    SurveyInstanceQuestionResponse instance = mock(SurveyInstanceQuestionResponse.class);
    when(instance.questionResponse()).thenThrow(new IllegalStateException("instance"));
    when(instance.personId()).thenReturn(1L);
    when(instance.surveyInstanceId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).personId();
    verify(instance).questionResponse();
    verify(instance).surveyInstanceId();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceQuestionResponse.Builder#lastUpdatedAt(LocalDateTime)}
   */
  @Test
  void testBuilderLastUpdatedAt() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder builderResult = ImmutableSurveyInstanceQuestionResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceQuestionResponse.Builder#personId(Long)}
   */
  @Test
  void testBuilderPersonId() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder builderResult = ImmutableSurveyInstanceQuestionResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.personId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceQuestionResponse.Builder#questionResponse(SurveyQuestionResponse)}
   */
  @Test
  void testBuilderQuestionResponse() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder builderResult = ImmutableSurveyInstanceQuestionResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.questionResponse(new ImmutableSurveyQuestionResponse.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceQuestionResponse.Builder#questionResponse(SurveyQuestionResponse)}
   */
  @Test
  void testBuilderQuestionResponse2() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder builderResult = ImmutableSurveyInstanceQuestionResponse.builder();

    ImmutableSurveyQuestionResponse.Json questionResponse = new ImmutableSurveyQuestionResponse.Json();
    Optional<EntityReference> entityResponse = Optional.of(mock(EntityReference.class));
    questionResponse.setEntityResponse(entityResponse);

    // Act and Assert
    assertSame(builderResult, builderResult.questionResponse(questionResponse));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceQuestionResponse.Builder#surveyInstanceId(Long)}
   */
  @Test
  void testBuilderSurveyInstanceId() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder builderResult = ImmutableSurveyInstanceQuestionResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstanceId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceQuestionResponse#copyOf(SurveyInstanceQuestionResponse)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstanceQuestionResponse instance = mock(SurveyInstanceQuestionResponse.class);
    ImmutableSurveyQuestionResponse.Json json = new ImmutableSurveyQuestionResponse.Json();
    when(instance.questionResponse()).thenReturn(json);
    when(instance.personId()).thenReturn(1L);
    when(instance.surveyInstanceId()).thenReturn(1L);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());

    // Act
    ImmutableSurveyInstanceQuestionResponse actualCopyOfResult = ImmutableSurveyInstanceQuestionResponse
        .copyOf(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).personId();
    verify(instance).questionResponse();
    verify(instance).surveyInstanceId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(1L, actualCopyOfResult.personId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyInstanceId().longValue());
    assertSame(json, actualCopyOfResult.questionResponse());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceQuestionResponse#fromJson(ImmutableSurveyInstanceQuestionResponse.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Json json = new ImmutableSurveyInstanceQuestionResponse.Json();
    json.setSurveyInstanceId(1L);
    json.setPersonId(1L);
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    ImmutableSurveyQuestionResponse.Json questionResponse = new ImmutableSurveyQuestionResponse.Json();
    json.setQuestionResponse(questionResponse);

    // Act
    ImmutableSurveyInstanceQuestionResponse actualFromJsonResult = ImmutableSurveyInstanceQuestionResponse
        .fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.personId().longValue());
    assertEquals(1L, actualFromJsonResult.surveyInstanceId().longValue());
    assertSame(questionResponse, actualFromJsonResult.questionResponse());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSurveyInstanceQuestionResponse.Json}
   *   <li>
   * {@link ImmutableSurveyInstanceQuestionResponse.Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableSurveyInstanceQuestionResponse.Json#setPersonId(Long)}
   *   <li>
   * {@link ImmutableSurveyInstanceQuestionResponse.Json#setQuestionResponse(SurveyQuestionResponse)}
   *   <li>
   * {@link ImmutableSurveyInstanceQuestionResponse.Json#setSurveyInstanceId(Long)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSurveyInstanceQuestionResponse.Json actualJson = new ImmutableSurveyInstanceQuestionResponse.Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setPersonId(1L);
    actualJson.setQuestionResponse(new ImmutableSurveyQuestionResponse.Json());
    actualJson.setSurveyInstanceId(1L);

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(1L, actualJson.personId.longValue());
    assertEquals(1L, actualJson.surveyInstanceId.longValue());
    assertFalse(((ImmutableSurveyQuestionResponse.Json) actualJson.questionResponse).booleanResponse.isPresent());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceQuestionResponse.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceQuestionResponse.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceQuestionResponse.Json#personId()}
   */
  @Test
  void testJsonPersonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceQuestionResponse.Json()).personId());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceQuestionResponse.Json#questionResponse()}
   */
  @Test
  void testJsonQuestionResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceQuestionResponse.Json()).questionResponse());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceQuestionResponse.Json#surveyInstanceId()}
   */
  @Test
  void testJsonSurveyInstanceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceQuestionResponse.Json()).surveyInstanceId());
  }
}
