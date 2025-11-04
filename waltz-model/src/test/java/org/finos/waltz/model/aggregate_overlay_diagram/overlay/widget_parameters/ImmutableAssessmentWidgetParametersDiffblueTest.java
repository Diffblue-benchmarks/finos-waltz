package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentWidgetParametersDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentWidgetParameters.Builder#assessmentDefinitionId(Long)}
   */
  @Test
  void testBuilderAssessmentDefinitionId() {
    // Arrange
    ImmutableAssessmentWidgetParameters.Builder builderResult = ImmutableAssessmentWidgetParameters.builder();

    // Act
    ImmutableAssessmentWidgetParameters.Builder actualAssessmentDefinitionIdResult = builderResult
        .assessmentDefinitionId(1L);

    // Assert
    assertEquals(1L, actualAssessmentDefinitionIdResult.build().assessmentDefinitionId().longValue());
    assertEquals(1L, builderResult.build().assessmentDefinitionId().longValue());
    assertSame(builderResult, actualAssessmentDefinitionIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentWidgetParameters.Builder#from(AssessmentWidgetParameters)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentWidgetParameters.Builder builderResult = ImmutableAssessmentWidgetParameters.builder();
    AssessmentWidgetParameters instance = mock(AssessmentWidgetParameters.class);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.targetDate()).thenReturn(ofResult);

    // Act
    ImmutableAssessmentWidgetParameters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitionId();
    verify(instance).targetDate();
    assertEquals(1L, actualFromResult.build().assessmentDefinitionId().longValue());
    assertEquals(1L, builderResult.build().assessmentDefinitionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentWidgetParameters.Builder#from(AssessmentWidgetParameters)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentWidgetParameters.Builder builderResult = ImmutableAssessmentWidgetParameters.builder();
    AssessmentWidgetParameters instance = mock(AssessmentWidgetParameters.class);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.targetDate()).thenReturn(emptyResult);

    // Act
    ImmutableAssessmentWidgetParameters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitionId();
    verify(instance).targetDate();
    assertEquals(1L, actualFromResult.build().assessmentDefinitionId().longValue());
    assertEquals(1L, builderResult.build().assessmentDefinitionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentWidgetParameters#copyOf(AssessmentWidgetParameters)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentWidgetParameters instance = mock(AssessmentWidgetParameters.class);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.targetDate()).thenReturn(ofResult);

    // Act
    ImmutableAssessmentWidgetParameters actualCopyOfResult = ImmutableAssessmentWidgetParameters.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitionId();
    verify(instance).targetDate();
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentWidgetParameters#copyOf(AssessmentWidgetParameters)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AssessmentWidgetParameters instance = mock(AssessmentWidgetParameters.class);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.targetDate()).thenReturn(emptyResult);

    // Act
    ImmutableAssessmentWidgetParameters actualCopyOfResult = ImmutableAssessmentWidgetParameters.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinitionId();
    verify(instance).targetDate();
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentWidgetParameters#fromJson(ImmutableAssessmentWidgetParameters.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAssessmentWidgetParameters.Json json = new ImmutableAssessmentWidgetParameters.Json();
    json.setAssessmentDefinitionId(1L);
    json.setTargetDate(null);

    // Act and Assert
    assertEquals(1L, ImmutableAssessmentWidgetParameters.fromJson(json).assessmentDefinitionId().longValue());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentWidgetParameters.Json#assessmentDefinitionId()}
   */
  @Test
  void testJsonAssessmentDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentWidgetParameters.Json()).assessmentDefinitionId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentWidgetParameters.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentWidgetParameters.Json actualJson = new ImmutableAssessmentWidgetParameters.Json();

    // Assert
    assertNull(actualJson.assessmentDefinitionId);
    assertFalse(actualJson.targetDate.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentWidgetParameters.Json#targetDate()}
   */
  @Test
  void testJsonTargetDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentWidgetParameters.Json()).targetDate());
  }
}
