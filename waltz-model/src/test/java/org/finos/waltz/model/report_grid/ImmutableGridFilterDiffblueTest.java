package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllFilterValues(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllFilterValues(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllFilterValues(Iterable)"})
  void testBuilderAddAllFilterValues_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    Builder actualAddAllFilterValuesResult = builderResult.addAllFilterValues(elements);

    // Assert
    assertSame(builderResult, actualAddAllFilterValuesResult);
  }

  /**
   * Test Builder {@link Builder#addAllFilterValues(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllFilterValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllFilterValues(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllFilterValues(Iterable)"})
  void testBuilderAddAllFilterValues_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    // Act
    Builder actualAddAllFilterValuesResult = builderResult.addAllFilterValues(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllFilterValuesResult);
  }

  /**
   * Test Builder {@link Builder#addFilterValues(String)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addFilterValues(String)}
   */
  @Test
  @DisplayName("Test Builder addFilterValues(String) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addFilterValues(String)"})
  void testBuilderAddFilterValuesWithElement() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    // Act
    Builder actualAddFilterValuesResult = builderResult.addFilterValues("Element");

    // Assert
    assertSame(builderResult, actualAddFilterValuesResult);
  }

  /**
   * Test Builder {@link Builder#addFilterValues(String[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addFilterValues(String[])}
   */
  @Test
  @DisplayName("Test Builder addFilterValues(String[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addFilterValues(String[])"})
  void testBuilderAddFilterValuesWithElements() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    // Act
    Builder actualAddFilterValuesResult = builderResult.addFilterValues("Elements");

    // Assert
    assertSame(builderResult, actualAddFilterValuesResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGridFilter Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableGridFilter actualImmutableGridFilter =
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build();

    // Assert
    assertEquals(1L, actualImmutableGridFilter.columnDefinitionId().longValue());
    assertEquals(FilterOperator.CONTAINS_ANY_OPTION, actualImmutableGridFilter.filterOperator());
    assertTrue(actualImmutableGridFilter.filterValues().isEmpty());
  }

  /**
   * Test Builder {@link Builder#columnDefinitionId(Long)}.
   *
   * <p>Method under test: {@link Builder#columnDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test Builder columnDefinitionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.columnDefinitionId(Long)"})
  void testBuilderColumnDefinitionId() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    // Act
    Builder actualColumnDefinitionIdResult = builderResult.columnDefinitionId(1L);

    // Assert
    assertSame(builderResult, actualColumnDefinitionIdResult);
  }

  /**
   * Test Builder {@link Builder#filterOperator(FilterOperator)}.
   *
   * <p>Method under test: {@link Builder#filterOperator(FilterOperator)}
   */
  @Test
  @DisplayName("Test Builder filterOperator(FilterOperator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.filterOperator(FilterOperator)"})
  void testBuilderFilterOperator() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    // Act
    Builder actualFilterOperatorResult =
        builderResult.filterOperator(FilterOperator.CONTAINS_ANY_OPTION);

    // Assert
    assertSame(builderResult, actualFilterOperatorResult);
  }

  /**
   * Test Builder {@link Builder#filterValues(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#filterValues(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder filterValues(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.filterValues(Iterable)"})
  void testBuilderFilterValues_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    Builder actualFilterValuesResult = builderResult.filterValues(elements);

    // Assert
    assertSame(builderResult, actualFilterValuesResult);
  }

  /**
   * Test Builder {@link Builder#filterValues(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#filterValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder filterValues(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.filterValues(Iterable)"})
  void testBuilderFilterValues_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    // Act
    Builder actualFilterValuesResult = builderResult.filterValues(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualFilterValuesResult);
  }

  /**
   * Test Builder {@link Builder#from(GridFilter)}.
   *
   * <p>Method under test: {@link Builder#from(GridFilter)}
   */
  @Test
  @DisplayName("Test Builder from(GridFilter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(GridFilter)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();
    ImmutableGridFilter instance =
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build();

    // Act and Assert
    ImmutableGridFilter actualImmutableGridFilter = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableGridFilter);
  }

  /**
   * Test Builder {@link Builder#from(GridFilter)}.
   *
   * <p>Method under test: {@link Builder#from(GridFilter)}
   */
  @Test
  @DisplayName("Test Builder from(GridFilter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(GridFilter)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();

    Builder builderResult2 = ImmutableGridFilter.builder();
    builderResult2.addFilterValues("instance");
    ImmutableGridFilter instance =
        builderResult2
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableGridFilter actualImmutableGridFilter = builderResult.build();
    assertEquals(instance, actualImmutableGridFilter);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableGridFilter#copyOf(GridFilter)}.
   *
   * <ul>
   *   <li>Then return columnDefinitionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGridFilter#copyOf(GridFilter)}
   */
  @Test
  @DisplayName("Test copyOf(GridFilter); then return columnDefinitionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGridFilter ImmutableGridFilter.copyOf(GridFilter)"})
  void testCopyOf_thenReturnColumnDefinitionIdLongValueIsOne() {
    // Arrange
    ImmutableGridFilter instance =
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build();

    // Act
    ImmutableGridFilter actualCopyOfResult = ImmutableGridFilter.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.columnDefinitionId().longValue());
    assertEquals(FilterOperator.CONTAINS_ANY_OPTION, actualCopyOfResult.filterOperator());
    assertTrue(actualCopyOfResult.filterValues().isEmpty());
  }

  /**
   * Test {@link ImmutableGridFilter#equals(Object)}, and {@link ImmutableGridFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableGridFilter#equals(Object)}
   *   <li>{@link ImmutableGridFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGridFilter.equals(Object)",
    "int ImmutableGridFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableGridFilter immutableGridFilter =
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build();
    ImmutableGridFilter immutableGridFilter2 =
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build();

    // Act and Assert
    assertEquals(immutableGridFilter, immutableGridFilter2);
    assertEquals(immutableGridFilter.hashCode(), immutableGridFilter2.hashCode());
  }

  /**
   * Test {@link ImmutableGridFilter#equals(Object)}, and {@link ImmutableGridFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableGridFilter#equals(Object)}
   *   <li>{@link ImmutableGridFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGridFilter.equals(Object)",
    "int ImmutableGridFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableGridFilter immutableGridFilter =
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build();

    // Act and Assert
    assertEquals(immutableGridFilter, immutableGridFilter);
    int expectedHashCodeResult = immutableGridFilter.hashCode();
    assertEquals(expectedHashCodeResult, immutableGridFilter.hashCode());
  }

  /**
   * Test {@link ImmutableGridFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGridFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGridFilter.equals(Object)",
    "int ImmutableGridFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableGridFilter.builder();
    builderResult.addFilterValues("Element");
    ImmutableGridFilter immutableGridFilter =
        builderResult
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableGridFilter,
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build());
  }

  /**
   * Test {@link ImmutableGridFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGridFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGridFilter.equals(Object)",
    "int ImmutableGridFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableGridFilter immutableGridFilter =
        ImmutableGridFilter.builder()
            .columnDefinitionId(2L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableGridFilter,
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build());
  }

  /**
   * Test {@link ImmutableGridFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGridFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGridFilter.equals(Object)",
    "int ImmutableGridFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableGridFilter immutableGridFilter =
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_STRING)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableGridFilter,
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build());
  }

  /**
   * Test {@link ImmutableGridFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGridFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGridFilter.equals(Object)",
    "int ImmutableGridFilter.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableGridFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGridFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGridFilter.equals(Object)",
    "int ImmutableGridFilter.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build(),
        "Different type to ImmutableGridFilter");
  }

  /**
   * Test {@link ImmutableGridFilter#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) FilterValues is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGridFilter#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) FilterValues is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGridFilter ImmutableGridFilter.fromJson(Json)"})
  void testFromJson_givenHashSet_whenJsonFilterValuesIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setColumnDefinitionId(1L);
    json.setFilterOperator(FilterOperator.CONTAINS_ANY_OPTION);
    json.setFilterValues(new HashSet<>());

    // Act
    ImmutableGridFilter actualFromJsonResult = ImmutableGridFilter.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.columnDefinitionId().longValue());
    assertEquals(FilterOperator.CONTAINS_ANY_OPTION, actualFromJsonResult.filterOperator());
    assertTrue(actualFromJsonResult.filterValues().isEmpty());
  }

  /**
   * Test {@link ImmutableGridFilter#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code Json}.
   *   <li>Then return filterValues size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGridFilter#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add 'Json'; then return filterValues size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGridFilter ImmutableGridFilter.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnFilterValuesSizeIsOne() {
    // Arrange
    LinkedHashSet<String> filterValues = new LinkedHashSet<>();
    filterValues.add("Json");

    Json json = new Json();
    json.setColumnDefinitionId(1L);
    json.setFilterOperator(FilterOperator.CONTAINS_ANY_OPTION);
    json.setFilterValues(filterValues);

    // Act
    ImmutableGridFilter actualFromJsonResult = ImmutableGridFilter.fromJson(json);

    // Assert
    Set<String> filterValuesResult = actualFromJsonResult.filterValues();
    assertEquals(1, filterValuesResult.size());
    assertTrue(filterValuesResult.contains("Json"));
  }

  /**
   * Test {@link ImmutableGridFilter#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return columnDefinitionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGridFilter#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return columnDefinitionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGridFilter ImmutableGridFilter.fromJson(Json)"})
  void testFromJson_thenReturnColumnDefinitionIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
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
   * Test {@link ImmutableGridFilter#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return filterValues is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGridFilter#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return filterValues is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGridFilter ImmutableGridFilter.fromJson(Json)"})
  void testFromJson_thenReturnFilterValuesIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<String> filterValues = new LinkedHashSet<>();
    filterValues.add("columnDefinitionId");
    filterValues.add("Json");

    Json json = new Json();
    json.setColumnDefinitionId(1L);
    json.setFilterOperator(FilterOperator.CONTAINS_ANY_OPTION);
    json.setFilterValues(filterValues);

    // Act
    ImmutableGridFilter actualFromJsonResult = ImmutableGridFilter.fromJson(json);

    // Assert
    assertEquals(filterValues, actualFromJsonResult.filterValues());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableGridFilter#toString()}
   *   <li>{@link ImmutableGridFilter#columnDefinitionId()}
   *   <li>{@link ImmutableGridFilter#filterOperator()}
   *   <li>{@link ImmutableGridFilter#filterValues()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableGridFilter.columnDefinitionId()",
    "FilterOperator ImmutableGridFilter.filterOperator()",
    "Set ImmutableGridFilter.filterValues()",
    "String ImmutableGridFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableGridFilter immutableGridFilter =
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build();

    // Act
    String actualToStringResult = immutableGridFilter.toString();
    Long actualColumnDefinitionIdResult = immutableGridFilter.columnDefinitionId();
    FilterOperator actualFilterOperatorResult = immutableGridFilter.filterOperator();
    Set<String> actualFilterValuesResult = immutableGridFilter.filterValues();

    // Assert
    assertEquals(
        "GridFilter{columnDefinitionId=1, filterOperator=CONTAINS_ANY_OPTION, filterValues=[]}",
        actualToStringResult);
    assertEquals(1L, actualColumnDefinitionIdResult.longValue());
    assertEquals(FilterOperator.CONTAINS_ANY_OPTION, actualFilterOperatorResult);
    assertTrue(actualFilterValuesResult.isEmpty());
  }

  /**
   * Test Json {@link Json#columnDefinitionId()}.
   *
   * <p>Method under test: {@link Json#columnDefinitionId()}
   */
  @Test
  @DisplayName("Test Json columnDefinitionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.columnDefinitionId()"})
  void testJsonColumnDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().columnDefinitionId());
  }

  /**
   * Test Json {@link Json#filterOperator()}.
   *
   * <p>Method under test: {@link Json#filterOperator()}
   */
  @Test
  @DisplayName("Test Json filterOperator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FilterOperator Json.filterOperator()"})
  void testJsonFilterOperator() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().filterOperator());
  }

  /**
   * Test Json {@link Json#filterValues()}.
   *
   * <p>Method under test: {@link Json#filterValues()}
   */
  @Test
  @DisplayName("Test Json filterValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.filterValues()"})
  void testJsonFilterValues() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().filterValues());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.columnDefinitionId);
    assertNull(actualJson.filterOperator);
    assertTrue(actualJson.filterValues.isEmpty());
  }

  /**
   * Test {@link ImmutableGridFilter#withColumnDefinitionId(Long)}.
   *
   * <p>Method under test: {@link ImmutableGridFilter#withColumnDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test withColumnDefinitionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGridFilter ImmutableGridFilter.withColumnDefinitionId(Long)"})
  void testWithColumnDefinitionId() {
    // Arrange
    ImmutableGridFilter immutableGridFilter =
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build();

    // Act
    ImmutableGridFilter actualWithColumnDefinitionIdResult =
        immutableGridFilter.withColumnDefinitionId(1L);

    // Assert
    assertSame(immutableGridFilter, actualWithColumnDefinitionIdResult);
  }

  /**
   * Test {@link ImmutableGridFilter#withColumnDefinitionId(Long)}.
   *
   * <ul>
   *   <li>Then return columnDefinitionId longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGridFilter#withColumnDefinitionId(Long)}
   */
  @Test
  @DisplayName(
      "Test withColumnDefinitionId(Long); then return columnDefinitionId longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGridFilter ImmutableGridFilter.withColumnDefinitionId(Long)"})
  void testWithColumnDefinitionId_thenReturnColumnDefinitionIdLongValueIsFortyTwo() {
    // Arrange and Act
    ImmutableGridFilter actualWithColumnDefinitionIdResult =
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build()
            .withColumnDefinitionId(42L);

    // Assert
    assertEquals(42L, actualWithColumnDefinitionIdResult.columnDefinitionId().longValue());
    assertEquals(
        FilterOperator.CONTAINS_ANY_OPTION, actualWithColumnDefinitionIdResult.filterOperator());
    assertTrue(actualWithColumnDefinitionIdResult.filterValues().isEmpty());
  }

  /**
   * Test {@link ImmutableGridFilter#withFilterOperator(FilterOperator)}.
   *
   * <p>Method under test: {@link ImmutableGridFilter#withFilterOperator(FilterOperator)}
   */
  @Test
  @DisplayName("Test withFilterOperator(FilterOperator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGridFilter ImmutableGridFilter.withFilterOperator(FilterOperator)"})
  void testWithFilterOperator() {
    // Arrange
    ImmutableGridFilter immutableGridFilter =
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build();

    // Act
    ImmutableGridFilter actualWithFilterOperatorResult =
        immutableGridFilter.withFilterOperator(FilterOperator.CONTAINS_ANY_OPTION);

    // Assert
    assertSame(immutableGridFilter, actualWithFilterOperatorResult);
  }

  /**
   * Test {@link ImmutableGridFilter#withFilterOperator(FilterOperator)}.
   *
   * <ul>
   *   <li>Then return columnDefinitionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGridFilter#withFilterOperator(FilterOperator)}
   */
  @Test
  @DisplayName(
      "Test withFilterOperator(FilterOperator); then return columnDefinitionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGridFilter ImmutableGridFilter.withFilterOperator(FilterOperator)"})
  void testWithFilterOperator_thenReturnColumnDefinitionIdLongValueIsOne() {
    // Arrange and Act
    ImmutableGridFilter actualWithFilterOperatorResult =
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_STRING)
            .build()
            .withFilterOperator(FilterOperator.CONTAINS_ANY_OPTION);

    // Assert
    assertEquals(1L, actualWithFilterOperatorResult.columnDefinitionId().longValue());
    assertEquals(
        FilterOperator.CONTAINS_ANY_OPTION, actualWithFilterOperatorResult.filterOperator());
    assertTrue(actualWithFilterOperatorResult.filterValues().isEmpty());
  }

  /**
   * Test {@link ImmutableGridFilter#withFilterValues(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then return columnDefinitionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGridFilter#withFilterValues(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withFilterValues(Iterable) with 'Iterable'; then return columnDefinitionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGridFilter ImmutableGridFilter.withFilterValues(Iterable)"})
  void testWithFilterValuesWithIterable_thenReturnColumnDefinitionIdLongValueIsOne() {
    // Arrange
    ImmutableGridFilter immutableGridFilter =
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    ImmutableGridFilter actualWithFilterValuesResult =
        immutableGridFilter.withFilterValues(elements);

    // Assert
    assertEquals(1L, actualWithFilterValuesResult.columnDefinitionId().longValue());
    assertEquals(FilterOperator.CONTAINS_ANY_OPTION, actualWithFilterValuesResult.filterOperator());
    assertEquals(elements, actualWithFilterValuesResult.filterValues());
  }

  /**
   * Test {@link ImmutableGridFilter#withFilterValues(String[])} with {@code String[]}.
   *
   * <p>Method under test: {@link ImmutableGridFilter#withFilterValues(String[])}
   */
  @Test
  @DisplayName("Test withFilterValues(String[]) with 'String[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGridFilter ImmutableGridFilter.withFilterValues(String[])"})
  void testWithFilterValuesWithString() {
    // Arrange and Act
    ImmutableGridFilter actualWithFilterValuesResult =
        ImmutableGridFilter.builder()
            .columnDefinitionId(1L)
            .filterOperator(FilterOperator.CONTAINS_ANY_OPTION)
            .build()
            .withFilterValues("Elements");

    // Assert
    Set<String> filterValuesResult = actualWithFilterValuesResult.filterValues();
    assertEquals(1, filterValuesResult.size());
    assertEquals(1L, actualWithFilterValuesResult.columnDefinitionId().longValue());
    assertEquals(FilterOperator.CONTAINS_ANY_OPTION, actualWithFilterValuesResult.filterOperator());
    assertTrue(filterValuesResult.contains("Elements"));
  }
}
