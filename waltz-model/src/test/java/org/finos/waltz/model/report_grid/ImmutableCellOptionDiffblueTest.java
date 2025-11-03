package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.report_grid.ImmutableCellOption.Builder;
import org.finos.waltz.model.report_grid.ImmutableCellOption.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCellOptionDiffblueTest {
  /**
   * Test Builder {@link Builder#code(String)}.
   * <p>
   * Method under test: {@link Builder#code(String)}
   */
  @Test
  @DisplayName("Test Builder code(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.code(String)"})
  void testBuilderCode() {
    // Arrange
    Builder builderResult = ImmutableCellOption.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.code("Code"));
  }

  /**
   * Test Builder {@link Builder#from(CellOption)}.
   * <ul>
   *   <li>Given {@code Code}.</li>
   *   <li>Then builder build code is {@code Code}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellOption)}
   */
  @Test
  @DisplayName("Test Builder from(CellOption); given 'Code'; then builder build code is 'Code'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellOption)"})
  void testBuilderFrom_givenCode_thenBuilderBuildCodeIsCode() {
    // Arrange
    Builder builderResult = ImmutableCellOption.builder();
    CellOption instance = mock(CellOption.class);
    when(instance.code()).thenReturn("Code");
    when(instance.text()).thenReturn("Text");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).code();
    verify(instance).text();
    ImmutableCellOption buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Text", buildResult.text());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CellOption)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellOption)}
   */
  @Test
  @DisplayName("Test Builder from(CellOption); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellOption)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCellOption.builder();
    CellOption instance = mock(CellOption.class);
    when(instance.code()).thenThrow(new IllegalStateException("instance"));
    when(instance.text()).thenReturn("Text");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).code();
    verify(instance).text();
  }

  /**
   * Test Builder {@link Builder#text(String)}.
   * <p>
   * Method under test: {@link Builder#text(String)}
   */
  @Test
  @DisplayName("Test Builder text(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.text(String)"})
  void testBuilderText() {
    // Arrange
    Builder builderResult = ImmutableCellOption.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.text("Text"));
  }

  /**
   * Test Json {@link Json#code()}.
   * <p>
   * Method under test: {@link Json#code()}
   */
  @Test
  @DisplayName("Test Json code()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.code()"})
  void testJsonCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).code());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCode(String)}
   *   <li>{@link Json#setText(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCode(String)", "void Json.setText(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCode("Code");
    actualJson.setText("Text");

    // Assert
    assertEquals("Code", actualJson.code);
    assertEquals("Text", actualJson.text);
  }

  /**
   * Test Json {@link Json#text()}.
   * <p>
   * Method under test: {@link Json#text()}
   */
  @Test
  @DisplayName("Test Json text()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.text()"})
  void testJsonText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).text());
  }
}
