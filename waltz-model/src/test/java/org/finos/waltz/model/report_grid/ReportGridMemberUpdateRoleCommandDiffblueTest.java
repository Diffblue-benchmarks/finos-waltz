package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportGridMemberUpdateRoleCommandDiffblueTest {
  /**
   * Test {@link ReportGridMemberUpdateRoleCommand#role()}.
   *
   * <ul>
   *   <li>Given builder role {@code VIEWER} userId {@code 42} build.
   *   <li>Then return {@code VIEWER}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridMemberUpdateRoleCommand#role()}
   */
  @Test
  @DisplayName("Test role(); given builder role 'VIEWER' userId '42' build; then return 'VIEWER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridMemberRole ReportGridMemberUpdateRoleCommand.role()"})
  void testRole_givenBuilderRoleViewerUserId42Build_thenReturnViewer() {
    // Arrange, Act and Assert
    assertEquals(
        ReportGridMemberRole.VIEWER,
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build()
            .role());
  }
}
