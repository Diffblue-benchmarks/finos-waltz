package org.finos.waltz.service.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.involvement.EntityInvolvementChangeCommand;
import org.finos.waltz.model.involvement.ImmutableEntityInvolvementChangeCommand;
import org.finos.waltz.model.involvement.ImmutableEntityInvolvementChangeCommand.Builder;
import org.finos.waltz.model.involvement.ImmutableInvolvement;
import org.finos.waltz.model.involvement.Involvement;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKind;
import org.finos.waltz.model.involvement_kind.InvolvementKind;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.model.user.SystemRole;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class InvolvementServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private EntityReferenceNameResolver entityReferenceNameResolver;

  @Mock private InvolvementDao involvementDao;

  @Mock private InvolvementKindService involvementKindService;

  @InjectMocks private InvolvementService involvementService;

  @Mock private LogicalFlowDao logicalFlowDao;

  @Mock private PersonDao personDao;

  @Mock private PhysicalFlowDao physicalFlowDao;

  @Mock private UserRoleService userRoleService;

  /**
   * Test {@link InvolvementService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenReturnEmpty() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
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
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    List<Involvement> actualFindByEntityReferenceResult =
        involvementService.findByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dao).findByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link InvolvementService#findByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementService#findByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findByEmployeeId(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementService.findByEmployeeId(String)"})
  void testFindByEmployeeId_thenReturnEmpty() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByEmployeeId(Mockito.<String>any())).thenReturn(new ArrayList<>());
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
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    List<Involvement> actualFindByEmployeeIdResult = involvementService.findByEmployeeId("42");

    // Assert
    verify(dao).findByEmployeeId("42");
    assertTrue(actualFindByEmployeeIdResult.isEmpty());
  }

  /**
   * Test {@link InvolvementService#findExistingInvolvementKindIdsForUser(EntityReference, String)}.
   *
   * <p>Method under test: {@link
   * InvolvementService#findExistingInvolvementKindIdsForUser(EntityReference, String)}
   */
  @Test
  @DisplayName("Test findExistingInvolvementKindIdsForUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set InvolvementService.findExistingInvolvementKindIdsForUser(EntityReference, String)"
  })
  void testFindExistingInvolvementKindIdsForUser() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
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
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    Set<Long> actualFindExistingInvolvementKindIdsForUserResult =
        involvementService.findExistingInvolvementKindIdsForUser(
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
    verify(dao).findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    assertTrue(actualFindExistingInvolvementKindIdsForUserResult.isEmpty());
  }

  /**
   * Test {@link InvolvementService#findExistingInvolvementKindIdsForUser(EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>Then calls {@link EntityReference#kind()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InvolvementService#findExistingInvolvementKindIdsForUser(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test findExistingInvolvementKindIdsForUser(EntityReference, String); given 'ALL'; then calls kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set InvolvementService.findExistingInvolvementKindIdsForUser(EntityReference, String)"
  })
  void testFindExistingInvolvementKindIdsForUser_givenAll_thenCallsKind() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findExistingInvolvementKindIdsForUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());
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
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act
    Set<Long> actualFindExistingInvolvementKindIdsForUserResult =
        involvementService.findExistingInvolvementKindIdsForUser(entityReference, "janedoe");

    // Assert
    verify(dao).findExistingInvolvementKindIdsForUser(isA(EntityReference.class), eq("janedoe"));
    verify(entityReference, atLeast(1)).kind();
    assertTrue(actualFindExistingInvolvementKindIdsForUserResult.isEmpty());
  }

  /**
   * Test {@link InvolvementService#findAllByEmployeeId(String)}.
   *
   * <p>Method under test: {@link InvolvementService#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllByEmployeeId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementService.findAllByEmployeeId(String)"})
  void testFindAllByEmployeeId() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findAllByEmployeeId(Mockito.<String>any())).thenReturn(new ArrayList<>());
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
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    List<Involvement> actualFindAllByEmployeeIdResult =
        involvementService.findAllByEmployeeId("42");

    // Assert
    verify(dao).findAllByEmployeeId("42");
    assertTrue(actualFindAllByEmployeeIdResult.isEmpty());
  }

  /**
   * Test {@link InvolvementService#findInvolvementsByKindAndEntityKind(Long, EntityKind)}.
   *
   * <p>Method under test: {@link InvolvementService#findInvolvementsByKindAndEntityKind(Long,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test findInvolvementsByKindAndEntityKind(Long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set InvolvementService.findInvolvementsByKindAndEntityKind(Long, EntityKind)"
  })
  void testFindInvolvementsByKindAndEntityKind() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findInvolvementsByKindAndEntityKind(Mockito.<Long>any(), Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
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
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    Set<Involvement> actualFindInvolvementsByKindAndEntityKindResult =
        involvementService.findInvolvementsByKindAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(dao).findInvolvementsByKindAndEntityKind(1L, EntityKind.ALL);
    assertTrue(actualFindInvolvementsByKindAndEntityKindResult.isEmpty());
  }

  /**
   * Test {@link InvolvementService#findPeopleByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementService#findPeopleByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findPeopleByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InvolvementService.findPeopleByEntityReference(EntityReference)"})
  void testFindPeopleByEntityReference_thenReturnEmpty() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findPeopleByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
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
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    List<Person> actualFindPeopleByEntityReferenceResult =
        involvementService.findPeopleByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dao).findPeopleByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindPeopleByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link InvolvementService#findPeopleByGenericEntitySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * InvolvementService#findPeopleByGenericEntitySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findPeopleByGenericEntitySelector(IdSelectionOptions); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List InvolvementService.findPeopleByGenericEntitySelector(IdSelectionOptions)"
  })
  void testFindPeopleByGenericEntitySelector_thenReturnEmpty() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findPeopleByGenericEntitySelector(Mockito.<GenericSelector>any()))
        .thenReturn(new ArrayList<>());
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
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<Person> actualFindPeopleByGenericEntitySelectorResult =
        involvementService.findPeopleByGenericEntitySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(dao).findPeopleByGenericEntitySelector(isA(GenericSelector.class));
    assertTrue(actualFindPeopleByGenericEntitySelectorResult.isEmpty());
  }

  /**
   * Test {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <p>Method under test: {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName("Test addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testAddEntityInvolvement() {
    // Arrange
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(1);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(entityReferenceList);

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualAddEntityInvolvementResult =
        involvementService.addEntityInvolvement(
            "42",
            entityReference,
            operationResult
                .personEntityRef(
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
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(dao).save(isA(Involvement.class));
    verify(personDao).getById(1L);
    verify(involvementKindService).findAll();
    verify(involvementKindService, atLeast(1)).getById(1L);
    verify(userRoleService).hasAnyRole(eq("42"), isA(Set.class));
    assertTrue(actualAddEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <p>Method under test: {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName("Test addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testAddEntityInvolvement2() {
    // Arrange
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(1);

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<InvolvementKind> involvementKindList = new ArrayList<>();
    involvementKindList.add(
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(involvementKindList);
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualAddEntityInvolvementResult =
        involvementService.addEntityInvolvement(
            "42",
            entityReference,
            operationResult
                .personEntityRef(
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
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(dao).save(isA(Involvement.class));
    verify(personDao).getById(1L);
    verify(involvementKindService).findAll();
    verify(involvementKindService, atLeast(1)).getById(1L);
    verify(userRoleService).hasAnyRole(eq("42"), isA(Set.class));
    assertTrue(actualAddEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <p>Method under test: {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName("Test addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testAddEntityInvolvement3() {
    // Arrange
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(1);

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    involvementService.addEntityInvolvement(
        "Permitted Role",
        entityReference,
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    ImmutableEntityReference entityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult2 =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualAddEntityInvolvementResult =
        involvementService.addEntityInvolvement(
            "42",
            entityReference2,
            operationResult2
                .personEntityRef(
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
    verify(entityReferenceNameResolver, atLeast(1)).resolve(isA(List.class));
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(dao, atLeast(1)).save(isA(Involvement.class));
    verify(personDao, atLeast(1)).getById(1L);
    verify(involvementKindService).findAll();
    verify(involvementKindService, atLeast(1)).getById(1L);
    verify(userRoleService, atLeast(1)).hasAnyRole(Mockito.<String>any(), isA(Set.class));
    assertTrue(actualAddEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <p>Method under test: {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName("Test addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testAddEntityInvolvement4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(1);

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("")
                .subjectKind(EntityKind.ALL)
                .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            mock(UserRoleService.class));
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualAddEntityInvolvementResult =
        involvementService.addEntityInvolvement(
            "42",
            entityReference,
            operationResult
                .personEntityRef(
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
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(dao).save(isA(Involvement.class));
    verify(personDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(involvementKindService).findAll();
    verify(involvementKindService, atLeast(1)).getById(1L);
    assertTrue(actualAddEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <p>Method under test: {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName("Test addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testAddEntityInvolvement5() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(1);

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole(null)
                .subjectKind(EntityKind.ALL)
                .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            mock(UserRoleService.class));
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualAddEntityInvolvementResult =
        involvementService.addEntityInvolvement(
            "42",
            entityReference,
            operationResult
                .personEntityRef(
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
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(dao).save(isA(Involvement.class));
    verify(personDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(involvementKindService).findAll();
    verify(involvementKindService, atLeast(1)).getById(1L);
    assertTrue(actualAddEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <p>Method under test: {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName("Test addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testAddEntityInvolvement6() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(involvementDao.save(Mockito.<Involvement>any())).thenReturn(1);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<InvolvementKind> involvementKindList = new ArrayList<>();
    involvementKindList.add(
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
    involvementKindList.add(
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
    when(involvementKindService.findAll()).thenReturn(involvementKindList);
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualAddEntityInvolvementResult =
        involvementService.addEntityInvolvement(
            "42",
            entityReference,
            operationResult
                .personEntityRef(
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
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(involvementDao).save(isA(Involvement.class));
    verify(personDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(involvementKindService).findAll();
    verify(involvementKindService, atLeast(1)).getById(1L);
    verify(userRoleService).hasAnyRole(eq("42"), isA(Set.class));
    assertTrue(actualAddEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testAddEntityInvolvement_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(1);

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualAddEntityInvolvementResult =
        involvementService.addEntityInvolvement(
            "42",
            entityReference,
            operationResult
                .personEntityRef(
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
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(dao).save(isA(Involvement.class));
    verify(personDao).getById(1L);
    verify(involvementKindService).findAll();
    verify(involvementKindService, atLeast(1)).getById(1L);
    verify(userRoleService).hasAnyRole(eq("42"), isA(Set.class));
    assertTrue(actualAddEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link InvolvementDao} {@link InvolvementDao#save(Involvement)} return two.
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand); given InvolvementDao save(Involvement) return two; when '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testAddEntityInvolvement_givenInvolvementDaoSaveReturnTwo_when42_thenReturnFalse() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(2);

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);

    InvolvementService involvementService =
        new InvolvementService(
            mock(ChangeLogService.class),
            dao,
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            mock(EntityReferenceNameResolver.class),
            involvementKindService,
            personDao,
            userRoleService);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualAddEntityInvolvementResult =
        involvementService.addEntityInvolvement(
            "42",
            entityReference,
            operationResult
                .personEntityRef(
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
    verify(dao).save(isA(Involvement.class));
    verify(personDao).getById(1L);
    verify(involvementKindService, atLeast(1)).getById(1L);
    verify(userRoleService).hasAnyRole(eq("42"), isA(Set.class));
    assertFalse(actualAddEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand); then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testAddEntityInvolvement_thenCallsWrite() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(1);

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualAddEntityInvolvementResult =
        involvementService.addEntityInvolvement(
            "42",
            entityReference,
            operationResult
                .personEntityRef(
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
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(dao).save(isA(Involvement.class));
    verify(personDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(involvementKindService).findAll();
    verify(involvementKindService, atLeast(1)).getById(1L);
    verify(userRoleService).hasAnyRole(eq("42"), isA(Set.class));
    assertTrue(actualAddEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#removeEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <p>Method under test: {@link InvolvementService#removeEntityInvolvement(String,
   * EntityReference, EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testRemoveEntityInvolvement() {
    // Arrange
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.remove(Mockito.<Involvement>any())).thenReturn(1);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(entityReferenceList);

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualRemoveEntityInvolvementResult =
        involvementService.removeEntityInvolvement(
            "42",
            entityReference,
            operationResult
                .personEntityRef(
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
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(dao).remove(isA(Involvement.class));
    verify(personDao).getById(1L);
    verify(involvementKindService).findAll();
    verify(involvementKindService).getById(1L);
    verify(userRoleService).hasAnyRole(eq("42"), isA(Set.class));
    assertTrue(actualRemoveEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#removeEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <p>Method under test: {@link InvolvementService#removeEntityInvolvement(String,
   * EntityReference, EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testRemoveEntityInvolvement2() {
    // Arrange
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.remove(Mockito.<Involvement>any())).thenReturn(1);

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<InvolvementKind> involvementKindList = new ArrayList<>();
    involvementKindList.add(
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(involvementKindList);
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualRemoveEntityInvolvementResult =
        involvementService.removeEntityInvolvement(
            "42",
            entityReference,
            operationResult
                .personEntityRef(
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
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(dao).remove(isA(Involvement.class));
    verify(personDao).getById(1L);
    verify(involvementKindService).findAll();
    verify(involvementKindService).getById(1L);
    verify(userRoleService).hasAnyRole(eq("42"), isA(Set.class));
    assertTrue(actualRemoveEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#removeEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <p>Method under test: {@link InvolvementService#removeEntityInvolvement(String,
   * EntityReference, EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testRemoveEntityInvolvement3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(1);
    when(dao.remove(Mockito.<Involvement>any())).thenReturn(1);

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole(null)
                .subjectKind(EntityKind.ALL)
                .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            mock(UserRoleService.class));
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    involvementService.addEntityInvolvement(
        "command cannot be null",
        entityReference,
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    ImmutableEntityReference entityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult2 =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualRemoveEntityInvolvementResult =
        involvementService.removeEntityInvolvement(
            "42",
            entityReference2,
            operationResult2
                .personEntityRef(
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
    verify(entityReferenceNameResolver, atLeast(1)).resolve(isA(List.class));
    verify(dao).remove(isA(Involvement.class));
    verify(dao).save(isA(Involvement.class));
    verify(personDao, atLeast(1)).getById(1L);
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(involvementKindService).findAll();
    verify(involvementKindService, atLeast(1)).getById(1L);
    assertTrue(actualRemoveEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#removeEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <p>Method under test: {@link InvolvementService#removeEntityInvolvement(String,
   * EntityReference, EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testRemoveEntityInvolvement4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(1);
    when(dao.remove(Mockito.<Involvement>any())).thenReturn(1);

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("")
                .subjectKind(EntityKind.ALL)
                .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            mock(UserRoleService.class));
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    involvementService.addEntityInvolvement(
        "command cannot be null",
        entityReference,
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    ImmutableEntityReference entityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult2 =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualRemoveEntityInvolvementResult =
        involvementService.removeEntityInvolvement(
            "42",
            entityReference2,
            operationResult2
                .personEntityRef(
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
    verify(entityReferenceNameResolver, atLeast(1)).resolve(isA(List.class));
    verify(dao).remove(isA(Involvement.class));
    verify(dao).save(isA(Involvement.class));
    verify(personDao, atLeast(1)).getById(1L);
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(involvementKindService).findAll();
    verify(involvementKindService, atLeast(1)).getById(1L);
    assertTrue(actualRemoveEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#removeEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementService#removeEntityInvolvement(String,
   * EntityReference, EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testRemoveEntityInvolvement_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.remove(Mockito.<Involvement>any())).thenReturn(1);

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualRemoveEntityInvolvementResult =
        involvementService.removeEntityInvolvement(
            "42",
            entityReference,
            operationResult
                .personEntityRef(
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
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(dao).remove(isA(Involvement.class));
    verify(personDao).getById(1L);
    verify(involvementKindService).findAll();
    verify(involvementKindService).getById(1L);
    verify(userRoleService).hasAnyRole(eq("42"), isA(Set.class));
    assertTrue(actualRemoveEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#removeEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementService#removeEntityInvolvement(String,
   * EntityReference, EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testRemoveEntityInvolvement_givenChangeLogDaoWriteReturn19088743_thenCallsWrite2() {
    // Arrange
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(1);
    when(dao.remove(Mockito.<Involvement>any())).thenReturn(1);

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    involvementService.addEntityInvolvement(
        "command cannot be null",
        entityReference,
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    ImmutableEntityReference entityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult2 =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualRemoveEntityInvolvementResult =
        involvementService.removeEntityInvolvement(
            "42",
            entityReference2,
            operationResult2
                .personEntityRef(
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
    verify(entityReferenceNameResolver, atLeast(1)).resolve(isA(List.class));
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(dao).remove(isA(Involvement.class));
    verify(dao).save(isA(Involvement.class));
    verify(personDao, atLeast(1)).getById(1L);
    verify(involvementKindService).findAll();
    verify(involvementKindService, atLeast(1)).getById(1L);
    verify(userRoleService, atLeast(1)).hasAnyRole(Mockito.<String>any(), isA(Set.class));
    assertTrue(actualRemoveEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#removeEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementService#removeEntityInvolvement(String,
   * EntityReference, EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand); then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testRemoveEntityInvolvement_thenCallsWrite() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(1);
    when(dao.remove(Mockito.<Involvement>any())).thenReturn(1);

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    involvementService.addEntityInvolvement(
        "command cannot be null",
        entityReference,
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    ImmutableEntityReference entityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult2 =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualRemoveEntityInvolvementResult =
        involvementService.removeEntityInvolvement(
            "42",
            entityReference2,
            operationResult2
                .personEntityRef(
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
    verify(entityReferenceNameResolver, atLeast(1)).resolve(isA(List.class));
    verify(dao).remove(isA(Involvement.class));
    verify(dao).save(isA(Involvement.class));
    verify(personDao, atLeast(1)).getById(1L);
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(involvementKindService).findAll();
    verify(involvementKindService, atLeast(1)).getById(1L);
    verify(userRoleService, atLeast(1)).hasAnyRole(Mockito.<String>any(), isA(Set.class));
    assertTrue(actualRemoveEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#removeEntityInvolvement(String, EntityReference,
   * EntityInvolvementChangeCommand)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementService#removeEntityInvolvement(String,
   * EntityReference, EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InvolvementService.removeEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)"
  })
  void testRemoveEntityInvolvement_thenReturnFalse() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.save(Mockito.<Involvement>any())).thenReturn(1);
    when(dao.remove(Mockito.<Involvement>any())).thenReturn(-3);

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(new ArrayList<>());

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindService.getById(anyLong()))
        .thenReturn(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            mock(LogicalFlowDao.class),
            mock(PhysicalFlowDao.class),
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    involvementService.addEntityInvolvement(
        "command cannot be null",
        entityReference,
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    ImmutableEntityReference entityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    Builder operationResult2 =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    boolean actualRemoveEntityInvolvementResult =
        involvementService.removeEntityInvolvement(
            "42",
            entityReference2,
            operationResult2
                .personEntityRef(
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
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(dao).remove(isA(Involvement.class));
    verify(dao).save(isA(Involvement.class));
    verify(personDao, atLeast(1)).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(involvementKindService).findAll();
    verify(involvementKindService, atLeast(1)).getById(1L);
    verify(userRoleService, atLeast(1)).hasAnyRole(Mockito.<String>any(), isA(Set.class));
    assertFalse(actualRemoveEntityInvolvementResult);
  }

  /**
   * Test {@link InvolvementService#findByGenericEntitySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InvolvementService#findByGenericEntitySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByGenericEntitySelector(IdSelectionOptions); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection InvolvementService.findByGenericEntitySelector(IdSelectionOptions)"
  })
  void testFindByGenericEntitySelector_thenReturnList() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    ArrayList<Involvement> involvementList = new ArrayList<>();
    when(dao.findByGenericEntitySelector(Mockito.<GenericSelector>any()))
        .thenReturn(involvementList);
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
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Collection<Involvement> actualFindByGenericEntitySelectorResult =
        involvementService.findByGenericEntitySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(dao).findByGenericEntitySelector(isA(GenericSelector.class));
    assertTrue(actualFindByGenericEntitySelectorResult instanceof List);
    assertTrue(actualFindByGenericEntitySelectorResult.isEmpty());
    assertSame(involvementList, actualFindByGenericEntitySelectorResult);
  }

  /**
   * Test {@link InvolvementService#deleteByGenericEntitySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * InvolvementService#deleteByGenericEntitySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test deleteByGenericEntitySelector(IdSelectionOptions); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.deleteByGenericEntitySelector(IdSelectionOptions)"})
  void testDeleteByGenericEntitySelector_thenReturnOne() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.deleteByGenericEntitySelector(Mockito.<GenericSelector>any())).thenReturn(1);
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
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    int actualDeleteByGenericEntitySelectorResult =
        involvementService.deleteByGenericEntitySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(dao).deleteByGenericEntitySelector(isA(GenericSelector.class));
    assertEquals(1, actualDeleteByGenericEntitySelectorResult);
  }

  /**
   * Test {@link InvolvementService#countOrphanInvolvementsForKind(EntityKind)}.
   *
   * <p>Method under test: {@link InvolvementService#countOrphanInvolvementsForKind(EntityKind)}
   */
  @Test
  @DisplayName("Test countOrphanInvolvementsForKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.countOrphanInvolvementsForKind(EntityKind)"})
  void testCountOrphanInvolvementsForKind() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.countOrphanInvolvementsForKind(Mockito.<EntityKind>any())).thenReturn(3);
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
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    int actualCountOrphanInvolvementsForKindResult =
        involvementService.countOrphanInvolvementsForKind(EntityKind.ALL);

    // Assert
    verify(dao).countOrphanInvolvementsForKind(EntityKind.ALL);
    assertEquals(3, actualCountOrphanInvolvementsForKindResult);
  }

  /**
   * Test {@link InvolvementService#cleanupInvolvementsForKind(String, EntityKind)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementService#cleanupInvolvementsForKind(String, EntityKind)}
   */
  @Test
  @DisplayName("Test cleanupInvolvementsForKind(String, EntityKind); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.cleanupInvolvementsForKind(String, EntityKind)"})
  void testCleanupInvolvementsForKind_thenReturnOne() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.cleanupInvolvementsForKind(Mockito.<EntityKind>any())).thenReturn(1);

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);
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
            userRoleService);

    // Act
    int actualCleanupInvolvementsForKindResult =
        involvementService.cleanupInvolvementsForKind("janedoe", EntityKind.ALL);

    // Assert
    verify(dao).cleanupInvolvementsForKind(EntityKind.ALL);
    verify(userRoleService).hasRole(eq("janedoe"), (SystemRole[]) Mockito.any());
    assertEquals(1, actualCleanupInvolvementsForKindResult);
  }

  /**
   * Test {@link InvolvementService#bulkStoreInvolvements(Set, String)}.
   *
   * <p>Method under test: {@link InvolvementService#bulkStoreInvolvements(Set, String)}
   */
  @Test
  @DisplayName("Test bulkStoreInvolvements(Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.bulkStoreInvolvements(Set, String)"})
  void testBulkStoreInvolvements() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkStoreInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);

    ArrayList<InvolvementKind> involvementKindList = new ArrayList<>();
    involvementKindList.add(
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(involvementKindList);
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    int actualBulkStoreInvolvementsResult =
        involvementService.bulkStoreInvolvements(new HashSet<>(), "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(dao).bulkStoreInvolvements(isA(Set.class));
    verify(involvementKindDao).findAll();
    assertEquals(1, actualBulkStoreInvolvementsResult);
  }

  /**
   * Test {@link InvolvementService#bulkStoreInvolvements(Set, String)}.
   *
   * <p>Method under test: {@link InvolvementService#bulkStoreInvolvements(Set, String)}
   */
  @Test
  @DisplayName("Test bulkStoreInvolvements(Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.bulkStoreInvolvements(Set, String)"})
  void testBulkStoreInvolvements2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkStoreInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    HashSet<Involvement> involvements = new HashSet<>();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvements.add(
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build());

    // Act
    int actualBulkStoreInvolvementsResult =
        involvementService.bulkStoreInvolvements(involvements, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(dao).bulkStoreInvolvements(isA(Set.class));
    verify(involvementKindDao).findAll();
    assertEquals(1, actualBulkStoreInvolvementsResult);
  }

  /**
   * Test {@link InvolvementService#bulkStoreInvolvements(Set, String)}.
   *
   * <p>Method under test: {@link InvolvementService#bulkStoreInvolvements(Set, String)}
   */
  @Test
  @DisplayName("Test bulkStoreInvolvements(Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.bulkStoreInvolvements(Set, String)"})
  void testBulkStoreInvolvements3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkStoreInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    int actualBulkStoreInvolvementsResult =
        involvementService.bulkStoreInvolvements(new HashSet<>(), "janedoe");

    // Assert
    verify(dao).bulkStoreInvolvements(isA(Set.class));
    verify(involvementKindDao).findAll();
    verify(changeLogService).write(isA(Collection.class));
    assertEquals(1, actualBulkStoreInvolvementsResult);
  }

  /**
   * Test {@link InvolvementService#bulkStoreInvolvements(Set, String)}.
   *
   * <p>Method under test: {@link InvolvementService#bulkStoreInvolvements(Set, String)}
   */
  @Test
  @DisplayName("Test bulkStoreInvolvements(Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.bulkStoreInvolvements(Set, String)"})
  void testBulkStoreInvolvements4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkStoreInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    int actualBulkStoreInvolvementsResult =
        involvementService.bulkStoreInvolvements(new HashSet<>(), "janedoe");

    // Assert
    verify(dao).bulkStoreInvolvements(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(involvementKindService).findAll();
    assertEquals(1, actualBulkStoreInvolvementsResult);
  }

  /**
   * Test {@link InvolvementService#bulkStoreInvolvements(Set, String)}.
   *
   * <p>Method under test: {@link InvolvementService#bulkStoreInvolvements(Set, String)}
   */
  @Test
  @DisplayName("Test bulkStoreInvolvements(Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.bulkStoreInvolvements(Set, String)"})
  void testBulkStoreInvolvements5() {
    // Arrange
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    when(involvementDao.bulkStoreInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);

    ArrayList<InvolvementKind> involvementKindList = new ArrayList<>();
    involvementKindList.add(
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
    involvementKindList.add(
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
    when(involvementKindService.findAll()).thenReturn(involvementKindList);

    // Act
    int actualBulkStoreInvolvementsResult =
        involvementService.bulkStoreInvolvements(new HashSet<>(), "janedoe");

    // Assert
    verify(involvementDao).bulkStoreInvolvements(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(involvementKindService).findAll();
    assertEquals(1, actualBulkStoreInvolvementsResult);
  }

  /**
   * Test {@link InvolvementService#bulkStoreInvolvements(Set, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementService#bulkStoreInvolvements(Set, String)}
   */
  @Test
  @DisplayName("Test bulkStoreInvolvements(Set, String); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.bulkStoreInvolvements(Set, String)"})
  void testBulkStoreInvolvements_thenCallsWrite() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkStoreInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    int actualBulkStoreInvolvementsResult =
        involvementService.bulkStoreInvolvements(new HashSet<>(), "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(dao).bulkStoreInvolvements(isA(Set.class));
    verify(involvementKindDao).findAll();
    assertEquals(1, actualBulkStoreInvolvementsResult);
  }

  /**
   * Test {@link InvolvementService#bulkStoreInvolvements(Set, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementService#bulkStoreInvolvements(Set, String)}
   */
  @Test
  @DisplayName("Test bulkStoreInvolvements(Set, String); when 'null'; then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.bulkStoreInvolvements(Set, String)"})
  void testBulkStoreInvolvements_whenNull_thenCallsWrite() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkStoreInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    int actualBulkStoreInvolvementsResult =
        involvementService.bulkStoreInvolvements(null, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(dao).bulkStoreInvolvements(isNull());
    verify(involvementKindDao).findAll();
    assertEquals(1, actualBulkStoreInvolvementsResult);
  }

  /**
   * Test {@link InvolvementService#bulkDeleteInvolvements(Set, String)}.
   *
   * <p>Method under test: {@link InvolvementService#bulkDeleteInvolvements(Set, String)}
   */
  @Test
  @DisplayName("Test bulkDeleteInvolvements(Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.bulkDeleteInvolvements(Set, String)"})
  void testBulkDeleteInvolvements() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkDeleteInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);

    ArrayList<InvolvementKind> involvementKindList = new ArrayList<>();
    involvementKindList.add(
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(involvementKindList);
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    int actualBulkDeleteInvolvementsResult =
        involvementService.bulkDeleteInvolvements(new HashSet<>(), "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(dao).bulkDeleteInvolvements(isA(Set.class));
    verify(involvementKindDao).findAll();
    assertEquals(1, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Test {@link InvolvementService#bulkDeleteInvolvements(Set, String)}.
   *
   * <p>Method under test: {@link InvolvementService#bulkDeleteInvolvements(Set, String)}
   */
  @Test
  @DisplayName("Test bulkDeleteInvolvements(Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.bulkDeleteInvolvements(Set, String)"})
  void testBulkDeleteInvolvements2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkDeleteInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    HashSet<Involvement> involvements = new HashSet<>();

    ImmutableInvolvement.Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvements.add(
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build());

    // Act
    int actualBulkDeleteInvolvementsResult =
        involvementService.bulkDeleteInvolvements(involvements, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(dao).bulkDeleteInvolvements(isA(Set.class));
    verify(involvementKindDao).findAll();
    assertEquals(1, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Test {@link InvolvementService#bulkDeleteInvolvements(Set, String)}.
   *
   * <p>Method under test: {@link InvolvementService#bulkDeleteInvolvements(Set, String)}
   */
  @Test
  @DisplayName("Test bulkDeleteInvolvements(Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.bulkDeleteInvolvements(Set, String)"})
  void testBulkDeleteInvolvements3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkDeleteInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    int actualBulkDeleteInvolvementsResult =
        involvementService.bulkDeleteInvolvements(new HashSet<>(), "janedoe");

    // Assert
    verify(dao).bulkDeleteInvolvements(isA(Set.class));
    verify(involvementKindDao).findAll();
    verify(changeLogService).write(isA(Collection.class));
    assertEquals(1, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Test {@link InvolvementService#bulkDeleteInvolvements(Set, String)}.
   *
   * <p>Method under test: {@link InvolvementService#bulkDeleteInvolvements(Set, String)}
   */
  @Test
  @DisplayName("Test bulkDeleteInvolvements(Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.bulkDeleteInvolvements(Set, String)"})
  void testBulkDeleteInvolvements4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkDeleteInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findAll()).thenReturn(new ArrayList<>());
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    int actualBulkDeleteInvolvementsResult =
        involvementService.bulkDeleteInvolvements(new HashSet<>(), "janedoe");

    // Assert
    verify(dao).bulkDeleteInvolvements(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(involvementKindService).findAll();
    assertEquals(1, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Test {@link InvolvementService#bulkDeleteInvolvements(Set, String)}.
   *
   * <p>Method under test: {@link InvolvementService#bulkDeleteInvolvements(Set, String)}
   */
  @Test
  @DisplayName("Test bulkDeleteInvolvements(Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.bulkDeleteInvolvements(Set, String)"})
  void testBulkDeleteInvolvements5() {
    // Arrange
    when(changeLogService.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
    when(involvementDao.bulkDeleteInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);

    ArrayList<InvolvementKind> involvementKindList = new ArrayList<>();
    involvementKindList.add(
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
    involvementKindList.add(
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
    when(involvementKindService.findAll()).thenReturn(involvementKindList);

    // Act
    int actualBulkDeleteInvolvementsResult =
        involvementService.bulkDeleteInvolvements(new HashSet<>(), "janedoe");

    // Assert
    verify(involvementDao).bulkDeleteInvolvements(isA(Set.class));
    verify(changeLogService).write(isA(Collection.class));
    verify(involvementKindService).findAll();
    assertEquals(1, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Test {@link InvolvementService#bulkDeleteInvolvements(Set, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementService#bulkDeleteInvolvements(Set, String)}
   */
  @Test
  @DisplayName("Test bulkDeleteInvolvements(Set, String); then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.bulkDeleteInvolvements(Set, String)"})
  void testBulkDeleteInvolvements_thenCallsWrite() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkDeleteInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    int actualBulkDeleteInvolvementsResult =
        involvementService.bulkDeleteInvolvements(new HashSet<>(), "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(dao).bulkDeleteInvolvements(isA(Set.class));
    verify(involvementKindDao).findAll();
    assertEquals(1, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Test {@link InvolvementService#bulkDeleteInvolvements(Set, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link ChangeLogDao#write(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementService#bulkDeleteInvolvements(Set, String)}
   */
  @Test
  @DisplayName(
      "Test bulkDeleteInvolvements(Set, String); when 'null'; then calls write(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InvolvementService.bulkDeleteInvolvements(Set, String)"})
  void testBulkDeleteInvolvements_whenNull_thenCallsWrite() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Collection<ChangeLog>>any()))
        .thenReturn(new int[] {19088743, 1, 19088743, 1});
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.bulkDeleteInvolvements(Mockito.<Set<Involvement>>any())).thenReturn(1);

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    int actualBulkDeleteInvolvementsResult =
        involvementService.bulkDeleteInvolvements(null, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Collection.class));
    verify(dao).bulkDeleteInvolvements(isNull());
    verify(involvementKindDao).findAll();
    assertEquals(1, actualBulkDeleteInvolvementsResult);
  }

  /**
   * Test {@link InvolvementService#findByKindIdAndEntityKind(long, EntityKind)}.
   *
   * <p>Method under test: {@link InvolvementService#findByKindIdAndEntityKind(long, EntityKind)}
   */
  @Test
  @DisplayName("Test findByKindIdAndEntityKind(long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementService.findByKindIdAndEntityKind(long, EntityKind)"})
  void testFindByKindIdAndEntityKind() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByKindIdAndEntityKind(anyLong(), Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());
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
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonDao personDao = mock(PersonDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao2, changeLogService2, personService, settingsService);

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            personDao,
            userRoleService);

    // Act
    Set<Involvement> actualFindByKindIdAndEntityKindResult =
        involvementService.findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(dao).findByKindIdAndEntityKind(1L, EntityKind.ALL);
    assertTrue(actualFindByKindIdAndEntityKindResult.isEmpty());
  }
}
