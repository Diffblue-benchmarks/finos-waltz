package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ImmutableCellValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCellValue#builder()}
   *   <li>{@link ImmutableCellValue#comment(String)}
   *   <li>{@link ImmutableCellValue#type(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableCellValue.Builder actualCommentResult = ImmutableCellValue.builder().comment("Comment");
    Optional<String> comment = Optional.of("foo");
    ImmutableCellValue.Builder actualCommentResult2 = actualCommentResult.comment(comment);

    // Assert
    assertSame(actualCommentResult2, actualCommentResult2.type("Type"));
  }

  /**
   * Method under test: {@link ImmutableCellValue.Builder#comment(Optional)}
   */
  @Test
  void testBuilderComment() {
    // Arrange
    ImmutableCellValue.Builder builderResult = ImmutableCellValue.builder();
    Optional<String> comment = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.comment(comment));
  }

  /**
   * Method under test: {@link ImmutableCellValue.Builder#from(CellValue)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCellValue.Builder builderResult = ImmutableCellValue.builder();
    CellValue instance = mock(CellValue.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    when(instance.value()).thenReturn("42");
    when(instance.name()).thenReturn("Name");
    when(instance.type()).thenReturn("Type");

    // Act
    ImmutableCellValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).name();
    verify(instance).type();
    verify(instance).value();
    ImmutableCellValue buildResult = builderResult.build();
    assertEquals("42", buildResult.value());
    assertEquals("Name", buildResult.name());
    assertEquals("Type", buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellValue.Builder#from(CellValue)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCellValue.Builder builderResult = ImmutableCellValue.builder();
    CellValue instance = mock(CellValue.class);
    when(instance.comment()).thenThrow(new IllegalStateException("instance"));
    when(instance.value()).thenReturn("42");
    when(instance.name()).thenReturn("Name");
    when(instance.type()).thenReturn("Type");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
    verify(instance).name();
    verify(instance).type();
    verify(instance).value();
  }

  /**
   * Method under test: {@link ImmutableCellValue.Builder#from(CellValue)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableCellValue.Builder builderResult = ImmutableCellValue.builder();
    CellValue instance = mock(CellValue.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.comment()).thenReturn(emptyResult);
    when(instance.value()).thenReturn("42");
    when(instance.name()).thenReturn("Name");
    when(instance.type()).thenReturn("Type");

    // Act
    ImmutableCellValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).name();
    verify(instance).type();
    verify(instance).value();
    ImmutableCellValue buildResult = builderResult.build();
    assertEquals("42", buildResult.value());
    assertEquals("Name", buildResult.name());
    assertEquals("Type", buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellValue.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableCellValue.Builder builderResult = ImmutableCellValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableCellValue.Builder#value(String)}
   */
  @Test
  void testBuilderValue() {
    // Arrange
    ImmutableCellValue.Builder builderResult = ImmutableCellValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
  }

  /**
   * Method under test: {@link ImmutableCellValue#copyOf(CellValue)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CellValue instance = mock(CellValue.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    when(instance.value()).thenReturn("42");
    when(instance.name()).thenReturn("Name");
    when(instance.type()).thenReturn("Type");

    // Act
    ImmutableCellValue actualCopyOfResult = ImmutableCellValue.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).name();
    verify(instance).type();
    verify(instance).value();
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Type", actualCopyOfResult.type());
  }

  /**
   * Method under test: {@link ImmutableCellValue#copyOf(CellValue)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    CellValue instance = mock(CellValue.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.comment()).thenReturn(emptyResult);
    when(instance.value()).thenReturn("42");
    when(instance.name()).thenReturn("Name");
    when(instance.type()).thenReturn("Type");

    // Act
    ImmutableCellValue actualCopyOfResult = ImmutableCellValue.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).name();
    verify(instance).type();
    verify(instance).value();
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Type", actualCopyOfResult.type());
  }

  /**
   * Method under test:
   * {@link ImmutableCellValue#fromJson(ImmutableCellValue.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableCellValue.Json json = new ImmutableCellValue.Json();
    json.setType(null);
    json.setName("Json");
    json.setValue("Json");
    json.setComment(null);

    // Act
    ImmutableCellValue actualFromJsonResult = ImmutableCellValue.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.value());
    assertEquals(ApiTypes.VALCELL, actualFromJsonResult.type());
  }

  /**
   * Method under test:
   * {@link ImmutableCellValue#fromJson(ImmutableCellValue.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableCellValue.Json json = new ImmutableCellValue.Json();
    json.setType("Json");
    json.setName("Json");
    json.setValue("Json");
    json.setComment(null);

    // Act
    ImmutableCellValue actualFromJsonResult = ImmutableCellValue.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.type());
    assertEquals("Json", actualFromJsonResult.value());
  }

  /**
   * Method under test: {@link ImmutableCellValue.Json#comment()}
   */
  @Test
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCellValue.Json()).comment());
  }

  /**
   * Method under test: {@link ImmutableCellValue.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCellValue.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableCellValue.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableCellValue.Json actualJson = new ImmutableCellValue.Json();

    // Assert
    assertNull(actualJson.name);
    assertNull(actualJson.type);
    assertNull(actualJson.value);
    assertFalse(actualJson.comment.isPresent());
  }

  /**
   * Method under test: {@link ImmutableCellValue.Json#type()}
   */
  @Test
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCellValue.Json()).type());
  }

  /**
   * Method under test: {@link ImmutableCellValue.Json#value()}
   */
  @Test
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCellValue.Json()).value());
  }
}
