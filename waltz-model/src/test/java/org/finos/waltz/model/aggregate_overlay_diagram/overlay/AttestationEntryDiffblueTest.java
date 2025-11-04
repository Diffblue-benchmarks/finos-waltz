package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AttestationEntryDiffblueTest {
  /**
   * Method under test: {@link AttestationEntry#mkUnattestedEntry(long)}
   */
  @Test
  void testMkUnattestedEntry() {
    // Arrange and Act
    AttestationEntry actualMkUnattestedEntryResult = AttestationEntry.mkUnattestedEntry(1L);

    // Assert
    assertTrue(actualMkUnattestedEntryResult instanceof ImmutableAttestationEntry);
    assertNull(actualMkUnattestedEntryResult.attestedBy());
    assertNull(actualMkUnattestedEntryResult.attestedAt());
    assertEquals(1L, actualMkUnattestedEntryResult.appId());
  }
}
