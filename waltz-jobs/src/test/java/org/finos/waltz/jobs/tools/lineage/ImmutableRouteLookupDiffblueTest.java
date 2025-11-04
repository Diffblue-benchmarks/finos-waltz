package org.finos.waltz.jobs.tools.lineage;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.GraphType;
import org.jgrapht.graph.AsGraphUnion;
import org.jgrapht.graph.GraphWalk;
import org.jgrapht.util.WeightCombiner;
import org.jooq.lambda.tuple.Tuple2;
import org.jooq.lambda.tuple.Tuple3;
import org.junit.jupiter.api.Test;

class ImmutableRouteLookupDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#addAllProcessingMessages(Iterable)}
   */
  @Test
  void testBuilderAddAllProcessingMessages() {
    // Arrange
    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllProcessingMessages(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#addAllProcessingMessages(Iterable)}
   */
  @Test
  void testBuilderAddAllProcessingMessages2() {
    // Arrange
    GraphType graphType = mock(GraphType.class);
    when(graphType.isAllowingSelfLoops()).thenReturn(true);
    when(graphType.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g1 = mock(Graph.class);
    when(g1.getType()).thenReturn(graphType);
    GraphType graphType2 = mock(GraphType.class);
    when(graphType2.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g2 = mock(Graph.class);
    when(g2.getType()).thenReturn(graphType2);
    AsGraphUnion<EntityReference, DataTypeEdge> g12 = new AsGraphUnion<>(g1, g2, mock(WeightCombiner.class));

    GraphType graphType3 = mock(GraphType.class);
    when(graphType3.isAllowingSelfLoops()).thenReturn(true);
    when(graphType3.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g13 = mock(Graph.class);
    when(g13.getType()).thenReturn(graphType3);
    GraphType graphType4 = mock(GraphType.class);
    when(graphType4.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g22 = mock(Graph.class);
    when(g22.getType()).thenReturn(graphType4);
    AsGraphUnion<EntityReference, DataTypeEdge> asGraphUnion = new AsGraphUnion<>(g12,
        new AsGraphUnion<>(g13, g22, mock(WeightCombiner.class)));

    GraphType graphType5 = mock(GraphType.class);
    when(graphType5.isAllowingSelfLoops()).thenReturn(true);
    when(graphType5.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g14 = mock(Graph.class);
    when(g14.getType()).thenReturn(graphType5);
    GraphType graphType6 = mock(GraphType.class);
    when(graphType6.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g23 = mock(Graph.class);
    when(g23.getType()).thenReturn(graphType6);
    AsGraphUnion<EntityReference, DataTypeEdge> graph = new AsGraphUnion<>(g14, g23);

    Tuple3<String, Graph<EntityReference, DataTypeEdge>, GraphPath<EntityReference, DataTypeEdge>> element = new Tuple3<>(
        "V1", asGraphUnion, new GraphWalk<>(graph, new ArrayList<>(), 10.0d));

    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();
    builderResult.addStrictRoutes(element);

    // Act
    ImmutableRouteLookup.Builder actualAddAllProcessingMessagesResult = builderResult
        .addAllProcessingMessages(new ArrayList<>());

    // Assert
    verify(g1, atLeast(1)).getType();
    verify(g2, atLeast(1)).getType();
    verify(g13, atLeast(1)).getType();
    verify(g22, atLeast(1)).getType();
    verify(g14, atLeast(1)).getType();
    verify(g23, atLeast(1)).getType();
    verify(graphType).isAllowingSelfLoops();
    verify(graphType3).isAllowingSelfLoops();
    verify(graphType5).isAllowingSelfLoops();
    verify(graphType, atLeast(1)).isDirected();
    verify(graphType2, atLeast(1)).isDirected();
    verify(graphType3, atLeast(1)).isDirected();
    verify(graphType4, atLeast(1)).isDirected();
    verify(graphType5, atLeast(1)).isDirected();
    verify(graphType6, atLeast(1)).isDirected();
    assertSame(builderResult, actualAddAllProcessingMessagesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#addAllProcessingMessages(Iterable)}
   */
  @Test
  void testBuilderAddAllProcessingMessages3() {
    // Arrange
    GraphType graphType = mock(GraphType.class);
    when(graphType.isAllowingSelfLoops()).thenReturn(true);
    when(graphType.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g1 = mock(Graph.class);
    when(g1.getType()).thenReturn(graphType);
    GraphType graphType2 = mock(GraphType.class);
    when(graphType2.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g2 = mock(Graph.class);
    when(g2.getType()).thenReturn(graphType2);
    AsGraphUnion<EntityReference, DataTypeEdge> g12 = new AsGraphUnion<>(g1, g2, mock(WeightCombiner.class));

    GraphType graphType3 = mock(GraphType.class);
    when(graphType3.isAllowingSelfLoops()).thenReturn(true);
    when(graphType3.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g13 = mock(Graph.class);
    when(g13.getType()).thenReturn(graphType3);
    GraphType graphType4 = mock(GraphType.class);
    when(graphType4.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g22 = mock(Graph.class);
    when(g22.getType()).thenReturn(graphType4);
    AsGraphUnion<EntityReference, DataTypeEdge> asGraphUnion = new AsGraphUnion<>(g12,
        new AsGraphUnion<>(g13, g22, mock(WeightCombiner.class)));

    GraphType graphType5 = mock(GraphType.class);
    when(graphType5.isAllowingSelfLoops()).thenReturn(true);
    when(graphType5.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g14 = mock(Graph.class);
    when(g14.getType()).thenReturn(graphType5);
    GraphType graphType6 = mock(GraphType.class);
    when(graphType6.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g23 = mock(Graph.class);
    when(g23.getType()).thenReturn(graphType6);
    AsGraphUnion<EntityReference, DataTypeEdge> graph = new AsGraphUnion<>(g14, g23);

    Tuple3<String, Graph<EntityReference, DataTypeEdge>, GraphPath<EntityReference, DataTypeEdge>> element = new Tuple3<>(
        "V1", asGraphUnion, new GraphWalk<>(graph, new ArrayList<>(), 10.0d));

    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();
    builderResult.addStrictRoutes(element);

    ArrayList<String> elements = new ArrayList<>();
    elements.add("foo");

    // Act
    ImmutableRouteLookup.Builder actualAddAllProcessingMessagesResult = builderResult
        .addAllProcessingMessages(elements);

    // Assert
    verify(g1, atLeast(1)).getType();
    verify(g2, atLeast(1)).getType();
    verify(g13, atLeast(1)).getType();
    verify(g22, atLeast(1)).getType();
    verify(g14, atLeast(1)).getType();
    verify(g23, atLeast(1)).getType();
    verify(graphType).isAllowingSelfLoops();
    verify(graphType3).isAllowingSelfLoops();
    verify(graphType5).isAllowingSelfLoops();
    verify(graphType, atLeast(1)).isDirected();
    verify(graphType2, atLeast(1)).isDirected();
    verify(graphType3, atLeast(1)).isDirected();
    verify(graphType4, atLeast(1)).isDirected();
    verify(graphType5, atLeast(1)).isDirected();
    verify(graphType6, atLeast(1)).isDirected();
    assertSame(builderResult, actualAddAllProcessingMessagesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#addAllProcessingMessages(Iterable)}
   */
  @Test
  void testBuilderAddAllProcessingMessages4() {
    // Arrange
    GraphType graphType = mock(GraphType.class);
    when(graphType.isAllowingSelfLoops()).thenReturn(true);
    when(graphType.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g1 = mock(Graph.class);
    when(g1.getType()).thenReturn(graphType);
    GraphType graphType2 = mock(GraphType.class);
    when(graphType2.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g2 = mock(Graph.class);
    when(g2.getType()).thenReturn(graphType2);
    AsGraphUnion<EntityReference, DataTypeEdge> g12 = new AsGraphUnion<>(g1, g2, mock(WeightCombiner.class));

    GraphType graphType3 = mock(GraphType.class);
    when(graphType3.isAllowingSelfLoops()).thenReturn(true);
    when(graphType3.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g13 = mock(Graph.class);
    when(g13.getType()).thenReturn(graphType3);
    GraphType graphType4 = mock(GraphType.class);
    when(graphType4.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g22 = mock(Graph.class);
    when(g22.getType()).thenReturn(graphType4);
    AsGraphUnion<EntityReference, DataTypeEdge> asGraphUnion = new AsGraphUnion<>(g12,
        new AsGraphUnion<>(g13, g22, mock(WeightCombiner.class)));

    GraphType graphType5 = mock(GraphType.class);
    when(graphType5.isAllowingSelfLoops()).thenReturn(true);
    when(graphType5.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g14 = mock(Graph.class);
    when(g14.getType()).thenReturn(graphType5);
    GraphType graphType6 = mock(GraphType.class);
    when(graphType6.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g23 = mock(Graph.class);
    when(g23.getType()).thenReturn(graphType6);
    AsGraphUnion<EntityReference, DataTypeEdge> graph = new AsGraphUnion<>(g14, g23);

    Tuple3<String, Graph<EntityReference, DataTypeEdge>, GraphPath<EntityReference, DataTypeEdge>> element = new Tuple3<>(
        "V1", asGraphUnion, new GraphWalk<>(graph, new ArrayList<>(), 10.0d));

    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();
    builderResult.addStrictRoutes(element);

    ArrayList<String> elements = new ArrayList<>();
    elements.add("42");
    elements.add("foo");

    // Act
    ImmutableRouteLookup.Builder actualAddAllProcessingMessagesResult = builderResult
        .addAllProcessingMessages(elements);

    // Assert
    verify(g1, atLeast(1)).getType();
    verify(g2, atLeast(1)).getType();
    verify(g13, atLeast(1)).getType();
    verify(g22, atLeast(1)).getType();
    verify(g14, atLeast(1)).getType();
    verify(g23, atLeast(1)).getType();
    verify(graphType).isAllowingSelfLoops();
    verify(graphType3).isAllowingSelfLoops();
    verify(graphType5).isAllowingSelfLoops();
    verify(graphType, atLeast(1)).isDirected();
    verify(graphType2, atLeast(1)).isDirected();
    verify(graphType3, atLeast(1)).isDirected();
    verify(graphType4, atLeast(1)).isDirected();
    verify(graphType5, atLeast(1)).isDirected();
    verify(graphType6, atLeast(1)).isDirected();
    assertSame(builderResult, actualAddAllProcessingMessagesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#addAllStrictRoutes(Iterable)}
   */
  @Test
  void testBuilderAddAllStrictRoutes() {
    // Arrange
    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllStrictRoutes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#addAllStrictRoutes(Iterable)}
   */
  @Test
  void testBuilderAddAllStrictRoutes2() {
    // Arrange
    GraphType graphType = mock(GraphType.class);
    when(graphType.isAllowingSelfLoops()).thenReturn(true);
    when(graphType.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g1 = mock(Graph.class);
    when(g1.getType()).thenReturn(graphType);
    GraphType graphType2 = mock(GraphType.class);
    when(graphType2.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g2 = mock(Graph.class);
    when(g2.getType()).thenReturn(graphType2);
    AsGraphUnion<EntityReference, DataTypeEdge> g12 = new AsGraphUnion<>(g1, g2, mock(WeightCombiner.class));

    GraphType graphType3 = mock(GraphType.class);
    when(graphType3.isAllowingSelfLoops()).thenReturn(true);
    when(graphType3.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g13 = mock(Graph.class);
    when(g13.getType()).thenReturn(graphType3);
    GraphType graphType4 = mock(GraphType.class);
    when(graphType4.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g22 = mock(Graph.class);
    when(g22.getType()).thenReturn(graphType4);
    AsGraphUnion<EntityReference, DataTypeEdge> asGraphUnion = new AsGraphUnion<>(g12,
        new AsGraphUnion<>(g13, g22, mock(WeightCombiner.class)));

    GraphType graphType5 = mock(GraphType.class);
    when(graphType5.isAllowingSelfLoops()).thenReturn(true);
    when(graphType5.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g14 = mock(Graph.class);
    when(g14.getType()).thenReturn(graphType5);
    GraphType graphType6 = mock(GraphType.class);
    when(graphType6.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g23 = mock(Graph.class);
    when(g23.getType()).thenReturn(graphType6);
    AsGraphUnion<EntityReference, DataTypeEdge> graph = new AsGraphUnion<>(g14, g23);

    Tuple3<String, Graph<EntityReference, DataTypeEdge>, GraphPath<EntityReference, DataTypeEdge>> element = new Tuple3<>(
        "V1", asGraphUnion, new GraphWalk<>(graph, new ArrayList<>(), 10.0d));

    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();
    builderResult.addStrictRoutes(element);

    // Act
    ImmutableRouteLookup.Builder actualAddAllStrictRoutesResult = builderResult.addAllStrictRoutes(new ArrayList<>());

    // Assert
    verify(g1, atLeast(1)).getType();
    verify(g2, atLeast(1)).getType();
    verify(g13, atLeast(1)).getType();
    verify(g22, atLeast(1)).getType();
    verify(g14, atLeast(1)).getType();
    verify(g23, atLeast(1)).getType();
    verify(graphType).isAllowingSelfLoops();
    verify(graphType3).isAllowingSelfLoops();
    verify(graphType5).isAllowingSelfLoops();
    verify(graphType, atLeast(1)).isDirected();
    verify(graphType2, atLeast(1)).isDirected();
    verify(graphType3, atLeast(1)).isDirected();
    verify(graphType4, atLeast(1)).isDirected();
    verify(graphType5, atLeast(1)).isDirected();
    verify(graphType6, atLeast(1)).isDirected();
    assertSame(builderResult, actualAddAllStrictRoutesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#addProcessingMessages(String)}
   */
  @Test
  void testBuilderAddProcessingMessages() {
    // Arrange
    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addProcessingMessages("Element"));
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#addProcessingMessages(String)}
   */
  @Test
  void testBuilderAddProcessingMessages2() {
    // Arrange
    GraphType graphType = mock(GraphType.class);
    when(graphType.isAllowingSelfLoops()).thenReturn(true);
    when(graphType.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g1 = mock(Graph.class);
    when(g1.getType()).thenReturn(graphType);
    GraphType graphType2 = mock(GraphType.class);
    when(graphType2.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g2 = mock(Graph.class);
    when(g2.getType()).thenReturn(graphType2);
    AsGraphUnion<EntityReference, DataTypeEdge> g12 = new AsGraphUnion<>(g1, g2, mock(WeightCombiner.class));

    GraphType graphType3 = mock(GraphType.class);
    when(graphType3.isAllowingSelfLoops()).thenReturn(true);
    when(graphType3.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g13 = mock(Graph.class);
    when(g13.getType()).thenReturn(graphType3);
    GraphType graphType4 = mock(GraphType.class);
    when(graphType4.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g22 = mock(Graph.class);
    when(g22.getType()).thenReturn(graphType4);
    AsGraphUnion<EntityReference, DataTypeEdge> asGraphUnion = new AsGraphUnion<>(g12,
        new AsGraphUnion<>(g13, g22, mock(WeightCombiner.class)));

    GraphType graphType5 = mock(GraphType.class);
    when(graphType5.isAllowingSelfLoops()).thenReturn(true);
    when(graphType5.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g14 = mock(Graph.class);
    when(g14.getType()).thenReturn(graphType5);
    GraphType graphType6 = mock(GraphType.class);
    when(graphType6.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g23 = mock(Graph.class);
    when(g23.getType()).thenReturn(graphType6);
    AsGraphUnion<EntityReference, DataTypeEdge> graph = new AsGraphUnion<>(g14, g23);

    Tuple3<String, Graph<EntityReference, DataTypeEdge>, GraphPath<EntityReference, DataTypeEdge>> element = new Tuple3<>(
        "V1", asGraphUnion, new GraphWalk<>(graph, new ArrayList<>(), 10.0d));

    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();
    builderResult.addStrictRoutes(element);

    // Act
    ImmutableRouteLookup.Builder actualAddProcessingMessagesResult = builderResult.addProcessingMessages("Element");

    // Assert
    verify(g1, atLeast(1)).getType();
    verify(g2, atLeast(1)).getType();
    verify(g13, atLeast(1)).getType();
    verify(g22, atLeast(1)).getType();
    verify(g14, atLeast(1)).getType();
    verify(g23, atLeast(1)).getType();
    verify(graphType).isAllowingSelfLoops();
    verify(graphType3).isAllowingSelfLoops();
    verify(graphType5).isAllowingSelfLoops();
    verify(graphType, atLeast(1)).isDirected();
    verify(graphType2, atLeast(1)).isDirected();
    verify(graphType3, atLeast(1)).isDirected();
    verify(graphType4, atLeast(1)).isDirected();
    verify(graphType5, atLeast(1)).isDirected();
    verify(graphType6, atLeast(1)).isDirected();
    assertSame(builderResult, actualAddProcessingMessagesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#addProcessingMessages(String[])}
   */
  @Test
  void testBuilderAddProcessingMessages3() {
    // Arrange
    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addProcessingMessages("Elements"));
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#addProcessingMessages(String[])}
   */
  @Test
  void testBuilderAddProcessingMessages4() {
    // Arrange
    GraphType graphType = mock(GraphType.class);
    when(graphType.isAllowingSelfLoops()).thenReturn(true);
    when(graphType.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g1 = mock(Graph.class);
    when(g1.getType()).thenReturn(graphType);
    GraphType graphType2 = mock(GraphType.class);
    when(graphType2.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g2 = mock(Graph.class);
    when(g2.getType()).thenReturn(graphType2);
    AsGraphUnion<EntityReference, DataTypeEdge> g12 = new AsGraphUnion<>(g1, g2, mock(WeightCombiner.class));

    GraphType graphType3 = mock(GraphType.class);
    when(graphType3.isAllowingSelfLoops()).thenReturn(true);
    when(graphType3.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g13 = mock(Graph.class);
    when(g13.getType()).thenReturn(graphType3);
    GraphType graphType4 = mock(GraphType.class);
    when(graphType4.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g22 = mock(Graph.class);
    when(g22.getType()).thenReturn(graphType4);
    AsGraphUnion<EntityReference, DataTypeEdge> asGraphUnion = new AsGraphUnion<>(g12,
        new AsGraphUnion<>(g13, g22, mock(WeightCombiner.class)));

    GraphType graphType5 = mock(GraphType.class);
    when(graphType5.isAllowingSelfLoops()).thenReturn(true);
    when(graphType5.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g14 = mock(Graph.class);
    when(g14.getType()).thenReturn(graphType5);
    GraphType graphType6 = mock(GraphType.class);
    when(graphType6.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g23 = mock(Graph.class);
    when(g23.getType()).thenReturn(graphType6);
    AsGraphUnion<EntityReference, DataTypeEdge> graph = new AsGraphUnion<>(g14, g23);

    Tuple3<String, Graph<EntityReference, DataTypeEdge>, GraphPath<EntityReference, DataTypeEdge>> element = new Tuple3<>(
        "V1", asGraphUnion, new GraphWalk<>(graph, new ArrayList<>(), 10.0d));

    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();
    builderResult.addStrictRoutes(element);

    // Act
    ImmutableRouteLookup.Builder actualAddProcessingMessagesResult = builderResult.addProcessingMessages("Elements");

    // Assert
    verify(g1, atLeast(1)).getType();
    verify(g2, atLeast(1)).getType();
    verify(g13, atLeast(1)).getType();
    verify(g22, atLeast(1)).getType();
    verify(g14, atLeast(1)).getType();
    verify(g23, atLeast(1)).getType();
    verify(graphType).isAllowingSelfLoops();
    verify(graphType3).isAllowingSelfLoops();
    verify(graphType5).isAllowingSelfLoops();
    verify(graphType, atLeast(1)).isDirected();
    verify(graphType2, atLeast(1)).isDirected();
    verify(graphType3, atLeast(1)).isDirected();
    verify(graphType4, atLeast(1)).isDirected();
    verify(graphType5, atLeast(1)).isDirected();
    verify(graphType6, atLeast(1)).isDirected();
    assertSame(builderResult, actualAddProcessingMessagesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#addStrictRoutes(Tuple3[])}
   */
  @Test
  void testBuilderAddStrictRoutes() {
    // Arrange
    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addStrictRoutes());
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#nonStrictRoute(Optional)}
   */
  @Test
  void testBuilderNonStrictRoute() {
    // Arrange
    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();
    Optional<? extends Tuple2<Graph<EntityReference, DataTypeEdge>, GraphPath<EntityReference, DataTypeEdge>>> nonStrictRoute = Optional
        .empty();

    // Act and Assert
    assertSame(builderResult, builderResult.nonStrictRoute(nonStrictRoute));
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#processingMessages(Iterable)}
   */
  @Test
  void testBuilderProcessingMessages() {
    // Arrange
    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.processingMessages(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#processingMessages(Iterable)}
   */
  @Test
  void testBuilderProcessingMessages2() {
    // Arrange
    GraphType graphType = mock(GraphType.class);
    when(graphType.isAllowingSelfLoops()).thenReturn(true);
    when(graphType.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g1 = mock(Graph.class);
    when(g1.getType()).thenReturn(graphType);
    GraphType graphType2 = mock(GraphType.class);
    when(graphType2.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g2 = mock(Graph.class);
    when(g2.getType()).thenReturn(graphType2);
    AsGraphUnion<EntityReference, DataTypeEdge> g12 = new AsGraphUnion<>(g1, g2, mock(WeightCombiner.class));

    GraphType graphType3 = mock(GraphType.class);
    when(graphType3.isAllowingSelfLoops()).thenReturn(true);
    when(graphType3.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g13 = mock(Graph.class);
    when(g13.getType()).thenReturn(graphType3);
    GraphType graphType4 = mock(GraphType.class);
    when(graphType4.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g22 = mock(Graph.class);
    when(g22.getType()).thenReturn(graphType4);
    AsGraphUnion<EntityReference, DataTypeEdge> asGraphUnion = new AsGraphUnion<>(g12,
        new AsGraphUnion<>(g13, g22, mock(WeightCombiner.class)));

    GraphType graphType5 = mock(GraphType.class);
    when(graphType5.isAllowingSelfLoops()).thenReturn(true);
    when(graphType5.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g14 = mock(Graph.class);
    when(g14.getType()).thenReturn(graphType5);
    GraphType graphType6 = mock(GraphType.class);
    when(graphType6.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g23 = mock(Graph.class);
    when(g23.getType()).thenReturn(graphType6);
    AsGraphUnion<EntityReference, DataTypeEdge> graph = new AsGraphUnion<>(g14, g23);

    Tuple3<String, Graph<EntityReference, DataTypeEdge>, GraphPath<EntityReference, DataTypeEdge>> element = new Tuple3<>(
        "V1", asGraphUnion, new GraphWalk<>(graph, new ArrayList<>(), 10.0d));

    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();
    builderResult.addStrictRoutes(element);

    // Act
    ImmutableRouteLookup.Builder actualProcessingMessagesResult = builderResult.processingMessages(new ArrayList<>());

    // Assert
    verify(g1, atLeast(1)).getType();
    verify(g2, atLeast(1)).getType();
    verify(g13, atLeast(1)).getType();
    verify(g22, atLeast(1)).getType();
    verify(g14, atLeast(1)).getType();
    verify(g23, atLeast(1)).getType();
    verify(graphType).isAllowingSelfLoops();
    verify(graphType3).isAllowingSelfLoops();
    verify(graphType5).isAllowingSelfLoops();
    verify(graphType, atLeast(1)).isDirected();
    verify(graphType2, atLeast(1)).isDirected();
    verify(graphType3, atLeast(1)).isDirected();
    verify(graphType4, atLeast(1)).isDirected();
    verify(graphType5, atLeast(1)).isDirected();
    verify(graphType6, atLeast(1)).isDirected();
    assertSame(builderResult, actualProcessingMessagesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#processingMessages(Iterable)}
   */
  @Test
  void testBuilderProcessingMessages3() {
    // Arrange
    GraphType graphType = mock(GraphType.class);
    when(graphType.isAllowingSelfLoops()).thenReturn(true);
    when(graphType.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g1 = mock(Graph.class);
    when(g1.getType()).thenReturn(graphType);
    GraphType graphType2 = mock(GraphType.class);
    when(graphType2.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g2 = mock(Graph.class);
    when(g2.getType()).thenReturn(graphType2);
    AsGraphUnion<EntityReference, DataTypeEdge> g12 = new AsGraphUnion<>(g1, g2, mock(WeightCombiner.class));

    GraphType graphType3 = mock(GraphType.class);
    when(graphType3.isAllowingSelfLoops()).thenReturn(true);
    when(graphType3.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g13 = mock(Graph.class);
    when(g13.getType()).thenReturn(graphType3);
    GraphType graphType4 = mock(GraphType.class);
    when(graphType4.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g22 = mock(Graph.class);
    when(g22.getType()).thenReturn(graphType4);
    AsGraphUnion<EntityReference, DataTypeEdge> asGraphUnion = new AsGraphUnion<>(g12,
        new AsGraphUnion<>(g13, g22, mock(WeightCombiner.class)));

    GraphType graphType5 = mock(GraphType.class);
    when(graphType5.isAllowingSelfLoops()).thenReturn(true);
    when(graphType5.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g14 = mock(Graph.class);
    when(g14.getType()).thenReturn(graphType5);
    GraphType graphType6 = mock(GraphType.class);
    when(graphType6.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g23 = mock(Graph.class);
    when(g23.getType()).thenReturn(graphType6);
    AsGraphUnion<EntityReference, DataTypeEdge> graph = new AsGraphUnion<>(g14, g23);

    Tuple3<String, Graph<EntityReference, DataTypeEdge>, GraphPath<EntityReference, DataTypeEdge>> element = new Tuple3<>(
        "V1", asGraphUnion, new GraphWalk<>(graph, new ArrayList<>(), 10.0d));

    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();
    builderResult.addStrictRoutes(element);

    ArrayList<String> elements = new ArrayList<>();
    elements.add("foo");

    // Act
    ImmutableRouteLookup.Builder actualProcessingMessagesResult = builderResult.processingMessages(elements);

    // Assert
    verify(g1, atLeast(1)).getType();
    verify(g2, atLeast(1)).getType();
    verify(g13, atLeast(1)).getType();
    verify(g22, atLeast(1)).getType();
    verify(g14, atLeast(1)).getType();
    verify(g23, atLeast(1)).getType();
    verify(graphType).isAllowingSelfLoops();
    verify(graphType3).isAllowingSelfLoops();
    verify(graphType5).isAllowingSelfLoops();
    verify(graphType, atLeast(1)).isDirected();
    verify(graphType2, atLeast(1)).isDirected();
    verify(graphType3, atLeast(1)).isDirected();
    verify(graphType4, atLeast(1)).isDirected();
    verify(graphType5, atLeast(1)).isDirected();
    verify(graphType6, atLeast(1)).isDirected();
    assertSame(builderResult, actualProcessingMessagesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#processingMessages(Iterable)}
   */
  @Test
  void testBuilderProcessingMessages4() {
    // Arrange
    GraphType graphType = mock(GraphType.class);
    when(graphType.isAllowingSelfLoops()).thenReturn(true);
    when(graphType.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g1 = mock(Graph.class);
    when(g1.getType()).thenReturn(graphType);
    GraphType graphType2 = mock(GraphType.class);
    when(graphType2.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g2 = mock(Graph.class);
    when(g2.getType()).thenReturn(graphType2);
    AsGraphUnion<EntityReference, DataTypeEdge> g12 = new AsGraphUnion<>(g1, g2, mock(WeightCombiner.class));

    GraphType graphType3 = mock(GraphType.class);
    when(graphType3.isAllowingSelfLoops()).thenReturn(true);
    when(graphType3.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g13 = mock(Graph.class);
    when(g13.getType()).thenReturn(graphType3);
    GraphType graphType4 = mock(GraphType.class);
    when(graphType4.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g22 = mock(Graph.class);
    when(g22.getType()).thenReturn(graphType4);
    AsGraphUnion<EntityReference, DataTypeEdge> asGraphUnion = new AsGraphUnion<>(g12,
        new AsGraphUnion<>(g13, g22, mock(WeightCombiner.class)));

    GraphType graphType5 = mock(GraphType.class);
    when(graphType5.isAllowingSelfLoops()).thenReturn(true);
    when(graphType5.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g14 = mock(Graph.class);
    when(g14.getType()).thenReturn(graphType5);
    GraphType graphType6 = mock(GraphType.class);
    when(graphType6.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g23 = mock(Graph.class);
    when(g23.getType()).thenReturn(graphType6);
    AsGraphUnion<EntityReference, DataTypeEdge> graph = new AsGraphUnion<>(g14, g23);

    Tuple3<String, Graph<EntityReference, DataTypeEdge>, GraphPath<EntityReference, DataTypeEdge>> element = new Tuple3<>(
        "V1", asGraphUnion, new GraphWalk<>(graph, new ArrayList<>(), 10.0d));

    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();
    builderResult.addStrictRoutes(element);

    ArrayList<String> elements = new ArrayList<>();
    elements.add("42");
    elements.add("foo");

    // Act
    ImmutableRouteLookup.Builder actualProcessingMessagesResult = builderResult.processingMessages(elements);

    // Assert
    verify(g1, atLeast(1)).getType();
    verify(g2, atLeast(1)).getType();
    verify(g13, atLeast(1)).getType();
    verify(g22, atLeast(1)).getType();
    verify(g14, atLeast(1)).getType();
    verify(g23, atLeast(1)).getType();
    verify(graphType).isAllowingSelfLoops();
    verify(graphType3).isAllowingSelfLoops();
    verify(graphType5).isAllowingSelfLoops();
    verify(graphType, atLeast(1)).isDirected();
    verify(graphType2, atLeast(1)).isDirected();
    verify(graphType3, atLeast(1)).isDirected();
    verify(graphType4, atLeast(1)).isDirected();
    verify(graphType5, atLeast(1)).isDirected();
    verify(graphType6, atLeast(1)).isDirected();
    assertSame(builderResult, actualProcessingMessagesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#source(ExternalIdValue)}
   */
  @Test
  void testBuilderSource() {
    // Arrange
    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.source(ExternalIdValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#source(ExternalIdValue)}
   */
  @Test
  void testBuilderSource2() {
    // Arrange
    GraphType graphType = mock(GraphType.class);
    when(graphType.isAllowingSelfLoops()).thenReturn(true);
    when(graphType.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g1 = mock(Graph.class);
    when(g1.getType()).thenReturn(graphType);
    GraphType graphType2 = mock(GraphType.class);
    when(graphType2.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g2 = mock(Graph.class);
    when(g2.getType()).thenReturn(graphType2);
    AsGraphUnion<EntityReference, DataTypeEdge> g12 = new AsGraphUnion<>(g1, g2, mock(WeightCombiner.class));

    GraphType graphType3 = mock(GraphType.class);
    when(graphType3.isAllowingSelfLoops()).thenReturn(true);
    when(graphType3.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g13 = mock(Graph.class);
    when(g13.getType()).thenReturn(graphType3);
    GraphType graphType4 = mock(GraphType.class);
    when(graphType4.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g22 = mock(Graph.class);
    when(g22.getType()).thenReturn(graphType4);
    AsGraphUnion<EntityReference, DataTypeEdge> asGraphUnion = new AsGraphUnion<>(g12,
        new AsGraphUnion<>(g13, g22, mock(WeightCombiner.class)));

    GraphType graphType5 = mock(GraphType.class);
    when(graphType5.isAllowingSelfLoops()).thenReturn(true);
    when(graphType5.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g14 = mock(Graph.class);
    when(g14.getType()).thenReturn(graphType5);
    GraphType graphType6 = mock(GraphType.class);
    when(graphType6.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g23 = mock(Graph.class);
    when(g23.getType()).thenReturn(graphType6);
    AsGraphUnion<EntityReference, DataTypeEdge> graph = new AsGraphUnion<>(g14, g23);

    Tuple3<String, Graph<EntityReference, DataTypeEdge>, GraphPath<EntityReference, DataTypeEdge>> element = new Tuple3<>(
        "source", asGraphUnion, new GraphWalk<>(graph, new ArrayList<>(), 10.0d));

    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();
    builderResult.addStrictRoutes(element);

    // Act
    ImmutableRouteLookup.Builder actualSourceResult = builderResult.source(ExternalIdValue.of("42"));

    // Assert
    verify(g1, atLeast(1)).getType();
    verify(g2, atLeast(1)).getType();
    verify(g13, atLeast(1)).getType();
    verify(g22, atLeast(1)).getType();
    verify(g14, atLeast(1)).getType();
    verify(g23, atLeast(1)).getType();
    verify(graphType).isAllowingSelfLoops();
    verify(graphType3).isAllowingSelfLoops();
    verify(graphType5).isAllowingSelfLoops();
    verify(graphType, atLeast(1)).isDirected();
    verify(graphType2, atLeast(1)).isDirected();
    verify(graphType3, atLeast(1)).isDirected();
    verify(graphType4, atLeast(1)).isDirected();
    verify(graphType5, atLeast(1)).isDirected();
    verify(graphType6, atLeast(1)).isDirected();
    assertSame(builderResult, actualSourceResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#strictRoutes(Iterable)}
   */
  @Test
  void testBuilderStrictRoutes() {
    // Arrange
    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.strictRoutes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#strictRoutes(Iterable)}
   */
  @Test
  void testBuilderStrictRoutes2() {
    // Arrange
    GraphType graphType = mock(GraphType.class);
    when(graphType.isAllowingSelfLoops()).thenReturn(true);
    when(graphType.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g1 = mock(Graph.class);
    when(g1.getType()).thenReturn(graphType);
    GraphType graphType2 = mock(GraphType.class);
    when(graphType2.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g2 = mock(Graph.class);
    when(g2.getType()).thenReturn(graphType2);
    AsGraphUnion<EntityReference, DataTypeEdge> g12 = new AsGraphUnion<>(g1, g2, mock(WeightCombiner.class));

    GraphType graphType3 = mock(GraphType.class);
    when(graphType3.isAllowingSelfLoops()).thenReturn(true);
    when(graphType3.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g13 = mock(Graph.class);
    when(g13.getType()).thenReturn(graphType3);
    GraphType graphType4 = mock(GraphType.class);
    when(graphType4.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g22 = mock(Graph.class);
    when(g22.getType()).thenReturn(graphType4);
    AsGraphUnion<EntityReference, DataTypeEdge> asGraphUnion = new AsGraphUnion<>(g12,
        new AsGraphUnion<>(g13, g22, mock(WeightCombiner.class)));

    GraphType graphType5 = mock(GraphType.class);
    when(graphType5.isAllowingSelfLoops()).thenReturn(true);
    when(graphType5.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g14 = mock(Graph.class);
    when(g14.getType()).thenReturn(graphType5);
    GraphType graphType6 = mock(GraphType.class);
    when(graphType6.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g23 = mock(Graph.class);
    when(g23.getType()).thenReturn(graphType6);
    AsGraphUnion<EntityReference, DataTypeEdge> graph = new AsGraphUnion<>(g14, g23);

    Tuple3<String, Graph<EntityReference, DataTypeEdge>, GraphPath<EntityReference, DataTypeEdge>> element = new Tuple3<>(
        "V1", asGraphUnion, new GraphWalk<>(graph, new ArrayList<>(), 10.0d));

    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();
    builderResult.addStrictRoutes(element);

    // Act
    ImmutableRouteLookup.Builder actualStrictRoutesResult = builderResult.strictRoutes(new ArrayList<>());

    // Assert
    verify(g1, atLeast(1)).getType();
    verify(g2, atLeast(1)).getType();
    verify(g13, atLeast(1)).getType();
    verify(g22, atLeast(1)).getType();
    verify(g14, atLeast(1)).getType();
    verify(g23, atLeast(1)).getType();
    verify(graphType).isAllowingSelfLoops();
    verify(graphType3).isAllowingSelfLoops();
    verify(graphType5).isAllowingSelfLoops();
    verify(graphType, atLeast(1)).isDirected();
    verify(graphType2, atLeast(1)).isDirected();
    verify(graphType3, atLeast(1)).isDirected();
    verify(graphType4, atLeast(1)).isDirected();
    verify(graphType5, atLeast(1)).isDirected();
    verify(graphType6, atLeast(1)).isDirected();
    assertSame(builderResult, actualStrictRoutesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#target(ExternalIdValue)}
   */
  @Test
  void testBuilderTarget() {
    // Arrange
    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.target(ExternalIdValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutableRouteLookup.Builder#target(ExternalIdValue)}
   */
  @Test
  void testBuilderTarget2() {
    // Arrange
    GraphType graphType = mock(GraphType.class);
    when(graphType.isAllowingSelfLoops()).thenReturn(true);
    when(graphType.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g1 = mock(Graph.class);
    when(g1.getType()).thenReturn(graphType);
    GraphType graphType2 = mock(GraphType.class);
    when(graphType2.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g2 = mock(Graph.class);
    when(g2.getType()).thenReturn(graphType2);
    AsGraphUnion<EntityReference, DataTypeEdge> g12 = new AsGraphUnion<>(g1, g2, mock(WeightCombiner.class));

    GraphType graphType3 = mock(GraphType.class);
    when(graphType3.isAllowingSelfLoops()).thenReturn(true);
    when(graphType3.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g13 = mock(Graph.class);
    when(g13.getType()).thenReturn(graphType3);
    GraphType graphType4 = mock(GraphType.class);
    when(graphType4.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g22 = mock(Graph.class);
    when(g22.getType()).thenReturn(graphType4);
    AsGraphUnion<EntityReference, DataTypeEdge> asGraphUnion = new AsGraphUnion<>(g12,
        new AsGraphUnion<>(g13, g22, mock(WeightCombiner.class)));

    GraphType graphType5 = mock(GraphType.class);
    when(graphType5.isAllowingSelfLoops()).thenReturn(true);
    when(graphType5.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g14 = mock(Graph.class);
    when(g14.getType()).thenReturn(graphType5);
    GraphType graphType6 = mock(GraphType.class);
    when(graphType6.isDirected()).thenReturn(true);
    Graph<EntityReference, DataTypeEdge> g23 = mock(Graph.class);
    when(g23.getType()).thenReturn(graphType6);
    AsGraphUnion<EntityReference, DataTypeEdge> graph = new AsGraphUnion<>(g14, g23);

    Tuple3<String, Graph<EntityReference, DataTypeEdge>, GraphPath<EntityReference, DataTypeEdge>> element = new Tuple3<>(
        "target", asGraphUnion, new GraphWalk<>(graph, new ArrayList<>(), 10.0d));

    ImmutableRouteLookup.Builder builderResult = ImmutableRouteLookup.builder();
    builderResult.addStrictRoutes(element);

    // Act
    ImmutableRouteLookup.Builder actualTargetResult = builderResult.target(ExternalIdValue.of("42"));

    // Assert
    verify(g1, atLeast(1)).getType();
    verify(g2, atLeast(1)).getType();
    verify(g13, atLeast(1)).getType();
    verify(g22, atLeast(1)).getType();
    verify(g14, atLeast(1)).getType();
    verify(g23, atLeast(1)).getType();
    verify(graphType).isAllowingSelfLoops();
    verify(graphType3).isAllowingSelfLoops();
    verify(graphType5).isAllowingSelfLoops();
    verify(graphType, atLeast(1)).isDirected();
    verify(graphType2, atLeast(1)).isDirected();
    verify(graphType3, atLeast(1)).isDirected();
    verify(graphType4, atLeast(1)).isDirected();
    verify(graphType5, atLeast(1)).isDirected();
    verify(graphType6, atLeast(1)).isDirected();
    assertSame(builderResult, actualTargetResult);
  }
}
