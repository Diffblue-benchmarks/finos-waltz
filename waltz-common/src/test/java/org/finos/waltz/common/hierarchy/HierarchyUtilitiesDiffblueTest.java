package org.finos.waltz.common.hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HierarchyUtilitiesDiffblueTest {
  /**
   * Test {@link HierarchyUtilities#toForest(Collection)}.
   *
   * <ul>
   *   <li>Given {@link Optional} with {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link HierarchyUtilities#toForest(Collection)}
   */
  @Test
  @DisplayName("Test toForest(Collection); given Optional with 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Forest HierarchyUtilities.toForest(Collection)"})
  void testToForest_givenOptionalWithValue() {
    // Arrange
    ArrayList<FlatNode<Object, Object>> flatNodes = new ArrayList<>();
    Optional<Object> parentId = Optional.of("Value");
    FlatNode<Object, Object> flatNode = new FlatNode<>("Id", parentId, "Data");
    flatNodes.add(flatNode);

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
   *
   * <ul>
   *   <li>Given {@link Optional} with {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link HierarchyUtilities#toForest(Collection)}
   */
  @Test
  @DisplayName("Test toForest(Collection); given Optional with 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Forest HierarchyUtilities.toForest(Collection)"})
  void testToForest_givenOptionalWithValue2() {
    // Arrange
    ArrayList<FlatNode<Object, Object>> flatNodes = new ArrayList<>();
    Optional<Object> parentId = Optional.of("Value");
    FlatNode<Object, Object> flatNode = new FlatNode<>("Id", parentId, "Data");
    flatNodes.add(flatNode);
    Optional<Object> parentId2 = Optional.of("Value");
    FlatNode<Object, Object> flatNode2 = new FlatNode<>("Id", parentId2, "Data");
    flatNodes.add(flatNode2);

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
   *
   * <ul>
   *   <li>Then return RootNodes size is one.
   * </ul>
   *
   * <p>Method under test: {@link HierarchyUtilities#toForest(Collection)}
   */
  @Test
  @DisplayName("Test toForest(Collection); then return RootNodes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Forest HierarchyUtilities.toForest(Collection)"})
  void testToForest_thenReturnRootNodesSizeIsOne() {
    // Arrange
    ArrayList<FlatNode<Object, Object>> flatNodes = new ArrayList<>();
    Optional<Object> parentId = Optional.empty();
    FlatNode<Object, Object> flatNode = new FlatNode<>("Id", parentId, "Data");
    flatNodes.add(flatNode);

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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return AllNodes Empty.
   * </ul>
   *
   * <p>Method under test: {@link HierarchyUtilities#toForest(Collection)}
   */
  @Test
  @DisplayName("Test toForest(Collection); when ArrayList(); then return AllNodes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link FlatNode#FlatNode(Object, Optional, Object)} with id is one and parentId is
   *       {@link Optional} and {@code Data}.
   * </ul>
   *
   * <p>Method under test: {@link HierarchyUtilities#hasCycle(Forest)}
   */
  @Test
  @DisplayName(
      "Test hasCycle(Forest) with 'forest'; given FlatNode(Object, Optional, Object) with id is one and parentId is Optional and 'Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HierarchyUtilities.hasCycle(Forest)"})
  void testHasCycleWithForest_givenFlatNodeWithIdIsOneAndParentIdIsOptionalAndData() {
    // Arrange
    ArrayList<FlatNode<Object, Object>> flatNodes = new ArrayList<>();
    Optional<Object> parentId = Optional.of("Value");
    FlatNode<Object, Object> flatNode = new FlatNode<>(1, parentId, "Data");
    flatNodes.add(flatNode);
    Optional<Object> parentId2 = Optional.of("Value");
    FlatNode<Object, Object> flatNode2 = new FlatNode<>("Id", parentId2, "Data");
    flatNodes.add(flatNode2);
    Forest<Object, Object> forest = HierarchyUtilities.toForest(flatNodes);

    // Act and Assert
    assertFalse(HierarchyUtilities.hasCycle(forest));
  }

  /**
   * Test {@link HierarchyUtilities#hasCycle(Forest)} with {@code forest}.
   *
   * <ul>
   *   <li>Given {@link Optional} with {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link HierarchyUtilities#hasCycle(Forest)}
   */
  @Test
  @DisplayName("Test hasCycle(Forest) with 'forest'; given Optional with 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HierarchyUtilities.hasCycle(Forest)"})
  void testHasCycleWithForest_givenOptionalWithValue() {
    // Arrange
    ArrayList<FlatNode<Object, Object>> flatNodes = new ArrayList<>();
    Optional<Object> parentId = Optional.of("Value");
    FlatNode<Object, Object> flatNode = new FlatNode<>("Id", parentId, "Data");
    flatNodes.add(flatNode);
    Forest<Object, Object> forest = HierarchyUtilities.toForest(flatNodes);

    // Act and Assert
    assertFalse(HierarchyUtilities.hasCycle(forest));
  }

  /**
   * Test {@link HierarchyUtilities#hasCycle(Forest)} with {@code forest}.
   *
   * <ul>
   *   <li>When toForest {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link HierarchyUtilities#hasCycle(Forest)}
   */
  @Test
  @DisplayName(
      "Test hasCycle(Forest) with 'forest'; when toForest ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HierarchyUtilities.hasCycle(Forest)"})
  void testHasCycleWithForest_whenToForestArrayList_thenReturnFalse() {
    // Arrange
    Forest<Object, Object> forest = HierarchyUtilities.toForest(new ArrayList<>());

    // Act and Assert
    assertFalse(HierarchyUtilities.hasCycle(forest));
  }

  /**
   * Test {@link HierarchyUtilities#parents(Node)}.
   *
   * <ul>
   *   <li>Then return size is eighteen.
   * </ul>
   *
   * <p>Method under test: {@link HierarchyUtilities#parents(Node)}
   */
  @Test
  @DisplayName("Test parents(Node); then return size is eighteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List HierarchyUtilities.parents(Node)"})
  void testParents_thenReturnSizeIsEighteen() {
    // Arrange
    Node<Object, Object> parent = new Node<>("Id", "Data");
    Node<Object, Object> parent2 = new Node<>("Id", "Data");
    parent.setParent(parent2);

    Node<Object, Object> parent3 = new Node<>("Id", "Data");
    parent3.setParent(parent);

    Node<Object, Object> parent4 = new Node<>("Id", "Data");
    parent4.setParent(parent3);

    Node<Object, Object> parent5 = new Node<>("Id", "Data");
    parent5.setParent(parent4);

    Node<Object, Object> parent6 = new Node<>("Id", "Data");
    parent6.setParent(parent5);

    Node<Object, Object> parent7 = new Node<>("Id", "Data");
    parent7.setParent(parent6);

    Node<Object, Object> parent8 = new Node<>("Id", "Data");
    parent8.setParent(parent7);

    Node<Object, Object> parent9 = new Node<>("Id", "Data");
    parent9.setParent(parent8);

    Node<Object, Object> parent10 = new Node<>("Id", "Data");
    parent10.setParent(parent9);

    Node<Object, Object> parent11 = new Node<>("Id", "Data");
    parent11.setParent(parent10);

    Node<Object, Object> parent12 = new Node<>("Id", "Data");
    parent12.setParent(parent11);

    Node<Object, Object> parent13 = new Node<>("Id", "Data");
    parent13.setParent(parent12);

    Node<Object, Object> parent14 = new Node<>("Id", "Data");
    parent14.setParent(parent13);

    Node<Object, Object> parent15 = new Node<>("Id", "Data");
    parent15.setParent(parent14);

    Node<Object, Object> parent16 = new Node<>("Id", "Data");
    parent16.setParent(parent15);

    Node<Object, Object> parent17 = new Node<>("Id", "Data");
    parent17.setParent(parent16);

    Node<Object, Object> parent18 = new Node<>("Id", "Data");
    parent18.setParent(parent17);

    Node<Object, Object> startNode = new Node<>("Id", "Data");
    startNode.setParent(parent18);

    // Act
    List<Node<Object, Object>> actualParentsResult = HierarchyUtilities.parents(startNode);

    // Assert
    assertEquals(18, actualParentsResult.size());
    assertSame(parent18, actualParentsResult.get(0));
    assertSame(parent17, actualParentsResult.get(1));
    assertSame(parent6, actualParentsResult.get(12));
    assertSame(parent5, actualParentsResult.get(13));
    assertSame(parent4, actualParentsResult.get(14));
    assertSame(parent3, actualParentsResult.get(15));
    assertSame(parent2, actualParentsResult.get(17));
    assertSame(parent16, actualParentsResult.get(2));
    assertSame(parent15, actualParentsResult.get(3));
    assertSame(parent14, actualParentsResult.get(4));
    assertSame(parent13, actualParentsResult.get(5));
    assertSame(parent, actualParentsResult.get(Short.SIZE));
  }

  /**
   * Test {@link HierarchyUtilities#parents(Node)}.
   *
   * <ul>
   *   <li>When {@link Node#Node(Object, Object)} with {@code Id} and {@code Data}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link HierarchyUtilities#parents(Node)}
   */
  @Test
  @DisplayName(
      "Test parents(Node); when Node(Object, Object) with 'Id' and 'Data'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List HierarchyUtilities.parents(Node)"})
  void testParents_whenNodeWithIdAndData_thenReturnEmpty() {
    // Arrange and Act
    List<Node<Object, Object>> actualParentsResult =
        HierarchyUtilities.parents(new Node<>("Id", "Data"));

    // Assert
    assertTrue(actualParentsResult.isEmpty());
  }

  /**
   * Test {@link HierarchyUtilities#assignDepths(Forest)} with {@code forest}.
   *
   * <ul>
   *   <li>Given {@link Node#Node(Object, Object)} with {@code Id} and {@code Data}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link HierarchyUtilities#assignDepths(Forest)}
   */
  @Test
  @DisplayName(
      "Test assignDepths(Forest) with 'forest'; given Node(Object, Object) with 'Id' and 'Data'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map HierarchyUtilities.assignDepths(Forest)"})
  void testAssignDepthsWithForest_givenNodeWithIdAndData_thenReturnSizeIsOne() {
    // Arrange
    LinkedHashSet<Node<Object, Object>> rootNodes = new LinkedHashSet<>();
    rootNodes.add(new Node<>("Id", "Data"));
    Forest<Object, Object> forest = new Forest<>(new HashMap<>(), rootNodes);

    // Act
    Map<Object, Integer> actualAssignDepthsResult = HierarchyUtilities.assignDepths(forest);

    // Assert
    assertEquals(1, actualAssignDepthsResult.size());
    assertEquals(1, actualAssignDepthsResult.get("Id").intValue());
  }

  /**
   * Test {@link HierarchyUtilities#assignDepths(Forest)} with {@code forest}.
   *
   * <ul>
   *   <li>When toForest {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link HierarchyUtilities#assignDepths(Forest)}
   */
  @Test
  @DisplayName(
      "Test assignDepths(Forest) with 'forest'; when toForest ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
