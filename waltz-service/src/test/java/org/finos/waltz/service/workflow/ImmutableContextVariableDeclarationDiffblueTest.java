package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableContextVariableDeclarationDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableContextVariableDeclaration.Builder#from(ContextVariableDeclaration)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableContextVariableDeclaration.Builder builderResult = ImmutableContextVariableDeclaration.builder();
    ContextVariableDeclaration instance = mock(ContextVariableDeclaration.class);
    when(instance.ref()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
    verify(instance).ref();
  }

  /**
   * Method under test:
   * {@link ImmutableContextVariableDeclaration.Builder#from(ContextVariableDeclaration)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableContextVariableDeclaration.Builder builderResult = ImmutableContextVariableDeclaration.builder();
    ContextVariableDeclaration instance = mock(ContextVariableDeclaration.class);
    when(instance.ref()).thenReturn(mock(ContextVariableReference.class));
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableContextVariableDeclaration.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    verify(instance).ref();
    assertEquals("Name", actualFromResult.build().name());
    assertEquals("Name", builderResult.build().name());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableContextVariableDeclaration.Builder#from(ContextVariableDeclaration)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableContextVariableDeclaration.Builder builderResult = ImmutableContextVariableDeclaration.builder();
    ContextVariableDeclaration instance = mock(ContextVariableDeclaration.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableContextVariableDeclaration.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableContextVariableDeclaration.Builder builderResult = ImmutableContextVariableDeclaration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableContextVariableDeclaration.Builder#ref(ContextVariableReference)}
   */
  @Test
  void testBuilderRef() {
    // Arrange
    ImmutableContextVariableDeclaration.Builder builderResult = ImmutableContextVariableDeclaration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ref(mock(ContextVariableReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableContextVariableDeclaration#copyOf(ContextVariableDeclaration)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ContextVariableDeclaration instance = mock(ContextVariableDeclaration.class);
    when(instance.ref()).thenReturn(mock(ContextVariableReference.class));
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableContextVariableDeclaration actualCopyOfResult = ImmutableContextVariableDeclaration.copyOf(instance);

    // Assert
    verify(instance).name();
    verify(instance).ref();
    assertEquals("Name", actualCopyOfResult.name());
  }
}
