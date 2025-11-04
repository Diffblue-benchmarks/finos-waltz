package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.Test;

class ContextVariableDeclarationDiffblueTest {
  /**
   * Method under test:
   * {@link ContextVariableDeclaration#mkDecl(String, EntityKind, String)}
   */
  @Test
  void testMkDecl() {
    // Arrange and Act
    ContextVariableDeclaration actualMkDeclResult = ContextVariableDeclaration.mkDecl("Nicename", EntityKind.ALL, "42");

    // Assert
    assertTrue(actualMkDeclResult instanceof ImmutableContextVariableDeclaration);
    ContextVariableReference refResult = actualMkDeclResult.ref();
    assertTrue(refResult instanceof ImmutableContextVariableReference);
    assertEquals("42", refResult.externalId());
    assertEquals("Nicename", actualMkDeclResult.name());
    assertEquals(EntityKind.ALL, refResult.kind());
  }

  /**
   * Method under test:
   * {@link ContextVariableDeclaration#mkDecl(String, ContextVariableReference)}
   */
  @Test
  void testMkDecl2() {
    // Arrange
    ContextVariableReference ref = mock(ContextVariableReference.class);

    // Act
    ContextVariableDeclaration actualMkDeclResult = ContextVariableDeclaration.mkDecl("Nicename", ref);

    // Assert
    assertTrue(actualMkDeclResult instanceof ImmutableContextVariableDeclaration);
    assertEquals("Nicename", actualMkDeclResult.name());
    assertSame(ref, actualMkDeclResult.ref());
  }
}
