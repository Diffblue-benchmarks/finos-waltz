package org.finos.waltz.model.staticpanel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StaticPanelDiffblueTest {
  /**
   * Test {@link StaticPanel#width()}.
   *
   * <p>Method under test: {@link StaticPanel#width()}
   */
  @Test
  @DisplayName("Test width()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int StaticPanel.width()"})
  void testWidth() {
    // Arrange, Act and Assert
    assertEquals(
        12,
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build()
            .width());
  }

  /**
   * Test {@link StaticPanel#encoding()}.
   *
   * <p>Method under test: {@link StaticPanel#encoding()}
   */
  @Test
  @DisplayName("Test encoding()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ContentKind StaticPanel.encoding()"})
  void testEncoding() {
    // Arrange, Act and Assert
    assertEquals(
        ContentKind.HTML,
        ImmutableStaticPanel.builder()
            .content("Not all who wander are lost")
            .encoding(ContentKind.HTML)
            .group("Group")
            .icon("Icon")
            .id(1L)
            .priority(1)
            .title("Dr")
            .build()
            .encoding());
  }
}
