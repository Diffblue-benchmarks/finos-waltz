package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.service.report_grid.ImmutableCellResult.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCellResultDiffblueTest {
  /**
   * Test Builder {@link Builder#from(CellResult)}.
   * <ul>
   *   <li>Given {@code Option Text}.</li>
   *   <li>Then builder build value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellResult)}
   */
  @Test
  @DisplayName("Test Builder from(CellResult); given 'Option Text'; then builder build value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellResult)"})
  void testBuilderFrom_givenOptionText_thenBuilderBuildValueIs42() {
    // Arrange
    Builder builderResult = ImmutableCellResult.builder();
    CellResult instance = mock(CellResult.class);
    when(instance.optionText()).thenReturn("Option Text");
    when(instance.optionCode()).thenReturn("Option Code");
    when(instance.value()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(CellResult)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellResult)}
   */
  @Test
  @DisplayName("Test Builder from(CellResult); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellResult)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCellResult.builder();
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
   * Test Builder {@link Builder#optionCode(String)}.
   * <p>
   * Method under test: {@link Builder#optionCode(String)}
   */
  @Test
  @DisplayName("Test Builder optionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.optionCode(String)"})
  void testBuilderOptionCode() {
    // Arrange
    Builder builderResult = ImmutableCellResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.optionCode("Option Code"));
  }

  /**
   * Test Builder {@link Builder#optionText(String)}.
   * <p>
   * Method under test: {@link Builder#optionText(String)}
   */
  @Test
  @DisplayName("Test Builder optionText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.optionText(String)"})
  void testBuilderOptionText() {
    // Arrange
    Builder builderResult = ImmutableCellResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.optionText("Option Text"));
  }

  /**
   * Test Builder {@link Builder#value(String)}.
   * <p>
   * Method under test: {@link Builder#value(String)}
   */
  @Test
  @DisplayName("Test Builder value(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.value(String)"})
  void testBuilderValue() {
    // Arrange
    Builder builderResult = ImmutableCellResult.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
  }
}
