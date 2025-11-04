package org.finos.waltz.service.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.involvement.InvolvementDao;
import org.finos.waltz.data.involvement.InvolvementViewDao;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyDirection;
import org.finos.waltz.model.involvement.ImmutableInvolvementDetailByDirectionResults;
import org.finos.waltz.model.involvement.Involvement;
import org.finos.waltz.model.involvement.InvolvementDetail;
import org.finos.waltz.model.involvement.InvolvementDetailByDirectionResults;
import org.finos.waltz.model.involvement.InvolvementViewItem;
import org.finos.waltz.model.involvement_kind.InvolvementKind;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InvolvementViewServiceDiffblueTest {
  /**
   * Method under test: {@link InvolvementViewService#findAllByEmployeeId(String)}
   */
  @Test
  void testFindAllByEmployeeId() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findAllByEmployeeId(Mockito.<String>any())).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));

    // Act
    Set<InvolvementViewItem> actualFindAllByEmployeeIdResult = (new InvolvementViewService(involvementService,
        new InvolvementKindService(mock(InvolvementKindDao.class)), personService2, mock(InvolvementViewDao.class)))
            .findAllByEmployeeId("42");

    // Assert
    verify(dao).findAllByEmployeeId(eq("42"));
    verify(personDao3).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindAllByEmployeeIdResult.isEmpty());
  }

  /**
   * Method under test: {@link InvolvementViewService#findAllByEmployeeId(String)}
   */
  @Test
  void testFindAllByEmployeeId2() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");

    ArrayList<Involvement> involvementList = new ArrayList<>();
    involvementList.add(involvement);
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findAllByEmployeeId(Mockito.<String>any())).thenReturn(involvementList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));

    // Act
    Set<InvolvementViewItem> actualFindAllByEmployeeIdResult = (new InvolvementViewService(involvementService,
        new InvolvementKindService(mock(InvolvementKindDao.class)), personService2, mock(InvolvementViewDao.class)))
            .findAllByEmployeeId("42");

    // Assert
    verify(dao).findAllByEmployeeId(eq("42"));
    verify(personDao3).findByEmployeeIds(isA(Set.class));
    verify(involvement, atLeast(1)).employeeId();
    assertTrue(actualFindAllByEmployeeIdResult.isEmpty());
  }

  /**
   * Method under test: {@link InvolvementViewService#findAllByEmployeeId(String)}
   */
  @Test
  void testFindAllByEmployeeId3() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");
    Involvement involvement2 = mock(Involvement.class);
    when(involvement2.employeeId()).thenReturn("42");

    ArrayList<Involvement> involvementList = new ArrayList<>();
    involvementList.add(involvement2);
    involvementList.add(involvement);
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findAllByEmployeeId(Mockito.<String>any())).thenReturn(involvementList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));

    // Act
    Set<InvolvementViewItem> actualFindAllByEmployeeIdResult = (new InvolvementViewService(involvementService,
        new InvolvementKindService(mock(InvolvementKindDao.class)), personService2, mock(InvolvementViewDao.class)))
            .findAllByEmployeeId("42");

    // Assert
    verify(dao).findAllByEmployeeId(eq("42"));
    verify(personDao3).findByEmployeeIds(isA(Set.class));
    verify(involvement2, atLeast(1)).employeeId();
    verify(involvement, atLeast(1)).employeeId();
    assertTrue(actualFindAllByEmployeeIdResult.isEmpty());
  }

  /**
   * Method under test: {@link InvolvementViewService#findAllByEmployeeId(String)}
   */
  @Test
  void testFindAllByEmployeeId4() {
    // Arrange
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findAllByEmployeeId(Mockito.<String>any())).thenReturn(new ArrayList<>());
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    Set<InvolvementViewItem> actualFindAllByEmployeeIdResult = (new InvolvementViewService(involvementService,
        new InvolvementKindService(mock(InvolvementKindDao.class)), personService, mock(InvolvementViewDao.class)))
            .findAllByEmployeeId("42");

    // Assert
    verify(personDao).findByEmployeeIds(isA(Set.class));
    verify(involvementService).findAllByEmployeeId(eq("42"));
    assertTrue(actualFindAllByEmployeeIdResult.isEmpty());
  }

  /**
   * Method under test: {@link InvolvementViewService#findAllByEmployeeId(String)}
   */
  @Test
  void testFindAllByEmployeeId5() {
    // Arrange
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findAllByEmployeeId(Mockito.<String>any())).thenReturn(new ArrayList<>());
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(person);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(personSet);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    Set<InvolvementViewItem> actualFindAllByEmployeeIdResult = (new InvolvementViewService(involvementService,
        new InvolvementKindService(mock(InvolvementKindDao.class)), personService, mock(InvolvementViewDao.class)))
            .findAllByEmployeeId("42");

    // Assert
    verify(personDao).findByEmployeeIds(isA(Set.class));
    verify(person).employeeId();
    verify(involvementService).findAllByEmployeeId(eq("42"));
    assertTrue(actualFindAllByEmployeeIdResult.isEmpty());
  }

  /**
   * Method under test: {@link InvolvementViewService#findAllByEmployeeId(String)}
   */
  @Test
  void testFindAllByEmployeeId6() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");

    ArrayList<Involvement> involvementList = new ArrayList<>();
    involvementList.add(involvement);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findAllByEmployeeId(Mockito.<String>any())).thenReturn(involvementList);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(person);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(personSet);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    Set<InvolvementViewItem> actualFindAllByEmployeeIdResult = (new InvolvementViewService(involvementService,
        new InvolvementKindService(mock(InvolvementKindDao.class)), personService, mock(InvolvementViewDao.class)))
            .findAllByEmployeeId("42");

    // Assert
    verify(personDao).findByEmployeeIds(isA(Set.class));
    verify(involvement, atLeast(1)).employeeId();
    verify(person).employeeId();
    verify(involvementService).findAllByEmployeeId(eq("42"));
    assertEquals(1, actualFindAllByEmployeeIdResult.size());
  }

  /**
   * Method under test: {@link InvolvementViewService#findAllByEmployeeId(String)}
   */
  @Test
  void testFindAllByEmployeeId7() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");

    ArrayList<Involvement> involvementList = new ArrayList<>();
    involvementList.add(involvement);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findAllByEmployeeId(Mockito.<String>any())).thenReturn(involvementList);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");
    Person person2 = mock(Person.class);
    when(person2.employeeId()).thenReturn("42");

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(person2);
    personSet.add(person);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(personSet);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    Set<InvolvementViewItem> actualFindAllByEmployeeIdResult = (new InvolvementViewService(involvementService,
        new InvolvementKindService(mock(InvolvementKindDao.class)), personService, mock(InvolvementViewDao.class)))
            .findAllByEmployeeId("42");

    // Assert
    verify(personDao).findByEmployeeIds(isA(Set.class));
    verify(involvement, atLeast(1)).employeeId();
    verify(person2).employeeId();
    verify(person).employeeId();
    verify(involvementService).findAllByEmployeeId(eq("42"));
    assertEquals(1, actualFindAllByEmployeeIdResult.size());
  }

  /**
   * Method under test: {@link InvolvementViewService#findAllByEmployeeId(String)}
   */
  @Test
  void testFindAllByEmployeeId8() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");

    ArrayList<Involvement> involvementList = new ArrayList<>();
    involvementList.add(involvement);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findAllByEmployeeId(Mockito.<String>any())).thenReturn(involvementList);
    PersonService personService = mock(PersonService.class);
    when(personService.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());

    // Act
    Set<InvolvementViewItem> actualFindAllByEmployeeIdResult = (new InvolvementViewService(involvementService,
        new InvolvementKindService(mock(InvolvementKindDao.class)), personService, mock(InvolvementViewDao.class)))
            .findAllByEmployeeId("42");

    // Assert
    verify(involvement, atLeast(1)).employeeId();
    verify(involvementService).findAllByEmployeeId(eq("42"));
    verify(personService).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindAllByEmployeeIdResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  void testFindKeyInvolvementsForEntity() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    when(dao.findPeopleByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService2 = new InvolvementKindService(involvementKindDao);
    InvolvementViewService involvementViewService = new InvolvementViewService(involvementService,
        involvementKindService2, new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)),
        mock(InvolvementViewDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult = involvementViewService
        .findKeyInvolvementsForEntity(ref);

    // Assert
    verify(dao).findByEntityReference(isA(EntityReference.class));
    verify(dao).findPeopleByEntityReference(isA(EntityReference.class));
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(eq(EntityKind.ALL));
    verify(ref).kind();
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  void testFindKeyInvolvementsForEntity2() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.kindId()).thenReturn(1L);

    ArrayList<Involvement> involvementList = new ArrayList<>();
    involvementList.add(involvement);
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(involvementList);
    when(dao.findPeopleByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService2 = new InvolvementKindService(involvementKindDao);
    InvolvementViewService involvementViewService = new InvolvementViewService(involvementService,
        involvementKindService2, new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)),
        mock(InvolvementViewDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult = involvementViewService
        .findKeyInvolvementsForEntity(ref);

    // Assert
    verify(dao).findByEntityReference(isA(EntityReference.class));
    verify(dao).findPeopleByEntityReference(isA(EntityReference.class));
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(eq(EntityKind.ALL));
    verify(ref).kind();
    verify(involvement).kindId();
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  void testFindKeyInvolvementsForEntity3() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.kindId()).thenReturn(1L);
    Involvement involvement2 = mock(Involvement.class);
    when(involvement2.kindId()).thenReturn(1L);

    ArrayList<Involvement> involvementList = new ArrayList<>();
    involvementList.add(involvement2);
    involvementList.add(involvement);
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(involvementList);
    when(dao.findPeopleByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService2 = new InvolvementKindService(involvementKindDao);
    InvolvementViewService involvementViewService = new InvolvementViewService(involvementService,
        involvementKindService2, new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)),
        mock(InvolvementViewDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult = involvementViewService
        .findKeyInvolvementsForEntity(ref);

    // Assert
    verify(dao).findByEntityReference(isA(EntityReference.class));
    verify(dao).findPeopleByEntityReference(isA(EntityReference.class));
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(eq(EntityKind.ALL));
    verify(ref).kind();
    verify(involvement2).kindId();
    verify(involvement).kindId();
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  void testFindKeyInvolvementsForEntity4() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.kindId()).thenReturn(1L);
    Involvement involvement2 = mock(Involvement.class);
    when(involvement2.kindId()).thenReturn(1L);

    ArrayList<Involvement> involvementList = new ArrayList<>();
    involvementList.add(involvement2);
    involvementList.add(involvement);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");

    ArrayList<Person> personList = new ArrayList<>();
    personList.add(person);
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(involvementList);
    when(dao.findPeopleByEntityReference(Mockito.<EntityReference>any())).thenReturn(personList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService2 = new InvolvementKindService(involvementKindDao);
    InvolvementViewService involvementViewService = new InvolvementViewService(involvementService,
        involvementKindService2, new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)),
        mock(InvolvementViewDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult = involvementViewService
        .findKeyInvolvementsForEntity(ref);

    // Assert
    verify(dao).findByEntityReference(isA(EntityReference.class));
    verify(dao).findPeopleByEntityReference(isA(EntityReference.class));
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(eq(EntityKind.ALL));
    verify(ref).kind();
    verify(involvement2).kindId();
    verify(involvement).kindId();
    verify(person).employeeId();
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  void testFindKeyInvolvementsForEntity5() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.kindId()).thenReturn(1L);
    Involvement involvement2 = mock(Involvement.class);
    when(involvement2.kindId()).thenReturn(1L);

    ArrayList<Involvement> involvementList = new ArrayList<>();
    involvementList.add(involvement2);
    involvementList.add(involvement);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");
    Person person2 = mock(Person.class);
    when(person2.employeeId()).thenReturn("42");

    ArrayList<Person> personList = new ArrayList<>();
    personList.add(person2);
    personList.add(person);
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(involvementList);
    when(dao.findPeopleByEntityReference(Mockito.<EntityReference>any())).thenReturn(personList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService2 = new InvolvementKindService(involvementKindDao);
    InvolvementViewService involvementViewService = new InvolvementViewService(involvementService,
        involvementKindService2, new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)),
        mock(InvolvementViewDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult = involvementViewService
        .findKeyInvolvementsForEntity(ref);

    // Assert
    verify(dao).findByEntityReference(isA(EntityReference.class));
    verify(dao).findPeopleByEntityReference(isA(EntityReference.class));
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(eq(EntityKind.ALL));
    verify(ref).kind();
    verify(involvement2).kindId();
    verify(involvement).kindId();
    verify(person2).employeeId();
    verify(person).employeeId();
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  void testFindKeyInvolvementsForEntity6() {
    // Arrange
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    when(involvementService.findPeopleByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    InvolvementViewService involvementViewService = new InvolvementViewService(involvementService,
        involvementKindService, new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)),
        mock(InvolvementViewDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult = involvementViewService
        .findKeyInvolvementsForEntity(ref);

    // Assert
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(eq(EntityKind.ALL));
    verify(ref).kind();
    verify(involvementService).findByEntityReference(isA(EntityReference.class));
    verify(involvementService).findPeopleByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  void testFindKeyInvolvementsForEntity7() {
    // Arrange
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    when(involvementService.findPeopleByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    InvolvementKind involvementKind = mock(InvolvementKind.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(involvementKind.id()).thenReturn(ofResult);

    ArrayList<InvolvementKind> involvementKindList = new ArrayList<>();
    involvementKindList.add(involvementKind);
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(involvementKindList);
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    InvolvementViewService involvementViewService = new InvolvementViewService(involvementService,
        involvementKindService, new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)),
        mock(InvolvementViewDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult = involvementViewService
        .findKeyInvolvementsForEntity(ref);

    // Assert
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(eq(EntityKind.ALL));
    verify(ref).kind();
    verify(involvementKind).id();
    verify(involvementService).findByEntityReference(isA(EntityReference.class));
    verify(involvementService).findPeopleByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  void testFindKeyInvolvementsForEntity8() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");
    when(involvement.kindId()).thenReturn(1L);

    ArrayList<Involvement> involvementList = new ArrayList<>();
    involvementList.add(involvement);
    Person person = mock(Person.class);
    when(person.isRemoved()).thenReturn(true);
    when(person.employeeId()).thenReturn("42");

    ArrayList<Person> personList = new ArrayList<>();
    personList.add(person);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(involvementList);
    when(involvementService.findPeopleByEntityReference(Mockito.<EntityReference>any())).thenReturn(personList);
    InvolvementKind involvementKind = mock(InvolvementKind.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(involvementKind.id()).thenReturn(ofResult);

    ArrayList<InvolvementKind> involvementKindList = new ArrayList<>();
    involvementKindList.add(involvementKind);
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(involvementKindList);
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    InvolvementViewService involvementViewService = new InvolvementViewService(involvementService,
        involvementKindService, new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)),
        mock(InvolvementViewDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult = involvementViewService
        .findKeyInvolvementsForEntity(ref);

    // Assert
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(eq(EntityKind.ALL));
    verify(ref).kind();
    verify(involvementKind).id();
    verify(involvement).employeeId();
    verify(involvement, atLeast(1)).kindId();
    verify(person).employeeId();
    verify(person).isRemoved();
    verify(involvementService).findByEntityReference(isA(EntityReference.class));
    verify(involvementService).findPeopleByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  void testFindKeyInvolvementsForEntity9() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");
    when(involvement.kindId()).thenReturn(1L);

    ArrayList<Involvement> involvementList = new ArrayList<>();
    involvementList.add(involvement);
    Person person = mock(Person.class);
    when(person.isRemoved()).thenReturn(false);
    when(person.employeeId()).thenReturn("42");

    ArrayList<Person> personList = new ArrayList<>();
    personList.add(person);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(involvementList);
    when(involvementService.findPeopleByEntityReference(Mockito.<EntityReference>any())).thenReturn(personList);
    InvolvementKind involvementKind = mock(InvolvementKind.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(involvementKind.id()).thenReturn(ofResult);

    ArrayList<InvolvementKind> involvementKindList = new ArrayList<>();
    involvementKindList.add(involvementKind);
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(involvementKindList);
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    InvolvementViewService involvementViewService = new InvolvementViewService(involvementService,
        involvementKindService, new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)),
        mock(InvolvementViewDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult = involvementViewService
        .findKeyInvolvementsForEntity(ref);

    // Assert
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(eq(EntityKind.ALL));
    verify(ref).kind();
    verify(involvementKind).id();
    verify(involvement).employeeId();
    verify(involvement, atLeast(1)).kindId();
    verify(person).employeeId();
    verify(person).isRemoved();
    verify(involvementService).findByEntityReference(isA(EntityReference.class));
    verify(involvementService).findPeopleByEntityReference(isA(EntityReference.class));
    assertEquals(1, actualFindKeyInvolvementsForEntityResult.size());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  void testFindKeyInvolvementsForEntity10() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.kindId()).thenReturn(1L);

    ArrayList<Involvement> involvementList = new ArrayList<>();
    involvementList.add(involvement);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");

    ArrayList<Person> personList = new ArrayList<>();
    personList.add(person);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(involvementList);
    when(involvementService.findPeopleByEntityReference(Mockito.<EntityReference>any())).thenReturn(personList);
    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    InvolvementViewService involvementViewService = new InvolvementViewService(involvementService,
        involvementKindService, new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)),
        mock(InvolvementViewDao.class));
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult = involvementViewService
        .findKeyInvolvementsForEntity(ref);

    // Assert
    verify(ref).kind();
    verify(involvement).kindId();
    verify(person).employeeId();
    verify(involvementService).findByEntityReference(isA(EntityReference.class));
    verify(involvementService).findPeopleByEntityReference(isA(EntityReference.class));
    verify(involvementKindService).findKeyInvolvementKindsByEntityKind(eq(EntityKind.ALL));
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findByKindIdAndEntityKind(long, EntityKind)}
   */
  @Test
  void testFindByKindIdAndEntityKind() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByKindIdAndEntityKind(anyLong(), Mockito.<EntityKind>any())).thenReturn(new HashSet<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));

    // Act
    Set<InvolvementViewItem> actualFindByKindIdAndEntityKindResult = (new InvolvementViewService(involvementService,
        new InvolvementKindService(mock(InvolvementKindDao.class)), personService2, mock(InvolvementViewDao.class)))
            .findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(dao).findByKindIdAndEntityKind(eq(1L), eq(EntityKind.ALL));
    verify(personDao3).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindByKindIdAndEntityKindResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findByKindIdAndEntityKind(long, EntityKind)}
   */
  @Test
  void testFindByKindIdAndEntityKind2() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");

    HashSet<Involvement> involvementSet = new HashSet<>();
    involvementSet.add(involvement);
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByKindIdAndEntityKind(anyLong(), Mockito.<EntityKind>any())).thenReturn(involvementSet);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));

    // Act
    Set<InvolvementViewItem> actualFindByKindIdAndEntityKindResult = (new InvolvementViewService(involvementService,
        new InvolvementKindService(mock(InvolvementKindDao.class)), personService2, mock(InvolvementViewDao.class)))
            .findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(dao).findByKindIdAndEntityKind(eq(1L), eq(EntityKind.ALL));
    verify(personDao3).findByEmployeeIds(isA(Set.class));
    verify(involvement, atLeast(1)).employeeId();
    assertTrue(actualFindByKindIdAndEntityKindResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findByKindIdAndEntityKind(long, EntityKind)}
   */
  @Test
  void testFindByKindIdAndEntityKind3() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");
    Involvement involvement2 = mock(Involvement.class);
    when(involvement2.employeeId()).thenReturn("42");

    HashSet<Involvement> involvementSet = new HashSet<>();
    involvementSet.add(involvement2);
    involvementSet.add(involvement);
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByKindIdAndEntityKind(anyLong(), Mockito.<EntityKind>any())).thenReturn(involvementSet);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));

    // Act
    Set<InvolvementViewItem> actualFindByKindIdAndEntityKindResult = (new InvolvementViewService(involvementService,
        new InvolvementKindService(mock(InvolvementKindDao.class)), personService2, mock(InvolvementViewDao.class)))
            .findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(dao).findByKindIdAndEntityKind(eq(1L), eq(EntityKind.ALL));
    verify(personDao3).findByEmployeeIds(isA(Set.class));
    verify(involvement2, atLeast(1)).employeeId();
    verify(involvement, atLeast(1)).employeeId();
    assertTrue(actualFindByKindIdAndEntityKindResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findByKindIdAndEntityKind(long, EntityKind)}
   */
  @Test
  void testFindByKindIdAndEntityKind4() {
    // Arrange
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByKindIdAndEntityKind(anyLong(), Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    Set<InvolvementViewItem> actualFindByKindIdAndEntityKindResult = (new InvolvementViewService(involvementService,
        new InvolvementKindService(mock(InvolvementKindDao.class)), personService, mock(InvolvementViewDao.class)))
            .findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(personDao).findByEmployeeIds(isA(Set.class));
    verify(involvementService).findByKindIdAndEntityKind(eq(1L), eq(EntityKind.ALL));
    assertTrue(actualFindByKindIdAndEntityKindResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findByKindIdAndEntityKind(long, EntityKind)}
   */
  @Test
  void testFindByKindIdAndEntityKind5() {
    // Arrange
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByKindIdAndEntityKind(anyLong(), Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(person);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(personSet);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    Set<InvolvementViewItem> actualFindByKindIdAndEntityKindResult = (new InvolvementViewService(involvementService,
        new InvolvementKindService(mock(InvolvementKindDao.class)), personService, mock(InvolvementViewDao.class)))
            .findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(personDao).findByEmployeeIds(isA(Set.class));
    verify(person).employeeId();
    verify(involvementService).findByKindIdAndEntityKind(eq(1L), eq(EntityKind.ALL));
    assertTrue(actualFindByKindIdAndEntityKindResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findByKindIdAndEntityKind(long, EntityKind)}
   */
  @Test
  void testFindByKindIdAndEntityKind6() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");

    HashSet<Involvement> involvementSet = new HashSet<>();
    involvementSet.add(involvement);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByKindIdAndEntityKind(anyLong(), Mockito.<EntityKind>any())).thenReturn(involvementSet);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(person);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(personSet);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    Set<InvolvementViewItem> actualFindByKindIdAndEntityKindResult = (new InvolvementViewService(involvementService,
        new InvolvementKindService(mock(InvolvementKindDao.class)), personService, mock(InvolvementViewDao.class)))
            .findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(personDao).findByEmployeeIds(isA(Set.class));
    verify(involvement, atLeast(1)).employeeId();
    verify(person).employeeId();
    verify(involvementService).findByKindIdAndEntityKind(eq(1L), eq(EntityKind.ALL));
    assertEquals(1, actualFindByKindIdAndEntityKindResult.size());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findByKindIdAndEntityKind(long, EntityKind)}
   */
  @Test
  void testFindByKindIdAndEntityKind7() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");

    HashSet<Involvement> involvementSet = new HashSet<>();
    involvementSet.add(involvement);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByKindIdAndEntityKind(anyLong(), Mockito.<EntityKind>any())).thenReturn(involvementSet);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");
    Person person2 = mock(Person.class);
    when(person2.employeeId()).thenReturn("42");

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(person2);
    personSet.add(person);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(personSet);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    Set<InvolvementViewItem> actualFindByKindIdAndEntityKindResult = (new InvolvementViewService(involvementService,
        new InvolvementKindService(mock(InvolvementKindDao.class)), personService, mock(InvolvementViewDao.class)))
            .findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(personDao).findByEmployeeIds(isA(Set.class));
    verify(involvement, atLeast(1)).employeeId();
    verify(person2).employeeId();
    verify(person).employeeId();
    verify(involvementService).findByKindIdAndEntityKind(eq(1L), eq(EntityKind.ALL));
    assertEquals(1, actualFindByKindIdAndEntityKindResult.size());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#findByKindIdAndEntityKind(long, EntityKind)}
   */
  @Test
  void testFindByKindIdAndEntityKind8() {
    // Arrange
    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");

    HashSet<Involvement> involvementSet = new HashSet<>();
    involvementSet.add(involvement);
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByKindIdAndEntityKind(anyLong(), Mockito.<EntityKind>any())).thenReturn(involvementSet);
    PersonService personService = mock(PersonService.class);
    when(personService.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());

    // Act
    Set<InvolvementViewItem> actualFindByKindIdAndEntityKindResult = (new InvolvementViewService(involvementService,
        new InvolvementKindService(mock(InvolvementKindDao.class)), personService, mock(InvolvementViewDao.class)))
            .findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(involvement, atLeast(1)).employeeId();
    verify(involvementService).findByKindIdAndEntityKind(eq(1L), eq(EntityKind.ALL));
    verify(personService).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindByKindIdAndEntityKindResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#getAllInvolvements(EntityReference)}
   */
  @Test
  void testGetAllInvolvements() {
    // Arrange
    InvolvementViewDao involvementViewDao = mock(InvolvementViewDao.class);
    Mockito
        .<Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>>when(
            involvementViewDao.findAllInvolvements(Mockito.<EntityReference>any()))
        .thenReturn(new HashMap<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    InvolvementKindService involvementKindService2 = new InvolvementKindService(mock(InvolvementKindDao.class));

    // Act
    InvolvementDetailByDirectionResults actualAllInvolvements = (new InvolvementViewService(involvementService,
        involvementKindService2, new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)),
        involvementViewDao)).getAllInvolvements(null);

    // Assert
    verify(involvementViewDao).findAllInvolvements(isNull());
    assertTrue(actualAllInvolvements instanceof ImmutableInvolvementDetailByDirectionResults);
    Set<InvolvementDetail> ancestorsResult = actualAllInvolvements.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualAllInvolvements.descendents());
    assertSame(ancestorsResult, actualAllInvolvements.exact());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#getAllInvolvements(EntityReference)}
   */
  @Test
  void testGetAllInvolvements2() {
    // Arrange
    HashMap<HierarchyDirection, Collection<InvolvementDetail>> hierarchyDirectionCollectionMap = new HashMap<>();
    hierarchyDirectionCollectionMap.put(HierarchyDirection.EXACT, new ArrayList<>());
    InvolvementViewDao involvementViewDao = mock(InvolvementViewDao.class);
    Mockito
        .<Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>>when(
            involvementViewDao.findAllInvolvements(Mockito.<EntityReference>any()))
        .thenReturn(hierarchyDirectionCollectionMap);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    InvolvementKindService involvementKindService2 = new InvolvementKindService(mock(InvolvementKindDao.class));

    // Act
    InvolvementDetailByDirectionResults actualAllInvolvements = (new InvolvementViewService(involvementService,
        involvementKindService2, new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)),
        involvementViewDao)).getAllInvolvements(null);

    // Assert
    verify(involvementViewDao).findAllInvolvements(isNull());
    assertTrue(actualAllInvolvements instanceof ImmutableInvolvementDetailByDirectionResults);
    Set<InvolvementDetail> ancestorsResult = actualAllInvolvements.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualAllInvolvements.descendents());
    assertSame(ancestorsResult, actualAllInvolvements.exact());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#getAllInvolvements(EntityReference)}
   */
  @Test
  void testGetAllInvolvements3() {
    // Arrange
    ArrayList<InvolvementDetail> involvementDetailList = new ArrayList<>();
    involvementDetailList.add(mock(InvolvementDetail.class));

    HashMap<HierarchyDirection, Collection<InvolvementDetail>> hierarchyDirectionCollectionMap = new HashMap<>();
    hierarchyDirectionCollectionMap.put(HierarchyDirection.EXACT, involvementDetailList);
    InvolvementViewDao involvementViewDao = mock(InvolvementViewDao.class);
    Mockito
        .<Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>>when(
            involvementViewDao.findAllInvolvements(Mockito.<EntityReference>any()))
        .thenReturn(hierarchyDirectionCollectionMap);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    InvolvementKindService involvementKindService2 = new InvolvementKindService(mock(InvolvementKindDao.class));

    // Act
    InvolvementDetailByDirectionResults actualAllInvolvements = (new InvolvementViewService(involvementService,
        involvementKindService2, new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)),
        involvementViewDao)).getAllInvolvements(null);

    // Assert
    verify(involvementViewDao).findAllInvolvements(isNull());
    assertTrue(actualAllInvolvements instanceof ImmutableInvolvementDetailByDirectionResults);
    assertEquals(1, actualAllInvolvements.exact().size());
    Set<InvolvementDetail> ancestorsResult = actualAllInvolvements.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualAllInvolvements.descendents());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#getAllInvolvements(EntityReference)}
   */
  @Test
  void testGetAllInvolvements4() {
    // Arrange
    ArrayList<InvolvementDetail> involvementDetailList = new ArrayList<>();
    involvementDetailList.add(mock(InvolvementDetail.class));
    involvementDetailList.add(mock(InvolvementDetail.class));

    HashMap<HierarchyDirection, Collection<InvolvementDetail>> hierarchyDirectionCollectionMap = new HashMap<>();
    hierarchyDirectionCollectionMap.put(HierarchyDirection.EXACT, involvementDetailList);
    InvolvementViewDao involvementViewDao = mock(InvolvementViewDao.class);
    Mockito
        .<Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>>when(
            involvementViewDao.findAllInvolvements(Mockito.<EntityReference>any()))
        .thenReturn(hierarchyDirectionCollectionMap);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    InvolvementKindService involvementKindService2 = new InvolvementKindService(mock(InvolvementKindDao.class));

    // Act
    InvolvementDetailByDirectionResults actualAllInvolvements = (new InvolvementViewService(involvementService,
        involvementKindService2, new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)),
        involvementViewDao)).getAllInvolvements(null);

    // Assert
    verify(involvementViewDao).findAllInvolvements(isNull());
    assertTrue(actualAllInvolvements instanceof ImmutableInvolvementDetailByDirectionResults);
    assertEquals(2, actualAllInvolvements.exact().size());
    Set<InvolvementDetail> ancestorsResult = actualAllInvolvements.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualAllInvolvements.descendents());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#getAllInvolvements(EntityReference)}
   */
  @Test
  void testGetAllInvolvements5() {
    // Arrange
    ArrayList<InvolvementDetail> involvementDetailList = new ArrayList<>();
    involvementDetailList.add(mock(InvolvementDetail.class));

    HashMap<HierarchyDirection, Collection<InvolvementDetail>> hierarchyDirectionCollectionMap = new HashMap<>();
    hierarchyDirectionCollectionMap.put(HierarchyDirection.ANCESTOR, involvementDetailList);
    InvolvementViewDao involvementViewDao = mock(InvolvementViewDao.class);
    Mockito
        .<Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>>when(
            involvementViewDao.findAllInvolvements(Mockito.<EntityReference>any()))
        .thenReturn(hierarchyDirectionCollectionMap);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    InvolvementKindService involvementKindService2 = new InvolvementKindService(mock(InvolvementKindDao.class));

    // Act
    InvolvementDetailByDirectionResults actualAllInvolvements = (new InvolvementViewService(involvementService,
        involvementKindService2, new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)),
        involvementViewDao)).getAllInvolvements(null);

    // Assert
    verify(involvementViewDao).findAllInvolvements(isNull());
    assertTrue(actualAllInvolvements instanceof ImmutableInvolvementDetailByDirectionResults);
    assertEquals(1, actualAllInvolvements.ancestors().size());
    Set<InvolvementDetail> descendentsResult = actualAllInvolvements.descendents();
    assertTrue(descendentsResult.isEmpty());
    assertSame(descendentsResult, actualAllInvolvements.exact());
  }

  /**
   * Method under test:
   * {@link InvolvementViewService#getAllInvolvements(EntityReference)}
   */
  @Test
  void testGetAllInvolvements6() {
    // Arrange
    ArrayList<InvolvementDetail> involvementDetailList = new ArrayList<>();
    involvementDetailList.add(mock(InvolvementDetail.class));

    HashMap<HierarchyDirection, Collection<InvolvementDetail>> hierarchyDirectionCollectionMap = new HashMap<>();
    hierarchyDirectionCollectionMap.put(HierarchyDirection.DESCENDENT, involvementDetailList);
    InvolvementViewDao involvementViewDao = mock(InvolvementViewDao.class);
    Mockito
        .<Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>>when(
            involvementViewDao.findAllInvolvements(Mockito.<EntityReference>any()))
        .thenReturn(hierarchyDirectionCollectionMap);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService = new InvolvementKindService(mock(InvolvementKindDao.class));
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
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())));

    InvolvementKindService involvementKindService2 = new InvolvementKindService(mock(InvolvementKindDao.class));

    // Act
    InvolvementDetailByDirectionResults actualAllInvolvements = (new InvolvementViewService(involvementService,
        involvementKindService2, new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class)),
        involvementViewDao)).getAllInvolvements(null);

    // Assert
    verify(involvementViewDao).findAllInvolvements(isNull());
    assertTrue(actualAllInvolvements instanceof ImmutableInvolvementDetailByDirectionResults);
    assertEquals(1, actualAllInvolvements.descendents().size());
    Set<InvolvementDetail> ancestorsResult = actualAllInvolvements.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualAllInvolvements.exact());
  }
}
