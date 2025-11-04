package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableBulkMeasurableRatingApplyResultDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult.Builder#allocationsAdded(int)}
   */
  @Test
  void testBuilderAllocationsAdded() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult.Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allocationsAdded(1));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult.Builder#from(BulkMeasurableRatingApplyResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult.Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();
    BulkMeasurableRatingApplyResult instance = mock(BulkMeasurableRatingApplyResult.class);
    when(instance.allocationsAdded()).thenReturn(1);
    when(instance.recordsAdded()).thenReturn(1);
    when(instance.recordsRemoved()).thenReturn(1);
    when(instance.recordsUpdated()).thenReturn(1);
    when(instance.skippedRows()).thenReturn(1);

    // Act
    ImmutableBulkMeasurableRatingApplyResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocationsAdded();
    verify(instance).recordsAdded();
    verify(instance).recordsRemoved();
    verify(instance).recordsUpdated();
    verify(instance).skippedRows();
    ImmutableBulkMeasurableRatingApplyResult buildResult = builderResult.build();
    assertEquals(1, buildResult.allocationsAdded());
    assertEquals(1, buildResult.recordsAdded());
    assertEquals(1, buildResult.recordsRemoved());
    assertEquals(1, buildResult.recordsUpdated());
    assertEquals(1, buildResult.skippedRows());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult.Builder#recordsAdded(int)}
   */
  @Test
  void testBuilderRecordsAdded() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult.Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsAdded(1));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult.Builder#recordsRemoved(int)}
   */
  @Test
  void testBuilderRecordsRemoved() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult.Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsRemoved(1));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult.Builder#recordsUpdated(int)}
   */
  @Test
  void testBuilderRecordsUpdated() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult.Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsUpdated(1));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult.Builder#skippedRows(int)}
   */
  @Test
  void testBuilderSkippedRows() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult.Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.skippedRows(1));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult#copyOf(BulkMeasurableRatingApplyResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkMeasurableRatingApplyResult instance = mock(BulkMeasurableRatingApplyResult.class);
    when(instance.allocationsAdded()).thenReturn(1);
    when(instance.recordsAdded()).thenReturn(1);
    when(instance.recordsRemoved()).thenReturn(1);
    when(instance.recordsUpdated()).thenReturn(1);
    when(instance.skippedRows()).thenReturn(1);

    // Act
    ImmutableBulkMeasurableRatingApplyResult actualCopyOfResult = ImmutableBulkMeasurableRatingApplyResult
        .copyOf(instance);

    // Assert
    verify(instance).allocationsAdded();
    verify(instance).recordsAdded();
    verify(instance).recordsRemoved();
    verify(instance).recordsUpdated();
    verify(instance).skippedRows();
    assertEquals(1, actualCopyOfResult.allocationsAdded());
    assertEquals(1, actualCopyOfResult.recordsAdded());
    assertEquals(1, actualCopyOfResult.recordsRemoved());
    assertEquals(1, actualCopyOfResult.recordsUpdated());
    assertEquals(1, actualCopyOfResult.skippedRows());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult.Json#allocationsAdded()}
   */
  @Test
  void testJsonAllocationsAdded() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingApplyResult.Json()).allocationsAdded());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableBulkMeasurableRatingApplyResult.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingApplyResult.Json actualJson = new ImmutableBulkMeasurableRatingApplyResult.Json();

    // Assert
    assertEquals(0, actualJson.allocationsAdded);
    assertEquals(0, actualJson.recordsAdded);
    assertEquals(0, actualJson.recordsRemoved);
    assertEquals(0, actualJson.recordsUpdated);
    assertEquals(0, actualJson.skippedRows);
    assertFalse(actualJson.allocationsAddedIsSet);
    assertFalse(actualJson.recordsAddedIsSet);
    assertFalse(actualJson.recordsRemovedIsSet);
    assertFalse(actualJson.recordsUpdatedIsSet);
    assertFalse(actualJson.skippedRowsIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult.Json#recordsAdded()}
   */
  @Test
  void testJsonRecordsAdded() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingApplyResult.Json()).recordsAdded());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult.Json#recordsRemoved()}
   */
  @Test
  void testJsonRecordsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingApplyResult.Json()).recordsRemoved());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult.Json#recordsUpdated()}
   */
  @Test
  void testJsonRecordsUpdated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingApplyResult.Json()).recordsUpdated());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult.Json#setAllocationsAdded(int)}
   */
  @Test
  void testJsonSetAllocationsAdded() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult.Json json = new ImmutableBulkMeasurableRatingApplyResult.Json();

    // Act
    json.setAllocationsAdded(1);

    // Assert
    assertEquals(1, json.allocationsAdded);
    assertTrue(json.allocationsAddedIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult.Json#setRecordsAdded(int)}
   */
  @Test
  void testJsonSetRecordsAdded() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult.Json json = new ImmutableBulkMeasurableRatingApplyResult.Json();

    // Act
    json.setRecordsAdded(1);

    // Assert
    assertEquals(1, json.recordsAdded);
    assertTrue(json.recordsAddedIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult.Json#setRecordsRemoved(int)}
   */
  @Test
  void testJsonSetRecordsRemoved() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult.Json json = new ImmutableBulkMeasurableRatingApplyResult.Json();

    // Act
    json.setRecordsRemoved(1);

    // Assert
    assertEquals(1, json.recordsRemoved);
    assertTrue(json.recordsRemovedIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult.Json#setRecordsUpdated(int)}
   */
  @Test
  void testJsonSetRecordsUpdated() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult.Json json = new ImmutableBulkMeasurableRatingApplyResult.Json();

    // Act
    json.setRecordsUpdated(1);

    // Assert
    assertEquals(1, json.recordsUpdated);
    assertTrue(json.recordsUpdatedIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult.Json#setSkippedRows(int)}
   */
  @Test
  void testJsonSetSkippedRows() {
    // Arrange
    ImmutableBulkMeasurableRatingApplyResult.Json json = new ImmutableBulkMeasurableRatingApplyResult.Json();

    // Act
    json.setSkippedRows(1);

    // Assert
    assertEquals(1, json.skippedRows);
    assertTrue(json.skippedRowsIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingApplyResult.Json#skippedRows()}
   */
  @Test
  void testJsonSkippedRows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingApplyResult.Json()).skippedRows());
  }
}
