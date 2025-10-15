package org.finos.waltz.model.physical_flow_participant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.physical_flow_participant.ImmutablePhysicalFlowParticipant.Builder;
import org.finos.waltz.model.physical_flow_participant.ImmutablePhysicalFlowParticipant.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalFlowParticipantDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParticipant Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    Builder actualLastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01");
    ImmutableEntityReference participant =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutablePhysicalFlowParticipant actualImmutablePhysicalFlowParticipant =
        actualLastUpdatedByResult
            .participant(participant)
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutablePhysicalFlowParticipant.lastUpdatedBy());
    assertEquals("Provenance", actualImmutablePhysicalFlowParticipant.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutablePhysicalFlowParticipant.description());
    assertEquals(1L, actualImmutablePhysicalFlowParticipant.physicalFlowId());
    assertEquals(ParticipationKind.SOURCE, actualImmutablePhysicalFlowParticipant.kind());
    assertSame(lastUpdatedAt, actualImmutablePhysicalFlowParticipant.lastUpdatedAt());
    assertSame(participant, actualImmutablePhysicalFlowParticipant.participant());
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant instance =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutablePhysicalFlowParticipant actualImmutablePhysicalFlowParticipant =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalFlowParticipant);
    ImmutablePhysicalFlowParticipant actualImmutablePhysicalFlowParticipant2 =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowParticipant2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant instance =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutablePhysicalFlowParticipant actualImmutablePhysicalFlowParticipant =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalFlowParticipant);
    ImmutablePhysicalFlowParticipant actualImmutablePhysicalFlowParticipant2 =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowParticipant2);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedBy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParticipant)} with {@code
   * PhysicalFlowParticipant}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowParticipant)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParticipant) with 'PhysicalFlowParticipant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParticipant)"})
  void testBuilderFromWithPhysicalFlowParticipant() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant instance =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowParticipant actualImmutablePhysicalFlowParticipant = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowParticipant);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalFlowParticipant)} with {@code
   * PhysicalFlowParticipant}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalFlowParticipant)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalFlowParticipant) with 'PhysicalFlowParticipant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalFlowParticipant)"})
  void testBuilderFromWithPhysicalFlowParticipant2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description(null)
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant instance =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalFlowParticipant actualImmutablePhysicalFlowParticipant = builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowParticipant);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableActor.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isExternal(true)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant instance =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutablePhysicalFlowParticipant actualImmutablePhysicalFlowParticipant =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutablePhysicalFlowParticipant);
    ImmutablePhysicalFlowParticipant actualImmutablePhysicalFlowParticipant2 =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalFlowParticipant2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableActor.builder()
                    .description(null)
                    .externalId("42")
                    .id(1L)
                    .isExternal(true)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#kind(ParticipationKind)}.
   *
   * <p>Method under test: {@link Builder#kind(ParticipationKind)}
   */
  @Test
  @DisplayName("Test Builder kind(ParticipationKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.kind(ParticipationKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    // Act
    Builder actualKindResult = builderResult.kind(ParticipationKind.SOURCE);

    // Assert
    assertSame(builderResult, actualKindResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>When {@code 2020-03-01}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String); when '2020-03-01'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy_when20200301_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#participant(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#participant(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder participant(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.participant(EntityReference)"})
  void testBuilderParticipant_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    // Act
    Builder actualParticipantResult = builderResult.participant(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualParticipantResult);
  }

  /**
   * Test Builder {@link Builder#physicalFlowId(long)}.
   *
   * <p>Method under test: {@link Builder#physicalFlowId(long)}
   */
  @Test
  @DisplayName("Test Builder physicalFlowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.physicalFlowId(long)"})
  void testBuilderPhysicalFlowId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalFlowParticipant.builder();

    // Act
    Builder actualPhysicalFlowIdResult = builderResult.physicalFlowId(1L);

    // Assert
    assertSame(builderResult, actualPhysicalFlowIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#copyOf(PhysicalFlowParticipant)}.
   *
   * <ul>
   *   <li>Then participant return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#copyOf(PhysicalFlowParticipant)}
   */
  @Test
  @DisplayName(
      "Test copyOf(PhysicalFlowParticipant); then participant return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParticipant ImmutablePhysicalFlowParticipant.copyOf(PhysicalFlowParticipant)"
  })
  void testCopyOf_thenParticipantReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant instance =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutablePhysicalFlowParticipant actualCopyOfResult =
        ImmutablePhysicalFlowParticipant.copyOf(instance);

    // Assert
    EntityReference participantResult = actualCopyOfResult.participant();
    assertTrue(participantResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", participantResult.description());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, participantResult.id());
    assertEquals(1L, actualCopyOfResult.physicalFlowId());
    assertEquals(EntityKind.ALL, participantResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, participantResult.entityLifecycleStatus());
    assertEquals(ParticipationKind.SOURCE, actualCopyOfResult.kind());
    assertSame(ofResult, actualCopyOfResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#equals(Object)}, and {@link
   * ImmutablePhysicalFlowParticipant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowParticipant#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowParticipant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParticipant.equals(Object)",
    "int ImmutablePhysicalFlowParticipant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    Builder lastUpdatedByResult2 =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant2 =
        lastUpdatedByResult2
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutablePhysicalFlowParticipant, immutablePhysicalFlowParticipant2);
    assertEquals(
        immutablePhysicalFlowParticipant.hashCode(), immutablePhysicalFlowParticipant2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#equals(Object)}, and {@link
   * ImmutablePhysicalFlowParticipant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowParticipant#equals(Object)}
   *   <li>{@link ImmutablePhysicalFlowParticipant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParticipant.equals(Object)",
    "int ImmutablePhysicalFlowParticipant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutablePhysicalFlowParticipant, immutablePhysicalFlowParticipant);
    int expectedHashCodeResult = immutablePhysicalFlowParticipant.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalFlowParticipant.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParticipant.equals(Object)",
    "int ImmutablePhysicalFlowParticipant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.FLOW)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    Builder lastUpdatedByResult2 =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowParticipant,
        lastUpdatedByResult2
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParticipant.equals(Object)",
    "int ImmutablePhysicalFlowParticipant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    Builder lastUpdatedByResult2 =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowParticipant,
        lastUpdatedByResult2
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParticipant.equals(Object)",
    "int ImmutablePhysicalFlowParticipant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    Builder lastUpdatedByResult2 =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowParticipant,
        lastUpdatedByResult2
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParticipant.equals(Object)",
    "int ImmutablePhysicalFlowParticipant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    Builder lastUpdatedByResult2 =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowParticipant,
        lastUpdatedByResult2
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParticipant.equals(Object)",
    "int ImmutablePhysicalFlowParticipant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(2L)
            .provenance("Provenance")
            .build();

    Builder lastUpdatedByResult2 =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowParticipant,
        lastUpdatedByResult2
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParticipant.equals(Object)",
    "int ImmutablePhysicalFlowParticipant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("2020-03-01")
            .build();

    Builder lastUpdatedByResult2 =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        immutablePhysicalFlowParticipant,
        lastUpdatedByResult2
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParticipant.equals(Object)",
    "int ImmutablePhysicalFlowParticipant.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalFlowParticipant.equals(Object)",
    "int ImmutablePhysicalFlowParticipant.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertNotEquals(
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build(),
        "Different type to ImmutablePhysicalFlowParticipant");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalFlowParticipant#toString()}
   *   <li>{@link ImmutablePhysicalFlowParticipant#description()}
   *   <li>{@link ImmutablePhysicalFlowParticipant#kind()}
   *   <li>{@link ImmutablePhysicalFlowParticipant#lastUpdatedBy()}
   *   <li>{@link ImmutablePhysicalFlowParticipant#participant()}
   *   <li>{@link ImmutablePhysicalFlowParticipant#physicalFlowId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutablePhysicalFlowParticipant.description()",
    "ParticipationKind ImmutablePhysicalFlowParticipant.kind()",
    "String ImmutablePhysicalFlowParticipant.lastUpdatedBy()",
    "EntityReference ImmutablePhysicalFlowParticipant.participant()",
    "long ImmutablePhysicalFlowParticipant.physicalFlowId()",
    "String ImmutablePhysicalFlowParticipant.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    // Act
    String actualToStringResult = immutablePhysicalFlowParticipant.toString();
    String actualDescriptionResult = immutablePhysicalFlowParticipant.description();
    ParticipationKind actualKindResult = immutablePhysicalFlowParticipant.kind();
    String actualLastUpdatedByResult = immutablePhysicalFlowParticipant.lastUpdatedBy();
    EntityReference actualParticipantResult = immutablePhysicalFlowParticipant.participant();

    // Assert
    assertTrue(actualParticipantResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals(
        "PhysicalFlowParticipant{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance,"
            + " physicalFlowId=1, kind=SOURCE, participant=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}}",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, immutablePhysicalFlowParticipant.physicalFlowId());
    assertEquals(ParticipationKind.SOURCE, actualKindResult);
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setKind(ParticipationKind)}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link Json#setLastUpdatedBy(String)}
   *   <li>{@link Json#setParticipant(EntityReference)}
   *   <li>{@link Json#setProvenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setKind(ParticipationKind)",
    "void Json.setLastUpdatedAt(LocalDateTime)",
    "void Json.setLastUpdatedBy(String)",
    "void Json.setParticipant(EntityReference)",
    "void Json.setProvenance(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setKind(ParticipationKind.SOURCE);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setParticipant(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setProvenance("Provenance");

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ParticipationKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedBy());
  }

  /**
   * Test Json {@link Json#participant()}.
   *
   * <p>Method under test: {@link Json#participant()}
   */
  @Test
  @DisplayName("Test Json participant()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.participant()"})
  void testJsonParticipant() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().participant());
  }

  /**
   * Test Json {@link Json#physicalFlowId()}.
   *
   * <p>Method under test: {@link Json#physicalFlowId()}
   */
  @Test
  @DisplayName("Test Json physicalFlowId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.physicalFlowId()"})
  void testJsonPhysicalFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().physicalFlowId());
  }

  /**
   * Test Json {@link Json#provenance()}.
   *
   * <p>Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().provenance());
  }

  /**
   * Test Json {@link Json#setPhysicalFlowId(long)}.
   *
   * <p>Method under test: {@link Json#setPhysicalFlowId(long)}
   */
  @Test
  @DisplayName("Test Json setPhysicalFlowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPhysicalFlowId(long)"})
  void testJsonSetPhysicalFlowId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPhysicalFlowId(1L);

    // Assert
    assertEquals(1L, json.physicalFlowId);
    assertTrue(json.physicalFlowIdIsSet);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutablePhysicalFlowParticipant.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#provenance()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePhysicalFlowParticipant.provenance()"})
  void testProvenance() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act and Assert
    assertEquals(
        "Provenance",
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParticipant ImmutablePhysicalFlowParticipant.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutablePhysicalFlowParticipant actualWithDescriptionResult =
        immutablePhysicalFlowParticipant.withDescription("42");

    // Assert
    assertEquals(immutablePhysicalFlowParticipant, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParticipant ImmutablePhysicalFlowParticipant.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("42")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutablePhysicalFlowParticipant actualWithDescriptionResult =
        immutablePhysicalFlowParticipant.withDescription("42");

    // Assert
    assertSame(immutablePhysicalFlowParticipant, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#withKind(ParticipationKind)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#withKind(ParticipationKind)}
   */
  @Test
  @DisplayName("Test withKind(ParticipationKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParticipant ImmutablePhysicalFlowParticipant.withKind(ParticipationKind)"
  })
  void testWithKind() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutablePhysicalFlowParticipant actualWithKindResult =
        immutablePhysicalFlowParticipant.withKind(ParticipationKind.SOURCE);

    // Assert
    assertSame(immutablePhysicalFlowParticipant, actualWithKindResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#withKind(ParticipationKind)}.
   *
   * <ul>
   *   <li>Then participant return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#withKind(ParticipationKind)}
   */
  @Test
  @DisplayName("Test withKind(ParticipationKind); then participant return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParticipant ImmutablePhysicalFlowParticipant.withKind(ParticipationKind)"
  })
  void testWithKind_thenParticipantReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.FLOW)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutablePhysicalFlowParticipant actualWithKindResult =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build()
            .withKind(ParticipationKind.SOURCE);

    // Assert
    EntityReference participantResult = actualWithKindResult.participant();
    assertTrue(participantResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithKindResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("The characteristics of someone or something", participantResult.description());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(1L, participantResult.id());
    assertEquals(1L, actualWithKindResult.physicalFlowId());
    assertEquals(EntityKind.ALL, participantResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, participantResult.entityLifecycleStatus());
    assertEquals(ParticipationKind.SOURCE, actualWithKindResult.kind());
    assertSame(ofResult, actualWithKindResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParticipant ImmutablePhysicalFlowParticipant.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutablePhysicalFlowParticipant actualWithLastUpdatedAtResult =
        immutablePhysicalFlowParticipant.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutablePhysicalFlowParticipant, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParticipant ImmutablePhysicalFlowParticipant.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutablePhysicalFlowParticipant actualWithLastUpdatedByResult =
        immutablePhysicalFlowParticipant.withLastUpdatedBy("42");

    // Assert
    assertSame(immutablePhysicalFlowParticipant, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then participant return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String); then participant return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParticipant ImmutablePhysicalFlowParticipant.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenParticipantReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutablePhysicalFlowParticipant actualWithLastUpdatedByResult =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build()
            .withLastUpdatedBy("42");

    // Assert
    EntityReference participantResult = actualWithLastUpdatedByResult.participant();
    assertTrue(participantResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals("The characteristics of someone or something", participantResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(1L, participantResult.id());
    assertEquals(1L, actualWithLastUpdatedByResult.physicalFlowId());
    assertEquals(EntityKind.ALL, participantResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, participantResult.entityLifecycleStatus());
    assertEquals(ParticipationKind.SOURCE, actualWithLastUpdatedByResult.kind());
    assertSame(ofResult, actualWithLastUpdatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#withParticipant(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#withParticipant(EntityReference)}
   */
  @Test
  @DisplayName("Test withParticipant(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParticipant ImmutablePhysicalFlowParticipant.withParticipant(EntityReference)"
  })
  void testWithParticipant() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutablePhysicalFlowParticipant actualWithParticipantResult =
        immutablePhysicalFlowParticipant.withParticipant(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutablePhysicalFlowParticipant, actualWithParticipantResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#withPhysicalFlowId(long)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#withPhysicalFlowId(long)}
   */
  @Test
  @DisplayName("Test withPhysicalFlowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParticipant ImmutablePhysicalFlowParticipant.withPhysicalFlowId(long)"
  })
  void testWithPhysicalFlowId() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(42L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutablePhysicalFlowParticipant actualWithPhysicalFlowIdResult =
        immutablePhysicalFlowParticipant.withPhysicalFlowId(42L);

    // Assert
    assertSame(immutablePhysicalFlowParticipant, actualWithPhysicalFlowIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#withPhysicalFlowId(long)}.
   *
   * <ul>
   *   <li>Then participant return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#withPhysicalFlowId(long)}
   */
  @Test
  @DisplayName("Test withPhysicalFlowId(long); then participant return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParticipant ImmutablePhysicalFlowParticipant.withPhysicalFlowId(long)"
  })
  void testWithPhysicalFlowId_thenParticipantReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutablePhysicalFlowParticipant actualWithPhysicalFlowIdResult =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build()
            .withPhysicalFlowId(42L);

    // Assert
    EntityReference participantResult = actualWithPhysicalFlowIdResult.participant();
    assertTrue(participantResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithPhysicalFlowIdResult.lastUpdatedBy());
    assertEquals("Provenance", actualWithPhysicalFlowIdResult.provenance());
    assertEquals("The characteristics of someone or something", participantResult.description());
    assertEquals(
        "The characteristics of someone or something",
        actualWithPhysicalFlowIdResult.description());
    assertEquals(1L, participantResult.id());
    assertEquals(42L, actualWithPhysicalFlowIdResult.physicalFlowId());
    assertEquals(EntityKind.ALL, participantResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, participantResult.entityLifecycleStatus());
    assertEquals(ParticipationKind.SOURCE, actualWithPhysicalFlowIdResult.kind());
    assertSame(ofResult, actualWithPhysicalFlowIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParticipant ImmutablePhysicalFlowParticipant.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");
    ImmutablePhysicalFlowParticipant immutablePhysicalFlowParticipant =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("42")
            .build();

    // Act
    ImmutablePhysicalFlowParticipant actualWithProvenanceResult =
        immutablePhysicalFlowParticipant.withProvenance("42");

    // Assert
    assertSame(immutablePhysicalFlowParticipant, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutablePhysicalFlowParticipant#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then participant return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalFlowParticipant#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then participant return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalFlowParticipant ImmutablePhysicalFlowParticipant.withProvenance(String)"
  })
  void testWithProvenance_thenParticipantReturnImmutableEntityReference() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder lastUpdatedByResult =
        ImmutablePhysicalFlowParticipant.builder()
            .description("The characteristics of someone or something")
            .kind(ParticipationKind.SOURCE)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutablePhysicalFlowParticipant actualWithProvenanceResult =
        lastUpdatedByResult
            .participant(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .physicalFlowId(1L)
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    EntityReference participantResult = actualWithProvenanceResult.participant();
    assertTrue(participantResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("The characteristics of someone or something", participantResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(1L, participantResult.id());
    assertEquals(1L, actualWithProvenanceResult.physicalFlowId());
    assertEquals(EntityKind.ALL, participantResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, participantResult.entityLifecycleStatus());
    assertEquals(ParticipationKind.SOURCE, actualWithProvenanceResult.kind());
    assertSame(ofResult, actualWithProvenanceResult.lastUpdatedAt().toLocalDate());
  }
}
