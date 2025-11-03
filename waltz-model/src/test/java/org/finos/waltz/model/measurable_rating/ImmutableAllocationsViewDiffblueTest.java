package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.allocation.Allocation;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.model.measurable_rating.ImmutableAllocationsView.Builder;
import org.finos.waltz.model.measurable_rating.ImmutableAllocationsView.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAllocationsViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAllocationSchemes(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAllocationSchemes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAllocationSchemes(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAllocationSchemes(Iterable)"})
  void testBuilderAddAllAllocationSchemes_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAllocationSchemes(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllAllocations(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAllocations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAllocations(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAllocations(Iterable)"})
  void testBuilderAddAllAllocations_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAllocations(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllocationSchemes(AllocationScheme)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addAllocationSchemes(AllocationScheme)}
   */
  @Test
  @DisplayName("Test Builder addAllocationSchemes(AllocationScheme) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllocationSchemes(AllocationScheme)"})
  void testBuilderAddAllocationSchemesWithElement() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();

    // Act
    Builder actualAddAllocationSchemesResult = builderResult.addAllocationSchemes(mock(AllocationScheme.class));

    // Assert
    assertEquals(1, builderResult.build().allocationSchemes().size());
    assertSame(builderResult, actualAddAllocationSchemesResult);
  }

  /**
   * Test Builder {@link Builder#addAllocationSchemes(AllocationScheme[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addAllocationSchemes(AllocationScheme[])}
   */
  @Test
  @DisplayName("Test Builder addAllocationSchemes(AllocationScheme[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllocationSchemes(AllocationScheme[])"})
  void testBuilderAddAllocationSchemesWithElements() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();

    // Act
    Builder actualAddAllocationSchemesResult = builderResult.addAllocationSchemes(mock(AllocationScheme.class));

    // Assert
    assertEquals(1, builderResult.build().allocationSchemes().size());
    assertSame(builderResult, actualAddAllocationSchemesResult);
  }

  /**
   * Test Builder {@link Builder#addAllocations(Allocation)} with {@code element}.
   * <ul>
   *   <li>Then builder build allocations size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllocations(Allocation)}
   */
  @Test
  @DisplayName("Test Builder addAllocations(Allocation) with 'element'; then builder build allocations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllocations(Allocation)"})
  void testBuilderAddAllocationsWithElement_thenBuilderBuildAllocationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();

    // Act
    Builder actualAddAllocationsResult = builderResult.addAllocations(mock(Allocation.class));

    // Assert
    assertEquals(1, builderResult.build().allocations().size());
    assertSame(builderResult, actualAddAllocationsResult);
  }

  /**
   * Test Builder {@link Builder#addAllocations(Allocation[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build allocations size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllocations(Allocation[])}
   */
  @Test
  @DisplayName("Test Builder addAllocations(Allocation[]) with 'elements'; then builder build allocations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllocations(Allocation[])"})
  void testBuilderAddAllocationsWithElements_thenBuilderBuildAllocationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();

    // Act
    Builder actualAddAllocationsResult = builderResult.addAllocations(mock(Allocation.class));

    // Assert
    assertEquals(1, builderResult.build().allocations().size());
    assertSame(builderResult, actualAddAllocationsResult);
  }

  /**
   * Test Builder {@link Builder#allocationSchemes(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#allocationSchemes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder allocationSchemes(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.allocationSchemes(Iterable)"})
  void testBuilderAllocationSchemes_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allocationSchemes(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#allocations(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#allocations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder allocations(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.allocations(Iterable)"})
  void testBuilderAllocations_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allocations(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAllocationsView Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableAllocationsView.builder().build().allocationSchemes().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(AllocationsView)}.
   * <ul>
   *   <li>Given array of {@link Allocation} with {@link Allocation}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AllocationsView)}
   */
  @Test
  @DisplayName("Test Builder from(AllocationsView); given array of Allocation with Allocation; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AllocationsView)"})
  void testBuilderFrom_givenArrayOfAllocationWithAllocation_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();
    Builder builderResult2 = ImmutableAllocationsView.builder();
    builderResult2.addAllocations(mock(Allocation.class));
    builderResult2.addAllocationSchemes(mock(AllocationScheme.class));
    ImmutableAllocationsView instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AllocationsView)}.
   * <ul>
   *   <li>Then return build is builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AllocationsView)}
   */
  @Test
  @DisplayName("Test Builder from(AllocationsView); then return build is builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AllocationsView)"})
  void testBuilderFrom_thenReturnBuildIsBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();
    Builder builderResult2 = ImmutableAllocationsView.builder();
    builderResult2.addAllocationSchemes(mock(AllocationScheme.class));
    ImmutableAllocationsView instance = builderResult2.build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(AllocationsView)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return build is builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AllocationsView)}
   */
  @Test
  @DisplayName("Test Builder from(AllocationsView); when builder build; then return build is builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AllocationsView)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildIsBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();
    ImmutableAllocationsView instance = ImmutableAllocationsView.builder().build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test {@link ImmutableAllocationsView#copyOf(AllocationsView)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return allocationSchemes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAllocationsView#copyOf(AllocationsView)}
   */
  @Test
  @DisplayName("Test copyOf(AllocationsView); when builder build; then return allocationSchemes Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAllocationsView ImmutableAllocationsView.copyOf(AllocationsView)"})
  void testCopyOf_whenBuilderBuild_thenReturnAllocationSchemesEmpty() {
    // Arrange
    ImmutableAllocationsView instance = ImmutableAllocationsView.builder().build();

    // Act
    ImmutableAllocationsView actualCopyOfResult = ImmutableAllocationsView.copyOf(instance);

    // Assert
    Set<AllocationScheme> allocationSchemesResult = actualCopyOfResult.allocationSchemes();
    assertTrue(allocationSchemesResult.isEmpty());
    assertSame(allocationSchemesResult, actualCopyOfResult.allocations());
  }

  /**
   * Test {@link ImmutableAllocationsView#equals(Object)}, and {@link ImmutableAllocationsView#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAllocationsView#equals(Object)}
   *   <li>{@link ImmutableAllocationsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAllocationsView.equals(Object)", "int ImmutableAllocationsView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAllocationsView buildResult = ImmutableAllocationsView.builder().build();
    ImmutableAllocationsView buildResult2 = ImmutableAllocationsView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableAllocationsView#equals(Object)}, and {@link ImmutableAllocationsView#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAllocationsView#equals(Object)}
   *   <li>{@link ImmutableAllocationsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAllocationsView.equals(Object)", "int ImmutableAllocationsView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAllocationsView buildResult = ImmutableAllocationsView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableAllocationsView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAllocationsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAllocationsView.equals(Object)", "int ImmutableAllocationsView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();
    builderResult.addAllocationSchemes(mock(AllocationScheme.class));
    ImmutableAllocationsView buildResult = builderResult.build();
    ImmutableAllocationsView buildResult2 = ImmutableAllocationsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableAllocationsView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAllocationsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAllocationsView.equals(Object)", "int ImmutableAllocationsView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();
    builderResult.addAllocations(mock(Allocation.class));
    ImmutableAllocationsView buildResult = builderResult.build();
    ImmutableAllocationsView buildResult2 = ImmutableAllocationsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableAllocationsView#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAllocationsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAllocationsView.equals(Object)", "int ImmutableAllocationsView.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableAllocationsView buildResult = ImmutableAllocationsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableAllocationsView#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAllocationsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAllocationsView.equals(Object)", "int ImmutableAllocationsView.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableAllocationsView buildResult = ImmutableAllocationsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableAllocationsView");
  }

  /**
   * Test {@link ImmutableAllocationsView#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link Allocation}.</li>
   *   <li>Then return allocations size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAllocationsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Allocation; then return allocations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAllocationsView ImmutableAllocationsView.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddAllocation_thenReturnAllocationsSizeIsOne() {
    // Arrange
    LinkedHashSet<Allocation> allocations = new LinkedHashSet<>();
    allocations.add(mock(Allocation.class));

    Json json = new Json();
    json.setAllocationSchemes(null);
    json.setAllocations(allocations);

    // Act
    ImmutableAllocationsView actualFromJsonResult = ImmutableAllocationsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.allocations().size());
    assertTrue(actualFromJsonResult.allocationSchemes().isEmpty());
  }

  /**
   * Test {@link ImmutableAllocationsView#fromJson(Json)}.
   * <ul>
   *   <li>Then return allocationSchemes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAllocationsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return allocationSchemes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAllocationsView ImmutableAllocationsView.fromJson(Json)"})
  void testFromJson_thenReturnAllocationSchemesSizeIsOne() {
    // Arrange
    LinkedHashSet<AllocationScheme> allocationSchemes = new LinkedHashSet<>();
    allocationSchemes.add(mock(AllocationScheme.class));

    Json json = new Json();
    json.setAllocationSchemes(allocationSchemes);
    json.setAllocations(null);

    // Act
    ImmutableAllocationsView actualFromJsonResult = ImmutableAllocationsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.allocationSchemes().size());
    assertTrue(actualFromJsonResult.allocations().isEmpty());
  }

  /**
   * Test {@link ImmutableAllocationsView#fromJson(Json)}.
   * <ul>
   *   <li>Then return allocations is allocationSchemes.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAllocationsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return allocations is allocationSchemes")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAllocationsView ImmutableAllocationsView.fromJson(Json)"})
  void testFromJson_thenReturnAllocationsIsAllocationSchemes() {
    // Arrange
    Json json = new Json();
    json.setAllocationSchemes(null);
    json.setAllocations(null);

    // Act
    ImmutableAllocationsView actualFromJsonResult = ImmutableAllocationsView.fromJson(json);

    // Assert
    Set<AllocationScheme> allocationSchemesResult = actualFromJsonResult.allocationSchemes();
    assertTrue(allocationSchemesResult.isEmpty());
    assertSame(allocationSchemesResult, actualFromJsonResult.allocations());
  }

  /**
   * Test {@link ImmutableAllocationsView#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return allocations is {@link Json} (default constructor) {@link Json#allocations}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAllocationsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return allocations is Json (default constructor) allocations")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAllocationsView ImmutableAllocationsView.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnAllocationsIsJsonAllocations() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableAllocationsView actualFromJsonResult = ImmutableAllocationsView.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.allocationSchemes().isEmpty());
    Set<Allocation> expectedAllocationsResult = json.allocations;
    assertSame(expectedAllocationsResult, actualFromJsonResult.allocations());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAllocationsView#toString()}
   *   <li>{@link ImmutableAllocationsView#allocationSchemes()}
   *   <li>{@link ImmutableAllocationsView#allocations()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableAllocationsView.allocationSchemes()", "Set ImmutableAllocationsView.allocations()",
      "String ImmutableAllocationsView.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableAllocationsView buildResult = ImmutableAllocationsView.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    Set<AllocationScheme> actualAllocationSchemesResult = buildResult.allocationSchemes();
    Set<Allocation> actualAllocationsResult = buildResult.allocations();

    // Assert
    assertEquals("AllocationsView{allocationSchemes=[], allocations=[]}", actualToStringResult);
    assertTrue(actualAllocationSchemesResult.isEmpty());
    assertSame(actualAllocationSchemesResult, actualAllocationsResult);
  }

  /**
   * Test Json {@link Json#allocationSchemes()}.
   * <p>
   * Method under test: {@link Json#allocationSchemes()}
   */
  @Test
  @DisplayName("Test Json allocationSchemes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.allocationSchemes()"})
  void testJsonAllocationSchemes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).allocationSchemes());
  }

  /**
   * Test Json {@link Json#allocations()}.
   * <p>
   * Method under test: {@link Json#allocations()}
   */
  @Test
  @DisplayName("Test Json allocations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.allocations()"})
  void testJsonAllocations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).allocations());
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
    assertTrue(actualJson.allocationSchemes.isEmpty());
    assertTrue(actualJson.allocations.isEmpty());
  }

  /**
   * Test {@link ImmutableAllocationsView#withAllocationSchemes(AllocationScheme[])} with {@code AllocationScheme[]}.
   * <p>
   * Method under test: {@link ImmutableAllocationsView#withAllocationSchemes(AllocationScheme[])}
   */
  @Test
  @DisplayName("Test withAllocationSchemes(AllocationScheme[]) with 'AllocationScheme[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAllocationsView ImmutableAllocationsView.withAllocationSchemes(AllocationScheme[])"})
  void testWithAllocationSchemesWithAllocationScheme() {
    // Arrange
    ImmutableAllocationsView buildResult = ImmutableAllocationsView.builder().build();

    // Act
    ImmutableAllocationsView actualWithAllocationSchemesResult = buildResult
        .withAllocationSchemes(mock(AllocationScheme.class));

    // Assert
    assertEquals(1, actualWithAllocationSchemesResult.allocationSchemes().size());
    assertTrue(actualWithAllocationSchemesResult.allocations().isEmpty());
  }

  /**
   * Test {@link ImmutableAllocationsView#withAllocations(Allocation[])} with {@code Allocation[]}.
   * <ul>
   *   <li>When {@link Allocation}.</li>
   *   <li>Then return allocations size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAllocationsView#withAllocations(Allocation[])}
   */
  @Test
  @DisplayName("Test withAllocations(Allocation[]) with 'Allocation[]'; when Allocation; then return allocations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAllocationsView ImmutableAllocationsView.withAllocations(Allocation[])"})
  void testWithAllocationsWithAllocation_whenAllocation_thenReturnAllocationsSizeIsOne() {
    // Arrange
    ImmutableAllocationsView buildResult = ImmutableAllocationsView.builder().build();

    // Act
    ImmutableAllocationsView actualWithAllocationsResult = buildResult.withAllocations(mock(Allocation.class));

    // Assert
    assertEquals(1, actualWithAllocationsResult.allocations().size());
    assertTrue(actualWithAllocationsResult.allocationSchemes().isEmpty());
  }
}
