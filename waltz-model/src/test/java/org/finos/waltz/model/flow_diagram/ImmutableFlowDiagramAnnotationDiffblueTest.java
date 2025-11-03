package org.finos.waltz.model.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramAnnotation.Builder;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramAnnotation.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowDiagramAnnotationDiffblueTest {
  /**
   * Test Builder {@link Builder#annotationId(String)}.
   * <p>
   * Method under test: {@link Builder#annotationId(String)}
   */
  @Test
  @DisplayName("Test Builder annotationId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.annotationId(String)"})
  void testBuilderAnnotationId() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramAnnotation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.annotationId("42"));
  }

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
    Builder builderResult = ImmutableFlowDiagramAnnotation.builder();

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
    Builder builderResult = ImmutableFlowDiagramAnnotation.builder();
    Optional<Long> diagramId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.diagramId(diagramId));
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
    Builder builderResult = ImmutableFlowDiagramAnnotation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(FlowDiagramAnnotation)}.
   * <p>
   * Method under test: {@link Builder#from(FlowDiagramAnnotation)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDiagramAnnotation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowDiagramAnnotation)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramAnnotation.builder();
    FlowDiagramAnnotation instance = mock(FlowDiagramAnnotation.class);
    when(instance.diagramId()).thenThrow(new IllegalStateException("instance"));
    when(instance.annotationId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).annotationId();
    verify(instance).diagramId();
  }

  /**
   * Test Builder {@link Builder#from(FlowDiagramAnnotation)}.
   * <p>
   * Method under test: {@link Builder#from(FlowDiagramAnnotation)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDiagramAnnotation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowDiagramAnnotation)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramAnnotation.builder();
    FlowDiagramAnnotation instance = mock(FlowDiagramAnnotation.class);
    when(instance.note()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.annotationId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).annotationId();
    verify(instance).diagramId();
    verify(instance).entityReference();
    verify(instance).note();
  }

  /**
   * Test Builder {@link Builder#from(FlowDiagramAnnotation)}.
   * <ul>
   *   <li>Given {@code Note}.</li>
   *   <li>Then builder build annotationId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowDiagramAnnotation)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDiagramAnnotation); given 'Note'; then builder build annotationId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowDiagramAnnotation)"})
  void testBuilderFrom_givenNote_thenBuilderBuildAnnotationIdIs42() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramAnnotation.builder();
    FlowDiagramAnnotation instance = mock(FlowDiagramAnnotation.class);
    when(instance.note()).thenReturn("Note");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.diagramId()).thenReturn(ofResult);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.annotationId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).annotationId();
    verify(instance).diagramId();
    verify(instance).entityReference();
    verify(instance).note();
    ImmutableFlowDiagramAnnotation buildResult = builderResult.build();
    assertEquals("42", buildResult.annotationId());
    assertEquals("Note", buildResult.note());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#note(String)}.
   * <p>
   * Method under test: {@link Builder#note(String)}
   */
  @Test
  @DisplayName("Test Builder note(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.note(String)"})
  void testBuilderNote() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramAnnotation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.note("Note"));
  }

  /**
   * Test Json {@link Json#annotationId()}.
   * <p>
   * Method under test: {@link Json#annotationId()}
   */
  @Test
  @DisplayName("Test Json annotationId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.annotationId()"})
  void testJsonAnnotationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).annotationId());
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
    assertNull(actualJson.annotationId);
    assertNull(actualJson.note);
    assertNull(actualJson.entityReference);
    assertFalse(actualJson.diagramId.isPresent());
  }

  /**
   * Test Json {@link Json#note()}.
   * <p>
   * Method under test: {@link Json#note()}
   */
  @Test
  @DisplayName("Test Json note()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.note()"})
  void testJsonNote() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).note());
  }
}
