package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceRecipientUpdateCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceRecipientUpdateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceRecipientUpdateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(SurveyInstanceRecipientUpdateCommand)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build instanceRecipientId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceRecipientUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceRecipientUpdateCommand); given one; then builder build instanceRecipientId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceRecipientUpdateCommand)"})
  void testBuilderFrom_givenOne_thenBuilderBuildInstanceRecipientIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientUpdateCommand.builder();
    SurveyInstanceRecipientUpdateCommand instance = mock(SurveyInstanceRecipientUpdateCommand.class);
    when(instance.instanceRecipientId()).thenReturn(1L);
    when(instance.personId()).thenReturn(1L);
    when(instance.surveyInstanceId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).instanceRecipientId();
    verify(instance).personId();
    verify(instance).surveyInstanceId();
    ImmutableSurveyInstanceRecipientUpdateCommand buildResult = builderResult.build();
    assertEquals(1L, buildResult.instanceRecipientId().longValue());
    assertEquals(1L, buildResult.personId().longValue());
    assertEquals(1L, buildResult.surveyInstanceId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#instanceRecipientId(Long)}.
   * <p>
   * Method under test: {@link Builder#instanceRecipientId(Long)}
   */
  @Test
  @DisplayName("Test Builder instanceRecipientId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.instanceRecipientId(Long)"})
  void testBuilderInstanceRecipientId() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceRecipientUpdateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.instanceRecipientId(1L));
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
    Builder builderResult = ImmutableSurveyInstanceRecipientUpdateCommand.builder();

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
    Builder builderResult = ImmutableSurveyInstanceRecipientUpdateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstanceId(1L));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setInstanceRecipientId(Long)}
   *   <li>{@link Json#setPersonId(Long)}
   *   <li>{@link Json#setSurveyInstanceId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setInstanceRecipientId(Long)", "void Json.setPersonId(Long)",
      "void Json.setSurveyInstanceId(Long)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setInstanceRecipientId(1L);
    actualJson.setPersonId(1L);
    actualJson.setSurveyInstanceId(1L);

    // Assert
    assertEquals(1L, actualJson.instanceRecipientId.longValue());
    assertEquals(1L, actualJson.personId.longValue());
    assertEquals(1L, actualJson.surveyInstanceId.longValue());
  }

  /**
   * Test Json {@link Json#instanceRecipientId()}.
   * <p>
   * Method under test: {@link Json#instanceRecipientId()}
   */
  @Test
  @DisplayName("Test Json instanceRecipientId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.instanceRecipientId()"})
  void testJsonInstanceRecipientId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).instanceRecipientId());
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
