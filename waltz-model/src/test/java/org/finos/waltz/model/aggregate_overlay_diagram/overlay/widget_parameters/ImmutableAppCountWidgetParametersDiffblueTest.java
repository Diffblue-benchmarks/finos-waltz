package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAppCountWidgetParameters.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAppCountWidgetParameters.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppCountWidgetParametersDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppCountWidgetParameters Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    LocalDate targetDate = LocalDate.of(1970, 1, 1);

    // Act and Assert
    LocalDate targetDateResult =
        ImmutableAppCountWidgetParameters.builder().targetDate(targetDate).build().targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertSame(targetDate, targetDateResult);
  }

  /**
   * Test Builder {@link Builder#from(AppCountWidgetParameters)}.
   *
   * <p>Method under test: {@link Builder#from(AppCountWidgetParameters)}
   */
  @Test
  @DisplayName("Test Builder from(AppCountWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppCountWidgetParameters)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAppCountWidgetParameters.builder();
    ImmutableAppCountWidgetParameters instance =
        ImmutableAppCountWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppCountWidgetParameters actualImmutableAppCountWidgetParameters =
        builderResult.build();
    assertEquals(instance, actualImmutableAppCountWidgetParameters);
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
    Builder builderResult = ImmutableAppCountWidgetParameters.builder();
    LocalDate targetDate = LocalDate.of(1970, 1, 1);

    // Act
    Builder actualTargetDateResult = builderResult.targetDate(targetDate);

    // Assert
    assertSame(targetDate, builderResult.build().targetDate());
    assertSame(builderResult, actualTargetDateResult);
  }

  /**
   * Test {@link ImmutableAppCountWidgetParameters#copyOf(AppCountWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return targetDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAppCountWidgetParameters#copyOf(AppCountWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AppCountWidgetParameters); then return targetDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppCountWidgetParameters ImmutableAppCountWidgetParameters.copyOf(AppCountWidgetParameters)"
  })
  void testCopyOf_thenReturnTargetDateToStringIs19700101() {
    // Arrange
    LocalDate targetDate = LocalDate.of(1970, 1, 1);
    ImmutableAppCountWidgetParameters instance =
        ImmutableAppCountWidgetParameters.builder().targetDate(targetDate).build();

    // Act and Assert
    LocalDate targetDateResult = ImmutableAppCountWidgetParameters.copyOf(instance).targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertSame(targetDate, targetDateResult);
  }

  /**
   * Test {@link ImmutableAppCountWidgetParameters#equals(Object)}, and {@link
   * ImmutableAppCountWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppCountWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableAppCountWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppCountWidgetParameters.equals(Object)",
    "int ImmutableAppCountWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAppCountWidgetParameters immutableAppCountWidgetParameters =
        ImmutableAppCountWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build();
    ImmutableAppCountWidgetParameters immutableAppCountWidgetParameters2 =
        ImmutableAppCountWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build();

    // Act and Assert
    assertEquals(immutableAppCountWidgetParameters, immutableAppCountWidgetParameters2);
    assertEquals(
        immutableAppCountWidgetParameters.hashCode(),
        immutableAppCountWidgetParameters2.hashCode());
  }

  /**
   * Test {@link ImmutableAppCountWidgetParameters#equals(Object)}, and {@link
   * ImmutableAppCountWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppCountWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableAppCountWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppCountWidgetParameters.equals(Object)",
    "int ImmutableAppCountWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAppCountWidgetParameters immutableAppCountWidgetParameters =
        ImmutableAppCountWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build();

    // Act and Assert
    assertEquals(immutableAppCountWidgetParameters, immutableAppCountWidgetParameters);
    int expectedHashCodeResult = immutableAppCountWidgetParameters.hashCode();
    assertEquals(expectedHashCodeResult, immutableAppCountWidgetParameters.hashCode());
  }

  /**
   * Test {@link ImmutableAppCountWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppCountWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppCountWidgetParameters.equals(Object)",
    "int ImmutableAppCountWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAppCountWidgetParameters immutableAppCountWidgetParameters =
        ImmutableAppCountWidgetParameters.builder().targetDate(LocalDate.now()).build();

    // Act and Assert
    assertNotEquals(
        immutableAppCountWidgetParameters,
        ImmutableAppCountWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build());
  }

  /**
   * Test {@link ImmutableAppCountWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppCountWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppCountWidgetParameters.equals(Object)",
    "int ImmutableAppCountWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAppCountWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build(),
        null);
  }

  /**
   * Test {@link ImmutableAppCountWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppCountWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppCountWidgetParameters.equals(Object)",
    "int ImmutableAppCountWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAppCountWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build(),
        "Different type to ImmutableAppCountWidgetParameters");
  }

  /**
   * Test {@link ImmutableAppCountWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return targetDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppCountWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return targetDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppCountWidgetParameters ImmutableAppCountWidgetParameters.fromJson(Json)"
  })
  void testFromJson_thenReturnTargetDateToStringIs19700101() {
    // Arrange
    Json json = new Json();
    LocalDate targetDate = LocalDate.of(1970, 1, 1);
    json.setTargetDate(targetDate);

    // Act
    ImmutableAppCountWidgetParameters actualFromJsonResult =
        ImmutableAppCountWidgetParameters.fromJson(json);

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
   *   <li>{@link ImmutableAppCountWidgetParameters#toString()}
   *   <li>{@link ImmutableAppCountWidgetParameters#targetDate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalDate ImmutableAppCountWidgetParameters.targetDate()",
    "String ImmutableAppCountWidgetParameters.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate targetDate = LocalDate.of(1970, 1, 1);
    ImmutableAppCountWidgetParameters immutableAppCountWidgetParameters =
        ImmutableAppCountWidgetParameters.builder().targetDate(targetDate).build();

    // Act
    String actualToStringResult = immutableAppCountWidgetParameters.toString();
    LocalDate actualTargetDateResult = immutableAppCountWidgetParameters.targetDate();

    // Assert
    assertEquals("1970-01-01", actualTargetDateResult.toString());
    assertEquals("AppCountWidgetParameters{targetDate=1970-01-01}", actualToStringResult);
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
   * Test {@link ImmutableAppCountWidgetParameters#withTargetDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableAppCountWidgetParameters#withTargetDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withTargetDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppCountWidgetParameters ImmutableAppCountWidgetParameters.withTargetDate(LocalDate)"
  })
  void testWithTargetDate() {
    // Arrange
    ImmutableAppCountWidgetParameters immutableAppCountWidgetParameters =
        ImmutableAppCountWidgetParameters.builder().targetDate(LocalDate.of(1970, 1, 1)).build();

    // Act
    ImmutableAppCountWidgetParameters actualWithTargetDateResult =
        immutableAppCountWidgetParameters.withTargetDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableAppCountWidgetParameters, actualWithTargetDateResult);
  }
}
