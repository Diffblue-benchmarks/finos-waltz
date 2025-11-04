package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.bulk_upload.ResolutionStatus;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentCellDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentCell.Builder#addAllRatings(Iterable)}
   */
  @Test
  void testBuilderAddAllRatings() {
    // Arrange
    ImmutableAssessmentCell.Builder builderResult = ImmutableAssessmentCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCell.Builder#addRatings(AssessmentCellRating)}
   */
  @Test
  void testBuilderAddRatings() {
    // Arrange
    ImmutableAssessmentCell.Builder builderResult = ImmutableAssessmentCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatings(new ImmutableAssessmentCellRating.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCell.Builder#addRatings(AssessmentCellRating)}
   */
  @Test
  void testBuilderAddRatings2() {
    // Arrange
    ImmutableAssessmentCell.Builder builderResult = ImmutableAssessmentCell.builder();

    ImmutableAssessmentCellRating.Json element = new ImmutableAssessmentCellRating.Json();
    Optional<RatingSchemeItem> resolvedRating = Optional.of(mock(RatingSchemeItem.class));
    element.setResolvedRating(resolvedRating);

    // Act and Assert
    assertSame(builderResult, builderResult.addRatings(element));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCell.Builder#addRatings(AssessmentCellRating[])}
   */
  @Test
  void testBuilderAddRatings3() {
    // Arrange
    ImmutableAssessmentCell.Builder builderResult = ImmutableAssessmentCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatings(new ImmutableAssessmentCellRating.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCell.Builder#addRatings(AssessmentCellRating[])}
   */
  @Test
  void testBuilderAddRatings4() {
    // Arrange
    ImmutableAssessmentCell.Builder builderResult = ImmutableAssessmentCell.builder();

    ImmutableAssessmentCellRating.Json json = new ImmutableAssessmentCellRating.Json();
    Optional<RatingSchemeItem> resolvedRating = Optional.of(mock(RatingSchemeItem.class));
    json.setResolvedRating(resolvedRating);

    // Act and Assert
    assertSame(builderResult, builderResult.addRatings(json));
  }

  /**
   * Method under test: {@link ImmutableAssessmentCell.Builder#columnId(int)}
   */
  @Test
  void testBuilderColumnId() {
    // Arrange
    ImmutableAssessmentCell.Builder builderResult = ImmutableAssessmentCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnId(1));
  }

  /**
   * Method under test: {@link ImmutableAssessmentCell.Builder#columnId(int)}
   */
  @Test
  void testBuilderColumnId2() {
    // Arrange
    ImmutableAssessmentCellRating.Json element = new ImmutableAssessmentCellRating.Json();
    Optional<RatingSchemeItem> resolvedRating = Optional.of(mock(RatingSchemeItem.class));
    element.setResolvedRating(resolvedRating);
    ImmutableAssessmentCell.Builder builderResult = ImmutableAssessmentCell.builder();
    builderResult.addRatings(element);

    // Act and Assert
    assertSame(builderResult, builderResult.columnId(1));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCell.Builder#from(AssessmentCell)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentCell.Builder builderResult = ImmutableAssessmentCell.builder();
    AssessmentCell instance = mock(AssessmentCell.class);
    when(instance.columnId()).thenReturn(1);
    when(instance.ratings()).thenReturn(new HashSet<>());
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableAssessmentCell.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).ratings();
    ImmutableAssessmentCell buildResult = builderResult.build();
    assertEquals("Input String", buildResult.inputString());
    assertEquals(1, buildResult.columnId());
    assertTrue(buildResult.statuses().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCell.Builder#from(AssessmentCell)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentCell.Builder builderResult = ImmutableAssessmentCell.builder();
    AssessmentCell instance = mock(AssessmentCell.class);
    when(instance.columnId()).thenThrow(new IllegalStateException("instance"));
    when(instance.inputString()).thenReturn("Input String");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).columnId();
    verify(instance).inputString();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCell.Builder#from(AssessmentCell)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentCell.Builder builderResult = ImmutableAssessmentCell.builder();

    HashSet<AssessmentCellRating> assessmentCellRatingSet = new HashSet<>();
    assessmentCellRatingSet.add(new ImmutableAssessmentCellRating.Json());
    AssessmentCell instance = mock(AssessmentCell.class);
    when(instance.columnId()).thenReturn(1);
    when(instance.ratings()).thenReturn(assessmentCellRatingSet);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableAssessmentCell.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).ratings();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCell.Builder#inputString(String)}
   */
  @Test
  void testBuilderInputString() {
    // Arrange
    ImmutableAssessmentCell.Builder builderResult = ImmutableAssessmentCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inputString("Input String"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentCell.Builder#inputString(String)}
   */
  @Test
  void testBuilderInputString2() {
    // Arrange
    ImmutableAssessmentCellRating.Json element = new ImmutableAssessmentCellRating.Json();
    Optional<RatingSchemeItem> resolvedRating = Optional.of(mock(RatingSchemeItem.class));
    element.setResolvedRating(resolvedRating);
    ImmutableAssessmentCell.Builder builderResult = ImmutableAssessmentCell.builder();
    builderResult.addRatings(element);

    // Act and Assert
    assertSame(builderResult, builderResult.inputString("Input String"));
  }

  /**
   * Method under test: {@link ImmutableAssessmentCell.Builder#ratings(Iterable)}
   */
  @Test
  void testBuilderRatings() {
    // Arrange
    ImmutableAssessmentCell.Builder builderResult = ImmutableAssessmentCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratings(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableAssessmentCell#copyOf(AssessmentCell)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentCell instance = mock(AssessmentCell.class);
    when(instance.columnId()).thenReturn(1);
    when(instance.ratings()).thenReturn(new HashSet<>());
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableAssessmentCell actualCopyOfResult = ImmutableAssessmentCell.copyOf(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).ratings();
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals(1, actualCopyOfResult.columnId());
    assertTrue(actualCopyOfResult.ratings().isEmpty());
    assertTrue(actualCopyOfResult.statuses().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableAssessmentCell#copyOf(AssessmentCell)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AssessmentCellRating assessmentCellRating = mock(AssessmentCellRating.class);
    when(assessmentCellRating.status()).thenReturn(ResolutionStatus.NEW);

    HashSet<AssessmentCellRating> assessmentCellRatingSet = new HashSet<>();
    assessmentCellRatingSet.add(assessmentCellRating);
    AssessmentCell instance = mock(AssessmentCell.class);
    when(instance.columnId()).thenReturn(1);
    when(instance.ratings()).thenReturn(assessmentCellRatingSet);
    when(instance.inputString()).thenReturn("Input String");

    // Act
    ImmutableAssessmentCell actualCopyOfResult = ImmutableAssessmentCell.copyOf(instance);

    // Assert
    verify(instance).columnId();
    verify(instance).inputString();
    verify(instance).ratings();
    verify(assessmentCellRating).status();
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals(1, actualCopyOfResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualCopyOfResult.statuses();
    assertEquals(1, statusesResult.size());
    assertEquals(1, actualCopyOfResult.columnId());
    assertTrue(statusesResult.contains(ResolutionStatus.NEW));
  }

  /**
   * Method under test: {@link ImmutableAssessmentCell.Json#columnId()}
   */
  @Test
  void testJsonColumnId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentCell.Json()).columnId());
  }

  /**
   * Method under test: {@link ImmutableAssessmentCell.Json#inputString()}
   */
  @Test
  void testJsonInputString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentCell.Json()).inputString());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentCell.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentCell.Json actualJson = new ImmutableAssessmentCell.Json();

    // Assert
    assertNull(actualJson.inputString);
    assertEquals(0, actualJson.columnId);
    assertFalse(actualJson.columnIdIsSet);
    assertTrue(actualJson.ratings.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableAssessmentCell.Json#ratings()}
   */
  @Test
  void testJsonRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentCell.Json()).ratings());
  }

  /**
   * Method under test: {@link ImmutableAssessmentCell.Json#setColumnId(int)}
   */
  @Test
  void testJsonSetColumnId() {
    // Arrange
    ImmutableAssessmentCell.Json json = new ImmutableAssessmentCell.Json();

    // Act
    json.setColumnId(1);

    // Assert
    assertEquals(1, json.columnId);
    assertTrue(json.columnIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableAssessmentCell.Json#statuses()}
   */
  @Test
  void testJsonStatuses() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentCell.Json()).statuses());
  }
}
