package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.web.json.ImmutableCellValue.Builder;
import org.finos.waltz.web.json.ImmutableCellValue.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCellValueDiffblueTest {
  /**
   * Test {@link ImmutableCellValue#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCellValue#builder()}
   *   <li>{@link ImmutableCellValue#comment(String)}
   *   <li>{@link ImmutableCellValue#type(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCellValue Builder.build()", "Builder Builder.comment(String)",
      "Builder Builder.type(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualCommentResult = ImmutableCellValue.builder().comment("Comment");
    Optional<String> comment = Optional.of("foo");
    Builder actualCommentResult2 = actualCommentResult.comment(comment);

    // Assert
    assertSame(actualCommentResult2, actualCommentResult2.type("Type"));
  }

  /**
   * Test Builder {@link Builder#comment(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#comment(Optional)}
   */
  @Test
  @DisplayName("Test Builder comment(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.comment(Optional)"})
  void testBuilderCommentWithOptional() {
    // Arrange
    Builder builderResult = ImmutableCellValue.builder();
    Optional<String> comment = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.comment(comment));
  }

  /**
   * Test Builder {@link Builder#from(CellValue)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link CellValue} {@link CellValue#comment()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellValue)}
   */
  @Test
  @DisplayName("Test Builder from(CellValue); given empty; when CellValue comment() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellValue)"})
  void testBuilderFrom_givenEmpty_whenCellValueCommentReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableCellValue.builder();
    CellValue instance = mock(CellValue.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.comment()).thenReturn(emptyResult);
    when(instance.value()).thenReturn("42");
    when(instance.name()).thenReturn("Name");
    when(instance.type()).thenReturn("Type");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(CellValue)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   *   <li>When {@link CellValue} {@link CellValue#comment()} return {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellValue)}
   */
  @Test
  @DisplayName("Test Builder from(CellValue); given Optional with 'foo'; when CellValue comment() return Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellValue)"})
  void testBuilderFrom_givenOptionalWithFoo_whenCellValueCommentReturnOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutableCellValue.builder();
    CellValue instance = mock(CellValue.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.comment()).thenReturn(ofResult);
    when(instance.value()).thenReturn("42");
    when(instance.name()).thenReturn("Name");
    when(instance.type()).thenReturn("Type");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(CellValue)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellValue)}
   */
  @Test
  @DisplayName("Test Builder from(CellValue); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellValue)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCellValue.builder();
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
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableCellValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
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
    Builder builderResult = ImmutableCellValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
  }

  /**
   * Test Json {@link Json#comment()}.
   * <p>
   * Method under test: {@link Json#comment()}
   */
  @Test
  @DisplayName("Test Json comment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).comment());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
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
    assertNull(actualJson.name);
    assertNull(actualJson.type);
    assertNull(actualJson.value);
    assertFalse(actualJson.comment.isPresent());
  }

  /**
   * Test Json {@link Json#type()}.
   * <p>
   * Method under test: {@link Json#type()}
   */
  @Test
  @DisplayName("Test Json type()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).type());
  }

  /**
   * Test Json {@link Json#value()}.
   * <p>
   * Method under test: {@link Json#value()}
   */
  @Test
  @DisplayName("Test Json value()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.value()"})
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).value());
  }
}
