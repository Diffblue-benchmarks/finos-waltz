package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAppCostWidgetParameters.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAppCostWidgetParameters.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppCostWidgetParametersDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllCostKindIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllCostKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCostKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllCostKindIds(Iterable)"})
  void testBuilderAddAllCostKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllCostKindIdsResult = builderResult.addAllCostKindIds(elements);

    // Assert
    assertSame(builderResult, actualAddAllCostKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllCostKindIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllCostKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCostKindIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllCostKindIds(Iterable)"})
  void testBuilderAddAllCostKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    // Act
    Builder actualAddAllCostKindIdsResult = builderResult.addAllCostKindIds(new ArrayList<>());

    // Assert
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
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    // Act
    Builder actualAddCostKindIdsResult = builderResult.addCostKindIds(1L);

    // Assert
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
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    // Act
    Builder actualAddCostKindIdsResult = builderResult.addCostKindIds(1L, -2L, 1L, -2L);

    // Assert
    assertSame(builderResult, actualAddCostKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#allocationSchemeId(Long)}.
   *
   * <p>Method under test: {@link Builder#allocationSchemeId(Long)}
   */
  @Test
  @DisplayName("Test Builder allocationSchemeId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppCostWidgetParameters Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAppCostWidgetParameters actualImmutableAppCostWidgetParameters =
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build();

    // Assert
    assertEquals(1L, actualImmutableAppCostWidgetParameters.allocationSchemeId().longValue());
    assertTrue(actualImmutableAppCostWidgetParameters.costKindIds().isEmpty());
  }

  /**
   * Test Builder {@link Builder#costKindIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#costKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder costKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.costKindIds(Iterable)"})
  void testBuilderCostKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualCostKindIdsResult = builderResult.costKindIds(elements);

    // Assert
    assertSame(builderResult, actualCostKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#costKindIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#costKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder costKindIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.costKindIds(Iterable)"})
  void testBuilderCostKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    // Act
    Builder actualCostKindIdsResult = builderResult.costKindIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualCostKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#from(AppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Given minus two.
   *   <li>When builder addCostKindIds minus two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AppCostWidgetParameters); given minus two; when builder addCostKindIds minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppCostWidgetParameters)"})
  void testBuilderFrom_givenMinusTwo_whenBuilderAddCostKindIdsMinusTwo() {
    // Arrange
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();

    Builder builderResult2 = ImmutableAppCostWidgetParameters.builder();
    builderResult2.addCostKindIds(-2L);
    ImmutableAppCostWidgetParameters instance = builderResult2.allocationSchemeId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppCostWidgetParameters actualImmutableAppCostWidgetParameters = builderResult.build();
    assertEquals(instance, actualImmutableAppCostWidgetParameters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then builder build is builder allocationSchemeId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AppCostWidgetParameters); then builder build is builder allocationSchemeId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppCostWidgetParameters)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderAllocationSchemeIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();
    ImmutableAppCostWidgetParameters instance =
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppCostWidgetParameters actualImmutableAppCostWidgetParameters = builderResult.build();
    assertEquals(instance, actualImmutableAppCostWidgetParameters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableAppCostWidgetParameters#copyOf(AppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return allocationSchemeId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppCostWidgetParameters#copyOf(AppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AppCostWidgetParameters); then return allocationSchemeId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppCostWidgetParameters ImmutableAppCostWidgetParameters.copyOf(AppCostWidgetParameters)"
  })
  void testCopyOf_thenReturnAllocationSchemeIdLongValueIsOne() {
    // Arrange
    ImmutableAppCostWidgetParameters instance =
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build();

    // Act
    ImmutableAppCostWidgetParameters actualCopyOfResult =
        ImmutableAppCostWidgetParameters.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.allocationSchemeId().longValue());
    assertTrue(actualCopyOfResult.costKindIds().isEmpty());
  }

  /**
   * Test {@link ImmutableAppCostWidgetParameters#equals(Object)}, and {@link
   * ImmutableAppCostWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppCostWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableAppCostWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppCostWidgetParameters.equals(Object)",
    "int ImmutableAppCostWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAppCostWidgetParameters immutableAppCostWidgetParameters =
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build();
    ImmutableAppCostWidgetParameters immutableAppCostWidgetParameters2 =
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build();

    // Act and Assert
    assertEquals(immutableAppCostWidgetParameters, immutableAppCostWidgetParameters2);
    assertEquals(
        immutableAppCostWidgetParameters.hashCode(), immutableAppCostWidgetParameters2.hashCode());
  }

  /**
   * Test {@link ImmutableAppCostWidgetParameters#equals(Object)}, and {@link
   * ImmutableAppCostWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppCostWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableAppCostWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppCostWidgetParameters.equals(Object)",
    "int ImmutableAppCostWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAppCostWidgetParameters immutableAppCostWidgetParameters =
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build();

    // Act and Assert
    assertEquals(immutableAppCostWidgetParameters, immutableAppCostWidgetParameters);
    int expectedHashCodeResult = immutableAppCostWidgetParameters.hashCode();
    assertEquals(expectedHashCodeResult, immutableAppCostWidgetParameters.hashCode());
  }

  /**
   * Test {@link ImmutableAppCostWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppCostWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppCostWidgetParameters.equals(Object)",
    "int ImmutableAppCostWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppCostWidgetParameters.builder();
    builderResult.addCostKindIds(1L);
    ImmutableAppCostWidgetParameters immutableAppCostWidgetParameters =
        builderResult.allocationSchemeId(1L).build();

    // Act and Assert
    assertNotEquals(
        immutableAppCostWidgetParameters,
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());
  }

  /**
   * Test {@link ImmutableAppCostWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppCostWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppCostWidgetParameters.equals(Object)",
    "int ImmutableAppCostWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAppCostWidgetParameters immutableAppCostWidgetParameters =
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(2L).build();

    // Act and Assert
    assertNotEquals(
        immutableAppCostWidgetParameters,
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build());
  }

  /**
   * Test {@link ImmutableAppCostWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppCostWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppCostWidgetParameters.equals(Object)",
    "int ImmutableAppCostWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build(), null);
  }

  /**
   * Test {@link ImmutableAppCostWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppCostWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppCostWidgetParameters.equals(Object)",
    "int ImmutableAppCostWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build(),
        "Different type to ImmutableAppCostWidgetParameters");
  }

  /**
   * Test {@link ImmutableAppCostWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) CostKindIds is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppCostWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) CostKindIds is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppCostWidgetParameters ImmutableAppCostWidgetParameters.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonCostKindIdsIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setAllocationSchemeId(1L);
    json.setCostKindIds(new HashSet<>());

    // Act
    ImmutableAppCostWidgetParameters actualFromJsonResult =
        ImmutableAppCostWidgetParameters.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.allocationSchemeId().longValue());
    assertTrue(actualFromJsonResult.costKindIds().isEmpty());
  }

  /**
   * Test {@link ImmutableAppCostWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add minus one.
   *   <li>Then return costKindIds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppCostWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add minus one; then return costKindIds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppCostWidgetParameters ImmutableAppCostWidgetParameters.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddMinusOne_thenReturnCostKindIdsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<Long> costKindIds = new LinkedHashSet<>();
    costKindIds.add(-1L);
    costKindIds.add(1L);

    Json json = new Json();
    json.setAllocationSchemeId(1L);
    json.setCostKindIds(costKindIds);

    // Act
    ImmutableAppCostWidgetParameters actualFromJsonResult =
        ImmutableAppCostWidgetParameters.fromJson(json);

    // Assert
    assertEquals(costKindIds, actualFromJsonResult.costKindIds());
  }

  /**
   * Test {@link ImmutableAppCostWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add one.
   *   <li>Then return costKindIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppCostWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add one; then return costKindIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppCostWidgetParameters ImmutableAppCostWidgetParameters.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddOne_thenReturnCostKindIdsSizeIsOne() {
    // Arrange
    LinkedHashSet<Long> costKindIds = new LinkedHashSet<>();
    costKindIds.add(1L);

    Json json = new Json();
    json.setAllocationSchemeId(1L);
    json.setCostKindIds(costKindIds);

    // Act
    ImmutableAppCostWidgetParameters actualFromJsonResult =
        ImmutableAppCostWidgetParameters.fromJson(json);

    // Assert
    Set<Long> costKindIdsResult = actualFromJsonResult.costKindIds();
    assertEquals(1, costKindIdsResult.size());
    assertTrue(costKindIdsResult.contains(1L));
  }

  /**
   * Test {@link ImmutableAppCostWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return allocationSchemeId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppCostWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return allocationSchemeId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppCostWidgetParameters ImmutableAppCostWidgetParameters.fromJson(Json)"
  })
  void testFromJson_thenReturnAllocationSchemeIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setAllocationSchemeId(1L);
    json.setCostKindIds(null);

    // Act
    ImmutableAppCostWidgetParameters actualFromJsonResult =
        ImmutableAppCostWidgetParameters.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.allocationSchemeId().longValue());
    assertTrue(actualFromJsonResult.costKindIds().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppCostWidgetParameters#toString()}
   *   <li>{@link ImmutableAppCostWidgetParameters#allocationSchemeId()}
   *   <li>{@link ImmutableAppCostWidgetParameters#costKindIds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableAppCostWidgetParameters.allocationSchemeId()",
    "Set ImmutableAppCostWidgetParameters.costKindIds()",
    "String ImmutableAppCostWidgetParameters.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAppCostWidgetParameters immutableAppCostWidgetParameters =
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build();

    // Act
    String actualToStringResult = immutableAppCostWidgetParameters.toString();
    Long actualAllocationSchemeIdResult = immutableAppCostWidgetParameters.allocationSchemeId();
    Set<Long> actualCostKindIdsResult = immutableAppCostWidgetParameters.costKindIds();

    // Assert
    assertEquals(
        "AppCostWidgetParameters{allocationSchemeId=1, costKindIds=[]}", actualToStringResult);
    assertEquals(1L, actualAllocationSchemeIdResult.longValue());
    assertTrue(actualCostKindIdsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#allocationSchemeId()}.
   *
   * <p>Method under test: {@link Json#allocationSchemeId()}
   */
  @Test
  @DisplayName("Test Json allocationSchemeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.allocationSchemeId()"})
  void testJsonAllocationSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().allocationSchemeId());
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
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.allocationSchemeId);
    assertTrue(actualJson.costKindIds.isEmpty());
  }

  /**
   * Test {@link ImmutableAppCostWidgetParameters#withAllocationSchemeId(Long)}.
   *
   * <ul>
   *   <li>Then return allocationSchemeId longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppCostWidgetParameters#withAllocationSchemeId(Long)}
   */
  @Test
  @DisplayName(
      "Test withAllocationSchemeId(Long); then return allocationSchemeId longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppCostWidgetParameters ImmutableAppCostWidgetParameters.withAllocationSchemeId(Long)"
  })
  void testWithAllocationSchemeId_thenReturnAllocationSchemeIdLongValueIsFortyTwo() {
    // Arrange and Act
    ImmutableAppCostWidgetParameters actualWithAllocationSchemeIdResult =
        ImmutableAppCostWidgetParameters.builder()
            .allocationSchemeId(1L)
            .build()
            .withAllocationSchemeId(42L);

    // Assert
    assertEquals(42L, actualWithAllocationSchemeIdResult.allocationSchemeId().longValue());
    assertTrue(actualWithAllocationSchemeIdResult.costKindIds().isEmpty());
  }

  /**
   * Test {@link ImmutableAppCostWidgetParameters#withAllocationSchemeId(Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder allocationSchemeId one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppCostWidgetParameters#withAllocationSchemeId(Long)}
   */
  @Test
  @DisplayName(
      "Test withAllocationSchemeId(Long); when one; then return builder allocationSchemeId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppCostWidgetParameters ImmutableAppCostWidgetParameters.withAllocationSchemeId(Long)"
  })
  void testWithAllocationSchemeId_whenOne_thenReturnBuilderAllocationSchemeIdOneBuild() {
    // Arrange
    ImmutableAppCostWidgetParameters immutableAppCostWidgetParameters =
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build();

    // Act
    ImmutableAppCostWidgetParameters actualWithAllocationSchemeIdResult =
        immutableAppCostWidgetParameters.withAllocationSchemeId(1L);

    // Assert
    assertSame(immutableAppCostWidgetParameters, actualWithAllocationSchemeIdResult);
  }

  /**
   * Test {@link ImmutableAppCostWidgetParameters#withCostKindIds(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then return allocationSchemeId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppCostWidgetParameters#withCostKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withCostKindIds(Iterable) with 'Iterable'; then return allocationSchemeId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppCostWidgetParameters ImmutableAppCostWidgetParameters.withCostKindIds(Iterable)"
  })
  void testWithCostKindIdsWithIterable_thenReturnAllocationSchemeIdLongValueIsOne() {
    // Arrange
    ImmutableAppCostWidgetParameters immutableAppCostWidgetParameters =
        ImmutableAppCostWidgetParameters.builder().allocationSchemeId(1L).build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableAppCostWidgetParameters actualWithCostKindIdsResult =
        immutableAppCostWidgetParameters.withCostKindIds(elements);

    // Assert
    assertEquals(1L, actualWithCostKindIdsResult.allocationSchemeId().longValue());
    assertEquals(elements, actualWithCostKindIdsResult.costKindIds());
  }

  /**
   * Test {@link ImmutableAppCostWidgetParameters#withCostKindIds(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutableAppCostWidgetParameters#withCostKindIds(long[])}
   */
  @Test
  @DisplayName("Test withCostKindIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppCostWidgetParameters ImmutableAppCostWidgetParameters.withCostKindIds(long[])"
  })
  void testWithCostKindIdsWithLong() {
    // Arrange and Act
    ImmutableAppCostWidgetParameters actualWithCostKindIdsResult =
        ImmutableAppCostWidgetParameters.builder()
            .allocationSchemeId(1L)
            .build()
            .withCostKindIds(1L, -1L, 1L, -1L);

    // Assert
    assertEquals(1L, actualWithCostKindIdsResult.allocationSchemeId().longValue());
    Set<Long> costKindIdsResult = actualWithCostKindIdsResult.costKindIds();
    assertEquals(2, costKindIdsResult.size());
    assertTrue(costKindIdsResult.contains(-1L));
    assertTrue(costKindIdsResult.contains(1L));
  }
}
