package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CopySurveyResponsesCommandDiffblueTest {
  /**
   * Test {@link CopySurveyResponsesCommand#overrideExistingResponses()}.
   *
   * <ul>
   *   <li>Given builder build.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CopySurveyResponsesCommand#overrideExistingResponses()}
   */
  @Test
  @DisplayName("Test overrideExistingResponses(); given builder build; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CopySurveyResponsesCommand.overrideExistingResponses()"})
  void testOverrideExistingResponses_givenBuilderBuild_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImmutableCopySurveyResponsesCommand.builder().build().overrideExistingResponses());
  }
}
