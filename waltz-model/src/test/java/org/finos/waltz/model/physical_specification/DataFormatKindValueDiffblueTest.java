package org.finos.waltz.model.physical_specification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataFormatKindValueDiffblueTest {
  /**
   * Test {@link DataFormatKindValue#equals(Object)}, and {@link DataFormatKindValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DataFormatKindValue#equals(Object)}
   *   <li>{@link DataFormatKindValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataFormatKindValue.equals(Object)",
    "int DataFormatKindValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DataFormatKindValue ofResult = DataFormatKindValue.of("42");
    DataFormatKindValue ofResult2 = DataFormatKindValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link DataFormatKindValue#equals(Object)}, and {@link DataFormatKindValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DataFormatKindValue#equals(Object)}
   *   <li>{@link DataFormatKindValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataFormatKindValue.equals(Object)",
    "int DataFormatKindValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DataFormatKindValue ofResult = DataFormatKindValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Test {@link DataFormatKindValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DataFormatKindValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataFormatKindValue.equals(Object)",
    "int DataFormatKindValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataFormatKindValue.of("42"), 1);
  }

  /**
   * Test {@link DataFormatKindValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DataFormatKindValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataFormatKindValue.equals(Object)",
    "int DataFormatKindValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DataFormatKindValue ofResult = DataFormatKindValue.of("Value");

    // Act and Assert
    assertNotEquals(ofResult, DataFormatKindValue.of("42"));
  }

  /**
   * Test {@link DataFormatKindValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DataFormatKindValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataFormatKindValue.equals(Object)",
    "int DataFormatKindValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataFormatKindValue.of("42"), null);
  }

  /**
   * Test {@link DataFormatKindValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DataFormatKindValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataFormatKindValue.equals(Object)",
    "int DataFormatKindValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataFormatKindValue.of("42"), "Different type to DataFormatKindValue");
  }

  /**
   * Test {@link DataFormatKindValue#of(String)}.
   *
   * <p>Method under test: {@link DataFormatKindValue#of(String)}
   */
  @Test
  @DisplayName("Test of(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataFormatKindValue DataFormatKindValue.of(String)"})
  void testOf() {
    // Arrange, Act and Assert
    assertEquals("42", DataFormatKindValue.of("42").value());
  }

  /**
   * Test {@link DataFormatKindValue#value()}.
   *
   * <p>Method under test: {@link DataFormatKindValue#value()}
   */
  @Test
  @DisplayName("Test value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataFormatKindValue.value()"})
  void testValue() {
    // Arrange, Act and Assert
    assertEquals("42", DataFormatKindValue.of("42").value());
  }
}
