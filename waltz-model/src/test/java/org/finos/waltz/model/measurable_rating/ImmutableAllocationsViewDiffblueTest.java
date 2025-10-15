package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.allocation.Allocation;
import org.finos.waltz.model.allocation.ImmutableAllocation;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.model.allocation_scheme.ImmutableAllocationScheme;
import org.finos.waltz.model.measurable_rating.ImmutableAllocationsView.Builder;
import org.finos.waltz.model.measurable_rating.ImmutableAllocationsView.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAllocationsViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAllocationSchemes(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAllocationSchemes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAllocationSchemes(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAllocationSchemes(Iterable)"})
  void testBuilderAddAllAllocationSchemes_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();

    // Act
    Builder actualAddAllAllocationSchemesResult =
        builderResult.addAllAllocationSchemes(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAllocationSchemesResult);
  }

  /**
   * Test Builder {@link Builder#addAllAllocations(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAllocations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAllocations(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAllocations(Iterable)"})
  void testBuilderAddAllAllocations_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();

    // Act
    Builder actualAddAllAllocationsResult = builderResult.addAllAllocations(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAllocationsResult);
  }

  /**
   * Test Builder {@link Builder#addAllocationSchemes(AllocationScheme)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addAllocationSchemes(AllocationScheme)}
   */
  @Test
  @DisplayName("Test Builder addAllocationSchemes(AllocationScheme) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllocationSchemes(AllocationScheme)"})
  void testBuilderAddAllocationSchemesWithElement() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();

    // Act
    Builder actualAddAllocationSchemesResult =
        builderResult.addAllocationSchemes(mock(AllocationScheme.class));

    // Assert
    assertEquals(1, builderResult.build().allocationSchemes().size());
    assertSame(builderResult, actualAddAllocationSchemesResult);
  }

  /**
   * Test Builder {@link Builder#addAllocationSchemes(AllocationScheme[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addAllocationSchemes(AllocationScheme[])}
   */
  @Test
  @DisplayName("Test Builder addAllocationSchemes(AllocationScheme[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllocationSchemes(AllocationScheme[])"})
  void testBuilderAddAllocationSchemesWithElements() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();

    // Act
    Builder actualAddAllocationSchemesResult =
        builderResult.addAllocationSchemes(mock(AllocationScheme.class));

    // Assert
    assertEquals(1, builderResult.build().allocationSchemes().size());
    assertSame(builderResult, actualAddAllocationSchemesResult);
  }

  /**
   * Test Builder {@link Builder#addAllocations(Allocation)} with {@code element}.
   *
   * <ul>
   *   <li>Then builder build allocations size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllocations(Allocation)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllocations(Allocation) with 'element'; then builder build allocations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then builder build allocations size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllocations(Allocation[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAllocations(Allocation[]) with 'elements'; then builder build allocations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#allocationSchemes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder allocationSchemes(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.allocationSchemes(Iterable)"})
  void testBuilderAllocationSchemes_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();

    // Act
    Builder actualAllocationSchemesResult = builderResult.allocationSchemes(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAllocationSchemesResult);
  }

  /**
   * Test Builder {@link Builder#allocations(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#allocations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder allocations(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.allocations(Iterable)"})
  void testBuilderAllocations_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();

    // Act
    Builder actualAllocationsResult = builderResult.allocations(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAllocationsResult);
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
  @MethodsUnderTest({"ImmutableAllocationsView Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableAllocationsView.builder().build().allocationSchemes().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(AllocationsView)}.
   *
   * <ul>
   *   <li>Then return build is builder build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AllocationsView)}
   */
  @Test
  @DisplayName("Test Builder from(AllocationsView); then return build is builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AllocationsView)"})
  void testBuilderFrom_thenReturnBuildIsBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();

    Builder builderResult2 = ImmutableAllocationsView.builder();
    builderResult2.addAllocationSchemes(
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());
    ImmutableAllocationsView instance = builderResult2.build();

    // Act and Assert
    ImmutableAllocationsView actualImmutableAllocationsView = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAllocationsView);
    ImmutableAllocationsView actualImmutableAllocationsView2 = builderResult.build();
    assertEquals(instance, actualImmutableAllocationsView2);
  }

  /**
   * Test Builder {@link Builder#from(AllocationsView)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AllocationsView)}
   */
  @Test
  @DisplayName("Test Builder from(AllocationsView); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AllocationsView)"})
  void testBuilderFrom_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();

    Builder builderResult2 = ImmutableAllocationsView.builder();
    builderResult2.addAllocations(
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());
    builderResult2.addAllocationSchemes(
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());
    ImmutableAllocationsView instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAllocationsView actualImmutableAllocationsView = builderResult.build();
    assertEquals(instance, actualImmutableAllocationsView);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AllocationsView)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return build is builder build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AllocationsView)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AllocationsView); when builder build; then return build is builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AllocationsView)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildIsBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();
    ImmutableAllocationsView instance = ImmutableAllocationsView.builder().build();

    // Act and Assert
    ImmutableAllocationsView actualImmutableAllocationsView = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableAllocationsView);
    ImmutableAllocationsView actualImmutableAllocationsView2 = builderResult.build();
    assertEquals(instance, actualImmutableAllocationsView2);
  }

  /**
   * Test {@link ImmutableAllocationsView#copyOf(AllocationsView)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return allocationSchemes Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationsView#copyOf(AllocationsView)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AllocationsView); when builder build; then return allocationSchemes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link ImmutableAllocationsView#equals(Object)}, and {@link
   * ImmutableAllocationsView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAllocationsView#equals(Object)}
   *   <li>{@link ImmutableAllocationsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocationsView.equals(Object)",
    "int ImmutableAllocationsView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAllocationsView immutableAllocationsView = ImmutableAllocationsView.builder().build();
    ImmutableAllocationsView immutableAllocationsView2 = ImmutableAllocationsView.builder().build();

    // Act and Assert
    assertEquals(immutableAllocationsView, immutableAllocationsView2);
    assertEquals(immutableAllocationsView.hashCode(), immutableAllocationsView2.hashCode());
  }

  /**
   * Test {@link ImmutableAllocationsView#equals(Object)}, and {@link
   * ImmutableAllocationsView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAllocationsView#equals(Object)}
   *   <li>{@link ImmutableAllocationsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocationsView.equals(Object)",
    "int ImmutableAllocationsView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAllocationsView immutableAllocationsView = ImmutableAllocationsView.builder().build();

    // Act and Assert
    assertEquals(immutableAllocationsView, immutableAllocationsView);
    int expectedHashCodeResult = immutableAllocationsView.hashCode();
    assertEquals(expectedHashCodeResult, immutableAllocationsView.hashCode());
  }

  /**
   * Test {@link ImmutableAllocationsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocationsView.equals(Object)",
    "int ImmutableAllocationsView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();
    builderResult.addAllocationSchemes(
        ImmutableAllocationScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .measurableCategoryId(1L)
            .name("Name")
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableAllocationsView.builder().build());
  }

  /**
   * Test {@link ImmutableAllocationsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocationsView.equals(Object)",
    "int ImmutableAllocationsView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAllocationsView.builder();
    builderResult.addAllocations(
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableAllocationsView.builder().build());
  }

  /**
   * Test {@link ImmutableAllocationsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocationsView.equals(Object)",
    "int ImmutableAllocationsView.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableAllocationsView.builder().build(), null);
  }

  /**
   * Test {@link ImmutableAllocationsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocationsView.equals(Object)",
    "int ImmutableAllocationsView.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAllocationsView.builder().build(), "Different type to ImmutableAllocationsView");
  }

  /**
   * Test {@link ImmutableAllocationsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link Allocation}.
   *   <li>Then return allocations size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationsView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Allocation; then return allocations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return allocationSchemes size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return allocationSchemes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return allocations is allocationSchemes.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return allocations is allocationSchemes")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return allocations is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return allocations is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAllocationsView ImmutableAllocationsView.fromJson(Json)"})
  void testFromJson_thenReturnAllocationsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<Allocation> allocations = new LinkedHashSet<>();
    allocations.add(
        ImmutableAllocation.builder()
            .externalId("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .percentage(1)
            .provenance("Provenance")
            .schemeId(1L)
            .build());
    allocations.add(mock(Allocation.class));

    Json json = new Json();
    json.setAllocationSchemes(null);
    json.setAllocations(allocations);

    // Act
    ImmutableAllocationsView actualFromJsonResult = ImmutableAllocationsView.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.allocationSchemes().isEmpty());
    assertEquals(allocations, actualFromJsonResult.allocations());
  }

  /**
   * Test {@link ImmutableAllocationsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return allocations is {@link Json} (default constructor) {@link Json#allocations}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocationsView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return allocations is Json (default constructor) allocations")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAllocationsView#toString()}
   *   <li>{@link ImmutableAllocationsView#allocationSchemes()}
   *   <li>{@link ImmutableAllocationsView#allocations()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableAllocationsView.allocationSchemes()",
    "Set ImmutableAllocationsView.allocations()",
    "String ImmutableAllocationsView.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAllocationsView immutableAllocationsView = ImmutableAllocationsView.builder().build();

    // Act
    String actualToStringResult = immutableAllocationsView.toString();
    Set<AllocationScheme> actualAllocationSchemesResult =
        immutableAllocationsView.allocationSchemes();
    Set<Allocation> actualAllocationsResult = immutableAllocationsView.allocations();

    // Assert
    assertEquals("AllocationsView{allocationSchemes=[], allocations=[]}", actualToStringResult);
    assertTrue(actualAllocationSchemesResult.isEmpty());
    assertSame(actualAllocationSchemesResult, actualAllocationsResult);
  }

  /**
   * Test Json {@link Json#allocationSchemes()}.
   *
   * <p>Method under test: {@link Json#allocationSchemes()}
   */
  @Test
  @DisplayName("Test Json allocationSchemes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.allocationSchemes()"})
  void testJsonAllocationSchemes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().allocationSchemes());
  }

  /**
   * Test Json {@link Json#allocations()}.
   *
   * <p>Method under test: {@link Json#allocations()}
   */
  @Test
  @DisplayName("Test Json allocations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.allocations()"})
  void testJsonAllocations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().allocations());
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
    assertTrue(actualJson.allocationSchemes.isEmpty());
    assertTrue(actualJson.allocations.isEmpty());
  }

  /**
   * Test {@link ImmutableAllocationsView#withAllocationSchemes(AllocationScheme[])} with {@code
   * AllocationScheme[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAllocationsView#withAllocationSchemes(AllocationScheme[])}
   */
  @Test
  @DisplayName("Test withAllocationSchemes(AllocationScheme[]) with 'AllocationScheme[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocationsView ImmutableAllocationsView.withAllocationSchemes(AllocationScheme[])"
  })
  void testWithAllocationSchemesWithAllocationScheme() {
    // Arrange
    ImmutableAllocationsView immutableAllocationsView = ImmutableAllocationsView.builder().build();

    // Act
    ImmutableAllocationsView actualWithAllocationSchemesResult =
        immutableAllocationsView.withAllocationSchemes(
            ImmutableAllocationScheme.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .measurableCategoryId(1L)
                .name("Name")
                .build());

    // Assert
    assertEquals(1, actualWithAllocationSchemesResult.allocationSchemes().size());
    assertTrue(actualWithAllocationSchemesResult.allocations().isEmpty());
  }

  /**
   * Test {@link ImmutableAllocationsView#withAllocations(Allocation[])} with {@code Allocation[]}.
   *
   * <p>Method under test: {@link ImmutableAllocationsView#withAllocations(Allocation[])}
   */
  @Test
  @DisplayName("Test withAllocations(Allocation[]) with 'Allocation[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocationsView ImmutableAllocationsView.withAllocations(Allocation[])"
  })
  void testWithAllocationsWithAllocation() {
    // Arrange
    ImmutableAllocationsView immutableAllocationsView = ImmutableAllocationsView.builder().build();

    // Act
    ImmutableAllocationsView actualWithAllocationsResult =
        immutableAllocationsView.withAllocations(
            ImmutableAllocation.builder()
                .externalId("42")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .percentage(1)
                .provenance("Provenance")
                .schemeId(1L)
                .build());

    // Assert
    assertEquals(1, actualWithAllocationsResult.allocations().size());
    assertTrue(actualWithAllocationsResult.allocationSchemes().isEmpty());
  }
}
