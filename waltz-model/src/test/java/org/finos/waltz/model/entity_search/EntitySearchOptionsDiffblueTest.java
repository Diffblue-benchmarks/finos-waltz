package org.finos.waltz.model.entity_search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntitySearchOptionsDiffblueTest {
  /**
   * Test {@link EntitySearchOptions#entityLifecycleStatuses()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntitySearchOptions#entityLifecycleStatuses()}
   */
  @Test
  @DisplayName("Test entityLifecycleStatuses(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntitySearchOptions.entityLifecycleStatuses()"})
  void testEntityLifecycleStatuses_thenReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertTrue(
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build()
            .entityLifecycleStatuses()
            .isEmpty());
  }

  /**
   * Test {@link EntitySearchOptions#limit()}.
   *
   * <ul>
   *   <li>Then return {@link EntitySearchOptions#DEFAULT_SEARCH_RESULTS_LIMIT}.
   * </ul>
   *
   * <p>Method under test: {@link EntitySearchOptions#limit()}
   */
  @Test
  @DisplayName("Test limit(); then return DEFAULT_SEARCH_RESULTS_LIMIT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntitySearchOptions.limit()"})
  void testLimit_thenReturnDefault_search_results_limit() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertEquals(
        EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT,
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build()
            .limit());
  }

  /**
   * Test {@link EntitySearchOptions#userId()}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EntitySearchOptions#userId()}
   */
  @Test
  @DisplayName("Test userId(); then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntitySearchOptions.userId()"})
  void testUserId_thenReturn42() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertEquals(
        "42",
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build()
            .userId());
  }

  /**
   * Test {@link EntitySearchOptions#mkForEntity(EntityKind, String)}.
   *
   * <p>Method under test: {@link EntitySearchOptions#mkForEntity(EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkForEntity(EntityKind, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntitySearchOptions EntitySearchOptions.mkForEntity(EntityKind, String)"})
  void testMkForEntity() {
    // Arrange and Act
    EntitySearchOptions actualMkForEntityResult =
        EntitySearchOptions.mkForEntity(EntityKind.ALL, "Search Query");

    // Assert
    assertTrue(actualMkForEntityResult instanceof ImmutableEntitySearchOptions);
    assertEquals("Search Query", actualMkForEntityResult.searchQuery());
    assertEquals("UNKNOWN", actualMkForEntityResult.userId());
    List<EntityKind> entityKindsResult = actualMkForEntityResult.entityKinds();
    assertEquals(1, entityKindsResult.size());
    List<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualMkForEntityResult.entityLifecycleStatuses();
    assertEquals(2, entityLifecycleStatusesResult.size());
    assertEquals(EntityKind.ALL, entityKindsResult.get(0));
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusesResult.get(0));
    assertEquals(EntityLifecycleStatus.PENDING, entityLifecycleStatusesResult.get(1));
    assertEquals(EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT, actualMkForEntityResult.limit());
  }
}
