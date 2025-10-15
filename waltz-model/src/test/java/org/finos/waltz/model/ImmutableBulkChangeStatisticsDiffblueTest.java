package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableBulkChangeStatistics.Builder;
import org.finos.waltz.model.ImmutableBulkChangeStatistics.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkChangeStatisticsDiffblueTest {
  /**
   * Test Builder {@link Builder#addedCount(int)}.
   *
   * <p>Method under test: {@link Builder#addedCount(int)}
   */
  @Test
  @DisplayName("Test Builder addedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addedCount(int)"})
  void testBuilderAddedCount() {
    // Arrange
    Builder builderResult = ImmutableBulkChangeStatistics.builder();

    // Act
    Builder actualAddedCountResult = builderResult.addedCount(3);

    // Assert
    assertSame(builderResult, actualAddedCountResult);
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
  @MethodsUnderTest({"ImmutableBulkChangeStatistics Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBulkChangeStatistics actualImmutableBulkChangeStatistics =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build();

    // Assert
    assertEquals(3, actualImmutableBulkChangeStatistics.addedCount());
    assertEquals(3, actualImmutableBulkChangeStatistics.removedCount());
    assertEquals(3, actualImmutableBulkChangeStatistics.updatedCount());
  }

  /**
   * Test Builder {@link Builder#from(BulkChangeStatistics)}.
   *
   * <p>Method under test: {@link Builder#from(BulkChangeStatistics)}
   */
  @Test
  @DisplayName("Test Builder from(BulkChangeStatistics)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkChangeStatistics)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkChangeStatistics.builder();
    ImmutableBulkChangeStatistics instance =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkChangeStatistics actualImmutableBulkChangeStatistics = builderResult.build();
    assertEquals(instance, actualImmutableBulkChangeStatistics);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#removedCount(int)}.
   *
   * <p>Method under test: {@link Builder#removedCount(int)}
   */
  @Test
  @DisplayName("Test Builder removedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.removedCount(int)"})
  void testBuilderRemovedCount() {
    // Arrange
    Builder builderResult = ImmutableBulkChangeStatistics.builder();

    // Act
    Builder actualRemovedCountResult = builderResult.removedCount(3);

    // Assert
    assertSame(builderResult, actualRemovedCountResult);
  }

  /**
   * Test Builder {@link Builder#updatedCount(int)}.
   *
   * <p>Method under test: {@link Builder#updatedCount(int)}
   */
  @Test
  @DisplayName("Test Builder updatedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.updatedCount(int)"})
  void testBuilderUpdatedCount() {
    // Arrange
    Builder builderResult = ImmutableBulkChangeStatistics.builder();

    // Act
    Builder actualUpdatedCountResult = builderResult.updatedCount(3);

    // Assert
    assertSame(builderResult, actualUpdatedCountResult);
  }

  /**
   * Test {@link ImmutableBulkChangeStatistics#copyOf(BulkChangeStatistics)}.
   *
   * <ul>
   *   <li>Then return addedCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkChangeStatistics#copyOf(BulkChangeStatistics)}
   */
  @Test
  @DisplayName("Test copyOf(BulkChangeStatistics); then return addedCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkChangeStatistics ImmutableBulkChangeStatistics.copyOf(BulkChangeStatistics)"
  })
  void testCopyOf_thenReturnAddedCountIsThree() {
    // Arrange
    ImmutableBulkChangeStatistics instance =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build();

    // Act
    ImmutableBulkChangeStatistics actualCopyOfResult =
        ImmutableBulkChangeStatistics.copyOf(instance);

    // Assert
    assertEquals(3, actualCopyOfResult.addedCount());
    assertEquals(3, actualCopyOfResult.removedCount());
    assertEquals(3, actualCopyOfResult.updatedCount());
  }

  /**
   * Test {@link ImmutableBulkChangeStatistics#equals(Object)}, and {@link
   * ImmutableBulkChangeStatistics#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkChangeStatistics#equals(Object)}
   *   <li>{@link ImmutableBulkChangeStatistics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkChangeStatistics.equals(Object)",
    "int ImmutableBulkChangeStatistics.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBulkChangeStatistics immutableBulkChangeStatistics =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build();
    ImmutableBulkChangeStatistics immutableBulkChangeStatistics2 =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build();

    // Act and Assert
    assertEquals(immutableBulkChangeStatistics, immutableBulkChangeStatistics2);
    assertEquals(
        immutableBulkChangeStatistics.hashCode(), immutableBulkChangeStatistics2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkChangeStatistics#equals(Object)}, and {@link
   * ImmutableBulkChangeStatistics#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkChangeStatistics#equals(Object)}
   *   <li>{@link ImmutableBulkChangeStatistics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkChangeStatistics.equals(Object)",
    "int ImmutableBulkChangeStatistics.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBulkChangeStatistics immutableBulkChangeStatistics =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build();

    // Act and Assert
    assertEquals(immutableBulkChangeStatistics, immutableBulkChangeStatistics);
    int expectedHashCodeResult = immutableBulkChangeStatistics.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkChangeStatistics.hashCode());
  }

  /**
   * Test {@link ImmutableBulkChangeStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkChangeStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkChangeStatistics.equals(Object)",
    "int ImmutableBulkChangeStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableBulkChangeStatistics immutableBulkChangeStatistics =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(2)
            .removedCount(3)
            .updatedCount(3)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkChangeStatistics,
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableBulkChangeStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkChangeStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkChangeStatistics.equals(Object)",
    "int ImmutableBulkChangeStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableBulkChangeStatistics immutableBulkChangeStatistics =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(1)
            .updatedCount(3)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkChangeStatistics,
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableBulkChangeStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkChangeStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkChangeStatistics.equals(Object)",
    "int ImmutableBulkChangeStatistics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableBulkChangeStatistics immutableBulkChangeStatistics =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBulkChangeStatistics,
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build());
  }

  /**
   * Test {@link ImmutableBulkChangeStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkChangeStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkChangeStatistics.equals(Object)",
    "int ImmutableBulkChangeStatistics.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkChangeStatistics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkChangeStatistics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkChangeStatistics.equals(Object)",
    "int ImmutableBulkChangeStatistics.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build(),
        "Different type to ImmutableBulkChangeStatistics");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkChangeStatistics#toString()}
   *   <li>{@link ImmutableBulkChangeStatistics#addedCount()}
   *   <li>{@link ImmutableBulkChangeStatistics#removedCount()}
   *   <li>{@link ImmutableBulkChangeStatistics#updatedCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableBulkChangeStatistics.addedCount()",
    "int ImmutableBulkChangeStatistics.removedCount()",
    "String ImmutableBulkChangeStatistics.toString()",
    "int ImmutableBulkChangeStatistics.updatedCount()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableBulkChangeStatistics immutableBulkChangeStatistics =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build();

    // Act
    String actualToStringResult = immutableBulkChangeStatistics.toString();
    int actualAddedCountResult = immutableBulkChangeStatistics.addedCount();
    int actualRemovedCountResult = immutableBulkChangeStatistics.removedCount();

    // Assert
    assertEquals(
        "BulkChangeStatistics{addedCount=3, updatedCount=3, removedCount=3}", actualToStringResult);
    assertEquals(3, actualAddedCountResult);
    assertEquals(3, actualRemovedCountResult);
    assertEquals(3, immutableBulkChangeStatistics.updatedCount());
  }

  /**
   * Test Json {@link Json#addedCount()}.
   *
   * <p>Method under test: {@link Json#addedCount()}
   */
  @Test
  @DisplayName("Test Json addedCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.addedCount()"})
  void testJsonAddedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().addedCount());
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
    assertEquals(0, actualJson.addedCount);
    assertEquals(0, actualJson.removedCount);
    assertEquals(0, actualJson.updatedCount);
    assertFalse(actualJson.addedCountIsSet);
    assertFalse(actualJson.removedCountIsSet);
    assertFalse(actualJson.updatedCountIsSet);
  }

  /**
   * Test Json {@link Json#removedCount()}.
   *
   * <p>Method under test: {@link Json#removedCount()}
   */
  @Test
  @DisplayName("Test Json removedCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.removedCount()"})
  void testJsonRemovedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().removedCount());
  }

  /**
   * Test Json {@link Json#setAddedCount(int)}.
   *
   * <p>Method under test: {@link Json#setAddedCount(int)}
   */
  @Test
  @DisplayName("Test Json setAddedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setAddedCount(int)"})
  void testJsonSetAddedCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setAddedCount(3);

    // Assert
    assertEquals(3, json.addedCount);
    assertTrue(json.addedCountIsSet);
  }

  /**
   * Test Json {@link Json#setRemovedCount(int)}.
   *
   * <p>Method under test: {@link Json#setRemovedCount(int)}
   */
  @Test
  @DisplayName("Test Json setRemovedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRemovedCount(int)"})
  void testJsonSetRemovedCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRemovedCount(3);

    // Assert
    assertEquals(3, json.removedCount);
    assertTrue(json.removedCountIsSet);
  }

  /**
   * Test Json {@link Json#setUpdatedCount(int)}.
   *
   * <p>Method under test: {@link Json#setUpdatedCount(int)}
   */
  @Test
  @DisplayName("Test Json setUpdatedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setUpdatedCount(int)"})
  void testJsonSetUpdatedCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setUpdatedCount(3);

    // Assert
    assertEquals(3, json.updatedCount);
    assertTrue(json.updatedCountIsSet);
  }

  /**
   * Test Json {@link Json#updatedCount()}.
   *
   * <p>Method under test: {@link Json#updatedCount()}
   */
  @Test
  @DisplayName("Test Json updatedCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.updatedCount()"})
  void testJsonUpdatedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().updatedCount());
  }

  /**
   * Test {@link ImmutableBulkChangeStatistics#withAddedCount(int)}.
   *
   * <p>Method under test: {@link ImmutableBulkChangeStatistics#withAddedCount(int)}
   */
  @Test
  @DisplayName("Test withAddedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkChangeStatistics ImmutableBulkChangeStatistics.withAddedCount(int)"
  })
  void testWithAddedCount() {
    // Arrange
    ImmutableBulkChangeStatistics immutableBulkChangeStatistics =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(42)
            .removedCount(3)
            .updatedCount(3)
            .build();

    // Act
    ImmutableBulkChangeStatistics actualWithAddedCountResult =
        immutableBulkChangeStatistics.withAddedCount(42);

    // Assert
    assertSame(immutableBulkChangeStatistics, actualWithAddedCountResult);
  }

  /**
   * Test {@link ImmutableBulkChangeStatistics#withAddedCount(int)}.
   *
   * <ul>
   *   <li>Then return removedCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkChangeStatistics#withAddedCount(int)}
   */
  @Test
  @DisplayName("Test withAddedCount(int); then return removedCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkChangeStatistics ImmutableBulkChangeStatistics.withAddedCount(int)"
  })
  void testWithAddedCount_thenReturnRemovedCountIsThree() {
    // Arrange and Act
    ImmutableBulkChangeStatistics actualWithAddedCountResult =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build()
            .withAddedCount(42);

    // Assert
    assertEquals(3, actualWithAddedCountResult.removedCount());
    assertEquals(3, actualWithAddedCountResult.updatedCount());
    assertEquals(42, actualWithAddedCountResult.addedCount());
  }

  /**
   * Test {@link ImmutableBulkChangeStatistics#withRemovedCount(int)}.
   *
   * <p>Method under test: {@link ImmutableBulkChangeStatistics#withRemovedCount(int)}
   */
  @Test
  @DisplayName("Test withRemovedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkChangeStatistics ImmutableBulkChangeStatistics.withRemovedCount(int)"
  })
  void testWithRemovedCount() {
    // Arrange
    ImmutableBulkChangeStatistics immutableBulkChangeStatistics =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(42)
            .updatedCount(3)
            .build();

    // Act
    ImmutableBulkChangeStatistics actualWithRemovedCountResult =
        immutableBulkChangeStatistics.withRemovedCount(42);

    // Assert
    assertSame(immutableBulkChangeStatistics, actualWithRemovedCountResult);
  }

  /**
   * Test {@link ImmutableBulkChangeStatistics#withRemovedCount(int)}.
   *
   * <ul>
   *   <li>Then return addedCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkChangeStatistics#withRemovedCount(int)}
   */
  @Test
  @DisplayName("Test withRemovedCount(int); then return addedCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkChangeStatistics ImmutableBulkChangeStatistics.withRemovedCount(int)"
  })
  void testWithRemovedCount_thenReturnAddedCountIsThree() {
    // Arrange and Act
    ImmutableBulkChangeStatistics actualWithRemovedCountResult =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build()
            .withRemovedCount(42);

    // Assert
    assertEquals(3, actualWithRemovedCountResult.addedCount());
    assertEquals(3, actualWithRemovedCountResult.updatedCount());
    assertEquals(42, actualWithRemovedCountResult.removedCount());
  }

  /**
   * Test {@link ImmutableBulkChangeStatistics#withUpdatedCount(int)}.
   *
   * <p>Method under test: {@link ImmutableBulkChangeStatistics#withUpdatedCount(int)}
   */
  @Test
  @DisplayName("Test withUpdatedCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkChangeStatistics ImmutableBulkChangeStatistics.withUpdatedCount(int)"
  })
  void testWithUpdatedCount() {
    // Arrange
    ImmutableBulkChangeStatistics immutableBulkChangeStatistics =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(42)
            .build();

    // Act
    ImmutableBulkChangeStatistics actualWithUpdatedCountResult =
        immutableBulkChangeStatistics.withUpdatedCount(42);

    // Assert
    assertSame(immutableBulkChangeStatistics, actualWithUpdatedCountResult);
  }

  /**
   * Test {@link ImmutableBulkChangeStatistics#withUpdatedCount(int)}.
   *
   * <ul>
   *   <li>Then return addedCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkChangeStatistics#withUpdatedCount(int)}
   */
  @Test
  @DisplayName("Test withUpdatedCount(int); then return addedCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkChangeStatistics ImmutableBulkChangeStatistics.withUpdatedCount(int)"
  })
  void testWithUpdatedCount_thenReturnAddedCountIsThree() {
    // Arrange and Act
    ImmutableBulkChangeStatistics actualWithUpdatedCountResult =
        ImmutableBulkChangeStatistics.builder()
            .addedCount(3)
            .removedCount(3)
            .updatedCount(3)
            .build()
            .withUpdatedCount(42);

    // Assert
    assertEquals(3, actualWithUpdatedCountResult.addedCount());
    assertEquals(3, actualWithUpdatedCountResult.removedCount());
    assertEquals(42, actualWithUpdatedCountResult.updatedCount());
  }
}
