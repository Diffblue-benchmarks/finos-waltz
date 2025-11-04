package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingStatParamsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingStatParams.Builder#from(MeasurableRatingStatParams)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Builder builderResult = ImmutableMeasurableRatingStatParams.builder();
    MeasurableRatingStatParams instance = mock(MeasurableRatingStatParams.class);
    when(instance.showPrimaryOnly()).thenReturn(true);
    when(instance.options()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableMeasurableRatingStatParams.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).options();
    verify(instance).showPrimaryOnly();
    assertTrue(actualFromResult.build().showPrimaryOnly());
    assertTrue(builderResult.build().showPrimaryOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingStatParams.Builder#from(MeasurableRatingStatParams)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Builder builderResult = ImmutableMeasurableRatingStatParams.builder();
    MeasurableRatingStatParams instance = mock(MeasurableRatingStatParams.class);
    when(instance.showPrimaryOnly()).thenThrow(new IllegalStateException("instance"));
    when(instance.options()).thenReturn(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).options();
    verify(instance).showPrimaryOnly();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingStatParams.Builder#options(IdSelectionOptions)}
   */
  @Test
  void testBuilderOptions() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Builder builderResult = ImmutableMeasurableRatingStatParams.builder();
    IdSelectionOptions options = mock(IdSelectionOptions.class);

    // Act
    ImmutableMeasurableRatingStatParams.Builder actualOptionsResult = builderResult.options(options);

    // Assert
    ImmutableMeasurableRatingStatParams buildResult = builderResult.build();
    assertFalse(buildResult.showPrimaryOnly());
    assertSame(builderResult, actualOptionsResult);
    assertSame(options, buildResult.options());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingStatParams.Builder#showPrimaryOnly(boolean)}
   */
  @Test
  void testBuilderShowPrimaryOnly() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Builder builderResult = ImmutableMeasurableRatingStatParams.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.showPrimaryOnly(true));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingStatParams#copyOf(MeasurableRatingStatParams)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableRatingStatParams instance = mock(MeasurableRatingStatParams.class);
    when(instance.showPrimaryOnly()).thenReturn(true);
    when(instance.options()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableMeasurableRatingStatParams actualCopyOfResult = ImmutableMeasurableRatingStatParams.copyOf(instance);

    // Assert
    verify(instance).options();
    verify(instance).showPrimaryOnly();
    assertTrue(actualCopyOfResult.showPrimaryOnly());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingStatParams#copyOf(MeasurableRatingStatParams)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    MeasurableRatingStatParams instance = mock(MeasurableRatingStatParams.class);
    when(instance.showPrimaryOnly()).thenReturn(false);
    when(instance.options()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableMeasurableRatingStatParams actualCopyOfResult = ImmutableMeasurableRatingStatParams.copyOf(instance);

    // Assert
    verify(instance).options();
    verify(instance).showPrimaryOnly();
    assertFalse(actualCopyOfResult.showPrimaryOnly());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingStatParams#fromJson(ImmutableMeasurableRatingStatParams.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Json json = new ImmutableMeasurableRatingStatParams.Json();
    json.setOptions(mock(IdSelectionOptions.class));

    // Act
    ImmutableMeasurableRatingStatParams actualFromJsonResult = ImmutableMeasurableRatingStatParams.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.showPrimaryOnly());
    IdSelectionOptions expectedOptionsResult = json.options;
    assertSame(expectedOptionsResult, actualFromJsonResult.options());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableMeasurableRatingStatParams.Json}
   *   <li>
   * {@link ImmutableMeasurableRatingStatParams.Json#setOptions(IdSelectionOptions)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableMeasurableRatingStatParams.Json actualJson = new ImmutableMeasurableRatingStatParams.Json();
    actualJson.setOptions(null);

    // Assert
    assertNull(actualJson.options);
    assertFalse(actualJson.showPrimaryOnly);
    assertFalse(actualJson.showPrimaryOnlyIsSet);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRatingStatParams.Json#options()}
   */
  @Test
  void testJsonOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRatingStatParams.Json()).options());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingStatParams.Json#setShowPrimaryOnly(boolean)}
   */
  @Test
  void testJsonSetShowPrimaryOnly() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Json json = new ImmutableMeasurableRatingStatParams.Json();

    // Act
    json.setShowPrimaryOnly(true);

    // Assert
    assertTrue(json.showPrimaryOnly);
    assertTrue(json.showPrimaryOnlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingStatParams.Json#setShowPrimaryOnly(boolean)}
   */
  @Test
  void testJsonSetShowPrimaryOnly2() {
    // Arrange
    ImmutableMeasurableRatingStatParams.Json json = new ImmutableMeasurableRatingStatParams.Json();
    json.setOptions(mock(IdSelectionOptions.class));

    // Act
    json.setShowPrimaryOnly(true);

    // Assert
    assertTrue(json.showPrimaryOnly);
    assertTrue(json.showPrimaryOnlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingStatParams.Json#showPrimaryOnly()}
   */
  @Test
  void testJsonShowPrimaryOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingStatParams.Json()).showPrimaryOnly());
  }
}
