package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableRatingCostWidgetParameters.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableRatingCostWidgetParameters.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRatingCostWidgetParametersDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllCostKindIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then builder build costKindIds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllCostKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllCostKindIds(Iterable); given one; then builder build costKindIds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllCostKindIds(Iterable)"})
  void testBuilderAddAllCostKindIds_givenOne_thenBuilderBuildCostKindIdsIsLinkedHashSet() {
    // Arrange
    Builder builderResult = ImmutableRatingCostWidgetParameters.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllCostKindIdsResult = builderResult.addAllCostKindIds(elements);

    // Assert
    assertEquals(elements, builderResult.build().costKindIds());
    assertSame(builderResult, actualAddAllCostKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllCostKindIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return build costKindIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllCostKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllCostKindIds(Iterable); when ArrayList(); then return build costKindIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllCostKindIds(Iterable)"})
  void testBuilderAddAllCostKindIds_whenArrayList_thenReturnBuildCostKindIdsEmpty() {
    // Arrange
    Builder builderResult = ImmutableRatingCostWidgetParameters.builder();

    // Act
    Builder actualAddAllCostKindIdsResult = builderResult.addAllCostKindIds(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllCostKindIdsResult.build().costKindIds().isEmpty());
    assertSame(builderResult, actualAddAllCostKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addCostKindIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addCostKindIds(long)}
   */
  @Test
  @DisplayName("Test Builder addCostKindIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCostKindIds(long)"})
  void testBuilderAddCostKindIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableRatingCostWidgetParameters.builder();

    // Act
    Builder actualAddCostKindIdsResult = builderResult.addCostKindIds(1L);

    // Assert
    Set<Long> costKindIdsResult = builderResult.build().costKindIds();
    assertEquals(1, costKindIdsResult.size());
    assertTrue(costKindIdsResult.contains(1L));
    assertSame(builderResult, actualAddCostKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addCostKindIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addCostKindIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addCostKindIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCostKindIds(long[])"})
  void testBuilderAddCostKindIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableRatingCostWidgetParameters.builder();

    // Act
    Builder actualAddCostKindIdsResult = builderResult.addCostKindIds(1L, -1L, 1L, -1L);

    // Assert
    Set<Long> costKindIdsResult = builderResult.build().costKindIds();
    assertEquals(2, costKindIdsResult.size());
    assertTrue(costKindIdsResult.contains(-1L));
    assertTrue(costKindIdsResult.contains(1L));
    assertSame(builderResult, actualAddCostKindIdsResult);
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
  @MethodsUnderTest({"ImmutableRatingCostWidgetParameters Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableRatingCostWidgetParameters.builder().build().costKindIds().isEmpty());
  }

  /**
   * Test Builder {@link Builder#costKindIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then builder build costKindIds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#costKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder costKindIds(Iterable); given one; then builder build costKindIds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.costKindIds(Iterable)"})
  void testBuilderCostKindIds_givenOne_thenBuilderBuildCostKindIdsIsLinkedHashSet() {
    // Arrange
    Builder builderResult = ImmutableRatingCostWidgetParameters.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualCostKindIdsResult = builderResult.costKindIds(elements);

    // Assert
    assertEquals(elements, builderResult.build().costKindIds());
    assertSame(builderResult, actualCostKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#costKindIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return build costKindIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#costKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder costKindIds(Iterable); when ArrayList(); then return build costKindIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.costKindIds(Iterable)"})
  void testBuilderCostKindIds_whenArrayList_thenReturnBuildCostKindIdsEmpty() {
    // Arrange
    Builder builderResult = ImmutableRatingCostWidgetParameters.builder();

    // Act
    Builder actualCostKindIdsResult = builderResult.costKindIds(new ArrayList<>());

    // Assert
    assertTrue(actualCostKindIdsResult.build().costKindIds().isEmpty());
    assertSame(builderResult, actualCostKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When builder addCostKindIds one.
   *   <li>Then builder build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(RatingCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test Builder from(RatingCostWidgetParameters); given one; when builder addCostKindIds one; then builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RatingCostWidgetParameters)"})
  void testBuilderFrom_givenOne_whenBuilderAddCostKindIdsOne_thenBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableRatingCostWidgetParameters.builder();

    Builder builderResult2 = ImmutableRatingCostWidgetParameters.builder();
    builderResult2.addCostKindIds(1L);
    ImmutableRatingCostWidgetParameters instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRatingCostWidgetParameters actualImmutableRatingCostWidgetParameters =
        builderResult.build();
    assertEquals(instance, actualImmutableRatingCostWidgetParameters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingCostWidgetParameters)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then builder build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(RatingCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test Builder from(RatingCostWidgetParameters); when builder build; then builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RatingCostWidgetParameters)"})
  void testBuilderFrom_whenBuilderBuild_thenBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableRatingCostWidgetParameters.builder();
    ImmutableRatingCostWidgetParameters instance =
        ImmutableRatingCostWidgetParameters.builder().build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRatingCostWidgetParameters actualImmutableRatingCostWidgetParameters =
        builderResult.build();
    assertEquals(instance, actualImmutableRatingCostWidgetParameters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableRatingCostWidgetParameters#copyOf(RatingCostWidgetParameters)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return costKindIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableRatingCostWidgetParameters#copyOf(RatingCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test copyOf(RatingCostWidgetParameters); when builder build; then return costKindIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingCostWidgetParameters ImmutableRatingCostWidgetParameters.copyOf(RatingCostWidgetParameters)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnCostKindIdsEmpty() {
    // Arrange
    ImmutableRatingCostWidgetParameters instance =
        ImmutableRatingCostWidgetParameters.builder().build();

    // Act and Assert
    assertTrue(ImmutableRatingCostWidgetParameters.copyOf(instance).costKindIds().isEmpty());
  }

  /**
   * Test {@link ImmutableRatingCostWidgetParameters#equals(Object)}, and {@link
   * ImmutableRatingCostWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingCostWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableRatingCostWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingCostWidgetParameters.equals(Object)",
    "int ImmutableRatingCostWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableRatingCostWidgetParameters immutableRatingCostWidgetParameters =
        ImmutableRatingCostWidgetParameters.builder().build();
    ImmutableRatingCostWidgetParameters immutableRatingCostWidgetParameters2 =
        ImmutableRatingCostWidgetParameters.builder().build();

    // Act and Assert
    assertEquals(immutableRatingCostWidgetParameters, immutableRatingCostWidgetParameters2);
    assertEquals(
        immutableRatingCostWidgetParameters.hashCode(),
        immutableRatingCostWidgetParameters2.hashCode());
  }

  /**
   * Test {@link ImmutableRatingCostWidgetParameters#equals(Object)}, and {@link
   * ImmutableRatingCostWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingCostWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableRatingCostWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingCostWidgetParameters.equals(Object)",
    "int ImmutableRatingCostWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableRatingCostWidgetParameters immutableRatingCostWidgetParameters =
        ImmutableRatingCostWidgetParameters.builder().build();

    // Act and Assert
    assertEquals(immutableRatingCostWidgetParameters, immutableRatingCostWidgetParameters);
    int expectedHashCodeResult = immutableRatingCostWidgetParameters.hashCode();
    assertEquals(expectedHashCodeResult, immutableRatingCostWidgetParameters.hashCode());
  }

  /**
   * Test {@link ImmutableRatingCostWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingCostWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingCostWidgetParameters.equals(Object)",
    "int ImmutableRatingCostWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRatingCostWidgetParameters.builder();
    builderResult.addCostKindIds(1L);

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableRatingCostWidgetParameters.builder().build());
  }

  /**
   * Test {@link ImmutableRatingCostWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingCostWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingCostWidgetParameters.equals(Object)",
    "int ImmutableRatingCostWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableRatingCostWidgetParameters.builder().build(), null);
  }

  /**
   * Test {@link ImmutableRatingCostWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingCostWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingCostWidgetParameters.equals(Object)",
    "int ImmutableRatingCostWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableRatingCostWidgetParameters.builder().build(),
        "Different type to ImmutableRatingCostWidgetParameters");
  }

  /**
   * Test {@link ImmutableRatingCostWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add minus one.
   *   <li>Then return costKindIds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingCostWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add minus one; then return costKindIds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingCostWidgetParameters ImmutableRatingCostWidgetParameters.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddMinusOne_thenReturnCostKindIdsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<Long> costKindIds = new LinkedHashSet<>();
    costKindIds.add(-1L);
    costKindIds.add(1L);

    Json json = new Json();
    json.setCostKindIds(costKindIds);

    // Act
    ImmutableRatingCostWidgetParameters actualFromJsonResult =
        ImmutableRatingCostWidgetParameters.fromJson(json);

    // Assert
    assertEquals(costKindIds, actualFromJsonResult.costKindIds());
  }

  /**
   * Test {@link ImmutableRatingCostWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add one.
   *   <li>Then return costKindIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingCostWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add one; then return costKindIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingCostWidgetParameters ImmutableRatingCostWidgetParameters.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddOne_thenReturnCostKindIdsSizeIsOne() {
    // Arrange
    LinkedHashSet<Long> costKindIds = new LinkedHashSet<>();
    costKindIds.add(1L);

    Json json = new Json();
    json.setCostKindIds(costKindIds);

    // Act
    ImmutableRatingCostWidgetParameters actualFromJsonResult =
        ImmutableRatingCostWidgetParameters.fromJson(json);

    // Assert
    Set<Long> costKindIdsResult = actualFromJsonResult.costKindIds();
    assertEquals(1, costKindIdsResult.size());
    assertTrue(costKindIdsResult.contains(1L));
  }

  /**
   * Test {@link ImmutableRatingCostWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) CostKindIds is {@code null}.
   *   <li>Then return costKindIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingCostWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) CostKindIds is 'null'; then return costKindIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingCostWidgetParameters ImmutableRatingCostWidgetParameters.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonCostKindIdsIsNull_thenReturnCostKindIdsEmpty() {
    // Arrange
    Json json = new Json();
    json.setCostKindIds(null);

    // Act
    ImmutableRatingCostWidgetParameters actualFromJsonResult =
        ImmutableRatingCostWidgetParameters.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.costKindIds().isEmpty());
  }

  /**
   * Test {@link ImmutableRatingCostWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return costKindIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingCostWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return costKindIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingCostWidgetParameters ImmutableRatingCostWidgetParameters.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnCostKindIdsEmpty() {
    // Arrange and Act
    ImmutableRatingCostWidgetParameters actualFromJsonResult =
        ImmutableRatingCostWidgetParameters.fromJson(new Json());

    // Assert
    assertTrue(actualFromJsonResult.costKindIds().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingCostWidgetParameters#toString()}
   *   <li>{@link ImmutableRatingCostWidgetParameters#costKindIds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableRatingCostWidgetParameters.costKindIds()",
    "String ImmutableRatingCostWidgetParameters.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableRatingCostWidgetParameters immutableRatingCostWidgetParameters =
        ImmutableRatingCostWidgetParameters.builder().build();

    // Act
    String actualToStringResult = immutableRatingCostWidgetParameters.toString();

    // Assert
    assertEquals("RatingCostWidgetParameters{costKindIds=[]}", actualToStringResult);
    assertTrue(immutableRatingCostWidgetParameters.costKindIds().isEmpty());
  }

  /**
   * Test Json {@link Json#costKindIds()}.
   *
   * <p>Method under test: {@link Json#costKindIds()}
   */
  @Test
  @DisplayName("Test Json costKindIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.costKindIds()"})
  void testJsonCostKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().costKindIds());
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
    // Arrange, Act and Assert
    assertTrue(new Json().costKindIds.isEmpty());
  }

  /**
   * Test {@link ImmutableRatingCostWidgetParameters#withCostKindIds(Iterable)} with {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return costKindIds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingCostWidgetParameters#withCostKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withCostKindIds(Iterable) with 'Iterable'; given one; then return costKindIds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingCostWidgetParameters ImmutableRatingCostWidgetParameters.withCostKindIds(Iterable)"
  })
  void testWithCostKindIdsWithIterable_givenOne_thenReturnCostKindIdsIsLinkedHashSet() {
    // Arrange
    ImmutableRatingCostWidgetParameters immutableRatingCostWidgetParameters =
        ImmutableRatingCostWidgetParameters.builder().build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertEquals(
        elements, immutableRatingCostWidgetParameters.withCostKindIds(elements).costKindIds());
  }

  /**
   * Test {@link ImmutableRatingCostWidgetParameters#withCostKindIds(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutableRatingCostWidgetParameters#withCostKindIds(long[])}
   */
  @Test
  @DisplayName("Test withCostKindIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingCostWidgetParameters ImmutableRatingCostWidgetParameters.withCostKindIds(long[])"
  })
  void testWithCostKindIdsWithLong() {
    // Arrange, Act and Assert
    Set<Long> costKindIdsResult =
        ImmutableRatingCostWidgetParameters.builder()
            .build()
            .withCostKindIds(1L, -1L, 1L, -1L)
            .costKindIds();
    assertEquals(2, costKindIdsResult.size());
    assertTrue(costKindIdsResult.contains(-1L));
    assertTrue(costKindIdsResult.contains(1L));
  }
}
