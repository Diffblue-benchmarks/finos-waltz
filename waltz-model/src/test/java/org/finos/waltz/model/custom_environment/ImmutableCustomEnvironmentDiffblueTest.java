package org.finos.waltz.model.custom_environment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableCustomEnvironmentDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCustomEnvironment#builder()}
   *   <li>{@link ImmutableCustomEnvironment#description(String)}
   *   <li>{@link ImmutableCustomEnvironment#externalId(String)}
   *   <li>{@link ImmutableCustomEnvironment#groupName(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableCustomEnvironment.Builder actualDescriptionResult = ImmutableCustomEnvironment.builder()
        .description("The characteristics of someone or something");
    Optional<String> description = Optional.of("foo");
    ImmutableCustomEnvironment.Builder actualExternalIdResult = actualDescriptionResult.description(description)
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableCustomEnvironment.Builder actualIdResult = actualExternalIdResult.externalId(externalId)
        .groupName("Group Name")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironment.Builder#description(Optional)}
   */
  @Test
  void testBuilderDescription() {
    // Arrange
    ImmutableCustomEnvironment.Builder builderResult = ImmutableCustomEnvironment.builder();
    Optional<String> description = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.description(description));
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironment.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableCustomEnvironment.Builder builderResult = ImmutableCustomEnvironment.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironment.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCustomEnvironment.Builder builderResult = ImmutableCustomEnvironment.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableCustomEnvironment.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironment.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCustomEnvironment.Builder builderResult = ImmutableCustomEnvironment.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableCustomEnvironment.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironment.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableCustomEnvironment.Builder builderResult = ImmutableCustomEnvironment.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironment.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableCustomEnvironment.Builder builderResult = ImmutableCustomEnvironment.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableCustomEnvironment.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironment.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableCustomEnvironment.Builder builderResult = ImmutableCustomEnvironment.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableCustomEnvironment.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironment.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableCustomEnvironment.Builder builderResult = ImmutableCustomEnvironment.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironment.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableCustomEnvironment.Builder builderResult = ImmutableCustomEnvironment.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableCustomEnvironment.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironment.Builder#from(CustomEnvironment)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableCustomEnvironment.Builder builderResult = ImmutableCustomEnvironment.builder();
    CustomEnvironment instance = mock(CustomEnvironment.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult2);
    when(instance.groupName()).thenReturn("Group Name");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).description();
    verify(instance).groupName();
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironment.Builder#from(CustomEnvironment)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableCustomEnvironment.Builder builderResult = ImmutableCustomEnvironment.builder();
    CustomEnvironment instance = mock(CustomEnvironment.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.owningEntity()).thenReturn(mock(EntityReference.class));
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult3);
    when(instance.groupName()).thenReturn("Group Name");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableCustomEnvironment.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).description();
    verify(instance).groupName();
    verify(instance).owningEntity();
    ImmutableCustomEnvironment buildResult = builderResult.build();
    assertEquals("Group Name", buildResult.groupName());
    assertEquals("Name", buildResult.name());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCustomEnvironment.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableCustomEnvironment.Builder builderResult = ImmutableCustomEnvironment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableCustomEnvironment.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableCustomEnvironment.Builder builderResult = ImmutableCustomEnvironment.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableCustomEnvironment.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableCustomEnvironment.Builder builderResult = ImmutableCustomEnvironment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironment.Builder#owningEntity(EntityReference)}
   */
  @Test
  void testBuilderOwningEntity() {
    // Arrange
    ImmutableCustomEnvironment.Builder builderResult = ImmutableCustomEnvironment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.owningEntity(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironment#copyOf(CustomEnvironment)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CustomEnvironment instance = mock(CustomEnvironment.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.owningEntity()).thenReturn(mock(EntityReference.class));
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult3);
    when(instance.groupName()).thenReturn("Group Name");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableCustomEnvironment actualCopyOfResult = ImmutableCustomEnvironment.copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).description();
    verify(instance).groupName();
    verify(instance).owningEntity();
    assertEquals("Group Name", actualCopyOfResult.groupName());
    assertEquals("Name", actualCopyOfResult.name());
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironment#fromJson(ImmutableCustomEnvironment.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableCustomEnvironment.Json json = new ImmutableCustomEnvironment.Json();
    json.setId(null);
    json.setName("Json");
    json.setExternalId(null);
    json.setOwningEntity(mock(EntityReference.class));
    json.setDescription(null);
    json.setGroupName(null);

    // Act
    ImmutableCustomEnvironment actualFromJsonResult = ImmutableCustomEnvironment.fromJson(json);

    // Assert
    assertEquals("Default", actualFromJsonResult.groupName());
    assertEquals("Json", actualFromJsonResult.name());
    EntityReference expectedOwningEntityResult = json.owningEntity;
    assertSame(expectedOwningEntityResult, actualFromJsonResult.owningEntity());
  }

  /**
   * Method under test:
   * {@link ImmutableCustomEnvironment#fromJson(ImmutableCustomEnvironment.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableCustomEnvironment.Json json = new ImmutableCustomEnvironment.Json();
    json.setId(null);
    json.setName("Json");
    json.setExternalId(null);
    json.setOwningEntity(mock(EntityReference.class));
    json.setDescription(null);
    json.setGroupName("name");

    // Act
    ImmutableCustomEnvironment actualFromJsonResult = ImmutableCustomEnvironment.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("name", actualFromJsonResult.groupName());
    EntityReference expectedOwningEntityResult = json.owningEntity;
    assertSame(expectedOwningEntityResult, actualFromJsonResult.owningEntity());
  }

  /**
   * Method under test: {@link ImmutableCustomEnvironment.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCustomEnvironment.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableCustomEnvironment.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCustomEnvironment.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableCustomEnvironment.Json#groupName()}
   */
  @Test
  void testJsonGroupName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCustomEnvironment.Json()).groupName());
  }

  /**
   * Method under test: {@link ImmutableCustomEnvironment.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCustomEnvironment.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableCustomEnvironment.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCustomEnvironment.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableCustomEnvironment.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableCustomEnvironment.Json actualJson = new ImmutableCustomEnvironment.Json();

    // Assert
    assertNull(actualJson.groupName);
    assertNull(actualJson.name);
    assertNull(actualJson.owningEntity);
    assertFalse(actualJson.description.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test: {@link ImmutableCustomEnvironment.Json#owningEntity()}
   */
  @Test
  void testJsonOwningEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCustomEnvironment.Json()).owningEntity());
  }
}
