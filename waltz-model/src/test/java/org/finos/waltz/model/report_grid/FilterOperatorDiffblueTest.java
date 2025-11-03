package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FilterOperatorDiffblueTest {
  /**
   * Test {@link FilterOperator#parseString(String)}.
   * <ul>
   *   <li>When {@code CONTAINS_ANY_OPTION}.</li>
   *   <li>Then return {@link Optional#get()} is {@code CONTAINS_ANY_OPTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterOperator#parseString(String)}
   */
  @Test
  @DisplayName("Test parseString(String); when 'CONTAINS_ANY_OPTION'; then return get() is 'CONTAINS_ANY_OPTION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional FilterOperator.parseString(String)"})
  void testParseString_whenContainsAnyOption_thenReturnGetIsContainsAnyOption() {
    // Arrange and Act
    Optional<FilterOperator> actualParseStringResult = FilterOperator.parseString("CONTAINS_ANY_OPTION");

    // Assert
    assertEquals(FilterOperator.CONTAINS_ANY_OPTION, actualParseStringResult.get());
    assertTrue(actualParseStringResult.isPresent());
  }

  /**
   * Test {@link FilterOperator#parseString(String)}.
   * <ul>
   *   <li>When {@code Operator}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterOperator#parseString(String)}
   */
  @Test
  @DisplayName("Test parseString(String); when 'Operator'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional FilterOperator.parseString(String)"})
  void testParseString_whenOperator_thenReturnNotPresent() {
    // Arrange and Act
    Optional<FilterOperator> actualParseStringResult = FilterOperator.parseString("Operator");

    // Assert
    assertFalse(actualParseStringResult.isPresent());
  }
}
