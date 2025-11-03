package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TransportKindValueDiffblueTest {
  /**
   * Test {@link TransportKindValue#equals(Object)}, and {@link TransportKindValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportKindValue#equals(Object)}
   *   <li>{@link TransportKindValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportKindValue.equals(Object)", "int TransportKindValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportKindValue ofResult = TransportKindValue.of("42");
    TransportKindValue ofResult2 = TransportKindValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Test {@link TransportKindValue#equals(Object)}, and {@link TransportKindValue#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportKindValue#equals(Object)}
   *   <li>{@link TransportKindValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportKindValue.equals(Object)", "int TransportKindValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportKindValue ofResult = TransportKindValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Test {@link TransportKindValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportKindValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportKindValue.equals(Object)", "int TransportKindValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TransportKindValue ofResult = TransportKindValue.of("Value");

    // Act and Assert
    assertNotEquals(ofResult, TransportKindValue.of("42"));
  }

  /**
   * Test {@link TransportKindValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportKindValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportKindValue.equals(Object)", "int TransportKindValue.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportKindValue.of("42"), null);
  }

  /**
   * Test {@link TransportKindValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TransportKindValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TransportKindValue.equals(Object)", "int TransportKindValue.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportKindValue.of("42"), "Different type to TransportKindValue");
  }

  /**
   * Test {@link TransportKindValue#of(String)}.
   * <p>
   * Method under test: {@link TransportKindValue#of(String)}
   */
  @Test
  @DisplayName("Test of(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportKindValue TransportKindValue.of(String)"})
  void testOf() {
    // Arrange, Act and Assert
    assertEquals("42", TransportKindValue.of("42").value());
  }

  /**
   * Test {@link TransportKindValue#value()}.
   * <p>
   * Method under test: {@link TransportKindValue#value()}
   */
  @Test
  @DisplayName("Test value()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TransportKindValue.value()"})
  void testValue() {
    // Arrange, Act and Assert
    assertEquals("42", TransportKindValue.of("42").value());
  }
}
