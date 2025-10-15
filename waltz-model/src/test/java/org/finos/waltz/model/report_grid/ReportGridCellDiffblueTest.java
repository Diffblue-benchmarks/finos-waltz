package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import org.finos.waltz.model.report_grid.ImmutableReportGridCell.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportGridCellDiffblueTest {
  /**
   * Test {@link ReportGridCell#options()}.
   *
   * <p>Method under test: {@link ReportGridCell#options()}
   */
  @Test
  @DisplayName("Test options()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ReportGridCell.options()"})
  void testOptions() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertTrue(
        numberValueResult
            .addAllOptions(new ArrayList<>())
            .subjectId(1L)
            .textValue("42")
            .build()
            .options()
            .isEmpty());
  }
}
