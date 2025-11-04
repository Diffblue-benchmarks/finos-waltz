package org.finos.waltz.jobs.tools.importers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingBulkImportConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingBulkImportConfig#builder()}
   *   <li>
   * {@link ImmutableAssessmentRatingBulkImportConfig#mode(SynchronisationMode)}
   *   <li>
   * {@link ImmutableAssessmentRatingBulkImportConfig#numberOfHeaderRows(Integer)}
   *   <li>{@link ImmutableAssessmentRatingBulkImportConfig#sheetPosition(Integer)}
   *   <li>{@link ImmutableAssessmentRatingBulkImportConfig#updateUser(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAssessmentRatingBulkImportConfig.Builder actualSheetPositionResult = ImmutableAssessmentRatingBulkImportConfig
        .builder()
        .mode(SynchronisationMode.DELTA)
        .numberOfHeaderRows(10)
        .sheetPosition(1);

    // Assert
    assertSame(actualSheetPositionResult, actualSheetPositionResult.updateUser("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingBulkImportConfig.Builder#assessmentDefinitionId(Long)}
   */
  @Test
  void testBuilderAssessmentDefinitionId() {
    // Arrange
    ImmutableAssessmentRatingBulkImportConfig.Builder builderResult = ImmutableAssessmentRatingBulkImportConfig
        .builder();

    // Act
    ImmutableAssessmentRatingBulkImportConfig.Builder actualAssessmentDefinitionIdResult = builderResult
        .assessmentDefinitionId(1L);

    // Assert
    ImmutableAssessmentRatingBulkImportConfig buildResult = builderResult.build();
    assertEquals("assessment_rating_bulk_import", buildResult.updateUser());
    assertEquals(0, buildResult.sheetPosition().intValue());
    assertEquals(1, buildResult.numberOfHeaderRows().intValue());
    assertEquals(1L, buildResult.assessmentDefinitionId().longValue());
    assertEquals(SynchronisationMode.DELTA, buildResult.mode());
    assertSame(builderResult, actualAssessmentDefinitionIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingBulkImportConfig.Builder#from(AssessmentRatingBulkImportConfig)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRatingBulkImportConfig.Builder builderResult = ImmutableAssessmentRatingBulkImportConfig
        .builder();
    AssessmentRatingBulkImportConfig instance = mock(AssessmentRatingBulkImportConfig.class);
    when(instance.mode()).thenReturn(SynchronisationMode.DELTA);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.numberOfHeaderRows()).thenReturn(10);
    when(instance.sheetPosition()).thenReturn(1);
    when(instance.updateUser()).thenReturn("2020-03-01");

    // Act
    ImmutableAssessmentRatingBulkImportConfig.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitionId();
    verify(instance).mode();
    verify(instance).numberOfHeaderRows();
    verify(instance).sheetPosition();
    verify(instance).updateUser();
    ImmutableAssessmentRatingBulkImportConfig buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.updateUser());
    assertEquals(1, buildResult.sheetPosition().intValue());
    assertEquals(10, buildResult.numberOfHeaderRows().intValue());
    assertEquals(1L, buildResult.assessmentDefinitionId().longValue());
    assertEquals(SynchronisationMode.DELTA, buildResult.mode());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingBulkImportConfig#copyOf(AssessmentRatingBulkImportConfig)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRatingBulkImportConfig instance = mock(AssessmentRatingBulkImportConfig.class);
    when(instance.mode()).thenReturn(SynchronisationMode.DELTA);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.numberOfHeaderRows()).thenReturn(10);
    when(instance.sheetPosition()).thenReturn(1);
    when(instance.updateUser()).thenReturn("2020-03-01");

    // Act
    ImmutableAssessmentRatingBulkImportConfig actualCopyOfResult = ImmutableAssessmentRatingBulkImportConfig
        .copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitionId();
    verify(instance).mode();
    verify(instance).numberOfHeaderRows();
    verify(instance).sheetPosition();
    verify(instance).updateUser();
    assertEquals("2020-03-01", actualCopyOfResult.updateUser());
    assertEquals(1, actualCopyOfResult.sheetPosition().intValue());
    assertEquals(10, actualCopyOfResult.numberOfHeaderRows().intValue());
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId().longValue());
    assertEquals(SynchronisationMode.DELTA, actualCopyOfResult.mode());
  }
}
