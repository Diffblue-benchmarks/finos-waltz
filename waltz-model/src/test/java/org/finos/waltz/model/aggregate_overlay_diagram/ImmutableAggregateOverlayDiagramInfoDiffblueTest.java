package org.finos.waltz.model.aggregate_overlay_diagram;

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
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramInfo.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAggregateOverlayDiagramInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllBackingEntities(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllBackingEntities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllBackingEntities(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllBackingEntities(Iterable)"})
  void testBuilderAddAllBackingEntities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllBackingEntities(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addBackingEntities(BackingEntity)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableBackingEntity.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addBackingEntities(BackingEntity)}
   */
  @Test
  @DisplayName("Test Builder addBackingEntities(BackingEntity) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addBackingEntities(BackingEntity)"})
  void testBuilderAddBackingEntitiesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addBackingEntities(new ImmutableBackingEntity.Json()));
  }

  /**
   * Test Builder {@link Builder#addBackingEntities(BackingEntity[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableBackingEntity.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addBackingEntities(BackingEntity[])}
   */
  @Test
  @DisplayName("Test Builder addBackingEntities(BackingEntity[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addBackingEntities(BackingEntity[])"})
  void testBuilderAddBackingEntitiesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addBackingEntities(new ImmutableBackingEntity.Json()));
  }

  /**
   * Test Builder {@link Builder#backingEntities(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#backingEntities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder backingEntities(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.backingEntities(Iterable)"})
  void testBuilderBackingEntities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.backingEntities(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#diagram(AggregateOverlayDiagram)}.
   * <ul>
   *   <li>When {@link ImmutableAggregateOverlayDiagram.Json} (default constructor).</li>
   *   <li>Then builder build diagram is {@link ImmutableAggregateOverlayDiagram.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#diagram(AggregateOverlayDiagram)}
   */
  @Test
  @DisplayName("Test Builder diagram(AggregateOverlayDiagram); when Json (default constructor); then builder build diagram is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.diagram(AggregateOverlayDiagram)"})
  void testBuilderDiagram_whenJson_thenBuilderBuildDiagramIsJson() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();
    ImmutableAggregateOverlayDiagram.Json diagram = new ImmutableAggregateOverlayDiagram.Json();

    // Act
    Builder actualDiagramResult = builderResult.diagram(diagram);

    // Assert
    assertSame(diagram, builderResult.build().diagram());
    assertSame(builderResult, actualDiagramResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregateOverlayDiagramInfo)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableBackingEntity.Json} (default constructor).</li>
   *   <li>Then return build backingEntities size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AggregateOverlayDiagramInfo)}
   */
  @Test
  @DisplayName("Test Builder from(AggregateOverlayDiagramInfo); given HashSet() add Json (default constructor); then return build backingEntities size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AggregateOverlayDiagramInfo)"})
  void testBuilderFrom_givenHashSetAddJson_thenReturnBuildBackingEntitiesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();

    HashSet<BackingEntity> backingEntitySet = new HashSet<>();
    backingEntitySet.add(new ImmutableBackingEntity.Json());
    AggregateOverlayDiagramInfo instance = mock(AggregateOverlayDiagramInfo.class);
    when(instance.backingEntities()).thenReturn(backingEntitySet);
    when(instance.diagram()).thenReturn(new ImmutableAggregateOverlayDiagram.Json());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).backingEntities();
    verify(instance).diagram();
    assertEquals(1, actualFromResult.build().backingEntities().size());
    assertEquals(1, builderResult.build().backingEntities().size());
  }

  /**
   * Test Builder {@link Builder#from(AggregateOverlayDiagramInfo)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build diagram is {@link ImmutableAggregateOverlayDiagram.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AggregateOverlayDiagramInfo)}
   */
  @Test
  @DisplayName("Test Builder from(AggregateOverlayDiagramInfo); given HashSet(); then builder build diagram is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AggregateOverlayDiagramInfo)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildDiagramIsJson() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();
    AggregateOverlayDiagramInfo instance = mock(AggregateOverlayDiagramInfo.class);
    when(instance.backingEntities()).thenReturn(new HashSet<>());
    ImmutableAggregateOverlayDiagram.Json json = new ImmutableAggregateOverlayDiagram.Json();
    when(instance.diagram()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).backingEntities();
    verify(instance).diagram();
    assertSame(json, builderResult.build().diagram());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregateOverlayDiagramInfo)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AggregateOverlayDiagramInfo)}
   */
  @Test
  @DisplayName("Test Builder from(AggregateOverlayDiagramInfo); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AggregateOverlayDiagramInfo)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramInfo.builder();
    AggregateOverlayDiagramInfo instance = mock(AggregateOverlayDiagramInfo.class);
    when(instance.backingEntities()).thenThrow(new IllegalStateException("instance"));
    when(instance.diagram()).thenReturn(new ImmutableAggregateOverlayDiagram.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).backingEntities();
    verify(instance).diagram();
  }

  /**
   * Test Json {@link Json#backingEntities()}.
   * <p>
   * Method under test: {@link Json#backingEntities()}
   */
  @Test
  @DisplayName("Test Json backingEntities()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.backingEntities()"})
  void testJsonBackingEntities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).backingEntities());
  }

  /**
   * Test Json {@link Json#diagram()}.
   * <p>
   * Method under test: {@link Json#diagram()}
   */
  @Test
  @DisplayName("Test Json diagram()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AggregateOverlayDiagram Json.diagram()"})
  void testJsonDiagram() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).diagram());
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
    assertTrue(actualJson.backingEntities.isEmpty());
  }
}
