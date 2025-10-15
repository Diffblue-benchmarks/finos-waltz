package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LegalEntityRelationshipResolutionErrorDiffblueTest {
  /**
   * Test {@link LegalEntityRelationshipResolutionError#mkError(LegalEntityResolutionErrorCode,
   * String)}.
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipResolutionError#mkError(LegalEntityResolutionErrorCode, String)}
   */
  @Test
  @DisplayName("Test mkError(LegalEntityResolutionErrorCode, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelationshipResolutionError LegalEntityRelationshipResolutionError.mkError(LegalEntityResolutionErrorCode, String)"
  })
  void testMkError() {
    // Arrange and Act
    LegalEntityRelationshipResolutionError actualMkErrorResult =
        LegalEntityRelationshipResolutionError.mkError(
            LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND, "Not all who wander are lost");

    // Assert
    assertTrue(actualMkErrorResult instanceof ImmutableLegalEntityRelationshipResolutionError);
    assertEquals("Not all who wander are lost", actualMkErrorResult.errorMessage());
    assertEquals(
        LegalEntityResolutionErrorCode.LEGAL_ENTITY_NOT_FOUND, actualMkErrorResult.errorCode());
  }
}
