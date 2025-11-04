package org.finos.waltz.model.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableDiscouragedSourceDiffblueTest {
  /**
   * Method under test: {@link ImmutableDiscouragedSource.Builder#count(int)}
   */
  @Test
  void testBuilderCount() {
    // Arrange
    ImmutableDiscouragedSource.Builder builderResult = ImmutableDiscouragedSource.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3));
  }

  /**
   * Method under test:
   * {@link ImmutableDiscouragedSource.Builder#dataTypeId(long)}
   */
  @Test
  void testBuilderDataTypeId() {
    // Arrange
    ImmutableDiscouragedSource.Builder builderResult = ImmutableDiscouragedSource.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableDiscouragedSource.Builder#from(DiscouragedSource)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDiscouragedSource.Builder builderResult = ImmutableDiscouragedSource.builder();
    DiscouragedSource instance = mock(DiscouragedSource.class);
    when(instance.count()).thenReturn(3);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.sourceReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableDiscouragedSource.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).dataTypeId();
    verify(instance).sourceReference();
    ImmutableDiscouragedSource buildResult = builderResult.build();
    assertEquals(1L, buildResult.dataTypeId());
    assertEquals(3, buildResult.count());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDiscouragedSource.Builder#from(DiscouragedSource)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDiscouragedSource.Builder builderResult = ImmutableDiscouragedSource.builder();
    DiscouragedSource instance = mock(DiscouragedSource.class);
    when(instance.dataTypeId()).thenThrow(new IllegalStateException("instance"));
    when(instance.sourceReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).dataTypeId();
    verify(instance).sourceReference();
  }

  /**
   * Method under test:
   * {@link ImmutableDiscouragedSource.Builder#sourceReference(EntityReference)}
   */
  @Test
  void testBuilderSourceReference() {
    // Arrange
    ImmutableDiscouragedSource.Builder builderResult = ImmutableDiscouragedSource.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sourceReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableDiscouragedSource#copyOf(DiscouragedSource)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DiscouragedSource instance = mock(DiscouragedSource.class);
    when(instance.count()).thenReturn(3);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.sourceReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableDiscouragedSource actualCopyOfResult = ImmutableDiscouragedSource.copyOf(instance);

    // Assert
    verify(instance).count();
    verify(instance).dataTypeId();
    verify(instance).sourceReference();
    assertEquals(1L, actualCopyOfResult.dataTypeId());
    assertEquals(3, actualCopyOfResult.count());
  }

  /**
   * Method under test: {@link ImmutableDiscouragedSource.Json#count()}
   */
  @Test
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDiscouragedSource.Json()).count());
  }

  /**
   * Method under test: {@link ImmutableDiscouragedSource.Json#dataTypeId()}
   */
  @Test
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDiscouragedSource.Json()).dataTypeId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableDiscouragedSource.Json}
   *   <li>
   * {@link ImmutableDiscouragedSource.Json#setSourceReference(EntityReference)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableDiscouragedSource.Json actualJson = new ImmutableDiscouragedSource.Json();
    actualJson.setSourceReference(null);

    // Assert
    assertNull(actualJson.sourceReference);
    assertEquals(0, actualJson.count);
    assertEquals(0L, actualJson.dataTypeId);
    assertFalse(actualJson.countIsSet);
    assertFalse(actualJson.dataTypeIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableDiscouragedSource.Json#setCount(int)}
   */
  @Test
  void testJsonSetCount() {
    // Arrange
    ImmutableDiscouragedSource.Json json = new ImmutableDiscouragedSource.Json();

    // Act
    json.setCount(3);

    // Assert
    assertEquals(3, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Method under test: {@link ImmutableDiscouragedSource.Json#setCount(int)}
   */
  @Test
  void testJsonSetCount2() {
    // Arrange
    ImmutableDiscouragedSource.Json json = new ImmutableDiscouragedSource.Json();
    json.setSourceReference(mock(EntityReference.class));

    // Act
    json.setCount(3);

    // Assert
    assertEquals(3, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableDiscouragedSource.Json#setDataTypeId(long)}
   */
  @Test
  void testJsonSetDataTypeId() {
    // Arrange
    ImmutableDiscouragedSource.Json json = new ImmutableDiscouragedSource.Json();

    // Act
    json.setDataTypeId(1L);

    // Assert
    assertEquals(1L, json.dataTypeId);
    assertTrue(json.dataTypeIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableDiscouragedSource.Json#setDataTypeId(long)}
   */
  @Test
  void testJsonSetDataTypeId2() {
    // Arrange
    ImmutableDiscouragedSource.Json json = new ImmutableDiscouragedSource.Json();
    json.setSourceReference(mock(EntityReference.class));

    // Act
    json.setDataTypeId(1L);

    // Assert
    assertEquals(1L, json.dataTypeId);
    assertTrue(json.dataTypeIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableDiscouragedSource.Json#sourceReference()}
   */
  @Test
  void testJsonSourceReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDiscouragedSource.Json()).sourceReference());
  }
}
