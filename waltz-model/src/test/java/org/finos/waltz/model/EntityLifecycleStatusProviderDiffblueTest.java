package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityLifecycleStatusProviderDiffblueTest {
  /**
   * Test {@link EntityLifecycleStatusProvider#entityLifecycleStatus()}.
   *
   * <ul>
   *   <li>Then return {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityLifecycleStatusProvider#entityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test entityLifecycleStatus(); then return 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus EntityLifecycleStatusProvider.entityLifecycleStatus()"})
  void testEntityLifecycleStatus_thenReturnActive() {
    // Arrange, Act and Assert
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .entityLifecycleStatus());
  }
}
