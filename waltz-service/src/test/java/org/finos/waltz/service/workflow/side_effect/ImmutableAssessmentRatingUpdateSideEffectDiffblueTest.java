package org.finos.waltz.service.workflow.side_effect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.service.workflow.side_effect.ImmutableAssessmentRatingUpdateSideEffect.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingUpdateSideEffectDiffblueTest {
  /**
   * Test Builder {@link Builder#assessmentDefinitionExternalId(String)}.
   * <p>
   * Method under test: {@link Builder#assessmentDefinitionExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder assessmentDefinitionExternalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessmentDefinitionExternalId(String)"})
  void testBuilderAssessmentDefinitionExternalId() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingUpdateSideEffect.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentDefinitionExternalId("42"));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingUpdateSideEffect)}.
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingUpdateSideEffect)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingUpdateSideEffect)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingUpdateSideEffect)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingUpdateSideEffect.builder();
    AssessmentRatingUpdateSideEffect instance = mock(AssessmentRatingUpdateSideEffect.class);
    when(instance.ratingSchemeItemExternalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.assessmentDefinitionExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentDefinitionExternalId();
    verify(instance).ratingSchemeItemExternalId();
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingUpdateSideEffect)}.
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingUpdateSideEffect)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingUpdateSideEffect)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingUpdateSideEffect)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingUpdateSideEffect.builder();
    AssessmentRatingUpdateSideEffect instance = mock(AssessmentRatingUpdateSideEffect.class);
    when(instance.assessmentDefinitionExternalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentDefinitionExternalId();
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingUpdateSideEffect)}.
   * <ul>
   *   <li>Then builder build assessmentDefinitionExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingUpdateSideEffect)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingUpdateSideEffect); then builder build assessmentDefinitionExternalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingUpdateSideEffect)"})
  void testBuilderFrom_thenBuilderBuildAssessmentDefinitionExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingUpdateSideEffect.builder();
    AssessmentRatingUpdateSideEffect instance = mock(AssessmentRatingUpdateSideEffect.class);
    when(instance.ratingSchemeItemExternalId()).thenReturn("42");
    when(instance.assessmentDefinitionExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitionExternalId();
    verify(instance).ratingSchemeItemExternalId();
    ImmutableAssessmentRatingUpdateSideEffect buildResult = builderResult.build();
    assertEquals("42", buildResult.assessmentDefinitionExternalId());
    assertEquals("42", buildResult.ratingSchemeItemExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingSchemeItemExternalId(String)}.
   * <p>
   * Method under test: {@link Builder#ratingSchemeItemExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeItemExternalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingSchemeItemExternalId(String)"})
  void testBuilderRatingSchemeItemExternalId() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingUpdateSideEffect.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeItemExternalId("42"));
  }
}
