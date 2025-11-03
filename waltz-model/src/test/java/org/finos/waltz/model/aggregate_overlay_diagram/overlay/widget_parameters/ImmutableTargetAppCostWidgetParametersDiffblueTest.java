package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableTargetAppCostWidgetParameters.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters.ImmutableTargetAppCostWidgetParameters.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTargetAppCostWidgetParametersDiffblueTest {
  /**
   * Test Builder {@link Builder#from(TargetAppCostWidgetParameters)}.
   * <ul>
   *   <li>Then builder build targetDate is {@link LocalDate} with {@code 1970} and one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TargetAppCostWidgetParameters)}
   */
  @Test
  @DisplayName("Test Builder from(TargetAppCostWidgetParameters); then builder build targetDate is LocalDate with '1970' and one and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TargetAppCostWidgetParameters)"})
  void testBuilderFrom_thenBuilderBuildTargetDateIsLocalDateWith1970AndOneAndOne() {
    // Arrange
    Builder builderResult = ImmutableTargetAppCostWidgetParameters.builder();
    TargetAppCostWidgetParameters instance = mock(TargetAppCostWidgetParameters.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.targetDate()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).targetDate();
    assertSame(ofResult, builderResult.build().targetDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#targetDate(LocalDate)}.
   * <ul>
   *   <li>Then builder build targetDate is {@link LocalDate} with {@code 1970} and one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#targetDate(LocalDate)}
   */
  @Test
  @DisplayName("Test Builder targetDate(LocalDate); then builder build targetDate is LocalDate with '1970' and one and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetDate(LocalDate)"})
  void testBuilderTargetDate_thenBuilderBuildTargetDateIsLocalDateWith1970AndOneAndOne() {
    // Arrange
    Builder builderResult = ImmutableTargetAppCostWidgetParameters.builder();
    LocalDate targetDate = LocalDate.of(1970, 1, 1);

    // Act
    Builder actualTargetDateResult = builderResult.targetDate(targetDate);

    // Assert
    assertSame(targetDate, builderResult.build().targetDate());
    assertSame(builderResult, actualTargetDateResult);
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setTargetDate(LocalDate)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setTargetDate(LocalDate)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setTargetDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals("1970-01-01", actualJson.targetDate.toString());
  }

  /**
   * Test Json {@link Json#targetDate()}.
   * <p>
   * Method under test: {@link Json#targetDate()}
   */
  @Test
  @DisplayName("Test Json targetDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDate Json.targetDate()"})
  void testJsonTargetDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).targetDate());
  }
}
