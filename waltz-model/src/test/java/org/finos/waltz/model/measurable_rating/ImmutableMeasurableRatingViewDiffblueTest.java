package org.finos.waltz.model.measurable_rating;

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
import org.finos.waltz.model.allocation.Allocation;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable_category.MeasurableCategory;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingView.Builder;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingView.Json;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_replacement.MeasurableRatingReplacement;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingViewDiffblueTest {
  /**
   * Test {@link ImmutableMeasurableRatingView#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingView#builder()}
   *   <li>{@link ImmutableMeasurableRatingView#category(MeasurableCategory)}
   *   <li>{@link ImmutableMeasurableRatingView#decommission(MeasurableRatingPlannedDecommission)}
   *   <li>{@link ImmutableMeasurableRatingView#measurable(Measurable)}
   *   <li>{@link ImmutableMeasurableRatingView#rating(RatingSchemeItem)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableMeasurableRatingView Builder.build()", "Builder Builder.category(MeasurableCategory)",
      "Builder Builder.decommission(MeasurableRatingPlannedDecommission)", "Builder Builder.measurable(Measurable)",
      "Builder Builder.rating(RatingSchemeItem)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualMeasurableResult = ImmutableMeasurableRatingView.builder()
        .category(null)
        .decommission(null)
        .measurable(null);

    // Assert
    assertSame(actualMeasurableResult, actualMeasurableResult.rating(null));
  }

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
    Builder builderResult = ImmutableMeasurableRatingView.builder();

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
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAllocations(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllReplacements(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllReplacements(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllReplacements(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllReplacements(Iterable)"})
  void testBuilderAddAllReplacements_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllReplacements(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllocationSchemes(AllocationScheme)} with {@code element}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllocationSchemes(AllocationScheme)}
   */
  @Test
  @DisplayName("Test Builder addAllocationSchemes(AllocationScheme) with 'element'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllocationSchemes(AllocationScheme)"})
  void testBuilderAddAllocationSchemesWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllocationSchemes(mock(AllocationScheme.class)));
  }

  /**
   * Test Builder {@link Builder#addAllocationSchemes(AllocationScheme[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllocationSchemes(AllocationScheme[])}
   */
  @Test
  @DisplayName("Test Builder addAllocationSchemes(AllocationScheme[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllocationSchemes(AllocationScheme[])"})
  void testBuilderAddAllocationSchemesWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllocationSchemes(mock(AllocationScheme.class)));
  }

  /**
   * Test Builder {@link Builder#addAllocations(Allocation)} with {@code element}.
   * <ul>
   *   <li>When {@link Allocation}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllocations(Allocation)}
   */
  @Test
  @DisplayName("Test Builder addAllocations(Allocation) with 'element'; when Allocation; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllocations(Allocation)"})
  void testBuilderAddAllocationsWithElement_whenAllocation_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllocations(mock(Allocation.class)));
  }

  /**
   * Test Builder {@link Builder#addAllocations(Allocation[])} with {@code elements}.
   * <ul>
   *   <li>When {@link Allocation}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllocations(Allocation[])}
   */
  @Test
  @DisplayName("Test Builder addAllocations(Allocation[]) with 'elements'; when Allocation; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllocations(Allocation[])"})
  void testBuilderAddAllocationsWithElements_whenAllocation_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllocations(mock(Allocation.class)));
  }

  /**
   * Test Builder {@link Builder#addReplacements(MeasurableRatingReplacement)} with {@code element}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addReplacements(MeasurableRatingReplacement)}
   */
  @Test
  @DisplayName("Test Builder addReplacements(MeasurableRatingReplacement) with 'element'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addReplacements(MeasurableRatingReplacement)"})
  void testBuilderAddReplacementsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addReplacements(mock(MeasurableRatingReplacement.class)));
  }

  /**
   * Test Builder {@link Builder#addReplacements(MeasurableRatingReplacement[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addReplacements(MeasurableRatingReplacement[])}
   */
  @Test
  @DisplayName("Test Builder addReplacements(MeasurableRatingReplacement[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addReplacements(MeasurableRatingReplacement[])"})
  void testBuilderAddReplacementsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addReplacements(mock(MeasurableRatingReplacement.class)));
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
    Builder builderResult = ImmutableMeasurableRatingView.builder();

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
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allocations(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingView)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build measurable is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingView); given ArrayList(); then return build measurable is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingView)"})
  void testBuilderFrom_givenArrayList_thenReturnBuildMeasurableIsNull() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(null);
    when(instance.measurableRating()).thenReturn(new ImmutableMeasurableRating.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    ImmutableMeasurableRatingView buildResult = actualFromResult.build();
    assertNull(buildResult.measurable());
    ImmutableMeasurableRatingView buildResult2 = builderResult.build();
    assertNull(buildResult2.measurable());
    assertNull(buildResult.category());
    assertNull(buildResult2.category());
    assertNull(buildResult.decommission());
    assertNull(buildResult2.decommission());
    assertNull(buildResult.rating());
    assertNull(buildResult2.rating());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingView)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Allocation}.</li>
   *   <li>Then return build allocations size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingView); given HashSet() add Allocation; then return build allocations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingView)"})
  void testBuilderFrom_givenHashSetAddAllocation_thenReturnBuildAllocationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    HashSet<Allocation> allocationSet = new HashSet<>();
    allocationSet.add(mock(Allocation.class));
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(allocationSet);
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(null);
    when(instance.measurableRating()).thenReturn(new ImmutableMeasurableRating.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    ImmutableMeasurableRatingView buildResult = actualFromResult.build();
    assertEquals(1, buildResult.allocations().size());
    assertEquals(1, builderResult.build().allocations().size());
    assertTrue(buildResult.replacements().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingView)}.
   * <ul>
   *   <li>Given {@link Measurable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingView); given Measurable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingView)"})
  void testBuilderFrom_givenMeasurable() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(mock(Measurable.class));
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(null);
    when(instance.measurableRating()).thenReturn(new ImmutableMeasurableRating.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    ImmutableMeasurableRatingView buildResult = actualFromResult.build();
    assertNull(buildResult.category());
    ImmutableMeasurableRatingView buildResult2 = builderResult.build();
    assertNull(buildResult2.category());
    assertNull(buildResult.decommission());
    assertNull(buildResult2.decommission());
    assertNull(buildResult.rating());
    assertNull(buildResult2.rating());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingView)}.
   * <ul>
   *   <li>Given {@link MeasurableCategory}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingView); given MeasurableCategory")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingView)"})
  void testBuilderFrom_givenMeasurableCategory() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(mock(MeasurableCategory.class));
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(null);
    when(instance.measurableRating()).thenReturn(new ImmutableMeasurableRating.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    ImmutableMeasurableRatingView buildResult = actualFromResult.build();
    assertNull(buildResult.measurable());
    ImmutableMeasurableRatingView buildResult2 = builderResult.build();
    assertNull(buildResult2.measurable());
    assertNull(buildResult.decommission());
    assertNull(buildResult2.decommission());
    assertNull(buildResult.rating());
    assertNull(buildResult2.rating());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingView)}.
   * <ul>
   *   <li>Given {@link MeasurableRatingPlannedDecommission}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingView); given MeasurableRatingPlannedDecommission")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingView)"})
  void testBuilderFrom_givenMeasurableRatingPlannedDecommission() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(mock(MeasurableRatingPlannedDecommission.class));
    when(instance.rating()).thenReturn(null);
    when(instance.measurableRating()).thenReturn(new ImmutableMeasurableRating.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    ImmutableMeasurableRatingView buildResult = actualFromResult.build();
    assertNull(buildResult.measurable());
    ImmutableMeasurableRatingView buildResult2 = builderResult.build();
    assertNull(buildResult2.measurable());
    assertNull(buildResult.category());
    assertNull(buildResult2.category());
    assertNull(buildResult.rating());
    assertNull(buildResult2.rating());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingView)}.
   * <ul>
   *   <li>Given {@link RatingSchemeItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingView); given RatingSchemeItem")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingView)"})
  void testBuilderFrom_givenRatingSchemeItem() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(mock(RatingSchemeItem.class));
    when(instance.measurableRating()).thenReturn(new ImmutableMeasurableRating.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    ImmutableMeasurableRatingView buildResult = actualFromResult.build();
    assertNull(buildResult.measurable());
    ImmutableMeasurableRatingView buildResult2 = builderResult.build();
    assertNull(buildResult2.measurable());
    assertNull(buildResult.category());
    assertNull(buildResult2.category());
    assertNull(buildResult.decommission());
    assertNull(buildResult2.decommission());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingView)}.
   * <ul>
   *   <li>Then return build allocationSchemes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingView); then return build allocationSchemes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingView)"})
  void testBuilderFrom_thenReturnBuildAllocationSchemesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    ArrayList<AllocationScheme> allocationSchemeList = new ArrayList<>();
    allocationSchemeList.add(mock(AllocationScheme.class));
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(allocationSchemeList);
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(null);
    when(instance.measurableRating()).thenReturn(new ImmutableMeasurableRating.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    assertEquals(1, actualFromResult.build().allocationSchemes().size());
    assertEquals(1, builderResult.build().allocationSchemes().size());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingView)}.
   * <ul>
   *   <li>Then return build replacements size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingView); then return build replacements size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingView)"})
  void testBuilderFrom_thenReturnBuildReplacementsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    HashSet<MeasurableRatingReplacement> measurableRatingReplacementSet = new HashSet<>();
    measurableRatingReplacementSet.add(mock(MeasurableRatingReplacement.class));
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(measurableRatingReplacementSet);
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(null);
    when(instance.measurableRating()).thenReturn(new ImmutableMeasurableRating.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    assertEquals(1, actualFromResult.build().replacements().size());
    assertEquals(1, builderResult.build().replacements().size());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingView)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingView); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingView)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.measurable()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableRating()).thenReturn(new ImmutableMeasurableRating.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).measurable();
    verify(instance).measurableRating();
  }

  /**
   * Test Builder {@link Builder#measurableRating(MeasurableRating)}.
   * <ul>
   *   <li>When {@link ImmutableMeasurableRating.Json} (default constructor).</li>
   *   <li>Then builder build measurable is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#measurableRating(MeasurableRating)}
   */
  @Test
  @DisplayName("Test Builder measurableRating(MeasurableRating); when Json (default constructor); then builder build measurable is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableRating(MeasurableRating)"})
  void testBuilderMeasurableRating_whenJson_thenBuilderBuildMeasurableIsNull() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();
    ImmutableMeasurableRating.Json measurableRating = new ImmutableMeasurableRating.Json();

    // Act
    Builder actualMeasurableRatingResult = builderResult.measurableRating(measurableRating);

    // Assert
    ImmutableMeasurableRatingView buildResult = builderResult.build();
    assertNull(buildResult.measurable());
    assertNull(buildResult.category());
    assertNull(buildResult.decommission());
    assertNull(buildResult.rating());
    assertSame(measurableRating, buildResult.measurableRating());
    assertSame(builderResult, actualMeasurableRatingResult);
  }

  /**
   * Test Builder {@link Builder#replacements(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#replacements(Iterable)}
   */
  @Test
  @DisplayName("Test Builder replacements(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.replacements(Iterable)"})
  void testBuilderReplacements_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.replacements(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#allocationSchemes()}.
   * <p>
   * Method under test: {@link Json#allocationSchemes()}
   */
  @Test
  @DisplayName("Test Json allocationSchemes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List Json.allocationSchemes()"})
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
  @MethodsUnderTest({"java.util.Set Json.allocations()"})
  void testJsonAllocations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).allocations());
  }

  /**
   * Test Json {@link Json#category()}.
   * <p>
   * Method under test: {@link Json#category()}
   */
  @Test
  @DisplayName("Test Json category()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurableCategory Json.category()"})
  void testJsonCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).category());
  }

  /**
   * Test Json {@link Json#decommission()}.
   * <p>
   * Method under test: {@link Json#decommission()}
   */
  @Test
  @DisplayName("Test Json decommission()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurableRatingPlannedDecommission Json.decommission()"})
  void testJsonDecommission() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).decommission());
  }

  /**
   * Test Json {@link Json#measurable()}.
   * <p>
   * Method under test: {@link Json#measurable()}
   */
  @Test
  @DisplayName("Test Json measurable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Measurable Json.measurable()"})
  void testJsonMeasurable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurable());
  }

  /**
   * Test Json {@link Json#measurableRating()}.
   * <p>
   * Method under test: {@link Json#measurableRating()}
   */
  @Test
  @DisplayName("Test Json measurableRating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurableRating Json.measurableRating()"})
  void testJsonMeasurableRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableRating());
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
    assertNull(actualJson.measurable);
    assertNull(actualJson.category);
    assertNull(actualJson.measurableRating);
    assertNull(actualJson.decommission);
    assertNull(actualJson.rating);
    assertTrue(actualJson.allocationSchemes.isEmpty());
    assertTrue(actualJson.allocations.isEmpty());
    assertTrue(actualJson.replacements.isEmpty());
  }

  /**
   * Test Json {@link Json#rating()}.
   * <p>
   * Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RatingSchemeItem Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rating());
  }

  /**
   * Test Json {@link Json#replacements()}.
   * <p>
   * Method under test: {@link Json#replacements()}
   */
  @Test
  @DisplayName("Test Json replacements()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.replacements()"})
  void testJsonReplacements() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).replacements());
  }
}
