package org.finos.waltz.model.settings;

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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.settings.ImmutableSetting.Builder;
import org.finos.waltz.model.settings.ImmutableSetting.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSettingDiffblueTest {
  /**
   * Test {@link ImmutableSetting#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSetting#builder()}
   *   <li>{@link ImmutableSetting#description(String)}
   *   <li>{@link ImmutableSetting#value(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSetting Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.value(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualValueResult = ImmutableSetting.builder()
        .description("The characteristics of someone or something")
        .value("42");
    Optional<String> value = Optional.of("foo");

    // Assert
    assertSame(actualValueResult, actualValueResult.value(value));
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then builder build name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then builder build name is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    ImmutableSetting buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertFalse(buildResult.restricted());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Setting)} with {@code Setting}.
   * <p>
   * Method under test: {@link Builder#from(Setting)}
   */
  @Test
  @DisplayName("Test Builder from(Setting) with 'Setting'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Setting)"})
  void testBuilderFromWithSetting() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();
    Setting instance = mock(Setting.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.value()).thenReturn(ofResult);
    when(instance.restricted()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).restricted();
    verify(instance).value();
    ImmutableSetting buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertTrue(buildResult.restricted());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Setting)} with {@code Setting}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Setting} {@link Setting#value()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Setting)}
   */
  @Test
  @DisplayName("Test Builder from(Setting) with 'Setting'; given empty; when Setting value() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Setting)"})
  void testBuilderFromWithSetting_givenEmpty_whenSettingValueReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();
    Setting instance = mock(Setting.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.value()).thenReturn(emptyResult);
    when(instance.restricted()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).restricted();
    verify(instance).value();
    ImmutableSetting buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertTrue(buildResult.restricted());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Setting)} with {@code Setting}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Setting)}
   */
  @Test
  @DisplayName("Test Builder from(Setting) with 'Setting'; then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Setting)"})
  void testBuilderFromWithSetting_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();
    Setting instance = mock(Setting.class);
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.value()).thenReturn(ofResult);
    when(instance.restricted()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).restricted();
    verify(instance).value();
    ImmutableSetting buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertTrue(buildResult.restricted());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Setting)} with {@code Setting}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Setting)}
   */
  @Test
  @DisplayName("Test Builder from(Setting) with 'Setting'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Setting)"})
  void testBuilderFromWithSetting_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();
    Setting instance = mock(Setting.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
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
    Builder builderResult = ImmutableSetting.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableSetting buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertFalse(buildResult.restricted());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#restricted(boolean)}.
   * <p>
   * Method under test: {@link Builder#restricted(boolean)}
   */
  @Test
  @DisplayName("Test Builder restricted(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.restricted(boolean)"})
  void testBuilderRestricted() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.restricted(true));
  }

  /**
   * Test Builder {@link Builder#value(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#value(Optional)}
   */
  @Test
  @DisplayName("Test Builder value(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.value(Optional)"})
  void testBuilderValueWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSetting.builder();
    Optional<String> value = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.value(value));
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
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
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertFalse(actualJson.value.isPresent());
    assertFalse(actualJson.restricted);
    assertFalse(actualJson.restrictedIsSet);
  }

  /**
   * Test Json {@link Json#restricted()}.
   * <p>
   * Method under test: {@link Json#restricted()}
   */
  @Test
  @DisplayName("Test Json restricted()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.restricted()"})
  void testJsonRestricted() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).restricted());
  }

  /**
   * Test Json {@link Json#setRestricted(boolean)}.
   * <p>
   * Method under test: {@link Json#setRestricted(boolean)}
   */
  @Test
  @DisplayName("Test Json setRestricted(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRestricted(boolean)"})
  void testJsonSetRestricted() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRestricted(true);

    // Assert
    assertTrue(json.restricted);
    assertTrue(json.restrictedIsSet);
  }

  /**
   * Test Json {@link Json#value()}.
   * <p>
   * Method under test: {@link Json#value()}
   */
  @Test
  @DisplayName("Test Json value()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.value()"})
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).value());
  }
}
