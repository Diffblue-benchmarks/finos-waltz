package org.finos.waltz.model.bulk_upload.taxonomy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyApplyResult.Builder;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyApplyResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkTaxonomyApplyResultDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBulkTaxonomyApplyResult Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBulkTaxonomyApplyResult actualImmutableBulkTaxonomyApplyResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build();

    // Assert
    assertEquals(1, actualImmutableBulkTaxonomyApplyResult.recordsAdded());
    assertEquals(1, actualImmutableBulkTaxonomyApplyResult.recordsRemoved());
    assertEquals(1, actualImmutableBulkTaxonomyApplyResult.recordsRestored());
    assertEquals(1, actualImmutableBulkTaxonomyApplyResult.recordsUpdated());
    assertTrue(actualImmutableBulkTaxonomyApplyResult.hierarchyRebuilt());
  }

  /**
   * Test Builder {@link Builder#from(BulkTaxonomyApplyResult)}.
   *
   * <p>Method under test: {@link Builder#from(BulkTaxonomyApplyResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyApplyResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyApplyResult)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();
    ImmutableBulkTaxonomyApplyResult instance =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkTaxonomyApplyResult actualImmutableBulkTaxonomyApplyResult = builderResult.build();
    assertEquals(instance, actualImmutableBulkTaxonomyApplyResult);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#hierarchyRebuilt(boolean)}.
   *
   * <p>Method under test: {@link Builder#hierarchyRebuilt(boolean)}
   */
  @Test
  @DisplayName("Test Builder hierarchyRebuilt(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.hierarchyRebuilt(boolean)"})
  void testBuilderHierarchyRebuilt() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();

    // Act
    Builder actualHierarchyRebuiltResult = builderResult.hierarchyRebuilt(true);

    // Assert
    assertSame(builderResult, actualHierarchyRebuiltResult);
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
    Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();

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
    Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();

    // Act
    Builder actualRecordsRemovedResult = builderResult.recordsRemoved(1);

    // Assert
    assertSame(builderResult, actualRecordsRemovedResult);
  }

  /**
   * Test Builder {@link Builder#recordsRestored(int)}.
   *
   * <p>Method under test: {@link Builder#recordsRestored(int)}
   */
  @Test
  @DisplayName("Test Builder recordsRestored(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.recordsRestored(int)"})
  void testBuilderRecordsRestored() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();

    // Act
    Builder actualRecordsRestoredResult = builderResult.recordsRestored(1);

    // Assert
    assertSame(builderResult, actualRecordsRestoredResult);
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
    Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();

    // Act
    Builder actualRecordsUpdatedResult = builderResult.recordsUpdated(1);

    // Assert
    assertSame(builderResult, actualRecordsUpdatedResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#copyOf(BulkTaxonomyApplyResult)}.
   *
   * <ul>
   *   <li>Then return recordsAdded is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#copyOf(BulkTaxonomyApplyResult)}
   */
  @Test
  @DisplayName("Test copyOf(BulkTaxonomyApplyResult); then return recordsAdded is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyApplyResult ImmutableBulkTaxonomyApplyResult.copyOf(BulkTaxonomyApplyResult)"
  })
  void testCopyOf_thenReturnRecordsAddedIsOne() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult instance =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build();

    // Act
    ImmutableBulkTaxonomyApplyResult actualCopyOfResult =
        ImmutableBulkTaxonomyApplyResult.copyOf(instance);

    // Assert
    assertEquals(1, actualCopyOfResult.recordsAdded());
    assertEquals(1, actualCopyOfResult.recordsRemoved());
    assertEquals(1, actualCopyOfResult.recordsRestored());
    assertEquals(1, actualCopyOfResult.recordsUpdated());
    assertTrue(actualCopyOfResult.hierarchyRebuilt());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#equals(Object)}, and {@link
   * ImmutableBulkTaxonomyApplyResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyApplyResult#equals(Object)}
   *   <li>{@link ImmutableBulkTaxonomyApplyResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyApplyResult.equals(Object)",
    "int ImmutableBulkTaxonomyApplyResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult immutableBulkTaxonomyApplyResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build();
    ImmutableBulkTaxonomyApplyResult immutableBulkTaxonomyApplyResult2 =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build();

    // Act and Assert
    assertEquals(immutableBulkTaxonomyApplyResult, immutableBulkTaxonomyApplyResult2);
    assertEquals(
        immutableBulkTaxonomyApplyResult.hashCode(), immutableBulkTaxonomyApplyResult2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#equals(Object)}, and {@link
   * ImmutableBulkTaxonomyApplyResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyApplyResult#equals(Object)}
   *   <li>{@link ImmutableBulkTaxonomyApplyResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyApplyResult.equals(Object)",
    "int ImmutableBulkTaxonomyApplyResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult immutableBulkTaxonomyApplyResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build();

    // Act and Assert
    assertEquals(immutableBulkTaxonomyApplyResult, immutableBulkTaxonomyApplyResult);
    int expectedHashCodeResult = immutableBulkTaxonomyApplyResult.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkTaxonomyApplyResult.hashCode());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyApplyResult.equals(Object)",
    "int ImmutableBulkTaxonomyApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult immutableBulkTaxonomyApplyResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(false)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyApplyResult,
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyApplyResult.equals(Object)",
    "int ImmutableBulkTaxonomyApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult immutableBulkTaxonomyApplyResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(0)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyApplyResult,
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyApplyResult.equals(Object)",
    "int ImmutableBulkTaxonomyApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult immutableBulkTaxonomyApplyResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(0)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyApplyResult,
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyApplyResult.equals(Object)",
    "int ImmutableBulkTaxonomyApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult immutableBulkTaxonomyApplyResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(0)
            .recordsUpdated(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyApplyResult,
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyApplyResult.equals(Object)",
    "int ImmutableBulkTaxonomyApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult immutableBulkTaxonomyApplyResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(0)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkTaxonomyApplyResult,
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyApplyResult.equals(Object)",
    "int ImmutableBulkTaxonomyApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyApplyResult.equals(Object)",
    "int ImmutableBulkTaxonomyApplyResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build(),
        "Different type to ImmutableBulkTaxonomyApplyResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyApplyResult#toString()}
   *   <li>{@link ImmutableBulkTaxonomyApplyResult#hierarchyRebuilt()}
   *   <li>{@link ImmutableBulkTaxonomyApplyResult#recordsAdded()}
   *   <li>{@link ImmutableBulkTaxonomyApplyResult#recordsRemoved()}
   *   <li>{@link ImmutableBulkTaxonomyApplyResult#recordsRestored()}
   *   <li>{@link ImmutableBulkTaxonomyApplyResult#recordsUpdated()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkTaxonomyApplyResult.hierarchyRebuilt()",
    "int ImmutableBulkTaxonomyApplyResult.recordsAdded()",
    "int ImmutableBulkTaxonomyApplyResult.recordsRemoved()",
    "int ImmutableBulkTaxonomyApplyResult.recordsRestored()",
    "int ImmutableBulkTaxonomyApplyResult.recordsUpdated()",
    "String ImmutableBulkTaxonomyApplyResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult immutableBulkTaxonomyApplyResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build();

    // Act
    String actualToStringResult = immutableBulkTaxonomyApplyResult.toString();
    boolean actualHierarchyRebuiltResult = immutableBulkTaxonomyApplyResult.hierarchyRebuilt();
    int actualRecordsAddedResult = immutableBulkTaxonomyApplyResult.recordsAdded();
    int actualRecordsRemovedResult = immutableBulkTaxonomyApplyResult.recordsRemoved();
    int actualRecordsRestoredResult = immutableBulkTaxonomyApplyResult.recordsRestored();

    // Assert
    assertEquals(
        "BulkTaxonomyApplyResult{recordsAdded=1, recordsUpdated=1, recordsRemoved=1, recordsRestored=1,"
            + " hierarchyRebuilt=true}",
        actualToStringResult);
    assertEquals(1, actualRecordsAddedResult);
    assertEquals(1, actualRecordsRemovedResult);
    assertEquals(1, actualRecordsRestoredResult);
    assertEquals(1, immutableBulkTaxonomyApplyResult.recordsUpdated());
    assertTrue(actualHierarchyRebuiltResult);
  }

  /**
   * Test Json {@link Json#hierarchyRebuilt()}.
   *
   * <p>Method under test: {@link Json#hierarchyRebuilt()}
   */
  @Test
  @DisplayName("Test Json hierarchyRebuilt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.hierarchyRebuilt()"})
  void testJsonHierarchyRebuilt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().hierarchyRebuilt());
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
    assertEquals(0, actualJson.recordsRestored);
    assertEquals(0, actualJson.recordsUpdated);
    assertFalse(actualJson.hierarchyRebuilt);
    assertFalse(actualJson.hierarchyRebuiltIsSet);
    assertFalse(actualJson.recordsAddedIsSet);
    assertFalse(actualJson.recordsRemovedIsSet);
    assertFalse(actualJson.recordsRestoredIsSet);
    assertFalse(actualJson.recordsUpdatedIsSet);
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
   * Test Json {@link Json#recordsRestored()}.
   *
   * <p>Method under test: {@link Json#recordsRestored()}
   */
  @Test
  @DisplayName("Test Json recordsRestored()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.recordsRestored()"})
  void testJsonRecordsRestored() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().recordsRestored());
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
   * Test Json {@link Json#setHierarchyRebuilt(boolean)}.
   *
   * <p>Method under test: {@link Json#setHierarchyRebuilt(boolean)}
   */
  @Test
  @DisplayName("Test Json setHierarchyRebuilt(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setHierarchyRebuilt(boolean)"})
  void testJsonSetHierarchyRebuilt() {
    // Arrange
    Json json = new Json();

    // Act
    json.setHierarchyRebuilt(true);

    // Assert
    assertTrue(json.hierarchyRebuilt);
    assertTrue(json.hierarchyRebuiltIsSet);
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
   * Test Json {@link Json#setRecordsRestored(int)}.
   *
   * <p>Method under test: {@link Json#setRecordsRestored(int)}
   */
  @Test
  @DisplayName("Test Json setRecordsRestored(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRecordsRestored(int)"})
  void testJsonSetRecordsRestored() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRecordsRestored(1);

    // Assert
    assertEquals(1, json.recordsRestored);
    assertTrue(json.recordsRestoredIsSet);
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
   * Test {@link ImmutableBulkTaxonomyApplyResult#withHierarchyRebuilt(boolean)}.
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#withHierarchyRebuilt(boolean)}
   */
  @Test
  @DisplayName("Test withHierarchyRebuilt(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyApplyResult ImmutableBulkTaxonomyApplyResult.withHierarchyRebuilt(boolean)"
  })
  void testWithHierarchyRebuilt() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult immutableBulkTaxonomyApplyResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build();

    // Act
    ImmutableBulkTaxonomyApplyResult actualWithHierarchyRebuiltResult =
        immutableBulkTaxonomyApplyResult.withHierarchyRebuilt(true);

    // Assert
    assertSame(immutableBulkTaxonomyApplyResult, actualWithHierarchyRebuiltResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#withHierarchyRebuilt(boolean)}.
   *
   * <ul>
   *   <li>Then return recordsAdded is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#withHierarchyRebuilt(boolean)}
   */
  @Test
  @DisplayName("Test withHierarchyRebuilt(boolean); then return recordsAdded is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyApplyResult ImmutableBulkTaxonomyApplyResult.withHierarchyRebuilt(boolean)"
  })
  void testWithHierarchyRebuilt_thenReturnRecordsAddedIsOne() {
    // Arrange and Act
    ImmutableBulkTaxonomyApplyResult actualWithHierarchyRebuiltResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(false)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build()
            .withHierarchyRebuilt(true);

    // Assert
    assertEquals(1, actualWithHierarchyRebuiltResult.recordsAdded());
    assertEquals(1, actualWithHierarchyRebuiltResult.recordsRemoved());
    assertEquals(1, actualWithHierarchyRebuiltResult.recordsRestored());
    assertEquals(1, actualWithHierarchyRebuiltResult.recordsUpdated());
    assertTrue(actualWithHierarchyRebuiltResult.hierarchyRebuilt());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#withRecordsAdded(int)}.
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#withRecordsAdded(int)}
   */
  @Test
  @DisplayName("Test withRecordsAdded(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyApplyResult ImmutableBulkTaxonomyApplyResult.withRecordsAdded(int)"
  })
  void testWithRecordsAdded() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult immutableBulkTaxonomyApplyResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(42)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build();

    // Act
    ImmutableBulkTaxonomyApplyResult actualWithRecordsAddedResult =
        immutableBulkTaxonomyApplyResult.withRecordsAdded(42);

    // Assert
    assertSame(immutableBulkTaxonomyApplyResult, actualWithRecordsAddedResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#withRecordsAdded(int)}.
   *
   * <ul>
   *   <li>Then return recordsRemoved is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#withRecordsAdded(int)}
   */
  @Test
  @DisplayName("Test withRecordsAdded(int); then return recordsRemoved is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyApplyResult ImmutableBulkTaxonomyApplyResult.withRecordsAdded(int)"
  })
  void testWithRecordsAdded_thenReturnRecordsRemovedIsOne() {
    // Arrange and Act
    ImmutableBulkTaxonomyApplyResult actualWithRecordsAddedResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build()
            .withRecordsAdded(42);

    // Assert
    assertEquals(1, actualWithRecordsAddedResult.recordsRemoved());
    assertEquals(1, actualWithRecordsAddedResult.recordsRestored());
    assertEquals(1, actualWithRecordsAddedResult.recordsUpdated());
    assertEquals(42, actualWithRecordsAddedResult.recordsAdded());
    assertTrue(actualWithRecordsAddedResult.hierarchyRebuilt());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#withRecordsRemoved(int)}.
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#withRecordsRemoved(int)}
   */
  @Test
  @DisplayName("Test withRecordsRemoved(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyApplyResult ImmutableBulkTaxonomyApplyResult.withRecordsRemoved(int)"
  })
  void testWithRecordsRemoved() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult immutableBulkTaxonomyApplyResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(42)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build();

    // Act
    ImmutableBulkTaxonomyApplyResult actualWithRecordsRemovedResult =
        immutableBulkTaxonomyApplyResult.withRecordsRemoved(42);

    // Assert
    assertSame(immutableBulkTaxonomyApplyResult, actualWithRecordsRemovedResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#withRecordsRemoved(int)}.
   *
   * <ul>
   *   <li>Then return recordsAdded is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#withRecordsRemoved(int)}
   */
  @Test
  @DisplayName("Test withRecordsRemoved(int); then return recordsAdded is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyApplyResult ImmutableBulkTaxonomyApplyResult.withRecordsRemoved(int)"
  })
  void testWithRecordsRemoved_thenReturnRecordsAddedIsOne() {
    // Arrange and Act
    ImmutableBulkTaxonomyApplyResult actualWithRecordsRemovedResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build()
            .withRecordsRemoved(42);

    // Assert
    assertEquals(1, actualWithRecordsRemovedResult.recordsAdded());
    assertEquals(1, actualWithRecordsRemovedResult.recordsRestored());
    assertEquals(1, actualWithRecordsRemovedResult.recordsUpdated());
    assertEquals(42, actualWithRecordsRemovedResult.recordsRemoved());
    assertTrue(actualWithRecordsRemovedResult.hierarchyRebuilt());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#withRecordsRestored(int)}.
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#withRecordsRestored(int)}
   */
  @Test
  @DisplayName("Test withRecordsRestored(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyApplyResult ImmutableBulkTaxonomyApplyResult.withRecordsRestored(int)"
  })
  void testWithRecordsRestored() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult immutableBulkTaxonomyApplyResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(42)
            .recordsUpdated(1)
            .build();

    // Act
    ImmutableBulkTaxonomyApplyResult actualWithRecordsRestoredResult =
        immutableBulkTaxonomyApplyResult.withRecordsRestored(42);

    // Assert
    assertSame(immutableBulkTaxonomyApplyResult, actualWithRecordsRestoredResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#withRecordsRestored(int)}.
   *
   * <ul>
   *   <li>Then return recordsAdded is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#withRecordsRestored(int)}
   */
  @Test
  @DisplayName("Test withRecordsRestored(int); then return recordsAdded is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyApplyResult ImmutableBulkTaxonomyApplyResult.withRecordsRestored(int)"
  })
  void testWithRecordsRestored_thenReturnRecordsAddedIsOne() {
    // Arrange and Act
    ImmutableBulkTaxonomyApplyResult actualWithRecordsRestoredResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build()
            .withRecordsRestored(42);

    // Assert
    assertEquals(1, actualWithRecordsRestoredResult.recordsAdded());
    assertEquals(1, actualWithRecordsRestoredResult.recordsRemoved());
    assertEquals(1, actualWithRecordsRestoredResult.recordsUpdated());
    assertEquals(42, actualWithRecordsRestoredResult.recordsRestored());
    assertTrue(actualWithRecordsRestoredResult.hierarchyRebuilt());
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#withRecordsUpdated(int)}.
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#withRecordsUpdated(int)}
   */
  @Test
  @DisplayName("Test withRecordsUpdated(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyApplyResult ImmutableBulkTaxonomyApplyResult.withRecordsUpdated(int)"
  })
  void testWithRecordsUpdated() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult immutableBulkTaxonomyApplyResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(42)
            .build();

    // Act
    ImmutableBulkTaxonomyApplyResult actualWithRecordsUpdatedResult =
        immutableBulkTaxonomyApplyResult.withRecordsUpdated(42);

    // Assert
    assertSame(immutableBulkTaxonomyApplyResult, actualWithRecordsUpdatedResult);
  }

  /**
   * Test {@link ImmutableBulkTaxonomyApplyResult#withRecordsUpdated(int)}.
   *
   * <ul>
   *   <li>Then return recordsAdded is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkTaxonomyApplyResult#withRecordsUpdated(int)}
   */
  @Test
  @DisplayName("Test withRecordsUpdated(int); then return recordsAdded is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkTaxonomyApplyResult ImmutableBulkTaxonomyApplyResult.withRecordsUpdated(int)"
  })
  void testWithRecordsUpdated_thenReturnRecordsAddedIsOne() {
    // Arrange and Act
    ImmutableBulkTaxonomyApplyResult actualWithRecordsUpdatedResult =
        ImmutableBulkTaxonomyApplyResult.builder()
            .hierarchyRebuilt(true)
            .recordsAdded(1)
            .recordsRemoved(1)
            .recordsRestored(1)
            .recordsUpdated(1)
            .build()
            .withRecordsUpdated(42);

    // Assert
    assertEquals(1, actualWithRecordsUpdatedResult.recordsAdded());
    assertEquals(1, actualWithRecordsUpdatedResult.recordsRemoved());
    assertEquals(1, actualWithRecordsUpdatedResult.recordsRestored());
    assertEquals(42, actualWithRecordsUpdatedResult.recordsUpdated());
    assertTrue(actualWithRecordsUpdatedResult.hierarchyRebuilt());
  }
}
