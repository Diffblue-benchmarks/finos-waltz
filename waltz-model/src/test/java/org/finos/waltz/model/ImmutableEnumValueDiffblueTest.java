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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableEnumValue.Builder;
import org.finos.waltz.model.ImmutableEnumValue.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEnumValueDiffblueTest {
  /**
   * Test {@link ImmutableEnumValue#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEnumValue#builder()}
   *   <li>{@link ImmutableEnumValue#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableEnumValue Builder.build()", "Builder Builder.description(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableEnumValue.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
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
    Builder builderResult = ImmutableEnumValue.builder();
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
    Builder builderResult = ImmutableEnumValue.builder();
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
    Builder builderResult = ImmutableEnumValue.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EnumValue)} with {@code EnumValue}.
   * <p>
   * Method under test: {@link Builder#from(EnumValue)}
   */
  @Test
  @DisplayName("Test Builder from(EnumValue) with 'EnumValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EnumValue)"})
  void testBuilderFromWithEnumValue() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();
    EnumValue instance = mock(EnumValue.class);
    when(instance.key()).thenReturn("Key");
    when(instance.type()).thenReturn("Type");
    when(instance.iconColor()).thenReturn("Icon Color");
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.icon()).thenReturn("Icon");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(EnumValue)} with {@code EnumValue}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EnumValue)}
   */
  @Test
  @DisplayName("Test Builder from(EnumValue) with 'EnumValue'; then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EnumValue)"})
  void testBuilderFromWithEnumValue_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();
    EnumValue instance = mock(EnumValue.class);
    when(instance.key()).thenReturn("Key");
    when(instance.type()).thenReturn("Type");
    when(instance.iconColor()).thenReturn("Icon Color");
    when(instance.position()).thenReturn(1);
    when(instance.description()).thenReturn(null);
    when(instance.icon()).thenReturn("Icon");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(EnumValue)} with {@code EnumValue}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EnumValue)}
   */
  @Test
  @DisplayName("Test Builder from(EnumValue) with 'EnumValue'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EnumValue)"})
  void testBuilderFromWithEnumValue_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();
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
   * Test Builder {@link Builder#from(IconProvider)} with {@code IconProvider}.
   * <ul>
   *   <li>Given {@code Icon}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IconProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IconProvider) with 'IconProvider'; given 'Icon'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IconProvider)"})
  void testBuilderFromWithIconProvider_givenIcon_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();
    IconProvider instance = mock(IconProvider.class);
    when(instance.icon()).thenReturn("Icon");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).icon();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IconProvider)} with {@code IconProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IconProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IconProvider) with 'IconProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IconProvider)"})
  void testBuilderFromWithIconProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();
    IconProvider instance = mock(IconProvider.class);
    when(instance.icon()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).icon();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'; given one; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider_givenOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();
    PositionProvider instance = mock(PositionProvider.class);
    when(instance.position()).thenReturn(1);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).position();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();
    PositionProvider instance = mock(PositionProvider.class);
    when(instance.position()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).position();
  }

  /**
   * Test Builder {@link Builder#icon(String)}.
   * <p>
   * Method under test: {@link Builder#icon(String)}
   */
  @Test
  @DisplayName("Test Builder icon(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.icon(String)"})
  void testBuilderIcon() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.icon("Icon"));
  }

  /**
   * Test Builder {@link Builder#iconColor(String)}.
   * <p>
   * Method under test: {@link Builder#iconColor(String)}
   */
  @Test
  @DisplayName("Test Builder iconColor(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.iconColor(String)"})
  void testBuilderIconColor() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.iconColor("Icon Color"));
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
    Builder builderResult = ImmutableEnumValue.builder();

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
    Builder builderResult = ImmutableEnumValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   * <p>
   * Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Test Builder {@link Builder#type(String)}.
   * <p>
   * Method under test: {@link Builder#type(String)}
   */
  @Test
  @DisplayName("Test Builder type(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.type(String)"})
  void testBuilderType() {
    // Arrange
    Builder builderResult = ImmutableEnumValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.type("Type"));
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
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setIcon(String)}
   *   <li>{@link Json#setIconColor(String)}
   *   <li>{@link Json#setKey(String)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setType(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDescription(String)", "void Json.setIcon(String)",
      "void Json.setIconColor(String)", "void Json.setKey(String)", "void Json.setName(String)",
      "void Json.setType(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
   * Test Json {@link Json#icon()}.
   * <p>
   * Method under test: {@link Json#icon()}
   */
  @Test
  @DisplayName("Test Json icon()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.icon()"})
  void testJsonIcon() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).icon());
  }

  /**
   * Test Json {@link Json#iconColor()}.
   * <p>
   * Method under test: {@link Json#iconColor()}
   */
  @Test
  @DisplayName("Test Json iconColor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.iconColor()"})
  void testJsonIconColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).iconColor());
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
   * Test Json {@link Json#position()}.
   * <p>
   * Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).position());
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   * <p>
   * Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
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
}
