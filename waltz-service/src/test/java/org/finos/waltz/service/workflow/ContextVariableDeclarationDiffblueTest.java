package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ContextVariableDeclarationDiffblueTest {
  /**
   * Test {@link ContextVariableDeclaration#mkDecl(String, EntityKind, String)} with {@code nicename}, {@code kind}, {@code extId}.
   * <p>
   * Method under test: {@link ContextVariableDeclaration#mkDecl(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkDecl(String, EntityKind, String) with 'nicename', 'kind', 'extId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ContextVariableDeclaration ContextVariableDeclaration.mkDecl(String, EntityKind, String)"})
  void testMkDeclWithNicenameKindExtId() {
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
   * Test {@link ContextVariableDeclaration#mkDecl(String, ContextVariableReference)} with {@code nicename}, {@code ref}.
   * <ul>
   *   <li>Then return {@link ImmutableContextVariableDeclaration}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContextVariableDeclaration#mkDecl(String, ContextVariableReference)}
   */
  @Test
  @DisplayName("Test mkDecl(String, ContextVariableReference) with 'nicename', 'ref'; then return ImmutableContextVariableDeclaration")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ContextVariableDeclaration ContextVariableDeclaration.mkDecl(String, ContextVariableReference)"})
  void testMkDeclWithNicenameRef_thenReturnImmutableContextVariableDeclaration() {
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
