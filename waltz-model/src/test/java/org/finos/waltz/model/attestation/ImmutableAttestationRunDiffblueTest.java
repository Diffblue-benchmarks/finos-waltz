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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.WaltzEntity;
import org.junit.jupiter.api.Test;

class ImmutableAttestationRunDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllInvolvementKindIds() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllInvolvementKindIds2() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#addAllInvolvementKindIds(Iterable)}
   */
  @Test
  void testBuilderAddAllInvolvementKindIds3() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    builderResult.attestedEntityRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInvolvementKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#addInvolvementKindIds(long)}
   */
  @Test
  void testBuilderAddInvolvementKindIds() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#addInvolvementKindIds(long)}
   */
  @Test
  void testBuilderAddInvolvementKindIds2() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    builderResult.attestedEntityRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#addInvolvementKindIds(long[])}
   */
  @Test
  void testBuilderAddInvolvementKindIds3() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L, -17L, 1L, -17L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#addInvolvementKindIds(long[])}
   */
  @Test
  void testBuilderAddInvolvementKindIds4() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    builderResult.attestedEntityRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addInvolvementKindIds(1L, -17L, 1L, -17L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#attestedEntityKind(EntityKind)}
   */
  @Test
  void testBuilderAttestedEntityKind() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.attestedEntityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#attestedEntityKind(EntityKind)}
   */
  @Test
  void testBuilderAttestedEntityKind2() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    builderResult.attestedEntityRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.attestedEntityKind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Builder#dueDate(LocalDate)}
   */
  @Test
  void testBuilderDueDate() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Builder#dueDate(LocalDate)}
   */
  @Test
  void testBuilderDueDate2() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    builderResult.attestedEntityRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.dueDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableAttestationRun.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableAttestationRun.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableAttestationRun.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableAttestationRun.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttestationRun.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Builder#from(WaltzEntity)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableAttestationRun.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Builder#from(WaltzEntity)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    WaltzEntity instance = mock(WaltzEntity.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#from(AttestationRun)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    AttestationRun instance = mock(AttestationRun.class);
    when(instance.selectionOptions()).thenThrow(new IllegalStateException("instance"));
    when(instance.issuedBy()).thenReturn("Issued By");
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).issuedBy();
    verify(instance).selectionOptions();
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#from(AttestationRun)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    AttestationRun instance = mock(AttestationRun.class);
    when(instance.selectionOptions()).thenThrow(new IllegalStateException("instance"));
    when(instance.issuedBy()).thenReturn(null);
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).issuedBy();
    verify(instance).selectionOptions();
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#from(AttestationRun)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    AttestationRun instance = mock(AttestationRun.class);
    when(instance.selectionOptions()).thenThrow(new IllegalStateException("instance"));
    when(instance.issuedBy()).thenReturn("Issued By");
    when(instance.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.description()).thenReturn(null);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).attestedEntityKind();
    verify(instance).dueDate();
    verify(instance).issuedBy();
    verify(instance).selectionOptions();
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    builderResult.attestedEntityRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    builderResult.attestedEntityRef(mock(EntityReference.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#involvementKindIds(Iterable)}
   */
  @Test
  void testBuilderInvolvementKindIds() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#involvementKindIds(Iterable)}
   */
  @Test
  void testBuilderInvolvementKindIds2() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#involvementKindIds(Iterable)}
   */
  @Test
  void testBuilderInvolvementKindIds3() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    builderResult.attestedEntityRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.involvementKindIds(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Builder#name(String)}
   */
  @Test
  void testBuilderName2() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    builderResult.attestedEntityRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#selectionOptions(IdSelectionOptions)}
   */
  @Test
  void testBuilderSelectionOptions() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.selectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#targetEntityKind(EntityKind)}
   */
  @Test
  void testBuilderTargetEntityKind() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetEntityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRun.Builder#targetEntityKind(EntityKind)}
   */
  @Test
  void testBuilderTargetEntityKind2() {
    // Arrange
    ImmutableAttestationRun.Builder builderResult = ImmutableAttestationRun.builder();
    builderResult.attestedEntityRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.targetEntityKind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutableAttestationRun#copyOf(AttestationRun)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AttestationRun instance = mock(AttestationRun.class);
    when(instance.status()).thenReturn(AttestationStatus.DRAFT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(mock(EntityReference.class));
    when(instance.attestedEntityRef()).thenReturn(ofResult2);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult3);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.issuedBy()).thenReturn("Issued By");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttestationRun actualCopyOfResult = ImmutableAttestationRun.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).attestedEntityKind();
    verify(instance).attestedEntityRef();
    verify(instance).dueDate();
    verify(instance).entityReference();
    verify(instance).involvementKindIds();
    verify(instance).issuedBy();
    verify(instance).issuedOn();
    verify(instance).provenance();
    verify(instance).selectionOptions();
    verify(instance).status();
    verify(instance).targetEntityKind();
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Issued By", actualCopyOfResult.issuedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.involvementKindIds().isEmpty());
    assertSame(ofResult4, dueDateResult);
    assertSame(ofResult3, issuedOnResult);
  }

  /**
   * Method under test: {@link ImmutableAttestationRun#copyOf(AttestationRun)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AttestationRun instance = mock(AttestationRun.class);
    when(instance.status()).thenReturn(AttestationStatus.DRAFT);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<EntityReference> ofResult = Optional.of(mock(EntityReference.class));
    when(instance.attestedEntityRef()).thenReturn(ofResult);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult2);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.issuedBy()).thenReturn("Issued By");
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttestationRun actualCopyOfResult = ImmutableAttestationRun.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).attestedEntityKind();
    verify(instance).attestedEntityRef();
    verify(instance).dueDate();
    verify(instance).entityReference();
    verify(instance).involvementKindIds();
    verify(instance).issuedBy();
    verify(instance).issuedOn();
    verify(instance).provenance();
    verify(instance).selectionOptions();
    verify(instance).status();
    verify(instance).targetEntityKind();
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Issued By", actualCopyOfResult.issuedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.involvementKindIds().isEmpty());
    assertSame(ofResult3, dueDateResult);
    assertSame(ofResult2, issuedOnResult);
  }

  /**
   * Method under test: {@link ImmutableAttestationRun#copyOf(AttestationRun)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    AttestationRun instance = mock(AttestationRun.class);
    when(instance.status()).thenReturn(AttestationStatus.DRAFT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.attestedEntityRef()).thenReturn(emptyResult);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult2);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.issuedBy()).thenReturn("Issued By");
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttestationRun actualCopyOfResult = ImmutableAttestationRun.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).attestedEntityKind();
    verify(instance).attestedEntityRef();
    verify(instance).dueDate();
    verify(instance).entityReference();
    verify(instance).involvementKindIds();
    verify(instance).issuedBy();
    verify(instance).issuedOn();
    verify(instance).provenance();
    verify(instance).selectionOptions();
    verify(instance).status();
    verify(instance).targetEntityKind();
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Issued By", actualCopyOfResult.issuedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.involvementKindIds().isEmpty());
    assertSame(ofResult3, dueDateResult);
    assertSame(ofResult2, issuedOnResult);
  }

  /**
   * Method under test: {@link ImmutableAttestationRun#copyOf(AttestationRun)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(4L);
    AttestationRun instance = mock(AttestationRun.class);
    when(instance.status()).thenReturn(AttestationStatus.DRAFT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(mock(EntityReference.class));
    when(instance.attestedEntityRef()).thenReturn(ofResult2);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult3);
    when(instance.involvementKindIds()).thenReturn(resultLongSet);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.issuedBy()).thenReturn("Issued By");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttestationRun actualCopyOfResult = ImmutableAttestationRun.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).attestedEntityKind();
    verify(instance).attestedEntityRef();
    verify(instance).dueDate();
    verify(instance).entityReference();
    verify(instance).involvementKindIds();
    verify(instance).issuedBy();
    verify(instance).issuedOn();
    verify(instance).provenance();
    verify(instance).selectionOptions();
    verify(instance).status();
    verify(instance).targetEntityKind();
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Issued By", actualCopyOfResult.issuedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    Set<Long> involvementKindIdsResult = actualCopyOfResult.involvementKindIds();
    assertEquals(1, involvementKindIdsResult.size());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualCopyOfResult.status());
    assertTrue(involvementKindIdsResult.contains(4L));
    assertSame(ofResult4, dueDateResult);
    assertSame(ofResult3, issuedOnResult);
  }

  /**
   * Method under test: {@link ImmutableAttestationRun#copyOf(AttestationRun)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    AttestationRun instance = mock(AttestationRun.class);
    when(instance.status()).thenReturn(AttestationStatus.DRAFT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(mock(EntityReference.class));
    when(instance.attestedEntityRef()).thenReturn(ofResult2);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult3);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.issuedBy()).thenReturn(null);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttestationRun actualCopyOfResult = ImmutableAttestationRun.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).attestedEntityKind();
    verify(instance).attestedEntityRef();
    verify(instance).dueDate();
    verify(instance).entityReference();
    verify(instance).involvementKindIds();
    verify(instance).issuedBy();
    verify(instance).issuedOn();
    verify(instance).provenance();
    verify(instance).selectionOptions();
    verify(instance).status();
    verify(instance).targetEntityKind();
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.issuedBy());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.involvementKindIds().isEmpty());
    assertSame(ofResult4, dueDateResult);
    assertSame(ofResult3, issuedOnResult);
  }

  /**
   * Method under test: {@link ImmutableAttestationRun#copyOf(AttestationRun)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    AttestationRun instance = mock(AttestationRun.class);
    when(instance.status()).thenReturn(AttestationStatus.DRAFT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(mock(EntityReference.class));
    when(instance.attestedEntityRef()).thenReturn(ofResult2);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult3);
    when(instance.involvementKindIds()).thenReturn(new HashSet<>());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.issuedBy()).thenReturn("Issued By");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.description()).thenReturn(null);
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttestationRun actualCopyOfResult = ImmutableAttestationRun.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).attestedEntityKind();
    verify(instance).attestedEntityRef();
    verify(instance).dueDate();
    verify(instance).entityReference();
    verify(instance).involvementKindIds();
    verify(instance).issuedBy();
    verify(instance).issuedOn();
    verify(instance).provenance();
    verify(instance).selectionOptions();
    verify(instance).status();
    verify(instance).targetEntityKind();
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Issued By", actualCopyOfResult.issuedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.involvementKindIds().isEmpty());
    assertSame(ofResult4, dueDateResult);
    assertSame(ofResult3, issuedOnResult);
  }

  /**
   * Method under test: {@link ImmutableAttestationRun#copyOf(AttestationRun)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(31L);
    resultLongSet.add(4L);
    AttestationRun instance = mock(AttestationRun.class);
    when(instance.status()).thenReturn(AttestationStatus.DRAFT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(mock(EntityReference.class));
    when(instance.attestedEntityRef()).thenReturn(ofResult2);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.issuedOn()).thenReturn(ofResult3);
    when(instance.involvementKindIds()).thenReturn(resultLongSet);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));
    when(instance.issuedBy()).thenReturn("Issued By");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.dueDate()).thenReturn(ofResult4);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.attestedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAttestationRun actualCopyOfResult = ImmutableAttestationRun.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).attestedEntityKind();
    verify(instance).attestedEntityRef();
    verify(instance).dueDate();
    verify(instance).entityReference();
    verify(instance).involvementKindIds();
    verify(instance).issuedBy();
    verify(instance).issuedOn();
    verify(instance).provenance();
    verify(instance).selectionOptions();
    verify(instance).status();
    verify(instance).targetEntityKind();
    LocalDate dueDateResult = actualCopyOfResult.dueDate();
    assertEquals("1970-01-01", dueDateResult.toString());
    LocalDate issuedOnResult = actualCopyOfResult.issuedOn();
    assertEquals("1970-01-01", issuedOnResult.toString());
    assertEquals("Issued By", actualCopyOfResult.issuedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualCopyOfResult.status());
    assertEquals(resultLongSet, actualCopyOfResult.involvementKindIds());
    assertSame(ofResult4, dueDateResult);
    assertSame(ofResult3, issuedOnResult);
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Json#attestedEntityKind()}
   */
  @Test
  void testJsonAttestedEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRun.Json()).attestedEntityKind());
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Json#attestedEntityRef()}
   */
  @Test
  void testJsonAttestedEntityRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRun.Json()).attestedEntityRef());
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRun.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Json#dueDate()}
   */
  @Test
  void testJsonDueDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRun.Json()).dueDate());
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRun.Json()).entityReference());
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRun.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Json#involvementKindIds()}
   */
  @Test
  void testJsonInvolvementKindIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRun.Json()).involvementKindIds());
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Json#issuedBy()}
   */
  @Test
  void testJsonIssuedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRun.Json()).issuedBy());
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Json#issuedOn()}
   */
  @Test
  void testJsonIssuedOn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRun.Json()).issuedOn());
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRun.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAttestationRun.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAttestationRun.Json actualJson = new ImmutableAttestationRun.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.issuedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.dueDate);
    assertNull(actualJson.issuedOn);
    assertNull(actualJson.attestedEntityKind);
    assertNull(actualJson.targetEntityKind);
    assertNull(actualJson.entityReference);
    assertNull(actualJson.selectionOptions);
    assertNull(actualJson.status);
    assertFalse(actualJson.attestedEntityRef.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertTrue(actualJson.involvementKindIds.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRun.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Json#selectionOptions()}
   */
  @Test
  void testJsonSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRun.Json()).selectionOptions());
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Json#status()}
   */
  @Test
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRun.Json()).status());
  }

  /**
   * Method under test: {@link ImmutableAttestationRun.Json#targetEntityKind()}
   */
  @Test
  void testJsonTargetEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAttestationRun.Json()).targetEntityKind());
  }
}
