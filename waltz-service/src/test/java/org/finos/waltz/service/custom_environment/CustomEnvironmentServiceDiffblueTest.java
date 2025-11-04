package org.finos.waltz.service.custom_environment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.custom_environment.CustomEnvironment;
import org.finos.waltz.model.permission_group.CheckPermissionCommand;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement.InvolvementService;
import org.finos.waltz.service.involvement_kind.InvolvementKindService;
import org.finos.waltz.service.permission.PermissionGroupService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CustomEnvironmentServiceDiffblueTest {
  /**
   * Method under test: {@link CustomEnvironmentService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    CustomEnvironmentDao customEnvironmentDao = mock(CustomEnvironmentDao.class);
    HashSet<CustomEnvironment> customEnvironmentSet = new HashSet<>();
    when(customEnvironmentDao.findAll()).thenReturn(customEnvironmentSet);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    Set<CustomEnvironment> actualFindAllResult = (new CustomEnvironmentService(customEnvironmentDao, changeLogService,
        new PermissionGroupService(personService, permissionGroupDao,
            new InvolvementService(changeLogService2, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver,
                new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
                mock(UserRoleService.class))))).findAll();

    // Assert
    verify(customEnvironmentDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(customEnvironmentSet, actualFindAllResult);
  }

  /**
   * Method under test:
   * {@link CustomEnvironmentService#findByOwningEntityRef(EntityReference)}
   */
  @Test
  void testFindByOwningEntityRef() {
    // Arrange
    CustomEnvironmentDao customEnvironmentDao = mock(CustomEnvironmentDao.class);
    HashSet<CustomEnvironment> customEnvironmentSet = new HashSet<>();
    when(customEnvironmentDao.findByOwningEntityRef(Mockito.<EntityReference>any())).thenReturn(customEnvironmentSet);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    Collection<CustomEnvironment> actualFindByOwningEntityRefResult = (new CustomEnvironmentService(
        customEnvironmentDao, changeLogService,
        new PermissionGroupService(personService, permissionGroupDao,
            new InvolvementService(changeLogService2, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver,
                new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
                mock(UserRoleService.class))))).findByOwningEntityRef(null);

    // Assert
    verify(customEnvironmentDao).findByOwningEntityRef(isNull());
    assertTrue(actualFindByOwningEntityRefResult instanceof Set);
    assertTrue(actualFindByOwningEntityRefResult.isEmpty());
    assertSame(customEnvironmentSet, actualFindByOwningEntityRefResult);
  }

  /**
   * Method under test: {@link CustomEnvironmentService#remove(Long, String)}
   */
  @Test
  void testRemove() throws InsufficientPrivelegeException {
    // Arrange
    CustomEnvironment customEnvironment = mock(CustomEnvironment.class);
    when(customEnvironment.name()).thenReturn("Name");
    when(customEnvironment.groupName()).thenReturn("Group Name");
    when(customEnvironment.owningEntity()).thenReturn(mock(EntityReference.class));
    CustomEnvironmentDao customEnvironmentDao = mock(CustomEnvironmentDao.class);
    when(customEnvironmentDao.remove(Mockito.<Long>any())).thenReturn(true);
    when(customEnvironmentDao.getById(Mockito.<Long>any())).thenReturn(customEnvironment);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    PermissionGroupService permissionGroupService = mock(PermissionGroupService.class);
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any())).thenReturn(true);

    // Act
    Boolean actualRemoveResult = (new CustomEnvironmentService(customEnvironmentDao, changeLogService,
        permissionGroupService)).remove(1L, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(customEnvironmentDao).getById(eq(1L));
    verify(customEnvironmentDao).remove(eq(1L));
    verify(customEnvironment).name();
    verify(customEnvironment).groupName();
    verify(customEnvironment, atLeast(1)).owningEntity();
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test: {@link CustomEnvironmentService#remove(Long, String)}
   */
  @Test
  void testRemove2() throws InsufficientPrivelegeException {
    // Arrange
    CustomEnvironment customEnvironment = mock(CustomEnvironment.class);
    when(customEnvironment.owningEntity()).thenReturn(mock(EntityReference.class));
    CustomEnvironmentDao customEnvironmentDao = mock(CustomEnvironmentDao.class);
    when(customEnvironmentDao.remove(Mockito.<Long>any())).thenReturn(false);
    when(customEnvironmentDao.getById(Mockito.<Long>any())).thenReturn(customEnvironment);
    PermissionGroupService permissionGroupService = mock(PermissionGroupService.class);
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any())).thenReturn(true);

    // Act
    Boolean actualRemoveResult = (new CustomEnvironmentService(customEnvironmentDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        permissionGroupService)).remove(1L, "janedoe");

    // Assert
    verify(customEnvironmentDao).getById(eq(1L));
    verify(customEnvironmentDao).remove(eq(1L));
    verify(customEnvironment).owningEntity();
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link CustomEnvironmentService#remove(Long, String)}
   */
  @Test
  void testRemove3() throws InsufficientPrivelegeException {
    // Arrange
    CustomEnvironment customEnvironment = mock(CustomEnvironment.class);
    when(customEnvironment.name()).thenReturn("Name");
    when(customEnvironment.groupName()).thenReturn("Group Name");
    when(customEnvironment.owningEntity()).thenReturn(mock(EntityReference.class));
    CustomEnvironmentDao customEnvironmentDao = mock(CustomEnvironmentDao.class);
    when(customEnvironmentDao.remove(Mockito.<Long>any())).thenReturn(true);
    when(customEnvironmentDao.getById(Mockito.<Long>any())).thenReturn(customEnvironment);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    PermissionGroupService permissionGroupService = mock(PermissionGroupService.class);
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any())).thenReturn(true);

    // Act
    Boolean actualRemoveResult = (new CustomEnvironmentService(customEnvironmentDao, changeLogService,
        permissionGroupService)).remove(1L, "janedoe");

    // Assert
    verify(customEnvironmentDao).getById(eq(1L));
    verify(customEnvironmentDao).remove(eq(1L));
    verify(customEnvironment).name();
    verify(customEnvironment).groupName();
    verify(customEnvironment, atLeast(1)).owningEntity();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test: {@link CustomEnvironmentService#remove(Long, String)}
   */
  @Test
  void testRemove4() throws InsufficientPrivelegeException {
    // Arrange
    CustomEnvironment customEnvironment = mock(CustomEnvironment.class);
    when(customEnvironment.owningEntity()).thenReturn(mock(EntityReference.class));
    CustomEnvironmentDao customEnvironmentDao = mock(CustomEnvironmentDao.class);
    when(customEnvironmentDao.getById(Mockito.<Long>any())).thenReturn(customEnvironment);
    PermissionGroupService permissionGroupService = mock(PermissionGroupService.class);
    when(permissionGroupService.hasPermission(Mockito.<CheckPermissionCommand>any())).thenReturn(false);

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> (new CustomEnvironmentService(customEnvironmentDao, mock(ChangeLogService.class), permissionGroupService))
            .remove(1L, "janedoe"));
    verify(customEnvironmentDao).getById(eq(1L));
    verify(customEnvironment).owningEntity();
    verify(permissionGroupService).hasPermission(isA(CheckPermissionCommand.class));
  }

  /**
   * Method under test: {@link CustomEnvironmentService#getById(Long)}
   */
  @Test
  void testGetById() {
    // Arrange
    CustomEnvironmentDao customEnvironmentDao = mock(CustomEnvironmentDao.class);
    when(customEnvironmentDao.getById(Mockito.<Long>any())).thenReturn(null);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    PermissionGroupDao permissionGroupDao = mock(PermissionGroupDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao dao = mock(InvolvementDao.class);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowDao physicalFlowDao = mock(PhysicalFlowDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    CustomEnvironment actualById = (new CustomEnvironmentService(customEnvironmentDao, changeLogService,
        new PermissionGroupService(personService, permissionGroupDao,
            new InvolvementService(changeLogService2, dao, logicalFlowDao, physicalFlowDao, entityReferenceNameResolver,
                new InvolvementKindService(mock(InvolvementKindDao.class)), mock(PersonDao.class),
                mock(UserRoleService.class))))).getById(1L);

    // Assert
    verify(customEnvironmentDao).getById(eq(1L));
    assertNull(actualById);
  }
}
