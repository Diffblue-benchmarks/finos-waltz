package org.finos.waltz.model.process_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProcessDiagramDiffblueTest {
  /**
   * Test {@link ProcessDiagram#kind()}.
   *
   * <p>Method under test: {@link ProcessDiagram#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ProcessDiagram.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableProcessDiagram.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .description("The characteristics of someone or something")
            .diagramKind(ProcessDiagramKind.WALTZ_SPARX)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .provenance("Provenance")
            .build()
            .kind());
  }
}
