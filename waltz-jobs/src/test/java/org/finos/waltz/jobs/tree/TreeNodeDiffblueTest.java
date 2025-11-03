package org.finos.waltz.jobs.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TreeNodeDiffblueTest {
  /**
   * Test {@link TreeNode#TreeNode(TreeNode, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TreeNode#TreeNode(TreeNode, String)}
   */
  @Test
  @DisplayName("Test new TreeNode(TreeNode, String); when 'null'; then return 'Data'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TreeNode.<init>(TreeNode, String)"})
  void testNewTreeNode_whenNull_thenReturnData() {
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
   * Test {@link TreeNode#TreeNode(TreeNode, String)}.
   * <ul>
   *   <li>When {@link TreeNode#TreeNode(TreeNode, String)} with parent is {@code null} and {@code Data}.</li>
   *   <li>Then return {@link TreeNode#parent} {@link TreeNode#data} is {@code Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TreeNode#TreeNode(TreeNode, String)}
   */
  @Test
  @DisplayName("Test new TreeNode(TreeNode, String); when TreeNode(TreeNode, String) with parent is 'null' and 'Data'; then return parent data is 'Data'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TreeNode.<init>(TreeNode, String)"})
  void testNewTreeNode_whenTreeNodeWithParentIsNullAndData_thenReturnParentDataIsData() {
    // Arrange
    TreeNode parent = new TreeNode(null, "Data");

    // Act
    TreeNode actualTreeNode = new TreeNode(parent, "Data");

    // Assert
    TreeNode treeNode = actualTreeNode.parent;
    assertEquals("Data", treeNode.data);
    assertNull(treeNode.parent);
    assertEquals(0, treeNode.leftIdx);
    assertEquals(0, treeNode.rightIdx);
    assertEquals(1, parent.children.size());
    List<TreeNode> treeNodeList = treeNode.children;
    assertEquals(1, treeNodeList.size());
    assertSame(actualTreeNode, treeNodeList.get(0));
    assertSame(parent.children, treeNodeList);
  }

  /**
   * Test {@link TreeNode#toString()}.
   * <p>
   * Method under test: {@link TreeNode#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TreeNode.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("TreeNode{parent=null, data='Data', leftIdx=0, rightIdx=0, children=0}",
        (new TreeNode(null, "Data")).toString());
  }
}
