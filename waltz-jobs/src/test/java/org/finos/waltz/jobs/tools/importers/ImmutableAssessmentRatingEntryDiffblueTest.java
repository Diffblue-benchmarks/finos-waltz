package org.finos.waltz.jobs.tools.importers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingEntryDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingEntry.Builder#description(String)}
   */
  @Test
  void testBuilderDescription() {
    // Arrange
    ImmutableAssessmentRatingEntry.Builder builderResult = ImmutableAssessmentRatingEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingEntry.Builder#entity(EntityReference)}
   */
  @Test
  void testBuilderEntity() {
    // Arrange
    ImmutableAssessmentRatingEntry.Builder builderResult = ImmutableAssessmentRatingEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entity(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingEntry.Builder#from(AssessmentRatingEntry)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRatingEntry.Builder builderResult = ImmutableAssessmentRatingEntry.builder();
    AssessmentRatingEntry instance = mock(AssessmentRatingEntry.class);
    when(instance.entity()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entity();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingEntry.Builder#from(AssessmentRatingEntry)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentRatingEntry.Builder builderResult = ImmutableAssessmentRatingEntry.builder();
    AssessmentRatingEntry instance = mock(AssessmentRatingEntry.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableAssessmentRatingEntry.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entity();
    verify(instance).ratingId();
    ImmutableAssessmentRatingEntry buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.ratingId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingEntry.Builder#from(AssessmentRatingEntry)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentRatingEntry.Builder builderResult = ImmutableAssessmentRatingEntry.builder();
    AssessmentRatingEntry instance = mock(AssessmentRatingEntry.class);
    when(instance.ratingId()).thenThrow(new IllegalStateException("instance"));
    when(instance.entity()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entity();
    verify(instance).ratingId();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingEntry.Builder#ratingId(Long)}
   */
  @Test
  void testBuilderRatingId() {
    // Arrange
    ImmutableAssessmentRatingEntry.Builder builderResult = ImmutableAssessmentRatingEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingEntry#copyOf(AssessmentRatingEntry)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRatingEntry instance = mock(AssessmentRatingEntry.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entity()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableAssessmentRatingEntry actualCopyOfResult = ImmutableAssessmentRatingEntry.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entity();
    verify(instance).ratingId();
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ratingId().longValue());
  }
}
