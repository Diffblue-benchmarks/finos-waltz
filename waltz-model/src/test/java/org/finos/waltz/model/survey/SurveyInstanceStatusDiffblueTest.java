package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SurveyInstanceStatusDiffblueTest {
  /**
   * Test {@link SurveyInstanceStatus#prettyName()}.
   *
   * <p>Method under test: {@link SurveyInstanceStatus#prettyName()}
   */
  @Test
  @DisplayName("Test prettyName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SurveyInstanceStatus.prettyName()"})
  void testPrettyName() {
    // Arrange, Act and Assert
    assertEquals("Not Started", SurveyInstanceStatus.valueOf("NOT_STARTED").prettyName());
  }
}
