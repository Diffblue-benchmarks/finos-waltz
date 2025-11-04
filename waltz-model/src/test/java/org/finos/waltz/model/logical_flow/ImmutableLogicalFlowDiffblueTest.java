package org.finos.waltz.model.logical_flow;

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
import org.finos.waltz.model.CreatedUserTimestampProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IsReadOnlyProvider;
import org.finos.waltz.model.IsRemovedProvider;
import org.finos.waltz.model.LastAttestedProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.UserTimestamp;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowDiffblueTest {
  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    when(instance.created()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatus();
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(IsReadOnlyProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    IsReadOnlyProvider instance = mock(IsReadOnlyProvider.class);
    when(instance.isReadOnly()).thenReturn(true);

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isReadOnly();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(IsRemovedProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    IsRemovedProvider instance = mock(IsRemovedProvider.class);
    when(instance.isRemoved()).thenReturn(true);

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isRemoved();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(LastAttestedProvider)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    LastAttestedProvider instance = mock(LastAttestedProvider.class);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult2);

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(LastAttestedProvider)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    LastAttestedProvider instance = mock(LastAttestedProvider.class);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.lastAttestedAt()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult);

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(LastAttestedProvider)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    LastAttestedProvider instance = mock(LastAttestedProvider.class);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.lastAttestedBy()).thenReturn(emptyResult);

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(LastAttestedProvider)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    LastAttestedProvider instance = mock(LastAttestedProvider.class);
    when(instance.lastAttestedBy()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastAttestedBy();
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
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
   * {@link ImmutableLogicalFlow.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom22() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#from(LogicalFlow)}
   */
  @Test
  void testBuilderFrom23() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    LogicalFlow instance = mock(LogicalFlow.class);
    when(instance.created()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
    verify(instance).entityLifecycleStatus();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#from(LogicalFlow)}
   */
  @Test
  void testBuilderFrom24() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    LogicalFlow instance = mock(LogicalFlow.class);
    when(instance.lastAttestedBy()).thenThrow(new IllegalStateException("instance"));
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
    verify(instance).entityLifecycleStatus();
    verify(instance).isReadOnly();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#from(LogicalFlow)}
   */
  @Test
  void testBuilderFrom25() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    LogicalFlow instance = mock(LogicalFlow.class);
    when(instance.target()).thenThrow(new IllegalStateException("instance"));
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult2);
    when(instance.source()).thenReturn(mock(EntityReference.class));
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).source();
    verify(instance).target();
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#from(LogicalFlow)}
   */
  @Test
  void testBuilderFrom26() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    LogicalFlow instance = mock(LogicalFlow.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult2);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult4);
    when(instance.source()).thenReturn(mock(EntityReference.class));
    Optional<UserTimestamp> ofResult5 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult5);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).source();
    verify(instance).target();
    ImmutableLogicalFlow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertTrue(buildResult.isReadOnly());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#from(LogicalFlow)}
   */
  @Test
  void testBuilderFrom27() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    LogicalFlow instance = mock(LogicalFlow.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult3);
    when(instance.source()).thenReturn(mock(EntityReference.class));
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).source();
    verify(instance).target();
    ImmutableLogicalFlow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertTrue(buildResult.isReadOnly());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#from(LogicalFlow)}
   */
  @Test
  void testBuilderFrom28() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    LogicalFlow instance = mock(LogicalFlow.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.lastAttestedAt()).thenReturn(emptyResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult3);
    when(instance.source()).thenReturn(mock(EntityReference.class));
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLogicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).source();
    verify(instance).target();
    ImmutableLogicalFlow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertTrue(buildResult.isReadOnly());
    assertTrue(buildResult.isRemoved());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly2() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#isRemoved(boolean)}
   */
  @Test
  void testBuilderIsRemoved() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRemoved(true));
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#isRemoved(boolean)}
   */
  @Test
  void testBuilderIsRemoved2() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.isRemoved(true));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#lastAttestedBy(Optional)}
   */
  @Test
  void testBuilderLastAttestedBy() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    Optional<String> lastAttestedBy = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.lastAttestedBy(lastAttestedBy));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#lastAttestedBy(Optional)}
   */
  @Test
  void testBuilderLastAttestedBy2() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<String> lastAttestedBy = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.lastAttestedBy(lastAttestedBy));
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy2() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#source(EntityReference)}
   */
  @Test
  void testBuilderSource() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.source(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlow.Builder#target(EntityReference)}
   */
  @Test
  void testBuilderTarget() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.target(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow#copyOf(LogicalFlow)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LogicalFlow instance = mock(LogicalFlow.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult2);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult4);
    when(instance.source()).thenReturn(mock(EntityReference.class));
    Optional<UserTimestamp> ofResult5 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult5);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult6 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult6.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLogicalFlow actualCopyOfResult = ImmutableLogicalFlow.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).source();
    verify(instance).target();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult6, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow#copyOf(LogicalFlow)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    LogicalFlow instance = mock(LogicalFlow.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult3);
    when(instance.source()).thenReturn(mock(EntityReference.class));
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult5.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLogicalFlow actualCopyOfResult = ImmutableLogicalFlow.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).source();
    verify(instance).target();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult5, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow#copyOf(LogicalFlow)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    LogicalFlow instance = mock(LogicalFlow.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.lastAttestedAt()).thenReturn(emptyResult);
    when(instance.isRemoved()).thenReturn(true);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult3);
    when(instance.source()).thenReturn(mock(EntityReference.class));
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult5.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLogicalFlow actualCopyOfResult = ImmutableLogicalFlow.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).source();
    verify(instance).target();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult5, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow#copyOf(LogicalFlow)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    LogicalFlow instance = mock(LogicalFlow.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult2);
    when(instance.isRemoved()).thenReturn(false);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult4);
    when(instance.source()).thenReturn(mock(EntityReference.class));
    Optional<UserTimestamp> ofResult5 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult5);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult6 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult6.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableLogicalFlow actualCopyOfResult = ImmutableLogicalFlow.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).source();
    verify(instance).target();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertFalse(actualCopyOfResult.isRemoved());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult6, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#created()}
   */
  @Test
  void testJsonCreated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlow.Json()).created());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#entityLifecycleStatus()}
   */
  @Test
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlow.Json()).entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlow.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlow.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#isReadOnly()}
   */
  @Test
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlow.Json()).isReadOnly());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#isRemoved()}
   */
  @Test
  void testJsonIsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlow.Json()).isRemoved());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlow.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#lastAttestedAt()}
   */
  @Test
  void testJsonLastAttestedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlow.Json()).lastAttestedAt());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#lastAttestedBy()}
   */
  @Test
  void testJsonLastAttestedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlow.Json()).lastAttestedBy());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlow.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlow.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableLogicalFlow.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableLogicalFlow.Json actualJson = new ImmutableLogicalFlow.Json();

    // Assert
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityLifecycleStatus);
    assertNull(actualJson.source);
    assertNull(actualJson.target);
    assertFalse(actualJson.created.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.lastAttestedAt.isPresent());
    assertFalse(actualJson.lastAttestedBy.isPresent());
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
    assertFalse(actualJson.isRemoved);
    assertFalse(actualJson.isRemovedIsSet);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlow.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly() {
    // Arrange
    ImmutableLogicalFlow.Json json = new ImmutableLogicalFlow.Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly2() {
    // Arrange
    ImmutableLogicalFlow.Json json = new ImmutableLogicalFlow.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    json.setCreated(created);

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#setIsRemoved(boolean)}
   */
  @Test
  void testJsonSetIsRemoved() {
    // Arrange
    ImmutableLogicalFlow.Json json = new ImmutableLogicalFlow.Json();

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#setIsRemoved(boolean)}
   */
  @Test
  void testJsonSetIsRemoved2() {
    // Arrange
    ImmutableLogicalFlow.Json json = new ImmutableLogicalFlow.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    json.setCreated(created);

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#source()}
   */
  @Test
  void testJsonSource() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlow.Json()).source());
  }

  /**
   * Method under test: {@link ImmutableLogicalFlow.Json#target()}
   */
  @Test
  void testJsonTarget() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLogicalFlow.Json()).target());
  }
}
