package org.finos.waltz.model.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class InvolvementDiffblueTest {
  /**
   * Method under test:
   * {@link Involvement#mkInvolvement(EntityReference, String, int, String, boolean)}
   */
  @Test
  void testMkInvolvement() {
    // Arrange
    EntityReference entityRef = mock(EntityReference.class);

    // Act
    Involvement actualMkInvolvementResult = Involvement.mkInvolvement(entityRef, "42", 1, "Provenance", true);

    // Assert
    assertTrue(actualMkInvolvementResult instanceof ImmutableInvolvement);
    assertEquals("42", actualMkInvolvementResult.employeeId());
    assertEquals("Provenance", actualMkInvolvementResult.provenance());
    assertEquals(1L, actualMkInvolvementResult.kindId());
    assertTrue(actualMkInvolvementResult.isReadOnly());
    assertSame(entityRef, actualMkInvolvementResult.entityReference());
  }

  /**
   * Method under test:
   * {@link Involvement#mkInvolvement(EntityReference, String, int, String, boolean)}
   */
  @Test
  void testMkInvolvement2() {
    // Arrange
    EntityReference entityRef = mock(EntityReference.class);

    // Act
    Involvement actualMkInvolvementResult = Involvement.mkInvolvement(entityRef, "42", 1, "Provenance", false);

    // Assert
    assertTrue(actualMkInvolvementResult instanceof ImmutableInvolvement);
    assertEquals("42", actualMkInvolvementResult.employeeId());
    assertEquals("Provenance", actualMkInvolvementResult.provenance());
    assertEquals(1L, actualMkInvolvementResult.kindId());
    assertFalse(actualMkInvolvementResult.isReadOnly());
    assertSame(entityRef, actualMkInvolvementResult.entityReference());
  }
}
