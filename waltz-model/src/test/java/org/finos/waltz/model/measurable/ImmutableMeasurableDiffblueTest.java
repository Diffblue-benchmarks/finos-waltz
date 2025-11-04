package org.finos.waltz.model.measurable;

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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.ExternalParentIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ParentIdProvider;
import org.finos.waltz.model.PositionProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMeasurable#builder()}
   *   <li>{@link ImmutableMeasurable#description(String)}
   *   <li>{@link ImmutableMeasurable#entityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link ImmutableMeasurable#externalId(String)}
   *   <li>{@link ImmutableMeasurable#externalParentId(String)}
   *   <li>{@link ImmutableMeasurable#kind(EntityKind)}
   *   <li>{@link ImmutableMeasurable#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableMeasurable#organisationalUnitId(Long)}
   *   <li>{@link ImmutableMeasurable#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableMeasurable.Builder actualExternalIdResult = ImmutableMeasurable.builder()
        .description("The characteristics of someone or something")
        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableMeasurable.Builder actualExternalParentIdResult = actualExternalIdResult.externalId(externalId)
        .externalParentId("42");
    Optional<String> externalParentId = Optional.of("foo");
    ImmutableMeasurable.Builder actualIdResult = actualExternalParentIdResult.externalParentId(externalParentId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableMeasurable.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    ImmutableMeasurable.Builder actualParentIdResult = actualKindResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .organisationalUnitId(1L)
        .parentId(1L);
    Optional<Long> parentId = Optional.<Long>of(1L);
    ImmutableMeasurable.Builder actualParentIdResult2 = actualParentIdResult.parentId(parentId);

    // Assert
    assertSame(actualParentIdResult2, actualParentIdResult2.provenance("Provenance"));
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#categoryId(long)}
   */
  @Test
  void testBuilderCategoryId() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.categoryId(1L));
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#concrete(boolean)}
   */
  @Test
  void testBuilderConcrete() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.concrete(true));
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#externalParentId(Optional)}
   */
  @Test
  void testBuilderExternalParentId() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    Optional<String> externalParentId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalParentId(externalParentId));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatus();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#from(ExternalParentIdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    ExternalParentIdProvider instance = mock(ExternalParentIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalParentId()).thenReturn(ofResult);

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalParentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#from(ExternalParentIdProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    ExternalParentIdProvider instance = mock(ExternalParentIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalParentId()).thenReturn(emptyResult);

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalParentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#from(ExternalParentIdProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    ExternalParentIdProvider instance = mock(ExternalParentIdProvider.class);
    when(instance.externalParentId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalParentId();
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom22() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    when(instance.parentId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentId();
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(PositionProvider)}
   */
  @Test
  void testBuilderFrom23() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    PositionProvider instance = mock(PositionProvider.class);
    when(instance.position()).thenReturn(1);

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).position();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(PositionProvider)}
   */
  @Test
  void testBuilderFrom24() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    PositionProvider instance = mock(PositionProvider.class);
    when(instance.position()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).position();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurable.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom25() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(Measurable)}
   */
  @Test
  void testBuilderFrom26() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    Measurable instance = mock(Measurable.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.categoryId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.concrete()).thenReturn(true);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalParentId()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult4);
    when(instance.position()).thenReturn(1);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).externalParentId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).position();
    verify(instance).provenance();
    verify(instance).categoryId();
    verify(instance).concrete();
    verify(instance).kind();
    verify(instance).organisationalUnitId();
    ImmutableMeasurable buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(1L, buildResult.categoryId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertTrue(buildResult.concrete());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(Measurable)}
   */
  @Test
  void testBuilderFrom27() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    Measurable instance = mock(Measurable.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.concrete()).thenReturn(true);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalParentId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult2);
    when(instance.position()).thenReturn(1);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).externalParentId();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).position();
    verify(instance).provenance();
    verify(instance).concrete();
    verify(instance).kind();
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(Measurable)}
   */
  @Test
  void testBuilderFrom28() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    Measurable instance = mock(Measurable.class);
    when(instance.organisationalUnitId()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.categoryId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.concrete()).thenReturn(true);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalParentId()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult4);
    when(instance.position()).thenReturn(1);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).externalParentId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).position();
    verify(instance).provenance();
    verify(instance).categoryId();
    verify(instance).concrete();
    verify(instance).kind();
    verify(instance).organisationalUnitId();
    ImmutableMeasurable buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.organisationalUnitId());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.categoryId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertTrue(buildResult.concrete());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(Measurable)}
   */
  @Test
  void testBuilderFrom29() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    Measurable instance = mock(Measurable.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.categoryId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.concrete()).thenReturn(true);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalParentId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult3);
    when(instance.position()).thenReturn(1);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).externalParentId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).position();
    verify(instance).provenance();
    verify(instance).categoryId();
    verify(instance).concrete();
    verify(instance).kind();
    verify(instance).organisationalUnitId();
    ImmutableMeasurable buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(1L, buildResult.categoryId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertTrue(buildResult.concrete());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(Measurable)}
   */
  @Test
  void testBuilderFrom30() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    Measurable instance = mock(Measurable.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.categoryId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.concrete()).thenReturn(true);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalParentId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult3);
    when(instance.position()).thenReturn(1);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).externalParentId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).position();
    verify(instance).provenance();
    verify(instance).categoryId();
    verify(instance).concrete();
    verify(instance).kind();
    verify(instance).organisationalUnitId();
    ImmutableMeasurable buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(1L, buildResult.categoryId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertTrue(buildResult.concrete());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(Measurable)}
   */
  @Test
  void testBuilderFrom31() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    Measurable instance = mock(Measurable.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.categoryId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.concrete()).thenReturn(true);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalParentId()).thenReturn(emptyResult);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult3);
    when(instance.position()).thenReturn(1);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).externalParentId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).position();
    verify(instance).provenance();
    verify(instance).categoryId();
    verify(instance).concrete();
    verify(instance).kind();
    verify(instance).organisationalUnitId();
    ImmutableMeasurable buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(1L, buildResult.categoryId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertTrue(buildResult.concrete());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(Measurable)}
   */
  @Test
  void testBuilderFrom32() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    Measurable instance = mock(Measurable.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.categoryId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.concrete()).thenReturn(true);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalParentId()).thenReturn(ofResult3);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);
    when(instance.position()).thenReturn(1);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).externalParentId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).position();
    verify(instance).provenance();
    verify(instance).categoryId();
    verify(instance).concrete();
    verify(instance).kind();
    verify(instance).organisationalUnitId();
    ImmutableMeasurable buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(1L, buildResult.categoryId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertTrue(buildResult.concrete());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#from(Measurable)}
   */
  @Test
  void testBuilderFrom33() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    Measurable instance = mock(Measurable.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.categoryId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.concrete()).thenReturn(true);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalParentId()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult4);
    when(instance.position()).thenReturn(1);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).externalParentId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).position();
    verify(instance).provenance();
    verify(instance).categoryId();
    verify(instance).concrete();
    verify(instance).kind();
    verify(instance).organisationalUnitId();
    ImmutableMeasurable buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(1L, buildResult.categoryId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertTrue(buildResult.concrete());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#parentId(long)}
   */
  @Test
  void testBuilderParentId() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(1L));
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#parentId(Optional)}
   */
  @Test
  void testBuilderParentId2() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();
    Optional<Long> parentId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(parentId));
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableMeasurable.Builder builderResult = ImmutableMeasurable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test: {@link ImmutableMeasurable#copyOf(Measurable)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Measurable instance = mock(Measurable.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.categoryId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.concrete()).thenReturn(true);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalParentId()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult5);
    when(instance.position()).thenReturn(1);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurable actualCopyOfResult = ImmutableMeasurable.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).externalParentId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).position();
    verify(instance).provenance();
    verify(instance).categoryId();
    verify(instance).concrete();
    verify(instance).kind();
    verify(instance).organisationalUnitId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(1L, actualCopyOfResult.categoryId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.concrete());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable#copyOf(Measurable)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    Measurable instance = mock(Measurable.class);
    when(instance.organisationalUnitId()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.categoryId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.concrete()).thenReturn(true);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalParentId()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult5);
    when(instance.position()).thenReturn(1);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurable actualCopyOfResult = ImmutableMeasurable.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).externalParentId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).position();
    verify(instance).provenance();
    verify(instance).categoryId();
    verify(instance).concrete();
    verify(instance).kind();
    verify(instance).organisationalUnitId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.organisationalUnitId());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.categoryId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.concrete());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable#copyOf(Measurable)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    Measurable instance = mock(Measurable.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.categoryId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.concrete()).thenReturn(true);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalParentId()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult4);
    when(instance.position()).thenReturn(1);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurable actualCopyOfResult = ImmutableMeasurable.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).externalParentId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).position();
    verify(instance).provenance();
    verify(instance).categoryId();
    verify(instance).concrete();
    verify(instance).kind();
    verify(instance).organisationalUnitId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(1L, actualCopyOfResult.categoryId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.concrete());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable#copyOf(Measurable)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    Measurable instance = mock(Measurable.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.categoryId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.concrete()).thenReturn(true);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalParentId()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult4);
    when(instance.position()).thenReturn(1);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurable actualCopyOfResult = ImmutableMeasurable.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).externalParentId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).position();
    verify(instance).provenance();
    verify(instance).categoryId();
    verify(instance).concrete();
    verify(instance).kind();
    verify(instance).organisationalUnitId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(1L, actualCopyOfResult.categoryId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.concrete());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable#copyOf(Measurable)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    Measurable instance = mock(Measurable.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.categoryId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.concrete()).thenReturn(false);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalParentId()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult5);
    when(instance.position()).thenReturn(1);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurable actualCopyOfResult = ImmutableMeasurable.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).externalParentId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).position();
    verify(instance).provenance();
    verify(instance).categoryId();
    verify(instance).concrete();
    verify(instance).kind();
    verify(instance).organisationalUnitId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(1L, actualCopyOfResult.categoryId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertFalse(actualCopyOfResult.concrete());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable#copyOf(Measurable)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    Measurable instance = mock(Measurable.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.categoryId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.concrete()).thenReturn(true);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalParentId()).thenReturn(emptyResult);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult4);
    when(instance.position()).thenReturn(1);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurable actualCopyOfResult = ImmutableMeasurable.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).externalParentId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).position();
    verify(instance).provenance();
    verify(instance).categoryId();
    verify(instance).concrete();
    verify(instance).kind();
    verify(instance).organisationalUnitId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(1L, actualCopyOfResult.categoryId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.concrete());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable#copyOf(Measurable)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    Measurable instance = mock(Measurable.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.categoryId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.concrete()).thenReturn(true);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalParentId()).thenReturn(ofResult4);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);
    when(instance.position()).thenReturn(1);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurable actualCopyOfResult = ImmutableMeasurable.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).externalParentId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).position();
    verify(instance).provenance();
    verify(instance).categoryId();
    verify(instance).concrete();
    verify(instance).kind();
    verify(instance).organisationalUnitId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(1L, actualCopyOfResult.categoryId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.concrete());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable#copyOf(Measurable)}
   */
  @Test
  void testCopyOf8() {
    // Arrange
    Measurable instance = mock(Measurable.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.categoryId()).thenReturn(1L);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.concrete()).thenReturn(true);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.externalParentId()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult5);
    when(instance.position()).thenReturn(1);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurable actualCopyOfResult = ImmutableMeasurable.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).externalParentId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).parentId();
    verify(instance).position();
    verify(instance).provenance();
    verify(instance).categoryId();
    verify(instance).concrete();
    verify(instance).kind();
    verify(instance).organisationalUnitId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(1L, actualCopyOfResult.categoryId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.concrete());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#categoryId()}
   */
  @Test
  void testJsonCategoryId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurable.Json()).categoryId());
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#concrete()}
   */
  @Test
  void testJsonConcrete() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurable.Json()).concrete());
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurable.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#entityLifecycleStatus()}
   */
  @Test
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurable.Json()).entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurable.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#externalParentId()}
   */
  @Test
  void testJsonExternalParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurable.Json()).externalParentId());
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurable.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurable.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurable.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurable.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurable.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableMeasurable.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableMeasurable.Json actualJson = new ImmutableMeasurable.Json();

    // Assert
    assertNull(actualJson.organisationalUnitId);
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityLifecycleStatus);
    assertEquals(0, actualJson.position);
    assertEquals(0L, actualJson.categoryId);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.externalParentId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.parentId.isPresent());
    assertFalse(actualJson.categoryIdIsSet);
    assertFalse(actualJson.concrete);
    assertFalse(actualJson.concreteIsSet);
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#organisationalUnitId()}
   */
  @Test
  void testJsonOrganisationalUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurable.Json()).organisationalUnitId());
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#parentId()}
   */
  @Test
  void testJsonParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurable.Json()).parentId());
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurable.Json()).position());
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurable.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#setCategoryId(long)}
   */
  @Test
  void testJsonSetCategoryId() {
    // Arrange
    ImmutableMeasurable.Json json = new ImmutableMeasurable.Json();

    // Act
    json.setCategoryId(1L);

    // Assert
    assertEquals(1L, json.categoryId);
    assertTrue(json.categoryIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#setConcrete(boolean)}
   */
  @Test
  void testJsonSetConcrete() {
    // Arrange
    ImmutableMeasurable.Json json = new ImmutableMeasurable.Json();

    // Act
    json.setConcrete(true);

    // Assert
    assertTrue(json.concrete);
    assertTrue(json.concreteIsSet);
  }

  /**
   * Method under test: {@link ImmutableMeasurable.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableMeasurable.Json json = new ImmutableMeasurable.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }
}
