package org.finos.waltz.test_common.playwright;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SectionDiffblueTest {
  /**
   * Test {@link Section#id()}.
   * <p>
   * Method under test: {@link Section#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Section.id()"})
  void testId() {
    // Arrange, Act and Assert
    assertEquals(17, Section.valueOf("APP_SURVEYS").id());
  }
}
