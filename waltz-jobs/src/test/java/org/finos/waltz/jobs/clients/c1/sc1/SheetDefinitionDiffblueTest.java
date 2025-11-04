package org.finos.waltz.jobs.clients.c1.sc1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SheetDefinitionDiffblueTest {
  /**
   * Method under test: {@link SheetDefinition#sheetNum()}
   */
  @Test
  void testSheetNum() {
    // Arrange, Act and Assert
    assertEquals(0, SheetDefinition.valueOf("APPLICATION").sheetNum());
  }
}
