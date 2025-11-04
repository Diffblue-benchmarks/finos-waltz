package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.Test;

class ImmutableEntityStatisticQueryOptionsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions.Builder#addAllStatisticIds(Iterable)}
   */
  @Test
  void testBuilderAddAllStatisticIds() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllStatisticIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions.Builder#addAllStatisticIds(Iterable)}
   */
  @Test
  void testBuilderAddAllStatisticIds2() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllStatisticIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions.Builder#addStatisticIds(long)}
   */
  @Test
  void testBuilderAddStatisticIds() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addStatisticIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions.Builder#addStatisticIds(long[])}
   */
  @Test
  void testBuilderAddStatisticIds2() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addStatisticIds(1L, -2L, 1L, -2L));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions.Builder#from(EntityStatisticQueryOptions)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();
    EntityStatisticQueryOptions instance = mock(EntityStatisticQueryOptions.class);
    when(instance.statisticIds()).thenReturn(new ArrayList<>());
    when(instance.selector()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableEntityStatisticQueryOptions.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).selector();
    verify(instance).statisticIds();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions.Builder#from(EntityStatisticQueryOptions)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(-2L);
    EntityStatisticQueryOptions instance = mock(EntityStatisticQueryOptions.class);
    when(instance.statisticIds()).thenReturn(resultLongList);
    when(instance.selector()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableEntityStatisticQueryOptions.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).selector();
    verify(instance).statisticIds();
    List<Long> statisticIdsResult = builderResult.build().statisticIds();
    assertEquals(1, statisticIdsResult.size());
    assertEquals(-2L, statisticIdsResult.get(0).longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions.Builder#from(EntityStatisticQueryOptions)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();
    EntityStatisticQueryOptions instance = mock(EntityStatisticQueryOptions.class);
    when(instance.statisticIds()).thenThrow(new IllegalStateException("instance"));
    when(instance.selector()).thenReturn(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).selector();
    verify(instance).statisticIds();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions.Builder#selector(IdSelectionOptions)}
   */
  @Test
  void testBuilderSelector() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();
    IdSelectionOptions selector = mock(IdSelectionOptions.class);

    // Act and Assert
    assertSame(builderResult, builderResult.selector(selector));
    assertSame(selector, builderResult.build().selector());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions.Builder#statisticIds(Iterable)}
   */
  @Test
  void testBuilderStatisticIds() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.statisticIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions.Builder#statisticIds(Iterable)}
   */
  @Test
  void testBuilderStatisticIds2() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.statisticIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions#copyOf(EntityStatisticQueryOptions)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityStatisticQueryOptions instance = mock(EntityStatisticQueryOptions.class);
    when(instance.statisticIds()).thenReturn(new ArrayList<>());
    when(instance.selector()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableEntityStatisticQueryOptions actualCopyOfResult = ImmutableEntityStatisticQueryOptions.copyOf(instance);

    // Assert
    verify(instance).selector();
    verify(instance).statisticIds();
    assertTrue(actualCopyOfResult.statisticIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions#copyOf(EntityStatisticQueryOptions)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    EntityStatisticQueryOptions instance = mock(EntityStatisticQueryOptions.class);
    when(instance.statisticIds()).thenReturn(resultLongList);
    when(instance.selector()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableEntityStatisticQueryOptions actualCopyOfResult = ImmutableEntityStatisticQueryOptions.copyOf(instance);

    // Assert
    verify(instance).selector();
    verify(instance).statisticIds();
    List<Long> statisticIdsResult = actualCopyOfResult.statisticIds();
    assertEquals(1, statisticIdsResult.size());
    assertEquals(1L, statisticIdsResult.get(0).longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions#copyOf(EntityStatisticQueryOptions)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(-2L);
    resultLongList.add(1L);
    EntityStatisticQueryOptions instance = mock(EntityStatisticQueryOptions.class);
    when(instance.statisticIds()).thenReturn(resultLongList);
    when(instance.selector()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableEntityStatisticQueryOptions actualCopyOfResult = ImmutableEntityStatisticQueryOptions.copyOf(instance);

    // Assert
    verify(instance).selector();
    verify(instance).statisticIds();
    assertEquals(resultLongList, actualCopyOfResult.statisticIds());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions#fromJson(ImmutableEntityStatisticQueryOptions.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableEntityStatisticQueryOptions.Json json = new ImmutableEntityStatisticQueryOptions.Json();
    json.setSelector(mock(IdSelectionOptions.class));

    // Act
    ImmutableEntityStatisticQueryOptions actualFromJsonResult = ImmutableEntityStatisticQueryOptions.fromJson(json);

    // Assert
    List<Long> statisticIdsResult = actualFromJsonResult.statisticIds();
    assertTrue(statisticIdsResult.isEmpty());
    IdSelectionOptions expectedSelectorResult = json.selector;
    assertSame(expectedSelectorResult, actualFromJsonResult.selector());
    assertSame(json.statisticIds, statisticIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions#fromJson(ImmutableEntityStatisticQueryOptions.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<Long> statisticIds = new ArrayList<>();
    statisticIds.add(1L);

    ImmutableEntityStatisticQueryOptions.Json json = new ImmutableEntityStatisticQueryOptions.Json();
    json.setSelector(mock(IdSelectionOptions.class));
    json.setStatisticIds(statisticIds);

    // Act
    ImmutableEntityStatisticQueryOptions actualFromJsonResult = ImmutableEntityStatisticQueryOptions.fromJson(json);

    // Assert
    List<Long> statisticIdsResult = actualFromJsonResult.statisticIds();
    assertEquals(1, statisticIdsResult.size());
    assertEquals(1L, statisticIdsResult.get(0).longValue());
    IdSelectionOptions expectedSelectorResult = json.selector;
    assertSame(expectedSelectorResult, actualFromJsonResult.selector());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions#fromJson(ImmutableEntityStatisticQueryOptions.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<Long> statisticIds = new ArrayList<>();
    statisticIds.add(-2L);
    statisticIds.add(1L);

    ImmutableEntityStatisticQueryOptions.Json json = new ImmutableEntityStatisticQueryOptions.Json();
    json.setSelector(mock(IdSelectionOptions.class));
    json.setStatisticIds(statisticIds);

    // Act
    ImmutableEntityStatisticQueryOptions actualFromJsonResult = ImmutableEntityStatisticQueryOptions.fromJson(json);

    // Assert
    assertEquals(statisticIds, actualFromJsonResult.statisticIds());
    IdSelectionOptions expectedSelectorResult = json.selector;
    assertSame(expectedSelectorResult, actualFromJsonResult.selector());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntityStatisticQueryOptions.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityStatisticQueryOptions.Json actualJson = new ImmutableEntityStatisticQueryOptions.Json();

    // Assert
    assertNull(actualJson.selector);
    assertTrue(actualJson.statisticIds.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions.Json#selector()}
   */
  @Test
  void testJsonSelector() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityStatisticQueryOptions.Json()).selector());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityStatisticQueryOptions.Json#statisticIds()}
   */
  @Test
  void testJsonStatisticIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityStatisticQueryOptions.Json()).statisticIds());
  }
}
