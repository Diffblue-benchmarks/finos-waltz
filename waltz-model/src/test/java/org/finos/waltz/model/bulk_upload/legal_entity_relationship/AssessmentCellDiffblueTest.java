package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AssessmentCellDiffblueTest {
  /**
   * Test {@link AssessmentCell#statuses()}.
   *
   * <ul>
   *   <li>Given builder columnId one inputString {@code Input String} build.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentCell#statuses()}
   */
  @Test
  @DisplayName(
      "Test statuses(); given builder columnId one inputString 'Input String' build; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set AssessmentCell.statuses()"})
  void testStatuses_givenBuilderColumnIdOneInputStringInputStringBuild_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableAssessmentCell.builder()
            .columnId(1)
            .inputString("Input String")
            .build()
            .statuses()
            .isEmpty());
  }
}
