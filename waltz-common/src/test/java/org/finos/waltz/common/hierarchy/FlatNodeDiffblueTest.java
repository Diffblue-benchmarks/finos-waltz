package org.finos.waltz.common.hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlatNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FlatNode#FlatNode(Object, Optional, Object)}
   *   <li>{@link FlatNode#getData()}
   *   <li>{@link FlatNode#getId()}
   *   <li>{@link FlatNode#getParentId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FlatNode.<init>(Object, Optional, Object)",
    "Object FlatNode.getData()",
    "Object FlatNode.getId()",
    "Optional FlatNode.getParentId()"
  })
  void testGettersAndSetters() {
    // Arrange
    Optional<Object> parentId = Optional.of("Value");

    // Act
    FlatNode<Object, Object> actualFlatNode = new FlatNode<>("Id", parentId, "Data");
    Object actualData = actualFlatNode.getData();
    Object actualId = actualFlatNode.getId();

    // Assert
    assertEquals("Data", actualData);
    assertEquals("Id", actualId);
    assertSame(parentId, actualFlatNode.getParentId());
  }

  /**
   * Test {@link FlatNode#equals(Object)}, and {@link FlatNode#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FlatNode#equals(Object)}
   *   <li>{@link FlatNode#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlatNode.equals(Object)", "int FlatNode.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Optional<Object> parentId = Optional.of("Value");
    FlatNode<Object, Object> flatNode = new FlatNode<>("Id", parentId, "Data");
    Optional<Object> parentId2 = Optional.of("Value");
    FlatNode<Object, Object> flatNode2 = new FlatNode<>("Id", parentId2, "Data");

    // Act and Assert
    assertEquals(flatNode, flatNode2);
    assertEquals(flatNode.hashCode(), flatNode2.hashCode());
  }

  /**
   * Test {@link FlatNode#equals(Object)}, and {@link FlatNode#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FlatNode#equals(Object)}
   *   <li>{@link FlatNode#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlatNode.equals(Object)", "int FlatNode.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Optional<Object> parentId = Optional.of("Value");
    FlatNode<Object, Object> flatNode = new FlatNode<>("Id", parentId, "Data");

    // Act and Assert
    assertEquals(flatNode, flatNode);
    int expectedHashCodeResult = flatNode.hashCode();
    assertEquals(expectedHashCodeResult, flatNode.hashCode());
  }

  /**
   * Test {@link FlatNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FlatNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlatNode.equals(Object)", "int FlatNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Optional<Object> parentId = Optional.of("Value");
    FlatNode<Object, Object> flatNode = new FlatNode<>(1, parentId, "Data");
    Optional<Object> parentId2 = Optional.of("Value");

    // Act and Assert
    assertNotEquals(flatNode, new FlatNode<>("Id", parentId2, "Data"));
  }

  /**
   * Test {@link FlatNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FlatNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlatNode.equals(Object)", "int FlatNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Optional<Object> parentId = Optional.of("Value");
    FlatNode<Object, Object> flatNode = new FlatNode<>("Id", parentId, "Data");
    Optional<Object> parentId2 = Optional.of("Value");

    FlatNode<Object, Object> flatNode2 = new FlatNode<>(flatNode, parentId2, "Data");
    Optional<Object> parentId3 = Optional.of("Value");

    // Act and Assert
    assertNotEquals(flatNode2, new FlatNode<>("Id", parentId3, "Data"));
  }

  /**
   * Test {@link FlatNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FlatNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlatNode.equals(Object)", "int FlatNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Optional<Object> parentId = Optional.of("Value");
    FlatNode<Object, Object> flatNode = new FlatNode<>("Id", parentId, 1);
    Optional<Object> parentId2 = Optional.of("Value");

    // Act and Assert
    assertNotEquals(flatNode, new FlatNode<>("Id", parentId2, "Data"));
  }

  /**
   * Test {@link FlatNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FlatNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlatNode.equals(Object)", "int FlatNode.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Optional<Object> parentId = Optional.of("Value");
    Optional<Object> parentId2 = Optional.of("Value");
    FlatNode<Object, Object> flatNode = new FlatNode<>("Id", parentId2, "Data");

    FlatNode<Object, Object> flatNode2 = new FlatNode<>("Id", parentId, flatNode);
    Optional<Object> parentId3 = Optional.of("Value");

    // Act and Assert
    assertNotEquals(flatNode2, new FlatNode<>("Id", parentId3, "Data"));
  }

  /**
   * Test {@link FlatNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FlatNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlatNode.equals(Object)", "int FlatNode.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Optional<Object> parentId = Optional.of("Value");
    FlatNode<Object, Object> flatNode = new FlatNode<>("Id", parentId, "Data");

    // Act and Assert
    assertNotEquals(flatNode, null);
  }

  /**
   * Test {@link FlatNode#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FlatNode#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlatNode.equals(Object)", "int FlatNode.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Optional<Object> parentId = Optional.of("Value");
    FlatNode<Object, Object> flatNode = new FlatNode<>("Id", parentId, "Data");

    // Act and Assert
    assertNotEquals(flatNode, "Different type to FlatNode");
  }
}
