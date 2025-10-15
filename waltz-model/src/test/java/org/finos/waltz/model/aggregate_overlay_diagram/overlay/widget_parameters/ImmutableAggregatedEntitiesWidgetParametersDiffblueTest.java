package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAggregatedEntitiesWidgetParameters.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAggregatedEntitiesWidgetParameters.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAggregatedEntitiesWidgetParametersDiffblueTest {
  /**
   * Test Builder {@link Builder#from(AggregatedEntitiesWidgetParameters)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AggregatedEntitiesWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AggregatedEntitiesWidgetParameters); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AggregatedEntitiesWidgetParameters)"})
  void testBuilderFrom_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregatedEntitiesWidgetParameters.builder();

    // Act
    Builder actualFromResult = builderResult.from(new Json());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetParameters#equals(Object)}, and {@link
   * ImmutableAggregatedEntitiesWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregatedEntitiesWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableAggregatedEntitiesWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregatedEntitiesWidgetParameters.equals(Object)",
    "int ImmutableAggregatedEntitiesWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetParameters immutableAggregatedEntitiesWidgetParameters =
        ImmutableAggregatedEntitiesWidgetParameters.builder().build();
    ImmutableAggregatedEntitiesWidgetParameters immutableAggregatedEntitiesWidgetParameters2 =
        ImmutableAggregatedEntitiesWidgetParameters.builder().build();

    // Act and Assert
    assertEquals(
        immutableAggregatedEntitiesWidgetParameters, immutableAggregatedEntitiesWidgetParameters2);
    assertEquals(
        immutableAggregatedEntitiesWidgetParameters.hashCode(),
        immutableAggregatedEntitiesWidgetParameters2.hashCode());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetParameters#equals(Object)}, and {@link
   * ImmutableAggregatedEntitiesWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregatedEntitiesWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableAggregatedEntitiesWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregatedEntitiesWidgetParameters.equals(Object)",
    "int ImmutableAggregatedEntitiesWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAggregatedEntitiesWidgetParameters immutableAggregatedEntitiesWidgetParameters =
        ImmutableAggregatedEntitiesWidgetParameters.builder().build();

    // Act and Assert
    assertEquals(
        immutableAggregatedEntitiesWidgetParameters, immutableAggregatedEntitiesWidgetParameters);
    int expectedHashCodeResult = immutableAggregatedEntitiesWidgetParameters.hashCode();
    assertEquals(expectedHashCodeResult, immutableAggregatedEntitiesWidgetParameters.hashCode());
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregatedEntitiesWidgetParameters.equals(Object)",
    "int ImmutableAggregatedEntitiesWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableAggregatedEntitiesWidgetParameters.builder().build(), null);
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregatedEntitiesWidgetParameters.equals(Object)",
    "int ImmutableAggregatedEntitiesWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAggregatedEntitiesWidgetParameters.builder().build(),
        "Different type to ImmutableAggregatedEntitiesWidgetParameters");
  }

  /**
   * Test {@link ImmutableAggregatedEntitiesWidgetParameters#toString()}.
   *
   * <p>Method under test: {@link ImmutableAggregatedEntitiesWidgetParameters#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableAggregatedEntitiesWidgetParameters.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "AggregatedEntitiesWidgetParameters{}",
        ImmutableAggregatedEntitiesWidgetParameters.builder().build().toString());
  }
}
