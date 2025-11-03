package org.finos.waltz.model;

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
import org.finos.waltz.model.ImmutableWebError.Builder;
import org.finos.waltz.model.ImmutableWebError.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableWebErrorDiffblueTest {
  /**
   * Test {@link ImmutableWebError#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableWebError#builder()}
   *   <li>{@link ImmutableWebError#id(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableWebError Builder.build()", "Builder Builder.id(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualIdResult = ImmutableWebError.builder().id("42");
    Optional<String> id = Optional.of("foo");

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Test Builder {@link Builder#from(WebError)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link WebError} {@link WebError#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(WebError)}
   */
  @Test
  @DisplayName("Test Builder from(WebError); given empty; when WebError id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(WebError)"})
  void testBuilderFrom_givenEmpty_whenWebErrorIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableWebError.builder();
    WebError instance = mock(WebError.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).message();
    assertEquals("Not all who wander are lost", builderResult.build().message());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(WebError)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   *   <li>When {@link WebError} {@link WebError#id()} return {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(WebError)}
   */
  @Test
  @DisplayName("Test Builder from(WebError); given Optional with 'foo'; when WebError id() return Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(WebError)"})
  void testBuilderFrom_givenOptionalWithFoo_whenWebErrorIdReturnOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutableWebError.builder();
    WebError instance = mock(WebError.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.id()).thenReturn(ofResult);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).message();
    assertEquals("Not all who wander are lost", builderResult.build().message());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(WebError)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(WebError)}
   */
  @Test
  @DisplayName("Test Builder from(WebError); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(WebError)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableWebError.builder();
    WebError instance = mock(WebError.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).message();
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableWebError.builder();
    Optional<String> id = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#message(String)}.
   * <p>
   * Method under test: {@link Builder#message(String)}
   */
  @Test
  @DisplayName("Test Builder message(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.message(String)"})
  void testBuilderMessage() {
    // Arrange
    Builder builderResult = ImmutableWebError.builder();

    // Act
    Builder actualMessageResult = builderResult.message("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", builderResult.build().message());
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#message()}.
   * <p>
   * Method under test: {@link Json#message()}
   */
  @Test
  @DisplayName("Test Json message()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.message()"})
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).message());
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
    assertNull(actualJson.message);
    assertFalse(actualJson.id.isPresent());
  }
}
