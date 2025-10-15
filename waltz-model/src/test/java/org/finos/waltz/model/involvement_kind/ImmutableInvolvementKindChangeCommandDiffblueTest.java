package org.finos.waltz.model.involvement_kind;

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
import org.finos.waltz.model.change_unit.ExecutionStatus;
import org.finos.waltz.model.change_unit.ImmutableUpdateExecutionStatusCommand;
import org.finos.waltz.model.command.EntityChangeCommand;
import org.finos.waltz.model.command.FieldChange;
import org.finos.waltz.model.command.ImmutableFieldChange;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKindChangeCommand.Builder;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKindChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementKindChangeCommandDiffblueTest {
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
    Builder builderResult = ImmutableInvolvementKindChangeCommand.builder();

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
    Builder builderResult = ImmutableInvolvementKindChangeCommand.builder();

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
    Builder builderResult = ImmutableInvolvementKindChangeCommand.builder();

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
    Builder builderResult = ImmutableInvolvementKindChangeCommand.builder();

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
   * Test Builder {@link Builder#from(InvolvementKindChangeCommand)} with {@code
   * InvolvementKindChangeCommand}.
   *
   * <ul>
   *   <li>Then builder build id is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(InvolvementKindChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(InvolvementKindChangeCommand) with 'InvolvementKindChangeCommand'; then builder build id is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(InvolvementKindChangeCommand)"})
  void testBuilderFromWithInvolvementKindChangeCommand_thenBuilderBuildIdIsOne() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindChangeCommand.builder();

    InvolvementKindChangeCommand instance = mock(InvolvementKindChangeCommand.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.lastUpdate()).thenReturn(emptyResult);
    Optional<FieldChange<String>> emptyResult2 = Optional.empty();
    when(instance.description()).thenReturn(emptyResult2);
    Optional<FieldChange<String>> emptyResult3 = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult3);
    Optional<FieldChange<String>> emptyResult4 = Optional.empty();
    when(instance.name()).thenReturn(emptyResult4);
    Optional<FieldChange<String>> emptyResult5 = Optional.empty();
    when(instance.permittedRole()).thenReturn(emptyResult5);
    Optional<FieldChange<Boolean>> emptyResult6 = Optional.empty();
    when(instance.transitive()).thenReturn(emptyResult6);
    Optional<FieldChange<Boolean>> emptyResult7 = Optional.empty();
    when(instance.userSelectable()).thenReturn(emptyResult7);
    when(instance.id()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdate();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).permittedRole();
    verify(instance).transitive();
    verify(instance).userSelectable();
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
    Builder builderResult = ImmutableInvolvementKindChangeCommand.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertEquals(1L, builderResult.build().id());
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
    Builder builderResult = ImmutableInvolvementKindChangeCommand.builder();
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
    Builder builderResult = ImmutableInvolvementKindChangeCommand.builder();

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
   * Test Builder {@link Builder#permittedRole(Optional)} with {@code Optional}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#permittedRole(Optional)}
   */
  @Test
  @DisplayName("Test Builder permittedRole(Optional) with 'Optional'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.permittedRole(Optional)"})
  void testBuilderPermittedRoleWithOptional_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindChangeCommand.builder();

    ImmutableFieldChange.Builder<String> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<String> immutableFieldChange =
        builderResult2
            .description("The characteristics of someone or something")
            .newVal("New Val")
            .oldVal("Old Val")
            .build();
    Optional<? extends FieldChange<String>> permittedRole = Optional.of(immutableFieldChange);

    // Act
    Builder actualPermittedRoleResult = builderResult.permittedRole(permittedRole);

    // Assert
    assertSame(builderResult, actualPermittedRoleResult);
  }

  /**
   * Test Builder {@link Builder#transitive(Optional)} with {@code Optional}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#transitive(Optional)}
   */
  @Test
  @DisplayName("Test Builder transitive(Optional) with 'Optional'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.transitive(Optional)"})
  void testBuilderTransitiveWithOptional_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindChangeCommand.builder();

    ImmutableFieldChange.Builder<Boolean> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Boolean> immutableFieldChange =
        builderResult2
            .description("The characteristics of someone or something")
            .newVal(true)
            .oldVal(true)
            .build();
    Optional<? extends FieldChange<Boolean>> resultTransitive = Optional.of(immutableFieldChange);

    // Act
    Builder actualTransitiveResult = builderResult.transitive(resultTransitive);

    // Assert
    assertSame(builderResult, actualTransitiveResult);
  }

  /**
   * Test Builder {@link Builder#userSelectable(Optional)} with {@code Optional}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#userSelectable(Optional)}
   */
  @Test
  @DisplayName("Test Builder userSelectable(Optional) with 'Optional'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.userSelectable(Optional)"})
  void testBuilderUserSelectableWithOptional_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindChangeCommand.builder();

    ImmutableFieldChange.Builder<Boolean> builderResult2 = ImmutableFieldChange.builder();
    ImmutableFieldChange<Boolean> immutableFieldChange =
        builderResult2
            .description("The characteristics of someone or something")
            .newVal(true)
            .oldVal(true)
            .build();
    Optional<? extends FieldChange<Boolean>> userSelectable = Optional.of(immutableFieldChange);

    // Act
    Builder actualUserSelectableResult = builderResult.userSelectable(userSelectable);

    // Assert
    assertSame(builderResult, actualUserSelectableResult);
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
    assertFalse(actualJson.lastUpdate.isPresent());
    assertFalse(actualJson.name.isPresent());
    assertFalse(actualJson.permittedRole.isPresent());
    assertFalse(actualJson.transitive.isPresent());
    assertFalse(actualJson.userSelectable.isPresent());
    assertFalse(actualJson.idIsSet);
  }

  /**
   * Test Json {@link Json#permittedRole()}.
   *
   * <p>Method under test: {@link Json#permittedRole()}
   */
  @Test
  @DisplayName("Test Json permittedRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.permittedRole()"})
  void testJsonPermittedRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().permittedRole());
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

  /**
   * Test Json {@link Json#transitive()}.
   *
   * <p>Method under test: {@link Json#transitive()}
   */
  @Test
  @DisplayName("Test Json transitive()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.transitive()"})
  void testJsonTransitive() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().transitive());
  }

  /**
   * Test Json {@link Json#userSelectable()}.
   *
   * <p>Method under test: {@link Json#userSelectable()}
   */
  @Test
  @DisplayName("Test Json userSelectable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.userSelectable()"})
  void testJsonUserSelectable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().userSelectable());
  }
}
