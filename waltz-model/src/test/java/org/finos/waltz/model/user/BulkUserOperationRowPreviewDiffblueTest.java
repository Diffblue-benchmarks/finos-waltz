package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.user.BulkUserOperationRowPreview.ResolutionStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkUserOperationRowPreviewDiffblueTest {
  /**
   * Test {@link BulkUserOperationRowPreview#status()}.
   *
   * <p>Method under test: {@link BulkUserOperationRowPreview#status()}
   */
  @Test
  @DisplayName("Test status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolutionStatus BulkUserOperationRowPreview.status()"})
  void testStatus() {
    // Arrange, Act and Assert
    assertEquals(
        ResolutionStatus.OK,
        ImmutableBulkUserOperationRowPreview.builder()
            .givenComment("Given Comment")
            .givenRole("Given Role")
            .givenUser("Given User")
            .resolvedComment("Resolved Comment")
            .resolvedRole("Resolved Role")
            .resolvedUser("Resolved User")
            .build()
            .status());
  }
}
