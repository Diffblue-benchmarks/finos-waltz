package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import org.finos.waltz.service.report_grid.ImmutableCellVariable.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CellVariableDiffblueTest {
  /**
   * Test {@link CellVariable#cellName()}.
   *
   * <p>Method under test: {@link CellVariable#cellName()}
   */
  @Test
  @DisplayName("Test cellName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CellVariable.cellName()"})
  void testCellName() {
    // Arrange
    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(
        "",
        numberValueResult
            .addAllOptions(new ArrayList<>())
            .subjectId(1L)
            .textValue("42")
            .build()
            .cellName());
  }
}
