package org.finos.waltz.model.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FrequencyKindValueDiffblueTest {
  /**
   * Test {@link FrequencyKindValue#equals(Object)}, and {@link FrequencyKindValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FrequencyKindValue#equals(Object)}
   *   <li>{@link FrequencyKindValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FrequencyKindValue.equals(Object)", "int FrequencyKindValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Test {@link FrequencyKindValue#equals(Object)}, and {@link FrequencyKindValue#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FrequencyKindValue#equals(Object)}
   *   <li>{@link FrequencyKindValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FrequencyKindValue.equals(Object)", "int FrequencyKindValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Test {@link FrequencyKindValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrequencyKindValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FrequencyKindValue.equals(Object)", "int FrequencyKindValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FrequencyKindValue ofResult = FrequencyKindValue.of("Value");

    // Act and Assert
    assertNotEquals(ofResult, FrequencyKindValue.of("42"));
  }

  /**
   * Test {@link FrequencyKindValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrequencyKindValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FrequencyKindValue.equals(Object)", "int FrequencyKindValue.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FrequencyKindValue.of("42"), null);
  }

  /**
   * Test {@link FrequencyKindValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrequencyKindValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FrequencyKindValue.equals(Object)", "int FrequencyKindValue.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FrequencyKindValue.of("42"), "Different type to FrequencyKindValue");
  }

  /**
   * Test {@link FrequencyKindValue#of(String)}.
   * <p>
   * Method under test: {@link FrequencyKindValue#of(String)}
   */
  @Test
  @DisplayName("Test of(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FrequencyKindValue FrequencyKindValue.of(String)"})
  void testOf() {
    // Arrange, Act and Assert
    assertEquals("42", FrequencyKindValue.of("42").value());
  }

  /**
   * Test {@link FrequencyKindValue#value()}.
   * <p>
   * Method under test: {@link FrequencyKindValue#value()}
   */
  @Test
  @DisplayName("Test value()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FrequencyKindValue.value()"})
  void testValue() {
    // Arrange, Act and Assert
    assertEquals("42", FrequencyKindValue.of("42").value());
  }
}
