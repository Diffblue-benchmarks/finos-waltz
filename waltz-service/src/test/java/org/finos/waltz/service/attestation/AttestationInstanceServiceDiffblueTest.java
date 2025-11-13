package org.finos.waltz.service.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.common.exception.UpdateFailedException;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.application.search.ApplicationSearchDao;
import org.finos.waltz.data.attestation.AttestationInstanceDao;
import org.finos.waltz.data.attestation.AttestationInstanceRecipientDao;
import org.finos.waltz.data.attestation.AttestationPreCheckDao;
import org.finos.waltz.data.attestation.AttestationRunDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.entity_alias.EntityAliasDao;
import org.finos.waltz.data.involvement.InvolvementDao;
import org.finos.waltz.data.involvement_group.InvolvementGroupDao;
import org.finos.waltz.data.involvement_kind.InvolvementKindDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.permission.PermissionGroupDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdCommandResponse;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.attestation.ApplicationAttestationInstanceInfo;
import org.finos.waltz.model.attestation.ApplicationAttestationInstanceSummary;
import org.finos.waltz.model.attestation.ApplicationAttestationSummaryCounts;
import org.finos.waltz.model.attestation.AttestEntityCommand;
import org.finos.waltz.model.attestation.AttestationInstance;
import org.finos.waltz.model.attestation.AttestationState;
import org.finos.waltz.model.attestation.AttestationStatus;
import org.finos.waltz.model.attestation.ImmutableApplicationAttestationInstanceInfo;
import org.finos.waltz.model.attestation.ImmutableApplicationAttestationSummaryFilters;
import org.finos.waltz.model.attestation.ImmutableAttestEntityCommand;
import org.finos.waltz.model.attestation.ImmutableAttestationInstance;
import org.finos.waltz.model.attestation.ImmutableAttestationRun;
import org.finos.waltz.model.attestation.ImmutableSyncRecipientsResponse;
import org.finos.waltz.model.attestation.LatestMeasurableAttestationInfo;
import org.finos.waltz.model.attestation.SyncRecipientsResponse;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.permission_group.CheckPermissionCommand;
import org.finos.waltz.model.permission_group.ImmutableRequiredInvolvementsResult;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.involvement_group.InvolvementGroupService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.finos.waltz.service.permission.PermissionGroupService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.tag.TagService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.Condition;
import org.jooq.DSLContext;
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
class AttestationInstanceServiceDiffblueTest {
  @Mock private AttestationInstanceDao attestationInstanceDao;

  @InjectMocks private AttestationInstanceService attestationInstanceService;

  @Mock private AttestationRunService attestationRunService;

  @Mock private ChangeLogService changeLogService;

  @Mock private EntityReferenceNameResolver entityReferenceNameResolver;

  @Mock private PermissionGroupService permissionGroupService;

  @Mock private PersonDao personDao;

