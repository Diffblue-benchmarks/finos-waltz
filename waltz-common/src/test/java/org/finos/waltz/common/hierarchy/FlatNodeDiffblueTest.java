package org.finos.waltz.common.hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class FlatNodeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FlatNode#equals(Object)}
   *   <li>{@link FlatNode#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Optional<Object> parentId = Optional.of("42");
    FlatNode<Object, Object> flatNode = new FlatNode<>("Id", parentId, "Data");
    Optional<Object> parentId2 = Optional.of("42");
    FlatNode<Object, Object> flatNode2 = new FlatNode<>("Id", parentId2, "Data");

    // Act and Assert
    assertEquals(flatNode, flatNode2);
    int expectedHashCodeResult = flatNode.hashCode();
    assertEquals(expectedHashCodeResult, flatNode2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FlatNode#equals(Object)}
   *   <li>{@link FlatNode#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Optional<Object> parentId = Optional.of("42");
    FlatNode<Object, Object> flatNode = new FlatNode<>("Id", parentId, "Data");

    // Act and Assert
    assertEquals(flatNode, flatNode);
    int expectedHashCodeResult = flatNode.hashCode();
    assertEquals(expectedHashCodeResult, flatNode.hashCode());
  }

  /**
   * Method under test: {@link FlatNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Optional<Object> parentId = Optional.of("42");
    FlatNode<Object, Object> flatNode = new FlatNode<>(1, parentId, "Data");
    Optional<Object> parentId2 = Optional.of("42");

    // Act and Assert
    assertNotEquals(flatNode, new FlatNode<>("Id", parentId2, "Data"));
  }

  /**
   * Method under test: {@link FlatNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Optional<Object> parentId = Optional.of("42");
    FlatNode<Object, Object> flatNode = new FlatNode<>("Id", parentId, 1);
    Optional<Object> parentId2 = Optional.of("42");

    // Act and Assert
    assertNotEquals(flatNode, new FlatNode<>("Id", parentId2, "Data"));
  }

  /**
   * Method under test: {@link FlatNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Optional<Object> parentId = Optional.of("42");
    FlatNode<Object, Object> flatNode = new FlatNode<>("Id", parentId, "Data");

    // Act and Assert
    assertNotEquals(flatNode, null);
  }

  /**
   * Method under test: {@link FlatNode#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Optional<Object> parentId = Optional.of("42");
    FlatNode<Object, Object> flatNode = new FlatNode<>("Id", parentId, "Data");

    // Act and Assert
    assertNotEquals(flatNode, "Different type to FlatNode");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FlatNode#FlatNode(Object, Optional, Object)}
   *   <li>{@link FlatNode#getData()}
   *   <li>{@link FlatNode#getId()}
   *   <li>{@link FlatNode#getParentId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Optional<Object> parentId = Optional.of("42");

    // Act
    FlatNode<Object, Object> actualFlatNode = new FlatNode<>("Id", parentId, "Data");
    Object actualData = actualFlatNode.getData();
    Object actualId = actualFlatNode.getId();

    // Assert
    assertEquals("Data", actualData);
    assertEquals("Id", actualId);
    assertSame(parentId, actualFlatNode.getParentId());
  }
}
