package org.finos.waltz.model.change_unit;

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
import java.util.Optional;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.change_unit.ImmutableUpdateExecutionStatusCommand.Builder;
import org.finos.waltz.model.change_unit.ImmutableUpdateExecutionStatusCommand.Json;
import org.finos.waltz.model.command.EntityChangeCommand;
import org.finos.waltz.model.command.FieldChange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateExecutionStatusCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#executionStatus(FieldChange)}.
   * <ul>
   *   <li>When {@link FieldChange}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#executionStatus(FieldChange)}
   */
  @Test
  @DisplayName("Test Builder executionStatus(FieldChange); when FieldChange; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.executionStatus(FieldChange)"})
  void testBuilderExecutionStatus_whenFieldChange_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.executionStatus(mock(FieldChange.class)));
  }

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
    Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();
    EntityChangeCommand instance = mock(EntityChangeCommand.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.lastUpdate()).thenReturn(emptyResult);
    when(instance.id()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdate();
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
    Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();
    EntityChangeCommand instance = mock(EntityChangeCommand.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdate()).thenReturn(ofResult);
    when(instance.id()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdate();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateExecutionStatusCommand)} with {@code UpdateExecutionStatusCommand}.
   * <ul>
   *   <li>Then builder build id is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateExecutionStatusCommand)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateExecutionStatusCommand) with 'UpdateExecutionStatusCommand'; then builder build id is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateExecutionStatusCommand)"})
  void testBuilderFromWithUpdateExecutionStatusCommand_thenBuilderBuildIdIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();
    UpdateExecutionStatusCommand instance = mock(UpdateExecutionStatusCommand.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.lastUpdate()).thenReturn(ofResult);
    when(instance.id()).thenReturn(1L);
    when(instance.executionStatus()).thenReturn(mock(FieldChange.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).executionStatus();
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
    Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
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
    Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();
    Optional<? extends UserTimestamp> lastUpdate = Optional.of(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdate(lastUpdate));
  }

  /**
   * Test Json {@link Json#executionStatus()}.
   * <p>
   * Method under test: {@link Json#executionStatus()}
   */
  @Test
  @DisplayName("Test Json executionStatus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FieldChange Json.executionStatus()"})
  void testJsonExecutionStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).executionStatus());
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
    assertNull(actualJson.executionStatus);
    assertEquals(0L, actualJson.id);
    assertFalse(actualJson.lastUpdate.isPresent());
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
