package org.finos.waltz.common.hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NodeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Node.<init>(Object, Object)", "Object Node.getData()", "Object Node.getId()",
      "Node Node.getParent()", "Node Node.setParent(Node)", "String Node.toString()"})
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

  /**
   * Test {@link Node#getChildren()}.
   * <p>
   * Method under test: {@link Node#getChildren()}
   */
  @Test
  @DisplayName("Test getChildren()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Node.getChildren()"})
  void testGetChildren() {
    // Arrange
    Node<Object, Object> node = new Node<>("Id", "Data");

    // Act and Assert
    assertTrue(node.getChildren().isEmpty());
  }

  /**
   * Test {@link Node#addChild(Node)}.
   * <ul>
   *   <li>When {@link Node#Node(Object, Object)} with {@code Id} and {@code Data}.</li>
   *   <li>Then return {@link Node#Node(Object, Object)} with {@code Id} and {@code Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Node#addChild(Node)}
   */
  @Test
  @DisplayName("Test addChild(Node); when Node(Object, Object) with 'Id' and 'Data'; then return Node(Object, Object) with 'Id' and 'Data'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Node Node.addChild(Node)"})
  void testAddChild_whenNodeWithIdAndData_thenReturnNodeWithIdAndData() {
    // Arrange
    Node<Object, Object> node = new Node<>("Id", "Data");

    // Act and Assert
    assertSame(node, node.addChild(new Node<>("Id", "Data")));
  }
}
