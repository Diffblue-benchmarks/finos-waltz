package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionResponseContextVariableReferenceDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponseContextVariableReference.Builder#externalId(String)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference.Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponseContextVariableReference.Builder#from(ContextVariableReference)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference.Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference
        .builder();
    ContextVariableReference instance = mock(ContextVariableReference.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.externalId()).thenReturn("42");

    // Act
    ImmutableSurveyQuestionResponseContextVariableReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponseContextVariableReference.Builder#from(ContextVariableReference)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference.Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference
        .builder();
    ContextVariableReference instance = mock(ContextVariableReference.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));
    when(instance.externalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponseContextVariableReference.Builder#from(ContextVariableReference)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference.Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference
        .builder();
    ContextVariableReference instance = mock(ContextVariableReference.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponseContextVariableReference.Builder#from(SurveyQuestionResponseContextVariableReference)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference.Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference
        .builder();
    SurveyQuestionResponseContextVariableReference instance = mock(
        SurveyQuestionResponseContextVariableReference.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.externalId()).thenReturn("42");
    when(instance.surveyExternalId()).thenReturn("42");

    // Act
    ImmutableSurveyQuestionResponseContextVariableReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).surveyExternalId();
    ImmutableSurveyQuestionResponseContextVariableReference buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("42", buildResult.surveyExternalId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponseContextVariableReference.Builder#from(SurveyQuestionResponseContextVariableReference)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference.Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference
        .builder();
    SurveyQuestionResponseContextVariableReference instance = mock(
        SurveyQuestionResponseContextVariableReference.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));
    when(instance.externalId()).thenReturn("42");
    when(instance.surveyExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).surveyExternalId();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponseContextVariableReference.Builder#kind(EntityKind)}
   */
  @Test
  void testBuilderKind() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference.Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponseContextVariableReference.Builder#surveyExternalId(String)}
   */
  @Test
  void testBuilderSurveyExternalId() {
    // Arrange
    ImmutableSurveyQuestionResponseContextVariableReference.Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponseContextVariableReference#copyOf(SurveyQuestionResponseContextVariableReference)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyQuestionResponseContextVariableReference instance = mock(
        SurveyQuestionResponseContextVariableReference.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.externalId()).thenReturn("42");
    when(instance.surveyExternalId()).thenReturn("42");

    // Act
    ImmutableSurveyQuestionResponseContextVariableReference actualCopyOfResult = ImmutableSurveyQuestionResponseContextVariableReference
        .copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).surveyExternalId();
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("42", actualCopyOfResult.surveyExternalId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }
}
