package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.allocation.Allocation;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable_category.MeasurableCategory;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_replacement.MeasurableRatingReplacement;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingViewDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingView#builder()}
   *   <li>{@link ImmutableMeasurableRatingView#category(MeasurableCategory)}
   *   <li>
   * {@link ImmutableMeasurableRatingView#decommission(MeasurableRatingPlannedDecommission)}
   *   <li>{@link ImmutableMeasurableRatingView#measurable(Measurable)}
   *   <li>{@link ImmutableMeasurableRatingView#rating(RatingSchemeItem)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableMeasurableRatingView.Builder actualMeasurableResult = ImmutableMeasurableRatingView.builder()
        .category(null)
        .decommission(null)
        .measurable(null);

    // Assert
    assertSame(actualMeasurableResult, actualMeasurableResult.rating(null));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#addAllAllocationSchemes(Iterable)}
   */
  @Test
  void testBuilderAddAllAllocationSchemes() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAllocationSchemes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#addAllAllocations(Iterable)}
   */
  @Test
  void testBuilderAddAllAllocations() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAllocations(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#addAllReplacements(Iterable)}
   */
  @Test
  void testBuilderAddAllReplacements() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllReplacements(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#addAllocationSchemes(AllocationScheme)}
   */
  @Test
  void testBuilderAddAllocationSchemes() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllocationSchemes(mock(AllocationScheme.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#addAllocationSchemes(AllocationScheme[])}
   */
  @Test
  void testBuilderAddAllocationSchemes2() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllocationSchemes(mock(AllocationScheme.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#addAllocations(Allocation)}
   */
  @Test
  void testBuilderAddAllocations() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllocations(mock(Allocation.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#addAllocations(Allocation[])}
   */
  @Test
  void testBuilderAddAllocations2() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllocations(mock(Allocation.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#addReplacements(MeasurableRatingReplacement)}
   */
  @Test
  void testBuilderAddReplacements() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addReplacements(mock(MeasurableRatingReplacement.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#addReplacements(MeasurableRatingReplacement[])}
   */
  @Test
  void testBuilderAddReplacements2() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addReplacements(mock(MeasurableRatingReplacement.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#allocationSchemes(Iterable)}
   */
  @Test
  void testBuilderAllocationSchemes() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allocationSchemes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#allocations(Iterable)}
   */
  @Test
  void testBuilderAllocations() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allocations(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#from(MeasurableRatingView)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(null);
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    ImmutableMeasurableRatingView buildResult = builderResult.build();
    assertNull(buildResult.measurable());
    assertNull(buildResult.category());
    assertNull(buildResult.decommission());
    assertNull(buildResult.rating());
    assertSame(json, buildResult.measurableRating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#from(MeasurableRatingView)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.measurable()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableRating()).thenReturn(new ImmutableMeasurableRating.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).measurable();
    verify(instance).measurableRating();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#from(MeasurableRatingView)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();

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
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    ImmutableMeasurableRatingView buildResult = builderResult.build();
    assertNull(buildResult.measurable());
    assertNull(buildResult.category());
    assertNull(buildResult.decommission());
    assertNull(buildResult.rating());
    assertEquals(1, buildResult.allocationSchemes().size());
    assertSame(json, buildResult.measurableRating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#from(MeasurableRatingView)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();

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
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    ImmutableMeasurableRatingView buildResult = builderResult.build();
    assertNull(buildResult.measurable());
    assertNull(buildResult.category());
    assertNull(buildResult.decommission());
    assertNull(buildResult.rating());
    assertEquals(1, buildResult.allocations().size());
    assertSame(json, buildResult.measurableRating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#from(MeasurableRatingView)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();

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
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    ImmutableMeasurableRatingView buildResult = builderResult.build();
    assertNull(buildResult.measurable());
    assertNull(buildResult.category());
    assertNull(buildResult.decommission());
    assertNull(buildResult.rating());
    assertEquals(1, buildResult.replacements().size());
    assertSame(json, buildResult.measurableRating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#from(MeasurableRatingView)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(mock(Measurable.class));
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(null);
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    ImmutableMeasurableRatingView buildResult = builderResult.build();
    assertNull(buildResult.category());
    assertNull(buildResult.decommission());
    assertNull(buildResult.rating());
    assertSame(json, buildResult.measurableRating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#from(MeasurableRatingView)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(mock(MeasurableCategory.class));
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(null);
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    ImmutableMeasurableRatingView buildResult = builderResult.build();
    assertNull(buildResult.measurable());
    assertNull(buildResult.decommission());
    assertNull(buildResult.rating());
    assertSame(json, buildResult.measurableRating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#from(MeasurableRatingView)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(mock(MeasurableRatingPlannedDecommission.class));
    when(instance.rating()).thenReturn(null);
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    ImmutableMeasurableRatingView buildResult = builderResult.build();
    assertNull(buildResult.measurable());
    assertNull(buildResult.category());
    assertNull(buildResult.rating());
    assertSame(json, buildResult.measurableRating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#from(MeasurableRatingView)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(mock(RatingSchemeItem.class));
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    ImmutableMeasurableRatingView buildResult = builderResult.build();
    assertNull(buildResult.measurable());
    assertNull(buildResult.category());
    assertNull(buildResult.decommission());
    assertSame(json, buildResult.measurableRating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#measurableRating(MeasurableRating)}
   */
  @Test
  void testBuilderMeasurableRating() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();
    ImmutableMeasurableRating.Json measurableRating = new ImmutableMeasurableRating.Json();

    // Act
    ImmutableMeasurableRatingView.Builder actualMeasurableRatingResult = builderResult
        .measurableRating(measurableRating);

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
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#measurableRating(MeasurableRating)}
   */
  @Test
  void testBuilderMeasurableRating2() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();
    builderResult.addReplacements(mock(MeasurableRatingReplacement.class));
    ImmutableMeasurableRating.Json measurableRating = new ImmutableMeasurableRating.Json();

    // Act
    ImmutableMeasurableRatingView.Builder actualMeasurableRatingResult = builderResult
        .measurableRating(measurableRating);

    // Assert
    ImmutableMeasurableRatingView buildResult = builderResult.build();
    assertNull(buildResult.measurable());
    assertNull(buildResult.category());
    assertNull(buildResult.decommission());
    assertNull(buildResult.rating());
    assertEquals(1, buildResult.replacements().size());
    assertSame(measurableRating, buildResult.measurableRating());
    assertSame(builderResult, actualMeasurableRatingResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Builder#replacements(Iterable)}
   */
  @Test
  void testBuilderReplacements() {
    // Arrange
    ImmutableMeasurableRatingView.Builder builderResult = ImmutableMeasurableRatingView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.replacements(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView#copyOf(MeasurableRatingView)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(null);
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView actualCopyOfResult = ImmutableMeasurableRatingView.copyOf(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    assertNull(actualCopyOfResult.measurable());
    assertNull(actualCopyOfResult.category());
    assertNull(actualCopyOfResult.decommission());
    assertNull(actualCopyOfResult.rating());
    assertTrue(actualCopyOfResult.allocationSchemes().isEmpty());
    Set<Allocation> allocationsResult = actualCopyOfResult.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertSame(json, actualCopyOfResult.measurableRating());
    assertSame(allocationsResult, actualCopyOfResult.replacements());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView#copyOf(MeasurableRatingView)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
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
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView actualCopyOfResult = ImmutableMeasurableRatingView.copyOf(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    assertNull(actualCopyOfResult.measurable());
    assertNull(actualCopyOfResult.category());
    assertNull(actualCopyOfResult.decommission());
    assertNull(actualCopyOfResult.rating());
    assertEquals(1, actualCopyOfResult.allocationSchemes().size());
    Set<Allocation> allocationsResult = actualCopyOfResult.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertSame(json, actualCopyOfResult.measurableRating());
    assertSame(allocationsResult, actualCopyOfResult.replacements());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView#copyOf(MeasurableRatingView)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<AllocationScheme> allocationSchemeList = new ArrayList<>();
    allocationSchemeList.add(mock(AllocationScheme.class));
    allocationSchemeList.add(mock(AllocationScheme.class));
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(allocationSchemeList);
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(null);
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView actualCopyOfResult = ImmutableMeasurableRatingView.copyOf(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    assertNull(actualCopyOfResult.measurable());
    assertNull(actualCopyOfResult.category());
    assertNull(actualCopyOfResult.decommission());
    assertNull(actualCopyOfResult.rating());
    Set<Allocation> allocationsResult = actualCopyOfResult.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertEquals(allocationSchemeList, actualCopyOfResult.allocationSchemes());
    assertSame(json, actualCopyOfResult.measurableRating());
    assertSame(allocationsResult, actualCopyOfResult.replacements());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView#copyOf(MeasurableRatingView)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
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
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView actualCopyOfResult = ImmutableMeasurableRatingView.copyOf(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    assertNull(actualCopyOfResult.measurable());
    assertNull(actualCopyOfResult.category());
    assertNull(actualCopyOfResult.decommission());
    assertNull(actualCopyOfResult.rating());
    assertEquals(1, actualCopyOfResult.allocations().size());
    assertTrue(actualCopyOfResult.allocationSchemes().isEmpty());
    assertTrue(actualCopyOfResult.replacements().isEmpty());
    assertSame(json, actualCopyOfResult.measurableRating());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView#copyOf(MeasurableRatingView)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<Allocation> allocationSet = new HashSet<>();
    allocationSet.add(mock(Allocation.class));
    allocationSet.add(mock(Allocation.class));
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(allocationSet);
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(null);
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView actualCopyOfResult = ImmutableMeasurableRatingView.copyOf(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    assertNull(actualCopyOfResult.measurable());
    assertNull(actualCopyOfResult.category());
    assertNull(actualCopyOfResult.decommission());
    assertNull(actualCopyOfResult.rating());
    assertTrue(actualCopyOfResult.allocationSchemes().isEmpty());
    assertTrue(actualCopyOfResult.replacements().isEmpty());
    assertEquals(allocationSet, actualCopyOfResult.allocations());
    assertSame(json, actualCopyOfResult.measurableRating());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView#copyOf(MeasurableRatingView)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
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
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView actualCopyOfResult = ImmutableMeasurableRatingView.copyOf(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    assertNull(actualCopyOfResult.measurable());
    assertNull(actualCopyOfResult.category());
    assertNull(actualCopyOfResult.decommission());
    assertNull(actualCopyOfResult.rating());
    assertEquals(1, actualCopyOfResult.replacements().size());
    assertTrue(actualCopyOfResult.allocationSchemes().isEmpty());
    assertTrue(actualCopyOfResult.allocations().isEmpty());
    assertSame(json, actualCopyOfResult.measurableRating());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView#copyOf(MeasurableRatingView)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(mock(Measurable.class));
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(null);
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView actualCopyOfResult = ImmutableMeasurableRatingView.copyOf(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    assertNull(actualCopyOfResult.category());
    assertNull(actualCopyOfResult.decommission());
    assertNull(actualCopyOfResult.rating());
    assertTrue(actualCopyOfResult.allocationSchemes().isEmpty());
    Set<Allocation> allocationsResult = actualCopyOfResult.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertSame(json, actualCopyOfResult.measurableRating());
    assertSame(allocationsResult, actualCopyOfResult.replacements());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView#copyOf(MeasurableRatingView)}
   */
  @Test
  void testCopyOf8() {
    // Arrange
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(mock(MeasurableCategory.class));
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(null);
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView actualCopyOfResult = ImmutableMeasurableRatingView.copyOf(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    assertNull(actualCopyOfResult.measurable());
    assertNull(actualCopyOfResult.decommission());
    assertNull(actualCopyOfResult.rating());
    assertTrue(actualCopyOfResult.allocationSchemes().isEmpty());
    Set<Allocation> allocationsResult = actualCopyOfResult.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertSame(json, actualCopyOfResult.measurableRating());
    assertSame(allocationsResult, actualCopyOfResult.replacements());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView#copyOf(MeasurableRatingView)}
   */
  @Test
  void testCopyOf9() {
    // Arrange
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(mock(MeasurableRatingPlannedDecommission.class));
    when(instance.rating()).thenReturn(null);
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView actualCopyOfResult = ImmutableMeasurableRatingView.copyOf(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    assertNull(actualCopyOfResult.measurable());
    assertNull(actualCopyOfResult.category());
    assertNull(actualCopyOfResult.rating());
    assertTrue(actualCopyOfResult.allocationSchemes().isEmpty());
    Set<Allocation> allocationsResult = actualCopyOfResult.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertSame(json, actualCopyOfResult.measurableRating());
    assertSame(allocationsResult, actualCopyOfResult.replacements());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView#copyOf(MeasurableRatingView)}
   */
  @Test
  void testCopyOf10() {
    // Arrange
    MeasurableRatingView instance = mock(MeasurableRatingView.class);
    when(instance.allocationSchemes()).thenReturn(new ArrayList<>());
    when(instance.allocations()).thenReturn(new HashSet<>());
    when(instance.replacements()).thenReturn(new HashSet<>());
    when(instance.measurable()).thenReturn(null);
    when(instance.category()).thenReturn(null);
    when(instance.decommission()).thenReturn(null);
    when(instance.rating()).thenReturn(mock(RatingSchemeItem.class));
    ImmutableMeasurableRating.Json json = new ImmutableMeasurableRating.Json();
    when(instance.measurableRating()).thenReturn(json);

    // Act
    ImmutableMeasurableRatingView actualCopyOfResult = ImmutableMeasurableRatingView.copyOf(instance);

    // Assert
    verify(instance).allocationSchemes();
    verify(instance).allocations();
    verify(instance).category();
    verify(instance).decommission();
    verify(instance).measurable();
    verify(instance).measurableRating();
    verify(instance).rating();
    verify(instance).replacements();
    assertNull(actualCopyOfResult.measurable());
    assertNull(actualCopyOfResult.category());
    assertNull(actualCopyOfResult.decommission());
    assertTrue(actualCopyOfResult.allocationSchemes().isEmpty());
    Set<Allocation> allocationsResult = actualCopyOfResult.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertSame(json, actualCopyOfResult.measurableRating());
    assertSame(allocationsResult, actualCopyOfResult.replacements());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView#fromJson(ImmutableMeasurableRatingView.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableMeasurableRatingView.Json json = new ImmutableMeasurableRatingView.Json();
    ImmutableMeasurableRating.Json measurableRating = new ImmutableMeasurableRating.Json();
    json.setMeasurableRating(measurableRating);

    // Act
    ImmutableMeasurableRatingView actualFromJsonResult = ImmutableMeasurableRatingView.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.measurable());
    assertNull(actualFromJsonResult.category());
    assertNull(actualFromJsonResult.decommission());
    assertNull(actualFromJsonResult.rating());
    List<AllocationScheme> allocationSchemesResult = actualFromJsonResult.allocationSchemes();
    assertTrue(allocationSchemesResult.isEmpty());
    Set<Allocation> allocationsResult = actualFromJsonResult.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertSame(measurableRating, actualFromJsonResult.measurableRating());
    assertSame(json.allocationSchemes, allocationSchemesResult);
    Set<MeasurableRatingReplacement> measurableRatingReplacementSet = json.replacements;
    assertSame(measurableRatingReplacementSet, allocationsResult);
    assertSame(measurableRatingReplacementSet, actualFromJsonResult.replacements());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView#fromJson(ImmutableMeasurableRatingView.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<AllocationScheme> allocationSchemes = new ArrayList<>();
    allocationSchemes.add(mock(AllocationScheme.class));

    ImmutableMeasurableRatingView.Json json = new ImmutableMeasurableRatingView.Json();
    ImmutableMeasurableRating.Json measurableRating = new ImmutableMeasurableRating.Json();
    json.setMeasurableRating(measurableRating);
    json.setMeasurable(null);
    json.setCategory(null);
    json.setRating(null);
    json.setDecommission(null);
    json.setReplacements(null);
    json.setAllocations(null);
    json.setAllocationSchemes(allocationSchemes);

    // Act
    ImmutableMeasurableRatingView actualFromJsonResult = ImmutableMeasurableRatingView.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.measurable());
    assertNull(actualFromJsonResult.category());
    assertNull(actualFromJsonResult.decommission());
    assertNull(actualFromJsonResult.rating());
    assertEquals(1, actualFromJsonResult.allocationSchemes().size());
    Set<Allocation> allocationsResult = actualFromJsonResult.allocations();
    assertTrue(allocationsResult.isEmpty());
    assertSame(measurableRating, actualFromJsonResult.measurableRating());
    assertSame(allocationsResult, actualFromJsonResult.replacements());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView#fromJson(ImmutableMeasurableRatingView.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<Allocation> allocations = new LinkedHashSet<>();
    allocations.add(mock(Allocation.class));

    ImmutableMeasurableRatingView.Json json = new ImmutableMeasurableRatingView.Json();
    ImmutableMeasurableRating.Json measurableRating = new ImmutableMeasurableRating.Json();
    json.setMeasurableRating(measurableRating);
    json.setMeasurable(null);
    json.setCategory(null);
    json.setRating(null);
    json.setDecommission(null);
    json.setReplacements(null);
    json.setAllocations(allocations);
    json.setAllocationSchemes(null);

    // Act
    ImmutableMeasurableRatingView actualFromJsonResult = ImmutableMeasurableRatingView.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.measurable());
    assertNull(actualFromJsonResult.category());
    assertNull(actualFromJsonResult.decommission());
    assertNull(actualFromJsonResult.rating());
    assertEquals(1, actualFromJsonResult.allocations().size());
    assertTrue(actualFromJsonResult.allocationSchemes().isEmpty());
    assertTrue(actualFromJsonResult.replacements().isEmpty());
    assertSame(measurableRating, actualFromJsonResult.measurableRating());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Json#allocationSchemes()}
   */
  @Test
  void testJsonAllocationSchemes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingView.Json()).allocationSchemes());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRatingView.Json#allocations()}
   */
  @Test
  void testJsonAllocations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRatingView.Json()).allocations());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRatingView.Json#category()}
   */
  @Test
  void testJsonCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRatingView.Json()).category());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRatingView.Json#decommission()}
   */
  @Test
  void testJsonDecommission() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRatingView.Json()).decommission());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRatingView.Json#measurable()}
   */
  @Test
  void testJsonMeasurable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRatingView.Json()).measurable());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingView.Json#measurableRating()}
   */
  @Test
  void testJsonMeasurableRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingView.Json()).measurableRating());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableMeasurableRatingView.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableMeasurableRatingView.Json actualJson = new ImmutableMeasurableRatingView.Json();

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
   * Method under test: {@link ImmutableMeasurableRatingView.Json#rating()}
   */
  @Test
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRatingView.Json()).rating());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRatingView.Json#replacements()}
   */
  @Test
  void testJsonReplacements() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRatingView.Json()).replacements());
  }
}
