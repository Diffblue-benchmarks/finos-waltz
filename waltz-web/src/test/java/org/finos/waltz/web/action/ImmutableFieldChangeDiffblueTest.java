package org.finos.waltz.web.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.web.action.ImmutableFieldChange.Builder;
import org.finos.waltz.web.action.ImmutableFieldChange.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFieldChangeDiffblueTest {
  /**
   * Test {@link ImmutableFieldChange#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFieldChange#builder()}
   *   <li>{@link ImmutableFieldChange#current(String)}
   *   <li>{@link ImmutableFieldChange#original(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFieldChange Builder.build()", "Builder Builder.current(String)",
      "Builder Builder.original(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualCurrentResult = ImmutableFieldChange.builder().current("Current");
    Optional<String> current = Optional.of("foo");
    Builder actualOriginalResult = actualCurrentResult.current(current).original("Original");
    Optional<String> original = Optional.of("foo");

    // Assert
    assertSame(actualOriginalResult, actualOriginalResult.original(original));
  }

  /**
   * Test Builder {@link Builder#current(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#current(Optional)}
   */
  @Test
  @DisplayName("Test Builder current(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.current(Optional)"})
  void testBuilderCurrentWithOptional() {
    // Arrange
    Builder builderResult = ImmutableFieldChange.builder();
    Optional<String> current = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.current(current));
  }

  /**
   * Test Builder {@link Builder#dirty(boolean)}.
   * <p>
   * Method under test: {@link Builder#dirty(boolean)}
   */
  @Test
  @DisplayName("Test Builder dirty(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dirty(boolean)"})
  void testBuilderDirty() {
    // Arrange
    Builder builderResult = ImmutableFieldChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dirty(true));
  }

  /**
   * Test Builder {@link Builder#from(FieldChange)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link FieldChange} {@link FieldChange#current()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(FieldChange); given empty; when FieldChange current() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FieldChange)"})
  void testBuilderFrom_givenEmpty_whenFieldChangeCurrentReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableFieldChange.builder();
    FieldChange instance = mock(FieldChange.class);
    when(instance.dirty()).thenReturn(true);
    Optional<String> emptyResult = Optional.empty();
    when(instance.current()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.original()).thenReturn(ofResult);
    when(instance.key()).thenReturn("Key");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).current();
    verify(instance).dirty();
    verify(instance).key();
    verify(instance).name();
    verify(instance).original();
    ImmutableFieldChange buildResult = builderResult.build();
    assertEquals("Key", buildResult.key());
    assertEquals("Name", buildResult.name());
    assertTrue(buildResult.dirty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FieldChange)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link FieldChange} {@link FieldChange#original()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(FieldChange); given empty; when FieldChange original() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FieldChange)"})
  void testBuilderFrom_givenEmpty_whenFieldChangeOriginalReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableFieldChange.builder();
    FieldChange instance = mock(FieldChange.class);
    when(instance.dirty()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.current()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.original()).thenReturn(emptyResult);
    when(instance.key()).thenReturn("Key");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).current();
    verify(instance).dirty();
    verify(instance).key();
    verify(instance).name();
    verify(instance).original();
    ImmutableFieldChange buildResult = builderResult.build();
    assertEquals("Key", buildResult.key());
    assertEquals("Name", buildResult.name());
    assertTrue(buildResult.dirty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FieldChange)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(FieldChange); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FieldChange)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFieldChange.builder();
    FieldChange instance = mock(FieldChange.class);
    when(instance.dirty()).thenThrow(new IllegalStateException("instance"));
    when(instance.key()).thenReturn("Key");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).dirty();
    verify(instance).key();
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#from(FieldChange)}.
   * <ul>
   *   <li>When {@link FieldChange} {@link FieldChange#current()} return {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FieldChange)}
   */
  @Test
  @DisplayName("Test Builder from(FieldChange); when FieldChange current() return Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FieldChange)"})
  void testBuilderFrom_whenFieldChangeCurrentReturnOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutableFieldChange.builder();
    FieldChange instance = mock(FieldChange.class);
    when(instance.dirty()).thenReturn(true);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.current()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.original()).thenReturn(ofResult2);
    when(instance.key()).thenReturn("Key");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).current();
    verify(instance).dirty();
    verify(instance).key();
    verify(instance).name();
    verify(instance).original();
    ImmutableFieldChange buildResult = builderResult.build();
    assertEquals("Key", buildResult.key());
    assertEquals("Name", buildResult.name());
    assertTrue(buildResult.dirty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#key(String)}.
   * <p>
   * Method under test: {@link Builder#key(String)}
   */
  @Test
  @DisplayName("Test Builder key(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.key(String)"})
  void testBuilderKey() {
    // Arrange
    Builder builderResult = ImmutableFieldChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
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
    Builder builderResult = ImmutableFieldChange.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#original(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#original(Optional)}
   */
  @Test
  @DisplayName("Test Builder original(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.original(Optional)"})
  void testBuilderOriginalWithOptional() {
    // Arrange
    Builder builderResult = ImmutableFieldChange.builder();
    Optional<String> original = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.original(original));
  }

  /**
   * Test Json {@link Json#current()}.
   * <p>
   * Method under test: {@link Json#current()}
   */
  @Test
  @DisplayName("Test Json current()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.current()"})
  void testJsonCurrent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).current());
  }

  /**
   * Test Json {@link Json#dirty()}.
   * <p>
   * Method under test: {@link Json#dirty()}
   */
  @Test
  @DisplayName("Test Json dirty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.dirty()"})
  void testJsonDirty() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dirty());
  }

  /**
   * Test Json {@link Json#key()}.
   * <p>
   * Method under test: {@link Json#key()}
   */
  @Test
  @DisplayName("Test Json key()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.key()"})
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).key());
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
    assertNull(actualJson.key);
    assertNull(actualJson.name);
    assertFalse(actualJson.current.isPresent());
    assertFalse(actualJson.original.isPresent());
    assertFalse(actualJson.dirty);
    assertFalse(actualJson.dirtyIsSet);
  }

  /**
   * Test Json {@link Json#original()}.
   * <p>
   * Method under test: {@link Json#original()}
   */
  @Test
  @DisplayName("Test Json original()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.original()"})
  void testJsonOriginal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).original());
  }

  /**
   * Test Json {@link Json#setDirty(boolean)}.
   * <p>
   * Method under test: {@link Json#setDirty(boolean)}
   */
  @Test
  @DisplayName("Test Json setDirty(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setDirty(boolean)"})
  void testJsonSetDirty() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDirty(true);

    // Assert
    assertTrue(json.dirty);
    assertTrue(json.dirtyIsSet);
  }
}
