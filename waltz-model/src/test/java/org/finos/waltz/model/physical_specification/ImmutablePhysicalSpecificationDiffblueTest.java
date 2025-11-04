package org.finos.waltz.model.physical_specification;

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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IsReadOnlyProvider;
import org.finos.waltz.model.IsRemovedProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.UserTimestamp;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecificationDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#format(DataFormatKindValue)}
   */
  @Test
  void testBuilderFormat() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.format(DataFormatKindValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#format(DataFormatKindValue)}
   */
  @Test
  void testBuilderFormat2() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.format(DataFormatKindValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    when(instance.created()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(IsReadOnlyProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    IsReadOnlyProvider instance = mock(IsReadOnlyProvider.class);
    when(instance.isReadOnly()).thenReturn(true);

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isReadOnly();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(IsRemovedProvider)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    IsRemovedProvider instance = mock(IsRemovedProvider.class);
    when(instance.isRemoved()).thenReturn(true);

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isRemoved();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
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
   * {@link ImmutablePhysicalSpecification.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(PhysicalSpecification)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    PhysicalSpecification instance = mock(PhysicalSpecification.class);
    when(instance.owningEntity()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).owningEntity();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(PhysicalSpecification)}
   */
  @Test
  void testBuilderFrom22() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    PhysicalSpecification instance = mock(PhysicalSpecification.class);
    when(instance.owningEntity()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).owningEntity();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(PhysicalSpecification)}
   */
  @Test
  void testBuilderFrom23() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    PhysicalSpecification instance = mock(PhysicalSpecification.class);
    when(instance.created()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.owningEntity()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
    verify(instance).description();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).kind();
    verify(instance).owningEntity();
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(PhysicalSpecification)}
   */
  @Test
  void testBuilderFrom24() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    PhysicalSpecification instance = mock(PhysicalSpecification.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult3);
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.owningEntity()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).format();
    verify(instance).kind();
    verify(instance).owningEntity();
    ImmutablePhysicalSpecification buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isReadOnly());
    assertTrue(buildResult.isRemoved());
    assertSame(ofResult4, buildResult.format());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(PhysicalSpecification)}
   */
  @Test
  void testBuilderFrom25() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    PhysicalSpecification instance = mock(PhysicalSpecification.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<UserTimestamp> ofResult2 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult2);
    DataFormatKindValue ofResult3 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult3);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.owningEntity()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).format();
    verify(instance).kind();
    verify(instance).owningEntity();
    ImmutablePhysicalSpecification buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isReadOnly());
    assertTrue(buildResult.isRemoved());
    assertSame(ofResult3, buildResult.format());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(PhysicalSpecification)}
   */
  @Test
  void testBuilderFrom26() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    PhysicalSpecification instance = mock(PhysicalSpecification.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<UserTimestamp> ofResult2 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult2);
    DataFormatKindValue ofResult3 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult3);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.owningEntity()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).format();
    verify(instance).kind();
    verify(instance).owningEntity();
    ImmutablePhysicalSpecification buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isReadOnly());
    assertTrue(buildResult.isRemoved());
    assertSame(ofResult3, buildResult.format());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(PhysicalSpecification)}
   */
  @Test
  void testBuilderFrom27() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    PhysicalSpecification instance = mock(PhysicalSpecification.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);
    DataFormatKindValue ofResult3 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult3);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.owningEntity()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecification.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).format();
    verify(instance).kind();
    verify(instance).owningEntity();
    ImmutablePhysicalSpecification buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.isReadOnly());
    assertTrue(buildResult.isRemoved());
    assertSame(ofResult3, buildResult.format());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#from(PhysicalSpecification)}
   */
  @Test
  void testBuilderFrom28() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    PhysicalSpecification instance = mock(PhysicalSpecification.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));
    Optional<UserTimestamp> ofResult = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult);
    when(instance.format()).thenReturn(DataFormatKindValue.of("42"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.owningEntity()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).format();
    verify(instance).kind();
    verify(instance).owningEntity();
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecification.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecification.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    builderResult.created(mock(UserTimestamp.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly2() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#isRemoved(boolean)}
   */
  @Test
  void testBuilderIsRemoved() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRemoved(true));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#isRemoved(boolean)}
   */
  @Test
  void testBuilderIsRemoved2() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.isRemoved(true));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy2() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#name(String)}
   */
  @Test
  void testBuilderName2() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    builderResult.created(mock(UserTimestamp.class));

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Builder#owningEntity(EntityReference)}
   */
  @Test
  void testBuilderOwningEntity() {
    // Arrange
    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.owningEntity(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification#copyOf(PhysicalSpecification)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    PhysicalSpecification instance = mock(PhysicalSpecification.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult3);
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult5.atStartOfDay());
    when(instance.owningEntity()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecification actualCopyOfResult = ImmutablePhysicalSpecification.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).format();
    verify(instance).kind();
    verify(instance).owningEntity();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    DataFormatKindValue formatResult = actualCopyOfResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult5, toLocalDateResult);
    assertSame(ofResult4, formatResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification#copyOf(PhysicalSpecification)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    PhysicalSpecification instance = mock(PhysicalSpecification.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<UserTimestamp> ofResult2 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult2);
    DataFormatKindValue ofResult3 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult3);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.owningEntity()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecification actualCopyOfResult = ImmutablePhysicalSpecification.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).format();
    verify(instance).kind();
    verify(instance).owningEntity();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    DataFormatKindValue formatResult = actualCopyOfResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult3, formatResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification#copyOf(PhysicalSpecification)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    PhysicalSpecification instance = mock(PhysicalSpecification.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<UserTimestamp> ofResult2 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult2);
    DataFormatKindValue ofResult3 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult3);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.owningEntity()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecification actualCopyOfResult = ImmutablePhysicalSpecification.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).format();
    verify(instance).kind();
    verify(instance).owningEntity();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    DataFormatKindValue formatResult = actualCopyOfResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult3, formatResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification#copyOf(PhysicalSpecification)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    PhysicalSpecification instance = mock(PhysicalSpecification.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);
    DataFormatKindValue ofResult3 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult3);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.owningEntity()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecification actualCopyOfResult = ImmutablePhysicalSpecification.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).format();
    verify(instance).kind();
    verify(instance).owningEntity();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    DataFormatKindValue formatResult = actualCopyOfResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult3, formatResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification#copyOf(PhysicalSpecification)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    PhysicalSpecification instance = mock(PhysicalSpecification.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult3);
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult5.atStartOfDay());
    when(instance.owningEntity()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isRemoved()).thenReturn(false);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecification actualCopyOfResult = ImmutablePhysicalSpecification.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).format();
    verify(instance).kind();
    verify(instance).owningEntity();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    DataFormatKindValue formatResult = actualCopyOfResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertFalse(actualCopyOfResult.isRemoved());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult5, toLocalDateResult);
    assertSame(ofResult4, formatResult);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification#copyOf(PhysicalSpecification)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    PhysicalSpecification instance = mock(PhysicalSpecification.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    Optional<UserTimestamp> ofResult3 = Optional.of(mock(UserTimestamp.class));
    when(instance.created()).thenReturn(ofResult3);
    DataFormatKindValue ofResult4 = DataFormatKindValue.of("42");
    when(instance.format()).thenReturn(ofResult4);
    LocalDate ofResult5 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult5.atStartOfDay());
    when(instance.owningEntity()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isRemoved()).thenReturn(true);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutablePhysicalSpecification actualCopyOfResult = ImmutablePhysicalSpecification.copyOf(instance);

    // Assert
    verify(instance).created();
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).isReadOnly();
    verify(instance).isRemoved();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).format();
    verify(instance).kind();
    verify(instance).owningEntity();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    DataFormatKindValue formatResult = actualCopyOfResult.format();
    assertEquals("42", formatResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertTrue(actualCopyOfResult.isRemoved());
    assertSame(ofResult5, toLocalDateResult);
    assertSame(ofResult4, formatResult);
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecification.Json#created()}
   */
  @Test
  void testJsonCreated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecification.Json()).created());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecification.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecification.Json()).description());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecification.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecification.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecification.Json#format()}
   */
  @Test
  void testJsonFormat() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecification.Json()).format());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecification.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecification.Json()).id());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecification.Json#isReadOnly()}
   */
  @Test
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecification.Json()).isReadOnly());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecification.Json#isRemoved()}
   */
  @Test
  void testJsonIsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecification.Json()).isRemoved());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecification.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecification.Json()).kind());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecification.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutablePhysicalSpecification.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecification.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecification.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutablePhysicalSpecification.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutablePhysicalSpecification.Json actualJson = new ImmutablePhysicalSpecification.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.owningEntity);
    assertNull(actualJson.format);
    assertFalse(actualJson.created.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
    assertFalse(actualJson.isRemoved);
    assertFalse(actualJson.isRemovedIsSet);
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecification.Json#owningEntity()}
   */
  @Test
  void testJsonOwningEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecification.Json()).owningEntity());
  }

  /**
   * Method under test: {@link ImmutablePhysicalSpecification.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutablePhysicalSpecification.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly() {
    // Arrange
    ImmutablePhysicalSpecification.Json json = new ImmutablePhysicalSpecification.Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly2() {
    // Arrange
    ImmutablePhysicalSpecification.Json json = new ImmutablePhysicalSpecification.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    json.setCreated(created);

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Json#setIsRemoved(boolean)}
   */
  @Test
  void testJsonSetIsRemoved() {
    // Arrange
    ImmutablePhysicalSpecification.Json json = new ImmutablePhysicalSpecification.Json();

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutablePhysicalSpecification.Json#setIsRemoved(boolean)}
   */
  @Test
  void testJsonSetIsRemoved2() {
    // Arrange
    ImmutablePhysicalSpecification.Json json = new ImmutablePhysicalSpecification.Json();
    Optional<UserTimestamp> created = Optional.of(mock(UserTimestamp.class));
    json.setCreated(created);

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }
}
