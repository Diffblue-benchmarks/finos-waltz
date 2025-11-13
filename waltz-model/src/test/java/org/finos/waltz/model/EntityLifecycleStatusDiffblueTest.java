package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityLifecycleStatusDiffblueTest {
  /**
   * Test {@link EntityLifecycleStatus#fromIsRemovedFlag(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityLifecycleStatus#fromIsRemovedFlag(boolean)}
   */
  @Test
  @DisplayName("Test fromIsRemovedFlag(boolean); when 'false'; then return 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus EntityLifecycleStatus.fromIsRemovedFlag(boolean)"})
  void testFromIsRemovedFlag_whenFalse_thenReturnActive() {
    // Arrange, Act and Assert
    assertEquals(EntityLifecycleStatus.ACTIVE, EntityLifecycleStatus.fromIsRemovedFlag(false));
  }

  /**
   * Test {@link EntityLifecycleStatus#fromIsRemovedFlag(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code REMOVED}.
   * </ul>
   *
   * <p>Method under test: {@link EntityLifecycleStatus#fromIsRemovedFlag(boolean)}
   */
  @Test
  @DisplayName("Test fromIsRemovedFlag(boolean); when 'true'; then return 'REMOVED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus EntityLifecycleStatus.fromIsRemovedFlag(boolean)"})
  void testFromIsRemovedFlag_whenTrue_thenReturnRemoved() {
    // Arrange, Act and Assert
    assertEquals(EntityLifecycleStatus.REMOVED, EntityLifecycleStatus.fromIsRemovedFlag(true));
  }
}
