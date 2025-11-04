package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableSurveyRunStatusChangeCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyRunStatusChangeCommand.Builder#from(SurveyRunStatusChangeCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyRunStatusChangeCommand.Builder builderResult = ImmutableSurveyRunStatusChangeCommand.builder();
    SurveyRunStatusChangeCommand instance = mock(SurveyRunStatusChangeCommand.class);
    when(instance.newStatus()).thenReturn(SurveyRunStatus.DRAFT);

    // Act
    ImmutableSurveyRunStatusChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newStatus();
    assertEquals(SurveyRunStatus.DRAFT, actualFromResult.build().newStatus());
    assertEquals(SurveyRunStatus.DRAFT, builderResult.build().newStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunStatusChangeCommand.Builder#newStatus(SurveyRunStatus)}
   */
  @Test
  void testBuilderNewStatus() {
    // Arrange
    ImmutableSurveyRunStatusChangeCommand.Builder builderResult = ImmutableSurveyRunStatusChangeCommand.builder();

    // Act
    ImmutableSurveyRunStatusChangeCommand.Builder actualNewStatusResult = builderResult
        .newStatus(SurveyRunStatus.DRAFT);

    // Assert
    assertEquals(SurveyRunStatus.DRAFT, actualNewStatusResult.build().newStatus());
    assertEquals(SurveyRunStatus.DRAFT, builderResult.build().newStatus());
    assertSame(builderResult, actualNewStatusResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunStatusChangeCommand#copyOf(SurveyRunStatusChangeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyRunStatusChangeCommand instance = mock(SurveyRunStatusChangeCommand.class);
    when(instance.newStatus()).thenReturn(SurveyRunStatus.DRAFT);

    // Act
    ImmutableSurveyRunStatusChangeCommand actualCopyOfResult = ImmutableSurveyRunStatusChangeCommand.copyOf(instance);

    // Assert
    verify(instance).newStatus();
    assertEquals(SurveyRunStatus.DRAFT, actualCopyOfResult.newStatus());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunStatusChangeCommand#fromJson(ImmutableSurveyRunStatusChangeCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyRunStatusChangeCommand.Json json = new ImmutableSurveyRunStatusChangeCommand.Json();
    json.setNewStatus(SurveyRunStatus.DRAFT);

    // Act and Assert
    assertEquals(SurveyRunStatus.DRAFT, ImmutableSurveyRunStatusChangeCommand.fromJson(json).newStatus());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSurveyRunStatusChangeCommand.Json}
   *   <li>
   * {@link ImmutableSurveyRunStatusChangeCommand.Json#setNewStatus(SurveyRunStatus)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSurveyRunStatusChangeCommand.Json actualJson = new ImmutableSurveyRunStatusChangeCommand.Json();
    actualJson.setNewStatus(SurveyRunStatus.DRAFT);

    // Assert
    assertEquals(SurveyRunStatus.DRAFT, actualJson.newStatus);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyRunStatusChangeCommand.Json#newStatus()}
   */
  @Test
  void testJsonNewStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyRunStatusChangeCommand.Json()).newStatus());
  }
}
