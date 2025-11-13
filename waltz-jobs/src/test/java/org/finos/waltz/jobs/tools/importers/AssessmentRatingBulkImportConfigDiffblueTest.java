package org.finos.waltz.jobs.tools.importers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AssessmentRatingBulkImportConfigDiffblueTest {
  /**
   * Test {@link AssessmentRatingBulkImportConfig#numberOfHeaderRows()}.
   *
   * <p>Method under test: {@link AssessmentRatingBulkImportConfig#numberOfHeaderRows()}
   */
  @Test
  @DisplayName("Test numberOfHeaderRows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer AssessmentRatingBulkImportConfig.numberOfHeaderRows()"})
  void testNumberOfHeaderRows() {
    // Arrange, Act and Assert
    assertEquals(
        10,
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build()
            .numberOfHeaderRows()
            .intValue());
  }

  /**
   * Test {@link AssessmentRatingBulkImportConfig#sheetPosition()}.
   *
   * <p>Method under test: {@link AssessmentRatingBulkImportConfig#sheetPosition()}
   */
  @Test
  @DisplayName("Test sheetPosition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer AssessmentRatingBulkImportConfig.sheetPosition()"})
  void testSheetPosition() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build()
            .sheetPosition()
            .intValue());
  }

  /**
   * Test {@link AssessmentRatingBulkImportConfig#updateUser()}.
   *
   * <p>Method under test: {@link AssessmentRatingBulkImportConfig#updateUser()}
   */
  @Test
  @DisplayName("Test updateUser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AssessmentRatingBulkImportConfig.updateUser()"})
  void testUpdateUser() {
    // Arrange, Act and Assert
    assertEquals(
        "2020-03-01",
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build()
            .updateUser());
  }

  /**
   * Test {@link AssessmentRatingBulkImportConfig#mode()}.
   *
   * <p>Method under test: {@link AssessmentRatingBulkImportConfig#mode()}
   */
  @Test
  @DisplayName("Test mode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SynchronisationMode AssessmentRatingBulkImportConfig.mode()"})
  void testMode() {
    // Arrange, Act and Assert
    assertEquals(
        SynchronisationMode.DELTA,
        ImmutableAssessmentRatingBulkImportConfig.builder()
            .assessmentDefinitionId(1L)
            .mode(SynchronisationMode.DELTA)
            .numberOfHeaderRows(10)
            .sheetPosition(1)
            .updateUser("2020-03-01")
            .build()
            .mode());
  }
}
