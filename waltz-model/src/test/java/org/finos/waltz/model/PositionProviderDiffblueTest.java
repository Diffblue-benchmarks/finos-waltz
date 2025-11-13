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
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PositionProvider#position()}
   */
  @Test
  @DisplayName("Test position(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PositionProvider.position()"})
  void testPosition_thenReturnZero() {
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
