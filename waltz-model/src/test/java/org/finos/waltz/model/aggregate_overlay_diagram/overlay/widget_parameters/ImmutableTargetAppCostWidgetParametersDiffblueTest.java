package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableTargetAppCostWidgetParameters.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableTargetAppCostWidgetParameters.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTargetAppCostWidgetParametersDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTargetAppCostWidgetParameters Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    LocalDate targetDate = LocalDate.of(1970, 1, 1);

    // Act and Assert
    LocalDate targetDateResult =
        ImmutableTargetAppCostWidgetParameters.builder()
            .targetDate(targetDate)
            .build()
            .targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertSame(targetDate, targetDateResult);
  }

  /**
   * Test Builder {@link Builder#from(TargetAppCostWidgetParameters)}.
   *
   * <p>Method under test: {@link Builder#from(TargetAppCostWidgetParameters)}
   */
  @Test
  @DisplayName("Test Builder from(TargetAppCostWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(TargetAppCostWidgetParameters)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableTargetAppCostWidgetParameters.builder();
    ImmutableTargetAppCostWidgetParameters instance =
        ImmutableTargetAppCostWidgetParameters.builder()
            .targetDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableTargetAppCostWidgetParameters actualImmutableTargetAppCostWidgetParameters =
        builderResult.build();
    assertEquals(instance, actualImmutableTargetAppCostWidgetParameters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#targetDate(LocalDate)}.
   *
   * <ul>
   *   <li>Then builder build targetDate is {@link LocalDate} with {@code 1970} and one and one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#targetDate(LocalDate)}
   */
  @Test
  @DisplayName(
      "Test Builder targetDate(LocalDate); then builder build targetDate is LocalDate with '1970' and one and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetDate(LocalDate)"})
  void testBuilderTargetDate_thenBuilderBuildTargetDateIsLocalDateWith1970AndOneAndOne() {
    // Arrange
    Builder builderResult = ImmutableTargetAppCostWidgetParameters.builder();
    LocalDate targetDate = LocalDate.of(1970, 1, 1);

    // Act
    Builder actualTargetDateResult = builderResult.targetDate(targetDate);

    // Assert
    assertSame(targetDate, builderResult.build().targetDate());
    assertSame(builderResult, actualTargetDateResult);
  }

  /**
   * Test {@link ImmutableTargetAppCostWidgetParameters#copyOf(TargetAppCostWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return targetDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableTargetAppCostWidgetParameters#copyOf(TargetAppCostWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test copyOf(TargetAppCostWidgetParameters); then return targetDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTargetAppCostWidgetParameters ImmutableTargetAppCostWidgetParameters.copyOf(TargetAppCostWidgetParameters)"
  })
  void testCopyOf_thenReturnTargetDateToStringIs19700101() {
    // Arrange
    LocalDate targetDate = LocalDate.of(1970, 1, 1);
    ImmutableTargetAppCostWidgetParameters instance =
        ImmutableTargetAppCostWidgetParameters.builder().targetDate(targetDate).build();

    // Act and Assert
    LocalDate targetDateResult =
        ImmutableTargetAppCostWidgetParameters.copyOf(instance).targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertSame(targetDate, targetDateResult);
  }

  /**
   * Test {@link ImmutableTargetAppCostWidgetParameters#equals(Object)}, and {@link
   * ImmutableTargetAppCostWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTargetAppCostWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableTargetAppCostWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetAppCostWidgetParameters.equals(Object)",
    "int ImmutableTargetAppCostWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableTargetAppCostWidgetParameters immutableTargetAppCostWidgetParameters =
        ImmutableTargetAppCostWidgetParameters.builder()
            .targetDate(LocalDate.of(1970, 1, 1))
            .build();
    ImmutableTargetAppCostWidgetParameters immutableTargetAppCostWidgetParameters2 =
        ImmutableTargetAppCostWidgetParameters.builder()
            .targetDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertEquals(immutableTargetAppCostWidgetParameters, immutableTargetAppCostWidgetParameters2);
    assertEquals(
        immutableTargetAppCostWidgetParameters.hashCode(),
        immutableTargetAppCostWidgetParameters2.hashCode());
  }

  /**
   * Test {@link ImmutableTargetAppCostWidgetParameters#equals(Object)}, and {@link
   * ImmutableTargetAppCostWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTargetAppCostWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableTargetAppCostWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetAppCostWidgetParameters.equals(Object)",
    "int ImmutableTargetAppCostWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableTargetAppCostWidgetParameters immutableTargetAppCostWidgetParameters =
        ImmutableTargetAppCostWidgetParameters.builder()
            .targetDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertEquals(immutableTargetAppCostWidgetParameters, immutableTargetAppCostWidgetParameters);
    int expectedHashCodeResult = immutableTargetAppCostWidgetParameters.hashCode();
    assertEquals(expectedHashCodeResult, immutableTargetAppCostWidgetParameters.hashCode());
  }

  /**
   * Test {@link ImmutableTargetAppCostWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetAppCostWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetAppCostWidgetParameters.equals(Object)",
    "int ImmutableTargetAppCostWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableTargetAppCostWidgetParameters immutableTargetAppCostWidgetParameters =
        ImmutableTargetAppCostWidgetParameters.builder().targetDate(LocalDate.now()).build();

    // Act and Assert
    assertNotEquals(
        immutableTargetAppCostWidgetParameters,
        ImmutableTargetAppCostWidgetParameters.builder()
            .targetDate(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableTargetAppCostWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetAppCostWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetAppCostWidgetParameters.equals(Object)",
    "int ImmutableTargetAppCostWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableTargetAppCostWidgetParameters.builder()
            .targetDate(LocalDate.of(1970, 1, 1))
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableTargetAppCostWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetAppCostWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTargetAppCostWidgetParameters.equals(Object)",
    "int ImmutableTargetAppCostWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableTargetAppCostWidgetParameters.builder()
            .targetDate(LocalDate.of(1970, 1, 1))
            .build(),
        "Different type to ImmutableTargetAppCostWidgetParameters");
  }

  /**
   * Test {@link ImmutableTargetAppCostWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return targetDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTargetAppCostWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return targetDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTargetAppCostWidgetParameters ImmutableTargetAppCostWidgetParameters.fromJson(Json)"
  })
  void testFromJson_thenReturnTargetDateToStringIs19700101() {
    // Arrange
    Json json = new Json();
    LocalDate targetDate = LocalDate.of(1970, 1, 1);
    json.setTargetDate(targetDate);

    // Act
    ImmutableTargetAppCostWidgetParameters actualFromJsonResult =
        ImmutableTargetAppCostWidgetParameters.fromJson(json);

    // Assert
    LocalDate targetDateResult = actualFromJsonResult.targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertSame(targetDate, targetDateResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTargetAppCostWidgetParameters#toString()}
   *   <li>{@link ImmutableTargetAppCostWidgetParameters#targetDate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalDate ImmutableTargetAppCostWidgetParameters.targetDate()",
    "String ImmutableTargetAppCostWidgetParameters.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate targetDate = LocalDate.of(1970, 1, 1);
    ImmutableTargetAppCostWidgetParameters immutableTargetAppCostWidgetParameters =
        ImmutableTargetAppCostWidgetParameters.builder().targetDate(targetDate).build();

    // Act
    String actualToStringResult = immutableTargetAppCostWidgetParameters.toString();
    LocalDate actualTargetDateResult = immutableTargetAppCostWidgetParameters.targetDate();

    // Assert
    assertEquals("1970-01-01", actualTargetDateResult.toString());
    assertEquals("TargetAppCostWidgetParameters{targetDate=1970-01-01}", actualToStringResult);
    assertSame(targetDate, actualTargetDateResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setTargetDate(LocalDate)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setTargetDate(LocalDate)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setTargetDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals("1970-01-01", actualJson.targetDate.toString());
  }

  /**
   * Test Json {@link Json#targetDate()}.
   *
   * <p>Method under test: {@link Json#targetDate()}
   */
  @Test
  @DisplayName("Test Json targetDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate Json.targetDate()"})
  void testJsonTargetDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetDate());
  }

  /**
   * Test {@link ImmutableTargetAppCostWidgetParameters#withTargetDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableTargetAppCostWidgetParameters#withTargetDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withTargetDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTargetAppCostWidgetParameters ImmutableTargetAppCostWidgetParameters.withTargetDate(LocalDate)"
  })
  void testWithTargetDate() {
    // Arrange
    ImmutableTargetAppCostWidgetParameters immutableTargetAppCostWidgetParameters =
        ImmutableTargetAppCostWidgetParameters.builder()
            .targetDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableTargetAppCostWidgetParameters actualWithTargetDateResult =
        immutableTargetAppCostWidgetParameters.withTargetDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableTargetAppCostWidgetParameters, actualWithTargetDateResult);
  }
}
