package org.finos.waltz.model.aggregate_overlay_diagram.overlay.widget_parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class ImmutableAppCountWidgetParametersDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAppCountWidgetParameters.Builder#from(AppCountWidgetParameters)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAppCountWidgetParameters.Builder builderResult = ImmutableAppCountWidgetParameters.builder();
    AppCountWidgetParameters instance = mock(AppCountWidgetParameters.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.targetDate()).thenReturn(ofResult);

    // Act
    ImmutableAppCountWidgetParameters.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).targetDate();
    assertSame(ofResult, builderResult.build().targetDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppCountWidgetParameters.Builder#targetDate(LocalDate)}
   */
  @Test
  void testBuilderTargetDate() {
    // Arrange
    ImmutableAppCountWidgetParameters.Builder builderResult = ImmutableAppCountWidgetParameters.builder();
    LocalDate targetDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAppCountWidgetParameters.Builder actualTargetDateResult = builderResult.targetDate(targetDate);

    // Assert
    assertSame(targetDate, builderResult.build().targetDate());
    assertSame(builderResult, actualTargetDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppCountWidgetParameters#copyOf(AppCountWidgetParameters)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AppCountWidgetParameters instance = mock(AppCountWidgetParameters.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.targetDate()).thenReturn(ofResult);

    // Act
    ImmutableAppCountWidgetParameters actualCopyOfResult = ImmutableAppCountWidgetParameters.copyOf(instance);

    // Assert
    verify(instance).targetDate();
    LocalDate targetDateResult = actualCopyOfResult.targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertSame(ofResult, targetDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppCountWidgetParameters#fromJson(ImmutableAppCountWidgetParameters.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAppCountWidgetParameters.Json json = new ImmutableAppCountWidgetParameters.Json();
    LocalDate targetDate = LocalDate.of(1970, 1, 1);
    json.setTargetDate(targetDate);

    // Act and Assert
    LocalDate targetDateResult = ImmutableAppCountWidgetParameters.fromJson(json).targetDate();
    assertEquals("1970-01-01", targetDateResult.toString());
    assertSame(targetDate, targetDateResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAppCountWidgetParameters.Json}
   *   <li>{@link ImmutableAppCountWidgetParameters.Json#setTargetDate(LocalDate)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAppCountWidgetParameters.Json actualJson = new ImmutableAppCountWidgetParameters.Json();
    actualJson.setTargetDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals("1970-01-01", actualJson.targetDate.toString());
  }

  /**
   * Method under test:
   * {@link ImmutableAppCountWidgetParameters.Json#targetDate()}
   */
  @Test
  void testJsonTargetDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAppCountWidgetParameters.Json()).targetDate());
  }
}
