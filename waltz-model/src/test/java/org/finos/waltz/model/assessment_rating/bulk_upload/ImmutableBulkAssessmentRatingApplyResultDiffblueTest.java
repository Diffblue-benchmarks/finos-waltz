package org.finos.waltz.model.assessment_rating.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableBulkAssessmentRatingApplyResultDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingApplyResult.Builder#from(BulkAssessmentRatingApplyResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult.Builder builderResult = ImmutableBulkAssessmentRatingApplyResult.builder();
    BulkAssessmentRatingApplyResult instance = mock(BulkAssessmentRatingApplyResult.class);
    when(instance.recordsAdded()).thenReturn(1);
    when(instance.recordsRemoved()).thenReturn(1);
    when(instance.recordsUpdated()).thenReturn(1);
    when(instance.skippedRows()).thenReturn(1);

    // Act
    ImmutableBulkAssessmentRatingApplyResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).recordsAdded();
    verify(instance).recordsRemoved();
    verify(instance).recordsUpdated();
    verify(instance).skippedRows();
    ImmutableBulkAssessmentRatingApplyResult buildResult = builderResult.build();
    assertEquals(1, buildResult.recordsAdded());
    assertEquals(1, buildResult.recordsRemoved());
    assertEquals(1, buildResult.recordsUpdated());
    assertEquals(1, buildResult.skippedRows());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingApplyResult.Builder#recordsAdded(int)}
   */
  @Test
  void testBuilderRecordsAdded() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult.Builder builderResult = ImmutableBulkAssessmentRatingApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsAdded(1));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingApplyResult.Builder#recordsRemoved(int)}
   */
  @Test
  void testBuilderRecordsRemoved() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult.Builder builderResult = ImmutableBulkAssessmentRatingApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsRemoved(1));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingApplyResult.Builder#recordsUpdated(int)}
   */
  @Test
  void testBuilderRecordsUpdated() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult.Builder builderResult = ImmutableBulkAssessmentRatingApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsUpdated(1));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingApplyResult.Builder#skippedRows(int)}
   */
  @Test
  void testBuilderSkippedRows() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult.Builder builderResult = ImmutableBulkAssessmentRatingApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.skippedRows(1));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingApplyResult#copyOf(BulkAssessmentRatingApplyResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkAssessmentRatingApplyResult instance = mock(BulkAssessmentRatingApplyResult.class);
    when(instance.recordsAdded()).thenReturn(1);
    when(instance.recordsRemoved()).thenReturn(1);
    when(instance.recordsUpdated()).thenReturn(1);
    when(instance.skippedRows()).thenReturn(1);

    // Act
    ImmutableBulkAssessmentRatingApplyResult actualCopyOfResult = ImmutableBulkAssessmentRatingApplyResult
        .copyOf(instance);

    // Assert
    verify(instance).recordsAdded();
    verify(instance).recordsRemoved();
    verify(instance).recordsUpdated();
    verify(instance).skippedRows();
    assertEquals(1, actualCopyOfResult.recordsAdded());
    assertEquals(1, actualCopyOfResult.recordsRemoved());
    assertEquals(1, actualCopyOfResult.recordsUpdated());
    assertEquals(1, actualCopyOfResult.skippedRows());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableBulkAssessmentRatingApplyResult.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkAssessmentRatingApplyResult.Json actualJson = new ImmutableBulkAssessmentRatingApplyResult.Json();

    // Assert
    assertEquals(0, actualJson.recordsAdded);
    assertEquals(0, actualJson.recordsRemoved);
    assertEquals(0, actualJson.recordsUpdated);
    assertEquals(0, actualJson.skippedRows);
    assertFalse(actualJson.recordsAddedIsSet);
    assertFalse(actualJson.recordsRemovedIsSet);
    assertFalse(actualJson.recordsUpdatedIsSet);
    assertFalse(actualJson.skippedRowsIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingApplyResult.Json#recordsAdded()}
   */
  @Test
  void testJsonRecordsAdded() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkAssessmentRatingApplyResult.Json()).recordsAdded());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingApplyResult.Json#recordsRemoved()}
   */
  @Test
  void testJsonRecordsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkAssessmentRatingApplyResult.Json()).recordsRemoved());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingApplyResult.Json#recordsUpdated()}
   */
  @Test
  void testJsonRecordsUpdated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkAssessmentRatingApplyResult.Json()).recordsUpdated());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingApplyResult.Json#setRecordsAdded(int)}
   */
  @Test
  void testJsonSetRecordsAdded() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult.Json json = new ImmutableBulkAssessmentRatingApplyResult.Json();

    // Act
    json.setRecordsAdded(1);

    // Assert
    assertEquals(1, json.recordsAdded);
    assertTrue(json.recordsAddedIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingApplyResult.Json#setRecordsRemoved(int)}
   */
  @Test
  void testJsonSetRecordsRemoved() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult.Json json = new ImmutableBulkAssessmentRatingApplyResult.Json();

    // Act
    json.setRecordsRemoved(1);

    // Assert
    assertEquals(1, json.recordsRemoved);
    assertTrue(json.recordsRemovedIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingApplyResult.Json#setRecordsUpdated(int)}
   */
  @Test
  void testJsonSetRecordsUpdated() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult.Json json = new ImmutableBulkAssessmentRatingApplyResult.Json();

    // Act
    json.setRecordsUpdated(1);

    // Assert
    assertEquals(1, json.recordsUpdated);
    assertTrue(json.recordsUpdatedIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingApplyResult.Json#setSkippedRows(int)}
   */
  @Test
  void testJsonSetSkippedRows() {
    // Arrange
    ImmutableBulkAssessmentRatingApplyResult.Json json = new ImmutableBulkAssessmentRatingApplyResult.Json();

    // Act
    json.setSkippedRows(1);

    // Assert
    assertEquals(1, json.skippedRows);
    assertTrue(json.skippedRowsIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingApplyResult.Json#skippedRows()}
   */
  @Test
  void testJsonSkippedRows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkAssessmentRatingApplyResult.Json()).skippedRows());
  }
}
