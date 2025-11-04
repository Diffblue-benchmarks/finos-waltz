package org.finos.waltz.service.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.attestation.AttestationInstance;
import org.finos.waltz.model.attestation.LatestMeasurableAttestationInfo;
import org.finos.waltz.model.attestation.SyncRecipientsResponse;
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AttestationInstanceServiceDiffblueTest {
  /**
   * Method under test:
   * {@link AttestationInstanceService#findByRecipient(String, boolean)}
   */
  @Test
  void testFindByRecipient() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    ArrayList<AttestationInstance> attestationInstanceList = new ArrayList<>();
    when(attestationInstanceDao.findByRecipient(Mockito.<String>any(), anyBoolean()))
        .thenReturn(attestationInstanceList);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act
    List<AttestationInstance> actualFindByRecipientResult = (new AttestationInstanceService(attestationInstanceDao,
        attestationRunService, attestationPreCheckService, applicationService, entityReferenceNameResolver2, personDao,
        permissionGroupService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findByRecipient("42", true);

    // Assert
    verify(attestationInstanceDao).findByRecipient(eq("42"), eq(true));
    assertTrue(actualFindByRecipientResult.isEmpty());
    assertSame(attestationInstanceList, actualFindByRecipientResult);
  }

  /**
   * Method under test:
   * {@link AttestationInstanceService#findByRecipient(String, boolean)}
   */
  @Test
  void testFindByRecipient2() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findByRecipient(Mockito.<String>any(), anyBoolean()))
        .thenThrow(new UpdateFailedException("userId cannot be null", "An error occurred"));
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new AttestationInstanceService(attestationInstanceDao, attestationRunService, attestationPreCheckService,
            applicationService, entityReferenceNameResolver2, personDao, permissionGroupService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findByRecipient("42", true));
    verify(attestationInstanceDao).findByRecipient(eq("42"), eq(true));
  }

  /**
   * Method under test:
   * {@link AttestationInstanceService#findHistoricalForPendingByUserId(String)}
   */
  @Test
  void testFindHistoricalForPendingByUserId() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    ArrayList<AttestationInstance> attestationInstanceList = new ArrayList<>();
    when(attestationInstanceDao.findHistoricalForPendingByUserId(Mockito.<String>any()))
        .thenReturn(attestationInstanceList);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act
    List<AttestationInstance> actualFindHistoricalForPendingByUserIdResult = (new AttestationInstanceService(
        attestationInstanceDao, attestationRunService, attestationPreCheckService, applicationService,
        entityReferenceNameResolver2, personDao, permissionGroupService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findHistoricalForPendingByUserId("42");

    // Assert
    verify(attestationInstanceDao).findHistoricalForPendingByUserId(eq("42"));
    assertTrue(actualFindHistoricalForPendingByUserIdResult.isEmpty());
    assertSame(attestationInstanceList, actualFindHistoricalForPendingByUserIdResult);
  }

  /**
   * Method under test:
   * {@link AttestationInstanceService#findHistoricalForPendingByUserId(String)}
   */
  @Test
  void testFindHistoricalForPendingByUserId2() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findHistoricalForPendingByUserId(Mockito.<String>any()))
        .thenThrow(new UpdateFailedException("userId cannot be null", "An error occurred"));
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new AttestationInstanceService(attestationInstanceDao, attestationRunService, attestationPreCheckService,
            applicationService, entityReferenceNameResolver2, personDao, permissionGroupService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findHistoricalForPendingByUserId("42"));
    verify(attestationInstanceDao).findHistoricalForPendingByUserId(eq("42"));
  }

  /**
   * Method under test:
   * {@link AttestationInstanceService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    ArrayList<AttestationInstance> attestationInstanceList = new ArrayList<>();
    when(attestationInstanceDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(attestationInstanceList);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act
    List<AttestationInstance> actualFindByEntityReferenceResult = (new AttestationInstanceService(
        attestationInstanceDao, attestationRunService, attestationPreCheckService, applicationService,
        entityReferenceNameResolver2, personDao, permissionGroupService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findByEntityReference(mock(EntityReference.class));

    // Assert
    verify(attestationInstanceDao).findByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(attestationInstanceList, actualFindByEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link AttestationInstanceService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference2() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new UpdateFailedException("ref cannot be null", "An error occurred"));
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new AttestationInstanceService(attestationInstanceDao, attestationRunService, attestationPreCheckService,
            applicationService, entityReferenceNameResolver2, personDao, permissionGroupService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findByEntityReference(mock(EntityReference.class)));
    verify(attestationInstanceDao).findByEntityReference(isA(EntityReference.class));
  }

  /**
   * Method under test:
   * {@link AttestationInstanceService#attestInstance(long, String)}
   */
  @Test
  void testAttestInstance() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.getById(anyLong()))
        .thenThrow(new UpdateFailedException("attestedBy must be provided", "An error occurred"));
    when(attestationInstanceDao.attestInstance(anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenReturn(true);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new AttestationInstanceService(attestationInstanceDao, attestationRunService, attestationPreCheckService,
            applicationService, entityReferenceNameResolver2, personDao, permissionGroupService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .attestInstance(1L, "Attested By"));
    verify(attestationInstanceDao).attestInstance(eq(1L), eq("Attested By"), isA(LocalDateTime.class));
    verify(attestationInstanceDao).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link AttestationInstanceService#attestInstance(long, String)}
   */
  @Test
  void testAttestInstance2() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.attestInstance(anyLong(), Mockito.<String>any(), Mockito.<LocalDateTime>any()))
        .thenReturn(false);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act
    boolean actualAttestInstanceResult = (new AttestationInstanceService(attestationInstanceDao, attestationRunService,
        attestationPreCheckService, applicationService, entityReferenceNameResolver2, personDao, permissionGroupService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .attestInstance(1L, "Attested By");

    // Assert
    verify(attestationInstanceDao).attestInstance(eq(1L), eq("Attested By"), isA(LocalDateTime.class));
    assertFalse(actualAttestInstanceResult);
  }

  /**
   * Method under test: {@link AttestationInstanceService#findByRunId(long)}
   */
  @Test
  void testFindByRunId() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    ArrayList<AttestationInstance> attestationInstanceList = new ArrayList<>();
    when(attestationInstanceDao.findByRunId(anyLong())).thenReturn(attestationInstanceList);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act
    List<AttestationInstance> actualFindByRunIdResult = (new AttestationInstanceService(attestationInstanceDao,
        attestationRunService, attestationPreCheckService, applicationService, entityReferenceNameResolver2, personDao,
        permissionGroupService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findByRunId(1L);

    // Assert
    verify(attestationInstanceDao).findByRunId(eq(1L));
    assertTrue(actualFindByRunIdResult.isEmpty());
    assertSame(attestationInstanceList, actualFindByRunIdResult);
  }

  /**
   * Method under test: {@link AttestationInstanceService#findByRunId(long)}
   */
  @Test
  void testFindByRunId2() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findByRunId(anyLong()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new AttestationInstanceService(attestationInstanceDao, attestationRunService, attestationPreCheckService,
            applicationService, entityReferenceNameResolver2, personDao, permissionGroupService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findByRunId(1L));
    verify(attestationInstanceDao).findByRunId(eq(1L));
  }

  /**
   * Method under test:
   * {@link AttestationInstanceService#findPersonsByInstanceId(long)}
   */
  @Test
  void testFindPersonsByInstanceId() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    ArrayList<Person> personList = new ArrayList<>();
    when(personDao.findPersonsByAttestationInstanceId(anyLong())).thenReturn(personList);
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act
    List<Person> actualFindPersonsByInstanceIdResult = (new AttestationInstanceService(attestationInstanceDao,
        attestationRunService, attestationPreCheckService, applicationService, entityReferenceNameResolver2, personDao,
        permissionGroupService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findPersonsByInstanceId(1L);

    // Assert
    verify(personDao).findPersonsByAttestationInstanceId(eq(1L));
    assertTrue(actualFindPersonsByInstanceIdResult.isEmpty());
    assertSame(personList, actualFindPersonsByInstanceIdResult);
  }

  /**
   * Method under test:
   * {@link AttestationInstanceService#findPersonsByInstanceId(long)}
   */
  @Test
  void testFindPersonsByInstanceId2() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findPersonsByAttestationInstanceId(anyLong()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new AttestationInstanceService(attestationInstanceDao, attestationRunService, attestationPreCheckService,
            applicationService, entityReferenceNameResolver2, personDao, permissionGroupService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findPersonsByInstanceId(1L));
    verify(personDao).findPersonsByAttestationInstanceId(eq(1L));
  }

  /**
   * Method under test: {@link AttestationInstanceService#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.cleanupOrphans()).thenReturn(1);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act
    int actualCleanupOrphansResult = (new AttestationInstanceService(attestationInstanceDao, attestationRunService,
        attestationPreCheckService, applicationService, entityReferenceNameResolver2, personDao, permissionGroupService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .cleanupOrphans();

    // Assert
    verify(attestationInstanceDao).cleanupOrphans();
    assertEquals(1, actualCleanupOrphansResult);
  }

  /**
   * Method under test: {@link AttestationInstanceService#cleanupOrphans()}
   */
  @Test
  void testCleanupOrphans2() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.cleanupOrphans()).thenThrow(new UpdateFailedException("Code", "An error occurred"));
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new AttestationInstanceService(attestationInstanceDao, attestationRunService, attestationPreCheckService,
            applicationService, entityReferenceNameResolver2, personDao, permissionGroupService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .cleanupOrphans());
    verify(attestationInstanceDao).cleanupOrphans();
  }

  /**
   * Method under test: {@link AttestationInstanceService#reassignRecipients()}
   */
  @Test
  void testReassignRecipients() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.reassignRecipients()).thenReturn(null);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act
    SyncRecipientsResponse actualReassignRecipientsResult = (new AttestationInstanceService(attestationInstanceDao,
        attestationRunService, attestationPreCheckService, applicationService, entityReferenceNameResolver2, personDao,
        permissionGroupService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .reassignRecipients();

    // Assert
    verify(attestationInstanceDao).reassignRecipients();
    assertNull(actualReassignRecipientsResult);
  }

  /**
   * Method under test: {@link AttestationInstanceService#reassignRecipients()}
   */
  @Test
  void testReassignRecipients2() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.reassignRecipients()).thenThrow(new UpdateFailedException("Code", "An error occurred"));
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new AttestationInstanceService(attestationInstanceDao, attestationRunService, attestationPreCheckService,
            applicationService, entityReferenceNameResolver2, personDao, permissionGroupService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .reassignRecipients());
    verify(attestationInstanceDao).reassignRecipients();
  }

  /**
   * Method under test:
   * {@link AttestationInstanceService#getCountsOfRecipientsToReassign()}
   */
  @Test
  void testGetCountsOfRecipientsToReassign() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.getCountsOfRecipientsToReassign()).thenReturn(null);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act
    SyncRecipientsResponse actualCountsOfRecipientsToReassign = (new AttestationInstanceService(attestationInstanceDao,
        attestationRunService, attestationPreCheckService, applicationService, entityReferenceNameResolver2, personDao,
        permissionGroupService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .getCountsOfRecipientsToReassign();

    // Assert
    verify(attestationInstanceDao).getCountsOfRecipientsToReassign();
    assertNull(actualCountsOfRecipientsToReassign);
  }

  /**
   * Method under test:
   * {@link AttestationInstanceService#getCountsOfRecipientsToReassign()}
   */
  @Test
  void testGetCountsOfRecipientsToReassign2() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.getCountsOfRecipientsToReassign())
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new AttestationInstanceService(attestationInstanceDao, attestationRunService, attestationPreCheckService,
            applicationService, entityReferenceNameResolver2, personDao, permissionGroupService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .getCountsOfRecipientsToReassign());
    verify(attestationInstanceDao).getCountsOfRecipientsToReassign();
  }

  /**
   * Method under test:
   * {@link AttestationInstanceService#findLatestMeasurableAttestations(EntityReference)}
   */
  @Test
  void testFindLatestMeasurableAttestations() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    HashSet<LatestMeasurableAttestationInfo> latestMeasurableAttestationInfoSet = new HashSet<>();
    when(attestationInstanceDao.findLatestMeasurableAttestations(Mockito.<EntityReference>any()))
        .thenReturn(latestMeasurableAttestationInfoSet);
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act
    Set<LatestMeasurableAttestationInfo> actualFindLatestMeasurableAttestationsResult = (new AttestationInstanceService(
        attestationInstanceDao, attestationRunService, attestationPreCheckService, applicationService,
        entityReferenceNameResolver2, personDao, permissionGroupService,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findLatestMeasurableAttestations(null);

    // Assert
    verify(attestationInstanceDao).findLatestMeasurableAttestations(isNull());
    assertTrue(actualFindLatestMeasurableAttestationsResult.isEmpty());
    assertSame(latestMeasurableAttestationInfoSet, actualFindLatestMeasurableAttestationsResult);
  }

  /**
   * Method under test:
   * {@link AttestationInstanceService#findLatestMeasurableAttestations(EntityReference)}
   */
  @Test
  void testFindLatestMeasurableAttestations2() {
    // Arrange
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    when(attestationInstanceDao.findLatestMeasurableAttestations(Mockito.<EntityReference>any()))
        .thenThrow(new UpdateFailedException("Code", "An error occurred"));
    AttestationInstanceDao attestationInstanceDao2 = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao2,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    SettingsDao settingsDao = mock(SettingsDao.class);
    AttestationPreCheckService attestationPreCheckService = new AttestationPreCheckService(attestationPreCheckDao,
        new SettingsService(settingsDao, new ArrayList<>()));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    EntityReferenceNameResolver entityReferenceNameResolver2 = mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver3 = mock(EntityReferenceNameResolver.class);
    PermissionGroupService permissionGroupService = new PermissionGroupService(personService, permissionGroupDao,
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver3,
            new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
            mock(UserRoleService.class)));

    // Act and Assert
    assertThrows(UpdateFailedException.class,
        () -> (new AttestationInstanceService(attestationInstanceDao, attestationRunService, attestationPreCheckService,
            applicationService, entityReferenceNameResolver2, personDao, permissionGroupService,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                    .findLatestMeasurableAttestations(null));
    verify(attestationInstanceDao).findLatestMeasurableAttestations(isNull());
  }
}
