package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.Test;

class ContextVariableReferenceDiffblueTest {
  /**
   * Method under test:
   * {@link ContextVariableReference#mkVarRef(EntityKind, String)}
   */
  @Test
  void testMkVarRef() {
    // Arrange and Act
    ContextVariableReference actualMkVarRefResult = ContextVariableReference.mkVarRef(EntityKind.ALL, "42");

    // Assert
    assertTrue(actualMkVarRefResult instanceof ImmutableContextVariableReference);
    assertEquals("42", actualMkVarRefResult.externalId());
    assertEquals(EntityKind.ALL, actualMkVarRefResult.kind());
  }
}
