package org.finos.waltz.service.workflow.side_effect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.service.workflow.side_effect.ImmutableAssessmentRatingUpdateSideEffect.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingUpdateSideEffectDiffblueTest {
  /**
   * Test Builder {@link Builder#assessmentDefinitionExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#assessmentDefinitionExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test Builder assessmentDefinitionExternalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessmentDefinitionExternalId(String)"})
  void testBuilderAssessmentDefinitionExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingUpdateSideEffect.builder();

    // Act
    Builder actualAssessmentDefinitionExternalIdResult =
        builderResult.assessmentDefinitionExternalId("42");

    // Assert
    assertSame(builderResult, actualAssessmentDefinitionExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRatingUpdateSideEffect Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAssessmentRatingUpdateSideEffect actualImmutableAssessmentRatingUpdateSideEffect =
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("42")
            .ratingSchemeItemExternalId("42")
            .build();

    // Assert
    assertEquals(
        "42", actualImmutableAssessmentRatingUpdateSideEffect.assessmentDefinitionExternalId());
    assertEquals(
        "42", actualImmutableAssessmentRatingUpdateSideEffect.ratingSchemeItemExternalId());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingUpdateSideEffect)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingUpdateSideEffect)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingUpdateSideEffect)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingUpdateSideEffect)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingUpdateSideEffect.builder();
    ImmutableAssessmentRatingUpdateSideEffect instance =
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("42")
            .ratingSchemeItemExternalId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingUpdateSideEffect actualImmutableAssessmentRatingUpdateSideEffect =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingUpdateSideEffect);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingSchemeItemExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingSchemeItemExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeItemExternalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingSchemeItemExternalId(String)"})
  void testBuilderRatingSchemeItemExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingUpdateSideEffect.builder();

    // Act
    Builder actualRatingSchemeItemExternalIdResult = builderResult.ratingSchemeItemExternalId("42");

    // Assert
    assertSame(builderResult, actualRatingSchemeItemExternalIdResult);
  }

  /**
   * Test {@link
   * ImmutableAssessmentRatingUpdateSideEffect#copyOf(AssessmentRatingUpdateSideEffect)}.
   *
   * <ul>
   *   <li>Then return assessmentDefinitionExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingUpdateSideEffect#copyOf(AssessmentRatingUpdateSideEffect)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentRatingUpdateSideEffect); then return assessmentDefinitionExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingUpdateSideEffect ImmutableAssessmentRatingUpdateSideEffect.copyOf(AssessmentRatingUpdateSideEffect)"
  })
  void testCopyOf_thenReturnAssessmentDefinitionExternalIdIs42() {
    // Arrange
    ImmutableAssessmentRatingUpdateSideEffect instance =
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("42")
            .ratingSchemeItemExternalId("42")
            .build();

    // Act
    ImmutableAssessmentRatingUpdateSideEffect actualCopyOfResult =
        ImmutableAssessmentRatingUpdateSideEffect.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.assessmentDefinitionExternalId());
    assertEquals("42", actualCopyOfResult.ratingSchemeItemExternalId());
  }

  /**
   * Test {@link ImmutableAssessmentRatingUpdateSideEffect#equals(Object)}, and {@link
   * ImmutableAssessmentRatingUpdateSideEffect#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingUpdateSideEffect#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingUpdateSideEffect#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingUpdateSideEffect.equals(Object)",
    "int ImmutableAssessmentRatingUpdateSideEffect.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRatingUpdateSideEffect immutableAssessmentRatingUpdateSideEffect =
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("42")
            .ratingSchemeItemExternalId("42")
            .build();
    ImmutableAssessmentRatingUpdateSideEffect immutableAssessmentRatingUpdateSideEffect2 =
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("42")
            .ratingSchemeItemExternalId("42")
            .build();

    // Act and Assert
    assertEquals(
        immutableAssessmentRatingUpdateSideEffect, immutableAssessmentRatingUpdateSideEffect2);
    assertEquals(
        immutableAssessmentRatingUpdateSideEffect.hashCode(),
        immutableAssessmentRatingUpdateSideEffect2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingUpdateSideEffect#equals(Object)}, and {@link
   * ImmutableAssessmentRatingUpdateSideEffect#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingUpdateSideEffect#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingUpdateSideEffect#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingUpdateSideEffect.equals(Object)",
    "int ImmutableAssessmentRatingUpdateSideEffect.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRatingUpdateSideEffect immutableAssessmentRatingUpdateSideEffect =
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("42")
            .ratingSchemeItemExternalId("42")
            .build();

    // Act and Assert
    assertEquals(
        immutableAssessmentRatingUpdateSideEffect, immutableAssessmentRatingUpdateSideEffect);
    int expectedHashCodeResult = immutableAssessmentRatingUpdateSideEffect.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentRatingUpdateSideEffect.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingUpdateSideEffect#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingUpdateSideEffect#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingUpdateSideEffect.equals(Object)",
    "int ImmutableAssessmentRatingUpdateSideEffect.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAssessmentRatingUpdateSideEffect immutableAssessmentRatingUpdateSideEffect =
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("Assessment Definition External Id")
            .ratingSchemeItemExternalId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingUpdateSideEffect,
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("42")
            .ratingSchemeItemExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingUpdateSideEffect#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingUpdateSideEffect#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingUpdateSideEffect.equals(Object)",
    "int ImmutableAssessmentRatingUpdateSideEffect.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAssessmentRatingUpdateSideEffect immutableAssessmentRatingUpdateSideEffect =
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("42")
            .ratingSchemeItemExternalId("Rating Scheme Item External Id")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingUpdateSideEffect,
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("42")
            .ratingSchemeItemExternalId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingUpdateSideEffect#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingUpdateSideEffect#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingUpdateSideEffect.equals(Object)",
    "int ImmutableAssessmentRatingUpdateSideEffect.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("42")
            .ratingSchemeItemExternalId("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssessmentRatingUpdateSideEffect#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingUpdateSideEffect#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingUpdateSideEffect.equals(Object)",
    "int ImmutableAssessmentRatingUpdateSideEffect.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("42")
            .ratingSchemeItemExternalId("42")
            .build(),
        "Different type to ImmutableAssessmentRatingUpdateSideEffect");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingUpdateSideEffect#toString()}
   *   <li>{@link ImmutableAssessmentRatingUpdateSideEffect#assessmentDefinitionExternalId()}
   *   <li>{@link ImmutableAssessmentRatingUpdateSideEffect#ratingSchemeItemExternalId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableAssessmentRatingUpdateSideEffect.assessmentDefinitionExternalId()",
    "String ImmutableAssessmentRatingUpdateSideEffect.ratingSchemeItemExternalId()",
    "String ImmutableAssessmentRatingUpdateSideEffect.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAssessmentRatingUpdateSideEffect immutableAssessmentRatingUpdateSideEffect =
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("42")
            .ratingSchemeItemExternalId("42")
            .build();

    // Act
    String actualToStringResult = immutableAssessmentRatingUpdateSideEffect.toString();
    String actualAssessmentDefinitionExternalIdResult =
        immutableAssessmentRatingUpdateSideEffect.assessmentDefinitionExternalId();

    // Assert
    assertEquals("42", actualAssessmentDefinitionExternalIdResult);
    assertEquals("42", immutableAssessmentRatingUpdateSideEffect.ratingSchemeItemExternalId());
    assertEquals(
        "AssessmentRatingUpdateSideEffect{assessmentDefinitionExternalId=42, ratingSchemeItemExternalId=42}",
        actualToStringResult);
  }

  /**
   * Test {@link
   * ImmutableAssessmentRatingUpdateSideEffect#withAssessmentDefinitionExternalId(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingUpdateSideEffect#withAssessmentDefinitionExternalId(String)}
   */
  @Test
  @DisplayName("Test withAssessmentDefinitionExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingUpdateSideEffect ImmutableAssessmentRatingUpdateSideEffect.withAssessmentDefinitionExternalId(String)"
  })
  void testWithAssessmentDefinitionExternalId() {
    // Arrange
    ImmutableAssessmentRatingUpdateSideEffect immutableAssessmentRatingUpdateSideEffect =
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("42")
            .ratingSchemeItemExternalId("42")
            .build();

    // Act
    ImmutableAssessmentRatingUpdateSideEffect actualWithAssessmentDefinitionExternalIdResult =
        immutableAssessmentRatingUpdateSideEffect.withAssessmentDefinitionExternalId("42");

    // Assert
    assertSame(
        immutableAssessmentRatingUpdateSideEffect, actualWithAssessmentDefinitionExternalIdResult);
  }

  /**
   * Test {@link
   * ImmutableAssessmentRatingUpdateSideEffect#withAssessmentDefinitionExternalId(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingUpdateSideEffect#withAssessmentDefinitionExternalId(String)}
   */
  @Test
  @DisplayName("Test withAssessmentDefinitionExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingUpdateSideEffect ImmutableAssessmentRatingUpdateSideEffect.withAssessmentDefinitionExternalId(String)"
  })
  void testWithAssessmentDefinitionExternalId2() {
    // Arrange and Act
    ImmutableAssessmentRatingUpdateSideEffect actualWithAssessmentDefinitionExternalIdResult =
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("assessmentDefinitionExternalId")
            .ratingSchemeItemExternalId("42")
            .build()
            .withAssessmentDefinitionExternalId("42");

    // Assert
    assertEquals(
        "42", actualWithAssessmentDefinitionExternalIdResult.assessmentDefinitionExternalId());
    assertEquals("42", actualWithAssessmentDefinitionExternalIdResult.ratingSchemeItemExternalId());
  }

  /**
   * Test {@link ImmutableAssessmentRatingUpdateSideEffect#withRatingSchemeItemExternalId(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingUpdateSideEffect#withRatingSchemeItemExternalId(String)}
   */
  @Test
  @DisplayName("Test withRatingSchemeItemExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingUpdateSideEffect ImmutableAssessmentRatingUpdateSideEffect.withRatingSchemeItemExternalId(String)"
  })
  void testWithRatingSchemeItemExternalId() {
    // Arrange
    ImmutableAssessmentRatingUpdateSideEffect immutableAssessmentRatingUpdateSideEffect =
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("42")
            .ratingSchemeItemExternalId("42")
            .build();

    // Act
    ImmutableAssessmentRatingUpdateSideEffect actualWithRatingSchemeItemExternalIdResult =
        immutableAssessmentRatingUpdateSideEffect.withRatingSchemeItemExternalId("42");

    // Assert
    assertSame(
        immutableAssessmentRatingUpdateSideEffect, actualWithRatingSchemeItemExternalIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingUpdateSideEffect#withRatingSchemeItemExternalId(String)}.
   *
   * <ul>
   *   <li>Then return assessmentDefinitionExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingUpdateSideEffect#withRatingSchemeItemExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withRatingSchemeItemExternalId(String); then return assessmentDefinitionExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingUpdateSideEffect ImmutableAssessmentRatingUpdateSideEffect.withRatingSchemeItemExternalId(String)"
  })
  void testWithRatingSchemeItemExternalId_thenReturnAssessmentDefinitionExternalIdIs42() {
    // Arrange and Act
    ImmutableAssessmentRatingUpdateSideEffect actualWithRatingSchemeItemExternalIdResult =
        ImmutableAssessmentRatingUpdateSideEffect.builder()
            .assessmentDefinitionExternalId("42")
            .ratingSchemeItemExternalId("ratingSchemeItemExternalId")
            .build()
            .withRatingSchemeItemExternalId("42");

    // Assert
    assertEquals("42", actualWithRatingSchemeItemExternalIdResult.assessmentDefinitionExternalId());
    assertEquals("42", actualWithRatingSchemeItemExternalIdResult.ratingSchemeItemExternalId());
  }
}
