package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipApplyResultDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipApplyResult.Builder#from(BulkUploadRelationshipApplyResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkUploadRelationshipApplyResult.Builder builderResult = ImmutableBulkUploadRelationshipApplyResult
        .builder();
    BulkUploadRelationshipApplyResult instance = mock(BulkUploadRelationshipApplyResult.class);
    when(instance.recordsAdded()).thenReturn(1L);
    when(instance.recordsUpdated()).thenReturn(1L);
    when(instance.skippedRows()).thenReturn(1L);

    // Act
    ImmutableBulkUploadRelationshipApplyResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).recordsAdded();
    verify(instance).recordsUpdated();
    verify(instance).skippedRows();
    ImmutableBulkUploadRelationshipApplyResult buildResult = builderResult.build();
    assertEquals(1L, buildResult.recordsAdded().longValue());
    assertEquals(1L, buildResult.recordsUpdated().longValue());
    assertEquals(1L, buildResult.skippedRows().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipApplyResult.Builder#recordsAdded(Long)}
   */
  @Test
  void testBuilderRecordsAdded() {
    // Arrange
    ImmutableBulkUploadRelationshipApplyResult.Builder builderResult = ImmutableBulkUploadRelationshipApplyResult
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsAdded(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipApplyResult.Builder#recordsUpdated(Long)}
   */
  @Test
  void testBuilderRecordsUpdated() {
    // Arrange
    ImmutableBulkUploadRelationshipApplyResult.Builder builderResult = ImmutableBulkUploadRelationshipApplyResult
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsUpdated(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipApplyResult.Builder#skippedRows(Long)}
   */
  @Test
  void testBuilderSkippedRows() {
    // Arrange
    ImmutableBulkUploadRelationshipApplyResult.Builder builderResult = ImmutableBulkUploadRelationshipApplyResult
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.skippedRows(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipApplyResult#copyOf(BulkUploadRelationshipApplyResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkUploadRelationshipApplyResult instance = mock(BulkUploadRelationshipApplyResult.class);
    when(instance.recordsAdded()).thenReturn(1L);
    when(instance.recordsUpdated()).thenReturn(1L);
    when(instance.skippedRows()).thenReturn(1L);

    // Act
    ImmutableBulkUploadRelationshipApplyResult actualCopyOfResult = ImmutableBulkUploadRelationshipApplyResult
        .copyOf(instance);

    // Assert
    verify(instance).recordsAdded();
    verify(instance).recordsUpdated();
    verify(instance).skippedRows();
    assertEquals(1L, actualCopyOfResult.recordsAdded().longValue());
    assertEquals(1L, actualCopyOfResult.recordsUpdated().longValue());
    assertEquals(1L, actualCopyOfResult.skippedRows().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipApplyResult#fromJson(ImmutableBulkUploadRelationshipApplyResult.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBulkUploadRelationshipApplyResult.Json json = new ImmutableBulkUploadRelationshipApplyResult.Json();
    json.setRecordsAdded(1L);
    json.setRecordsUpdated(1L);
    json.setSkippedRows(1L);

    // Act
    ImmutableBulkUploadRelationshipApplyResult actualFromJsonResult = ImmutableBulkUploadRelationshipApplyResult
        .fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.recordsAdded().longValue());
    assertEquals(1L, actualFromJsonResult.recordsUpdated().longValue());
    assertEquals(1L, actualFromJsonResult.skippedRows().longValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableBulkUploadRelationshipApplyResult.Json}
   *   <li>
   * {@link ImmutableBulkUploadRelationshipApplyResult.Json#setRecordsAdded(Long)}
   *   <li>
   * {@link ImmutableBulkUploadRelationshipApplyResult.Json#setRecordsUpdated(Long)}
   *   <li>
   * {@link ImmutableBulkUploadRelationshipApplyResult.Json#setSkippedRows(Long)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipApplyResult.Json actualJson = new ImmutableBulkUploadRelationshipApplyResult.Json();
    actualJson.setRecordsAdded(1L);
    actualJson.setRecordsUpdated(1L);
    actualJson.setSkippedRows(1L);

    // Assert
    assertEquals(1L, actualJson.recordsAdded.longValue());
    assertEquals(1L, actualJson.recordsUpdated.longValue());
    assertEquals(1L, actualJson.skippedRows.longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipApplyResult.Json#recordsAdded()}
   */
  @Test
  void testJsonRecordsAdded() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipApplyResult.Json()).recordsAdded());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipApplyResult.Json#recordsUpdated()}
   */
  @Test
  void testJsonRecordsUpdated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipApplyResult.Json()).recordsUpdated());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipApplyResult.Json#skippedRows()}
   */
  @Test
  void testJsonSkippedRows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipApplyResult.Json()).skippedRows());
  }
}
