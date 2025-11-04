package org.finos.waltz.service.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import org.finos.waltz.data.application.search.ApplicationSearchDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.entity_alias.EntityAliasDao;
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
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.measurable_category.MeasurableCategory;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.measurable_rating.MeasurableRatingStatParams;
import org.finos.waltz.model.measurable_rating.RemoveMeasurableRatingCommand;
import org.finos.waltz.model.measurable_rating.SaveMeasurableRatingCommand;
import org.finos.waltz.model.tally.MeasurableRatingTally;
import org.finos.waltz.model.tally.Tally;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.measurable_category.MeasurableCategoryService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.tag.TagService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableRatingServiceDiffblueTest {
  /**
   * Method under test:
   * {@link MeasurableRatingService#findForEntity(EntityReference)}
   */
  @Test
  void testFindForEntity() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    when(measurableRatingDao.findForEntity(Mockito.<EntityReference>any())).thenReturn(measurableRatingList);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    List<MeasurableRating> actualFindForEntityResult = (new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).findForEntity(mock(EntityReference.class));

    // Assert
    verify(measurableRatingDao).findForEntity(isA(EntityReference.class));
    assertTrue(actualFindForEntityResult.isEmpty());
    assertSame(measurableRatingList, actualFindForEntityResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#findForCategoryAndSubjectIdSelector(Select, long)}
   */
  @Test
  void testFindForCategoryAndSubjectIdSelector() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    when(measurableRatingDao.findForCategoryAndSubjectIdSelector(Mockito.<Select<Record1<Long>>>any(), anyLong()))
        .thenReturn(measurableRatingList);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    List<MeasurableRating> actualFindForCategoryAndSubjectIdSelectorResult = (new MeasurableRatingService(
        measurableRatingDao, measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService,
        entityReferenceNameResolver, measurableService, applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).findForCategoryAndSubjectIdSelector(mock(Select.class), 1L);

    // Assert
    verify(measurableRatingDao).findForCategoryAndSubjectIdSelector(isA(Select.class), eq(1L));
    assertTrue(actualFindForCategoryAndSubjectIdSelectorResult.isEmpty());
    assertSame(measurableRatingList, actualFindForCategoryAndSubjectIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#findForCategoryAndMeasurableRatingIdSelector(Select, long)}
   */
  @Test
  void testFindForCategoryAndMeasurableRatingIdSelector() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    when(measurableRatingDao.findForCategoryAndMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(),
        anyLong())).thenReturn(measurableRatingList);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    List<MeasurableRating> actualFindForCategoryAndMeasurableRatingIdSelectorResult = (new MeasurableRatingService(
        measurableRatingDao, measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService,
        entityReferenceNameResolver, measurableService, applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).findForCategoryAndMeasurableRatingIdSelector(mock(Select.class), 1L);

    // Assert
    verify(measurableRatingDao).findForCategoryAndMeasurableRatingIdSelector(isA(Select.class), eq(1L));
    assertTrue(actualFindForCategoryAndMeasurableRatingIdSelectorResult.isEmpty());
    assertSame(measurableRatingList, actualFindForCategoryAndMeasurableRatingIdSelectorResult);
  }

  /**
   * Method under test: {@link MeasurableRatingService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.getById(anyLong())).thenReturn(null);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    MeasurableRating actualById = (new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService, new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3,
            measurableService2, new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).getById(1L);

    // Assert
    verify(measurableRatingDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link MeasurableRatingService#getByDecommId(long)}
   */
  @Test
  void testGetByDecommId() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.getByDecommId(anyLong())).thenReturn(null);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    MeasurableRating actualByDecommId = (new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService, new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3,
            measurableService2, new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).getByDecommId(1L);

    // Assert
    verify(measurableRatingDao).getByDecommId(eq(1L));
    assertNull(actualByDecommId);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByMeasurableIdSelector() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    when(measurableRatingDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any(),
        Mockito.<IdSelectionOptions>any())).thenReturn(measurableRatingList);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<MeasurableRating> actualFindByMeasurableIdSelectorResult = measurableRatingService
        .findByMeasurableIdSelector(options);

    // Assert
    verify(measurableRatingDao).findByMeasurableIdSelector(isA(Select.class), isA(IdSelectionOptions.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
    assertSame(measurableRatingList, actualFindByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByMeasurableIdSelector2() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    when(measurableRatingDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any(),
        Mockito.<IdSelectionOptions>any())).thenReturn(measurableRatingList);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<MeasurableRating> actualFindByMeasurableIdSelectorResult = measurableRatingService
        .findByMeasurableIdSelector(options);

    // Assert
    verify(measurableRatingDao).findByMeasurableIdSelector(isA(Select.class), isA(IdSelectionOptions.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
    assertSame(measurableRatingList, actualFindByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByMeasurableIdSelector3() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    when(measurableRatingDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any(),
        Mockito.<IdSelectionOptions>any())).thenReturn(measurableRatingList);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.AGGREGATE_OVERLAY_DIAGRAM);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<MeasurableRating> actualFindByMeasurableIdSelectorResult = measurableRatingService
        .findByMeasurableIdSelector(options);

    // Assert
    verify(measurableRatingDao).findByMeasurableIdSelector(isNull(), isA(IdSelectionOptions.class));
    verify(entityReference).kind();
    verify(options).entityReference();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
    assertSame(measurableRatingList, actualFindByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByMeasurableIdSelector4() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    when(measurableRatingDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any(),
        Mockito.<IdSelectionOptions>any())).thenReturn(measurableRatingList);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<MeasurableRating> actualFindByMeasurableIdSelectorResult = measurableRatingService
        .findByMeasurableIdSelector(options);

    // Assert
    verify(measurableRatingDao).findByMeasurableIdSelector(isA(Select.class), isA(IdSelectionOptions.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options, atLeast(1)).scope();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
    assertSame(measurableRatingList, actualFindByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByMeasurableIdSelector5() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    when(measurableRatingDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any(),
        Mockito.<IdSelectionOptions>any())).thenReturn(measurableRatingList);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<MeasurableRating> actualFindByMeasurableIdSelectorResult = measurableRatingService
        .findByMeasurableIdSelector(options);

    // Assert
    verify(measurableRatingDao).findByMeasurableIdSelector(isA(Select.class), isA(IdSelectionOptions.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
    assertSame(measurableRatingList, actualFindByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#findByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByMeasurableIdSelector6() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    when(measurableRatingDao.findByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any(),
        Mockito.<IdSelectionOptions>any())).thenReturn(measurableRatingList);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<MeasurableRating> actualFindByMeasurableIdSelectorResult = measurableRatingService
        .findByMeasurableIdSelector(options);

    // Assert
    verify(measurableRatingDao).findByMeasurableIdSelector(isA(Select.class), isA(IdSelectionOptions.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByMeasurableIdSelectorResult.isEmpty());
    assertSame(measurableRatingList, actualFindByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByAppIdSelector() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    when(measurableRatingDao.findByApplicationIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableRatingList);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService, new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3,
            measurableService2, new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Collection<MeasurableRating> actualFindByAppIdSelectorResult = measurableRatingService.findByAppIdSelector(options);

    // Assert
    verify(measurableRatingDao).findByApplicationIdSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindByAppIdSelectorResult instanceof List);
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
    assertSame(measurableRatingList, actualFindByAppIdSelectorResult);
  }

  /**
   * Method under test: {@link MeasurableRatingService#findByCategory(long)}
   */
  @Test
  void testFindByCategory() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    when(measurableRatingDao.findByCategory(anyLong())).thenReturn(measurableRatingList);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    Collection<MeasurableRating> actualFindByCategoryResult = (new MeasurableRatingService(measurableRatingDao,
        measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver,
        measurableService, applicationService, new MeasurableCategoryService(measurableCategoryDao2, userRoleService,
            changeLogService3, measurableService2, new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).findByCategory(1L);

    // Assert
    verify(measurableRatingDao).findByCategory(eq(1L));
    assertTrue(actualFindByCategoryResult instanceof List);
    assertTrue(actualFindByCategoryResult.isEmpty());
    assertSame(measurableRatingList, actualFindByCategoryResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#removeForCategory(EntityReference, long, String)}
   */
  @Test
  void testRemoveForCategory() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.removeForCategory(Mockito.<EntityReference>any(), anyLong())).thenReturn(1);
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    when(measurableRatingDao.findForEntity(Mockito.<EntityReference>any())).thenReturn(measurableRatingList);
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    when(measurableCategory.name()).thenReturn("Name");
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.getById(anyLong())).thenReturn(measurableCategory);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    Collection<MeasurableRating> actualRemoveForCategoryResult = (new MeasurableRatingService(measurableRatingDao,
        measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver,
        measurableService, applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).removeForCategory(mock(EntityReference.class), 1L, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(measurableCategoryDao).getById(eq(1L));
    verify(measurableRatingDao).findForEntity(isA(EntityReference.class));
    verify(measurableRatingDao).removeForCategory(isA(EntityReference.class), eq(1L));
    verify(measurableCategory).name();
    assertTrue(actualRemoveForCategoryResult instanceof List);
    assertTrue(actualRemoveForCategoryResult.isEmpty());
    assertSame(measurableRatingList, actualRemoveForCategoryResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#removeForCategory(EntityReference, long, String)}
   */
  @Test
  void testRemoveForCategory2() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.removeForCategory(Mockito.<EntityReference>any(), anyLong())).thenReturn(1);
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    when(measurableRatingDao.findForEntity(Mockito.<EntityReference>any())).thenReturn(measurableRatingList);
    MeasurableCategory measurableCategory = mock(MeasurableCategory.class);
    when(measurableCategory.name()).thenReturn("Name");
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    when(measurableCategoryDao.getById(anyLong())).thenReturn(measurableCategory);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    Collection<MeasurableRating> actualRemoveForCategoryResult = (new MeasurableRatingService(measurableRatingDao,
        measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver,
        measurableService, applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).removeForCategory(mock(EntityReference.class), 1L, "janedoe");

    // Assert
    verify(measurableCategoryDao).getById(eq(1L));
    verify(measurableRatingDao).findForEntity(isA(EntityReference.class));
    verify(measurableRatingDao).removeForCategory(isA(EntityReference.class), eq(1L));
    verify(measurableCategory).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveForCategoryResult instanceof List);
    assertTrue(actualRemoveForCategoryResult.isEmpty());
    assertSame(measurableRatingList, actualRemoveForCategoryResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#remove(RemoveMeasurableRatingCommand)}
   */
  @Test
  void testRemove() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    ArrayList<MeasurableRating> measurableRatingList = new ArrayList<>();
    when(measurableRatingDao.findForEntity(Mockito.<EntityReference>any())).thenReturn(measurableRatingList);
    when(measurableRatingDao.remove(Mockito.<RemoveMeasurableRatingCommand>any())).thenReturn(true);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.getById(anyLong())).thenReturn(null);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService, new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3,
            measurableService2, new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class));
    RemoveMeasurableRatingCommand command = mock(RemoveMeasurableRatingCommand.class);
    when(command.measurableId()).thenReturn(1L);
    when(command.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Collection<MeasurableRating> actualRemoveResult = measurableRatingService.remove(command);

    // Assert
    verify(measurableDao).getById(eq(1L));
    verify(measurableRatingDao).findForEntity(isA(EntityReference.class));
    verify(measurableRatingDao).remove(isA(RemoveMeasurableRatingCommand.class));
    verify(command).entityReference();
    verify(command).measurableId();
    assertTrue(actualRemoveResult instanceof List);
    assertTrue(actualRemoveResult.isEmpty());
    assertSame(measurableRatingList, actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#deleteByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteByMeasurableIdSelector() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.deleteByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteByMeasurableIdSelectorResult = measurableRatingService
        .deleteByMeasurableIdSelector(selectionOptions);

    // Assert
    verify(measurableRatingDao).deleteByMeasurableIdSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#deleteByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteByMeasurableIdSelector2() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.deleteByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteByMeasurableIdSelectorResult = measurableRatingService
        .deleteByMeasurableIdSelector(selectionOptions);

    // Assert
    verify(measurableRatingDao).deleteByMeasurableIdSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#deleteByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteByMeasurableIdSelector3() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.deleteByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.AGGREGATE_OVERLAY_DIAGRAM);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteByMeasurableIdSelectorResult = measurableRatingService
        .deleteByMeasurableIdSelector(selectionOptions);

    // Assert
    verify(measurableRatingDao).deleteByMeasurableIdSelector(isNull());
    verify(entityReference).kind();
    verify(selectionOptions).entityReference();
    assertEquals(1, actualDeleteByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#deleteByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteByMeasurableIdSelector4() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.deleteByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(selectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteByMeasurableIdSelectorResult = measurableRatingService
        .deleteByMeasurableIdSelector(selectionOptions);

    // Assert
    verify(measurableRatingDao).deleteByMeasurableIdSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions, atLeast(1)).filters();
    verify(selectionOptions).joiningEntityKind();
    verify(selectionOptions, atLeast(1)).scope();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertEquals(1, actualDeleteByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#deleteByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteByMeasurableIdSelector5() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.deleteByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteByMeasurableIdSelectorResult = measurableRatingService
        .deleteByMeasurableIdSelector(selectionOptions);

    // Assert
    verify(measurableRatingDao).deleteByMeasurableIdSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#deleteByMeasurableIdSelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteByMeasurableIdSelector6() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.deleteByMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(1);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.PARENTS);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteByMeasurableIdSelectorResult = measurableRatingService
        .deleteByMeasurableIdSelector(selectionOptions);

    // Assert
    verify(measurableRatingDao).deleteByMeasurableIdSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByMeasurableIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#saveRatingIsPrimary(EntityReference, long, boolean, String)}
   */
  @Test
  void testSaveRatingIsPrimary() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.saveRatingIsPrimary(Mockito.<EntityReference>any(), anyLong(), anyBoolean(),
        Mockito.<String>any())).thenReturn(false);
    when(measurableRatingDao.resolveLoggingContextForRatingChange(Mockito.<EntityReference>any(), anyLong(),
        Mockito.<String>any())).thenReturn(null);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    boolean actualSaveRatingIsPrimaryResult = (new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).saveRatingIsPrimary(null, 1L, true, "janedoe");

    // Assert
    verify(measurableRatingDao).resolveLoggingContextForRatingChange(isNull(), eq(1L), isNull());
    verify(measurableRatingDao).saveRatingIsPrimary(isNull(), eq(1L), eq(true), eq("janedoe"));
    assertFalse(actualSaveRatingIsPrimaryResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#saveRatingDescription(EntityReference, long, String, String)}
   */
  @Test
  void testSaveRatingDescription() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.saveRatingDescription(Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(false);
    when(measurableRatingDao.resolveLoggingContextForRatingChange(Mockito.<EntityReference>any(), anyLong(),
        Mockito.<String>any())).thenReturn(null);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    boolean actualSaveRatingDescriptionResult = (new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).saveRatingDescription(null, 1L, "The characteristics of someone or something",
            "janedoe");

    // Assert
    verify(measurableRatingDao).resolveLoggingContextForRatingChange(isNull(), eq(1L), isNull());
    verify(measurableRatingDao).saveRatingDescription(isNull(), eq(1L),
        eq("The characteristics of someone or something"), eq("janedoe"));
    assertFalse(actualSaveRatingDescriptionResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#tallyByMeasurableCategoryId(long)}
   */
  @Test
  void testTallyByMeasurableCategoryId() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    ArrayList<Tally<Long>> tallyList = new ArrayList<>();
    when(measurableRatingDao.tallyByMeasurableCategoryId(anyLong())).thenReturn(tallyList);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    List<Tally<Long>> actualTallyByMeasurableCategoryIdResult = (new MeasurableRatingService(measurableRatingDao,
        measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver,
        measurableService, applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).tallyByMeasurableCategoryId(1L);

    // Assert
    verify(measurableRatingDao).tallyByMeasurableCategoryId(eq(1L));
    assertTrue(actualTallyByMeasurableCategoryIdResult.isEmpty());
    assertSame(tallyList, actualTallyByMeasurableCategoryIdResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#statsByAppSelector(MeasurableRatingStatParams)}
   */
  @Test
  void testStatsByAppSelector() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    ArrayList<MeasurableRatingTally> measurableRatingTallyList = new ArrayList<>();
    when(measurableRatingDao.statsByMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyBoolean()))
        .thenReturn(measurableRatingTallyList);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    MeasurableRatingStatParams params = mock(MeasurableRatingStatParams.class);
    when(params.showPrimaryOnly()).thenReturn(true);
    when(params.options()).thenReturn(idSelectionOptions);

    // Act
    List<MeasurableRatingTally> actualStatsByAppSelectorResult = measurableRatingService.statsByAppSelector(params);

    // Assert
    verify(measurableRatingDao).statsByMeasurableRatingIdSelector(isA(Select.class), eq(true));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    verify(params).options();
    verify(params).showPrimaryOnly();
    assertTrue(actualStatsByAppSelectorResult.isEmpty());
    assertSame(measurableRatingTallyList, actualStatsByAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#statsByAppSelector(MeasurableRatingStatParams)}
   */
  @Test
  void testStatsByAppSelector2() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    ArrayList<MeasurableRatingTally> measurableRatingTallyList = new ArrayList<>();
    when(measurableRatingDao.statsByMeasurableRatingIdSelector(Mockito.<Select<Record1<Long>>>any(), anyBoolean()))
        .thenReturn(measurableRatingTallyList);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(idSelectionOptions.joiningEntityKind()).thenReturn(ofResult);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    MeasurableRatingStatParams params = mock(MeasurableRatingStatParams.class);
    when(params.showPrimaryOnly()).thenReturn(true);
    when(params.options()).thenReturn(idSelectionOptions);

    // Act
    List<MeasurableRatingTally> actualStatsByAppSelectorResult = measurableRatingService.statsByAppSelector(params);

    // Assert
    verify(measurableRatingDao).statsByMeasurableRatingIdSelector(isA(Select.class), eq(true));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).filters();
    verify(idSelectionOptions).joiningEntityKind();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    verify(params).options();
    verify(params).showPrimaryOnly();
    assertTrue(actualStatsByAppSelectorResult.isEmpty());
    assertSame(measurableRatingTallyList, actualStatsByAppSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#hasMeasurableRatings(IdSelectionOptions)}
   */
  @Test
  void testHasMeasurableRatings() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.hasMeasurableRatings(Mockito.<Select<Record1<Long>>>any())).thenReturn(true);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    boolean actualHasMeasurableRatingsResult = measurableRatingService.hasMeasurableRatings(options);

    // Assert
    verify(measurableRatingDao).hasMeasurableRatings(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualHasMeasurableRatingsResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#hasMeasurableRatings(IdSelectionOptions)}
   */
  @Test
  void testHasMeasurableRatings2() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.hasMeasurableRatings(Mockito.<Select<Record1<Long>>>any())).thenReturn(false);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    boolean actualHasMeasurableRatingsResult = measurableRatingService.hasMeasurableRatings(options);

    // Assert
    verify(measurableRatingDao).hasMeasurableRatings(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertFalse(actualHasMeasurableRatingsResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#hasMeasurableRatings(IdSelectionOptions)}
   */
  @Test
  void testHasMeasurableRatings3() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.hasMeasurableRatings(Mockito.<Select<Record1<Long>>>any())).thenReturn(true);
    MeasurableRatingService measurableRatingService = new MeasurableRatingService(measurableRatingDao,
        mock(MeasurableDao.class), mock(MeasurableCategoryDao.class), mock(ChangeLogService.class),
        mock(RatingSchemeService.class), mock(EntityReferenceNameResolver.class), mock(MeasurableService.class),
        mock(ApplicationService.class), mock(MeasurableCategoryService.class), mock(ApplicationDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    Optional<EntityKind> ofResult = Optional.of(EntityKind.ALL);
    when(options.joiningEntityKind()).thenReturn(ofResult);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    boolean actualHasMeasurableRatingsResult = measurableRatingService.hasMeasurableRatings(options);

    // Assert
    verify(measurableRatingDao).hasMeasurableRatings(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options, atLeast(1)).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).joiningEntityKind();
    verify(options, atLeast(1)).scope();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualHasMeasurableRatingsResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#getRequiredRatingEditRole(EntityReference)}
   */
  @Test
  void testGetRequiredRatingEditRole() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    when(measurableDao.getRequiredRatingEditRole(Mockito.<EntityReference>any()))
        .thenReturn("Required Rating Edit Role");
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    String actualRequiredRatingEditRole = (new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).getRequiredRatingEditRole(null);

    // Assert
    verify(measurableDao).getRequiredRatingEditRole(isNull());
    assertEquals("Required Rating Edit Role", actualRequiredRatingEditRole);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#checkRatingExists(SaveMeasurableRatingCommand)}
   */
  @Test
  void testCheckRatingExists() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.checkRatingExists(Mockito.<SaveMeasurableRatingCommand>any())).thenReturn(true);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    boolean actualCheckRatingExistsResult = (new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService, new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3,
            measurableService2, new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).checkRatingExists(null);

    // Assert
    verify(measurableRatingDao).checkRatingExists(isNull());
    assertTrue(actualCheckRatingExistsResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#checkRatingExists(SaveMeasurableRatingCommand)}
   */
  @Test
  void testCheckRatingExists2() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.checkRatingExists(Mockito.<SaveMeasurableRatingCommand>any())).thenReturn(false);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    boolean actualCheckRatingExistsResult = (new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService, new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3,
            measurableService2, new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).checkRatingExists(null);

    // Assert
    verify(measurableRatingDao).checkRatingExists(isNull());
    assertFalse(actualCheckRatingExistsResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#migrateRatings(Long, Long, String)}
   */
  @Test
  void testMigrateRatings() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    doNothing().when(measurableRatingDao)
        .migrateRatings(Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<String>any());
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    (new MeasurableRatingService(measurableRatingDao, measurableDao, measurableCategoryDao, changeLogService,
        ratingSchemeService, entityReferenceNameResolver, measurableService, applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).migrateRatings(1L, 1L, "42");

    // Assert
    verify(measurableRatingDao).migrateRatings(eq(1L), eq(1L), eq("42"));
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#getSharedRatingsCount(Long, Long)}
   */
  @Test
  void testGetSharedRatingsCount() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.getSharedRatingsCount(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(3);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    int actualSharedRatingsCount = (new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).getSharedRatingsCount(1L, 1L);

    // Assert
    verify(measurableRatingDao).getSharedRatingsCount(eq(1L), eq(1L));
    assertEquals(3, actualSharedRatingsCount);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#getSharedRatingsCount(Long, Long)}
   */
  @Test
  void testGetSharedRatingsCount2() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.getSharedRatingsCount(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(3);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    int actualSharedRatingsCount = (new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).getSharedRatingsCount(2L, 1L);

    // Assert
    verify(measurableRatingDao).getSharedRatingsCount(eq(2L), eq(1L));
    assertEquals(3, actualSharedRatingsCount);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#getSharedRatingsCount(Long, Long)}
   */
  @Test
  void testGetSharedRatingsCount3() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.getSharedRatingsCount(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(3);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    int actualSharedRatingsCount = (new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).getSharedRatingsCount(3L, 1L);

    // Assert
    verify(measurableRatingDao).getSharedRatingsCount(eq(3L), eq(1L));
    assertEquals(3, actualSharedRatingsCount);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#getSharedRatingsCount(Long, Long)}
   */
  @Test
  void testGetSharedRatingsCount4() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.getSharedRatingsCount(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(3);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    int actualSharedRatingsCount = (new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).getSharedRatingsCount(4L, 1L);

    // Assert
    verify(measurableRatingDao).getSharedRatingsCount(eq(4L), eq(1L));
    assertEquals(3, actualSharedRatingsCount);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#getSharedDecommsCount(Long, Long)}
   */
  @Test
  void testGetSharedDecommsCount() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.getSharedDecommsCount(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(3);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    int actualSharedDecommsCount = (new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).getSharedDecommsCount(1L, 1L);

    // Assert
    verify(measurableRatingDao).getSharedDecommsCount(eq(1L), eq(1L));
    assertEquals(3, actualSharedDecommsCount);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#getSharedDecommsCount(Long, Long)}
   */
  @Test
  void testGetSharedDecommsCount2() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.getSharedDecommsCount(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(3);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    int actualSharedDecommsCount = (new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).getSharedDecommsCount(2L, 1L);

    // Assert
    verify(measurableRatingDao).getSharedDecommsCount(eq(2L), eq(1L));
    assertEquals(3, actualSharedDecommsCount);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#getSharedDecommsCount(Long, Long)}
   */
  @Test
  void testGetSharedDecommsCount3() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.getSharedDecommsCount(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(3);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    int actualSharedDecommsCount = (new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).getSharedDecommsCount(3L, 1L);

    // Assert
    verify(measurableRatingDao).getSharedDecommsCount(eq(3L), eq(1L));
    assertEquals(3, actualSharedDecommsCount);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#getSharedDecommsCount(Long, Long)}
   */
  @Test
  void testGetSharedDecommsCount4() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    when(measurableRatingDao.getSharedDecommsCount(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(3);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    int actualSharedDecommsCount = (new MeasurableRatingService(measurableRatingDao, measurableDao,
        measurableCategoryDao, changeLogService, ratingSchemeService, entityReferenceNameResolver, measurableService,
        applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).getSharedDecommsCount(4L, 1L);

    // Assert
    verify(measurableRatingDao).getSharedDecommsCount(eq(4L), eq(1L));
    assertEquals(3, actualSharedDecommsCount);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#findPrimaryRatingsForGenericSelector(GenericSelector)}
   */
  @Test
  void testFindPrimaryRatingsForGenericSelector() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    HashSet<MeasurableRating> measurableRatingSet = new HashSet<>();
    when(measurableRatingDao.findPrimaryRatingsForGenericSelector(Mockito.<GenericSelector>any()))
        .thenReturn(measurableRatingSet);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    Set<MeasurableRating> actualFindPrimaryRatingsForGenericSelectorResult = (new MeasurableRatingService(
        measurableRatingDao, measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService,
        entityReferenceNameResolver, measurableService, applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).findPrimaryRatingsForGenericSelector(null);

    // Assert
    verify(measurableRatingDao).findPrimaryRatingsForGenericSelector(isNull());
    assertTrue(actualFindPrimaryRatingsForGenericSelectorResult.isEmpty());
    assertSame(measurableRatingSet, actualFindPrimaryRatingsForGenericSelectorResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRatingService#findPrimaryRatingsForMeasurableIdSelector(Select)}
   */
  @Test
  void testFindPrimaryRatingsForMeasurableIdSelector() {
    // Arrange
    MeasurableRatingDao measurableRatingDao = mock(MeasurableRatingDao.class);
    HashSet<MeasurableRating> measurableRatingSet = new HashSet<>();
    when(measurableRatingDao.findPrimaryRatingsForMeasurableIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(measurableRatingSet);
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao2, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    MeasurableCategoryDao measurableCategoryDao2 = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService2,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao3, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);

    // Act
    Set<MeasurableRating> actualFindPrimaryRatingsForMeasurableIdSelectorResult = (new MeasurableRatingService(
        measurableRatingDao, measurableDao, measurableCategoryDao, changeLogService, ratingSchemeService,
        entityReferenceNameResolver, measurableService, applicationService,
        new MeasurableCategoryService(measurableCategoryDao2, userRoleService, changeLogService3, measurableService2,
            new SettingsService(settingsDao2, new ArrayList<>())),
        mock(ApplicationDao.class))).findPrimaryRatingsForMeasurableIdSelector(mock(Select.class));

    // Assert
    verify(measurableRatingDao).findPrimaryRatingsForMeasurableIdSelector(isA(Select.class));
    assertTrue(actualFindPrimaryRatingsForMeasurableIdSelectorResult.isEmpty());
    assertSame(measurableRatingSet, actualFindPrimaryRatingsForMeasurableIdSelectorResult);
  }
}
