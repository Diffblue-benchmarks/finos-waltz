package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportGridInfoDiffblueTest {
  /**
   * Test {@link ReportGridInfo#visibilityKind()}.
   *
   * <p>Method under test: {@link ReportGridInfo#visibilityKind()}
   */
  @Test
  @DisplayName("Test visibilityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridKind ReportGridInfo.visibilityKind()"})
  void testVisibilityKind() {
    // Arrange, Act and Assert
    assertEquals(
        ReportGridKind.PUBLIC,
        ImmutableReportGridInfo.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .gridId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .visibilityKind(ReportGridKind.PUBLIC)
            .build()
            .visibilityKind());
  }
}
