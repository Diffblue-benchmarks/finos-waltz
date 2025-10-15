package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAssessmentWidgetParameters.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAssessmentWidgetParameters.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentWidgetParametersDiffblueTest {
  /**
   * Test {@link ImmutableAssessmentWidgetParameters#assessmentDefinitionId()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentWidgetParameters#assessmentDefinitionId()}
   */
  @Test
  @DisplayName("Test assessmentDefinitionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ImmutableAssessmentWidgetParameters.assessmentDefinitionId()"})
  void testAssessmentDefinitionId() {
    // Arrange, Act and Assert
    assertEquals(
        1L,
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build()
            .assessmentDefinitionId()
            .longValue());
  }

  /**
   * Test Builder {@link Builder#assessmentDefinitionId(Long)}.
   *
   * <p>Method under test: {@link Builder#assessmentDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test Builder assessmentDefinitionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessmentDefinitionId(Long)"})
  void testBuilderAssessmentDefinitionId() {
    // Arrange
    Builder builderResult = ImmutableAssessmentWidgetParameters.builder();

    // Act
    Builder actualAssessmentDefinitionIdResult = builderResult.assessmentDefinitionId(1L);

    // Assert
    assertEquals(1L, builderResult.build().assessmentDefinitionId().longValue());
    assertSame(builderResult, actualAssessmentDefinitionIdResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#targetDate(LocalDate)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentWidgetParameters Builder.build()",
    "Builder Builder.targetDate(LocalDate)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualTargetDateResult =
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1));
    Optional<? extends LocalDate> targetDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(
        1L,
        actualTargetDateResult.targetDate(targetDate).build().assessmentDefinitionId().longValue());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentWidgetParameters)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentWidgetParameters)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentWidgetParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentWidgetParameters)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentWidgetParameters.builder();
    ImmutableAssessmentWidgetParameters instance =
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentWidgetParameters actualImmutableAssessmentWidgetParameters =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentWidgetParameters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#targetDate(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#targetDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder targetDate(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetDate(Optional)"})
  void testBuilderTargetDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAssessmentWidgetParameters.builder();
    Optional<? extends LocalDate> targetDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    Builder actualTargetDateResult = builderResult.targetDate(targetDate);

    // Assert
    assertSame(builderResult, actualTargetDateResult);
  }

  /**
   * Test {@link ImmutableAssessmentWidgetParameters#copyOf(AssessmentWidgetParameters)}.
   *
   * <ul>
   *   <li>Then return assessmentDefinitionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentWidgetParameters#copyOf(AssessmentWidgetParameters)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentWidgetParameters); then return assessmentDefinitionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentWidgetParameters ImmutableAssessmentWidgetParameters.copyOf(AssessmentWidgetParameters)"
  })
  void testCopyOf_thenReturnAssessmentDefinitionIdLongValueIsOne() {
    // Arrange
    ImmutableAssessmentWidgetParameters instance =
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertEquals(
        1L,
        ImmutableAssessmentWidgetParameters.copyOf(instance).assessmentDefinitionId().longValue());
  }

  /**
   * Test {@link ImmutableAssessmentWidgetParameters#equals(Object)}, and {@link
   * ImmutableAssessmentWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableAssessmentWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentWidgetParameters.equals(Object)",
    "int ImmutableAssessmentWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentWidgetParameters immutableAssessmentWidgetParameters =
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build();
    ImmutableAssessmentWidgetParameters immutableAssessmentWidgetParameters2 =
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentWidgetParameters, immutableAssessmentWidgetParameters2);
    assertEquals(
        immutableAssessmentWidgetParameters.hashCode(),
        immutableAssessmentWidgetParameters2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentWidgetParameters#equals(Object)}, and {@link
   * ImmutableAssessmentWidgetParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentWidgetParameters#equals(Object)}
   *   <li>{@link ImmutableAssessmentWidgetParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentWidgetParameters.equals(Object)",
    "int ImmutableAssessmentWidgetParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentWidgetParameters immutableAssessmentWidgetParameters =
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentWidgetParameters, immutableAssessmentWidgetParameters);
    int expectedHashCodeResult = immutableAssessmentWidgetParameters.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentWidgetParameters.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentWidgetParameters.equals(Object)",
    "int ImmutableAssessmentWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAssessmentWidgetParameters immutableAssessmentWidgetParameters =
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(2L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentWidgetParameters,
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentWidgetParameters.equals(Object)",
    "int ImmutableAssessmentWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAssessmentWidgetParameters immutableAssessmentWidgetParameters =
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.now())
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentWidgetParameters,
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentWidgetParameters.equals(Object)",
    "int ImmutableAssessmentWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssessmentWidgetParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentWidgetParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentWidgetParameters.equals(Object)",
    "int ImmutableAssessmentWidgetParameters.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build(),
        "Different type to ImmutableAssessmentWidgetParameters");
  }

  /**
   * Test {@link ImmutableAssessmentWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@link LocalDate} with {@code 1970} and one and one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given of LocalDate with '1970' and one and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentWidgetParameters ImmutableAssessmentWidgetParameters.fromJson(Json)"
  })
  void testFromJson_givenOfLocalDateWith1970AndOneAndOne() {
    // Arrange
    Json json = new Json();
    json.setAssessmentDefinitionId(1L);
    Optional<LocalDate> targetDate = Optional.of(LocalDate.of(1970, 1, 1));
    json.setTargetDate(targetDate);

    // Act
    ImmutableAssessmentWidgetParameters actualFromJsonResult =
        ImmutableAssessmentWidgetParameters.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.assessmentDefinitionId().longValue());
  }

  /**
   * Test {@link ImmutableAssessmentWidgetParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return assessmentDefinitionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentWidgetParameters#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given one; then return assessmentDefinitionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentWidgetParameters ImmutableAssessmentWidgetParameters.fromJson(Json)"
  })
  void testFromJson_givenOne_thenReturnAssessmentDefinitionIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setAssessmentDefinitionId(1L);
    json.setTargetDate(null);

    // Act
    ImmutableAssessmentWidgetParameters actualFromJsonResult =
        ImmutableAssessmentWidgetParameters.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.assessmentDefinitionId().longValue());
  }

  /**
   * Test Json {@link Json#assessmentDefinitionId()}.
   *
   * <p>Method under test: {@link Json#assessmentDefinitionId()}
   */
  @Test
  @DisplayName("Test Json assessmentDefinitionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.assessmentDefinitionId()"})
  void testJsonAssessmentDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assessmentDefinitionId());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.assessmentDefinitionId);
    assertFalse(actualJson.targetDate.isPresent());
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
  @MethodsUnderTest({"Optional Json.targetDate()"})
  void testJsonTargetDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetDate());
  }

  /**
   * Test {@link ImmutableAssessmentWidgetParameters#targetDate()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentWidgetParameters#targetDate()}
   */
  @Test
  @DisplayName("Test targetDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAssessmentWidgetParameters.targetDate()"})
  void testTargetDate() {
    // Arrange
    LocalDate targetDate = LocalDate.of(1970, 1, 1);

    // Act
    Optional<LocalDate> actualTargetDateResult =
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(targetDate)
            .build()
            .targetDate();

    // Assert
    LocalDate getResult = actualTargetDateResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(actualTargetDateResult.isPresent());
    assertSame(targetDate, getResult);
  }

  /**
   * Test {@link ImmutableAssessmentWidgetParameters#toString()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentWidgetParameters#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableAssessmentWidgetParameters.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "AssessmentWidgetParameters{assessmentDefinitionId=1, targetDate=1970-01-01}",
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAssessmentWidgetParameters#withAssessmentDefinitionId(Long)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentWidgetParameters#withAssessmentDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test withAssessmentDefinitionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentWidgetParameters ImmutableAssessmentWidgetParameters.withAssessmentDefinitionId(Long)"
  })
  void testWithAssessmentDefinitionId() {
    // Arrange, Act and Assert
    assertEquals(
        42L,
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build()
            .withAssessmentDefinitionId(42L)
            .assessmentDefinitionId()
            .longValue());
  }

  /**
   * Test {@link ImmutableAssessmentWidgetParameters#withAssessmentDefinitionId(Long)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentWidgetParameters#withAssessmentDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test withAssessmentDefinitionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentWidgetParameters ImmutableAssessmentWidgetParameters.withAssessmentDefinitionId(Long)"
  })
  void testWithAssessmentDefinitionId2() {
    // Arrange
    ImmutableAssessmentWidgetParameters immutableAssessmentWidgetParameters =
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableAssessmentWidgetParameters actualWithAssessmentDefinitionIdResult =
        immutableAssessmentWidgetParameters.withAssessmentDefinitionId(1L);

    // Assert
    assertSame(immutableAssessmentWidgetParameters, actualWithAssessmentDefinitionIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentWidgetParameters#withTargetDate(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableAssessmentWidgetParameters#withTargetDate(Optional)}
   */
  @Test
  @DisplayName("Test withTargetDate(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentWidgetParameters ImmutableAssessmentWidgetParameters.withTargetDate(Optional)"
  })
  void testWithTargetDateWithOptional() {
    // Arrange
    ImmutableAssessmentWidgetParameters immutableAssessmentWidgetParameters =
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build();
    Optional<? extends LocalDate> optional = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    ImmutableAssessmentWidgetParameters actualWithTargetDateResult =
        immutableAssessmentWidgetParameters.withTargetDate(optional);

    // Assert
    assertEquals(immutableAssessmentWidgetParameters, actualWithTargetDateResult);
  }

  /**
   * Test {@link ImmutableAssessmentWidgetParameters#withTargetDate(LocalDate)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAssessmentWidgetParameters#withTargetDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withTargetDate(LocalDate) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentWidgetParameters ImmutableAssessmentWidgetParameters.withTargetDate(LocalDate)"
  })
  void testWithTargetDateWithValue() {
    // Arrange
    ImmutableAssessmentWidgetParameters immutableAssessmentWidgetParameters =
        ImmutableAssessmentWidgetParameters.builder()
            .assessmentDefinitionId(1L)
            .targetDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableAssessmentWidgetParameters actualWithTargetDateResult =
        immutableAssessmentWidgetParameters.withTargetDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableAssessmentWidgetParameters, actualWithTargetDateResult);
  }
}
