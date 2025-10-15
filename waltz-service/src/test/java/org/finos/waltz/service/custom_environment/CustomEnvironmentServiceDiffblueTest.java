package org.finos.waltz.service.custom_environment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.custom_environment.CustomEnvironmentDao;
import org.finos.waltz.data.involvement.InvolvementDao;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.custom_environment.CustomEnvironment;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironment;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironment.Builder;
import org.finos.waltz.model.permission_group.CheckPermissionCommand;
import org.finos.waltz.model.permission_group.ImmutableRequiredInvolvementsResult;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.finos.waltz.service.permission.PermissionGroupService;
import org.finos.waltz.service.person.PersonService;
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
class CustomEnvironmentServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private CustomEnvironmentDao customEnvironmentDao;

  @InjectMocks private CustomEnvironmentService customEnvironmentService;

  @Mock private PermissionGroupService permissionGroupService;

  /**
   * Test {@link CustomEnvironmentService#findAll()}.
   *
   * <p>Method under test: {@link CustomEnvironmentService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CustomEnvironmentService.findAll()"})
  void testFindAll() {
    // Arrange
    when(customEnvironmentDao.findAll()).thenReturn(new HashSet<>());

    // Act
    Set<CustomEnvironment> actualFindAllResult = customEnvironmentService.findAll();

    // Assert
    verify(customEnvironmentDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link CustomEnvironmentService#findByOwningEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link CustomEnvironmentService#findByOwningEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByOwningEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection CustomEnvironmentService.findByOwningEntityRef(EntityReference)"})
  void testFindByOwningEntityRef() {
    // Arrange
    HashSet<CustomEnvironment> customEnvironmentSet = new HashSet<>();
    when(customEnvironmentDao.findByOwningEntityRef(Mockito.<EntityReference>any()))
        .thenReturn(customEnvironmentSet);

    // Act
    Collection<CustomEnvironment> actualFindByOwningEntityRefResult =
        customEnvironmentService.findByOwningEntityRef(null);

    // Assert
    verify(customEnvironmentDao).findByOwningEntityRef(isNull());
    assertTrue(actualFindByOwningEntityRefResult instanceof Set);
    assertTrue(actualFindByOwningEntityRefResult.isEmpty());
    assertSame(customEnvironmentSet, actualFindByOwningEntityRefResult);
  }

  /**
   * Test {@link CustomEnvironmentService#create(CustomEnvironment, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentService#create(CustomEnvironment, String)}
   */
  @Test
  @DisplayName(
      "Test create(CustomEnvironment, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CustomEnvironmentService.create(CustomEnvironment, String)"})
  void testCreate_givenChangeLogDaoWriteReturn19088743_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    CustomEnvironmentDao customEnvironmentDao = mock(CustomEnvironmentDao.class);
    when(customEnvironmentDao.create(Mockito.<CustomEnvironment>any())).thenReturn(1L);

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

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.getRequiredInvolvements(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
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
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);

    CustomEnvironmentService customEnvironmentService =
        new CustomEnvironmentService(
            customEnvironmentDao, changeLogService, permissionGroupService);

    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act
    Long actualCreateResult =
        customEnvironmentService.create(
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
                .build(),
            "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(customEnvironmentDao).create(isA(CustomEnvironment.class));
    verify(permissionGroupDao).getRequiredInvolvements(isA(CheckPermissionCommand.class));
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Test {@link CustomEnvironmentService#create(CustomEnvironment, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentService#create(CustomEnvironment, String)}
   */
  @Test
  @DisplayName(
      "Test create(CustomEnvironment, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CustomEnvironmentService.create(CustomEnvironment, String)"})
  void testCreate_givenChangeLogServiceWriteReturn19088743_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    when(customEnvironmentDao.create(Mockito.<CustomEnvironment>any())).thenReturn(1L);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(true);

    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act
    Long actualCreateResult =
        customEnvironmentService.create(
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
                .build(),
            "janedoe");

    // Assert
    verify(customEnvironmentDao).create(isA(CustomEnvironment.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Test {@link CustomEnvironmentService#create(CustomEnvironment, String)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link CustomEnvironment} {@link CustomEnvironment#name()} return {@code Name}.
   *   <li>Then calls {@link CustomEnvironment#name()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentService#create(CustomEnvironment, String)}
   */
  @Test
  @DisplayName(
      "Test create(CustomEnvironment, String); given 'Name'; when CustomEnvironment name() return 'Name'; then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CustomEnvironmentService.create(CustomEnvironment, String)"})
  void testCreate_givenName_whenCustomEnvironmentNameReturnName_thenCallsName()
      throws InsufficientPrivelegeException {
    // Arrange
    when(customEnvironmentDao.create(Mockito.<CustomEnvironment>any())).thenReturn(1L);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(true);

    CustomEnvironment env = mock(CustomEnvironment.class);
    when(env.name()).thenReturn("Name");
    when(env.groupName()).thenReturn("Group Name");
    when(env.owningEntity())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Long actualCreateResult = customEnvironmentService.create(env, "janedoe");

    // Assert
    verify(customEnvironmentDao).create(isA(CustomEnvironment.class));
    verify(env).name();
    verify(env).groupName();
    verify(env, atLeast(1)).owningEntity();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
    assertEquals(1L, actualCreateResult.longValue());
  }

  /**
   * Test {@link CustomEnvironmentService#create(CustomEnvironment, String)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentService#create(CustomEnvironment, String)}
   */
  @Test
  @DisplayName("Test create(CustomEnvironment, String); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CustomEnvironmentService.create(CustomEnvironment, String)"})
  void testCreate_thenThrowInsufficientPrivelegeException() throws InsufficientPrivelegeException {
    // Arrange
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(false);

    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class,
        () ->
            customEnvironmentService.create(
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
                    .build(),
                "janedoe"));
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
  }

  /**
   * Test {@link CustomEnvironmentService#remove(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentService#remove(Long, String)}
   */
  @Test
  @DisplayName(
      "Test remove(Long, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CustomEnvironmentService.remove(Long, String)"})
  void testRemove_givenChangeLogDaoWriteReturn19088743_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    CustomEnvironmentDao customEnvironmentDao = mock(CustomEnvironmentDao.class);
    when(customEnvironmentDao.remove(Mockito.<Long>any())).thenReturn(true);

    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    when(customEnvironmentDao.getById(Mockito.<Long>any()))
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
                .build());

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

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    when(permissionGroupDao.getRequiredInvolvements(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build());
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
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
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    InvolvementKindService involvementKindService =
        new InvolvementKindService(mock(InvolvementKindDao.class));

    InvolvementService involvementService =
        new InvolvementService(
            changeLogService2,
            dao,
            logicalFlowDao,
            physicalFlowDao,
            entityReferenceNameResolver,
            involvementKindService,
            mock(PersonDao.class),
            mock(UserRoleService.class));

    PermissionGroupService permissionGroupService =
        new PermissionGroupService(personService, permissionGroupDao, involvementService);

    CustomEnvironmentService customEnvironmentService =
        new CustomEnvironmentService(
            customEnvironmentDao, changeLogService, permissionGroupService);

    // Act
    Boolean actualRemoveResult = customEnvironmentService.remove(1L, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(customEnvironmentDao).getById(1L);
    verify(customEnvironmentDao).remove(1L);
    verify(permissionGroupDao).getRequiredInvolvements(isA(CheckPermissionCommand.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link CustomEnvironmentService#remove(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentService#remove(Long, String)}
   */
  @Test
  @DisplayName(
      "Test remove(Long, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CustomEnvironmentService.remove(Long, String)"})
  void testRemove_givenChangeLogServiceWriteReturn19088743_thenCallsWrite()
      throws InsufficientPrivelegeException {
    // Arrange
    when(customEnvironmentDao.remove(Mockito.<Long>any())).thenReturn(true);

    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    when(customEnvironmentDao.getById(Mockito.<Long>any()))
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
                .build());
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(true);

    // Act
    Boolean actualRemoveResult = customEnvironmentService.remove(1L, "janedoe");

    // Assert
    verify(customEnvironmentDao).getById(1L);
    verify(customEnvironmentDao).remove(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link CustomEnvironmentService#remove(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link CustomEnvironmentDao} {@link CustomEnvironmentDao#remove(Long)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentService#remove(Long, String)}
   */
  @Test
  @DisplayName(
      "Test remove(Long, String); given CustomEnvironmentDao remove(Long) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CustomEnvironmentService.remove(Long, String)"})
  void testRemove_givenCustomEnvironmentDaoRemoveReturnFalse_thenReturnFalse()
      throws InsufficientPrivelegeException {
    // Arrange
    when(customEnvironmentDao.remove(Mockito.<Long>any())).thenReturn(false);

    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    when(customEnvironmentDao.getById(Mockito.<Long>any()))
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
                .build());
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(true);

    // Act
    Boolean actualRemoveResult = customEnvironmentService.remove(1L, "janedoe");

    // Assert
    verify(customEnvironmentDao).getById(1L);
    verify(customEnvironmentDao).remove(1L);
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link CustomEnvironmentService#remove(Long, String)}.
   *
   * <ul>
   *   <li>Then throw {@link InsufficientPrivelegeException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentService#remove(Long, String)}
   */
  @Test
  @DisplayName("Test remove(Long, String); then throw InsufficientPrivelegeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CustomEnvironmentService.remove(Long, String)"})
  void testRemove_thenThrowInsufficientPrivelegeException() throws InsufficientPrivelegeException {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    when(customEnvironmentDao.getById(Mockito.<Long>any()))
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
                .build());
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any()))
        .thenReturn(false);

    // Act and Assert
    assertThrows(
        InsufficientPrivelegeException.class, () -> customEnvironmentService.remove(1L, "janedoe"));
    verify(customEnvironmentDao).getById(1L);
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
  }

  /**
   * Test {@link CustomEnvironmentService#getById(Long)}.
   *
   * <p>Method under test: {@link CustomEnvironmentService#getById(Long)}
   */
  @Test
  @DisplayName("Test getById(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomEnvironment CustomEnvironmentService.getById(Long)"})
  void testGetById() {
    // Arrange
    Builder nameResult =
        ImmutableCustomEnvironment.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .groupName("Group Name")
            .id(1L)
            .name("Name");
    when(customEnvironmentDao.getById(Mockito.<Long>any()))
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
                .build());

    // Act
    CustomEnvironment actualById = customEnvironmentService.getById(1L);

    // Assert
    verify(customEnvironmentDao).getById(1L);
    EntityReference owningEntityResult = actualById.owningEntity();
    assertTrue(owningEntityResult instanceof ImmutableEntityReference);
    assertTrue(actualById instanceof ImmutableCustomEnvironment);
    assertEquals("Group Name", actualById.groupName());
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", owningEntityResult.description());
    assertEquals(1L, owningEntityResult.id());
    assertEquals(EntityKind.ALL, owningEntityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, owningEntityResult.entityLifecycleStatus());
  }
}
