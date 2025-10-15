package org.finos.waltz.model.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ComplexityKindDiffblueTest {
  /**
   * Test {@link ComplexityKind#kind()}.
   *
   * <p>Method under test: {@link ComplexityKind#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ComplexityKind.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .kind());
  }
}
