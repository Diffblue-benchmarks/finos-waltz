package org.finos.waltz.common.hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class HierarchyUtilitiesDiffblueTest {
  /**
   * Method under test: {@link HierarchyUtilities#toForest(Collection)}
   */
  @Test
  void testToForest() {
    // Arrange and Act
    Forest<Object, Object> actualToForestResult = HierarchyUtilities.toForest(new ArrayList<>());

    // Assert
    assertTrue(actualToForestResult.getAllNodes().isEmpty());
    assertTrue(actualToForestResult.getRootNodes().isEmpty());
  }

  /**
   * Method under test: {@link HierarchyUtilities#toForest(Collection)}
   */
  @Test
  void testToForest2() {
    // Arrange
    ArrayList<FlatNode<Object, Object>> flatNodes = new ArrayList<>();
    Optional<Object> parentId = Optional.of("42");
    flatNodes.add(new FlatNode<>("Id", parentId, "Data"));

    // Act
    Forest<Object, Object> actualToForestResult = HierarchyUtilities.toForest(flatNodes);

    // Assert
    Map<Object, Node<Object, Object>> allNodes = actualToForestResult.getAllNodes();
    assertEquals(1, allNodes.size());
    Node<Object, Object> getResult = allNodes.get("Id");
    assertEquals("Data", getResult.getData());
    assertEquals("Id", getResult.getId());
    assertNull(getResult.getParent());
    assertTrue(actualToForestResult.getRootNodes().isEmpty());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Method under test: {@link HierarchyUtilities#toForest(Collection)}
   */
  @Test
  void testToForest3() {
    // Arrange
    ArrayList<FlatNode<Object, Object>> flatNodes = new ArrayList<>();
    Optional<Object> parentId = Optional.of("42");
    flatNodes.add(new FlatNode<>("Id", parentId, "Data"));
    Optional<Object> parentId2 = Optional.of("42");
    flatNodes.add(new FlatNode<>("Id", parentId2, "Data"));

    // Act
    Forest<Object, Object> actualToForestResult = HierarchyUtilities.toForest(flatNodes);

    // Assert
    Map<Object, Node<Object, Object>> allNodes = actualToForestResult.getAllNodes();
    assertEquals(1, allNodes.size());
    Node<Object, Object> getResult = allNodes.get("Id");
    assertEquals("Data", getResult.getData());
    assertEquals("Id", getResult.getId());
    assertNull(getResult.getParent());
    assertTrue(actualToForestResult.getRootNodes().isEmpty());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Method under test: {@link HierarchyUtilities#toForest(Collection)}
   */
  @Test
  void testToForest4() {
    // Arrange
    ArrayList<FlatNode<Object, Object>> flatNodes = new ArrayList<>();
    Optional<Object> parentId = Optional.of("42");
    flatNodes.add(new FlatNode<>("42", parentId, "Data"));
    Optional<Object> parentId2 = Optional.of("42");
    flatNodes.add(new FlatNode<>("Id", parentId2, "Data"));
    Optional<Object> parentId3 = Optional.of("42");
    flatNodes.add(new FlatNode<>("Id", parentId3, "Data"));

    // Act
    Forest<Object, Object> actualToForestResult = HierarchyUtilities.toForest(flatNodes);

    // Assert
    Map<Object, Node<Object, Object>> allNodes = actualToForestResult.getAllNodes();
    assertEquals(2, allNodes.size());
    Node<Object, Object> getResult = allNodes.get("42");
    assertEquals("42", getResult.getId());
    assertEquals("Data", getResult.getData());
    Node<Object, Object> getResult2 = allNodes.get("Id");
    assertEquals("Data", getResult2.getData());
    assertEquals("Id", getResult2.getId());
    assertNull(getResult.getParent());
    assertEquals(1, actualToForestResult.getRootNodes().size());
    assertEquals(1, getResult.getChildren().size());
    assertTrue(getResult2.getChildren().isEmpty());
    assertSame(getResult, getResult2.getParent());
  }

  /**
   * Method under test: {@link HierarchyUtilities#toForest(Collection)}
   */
  @Test
  void testToForest5() {
    // Arrange
    ArrayList<FlatNode<Object, Object>> flatNodes = new ArrayList<>();
    Optional<Object> parentId = Optional.empty();
    flatNodes.add(new FlatNode<>("Id", parentId, "Data"));

    // Act
    Forest<Object, Object> actualToForestResult = HierarchyUtilities.toForest(flatNodes);

    // Assert
    Map<Object, Node<Object, Object>> allNodes = actualToForestResult.getAllNodes();
    assertEquals(1, allNodes.size());
    Node<Object, Object> getResult = allNodes.get("Id");
    assertEquals("Data", getResult.getData());
    assertEquals("Id", getResult.getId());
    assertNull(getResult.getParent());
    assertEquals(1, actualToForestResult.getRootNodes().size());
    assertTrue(getResult.getChildren().isEmpty());
  }

  /**
   * Method under test: {@link HierarchyUtilities#hasCycle(Forest)}
   */
  @Test
  void testHasCycle() {
    // Arrange
    Forest<Object, Object> forest = HierarchyUtilities.toForest(new ArrayList<>());

    // Act and Assert
    assertFalse(HierarchyUtilities.hasCycle(forest));
  }

  /**
   * Method under test: {@link HierarchyUtilities#hasCycle(Forest)}
   */
  @Test
  void testHasCycle2() {
    // Arrange
    ArrayList<FlatNode<Object, Object>> flatNodes = new ArrayList<>();
    Optional<Object> parentId = Optional.of("42");
    flatNodes.add(new FlatNode<>("Id", parentId, "Data"));
    Forest<Object, Object> forest = HierarchyUtilities.toForest(flatNodes);

    // Act and Assert
    assertFalse(HierarchyUtilities.hasCycle(forest));
  }

  /**
   * Method under test: {@link HierarchyUtilities#hasCycle(Forest)}
   */
  @Test
  void testHasCycle3() {
    // Arrange
    ArrayList<FlatNode<Object, Object>> flatNodes = new ArrayList<>();
    Optional<Object> parentId = Optional.of("42");
    flatNodes.add(new FlatNode<>(1, parentId, "Data"));
    Optional<Object> parentId2 = Optional.of("42");
    flatNodes.add(new FlatNode<>("Id", parentId2, "Data"));
    Forest<Object, Object> forest = HierarchyUtilities.toForest(flatNodes);

    // Act and Assert
    assertFalse(HierarchyUtilities.hasCycle(forest));
  }

  /**
   * Method under test: {@link HierarchyUtilities#hasCycle(Forest)}
   */
  @Test
  void testHasCycle4() {
    // Arrange
    ArrayList<FlatNode<Object, Object>> flatNodes = new ArrayList<>();
    Optional<Object> parentId = Optional.of("42");
    flatNodes.add(new FlatNode<>("42", parentId, "Data"));
    Optional<Object> parentId2 = Optional.of("42");
    flatNodes.add(new FlatNode<>("Id", parentId2, "Data"));
    Forest<Object, Object> forest = HierarchyUtilities.toForest(flatNodes);

    // Act and Assert
    assertFalse(HierarchyUtilities.hasCycle(forest));
  }

  /**
   * Method under test: {@link HierarchyUtilities#parents(Node)}
   */
  @Test
  void testParents() {
    // Arrange and Act
    List<Node<Object, Object>> actualParentsResult = HierarchyUtilities.parents(new Node<>("Id", "Data"));

    // Assert
    assertTrue(actualParentsResult.isEmpty());
  }

  /**
   * Method under test: {@link HierarchyUtilities#parents(Node)}
   */
  @Test
  void testParents2() {
    // Arrange
    Node<Object, Object> startNode = new Node<>("Id", "Data");
    Node<Object, Object> parent = new Node<>("Id", "Data");

    startNode.setParent(parent);

    // Act
    List<Node<Object, Object>> actualParentsResult = HierarchyUtilities.parents(startNode);

    // Assert
    assertEquals(1, actualParentsResult.size());
    assertSame(parent, actualParentsResult.get(0));
  }

  /**
   * Method under test: {@link HierarchyUtilities#assignDepths(Forest)}
   */
  @Test
  void testAssignDepths() {
    // Arrange
    Forest<Object, Object> forest = HierarchyUtilities.toForest(new ArrayList<>());

    // Act
    Map<Object, Integer> actualAssignDepthsResult = HierarchyUtilities.assignDepths(forest);

    // Assert
    assertTrue(actualAssignDepthsResult.isEmpty());
  }

  /**
   * Method under test: {@link HierarchyUtilities#assignDepths(Forest)}
   */
  @Test
  void testAssignDepths2() {
    // Arrange
    ArrayList<FlatNode<Object, Object>> flatNodes = new ArrayList<>();
    Optional<Object> parentId = Optional.of("42");
    flatNodes.add(new FlatNode<>("42", parentId, "Data"));
    Forest<Object, Object> forest = HierarchyUtilities.toForest(flatNodes);

    // Act
    Map<Object, Integer> actualAssignDepthsResult = HierarchyUtilities.assignDepths(forest);

    // Assert
    assertEquals(1, actualAssignDepthsResult.size());
    assertEquals(1, actualAssignDepthsResult.get("42").intValue());
  }
}
