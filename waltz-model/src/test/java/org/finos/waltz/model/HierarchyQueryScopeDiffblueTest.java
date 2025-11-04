package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class HierarchyQueryScopeDiffblueTest {
  /**
   * Method under test:
   * {@link HierarchyQueryScope#determineDownwardsScopeForKind(EntityKind)}
   */
  @Test
  void testDetermineDownwardsScopeForKind() {
    // Arrange, Act and Assert
    assertEquals(HierarchyQueryScope.EXACT, HierarchyQueryScope.determineDownwardsScopeForKind(EntityKind.ALL));
    assertEquals(HierarchyQueryScope.CHILDREN, HierarchyQueryScope.determineDownwardsScopeForKind(EntityKind.ORG_UNIT));
  }

  /**
   * Method under test:
   * {@link HierarchyQueryScope#determineUpwardsScopeForKind(EntityKind)}
   */
  @Test
  void testDetermineUpwardsScopeForKind() {
    // Arrange, Act and Assert
    assertEquals(HierarchyQueryScope.EXACT, HierarchyQueryScope.determineUpwardsScopeForKind(EntityKind.ALL));
    assertEquals(HierarchyQueryScope.PARENTS, HierarchyQueryScope.determineUpwardsScopeForKind(EntityKind.ORG_UNIT));
  }
}
