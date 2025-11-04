package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.entity_field_reference.EntityFieldReference;
import org.junit.jupiter.api.Test;

class ReportGridFixedColumnDefinitionDiffblueTest {
  /**
   * Method under test: {@link ReportGridFixedColumnDefinition#kind()}
   */
  @Test
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION,
        (new ImmutableReportGridFixedColumnDefinition.Json()).kind());
  }

  /**
   * Method under test: {@link ReportGridFixedColumnDefinition#kind()}
   */
  @Test
  void testKind2() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Json json = new ImmutableReportGridFixedColumnDefinition.Json();
    json.setEntityFieldReference(mock(EntityFieldReference.class));

    // Act and Assert
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, json.kind());
  }
}
