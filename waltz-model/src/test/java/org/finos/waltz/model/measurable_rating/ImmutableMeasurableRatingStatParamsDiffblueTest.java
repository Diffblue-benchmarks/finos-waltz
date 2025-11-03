package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingStatParams.Builder;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingStatParams.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingStatParamsDiffblueTest {
  /**
   * Test Builder {@link Builder#from(MeasurableRatingStatParams)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then builder build showPrimaryOnly.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingStatParams)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingStatParams); given 'true'; then builder build showPrimaryOnly")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingStatParams)"})
  void testBuilderFrom_givenTrue_thenBuilderBuildShowPrimaryOnly() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingStatParams.builder();
    MeasurableRatingStatParams instance = mock(MeasurableRatingStatParams.class);
    when(instance.showPrimaryOnly()).thenReturn(true);
    when(instance.options()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).options();
    verify(instance).showPrimaryOnly();
    assertTrue(builderResult.build().showPrimaryOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingStatParams)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingStatParams)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingStatParams); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingStatParams)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingStatParams.builder();
    MeasurableRatingStatParams instance = mock(MeasurableRatingStatParams.class);
    when(instance.showPrimaryOnly()).thenThrow(new IllegalStateException("instance"));
    when(instance.options()).thenReturn(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).options();
    verify(instance).showPrimaryOnly();
  }

  /**
   * Test Builder {@link Builder#options(IdSelectionOptions)}.
   * <ul>
   *   <li>When {@link IdSelectionOptions}.</li>
   *   <li>Then not builder build showPrimaryOnly.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#options(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder options(IdSelectionOptions); when IdSelectionOptions; then not builder build showPrimaryOnly")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.options(IdSelectionOptions)"})
  void testBuilderOptions_whenIdSelectionOptions_thenNotBuilderBuildShowPrimaryOnly() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingStatParams.builder();
    IdSelectionOptions options = mock(IdSelectionOptions.class);

    // Act
    Builder actualOptionsResult = builderResult.options(options);

    // Assert
    ImmutableMeasurableRatingStatParams buildResult = builderResult.build();
    assertFalse(buildResult.showPrimaryOnly());
    assertSame(builderResult, actualOptionsResult);
    assertSame(options, buildResult.options());
  }

  /**
   * Test Builder {@link Builder#showPrimaryOnly(boolean)}.
   * <p>
   * Method under test: {@link Builder#showPrimaryOnly(boolean)}
   */
  @Test
  @DisplayName("Test Builder showPrimaryOnly(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.showPrimaryOnly(boolean)"})
  void testBuilderShowPrimaryOnly() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingStatParams.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.showPrimaryOnly(true));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setOptions(IdSelectionOptions)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setOptions(IdSelectionOptions)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setOptions(null);

    // Assert
    assertNull(actualJson.options);
    assertFalse(actualJson.showPrimaryOnly);
    assertFalse(actualJson.showPrimaryOnlyIsSet);
  }

  /**
   * Test Json {@link Json#options()}.
   * <p>
   * Method under test: {@link Json#options()}
   */
  @Test
  @DisplayName("Test Json options()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IdSelectionOptions Json.options()"})
  void testJsonOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).options());
  }

  /**
   * Test Json {@link Json#setShowPrimaryOnly(boolean)}.
   * <p>
   * Method under test: {@link Json#setShowPrimaryOnly(boolean)}
   */
  @Test
  @DisplayName("Test Json setShowPrimaryOnly(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setShowPrimaryOnly(boolean)"})
  void testJsonSetShowPrimaryOnly() {
    // Arrange
    Json json = new Json();

    // Act
    json.setShowPrimaryOnly(true);

    // Assert
    assertTrue(json.showPrimaryOnly);
    assertTrue(json.showPrimaryOnlyIsSet);
  }

  /**
   * Test Json {@link Json#showPrimaryOnly()}.
   * <p>
   * Method under test: {@link Json#showPrimaryOnly()}
   */
  @Test
  @DisplayName("Test Json showPrimaryOnly()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.showPrimaryOnly()"})
  void testJsonShowPrimaryOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).showPrimaryOnly());
  }
}
