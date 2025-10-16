package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.util.List;
import java.util.Optional;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.involvement.EntityInvolvementChangeCommand;
import org.finos.waltz.model.involvement.Involvement;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKind;
import org.finos.waltz.model.involvement_kind.InvolvementKindChangeCommand;
import org.finos.waltz.model.involvement_kind.InvolvementKindCreateCommand;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement.InvolvementService;
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

@ExtendWith(MockitoExtension.class)
class InvolvementHelperDiffblueTest {
  @InjectMocks private InvolvementHelper involvementHelper;

  @Mock private InvolvementKindService involvementKindService;

  @Mock private InvolvementService involvementService;

  /**
   * Test {@link InvolvementHelper#mkInvolvementKind(String, String)} with {@code name}, {@code
   * externalId}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementKindService#create(InvolvementKindCreateCommand, String)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementHelper#mkInvolvementKind(String, String)}
   */
  @Test
  @DisplayName(
      "Test mkInvolvementKind(String, String) with 'name', 'externalId'; then calls create(InvolvementKindCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long InvolvementHelper.mkInvolvementKind(String, String)"})
  void testMkInvolvementKindWithNameExternalId_thenCallsCreate() {
    // Arrange
    when(involvementKindService.create(
            Mockito.<InvolvementKindCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    // Act
    long actualMkInvolvementKindResult = involvementHelper.mkInvolvementKind("Name", "42");

    // Assert
    verify(involvementKindService)
        .create(
            isA(InvolvementKindCreateCommand.class),
            eq("involvementHelper_de10f882-947b-43bd-b1c7-962bccb711ca"));
    assertEquals(1L, actualMkInvolvementKindResult);
  }

  /**
   * Test {@link InvolvementHelper#mkInvolvementKind(String, String)} with {@code name}, {@code
   * externalId}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementHelper#mkInvolvementKind(String, String)}
   */
  @Test
  @DisplayName(
      "Test mkInvolvementKind(String, String) with 'name', 'externalId'; then calls create(InvolvementKindCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long InvolvementHelper.mkInvolvementKind(String, String)"})
  void testMkInvolvementKindWithNameExternalId_thenCallsCreate2() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.create(
            Mockito.<InvolvementKindCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
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
    InvolvementKindService involvementKindService2 =
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
            involvementKindService2,
            personDao,
            userRoleService);

    InvolvementHelper involvementHelper =
        new InvolvementHelper(involvementService, involvementKindService);

    // Act
    long actualMkInvolvementKindResult = involvementHelper.mkInvolvementKind("Name", "42");

    // Assert
    verify(involvementKindDao)
        .create(
            isA(InvolvementKindCreateCommand.class),
            eq("involvementHelper_7bd7e7f3-38c9-4733-93fe-1940e76dcb8f"));
    assertEquals(1L, actualMkInvolvementKindResult);
  }

  /**
   * Test {@link InvolvementHelper#mkInvolvementKind(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementKindService#create(InvolvementKindCreateCommand, String)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementHelper#mkInvolvementKind(String)}
   */
  @Test
  @DisplayName(
      "Test mkInvolvementKind(String) with 'name'; then calls create(InvolvementKindCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long InvolvementHelper.mkInvolvementKind(String)"})
  void testMkInvolvementKindWithName_thenCallsCreate() {
    // Arrange
    when(involvementKindService.create(
            Mockito.<InvolvementKindCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    // Act
    long actualMkInvolvementKindResult = involvementHelper.mkInvolvementKind("Name");

    // Assert
    verify(involvementKindService)
        .create(
            isA(InvolvementKindCreateCommand.class),
            eq("involvementHelper_51ccb4b9-6107-47d4-aae1-8666ffbb62ae"));
    assertEquals(1L, actualMkInvolvementKindResult);
  }

  /**
   * Test {@link InvolvementHelper#mkInvolvementKind(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementKindDao#create(InvolvementKindCreateCommand, String)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementHelper#mkInvolvementKind(String)}
   */
  @Test
  @DisplayName(
      "Test mkInvolvementKind(String) with 'name'; then calls create(InvolvementKindCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long InvolvementHelper.mkInvolvementKind(String)"})
  void testMkInvolvementKindWithName_thenCallsCreate2() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.create(
            Mockito.<InvolvementKindCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
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
    InvolvementKindService involvementKindService2 =
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
            involvementKindService2,
            personDao,
            userRoleService);

    InvolvementHelper involvementHelper =
        new InvolvementHelper(involvementService, involvementKindService);

    // Act
    long actualMkInvolvementKindResult = involvementHelper.mkInvolvementKind("Name");

    // Assert
    verify(involvementKindDao)
        .create(
            isA(InvolvementKindCreateCommand.class),
            eq("involvementHelper_50b61faa-897c-40f7-81f7-c7c2dd878e0e"));
    assertEquals(1L, actualMkInvolvementKindResult);
  }

  /**
   * Test {@link InvolvementHelper#createInvolvement(Long, long, EntityReference)}.
   *
   * <p>Method under test: {@link InvolvementHelper#createInvolvement(Long, long, EntityReference)}
   */
  @Test
  @DisplayName("Test createInvolvement(Long, long, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvolvementHelper.createInvolvement(Long, long, EntityReference)"})
  void testCreateInvolvement() {
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

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindDao.getById(anyLong()))
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
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);

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
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
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

    InvolvementHelper involvementHelper =
        new InvolvementHelper(involvementService, involvementKindService2);

    // Act
    involvementHelper.createInvolvement(
        1L,
        1L,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(dao).save(isA(Involvement.class));
    verify(involvementKindDao).findAll();
    verify(involvementKindDao, atLeast(1)).getById(1L);
    verify(personDao).getById(1L);
  }

  /**
   * Test {@link InvolvementHelper#createInvolvement(Long, long, EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link EntityReferenceNameResolver#resolve(List)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementHelper#createInvolvement(Long, long, EntityReference)}
   */
  @Test
  @DisplayName(
      "Test createInvolvement(Long, long, EntityReference); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls resolve(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvolvementHelper.createInvolvement(Long, long, EntityReference)"})
  void testCreateInvolvement_givenChangeLogDaoWriteReturn19088743_thenCallsResolve() {
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

    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.findAll()).thenReturn(new ArrayList<>());
    when(involvementKindDao.getById(anyLong()))
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
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);

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
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
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

    InvolvementHelper involvementHelper =
        new InvolvementHelper(involvementService, involvementKindService2);

    // Act
    involvementHelper.createInvolvement(
        1L,
        1L,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(dao).save(isA(Involvement.class));
    verify(involvementKindDao).findAll();
    verify(involvementKindDao, atLeast(1)).getById(1L);
    verify(personDao).getById(1L);
  }

  /**
   * Test {@link InvolvementHelper#createInvolvement(Long, long, EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link InvolvementService#addEntityInvolvement(String, EntityReference,
   *       EntityInvolvementChangeCommand)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementHelper#createInvolvement(Long, long, EntityReference)}
   */
  @Test
  @DisplayName(
      "Test createInvolvement(Long, long, EntityReference); then calls addEntityInvolvement(String, EntityReference, EntityInvolvementChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvolvementHelper.createInvolvement(Long, long, EntityReference)"})
  void testCreateInvolvement_thenCallsAddEntityInvolvement() {
    // Arrange
    when(involvementService.addEntityInvolvement(
            Mockito.<String>any(),
            Mockito.<EntityReference>any(),
            Mockito.<EntityInvolvementChangeCommand>any()))
        .thenReturn(true);

    // Act
    involvementHelper.createInvolvement(1L, 1L, null);

    // Assert
    verify(involvementService)
        .addEntityInvolvement(
            eq("testuser_3d21a0cd-700a-4aee-a60a-42dc91004026"),
            isNull(),
            isA(EntityInvolvementChangeCommand.class));
  }

  /**
   * Test {@link InvolvementHelper#markAsIntransitive(long)}.
   *
   * <ul>
   *   <li>Given {@link InvolvementKindDao} {@link
   *       InvolvementKindDao#update(InvolvementKindChangeCommand)} return {@code true}.
   *   <li>Then calls {@link InvolvementKindDao#update(InvolvementKindChangeCommand)}.
   * </ul>
   *
   * <p>Method under test: {@link InvolvementHelper#markAsIntransitive(long)}
   */
  @Test
  @DisplayName(
      "Test markAsIntransitive(long); given InvolvementKindDao update(InvolvementKindChangeCommand) return 'true'; then calls update(InvolvementKindChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvolvementHelper.markAsIntransitive(long)"})
  void testMarkAsIntransitive_givenInvolvementKindDaoUpdateReturnTrue_thenCallsUpdate() {
    // Arrange
    InvolvementKindDao involvementKindDao = mock(InvolvementKindDao.class);
    when(involvementKindDao.update(Mockito.<InvolvementKindChangeCommand>any())).thenReturn(true);
    InvolvementKindService involvementKindService = new InvolvementKindService(involvementKindDao);
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
    InvolvementKindService involvementKindService2 =
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
            involvementKindService2,
            personDao,
            userRoleService);

    InvolvementHelper involvementHelper =
        new InvolvementHelper(involvementService, involvementKindService);

    // Act
    involvementHelper.markAsIntransitive(1L);

    // Assert
    verify(involvementKindDao).update(isA(InvolvementKindChangeCommand.class));
  }
}
