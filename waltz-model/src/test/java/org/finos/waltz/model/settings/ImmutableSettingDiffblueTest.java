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
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableSettingDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSetting#builder()}
   *   <li>{@link ImmutableSetting#description(String)}
   *   <li>{@link ImmutableSetting#value(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableSetting.Builder actualValueResult = ImmutableSetting.builder()
        .description("The characteristics of someone or something")
        .value("42");
    Optional<String> value = Optional.of("foo");

    // Assert
    assertSame(actualValueResult, actualValueResult.value(value));
  }

  /**
   * Method under test: {@link ImmutableSetting.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSetting.Builder builderResult = ImmutableSetting.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableSetting.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSetting.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSetting.Builder builderResult = ImmutableSetting.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableSetting.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSetting.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSetting.Builder builderResult = ImmutableSetting.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test: {@link ImmutableSetting.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSetting.Builder builderResult = ImmutableSetting.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSetting.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    ImmutableSetting buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertFalse(buildResult.restricted());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSetting.Builder#from(Setting)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSetting.Builder builderResult = ImmutableSetting.builder();
    Setting instance = mock(Setting.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.value()).thenReturn(ofResult);
    when(instance.restricted()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSetting.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableSetting.Builder#from(Setting)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSetting.Builder builderResult = ImmutableSetting.builder();
    Setting instance = mock(Setting.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Method under test: {@link ImmutableSetting.Builder#from(Setting)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSetting.Builder builderResult = ImmutableSetting.builder();
    Setting instance = mock(Setting.class);
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.value()).thenReturn(ofResult);
    when(instance.restricted()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSetting.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableSetting.Builder#from(Setting)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableSetting.Builder builderResult = ImmutableSetting.builder();
    Setting instance = mock(Setting.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.value()).thenReturn(emptyResult);
    when(instance.restricted()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSetting.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableSetting.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableSetting.Builder builderResult = ImmutableSetting.builder();

    // Act
    ImmutableSetting.Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableSetting buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertFalse(buildResult.restricted());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Method under test: {@link ImmutableSetting.Builder#restricted(boolean)}
   */
  @Test
  void testBuilderRestricted() {
    // Arrange
    ImmutableSetting.Builder builderResult = ImmutableSetting.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.restricted(true));
  }

  /**
   * Method under test: {@link ImmutableSetting.Builder#value(Optional)}
   */
  @Test
  void testBuilderValue() {
    // Arrange
    ImmutableSetting.Builder builderResult = ImmutableSetting.builder();
    Optional<String> value = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.value(value));
  }

  /**
   * Method under test: {@link ImmutableSetting#copyOf(Setting)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Setting instance = mock(Setting.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.value()).thenReturn(ofResult);
    when(instance.restricted()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSetting actualCopyOfResult = ImmutableSetting.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).restricted();
    verify(instance).value();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.restricted());
  }

  /**
   * Method under test: {@link ImmutableSetting#copyOf(Setting)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    Setting instance = mock(Setting.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.value()).thenReturn(emptyResult);
    when(instance.restricted()).thenReturn(true);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSetting actualCopyOfResult = ImmutableSetting.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).restricted();
    verify(instance).value();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.restricted());
  }

  /**
   * Method under test: {@link ImmutableSetting#copyOf(Setting)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    Setting instance = mock(Setting.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.value()).thenReturn(ofResult);
    when(instance.restricted()).thenReturn(false);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSetting actualCopyOfResult = ImmutableSetting.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).restricted();
    verify(instance).value();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertFalse(actualCopyOfResult.restricted());
  }

  /**
   * Method under test: {@link ImmutableSetting#fromJson(ImmutableSetting.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSetting.Json json = new ImmutableSetting.Json();
    json.setName("name");

    // Act
    ImmutableSetting actualFromJsonResult = ImmutableSetting.fromJson(json);

    // Assert
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertFalse(actualFromJsonResult.restricted());
  }

  /**
   * Method under test: {@link ImmutableSetting.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSetting.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableSetting.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSetting.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSetting.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSetting.Json actualJson = new ImmutableSetting.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertFalse(actualJson.value.isPresent());
    assertFalse(actualJson.restricted);
    assertFalse(actualJson.restrictedIsSet);
  }

  /**
   * Method under test: {@link ImmutableSetting.Json#restricted()}
   */
  @Test
  void testJsonRestricted() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSetting.Json()).restricted());
  }

  /**
   * Method under test: {@link ImmutableSetting.Json#setRestricted(boolean)}
   */
  @Test
  void testJsonSetRestricted() {
    // Arrange
    ImmutableSetting.Json json = new ImmutableSetting.Json();

    // Act
    json.setRestricted(true);

    // Assert
    assertTrue(json.restricted);
    assertTrue(json.restrictedIsSet);
  }

  /**
   * Method under test: {@link ImmutableSetting.Json#value()}
   */
  @Test
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSetting.Json()).value());
  }
}
