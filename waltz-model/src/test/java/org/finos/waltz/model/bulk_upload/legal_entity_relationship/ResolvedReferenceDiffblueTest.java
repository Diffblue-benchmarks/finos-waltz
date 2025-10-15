package org.finos.waltz.model.bulk_upload.legal_entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ResolvedReferenceDiffblueTest {
  /**
   * Test {@link ResolvedReference#mkResolvedReference(String, Map)}.
   *
   * <p>Method under test: {@link ResolvedReference#mkResolvedReference(String, Map)}
   */
  @Test
  @DisplayName("Test mkResolvedReference(String, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResolvedReference ResolvedReference.mkResolvedReference(String, Map)"})
  void testMkResolvedReference() {
    // Arrange and Act
    ResolvedReference actualMkResolvedReferenceResult =
        ResolvedReference.mkResolvedReference("Input String", new HashMap<>());

    // Assert
    assertTrue(actualMkResolvedReferenceResult instanceof ImmutableResolvedReference);
    assertEquals("Input String", actualMkResolvedReferenceResult.inputString());
  }
}
