package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ContextVariableReferenceDiffblueTest {
  /**
   * Test {@link ContextVariableReference#mkVarRef(EntityKind, String)}.
   *
   * <p>Method under test: {@link ContextVariableReference#mkVarRef(EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkVarRef(EntityKind, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ContextVariableReference ContextVariableReference.mkVarRef(EntityKind, String)"
  })
  void testMkVarRef() {
    // Arrange and Act
    ContextVariableReference actualMkVarRefResult =
        ContextVariableReference.mkVarRef(EntityKind.ALL, "42");

    // Assert
    assertTrue(actualMkVarRefResult instanceof ImmutableContextVariableReference);
    assertEquals("42", actualMkVarRefResult.externalId());
    assertEquals(EntityKind.ALL, actualMkVarRefResult.kind());
  }
}
