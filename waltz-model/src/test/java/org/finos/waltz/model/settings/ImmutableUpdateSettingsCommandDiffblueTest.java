package org.finos.waltz.model.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableUpdateSettingsCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUpdateSettingsCommand#builder()}
   *   <li>{@link ImmutableUpdateSettingsCommand#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableUpdateSettingsCommand.Builder actualBuilderResult = ImmutableUpdateSettingsCommand.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateSettingsCommand.Builder#from(UpdateSettingsCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUpdateSettingsCommand.Builder builderResult = ImmutableUpdateSettingsCommand.builder();
    UpdateSettingsCommand instance = mock(UpdateSettingsCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.value()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableUpdateSettingsCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).value();
    ImmutableUpdateSettingsCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.value());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateSettingsCommand.Builder#from(UpdateSettingsCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUpdateSettingsCommand.Builder builderResult = ImmutableUpdateSettingsCommand.builder();
    UpdateSettingsCommand instance = mock(UpdateSettingsCommand.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.value()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).value();
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateSettingsCommand.Builder#from(UpdateSettingsCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableUpdateSettingsCommand.Builder builderResult = ImmutableUpdateSettingsCommand.builder();
    UpdateSettingsCommand instance = mock(UpdateSettingsCommand.class);
    when(instance.description()).thenReturn(null);
    when(instance.value()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableUpdateSettingsCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).value();
    ImmutableUpdateSettingsCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.value());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateSettingsCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableUpdateSettingsCommand.Builder builderResult = ImmutableUpdateSettingsCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateSettingsCommand.Builder#value(String)}
   */
  @Test
  void testBuilderValue() {
    // Arrange
    ImmutableUpdateSettingsCommand.Builder builderResult = ImmutableUpdateSettingsCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateSettingsCommand#copyOf(UpdateSettingsCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UpdateSettingsCommand instance = mock(UpdateSettingsCommand.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.value()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableUpdateSettingsCommand actualCopyOfResult = ImmutableUpdateSettingsCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).value();
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateSettingsCommand#fromJson(ImmutableUpdateSettingsCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableUpdateSettingsCommand.Json json = new ImmutableUpdateSettingsCommand.Json();
    json.setName("Json");
    json.setValue("Json");
    json.setDescription(null);

    // Act
    ImmutableUpdateSettingsCommand actualFromJsonResult = ImmutableUpdateSettingsCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.value());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Method under test: {@link ImmutableUpdateSettingsCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUpdateSettingsCommand.Json()).description());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableUpdateSettingsCommand.Json}
   *   <li>{@link ImmutableUpdateSettingsCommand.Json#setDescription(String)}
   *   <li>{@link ImmutableUpdateSettingsCommand.Json#setName(String)}
   *   <li>{@link ImmutableUpdateSettingsCommand.Json#setValue(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableUpdateSettingsCommand.Json actualJson = new ImmutableUpdateSettingsCommand.Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setName("Name");
    actualJson.setValue("42");

    // Assert
    assertEquals("42", actualJson.value);
    assertEquals("Name", actualJson.name);
    assertEquals("The characteristics of someone or something", actualJson.description);
  }

  /**
   * Method under test: {@link ImmutableUpdateSettingsCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUpdateSettingsCommand.Json()).name());
  }

  /**
   * Method under test: {@link ImmutableUpdateSettingsCommand.Json#value()}
   */
  @Test
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUpdateSettingsCommand.Json()).value());
  }
}
