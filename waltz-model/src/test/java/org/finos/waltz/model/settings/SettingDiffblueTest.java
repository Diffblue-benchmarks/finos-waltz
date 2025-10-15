package org.finos.waltz.model.settings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SettingDiffblueTest {
  /**
   * Test {@link Setting#restricted()}.
   *
   * <p>Method under test: {@link Setting#restricted()}
   */
  @Test
  @DisplayName("Test restricted()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Setting.restricted()"})
  void testRestricted() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build()
            .restricted());
  }
}
