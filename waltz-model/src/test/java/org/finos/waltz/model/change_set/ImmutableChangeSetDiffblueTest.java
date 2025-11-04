package org.finos.waltz.model.change_set;

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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableChangeSetDiffblueTest {
  /**
   * Method under test: {@link ImmutableChangeSet.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    builderResult.parentEntity(mock(EntityReference.class));
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatus();
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#from(ChangeSet)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    ChangeSet instance = mock(ChangeSet.class);
    when(instance.parentEntity()).thenThrow(new IllegalStateException("instance"));
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedDate()).thenReturn(ofResult);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).parentEntity();
    verify(instance).plannedDate();
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#from(ChangeSet)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    ChangeSet instance = mock(ChangeSet.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");
    Optional<EntityReference> ofResult3 = Optional.of(mock(EntityReference.class));
    when(instance.parentEntity()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedDate()).thenReturn(ofResult4);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).parentEntity();
    verify(instance).plannedDate();
    ImmutableChangeSet buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#from(ChangeSet)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    ChangeSet instance = mock(ChangeSet.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");
    Optional<EntityReference> ofResult2 = Optional.of(mock(EntityReference.class));
    when(instance.parentEntity()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedDate()).thenReturn(ofResult3);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).parentEntity();
    verify(instance).plannedDate();
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#from(ChangeSet)}
   */
  @Test
  void testBuilderFrom22() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    ChangeSet instance = mock(ChangeSet.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");
    Optional<EntityReference> ofResult2 = Optional.of(mock(EntityReference.class));
    when(instance.parentEntity()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedDate()).thenReturn(ofResult3);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).parentEntity();
    verify(instance).plannedDate();
    ImmutableChangeSet buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#from(ChangeSet)}
   */
  @Test
  void testBuilderFrom23() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    ChangeSet instance = mock(ChangeSet.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");
    Optional<EntityReference> ofResult3 = Optional.of(mock(EntityReference.class));
    when(instance.parentEntity()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedDate()).thenReturn(ofResult4);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).parentEntity();
    verify(instance).plannedDate();
    ImmutableChangeSet buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#from(ChangeSet)}
   */
  @Test
  void testBuilderFrom24() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    ChangeSet instance = mock(ChangeSet.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");
    Optional<EntityReference> ofResult2 = Optional.of(mock(EntityReference.class));
    when(instance.parentEntity()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedDate()).thenReturn(ofResult3);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).parentEntity();
    verify(instance).plannedDate();
    ImmutableChangeSet buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#from(ChangeSet)}
   */
  @Test
  void testBuilderFrom25() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    ChangeSet instance = mock(ChangeSet.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.parentEntity()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedDate()).thenReturn(ofResult3);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).parentEntity();
    verify(instance).plannedDate();
    ImmutableChangeSet buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#from(ChangeSet)}
   */
  @Test
  void testBuilderFrom26() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    ChangeSet instance = mock(ChangeSet.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");
    Optional<EntityReference> ofResult3 = Optional.of(mock(EntityReference.class));
    when(instance.parentEntity()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.plannedDate()).thenReturn(emptyResult);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableChangeSet.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).parentEntity();
    verify(instance).plannedDate();
    ImmutableChangeSet buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    builderResult.parentEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    builderResult.parentEntity(mock(EntityReference.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy2() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    builderResult.parentEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Builder#name(String)}
   */
  @Test
  void testBuilderName2() {
    // Arrange
    ImmutableChangeSet.Builder builderResult = ImmutableChangeSet.builder();
    builderResult.parentEntity(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableChangeSet#copyOf(ChangeSet)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ChangeSet instance = mock(ChangeSet.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");
    Optional<EntityReference> ofResult3 = Optional.of(mock(EntityReference.class));
    when(instance.parentEntity()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedDate()).thenReturn(ofResult4);
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult5.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableChangeSet actualCopyOfResult = ImmutableChangeSet.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).parentEntity();
    verify(instance).plannedDate();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertSame(ofResult5, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableChangeSet#copyOf(ChangeSet)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ChangeSet instance = mock(ChangeSet.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");
    Optional<EntityReference> ofResult2 = Optional.of(mock(EntityReference.class));
    when(instance.parentEntity()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedDate()).thenReturn(ofResult3);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableChangeSet actualCopyOfResult = ImmutableChangeSet.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).parentEntity();
    verify(instance).plannedDate();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertSame(ofResult4, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableChangeSet#copyOf(ChangeSet)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ChangeSet instance = mock(ChangeSet.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");
    Optional<EntityReference> ofResult3 = Optional.of(mock(EntityReference.class));
    when(instance.parentEntity()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedDate()).thenReturn(ofResult4);
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult5.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableChangeSet actualCopyOfResult = ImmutableChangeSet.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).parentEntity();
    verify(instance).plannedDate();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertSame(ofResult5, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableChangeSet#copyOf(ChangeSet)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ChangeSet instance = mock(ChangeSet.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");
    Optional<EntityReference> ofResult2 = Optional.of(mock(EntityReference.class));
    when(instance.parentEntity()).thenReturn(ofResult2);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedDate()).thenReturn(ofResult3);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableChangeSet actualCopyOfResult = ImmutableChangeSet.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).parentEntity();
    verify(instance).plannedDate();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertSame(ofResult4, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableChangeSet#copyOf(ChangeSet)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ChangeSet instance = mock(ChangeSet.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.parentEntity()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<LocalDateTime> ofResult3 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedDate()).thenReturn(ofResult3);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableChangeSet actualCopyOfResult = ImmutableChangeSet.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).parentEntity();
    verify(instance).plannedDate();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertSame(ofResult4, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableChangeSet#copyOf(ChangeSet)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    ChangeSet instance = mock(ChangeSet.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.name()).thenReturn("Name");
    Optional<EntityReference> ofResult3 = Optional.of(mock(EntityReference.class));
    when(instance.parentEntity()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.plannedDate()).thenReturn(emptyResult);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableChangeSet actualCopyOfResult = ImmutableChangeSet.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).parentEntity();
    verify(instance).plannedDate();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertSame(ofResult4, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet#fromJson(ImmutableChangeSet.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableChangeSet.Json json = new ImmutableChangeSet.Json();
    json.setId(null);
    json.setEntityLifecycleStatus(null);
    json.setName("lastUpdatedBy");
    json.setDescription(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setExternalId(null);
    json.setProvenance(null);
    json.setParentEntity(null);
    json.setPlannedDate(null);
    json.setKind(null);

    // Act
    ImmutableChangeSet actualFromJsonResult = ImmutableChangeSet.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("lastUpdatedBy", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.CHANGE_SET, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.entityLifecycleStatus());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet#fromJson(ImmutableChangeSet.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableChangeSet.Json json = new ImmutableChangeSet.Json();
    json.setId(null);
    json.setEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);
    json.setName("lastUpdatedBy");
    json.setDescription(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setExternalId(null);
    json.setProvenance(null);
    json.setParentEntity(null);
    json.setPlannedDate(null);
    json.setKind(null);

    // Act
    ImmutableChangeSet actualFromJsonResult = ImmutableChangeSet.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("lastUpdatedBy", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.CHANGE_SET, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.entityLifecycleStatus());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet#fromJson(ImmutableChangeSet.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ImmutableChangeSet.Json json = new ImmutableChangeSet.Json();
    json.setId(null);
    json.setEntityLifecycleStatus(null);
    json.setName("lastUpdatedBy");
    json.setDescription(null);
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setExternalId(null);
    json.setProvenance(null);
    json.setParentEntity(null);
    json.setPlannedDate(null);
    json.setKind(null);

    // Act
    ImmutableChangeSet actualFromJsonResult = ImmutableChangeSet.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("lastUpdatedBy", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.CHANGE_SET, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.entityLifecycleStatus());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet#fromJson(ImmutableChangeSet.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ImmutableChangeSet.Json json = new ImmutableChangeSet.Json();
    json.setId(null);
    json.setEntityLifecycleStatus(null);
    json.setName("lastUpdatedBy");
    json.setDescription(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setExternalId(null);
    json.setProvenance("name");
    json.setParentEntity(null);
    json.setPlannedDate(null);
    json.setKind(null);

    // Act
    ImmutableChangeSet actualFromJsonResult = ImmutableChangeSet.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("lastUpdatedBy", actualFromJsonResult.name());
    assertEquals("name", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.CHANGE_SET, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.entityLifecycleStatus());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeSet#fromJson(ImmutableChangeSet.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    ImmutableChangeSet.Json json = new ImmutableChangeSet.Json();
    json.setId(null);
    json.setEntityLifecycleStatus(null);
    json.setName("lastUpdatedBy");
    json.setDescription(null);
    json.setLastUpdatedAt(null);
    json.setLastUpdatedBy("Json");
    json.setExternalId(null);
    json.setProvenance(null);
    json.setParentEntity(null);
    json.setPlannedDate(null);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableChangeSet actualFromJsonResult = ImmutableChangeSet.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.lastUpdatedBy());
    assertEquals("lastUpdatedBy", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualFromJsonResult.entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeSet.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Json#entityLifecycleStatus()}
   */
  @Test
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeSet.Json()).entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeSet.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeSet.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeSet.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeSet.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeSet.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeSet.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableChangeSet.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableChangeSet.Json actualJson = new ImmutableChangeSet.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityLifecycleStatus);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.parentEntity.isPresent());
    assertFalse(actualJson.plannedDate.isPresent());
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Json#parentEntity()}
   */
  @Test
  void testJsonParentEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeSet.Json()).parentEntity());
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Json#plannedDate()}
   */
  @Test
  void testJsonPlannedDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeSet.Json()).plannedDate());
  }

  /**
   * Method under test: {@link ImmutableChangeSet.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeSet.Json()).provenance());
  }
}
