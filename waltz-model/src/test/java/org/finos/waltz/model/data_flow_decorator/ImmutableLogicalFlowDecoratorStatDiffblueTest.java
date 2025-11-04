package org.finos.waltz.model.data_flow_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.logical_flow.LogicalFlowMeasures;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowDecoratorStatDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableLogicalFlowDecoratorStat.Builder#dataTypeId(long)}
   */
  @Test
  void testBuilderDataTypeId() {
    // Arrange
    ImmutableLogicalFlowDecoratorStat.Builder builderResult = ImmutableLogicalFlowDecoratorStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowDecoratorStat.Builder#from(LogicalFlowDecoratorStat)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLogicalFlowDecoratorStat.Builder builderResult = ImmutableLogicalFlowDecoratorStat.builder();
    LogicalFlowDecoratorStat instance = mock(LogicalFlowDecoratorStat.class);
    when(instance.totalCount()).thenReturn(3);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.logicalFlowMeasures()).thenReturn(mock(LogicalFlowMeasures.class));

    // Act
    ImmutableLogicalFlowDecoratorStat.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypeId();
    verify(instance).logicalFlowMeasures();
    verify(instance).totalCount();
    ImmutableLogicalFlowDecoratorStat buildResult = builderResult.build();
    assertEquals(1L, buildResult.dataTypeId());
    assertEquals(3, buildResult.totalCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowDecoratorStat.Builder#from(LogicalFlowDecoratorStat)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLogicalFlowDecoratorStat.Builder builderResult = ImmutableLogicalFlowDecoratorStat.builder();
    LogicalFlowDecoratorStat instance = mock(LogicalFlowDecoratorStat.class);
    when(instance.totalCount()).thenThrow(new IllegalStateException("instance"));
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.logicalFlowMeasures()).thenReturn(mock(LogicalFlowMeasures.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).dataTypeId();
    verify(instance).logicalFlowMeasures();
    verify(instance).totalCount();
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowDecoratorStat.Builder#logicalFlowMeasures(LogicalFlowMeasures)}
   */
  @Test
  void testBuilderLogicalFlowMeasures() {
    // Arrange
    ImmutableLogicalFlowDecoratorStat.Builder builderResult = ImmutableLogicalFlowDecoratorStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlowMeasures(mock(LogicalFlowMeasures.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowDecoratorStat.Builder#totalCount(int)}
   */
  @Test
  void testBuilderTotalCount() {
    // Arrange
    ImmutableLogicalFlowDecoratorStat.Builder builderResult = ImmutableLogicalFlowDecoratorStat.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.totalCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowDecoratorStat#copyOf(LogicalFlowDecoratorStat)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LogicalFlowDecoratorStat instance = mock(LogicalFlowDecoratorStat.class);
    when(instance.totalCount()).thenReturn(3);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.logicalFlowMeasures()).thenReturn(mock(LogicalFlowMeasures.class));

    // Act
    ImmutableLogicalFlowDecoratorStat actualCopyOfResult = ImmutableLogicalFlowDecoratorStat.copyOf(instance);

    // Assert
    verify(instance).dataTypeId();
    verify(instance).logicalFlowMeasures();
    verify(instance).totalCount();
    assertEquals(1L, actualCopyOfResult.dataTypeId());
    assertEquals(3, actualCopyOfResult.totalCount());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowDecoratorStat.Json#dataTypeId()}
   */
  @Test
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalFlowDecoratorStat.Json()).dataTypeId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableLogicalFlowDecoratorStat.Json}
   *   <li>
   * {@link ImmutableLogicalFlowDecoratorStat.Json#setLogicalFlowMeasures(LogicalFlowMeasures)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableLogicalFlowDecoratorStat.Json actualJson = new ImmutableLogicalFlowDecoratorStat.Json();
    actualJson.setLogicalFlowMeasures(null);

    // Assert
    assertNull(actualJson.logicalFlowMeasures);
    assertEquals(0, actualJson.totalCount);
    assertEquals(0L, actualJson.dataTypeId);
    assertFalse(actualJson.dataTypeIdIsSet);
    assertFalse(actualJson.totalCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowDecoratorStat.Json#logicalFlowMeasures()}
   */
  @Test
  void testJsonLogicalFlowMeasures() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalFlowDecoratorStat.Json()).logicalFlowMeasures());
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowDecoratorStat.Json#setDataTypeId(long)}
   */
  @Test
  void testJsonSetDataTypeId() {
    // Arrange
    ImmutableLogicalFlowDecoratorStat.Json json = new ImmutableLogicalFlowDecoratorStat.Json();

    // Act
    json.setDataTypeId(1L);

    // Assert
    assertEquals(1L, json.dataTypeId);
    assertTrue(json.dataTypeIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowDecoratorStat.Json#setDataTypeId(long)}
   */
  @Test
  void testJsonSetDataTypeId2() {
    // Arrange
    ImmutableLogicalFlowDecoratorStat.Json json = new ImmutableLogicalFlowDecoratorStat.Json();
    json.setLogicalFlowMeasures(mock(LogicalFlowMeasures.class));

    // Act
    json.setDataTypeId(1L);

    // Assert
    assertEquals(1L, json.dataTypeId);
    assertTrue(json.dataTypeIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowDecoratorStat.Json#setTotalCount(int)}
   */
  @Test
  void testJsonSetTotalCount() {
    // Arrange
    ImmutableLogicalFlowDecoratorStat.Json json = new ImmutableLogicalFlowDecoratorStat.Json();

    // Act
    json.setTotalCount(3);

    // Assert
    assertEquals(3, json.totalCount);
    assertTrue(json.totalCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowDecoratorStat.Json#setTotalCount(int)}
   */
  @Test
  void testJsonSetTotalCount2() {
    // Arrange
    ImmutableLogicalFlowDecoratorStat.Json json = new ImmutableLogicalFlowDecoratorStat.Json();
    json.setLogicalFlowMeasures(mock(LogicalFlowMeasures.class));

    // Act
    json.setTotalCount(3);

    // Assert
    assertEquals(3, json.totalCount);
    assertTrue(json.totalCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowDecoratorStat.Json#totalCount()}
   */
  @Test
  void testJsonTotalCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLogicalFlowDecoratorStat.Json()).totalCount());
  }
}
