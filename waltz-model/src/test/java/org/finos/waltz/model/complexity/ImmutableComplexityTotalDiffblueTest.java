package org.finos.waltz.model.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.complexity.ImmutableComplexityTotal.Builder;
import org.finos.waltz.model.complexity.ImmutableComplexityTotal.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableComplexityTotalDiffblueTest {
  /**
   * Test Builder {@link Builder#average(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#average(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test Builder average(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.average(BigDecimal)"})
  void testBuilderAverage_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    // Act
    Builder actualAverageResult = builderResult.average(new BigDecimal("2.3"));

    // Assert
    assertSame(builderResult, actualAverageResult);
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
  @MethodsUnderTest({"ImmutableComplexityTotal Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableComplexityTotal.builder();
    BigDecimal average = new BigDecimal("2.3");
    Builder actualAverageResult = actualBuilderResult.average(average);
    ImmutableComplexityKind complexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualComplexityKindResult = actualAverageResult.complexityKind(complexityKind);
    BigDecimal standardDeviation = new BigDecimal("2.3");
    Builder actualStandardDeviationResult =
        actualComplexityKindResult.standardDeviation(standardDeviation);
    BigDecimal total = new BigDecimal("2.3");
    ImmutableComplexityTotal actualImmutableComplexityTotal =
        actualStandardDeviationResult.total(total).build();

    // Assert
    BigDecimal expectedAverageResult = new BigDecimal("2.3");
    BigDecimal averageResult = actualImmutableComplexityTotal.average();
    assertEquals(expectedAverageResult, averageResult);
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.3");
    BigDecimal standardDeviationResult = actualImmutableComplexityTotal.standardDeviation();
    assertEquals(expectedStandardDeviationResult, standardDeviationResult);
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualImmutableComplexityTotal.total();
    assertEquals(expectedTotalResult, totalResult);
    assertSame(average, averageResult);
    assertSame(standardDeviation, standardDeviationResult);
    assertSame(total, totalResult);
    assertSame(complexityKind, actualImmutableComplexityTotal.complexityKind());
  }

  /**
   * Test Builder {@link Builder#complexityKind(ComplexityKind)}.
   *
   * <ul>
   *   <li>When {@link ImmutableComplexityKind.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#complexityKind(ComplexityKind)}
   */
  @Test
  @DisplayName(
      "Test Builder complexityKind(ComplexityKind); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.complexityKind(ComplexityKind)"})
  void testBuilderComplexityKind_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    // Act
    Builder actualComplexityKindResult =
        builderResult.complexityKind(new ImmutableComplexityKind.Json());

    // Assert
    assertSame(builderResult, actualComplexityKindResult);
  }

  /**
   * Test Builder {@link Builder#from(ComplexityTotal)}.
   *
   * <p>Method under test: {@link Builder#from(ComplexityTotal)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityTotal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ComplexityTotal)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder builderResult2 = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult2.average(new BigDecimal("2.3"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("2.3"));
    ImmutableComplexityTotal instance =
        standardDeviationResult.total(new BigDecimal("2.3")).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableComplexityTotal actualImmutableComplexityTotal = builderResult.build();
    assertEquals(instance, actualImmutableComplexityTotal);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#standardDeviation(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#standardDeviation(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test Builder standardDeviation(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.standardDeviation(BigDecimal)"})
  void testBuilderStandardDeviation_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    // Act
    Builder actualStandardDeviationResult = builderResult.standardDeviation(new BigDecimal("2.3"));

    // Assert
    assertSame(builderResult, actualStandardDeviationResult);
  }

  /**
   * Test Builder {@link Builder#total(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#total(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test Builder total(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.total(BigDecimal)"})
  void testBuilderTotal_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    // Act
    Builder actualTotalResult = builderResult.total(new BigDecimal("2.3"));

    // Assert
    assertSame(builderResult, actualTotalResult);
  }

  /**
   * Test {@link ImmutableComplexityTotal#copyOf(ComplexityTotal)}.
   *
   * <ul>
   *   <li>Then complexityKind return {@link ImmutableComplexityKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityTotal#copyOf(ComplexityTotal)}
   */
  @Test
  @DisplayName("Test copyOf(ComplexityTotal); then complexityKind return ImmutableComplexityKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityTotal ImmutableComplexityTotal.copyOf(ComplexityTotal)"})
  void testCopyOf_thenComplexityKindReturnImmutableComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("2.3"));
    ImmutableComplexityTotal instance =
        standardDeviationResult.total(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexityTotal actualCopyOfResult = ImmutableComplexityTotal.copyOf(instance);

    // Assert
    ComplexityKind complexityKindResult2 = actualCopyOfResult.complexityKind();
    assertTrue(complexityKindResult2 instanceof ImmutableComplexityKind);
    assertEquals("Name", complexityKindResult2.name());
    assertEquals(
        "The characteristics of someone or something", complexityKindResult2.description());
    assertEquals(EntityKind.ALL, complexityKindResult2.kind());
    assertTrue(complexityKindResult2.isDefault());
    BigDecimal expectedAverageResult = new BigDecimal("2.3");
    assertEquals(expectedAverageResult, actualCopyOfResult.average());
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.3");
    assertEquals(expectedStandardDeviationResult, actualCopyOfResult.standardDeviation());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualCopyOfResult.total());
  }

  /**
   * Test {@link ImmutableComplexityTotal#equals(Object)}, and {@link
   * ImmutableComplexityTotal#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplexityTotal#equals(Object)}
   *   <li>{@link ImmutableComplexityTotal#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityTotal.equals(Object)",
    "int ImmutableComplexityTotal.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("2.3"));
    ImmutableComplexityTotal immutableComplexityTotal =
        standardDeviationResult.total(new BigDecimal("2.3")).build();

    Builder builderResult2 = ImmutableComplexityTotal.builder();

    Builder averageResult2 = builderResult2.average(new BigDecimal("2.3"));

    Builder complexityKindResult2 =
        averageResult2.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult2 =
        complexityKindResult2.standardDeviation(new BigDecimal("2.3"));
    ImmutableComplexityTotal immutableComplexityTotal2 =
        standardDeviationResult2.total(new BigDecimal("2.3")).build();

    // Act and Assert
    assertEquals(immutableComplexityTotal, immutableComplexityTotal2);
    assertEquals(immutableComplexityTotal.hashCode(), immutableComplexityTotal2.hashCode());
  }

  /**
   * Test {@link ImmutableComplexityTotal#equals(Object)}, and {@link
   * ImmutableComplexityTotal#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplexityTotal#equals(Object)}
   *   <li>{@link ImmutableComplexityTotal#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityTotal.equals(Object)",
    "int ImmutableComplexityTotal.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("2.3"));
    ImmutableComplexityTotal immutableComplexityTotal =
        standardDeviationResult.total(new BigDecimal("2.3")).build();

    // Act and Assert
    assertEquals(immutableComplexityTotal, immutableComplexityTotal);
    int expectedHashCodeResult = immutableComplexityTotal.hashCode();
    assertEquals(expectedHashCodeResult, immutableComplexityTotal.hashCode());
  }

  /**
   * Test {@link ImmutableComplexityTotal#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityTotal#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityTotal.equals(Object)",
    "int ImmutableComplexityTotal.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult.average(new BigDecimal("4.5"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("2.3"));
    ImmutableComplexityTotal immutableComplexityTotal =
        standardDeviationResult.total(new BigDecimal("2.3")).build();

    Builder builderResult2 = ImmutableComplexityTotal.builder();

    Builder averageResult2 = builderResult2.average(new BigDecimal("2.3"));

    Builder complexityKindResult2 =
        averageResult2.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult2 =
        complexityKindResult2.standardDeviation(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableComplexityTotal, standardDeviationResult2.total(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableComplexityTotal#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityTotal#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityTotal.equals(Object)",
    "int ImmutableComplexityTotal.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("Name")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("2.3"));
    ImmutableComplexityTotal immutableComplexityTotal =
        standardDeviationResult.total(new BigDecimal("2.3")).build();

    Builder builderResult2 = ImmutableComplexityTotal.builder();

    Builder averageResult2 = builderResult2.average(new BigDecimal("2.3"));

    Builder complexityKindResult2 =
        averageResult2.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult2 =
        complexityKindResult2.standardDeviation(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableComplexityTotal, standardDeviationResult2.total(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableComplexityTotal#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityTotal#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityTotal.equals(Object)",
    "int ImmutableComplexityTotal.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("4.5"));
    ImmutableComplexityTotal immutableComplexityTotal =
        standardDeviationResult.total(new BigDecimal("2.3")).build();

    Builder builderResult2 = ImmutableComplexityTotal.builder();

    Builder averageResult2 = builderResult2.average(new BigDecimal("2.3"));

    Builder complexityKindResult2 =
        averageResult2.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult2 =
        complexityKindResult2.standardDeviation(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableComplexityTotal, standardDeviationResult2.total(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableComplexityTotal#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityTotal#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityTotal.equals(Object)",
    "int ImmutableComplexityTotal.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("2.3"));
    ImmutableComplexityTotal immutableComplexityTotal =
        standardDeviationResult.total(new BigDecimal("4.5")).build();

    Builder builderResult2 = ImmutableComplexityTotal.builder();

    Builder averageResult2 = builderResult2.average(new BigDecimal("2.3"));

    Builder complexityKindResult2 =
        averageResult2.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult2 =
        complexityKindResult2.standardDeviation(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableComplexityTotal, standardDeviationResult2.total(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableComplexityTotal#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityTotal#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityTotal.equals(Object)",
    "int ImmutableComplexityTotal.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(standardDeviationResult.total(new BigDecimal("2.3")).build(), null);
  }

  /**
   * Test {@link ImmutableComplexityTotal#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityTotal#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityTotal.equals(Object)",
    "int ImmutableComplexityTotal.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        standardDeviationResult.total(new BigDecimal("2.3")).build(),
        "Different type to ImmutableComplexityTotal");
  }

  /**
   * Test {@link ImmutableComplexityTotal#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutableComplexityKind.Json} (default constructor).
   *   <li>Then return average is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityTotal#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); then return average is BigDecimal(String) with '2.3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityTotal ImmutableComplexityTotal.fromJson(Json)"})
  void testFromJson_givenJson_thenReturnAverageIsBigDecimalWith23() {
    // Arrange
    Json json = new Json();
    ImmutableComplexityKind.Json complexityKind = new ImmutableComplexityKind.Json();
    json.setComplexityKind(complexityKind);
    json.setTotal(new BigDecimal("2.3"));
    json.setAverage(new BigDecimal("2.3"));
    json.setStandardDeviation(new BigDecimal("2.3"));

    // Act
    ImmutableComplexityTotal actualFromJsonResult = ImmutableComplexityTotal.fromJson(json);

    // Assert
    BigDecimal expectedAverageResult = new BigDecimal("2.3");
    assertEquals(expectedAverageResult, actualFromJsonResult.average());
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.3");
    assertEquals(expectedStandardDeviationResult, actualFromJsonResult.standardDeviation());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualFromJsonResult.total());
    assertSame(complexityKind, actualFromJsonResult.complexityKind());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplexityTotal#toString()}
   *   <li>{@link ImmutableComplexityTotal#average()}
   *   <li>{@link ImmutableComplexityTotal#complexityKind()}
   *   <li>{@link ImmutableComplexityTotal#standardDeviation()}
   *   <li>{@link ImmutableComplexityTotal#total()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal ImmutableComplexityTotal.average()",
    "ComplexityKind ImmutableComplexityTotal.complexityKind()",
    "BigDecimal ImmutableComplexityTotal.standardDeviation()",
    "String ImmutableComplexityTotal.toString()",
    "BigDecimal ImmutableComplexityTotal.total()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();
    BigDecimal average = new BigDecimal("2.3");

    Builder averageResult = builderResult.average(average);

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    BigDecimal standardDeviation = new BigDecimal("2.3");

    Builder standardDeviationResult = complexityKindResult.standardDeviation(standardDeviation);
    BigDecimal total = new BigDecimal("2.3");
    ImmutableComplexityTotal immutableComplexityTotal =
        standardDeviationResult.total(total).build();

    // Act
    String actualToStringResult = immutableComplexityTotal.toString();
    BigDecimal actualAverageResult = immutableComplexityTotal.average();
    ComplexityKind actualComplexityKindResult = immutableComplexityTotal.complexityKind();
    BigDecimal actualStandardDeviationResult = immutableComplexityTotal.standardDeviation();
    BigDecimal actualTotalResult = immutableComplexityTotal.total();

    // Assert
    assertTrue(actualComplexityKindResult instanceof ImmutableComplexityKind);
    assertEquals(
        "ComplexityTotal{complexityKind=ComplexityKind{id=1, name=Name, externalId=42, isDefault=true, kind=ALL},"
            + " total=2.3, average=2.3, standardDeviation=2.3}",
        actualToStringResult);
    assertEquals(new BigDecimal("2.3"), actualAverageResult);
    assertEquals(new BigDecimal("2.3"), actualStandardDeviationResult);
    assertEquals(new BigDecimal("2.3"), actualTotalResult);
    assertSame(average, actualAverageResult);
    assertSame(standardDeviation, actualStandardDeviationResult);
    assertSame(total, actualTotalResult);
  }

  /**
   * Test Json {@link Json#average()}.
   *
   * <p>Method under test: {@link Json#average()}
   */
  @Test
  @DisplayName("Test Json average()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.average()"})
  void testJsonAverage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().average());
  }

  /**
   * Test Json {@link Json#complexityKind()}.
   *
   * <p>Method under test: {@link Json#complexityKind()}
   */
  @Test
  @DisplayName("Test Json complexityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ComplexityKind Json.complexityKind()"})
  void testJsonComplexityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().complexityKind());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAverage(BigDecimal)}
   *   <li>{@link Json#setComplexityKind(ComplexityKind)}
   *   <li>{@link Json#setStandardDeviation(BigDecimal)}
   *   <li>{@link Json#setTotal(BigDecimal)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAverage(BigDecimal)",
    "void Json.setComplexityKind(ComplexityKind)",
    "void Json.setStandardDeviation(BigDecimal)",
    "void Json.setTotal(BigDecimal)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAverage(new BigDecimal("2.3"));
    actualJson.setComplexityKind(
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setStandardDeviation(new BigDecimal("2.3"));
    actualJson.setTotal(new BigDecimal("2.3"));

    // Assert
    ComplexityKind complexityKind = actualJson.complexityKind;
    assertTrue(complexityKind instanceof ImmutableComplexityKind);
    assertEquals("Name", complexityKind.name());
    assertEquals("The characteristics of someone or something", complexityKind.description());
    assertEquals(EntityKind.ALL, complexityKind.kind());
    assertTrue(complexityKind.isDefault());
    assertEquals(new BigDecimal("2.3"), actualJson.average);
    assertEquals(new BigDecimal("2.3"), actualJson.standardDeviation);
    assertEquals(new BigDecimal("2.3"), actualJson.total);
  }

  /**
   * Test Json {@link Json#standardDeviation()}.
   *
   * <p>Method under test: {@link Json#standardDeviation()}
   */
  @Test
  @DisplayName("Test Json standardDeviation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.standardDeviation()"})
  void testJsonStandardDeviation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().standardDeviation());
  }

  /**
   * Test Json {@link Json#total()}.
   *
   * <p>Method under test: {@link Json#total()}
   */
  @Test
  @DisplayName("Test Json total()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.total()"})
  void testJsonTotal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().total());
  }

  /**
   * Test {@link ImmutableComplexityTotal#withAverage(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableComplexityTotal#withAverage(BigDecimal)}
   */
  @Test
  @DisplayName("Test withAverage(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityTotal ImmutableComplexityTotal.withAverage(BigDecimal)"})
  void testWithAverage() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("2.3"));
    ImmutableComplexityTotal immutableComplexityTotal =
        standardDeviationResult.total(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexityTotal actualWithAverageResult =
        immutableComplexityTotal.withAverage(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableComplexityTotal, actualWithAverageResult);
  }

  /**
   * Test {@link ImmutableComplexityTotal#withAverage(BigDecimal)}.
   *
   * <ul>
   *   <li>Then complexityKind return {@link ImmutableComplexityKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityTotal#withAverage(BigDecimal)}
   */
  @Test
  @DisplayName("Test withAverage(BigDecimal); then complexityKind return ImmutableComplexityKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityTotal ImmutableComplexityTotal.withAverage(BigDecimal)"})
  void testWithAverage_thenComplexityKindReturnImmutableComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult.average(new BigDecimal("4.5"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("2.3"));
    ImmutableComplexityTotal immutableComplexityTotal =
        standardDeviationResult.total(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexityTotal actualWithAverageResult =
        immutableComplexityTotal.withAverage(new BigDecimal("2.3"));

    // Assert
    ComplexityKind complexityKindResult2 = actualWithAverageResult.complexityKind();
    assertTrue(complexityKindResult2 instanceof ImmutableComplexityKind);
    assertEquals("Name", complexityKindResult2.name());
    assertEquals(
        "The characteristics of someone or something", complexityKindResult2.description());
    assertEquals(EntityKind.ALL, complexityKindResult2.kind());
    assertTrue(complexityKindResult2.isDefault());
    BigDecimal expectedAverageResult = new BigDecimal("2.3");
    assertEquals(expectedAverageResult, actualWithAverageResult.average());
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.3");
    assertEquals(expectedStandardDeviationResult, actualWithAverageResult.standardDeviation());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualWithAverageResult.total());
  }

  /**
   * Test {@link ImmutableComplexityTotal#withComplexityKind(ComplexityKind)}.
   *
   * <p>Method under test: {@link ImmutableComplexityTotal#withComplexityKind(ComplexityKind)}
   */
  @Test
  @DisplayName("Test withComplexityKind(ComplexityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityTotal ImmutableComplexityTotal.withComplexityKind(ComplexityKind)"
  })
  void testWithComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("2.3"));
    ImmutableComplexityTotal immutableComplexityTotal =
        standardDeviationResult.total(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexityTotal actualWithComplexityKindResult =
        immutableComplexityTotal.withComplexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableComplexityTotal, actualWithComplexityKindResult);
  }

  /**
   * Test {@link ImmutableComplexityTotal#withStandardDeviation(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableComplexityTotal#withStandardDeviation(BigDecimal)}
   */
  @Test
  @DisplayName("Test withStandardDeviation(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityTotal ImmutableComplexityTotal.withStandardDeviation(BigDecimal)"
  })
  void testWithStandardDeviation() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("2.3"));
    ImmutableComplexityTotal immutableComplexityTotal =
        standardDeviationResult.total(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexityTotal actualWithStandardDeviationResult =
        immutableComplexityTotal.withStandardDeviation(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableComplexityTotal, actualWithStandardDeviationResult);
  }

  /**
   * Test {@link ImmutableComplexityTotal#withStandardDeviation(BigDecimal)}.
   *
   * <ul>
   *   <li>Then complexityKind return {@link ImmutableComplexityKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityTotal#withStandardDeviation(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test withStandardDeviation(BigDecimal); then complexityKind return ImmutableComplexityKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityTotal ImmutableComplexityTotal.withStandardDeviation(BigDecimal)"
  })
  void testWithStandardDeviation_thenComplexityKindReturnImmutableComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("4.5"));
    ImmutableComplexityTotal immutableComplexityTotal =
        standardDeviationResult.total(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexityTotal actualWithStandardDeviationResult =
        immutableComplexityTotal.withStandardDeviation(new BigDecimal("2.3"));

    // Assert
    ComplexityKind complexityKindResult2 = actualWithStandardDeviationResult.complexityKind();
    assertTrue(complexityKindResult2 instanceof ImmutableComplexityKind);
    assertEquals("Name", complexityKindResult2.name());
    assertEquals(
        "The characteristics of someone or something", complexityKindResult2.description());
    assertEquals(EntityKind.ALL, complexityKindResult2.kind());
    assertTrue(complexityKindResult2.isDefault());
    BigDecimal expectedAverageResult = new BigDecimal("2.3");
    assertEquals(expectedAverageResult, actualWithStandardDeviationResult.average());
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.3");
    assertEquals(
        expectedStandardDeviationResult, actualWithStandardDeviationResult.standardDeviation());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualWithStandardDeviationResult.total());
  }

  /**
   * Test {@link ImmutableComplexityTotal#withTotal(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableComplexityTotal#withTotal(BigDecimal)}
   */
  @Test
  @DisplayName("Test withTotal(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityTotal ImmutableComplexityTotal.withTotal(BigDecimal)"})
  void testWithTotal() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("2.3"));
    ImmutableComplexityTotal immutableComplexityTotal =
        standardDeviationResult.total(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexityTotal actualWithTotalResult =
        immutableComplexityTotal.withTotal(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableComplexityTotal, actualWithTotalResult);
  }

  /**
   * Test {@link ImmutableComplexityTotal#withTotal(BigDecimal)}.
   *
   * <ul>
   *   <li>Then complexityKind return {@link ImmutableComplexityKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityTotal#withTotal(BigDecimal)}
   */
  @Test
  @DisplayName("Test withTotal(BigDecimal); then complexityKind return ImmutableComplexityKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityTotal ImmutableComplexityTotal.withTotal(BigDecimal)"})
  void testWithTotal_thenComplexityKindReturnImmutableComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableComplexityTotal.builder();

    Builder averageResult = builderResult.average(new BigDecimal("2.3"));

    Builder complexityKindResult =
        averageResult.complexityKind(
            ImmutableComplexityKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder standardDeviationResult = complexityKindResult.standardDeviation(new BigDecimal("2.3"));
    ImmutableComplexityTotal immutableComplexityTotal =
        standardDeviationResult.total(new BigDecimal("4.5")).build();

    // Act
    ImmutableComplexityTotal actualWithTotalResult =
        immutableComplexityTotal.withTotal(new BigDecimal("2.3"));

    // Assert
    ComplexityKind complexityKindResult2 = actualWithTotalResult.complexityKind();
    assertTrue(complexityKindResult2 instanceof ImmutableComplexityKind);
    assertEquals("Name", complexityKindResult2.name());
    assertEquals(
        "The characteristics of someone or something", complexityKindResult2.description());
    assertEquals(EntityKind.ALL, complexityKindResult2.kind());
    assertTrue(complexityKindResult2.isDefault());
    BigDecimal expectedAverageResult = new BigDecimal("2.3");
    assertEquals(expectedAverageResult, actualWithTotalResult.average());
    BigDecimal expectedStandardDeviationResult = new BigDecimal("2.3");
    assertEquals(expectedStandardDeviationResult, actualWithTotalResult.standardDeviation());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    assertEquals(expectedTotalResult, actualWithTotalResult.total());
  }
}
