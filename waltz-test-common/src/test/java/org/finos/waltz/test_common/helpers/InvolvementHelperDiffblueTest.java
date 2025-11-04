package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.involvement.InvolvementDao;
import org.finos.waltz.data.involvement_kind.InvolvementKindDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.involvement.EntityInvolvementChangeCommand;
import org.finos.waltz.model.involvement_kind.InvolvementKindChangeCommand;
import org.finos.waltz.model.involvement_kind.InvolvementKindCreateCommand;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InvolvementHelperDiffblueTest {
  /**
   * Method under test: {@link InvolvementHelper#mkInvolvementKind(String)}
   */
  @Test
  void testMkInvolvementKind() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.create(Mockito.<InvolvementKindCreateCommand>any(), Mockito.<String>any())).thenReturn(1L);
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService2 = new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    long actualMkInvolvementKindResult = (new InvolvementHelper(
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver,
            involvementKindService2, personDao,
            new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
                new SettingsService(settingsDao, new ArrayList<>()))),
        involvementKindService)).mkInvolvementKind("Name");

    // Assert
    verify(involvementKindDao).create(isA(InvolvementKindCreateCommand.class),
        eq("involvementHelper_09666e30-133c-4403-887f-5fee248bcf7a"));
    assertEquals(1L, actualMkInvolvementKindResult);
  }

  /**
   * Method under test: {@link InvolvementHelper#mkInvolvementKind(String)}
   */
  @Test
  void testMkInvolvementKind2() {
    // Arrange
    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.create(Mockito.<InvolvementKindCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService2 = new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    long actualMkInvolvementKindResult = (new InvolvementHelper(
        new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver,
            involvementKindService2, personDao,
            new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
                new SettingsService(settingsDao, new ArrayList<>()))),
        involvementKindService)).mkInvolvementKind("Name");

    // Assert
    verify(involvementKindService).create(isA(InvolvementKindCreateCommand.class),
        eq("involvementHelper_32b74e79-ee34-4c4c-8ca8-a5407ba25a22"));
    assertEquals(1L, actualMkInvolvementKindResult);
  }

  /**
   * Method under test:
   * {@link InvolvementHelper#mkInvolvementKind(String, String)}
   */
  @Test
  void testMkInvolvementKind3() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.create(Mockito.<InvolvementKindCreateCommand>any(), Mockito.<String>any())).thenReturn(1L);
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService2 = new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    long actualMkInvolvementKindResult = (new InvolvementHelper(new InvolvementService(changeLogService, dao,
        logicalFlowDao, physicalFlowDao, entityReferenceNameResolver, involvementKindService2, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>()))),
        involvementKindService)).mkInvolvementKind("Name", "42");

    // Assert
    verify(involvementKindDao).create(isA(InvolvementKindCreateCommand.class),
        eq("involvementHelper_eabe7643-0539-44f0-95d2-8d8217fa359d"));
    assertEquals(1L, actualMkInvolvementKindResult);
  }

  /**
   * Method under test:
   * {@link InvolvementHelper#mkInvolvementKind(String, String)}
   */
  @Test
  void testMkInvolvementKind4() {
    // Arrange
    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.create(Mockito.<InvolvementKindCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService2 = new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    long actualMkInvolvementKindResult = (new InvolvementHelper(new InvolvementService(changeLogService, dao,
        logicalFlowDao, physicalFlowDao, entityReferenceNameResolver, involvementKindService2, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>()))),
        involvementKindService)).mkInvolvementKind("Name", "42");

    // Assert
    verify(involvementKindService).create(isA(InvolvementKindCreateCommand.class),
        eq("involvementHelper_ee2972bc-94a6-419e-9e12-986ccf0e05be"));
    assertEquals(1L, actualMkInvolvementKindResult);
  }

  /**
   * Method under test:
   * {@link InvolvementHelper#createInvolvement(Long, long, EntityReference)}
   */
  @Test
  void testCreateInvolvement() {
    // Arrange
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.addEntityInvolvement(Mockito.<String>any(), Mockito.<EntityReference>any(),
        Mockito.<EntityInvolvementChangeCommand>any())).thenReturn(true);

    // Act
    (new InvolvementHelper(involvementService, new InvolvementKindService(mock(InvolvementKindDao.class))))
        .createInvolvement(1L, 1L, null);

    // Assert
    verify(involvementService).addEntityInvolvement(eq("testuser_d52b9c89-2298-4b83-81a3-b14c88c8965a"), isNull(),
        isA(EntityInvolvementChangeCommand.class));
  }

  /**
   * Method under test: {@link InvolvementHelper#markAsIntransitive(long)}
   */
  @Test
  void testMarkAsIntransitive() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.update(Mockito.<InvolvementKindChangeCommand>any())).thenReturn(true);
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService2 = new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    (new InvolvementHelper(new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao,
        entityReferenceNameResolver, involvementKindService2, personDao, new UserRoleService(userRoleDao, roleDao,
            personDao2, changeLogService2, personService, new SettingsService(settingsDao, new ArrayList<>()))),
        involvementKindService)).markAsIntransitive(1L);

    // Assert
    verify(involvementKindDao).update(isA(InvolvementKindChangeCommand.class));
  }

  /**
   * Method under test: {@link InvolvementHelper#markAsIntransitive(long)}
   */
  @Test
  void testMarkAsIntransitive2() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.update(Mockito.<InvolvementKindChangeCommand>any())).thenReturn(false);
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService2 = new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    (new InvolvementHelper(new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao,
        entityReferenceNameResolver, involvementKindService2, personDao, new UserRoleService(userRoleDao, roleDao,
            personDao2, changeLogService2, personService, new SettingsService(settingsDao, new ArrayList<>()))),
        involvementKindService)).markAsIntransitive(1L);

    // Assert
    verify(involvementKindDao).update(isA(InvolvementKindChangeCommand.class));
  }

  /**
   * Method under test: {@link InvolvementHelper#markAsIntransitive(long)}
   */
  @Test
  void testMarkAsIntransitive3() {
    // Arrange
    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.update(Mockito.<InvolvementKindChangeCommand>any(), Mockito.<String>any()))
        .thenReturn(null);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService2 = new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);

    // Act
    (new InvolvementHelper(new InvolvementService(changeLogService, dao, logicalFlowDao, physicalFlowDao,
        entityReferenceNameResolver, involvementKindService2, personDao, new UserRoleService(userRoleDao, roleDao,
            personDao2, changeLogService2, personService, new SettingsService(settingsDao, new ArrayList<>()))),
        involvementKindService)).markAsIntransitive(1L);

    // Assert
    verify(involvementKindService).update(isA(InvolvementKindChangeCommand.class), eq("admin"));
  }
}
