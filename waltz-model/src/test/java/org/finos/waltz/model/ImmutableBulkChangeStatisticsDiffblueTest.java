package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableBulkChangeStatisticsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableBulkChangeStatistics.Builder#addedCount(int)}
   */
  @Test
  void testBuilderAddedCount() {
    // Arrange
    ImmutableBulkChangeStatistics.Builder builderResult = ImmutableBulkChangeStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addedCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkChangeStatistics.Builder#from(BulkChangeStatistics)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkChangeStatistics.Builder builderResult = ImmutableBulkChangeStatistics.builder();
    BulkChangeStatistics instance = mock(BulkChangeStatistics.class);
    when(instance.addedCount()).thenReturn(3);
    when(instance.removedCount()).thenReturn(3);
    when(instance.updatedCount()).thenReturn(3);

    // Act
    ImmutableBulkChangeStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).addedCount();
    verify(instance).removedCount();
    verify(instance).updatedCount();
    ImmutableBulkChangeStatistics buildResult = builderResult.build();
    assertEquals(3, buildResult.addedCount());
    assertEquals(3, buildResult.removedCount());
    assertEquals(3, buildResult.updatedCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkChangeStatistics.Builder#removedCount(int)}
   */
  @Test
  void testBuilderRemovedCount() {
    // Arrange
    ImmutableBulkChangeStatistics.Builder builderResult = ImmutableBulkChangeStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.removedCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkChangeStatistics.Builder#updatedCount(int)}
   */
  @Test
  void testBuilderUpdatedCount() {
    // Arrange
    ImmutableBulkChangeStatistics.Builder builderResult = ImmutableBulkChangeStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.updatedCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkChangeStatistics#copyOf(BulkChangeStatistics)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkChangeStatistics instance = mock(BulkChangeStatistics.class);
    when(instance.addedCount()).thenReturn(3);
    when(instance.removedCount()).thenReturn(3);
    when(instance.updatedCount()).thenReturn(3);

    // Act
    ImmutableBulkChangeStatistics actualCopyOfResult = ImmutableBulkChangeStatistics.copyOf(instance);

    // Assert
    verify(instance).addedCount();
    verify(instance).removedCount();
    verify(instance).updatedCount();
    assertEquals(3, actualCopyOfResult.addedCount());
    assertEquals(3, actualCopyOfResult.removedCount());
    assertEquals(3, actualCopyOfResult.updatedCount());
  }

  /**
   * Method under test: {@link ImmutableBulkChangeStatistics.Json#addedCount()}
   */
  @Test
  void testJsonAddedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkChangeStatistics.Json()).addedCount());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableBulkChangeStatistics.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkChangeStatistics.Json actualJson = new ImmutableBulkChangeStatistics.Json();

    // Assert
    assertEquals(0, actualJson.addedCount);
    assertEquals(0, actualJson.removedCount);
    assertEquals(0, actualJson.updatedCount);
    assertFalse(actualJson.addedCountIsSet);
    assertFalse(actualJson.removedCountIsSet);
    assertFalse(actualJson.updatedCountIsSet);
  }

  /**
   * Method under test: {@link ImmutableBulkChangeStatistics.Json#removedCount()}
   */
  @Test
  void testJsonRemovedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkChangeStatistics.Json()).removedCount());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkChangeStatistics.Json#setAddedCount(int)}
   */
  @Test
  void testJsonSetAddedCount() {
    // Arrange
    ImmutableBulkChangeStatistics.Json json = new ImmutableBulkChangeStatistics.Json();

    // Act
    json.setAddedCount(3);

    // Assert
    assertEquals(3, json.addedCount);
    assertTrue(json.addedCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkChangeStatistics.Json#setRemovedCount(int)}
   */
  @Test
  void testJsonSetRemovedCount() {
    // Arrange
    ImmutableBulkChangeStatistics.Json json = new ImmutableBulkChangeStatistics.Json();

    // Act
    json.setRemovedCount(3);

    // Assert
    assertEquals(3, json.removedCount);
    assertTrue(json.removedCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkChangeStatistics.Json#setUpdatedCount(int)}
   */
  @Test
  void testJsonSetUpdatedCount() {
    // Arrange
    ImmutableBulkChangeStatistics.Json json = new ImmutableBulkChangeStatistics.Json();

    // Act
    json.setUpdatedCount(3);

    // Assert
    assertEquals(3, json.updatedCount);
    assertTrue(json.updatedCountIsSet);
  }

  /**
   * Method under test: {@link ImmutableBulkChangeStatistics.Json#updatedCount()}
   */
  @Test
  void testJsonUpdatedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkChangeStatistics.Json()).updatedCount());
  }
}
