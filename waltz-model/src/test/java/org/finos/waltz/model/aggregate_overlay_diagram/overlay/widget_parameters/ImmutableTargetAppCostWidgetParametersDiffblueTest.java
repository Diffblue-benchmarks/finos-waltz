package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class ImmutableTargetAppCostWidgetParametersDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableTargetAppCostWidgetParameters.Builder#from(TargetAppCostWidgetParameters)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableTargetAppCostWidgetParameters.Builder builderResult = ImmutableTargetAppCostWidgetParameters.builder();
    TargetAppCostWidgetParameters instance = mock(TargetAppCostWidgetParameters.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.targetDate()).thenReturn(ofResult);

    // Act
    ImmutableTargetAppCostWidgetParameters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).targetDate();
    assertSame(ofResult, builderResult.build().targetDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTargetAppCostWidgetParameters.Builder#targetDate(LocalDate)}
   */
  @Test
  void testBuilderTargetDate() {
    // Arrange
    ImmutableTargetAppCostWidgetParameters.Builder builderResult = ImmutableTargetAppCostWidgetParameters.builder();
    LocalDate targetDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableTargetAppCostWidgetParameters.Builder actualTargetDateResult = builderResult.targetDate(targetDate);

    // Assert
    assertSame(targetDate, builderResult.build().targetDate());
    assertSame(builderResult, actualTargetDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTargetAppCostWidgetParameters#copyOf(TargetAppCostWidgetParameters)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    TargetAppCostWidgetParameters instance = mock(TargetAppCostWidgetParameters.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.targetDate()).thenReturn(ofResult);

    // Act
    ImmutableTargetAppCostWidgetParameters actualCopyOfResult = ImmutableTargetAppCostWidgetParameters.copyOf(instance);

    // Assert
    verify(instance).targetDate();
    LocalDate targetDateResult = actualCopyOfResult.targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertSame(ofResult, targetDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTargetAppCostWidgetParameters#fromJson(ImmutableTargetAppCostWidgetParameters.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableTargetAppCostWidgetParameters.Json json = new ImmutableTargetAppCostWidgetParameters.Json();
    LocalDate targetDate = LocalDate.of(1970, 1, 1);
    json.setTargetDate(targetDate);

    // Act and Assert
    LocalDate targetDateResult = ImmutableTargetAppCostWidgetParameters.fromJson(json).targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertSame(targetDate, targetDateResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableTargetAppCostWidgetParameters.Json}
   *   <li>
   * {@link ImmutableTargetAppCostWidgetParameters.Json#setTargetDate(LocalDate)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableTargetAppCostWidgetParameters.Json actualJson = new ImmutableTargetAppCostWidgetParameters.Json();
    actualJson.setTargetDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals("1970-01-01", actualJson.targetDate.toString());
  }

  /**
   * Method under test:
   * {@link ImmutableTargetAppCostWidgetParameters.Json#targetDate()}
   */
  @Test
  void testJsonTargetDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableTargetAppCostWidgetParameters.Json()).targetDate());
  }
}
