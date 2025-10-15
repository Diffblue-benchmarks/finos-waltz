package org.finos.waltz.jobs.clients.c1.sc1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SheetDefinitionDiffblueTest {
  /**
   * Test {@link SheetDefinition#sheetNum()}.
   *
   * <p>Method under test: {@link SheetDefinition#sheetNum()}
   */
  @Test
  @DisplayName("Test sheetNum()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SheetDefinition.sheetNum()"})
  void testSheetNum() {
    // Arrange, Act and Assert
    assertEquals(0, SheetDefinition.valueOf("APPLICATION").sheetNum());
  }
}
