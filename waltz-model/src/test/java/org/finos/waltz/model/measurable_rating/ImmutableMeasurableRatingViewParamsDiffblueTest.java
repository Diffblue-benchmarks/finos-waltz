package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingViewParams.Builder;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingViewParams.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingViewParamsDiffblueTest {
  /**
   * Test Builder {@link Builder#from(MeasurableRatingViewParams)}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingViewParams)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingViewParams); given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingViewParams)"})
  void testBuilderFrom_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingViewParams.builder();
    MeasurableRatingViewParams instance = mock(MeasurableRatingViewParams.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentMeasurableId()).thenReturn(emptyResult);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).idSelectionOptions();
    verify(instance).parentMeasurableId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingViewParams)}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingViewParams)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingViewParams); given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingViewParams)"})
  void testBuilderFrom_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingViewParams.builder();
    MeasurableRatingViewParams instance = mock(MeasurableRatingViewParams.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentMeasurableId()).thenReturn(ofResult);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).idSelectionOptions();
    verify(instance).parentMeasurableId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingViewParams)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingViewParams)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingViewParams); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingViewParams)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingViewParams.builder();
    MeasurableRatingViewParams instance = mock(MeasurableRatingViewParams.class);
    when(instance.parentMeasurableId()).thenThrow(new IllegalStateException("instance"));
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).idSelectionOptions();
    verify(instance).parentMeasurableId();
  }

  /**
   * Test Builder {@link Builder#idSelectionOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>When {@link IdSelectionOptions}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder idSelectionOptions(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.idSelectionOptions(IdSelectionOptions)"})
  void testBuilderIdSelectionOptions_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingViewParams.builder();
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);

    // Act and Assert
    assertSame(builderResult, builderResult.idSelectionOptions(idSelectionOptions));
    assertSame(idSelectionOptions, builderResult.build().idSelectionOptions());
  }

  /**
   * Test Builder {@link Builder#parentMeasurableId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#parentMeasurableId(long)}
   */
  @Test
  @DisplayName("Test Builder parentMeasurableId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentMeasurableId(long)"})
  void testBuilderParentMeasurableIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingViewParams.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentMeasurableId(1L));
  }

  /**
   * Test Builder {@link Builder#parentMeasurableId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#parentMeasurableId(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentMeasurableId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.parentMeasurableId(Optional)"})
  void testBuilderParentMeasurableIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingViewParams.builder();
    Optional<Long> parentMeasurableId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.parentMeasurableId(parentMeasurableId));
  }

  /**
   * Test Json {@link Json#idSelectionOptions()}.
   * <p>
   * Method under test: {@link Json#idSelectionOptions()}
   */
  @Test
  @DisplayName("Test Json idSelectionOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IdSelectionOptions Json.idSelectionOptions()"})
  void testJsonIdSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).idSelectionOptions());
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
    assertNull(actualJson.idSelectionOptions);
    assertFalse(actualJson.parentMeasurableId.isPresent());
  }

  /**
   * Test Json {@link Json#parentMeasurableId()}.
   * <p>
   * Method under test: {@link Json#parentMeasurableId()}
   */
  @Test
  @DisplayName("Test Json parentMeasurableId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.parentMeasurableId()"})
  void testJsonParentMeasurableId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).parentMeasurableId());
  }
}
