package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityLifecycleStatusDiffblueTest {
  /**
   * Test {@link EntityLifecycleStatus#fromIsRemovedFlag(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code ACTIVE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLifecycleStatus#fromIsRemovedFlag(boolean)}
   */
  @Test
  @DisplayName("Test fromIsRemovedFlag(boolean); when 'false'; then return 'ACTIVE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityLifecycleStatus EntityLifecycleStatus.fromIsRemovedFlag(boolean)"})
  void testFromIsRemovedFlag_whenFalse_thenReturnActive() {
    // Arrange, Act and Assert
    assertEquals(EntityLifecycleStatus.ACTIVE, EntityLifecycleStatus.fromIsRemovedFlag(false));
  }

  /**
   * Test {@link EntityLifecycleStatus#fromIsRemovedFlag(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code REMOVED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLifecycleStatus#fromIsRemovedFlag(boolean)}
   */
  @Test
  @DisplayName("Test fromIsRemovedFlag(boolean); when 'true'; then return 'REMOVED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityLifecycleStatus EntityLifecycleStatus.fromIsRemovedFlag(boolean)"})
  void testFromIsRemovedFlag_whenTrue_thenReturnRemoved() {
    // Arrange, Act and Assert
    assertEquals(EntityLifecycleStatus.REMOVED, EntityLifecycleStatus.fromIsRemovedFlag(true));
  }
}
