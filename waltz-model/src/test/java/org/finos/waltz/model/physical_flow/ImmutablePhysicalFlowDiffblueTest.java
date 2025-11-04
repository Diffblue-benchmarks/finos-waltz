package org.finos.waltz.model.physical_flow;

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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityLifecycleStatusProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.FreshnessIndicator;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IsRemovedProvider;
import org.finos.waltz.model.LastAttestedProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.UserTimestamp;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowDiffblueTest {
  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#basisOffset(int)}
   */
  @Test
  void testBuilderBasisOffset() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.basisOffset(1));
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#basisOffset(int)}
   */
  @Test
  void testBuilderBasisOffset2() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.basisOffset(1));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#criticality(CriticalityValue)}
   */
  @Test
  void testBuilderCriticality() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.criticality(CriticalityValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#criticality(CriticalityValue)}
   */
  @Test
  void testBuilderCriticality2() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.criticality(CriticalityValue.of("42")));
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#frequency(FrequencyKindValue)}
   */
  @Test
  void testBuilderFrequency() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.frequency(FrequencyKindValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#frequency(FrequencyKindValue)}
   */
  @Test
  void testBuilderFrequency2() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.frequency(FrequencyKindValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    when(instance.created()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityLifecycleStatus();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    EntityLifecycleStatusProvider instance = mock(EntityLifecycleStatusProvider.class);
    when(instance.entityLifecycleStatus()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityLifecycleStatus();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(IsRemovedProvider)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    IsRemovedProvider instance = mock(IsRemovedProvider.class);
    when(instance.isRemoved()).thenReturn(true);

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isRemoved();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(LastAttestedProvider)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    LastAttestedProvider instance = mock(LastAttestedProvider.class);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult2);

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(LastAttestedProvider)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    LastAttestedProvider instance = mock(LastAttestedProvider.class);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.lastAttestedAt()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult);

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(LastAttestedProvider)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    LastAttestedProvider instance = mock(LastAttestedProvider.class);
    Optional<LocalDateTime> ofResult = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.lastAttestedBy()).thenReturn(emptyResult);

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(LastAttestedProvider)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    LastAttestedProvider instance = mock(LastAttestedProvider.class);
    when(instance.lastAttestedBy()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastAttestedBy();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom22() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
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
   * {@link ImmutablePhysicalFlow.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom23() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#from(PhysicalFlow)}
   */
  @Test
  void testBuilderFrom24() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.specificationId()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult2 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult3);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).specificationId();
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#from(PhysicalFlow)}
   */
  @Test
  void testBuilderFrom25() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult5);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult6 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult6);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult7);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult8 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult8);
    Optional<String> ofResult9 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult9);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.basisOffset());
    assertEquals(1L, buildResult.logicalFlowId());
    assertEquals(1L, buildResult.specificationId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, buildResult.freshnessIndicator());
    assertTrue(buildResult.isReadOnly());
    assertTrue(buildResult.isRemoved());
    assertSame(ofResult6, buildResult.criticality());
    assertSame(ofResult2, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult3, buildResult.transport());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#from(PhysicalFlow)}
   */
  @Test
  void testBuilderFrom26() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenThrow(new IllegalStateException("instance"));
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    when(instance.frequency()).thenReturn(FrequencyKindValue.of("42"));
    when(instance.transport()).thenReturn(TransportKindValue.of("42"));
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult2);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    when(instance.criticality()).thenReturn(CriticalityValue.of("42"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult4 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult5);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#from(PhysicalFlow)}
   */
  @Test
  void testBuilderFrom27() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult5);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult6 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult6);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult7);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult8 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult8);
    Optional<String> ofResult9 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult9);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.name());
    assertEquals(1, buildResult.basisOffset());
    assertEquals(1L, buildResult.logicalFlowId());
    assertEquals(1L, buildResult.specificationId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, buildResult.freshnessIndicator());
    assertTrue(buildResult.isReadOnly());
    assertTrue(buildResult.isRemoved());
    assertSame(ofResult6, buildResult.criticality());
    assertSame(ofResult2, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult3, buildResult.transport());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#from(PhysicalFlow)}
   */
  @Test
  void testBuilderFrom28() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult4);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult5 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult5);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult6);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult7 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult7);
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult8);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.basisOffset());
    assertEquals(1L, buildResult.logicalFlowId());
    assertEquals(1L, buildResult.specificationId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, buildResult.freshnessIndicator());
    assertTrue(buildResult.isReadOnly());
    assertTrue(buildResult.isRemoved());
    assertSame(ofResult5, buildResult.criticality());
    assertSame(ofResult, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.transport());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#from(PhysicalFlow)}
   */
  @Test
  void testBuilderFrom29() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult4);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult5 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult5);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult6);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult7 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult7);
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult8);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.basisOffset());
    assertEquals(1L, buildResult.logicalFlowId());
    assertEquals(1L, buildResult.specificationId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, buildResult.freshnessIndicator());
    assertTrue(buildResult.isReadOnly());
    assertTrue(buildResult.isRemoved());
    assertSame(ofResult5, buildResult.criticality());
    assertSame(ofResult2, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult3, buildResult.transport());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#from(PhysicalFlow)}
   */
  @Test
  void testBuilderFrom30() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.specificationDefinitionId()).thenReturn(emptyResult);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult5 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult5);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult6 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult6);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult7 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult7);
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult8);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.basisOffset());
    assertEquals(1L, buildResult.logicalFlowId());
    assertEquals(1L, buildResult.specificationId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, buildResult.freshnessIndicator());
    assertTrue(buildResult.isReadOnly());
    assertTrue(buildResult.isRemoved());
    assertSame(ofResult5, buildResult.criticality());
    assertSame(ofResult2, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult3, buildResult.transport());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#from(PhysicalFlow)}
   */
  @Test
  void testBuilderFrom31() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult5);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult6 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult6);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult7 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult7);
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult8);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.basisOffset());
    assertEquals(1L, buildResult.logicalFlowId());
    assertEquals(1L, buildResult.specificationId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, buildResult.freshnessIndicator());
    assertTrue(buildResult.isReadOnly());
    assertTrue(buildResult.isRemoved());
    assertSame(ofResult6, buildResult.criticality());
    assertSame(ofResult2, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult3, buildResult.transport());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#from(PhysicalFlow)}
   */
  @Test
  void testBuilderFrom32() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult5);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult6 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult6);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult7);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.lastAttestedAt()).thenReturn(emptyResult);
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult8);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.basisOffset());
    assertEquals(1L, buildResult.logicalFlowId());
    assertEquals(1L, buildResult.specificationId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, buildResult.freshnessIndicator());
    assertTrue(buildResult.isReadOnly());
    assertTrue(buildResult.isRemoved());
    assertSame(ofResult6, buildResult.criticality());
    assertSame(ofResult2, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult3, buildResult.transport());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#from(PhysicalFlow)}
   */
  @Test
  void testBuilderFrom33() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult5);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult6 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult6);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult7);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult8 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult8);
    Optional<String> emptyResult = Optional.empty();
    when(instance.lastAttestedBy()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.basisOffset());
    assertEquals(1L, buildResult.logicalFlowId());
    assertEquals(1L, buildResult.specificationId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, buildResult.freshnessIndicator());
    assertTrue(buildResult.isReadOnly());
    assertTrue(buildResult.isRemoved());
    assertSame(ofResult6, buildResult.criticality());
    assertSame(ofResult2, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult3, buildResult.transport());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#from(PhysicalFlow)}
   */
  @Test
  void testBuilderFrom34() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult5);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult6 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult6);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult7);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult8 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult8);
    Optional<String> ofResult9 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult9);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    ImmutablePhysicalFlow buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.basisOffset());
    assertEquals(1L, buildResult.logicalFlowId());
    assertEquals(1L, buildResult.specificationId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, buildResult.freshnessIndicator());
    assertTrue(buildResult.isReadOnly());
    assertTrue(buildResult.isRemoved());
    assertSame(ofResult6, buildResult.criticality());
    assertSame(ofResult2, buildResult.frequency());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult3, buildResult.transport());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly2() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#isRemoved(boolean)}
   */
  @Test
  void testBuilderIsRemoved() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRemoved(true));
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#isRemoved(boolean)}
   */
  @Test
  void testBuilderIsRemoved2() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.isRemoved(true));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#lastAttestedBy(Optional)}
   */
  @Test
  void testBuilderLastAttestedBy() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    Optional<String> lastAttestedBy = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.lastAttestedBy(lastAttestedBy));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#lastAttestedBy(Optional)}
   */
  @Test
  void testBuilderLastAttestedBy2() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<String> lastAttestedBy = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.lastAttestedBy(lastAttestedBy));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy2() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#logicalFlowId(long)}
   */
  @Test
  void testBuilderLogicalFlowId() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlowId(1L));
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Builder#logicalFlowId(long)}
   */
  @Test
  void testBuilderLogicalFlowId2() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.logicalFlowId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#specificationDefinitionId(long)}
   */
  @Test
  void testBuilderSpecificationDefinitionId() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.specificationDefinitionId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#specificationDefinitionId(long)}
   */
  @Test
  void testBuilderSpecificationDefinitionId2() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.specificationDefinitionId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#specificationDefinitionId(Optional)}
   */
  @Test
  void testBuilderSpecificationDefinitionId3() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    Optional<Long> specificationDefinitionId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.specificationDefinitionId(specificationDefinitionId));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#specificationDefinitionId(Optional)}
   */
  @Test
  void testBuilderSpecificationDefinitionId4() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<Long> specificationDefinitionId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.specificationDefinitionId(specificationDefinitionId));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#specificationId(long)}
   */
  @Test
  void testBuilderSpecificationId() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.specificationId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Builder#specificationId(long)}
   */
  @Test
  void testBuilderSpecificationId2() {
    // Arrange
    ImmutablePhysicalFlow.Builder builderResult = ImmutablePhysicalFlow.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.specificationId(1L));
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow#copyOf(PhysicalFlow)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult5);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult6 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult6);
    LocalDate ofResult7 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult7.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult8);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult9 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult9);
    Optional<String> ofResult10 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult10);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow actualCopyOfResult = ImmutablePhysicalFlow.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.basisOffset());
    assertEquals(1L, actualCopyOfResult.logicalFlowId());
    assertEquals(1L, actualCopyOfResult.specificationId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualCopyOfResult.freshnessIndicator());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult7, toLocalDateResult);
    assertSame(ofResult6, criticalityResult);
    assertSame(ofResult2, frequencyResult);
    assertSame(ofResult3, transportResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow#copyOf(PhysicalFlow)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn(null);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult5);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult6 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult6);
    LocalDate ofResult7 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult7.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult8);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult9 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult9);
    Optional<String> ofResult10 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult10);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow actualCopyOfResult = ImmutablePhysicalFlow.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.name());
    assertEquals(1, actualCopyOfResult.basisOffset());
    assertEquals(1L, actualCopyOfResult.logicalFlowId());
    assertEquals(1L, actualCopyOfResult.specificationId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualCopyOfResult.freshnessIndicator());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult7, toLocalDateResult);
    assertSame(ofResult6, criticalityResult);
    assertSame(ofResult2, frequencyResult);
    assertSame(ofResult3, transportResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow#copyOf(PhysicalFlow)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult);
    TransportKindValue ofResult2 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult2);
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult4);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult5 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult5);
    LocalDate ofResult6 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult6.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult7);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult8 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult8);
    Optional<String> ofResult9 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult9);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow actualCopyOfResult = ImmutablePhysicalFlow.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.basisOffset());
    assertEquals(1L, actualCopyOfResult.logicalFlowId());
    assertEquals(1L, actualCopyOfResult.specificationId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualCopyOfResult.freshnessIndicator());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult6, toLocalDateResult);
    assertSame(ofResult5, criticalityResult);
    assertSame(ofResult, frequencyResult);
    assertSame(ofResult2, transportResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow#copyOf(PhysicalFlow)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(false);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult5);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult6 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult6);
    LocalDate ofResult7 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult7.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult8);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult9 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult9);
    Optional<String> ofResult10 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult10);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow actualCopyOfResult = ImmutablePhysicalFlow.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.basisOffset());
    assertEquals(1L, actualCopyOfResult.logicalFlowId());
    assertEquals(1L, actualCopyOfResult.specificationId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualCopyOfResult.freshnessIndicator());
    assertFalse(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult7, toLocalDateResult);
    assertSame(ofResult6, criticalityResult);
    assertSame(ofResult2, frequencyResult);
    assertSame(ofResult3, transportResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow#copyOf(PhysicalFlow)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult4);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult5 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult5);
    LocalDate ofResult6 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult6.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult7);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult8 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult8);
    Optional<String> ofResult9 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult9);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow actualCopyOfResult = ImmutablePhysicalFlow.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.basisOffset());
    assertEquals(1L, actualCopyOfResult.logicalFlowId());
    assertEquals(1L, actualCopyOfResult.specificationId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualCopyOfResult.freshnessIndicator());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult6, toLocalDateResult);
    assertSame(ofResult5, criticalityResult);
    assertSame(ofResult2, frequencyResult);
    assertSame(ofResult3, transportResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow#copyOf(PhysicalFlow)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.specificationDefinitionId()).thenReturn(emptyResult);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult5 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult5);
    LocalDate ofResult6 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult6.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult7 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult7);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult8 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult8);
    Optional<String> ofResult9 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult9);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow actualCopyOfResult = ImmutablePhysicalFlow.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.basisOffset());
    assertEquals(1L, actualCopyOfResult.logicalFlowId());
    assertEquals(1L, actualCopyOfResult.specificationId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualCopyOfResult.freshnessIndicator());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult6, toLocalDateResult);
    assertSame(ofResult5, criticalityResult);
    assertSame(ofResult2, frequencyResult);
    assertSame(ofResult3, transportResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow#copyOf(PhysicalFlow)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult5);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult6 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult6);
    LocalDate ofResult7 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult7.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult8 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult8);
    Optional<String> ofResult9 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult9);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow actualCopyOfResult = ImmutablePhysicalFlow.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.basisOffset());
    assertEquals(1L, actualCopyOfResult.logicalFlowId());
    assertEquals(1L, actualCopyOfResult.specificationId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualCopyOfResult.freshnessIndicator());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult7, toLocalDateResult);
    assertSame(ofResult6, criticalityResult);
    assertSame(ofResult2, frequencyResult);
    assertSame(ofResult3, transportResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow#copyOf(PhysicalFlow)}
   */
  @Test
  void testCopyOf8() {
    // Arrange
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult5);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult6 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult6);
    LocalDate ofResult7 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult7.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult8);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> emptyResult = Optional.empty();
    when(instance.lastAttestedAt()).thenReturn(emptyResult);
    Optional<String> ofResult9 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult9);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow actualCopyOfResult = ImmutablePhysicalFlow.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.basisOffset());
    assertEquals(1L, actualCopyOfResult.logicalFlowId());
    assertEquals(1L, actualCopyOfResult.specificationId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualCopyOfResult.freshnessIndicator());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult7, toLocalDateResult);
    assertSame(ofResult6, criticalityResult);
    assertSame(ofResult2, frequencyResult);
    assertSame(ofResult3, transportResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow#copyOf(PhysicalFlow)}
   */
  @Test
  void testCopyOf9() {
    // Arrange
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult5);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult6 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult6);
    LocalDate ofResult7 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult7.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult8);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult9 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult9);
    Optional<String> emptyResult = Optional.empty();
    when(instance.lastAttestedBy()).thenReturn(emptyResult);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow actualCopyOfResult = ImmutablePhysicalFlow.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.basisOffset());
    assertEquals(1L, actualCopyOfResult.logicalFlowId());
    assertEquals(1L, actualCopyOfResult.specificationId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualCopyOfResult.freshnessIndicator());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult7, toLocalDateResult);
    assertSame(ofResult6, criticalityResult);
    assertSame(ofResult2, frequencyResult);
    assertSame(ofResult3, transportResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow#copyOf(PhysicalFlow)}
   */
  @Test
  void testCopyOf10() {
    // Arrange
    PhysicalFlow instance = mock(PhysicalFlow.class);
    when(instance.basisOffset()).thenReturn(1);
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.freshnessIndicator()).thenReturn(FreshnessIndicator.NEVER_OBSERVED);
    FrequencyKindValue ofResult2 = FrequencyKindValue.of("42");
    when(instance.frequency()).thenReturn(ofResult2);
    TransportKindValue ofResult3 = TransportKindValue.of("42");
    when(instance.transport()).thenReturn(ofResult3);
    Optional<UserTimestamp> ofResult4 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult4);
    Optional<Long> ofResult5 = Optional.<Long>of(1L);
    when(instance.specificationDefinitionId()).thenReturn(ofResult5);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.specificationId()).thenReturn(1L);
    CriticalityValue ofResult6 = CriticalityValue.of("42");
    when(instance.criticality()).thenReturn(ofResult6);
    LocalDate ofResult7 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult7.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult8 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult8);
    when(instance.isRemoved()).thenReturn(true);
    Optional<LocalDateTime> ofResult9 = Optional.of(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastAttestedAt()).thenReturn(ofResult9);
    Optional<String> ofResult10 = Optional.of("foo");
    when(instance.lastAttestedBy()).thenReturn(ofResult10);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.entityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalFlow actualCopyOfResult = ImmutablePhysicalFlow.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).entityLifecycleStatus();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isRemoved();
    verify(instance).lastAttestedAt();
    verify(instance).lastAttestedBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).basisOffset();
    verify(instance).criticality();
    verify(instance).frequency();
    verify(instance).freshnessIndicator();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).logicalFlowId();
    verify(instance).name();
    verify(instance).specificationDefinitionId();
    verify(instance).specificationId();
    verify(instance).transport();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    CriticalityValue criticalityResult = actualCopyOfResult.criticality();
    assertEquals("42", criticalityResult.value());
    FrequencyKindValue frequencyResult = actualCopyOfResult.frequency();
    assertEquals("42", frequencyResult.value());
    TransportKindValue transportResult = actualCopyOfResult.transport();
    assertEquals("42", transportResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.basisOffset());
    assertEquals(1L, actualCopyOfResult.logicalFlowId());
    assertEquals(1L, actualCopyOfResult.specificationId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualCopyOfResult.freshnessIndicator());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult7, toLocalDateResult);
    assertSame(ofResult6, criticalityResult);
    assertSame(ofResult2, frequencyResult);
    assertSame(ofResult3, transportResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#basisOffset()}
   */
  @Test
  void testJsonBasisOffset() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).basisOffset());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#created()}
   */
  @Test
  void testJsonCreated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).created());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#criticality()}
   */
  @Test
  void testJsonCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).criticality());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).description());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#entityLifecycleStatus()}
   */
  @Test
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).entityLifecycleStatus());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#frequency()}
   */
  @Test
  void testJsonFrequency() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).frequency());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#freshnessIndicator()}
   */
  @Test
  void testJsonFreshnessIndicator() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).freshnessIndicator());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).id());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#isReadOnly()}
   */
  @Test
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).isReadOnly());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#isRemoved()}
   */
  @Test
  void testJsonIsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).isRemoved());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#lastAttestedAt()}
   */
  @Test
  void testJsonLastAttestedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).lastAttestedAt());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#lastAttestedBy()}
   */
  @Test
  void testJsonLastAttestedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).lastAttestedBy());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#logicalFlowId()}
   */
  @Test
  void testJsonLogicalFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).logicalFlowId());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalFlow.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalFlow.Json actualJson = new ImmutablePhysicalFlow.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.entityLifecycleStatus);
    assertNull(actualJson.freshnessIndicator);
    assertNull(actualJson.criticality);
    assertNull(actualJson.frequency);
    assertNull(actualJson.transport);
    assertEquals(0, actualJson.basisOffset);
    assertEquals(0L, actualJson.logicalFlowId);
    assertEquals(0L, actualJson.specificationId);
    assertFalse(actualJson.created.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.lastAttestedAt.isPresent());
    assertFalse(actualJson.lastAttestedBy.isPresent());
    assertFalse(actualJson.specificationDefinitionId.isPresent());
    assertFalse(actualJson.basisOffsetIsSet);
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
    assertFalse(actualJson.isRemoved);
    assertFalse(actualJson.isRemovedIsSet);
    assertFalse(actualJson.logicalFlowIdIsSet);
    assertFalse(actualJson.specificationIdIsSet);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#setBasisOffset(int)}
   */
  @Test
  void testJsonSetBasisOffset() {
    // Arrange
    ImmutablePhysicalFlow.Json json = new ImmutablePhysicalFlow.Json();

    // Act
    json.setBasisOffset(1);

    // Assert
    assertEquals(1, json.basisOffset);
    assertTrue(json.basisOffsetIsSet);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#setBasisOffset(int)}
   */
  @Test
  void testJsonSetBasisOffset2() {
    // Arrange
    ImmutablePhysicalFlow.Json json = new ImmutablePhysicalFlow.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    json.setCreated(created);

    // Act
    json.setBasisOffset(1);

    // Assert
    assertEquals(1, json.basisOffset);
    assertTrue(json.basisOffsetIsSet);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly() {
    // Arrange
    ImmutablePhysicalFlow.Json json = new ImmutablePhysicalFlow.Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly2() {
    // Arrange
    ImmutablePhysicalFlow.Json json = new ImmutablePhysicalFlow.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    json.setCreated(created);

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#setIsRemoved(boolean)}
   */
  @Test
  void testJsonSetIsRemoved() {
    // Arrange
    ImmutablePhysicalFlow.Json json = new ImmutablePhysicalFlow.Json();

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#setIsRemoved(boolean)}
   */
  @Test
  void testJsonSetIsRemoved2() {
    // Arrange
    ImmutablePhysicalFlow.Json json = new ImmutablePhysicalFlow.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    json.setCreated(created);

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#setLogicalFlowId(long)}
   */
  @Test
  void testJsonSetLogicalFlowId() {
    // Arrange
    ImmutablePhysicalFlow.Json json = new ImmutablePhysicalFlow.Json();

    // Act
    json.setLogicalFlowId(1L);

    // Assert
    assertEquals(1L, json.logicalFlowId);
    assertTrue(json.logicalFlowIdIsSet);
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#setLogicalFlowId(long)}
   */
  @Test
  void testJsonSetLogicalFlowId2() {
    // Arrange
    ImmutablePhysicalFlow.Json json = new ImmutablePhysicalFlow.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    json.setCreated(created);

    // Act
    json.setLogicalFlowId(1L);

    // Assert
    assertEquals(1L, json.logicalFlowId);
    assertTrue(json.logicalFlowIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Json#setSpecificationId(long)}
   */
  @Test
  void testJsonSetSpecificationId() {
    // Arrange
    ImmutablePhysicalFlow.Json json = new ImmutablePhysicalFlow.Json();

    // Act
    json.setSpecificationId(1L);

    // Assert
    assertEquals(1L, json.specificationId);
    assertTrue(json.specificationIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Json#setSpecificationId(long)}
   */
  @Test
  void testJsonSetSpecificationId2() {
    // Arrange
    ImmutablePhysicalFlow.Json json = new ImmutablePhysicalFlow.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    json.setCreated(created);

    // Act
    json.setSpecificationId(1L);

    // Assert
    assertEquals(1L, json.specificationId);
    assertTrue(json.specificationIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalFlow.Json#specificationDefinitionId()}
   */
  @Test
  void testJsonSpecificationDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalFlow.Json()).specificationDefinitionId());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#specificationId()}
   */
  @Test
  void testJsonSpecificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).specificationId());
  }

  /**
   * Method under test: {@link ImmutablePhysicalFlow.Json#transport()}
   */
  @Test
  void testJsonTransport() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalFlow.Json()).transport());
  }
}
