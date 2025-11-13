package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.app_group.AppGroupKind;
import org.finos.waltz.model.app_group.ImmutableAppGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IsRemovedProviderDiffblueTest {
  /**
   * Test {@link IsRemovedProvider#isRemoved()}.
   *
   * <p>Method under test: {@link IsRemovedProvider#isRemoved()}
   */
  @Test
  @DisplayName("Test isRemoved()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IsRemovedProvider.isRemoved()"})
  void testIsRemoved() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .isRemoved());
  }
}
