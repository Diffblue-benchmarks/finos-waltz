package org.finos.waltz.model.process_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagramEntity.Builder;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagramEntity.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableProcessDiagramEntityDiffblueTest {
  /**
   * Test Builder {@link Builder#diagramId(Long)}.
   * <p>
   * Method under test: {@link Builder#diagramId(Long)}
   */
  @Test
  @DisplayName("Test Builder diagramId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.diagramId(Long)"})
  void testBuilderDiagramId() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(1L));
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntity.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(ProcessDiagramEntity)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then builder build Notable.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProcessDiagramEntity)}
   */
  @Test
  @DisplayName("Test Builder from(ProcessDiagramEntity); given 'true'; then builder build Notable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProcessDiagramEntity)"})
  void testBuilderFrom_givenTrue_thenBuilderBuildNotable() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntity.builder();
    ProcessDiagramEntity instance = mock(ProcessDiagramEntity.class);
    when(instance.isNotable()).thenReturn(true);
    when(instance.diagramId()).thenReturn(1L);
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
    Builder builderResult = ImmutableProcessDiagramEntity.builder();

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
  @MethodsUnderTest({"Long Json.diagramId()"})
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
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDiagramId(Long)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDiagramId(Long)",
      "void Json.setEntityReference(EntityReference)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDiagramId(1L);
    actualJson.setEntityReference(null);

    // Assert
    assertEquals(1L, actualJson.diagramId.longValue());
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
