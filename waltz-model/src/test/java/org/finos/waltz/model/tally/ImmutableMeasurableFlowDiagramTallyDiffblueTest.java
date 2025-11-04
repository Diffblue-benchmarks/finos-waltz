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

class ImmutableMeasurableFlowDiagramTallyDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMeasurableFlowDiagramTally.Builder#count(long)}
   */
  @Test
  void testBuilderCount() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally.Builder builderResult = ImmutableMeasurableFlowDiagramTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableFlowDiagramTally.Builder#from(MeasurableFlowDiagramTally)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally.Builder builderResult = ImmutableMeasurableFlowDiagramTally.builder();
    MeasurableFlowDiagramTally instance = mock(MeasurableFlowDiagramTally.class);
    when(instance.rating()).thenReturn('A');
    when(instance.count()).thenReturn(3L);
    when(instance.id()).thenReturn(1L);

    // Act
    ImmutableMeasurableFlowDiagramTally.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).id();
    verify(instance).rating();
    ImmutableMeasurableFlowDiagramTally buildResult = builderResult.build();
    assertEquals('A', buildResult.rating());
    assertEquals(1L, buildResult.id());
    assertEquals(3L, buildResult.count());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableFlowDiagramTally.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally.Builder builderResult = ImmutableMeasurableFlowDiagramTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableFlowDiagramTally.Builder#rating(char)}
   */
  @Test
  void testBuilderRating() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally.Builder builderResult = ImmutableMeasurableFlowDiagramTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating('A'));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableFlowDiagramTally#copyOf(MeasurableFlowDiagramTally)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableFlowDiagramTally instance = mock(MeasurableFlowDiagramTally.class);
    when(instance.rating()).thenReturn('A');
    when(instance.count()).thenReturn(3L);
    when(instance.id()).thenReturn(1L);

    // Act
    ImmutableMeasurableFlowDiagramTally actualCopyOfResult = ImmutableMeasurableFlowDiagramTally.copyOf(instance);

    // Assert
    verify(instance).count();
    verify(instance).id();
    verify(instance).rating();
    assertEquals('A', actualCopyOfResult.rating());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(3L, actualCopyOfResult.count());
  }

  /**
   * Method under test: {@link ImmutableMeasurableFlowDiagramTally.Json#count()}
   */
  @Test
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableFlowDiagramTally.Json()).count());
  }

  /**
   * Method under test: {@link ImmutableMeasurableFlowDiagramTally.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableFlowDiagramTally.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableMeasurableFlowDiagramTally.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableMeasurableFlowDiagramTally.Json actualJson = new ImmutableMeasurableFlowDiagramTally.Json();

    // Assert
    assertEquals('\u0000', actualJson.rating);
    assertEquals(0L, actualJson.count);
    assertEquals(0L, actualJson.id);
    assertFalse(actualJson.countIsSet);
    assertFalse(actualJson.idIsSet);
    assertFalse(actualJson.ratingIsSet);
  }

  /**
   * Method under test: {@link ImmutableMeasurableFlowDiagramTally.Json#rating()}
   */
  @Test
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableFlowDiagramTally.Json()).rating());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableFlowDiagramTally.Json#setCount(long)}
   */
  @Test
  void testJsonSetCount() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally.Json json = new ImmutableMeasurableFlowDiagramTally.Json();

    // Act
    json.setCount(3L);

    // Assert
    assertEquals(3L, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableFlowDiagramTally.Json#setId(long)}
   */
  @Test
  void testJsonSetId() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally.Json json = new ImmutableMeasurableFlowDiagramTally.Json();

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableFlowDiagramTally.Json#setRating(char)}
   */
  @Test
  void testJsonSetRating() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally.Json json = new ImmutableMeasurableFlowDiagramTally.Json();

    // Act
    json.setRating('A');

    // Assert
    assertEquals('A', json.rating);
    assertTrue(json.ratingIsSet);
  }
}
