package org.finos.waltz.service.physical_flow_participant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.physical_flow_participant.PhysicalFlowParticipantDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FreshnessIndicator;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow;
import org.finos.waltz.model.physical_flow.CriticalityValue;
import org.finos.waltz.model.physical_flow.FrequencyKindValue;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlow;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlow.Builder;
import org.finos.waltz.model.physical_flow.TransportKindValue;
import org.finos.waltz.model.physical_flow_participant.ParticipationKind;
import org.finos.waltz.model.physical_flow_participant.PhysicalFlowParticipant;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.logical_flow.LogicalFlowService;
import org.finos.waltz.service.physical_flow.PhysicalFlowService;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PhysicalFlowParticipantServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private EntityReferenceNameResolver entityReferenceNameResolver;

  @Mock private LogicalFlowService logicalFlowService;

  @Mock private PhysicalFlowParticipantDao physicalFlowParticipantDao;

  @InjectMocks private PhysicalFlowParticipantService physicalFlowParticipantService;

  @Mock private PhysicalFlowService physicalFlowService;

  @Mock private PhysicalSpecificationService physicalSpecificationService;

  /**
   * Test {@link PhysicalFlowParticipantService#findByPhysicalFlowId(long)}.
   *
   * <p>Method under test: {@link PhysicalFlowParticipantService#findByPhysicalFlowId(long)}
   */
  @Test
  @DisplayName("Test findByPhysicalFlowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalFlowParticipantService.findByPhysicalFlowId(long)"})
  void testFindByPhysicalFlowId() {
    // Arrange
    ArrayList<PhysicalFlowParticipant> physicalFlowParticipantList = new ArrayList<>();
    when(physicalFlowParticipantDao.findByPhysicalFlowId(anyLong()))
        .thenReturn(physicalFlowParticipantList);

    // Act
    Collection<PhysicalFlowParticipant> actualFindByPhysicalFlowIdResult =
        physicalFlowParticipantService.findByPhysicalFlowId(1L);

    // Assert
    verify(physicalFlowParticipantDao).findByPhysicalFlowId(1L);
    assertTrue(actualFindByPhysicalFlowIdResult instanceof List);
    assertTrue(actualFindByPhysicalFlowIdResult.isEmpty());
    assertSame(physicalFlowParticipantList, actualFindByPhysicalFlowIdResult);
  }

  /**
   * Test {@link PhysicalFlowParticipantService#findByParticipant(EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowParticipantService#findByParticipant(EntityReference)}
   */
  @Test
  @DisplayName("Test findByParticipant(EntityReference); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection PhysicalFlowParticipantService.findByParticipant(EntityReference)"
  })
  void testFindByParticipant_thenReturnList() {
    // Arrange
    ArrayList<PhysicalFlowParticipant> physicalFlowParticipantList = new ArrayList<>();
    when(physicalFlowParticipantDao.findByParticipant(Mockito.<EntityReference>any()))
        .thenReturn(physicalFlowParticipantList);

    // Act
    Collection<PhysicalFlowParticipant> actualFindByParticipantResult =
        physicalFlowParticipantService.findByParticipant(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(physicalFlowParticipantDao).findByParticipant(isA(EntityReference.class));
    assertTrue(actualFindByParticipantResult instanceof List);
    assertTrue(actualFindByParticipantResult.isEmpty());
    assertSame(physicalFlowParticipantList, actualFindByParticipantResult);
  }

  /**
   * Test {@link PhysicalFlowParticipantService#remove(long, ParticipationKind, EntityReference,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link EntityReferenceNameResolver} {@link
   *       EntityReferenceNameResolver#resolve(EntityReference)} return empty.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowParticipantService#remove(long, ParticipationKind,
   * EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test remove(long, ParticipationKind, EntityReference, String); given EntityReferenceNameResolver resolve(EntityReference) return empty; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean PhysicalFlowParticipantService.remove(long, ParticipationKind, EntityReference, String)"
  })
  void testRemove_givenEntityReferenceNameResolverResolveReturnEmpty_thenReturnTrue() {
    // Arrange
    when(physicalFlowParticipantDao.remove(
            anyLong(), Mockito.<ParticipationKind>any(), Mockito.<EntityReference>any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(entityReferenceNameResolver.resolve(Mockito.<EntityReference>any()))
        .thenReturn(emptyResult);

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowService.getById(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult = basisOffsetResult.created(created2);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowService.getById(anyLong()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created3 = Optional.of(immutableUserTimestamp3);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created3)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationService.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    // Act
    Boolean actualRemoveResult =
        physicalFlowParticipantService.remove(
            1L,
            ParticipationKind.SOURCE,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(EntityReference.class));
    verify(physicalFlowParticipantDao)
        .remove(eq(1L), eq(ParticipationKind.SOURCE), isA(EntityReference.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(logicalFlowService).getById(1L);
    verify(physicalFlowService).getById(1L);
    verify(physicalSpecificationService).getById(1L);
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link PhysicalFlowParticipantService#remove(long, ParticipationKind, EntityReference,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalFlowParticipantDao} {@link PhysicalFlowParticipantDao#remove(long,
   *       ParticipationKind, EntityReference)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowParticipantService#remove(long, ParticipationKind,
   * EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test remove(long, ParticipationKind, EntityReference, String); given PhysicalFlowParticipantDao remove(long, ParticipationKind, EntityReference) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean PhysicalFlowParticipantService.remove(long, ParticipationKind, EntityReference, String)"
  })
  void testRemove_givenPhysicalFlowParticipantDaoRemoveReturnFalse_thenReturnFalse() {
    // Arrange
    when(physicalFlowParticipantDao.remove(
            anyLong(), Mockito.<ParticipationKind>any(), Mockito.<EntityReference>any()))
        .thenReturn(false);

    // Act
    Boolean actualRemoveResult =
        physicalFlowParticipantService.remove(
            1L,
            ParticipationKind.SOURCE,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(physicalFlowParticipantDao)
        .remove(eq(1L), eq(ParticipationKind.SOURCE), isA(EntityReference.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link PhysicalFlowParticipantService#remove(long, ParticipationKind, EntityReference,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowParticipantService#remove(long, ParticipationKind,
   * EntityReference, String)}
   */
  @Test
  @DisplayName("Test remove(long, ParticipationKind, EntityReference, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean PhysicalFlowParticipantService.remove(long, ParticipationKind, EntityReference, String)"
  })
  void testRemove_thenReturnTrue() {
    // Arrange
    when(physicalFlowParticipantDao.remove(
            anyLong(), Mockito.<ParticipationKind>any(), Mockito.<EntityReference>any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(entityReferenceNameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowService.getById(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult = basisOffsetResult.created(created2);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowService.getById(anyLong()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created3 = Optional.of(immutableUserTimestamp3);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created3)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationService.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    // Act
    Boolean actualRemoveResult =
        physicalFlowParticipantService.remove(
            1L,
            ParticipationKind.SOURCE,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(EntityReference.class));
    verify(physicalFlowParticipantDao)
        .remove(eq(1L), eq(ParticipationKind.SOURCE), isA(EntityReference.class));
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(logicalFlowService).getById(1L);
    verify(physicalFlowService).getById(1L);
    verify(physicalSpecificationService).getById(1L);
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link PhysicalFlowParticipantService#add(long, ParticipationKind, EntityReference,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link EntityReferenceNameResolver} {@link
   *       EntityReferenceNameResolver#resolve(EntityReference)} return empty.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowParticipantService#add(long, ParticipationKind,
   * EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test add(long, ParticipationKind, EntityReference, String); given EntityReferenceNameResolver resolve(EntityReference) return empty; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean PhysicalFlowParticipantService.add(long, ParticipationKind, EntityReference, String)"
  })
  void testAdd_givenEntityReferenceNameResolverResolveReturnEmpty_thenReturnTrue() {
    // Arrange
    when(physicalFlowParticipantDao.add(
            anyLong(),
            Mockito.<ParticipationKind>any(),
            Mockito.<EntityReference>any(),
            Mockito.<String>any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(entityReferenceNameResolver.resolve(Mockito.<EntityReference>any()))
        .thenReturn(emptyResult);

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowService.getById(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult = basisOffsetResult.created(created2);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowService.getById(anyLong()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created3 = Optional.of(immutableUserTimestamp3);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created3)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationService.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    // Act
    Boolean actualAddResult =
        physicalFlowParticipantService.add(
            1L,
            ParticipationKind.SOURCE,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(EntityReference.class));
    verify(physicalFlowParticipantDao)
        .add(eq(1L), eq(ParticipationKind.SOURCE), isA(EntityReference.class), eq("janedoe"));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(logicalFlowService).getById(1L);
    verify(physicalFlowService).getById(1L);
    verify(physicalSpecificationService).getById(1L);
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link PhysicalFlowParticipantService#add(long, ParticipationKind, EntityReference,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalFlowParticipantDao} {@link PhysicalFlowParticipantDao#add(long,
   *       ParticipationKind, EntityReference, String)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowParticipantService#add(long, ParticipationKind,
   * EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test add(long, ParticipationKind, EntityReference, String); given PhysicalFlowParticipantDao add(long, ParticipationKind, EntityReference, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean PhysicalFlowParticipantService.add(long, ParticipationKind, EntityReference, String)"
  })
  void testAdd_givenPhysicalFlowParticipantDaoAddReturnFalse_thenReturnFalse() {
    // Arrange
    when(physicalFlowParticipantDao.add(
            anyLong(),
            Mockito.<ParticipationKind>any(),
            Mockito.<EntityReference>any(),
            Mockito.<String>any()))
        .thenReturn(false);

    // Act
    Boolean actualAddResult =
        physicalFlowParticipantService.add(
            1L,
            ParticipationKind.SOURCE,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(physicalFlowParticipantDao)
        .add(eq(1L), eq(ParticipationKind.SOURCE), isA(EntityReference.class), eq("janedoe"));
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link PhysicalFlowParticipantService#add(long, ParticipationKind, EntityReference,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowParticipantService#add(long, ParticipationKind,
   * EntityReference, String)}
   */
  @Test
  @DisplayName("Test add(long, ParticipationKind, EntityReference, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean PhysicalFlowParticipantService.add(long, ParticipationKind, EntityReference, String)"
  })
  void testAdd_thenReturnTrue() {
    // Arrange
    when(physicalFlowParticipantDao.add(
            anyLong(),
            Mockito.<ParticipationKind>any(),
            Mockito.<EntityReference>any(),
            Mockito.<String>any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(entityReferenceNameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowService.getById(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult = basisOffsetResult.created(created2);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowService.getById(anyLong()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created3 = Optional.of(immutableUserTimestamp3);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created3)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationService.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    // Act
    Boolean actualAddResult =
        physicalFlowParticipantService.add(
            1L,
            ParticipationKind.SOURCE,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(EntityReference.class));
    verify(physicalFlowParticipantDao)
        .add(eq(1L), eq(ParticipationKind.SOURCE), isA(EntityReference.class), eq("janedoe"));
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(logicalFlowService).getById(1L);
    verify(physicalFlowService).getById(1L);
    verify(physicalSpecificationService).getById(1L);
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link PhysicalFlowParticipantService#checkHasPermission(long, String)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalFlowService} {@link PhysicalFlowService#checkHasPermission(long,
   *       String)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowParticipantService#checkHasPermission(long, String)}
   */
  @Test
  @DisplayName(
      "Test checkHasPermission(long, String); given PhysicalFlowService checkHasPermission(long, String) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhysicalFlowParticipantService.checkHasPermission(long, String)"})
  void testCheckHasPermission_givenPhysicalFlowServiceCheckHasPermissionDoesNothing()
      throws InsufficientPrivelegeException {
    // Arrange
    doNothing().when(physicalFlowService).checkHasPermission(anyLong(), Mockito.<String>any());

    // Act
    physicalFlowParticipantService.checkHasPermission(1L, "janedoe");

    // Assert
    verify(physicalFlowService).checkHasPermission(1L, "janedoe");
  }

  /**
   * Test {@link PhysicalFlowParticipantService#checkHasPermission(long, String)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowParticipantService#checkHasPermission(long, String)}
   */
  @Test
  @DisplayName("Test checkHasPermission(long, String); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhysicalFlowParticipantService.checkHasPermission(long, String)"})
  void testCheckHasPermission_thenThrowInsufficientPrivelegeException()
      throws InsufficientPrivelegeException {
    // Arrange
    doThrow(new InsufficientPrivelegeException("An error occurred"))
        .when(physicalFlowService)
        .checkHasPermission(anyLong(), Mockito.<String>any());

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () -> physicalFlowParticipantService.checkHasPermission(1L, "janedoe"));
    verify(physicalFlowService).checkHasPermission(1L, "janedoe");
  }
}
