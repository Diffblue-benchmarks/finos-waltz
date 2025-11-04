package org.finos.waltz.model.tally;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingTallyDiffblueTest {
  /**
   * Method under test: {@link ImmutableMeasurableRatingTally.Builder#count(long)}
   */
  @Test
  void testBuilderCount() {
    // Arrange
    ImmutableMeasurableRatingTally.Builder builderResult = ImmutableMeasurableRatingTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingTally.Builder#from(MeasurableRatingTally)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableRatingTally.Builder builderResult = ImmutableMeasurableRatingTally.builder();
    MeasurableRatingTally instance = mock(MeasurableRatingTally.class);
    when(instance.rating()).thenReturn('A');
    when(instance.count()).thenReturn(3L);
    when(instance.id()).thenReturn(1L);

    // Act
    ImmutableMeasurableRatingTally.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).id();
    verify(instance).rating();
    ImmutableMeasurableRatingTally buildResult = builderResult.build();
    assertEquals('A', buildResult.rating());
    assertEquals(1L, buildResult.id());
    assertEquals(3L, buildResult.count());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRatingTally.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableMeasurableRatingTally.Builder builderResult = ImmutableMeasurableRatingTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingTally.Builder#rating(char)}
   */
  @Test
  void testBuilderRating() {
    // Arrange
    ImmutableMeasurableRatingTally.Builder builderResult = ImmutableMeasurableRatingTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating('A'));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingTally#copyOf(MeasurableRatingTally)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableRatingTally instance = mock(MeasurableRatingTally.class);
    when(instance.rating()).thenReturn('A');
    when(instance.count()).thenReturn(3L);
    when(instance.id()).thenReturn(1L);

    // Act
    ImmutableMeasurableRatingTally actualCopyOfResult = ImmutableMeasurableRatingTally.copyOf(instance);

    // Assert
    verify(instance).count();
    verify(instance).id();
    verify(instance).rating();
    assertEquals('A', actualCopyOfResult.rating());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(3L, actualCopyOfResult.count());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRatingTally.Json#count()}
   */
  @Test
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRatingTally.Json()).count());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRatingTally.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRatingTally.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableMeasurableRatingTally.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableMeasurableRatingTally.Json actualJson = new ImmutableMeasurableRatingTally.Json();

    // Assert
    assertEquals('\u0000', actualJson.rating);
    assertEquals(0L, actualJson.count);
    assertEquals(0L, actualJson.id);
    assertFalse(actualJson.countIsSet);
    assertFalse(actualJson.idIsSet);
    assertFalse(actualJson.ratingIsSet);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRatingTally.Json#rating()}
   */
  @Test
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRatingTally.Json()).rating());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRatingTally.Json#setCount(long)}
   */
  @Test
  void testJsonSetCount() {
    // Arrange
    ImmutableMeasurableRatingTally.Json json = new ImmutableMeasurableRatingTally.Json();

    // Act
    json.setCount(3L);

    // Assert
    assertEquals(3L, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRatingTally.Json#setId(long)}
   */
  @Test
  void testJsonSetId() {
    // Arrange
    ImmutableMeasurableRatingTally.Json json = new ImmutableMeasurableRatingTally.Json();

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingTally.Json#setRating(char)}
   */
  @Test
  void testJsonSetRating() {
    // Arrange
    ImmutableMeasurableRatingTally.Json json = new ImmutableMeasurableRatingTally.Json();

    // Act
    json.setRating('A');

    // Assert
    assertEquals('A', json.rating);
    assertTrue(json.ratingIsSet);
  }
}
