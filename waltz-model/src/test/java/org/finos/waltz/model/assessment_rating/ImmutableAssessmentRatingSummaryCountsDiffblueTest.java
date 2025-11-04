package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.model.tally.Tally;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingSummaryCountsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingSummaryCounts.Builder#addAllRatingCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingCounts() {
    // Arrange
    ImmutableAssessmentRatingSummaryCounts.Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingSummaryCounts.Builder#addRatingCounts(Tally)}
   */
  @Test
  void testBuilderAddRatingCounts() {
    // Arrange
    ImmutableAssessmentRatingSummaryCounts.Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingCounts(mock(Tally.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingSummaryCounts.Builder#addRatingCounts(Tally[])}
   */
  @Test
  void testBuilderAddRatingCounts2() {
    // Arrange
    ImmutableAssessmentRatingSummaryCounts.Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingCounts(mock(Tally.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingSummaryCounts.Builder#definitionId(long)}
   */
  @Test
  void testBuilderDefinitionId() {
    // Arrange
    ImmutableAssessmentRatingSummaryCounts.Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    // Act
    ImmutableAssessmentRatingSummaryCounts.Builder actualDefinitionIdResult = builderResult.definitionId(1L);

    // Assert
    assertEquals(1L, builderResult.build().definitionId());
    assertSame(builderResult, actualDefinitionIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingSummaryCounts.Builder#definitionId(long)}
   */
  @Test
  void testBuilderDefinitionId2() {
    // Arrange
    ImmutableAssessmentRatingSummaryCounts.Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();
    builderResult.addRatingCounts(mock(Tally.class));

    // Act
    ImmutableAssessmentRatingSummaryCounts.Builder actualDefinitionIdResult = builderResult.definitionId(1L);

    // Assert
    ImmutableAssessmentRatingSummaryCounts buildResult = builderResult.build();
    assertEquals(1, buildResult.ratingCounts().size());
    assertEquals(1L, buildResult.definitionId());
    assertSame(builderResult, actualDefinitionIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingSummaryCounts.Builder#from(AssessmentRatingSummaryCounts)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRatingSummaryCounts.Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();
    AssessmentRatingSummaryCounts instance = mock(AssessmentRatingSummaryCounts.class);
    when(instance.ratingCounts()).thenReturn(new HashSet<>());
    when(instance.definitionId()).thenReturn(1L);

    // Act
    ImmutableAssessmentRatingSummaryCounts.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definitionId();
    verify(instance).ratingCounts();
    assertEquals(1L, builderResult.build().definitionId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingSummaryCounts.Builder#from(AssessmentRatingSummaryCounts)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentRatingSummaryCounts.Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    HashSet<Tally<Long>> tallySet = new HashSet<>();
    tallySet.add(mock(Tally.class));
    AssessmentRatingSummaryCounts instance = mock(AssessmentRatingSummaryCounts.class);
    when(instance.ratingCounts()).thenReturn(tallySet);
    when(instance.definitionId()).thenReturn(1L);

    // Act
    ImmutableAssessmentRatingSummaryCounts.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definitionId();
    verify(instance).ratingCounts();
    ImmutableAssessmentRatingSummaryCounts buildResult = builderResult.build();
    assertEquals(1, buildResult.ratingCounts().size());
    assertEquals(1L, buildResult.definitionId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingSummaryCounts.Builder#ratingCounts(Iterable)}
   */
  @Test
  void testBuilderRatingCounts() {
    // Arrange
    ImmutableAssessmentRatingSummaryCounts.Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingSummaryCounts#copyOf(AssessmentRatingSummaryCounts)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRatingSummaryCounts instance = mock(AssessmentRatingSummaryCounts.class);
    when(instance.ratingCounts()).thenReturn(new HashSet<>());
    when(instance.definitionId()).thenReturn(1L);

    // Act
    ImmutableAssessmentRatingSummaryCounts actualCopyOfResult = ImmutableAssessmentRatingSummaryCounts.copyOf(instance);

    // Assert
    verify(instance).definitionId();
    verify(instance).ratingCounts();
    assertEquals(1L, actualCopyOfResult.definitionId());
    assertTrue(actualCopyOfResult.ratingCounts().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingSummaryCounts#copyOf(AssessmentRatingSummaryCounts)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Tally<Long>> tallySet = new HashSet<>();
    tallySet.add(mock(Tally.class));
    AssessmentRatingSummaryCounts instance = mock(AssessmentRatingSummaryCounts.class);
    when(instance.ratingCounts()).thenReturn(tallySet);
    when(instance.definitionId()).thenReturn(1L);

    // Act
    ImmutableAssessmentRatingSummaryCounts actualCopyOfResult = ImmutableAssessmentRatingSummaryCounts.copyOf(instance);

    // Assert
    verify(instance).definitionId();
    verify(instance).ratingCounts();
    assertEquals(1, actualCopyOfResult.ratingCounts().size());
    assertEquals(1L, actualCopyOfResult.definitionId());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingSummaryCounts#copyOf(AssessmentRatingSummaryCounts)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Tally<Long>> tallySet = new HashSet<>();
    tallySet.add(mock(Tally.class));
    tallySet.add(mock(Tally.class));
    AssessmentRatingSummaryCounts instance = mock(AssessmentRatingSummaryCounts.class);
    when(instance.ratingCounts()).thenReturn(tallySet);
    when(instance.definitionId()).thenReturn(1L);

    // Act
    ImmutableAssessmentRatingSummaryCounts actualCopyOfResult = ImmutableAssessmentRatingSummaryCounts.copyOf(instance);

    // Assert
    verify(instance).definitionId();
    verify(instance).ratingCounts();
    assertEquals(1L, actualCopyOfResult.definitionId());
    assertEquals(tallySet, actualCopyOfResult.ratingCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingSummaryCounts.Json#definitionId()}
   */
  @Test
  void testJsonDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingSummaryCounts.Json()).definitionId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentRatingSummaryCounts.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentRatingSummaryCounts.Json actualJson = new ImmutableAssessmentRatingSummaryCounts.Json();

    // Assert
    assertEquals(0L, actualJson.definitionId);
    assertFalse(actualJson.definitionIdIsSet);
    assertTrue(actualJson.ratingCounts.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingSummaryCounts.Json#ratingCounts()}
   */
  @Test
  void testJsonRatingCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingSummaryCounts.Json()).ratingCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingSummaryCounts.Json#setDefinitionId(long)}
   */
  @Test
  void testJsonSetDefinitionId() {
    // Arrange
    ImmutableAssessmentRatingSummaryCounts.Json json = new ImmutableAssessmentRatingSummaryCounts.Json();

    // Act
    json.setDefinitionId(1L);

    // Assert
    assertEquals(1L, json.definitionId);
    assertTrue(json.definitionIdIsSet);
  }
}
