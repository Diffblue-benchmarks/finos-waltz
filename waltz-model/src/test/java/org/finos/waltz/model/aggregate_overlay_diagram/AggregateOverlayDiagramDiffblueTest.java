package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AggregateOverlayDiagramDiffblueTest {
  /**
   * Test {@link AggregateOverlayDiagram#kind()}.
   *
   * <ul>
   *   <li>Then return {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link AggregateOverlayDiagram#kind()}
   */
  @Test
  @DisplayName("Test kind(); then return 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind AggregateOverlayDiagram.kind()"})
  void testKind_thenReturnAll() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableAggregateOverlayDiagram.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .status(ReleaseLifecycleStatus.DRAFT)
            .build()
            .kind());
  }
}
