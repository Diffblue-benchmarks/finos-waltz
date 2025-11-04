package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CellOptionDiffblueTest {
  /**
   * Method under test: {@link CellOption#defaultCellOption()}
   */
  @Test
  void testDefaultCellOption() {
    // Arrange and Act
    CellOption actualDefaultCellOptionResult = CellOption.defaultCellOption();

    // Assert
    assertTrue(actualDefaultCellOptionResult instanceof ImmutableCellOption);
    assertEquals("PROVIDED", actualDefaultCellOptionResult.code());
    assertEquals("Provided", actualDefaultCellOptionResult.text());
  }

  /**
   * Method under test: {@link CellOption#mkCellOption(String, String)}
   */
  @Test
  void testMkCellOption() {
    // Arrange and Act
    CellOption actualMkCellOptionResult = CellOption.mkCellOption("Code", "Text");

    // Assert
    assertTrue(actualMkCellOptionResult instanceof ImmutableCellOption);
    assertEquals("Code", actualMkCellOptionResult.code());
    assertEquals("Text", actualMkCellOptionResult.text());
  }
}
