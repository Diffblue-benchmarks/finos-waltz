package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable.MeasurableHierarchy;
import org.finos.waltz.model.measurable_category.MeasurableCategory;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingsViewDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#addAllMeasurableCategories(Iterable)}
   */
  @Test
  void testBuilderAddAllMeasurableCategories() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllMeasurableCategories(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#addAllMeasurableHierarchy(Iterable)}
   */
  @Test
  void testBuilderAddAllMeasurableHierarchy() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllMeasurableHierarchy(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#addAllMeasurableRatings(Iterable)}
   */
  @Test
  void testBuilderAddAllMeasurableRatings() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllMeasurableRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#addAllMeasurables(Iterable)}
   */
  @Test
  void testBuilderAddAllMeasurables() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllMeasurables(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#addAllRatingSchemeItems(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingSchemeItems() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingSchemeItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#addMeasurableCategories(MeasurableCategory)}
   */
  @Test
  void testBuilderAddMeasurableCategories() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    ImmutableMeasurableRatingsView.Builder actualAddMeasurableCategoriesResult = builderResult
        .addMeasurableCategories(mock(MeasurableCategory.class));

    // Assert
    assertEquals(1, builderResult.build().measurableCategories().size());
    assertSame(builderResult, actualAddMeasurableCategoriesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#addMeasurableCategories(MeasurableCategory[])}
   */
  @Test
  void testBuilderAddMeasurableCategories2() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    ImmutableMeasurableRatingsView.Builder actualAddMeasurableCategoriesResult = builderResult
        .addMeasurableCategories(mock(MeasurableCategory.class));

    // Assert
    assertEquals(1, builderResult.build().measurableCategories().size());
    assertSame(builderResult, actualAddMeasurableCategoriesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#addMeasurableHierarchy(MeasurableHierarchy)}
   */
  @Test
  void testBuilderAddMeasurableHierarchy() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    ImmutableMeasurableRatingsView.Builder actualAddMeasurableHierarchyResult = builderResult
        .addMeasurableHierarchy(mock(MeasurableHierarchy.class));

    // Assert
    assertEquals(1, builderResult.build().measurableHierarchy().size());
    assertSame(builderResult, actualAddMeasurableHierarchyResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#addMeasurableHierarchy(MeasurableHierarchy[])}
   */
  @Test
  void testBuilderAddMeasurableHierarchy2() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    ImmutableMeasurableRatingsView.Builder actualAddMeasurableHierarchyResult = builderResult
        .addMeasurableHierarchy(mock(MeasurableHierarchy.class));

    // Assert
    assertEquals(1, builderResult.build().measurableHierarchy().size());
    assertSame(builderResult, actualAddMeasurableHierarchyResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#addMeasurableRatings(MeasurableRating)}
   */
  @Test
  void testBuilderAddMeasurableRatings() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    ImmutableMeasurableRatingsView.Builder actualAddMeasurableRatingsResult = builderResult
        .addMeasurableRatings(mock(MeasurableRating.class));

    // Assert
    assertEquals(1, builderResult.build().measurableRatings().size());
    assertSame(builderResult, actualAddMeasurableRatingsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#addMeasurableRatings(MeasurableRating[])}
   */
  @Test
  void testBuilderAddMeasurableRatings2() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    ImmutableMeasurableRatingsView.Builder actualAddMeasurableRatingsResult = builderResult
        .addMeasurableRatings(mock(MeasurableRating.class));

    // Assert
    assertEquals(1, builderResult.build().measurableRatings().size());
    assertSame(builderResult, actualAddMeasurableRatingsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#addMeasurables(Measurable)}
   */
  @Test
  void testBuilderAddMeasurables() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    ImmutableMeasurableRatingsView.Builder actualAddMeasurablesResult = builderResult
        .addMeasurables(mock(Measurable.class));

    // Assert
    assertEquals(1, builderResult.build().measurables().size());
    assertSame(builderResult, actualAddMeasurablesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#addMeasurables(Measurable[])}
   */
  @Test
  void testBuilderAddMeasurables2() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    ImmutableMeasurableRatingsView.Builder actualAddMeasurablesResult = builderResult
        .addMeasurables(mock(Measurable.class));

    // Assert
    assertEquals(1, builderResult.build().measurables().size());
    assertSame(builderResult, actualAddMeasurablesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#addRatingSchemeItems(RatingSchemeItem)}
   */
  @Test
  void testBuilderAddRatingSchemeItems() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    ImmutableMeasurableRatingsView.Builder actualAddRatingSchemeItemsResult = builderResult
        .addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#addRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  void testBuilderAddRatingSchemeItems2() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    ImmutableMeasurableRatingsView.Builder actualAddRatingSchemeItemsResult = builderResult
        .addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRatingsView.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableMeasurableRatingsView.builder().build().measurableCategories().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#from(MeasurableRatingsView)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();
    MeasurableRatingsView instance = mock(MeasurableRatingsView.class);
    when(instance.measurableCategories()).thenReturn(new HashSet<>());
    when(instance.measurableHierarchy()).thenReturn(new HashSet<>());
    when(instance.measurableRatings()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableMeasurableRatingsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurableCategories();
    verify(instance).measurableHierarchy();
    verify(instance).measurableRatings();
    verify(instance).measurables();
    verify(instance).ratingSchemeItems();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#from(MeasurableRatingsView)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    HashSet<MeasurableCategory> measurableCategorySet = new HashSet<>();
    measurableCategorySet.add(mock(MeasurableCategory.class));
    MeasurableRatingsView instance = mock(MeasurableRatingsView.class);
    when(instance.measurableCategories()).thenReturn(measurableCategorySet);
    when(instance.measurableHierarchy()).thenReturn(new HashSet<>());
    when(instance.measurableRatings()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableMeasurableRatingsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurableCategories();
    verify(instance).measurableHierarchy();
    verify(instance).measurableRatings();
    verify(instance).measurables();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().measurableCategories().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#from(MeasurableRatingsView)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    HashSet<MeasurableHierarchy> measurableHierarchySet = new HashSet<>();
    measurableHierarchySet.add(mock(MeasurableHierarchy.class));
    MeasurableRatingsView instance = mock(MeasurableRatingsView.class);
    when(instance.measurableCategories()).thenReturn(new HashSet<>());
    when(instance.measurableHierarchy()).thenReturn(measurableHierarchySet);
    when(instance.measurableRatings()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableMeasurableRatingsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurableCategories();
    verify(instance).measurableHierarchy();
    verify(instance).measurableRatings();
    verify(instance).measurables();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().measurableHierarchy().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#from(MeasurableRatingsView)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    HashSet<MeasurableRating> measurableRatingSet = new HashSet<>();
    measurableRatingSet.add(mock(MeasurableRating.class));
    MeasurableRatingsView instance = mock(MeasurableRatingsView.class);
    when(instance.measurableCategories()).thenReturn(new HashSet<>());
    when(instance.measurableHierarchy()).thenReturn(new HashSet<>());
    when(instance.measurableRatings()).thenReturn(measurableRatingSet);
    when(instance.measurables()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableMeasurableRatingsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurableCategories();
    verify(instance).measurableHierarchy();
    verify(instance).measurableRatings();
    verify(instance).measurables();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().measurableRatings().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#from(MeasurableRatingsView)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    HashSet<Measurable> measurableSet = new HashSet<>();
    measurableSet.add(mock(Measurable.class));
    MeasurableRatingsView instance = mock(MeasurableRatingsView.class);
    when(instance.measurableCategories()).thenReturn(new HashSet<>());
    when(instance.measurableHierarchy()).thenReturn(new HashSet<>());
    when(instance.measurableRatings()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(measurableSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableMeasurableRatingsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurableCategories();
    verify(instance).measurableHierarchy();
    verify(instance).measurableRatings();
    verify(instance).measurables();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().measurables().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#from(MeasurableRatingsView)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(mock(RatingSchemeItem.class));
    MeasurableRatingsView instance = mock(MeasurableRatingsView.class);
    when(instance.measurableCategories()).thenReturn(new HashSet<>());
    when(instance.measurableHierarchy()).thenReturn(new HashSet<>());
    when(instance.measurableRatings()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(ratingSchemeItemSet);

    // Act
    ImmutableMeasurableRatingsView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurableCategories();
    verify(instance).measurableHierarchy();
    verify(instance).measurableRatings();
    verify(instance).measurables();
    verify(instance).ratingSchemeItems();
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#measurableCategories(Iterable)}
   */
  @Test
  void testBuilderMeasurableCategories() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableCategories(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#measurableHierarchy(Iterable)}
   */
  @Test
  void testBuilderMeasurableHierarchy() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableHierarchy(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#measurableRatings(Iterable)}
   */
  @Test
  void testBuilderMeasurableRatings() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#measurables(Iterable)}
   */
  @Test
  void testBuilderMeasurables() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurables(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Builder#ratingSchemeItems(Iterable)}
   */
  @Test
  void testBuilderRatingSchemeItems() {
    // Arrange
    ImmutableMeasurableRatingsView.Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView#copyOf(MeasurableRatingsView)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableRatingsView instance = mock(MeasurableRatingsView.class);
    when(instance.measurableCategories()).thenReturn(new HashSet<>());
    when(instance.measurableHierarchy()).thenReturn(new HashSet<>());
    when(instance.measurableRatings()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableMeasurableRatingsView actualCopyOfResult = ImmutableMeasurableRatingsView.copyOf(instance);

    // Assert
    verify(instance).measurableCategories();
    verify(instance).measurableHierarchy();
    verify(instance).measurableRatings();
    verify(instance).measurables();
    verify(instance).ratingSchemeItems();
    Set<MeasurableCategory> measurableCategoriesResult = actualCopyOfResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurableRatings());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurables());
    assertSame(measurableCategoriesResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView#copyOf(MeasurableRatingsView)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<MeasurableCategory> measurableCategorySet = new HashSet<>();
    measurableCategorySet.add(mock(MeasurableCategory.class));
    MeasurableRatingsView instance = mock(MeasurableRatingsView.class);
    when(instance.measurableCategories()).thenReturn(measurableCategorySet);
    when(instance.measurableHierarchy()).thenReturn(new HashSet<>());
    when(instance.measurableRatings()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableMeasurableRatingsView actualCopyOfResult = ImmutableMeasurableRatingsView.copyOf(instance);

    // Assert
    verify(instance).measurableCategories();
    verify(instance).measurableHierarchy();
    verify(instance).measurableRatings();
    verify(instance).measurables();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.measurableCategories().size());
    Set<MeasurableHierarchy> measurableHierarchyResult = actualCopyOfResult.measurableHierarchy();
    assertTrue(measurableHierarchyResult.isEmpty());
    assertSame(measurableHierarchyResult, actualCopyOfResult.measurableRatings());
    assertSame(measurableHierarchyResult, actualCopyOfResult.measurables());
    assertSame(measurableHierarchyResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView#copyOf(MeasurableRatingsView)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<MeasurableCategory> measurableCategorySet = new HashSet<>();
    measurableCategorySet.add(mock(MeasurableCategory.class));
    measurableCategorySet.add(mock(MeasurableCategory.class));
    MeasurableRatingsView instance = mock(MeasurableRatingsView.class);
    when(instance.measurableCategories()).thenReturn(measurableCategorySet);
    when(instance.measurableHierarchy()).thenReturn(new HashSet<>());
    when(instance.measurableRatings()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableMeasurableRatingsView actualCopyOfResult = ImmutableMeasurableRatingsView.copyOf(instance);

    // Assert
    verify(instance).measurableCategories();
    verify(instance).measurableHierarchy();
    verify(instance).measurableRatings();
    verify(instance).measurables();
    verify(instance).ratingSchemeItems();
    Set<MeasurableHierarchy> measurableHierarchyResult = actualCopyOfResult.measurableHierarchy();
    assertTrue(measurableHierarchyResult.isEmpty());
    assertEquals(measurableCategorySet, actualCopyOfResult.measurableCategories());
    assertSame(measurableHierarchyResult, actualCopyOfResult.measurableRatings());
    assertSame(measurableHierarchyResult, actualCopyOfResult.measurables());
    assertSame(measurableHierarchyResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView#copyOf(MeasurableRatingsView)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<MeasurableHierarchy> measurableHierarchySet = new HashSet<>();
    measurableHierarchySet.add(mock(MeasurableHierarchy.class));
    MeasurableRatingsView instance = mock(MeasurableRatingsView.class);
    when(instance.measurableCategories()).thenReturn(new HashSet<>());
    when(instance.measurableHierarchy()).thenReturn(measurableHierarchySet);
    when(instance.measurableRatings()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableMeasurableRatingsView actualCopyOfResult = ImmutableMeasurableRatingsView.copyOf(instance);

    // Assert
    verify(instance).measurableCategories();
    verify(instance).measurableHierarchy();
    verify(instance).measurableRatings();
    verify(instance).measurables();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.measurableHierarchy().size());
    Set<MeasurableCategory> measurableCategoriesResult = actualCopyOfResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurableRatings());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurables());
    assertSame(measurableCategoriesResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView#copyOf(MeasurableRatingsView)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<MeasurableRating> measurableRatingSet = new HashSet<>();
    measurableRatingSet.add(mock(MeasurableRating.class));
    MeasurableRatingsView instance = mock(MeasurableRatingsView.class);
    when(instance.measurableCategories()).thenReturn(new HashSet<>());
    when(instance.measurableHierarchy()).thenReturn(new HashSet<>());
    when(instance.measurableRatings()).thenReturn(measurableRatingSet);
    when(instance.measurables()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableMeasurableRatingsView actualCopyOfResult = ImmutableMeasurableRatingsView.copyOf(instance);

    // Assert
    verify(instance).measurableCategories();
    verify(instance).measurableHierarchy();
    verify(instance).measurableRatings();
    verify(instance).measurables();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.measurableRatings().size());
    Set<MeasurableCategory> measurableCategoriesResult = actualCopyOfResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurables());
    assertSame(measurableCategoriesResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView#copyOf(MeasurableRatingsView)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    HashSet<Measurable> measurableSet = new HashSet<>();
    measurableSet.add(mock(Measurable.class));
    MeasurableRatingsView instance = mock(MeasurableRatingsView.class);
    when(instance.measurableCategories()).thenReturn(new HashSet<>());
    when(instance.measurableHierarchy()).thenReturn(new HashSet<>());
    when(instance.measurableRatings()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(measurableSet);
    when(instance.ratingSchemeItems()).thenReturn(new HashSet<>());

    // Act
    ImmutableMeasurableRatingsView actualCopyOfResult = ImmutableMeasurableRatingsView.copyOf(instance);

    // Assert
    verify(instance).measurableCategories();
    verify(instance).measurableHierarchy();
    verify(instance).measurableRatings();
    verify(instance).measurables();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.measurables().size());
    Set<MeasurableCategory> measurableCategoriesResult = actualCopyOfResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurableRatings());
    assertSame(measurableCategoriesResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView#copyOf(MeasurableRatingsView)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(mock(RatingSchemeItem.class));
    MeasurableRatingsView instance = mock(MeasurableRatingsView.class);
    when(instance.measurableCategories()).thenReturn(new HashSet<>());
    when(instance.measurableHierarchy()).thenReturn(new HashSet<>());
    when(instance.measurableRatings()).thenReturn(new HashSet<>());
    when(instance.measurables()).thenReturn(new HashSet<>());
    when(instance.ratingSchemeItems()).thenReturn(ratingSchemeItemSet);

    // Act
    ImmutableMeasurableRatingsView actualCopyOfResult = ImmutableMeasurableRatingsView.copyOf(instance);

    // Assert
    verify(instance).measurableCategories();
    verify(instance).measurableHierarchy();
    verify(instance).measurableRatings();
    verify(instance).measurables();
    verify(instance).ratingSchemeItems();
    assertEquals(1, actualCopyOfResult.ratingSchemeItems().size());
    Set<MeasurableCategory> measurableCategoriesResult = actualCopyOfResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurableRatings());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurables());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView#fromJson(ImmutableMeasurableRatingsView.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableMeasurableRatingsView.Json json = new ImmutableMeasurableRatingsView.Json();

    // Act
    ImmutableMeasurableRatingsView actualFromJsonResult = ImmutableMeasurableRatingsView.fromJson(json);

    // Assert
    Set<MeasurableCategory> measurableCategoriesResult = actualFromJsonResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, measurableCategoriesResult);
    assertSame(ratingSchemeItemSet, actualFromJsonResult.measurableHierarchy());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.measurableRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.measurables());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView#fromJson(ImmutableMeasurableRatingsView.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableMeasurableRatingsView.Json json = new ImmutableMeasurableRatingsView.Json();
    json.setMeasurableCategories(null);
    json.setMeasurables(null);
    json.setMeasurableRatings(null);
    json.setRatingSchemeItems(null);
    json.setMeasurableHierarchy(null);

    // Act
    ImmutableMeasurableRatingsView actualFromJsonResult = ImmutableMeasurableRatingsView.fromJson(json);

    // Assert
    Set<MeasurableCategory> measurableCategoriesResult = actualFromJsonResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualFromJsonResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualFromJsonResult.measurableRatings());
    assertSame(measurableCategoriesResult, actualFromJsonResult.measurables());
    assertSame(measurableCategoriesResult, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView#fromJson(ImmutableMeasurableRatingsView.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<MeasurableHierarchy> measurableHierarchy = new LinkedHashSet<>();
    measurableHierarchy.add(mock(MeasurableHierarchy.class));

    ImmutableMeasurableRatingsView.Json json = new ImmutableMeasurableRatingsView.Json();
    json.setMeasurableCategories(null);
    json.setMeasurables(null);
    json.setMeasurableRatings(null);
    json.setRatingSchemeItems(null);
    json.setMeasurableHierarchy(measurableHierarchy);

    // Act
    ImmutableMeasurableRatingsView actualFromJsonResult = ImmutableMeasurableRatingsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.measurableHierarchy().size());
    Set<MeasurableCategory> measurableCategoriesResult = actualFromJsonResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualFromJsonResult.measurableRatings());
    assertSame(measurableCategoriesResult, actualFromJsonResult.measurables());
    assertSame(measurableCategoriesResult, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView#fromJson(ImmutableMeasurableRatingsView.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(mock(RatingSchemeItem.class));

    ImmutableMeasurableRatingsView.Json json = new ImmutableMeasurableRatingsView.Json();
    json.setMeasurableCategories(null);
    json.setMeasurables(null);
    json.setMeasurableRatings(null);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setMeasurableHierarchy(null);

    // Act
    ImmutableMeasurableRatingsView actualFromJsonResult = ImmutableMeasurableRatingsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.ratingSchemeItems().size());
    Set<MeasurableCategory> measurableCategoriesResult = actualFromJsonResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualFromJsonResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualFromJsonResult.measurableRatings());
    assertSame(measurableCategoriesResult, actualFromJsonResult.measurables());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView#fromJson(ImmutableMeasurableRatingsView.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    LinkedHashSet<MeasurableRating> measurableRatings = new LinkedHashSet<>();
    measurableRatings.add(mock(MeasurableRating.class));

    ImmutableMeasurableRatingsView.Json json = new ImmutableMeasurableRatingsView.Json();
    json.setMeasurableCategories(null);
    json.setMeasurables(null);
    json.setMeasurableRatings(measurableRatings);
    json.setRatingSchemeItems(null);
    json.setMeasurableHierarchy(null);

    // Act
    ImmutableMeasurableRatingsView actualFromJsonResult = ImmutableMeasurableRatingsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.measurableRatings().size());
    Set<MeasurableCategory> measurableCategoriesResult = actualFromJsonResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualFromJsonResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualFromJsonResult.measurables());
    assertSame(measurableCategoriesResult, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Json#measurableCategories()}
   */
  @Test
  void testJsonMeasurableCategories() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingsView.Json()).measurableCategories());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Json#measurableHierarchy()}
   */
  @Test
  void testJsonMeasurableHierarchy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingsView.Json()).measurableHierarchy());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Json#measurableRatings()}
   */
  @Test
  void testJsonMeasurableRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingsView.Json()).measurableRatings());
  }

  /**
   * Method under test: {@link ImmutableMeasurableRatingsView.Json#measurables()}
   */
  @Test
  void testJsonMeasurables() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRatingsView.Json()).measurables());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableMeasurableRatingsView.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableMeasurableRatingsView.Json actualJson = new ImmutableMeasurableRatingsView.Json();

    // Assert
    assertTrue(actualJson.measurableCategories.isEmpty());
    assertTrue(actualJson.measurableHierarchy.isEmpty());
    assertTrue(actualJson.measurableRatings.isEmpty());
    assertTrue(actualJson.measurables.isEmpty());
    assertTrue(actualJson.ratingSchemeItems.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingsView.Json#ratingSchemeItems()}
   */
  @Test
  void testJsonRatingSchemeItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingsView.Json()).ratingSchemeItems());
  }
}
