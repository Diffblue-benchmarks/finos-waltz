package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CellOptionDiffblueTest {
  /**
   * Test {@link CellOption#defaultCellOption()}.
   *
   * <p>Method under test: {@link CellOption#defaultCellOption()}
   */
  @Test
  @DisplayName("Test defaultCellOption()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CellOption CellOption.defaultCellOption()"})
  void testDefaultCellOption() {
    // Arrange and Act
    CellOption actualDefaultCellOptionResult = CellOption.defaultCellOption();

    // Assert
    assertTrue(actualDefaultCellOptionResult instanceof ImmutableCellOption);
    assertEquals("PROVIDED", actualDefaultCellOptionResult.code());
    assertEquals("Provided", actualDefaultCellOptionResult.text());
  }

  /**
   * Test {@link CellOption#mkCellOption(String, String)}.
   *
   * <p>Method under test: {@link CellOption#mkCellOption(String, String)}
   */
  @Test
  @DisplayName("Test mkCellOption(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CellOption CellOption.mkCellOption(String, String)"})
  void testMkCellOption() {
    // Arrange and Act
    CellOption actualMkCellOptionResult = CellOption.mkCellOption("Code", "Text");

    // Assert
    assertTrue(actualMkCellOptionResult instanceof ImmutableCellOption);
    assertEquals("Code", actualMkCellOptionResult.code());
    assertEquals("Text", actualMkCellOptionResult.text());
  }
}
