package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAggregatedEntitiesWidgetParameters.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAggregatedEntitiesWidgetParameters.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAggregatedEntitiesWidgetParametersDiffblueTest {
  /**
   * Test Builder {@link Builder#from(AggregatedEntitiesWidgetParameters)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AggregatedEntitiesWidgetParameters)}
   */
  @Test
  @DisplayName("Test Builder from(AggregatedEntitiesWidgetParameters); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AggregatedEntitiesWidgetParameters)"})
  void testBuilderFrom_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetParameters.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.from(new Json()));
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetParameters#equals(Object)}, and {@link ImmutableAggregatedEntitiesWidgetParameters#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAggregatedEntitiesWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableAggregatedEntitiesWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAggregatedEntitiesWidgetParameters.equals(Object)",
      "int ImmutableAggregatedEntitiesWidgetParameters.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetParameters buildResult = ImmutableAggregatedEntitiesWidgetParameters.builder()
        .build();
    ImmutableAggregatedEntitiesWidgetParameters buildResult2 = ImmutableAggregatedEntitiesWidgetParameters.builder()
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetParameters#equals(Object)}, and {@link ImmutableAggregatedEntitiesWidgetParameters#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAggregatedEntitiesWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableAggregatedEntitiesWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAggregatedEntitiesWidgetParameters.equals(Object)",
      "int ImmutableAggregatedEntitiesWidgetParameters.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetParameters buildResult = ImmutableAggregatedEntitiesWidgetParameters.builder()
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetParameters#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAggregatedEntitiesWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAggregatedEntitiesWidgetParameters.equals(Object)",
      "int ImmutableAggregatedEntitiesWidgetParameters.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetParameters buildResult = ImmutableAggregatedEntitiesWidgetParameters.builder()
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetParameters#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAggregatedEntitiesWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAggregatedEntitiesWidgetParameters.equals(Object)",
      "int ImmutableAggregatedEntitiesWidgetParameters.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetParameters buildResult = ImmutableAggregatedEntitiesWidgetParameters.builder()
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableAggregatedEntitiesWidgetParameters");
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetParameters#toString()}.
   * <p>
   * Method under test: {@link ImmutableAggregatedEntitiesWidgetParameters#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ImmutableAggregatedEntitiesWidgetParameters.toString()"})
  void testToString() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetParameters buildResult = ImmutableAggregatedEntitiesWidgetParameters.builder()
        .build();

    // Act and Assert
    assertEquals("AggregatedEntitiesWidgetParameters{}", buildResult.toString());
  }
}
