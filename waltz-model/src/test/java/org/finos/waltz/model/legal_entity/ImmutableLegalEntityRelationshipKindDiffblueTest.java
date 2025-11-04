package org.finos.waltz.model.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelationshipKindDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipKind#builder()}
   *   <li>{@link ImmutableLegalEntityRelationshipKind#cardinality(Cardinality)}
   *   <li>{@link ImmutableLegalEntityRelationshipKind#kind(EntityKind)}
   *   <li>{@link ImmutableLegalEntityRelationshipKind#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableLegalEntityRelationshipKind#provenance(String)}
   *   <li>{@link ImmutableLegalEntityRelationshipKind#requiredRole(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableLegalEntityRelationshipKind.Builder actualIdResult = ImmutableLegalEntityRelationshipKind.builder()
        .cardinality(Cardinality.ZERO_ONE)
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableLegalEntityRelationshipKind.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    ImmutableLegalEntityRelationshipKind.Builder actualProvenanceResult = actualKindResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .provenance("Provenance");

    // Assert
    assertSame(actualProvenanceResult, actualProvenanceResult.requiredRole("Required Role"));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#description(String)}
   */
  @Test
  void testBuilderDescription() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#externalId(String)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableLegalEntityRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableLegalEntityRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableLegalEntityRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableLegalEntityRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
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
   * {@link ImmutableLegalEntityRelationshipKind.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLegalEntityRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#from(LegalEntityRelationshipKind)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    LegalEntityRelationshipKind instance = mock(LegalEntityRelationshipKind.class);
    when(instance.requiredRole()).thenReturn("Required Role");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.externalId()).thenReturn("42");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableLegalEntityRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).requiredRole();
    verify(instance).targetKind();
    ImmutableLegalEntityRelationshipKind buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("Required Role", buildResult.requiredRole());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(Cardinality.ZERO_ONE, buildResult.cardinality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.targetKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#from(LegalEntityRelationshipKind)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    LegalEntityRelationshipKind instance = mock(LegalEntityRelationshipKind.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.externalId()).thenReturn("42");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).targetKind();
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#from(LegalEntityRelationshipKind)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    LegalEntityRelationshipKind instance = mock(LegalEntityRelationshipKind.class);
    when(instance.requiredRole()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.externalId()).thenReturn("42");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableLegalEntityRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).requiredRole();
    verify(instance).targetKind();
    ImmutableLegalEntityRelationshipKind buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.requiredRole());
    assertEquals(Cardinality.ZERO_ONE, buildResult.cardinality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.targetKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#from(LegalEntityRelationshipKind)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    LegalEntityRelationshipKind instance = mock(LegalEntityRelationshipKind.class);
    when(instance.requiredRole()).thenReturn("Required Role");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.externalId()).thenReturn("42");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableLegalEntityRelationshipKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).requiredRole();
    verify(instance).targetKind();
    ImmutableLegalEntityRelationshipKind buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("42", buildResult.externalId());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("Required Role", buildResult.requiredRole());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(Cardinality.ZERO_ONE, buildResult.cardinality());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.targetKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Builder#targetKind(EntityKind)}
   */
  @Test
  void testBuilderTargetKind() {
    // Arrange
    ImmutableLegalEntityRelationshipKind.Builder builderResult = ImmutableLegalEntityRelationshipKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind#copyOf(LegalEntityRelationshipKind)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LegalEntityRelationshipKind instance = mock(LegalEntityRelationshipKind.class);
    when(instance.requiredRole()).thenReturn("Required Role");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.externalId()).thenReturn("42");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableLegalEntityRelationshipKind actualCopyOfResult = ImmutableLegalEntityRelationshipKind.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).requiredRole();
    verify(instance).targetKind();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Required Role", actualCopyOfResult.requiredRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(Cardinality.ZERO_ONE, actualCopyOfResult.cardinality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetKind());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind#copyOf(LegalEntityRelationshipKind)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    LegalEntityRelationshipKind instance = mock(LegalEntityRelationshipKind.class);
    when(instance.requiredRole()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.externalId()).thenReturn("42");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableLegalEntityRelationshipKind actualCopyOfResult = ImmutableLegalEntityRelationshipKind.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).requiredRole();
    verify(instance).targetKind();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.requiredRole());
    assertEquals(Cardinality.ZERO_ONE, actualCopyOfResult.cardinality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetKind());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind#copyOf(LegalEntityRelationshipKind)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    LegalEntityRelationshipKind instance = mock(LegalEntityRelationshipKind.class);
    when(instance.requiredRole()).thenReturn("Required Role");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.targetKind()).thenReturn(EntityKind.ALL);
    when(instance.externalId()).thenReturn("42");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableLegalEntityRelationshipKind actualCopyOfResult = ImmutableLegalEntityRelationshipKind.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).kind();
    verify(instance).name();
    verify(instance).requiredRole();
    verify(instance).targetKind();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("Required Role", actualCopyOfResult.requiredRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(Cardinality.ZERO_ONE, actualCopyOfResult.cardinality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Json#cardinality()}
   */
  @Test
  void testJsonCardinality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationshipKind.Json()).cardinality());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationshipKind.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationshipKind.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableLegalEntityRelationshipKind.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntityRelationshipKind.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableLegalEntityRelationshipKind.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntityRelationshipKind.Json()).kind());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationshipKind.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationshipKind.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableLegalEntityRelationshipKind.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLegalEntityRelationshipKind.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableLegalEntityRelationshipKind.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableLegalEntityRelationshipKind.Json actualJson = new ImmutableLegalEntityRelationshipKind.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.externalId);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.requiredRole);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.cardinality);
    assertNull(actualJson.kind);
    assertNull(actualJson.targetKind);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationshipKind.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Json#requiredRole()}
   */
  @Test
  void testJsonRequiredRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationshipKind.Json()).requiredRole());
  }

  /**
   * Method under test:
   * {@link ImmutableLegalEntityRelationshipKind.Json#targetKind()}
   */
  @Test
  void testJsonTargetKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableLegalEntityRelationshipKind.Json()).targetKind());
  }
}
