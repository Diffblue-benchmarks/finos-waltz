package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutablePrimaryRatingViewItemDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutablePrimaryRatingViewItem.Builder#from(PrimaryRatingViewItem)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePrimaryRatingViewItem.Builder builderResult = ImmutablePrimaryRatingViewItem.builder();
    PrimaryRatingViewItem instance = mock(PrimaryRatingViewItem.class);
    when(instance.measurable()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableCategory()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).measurable();
    verify(instance).measurableCategory();
  }

  /**
   * Method under test:
   * {@link ImmutablePrimaryRatingViewItem.Builder#from(PrimaryRatingViewItem)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePrimaryRatingViewItem.Builder builderResult = ImmutablePrimaryRatingViewItem.builder();
    PrimaryRatingViewItem instance = mock(PrimaryRatingViewItem.class);
    when(instance.ratingColor()).thenReturn("Rating Color");
    when(instance.ratingDescription()).thenReturn("Rating Description");
    when(instance.ratingName()).thenReturn("Rating Name");
    when(instance.measurable()).thenReturn(mock(EntityReference.class));
    when(instance.measurableCategory()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePrimaryRatingViewItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurable();
    verify(instance).measurableCategory();
    verify(instance).ratingColor();
    verify(instance).ratingDescription();
    verify(instance).ratingName();
    ImmutablePrimaryRatingViewItem buildResult = builderResult.build();
    assertEquals("Rating Color", buildResult.ratingColor());
    assertEquals("Rating Description", buildResult.ratingDescription());
    assertEquals("Rating Name", buildResult.ratingName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePrimaryRatingViewItem.Builder#from(PrimaryRatingViewItem)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePrimaryRatingViewItem.Builder builderResult = ImmutablePrimaryRatingViewItem.builder();
    PrimaryRatingViewItem instance = mock(PrimaryRatingViewItem.class);
    when(instance.ratingColor()).thenThrow(new IllegalStateException("instance"));
    when(instance.ratingDescription()).thenReturn("Rating Description");
    when(instance.ratingName()).thenReturn("Rating Name");
    when(instance.measurable()).thenReturn(mock(EntityReference.class));
    when(instance.measurableCategory()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).measurable();
    verify(instance).measurableCategory();
    verify(instance).ratingColor();
    verify(instance).ratingDescription();
    verify(instance).ratingName();
  }

  /**
   * Method under test:
   * {@link ImmutablePrimaryRatingViewItem.Builder#measurable(EntityReference)}
   */
  @Test
  void testBuilderMeasurable() {
    // Arrange
    ImmutablePrimaryRatingViewItem.Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurable(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePrimaryRatingViewItem.Builder#measurableCategory(EntityReference)}
   */
  @Test
  void testBuilderMeasurableCategory() {
    // Arrange
    ImmutablePrimaryRatingViewItem.Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableCategory(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePrimaryRatingViewItem.Builder#ratingColor(String)}
   */
  @Test
  void testBuilderRatingColor() {
    // Arrange
    ImmutablePrimaryRatingViewItem.Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingColor("Rating Color"));
  }

  /**
   * Method under test:
   * {@link ImmutablePrimaryRatingViewItem.Builder#ratingDescription(String)}
   */
  @Test
  void testBuilderRatingDescription() {
    // Arrange
    ImmutablePrimaryRatingViewItem.Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingDescription("Rating Description"));
  }

  /**
   * Method under test:
   * {@link ImmutablePrimaryRatingViewItem.Builder#ratingName(String)}
   */
  @Test
  void testBuilderRatingName() {
    // Arrange
    ImmutablePrimaryRatingViewItem.Builder builderResult = ImmutablePrimaryRatingViewItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingName("Rating Name"));
  }

  /**
   * Method under test:
   * {@link ImmutablePrimaryRatingViewItem#copyOf(PrimaryRatingViewItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PrimaryRatingViewItem instance = mock(PrimaryRatingViewItem.class);
    when(instance.ratingColor()).thenReturn("Rating Color");
    when(instance.ratingDescription()).thenReturn("Rating Description");
    when(instance.ratingName()).thenReturn("Rating Name");
    when(instance.measurable()).thenReturn(mock(EntityReference.class));
    when(instance.measurableCategory()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutablePrimaryRatingViewItem actualCopyOfResult = ImmutablePrimaryRatingViewItem.copyOf(instance);

    // Assert
    verify(instance).measurable();
    verify(instance).measurableCategory();
    verify(instance).ratingColor();
    verify(instance).ratingDescription();
    verify(instance).ratingName();
    assertEquals("Rating Color", actualCopyOfResult.ratingColor());
    assertEquals("Rating Description", actualCopyOfResult.ratingDescription());
    assertEquals("Rating Name", actualCopyOfResult.ratingName());
  }

  /**
   * Method under test:
   * {@link ImmutablePrimaryRatingViewItem#fromJson(ImmutablePrimaryRatingViewItem.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutablePrimaryRatingViewItem.Json json = new ImmutablePrimaryRatingViewItem.Json();
    json.setMeasurableCategory(mock(EntityReference.class));
    json.setMeasurable(mock(EntityReference.class));
    json.setRatingName("Json");
    json.setRatingDescription("Json");
    json.setRatingColor("Json");

    // Act
    ImmutablePrimaryRatingViewItem actualFromJsonResult = ImmutablePrimaryRatingViewItem.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.ratingColor());
    assertEquals("Json", actualFromJsonResult.ratingDescription());
    assertEquals("Json", actualFromJsonResult.ratingName());
    EntityReference expectedMeasurableResult = json.measurable;
    assertSame(expectedMeasurableResult, actualFromJsonResult.measurable());
    EntityReference expectedMeasurableCategoryResult = json.measurableCategory;
    assertSame(expectedMeasurableCategoryResult, actualFromJsonResult.measurableCategory());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutablePrimaryRatingViewItem.Json}
   *   <li>
   * {@link ImmutablePrimaryRatingViewItem.Json#setMeasurable(EntityReference)}
   *   <li>
   * {@link ImmutablePrimaryRatingViewItem.Json#setMeasurableCategory(EntityReference)}
   *   <li>{@link ImmutablePrimaryRatingViewItem.Json#setRatingColor(String)}
   *   <li>{@link ImmutablePrimaryRatingViewItem.Json#setRatingDescription(String)}
   *   <li>{@link ImmutablePrimaryRatingViewItem.Json#setRatingName(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutablePrimaryRatingViewItem.Json actualJson = new ImmutablePrimaryRatingViewItem.Json();
    actualJson.setMeasurable(null);
    actualJson.setMeasurableCategory(null);
    actualJson.setRatingColor("Rating Color");
    actualJson.setRatingDescription("Rating Description");
    actualJson.setRatingName("Rating Name");

    // Assert
    assertEquals("Rating Color", actualJson.ratingColor);
    assertEquals("Rating Description", actualJson.ratingDescription);
    assertEquals("Rating Name", actualJson.ratingName);
    assertNull(actualJson.measurable);
    assertNull(actualJson.measurableCategory);
  }

  /**
   * Method under test: {@link ImmutablePrimaryRatingViewItem.Json#measurable()}
   */
  @Test
  void testJsonMeasurable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePrimaryRatingViewItem.Json()).measurable());
  }

  /**
   * Method under test:
   * {@link ImmutablePrimaryRatingViewItem.Json#measurableCategory()}
   */
  @Test
  void testJsonMeasurableCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePrimaryRatingViewItem.Json()).measurableCategory());
  }

  /**
   * Method under test: {@link ImmutablePrimaryRatingViewItem.Json#ratingColor()}
   */
  @Test
  void testJsonRatingColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePrimaryRatingViewItem.Json()).ratingColor());
  }

  /**
   * Method under test:
   * {@link ImmutablePrimaryRatingViewItem.Json#ratingDescription()}
   */
  @Test
  void testJsonRatingDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePrimaryRatingViewItem.Json()).ratingDescription());
  }

  /**
   * Method under test: {@link ImmutablePrimaryRatingViewItem.Json#ratingName()}
   */
  @Test
  void testJsonRatingName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePrimaryRatingViewItem.Json()).ratingName());
  }
}
