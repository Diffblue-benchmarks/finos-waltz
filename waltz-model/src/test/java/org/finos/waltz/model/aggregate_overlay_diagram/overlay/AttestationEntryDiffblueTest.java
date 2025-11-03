package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AttestationEntryDiffblueTest {
  /**
   * Test {@link AttestationEntry#mkUnattestedEntry(long)}.
   * <p>
   * Method under test: {@link AttestationEntry#mkUnattestedEntry(long)}
   */
  @Test
  @DisplayName("Test mkUnattestedEntry(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttestationEntry AttestationEntry.mkUnattestedEntry(long)"})
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
