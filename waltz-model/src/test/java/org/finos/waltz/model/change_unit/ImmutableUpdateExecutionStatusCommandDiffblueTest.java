package org.finos.waltz.model.change_unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.change_unit.ImmutableUpdateExecutionStatusCommand.Builder;
import org.finos.waltz.model.change_unit.ImmutableUpdateExecutionStatusCommand.Json;
import org.finos.waltz.model.command.EntityChangeCommand;
import org.finos.waltz.model.command.FieldChange;
import org.finos.waltz.model.command.ImmutableFieldChange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateExecutionStatusCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#executionStatus(FieldChange)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#executionStatus(FieldChange)}
   */
  @Test
  @DisplayName("Test Builder executionStatus(FieldChange); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.executionStatus(FieldChange)"})
  void testBuilderExecutionStatus_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();

    ImmutableFieldChange.Builder<ExecutionStatus> builderResult2 = ImmutableFieldChange.builder();

    // Act
    Builder actualExecutionStatusResult =
        builderResult.executionStatus(
            builderResult2
                .description("The characteristics of someone or something")
                .newVal(ExecutionStatus.PENDING)
                .oldVal(ExecutionStatus.PENDING)
                .build());

    // Assert
    assertSame(builderResult, actualExecutionStatusResult);
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
    Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();

    Builder builderResult2 = ImmutableUpdateExecutionStatusCommand.builder();

    ImmutableFieldChange.Builder<ExecutionStatus> builderResult3 = ImmutableFieldChange.builder();

    Builder idResult =
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
    ImmutableUpdateExecutionStatusCommand instance = idResult.lastUpdate(lastUpdate).build();

    // Act
    Builder actualFromResult = builderResult.from((EntityChangeCommand) instance);

    // Assert
    ImmutableUpdateExecutionStatusCommand actualImmutableUpdateExecutionStatusCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateExecutionStatusCommand);
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
    Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();

    Builder builderResult2 = ImmutableUpdateExecutionStatusCommand.builder();

    ImmutableFieldChange.Builder<ExecutionStatus> builderResult3 = ImmutableFieldChange.builder();

    Builder idResult =
        builderResult2
            .executionStatus(
                builderResult3
                    .description("The characteristics of someone or something")
                    .newVal(ExecutionStatus.PENDING)
                    .oldVal(ExecutionStatus.PENDING)
                    .build())
            .id(1L);
    Optional<? extends UserTimestamp> lastUpdate = Optional.empty();
    ImmutableUpdateExecutionStatusCommand instance = idResult.lastUpdate(lastUpdate).build();

    // Act
    Builder actualFromResult = builderResult.from((EntityChangeCommand) instance);

    // Assert
    ImmutableUpdateExecutionStatusCommand actualImmutableUpdateExecutionStatusCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateExecutionStatusCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateExecutionStatusCommand)} with {@code
   * UpdateExecutionStatusCommand}.
   *
   * <p>Method under test: {@link Builder#from(UpdateExecutionStatusCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UpdateExecutionStatusCommand) with 'UpdateExecutionStatusCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateExecutionStatusCommand)"})
  void testBuilderFromWithUpdateExecutionStatusCommand() {
    // Arrange
    Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();

    Builder builderResult2 = ImmutableUpdateExecutionStatusCommand.builder();

    ImmutableFieldChange.Builder<ExecutionStatus> builderResult3 = ImmutableFieldChange.builder();

    Builder idResult =
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
    ImmutableUpdateExecutionStatusCommand instance = idResult.lastUpdate(lastUpdate).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateExecutionStatusCommand actualImmutableUpdateExecutionStatusCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateExecutionStatusCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateExecutionStatusCommand)} with {@code
   * UpdateExecutionStatusCommand}.
   *
   * <p>Method under test: {@link Builder#from(UpdateExecutionStatusCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UpdateExecutionStatusCommand) with 'UpdateExecutionStatusCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateExecutionStatusCommand)"})
  void testBuilderFromWithUpdateExecutionStatusCommand2() {
    // Arrange
    Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();

    Builder builderResult2 = ImmutableUpdateExecutionStatusCommand.builder();

    ImmutableFieldChange.Builder<ExecutionStatus> builderResult3 = ImmutableFieldChange.builder();

    Builder idResult =
        builderResult2
            .executionStatus(
                builderResult3
                    .description("The characteristics of someone or something")
                    .newVal(ExecutionStatus.PENDING)
                    .oldVal(ExecutionStatus.PENDING)
                    .build())
            .id(1L);
    Optional<? extends UserTimestamp> lastUpdate = Optional.empty();
    ImmutableUpdateExecutionStatusCommand instance = idResult.lastUpdate(lastUpdate).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateExecutionStatusCommand actualImmutableUpdateExecutionStatusCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateExecutionStatusCommand);
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
    Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
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
    Builder builderResult = ImmutableUpdateExecutionStatusCommand.builder();
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
   * Test Json {@link Json#executionStatus()}.
   *
   * <p>Method under test: {@link Json#executionStatus()}
   */
  @Test
  @DisplayName("Test Json executionStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldChange Json.executionStatus()"})
  void testJsonExecutionStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().executionStatus());
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
    assertNull(actualJson.executionStatus);
    assertEquals(0L, actualJson.id);
    assertFalse(actualJson.lastUpdate.isPresent());
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
