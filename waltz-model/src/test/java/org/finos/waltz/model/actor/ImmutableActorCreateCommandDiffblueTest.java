package org.finos.waltz.model.actor;

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
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableActorCreateCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableActorCreateCommand#builder()}
   *   <li>{@link ImmutableActorCreateCommand#description(String)}
   *   <li>{@link ImmutableActorCreateCommand#externalId(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableActorCreateCommand.Builder actualExternalIdResult = ImmutableActorCreateCommand.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");

    // Assert
    assertSame(actualExternalIdResult, actualExternalIdResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableActorCreateCommand.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableActorCreateCommand.Builder builderResult = ImmutableActorCreateCommand.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableActorCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableActorCreateCommand.Builder builderResult = ImmutableActorCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableActorCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableActorCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableActorCreateCommand.Builder builderResult = ImmutableActorCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableActorCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableActorCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableActorCreateCommand.Builder builderResult = ImmutableActorCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableActorCreateCommand.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableActorCreateCommand.Builder builderResult = ImmutableActorCreateCommand.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableActorCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableActorCreateCommand.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableActorCreateCommand.Builder builderResult = ImmutableActorCreateCommand.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableActorCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableActorCreateCommand.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableActorCreateCommand.Builder builderResult = ImmutableActorCreateCommand.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableActorCreateCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableActorCreateCommand.Builder builderResult = ImmutableActorCreateCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableActorCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableActorCreateCommand.Builder#from(ActorCreateCommand)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableActorCreateCommand.Builder builderResult = ImmutableActorCreateCommand.builder();
    ActorCreateCommand instance = mock(ActorCreateCommand.class);
    when(instance.isExternal()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableActorCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).isExternal();
    ImmutableActorCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertTrue(buildResult.isExternal());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableActorCreateCommand.Builder#from(ActorCreateCommand)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableActorCreateCommand.Builder builderResult = ImmutableActorCreateCommand.builder();
    ActorCreateCommand instance = mock(ActorCreateCommand.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableActorCreateCommand.Builder#from(ActorCreateCommand)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableActorCreateCommand.Builder builderResult = ImmutableActorCreateCommand.builder();
    ActorCreateCommand instance = mock(ActorCreateCommand.class);
    when(instance.isExternal()).thenReturn(true);
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableActorCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).isExternal();
    ImmutableActorCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertTrue(buildResult.isExternal());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableActorCreateCommand.Builder#from(ActorCreateCommand)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableActorCreateCommand.Builder builderResult = ImmutableActorCreateCommand.builder();
    ActorCreateCommand instance = mock(ActorCreateCommand.class);
    when(instance.isExternal()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableActorCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).isExternal();
    ImmutableActorCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertTrue(buildResult.isExternal());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableActorCreateCommand.Builder#isExternal(boolean)}
   */
  @Test
  void testBuilderIsExternal() {
    // Arrange
    ImmutableActorCreateCommand.Builder builderResult = ImmutableActorCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isExternal(true));
  }

  /**
   * Method under test: {@link ImmutableActorCreateCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableActorCreateCommand.Builder builderResult = ImmutableActorCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableActorCreateCommand#copyOf(ActorCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ActorCreateCommand instance = mock(ActorCreateCommand.class);
    when(instance.isExternal()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableActorCreateCommand actualCopyOfResult = ImmutableActorCreateCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).isExternal();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.isExternal());
  }

  /**
   * Method under test:
   * {@link ImmutableActorCreateCommand#copyOf(ActorCreateCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ActorCreateCommand instance = mock(ActorCreateCommand.class);
    when(instance.isExternal()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableActorCreateCommand actualCopyOfResult = ImmutableActorCreateCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).isExternal();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.isExternal());
  }

  /**
   * Method under test: {@link ImmutableActorCreateCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActorCreateCommand.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableActorCreateCommand.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActorCreateCommand.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableActorCreateCommand.Json#isExternal()}
   */
  @Test
  void testJsonIsExternal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActorCreateCommand.Json()).isExternal());
  }

  /**
   * Method under test: {@link ImmutableActorCreateCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActorCreateCommand.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableActorCreateCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableActorCreateCommand.Json actualJson = new ImmutableActorCreateCommand.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.isExternal);
    assertFalse(actualJson.isExternalIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableActorCreateCommand.Json#setIsExternal(boolean)}
   */
  @Test
  void testJsonSetIsExternal() {
    // Arrange
    ImmutableActorCreateCommand.Json json = new ImmutableActorCreateCommand.Json();

    // Act
    json.setIsExternal(true);

    // Assert
    assertTrue(json.isExternal);
    assertTrue(json.isExternalIsSet);
  }
}
