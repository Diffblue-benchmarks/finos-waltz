package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

class ImmutableAppCostWidgetParametersDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters.Builder#addAllCostKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllCostKindIds() {
    // Arrange
    ImmutableAppCostWidgetParameters.Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCostKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters.Builder#addAllCostKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllCostKindIds2() {
    // Arrange
    ImmutableAppCostWidgetParameters.Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCostKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters.Builder#addCostKindIds(long)}
   */
  @Test
  void testBuilderAddCostKindIds() {
    // Arrange
    ImmutableAppCostWidgetParameters.Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCostKindIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters.Builder#addCostKindIds(long[])}
   */
  @Test
  void testBuilderAddCostKindIds2() {
    // Arrange
    ImmutableAppCostWidgetParameters.Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCostKindIds(1L, -2L, 1L, -2L));
  }

  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters.Builder#allocationSchemeId(Long)}
   */
  @Test
  void testBuilderAllocationSchemeId() {
    // Arrange
    ImmutableAppCostWidgetParameters.Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    // Act
    ImmutableAppCostWidgetParameters.Builder actualAllocationSchemeIdResult = builderResult.allocationSchemeId(1L);

    // Assert
    assertEquals(1L, builderResult.build().allocationSchemeId().longValue());
    assertSame(builderResult, actualAllocationSchemeIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters.Builder#costKindIds(Iterable)}
   */
  @Test
  void testBuilderCostKindIds() {
    // Arrange
    ImmutableAppCostWidgetParameters.Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.costKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters.Builder#costKindIds(Iterable)}
   */
  @Test
  void testBuilderCostKindIds2() {
    // Arrange
    ImmutableAppCostWidgetParameters.Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.costKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters.Builder#from(AppCostWidgetParameters)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAppCostWidgetParameters.Builder builderResult = ImmutableAppCostWidgetParameters.builder();
    AppCostWidgetParameters instance = mock(AppCostWidgetParameters.class);
    when(instance.allocationSchemeId()).thenReturn(1L);
    when(instance.costKindIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableAppCostWidgetParameters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemeId();
    verify(instance).costKindIds();
    assertEquals(1L, builderResult.build().allocationSchemeId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters.Builder#from(AppCostWidgetParameters)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAppCostWidgetParameters.Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    AppCostWidgetParameters instance = mock(AppCostWidgetParameters.class);
    when(instance.allocationSchemeId()).thenReturn(1L);
    when(instance.costKindIds()).thenReturn(resultLongSet);

    // Act
    ImmutableAppCostWidgetParameters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemeId();
    verify(instance).costKindIds();
    ImmutableAppCostWidgetParameters buildResult = builderResult.build();
    Set<Long> costKindIdsResult = buildResult.costKindIds();
    assertEquals(1, costKindIdsResult.size());
    assertEquals(1L, buildResult.allocationSchemeId().longValue());
    assertTrue(costKindIdsResult.contains(-2L));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters#copyOf(AppCostWidgetParameters)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AppCostWidgetParameters instance = mock(AppCostWidgetParameters.class);
    when(instance.allocationSchemeId()).thenReturn(1L);
    when(instance.costKindIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableAppCostWidgetParameters actualCopyOfResult = ImmutableAppCostWidgetParameters.copyOf(instance);

    // Assert
    verify(instance).allocationSchemeId();
    verify(instance).costKindIds();
    assertEquals(1L, actualCopyOfResult.allocationSchemeId().longValue());
    assertTrue(actualCopyOfResult.costKindIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters#copyOf(AppCostWidgetParameters)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    AppCostWidgetParameters instance = mock(AppCostWidgetParameters.class);
    when(instance.allocationSchemeId()).thenReturn(1L);
    when(instance.costKindIds()).thenReturn(resultLongSet);

    // Act
    ImmutableAppCostWidgetParameters actualCopyOfResult = ImmutableAppCostWidgetParameters.copyOf(instance);

    // Assert
    verify(instance).allocationSchemeId();
    verify(instance).costKindIds();
    Set<Long> costKindIdsResult = actualCopyOfResult.costKindIds();
    assertEquals(1, costKindIdsResult.size());
    assertEquals(1L, actualCopyOfResult.allocationSchemeId().longValue());
    assertTrue(costKindIdsResult.contains(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters#copyOf(AppCostWidgetParameters)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    resultLongSet.add(1L);
    AppCostWidgetParameters instance = mock(AppCostWidgetParameters.class);
    when(instance.allocationSchemeId()).thenReturn(1L);
    when(instance.costKindIds()).thenReturn(resultLongSet);

    // Act
    ImmutableAppCostWidgetParameters actualCopyOfResult = ImmutableAppCostWidgetParameters.copyOf(instance);

    // Assert
    verify(instance).allocationSchemeId();
    verify(instance).costKindIds();
    assertEquals(1L, actualCopyOfResult.allocationSchemeId().longValue());
    assertEquals(resultLongSet, actualCopyOfResult.costKindIds());
  }

  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters#fromJson(ImmutableAppCostWidgetParameters.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAppCostWidgetParameters.Json json = new ImmutableAppCostWidgetParameters.Json();
    json.setAllocationSchemeId(1L);
    json.setCostKindIds(null);

    // Act
    ImmutableAppCostWidgetParameters actualFromJsonResult = ImmutableAppCostWidgetParameters.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.allocationSchemeId().longValue());
    assertTrue(actualFromJsonResult.costKindIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters#fromJson(ImmutableAppCostWidgetParameters.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<Long> costKindIds = new LinkedHashSet<>();
    costKindIds.add(1L);

    ImmutableAppCostWidgetParameters.Json json = new ImmutableAppCostWidgetParameters.Json();
    json.setAllocationSchemeId(1L);
    json.setCostKindIds(costKindIds);

    // Act
    ImmutableAppCostWidgetParameters actualFromJsonResult = ImmutableAppCostWidgetParameters.fromJson(json);

    // Assert
    Set<Long> costKindIdsResult = actualFromJsonResult.costKindIds();
    assertEquals(1, costKindIdsResult.size());
    assertEquals(1L, actualFromJsonResult.allocationSchemeId().longValue());
    assertTrue(costKindIdsResult.contains(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters#fromJson(ImmutableAppCostWidgetParameters.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<Long> costKindIds = new LinkedHashSet<>();
    costKindIds.add(-1L);
    costKindIds.add(1L);

    ImmutableAppCostWidgetParameters.Json json = new ImmutableAppCostWidgetParameters.Json();
    json.setAllocationSchemeId(1L);
    json.setCostKindIds(costKindIds);

    // Act
    ImmutableAppCostWidgetParameters actualFromJsonResult = ImmutableAppCostWidgetParameters.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.allocationSchemeId().longValue());
    assertEquals(costKindIds, actualFromJsonResult.costKindIds());
  }

  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters.Json#allocationSchemeId()}
   */
  @Test
  void testJsonAllocationSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAppCostWidgetParameters.Json()).allocationSchemeId());
  }

  /**
   * Method under test:
   * {@link ImmutableAppCostWidgetParameters.Json#costKindIds()}
   */
  @Test
  void testJsonCostKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAppCostWidgetParameters.Json()).costKindIds());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAppCostWidgetParameters.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAppCostWidgetParameters.Json actualJson = new ImmutableAppCostWidgetParameters.Json();

    // Assert
    assertNull(actualJson.allocationSchemeId);
    assertTrue(actualJson.costKindIds.isEmpty());
  }
}
