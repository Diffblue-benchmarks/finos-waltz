package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.service.workflow.ImmutableSurveyQuestionResponseContextValue.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionResponseContextValueDiffblueTest {
  /**
   * Test {@link ImmutableSurveyQuestionResponseContextValue#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionResponseContextValue#builder()}
   *   <li>{@link ImmutableSurveyQuestionResponseContextValue#comment(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSurveyQuestionResponseContextValue Builder.build()", "Builder Builder.comment(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSurveyQuestionResponseContextValue.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.comment("Comment"));
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionResponseContextValue)}.
   * <ul>
   *   <li>Given {@code Comment}.</li>
   *   <li>Then builder build Comment is {@code Comment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionResponseContextValue)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionResponseContextValue); given 'Comment'; then builder build Comment is 'Comment'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponseContextValue)"})
  void testBuilderFrom_givenComment_thenBuilderBuildCommentIsComment() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextValue.builder();
    SurveyQuestionResponseContextValue instance = mock(SurveyQuestionResponseContextValue.class);
    when(instance.getComment()).thenReturn("Comment");
    when(instance.getValue()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).getComment();
    verify(instance).getValue();
    ImmutableSurveyQuestionResponseContextValue buildResult = builderResult.build();
    assertEquals("42", buildResult.getValue());
    assertEquals("Comment", buildResult.getComment());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionResponseContextValue)}.
   * <ul>
   *   <li>Then builder build Comment is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionResponseContextValue)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionResponseContextValue); then builder build Comment is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponseContextValue)"})
  void testBuilderFrom_thenBuilderBuildCommentIsNull() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextValue.builder();
    SurveyQuestionResponseContextValue instance = mock(SurveyQuestionResponseContextValue.class);
    when(instance.getComment()).thenReturn(null);
    when(instance.getValue()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).getComment();
    verify(instance).getValue();
    ImmutableSurveyQuestionResponseContextValue buildResult = builderResult.build();
    assertEquals("42", buildResult.getValue());
    assertNull(buildResult.getComment());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionResponseContextValue)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionResponseContextValue)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionResponseContextValue); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponseContextValue)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextValue.builder();
    SurveyQuestionResponseContextValue instance = mock(SurveyQuestionResponseContextValue.class);
    when(instance.getComment()).thenThrow(new IllegalStateException("instance"));
    when(instance.getValue()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).getComment();
    verify(instance).getValue();
  }

  /**
   * Test Builder {@link Builder#value(String)}.
   * <p>
   * Method under test: {@link Builder#value(String)}
   */
  @Test
  @DisplayName("Test Builder value(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.value(String)"})
  void testBuilderValue() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextValue.builder();

    // Act
    Builder actualValueResult = builderResult.value("42");

    // Assert
    ImmutableSurveyQuestionResponseContextValue buildResult = builderResult.build();
    assertEquals("42", buildResult.getValue());
    assertNull(buildResult.getComment());
    assertSame(builderResult, actualValueResult);
  }
}
