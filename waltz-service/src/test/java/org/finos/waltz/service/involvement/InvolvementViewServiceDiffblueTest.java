package org.finos.waltz.service.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
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
import java.util.Map;
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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyDirection;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.involvement.ImmutableInvolvement;
import org.finos.waltz.model.involvement.ImmutableInvolvement.Builder;
import org.finos.waltz.model.involvement.ImmutableInvolvementDetail;
import org.finos.waltz.model.involvement.ImmutableInvolvementDetailByDirectionResults;
import org.finos.waltz.model.involvement.Involvement;
import org.finos.waltz.model.involvement.InvolvementDetail;
import org.finos.waltz.model.involvement.InvolvementDetailByDirectionResults;
import org.finos.waltz.model.involvement.InvolvementViewItem;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKind;
import org.finos.waltz.model.involvement_kind.InvolvementKind;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InvolvementViewServiceDiffblueTest {
  /**
   * Test {@link InvolvementViewService#findAllByEmployeeId(String)}.
   *
   * <p>Method under test: {@link InvolvementViewService#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllByEmployeeId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findAllByEmployeeId(String)"})
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

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(
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

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(personSet);
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService2,
            personService2,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementViewItem> actualFindAllByEmployeeIdResult =
        involvementViewService.findAllByEmployeeId("42");

    // Assert
    verify(dao).findAllByEmployeeId("42");
    verify(personDao3).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindAllByEmployeeIdResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findAllByEmployeeId(String)}.
   *
   * <p>Method under test: {@link InvolvementViewService#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllByEmployeeId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findAllByEmployeeId(String)"})
  void testFindAllByEmployeeId2() {
    // Arrange
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findAllByEmployeeId(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService,
            personService,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementViewItem> actualFindAllByEmployeeIdResult =
        involvementViewService.findAllByEmployeeId("42");

    // Assert
    verify(personDao).findByEmployeeIds(isA(Set.class));
    verify(involvementService).findAllByEmployeeId("42");
    assertTrue(actualFindAllByEmployeeIdResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findAllByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementDao#findAllByEmployeeId(String)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllByEmployeeId(String); then calls findAllByEmployeeId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findAllByEmployeeId(String)"})
  void testFindAllByEmployeeId_thenCallsFindAllByEmployeeId() {
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

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService2,
            personService2,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementViewItem> actualFindAllByEmployeeIdResult =
        involvementViewService.findAllByEmployeeId("42");

    // Assert
    verify(dao).findAllByEmployeeId("42");
    verify(personDao3).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindAllByEmployeeIdResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findAllByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementDao#findAllByEmployeeId(String)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllByEmployeeId(String); then calls findAllByEmployeeId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findAllByEmployeeId(String)"})
  void testFindAllByEmployeeId_thenCallsFindAllByEmployeeId2() {
    // Arrange
    ArrayList<Involvement> involvementList = new ArrayList<>();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvementList.add(
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findAllByEmployeeId(Mockito.<String>any())).thenReturn(involvementList);
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

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService2,
            personService2,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementViewItem> actualFindAllByEmployeeIdResult =
        involvementViewService.findAllByEmployeeId("42");

    // Assert
    verify(dao).findAllByEmployeeId("42");
    verify(personDao3).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindAllByEmployeeIdResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findAllByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementDao#findAllByEmployeeId(String)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllByEmployeeId(String); then calls findAllByEmployeeId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findAllByEmployeeId(String)"})
  void testFindAllByEmployeeId_thenCallsFindAllByEmployeeId3() {
    // Arrange
    ArrayList<Involvement> involvementList = new ArrayList<>();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvementList.add(
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

    Builder employeeIdResult2 = ImmutableInvolvement.builder().employeeId("42");
    involvementList.add(
        employeeIdResult2
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findAllByEmployeeId(Mockito.<String>any())).thenReturn(involvementList);
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

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService2,
            personService2,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementViewItem> actualFindAllByEmployeeIdResult =
        involvementViewService.findAllByEmployeeId("42");

    // Assert
    verify(dao).findAllByEmployeeId("42");
    verify(personDao3).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindAllByEmployeeIdResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findAllByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then calls {@link PersonService#findByEmployeeIds(Set)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllByEmployeeId(String); then calls findByEmployeeIds(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findAllByEmployeeId(String)"})
  void testFindAllByEmployeeId_thenCallsFindByEmployeeIds() {
    // Arrange
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findAllByEmployeeId(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    PersonService personService = mock(PersonService.class);
    when(personService.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService,
            personService,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementViewItem> actualFindAllByEmployeeIdResult =
        involvementViewService.findAllByEmployeeId("42");

    // Assert
    verify(involvementService).findAllByEmployeeId("42");
    verify(personService).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindAllByEmployeeIdResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findAllByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllByEmployeeId(String); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findAllByEmployeeId(String)"})
  void testFindAllByEmployeeId_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Involvement> involvementList = new ArrayList<>();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvementList.add(
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

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findAllByEmployeeId(Mockito.<String>any())).thenReturn(involvementList);

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(
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

    PersonService personService = mock(PersonService.class);
    when(personService.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(personSet);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService,
            personService,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementViewItem> actualFindAllByEmployeeIdResult =
        involvementViewService.findAllByEmployeeId("42");

    // Assert
    verify(involvementService).findAllByEmployeeId("42");
    verify(personService).findByEmployeeIds(isA(Set.class));
    assertEquals(1, actualFindAllByEmployeeIdResult.size());
  }

  /**
   * Test {@link InvolvementViewService#findAllByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#findAllByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllByEmployeeId(String); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findAllByEmployeeId(String)"})
  void testFindAllByEmployeeId_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<Involvement> involvementList = new ArrayList<>();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvementList.add(
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

    Builder employeeIdResult2 = ImmutableInvolvement.builder().employeeId("42");
    involvementList.add(
        employeeIdResult2
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

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findAllByEmployeeId(Mockito.<String>any())).thenReturn(involvementList);

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(
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

    PersonService personService = mock(PersonService.class);
    when(personService.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(personSet);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService,
            personService,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementViewItem> actualFindAllByEmployeeIdResult =
        involvementViewService.findAllByEmployeeId("42");

    // Assert
    verify(involvementService).findAllByEmployeeId("42");
    verify(personService).findByEmployeeIds(isA(Set.class));
    assertEquals(1, actualFindAllByEmployeeIdResult.size());
  }

  /**
   * Test {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link
   * InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findKeyInvolvementsForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findKeyInvolvementsForEntity(EntityReference)"})
  void testFindKeyInvolvementsForEntity() {
    // Arrange
    ArrayList<Involvement> involvementList = new ArrayList<>();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvementList.add(
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(involvementList);
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

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService2 = new InvolvementKindService(involvementKindDao);
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService2,
            personService2,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult =
        involvementViewService.findKeyInvolvementsForEntity(
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
    verify(dao).findPeopleByEntityReference(isA(EntityReference.class));
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(EntityKind.ALL);
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link
   * InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findKeyInvolvementsForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findKeyInvolvementsForEntity(EntityReference)"})
  void testFindKeyInvolvementsForEntity2() {
    // Arrange
    ArrayList<Involvement> involvementList = new ArrayList<>();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvementList.add(
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

    Builder employeeIdResult2 = ImmutableInvolvement.builder().employeeId("42");
    involvementList.add(
        employeeIdResult2
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(involvementList);
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

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService2 = new InvolvementKindService(involvementKindDao);
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService2,
            personService2,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult =
        involvementViewService.findKeyInvolvementsForEntity(
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
    verify(dao).findPeopleByEntityReference(isA(EntityReference.class));
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(EntityKind.ALL);
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link
   * InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findKeyInvolvementsForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findKeyInvolvementsForEntity(EntityReference)"})
  void testFindKeyInvolvementsForEntity3() {
    // Arrange
    ArrayList<Person> personList = new ArrayList<>();
    personList.add(
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    when(dao.findPeopleByEntityReference(Mockito.<EntityReference>any())).thenReturn(personList);
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

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService2 = new InvolvementKindService(involvementKindDao);
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService2,
            personService2,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult =
        involvementViewService.findKeyInvolvementsForEntity(
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
    verify(dao).findPeopleByEntityReference(isA(EntityReference.class));
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(EntityKind.ALL);
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link
   * InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findKeyInvolvementsForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findKeyInvolvementsForEntity(EntityReference)"})
  void testFindKeyInvolvementsForEntity4() {
    // Arrange
    ArrayList<Person> personList = new ArrayList<>();
    personList.add(
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
    personList.add(
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    when(dao.findPeopleByEntityReference(Mockito.<EntityReference>any())).thenReturn(personList);
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

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService2 = new InvolvementKindService(involvementKindDao);
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService2,
            personService2,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult =
        involvementViewService.findKeyInvolvementsForEntity(
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
    verify(dao).findPeopleByEntityReference(isA(EntityReference.class));
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(EntityKind.ALL);
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link
   * InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findKeyInvolvementsForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findKeyInvolvementsForEntity(EntityReference)"})
  void testFindKeyInvolvementsForEntity5() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
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
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(involvementKindList);
    InvolvementKindService involvementKindService2 = new InvolvementKindService(involvementKindDao);
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService2,
            personService2,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult =
        involvementViewService.findKeyInvolvementsForEntity(
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
    verify(dao).findPeopleByEntityReference(isA(EntityReference.class));
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(EntityKind.ALL);
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}.
   *
   * <p>Method under test: {@link
   * InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findKeyInvolvementsForEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findKeyInvolvementsForEntity(EntityReference)"})
  void testFindKeyInvolvementsForEntity6() {
    // Arrange
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(involvementService.findPeopleByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService,
            personService,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult =
        involvementViewService.findKeyInvolvementsForEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(EntityKind.ALL);
    verify(involvementService).findByEntityReference(isA(EntityReference.class));
    verify(involvementService).findPeopleByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>Then calls {@link EntityReference#kind()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findKeyInvolvementsForEntity(EntityReference); given 'ALL'; then calls kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findKeyInvolvementsForEntity(EntityReference)"})
  void testFindKeyInvolvementsForEntity_givenAll_thenCallsKind() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
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

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService2 = new InvolvementKindService(involvementKindDao);
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService2,
            personService2,
            mock(InvolvementViewDao.class));

    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult =
        involvementViewService.findKeyInvolvementsForEntity(ref);

    // Assert
    verify(dao).findByEntityReference(isA(EntityReference.class));
    verify(dao).findPeopleByEntityReference(isA(EntityReference.class));
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(EntityKind.ALL);
    verify(ref).kind();
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementDao#findByEntityReference(EntityReference)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findKeyInvolvementsForEntity(EntityReference); then calls findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findKeyInvolvementsForEntity(EntityReference)"})
  void testFindKeyInvolvementsForEntity_thenCallsFindByEntityReference() {
    // Arrange
    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
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

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    InvolvementKindService involvementKindService2 = new InvolvementKindService(involvementKindDao);
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService2,
            personService2,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult =
        involvementViewService.findKeyInvolvementsForEntity(
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
    verify(dao).findPeopleByEntityReference(isA(EntityReference.class));
    verify(involvementKindDao).findKeyInvolvementKindsByEntityKind(EntityKind.ALL);
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       InvolvementKindService#findKeyInvolvementKindsByEntityKind(EntityKind)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findKeyInvolvementsForEntity(EntityReference); then calls findKeyInvolvementKindsByEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findKeyInvolvementsForEntity(EntityReference)"})
  void testFindKeyInvolvementsForEntity_thenCallsFindKeyInvolvementKindsByEntityKind() {
    // Arrange
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    when(involvementService.findPeopleByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    InvolvementKindService involvementKindService = mock(InvolvementKindService.class);
    when(involvementKindService.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(new ArrayList<>());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService,
            personService,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult =
        involvementViewService.findKeyInvolvementsForEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(involvementService).findByEntityReference(isA(EntityReference.class));
    verify(involvementService).findPeopleByEntityReference(isA(EntityReference.class));
    verify(involvementKindService).findKeyInvolvementKindsByEntityKind(EntityKind.ALL);
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       InvolvementKindService#findKeyInvolvementKindsByEntityKind(EntityKind)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * InvolvementViewService#findKeyInvolvementsForEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findKeyInvolvementsForEntity(EntityReference); then calls findKeyInvolvementKindsByEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findKeyInvolvementsForEntity(EntityReference)"})
  void testFindKeyInvolvementsForEntity_thenCallsFindKeyInvolvementKindsByEntityKind2() {
    // Arrange
    ArrayList<Involvement> involvementList = new ArrayList<>();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvementList.add(
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

    ArrayList<Person> personList = new ArrayList<>();
    personList.add(
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

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(involvementList);
    when(involvementService.findPeopleByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(personList);

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
    when(involvementKindService.findKeyInvolvementKindsByEntityKind(Mockito.<EntityKind>any()))
        .thenReturn(involvementKindList);
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService,
            personService,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementDetail> actualFindKeyInvolvementsForEntityResult =
        involvementViewService.findKeyInvolvementsForEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(involvementService).findByEntityReference(isA(EntityReference.class));
    verify(involvementService).findPeopleByEntityReference(isA(EntityReference.class));
    verify(involvementKindService).findKeyInvolvementKindsByEntityKind(EntityKind.ALL);
    assertTrue(actualFindKeyInvolvementsForEntityResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findByKindIdAndEntityKind(long, EntityKind)}.
   *
   * <p>Method under test: {@link InvolvementViewService#findByKindIdAndEntityKind(long,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test findByKindIdAndEntityKind(long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findByKindIdAndEntityKind(long, EntityKind)"})
  void testFindByKindIdAndEntityKind() {
    // Arrange
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByKindIdAndEntityKind(anyLong(), Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService,
            personService,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementViewItem> actualFindByKindIdAndEntityKindResult =
        involvementViewService.findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(personDao).findByEmployeeIds(isA(Set.class));
    verify(involvementService).findByKindIdAndEntityKind(1L, EntityKind.ALL);
    assertTrue(actualFindByKindIdAndEntityKindResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findByKindIdAndEntityKind(long, EntityKind)}.
   *
   * <p>Method under test: {@link InvolvementViewService#findByKindIdAndEntityKind(long,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test findByKindIdAndEntityKind(long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findByKindIdAndEntityKind(long, EntityKind)"})
  void testFindByKindIdAndEntityKind2() {
    // Arrange
    HashSet<Involvement> involvementSet = new HashSet<>();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvementSet.add(
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

    Builder employeeIdResult2 = ImmutableInvolvement.builder().employeeId("xs cannot be null");
    involvementSet.add(
        employeeIdResult2
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

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByKindIdAndEntityKind(anyLong(), Mockito.<EntityKind>any()))
        .thenReturn(involvementSet);

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(
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

    PersonService personService = mock(PersonService.class);
    when(personService.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(personSet);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService,
            personService,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementViewItem> actualFindByKindIdAndEntityKindResult =
        involvementViewService.findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(involvementService).findByKindIdAndEntityKind(1L, EntityKind.ALL);
    verify(personService).findByEmployeeIds(isA(Set.class));
    assertEquals(1, actualFindByKindIdAndEntityKindResult.size());
  }

  /**
   * Test {@link InvolvementViewService#findByKindIdAndEntityKind(long, EntityKind)}.
   *
   * <ul>
   *   <li>Then calls {@link PersonService#findByEmployeeIds(Set)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#findByKindIdAndEntityKind(long,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test findByKindIdAndEntityKind(long, EntityKind); then calls findByEmployeeIds(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findByKindIdAndEntityKind(long, EntityKind)"})
  void testFindByKindIdAndEntityKind_thenCallsFindByEmployeeIds() {
    // Arrange
    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByKindIdAndEntityKind(anyLong(), Mockito.<EntityKind>any()))
        .thenReturn(new HashSet<>());

    PersonService personService = mock(PersonService.class);
    when(personService.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService,
            personService,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementViewItem> actualFindByKindIdAndEntityKindResult =
        involvementViewService.findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(involvementService).findByKindIdAndEntityKind(1L, EntityKind.ALL);
    verify(personService).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindByKindIdAndEntityKindResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findByKindIdAndEntityKind(long, EntityKind)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementDao#findByKindIdAndEntityKind(long, EntityKind)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#findByKindIdAndEntityKind(long,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test findByKindIdAndEntityKind(long, EntityKind); then calls findByKindIdAndEntityKind(long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findByKindIdAndEntityKind(long, EntityKind)"})
  void testFindByKindIdAndEntityKind_thenCallsFindByKindIdAndEntityKind() {
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

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService2,
            personService2,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementViewItem> actualFindByKindIdAndEntityKindResult =
        involvementViewService.findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(dao).findByKindIdAndEntityKind(1L, EntityKind.ALL);
    verify(personDao3).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindByKindIdAndEntityKindResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findByKindIdAndEntityKind(long, EntityKind)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementDao#findByKindIdAndEntityKind(long, EntityKind)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#findByKindIdAndEntityKind(long,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test findByKindIdAndEntityKind(long, EntityKind); then calls findByKindIdAndEntityKind(long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findByKindIdAndEntityKind(long, EntityKind)"})
  void testFindByKindIdAndEntityKind_thenCallsFindByKindIdAndEntityKind2() {
    // Arrange
    HashSet<Involvement> involvementSet = new HashSet<>();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvementSet.add(
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

    InvolvementDao dao = mock(InvolvementDao.class);
    when(dao.findByKindIdAndEntityKind(anyLong(), Mockito.<EntityKind>any()))
        .thenReturn(involvementSet);
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

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService2,
            personService2,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementViewItem> actualFindByKindIdAndEntityKindResult =
        involvementViewService.findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(dao).findByKindIdAndEntityKind(1L, EntityKind.ALL);
    verify(personDao3).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindByKindIdAndEntityKindResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findByKindIdAndEntityKind(long, EntityKind)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementDao#findByKindIdAndEntityKind(long, EntityKind)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#findByKindIdAndEntityKind(long,
   * EntityKind)}
   */
  @Test
  @DisplayName(
      "Test findByKindIdAndEntityKind(long, EntityKind); then calls findByKindIdAndEntityKind(long, EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findByKindIdAndEntityKind(long, EntityKind)"})
  void testFindByKindIdAndEntityKind_thenCallsFindByKindIdAndEntityKind3() {
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

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(
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

    PersonDao personDao3 = mock(PersonDao.class);
    when(personDao3.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(personSet);
    PersonService personService2 = new PersonService(personDao3, mock(PersonSearchDao.class));
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService2,
            personService2,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementViewItem> actualFindByKindIdAndEntityKindResult =
        involvementViewService.findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(dao).findByKindIdAndEntityKind(1L, EntityKind.ALL);
    verify(personDao3).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindByKindIdAndEntityKindResult.isEmpty());
  }

  /**
   * Test {@link InvolvementViewService#findByKindIdAndEntityKind(long, EntityKind)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#findByKindIdAndEntityKind(long,
   * EntityKind)}
   */
  @Test
  @DisplayName("Test findByKindIdAndEntityKind(long, EntityKind); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set InvolvementViewService.findByKindIdAndEntityKind(long, EntityKind)"})
  void testFindByKindIdAndEntityKind_thenReturnSizeIsOne() {
    // Arrange
    HashSet<Involvement> involvementSet = new HashSet<>();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    involvementSet.add(
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

    InvolvementService involvementService = mock(InvolvementService.class);
    when(involvementService.findByKindIdAndEntityKind(anyLong(), Mockito.<EntityKind>any()))
        .thenReturn(involvementSet);

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(
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

    PersonService personService = mock(PersonService.class);
    when(personService.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(personSet);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService,
            involvementKindService,
            personService,
            mock(InvolvementViewDao.class));

    // Act
    Set<InvolvementViewItem> actualFindByKindIdAndEntityKindResult =
        involvementViewService.findByKindIdAndEntityKind(1L, EntityKind.ALL);

    // Assert
    verify(involvementService).findByKindIdAndEntityKind(1L, EntityKind.ALL);
    verify(personService).findByEmployeeIds(isA(Set.class));
    assertEquals(1, actualFindByKindIdAndEntityKindResult.size());
  }

  /**
   * Test {@link InvolvementViewService#getAllInvolvements(EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementViewService#getAllInvolvements(EntityReference)}
   */
  @Test
  @DisplayName("Test getAllInvolvements(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InvolvementDetailByDirectionResults InvolvementViewService.getAllInvolvements(EntityReference)"
  })
  void testGetAllInvolvements() {
    // Arrange
    ArrayList<InvolvementDetail> involvementDetailList = new ArrayList<>();

    ImmutableInvolvementDetail.Builder builderResult = ImmutableInvolvementDetail.builder();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    ImmutableInvolvementDetail.Builder involvementResult =
        builderResult.involvement(
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

    ImmutableInvolvementDetail.Builder involvementKindResult =
        involvementResult.involvementKind(
            ImmutableInvolvementKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.now().atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .permittedRole("Permitted Role")
                .subjectKind(EntityKind.ALL)
                .build());
    involvementDetailList.add(
        involvementKindResult
            .person(
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
                    .build())
            .build());

    ImmutableInvolvementDetail.Builder builderResult2 = ImmutableInvolvementDetail.builder();

    Builder employeeIdResult2 = ImmutableInvolvement.builder().employeeId("42");

    ImmutableInvolvementDetail.Builder involvementResult2 =
        builderResult2.involvement(
            employeeIdResult2
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

    ImmutableInvolvementDetail.Builder involvementKindResult2 =
        involvementResult2.involvementKind(
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
    involvementDetailList.add(
        involvementKindResult2
            .person(
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
                    .build())
            .build());

    HashMap<HierarchyDirection, Collection<InvolvementDetail>> hierarchyDirectionCollectionMap =
        new HashMap<>();
    hierarchyDirectionCollectionMap.put(HierarchyDirection.EXACT, involvementDetailList);

    InvolvementViewDao involvementViewDao = mock(InvolvementViewDao.class);
    Mockito.<Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>>when(
            involvementViewDao.findAllInvolvements(Mockito.<EntityReference>any()))
        .thenReturn(hierarchyDirectionCollectionMap);
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
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService, involvementKindService2, personService2, involvementViewDao);

    // Act
    InvolvementDetailByDirectionResults actualAllInvolvements =
        involvementViewService.getAllInvolvements(null);

    // Assert
    verify(involvementViewDao).findAllInvolvements(isNull());
    assertTrue(actualAllInvolvements instanceof ImmutableInvolvementDetailByDirectionResults);
    Set<InvolvementDetail> ancestorsResult = actualAllInvolvements.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualAllInvolvements.descendents());
  }

  /**
   * Test {@link InvolvementViewService#getAllInvolvements(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code EXACT} is {@link ArrayList#ArrayList()}.
   *   <li>Then return exact is ancestors.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#getAllInvolvements(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test getAllInvolvements(EntityReference); given HashMap() 'EXACT' is ArrayList(); then return exact is ancestors")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InvolvementDetailByDirectionResults InvolvementViewService.getAllInvolvements(EntityReference)"
  })
  void testGetAllInvolvements_givenHashMapExactIsArrayList_thenReturnExactIsAncestors() {
    // Arrange
    HashMap<HierarchyDirection, Collection<InvolvementDetail>> hierarchyDirectionCollectionMap =
        new HashMap<>();
    hierarchyDirectionCollectionMap.put(HierarchyDirection.EXACT, new ArrayList<>());

    InvolvementViewDao involvementViewDao = mock(InvolvementViewDao.class);
    Mockito.<Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>>when(
            involvementViewDao.findAllInvolvements(Mockito.<EntityReference>any()))
        .thenReturn(hierarchyDirectionCollectionMap);
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
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService, involvementKindService2, personService2, involvementViewDao);

    // Act
    InvolvementDetailByDirectionResults actualAllInvolvements =
        involvementViewService.getAllInvolvements(null);

    // Assert
    verify(involvementViewDao).findAllInvolvements(isNull());
    assertTrue(actualAllInvolvements instanceof ImmutableInvolvementDetailByDirectionResults);
    Set<InvolvementDetail> ancestorsResult = actualAllInvolvements.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualAllInvolvements.descendents());
    assertSame(ancestorsResult, actualAllInvolvements.exact());
  }

  /**
   * Test {@link InvolvementViewService#getAllInvolvements(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code EXACT} is {@link ArrayList#ArrayList()}.
   *   <li>Then return exact size is one.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#getAllInvolvements(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test getAllInvolvements(EntityReference); given HashMap() 'EXACT' is ArrayList(); then return exact size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InvolvementDetailByDirectionResults InvolvementViewService.getAllInvolvements(EntityReference)"
  })
  void testGetAllInvolvements_givenHashMapExactIsArrayList_thenReturnExactSizeIsOne() {
    // Arrange
    ArrayList<InvolvementDetail> involvementDetailList = new ArrayList<>();

    ImmutableInvolvementDetail.Builder builderResult = ImmutableInvolvementDetail.builder();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    ImmutableInvolvementDetail.Builder involvementResult =
        builderResult.involvement(
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

    ImmutableInvolvementDetail.Builder involvementKindResult =
        involvementResult.involvementKind(
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
    involvementDetailList.add(
        involvementKindResult
            .person(
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
                    .build())
            .build());

    HashMap<HierarchyDirection, Collection<InvolvementDetail>> hierarchyDirectionCollectionMap =
        new HashMap<>();
    hierarchyDirectionCollectionMap.put(HierarchyDirection.EXACT, involvementDetailList);

    InvolvementViewDao involvementViewDao = mock(InvolvementViewDao.class);
    Mockito.<Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>>when(
            involvementViewDao.findAllInvolvements(Mockito.<EntityReference>any()))
        .thenReturn(hierarchyDirectionCollectionMap);
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
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService, involvementKindService2, personService2, involvementViewDao);

    // Act
    InvolvementDetailByDirectionResults actualAllInvolvements =
        involvementViewService.getAllInvolvements(null);

    // Assert
    verify(involvementViewDao).findAllInvolvements(isNull());
    assertTrue(actualAllInvolvements instanceof ImmutableInvolvementDetailByDirectionResults);
    assertEquals(1, actualAllInvolvements.exact().size());
    Set<InvolvementDetail> ancestorsResult = actualAllInvolvements.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualAllInvolvements.descendents());
  }

  /**
   * Test {@link InvolvementViewService#getAllInvolvements(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code EXACT} is {@link ArrayList#ArrayList()}.
   *   <li>Then return exact size is one.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#getAllInvolvements(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test getAllInvolvements(EntityReference); given HashMap() 'EXACT' is ArrayList(); then return exact size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InvolvementDetailByDirectionResults InvolvementViewService.getAllInvolvements(EntityReference)"
  })
  void testGetAllInvolvements_givenHashMapExactIsArrayList_thenReturnExactSizeIsOne2() {
    // Arrange
    ArrayList<InvolvementDetail> involvementDetailList = new ArrayList<>();

    ImmutableInvolvementDetail.Builder builderResult = ImmutableInvolvementDetail.builder();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    ImmutableInvolvementDetail.Builder involvementResult =
        builderResult.involvement(
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

    ImmutableInvolvementDetail.Builder involvementKindResult =
        involvementResult.involvementKind(
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
    involvementDetailList.add(
        involvementKindResult
            .person(
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
                    .build())
            .build());

    ImmutableInvolvementDetail.Builder builderResult2 = ImmutableInvolvementDetail.builder();

    Builder employeeIdResult2 = ImmutableInvolvement.builder().employeeId("42");

    ImmutableInvolvementDetail.Builder involvementResult2 =
        builderResult2.involvement(
            employeeIdResult2
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

    ImmutableInvolvementDetail.Builder involvementKindResult2 =
        involvementResult2.involvementKind(
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
    involvementDetailList.add(
        involvementKindResult2
            .person(
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
                    .build())
            .build());

    HashMap<HierarchyDirection, Collection<InvolvementDetail>> hierarchyDirectionCollectionMap =
        new HashMap<>();
    hierarchyDirectionCollectionMap.put(HierarchyDirection.EXACT, involvementDetailList);

    InvolvementViewDao involvementViewDao = mock(InvolvementViewDao.class);
    Mockito.<Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>>when(
            involvementViewDao.findAllInvolvements(Mockito.<EntityReference>any()))
        .thenReturn(hierarchyDirectionCollectionMap);
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
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService, involvementKindService2, personService2, involvementViewDao);

    // Act
    InvolvementDetailByDirectionResults actualAllInvolvements =
        involvementViewService.getAllInvolvements(null);

    // Assert
    verify(involvementViewDao).findAllInvolvements(isNull());
    assertTrue(actualAllInvolvements instanceof ImmutableInvolvementDetailByDirectionResults);
    assertEquals(1, actualAllInvolvements.exact().size());
    Set<InvolvementDetail> ancestorsResult = actualAllInvolvements.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualAllInvolvements.descendents());
  }

  /**
   * Test {@link InvolvementViewService#getAllInvolvements(EntityReference)}.
   *
   * <ul>
   *   <li>Then return ancestors size is one.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#getAllInvolvements(EntityReference)}
   */
  @Test
  @DisplayName("Test getAllInvolvements(EntityReference); then return ancestors size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InvolvementDetailByDirectionResults InvolvementViewService.getAllInvolvements(EntityReference)"
  })
  void testGetAllInvolvements_thenReturnAncestorsSizeIsOne() {
    // Arrange
    ArrayList<InvolvementDetail> involvementDetailList = new ArrayList<>();

    ImmutableInvolvementDetail.Builder builderResult = ImmutableInvolvementDetail.builder();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    ImmutableInvolvementDetail.Builder involvementResult =
        builderResult.involvement(
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

    ImmutableInvolvementDetail.Builder involvementKindResult =
        involvementResult.involvementKind(
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
    involvementDetailList.add(
        involvementKindResult
            .person(
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
                    .build())
            .build());

    HashMap<HierarchyDirection, Collection<InvolvementDetail>> hierarchyDirectionCollectionMap =
        new HashMap<>();
    hierarchyDirectionCollectionMap.put(HierarchyDirection.ANCESTOR, involvementDetailList);

    InvolvementViewDao involvementViewDao = mock(InvolvementViewDao.class);
    Mockito.<Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>>when(
            involvementViewDao.findAllInvolvements(Mockito.<EntityReference>any()))
        .thenReturn(hierarchyDirectionCollectionMap);
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
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService, involvementKindService2, personService2, involvementViewDao);

    // Act
    InvolvementDetailByDirectionResults actualAllInvolvements =
        involvementViewService.getAllInvolvements(null);

    // Assert
    verify(involvementViewDao).findAllInvolvements(isNull());
    assertTrue(actualAllInvolvements instanceof ImmutableInvolvementDetailByDirectionResults);
    assertEquals(1, actualAllInvolvements.ancestors().size());
    Set<InvolvementDetail> descendentsResult = actualAllInvolvements.descendents();
    assertTrue(descendentsResult.isEmpty());
    assertSame(descendentsResult, actualAllInvolvements.exact());
  }

  /**
   * Test {@link InvolvementViewService#getAllInvolvements(EntityReference)}.
   *
   * <ul>
   *   <li>Then return descendents size is one.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#getAllInvolvements(EntityReference)}
   */
  @Test
  @DisplayName("Test getAllInvolvements(EntityReference); then return descendents size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InvolvementDetailByDirectionResults InvolvementViewService.getAllInvolvements(EntityReference)"
  })
  void testGetAllInvolvements_thenReturnDescendentsSizeIsOne() {
    // Arrange
    ArrayList<InvolvementDetail> involvementDetailList = new ArrayList<>();

    ImmutableInvolvementDetail.Builder builderResult = ImmutableInvolvementDetail.builder();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    ImmutableInvolvementDetail.Builder involvementResult =
        builderResult.involvement(
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

    ImmutableInvolvementDetail.Builder involvementKindResult =
        involvementResult.involvementKind(
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
    involvementDetailList.add(
        involvementKindResult
            .person(
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
                    .build())
            .build());

    HashMap<HierarchyDirection, Collection<InvolvementDetail>> hierarchyDirectionCollectionMap =
        new HashMap<>();
    hierarchyDirectionCollectionMap.put(HierarchyDirection.DESCENDENT, involvementDetailList);

    InvolvementViewDao involvementViewDao = mock(InvolvementViewDao.class);
    Mockito.<Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>>when(
            involvementViewDao.findAllInvolvements(Mockito.<EntityReference>any()))
        .thenReturn(hierarchyDirectionCollectionMap);
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
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService, involvementKindService2, personService2, involvementViewDao);

    // Act
    InvolvementDetailByDirectionResults actualAllInvolvements =
        involvementViewService.getAllInvolvements(null);

    // Assert
    verify(involvementViewDao).findAllInvolvements(isNull());
    assertTrue(actualAllInvolvements instanceof ImmutableInvolvementDetailByDirectionResults);
    assertEquals(1, actualAllInvolvements.descendents().size());
    Set<InvolvementDetail> ancestorsResult = actualAllInvolvements.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualAllInvolvements.exact());
  }

  /**
   * Test {@link InvolvementViewService#getAllInvolvements(EntityReference)}.
   *
   * <ul>
   *   <li>Then return exact is ancestors.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementViewService#getAllInvolvements(EntityReference)}
   */
  @Test
  @DisplayName("Test getAllInvolvements(EntityReference); then return exact is ancestors")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InvolvementDetailByDirectionResults InvolvementViewService.getAllInvolvements(EntityReference)"
  })
  void testGetAllInvolvements_thenReturnExactIsAncestors() {
    // Arrange
    InvolvementViewDao involvementViewDao = mock(InvolvementViewDao.class);
    Mockito.<Map<HierarchyDirection, ? extends Collection<InvolvementDetail>>>when(
            involvementViewDao.findAllInvolvements(Mockito.<EntityReference>any()))
        .thenReturn(new HashMap<>());
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
    InvolvementKindService involvementKindService2 =
        new InvolvementKindService(mock(InvolvementKindDao.class));
    PersonService personService2 =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    InvolvementViewService involvementViewService =
        new InvolvementViewService(
            involvementService, involvementKindService2, personService2, involvementViewDao);

    // Act
    InvolvementDetailByDirectionResults actualAllInvolvements =
        involvementViewService.getAllInvolvements(null);

    // Assert
    verify(involvementViewDao).findAllInvolvements(isNull());
    assertTrue(actualAllInvolvements instanceof ImmutableInvolvementDetailByDirectionResults);
    Set<InvolvementDetail> ancestorsResult = actualAllInvolvements.ancestors();
    assertTrue(ancestorsResult.isEmpty());
    assertSame(ancestorsResult, actualAllInvolvements.descendents());
    assertSame(ancestorsResult, actualAllInvolvements.exact());
  }
}
