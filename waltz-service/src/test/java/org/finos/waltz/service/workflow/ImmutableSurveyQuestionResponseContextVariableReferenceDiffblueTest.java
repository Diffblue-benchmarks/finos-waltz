package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.service.workflow.ImmutableSurveyQuestionResponseContextVariableReference.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionResponseContextVariableReferenceDiffblueTest {
  /**
   * Test Builder {@link Builder#externalId(String)}.
   * <p>
   * Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Test Builder {@link Builder#from(ContextVariableReference)} with {@code ContextVariableReference}.
   * <p>
   * Method under test: {@link Builder#from(ContextVariableReference)}
   */
  @Test
  @DisplayName("Test Builder from(ContextVariableReference) with 'ContextVariableReference'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ContextVariableReference)"})
  void testBuilderFromWithContextVariableReference() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference.builder();
    ContextVariableReference instance = mock(ContextVariableReference.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));
    when(instance.externalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(ContextVariableReference)} with {@code ContextVariableReference}.
   * <p>
   * Method under test: {@link Builder#from(ContextVariableReference)}
   */
  @Test
  @DisplayName("Test Builder from(ContextVariableReference) with 'ContextVariableReference'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ContextVariableReference)"})
  void testBuilderFromWithContextVariableReference2() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference.builder();
    ContextVariableReference instance = mock(ContextVariableReference.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(ContextVariableReference)} with {@code ContextVariableReference}.
   * <ul>
   *   <li>Given {@code ALL}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ContextVariableReference)}
   */
  @Test
  @DisplayName("Test Builder from(ContextVariableReference) with 'ContextVariableReference'; given 'ALL'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ContextVariableReference)"})
  void testBuilderFromWithContextVariableReference_givenAll_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference.builder();
    ContextVariableReference instance = mock(ContextVariableReference.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.externalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionResponseContextVariableReference)} with {@code SurveyQuestionResponseContextVariableReference}.
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionResponseContextVariableReference)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionResponseContextVariableReference) with 'SurveyQuestionResponseContextVariableReference'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponseContextVariableReference)"})
  void testBuilderFromWithSurveyQuestionResponseContextVariableReference() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference.builder();
    SurveyQuestionResponseContextVariableReference instance = mock(
        SurveyQuestionResponseContextVariableReference.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.externalId()).thenReturn("42");
    when(instance.surveyExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(SurveyQuestionResponseContextVariableReference)} with {@code SurveyQuestionResponseContextVariableReference}.
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionResponseContextVariableReference)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionResponseContextVariableReference) with 'SurveyQuestionResponseContextVariableReference'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponseContextVariableReference)"})
  void testBuilderFromWithSurveyQuestionResponseContextVariableReference2() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference.builder();
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
   * Test Builder {@link Builder#kind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#kind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.kind(EntityKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#surveyExternalId(String)}.
   * <p>
   * Method under test: {@link Builder#surveyExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder surveyExternalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.surveyExternalId(String)"})
  void testBuilderSurveyExternalId() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextVariableReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyExternalId("42"));
  }
}
