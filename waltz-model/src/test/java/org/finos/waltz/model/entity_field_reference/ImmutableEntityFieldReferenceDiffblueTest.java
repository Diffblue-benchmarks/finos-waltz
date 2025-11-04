package org.finos.waltz.model.entity_field_reference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.Test;

class ImmutableEntityFieldReferenceDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityFieldReference#builder()}
   *   <li>{@link ImmutableEntityFieldReference#kind(EntityKind)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableEntityFieldReference.Builder actualIdResult = ImmutableEntityFieldReference.builder().id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableEntityFieldReference.Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.kind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityFieldReference.Builder#description(String)}
   */
  @Test
  void testBuilderDescription() {
    // Arrange
    ImmutableEntityFieldReference.Builder builderResult = ImmutableEntityFieldReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityFieldReference.Builder#displayName(String)}
   */
  @Test
  void testBuilderDisplayName() {
    // Arrange
    ImmutableEntityFieldReference.Builder builderResult = ImmutableEntityFieldReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.displayName("Display Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityFieldReference.Builder#entityKind(EntityKind)}
   */
  @Test
  void testBuilderEntityKind() {
    // Arrange
    ImmutableEntityFieldReference.Builder builderResult = ImmutableEntityFieldReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityFieldReference.Builder#fieldName(String)}
   */
  @Test
  void testBuilderFieldName() {
    // Arrange
    ImmutableEntityFieldReference.Builder builderResult = ImmutableEntityFieldReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fieldName("Field Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityFieldReference.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityFieldReference.Builder builderResult = ImmutableEntityFieldReference.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableEntityFieldReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityFieldReference.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityFieldReference.Builder builderResult = ImmutableEntityFieldReference.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableEntityFieldReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityFieldReference.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityFieldReference.Builder builderResult = ImmutableEntityFieldReference.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableEntityFieldReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityFieldReference.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntityFieldReference.Builder builderResult = ImmutableEntityFieldReference.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityFieldReference.Builder#from(EntityFieldReference)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntityFieldReference.Builder builderResult = ImmutableEntityFieldReference.builder();
    EntityFieldReference instance = mock(EntityFieldReference.class);
    when(instance.displayName()).thenReturn("Display Name");
    when(instance.fieldName()).thenReturn("Field Name");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableEntityFieldReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).description();
    verify(instance).displayName();
    verify(instance).entityKind();
    verify(instance).fieldName();
    verify(instance).kind();
    ImmutableEntityFieldReference buildResult = builderResult.build();
    assertEquals("Display Name", buildResult.displayName());
    assertEquals("Field Name", buildResult.fieldName());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityFieldReference.Builder#from(EntityFieldReference)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEntityFieldReference.Builder builderResult = ImmutableEntityFieldReference.builder();
    EntityFieldReference instance = mock(EntityFieldReference.class);
    when(instance.displayName()).thenThrow(new IllegalStateException("instance"));
    when(instance.fieldName()).thenReturn("Field Name");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).description();
    verify(instance).displayName();
    verify(instance).entityKind();
    verify(instance).fieldName();
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityFieldReference.Builder#from(EntityFieldReference)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEntityFieldReference.Builder builderResult = ImmutableEntityFieldReference.builder();
    EntityFieldReference instance = mock(EntityFieldReference.class);
    when(instance.displayName()).thenReturn("Display Name");
    when(instance.fieldName()).thenReturn("Field Name");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableEntityFieldReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).description();
    verify(instance).displayName();
    verify(instance).entityKind();
    verify(instance).fieldName();
    verify(instance).kind();
    ImmutableEntityFieldReference buildResult = builderResult.build();
    assertEquals("Display Name", buildResult.displayName());
    assertEquals("Field Name", buildResult.fieldName());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableEntityFieldReference.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableEntityFieldReference.Builder builderResult = ImmutableEntityFieldReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableEntityFieldReference.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableEntityFieldReference.Builder builderResult = ImmutableEntityFieldReference.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityFieldReference#copyOf(EntityFieldReference)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityFieldReference instance = mock(EntityFieldReference.class);
    when(instance.displayName()).thenReturn("Display Name");
    when(instance.fieldName()).thenReturn("Field Name");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableEntityFieldReference actualCopyOfResult = ImmutableEntityFieldReference.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).description();
    verify(instance).displayName();
    verify(instance).entityKind();
    verify(instance).fieldName();
    verify(instance).kind();
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals("Field Name", actualCopyOfResult.fieldName());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityFieldReference#copyOf(EntityFieldReference)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    EntityFieldReference instance = mock(EntityFieldReference.class);
    when(instance.displayName()).thenReturn("Display Name");
    when(instance.fieldName()).thenReturn("Field Name");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableEntityFieldReference actualCopyOfResult = ImmutableEntityFieldReference.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).description();
    verify(instance).displayName();
    verify(instance).entityKind();
    verify(instance).fieldName();
    verify(instance).kind();
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals("Field Name", actualCopyOfResult.fieldName());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityFieldReference#fromJson(ImmutableEntityFieldReference.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableEntityFieldReference.Json json = new ImmutableEntityFieldReference.Json();
    json.setId(null);
    json.setEntityKind(EntityKind.ALL);
    json.setFieldName("Json");
    json.setDisplayName("Json");
    json.setDescription("Json");
    json.setKind(null);

    // Act
    ImmutableEntityFieldReference actualFromJsonResult = ImmutableEntityFieldReference.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.displayName());
    assertEquals("Json", actualFromJsonResult.fieldName());
    assertEquals(EntityKind.ALL, actualFromJsonResult.entityKind());
    assertEquals(EntityKind.ENTITY_FIELD_REFERENCE, actualFromJsonResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityFieldReference#fromJson(ImmutableEntityFieldReference.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableEntityFieldReference.Json json = new ImmutableEntityFieldReference.Json();
    json.setId(null);
    json.setEntityKind(EntityKind.ALL);
    json.setFieldName("Json");
    json.setDisplayName("Json");
    json.setDescription("Json");
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableEntityFieldReference actualFromJsonResult = ImmutableEntityFieldReference.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.displayName());
    assertEquals("Json", actualFromJsonResult.fieldName());
    assertEquals(EntityKind.ALL, actualFromJsonResult.entityKind());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
  }

  /**
   * Method under test: {@link ImmutableEntityFieldReference.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityFieldReference.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableEntityFieldReference.Json#displayName()}
   */
  @Test
  void testJsonDisplayName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityFieldReference.Json()).displayName());
  }

  /**
   * Method under test: {@link ImmutableEntityFieldReference.Json#entityKind()}
   */
  @Test
  void testJsonEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityFieldReference.Json()).entityKind());
  }

  /**
   * Method under test: {@link ImmutableEntityFieldReference.Json#fieldName()}
   */
  @Test
  void testJsonFieldName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityFieldReference.Json()).fieldName());
  }

  /**
   * Method under test: {@link ImmutableEntityFieldReference.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityFieldReference.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableEntityFieldReference.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityFieldReference.Json()).kind());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntityFieldReference.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityFieldReference.Json actualJson = new ImmutableEntityFieldReference.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.displayName);
    assertNull(actualJson.fieldName);
    assertNull(actualJson.entityKind);
    assertNull(actualJson.kind);
    assertFalse(actualJson.id.isPresent());
  }
}
