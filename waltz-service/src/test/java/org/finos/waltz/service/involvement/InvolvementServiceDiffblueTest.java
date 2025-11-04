package org.finos.waltz.service.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.GenericSelector;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.involvement.EntityInvolvementChangeCommand;
import org.finos.waltz.model.involvement.Involvement;
import org.finos.waltz.model.involvement_kind.InvolvementKind;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.user.SystemRole;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InvolvementServiceDiffblueTest {
  /**
   * Method under test:
   * {@link InvolvementService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    ArrayList<Involvement> involvementList = new ArrayList<>();
    when(dao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(involvementList);
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

    // Act
    List<Involvement> actualFindByEntityReferenceResult = (new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())))).findByEntityReference(mock(EntityReference.class));

    // Assert
    verify(dao).findByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(involvementList, actualFindByEntityReferenceResult);
  }

  /**
   * Method under test: {@link InvolvementService#findByEmployeeId(String)}
   */
  @Test
  void testFindByEmployeeId() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    ArrayList<Involvement> involvementList = new ArrayList<>();
    when(dao.findByEmployeeId(Mockito.<String>any())).thenReturn(involvementList);
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

    // Act
    List<Involvement> actualFindByEmployeeIdResult = (new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())))).findByEmployeeId("42");

    // Assert
    verify(dao).findByEmployeeId(eq("42"));
    assertTrue(actualFindByEmployeeIdResult.isEmpty());
    assertSame(involvementList, actualFindByEmployeeIdResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#findExistingInvolvementKindIdsForUser(EntityReference, String)}
   */
  @Test
  void testFindExistingInvolvementKindIdsForUser() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    HashSet<Long> resultLongSet = new HashSet<>();
    when(dao.findExistingInvolvementKindIdsForUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(resultLongSet);
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
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    Set<Long> actualFindExistingInvolvementKindIdsForUserResult = involvementService
        .findExistingInvolvementKindIdsForUser(entityReference, "janedoe");

    // Assert
    verify(dao).findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(entityReference, atLeast(1)).kind();
    assertTrue(actualFindExistingInvolvementKindIdsForUserResult.isEmpty());
    assertSame(resultLongSet, actualFindExistingInvolvementKindIdsForUserResult);
  }

  /**
   * Method under test: {@link InvolvementService#findAllByEmployeeId(String)}
   */
  @Test
  void testFindAllByEmployeeId() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    ArrayList<Involvement> involvementList = new ArrayList<>();
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

    // Act
    List<Involvement> actualFindAllByEmployeeIdResult = (new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())))).findAllByEmployeeId("42");

    // Assert
    verify(dao).findAllByEmployeeId(eq("42"));
    assertTrue(actualFindAllByEmployeeIdResult.isEmpty());
    assertSame(involvementList, actualFindAllByEmployeeIdResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#findInvolvementsByKindAndEntityKind(Long, EntityKind)}
   */
  @Test
  void testFindInvolvementsByKindAndEntityKind() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    HashSet<Involvement> involvementSet = new HashSet<>();
    when(dao.findInvolvementsByKindAndEntityKind(Mockito.<Long>any(), Mockito.<EntityKind>any()))
        .thenReturn(involvementSet);
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

    // Act
    Set<Involvement> actualFindInvolvementsByKindAndEntityKindResult = (new InvolvementService(changeLogService, dao,
        logicalFlowDao, physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())))).findInvolvementsByKindAndEntityKind(1L,
                EntityKind.ALL);

    // Assert
    verify(dao).findInvolvementsByKindAndEntityKind(eq(1L), eq(EntityKind.ALL));
    assertTrue(actualFindInvolvementsByKindAndEntityKindResult.isEmpty());
    assertSame(involvementSet, actualFindInvolvementsByKindAndEntityKindResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#findPeopleByEntityReference(EntityReference)}
   */
  @Test
  void testFindPeopleByEntityReference() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    ArrayList<Person> personList = new ArrayList<>();
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

    // Act
    List<Person> actualFindPeopleByEntityReferenceResult = (new InvolvementService(changeLogService, dao,
        logicalFlowDao, physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>()))))
                .findPeopleByEntityReference(mock(EntityReference.class));

    // Assert
    verify(dao).findPeopleByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindPeopleByEntityReferenceResult.isEmpty());
    assertSame(personList, actualFindPeopleByEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#findPeopleByGenericEntitySelector(IdSelectionOptions)}
   */
  @Test
  void testFindPeopleByGenericEntitySelector() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    ArrayList<Person> personList = new ArrayList<>();
    when(dao.findPeopleByGenericEntitySelector(Mockito.<GenericSelector>any())).thenReturn(personList);
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
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    List<Person> actualFindPeopleByGenericEntitySelectorResult = involvementService
        .findPeopleByGenericEntitySelector(selectionOptions);

    // Assert
    verify(dao).findPeopleByGenericEntitySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindPeopleByGenericEntitySelectorResult.isEmpty());
    assertSame(personList, actualFindPeopleByGenericEntitySelectorResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)}
   */
  @Test
  void testAddEntityInvolvement() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(1);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any())).thenReturn(new ArrayList<>());
    InvolvementKind involvementKind = mock(InvolvementKind.class);
    when(involvementKind.permittedRole()).thenReturn("Permitted Role");
    when(involvementKind.name()).thenReturn("Name");
    when(involvementKind.userSelectable()).thenReturn(true);
    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong())).thenReturn(involvementKind);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, mock(LogicalFlowDao.class),
        mock(PhysicalFlowDao.class), entityReferenceNameResolver, involvementKindService, personDao, userRoleService);
    EntityReference entityReference = mock(EntityReference.class);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    when(entityReference2.id()).thenReturn(1L);
    EntityInvolvementChangeCommand command = mock(EntityInvolvementChangeCommand.class);
    when(command.operation()).thenReturn(Operation.ADD);
    when(command.personEntityRef()).thenReturn(entityReference2);
    when(command.involvementKindId()).thenReturn(1);

    // Act
    boolean actualAddEntityInvolvementResult = involvementService.addEntityInvolvement("42", entityReference, command);

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(dao).save(isA(Involvement.class));
    verify(personDao).getById(eq(1L));
    verify(entityReference2).id();
    verify(entityReference2).kind();
    verify(involvementKind, atLeast(1)).name();
    verify(command, atLeast(1)).involvementKindId();
    verify(command, atLeast(1)).operation();
    verify(command, atLeast(1)).personEntityRef();
    verify(involvementKind, atLeast(1)).permittedRole();
    verify(involvementKind).userSelectable();
    verify(person).employeeId();
    verify(involvementKindService).findAll();
    verify(involvementKindService, atLeast(1)).getById(eq(1L));
    verify(userRoleService).hasAnyRole(eq("42"), isA(Set.class));
    assertTrue(actualAddEntityInvolvementResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)}
   */
  @Test
  void testAddEntityInvolvement2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(1);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any())).thenReturn(new ArrayList<>());
    InvolvementKind involvementKind = mock(InvolvementKind.class);
    when(involvementKind.permittedRole()).thenReturn("Permitted Role");
    when(involvementKind.name()).thenReturn("Name");
    when(involvementKind.userSelectable()).thenReturn(true);
    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong())).thenReturn(involvementKind);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, mock(LogicalFlowDao.class),
        mock(PhysicalFlowDao.class), entityReferenceNameResolver, involvementKindService, personDao, userRoleService);
    EntityReference entityReference = mock(EntityReference.class);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    when(entityReference2.id()).thenReturn(1L);
    EntityInvolvementChangeCommand command = mock(EntityInvolvementChangeCommand.class);
    when(command.operation()).thenReturn(Operation.ADD);
    when(command.personEntityRef()).thenReturn(entityReference2);
    when(command.involvementKindId()).thenReturn(1);

    // Act
    boolean actualAddEntityInvolvementResult = involvementService.addEntityInvolvement("42", entityReference, command);

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(dao).save(isA(Involvement.class));
    verify(personDao).getById(eq(1L));
    verify(entityReference2).id();
    verify(entityReference2).kind();
    verify(involvementKind, atLeast(1)).name();
    verify(command, atLeast(1)).involvementKindId();
    verify(command, atLeast(1)).operation();
    verify(command, atLeast(1)).personEntityRef();
    verify(involvementKind, atLeast(1)).permittedRole();
    verify(involvementKind).userSelectable();
    verify(person).employeeId();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(involvementKindService).findAll();
    verify(involvementKindService, atLeast(1)).getById(eq(1L));
    verify(userRoleService).hasAnyRole(eq("42"), isA(Set.class));
    assertTrue(actualAddEntityInvolvementResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)}
   */
  @Test
  void testAddEntityInvolvement3() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(14);
    InvolvementKind involvementKind = mock(InvolvementKind.class);
    when(involvementKind.permittedRole()).thenReturn("Permitted Role");
    when(involvementKind.name()).thenReturn("Name");
    when(involvementKind.userSelectable()).thenReturn(true);
    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.getById(anyLong())).thenReturn(involvementKind);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    InvolvementService involvementService = new InvolvementService(mock(ChangeLogService.class), dao,
        mock(LogicalFlowDao.class), mock(PhysicalFlowDao.class), mock(EntityReferenceNameResolver.class),
        involvementKindService, personDao, userRoleService);
    EntityReference entityReference = mock(EntityReference.class);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    EntityInvolvementChangeCommand command = mock(EntityInvolvementChangeCommand.class);
    when(command.personEntityRef()).thenReturn(entityReference2);
    when(command.involvementKindId()).thenReturn(1);

    // Act
    boolean actualAddEntityInvolvementResult = involvementService.addEntityInvolvement("42", entityReference, command);

    // Assert
    verify(dao).save(isA(Involvement.class));
    verify(personDao).getById(eq(1L));
    verify(entityReference2).id();
    verify(involvementKind, atLeast(1)).name();
    verify(command, atLeast(1)).involvementKindId();
    verify(command).personEntityRef();
    verify(involvementKind, atLeast(1)).permittedRole();
    verify(involvementKind).userSelectable();
    verify(person).employeeId();
    verify(involvementKindService, atLeast(1)).getById(eq(1L));
    verify(userRoleService).hasAnyRole(eq("42"), isA(Set.class));
    assertFalse(actualAddEntityInvolvementResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)}
   */
  @Test
  void testAddEntityInvolvement4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(1);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(entityReference);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any())).thenReturn(entityReferenceList);
    InvolvementKind involvementKind = mock(InvolvementKind.class);
    when(involvementKind.permittedRole()).thenReturn("Permitted Role");
    when(involvementKind.name()).thenReturn("Name");
    when(involvementKind.userSelectable()).thenReturn(true);
    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong())).thenReturn(involvementKind);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    InvolvementService involvementService = new InvolvementService(changeLogService, dao, mock(LogicalFlowDao.class),
        mock(PhysicalFlowDao.class), entityReferenceNameResolver, involvementKindService, personDao, userRoleService);
    EntityReference entityReference2 = mock(EntityReference.class);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.kind()).thenReturn(EntityKind.ALL);
    when(entityReference3.id()).thenReturn(1L);
    EntityInvolvementChangeCommand command = mock(EntityInvolvementChangeCommand.class);
    when(command.operation()).thenReturn(Operation.ADD);
    when(command.personEntityRef()).thenReturn(entityReference3);
    when(command.involvementKindId()).thenReturn(1);

    // Act
    boolean actualAddEntityInvolvementResult = involvementService.addEntityInvolvement("42", entityReference2, command);

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(dao).save(isA(Involvement.class));
    verify(personDao).getById(eq(1L));
    verify(entityReference).id();
    verify(entityReference3).id();
    verify(entityReference).kind();
    verify(entityReference3).kind();
    verify(entityReference).name();
    verify(involvementKind, atLeast(1)).name();
    verify(command, atLeast(1)).involvementKindId();
    verify(command, atLeast(1)).operation();
    verify(command, atLeast(1)).personEntityRef();
    verify(involvementKind, atLeast(1)).permittedRole();
    verify(involvementKind).userSelectable();
    verify(person).employeeId();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(involvementKindService).findAll();
    verify(involvementKindService, atLeast(1)).getById(eq(1L));
    verify(userRoleService).hasAnyRole(eq("42"), isA(Set.class));
    assertTrue(actualAddEntityInvolvementResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)}
   */
  @Test
  void testRemoveEntityInvolvement() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.remove(Mockito.<Involvement>any())).thenReturn(1);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any())).thenReturn(new ArrayList<>());
    InvolvementKind involvementKind = mock(InvolvementKind.class);
    when(involvementKind.permittedRole()).thenReturn("");
    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong())).thenReturn(involvementKind);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
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
    EntityReference entityReference = mock(EntityReference.class);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    when(entityReference2.id()).thenReturn(1L);
    EntityInvolvementChangeCommand command = mock(EntityInvolvementChangeCommand.class);
    when(command.operation()).thenReturn(Operation.ADD);
    when(command.involvementKindId()).thenReturn(1);
    when(command.personEntityRef()).thenReturn(entityReference2);

    // Act
    boolean actualRemoveEntityInvolvementResult = involvementService.removeEntityInvolvement("42", entityReference,
        command);

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(dao).remove(isA(Involvement.class));
    verify(personDao).getById(eq(1L));
    verify(entityReference2).id();
    verify(entityReference2).kind();
    verify(command, atLeast(1)).involvementKindId();
    verify(command, atLeast(1)).operation();
    verify(command, atLeast(1)).personEntityRef();
    verify(involvementKind).permittedRole();
    verify(person).employeeId();
    verify(involvementKindService).findAll();
    verify(involvementKindService).getById(eq(1L));
    assertTrue(actualRemoveEntityInvolvementResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)}
   */
  @Test
  void testRemoveEntityInvolvement2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.remove(Mockito.<Involvement>any())).thenReturn(1);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any())).thenReturn(new ArrayList<>());
    InvolvementKind involvementKind = mock(InvolvementKind.class);
    when(involvementKind.permittedRole()).thenReturn("");
    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong())).thenReturn(involvementKind);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
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
    EntityReference entityReference = mock(EntityReference.class);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    when(entityReference2.id()).thenReturn(1L);
    EntityInvolvementChangeCommand command = mock(EntityInvolvementChangeCommand.class);
    when(command.operation()).thenReturn(Operation.ADD);
    when(command.involvementKindId()).thenReturn(1);
    when(command.personEntityRef()).thenReturn(entityReference2);

    // Act
    boolean actualRemoveEntityInvolvementResult = involvementService.removeEntityInvolvement("42", entityReference,
        command);

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(dao).remove(isA(Involvement.class));
    verify(personDao).getById(eq(1L));
    verify(entityReference2).id();
    verify(entityReference2).kind();
    verify(command, atLeast(1)).involvementKindId();
    verify(command, atLeast(1)).operation();
    verify(command, atLeast(1)).personEntityRef();
    verify(involvementKind).permittedRole();
    verify(person).employeeId();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(involvementKindService).findAll();
    verify(involvementKindService).getById(eq(1L));
    assertTrue(actualRemoveEntityInvolvementResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)}
   */
  @Test
  void testRemoveEntityInvolvement3() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.remove(Mockito.<Involvement>any())).thenReturn(-3);
    InvolvementKind involvementKind = mock(InvolvementKind.class);
    when(involvementKind.permittedRole()).thenReturn("");
    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.getById(anyLong())).thenReturn(involvementKind);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
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
    EntityReference entityReference = mock(EntityReference.class);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    EntityInvolvementChangeCommand command = mock(EntityInvolvementChangeCommand.class);
    when(command.involvementKindId()).thenReturn(1);
    when(command.personEntityRef()).thenReturn(entityReference2);

    // Act
    boolean actualRemoveEntityInvolvementResult = involvementService.removeEntityInvolvement("42", entityReference,
        command);

    // Assert
    verify(dao).remove(isA(Involvement.class));
    verify(personDao).getById(eq(1L));
    verify(entityReference2).id();
    verify(command, atLeast(1)).involvementKindId();
    verify(command).personEntityRef();
    verify(involvementKind).permittedRole();
    verify(person).employeeId();
    verify(involvementKindService).getById(eq(1L));
    assertFalse(actualRemoveEntityInvolvementResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)}
   */
  @Test
  void testRemoveEntityInvolvement4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.remove(Mockito.<Involvement>any())).thenReturn(1);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(entityReference);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any())).thenReturn(entityReferenceList);
    InvolvementKind involvementKind = mock(InvolvementKind.class);
    when(involvementKind.permittedRole()).thenReturn("");
    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong())).thenReturn(involvementKind);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(person);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
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
    EntityReference entityReference2 = mock(EntityReference.class);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.kind()).thenReturn(EntityKind.ALL);
    when(entityReference3.id()).thenReturn(1L);
    EntityInvolvementChangeCommand command = mock(EntityInvolvementChangeCommand.class);
    when(command.operation()).thenReturn(Operation.ADD);
    when(command.involvementKindId()).thenReturn(1);
    when(command.personEntityRef()).thenReturn(entityReference3);

    // Act
    boolean actualRemoveEntityInvolvementResult = involvementService.removeEntityInvolvement("42", entityReference2,
        command);

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(dao).remove(isA(Involvement.class));
    verify(personDao).getById(eq(1L));
    verify(entityReference).id();
    verify(entityReference3).id();
    verify(entityReference).kind();
    verify(entityReference3).kind();
    verify(entityReference).name();
    verify(command, atLeast(1)).involvementKindId();
    verify(command, atLeast(1)).operation();
    verify(command, atLeast(1)).personEntityRef();
    verify(involvementKind).permittedRole();
    verify(person).employeeId();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(involvementKindService).findAll();
    verify(involvementKindService).getById(eq(1L));
    assertTrue(actualRemoveEntityInvolvementResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#findByGenericEntitySelector(IdSelectionOptions)}
   */
  @Test
  void testFindByGenericEntitySelector() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    ArrayList<Involvement> involvementList = new ArrayList<>();
    when(dao.findByGenericEntitySelector(Mockito.<GenericSelector>any())).thenReturn(involvementList);
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
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    Collection<Involvement> actualFindByGenericEntitySelectorResult = involvementService
        .findByGenericEntitySelector(selectionOptions);

    // Assert
    verify(dao).findByGenericEntitySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindByGenericEntitySelectorResult instanceof List);
    assertTrue(actualFindByGenericEntitySelectorResult.isEmpty());
    assertSame(involvementList, actualFindByGenericEntitySelectorResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#deleteByGenericEntitySelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteByGenericEntitySelector() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.deleteByGenericEntitySelector(Mockito.<GenericSelector>any())).thenReturn(1);
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
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteByGenericEntitySelectorResult = involvementService.deleteByGenericEntitySelector(selectionOptions);

    // Assert
    verify(dao).deleteByGenericEntitySelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByGenericEntitySelectorResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#countOrphanInvolvementsForKind(EntityKind)}
   */
  @Test
  void testCountOrphanInvolvementsForKind() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.countOrphanInvolvementsForKind(Mockito.<EntityKind>any())).thenReturn(3);
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

    // Act
    int actualCountOrphanInvolvementsForKindResult = (new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())))).countOrphanInvolvementsForKind(EntityKind.ALL);

    // Assert
    verify(dao).countOrphanInvolvementsForKind(eq(EntityKind.ALL));
    assertEquals(3, actualCountOrphanInvolvementsForKindResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#cleanupInvolvementsForKind(String, EntityKind)}
   */
  @Test
  void testCleanupInvolvementsForKind() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.cleanupInvolvementsForKind(Mockito.<EntityKind>any())).thenReturn(1);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) any())).thenReturn(true);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    int actualCleanupInvolvementsForKindResult = (new InvolvementService(changeLogService, dao, logicalFlowDao,
        physicalFlowDao, entityReferenceNameResolver, new InvolvementKindService(mock(InvolvementKindDao.class)),
        mock(PersonDao.class), userRoleService)).cleanupInvolvementsForKind("janedoe", EntityKind.ALL);

    // Assert
    verify(dao).cleanupInvolvementsForKind(eq(EntityKind.ALL));
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) any());
    assertEquals(1, actualCleanupInvolvementsForKindResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#bulkStoreInvolvements(Set, String)}
   */
  @Test
  void testBulkStoreInvolvements() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkStoreInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
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

    // Act
    int actualBulkStoreInvolvementsResult = involvementService.bulkStoreInvolvements(new HashSet<>(), "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(dao).bulkStoreInvolvements(isA(Set.class));
    verify(involvementKindDao).findAll();
    assertEquals(1, actualBulkStoreInvolvementsResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#bulkStoreInvolvements(Set, String)}
   */
  @Test
  void testBulkStoreInvolvements2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkStoreInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
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

    // Act
    int actualBulkStoreInvolvementsResult = involvementService.bulkStoreInvolvements(new HashSet<>(), "janedoe");

    // Assert
    verify(dao).bulkStoreInvolvements(isA(Set.class));
    verify(involvementKindDao).findAll();
    verify(changeLogService).write(isA(Collection.class));
    assertEquals(1, actualBulkStoreInvolvementsResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#bulkStoreInvolvements(Set, String)}
   */
  @Test
  void testBulkStoreInvolvements3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkStoreInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);
    InvolvementKind involvementKind = mock(InvolvementKind.class);
    when(involvementKind.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(involvementKind.id()).thenReturn(ofResult);

    ArrayList<InvolvementKind> involvementKindList = new ArrayList<>();
    involvementKindList.add(involvementKind);
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(involvementKindList);
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
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

    // Act
    int actualBulkStoreInvolvementsResult = involvementService.bulkStoreInvolvements(new HashSet<>(), "janedoe");

    // Assert
    verify(dao).bulkStoreInvolvements(isA(Set.class));
    verify(involvementKindDao).findAll();
    verify(involvementKind).id();
    verify(involvementKind).name();
    verify(changeLogService).write(isA(Collection.class));
    assertEquals(1, actualBulkStoreInvolvementsResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#bulkDeleteInvolvements(Set, String)}
   */
  @Test
  void testBulkDeleteInvolvements() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkDeleteInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
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

    // Act
    int actualBulkDeleteInvolvementsResult = involvementService.bulkDeleteInvolvements(new HashSet<>(), "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(dao).bulkDeleteInvolvements(isA(Set.class));
    verify(involvementKindDao).findAll();
    assertEquals(1, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#bulkDeleteInvolvements(Set, String)}
   */
  @Test
  void testBulkDeleteInvolvements2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkDeleteInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
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

    // Act
    int actualBulkDeleteInvolvementsResult = involvementService.bulkDeleteInvolvements(new HashSet<>(), "janedoe");

    // Assert
    verify(dao).bulkDeleteInvolvements(isA(Set.class));
    verify(involvementKindDao).findAll();
    verify(changeLogService).write(isA(Collection.class));
    assertEquals(1, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#bulkDeleteInvolvements(Set, String)}
   */
  @Test
  void testBulkDeleteInvolvements3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any())).thenReturn(new int[]{19088743, 1, 19088743, 1});
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkDeleteInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);
    InvolvementKind involvementKind = mock(InvolvementKind.class);
    when(involvementKind.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(involvementKind.id()).thenReturn(ofResult);

    ArrayList<InvolvementKind> involvementKindList = new ArrayList<>();
    involvementKindList.add(involvementKind);
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(involvementKindList);
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
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

    // Act
    int actualBulkDeleteInvolvementsResult = involvementService.bulkDeleteInvolvements(new HashSet<>(), "janedoe");

    // Assert
    verify(dao).bulkDeleteInvolvements(isA(Set.class));
    verify(involvementKindDao).findAll();
    verify(involvementKind).id();
    verify(involvementKind).name();
    verify(changeLogService).write(isA(Collection.class));
    assertEquals(1, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Method under test:
   * {@link InvolvementService#findByKindIdAndEntityKind(long, EntityKind)}
   */
  @Test
  void testFindByKindIdAndEntityKind() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    HashSet<Involvement> involvementSet = new HashSet<>();
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

    // Act
    Set<Involvement> actualFindByKindIdAndEntityKindResult = (new InvolvementService(changeLogService, dao,
        logicalFlowDao, physicalFlowDao, entityReferenceNameResolver, involvementKindService, personDao,
        new UserRoleService(userRoleDao, roleDao, personDao2, changeLogService2, personService,
            new SettingsService(settingsDao, new ArrayList<>())))).findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(dao).findByKindIdAndEntityKind(eq(1L), eq(EntityKind.ALL));
    assertTrue(actualFindByKindIdAndEntityKindResult.isEmpty());
    assertSame(involvementSet, actualFindByKindIdAndEntityKindResult);
  }
}
