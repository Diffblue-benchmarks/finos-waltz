package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableCellOptionDiffblueTest {
  /**
   * Method under test: {@link ImmutableCellOption.Builder#code(String)}
   */
  @Test
  void testBuilderCode() {
    // Arrange
    ImmutableCellOption.Builder builderResult = ImmutableCellOption.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.code("Code"));
  }

  /**
   * Method under test: {@link ImmutableCellOption.Builder#from(CellOption)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCellOption.Builder builderResult = ImmutableCellOption.builder();
    CellOption instance = mock(CellOption.class);
    when(instance.code()).thenReturn("Code");
    when(instance.text()).thenReturn("Text");

    // Act
    ImmutableCellOption.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).code();
    verify(instance).text();
    ImmutableCellOption buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Text", buildResult.text());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellOption.Builder#from(CellOption)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCellOption.Builder builderResult = ImmutableCellOption.builder();
    CellOption instance = mock(CellOption.class);
    when(instance.code()).thenThrow(new IllegalStateException("instance"));
    when(instance.text()).thenReturn("Text");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).code();
    verify(instance).text();
  }

  /**
   * Method under test: {@link ImmutableCellOption.Builder#text(String)}
   */
  @Test
  void testBuilderText() {
    // Arrange
    ImmutableCellOption.Builder builderResult = ImmutableCellOption.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.text("Text"));
  }

  /**
   * Method under test: {@link ImmutableCellOption#copyOf(CellOption)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CellOption instance = mock(CellOption.class);
    when(instance.code()).thenReturn("Code");
    when(instance.text()).thenReturn("Text");

    // Act
    ImmutableCellOption actualCopyOfResult = ImmutableCellOption.copyOf(instance);

    // Assert
    verify(instance).code();
    verify(instance).text();
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Text", actualCopyOfResult.text());
  }

  /**
   * Method under test:
   * {@link ImmutableCellOption#fromJson(ImmutableCellOption.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableCellOption.Json json = new ImmutableCellOption.Json();
    json.setText("Json");
    json.setCode("Json");

    // Act
    ImmutableCellOption actualFromJsonResult = ImmutableCellOption.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.code());
    assertEquals("Json", actualFromJsonResult.text());
  }

  /**
   * Method under test: {@link ImmutableCellOption.Json#code()}
   */
  @Test
  void testJsonCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCellOption.Json()).code());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableCellOption.Json}
   *   <li>{@link ImmutableCellOption.Json#setCode(String)}
   *   <li>{@link ImmutableCellOption.Json#setText(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableCellOption.Json actualJson = new ImmutableCellOption.Json();
    actualJson.setCode("Code");
    actualJson.setText("Text");

    // Assert
    assertEquals("Code", actualJson.code);
    assertEquals("Text", actualJson.text);
  }

  /**
   * Method under test: {@link ImmutableCellOption.Json#text()}
   */
  @Test
  void testJsonText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCellOption.Json()).text());
  }
}
