package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipApplyResult.Builder;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipApplyResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipApplyResultDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBulkUploadRelationshipApplyResult Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipApplyResult actualImmutableBulkUploadRelationshipApplyResult =
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build();

    // Assert
    assertEquals(1L, actualImmutableBulkUploadRelationshipApplyResult.recordsAdded().longValue());
    assertEquals(1L, actualImmutableBulkUploadRelationshipApplyResult.recordsUpdated().longValue());
    assertEquals(1L, actualImmutableBulkUploadRelationshipApplyResult.skippedRows().longValue());
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipApplyResult)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUploadRelationshipApplyResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipApplyResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipApplyResult)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipApplyResult.builder();
    ImmutableBulkUploadRelationshipApplyResult instance =
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUploadRelationshipApplyResult actualImmutableBulkUploadRelationshipApplyResult =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkUploadRelationshipApplyResult);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#recordsAdded(Long)}.
   *
   * <p>Method under test: {@link Builder#recordsAdded(Long)}
   */
  @Test
  @DisplayName("Test Builder recordsAdded(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.recordsAdded(Long)"})
  void testBuilderRecordsAdded() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipApplyResult.builder();

    // Act
    Builder actualRecordsAddedResult = builderResult.recordsAdded(1L);

    // Assert
    assertSame(builderResult, actualRecordsAddedResult);
  }

  /**
   * Test Builder {@link Builder#recordsUpdated(Long)}.
   *
   * <p>Method under test: {@link Builder#recordsUpdated(Long)}
   */
  @Test
  @DisplayName("Test Builder recordsUpdated(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.recordsUpdated(Long)"})
  void testBuilderRecordsUpdated() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipApplyResult.builder();

    // Act
    Builder actualRecordsUpdatedResult = builderResult.recordsUpdated(1L);

    // Assert
    assertSame(builderResult, actualRecordsUpdatedResult);
  }

  /**
   * Test Builder {@link Builder#skippedRows(Long)}.
   *
   * <p>Method under test: {@link Builder#skippedRows(Long)}
   */
  @Test
  @DisplayName("Test Builder skippedRows(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.skippedRows(Long)"})
  void testBuilderSkippedRows() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipApplyResult.builder();

    // Act
    Builder actualSkippedRowsResult = builderResult.skippedRows(1L);

    // Assert
    assertSame(builderResult, actualSkippedRowsResult);
  }

  /**
   * Test {@link
   * ImmutableBulkUploadRelationshipApplyResult#copyOf(BulkUploadRelationshipApplyResult)}.
   *
   * <ul>
   *   <li>Then return recordsAdded longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipApplyResult#copyOf(BulkUploadRelationshipApplyResult)}
   */
  @Test
  @DisplayName(
      "Test copyOf(BulkUploadRelationshipApplyResult); then return recordsAdded longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipApplyResult ImmutableBulkUploadRelationshipApplyResult.copyOf(BulkUploadRelationshipApplyResult)"
  })
  void testCopyOf_thenReturnRecordsAddedLongValueIsOne() {
    // Arrange
    ImmutableBulkUploadRelationshipApplyResult instance =
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build();

    // Act
    ImmutableBulkUploadRelationshipApplyResult actualCopyOfResult =
        ImmutableBulkUploadRelationshipApplyResult.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.recordsAdded().longValue());
    assertEquals(1L, actualCopyOfResult.recordsUpdated().longValue());
    assertEquals(1L, actualCopyOfResult.skippedRows().longValue());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipApplyResult#equals(Object)}, and {@link
   * ImmutableBulkUploadRelationshipApplyResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipApplyResult#equals(Object)}
   *   <li>{@link ImmutableBulkUploadRelationshipApplyResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipApplyResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipApplyResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBulkUploadRelationshipApplyResult immutableBulkUploadRelationshipApplyResult =
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build();
    ImmutableBulkUploadRelationshipApplyResult immutableBulkUploadRelationshipApplyResult2 =
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkUploadRelationshipApplyResult, immutableBulkUploadRelationshipApplyResult2);
    assertEquals(
        immutableBulkUploadRelationshipApplyResult.hashCode(),
        immutableBulkUploadRelationshipApplyResult2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipApplyResult#equals(Object)}, and {@link
   * ImmutableBulkUploadRelationshipApplyResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipApplyResult#equals(Object)}
   *   <li>{@link ImmutableBulkUploadRelationshipApplyResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipApplyResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipApplyResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBulkUploadRelationshipApplyResult immutableBulkUploadRelationshipApplyResult =
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build();

    // Act and Assert
    assertEquals(
        immutableBulkUploadRelationshipApplyResult, immutableBulkUploadRelationshipApplyResult);
    int expectedHashCodeResult = immutableBulkUploadRelationshipApplyResult.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkUploadRelationshipApplyResult.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipApplyResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableBulkUploadRelationshipApplyResult immutableBulkUploadRelationshipApplyResult =
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(0L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUploadRelationshipApplyResult,
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipApplyResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableBulkUploadRelationshipApplyResult immutableBulkUploadRelationshipApplyResult =
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(0L)
            .skippedRows(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUploadRelationshipApplyResult,
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipApplyResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableBulkUploadRelationshipApplyResult immutableBulkUploadRelationshipApplyResult =
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(0L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkUploadRelationshipApplyResult,
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipApplyResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadRelationshipApplyResult.equals(Object)",
    "int ImmutableBulkUploadRelationshipApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build(),
        "Different type to ImmutableBulkUploadRelationshipApplyResult");
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipApplyResult#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) RecordsUpdated is one.
   *   <li>Then return recordsAdded longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipApplyResult#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) RecordsUpdated is one; then return recordsAdded longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipApplyResult ImmutableBulkUploadRelationshipApplyResult.fromJson(Json)"
  })
  void testFromJson_whenJsonRecordsUpdatedIsOne_thenReturnRecordsAddedLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setRecordsAdded(1L);
    json.setRecordsUpdated(1L);
    json.setSkippedRows(1L);

    // Act
    ImmutableBulkUploadRelationshipApplyResult actualFromJsonResult =
        ImmutableBulkUploadRelationshipApplyResult.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.recordsAdded().longValue());
    assertEquals(1L, actualFromJsonResult.recordsUpdated().longValue());
    assertEquals(1L, actualFromJsonResult.skippedRows().longValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipApplyResult#toString()}
   *   <li>{@link ImmutableBulkUploadRelationshipApplyResult#recordsAdded()}
   *   <li>{@link ImmutableBulkUploadRelationshipApplyResult#recordsUpdated()}
   *   <li>{@link ImmutableBulkUploadRelationshipApplyResult#skippedRows()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableBulkUploadRelationshipApplyResult.recordsAdded()",
    "Long ImmutableBulkUploadRelationshipApplyResult.recordsUpdated()",
    "Long ImmutableBulkUploadRelationshipApplyResult.skippedRows()",
    "String ImmutableBulkUploadRelationshipApplyResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableBulkUploadRelationshipApplyResult immutableBulkUploadRelationshipApplyResult =
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build();

    // Act
    String actualToStringResult = immutableBulkUploadRelationshipApplyResult.toString();
    Long actualRecordsAddedResult = immutableBulkUploadRelationshipApplyResult.recordsAdded();
    Long actualRecordsUpdatedResult = immutableBulkUploadRelationshipApplyResult.recordsUpdated();
    Long actualSkippedRowsResult = immutableBulkUploadRelationshipApplyResult.skippedRows();

    // Assert
    assertEquals(
        "BulkUploadRelationshipApplyResult{recordsAdded=1, recordsUpdated=1, skippedRows=1}",
        actualToStringResult);
    assertEquals(1L, actualRecordsAddedResult.longValue());
    assertEquals(1L, actualRecordsUpdatedResult.longValue());
    assertEquals(1L, actualSkippedRowsResult.longValue());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setRecordsAdded(Long)}
   *   <li>{@link Json#setRecordsUpdated(Long)}
   *   <li>{@link Json#setSkippedRows(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setRecordsAdded(Long)",
    "void Json.setRecordsUpdated(Long)",
    "void Json.setSkippedRows(Long)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setRecordsAdded(1L);
    actualJson.setRecordsUpdated(1L);
    actualJson.setSkippedRows(1L);

    // Assert
    assertEquals(1L, actualJson.recordsAdded.longValue());
    assertEquals(1L, actualJson.recordsUpdated.longValue());
    assertEquals(1L, actualJson.skippedRows.longValue());
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
  @MethodsUnderTest({"Long Json.recordsAdded()"})
  void testJsonRecordsAdded() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().recordsAdded());
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
  @MethodsUnderTest({"Long Json.recordsUpdated()"})
  void testJsonRecordsUpdated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().recordsUpdated());
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
  @MethodsUnderTest({"Long Json.skippedRows()"})
  void testJsonSkippedRows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().skippedRows());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipApplyResult#withRecordsAdded(Long)}.
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipApplyResult#withRecordsAdded(Long)}
   */
  @Test
  @DisplayName("Test withRecordsAdded(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipApplyResult ImmutableBulkUploadRelationshipApplyResult.withRecordsAdded(Long)"
  })
  void testWithRecordsAdded() {
    // Arrange
    ImmutableBulkUploadRelationshipApplyResult immutableBulkUploadRelationshipApplyResult =
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build();

    // Act
    ImmutableBulkUploadRelationshipApplyResult actualWithRecordsAddedResult =
        immutableBulkUploadRelationshipApplyResult.withRecordsAdded(1L);

    // Assert
    assertSame(immutableBulkUploadRelationshipApplyResult, actualWithRecordsAddedResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipApplyResult#withRecordsAdded(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return recordsUpdated longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipApplyResult#withRecordsAdded(Long)}
   */
  @Test
  @DisplayName(
      "Test withRecordsAdded(Long); when forty-two; then return recordsUpdated longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipApplyResult ImmutableBulkUploadRelationshipApplyResult.withRecordsAdded(Long)"
  })
  void testWithRecordsAdded_whenFortyTwo_thenReturnRecordsUpdatedLongValueIsOne() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipApplyResult actualWithRecordsAddedResult =
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build()
            .withRecordsAdded(42L);

    // Assert
    assertEquals(1L, actualWithRecordsAddedResult.recordsUpdated().longValue());
    assertEquals(1L, actualWithRecordsAddedResult.skippedRows().longValue());
    assertEquals(42L, actualWithRecordsAddedResult.recordsAdded().longValue());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipApplyResult#withRecordsUpdated(Long)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipApplyResult#withRecordsUpdated(Long)}
   */
  @Test
  @DisplayName("Test withRecordsUpdated(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipApplyResult ImmutableBulkUploadRelationshipApplyResult.withRecordsUpdated(Long)"
  })
  void testWithRecordsUpdated() {
    // Arrange
    ImmutableBulkUploadRelationshipApplyResult immutableBulkUploadRelationshipApplyResult =
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build();

    // Act
    ImmutableBulkUploadRelationshipApplyResult actualWithRecordsUpdatedResult =
        immutableBulkUploadRelationshipApplyResult.withRecordsUpdated(1L);

    // Assert
    assertSame(immutableBulkUploadRelationshipApplyResult, actualWithRecordsUpdatedResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipApplyResult#withRecordsUpdated(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return recordsAdded longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadRelationshipApplyResult#withRecordsUpdated(Long)}
   */
  @Test
  @DisplayName(
      "Test withRecordsUpdated(Long); when forty-two; then return recordsAdded longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipApplyResult ImmutableBulkUploadRelationshipApplyResult.withRecordsUpdated(Long)"
  })
  void testWithRecordsUpdated_whenFortyTwo_thenReturnRecordsAddedLongValueIsOne() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipApplyResult actualWithRecordsUpdatedResult =
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build()
            .withRecordsUpdated(42L);

    // Assert
    assertEquals(1L, actualWithRecordsUpdatedResult.recordsAdded().longValue());
    assertEquals(1L, actualWithRecordsUpdatedResult.skippedRows().longValue());
    assertEquals(42L, actualWithRecordsUpdatedResult.recordsUpdated().longValue());
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipApplyResult#withSkippedRows(Long)}.
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipApplyResult#withSkippedRows(Long)}
   */
  @Test
  @DisplayName("Test withSkippedRows(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipApplyResult ImmutableBulkUploadRelationshipApplyResult.withSkippedRows(Long)"
  })
  void testWithSkippedRows() {
    // Arrange
    ImmutableBulkUploadRelationshipApplyResult immutableBulkUploadRelationshipApplyResult =
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build();

    // Act
    ImmutableBulkUploadRelationshipApplyResult actualWithSkippedRowsResult =
        immutableBulkUploadRelationshipApplyResult.withSkippedRows(1L);

    // Assert
    assertSame(immutableBulkUploadRelationshipApplyResult, actualWithSkippedRowsResult);
  }

  /**
   * Test {@link ImmutableBulkUploadRelationshipApplyResult#withSkippedRows(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return recordsAdded longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadRelationshipApplyResult#withSkippedRows(Long)}
   */
  @Test
  @DisplayName(
      "Test withSkippedRows(Long); when forty-two; then return recordsAdded longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadRelationshipApplyResult ImmutableBulkUploadRelationshipApplyResult.withSkippedRows(Long)"
  })
  void testWithSkippedRows_whenFortyTwo_thenReturnRecordsAddedLongValueIsOne() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipApplyResult actualWithSkippedRowsResult =
        ImmutableBulkUploadRelationshipApplyResult.builder()
            .recordsAdded(1L)
            .recordsUpdated(1L)
            .skippedRows(1L)
            .build()
            .withSkippedRows(42L);

    // Assert
    assertEquals(1L, actualWithSkippedRowsResult.recordsAdded().longValue());
    assertEquals(1L, actualWithSkippedRowsResult.recordsUpdated().longValue());
    assertEquals(42L, actualWithSkippedRowsResult.skippedRows().longValue());
  }
}
