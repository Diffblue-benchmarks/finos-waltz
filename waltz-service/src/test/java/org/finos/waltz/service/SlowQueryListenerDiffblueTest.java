package org.finos.waltz.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class SlowQueryListenerDiffblueTest {
  /**
   * Method under test:
   * {@link SlowQueryListener.SQLPerformanceWarning#SQLPerformanceWarning(SlowQueryListener, String)}
   */
  @Test
  void testSQLPerformanceWarningNewSQLPerformanceWarning() {
    // Arrange and Act
    SlowQueryListener.SQLPerformanceWarning actualSqlPerformanceWarning = (new SlowQueryListener(
        1)).new SQLPerformanceWarning("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualSqlPerformanceWarning.getMessage());
    assertNull(actualSqlPerformanceWarning.getCause());
    assertEquals(0, actualSqlPerformanceWarning.getSuppressed().length);
  }
}
