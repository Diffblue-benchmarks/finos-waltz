package org.finos.waltz.jobs.clients.c1.sc1.parse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.junit.jupiter.api.Test;

class StatusToEntityLifecycleStatusDiffblueTest {
  /**
   * Method under test: {@link StatusToEntityLifecycleStatus#apply(String)}
   */
  @Test
  void testApply() {
    // Arrange, Act and Assert
    assertEquals(EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("foo"));
    assertEquals(EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("foo foo"));
    assertEquals(EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("foo abgeschaltet"));
    assertEquals(EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("foo 42"));
    assertEquals(EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("abgeschaltet foo"));
    assertEquals(EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("abgeschaltet abgeschaltet"));
    assertEquals(EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("abgeschaltet 42"));
    assertEquals(EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("42 foo"));
    assertEquals(EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("42 abgeschaltet"));
    assertEquals(EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("42 42"));
  }
}
