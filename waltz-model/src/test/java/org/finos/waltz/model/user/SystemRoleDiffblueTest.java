package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.Test;

class SystemRoleDiffblueTest {
  /**
   * Method under test: {@link SystemRole#allNames()}
   */
  @Test
  void testAllNames() {
    // Arrange and Act
    Set<String> actualAllNamesResult = SystemRole.allNames();

    // Assert
    assertEquals(31, actualAllNamesResult.size());
    assertTrue(actualAllNamesResult.contains("ACTOR_ADMIN"));
    assertTrue(actualAllNamesResult.contains("ADMIN"));
    assertTrue(actualAllNamesResult.contains("ATTESTATION_ADMIN"));
    assertTrue(actualAllNamesResult.contains("AUTHORITATIVE_SOURCE_EDITOR"));
    assertTrue(actualAllNamesResult.contains("BOOKMARK_EDITOR"));
    assertTrue(actualAllNamesResult.contains("BULK_FLOW_EDITOR"));
    assertTrue(actualAllNamesResult.contains("CAPABILITY_EDITOR"));
    assertTrue(actualAllNamesResult.contains("EUDA_ADMIN"));
    assertTrue(actualAllNamesResult.contains("LINEAGE_EDITOR"));
    assertTrue(actualAllNamesResult.contains("ORG_UNIT_EDITOR"));
    assertTrue(actualAllNamesResult.contains("PHYSICAL_SPECIFICATION_EDITOR"));
  }
}
