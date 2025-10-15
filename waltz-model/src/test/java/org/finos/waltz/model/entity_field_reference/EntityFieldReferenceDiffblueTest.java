package org.finos.waltz.model.entity_field_reference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityFieldReferenceDiffblueTest {
  /**
   * Test {@link EntityFieldReference#kind()}.
   *
   * <p>Method under test: {@link EntityFieldReference#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind EntityFieldReference.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build()
            .kind());
  }
}
