package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class FilterOperatorDiffblueTest {
  /**
   * Method under test: {@link FilterOperator#parseString(String)}
   */
  @Test
  void testParseString() {
    // Arrange and Act
    Optional<FilterOperator> actualParseStringResult = FilterOperator.parseString("Operator");

    // Assert
    assertFalse(actualParseStringResult.isPresent());
  }

  /**
   * Method under test: {@link FilterOperator#parseString(String)}
   */
  @Test
  void testParseString2() {
    // Arrange and Act
    Optional<FilterOperator> actualParseStringResult = FilterOperator.parseString("CONTAINS_ANY_OPTION");

    // Assert
    assertEquals(FilterOperator.CONTAINS_ANY_OPTION, actualParseStringResult.get());
    assertTrue(actualParseStringResult.isPresent());
  }
}
