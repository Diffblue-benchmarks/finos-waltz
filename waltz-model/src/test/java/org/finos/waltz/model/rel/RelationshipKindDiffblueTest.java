package org.finos.waltz.model.rel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RelationshipKindDiffblueTest {
  /**
   * Test {@link RelationshipKind#isReadonly()}.
   *
   * <p>Method under test: {@link RelationshipKind#isReadonly()}
   */
  @Test
  @DisplayName("Test isReadonly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RelationshipKind.isReadonly()"})
  void testIsReadonly() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableRelationshipKind.builder()
            .categoryA(1L)
            .categoryB(1L)
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kindA(EntityKind.ALL)
            .kindB(EntityKind.ALL)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .isReadonly());
  }
}
