package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CellResultDiffblueTest {
  /**
   * Method under test: {@link CellResult#mkResult(String, String, String)}
   */
  @Test
  void testMkResult() {
    // Arrange and Act
    CellResult actualMkResultResult = CellResult.mkResult("42", "Option Text", "Option Code");

    // Assert
    assertTrue(actualMkResultResult instanceof ImmutableCellResult);
    assertEquals("42", actualMkResultResult.value());
    assertEquals("Option Code", actualMkResultResult.optionCode());
    assertEquals("Option Text", actualMkResultResult.optionText());
  }
}
