package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.BulkUpdateMode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkUploadLegalEntityRelationshipCommandDiffblueTest {
  /**
   * Test {@link BulkUploadLegalEntityRelationshipCommand#updateMode()}.
   *
   * <ul>
   *   <li>Then return {@code ADD_ONLY}.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadLegalEntityRelationshipCommand#updateMode()}
   */
  @Test
  @DisplayName("Test updateMode(); then return 'ADD_ONLY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BulkUpdateMode BulkUploadLegalEntityRelationshipCommand.updateMode()"})
  void testUpdateMode_thenReturnAddOnly() {
    // Arrange, Act and Assert
    assertEquals(
        BulkUpdateMode.ADD_ONLY,
        ImmutableBulkUploadLegalEntityRelationshipCommand.builder()
            .inputString("Input String")
            .legalEntityRelationshipKindId(1L)
            .updateMode(BulkUpdateMode.ADD_ONLY)
            .build()
            .updateMode());
  }
}
