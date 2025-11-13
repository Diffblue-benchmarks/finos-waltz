package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.report_grid.ImmutableReportGridDerivedColumnDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportGridDerivedColumnDefinitionDiffblueTest {
  /**
   * Test {@link ReportGridDerivedColumnDefinition#columnEntityKind()}.
   *
   * <p>Method under test: {@link ReportGridDerivedColumnDefinition#columnEntityKind()}
   */
  @Test
  @DisplayName("Test columnEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ReportGridDerivedColumnDefinition.columnEntityKind()"})
  void testColumnEntityKind() {
    // Arrange, Act and Assert
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, new Json().columnEntityKind());
  }

  /**
   * Test {@link ReportGridDerivedColumnDefinition#kind()}.
   *
   * <p>Method under test: {@link ReportGridDerivedColumnDefinition#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ReportGridDerivedColumnDefinition.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, new Json().kind());
  }
}
