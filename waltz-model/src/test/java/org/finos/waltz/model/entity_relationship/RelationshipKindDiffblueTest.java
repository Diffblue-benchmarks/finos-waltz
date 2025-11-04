package org.finos.waltz.model.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class RelationshipKindDiffblueTest {
  /**
   * Method under test: {@link RelationshipKind#getAllowedEntityKinds()}
   */
  @Test
  void testGetAllowedEntityKinds() {
    // Arrange, Act and Assert
    assertTrue(RelationshipKind.valueOf("HAS").getAllowedEntityKinds().isEmpty());
  }
}
