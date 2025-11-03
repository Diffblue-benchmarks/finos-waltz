package org.finos.waltz.model.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InvolvementDiffblueTest {
  /**
   * Test {@link Involvement#mkInvolvement(EntityReference, String, int, String, boolean)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return ReadOnly.</li>
   * </ul>
   * <p>
   * Method under test: {@link Involvement#mkInvolvement(EntityReference, String, int, String, boolean)}
   */
  @Test
  @DisplayName("Test mkInvolvement(EntityReference, String, int, String, boolean); when EntityReference; then return ReadOnly")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Involvement Involvement.mkInvolvement(EntityReference, String, int, String, boolean)"})
  void testMkInvolvement_whenEntityReference_thenReturnReadOnly() {
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
   * Test {@link Involvement#mkInvolvement(EntityReference, String, int, String, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return not ReadOnly.</li>
   * </ul>
   * <p>
   * Method under test: {@link Involvement#mkInvolvement(EntityReference, String, int, String, boolean)}
   */
  @Test
  @DisplayName("Test mkInvolvement(EntityReference, String, int, String, boolean); when 'false'; then return not ReadOnly")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Involvement Involvement.mkInvolvement(EntityReference, String, int, String, boolean)"})
  void testMkInvolvement_whenFalse_thenReturnNotReadOnly() {
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
