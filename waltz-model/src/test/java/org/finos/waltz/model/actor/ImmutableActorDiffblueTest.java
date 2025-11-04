package org.finos.waltz.model.actor;

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
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableActorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableActor#builder()}
   *   <li>{@link ImmutableActor#description(String)}
   *   <li>{@link ImmutableActor#externalId(String)}
   *   <li>{@link ImmutableActor#kind(EntityKind)}
   *   <li>{@link ImmutableActor#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableActor#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableActor.Builder actualExternalIdResult = ImmutableActor.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableActor.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableActor.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    ImmutableActor.Builder actualLastUpdatedAtResult = actualKindResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableActor.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableActor.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableActor.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableActor.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableActor.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableActor.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableActor.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableActor.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableActor.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableActor.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(Actor)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    Actor instance = mock(Actor.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isExternal()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableActor.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).isExternal();
    verify(instance).kind();
    ImmutableActor buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isExternal());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(Actor)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    Actor instance = mock(Actor.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isExternal()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).isExternal();
    verify(instance).kind();
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(Actor)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    Actor instance = mock(Actor.class);
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isExternal()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableActor.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).isExternal();
    verify(instance).kind();
    ImmutableActor buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isExternal());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(Actor)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    Actor instance = mock(Actor.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isExternal()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableActor.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).isExternal();
    verify(instance).kind();
    ImmutableActor buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isExternal());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#from(Actor)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    Actor instance = mock(Actor.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isExternal()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableActor.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).isExternal();
    verify(instance).kind();
    ImmutableActor buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isExternal());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#isExternal(boolean)}
   */
  @Test
  void testBuilderIsExternal() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isExternal(true));
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableActor.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableActor.Builder builderResult = ImmutableActor.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableActor#copyOf(Actor)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Actor instance = mock(Actor.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isExternal()).thenReturn(true);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableActor actualCopyOfResult = ImmutableActor.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).isExternal();
    verify(instance).kind();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isExternal());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableActor#copyOf(Actor)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    Actor instance = mock(Actor.class);
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isExternal()).thenReturn(true);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableActor actualCopyOfResult = ImmutableActor.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).isExternal();
    verify(instance).kind();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isExternal());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableActor#copyOf(Actor)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    Actor instance = mock(Actor.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isExternal()).thenReturn(true);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableActor actualCopyOfResult = ImmutableActor.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).isExternal();
    verify(instance).kind();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isExternal());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableActor#copyOf(Actor)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    Actor instance = mock(Actor.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isExternal()).thenReturn(true);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableActor actualCopyOfResult = ImmutableActor.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).isExternal();
    verify(instance).kind();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isExternal());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableActor#copyOf(Actor)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    Actor instance = mock(Actor.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.name()).thenReturn("Name");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.isExternal()).thenReturn(false);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableActor actualCopyOfResult = ImmutableActor.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).isExternal();
    verify(instance).kind();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertFalse(actualCopyOfResult.isExternal());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableActor.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActor.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableActor.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActor.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableActor.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActor.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableActor.Json#isExternal()}
   */
  @Test
  void testJsonIsExternal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActor.Json()).isExternal());
  }

  /**
   * Method under test: {@link ImmutableActor.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActor.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableActor.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActor.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableActor.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActor.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableActor.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActor.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableActor.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableActor.Json actualJson = new ImmutableActor.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isExternal);
    assertFalse(actualJson.isExternalIsSet);
  }

  /**
   * Method under test: {@link ImmutableActor.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableActor.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableActor.Json#setIsExternal(boolean)}
   */
  @Test
  void testJsonSetIsExternal() {
    // Arrange
    ImmutableActor.Json json = new ImmutableActor.Json();

    // Act
    json.setIsExternal(true);

    // Assert
    assertTrue(json.isExternal);
    assertTrue(json.isExternalIsSet);
  }
}
