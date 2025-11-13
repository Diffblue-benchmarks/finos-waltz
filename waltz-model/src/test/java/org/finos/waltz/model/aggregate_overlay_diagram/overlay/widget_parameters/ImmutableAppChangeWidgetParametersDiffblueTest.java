package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAppChangeWidgetParameters.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAppChangeWidgetParameters.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppChangeWidgetParametersDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppChangeWidgetParameters Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    LocalDate targetDate = LocalDate.of(1970, 1, 1);

    // Act and Assert
    LocalDate targetDateResult =
        ImmutableAppChangeWidgetParameters.builder().targetDate(targetDate).build().targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertSame(targetDate, targetDateResult);
  }

  /**
   * Test Builder {@link Builder#from(AppChangeWidgetParameters)}.
   *
   * <p>Method under test: {@link Builder#from(AppChangeWidgetParameters)}
   */
  @Test
  @DisplayName("Test Builder from(AppChangeWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppChangeWidgetParameters)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAppChangeWidgetParameters.builder();
    ImmutableAppChangeWidgetParameters instance =
        ImmutableAppChangeWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppChangeWidgetParameters actualImmutableAppChangeWidgetParameters =
        builderResult.build();
    assertEquals(instance, actualImmutableAppChangeWidgetParameters);
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
    Builder builderResult = ImmutableAppChangeWidgetParameters.builder();
    LocalDate targetDate = LocalDate.of(1970, 1, 1);

    // Act
    Builder actualTargetDateResult = builderResult.targetDate(targetDate);

    // Assert
    assertSame(targetDate, builderResult.build().targetDate());
    assertSame(builderResult, actualTargetDateResult);
  }

  /**
   * Test {@link ImmutableAppChangeWidgetParameters#copyOf(AppChangeWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return targetDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAppChangeWidgetParameters#copyOf(AppChangeWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AppChangeWidgetParameters); then return targetDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppChangeWidgetParameters ImmutableAppChangeWidgetParameters.copyOf(AppChangeWidgetParameters)"
  })
  void testCopyOf_thenReturnTargetDateToStringIs19700101() {
    // Arrange
    LocalDate targetDate = LocalDate.of(1970, 1, 1);
    ImmutableAppChangeWidgetParameters instance =
        ImmutableAppChangeWidgetParameters.builder().targetDate(targetDate).build();

    // Act and Assert
    LocalDate targetDateResult = ImmutableAppChangeWidgetParameters.copyOf(instance).targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertSame(targetDate, targetDateResult);
  }

  /**
   * Test {@link ImmutableAppChangeWidgetParameters#equals(Object)}, and {@link
   * ImmutableAppChangeWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppChangeWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableAppChangeWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeWidgetParameters.equals(Object)",
    "int ImmutableAppChangeWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAppChangeWidgetParameters immutableAppChangeWidgetParameters =
        ImmutableAppChangeWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build();
    ImmutableAppChangeWidgetParameters immutableAppChangeWidgetParameters2 =
        ImmutableAppChangeWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build();

    // Act and Assert
    assertEquals(immutableAppChangeWidgetParameters, immutableAppChangeWidgetParameters2);
    assertEquals(
        immutableAppChangeWidgetParameters.hashCode(),
        immutableAppChangeWidgetParameters2.hashCode());
  }

  /**
   * Test {@link ImmutableAppChangeWidgetParameters#equals(Object)}, and {@link
   * ImmutableAppChangeWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppChangeWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableAppChangeWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeWidgetParameters.equals(Object)",
    "int ImmutableAppChangeWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAppChangeWidgetParameters immutableAppChangeWidgetParameters =
        ImmutableAppChangeWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build();

    // Act and Assert
    assertEquals(immutableAppChangeWidgetParameters, immutableAppChangeWidgetParameters);
    int expectedHashCodeResult = immutableAppChangeWidgetParameters.hashCode();
    assertEquals(expectedHashCodeResult, immutableAppChangeWidgetParameters.hashCode());
  }

  /**
   * Test {@link ImmutableAppChangeWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeWidgetParameters.equals(Object)",
    "int ImmutableAppChangeWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAppChangeWidgetParameters immutableAppChangeWidgetParameters =
        ImmutableAppChangeWidgetParameters.builder().targetDate(LocalDate.now()).build();

    // Act and Assert
    assertNotEquals(
        immutableAppChangeWidgetParameters,
        ImmutableAppChangeWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build());
  }

  /**
   * Test {@link ImmutableAppChangeWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeWidgetParameters.equals(Object)",
    "int ImmutableAppChangeWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAppChangeWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build(),
        null);
  }

  /**
   * Test {@link ImmutableAppChangeWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppChangeWidgetParameters.equals(Object)",
    "int ImmutableAppChangeWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAppChangeWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build(),
        "Different type to ImmutableAppChangeWidgetParameters");
  }

  /**
   * Test {@link ImmutableAppChangeWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return targetDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppChangeWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return targetDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppChangeWidgetParameters ImmutableAppChangeWidgetParameters.fromJson(Json)"
  })
  void testFromJson_thenReturnTargetDateToStringIs19700101() {
    // Arrange
    Json json = new Json();
    LocalDate targetDate = LocalDate.of(1970, 1, 1);
    json.setTargetDate(targetDate);

    // Act
    ImmutableAppChangeWidgetParameters actualFromJsonResult =
        ImmutableAppChangeWidgetParameters.fromJson(json);

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
   *   <li>{@link ImmutableAppChangeWidgetParameters#toString()}
   *   <li>{@link ImmutableAppChangeWidgetParameters#targetDate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalDate ImmutableAppChangeWidgetParameters.targetDate()",
    "String ImmutableAppChangeWidgetParameters.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate targetDate = LocalDate.of(1970, 1, 1);
    ImmutableAppChangeWidgetParameters immutableAppChangeWidgetParameters =
        ImmutableAppChangeWidgetParameters.builder().targetDate(targetDate).build();

    // Act
    String actualToStringResult = immutableAppChangeWidgetParameters.toString();
    LocalDate actualTargetDateResult = immutableAppChangeWidgetParameters.targetDate();

    // Assert
    assertEquals("1970-01-01", actualTargetDateResult.toString());
    assertEquals("AppChangeWidgetParameters{targetDate=1970-01-01}", actualToStringResult);
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
   * Test {@link ImmutableAppChangeWidgetParameters#withTargetDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableAppChangeWidgetParameters#withTargetDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withTargetDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppChangeWidgetParameters ImmutableAppChangeWidgetParameters.withTargetDate(LocalDate)"
  })
  void testWithTargetDate() {
    // Arrange
    ImmutableAppChangeWidgetParameters immutableAppChangeWidgetParameters =
        ImmutableAppChangeWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build();

    // Act
    ImmutableAppChangeWidgetParameters actualWithTargetDateResult =
        immutableAppChangeWidgetParameters.withTargetDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableAppChangeWidgetParameters, actualWithTargetDateResult);
  }
}
