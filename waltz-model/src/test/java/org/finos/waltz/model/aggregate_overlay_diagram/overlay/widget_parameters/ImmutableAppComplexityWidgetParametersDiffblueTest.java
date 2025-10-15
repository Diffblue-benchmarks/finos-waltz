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
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAppComplexityWidgetParameters.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAppComplexityWidgetParameters.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppComplexityWidgetParametersDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllComplexityKindIds(Iterable)}.
   *
   * <p>Method under test: {@link Builder#addAllComplexityKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllComplexityKindIds(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllComplexityKindIds(Iterable)"})
  void testBuilderAddAllComplexityKindIds() {
    // Arrange
    Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllComplexityKindIdsResult = builderResult.addAllComplexityKindIds(elements);

    // Assert
    assertEquals(elements, builderResult.build().complexityKindIds());
    assertSame(builderResult, actualAddAllComplexityKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllComplexityKindIds(Iterable)}.
   *
   * <ul>
   *   <li>Then return build complexityKindIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllComplexityKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllComplexityKindIds(Iterable); then return build complexityKindIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllComplexityKindIds(Iterable)"})
  void testBuilderAddAllComplexityKindIds_thenReturnBuildComplexityKindIdsEmpty() {
    // Arrange
    Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();

    // Act
    Builder actualAddAllComplexityKindIdsResult =
        builderResult.addAllComplexityKindIds(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllComplexityKindIdsResult.build().complexityKindIds().isEmpty());
    assertSame(builderResult, actualAddAllComplexityKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addComplexityKindIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addComplexityKindIds(long)}
   */
  @Test
  @DisplayName("Test Builder addComplexityKindIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addComplexityKindIds(long)"})
  void testBuilderAddComplexityKindIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();

    // Act
    Builder actualAddComplexityKindIdsResult = builderResult.addComplexityKindIds(1L);

    // Assert
    Set<Long> complexityKindIdsResult = builderResult.build().complexityKindIds();
    assertEquals(1, complexityKindIdsResult.size());
    assertTrue(complexityKindIdsResult.contains(1L));
    assertSame(builderResult, actualAddComplexityKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addComplexityKindIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addComplexityKindIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addComplexityKindIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addComplexityKindIds(long[])"})
  void testBuilderAddComplexityKindIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();

    // Act
    Builder actualAddComplexityKindIdsResult = builderResult.addComplexityKindIds(1L, -1L, 1L, -1L);

    // Assert
    Set<Long> complexityKindIdsResult = builderResult.build().complexityKindIds();
    assertEquals(2, complexityKindIdsResult.size());
    assertTrue(complexityKindIdsResult.contains(-1L));
    assertTrue(complexityKindIdsResult.contains(1L));
    assertSame(builderResult, actualAddComplexityKindIdsResult);
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
  @MethodsUnderTest({"ImmutableAppComplexityWidgetParameters Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableAppComplexityWidgetParameters.builder().build().complexityKindIds().isEmpty());
  }

  /**
   * Test Builder {@link Builder#complexityKindIds(Iterable)}.
   *
   * <ul>
   *   <li>Then builder build complexityKindIds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#complexityKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder complexityKindIds(Iterable); then builder build complexityKindIds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.complexityKindIds(Iterable)"})
  void testBuilderComplexityKindIds_thenBuilderBuildComplexityKindIdsIsLinkedHashSet() {
    // Arrange
    Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualComplexityKindIdsResult = builderResult.complexityKindIds(elements);

    // Assert
    assertEquals(elements, builderResult.build().complexityKindIds());
    assertSame(builderResult, actualComplexityKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#complexityKindIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return build complexityKindIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#complexityKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder complexityKindIds(Iterable); when ArrayList(); then return build complexityKindIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.complexityKindIds(Iterable)"})
  void testBuilderComplexityKindIds_whenArrayList_thenReturnBuildComplexityKindIdsEmpty() {
    // Arrange
    Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();

    // Act
    Builder actualComplexityKindIdsResult = builderResult.complexityKindIds(new ArrayList<>());

    // Assert
    assertTrue(actualComplexityKindIdsResult.build().complexityKindIds().isEmpty());
    assertSame(builderResult, actualComplexityKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#from(AppComplexityWidgetParameters)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When builder addComplexityKindIds one.
   *   <li>Then builder build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AppComplexityWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AppComplexityWidgetParameters); given one; when builder addComplexityKindIds one; then builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppComplexityWidgetParameters)"})
  void testBuilderFrom_givenOne_whenBuilderAddComplexityKindIdsOne_thenBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();

    Builder builderResult2 = ImmutableAppComplexityWidgetParameters.builder();
    builderResult2.addComplexityKindIds(1L);
    ImmutableAppComplexityWidgetParameters instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppComplexityWidgetParameters actualImmutableAppComplexityWidgetParameters =
        builderResult.build();
    assertEquals(instance, actualImmutableAppComplexityWidgetParameters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AppComplexityWidgetParameters)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then builder build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AppComplexityWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AppComplexityWidgetParameters); when builder build; then builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppComplexityWidgetParameters)"})
  void testBuilderFrom_whenBuilderBuild_thenBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();
    ImmutableAppComplexityWidgetParameters instance =
        ImmutableAppComplexityWidgetParameters.builder().build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppComplexityWidgetParameters actualImmutableAppComplexityWidgetParameters =
        builderResult.build();
    assertEquals(instance, actualImmutableAppComplexityWidgetParameters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableAppComplexityWidgetParameters#copyOf(AppComplexityWidgetParameters)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return complexityKindIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAppComplexityWidgetParameters#copyOf(AppComplexityWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AppComplexityWidgetParameters); when builder build; then return complexityKindIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppComplexityWidgetParameters ImmutableAppComplexityWidgetParameters.copyOf(AppComplexityWidgetParameters)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnComplexityKindIdsEmpty() {
    // Arrange
    ImmutableAppComplexityWidgetParameters instance =
        ImmutableAppComplexityWidgetParameters.builder().build();

    // Act and Assert
    assertTrue(
        ImmutableAppComplexityWidgetParameters.copyOf(instance).complexityKindIds().isEmpty());
  }

  /**
   * Test {@link ImmutableAppComplexityWidgetParameters#equals(Object)}, and {@link
   * ImmutableAppComplexityWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppComplexityWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableAppComplexityWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppComplexityWidgetParameters.equals(Object)",
    "int ImmutableAppComplexityWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAppComplexityWidgetParameters immutableAppComplexityWidgetParameters =
        ImmutableAppComplexityWidgetParameters.builder().build();
    ImmutableAppComplexityWidgetParameters immutableAppComplexityWidgetParameters2 =
        ImmutableAppComplexityWidgetParameters.builder().build();

    // Act and Assert
    assertEquals(immutableAppComplexityWidgetParameters, immutableAppComplexityWidgetParameters2);
    assertEquals(
        immutableAppComplexityWidgetParameters.hashCode(),
        immutableAppComplexityWidgetParameters2.hashCode());
  }

  /**
   * Test {@link ImmutableAppComplexityWidgetParameters#equals(Object)}, and {@link
   * ImmutableAppComplexityWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppComplexityWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableAppComplexityWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppComplexityWidgetParameters.equals(Object)",
    "int ImmutableAppComplexityWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAppComplexityWidgetParameters immutableAppComplexityWidgetParameters =
        ImmutableAppComplexityWidgetParameters.builder().build();

    // Act and Assert
    assertEquals(immutableAppComplexityWidgetParameters, immutableAppComplexityWidgetParameters);
    int expectedHashCodeResult = immutableAppComplexityWidgetParameters.hashCode();
    assertEquals(expectedHashCodeResult, immutableAppComplexityWidgetParameters.hashCode());
  }

  /**
   * Test {@link ImmutableAppComplexityWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppComplexityWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppComplexityWidgetParameters.equals(Object)",
    "int ImmutableAppComplexityWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppComplexityWidgetParameters.builder();
    builderResult.addComplexityKindIds(1L);

    // Act and Assert
    assertNotEquals(
        builderResult.build(), ImmutableAppComplexityWidgetParameters.builder().build());
  }

  /**
   * Test {@link ImmutableAppComplexityWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppComplexityWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppComplexityWidgetParameters.equals(Object)",
    "int ImmutableAppComplexityWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableAppComplexityWidgetParameters.builder().build(), null);
  }

  /**
   * Test {@link ImmutableAppComplexityWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppComplexityWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppComplexityWidgetParameters.equals(Object)",
    "int ImmutableAppComplexityWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAppComplexityWidgetParameters.builder().build(),
        "Different type to ImmutableAppComplexityWidgetParameters");
  }

  /**
   * Test {@link ImmutableAppComplexityWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add one.
   *   <li>Then return complexityKindIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppComplexityWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add one; then return complexityKindIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppComplexityWidgetParameters ImmutableAppComplexityWidgetParameters.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddOne_thenReturnComplexityKindIdsSizeIsOne() {
    // Arrange
    LinkedHashSet<Long> complexityKindIds = new LinkedHashSet<>();
    complexityKindIds.add(1L);

    Json json = new Json();
    json.setComplexityKindIds(complexityKindIds);

    // Act
    ImmutableAppComplexityWidgetParameters actualFromJsonResult =
        ImmutableAppComplexityWidgetParameters.fromJson(json);

    // Assert
    Set<Long> complexityKindIdsResult = actualFromJsonResult.complexityKindIds();
    assertEquals(1, complexityKindIdsResult.size());
    assertTrue(complexityKindIdsResult.contains(1L));
  }

  /**
   * Test {@link ImmutableAppComplexityWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) ComplexityKindIds is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppComplexityWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) ComplexityKindIds is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppComplexityWidgetParameters ImmutableAppComplexityWidgetParameters.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonComplexityKindIdsIsNull() {
    // Arrange
    Json json = new Json();
    json.setComplexityKindIds(null);

    // Act
    ImmutableAppComplexityWidgetParameters actualFromJsonResult =
        ImmutableAppComplexityWidgetParameters.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.complexityKindIds().isEmpty());
  }

  /**
   * Test {@link ImmutableAppComplexityWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return complexityKindIds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppComplexityWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return complexityKindIds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppComplexityWidgetParameters ImmutableAppComplexityWidgetParameters.fromJson(Json)"
  })
  void testFromJson_thenReturnComplexityKindIdsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<Long> complexityKindIds = new LinkedHashSet<>();
    complexityKindIds.add(-1L);
    complexityKindIds.add(1L);

    Json json = new Json();
    json.setComplexityKindIds(complexityKindIds);

    // Act
    ImmutableAppComplexityWidgetParameters actualFromJsonResult =
        ImmutableAppComplexityWidgetParameters.fromJson(json);

    // Assert
    assertEquals(complexityKindIds, actualFromJsonResult.complexityKindIds());
  }

  /**
   * Test {@link ImmutableAppComplexityWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return complexityKindIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppComplexityWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return complexityKindIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppComplexityWidgetParameters ImmutableAppComplexityWidgetParameters.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnComplexityKindIdsEmpty() {
    // Arrange and Act
    ImmutableAppComplexityWidgetParameters actualFromJsonResult =
        ImmutableAppComplexityWidgetParameters.fromJson(new Json());

    // Assert
    assertTrue(actualFromJsonResult.complexityKindIds().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppComplexityWidgetParameters#toString()}
   *   <li>{@link ImmutableAppComplexityWidgetParameters#complexityKindIds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableAppComplexityWidgetParameters.complexityKindIds()",
    "String ImmutableAppComplexityWidgetParameters.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAppComplexityWidgetParameters immutableAppComplexityWidgetParameters =
        ImmutableAppComplexityWidgetParameters.builder().build();

    // Act
    String actualToStringResult = immutableAppComplexityWidgetParameters.toString();

    // Assert
    assertEquals("AppComplexityWidgetParameters{complexityKindIds=[]}", actualToStringResult);
    assertTrue(immutableAppComplexityWidgetParameters.complexityKindIds().isEmpty());
  }

  /**
   * Test Json {@link Json#complexityKindIds()}.
   *
   * <p>Method under test: {@link Json#complexityKindIds()}
   */
  @Test
  @DisplayName("Test Json complexityKindIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.complexityKindIds()"})
  void testJsonComplexityKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().complexityKindIds());
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
    assertTrue(new Json().complexityKindIds.isEmpty());
  }

  /**
   * Test {@link ImmutableAppComplexityWidgetParameters#withComplexityKindIds(Iterable)} with {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Then return complexityKindIds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAppComplexityWidgetParameters#withComplexityKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withComplexityKindIds(Iterable) with 'Iterable'; then return complexityKindIds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppComplexityWidgetParameters ImmutableAppComplexityWidgetParameters.withComplexityKindIds(Iterable)"
  })
  void testWithComplexityKindIdsWithIterable_thenReturnComplexityKindIdsIsLinkedHashSet() {
    // Arrange
    ImmutableAppComplexityWidgetParameters immutableAppComplexityWidgetParameters =
        ImmutableAppComplexityWidgetParameters.builder().build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertEquals(
        elements,
        immutableAppComplexityWidgetParameters.withComplexityKindIds(elements).complexityKindIds());
  }

  /**
   * Test {@link ImmutableAppComplexityWidgetParameters#withComplexityKindIds(long[])} with {@code
   * long[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAppComplexityWidgetParameters#withComplexityKindIds(long[])}
   */
  @Test
  @DisplayName("Test withComplexityKindIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppComplexityWidgetParameters ImmutableAppComplexityWidgetParameters.withComplexityKindIds(long[])"
  })
  void testWithComplexityKindIdsWithLong() {
    // Arrange, Act and Assert
    Set<Long> complexityKindIdsResult =
        ImmutableAppComplexityWidgetParameters.builder()
            .build()
            .withComplexityKindIds(1L, -1L, 1L, -1L)
            .complexityKindIds();
    assertEquals(2, complexityKindIdsResult.size());
    assertTrue(complexityKindIdsResult.contains(-1L));
    assertTrue(complexityKindIdsResult.contains(1L));
  }
}
