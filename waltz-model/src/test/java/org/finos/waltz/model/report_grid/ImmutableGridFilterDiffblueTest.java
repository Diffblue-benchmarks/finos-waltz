package org.finos.waltz.model.report_grid;

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

class ImmutableGridFilterDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableGridFilter.Builder#addAllFilterValues(Iterable)}
   */
  @Test
  void testBuilderAddAllFilterValues() {
    // Arrange
    ImmutableGridFilter.Builder builderResult = ImmutableGridFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFilterValues(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableGridFilter.Builder#addAllFilterValues(Iterable)}
   */
  @Test
  void testBuilderAddAllFilterValues2() {
    // Arrange
    ImmutableGridFilter.Builder builderResult = ImmutableGridFilter.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFilterValues(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableGridFilter.Builder#addFilterValues(String)}
   */
  @Test
  void testBuilderAddFilterValues() {
    // Arrange
    ImmutableGridFilter.Builder builderResult = ImmutableGridFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addFilterValues("Element"));
  }

  /**
   * Method under test:
   * {@link ImmutableGridFilter.Builder#addFilterValues(String[])}
   */
  @Test
  void testBuilderAddFilterValues2() {
    // Arrange
    ImmutableGridFilter.Builder builderResult = ImmutableGridFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addFilterValues("Elements"));
  }

  /**
   * Method under test:
   * {@link ImmutableGridFilter.Builder#columnDefinitionId(Long)}
   */
  @Test
  void testBuilderColumnDefinitionId() {
    // Arrange
    ImmutableGridFilter.Builder builderResult = ImmutableGridFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnDefinitionId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableGridFilter.Builder#filterOperator(FilterOperator)}
   */
  @Test
  void testBuilderFilterOperator() {
    // Arrange
    ImmutableGridFilter.Builder builderResult = ImmutableGridFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.filterOperator(FilterOperator.CONTAINS_ANY_OPTION));
  }

  /**
   * Method under test: {@link ImmutableGridFilter.Builder#filterValues(Iterable)}
   */
  @Test
  void testBuilderFilterValues() {
    // Arrange
    ImmutableGridFilter.Builder builderResult = ImmutableGridFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.filterValues(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableGridFilter.Builder#filterValues(Iterable)}
   */
  @Test
  void testBuilderFilterValues2() {
    // Arrange
    ImmutableGridFilter.Builder builderResult = ImmutableGridFilter.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.filterValues(elements));
  }

  /**
   * Method under test: {@link ImmutableGridFilter.Builder#from(GridFilter)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableGridFilter.Builder builderResult = ImmutableGridFilter.builder();
    GridFilter instance = mock(GridFilter.class);
    when(instance.filterValues()).thenReturn(new HashSet<>());
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.filterOperator()).thenReturn(FilterOperator.CONTAINS_ANY_OPTION);

    // Act
    ImmutableGridFilter.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).columnDefinitionId();
    verify(instance).filterOperator();
    verify(instance).filterValues();
    ImmutableGridFilter buildResult = builderResult.build();
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(FilterOperator.CONTAINS_ANY_OPTION, buildResult.filterOperator());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableGridFilter.Builder#from(GridFilter)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableGridFilter.Builder builderResult = ImmutableGridFilter.builder();
    GridFilter instance = mock(GridFilter.class);
    when(instance.filterValues()).thenThrow(new IllegalStateException("instance"));
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.filterOperator()).thenReturn(FilterOperator.CONTAINS_ANY_OPTION);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).columnDefinitionId();
    verify(instance).filterOperator();
    verify(instance).filterValues();
  }

  /**
   * Method under test: {@link ImmutableGridFilter.Builder#from(GridFilter)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableGridFilter.Builder builderResult = ImmutableGridFilter.builder();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("instance");
    GridFilter instance = mock(GridFilter.class);
    when(instance.filterValues()).thenReturn(stringSet);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.filterOperator()).thenReturn(FilterOperator.CONTAINS_ANY_OPTION);

    // Act
    ImmutableGridFilter.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).columnDefinitionId();
    verify(instance).filterOperator();
    verify(instance).filterValues();
    ImmutableGridFilter buildResult = builderResult.build();
    Set<String> filterValuesResult = buildResult.filterValues();
    assertEquals(1, filterValuesResult.size());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(FilterOperator.CONTAINS_ANY_OPTION, buildResult.filterOperator());
    assertTrue(filterValuesResult.contains("instance"));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableGridFilter#copyOf(GridFilter)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    GridFilter instance = mock(GridFilter.class);
    when(instance.filterValues()).thenReturn(new HashSet<>());
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.filterOperator()).thenReturn(FilterOperator.CONTAINS_ANY_OPTION);

    // Act
    ImmutableGridFilter actualCopyOfResult = ImmutableGridFilter.copyOf(instance);

    // Assert
    verify(instance).columnDefinitionId();
    verify(instance).filterOperator();
    verify(instance).filterValues();
    assertEquals(1L, actualCopyOfResult.columnDefinitionId().longValue());
    assertEquals(FilterOperator.CONTAINS_ANY_OPTION, actualCopyOfResult.filterOperator());
    assertTrue(actualCopyOfResult.filterValues().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableGridFilter#copyOf(GridFilter)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("instance");
    GridFilter instance = mock(GridFilter.class);
    when(instance.filterValues()).thenReturn(stringSet);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.filterOperator()).thenReturn(FilterOperator.CONTAINS_ANY_OPTION);

    // Act
    ImmutableGridFilter actualCopyOfResult = ImmutableGridFilter.copyOf(instance);

    // Assert
    verify(instance).columnDefinitionId();
    verify(instance).filterOperator();
    verify(instance).filterValues();
    Set<String> filterValuesResult = actualCopyOfResult.filterValues();
    assertEquals(1, filterValuesResult.size());
    assertEquals(1L, actualCopyOfResult.columnDefinitionId().longValue());
    assertEquals(FilterOperator.CONTAINS_ANY_OPTION, actualCopyOfResult.filterOperator());
    assertTrue(filterValuesResult.contains("instance"));
  }

  /**
   * Method under test: {@link ImmutableGridFilter#copyOf(GridFilter)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("columnDefinitionId");
    stringSet.add("instance");
    GridFilter instance = mock(GridFilter.class);
    when(instance.filterValues()).thenReturn(stringSet);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.filterOperator()).thenReturn(FilterOperator.CONTAINS_ANY_OPTION);

    // Act
    ImmutableGridFilter actualCopyOfResult = ImmutableGridFilter.copyOf(instance);

    // Assert
    verify(instance).columnDefinitionId();
    verify(instance).filterOperator();
    verify(instance).filterValues();
    assertEquals(1L, actualCopyOfResult.columnDefinitionId().longValue());
    assertEquals(FilterOperator.CONTAINS_ANY_OPTION, actualCopyOfResult.filterOperator());
    assertEquals(stringSet, actualCopyOfResult.filterValues());
  }

  /**
   * Method under test:
   * {@link ImmutableGridFilter#fromJson(ImmutableGridFilter.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableGridFilter.Json json = new ImmutableGridFilter.Json();
    json.setColumnDefinitionId(1L);
    json.setFilterOperator(FilterOperator.CONTAINS_ANY_OPTION);
    json.setFilterValues(null);

    // Act
    ImmutableGridFilter actualFromJsonResult = ImmutableGridFilter.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.columnDefinitionId().longValue());
    assertEquals(FilterOperator.CONTAINS_ANY_OPTION, actualFromJsonResult.filterOperator());
    assertTrue(actualFromJsonResult.filterValues().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableGridFilter#fromJson(ImmutableGridFilter.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<String> filterValues = new LinkedHashSet<>();
    filterValues.add("Json");

    ImmutableGridFilter.Json json = new ImmutableGridFilter.Json();
    json.setColumnDefinitionId(1L);
    json.setFilterOperator(FilterOperator.CONTAINS_ANY_OPTION);
    json.setFilterValues(filterValues);

    // Act
    ImmutableGridFilter actualFromJsonResult = ImmutableGridFilter.fromJson(json);

    // Assert
    Set<String> filterValuesResult = actualFromJsonResult.filterValues();
    assertEquals(1, filterValuesResult.size());
    assertEquals(1L, actualFromJsonResult.columnDefinitionId().longValue());
    assertEquals(FilterOperator.CONTAINS_ANY_OPTION, actualFromJsonResult.filterOperator());
    assertTrue(filterValuesResult.contains("Json"));
  }

  /**
   * Method under test:
   * {@link ImmutableGridFilter#fromJson(ImmutableGridFilter.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<String> filterValues = new LinkedHashSet<>();
    filterValues.add("columnDefinitionId");
    filterValues.add("Json");

    ImmutableGridFilter.Json json = new ImmutableGridFilter.Json();
    json.setColumnDefinitionId(1L);
    json.setFilterOperator(FilterOperator.CONTAINS_ANY_OPTION);
    json.setFilterValues(filterValues);

    // Act
    ImmutableGridFilter actualFromJsonResult = ImmutableGridFilter.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.columnDefinitionId().longValue());
    assertEquals(FilterOperator.CONTAINS_ANY_OPTION, actualFromJsonResult.filterOperator());
    assertEquals(filterValues, actualFromJsonResult.filterValues());
  }

  /**
   * Method under test: {@link ImmutableGridFilter.Json#columnDefinitionId()}
   */
  @Test
  void testJsonColumnDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableGridFilter.Json()).columnDefinitionId());
  }

  /**
   * Method under test: {@link ImmutableGridFilter.Json#filterOperator()}
   */
  @Test
  void testJsonFilterOperator() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableGridFilter.Json()).filterOperator());
  }

  /**
   * Method under test: {@link ImmutableGridFilter.Json#filterValues()}
   */
  @Test
  void testJsonFilterValues() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableGridFilter.Json()).filterValues());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableGridFilter.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableGridFilter.Json actualJson = new ImmutableGridFilter.Json();

    // Assert
    assertNull(actualJson.columnDefinitionId);
    assertNull(actualJson.filterOperator);
    assertTrue(actualJson.filterValues.isEmpty());
  }
}
