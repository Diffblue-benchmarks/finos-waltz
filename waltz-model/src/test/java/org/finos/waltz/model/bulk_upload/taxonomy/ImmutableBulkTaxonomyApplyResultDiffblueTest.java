package org.finos.waltz.model.bulk_upload.taxonomy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyApplyResult.Builder;
import org.finos.waltz.model.bulk_upload.taxonomy.ImmutableBulkTaxonomyApplyResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkTaxonomyApplyResultDiffblueTest {
  /**
   * Test Builder {@link Builder#from(BulkTaxonomyApplyResult)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then builder build recordsAdded is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkTaxonomyApplyResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkTaxonomyApplyResult); given 'true'; then builder build recordsAdded is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkTaxonomyApplyResult)"})
  void testBuilderFrom_givenTrue_thenBuilderBuildRecordsAddedIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();
    BulkTaxonomyApplyResult instance = mock(BulkTaxonomyApplyResult.class);
    when(instance.hierarchyRebuilt()).thenReturn(true);
    when(instance.recordsAdded()).thenReturn(1);
    when(instance.recordsRemoved()).thenReturn(1);
    when(instance.recordsRestored()).thenReturn(1);
    when(instance.recordsUpdated()).thenReturn(1);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#hierarchyRebuilt(boolean)}.
   * <p>
   * Method under test: {@link Builder#hierarchyRebuilt(boolean)}
   */
  @Test
  @DisplayName("Test Builder hierarchyRebuilt(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.hierarchyRebuilt(boolean)"})
  void testBuilderHierarchyRebuilt() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.hierarchyRebuilt(true));
  }

  /**
   * Test Builder {@link Builder#recordsAdded(int)}.
   * <p>
   * Method under test: {@link Builder#recordsAdded(int)}
   */
  @Test
  @DisplayName("Test Builder recordsAdded(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.recordsAdded(int)"})
  void testBuilderRecordsAdded() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsAdded(1));
  }

  /**
   * Test Builder {@link Builder#recordsRemoved(int)}.
   * <p>
   * Method under test: {@link Builder#recordsRemoved(int)}
   */
  @Test
  @DisplayName("Test Builder recordsRemoved(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.recordsRemoved(int)"})
  void testBuilderRecordsRemoved() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsRemoved(1));
  }

  /**
   * Test Builder {@link Builder#recordsRestored(int)}.
   * <p>
   * Method under test: {@link Builder#recordsRestored(int)}
   */
  @Test
  @DisplayName("Test Builder recordsRestored(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.recordsRestored(int)"})
  void testBuilderRecordsRestored() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsRestored(1));
  }

  /**
   * Test Builder {@link Builder#recordsUpdated(int)}.
   * <p>
   * Method under test: {@link Builder#recordsUpdated(int)}
   */
  @Test
  @DisplayName("Test Builder recordsUpdated(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.recordsUpdated(int)"})
  void testBuilderRecordsUpdated() {
    // Arrange
    Builder builderResult = ImmutableBulkTaxonomyApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsUpdated(1));
  }

  /**
   * Test Json {@link Json#hierarchyRebuilt()}.
   * <p>
   * Method under test: {@link Json#hierarchyRebuilt()}
   */
  @Test
  @DisplayName("Test Json hierarchyRebuilt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.hierarchyRebuilt()"})
  void testJsonHierarchyRebuilt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).hierarchyRebuilt());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

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
   * Test Json {@link Json#recordsAdded()}.
   * <p>
   * Method under test: {@link Json#recordsAdded()}
   */
  @Test
  @DisplayName("Test Json recordsAdded()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.recordsAdded()"})
  void testJsonRecordsAdded() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).recordsAdded());
  }

  /**
   * Test Json {@link Json#recordsRemoved()}.
   * <p>
   * Method under test: {@link Json#recordsRemoved()}
   */
  @Test
  @DisplayName("Test Json recordsRemoved()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.recordsRemoved()"})
  void testJsonRecordsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).recordsRemoved());
  }

  /**
   * Test Json {@link Json#recordsRestored()}.
   * <p>
   * Method under test: {@link Json#recordsRestored()}
   */
  @Test
  @DisplayName("Test Json recordsRestored()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.recordsRestored()"})
  void testJsonRecordsRestored() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).recordsRestored());
  }

  /**
   * Test Json {@link Json#recordsUpdated()}.
   * <p>
   * Method under test: {@link Json#recordsUpdated()}
   */
  @Test
  @DisplayName("Test Json recordsUpdated()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.recordsUpdated()"})
  void testJsonRecordsUpdated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).recordsUpdated());
  }

  /**
   * Test Json {@link Json#setHierarchyRebuilt(boolean)}.
   * <p>
   * Method under test: {@link Json#setHierarchyRebuilt(boolean)}
   */
  @Test
  @DisplayName("Test Json setHierarchyRebuilt(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setHierarchyRebuilt(boolean)"})
  void testJsonSetHierarchyRebuilt() {
    // Arrange
    Json json = new Json();

    // Act
    json.setHierarchyRebuilt(true);

    // Assert
    assertTrue(json.hierarchyRebuilt);
    assertTrue(json.hierarchyRebuiltIsSet);
  }

  /**
   * Test Json {@link Json#setRecordsAdded(int)}.
   * <p>
   * Method under test: {@link Json#setRecordsAdded(int)}
   */
  @Test
  @DisplayName("Test Json setRecordsAdded(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRecordsAdded(int)"})
  void testJsonSetRecordsAdded() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRecordsAdded(1);

    // Assert
    assertEquals(1, json.recordsAdded);
    assertTrue(json.recordsAddedIsSet);
  }

  /**
   * Test Json {@link Json#setRecordsRemoved(int)}.
   * <p>
   * Method under test: {@link Json#setRecordsRemoved(int)}
   */
  @Test
  @DisplayName("Test Json setRecordsRemoved(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRecordsRemoved(int)"})
  void testJsonSetRecordsRemoved() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRecordsRemoved(1);

    // Assert
    assertEquals(1, json.recordsRemoved);
    assertTrue(json.recordsRemovedIsSet);
  }

  /**
   * Test Json {@link Json#setRecordsRestored(int)}.
   * <p>
   * Method under test: {@link Json#setRecordsRestored(int)}
   */
  @Test
  @DisplayName("Test Json setRecordsRestored(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRecordsRestored(int)"})
  void testJsonSetRecordsRestored() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRecordsRestored(1);

    // Assert
    assertEquals(1, json.recordsRestored);
    assertTrue(json.recordsRestoredIsSet);
  }

  /**
   * Test Json {@link Json#setRecordsUpdated(int)}.
   * <p>
   * Method under test: {@link Json#setRecordsUpdated(int)}
   */
  @Test
  @DisplayName("Test Json setRecordsUpdated(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRecordsUpdated(int)"})
  void testJsonSetRecordsUpdated() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRecordsUpdated(1);

    // Assert
    assertEquals(1, json.recordsUpdated);
    assertTrue(json.recordsUpdatedIsSet);
  }
}
