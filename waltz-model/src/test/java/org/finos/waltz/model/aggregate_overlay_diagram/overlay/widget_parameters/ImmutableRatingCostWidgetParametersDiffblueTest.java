package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ImmutableRatingCostWidgetParametersDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters.Builder#addAllCostKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllCostKindIds() {
    // Arrange
    ImmutableRatingCostWidgetParameters.Builder builderResult = ImmutableRatingCostWidgetParameters.builder();

    // Act
    ImmutableRatingCostWidgetParameters.Builder actualAddAllCostKindIdsResult = builderResult
        .addAllCostKindIds(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllCostKindIdsResult.build().costKindIds().isEmpty());
    assertSame(builderResult, actualAddAllCostKindIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters.Builder#addAllCostKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllCostKindIds2() {
    // Arrange
    ImmutableRatingCostWidgetParameters.Builder builderResult = ImmutableRatingCostWidgetParameters.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableRatingCostWidgetParameters.Builder actualAddAllCostKindIdsResult = builderResult
        .addAllCostKindIds(elements);

    // Assert
    Set<Long> costKindIdsResult = builderResult.build().costKindIds();
    assertEquals(1, costKindIdsResult.size());
    assertTrue(costKindIdsResult.contains(1L));
    assertSame(builderResult, actualAddAllCostKindIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters.Builder#addCostKindIds(long)}
   */
  @Test
  void testBuilderAddCostKindIds() {
    // Arrange
    ImmutableRatingCostWidgetParameters.Builder builderResult = ImmutableRatingCostWidgetParameters.builder();

    // Act
    ImmutableRatingCostWidgetParameters.Builder actualAddCostKindIdsResult = builderResult.addCostKindIds(1L);

    // Assert
    Set<Long> costKindIdsResult = actualAddCostKindIdsResult.build().costKindIds();
    assertEquals(1, costKindIdsResult.size());
    Set<Long> costKindIdsResult2 = builderResult.build().costKindIds();
    assertEquals(1, costKindIdsResult2.size());
    assertTrue(costKindIdsResult.contains(1L));
    assertTrue(costKindIdsResult2.contains(1L));
    assertSame(builderResult, actualAddCostKindIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters.Builder#addCostKindIds(long[])}
   */
  @Test
  void testBuilderAddCostKindIds2() {
    // Arrange
    ImmutableRatingCostWidgetParameters.Builder builderResult = ImmutableRatingCostWidgetParameters.builder();

    // Act
    ImmutableRatingCostWidgetParameters.Builder actualAddCostKindIdsResult = builderResult.addCostKindIds(1L, -1L, 1L,
        -1L);

    // Assert
    Set<Long> costKindIdsResult = builderResult.build().costKindIds();
    assertEquals(2, costKindIdsResult.size());
    assertTrue(costKindIdsResult.contains(-1L));
    assertTrue(costKindIdsResult.contains(1L));
    assertSame(builderResult, actualAddCostKindIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableRatingCostWidgetParameters.builder().build().costKindIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters.Builder#costKindIds(Iterable)}
   */
  @Test
  void testBuilderCostKindIds() {
    // Arrange
    ImmutableRatingCostWidgetParameters.Builder builderResult = ImmutableRatingCostWidgetParameters.builder();

    // Act
    ImmutableRatingCostWidgetParameters.Builder actualCostKindIdsResult = builderResult.costKindIds(new ArrayList<>());

    // Assert
    assertTrue(actualCostKindIdsResult.build().costKindIds().isEmpty());
    assertSame(builderResult, actualCostKindIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters.Builder#costKindIds(Iterable)}
   */
  @Test
  void testBuilderCostKindIds2() {
    // Arrange
    ImmutableRatingCostWidgetParameters.Builder builderResult = ImmutableRatingCostWidgetParameters.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableRatingCostWidgetParameters.Builder actualCostKindIdsResult = builderResult.costKindIds(elements);

    // Assert
    Set<Long> costKindIdsResult = builderResult.build().costKindIds();
    assertEquals(1, costKindIdsResult.size());
    assertTrue(costKindIdsResult.contains(1L));
    assertSame(builderResult, actualCostKindIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters.Builder#from(RatingCostWidgetParameters)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRatingCostWidgetParameters.Builder builderResult = ImmutableRatingCostWidgetParameters.builder();
    RatingCostWidgetParameters instance = mock(RatingCostWidgetParameters.class);
    when(instance.costKindIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableRatingCostWidgetParameters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).costKindIds();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters.Builder#from(RatingCostWidgetParameters)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRatingCostWidgetParameters.Builder builderResult = ImmutableRatingCostWidgetParameters.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    RatingCostWidgetParameters instance = mock(RatingCostWidgetParameters.class);
    when(instance.costKindIds()).thenReturn(resultLongSet);

    // Act
    ImmutableRatingCostWidgetParameters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).costKindIds();
    Set<Long> costKindIdsResult = builderResult.build().costKindIds();
    assertEquals(1, costKindIdsResult.size());
    assertTrue(costKindIdsResult.contains(1L));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters#copyOf(RatingCostWidgetParameters)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    RatingCostWidgetParameters instance = mock(RatingCostWidgetParameters.class);
    when(instance.costKindIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableRatingCostWidgetParameters actualCopyOfResult = ImmutableRatingCostWidgetParameters.copyOf(instance);

    // Assert
    verify(instance).costKindIds();
    assertTrue(actualCopyOfResult.costKindIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters#copyOf(RatingCostWidgetParameters)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    RatingCostWidgetParameters instance = mock(RatingCostWidgetParameters.class);
    when(instance.costKindIds()).thenReturn(resultLongSet);

    // Act
    ImmutableRatingCostWidgetParameters actualCopyOfResult = ImmutableRatingCostWidgetParameters.copyOf(instance);

    // Assert
    verify(instance).costKindIds();
    Set<Long> costKindIdsResult = actualCopyOfResult.costKindIds();
    assertEquals(1, costKindIdsResult.size());
    assertTrue(costKindIdsResult.contains(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters#copyOf(RatingCostWidgetParameters)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(0L);
    resultLongSet.add(1L);
    RatingCostWidgetParameters instance = mock(RatingCostWidgetParameters.class);
    when(instance.costKindIds()).thenReturn(resultLongSet);

    // Act
    ImmutableRatingCostWidgetParameters actualCopyOfResult = ImmutableRatingCostWidgetParameters.copyOf(instance);

    // Assert
    verify(instance).costKindIds();
    assertEquals(resultLongSet, actualCopyOfResult.costKindIds());
  }

  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters#fromJson(ImmutableRatingCostWidgetParameters.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableRatingCostWidgetParameters.Json json = new ImmutableRatingCostWidgetParameters.Json();

    // Act and Assert
    Set<Long> costKindIdsResult = ImmutableRatingCostWidgetParameters.fromJson(json).costKindIds();
    assertTrue(costKindIdsResult.isEmpty());
    assertSame(json.costKindIds, costKindIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters#fromJson(ImmutableRatingCostWidgetParameters.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableRatingCostWidgetParameters.Json json = new ImmutableRatingCostWidgetParameters.Json();
    json.setCostKindIds(null);

    // Act and Assert
    assertTrue(ImmutableRatingCostWidgetParameters.fromJson(json).costKindIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters#fromJson(ImmutableRatingCostWidgetParameters.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<Long> costKindIds = new LinkedHashSet<>();
    costKindIds.add(1L);

    ImmutableRatingCostWidgetParameters.Json json = new ImmutableRatingCostWidgetParameters.Json();
    json.setCostKindIds(costKindIds);

    // Act and Assert
    Set<Long> costKindIdsResult = ImmutableRatingCostWidgetParameters.fromJson(json).costKindIds();
    assertEquals(1, costKindIdsResult.size());
    assertTrue(costKindIdsResult.contains(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters#fromJson(ImmutableRatingCostWidgetParameters.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<Long> costKindIds = new LinkedHashSet<>();
    costKindIds.add(-1L);
    costKindIds.add(1L);

    ImmutableRatingCostWidgetParameters.Json json = new ImmutableRatingCostWidgetParameters.Json();
    json.setCostKindIds(costKindIds);

    // Act and Assert
    assertEquals(costKindIds, ImmutableRatingCostWidgetParameters.fromJson(json).costKindIds());
  }

  /**
   * Method under test:
   * {@link ImmutableRatingCostWidgetParameters.Json#costKindIds()}
   */
  @Test
  void testJsonCostKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableRatingCostWidgetParameters.Json()).costKindIds());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableRatingCostWidgetParameters.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange, Act and Assert
    assertTrue((new ImmutableRatingCostWidgetParameters.Json()).costKindIds.isEmpty());
  }
}
