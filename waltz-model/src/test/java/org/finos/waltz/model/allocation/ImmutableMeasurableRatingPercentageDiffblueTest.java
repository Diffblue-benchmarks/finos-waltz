package org.finos.waltz.model.allocation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.allocation.ImmutableMeasurableRatingPercentage.Builder;
import org.finos.waltz.model.allocation.ImmutableMeasurableRatingPercentage.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingPercentageDiffblueTest {
  /**
   * Test Builder {@link Builder#from(MeasurableRatingPercentage)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build percentage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingPercentage)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingPercentage); given one; then builder build percentage is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingPercentage)"})
  void testBuilderFrom_givenOne_thenBuilderBuildPercentageIsOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPercentage.builder();
    MeasurableRatingPercentage instance = mock(MeasurableRatingPercentage.class);
    when(instance.percentage()).thenReturn(1);
    when(instance.measurableRatingId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurableRatingId();
    verify(instance).percentage();
    ImmutableMeasurableRatingPercentage buildResult = builderResult.build();
    assertEquals(1, buildResult.percentage());
    assertEquals(1L, buildResult.measurableRatingId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#measurableRatingId(long)}.
   * <p>
   * Method under test: {@link Builder#measurableRatingId(long)}
   */
  @Test
  @DisplayName("Test Builder measurableRatingId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableRatingId(long)"})
  void testBuilderMeasurableRatingId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPercentage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableRatingId(1L));
  }

  /**
   * Test Builder {@link Builder#percentage(int)}.
   * <p>
   * Method under test: {@link Builder#percentage(int)}
   */
  @Test
  @DisplayName("Test Builder percentage(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.percentage(int)"})
  void testBuilderPercentage() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPercentage.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.percentage(1));
  }

  /**
   * Test Json {@link Json#measurableRatingId()}.
   * <p>
   * Method under test: {@link Json#measurableRatingId()}
   */
  @Test
  @DisplayName("Test Json measurableRatingId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.measurableRatingId()"})
  void testJsonMeasurableRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableRatingId());
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
    assertEquals(0, actualJson.percentage);
    assertEquals(0L, actualJson.measurableRatingId);
    assertFalse(actualJson.measurableRatingIdIsSet);
    assertFalse(actualJson.percentageIsSet);
  }

  /**
   * Test Json {@link Json#percentage()}.
   * <p>
   * Method under test: {@link Json#percentage()}
   */
  @Test
  @DisplayName("Test Json percentage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.percentage()"})
  void testJsonPercentage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).percentage());
  }

  /**
   * Test Json {@link Json#setMeasurableRatingId(long)}.
   * <p>
   * Method under test: {@link Json#setMeasurableRatingId(long)}
   */
  @Test
  @DisplayName("Test Json setMeasurableRatingId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setMeasurableRatingId(long)"})
  void testJsonSetMeasurableRatingId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMeasurableRatingId(1L);

    // Assert
    assertEquals(1L, json.measurableRatingId);
    assertTrue(json.measurableRatingIdIsSet);
  }

  /**
   * Test Json {@link Json#setPercentage(int)}.
   * <p>
   * Method under test: {@link Json#setPercentage(int)}
   */
  @Test
  @DisplayName("Test Json setPercentage(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setPercentage(int)"})
  void testJsonSetPercentage() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPercentage(1);

    // Assert
    assertEquals(1, json.percentage);
    assertTrue(json.percentageIsSet);
  }
}
