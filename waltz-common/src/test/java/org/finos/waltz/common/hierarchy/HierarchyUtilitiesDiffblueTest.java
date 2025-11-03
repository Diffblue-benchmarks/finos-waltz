package org.finos.waltz.common.hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HierarchyUtilitiesDiffblueTest {
  /**
   * Test {@link HierarchyUtilities#toForest(Collection)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code 42}.</li>
   *   <li>Then return AllNodes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link HierarchyUtilities#toForest(Collection)}
   */
  @Test
  @DisplayName("Test toForest(Collection); given Optional with '42'; then return AllNodes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Forest HierarchyUtilities.toForest(Collection)"})
  void testToForest_givenOptionalWith42_thenReturnAllNodesSizeIsOne() {
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
   * Test {@link HierarchyUtilities#toForest(Collection)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code 42}.</li>
   *   <li>Then return AllNodes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link HierarchyUtilities#toForest(Collection)}
   */
  @Test
  @DisplayName("Test toForest(Collection); given Optional with '42'; then return AllNodes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Forest HierarchyUtilities.toForest(Collection)"})
  void testToForest_givenOptionalWith42_thenReturnAllNodesSizeIsOne2() {
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
   * Test {@link HierarchyUtilities#toForest(Collection)}.
   * <ul>
   *   <li>Then return AllNodes size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link HierarchyUtilities#toForest(Collection)}
   */
  @Test
  @DisplayName("Test toForest(Collection); then return AllNodes size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Forest HierarchyUtilities.toForest(Collection)"})
  void testToForest_thenReturnAllNodesSizeIsTwo() {
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
    assertNull(getResult.getParent());
    assertEquals(1, getResult.getChildren().size());
    assertSame(getResult, allNodes.get("Id").getParent());
  }

  /**
   * Test {@link HierarchyUtilities#toForest(Collection)}.
   * <ul>
   *   <li>Then return RootNodes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link HierarchyUtilities#toForest(Collection)}
   */
  @Test
  @DisplayName("Test toForest(Collection); then return RootNodes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Forest HierarchyUtilities.toForest(Collection)"})
  void testToForest_thenReturnRootNodesSizeIsOne() {
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
   * Test {@link HierarchyUtilities#toForest(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return AllNodes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link HierarchyUtilities#toForest(Collection)}
   */
  @Test
  @DisplayName("Test toForest(Collection); when ArrayList(); then return AllNodes Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Forest HierarchyUtilities.toForest(Collection)"})
  void testToForest_whenArrayList_thenReturnAllNodesEmpty() {
    // Arrange and Act
    Forest<Object, Object> actualToForestResult = HierarchyUtilities.toForest(new ArrayList<>());

    // Assert
    assertTrue(actualToForestResult.getAllNodes().isEmpty());
    assertTrue(actualToForestResult.getRootNodes().isEmpty());
  }

  /**
   * Test {@link HierarchyUtilities#hasCycle(Forest)} with {@code forest}.
   * <ul>
   *   <li>Given {@link FlatNode#FlatNode(Object, Optional, Object)} with id is {@code 42} and parentId is {@link Optional} and {@code Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HierarchyUtilities#hasCycle(Forest)}
   */
  @Test
  @DisplayName("Test hasCycle(Forest) with 'forest'; given FlatNode(Object, Optional, Object) with id is '42' and parentId is Optional and 'Data'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HierarchyUtilities.hasCycle(Forest)"})
  void testHasCycleWithForest_givenFlatNodeWithIdIs42AndParentIdIsOptionalAndData() {
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
   * Test {@link HierarchyUtilities#hasCycle(Forest)} with {@code forest}.
   * <ul>
   *   <li>Given {@link FlatNode#FlatNode(Object, Optional, Object)} with id is one and parentId is {@link Optional} and {@code Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HierarchyUtilities#hasCycle(Forest)}
   */
  @Test
  @DisplayName("Test hasCycle(Forest) with 'forest'; given FlatNode(Object, Optional, Object) with id is one and parentId is Optional and 'Data'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HierarchyUtilities.hasCycle(Forest)"})
  void testHasCycleWithForest_givenFlatNodeWithIdIsOneAndParentIdIsOptionalAndData() {
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
   * Test {@link HierarchyUtilities#hasCycle(Forest)} with {@code forest}.
   * <ul>
   *   <li>Given {@link Optional} with {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HierarchyUtilities#hasCycle(Forest)}
   */
  @Test
  @DisplayName("Test hasCycle(Forest) with 'forest'; given Optional with '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HierarchyUtilities.hasCycle(Forest)"})
  void testHasCycleWithForest_givenOptionalWith42() {
    // Arrange
    ArrayList<FlatNode<Object, Object>> flatNodes = new ArrayList<>();
    Optional<Object> parentId = Optional.of("42");
    flatNodes.add(new FlatNode<>("Id", parentId, "Data"));
    Forest<Object, Object> forest = HierarchyUtilities.toForest(flatNodes);

    // Act and Assert
    assertFalse(HierarchyUtilities.hasCycle(forest));
  }

  /**
   * Test {@link HierarchyUtilities#hasCycle(Forest)} with {@code forest}.
   * <ul>
   *   <li>When toForest {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HierarchyUtilities#hasCycle(Forest)}
   */
  @Test
  @DisplayName("Test hasCycle(Forest) with 'forest'; when toForest ArrayList(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HierarchyUtilities.hasCycle(Forest)"})
  void testHasCycleWithForest_whenToForestArrayList_thenReturnFalse() {
    // Arrange
    Forest<Object, Object> forest = HierarchyUtilities.toForest(new ArrayList<>());

    // Act and Assert
    assertFalse(HierarchyUtilities.hasCycle(forest));
  }

  /**
   * Test {@link HierarchyUtilities#parents(Node)}.
   * <ul>
   *   <li>Given {@link Node#Node(Object, Object)} with {@code Id} and {@code Data}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link HierarchyUtilities#parents(Node)}
   */
  @Test
  @DisplayName("Test parents(Node); given Node(Object, Object) with 'Id' and 'Data'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List HierarchyUtilities.parents(Node)"})
  void testParents_givenNodeWithIdAndData_thenReturnSizeIsOne() {
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
   * Test {@link HierarchyUtilities#parents(Node)}.
   * <ul>
   *   <li>When {@link Node#Node(Object, Object)} with {@code Id} and {@code Data}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link HierarchyUtilities#parents(Node)}
   */
  @Test
  @DisplayName("Test parents(Node); when Node(Object, Object) with 'Id' and 'Data'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List HierarchyUtilities.parents(Node)"})
  void testParents_whenNodeWithIdAndData_thenReturnEmpty() {
    // Arrange and Act
    List<Node<Object, Object>> actualParentsResult = HierarchyUtilities.parents(new Node<>("Id", "Data"));

    // Assert
    assertTrue(actualParentsResult.isEmpty());
  }

  /**
   * Test {@link HierarchyUtilities#assignDepths(Forest)} with {@code forest}.
   * <ul>
   *   <li>Given {@link Optional} with {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link HierarchyUtilities#assignDepths(Forest)}
   */
  @Test
  @DisplayName("Test assignDepths(Forest) with 'forest'; given Optional with '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map HierarchyUtilities.assignDepths(Forest)"})
  void testAssignDepthsWithForest_givenOptionalWith42_thenReturnSizeIsOne() {
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

  /**
   * Test {@link HierarchyUtilities#assignDepths(Forest)} with {@code forest}.
   * <ul>
   *   <li>When toForest {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link HierarchyUtilities#assignDepths(Forest)}
   */
  @Test
  @DisplayName("Test assignDepths(Forest) with 'forest'; when toForest ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map HierarchyUtilities.assignDepths(Forest)"})
  void testAssignDepthsWithForest_whenToForestArrayList_thenReturnEmpty() {
    // Arrange
    Forest<Object, Object> forest = HierarchyUtilities.toForest(new ArrayList<>());

    // Act
    Map<Object, Integer> actualAssignDepthsResult = HierarchyUtilities.assignDepths(forest);

    // Assert
    assertTrue(actualAssignDepthsResult.isEmpty());
  }
}
