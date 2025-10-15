package org.finos.waltz.model.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.complexity.ImmutableMeasurableComplexityDetail.Builder;
import org.finos.waltz.model.complexity.ImmutableMeasurableComplexityDetail.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableComplexityDetailDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableComplexityDetail Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableMeasurableComplexityDetail actualImmutableMeasurableComplexityDetail =
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Measurable Category")
            .build();

    // Assert
    assertEquals("Complexity Kind", actualImmutableMeasurableComplexityDetail.complexityKind());
    assertEquals(
        "Measurable Category", actualImmutableMeasurableComplexityDetail.measurableCategory());
  }

  /**
   * Test Builder {@link Builder#complexityKind(String)}.
   *
   * <ul>
   *   <li>When {@code Complexity Kind}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#complexityKind(String)}
   */
  @Test
  @DisplayName("Test Builder complexityKind(String); when 'Complexity Kind'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.complexityKind(String)"})
  void testBuilderComplexityKind_whenComplexityKind_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableComplexityDetail.builder();

    // Act
    Builder actualComplexityKindResult = builderResult.complexityKind("Complexity Kind");

    // Assert
    assertSame(builderResult, actualComplexityKindResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableComplexityDetail)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableComplexityDetail)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableComplexityDetail)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableComplexityDetail)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableMeasurableComplexityDetail.builder();
    ImmutableMeasurableComplexityDetail instance =
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Measurable Category")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableComplexityDetail actualImmutableMeasurableComplexityDetail =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurableComplexityDetail);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#measurableCategory(String)}.
   *
   * <ul>
   *   <li>When {@code Measurable Category}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#measurableCategory(String)}
   */
  @Test
  @DisplayName(
      "Test Builder measurableCategory(String); when 'Measurable Category'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableCategory(String)"})
  void testBuilderMeasurableCategory_whenMeasurableCategory_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableComplexityDetail.builder();

    // Act
    Builder actualMeasurableCategoryResult =
        builderResult.measurableCategory("Measurable Category");

    // Assert
    assertSame(builderResult, actualMeasurableCategoryResult);
  }

  /**
   * Test {@link ImmutableMeasurableComplexityDetail#copyOf(MeasurableComplexityDetail)}.
   *
   * <ul>
   *   <li>Then return {@code Complexity Kind}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableComplexityDetail#copyOf(MeasurableComplexityDetail)}
   */
  @Test
  @DisplayName("Test copyOf(MeasurableComplexityDetail); then return 'Complexity Kind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableComplexityDetail ImmutableMeasurableComplexityDetail.copyOf(MeasurableComplexityDetail)"
  })
  void testCopyOf_thenReturnComplexityKind() {
    // Arrange
    ImmutableMeasurableComplexityDetail instance =
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Measurable Category")
            .build();

    // Act
    ImmutableMeasurableComplexityDetail actualCopyOfResult =
        ImmutableMeasurableComplexityDetail.copyOf(instance);

    // Assert
    assertEquals("Complexity Kind", actualCopyOfResult.complexityKind());
    assertEquals("Measurable Category", actualCopyOfResult.measurableCategory());
  }

  /**
   * Test {@link ImmutableMeasurableComplexityDetail#equals(Object)}, and {@link
   * ImmutableMeasurableComplexityDetail#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableComplexityDetail#equals(Object)}
   *   <li>{@link ImmutableMeasurableComplexityDetail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableComplexityDetail.equals(Object)",
    "int ImmutableMeasurableComplexityDetail.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableComplexityDetail immutableMeasurableComplexityDetail =
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Measurable Category")
            .build();
    ImmutableMeasurableComplexityDetail immutableMeasurableComplexityDetail2 =
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Measurable Category")
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableComplexityDetail, immutableMeasurableComplexityDetail2);
    assertEquals(
        immutableMeasurableComplexityDetail.hashCode(),
        immutableMeasurableComplexityDetail2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableComplexityDetail#equals(Object)}, and {@link
   * ImmutableMeasurableComplexityDetail#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableComplexityDetail#equals(Object)}
   *   <li>{@link ImmutableMeasurableComplexityDetail#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableComplexityDetail.equals(Object)",
    "int ImmutableMeasurableComplexityDetail.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableComplexityDetail immutableMeasurableComplexityDetail =
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Measurable Category")
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableComplexityDetail, immutableMeasurableComplexityDetail);
    int expectedHashCodeResult = immutableMeasurableComplexityDetail.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableComplexityDetail.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableComplexityDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableComplexityDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableComplexityDetail.equals(Object)",
    "int ImmutableMeasurableComplexityDetail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableMeasurableComplexityDetail immutableMeasurableComplexityDetail =
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Measurable Category")
            .measurableCategory("Measurable Category")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableComplexityDetail,
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Measurable Category")
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableComplexityDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableComplexityDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableComplexityDetail.equals(Object)",
    "int ImmutableMeasurableComplexityDetail.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableMeasurableComplexityDetail immutableMeasurableComplexityDetail =
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Complexity Kind")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableComplexityDetail,
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Measurable Category")
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableComplexityDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableComplexityDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableComplexityDetail.equals(Object)",
    "int ImmutableMeasurableComplexityDetail.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Measurable Category")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMeasurableComplexityDetail#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableComplexityDetail#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableComplexityDetail.equals(Object)",
    "int ImmutableMeasurableComplexityDetail.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Measurable Category")
            .build(),
        "Different type to ImmutableMeasurableComplexityDetail");
  }

  /**
   * Test {@link ImmutableMeasurableComplexityDetail#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) MeasurableCategory is {@code Json}.
   *   <li>Then return complexityKind is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableComplexityDetail#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) MeasurableCategory is 'Json'; then return complexityKind is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableComplexityDetail ImmutableMeasurableComplexityDetail.fromJson(Json)"
  })
  void testFromJson_whenJsonMeasurableCategoryIsJson_thenReturnComplexityKindIsJson() {
    // Arrange
    Json json = new Json();
    json.setMeasurableCategory("Json");
    json.setComplexityKind("Json");

    // Act
    ImmutableMeasurableComplexityDetail actualFromJsonResult =
        ImmutableMeasurableComplexityDetail.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.complexityKind());
    assertEquals("Json", actualFromJsonResult.measurableCategory());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableComplexityDetail#toString()}
   *   <li>{@link ImmutableMeasurableComplexityDetail#complexityKind()}
   *   <li>{@link ImmutableMeasurableComplexityDetail#measurableCategory()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableMeasurableComplexityDetail.complexityKind()",
    "String ImmutableMeasurableComplexityDetail.measurableCategory()",
    "String ImmutableMeasurableComplexityDetail.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableMeasurableComplexityDetail immutableMeasurableComplexityDetail =
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Measurable Category")
            .build();

    // Act
    String actualToStringResult = immutableMeasurableComplexityDetail.toString();
    String actualComplexityKindResult = immutableMeasurableComplexityDetail.complexityKind();

    // Assert
    assertEquals("Complexity Kind", actualComplexityKindResult);
    assertEquals("Measurable Category", immutableMeasurableComplexityDetail.measurableCategory());
    assertEquals(
        "MeasurableComplexityDetail{measurableCategory=Measurable Category, complexityKind=Complexity Kind}",
        actualToStringResult);
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
  @MethodsUnderTest({"String Json.complexityKind()"})
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
   *   <li>{@link Json#setComplexityKind(String)}
   *   <li>{@link Json#setMeasurableCategory(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setComplexityKind(String)",
    "void Json.setMeasurableCategory(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setComplexityKind("Complexity Kind");
    actualJson.setMeasurableCategory("Measurable Category");

    // Assert
    assertEquals("Complexity Kind", actualJson.complexityKind);
    assertEquals("Measurable Category", actualJson.measurableCategory);
  }

  /**
   * Test Json {@link Json#measurableCategory()}.
   *
   * <p>Method under test: {@link Json#measurableCategory()}
   */
  @Test
  @DisplayName("Test Json measurableCategory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.measurableCategory()"})
  void testJsonMeasurableCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableCategory());
  }

  /**
   * Test {@link ImmutableMeasurableComplexityDetail#withComplexityKind(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableComplexityDetail#withComplexityKind(String)}
   */
  @Test
  @DisplayName("Test withComplexityKind(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableComplexityDetail ImmutableMeasurableComplexityDetail.withComplexityKind(String)"
  })
  void testWithComplexityKind() {
    // Arrange
    ImmutableMeasurableComplexityDetail immutableMeasurableComplexityDetail =
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("42")
            .measurableCategory("Measurable Category")
            .build();

    // Act
    ImmutableMeasurableComplexityDetail actualWithComplexityKindResult =
        immutableMeasurableComplexityDetail.withComplexityKind("42");

    // Assert
    assertSame(immutableMeasurableComplexityDetail, actualWithComplexityKindResult);
  }

  /**
   * Test {@link ImmutableMeasurableComplexityDetail#withComplexityKind(String)}.
   *
   * <ul>
   *   <li>Then return complexityKind is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableComplexityDetail#withComplexityKind(String)}
   */
  @Test
  @DisplayName("Test withComplexityKind(String); then return complexityKind is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableComplexityDetail ImmutableMeasurableComplexityDetail.withComplexityKind(String)"
  })
  void testWithComplexityKind_thenReturnComplexityKindIs42() {
    // Arrange and Act
    ImmutableMeasurableComplexityDetail actualWithComplexityKindResult =
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Measurable Category")
            .build()
            .withComplexityKind("42");

    // Assert
    assertEquals("42", actualWithComplexityKindResult.complexityKind());
    assertEquals("Measurable Category", actualWithComplexityKindResult.measurableCategory());
  }

  /**
   * Test {@link ImmutableMeasurableComplexityDetail#withMeasurableCategory(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableComplexityDetail#withMeasurableCategory(String)}
   */
  @Test
  @DisplayName("Test withMeasurableCategory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableComplexityDetail ImmutableMeasurableComplexityDetail.withMeasurableCategory(String)"
  })
  void testWithMeasurableCategory() {
    // Arrange
    ImmutableMeasurableComplexityDetail immutableMeasurableComplexityDetail =
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("42")
            .build();

    // Act
    ImmutableMeasurableComplexityDetail actualWithMeasurableCategoryResult =
        immutableMeasurableComplexityDetail.withMeasurableCategory("42");

    // Assert
    assertSame(immutableMeasurableComplexityDetail, actualWithMeasurableCategoryResult);
  }

  /**
   * Test {@link ImmutableMeasurableComplexityDetail#withMeasurableCategory(String)}.
   *
   * <ul>
   *   <li>Then return measurableCategory is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableComplexityDetail#withMeasurableCategory(String)}
   */
  @Test
  @DisplayName("Test withMeasurableCategory(String); then return measurableCategory is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableComplexityDetail ImmutableMeasurableComplexityDetail.withMeasurableCategory(String)"
  })
  void testWithMeasurableCategory_thenReturnMeasurableCategoryIs42() {
    // Arrange and Act
    ImmutableMeasurableComplexityDetail actualWithMeasurableCategoryResult =
        ImmutableMeasurableComplexityDetail.builder()
            .complexityKind("Complexity Kind")
            .measurableCategory("Measurable Category")
            .build()
            .withMeasurableCategory("42");

    // Assert
    assertEquals("42", actualWithMeasurableCategoryResult.measurableCategory());
    assertEquals("Complexity Kind", actualWithMeasurableCategoryResult.complexityKind());
  }
}
