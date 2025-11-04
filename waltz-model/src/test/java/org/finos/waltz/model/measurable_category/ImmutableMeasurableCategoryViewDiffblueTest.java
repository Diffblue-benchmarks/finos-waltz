package org.finos.waltz.model.measurable_category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableCategoryViewDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryView.Builder#category(MeasurableCategory)}
   */
  @Test
  void testBuilderCategory() {
    // Arrange
    ImmutableMeasurableCategoryView.Builder builderResult = ImmutableMeasurableCategoryView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.category(new ImmutableMeasurableCategory.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryView.Builder#from(MeasurableCategoryView)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableCategoryView.Builder builderResult = ImmutableMeasurableCategoryView.builder();
    MeasurableCategoryView instance = mock(MeasurableCategoryView.class);
    when(instance.ratingCount()).thenReturn(3L);
    ImmutableMeasurableCategory.Json json = new ImmutableMeasurableCategory.Json();
    when(instance.category()).thenReturn(json);

    // Act
    ImmutableMeasurableCategoryView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).category();
    verify(instance).ratingCount();
    ImmutableMeasurableCategoryView buildResult = builderResult.build();
    assertEquals(3L, buildResult.ratingCount().longValue());
    assertSame(json, buildResult.category());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryView.Builder#from(MeasurableCategoryView)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableCategoryView.Builder builderResult = ImmutableMeasurableCategoryView.builder();
    MeasurableCategoryView instance = mock(MeasurableCategoryView.class);
    when(instance.ratingCount()).thenThrow(new IllegalStateException("instance"));
    when(instance.category()).thenReturn(new ImmutableMeasurableCategory.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).category();
    verify(instance).ratingCount();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryView.Builder#ratingCount(Long)}
   */
  @Test
  void testBuilderRatingCount() {
    // Arrange
    ImmutableMeasurableCategoryView.Builder builderResult = ImmutableMeasurableCategoryView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryView#copyOf(MeasurableCategoryView)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableCategoryView instance = mock(MeasurableCategoryView.class);
    when(instance.ratingCount()).thenReturn(3L);
    ImmutableMeasurableCategory.Json json = new ImmutableMeasurableCategory.Json();
    when(instance.category()).thenReturn(json);

    // Act
    ImmutableMeasurableCategoryView actualCopyOfResult = ImmutableMeasurableCategoryView.copyOf(instance);

    // Assert
    verify(instance).category();
    verify(instance).ratingCount();
    assertEquals(3L, actualCopyOfResult.ratingCount().longValue());
    assertSame(json, actualCopyOfResult.category());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategoryView#fromJson(ImmutableMeasurableCategoryView.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableMeasurableCategoryView.Json json = new ImmutableMeasurableCategoryView.Json();
    ImmutableMeasurableCategory.Json category = new ImmutableMeasurableCategory.Json();
    json.setCategory(category);
    json.setRatingCount(1L);

    // Act
    ImmutableMeasurableCategoryView actualFromJsonResult = ImmutableMeasurableCategoryView.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.ratingCount().longValue());
    assertSame(category, actualFromJsonResult.category());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategoryView.Json#category()}
   */
  @Test
  void testJsonCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCategoryView.Json()).category());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableMeasurableCategoryView.Json}
   *   <li>
   * {@link ImmutableMeasurableCategoryView.Json#setCategory(MeasurableCategory)}
   *   <li>{@link ImmutableMeasurableCategoryView.Json#setRatingCount(Long)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableMeasurableCategoryView.Json actualJson = new ImmutableMeasurableCategoryView.Json();
    actualJson.setCategory(new ImmutableMeasurableCategory.Json());
    actualJson.setRatingCount(3L);

    // Assert
    assertEquals(3L, actualJson.ratingCount.longValue());
    assertFalse(
        ((ImmutableMeasurableCategory.Json) actualJson.category).constrainingAssessmentDefinitionId.isPresent());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategoryView.Json#ratingCount()}
   */
  @Test
  void testJsonRatingCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCategoryView.Json()).ratingCount());
  }
}
