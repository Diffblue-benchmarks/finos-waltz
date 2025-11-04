package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class LegalEntityRelationshipResolutionErrorDiffblueTest {
  /**
   * Method under test:
   * {@link LegalEntityRelationshipResolutionError#mkError(LegalEntityResolutionErrorCode, String)}
   */
  @Test
  void testMkError() {
    // Arrange and Act
    LegalEntityRelationshipResolutionError actualMkErrorResult = LegalEntityRelationshipResolutionError
        .mkError(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND, "Not all who wander are lost");

    // Assert
    assertTrue(actualMkErrorResult instanceof ImmutableLegalEntityRelationshipResolutionError);
    assertEquals("Not all who wander are lost", actualMkErrorResult.errorMessage());
    assertEquals(LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND, actualMkErrorResult.errorCode());
  }
}
