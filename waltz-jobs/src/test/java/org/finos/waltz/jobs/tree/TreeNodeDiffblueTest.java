package org.finos.waltz.jobs.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;

class TreeNodeDiffblueTest {
  /**
   * Method under test: {@link TreeNode#TreeNode(TreeNode, String)}
   */
  @Test
  void testNewTreeNode() {
    // Arrange and Act
    TreeNode actualTreeNode = new TreeNode(null, "Data");

    // Assert
    assertEquals("Data", actualTreeNode.data);
    assertNull(actualTreeNode.parent);
    assertEquals(0, actualTreeNode.leftIdx);
    assertEquals(0, actualTreeNode.rightIdx);
    assertTrue(actualTreeNode.children.isEmpty());
  }

  /**
   * Method under test: {@link TreeNode#TreeNode(TreeNode, String)}
   */
  @Test
  void testNewTreeNode2() {
    // Arrange
    TreeNode parent = new TreeNode(null, "Data");

    // Act
    TreeNode actualTreeNode = new TreeNode(parent, "Data");

    // Assert
    assertEquals("Data", parent.data);
    assertEquals("Data", actualTreeNode.data);
    TreeNode treeNode = actualTreeNode.parent;
    assertEquals("Data", treeNode.data);
    assertNull(parent.parent);
    assertNull(treeNode.parent);
    assertEquals(0, parent.leftIdx);
    assertEquals(0, actualTreeNode.leftIdx);
    assertEquals(0, treeNode.leftIdx);
    assertEquals(0, parent.rightIdx);
    assertEquals(0, actualTreeNode.rightIdx);
    assertEquals(0, treeNode.rightIdx);
    assertEquals(1, parent.children.size());
    List<TreeNode> treeNodeList = treeNode.children;
    assertEquals(1, treeNodeList.size());
    assertTrue(actualTreeNode.children.isEmpty());
    assertSame(actualTreeNode, treeNodeList.get(0));
    assertSame(parent.children, treeNodeList);
  }

  /**
   * Method under test: {@link TreeNode#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("TreeNode{parent=null, data='Data', leftIdx=0, rightIdx=0, children=0}",
        (new TreeNode(null, "Data")).toString());
  }
}
