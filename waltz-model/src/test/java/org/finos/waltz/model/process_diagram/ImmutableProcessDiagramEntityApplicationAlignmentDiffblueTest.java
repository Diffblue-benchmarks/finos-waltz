package org.finos.waltz.model.process_diagram;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableProcessDiagramEntityApplicationAlignmentDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntityApplicationAlignment.Builder#applicationRef(EntityReference)}
   */
  @Test
  void testBuilderApplicationRef() {
    // Arrange
    ImmutableProcessDiagramEntityApplicationAlignment.Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntityApplicationAlignment.Builder#diagramMeasurableRef(EntityReference)}
   */
  @Test
  void testBuilderDiagramMeasurableRef() {
    // Arrange
    ImmutableProcessDiagramEntityApplicationAlignment.Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramMeasurableRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntityApplicationAlignment.Builder#from(ProcessDiagramEntityApplicationAlignment)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableProcessDiagramEntityApplicationAlignment.Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment
        .builder();
    ProcessDiagramEntityApplicationAlignment instance = mock(ProcessDiagramEntityApplicationAlignment.class);
    when(instance.applicationRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.diagramMeasurableRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).applicationRef();
    verify(instance).diagramMeasurableRef();
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntityApplicationAlignment.Builder#from(ProcessDiagramEntityApplicationAlignment)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableProcessDiagramEntityApplicationAlignment.Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment
        .builder();
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
   * Method under test:
   * {@link ImmutableProcessDiagramEntityApplicationAlignment.Builder#from(ProcessDiagramEntityApplicationAlignment)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableProcessDiagramEntityApplicationAlignment.Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment
        .builder();
    ProcessDiagramEntityApplicationAlignment instance = mock(ProcessDiagramEntityApplicationAlignment.class);
    when(instance.referencedMeasurableRef()).thenReturn(mock(EntityReference.class));
    when(instance.applicationRef()).thenReturn(mock(EntityReference.class));
    when(instance.diagramMeasurableRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableProcessDiagramEntityApplicationAlignment.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationRef();
    verify(instance).diagramMeasurableRef();
    verify(instance).referencedMeasurableRef();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntityApplicationAlignment.Builder#referencedMeasurableRef(EntityReference)}
   */
  @Test
  void testBuilderReferencedMeasurableRef() {
    // Arrange
    ImmutableProcessDiagramEntityApplicationAlignment.Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.referencedMeasurableRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntityApplicationAlignment#copyOf(ProcessDiagramEntityApplicationAlignment)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ProcessDiagramEntityApplicationAlignment instance = mock(ProcessDiagramEntityApplicationAlignment.class);
    when(instance.referencedMeasurableRef()).thenReturn(mock(EntityReference.class));
    when(instance.applicationRef()).thenReturn(mock(EntityReference.class));
    when(instance.diagramMeasurableRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableProcessDiagramEntityApplicationAlignment.copyOf(instance);

    // Assert
    verify(instance).applicationRef();
    verify(instance).diagramMeasurableRef();
    verify(instance).referencedMeasurableRef();
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntityApplicationAlignment#fromJson(ImmutableProcessDiagramEntityApplicationAlignment.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableProcessDiagramEntityApplicationAlignment.Json json = new ImmutableProcessDiagramEntityApplicationAlignment.Json();
    json.setReferencedMeasurableRef(mock(EntityReference.class));
    json.setApplicationRef(mock(EntityReference.class));
    json.setDiagramMeasurableRef(mock(EntityReference.class));

    // Act
    ImmutableProcessDiagramEntityApplicationAlignment actualFromJsonResult = ImmutableProcessDiagramEntityApplicationAlignment
        .fromJson(json);

    // Assert
    EntityReference expectedApplicationRefResult = json.applicationRef;
    assertSame(expectedApplicationRefResult, actualFromJsonResult.applicationRef());
    EntityReference expectedDiagramMeasurableRefResult = json.diagramMeasurableRef;
    assertSame(expectedDiagramMeasurableRefResult, actualFromJsonResult.diagramMeasurableRef());
    EntityReference expectedReferencedMeasurableRefResult = json.referencedMeasurableRef;
    assertSame(expectedReferencedMeasurableRefResult, actualFromJsonResult.referencedMeasurableRef());
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntityApplicationAlignment.Json#applicationRef()}
   */
  @Test
  void testJsonApplicationRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableProcessDiagramEntityApplicationAlignment.Json()).applicationRef());
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntityApplicationAlignment.Json#diagramMeasurableRef()}
   */
  @Test
  void testJsonDiagramMeasurableRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableProcessDiagramEntityApplicationAlignment.Json()).diagramMeasurableRef());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableProcessDiagramEntityApplicationAlignment.Json}
   *   <li>
   * {@link ImmutableProcessDiagramEntityApplicationAlignment.Json#setApplicationRef(EntityReference)}
   *   <li>
   * {@link ImmutableProcessDiagramEntityApplicationAlignment.Json#setDiagramMeasurableRef(EntityReference)}
   *   <li>
   * {@link ImmutableProcessDiagramEntityApplicationAlignment.Json#setReferencedMeasurableRef(EntityReference)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableProcessDiagramEntityApplicationAlignment.Json actualJson = new ImmutableProcessDiagramEntityApplicationAlignment.Json();
    actualJson.setApplicationRef(null);
    actualJson.setDiagramMeasurableRef(null);
    actualJson.setReferencedMeasurableRef(null);

    // Assert
    assertNull(actualJson.applicationRef);
    assertNull(actualJson.diagramMeasurableRef);
    assertNull(actualJson.referencedMeasurableRef);
  }

  /**
   * Method under test:
   * {@link ImmutableProcessDiagramEntityApplicationAlignment.Json#referencedMeasurableRef()}
   */
  @Test
  void testJsonReferencedMeasurableRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableProcessDiagramEntityApplicationAlignment.Json()).referencedMeasurableRef());
  }
}
