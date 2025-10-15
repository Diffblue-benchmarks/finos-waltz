package org.finos.waltz.model.allocation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.allocation.ImmutableMeasurableRatingPercentage.Builder;
import org.finos.waltz.model.allocation.ImmutableMeasurableRatingPercentage.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingPercentageDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingPercentage Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableMeasurableRatingPercentage actualImmutableMeasurableRatingPercentage =
        ImmutableMeasurableRatingPercentage.builder().measurableRatingId(1L).percentage(1).build();

    // Assert
    assertEquals(1, actualImmutableMeasurableRatingPercentage.percentage());
    assertEquals(1L, actualImmutableMeasurableRatingPercentage.measurableRatingId());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingPercentage)}.
   *
   * <ul>
   *   <li>Then builder build is builder measurableRatingId one percentage one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(MeasurableRatingPercentage)}
   */
  @Test
  @DisplayName(
      "Test Builder from(MeasurableRatingPercentage); then builder build is builder measurableRatingId one percentage one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingPercentage)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderMeasurableRatingIdOnePercentageOneBuild() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPercentage.builder();
    ImmutableMeasurableRatingPercentage instance =
        ImmutableMeasurableRatingPercentage.builder().measurableRatingId(1L).percentage(1).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableRatingPercentage actualImmutableMeasurableRatingPercentage =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingPercentage);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#measurableRatingId(long)}.
   *
   * <p>Method under test: {@link Builder#measurableRatingId(long)}
   */
  @Test
  @DisplayName("Test Builder measurableRatingId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableRatingId(long)"})
  void testBuilderMeasurableRatingId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPercentage.builder();

    // Act
    Builder actualMeasurableRatingIdResult = builderResult.measurableRatingId(1L);

    // Assert
    assertSame(builderResult, actualMeasurableRatingIdResult);
  }

  /**
   * Test Builder {@link Builder#percentage(int)}.
   *
   * <p>Method under test: {@link Builder#percentage(int)}
   */
  @Test
  @DisplayName("Test Builder percentage(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.percentage(int)"})
  void testBuilderPercentage() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPercentage.builder();

    // Act
    Builder actualPercentageResult = builderResult.percentage(1);

    // Assert
    assertSame(builderResult, actualPercentageResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPercentage#copyOf(MeasurableRatingPercentage)}.
   *
   * <ul>
   *   <li>Then return percentage is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPercentage#copyOf(MeasurableRatingPercentage)}
   */
  @Test
  @DisplayName("Test copyOf(MeasurableRatingPercentage); then return percentage is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPercentage ImmutableMeasurableRatingPercentage.copyOf(MeasurableRatingPercentage)"
  })
  void testCopyOf_thenReturnPercentageIsOne() {
    // Arrange
    ImmutableMeasurableRatingPercentage instance =
        ImmutableMeasurableRatingPercentage.builder().measurableRatingId(1L).percentage(1).build();

    // Act
    ImmutableMeasurableRatingPercentage actualCopyOfResult =
        ImmutableMeasurableRatingPercentage.copyOf(instance);

    // Assert
    assertEquals(1, actualCopyOfResult.percentage());
    assertEquals(1L, actualCopyOfResult.measurableRatingId());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPercentage#equals(Object)}, and {@link
   * ImmutableMeasurableRatingPercentage#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingPercentage#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingPercentage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPercentage.equals(Object)",
    "int ImmutableMeasurableRatingPercentage.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRatingPercentage immutableMeasurableRatingPercentage =
        ImmutableMeasurableRatingPercentage.builder().measurableRatingId(1L).percentage(1).build();
    ImmutableMeasurableRatingPercentage immutableMeasurableRatingPercentage2 =
        ImmutableMeasurableRatingPercentage.builder().measurableRatingId(1L).percentage(1).build();

    // Act and Assert
    assertEquals(immutableMeasurableRatingPercentage, immutableMeasurableRatingPercentage2);
    assertEquals(
        immutableMeasurableRatingPercentage.hashCode(),
        immutableMeasurableRatingPercentage2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPercentage#equals(Object)}, and {@link
   * ImmutableMeasurableRatingPercentage#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingPercentage#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingPercentage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPercentage.equals(Object)",
    "int ImmutableMeasurableRatingPercentage.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRatingPercentage immutableMeasurableRatingPercentage =
        ImmutableMeasurableRatingPercentage.builder().measurableRatingId(1L).percentage(1).build();

    // Act and Assert
    assertEquals(immutableMeasurableRatingPercentage, immutableMeasurableRatingPercentage);
    int expectedHashCodeResult = immutableMeasurableRatingPercentage.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableRatingPercentage.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPercentage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPercentage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPercentage.equals(Object)",
    "int ImmutableMeasurableRatingPercentage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableMeasurableRatingPercentage immutableMeasurableRatingPercentage =
        ImmutableMeasurableRatingPercentage.builder().measurableRatingId(2L).percentage(1).build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingPercentage,
        ImmutableMeasurableRatingPercentage.builder().measurableRatingId(1L).percentage(1).build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPercentage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPercentage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPercentage.equals(Object)",
    "int ImmutableMeasurableRatingPercentage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableMeasurableRatingPercentage immutableMeasurableRatingPercentage =
        ImmutableMeasurableRatingPercentage.builder().measurableRatingId(1L).percentage(0).build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingPercentage,
        ImmutableMeasurableRatingPercentage.builder().measurableRatingId(1L).percentage(1).build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPercentage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPercentage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPercentage.equals(Object)",
    "int ImmutableMeasurableRatingPercentage.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableRatingPercentage.builder().measurableRatingId(1L).percentage(1).build(),
        null);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPercentage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPercentage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPercentage.equals(Object)",
    "int ImmutableMeasurableRatingPercentage.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableRatingPercentage.builder().measurableRatingId(1L).percentage(1).build(),
        "Different type to ImmutableMeasurableRatingPercentage");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingPercentage#toString()}
   *   <li>{@link ImmutableMeasurableRatingPercentage#measurableRatingId()}
   *   <li>{@link ImmutableMeasurableRatingPercentage#percentage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableMeasurableRatingPercentage.measurableRatingId()",
    "int ImmutableMeasurableRatingPercentage.percentage()",
    "String ImmutableMeasurableRatingPercentage.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableMeasurableRatingPercentage immutableMeasurableRatingPercentage =
        ImmutableMeasurableRatingPercentage.builder().measurableRatingId(1L).percentage(1).build();

    // Act
    String actualToStringResult = immutableMeasurableRatingPercentage.toString();
    long actualMeasurableRatingIdResult = immutableMeasurableRatingPercentage.measurableRatingId();

    // Assert
    assertEquals(
        "MeasurableRatingPercentage{percentage=1, measurableRatingId=1}", actualToStringResult);
    assertEquals(1, immutableMeasurableRatingPercentage.percentage());
    assertEquals(1L, actualMeasurableRatingIdResult);
  }

  /**
   * Test Json {@link Json#measurableRatingId()}.
   *
   * <p>Method under test: {@link Json#measurableRatingId()}
   */
  @Test
  @DisplayName("Test Json measurableRatingId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.measurableRatingId()"})
  void testJsonMeasurableRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableRatingId());
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
    assertEquals(0, actualJson.percentage);
    assertEquals(0L, actualJson.measurableRatingId);
    assertFalse(actualJson.measurableRatingIdIsSet);
    assertFalse(actualJson.percentageIsSet);
  }

  /**
   * Test Json {@link Json#percentage()}.
   *
   * <p>Method under test: {@link Json#percentage()}
   */
  @Test
  @DisplayName("Test Json percentage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.percentage()"})
  void testJsonPercentage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().percentage());
  }

  /**
   * Test Json {@link Json#setMeasurableRatingId(long)}.
   *
   * <p>Method under test: {@link Json#setMeasurableRatingId(long)}
   */
  @Test
  @DisplayName("Test Json setMeasurableRatingId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setMeasurableRatingId(long)"})
  void testJsonSetMeasurableRatingId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMeasurableRatingId(1L);

    // Assert
    assertEquals(1L, json.measurableRatingId);
    assertTrue(json.measurableRatingIdIsSet);
  }

  /**
   * Test Json {@link Json#setPercentage(int)}.
   *
   * <p>Method under test: {@link Json#setPercentage(int)}
   */
  @Test
  @DisplayName("Test Json setPercentage(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPercentage(int)"})
  void testJsonSetPercentage() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPercentage(1);

    // Assert
    assertEquals(1, json.percentage);
    assertTrue(json.percentageIsSet);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPercentage#withMeasurableRatingId(long)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPercentage#withMeasurableRatingId(long)}
   */
  @Test
  @DisplayName("Test withMeasurableRatingId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPercentage ImmutableMeasurableRatingPercentage.withMeasurableRatingId(long)"
  })
  void testWithMeasurableRatingId() {
    // Arrange
    ImmutableMeasurableRatingPercentage immutableMeasurableRatingPercentage =
        ImmutableMeasurableRatingPercentage.builder().measurableRatingId(42L).percentage(1).build();

    // Act
    ImmutableMeasurableRatingPercentage actualWithMeasurableRatingIdResult =
        immutableMeasurableRatingPercentage.withMeasurableRatingId(42L);

    // Assert
    assertSame(immutableMeasurableRatingPercentage, actualWithMeasurableRatingIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPercentage#withMeasurableRatingId(long)}.
   *
   * <ul>
   *   <li>Then return percentage is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPercentage#withMeasurableRatingId(long)}
   */
  @Test
  @DisplayName("Test withMeasurableRatingId(long); then return percentage is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPercentage ImmutableMeasurableRatingPercentage.withMeasurableRatingId(long)"
  })
  void testWithMeasurableRatingId_thenReturnPercentageIsOne() {
    // Arrange and Act
    ImmutableMeasurableRatingPercentage actualWithMeasurableRatingIdResult =
        ImmutableMeasurableRatingPercentage.builder()
            .measurableRatingId(1L)
            .percentage(1)
            .build()
            .withMeasurableRatingId(42L);

    // Assert
    assertEquals(1, actualWithMeasurableRatingIdResult.percentage());
    assertEquals(42L, actualWithMeasurableRatingIdResult.measurableRatingId());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPercentage#withPercentage(int)}.
   *
   * <ul>
   *   <li>Then return builder measurableRatingId one percentage forty-two build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPercentage#withPercentage(int)}
   */
  @Test
  @DisplayName(
      "Test withPercentage(int); then return builder measurableRatingId one percentage forty-two build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPercentage ImmutableMeasurableRatingPercentage.withPercentage(int)"
  })
  void testWithPercentage_thenReturnBuilderMeasurableRatingIdOnePercentageFortyTwoBuild() {
    // Arrange
    ImmutableMeasurableRatingPercentage immutableMeasurableRatingPercentage =
        ImmutableMeasurableRatingPercentage.builder().measurableRatingId(1L).percentage(42).build();

    // Act
    ImmutableMeasurableRatingPercentage actualWithPercentageResult =
        immutableMeasurableRatingPercentage.withPercentage(42);

    // Assert
    assertSame(immutableMeasurableRatingPercentage, actualWithPercentageResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPercentage#withPercentage(int)}.
   *
   * <ul>
   *   <li>Then return measurableRatingId is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPercentage#withPercentage(int)}
   */
  @Test
  @DisplayName("Test withPercentage(int); then return measurableRatingId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPercentage ImmutableMeasurableRatingPercentage.withPercentage(int)"
  })
  void testWithPercentage_thenReturnMeasurableRatingIdIsOne() {
    // Arrange and Act
    ImmutableMeasurableRatingPercentage actualWithPercentageResult =
        ImmutableMeasurableRatingPercentage.builder()
            .measurableRatingId(1L)
            .percentage(1)
            .build()
            .withPercentage(42);

    // Assert
    assertEquals(1L, actualWithPercentageResult.measurableRatingId());
    assertEquals(42, actualWithPercentageResult.percentage());
  }
}
