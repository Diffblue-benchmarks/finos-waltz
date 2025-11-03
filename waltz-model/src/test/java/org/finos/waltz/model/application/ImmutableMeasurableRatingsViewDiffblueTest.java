package org.finos.waltz.model.application;

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
import org.finos.waltz.model.application.ImmutableMeasurableRatingsView.Builder;
import org.finos.waltz.model.application.ImmutableMeasurableRatingsView.Json;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable.MeasurableHierarchy;
import org.finos.waltz.model.measurable_category.MeasurableCategory;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingsViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllMeasurableCategories(Iterable)}.
   * <ul>
   *   <li>Then return build measurableCategories Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllMeasurableCategories(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllMeasurableCategories(Iterable); then return build measurableCategories Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllMeasurableCategories(Iterable)"})
  void testBuilderAddAllMeasurableCategories_thenReturnBuildMeasurableCategoriesEmpty() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act and Assert
    ImmutableMeasurableRatingsView buildResult = builderResult.addAllMeasurableCategories(new ArrayList<>()).build();
    Set<MeasurableCategory> measurableCategoriesResult = buildResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, buildResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, buildResult.measurableRatings());
    assertSame(measurableCategoriesResult, buildResult.measurables());
    assertSame(measurableCategoriesResult, buildResult.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#addMeasurableCategories(MeasurableCategory)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addMeasurableCategories(MeasurableCategory)}
   */
  @Test
  @DisplayName("Test Builder addMeasurableCategories(MeasurableCategory) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMeasurableCategories(MeasurableCategory)"})
  void testBuilderAddMeasurableCategoriesWithElement() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddMeasurableCategoriesResult = builderResult.addMeasurableCategories(mock(MeasurableCategory.class));

    // Assert
    assertEquals(1, builderResult.build().measurableCategories().size());
    assertSame(builderResult, actualAddMeasurableCategoriesResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurableCategories(MeasurableCategory[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addMeasurableCategories(MeasurableCategory[])}
   */
  @Test
  @DisplayName("Test Builder addMeasurableCategories(MeasurableCategory[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMeasurableCategories(MeasurableCategory[])"})
  void testBuilderAddMeasurableCategoriesWithElements() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddMeasurableCategoriesResult = builderResult.addMeasurableCategories(mock(MeasurableCategory.class));

    // Assert
    assertEquals(1, builderResult.build().measurableCategories().size());
    assertSame(builderResult, actualAddMeasurableCategoriesResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurableHierarchy(MeasurableHierarchy)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addMeasurableHierarchy(MeasurableHierarchy)}
   */
  @Test
  @DisplayName("Test Builder addMeasurableHierarchy(MeasurableHierarchy) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMeasurableHierarchy(MeasurableHierarchy)"})
  void testBuilderAddMeasurableHierarchyWithElement() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddMeasurableHierarchyResult = builderResult.addMeasurableHierarchy(mock(MeasurableHierarchy.class));

    // Assert
    assertEquals(1, builderResult.build().measurableHierarchy().size());
    assertSame(builderResult, actualAddMeasurableHierarchyResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurableHierarchy(MeasurableHierarchy[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addMeasurableHierarchy(MeasurableHierarchy[])}
   */
  @Test
  @DisplayName("Test Builder addMeasurableHierarchy(MeasurableHierarchy[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMeasurableHierarchy(MeasurableHierarchy[])"})
  void testBuilderAddMeasurableHierarchyWithElements() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddMeasurableHierarchyResult = builderResult.addMeasurableHierarchy(mock(MeasurableHierarchy.class));

    // Assert
    assertEquals(1, builderResult.build().measurableHierarchy().size());
    assertSame(builderResult, actualAddMeasurableHierarchyResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurableRatings(MeasurableRating)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addMeasurableRatings(MeasurableRating)}
   */
  @Test
  @DisplayName("Test Builder addMeasurableRatings(MeasurableRating) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMeasurableRatings(MeasurableRating)"})
  void testBuilderAddMeasurableRatingsWithElement() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddMeasurableRatingsResult = builderResult.addMeasurableRatings(mock(MeasurableRating.class));

    // Assert
    assertEquals(1, builderResult.build().measurableRatings().size());
    assertSame(builderResult, actualAddMeasurableRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurableRatings(MeasurableRating[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addMeasurableRatings(MeasurableRating[])}
   */
  @Test
  @DisplayName("Test Builder addMeasurableRatings(MeasurableRating[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMeasurableRatings(MeasurableRating[])"})
  void testBuilderAddMeasurableRatingsWithElements() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddMeasurableRatingsResult = builderResult.addMeasurableRatings(mock(MeasurableRating.class));

    // Assert
    assertEquals(1, builderResult.build().measurableRatings().size());
    assertSame(builderResult, actualAddMeasurableRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurables(Measurable)} with {@code element}.
   * <ul>
   *   <li>Then builder build measurables size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addMeasurables(Measurable)}
   */
  @Test
  @DisplayName("Test Builder addMeasurables(Measurable) with 'element'; then builder build measurables size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMeasurables(Measurable)"})
  void testBuilderAddMeasurablesWithElement_thenBuilderBuildMeasurablesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddMeasurablesResult = builderResult.addMeasurables(mock(Measurable.class));

    // Assert
    assertEquals(1, builderResult.build().measurables().size());
    assertSame(builderResult, actualAddMeasurablesResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurables(Measurable[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build measurables size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addMeasurables(Measurable[])}
   */
  @Test
  @DisplayName("Test Builder addMeasurables(Measurable[]) with 'elements'; then builder build measurables size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMeasurables(Measurable[])"})
  void testBuilderAddMeasurablesWithElements_thenBuilderBuildMeasurablesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddMeasurablesResult = builderResult.addMeasurables(mock(Measurable.class));

    // Assert
    assertEquals(1, builderResult.build().measurables().size());
    assertSame(builderResult, actualAddMeasurablesResult);
  }

  /**
   * Test Builder {@link Builder#addRatingSchemeItems(RatingSchemeItem)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addRatingSchemeItems(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder addRatingSchemeItems(RatingSchemeItem) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingSchemeItems(RatingSchemeItem)"})
  void testBuilderAddRatingSchemeItemsWithElement() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult = builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingSchemeItems(RatingSchemeItem[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test Builder addRatingSchemeItems(RatingSchemeItem[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingSchemeItems(RatingSchemeItem[])"})
  void testBuilderAddRatingSchemeItemsWithElements() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act
    Builder actualAddRatingSchemeItemsResult = builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, builderResult.build().ratingSchemeItems().size());
    assertSame(builderResult, actualAddRatingSchemeItemsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableMeasurableRatingsView Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableMeasurableRatingsView.builder().build().measurableCategories().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingsView)}.
   * <ul>
   *   <li>Then return build measurableHierarchy size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingsView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingsView); then return build measurableHierarchy size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingsView)"})
  void testBuilderFrom_thenReturnBuildMeasurableHierarchySizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();
    Builder builderResult2 = ImmutableMeasurableRatingsView.builder();
    builderResult2.addMeasurableHierarchy(mock(MeasurableHierarchy.class));
    builderResult2.addMeasurableCategories(mock(MeasurableCategory.class));
    ImmutableMeasurableRatingsView instance = builderResult2.build();

    // Act and Assert
    ImmutableMeasurableRatingsView buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.measurableHierarchy().size());
    Set<MeasurableRating> measurableRatingsResult = buildResult.measurableRatings();
    assertTrue(measurableRatingsResult.isEmpty());
    assertSame(measurableRatingsResult, buildResult.measurables());
    assertSame(measurableRatingsResult, buildResult.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingsView)}.
   * <ul>
   *   <li>Then return build measurableRatings is build measurableHierarchy.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingsView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingsView); then return build measurableRatings is build measurableHierarchy")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingsView)"})
  void testBuilderFrom_thenReturnBuildMeasurableRatingsIsBuildMeasurableHierarchy() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();
    Builder builderResult2 = ImmutableMeasurableRatingsView.builder();
    builderResult2.addMeasurableCategories(mock(MeasurableCategory.class));
    ImmutableMeasurableRatingsView instance = builderResult2.build();

    // Act and Assert
    ImmutableMeasurableRatingsView buildResult = builderResult.from(instance).build();
    Set<MeasurableHierarchy> measurableHierarchyResult = buildResult.measurableHierarchy();
    assertTrue(measurableHierarchyResult.isEmpty());
    assertSame(measurableHierarchyResult, buildResult.measurableRatings());
    assertSame(measurableHierarchyResult, buildResult.measurables());
    assertSame(measurableHierarchyResult, buildResult.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingsView)}.
   * <ul>
   *   <li>Then return build measurableRatings size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingsView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingsView); then return build measurableRatings size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingsView)"})
  void testBuilderFrom_thenReturnBuildMeasurableRatingsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();
    Builder builderResult2 = ImmutableMeasurableRatingsView.builder();
    builderResult2.addMeasurableRatings(mock(MeasurableRating.class));
    builderResult2.addMeasurableCategories(mock(MeasurableCategory.class));
    ImmutableMeasurableRatingsView instance = builderResult2.build();

    // Act and Assert
    ImmutableMeasurableRatingsView buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.measurableRatings().size());
    Set<MeasurableHierarchy> measurableHierarchyResult = buildResult.measurableHierarchy();
    assertTrue(measurableHierarchyResult.isEmpty());
    assertSame(measurableHierarchyResult, buildResult.measurables());
    assertSame(measurableHierarchyResult, buildResult.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingsView)}.
   * <ul>
   *   <li>Then return build measurables size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingsView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingsView); then return build measurables size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingsView)"})
  void testBuilderFrom_thenReturnBuildMeasurablesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();
    Builder builderResult2 = ImmutableMeasurableRatingsView.builder();
    builderResult2.addMeasurables(mock(Measurable.class));
    builderResult2.addMeasurableCategories(mock(MeasurableCategory.class));
    ImmutableMeasurableRatingsView instance = builderResult2.build();

    // Act and Assert
    ImmutableMeasurableRatingsView buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.measurables().size());
    Set<MeasurableHierarchy> measurableHierarchyResult = buildResult.measurableHierarchy();
    assertTrue(measurableHierarchyResult.isEmpty());
    assertSame(measurableHierarchyResult, buildResult.measurableRatings());
    assertSame(measurableHierarchyResult, buildResult.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingsView)}.
   * <ul>
   *   <li>Then return build ratingSchemeItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingsView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingsView); then return build ratingSchemeItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingsView)"})
  void testBuilderFrom_thenReturnBuildRatingSchemeItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();
    Builder builderResult2 = ImmutableMeasurableRatingsView.builder();
    builderResult2.addRatingSchemeItems(mock(RatingSchemeItem.class));
    builderResult2.addMeasurableCategories(mock(MeasurableCategory.class));
    ImmutableMeasurableRatingsView instance = builderResult2.build();

    // Act and Assert
    ImmutableMeasurableRatingsView buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.ratingSchemeItems().size());
    Set<MeasurableHierarchy> measurableHierarchyResult = buildResult.measurableHierarchy();
    assertTrue(measurableHierarchyResult.isEmpty());
    assertSame(measurableHierarchyResult, buildResult.measurableRatings());
    assertSame(measurableHierarchyResult, buildResult.measurables());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingsView)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return build measurableCategories Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingsView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingsView); when builder build; then return build measurableCategories Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingsView)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildMeasurableCategoriesEmpty() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();
    ImmutableMeasurableRatingsView instance = ImmutableMeasurableRatingsView.builder().build();

    // Act and Assert
    ImmutableMeasurableRatingsView buildResult = builderResult.from(instance).build();
    Set<MeasurableCategory> measurableCategoriesResult = buildResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, buildResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, buildResult.measurableRatings());
    assertSame(measurableCategoriesResult, buildResult.measurables());
    assertSame(measurableCategoriesResult, buildResult.ratingSchemeItems());
  }

  /**
   * Test Builder {@link Builder#measurableCategories(Iterable)}.
   * <ul>
   *   <li>Then return build measurableCategories Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#measurableCategories(Iterable)}
   */
  @Test
  @DisplayName("Test Builder measurableCategories(Iterable); then return build measurableCategories Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableCategories(Iterable)"})
  void testBuilderMeasurableCategories_thenReturnBuildMeasurableCategoriesEmpty() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();

    // Act and Assert
    ImmutableMeasurableRatingsView buildResult = builderResult.measurableCategories(new ArrayList<>()).build();
    Set<MeasurableCategory> measurableCategoriesResult = buildResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, buildResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, buildResult.measurableRatings());
    assertSame(measurableCategoriesResult, buildResult.measurables());
    assertSame(measurableCategoriesResult, buildResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#copyOf(MeasurableRatingsView)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return measurableCategories Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#copyOf(MeasurableRatingsView)}
   */
  @Test
  @DisplayName("Test copyOf(MeasurableRatingsView); when builder build; then return measurableCategories Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.copyOf(MeasurableRatingsView)"})
  void testCopyOf_whenBuilderBuild_thenReturnMeasurableCategoriesEmpty() {
    // Arrange
    ImmutableMeasurableRatingsView instance = ImmutableMeasurableRatingsView.builder().build();

    // Act
    ImmutableMeasurableRatingsView actualCopyOfResult = ImmutableMeasurableRatingsView.copyOf(instance);

    // Assert
    Set<MeasurableCategory> measurableCategoriesResult = actualCopyOfResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurableRatings());
    assertSame(measurableCategoriesResult, actualCopyOfResult.measurables());
    assertSame(measurableCategoriesResult, actualCopyOfResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}, and {@link ImmutableMeasurableRatingsView#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingsView#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableMeasurableRatingsView.equals(Object)",
      "int ImmutableMeasurableRatingsView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRatingsView buildResult = ImmutableMeasurableRatingsView.builder().build();
    ImmutableMeasurableRatingsView buildResult2 = ImmutableMeasurableRatingsView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}, and {@link ImmutableMeasurableRatingsView#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingsView#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableMeasurableRatingsView.equals(Object)",
      "int ImmutableMeasurableRatingsView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRatingsView buildResult = ImmutableMeasurableRatingsView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableMeasurableRatingsView.equals(Object)",
      "int ImmutableMeasurableRatingsView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();
    builderResult.addMeasurableCategories(mock(MeasurableCategory.class));
    ImmutableMeasurableRatingsView buildResult = builderResult.build();
    ImmutableMeasurableRatingsView buildResult2 = ImmutableMeasurableRatingsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableMeasurableRatingsView.equals(Object)",
      "int ImmutableMeasurableRatingsView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();
    builderResult.addMeasurables(mock(Measurable.class));
    ImmutableMeasurableRatingsView buildResult = builderResult.build();
    ImmutableMeasurableRatingsView buildResult2 = ImmutableMeasurableRatingsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableMeasurableRatingsView.equals(Object)",
      "int ImmutableMeasurableRatingsView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();
    builderResult.addMeasurableRatings(mock(MeasurableRating.class));
    ImmutableMeasurableRatingsView buildResult = builderResult.build();
    ImmutableMeasurableRatingsView buildResult2 = ImmutableMeasurableRatingsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableMeasurableRatingsView.equals(Object)",
      "int ImmutableMeasurableRatingsView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();
    builderResult.addRatingSchemeItems(mock(RatingSchemeItem.class));
    ImmutableMeasurableRatingsView buildResult = builderResult.build();
    ImmutableMeasurableRatingsView buildResult2 = ImmutableMeasurableRatingsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableMeasurableRatingsView.equals(Object)",
      "int ImmutableMeasurableRatingsView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingsView.builder();
    builderResult.addMeasurableHierarchy(mock(MeasurableHierarchy.class));
    ImmutableMeasurableRatingsView buildResult = builderResult.build();
    ImmutableMeasurableRatingsView buildResult2 = ImmutableMeasurableRatingsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableMeasurableRatingsView.equals(Object)",
      "int ImmutableMeasurableRatingsView.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableMeasurableRatingsView buildResult = ImmutableMeasurableRatingsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableMeasurableRatingsView.equals(Object)",
      "int ImmutableMeasurableRatingsView.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableMeasurableRatingsView buildResult = ImmutableMeasurableRatingsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableMeasurableRatingsView");
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#fromJson(Json)}.
   * <ul>
   *   <li>Then return measurableHierarchy size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return measurableHierarchy size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.fromJson(Json)"})
  void testFromJson_thenReturnMeasurableHierarchySizeIsOne() {
    // Arrange
    LinkedHashSet<MeasurableHierarchy> measurableHierarchy = new LinkedHashSet<>();
    measurableHierarchy.add(mock(MeasurableHierarchy.class));

    Json json = new Json();
    json.setMeasurableCategories(null);
    json.setMeasurables(null);
    json.setMeasurableRatings(null);
    json.setRatingSchemeItems(null);
    json.setMeasurableHierarchy(measurableHierarchy);

    // Act and Assert
    assertEquals(1, ImmutableMeasurableRatingsView.fromJson(json).measurableHierarchy().size());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#fromJson(Json)}.
   * <ul>
   *   <li>Then return measurableRatings size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return measurableRatings size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.fromJson(Json)"})
  void testFromJson_thenReturnMeasurableRatingsSizeIsOne() {
    // Arrange
    LinkedHashSet<MeasurableRating> measurableRatings = new LinkedHashSet<>();
    measurableRatings.add(mock(MeasurableRating.class));

    Json json = new Json();
    json.setMeasurableCategories(null);
    json.setMeasurables(null);
    json.setMeasurableRatings(measurableRatings);
    json.setRatingSchemeItems(null);
    json.setMeasurableHierarchy(null);

    // Act and Assert
    assertEquals(1, ImmutableMeasurableRatingsView.fromJson(json).measurableRatings().size());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#fromJson(Json)}.
   * <ul>
   *   <li>Then return ratingSchemeItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ratingSchemeItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.fromJson(Json)"})
  void testFromJson_thenReturnRatingSchemeItemsSizeIsOne() {
    // Arrange
    LinkedHashSet<RatingSchemeItem> ratingSchemeItems = new LinkedHashSet<>();
    ratingSchemeItems.add(mock(RatingSchemeItem.class));

    Json json = new Json();
    json.setMeasurableCategories(null);
    json.setMeasurables(null);
    json.setMeasurableRatings(null);
    json.setRatingSchemeItems(ratingSchemeItems);
    json.setMeasurableHierarchy(null);

    // Act and Assert
    assertEquals(1, ImmutableMeasurableRatingsView.fromJson(json).ratingSchemeItems().size());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor) MeasurableRatings is {@code null}.</li>
   *   <li>Then return measurableCategories Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor) MeasurableRatings is 'null'; then return measurableCategories Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.fromJson(Json)"})
  void testFromJson_whenJsonMeasurableRatingsIsNull_thenReturnMeasurableCategoriesEmpty() {
    // Arrange
    Json json = new Json();
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
   * Test {@link ImmutableMeasurableRatingsView#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return measurableHierarchy is {@link Json} (default constructor) {@link Json#ratingSchemeItems}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return measurableHierarchy is Json (default constructor) ratingSchemeItems")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnMeasurableHierarchyIsJsonRatingSchemeItems() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableMeasurableRatingsView actualFromJsonResult = ImmutableMeasurableRatingsView.fromJson(json);

    // Assert
    Set<RatingSchemeItem> ratingSchemeItemSet = json.ratingSchemeItems;
    assertSame(ratingSchemeItemSet, actualFromJsonResult.measurableHierarchy());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.measurableRatings());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.measurables());
    assertSame(ratingSchemeItemSet, actualFromJsonResult.ratingSchemeItems());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingsView#toString()}
   *   <li>{@link ImmutableMeasurableRatingsView#measurableCategories()}
   *   <li>{@link ImmutableMeasurableRatingsView#measurableHierarchy()}
   *   <li>{@link ImmutableMeasurableRatingsView#measurableRatings()}
   *   <li>{@link ImmutableMeasurableRatingsView#measurables()}
   *   <li>{@link ImmutableMeasurableRatingsView#ratingSchemeItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableMeasurableRatingsView.measurableCategories()",
      "Set ImmutableMeasurableRatingsView.measurableHierarchy()",
      "Set ImmutableMeasurableRatingsView.measurableRatings()", "Set ImmutableMeasurableRatingsView.measurables()",
      "Set ImmutableMeasurableRatingsView.ratingSchemeItems()", "String ImmutableMeasurableRatingsView.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableMeasurableRatingsView buildResult = ImmutableMeasurableRatingsView.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    Set<MeasurableCategory> actualMeasurableCategoriesResult = buildResult.measurableCategories();
    Set<MeasurableHierarchy> actualMeasurableHierarchyResult = buildResult.measurableHierarchy();
    Set<MeasurableRating> actualMeasurableRatingsResult = buildResult.measurableRatings();
    Set<Measurable> actualMeasurablesResult = buildResult.measurables();
    Set<RatingSchemeItem> actualRatingSchemeItemsResult = buildResult.ratingSchemeItems();

    // Assert
    assertEquals(
        "MeasurableRatingsView{measurableCategories=[], measurables=[], measurableRatings=[], ratingSchemeItems=[],"
            + " measurableHierarchy=[]}",
        actualToStringResult);
    assertTrue(actualMeasurableCategoriesResult.isEmpty());
    assertSame(actualMeasurableCategoriesResult, actualMeasurableHierarchyResult);
    assertSame(actualMeasurableCategoriesResult, actualMeasurableRatingsResult);
    assertSame(actualMeasurableCategoriesResult, actualMeasurablesResult);
    assertSame(actualMeasurableCategoriesResult, actualRatingSchemeItemsResult);
  }

  /**
   * Test Json {@link Json#measurableCategories()}.
   * <p>
   * Method under test: {@link Json#measurableCategories()}
   */
  @Test
  @DisplayName("Test Json measurableCategories()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.measurableCategories()"})
  void testJsonMeasurableCategories() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableCategories());
  }

  /**
   * Test Json {@link Json#measurableHierarchy()}.
   * <p>
   * Method under test: {@link Json#measurableHierarchy()}
   */
  @Test
  @DisplayName("Test Json measurableHierarchy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.measurableHierarchy()"})
  void testJsonMeasurableHierarchy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableHierarchy());
  }

  /**
   * Test Json {@link Json#measurableRatings()}.
   * <p>
   * Method under test: {@link Json#measurableRatings()}
   */
  @Test
  @DisplayName("Test Json measurableRatings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.measurableRatings()"})
  void testJsonMeasurableRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableRatings());
  }

  /**
   * Test Json {@link Json#measurables()}.
   * <p>
   * Method under test: {@link Json#measurables()}
   */
  @Test
  @DisplayName("Test Json measurables()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.measurables()"})
  void testJsonMeasurables() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurables());
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
    assertTrue(actualJson.measurableCategories.isEmpty());
    assertTrue(actualJson.measurableHierarchy.isEmpty());
    assertTrue(actualJson.measurableRatings.isEmpty());
    assertTrue(actualJson.measurables.isEmpty());
    assertTrue(actualJson.ratingSchemeItems.isEmpty());
  }

  /**
   * Test Json {@link Json#ratingSchemeItems()}.
   * <p>
   * Method under test: {@link Json#ratingSchemeItems()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeItems()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.ratingSchemeItems()"})
  void testJsonRatingSchemeItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#withMeasurableCategories(MeasurableCategory[])} with {@code MeasurableCategory[]}.
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#withMeasurableCategories(MeasurableCategory[])}
   */
  @Test
  @DisplayName("Test withMeasurableCategories(MeasurableCategory[]) with 'MeasurableCategory[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.withMeasurableCategories(MeasurableCategory[])"})
  void testWithMeasurableCategoriesWithMeasurableCategory() {
    // Arrange
    ImmutableMeasurableRatingsView buildResult = ImmutableMeasurableRatingsView.builder().build();

    // Act
    ImmutableMeasurableRatingsView actualWithMeasurableCategoriesResult = buildResult
        .withMeasurableCategories(mock(MeasurableCategory.class));

    // Assert
    assertEquals(1, actualWithMeasurableCategoriesResult.measurableCategories().size());
    Set<MeasurableHierarchy> measurableHierarchyResult = actualWithMeasurableCategoriesResult.measurableHierarchy();
    assertTrue(measurableHierarchyResult.isEmpty());
    assertSame(measurableHierarchyResult, actualWithMeasurableCategoriesResult.measurableRatings());
    assertSame(measurableHierarchyResult, actualWithMeasurableCategoriesResult.measurables());
    assertSame(measurableHierarchyResult, actualWithMeasurableCategoriesResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#withMeasurableHierarchy(MeasurableHierarchy[])} with {@code MeasurableHierarchy[]}.
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#withMeasurableHierarchy(MeasurableHierarchy[])}
   */
  @Test
  @DisplayName("Test withMeasurableHierarchy(MeasurableHierarchy[]) with 'MeasurableHierarchy[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.withMeasurableHierarchy(MeasurableHierarchy[])"})
  void testWithMeasurableHierarchyWithMeasurableHierarchy() {
    // Arrange
    ImmutableMeasurableRatingsView buildResult = ImmutableMeasurableRatingsView.builder().build();

    // Act
    ImmutableMeasurableRatingsView actualWithMeasurableHierarchyResult = buildResult
        .withMeasurableHierarchy(mock(MeasurableHierarchy.class));

    // Assert
    assertEquals(1, actualWithMeasurableHierarchyResult.measurableHierarchy().size());
    Set<MeasurableCategory> measurableCategoriesResult = actualWithMeasurableHierarchyResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualWithMeasurableHierarchyResult.measurableRatings());
    assertSame(measurableCategoriesResult, actualWithMeasurableHierarchyResult.measurables());
    assertSame(measurableCategoriesResult, actualWithMeasurableHierarchyResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#withMeasurableRatings(MeasurableRating[])} with {@code MeasurableRating[]}.
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#withMeasurableRatings(MeasurableRating[])}
   */
  @Test
  @DisplayName("Test withMeasurableRatings(MeasurableRating[]) with 'MeasurableRating[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.withMeasurableRatings(MeasurableRating[])"})
  void testWithMeasurableRatingsWithMeasurableRating() {
    // Arrange
    ImmutableMeasurableRatingsView buildResult = ImmutableMeasurableRatingsView.builder().build();

    // Act
    ImmutableMeasurableRatingsView actualWithMeasurableRatingsResult = buildResult
        .withMeasurableRatings(mock(MeasurableRating.class));

    // Assert
    assertEquals(1, actualWithMeasurableRatingsResult.measurableRatings().size());
    Set<MeasurableCategory> measurableCategoriesResult = actualWithMeasurableRatingsResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualWithMeasurableRatingsResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualWithMeasurableRatingsResult.measurables());
    assertSame(measurableCategoriesResult, actualWithMeasurableRatingsResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#withMeasurables(Measurable[])} with {@code Measurable[]}.
   * <ul>
   *   <li>When {@link Measurable}.</li>
   *   <li>Then return measurables size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#withMeasurables(Measurable[])}
   */
  @Test
  @DisplayName("Test withMeasurables(Measurable[]) with 'Measurable[]'; when Measurable; then return measurables size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.withMeasurables(Measurable[])"})
  void testWithMeasurablesWithMeasurable_whenMeasurable_thenReturnMeasurablesSizeIsOne() {
    // Arrange
    ImmutableMeasurableRatingsView buildResult = ImmutableMeasurableRatingsView.builder().build();

    // Act
    ImmutableMeasurableRatingsView actualWithMeasurablesResult = buildResult.withMeasurables(mock(Measurable.class));

    // Assert
    assertEquals(1, actualWithMeasurablesResult.measurables().size());
    Set<MeasurableCategory> measurableCategoriesResult = actualWithMeasurablesResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualWithMeasurablesResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualWithMeasurablesResult.measurableRatings());
    assertSame(measurableCategoriesResult, actualWithMeasurablesResult.ratingSchemeItems());
  }

  /**
   * Test {@link ImmutableMeasurableRatingsView#withRatingSchemeItems(RatingSchemeItem[])} with {@code RatingSchemeItem[]}.
   * <p>
   * Method under test: {@link ImmutableMeasurableRatingsView#withRatingSchemeItems(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test withRatingSchemeItems(RatingSchemeItem[]) with 'RatingSchemeItem[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableMeasurableRatingsView ImmutableMeasurableRatingsView.withRatingSchemeItems(RatingSchemeItem[])"})
  void testWithRatingSchemeItemsWithRatingSchemeItem() {
    // Arrange
    ImmutableMeasurableRatingsView buildResult = ImmutableMeasurableRatingsView.builder().build();

    // Act
    ImmutableMeasurableRatingsView actualWithRatingSchemeItemsResult = buildResult
        .withRatingSchemeItems(mock(RatingSchemeItem.class));

    // Assert
    assertEquals(1, actualWithRatingSchemeItemsResult.ratingSchemeItems().size());
    Set<MeasurableCategory> measurableCategoriesResult = actualWithRatingSchemeItemsResult.measurableCategories();
    assertTrue(measurableCategoriesResult.isEmpty());
    assertSame(measurableCategoriesResult, actualWithRatingSchemeItemsResult.measurableHierarchy());
    assertSame(measurableCategoriesResult, actualWithRatingSchemeItemsResult.measurableRatings());
    assertSame(measurableCategoriesResult, actualWithRatingSchemeItemsResult.measurables());
  }
}
