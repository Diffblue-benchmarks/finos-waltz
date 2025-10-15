package org.finos.waltz.service.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.attestation.AttestationInstanceDao;
import org.finos.waltz.data.attestation.AttestationInstanceRecipientDao;
import org.finos.waltz.data.attestation.AttestationRunDao;
import org.finos.waltz.data.involvement.InvolvementDao;
import org.finos.waltz.data.involvement_group.InvolvementGroupDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.attestation.AttestEntityCommand;
import org.finos.waltz.model.attestation.AttestationCreateSummary;
import org.finos.waltz.model.attestation.AttestationRun;
import org.finos.waltz.model.attestation.AttestationRunCreateCommand;
import org.finos.waltz.model.attestation.AttestationRunRecipient;
import org.finos.waltz.model.attestation.AttestationRunResponseSummary;
import org.finos.waltz.model.attestation.AttestationStatus;
import org.finos.waltz.model.attestation.ImmutableAttestEntityCommand;
import org.finos.waltz.model.attestation.ImmutableAttestationCreateSummary;
import org.finos.waltz.model.attestation.ImmutableAttestationRun;
import org.finos.waltz.model.attestation.ImmutableAttestationRunCreateCommand;
import org.finos.waltz.model.involvement_group.InvolvementGroupCreateCommand;
import org.finos.waltz.service.involvement_group.InvolvementGroupService;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AttestationRunServiceDiffblueTest {
  @Mock private AttestationInstanceDao attestationInstanceDao;

  @Mock private AttestationInstanceRecipientDao attestationInstanceRecipientDao;

  @Mock private AttestationRunDao attestationRunDao;

  @InjectMocks private AttestationRunService attestationRunService;

  @Mock private EntityReferenceNameResolver entityReferenceNameResolver;

  @Mock private InvolvementDao involvementDao;

  @Mock private InvolvementGroupService involvementGroupService;

  /**
   * Test {@link AttestationRunService#getById(long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttestationRun AttestationRunService.getById(long)"})
  void testGetById_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    ImmutableAttestationRun.Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);
    LocalDate dueDate = LocalDate.of(1970, 1, 1);

    ImmutableAttestationRun.Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(dueDate);
    LocalDate issuedOn = LocalDate.of(1970, 1, 1);

    ImmutableAttestationRun.Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(issuedOn)
            .name("Name")
            .provenance("Provenance");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    when(attestationRunDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(AttestationStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    AttestationRun actualById = attestationRunService.getById(1L);

    // Assert
    verify(attestationRunDao).getById(1L);
    assertTrue(actualById.entityReference() instanceof ImmutableEntityReference);
    assertTrue(actualById.selectionOptions() instanceof ImmutableIdSelectionOptions);
    assertTrue(actualById instanceof ImmutableAttestationRun);
    assertEquals("Issued By", actualById.issuedBy());
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(EntityKind.ALL, actualById.attestedEntityKind());
    assertEquals(EntityKind.ALL, actualById.targetEntityKind());
    assertEquals(AttestationStatus.DRAFT, actualById.status());
    assertTrue(actualById.involvementKindIds().isEmpty());
    assertSame(dueDate, actualById.dueDate());
    assertSame(issuedOn, actualById.issuedOn());
  }

  /**
   * Test {@link AttestationRunService#getById(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttestationRun AttestationRunService.getById(long)"})
  void testGetById_thenThrowIllegalArgumentException() {
    // Arrange
    when(attestationRunDao.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> attestationRunService.getById(1L));
    verify(attestationRunDao).getById(1L);
  }

  /**
   * Test {@link AttestationRunService#findAll()}.
   *
   * <ul>
   *   <li>Given {@link AttestationRunDao} {@link AttestationRunDao#findAll()} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given AttestationRunDao findAll() return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationRunService.findAll()"})
  void testFindAll_givenAttestationRunDaoFindAllReturnArrayList_thenReturnEmpty() {
    // Arrange
    when(attestationRunDao.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<AttestationRun> actualFindAllResult = attestationRunService.findAll();

    // Assert
    verify(attestationRunDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link AttestationRunService#findAll()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#findAll()}
   */
  @Test
  @DisplayName("Test findAll(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationRunService.findAll()"})
  void testFindAll_thenThrowIllegalArgumentException() {
    // Arrange
    when(attestationRunDao.findAll()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> attestationRunService.findAll());
    verify(attestationRunDao).findAll();
  }

  /**
   * Test {@link AttestationRunService#findByRecipient(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#findByRecipient(String)}
   */
  @Test
  @DisplayName("Test findByRecipient(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationRunService.findByRecipient(String)"})
  void testFindByRecipient_thenReturnEmpty() {
    // Arrange
    when(attestationRunDao.findByRecipient(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<AttestationRun> actualFindByRecipientResult = attestationRunService.findByRecipient("42");

    // Assert
    verify(attestationRunDao).findByRecipient("42");
    assertTrue(actualFindByRecipientResult.isEmpty());
  }

  /**
   * Test {@link AttestationRunService#findByRecipient(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#findByRecipient(String)}
   */
  @Test
  @DisplayName("Test findByRecipient(String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationRunService.findByRecipient(String)"})
  void testFindByRecipient_thenThrowIllegalArgumentException() {
    // Arrange
    when(attestationRunDao.findByRecipient(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> attestationRunService.findByRecipient("42"));
    verify(attestationRunDao).findByRecipient("42");
  }

  /**
   * Test {@link AttestationRunService#findResponseSummaries()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#findResponseSummaries()}
   */
  @Test
  @DisplayName("Test findResponseSummaries(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationRunService.findResponseSummaries()"})
  void testFindResponseSummaries_thenReturnEmpty() {
    // Arrange
    when(attestationRunDao.findResponseSummaries()).thenReturn(new ArrayList<>());

    // Act
    List<AttestationRunResponseSummary> actualFindResponseSummariesResult =
        attestationRunService.findResponseSummaries();

    // Assert
    verify(attestationRunDao).findResponseSummaries();
    assertTrue(actualFindResponseSummariesResult.isEmpty());
  }

  /**
   * Test {@link AttestationRunService#findResponseSummaries()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#findResponseSummaries()}
   */
  @Test
  @DisplayName("Test findResponseSummaries(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationRunService.findResponseSummaries()"})
  void testFindResponseSummaries_thenThrowIllegalArgumentException() {
    // Arrange
    when(attestationRunDao.findResponseSummaries()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> attestationRunService.findResponseSummaries());
    verify(attestationRunDao).findResponseSummaries();
  }

  /**
   * Test {@link AttestationRunService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationRunService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenReturnEmpty() {
    // Arrange
    when(attestationRunDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<AttestationRun> actualFindByEntityReferenceResult =
        attestationRunService.findByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(attestationRunDao).findByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link AttestationRunService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationRunService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenThrowIllegalArgumentException() {
    // Arrange
    when(attestationRunDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationRunService.findByEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(attestationRunDao).findByEntityReference(isA(EntityReference.class));
  }

  /**
   * Test {@link AttestationRunService#getCreateSummary(AttestationRunCreateCommand)}.
   *
   * <p>Method under test: {@link
   * AttestationRunService#getCreateSummary(AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName("Test getCreateSummary(AttestationRunCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationCreateSummary AttestationRunService.getCreateSummary(AttestationRunCreateCommand)"
  })
  void testGetCreateSummary() {
    // Arrange
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenThrow(new IllegalArgumentException());

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationRunService.getCreateSummary(
                nameResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .targetEntityKind(EntityKind.APPLICATION)
                    .build()));
    verify(involvementDao)
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
  }

  /**
   * Test {@link AttestationRunService#getCreateSummary(AttestationRunCreateCommand)}.
   *
   * <p>Method under test: {@link
   * AttestationRunService#getCreateSummary(AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName("Test getCreateSummary(AttestationRunCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationCreateSummary AttestationRunService.getCreateSummary(AttestationRunCreateCommand)"
  })
  void testGetCreateSummary2() {
    // Arrange
    when(attestationRunDao.getEntityCount(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException());
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationRunService.getCreateSummary(
                nameResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .targetEntityKind(EntityKind.APPLICATION)
                    .build()));
    verify(attestationRunDao).getEntityCount(isA(Select.class));
    verify(involvementDao)
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
  }

  /**
   * Test {@link AttestationRunService#getCreateSummary(AttestationRunCreateCommand)}.
   *
   * <p>Method under test: {@link
   * AttestationRunService#getCreateSummary(AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName("Test getCreateSummary(AttestationRunCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationCreateSummary AttestationRunService.getCreateSummary(AttestationRunCreateCommand)"
  })
  void testGetCreateSummary3() {
    // Arrange
    when(attestationRunDao.getEntityCount(Mockito.<Select<Record1<Long>>>any())).thenReturn(3);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    AttestationCreateSummary actualCreateSummary =
        attestationRunService.getCreateSummary(
            nameResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .targetEntityKind(EntityKind.APPLICATION)
                .build());

    // Assert
    verify(attestationRunDao).getEntityCount(isA(Select.class));
    verify(involvementDao)
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    assertTrue(actualCreateSummary instanceof ImmutableAttestationCreateSummary);
    assertEquals(0, actualCreateSummary.instanceCount());
    assertEquals(0L, actualCreateSummary.recipientCount());
    assertEquals(3, actualCreateSummary.entityCount());
  }

  /**
   * Test {@link AttestationRunService#getCreateSummary(AttestationRunCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@code INTERNALLY_HOSTED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttestationRunService#getCreateSummary(AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName("Test getCreateSummary(AttestationRunCreateCommand); given 'INTERNALLY_HOSTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationCreateSummary AttestationRunService.getCreateSummary(AttestationRunCreateCommand)"
  })
  void testGetCreateSummary_givenInternallyHosted() {
    // Arrange
    when(attestationRunDao.getEntityCount(Mockito.<Select<Record1<Long>>>any())).thenReturn(3);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.INTERNALLY_HOSTED);
    ImmutableSelectionFilters filters = builderResult.build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    AttestationCreateSummary actualCreateSummary =
        attestationRunService.getCreateSummary(
            ImmutableAttestationRunCreateCommand.builder()
                .attestedEntityId(1L)
                .attestedEntityKind(EntityKind.ALL)
                .description("The characteristics of someone or something")
                .dueDate(LocalDate.of(1970, 1, 1))
                .issuedOn(LocalDate.of(1970, 1, 1))
                .name("Name")
                .selectionOptions(selectionOptions)
                .targetEntityKind(EntityKind.APPLICATION)
                .build());

    // Assert
    verify(attestationRunDao).getEntityCount(isA(Select.class));
    verify(involvementDao)
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    assertTrue(actualCreateSummary instanceof ImmutableAttestationCreateSummary);
    assertEquals(0, actualCreateSummary.instanceCount());
    assertEquals(0L, actualCreateSummary.recipientCount());
    assertEquals(3, actualCreateSummary.entityCount());
  }

  /**
   * Test {@link AttestationRunService#getCreateSummary(AttestationRunCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   *   <li>When builder addEntityLifecycleStatuses {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttestationRunService#getCreateSummary(AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test getCreateSummary(AttestationRunCreateCommand); given 'PENDING'; when builder addEntityLifecycleStatuses 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationCreateSummary AttestationRunService.getCreateSummary(AttestationRunCreateCommand)"
  })
  void testGetCreateSummary_givenPending_whenBuilderAddEntityLifecycleStatusesPending() {
    // Arrange
    when(attestationRunDao.getEntityCount(Mockito.<Select<Record1<Long>>>any())).thenReturn(3);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions selectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();

    // Act
    AttestationCreateSummary actualCreateSummary =
        attestationRunService.getCreateSummary(
            ImmutableAttestationRunCreateCommand.builder()
                .attestedEntityId(1L)
                .attestedEntityKind(EntityKind.ALL)
                .description("The characteristics of someone or something")
                .dueDate(LocalDate.of(1970, 1, 1))
                .issuedOn(LocalDate.of(1970, 1, 1))
                .name("Name")
                .selectionOptions(selectionOptions)
                .targetEntityKind(EntityKind.APPLICATION)
                .build());

    // Assert
    verify(attestationRunDao).getEntityCount(isA(Select.class));
    verify(involvementDao)
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    assertTrue(actualCreateSummary instanceof ImmutableAttestationCreateSummary);
    assertEquals(0, actualCreateSummary.instanceCount());
    assertEquals(0L, actualCreateSummary.recipientCount());
    assertEquals(3, actualCreateSummary.entityCount());
  }

  /**
   * Test {@link AttestationRunService#getCreateSummary(AttestationRunCreateCommand)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableAttestationCreateSummary}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttestationRunService#getCreateSummary(AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test getCreateSummary(AttestationRunCreateCommand); then return ImmutableAttestationCreateSummary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AttestationCreateSummary AttestationRunService.getCreateSummary(AttestationRunCreateCommand)"
  })
  void testGetCreateSummary_thenReturnImmutableAttestationCreateSummary() {
    // Arrange
    when(attestationRunDao.getEntityCount(Mockito.<Select<Record1<Long>>>any())).thenReturn(3);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(
            Mockito.<EntityKind>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Set<Long>>any()))
        .thenReturn(new HashMap<>());

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    AttestationCreateSummary actualCreateSummary =
        attestationRunService.getCreateSummary(
            nameResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .targetEntityKind(EntityKind.APPLICATION)
                .build());

    // Assert
    verify(attestationRunDao).getEntityCount(isA(Select.class));
    verify(involvementDao)
        .findPeopleByEntitySelectorAndInvolvement(
            eq(EntityKind.APPLICATION), isA(Select.class), isA(Set.class));
    assertTrue(actualCreateSummary instanceof ImmutableAttestationCreateSummary);
    assertEquals(0, actualCreateSummary.instanceCount());
    assertEquals(0L, actualCreateSummary.recipientCount());
    assertEquals(3, actualCreateSummary.entityCount());
  }

  /**
   * Test {@link AttestationRunService#create(String, AttestationRunCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link AttestationRunDao} {@link AttestationRunDao#create(String,
   *       AttestationRunCreateCommand)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#create(String, AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, AttestationRunCreateCommand); given AttestationRunDao create(String, AttestationRunCreateCommand) throw IllegalArgumentException(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.IdCommandResponse AttestationRunService.create(String, AttestationRunCreateCommand)"
  })
  void testCreate_givenAttestationRunDaoCreateThrowIllegalArgumentException_whenNull() {
    // Arrange
    when(attestationRunDao.create(
            Mockito.<String>any(), Mockito.<AttestationRunCreateCommand>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> attestationRunService.create("42", null));
    verify(attestationRunDao).create(eq("42"), isNull());
  }

  /**
   * Test {@link AttestationRunService#create(String, AttestationRunCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add one.
   *   <li>Then calls {@link AttestationRunCreateCommand#name()}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#create(String, AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, AttestationRunCreateCommand); given HashSet() add one; then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.IdCommandResponse AttestationRunService.create(String, AttestationRunCreateCommand)"
  })
  void testCreate_givenHashSetAddOne_thenCallsName() {
    // Arrange
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(attestationRunDao.create(
            Mockito.<String>any(), Mockito.<AttestationRunCreateCommand>any()))
        .thenReturn(1L);

    ImmutableAttestationRun.Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    ImmutableAttestationRun.Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    ImmutableAttestationRun.Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    when(attestationRunDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(AttestationStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    resultLongSet.add(2L);

    AttestationRunCreateCommand command = mock(AttestationRunCreateCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(resultLongSet);
    when(command.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> attestationRunService.create("42", command));
    verify(attestationRunDao).create(eq("42"), isA(AttestationRunCreateCommand.class));
    verify(attestationRunDao).getById(1L);
    verify(attestationRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(command).name();
    verify(command).attestedEntityKind();
    verify(command).involvementKindIds();
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("42"));
  }

  /**
   * Test {@link AttestationRunService#create(String, AttestationRunCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add two.
   *   <li>Then calls {@link AttestationRunCreateCommand#name()}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#create(String, AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, AttestationRunCreateCommand); given HashSet() add two; then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.IdCommandResponse AttestationRunService.create(String, AttestationRunCreateCommand)"
  })
  void testCreate_givenHashSetAddTwo_thenCallsName() {
    // Arrange
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(attestationRunDao.create(
            Mockito.<String>any(), Mockito.<AttestationRunCreateCommand>any()))
        .thenReturn(1L);

    ImmutableAttestationRun.Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    ImmutableAttestationRun.Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    ImmutableAttestationRun.Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    when(attestationRunDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(AttestationStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(2L);

    AttestationRunCreateCommand command = mock(AttestationRunCreateCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(resultLongSet);
    when(command.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> attestationRunService.create("42", command));
    verify(attestationRunDao).create(eq("42"), isA(AttestationRunCreateCommand.class));
    verify(attestationRunDao).getById(1L);
    verify(attestationRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(command).name();
    verify(command).attestedEntityKind();
    verify(command).involvementKindIds();
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("42"));
  }

  /**
   * Test {@link AttestationRunService#create(String, AttestationRunCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then calls {@link AttestationRunCreateCommand#name()}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#create(String, AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, AttestationRunCreateCommand); given HashSet(); then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.IdCommandResponse AttestationRunService.create(String, AttestationRunCreateCommand)"
  })
  void testCreate_givenHashSet_thenCallsName() {
    // Arrange
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(attestationRunDao.create(
            Mockito.<String>any(), Mockito.<AttestationRunCreateCommand>any()))
        .thenReturn(1L);

    ImmutableAttestationRun.Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    ImmutableAttestationRun.Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    ImmutableAttestationRun.Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    when(attestationRunDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(AttestationStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    AttestationRunCreateCommand command = mock(AttestationRunCreateCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> attestationRunService.create("42", command));
    verify(attestationRunDao).create(eq("42"), isA(AttestationRunCreateCommand.class));
    verify(attestationRunDao).getById(1L);
    verify(attestationRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(command).name();
    verify(command).attestedEntityKind();
    verify(command).involvementKindIds();
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("42"));
  }

  /**
   * Test {@link AttestationRunService#create(String, AttestationRunCreateCommand)}.
   *
   * <ul>
   *   <li>Given {@link InvolvementGroupService} {@link
   *       InvolvementGroupService#createGroup(InvolvementGroupCreateCommand, String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#create(String, AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, AttestationRunCreateCommand); given InvolvementGroupService createGroup(InvolvementGroupCreateCommand, String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.IdCommandResponse AttestationRunService.create(String, AttestationRunCreateCommand)"
  })
  void testCreate_givenInvolvementGroupServiceCreateGroupThrowIllegalArgumentException() {
    // Arrange
    when(attestationRunDao.create(
            Mockito.<String>any(), Mockito.<AttestationRunCreateCommand>any()))
        .thenReturn(1L);
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationRunService.create(
                "42",
                nameResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .targetEntityKind(EntityKind.ALL)
                    .build()));
    verify(attestationRunDao).create(eq("42"), isA(AttestationRunCreateCommand.class));
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("42"));
  }

  /**
   * Test {@link AttestationRunService#create(String, AttestationRunCreateCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       InvolvementGroupDao#createInvolvementGroup(InvolvementGroupCreateCommand)}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#create(String, AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, AttestationRunCreateCommand); then calls createInvolvementGroup(InvolvementGroupCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.IdCommandResponse AttestationRunService.create(String, AttestationRunCreateCommand)"
  })
  void testCreate_thenCallsCreateInvolvementGroup() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(attestationRunDao.create(
            Mockito.<String>any(), Mockito.<AttestationRunCreateCommand>any()))
        .thenReturn(1L);

    ImmutableAttestationRun.Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    ImmutableAttestationRun.Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    ImmutableAttestationRun.Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    when(attestationRunDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(AttestationStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);

    AttestationRunService attestationRunService =
        new AttestationRunService(
            mock(AttestationInstanceDao.class),
            mock(AttestationInstanceRecipientDao.class),
            attestationRunDao,
            mock(EntityReferenceNameResolver.class),
            mock(InvolvementDao.class),
            involvementGroupService);

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationRunService.create(
                "42",
                nameResult
                    .selectionOptions(
                        joiningEntityKindResult2
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .targetEntityKind(EntityKind.ALL)
                    .build()));
    verify(attestationRunDao).create(eq("42"), isA(AttestationRunCreateCommand.class));
    verify(attestationRunDao).getById(1L);
    verify(attestationRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(involvementGroupDao).createInvolvementGroup(isA(InvolvementGroupCreateCommand.class));
  }

  /**
   * Test {@link AttestationRunService#create(String, AttestationRunCreateCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link AttestationRunDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#create(String, AttestationRunCreateCommand)}
   */
  @Test
  @DisplayName("Test create(String, AttestationRunCreateCommand); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.IdCommandResponse AttestationRunService.create(String, AttestationRunCreateCommand)"
  })
  void testCreate_thenCallsGetById() {
    // Arrange
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(attestationRunDao.create(
            Mockito.<String>any(), Mockito.<AttestationRunCreateCommand>any()))
        .thenReturn(1L);

    ImmutableAttestationRun.Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    ImmutableAttestationRun.Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    ImmutableAttestationRun.Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    when(attestationRunDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(AttestationStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    ImmutableAttestationRunCreateCommand.Builder nameResult =
        ImmutableAttestationRunCreateCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationRunService.create(
                "42",
                nameResult
                    .selectionOptions(
                        joiningEntityKindResult2
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .targetEntityKind(EntityKind.ALL)
                    .build()));
    verify(attestationRunDao).create(eq("42"), isA(AttestationRunCreateCommand.class));
    verify(attestationRunDao).getById(1L);
    verify(attestationRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("42"));
  }

  /**
   * Test {@link AttestationRunService#createRunForEntity(String, AttestEntityCommand)}.
   *
   * <p>Method under test: {@link AttestationRunService#createRunForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test createRunForEntity(String, AttestEntityCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.IdCommandResponse AttestationRunService.createRunForEntity(String, AttestEntityCommand)"
  })
  void testCreateRunForEntity() {
    // Arrange
    when(entityReferenceNameResolver.resolve(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException());

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationRunService.createRunForEntity(
                "janedoe",
                attestedEntityKindResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build()));
    verify(entityReferenceNameResolver).resolve(isA(EntityReference.class));
  }

  /**
   * Test {@link AttestationRunService#createRunForEntity(String, AttestEntityCommand)}.
   *
   * <p>Method under test: {@link AttestationRunService#createRunForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test createRunForEntity(String, AttestEntityCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.IdCommandResponse AttestationRunService.createRunForEntity(String, AttestEntityCommand)"
  })
  void testCreateRunForEntity2() {
    // Arrange
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(attestationRunDao.create(
            Mockito.<String>any(), Mockito.<AttestationRunCreateCommand>any()))
        .thenReturn(1L);

    ImmutableAttestationRun.Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    ImmutableAttestationRun.Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    ImmutableAttestationRun.Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    when(attestationRunDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(AttestationStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult2 =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(null)
            .attestedEntityKind(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationRunService.createRunForEntity(
                "janedoe",
                attestedEntityKindResult2
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build()));
    verify(attestationRunDao).create(eq("janedoe"), isA(AttestationRunCreateCommand.class));
    verify(attestationRunDao).getById(1L);
    verify(attestationRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(involvementGroupService)
        .createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Test {@link AttestationRunService#createRunForEntity(String, AttestEntityCommand)}.
   *
   * <p>Method under test: {@link AttestationRunService#createRunForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test createRunForEntity(String, AttestEntityCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.IdCommandResponse AttestationRunService.createRunForEntity(String, AttestEntityCommand)"
  })
  void testCreateRunForEntity3() {
    // Arrange
    when(attestationRunDao.create(
            Mockito.<String>any(), Mockito.<AttestationRunCreateCommand>any()))
        .thenReturn(1L);
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
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationRunService.createRunForEntity(
                "janedoe",
                attestedEntityKindResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build()));
    verify(entityReferenceNameResolver).resolve(isA(EntityReference.class));
    verify(attestationRunDao).create(eq("janedoe"), isA(AttestationRunCreateCommand.class));
    verify(involvementGroupService)
        .createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Test {@link AttestationRunService#createRunForEntity(String, AttestEntityCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       InvolvementGroupDao#createInvolvementGroup(InvolvementGroupCreateCommand)}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#createRunForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName(
      "Test createRunForEntity(String, AttestEntityCommand); then calls createInvolvementGroup(InvolvementGroupCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.IdCommandResponse AttestationRunService.createRunForEntity(String, AttestEntityCommand)"
  })
  void testCreateRunForEntity_thenCallsCreateInvolvementGroup() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(attestationRunDao.create(
            Mockito.<String>any(), Mockito.<AttestationRunCreateCommand>any()))
        .thenReturn(1L);

    ImmutableAttestationRun.Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    ImmutableAttestationRun.Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    ImmutableAttestationRun.Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    when(attestationRunDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(AttestationStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference2);
    when(entityReferenceNameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);

    AttestationRunService attestationRunService =
        new AttestationRunService(
            mock(AttestationInstanceDao.class),
            mock(AttestationInstanceRecipientDao.class),
            attestationRunDao,
            entityReferenceNameResolver,
            mock(InvolvementDao.class),
            involvementGroupService);

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult2 =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationRunService.createRunForEntity(
                "janedoe",
                attestedEntityKindResult2
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build()));
    verify(entityReferenceNameResolver).resolve(isA(EntityReference.class));
    verify(attestationRunDao).create(eq("janedoe"), isA(AttestationRunCreateCommand.class));
    verify(attestationRunDao).getById(1L);
    verify(attestationRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(involvementGroupDao).createInvolvementGroup(isA(InvolvementGroupCreateCommand.class));
  }

  /**
   * Test {@link AttestationRunService#createRunForEntity(String, AttestEntityCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link AttestationRunDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#createRunForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test createRunForEntity(String, AttestEntityCommand); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.IdCommandResponse AttestationRunService.createRunForEntity(String, AttestEntityCommand)"
  })
  void testCreateRunForEntity_thenCallsGetById() {
    // Arrange
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(attestationRunDao.create(
            Mockito.<String>any(), Mockito.<AttestationRunCreateCommand>any()))
        .thenReturn(1L);

    ImmutableAttestationRun.Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    ImmutableAttestationRun.Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    ImmutableAttestationRun.Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    when(attestationRunDao.getById(anyLong()))
        .thenReturn(
            provenanceResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(AttestationStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference2);
    when(entityReferenceNameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult2 =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationRunService.createRunForEntity(
                "janedoe",
                attestedEntityKindResult2
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build()));
    verify(entityReferenceNameResolver).resolve(isA(EntityReference.class));
    verify(attestationRunDao).create(eq("janedoe"), isA(AttestationRunCreateCommand.class));
    verify(attestationRunDao).getById(1L);
    verify(attestationRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(involvementGroupService)
        .createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Test {@link AttestationRunService#findByIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link AttestationRunService#findByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AttestationRunService.findByIdSelector(IdSelectionOptions)"})
  void testFindByIdSelector() {
    // Arrange
    ArrayList<AttestationRun> attestationRunList = new ArrayList<>();
    when(attestationRunDao.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(attestationRunList);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Collection<AttestationRun> actualFindByIdSelectorResult =
        attestationRunService.findByIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(attestationRunDao).findByIdSelector(isA(Select.class));
    assertTrue(actualFindByIdSelectorResult instanceof List);
    assertTrue(actualFindByIdSelectorResult.isEmpty());
    assertSame(attestationRunList, actualFindByIdSelectorResult);
  }

  /**
   * Test {@link AttestationRunService#findByIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#findByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByIdSelector(IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AttestationRunService.findByIdSelector(IdSelectionOptions)"})
  void testFindByIdSelector_givenBuilderAddOmitApplicationKindsInHouse_thenReturnList() {
    // Arrange
    ArrayList<AttestationRun> attestationRunList = new ArrayList<>();
    when(attestationRunDao.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(attestationRunList);

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(immutableSelectionFilters);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    Collection<AttestationRun> actualFindByIdSelectorResult =
        attestationRunService.findByIdSelector(options);

    // Assert
    verify(attestationRunDao).findByIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).scope();
    assertTrue(actualFindByIdSelectorResult instanceof List);
    assertTrue(actualFindByIdSelectorResult.isEmpty());
    assertSame(attestationRunList, actualFindByIdSelectorResult);
  }

  /**
   * Test {@link AttestationRunService#findByIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#findByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByIdSelector(IdSelectionOptions); given HashSet() add 'ACTIVE'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AttestationRunService.findByIdSelector(IdSelectionOptions)"})
  void testFindByIdSelector_givenHashSetAddActive_thenReturnList() {
    // Arrange
    ArrayList<AttestationRun> attestationRunList = new ArrayList<>();
    when(attestationRunDao.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(attestationRunList);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    Collection<AttestationRun> actualFindByIdSelectorResult =
        attestationRunService.findByIdSelector(options);

    // Assert
    verify(attestationRunDao).findByIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindByIdSelectorResult instanceof List);
    assertTrue(actualFindByIdSelectorResult.isEmpty());
    assertSame(attestationRunList, actualFindByIdSelectorResult);
  }

  /**
   * Test {@link AttestationRunService#findByIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#findByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByIdSelector(IdSelectionOptions); given HashSet() add 'PENDING'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AttestationRunService.findByIdSelector(IdSelectionOptions)"})
  void testFindByIdSelector_givenHashSetAddPending_thenReturnList() {
    // Arrange
    ArrayList<AttestationRun> attestationRunList = new ArrayList<>();
    when(attestationRunDao.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(attestationRunList);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    Collection<AttestationRun> actualFindByIdSelectorResult =
        attestationRunService.findByIdSelector(options);

    // Assert
    verify(attestationRunDao).findByIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindByIdSelectorResult instanceof List);
    assertTrue(actualFindByIdSelectorResult.isEmpty());
    assertSame(attestationRunList, actualFindByIdSelectorResult);
  }

  /**
   * Test {@link AttestationRunService#findByIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#findByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByIdSelector(IdSelectionOptions); given HashSet(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AttestationRunService.findByIdSelector(IdSelectionOptions)"})
  void testFindByIdSelector_givenHashSet_thenReturnList() {
    // Arrange
    ArrayList<AttestationRun> attestationRunList = new ArrayList<>();
    when(attestationRunDao.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(attestationRunList);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    Collection<AttestationRun> actualFindByIdSelectorResult =
        attestationRunService.findByIdSelector(options);

    // Assert
    verify(attestationRunDao).findByIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindByIdSelectorResult instanceof List);
    assertTrue(actualFindByIdSelectorResult.isEmpty());
    assertSame(attestationRunList, actualFindByIdSelectorResult);
  }

  /**
   * Test {@link AttestationRunService#findByIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#findByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByIdSelector(IdSelectionOptions); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection AttestationRunService.findByIdSelector(IdSelectionOptions)"})
  void testFindByIdSelector_thenThrowIllegalArgumentException() {
    // Arrange
    when(attestationRunDao.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new IllegalArgumentException());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> attestationRunService.findByIdSelector(options));
    verify(attestationRunDao).findByIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
  }

  /**
   * Test {@link AttestationRunService#issueInstancesForPendingRuns()}.
   *
   * <p>Method under test: {@link AttestationRunService#issueInstancesForPendingRuns()}
   */
  @Test
  @DisplayName("Test issueInstancesForPendingRuns()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunService.issueInstancesForPendingRuns()"})
  void testIssueInstancesForPendingRuns() {
    // Arrange
    when(attestationRunDao.findPendingRuns()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> attestationRunService.issueInstancesForPendingRuns());
    verify(attestationRunDao).findPendingRuns();
  }

  /**
   * Test {@link AttestationRunService#issueInstancesForPendingRuns()}.
   *
   * <p>Method under test: {@link AttestationRunService#issueInstancesForPendingRuns()}
   */
  @Test
  @DisplayName("Test issueInstancesForPendingRuns()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunService.issueInstancesForPendingRuns()"})
  void testIssueInstancesForPendingRuns2() {
    // Arrange
    HashSet<AttestationRun> attestationRunSet = new HashSet<>();

    ImmutableAttestationRun.Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    ImmutableAttestationRun.Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    ImmutableAttestationRun.Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    attestationRunSet.add(
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
    when(attestationRunDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
    when(attestationRunDao.findPendingRuns()).thenReturn(attestationRunSet);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> attestationRunService.issueInstancesForPendingRuns());
    verify(attestationRunDao).findPendingRuns();
    verify(attestationRunDao).getById(1L);
  }

  /**
   * Test {@link AttestationRunService#issueInstancesForPendingRuns()}.
   *
   * <ul>
   *   <li>Then calls {@link AttestationRunDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#issueInstancesForPendingRuns()}
   */
  @Test
  @DisplayName("Test issueInstancesForPendingRuns(); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunService.issueInstancesForPendingRuns()"})
  void testIssueInstancesForPendingRuns_thenCallsGetById() {
    // Arrange
    HashSet<AttestationRun> attestationRunSet = new HashSet<>();

    ImmutableAttestationRun.Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef = Optional.of(immutableEntityReference);

    ImmutableAttestationRun.Builder dueDateResult =
        attestedEntityKindResult
            .attestedEntityRef(attestedEntityRef)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    ImmutableAttestationRun.Builder provenanceResult =
        dueDateResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    attestationRunSet.add(
        provenanceResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(AttestationStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());

    ImmutableAttestationRun.Builder attestedEntityKindResult2 =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> attestedEntityRef2 = Optional.of(immutableEntityReference2);

    ImmutableAttestationRun.Builder dueDateResult2 =
        attestedEntityKindResult2
            .attestedEntityRef(attestedEntityRef2)
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1));

    ImmutableAttestationRun.Builder provenanceResult2 =
        dueDateResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .issuedBy("Issued By")
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .provenance("Provenance");

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);
    when(attestationRunDao.getById(anyLong()))
        .thenReturn(
            provenanceResult2
                .selectionOptions(
                    joiningEntityKindResult2
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(AttestationStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    when(attestationRunDao.findPendingRuns()).thenReturn(attestationRunSet);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> attestationRunService.issueInstancesForPendingRuns());
    verify(attestationRunDao).findPendingRuns();
    verify(attestationRunDao).getById(1L);
  }

  /**
   * Test {@link AttestationRunService#issueInstancesForPendingRuns()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#issueInstancesForPendingRuns()}
   */
  @Test
  @DisplayName("Test issueInstancesForPendingRuns(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationRunService.issueInstancesForPendingRuns()"})
  void testIssueInstancesForPendingRuns_thenReturnOne() {
    // Arrange
    when(attestationRunDao.updateStatusForRunIds(
            Mockito.<Set<Long>>any(), Mockito.<AttestationStatus>any()))
        .thenReturn(1);
    when(attestationRunDao.findPendingRuns()).thenReturn(new HashSet<>());

    // Act
    int actualIssueInstancesForPendingRunsResult =
        attestationRunService.issueInstancesForPendingRuns();

    // Assert
    verify(attestationRunDao).findPendingRuns();
    verify(attestationRunDao, atLeast(1))
        .updateStatusForRunIds(isA(Set.class), Mockito.<AttestationStatus>any());
    assertEquals(1, actualIssueInstancesForPendingRunsResult);
  }

  /**
   * Test {@link AttestationRunService#createRecipientsGroup(long, String, Set, String)}.
   *
   * <p>Method under test: {@link AttestationRunService#createRecipientsGroup(long, String, Set,
   * String)}
   */
  @Test
  @DisplayName("Test createRecipientsGroup(long, String, Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AttestationRunService.createRecipientsGroup(long, String, Set, String)"})
  void testCreateRecipientsGroup() {
    // Arrange
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    // Act
    attestationRunService.createRecipientsGroup(1L, "Run Name", new HashSet<>(), "janedoe");

    // Assert
    verify(attestationRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(involvementGroupService)
        .createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Test {@link AttestationRunService#createRecipientsGroup(long, String, Set, String)}.
   *
   * <p>Method under test: {@link AttestationRunService#createRecipientsGroup(long, String, Set,
   * String)}
   */
  @Test
  @DisplayName("Test createRecipientsGroup(long, String, Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AttestationRunService.createRecipientsGroup(long, String, Set, String)"})
  void testCreateRecipientsGroup2() {
    // Arrange
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationRunService.createRecipientsGroup(
                1L, "Run Name", new HashSet<>(), "janedoe"));
    verify(attestationRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(involvementGroupService)
        .createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Test {@link AttestationRunService#createRecipientsGroup(long, String, Set, String)}.
   *
   * <ul>
   *   <li>Given {@link AttestationRunDao}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#createRecipientsGroup(long, String, Set,
   * String)}
   */
  @Test
  @DisplayName("Test createRecipientsGroup(long, String, Set, String); given AttestationRunDao")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AttestationRunService.createRecipientsGroup(long, String, Set, String)"})
  void testCreateRecipientsGroup_givenAttestationRunDao() {
    // Arrange
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            attestationRunService.createRecipientsGroup(
                1L, "Run Name", new HashSet<>(), "janedoe"));
    verify(involvementGroupService)
        .createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Test {@link AttestationRunService#createRecipientsGroup(long, String, Set, String)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#createRecipientsGroup(long, String, Set,
   * String)}
   */
  @Test
  @DisplayName(
      "Test createRecipientsGroup(long, String, Set, String); given one; when HashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AttestationRunService.createRecipientsGroup(long, String, Set, String)"})
  void testCreateRecipientsGroup_givenOne_whenHashSetAddOne() {
    // Arrange
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(1L);
    involvementKindIds.add(3L);

    // Act
    attestationRunService.createRecipientsGroup(1L, "Run Name", involvementKindIds, "janedoe");

    // Assert
    verify(attestationRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(involvementGroupService)
        .createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Test {@link AttestationRunService#createRecipientsGroup(long, String, Set, String)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>When {@link HashSet#HashSet()} add three.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#createRecipientsGroup(long, String, Set,
   * String)}
   */
  @Test
  @DisplayName(
      "Test createRecipientsGroup(long, String, Set, String); given three; when HashSet() add three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AttestationRunService.createRecipientsGroup(long, String, Set, String)"})
  void testCreateRecipientsGroup_givenThree_whenHashSetAddThree() {
    // Arrange
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);
    when(involvementGroupService.createGroup(
            Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(3L);

    // Act
    attestationRunService.createRecipientsGroup(1L, "Run Name", involvementKindIds, "janedoe");

    // Assert
    verify(attestationRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(involvementGroupService)
        .createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Test {@link AttestationRunService#createRecipientsGroup(long, String, Set, String)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       InvolvementGroupDao#createInvolvementGroup(InvolvementGroupCreateCommand)}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#createRecipientsGroup(long, String, Set,
   * String)}
   */
  @Test
  @DisplayName(
      "Test createRecipientsGroup(long, String, Set, String); then calls createInvolvementGroup(InvolvementGroupCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AttestationRunService.createRecipientsGroup(long, String, Set, String)"})
  void testCreateRecipientsGroup_thenCallsCreateInvolvementGroup() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);

    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any()))
        .thenReturn(1L);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(involvementGroupDao);

    AttestationRunService attestationRunService =
        new AttestationRunService(
            mock(AttestationInstanceDao.class),
            mock(AttestationInstanceRecipientDao.class),
            attestationRunDao,
            mock(EntityReferenceNameResolver.class),
            mock(InvolvementDao.class),
            involvementGroupService);

    // Act
    attestationRunService.createRecipientsGroup(1L, "Run Name", new HashSet<>(), "janedoe");

    // Assert
    verify(attestationRunDao).updateRecipientInvolvementGroupId(1L, 1L);
    verify(involvementGroupDao).createInvolvementGroup(isA(InvolvementGroupCreateCommand.class));
  }

  /**
   * Test {@link AttestationRunService#findRunRecipients(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#findRunRecipients(long)}
   */
  @Test
  @DisplayName("Test findRunRecipients(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AttestationRunService.findRunRecipients(long)"})
  void testFindRunRecipients_thenReturnEmpty() {
    // Arrange
    when(attestationRunDao.findRunRecipients(anyLong())).thenReturn(new HashSet<>());

    // Act
    Set<AttestationRunRecipient> actualFindRunRecipientsResult =
        attestationRunService.findRunRecipients(1L);

    // Assert
    verify(attestationRunDao).findRunRecipients(1L);
    assertTrue(actualFindRunRecipientsResult.isEmpty());
  }

  /**
   * Test {@link AttestationRunService#findRunRecipients(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationRunService#findRunRecipients(long)}
   */
  @Test
  @DisplayName("Test findRunRecipients(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AttestationRunService.findRunRecipients(long)"})
  void testFindRunRecipients_thenThrowIllegalArgumentException() {
    // Arrange
    when(attestationRunDao.findRunRecipients(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> attestationRunService.findRunRecipients(1L));
    verify(attestationRunDao).findRunRecipients(1L);
  }
}
