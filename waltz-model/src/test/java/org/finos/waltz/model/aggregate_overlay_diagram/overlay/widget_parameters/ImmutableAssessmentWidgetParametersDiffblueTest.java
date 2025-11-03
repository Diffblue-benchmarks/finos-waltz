package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAssessmentWidgetParameters.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableAssessmentWidgetParameters.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentWidgetParametersDiffblueTest {
  /**
   * Test {@link ImmutableAssessmentWidgetParameters#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentWidgetParameters#builder()}
   *   <li>{@link ImmutableAssessmentWidgetParameters#targetDate(LocalDate)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentWidgetParameters Builder.build()", "Builder Builder.targetDate(LocalDate)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAssessmentWidgetParameters.builder();
    Builder actualTargetDateResult = actualBuilderResult.targetDate(LocalDate.of(1970, 1, 1));
    Optional<? extends LocalDate> targetDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Assert
    assertSame(actualTargetDateResult, actualTargetDateResult.targetDate(targetDate));
  }

  /**
   * Test Builder {@link Builder#assessmentDefinitionId(Long)}.
   * <p>
   * Method under test: {@link Builder#assessmentDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test Builder assessmentDefinitionId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessmentDefinitionId(Long)"})
  void testBuilderAssessmentDefinitionId() {
    // Arrange
    Builder builderResult = ImmutableAssessmentWidgetParameters.builder();

    // Act
    Builder actualAssessmentDefinitionIdResult = builderResult.assessmentDefinitionId(1L);

    // Assert
    assertEquals(1L, builderResult.build().assessmentDefinitionId().longValue());
    assertSame(builderResult, actualAssessmentDefinitionIdResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentWidgetParameters)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link AssessmentWidgetParameters} {@link AssessmentWidgetParameters#targetDate()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentWidgetParameters)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentWidgetParameters); given empty; when AssessmentWidgetParameters targetDate() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentWidgetParameters)"})
  void testBuilderFrom_givenEmpty_whenAssessmentWidgetParametersTargetDateReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentWidgetParameters.builder();
    AssessmentWidgetParameters instance = mock(AssessmentWidgetParameters.class);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    Optional<LocalDate> emptyResult = Optional.empty();
    when(instance.targetDate()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitionId();
    verify(instance).targetDate();
    assertEquals(1L, builderResult.build().assessmentDefinitionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentWidgetParameters)}.
   * <ul>
   *   <li>Given {@link LocalDate} with {@code 1970} and one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentWidgetParameters)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentWidgetParameters); given LocalDate with '1970' and one and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentWidgetParameters)"})
  void testBuilderFrom_givenLocalDateWith1970AndOneAndOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentWidgetParameters.builder();
    AssessmentWidgetParameters instance = mock(AssessmentWidgetParameters.class);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(instance.targetDate()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitionId();
    verify(instance).targetDate();
    assertEquals(1L, builderResult.build().assessmentDefinitionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#targetDate(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#targetDate(Optional)}
   */
  @Test
  @DisplayName("Test Builder targetDate(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetDate(Optional)"})
  void testBuilderTargetDateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAssessmentWidgetParameters.builder();
    Optional<? extends LocalDate> targetDate = Optional.of(LocalDate.of(1970, 1, 1));

    // Act and Assert
    assertSame(builderResult, builderResult.targetDate(targetDate));
  }

  /**
   * Test Json {@link Json#assessmentDefinitionId()}.
   * <p>
   * Method under test: {@link Json#assessmentDefinitionId()}
   */
  @Test
  @DisplayName("Test Json assessmentDefinitionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.assessmentDefinitionId()"})
  void testJsonAssessmentDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assessmentDefinitionId());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.assessmentDefinitionId);
    assertFalse(actualJson.targetDate.isPresent());
  }

  /**
   * Test Json {@link Json#targetDate()}.
   * <p>
   * Method under test: {@link Json#targetDate()}
   */
  @Test
  @DisplayName("Test Json targetDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.targetDate()"})
  void testJsonTargetDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).targetDate());
  }
}
