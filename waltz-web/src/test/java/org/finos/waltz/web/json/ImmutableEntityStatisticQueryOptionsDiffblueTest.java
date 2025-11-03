package org.finos.waltz.web.json;

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
import java.util.LinkedHashSet;
import java.util.List;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.web.json.ImmutableEntityStatisticQueryOptions.Builder;
import org.finos.waltz.web.json.ImmutableEntityStatisticQueryOptions.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityStatisticQueryOptionsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllStatisticIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllStatisticIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllStatisticIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllStatisticIds(Iterable)"})
  void testBuilderAddAllStatisticIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllStatisticIds(elements));
  }

  /**
   * Test Builder {@link Builder#addAllStatisticIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllStatisticIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllStatisticIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllStatisticIds(Iterable)"})
  void testBuilderAddAllStatisticIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllStatisticIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addStatisticIds(long)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addStatisticIds(long)}
   */
  @Test
  @DisplayName("Test Builder addStatisticIds(long) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addStatisticIds(long)"})
  void testBuilderAddStatisticIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addStatisticIds(1L));
  }

  /**
   * Test Builder {@link Builder#addStatisticIds(long[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addStatisticIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addStatisticIds(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addStatisticIds(long[])"})
  void testBuilderAddStatisticIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addStatisticIds(1L, -2L, 1L, -2L));
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticQueryOptions)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add minus two.</li>
   *   <li>Then return build statisticIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityStatisticQueryOptions)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticQueryOptions); given ArrayList() add minus two; then return build statisticIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticQueryOptions)"})
  void testBuilderFrom_givenArrayListAddMinusTwo_thenReturnBuildStatisticIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(-2L);
    EntityStatisticQueryOptions instance = mock(EntityStatisticQueryOptions.class);
    when(instance.statisticIds()).thenReturn(resultLongList);
    when(instance.selector()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).selector();
    verify(instance).statisticIds();
    List<Long> statisticIdsResult = actualFromResult.build().statisticIds();
    assertEquals(1, statisticIdsResult.size());
    assertEquals(-2L, statisticIdsResult.get(0).longValue());
    List<Long> statisticIdsResult2 = builderResult.build().statisticIds();
    assertEquals(1, statisticIdsResult2.size());
    assertEquals(-2L, statisticIdsResult2.get(0).longValue());
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticQueryOptions)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build statisticIds Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityStatisticQueryOptions)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticQueryOptions); given ArrayList(); then return build statisticIds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticQueryOptions)"})
  void testBuilderFrom_givenArrayList_thenReturnBuildStatisticIdsEmpty() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();
    EntityStatisticQueryOptions instance = mock(EntityStatisticQueryOptions.class);
    when(instance.statisticIds()).thenReturn(new ArrayList<>());
    when(instance.selector()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).selector();
    verify(instance).statisticIds();
    assertTrue(actualFromResult.build().statisticIds().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityStatisticQueryOptions)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityStatisticQueryOptions)}
   */
  @Test
  @DisplayName("Test Builder from(EntityStatisticQueryOptions); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityStatisticQueryOptions)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();
    EntityStatisticQueryOptions instance = mock(EntityStatisticQueryOptions.class);
    when(instance.statisticIds()).thenThrow(new IllegalStateException("instance"));
    when(instance.selector()).thenReturn(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).selector();
    verify(instance).statisticIds();
  }

  /**
   * Test Builder {@link Builder#selector(IdSelectionOptions)}.
   * <ul>
   *   <li>When {@link IdSelectionOptions}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#selector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder selector(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.selector(IdSelectionOptions)"})
  void testBuilderSelector_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();
    IdSelectionOptions selector = mock(IdSelectionOptions.class);

    // Act and Assert
    assertSame(builderResult, builderResult.selector(selector));
    assertSame(selector, builderResult.build().selector());
  }

  /**
   * Test Builder {@link Builder#statisticIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#statisticIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder statisticIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.statisticIds(Iterable)"})
  void testBuilderStatisticIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.statisticIds(elements));
  }

  /**
   * Test Builder {@link Builder#statisticIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#statisticIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder statisticIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.statisticIds(Iterable)"})
  void testBuilderStatisticIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableEntityStatisticQueryOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.statisticIds(new ArrayList<>()));
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
    assertNull(actualJson.selector);
    assertTrue(actualJson.statisticIds.isEmpty());
  }

  /**
   * Test Json {@link Json#selector()}.
   * <p>
   * Method under test: {@link Json#selector()}
   */
  @Test
  @DisplayName("Test Json selector()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IdSelectionOptions Json.selector()"})
  void testJsonSelector() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).selector());
  }

  /**
   * Test Json {@link Json#statisticIds()}.
   * <p>
   * Method under test: {@link Json#statisticIds()}
   */
  @Test
  @DisplayName("Test Json statisticIds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.statisticIds()"})
  void testJsonStatisticIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).statisticIds());
  }
}
