package org.finos.waltz.jobs.clients.c1.sc1.parse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.finos.waltz.model.application.LifecyclePhase;
import org.junit.jupiter.api.Test;

class StatusToLifecyclePhaseDiffblueTest {
  /**
   * Method under test: {@link StatusToLifecyclePhase#apply(String)}
   */
  @Test
  void testApply() {
    // Arrange, Act and Assert
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("foo"));
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("foo foo"));
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("foo beendet"));
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("foo 42"));
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("beendet foo"));
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("beendet beendet"));
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("beendet 42"));
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("42 foo"));
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("42 beendet"));
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("42 42"));
  }
}
