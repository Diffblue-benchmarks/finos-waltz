package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionResponseContextValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionResponseContextValue#builder()}
   *   <li>{@link ImmutableSurveyQuestionResponseContextValue#comment(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableSurveyQuestionResponseContextValue.Builder actualBuilderResult = ImmutableSurveyQuestionResponseContextValue
        .builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.comment("Comment"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponseContextValue.Builder#from(SurveyQuestionResponseContextValue)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyQuestionResponseContextValue.Builder builderResult = ImmutableSurveyQuestionResponseContextValue
        .builder();
    SurveyQuestionResponseContextValue instance = mock(SurveyQuestionResponseContextValue.class);
    when(instance.getComment()).thenReturn("Comment");
    when(instance.getValue()).thenReturn("42");

    // Act
    ImmutableSurveyQuestionResponseContextValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).getComment();
    verify(instance).getValue();
    ImmutableSurveyQuestionResponseContextValue buildResult = builderResult.build();
    assertEquals("42", buildResult.getValue());
    assertEquals("Comment", buildResult.getComment());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponseContextValue.Builder#from(SurveyQuestionResponseContextValue)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyQuestionResponseContextValue.Builder builderResult = ImmutableSurveyQuestionResponseContextValue
        .builder();
    SurveyQuestionResponseContextValue instance = mock(SurveyQuestionResponseContextValue.class);
    when(instance.getComment()).thenThrow(new IllegalStateException("instance"));
    when(instance.getValue()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).getComment();
    verify(instance).getValue();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponseContextValue.Builder#from(SurveyQuestionResponseContextValue)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyQuestionResponseContextValue.Builder builderResult = ImmutableSurveyQuestionResponseContextValue
        .builder();
    SurveyQuestionResponseContextValue instance = mock(SurveyQuestionResponseContextValue.class);
    when(instance.getComment()).thenReturn(null);
    when(instance.getValue()).thenReturn("42");

    // Act
    ImmutableSurveyQuestionResponseContextValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).getComment();
    verify(instance).getValue();
    ImmutableSurveyQuestionResponseContextValue buildResult = builderResult.build();
    assertEquals("42", buildResult.getValue());
    assertNull(buildResult.getComment());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponseContextValue.Builder#value(String)}
   */
  @Test
  void testBuilderValue() {
    // Arrange
    ImmutableSurveyQuestionResponseContextValue.Builder builderResult = ImmutableSurveyQuestionResponseContextValue
        .builder();

    // Act
    ImmutableSurveyQuestionResponseContextValue.Builder actualValueResult = builderResult.value("42");

    // Assert
    ImmutableSurveyQuestionResponseContextValue buildResult = builderResult.build();
    assertEquals("42", buildResult.getValue());
    assertNull(buildResult.getComment());
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionResponseContextValue#copyOf(SurveyQuestionResponseContextValue)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyQuestionResponseContextValue instance = mock(SurveyQuestionResponseContextValue.class);
    when(instance.getComment()).thenReturn("Comment");
    when(instance.getValue()).thenReturn("42");

    // Act
    ImmutableSurveyQuestionResponseContextValue actualCopyOfResult = ImmutableSurveyQuestionResponseContextValue
        .copyOf(instance);

    // Assert
    verify(instance).getComment();
    verify(instance).getValue();
    assertEquals("42", actualCopyOfResult.getValue());
    assertEquals("Comment", actualCopyOfResult.getComment());
  }
}
