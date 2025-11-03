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
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowSpecDefinitionChangeCommand.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowSpecDefinitionChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowSpecDefinitionChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(PhysicalFlowSpecDefinitionChangeCommand)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build newSpecDefinitionId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalFlowSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowSpecDefinitionChangeCommand); given one; then builder build newSpecDefinitionId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowSpecDefinitionChangeCommand)"})
  void testBuilderFrom_givenOne_thenBuilderBuildNewSpecDefinitionIdIsOne() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder();
    PhysicalFlowSpecDefinitionChangeCommand instance = mock(PhysicalFlowSpecDefinitionChangeCommand.class);
    when(instance.newSpecDefinitionId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newSpecDefinitionId();
    assertEquals(1L, builderResult.build().newSpecDefinitionId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newSpecDefinitionId(long)}.
   * <p>
   * Method under test: {@link Builder#newSpecDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Builder newSpecDefinitionId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.newSpecDefinitionId(long)"})
  void testBuilderNewSpecDefinitionId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowSpecDefinitionChangeCommand.builder();

    // Act
    Builder actualNewSpecDefinitionIdResult = builderResult.newSpecDefinitionId(1L);

    // Assert
    assertEquals(1L, builderResult.build().newSpecDefinitionId());
    assertSame(builderResult, actualNewSpecDefinitionIdResult);
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
    assertEquals(0L, actualJson.newSpecDefinitionId);
    assertFalse(actualJson.newSpecDefinitionIdIsSet);
  }

  /**
   * Test Json {@link Json#newSpecDefinitionId()}.
   * <p>
   * Method under test: {@link Json#newSpecDefinitionId()}
   */
  @Test
  @DisplayName("Test Json newSpecDefinitionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.newSpecDefinitionId()"})
  void testJsonNewSpecDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).newSpecDefinitionId());
  }

  /**
   * Test Json {@link Json#setNewSpecDefinitionId(long)}.
   * <p>
   * Method under test: {@link Json#setNewSpecDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Json setNewSpecDefinitionId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setNewSpecDefinitionId(long)"})
  void testJsonSetNewSpecDefinitionId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setNewSpecDefinitionId(1L);

    // Assert
    assertEquals(1L, json.newSpecDefinitionId);
    assertTrue(json.newSpecDefinitionIdIsSet);
  }
}
