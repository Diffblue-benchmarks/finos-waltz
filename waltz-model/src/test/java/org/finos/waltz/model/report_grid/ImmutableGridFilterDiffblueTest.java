package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.report_grid.ImmutableGridFilter.Builder;
import org.finos.waltz.model.report_grid.ImmutableGridFilter.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableGridFilterDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllFilterValues(Iterable)}.
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllFilterValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllFilterValues(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllFilterValues(Iterable)"})
  void testBuilderAddAllFilterValues_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFilterValues(elements));
  }

  /**
   * Test Builder {@link Builder#addAllFilterValues(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllFilterValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllFilterValues(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllFilterValues(Iterable)"})
  void testBuilderAddAllFilterValues_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFilterValues(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addFilterValues(String)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addFilterValues(String)}
   */
  @Test
  @DisplayName("Test Builder addFilterValues(String) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addFilterValues(String)"})
  void testBuilderAddFilterValuesWithElement() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addFilterValues("Element"));
  }

  /**
   * Test Builder {@link Builder#addFilterValues(String[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addFilterValues(String[])}
   */
  @Test
  @DisplayName("Test Builder addFilterValues(String[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addFilterValues(String[])"})
  void testBuilderAddFilterValuesWithElements() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addFilterValues("Elements"));
  }

  /**
   * Test Builder {@link Builder#columnDefinitionId(Long)}.
   * <p>
   * Method under test: {@link Builder#columnDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test Builder columnDefinitionId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.columnDefinitionId(Long)"})
  void testBuilderColumnDefinitionId() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnDefinitionId(1L));
  }

  /**
   * Test Builder {@link Builder#filterOperator(FilterOperator)}.
   * <p>
   * Method under test: {@link Builder#filterOperator(FilterOperator)}
   */
  @Test
  @DisplayName("Test Builder filterOperator(FilterOperator)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.filterOperator(FilterOperator)"})
  void testBuilderFilterOperator() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.filterOperator(FilterOperator.CONTAINS_ANY_OPTION));
  }

  /**
   * Test Builder {@link Builder#filterValues(Iterable)}.
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#filterValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder filterValues(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.filterValues(Iterable)"})
  void testBuilderFilterValues_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.filterValues(elements));
  }

  /**
   * Test Builder {@link Builder#filterValues(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#filterValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder filterValues(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.filterValues(Iterable)"})
  void testBuilderFilterValues_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.filterValues(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(GridFilter)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code instance}.</li>
   *   <li>Then builder build filterValues size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(GridFilter)}
   */
  @Test
  @DisplayName("Test Builder from(GridFilter); given HashSet() add 'instance'; then builder build filterValues size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(GridFilter)"})
  void testBuilderFrom_givenHashSetAddInstance_thenBuilderBuildFilterValuesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("instance");
    GridFilter instance = mock(GridFilter.class);
    when(instance.filterValues()).thenReturn(stringSet);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.filterOperator()).thenReturn(FilterOperator.CONTAINS_ANY_OPTION);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(GridFilter)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build columnDefinitionId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(GridFilter)}
   */
  @Test
  @DisplayName("Test Builder from(GridFilter); given HashSet(); then builder build columnDefinitionId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(GridFilter)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildColumnDefinitionIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();
    GridFilter instance = mock(GridFilter.class);
    when(instance.filterValues()).thenReturn(new HashSet<>());
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.filterOperator()).thenReturn(FilterOperator.CONTAINS_ANY_OPTION);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(GridFilter)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(GridFilter)}
   */
  @Test
  @DisplayName("Test Builder from(GridFilter); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(GridFilter)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();
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
   * Test Json {@link Json#columnDefinitionId()}.
   * <p>
   * Method under test: {@link Json#columnDefinitionId()}
   */
  @Test
  @DisplayName("Test Json columnDefinitionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.columnDefinitionId()"})
  void testJsonColumnDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).columnDefinitionId());
  }

  /**
   * Test Json {@link Json#filterOperator()}.
   * <p>
   * Method under test: {@link Json#filterOperator()}
   */
  @Test
  @DisplayName("Test Json filterOperator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FilterOperator Json.filterOperator()"})
  void testJsonFilterOperator() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).filterOperator());
  }

  /**
   * Test Json {@link Json#filterValues()}.
   * <p>
   * Method under test: {@link Json#filterValues()}
   */
  @Test
  @DisplayName("Test Json filterValues()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.filterValues()"})
  void testJsonFilterValues() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).filterValues());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.columnDefinitionId);
    assertNull(actualJson.filterOperator);
    assertTrue(actualJson.filterValues.isEmpty());
  }
}
