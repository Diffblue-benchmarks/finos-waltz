package org.finos.waltz.model.process_diagram;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagramEntityApplicationAlignment.Builder;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagramEntityApplicationAlignment.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableProcessDiagramEntityApplicationAlignmentDiffblueTest {
  /**
   * Test Builder {@link Builder#applicationRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#applicationRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder applicationRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicationRef(EntityReference)"})
  void testBuilderApplicationRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationRef(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#diagramMeasurableRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#diagramMeasurableRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder diagramMeasurableRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.diagramMeasurableRef(EntityReference)"})
  void testBuilderDiagramMeasurableRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramMeasurableRef(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(ProcessDiagramEntityApplicationAlignment)}.
   * <p>
   * Method under test: {@link Builder#from(ProcessDiagramEntityApplicationAlignment)}
   */
  @Test
  @DisplayName("Test Builder from(ProcessDiagramEntityApplicationAlignment)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProcessDiagramEntityApplicationAlignment)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();
    ProcessDiagramEntityApplicationAlignment instance = mock(ProcessDiagramEntityApplicationAlignment.class);
    when(instance.applicationRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.diagramMeasurableRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).applicationRef();
    verify(instance).diagramMeasurableRef();
  }

  /**
   * Test Builder {@link Builder#from(ProcessDiagramEntityApplicationAlignment)}.
   * <p>
   * Method under test: {@link Builder#from(ProcessDiagramEntityApplicationAlignment)}
   */
  @Test
  @DisplayName("Test Builder from(ProcessDiagramEntityApplicationAlignment)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProcessDiagramEntityApplicationAlignment)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();
    ProcessDiagramEntityApplicationAlignment instance = mock(ProcessDiagramEntityApplicationAlignment.class);
    when(instance.referencedMeasurableRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.applicationRef()).thenReturn(mock(EntityReference.class));
    when(instance.diagramMeasurableRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).applicationRef();
    verify(instance).diagramMeasurableRef();
    verify(instance).referencedMeasurableRef();
  }

  /**
   * Test Builder {@link Builder#from(ProcessDiagramEntityApplicationAlignment)}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProcessDiagramEntityApplicationAlignment)}
   */
  @Test
  @DisplayName("Test Builder from(ProcessDiagramEntityApplicationAlignment); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProcessDiagramEntityApplicationAlignment)"})
  void testBuilderFrom_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();
    ProcessDiagramEntityApplicationAlignment instance = mock(ProcessDiagramEntityApplicationAlignment.class);
    when(instance.referencedMeasurableRef()).thenReturn(mock(EntityReference.class));
    when(instance.applicationRef()).thenReturn(mock(EntityReference.class));
    when(instance.diagramMeasurableRef()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationRef();
    verify(instance).diagramMeasurableRef();
    verify(instance).referencedMeasurableRef();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#referencedMeasurableRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#referencedMeasurableRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder referencedMeasurableRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.referencedMeasurableRef(EntityReference)"})
  void testBuilderReferencedMeasurableRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.referencedMeasurableRef(mock(EntityReference.class)));
  }

  /**
   * Test Json {@link Json#applicationRef()}.
   * <p>
   * Method under test: {@link Json#applicationRef()}
   */
  @Test
  @DisplayName("Test Json applicationRef()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.applicationRef()"})
  void testJsonApplicationRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).applicationRef());
  }

  /**
   * Test Json {@link Json#diagramMeasurableRef()}.
   * <p>
   * Method under test: {@link Json#diagramMeasurableRef()}
   */
  @Test
  @DisplayName("Test Json diagramMeasurableRef()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.diagramMeasurableRef()"})
  void testJsonDiagramMeasurableRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).diagramMeasurableRef());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setApplicationRef(EntityReference)}
   *   <li>{@link Json#setDiagramMeasurableRef(EntityReference)}
   *   <li>{@link Json#setReferencedMeasurableRef(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setApplicationRef(EntityReference)",
      "void Json.setDiagramMeasurableRef(EntityReference)", "void Json.setReferencedMeasurableRef(EntityReference)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setApplicationRef(null);
    actualJson.setDiagramMeasurableRef(null);
    actualJson.setReferencedMeasurableRef(null);

    // Assert
    assertNull(actualJson.applicationRef);
    assertNull(actualJson.diagramMeasurableRef);
    assertNull(actualJson.referencedMeasurableRef);
  }

  /**
   * Test Json {@link Json#referencedMeasurableRef()}.
   * <p>
   * Method under test: {@link Json#referencedMeasurableRef()}
   */
  @Test
  @DisplayName("Test Json referencedMeasurableRef()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.referencedMeasurableRef()"})
  void testJsonReferencedMeasurableRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).referencedMeasurableRef());
  }
}
