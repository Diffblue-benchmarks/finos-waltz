package org.finos.waltz.common.hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class NodeDiffblueTest {
  /**
   * Method under test: {@link Node#getChildren()}
   */
  @Test
  void testGetChildren() {
    // Arrange
    Node<Object, Object> node = new Node<>("Id", "Data");

    // Act and Assert
    assertTrue(node.getChildren().isEmpty());
  }

  /**
   * Method under test: {@link Node#addChild(Node)}
   */
  @Test
  void testAddChild() {
    // Arrange
    Node<Object, Object> node = new Node<>("Id", "Data");

    // Act and Assert
    assertSame(node, node.addChild(new Node<>("Id", "Data")));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Node#Node(Object, Object)}
   *   <li>{@link Node#setParent(Node)}
   *   <li>{@link Node#toString()}
   *   <li>{@link Node#getData()}
   *   <li>{@link Node#getId()}
   *   <li>{@link Node#getParent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Node<Object, Object> actualNode = new Node<>("Id", "Data");
    Node<Object, Object> parent = new Node<>("Id", "Data");

    Node<Object, Object> actualSetParentResult = actualNode.setParent(parent);
    String actualToStringResult = actualNode.toString();
    Object actualData = actualNode.getData();
    Object actualId = actualNode.getId();

    // Assert
    assertEquals("Data", actualData);
    assertEquals("Id", actualId);
    assertEquals("Node{id=Id, #children=0}", actualToStringResult);
    assertSame(parent, actualNode.getParent());
    assertSame(actualNode, actualSetParentResult);
  }
}
