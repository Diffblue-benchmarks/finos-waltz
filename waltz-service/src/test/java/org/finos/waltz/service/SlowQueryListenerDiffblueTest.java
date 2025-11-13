package org.finos.waltz.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.service.SlowQueryListener.SQLPerformanceWarning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SlowQueryListenerDiffblueTest {
  /**
   * Test SQLPerformanceWarning {@link
   * SQLPerformanceWarning#SQLPerformanceWarning(SlowQueryListener, String)}.
   *
   * <p>Method under test: {@link SQLPerformanceWarning#SQLPerformanceWarning(SlowQueryListener,
   * String)}
   */
  @Test
  @DisplayName("Test SQLPerformanceWarning new SQLPerformanceWarning(SlowQueryListener, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SQLPerformanceWarning.<init>(SlowQueryListener, String)"})
  void testSQLPerformanceWarningNewSQLPerformanceWarning() {
    // Arrange and Act
    SQLPerformanceWarning actualSqlPerformanceWarning =
        new SlowQueryListener(1).new SQLPerformanceWarning("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", actualSqlPerformanceWarning.getMessage());
    assertNull(actualSqlPerformanceWarning.getCause());
    assertEquals(0, actualSqlPerformanceWarning.getSuppressed().length);
  }
}
