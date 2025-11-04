package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceOwnerCreateCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwnerCreateCommand.Builder#from(SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstanceOwnerCreateCommand.Builder builderResult = ImmutableSurveyInstanceOwnerCreateCommand
        .builder();
    SurveyInstanceOwnerCreateCommand instance = mock(SurveyInstanceOwnerCreateCommand.class);
    when(instance.personId()).thenReturn(1L);
    when(instance.surveyInstanceId()).thenReturn(1L);

    // Act
    ImmutableSurveyInstanceOwnerCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).personId();
    verify(instance).surveyInstanceId();
    ImmutableSurveyInstanceOwnerCreateCommand buildResult = builderResult.build();
    assertEquals(1L, buildResult.personId().longValue());
    assertEquals(1L, buildResult.surveyInstanceId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwnerCreateCommand.Builder#personId(Long)}
   */
  @Test
  void testBuilderPersonId() {
    // Arrange
    ImmutableSurveyInstanceOwnerCreateCommand.Builder builderResult = ImmutableSurveyInstanceOwnerCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.personId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwnerCreateCommand.Builder#surveyInstanceId(Long)}
   */
  @Test
  void testBuilderSurveyInstanceId() {
    // Arrange
    ImmutableSurveyInstanceOwnerCreateCommand.Builder builderResult = ImmutableSurveyInstanceOwnerCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstanceId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwnerCreateCommand#copyOf(SurveyInstanceOwnerCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstanceOwnerCreateCommand instance = mock(SurveyInstanceOwnerCreateCommand.class);
    when(instance.personId()).thenReturn(1L);
    when(instance.surveyInstanceId()).thenReturn(1L);

    // Act
    ImmutableSurveyInstanceOwnerCreateCommand actualCopyOfResult = ImmutableSurveyInstanceOwnerCreateCommand
        .copyOf(instance);

    // Assert
    verify(instance).personId();
    verify(instance).surveyInstanceId();
    assertEquals(1L, actualCopyOfResult.personId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyInstanceId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwnerCreateCommand#fromJson(ImmutableSurveyInstanceOwnerCreateCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyInstanceOwnerCreateCommand.Json json = new ImmutableSurveyInstanceOwnerCreateCommand.Json();
    json.setSurveyInstanceId(1L);
    json.setPersonId(1L);

    // Act
    ImmutableSurveyInstanceOwnerCreateCommand actualFromJsonResult = ImmutableSurveyInstanceOwnerCreateCommand
        .fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.personId().longValue());
    assertEquals(1L, actualFromJsonResult.surveyInstanceId().longValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSurveyInstanceOwnerCreateCommand.Json}
   *   <li>{@link ImmutableSurveyInstanceOwnerCreateCommand.Json#setPersonId(Long)}
   *   <li>
   * {@link ImmutableSurveyInstanceOwnerCreateCommand.Json#setSurveyInstanceId(Long)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSurveyInstanceOwnerCreateCommand.Json actualJson = new ImmutableSurveyInstanceOwnerCreateCommand.Json();
    actualJson.setPersonId(1L);
    actualJson.setSurveyInstanceId(1L);

    // Assert
    assertEquals(1L, actualJson.personId.longValue());
    assertEquals(1L, actualJson.surveyInstanceId.longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwnerCreateCommand.Json#personId()}
   */
  @Test
  void testJsonPersonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceOwnerCreateCommand.Json()).personId());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwnerCreateCommand.Json#surveyInstanceId()}
   */
  @Test
  void testJsonSurveyInstanceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceOwnerCreateCommand.Json()).surveyInstanceId());
  }
}
