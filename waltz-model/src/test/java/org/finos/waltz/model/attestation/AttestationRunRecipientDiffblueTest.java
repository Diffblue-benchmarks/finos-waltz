package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AttestationRunRecipientDiffblueTest {
  /**
   * Test {@link AttestationRunRecipient#totalCount()}.
   *
   * <ul>
   *   <li>Then return six.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunRecipient#totalCount()}
   */
  @Test
  @DisplayName("Test totalCount(); then return six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AttestationRunRecipient.totalCount()"})
  void testTotalCount_thenReturnSix() {
    // Arrange, Act and Assert
    assertEquals(
        6L,
        ImmutableAttestationRunRecipient.builder()
            .completedCount(3L)
            .id(1L)
            .pendingCount(3L)
            .userId("42")
            .build()
            .totalCount());
  }
}
