package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingApplyResult.Builder;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingApplyResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkMeasurableRatingApplyResultDiffblueTest {
  /**
   * Test Builder {@link Builder#allocationsAdded(int)}.
   *
   * <p>Method under test: {@link Builder#allocationsAdded(int)}
   */
  @Test
  @DisplayName("Test Builder allocationsAdded(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.allocationsAdded(int)"})
  void testBuilderAllocationsAdded() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();

    // Act
    Builder actualAllocationsAddedResult = builderResult.allocationsAdded(1);

    // Assert
    assertSame(builderResult, actualAllocationsAddedResult);
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
  @MethodsUnderTest({"ImmutableBulkMeasurableRatingApplyResult Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingApplyResult actualImmutableBulkMeasurableRatingApplyResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Assert
    assertEquals(1, actualImmutableBulkMeasurableRatingApplyResult.allocationsAdded());
    assertEquals(1, actualImmutableBulkMeasurableRatingApplyResult.recordsAdded());
    assertEquals(1, actualImmutableBulkMeasurableRatingApplyResult.recordsRemoved());
    assertEquals(1, actualImmutableBulkMeasurableRatingApplyResult.recordsUpdated());
    assertEquals(1, actualImmutableBulkMeasurableRatingApplyResult.skippedRows());
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingApplyResult)}.
   *
   * <p>Method under test: {@link Builder#from(BulkMeasurableRatingApplyResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingApplyResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingApplyResult)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();
    ImmutableBulkMeasurableRatingApplyResult instance =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkMeasurableRatingApplyResult actualImmutableBulkMeasurableRatingApplyResult =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkMeasurableRatingApplyResult);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#recordsAdded(int)}.
   *
   * <p>Method under test: {@link Builder#recordsAdded(int)}
   */
  @Test
  @DisplayName("Test Builder recordsAdded(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.recordsAdded(int)"})
  void testBuilderRecordsAdded() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();

    // Act
    Builder actualRecordsAddedResult = builderResult.recordsAdded(1);

    // Assert
    assertSame(builderResult, actualRecordsAddedResult);
  }

  /**
   * Test Builder {@link Builder#recordsRemoved(int)}.
   *
   * <p>Method under test: {@link Builder#recordsRemoved(int)}
   */
  @Test
  @DisplayName("Test Builder recordsRemoved(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.recordsRemoved(int)"})
  void testBuilderRecordsRemoved() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();

    // Act
    Builder actualRecordsRemovedResult = builderResult.recordsRemoved(1);

    // Assert
    assertSame(builderResult, actualRecordsRemovedResult);
  }

  /**
   * Test Builder {@link Builder#recordsUpdated(int)}.
   *
   * <p>Method under test: {@link Builder#recordsUpdated(int)}
   */
  @Test
  @DisplayName("Test Builder recordsUpdated(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.recordsUpdated(int)"})
  void testBuilderRecordsUpdated() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();

    // Act
    Builder actualRecordsUpdatedResult = builderResult.recordsUpdated(1);

    // Assert
    assertSame(builderResult, actualRecordsUpdatedResult);
  }

  /**
   * Test Builder {@link Builder#skippedRows(int)}.
   *
   * <p>Method under test: {@link Builder#skippedRows(int)}
   */
  @Test
  @DisplayName("Test Builder skippedRows(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.skippedRows(int)"})
  void testBuilderSkippedRows() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();

    // Act
    Builder actualSkippedRowsResult = builderResult.skippedRows(1);

    // Assert
    assertSame(builderResult, actualSkippedRowsResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#copyOf(BulkMeasurableRatingApplyResult)}.
   *
   * <ul>
   *   <li>Then return allocationsAdded is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingApplyResult#copyOf(BulkMeasurableRatingApplyResult)}
   */
  @Test
  @DisplayName("Test copyOf(BulkMeasurableRatingApplyResult); then return allocationsAdded is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingApplyResult ImmutableBulkMeasurableRatingApplyResult.copyOf(BulkMeasurableRatingApplyResult)"
  })
  void testCopyOf_thenReturnAllocationsAddedIsOne() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult instance =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act
    ImmutableBulkMeasurableRatingApplyResult actualCopyOfResult =
        ImmutableBulkMeasurableRatingApplyResult.copyOf(instance);

    // Assert
    assertEquals(1, actualCopyOfResult.allocationsAdded());
    assertEquals(1, actualCopyOfResult.recordsAdded());
    assertEquals(1, actualCopyOfResult.recordsRemoved());
    assertEquals(1, actualCopyOfResult.recordsUpdated());
    assertEquals(1, actualCopyOfResult.skippedRows());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}, and {@link
   * ImmutableBulkMeasurableRatingApplyResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}
   *   <li>{@link ImmutableBulkMeasurableRatingApplyResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingApplyResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingApplyResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult immutableBulkMeasurableRatingApplyResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();
    ImmutableBulkMeasurableRatingApplyResult immutableBulkMeasurableRatingApplyResult2 =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkMeasurableRatingApplyResult, immutableBulkMeasurableRatingApplyResult2);
    assertEquals(
        immutableBulkMeasurableRatingApplyResult.hashCode(),
        immutableBulkMeasurableRatingApplyResult2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}, and {@link
   * ImmutableBulkMeasurableRatingApplyResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}
   *   <li>{@link ImmutableBulkMeasurableRatingApplyResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingApplyResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingApplyResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult immutableBulkMeasurableRatingApplyResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkMeasurableRatingApplyResult, immutableBulkMeasurableRatingApplyResult);
    int expectedHashCodeResult = immutableBulkMeasurableRatingApplyResult.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkMeasurableRatingApplyResult.hashCode());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingApplyResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult immutableBulkMeasurableRatingApplyResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(0)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingApplyResult,
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingApplyResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult immutableBulkMeasurableRatingApplyResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(0)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingApplyResult,
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingApplyResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult immutableBulkMeasurableRatingApplyResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(0)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingApplyResult,
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingApplyResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult immutableBulkMeasurableRatingApplyResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(0)
            .skippedRows(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingApplyResult,
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingApplyResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult immutableBulkMeasurableRatingApplyResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(0)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkMeasurableRatingApplyResult,
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingApplyResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkMeasurableRatingApplyResult.equals(Object)",
    "int ImmutableBulkMeasurableRatingApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build(),
        "Different type to ImmutableBulkMeasurableRatingApplyResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingApplyResult#toString()}
   *   <li>{@link ImmutableBulkMeasurableRatingApplyResult#allocationsAdded()}
   *   <li>{@link ImmutableBulkMeasurableRatingApplyResult#recordsAdded()}
   *   <li>{@link ImmutableBulkMeasurableRatingApplyResult#recordsRemoved()}
   *   <li>{@link ImmutableBulkMeasurableRatingApplyResult#recordsUpdated()}
   *   <li>{@link ImmutableBulkMeasurableRatingApplyResult#skippedRows()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableBulkMeasurableRatingApplyResult.allocationsAdded()",
    "int ImmutableBulkMeasurableRatingApplyResult.recordsAdded()",
    "int ImmutableBulkMeasurableRatingApplyResult.recordsRemoved()",
    "int ImmutableBulkMeasurableRatingApplyResult.recordsUpdated()",
    "int ImmutableBulkMeasurableRatingApplyResult.skippedRows()",
    "String ImmutableBulkMeasurableRatingApplyResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult immutableBulkMeasurableRatingApplyResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act
    String actualToStringResult = immutableBulkMeasurableRatingApplyResult.toString();
    int actualAllocationsAddedResult = immutableBulkMeasurableRatingApplyResult.allocationsAdded();
    int actualRecordsAddedResult = immutableBulkMeasurableRatingApplyResult.recordsAdded();
    int actualRecordsRemovedResult = immutableBulkMeasurableRatingApplyResult.recordsRemoved();
    int actualRecordsUpdatedResult = immutableBulkMeasurableRatingApplyResult.recordsUpdated();

    // Assert
    assertEquals(
        "BulkMeasurableRatingApplyResult{recordsAdded=1, recordsUpdated=1, recordsRemoved=1, skippedRows=1,"
            + " allocationsAdded=1}",
        actualToStringResult);
    assertEquals(1, actualAllocationsAddedResult);
    assertEquals(1, actualRecordsAddedResult);
    assertEquals(1, actualRecordsRemovedResult);
    assertEquals(1, actualRecordsUpdatedResult);
    assertEquals(1, immutableBulkMeasurableRatingApplyResult.skippedRows());
  }

  /**
   * Test Json {@link Json#allocationsAdded()}.
   *
   * <p>Method under test: {@link Json#allocationsAdded()}
   */
  @Test
  @DisplayName("Test Json allocationsAdded()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.allocationsAdded()"})
  void testJsonAllocationsAdded() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().allocationsAdded());
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
    assertEquals(0, actualJson.allocationsAdded);
    assertEquals(0, actualJson.recordsAdded);
    assertEquals(0, actualJson.recordsRemoved);
    assertEquals(0, actualJson.recordsUpdated);
    assertEquals(0, actualJson.skippedRows);
    assertFalse(actualJson.allocationsAddedIsSet);
    assertFalse(actualJson.recordsAddedIsSet);
    assertFalse(actualJson.recordsRemovedIsSet);
    assertFalse(actualJson.recordsUpdatedIsSet);
    assertFalse(actualJson.skippedRowsIsSet);
  }

  /**
   * Test Json {@link Json#recordsAdded()}.
   *
   * <p>Method under test: {@link Json#recordsAdded()}
   */
  @Test
  @DisplayName("Test Json recordsAdded()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.recordsAdded()"})
  void testJsonRecordsAdded() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().recordsAdded());
  }

  /**
   * Test Json {@link Json#recordsRemoved()}.
   *
   * <p>Method under test: {@link Json#recordsRemoved()}
   */
  @Test
  @DisplayName("Test Json recordsRemoved()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.recordsRemoved()"})
  void testJsonRecordsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().recordsRemoved());
  }

  /**
   * Test Json {@link Json#recordsUpdated()}.
   *
   * <p>Method under test: {@link Json#recordsUpdated()}
   */
  @Test
  @DisplayName("Test Json recordsUpdated()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.recordsUpdated()"})
  void testJsonRecordsUpdated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().recordsUpdated());
  }

  /**
   * Test Json {@link Json#setAllocationsAdded(int)}.
   *
   * <p>Method under test: {@link Json#setAllocationsAdded(int)}
   */
  @Test
  @DisplayName("Test Json setAllocationsAdded(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setAllocationsAdded(int)"})
  void testJsonSetAllocationsAdded() {
    // Arrange
    Json json = new Json();

    // Act
    json.setAllocationsAdded(1);

    // Assert
    assertEquals(1, json.allocationsAdded);
    assertTrue(json.allocationsAddedIsSet);
  }

  /**
   * Test Json {@link Json#setRecordsAdded(int)}.
   *
   * <p>Method under test: {@link Json#setRecordsAdded(int)}
   */
  @Test
  @DisplayName("Test Json setRecordsAdded(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRecordsAdded(int)"})
  void testJsonSetRecordsAdded() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRecordsAdded(1);

    // Assert
    assertEquals(1, json.recordsAdded);
    assertTrue(json.recordsAddedIsSet);
  }

  /**
   * Test Json {@link Json#setRecordsRemoved(int)}.
   *
   * <p>Method under test: {@link Json#setRecordsRemoved(int)}
   */
  @Test
  @DisplayName("Test Json setRecordsRemoved(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRecordsRemoved(int)"})
  void testJsonSetRecordsRemoved() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRecordsRemoved(1);

    // Assert
    assertEquals(1, json.recordsRemoved);
    assertTrue(json.recordsRemovedIsSet);
  }

  /**
   * Test Json {@link Json#setRecordsUpdated(int)}.
   *
   * <p>Method under test: {@link Json#setRecordsUpdated(int)}
   */
  @Test
  @DisplayName("Test Json setRecordsUpdated(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRecordsUpdated(int)"})
  void testJsonSetRecordsUpdated() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRecordsUpdated(1);

    // Assert
    assertEquals(1, json.recordsUpdated);
    assertTrue(json.recordsUpdatedIsSet);
  }

  /**
   * Test Json {@link Json#setSkippedRows(int)}.
   *
   * <p>Method under test: {@link Json#setSkippedRows(int)}
   */
  @Test
  @DisplayName("Test Json setSkippedRows(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setSkippedRows(int)"})
  void testJsonSetSkippedRows() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSkippedRows(1);

    // Assert
    assertEquals(1, json.skippedRows);
    assertTrue(json.skippedRowsIsSet);
  }

  /**
   * Test Json {@link Json#skippedRows()}.
   *
   * <p>Method under test: {@link Json#skippedRows()}
   */
  @Test
  @DisplayName("Test Json skippedRows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.skippedRows()"})
  void testJsonSkippedRows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().skippedRows());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#withAllocationsAdded(int)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingApplyResult#withAllocationsAdded(int)}
   */
  @Test
  @DisplayName("Test withAllocationsAdded(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingApplyResult ImmutableBulkMeasurableRatingApplyResult.withAllocationsAdded(int)"
  })
  void testWithAllocationsAdded() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult immutableBulkMeasurableRatingApplyResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(42)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act
    ImmutableBulkMeasurableRatingApplyResult actualWithAllocationsAddedResult =
        immutableBulkMeasurableRatingApplyResult.withAllocationsAdded(42);

    // Assert
    assertSame(immutableBulkMeasurableRatingApplyResult, actualWithAllocationsAddedResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#withAllocationsAdded(int)}.
   *
   * <ul>
   *   <li>Then return recordsAdded is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkMeasurableRatingApplyResult#withAllocationsAdded(int)}
   */
  @Test
  @DisplayName("Test withAllocationsAdded(int); then return recordsAdded is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingApplyResult ImmutableBulkMeasurableRatingApplyResult.withAllocationsAdded(int)"
  })
  void testWithAllocationsAdded_thenReturnRecordsAddedIsOne() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingApplyResult actualWithAllocationsAddedResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build()
            .withAllocationsAdded(42);

    // Assert
    assertEquals(1, actualWithAllocationsAddedResult.recordsAdded());
    assertEquals(1, actualWithAllocationsAddedResult.recordsRemoved());
    assertEquals(1, actualWithAllocationsAddedResult.recordsUpdated());
    assertEquals(1, actualWithAllocationsAddedResult.skippedRows());
    assertEquals(42, actualWithAllocationsAddedResult.allocationsAdded());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#withRecordsAdded(int)}.
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingApplyResult#withRecordsAdded(int)}
   */
  @Test
  @DisplayName("Test withRecordsAdded(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingApplyResult ImmutableBulkMeasurableRatingApplyResult.withRecordsAdded(int)"
  })
  void testWithRecordsAdded() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult immutableBulkMeasurableRatingApplyResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(42)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act
    ImmutableBulkMeasurableRatingApplyResult actualWithRecordsAddedResult =
        immutableBulkMeasurableRatingApplyResult.withRecordsAdded(42);

    // Assert
    assertSame(immutableBulkMeasurableRatingApplyResult, actualWithRecordsAddedResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#withRecordsAdded(int)}.
   *
   * <ul>
   *   <li>Then return allocationsAdded is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingApplyResult#withRecordsAdded(int)}
   */
  @Test
  @DisplayName("Test withRecordsAdded(int); then return allocationsAdded is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingApplyResult ImmutableBulkMeasurableRatingApplyResult.withRecordsAdded(int)"
  })
  void testWithRecordsAdded_thenReturnAllocationsAddedIsOne() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingApplyResult actualWithRecordsAddedResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build()
            .withRecordsAdded(42);

    // Assert
    assertEquals(1, actualWithRecordsAddedResult.allocationsAdded());
    assertEquals(1, actualWithRecordsAddedResult.recordsRemoved());
    assertEquals(1, actualWithRecordsAddedResult.recordsUpdated());
    assertEquals(1, actualWithRecordsAddedResult.skippedRows());
    assertEquals(42, actualWithRecordsAddedResult.recordsAdded());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#withRecordsRemoved(int)}.
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingApplyResult#withRecordsRemoved(int)}
   */
  @Test
  @DisplayName("Test withRecordsRemoved(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingApplyResult ImmutableBulkMeasurableRatingApplyResult.withRecordsRemoved(int)"
  })
  void testWithRecordsRemoved() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult immutableBulkMeasurableRatingApplyResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(42)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act
    ImmutableBulkMeasurableRatingApplyResult actualWithRecordsRemovedResult =
        immutableBulkMeasurableRatingApplyResult.withRecordsRemoved(42);

    // Assert
    assertSame(immutableBulkMeasurableRatingApplyResult, actualWithRecordsRemovedResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#withRecordsRemoved(int)}.
   *
   * <ul>
   *   <li>Then return allocationsAdded is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingApplyResult#withRecordsRemoved(int)}
   */
  @Test
  @DisplayName("Test withRecordsRemoved(int); then return allocationsAdded is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingApplyResult ImmutableBulkMeasurableRatingApplyResult.withRecordsRemoved(int)"
  })
  void testWithRecordsRemoved_thenReturnAllocationsAddedIsOne() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingApplyResult actualWithRecordsRemovedResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build()
            .withRecordsRemoved(42);

    // Assert
    assertEquals(1, actualWithRecordsRemovedResult.allocationsAdded());
    assertEquals(1, actualWithRecordsRemovedResult.recordsAdded());
    assertEquals(1, actualWithRecordsRemovedResult.recordsUpdated());
    assertEquals(1, actualWithRecordsRemovedResult.skippedRows());
    assertEquals(42, actualWithRecordsRemovedResult.recordsRemoved());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#withRecordsUpdated(int)}.
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingApplyResult#withRecordsUpdated(int)}
   */
  @Test
  @DisplayName("Test withRecordsUpdated(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingApplyResult ImmutableBulkMeasurableRatingApplyResult.withRecordsUpdated(int)"
  })
  void testWithRecordsUpdated() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult immutableBulkMeasurableRatingApplyResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(42)
            .skippedRows(1)
            .build();

    // Act
    ImmutableBulkMeasurableRatingApplyResult actualWithRecordsUpdatedResult =
        immutableBulkMeasurableRatingApplyResult.withRecordsUpdated(42);

    // Assert
    assertSame(immutableBulkMeasurableRatingApplyResult, actualWithRecordsUpdatedResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#withRecordsUpdated(int)}.
   *
   * <ul>
   *   <li>Then return allocationsAdded is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingApplyResult#withRecordsUpdated(int)}
   */
  @Test
  @DisplayName("Test withRecordsUpdated(int); then return allocationsAdded is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingApplyResult ImmutableBulkMeasurableRatingApplyResult.withRecordsUpdated(int)"
  })
  void testWithRecordsUpdated_thenReturnAllocationsAddedIsOne() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingApplyResult actualWithRecordsUpdatedResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build()
            .withRecordsUpdated(42);

    // Assert
    assertEquals(1, actualWithRecordsUpdatedResult.allocationsAdded());
    assertEquals(1, actualWithRecordsUpdatedResult.recordsAdded());
    assertEquals(1, actualWithRecordsUpdatedResult.recordsRemoved());
    assertEquals(1, actualWithRecordsUpdatedResult.skippedRows());
    assertEquals(42, actualWithRecordsUpdatedResult.recordsUpdated());
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#withSkippedRows(int)}.
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingApplyResult#withSkippedRows(int)}
   */
  @Test
  @DisplayName("Test withSkippedRows(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingApplyResult ImmutableBulkMeasurableRatingApplyResult.withSkippedRows(int)"
  })
  void testWithSkippedRows() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult immutableBulkMeasurableRatingApplyResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(42)
            .build();

    // Act
    ImmutableBulkMeasurableRatingApplyResult actualWithSkippedRowsResult =
        immutableBulkMeasurableRatingApplyResult.withSkippedRows(42);

    // Assert
    assertSame(immutableBulkMeasurableRatingApplyResult, actualWithSkippedRowsResult);
  }

  /**
   * Test {@link ImmutableBulkMeasurableRatingApplyResult#withSkippedRows(int)}.
   *
   * <ul>
   *   <li>Then return allocationsAdded is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkMeasurableRatingApplyResult#withSkippedRows(int)}
   */
  @Test
  @DisplayName("Test withSkippedRows(int); then return allocationsAdded is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkMeasurableRatingApplyResult ImmutableBulkMeasurableRatingApplyResult.withSkippedRows(int)"
  })
  void testWithSkippedRows_thenReturnAllocationsAddedIsOne() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingApplyResult actualWithSkippedRowsResult =
        ImmutableBulkMeasurableRatingApplyResult.builder()
            .allocationsAdded(1)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build()
            .withSkippedRows(42);

    // Assert
    assertEquals(1, actualWithSkippedRowsResult.allocationsAdded());
    assertEquals(1, actualWithSkippedRowsResult.recordsAdded());
    assertEquals(1, actualWithSkippedRowsResult.recordsRemoved());
    assertEquals(1, actualWithSkippedRowsResult.recordsUpdated());
    assertEquals(42, actualWithSkippedRowsResult.skippedRows());
  }
}
