package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SurveyQuestionDropdownEntryDiffblueTest {
  /**
   * Method under test: {@link SurveyQuestionDropdownEntry#mkEntry(String, int)}
   */
  @Test
  void testMkEntry() {
    // Arrange and Act
    SurveyQuestionDropdownEntry actualMkEntryResult = SurveyQuestionDropdownEntry.mkEntry("42", 1);

    // Assert
    assertTrue(actualMkEntryResult instanceof ImmutableSurveyQuestionDropdownEntry);
    assertEquals("42", actualMkEntryResult.value());
    assertEquals(1, actualMkEntryResult.position());
  }
}
