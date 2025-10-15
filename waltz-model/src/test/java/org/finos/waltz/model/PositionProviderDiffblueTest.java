package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PositionProviderDiffblueTest {
  /**
   * Test {@link PositionProvider#position()}.
   *
   * <p>Method under test: {@link PositionProvider#position()}
   */
  @Test
  @DisplayName("Test position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PositionProvider.position()"})
  void testPosition() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ImmutableEnumValue.builder()
            .description("The characteristics of someone or something")
            .icon("Icon")
            .iconColor("Icon Color")
            .key("Key")
            .name("Name")
            .type("Type")
            .build()
            .position());
  }
}
