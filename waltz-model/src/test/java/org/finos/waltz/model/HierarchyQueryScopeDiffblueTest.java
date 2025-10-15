package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HierarchyQueryScopeDiffblueTest {
  /**
   * Test {@link HierarchyQueryScope#determineUpwardsScopeForKind(EntityKind)}.
   *
   * <ul>
   *   <li>When {@code ALL}.
   *   <li>Then return {@code EXACT}.
   * </ul>
   *
   * <p>Method under test: {@link HierarchyQueryScope#determineUpwardsScopeForKind(EntityKind)}
   */
  @Test
  @DisplayName("Test determineUpwardsScopeForKind(EntityKind); when 'ALL'; then return 'EXACT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HierarchyQueryScope HierarchyQueryScope.determineUpwardsScopeForKind(EntityKind)"
  })
  void testDetermineUpwardsScopeForKind_whenAll_thenReturnExact() {
    // Arrange, Act and Assert
    assertEquals(
        HierarchyQueryScope.EXACT,
        HierarchyQueryScope.determineUpwardsScopeForKind(EntityKind.ALL));
  }

  /**
   * Test {@link HierarchyQueryScope#determineUpwardsScopeForKind(EntityKind)}.
   *
   * <ul>
   *   <li>When {@code ORG_UNIT}.
   *   <li>Then return {@code PARENTS}.
   * </ul>
   *
   * <p>Method under test: {@link HierarchyQueryScope#determineUpwardsScopeForKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test determineUpwardsScopeForKind(EntityKind); when 'ORG_UNIT'; then return 'PARENTS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HierarchyQueryScope HierarchyQueryScope.determineUpwardsScopeForKind(EntityKind)"
  })
  void testDetermineUpwardsScopeForKind_whenOrgUnit_thenReturnParents() {
    // Arrange, Act and Assert
    assertEquals(
        HierarchyQueryScope.PARENTS,
        HierarchyQueryScope.determineUpwardsScopeForKind(EntityKind.ORG_UNIT));
  }

  /**
   * Test {@link HierarchyQueryScope#determineDownwardsScopeForKind(EntityKind)}.
   *
   * <ul>
   *   <li>When {@code ALL}.
   *   <li>Then return {@code EXACT}.
   * </ul>
   *
   * <p>Method under test: {@link HierarchyQueryScope#determineDownwardsScopeForKind(EntityKind)}
   */
  @Test
  @DisplayName("Test determineDownwardsScopeForKind(EntityKind); when 'ALL'; then return 'EXACT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HierarchyQueryScope HierarchyQueryScope.determineDownwardsScopeForKind(EntityKind)"
  })
  void testDetermineDownwardsScopeForKind_whenAll_thenReturnExact() {
    // Arrange, Act and Assert
    assertEquals(
        HierarchyQueryScope.EXACT,
        HierarchyQueryScope.determineDownwardsScopeForKind(EntityKind.ALL));
  }

  /**
   * Test {@link HierarchyQueryScope#determineDownwardsScopeForKind(EntityKind)}.
   *
   * <ul>
   *   <li>When {@code ORG_UNIT}.
   *   <li>Then return {@code CHILDREN}.
   * </ul>
   *
   * <p>Method under test: {@link HierarchyQueryScope#determineDownwardsScopeForKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test determineDownwardsScopeForKind(EntityKind); when 'ORG_UNIT'; then return 'CHILDREN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HierarchyQueryScope HierarchyQueryScope.determineDownwardsScopeForKind(EntityKind)"
  })
  void testDetermineDownwardsScopeForKind_whenOrgUnit_thenReturnChildren() {
    // Arrange, Act and Assert
    assertEquals(
        HierarchyQueryScope.CHILDREN,
        HierarchyQueryScope.determineDownwardsScopeForKind(EntityKind.ORG_UNIT));
  }
}
