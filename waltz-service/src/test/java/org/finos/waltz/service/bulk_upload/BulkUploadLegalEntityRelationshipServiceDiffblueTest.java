package org.finos.waltz.service.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.UploadOperation;
import org.junit.jupiter.api.Test;

class BulkUploadLegalEntityRelationshipServiceDiffblueTest {
  /**
   * Method under test:
   * {@link BulkUploadLegalEntityRelationshipService#determineAction(boolean, boolean)}
   */
  @Test
  void testDetermineAction() {
    // Arrange, Act and Assert
    assertEquals(UploadOperation.REMOVE, BulkUploadLegalEntityRelationshipService.determineAction(true, true));
    assertEquals(UploadOperation.UPDATE, BulkUploadLegalEntityRelationshipService.determineAction(true, false));
    assertEquals(UploadOperation.ADD, BulkUploadLegalEntityRelationshipService.determineAction(false, false));
  }
}
