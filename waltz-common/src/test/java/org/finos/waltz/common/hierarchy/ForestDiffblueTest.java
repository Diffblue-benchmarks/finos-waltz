package org.finos.waltz.common.hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ForestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Forest#Forest(Map, Set)}
   *   <li>{@link Forest#toString()}
   *   <li>{@link Forest#getAllNodes()}
   *   <li>{@link Forest#getRootNodes()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    HashMap<Object, Node<Object, Object>> allNodes = new HashMap<>();
    HashSet<Node<Object, Object>> rootNodes = new HashSet<>();

    // Act
    Forest<Object, Object> actualForest = new Forest<>(allNodes, rootNodes);
    String actualToStringResult = actualForest.toString();
    Map<Object, Node<Object, Object>> actualAllNodes = actualForest.getAllNodes();
    Set<Node<Object, Object>> actualRootNodes = actualForest.getRootNodes();

    // Assert
    assertEquals("Forest{#allNodes=0, rootNodes=[]}", actualToStringResult);
    assertTrue(actualAllNodes.isEmpty());
    assertTrue(actualRootNodes.isEmpty());
    assertSame(allNodes, actualAllNodes);
    assertSame(rootNodes, actualRootNodes);
  }
}
