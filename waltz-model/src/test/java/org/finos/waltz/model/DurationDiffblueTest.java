package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DurationDiffblueTest {
  /**
   * Test {@link Duration#numDays()}.
   * <p>
   * Method under test: {@link Duration#numDays()}
   */
  @Test
  @DisplayName("Test numDays()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Duration.numDays()"})
  void testNumDays() {
    // Arrange, Act and Assert
    assertEquals(1, Duration.valueOf("DAY").numDays());
  }
}
