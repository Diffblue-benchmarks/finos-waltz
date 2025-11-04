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

class ImmutableAppComplexityWidgetParametersDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters.Builder#addAllComplexityKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllComplexityKindIds() {
    // Arrange
    ImmutableAppComplexityWidgetParameters.Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();

    // Act
    ImmutableAppComplexityWidgetParameters.Builder actualAddAllComplexityKindIdsResult = builderResult
        .addAllComplexityKindIds(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllComplexityKindIdsResult.build().complexityKindIds().isEmpty());
    assertSame(builderResult, actualAddAllComplexityKindIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters.Builder#addAllComplexityKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllComplexityKindIds2() {
    // Arrange
    ImmutableAppComplexityWidgetParameters.Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableAppComplexityWidgetParameters.Builder actualAddAllComplexityKindIdsResult = builderResult
        .addAllComplexityKindIds(elements);

    // Assert
    Set<Long> complexityKindIdsResult = builderResult.build().complexityKindIds();
    assertEquals(1, complexityKindIdsResult.size());
    assertTrue(complexityKindIdsResult.contains(1L));
    assertSame(builderResult, actualAddAllComplexityKindIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters.Builder#addComplexityKindIds(long)}
   */
  @Test
  void testBuilderAddComplexityKindIds() {
    // Arrange
    ImmutableAppComplexityWidgetParameters.Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();

    // Act
    ImmutableAppComplexityWidgetParameters.Builder actualAddComplexityKindIdsResult = builderResult
        .addComplexityKindIds(1L);

    // Assert
    Set<Long> complexityKindIdsResult = actualAddComplexityKindIdsResult.build().complexityKindIds();
    assertEquals(1, complexityKindIdsResult.size());
    Set<Long> complexityKindIdsResult2 = builderResult.build().complexityKindIds();
    assertEquals(1, complexityKindIdsResult2.size());
    assertTrue(complexityKindIdsResult.contains(1L));
    assertTrue(complexityKindIdsResult2.contains(1L));
    assertSame(builderResult, actualAddComplexityKindIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters.Builder#addComplexityKindIds(long[])}
   */
  @Test
  void testBuilderAddComplexityKindIds2() {
    // Arrange
    ImmutableAppComplexityWidgetParameters.Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();

    // Act
    ImmutableAppComplexityWidgetParameters.Builder actualAddComplexityKindIdsResult = builderResult
        .addComplexityKindIds(1L, -1L, 1L, -1L);

    // Assert
    Set<Long> complexityKindIdsResult = builderResult.build().complexityKindIds();
    assertEquals(2, complexityKindIdsResult.size());
    assertTrue(complexityKindIdsResult.contains(-1L));
    assertTrue(complexityKindIdsResult.contains(1L));
    assertSame(builderResult, actualAddComplexityKindIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableAppComplexityWidgetParameters.builder().build().complexityKindIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters.Builder#complexityKindIds(Iterable)}
   */
  @Test
  void testBuilderComplexityKindIds() {
    // Arrange
    ImmutableAppComplexityWidgetParameters.Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();

    // Act
    ImmutableAppComplexityWidgetParameters.Builder actualComplexityKindIdsResult = builderResult
        .complexityKindIds(new ArrayList<>());

    // Assert
    assertTrue(actualComplexityKindIdsResult.build().complexityKindIds().isEmpty());
    assertSame(builderResult, actualComplexityKindIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters.Builder#complexityKindIds(Iterable)}
   */
  @Test
  void testBuilderComplexityKindIds2() {
    // Arrange
    ImmutableAppComplexityWidgetParameters.Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableAppComplexityWidgetParameters.Builder actualComplexityKindIdsResult = builderResult
        .complexityKindIds(elements);

    // Assert
    Set<Long> complexityKindIdsResult = builderResult.build().complexityKindIds();
    assertEquals(1, complexityKindIdsResult.size());
    assertTrue(complexityKindIdsResult.contains(1L));
    assertSame(builderResult, actualComplexityKindIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters.Builder#from(AppComplexityWidgetParameters)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAppComplexityWidgetParameters.Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();
    AppComplexityWidgetParameters instance = mock(AppComplexityWidgetParameters.class);
    when(instance.complexityKindIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableAppComplexityWidgetParameters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).complexityKindIds();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters.Builder#from(AppComplexityWidgetParameters)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAppComplexityWidgetParameters.Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    AppComplexityWidgetParameters instance = mock(AppComplexityWidgetParameters.class);
    when(instance.complexityKindIds()).thenReturn(resultLongSet);

    // Act
    ImmutableAppComplexityWidgetParameters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).complexityKindIds();
    Set<Long> complexityKindIdsResult = builderResult.build().complexityKindIds();
    assertEquals(1, complexityKindIdsResult.size());
    assertTrue(complexityKindIdsResult.contains(1L));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters#copyOf(AppComplexityWidgetParameters)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AppComplexityWidgetParameters instance = mock(AppComplexityWidgetParameters.class);
    when(instance.complexityKindIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableAppComplexityWidgetParameters actualCopyOfResult = ImmutableAppComplexityWidgetParameters.copyOf(instance);

    // Assert
    verify(instance).complexityKindIds();
    assertTrue(actualCopyOfResult.complexityKindIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters#copyOf(AppComplexityWidgetParameters)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    AppComplexityWidgetParameters instance = mock(AppComplexityWidgetParameters.class);
    when(instance.complexityKindIds()).thenReturn(resultLongSet);

    // Act
    ImmutableAppComplexityWidgetParameters actualCopyOfResult = ImmutableAppComplexityWidgetParameters.copyOf(instance);

    // Assert
    verify(instance).complexityKindIds();
    Set<Long> complexityKindIdsResult = actualCopyOfResult.complexityKindIds();
    assertEquals(1, complexityKindIdsResult.size());
    assertTrue(complexityKindIdsResult.contains(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters#copyOf(AppComplexityWidgetParameters)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(0L);
    resultLongSet.add(1L);
    AppComplexityWidgetParameters instance = mock(AppComplexityWidgetParameters.class);
    when(instance.complexityKindIds()).thenReturn(resultLongSet);

    // Act
    ImmutableAppComplexityWidgetParameters actualCopyOfResult = ImmutableAppComplexityWidgetParameters.copyOf(instance);

    // Assert
    verify(instance).complexityKindIds();
    assertEquals(resultLongSet, actualCopyOfResult.complexityKindIds());
  }

  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters#fromJson(ImmutableAppComplexityWidgetParameters.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAppComplexityWidgetParameters.Json json = new ImmutableAppComplexityWidgetParameters.Json();

    // Act and Assert
    Set<Long> complexityKindIdsResult = ImmutableAppComplexityWidgetParameters.fromJson(json).complexityKindIds();
    assertTrue(complexityKindIdsResult.isEmpty());
    assertSame(json.complexityKindIds, complexityKindIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters#fromJson(ImmutableAppComplexityWidgetParameters.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableAppComplexityWidgetParameters.Json json = new ImmutableAppComplexityWidgetParameters.Json();
    json.setComplexityKindIds(null);

    // Act and Assert
    assertTrue(ImmutableAppComplexityWidgetParameters.fromJson(json).complexityKindIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters#fromJson(ImmutableAppComplexityWidgetParameters.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<Long> complexityKindIds = new LinkedHashSet<>();
    complexityKindIds.add(1L);

    ImmutableAppComplexityWidgetParameters.Json json = new ImmutableAppComplexityWidgetParameters.Json();
    json.setComplexityKindIds(complexityKindIds);

    // Act and Assert
    Set<Long> complexityKindIdsResult = ImmutableAppComplexityWidgetParameters.fromJson(json).complexityKindIds();
    assertEquals(1, complexityKindIdsResult.size());
    assertTrue(complexityKindIdsResult.contains(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters#fromJson(ImmutableAppComplexityWidgetParameters.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<Long> complexityKindIds = new LinkedHashSet<>();
    complexityKindIds.add(-1L);
    complexityKindIds.add(1L);

    ImmutableAppComplexityWidgetParameters.Json json = new ImmutableAppComplexityWidgetParameters.Json();
    json.setComplexityKindIds(complexityKindIds);

    // Act and Assert
    assertEquals(complexityKindIds, ImmutableAppComplexityWidgetParameters.fromJson(json).complexityKindIds());
  }

  /**
   * Method under test:
   * {@link ImmutableAppComplexityWidgetParameters.Json#complexityKindIds()}
   */
  @Test
  void testJsonComplexityKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAppComplexityWidgetParameters.Json()).complexityKindIds());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAppComplexityWidgetParameters.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange, Act and Assert
    assertTrue((new ImmutableAppComplexityWidgetParameters.Json()).complexityKindIds.isEmpty());
  }
}
