package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.report_grid.ImmutableReportGridFixedColumnDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportGridFixedColumnDefinitionDiffblueTest {
  /**
   * Test {@link ReportGridFixedColumnDefinition#kind()}.
   *
   * <p>Method under test: {@link ReportGridFixedColumnDefinition#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ReportGridFixedColumnDefinition.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, new Json().kind());
  }
}
