package org.finos.waltz.model.actor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.actor.ImmutableActorChangeCommand.Builder;
import org.finos.waltz.model.actor.ImmutableActorChangeCommand.Json;
import org.finos.waltz.model.command.EntityChangeCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableActorChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(EntityChangeCommand)} with {@code EntityChangeCommand}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityChangeCommand) with 'EntityChangeCommand'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityChangeCommand)"})
  void testBuilderFromWithEntityChangeCommand_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableActorChangeCommand.builder();
    EntityChangeCommand instance = mock(EntityChangeCommand.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.lastUpdate()).thenReturn(emptyResult);
    when(instance.id()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdate();
    assertEquals(1L, builderResult.build().id());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityChangeCommand)} with {@code EntityChangeCommand}.
   * <ul>
   *   <li>Given {@link Optional} with {@link UserTimestamp}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityChangeCommand) with 'EntityChangeCommand'; given Optional with UserTimestamp")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityChangeCommand)"})
  void testBuilderFromWithEntityChangeCommand_givenOptionalWithUserTimestamp() {
    // Arrange
    Builder builderResult = ImmutableActorChangeCommand.builder();
    EntityChangeCommand instance = mock(EntityChangeCommand.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdate()).thenReturn(ofResult);
    when(instance.id()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdate();
    assertEquals(1L, builderResult.build().id());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderId() {
    // Arrange
    Builder builderResult = ImmutableActorChangeCommand.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertEquals(1L, builderResult.build().id());
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdate(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#lastUpdate(Optional)}
   */
  @Test
  @DisplayName("Test Builder lastUpdate(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastUpdate(Optional)"})
  void testBuilderLastUpdateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableActorChangeCommand.builder();
    Optional<? extends UserTimestamp> lastUpdate = Optional.of(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdate(lastUpdate));
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#isExternal()}.
   * <p>
   * Method under test: {@link Json#isExternal()}
   */
  @Test
  @DisplayName("Test Json isExternal()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.isExternal()"})
  void testJsonIsExternal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isExternal());
  }

  /**
   * Test Json {@link Json#lastUpdate()}.
   * <p>
   * Method under test: {@link Json#lastUpdate()}
   */
  @Test
  @DisplayName("Test Json lastUpdate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.lastUpdate()"})
  void testJsonLastUpdate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdate());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

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
   * Test Json {@link Json#setId(long)}.
   * <p>
   * Method under test: {@link Json#setId(long)}
   */
  @Test
  @DisplayName("Test Json setId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setId(long)"})
  void testJsonSetId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
  }
}
