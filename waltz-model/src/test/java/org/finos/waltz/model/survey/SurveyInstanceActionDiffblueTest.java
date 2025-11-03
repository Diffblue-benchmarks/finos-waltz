package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SurveyInstanceActionDiffblueTest {
  /**
   * Test {@link SurveyInstanceAction#getName()}.
   * <p>
   * Method under test: {@link SurveyInstanceAction#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SurveyInstanceAction.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("SUBMITTING", SurveyInstanceAction.SUBMITTING.getName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SurveyInstanceAction#getAvailability()}
   *   <li>{@link SurveyInstanceAction#getCompletionRequirement()}
   *   <li>{@link SurveyInstanceAction#getConfirmationRequirement()}
   *   <li>{@link SurveyInstanceAction#getDescription()}
   *   <li>{@link SurveyInstanceAction#getDisplay()}
   *   <li>{@link SurveyInstanceAction#getIcon()}
   *   <li>{@link SurveyInstanceAction#getStyle()}
   *   <li>{@link SurveyInstanceAction#getVerb()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyInstanceActionAvailability SurveyInstanceAction.getAvailability()",
      "SurveyInstanceActionCompletionRequirement SurveyInstanceAction.getCompletionRequirement()",
      "SurveyInstanceActionConfirmationRequirement SurveyInstanceAction.getConfirmationRequirement()",
      "String SurveyInstanceAction.getDescription()", "String SurveyInstanceAction.getDisplay()",
      "String SurveyInstanceAction.getIcon()", "String SurveyInstanceAction.getStyle()",
      "String SurveyInstanceAction.getVerb()"})
  void testGettersAndSetters() {
    // Arrange
    SurveyInstanceAction valueOfResult = SurveyInstanceAction.valueOf("SUBMITTING");

    // Act
    SurveyInstanceActionAvailability actualAvailability = valueOfResult.getAvailability();
    SurveyInstanceActionCompletionRequirement actualCompletionRequirement = valueOfResult.getCompletionRequirement();
    SurveyInstanceActionConfirmationRequirement actualConfirmationRequirement = valueOfResult
        .getConfirmationRequirement();
    String actualDescription = valueOfResult.getDescription();
    String actualDisplay = valueOfResult.getDisplay();
    String actualIcon = valueOfResult.getIcon();
    String actualStyle = valueOfResult.getStyle();

    // Assert
    assertEquals("Submit this survey for an owner to review", actualDescription);
    assertEquals("Submit", actualDisplay);
    assertEquals("cloud-upload", actualIcon);
    assertEquals("submitted", valueOfResult.getVerb());
    assertEquals("success", actualStyle);
    assertEquals(SurveyInstanceActionAvailability.EDIT_AND_VIEW, actualAvailability);
    assertEquals(SurveyInstanceActionCompletionRequirement.REQUIRE_FULL_COMPLETION, actualCompletionRequirement);
    assertEquals(SurveyInstanceActionConfirmationRequirement.CONFIRM_AND_COMMENT_REQUIRED,
        actualConfirmationRequirement);
  }

  /**
   * Test {@link SurveyInstanceAction#findByDisplay(String)}.
   * <ul>
   *   <li>When {@code Approve}.</li>
   *   <li>Then return {@code APPROVING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SurveyInstanceAction#findByDisplay(String)}
   */
  @Test
  @DisplayName("Test findByDisplay(String); when 'Approve'; then return 'APPROVING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyInstanceAction SurveyInstanceAction.findByDisplay(String)"})
  void testFindByDisplay_whenApprove_thenReturnApproving() {
    // Arrange, Act and Assert
    assertEquals(SurveyInstanceAction.APPROVING, SurveyInstanceAction.findByDisplay("Approve"));
  }

  /**
   * Test {@link SurveyInstanceAction#findByDisplay(String)}.
   * <ul>
   *   <li>When {@code Display}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SurveyInstanceAction#findByDisplay(String)}
   */
  @Test
  @DisplayName("Test findByDisplay(String); when 'Display'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyInstanceAction SurveyInstanceAction.findByDisplay(String)"})
  void testFindByDisplay_whenDisplay_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(SurveyInstanceAction.findByDisplay("Display"));
  }
}
