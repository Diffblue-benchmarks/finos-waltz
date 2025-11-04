package org.finos.waltz.model.flow_classification_rule;

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
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationRuleDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRule#builder()}
   *   <li>{@link ImmutableFlowClassificationRule#dataTypeId(Long)}
   *   <li>{@link ImmutableFlowClassificationRule#description(String)}
   *   <li>{@link ImmutableFlowClassificationRule#externalId(String)}
   *   <li>{@link ImmutableFlowClassificationRule#kind(EntityKind)}
   *   <li>{@link ImmutableFlowClassificationRule#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableFlowClassificationRule#message(String)}
   *   <li>{@link ImmutableFlowClassificationRule#messageSeverity(MessageSeverity)}
   *   <li>{@link ImmutableFlowClassificationRule#provenance(String)}
   *   <li>
   * {@link ImmutableFlowClassificationRule#subjectOrgUnitReference(EntityReference)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableFlowClassificationRule.Builder actualExternalIdResult = ImmutableFlowClassificationRule.builder()
        .dataTypeId(1L)
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableFlowClassificationRule.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableFlowClassificationRule.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    ImmutableFlowClassificationRule.Builder actualProvenanceResult = actualKindResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .message("Not all who wander are lost")
        .messageSeverity(MessageSeverity.NONE)
        .provenance("Provenance");

    // Assert
    assertSame(actualProvenanceResult, actualProvenanceResult.subjectOrgUnitReference(null));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#classificationId(Long)}
   */
  @Test
  void testBuilderClassificationId() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.classificationId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#classificationId(Long)}
   */
  @Test
  void testBuilderClassificationId2() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    builderResult.subjectOrgUnitReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.classificationId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    builderResult.subjectOrgUnitReference(mock(EntityReference.class));
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableFlowClassificationRule.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableFlowClassificationRule.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableFlowClassificationRule.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableFlowClassificationRule.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableFlowClassificationRule.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableFlowClassificationRule.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableFlowClassificationRule.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableFlowClassificationRule.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
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
   * {@link ImmutableFlowClassificationRule.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableFlowClassificationRule.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#from(FlowClassificationRule)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    FlowClassificationRule instance = mock(FlowClassificationRule.class);
    when(instance.dataTypeId()).thenThrow(new IllegalStateException("instance"));
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.isReadonly()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).dataTypeId();
    verify(instance).isReadonly();
    verify(instance).kind();
    verify(instance).messageSeverity();
    verify(instance).provenance();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#from(FlowClassificationRule)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    FlowClassificationRule instance = mock(FlowClassificationRule.class);
    when(instance.dataTypeId()).thenThrow(new IllegalStateException("instance"));
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.isReadonly()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).dataTypeId();
    verify(instance).isReadonly();
    verify(instance).kind();
    verify(instance).messageSeverity();
    verify(instance).provenance();
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#from(FlowClassificationRule)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    FlowClassificationRule instance = mock(FlowClassificationRule.class);
    when(instance.classificationId()).thenThrow(new IllegalStateException("instance"));
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.message()).thenReturn("Not all who wander are lost");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.subjectReference()).thenReturn(mock(EntityReference.class));
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.isReadonly()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).classificationId();
    verify(instance).dataTypeId();
    verify(instance).isReadonly();
    verify(instance).kind();
    verify(instance).message();
    verify(instance).messageSeverity();
    verify(instance).provenance();
    verify(instance).subjectReference();
  }

  /**
   * Method under test: {@link ImmutableFlowClassificationRule.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableFlowClassificationRule.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    builderResult.subjectOrgUnitReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    builderResult.subjectOrgUnitReference(mock(EntityReference.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#isReadonly(boolean)}
   */
  @Test
  void testBuilderIsReadonly() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadonly(true));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#isReadonly(boolean)}
   */
  @Test
  void testBuilderIsReadonly2() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    builderResult.subjectOrgUnitReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.isReadonly(true));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy2() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();
    builderResult.subjectOrgUnitReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#subjectReference(EntityReference)}
   */
  @Test
  void testBuilderSubjectReference() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Builder#vantagePointReference(EntityReference)}
   */
  @Test
  void testBuilderVantagePointReference() {
    // Arrange
    ImmutableFlowClassificationRule.Builder builderResult = ImmutableFlowClassificationRule.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.vantagePointReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule#copyOf(FlowClassificationRule)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FlowClassificationRule instance = mock(FlowClassificationRule.class);
    when(instance.classificationId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectOrgUnitReference()).thenReturn(null);
    when(instance.vantagePointReference()).thenReturn(mock(EntityReference.class));
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.message()).thenReturn("Not all who wander are lost");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.subjectReference()).thenReturn(mock(EntityReference.class));
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.isReadonly()).thenReturn(true);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableFlowClassificationRule actualCopyOfResult = ImmutableFlowClassificationRule.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).classificationId();
    verify(instance).dataTypeId();
    verify(instance).isReadonly();
    verify(instance).kind();
    verify(instance).message();
    verify(instance).messageSeverity();
    verify(instance).provenance();
    verify(instance).subjectOrgUnitReference();
    verify(instance).subjectReference();
    verify(instance).vantagePointReference();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.subjectOrgUnitReference());
    assertEquals(1L, actualCopyOfResult.classificationId().longValue());
    assertEquals(1L, actualCopyOfResult.dataTypeId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.messageSeverity());
    assertTrue(actualCopyOfResult.isReadonly());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule#copyOf(FlowClassificationRule)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    FlowClassificationRule instance = mock(FlowClassificationRule.class);
    when(instance.classificationId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectOrgUnitReference()).thenReturn(null);
    when(instance.vantagePointReference()).thenReturn(mock(EntityReference.class));
    when(instance.dataTypeId()).thenReturn(null);
    when(instance.message()).thenReturn("Not all who wander are lost");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.subjectReference()).thenReturn(mock(EntityReference.class));
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.isReadonly()).thenReturn(true);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableFlowClassificationRule actualCopyOfResult = ImmutableFlowClassificationRule.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).classificationId();
    verify(instance).dataTypeId();
    verify(instance).isReadonly();
    verify(instance).kind();
    verify(instance).message();
    verify(instance).messageSeverity();
    verify(instance).provenance();
    verify(instance).subjectOrgUnitReference();
    verify(instance).subjectReference();
    verify(instance).vantagePointReference();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.dataTypeId());
    assertNull(actualCopyOfResult.subjectOrgUnitReference());
    assertEquals(1L, actualCopyOfResult.classificationId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.messageSeverity());
    assertTrue(actualCopyOfResult.isReadonly());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule#copyOf(FlowClassificationRule)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    FlowClassificationRule instance = mock(FlowClassificationRule.class);
    when(instance.classificationId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectOrgUnitReference()).thenReturn(null);
    when(instance.vantagePointReference()).thenReturn(mock(EntityReference.class));
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.message()).thenReturn(null);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.subjectReference()).thenReturn(mock(EntityReference.class));
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.isReadonly()).thenReturn(true);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableFlowClassificationRule actualCopyOfResult = ImmutableFlowClassificationRule.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).classificationId();
    verify(instance).dataTypeId();
    verify(instance).isReadonly();
    verify(instance).kind();
    verify(instance).message();
    verify(instance).messageSeverity();
    verify(instance).provenance();
    verify(instance).subjectOrgUnitReference();
    verify(instance).subjectReference();
    verify(instance).vantagePointReference();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.message());
    assertNull(actualCopyOfResult.subjectOrgUnitReference());
    assertEquals(1L, actualCopyOfResult.classificationId().longValue());
    assertEquals(1L, actualCopyOfResult.dataTypeId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.messageSeverity());
    assertTrue(actualCopyOfResult.isReadonly());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule#copyOf(FlowClassificationRule)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    FlowClassificationRule instance = mock(FlowClassificationRule.class);
    when(instance.classificationId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectOrgUnitReference()).thenReturn(null);
    when(instance.vantagePointReference()).thenReturn(mock(EntityReference.class));
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.message()).thenReturn("Not all who wander are lost");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.subjectReference()).thenReturn(mock(EntityReference.class));
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.isReadonly()).thenReturn(false);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableFlowClassificationRule actualCopyOfResult = ImmutableFlowClassificationRule.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).classificationId();
    verify(instance).dataTypeId();
    verify(instance).isReadonly();
    verify(instance).kind();
    verify(instance).message();
    verify(instance).messageSeverity();
    verify(instance).provenance();
    verify(instance).subjectOrgUnitReference();
    verify(instance).subjectReference();
    verify(instance).vantagePointReference();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.subjectOrgUnitReference());
    assertEquals(1L, actualCopyOfResult.classificationId().longValue());
    assertEquals(1L, actualCopyOfResult.dataTypeId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.messageSeverity());
    assertFalse(actualCopyOfResult.isReadonly());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule#copyOf(FlowClassificationRule)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    FlowClassificationRule instance = mock(FlowClassificationRule.class);
    when(instance.classificationId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectOrgUnitReference()).thenReturn(null);
    when(instance.vantagePointReference()).thenReturn(mock(EntityReference.class));
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.message()).thenReturn("Not all who wander are lost");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.subjectReference()).thenReturn(mock(EntityReference.class));
    when(instance.messageSeverity()).thenReturn(MessageSeverity.NONE);
    when(instance.isReadonly()).thenReturn(true);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableFlowClassificationRule actualCopyOfResult = ImmutableFlowClassificationRule.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).classificationId();
    verify(instance).dataTypeId();
    verify(instance).isReadonly();
    verify(instance).kind();
    verify(instance).message();
    verify(instance).messageSeverity();
    verify(instance).provenance();
    verify(instance).subjectOrgUnitReference();
    verify(instance).subjectReference();
    verify(instance).vantagePointReference();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertNull(actualCopyOfResult.subjectOrgUnitReference());
    assertEquals(1L, actualCopyOfResult.classificationId().longValue());
    assertEquals(1L, actualCopyOfResult.dataTypeId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.messageSeverity());
    assertTrue(actualCopyOfResult.isReadonly());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Json#classificationId()}
   */
  @Test
  void testJsonClassificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRule.Json()).classificationId());
  }

  /**
   * Method under test: {@link ImmutableFlowClassificationRule.Json#dataTypeId()}
   */
  @Test
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassificationRule.Json()).dataTypeId());
  }

  /**
   * Method under test: {@link ImmutableFlowClassificationRule.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassificationRule.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableFlowClassificationRule.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassificationRule.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableFlowClassificationRule.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassificationRule.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableFlowClassificationRule.Json#isReadonly()}
   */
  @Test
  void testJsonIsReadonly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassificationRule.Json()).isReadonly());
  }

  /**
   * Method under test: {@link ImmutableFlowClassificationRule.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassificationRule.Json()).kind());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRule.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRule.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableFlowClassificationRule.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassificationRule.Json()).message());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Json#messageSeverity()}
   */
  @Test
  void testJsonMessageSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRule.Json()).messageSeverity());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableFlowClassificationRule.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableFlowClassificationRule.Json actualJson = new ImmutableFlowClassificationRule.Json();

    // Assert
    assertNull(actualJson.classificationId);
    assertNull(actualJson.dataTypeId);
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.message);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.subjectOrgUnitReference);
    assertNull(actualJson.subjectReference);
    assertNull(actualJson.vantagePointReference);
    assertNull(actualJson.messageSeverity);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isReadonly);
    assertFalse(actualJson.isReadonlyIsSet);
  }

  /**
   * Method under test: {@link ImmutableFlowClassificationRule.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableFlowClassificationRule.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Json#setIsReadonly(boolean)}
   */
  @Test
  void testJsonSetIsReadonly() {
    // Arrange
    ImmutableFlowClassificationRule.Json json = new ImmutableFlowClassificationRule.Json();

    // Act
    json.setIsReadonly(true);

    // Assert
    assertTrue(json.isReadonly);
    assertTrue(json.isReadonlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Json#setIsReadonly(boolean)}
   */
  @Test
  void testJsonSetIsReadonly2() {
    // Arrange
    ImmutableFlowClassificationRule.Json json = new ImmutableFlowClassificationRule.Json();
    json.setSubjectReference(mock(EntityReference.class));

    // Act
    json.setIsReadonly(true);

    // Assert
    assertTrue(json.isReadonly);
    assertTrue(json.isReadonlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Json#subjectOrgUnitReference()}
   */
  @Test
  void testJsonSubjectOrgUnitReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRule.Json()).subjectOrgUnitReference());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Json#subjectReference()}
   */
  @Test
  void testJsonSubjectReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRule.Json()).subjectReference());
  }

  /**
   * Method under test:
   * {@link ImmutableFlowClassificationRule.Json#vantagePointReference()}
   */
  @Test
  void testJsonVantagePointReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableFlowClassificationRule.Json()).vantagePointReference());
  }
}
