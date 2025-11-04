package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingViewParamsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingViewParams.Builder#from(MeasurableRatingViewParams)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult = ImmutableMeasurableRatingViewParams.builder();
    MeasurableRatingViewParams instance = mock(MeasurableRatingViewParams.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentMeasurableId()).thenReturn(ofResult);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableMeasurableRatingViewParams.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).idSelectionOptions();
    verify(instance).parentMeasurableId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingViewParams.Builder#from(MeasurableRatingViewParams)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult = ImmutableMeasurableRatingViewParams.builder();
    MeasurableRatingViewParams instance = mock(MeasurableRatingViewParams.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentMeasurableId()).thenReturn(emptyResult);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableMeasurableRatingViewParams.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).idSelectionOptions();
    verify(instance).parentMeasurableId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingViewParams.Builder#from(MeasurableRatingViewParams)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult = ImmutableMeasurableRatingViewParams.builder();
    MeasurableRatingViewParams instance = mock(MeasurableRatingViewParams.class);
    when(instance.parentMeasurableId()).thenThrow(new IllegalStateException("instance"));
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).idSelectionOptions();
    verify(instance).parentMeasurableId();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingViewParams.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  void testBuilderIdSelectionOptions() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult = ImmutableMeasurableRatingViewParams.builder();
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);

    // Act
    ImmutableMeasurableRatingViewParams.Builder actualIdSelectionOptionsResult = builderResult
        .idSelectionOptions(idSelectionOptions);

    // Assert
    assertSame(builderResult, actualIdSelectionOptionsResult);
    assertSame(idSelectionOptions, actualIdSelectionOptionsResult.build().idSelectionOptions());
    assertSame(idSelectionOptions, builderResult.build().idSelectionOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingViewParams.Builder#parentMeasurableId(long)}
   */
  @Test
  void testBuilderParentMeasurableId() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult = ImmutableMeasurableRatingViewParams.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentMeasurableId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingViewParams.Builder#parentMeasurableId(Optional)}
   */
  @Test
  void testBuilderParentMeasurableId2() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Builder builderResult = ImmutableMeasurableRatingViewParams.builder();
    Optional<Long> parentMeasurableId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.parentMeasurableId(parentMeasurableId));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingViewParams#copyOf(MeasurableRatingViewParams)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableRatingViewParams instance = mock(MeasurableRatingViewParams.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentMeasurableId()).thenReturn(ofResult);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableMeasurableRatingViewParams.copyOf(instance);

    // Assert
    verify(instance).idSelectionOptions();
    verify(instance).parentMeasurableId();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingViewParams#copyOf(MeasurableRatingViewParams)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    MeasurableRatingViewParams instance = mock(MeasurableRatingViewParams.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentMeasurableId()).thenReturn(emptyResult);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableMeasurableRatingViewParams.copyOf(instance);

    // Assert
    verify(instance).idSelectionOptions();
    verify(instance).parentMeasurableId();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingViewParams#fromJson(ImmutableMeasurableRatingViewParams.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableMeasurableRatingViewParams.Json json = new ImmutableMeasurableRatingViewParams.Json();
    json.setIdSelectionOptions(mock(IdSelectionOptions.class));

    // Act and Assert
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult,
        ImmutableMeasurableRatingViewParams.fromJson(json).idSelectionOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingViewParams.Json#idSelectionOptions()}
   */
  @Test
  void testJsonIdSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingViewParams.Json()).idSelectionOptions());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableMeasurableRatingViewParams.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableMeasurableRatingViewParams.Json actualJson = new ImmutableMeasurableRatingViewParams.Json();

    // Assert
    assertNull(actualJson.idSelectionOptions);
    assertFalse(actualJson.parentMeasurableId.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingViewParams.Json#parentMeasurableId()}
   */
  @Test
  void testJsonParentMeasurableId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingViewParams.Json()).parentMeasurableId());
  }
}
