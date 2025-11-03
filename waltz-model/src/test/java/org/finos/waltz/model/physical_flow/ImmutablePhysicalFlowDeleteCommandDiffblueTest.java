package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowDeleteCommand.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowDeleteCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowDeleteCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#flowId(long)}.
   * <p>
   * Method under test: {@link Builder#flowId(long)}
   */
  @Test
  @DisplayName("Test Builder flowId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.flowId(long)"})
  void testBuilderFlowId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommand.builder();

    // Act
    Builder actualFlowIdResult = builderResult.flowId(1L);

    // Assert
    assertEquals(1L, builderResult.build().flowId());
    assertSame(builderResult, actualFlowIdResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowDeleteCommand)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build flowId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowDeleteCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowDeleteCommand); given one; then builder build flowId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowDeleteCommand)"})
  void testBuilderFrom_givenOne_thenBuilderBuildFlowIdIsOne() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowDeleteCommand.builder();
    PhysicalFlowDeleteCommand instance = mock(PhysicalFlowDeleteCommand.class);
    when(instance.flowId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).flowId();
    assertEquals(1L, builderResult.build().flowId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Json {@link Json#flowId()}.
   * <p>
   * Method under test: {@link Json#flowId()}
   */
  @Test
  @DisplayName("Test Json flowId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.flowId()"})
  void testJsonFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).flowId());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertEquals(0L, actualJson.flowId);
    assertFalse(actualJson.flowIdIsSet);
  }

  /**
   * Test Json {@link Json#setFlowId(long)}.
   * <p>
   * Method under test: {@link Json#setFlowId(long)}
   */
  @Test
  @DisplayName("Test Json setFlowId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setFlowId(long)"})
  void testJsonSetFlowId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setFlowId(1L);

    // Assert
    assertEquals(1L, json.flowId);
    assertTrue(json.flowIdIsSet);
  }
}
