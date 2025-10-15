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
   * <p>Method under test: {@link ReportGridMemberUpdateRoleCommand#role()}
   */
  @Test
  @DisplayName("Test role()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridMemberRole ReportGridMemberUpdateRoleCommand.role()"})
  void testRole() {
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
