package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableUpdateReadOnlyCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableUpdateReadOnlyCommand.Builder#from(UpdateReadOnlyCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUpdateReadOnlyCommand.Builder builderResult = ImmutableUpdateReadOnlyCommand.builder();
    UpdateReadOnlyCommand instance = mock(UpdateReadOnlyCommand.class);
    when(instance.readOnly()).thenReturn(true);

    // Act
    ImmutableUpdateReadOnlyCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).readOnly();
    assertTrue(actualFromResult.build().readOnly());
    assertTrue(builderResult.build().readOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateReadOnlyCommand.Builder#from(UpdateReadOnlyCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUpdateReadOnlyCommand.Builder builderResult = ImmutableUpdateReadOnlyCommand.builder();
    UpdateReadOnlyCommand instance = mock(UpdateReadOnlyCommand.class);
    when(instance.readOnly()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).readOnly();
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateReadOnlyCommand.Builder#readOnly(boolean)}
   */
  @Test
  void testBuilderReadOnly() {
    // Arrange
    ImmutableUpdateReadOnlyCommand.Builder builderResult = ImmutableUpdateReadOnlyCommand.builder();

    // Act
    ImmutableUpdateReadOnlyCommand.Builder actualReadOnlyResult = builderResult.readOnly(true);

    // Assert
    assertTrue(actualReadOnlyResult.build().readOnly());
    assertTrue(builderResult.build().readOnly());
    assertSame(builderResult, actualReadOnlyResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateReadOnlyCommand#copyOf(UpdateReadOnlyCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UpdateReadOnlyCommand instance = mock(UpdateReadOnlyCommand.class);
    when(instance.readOnly()).thenReturn(true);

    // Act
    ImmutableUpdateReadOnlyCommand actualCopyOfResult = ImmutableUpdateReadOnlyCommand.copyOf(instance);

    // Assert
    verify(instance).readOnly();
    assertTrue(actualCopyOfResult.readOnly());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableUpdateReadOnlyCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableUpdateReadOnlyCommand.Json actualJson = new ImmutableUpdateReadOnlyCommand.Json();

    // Assert
    assertFalse(actualJson.readOnly);
    assertFalse(actualJson.readOnlyIsSet);
  }

  /**
   * Method under test: {@link ImmutableUpdateReadOnlyCommand.Json#readOnly()}
   */
  @Test
  void testJsonReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUpdateReadOnlyCommand.Json()).readOnly());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateReadOnlyCommand.Json#setReadOnly(boolean)}
   */
  @Test
  void testJsonSetReadOnly() {
    // Arrange
    ImmutableUpdateReadOnlyCommand.Json json = new ImmutableUpdateReadOnlyCommand.Json();

    // Act
    json.setReadOnly(true);

    // Assert
    assertTrue(json.readOnly);
    assertTrue(json.readOnlyIsSet);
  }
}
