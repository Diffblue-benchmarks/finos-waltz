package org.finos.waltz.model.allocation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingPercentageDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPercentage.Builder#from(MeasurableRatingPercentage)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableRatingPercentage.Builder builderResult = ImmutableMeasurableRatingPercentage.builder();
    MeasurableRatingPercentage instance = mock(MeasurableRatingPercentage.class);
    when(instance.percentage()).thenReturn(1);
    when(instance.measurableRatingId()).thenReturn(1L);

    // Act
    ImmutableMeasurableRatingPercentage.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurableRatingId();
    verify(instance).percentage();
    ImmutableMeasurableRatingPercentage buildResult = builderResult.build();
    assertEquals(1, buildResult.percentage());
    assertEquals(1L, buildResult.measurableRatingId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPercentage.Builder#measurableRatingId(long)}
   */
  @Test
  void testBuilderMeasurableRatingId() {
    // Arrange
    ImmutableMeasurableRatingPercentage.Builder builderResult = ImmutableMeasurableRatingPercentage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableRatingId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPercentage.Builder#percentage(int)}
   */
  @Test
  void testBuilderPercentage() {
    // Arrange
    ImmutableMeasurableRatingPercentage.Builder builderResult = ImmutableMeasurableRatingPercentage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.percentage(1));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPercentage#copyOf(MeasurableRatingPercentage)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableRatingPercentage instance = mock(MeasurableRatingPercentage.class);
    when(instance.percentage()).thenReturn(1);
    when(instance.measurableRatingId()).thenReturn(1L);

    // Act
    ImmutableMeasurableRatingPercentage actualCopyOfResult = ImmutableMeasurableRatingPercentage.copyOf(instance);

    // Assert
    verify(instance).measurableRatingId();
    verify(instance).percentage();
    assertEquals(1, actualCopyOfResult.percentage());
    assertEquals(1L, actualCopyOfResult.measurableRatingId());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPercentage.Json#measurableRatingId()}
   */
  @Test
  void testJsonMeasurableRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingPercentage.Json()).measurableRatingId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableMeasurableRatingPercentage.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableMeasurableRatingPercentage.Json actualJson = new ImmutableMeasurableRatingPercentage.Json();

    // Assert
    assertEquals(0, actualJson.percentage);
    assertEquals(0L, actualJson.measurableRatingId);
    assertFalse(actualJson.measurableRatingIdIsSet);
    assertFalse(actualJson.percentageIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPercentage.Json#percentage()}
   */
  @Test
  void testJsonPercentage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingPercentage.Json()).percentage());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPercentage.Json#setMeasurableRatingId(long)}
   */
  @Test
  void testJsonSetMeasurableRatingId() {
    // Arrange
    ImmutableMeasurableRatingPercentage.Json json = new ImmutableMeasurableRatingPercentage.Json();

    // Act
    json.setMeasurableRatingId(1L);

    // Assert
    assertEquals(1L, json.measurableRatingId);
    assertTrue(json.measurableRatingIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPercentage.Json#setPercentage(int)}
   */
  @Test
  void testJsonSetPercentage() {
    // Arrange
    ImmutableMeasurableRatingPercentage.Json json = new ImmutableMeasurableRatingPercentage.Json();

    // Act
    json.setPercentage(1);

    // Assert
    assertEquals(1, json.percentage);
    assertTrue(json.percentageIsSet);
  }
}
