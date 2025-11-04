package org.finos.waltz.model.entity_enum;

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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.IconProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableEntityEnumDefinitionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityEnumDefinition#builder()}
   *   <li>{@link ImmutableEntityEnumDefinition#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableEntityEnumDefinition.Builder actualIdResult = ImmutableEntityEnumDefinition.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#entityKind(EntityKind)}
   */
  @Test
  void testBuilderEntityKind() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#enumValueType(String)}
   */
  @Test
  void testBuilderEnumValueType() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.enumValueType("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableEntityEnumDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableEntityEnumDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#from(IconProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();
    IconProvider instance = mock(IconProvider.class);
    when(instance.icon()).thenReturn("Icon");

    // Act
    ImmutableEntityEnumDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).icon();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#from(IconProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();
    IconProvider instance = mock(IconProvider.class);
    when(instance.icon()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).icon();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableEntityEnumDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableEntityEnumDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityEnumDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#from(EntityEnumDefinition)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();
    EntityEnumDefinition instance = mock(EntityEnumDefinition.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isEditable()).thenReturn(true);
    when(instance.enumValueType()).thenReturn("42");
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.icon()).thenReturn("Icon");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityEnumDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).icon();
    verify(instance).id();
    verify(instance).name();
    verify(instance).entityKind();
    verify(instance).enumValueType();
    verify(instance).isEditable();
    verify(instance).position();
    ImmutableEntityEnumDefinition buildResult = builderResult.build();
    assertEquals("42", buildResult.enumValueType());
    assertEquals("Icon", buildResult.icon());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertTrue(buildResult.isEditable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#from(EntityEnumDefinition)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();
    EntityEnumDefinition instance = mock(EntityEnumDefinition.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.isEditable()).thenReturn(true);
    when(instance.enumValueType()).thenReturn("42");
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.icon()).thenReturn("Icon");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).icon();
    verify(instance).id();
    verify(instance).name();
    verify(instance).entityKind();
    verify(instance).enumValueType();
    verify(instance).isEditable();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#from(EntityEnumDefinition)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();
    EntityEnumDefinition instance = mock(EntityEnumDefinition.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.isEditable()).thenReturn(true);
    when(instance.enumValueType()).thenReturn("42");
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.icon()).thenReturn("Icon");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityEnumDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).icon();
    verify(instance).id();
    verify(instance).name();
    verify(instance).entityKind();
    verify(instance).enumValueType();
    verify(instance).isEditable();
    verify(instance).position();
    ImmutableEntityEnumDefinition buildResult = builderResult.build();
    assertEquals("42", buildResult.enumValueType());
    assertEquals("Icon", buildResult.icon());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertTrue(buildResult.isEditable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#from(EntityEnumDefinition)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();
    EntityEnumDefinition instance = mock(EntityEnumDefinition.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isEditable()).thenReturn(true);
    when(instance.enumValueType()).thenReturn("42");
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.icon()).thenReturn("Icon");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityEnumDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).icon();
    verify(instance).id();
    verify(instance).name();
    verify(instance).entityKind();
    verify(instance).enumValueType();
    verify(instance).isEditable();
    verify(instance).position();
    ImmutableEntityEnumDefinition buildResult = builderResult.build();
    assertEquals("42", buildResult.enumValueType());
    assertEquals("Icon", buildResult.icon());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertTrue(buildResult.isEditable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntityEnumDefinition.Builder#icon(String)}
   */
  @Test
  void testBuilderIcon() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.icon("Icon"));
  }

  /**
   * Method under test: {@link ImmutableEntityEnumDefinition.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableEntityEnumDefinition.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#isEditable(boolean)}
   */
  @Test
  void testBuilderIsEditable() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isEditable(true));
  }

  /**
   * Method under test: {@link ImmutableEntityEnumDefinition.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableEntityEnumDefinition.Builder builderResult = ImmutableEntityEnumDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition#copyOf(EntityEnumDefinition)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityEnumDefinition instance = mock(EntityEnumDefinition.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isEditable()).thenReturn(true);
    when(instance.enumValueType()).thenReturn("42");
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.icon()).thenReturn("Icon");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityEnumDefinition actualCopyOfResult = ImmutableEntityEnumDefinition.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).icon();
    verify(instance).id();
    verify(instance).name();
    verify(instance).entityKind();
    verify(instance).enumValueType();
    verify(instance).isEditable();
    verify(instance).position();
    assertEquals("42", actualCopyOfResult.enumValueType());
    assertEquals("Icon", actualCopyOfResult.icon());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertTrue(actualCopyOfResult.isEditable());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition#copyOf(EntityEnumDefinition)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    EntityEnumDefinition instance = mock(EntityEnumDefinition.class);
    when(instance.position()).thenReturn(1);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.isEditable()).thenReturn(true);
    when(instance.enumValueType()).thenReturn("42");
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.icon()).thenReturn("Icon");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEntityEnumDefinition actualCopyOfResult = ImmutableEntityEnumDefinition.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).icon();
    verify(instance).id();
    verify(instance).name();
    verify(instance).entityKind();
    verify(instance).enumValueType();
    verify(instance).isEditable();
    verify(instance).position();
    assertEquals("42", actualCopyOfResult.enumValueType());
    assertEquals("Icon", actualCopyOfResult.icon());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertTrue(actualCopyOfResult.isEditable());
  }

  /**
   * Method under test: {@link ImmutableEntityEnumDefinition.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityEnumDefinition.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableEntityEnumDefinition.Json#entityKind()}
   */
  @Test
  void testJsonEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityEnumDefinition.Json()).entityKind());
  }

  /**
   * Method under test: {@link ImmutableEntityEnumDefinition.Json#enumValueType()}
   */
  @Test
  void testJsonEnumValueType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityEnumDefinition.Json()).enumValueType());
  }

  /**
   * Method under test: {@link ImmutableEntityEnumDefinition.Json#icon()}
   */
  @Test
  void testJsonIcon() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityEnumDefinition.Json()).icon());
  }

  /**
   * Method under test: {@link ImmutableEntityEnumDefinition.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityEnumDefinition.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableEntityEnumDefinition.Json#isEditable()}
   */
  @Test
  void testJsonIsEditable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityEnumDefinition.Json()).isEditable());
  }

  /**
   * Method under test: {@link ImmutableEntityEnumDefinition.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityEnumDefinition.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntityEnumDefinition.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityEnumDefinition.Json actualJson = new ImmutableEntityEnumDefinition.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.enumValueType);
    assertNull(actualJson.icon);
    assertNull(actualJson.name);
    assertNull(actualJson.entityKind);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isEditable);
    assertFalse(actualJson.isEditableIsSet);
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntityEnumDefinition.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityEnumDefinition.Json()).position());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Json#setIsEditable(boolean)}
   */
  @Test
  void testJsonSetIsEditable() {
    // Arrange
    ImmutableEntityEnumDefinition.Json json = new ImmutableEntityEnumDefinition.Json();

    // Act
    json.setIsEditable(true);

    // Assert
    assertTrue(json.isEditable);
    assertTrue(json.isEditableIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityEnumDefinition.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableEntityEnumDefinition.Json json = new ImmutableEntityEnumDefinition.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }
}
