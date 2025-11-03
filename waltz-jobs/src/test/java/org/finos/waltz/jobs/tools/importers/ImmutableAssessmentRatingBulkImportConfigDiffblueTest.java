package org.finos.waltz.jobs.tools.importers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.importers.ImmutableAssessmentRatingBulkImportConfig.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingBulkImportConfigDiffblueTest {
  /**
   * Test {@link ImmutableAssessmentRatingBulkImportConfig#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingBulkImportConfig#builder()}
   *   <li>{@link ImmutableAssessmentRatingBulkImportConfig#mode(SynchronisationMode)}
   *   <li>{@link ImmutableAssessmentRatingBulkImportConfig#numberOfHeaderRows(Integer)}
   *   <li>{@link ImmutableAssessmentRatingBulkImportConfig#sheetPosition(Integer)}
   *   <li>{@link ImmutableAssessmentRatingBulkImportConfig#updateUser(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentRatingBulkImportConfig Builder.build()",
      "Builder Builder.mode(SynchronisationMode)", "Builder Builder.numberOfHeaderRows(Integer)",
      "Builder Builder.sheetPosition(Integer)", "Builder Builder.updateUser(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualSheetPositionResult = ImmutableAssessmentRatingBulkImportConfig.builder()
        .mode(SynchronisationMode.DELTA)
        .numberOfHeaderRows(10)
        .sheetPosition(1);

    // Assert
    assertSame(actualSheetPositionResult, actualSheetPositionResult.updateUser("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#assessmentDefinitionId(Long)}.
   * <p>
   * Method under test: {@link Builder#assessmentDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test Builder assessmentDefinitionId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessmentDefinitionId(Long)"})
  void testBuilderAssessmentDefinitionId() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingBulkImportConfig.builder();

    // Act
    Builder actualAssessmentDefinitionIdResult = builderResult.assessmentDefinitionId(1L);

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
   * Test Builder {@link Builder#from(AssessmentRatingBulkImportConfig)}.
   * <ul>
   *   <li>Given {@code DELTA}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingBulkImportConfig)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingBulkImportConfig); given 'DELTA'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingBulkImportConfig)"})
  void testBuilderFrom_givenDelta_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingBulkImportConfig.builder();
    AssessmentRatingBulkImportConfig instance = mock(AssessmentRatingBulkImportConfig.class);
    when(instance.mode()).thenReturn(SynchronisationMode.DELTA);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.numberOfHeaderRows()).thenReturn(10);
    when(instance.sheetPosition()).thenReturn(1);
    when(instance.updateUser()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
}
