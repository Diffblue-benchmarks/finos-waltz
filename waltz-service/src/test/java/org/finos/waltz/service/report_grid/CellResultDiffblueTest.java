package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CellResultDiffblueTest {
  /**
   * Test {@link CellResult#mkResult(String, String, String)}.
   * <p>
   * Method under test: {@link CellResult#mkResult(String, String, String)}
   */
  @Test
  @DisplayName("Test mkResult(String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CellResult CellResult.mkResult(String, String, String)"})
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
