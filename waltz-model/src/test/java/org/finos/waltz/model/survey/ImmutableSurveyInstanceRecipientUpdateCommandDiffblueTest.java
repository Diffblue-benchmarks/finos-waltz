package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceRecipientUpdateCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientUpdateCommand.Builder#from(SurveyInstanceRecipientUpdateCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstanceRecipientUpdateCommand.Builder builderResult = ImmutableSurveyInstanceRecipientUpdateCommand
        .builder();
    SurveyInstanceRecipientUpdateCommand instance = mock(SurveyInstanceRecipientUpdateCommand.class);
    when(instance.instanceRecipientId()).thenReturn(1L);
    when(instance.personId()).thenReturn(1L);
    when(instance.surveyInstanceId()).thenReturn(1L);

    // Act
    ImmutableSurveyInstanceRecipientUpdateCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientUpdateCommand.Builder#instanceRecipientId(Long)}
   */
  @Test
  void testBuilderInstanceRecipientId() {
    // Arrange
    ImmutableSurveyInstanceRecipientUpdateCommand.Builder builderResult = ImmutableSurveyInstanceRecipientUpdateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.instanceRecipientId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientUpdateCommand.Builder#personId(Long)}
   */
  @Test
  void testBuilderPersonId() {
    // Arrange
    ImmutableSurveyInstanceRecipientUpdateCommand.Builder builderResult = ImmutableSurveyInstanceRecipientUpdateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.personId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientUpdateCommand.Builder#surveyInstanceId(Long)}
   */
  @Test
  void testBuilderSurveyInstanceId() {
    // Arrange
    ImmutableSurveyInstanceRecipientUpdateCommand.Builder builderResult = ImmutableSurveyInstanceRecipientUpdateCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstanceId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientUpdateCommand#copyOf(SurveyInstanceRecipientUpdateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstanceRecipientUpdateCommand instance = mock(SurveyInstanceRecipientUpdateCommand.class);
    when(instance.instanceRecipientId()).thenReturn(1L);
    when(instance.personId()).thenReturn(1L);
    when(instance.surveyInstanceId()).thenReturn(1L);

    // Act
    ImmutableSurveyInstanceRecipientUpdateCommand actualCopyOfResult = ImmutableSurveyInstanceRecipientUpdateCommand
        .copyOf(instance);

    // Assert
    verify(instance).instanceRecipientId();
    verify(instance).personId();
    verify(instance).surveyInstanceId();
    assertEquals(1L, actualCopyOfResult.instanceRecipientId().longValue());
    assertEquals(1L, actualCopyOfResult.personId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyInstanceId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientUpdateCommand#fromJson(ImmutableSurveyInstanceRecipientUpdateCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyInstanceRecipientUpdateCommand.Json json = new ImmutableSurveyInstanceRecipientUpdateCommand.Json();
    json.setInstanceRecipientId(1L);
    json.setSurveyInstanceId(1L);
    json.setPersonId(1L);

    // Act
    ImmutableSurveyInstanceRecipientUpdateCommand actualFromJsonResult = ImmutableSurveyInstanceRecipientUpdateCommand
        .fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.instanceRecipientId().longValue());
    assertEquals(1L, actualFromJsonResult.personId().longValue());
    assertEquals(1L, actualFromJsonResult.surveyInstanceId().longValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSurveyInstanceRecipientUpdateCommand.Json}
   *   <li>
   * {@link ImmutableSurveyInstanceRecipientUpdateCommand.Json#setInstanceRecipientId(Long)}
   *   <li>
   * {@link ImmutableSurveyInstanceRecipientUpdateCommand.Json#setPersonId(Long)}
   *   <li>
   * {@link ImmutableSurveyInstanceRecipientUpdateCommand.Json#setSurveyInstanceId(Long)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipientUpdateCommand.Json actualJson = new ImmutableSurveyInstanceRecipientUpdateCommand.Json();
    actualJson.setInstanceRecipientId(1L);
    actualJson.setPersonId(1L);
    actualJson.setSurveyInstanceId(1L);

    // Assert
    assertEquals(1L, actualJson.instanceRecipientId.longValue());
    assertEquals(1L, actualJson.personId.longValue());
    assertEquals(1L, actualJson.surveyInstanceId.longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientUpdateCommand.Json#instanceRecipientId()}
   */
  @Test
  void testJsonInstanceRecipientId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceRecipientUpdateCommand.Json()).instanceRecipientId());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientUpdateCommand.Json#personId()}
   */
  @Test
  void testJsonPersonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceRecipientUpdateCommand.Json()).personId());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientUpdateCommand.Json#surveyInstanceId()}
   */
  @Test
  void testJsonSurveyInstanceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceRecipientUpdateCommand.Json()).surveyInstanceId());
  }
}
