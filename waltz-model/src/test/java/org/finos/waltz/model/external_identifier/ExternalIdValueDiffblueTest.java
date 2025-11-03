package org.finos.waltz.model.external_identifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExternalIdValueDiffblueTest {
  /**
   * Test {@link ExternalIdValue#equals(Object)}, and {@link ExternalIdValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExternalIdValue#equals(Object)}
   *   <li>{@link ExternalIdValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExternalIdValue.equals(Object)", "int ExternalIdValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExternalIdValue ofResult = ExternalIdValue.of("42");
    ExternalIdValue ofResult2 = ExternalIdValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Test {@link ExternalIdValue#equals(Object)}, and {@link ExternalIdValue#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExternalIdValue#equals(Object)}
   *   <li>{@link ExternalIdValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExternalIdValue.equals(Object)", "int ExternalIdValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExternalIdValue ofResult = ExternalIdValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Test {@link ExternalIdValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExternalIdValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExternalIdValue.equals(Object)", "int ExternalIdValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExternalIdValue ofResult = ExternalIdValue.of("Value");

    // Act and Assert
    assertNotEquals(ofResult, ExternalIdValue.of("42"));
  }

  /**
   * Test {@link ExternalIdValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExternalIdValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExternalIdValue.equals(Object)", "int ExternalIdValue.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExternalIdValue.of("42"), null);
  }

  /**
   * Test {@link ExternalIdValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExternalIdValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ExternalIdValue.equals(Object)", "int ExternalIdValue.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ExternalIdValue.of("42"), "Different type to ExternalIdValue");
  }

  /**
   * Test {@link ExternalIdValue#of(String)}.
   * <p>
   * Method under test: {@link ExternalIdValue#of(String)}
   */
  @Test
  @DisplayName("Test of(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExternalIdValue ExternalIdValue.of(String)"})
  void testOf() {
    // Arrange, Act and Assert
    assertEquals("42", ExternalIdValue.of("42").value());
  }

  /**
   * Test {@link ExternalIdValue#value()}.
   * <p>
   * Method under test: {@link ExternalIdValue#value()}
   */
  @Test
  @DisplayName("Test value()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExternalIdValue.value()"})
  void testValue() {
    // Arrange, Act and Assert
    assertEquals("42", ExternalIdValue.of("42").value());
  }
}
