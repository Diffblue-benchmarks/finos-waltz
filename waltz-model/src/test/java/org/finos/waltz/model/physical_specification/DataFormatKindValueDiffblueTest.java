package org.finos.waltz.model.physical_specification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class DataFormatKindValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataFormatKindValue#equals(Object)}
   *   <li>{@link DataFormatKindValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DataFormatKindValue ofResult = DataFormatKindValue.of("42");
    DataFormatKindValue ofResult2 = DataFormatKindValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DataFormatKindValue#equals(Object)}
   *   <li>{@link DataFormatKindValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DataFormatKindValue ofResult = DataFormatKindValue.of("42");

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Method under test: {@link DataFormatKindValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DataFormatKindValue ofResult = DataFormatKindValue.of("Value");

    // Act and Assert
    assertNotEquals(ofResult, DataFormatKindValue.of("42"));
  }

  /**
   * Method under test: {@link DataFormatKindValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataFormatKindValue.of("42"), null);
  }

  /**
   * Method under test: {@link DataFormatKindValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataFormatKindValue.of("42"), "Different type to DataFormatKindValue");
  }

  /**
   * Method under test: {@link DataFormatKindValue#of(String)}
   */
  @Test
  void testOf() {
    // Arrange, Act and Assert
    assertEquals("42", DataFormatKindValue.of("42").value());
  }

  /**
   * Method under test: {@link DataFormatKindValue#value()}
   */
  @Test
  void testValue() {
    // Arrange, Act and Assert
    assertEquals("42", DataFormatKindValue.of("42").value());
  }
}
