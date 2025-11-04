package org.finos.waltz.model.bulk_upload.taxonomy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableBulkTaxonomyApplyResultDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult.Builder#from(BulkTaxonomyApplyResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult.Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();
    BulkTaxonomyApplyResult instance = mock(BulkTaxonomyApplyResult.class);
    when(instance.hierarchyRebuilt()).thenReturn(true);
    when(instance.recordsAdded()).thenReturn(1);
    when(instance.recordsRemoved()).thenReturn(1);
    when(instance.recordsRestored()).thenReturn(1);
    when(instance.recordsUpdated()).thenReturn(1);

    // Act
    ImmutableBulkTaxonomyApplyResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).hierarchyRebuilt();
    verify(instance).recordsAdded();
    verify(instance).recordsRemoved();
    verify(instance).recordsRestored();
    verify(instance).recordsUpdated();
    ImmutableBulkTaxonomyApplyResult buildResult = builderResult.build();
    assertEquals(1, buildResult.recordsAdded());
    assertEquals(1, buildResult.recordsRemoved());
    assertEquals(1, buildResult.recordsRestored());
    assertEquals(1, buildResult.recordsUpdated());
    assertTrue(buildResult.hierarchyRebuilt());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult.Builder#hierarchyRebuilt(boolean)}
   */
  @Test
  void testBuilderHierarchyRebuilt() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult.Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.hierarchyRebuilt(true));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult.Builder#recordsAdded(int)}
   */
  @Test
  void testBuilderRecordsAdded() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult.Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsAdded(1));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult.Builder#recordsRemoved(int)}
   */
  @Test
  void testBuilderRecordsRemoved() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult.Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsRemoved(1));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult.Builder#recordsRestored(int)}
   */
  @Test
  void testBuilderRecordsRestored() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult.Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsRestored(1));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult.Builder#recordsUpdated(int)}
   */
  @Test
  void testBuilderRecordsUpdated() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult.Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsUpdated(1));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult#copyOf(BulkTaxonomyApplyResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkTaxonomyApplyResult instance = mock(BulkTaxonomyApplyResult.class);
    when(instance.hierarchyRebuilt()).thenReturn(true);
    when(instance.recordsAdded()).thenReturn(1);
    when(instance.recordsRemoved()).thenReturn(1);
    when(instance.recordsRestored()).thenReturn(1);
    when(instance.recordsUpdated()).thenReturn(1);

    // Act
    ImmutableBulkTaxonomyApplyResult actualCopyOfResult = ImmutableBulkTaxonomyApplyResult.copyOf(instance);

    // Assert
    verify(instance).hierarchyRebuilt();
    verify(instance).recordsAdded();
    verify(instance).recordsRemoved();
    verify(instance).recordsRestored();
    verify(instance).recordsUpdated();
    assertEquals(1, actualCopyOfResult.recordsAdded());
    assertEquals(1, actualCopyOfResult.recordsRemoved());
    assertEquals(1, actualCopyOfResult.recordsRestored());
    assertEquals(1, actualCopyOfResult.recordsUpdated());
    assertTrue(actualCopyOfResult.hierarchyRebuilt());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult.Json#hierarchyRebuilt()}
   */
  @Test
  void testJsonHierarchyRebuilt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkTaxonomyApplyResult.Json()).hierarchyRebuilt());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableBulkTaxonomyApplyResult.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableBulkTaxonomyApplyResult.Json actualJson = new ImmutableBulkTaxonomyApplyResult.Json();

    // Assert
    assertEquals(0, actualJson.recordsAdded);
    assertEquals(0, actualJson.recordsRemoved);
    assertEquals(0, actualJson.recordsRestored);
    assertEquals(0, actualJson.recordsUpdated);
    assertFalse(actualJson.hierarchyRebuilt);
    assertFalse(actualJson.hierarchyRebuiltIsSet);
    assertFalse(actualJson.recordsAddedIsSet);
    assertFalse(actualJson.recordsRemovedIsSet);
    assertFalse(actualJson.recordsRestoredIsSet);
    assertFalse(actualJson.recordsUpdatedIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult.Json#recordsAdded()}
   */
  @Test
  void testJsonRecordsAdded() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkTaxonomyApplyResult.Json()).recordsAdded());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult.Json#recordsRemoved()}
   */
  @Test
  void testJsonRecordsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkTaxonomyApplyResult.Json()).recordsRemoved());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult.Json#recordsRestored()}
   */
  @Test
  void testJsonRecordsRestored() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkTaxonomyApplyResult.Json()).recordsRestored());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult.Json#recordsUpdated()}
   */
  @Test
  void testJsonRecordsUpdated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkTaxonomyApplyResult.Json()).recordsUpdated());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult.Json#setHierarchyRebuilt(boolean)}
   */
  @Test
  void testJsonSetHierarchyRebuilt() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult.Json json = new ImmutableBulkTaxonomyApplyResult.Json();

    // Act
    json.setHierarchyRebuilt(true);

    // Assert
    assertTrue(json.hierarchyRebuilt);
    assertTrue(json.hierarchyRebuiltIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult.Json#setRecordsAdded(int)}
   */
  @Test
  void testJsonSetRecordsAdded() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult.Json json = new ImmutableBulkTaxonomyApplyResult.Json();

    // Act
    json.setRecordsAdded(1);

    // Assert
    assertEquals(1, json.recordsAdded);
    assertTrue(json.recordsAddedIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult.Json#setRecordsRemoved(int)}
   */
  @Test
  void testJsonSetRecordsRemoved() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult.Json json = new ImmutableBulkTaxonomyApplyResult.Json();

    // Act
    json.setRecordsRemoved(1);

    // Assert
    assertEquals(1, json.recordsRemoved);
    assertTrue(json.recordsRemovedIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult.Json#setRecordsRestored(int)}
   */
  @Test
  void testJsonSetRecordsRestored() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult.Json json = new ImmutableBulkTaxonomyApplyResult.Json();

    // Act
    json.setRecordsRestored(1);

    // Assert
    assertEquals(1, json.recordsRestored);
    assertTrue(json.recordsRestoredIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyApplyResult.Json#setRecordsUpdated(int)}
   */
  @Test
  void testJsonSetRecordsUpdated() {
    // Arrange
    ImmutableBulkTaxonomyApplyResult.Json json = new ImmutableBulkTaxonomyApplyResult.Json();

    // Act
    json.setRecordsUpdated(1);

    // Assert
    assertEquals(1, json.recordsUpdated);
    assertTrue(json.recordsUpdatedIsSet);
  }
}
