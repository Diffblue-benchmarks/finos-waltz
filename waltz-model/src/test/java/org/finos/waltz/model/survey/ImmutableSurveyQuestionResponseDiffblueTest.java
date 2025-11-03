package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionResponse.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionResponseDiffblueTest {
  /**
   * Test Builder {@link Builder#booleanResponse(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link Builder#booleanResponse(boolean)}
   */
  @Test
  @DisplayName("Test Builder booleanResponse(boolean) with 'boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.booleanResponse(boolean)"})
  void testBuilderBooleanResponseWithBoolean() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.booleanResponse(true));
  }

  /**
   * Test Builder {@link Builder#booleanResponse(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#booleanResponse(Optional)}
   */
  @Test
  @DisplayName("Test Builder booleanResponse(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.booleanResponse(Optional)"})
  void testBuilderBooleanResponseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    // Act and Assert
    assertSame(builderResult, builderResult.booleanResponse(booleanResponse));
  }

  /**
   * Test Builder {@link Builder#comment(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#comment(Optional)}
   */
  @Test
  @DisplayName("Test Builder comment(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.comment(Optional)"})
  void testBuilderCommentWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<String> comment = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.comment(comment));
  }

  /**
   * Test Builder {@link Builder#dateResponse(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#dateResponse(Optional)}
   */
  @Test
  @DisplayName("Test Builder dateResponse(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dateResponse(Optional)"})
  void testBuilderDateResponseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<? extends LocalDate> dateResponse = Optional.of(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertSame(builderResult, builderResult.dateResponse(dateResponse));
  }

  /**
   * Test Builder {@link Builder#entityListResponse(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#entityListResponse(Optional)}
   */
  @Test
  @DisplayName("Test Builder entityListResponse(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityListResponse(Optional)"})
  void testBuilderEntityListResponseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<? extends List<EntityReference>> entityListResponse = Optional.of(new ArrayList<>());

    // Act and Assert
    assertSame(builderResult, builderResult.entityListResponse(entityListResponse));
  }

  /**
   * Test Builder {@link Builder#entityResponse(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#entityResponse(Optional)}
   */
  @Test
  @DisplayName("Test Builder entityResponse(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityResponse(Optional)"})
  void testBuilderEntityResponseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<? extends EntityReference> entityResponse = Optional.of(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.entityResponse(entityResponse));
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionResponse)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link SurveyQuestionResponse} {@link SurveyQuestionResponse#booleanResponse()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionResponse); given empty; when SurveyQuestionResponse booleanResponse() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponse)"})
  void testBuilderFrom_givenEmpty_whenSurveyQuestionResponseBooleanResponseReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    assertEquals(1L, builderResult.build().questionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionResponse)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionResponse); given Optional with 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponse)"})
  void testBuilderFrom_givenOptionalWithTrue() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    assertEquals(1L, builderResult.build().questionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionResponse)}.
   * <ul>
   *   <li>When {@link SurveyQuestionResponse} {@link SurveyQuestionResponse#comment()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionResponse); when SurveyQuestionResponse comment() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponse)"})
  void testBuilderFrom_whenSurveyQuestionResponseCommentReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    assertEquals(1L, builderResult.build().questionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionResponse)}.
   * <ul>
   *   <li>When {@link SurveyQuestionResponse} {@link SurveyQuestionResponse#dateResponse()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionResponse); when SurveyQuestionResponse dateResponse() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponse)"})
  void testBuilderFrom_whenSurveyQuestionResponseDateResponseReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    assertEquals(1L, builderResult.build().questionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionResponse)}.
   * <ul>
   *   <li>When {@link SurveyQuestionResponse} {@link SurveyQuestionResponse#entityListResponse()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionResponse); when SurveyQuestionResponse entityListResponse() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponse)"})
  void testBuilderFrom_whenSurveyQuestionResponseEntityListResponseReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    assertEquals(1L, builderResult.build().questionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionResponse)}.
   * <ul>
   *   <li>When {@link SurveyQuestionResponse} {@link SurveyQuestionResponse#entityResponse()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionResponse); when SurveyQuestionResponse entityResponse() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponse)"})
  void testBuilderFrom_whenSurveyQuestionResponseEntityResponseReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    assertEquals(1L, builderResult.build().questionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#listResponse(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#listResponse(Optional)}
   */
  @Test
  @DisplayName("Test Builder listResponse(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.listResponse(Optional)"})
  void testBuilderListResponseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<? extends List<String>> listResponse = Optional.of(new ArrayList<>());

    // Act and Assert
    assertSame(builderResult, builderResult.listResponse(listResponse));
  }

  /**
   * Test Builder {@link Builder#numberResponse(double)} with {@code double}.
   * <p>
   * Method under test: {@link Builder#numberResponse(double)}
   */
  @Test
  @DisplayName("Test Builder numberResponse(double) with 'double'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.numberResponse(double)"})
  void testBuilderNumberResponseWithDouble() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.numberResponse(10.0d));
  }

  /**
   * Test Builder {@link Builder#numberResponse(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#numberResponse(Optional)}
   */
  @Test
  @DisplayName("Test Builder numberResponse(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.numberResponse(Optional)"})
  void testBuilderNumberResponseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Double> numberResponse = Optional.<Double>of(10.0d);

    // Act and Assert
    assertSame(builderResult, builderResult.numberResponse(numberResponse));
  }

  /**
   * Test Builder {@link Builder#questionId(Long)}.
   * <p>
   * Method under test: {@link Builder#questionId(Long)}
   */
  @Test
  @DisplayName("Test Builder questionId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.questionId(Long)"})
  void testBuilderQuestionId() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();

    // Act
    Builder actualQuestionIdResult = builderResult.questionId(1L);

    // Assert
    assertEquals(1L, builderResult.build().questionId().longValue());
    assertSame(builderResult, actualQuestionIdResult);
  }

  /**
   * Test Builder {@link Builder#stringResponse(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#stringResponse(Optional)}
   */
  @Test
  @DisplayName("Test Builder stringResponse(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.stringResponse(Optional)"})
  void testBuilderStringResponseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<String> stringResponse = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.stringResponse(stringResponse));
  }

  /**
   * Test Json {@link Json#booleanResponse()}.
   * <p>
   * Method under test: {@link Json#booleanResponse()}
   */
  @Test
  @DisplayName("Test Json booleanResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.booleanResponse()"})
  void testJsonBooleanResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).booleanResponse());
  }

  /**
   * Test Json {@link Json#comment()}.
   * <p>
   * Method under test: {@link Json#comment()}
   */
  @Test
  @DisplayName("Test Json comment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).comment());
  }

  /**
   * Test Json {@link Json#dateResponse()}.
   * <p>
   * Method under test: {@link Json#dateResponse()}
   */
  @Test
  @DisplayName("Test Json dateResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.dateResponse()"})
  void testJsonDateResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dateResponse());
  }

  /**
   * Test Json {@link Json#entityListResponse()}.
   * <p>
   * Method under test: {@link Json#entityListResponse()}
   */
  @Test
  @DisplayName("Test Json entityListResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.entityListResponse()"})
  void testJsonEntityListResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityListResponse());
  }

  /**
   * Test Json {@link Json#entityResponse()}.
   * <p>
   * Method under test: {@link Json#entityResponse()}
   */
  @Test
  @DisplayName("Test Json entityResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.entityResponse()"})
  void testJsonEntityResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityResponse());
  }

  /**
   * Test Json {@link Json#listResponse()}.
   * <p>
   * Method under test: {@link Json#listResponse()}
   */
  @Test
  @DisplayName("Test Json listResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.listResponse()"})
  void testJsonListResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).listResponse());
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
   * Test Json {@link Json#numberResponse()}.
   * <p>
   * Method under test: {@link Json#numberResponse()}
   */
  @Test
  @DisplayName("Test Json numberResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.numberResponse()"})
  void testJsonNumberResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).numberResponse());
  }

  /**
   * Test Json {@link Json#questionId()}.
   * <p>
   * Method under test: {@link Json#questionId()}
   */
  @Test
  @DisplayName("Test Json questionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.questionId()"})
  void testJsonQuestionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).questionId());
  }

  /**
   * Test Json {@link Json#stringResponse()}.
   * <p>
   * Method under test: {@link Json#stringResponse()}
   */
  @Test
  @DisplayName("Test Json stringResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.stringResponse()"})
  void testJsonStringResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).stringResponse());
  }
}
