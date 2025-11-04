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
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ImmutableEntityReferenceDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityReference#builder()}
   *   <li>{@link ImmutableEntityReference#description(String)}
   *   <li>
   * {@link ImmutableEntityReference#entityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link ImmutableEntityReference#externalId(String)}
   *   <li>{@link ImmutableEntityReference#name(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableEntityReference.Builder actualExternalIdResult = ImmutableEntityReference.builder()
        .description("The characteristics of someone or something")
        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableEntityReference.Builder actualNameResult = actualExternalIdResult.externalId(externalId).name("Name");
    Optional<String> name = Optional.of("foo");

    // Assert
    assertSame(actualNameResult, actualNameResult.name(name));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReference.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableEntityReference.Builder builderResult = ImmutableEntityReference.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReference.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityReference.Builder builderResult = ImmutableEntityReference.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableEntityReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReference.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityReference.Builder builderResult = ImmutableEntityReference.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableEntityReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReference.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityReference.Builder builderResult = ImmutableEntityReference.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableEntityReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReference.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntityReference.Builder builderResult = ImmutableEntityReference.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatus();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReference.Builder#from(EntityReference)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntityReference.Builder builderResult = ImmutableEntityReference.builder();
    EntityReference instance = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult2);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableEntityReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    ImmutableEntityReference buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.id());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReference.Builder#from(EntityReference)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEntityReference.Builder builderResult = ImmutableEntityReference.builder();
    EntityReference instance = mock(EntityReference.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReference.Builder#from(EntityReference)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEntityReference.Builder builderResult = ImmutableEntityReference.builder();
    EntityReference instance = mock(EntityReference.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableEntityReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    ImmutableEntityReference buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.id());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReference.Builder#from(EntityReference)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableEntityReference.Builder builderResult = ImmutableEntityReference.builder();
    EntityReference instance = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.name()).thenReturn(emptyResult);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableEntityReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    ImmutableEntityReference buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.id());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReference.Builder#from(EntityReference)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableEntityReference.Builder builderResult = ImmutableEntityReference.builder();
    EntityReference instance = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult2);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableEntityReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    ImmutableEntityReference buildResult = builderResult.build();
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.id());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReference.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableEntityReference.Builder builderResult = ImmutableEntityReference.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableEntityReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReference.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableEntityReference.Builder builderResult = ImmutableEntityReference.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableEntityReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReference.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableEntityReference.Builder builderResult = ImmutableEntityReference.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableEntityReference.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableEntityReference.Builder builderResult = ImmutableEntityReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableEntityReference.Builder#kind(EntityKind)}
   */
  @Test
  void testBuilderKind() {
    // Arrange
    ImmutableEntityReference.Builder builderResult = ImmutableEntityReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutableEntityReference.Builder#name(Optional)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableEntityReference.Builder builderResult = ImmutableEntityReference.builder();
    Optional<String> name = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.name(name));
  }

  /**
   * Method under test: {@link ImmutableEntityReference#copyOf(EntityReference)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityReference instance = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult2);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableEntityReference actualCopyOfResult = ImmutableEntityReference.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableEntityReference#copyOf(EntityReference)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    EntityReference instance = mock(EntityReference.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableEntityReference actualCopyOfResult = ImmutableEntityReference.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableEntityReference#copyOf(EntityReference)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    EntityReference instance = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.name()).thenReturn(emptyResult);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableEntityReference actualCopyOfResult = ImmutableEntityReference.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableEntityReference#copyOf(EntityReference)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    EntityReference instance = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult2);
    when(instance.id()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableEntityReference actualCopyOfResult = ImmutableEntityReference.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).kind();
    verify(instance).name();
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableEntityReference.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityReference.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReference.Json#entityLifecycleStatus()}
   */
  @Test
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityReference.Json()).entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableEntityReference.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityReference.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableEntityReference.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityReference.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableEntityReference.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityReference.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableEntityReference.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityReference.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntityReference.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityReference.Json actualJson = new ImmutableEntityReference.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityLifecycleStatus);
    assertEquals(0L, actualJson.id);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.name.isPresent());
    assertFalse(actualJson.idIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntityReference.Json#setId(long)}
   */
  @Test
  void testJsonSetId() {
    // Arrange
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
  }
}
