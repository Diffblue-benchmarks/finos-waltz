package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <p>
   * Method under test: {@link Builder#addAllOmitApplicationKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOmitApplicationKinds(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllOmitApplicationKinds(Iterable)"})
  void testBuilderAddAllOmitApplicationKinds() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();

    LinkedHashSet<ApplicationKind> elements = new LinkedHashSet<>();
    elements.add(ApplicationKind.IN_HOUSE);

    // Act
    Builder actualAddAllOmitApplicationKindsResult = builderResult.addAllOmitApplicationKinds(elements);

    // Assert
    assertEquals(elements, builderResult.build().omitApplicationKinds());
    assertSame(builderResult, actualAddAllOmitApplicationKindsResult);
  }

  /**
   * Test Builder {@link Builder#addAllOmitApplicationKinds(Iterable)}.
   * <ul>
   *   <li>Then builder build omitApplicationKinds Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllOmitApplicationKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOmitApplicationKinds(Iterable); then builder build omitApplicationKinds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllOmitApplicationKinds(Iterable)"})
  void testBuilderAddAllOmitApplicationKinds_thenBuilderBuildOmitApplicationKindsEmpty() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();

    // Act
    Builder actualAddAllOmitApplicationKindsResult = builderResult.addAllOmitApplicationKinds(new ArrayList<>());

    // Assert
    assertTrue(builderResult.build().omitApplicationKinds().isEmpty());
    assertSame(builderResult, actualAddAllOmitApplicationKindsResult);
  }

  /**
   * Test Builder {@link Builder#addOmitApplicationKinds(ApplicationKind)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addOmitApplicationKinds(ApplicationKind)}
   */
  @Test
  @DisplayName("Test Builder addOmitApplicationKinds(ApplicationKind) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOmitApplicationKinds(ApplicationKind)"})
  void testBuilderAddOmitApplicationKindsWithElement() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();

    // Act
    Builder actualAddOmitApplicationKindsResult = builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);

    // Assert
    Set<ApplicationKind> omitApplicationKindsResult = builderResult.build().omitApplicationKinds();
    assertEquals(1, omitApplicationKindsResult.size());
    assertTrue(omitApplicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertSame(builderResult, actualAddOmitApplicationKindsResult);
  }

  /**
   * Test Builder {@link Builder#addOmitApplicationKinds(ApplicationKind[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addOmitApplicationKinds(ApplicationKind[])}
   */
  @Test
  @DisplayName("Test Builder addOmitApplicationKinds(ApplicationKind[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOmitApplicationKinds(ApplicationKind[])"})
  void testBuilderAddOmitApplicationKindsWithElements() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();

    // Act
    Builder actualAddOmitApplicationKindsResult = builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);

    // Assert
    Set<ApplicationKind> omitApplicationKindsResult = builderResult.build().omitApplicationKinds();
    assertEquals(1, omitApplicationKindsResult.size());
    assertTrue(omitApplicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertSame(builderResult, actualAddOmitApplicationKindsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSelectionFilters Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableSelectionFilters.builder().build().omitApplicationKinds().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(SelectionFilters)}.
   * <ul>
   *   <li>Given {@code IN_HOUSE}.</li>
   *   <li>Then builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SelectionFilters)}
   */
  @Test
  @DisplayName("Test Builder from(SelectionFilters); given 'IN_HOUSE'; then builder build")
  @Tag("MaintainedByDiffblue")
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
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SelectionFilters)}.
   * <ul>
   *   <li>When {@link SelectionFilters#NO_FILTERS}.</li>
   *   <li>Then builder build is {@link SelectionFilters#NO_FILTERS} {@link SelectionFilters#NO_FILTERS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SelectionFilters)}
   */
  @Test
  @DisplayName("Test Builder from(SelectionFilters); when NO_FILTERS; then builder build is NO_FILTERS NO_FILTERS")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SelectionFilters)"})
  void testBuilderFrom_whenNo_filters_thenBuilderBuildIsNo_filtersNo_filters() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();
    SelectionFilters instance = SelectionFilters.NO_FILTERS;

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    SelectionFilters expectedBuildResult = instance.NO_FILTERS;
    assertEquals(expectedBuildResult, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#omitApplicationKinds(Iterable)}.
   * <p>
   * Method under test: {@link Builder#omitApplicationKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder omitApplicationKinds(Iterable)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then builder build omitApplicationKinds Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#omitApplicationKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder omitApplicationKinds(Iterable); then builder build omitApplicationKinds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.omitApplicationKinds(Iterable)"})
  void testBuilderOmitApplicationKinds_thenBuilderBuildOmitApplicationKindsEmpty() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();

    // Act
    Builder actualOmitApplicationKindsResult = builderResult.omitApplicationKinds(new ArrayList<>());

    // Assert
    assertTrue(builderResult.build().omitApplicationKinds().isEmpty());
    assertSame(builderResult, actualOmitApplicationKindsResult);
  }

  /**
   * Test {@link ImmutableSelectionFilters#copyOf(SelectionFilters)}.
   * <ul>
   *   <li>When {@link SelectionFilters#NO_FILTERS}.</li>
   *   <li>Then return omitApplicationKinds Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSelectionFilters#copyOf(SelectionFilters)}
   */
  @Test
  @DisplayName("Test copyOf(SelectionFilters); when NO_FILTERS; then return omitApplicationKinds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSelectionFilters ImmutableSelectionFilters.copyOf(SelectionFilters)"})
  void testCopyOf_whenNo_filters_thenReturnOmitApplicationKindsEmpty() {
    // Arrange, Act and Assert
    assertTrue(ImmutableSelectionFilters.copyOf(SelectionFilters.NO_FILTERS).omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableSelectionFilters#equals(Object)}, and {@link ImmutableSelectionFilters#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSelectionFilters#equals(Object)}
   *   <li>{@link ImmutableSelectionFilters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSelectionFilters.equals(Object)", "int ImmutableSelectionFilters.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSelectionFilters buildResult = ImmutableSelectionFilters.builder().build();
    ImmutableSelectionFilters buildResult2 = ImmutableSelectionFilters.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableSelectionFilters#equals(Object)}, and {@link ImmutableSelectionFilters#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSelectionFilters#equals(Object)}
   *   <li>{@link ImmutableSelectionFilters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSelectionFilters.equals(Object)", "int ImmutableSelectionFilters.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSelectionFilters buildResult = ImmutableSelectionFilters.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableSelectionFilters#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSelectionFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSelectionFilters.equals(Object)", "int ImmutableSelectionFilters.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters buildResult = builderResult.build();
    ImmutableSelectionFilters buildResult2 = ImmutableSelectionFilters.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableSelectionFilters#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSelectionFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSelectionFilters.equals(Object)", "int ImmutableSelectionFilters.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableSelectionFilters buildResult = ImmutableSelectionFilters.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableSelectionFilters#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSelectionFilters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableSelectionFilters.equals(Object)", "int ImmutableSelectionFilters.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableSelectionFilters buildResult = ImmutableSelectionFilters.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableSelectionFilters");
  }

  /**
   * Test {@link ImmutableSelectionFilters#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) OmitApplicationKinds is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSelectionFilters#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) OmitApplicationKinds is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSelectionFilters ImmutableSelectionFilters.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonOmitApplicationKindsIsNull() {
    // Arrange
    Json json = new Json();
    json.setOmitApplicationKinds(null);

    // Act and Assert
    assertTrue(ImmutableSelectionFilters.fromJson(json).omitApplicationKinds().isEmpty());
  }

  /**
   * Test {@link ImmutableSelectionFilters#fromJson(Json)}.
   * <ul>
   *   <li>Then return omitApplicationKinds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSelectionFilters#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return omitApplicationKinds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSelectionFilters ImmutableSelectionFilters.fromJson(Json)"})
  void testFromJson_thenReturnOmitApplicationKindsSizeIsOne() {
    // Arrange
    LinkedHashSet<ApplicationKind> omitApplicationKinds = new LinkedHashSet<>();
    omitApplicationKinds.add(ApplicationKind.IN_HOUSE);

    Json json = new Json();
    json.setOmitApplicationKinds(omitApplicationKinds);

    // Act and Assert
    Set<ApplicationKind> omitApplicationKindsResult = ImmutableSelectionFilters.fromJson(json).omitApplicationKinds();
    assertEquals(1, omitApplicationKindsResult.size());
    assertTrue(omitApplicationKindsResult.contains(ApplicationKind.IN_HOUSE));
  }

  /**
   * Test {@link ImmutableSelectionFilters#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return omitApplicationKinds Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableSelectionFilters#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return omitApplicationKinds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSelectionFilters ImmutableSelectionFilters.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnOmitApplicationKindsEmpty() {
    // Arrange, Act and Assert
    assertTrue(ImmutableSelectionFilters.fromJson(new Json()).omitApplicationKinds().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSelectionFilters#toString()}
   *   <li>{@link ImmutableSelectionFilters#omitApplicationKinds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableSelectionFilters.omitApplicationKinds()",
      "String ImmutableSelectionFilters.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableSelectionFilters buildResult = ImmutableSelectionFilters.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();

    // Assert
    assertEquals("SelectionFilters{omitApplicationKinds=[]}", actualToStringResult);
    assertTrue(buildResult.omitApplicationKinds().isEmpty());
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
    // Arrange, Act and Assert
    assertTrue((new Json()).omitApplicationKinds.isEmpty());
  }

  /**
   * Test Json {@link Json#omitApplicationKinds()}.
   * <p>
   * Method under test: {@link Json#omitApplicationKinds()}
   */
  @Test
  @DisplayName("Test Json omitApplicationKinds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.omitApplicationKinds()"})
  void testJsonOmitApplicationKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).omitApplicationKinds());
  }

  /**
   * Test {@link ImmutableSelectionFilters#withOmitApplicationKinds(ApplicationKind[])} with {@code ApplicationKind[]}.
   * <p>
   * Method under test: {@link ImmutableSelectionFilters#withOmitApplicationKinds(ApplicationKind[])}
   */
  @Test
  @DisplayName("Test withOmitApplicationKinds(ApplicationKind[]) with 'ApplicationKind[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSelectionFilters ImmutableSelectionFilters.withOmitApplicationKinds(ApplicationKind[])"})
  void testWithOmitApplicationKindsWithApplicationKind() {
    // Arrange
    ImmutableSelectionFilters buildResult = ImmutableSelectionFilters.builder().build();

    // Act and Assert
    Set<ApplicationKind> omitApplicationKindsResult = buildResult.withOmitApplicationKinds(ApplicationKind.IN_HOUSE)
        .omitApplicationKinds();
    assertEquals(1, omitApplicationKindsResult.size());
    assertTrue(omitApplicationKindsResult.contains(ApplicationKind.IN_HOUSE));
  }

  /**
   * Test {@link ImmutableSelectionFilters#withOmitApplicationKinds(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link ImmutableSelectionFilters#withOmitApplicationKinds(Iterable)}
   */
  @Test
  @DisplayName("Test withOmitApplicationKinds(Iterable) with 'Iterable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSelectionFilters ImmutableSelectionFilters.withOmitApplicationKinds(Iterable)"})
  void testWithOmitApplicationKindsWithIterable() {
    // Arrange
    ImmutableSelectionFilters buildResult = ImmutableSelectionFilters.builder().build();

    LinkedHashSet<ApplicationKind> elements = new LinkedHashSet<>();
    elements.add(ApplicationKind.IN_HOUSE);

    // Act and Assert
    assertEquals(elements, buildResult.withOmitApplicationKinds(elements).omitApplicationKinds());
  }
}
