package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;

class ImmutableGenericSelectorDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableGenericSelector.Builder#from(GenericSelector)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableGenericSelector.Builder builderResult = ImmutableGenericSelector.builder();
    GenericSelector instance = mock(GenericSelector.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.selector()).thenReturn(mock(Select.class));

    // Act
    ImmutableGenericSelector.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    verify(instance).selector();
    assertEquals(EntityKind.ALL, actualFromResult.build().kind());
    assertEquals(EntityKind.ALL, builderResult.build().kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableGenericSelector.Builder#from(GenericSelector)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableGenericSelector.Builder builderResult = ImmutableGenericSelector.builder();
    GenericSelector instance = mock(GenericSelector.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));
    when(instance.selector()).thenReturn(mock(Select.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
    verify(instance).selector();
  }

  /**
   * Method under test:
   * {@link ImmutableGenericSelector.Builder#from(GenericSelector)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableGenericSelector.Builder builderResult = ImmutableGenericSelector.builder();
    GenericSelector instance = mock(GenericSelector.class);
    when(instance.selector()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).selector();
  }

  /**
   * Method under test: {@link ImmutableGenericSelector.Builder#kind(EntityKind)}
   */
  @Test
  void testBuilderKind() {
    // Arrange
    ImmutableGenericSelector.Builder builderResult = ImmutableGenericSelector.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutableGenericSelector.Builder#selector(Select)}
   */
  @Test
  void testBuilderSelector() {
    // Arrange
    ImmutableGenericSelector.Builder builderResult = ImmutableGenericSelector.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.selector(mock(Select.class)));
  }

  /**
   * Method under test: {@link ImmutableGenericSelector#copyOf(GenericSelector)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    GenericSelector instance = mock(GenericSelector.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.selector()).thenReturn(mock(Select.class));

    // Act
    ImmutableGenericSelector actualCopyOfResult = ImmutableGenericSelector.copyOf(instance);

    // Assert
    verify(instance).kind();
    verify(instance).selector();
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }
}
