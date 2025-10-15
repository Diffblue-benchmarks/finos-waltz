package org.finos.waltz.model.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramEntity.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlowDiagramEntityDiffblueTest {
  /**
   * Test {@link FlowDiagramEntity#isNotable()}.
   *
   * <p>Method under test: {@link FlowDiagramEntity#isNotable()}
   */
  @Test
  @DisplayName("Test isNotable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowDiagramEntity.isNotable()"})
  void testIsNotable() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);

    // Act and Assert
    assertFalse(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .isNotable());
  }
}
