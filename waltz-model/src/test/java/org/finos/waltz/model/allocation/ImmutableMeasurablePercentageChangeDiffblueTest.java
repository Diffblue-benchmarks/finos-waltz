package org.finos.waltz.model.allocation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.allocation.ImmutableMeasurablePercentageChange.Builder;
import org.finos.waltz.model.allocation.ImmutableMeasurablePercentageChange.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurablePercentageChangeDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurablePercentageChange Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableMeasurablePercentageChange.builder();
    ImmutableMeasurableRatingPercentage measurablePercentage =
        ImmutableMeasurableRatingPercentage.builder().measurableRatingId(1L).percentage(1).build();
    Builder actualPreviousPercentageResult =
        actualBuilderResult
            .measurablePercentage(measurablePercentage)
            .operation(Operation.ADD)
            .previousPercentage(1);
    Optional<Integer> previousPercentage = Optional.of(1);
    ImmutableMeasurablePercentageChange actualImmutableMeasurablePercentageChange =
        actualPreviousPercentageResult.previousPercentage(previousPercentage).build();

    // Assert
    assertEquals(Operation.ADD, actualImmutableMeasurablePercentageChange.operation());
    assertSame(
        measurablePercentage, actualImmutableMeasurablePercentageChange.measurablePercentage());
  }

  /**
   * Test Builder {@link Builder#from(MeasurablePercentageChange)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurablePercentageChange)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurablePercentageChange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurablePercentageChange)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();

    Builder builderResult2 = ImmutableMeasurablePercentageChange.builder();
    ImmutableMeasurablePercentageChange instance =
        builderResult2
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurablePercentageChange actualImmutableMeasurablePercentageChange =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurablePercentageChange);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#measurablePercentage(MeasurableRatingPercentage)}.
   *
   * <ul>
   *   <li>When {@link ImmutableMeasurableRatingPercentage.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#measurablePercentage(MeasurableRatingPercentage)}
   */
  @Test
  @DisplayName(
      "Test Builder measurablePercentage(MeasurableRatingPercentage); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurablePercentage(MeasurableRatingPercentage)"})
  void testBuilderMeasurablePercentage_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();

    // Act
    Builder actualMeasurablePercentageResult =
        builderResult.measurablePercentage(new ImmutableMeasurableRatingPercentage.Json());

    // Assert
    assertSame(builderResult, actualMeasurablePercentageResult);
  }

  /**
   * Test Builder {@link Builder#operation(Operation)}.
   *
   * <p>Method under test: {@link Builder#operation(Operation)}
   */
  @Test
  @DisplayName("Test Builder operation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operation(Operation)"})
  void testBuilderOperation() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();

    // Act
    Builder actualOperationResult = builderResult.operation(Operation.ADD);

    // Assert
    assertSame(builderResult, actualOperationResult);
  }

  /**
   * Test Builder {@link Builder#previousPercentage(int)} with {@code int}.
   *
   * <p>Method under test: {@link Builder#previousPercentage(int)}
   */
  @Test
  @DisplayName("Test Builder previousPercentage(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.previousPercentage(int)"})
  void testBuilderPreviousPercentageWithInt() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();

    // Act
    Builder actualPreviousPercentageResult = builderResult.previousPercentage(1);

    // Assert
    assertSame(builderResult, actualPreviousPercentageResult);
  }

  /**
   * Test Builder {@link Builder#previousPercentage(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#previousPercentage(Optional)}
   */
  @Test
  @DisplayName("Test Builder previousPercentage(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.previousPercentage(Optional)"})
  void testBuilderPreviousPercentageWithOptional() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    Optional<Integer> previousPercentage = Optional.of(1);

    // Act
    Builder actualPreviousPercentageResult = builderResult.previousPercentage(previousPercentage);

    // Assert
    assertSame(builderResult, actualPreviousPercentageResult);
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#copyOf(MeasurablePercentageChange)}.
   *
   * <ul>
   *   <li>Then measurablePercentage return {@link ImmutableMeasurableRatingPercentage}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurablePercentageChange#copyOf(MeasurablePercentageChange)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurablePercentageChange); then measurablePercentage return ImmutableMeasurableRatingPercentage")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurablePercentageChange ImmutableMeasurablePercentageChange.copyOf(MeasurablePercentageChange)"
  })
  void testCopyOf_thenMeasurablePercentageReturnImmutableMeasurableRatingPercentage() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    ImmutableMeasurablePercentageChange instance =
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build();

    // Act
    ImmutableMeasurablePercentageChange actualCopyOfResult =
        ImmutableMeasurablePercentageChange.copyOf(instance);

    // Assert
    MeasurableRatingPercentage measurablePercentageResult =
        actualCopyOfResult.measurablePercentage();
    assertTrue(measurablePercentageResult instanceof ImmutableMeasurableRatingPercentage);
    assertEquals(1, measurablePercentageResult.percentage());
    assertEquals(1L, measurablePercentageResult.measurableRatingId());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#equals(Object)}, and {@link
   * ImmutableMeasurablePercentageChange#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurablePercentageChange#equals(Object)}
   *   <li>{@link ImmutableMeasurablePercentageChange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurablePercentageChange.equals(Object)",
    "int ImmutableMeasurablePercentageChange.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    ImmutableMeasurablePercentageChange immutableMeasurablePercentageChange =
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build();

    Builder builderResult2 = ImmutableMeasurablePercentageChange.builder();
    ImmutableMeasurablePercentageChange immutableMeasurablePercentageChange2 =
        builderResult2
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build();

    // Act and Assert
    assertEquals(immutableMeasurablePercentageChange, immutableMeasurablePercentageChange2);
    assertEquals(
        immutableMeasurablePercentageChange.hashCode(),
        immutableMeasurablePercentageChange2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#equals(Object)}, and {@link
   * ImmutableMeasurablePercentageChange#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurablePercentageChange#equals(Object)}
   *   <li>{@link ImmutableMeasurablePercentageChange#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurablePercentageChange.equals(Object)",
    "int ImmutableMeasurablePercentageChange.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    ImmutableMeasurablePercentageChange immutableMeasurablePercentageChange =
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build();

    // Act and Assert
    assertEquals(immutableMeasurablePercentageChange, immutableMeasurablePercentageChange);
    int expectedHashCodeResult = immutableMeasurablePercentageChange.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurablePercentageChange.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurablePercentageChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurablePercentageChange.equals(Object)",
    "int ImmutableMeasurablePercentageChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    ImmutableMeasurablePercentageChange immutableMeasurablePercentageChange =
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(2L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build();

    Builder builderResult2 = ImmutableMeasurablePercentageChange.builder();

    // Act and Assert
    assertNotEquals(
        immutableMeasurablePercentageChange,
        builderResult2
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurablePercentageChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurablePercentageChange.equals(Object)",
    "int ImmutableMeasurablePercentageChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    ImmutableMeasurablePercentageChange immutableMeasurablePercentageChange =
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ATTEST)
            .previousPercentage(1)
            .build();

    Builder builderResult2 = ImmutableMeasurablePercentageChange.builder();

    // Act and Assert
    assertNotEquals(
        immutableMeasurablePercentageChange,
        builderResult2
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurablePercentageChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurablePercentageChange.equals(Object)",
    "int ImmutableMeasurablePercentageChange.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    ImmutableMeasurablePercentageChange immutableMeasurablePercentageChange =
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(0)
            .build();

    Builder builderResult2 = ImmutableMeasurablePercentageChange.builder();

    // Act and Assert
    assertNotEquals(
        immutableMeasurablePercentageChange,
        builderResult2
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurablePercentageChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurablePercentageChange.equals(Object)",
    "int ImmutableMeasurablePercentageChange.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurablePercentageChange#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurablePercentageChange.equals(Object)",
    "int ImmutableMeasurablePercentageChange.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build(),
        "Different type to ImmutableMeasurablePercentageChange");
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>When {@link Json} (default constructor) Operation is {@code ADD}.
   *   <li>Then return operation is {@code ADD}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurablePercentageChange#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ADD'; when Json (default constructor) Operation is 'ADD'; then return operation is 'ADD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurablePercentageChange ImmutableMeasurablePercentageChange.fromJson(Json)"
  })
  void testFromJson_givenAdd_whenJsonOperationIsAdd_thenReturnOperationIsAdd() {
    // Arrange
    Json json = new Json();
    json.setOperation(Operation.ADD);
    ImmutableMeasurableRatingPercentage.Json measurablePercentage =
        new ImmutableMeasurableRatingPercentage.Json();
    json.setMeasurablePercentage(measurablePercentage);
    json.setPreviousPercentage(null);

    // Act
    ImmutableMeasurablePercentageChange actualFromJsonResult =
        ImmutableMeasurablePercentageChange.fromJson(json);

    // Assert
    assertEquals(Operation.ADD, actualFromJsonResult.operation());
    assertSame(measurablePercentage, actualFromJsonResult.measurablePercentage());
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link Json} (default constructor) PreviousPercentage is of one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurablePercentageChange#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of one; when Json (default constructor) PreviousPercentage is of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurablePercentageChange ImmutableMeasurablePercentageChange.fromJson(Json)"
  })
  void testFromJson_givenOfOne_whenJsonPreviousPercentageIsOfOne() {
    // Arrange
    Json json = new Json();
    json.setOperation(Operation.ADD);
    ImmutableMeasurableRatingPercentage.Json measurablePercentage =
        new ImmutableMeasurableRatingPercentage.Json();
    json.setMeasurablePercentage(measurablePercentage);
    Optional<Integer> previousPercentage = Optional.of(1);
    json.setPreviousPercentage(previousPercentage);

    // Act
    ImmutableMeasurablePercentageChange actualFromJsonResult =
        ImmutableMeasurablePercentageChange.fromJson(json);

    // Assert
    assertEquals(Operation.ADD, actualFromJsonResult.operation());
    assertSame(measurablePercentage, actualFromJsonResult.measurablePercentage());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurablePercentageChange#measurablePercentage()}
   *   <li>{@link ImmutableMeasurablePercentageChange#operation()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPercentage ImmutableMeasurablePercentageChange.measurablePercentage()",
    "Operation ImmutableMeasurablePercentageChange.operation()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    ImmutableMeasurablePercentageChange immutableMeasurablePercentageChange =
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build();

    // Act
    MeasurableRatingPercentage actualMeasurablePercentageResult =
        immutableMeasurablePercentageChange.measurablePercentage();

    // Assert
    assertTrue(actualMeasurablePercentageResult instanceof ImmutableMeasurableRatingPercentage);
    assertEquals(Operation.ADD, immutableMeasurablePercentageChange.operation());
  }

  /**
   * Test Json {@link Json#measurablePercentage()}.
   *
   * <p>Method under test: {@link Json#measurablePercentage()}
   */
  @Test
  @DisplayName("Test Json measurablePercentage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingPercentage Json.measurablePercentage()"})
  void testJsonMeasurablePercentage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurablePercentage());
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
    assertNull(actualJson.operation);
    assertNull(actualJson.measurablePercentage);
    assertFalse(actualJson.previousPercentage.isPresent());
  }

  /**
   * Test Json {@link Json#operation()}.
   *
   * <p>Method under test: {@link Json#operation()}
   */
  @Test
  @DisplayName("Test Json operation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation Json.operation()"})
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().operation());
  }

  /**
   * Test Json {@link Json#previousPercentage()}.
   *
   * <p>Method under test: {@link Json#previousPercentage()}
   */
  @Test
  @DisplayName("Test Json previousPercentage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.previousPercentage()"})
  void testJsonPreviousPercentage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().previousPercentage());
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#previousPercentage()}.
   *
   * <p>Method under test: {@link ImmutableMeasurablePercentageChange#previousPercentage()}
   */
  @Test
  @DisplayName("Test previousPercentage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableMeasurablePercentageChange.previousPercentage()"})
  void testPreviousPercentage() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();

    // Act
    Optional<Integer> actualPreviousPercentageResult =
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build()
            .previousPercentage();

    // Assert
    assertEquals(1, actualPreviousPercentageResult.get().intValue());
    assertTrue(actualPreviousPercentageResult.isPresent());
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#toString()}.
   *
   * <p>Method under test: {@link ImmutableMeasurablePercentageChange#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableMeasurablePercentageChange.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();

    // Act and Assert
    assertEquals(
        "MeasurablePercentageChange{operation=ADD, measurablePercentage=MeasurableRatingPercentage{percentage=1,"
            + " measurableRatingId=1}, previousPercentage=1}",
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build()
            .toString());
  }

  /**
   * Test {@link
   * ImmutableMeasurablePercentageChange#withMeasurablePercentage(MeasurableRatingPercentage)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurablePercentageChange#withMeasurablePercentage(MeasurableRatingPercentage)}
   */
  @Test
  @DisplayName("Test withMeasurablePercentage(MeasurableRatingPercentage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurablePercentageChange ImmutableMeasurablePercentageChange.withMeasurablePercentage(MeasurableRatingPercentage)"
  })
  void testWithMeasurablePercentage() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    ImmutableMeasurablePercentageChange immutableMeasurablePercentageChange =
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build();

    // Act
    ImmutableMeasurablePercentageChange actualWithMeasurablePercentageResult =
        immutableMeasurablePercentageChange.withMeasurablePercentage(
            ImmutableMeasurableRatingPercentage.builder()
                .measurableRatingId(1L)
                .percentage(1)
                .build());

    // Assert
    assertEquals(immutableMeasurablePercentageChange, actualWithMeasurablePercentageResult);
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#withOperation(Operation)}.
   *
   * <p>Method under test: {@link ImmutableMeasurablePercentageChange#withOperation(Operation)}
   */
  @Test
  @DisplayName("Test withOperation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurablePercentageChange ImmutableMeasurablePercentageChange.withOperation(Operation)"
  })
  void testWithOperation() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    ImmutableMeasurablePercentageChange immutableMeasurablePercentageChange =
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build();

    // Act
    ImmutableMeasurablePercentageChange actualWithOperationResult =
        immutableMeasurablePercentageChange.withOperation(Operation.ADD);

    // Assert
    assertSame(immutableMeasurablePercentageChange, actualWithOperationResult);
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#withOperation(Operation)}.
   *
   * <p>Method under test: {@link ImmutableMeasurablePercentageChange#withOperation(Operation)}
   */
  @Test
  @DisplayName("Test withOperation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurablePercentageChange ImmutableMeasurablePercentageChange.withOperation(Operation)"
  })
  void testWithOperation2() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();

    // Act
    ImmutableMeasurablePercentageChange actualWithOperationResult =
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ATTEST)
            .previousPercentage(1)
            .build()
            .withOperation(Operation.ADD);

    // Assert
    MeasurableRatingPercentage measurablePercentageResult =
        actualWithOperationResult.measurablePercentage();
    assertTrue(measurablePercentageResult instanceof ImmutableMeasurableRatingPercentage);
    assertEquals(1, measurablePercentageResult.percentage());
    assertEquals(1L, measurablePercentageResult.measurableRatingId());
    assertEquals(Operation.ADD, actualWithOperationResult.operation());
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#withPreviousPercentage(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurablePercentageChange#withPreviousPercentage(Optional)}
   */
  @Test
  @DisplayName("Test withPreviousPercentage(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurablePercentageChange ImmutableMeasurablePercentageChange.withPreviousPercentage(Optional)"
  })
  void testWithPreviousPercentageWithOptional() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    ImmutableMeasurablePercentageChange immutableMeasurablePercentageChange =
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build();
    Optional<Integer> optional = Optional.of(1);

    // Act
    ImmutableMeasurablePercentageChange actualWithPreviousPercentageResult =
        immutableMeasurablePercentageChange.withPreviousPercentage(optional);

    // Assert
    assertSame(immutableMeasurablePercentageChange, actualWithPreviousPercentageResult);
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#withPreviousPercentage(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurablePercentageChange#withPreviousPercentage(Optional)}
   */
  @Test
  @DisplayName("Test withPreviousPercentage(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurablePercentageChange ImmutableMeasurablePercentageChange.withPreviousPercentage(Optional)"
  })
  void testWithPreviousPercentageWithOptional2() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    ImmutableMeasurablePercentageChange immutableMeasurablePercentageChange =
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(0)
            .build();
    Optional<Integer> optional = Optional.of(1);

    // Act
    ImmutableMeasurablePercentageChange actualWithPreviousPercentageResult =
        immutableMeasurablePercentageChange.withPreviousPercentage(optional);

    // Assert
    MeasurableRatingPercentage measurablePercentageResult =
        actualWithPreviousPercentageResult.measurablePercentage();
    assertTrue(measurablePercentageResult instanceof ImmutableMeasurableRatingPercentage);
    assertEquals(1, measurablePercentageResult.percentage());
    assertEquals(1L, measurablePercentageResult.measurableRatingId());
    assertEquals(Operation.ADD, actualWithPreviousPercentageResult.operation());
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#withPreviousPercentage(int)} with {@code
   * value}.
   *
   * <p>Method under test: {@link ImmutableMeasurablePercentageChange#withPreviousPercentage(int)}
   */
  @Test
  @DisplayName("Test withPreviousPercentage(int) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurablePercentageChange ImmutableMeasurablePercentageChange.withPreviousPercentage(int)"
  })
  void testWithPreviousPercentageWithValue() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();

    // Act
    ImmutableMeasurablePercentageChange actualWithPreviousPercentageResult =
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build()
            .withPreviousPercentage(42);

    // Assert
    MeasurableRatingPercentage measurablePercentageResult =
        actualWithPreviousPercentageResult.measurablePercentage();
    assertTrue(measurablePercentageResult instanceof ImmutableMeasurableRatingPercentage);
    assertEquals(1, measurablePercentageResult.percentage());
    assertEquals(1L, measurablePercentageResult.measurableRatingId());
    assertEquals(Operation.ADD, actualWithPreviousPercentageResult.operation());
  }

  /**
   * Test {@link ImmutableMeasurablePercentageChange#withPreviousPercentage(int)} with {@code
   * value}.
   *
   * <p>Method under test: {@link ImmutableMeasurablePercentageChange#withPreviousPercentage(int)}
   */
  @Test
  @DisplayName("Test withPreviousPercentage(int) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurablePercentageChange ImmutableMeasurablePercentageChange.withPreviousPercentage(int)"
  })
  void testWithPreviousPercentageWithValue2() {
    // Arrange
    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    ImmutableMeasurablePercentageChange immutableMeasurablePercentageChange =
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build();

    // Act
    ImmutableMeasurablePercentageChange actualWithPreviousPercentageResult =
        immutableMeasurablePercentageChange.withPreviousPercentage(1);

    // Assert
    assertSame(immutableMeasurablePercentageChange, actualWithPreviousPercentageResult);
  }
}
