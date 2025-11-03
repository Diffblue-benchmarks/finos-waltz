package org.finos.waltz.model.tally;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.tally.ImmutableMeasurableRatingTally.Builder;
import org.finos.waltz.model.tally.ImmutableMeasurableRatingTally.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingTallyDiffblueTest {
  /**
   * Test Builder {@link Builder#count(long)}.
   * <p>
   * Method under test: {@link Builder#count(long)}
   */
  @Test
  @DisplayName("Test Builder count(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.count(long)"})
  void testBuilderCount() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3L));
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingTally)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then builder build rating is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingTally)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingTally); given 'A'; then builder build rating is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingTally)"})
  void testBuilderFrom_givenA_thenBuilderBuildRatingIsA() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingTally.builder();
    MeasurableRatingTally instance = mock(MeasurableRatingTally.class);
    when(instance.rating()).thenReturn('A');
    when(instance.count()).thenReturn(3L);
    when(instance.id()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).id();
    verify(instance).rating();
    ImmutableMeasurableRatingTally buildResult = builderResult.build();
    assertEquals('A', buildResult.rating());
    assertEquals(1L, buildResult.id());
    assertEquals(3L, buildResult.count());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#rating(char)}.
   * <p>
   * Method under test: {@link Builder#rating(char)}
   */
  @Test
  @DisplayName("Test Builder rating(char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rating(char)"})
  void testBuilderRating() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating('A'));
  }

  /**
   * Test Json {@link Json#count()}.
   * <p>
   * Method under test: {@link Json#count()}
   */
  @Test
  @DisplayName("Test Json count()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.count()"})
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).count());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
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
    assertEquals('\u0000', actualJson.rating);
    assertEquals(0L, actualJson.count);
    assertEquals(0L, actualJson.id);
    assertFalse(actualJson.countIsSet);
    assertFalse(actualJson.idIsSet);
    assertFalse(actualJson.ratingIsSet);
  }

  /**
   * Test Json {@link Json#rating()}.
   * <p>
   * Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"char Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rating());
  }

  /**
   * Test Json {@link Json#setCount(long)}.
   * <p>
   * Method under test: {@link Json#setCount(long)}
   */
  @Test
  @DisplayName("Test Json setCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setCount(long)"})
  void testJsonSetCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCount(3L);

    // Assert
    assertEquals(3L, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Test Json {@link Json#setId(long)}.
   * <p>
   * Method under test: {@link Json#setId(long)}
   */
  @Test
  @DisplayName("Test Json setId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setId(long)"})
  void testJsonSetId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
  }

  /**
   * Test Json {@link Json#setRating(char)}.
   * <p>
   * Method under test: {@link Json#setRating(char)}
   */
  @Test
  @DisplayName("Test Json setRating(char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRating(char)"})
  void testJsonSetRating() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRating('A');

    // Assert
    assertEquals('A', json.rating);
    assertTrue(json.ratingIsSet);
  }
}
