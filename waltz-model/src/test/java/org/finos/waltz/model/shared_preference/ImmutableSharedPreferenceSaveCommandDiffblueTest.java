package org.finos.waltz.model.shared_preference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.shared_preference.ImmutableSharedPreferenceSaveCommand.Builder;
import org.finos.waltz.model.shared_preference.ImmutableSharedPreferenceSaveCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSharedPreferenceSaveCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#category(String)}.
   * <p>
   * Method under test: {@link Builder#category(String)}
   */
  @Test
  @DisplayName("Test Builder category(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.category(String)"})
  void testBuilderCategory() {
    // Arrange
    Builder builderResult = ImmutableSharedPreferenceSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.category("Category"));
  }

  /**
   * Test Builder {@link Builder#from(SharedPreferenceSaveCommand)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then builder build value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SharedPreferenceSaveCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SharedPreferenceSaveCommand); given '42'; then builder build value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SharedPreferenceSaveCommand)"})
  void testBuilderFrom_given42_thenBuilderBuildValueIs42() {
    // Arrange
    Builder builderResult = ImmutableSharedPreferenceSaveCommand.builder();
    SharedPreferenceSaveCommand instance = mock(SharedPreferenceSaveCommand.class);
    when(instance.value()).thenReturn("42");
    when(instance.category()).thenReturn("Category");
    when(instance.key()).thenReturn("Key");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).category();
    verify(instance).key();
    verify(instance).value();
    ImmutableSharedPreferenceSaveCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.value());
    assertEquals("Category", buildResult.category());
    assertEquals("Key", buildResult.key());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SharedPreferenceSaveCommand)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SharedPreferenceSaveCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SharedPreferenceSaveCommand); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SharedPreferenceSaveCommand)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSharedPreferenceSaveCommand.builder();
    SharedPreferenceSaveCommand instance = mock(SharedPreferenceSaveCommand.class);
    when(instance.value()).thenThrow(new IllegalStateException("instance"));
    when(instance.category()).thenReturn("Category");
    when(instance.key()).thenReturn("Key");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).category();
    verify(instance).key();
    verify(instance).value();
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
    Builder builderResult = ImmutableSharedPreferenceSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
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
    Builder builderResult = ImmutableSharedPreferenceSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
  }

  /**
   * Test Json {@link Json#category()}.
   * <p>
   * Method under test: {@link Json#category()}
   */
  @Test
  @DisplayName("Test Json category()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.category()"})
  void testJsonCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).category());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCategory(String)}
   *   <li>{@link Json#setKey(String)}
   *   <li>{@link Json#setValue(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCategory(String)", "void Json.setKey(String)",
      "void Json.setValue(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCategory("Category");
    actualJson.setKey("Key");
    actualJson.setValue("42");

    // Assert
    assertEquals("42", actualJson.value);
    assertEquals("Category", actualJson.category);
    assertEquals("Key", actualJson.key);
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
