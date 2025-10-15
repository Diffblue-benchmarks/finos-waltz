package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.model.report_grid.ImmutableReportGridMember.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportGridMemberDiffblueTest {
  /**
   * Test {@link ReportGridMember#role()}.
   *
   * <p>Method under test: {@link ReportGridMember#role()}
   */
  @Test
  @DisplayName("Test role()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridMemberRole ReportGridMember.role()"})
  void testRole() {
    // Arrange
    Builder roleResult =
        ImmutableReportGridMember.builder().gridId(1L).role(ReportGridMemberRole.VIEWER);

    // Act and Assert
    assertEquals(
        ReportGridMemberRole.VIEWER,
        roleResult
            .user(
                ImmutablePerson.builder()
                    .departmentName("Department Name")
                    .displayName("Display Name")
                    .email("jane.doe@example.org")
                    .employeeId("42")
                    .id(1L)
                    .isRemoved(true)
                    .kind(EntityKind.ALL)
                    .managerEmployeeId("42")
                    .mobilePhone("6625550144")
                    .officePhone("6625550144")
                    .organisationalUnitId(1L)
                    .personKind(PersonKind.EMPLOYEE)
                    .title("Dr")
                    .userId("42")
                    .userPrincipalName("User Principal Name")
                    .build())
            .build()
            .role());
  }
}
