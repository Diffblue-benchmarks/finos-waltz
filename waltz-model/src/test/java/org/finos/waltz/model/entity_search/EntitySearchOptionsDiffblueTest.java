package org.finos.waltz.model.entity_search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.junit.jupiter.api.Test;

class EntitySearchOptionsDiffblueTest {
  /**
   * Method under test:
   * {@link EntitySearchOptions#mkForEntity(EntityKind, String)}
   */
  @Test
  void testMkForEntity() {
    // Arrange and Act
    EntitySearchOptions actualMkForEntityResult = EntitySearchOptions.mkForEntity(EntityKind.ALL, "Search Query");

    // Assert
    assertTrue(actualMkForEntityResult instanceof ImmutableEntitySearchOptions);
    assertEquals("Search Query", actualMkForEntityResult.searchQuery());
    assertEquals("UNKNOWN", actualMkForEntityResult.userId());
    List<EntityKind> entityKindsResult = actualMkForEntityResult.entityKinds();
    assertEquals(1, entityKindsResult.size());
    List<EntityLifecycleStatus> entityLifecycleStatusesResult = actualMkForEntityResult.entityLifecycleStatuses();
    assertEquals(2, entityLifecycleStatusesResult.size());
    assertEquals(EntityKind.ALL, entityKindsResult.get(0));
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusesResult.get(0));
    assertEquals(EntityLifecycleStatus.PENDING, entityLifecycleStatusesResult.get(1));
    assertEquals(EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT, actualMkForEntityResult.limit());
  }
}
