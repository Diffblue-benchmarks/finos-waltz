package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingCountDiffblueTest {
  /**
   * Method under test: {@link ImmutableAssessmentRatingCount.Builder#count(int)}
   */
  @Test
  void testBuilderCount() {
    // Arrange
    ImmutableAssessmentRatingCount.Builder builderResult = ImmutableAssessmentRatingCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingCount.Builder#from(AssessmentRatingCount)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRatingCount.Builder builderResult = ImmutableAssessmentRatingCount.builder();
    AssessmentRatingCount instance = mock(AssessmentRatingCount.class);
    when(instance.count()).thenReturn(3);
    when(instance.rating()).thenReturn(mock(RatingSchemeItem.class));

    // Act
    ImmutableAssessmentRatingCount.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).rating();
    assertEquals(3, actualFromResult.build().count());
    assertEquals(3, builderResult.build().count());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingCount.Builder#rating(RatingSchemeItem)}
   */
  @Test
  void testBuilderRating() {
    // Arrange
    ImmutableAssessmentRatingCount.Builder builderResult = ImmutableAssessmentRatingCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating(mock(RatingSchemeItem.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingCount#copyOf(AssessmentRatingCount)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRatingCount instance = mock(AssessmentRatingCount.class);
    when(instance.count()).thenReturn(3);
    when(instance.rating()).thenReturn(mock(RatingSchemeItem.class));

    // Act
    ImmutableAssessmentRatingCount actualCopyOfResult = ImmutableAssessmentRatingCount.copyOf(instance);

    // Assert
    verify(instance).count();
    verify(instance).rating();
    assertEquals(3, actualCopyOfResult.count());
  }

  /**
   * Method under test: {@link ImmutableAssessmentRatingCount.Json#count()}
   */
  @Test
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRatingCount.Json()).count());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAssessmentRatingCount.Json}
   *   <li>{@link ImmutableAssessmentRatingCount.Json#setRating(RatingSchemeItem)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAssessmentRatingCount.Json actualJson = new ImmutableAssessmentRatingCount.Json();
    actualJson.setRating(null);

    // Assert
    assertNull(actualJson.rating);
    assertEquals(0, actualJson.count);
    assertFalse(actualJson.countIsSet);
  }

  /**
   * Method under test: {@link ImmutableAssessmentRatingCount.Json#rating()}
   */
  @Test
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRatingCount.Json()).rating());
  }

  /**
   * Method under test: {@link ImmutableAssessmentRatingCount.Json#setCount(int)}
   */
  @Test
  void testJsonSetCount() {
    // Arrange
    ImmutableAssessmentRatingCount.Json json = new ImmutableAssessmentRatingCount.Json();

    // Act
    json.setCount(3);

    // Assert
    assertEquals(3, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Method under test: {@link ImmutableAssessmentRatingCount.Json#setCount(int)}
   */
  @Test
  void testJsonSetCount2() {
    // Arrange
    ImmutableAssessmentRatingCount.Json json = new ImmutableAssessmentRatingCount.Json();
    json.setRating(mock(RatingSchemeItem.class));

    // Act
    json.setCount(3);

    // Assert
    assertEquals(3, json.count);
    assertTrue(json.countIsSet);
  }
}
