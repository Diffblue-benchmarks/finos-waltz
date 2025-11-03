package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.survey.ImmutableSurveyRunStatusChangeCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyRunStatusChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyRunStatusChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(SurveyRunStatusChangeCommand)}.
   * <ul>
   *   <li>Given {@code DRAFT}.</li>
   *   <li>Then builder build newStatus is {@code DRAFT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyRunStatusChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyRunStatusChangeCommand); given 'DRAFT'; then builder build newStatus is 'DRAFT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyRunStatusChangeCommand)"})
  void testBuilderFrom_givenDraft_thenBuilderBuildNewStatusIsDraft() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunStatusChangeCommand.builder();
    SurveyRunStatusChangeCommand instance = mock(SurveyRunStatusChangeCommand.class);
    when(instance.newStatus()).thenReturn(SurveyRunStatus.DRAFT);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newStatus();
    assertEquals(SurveyRunStatus.DRAFT, builderResult.build().newStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newStatus(SurveyRunStatus)}.
   * <p>
   * Method under test: {@link Builder#newStatus(SurveyRunStatus)}
   */
  @Test
  @DisplayName("Test Builder newStatus(SurveyRunStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.newStatus(SurveyRunStatus)"})
  void testBuilderNewStatus() {
    // Arrange
    Builder builderResult = ImmutableSurveyRunStatusChangeCommand.builder();

    // Act
    Builder actualNewStatusResult = builderResult.newStatus(SurveyRunStatus.DRAFT);

    // Assert
    assertEquals(SurveyRunStatus.DRAFT, builderResult.build().newStatus());
    assertSame(builderResult, actualNewStatusResult);
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setNewStatus(SurveyRunStatus)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setNewStatus(SurveyRunStatus)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setNewStatus(SurveyRunStatus.DRAFT);

    // Assert
    assertEquals(SurveyRunStatus.DRAFT, actualJson.newStatus);
  }

  /**
   * Test Json {@link Json#newStatus()}.
   * <p>
   * Method under test: {@link Json#newStatus()}
   */
  @Test
  @DisplayName("Test Json newStatus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyRunStatus Json.newStatus()"})
  void testJsonNewStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).newStatus());
  }
}
