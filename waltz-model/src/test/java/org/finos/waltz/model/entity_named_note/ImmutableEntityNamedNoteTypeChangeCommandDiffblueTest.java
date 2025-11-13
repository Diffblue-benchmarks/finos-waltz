package org.finos.waltz.model.entity_named_note;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.entity_named_note.ImmutableEntityNamedNoteTypeChangeCommand.Builder;
import org.finos.waltz.model.entity_named_note.ImmutableEntityNamedNoteTypeChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityNamedNoteTypeChangeCommandDiffblueTest {
  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#applicableEntityKinds()}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#applicableEntityKinds()}
   */
  @Test
  @DisplayName("Test applicableEntityKinds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityNamedNoteTypeChangeCommand.applicableEntityKinds()"})
  void testApplicableEntityKinds() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act and Assert
    assertEquals(
        applicableEntityKinds,
        externalIdResult
            .isReadOnly(isReadOnly)
            .name("Name")
            .position(1)
            .build()
            .applicableEntityKinds());
  }

  /**
   * Test Builder {@link Builder#applicableEntityKinds(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#applicableEntityKinds(Optional)}
   */
  @Test
  @DisplayName("Test Builder applicableEntityKinds(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicableEntityKinds(Optional)"})
  void testBuilderApplicableEntityKindsWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    // Act
    Builder actualApplicableEntityKindsResult =
        builderResult.applicableEntityKinds(applicableEntityKinds);

    // Assert
    assertSame(builderResult, actualApplicableEntityKindsResult);
  }

  /**
   * Test Builder {@link Builder#description(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#description(Optional)}
   */
  @Test
  @DisplayName("Test Builder description(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.description(Optional)"})
  void testBuilderDescriptionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<String> description = Optional.of("42");

    // Act
    Builder actualDescriptionResult = builderResult.description(description);

    // Assert
    assertSame(builderResult, actualDescriptionResult);
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityNamedNoteTypeChangeCommand)}.
   *
   * <p>Method under test: {@link Builder#from(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityNamedNoteTypeChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityNamedNoteTypeChangeCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();

    Builder builderResult2 = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult2
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand instance =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityNamedNoteTypeChangeCommand actualImmutableEntityNamedNoteTypeChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityNamedNoteTypeChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityNamedNoteTypeChangeCommand)}.
   *
   * <p>Method under test: {@link Builder#from(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityNamedNoteTypeChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityNamedNoteTypeChangeCommand)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();

    Builder builderResult2 = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.empty();

    Builder externalIdResult =
        builderResult2
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand instance =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityNamedNoteTypeChangeCommand actualImmutableEntityNamedNoteTypeChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityNamedNoteTypeChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityNamedNoteTypeChangeCommand)}.
   *
   * <p>Method under test: {@link Builder#from(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityNamedNoteTypeChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityNamedNoteTypeChangeCommand)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();

    Builder builderResult2 = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult2
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.empty();
    ImmutableEntityNamedNoteTypeChangeCommand instance =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityNamedNoteTypeChangeCommand actualImmutableEntityNamedNoteTypeChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityNamedNoteTypeChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#isReadOnly(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link Builder#isReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Builder isReadOnly(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isReadOnly(boolean)"})
  void testBuilderIsReadOnlyWithBoolean() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();

    // Act
    Builder actualIsReadOnlyResult = builderResult.isReadOnly(true);

    // Assert
    assertSame(builderResult, actualIsReadOnlyResult);
  }

  /**
   * Test Builder {@link Builder#isReadOnly(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#isReadOnly(Optional)}
   */
  @Test
  @DisplayName("Test Builder isReadOnly(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isReadOnly(Optional)"})
  void testBuilderIsReadOnlyWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    Builder actualIsReadOnlyResult = builderResult.isReadOnly(isReadOnly);

    // Assert
    assertSame(builderResult, actualIsReadOnlyResult);
  }

  /**
   * Test Builder {@link Builder#name(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#name(Optional)}
   */
  @Test
  @DisplayName("Test Builder name(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(Optional)"})
  void testBuilderNameWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<String> name = Optional.of("42");

    // Act
    Builder actualNameResult = builderResult.name(name);

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#position(int)} with {@code int}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPositionWithInt() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test Builder {@link Builder#position(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#position(Optional)}
   */
  @Test
  @DisplayName("Test Builder position(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(Optional)"})
  void testBuilderPositionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<Integer> position = Optional.of(42);

    // Act
    Builder actualPositionResult = builderResult.position(position);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test {@link
   * ImmutableEntityNamedNoteTypeChangeCommand#copyOf(EntityNamedNoteTypeChangeCommand)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityNamedNoteTypeChangeCommand#copyOf(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName("Test copyOf(EntityNamedNoteTypeChangeCommand); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.copyOf(EntityNamedNoteTypeChangeCommand)"
  })
  void testCopyOf_thenReturnExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand instance =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualCopyOfResult =
        ImmutableEntityNamedNoteTypeChangeCommand.copyOf(instance);

    // Assert
    Optional<String> externalIdResult2 = actualCopyOfResult.externalId();
    assertEquals("42", externalIdResult2.get());
    Optional<String> descriptionResult = actualCopyOfResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    assertTrue(descriptionResult.isPresent());
    assertTrue(externalIdResult2.isPresent());
    assertEquals(isReadOnly, actualCopyOfResult.isReadOnly());
    assertEquals(applicableEntityKinds, actualCopyOfResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#description()}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#description()}
   */
  @Test
  @DisplayName("Test description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityNamedNoteTypeChangeCommand.description()"})
  void testDescription() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    Optional<String> actualDescriptionResult =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build().description();

    // Assert
    assertEquals("The characteristics of someone or something", actualDescriptionResult.get());
    assertTrue(actualDescriptionResult.isPresent());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}, and {@link
   * ImmutableEntityNamedNoteTypeChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   *   <li>{@link ImmutableEntityNamedNoteTypeChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
    "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();

    Builder builderResult2 = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds2 = Optional.of(new HashSet<>());

    Builder externalIdResult2 =
        builderResult2
            .applicableEntityKinds(applicableEntityKinds2)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly2 = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand2 =
        externalIdResult2.isReadOnly(isReadOnly2).name("Name").position(1).build();

    // Act and Assert
    assertEquals(
        immutableEntityNamedNoteTypeChangeCommand, immutableEntityNamedNoteTypeChangeCommand2);
    assertEquals(
        immutableEntityNamedNoteTypeChangeCommand.hashCode(),
        immutableEntityNamedNoteTypeChangeCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}, and {@link
   * ImmutableEntityNamedNoteTypeChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   *   <li>{@link ImmutableEntityNamedNoteTypeChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
    "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();

    // Act and Assert
    assertEquals(
        immutableEntityNamedNoteTypeChangeCommand, immutableEntityNamedNoteTypeChangeCommand);
    int expectedHashCodeResult = immutableEntityNamedNoteTypeChangeCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityNamedNoteTypeChangeCommand.hashCode());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
    "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<EntityKind> entityKindSet = new HashSet<>();
    entityKindSet.add(EntityKind.ALL);
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(entityKindSet);

    Builder externalIdResult =
        ImmutableEntityNamedNoteTypeChangeCommand.builder()
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();

    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds2 = Optional.of(new HashSet<>());

    Builder externalIdResult2 =
        builderResult
            .applicableEntityKinds(applicableEntityKinds2)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly2 = Optional.of(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityNamedNoteTypeChangeCommand,
        externalIdResult2.isReadOnly(isReadOnly2).name("Name").position(1).build());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
    "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("Description")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();

    Builder builderResult2 = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds2 = Optional.of(new HashSet<>());

    Builder externalIdResult2 =
        builderResult2
            .applicableEntityKinds(applicableEntityKinds2)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly2 = Optional.of(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityNamedNoteTypeChangeCommand,
        externalIdResult2.isReadOnly(isReadOnly2).name("Name").position(1).build());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
    "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("External Id");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();

    Builder builderResult2 = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds2 = Optional.of(new HashSet<>());

    Builder externalIdResult2 =
        builderResult2
            .applicableEntityKinds(applicableEntityKinds2)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly2 = Optional.of(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityNamedNoteTypeChangeCommand,
        externalIdResult2.isReadOnly(isReadOnly2).name("Name").position(1).build());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
    "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(false);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();

    Builder builderResult2 = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds2 = Optional.of(new HashSet<>());

    Builder externalIdResult2 =
        builderResult2
            .applicableEntityKinds(applicableEntityKinds2)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly2 = Optional.of(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityNamedNoteTypeChangeCommand,
        externalIdResult2.isReadOnly(isReadOnly2).name("Name").position(1).build());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
    "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("applicableEntityKinds").position(1).build();

    Builder builderResult2 = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds2 = Optional.of(new HashSet<>());

    Builder externalIdResult2 =
        builderResult2
            .applicableEntityKinds(applicableEntityKinds2)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly2 = Optional.of(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityNamedNoteTypeChangeCommand,
        externalIdResult2.isReadOnly(isReadOnly2).name("Name").position(1).build());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
    "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(0).build();

    Builder builderResult2 = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds2 = Optional.of(new HashSet<>());

    Builder externalIdResult2 =
        builderResult2
            .applicableEntityKinds(applicableEntityKinds2)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly2 = Optional.of(true);

    // Act and Assert
    assertNotEquals(
        immutableEntityNamedNoteTypeChangeCommand,
        externalIdResult2.isReadOnly(isReadOnly2).name("Name").position(1).build());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
    "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act and Assert
    assertNotEquals(externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build(), null);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
    "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act and Assert
    assertNotEquals(
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build(),
        "Different type to ImmutableEntityNamedNoteTypeChangeCommand");
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#externalId()}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityNamedNoteTypeChangeCommand.externalId()"})
  void testExternalId() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    Optional<String> actualExternalIdResult =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build().externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Name is {@code null}.
   *   <li>Then return description is of {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of HashSet(); when Json (default constructor) Name is 'null'; then return description is of '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenOfHashSet_whenJsonNameIsNull_thenReturnDescriptionIsOf42() {
    // Arrange
    Json json = new Json();
    Optional<Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    json.setApplicableEntityKinds(applicableEntityKinds);
    json.setName(null);
    Optional<String> description = Optional.of("42");
    json.setDescription(description);
    Optional<Boolean> isReadOnly = Optional.of(true);
    json.setIsReadOnly(isReadOnly);
    Optional<Integer> position = Optional.of(42);
    json.setPosition(position);
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualFromJsonResult =
        ImmutableEntityNamedNoteTypeChangeCommand.fromJson(json);

    // Assert
    assertEquals(description, actualFromJsonResult.description());
    assertEquals(description, actualFromJsonResult.externalId());
    assertEquals(isReadOnly, actualFromJsonResult.isReadOnly());
    assertEquals(applicableEntityKinds, actualFromJsonResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Position is {@code null}.
   *   <li>Then return description is of {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of HashSet(); when Json (default constructor) Position is 'null'; then return description is of '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenOfHashSet_whenJsonPositionIsNull_thenReturnDescriptionIsOf42() {
    // Arrange
    Json json = new Json();
    Optional<Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    json.setApplicableEntityKinds(applicableEntityKinds);
    Optional<String> name = Optional.of("42");
    json.setName(name);
    Optional<String> description = Optional.of("42");
    json.setDescription(description);
    Optional<Boolean> isReadOnly = Optional.of(true);
    json.setIsReadOnly(isReadOnly);
    json.setPosition(null);
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualFromJsonResult =
        ImmutableEntityNamedNoteTypeChangeCommand.fromJson(json);

    // Assert
    assertEquals(description, actualFromJsonResult.description());
    assertEquals(description, actualFromJsonResult.externalId());
    assertEquals(isReadOnly, actualFromJsonResult.isReadOnly());
    assertEquals(applicableEntityKinds, actualFromJsonResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return not applicableEntityKinds Present.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return not applicableEntityKinds Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.fromJson(Json)"
  })
  void testFromJson_thenReturnNotApplicableEntityKindsPresent() {
    // Arrange
    Json json = new Json();
    json.setApplicableEntityKinds(null);
    Optional<String> name = Optional.of("42");
    json.setName(name);
    Optional<String> description = Optional.of("42");
    json.setDescription(description);
    Optional<Boolean> isReadOnly = Optional.of(true);
    json.setIsReadOnly(isReadOnly);
    Optional<Integer> position = Optional.of(42);
    json.setPosition(position);
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualFromJsonResult =
        ImmutableEntityNamedNoteTypeChangeCommand.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.applicableEntityKinds().isPresent());
    assertEquals(description, actualFromJsonResult.description());
    assertEquals(description, actualFromJsonResult.externalId());
    assertEquals(isReadOnly, actualFromJsonResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Description is {@code null}.
   *   <li>Then return not description Present.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Description is 'null'; then return not description Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.fromJson(Json)"
  })
  void testFromJson_whenJsonDescriptionIsNull_thenReturnNotDescriptionPresent() {
    // Arrange
    Json json = new Json();
    Optional<Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    json.setApplicableEntityKinds(applicableEntityKinds);
    Optional<String> name = Optional.of("42");
    json.setName(name);
    json.setDescription(null);
    Optional<Boolean> isReadOnly = Optional.of(true);
    json.setIsReadOnly(isReadOnly);
    Optional<Integer> position = Optional.of(42);
    json.setPosition(position);
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualFromJsonResult =
        ImmutableEntityNamedNoteTypeChangeCommand.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.description().isPresent());
    assertEquals(externalId, actualFromJsonResult.externalId());
    assertEquals(isReadOnly, actualFromJsonResult.isReadOnly());
    assertEquals(applicableEntityKinds, actualFromJsonResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ExternalId is {@code null}.
   *   <li>Then return not externalId Present.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ExternalId is 'null'; then return not externalId Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.fromJson(Json)"
  })
  void testFromJson_whenJsonExternalIdIsNull_thenReturnNotExternalIdPresent() {
    // Arrange
    Json json = new Json();
    Optional<Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    json.setApplicableEntityKinds(applicableEntityKinds);
    Optional<String> name = Optional.of("42");
    json.setName(name);
    Optional<String> description = Optional.of("42");
    json.setDescription(description);
    Optional<Boolean> isReadOnly = Optional.of(true);
    json.setIsReadOnly(isReadOnly);
    Optional<Integer> position = Optional.of(42);
    json.setPosition(position);
    json.setExternalId(null);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualFromJsonResult =
        ImmutableEntityNamedNoteTypeChangeCommand.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.externalId().isPresent());
    assertEquals(description, actualFromJsonResult.description());
    assertEquals(isReadOnly, actualFromJsonResult.isReadOnly());
    assertEquals(applicableEntityKinds, actualFromJsonResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) IsReadOnly is {@code null}.
   *   <li>Then return not ReadOnly Present.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) IsReadOnly is 'null'; then return not ReadOnly Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.fromJson(Json)"
  })
  void testFromJson_whenJsonIsReadOnlyIsNull_thenReturnNotReadOnlyPresent() {
    // Arrange
    Json json = new Json();
    Optional<Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    json.setApplicableEntityKinds(applicableEntityKinds);
    Optional<String> name = Optional.of("42");
    json.setName(name);
    Optional<String> description = Optional.of("42");
    json.setDescription(description);
    json.setIsReadOnly(null);
    Optional<Integer> position = Optional.of(42);
    json.setPosition(position);
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualFromJsonResult =
        ImmutableEntityNamedNoteTypeChangeCommand.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.isReadOnly().isPresent());
    assertEquals(description, actualFromJsonResult.description());
    assertEquals(description, actualFromJsonResult.externalId());
    assertEquals(applicableEntityKinds, actualFromJsonResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return description is {@link Json} (default constructor) {@link Json#position}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return description is Json (default constructor) position")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnDescriptionIsJsonPosition() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualFromJsonResult =
        ImmutableEntityNamedNoteTypeChangeCommand.fromJson(json);

    // Assert
    Optional<Integer> optional = json.position;
    assertSame(optional, actualFromJsonResult.description());
    assertSame(optional, actualFromJsonResult.externalId());
    assertSame(optional, actualFromJsonResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#isReadOnly()}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityNamedNoteTypeChangeCommand.isReadOnly()"})
  void testIsReadOnly() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act and Assert
    assertEquals(
        isReadOnly,
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build().isReadOnly());
  }

  /**
   * Test Json {@link Json#applicableEntityKinds()}.
   *
   * <p>Method under test: {@link Json#applicableEntityKinds()}
   */
  @Test
  @DisplayName("Test Json applicableEntityKinds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.applicableEntityKinds()"})
  void testJsonApplicableEntityKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().applicableEntityKinds());
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
   * Test Json {@link Json#isReadOnly()}.
   *
   * <p>Method under test: {@link Json#isReadOnly()}
   */
  @Test
  @DisplayName("Test Json isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.isReadOnly()"})
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isReadOnly());
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
    assertFalse(actualJson.applicableEntityKinds.isPresent());
    assertFalse(actualJson.description.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.isReadOnly.isPresent());
    assertFalse(actualJson.name.isPresent());
    assertFalse(actualJson.position.isPresent());
  }

  /**
   * Test Json {@link Json#position()}.
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#name()}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#name()}
   */
  @Test
  @DisplayName("Test name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityNamedNoteTypeChangeCommand.name()"})
  void testName() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    Optional<String> actualNameResult =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build().name();

    // Assert
    assertEquals("Name", actualNameResult.get());
    assertTrue(actualNameResult.isPresent());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#position()}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#position()}
   */
  @Test
  @DisplayName("Test position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityNamedNoteTypeChangeCommand.position()"})
  void testPosition() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    Optional<Integer> actualPositionResult =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build().position();

    // Assert
    assertEquals(1, actualPositionResult.get().intValue());
    assertTrue(actualPositionResult.isPresent());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEntityNamedNoteTypeChangeCommand.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act and Assert
    assertEquals(
        "EntityNamedNoteTypeChangeCommand{applicableEntityKinds=[], name=Name, description=The characteristics"
            + " of someone or something, isReadOnly=true, position=1, externalId=42}",
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build().toString());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEntityNamedNoteTypeChangeCommand.toString()"})
  void testToString2() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.empty();

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act and Assert
    assertEquals(
        "EntityNamedNoteTypeChangeCommand{name=Name, description=The characteristics of someone or something,"
            + " isReadOnly=true, position=1, externalId=42}",
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build().toString());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEntityNamedNoteTypeChangeCommand.toString()"})
  void testToString3() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.empty();

    // Act and Assert
    assertEquals(
        "EntityNamedNoteTypeChangeCommand{applicableEntityKinds=[], name=Name, description=The characteristics"
            + " of someone or something, position=1, externalId=42}",
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build().toString());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withApplicableEntityKinds(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityNamedNoteTypeChangeCommand#withApplicableEntityKinds(Optional)}
   */
  @Test
  @DisplayName("Test withApplicableEntityKinds(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withApplicableEntityKinds(Optional)"
  })
  void testWithApplicableEntityKindsWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();
    Optional<? extends Set<EntityKind>> optional = Optional.of(new HashSet<>());

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithApplicableEntityKindsResult =
        immutableEntityNamedNoteTypeChangeCommand.withApplicableEntityKinds(optional);

    // Assert
    assertEquals(immutableEntityNamedNoteTypeChangeCommand, actualWithApplicableEntityKindsResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withApplicableEntityKinds(Set)} with
   * {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityNamedNoteTypeChangeCommand#withApplicableEntityKinds(Set)}
   */
  @Test
  @DisplayName("Test withApplicableEntityKinds(Set) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withApplicableEntityKinds(Set)"
  })
  void testWithApplicableEntityKindsWithValue() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithApplicableEntityKindsResult =
        immutableEntityNamedNoteTypeChangeCommand.withApplicableEntityKinds(new HashSet<>());

    // Assert
    assertEquals(immutableEntityNamedNoteTypeChangeCommand, actualWithApplicableEntityKindsResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withDescription(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityNamedNoteTypeChangeCommand#withDescription(Optional)}
   */
  @Test
  @DisplayName("Test withDescription(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withDescription(Optional)"
  })
  void testWithDescriptionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("42")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithDescriptionResult =
        immutableEntityNamedNoteTypeChangeCommand.withDescription(optional);

    // Assert
    assertSame(immutableEntityNamedNoteTypeChangeCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withDescription(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then return description is of {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityNamedNoteTypeChangeCommand#withDescription(Optional)}
   */
  @Test
  @DisplayName("Test withDescription(Optional) with 'optional'; then return description is of '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withDescription(Optional)"
  })
  void testWithDescriptionWithOptional_thenReturnDescriptionIsOf42() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithDescriptionResult =
        immutableEntityNamedNoteTypeChangeCommand.withDescription(optional);

    // Assert
    assertEquals(optional, actualWithDescriptionResult.description());
    assertEquals(optional, actualWithDescriptionResult.externalId());
    assertEquals(isReadOnly, actualWithDescriptionResult.isReadOnly());
    assertEquals(applicableEntityKinds, actualWithDescriptionResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withDescription(String)} with {@code
   * value}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withDescription(String)"
  })
  void testWithDescriptionWithValue() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("42")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithDescriptionResult =
        immutableEntityNamedNoteTypeChangeCommand.withDescription("42");

    // Assert
    assertSame(immutableEntityNamedNoteTypeChangeCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withDescription(String)} with {@code
   * value}.
   *
   * <ul>
   *   <li>Then return description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String) with 'value'; then return description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withDescription(String)"
  })
  void testWithDescriptionWithValue_thenReturnDescriptionIs42() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithDescriptionResult =
        externalIdResult
            .isReadOnly(isReadOnly)
            .name("Name")
            .position(1)
            .build()
            .withDescription("42");

    // Assert
    Optional<String> descriptionResult = actualWithDescriptionResult.description();
    assertEquals("42", descriptionResult.get());
    assertTrue(descriptionResult.isPresent());
    assertEquals(descriptionResult, actualWithDescriptionResult.externalId());
    assertEquals(isReadOnly, actualWithDescriptionResult.isReadOnly());
    assertEquals(applicableEntityKinds, actualWithDescriptionResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withExternalId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityNamedNoteTypeChangeCommand#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithExternalIdResult =
        immutableEntityNamedNoteTypeChangeCommand.withExternalId(optional);

    // Assert
    assertSame(immutableEntityNamedNoteTypeChangeCommand, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withExternalId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityNamedNoteTypeChangeCommand#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional2() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("External Id");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithExternalIdResult =
        immutableEntityNamedNoteTypeChangeCommand.withExternalId(optional);

    // Assert
    Optional<String> descriptionResult = actualWithExternalIdResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    assertTrue(descriptionResult.isPresent());
    assertEquals(optional, actualWithExternalIdResult.externalId());
    assertEquals(isReadOnly, actualWithExternalIdResult.isReadOnly());
    assertEquals(applicableEntityKinds, actualWithExternalIdResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withExternalId(String)} with {@code
   * value}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithExternalIdResult =
        immutableEntityNamedNoteTypeChangeCommand.withExternalId("42");

    // Assert
    assertSame(immutableEntityNamedNoteTypeChangeCommand, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withExternalId(String)} with {@code
   * value}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then return externalId is '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withExternalId(String)"
  })
  void testWithExternalIdWithValue_thenReturnExternalIdIs0123456789abcdef() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithExternalIdResult =
        externalIdResult
            .isReadOnly(isReadOnly)
            .name("Name")
            .position(1)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    Optional<String> externalIdResult2 = actualWithExternalIdResult.externalId();
    assertEquals("0123456789ABCDEF", externalIdResult2.get());
    Optional<String> descriptionResult = actualWithExternalIdResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    assertTrue(descriptionResult.isPresent());
    assertTrue(externalIdResult2.isPresent());
    assertEquals(isReadOnly, actualWithExternalIdResult.isReadOnly());
    assertEquals(applicableEntityKinds, actualWithExternalIdResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withIsReadOnly(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityNamedNoteTypeChangeCommand#withIsReadOnly(Optional)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withIsReadOnly(Optional)"
  })
  void testWithIsReadOnlyWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();
    Optional<Boolean> optional = Optional.of(true);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithIsReadOnlyResult =
        immutableEntityNamedNoteTypeChangeCommand.withIsReadOnly(optional);

    // Assert
    assertSame(immutableEntityNamedNoteTypeChangeCommand, actualWithIsReadOnlyResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withIsReadOnly(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityNamedNoteTypeChangeCommand#withIsReadOnly(Optional)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(Optional) with 'optional'; then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withIsReadOnly(Optional)"
  })
  void testWithIsReadOnlyWithOptional_thenReturnExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(false);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();
    Optional<Boolean> optional = Optional.of(true);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithIsReadOnlyResult =
        immutableEntityNamedNoteTypeChangeCommand.withIsReadOnly(optional);

    // Assert
    Optional<String> externalIdResult2 = actualWithIsReadOnlyResult.externalId();
    assertEquals("42", externalIdResult2.get());
    Optional<String> descriptionResult = actualWithIsReadOnlyResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    assertTrue(descriptionResult.isPresent());
    assertTrue(externalIdResult2.isPresent());
    assertEquals(optional, actualWithIsReadOnlyResult.isReadOnly());
    assertEquals(applicableEntityKinds, actualWithIsReadOnlyResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withIsReadOnly(boolean)} with {@code
   * value}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(boolean) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withIsReadOnly(boolean)"
  })
  void testWithIsReadOnlyWithValue() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithIsReadOnlyResult =
        immutableEntityNamedNoteTypeChangeCommand.withIsReadOnly(true);

    // Assert
    assertSame(immutableEntityNamedNoteTypeChangeCommand, actualWithIsReadOnlyResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withIsReadOnly(boolean)} with {@code
   * value}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(boolean) with 'value'; then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withIsReadOnly(boolean)"
  })
  void testWithIsReadOnlyWithValue_thenReturnExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(false);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithIsReadOnlyResult =
        externalIdResult
            .isReadOnly(isReadOnly)
            .name("Name")
            .position(1)
            .build()
            .withIsReadOnly(true);

    // Assert
    Optional<String> externalIdResult2 = actualWithIsReadOnlyResult.externalId();
    assertEquals("42", externalIdResult2.get());
    Optional<String> descriptionResult = actualWithIsReadOnlyResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    Optional<Boolean> isReadOnlyResult = actualWithIsReadOnlyResult.isReadOnly();
    assertTrue(isReadOnlyResult.get());
    assertTrue(descriptionResult.isPresent());
    assertTrue(externalIdResult2.isPresent());
    assertTrue(isReadOnlyResult.isPresent());
    assertEquals(applicableEntityKinds, actualWithIsReadOnlyResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withName(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withName(Optional)}
   */
  @Test
  @DisplayName("Test withName(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withName(Optional)"
  })
  void testWithNameWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithNameResult =
        immutableEntityNamedNoteTypeChangeCommand.withName(optional);

    // Assert
    Optional<String> descriptionResult = actualWithNameResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    assertTrue(descriptionResult.isPresent());
    assertEquals(optional, actualWithNameResult.externalId());
    assertEquals(isReadOnly, actualWithNameResult.isReadOnly());
    assertEquals(applicableEntityKinds, actualWithNameResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withName(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withName(Optional)}
   */
  @Test
  @DisplayName("Test withName(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withName(Optional)"
  })
  void testWithNameWithOptional2() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("42").position(1).build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithNameResult =
        immutableEntityNamedNoteTypeChangeCommand.withName(optional);

    // Assert
    assertSame(immutableEntityNamedNoteTypeChangeCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withName(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withName(String)"
  })
  void testWithNameWithValue() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("42").position(1).build();

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithNameResult =
        immutableEntityNamedNoteTypeChangeCommand.withName("42");

    // Assert
    assertSame(immutableEntityNamedNoteTypeChangeCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withName(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String) with 'value'; then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withName(String)"
  })
  void testWithNameWithValue_thenReturnExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithNameResult =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build().withName("42");

    // Assert
    Optional<String> externalIdResult2 = actualWithNameResult.externalId();
    assertEquals("42", externalIdResult2.get());
    Optional<String> descriptionResult = actualWithNameResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    assertTrue(descriptionResult.isPresent());
    assertTrue(externalIdResult2.isPresent());
    assertEquals(isReadOnly, actualWithNameResult.isReadOnly());
    assertEquals(applicableEntityKinds, actualWithNameResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withPosition(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withPosition(Optional)}
   */
  @Test
  @DisplayName("Test withPosition(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withPosition(Optional)"
  })
  void testWithPositionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();
    Optional<Integer> optional = Optional.of(1);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithPositionResult =
        immutableEntityNamedNoteTypeChangeCommand.withPosition(optional);

    // Assert
    assertSame(immutableEntityNamedNoteTypeChangeCommand, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withPosition(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withPosition(Optional)}
   */
  @Test
  @DisplayName(
      "Test withPosition(Optional) with 'optional'; when of forty-two; then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withPosition(Optional)"
  })
  void testWithPositionWithOptional_whenOfFortyTwo_thenReturnExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();
    Optional<Integer> optional = Optional.of(42);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithPositionResult =
        immutableEntityNamedNoteTypeChangeCommand.withPosition(optional);

    // Assert
    Optional<String> externalIdResult2 = actualWithPositionResult.externalId();
    assertEquals("42", externalIdResult2.get());
    Optional<String> descriptionResult = actualWithPositionResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    assertTrue(descriptionResult.isPresent());
    assertTrue(externalIdResult2.isPresent());
    assertEquals(isReadOnly, actualWithPositionResult.isReadOnly());
    assertEquals(applicableEntityKinds, actualWithPositionResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withPosition(int)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withPosition(int)"
  })
  void testWithPositionWithValue() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);
    ImmutableEntityNamedNoteTypeChangeCommand immutableEntityNamedNoteTypeChangeCommand =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build();

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithPositionResult =
        immutableEntityNamedNoteTypeChangeCommand.withPosition(1);

    // Assert
    assertSame(immutableEntityNamedNoteTypeChangeCommand, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withPosition(int)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withPosition(int)}
   */
  @Test
  @DisplayName(
      "Test withPosition(int) with 'value'; when forty-two; then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withPosition(int)"
  })
  void testWithPositionWithValue_whenFortyTwo_thenReturnExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithPositionResult =
        externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build().withPosition(42);

    // Assert
    Optional<String> externalIdResult2 = actualWithPositionResult.externalId();
    assertEquals("42", externalIdResult2.get());
    Optional<String> descriptionResult = actualWithPositionResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    assertTrue(descriptionResult.isPresent());
    assertTrue(externalIdResult2.isPresent());
    assertEquals(isReadOnly, actualWithPositionResult.isReadOnly());
    assertEquals(applicableEntityKinds, actualWithPositionResult.applicableEntityKinds());
  }
}
