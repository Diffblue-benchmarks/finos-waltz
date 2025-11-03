package org.finos.waltz.model.measurable_category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategoryView.Builder;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategoryView.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableCategoryViewDiffblueTest {
  /**
   * Test Builder {@link Builder#category(MeasurableCategory)}.
   * <ul>
   *   <li>When {@link ImmutableMeasurableCategory.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#category(MeasurableCategory)}
   */
  @Test
  @DisplayName("Test Builder category(MeasurableCategory); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.category(MeasurableCategory)"})
  void testBuilderCategory_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.category(new ImmutableMeasurableCategory.Json()));
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCategoryView)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then builder build ratingCount longValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableCategoryView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCategoryView); given three; then builder build ratingCount longValue is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCategoryView)"})
  void testBuilderFrom_givenThree_thenBuilderBuildRatingCountLongValueIsThree() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();
    MeasurableCategoryView instance = mock(MeasurableCategoryView.class);
    when(instance.ratingCount()).thenReturn(3L);
    ImmutableMeasurableCategory.Json json = new ImmutableMeasurableCategory.Json();
    when(instance.category()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).category();
    verify(instance).ratingCount();
    ImmutableMeasurableCategoryView buildResult = builderResult.build();
    assertEquals(3L, buildResult.ratingCount().longValue());
    assertSame(json, buildResult.category());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCategoryView)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableCategoryView)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCategoryView); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCategoryView)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();
    MeasurableCategoryView instance = mock(MeasurableCategoryView.class);
    when(instance.ratingCount()).thenThrow(new IllegalStateException("instance"));
    when(instance.category()).thenReturn(new ImmutableMeasurableCategory.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).category();
    verify(instance).ratingCount();
  }

  /**
   * Test Builder {@link Builder#ratingCount(Long)}.
   * <p>
   * Method under test: {@link Builder#ratingCount(Long)}
   */
  @Test
  @DisplayName("Test Builder ratingCount(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingCount(Long)"})
  void testBuilderRatingCount() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingCount(3L));
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
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCategory(MeasurableCategory)}
   *   <li>{@link Json#setRatingCount(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCategory(MeasurableCategory)",
      "void Json.setRatingCount(Long)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCategory(new ImmutableMeasurableCategory.Json());
    actualJson.setRatingCount(3L);

    // Assert
    assertEquals(3L, actualJson.ratingCount.longValue());
    assertFalse(
        ((ImmutableMeasurableCategory.Json) actualJson.category).constrainingAssessmentDefinitionId.isPresent());
  }

  /**
   * Test Json {@link Json#ratingCount()}.
   * <p>
   * Method under test: {@link Json#ratingCount()}
   */
  @Test
  @DisplayName("Test Json ratingCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.ratingCount()"})
  void testJsonRatingCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingCount());
  }
}
