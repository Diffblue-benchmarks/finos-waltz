package org.finos.waltz.model.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RelationshipKindDiffblueTest {
  /**
   * Test {@link RelationshipKind#getAllowedEntityKinds()}.
   *
   * <p>Method under test: {@link RelationshipKind#getAllowedEntityKinds()}
   */
  @Test
  @DisplayName("Test getAllowedEntityKinds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set RelationshipKind.getAllowedEntityKinds()"})
  void testGetAllowedEntityKinds() {
    // Arrange, Act and Assert
    assertTrue(RelationshipKind.valueOf("HAS").getAllowedEntityKinds().isEmpty());
  }
}