  /**
   * Test {@link AttestationInstanceService#findByRecipient(String, boolean)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#findByRecipient(String, boolean)}
   */
  @Test
  @DisplayName("Test findByRecipient(String, boolean); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationInstanceService.findByRecipient(String, boolean)"})
  void testFindByRecipient_thenReturnEmpty() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findByRecipient(Mockito.<String>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    // Act
    List<AttestationInstance> actualFindByRecipientResult =
        attestationInstanceService.findByRecipient("42", true);

    // Assert
    verify(attestationInstanceDao).findByRecipient("42", true);
    assertTrue(actualFindByRecipientResult.isEmpty());
  }

  /**
   * Test {@link AttestationInstanceService#findByRecipient(String, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#findByRecipient(String, boolean)}
   */
  @Test
  @DisplayName("Test findByRecipient(String, boolean); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationInstanceService.findByRecipient(String, boolean)"})
  void testFindByRecipient_thenThrowUpdateFailedException() {
    // Arrange
    when(attestationInstanceDao.findByRecipient(Mockito.<String>any(), anyBoolean()))
        .thenThrow(new UpdateFailedException("userId cannot be null", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class, () -> attestationInstanceService.findByRecipient("42", true));
    verify(attestationInstanceDao).findByRecipient("42", true);
  }

  /**
   * Test {@link AttestationInstanceService#findHistoricalForPendingByUserId(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findHistoricalForPendingByUserId(String)}
   */
  @Test
  @DisplayName("Test findHistoricalForPendingByUserId(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationInstanceService.findHistoricalForPendingByUserId(String)"})
  void testFindHistoricalForPendingByUserId_thenReturnEmpty() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findHistoricalForPendingByUserId(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    // Act
    List<AttestationInstance> actualFindHistoricalForPendingByUserIdResult =
        attestationInstanceService.findHistoricalForPendingByUserId("42");

    // Assert
    verify(attestationInstanceDao).findHistoricalForPendingByUserId("42");
    assertTrue(actualFindHistoricalForPendingByUserIdResult.isEmpty());
  }

  /**
   * Test {@link AttestationInstanceService#findHistoricalForPendingByUserId(String)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findHistoricalForPendingByUserId(String)}
   */
  @Test
  @DisplayName("Test findHistoricalForPendingByUserId(String); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationInstanceService.findHistoricalForPendingByUserId(String)"})
  void testFindHistoricalForPendingByUserId_thenThrowUpdateFailedException() {
    // Arrange
    when(attestationInstanceDao.findHistoricalForPendingByUserId(Mockito.<String>any()))
        .thenThrow(new UpdateFailedException("userId cannot be null", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> attestationInstanceService.findHistoricalForPendingByUserId("42"));
    verify(attestationInstanceDao).findHistoricalForPendingByUserId("42");
  }

  /**
   * Test {@link AttestationInstanceService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationInstanceService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenReturnEmpty() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    // Act
    List<AttestationInstance> actualFindByEntityReferenceResult =
        attestationInstanceService.findByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(attestationInstanceDao).findByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link AttestationInstanceService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationInstanceService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenThrowUpdateFailedException() {
    // Arrange
    when(attestationInstanceDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new UpdateFailedException("ref cannot be null", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            attestationInstanceService.findByEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(attestationInstanceDao).findByEntityReference(isA(EntityReference.class));
  }

  /**
   * Test {@link AttestationInstanceService#attestInstance(long, String)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#attestInstance(long, String)}
   */
  @Test
  @DisplayName("Test attestInstance(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttestationInstanceService.attestInstance(long, String)"})
  void testAttestInstance() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenThrow(new UpdateFailedException("attestedBy must be provided", "An error occurred"));
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> attestationInstanceService.attestInstance(1L, "Attested By"));
    verify(attestationInstanceDao)
        .attestInstance(eq(1L), eq("Attested By"), isA(LocalDateTime.class));
  }

  /**
   * Test {@link AttestationInstanceService#attestInstance(long, String)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#attestInstance(long, String)}
   */
  @Test
  @DisplayName("Test attestInstance(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttestationInstanceService.attestInstance(long, String)"})
  void testAttestInstance2() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.getById(anyLong()))
        .thenThrow(new UpdateFailedException("attestedBy must be provided", "An error occurred"));
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenReturn(true);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> attestationInstanceService.attestInstance(1L, "Attested By"));
    verify(attestationInstanceDao)
        .attestInstance(eq(1L), eq("Attested By"), isA(LocalDateTime.class));
    verify(attestationInstanceDao).getById(1L);
  }

  /**
   * Test {@link AttestationInstanceService#attestInstance(long, String)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#attestInstance(long, String)}
   */
  @Test
  @DisplayName("Test attestInstance(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttestationInstanceService.attestInstance(long, String)"})
  void testAttestInstance3() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    when(attestationInstanceDao.getById(anyLong()))
        .thenReturn(
            idResult
                .parentEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenReturn(true);

    AttestationRunService attestationRunService = mock(AttestationRunService.class);

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
    when(attestationRunService.getById(anyLong()))
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

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService2);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService3,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver2,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver,
            personDao,
            permissionGroupService,
            changeLogService);

    // Act
    boolean actualAttestInstanceResult =
        attestationInstanceService.attestInstance(1L, "Attested By");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(EntityReference.class));
    verify(attestationInstanceDao)
        .attestInstance(eq(1L), eq("Attested By"), isA(LocalDateTime.class));
    verify(attestationInstanceDao).getById(1L);
    verify(attestationRunService).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualAttestInstanceResult);
  }

  /**
   * Test {@link AttestationInstanceService#attestInstance(long, String)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#attestInstance(long, String)}
   */
  @Test
  @DisplayName("Test attestInstance(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttestationInstanceService.attestInstance(long, String)"})
  void testAttestInstance4() {
    // Arrange
    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    when(attestationInstanceDao.getById(anyLong()))
        .thenReturn(
            idResult
                .parentEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenReturn(true);
    when(attestationRunService.getById(anyLong()))
        .thenThrow(new UpdateFailedException("attestedBy must be provided", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> attestationInstanceService.attestInstance(1L, "Attested By"));
    verify(attestationInstanceDao)
        .attestInstance(eq(1L), eq("Attested By"), isA(LocalDateTime.class));
    verify(attestationInstanceDao).getById(1L);
    verify(attestationRunService).getById(1L);
  }

  /**
   * Test {@link AttestationInstanceService#attestInstance(long, String)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#attestInstance(long, String)}
   */
  @Test
  @DisplayName("Test attestInstance(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttestationInstanceService.attestInstance(long, String)"})
  void testAttestInstance5() {
    // Arrange
    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    when(attestationInstanceDao.getById(anyLong()))
        .thenReturn(
            idResult
                .parentEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenReturn(true);

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
    when(attestationRunService.getById(anyLong()))
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
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new UpdateFailedException("attestedBy must be provided", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> attestationInstanceService.attestInstance(1L, "Attested By"));
    verify(entityReferenceNameResolver).resolve(isA(EntityReference.class));
    verify(attestationInstanceDao)
        .attestInstance(eq(1L), eq("Attested By"), isA(LocalDateTime.class));
    verify(attestationInstanceDao).getById(1L);
    verify(attestationRunService).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link AttestationInstanceService#attestInstance(long, String)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#attestInstance(long, String)}
   */
  @Test
  @DisplayName("Test attestInstance(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttestationInstanceService.attestInstance(long, String)"})
  void testAttestInstance6() {
    // Arrange
    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    when(attestationInstanceDao.getById(anyLong()))
        .thenReturn(
            idResult
                .parentEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenReturn(true);

    ImmutableAttestationRun.Builder attestedEntityKindResult =
        ImmutableAttestationRun.builder().attestedEntityKind(EntityKind.ALL);
    Optional<? extends EntityReference> attestedEntityRef = Optional.empty();

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
    when(attestationRunService.getById(anyLong()))
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
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualAttestInstanceResult =
        attestationInstanceService.attestInstance(1L, "Attested By");

    // Assert
    verify(attestationInstanceDao)
        .attestInstance(eq(1L), eq("Attested By"), isA(LocalDateTime.class));
    verify(attestationInstanceDao).getById(1L);
    verify(attestationRunService).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualAttestInstanceResult);
  }

  /**
   * Test {@link AttestationInstanceService#attestInstance(long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link AttestationRunDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#attestInstance(long, String)}
   */
  @Test
  @DisplayName("Test attestInstance(long, String); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttestationInstanceService.attestInstance(long, String)"})
  void testAttestInstance_thenCallsGetById() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    when(attestationInstanceDao.getById(anyLong()))
        .thenReturn(
            idResult
                .parentEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenReturn(true);

    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);

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
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);

    EntityReferenceNameResolver entityReferenceNameResolver2 =
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
    when(entityReferenceNameResolver2.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService2);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService3,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService);

    // Act
    boolean actualAttestInstanceResult =
        attestationInstanceService.attestInstance(1L, "Attested By");

    // Assert
    verify(entityReferenceNameResolver2).resolve(isA(EntityReference.class));
    verify(attestationInstanceDao)
        .attestInstance(eq(1L), eq("Attested By"), isA(LocalDateTime.class));
    verify(attestationInstanceDao).getById(1L);
    verify(attestationRunDao).getById(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    assertTrue(actualAttestInstanceResult);
  }

  /**
   * Test {@link AttestationInstanceService#attestInstance(long, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#attestInstance(long, String)}
   */
  @Test
  @DisplayName("Test attestInstance(long, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AttestationInstanceService.attestInstance(long, String)"})
  void testAttestInstance_thenReturnFalse() {
    // Arrange
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenReturn(false);

    // Act
    boolean actualAttestInstanceResult =
        attestationInstanceService.attestInstance(1L, "Attested By");

    // Assert
    verify(attestationInstanceDao)
        .attestInstance(eq(1L), eq("Attested By"), isA(LocalDateTime.class));
    assertFalse(actualAttestInstanceResult);
  }

  /**
   * Test {@link AttestationInstanceService#findByRunId(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#findByRunId(long)}
   */
  @Test
  @DisplayName("Test findByRunId(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationInstanceService.findByRunId(long)"})
  void testFindByRunId_thenReturnEmpty() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findByRunId(anyLong())).thenReturn(new ArrayList<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    // Act
    List<AttestationInstance> actualFindByRunIdResult = attestationInstanceService.findByRunId(1L);

    // Assert
    verify(attestationInstanceDao).findByRunId(1L);
    assertTrue(actualFindByRunIdResult.isEmpty());
  }

  /**
   * Test {@link AttestationInstanceService#findByRunId(long)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#findByRunId(long)}
   */
  @Test
  @DisplayName("Test findByRunId(long); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationInstanceService.findByRunId(long)"})
  void testFindByRunId_thenThrowUpdateFailedException() {
    // Arrange
    when(attestationInstanceDao.findByRunId(anyLong()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(UpdateFailedException.class, () -> attestationInstanceService.findByRunId(1L));
    verify(attestationInstanceDao).findByRunId(1L);
  }

  /**
   * Test {@link AttestationInstanceService#findPersonsByInstanceId(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#findPersonsByInstanceId(long)}
   */
  @Test
  @DisplayName("Test findPersonsByInstanceId(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationInstanceService.findPersonsByInstanceId(long)"})
  void testFindPersonsByInstanceId_thenReturnEmpty() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findPersonsByAttestationInstanceId(anyLong())).thenReturn(new ArrayList<>());
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    // Act
    List<Person> actualFindPersonsByInstanceIdResult =
        attestationInstanceService.findPersonsByInstanceId(1L);

    // Assert
    verify(personDao).findPersonsByAttestationInstanceId(1L);
    assertTrue(actualFindPersonsByInstanceIdResult.isEmpty());
  }

  /**
   * Test {@link AttestationInstanceService#findPersonsByInstanceId(long)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#findPersonsByInstanceId(long)}
   */
  @Test
  @DisplayName("Test findPersonsByInstanceId(long); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationInstanceService.findPersonsByInstanceId(long)"})
  void testFindPersonsByInstanceId_thenThrowUpdateFailedException() {
    // Arrange
    when(personDao.findPersonsByAttestationInstanceId(anyLong()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class, () -> attestationInstanceService.findPersonsByInstanceId(1L));
    verify(personDao).findPersonsByAttestationInstanceId(1L);
  }

  /**
   * Test {@link AttestationInstanceService#findByIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#findByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationInstanceService.findByIdSelector(IdSelectionOptions)"})
  void testFindByIdSelector() {
    // Arrange
    when(attestationInstanceDao.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<AttestationInstance> actualFindByIdSelectorResult =
        attestationInstanceService.findByIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(attestationInstanceDao).findByIdSelector(isA(Select.class));
    assertTrue(actualFindByIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link AttestationInstanceService#findByIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#findByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByIdSelector(IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationInstanceService.findByIdSelector(IdSelectionOptions)"})
  void testFindByIdSelector_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    when(attestationInstanceDao.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<AttestationInstance> actualFindByIdSelectorResult =
        attestationInstanceService.findByIdSelector(options);

    // Assert
    verify(attestationInstanceDao).findByIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).scope();
    assertTrue(actualFindByIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link AttestationInstanceService#findByIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#findByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByIdSelector(IdSelectionOptions); given HashSet() add 'ACTIVE'; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationInstanceService.findByIdSelector(IdSelectionOptions)"})
  void testFindByIdSelector_givenHashSetAddActive_thenCallsEntityLifecycleStatuses() {
    // Arrange
    when(attestationInstanceDao.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<AttestationInstance> actualFindByIdSelectorResult =
        attestationInstanceService.findByIdSelector(options);

    // Assert
    verify(attestationInstanceDao).findByIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindByIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link AttestationInstanceService#findByIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#findByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByIdSelector(IdSelectionOptions); given HashSet() add 'PENDING'; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationInstanceService.findByIdSelector(IdSelectionOptions)"})
  void testFindByIdSelector_givenHashSetAddPending_thenCallsEntityLifecycleStatuses() {
    // Arrange
    when(attestationInstanceDao.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<AttestationInstance> actualFindByIdSelectorResult =
        attestationInstanceService.findByIdSelector(options);

    // Assert
    verify(attestationInstanceDao).findByIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindByIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link AttestationInstanceService#findByIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#findByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByIdSelector(IdSelectionOptions); given HashSet(); then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationInstanceService.findByIdSelector(IdSelectionOptions)"})
  void testFindByIdSelector_givenHashSet_thenCallsEntityLifecycleStatuses() {
    // Arrange
    when(attestationInstanceDao.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<AttestationInstance> actualFindByIdSelectorResult =
        attestationInstanceService.findByIdSelector(options);

    // Assert
    verify(attestationInstanceDao).findByIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindByIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link AttestationInstanceService#findByIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code INTERNALLY_HOSTED}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#findByIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByIdSelector(IdSelectionOptions); given 'INTERNALLY_HOSTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AttestationInstanceService.findByIdSelector(IdSelectionOptions)"})
  void testFindByIdSelector_givenInternallyHosted() {
    // Arrange
    when(attestationInstanceDao.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<AttestationInstance> actualFindByIdSelectorResult =
        attestationInstanceService.findByIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(attestationInstanceDao).findByIdSelector(isA(Select.class));
    assertTrue(actualFindByIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link AttestationInstanceService#cleanupOrphans()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#cleanupOrphans()}
   */
  @Test
  @DisplayName("Test cleanupOrphans(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationInstanceService.cleanupOrphans()"})
  void testCleanupOrphans_thenReturnOne() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.cleanupOrphans()).thenReturn(1);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    // Act
    int actualCleanupOrphansResult = attestationInstanceService.cleanupOrphans();

    // Assert
    verify(attestationInstanceDao).cleanupOrphans();
    assertEquals(1, actualCleanupOrphansResult);
  }

  /**
   * Test {@link AttestationInstanceService#cleanupOrphans()}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#cleanupOrphans()}
   */
  @Test
  @DisplayName("Test cleanupOrphans(); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AttestationInstanceService.cleanupOrphans()"})
  void testCleanupOrphans_thenThrowUpdateFailedException() {
    // Arrange
    when(attestationInstanceDao.cleanupOrphans())
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(UpdateFailedException.class, () -> attestationInstanceService.cleanupOrphans());
    verify(attestationInstanceDao).cleanupOrphans();
  }

  /**
   * Test {@link AttestationInstanceService#reassignRecipients()}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableSyncRecipientsResponse}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#reassignRecipients()}
   */
  @Test
  @DisplayName("Test reassignRecipients(); then return ImmutableSyncRecipientsResponse")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SyncRecipientsResponse AttestationInstanceService.reassignRecipients()"})
  void testReassignRecipients_thenReturnImmutableSyncRecipientsResponse() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.reassignRecipients())
        .thenReturn(
            ImmutableSyncRecipientsResponse.builder()
                .recipientsCreatedCount(3L)
                .recipientsRemovedCount(3L)
                .build());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    // Act
    SyncRecipientsResponse actualReassignRecipientsResult =
        attestationInstanceService.reassignRecipients();

    // Assert
    verify(attestationInstanceDao).reassignRecipients();
    assertTrue(actualReassignRecipientsResult instanceof ImmutableSyncRecipientsResponse);
    assertEquals(3L, actualReassignRecipientsResult.recipientsCreatedCount().longValue());
    assertEquals(3L, actualReassignRecipientsResult.recipientsRemovedCount().longValue());
  }

  /**
   * Test {@link AttestationInstanceService#reassignRecipients()}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#reassignRecipients()}
   */
  @Test
  @DisplayName("Test reassignRecipients(); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SyncRecipientsResponse AttestationInstanceService.reassignRecipients()"})
  void testReassignRecipients_thenThrowUpdateFailedException() {
    // Arrange
    when(attestationInstanceDao.reassignRecipients())
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class, () -> attestationInstanceService.reassignRecipients());
    verify(attestationInstanceDao).reassignRecipients();
  }

  /**
   * Test {@link AttestationInstanceService#getCountsOfRecipientsToReassign()}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableSyncRecipientsResponse}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#getCountsOfRecipientsToReassign()}
   */
  @Test
  @DisplayName(
      "Test getCountsOfRecipientsToReassign(); then return ImmutableSyncRecipientsResponse")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SyncRecipientsResponse AttestationInstanceService.getCountsOfRecipientsToReassign()"
  })
  void testGetCountsOfRecipientsToReassign_thenReturnImmutableSyncRecipientsResponse() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.getCountsOfRecipientsToReassign())
        .thenReturn(
            ImmutableSyncRecipientsResponse.builder()
                .recipientsCreatedCount(3L)
                .recipientsRemovedCount(3L)
                .build());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    // Act
    SyncRecipientsResponse actualCountsOfRecipientsToReassign =
        attestationInstanceService.getCountsOfRecipientsToReassign();

    // Assert
    verify(attestationInstanceDao).getCountsOfRecipientsToReassign();
    assertTrue(actualCountsOfRecipientsToReassign instanceof ImmutableSyncRecipientsResponse);
    assertEquals(3L, actualCountsOfRecipientsToReassign.recipientsCreatedCount().longValue());
    assertEquals(3L, actualCountsOfRecipientsToReassign.recipientsRemovedCount().longValue());
  }

  /**
   * Test {@link AttestationInstanceService#getCountsOfRecipientsToReassign()}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#getCountsOfRecipientsToReassign()}
   */
  @Test
  @DisplayName("Test getCountsOfRecipientsToReassign(); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SyncRecipientsResponse AttestationInstanceService.getCountsOfRecipientsToReassign()"
  })
  void testGetCountsOfRecipientsToReassign_thenThrowUpdateFailedException() {
    // Arrange
    when(attestationInstanceDao.getCountsOfRecipientsToReassign())
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> attestationInstanceService.getCountsOfRecipientsToReassign());
    verify(attestationInstanceDao).getCountsOfRecipientsToReassign();
  }

  /**
   * Test {@link AttestationInstanceService#attestForEntity(String, AttestEntityCommand)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#attestForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test attestForEntity(String, AttestEntityCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttestationInstanceService.attestForEntity(String, AttestEntityCommand)"
  })
  void testAttestForEntity() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findForEntityByRecipient(
            Mockito.<AttestEntityCommand>any(), Mockito.<String>any(), anyBoolean()))
        .thenThrow(new UpdateFailedException("parentEntityRef", "An error occurred"));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.getRequiredInvolvements(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver2,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService2);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver3,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            attestationInstanceService.attestForEntity(
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
    verify(attestationInstanceDao)
        .findForEntityByRecipient(isA(AttestEntityCommand.class), eq("janedoe"), eq(true));
    verify(permissionGroupDao).getRequiredInvolvements(isA(CheckPermissionCommand.class));
  }

  /**
   * Test {@link AttestationInstanceService#attestForEntity(String, AttestEntityCommand)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#attestForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test attestForEntity(String, AttestEntityCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttestationInstanceService.attestForEntity(String, AttestEntityCommand)"
  })
  void testAttestForEntity2() {
    // Arrange
    ArrayList<AttestationInstance> attestationInstanceList = new ArrayList<>();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    attestationInstanceList.add(
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenThrow(new UpdateFailedException("parentEntityRef", "An error occurred"));
    when(attestationInstanceDao.findForEntityByRecipient(
            Mockito.<AttestEntityCommand>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(attestationInstanceList);

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.getRequiredInvolvements(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver2,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService2);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver3,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act
    boolean actualAttestForEntityResult =
        attestationInstanceService.attestForEntity(
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
                .build());

    // Assert
    verify(attestationInstanceDao).attestInstance(eq(1L), eq("janedoe"), isA(LocalDateTime.class));
    verify(attestationInstanceDao)
        .findForEntityByRecipient(isA(AttestEntityCommand.class), eq("janedoe"), eq(true));
    verify(permissionGroupDao).getRequiredInvolvements(isA(CheckPermissionCommand.class));
    assertTrue(actualAttestForEntityResult);
  }

  /**
   * Test {@link AttestationInstanceService#attestForEntity(String, AttestEntityCommand)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#attestForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test attestForEntity(String, AttestEntityCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttestationInstanceService.attestForEntity(String, AttestEntityCommand)"
  })
  void testAttestForEntity3() {
    // Arrange
    ArrayList<AttestationInstance> attestationInstanceList = new ArrayList<>();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    attestationInstanceList.add(
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.getById(anyLong()))
        .thenThrow(new UpdateFailedException("parentEntityRef", "An error occurred"));
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenReturn(true);
    when(attestationInstanceDao.findForEntityByRecipient(
            Mockito.<AttestEntityCommand>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(attestationInstanceList);

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.getRequiredInvolvements(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver2,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService2);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver3,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act
    boolean actualAttestForEntityResult =
        attestationInstanceService.attestForEntity(
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
                .build());

    // Assert
    verify(attestationInstanceDao).attestInstance(eq(1L), eq("janedoe"), isA(LocalDateTime.class));
    verify(attestationInstanceDao)
        .findForEntityByRecipient(isA(AttestEntityCommand.class), eq("janedoe"), eq(true));
    verify(attestationInstanceDao).getById(1L);
    verify(permissionGroupDao).getRequiredInvolvements(isA(CheckPermissionCommand.class));
    assertTrue(actualAttestForEntityResult);
  }

  /**
   * Test {@link AttestationInstanceService#attestForEntity(String, AttestEntityCommand)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#attestForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test attestForEntity(String, AttestEntityCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttestationInstanceService.attestForEntity(String, AttestEntityCommand)"
  })
  void testAttestForEntity4() {
    // Arrange
    ArrayList<AttestationInstance> attestationInstanceList = new ArrayList<>();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    attestationInstanceList.add(
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);

    ImmutableAttestationInstance.Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    when(attestationInstanceDao.getById(anyLong()))
        .thenReturn(
            idResult2
                .parentEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenReturn(true);
    when(attestationInstanceDao.findForEntityByRecipient(
            Mockito.<AttestEntityCommand>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(attestationInstanceList);

    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);

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
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);

    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver2.resolve(Mockito.<EntityReference>any()))
        .thenThrow(new UpdateFailedException("parentEntityRef", "An error occurred"));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.getRequiredInvolvements(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService2);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult2 =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act
    boolean actualAttestForEntityResult =
        attestationInstanceService.attestForEntity(
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
                .build());

    // Assert
    verify(entityReferenceNameResolver2).resolve(isA(EntityReference.class));
    verify(attestationInstanceDao).attestInstance(eq(1L), eq("janedoe"), isA(LocalDateTime.class));
    verify(attestationInstanceDao)
        .findForEntityByRecipient(isA(AttestEntityCommand.class), eq("janedoe"), eq(true));
    verify(attestationInstanceDao).getById(1L);
    verify(attestationRunDao).getById(1L);
    verify(permissionGroupDao).getRequiredInvolvements(isA(CheckPermissionCommand.class));
    assertTrue(actualAttestForEntityResult);
  }

  /**
   * Test {@link AttestationInstanceService#attestForEntity(String, AttestEntityCommand)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#attestForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test attestForEntity(String, AttestEntityCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttestationInstanceService.attestForEntity(String, AttestEntityCommand)"
  })
  void testAttestForEntity5() {
    // Arrange
    ArrayList<AttestationInstance> attestationInstanceList = new ArrayList<>();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    attestationInstanceList.add(
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);

    ImmutableAttestationInstance.Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    when(attestationInstanceDao.getById(anyLong()))
        .thenReturn(
            idResult2
                .parentEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenReturn(true);
    when(attestationInstanceDao.findForEntityByRecipient(
            Mockito.<AttestEntityCommand>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(attestationInstanceList);

    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);

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
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);

    EntityReferenceNameResolver entityReferenceNameResolver2 =
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
    when(entityReferenceNameResolver2.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.getRequiredInvolvements(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenThrow(new UpdateFailedException("parentEntityRef", "An error occurred"));
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService3);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            mock(PersonDao.class),
            permissionGroupService,
            changeLogService2);

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult2 =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act
    boolean actualAttestForEntityResult =
        attestationInstanceService.attestForEntity(
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
                .build());

    // Assert
    verify(entityReferenceNameResolver2).resolve(isA(EntityReference.class));
    verify(attestationInstanceDao).attestInstance(eq(1L), eq("janedoe"), isA(LocalDateTime.class));
    verify(attestationInstanceDao)
        .findForEntityByRecipient(isA(AttestEntityCommand.class), eq("janedoe"), eq(true));
    verify(attestationInstanceDao).getById(1L);
    verify(attestationRunDao).getById(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(permissionGroupDao).getRequiredInvolvements(isA(CheckPermissionCommand.class));
    assertTrue(actualAttestForEntityResult);
  }

  /**
   * Test {@link AttestationInstanceService#attestForEntity(String, AttestEntityCommand)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#attestForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test attestForEntity(String, AttestEntityCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttestationInstanceService.attestForEntity(String, AttestEntityCommand)"
  })
  void testAttestForEntity6() {
    // Arrange
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any()))
        .thenThrow(new UpdateFailedException("parentEntityRef", "An error occurred"));

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            attestationInstanceService.attestForEntity(
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
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
  }

  /**
   * Test {@link AttestationInstanceService#attestForEntity(String, AttestEntityCommand)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#attestForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test attestForEntity(String, AttestEntityCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttestationInstanceService.attestForEntity(String, AttestEntityCommand)"
  })
  void testAttestForEntity7() {
    // Arrange
    when(attestationInstanceDao.findForEntityByRecipient(
            Mockito.<AttestEntityCommand>any(), Mockito.<String>any(), anyBoolean()))
        .thenThrow(new UpdateFailedException("parentEntityRef", "An error occurred"));
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(true);

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            attestationInstanceService.attestForEntity(
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
    verify(attestationInstanceDao)
        .findForEntityByRecipient(isA(AttestEntityCommand.class), eq("janedoe"), eq(true));
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
  }

  /**
   * Test {@link AttestationInstanceService#attestForEntity(String, AttestEntityCommand)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#attestForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test attestForEntity(String, AttestEntityCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttestationInstanceService.attestForEntity(String, AttestEntityCommand)"
  })
  void testAttestForEntity8() {
    // Arrange
    when(attestationInstanceDao.findForEntityByRecipient(
            Mockito.<AttestEntityCommand>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    when(attestationRunService.createRunForEntity(
            Mockito.<String>any(), Mockito.<AttestEntityCommand>any()))
        .thenThrow(new UpdateFailedException("parentEntityRef", "An error occurred"));
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(true);

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            attestationInstanceService.attestForEntity(
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
    verify(attestationInstanceDao)
        .findForEntityByRecipient(isA(AttestEntityCommand.class), eq("janedoe"), eq(true));
    verify(attestationRunService).createRunForEntity(eq("janedoe"), isA(AttestEntityCommand.class));
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
  }

  /**
   * Test {@link AttestationInstanceService#attestForEntity(String, AttestEntityCommand)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#attestForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test attestForEntity(String, AttestEntityCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttestationInstanceService.attestForEntity(String, AttestEntityCommand)"
  })
  void testAttestForEntity9() {
    // Arrange
    ArrayList<AttestationInstance> attestationInstanceList = new ArrayList<>();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    attestationInstanceList.add(
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenThrow(new UpdateFailedException("parentEntityRef", "An error occurred"));
    when(attestationInstanceDao.findByRunId(anyLong())).thenReturn(attestationInstanceList);
    when(attestationInstanceDao.findForEntityByRecipient(
            Mockito.<AttestEntityCommand>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    when(attestationRunService.createRunForEntity(
            Mockito.<String>any(), Mockito.<AttestEntityCommand>any()))
        .thenReturn(ImmutableIdCommandResponse.builder().id(1L).build());
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(true);

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            attestationInstanceService.attestForEntity(
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
    verify(attestationInstanceDao).attestInstance(eq(1L), eq("janedoe"), isA(LocalDateTime.class));
    verify(attestationInstanceDao).findByRunId(1L);
    verify(attestationInstanceDao)
        .findForEntityByRecipient(isA(AttestEntityCommand.class), eq("janedoe"), eq(true));
    verify(attestationRunService).createRunForEntity(eq("janedoe"), isA(AttestEntityCommand.class));
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
  }

  /**
   * Test {@link AttestationInstanceService#attestForEntity(String, AttestEntityCommand)}.
   *
   * <p>Method under test: {@link AttestationInstanceService#attestForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test attestForEntity(String, AttestEntityCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttestationInstanceService.attestForEntity(String, AttestEntityCommand)"
  })
  void testAttestForEntity10() {
    // Arrange
    ArrayList<AttestationInstance> attestationInstanceList = new ArrayList<>();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    attestationInstanceList.add(
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    ImmutableAttestationInstance.Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    when(attestationInstanceDao.getById(anyLong()))
        .thenReturn(
            idResult2
                .parentEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenReturn(true);
    when(attestationInstanceDao.findByRunId(anyLong())).thenReturn(attestationInstanceList);
    when(attestationInstanceDao.findForEntityByRecipient(
            Mockito.<AttestEntityCommand>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    when(attestationRunService.getById(anyLong()))
        .thenThrow(new UpdateFailedException("parentEntityRef", "An error occurred"));
    when(attestationRunService.createRunForEntity(
            Mockito.<String>any(), Mockito.<AttestEntityCommand>any()))
        .thenReturn(ImmutableIdCommandResponse.builder().id(1L).build());
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(true);

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            attestationInstanceService.attestForEntity(
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
    verify(attestationInstanceDao).attestInstance(eq(1L), eq("janedoe"), isA(LocalDateTime.class));
    verify(attestationInstanceDao).findByRunId(1L);
    verify(attestationInstanceDao)
        .findForEntityByRecipient(isA(AttestEntityCommand.class), eq("janedoe"), eq(true));
    verify(attestationInstanceDao).getById(1L);
    verify(attestationRunService).createRunForEntity(eq("janedoe"), isA(AttestEntityCommand.class));
    verify(attestationRunService).getById(1L);
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
  }

  /**
   * Test {@link AttestationInstanceService#attestForEntity(String, AttestEntityCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#attestForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName(
      "Test attestForEntity(String, AttestEntityCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttestationInstanceService.attestForEntity(String, AttestEntityCommand)"
  })
  void testAttestForEntity_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ArrayList<AttestationInstance> attestationInstanceList = new ArrayList<>();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    attestationInstanceList.add(
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);

    ImmutableAttestationInstance.Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    when(attestationInstanceDao.getById(anyLong()))
        .thenReturn(
            idResult2
                .parentEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenReturn(true);
    when(attestationInstanceDao.findForEntityByRecipient(
            Mockito.<AttestEntityCommand>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(attestationInstanceList);

    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);

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
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);

    EntityReferenceNameResolver entityReferenceNameResolver2 =
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
    when(entityReferenceNameResolver2.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.getRequiredInvolvements(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService3);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            mock(PersonDao.class),
            permissionGroupService,
            changeLogService2);

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult2 =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act
    boolean actualAttestForEntityResult =
        attestationInstanceService.attestForEntity(
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
                .build());

    // Assert
    verify(entityReferenceNameResolver2).resolve(isA(EntityReference.class));
    verify(attestationInstanceDao).attestInstance(eq(1L), eq("janedoe"), isA(LocalDateTime.class));
    verify(attestationInstanceDao)
        .findForEntityByRecipient(isA(AttestEntityCommand.class), eq("janedoe"), eq(true));
    verify(attestationInstanceDao).getById(1L);
    verify(attestationRunDao).getById(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(permissionGroupDao).getRequiredInvolvements(isA(CheckPermissionCommand.class));
    assertTrue(actualAttestForEntityResult);
  }

  /**
   * Test {@link AttestationInstanceService#attestForEntity(String, AttestEntityCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#attestForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName(
      "Test attestForEntity(String, AttestEntityCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttestationInstanceService.attestForEntity(String, AttestEntityCommand)"
  })
  void testAttestForEntity_givenChangeLogDaoWriteReturn19088743_thenCallsWrite2() {
    // Arrange
    ArrayList<AttestationInstance> attestationInstanceList = new ArrayList<>();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    attestationInstanceList.add(
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    ImmutableAttestationInstance.Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    attestationInstanceList.add(
        idResult2
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);

    ImmutableAttestationInstance.Builder idResult3 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    when(attestationInstanceDao.getById(anyLong()))
        .thenReturn(
            idResult3
                .parentEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenReturn(true);
    when(attestationInstanceDao.findForEntityByRecipient(
            Mockito.<AttestEntityCommand>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(attestationInstanceList);

    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);

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
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);

    EntityReferenceNameResolver entityReferenceNameResolver2 =
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
    when(entityReferenceNameResolver2.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult);

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.getRequiredInvolvements(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService3);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            mock(PersonDao.class),
            permissionGroupService,
            changeLogService2);

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult2 =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act
    boolean actualAttestForEntityResult =
        attestationInstanceService.attestForEntity(
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
                .build());

    // Assert
    verify(entityReferenceNameResolver2, atLeast(1)).resolve(isA(EntityReference.class));
    verify(attestationInstanceDao, atLeast(1))
        .attestInstance(eq(1L), eq("janedoe"), Mockito.<LocalDateTime>any());
    verify(attestationInstanceDao)
        .findForEntityByRecipient(isA(AttestEntityCommand.class), eq("janedoe"), eq(true));
    verify(attestationInstanceDao, atLeast(1)).getById(1L);
    verify(attestationRunDao, atLeast(1)).getById(1L);
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(permissionGroupDao).getRequiredInvolvements(isA(CheckPermissionCommand.class));
    assertTrue(actualAttestForEntityResult);
  }

  /**
   * Test {@link AttestationInstanceService#attestForEntity(String, AttestEntityCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link AttestationInstanceService#attestForEntity(String,
   * AttestEntityCommand)}
   */
  @Test
  @DisplayName("Test attestForEntity(String, AttestEntityCommand); then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AttestationInstanceService.attestForEntity(String, AttestEntityCommand)"
  })
  void testAttestForEntity_thenCallsWrite() {
    // Arrange
    ArrayList<AttestationInstance> attestationInstanceList = new ArrayList<>();

    ImmutableAttestationInstance.Builder idResult =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    attestationInstanceList.add(
        idResult
            .parentEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    ImmutableAttestationInstance.Builder idResult2 =
        ImmutableAttestationInstance.builder()
            .attestationRunId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL)
            .id(1L);
    when(attestationInstanceDao.getById(anyLong()))
        .thenReturn(
            idResult2
                .parentEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(attestationInstanceDao.attestInstance(
            anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenReturn(true);
    when(attestationInstanceDao.findByRunId(anyLong())).thenReturn(attestationInstanceList);
    when(attestationInstanceDao.findForEntityByRecipient(
            Mockito.<AttestEntityCommand>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());

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
    when(attestationRunService.getById(anyLong()))
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
    when(attestationRunService.createRunForEntity(
            Mockito.<String>any(), Mockito.<AttestEntityCommand>any()))
        .thenReturn(ImmutableIdCommandResponse.builder().id(1L).build());
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
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ImmutableAttestEntityCommand.Builder attestedEntityKindResult2 =
        ImmutableAttestEntityCommand.builder()
            .attestedEntityId(1L)
            .attestedEntityKind(EntityKind.ALL);

    // Act
    boolean actualAttestForEntityResult =
        attestationInstanceService.attestForEntity(
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
                .build());

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(EntityReference.class));
    verify(attestationInstanceDao).attestInstance(eq(1L), eq("janedoe"), isA(LocalDateTime.class));
    verify(attestationInstanceDao).findByRunId(1L);
    verify(attestationInstanceDao)
        .findForEntityByRecipient(isA(AttestEntityCommand.class), eq("janedoe"), eq(true));
    verify(attestationInstanceDao).getById(1L);
    verify(attestationRunService).createRunForEntity(eq("janedoe"), isA(AttestEntityCommand.class));
    verify(attestationRunService).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
    assertTrue(actualAttestForEntityResult);
  }

  /**
   * Test {@link AttestationInstanceService#findLatestMeasurableAttestations(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findLatestMeasurableAttestations(EntityReference)}
   */
  @Test
  @DisplayName("Test findLatestMeasurableAttestations(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findLatestMeasurableAttestations(EntityReference)"
  })
  void testFindLatestMeasurableAttestations_thenReturnEmpty() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findLatestMeasurableAttestations(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    // Act
    Set<LatestMeasurableAttestationInfo> actualFindLatestMeasurableAttestationsResult =
        attestationInstanceService.findLatestMeasurableAttestations(null);

    // Assert
    verify(attestationInstanceDao).findLatestMeasurableAttestations(isNull());
    assertTrue(actualFindLatestMeasurableAttestationsResult.isEmpty());
  }

  /**
   * Test {@link AttestationInstanceService#findLatestMeasurableAttestations(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findLatestMeasurableAttestations(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findLatestMeasurableAttestations(EntityReference); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findLatestMeasurableAttestations(EntityReference)"
  })
  void testFindLatestMeasurableAttestations_thenThrowUpdateFailedException() {
    // Arrange
    when(attestationInstanceDao.findLatestMeasurableAttestations(Mockito.<EntityReference>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () -> attestationInstanceService.findLatestMeasurableAttestations(null));
    verify(attestationInstanceDao).findLatestMeasurableAttestations(isNull());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)"
  })
  void testFindApplicationAttestationInstancesForKindAndSelector() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findApplicationAttestationInstancesForKindAndSelector(
            Mockito.<EntityKind>any(),
            Mockito.<Long>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ApplicationAttestationInstanceSummary>
        actualFindApplicationAttestationInstancesForKindAndSelectorResult =
            attestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(
                EntityKind.ALL,
                1L,
                filtersResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .build());

    // Assert
    verify(attestationInstanceDao)
        .findApplicationAttestationInstancesForKindAndSelector(
            eq(EntityKind.ALL), eq(1L), isA(Select.class), isA(Condition.class));
    assertTrue(actualFindApplicationAttestationInstancesForKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)"
  })
  void testFindApplicationAttestationInstancesForKindAndSelector2() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findApplicationAttestationInstancesForKindAndSelector(
            Mockito.<EntityKind>any(),
            Mockito.<Long>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Condition>any()))
        .thenThrow(new UpdateFailedException("attested_at", "An error occurred"));
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            attestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(
                EntityKind.ALL,
                1L,
                filtersResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .build()));
    verify(attestationInstanceDao)
        .findApplicationAttestationInstancesForKindAndSelector(
            eq(EntityKind.ALL), eq(1L), isA(Select.class), isA(Condition.class));
  }

  /**
   * Test {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)"
  })
  void testFindApplicationAttestationInstancesForKindAndSelector3() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findApplicationAttestationInstancesForKindAndSelector(
            Mockito.<EntityKind>any(),
            Mockito.<Long>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState =
        Optional.of(AttestationState.NEVER_ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ApplicationAttestationInstanceSummary>
        actualFindApplicationAttestationInstancesForKindAndSelectorResult =
            attestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(
                EntityKind.ALL,
                1L,
                filtersResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .build());

    // Assert
    verify(attestationInstanceDao)
        .findApplicationAttestationInstancesForKindAndSelector(
            eq(EntityKind.ALL), eq(1L), isA(Select.class), isA(Condition.class));
    assertTrue(actualFindApplicationAttestationInstancesForKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)"
  })
  void testFindApplicationAttestationInstancesForKindAndSelector4() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findApplicationAttestationInstancesForKindAndSelector(
            Mockito.<EntityKind>any(),
            Mockito.<Long>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.empty();

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ApplicationAttestationInstanceSummary>
        actualFindApplicationAttestationInstancesForKindAndSelectorResult =
            attestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(
                EntityKind.ALL,
                1L,
                filtersResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .build());

    // Assert
    verify(attestationInstanceDao)
        .findApplicationAttestationInstancesForKindAndSelector(
            eq(EntityKind.ALL), eq(1L), isA(Select.class), isA(Condition.class));
    assertTrue(actualFindApplicationAttestationInstancesForKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)"
  })
  void testFindApplicationAttestationInstancesForKindAndSelector5() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findApplicationAttestationInstancesForKindAndSelector(
            Mockito.<EntityKind>any(),
            Mockito.<Long>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.empty();

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ApplicationAttestationInstanceSummary>
        actualFindApplicationAttestationInstancesForKindAndSelectorResult =
            attestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(
                EntityKind.ALL,
                1L,
                filtersResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .build());

    // Assert
    verify(attestationInstanceDao)
        .findApplicationAttestationInstancesForKindAndSelector(
            eq(EntityKind.ALL), eq(1L), isA(Select.class), isA(Condition.class));
    assertTrue(actualFindApplicationAttestationInstancesForKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)"
  })
  void testFindApplicationAttestationInstancesForKindAndSelector6() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findApplicationAttestationInstancesForKindAndSelector(
            Mockito.<EntityKind>any(),
            Mockito.<Long>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.empty();

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ApplicationAttestationInstanceSummary>
        actualFindApplicationAttestationInstancesForKindAndSelectorResult =
            attestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(
                EntityKind.ALL,
                1L,
                filtersResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .build());

    // Assert
    verify(attestationInstanceDao)
        .findApplicationAttestationInstancesForKindAndSelector(
            eq(EntityKind.ALL), eq(1L), isA(Select.class), isA(Condition.class));
    assertTrue(actualFindApplicationAttestationInstancesForKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)"
  })
  void testFindApplicationAttestationInstancesForKindAndSelector7() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findApplicationAttestationInstancesForKindAndSelector(
            Mockito.<EntityKind>any(),
            Mockito.<Long>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ApplicationAttestationInstanceSummary>
        actualFindApplicationAttestationInstancesForKindAndSelectorResult =
            attestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(
                EntityKind.ALL,
                1L,
                filtersResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .build());

    // Assert
    verify(attestationInstanceDao)
        .findApplicationAttestationInstancesForKindAndSelector(
            eq(EntityKind.ALL), eq(1L), isA(Select.class), isA(Condition.class));
    assertTrue(actualFindApplicationAttestationInstancesForKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)"
  })
  void testFindApplicationAttestationInstancesForKindAndSelector8() {
    // Arrange
    when(attestationInstanceDao.findApplicationAttestationInstancesForKindAndSelector(
            Mockito.<EntityKind>any(),
            Mockito.<Long>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ApplicationAttestationInstanceSummary>
        actualFindApplicationAttestationInstancesForKindAndSelectorResult =
            attestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(
                EntityKind.ALL,
                1L,
                filtersResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .build());

    // Assert
    verify(attestationInstanceDao)
        .findApplicationAttestationInstancesForKindAndSelector(
            eq(EntityKind.ALL), eq(1L), isA(Select.class), isA(Condition.class));
    assertTrue(actualFindApplicationAttestationInstancesForKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)"
  })
  void testFindApplicationAttestationInstancesForKindAndSelector9() {
    // Arrange
    when(attestationInstanceDao.findApplicationAttestationInstancesForKindAndSelector(
            Mockito.<EntityKind>any(),
            Mockito.<Long>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ApplicationAttestationInstanceSummary>
        actualFindApplicationAttestationInstancesForKindAndSelectorResult =
            attestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(
                EntityKind.ALL,
                1L,
                filtersResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .build());

    // Assert
    verify(attestationInstanceDao)
        .findApplicationAttestationInstancesForKindAndSelector(
            eq(EntityKind.ALL), eq(1L), isA(Select.class), isA(Condition.class));
    assertTrue(actualFindApplicationAttestationInstancesForKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)"
  })
  void testFindApplicationAttestationInstancesForKindAndSelector_givenActive() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findApplicationAttestationInstancesForKindAndSelector(
            Mockito.<EntityKind>any(),
            Mockito.<Long>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

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

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult2 =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult3 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult3.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    // Act
    Set<ApplicationAttestationInstanceSummary>
        actualFindApplicationAttestationInstancesForKindAndSelectorResult =
            attestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(
                EntityKind.ALL,
                1L,
                builderResult2
                    .filters(
                        appLifecyclePhaseResult
                            .attestationState(attestationState)
                            .attestationsFromDate(LocalDate.of(1970, 1, 1))
                            .build())
                    .selectionOptions(selectionOptions)
                    .build());

    // Assert
    verify(attestationInstanceDao)
        .findApplicationAttestationInstancesForKindAndSelector(
            eq(EntityKind.ALL), eq(1L), isA(Select.class), isA(Condition.class));
    assertTrue(actualFindApplicationAttestationInstancesForKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)"
  })
  void testFindApplicationAttestationInstancesForKindAndSelector_givenInHouse() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findApplicationAttestationInstancesForKindAndSelector(
            Mockito.<EntityKind>any(),
            Mockito.<Long>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
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

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult3 =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult4 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult4.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    // Act
    Set<ApplicationAttestationInstanceSummary>
        actualFindApplicationAttestationInstancesForKindAndSelectorResult =
            attestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(
                EntityKind.ALL,
                1L,
                builderResult3
                    .filters(
                        appLifecyclePhaseResult
                            .attestationState(attestationState)
                            .attestationsFromDate(LocalDate.of(1970, 1, 1))
                            .build())
                    .selectionOptions(selectionOptions)
                    .build());

    // Assert
    verify(attestationInstanceDao)
        .findApplicationAttestationInstancesForKindAndSelector(
            eq(EntityKind.ALL), eq(1L), isA(Select.class), isA(Condition.class));
    assertTrue(actualFindApplicationAttestationInstancesForKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findApplicationAttestationInstancesForKindAndSelector(EntityKind,
   * Long, ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(EntityKind, Long, ApplicationAttestationInstanceInfo)"
  })
  void testFindApplicationAttestationInstancesForKindAndSelector_givenPending() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findApplicationAttestationInstancesForKindAndSelector(
            Mockito.<EntityKind>any(),
            Mockito.<Long>any(),
            Mockito.<Select<Record1<Long>>>any(),
            Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

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

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult2 =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult3 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult3.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    // Act
    Set<ApplicationAttestationInstanceSummary>
        actualFindApplicationAttestationInstancesForKindAndSelectorResult =
            attestationInstanceService.findApplicationAttestationInstancesForKindAndSelector(
                EntityKind.ALL,
                1L,
                builderResult2
                    .filters(
                        appLifecyclePhaseResult
                            .attestationState(attestationState)
                            .attestationsFromDate(LocalDate.of(1970, 1, 1))
                            .build())
                    .selectionOptions(selectionOptions)
                    .build());

    // Assert
    verify(attestationInstanceDao)
        .findApplicationAttestationInstancesForKindAndSelector(
            eq(EntityKind.ALL), eq(1L), isA(Select.class), isA(Condition.class));
    assertTrue(actualFindApplicationAttestationInstancesForKindAndSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName("Test findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)"
  })
  void testFindAttestationInstanceSummaryForSelector() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findAttestationInstanceSummaryForSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ApplicationAttestationSummaryCounts> actualFindAttestationInstanceSummaryForSelectorResult =
        attestationInstanceService.findAttestationInstanceSummaryForSelector(
            filtersResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .build());

    // Assert
    verify(attestationInstanceDao)
        .findAttestationInstanceSummaryForSelector(isA(Select.class), isA(Condition.class));
    assertTrue(actualFindAttestationInstanceSummaryForSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName("Test findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)"
  })
  void testFindAttestationInstanceSummaryForSelector2() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findAttestationInstanceSummaryForSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState =
        Optional.of(AttestationState.NEVER_ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ApplicationAttestationSummaryCounts> actualFindAttestationInstanceSummaryForSelectorResult =
        attestationInstanceService.findAttestationInstanceSummaryForSelector(
            filtersResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .build());

    // Assert
    verify(attestationInstanceDao)
        .findAttestationInstanceSummaryForSelector(isA(Select.class), isA(Condition.class));
    assertTrue(actualFindAttestationInstanceSummaryForSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName("Test findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)"
  })
  void testFindAttestationInstanceSummaryForSelector3() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findAttestationInstanceSummaryForSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.empty();

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ApplicationAttestationSummaryCounts> actualFindAttestationInstanceSummaryForSelectorResult =
        attestationInstanceService.findAttestationInstanceSummaryForSelector(
            filtersResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .build());

    // Assert
    verify(attestationInstanceDao)
        .findAttestationInstanceSummaryForSelector(isA(Select.class), isA(Condition.class));
    assertTrue(actualFindAttestationInstanceSummaryForSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName("Test findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)"
  })
  void testFindAttestationInstanceSummaryForSelector4() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findAttestationInstanceSummaryForSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.empty();

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ApplicationAttestationSummaryCounts> actualFindAttestationInstanceSummaryForSelectorResult =
        attestationInstanceService.findAttestationInstanceSummaryForSelector(
            filtersResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .build());

    // Assert
    verify(attestationInstanceDao)
        .findAttestationInstanceSummaryForSelector(isA(Select.class), isA(Condition.class));
    assertTrue(actualFindAttestationInstanceSummaryForSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName("Test findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)"
  })
  void testFindAttestationInstanceSummaryForSelector5() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findAttestationInstanceSummaryForSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.empty();

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ApplicationAttestationSummaryCounts> actualFindAttestationInstanceSummaryForSelectorResult =
        attestationInstanceService.findAttestationInstanceSummaryForSelector(
            filtersResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .build());

    // Assert
    verify(attestationInstanceDao)
        .findAttestationInstanceSummaryForSelector(isA(Select.class), isA(Condition.class));
    assertTrue(actualFindAttestationInstanceSummaryForSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName("Test findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)"
  })
  void testFindAttestationInstanceSummaryForSelector6() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findAttestationInstanceSummaryForSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ApplicationAttestationSummaryCounts> actualFindAttestationInstanceSummaryForSelectorResult =
        attestationInstanceService.findAttestationInstanceSummaryForSelector(
            filtersResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .build());

    // Assert
    verify(attestationInstanceDao)
        .findAttestationInstanceSummaryForSelector(isA(Select.class), isA(Condition.class));
    assertTrue(actualFindAttestationInstanceSummaryForSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName("Test findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)"
  })
  void testFindAttestationInstanceSummaryForSelector7() {
    // Arrange
    when(attestationInstanceDao.findAttestationInstanceSummaryForSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ApplicationAttestationSummaryCounts> actualFindAttestationInstanceSummaryForSelectorResult =
        attestationInstanceService.findAttestationInstanceSummaryForSelector(
            filtersResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .build());

    // Assert
    verify(attestationInstanceDao)
        .findAttestationInstanceSummaryForSelector(isA(Select.class), isA(Condition.class));
    assertTrue(actualFindAttestationInstanceSummaryForSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}.
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName("Test findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)"
  })
  void testFindAttestationInstanceSummaryForSelector8() {
    // Arrange
    when(attestationInstanceDao.findAttestationInstanceSummaryForSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act
    Set<ApplicationAttestationSummaryCounts> actualFindAttestationInstanceSummaryForSelectorResult =
        attestationInstanceService.findAttestationInstanceSummaryForSelector(
            filtersResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .build());

    // Assert
    verify(attestationInstanceDao)
        .findAttestationInstanceSummaryForSelector(isA(Select.class), isA(Condition.class));
    assertTrue(actualFindAttestationInstanceSummaryForSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)"
  })
  void testFindAttestationInstanceSummaryForSelector_givenActive() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findAttestationInstanceSummaryForSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

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

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult2 =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult3 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult3.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    // Act
    Set<ApplicationAttestationSummaryCounts> actualFindAttestationInstanceSummaryForSelectorResult =
        attestationInstanceService.findAttestationInstanceSummaryForSelector(
            builderResult2
                .filters(
                    appLifecyclePhaseResult
                        .attestationState(attestationState)
                        .attestationsFromDate(LocalDate.of(1970, 1, 1))
                        .build())
                .selectionOptions(selectionOptions)
                .build());

    // Assert
    verify(attestationInstanceDao)
        .findAttestationInstanceSummaryForSelector(isA(Select.class), isA(Condition.class));
    assertTrue(actualFindAttestationInstanceSummaryForSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)"
  })
  void testFindAttestationInstanceSummaryForSelector_givenInHouse() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findAttestationInstanceSummaryForSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
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

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult3 =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult4 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult4.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    // Act
    Set<ApplicationAttestationSummaryCounts> actualFindAttestationInstanceSummaryForSelectorResult =
        attestationInstanceService.findAttestationInstanceSummaryForSelector(
            builderResult3
                .filters(
                    appLifecyclePhaseResult
                        .attestationState(attestationState)
                        .attestationsFromDate(LocalDate.of(1970, 1, 1))
                        .build())
                .selectionOptions(selectionOptions)
                .build());

    // Assert
    verify(attestationInstanceDao)
        .findAttestationInstanceSummaryForSelector(isA(Select.class), isA(Condition.class));
    assertTrue(actualFindAttestationInstanceSummaryForSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)"
  })
  void testFindAttestationInstanceSummaryForSelector_givenPending() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findAttestationInstanceSummaryForSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Condition>any()))
        .thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

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

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult2 =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult3 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult3.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    // Act
    Set<ApplicationAttestationSummaryCounts> actualFindAttestationInstanceSummaryForSelectorResult =
        attestationInstanceService.findAttestationInstanceSummaryForSelector(
            builderResult2
                .filters(
                    appLifecyclePhaseResult
                        .attestationState(attestationState)
                        .attestationsFromDate(LocalDate.of(1970, 1, 1))
                        .build())
                .selectionOptions(selectionOptions)
                .build());

    // Assert
    verify(attestationInstanceDao)
        .findAttestationInstanceSummaryForSelector(isA(Select.class), isA(Condition.class));
    assertTrue(actualFindAttestationInstanceSummaryForSelectorResult.isEmpty());
  }

  /**
   * Test {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link UpdateFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttestationInstanceService#findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName(
      "Test findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo); then throw UpdateFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set AttestationInstanceService.findAttestationInstanceSummaryForSelector(ApplicationAttestationInstanceInfo)"
  })
  void testFindAttestationInstanceSummaryForSelector_thenThrowUpdateFailedException() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findAttestationInstanceSummaryForSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Condition>any()))
        .thenThrow(new UpdateFailedException("attested_at", "An error occurred"));
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao =
        mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    AttestationRunService attestationRunService =
        new AttestationRunService(
            attestationInstanceDao2,
            attestationInstanceRecipientDao,
            attestationRunDao,
            entityReferenceNameResolver,
            involvementDao,
            involvementGroupService);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReferenceNameResolver entityReferenceNameResolver2 =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver3,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);
    ChangeLogService changeLogService3 =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    AttestationInstanceService attestationInstanceService =
        new AttestationInstanceService(
            attestationInstanceDao,
            attestationRunService,
            attestationPreCheckService,
            applicationService,
            entityReferenceNameResolver2,
            personDao,
            permissionGroupService,
            changeLogService3);

    ImmutableApplicationAttestationInstanceInfo.Builder builderResult =
        ImmutableApplicationAttestationInstanceInfo.builder();

    ImmutableApplicationAttestationSummaryFilters.Builder builderResult2 =
        ImmutableApplicationAttestationSummaryFilters.builder();
    Optional<? extends Criticality> appCriticality = Optional.of(Criticality.LOW);

    ImmutableApplicationAttestationSummaryFilters.Builder appCriticalityResult =
        builderResult2.appCriticality(appCriticality);
    Optional<? extends LifecyclePhase> appLifecyclePhase = Optional.of(LifecyclePhase.PRODUCTION);

    ImmutableApplicationAttestationSummaryFilters.Builder appLifecyclePhaseResult =
        appCriticalityResult.appLifecyclePhase(appLifecyclePhase);
    Optional<? extends AttestationState> attestationState = Optional.of(AttestationState.ATTESTED);

    ImmutableApplicationAttestationInstanceInfo.Builder filtersResult =
        builderResult.filters(
            appLifecyclePhaseResult
                .attestationState(attestationState)
                .attestationsFromDate(LocalDate.of(1970, 1, 1))
                .build());

    Builder builderResult3 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult3
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

    Builder joiningEntityKindResult = filtersResult2.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        UpdateFailedException.class,
        () ->
            attestationInstanceService.findAttestationInstanceSummaryForSelector(
                filtersResult
                    .selectionOptions(
                        joiningEntityKindResult
                            .addAllEntityLifecycleStatuses(new ArrayList<>())
                            .scope(HierarchyQueryScope.EXACT)
                            .build())
                    .build()));
    verify(attestationInstanceDao)
        .findAttestationInstanceSummaryForSelector(isA(Select.class), isA(Condition.class));
  }
}
