package org.finos.waltz.model.entity_named_note;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.Test;

class ImmutableEntityNamedNoteTypeChangeCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Builder#description(Optional)}
   */
  @Test
  void testBuilderDescription() {
    // Arrange
    ImmutableEntityNamedNoteTypeChangeCommand.Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand
        .builder();
    Optional<String> description = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.description(description));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableEntityNamedNoteTypeChangeCommand.Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand
        .builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Builder#from(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityNamedNoteTypeChangeCommand.Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand
        .builder();
    EntityNamedNoteTypeChangeCommand instance = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> ofResult = Optional.of(new HashSet<>());
    when(instance.applicableEntityKinds()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Boolean> ofResult4 = Optional.of(true);
    when(instance.isReadOnly()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult5);
    Optional<Integer> ofResult6 = Optional.<Integer>of(1);
    when(instance.position()).thenReturn(ofResult6);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicableEntityKinds();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).name();
    verify(instance).position();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Builder#from(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityNamedNoteTypeChangeCommand.Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand
        .builder();
    EntityNamedNoteTypeChangeCommand instance = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> emptyResult = Optional.empty();
    when(instance.applicableEntityKinds()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Boolean> ofResult3 = Optional.of(true);
    when(instance.isReadOnly()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult4);
    Optional<Integer> ofResult5 = Optional.<Integer>of(1);
    when(instance.position()).thenReturn(ofResult5);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicableEntityKinds();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).name();
    verify(instance).position();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Builder#from(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityNamedNoteTypeChangeCommand.Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand
        .builder();
    EntityNamedNoteTypeChangeCommand instance = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> ofResult = Optional.of(new HashSet<>());
    when(instance.applicableEntityKinds()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.description()).thenReturn(emptyResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Boolean> ofResult3 = Optional.of(true);
    when(instance.isReadOnly()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult4);
    Optional<Integer> ofResult5 = Optional.<Integer>of(1);
    when(instance.position()).thenReturn(ofResult5);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicableEntityKinds();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).name();
    verify(instance).position();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Builder#from(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEntityNamedNoteTypeChangeCommand.Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand
        .builder();
    EntityNamedNoteTypeChangeCommand instance = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> ofResult = Optional.of(new HashSet<>());
    when(instance.applicableEntityKinds()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult2);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Boolean> ofResult3 = Optional.of(true);
    when(instance.isReadOnly()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult4);
    Optional<Integer> ofResult5 = Optional.<Integer>of(1);
    when(instance.position()).thenReturn(ofResult5);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicableEntityKinds();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).name();
    verify(instance).position();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Builder#from(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEntityNamedNoteTypeChangeCommand.Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand
        .builder();
    EntityNamedNoteTypeChangeCommand instance = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> ofResult = Optional.of(new HashSet<>());
    when(instance.applicableEntityKinds()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Boolean> emptyResult = Optional.empty();
    when(instance.isReadOnly()).thenReturn(emptyResult);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult4);
    Optional<Integer> ofResult5 = Optional.<Integer>of(1);
    when(instance.position()).thenReturn(ofResult5);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicableEntityKinds();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).name();
    verify(instance).position();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Builder#from(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEntityNamedNoteTypeChangeCommand.Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand
        .builder();
    EntityNamedNoteTypeChangeCommand instance = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> ofResult = Optional.of(new HashSet<>());
    when(instance.applicableEntityKinds()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Boolean> ofResult4 = Optional.of(true);
    when(instance.isReadOnly()).thenReturn(ofResult4);
    Optional<String> emptyResult = Optional.empty();
    when(instance.name()).thenReturn(emptyResult);
    Optional<Integer> ofResult5 = Optional.<Integer>of(1);
    when(instance.position()).thenReturn(ofResult5);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicableEntityKinds();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).name();
    verify(instance).position();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Builder#from(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEntityNamedNoteTypeChangeCommand.Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand
        .builder();
    EntityNamedNoteTypeChangeCommand instance = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> ofResult = Optional.of(new HashSet<>());
    when(instance.applicableEntityKinds()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Boolean> ofResult4 = Optional.of(true);
    when(instance.isReadOnly()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult5);
    Optional<Integer> emptyResult = Optional.empty();
    when(instance.position()).thenReturn(emptyResult);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicableEntityKinds();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).name();
    verify(instance).position();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Builder#isReadOnly(Optional)}
   */
  @Test
  void testBuilderIsReadOnly() {
    // Arrange
    ImmutableEntityNamedNoteTypeChangeCommand.Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand
        .builder();
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(isReadOnly));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly2() {
    // Arrange
    ImmutableEntityNamedNoteTypeChangeCommand.Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Builder#name(Optional)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableEntityNamedNoteTypeChangeCommand.Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand
        .builder();
    Optional<String> name = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.name(name));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableEntityNamedNoteTypeChangeCommand.Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Builder#position(Optional)}
   */
  @Test
  void testBuilderPosition2() {
    // Arrange
    ImmutableEntityNamedNoteTypeChangeCommand.Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand
        .builder();
    Optional<Integer> position = Optional.<Integer>of(1);

    // Act and Assert
    assertSame(builderResult, builderResult.position(position));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand#copyOf(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityNamedNoteTypeChangeCommand instance = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> ofResult = Optional.of(new HashSet<>());
    when(instance.applicableEntityKinds()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Boolean> ofResult4 = Optional.of(true);
    when(instance.isReadOnly()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult5);
    Optional<Integer> ofResult6 = Optional.<Integer>of(1);
    when(instance.position()).thenReturn(ofResult6);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualCopyOfResult = ImmutableEntityNamedNoteTypeChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).applicableEntityKinds();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).name();
    verify(instance).position();
    assertEquals(ofResult2, actualCopyOfResult.description());
    assertEquals(ofResult2, actualCopyOfResult.externalId());
    assertEquals(ofResult4, actualCopyOfResult.isReadOnly());
    assertEquals(ofResult, actualCopyOfResult.applicableEntityKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand#copyOf(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    EntityNamedNoteTypeChangeCommand instance = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> emptyResult = Optional.empty();
    when(instance.applicableEntityKinds()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Boolean> ofResult3 = Optional.of(true);
    when(instance.isReadOnly()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult4);
    Optional<Integer> ofResult5 = Optional.<Integer>of(1);
    when(instance.position()).thenReturn(ofResult5);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualCopyOfResult = ImmutableEntityNamedNoteTypeChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).applicableEntityKinds();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).name();
    verify(instance).position();
    Optional<Set<EntityKind>> applicableEntityKindsResult = actualCopyOfResult.applicableEntityKinds();
    assertFalse(applicableEntityKindsResult.isPresent());
    assertEquals(ofResult, actualCopyOfResult.description());
    assertEquals(ofResult, actualCopyOfResult.externalId());
    assertEquals(ofResult3, actualCopyOfResult.isReadOnly());
    assertSame(emptyResult, applicableEntityKindsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand#copyOf(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    EntityNamedNoteTypeChangeCommand instance = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> ofResult = Optional.of(new HashSet<>());
    when(instance.applicableEntityKinds()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.description()).thenReturn(emptyResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Boolean> ofResult3 = Optional.of(true);
    when(instance.isReadOnly()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult4);
    Optional<Integer> ofResult5 = Optional.<Integer>of(1);
    when(instance.position()).thenReturn(ofResult5);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualCopyOfResult = ImmutableEntityNamedNoteTypeChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).applicableEntityKinds();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).name();
    verify(instance).position();
    Optional<String> descriptionResult = actualCopyOfResult.description();
    assertFalse(descriptionResult.isPresent());
    assertEquals(ofResult2, actualCopyOfResult.externalId());
    assertEquals(ofResult3, actualCopyOfResult.isReadOnly());
    assertEquals(ofResult, actualCopyOfResult.applicableEntityKinds());
    assertSame(emptyResult, descriptionResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand#copyOf(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    EntityNamedNoteTypeChangeCommand instance = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> ofResult = Optional.of(new HashSet<>());
    when(instance.applicableEntityKinds()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult2);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Boolean> ofResult3 = Optional.of(true);
    when(instance.isReadOnly()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult4);
    Optional<Integer> ofResult5 = Optional.<Integer>of(1);
    when(instance.position()).thenReturn(ofResult5);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualCopyOfResult = ImmutableEntityNamedNoteTypeChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).applicableEntityKinds();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).name();
    verify(instance).position();
    Optional<String> externalIdResult = actualCopyOfResult.externalId();
    assertFalse(externalIdResult.isPresent());
    assertEquals(ofResult2, actualCopyOfResult.description());
    assertEquals(ofResult3, actualCopyOfResult.isReadOnly());
    assertEquals(ofResult, actualCopyOfResult.applicableEntityKinds());
    assertSame(emptyResult, externalIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand#copyOf(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    EntityNamedNoteTypeChangeCommand instance = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> ofResult = Optional.of(new HashSet<>());
    when(instance.applicableEntityKinds()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Boolean> emptyResult = Optional.empty();
    when(instance.isReadOnly()).thenReturn(emptyResult);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult4);
    Optional<Integer> ofResult5 = Optional.<Integer>of(1);
    when(instance.position()).thenReturn(ofResult5);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualCopyOfResult = ImmutableEntityNamedNoteTypeChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).applicableEntityKinds();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).name();
    verify(instance).position();
    Optional<Boolean> isReadOnlyResult = actualCopyOfResult.isReadOnly();
    assertFalse(isReadOnlyResult.isPresent());
    assertEquals(ofResult2, actualCopyOfResult.description());
    assertEquals(ofResult2, actualCopyOfResult.externalId());
    assertEquals(ofResult, actualCopyOfResult.applicableEntityKinds());
    assertSame(emptyResult, isReadOnlyResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand#copyOf(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    EntityNamedNoteTypeChangeCommand instance = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> ofResult = Optional.of(new HashSet<>());
    when(instance.applicableEntityKinds()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Boolean> ofResult4 = Optional.of(true);
    when(instance.isReadOnly()).thenReturn(ofResult4);
    Optional<String> emptyResult = Optional.empty();
    when(instance.name()).thenReturn(emptyResult);
    Optional<Integer> ofResult5 = Optional.<Integer>of(1);
    when(instance.position()).thenReturn(ofResult5);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualCopyOfResult = ImmutableEntityNamedNoteTypeChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).applicableEntityKinds();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).name();
    verify(instance).position();
    assertEquals(ofResult2, actualCopyOfResult.description());
    assertEquals(ofResult2, actualCopyOfResult.externalId());
    assertEquals(ofResult4, actualCopyOfResult.isReadOnly());
    assertEquals(ofResult, actualCopyOfResult.applicableEntityKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand#copyOf(EntityNamedNoteTypeChangeCommand)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    EntityNamedNoteTypeChangeCommand instance = mock(EntityNamedNoteTypeChangeCommand.class);
    Optional<Set<EntityKind>> ofResult = Optional.of(new HashSet<>());
    when(instance.applicableEntityKinds()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.description()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Boolean> ofResult4 = Optional.of(true);
    when(instance.isReadOnly()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.name()).thenReturn(ofResult5);
    Optional<Integer> emptyResult = Optional.empty();
    when(instance.position()).thenReturn(emptyResult);

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualCopyOfResult = ImmutableEntityNamedNoteTypeChangeCommand
        .copyOf(instance);

    // Assert
    verify(instance).applicableEntityKinds();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).name();
    verify(instance).position();
    assertEquals(ofResult2, actualCopyOfResult.description());
    assertEquals(ofResult2, actualCopyOfResult.externalId());
    assertEquals(ofResult4, actualCopyOfResult.isReadOnly());
    assertEquals(ofResult, actualCopyOfResult.applicableEntityKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(ImmutableEntityNamedNoteTypeChangeCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableEntityNamedNoteTypeChangeCommand.Json json = new ImmutableEntityNamedNoteTypeChangeCommand.Json();

    // Act
    ImmutableEntityNamedNoteTypeChangeCommand actualFromJsonResult = ImmutableEntityNamedNoteTypeChangeCommand
        .fromJson(json);

    // Assert
    Optional<Set<EntityKind>> applicableEntityKindsResult = actualFromJsonResult.applicableEntityKinds();
    assertFalse(applicableEntityKindsResult.isPresent());
    Optional<Integer> optional = json.position;
    assertSame(optional, applicableEntityKindsResult);
    assertSame(optional, actualFromJsonResult.description());
    assertSame(optional, actualFromJsonResult.externalId());
    assertSame(optional, actualFromJsonResult.isReadOnly());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand#fromJson(ImmutableEntityNamedNoteTypeChangeCommand.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableEntityNamedNoteTypeChangeCommand.Json json = new ImmutableEntityNamedNoteTypeChangeCommand.Json();
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
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Json#applicableEntityKinds()}
   */
  @Test
  void testJsonApplicableEntityKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityNamedNoteTypeChangeCommand.Json()).applicableEntityKinds());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityNamedNoteTypeChangeCommand.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityNamedNoteTypeChangeCommand.Json()).externalId());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Json#isReadOnly()}
   */
  @Test
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityNamedNoteTypeChangeCommand.Json()).isReadOnly());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityNamedNoteTypeChangeCommand.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityNamedNoteTypeChangeCommand.Json actualJson = new ImmutableEntityNamedNoteTypeChangeCommand.Json();

    // Assert
    assertFalse(actualJson.applicableEntityKinds.isPresent());
    assertFalse(actualJson.description.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.isReadOnly.isPresent());
    assertFalse(actualJson.name.isPresent());
    assertFalse(actualJson.position.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityNamedNoteTypeChangeCommand.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEntityNamedNoteTypeChangeCommand.Json()).position());
  }
}
