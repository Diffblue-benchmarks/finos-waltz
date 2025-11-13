package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IsReadOnlyProviderDiffblueTest {
  /**
   * Test {@link IsReadOnlyProvider#isReadOnly()}.
   *
   * <p>Method under test: {@link IsReadOnlyProvider#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IsReadOnlyProvider.isReadOnly()"})
  void testIsReadOnly() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build()
            .isReadOnly());
  }
}
