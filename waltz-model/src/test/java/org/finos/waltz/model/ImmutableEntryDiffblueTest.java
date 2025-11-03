package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableEntry.Builder;
import org.finos.waltz.model.ImmutableEntry.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntryDiffblueTest {
  /**
   * Test Builder {@link Builder#from(Entry)}.
   * <ul>
   *   <li>Given {@code Value}.</li>
   *   <li>When {@link Entry} {@link Entry#value()} return {@code Value}.</li>
   *   <li>Then builder build key is {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Entry)}
   */
  @Test
  @DisplayName("Test Builder from(Entry); given 'Value'; when Entry value() return 'Value'; then builder build key is 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Entry)"})
  void testBuilderFrom_givenValue_whenEntryValueReturnValue_thenBuilderBuildKeyIsKey() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();
    Entry<Object, Object> instance = mock(Entry.class);
    when(instance.value()).thenReturn("Value");
    when(instance.key()).thenReturn("Key");

    // Act
    Builder<Object, Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).key();
    verify(instance).value();
    ImmutableEntry<Object, Object> buildResult = builderResult.build();
    assertEquals("Key", buildResult.key());
    assertEquals("Value", buildResult.value());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Entry)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Entry)}
   */
  @Test
  @DisplayName("Test Builder from(Entry); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Entry)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();
    Entry<Object, Object> instance = mock(Entry.class);
    when(instance.value()).thenThrow(new IllegalStateException("instance"));
    when(instance.key()).thenReturn("Key");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).key();
    verify(instance).value();
  }

  /**
   * Test Builder {@link Builder#key(Object)}.
   * <p>
   * Method under test: {@link Builder#key(Object)}
   */
  @Test
  @DisplayName("Test Builder key(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.key(Object)"})
  void testBuilderKey() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
  }

  /**
   * Test Builder {@link Builder#value(Object)}.
   * <p>
   * Method under test: {@link Builder#value(Object)}
   */
  @Test
  @DisplayName("Test Builder value(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.value(Object)"})
  void testBuilderValue() {
    // Arrange
    Builder<Object, Object> builderResult = ImmutableEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("Value"));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setKey(Object)}
   *   <li>{@link Json#setValue(Object)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setKey(Object)", "void Json.setValue(Object)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json<Object, Object> actualJson = new Json<>();
    actualJson.setKey("Key");
    actualJson.setValue("Value");

    // Assert
    assertEquals("Key", actualJson.key);
    assertEquals("Value", actualJson.value);
  }

  /**
   * Test Json {@link Json#key()}.
   * <p>
   * Method under test: {@link Json#key()}
   */
  @Test
  @DisplayName("Test Json key()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Json.key()"})
  void testJsonKey() {
    // Arrange
    Json<Object, Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.key());
  }

  /**
   * Test Json {@link Json#value()}.
   * <p>
   * Method under test: {@link Json#value()}
   */
  @Test
  @DisplayName("Test Json value()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Json.value()"})
  void testJsonValue() {
    // Arrange
    Json<Object, Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.value());
  }
}
