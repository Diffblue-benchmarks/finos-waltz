package org.finos.waltz.service.workflow.side_effect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingUpdateSideEffectDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingUpdateSideEffect.Builder#assessmentDefinitionExternalId(String)}
   */
  @Test
  void testBuilderAssessmentDefinitionExternalId() {
    // Arrange
    ImmutableAssessmentRatingUpdateSideEffect.Builder builderResult = ImmutableAssessmentRatingUpdateSideEffect
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentDefinitionExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingUpdateSideEffect.Builder#from(AssessmentRatingUpdateSideEffect)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRatingUpdateSideEffect.Builder builderResult = ImmutableAssessmentRatingUpdateSideEffect
        .builder();
    AssessmentRatingUpdateSideEffect instance = mock(AssessmentRatingUpdateSideEffect.class);
    when(instance.ratingSchemeItemExternalId()).thenReturn("42");
    when(instance.assessmentDefinitionExternalId()).thenReturn("42");

    // Act
    ImmutableAssessmentRatingUpdateSideEffect.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitionExternalId();
    verify(instance).ratingSchemeItemExternalId();
    ImmutableAssessmentRatingUpdateSideEffect buildResult = builderResult.build();
    assertEquals("42", buildResult.assessmentDefinitionExternalId());
    assertEquals("42", buildResult.ratingSchemeItemExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingUpdateSideEffect.Builder#from(AssessmentRatingUpdateSideEffect)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentRatingUpdateSideEffect.Builder builderResult = ImmutableAssessmentRatingUpdateSideEffect
        .builder();
    AssessmentRatingUpdateSideEffect instance = mock(AssessmentRatingUpdateSideEffect.class);
    when(instance.ratingSchemeItemExternalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.assessmentDefinitionExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentDefinitionExternalId();
    verify(instance).ratingSchemeItemExternalId();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingUpdateSideEffect.Builder#from(AssessmentRatingUpdateSideEffect)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentRatingUpdateSideEffect.Builder builderResult = ImmutableAssessmentRatingUpdateSideEffect
        .builder();
    AssessmentRatingUpdateSideEffect instance = mock(AssessmentRatingUpdateSideEffect.class);
    when(instance.assessmentDefinitionExternalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentDefinitionExternalId();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingUpdateSideEffect.Builder#ratingSchemeItemExternalId(String)}
   */
  @Test
  void testBuilderRatingSchemeItemExternalId() {
    // Arrange
    ImmutableAssessmentRatingUpdateSideEffect.Builder builderResult = ImmutableAssessmentRatingUpdateSideEffect
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeItemExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingUpdateSideEffect#copyOf(AssessmentRatingUpdateSideEffect)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRatingUpdateSideEffect instance = mock(AssessmentRatingUpdateSideEffect.class);
    when(instance.ratingSchemeItemExternalId()).thenReturn("42");
    when(instance.assessmentDefinitionExternalId()).thenReturn("42");

    // Act
    ImmutableAssessmentRatingUpdateSideEffect actualCopyOfResult = ImmutableAssessmentRatingUpdateSideEffect
        .copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitionExternalId();
    verify(instance).ratingSchemeItemExternalId();
    assertEquals("42", actualCopyOfResult.assessmentDefinitionExternalId());
    assertEquals("42", actualCopyOfResult.ratingSchemeItemExternalId());
  }
}
