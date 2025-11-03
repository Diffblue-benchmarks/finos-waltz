package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceOwnerCreateCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceOwnerCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceOwnerCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(SurveyInstanceOwnerCreateCommand)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build personId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceOwnerCreateCommand); given one; then builder build personId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceOwnerCreateCommand)"})
  void testBuilderFrom_givenOne_thenBuilderBuildPersonIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceOwnerCreateCommand.builder();
    SurveyInstanceOwnerCreateCommand instance = mock(SurveyInstanceOwnerCreateCommand.class);
    when(instance.personId()).thenReturn(1L);
    when(instance.surveyInstanceId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).personId();
    verify(instance).surveyInstanceId();
    ImmutableSurveyInstanceOwnerCreateCommand buildResult = builderResult.build();
    assertEquals(1L, buildResult.personId().longValue());
    assertEquals(1L, buildResult.surveyInstanceId().longValue());
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableSurveyInstanceOwnerCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.personId(1L));
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
    Builder builderResult = ImmutableSurveyInstanceOwnerCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstanceId(1L));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setPersonId(Long)}
   *   <li>{@link Json#setSurveyInstanceId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setPersonId(Long)", "void Json.setSurveyInstanceId(Long)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setPersonId(1L);
    actualJson.setSurveyInstanceId(1L);

    // Assert
    assertEquals(1L, actualJson.personId.longValue());
    assertEquals(1L, actualJson.surveyInstanceId.longValue());
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
