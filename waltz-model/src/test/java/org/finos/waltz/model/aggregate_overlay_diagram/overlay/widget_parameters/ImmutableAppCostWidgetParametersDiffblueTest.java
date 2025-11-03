package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAppCostWidgetParameters.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAppCostWidgetParameters.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppCostWidgetParametersDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllCostKindIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllCostKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCostKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllCostKindIds(Iterable)"})
  void testBuilderAddAllCostKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCostKindIds(elements));
  }

  /**
   * Test Builder {@link Builder#addAllCostKindIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllCostKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCostKindIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllCostKindIds(Iterable)"})
  void testBuilderAddAllCostKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCostKindIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addCostKindIds(long)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addCostKindIds(long)}
   */
  @Test
  @DisplayName("Test Builder addCostKindIds(long) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCostKindIds(long)"})
  void testBuilderAddCostKindIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCostKindIds(1L));
  }

  /**
   * Test Builder {@link Builder#addCostKindIds(long[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addCostKindIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addCostKindIds(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCostKindIds(long[])"})
  void testBuilderAddCostKindIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCostKindIds(1L, -2L, 1L, -2L));
  }

  /**
   * Test Builder {@link Builder#allocationSchemeId(Long)}.
   * <p>
   * Method under test: {@link Builder#allocationSchemeId(Long)}
   */
  @Test
  @DisplayName("Test Builder allocationSchemeId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.allocationSchemeId(Long)"})
  void testBuilderAllocationSchemeId() {
    // Arrange
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    // Act
    Builder actualAllocationSchemeIdResult = builderResult.allocationSchemeId(1L);

    // Assert
    assertEquals(1L, builderResult.build().allocationSchemeId().longValue());
    assertSame(builderResult, actualAllocationSchemeIdResult);
  }

  /**
   * Test Builder {@link Builder#costKindIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#costKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder costKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.costKindIds(Iterable)"})
  void testBuilderCostKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.costKindIds(elements));
  }

  /**
   * Test Builder {@link Builder#costKindIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#costKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder costKindIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.costKindIds(Iterable)"})
  void testBuilderCostKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.costKindIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(AppCostWidgetParameters)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add minus two.</li>
   *   <li>Then builder build costKindIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppCostWidgetParameters)}
   */
  @Test
  @DisplayName("Test Builder from(AppCostWidgetParameters); given HashSet() add minus two; then builder build costKindIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppCostWidgetParameters)"})
  void testBuilderFrom_givenHashSetAddMinusTwo_thenBuilderBuildCostKindIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    AppCostWidgetParameters instance = mock(AppCostWidgetParameters.class);
    when(instance.allocationSchemeId()).thenReturn(1L);
    when(instance.costKindIds()).thenReturn(resultLongSet);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(AppCostWidgetParameters)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build allocationSchemeId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppCostWidgetParameters)}
   */
  @Test
  @DisplayName("Test Builder from(AppCostWidgetParameters); given HashSet(); then builder build allocationSchemeId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppCostWidgetParameters)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildAllocationSchemeIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();
    AppCostWidgetParameters instance = mock(AppCostWidgetParameters.class);
    when(instance.allocationSchemeId()).thenReturn(1L);
    when(instance.costKindIds()).thenReturn(new HashSet<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemeId();
    verify(instance).costKindIds();
    assertEquals(1L, builderResult.build().allocationSchemeId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Json {@link Json#allocationSchemeId()}.
   * <p>
   * Method under test: {@link Json#allocationSchemeId()}
   */
  @Test
  @DisplayName("Test Json allocationSchemeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.allocationSchemeId()"})
  void testJsonAllocationSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).allocationSchemeId());
  }

  /**
   * Test Json {@link Json#costKindIds()}.
   * <p>
   * Method under test: {@link Json#costKindIds()}
   */
  @Test
  @DisplayName("Test Json costKindIds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.costKindIds()"})
  void testJsonCostKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).costKindIds());
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
    assertNull(actualJson.allocationSchemeId);
    assertTrue(actualJson.costKindIds.isEmpty());
  }
}
