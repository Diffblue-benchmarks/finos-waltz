package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class ImmutableAppChangeWidgetParametersDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAppChangeWidgetParameters.Builder#from(AppChangeWidgetParameters)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAppChangeWidgetParameters.Builder builderResult = ImmutableAppChangeWidgetParameters.builder();
    AppChangeWidgetParameters instance = mock(AppChangeWidgetParameters.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.targetDate()).thenReturn(ofResult);

    // Act
    ImmutableAppChangeWidgetParameters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).targetDate();
    assertSame(ofResult, builderResult.build().targetDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeWidgetParameters.Builder#targetDate(LocalDate)}
   */
  @Test
  void testBuilderTargetDate() {
    // Arrange
    ImmutableAppChangeWidgetParameters.Builder builderResult = ImmutableAppChangeWidgetParameters.builder();
    LocalDate targetDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAppChangeWidgetParameters.Builder actualTargetDateResult = builderResult.targetDate(targetDate);

    // Assert
    assertSame(targetDate, builderResult.build().targetDate());
    assertSame(builderResult, actualTargetDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeWidgetParameters#copyOf(AppChangeWidgetParameters)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AppChangeWidgetParameters instance = mock(AppChangeWidgetParameters.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.targetDate()).thenReturn(ofResult);

    // Act
    ImmutableAppChangeWidgetParameters actualCopyOfResult = ImmutableAppChangeWidgetParameters.copyOf(instance);

    // Assert
    verify(instance).targetDate();
    LocalDate targetDateResult = actualCopyOfResult.targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertSame(ofResult, targetDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeWidgetParameters#fromJson(ImmutableAppChangeWidgetParameters.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAppChangeWidgetParameters.Json json = new ImmutableAppChangeWidgetParameters.Json();
    LocalDate targetDate = LocalDate.of(1970, 1, 1);
    json.setTargetDate(targetDate);

    // Act and Assert
    LocalDate targetDateResult = ImmutableAppChangeWidgetParameters.fromJson(json).targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertSame(targetDate, targetDateResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAppChangeWidgetParameters.Json}
   *   <li>{@link ImmutableAppChangeWidgetParameters.Json#setTargetDate(LocalDate)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAppChangeWidgetParameters.Json actualJson = new ImmutableAppChangeWidgetParameters.Json();
    actualJson.setTargetDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals("1970-01-01", actualJson.targetDate.toString());
  }

  /**
   * Method under test:
   * {@link ImmutableAppChangeWidgetParameters.Json#targetDate()}
   */
  @Test
  void testJsonTargetDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAppChangeWidgetParameters.Json()).targetDate());
  }
}
