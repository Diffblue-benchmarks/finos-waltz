package org.finos.waltz.model.process_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagramAndEntities.Builder;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagramAndEntities.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableProcessDiagramAndEntitiesDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllEntities(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllEntities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllEntities(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllEntities(Iterable)"})
  void testBuilderAddAllEntities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntities(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addEntities(ProcessDiagramEntity)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableProcessDiagramEntity.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addEntities(ProcessDiagramEntity)}
   */
  @Test
  @DisplayName("Test Builder addEntities(ProcessDiagramEntity) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addEntities(ProcessDiagramEntity)"})
  void testBuilderAddEntitiesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntities(new ImmutableProcessDiagramEntity.Json()));
  }

  /**
   * Test Builder {@link Builder#addEntities(ProcessDiagramEntity[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableProcessDiagramEntity.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addEntities(ProcessDiagramEntity[])}
   */
  @Test
  @DisplayName("Test Builder addEntities(ProcessDiagramEntity[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addEntities(ProcessDiagramEntity[])"})
  void testBuilderAddEntitiesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntities(new ImmutableProcessDiagramEntity.Json()));
  }

  /**
   * Test Builder {@link Builder#diagram(ProcessDiagram)}.
   * <ul>
   *   <li>When {@link ImmutableProcessDiagram.Json} (default constructor).</li>
   *   <li>Then builder build diagram is {@link ImmutableProcessDiagram.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#diagram(ProcessDiagram)}
   */
  @Test
  @DisplayName("Test Builder diagram(ProcessDiagram); when Json (default constructor); then builder build diagram is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.diagram(ProcessDiagram)"})
  void testBuilderDiagram_whenJson_thenBuilderBuildDiagramIsJson() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();
    ImmutableProcessDiagram.Json diagram = new ImmutableProcessDiagram.Json();

    // Act
    Builder actualDiagramResult = builderResult.diagram(diagram);

    // Assert
    assertSame(diagram, builderResult.build().diagram());
    assertSame(builderResult, actualDiagramResult);
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entities(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entities(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(ProcessDiagramAndEntities)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableProcessDiagramEntity.Json} (default constructor).</li>
   *   <li>Then return build entities size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProcessDiagramAndEntities)}
   */
  @Test
  @DisplayName("Test Builder from(ProcessDiagramAndEntities); given HashSet() add Json (default constructor); then return build entities size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProcessDiagramAndEntities)"})
  void testBuilderFrom_givenHashSetAddJson_thenReturnBuildEntitiesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();

    HashSet<ProcessDiagramEntity> processDiagramEntitySet = new HashSet<>();
    processDiagramEntitySet.add(new ImmutableProcessDiagramEntity.Json());
    ProcessDiagramAndEntities instance = mock(ProcessDiagramAndEntities.class);
    when(instance.entities()).thenReturn(processDiagramEntitySet);
    when(instance.diagram()).thenReturn(new ImmutableProcessDiagram.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).diagram();
    verify(instance).entities();
    assertEquals(1, actualFromResult.build().entities().size());
    assertEquals(1, builderResult.build().entities().size());
  }

  /**
   * Test Builder {@link Builder#from(ProcessDiagramAndEntities)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build diagram is {@link ImmutableProcessDiagram.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProcessDiagramAndEntities)}
   */
  @Test
  @DisplayName("Test Builder from(ProcessDiagramAndEntities); given HashSet(); then builder build diagram is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProcessDiagramAndEntities)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildDiagramIsJson() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();
    ProcessDiagramAndEntities instance = mock(ProcessDiagramAndEntities.class);
    when(instance.entities()).thenReturn(new HashSet<>());
    ImmutableProcessDiagram.Json json = new ImmutableProcessDiagram.Json();
    when(instance.diagram()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).diagram();
    verify(instance).entities();
    assertSame(json, builderResult.build().diagram());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProcessDiagramAndEntities)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProcessDiagramAndEntities)}
   */
  @Test
  @DisplayName("Test Builder from(ProcessDiagramAndEntities); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProcessDiagramAndEntities)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramAndEntities.builder();
    ProcessDiagramAndEntities instance = mock(ProcessDiagramAndEntities.class);
    when(instance.entities()).thenThrow(new IllegalStateException("instance"));
    when(instance.diagram()).thenReturn(new ImmutableProcessDiagram.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).diagram();
    verify(instance).entities();
  }

  /**
   * Test Json {@link Json#diagram()}.
   * <p>
   * Method under test: {@link Json#diagram()}
   */
  @Test
  @DisplayName("Test Json diagram()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProcessDiagram Json.diagram()"})
  void testJsonDiagram() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).diagram());
  }

  /**
   * Test Json {@link Json#entities()}.
   * <p>
   * Method under test: {@link Json#entities()}
   */
  @Test
  @DisplayName("Test Json entities()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.entities()"})
  void testJsonEntities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entities());
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
    assertNull(actualJson.diagram);
    assertTrue(actualJson.entities.isEmpty());
  }
}
