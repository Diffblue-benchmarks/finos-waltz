package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CellValueDiffblueTest {
  /**
   * Test {@link CellValue#type()}.
   *
   * <p>Method under test: {@link CellValue#type()}
   */
  @Test
  @DisplayName("Test type()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CellValue.type()"})
  void testType() {
    // Arrange, Act and Assert
    assertEquals(
        "Type",
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build()
            .type());
  }
}
