package org.finos.waltz.service.measurable_category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.exceptions.NotAuthorizedException;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategory;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MeasurableCategoryServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private MeasurableCategoryDao measurableCategoryDao;

  @InjectMocks private MeasurableCategoryService measurableCategoryService;

  @Mock private UserRoleService userRoleService;

  /**
   * Test {@link MeasurableCategoryService#findAll()}.
   *
   * <ul>
   *   <li>Given {@link MeasurableCategoryDao} {@link MeasurableCategoryDao#findAll()} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryService#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given MeasurableCategoryDao findAll() return ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableCategoryService.findAll()"})
  void testFindAll_givenMeasurableCategoryDaoFindAllReturnArrayList_thenReturnList() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ArrayList<MeasurableCategory> measurableCategoryList = new ArrayList<>();
    when(measurableCategoryDao.findAll()).thenReturn(measurableCategoryList);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    // Act
    Collection<MeasurableCategory> actualFindAllResult = measurableCategoryService.findAll();

    // Assert
    verify(measurableCategoryDao).findAll();
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(measurableCategoryList, actualFindAllResult);
  }

  /**
   * Test {@link MeasurableCategoryService#findAll()}.
   *
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryService#findAll()}
   */
  @Test
  @DisplayName("Test findAll(); then throw NotAuthorizedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableCategoryService.findAll()"})
  void testFindAll_thenThrowNotAuthorizedException() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.findAll()).thenThrow(new NotAuthorizedException());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    // Act and Assert
    assertThrows(NotAuthorizedException.class, () -> measurableCategoryService.findAll());
    verify(measurableCategoryDao).findAll();
  }

  /**
   * Test {@link MeasurableCategoryService#getById(long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableMeasurableCategory}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then return ImmutableMeasurableCategory")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableCategory MeasurableCategoryService.getById(long)"})
  void testGetById_thenReturnImmutableMeasurableCategory() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.getById(anyLong()))
        .thenReturn(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    // Act
    MeasurableCategory actualById = measurableCategoryService.getById(1L);

    // Assert
    verify(measurableCategoryDao).getById(1L);
    assertTrue(actualById instanceof ImmutableMeasurableCategory);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Icon", actualById.icon());
    assertEquals("Name", actualById.name());
    assertEquals("Rating Editor Role", actualById.ratingEditorRole());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(0, actualById.position());
    assertEquals(1L, actualById.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertFalse(actualById.editable());
    assertFalse(actualById.isDeprecated());
    assertTrue(actualById.allowPrimaryRatings());
  }

  /**
   * Test {@link MeasurableCategoryService#getById(long)}.
   *
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then throw NotAuthorizedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableCategory MeasurableCategoryService.getById(long)"})
  void testGetById_thenThrowNotAuthorizedException() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.getById(anyLong())).thenThrow(new NotAuthorizedException());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    // Act and Assert
    assertThrows(NotAuthorizedException.class, () -> measurableCategoryService.getById(1L));
    verify(measurableCategoryDao).getById(1L);
  }

  /**
   * Test {@link MeasurableCategoryService#findCategoriesByDirectOrgUnit(long)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryService#findCategoriesByDirectOrgUnit(long)}
   */
  @Test
  @DisplayName("Test findCategoriesByDirectOrgUnit(long); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableCategoryService.findCategoriesByDirectOrgUnit(long)"})
  void testFindCategoriesByDirectOrgUnit_thenReturnList() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ArrayList<MeasurableCategory> measurableCategoryList = new ArrayList<>();
    when(measurableCategoryDao.findCategoriesByDirectOrgUnit(anyLong()))
        .thenReturn(measurableCategoryList);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    // Act
    Collection<MeasurableCategory> actualFindCategoriesByDirectOrgUnitResult =
        measurableCategoryService.findCategoriesByDirectOrgUnit(1L);

    // Assert
    verify(measurableCategoryDao).findCategoriesByDirectOrgUnit(1L);
    assertTrue(actualFindCategoriesByDirectOrgUnitResult instanceof List);
    assertTrue(actualFindCategoriesByDirectOrgUnitResult.isEmpty());
    assertSame(measurableCategoryList, actualFindCategoriesByDirectOrgUnitResult);
  }

  /**
   * Test {@link MeasurableCategoryService#findCategoriesByDirectOrgUnit(long)}.
   *
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryService#findCategoriesByDirectOrgUnit(long)}
   */
  @Test
  @DisplayName("Test findCategoriesByDirectOrgUnit(long); then throw NotAuthorizedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MeasurableCategoryService.findCategoriesByDirectOrgUnit(long)"})
  void testFindCategoriesByDirectOrgUnit_thenThrowNotAuthorizedException() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.findCategoriesByDirectOrgUnit(anyLong()))
        .thenThrow(new NotAuthorizedException());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () -> measurableCategoryService.findCategoriesByDirectOrgUnit(1L));
    verify(measurableCategoryDao).findCategoriesByDirectOrgUnit(1L);
  }

  /**
   * Test {@link MeasurableCategoryService#findByExternalId(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryService#findByExternalId(String)}
   */
  @Test
  @DisplayName("Test findByExternalId(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableCategoryService.findByExternalId(String)"})
  void testFindByExternalId_thenReturnEmpty() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.findByExternalId(Mockito.<String>any())).thenReturn(new HashSet<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    // Act
    Set<MeasurableCategory> actualFindByExternalIdResult =
        measurableCategoryService.findByExternalId("42");

    // Assert
    verify(measurableCategoryDao).findByExternalId("42");
    assertTrue(actualFindByExternalIdResult.isEmpty());
  }

  /**
   * Test {@link MeasurableCategoryService#findByExternalId(String)}.
   *
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryService#findByExternalId(String)}
   */
  @Test
  @DisplayName("Test findByExternalId(String); then throw NotAuthorizedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MeasurableCategoryService.findByExternalId(String)"})
  void testFindByExternalId_thenThrowNotAuthorizedException() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.findByExternalId(Mockito.<String>any()))
        .thenThrow(new NotAuthorizedException());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class, () -> measurableCategoryService.findByExternalId("42"));
    verify(measurableCategoryDao).findByExternalId("42");
  }

  /**
   * Test {@link MeasurableCategoryService#findPopulatedCategoriesForRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableCategoryService#findPopulatedCategoriesForRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findPopulatedCategoriesForRef(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List MeasurableCategoryService.findPopulatedCategoriesForRef(EntityReference)"
  })
  void testFindPopulatedCategoriesForRef_thenReturnEmpty() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.findAll()).thenReturn(new ArrayList<>());
    when(measurableCategoryDao.findRatingCountsByCategoryId(Mockito.<EntityReference>any()))
        .thenReturn(new HashMap<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    // Act
    List<MeasurableCategoryView> actualFindPopulatedCategoriesForRefResult =
        measurableCategoryService.findPopulatedCategoriesForRef(null);

    // Assert
    verify(measurableCategoryDao).findAll();
    verify(measurableCategoryDao).findRatingCountsByCategoryId(isNull());
    assertTrue(actualFindPopulatedCategoriesForRefResult.isEmpty());
  }

  /**
   * Test {@link MeasurableCategoryService#findPopulatedCategoriesForRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableCategoryService#findPopulatedCategoriesForRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findPopulatedCategoriesForRef(EntityReference); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List MeasurableCategoryService.findPopulatedCategoriesForRef(EntityReference)"
  })
  void testFindPopulatedCategoriesForRef_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<MeasurableCategory> measurableCategoryList = new ArrayList<>();
    measurableCategoryList.add(
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());

    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.findAll()).thenReturn(measurableCategoryList);
    when(measurableCategoryDao.findRatingCountsByCategoryId(Mockito.<EntityReference>any()))
        .thenReturn(new HashMap<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    // Act
    List<MeasurableCategoryView> actualFindPopulatedCategoriesForRefResult =
        measurableCategoryService.findPopulatedCategoriesForRef(null);

    // Assert
    verify(measurableCategoryDao).findAll();
    verify(measurableCategoryDao).findRatingCountsByCategoryId(isNull());
    assertEquals(1, actualFindPopulatedCategoriesForRefResult.size());
    MeasurableCategoryView getResult = actualFindPopulatedCategoriesForRefResult.get(0);
    MeasurableCategory categoryResult = getResult.category();
    assertTrue(categoryResult instanceof ImmutableMeasurableCategory);
    assertTrue(getResult instanceof ImmutableMeasurableCategoryView);
    assertEquals("2020-03-01", categoryResult.lastUpdatedBy());
    assertEquals("Icon", categoryResult.icon());
    assertEquals("Name", categoryResult.name());
    assertEquals("Rating Editor Role", categoryResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", categoryResult.description());
    assertEquals(0, categoryResult.position());
    assertEquals(0L, getResult.ratingCount().longValue());
    assertEquals(1L, categoryResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, categoryResult.kind());
    assertFalse(categoryResult.editable());
    assertFalse(categoryResult.isDeprecated());
    assertTrue(categoryResult.allowPrimaryRatings());
  }

  /**
   * Test {@link MeasurableCategoryService#findPopulatedCategoriesForRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableCategoryService#findPopulatedCategoriesForRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findPopulatedCategoriesForRef(EntityReference); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List MeasurableCategoryService.findPopulatedCategoriesForRef(EntityReference)"
  })
  void testFindPopulatedCategoriesForRef_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<MeasurableCategory> measurableCategoryList = new ArrayList<>();
    measurableCategoryList.add(
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
    measurableCategoryList.add(
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());

    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.findAll()).thenReturn(measurableCategoryList);
    when(measurableCategoryDao.findRatingCountsByCategoryId(Mockito.<EntityReference>any()))
        .thenReturn(new HashMap<>());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    // Act
    List<MeasurableCategoryView> actualFindPopulatedCategoriesForRefResult =
        measurableCategoryService.findPopulatedCategoriesForRef(null);

    // Assert
    verify(measurableCategoryDao).findAll();
    verify(measurableCategoryDao).findRatingCountsByCategoryId(isNull());
    assertEquals(2, actualFindPopulatedCategoriesForRefResult.size());
    MeasurableCategoryView getResult = actualFindPopulatedCategoriesForRefResult.get(1);
    assertTrue(getResult instanceof ImmutableMeasurableCategoryView);
    assertEquals(actualFindPopulatedCategoriesForRefResult.get(0), getResult);
  }

  /**
   * Test {@link MeasurableCategoryService#findPopulatedCategoriesForRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableCategoryService#findPopulatedCategoriesForRef(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findPopulatedCategoriesForRef(EntityReference); then throw NotAuthorizedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List MeasurableCategoryService.findPopulatedCategoriesForRef(EntityReference)"
  })
  void testFindPopulatedCategoriesForRef_thenThrowNotAuthorizedException() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.findAll()).thenThrow(new NotAuthorizedException());
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () -> measurableCategoryService.findPopulatedCategoriesForRef(null));
    verify(measurableCategoryDao).findAll();
  }

  /**
   * Test {@link MeasurableCategoryService#save(MeasurableCategory, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryService#save(MeasurableCategory, String)}
   */
  @Test
  @DisplayName(
      "Test save(MeasurableCategory, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableCategoryService.save(MeasurableCategory, String)"})
  void testSave_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.save(Mockito.<MeasurableCategory>any(), Mockito.<String>any()))
        .thenReturn(1L);

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService2);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService,
            measurableService,
            settingsService);

    // Act
    Long actualSaveResult =
        measurableCategoryService.save(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableCategoryDao).save(isA(MeasurableCategory.class), eq("janedoe"));
    verify(userRoleService).hasAnyRole(eq("janedoe"), (SystemRole[]) Mockito.any());
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Test {@link MeasurableCategoryService#save(MeasurableCategory, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryService#save(MeasurableCategory, String)}
   */
  @Test
  @DisplayName(
      "Test save(MeasurableCategory, String); given ChangeLogService write(ChangeLog) return '19088743'; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableCategoryService.save(MeasurableCategory, String)"})
  void testSave_givenChangeLogServiceWriteReturn19088743_thenReturnLongValueIsOne() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.save(Mockito.<MeasurableCategory>any(), Mockito.<String>any()))
        .thenReturn(1L);

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService2);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService,
            measurableService,
            settingsService);

    // Act
    Long actualSaveResult =
        measurableCategoryService.save(
            ImmutableMeasurableCategory.builder()
                .allowPrimaryRatings(true)
                .constrainingAssessmentDefinitionId(1L)
                .description("The characteristics of someone or something")
                .externalId("42")
                .icon("Icon")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .ratingEditorRole("Rating Editor Role")
                .ratingSchemeId(1L)
                .build(),
            "janedoe");

    // Assert
    verify(measurableCategoryDao).save(isA(MeasurableCategory.class), eq("janedoe"));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasAnyRole(eq("janedoe"), (SystemRole[]) Mockito.any());
    assertEquals(1L, actualSaveResult.longValue());
  }

  /**
   * Test {@link MeasurableCategoryService#save(MeasurableCategory, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       NotAuthorizedException#NotAuthorizedException()}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryService#save(MeasurableCategory, String)}
   */
  @Test
  @DisplayName(
      "Test save(MeasurableCategory, String); given ChangeLogService write(ChangeLog) throw NotAuthorizedException(); then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableCategoryService.save(MeasurableCategory, String)"})
  void testSave_givenChangeLogServiceWriteThrowNotAuthorizedException_thenCallsWrite() {
    // Arrange
    when(measurableCategoryDao.save(Mockito.<MeasurableCategory>any(), Mockito.<String>any()))
        .thenReturn(1L);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenThrow(new NotAuthorizedException());

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () ->
            measurableCategoryService.save(
                ImmutableMeasurableCategory.builder()
                    .allowPrimaryRatings(true)
                    .constrainingAssessmentDefinitionId(1L)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .icon("Icon")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .ratingEditorRole("Rating Editor Role")
                    .ratingSchemeId(1L)
                    .build(),
                "janedoe"));
    verify(measurableCategoryDao).save(isA(MeasurableCategory.class), eq("janedoe"));
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(userRoleService).hasAnyRole(eq("janedoe"), (SystemRole[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableCategoryService#save(MeasurableCategory, String)}.
   *
   * <ul>
   *   <li>Given {@link MeasurableCategoryDao} {@link MeasurableCategoryDao#save(MeasurableCategory,
   *       String)} throw {@link NotAuthorizedException#NotAuthorizedException()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryService#save(MeasurableCategory, String)}
   */
  @Test
  @DisplayName(
      "Test save(MeasurableCategory, String); given MeasurableCategoryDao save(MeasurableCategory, String) throw NotAuthorizedException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableCategoryService.save(MeasurableCategory, String)"})
  void testSave_givenMeasurableCategoryDaoSaveThrowNotAuthorizedException() {
    // Arrange
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.save(Mockito.<MeasurableCategory>any(), Mockito.<String>any()))
        .thenThrow(new NotAuthorizedException());

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService2);
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService,
            measurableService,
            settingsService);

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () ->
            measurableCategoryService.save(
                ImmutableMeasurableCategory.builder()
                    .allowPrimaryRatings(true)
                    .constrainingAssessmentDefinitionId(1L)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .icon("Icon")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .ratingEditorRole("Rating Editor Role")
                    .ratingSchemeId(1L)
                    .build(),
                "janedoe"));
    verify(measurableCategoryDao).save(isA(MeasurableCategory.class), eq("janedoe"));
    verify(userRoleService).hasAnyRole(eq("janedoe"), (SystemRole[]) Mockito.any());
  }

  /**
   * Test {@link MeasurableCategoryService#save(MeasurableCategory, String)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleDao} {@link UserRoleDao#getUserRoles(String)} return {@link
   *       HashSet#HashSet()}.
   *   <li>Then calls {@link UserRoleDao#getUserRoles(String)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryService#save(MeasurableCategory, String)}
   */
  @Test
  @DisplayName(
      "Test save(MeasurableCategory, String); given UserRoleDao getUserRoles(String) return HashSet(); then calls getUserRoles(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableCategoryService.save(MeasurableCategory, String)"})
  void testSave_givenUserRoleDaoGetUserRolesReturnHashSet_thenCallsGetUserRoles() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
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
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
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
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService3 =
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

    MeasurableService measurableService =
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver, changeLogService3);
    SettingsDao settingsDao2 = mock(SettingsDao.class);
    SettingsService settingsService2 = new SettingsService(settingsDao2, new ArrayList<>());

    MeasurableCategoryService measurableCategoryService =
        new MeasurableCategoryService(
            measurableCategoryDao,
            userRoleService,
            changeLogService2,
            measurableService,
            settingsService2);

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class, () -> measurableCategoryService.save(null, "janedoe"));
    verify(userRoleDao).getUserRoles("janedoe");
  }

  /**
   * Test {@link MeasurableCategoryService#save(MeasurableCategory, String)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasAnyRole(String, SystemRole[])}
   *       throw {@link NotAuthorizedException#NotAuthorizedException()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableCategoryService#save(MeasurableCategory, String)}
   */
  @Test
  @DisplayName(
      "Test save(MeasurableCategory, String); given UserRoleService hasAnyRole(String, SystemRole[]) throw NotAuthorizedException(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long MeasurableCategoryService.save(MeasurableCategory, String)"})
  void testSave_givenUserRoleServiceHasAnyRoleThrowNotAuthorizedException_whenNull() {
    // Arrange
    when(userRoleService.hasAnyRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenThrow(new NotAuthorizedException());

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class, () -> measurableCategoryService.save(null, "janedoe"));
    verify(userRoleService).hasAnyRole(eq("janedoe"), (SystemRole[]) Mockito.any());
  }
}
