package org.finos.waltz.model.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlowDiagramOverlayGroupDiffblueTest {
  /**
   * Test {@link FlowDiagramOverlayGroup#isDefault()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FlowDiagramOverlayGroup#isDefault()}
   */
  @Test
  @DisplayName("Test isDefault(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramOverlayGroup.isDefault()"})
  void testIsDefault_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build()
            .isDefault());
  }
}
