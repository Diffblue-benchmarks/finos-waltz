package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.Test;

class ReportGridDerivedColumnDefinitionDiffblueTest {
  /**
   * Method under test:
   * {@link ReportGridDerivedColumnDefinition#columnEntityKind()}
   */
  @Test
  void testColumnEntityKind() {
    // Arrange, Act and Assert
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION,
        (new ImmutableReportGridDerivedColumnDefinition.Json()).columnEntityKind());
  }

  /**
   * Method under test: {@link ReportGridDerivedColumnDefinition#kind()}
   */
  @Test
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION,
        (new ImmutableReportGridDerivedColumnDefinition.Json()).kind());
  }
}
