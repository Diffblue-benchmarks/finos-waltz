package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingApplyResult.Builder;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingApplyResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkMeasurableRatingApplyResultDiffblueTest {
  /**
   * Test Builder {@link Builder#allocationsAdded(int)}.
   * <p>
   * Method under test: {@link Builder#allocationsAdded(int)}
   */
  @Test
  @DisplayName("Test Builder allocationsAdded(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.allocationsAdded(int)"})
  void testBuilderAllocationsAdded() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allocationsAdded(1));
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingApplyResult)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build allocationsAdded is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingApplyResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingApplyResult); given one; then builder build allocationsAdded is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingApplyResult)"})
  void testBuilderFrom_givenOne_thenBuilderBuildAllocationsAddedIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();
    BulkMeasurableRatingApplyResult instance = mock(BulkMeasurableRatingApplyResult.class);
    when(instance.allocationsAdded()).thenReturn(1);
    when(instance.recordsAdded()).thenReturn(1);
    when(instance.recordsRemoved()).thenReturn(1);
    when(instance.recordsUpdated()).thenReturn(1);
    when(instance.skippedRows()).thenReturn(1);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
    Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();

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
    Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsRemoved(1));
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
    Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsUpdated(1));
  }

  /**
   * Test Builder {@link Builder#skippedRows(int)}.
   * <p>
   * Method under test: {@link Builder#skippedRows(int)}
   */
  @Test
  @DisplayName("Test Builder skippedRows(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.skippedRows(int)"})
  void testBuilderSkippedRows() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.skippedRows(1));
  }

  /**
   * Test Json {@link Json#allocationsAdded()}.
   * <p>
   * Method under test: {@link Json#allocationsAdded()}
   */
  @Test
  @DisplayName("Test Json allocationsAdded()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.allocationsAdded()"})
  void testJsonAllocationsAdded() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).allocationsAdded());
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
   * Test Json {@link Json#setAllocationsAdded(int)}.
   * <p>
   * Method under test: {@link Json#setAllocationsAdded(int)}
   */
  @Test
  @DisplayName("Test Json setAllocationsAdded(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setAllocationsAdded(int)"})
  void testJsonSetAllocationsAdded() {
    // Arrange
    Json json = new Json();

    // Act
    json.setAllocationsAdded(1);

    // Assert
    assertEquals(1, json.allocationsAdded);
    assertTrue(json.allocationsAddedIsSet);
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

  /**
   * Test Json {@link Json#setSkippedRows(int)}.
   * <p>
   * Method under test: {@link Json#setSkippedRows(int)}
   */
  @Test
  @DisplayName("Test Json setSkippedRows(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setSkippedRows(int)"})
  void testJsonSetSkippedRows() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSkippedRows(1);

    // Assert
    assertEquals(1, json.skippedRows);
    assertTrue(json.skippedRowsIsSet);
  }

  /**
   * Test Json {@link Json#skippedRows()}.
   * <p>
   * Method under test: {@link Json#skippedRows()}
   */
  @Test
  @DisplayName("Test Json skippedRows()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.skippedRows()"})
  void testJsonSkippedRows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).skippedRows());
  }
}
