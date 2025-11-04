package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableAttestationRunCreateCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAttestationRunCreateCommand#builder()}
   *   <li>{@link ImmutableAttestationRunCreateCommand#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAttestationRunCreateCommand.Builder actualAttestedEntityIdResult = ImmutableAttestationRunCreateCommand
        .builder()
        .attestedEntityId(1L);
    Optional<Long> attestedEntityId = Optional.<Long>of(1L);
    ImmutableAttestationRunCreateCommand.Builder actualAttestedEntityIdResult2 = actualAttestedEntityIdResult
        .attestedEntityId(attestedEntityId);

    // Assert
    assertSame(actualAttestedEntityIdResult2,
        actualAttestedEntityIdResult2.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllInvolvementKindIds() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllInvolvementKindIds2() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#addInvolvementKindIds(long)}
   */
  @Test
  void testBuilderAddInvolvementKindIds() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#addInvolvementKindIds(long[])}
   */
  @Test
  void testBuilderAddInvolvementKindIds2() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L, -17L, 1L, -17L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#attestedEntityId(long)}
   */
  @Test
  void testBuilderAttestedEntityId() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestedEntityId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#attestedEntityId(Optional)}
   */
  @Test
  void testBuilderAttestedEntityId2() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
    Optional<Long> attestedEntityId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.attestedEntityId(attestedEntityId));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#attestedEntityKind(EntityKind)}
   */
  @Test
  void testBuilderAttestedEntityKind() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestedEntityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#dueDate(LocalDate)}
   */
  @Test
  void testBuilderDueDate() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#from(AttestationRunCreateCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
    AttestationRunCreateCommand instance = mock(AttestationRunCreateCommand.class);
    when(instance.selectionOptions()).thenThrow(new IllegalStateException("instance"));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.attestedEntityId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).selectionOptions();
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#from(AttestationRunCreateCommand)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
    AttestationRunCreateCommand instance = mock(AttestationRunCreateCommand.class);
    when(instance.selectionOptions()).thenThrow(new IllegalStateException("instance"));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.attestedEntityId()).thenReturn(ofResult);
    when(instance.description()).thenReturn(null);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).selectionOptions();
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#from(AttestationRunCreateCommand)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
    AttestationRunCreateCommand instance = mock(AttestationRunCreateCommand.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.attestedEntityId()).thenReturn(ofResult3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).issuedOn();
    verify(instance).selectionOptions();
    verify(instance).targetEntityKind();
    ImmutableAttestationRunCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertSame(ofResult2, buildResult.dueDate());
    assertSame(ofResult, buildResult.issuedOn());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#from(AttestationRunCreateCommand)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();
    AttestationRunCreateCommand instance = mock(AttestationRunCreateCommand.class);
    when(instance.issuedOn()).thenThrow(new IllegalStateException("instance"));
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.attestedEntityId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).issuedOn();
    verify(instance).selectionOptions();
    verify(instance).targetEntityKind();
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#from(AttestationRunCreateCommand)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    AttestationRunCreateCommand instance = mock(AttestationRunCreateCommand.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult);
    when(instance.involvementKindIds()).thenReturn(resultLongSet);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.attestedEntityId()).thenReturn(ofResult3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttestationRunCreateCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).issuedOn();
    verify(instance).selectionOptions();
    verify(instance).targetEntityKind();
    ImmutableAttestationRunCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    Set<Long> involvementKindIdsResult = buildResult.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    assertEquals(EntityKind.ALL, buildResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertTrue(involvementKindIdsResult.contains(1L));
    assertSame(ofResult2, buildResult.dueDate());
    assertSame(ofResult, buildResult.issuedOn());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#involvementKindIds(Iterable)}
   */
  @Test
  void testBuilderInvolvementKindIds() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#involvementKindIds(Iterable)}
   */
  @Test
  void testBuilderInvolvementKindIds2() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#selectionOptions(IdSelectionOptions)}
   */
  @Test
  void testBuilderSelectionOptions() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.selectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Builder#targetEntityKind(EntityKind)}
   */
  @Test
  void testBuilderTargetEntityKind() {
    // Arrange
    ImmutableAttestationRunCreateCommand.Builder builderResult = ImmutableAttestationRunCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetEntityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand#copyOf(AttestationRunCreateCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AttestationRunCreateCommand instance = mock(AttestationRunCreateCommand.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.attestedEntityId()).thenReturn(ofResult3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttestationRunCreateCommand actualCopyOfResult = ImmutableAttestationRunCreateCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).issuedOn();
    verify(instance).selectionOptions();
    verify(instance).targetEntityKind();
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertTrue(actualCopyOfResult.involvementKindIds().isEmpty());
    assertSame(ofResult2, dueDateResult);
    assertSame(ofResult, issuedOnResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand#copyOf(AttestationRunCreateCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(31L);
    AttestationRunCreateCommand instance = mock(AttestationRunCreateCommand.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult);
    when(instance.involvementKindIds()).thenReturn(resultLongSet);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.attestedEntityId()).thenReturn(ofResult3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttestationRunCreateCommand actualCopyOfResult = ImmutableAttestationRunCreateCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).issuedOn();
    verify(instance).selectionOptions();
    verify(instance).targetEntityKind();
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    Set<Long> involvementKindIdsResult = actualCopyOfResult.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertTrue(involvementKindIdsResult.contains(31L));
    assertSame(ofResult2, dueDateResult);
    assertSame(ofResult, issuedOnResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand#copyOf(AttestationRunCreateCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    resultLongSet.add(31L);
    AttestationRunCreateCommand instance = mock(AttestationRunCreateCommand.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult);
    when(instance.involvementKindIds()).thenReturn(resultLongSet);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.attestedEntityId()).thenReturn(ofResult3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttestationRunCreateCommand actualCopyOfResult = ImmutableAttestationRunCreateCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).issuedOn();
    verify(instance).selectionOptions();
    verify(instance).targetEntityKind();
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertEquals(resultLongSet, actualCopyOfResult.involvementKindIds());
    assertSame(ofResult2, dueDateResult);
    assertSame(ofResult, issuedOnResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand#copyOf(AttestationRunCreateCommand)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    AttestationRunCreateCommand instance = mock(AttestationRunCreateCommand.class);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.attestedEntityId()).thenReturn(ofResult3);
    when(instance.description()).thenReturn(null);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttestationRunCreateCommand actualCopyOfResult = ImmutableAttestationRunCreateCommand.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityId();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).involvementKindIds();
    verify(instance).issuedOn();
    verify(instance).selectionOptions();
    verify(instance).targetEntityKind();
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertTrue(actualCopyOfResult.involvementKindIds().isEmpty());
    assertSame(ofResult2, dueDateResult);
    assertSame(ofResult, issuedOnResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Json#attestedEntityId()}
   */
  @Test
  void testJsonAttestedEntityId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationRunCreateCommand.Json()).attestedEntityId());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Json#attestedEntityKind()}
   */
  @Test
  void testJsonAttestedEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationRunCreateCommand.Json()).attestedEntityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationRunCreateCommand.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Json#dueDate()}
   */
  @Test
  void testJsonDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationRunCreateCommand.Json()).dueDate());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Json#involvementKindIds()}
   */
  @Test
  void testJsonInvolvementKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationRunCreateCommand.Json()).involvementKindIds());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Json#issuedOn()}
   */
  @Test
  void testJsonIssuedOn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationRunCreateCommand.Json()).issuedOn());
  }

  /**
   * Method under test: {@link ImmutableAttestationRunCreateCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRunCreateCommand.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAttestationRunCreateCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAttestationRunCreateCommand.Json actualJson = new ImmutableAttestationRunCreateCommand.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.dueDate);
    assertNull(actualJson.issuedOn);
    assertNull(actualJson.attestedEntityKind);
    assertNull(actualJson.targetEntityKind);
    assertNull(actualJson.selectionOptions);
    assertFalse(actualJson.attestedEntityId.isPresent());
    assertTrue(actualJson.involvementKindIds.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Json#selectionOptions()}
   */
  @Test
  void testJsonSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationRunCreateCommand.Json()).selectionOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunCreateCommand.Json#targetEntityKind()}
   */
  @Test
  void testJsonTargetEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationRunCreateCommand.Json()).targetEntityKind());
  }
}
