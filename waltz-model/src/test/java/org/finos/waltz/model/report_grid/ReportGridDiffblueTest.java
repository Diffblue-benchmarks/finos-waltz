package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.report_grid.ImmutableReportGrid.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportGridDiffblueTest {
  /**
   * Test {@link ReportGrid#userRole()}.
   *
   * <ul>
   *   <li>Then return {@code VIEWER}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGrid#userRole()}
   */
  @Test
  @DisplayName("Test userRole(); then return 'VIEWER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridMemberRole ReportGrid.userRole()"})
  void testUserRole_thenReturnViewer() {
    // Arrange
    Builder builderResult = ImmutableReportGrid.builder();

    // Act and Assert
    assertEquals(
        ReportGridMemberRole.VIEWER,
        builderResult
            .definition(
                ImmutableReportGridDefinition.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(ReportGridKind.PUBLIC)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .instance(ImmutableReportGridInstance.builder().build())
            .userRole(ReportGridMemberRole.VIEWER)
            .build()
            .userRole());
  }
}
