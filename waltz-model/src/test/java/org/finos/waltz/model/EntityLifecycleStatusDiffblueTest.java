package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class EntityLifecycleStatusDiffblueTest {
  /**
   * Method under test: {@link EntityLifecycleStatus#fromIsRemovedFlag(boolean)}
   */
  @Test
  void testFromIsRemovedFlag() {
    // Arrange, Act and Assert
    assertEquals(EntityLifecycleStatus.REMOVED, EntityLifecycleStatus.fromIsRemovedFlag(true));
    assertEquals(EntityLifecycleStatus.ACTIVE, EntityLifecycleStatus.fromIsRemovedFlag(false));
  }
}
