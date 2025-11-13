package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MapUtilitiesDiffblueTest {
  /**
   * Test {@link MapUtilities#newHashMap()}.
   *
   * <p>Method under test: {@link MapUtilities#newHashMap()}
   */
  @Test
  @DisplayName("Test newHashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HashMap MapUtilities.newHashMap()"})
  void testNewHashMap() {
    // Arrange and Act
    HashMap<Object, Object> actualNewHashMapResult = MapUtilities.newHashMap();

    // Assert
    assertTrue(actualNewHashMapResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#newHashMap(Object, Object, Object, Object)} with {@code k1}, {@code
   * v1}, {@code k2}, {@code v2}.
   *
   * <p>Method under test: {@link MapUtilities#newHashMap(Object, Object, Object, Object)}
   */
  @Test
  @DisplayName("Test newHashMap(Object, Object, Object, Object) with 'k1', 'v1', 'k2', 'v2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.newHashMap(Object, Object, Object, Object)"})
  void testNewHashMapWithK1V1K2V2() {
    // Arrange and Act
    Map<Object, Object> actualNewHashMapResult = MapUtilities.newHashMap("K1", "V1", "K2", "V2");

    // Assert
    assertEquals(2, actualNewHashMapResult.size());
    assertEquals("V1", actualNewHashMapResult.get("K1"));
    assertEquals("V2", actualNewHashMapResult.get("K2"));
  }

  /**
   * Test {@link MapUtilities#newHashMap(Object, Object, Object, Object, Object, Object)} with
   * {@code k1}, {@code v1}, {@code k2}, {@code v2}, {@code k3}, {@code v3}.
   *
   * <p>Method under test: {@link MapUtilities#newHashMap(Object, Object, Object, Object, Object,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test newHashMap(Object, Object, Object, Object, Object, Object) with 'k1', 'v1', 'k2', 'v2', 'k3', 'v3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.newHashMap(Object, Object, Object, Object, Object, Object)"})
  void testNewHashMapWithK1V1K2V2K3V3() {
    // Arrange and Act
    Map<Object, Object> actualNewHashMapResult =
        MapUtilities.newHashMap("K1", "V1", "K2", "V2", "K3", "V3");

    // Assert
    assertEquals(3, actualNewHashMapResult.size());
    assertEquals("V1", actualNewHashMapResult.get("K1"));
    assertEquals("V2", actualNewHashMapResult.get("K2"));
    assertEquals("V3", actualNewHashMapResult.get("K3"));
  }

  /**
   * Test {@link MapUtilities#newHashMap(Object, Object, Object, Object, Object, Object, Object,
   * Object)} with {@code k1}, {@code v1}, {@code k2}, {@code v2}, {@code k3}, {@code v3}, {@code
   * k4}, {@code v4}.
   *
   * <p>Method under test: {@link MapUtilities#newHashMap(Object, Object, Object, Object, Object,
   * Object, Object, Object)}
   */
  @Test
  @DisplayName(
      "Test newHashMap(Object, Object, Object, Object, Object, Object, Object, Object) with 'k1', 'v1', 'k2', 'v2', 'k3', 'v3', 'k4', 'v4'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map MapUtilities.newHashMap(Object, Object, Object, Object, Object, Object, Object, Object)"
  })
  void testNewHashMapWithK1V1K2V2K3V3K4V4() {
    // Arrange and Act
    Map<Object, Object> actualNewHashMapResult =
        MapUtilities.newHashMap("K1", "V1", "K2", "V2", "K3", "V3", "K4", "V4");

    // Assert
    assertEquals(4, actualNewHashMapResult.size());
    assertEquals("V1", actualNewHashMapResult.get("K1"));
    assertEquals("V2", actualNewHashMapResult.get("K2"));
    assertEquals("V3", actualNewHashMapResult.get("K3"));
    assertEquals("V4", actualNewHashMapResult.get("K4"));
  }

  /**
   * Test {@link MapUtilities#newHashMap(Object, Object, Object, Object, Object, Object, Object,
   * Object, Object, Object)} with {@code k1}, {@code v1}, {@code k2}, {@code v2}, {@code k3},
   * {@code v3}, {@code k4}, {@code v4}, {@code k5}, {@code v5}.
   *
   * <p>Method under test: {@link MapUtilities#newHashMap(Object, Object, Object, Object, Object,
   * Object, Object, Object, Object, Object)}
   */
  @Test
  @DisplayName(
      "Test newHashMap(Object, Object, Object, Object, Object, Object, Object, Object, Object, Object) with 'k1', 'v1', 'k2', 'v2', 'k3', 'v3', 'k4', 'v4', 'k5', 'v5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map MapUtilities.newHashMap(Object, Object, Object, Object, Object, Object, Object, Object, Object, Object)"
  })
  void testNewHashMapWithK1V1K2V2K3V3K4V4K5V5() {
    // Arrange and Act
    Map<Object, Object> actualNewHashMapResult =
        MapUtilities.newHashMap("K1", "V1", "K2", "V2", "K3", "V3", "K4", "V4", "K5", "V5");

    // Assert
    assertEquals(5, actualNewHashMapResult.size());
    assertEquals("V1", actualNewHashMapResult.get("K1"));
    assertEquals("V2", actualNewHashMapResult.get("K2"));
    assertEquals("V3", actualNewHashMapResult.get("K3"));
    assertEquals("V4", actualNewHashMapResult.get("K4"));
    assertEquals("V5", actualNewHashMapResult.get("K5"));
  }

  /**
   * Test {@link MapUtilities#newHashMap(Object, Object, Object, Object, Object, Object, Object,
   * Object, Object, Object, Object, Object)} with {@code k1}, {@code v1}, {@code k2}, {@code v2},
   * {@code k3}, {@code v3}, {@code k4}, {@code v4}, {@code k5}, {@code v5}, {@code k6}, {@code v6}.
   *
   * <p>Method under test: {@link MapUtilities#newHashMap(Object, Object, Object, Object, Object,
   * Object, Object, Object, Object, Object, Object, Object)}
   */
  @Test
  @DisplayName(
      "Test newHashMap(Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object) with 'k1', 'v1', 'k2', 'v2', 'k3', 'v3', 'k4', 'v4', 'k5', 'v5', 'k6', 'v6'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map MapUtilities.newHashMap(Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object)"
  })
  void testNewHashMapWithK1V1K2V2K3V3K4V4K5V5K6V6() {
    // Arrange and Act
    Map<Object, Object> actualNewHashMapResult =
        MapUtilities.newHashMap(
            "K1", "V1", "K2", "V2", "K3", "V3", "K4", "V4", "K5", "V5", "K6", "V6");

    // Assert
    assertEquals(6, actualNewHashMapResult.size());
    assertEquals("V1", actualNewHashMapResult.get("K1"));
    assertEquals("V2", actualNewHashMapResult.get("K2"));
    assertEquals("V3", actualNewHashMapResult.get("K3"));
    assertEquals("V4", actualNewHashMapResult.get("K4"));
    assertEquals("V5", actualNewHashMapResult.get("K5"));
    assertEquals("V6", actualNewHashMapResult.get("K6"));
  }

  /**
   * Test {@link MapUtilities#newHashMap(Object, Object)} with {@code key}, {@code val}.
   *
   * <p>Method under test: {@link MapUtilities#newHashMap(Object, Object)}
   */
  @Test
  @DisplayName("Test newHashMap(Object, Object) with 'key', 'val'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.newHashMap(Object, Object)"})
  void testNewHashMapWithKeyVal() {
    // Arrange and Act
    Map<Object, Object> actualNewHashMapResult = MapUtilities.newHashMap("Key", "Val");

    // Assert
    assertEquals(1, actualNewHashMapResult.size());
    assertEquals("Val", actualNewHashMapResult.get("Key"));
  }

  /**
   * Test {@link MapUtilities#groupBy(Function, Function, Collection)} with {@code keyFn}, {@code
   * valueFn}, {@code xs}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>Then return {@code Apply} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#groupBy(Function, Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test groupBy(Function, Function, Collection) with 'keyFn', 'valueFn', 'xs'; given 'Apply'; then return 'Apply' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.groupBy(Function, Function, Collection)"})
  void testGroupByWithKeyFnValueFnXs_givenApply_thenReturnApplySizeIsOne() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(keyFn, valueFn, xs);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    verify(valueFn).apply(isA(Object.class));
    assertEquals(1, actualGroupByResult.size());
    Collection<Object> getResult = actualGroupByResult.get("Apply");
    assertEquals(1, getResult.size());
    assertTrue(getResult instanceof List);
    assertEquals("Apply", ((List<Object>) getResult).get(0));
  }

  /**
   * Test {@link MapUtilities#groupBy(Function, Function, Collection)} with {@code keyFn}, {@code
   * valueFn}, {@code xs}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>Then return {@code Apply} size is two.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#groupBy(Function, Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test groupBy(Function, Function, Collection) with 'keyFn', 'valueFn', 'xs'; given 'Apply'; then return 'Apply' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.groupBy(Function, Function, Collection)"})
  void testGroupByWithKeyFnValueFnXs_givenApply_thenReturnApplySizeIsTwo() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(keyFn, valueFn, xs);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    verify(valueFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualGroupByResult.size());
    Collection<Object> getResult = actualGroupByResult.get("Apply");
    assertEquals(2, getResult.size());
    assertTrue(getResult instanceof List);
    assertEquals("Apply", ((List<Object>) getResult).get(0));
    assertEquals("Apply", ((List<Object>) getResult).get(1));
  }

  /**
   * Test {@link MapUtilities#groupBy(Function, Function, Collection)} with {@code keyFn}, {@code
   * valueFn}, {@code xs}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#groupBy(Function, Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test groupBy(Function, Function, Collection) with 'keyFn', 'valueFn', 'xs'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.groupBy(Function, Function, Collection)"})
  void testGroupByWithKeyFnValueFnXs_whenArrayList_thenReturnEmpty() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    Function<Object, Object> valueFn = mock(Function.class);

    // Act
    Map<Object, Collection<Object>> actualGroupByResult =
        MapUtilities.groupBy(keyFn, valueFn, new ArrayList<>());

    // Assert
    assertTrue(actualGroupByResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#groupBy(Function, Collection)} with {@code keyFn}, {@code xs}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#groupBy(Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test groupBy(Function, Collection) with 'keyFn', 'xs'; given 'Apply'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.groupBy(Function, Collection)"})
  void testGroupByWithKeyFnXs_givenApply_thenReturnSizeIsOne() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(keyFn, xs);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    assertEquals(1, actualGroupByResult.size());
    assertEquals(xs, actualGroupByResult.get("Apply"));
  }

  /**
   * Test {@link MapUtilities#groupBy(Function, Collection)} with {@code keyFn}, {@code xs}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#groupBy(Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test groupBy(Function, Collection) with 'keyFn', 'xs'; given 'Apply'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.groupBy(Function, Collection)"})
  void testGroupByWithKeyFnXs_givenApply_thenReturnSizeIsOne2() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(keyFn, xs);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualGroupByResult.size());
    assertEquals(xs, actualGroupByResult.get("Apply"));
  }

  /**
   * Test {@link MapUtilities#groupBy(Function, Collection)} with {@code keyFn}, {@code xs}.
   *
   * <ul>
   *   <li>When {@link Function}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#groupBy(Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test groupBy(Function, Collection) with 'keyFn', 'xs'; when Function; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.groupBy(Function, Collection)"})
  void testGroupByWithKeyFnXs_whenFunction_thenReturnEmpty() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);

    // Act
    Map<Object, Collection<Object>> actualGroupByResult =
        MapUtilities.groupBy(keyFn, new ArrayList<>());

    // Assert
    assertTrue(actualGroupByResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#groupBy(Collection, Function, Function)} with {@code xs}, {@code
   * keyFn}, {@code valueFn}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@code Apply} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#groupBy(Collection, Function, Function)}
   */
  @Test
  @DisplayName(
      "Test groupBy(Collection, Function, Function) with 'xs', 'keyFn', 'valueFn'; given '42'; then return 'Apply' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.groupBy(Collection, Function, Function)"})
  void testGroupByWithXsKeyFnValueFn_given42_thenReturnApplySizeIsOne() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(xs, keyFn, valueFn);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    verify(valueFn).apply(isA(Object.class));
    assertEquals(1, actualGroupByResult.size());
    Collection<Object> getResult = actualGroupByResult.get("Apply");
    assertEquals(1, getResult.size());
    assertTrue(getResult instanceof List);
    assertEquals("Apply", ((List<Object>) getResult).get(0));
  }

  /**
   * Test {@link MapUtilities#groupBy(Collection, Function, Function)} with {@code xs}, {@code
   * keyFn}, {@code valueFn}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@code Apply} size is two.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#groupBy(Collection, Function, Function)}
   */
  @Test
  @DisplayName(
      "Test groupBy(Collection, Function, Function) with 'xs', 'keyFn', 'valueFn'; given '42'; then return 'Apply' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.groupBy(Collection, Function, Function)"})
  void testGroupByWithXsKeyFnValueFn_given42_thenReturnApplySizeIsTwo() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(xs, keyFn, valueFn);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    verify(valueFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualGroupByResult.size());
    Collection<Object> getResult = actualGroupByResult.get("Apply");
    assertEquals(2, getResult.size());
    assertTrue(getResult instanceof List);
    assertEquals("Apply", ((List<Object>) getResult).get(0));
    assertEquals("Apply", ((List<Object>) getResult).get(1));
  }

  /**
   * Test {@link MapUtilities#groupBy(Collection, Function, Function)} with {@code xs}, {@code
   * keyFn}, {@code valueFn}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#groupBy(Collection, Function, Function)}
   */
  @Test
  @DisplayName(
      "Test groupBy(Collection, Function, Function) with 'xs', 'keyFn', 'valueFn'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.groupBy(Collection, Function, Function)"})
  void testGroupByWithXsKeyFnValueFn_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Map<Object, Collection<Object>> actualGroupByResult =
        MapUtilities.groupBy(new ArrayList<>(), mock(Function.class), mock(Function.class));

    // Assert
    assertTrue(actualGroupByResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#groupBy(Collection, Function)} with {@code xs}, {@code keyFn}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#groupBy(Collection, Function)}
   */
  @Test
  @DisplayName(
      "Test groupBy(Collection, Function) with 'xs', 'keyFn'; given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.groupBy(Collection, Function)"})
  void testGroupByWithXsKeyFn_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(xs, keyFn);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    assertEquals(1, actualGroupByResult.size());
    assertEquals(xs, actualGroupByResult.get("Apply"));
  }

  /**
   * Test {@link MapUtilities#groupBy(Collection, Function)} with {@code xs}, {@code keyFn}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#groupBy(Collection, Function)}
   */
  @Test
  @DisplayName(
      "Test groupBy(Collection, Function) with 'xs', 'keyFn'; given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.groupBy(Collection, Function)"})
  void testGroupByWithXsKeyFn_given42_whenArrayListAdd42_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Collection<Object>> actualGroupByResult = MapUtilities.groupBy(xs, keyFn);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualGroupByResult.size());
    assertEquals(xs, actualGroupByResult.get("Apply"));
  }

  /**
   * Test {@link MapUtilities#groupBy(Collection, Function)} with {@code xs}, {@code keyFn}.
   *
   * <ul>
   *   <li>When {@link Function}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#groupBy(Collection, Function)}
   */
  @Test
  @DisplayName(
      "Test groupBy(Collection, Function) with 'xs', 'keyFn'; when Function; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.groupBy(Collection, Function)"})
  void testGroupByWithXsKeyFn_whenFunction_thenReturnEmpty() {
    // Arrange and Act
    Map<Object, Collection<Object>> actualGroupByResult =
        MapUtilities.groupBy(new ArrayList<>(), mock(Function.class));

    // Assert
    assertTrue(actualGroupByResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#indexBy(Function, Function, Collection, BinaryOperator)} with {@code
   * keyFn}, {@code valueFn}, {@code xs}, {@code mergeFunction}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#indexBy(Function, Function, Collection,
   * BinaryOperator)}
   */
  @Test
  @DisplayName(
      "Test indexBy(Function, Function, Collection, BinaryOperator) with 'keyFn', 'valueFn', 'xs', 'mergeFunction'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.indexBy(Function, Function, Collection, BinaryOperator)"})
  void testIndexByWithKeyFnValueFnXsMergeFunction_whenArrayList_thenReturnEmpty() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    Function<Object, Object> valueFn = mock(Function.class);

    // Act
    Map<Object, Object> actualIndexByResult =
        MapUtilities.indexBy(keyFn, valueFn, new ArrayList<>(), mock(BinaryOperator.class));

    // Assert
    assertTrue(actualIndexByResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#indexBy(Function, Function, Collection)} with {@code keyFn}, {@code
   * valueFn}, {@code xs}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#indexBy(Function, Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test indexBy(Function, Function, Collection) with 'keyFn', 'valueFn', 'xs'; given 'Apply'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.indexBy(Function, Function, Collection)"})
  void testIndexByWithKeyFnValueFnXs_givenApply_thenReturnSizeIsOne() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(keyFn, valueFn, xs);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    verify(valueFn).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("Apply", actualIndexByResult.get("Apply"));
  }

  /**
   * Test {@link MapUtilities#indexBy(Function, Function, Collection)} with {@code keyFn}, {@code
   * valueFn}, {@code xs}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#indexBy(Function, Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test indexBy(Function, Function, Collection) with 'keyFn', 'valueFn', 'xs'; given 'Apply'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.indexBy(Function, Function, Collection)"})
  void testIndexByWithKeyFnValueFnXs_givenApply_thenReturnSizeIsOne2() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(keyFn, valueFn, xs);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    verify(valueFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("Apply", actualIndexByResult.get("Apply"));
  }

  /**
   * Test {@link MapUtilities#indexBy(Function, Function, Collection)} with {@code keyFn}, {@code
   * valueFn}, {@code xs}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#indexBy(Function, Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test indexBy(Function, Function, Collection) with 'keyFn', 'valueFn', 'xs'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.indexBy(Function, Function, Collection)"})
  void testIndexByWithKeyFnValueFnXs_whenArrayList_thenReturnEmpty() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    Function<Object, Object> valueFn = mock(Function.class);

    // Act
    Map<Object, Object> actualIndexByResult =
        MapUtilities.indexBy(keyFn, valueFn, new ArrayList<>());

    // Assert
    assertTrue(actualIndexByResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#indexBy(Function, Collection)} with {@code keyFn}, {@code xs}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#indexBy(Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test indexBy(Function, Collection) with 'keyFn', 'xs'; given 'Apply'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.indexBy(Function, Collection)"})
  void testIndexByWithKeyFnXs_givenApply_thenReturnSizeIsOne() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(keyFn, xs);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("42", actualIndexByResult.get("Apply"));
  }

  /**
   * Test {@link MapUtilities#indexBy(Function, Collection)} with {@code keyFn}, {@code xs}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#indexBy(Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test indexBy(Function, Collection) with 'keyFn', 'xs'; given 'Apply'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.indexBy(Function, Collection)"})
  void testIndexByWithKeyFnXs_givenApply_thenReturnSizeIsOne2() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(keyFn, xs);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("42", actualIndexByResult.get("Apply"));
  }

  /**
   * Test {@link MapUtilities#indexBy(Function, Collection)} with {@code keyFn}, {@code xs}.
   *
   * <ul>
   *   <li>When {@link Function}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#indexBy(Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test indexBy(Function, Collection) with 'keyFn', 'xs'; when Function; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.indexBy(Function, Collection)"})
  void testIndexByWithKeyFnXs_whenFunction_thenReturnEmpty() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(keyFn, new ArrayList<>());

    // Assert
    assertTrue(actualIndexByResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#indexBy(Collection, Function, Function, BinaryOperator)} with {@code
   * xs}, {@code keyFn}, {@code valueFn}, {@code mergeFunction}.
   *
   * <ul>
   *   <li>When {@link BinaryOperator}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#indexBy(Collection, Function, Function,
   * BinaryOperator)}
   */
  @Test
  @DisplayName(
      "Test indexBy(Collection, Function, Function, BinaryOperator) with 'xs', 'keyFn', 'valueFn', 'mergeFunction'; when BinaryOperator; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.indexBy(Collection, Function, Function, BinaryOperator)"})
  void testIndexByWithXsKeyFnValueFnMergeFunction_whenBinaryOperator_thenReturnEmpty() {
    // Arrange and Act
    Map<Object, Object> actualIndexByResult =
        MapUtilities.indexBy(
            new ArrayList<>(),
            mock(Function.class),
            mock(Function.class),
            mock(BinaryOperator.class));

    // Assert
    assertTrue(actualIndexByResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#indexBy(Collection, Function, Function)} with {@code xs}, {@code
   * keyFn}, {@code valueFn}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#indexBy(Collection, Function, Function)}
   */
  @Test
  @DisplayName(
      "Test indexBy(Collection, Function, Function) with 'xs', 'keyFn', 'valueFn'; given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.indexBy(Collection, Function, Function)"})
  void testIndexByWithXsKeyFnValueFn_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(xs, keyFn, valueFn);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    verify(valueFn).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("Apply", actualIndexByResult.get("Apply"));
  }

  /**
   * Test {@link MapUtilities#indexBy(Collection, Function, Function)} with {@code xs}, {@code
   * keyFn}, {@code valueFn}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#indexBy(Collection, Function, Function)}
   */
  @Test
  @DisplayName(
      "Test indexBy(Collection, Function, Function) with 'xs', 'keyFn', 'valueFn'; given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.indexBy(Collection, Function, Function)"})
  void testIndexByWithXsKeyFnValueFn_given42_whenArrayListAdd42_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    Function<Object, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(xs, keyFn, valueFn);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    verify(valueFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("Apply", actualIndexByResult.get("Apply"));
  }

  /**
   * Test {@link MapUtilities#indexBy(Collection, Function, Function)} with {@code xs}, {@code
   * keyFn}, {@code valueFn}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#indexBy(Collection, Function, Function)}
   */
  @Test
  @DisplayName(
      "Test indexBy(Collection, Function, Function) with 'xs', 'keyFn', 'valueFn'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.indexBy(Collection, Function, Function)"})
  void testIndexByWithXsKeyFnValueFn_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Map<Object, Object> actualIndexByResult =
        MapUtilities.indexBy(new ArrayList<>(), mock(Function.class), mock(Function.class));

    // Assert
    assertTrue(actualIndexByResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#indexBy(Collection, Function)} with {@code xs}, {@code keyFn}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#indexBy(Collection, Function)}
   */
  @Test
  @DisplayName(
      "Test indexBy(Collection, Function) with 'xs', 'keyFn'; given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.indexBy(Collection, Function)"})
  void testIndexByWithXsKeyFn_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(xs, keyFn);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("42", actualIndexByResult.get("Apply"));
  }

  /**
   * Test {@link MapUtilities#indexBy(Collection, Function)} with {@code xs}, {@code keyFn}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#indexBy(Collection, Function)}
   */
  @Test
  @DisplayName(
      "Test indexBy(Collection, Function) with 'xs', 'keyFn'; given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.indexBy(Collection, Function)"})
  void testIndexByWithXsKeyFn_given42_whenArrayListAdd42_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Object> actualIndexByResult = MapUtilities.indexBy(xs, keyFn);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualIndexByResult.size());
    assertEquals("42", actualIndexByResult.get("Apply"));
  }

  /**
   * Test {@link MapUtilities#indexBy(Collection, Function)} with {@code xs}, {@code keyFn}.
   *
   * <ul>
   *   <li>When {@link Function}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#indexBy(Collection, Function)}
   */
  @Test
  @DisplayName(
      "Test indexBy(Collection, Function) with 'xs', 'keyFn'; when Function; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.indexBy(Collection, Function)"})
  void testIndexByWithXsKeyFn_whenFunction_thenReturnEmpty() {
    // Arrange and Act
    Map<Object, Object> actualIndexByResult =
        MapUtilities.indexBy(new ArrayList<>(), mock(Function.class));

    // Assert
    assertTrue(actualIndexByResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#countBy(Function, Collection)} with {@code keyFn}, {@code xs}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#countBy(Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test countBy(Function, Collection) with 'keyFn', 'xs'; given 'Apply'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.countBy(Function, Collection)"})
  void testCountByWithKeyFnXs_givenApply_thenReturnSizeIsOne() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    // Act
    Map<Object, Long> actualCountByResult = MapUtilities.countBy(keyFn, xs);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualCountByResult.size());
    assertEquals(2L, actualCountByResult.get("Apply").longValue());
  }

  /**
   * Test {@link MapUtilities#countBy(Function, Collection)} with {@code keyFn}, {@code xs}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#countBy(Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test countBy(Function, Collection) with 'keyFn', 'xs'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.countBy(Function, Collection)"})
  void testCountByWithKeyFnXs_whenArrayList_thenReturnEmpty() {
    // Arrange
    Function<Object, Object> keyFn = mock(Function.class);

    // Act
    Map<Object, Long> actualCountByResult = MapUtilities.countBy(keyFn, new ArrayList<>());

    // Assert
    assertTrue(actualCountByResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#countBy(Function, Collection)} with {@code keyFn}, {@code xs}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#countBy(Function, Collection)}
   */
  @Test
  @DisplayName(
      "Test countBy(Function, Collection) with 'keyFn', 'xs'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.countBy(Function, Collection)"})
  void testCountByWithKeyFnXs_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Map<Object, Long> actualCountByResult = MapUtilities.countBy(mock(Function.class), null);

    // Assert
    assertTrue(actualCountByResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#countBy(Collection, Function)} with {@code xs}, {@code keyFn}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#countBy(Collection, Function)}
   */
  @Test
  @DisplayName(
      "Test countBy(Collection, Function) with 'xs', 'keyFn'; given 'Apply'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.countBy(Collection, Function)"})
  void testCountByWithXsKeyFn_givenApply_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    Map<Object, Long> actualCountByResult = MapUtilities.countBy(xs, keyFn);

    // Assert
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualCountByResult.size());
    assertEquals(2L, actualCountByResult.get("Apply").longValue());
  }

  /**
   * Test {@link MapUtilities#countBy(Collection, Function)} with {@code xs}, {@code keyFn}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#countBy(Collection, Function)}
   */
  @Test
  @DisplayName(
      "Test countBy(Collection, Function) with 'xs', 'keyFn'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.countBy(Collection, Function)"})
  void testCountByWithXsKeyFn_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Map<Object, Long> actualCountByResult =
        MapUtilities.countBy(new ArrayList<>(), mock(Function.class));

    // Assert
    assertTrue(actualCountByResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#countBy(Collection, Function)} with {@code xs}, {@code keyFn}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#countBy(Collection, Function)}
   */
  @Test
  @DisplayName(
      "Test countBy(Collection, Function) with 'xs', 'keyFn'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.countBy(Collection, Function)"})
  void testCountByWithXsKeyFn_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Map<Object, Long> actualCountByResult = MapUtilities.countBy(null, mock(Function.class));

    // Assert
    assertTrue(actualCountByResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#ensureNotNull(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#ensureNotNull(Map)}
   */
  @Test
  @DisplayName("Test ensureNotNull(Map); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.ensureNotNull(Map)"})
  void testEnsureNotNull_whenNull() {
    // Arrange and Act
    Map<Object, Object> actualEnsureNotNullResult = MapUtilities.ensureNotNull(null);

    // Assert
    assertTrue(actualEnsureNotNullResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#isEmpty(Map)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When newHashMap {@code Key} is {@code Value}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#isEmpty(Map)}
   */
  @Test
  @DisplayName(
      "Test isEmpty(Map); given 'Key'; when newHashMap 'Key' is 'Value'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapUtilities.isEmpty(Map)"})
  void testIsEmpty_givenKey_whenNewHashMapKeyIsValue_thenReturnFalse() {
    // Arrange
    HashMap<String, Object> map = MapUtilities.newHashMap();
    map.put("Key", "Value");

    // Act and Assert
    assertFalse(MapUtilities.isEmpty(map));
  }

  /**
   * Test {@link MapUtilities#isEmpty(Map)}.
   *
   * <ul>
   *   <li>When newHashMap.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#isEmpty(Map)}
   */
  @Test
  @DisplayName("Test isEmpty(Map); when newHashMap; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapUtilities.isEmpty(Map)"})
  void testIsEmpty_whenNewHashMap_thenReturnTrue() {
    // Arrange
    HashMap<String, Object> map = MapUtilities.newHashMap();

    // Act and Assert
    assertTrue(MapUtilities.isEmpty(map));
  }

  /**
   * Test {@link MapUtilities#isEmpty(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#isEmpty(Map)}
   */
  @Test
  @DisplayName("Test isEmpty(Map); when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapUtilities.isEmpty(Map)"})
  void testIsEmpty_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MapUtilities.isEmpty(null));
  }

  /**
   * Test {@link MapUtilities#maybeGet(Map, Object)}.
   *
   * <ul>
   *   <li>When newHashMap.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#maybeGet(Map, Object)}
   */
  @Test
  @DisplayName("Test maybeGet(Map, Object); when newHashMap")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MapUtilities.maybeGet(Map, Object)"})
  void testMaybeGet_whenNewHashMap() {
    // Arrange
    HashMap<String, Object> map = MapUtilities.newHashMap();

    // Act
    Optional<Object> actualMaybeGetResult = MapUtilities.maybeGet(map, "Key");

    // Assert
    assertFalse(actualMaybeGetResult.isPresent());
  }

  /**
   * Test {@link MapUtilities#maybeGet(Map, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#maybeGet(Map, Object)}
   */
  @Test
  @DisplayName("Test maybeGet(Map, Object); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MapUtilities.maybeGet(Map, Object)"})
  void testMaybeGet_whenNull() {
    // Arrange and Act
    Optional<Object> actualMaybeGetResult = MapUtilities.maybeGet(null, "Key");

    // Assert
    assertFalse(actualMaybeGetResult.isPresent());
  }

  /**
   * Test {@link MapUtilities#groupAndThen(Collection, Function, Function)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#groupAndThen(Collection, Function, Function)}
   */
  @Test
  @DisplayName(
      "Test groupAndThen(Collection, Function, Function); given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.groupAndThen(Collection, Function, Function)"})
  void testGroupAndThen_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");

    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    Function<Collection<Object>, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Collection<Object>>any())).thenReturn("Apply");

    // Act
    Map<Object, Object> actualGroupAndThenResult = MapUtilities.groupAndThen(xs, keyFn, valueFn);

    // Assert
    verify(keyFn).apply(isA(Object.class));
    verify(valueFn).apply(isA(Collection.class));
    assertEquals(1, actualGroupAndThenResult.size());
    assertEquals("Apply", actualGroupAndThenResult.get("Apply"));
  }

  /**
   * Test {@link MapUtilities#groupAndThen(Collection, Function, Function)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#groupAndThen(Collection, Function, Function)}
   */
  @Test
  @DisplayName(
      "Test groupAndThen(Collection, Function, Function); given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.groupAndThen(Collection, Function, Function)"})
  void testGroupAndThen_given42_whenArrayListAdd42_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<Object> xs = new ArrayList<>();
    xs.add("42");
    xs.add("42");

    Function<Object, Object> keyFn = mock(Function.class);
    when(keyFn.apply(Mockito.<Object>any())).thenReturn("Apply");

    Function<Collection<Object>, Object> valueFn = mock(Function.class);
    when(valueFn.apply(Mockito.<Collection<Object>>any())).thenReturn("Apply");

    // Act
    Map<Object, Object> actualGroupAndThenResult = MapUtilities.groupAndThen(xs, keyFn, valueFn);

    // Assert
    verify(valueFn).apply(isA(Collection.class));
    verify(keyFn, atLeast(1)).apply(isA(Object.class));
    assertEquals(1, actualGroupAndThenResult.size());
    assertEquals("Apply", actualGroupAndThenResult.get("Apply"));
  }

  /**
   * Test {@link MapUtilities#groupAndThen(Collection, Function, Function)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#groupAndThen(Collection, Function, Function)}
   */
  @Test
  @DisplayName(
      "Test groupAndThen(Collection, Function, Function); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.groupAndThen(Collection, Function, Function)"})
  void testGroupAndThen_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Map<Object, Object> actualGroupAndThenResult =
        MapUtilities.groupAndThen(new ArrayList<>(), mock(Function.class), mock(Function.class));

    // Assert
    assertTrue(actualGroupAndThenResult.isEmpty());
  }

  /**
   * Test {@link MapUtilities#transformKeys(Map, Function)}.
   *
   * <ul>
   *   <li>When newHashMap.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapUtilities#transformKeys(Map, Function)}
   */
  @Test
  @DisplayName("Test transformKeys(Map, Function); when newHashMap; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapUtilities.transformKeys(Map, Function)"})
  void testTransformKeys_whenNewHashMap_thenReturnEmpty() {
    // Arrange
    HashMap<String, Object> original = MapUtilities.newHashMap();

    // Act
    Map<Object, Object> actualTransformKeysResult =
        MapUtilities.transformKeys(original, mock(Function.class));

    // Assert
    assertTrue(actualTransformKeysResult.isEmpty());
  }
}
