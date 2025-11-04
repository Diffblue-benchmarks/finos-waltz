package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ResolvedReferenceDiffblueTest {
  /**
   * Method under test: {@link ResolvedReference#mkResolvedReference(String, Map)}
   */
  @Test
  void testMkResolvedReference() {
    // Arrange and Act
    ResolvedReference actualMkResolvedReferenceResult = ResolvedReference.mkResolvedReference("Input String",
        new HashMap<>());

    // Assert
    assertTrue(actualMkResolvedReferenceResult instanceof ImmutableResolvedReference);
    assertEquals("Input String", actualMkResolvedReferenceResult.inputString());
  }

  /**
   * Method under test: {@link ResolvedReference#mkResolvedReference(String, Map)}
   */
  @Test
  void testMkResolvedReference2() {
    // Arrange
    HashMap<String, EntityReference> identifierLookupMap = new HashMap<>();
    identifierLookupMap.replace("inputString", mock(EntityReference.class), mock(EntityReference.class));

    // Act
    ResolvedReference actualMkResolvedReferenceResult = ResolvedReference.mkResolvedReference("Input String",
        identifierLookupMap);

    // Assert
    assertTrue(actualMkResolvedReferenceResult instanceof ImmutableResolvedReference);
    assertEquals("Input String", actualMkResolvedReferenceResult.inputString());
  }
}
