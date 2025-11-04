package org.finos.waltz.model.scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableCloneScenarioCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableCloneScenarioCommand.Builder#from(CloneScenarioCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCloneScenarioCommand.Builder builderResult = ImmutableCloneScenarioCommand.builder();
    CloneScenarioCommand instance = mock(CloneScenarioCommand.class);
    when(instance.newName()).thenReturn("New Name");
    when(instance.userId()).thenReturn("42");
    when(instance.scenarioId()).thenReturn(1L);

    // Act
    ImmutableCloneScenarioCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newName();
    verify(instance).scenarioId();
    verify(instance).userId();
    ImmutableCloneScenarioCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals("New Name", buildResult.newName());
    assertEquals(1L, buildResult.scenarioId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCloneScenarioCommand.Builder#from(CloneScenarioCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCloneScenarioCommand.Builder builderResult = ImmutableCloneScenarioCommand.builder();
    CloneScenarioCommand instance = mock(CloneScenarioCommand.class);
    when(instance.newName()).thenThrow(new IllegalStateException("instance"));
    when(instance.userId()).thenReturn("42");
    when(instance.scenarioId()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).newName();
    verify(instance).scenarioId();
    verify(instance).userId();
  }

  /**
   * Method under test:
   * {@link ImmutableCloneScenarioCommand.Builder#newName(String)}
   */
  @Test
  void testBuilderNewName() {
    // Arrange
    ImmutableCloneScenarioCommand.Builder builderResult = ImmutableCloneScenarioCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.newName("New Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableCloneScenarioCommand.Builder#scenarioId(long)}
   */
  @Test
  void testBuilderScenarioId() {
    // Arrange
    ImmutableCloneScenarioCommand.Builder builderResult = ImmutableCloneScenarioCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scenarioId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableCloneScenarioCommand.Builder#userId(String)}
   */
  @Test
  void testBuilderUserId() {
    // Arrange
    ImmutableCloneScenarioCommand.Builder builderResult = ImmutableCloneScenarioCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableCloneScenarioCommand#copyOf(CloneScenarioCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CloneScenarioCommand instance = mock(CloneScenarioCommand.class);
    when(instance.newName()).thenReturn("New Name");
    when(instance.userId()).thenReturn("42");
    when(instance.scenarioId()).thenReturn(1L);

    // Act
    ImmutableCloneScenarioCommand actualCopyOfResult = ImmutableCloneScenarioCommand.copyOf(instance);

    // Assert
    verify(instance).newName();
    verify(instance).scenarioId();
    verify(instance).userId();
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("New Name", actualCopyOfResult.newName());
    assertEquals(1L, actualCopyOfResult.scenarioId());
  }
}
