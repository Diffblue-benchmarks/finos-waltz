package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipApplyResult.Builder;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipApplyResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipApplyResultDiffblueTest {
  /**
   * Test Builder {@link Builder#from(BulkUploadRelationshipApplyResult)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build recordsAdded longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkUploadRelationshipApplyResult)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadRelationshipApplyResult); given one; then builder build recordsAdded longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkUploadRelationshipApplyResult)"})
  void testBuilderFrom_givenOne_thenBuilderBuildRecordsAddedLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipApplyResult.builder();
    BulkUploadRelationshipApplyResult instance = mock(BulkUploadRelationshipApplyResult.class);
    when(instance.recordsAdded()).thenReturn(1L);
    when(instance.recordsUpdated()).thenReturn(1L);
    when(instance.skippedRows()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#recordsAdded(Long)}.
   * <p>
   * Method under test: {@link Builder#recordsAdded(Long)}
   */
  @Test
  @DisplayName("Test Builder recordsAdded(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.recordsAdded(Long)"})
  void testBuilderRecordsAdded() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsAdded(1L));
  }

  /**
   * Test Builder {@link Builder#recordsUpdated(Long)}.
   * <p>
   * Method under test: {@link Builder#recordsUpdated(Long)}
   */
  @Test
  @DisplayName("Test Builder recordsUpdated(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.recordsUpdated(Long)"})
  void testBuilderRecordsUpdated() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recordsUpdated(1L));
  }

  /**
   * Test Builder {@link Builder#skippedRows(Long)}.
   * <p>
   * Method under test: {@link Builder#skippedRows(Long)}
   */
  @Test
  @DisplayName("Test Builder skippedRows(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.skippedRows(Long)"})
  void testBuilderSkippedRows() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadRelationshipApplyResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.skippedRows(1L));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setRecordsAdded(Long)}
   *   <li>{@link Json#setRecordsUpdated(Long)}
   *   <li>{@link Json#setSkippedRows(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setRecordsAdded(Long)", "void Json.setRecordsUpdated(Long)",
      "void Json.setSkippedRows(Long)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setRecordsAdded(1L);
    actualJson.setRecordsUpdated(1L);
    actualJson.setSkippedRows(1L);

    // Assert
    assertEquals(1L, actualJson.recordsAdded.longValue());
    assertEquals(1L, actualJson.recordsUpdated.longValue());
    assertEquals(1L, actualJson.skippedRows.longValue());
  }

  /**
   * Test Json {@link Json#recordsAdded()}.
   * <p>
   * Method under test: {@link Json#recordsAdded()}
   */
  @Test
  @DisplayName("Test Json recordsAdded()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.recordsAdded()"})
  void testJsonRecordsAdded() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).recordsAdded());
  }

  /**
   * Test Json {@link Json#recordsUpdated()}.
   * <p>
   * Method under test: {@link Json#recordsUpdated()}
   */
  @Test
  @DisplayName("Test Json recordsUpdated()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.recordsUpdated()"})
  void testJsonRecordsUpdated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).recordsUpdated());
  }

  /**
   * Test Json {@link Json#skippedRows()}.
   * <p>
   * Method under test: {@link Json#skippedRows()}
   */
  @Test
  @DisplayName("Test Json skippedRows()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.skippedRows()"})
  void testJsonSkippedRows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).skippedRows());
  }
}
