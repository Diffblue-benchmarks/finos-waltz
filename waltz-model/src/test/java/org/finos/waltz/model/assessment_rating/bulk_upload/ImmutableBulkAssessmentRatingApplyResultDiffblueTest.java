package org.finos.waltz.model.assessment_rating.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableBulkAssessmentRatingApplyResult.Builder;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableBulkAssessmentRatingApplyResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkAssessmentRatingApplyResultDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBulkAssessmentRatingApplyResult Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBulkAssessmentRatingApplyResult actualImmutableBulkAssessmentRatingApplyResult =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Assert
    assertEquals(1, actualImmutableBulkAssessmentRatingApplyResult.recordsAdded());
    assertEquals(1, actualImmutableBulkAssessmentRatingApplyResult.recordsRemoved());
    assertEquals(1, actualImmutableBulkAssessmentRatingApplyResult.recordsUpdated());
    assertEquals(1, actualImmutableBulkAssessmentRatingApplyResult.skippedRows());
  }

  /**
   * Test Builder {@link Builder#from(BulkAssessmentRatingApplyResult)}.
   *
   * <p>Method under test: {@link Builder#from(BulkAssessmentRatingApplyResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkAssessmentRatingApplyResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkAssessmentRatingApplyResult)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkAssessmentRatingApplyResult.builder();
    ImmutableBulkAssessmentRatingApplyResult instance =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkAssessmentRatingApplyResult actualImmutableBulkAssessmentRatingApplyResult =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkAssessmentRatingApplyResult);
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
    Builder builderResult = ImmutableBulkAssessmentRatingApplyResult.builder();

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
    Builder builderResult = ImmutableBulkAssessmentRatingApplyResult.builder();

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
    Builder builderResult = ImmutableBulkAssessmentRatingApplyResult.builder();

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
    Builder builderResult = ImmutableBulkAssessmentRatingApplyResult.builder();

    // Act
    Builder actualSkippedRowsResult = builderResult.skippedRows(1);

    // Assert
    assertSame(builderResult, actualSkippedRowsResult);
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#copyOf(BulkAssessmentRatingApplyResult)}.
   *
   * <ul>
   *   <li>Then return recordsAdded is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkAssessmentRatingApplyResult#copyOf(BulkAssessmentRatingApplyResult)}
   */
  @Test
  @DisplayName("Test copyOf(BulkAssessmentRatingApplyResult); then return recordsAdded is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingApplyResult ImmutableBulkAssessmentRatingApplyResult.copyOf(BulkAssessmentRatingApplyResult)"
  })
  void testCopyOf_thenReturnRecordsAddedIsOne() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult instance =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act
    ImmutableBulkAssessmentRatingApplyResult actualCopyOfResult =
        ImmutableBulkAssessmentRatingApplyResult.copyOf(instance);

    // Assert
    assertEquals(1, actualCopyOfResult.recordsAdded());
    assertEquals(1, actualCopyOfResult.recordsRemoved());
    assertEquals(1, actualCopyOfResult.recordsUpdated());
    assertEquals(1, actualCopyOfResult.skippedRows());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#equals(Object)}, and {@link
   * ImmutableBulkAssessmentRatingApplyResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkAssessmentRatingApplyResult#equals(Object)}
   *   <li>{@link ImmutableBulkAssessmentRatingApplyResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkAssessmentRatingApplyResult.equals(Object)",
    "int ImmutableBulkAssessmentRatingApplyResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult immutableBulkAssessmentRatingApplyResult =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();
    ImmutableBulkAssessmentRatingApplyResult immutableBulkAssessmentRatingApplyResult2 =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkAssessmentRatingApplyResult, immutableBulkAssessmentRatingApplyResult2);
    assertEquals(
        immutableBulkAssessmentRatingApplyResult.hashCode(),
        immutableBulkAssessmentRatingApplyResult2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#equals(Object)}, and {@link
   * ImmutableBulkAssessmentRatingApplyResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkAssessmentRatingApplyResult#equals(Object)}
   *   <li>{@link ImmutableBulkAssessmentRatingApplyResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkAssessmentRatingApplyResult.equals(Object)",
    "int ImmutableBulkAssessmentRatingApplyResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult immutableBulkAssessmentRatingApplyResult =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkAssessmentRatingApplyResult, immutableBulkAssessmentRatingApplyResult);
    int expectedHashCodeResult = immutableBulkAssessmentRatingApplyResult.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkAssessmentRatingApplyResult.hashCode());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkAssessmentRatingApplyResult.equals(Object)",
    "int ImmutableBulkAssessmentRatingApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult immutableBulkAssessmentRatingApplyResult =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(0)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkAssessmentRatingApplyResult,
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkAssessmentRatingApplyResult.equals(Object)",
    "int ImmutableBulkAssessmentRatingApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult immutableBulkAssessmentRatingApplyResult =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(0)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkAssessmentRatingApplyResult,
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkAssessmentRatingApplyResult.equals(Object)",
    "int ImmutableBulkAssessmentRatingApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult immutableBulkAssessmentRatingApplyResult =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(0)
            .skippedRows(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkAssessmentRatingApplyResult,
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkAssessmentRatingApplyResult.equals(Object)",
    "int ImmutableBulkAssessmentRatingApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult immutableBulkAssessmentRatingApplyResult =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(0)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkAssessmentRatingApplyResult,
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkAssessmentRatingApplyResult.equals(Object)",
    "int ImmutableBulkAssessmentRatingApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkAssessmentRatingApplyResult.equals(Object)",
    "int ImmutableBulkAssessmentRatingApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build(),
        "Different type to ImmutableBulkAssessmentRatingApplyResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkAssessmentRatingApplyResult#toString()}
   *   <li>{@link ImmutableBulkAssessmentRatingApplyResult#recordsAdded()}
   *   <li>{@link ImmutableBulkAssessmentRatingApplyResult#recordsRemoved()}
   *   <li>{@link ImmutableBulkAssessmentRatingApplyResult#recordsUpdated()}
   *   <li>{@link ImmutableBulkAssessmentRatingApplyResult#skippedRows()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableBulkAssessmentRatingApplyResult.recordsAdded()",
    "int ImmutableBulkAssessmentRatingApplyResult.recordsRemoved()",
    "int ImmutableBulkAssessmentRatingApplyResult.recordsUpdated()",
    "int ImmutableBulkAssessmentRatingApplyResult.skippedRows()",
    "String ImmutableBulkAssessmentRatingApplyResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult immutableBulkAssessmentRatingApplyResult =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act
    String actualToStringResult = immutableBulkAssessmentRatingApplyResult.toString();
    int actualRecordsAddedResult = immutableBulkAssessmentRatingApplyResult.recordsAdded();
    int actualRecordsRemovedResult = immutableBulkAssessmentRatingApplyResult.recordsRemoved();
    int actualRecordsUpdatedResult = immutableBulkAssessmentRatingApplyResult.recordsUpdated();

    // Assert
    assertEquals(
        "BulkAssessmentRatingApplyResult{recordsAdded=1, recordsUpdated=1, recordsRemoved=1, skippedRows=1}",
        actualToStringResult);
    assertEquals(1, actualRecordsAddedResult);
    assertEquals(1, actualRecordsRemovedResult);
    assertEquals(1, actualRecordsUpdatedResult);
    assertEquals(1, immutableBulkAssessmentRatingApplyResult.skippedRows());
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
    assertEquals(0, actualJson.recordsAdded);
    assertEquals(0, actualJson.recordsRemoved);
    assertEquals(0, actualJson.recordsUpdated);
    assertEquals(0, actualJson.skippedRows);
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
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#withRecordsAdded(int)}.
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingApplyResult#withRecordsAdded(int)}
   */
  @Test
  @DisplayName("Test withRecordsAdded(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingApplyResult ImmutableBulkAssessmentRatingApplyResult.withRecordsAdded(int)"
  })
  void testWithRecordsAdded() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult immutableBulkAssessmentRatingApplyResult =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(42)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act
    ImmutableBulkAssessmentRatingApplyResult actualWithRecordsAddedResult =
        immutableBulkAssessmentRatingApplyResult.withRecordsAdded(42);

    // Assert
    assertSame(immutableBulkAssessmentRatingApplyResult, actualWithRecordsAddedResult);
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#withRecordsAdded(int)}.
   *
   * <ul>
   *   <li>Then return recordsRemoved is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingApplyResult#withRecordsAdded(int)}
   */
  @Test
  @DisplayName("Test withRecordsAdded(int); then return recordsRemoved is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingApplyResult ImmutableBulkAssessmentRatingApplyResult.withRecordsAdded(int)"
  })
  void testWithRecordsAdded_thenReturnRecordsRemovedIsOne() {
    // Arrange and Act
    ImmutableBulkAssessmentRatingApplyResult actualWithRecordsAddedResult =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build()
            .withRecordsAdded(42);

    // Assert
    assertEquals(1, actualWithRecordsAddedResult.recordsRemoved());
    assertEquals(1, actualWithRecordsAddedResult.recordsUpdated());
    assertEquals(1, actualWithRecordsAddedResult.skippedRows());
    assertEquals(42, actualWithRecordsAddedResult.recordsAdded());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#withRecordsRemoved(int)}.
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingApplyResult#withRecordsRemoved(int)}
   */
  @Test
  @DisplayName("Test withRecordsRemoved(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingApplyResult ImmutableBulkAssessmentRatingApplyResult.withRecordsRemoved(int)"
  })
  void testWithRecordsRemoved() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult immutableBulkAssessmentRatingApplyResult =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(42)
            .recordsUpdated(1)
            .skippedRows(1)
            .build();

    // Act
    ImmutableBulkAssessmentRatingApplyResult actualWithRecordsRemovedResult =
        immutableBulkAssessmentRatingApplyResult.withRecordsRemoved(42);

    // Assert
    assertSame(immutableBulkAssessmentRatingApplyResult, actualWithRecordsRemovedResult);
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#withRecordsRemoved(int)}.
   *
   * <ul>
   *   <li>Then return recordsAdded is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingApplyResult#withRecordsRemoved(int)}
   */
  @Test
  @DisplayName("Test withRecordsRemoved(int); then return recordsAdded is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingApplyResult ImmutableBulkAssessmentRatingApplyResult.withRecordsRemoved(int)"
  })
  void testWithRecordsRemoved_thenReturnRecordsAddedIsOne() {
    // Arrange and Act
    ImmutableBulkAssessmentRatingApplyResult actualWithRecordsRemovedResult =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build()
            .withRecordsRemoved(42);

    // Assert
    assertEquals(1, actualWithRecordsRemovedResult.recordsAdded());
    assertEquals(1, actualWithRecordsRemovedResult.recordsUpdated());
    assertEquals(1, actualWithRecordsRemovedResult.skippedRows());
    assertEquals(42, actualWithRecordsRemovedResult.recordsRemoved());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#withRecordsUpdated(int)}.
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingApplyResult#withRecordsUpdated(int)}
   */
  @Test
  @DisplayName("Test withRecordsUpdated(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingApplyResult ImmutableBulkAssessmentRatingApplyResult.withRecordsUpdated(int)"
  })
  void testWithRecordsUpdated() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult immutableBulkAssessmentRatingApplyResult =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(42)
            .skippedRows(1)
            .build();

    // Act
    ImmutableBulkAssessmentRatingApplyResult actualWithRecordsUpdatedResult =
        immutableBulkAssessmentRatingApplyResult.withRecordsUpdated(42);

    // Assert
    assertSame(immutableBulkAssessmentRatingApplyResult, actualWithRecordsUpdatedResult);
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#withRecordsUpdated(int)}.
   *
   * <ul>
   *   <li>Then return recordsAdded is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingApplyResult#withRecordsUpdated(int)}
   */
  @Test
  @DisplayName("Test withRecordsUpdated(int); then return recordsAdded is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingApplyResult ImmutableBulkAssessmentRatingApplyResult.withRecordsUpdated(int)"
  })
  void testWithRecordsUpdated_thenReturnRecordsAddedIsOne() {
    // Arrange and Act
    ImmutableBulkAssessmentRatingApplyResult actualWithRecordsUpdatedResult =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build()
            .withRecordsUpdated(42);

    // Assert
    assertEquals(1, actualWithRecordsUpdatedResult.recordsAdded());
    assertEquals(1, actualWithRecordsUpdatedResult.recordsRemoved());
    assertEquals(1, actualWithRecordsUpdatedResult.skippedRows());
    assertEquals(42, actualWithRecordsUpdatedResult.recordsUpdated());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#withSkippedRows(int)}.
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingApplyResult#withSkippedRows(int)}
   */
  @Test
  @DisplayName("Test withSkippedRows(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingApplyResult ImmutableBulkAssessmentRatingApplyResult.withSkippedRows(int)"
  })
  void testWithSkippedRows() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult immutableBulkAssessmentRatingApplyResult =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(42)
            .build();

    // Act
    ImmutableBulkAssessmentRatingApplyResult actualWithSkippedRowsResult =
        immutableBulkAssessmentRatingApplyResult.withSkippedRows(42);

    // Assert
    assertSame(immutableBulkAssessmentRatingApplyResult, actualWithSkippedRowsResult);
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingApplyResult#withSkippedRows(int)}.
   *
   * <ul>
   *   <li>Then return recordsAdded is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingApplyResult#withSkippedRows(int)}
   */
  @Test
  @DisplayName("Test withSkippedRows(int); then return recordsAdded is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingApplyResult ImmutableBulkAssessmentRatingApplyResult.withSkippedRows(int)"
  })
  void testWithSkippedRows_thenReturnRecordsAddedIsOne() {
    // Arrange and Act
    ImmutableBulkAssessmentRatingApplyResult actualWithSkippedRowsResult =
        ImmutableBulkAssessmentRatingApplyResult.builder()
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsUpdated(1)
            .skippedRows(1)
            .build()
            .withSkippedRows(42);

    // Assert
    assertEquals(1, actualWithSkippedRowsResult.recordsAdded());
    assertEquals(1, actualWithSkippedRowsResult.recordsRemoved());
    assertEquals(1, actualWithSkippedRowsResult.recordsUpdated());
    assertEquals(42, actualWithSkippedRowsResult.skippedRows());
  }
}
