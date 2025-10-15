package org.finos.waltz.model.datatype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.datatype.ImmutableDataTypeMigrationResult.Builder;
import org.finos.waltz.model.datatype.ImmutableDataTypeMigrationResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeMigrationResultDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeMigrationResult Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableDataTypeMigrationResult actualImmutableDataTypeMigrationResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build();

    // Assert
    assertEquals(3L, actualImmutableDataTypeMigrationResult.classificationRuleCount());
    assertEquals(3L, actualImmutableDataTypeMigrationResult.logicalFlowDataTypeCount());
    assertEquals(3L, actualImmutableDataTypeMigrationResult.physicalSpecDataTypeCount());
    assertEquals(3L, actualImmutableDataTypeMigrationResult.usageCount());
    assertTrue(actualImmutableDataTypeMigrationResult.dataTypeRemoved());
  }

  /**
   * Test Builder {@link Builder#classificationRuleCount(long)}.
   *
   * <p>Method under test: {@link Builder#classificationRuleCount(long)}
   */
  @Test
  @DisplayName("Test Builder classificationRuleCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.classificationRuleCount(long)"})
  void testBuilderClassificationRuleCount() {
    // Arrange
    Builder builderResult = ImmutableDataTypeMigrationResult.builder();

    // Act
    Builder actualClassificationRuleCountResult = builderResult.classificationRuleCount(3L);

    // Assert
    assertSame(builderResult, actualClassificationRuleCountResult);
  }

  /**
   * Test Builder {@link Builder#dataTypeRemoved(boolean)}.
   *
   * <p>Method under test: {@link Builder#dataTypeRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Builder dataTypeRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dataTypeRemoved(boolean)"})
  void testBuilderDataTypeRemoved() {
    // Arrange
    Builder builderResult = ImmutableDataTypeMigrationResult.builder();

    // Act
    Builder actualDataTypeRemovedResult = builderResult.dataTypeRemoved(true);

    // Assert
    assertSame(builderResult, actualDataTypeRemovedResult);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeMigrationResult)}.
   *
   * <p>Method under test: {@link Builder#from(DataTypeMigrationResult)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeMigrationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataTypeMigrationResult)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableDataTypeMigrationResult.builder();
    ImmutableDataTypeMigrationResult instance =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDataTypeMigrationResult actualImmutableDataTypeMigrationResult = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeMigrationResult);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeMigrationResult)}.
   *
   * <p>Method under test: {@link Builder#from(DataTypeMigrationResult)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeMigrationResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataTypeMigrationResult)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableDataTypeMigrationResult.builder();
    ImmutableDataTypeMigrationResult instance =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(false)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDataTypeMigrationResult actualImmutableDataTypeMigrationResult = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeMigrationResult);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#logicalFlowDataTypeCount(long)}.
   *
   * <p>Method under test: {@link Builder#logicalFlowDataTypeCount(long)}
   */
  @Test
  @DisplayName("Test Builder logicalFlowDataTypeCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.logicalFlowDataTypeCount(long)"})
  void testBuilderLogicalFlowDataTypeCount() {
    // Arrange
    Builder builderResult = ImmutableDataTypeMigrationResult.builder();

    // Act
    Builder actualLogicalFlowDataTypeCountResult = builderResult.logicalFlowDataTypeCount(3L);

    // Assert
    assertSame(builderResult, actualLogicalFlowDataTypeCountResult);
  }

  /**
   * Test Builder {@link Builder#physicalSpecDataTypeCount(long)}.
   *
   * <p>Method under test: {@link Builder#physicalSpecDataTypeCount(long)}
   */
  @Test
  @DisplayName("Test Builder physicalSpecDataTypeCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.physicalSpecDataTypeCount(long)"})
  void testBuilderPhysicalSpecDataTypeCount() {
    // Arrange
    Builder builderResult = ImmutableDataTypeMigrationResult.builder();

    // Act
    Builder actualPhysicalSpecDataTypeCountResult = builderResult.physicalSpecDataTypeCount(3L);

    // Assert
    assertSame(builderResult, actualPhysicalSpecDataTypeCountResult);
  }

  /**
   * Test Builder {@link Builder#usageCount(long)}.
   *
   * <p>Method under test: {@link Builder#usageCount(long)}
   */
  @Test
  @DisplayName("Test Builder usageCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.usageCount(long)"})
  void testBuilderUsageCount() {
    // Arrange
    Builder builderResult = ImmutableDataTypeMigrationResult.builder();

    // Act
    Builder actualUsageCountResult = builderResult.usageCount(3L);

    // Assert
    assertSame(builderResult, actualUsageCountResult);
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#copyOf(DataTypeMigrationResult)}.
   *
   * <ul>
   *   <li>Then return classificationRuleCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeMigrationResult#copyOf(DataTypeMigrationResult)}
   */
  @Test
  @DisplayName("Test copyOf(DataTypeMigrationResult); then return classificationRuleCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeMigrationResult ImmutableDataTypeMigrationResult.copyOf(DataTypeMigrationResult)"
  })
  void testCopyOf_thenReturnClassificationRuleCountIsThree() {
    // Arrange
    ImmutableDataTypeMigrationResult instance =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build();

    // Act
    ImmutableDataTypeMigrationResult actualCopyOfResult =
        ImmutableDataTypeMigrationResult.copyOf(instance);

    // Assert
    assertEquals(3L, actualCopyOfResult.classificationRuleCount());
    assertEquals(3L, actualCopyOfResult.logicalFlowDataTypeCount());
    assertEquals(3L, actualCopyOfResult.physicalSpecDataTypeCount());
    assertEquals(3L, actualCopyOfResult.usageCount());
    assertTrue(actualCopyOfResult.dataTypeRemoved());
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#equals(Object)}, and {@link
   * ImmutableDataTypeMigrationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeMigrationResult#equals(Object)}
   *   <li>{@link ImmutableDataTypeMigrationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeMigrationResult.equals(Object)",
    "int ImmutableDataTypeMigrationResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableDataTypeMigrationResult immutableDataTypeMigrationResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build();
    ImmutableDataTypeMigrationResult immutableDataTypeMigrationResult2 =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build();

    // Act and Assert
    assertEquals(immutableDataTypeMigrationResult, immutableDataTypeMigrationResult2);
    assertEquals(
        immutableDataTypeMigrationResult.hashCode(), immutableDataTypeMigrationResult2.hashCode());
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#equals(Object)}, and {@link
   * ImmutableDataTypeMigrationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeMigrationResult#equals(Object)}
   *   <li>{@link ImmutableDataTypeMigrationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeMigrationResult.equals(Object)",
    "int ImmutableDataTypeMigrationResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableDataTypeMigrationResult immutableDataTypeMigrationResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build();

    // Act and Assert
    assertEquals(immutableDataTypeMigrationResult, immutableDataTypeMigrationResult);
    int expectedHashCodeResult = immutableDataTypeMigrationResult.hashCode();
    assertEquals(expectedHashCodeResult, immutableDataTypeMigrationResult.hashCode());
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeMigrationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeMigrationResult.equals(Object)",
    "int ImmutableDataTypeMigrationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableDataTypeMigrationResult immutableDataTypeMigrationResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(1L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataTypeMigrationResult,
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeMigrationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeMigrationResult.equals(Object)",
    "int ImmutableDataTypeMigrationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableDataTypeMigrationResult immutableDataTypeMigrationResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(false)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataTypeMigrationResult,
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeMigrationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeMigrationResult.equals(Object)",
    "int ImmutableDataTypeMigrationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableDataTypeMigrationResult immutableDataTypeMigrationResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(1L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataTypeMigrationResult,
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeMigrationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeMigrationResult.equals(Object)",
    "int ImmutableDataTypeMigrationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableDataTypeMigrationResult immutableDataTypeMigrationResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(1L)
            .usageCount(3L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataTypeMigrationResult,
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeMigrationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeMigrationResult.equals(Object)",
    "int ImmutableDataTypeMigrationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableDataTypeMigrationResult immutableDataTypeMigrationResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataTypeMigrationResult,
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeMigrationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeMigrationResult.equals(Object)",
    "int ImmutableDataTypeMigrationResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeMigrationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeMigrationResult.equals(Object)",
    "int ImmutableDataTypeMigrationResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build(),
        "Different type to ImmutableDataTypeMigrationResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeMigrationResult#toString()}
   *   <li>{@link ImmutableDataTypeMigrationResult#classificationRuleCount()}
   *   <li>{@link ImmutableDataTypeMigrationResult#dataTypeRemoved()}
   *   <li>{@link ImmutableDataTypeMigrationResult#logicalFlowDataTypeCount()}
   *   <li>{@link ImmutableDataTypeMigrationResult#physicalSpecDataTypeCount()}
   *   <li>{@link ImmutableDataTypeMigrationResult#usageCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableDataTypeMigrationResult.classificationRuleCount()",
    "boolean ImmutableDataTypeMigrationResult.dataTypeRemoved()",
    "long ImmutableDataTypeMigrationResult.logicalFlowDataTypeCount()",
    "long ImmutableDataTypeMigrationResult.physicalSpecDataTypeCount()",
    "String ImmutableDataTypeMigrationResult.toString()",
    "long ImmutableDataTypeMigrationResult.usageCount()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableDataTypeMigrationResult immutableDataTypeMigrationResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build();

    // Act
    String actualToStringResult = immutableDataTypeMigrationResult.toString();
    long actualClassificationRuleCountResult =
        immutableDataTypeMigrationResult.classificationRuleCount();
    boolean actualDataTypeRemovedResult = immutableDataTypeMigrationResult.dataTypeRemoved();
    long actualLogicalFlowDataTypeCountResult =
        immutableDataTypeMigrationResult.logicalFlowDataTypeCount();
    long actualPhysicalSpecDataTypeCountResult =
        immutableDataTypeMigrationResult.physicalSpecDataTypeCount();

    // Assert
    assertEquals(
        "DataTypeMigrationResult{usageCount=3, classificationRuleCount=3, logicalFlowDataTypeCount=3,"
            + " physicalSpecDataTypeCount=3, dataTypeRemoved=true}",
        actualToStringResult);
    assertEquals(3L, actualClassificationRuleCountResult);
    assertEquals(3L, actualLogicalFlowDataTypeCountResult);
    assertEquals(3L, actualPhysicalSpecDataTypeCountResult);
    assertEquals(3L, immutableDataTypeMigrationResult.usageCount());
    assertTrue(actualDataTypeRemovedResult);
  }

  /**
   * Test Json {@link Json#classificationRuleCount()}.
   *
   * <p>Method under test: {@link Json#classificationRuleCount()}
   */
  @Test
  @DisplayName("Test Json classificationRuleCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.classificationRuleCount()"})
  void testJsonClassificationRuleCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().classificationRuleCount());
  }

  /**
   * Test Json {@link Json#dataTypeRemoved()}.
   *
   * <p>Method under test: {@link Json#dataTypeRemoved()}
   */
  @Test
  @DisplayName("Test Json dataTypeRemoved()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.dataTypeRemoved()"})
  void testJsonDataTypeRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dataTypeRemoved());
  }

  /**
   * Test Json {@link Json#logicalFlowDataTypeCount()}.
   *
   * <p>Method under test: {@link Json#logicalFlowDataTypeCount()}
   */
  @Test
  @DisplayName("Test Json logicalFlowDataTypeCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.logicalFlowDataTypeCount()"})
  void testJsonLogicalFlowDataTypeCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().logicalFlowDataTypeCount());
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
    assertEquals(0L, actualJson.classificationRuleCount);
    assertEquals(0L, actualJson.logicalFlowDataTypeCount);
    assertEquals(0L, actualJson.physicalSpecDataTypeCount);
    assertEquals(0L, actualJson.usageCount);
    assertFalse(actualJson.classificationRuleCountIsSet);
    assertFalse(actualJson.dataTypeRemoved);
    assertFalse(actualJson.dataTypeRemovedIsSet);
    assertFalse(actualJson.logicalFlowDataTypeCountIsSet);
    assertFalse(actualJson.physicalSpecDataTypeCountIsSet);
    assertFalse(actualJson.usageCountIsSet);
  }

  /**
   * Test Json {@link Json#physicalSpecDataTypeCount()}.
   *
   * <p>Method under test: {@link Json#physicalSpecDataTypeCount()}
   */
  @Test
  @DisplayName("Test Json physicalSpecDataTypeCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.physicalSpecDataTypeCount()"})
  void testJsonPhysicalSpecDataTypeCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().physicalSpecDataTypeCount());
  }

  /**
   * Test Json {@link Json#setClassificationRuleCount(long)}.
   *
   * <p>Method under test: {@link Json#setClassificationRuleCount(long)}
   */
  @Test
  @DisplayName("Test Json setClassificationRuleCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setClassificationRuleCount(long)"})
  void testJsonSetClassificationRuleCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setClassificationRuleCount(3L);

    // Assert
    assertEquals(3L, json.classificationRuleCount);
    assertTrue(json.classificationRuleCountIsSet);
  }

  /**
   * Test Json {@link Json#setDataTypeRemoved(boolean)}.
   *
   * <p>Method under test: {@link Json#setDataTypeRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Json setDataTypeRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setDataTypeRemoved(boolean)"})
  void testJsonSetDataTypeRemoved() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDataTypeRemoved(true);

    // Assert
    assertTrue(json.dataTypeRemoved);
    assertTrue(json.dataTypeRemovedIsSet);
  }

  /**
   * Test Json {@link Json#setLogicalFlowDataTypeCount(long)}.
   *
   * <p>Method under test: {@link Json#setLogicalFlowDataTypeCount(long)}
   */
  @Test
  @DisplayName("Test Json setLogicalFlowDataTypeCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setLogicalFlowDataTypeCount(long)"})
  void testJsonSetLogicalFlowDataTypeCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setLogicalFlowDataTypeCount(3L);

    // Assert
    assertEquals(3L, json.logicalFlowDataTypeCount);
    assertTrue(json.logicalFlowDataTypeCountIsSet);
  }

  /**
   * Test Json {@link Json#setPhysicalSpecDataTypeCount(long)}.
   *
   * <p>Method under test: {@link Json#setPhysicalSpecDataTypeCount(long)}
   */
  @Test
  @DisplayName("Test Json setPhysicalSpecDataTypeCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPhysicalSpecDataTypeCount(long)"})
  void testJsonSetPhysicalSpecDataTypeCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPhysicalSpecDataTypeCount(3L);

    // Assert
    assertEquals(3L, json.physicalSpecDataTypeCount);
    assertTrue(json.physicalSpecDataTypeCountIsSet);
  }

  /**
   * Test Json {@link Json#setUsageCount(long)}.
   *
   * <p>Method under test: {@link Json#setUsageCount(long)}
   */
  @Test
  @DisplayName("Test Json setUsageCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setUsageCount(long)"})
  void testJsonSetUsageCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setUsageCount(3L);

    // Assert
    assertEquals(3L, json.usageCount);
    assertTrue(json.usageCountIsSet);
  }

  /**
   * Test Json {@link Json#usageCount()}.
   *
   * <p>Method under test: {@link Json#usageCount()}
   */
  @Test
  @DisplayName("Test Json usageCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.usageCount()"})
  void testJsonUsageCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().usageCount());
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#withClassificationRuleCount(long)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeMigrationResult#withClassificationRuleCount(long)}
   */
  @Test
  @DisplayName("Test withClassificationRuleCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeMigrationResult ImmutableDataTypeMigrationResult.withClassificationRuleCount(long)"
  })
  void testWithClassificationRuleCount() {
    // Arrange
    ImmutableDataTypeMigrationResult immutableDataTypeMigrationResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(42L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build();

    // Act
    ImmutableDataTypeMigrationResult actualWithClassificationRuleCountResult =
        immutableDataTypeMigrationResult.withClassificationRuleCount(42L);

    // Assert
    assertSame(immutableDataTypeMigrationResult, actualWithClassificationRuleCountResult);
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#withClassificationRuleCount(long)}.
   *
   * <ul>
   *   <li>Then return logicalFlowDataTypeCount is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeMigrationResult#withClassificationRuleCount(long)}
   */
  @Test
  @DisplayName(
      "Test withClassificationRuleCount(long); then return logicalFlowDataTypeCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeMigrationResult ImmutableDataTypeMigrationResult.withClassificationRuleCount(long)"
  })
  void testWithClassificationRuleCount_thenReturnLogicalFlowDataTypeCountIsThree() {
    // Arrange and Act
    ImmutableDataTypeMigrationResult actualWithClassificationRuleCountResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build()
            .withClassificationRuleCount(42L);

    // Assert
    assertEquals(3L, actualWithClassificationRuleCountResult.logicalFlowDataTypeCount());
    assertEquals(3L, actualWithClassificationRuleCountResult.physicalSpecDataTypeCount());
    assertEquals(3L, actualWithClassificationRuleCountResult.usageCount());
    assertEquals(42L, actualWithClassificationRuleCountResult.classificationRuleCount());
    assertTrue(actualWithClassificationRuleCountResult.dataTypeRemoved());
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#withDataTypeRemoved(boolean)}.
   *
   * <p>Method under test: {@link ImmutableDataTypeMigrationResult#withDataTypeRemoved(boolean)}
   */
  @Test
  @DisplayName("Test withDataTypeRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeMigrationResult ImmutableDataTypeMigrationResult.withDataTypeRemoved(boolean)"
  })
  void testWithDataTypeRemoved() {
    // Arrange
    ImmutableDataTypeMigrationResult immutableDataTypeMigrationResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build();

    // Act
    ImmutableDataTypeMigrationResult actualWithDataTypeRemovedResult =
        immutableDataTypeMigrationResult.withDataTypeRemoved(true);

    // Assert
    assertSame(immutableDataTypeMigrationResult, actualWithDataTypeRemovedResult);
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#withDataTypeRemoved(boolean)}.
   *
   * <ul>
   *   <li>Then return classificationRuleCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeMigrationResult#withDataTypeRemoved(boolean)}
   */
  @Test
  @DisplayName("Test withDataTypeRemoved(boolean); then return classificationRuleCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeMigrationResult ImmutableDataTypeMigrationResult.withDataTypeRemoved(boolean)"
  })
  void testWithDataTypeRemoved_thenReturnClassificationRuleCountIsThree() {
    // Arrange and Act
    ImmutableDataTypeMigrationResult actualWithDataTypeRemovedResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(false)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build()
            .withDataTypeRemoved(true);

    // Assert
    assertEquals(3L, actualWithDataTypeRemovedResult.classificationRuleCount());
    assertEquals(3L, actualWithDataTypeRemovedResult.logicalFlowDataTypeCount());
    assertEquals(3L, actualWithDataTypeRemovedResult.physicalSpecDataTypeCount());
    assertEquals(3L, actualWithDataTypeRemovedResult.usageCount());
    assertTrue(actualWithDataTypeRemovedResult.dataTypeRemoved());
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#withLogicalFlowDataTypeCount(long)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeMigrationResult#withLogicalFlowDataTypeCount(long)}
   */
  @Test
  @DisplayName("Test withLogicalFlowDataTypeCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeMigrationResult ImmutableDataTypeMigrationResult.withLogicalFlowDataTypeCount(long)"
  })
  void testWithLogicalFlowDataTypeCount() {
    // Arrange
    ImmutableDataTypeMigrationResult immutableDataTypeMigrationResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(42L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build();

    // Act
    ImmutableDataTypeMigrationResult actualWithLogicalFlowDataTypeCountResult =
        immutableDataTypeMigrationResult.withLogicalFlowDataTypeCount(42L);

    // Assert
    assertSame(immutableDataTypeMigrationResult, actualWithLogicalFlowDataTypeCountResult);
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#withLogicalFlowDataTypeCount(long)}.
   *
   * <ul>
   *   <li>Then return classificationRuleCount is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeMigrationResult#withLogicalFlowDataTypeCount(long)}
   */
  @Test
  @DisplayName(
      "Test withLogicalFlowDataTypeCount(long); then return classificationRuleCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeMigrationResult ImmutableDataTypeMigrationResult.withLogicalFlowDataTypeCount(long)"
  })
  void testWithLogicalFlowDataTypeCount_thenReturnClassificationRuleCountIsThree() {
    // Arrange and Act
    ImmutableDataTypeMigrationResult actualWithLogicalFlowDataTypeCountResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build()
            .withLogicalFlowDataTypeCount(42L);

    // Assert
    assertEquals(3L, actualWithLogicalFlowDataTypeCountResult.classificationRuleCount());
    assertEquals(3L, actualWithLogicalFlowDataTypeCountResult.physicalSpecDataTypeCount());
    assertEquals(3L, actualWithLogicalFlowDataTypeCountResult.usageCount());
    assertEquals(42L, actualWithLogicalFlowDataTypeCountResult.logicalFlowDataTypeCount());
    assertTrue(actualWithLogicalFlowDataTypeCountResult.dataTypeRemoved());
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#withPhysicalSpecDataTypeCount(long)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeMigrationResult#withPhysicalSpecDataTypeCount(long)}
   */
  @Test
  @DisplayName("Test withPhysicalSpecDataTypeCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeMigrationResult ImmutableDataTypeMigrationResult.withPhysicalSpecDataTypeCount(long)"
  })
  void testWithPhysicalSpecDataTypeCount() {
    // Arrange
    ImmutableDataTypeMigrationResult immutableDataTypeMigrationResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(42L)
            .usageCount(3L)
            .build();

    // Act
    ImmutableDataTypeMigrationResult actualWithPhysicalSpecDataTypeCountResult =
        immutableDataTypeMigrationResult.withPhysicalSpecDataTypeCount(42L);

    // Assert
    assertSame(immutableDataTypeMigrationResult, actualWithPhysicalSpecDataTypeCountResult);
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#withPhysicalSpecDataTypeCount(long)}.
   *
   * <ul>
   *   <li>Then return classificationRuleCount is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeMigrationResult#withPhysicalSpecDataTypeCount(long)}
   */
  @Test
  @DisplayName(
      "Test withPhysicalSpecDataTypeCount(long); then return classificationRuleCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeMigrationResult ImmutableDataTypeMigrationResult.withPhysicalSpecDataTypeCount(long)"
  })
  void testWithPhysicalSpecDataTypeCount_thenReturnClassificationRuleCountIsThree() {
    // Arrange and Act
    ImmutableDataTypeMigrationResult actualWithPhysicalSpecDataTypeCountResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build()
            .withPhysicalSpecDataTypeCount(42L);

    // Assert
    assertEquals(3L, actualWithPhysicalSpecDataTypeCountResult.classificationRuleCount());
    assertEquals(3L, actualWithPhysicalSpecDataTypeCountResult.logicalFlowDataTypeCount());
    assertEquals(3L, actualWithPhysicalSpecDataTypeCountResult.usageCount());
    assertEquals(42L, actualWithPhysicalSpecDataTypeCountResult.physicalSpecDataTypeCount());
    assertTrue(actualWithPhysicalSpecDataTypeCountResult.dataTypeRemoved());
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#withUsageCount(long)}.
   *
   * <p>Method under test: {@link ImmutableDataTypeMigrationResult#withUsageCount(long)}
   */
  @Test
  @DisplayName("Test withUsageCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeMigrationResult ImmutableDataTypeMigrationResult.withUsageCount(long)"
  })
  void testWithUsageCount() {
    // Arrange
    ImmutableDataTypeMigrationResult immutableDataTypeMigrationResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(42L)
            .build();

    // Act
    ImmutableDataTypeMigrationResult actualWithUsageCountResult =
        immutableDataTypeMigrationResult.withUsageCount(42L);

    // Assert
    assertSame(immutableDataTypeMigrationResult, actualWithUsageCountResult);
  }

  /**
   * Test {@link ImmutableDataTypeMigrationResult#withUsageCount(long)}.
   *
   * <ul>
   *   <li>Then return classificationRuleCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeMigrationResult#withUsageCount(long)}
   */
  @Test
  @DisplayName("Test withUsageCount(long); then return classificationRuleCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeMigrationResult ImmutableDataTypeMigrationResult.withUsageCount(long)"
  })
  void testWithUsageCount_thenReturnClassificationRuleCountIsThree() {
    // Arrange and Act
    ImmutableDataTypeMigrationResult actualWithUsageCountResult =
        ImmutableDataTypeMigrationResult.builder()
            .classificationRuleCount(3L)
            .dataTypeRemoved(true)
            .logicalFlowDataTypeCount(3L)
            .physicalSpecDataTypeCount(3L)
            .usageCount(3L)
            .build()
            .withUsageCount(42L);

    // Assert
    assertEquals(3L, actualWithUsageCountResult.classificationRuleCount());
    assertEquals(3L, actualWithUsageCountResult.logicalFlowDataTypeCount());
    assertEquals(3L, actualWithUsageCountResult.physicalSpecDataTypeCount());
    assertEquals(42L, actualWithUsageCountResult.usageCount());
    assertTrue(actualWithUsageCountResult.dataTypeRemoved());
  }
}
