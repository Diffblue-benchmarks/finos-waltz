package org.finos.waltz.model.change_unit;

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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableChangeUnitDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableChangeUnit#builder()}
   *   <li>{@link ImmutableChangeUnit#description(String)}
   *   <li>{@link ImmutableChangeUnit#externalId(String)}
   *   <li>{@link ImmutableChangeUnit#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableChangeUnit#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableChangeUnit.Builder actualChangeSetIdResult = ImmutableChangeUnit.builder().changeSetId(1L);
    Optional<Long> changeSetId = Optional.<Long>of(1L);
    ImmutableChangeUnit.Builder actualExternalIdResult = actualChangeSetIdResult.changeSetId(changeSetId)
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableChangeUnit.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableChangeUnit.Builder actualIdResult2 = actualIdResult.id(id);
    ImmutableChangeUnit.Builder actualLastUpdatedAtResult = actualIdResult2
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#action(ChangeAction)}
   */
  @Test
  void testBuilderAction() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.action(ChangeAction.ACTIVATE));
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#changeSetId(long)}
   */
  @Test
  void testBuilderChangeSetId() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeSetId(1L));
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#changeSetId(Optional)}
   */
  @Test
  void testBuilderChangeSetId2() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    Optional<Long> changeSetId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.changeSetId(changeSetId));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeUnit.Builder#executionStatus(ExecutionStatus)}
   */
  @Test
  void testBuilderExecutionStatus() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.executionStatus(ExecutionStatus.PENDING));
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeUnit.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableChangeUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeUnit.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableChangeUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeUnit.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableChangeUnit.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableChangeUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeUnit.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableChangeUnit.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableChangeUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeUnit.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableChangeUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeUnit.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableChangeUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableChangeUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableChangeUnit.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableChangeUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeUnit.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeUnit.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableChangeUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#from(ChangeUnit)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    ChangeUnit instance = mock(ChangeUnit.class);
    when(instance.subjectEntity()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).subjectEntity();
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#from(ChangeUnit)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    ChangeUnit instance = mock(ChangeUnit.class);
    when(instance.subjectEntity()).thenThrow(new IllegalStateException("instance"));
    when(instance.description()).thenReturn(null);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).subjectEntity();
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#from(ChangeUnit)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    ChangeUnit instance = mock(ChangeUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.changeSetId()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(ChangeAction.ACTIVATE);
    when(instance.provenance()).thenReturn("Provenance");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.subjectInitialStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.executionStatus()).thenReturn(ExecutionStatus.PENDING);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.subjectEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).action();
    verify(instance).changeSetId();
    verify(instance).executionStatus();
    verify(instance).subjectEntity();
    verify(instance).subjectInitialStatus();
    ImmutableChangeUnit buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, buildResult.action());
    assertEquals(ExecutionStatus.PENDING, buildResult.executionStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#from(ChangeUnit)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    ChangeUnit instance = mock(ChangeUnit.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.action()).thenReturn(ChangeAction.ACTIVATE);
    when(instance.provenance()).thenReturn("Provenance");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.subjectInitialStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.executionStatus()).thenReturn(ExecutionStatus.PENDING);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.subjectEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).kind();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).action();
    verify(instance).executionStatus();
    verify(instance).subjectEntity();
    verify(instance).subjectInitialStatus();
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#from(ChangeUnit)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    ChangeUnit instance = mock(ChangeUnit.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.changeSetId()).thenReturn(ofResult);
    when(instance.action()).thenReturn(ChangeAction.ACTIVATE);
    when(instance.provenance()).thenReturn("Provenance");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.subjectInitialStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.executionStatus()).thenReturn(ExecutionStatus.PENDING);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.subjectEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).action();
    verify(instance).changeSetId();
    verify(instance).executionStatus();
    verify(instance).subjectEntity();
    verify(instance).subjectInitialStatus();
    ImmutableChangeUnit buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, buildResult.action());
    assertEquals(ExecutionStatus.PENDING, buildResult.executionStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#from(ChangeUnit)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    ChangeUnit instance = mock(ChangeUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.changeSetId()).thenReturn(emptyResult);
    when(instance.action()).thenReturn(ChangeAction.ACTIVATE);
    when(instance.provenance()).thenReturn("Provenance");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.subjectInitialStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.executionStatus()).thenReturn(ExecutionStatus.PENDING);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.subjectEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).action();
    verify(instance).changeSetId();
    verify(instance).executionStatus();
    verify(instance).subjectEntity();
    verify(instance).subjectInitialStatus();
    ImmutableChangeUnit buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, buildResult.action());
    assertEquals(ExecutionStatus.PENDING, buildResult.executionStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#from(ChangeUnit)}
   */
  @Test
  void testBuilderFrom22() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    ChangeUnit instance = mock(ChangeUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.changeSetId()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(ChangeAction.ACTIVATE);
    when(instance.provenance()).thenReturn("Provenance");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.subjectInitialStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.executionStatus()).thenReturn(ExecutionStatus.PENDING);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.subjectEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeUnit.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).action();
    verify(instance).changeSetId();
    verify(instance).executionStatus();
    verify(instance).subjectEntity();
    verify(instance).subjectInitialStatus();
    ImmutableChangeUnit buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, buildResult.action());
    assertEquals(ExecutionStatus.PENDING, buildResult.executionStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#kind(EntityKind)}
   */
  @Test
  void testBuilderKind() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeUnit.Builder#subjectEntity(EntityReference)}
   */
  @Test
  void testBuilderSubjectEntity() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectEntity(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeUnit.Builder#subjectInitialStatus(EntityLifecycleStatus)}
   */
  @Test
  void testBuilderSubjectInitialStatus() {
    // Arrange
    ImmutableChangeUnit.Builder builderResult = ImmutableChangeUnit.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectInitialStatus(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Method under test: {@link ImmutableChangeUnit#copyOf(ChangeUnit)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ChangeUnit instance = mock(ChangeUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.changeSetId()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(ChangeAction.ACTIVATE);
    when(instance.provenance()).thenReturn("Provenance");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.subjectInitialStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.executionStatus()).thenReturn(ExecutionStatus.PENDING);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.subjectEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeUnit actualCopyOfResult = ImmutableChangeUnit.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).action();
    verify(instance).changeSetId();
    verify(instance).executionStatus();
    verify(instance).subjectEntity();
    verify(instance).subjectInitialStatus();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, actualCopyOfResult.action());
    assertEquals(ExecutionStatus.PENDING, actualCopyOfResult.executionStatus());
    assertSame(ofResult4, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableChangeUnit#copyOf(ChangeUnit)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ChangeUnit instance = mock(ChangeUnit.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.changeSetId()).thenReturn(ofResult);
    when(instance.action()).thenReturn(ChangeAction.ACTIVATE);
    when(instance.provenance()).thenReturn("Provenance");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.subjectInitialStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.executionStatus()).thenReturn(ExecutionStatus.PENDING);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.subjectEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeUnit actualCopyOfResult = ImmutableChangeUnit.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).action();
    verify(instance).changeSetId();
    verify(instance).executionStatus();
    verify(instance).subjectEntity();
    verify(instance).subjectInitialStatus();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, actualCopyOfResult.action());
    assertEquals(ExecutionStatus.PENDING, actualCopyOfResult.executionStatus());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableChangeUnit#copyOf(ChangeUnit)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ChangeUnit instance = mock(ChangeUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.changeSetId()).thenReturn(emptyResult);
    when(instance.action()).thenReturn(ChangeAction.ACTIVATE);
    when(instance.provenance()).thenReturn("Provenance");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.subjectInitialStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.executionStatus()).thenReturn(ExecutionStatus.PENDING);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.subjectEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeUnit actualCopyOfResult = ImmutableChangeUnit.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).action();
    verify(instance).changeSetId();
    verify(instance).executionStatus();
    verify(instance).subjectEntity();
    verify(instance).subjectInitialStatus();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, actualCopyOfResult.action());
    assertEquals(ExecutionStatus.PENDING, actualCopyOfResult.executionStatus());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableChangeUnit#copyOf(ChangeUnit)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ChangeUnit instance = mock(ChangeUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.changeSetId()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(ChangeAction.ACTIVATE);
    when(instance.provenance()).thenReturn("Provenance");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.subjectInitialStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.executionStatus()).thenReturn(ExecutionStatus.PENDING);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.subjectEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeUnit actualCopyOfResult = ImmutableChangeUnit.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).action();
    verify(instance).changeSetId();
    verify(instance).executionStatus();
    verify(instance).subjectEntity();
    verify(instance).subjectInitialStatus();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, actualCopyOfResult.action());
    assertEquals(ExecutionStatus.PENDING, actualCopyOfResult.executionStatus());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableChangeUnit#copyOf(ChangeUnit)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ChangeUnit instance = mock(ChangeUnit.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.changeSetId()).thenReturn(ofResult2);
    when(instance.action()).thenReturn(ChangeAction.ACTIVATE);
    when(instance.provenance()).thenReturn("Provenance");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.subjectInitialStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);
    when(instance.executionStatus()).thenReturn(ExecutionStatus.PENDING);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.subjectEntity()).thenReturn(mock(EntityReference.class));
    when(instance.description()).thenReturn(null);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeUnit actualCopyOfResult = ImmutableChangeUnit.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).kind();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).action();
    verify(instance).changeSetId();
    verify(instance).executionStatus();
    verify(instance).subjectEntity();
    verify(instance).subjectInitialStatus();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.subjectInitialStatus());
    assertEquals(ChangeAction.ACTIVATE, actualCopyOfResult.action());
    assertEquals(ExecutionStatus.PENDING, actualCopyOfResult.executionStatus());
    assertSame(ofResult4, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Json#action()}
   */
  @Test
  void testJsonAction() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeUnit.Json()).action());
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Json#changeSetId()}
   */
  @Test
  void testJsonChangeSetId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeUnit.Json()).changeSetId());
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeUnit.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Json#executionStatus()}
   */
  @Test
  void testJsonExecutionStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeUnit.Json()).executionStatus());
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeUnit.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeUnit.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeUnit.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeUnit.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeUnit.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeUnit.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableChangeUnit.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableChangeUnit.Json actualJson = new ImmutableChangeUnit.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.subjectInitialStatus);
    assertNull(actualJson.subjectEntity);
    assertNull(actualJson.action);
    assertNull(actualJson.executionStatus);
    assertFalse(actualJson.changeSetId.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeUnit.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Json#subjectEntity()}
   */
  @Test
  void testJsonSubjectEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeUnit.Json()).subjectEntity());
  }

  /**
   * Method under test: {@link ImmutableChangeUnit.Json#subjectInitialStatus()}
   */
  @Test
  void testJsonSubjectInitialStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeUnit.Json()).subjectInitialStatus());
  }
}
