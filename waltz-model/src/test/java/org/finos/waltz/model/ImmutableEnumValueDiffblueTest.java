package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableEnumValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEnumValue#builder()}
   *   <li>{@link ImmutableEnumValue#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableEnumValue.Builder actualBuilderResult = ImmutableEnumValue.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutableEnumValue.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableEnumValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEnumValue.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableEnumValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEnumValue.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Builder#from(EnumValue)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();
    EnumValue instance = mock(EnumValue.class);
    when(instance.key()).thenReturn("Key");
    when(instance.type()).thenReturn("Type");
    when(instance.iconColor()).thenReturn("Icon Color");
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.icon()).thenReturn("Icon");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEnumValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).iconColor();
    verify(instance).key();
    verify(instance).type();
    verify(instance).icon();
    verify(instance).name();
    verify(instance).position();
    ImmutableEnumValue buildResult = builderResult.build();
    assertEquals("Icon Color", buildResult.iconColor());
    assertEquals("Icon", buildResult.icon());
    assertEquals("Key", buildResult.key());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("Type", buildResult.type());
    assertEquals(1, buildResult.position());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Builder#from(EnumValue)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();
    EnumValue instance = mock(EnumValue.class);
    when(instance.key()).thenThrow(new IllegalStateException("instance"));
    when(instance.type()).thenReturn("Type");
    when(instance.iconColor()).thenReturn("Icon Color");
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.icon()).thenReturn("Icon");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).iconColor();
    verify(instance).key();
    verify(instance).type();
    verify(instance).icon();
    verify(instance).name();
    verify(instance).position();
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Builder#from(EnumValue)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();
    EnumValue instance = mock(EnumValue.class);
    when(instance.key()).thenReturn("Key");
    when(instance.type()).thenReturn("Type");
    when(instance.iconColor()).thenReturn("Icon Color");
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn(null);
    when(instance.icon()).thenReturn("Icon");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEnumValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).iconColor();
    verify(instance).key();
    verify(instance).type();
    verify(instance).icon();
    verify(instance).name();
    verify(instance).position();
    ImmutableEnumValue buildResult = builderResult.build();
    assertEquals("Icon Color", buildResult.iconColor());
    assertEquals("Icon", buildResult.icon());
    assertEquals("Key", buildResult.key());
    assertEquals("Name", buildResult.name());
    assertEquals("Type", buildResult.type());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.position());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Builder#from(IconProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();
    IconProvider instance = mock(IconProvider.class);
    when(instance.icon()).thenReturn("Icon");

    // Act
    ImmutableEnumValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).icon();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Builder#from(IconProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();
    IconProvider instance = mock(IconProvider.class);
    when(instance.icon()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).icon();
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEnumValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Builder#from(PositionProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();
    PositionProvider instance = mock(PositionProvider.class);
    when(instance.position()).thenReturn(1);

    // Act
    ImmutableEnumValue.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).position();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Builder#from(PositionProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();
    PositionProvider instance = mock(PositionProvider.class);
    when(instance.position()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).position();
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Builder#icon(String)}
   */
  @Test
  void testBuilderIcon() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.icon("Icon"));
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Builder#iconColor(String)}
   */
  @Test
  void testBuilderIconColor() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.iconColor("Icon Color"));
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Builder#key(String)}
   */
  @Test
  void testBuilderKey() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Builder#type(String)}
   */
  @Test
  void testBuilderType() {
    // Arrange
    ImmutableEnumValue.Builder builderResult = ImmutableEnumValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.type("Type"));
  }

  /**
   * Method under test: {@link ImmutableEnumValue#copyOf(EnumValue)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EnumValue instance = mock(EnumValue.class);
    when(instance.key()).thenReturn("Key");
    when(instance.type()).thenReturn("Type");
    when(instance.iconColor()).thenReturn("Icon Color");
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.icon()).thenReturn("Icon");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEnumValue actualCopyOfResult = ImmutableEnumValue.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).iconColor();
    verify(instance).key();
    verify(instance).type();
    verify(instance).icon();
    verify(instance).name();
    verify(instance).position();
    assertEquals("Icon Color", actualCopyOfResult.iconColor());
    assertEquals("Icon", actualCopyOfResult.icon());
    assertEquals("Key", actualCopyOfResult.key());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Type", actualCopyOfResult.type());
    assertEquals(1, actualCopyOfResult.position());
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEnumValue.Json()).description());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableEnumValue.Json}
   *   <li>{@link ImmutableEnumValue.Json#setDescription(String)}
   *   <li>{@link ImmutableEnumValue.Json#setIcon(String)}
   *   <li>{@link ImmutableEnumValue.Json#setIconColor(String)}
   *   <li>{@link ImmutableEnumValue.Json#setKey(String)}
   *   <li>{@link ImmutableEnumValue.Json#setName(String)}
   *   <li>{@link ImmutableEnumValue.Json#setType(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableEnumValue.Json actualJson = new ImmutableEnumValue.Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setIcon("Icon");
    actualJson.setIconColor("Icon Color");
    actualJson.setKey("Key");
    actualJson.setName("Name");
    actualJson.setType("Type");

    // Assert
    assertEquals("Icon Color", actualJson.iconColor);
    assertEquals("Icon", actualJson.icon);
    assertEquals("Key", actualJson.key);
    assertEquals("Name", actualJson.name);
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals("Type", actualJson.type);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Json#icon()}
   */
  @Test
  void testJsonIcon() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEnumValue.Json()).icon());
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Json#iconColor()}
   */
  @Test
  void testJsonIconColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEnumValue.Json()).iconColor());
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Json#key()}
   */
  @Test
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEnumValue.Json()).key());
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEnumValue.Json()).name());
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEnumValue.Json()).position());
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableEnumValue.Json json = new ImmutableEnumValue.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Method under test: {@link ImmutableEnumValue.Json#type()}
   */
  @Test
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEnumValue.Json()).type());
  }
}
