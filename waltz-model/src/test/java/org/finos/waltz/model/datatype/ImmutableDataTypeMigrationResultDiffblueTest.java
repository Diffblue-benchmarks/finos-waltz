package org.finos.waltz.model.datatype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeMigrationResultDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableDataTypeMigrationResult.Builder#classificationRuleCount(long)}
   */
  @Test
  void testBuilderClassificationRuleCount() {
    // Arrange
    ImmutableDataTypeMigrationResult.Builder builderResult = ImmutableDataTypeMigrationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.classificationRuleCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeMigrationResult.Builder#dataTypeRemoved(boolean)}
   */
  @Test
  void testBuilderDataTypeRemoved() {
    // Arrange
    ImmutableDataTypeMigrationResult.Builder builderResult = ImmutableDataTypeMigrationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeRemoved(true));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeMigrationResult.Builder#from(DataTypeMigrationResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDataTypeMigrationResult.Builder builderResult = ImmutableDataTypeMigrationResult.builder();
    DataTypeMigrationResult instance = mock(DataTypeMigrationResult.class);
    when(instance.dataTypeRemoved()).thenReturn(true);
    when(instance.classificationRuleCount()).thenReturn(3L);
    when(instance.logicalFlowDataTypeCount()).thenReturn(3L);
    when(instance.physicalSpecDataTypeCount()).thenReturn(3L);
    when(instance.usageCount()).thenReturn(3L);

    // Act
    ImmutableDataTypeMigrationResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).classificationRuleCount();
    verify(instance).dataTypeRemoved();
    verify(instance).logicalFlowDataTypeCount();
    verify(instance).physicalSpecDataTypeCount();
    verify(instance).usageCount();
    ImmutableDataTypeMigrationResult buildResult = builderResult.build();
    assertEquals(3L, buildResult.classificationRuleCount());
    assertEquals(3L, buildResult.logicalFlowDataTypeCount());
    assertEquals(3L, buildResult.physicalSpecDataTypeCount());
    assertEquals(3L, buildResult.usageCount());
    assertTrue(buildResult.dataTypeRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeMigrationResult.Builder#logicalFlowDataTypeCount(long)}
   */
  @Test
  void testBuilderLogicalFlowDataTypeCount() {
    // Arrange
    ImmutableDataTypeMigrationResult.Builder builderResult = ImmutableDataTypeMigrationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlowDataTypeCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeMigrationResult.Builder#physicalSpecDataTypeCount(long)}
   */
  @Test
  void testBuilderPhysicalSpecDataTypeCount() {
    // Arrange
    ImmutableDataTypeMigrationResult.Builder builderResult = ImmutableDataTypeMigrationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.physicalSpecDataTypeCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeMigrationResult.Builder#usageCount(long)}
   */
  @Test
  void testBuilderUsageCount() {
    // Arrange
    ImmutableDataTypeMigrationResult.Builder builderResult = ImmutableDataTypeMigrationResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.usageCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeMigrationResult#copyOf(DataTypeMigrationResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DataTypeMigrationResult instance = mock(DataTypeMigrationResult.class);
    when(instance.dataTypeRemoved()).thenReturn(true);
    when(instance.classificationRuleCount()).thenReturn(3L);
    when(instance.logicalFlowDataTypeCount()).thenReturn(3L);
    when(instance.physicalSpecDataTypeCount()).thenReturn(3L);
    when(instance.usageCount()).thenReturn(3L);

    // Act
    ImmutableDataTypeMigrationResult actualCopyOfResult = ImmutableDataTypeMigrationResult.copyOf(instance);

    // Assert
    verify(instance).classificationRuleCount();
    verify(instance).dataTypeRemoved();
    verify(instance).logicalFlowDataTypeCount();
    verify(instance).physicalSpecDataTypeCount();
    verify(instance).usageCount();
    assertEquals(3L, actualCopyOfResult.classificationRuleCount());
    assertEquals(3L, actualCopyOfResult.logicalFlowDataTypeCount());
    assertEquals(3L, actualCopyOfResult.physicalSpecDataTypeCount());
    assertEquals(3L, actualCopyOfResult.usageCount());
    assertTrue(actualCopyOfResult.dataTypeRemoved());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeMigrationResult.Json#classificationRuleCount()}
   */
  @Test
  void testJsonClassificationRuleCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeMigrationResult.Json()).classificationRuleCount());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeMigrationResult.Json#dataTypeRemoved()}
   */
  @Test
  void testJsonDataTypeRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeMigrationResult.Json()).dataTypeRemoved());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeMigrationResult.Json#logicalFlowDataTypeCount()}
   */
  @Test
  void testJsonLogicalFlowDataTypeCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeMigrationResult.Json()).logicalFlowDataTypeCount());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableDataTypeMigrationResult.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableDataTypeMigrationResult.Json actualJson = new ImmutableDataTypeMigrationResult.Json();

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
   * Method under test:
   * {@link ImmutableDataTypeMigrationResult.Json#physicalSpecDataTypeCount()}
   */
  @Test
  void testJsonPhysicalSpecDataTypeCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeMigrationResult.Json()).physicalSpecDataTypeCount());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeMigrationResult.Json#setClassificationRuleCount(long)}
   */
  @Test
  void testJsonSetClassificationRuleCount() {
    // Arrange
    ImmutableDataTypeMigrationResult.Json json = new ImmutableDataTypeMigrationResult.Json();

    // Act
    json.setClassificationRuleCount(3L);

    // Assert
    assertEquals(3L, json.classificationRuleCount);
    assertTrue(json.classificationRuleCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeMigrationResult.Json#setDataTypeRemoved(boolean)}
   */
  @Test
  void testJsonSetDataTypeRemoved() {
    // Arrange
    ImmutableDataTypeMigrationResult.Json json = new ImmutableDataTypeMigrationResult.Json();

    // Act
    json.setDataTypeRemoved(true);

    // Assert
    assertTrue(json.dataTypeRemoved);
    assertTrue(json.dataTypeRemovedIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeMigrationResult.Json#setLogicalFlowDataTypeCount(long)}
   */
  @Test
  void testJsonSetLogicalFlowDataTypeCount() {
    // Arrange
    ImmutableDataTypeMigrationResult.Json json = new ImmutableDataTypeMigrationResult.Json();

    // Act
    json.setLogicalFlowDataTypeCount(3L);

    // Assert
    assertEquals(3L, json.logicalFlowDataTypeCount);
    assertTrue(json.logicalFlowDataTypeCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeMigrationResult.Json#setPhysicalSpecDataTypeCount(long)}
   */
  @Test
  void testJsonSetPhysicalSpecDataTypeCount() {
    // Arrange
    ImmutableDataTypeMigrationResult.Json json = new ImmutableDataTypeMigrationResult.Json();

    // Act
    json.setPhysicalSpecDataTypeCount(3L);

    // Assert
    assertEquals(3L, json.physicalSpecDataTypeCount);
    assertTrue(json.physicalSpecDataTypeCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeMigrationResult.Json#setUsageCount(long)}
   */
  @Test
  void testJsonSetUsageCount() {
    // Arrange
    ImmutableDataTypeMigrationResult.Json json = new ImmutableDataTypeMigrationResult.Json();

    // Act
    json.setUsageCount(3L);

    // Assert
    assertEquals(3L, json.usageCount);
    assertTrue(json.usageCountIsSet);
  }

  /**
   * Method under test: {@link ImmutableDataTypeMigrationResult.Json#usageCount()}
   */
  @Test
  void testJsonUsageCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDataTypeMigrationResult.Json()).usageCount());
  }
}
