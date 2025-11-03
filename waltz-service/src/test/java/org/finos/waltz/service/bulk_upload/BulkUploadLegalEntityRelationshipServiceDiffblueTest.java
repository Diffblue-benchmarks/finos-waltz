package org.finos.waltz.service.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.UploadOperation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkUploadLegalEntityRelationshipServiceDiffblueTest {
  /**
   * Test {@link BulkUploadLegalEntityRelationshipService#determineAction(boolean, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code ADD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadLegalEntityRelationshipService#determineAction(boolean, boolean)}
   */
  @Test
  @DisplayName("Test determineAction(boolean, boolean); when 'false'; then return 'ADD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UploadOperation BulkUploadLegalEntityRelationshipService.determineAction(boolean, boolean)"})
  void testDetermineAction_whenFalse_thenReturnAdd() {
    // Arrange, Act and Assert
    assertEquals(UploadOperation.ADD, BulkUploadLegalEntityRelationshipService.determineAction(false, false));
  }

  /**
   * Test {@link BulkUploadLegalEntityRelationshipService#determineAction(boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code REMOVE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadLegalEntityRelationshipService#determineAction(boolean, boolean)}
   */
  @Test
  @DisplayName("Test determineAction(boolean, boolean); when 'true'; then return 'REMOVE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UploadOperation BulkUploadLegalEntityRelationshipService.determineAction(boolean, boolean)"})
  void testDetermineAction_whenTrue_thenReturnRemove() {
    // Arrange, Act and Assert
    assertEquals(UploadOperation.REMOVE, BulkUploadLegalEntityRelationshipService.determineAction(true, true));
  }

  /**
   * Test {@link BulkUploadLegalEntityRelationshipService#determineAction(boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code UPDATE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BulkUploadLegalEntityRelationshipService#determineAction(boolean, boolean)}
   */
  @Test
  @DisplayName("Test determineAction(boolean, boolean); when 'true'; then return 'UPDATE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UploadOperation BulkUploadLegalEntityRelationshipService.determineAction(boolean, boolean)"})
  void testDetermineAction_whenTrue_thenReturnUpdate() {
    // Arrange, Act and Assert
    assertEquals(UploadOperation.UPDATE, BulkUploadLegalEntityRelationshipService.determineAction(true, false));
  }
}
