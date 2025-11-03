package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceQuestionResponse.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceQuestionResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceQuestionResponseDiffblueTest {
  /**
   * Test Builder {@link Builder#from(SurveyInstanceQuestionResponse)}.
   * <ul>
   *   <li>Given {@link ImmutableSurveyQuestionResponse.Json} (default constructor).</li>
   *   <li>Then builder build personId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceQuestionResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceQuestionResponse); given Json (default constructor); then builder build personId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceQuestionResponse)"})
  void testBuilderFrom_givenJson_thenBuilderBuildPersonIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceQuestionResponse.builder();
    SurveyInstanceQuestionResponse instance = mock(SurveyInstanceQuestionResponse.class);
    ImmutableSurveyQuestionResponse.Json json = new ImmutableSurveyQuestionResponse.Json();
    when(instance.questionResponse()).thenReturn(json);
    when(instance.personId()).thenReturn(1L);
    when(instance.surveyInstanceId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(SurveyInstanceQuestionResponse)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceQuestionResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceQuestionResponse); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceQuestionResponse)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceQuestionResponse.builder();
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
   * Test Builder {@link Builder#lastUpdatedAt(LocalDateTime)}.
   * <p>
   * Method under test: {@link Builder#lastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedAt(LocalDateTime)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastUpdatedAt(LocalDateTime)"})
  void testBuilderLastUpdatedAt() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceQuestionResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Test Builder {@link Builder#personId(Long)}.
   * <p>
   * Method under test: {@link Builder#personId(Long)}
   */
  @Test
  @DisplayName("Test Builder personId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.personId(Long)"})
  void testBuilderPersonId() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceQuestionResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.personId(1L));
  }

  /**
   * Test Builder {@link Builder#questionResponse(SurveyQuestionResponse)}.
   * <ul>
   *   <li>When {@link ImmutableSurveyQuestionResponse.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#questionResponse(SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test Builder questionResponse(SurveyQuestionResponse); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.questionResponse(SurveyQuestionResponse)"})
  void testBuilderQuestionResponse_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceQuestionResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.questionResponse(new ImmutableSurveyQuestionResponse.Json()));
  }

  /**
   * Test Builder {@link Builder#surveyInstanceId(Long)}.
   * <p>
   * Method under test: {@link Builder#surveyInstanceId(Long)}
   */
  @Test
  @DisplayName("Test Builder surveyInstanceId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.surveyInstanceId(Long)"})
  void testBuilderSurveyInstanceId() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceQuestionResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstanceId(1L));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link Json#setPersonId(Long)}
   *   <li>{@link Json#setQuestionResponse(SurveyQuestionResponse)}
   *   <li>{@link Json#setSurveyInstanceId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setLastUpdatedAt(LocalDateTime)", "void Json.setPersonId(Long)",
      "void Json.setQuestionResponse(SurveyQuestionResponse)", "void Json.setSurveyInstanceId(Long)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
   * Test Json {@link Json#lastUpdatedAt()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#personId()}.
   * <p>
   * Method under test: {@link Json#personId()}
   */
  @Test
  @DisplayName("Test Json personId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.personId()"})
  void testJsonPersonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).personId());
  }

  /**
   * Test Json {@link Json#questionResponse()}.
   * <p>
   * Method under test: {@link Json#questionResponse()}
   */
  @Test
  @DisplayName("Test Json questionResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyQuestionResponse Json.questionResponse()"})
  void testJsonQuestionResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).questionResponse());
  }

  /**
   * Test Json {@link Json#surveyInstanceId()}.
   * <p>
   * Method under test: {@link Json#surveyInstanceId()}
   */
  @Test
  @DisplayName("Test Json surveyInstanceId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.surveyInstanceId()"})
  void testJsonSurveyInstanceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).surveyInstanceId());
  }
}
