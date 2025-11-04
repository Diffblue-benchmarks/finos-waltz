package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.Test;

class ImmutableContextVariableReferenceDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableContextVariableReference.Builder#externalId(String)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableContextVariableReference.Builder builderResult = ImmutableContextVariableReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableContextVariableReference.Builder#from(ContextVariableReference)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableContextVariableReference.Builder builderResult = ImmutableContextVariableReference.builder();
    ContextVariableReference instance = mock(ContextVariableReference.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableContextVariableReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).kind();
    ImmutableContextVariableReference buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableContextVariableReference.Builder#from(ContextVariableReference)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableContextVariableReference.Builder builderResult = ImmutableContextVariableReference.builder();
    ContextVariableReference instance = mock(ContextVariableReference.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableContextVariableReference.Builder#kind(EntityKind)}
   */
  @Test
  void testBuilderKind() {
    // Arrange
    ImmutableContextVariableReference.Builder builderResult = ImmutableContextVariableReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableContextVariableReference#copyOf(ContextVariableReference)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ContextVariableReference instance = mock(ContextVariableReference.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableContextVariableReference actualCopyOfResult = ImmutableContextVariableReference.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).kind();
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }
}
