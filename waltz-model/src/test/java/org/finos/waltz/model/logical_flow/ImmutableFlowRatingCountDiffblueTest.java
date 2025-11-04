package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableFlowRatingCountDiffblueTest {
  /**
   * Method under test: {@link ImmutableFlowRatingCount.Builder#flowCount(int)}
   */
  @Test
  void testBuilderFlowCount() {
    // Arrange
    ImmutableFlowRatingCount.Builder builderResult = ImmutableFlowRatingCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowRatingCount.Builder#from(FlowRatingCount)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowRatingCount.Builder builderResult = ImmutableFlowRatingCount.builder();
    FlowRatingCount instance = mock(FlowRatingCount.class);
    when(instance.flowCount()).thenReturn(3);
    when(instance.rating()).thenReturn(1L);

    // Act
    ImmutableFlowRatingCount.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).flowCount();
    verify(instance).rating();
    ImmutableFlowRatingCount buildResult = builderResult.build();
    assertEquals(1L, buildResult.rating().longValue());
    assertEquals(3, buildResult.flowCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFlowRatingCount.Builder#rating(Long)}
   */
  @Test
  void testBuilderRating() {
    // Arrange
    ImmutableFlowRatingCount.Builder builderResult = ImmutableFlowRatingCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating(1L));
  }

  /**
   * Method under test: {@link ImmutableFlowRatingCount#copyOf(FlowRatingCount)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowRatingCount instance = mock(FlowRatingCount.class);
    when(instance.flowCount()).thenReturn(3);
    when(instance.rating()).thenReturn(1L);

    // Act
    ImmutableFlowRatingCount actualCopyOfResult = ImmutableFlowRatingCount.copyOf(instance);

    // Assert
    verify(instance).flowCount();
    verify(instance).rating();
    assertEquals(1L, actualCopyOfResult.rating().longValue());
    assertEquals(3, actualCopyOfResult.flowCount());
  }

  /**
   * Method under test: {@link ImmutableFlowRatingCount.Json#flowCount()}
   */
  @Test
  void testJsonFlowCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowRatingCount.Json()).flowCount());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableFlowRatingCount.Json}
   *   <li>{@link ImmutableFlowRatingCount.Json#setRating(Long)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableFlowRatingCount.Json actualJson = new ImmutableFlowRatingCount.Json();
    actualJson.setRating(1L);

    // Assert
    assertEquals(1L, actualJson.rating.longValue());
  }

  /**
   * Method under test: {@link ImmutableFlowRatingCount.Json#rating()}
   */
  @Test
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowRatingCount.Json()).rating());
  }

  /**
   * Method under test: {@link ImmutableFlowRatingCount.Json#setFlowCount(int)}
   */
  @Test
  void testJsonSetFlowCount() {
    // Arrange
    ImmutableFlowRatingCount.Json json = new ImmutableFlowRatingCount.Json();

    // Act
    json.setFlowCount(3);

    // Assert
    assertEquals(3, json.flowCount);
    assertTrue(json.flowCountIsSet);
  }
}
