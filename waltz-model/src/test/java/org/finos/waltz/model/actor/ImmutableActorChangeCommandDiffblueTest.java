package org.finos.waltz.model.actor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.actor.ImmutableActorChangeCommand.Builder;
import org.finos.waltz.model.actor.ImmutableActorChangeCommand.Json;
import org.finos.waltz.model.change_unit.ExecutionStatus;
import org.finos.waltz.model.change_unit.ImmutableUpdateExecutionStatusCommand;
import org.finos.waltz.model.command.EntityChangeCommand;
import org.finos.waltz.model.command.FieldChange;
import org.finos.waltz.model.command.ImmutableFieldChange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableActorChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#description(Optional)} with {@code Optional}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#description(Optional)}
   */
  @Test
  @DisplayName("Test Builder description(Optional) with 'Optional'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.description(Optional)"})
  void testBuilderDescriptionWithOptional_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableActorChangeCommand.builder();

    ImmutableFieldChange.Builder<String> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<String> immutableFieldChange =
        builderResult2
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build();
    Optional<? extends FieldChange<String>> description = Optional.of(immutableFieldChange);

    // Act
    Builder actualDescriptionResult = builderResult.description(description);

    // Assert
    assertSame(builderResult, actualDescriptionResult);
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableActorChangeCommand.builder();

    ImmutableFieldChange.Builder<String> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<String> immutableFieldChange =
        builderResult2
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build();
    Optional<? extends FieldChange<String>> externalId = Optional.of(immutableFieldChange);

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(ActorChangeCommand)} with {@code ActorChangeCommand}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then builder build id is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ActorChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ActorChangeCommand) with 'ActorChangeCommand'; given empty; then builder build id is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ActorChangeCommand)"})
  void testBuilderFromWithActorChangeCommand_givenEmpty_thenBuilderBuildIdIsOne() {
    // Arrange
    Builder builderResult = ImmutableActorChangeCommand.builder();

    ActorChangeCommand instance = mock(ActorChangeCommand.class);
    Optional<FieldChange<String>> emptyResult = Optional.empty();
    when(instance.description()).thenReturn(emptyResult);
    Optional<FieldChange<String>> emptyResult2 = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult2);
    Optional<FieldChange<Boolean>> emptyResult3 = Optional.empty();
    when(instance.isExternal()).thenReturn(emptyResult3);
    Optional<FieldChange<String>> emptyResult4 = Optional.empty();
    when(instance.name()).thenReturn(emptyResult4);
    Optional<UserTimestamp> emptyResult5 = Optional.empty();
    when(instance.lastUpdate()).thenReturn(emptyResult5);
    when(instance.id()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isExternal();
    verify(instance).name();
    verify(instance).id();
    verify(instance).lastUpdate();
    assertEquals(1L, builderResult.build().id());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityChangeCommand)} with {@code EntityChangeCommand}.
   *
   * <p>Method under test: {@link Builder#from(EntityChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityChangeCommand) with 'EntityChangeCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityChangeCommand)"})
  void testBuilderFromWithEntityChangeCommand() {
    // Arrange
    Builder builderResult = ImmutableActorChangeCommand.builder();

    ImmutableUpdateExecutionStatusCommand.Builder builderResult2 =
        ImmutableUpdateExecutionStatusCommand.builder();

    ImmutableFieldChange.Builder<ExecutionStatus> builderResult3 = ImmutableFieldChange.builder();

    ImmutableUpdateExecutionStatusCommand.Builder idResult =
        builderResult2
            .executionStatus(
                builderResult3
                    .description("The characteristics of someone or something")
                    .newVal(ExecutionStatus.PENDING)
                    .oldVal(ExecutionStatus.PENDING)
                    .build())
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdate = Optional.of(immutableUserTimestamp);

    // Act
    Builder actualFromResult = builderResult.from(idResult.lastUpdate(lastUpdate).build());

    // Assert
    assertEquals(1L, builderResult.build().id());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityChangeCommand)} with {@code EntityChangeCommand}.
   *
   * <p>Method under test: {@link Builder#from(EntityChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityChangeCommand) with 'EntityChangeCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityChangeCommand)"})
  void testBuilderFromWithEntityChangeCommand2() {
    // Arrange
    Builder builderResult = ImmutableActorChangeCommand.builder();

    ImmutableUpdateExecutionStatusCommand.Builder builderResult2 =
        ImmutableUpdateExecutionStatusCommand.builder();

    ImmutableFieldChange.Builder<ExecutionStatus> builderResult3 = ImmutableFieldChange.builder();

    ImmutableUpdateExecutionStatusCommand.Builder idResult =
        builderResult2
            .executionStatus(
                builderResult3
                    .description("The characteristics of someone or something")
                    .newVal(ExecutionStatus.PENDING)
                    .oldVal(ExecutionStatus.PENDING)
                    .build())
            .id(1L);
    Optional<? extends UserTimestamp> lastUpdate = Optional.empty();

    // Act
    Builder actualFromResult = builderResult.from(idResult.lastUpdate(lastUpdate).build());

    // Assert
    assertEquals(1L, builderResult.build().id());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test Builder {@link Builder#isExternal(Optional)} with {@code Optional}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#isExternal(Optional)}
   */
  @Test
  @DisplayName("Test Builder isExternal(Optional) with 'Optional'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isExternal(Optional)"})
  void testBuilderIsExternalWithOptional_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableActorChangeCommand.builder();

    ImmutableFieldChange.Builder<Boolean> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Boolean> immutableFieldChange =
        builderResult2
            .description("The characteristics of someone or something")
            .newVal(true)
            .oldVal(true)
            .build();
    Optional<? extends FieldChange<Boolean>> isExternal = Optional.of(immutableFieldChange);

    // Act
    Builder actualIsExternalResult = builderResult.isExternal(isExternal);

    // Assert
    assertSame(builderResult, actualIsExternalResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdate(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#lastUpdate(Optional)}
   */
  @Test
  @DisplayName("Test Builder lastUpdate(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastUpdate(Optional)"})
  void testBuilderLastUpdateWithOptional() {
    // Arrange
    Builder builderResult = ImmutableActorChangeCommand.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdate = Optional.of(immutableUserTimestamp);

    // Act
    Builder actualLastUpdateResult = builderResult.lastUpdate(lastUpdate);

    // Assert
    assertSame(builderResult, actualLastUpdateResult);
  }

  /**
   * Test Builder {@link Builder#name(Optional)} with {@code Optional}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(Optional)}
   */
  @Test
  @DisplayName("Test Builder name(Optional) with 'Optional'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(Optional)"})
  void testBuilderNameWithOptional_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableActorChangeCommand.builder();

    ImmutableFieldChange.Builder<String> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<String> immutableFieldChange =
        builderResult2
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build();
    Optional<? extends FieldChange<String>> name = Optional.of(immutableFieldChange);

    // Act
    Builder actualNameResult = builderResult.name(name);

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#isExternal()}.
   *
   * <p>Method under test: {@link Json#isExternal()}
   */
  @Test
  @DisplayName("Test Json isExternal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.isExternal()"})
  void testJsonIsExternal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isExternal());
  }

  /**
   * Test Json {@link Json#lastUpdate()}.
   *
   * <p>Method under test: {@link Json#lastUpdate()}
   */
  @Test
  @DisplayName("Test Json lastUpdate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.lastUpdate()"})
  void testJsonLastUpdate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdate());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#setId(long)}
   */
  @Test
  @DisplayName("Test Json setId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
