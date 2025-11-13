package org.finos.waltz.model.role;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RoleDiffblueTest {
  /**
   * Test {@link Role#userSelectable()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Role#userSelectable()}
   */
  @Test
  @DisplayName("Test userSelectable(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Role.userSelectable()"})
  void testUserSelectable_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build()
            .userSelectable());
  }
}
