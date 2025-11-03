package org.finos.waltz.model.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramEntity.Builder;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramEntity.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowDiagramEntityDiffblueTest {
  /**
   * Test Builder {@link Builder#diagramId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#diagramId(long)}
   */
  @Test
  @DisplayName("Test Builder diagramId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.diagramId(long)"})
  void testBuilderDiagramIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(1L));
  }

  /**
   * Test Builder {@link Builder#diagramId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#diagramId(Optional)}
   */
  @Test
  @DisplayName("Test Builder diagramId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.diagramId(Optional)"})
  void testBuilderDiagramIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramEntity.builder();
    Optional<Long> diagramId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(diagramId));
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then not builder build Notable.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then not builder build Notable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenNotBuilderBuildNotable() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramEntity.builder();
    EntityReference entityReference = mock(EntityReference.class);

    // Act
    Builder actualEntityReferenceResult = builderResult.entityReference(entityReference);

    // Assert
    ImmutableFlowDiagramEntity buildResult = builderResult.build();
    assertFalse(buildResult.isNotable());
    assertSame(builderResult, actualEntityReferenceResult);
    assertSame(entityReference, buildResult.entityReference());
  }

  /**
   * Test Builder {@link Builder#from(FlowDiagramEntity)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then builder build Notable.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowDiagramEntity)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDiagramEntity); given 'true'; then builder build Notable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowDiagramEntity)"})
  void testBuilderFrom_givenTrue_thenBuilderBuildNotable() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramEntity.builder();
    FlowDiagramEntity instance = mock(FlowDiagramEntity.class);
    when(instance.isNotable()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).diagramId();
    verify(instance).entityReference();
    verify(instance).isNotable();
    assertTrue(builderResult.build().isNotable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#isNotable(boolean)}.
   * <p>
   * Method under test: {@link Builder#isNotable(boolean)}
   */
  @Test
  @DisplayName("Test Builder isNotable(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isNotable(boolean)"})
  void testBuilderIsNotable() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isNotable(true));
  }

  /**
   * Test Json {@link Json#diagramId()}.
   * <p>
   * Method under test: {@link Json#diagramId()}
   */
  @Test
  @DisplayName("Test Json diagramId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.diagramId()"})
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).diagramId());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json {@link Json#isNotable()}.
   * <p>
   * Method under test: {@link Json#isNotable()}
   */
  @Test
  @DisplayName("Test Json isNotable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isNotable()"})
  void testJsonIsNotable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isNotable());
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
    assertNull(actualJson.entityReference);
    assertFalse(actualJson.diagramId.isPresent());
    assertFalse(actualJson.isNotable);
    assertFalse(actualJson.isNotableIsSet);
  }

  /**
   * Test Json {@link Json#setIsNotable(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsNotable(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsNotable(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsNotable(boolean)"})
  void testJsonSetIsNotable() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsNotable(true);

    // Assert
    assertTrue(json.isNotable);
    assertTrue(json.isNotableIsSet);
  }
}
