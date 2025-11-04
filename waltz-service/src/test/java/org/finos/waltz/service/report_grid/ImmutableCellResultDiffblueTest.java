package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableCellResultDiffblueTest {
  /**
   * Method under test: {@link ImmutableCellResult.Builder#from(CellResult)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCellResult.Builder builderResult = ImmutableCellResult.builder();
    CellResult instance = mock(CellResult.class);
    when(instance.optionText()).thenReturn("Option Text");
    when(instance.optionCode()).thenReturn("Option Code");
    when(instance.value()).thenReturn("42");

    // Act
    ImmutableCellResult.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).optionCode();
    verify(instance).optionText();
    verify(instance).value();
    ImmutableCellResult buildResult = builderResult.build();
    assertEquals("42", buildResult.value());
    assertEquals("Option Code", buildResult.optionCode());
    assertEquals("Option Text", buildResult.optionText());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellResult.Builder#from(CellResult)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCellResult.Builder builderResult = ImmutableCellResult.builder();
    CellResult instance = mock(CellResult.class);
    when(instance.optionText()).thenThrow(new IllegalStateException("instance"));
    when(instance.optionCode()).thenReturn("Option Code");
    when(instance.value()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).optionCode();
    verify(instance).optionText();
    verify(instance).value();
  }

  /**
   * Method under test: {@link ImmutableCellResult.Builder#optionCode(String)}
   */
  @Test
  void testBuilderOptionCode() {
    // Arrange
    ImmutableCellResult.Builder builderResult = ImmutableCellResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.optionCode("Option Code"));
  }

  /**
   * Method under test: {@link ImmutableCellResult.Builder#optionText(String)}
   */
  @Test
  void testBuilderOptionText() {
    // Arrange
    ImmutableCellResult.Builder builderResult = ImmutableCellResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.optionText("Option Text"));
  }

  /**
   * Method under test: {@link ImmutableCellResult.Builder#value(String)}
   */
  @Test
  void testBuilderValue() {
    // Arrange
    ImmutableCellResult.Builder builderResult = ImmutableCellResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
  }

  /**
   * Method under test: {@link ImmutableCellResult#copyOf(CellResult)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CellResult instance = mock(CellResult.class);
    when(instance.optionText()).thenReturn("Option Text");
    when(instance.optionCode()).thenReturn("Option Code");
    when(instance.value()).thenReturn("42");

    // Act
    ImmutableCellResult actualCopyOfResult = ImmutableCellResult.copyOf(instance);

    // Assert
    verify(instance).optionCode();
    verify(instance).optionText();
    verify(instance).value();
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Option Code", actualCopyOfResult.optionCode());
    assertEquals("Option Text", actualCopyOfResult.optionText());
  }
}
