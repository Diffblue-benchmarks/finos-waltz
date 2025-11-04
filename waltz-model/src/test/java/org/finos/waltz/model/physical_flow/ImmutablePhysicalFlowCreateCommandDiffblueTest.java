package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowCreateCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Builder#addAllDataTypeIds(Iterable)}
   */
  @Test
  void testBuilderAddAllDataTypeIds() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDataTypeIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Builder#addAllDataTypeIds(Iterable)}
   */
  @Test
  void testBuilderAddAllDataTypeIds2() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDataTypeIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Builder#addDataTypeIds(long)}
   */
  @Test
  void testBuilderAddDataTypeIds() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypeIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Builder#addDataTypeIds(long[])}
   */
  @Test
  void testBuilderAddDataTypeIds2() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDataTypeIds(1L, -5L, 1L, -5L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Builder#dataTypeIds(Iterable)}
   */
  @Test
  void testBuilderDataTypeIds() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Builder#dataTypeIds(Iterable)}
   */
  @Test
  void testBuilderDataTypeIds2() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Builder#flowAttributes(FlowAttributes)}
   */
  @Test
  void testBuilderFlowAttributes() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowAttributes(new ImmutableFlowAttributes.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Builder#from(PhysicalFlowCreateCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();
    PhysicalFlowCreateCommand instance = mock(PhysicalFlowCreateCommand.class);
    when(instance.dataTypeIds()).thenReturn(new HashSet<>());
    when(instance.logicalFlowId()).thenReturn(1L);
    ImmutableFlowAttributes.Json json = new ImmutableFlowAttributes.Json();
    when(instance.flowAttributes()).thenReturn(json);
    when(instance.specification()).thenReturn(mock(PhysicalSpecification.class));

    // Act
    ImmutablePhysicalFlowCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypeIds();
    verify(instance).flowAttributes();
    verify(instance).logicalFlowId();
    verify(instance).specification();
    ImmutablePhysicalFlowCreateCommand buildResult = builderResult.build();
    assertEquals(1L, buildResult.logicalFlowId());
    assertSame(json, buildResult.flowAttributes());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Builder#from(PhysicalFlowCreateCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();
    PhysicalFlowCreateCommand instance = mock(PhysicalFlowCreateCommand.class);
    when(instance.dataTypeIds()).thenThrow(new IllegalStateException("instance"));
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.flowAttributes()).thenReturn(new ImmutableFlowAttributes.Json());
    when(instance.specification()).thenReturn(mock(PhysicalSpecification.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).dataTypeIds();
    verify(instance).flowAttributes();
    verify(instance).logicalFlowId();
    verify(instance).specification();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Builder#from(PhysicalFlowCreateCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    PhysicalFlowCreateCommand instance = mock(PhysicalFlowCreateCommand.class);
    when(instance.dataTypeIds()).thenReturn(resultLongSet);
    when(instance.logicalFlowId()).thenReturn(1L);
    ImmutableFlowAttributes.Json json = new ImmutableFlowAttributes.Json();
    when(instance.flowAttributes()).thenReturn(json);
    when(instance.specification()).thenReturn(mock(PhysicalSpecification.class));

    // Act
    ImmutablePhysicalFlowCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypeIds();
    verify(instance).flowAttributes();
    verify(instance).logicalFlowId();
    verify(instance).specification();
    ImmutablePhysicalFlowCreateCommand buildResult = builderResult.build();
    Set<Long> dataTypeIdsResult = buildResult.dataTypeIds();
    assertEquals(1, dataTypeIdsResult.size());
    assertEquals(1L, buildResult.logicalFlowId());
    assertTrue(dataTypeIdsResult.contains(-2L));
    assertSame(json, buildResult.flowAttributes());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Builder#logicalFlowId(long)}
   */
  @Test
  void testBuilderLogicalFlowId() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlowId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Builder#specification(PhysicalSpecification)}
   */
  @Test
  void testBuilderSpecification() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Builder builderResult = ImmutablePhysicalFlowCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.specification(mock(PhysicalSpecification.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand#copyOf(PhysicalFlowCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalFlowCreateCommand instance = mock(PhysicalFlowCreateCommand.class);
    when(instance.dataTypeIds()).thenReturn(new HashSet<>());
    when(instance.logicalFlowId()).thenReturn(1L);
    ImmutableFlowAttributes.Json json = new ImmutableFlowAttributes.Json();
    when(instance.flowAttributes()).thenReturn(json);
    when(instance.specification()).thenReturn(mock(PhysicalSpecification.class));

    // Act
    ImmutablePhysicalFlowCreateCommand actualCopyOfResult = ImmutablePhysicalFlowCreateCommand.copyOf(instance);

    // Assert
    verify(instance).dataTypeIds();
    verify(instance).flowAttributes();
    verify(instance).logicalFlowId();
    verify(instance).specification();
    assertEquals(1L, actualCopyOfResult.logicalFlowId());
    assertTrue(actualCopyOfResult.dataTypeIds().isEmpty());
    assertSame(json, actualCopyOfResult.flowAttributes());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand#copyOf(PhysicalFlowCreateCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(7L);
    PhysicalFlowCreateCommand instance = mock(PhysicalFlowCreateCommand.class);
    when(instance.dataTypeIds()).thenReturn(resultLongSet);
    when(instance.logicalFlowId()).thenReturn(1L);
    ImmutableFlowAttributes.Json json = new ImmutableFlowAttributes.Json();
    when(instance.flowAttributes()).thenReturn(json);
    when(instance.specification()).thenReturn(mock(PhysicalSpecification.class));

    // Act
    ImmutablePhysicalFlowCreateCommand actualCopyOfResult = ImmutablePhysicalFlowCreateCommand.copyOf(instance);

    // Assert
    verify(instance).dataTypeIds();
    verify(instance).flowAttributes();
    verify(instance).logicalFlowId();
    verify(instance).specification();
    Set<Long> dataTypeIdsResult = actualCopyOfResult.dataTypeIds();
    assertEquals(1, dataTypeIdsResult.size());
    assertEquals(1L, actualCopyOfResult.logicalFlowId());
    assertTrue(dataTypeIdsResult.contains(7L));
    assertSame(json, actualCopyOfResult.flowAttributes());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand#copyOf(PhysicalFlowCreateCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    resultLongSet.add(7L);
    PhysicalFlowCreateCommand instance = mock(PhysicalFlowCreateCommand.class);
    when(instance.dataTypeIds()).thenReturn(resultLongSet);
    when(instance.logicalFlowId()).thenReturn(1L);
    ImmutableFlowAttributes.Json json = new ImmutableFlowAttributes.Json();
    when(instance.flowAttributes()).thenReturn(json);
    when(instance.specification()).thenReturn(mock(PhysicalSpecification.class));

    // Act
    ImmutablePhysicalFlowCreateCommand actualCopyOfResult = ImmutablePhysicalFlowCreateCommand.copyOf(instance);

    // Assert
    verify(instance).dataTypeIds();
    verify(instance).flowAttributes();
    verify(instance).logicalFlowId();
    verify(instance).specification();
    assertEquals(1L, actualCopyOfResult.logicalFlowId());
    assertEquals(resultLongSet, actualCopyOfResult.dataTypeIds());
    assertSame(json, actualCopyOfResult.flowAttributes());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Json#dataTypeIds()}
   */
  @Test
  void testJsonDataTypeIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowCreateCommand.Json()).dataTypeIds());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Json#flowAttributes()}
   */
  @Test
  void testJsonFlowAttributes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowCreateCommand.Json()).flowAttributes());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Json#logicalFlowId()}
   */
  @Test
  void testJsonLogicalFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowCreateCommand.Json()).logicalFlowId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalFlowCreateCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalFlowCreateCommand.Json actualJson = new ImmutablePhysicalFlowCreateCommand.Json();

    // Assert
    assertNull(actualJson.flowAttributes);
    assertNull(actualJson.specification);
    assertEquals(0L, actualJson.logicalFlowId);
    assertFalse(actualJson.dataTypeIdsIsSet);
    assertFalse(actualJson.logicalFlowIdIsSet);
    assertTrue(actualJson.dataTypeIds.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Json#setDataTypeIds(Set)}
   */
  @Test
  void testJsonSetDataTypeIds() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Json json = new ImmutablePhysicalFlowCreateCommand.Json();

    // Act
    json.setDataTypeIds(new HashSet<>());

    // Assert
    assertTrue(json.dataTypeIds.isEmpty());
    assertTrue(json.dataTypeIdsIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Json#setDataTypeIds(Set)}
   */
  @Test
  void testJsonSetDataTypeIds2() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Json json = new ImmutablePhysicalFlowCreateCommand.Json();

    // Act
    json.setDataTypeIds(null);

    // Assert
    assertNull(json.dataTypeIds);
    assertFalse(json.dataTypeIdsIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Json#setDataTypeIds(Set)}
   */
  @Test
  void testJsonSetDataTypeIds3() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Json json = new ImmutablePhysicalFlowCreateCommand.Json();

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(1L);

    // Act
    json.setDataTypeIds(dataTypeIds);

    // Assert
    Set<Long> resultLongSet = json.dataTypeIds;
    assertEquals(1, resultLongSet.size());
    assertTrue(resultLongSet.contains(1L));
    assertTrue(json.dataTypeIdsIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Json#setDataTypeIds(Set)}
   */
  @Test
  void testJsonSetDataTypeIds4() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Json json = new ImmutablePhysicalFlowCreateCommand.Json();

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(0L);
    dataTypeIds.add(1L);

    // Act
    json.setDataTypeIds(dataTypeIds);

    // Assert
    Set<Long> resultLongSet = json.dataTypeIds;
    assertEquals(2, resultLongSet.size());
    assertTrue(resultLongSet.contains(0L));
    assertTrue(resultLongSet.contains(1L));
    assertTrue(json.dataTypeIdsIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Json#setDataTypeIds(Set)}
   */
  @Test
  void testJsonSetDataTypeIds5() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Json json = new ImmutablePhysicalFlowCreateCommand.Json();
    json.setSpecification(mock(PhysicalSpecification.class));

    // Act
    json.setDataTypeIds(new HashSet<>());

    // Assert
    assertTrue(json.dataTypeIds.isEmpty());
    assertTrue(json.dataTypeIdsIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Json#setLogicalFlowId(long)}
   */
  @Test
  void testJsonSetLogicalFlowId() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Json json = new ImmutablePhysicalFlowCreateCommand.Json();

    // Act
    json.setLogicalFlowId(1L);

    // Assert
    assertEquals(1L, json.logicalFlowId);
    assertTrue(json.logicalFlowIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Json#setLogicalFlowId(long)}
   */
  @Test
  void testJsonSetLogicalFlowId2() {
    // Arrange
    ImmutablePhysicalFlowCreateCommand.Json json = new ImmutablePhysicalFlowCreateCommand.Json();
    json.setSpecification(mock(PhysicalSpecification.class));

    // Act
    json.setLogicalFlowId(1L);

    // Assert
    assertEquals(1L, json.logicalFlowId);
    assertTrue(json.logicalFlowIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlowCreateCommand.Json#specification()}
   */
  @Test
  void testJsonSpecification() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlowCreateCommand.Json()).specification());
  }
}
