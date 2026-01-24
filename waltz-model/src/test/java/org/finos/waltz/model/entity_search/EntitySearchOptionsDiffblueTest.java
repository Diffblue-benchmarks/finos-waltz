package org.finos.waltz.model.entity_search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntitySearchOptionsDiffblueTest {
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
