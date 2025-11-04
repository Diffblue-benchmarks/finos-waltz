package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceRecipientCreateCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientCreateCommand.Builder#from(SurveyInstanceRecipientCreateCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstanceRecipientCreateCommand.Builder builderResult = ImmutableSurveyInstanceRecipientCreateCommand
        .builder();
    SurveyInstanceRecipientCreateCommand instance = mock(SurveyInstanceRecipientCreateCommand.class);
    when(instance.personId()).thenReturn(1L);
    when(instance.surveyInstanceId()).thenReturn(1L);

    // Act
    ImmutableSurveyInstanceRecipientCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).personId();
    verify(instance).surveyInstanceId();
    ImmutableSurveyInstanceRecipientCreateCommand buildResult = builderResult.build();
    assertEquals(1L, buildResult.personId().longValue());
    assertEquals(1L, buildResult.surveyInstanceId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientCreateCommand.Builder#personId(Long)}
   */
  @Test
  void testBuilderPersonId() {
    // Arrange
    ImmutableSurveyInstanceRecipientCreateCommand.Builder builderResult = ImmutableSurveyInstanceRecipientCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.personId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientCreateCommand.Builder#surveyInstanceId(Long)}
   */
  @Test
  void testBuilderSurveyInstanceId() {
    // Arrange
    ImmutableSurveyInstanceRecipientCreateCommand.Builder builderResult = ImmutableSurveyInstanceRecipientCreateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstanceId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientCreateCommand#copyOf(SurveyInstanceRecipientCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstanceRecipientCreateCommand instance = mock(SurveyInstanceRecipientCreateCommand.class);
    when(instance.personId()).thenReturn(1L);
    when(instance.surveyInstanceId()).thenReturn(1L);

    // Act
    ImmutableSurveyInstanceRecipientCreateCommand actualCopyOfResult = ImmutableSurveyInstanceRecipientCreateCommand
        .copyOf(instance);

    // Assert
    verify(instance).personId();
    verify(instance).surveyInstanceId();
    assertEquals(1L, actualCopyOfResult.personId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyInstanceId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientCreateCommand#fromJson(ImmutableSurveyInstanceRecipientCreateCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyInstanceRecipientCreateCommand.Json json = new ImmutableSurveyInstanceRecipientCreateCommand.Json();
    json.setSurveyInstanceId(1L);
    json.setPersonId(1L);

    // Act
    ImmutableSurveyInstanceRecipientCreateCommand actualFromJsonResult = ImmutableSurveyInstanceRecipientCreateCommand
        .fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.personId().longValue());
    assertEquals(1L, actualFromJsonResult.surveyInstanceId().longValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSurveyInstanceRecipientCreateCommand.Json}
   *   <li>
   * {@link ImmutableSurveyInstanceRecipientCreateCommand.Json#setPersonId(Long)}
   *   <li>
   * {@link ImmutableSurveyInstanceRecipientCreateCommand.Json#setSurveyInstanceId(Long)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipientCreateCommand.Json actualJson = new ImmutableSurveyInstanceRecipientCreateCommand.Json();
    actualJson.setPersonId(1L);
    actualJson.setSurveyInstanceId(1L);

    // Assert
    assertEquals(1L, actualJson.personId.longValue());
    assertEquals(1L, actualJson.surveyInstanceId.longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientCreateCommand.Json#personId()}
   */
  @Test
  void testJsonPersonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceRecipientCreateCommand.Json()).personId());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientCreateCommand.Json#surveyInstanceId()}
   */
  @Test
  void testJsonSurveyInstanceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceRecipientCreateCommand.Json()).surveyInstanceId());
  }
}
