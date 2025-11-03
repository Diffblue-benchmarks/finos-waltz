package org.finos.waltz.model.scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.scenario.ImmutableCloneScenarioCommand.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCloneScenarioCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(CloneScenarioCommand)}.
   * <ul>
   *   <li>Given {@code New Name}.</li>
   *   <li>Then builder build userId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CloneScenarioCommand)}
   */
  @Test
  @DisplayName("Test Builder from(CloneScenarioCommand); given 'New Name'; then builder build userId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CloneScenarioCommand)"})
  void testBuilderFrom_givenNewName_thenBuilderBuildUserIdIs42() {
    // Arrange
    Builder builderResult = ImmutableCloneScenarioCommand.builder();
    CloneScenarioCommand instance = mock(CloneScenarioCommand.class);
    when(instance.newName()).thenReturn("New Name");
    when(instance.userId()).thenReturn("42");
    when(instance.scenarioId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(CloneScenarioCommand)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CloneScenarioCommand)}
   */
  @Test
  @DisplayName("Test Builder from(CloneScenarioCommand); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CloneScenarioCommand)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCloneScenarioCommand.builder();
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
   * Test Builder {@link Builder#newName(String)}.
   * <p>
   * Method under test: {@link Builder#newName(String)}
   */
  @Test
  @DisplayName("Test Builder newName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.newName(String)"})
  void testBuilderNewName() {
    // Arrange
    Builder builderResult = ImmutableCloneScenarioCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.newName("New Name"));
  }

  /**
   * Test Builder {@link Builder#scenarioId(long)}.
   * <p>
   * Method under test: {@link Builder#scenarioId(long)}
   */
  @Test
  @DisplayName("Test Builder scenarioId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.scenarioId(long)"})
  void testBuilderScenarioId() {
    // Arrange
    Builder builderResult = ImmutableCloneScenarioCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scenarioId(1L));
  }

  /**
   * Test Builder {@link Builder#userId(String)}.
   * <p>
   * Method under test: {@link Builder#userId(String)}
   */
  @Test
  @DisplayName("Test Builder userId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.userId(String)"})
  void testBuilderUserId() {
    // Arrange
    Builder builderResult = ImmutableCloneScenarioCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
  }
}
