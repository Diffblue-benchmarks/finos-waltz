package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SurveyQuestionDropdownEntryDiffblueTest {
  /**
   * Test {@link SurveyQuestionDropdownEntry#mkEntry(String, int)}.
   *
   * <p>Method under test: {@link SurveyQuestionDropdownEntry#mkEntry(String, int)}
   */
  @Test
  @DisplayName("Test mkEntry(String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SurveyQuestionDropdownEntry SurveyQuestionDropdownEntry.mkEntry(String, int)"
  })
  void testMkEntry() {
    // Arrange and Act
    SurveyQuestionDropdownEntry actualMkEntryResult = SurveyQuestionDropdownEntry.mkEntry("42", 1);

    // Assert
    assertTrue(actualMkEntryResult instanceof ImmutableSurveyQuestionDropdownEntry);
    assertEquals("42", actualMkEntryResult.value());
    assertEquals(1, actualMkEntryResult.position());
  }
}
