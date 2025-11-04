package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class SurveyInstanceActionDiffblueTest {
  /**
   * Method under test: {@link SurveyInstanceAction#findByDisplay(String)}
   */
  @Test
  void testFindByDisplay() {
    // Arrange, Act and Assert
    assertNull(SurveyInstanceAction.findByDisplay("Display"));
    assertEquals(SurveyInstanceAction.APPROVING, SurveyInstanceAction.findByDisplay("Approve"));
  }

  /**
   * Method under test: {@link SurveyInstanceAction#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("SUBMITTING", SurveyInstanceAction.SUBMITTING.getName());
  }

  /**
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
}
