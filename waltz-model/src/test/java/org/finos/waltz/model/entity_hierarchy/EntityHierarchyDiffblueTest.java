package org.finos.waltz.model.entity_hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.entity_hierarchy.ImmutableEntityHierarchy.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityHierarchyDiffblueTest {
  /**
   * Test {@link EntityHierarchy#findChildren(Long)}.
   *
   * <p>Method under test: {@link EntityHierarchy#findChildren(Long)}
   */
  @Test
  @DisplayName("Test findChildren(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntityHierarchy.findChildren(Long)"})
  void testFindChildren() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(2L)
            .build());

    // Act and Assert
    assertTrue(builderResult.build().findChildren(1L).isEmpty());
  }

  /**
   * Test {@link EntityHierarchy#findChildren(Long)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchy#findChildren(Long)}
   */
  @Test
  @DisplayName("Test findChildren(Long); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntityHierarchy.findChildren(Long)"})
  void testFindChildren_thenReturnSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    // Act
    Set<Long> actualFindChildrenResult = builderResult.build().findChildren(1L);

    // Assert
    assertEquals(1, actualFindChildrenResult.size());
    assertTrue(actualFindChildrenResult.contains(1L));
  }

  /**
   * Test {@link EntityHierarchy#findChildren(Long)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchy#findChildren(Long)}
   */
  @Test
  @DisplayName("Test findChildren(Long); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntityHierarchy.findChildren(Long)"})
  void testFindChildren_thenReturnSizeIsOne2() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    // Act
    Set<Long> actualFindChildrenResult = builderResult.build().findChildren(1L);

    // Assert
    assertEquals(1, actualFindChildrenResult.size());
    assertTrue(actualFindChildrenResult.contains(1L));
  }

  /**
   * Test {@link EntityHierarchy#findChildren(Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchy#findChildren(Long)}
   */
  @Test
  @DisplayName("Test findChildren(Long); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntityHierarchy.findChildren(Long)"})
  void testFindChildren_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(ImmutableEntityHierarchy.builder().build().findChildren(null).isEmpty());
  }

  /**
   * Test {@link EntityHierarchy#findChildren(Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchy#findChildren(Long)}
   */
  @Test
  @DisplayName("Test findChildren(Long); when one; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntityHierarchy.findChildren(Long)"})
  void testFindChildren_whenOne_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(ImmutableEntityHierarchy.builder().build().findChildren(1L).isEmpty());
  }

  /**
   * Test {@link EntityHierarchy#findAncestors(Long)}.
   *
   * <p>Method under test: {@link EntityHierarchy#findAncestors(Long)}
   */
  @Test
  @DisplayName("Test findAncestors(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntityHierarchy.findAncestors(Long)"})
  void testFindAncestors() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(2L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    // Act and Assert
    assertTrue(builderResult.build().findAncestors(1L).isEmpty());
  }

  /**
   * Test {@link EntityHierarchy#findAncestors(Long)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchy#findAncestors(Long)}
   */
  @Test
  @DisplayName("Test findAncestors(Long); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntityHierarchy.findAncestors(Long)"})
  void testFindAncestors_thenReturnSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    // Act
    Set<Long> actualFindAncestorsResult = builderResult.build().findAncestors(1L);

    // Assert
    assertEquals(1, actualFindAncestorsResult.size());
    assertTrue(actualFindAncestorsResult.contains(1L));
  }

  /**
   * Test {@link EntityHierarchy#findAncestors(Long)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchy#findAncestors(Long)}
   */
  @Test
  @DisplayName("Test findAncestors(Long); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntityHierarchy.findAncestors(Long)"})
  void testFindAncestors_thenReturnSizeIsOne2() {
    // Arrange
    Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());

    // Act
    Set<Long> actualFindAncestorsResult = builderResult.build().findAncestors(1L);

    // Assert
    assertEquals(1, actualFindAncestorsResult.size());
    assertTrue(actualFindAncestorsResult.contains(1L));
  }

  /**
   * Test {@link EntityHierarchy#findAncestors(Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchy#findAncestors(Long)}
   */
  @Test
  @DisplayName("Test findAncestors(Long); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntityHierarchy.findAncestors(Long)"})
  void testFindAncestors_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(ImmutableEntityHierarchy.builder().build().findAncestors(null).isEmpty());
  }

  /**
   * Test {@link EntityHierarchy#findAncestors(Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityHierarchy#findAncestors(Long)}
   */
  @Test
  @DisplayName("Test findAncestors(Long); when one; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntityHierarchy.findAncestors(Long)"})
  void testFindAncestors_whenOne_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(ImmutableEntityHierarchy.builder().build().findAncestors(1L).isEmpty());
  }
}
