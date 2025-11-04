package org.finos.waltz.model.involvement_kind;

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

class ImmutableInvolvementKindChangeCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableInvolvementKindChangeCommand.Builder#from(EntityChangeCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableInvolvementKindChangeCommand.Builder builderResult = ImmutableInvolvementKindChangeCommand.builder();
    EntityChangeCommand instance = mock(EntityChangeCommand.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdate()).thenReturn(ofResult);
    when(instance.id()).thenReturn(1L);

    // Act
    ImmutableInvolvementKindChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdate();
    assertEquals(1L, actualFromResult.build().id());
    assertEquals(1L, builderResult.build().id());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindChangeCommand.Builder#from(EntityChangeCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableInvolvementKindChangeCommand.Builder builderResult = ImmutableInvolvementKindChangeCommand.builder();
    EntityChangeCommand instance = mock(EntityChangeCommand.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.lastUpdate()).thenReturn(emptyResult);
    when(instance.id()).thenReturn(1L);

    // Act
    ImmutableInvolvementKindChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdate();
    assertEquals(1L, actualFromResult.build().id());
    assertEquals(1L, builderResult.build().id());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindChangeCommand.Builder#from(EntityChangeCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableInvolvementKindChangeCommand.Builder builderResult = ImmutableInvolvementKindChangeCommand.builder();
    EntityChangeCommand instance = mock(EntityChangeCommand.class);
    when(instance.lastUpdate()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdate();
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindChangeCommand.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableInvolvementKindChangeCommand.Builder builderResult = ImmutableInvolvementKindChangeCommand.builder();

    // Act
    ImmutableInvolvementKindChangeCommand.Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertEquals(1L, actualIdResult.build().id());
    assertEquals(1L, builderResult.build().id());
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindChangeCommand.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableInvolvementKindChangeCommand.Builder builderResult = ImmutableInvolvementKindChangeCommand.builder();
    builderResult.lastUpdate(mock(UserTimestamp.class));

    // Act
    ImmutableInvolvementKindChangeCommand.Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertEquals(1L, actualIdResult.build().id());
    assertEquals(1L, builderResult.build().id());
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindChangeCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInvolvementKindChangeCommand.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindChangeCommand.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInvolvementKindChangeCommand.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableInvolvementKindChangeCommand.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementKindChangeCommand.Json()).id());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindChangeCommand.Json#lastUpdate()}
   */
  @Test
  void testJsonLastUpdate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInvolvementKindChangeCommand.Json()).lastUpdate());
  }

  /**
   * Method under test: {@link ImmutableInvolvementKindChangeCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementKindChangeCommand.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableInvolvementKindChangeCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableInvolvementKindChangeCommand.Json actualJson = new ImmutableInvolvementKindChangeCommand.Json();

    // Assert
    assertEquals(0L, actualJson.id);
    assertFalse(actualJson.description.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.lastUpdate.isPresent());
    assertFalse(actualJson.name.isPresent());
    assertFalse(actualJson.permittedRole.isPresent());
    assertFalse(actualJson.transitive.isPresent());
    assertFalse(actualJson.userSelectable.isPresent());
    assertFalse(actualJson.idIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindChangeCommand.Json#permittedRole()}
   */
  @Test
  void testJsonPermittedRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInvolvementKindChangeCommand.Json()).permittedRole());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindChangeCommand.Json#setId(long)}
   */
  @Test
  void testJsonSetId() {
    // Arrange
    ImmutableInvolvementKindChangeCommand.Json json = new ImmutableInvolvementKindChangeCommand.Json();

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindChangeCommand.Json#setId(long)}
   */
  @Test
  void testJsonSetId2() {
    // Arrange
    ImmutableInvolvementKindChangeCommand.Json json = new ImmutableInvolvementKindChangeCommand.Json();
    Optional<UserTimestamp> lastUpdate = Optional.of(mock(UserTimestamp.class));
    json.setLastUpdate(lastUpdate);

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindChangeCommand.Json#transitive()}
   */
  @Test
  void testJsonTransitive() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInvolvementKindChangeCommand.Json()).transitive());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKindChangeCommand.Json#userSelectable()}
   */
  @Test
  void testJsonUserSelectable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableInvolvementKindChangeCommand.Json()).userSelectable());
  }
}
