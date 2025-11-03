package org.finos.waltz.model.entity_named_note;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#applicableEntityKinds()}
   */
  @Test
  @DisplayName("Test applicableEntityKinds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableEntityNamedNoteTypeChangeCommand.applicableEntityKinds()"})
  void testApplicableEntityKinds() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act and Assert
    assertEquals(applicableEntityKinds, buildResult.applicableEntityKinds());
  }

  /**
   * Test Builder {@link Builder#applicableEntityKinds(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#applicableEntityKinds(Optional)}
   */
  @Test
  @DisplayName("Test Builder applicableEntityKinds(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicableEntityKinds(Optional)"})
  void testBuilderApplicableEntityKindsWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    // Act and Assert
    assertSame(builderResult, builderResult.applicableEntityKinds(applicableEntityKinds));
  }

  /**
   * Test Builder {@link Builder#description(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#description(Optional)}
   */
  @Test
  @DisplayName("Test Builder description(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.description(Optional)"})
  void testBuilderDescriptionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<String> description = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.description(description));
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Test Builder {@link Builder#from(EntityNamedNoteTypeChangeCommand)}.
   * <p>
   * Method under test: {@link Builder#from(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityNamedNoteTypeChangeCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityNamedNoteTypeChangeCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Builder builderResult2 = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand instance = builderResult2.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityNamedNoteTypeChangeCommand)}.
   * <p>
   * Method under test: {@link Builder#from(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityNamedNoteTypeChangeCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityNamedNoteTypeChangeCommand)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Builder builderResult2 = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.empty();
    ImmutableEntityNamedNoteTypeChangeCommand instance = builderResult2.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#isReadOnly(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link Builder#isReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Builder isReadOnly(boolean) with 'boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isReadOnly(boolean)"})
  void testBuilderIsReadOnlyWithBoolean() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Test Builder {@link Builder#isReadOnly(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#isReadOnly(Optional)}
   */
  @Test
  @DisplayName("Test Builder isReadOnly(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isReadOnly(Optional)"})
  void testBuilderIsReadOnlyWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(isReadOnly));
  }

  /**
   * Test Builder {@link Builder#name(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#name(Optional)}
   */
  @Test
  @DisplayName("Test Builder name(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(Optional)"})
  void testBuilderNameWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<String> name = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.name(name));
  }

  /**
   * Test Builder {@link Builder#position(int)} with {@code int}.
   * <p>
   * Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPositionWithInt() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Test Builder {@link Builder#position(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#position(Optional)}
   */
  @Test
  @DisplayName("Test Builder position(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.position(Optional)"})
  void testBuilderPositionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<Integer> position = Optional.<Integer>of(1);

    // Act and Assert
    assertSame(builderResult, builderResult.position(position));
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#copyOf(EntityNamedNoteTypeChangeCommand)}.
   * <ul>
   *   <li>Then return externalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#copyOf(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  @DisplayName("Test copyOf(EntityNamedNoteTypeChangeCommand); then return externalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.copyOf(EntityNamedNoteTypeChangeCommand)"})
  void testCopyOf_thenReturnExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand instance = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualCopyOfResult = ImmutableEntityNamedNoteTypeChangeCommand
        .copyOf(instance);

    // Assert
    Optional<String> externalIdResult = actualCopyOfResult.externalId();
    assertEquals("42", externalIdResult.get());
    Optional<String> descriptionResult = actualCopyOfResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    assertFalse(actualCopyOfResult.isReadOnly().isPresent());
    assertTrue(descriptionResult.isPresent());
    assertTrue(externalIdResult.isPresent());
    assertEquals(applicableEntityKinds, actualCopyOfResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#description()}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#description()}
   */
  @Test
  @DisplayName("Test description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableEntityNamedNoteTypeChangeCommand.description()"})
  void testDescription() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act
    Optional<String> actualDescriptionResult = buildResult.description();

    // Assert
    assertEquals("The characteristics of someone or something", actualDescriptionResult.get());
    assertTrue(actualDescriptionResult.isPresent());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}, and {@link ImmutableEntityNamedNoteTypeChangeCommand#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   *   <li>{@link ImmutableEntityNamedNoteTypeChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
      "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();
    Builder builderResult2 = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds2 = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult2 = builderResult2
        .applicableEntityKinds(applicableEntityKinds2)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}, and {@link ImmutableEntityNamedNoteTypeChangeCommand#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   *   <li>{@link ImmutableEntityNamedNoteTypeChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
      "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
      "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<EntityKind> entityKindSet = new HashSet<>();
    entityKindSet.add(EntityKind.ALL);
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(entityKindSet);
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = ImmutableEntityNamedNoteTypeChangeCommand.builder()
        .applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds2 = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult2 = builderResult.applicableEntityKinds(applicableEntityKinds2)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
      "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("Description")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();
    Builder builderResult2 = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds2 = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult2 = builderResult2
        .applicableEntityKinds(applicableEntityKinds2)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
      "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("External Id")
        .name("Name")
        .position(1)
        .build();
    Builder builderResult2 = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds2 = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult2 = builderResult2
        .applicableEntityKinds(applicableEntityKinds2)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
      "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("applicableEntityKinds")
        .position(1)
        .build();
    Builder builderResult2 = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds2 = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult2 = builderResult2
        .applicableEntityKinds(applicableEntityKinds2)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
      "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(0)
        .build();
    Builder builderResult2 = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds2 = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult2 = builderResult2
        .applicableEntityKinds(applicableEntityKinds2)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
      "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableEntityNamedNoteTypeChangeCommand.equals(Object)",
      "int ImmutableEntityNamedNoteTypeChangeCommand.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableEntityNamedNoteTypeChangeCommand");
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#externalId()}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableEntityNamedNoteTypeChangeCommand.externalId()"})
  void testExternalId() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act
    Optional<String> actualExternalIdResult = buildResult.externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return not applicableEntityKinds Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; then return not applicableEntityKinds Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.fromJson(Json)"})
  void testFromJson_givenNull_thenReturnNotApplicableEntityKindsPresent() {
    // Arrange
    Json json = new Json();
    json.setApplicableEntityKinds(null);
    json.setName(null);
    json.setDescription(null);
    json.setIsReadOnly(null);
    json.setPosition(null);
    json.setExternalId(null);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualFromJsonResult = ImmutableEntityNamedNoteTypeChangeCommand
        .fromJson(json);

    // Assert
    Optional<Set<EntityKind>> applicableEntityKindsResult = actualFromJsonResult.applicableEntityKinds();
    assertFalse(applicableEntityKindsResult.isPresent());
    assertSame(applicableEntityKindsResult, actualFromJsonResult.description());
    assertSame(applicableEntityKindsResult, actualFromJsonResult.externalId());
    assertSame(applicableEntityKindsResult, actualFromJsonResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return description is {@link Json} (default constructor) {@link Json#position}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return description is Json (default constructor) position")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnDescriptionIsJsonPosition() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualFromJsonResult = ImmutableEntityNamedNoteTypeChangeCommand
        .fromJson(json);

    // Assert
    Optional<Integer> optional = json.position;
    assertSame(optional, actualFromJsonResult.description());
    assertSame(optional, actualFromJsonResult.externalId());
    assertSame(optional, actualFromJsonResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#isReadOnly()}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableEntityNamedNoteTypeChangeCommand.isReadOnly()"})
  void testIsReadOnly() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act and Assert
    assertFalse(buildResult.isReadOnly().isPresent());
  }

  /**
   * Test Json {@link Json#applicableEntityKinds()}.
   * <p>
   * Method under test: {@link Json#applicableEntityKinds()}
   */
  @Test
  @DisplayName("Test Json applicableEntityKinds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.applicableEntityKinds()"})
  void testJsonApplicableEntityKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).applicableEntityKinds());
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
   * Test Json {@link Json#isReadOnly()}.
   * <p>
   * Method under test: {@link Json#isReadOnly()}
   */
  @Test
  @DisplayName("Test Json isReadOnly()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.isReadOnly()"})
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isReadOnly());
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
    assertFalse(actualJson.applicableEntityKinds.isPresent());
    assertFalse(actualJson.description.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.isReadOnly.isPresent());
    assertFalse(actualJson.name.isPresent());
    assertFalse(actualJson.position.isPresent());
  }

  /**
   * Test Json {@link Json#position()}.
   * <p>
   * Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).position());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#name()}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#name()}
   */
  @Test
  @DisplayName("Test name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableEntityNamedNoteTypeChangeCommand.name()"})
  void testName() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act
    Optional<String> actualNameResult = buildResult.name();

    // Assert
    assertEquals("Name", actualNameResult.get());
    assertTrue(actualNameResult.isPresent());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#position()}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#position()}
   */
  @Test
  @DisplayName("Test position()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableEntityNamedNoteTypeChangeCommand.position()"})
  void testPosition() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act
    Optional<Integer> actualPositionResult = buildResult.position();

    // Assert
    assertEquals(1, actualPositionResult.get().intValue());
    assertTrue(actualPositionResult.isPresent());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withApplicableEntityKinds(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withApplicableEntityKinds(Optional)}
   */
  @Test
  @DisplayName("Test withApplicableEntityKinds(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withApplicableEntityKinds(Optional)"})
  void testWithApplicableEntityKindsWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();
    Optional<? extends Set<EntityKind>> optional = Optional.of(new HashSet<>());

    // Act and Assert
    assertEquals(buildResult, buildResult.withApplicableEntityKinds(optional));
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withApplicableEntityKinds(Set)} with {@code value}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withApplicableEntityKinds(Set)}
   */
  @Test
  @DisplayName("Test withApplicableEntityKinds(Set) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withApplicableEntityKinds(Set)"})
  void testWithApplicableEntityKindsWithValue() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult.withApplicableEntityKinds(new HashSet<>()));
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withDescription(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withDescription(Optional)}
   */
  @Test
  @DisplayName("Test withDescription(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withDescription(Optional)"})
  void testWithDescriptionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("42")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();
    Optional<String> optional = Optional.of("42");

    // Act and Assert
    assertSame(buildResult, buildResult.withDescription(optional));
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withDescription(Optional)} with {@code optional}.
   * <ul>
   *   <li>Then return externalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withDescription(Optional)}
   */
  @Test
  @DisplayName("Test withDescription(Optional) with 'optional'; then return externalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withDescription(Optional)"})
  void testWithDescriptionWithOptional_thenReturnExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithDescriptionResult = buildResult.withDescription(optional);

    // Assert
    Optional<String> externalIdResult = actualWithDescriptionResult.externalId();
    assertEquals("42", externalIdResult.get());
    assertFalse(actualWithDescriptionResult.isReadOnly().isPresent());
    assertTrue(externalIdResult.isPresent());
    assertEquals(optional, actualWithDescriptionResult.description());
    assertEquals(applicableEntityKinds, actualWithDescriptionResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withDescription(String)} with {@code value}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withDescription(String)"})
  void testWithDescriptionWithValue() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("42")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withDescription("42"));
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withDescription(String)} with {@code value}.
   * <ul>
   *   <li>Then return description is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String) with 'value'; then return description is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withDescription(String)"})
  void testWithDescriptionWithValue_thenReturnDescriptionIs42() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithDescriptionResult = buildResult.withDescription("42");

    // Assert
    Optional<String> descriptionResult = actualWithDescriptionResult.description();
    assertEquals("42", descriptionResult.get());
    assertFalse(actualWithDescriptionResult.isReadOnly().isPresent());
    assertTrue(descriptionResult.isPresent());
    assertEquals(descriptionResult, actualWithDescriptionResult.externalId());
    assertEquals(applicableEntityKinds, actualWithDescriptionResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withExternalId(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();
    Optional<String> optional = Optional.of("0123456789ABCDEF");

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithExternalIdResult = buildResult.withExternalId(optional);

    // Assert
    Optional<String> descriptionResult = actualWithExternalIdResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    assertFalse(actualWithExternalIdResult.isReadOnly().isPresent());
    assertTrue(descriptionResult.isPresent());
    assertEquals(optional, actualWithExternalIdResult.externalId());
    assertEquals(applicableEntityKinds, actualWithExternalIdResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withExternalId(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withExternalId(Optional)"})
  void testWithExternalIdWithOptional2() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();
    Optional<String> optional = Optional.of("42");

    // Act and Assert
    assertSame(buildResult, buildResult.withExternalId(optional));
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withExternalId(String)} with {@code value}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withExternalId("42"));
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withExternalId(String)} with {@code value}.
   * <ul>
   *   <li>Then return externalId is {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'; then return externalId is '0123456789ABCDEF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withExternalId(String)"})
  void testWithExternalIdWithValue_thenReturnExternalIdIs0123456789abcdef() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithExternalIdResult = buildResult
        .withExternalId("0123456789ABCDEF");

    // Assert
    Optional<String> externalIdResult = actualWithExternalIdResult.externalId();
    assertEquals("0123456789ABCDEF", externalIdResult.get());
    Optional<String> descriptionResult = actualWithExternalIdResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    assertFalse(actualWithExternalIdResult.isReadOnly().isPresent());
    assertTrue(descriptionResult.isPresent());
    assertTrue(externalIdResult.isPresent());
    assertEquals(applicableEntityKinds, actualWithExternalIdResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withIsReadOnly(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withIsReadOnly(Optional)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withIsReadOnly(Optional)"})
  void testWithIsReadOnlyWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();
    Optional<Boolean> optional = Optional.of(true);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithIsReadOnlyResult = buildResult.withIsReadOnly(optional);

    // Assert
    Optional<String> externalIdResult = actualWithIsReadOnlyResult.externalId();
    assertEquals("42", externalIdResult.get());
    Optional<String> descriptionResult = actualWithIsReadOnlyResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    assertTrue(descriptionResult.isPresent());
    assertTrue(externalIdResult.isPresent());
    assertEquals(optional, actualWithIsReadOnlyResult.isReadOnly());
    assertEquals(applicableEntityKinds, actualWithIsReadOnlyResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withIsReadOnly(boolean)} with {@code value}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(boolean) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withIsReadOnly(boolean)"})
  void testWithIsReadOnlyWithValue() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithIsReadOnlyResult = buildResult.withIsReadOnly(true);

    // Assert
    Optional<String> externalIdResult = actualWithIsReadOnlyResult.externalId();
    assertEquals("42", externalIdResult.get());
    Optional<String> descriptionResult = actualWithIsReadOnlyResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    Optional<Boolean> isReadOnlyResult = actualWithIsReadOnlyResult.isReadOnly();
    assertTrue(isReadOnlyResult.get());
    assertTrue(descriptionResult.isPresent());
    assertTrue(externalIdResult.isPresent());
    assertTrue(isReadOnlyResult.isPresent());
    assertEquals(applicableEntityKinds, actualWithIsReadOnlyResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withName(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withName(Optional)}
   */
  @Test
  @DisplayName("Test withName(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withName(Optional)"})
  void testWithNameWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithNameResult = buildResult.withName(optional);

    // Assert
    Optional<String> externalIdResult = actualWithNameResult.externalId();
    assertEquals("42", externalIdResult.get());
    Optional<String> descriptionResult = actualWithNameResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    assertFalse(actualWithNameResult.isReadOnly().isPresent());
    assertTrue(descriptionResult.isPresent());
    assertTrue(externalIdResult.isPresent());
    assertEquals(applicableEntityKinds, actualWithNameResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withName(String)} with {@code value}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withName(String)"})
  void testWithNameWithValue() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("42")
        .position(1)
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withName("42"));
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withName(String)} with {@code value}.
   * <ul>
   *   <li>Then return externalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String) with 'value'; then return externalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withName(String)"})
  void testWithNameWithValue_thenReturnExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithNameResult = buildResult.withName("42");

    // Assert
    Optional<String> externalIdResult = actualWithNameResult.externalId();
    assertEquals("42", externalIdResult.get());
    Optional<String> descriptionResult = actualWithNameResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    assertFalse(actualWithNameResult.isReadOnly().isPresent());
    assertTrue(descriptionResult.isPresent());
    assertTrue(externalIdResult.isPresent());
    assertEquals(applicableEntityKinds, actualWithNameResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withPosition(Optional)} with {@code optional}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withPosition(Optional)}
   */
  @Test
  @DisplayName("Test withPosition(Optional) with 'optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withPosition(Optional)"})
  void testWithPositionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();
    Optional<Integer> optional = Optional.<Integer>of(1);

    // Act and Assert
    assertSame(buildResult, buildResult.withPosition(optional));
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withPosition(Optional)} with {@code optional}.
   * <ul>
   *   <li>Then return externalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withPosition(Optional)}
   */
  @Test
  @DisplayName("Test withPosition(Optional) with 'optional'; then return externalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withPosition(Optional)"})
  void testWithPositionWithOptional_thenReturnExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(0)
        .build();
    Optional<Integer> optional = Optional.<Integer>of(1);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithPositionResult = buildResult.withPosition(optional);

    // Assert
    Optional<String> externalIdResult = actualWithPositionResult.externalId();
    assertEquals("42", externalIdResult.get());
    Optional<String> descriptionResult = actualWithPositionResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    assertFalse(actualWithPositionResult.isReadOnly().isPresent());
    assertTrue(descriptionResult.isPresent());
    assertTrue(externalIdResult.isPresent());
    assertEquals(applicableEntityKinds, actualWithPositionResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withPosition(int)} with {@code value}.
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withPosition(int)"})
  void testWithPositionWithValue() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act and Assert
    assertSame(buildResult, buildResult.withPosition(1));
  }

  /**
   * Test {@link ImmutableEntityNamedNoteTypeChangeCommand#withPosition(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return externalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableEntityNamedNoteTypeChangeCommand#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int) with 'value'; when forty-two; then return externalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableEntityNamedNoteTypeChangeCommand ImmutableEntityNamedNoteTypeChangeCommand.withPosition(int)"})
  void testWithPositionWithValue_whenFortyTwo_thenReturnExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());
    ImmutableEntityNamedNoteTypeChangeCommand buildResult = builderResult.applicableEntityKinds(applicableEntityKinds)
        .description("The characteristics of someone or something")
        .externalId("42")
        .name("Name")
        .position(1)
        .build();

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualWithPositionResult = buildResult.withPosition(42);

    // Assert
    Optional<String> externalIdResult = actualWithPositionResult.externalId();
    assertEquals("42", externalIdResult.get());
    Optional<String> descriptionResult = actualWithPositionResult.description();
    assertEquals("The characteristics of someone or something", descriptionResult.get());
    assertFalse(actualWithPositionResult.isReadOnly().isPresent());
    assertTrue(descriptionResult.isPresent());
    assertTrue(externalIdResult.isPresent());
    assertEquals(applicableEntityKinds, actualWithPositionResult.applicableEntityKinds());
  }
}
