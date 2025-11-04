package org.finos.waltz.service.measurable_category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.measurable.search.MeasurableSearchDao;
import org.finos.waltz.data.measurable_category.MeasurableCategoryDao;
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
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.exceptions.NotAuthorizedException;
import org.finos.waltz.model.measurable.Measurable;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategoryView;
import org.finos.waltz.model.measurable_category.MeasurableCategory;
import org.finos.waltz.model.measurable_category.MeasurableCategoryView;
import org.finos.waltz.model.user.SystemRole;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableCategoryServiceDiffblueTest {
  /**
   * Method under test: {@link MeasurableCategoryService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ArrayList<MeasurableCategory> measurableCategoryList = new ArrayList<>();
    when(measurableCategoryDao.findAll()).thenReturn(measurableCategoryList);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    Collection<MeasurableCategory> actualFindAllResult = (new MeasurableCategoryService(measurableCategoryDao,
        userRoleService, changeLogService2, measurableService, new SettingsService(settingsDao2, new ArrayList<>())))
            .findAll();

    // Assert
    verify(measurableCategoryDao).findAll();
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(measurableCategoryList, actualFindAllResult);
  }

  /**
   * Method under test: {@link MeasurableCategoryService#findAll()}
   */
  @Test
  void testFindAll2() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.findAll()).thenThrow(new NotAuthorizedException("An error occurred"));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> (new MeasurableCategoryService(measurableCategoryDao, userRoleService, changeLogService2,
            measurableService, new SettingsService(settingsDao2, new ArrayList<>()))).findAll());
    verify(measurableCategoryDao).findAll();
  }

  /**
   * Method under test: {@link MeasurableCategoryService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.getById(anyLong())).thenReturn(null);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    MeasurableCategory actualById = (new MeasurableCategoryService(measurableCategoryDao, userRoleService,
        changeLogService2, measurableService, new SettingsService(settingsDao2, new ArrayList<>()))).getById(1L);

    // Assert
    verify(measurableCategoryDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link MeasurableCategoryService#getById(long)}
   */
  @Test
  void testGetById2() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.getById(anyLong())).thenThrow(new NotAuthorizedException("An error occurred"));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> (new MeasurableCategoryService(measurableCategoryDao, userRoleService, changeLogService2,
            measurableService, new SettingsService(settingsDao2, new ArrayList<>()))).getById(1L));
    verify(measurableCategoryDao).getById(eq(1L));
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryService#findCategoriesByDirectOrgUnit(long)}
   */
  @Test
  void testFindCategoriesByDirectOrgUnit() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ArrayList<MeasurableCategory> measurableCategoryList = new ArrayList<>();
    when(measurableCategoryDao.findCategoriesByDirectOrgUnit(anyLong())).thenReturn(measurableCategoryList);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    Collection<MeasurableCategory> actualFindCategoriesByDirectOrgUnitResult = (new MeasurableCategoryService(
        measurableCategoryDao, userRoleService, changeLogService2, measurableService,
        new SettingsService(settingsDao2, new ArrayList<>()))).findCategoriesByDirectOrgUnit(1L);

    // Assert
    verify(measurableCategoryDao).findCategoriesByDirectOrgUnit(eq(1L));
    assertTrue(actualFindCategoriesByDirectOrgUnitResult instanceof List);
    assertTrue(actualFindCategoriesByDirectOrgUnitResult.isEmpty());
    assertSame(measurableCategoryList, actualFindCategoriesByDirectOrgUnitResult);
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryService#findCategoriesByDirectOrgUnit(long)}
   */
  @Test
  void testFindCategoriesByDirectOrgUnit2() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.findCategoriesByDirectOrgUnit(anyLong()))
        .thenThrow(new NotAuthorizedException("An error occurred"));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> (new MeasurableCategoryService(measurableCategoryDao, userRoleService, changeLogService2,
            measurableService, new SettingsService(settingsDao2, new ArrayList<>())))
                .findCategoriesByDirectOrgUnit(1L));
    verify(measurableCategoryDao).findCategoriesByDirectOrgUnit(eq(1L));
  }

  /**
   * Method under test: {@link MeasurableCategoryService#findByExternalId(String)}
   */
  @Test
  void testFindByExternalId() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    HashSet<MeasurableCategory> measurableCategorySet = new HashSet<>();
    when(measurableCategoryDao.findByExternalId(Mockito.<String>any())).thenReturn(measurableCategorySet);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    Set<MeasurableCategory> actualFindByExternalIdResult = (new MeasurableCategoryService(measurableCategoryDao,
        userRoleService, changeLogService2, measurableService, new SettingsService(settingsDao2, new ArrayList<>())))
            .findByExternalId("42");

    // Assert
    verify(measurableCategoryDao).findByExternalId(eq("42"));
    assertTrue(actualFindByExternalIdResult.isEmpty());
    assertSame(measurableCategorySet, actualFindByExternalIdResult);
  }

  /**
   * Method under test: {@link MeasurableCategoryService#findByExternalId(String)}
   */
  @Test
  void testFindByExternalId2() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.findByExternalId(Mockito.<String>any()))
        .thenThrow(new NotAuthorizedException("An error occurred"));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> (new MeasurableCategoryService(measurableCategoryDao, userRoleService, changeLogService2,
            measurableService, new SettingsService(settingsDao2, new ArrayList<>()))).findByExternalId("42"));
    verify(measurableCategoryDao).findByExternalId(eq("42"));
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryService#findPopulatedCategoriesForRef(EntityReference)}
   */
  @Test
  void testFindPopulatedCategoriesForRef() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryDao.findRatingCountsByCategoryId(Mockito.<EntityReference>any()))
        .thenReturn(new HashMap<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    List<MeasurableCategoryView> actualFindPopulatedCategoriesForRefResult = (new MeasurableCategoryService(
        measurableCategoryDao, userRoleService, changeLogService2, measurableService,
        new SettingsService(settingsDao2, new ArrayList<>()))).findPopulatedCategoriesForRef(null);

    // Assert
    verify(measurableCategoryDao).findAll();
    verify(measurableCategoryDao).findRatingCountsByCategoryId(isNull());
    assertTrue(actualFindPopulatedCategoriesForRefResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryService#findPopulatedCategoriesForRef(EntityReference)}
   */
  @Test
  void testFindPopulatedCategoriesForRef2() {
    // Arrange
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurableCategory.id()).thenReturn(ofResult);

    ArrayList<MeasurableCategory> measurableCategoryList = new ArrayList<>();
    measurableCategoryList.add(measurableCategory);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.findAll()).thenReturn(measurableCategoryList);
    when(measurableCategoryDao.findRatingCountsByCategoryId(Mockito.<EntityReference>any()))
        .thenReturn(new HashMap<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    List<MeasurableCategoryView> actualFindPopulatedCategoriesForRefResult = (new MeasurableCategoryService(
        measurableCategoryDao, userRoleService, changeLogService2, measurableService,
        new SettingsService(settingsDao2, new ArrayList<>()))).findPopulatedCategoriesForRef(null);

    // Assert
    verify(measurableCategoryDao).findAll();
    verify(measurableCategoryDao).findRatingCountsByCategoryId(isNull());
    verify(measurableCategory).id();
    assertEquals(1, actualFindPopulatedCategoriesForRefResult.size());
    MeasurableCategoryView getResult = actualFindPopulatedCategoriesForRefResult.get(0);
    assertTrue(getResult instanceof ImmutableMeasurableCategoryView);
    assertEquals(0L, getResult.ratingCount().longValue());
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryService#findPopulatedCategoriesForRef(EntityReference)}
   */
  @Test
  void testFindPopulatedCategoriesForRef3() {
    // Arrange
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    when(measurableCategory.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurableCategory.id()).thenReturn(ofResult);
    MeasurableCategory measurableCategory2 = mock(MeasurableCategory.class);
    when(measurableCategory2.name()).thenReturn("Name");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(measurableCategory2.id()).thenReturn(ofResult2);

    ArrayList<MeasurableCategory> measurableCategoryList = new ArrayList<>();
    measurableCategoryList.add(measurableCategory2);
    measurableCategoryList.add(measurableCategory);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.findAll()).thenReturn(measurableCategoryList);
    when(measurableCategoryDao.findRatingCountsByCategoryId(Mockito.<EntityReference>any()))
        .thenReturn(new HashMap<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    List<MeasurableCategoryView> actualFindPopulatedCategoriesForRefResult = (new MeasurableCategoryService(
        measurableCategoryDao, userRoleService, changeLogService2, measurableService,
        new SettingsService(settingsDao2, new ArrayList<>()))).findPopulatedCategoriesForRef(null);

    // Assert
    verify(measurableCategoryDao).findAll();
    verify(measurableCategoryDao).findRatingCountsByCategoryId(isNull());
    verify(measurableCategory2).id();
    verify(measurableCategory).id();
    verify(measurableCategory2).name();
    verify(measurableCategory).name();
    assertEquals(2, actualFindPopulatedCategoriesForRefResult.size());
    MeasurableCategoryView getResult = actualFindPopulatedCategoriesForRefResult.get(0);
    assertTrue(getResult instanceof ImmutableMeasurableCategoryView);
    MeasurableCategoryView getResult2 = actualFindPopulatedCategoriesForRefResult.get(1);
    assertTrue(getResult2 instanceof ImmutableMeasurableCategoryView);
    assertEquals(0L, getResult.ratingCount().longValue());
    assertEquals(0L, getResult2.ratingCount().longValue());
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryService#findPopulatedCategoriesForRef(EntityReference)}
   */
  @Test
  void testFindPopulatedCategoriesForRef4() {
    // Arrange
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    when(measurableCategory.name()).thenThrow(new NotAuthorizedException("An error occurred"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurableCategory.id()).thenReturn(ofResult);
    MeasurableCategory measurableCategory2 = mock(MeasurableCategory.class);
    when(measurableCategory2.name()).thenReturn("Name");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(measurableCategory2.id()).thenReturn(ofResult2);

    ArrayList<MeasurableCategory> measurableCategoryList = new ArrayList<>();
    measurableCategoryList.add(measurableCategory2);
    measurableCategoryList.add(measurableCategory);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.findAll()).thenReturn(measurableCategoryList);
    when(measurableCategoryDao.findRatingCountsByCategoryId(Mockito.<EntityReference>any()))
        .thenReturn(new HashMap<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> (new MeasurableCategoryService(measurableCategoryDao, userRoleService, changeLogService2,
            measurableService, new SettingsService(settingsDao2, new ArrayList<>())))
                .findPopulatedCategoriesForRef(null));
    verify(measurableCategoryDao).findAll();
    verify(measurableCategoryDao).findRatingCountsByCategoryId(isNull());
    verify(measurableCategory2).id();
    verify(measurableCategory).id();
    verify(measurableCategory).name();
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryService#save(MeasurableCategory, String)}
   */
  @Test
  void testSave() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> (new MeasurableCategoryService(measurableCategoryDao, userRoleService, changeLogService2,
            measurableService, new SettingsService(settingsDao2, new ArrayList<>()))).save(null, "janedoe"));
    verify(userRoleDao).getUserRoles(eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryService#save(MeasurableCategory, String)}
   */
  @Test
  void testSave2() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.save(Mockito.<MeasurableCategory>any(), Mockito.<String>any())).thenReturn(1L);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), (SystemRole[]) any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    ChangeLogDao changeLogDao2 = mock(ChangeLogDao.class);
    when(changeLogDao2.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableService measurableService = new MeasurableService(mock(MeasurableDao.class),
        mock(MeasurableSearchDao.class), mock(EntityReferenceNameResolver.class),
        new ChangeLogService(changeLogDao2, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao = mock(SettingsDao.class);
    MeasurableCategoryService measurableCategoryService = new MeasurableCategoryService(measurableCategoryDao,
        userRoleService, changeLogService, measurableService, new SettingsService(settingsDao, new ArrayList<>()));
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurableCategory.id()).thenReturn(ofResult);

    // Act
    Long actualSaveResult = measurableCategoryService.save(measurableCategory, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableCategoryDao).save(isA(MeasurableCategory.class), eq("janedoe"));
    verify(measurableCategory).id();
    verify(userRoleService).hasAnyRole(eq("janedoe"), (SystemRole[]) any());
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryService#save(MeasurableCategory, String)}
   */
  @Test
  void testSave3() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.save(Mockito.<MeasurableCategory>any(), Mockito.<String>any())).thenReturn(1L);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), (SystemRole[]) any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao = mock(SettingsDao.class);
    MeasurableCategoryService measurableCategoryService = new MeasurableCategoryService(measurableCategoryDao,
        userRoleService, changeLogService, measurableService, new SettingsService(settingsDao, new ArrayList<>()));
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(measurableCategory.id()).thenReturn(ofResult);

    // Act
    Long actualSaveResult = measurableCategoryService.save(measurableCategory, "janedoe");

    // Assert
    verify(measurableCategoryDao).save(isA(MeasurableCategory.class), eq("janedoe"));
    verify(measurableCategory).id();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasAnyRole(eq("janedoe"), (SystemRole[]) any());
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryService#save(MeasurableCategory, String)}
   */
  @Test
  void testSave4() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.save(Mockito.<MeasurableCategory>any(), Mockito.<String>any())).thenReturn(1L);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), (SystemRole[]) any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.create(Mockito.<Measurable>any())).thenReturn(1L);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableService measurableService = new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        mock(EntityReferenceNameResolver.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao = mock(SettingsDao.class);
    MeasurableCategoryService measurableCategoryService = new MeasurableCategoryService(measurableCategoryDao,
        userRoleService, changeLogService, measurableService, new SettingsService(settingsDao, new ArrayList<>()));
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    when(measurableCategory.name()).thenReturn("Name");
    Optional<String> ofResult = Optional.of("foo");
    when(measurableCategory.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(measurableCategory.id()).thenReturn(emptyResult);

    // Act
    Long actualSaveResult = measurableCategoryService.save(measurableCategory, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).create(isA(Measurable.class));
    verify(measurableCategoryDao).save(isA(MeasurableCategory.class), eq("janedoe"));
    verify(measurableCategory).externalId();
    verify(measurableCategory).id();
    verify(measurableCategory).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasAnyRole(eq("janedoe"), (SystemRole[]) any());
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryService#save(MeasurableCategory, String)}
   */
  @Test
  void testSave5() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.save(Mockito.<MeasurableCategory>any(), Mockito.<String>any())).thenReturn(1L);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), (SystemRole[]) any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.create(Mockito.<Measurable>any())).thenReturn(2L);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableService measurableService = new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        mock(EntityReferenceNameResolver.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao = mock(SettingsDao.class);
    MeasurableCategoryService measurableCategoryService = new MeasurableCategoryService(measurableCategoryDao,
        userRoleService, changeLogService, measurableService, new SettingsService(settingsDao, new ArrayList<>()));
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    when(measurableCategory.name()).thenReturn("Name");
    Optional<String> ofResult = Optional.of("foo");
    when(measurableCategory.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(measurableCategory.id()).thenReturn(emptyResult);

    // Act
    Long actualSaveResult = measurableCategoryService.save(measurableCategory, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableDao).create(isA(Measurable.class));
    verify(measurableCategoryDao).save(isA(MeasurableCategory.class), eq("janedoe"));
    verify(measurableCategory).externalId();
    verify(measurableCategory).id();
    verify(measurableCategory).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasAnyRole(eq("janedoe"), (SystemRole[]) any());
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryService#save(MeasurableCategory, String)}
   */
  @Test
  void testSave6() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.save(Mockito.<MeasurableCategory>any(), Mockito.<String>any())).thenReturn(1L);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), (SystemRole[]) any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.create(Mockito.<Measurable>any())).thenReturn(1L);
    ChangeLogService changeLogService2 = mock(ChangeLogService.class);
    when(changeLogService2.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableService measurableService = new MeasurableService(measurableDao, mock(MeasurableSearchDao.class),
        mock(EntityReferenceNameResolver.class), changeLogService2);

    SettingsDao settingsDao = mock(SettingsDao.class);
    MeasurableCategoryService measurableCategoryService = new MeasurableCategoryService(measurableCategoryDao,
        userRoleService, changeLogService, measurableService, new SettingsService(settingsDao, new ArrayList<>()));
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    when(measurableCategory.name()).thenReturn("Name");
    Optional<String> ofResult = Optional.of("foo");
    when(measurableCategory.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(measurableCategory.id()).thenReturn(emptyResult);

    // Act
    Long actualSaveResult = measurableCategoryService.save(measurableCategory, "janedoe");

    // Assert
    verify(measurableDao).create(isA(Measurable.class));
    verify(measurableCategoryDao).save(isA(MeasurableCategory.class), eq("janedoe"));
    verify(measurableCategory).externalId();
    verify(measurableCategory).id();
    verify(measurableCategory).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(changeLogService2).write(isA(ChangeLog.class));
    verify(userRoleService).hasAnyRole(eq("janedoe"), (SystemRole[]) any());
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryService#save(MeasurableCategory, String)}
   */
  @Test
  void testSave7() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.save(Mockito.<MeasurableCategory>any(), Mockito.<String>any())).thenReturn(1L);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), (SystemRole[]) any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.create(Mockito.<Measurable>any(), Mockito.<String>any())).thenReturn(true);
    SettingsDao settingsDao = mock(SettingsDao.class);
    MeasurableCategoryService measurableCategoryService = new MeasurableCategoryService(measurableCategoryDao,
        userRoleService, changeLogService, measurableService, new SettingsService(settingsDao, new ArrayList<>()));
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    when(measurableCategory.name()).thenReturn("Name");
    Optional<String> ofResult = Optional.of("foo");
    when(measurableCategory.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(measurableCategory.id()).thenReturn(emptyResult);

    // Act
    Long actualSaveResult = measurableCategoryService.save(measurableCategory, "janedoe");

    // Assert
    verify(measurableCategoryDao).save(isA(MeasurableCategory.class), eq("janedoe"));
    verify(measurableCategory).externalId();
    verify(measurableCategory).id();
    verify(measurableCategory).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(measurableService).create(isA(Measurable.class), eq("janedoe"));
    verify(userRoleService).hasAnyRole(eq("janedoe"), (SystemRole[]) any());
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Method under test:
   * {@link MeasurableCategoryService#save(MeasurableCategory, String)}
   */
  @Test
  void testSave8() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.save(Mockito.<MeasurableCategory>any(), Mockito.<String>any())).thenReturn(1L);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), (SystemRole[]) any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableService measurableService = mock(MeasurableService.class);
    when(measurableService.create(Mockito.<Measurable>any(), Mockito.<String>any())).thenReturn(true);
    SettingsDao settingsDao = mock(SettingsDao.class);
    MeasurableCategoryService measurableCategoryService = new MeasurableCategoryService(measurableCategoryDao,
        userRoleService, changeLogService, measurableService, new SettingsService(settingsDao, new ArrayList<>()));
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    when(measurableCategory.name()).thenReturn("Name");
    Optional<String> emptyResult = Optional.empty();
    when(measurableCategory.externalId()).thenReturn(emptyResult);
    Optional<Long> emptyResult2 = Optional.empty();
    when(measurableCategory.id()).thenReturn(emptyResult2);

    // Act
    Long actualSaveResult = measurableCategoryService.save(measurableCategory, "janedoe");

    // Assert
    verify(measurableCategoryDao).save(isA(MeasurableCategory.class), eq("janedoe"));
    verify(measurableCategory).externalId();
    verify(measurableCategory).id();
    verify(measurableCategory).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(measurableService).create(isA(Measurable.class), eq("janedoe"));
    verify(userRoleService).hasAnyRole(eq("janedoe"), (SystemRole[]) any());
    assertEquals(1L, actualSaveResult.longValue());
  }
}
