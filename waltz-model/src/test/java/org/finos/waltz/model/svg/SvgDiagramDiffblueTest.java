package org.finos.waltz.model.svg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SvgDiagramDiffblueTest {
  /**
   * Test {@link SvgDiagram#product()}.
   *
   * <p>Method under test: {@link SvgDiagram#product()}
   */
  @Test
  @DisplayName("Test product()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SvgDiagram.product()"})
  void testProduct() {
    // Arrange, Act and Assert
    assertEquals(
        "Product",
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build()
            .product());
  }
}
