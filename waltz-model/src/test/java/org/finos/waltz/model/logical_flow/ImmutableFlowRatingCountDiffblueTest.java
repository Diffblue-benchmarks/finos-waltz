package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.logical_flow.ImmutableFlowRatingCount.Builder;
import org.finos.waltz.model.logical_flow.ImmutableFlowRatingCount.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowRatingCountDiffblueTest {
  /**
   * Test Builder {@link Builder#flowCount(int)}.
   * <p>
   * Method under test: {@link Builder#flowCount(int)}
   */
  @Test
  @DisplayName("Test Builder flowCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.flowCount(int)"})
  void testBuilderFlowCount() {
    // Arrange
    Builder builderResult = ImmutableFlowRatingCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowCount(3));
  }

  /**
   * Test Builder {@link Builder#from(FlowRatingCount)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then builder build rating longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowRatingCount)}
   */
  @Test
  @DisplayName("Test Builder from(FlowRatingCount); given three; then builder build rating longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowRatingCount)"})
  void testBuilderFrom_givenThree_thenBuilderBuildRatingLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowRatingCount.builder();
    FlowRatingCount instance = mock(FlowRatingCount.class);
    when(instance.flowCount()).thenReturn(3);
    when(instance.rating()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).flowCount();
    verify(instance).rating();
    ImmutableFlowRatingCount buildResult = builderResult.build();
    assertEquals(1L, buildResult.rating().longValue());
    assertEquals(3, buildResult.flowCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#rating(Long)}.
   * <p>
   * Method under test: {@link Builder#rating(Long)}
   */
  @Test
  @DisplayName("Test Builder rating(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rating(Long)"})
  void testBuilderRating() {
    // Arrange
    Builder builderResult = ImmutableFlowRatingCount.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating(1L));
  }

  /**
   * Test Json {@link Json#flowCount()}.
   * <p>
   * Method under test: {@link Json#flowCount()}
   */
  @Test
  @DisplayName("Test Json flowCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.flowCount()"})
  void testJsonFlowCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).flowCount());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setRating(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setRating(Long)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setRating(1L);

    // Assert
    assertEquals(1L, actualJson.rating.longValue());
  }

  /**
   * Test Json {@link Json#rating()}.
   * <p>
   * Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rating());
  }

  /**
   * Test Json {@link Json#setFlowCount(int)}.
   * <p>
   * Method under test: {@link Json#setFlowCount(int)}
   */
  @Test
  @DisplayName("Test Json setFlowCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setFlowCount(int)"})
  void testJsonSetFlowCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setFlowCount(3);

    // Assert
    assertEquals(3, json.flowCount);
    assertTrue(json.flowCountIsSet);
  }
}
