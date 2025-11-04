package org.finos.waltz.model.legal_entity;

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
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IsReadOnlyProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelationshipDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationship#builder()}
   *   <li>{@link ImmutableLegalEntityRelationship#description(String)}
   *   <li>{@link ImmutableLegalEntityRelationship#externalId(String)}
   *   <li>{@link ImmutableLegalEntityRelationship#kind(EntityKind)}
   *   <li>{@link ImmutableLegalEntityRelationship#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableLegalEntityRelationship#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableLegalEntityRelationship.Builder actualExternalIdResult = ImmutableLegalEntityRelationship.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableLegalEntityRelationship.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableLegalEntityRelationship.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    ImmutableLegalEntityRelationship.Builder actualLastUpdatedAtResult = actualKindResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableLegalEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableLegalEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableLegalEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableLegalEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableLegalEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableLegalEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableLegalEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(IsReadOnlyProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    IsReadOnlyProvider instance = mock(IsReadOnlyProvider.class);
    when(instance.isReadOnly()).thenReturn(true);

    // Act
    ImmutableLegalEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isReadOnly();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableLegalEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLegalEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(LegalEntityRelationship)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    LegalEntityRelationship instance = mock(LegalEntityRelationship.class);
    when(instance.legalEntityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.relationshipKindId()).thenReturn(1L);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).legalEntityReference();
    verify(instance).relationshipKindId();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(LegalEntityRelationship)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    LegalEntityRelationship instance = mock(LegalEntityRelationship.class);
    when(instance.legalEntityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.relationshipKindId()).thenReturn(1L);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).legalEntityReference();
    verify(instance).relationshipKindId();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(LegalEntityRelationship)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    LegalEntityRelationship instance = mock(LegalEntityRelationship.class);
    when(instance.targetEntityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.legalEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.relationshipKindId()).thenReturn(1L);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).legalEntityReference();
    verify(instance).relationshipKindId();
    verify(instance).targetEntityReference();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(LegalEntityRelationship)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    LegalEntityRelationship instance = mock(LegalEntityRelationship.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.targetEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.legalEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.relationshipKindId()).thenReturn(1L);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLegalEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).legalEntityReference();
    verify(instance).relationshipKindId();
    verify(instance).targetEntityReference();
    ImmutableLegalEntityRelationship buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.relationshipKindId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(LegalEntityRelationship)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    LegalEntityRelationship instance = mock(LegalEntityRelationship.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.targetEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.legalEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.relationshipKindId()).thenReturn(1L);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLegalEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).legalEntityReference();
    verify(instance).relationshipKindId();
    verify(instance).targetEntityReference();
    ImmutableLegalEntityRelationship buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.relationshipKindId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(LegalEntityRelationship)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    LegalEntityRelationship instance = mock(LegalEntityRelationship.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.targetEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.legalEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.relationshipKindId()).thenReturn(1L);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLegalEntityRelationship.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).legalEntityReference();
    verify(instance).relationshipKindId();
    verify(instance).targetEntityReference();
    ImmutableLegalEntityRelationship buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.relationshipKindId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#from(LegalEntityRelationship)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    LegalEntityRelationship instance = mock(LegalEntityRelationship.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.targetEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.legalEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.relationshipKindId()).thenReturn(1L);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).legalEntityReference();
    verify(instance).relationshipKindId();
    verify(instance).targetEntityReference();
  }

  /**
   * Method under test: {@link ImmutableLegalEntityRelationship.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#legalEntityReference(EntityReference)}
   */
  @Test
  void testBuilderLegalEntityReference() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.legalEntityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#relationshipKindId(Long)}
   */
  @Test
  void testBuilderRelationshipKindId() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.relationshipKindId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Builder#targetEntityReference(EntityReference)}
   */
  @Test
  void testBuilderTargetEntityReference() {
    // Arrange
    ImmutableLegalEntityRelationship.Builder builderResult = ImmutableLegalEntityRelationship.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetEntityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship#copyOf(LegalEntityRelationship)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LegalEntityRelationship instance = mock(LegalEntityRelationship.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.targetEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.legalEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.relationshipKindId()).thenReturn(1L);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLegalEntityRelationship actualCopyOfResult = ImmutableLegalEntityRelationship.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).legalEntityReference();
    verify(instance).relationshipKindId();
    verify(instance).targetEntityReference();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.relationshipKindId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship#copyOf(LegalEntityRelationship)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    LegalEntityRelationship instance = mock(LegalEntityRelationship.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.targetEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.legalEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.relationshipKindId()).thenReturn(1L);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLegalEntityRelationship actualCopyOfResult = ImmutableLegalEntityRelationship.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).legalEntityReference();
    verify(instance).relationshipKindId();
    verify(instance).targetEntityReference();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.relationshipKindId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship#copyOf(LegalEntityRelationship)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    LegalEntityRelationship instance = mock(LegalEntityRelationship.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.targetEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.legalEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.relationshipKindId()).thenReturn(1L);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLegalEntityRelationship actualCopyOfResult = ImmutableLegalEntityRelationship.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).legalEntityReference();
    verify(instance).relationshipKindId();
    verify(instance).targetEntityReference();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.relationshipKindId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship#copyOf(LegalEntityRelationship)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    LegalEntityRelationship instance = mock(LegalEntityRelationship.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.targetEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.legalEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.relationshipKindId()).thenReturn(1L);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(false);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLegalEntityRelationship actualCopyOfResult = ImmutableLegalEntityRelationship.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).legalEntityReference();
    verify(instance).relationshipKindId();
    verify(instance).targetEntityReference();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.relationshipKindId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertFalse(actualCopyOfResult.isReadOnly());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship#copyOf(LegalEntityRelationship)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    LegalEntityRelationship instance = mock(LegalEntityRelationship.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.targetEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.legalEntityReference()).thenReturn(mock(EntityReference.class));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.relationshipKindId()).thenReturn(1L);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLegalEntityRelationship actualCopyOfResult = ImmutableLegalEntityRelationship.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).legalEntityReference();
    verify(instance).relationshipKindId();
    verify(instance).targetEntityReference();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.relationshipKindId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationship.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableLegalEntityRelationship.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntityRelationship.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableLegalEntityRelationship.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntityRelationship.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableLegalEntityRelationship.Json#isReadOnly()}
   */
  @Test
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntityRelationship.Json()).isReadOnly());
  }

  /**
   * Method under test: {@link ImmutableLegalEntityRelationship.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntityRelationship.Json()).kind());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationship.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationship.Json()).lastUpdatedBy());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Json#legalEntityReference()}
   */
  @Test
  void testJsonLegalEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationship.Json()).legalEntityReference());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableLegalEntityRelationship.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableLegalEntityRelationship.Json actualJson = new ImmutableLegalEntityRelationship.Json();

    // Assert
    assertNull(actualJson.relationshipKindId);
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.legalEntityReference);
    assertNull(actualJson.targetEntityReference);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
  }

  /**
   * Method under test: {@link ImmutableLegalEntityRelationship.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntityRelationship.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Json#relationshipKindId()}
   */
  @Test
  void testJsonRelationshipKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationship.Json()).relationshipKindId());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly() {
    // Arrange
    ImmutableLegalEntityRelationship.Json json = new ImmutableLegalEntityRelationship.Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly2() {
    // Arrange
    ImmutableLegalEntityRelationship.Json json = new ImmutableLegalEntityRelationship.Json();
    json.setLegalEntityReference(mock(EntityReference.class));

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationship.Json#targetEntityReference()}
   */
  @Test
  void testJsonTargetEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationship.Json()).targetEntityReference());
  }
}
