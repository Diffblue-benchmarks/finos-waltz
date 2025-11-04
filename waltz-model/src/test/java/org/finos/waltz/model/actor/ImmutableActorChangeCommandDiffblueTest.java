package org.finos.waltz.model.actor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.command.EntityChangeCommand;
import org.junit.jupiter.api.Test;

class ImmutableActorChangeCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableActorChangeCommand.Builder#from(EntityChangeCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableActorChangeCommand.Builder builderResult = ImmutableActorChangeCommand.builder();
    EntityChangeCommand instance = mock(EntityChangeCommand.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdate()).thenReturn(ofResult);
    when(instance.id()).thenReturn(1L);

    // Act
    ImmutableActorChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdate();
    assertEquals(1L, actualFromResult.build().id());
    assertEquals(1L, builderResult.build().id());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableActorChangeCommand.Builder#from(EntityChangeCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableActorChangeCommand.Builder builderResult = ImmutableActorChangeCommand.builder();
    EntityChangeCommand instance = mock(EntityChangeCommand.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.lastUpdate()).thenReturn(emptyResult);
    when(instance.id()).thenReturn(1L);

    // Act
    ImmutableActorChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdate();
    assertEquals(1L, actualFromResult.build().id());
    assertEquals(1L, builderResult.build().id());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableActorChangeCommand.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableActorChangeCommand.Builder builderResult = ImmutableActorChangeCommand.builder();

    // Act
    ImmutableActorChangeCommand.Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertEquals(1L, actualIdResult.build().id());
    assertEquals(1L, builderResult.build().id());
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Method under test: {@link ImmutableActorChangeCommand.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableActorChangeCommand.Builder builderResult = ImmutableActorChangeCommand.builder();
    builderResult.lastUpdate(mock(UserTimestamp.class));

    // Act
    ImmutableActorChangeCommand.Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertEquals(1L, actualIdResult.build().id());
    assertEquals(1L, builderResult.build().id());
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Method under test: {@link ImmutableActorChangeCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActorChangeCommand.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableActorChangeCommand.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActorChangeCommand.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableActorChangeCommand.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActorChangeCommand.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableActorChangeCommand.Json#isExternal()}
   */
  @Test
  void testJsonIsExternal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActorChangeCommand.Json()).isExternal());
  }

  /**
   * Method under test: {@link ImmutableActorChangeCommand.Json#lastUpdate()}
   */
  @Test
  void testJsonLastUpdate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActorChangeCommand.Json()).lastUpdate());
  }

  /**
   * Method under test: {@link ImmutableActorChangeCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActorChangeCommand.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableActorChangeCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableActorChangeCommand.Json actualJson = new ImmutableActorChangeCommand.Json();

    // Assert
    assertEquals(0L, actualJson.id);
    assertFalse(actualJson.description.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.isExternal.isPresent());
    assertFalse(actualJson.lastUpdate.isPresent());
    assertFalse(actualJson.name.isPresent());
    assertFalse(actualJson.idIsSet);
  }

  /**
   * Method under test: {@link ImmutableActorChangeCommand.Json#setId(long)}
   */
  @Test
  void testJsonSetId() {
    // Arrange
    ImmutableActorChangeCommand.Json json = new ImmutableActorChangeCommand.Json();

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
  }

  /**
   * Method under test: {@link ImmutableActorChangeCommand.Json#setId(long)}
   */
  @Test
  void testJsonSetId2() {
    // Arrange
    ImmutableActorChangeCommand.Json json = new ImmutableActorChangeCommand.Json();
    Optional<UserTimestamp> lastUpdate = Optional.of(mock(UserTimestamp.class));
    json.setLastUpdate(lastUpdate);

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
  }
}
