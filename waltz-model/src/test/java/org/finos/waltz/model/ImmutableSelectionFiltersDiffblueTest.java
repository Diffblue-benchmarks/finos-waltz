package org.finos.waltz.model;

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
import org.finos.waltz.model.ImmutableSelectionFilters.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters.Json;
import org.finos.waltz.model.application.ApplicationKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSelectionFiltersDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllOmitApplicationKinds(Iterable)}.
   *
   * <p>Method under test: {@link Builder#addAllOmitApplicationKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOmitApplicationKinds(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllOmitApplicationKinds(Iterable)"})
  void testBuilderAddAllOmitApplicationKinds() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();

    LinkedHashSet<ApplicationKind> elements = new LinkedHashSet<>();
    elements.add(ApplicationKind.IN_HOUSE);

    // Act
    Builder actualAddAllOmitApplicationKindsResult =
        builderResult.addAllOmitApplicationKinds(elements);

    // Assert
    assertEquals(elements, builderResult.build().omitApplicationKinds());
    assertSame(builderResult, actualAddAllOmitApplicationKindsResult);
  }

  /**
   * Test Builder {@link Builder#addAllOmitApplicationKinds(Iterable)}.
   *
   * <ul>
   *   <li>Then builder build omitApplicationKinds Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllOmitApplicationKinds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllOmitApplicationKinds(Iterable); then builder build omitApplicationKinds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllOmitApplicationKinds(Iterable)"})
  void testBuilderAddAllOmitApplicationKinds_thenBuilderBuildOmitApplicationKindsEmpty() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();

    // Act
    Builder actualAddAllOmitApplicationKindsResult =
        builderResult.addAllOmitApplicationKinds(new ArrayList<>());

    // Assert
    assertTrue(builderResult.build().omitApplicationKinds().isEmpty());
    assertSame(builderResult, actualAddAllOmitApplicationKindsResult);
  }

  /**
   * Test Builder {@link Builder#addOmitApplicationKinds(ApplicationKind)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addOmitApplicationKinds(ApplicationKind)}
   */
  @Test
  @DisplayName("Test Builder addOmitApplicationKinds(ApplicationKind) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOmitApplicationKinds(ApplicationKind)"})
  void testBuilderAddOmitApplicationKindsWithElement() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();

    // Act
    Builder actualAddOmitApplicationKindsResult =
        builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);

    // Assert
    Set<ApplicationKind> omitApplicationKindsResult = builderResult.build().omitApplicationKinds();
    assertEquals(1, omitApplicationKindsResult.size());
    assertTrue(omitApplicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertSame(builderResult, actualAddOmitApplicationKindsResult);
  }

  /**
   * Test Builder {@link Builder#addOmitApplicationKinds(ApplicationKind[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addOmitApplicationKinds(ApplicationKind[])}
   */
  @Test
  @DisplayName("Test Builder addOmitApplicationKinds(ApplicationKind[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOmitApplicationKinds(ApplicationKind[])"})
  void testBuilderAddOmitApplicationKindsWithElements() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();

    // Act
    Builder actualAddOmitApplicationKindsResult =
        builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);

    // Assert
    Set<ApplicationKind> omitApplicationKindsResult = builderResult.build().omitApplicationKinds();
    assertEquals(1, omitApplicationKindsResult.size());
    assertTrue(omitApplicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertSame(builderResult, actualAddOmitApplicationKindsResult);
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
  @MethodsUnderTest({"ImmutableSelectionFilters Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableSelectionFilters.builder().build().omitApplicationKinds().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(SelectionFilters)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>Then builder build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SelectionFilters)}
   */
  @Test
  @DisplayName("Test Builder from(SelectionFilters); given 'IN_HOUSE'; then builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SelectionFilters)"})
  void testBuilderFrom_givenInHouse_thenBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();

    Builder builderResult2 = ImmutableSelectionFilters.builder();
    builderResult2.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSelectionFilters actualImmutableSelectionFilters = builderResult.build();
    assertEquals(instance, actualImmutableSelectionFilters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SelectionFilters)}.
   *
   * <ul>
   *   <li>When {@link SelectionFilters#NO_FILTERS}.
   *   <li>Then builder build is {@link SelectionFilters#NO_FILTERS}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SelectionFilters)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SelectionFilters); when NO_FILTERS; then builder build is NO_FILTERS")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SelectionFilters)"})
  void testBuilderFrom_whenNo_filters_thenBuilderBuildIsNo_filters() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();

    // Act
    Builder actualFromResult = builderResult.from(SelectionFilters.NO_FILTERS);

    // Assert
    ImmutableSelectionFilters actualImmutableSelectionFilters = builderResult.build();
    assertEquals(SelectionFilters.NO_FILTERS, actualImmutableSelectionFilters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#omitApplicationKinds(Iterable)}.
   *
   * <p>Method under test: {@link Builder#omitApplicationKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder omitApplicationKinds(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.omitApplicationKinds(Iterable)"})
  void testBuilderOmitApplicationKinds() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();

    LinkedHashSet<ApplicationKind> elements = new LinkedHashSet<>();
    elements.add(ApplicationKind.IN_HOUSE);

    // Act
    Builder actualOmitApplicationKindsResult = builderResult.omitApplicationKinds(elements);

    // Assert
    assertEquals(elements, builderResult.build().omitApplicationKinds());
    assertSame(builderResult, actualOmitApplicationKindsResult);
  }

  /**
   * Test Builder {@link Builder#omitApplicationKinds(Iterable)}.
   *
   * <ul>
   *   <li>Then builder build omitApplicationKinds Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#omitApplicationKinds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder omitApplicationKinds(Iterable); then builder build omitApplicationKinds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.omitApplicationKinds(Iterable)"})
  void testBuilderOmitApplicationKinds_thenBuilderBuildOmitApplicationKindsEmpty() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();

    // Act
    Builder actualOmitApplicationKindsResult =
        builderResult.omitApplicationKinds(new ArrayList<>());

    // Assert
    assertTrue(builderResult.build().omitApplicationKinds().isEmpty());
    assertSame(builderResult, actualOmitApplicationKindsResult);
  }

  /**
   * Test {@link ImmutableSelectionFilters#copyOf(SelectionFilters)}.
   *
   * <ul>
   *   <li>When {@link SelectionFilters#NO_FILTERS}.
   *   <li>Then return omitApplicationKinds Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSelectionFilters#copyOf(SelectionFilters)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SelectionFilters); when NO_FILTERS; then return omitApplicationKinds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSelectionFilters ImmutableSelectionFilters.copyOf(SelectionFilters)"
  })
  void testCopyOf_whenNo_filters_thenReturnOmitApplicationKindsEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableSelectionFilters.copyOf(SelectionFilters.NO_FILTERS)
            .omitApplicationKinds()
            .isEmpty());
  }

  /**
   * Test {@link ImmutableSelectionFilters#equals(Object)}, and {@link
   * ImmutableSelectionFilters#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSelectionFilters#equals(Object)}
   *   <li>{@link ImmutableSelectionFilters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSelectionFilters.equals(Object)",
    "int ImmutableSelectionFilters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSelectionFilters immutableSelectionFilters =
        ImmutableSelectionFilters.builder().build();
    ImmutableSelectionFilters immutableSelectionFilters2 =
        ImmutableSelectionFilters.builder().build();

    // Act and Assert
    assertEquals(immutableSelectionFilters, immutableSelectionFilters2);
    assertEquals(immutableSelectionFilters.hashCode(), immutableSelectionFilters2.hashCode());
  }

  /**
   * Test {@link ImmutableSelectionFilters#equals(Object)}, and {@link
   * ImmutableSelectionFilters#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSelectionFilters#equals(Object)}
   *   <li>{@link ImmutableSelectionFilters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSelectionFilters.equals(Object)",
    "int ImmutableSelectionFilters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSelectionFilters immutableSelectionFilters =
        ImmutableSelectionFilters.builder().build();

    // Act and Assert
    assertEquals(immutableSelectionFilters, immutableSelectionFilters);
    int expectedHashCodeResult = immutableSelectionFilters.hashCode();
    assertEquals(expectedHashCodeResult, immutableSelectionFilters.hashCode());
  }

  /**
   * Test {@link ImmutableSelectionFilters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSelectionFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSelectionFilters.equals(Object)",
    "int ImmutableSelectionFilters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableSelectionFilters.builder().build());
  }

  /**
   * Test {@link ImmutableSelectionFilters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSelectionFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSelectionFilters.equals(Object)",
    "int ImmutableSelectionFilters.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableSelectionFilters.builder().build(), null);
  }

  /**
   * Test {@link ImmutableSelectionFilters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSelectionFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSelectionFilters.equals(Object)",
    "int ImmutableSelectionFilters.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSelectionFilters.builder().build(), "Different type to ImmutableSelectionFilters");
  }

  /**
   * Test {@link ImmutableSelectionFilters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) OmitApplicationKinds is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSelectionFilters#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) OmitApplicationKinds is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSelectionFilters ImmutableSelectionFilters.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonOmitApplicationKindsIsNull() {
    // Arrange
    Json json = new Json();
    json.setOmitApplicationKinds(null);

    // Act
    ImmutableSelectionFilters actualFromJsonResult = ImmutableSelectionFilters.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableSelectionFilters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return omitApplicationKinds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSelectionFilters#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return omitApplicationKinds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSelectionFilters ImmutableSelectionFilters.fromJson(Json)"})
  void testFromJson_thenReturnOmitApplicationKindsSizeIsOne() {
    // Arrange
    LinkedHashSet<ApplicationKind> omitApplicationKinds = new LinkedHashSet<>();
    omitApplicationKinds.add(ApplicationKind.IN_HOUSE);

    Json json = new Json();
    json.setOmitApplicationKinds(omitApplicationKinds);

    // Act
    ImmutableSelectionFilters actualFromJsonResult = ImmutableSelectionFilters.fromJson(json);

    // Assert
    Set<ApplicationKind> omitApplicationKindsResult = actualFromJsonResult.omitApplicationKinds();
    assertEquals(1, omitApplicationKindsResult.size());
    assertTrue(omitApplicationKindsResult.contains(ApplicationKind.IN_HOUSE));
  }

  /**
   * Test {@link ImmutableSelectionFilters#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return omitApplicationKinds Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSelectionFilters#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return omitApplicationKinds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSelectionFilters ImmutableSelectionFilters.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnOmitApplicationKindsEmpty() {
    // Arrange and Act
    ImmutableSelectionFilters actualFromJsonResult = ImmutableSelectionFilters.fromJson(new Json());

    // Assert
    assertTrue(actualFromJsonResult.omitApplicationKinds().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSelectionFilters#toString()}
   *   <li>{@link ImmutableSelectionFilters#omitApplicationKinds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableSelectionFilters.omitApplicationKinds()",
    "String ImmutableSelectionFilters.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSelectionFilters immutableSelectionFilters =
        ImmutableSelectionFilters.builder().build();

    // Act
    String actualToStringResult = immutableSelectionFilters.toString();

    // Assert
    assertEquals("SelectionFilters{omitApplicationKinds=[]}", actualToStringResult);
    assertTrue(immutableSelectionFilters.omitApplicationKinds().isEmpty());
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
    assertTrue(new Json().omitApplicationKinds.isEmpty());
  }

  /**
   * Test Json {@link Json#omitApplicationKinds()}.
   *
   * <p>Method under test: {@link Json#omitApplicationKinds()}
   */
  @Test
  @DisplayName("Test Json omitApplicationKinds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.omitApplicationKinds()"})
  void testJsonOmitApplicationKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().omitApplicationKinds());
  }

  /**
   * Test {@link ImmutableSelectionFilters#withOmitApplicationKinds(ApplicationKind[])} with {@code
   * ApplicationKind[]}.
   *
   * <p>Method under test: {@link
   * ImmutableSelectionFilters#withOmitApplicationKinds(ApplicationKind[])}
   */
  @Test
  @DisplayName("Test withOmitApplicationKinds(ApplicationKind[]) with 'ApplicationKind[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSelectionFilters ImmutableSelectionFilters.withOmitApplicationKinds(ApplicationKind[])"
  })
  void testWithOmitApplicationKindsWithApplicationKind() {
    // Arrange, Act and Assert
    Set<ApplicationKind> omitApplicationKindsResult =
        ImmutableSelectionFilters.builder()
            .build()
            .withOmitApplicationKinds(ApplicationKind.IN_HOUSE)
            .omitApplicationKinds();
    assertEquals(1, omitApplicationKindsResult.size());
    assertTrue(omitApplicationKindsResult.contains(ApplicationKind.IN_HOUSE));
  }

  /**
   * Test {@link ImmutableSelectionFilters#withOmitApplicationKinds(Iterable)} with {@code
   * Iterable}.
   *
   * <p>Method under test: {@link ImmutableSelectionFilters#withOmitApplicationKinds(Iterable)}
   */
  @Test
  @DisplayName("Test withOmitApplicationKinds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSelectionFilters ImmutableSelectionFilters.withOmitApplicationKinds(Iterable)"
  })
  void testWithOmitApplicationKindsWithIterable() {
    // Arrange
    ImmutableSelectionFilters immutableSelectionFilters =
        ImmutableSelectionFilters.builder().build();

    LinkedHashSet<ApplicationKind> elements = new LinkedHashSet<>();
    elements.add(ApplicationKind.IN_HOUSE);

    // Act and Assert
    assertEquals(
        elements,
        immutableSelectionFilters.withOmitApplicationKinds(elements).omitApplicationKinds());
  }
}
