package org.finos.waltz.service.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import java.util.Map;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.application.search.ApplicationSearchDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.entity_alias.EntityAliasDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.AppRegistrationRequest;
import org.finos.waltz.model.application.AppRegistrationResponse;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.AssetCodeRelationshipKind;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.tag.Tag;
import org.finos.waltz.model.tally.Tally;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.tag.TagService;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ApplicationServiceDiffblueTest {
  /**
   * Method under test: {@link ApplicationService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.getById(anyLong())).thenReturn(null);
    TagDao tagDao = mock(TagDao.class);

    // Act
    Application actualById = (new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class))).getById(1L);

    // Assert
    verify(appDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link ApplicationService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    ArrayList<Application> applicationList = new ArrayList<>();
    when(appDao.findAll()).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);

    // Act
    List<Application> actualFindAllResult = (new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class))).findAll();

    // Assert
    verify(appDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(applicationList, actualFindAllResult);
  }

  /**
   * Method under test: {@link ApplicationService#countByOrganisationalUnit()}
   */
  @Test
  void testCountByOrganisationalUnit() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    ArrayList<Tally<Long>> tallyList = new ArrayList<>();
    when(appDao.countByOrganisationalUnit()).thenReturn(tallyList);
    TagDao tagDao = mock(TagDao.class);

    // Act
    List<Tally<Long>> actualCountByOrganisationalUnitResult = (new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class))).countByOrganisationalUnit();

    // Assert
    verify(appDao).countByOrganisationalUnit();
    assertTrue(actualCountByOrganisationalUnitResult.isEmpty());
    assertSame(tallyList, actualCountByOrganisationalUnitResult);
  }

  /**
   * Method under test: {@link ApplicationService#search(String)}
   */
  @Test
  void testSearch() {
    // Arrange
    ApplicationSearchDao appSearchDao = mock(ApplicationSearchDao.class);
    ArrayList<Application> applicationList = new ArrayList<>();
    when(appSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(applicationList);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);

    // Act
    List<Application> actualSearchResult = (new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), appSearchDao)).search("Query");

    // Assert
    verify(appSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult.isEmpty());
    assertSame(applicationList, actualSearchResult);
  }

  /**
   * Method under test: {@link ApplicationService#search(String)}
   */
  @Test
  void testSearch2() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);

    // Act and Assert
    assertTrue(
        (new ApplicationService(appDao,
            new TagService(tagDao, new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
            mock(EntityAliasDao.class), mock(ApplicationSearchDao.class))).search("").isEmpty());
  }

  /**
   * Method under test: {@link ApplicationService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch3() {
    // Arrange
    ApplicationSearchDao appSearchDao = mock(ApplicationSearchDao.class);
    ArrayList<Application> applicationList = new ArrayList<>();
    when(appSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(applicationList);
    ApplicationDao appDao = mock(ApplicationDao.class);
    TagDao tagDao = mock(TagDao.class);

    // Act
    List<Application> actualSearchResult = (new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), appSearchDao)).search((EntitySearchOptions) null);

    // Assert
    verify(appSearchDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
    assertSame(applicationList, actualSearchResult);
  }

  /**
   * Method under test: {@link ApplicationService#findByIds(Collection)}
   */
  @Test
  void testFindByIds() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    ArrayList<Application> applicationList = new ArrayList<>();
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    // Act
    List<Application> actualFindByIdsResult = applicationService.findByIds(new ArrayList<>());

    // Assert
    verify(appDao).findByIds(isA(Collection.class));
    assertTrue(actualFindByIdsResult.isEmpty());
    assertSame(applicationList, actualFindByIdsResult);
  }

  /**
   * Method under test: {@link ApplicationService#findByIds(Collection)}
   */
  @Test
  void testFindByIds2() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    ArrayList<Application> applicationList = new ArrayList<>();
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    List<Application> actualFindByIdsResult = applicationService.findByIds(ids);

    // Assert
    verify(appDao).findByIds(isA(Collection.class));
    assertTrue(actualFindByIdsResult.isEmpty());
    assertSame(applicationList, actualFindByIdsResult);
  }

  /**
   * Method under test: {@link ApplicationService#findByIds(Collection)}
   */
  @Test
  void testFindByIds3() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    ArrayList<Application> applicationList = new ArrayList<>();
    when(appDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    List<Application> actualFindByIdsResult = applicationService.findByIds(ids);

    // Assert
    verify(appDao).findByIds(isA(Collection.class));
    assertTrue(actualFindByIdsResult.isEmpty());
    assertSame(applicationList, actualFindByIdsResult);
  }

  /**
   * Method under test:
   * {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByAppIdSelector() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    ArrayList<Application> applicationList = new ArrayList<>();
    when(appDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Application> actualFindByAppIdSelectorResult = applicationService.findByAppIdSelector(options);

    // Assert
    verify(appDao).findByAppIdSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
    assertSame(applicationList, actualFindByAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByAppIdSelector2() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    ArrayList<Application> applicationList = new ArrayList<>();
    when(appDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Application> actualFindByAppIdSelectorResult = applicationService.findByAppIdSelector(options);

    // Assert
    verify(appDao).findByAppIdSelector(isA(Select.class));
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
    assertSame(applicationList, actualFindByAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByAppIdSelector3() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    ArrayList<Application> applicationList = new ArrayList<>();
    when(appDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Application> actualFindByAppIdSelectorResult = applicationService.findByAppIdSelector(options);

    // Assert
    verify(appDao).findByAppIdSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
    assertSame(applicationList, actualFindByAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByAppIdSelector4() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    ArrayList<Application> applicationList = new ArrayList<>();
    when(appDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Application> actualFindByAppIdSelectorResult = applicationService.findByAppIdSelector(options);

    // Assert
    verify(appDao).findByAppIdSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
    assertSame(applicationList, actualFindByAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByAppIdSelector5() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    ArrayList<Application> applicationList = new ArrayList<>();
    when(appDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Application> actualFindByAppIdSelectorResult = applicationService.findByAppIdSelector(options);

    // Assert
    verify(appDao).findByAppIdSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
    assertSame(applicationList, actualFindByAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByAppIdSelector6() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    ArrayList<Application> applicationList = new ArrayList<>();
    when(appDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    List<Application> actualFindByAppIdSelectorResult = applicationService.findByAppIdSelector(options);

    // Assert
    verify(appDao).findByAppIdSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
    assertSame(applicationList, actualFindByAppIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link ApplicationService#registerApp(AppRegistrationRequest, String)}
   */
  @Test
  void testRegisterApp() {
    // Arrange
    AppRegistrationResponse appRegistrationResponse = mock(AppRegistrationResponse.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appRegistrationResponse.id()).thenReturn(ofResult);
    when(appRegistrationResponse.registered()).thenReturn(true);
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.registerApp(Mockito.<AppRegistrationRequest>any())).thenReturn(appRegistrationResponse);
    TagDao tagDao = mock(TagDao.class);
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(new ArrayList<>());
    TagService tagService = new TagService(tagDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    EntityAliasDao entityAliasDao = mock(EntityAliasDao.class);
    when(entityAliasDao.updateAliases(Mockito.<EntityReference>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    ApplicationService applicationService = new ApplicationService(appDao, tagService, entityAliasDao,
        mock(ApplicationSearchDao.class));
    AppRegistrationRequest request = mock(AppRegistrationRequest.class);
    when(request.aliases()).thenReturn(new HashSet<>());
    when(request.tags()).thenReturn(new HashSet<>());
    when(request.name()).thenReturn("Name");

    // Act
    applicationService.registerApp(request, "janedoe");

    // Assert
    verify(appDao).registerApp(isA(AppRegistrationRequest.class));
    verify(entityAliasDao).updateAliases(isA(EntityReference.class), isA(Collection.class));
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isA(EntityReference.class));
    verify(request).name();
    verify(request).aliases();
    verify(request).tags();
    verify(appRegistrationResponse).id();
    verify(appRegistrationResponse).registered();
  }

  /**
   * Method under test:
   * {@link ApplicationService#registerApp(AppRegistrationRequest, String)}
   */
  @Test
  void testRegisterApp2() {
    // Arrange
    AppRegistrationResponse appRegistrationResponse = mock(AppRegistrationResponse.class);
    when(appRegistrationResponse.registered()).thenReturn(false);
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.registerApp(Mockito.<AppRegistrationRequest>any())).thenReturn(appRegistrationResponse);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));
    AppRegistrationRequest request = mock(AppRegistrationRequest.class);
    when(request.name()).thenReturn("Name");

    // Act
    applicationService.registerApp(request, "janedoe");

    // Assert
    verify(appDao).registerApp(isA(AppRegistrationRequest.class));
    verify(request).name();
    verify(appRegistrationResponse).registered();
  }

  /**
   * Method under test:
   * {@link ApplicationService#registerApp(AppRegistrationRequest, String)}
   */
  @Test
  void testRegisterApp3() {
    // Arrange
    AppRegistrationResponse appRegistrationResponse = mock(AppRegistrationResponse.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(appRegistrationResponse.id()).thenReturn(ofResult);
    when(appRegistrationResponse.registered()).thenReturn(true);
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.registerApp(Mockito.<AppRegistrationRequest>any())).thenReturn(appRegistrationResponse);
    Tag tag = mock(Tag.class);
    when(tag.name()).thenReturn("Name");

    ArrayList<Tag> tagList = new ArrayList<>();
    tagList.add(tag);
    TagDao tagDao = mock(TagDao.class);
    doNothing().when(tagDao).removeTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);
    TagService tagService = new TagService(tagDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    EntityAliasDao entityAliasDao = mock(EntityAliasDao.class);
    when(entityAliasDao.updateAliases(Mockito.<EntityReference>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    ApplicationService applicationService = new ApplicationService(appDao, tagService, entityAliasDao,
        mock(ApplicationSearchDao.class));
    AppRegistrationRequest request = mock(AppRegistrationRequest.class);
    when(request.aliases()).thenReturn(new HashSet<>());
    when(request.tags()).thenReturn(new HashSet<>());
    when(request.name()).thenReturn("Name");

    // Act
    applicationService.registerApp(request, "janedoe");

    // Assert
    verify(appDao).registerApp(isA(AppRegistrationRequest.class));
    verify(entityAliasDao).updateAliases(isA(EntityReference.class), isA(Collection.class));
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isA(EntityReference.class));
    verify(tagDao).removeTagUsage(isA(EntityReference.class), eq("Name"));
    verify(request).name();
    verify(tag).name();
    verify(request).aliases();
    verify(request).tags();
    verify(appRegistrationResponse).id();
    verify(appRegistrationResponse).registered();
  }

  /**
   * Method under test: {@link ApplicationService#update(Application)}
   */
  @Test
  void testUpdate() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.update(Mockito.<Application>any())).thenReturn(1);
    TagDao tagDao = mock(TagDao.class);

    // Act
    Integer actualUpdateResult = (new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class))).update(null);

    // Assert
    verify(appDao).update(isNull());
    assertEquals(1, actualUpdateResult.intValue());
  }

  /**
   * Method under test: {@link ApplicationService#findRelated(long)}
   */
  @Test
  void testFindRelated() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findRelatedByApplicationId(anyLong())).thenReturn(new ArrayList<>());
    TagDao tagDao = mock(TagDao.class);

    // Act
    Map<AssetCodeRelationshipKind, List<Application>> actualFindRelatedResult = (new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class))).findRelated(1L);

    // Assert
    verify(appDao).findRelatedByApplicationId(eq(1L));
    assertTrue(actualFindRelatedResult.isEmpty());
  }

  /**
   * Method under test: {@link ApplicationService#findRelated(long)}
   */
  @Test
  void testFindRelated2() {
    // Arrange
    Application application = mock(Application.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult);

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application);
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findRelatedByApplicationId(anyLong())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);

    // Act
    Map<AssetCodeRelationshipKind, List<Application>> actualFindRelatedResult = (new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class))).findRelated(1L);

    // Assert
    verify(appDao).findRelatedByApplicationId(eq(1L));
    verify(application).id();
    assertTrue(actualFindRelatedResult.isEmpty());
  }

  /**
   * Method under test: {@link ApplicationService#findRelated(long)}
   */
  @Test
  void testFindRelated3() {
    // Arrange
    Application application = mock(Application.class);
    Optional<ExternalIdValue> ofResult = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult);
    Optional<ExternalIdValue> ofResult2 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult3);
    Application application2 = mock(Application.class);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(application2.id()).thenReturn(ofResult4);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(application2.assetCode()).thenReturn(ofResult5);
    Optional<ExternalIdValue> ofResult6 = Optional.of(ExternalIdValue.of("42"));
    when(application2.parentAssetCode()).thenReturn(ofResult6);

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application2);
    applicationList.add(application);
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findRelatedByApplicationId(anyLong())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);

    // Act
    Map<AssetCodeRelationshipKind, List<Application>> actualFindRelatedResult = (new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class))).findRelated(1L);

    // Assert
    verify(appDao).findRelatedByApplicationId(eq(1L));
    verify(application2).id();
    verify(application2, atLeast(1)).assetCode();
    verify(application, atLeast(1)).assetCode();
    verify(application2, atLeast(1)).parentAssetCode();
    verify(application, atLeast(1)).parentAssetCode();
    assertEquals(1, actualFindRelatedResult.size());
    assertEquals(1, actualFindRelatedResult.get(AssetCodeRelationshipKind.SHARING).size());
  }

  /**
   * Method under test: {@link ApplicationService#findRelated(long)}
   */
  @Test
  void testFindRelated4() {
    // Arrange
    Application application = mock(Application.class);
    Optional<ExternalIdValue> ofResult = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult);
    Optional<ExternalIdValue> ofResult2 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult3);
    Application application2 = mock(Application.class);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(application2.id()).thenReturn(ofResult4);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(application2.assetCode()).thenReturn(ofResult5);
    Optional<ExternalIdValue> ofResult6 = Optional.of(ExternalIdValue.of("42"));
    when(application2.parentAssetCode()).thenReturn(ofResult6);
    Application application3 = mock(Application.class);
    Optional<Long> ofResult7 = Optional.<Long>of(1L);
    when(application3.id()).thenReturn(ofResult7);
    Optional<ExternalIdValue> ofResult8 = Optional.of(ExternalIdValue.of("42"));
    when(application3.assetCode()).thenReturn(ofResult8);
    Optional<ExternalIdValue> ofResult9 = Optional.of(ExternalIdValue.of("42"));
    when(application3.parentAssetCode()).thenReturn(ofResult9);
    Application application4 = mock(Application.class);
    Optional<Long> ofResult10 = Optional.<Long>of(1L);
    when(application4.id()).thenReturn(ofResult10);
    Optional<ExternalIdValue> ofResult11 = Optional.of(ExternalIdValue.of("42"));
    when(application4.assetCode()).thenReturn(ofResult11);
    Optional<ExternalIdValue> ofResult12 = Optional.of(ExternalIdValue.of("42"));
    when(application4.parentAssetCode()).thenReturn(ofResult12);
    Application application5 = mock(Application.class);
    Optional<Long> ofResult13 = Optional.<Long>of(1L);
    when(application5.id()).thenReturn(ofResult13);
    Optional<ExternalIdValue> ofResult14 = Optional.of(ExternalIdValue.of("42"));
    when(application5.assetCode()).thenReturn(ofResult14);
    Optional<ExternalIdValue> ofResult15 = Optional.of(ExternalIdValue.of("42"));
    when(application5.parentAssetCode()).thenReturn(ofResult15);
    Application application6 = mock(Application.class);
    Optional<Long> ofResult16 = Optional.<Long>of(1L);
    when(application6.id()).thenReturn(ofResult16);
    Optional<ExternalIdValue> ofResult17 = Optional.of(ExternalIdValue.of("42"));
    when(application6.assetCode()).thenReturn(ofResult17);
    Optional<ExternalIdValue> ofResult18 = Optional.of(ExternalIdValue.of("42"));
    when(application6.parentAssetCode()).thenReturn(ofResult18);
    Application application7 = mock(Application.class);
    Optional<Long> ofResult19 = Optional.<Long>of(1L);
    when(application7.id()).thenReturn(ofResult19);
    Optional<ExternalIdValue> ofResult20 = Optional.of(ExternalIdValue.of("42"));
    when(application7.assetCode()).thenReturn(ofResult20);
    Optional<ExternalIdValue> ofResult21 = Optional.of(ExternalIdValue.of("42"));
    when(application7.parentAssetCode()).thenReturn(ofResult21);
    Application application8 = mock(Application.class);
    Optional<Long> ofResult22 = Optional.<Long>of(1L);
    when(application8.id()).thenReturn(ofResult22);
    Optional<ExternalIdValue> ofResult23 = Optional.of(ExternalIdValue.of("42"));
    when(application8.assetCode()).thenReturn(ofResult23);
    Optional<ExternalIdValue> ofResult24 = Optional.of(ExternalIdValue.of("42"));
    when(application8.parentAssetCode()).thenReturn(ofResult24);
    Application application9 = mock(Application.class);
    Optional<Long> ofResult25 = Optional.<Long>of(1L);
    when(application9.id()).thenReturn(ofResult25);
    Optional<ExternalIdValue> ofResult26 = Optional.of(ExternalIdValue.of("42"));
    when(application9.assetCode()).thenReturn(ofResult26);
    Optional<ExternalIdValue> ofResult27 = Optional.of(ExternalIdValue.of("42"));
    when(application9.parentAssetCode()).thenReturn(ofResult27);
    Application application10 = mock(Application.class);
    Optional<Long> ofResult28 = Optional.<Long>of(1L);
    when(application10.id()).thenReturn(ofResult28);
    Optional<ExternalIdValue> ofResult29 = Optional.of(ExternalIdValue.of("42"));
    when(application10.assetCode()).thenReturn(ofResult29);
    Optional<ExternalIdValue> ofResult30 = Optional.of(ExternalIdValue.of("42"));
    when(application10.parentAssetCode()).thenReturn(ofResult30);
    Application application11 = mock(Application.class);
    Optional<Long> ofResult31 = Optional.<Long>of(1L);
    when(application11.id()).thenReturn(ofResult31);
    Optional<ExternalIdValue> ofResult32 = Optional.of(ExternalIdValue.of("42"));
    when(application11.assetCode()).thenReturn(ofResult32);
    Optional<ExternalIdValue> ofResult33 = Optional.of(ExternalIdValue.of("42"));
    when(application11.parentAssetCode()).thenReturn(ofResult33);
    Application application12 = mock(Application.class);
    Optional<Long> ofResult34 = Optional.<Long>of(1L);
    when(application12.id()).thenReturn(ofResult34);
    Optional<ExternalIdValue> ofResult35 = Optional.of(ExternalIdValue.of("42"));
    when(application12.assetCode()).thenReturn(ofResult35);
    Optional<ExternalIdValue> ofResult36 = Optional.of(ExternalIdValue.of("42"));
    when(application12.parentAssetCode()).thenReturn(ofResult36);
    Application application13 = mock(Application.class);
    Optional<Long> ofResult37 = Optional.<Long>of(1L);
    when(application13.id()).thenReturn(ofResult37);
    Optional<ExternalIdValue> ofResult38 = Optional.of(ExternalIdValue.of("42"));
    when(application13.assetCode()).thenReturn(ofResult38);
    Optional<ExternalIdValue> ofResult39 = Optional.of(ExternalIdValue.of("42"));
    when(application13.parentAssetCode()).thenReturn(ofResult39);
    Application application14 = mock(Application.class);
    Optional<Long> ofResult40 = Optional.<Long>of(1L);
    when(application14.id()).thenReturn(ofResult40);
    Optional<ExternalIdValue> ofResult41 = Optional.of(ExternalIdValue.of("42"));
    when(application14.assetCode()).thenReturn(ofResult41);
    Optional<ExternalIdValue> ofResult42 = Optional.of(ExternalIdValue.of("42"));
    when(application14.parentAssetCode()).thenReturn(ofResult42);
    Application application15 = mock(Application.class);
    Optional<Long> ofResult43 = Optional.<Long>of(1L);
    when(application15.id()).thenReturn(ofResult43);
    Optional<ExternalIdValue> ofResult44 = Optional.of(ExternalIdValue.of("42"));
    when(application15.assetCode()).thenReturn(ofResult44);
    Optional<ExternalIdValue> ofResult45 = Optional.of(ExternalIdValue.of("42"));
    when(application15.parentAssetCode()).thenReturn(ofResult45);
    Application application16 = mock(Application.class);
    Optional<Long> ofResult46 = Optional.<Long>of(1L);
    when(application16.id()).thenReturn(ofResult46);
    Optional<ExternalIdValue> ofResult47 = Optional.of(ExternalIdValue.of("42"));
    when(application16.assetCode()).thenReturn(ofResult47);
    Optional<ExternalIdValue> ofResult48 = Optional.of(ExternalIdValue.of("42"));
    when(application16.parentAssetCode()).thenReturn(ofResult48);
    Application application17 = mock(Application.class);
    Optional<Long> ofResult49 = Optional.<Long>of(1L);
    when(application17.id()).thenReturn(ofResult49);
    Optional<ExternalIdValue> ofResult50 = Optional.of(ExternalIdValue.of("42"));
    when(application17.assetCode()).thenReturn(ofResult50);
    Optional<ExternalIdValue> ofResult51 = Optional.of(ExternalIdValue.of("42"));
    when(application17.parentAssetCode()).thenReturn(ofResult51);
    Application application18 = mock(Application.class);
    Optional<Long> ofResult52 = Optional.<Long>of(1L);
    when(application18.id()).thenReturn(ofResult52);
    Optional<ExternalIdValue> ofResult53 = Optional.of(ExternalIdValue.of("42"));
    when(application18.assetCode()).thenReturn(ofResult53);
    Optional<ExternalIdValue> ofResult54 = Optional.of(ExternalIdValue.of("42"));
    when(application18.parentAssetCode()).thenReturn(ofResult54);
    Application application19 = mock(Application.class);
    Optional<Long> ofResult55 = Optional.<Long>of(1L);
    when(application19.id()).thenReturn(ofResult55);
    Optional<ExternalIdValue> ofResult56 = Optional.of(ExternalIdValue.of("42"));
    when(application19.assetCode()).thenReturn(ofResult56);
    Optional<ExternalIdValue> ofResult57 = Optional.of(ExternalIdValue.of("42"));
    when(application19.parentAssetCode()).thenReturn(ofResult57);
    Application application20 = mock(Application.class);
    Optional<Long> ofResult58 = Optional.<Long>of(1L);
    when(application20.id()).thenReturn(ofResult58);
    Optional<ExternalIdValue> ofResult59 = Optional.of(ExternalIdValue.of("42"));
    when(application20.assetCode()).thenReturn(ofResult59);
    Optional<ExternalIdValue> ofResult60 = Optional.of(ExternalIdValue.of("42"));
    when(application20.parentAssetCode()).thenReturn(ofResult60);
    Application application21 = mock(Application.class);
    Optional<Long> ofResult61 = Optional.<Long>of(1L);
    when(application21.id()).thenReturn(ofResult61);
    Optional<ExternalIdValue> ofResult62 = Optional.of(ExternalIdValue.of("42"));
    when(application21.assetCode()).thenReturn(ofResult62);
    Optional<ExternalIdValue> ofResult63 = Optional.of(ExternalIdValue.of("42"));
    when(application21.parentAssetCode()).thenReturn(ofResult63);
    Application application22 = mock(Application.class);
    Optional<Long> ofResult64 = Optional.<Long>of(1L);
    when(application22.id()).thenReturn(ofResult64);
    Optional<ExternalIdValue> ofResult65 = Optional.of(ExternalIdValue.of("42"));
    when(application22.assetCode()).thenReturn(ofResult65);
    Optional<ExternalIdValue> ofResult66 = Optional.of(ExternalIdValue.of("42"));
    when(application22.parentAssetCode()).thenReturn(ofResult66);
    Application application23 = mock(Application.class);
    Optional<Long> ofResult67 = Optional.<Long>of(1L);
    when(application23.id()).thenReturn(ofResult67);
    Optional<ExternalIdValue> ofResult68 = Optional.of(ExternalIdValue.of("42"));
    when(application23.assetCode()).thenReturn(ofResult68);
    Optional<ExternalIdValue> ofResult69 = Optional.of(ExternalIdValue.of("42"));
    when(application23.parentAssetCode()).thenReturn(ofResult69);
    Application application24 = mock(Application.class);
    Optional<Long> ofResult70 = Optional.<Long>of(1L);
    when(application24.id()).thenReturn(ofResult70);
    Optional<ExternalIdValue> ofResult71 = Optional.of(ExternalIdValue.of("42"));
    when(application24.assetCode()).thenReturn(ofResult71);
    Optional<ExternalIdValue> ofResult72 = Optional.of(ExternalIdValue.of("42"));
    when(application24.parentAssetCode()).thenReturn(ofResult72);
    Application application25 = mock(Application.class);
    Optional<Long> ofResult73 = Optional.<Long>of(1L);
    when(application25.id()).thenReturn(ofResult73);
    Optional<ExternalIdValue> ofResult74 = Optional.of(ExternalIdValue.of("42"));
    when(application25.assetCode()).thenReturn(ofResult74);
    Optional<ExternalIdValue> ofResult75 = Optional.of(ExternalIdValue.of("42"));
    when(application25.parentAssetCode()).thenReturn(ofResult75);
    Application application26 = mock(Application.class);
    Optional<Long> ofResult76 = Optional.<Long>of(1L);
    when(application26.id()).thenReturn(ofResult76);
    Optional<ExternalIdValue> ofResult77 = Optional.of(ExternalIdValue.of("42"));
    when(application26.assetCode()).thenReturn(ofResult77);
    Optional<ExternalIdValue> ofResult78 = Optional.of(ExternalIdValue.of("42"));
    when(application26.parentAssetCode()).thenReturn(ofResult78);
    Application application27 = mock(Application.class);
    Optional<Long> ofResult79 = Optional.<Long>of(1L);
    when(application27.id()).thenReturn(ofResult79);
    Optional<ExternalIdValue> ofResult80 = Optional.of(ExternalIdValue.of("42"));
    when(application27.assetCode()).thenReturn(ofResult80);
    Optional<ExternalIdValue> ofResult81 = Optional.of(ExternalIdValue.of("42"));
    when(application27.parentAssetCode()).thenReturn(ofResult81);
    Application application28 = mock(Application.class);
    Optional<Long> ofResult82 = Optional.<Long>of(1L);
    when(application28.id()).thenReturn(ofResult82);
    Optional<ExternalIdValue> ofResult83 = Optional.of(ExternalIdValue.of("42"));
    when(application28.assetCode()).thenReturn(ofResult83);
    Optional<ExternalIdValue> ofResult84 = Optional.of(ExternalIdValue.of("42"));
    when(application28.parentAssetCode()).thenReturn(ofResult84);
    Application application29 = mock(Application.class);
    Optional<Long> ofResult85 = Optional.<Long>of(-1L);
    when(application29.id()).thenReturn(ofResult85);
    Optional<ExternalIdValue> ofResult86 = Optional.of(ExternalIdValue.of("42"));
    when(application29.assetCode()).thenReturn(ofResult86);
    Optional<ExternalIdValue> ofResult87 = Optional.of(ExternalIdValue.of("42"));
    when(application29.parentAssetCode()).thenReturn(ofResult87);

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application29);
    applicationList.add(application28);
    applicationList.add(application27);
    applicationList.add(application26);
    applicationList.add(application25);
    applicationList.add(application24);
    applicationList.add(application23);
    applicationList.add(application22);
    applicationList.add(application21);
    applicationList.add(application20);
    applicationList.add(application19);
    applicationList.add(application18);
    applicationList.add(application17);
    applicationList.add(application16);
    applicationList.add(application15);
    applicationList.add(application14);
    applicationList.add(application13);
    applicationList.add(application12);
    applicationList.add(application11);
    applicationList.add(application10);
    applicationList.add(application9);
    applicationList.add(application8);
    applicationList.add(application7);
    applicationList.add(application6);
    applicationList.add(application5);
    applicationList.add(application4);
    applicationList.add(application3);
    applicationList.add(application2);
    applicationList.add(application);
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findRelatedByApplicationId(anyLong())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);

    // Act
    Map<AssetCodeRelationshipKind, List<Application>> actualFindRelatedResult = (new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class))).findRelated(1L);

    // Assert
    verify(appDao).findRelatedByApplicationId(eq(1L));
    verify(application29).id();
    verify(application28).id();
    verify(application29, atLeast(1)).assetCode();
    verify(application27, atLeast(1)).assetCode();
    verify(application26, atLeast(1)).assetCode();
    verify(application25, atLeast(1)).assetCode();
    verify(application24, atLeast(1)).assetCode();
    verify(application23, atLeast(1)).assetCode();
    verify(application22, atLeast(1)).assetCode();
    verify(application21, atLeast(1)).assetCode();
    verify(application20, atLeast(1)).assetCode();
    verify(application19, atLeast(1)).assetCode();
    verify(application18, atLeast(1)).assetCode();
    verify(application17, atLeast(1)).assetCode();
    verify(application16, atLeast(1)).assetCode();
    verify(application15, atLeast(1)).assetCode();
    verify(application14, atLeast(1)).assetCode();
    verify(application13, atLeast(1)).assetCode();
    verify(application12, atLeast(1)).assetCode();
    verify(application11, atLeast(1)).assetCode();
    verify(application10, atLeast(1)).assetCode();
    verify(application9, atLeast(1)).assetCode();
    verify(application8, atLeast(1)).assetCode();
    verify(application7, atLeast(1)).assetCode();
    verify(application6, atLeast(1)).assetCode();
    verify(application5, atLeast(1)).assetCode();
    verify(application4, atLeast(1)).assetCode();
    verify(application3, atLeast(1)).assetCode();
    verify(application2, atLeast(1)).assetCode();
    verify(application, atLeast(1)).assetCode();
    verify(application28, atLeast(1)).assetCode();
    verify(application29, atLeast(1)).parentAssetCode();
    verify(application27, atLeast(1)).parentAssetCode();
    verify(application26, atLeast(1)).parentAssetCode();
    verify(application25, atLeast(1)).parentAssetCode();
    verify(application24, atLeast(1)).parentAssetCode();
    verify(application23, atLeast(1)).parentAssetCode();
    verify(application22, atLeast(1)).parentAssetCode();
    verify(application21, atLeast(1)).parentAssetCode();
    verify(application20, atLeast(1)).parentAssetCode();
    verify(application19, atLeast(1)).parentAssetCode();
    verify(application18, atLeast(1)).parentAssetCode();
    verify(application17, atLeast(1)).parentAssetCode();
    verify(application16, atLeast(1)).parentAssetCode();
    verify(application15, atLeast(1)).parentAssetCode();
    verify(application14, atLeast(1)).parentAssetCode();
    verify(application13, atLeast(1)).parentAssetCode();
    verify(application12, atLeast(1)).parentAssetCode();
    verify(application11, atLeast(1)).parentAssetCode();
    verify(application10, atLeast(1)).parentAssetCode();
    verify(application9, atLeast(1)).parentAssetCode();
    verify(application8, atLeast(1)).parentAssetCode();
    verify(application7, atLeast(1)).parentAssetCode();
    verify(application6, atLeast(1)).parentAssetCode();
    verify(application5, atLeast(1)).parentAssetCode();
    verify(application4, atLeast(1)).parentAssetCode();
    verify(application3, atLeast(1)).parentAssetCode();
    verify(application2, atLeast(1)).parentAssetCode();
    verify(application, atLeast(1)).parentAssetCode();
    verify(application28, atLeast(1)).parentAssetCode();
    assertEquals(1, actualFindRelatedResult.size());
    assertEquals(28, actualFindRelatedResult.get(AssetCodeRelationshipKind.SHARING).size());
  }

  /**
   * Method under test: {@link ApplicationService#findRelated(long)}
   */
  @Test
  void testFindRelated5() {
    // Arrange
    Application application = mock(Application.class);
    Optional<ExternalIdValue> ofResult = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult);
    Optional<ExternalIdValue> ofResult2 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult3);
    Application application2 = mock(Application.class);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(application2.id()).thenReturn(ofResult4);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(application2.assetCode()).thenReturn(ofResult5);
    Optional<ExternalIdValue> ofResult6 = Optional.of(ExternalIdValue.of("42"));
    when(application2.parentAssetCode()).thenReturn(ofResult6);
    Application application3 = mock(Application.class);
    Optional<Long> ofResult7 = Optional.<Long>of(1L);
    when(application3.id()).thenReturn(ofResult7);
    Optional<ExternalIdValue> ofResult8 = Optional.of(ExternalIdValue.of("42"));
    when(application3.assetCode()).thenReturn(ofResult8);
    Optional<ExternalIdValue> ofResult9 = Optional.of(ExternalIdValue.of("42"));
    when(application3.parentAssetCode()).thenReturn(ofResult9);
    Application application4 = mock(Application.class);
    Optional<Long> ofResult10 = Optional.<Long>of(1L);
    when(application4.id()).thenReturn(ofResult10);
    Optional<ExternalIdValue> ofResult11 = Optional.of(ExternalIdValue.of("42"));
    when(application4.assetCode()).thenReturn(ofResult11);
    Optional<ExternalIdValue> ofResult12 = Optional.of(ExternalIdValue.of("42"));
    when(application4.parentAssetCode()).thenReturn(ofResult12);
    Application application5 = mock(Application.class);
    Optional<Long> ofResult13 = Optional.<Long>of(1L);
    when(application5.id()).thenReturn(ofResult13);
    Optional<ExternalIdValue> ofResult14 = Optional.of(ExternalIdValue.of("42"));
    when(application5.assetCode()).thenReturn(ofResult14);
    Optional<ExternalIdValue> ofResult15 = Optional.of(ExternalIdValue.of("42"));
    when(application5.parentAssetCode()).thenReturn(ofResult15);
    Application application6 = mock(Application.class);
    Optional<Long> ofResult16 = Optional.<Long>of(1L);
    when(application6.id()).thenReturn(ofResult16);
    Optional<ExternalIdValue> ofResult17 = Optional.of(ExternalIdValue.of("42"));
    when(application6.assetCode()).thenReturn(ofResult17);
    Optional<ExternalIdValue> ofResult18 = Optional.of(ExternalIdValue.of("42"));
    when(application6.parentAssetCode()).thenReturn(ofResult18);
    Application application7 = mock(Application.class);
    Optional<Long> ofResult19 = Optional.<Long>of(1L);
    when(application7.id()).thenReturn(ofResult19);
    Optional<ExternalIdValue> ofResult20 = Optional.of(ExternalIdValue.of("42"));
    when(application7.assetCode()).thenReturn(ofResult20);
    Optional<ExternalIdValue> ofResult21 = Optional.of(ExternalIdValue.of("42"));
    when(application7.parentAssetCode()).thenReturn(ofResult21);
    Application application8 = mock(Application.class);
    Optional<Long> ofResult22 = Optional.<Long>of(1L);
    when(application8.id()).thenReturn(ofResult22);
    Optional<ExternalIdValue> ofResult23 = Optional.of(ExternalIdValue.of("42"));
    when(application8.assetCode()).thenReturn(ofResult23);
    Optional<ExternalIdValue> ofResult24 = Optional.of(ExternalIdValue.of("42"));
    when(application8.parentAssetCode()).thenReturn(ofResult24);
    Application application9 = mock(Application.class);
    Optional<Long> ofResult25 = Optional.<Long>of(1L);
    when(application9.id()).thenReturn(ofResult25);
    Optional<ExternalIdValue> ofResult26 = Optional.of(ExternalIdValue.of("42"));
    when(application9.assetCode()).thenReturn(ofResult26);
    Optional<ExternalIdValue> ofResult27 = Optional.of(ExternalIdValue.of("42"));
    when(application9.parentAssetCode()).thenReturn(ofResult27);
    Application application10 = mock(Application.class);
    Optional<Long> ofResult28 = Optional.<Long>of(1L);
    when(application10.id()).thenReturn(ofResult28);
    Optional<ExternalIdValue> ofResult29 = Optional.of(ExternalIdValue.of("42"));
    when(application10.assetCode()).thenReturn(ofResult29);
    Optional<ExternalIdValue> ofResult30 = Optional.of(ExternalIdValue.of("42"));
    when(application10.parentAssetCode()).thenReturn(ofResult30);
    Application application11 = mock(Application.class);
    Optional<Long> ofResult31 = Optional.<Long>of(1L);
    when(application11.id()).thenReturn(ofResult31);
    Optional<ExternalIdValue> ofResult32 = Optional.of(ExternalIdValue.of("42"));
    when(application11.assetCode()).thenReturn(ofResult32);
    Optional<ExternalIdValue> ofResult33 = Optional.of(ExternalIdValue.of("42"));
    when(application11.parentAssetCode()).thenReturn(ofResult33);
    Application application12 = mock(Application.class);
    Optional<Long> ofResult34 = Optional.<Long>of(1L);
    when(application12.id()).thenReturn(ofResult34);
    Optional<ExternalIdValue> ofResult35 = Optional.of(ExternalIdValue.of("42"));
    when(application12.assetCode()).thenReturn(ofResult35);
    Optional<ExternalIdValue> ofResult36 = Optional.of(ExternalIdValue.of("42"));
    when(application12.parentAssetCode()).thenReturn(ofResult36);
    Application application13 = mock(Application.class);
    Optional<Long> ofResult37 = Optional.<Long>of(1L);
    when(application13.id()).thenReturn(ofResult37);
    Optional<ExternalIdValue> ofResult38 = Optional.of(ExternalIdValue.of("42"));
    when(application13.assetCode()).thenReturn(ofResult38);
    Optional<ExternalIdValue> ofResult39 = Optional.of(ExternalIdValue.of("42"));
    when(application13.parentAssetCode()).thenReturn(ofResult39);
    Application application14 = mock(Application.class);
    Optional<Long> ofResult40 = Optional.<Long>of(1L);
    when(application14.id()).thenReturn(ofResult40);
    Optional<ExternalIdValue> ofResult41 = Optional.of(ExternalIdValue.of("42"));
    when(application14.assetCode()).thenReturn(ofResult41);
    Optional<ExternalIdValue> ofResult42 = Optional.of(ExternalIdValue.of("42"));
    when(application14.parentAssetCode()).thenReturn(ofResult42);
    Application application15 = mock(Application.class);
    Optional<Long> ofResult43 = Optional.<Long>of(1L);
    when(application15.id()).thenReturn(ofResult43);
    Optional<ExternalIdValue> ofResult44 = Optional.of(ExternalIdValue.of("42"));
    when(application15.assetCode()).thenReturn(ofResult44);
    Optional<ExternalIdValue> ofResult45 = Optional.of(ExternalIdValue.of("42"));
    when(application15.parentAssetCode()).thenReturn(ofResult45);
    Application application16 = mock(Application.class);
    Optional<Long> ofResult46 = Optional.<Long>of(1L);
    when(application16.id()).thenReturn(ofResult46);
    Optional<ExternalIdValue> ofResult47 = Optional.of(ExternalIdValue.of("42"));
    when(application16.assetCode()).thenReturn(ofResult47);
    Optional<ExternalIdValue> ofResult48 = Optional.of(ExternalIdValue.of("42"));
    when(application16.parentAssetCode()).thenReturn(ofResult48);
    Application application17 = mock(Application.class);
    Optional<Long> ofResult49 = Optional.<Long>of(1L);
    when(application17.id()).thenReturn(ofResult49);
    Optional<ExternalIdValue> ofResult50 = Optional.of(ExternalIdValue.of("42"));
    when(application17.assetCode()).thenReturn(ofResult50);
    Optional<ExternalIdValue> ofResult51 = Optional.of(ExternalIdValue.of("42"));
    when(application17.parentAssetCode()).thenReturn(ofResult51);
    Application application18 = mock(Application.class);
    Optional<Long> ofResult52 = Optional.<Long>of(1L);
    when(application18.id()).thenReturn(ofResult52);
    Optional<ExternalIdValue> ofResult53 = Optional.of(ExternalIdValue.of("42"));
    when(application18.assetCode()).thenReturn(ofResult53);
    Optional<ExternalIdValue> ofResult54 = Optional.of(ExternalIdValue.of("42"));
    when(application18.parentAssetCode()).thenReturn(ofResult54);
    Application application19 = mock(Application.class);
    Optional<Long> ofResult55 = Optional.<Long>of(1L);
    when(application19.id()).thenReturn(ofResult55);
    Optional<ExternalIdValue> ofResult56 = Optional.of(ExternalIdValue.of("42"));
    when(application19.assetCode()).thenReturn(ofResult56);
    Optional<ExternalIdValue> ofResult57 = Optional.of(ExternalIdValue.of("42"));
    when(application19.parentAssetCode()).thenReturn(ofResult57);
    Application application20 = mock(Application.class);
    Optional<Long> ofResult58 = Optional.<Long>of(1L);
    when(application20.id()).thenReturn(ofResult58);
    Optional<ExternalIdValue> ofResult59 = Optional.of(ExternalIdValue.of("42"));
    when(application20.assetCode()).thenReturn(ofResult59);
    Optional<ExternalIdValue> ofResult60 = Optional.of(ExternalIdValue.of("42"));
    when(application20.parentAssetCode()).thenReturn(ofResult60);
    Application application21 = mock(Application.class);
    Optional<Long> ofResult61 = Optional.<Long>of(1L);
    when(application21.id()).thenReturn(ofResult61);
    Optional<ExternalIdValue> ofResult62 = Optional.of(ExternalIdValue.of("42"));
    when(application21.assetCode()).thenReturn(ofResult62);
    Optional<ExternalIdValue> ofResult63 = Optional.of(ExternalIdValue.of("42"));
    when(application21.parentAssetCode()).thenReturn(ofResult63);
    Application application22 = mock(Application.class);
    Optional<Long> ofResult64 = Optional.<Long>of(1L);
    when(application22.id()).thenReturn(ofResult64);
    Optional<ExternalIdValue> ofResult65 = Optional.of(ExternalIdValue.of("42"));
    when(application22.assetCode()).thenReturn(ofResult65);
    Optional<ExternalIdValue> ofResult66 = Optional.of(ExternalIdValue.of("42"));
    when(application22.parentAssetCode()).thenReturn(ofResult66);
    Application application23 = mock(Application.class);
    Optional<Long> ofResult67 = Optional.<Long>of(1L);
    when(application23.id()).thenReturn(ofResult67);
    Optional<ExternalIdValue> ofResult68 = Optional.of(ExternalIdValue.of("42"));
    when(application23.assetCode()).thenReturn(ofResult68);
    Optional<ExternalIdValue> ofResult69 = Optional.of(ExternalIdValue.of("42"));
    when(application23.parentAssetCode()).thenReturn(ofResult69);
    Application application24 = mock(Application.class);
    Optional<Long> ofResult70 = Optional.<Long>of(1L);
    when(application24.id()).thenReturn(ofResult70);
    Optional<ExternalIdValue> ofResult71 = Optional.of(ExternalIdValue.of("42"));
    when(application24.assetCode()).thenReturn(ofResult71);
    Optional<ExternalIdValue> ofResult72 = Optional.of(ExternalIdValue.of("42"));
    when(application24.parentAssetCode()).thenReturn(ofResult72);
    Application application25 = mock(Application.class);
    Optional<Long> ofResult73 = Optional.<Long>of(1L);
    when(application25.id()).thenReturn(ofResult73);
    Optional<ExternalIdValue> ofResult74 = Optional.of(ExternalIdValue.of("42"));
    when(application25.assetCode()).thenReturn(ofResult74);
    Optional<ExternalIdValue> ofResult75 = Optional.of(ExternalIdValue.of("42"));
    when(application25.parentAssetCode()).thenReturn(ofResult75);
    Application application26 = mock(Application.class);
    Optional<Long> ofResult76 = Optional.<Long>of(1L);
    when(application26.id()).thenReturn(ofResult76);
    Optional<ExternalIdValue> ofResult77 = Optional.of(ExternalIdValue.of("42"));
    when(application26.assetCode()).thenReturn(ofResult77);
    Optional<ExternalIdValue> ofResult78 = Optional.of(ExternalIdValue.of("42"));
    when(application26.parentAssetCode()).thenReturn(ofResult78);
    Application application27 = mock(Application.class);
    Optional<Long> ofResult79 = Optional.<Long>of(1L);
    when(application27.id()).thenReturn(ofResult79);
    Optional<ExternalIdValue> ofResult80 = Optional.of(ExternalIdValue.of("42"));
    when(application27.assetCode()).thenReturn(ofResult80);
    Optional<ExternalIdValue> ofResult81 = Optional.of(ExternalIdValue.of("42"));
    when(application27.parentAssetCode()).thenReturn(ofResult81);
    Application application28 = mock(Application.class);
    Optional<Long> ofResult82 = Optional.<Long>of(1L);
    when(application28.id()).thenReturn(ofResult82);
    Optional<ExternalIdValue> ofResult83 = Optional.of(ExternalIdValue.of("42"));
    when(application28.assetCode()).thenReturn(ofResult83);
    Optional<ExternalIdValue> ofResult84 = Optional.of(ExternalIdValue.of("42"));
    when(application28.parentAssetCode()).thenReturn(ofResult84);
    Application application29 = mock(Application.class);
    Optional<Long> ofResult85 = Optional.<Long>of(1L);
    when(application29.id()).thenReturn(ofResult85);
    Optional<ExternalIdValue> ofResult86 = Optional.of(ExternalIdValue.of("Value"));
    when(application29.assetCode()).thenReturn(ofResult86);
    Optional<ExternalIdValue> ofResult87 = Optional.of(ExternalIdValue.of("42"));
    when(application29.parentAssetCode()).thenReturn(ofResult87);

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application29);
    applicationList.add(application28);
    applicationList.add(application27);
    applicationList.add(application26);
    applicationList.add(application25);
    applicationList.add(application24);
    applicationList.add(application23);
    applicationList.add(application22);
    applicationList.add(application21);
    applicationList.add(application20);
    applicationList.add(application19);
    applicationList.add(application18);
    applicationList.add(application17);
    applicationList.add(application16);
    applicationList.add(application15);
    applicationList.add(application14);
    applicationList.add(application13);
    applicationList.add(application12);
    applicationList.add(application11);
    applicationList.add(application10);
    applicationList.add(application9);
    applicationList.add(application8);
    applicationList.add(application7);
    applicationList.add(application6);
    applicationList.add(application5);
    applicationList.add(application4);
    applicationList.add(application3);
    applicationList.add(application2);
    applicationList.add(application);
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findRelatedByApplicationId(anyLong())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);

    // Act
    Map<AssetCodeRelationshipKind, List<Application>> actualFindRelatedResult = (new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class))).findRelated(1L);

    // Assert
    verify(appDao).findRelatedByApplicationId(eq(1L));
    verify(application29).id();
    verify(application28, atLeast(1)).assetCode();
    verify(application27, atLeast(1)).assetCode();
    verify(application26, atLeast(1)).assetCode();
    verify(application25, atLeast(1)).assetCode();
    verify(application24, atLeast(1)).assetCode();
    verify(application23, atLeast(1)).assetCode();
    verify(application22, atLeast(1)).assetCode();
    verify(application21, atLeast(1)).assetCode();
    verify(application20, atLeast(1)).assetCode();
    verify(application19, atLeast(1)).assetCode();
    verify(application18, atLeast(1)).assetCode();
    verify(application17, atLeast(1)).assetCode();
    verify(application16, atLeast(1)).assetCode();
    verify(application15, atLeast(1)).assetCode();
    verify(application14, atLeast(1)).assetCode();
    verify(application13, atLeast(1)).assetCode();
    verify(application12, atLeast(1)).assetCode();
    verify(application11, atLeast(1)).assetCode();
    verify(application10, atLeast(1)).assetCode();
    verify(application9, atLeast(1)).assetCode();
    verify(application8, atLeast(1)).assetCode();
    verify(application7, atLeast(1)).assetCode();
    verify(application6, atLeast(1)).assetCode();
    verify(application5, atLeast(1)).assetCode();
    verify(application4, atLeast(1)).assetCode();
    verify(application3, atLeast(1)).assetCode();
    verify(application2, atLeast(1)).assetCode();
    verify(application, atLeast(1)).assetCode();
    verify(application29, atLeast(1)).assetCode();
    verify(application28, atLeast(1)).parentAssetCode();
    verify(application27, atLeast(1)).parentAssetCode();
    verify(application26, atLeast(1)).parentAssetCode();
    verify(application25, atLeast(1)).parentAssetCode();
    verify(application24, atLeast(1)).parentAssetCode();
    verify(application23, atLeast(1)).parentAssetCode();
    verify(application22, atLeast(1)).parentAssetCode();
    verify(application21, atLeast(1)).parentAssetCode();
    verify(application20, atLeast(1)).parentAssetCode();
    verify(application19, atLeast(1)).parentAssetCode();
    verify(application18, atLeast(1)).parentAssetCode();
    verify(application17, atLeast(1)).parentAssetCode();
    verify(application16, atLeast(1)).parentAssetCode();
    verify(application15, atLeast(1)).parentAssetCode();
    verify(application14, atLeast(1)).parentAssetCode();
    verify(application13, atLeast(1)).parentAssetCode();
    verify(application12, atLeast(1)).parentAssetCode();
    verify(application11, atLeast(1)).parentAssetCode();
    verify(application10, atLeast(1)).parentAssetCode();
    verify(application9, atLeast(1)).parentAssetCode();
    verify(application8, atLeast(1)).parentAssetCode();
    verify(application7, atLeast(1)).parentAssetCode();
    verify(application6, atLeast(1)).parentAssetCode();
    verify(application5, atLeast(1)).parentAssetCode();
    verify(application4, atLeast(1)).parentAssetCode();
    verify(application3, atLeast(1)).parentAssetCode();
    verify(application2, atLeast(1)).parentAssetCode();
    verify(application, atLeast(1)).parentAssetCode();
    verify(application29, atLeast(1)).parentAssetCode();
    assertEquals(1, actualFindRelatedResult.size());
    assertEquals(28, actualFindRelatedResult.get(AssetCodeRelationshipKind.PARENT).size());
  }

  /**
   * Method under test: {@link ApplicationService#findRelated(long)}
   */
  @Test
  void testFindRelated6() {
    // Arrange
    Application application = mock(Application.class);
    Optional<ExternalIdValue> ofResult = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult);
    Optional<ExternalIdValue> ofResult2 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(application.id()).thenReturn(ofResult3);
    Application application2 = mock(Application.class);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(application2.id()).thenReturn(ofResult4);
    Optional<ExternalIdValue> ofResult5 = Optional.of(ExternalIdValue.of("42"));
    when(application2.assetCode()).thenReturn(ofResult5);
    Optional<ExternalIdValue> ofResult6 = Optional.of(ExternalIdValue.of("42"));
    when(application2.parentAssetCode()).thenReturn(ofResult6);
    Application application3 = mock(Application.class);
    Optional<Long> ofResult7 = Optional.<Long>of(1L);
    when(application3.id()).thenReturn(ofResult7);
    Optional<ExternalIdValue> ofResult8 = Optional.of(ExternalIdValue.of("42"));
    when(application3.assetCode()).thenReturn(ofResult8);
    Optional<ExternalIdValue> ofResult9 = Optional.of(ExternalIdValue.of("42"));
    when(application3.parentAssetCode()).thenReturn(ofResult9);
    Application application4 = mock(Application.class);
    Optional<Long> ofResult10 = Optional.<Long>of(1L);
    when(application4.id()).thenReturn(ofResult10);
    Optional<ExternalIdValue> ofResult11 = Optional.of(ExternalIdValue.of("42"));
    when(application4.assetCode()).thenReturn(ofResult11);
    Optional<ExternalIdValue> ofResult12 = Optional.of(ExternalIdValue.of("42"));
    when(application4.parentAssetCode()).thenReturn(ofResult12);
    Application application5 = mock(Application.class);
    Optional<Long> ofResult13 = Optional.<Long>of(1L);
    when(application5.id()).thenReturn(ofResult13);
    Optional<ExternalIdValue> ofResult14 = Optional.of(ExternalIdValue.of("42"));
    when(application5.assetCode()).thenReturn(ofResult14);
    Optional<ExternalIdValue> ofResult15 = Optional.of(ExternalIdValue.of("42"));
    when(application5.parentAssetCode()).thenReturn(ofResult15);
    Application application6 = mock(Application.class);
    Optional<Long> ofResult16 = Optional.<Long>of(1L);
    when(application6.id()).thenReturn(ofResult16);
    Optional<ExternalIdValue> ofResult17 = Optional.of(ExternalIdValue.of("42"));
    when(application6.assetCode()).thenReturn(ofResult17);
    Optional<ExternalIdValue> ofResult18 = Optional.of(ExternalIdValue.of("42"));
    when(application6.parentAssetCode()).thenReturn(ofResult18);
    Application application7 = mock(Application.class);
    Optional<Long> ofResult19 = Optional.<Long>of(1L);
    when(application7.id()).thenReturn(ofResult19);
    Optional<ExternalIdValue> ofResult20 = Optional.of(ExternalIdValue.of("42"));
    when(application7.assetCode()).thenReturn(ofResult20);
    Optional<ExternalIdValue> ofResult21 = Optional.of(ExternalIdValue.of("42"));
    when(application7.parentAssetCode()).thenReturn(ofResult21);
    Application application8 = mock(Application.class);
    Optional<Long> ofResult22 = Optional.<Long>of(1L);
    when(application8.id()).thenReturn(ofResult22);
    Optional<ExternalIdValue> ofResult23 = Optional.of(ExternalIdValue.of("42"));
    when(application8.assetCode()).thenReturn(ofResult23);
    Optional<ExternalIdValue> ofResult24 = Optional.of(ExternalIdValue.of("42"));
    when(application8.parentAssetCode()).thenReturn(ofResult24);
    Application application9 = mock(Application.class);
    Optional<Long> ofResult25 = Optional.<Long>of(1L);
    when(application9.id()).thenReturn(ofResult25);
    Optional<ExternalIdValue> ofResult26 = Optional.of(ExternalIdValue.of("42"));
    when(application9.assetCode()).thenReturn(ofResult26);
    Optional<ExternalIdValue> ofResult27 = Optional.of(ExternalIdValue.of("42"));
    when(application9.parentAssetCode()).thenReturn(ofResult27);
    Application application10 = mock(Application.class);
    Optional<Long> ofResult28 = Optional.<Long>of(1L);
    when(application10.id()).thenReturn(ofResult28);
    Optional<ExternalIdValue> ofResult29 = Optional.of(ExternalIdValue.of("42"));
    when(application10.assetCode()).thenReturn(ofResult29);
    Optional<ExternalIdValue> ofResult30 = Optional.of(ExternalIdValue.of("42"));
    when(application10.parentAssetCode()).thenReturn(ofResult30);
    Application application11 = mock(Application.class);
    Optional<Long> ofResult31 = Optional.<Long>of(1L);
    when(application11.id()).thenReturn(ofResult31);
    Optional<ExternalIdValue> ofResult32 = Optional.of(ExternalIdValue.of("42"));
    when(application11.assetCode()).thenReturn(ofResult32);
    Optional<ExternalIdValue> ofResult33 = Optional.of(ExternalIdValue.of("42"));
    when(application11.parentAssetCode()).thenReturn(ofResult33);
    Application application12 = mock(Application.class);
    Optional<Long> ofResult34 = Optional.<Long>of(1L);
    when(application12.id()).thenReturn(ofResult34);
    Optional<ExternalIdValue> ofResult35 = Optional.of(ExternalIdValue.of("42"));
    when(application12.assetCode()).thenReturn(ofResult35);
    Optional<ExternalIdValue> ofResult36 = Optional.of(ExternalIdValue.of("42"));
    when(application12.parentAssetCode()).thenReturn(ofResult36);
    Application application13 = mock(Application.class);
    Optional<Long> ofResult37 = Optional.<Long>of(1L);
    when(application13.id()).thenReturn(ofResult37);
    Optional<ExternalIdValue> ofResult38 = Optional.of(ExternalIdValue.of("42"));
    when(application13.assetCode()).thenReturn(ofResult38);
    Optional<ExternalIdValue> ofResult39 = Optional.of(ExternalIdValue.of("42"));
    when(application13.parentAssetCode()).thenReturn(ofResult39);
    Application application14 = mock(Application.class);
    Optional<Long> ofResult40 = Optional.<Long>of(1L);
    when(application14.id()).thenReturn(ofResult40);
    Optional<ExternalIdValue> ofResult41 = Optional.of(ExternalIdValue.of("42"));
    when(application14.assetCode()).thenReturn(ofResult41);
    Optional<ExternalIdValue> ofResult42 = Optional.of(ExternalIdValue.of("42"));
    when(application14.parentAssetCode()).thenReturn(ofResult42);
    Application application15 = mock(Application.class);
    Optional<Long> ofResult43 = Optional.<Long>of(1L);
    when(application15.id()).thenReturn(ofResult43);
    Optional<ExternalIdValue> ofResult44 = Optional.of(ExternalIdValue.of("42"));
    when(application15.assetCode()).thenReturn(ofResult44);
    Optional<ExternalIdValue> ofResult45 = Optional.of(ExternalIdValue.of("42"));
    when(application15.parentAssetCode()).thenReturn(ofResult45);
    Application application16 = mock(Application.class);
    Optional<Long> ofResult46 = Optional.<Long>of(1L);
    when(application16.id()).thenReturn(ofResult46);
    Optional<ExternalIdValue> ofResult47 = Optional.of(ExternalIdValue.of("42"));
    when(application16.assetCode()).thenReturn(ofResult47);
    Optional<ExternalIdValue> ofResult48 = Optional.of(ExternalIdValue.of("42"));
    when(application16.parentAssetCode()).thenReturn(ofResult48);
    Application application17 = mock(Application.class);
    Optional<Long> ofResult49 = Optional.<Long>of(1L);
    when(application17.id()).thenReturn(ofResult49);
    Optional<ExternalIdValue> ofResult50 = Optional.of(ExternalIdValue.of("42"));
    when(application17.assetCode()).thenReturn(ofResult50);
    Optional<ExternalIdValue> ofResult51 = Optional.of(ExternalIdValue.of("42"));
    when(application17.parentAssetCode()).thenReturn(ofResult51);
    Application application18 = mock(Application.class);
    Optional<Long> ofResult52 = Optional.<Long>of(1L);
    when(application18.id()).thenReturn(ofResult52);
    Optional<ExternalIdValue> ofResult53 = Optional.of(ExternalIdValue.of("42"));
    when(application18.assetCode()).thenReturn(ofResult53);
    Optional<ExternalIdValue> ofResult54 = Optional.of(ExternalIdValue.of("42"));
    when(application18.parentAssetCode()).thenReturn(ofResult54);
    Application application19 = mock(Application.class);
    Optional<Long> ofResult55 = Optional.<Long>of(1L);
    when(application19.id()).thenReturn(ofResult55);
    Optional<ExternalIdValue> ofResult56 = Optional.of(ExternalIdValue.of("42"));
    when(application19.assetCode()).thenReturn(ofResult56);
    Optional<ExternalIdValue> ofResult57 = Optional.of(ExternalIdValue.of("42"));
    when(application19.parentAssetCode()).thenReturn(ofResult57);
    Application application20 = mock(Application.class);
    Optional<Long> ofResult58 = Optional.<Long>of(1L);
    when(application20.id()).thenReturn(ofResult58);
    Optional<ExternalIdValue> ofResult59 = Optional.of(ExternalIdValue.of("42"));
    when(application20.assetCode()).thenReturn(ofResult59);
    Optional<ExternalIdValue> ofResult60 = Optional.of(ExternalIdValue.of("42"));
    when(application20.parentAssetCode()).thenReturn(ofResult60);
    Application application21 = mock(Application.class);
    Optional<Long> ofResult61 = Optional.<Long>of(1L);
    when(application21.id()).thenReturn(ofResult61);
    Optional<ExternalIdValue> ofResult62 = Optional.of(ExternalIdValue.of("42"));
    when(application21.assetCode()).thenReturn(ofResult62);
    Optional<ExternalIdValue> ofResult63 = Optional.of(ExternalIdValue.of("42"));
    when(application21.parentAssetCode()).thenReturn(ofResult63);
    Application application22 = mock(Application.class);
    Optional<Long> ofResult64 = Optional.<Long>of(1L);
    when(application22.id()).thenReturn(ofResult64);
    Optional<ExternalIdValue> ofResult65 = Optional.of(ExternalIdValue.of("42"));
    when(application22.assetCode()).thenReturn(ofResult65);
    Optional<ExternalIdValue> ofResult66 = Optional.of(ExternalIdValue.of("42"));
    when(application22.parentAssetCode()).thenReturn(ofResult66);
    Application application23 = mock(Application.class);
    Optional<Long> ofResult67 = Optional.<Long>of(1L);
    when(application23.id()).thenReturn(ofResult67);
    Optional<ExternalIdValue> ofResult68 = Optional.of(ExternalIdValue.of("42"));
    when(application23.assetCode()).thenReturn(ofResult68);
    Optional<ExternalIdValue> ofResult69 = Optional.of(ExternalIdValue.of("42"));
    when(application23.parentAssetCode()).thenReturn(ofResult69);
    Application application24 = mock(Application.class);
    Optional<Long> ofResult70 = Optional.<Long>of(1L);
    when(application24.id()).thenReturn(ofResult70);
    Optional<ExternalIdValue> ofResult71 = Optional.of(ExternalIdValue.of("42"));
    when(application24.assetCode()).thenReturn(ofResult71);
    Optional<ExternalIdValue> ofResult72 = Optional.of(ExternalIdValue.of("42"));
    when(application24.parentAssetCode()).thenReturn(ofResult72);
    Application application25 = mock(Application.class);
    Optional<Long> ofResult73 = Optional.<Long>of(1L);
    when(application25.id()).thenReturn(ofResult73);
    Optional<ExternalIdValue> ofResult74 = Optional.of(ExternalIdValue.of("42"));
    when(application25.assetCode()).thenReturn(ofResult74);
    Optional<ExternalIdValue> ofResult75 = Optional.of(ExternalIdValue.of("42"));
    when(application25.parentAssetCode()).thenReturn(ofResult75);
    Application application26 = mock(Application.class);
    Optional<Long> ofResult76 = Optional.<Long>of(1L);
    when(application26.id()).thenReturn(ofResult76);
    Optional<ExternalIdValue> ofResult77 = Optional.of(ExternalIdValue.of("42"));
    when(application26.assetCode()).thenReturn(ofResult77);
    Optional<ExternalIdValue> ofResult78 = Optional.of(ExternalIdValue.of("42"));
    when(application26.parentAssetCode()).thenReturn(ofResult78);
    Application application27 = mock(Application.class);
    Optional<Long> ofResult79 = Optional.<Long>of(1L);
    when(application27.id()).thenReturn(ofResult79);
    Optional<ExternalIdValue> ofResult80 = Optional.of(ExternalIdValue.of("42"));
    when(application27.assetCode()).thenReturn(ofResult80);
    Optional<ExternalIdValue> ofResult81 = Optional.of(ExternalIdValue.of("42"));
    when(application27.parentAssetCode()).thenReturn(ofResult81);
    Application application28 = mock(Application.class);
    Optional<Long> ofResult82 = Optional.<Long>of(1L);
    when(application28.id()).thenReturn(ofResult82);
    Optional<ExternalIdValue> ofResult83 = Optional.of(ExternalIdValue.of("Value"));
    when(application28.assetCode()).thenReturn(ofResult83);
    Optional<ExternalIdValue> ofResult84 = Optional.of(ExternalIdValue.of("42"));
    when(application28.parentAssetCode()).thenReturn(ofResult84);
    Application application29 = mock(Application.class);
    Optional<Long> ofResult85 = Optional.<Long>of(1L);
    when(application29.id()).thenReturn(ofResult85);
    Optional<ExternalIdValue> ofResult86 = Optional.of(ExternalIdValue.of("42"));
    when(application29.assetCode()).thenReturn(ofResult86);
    Optional<ExternalIdValue> ofResult87 = Optional.of(ExternalIdValue.of("42"));
    when(application29.parentAssetCode()).thenReturn(ofResult87);

    ArrayList<Application> applicationList = new ArrayList<>();
    applicationList.add(application29);
    applicationList.add(application28);
    applicationList.add(application27);
    applicationList.add(application26);
    applicationList.add(application25);
    applicationList.add(application24);
    applicationList.add(application23);
    applicationList.add(application22);
    applicationList.add(application21);
    applicationList.add(application20);
    applicationList.add(application19);
    applicationList.add(application18);
    applicationList.add(application17);
    applicationList.add(application16);
    applicationList.add(application15);
    applicationList.add(application14);
    applicationList.add(application13);
    applicationList.add(application12);
    applicationList.add(application11);
    applicationList.add(application10);
    applicationList.add(application9);
    applicationList.add(application8);
    applicationList.add(application7);
    applicationList.add(application6);
    applicationList.add(application5);
    applicationList.add(application4);
    applicationList.add(application3);
    applicationList.add(application2);
    applicationList.add(application);
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findRelatedByApplicationId(anyLong())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);

    // Act
    Map<AssetCodeRelationshipKind, List<Application>> actualFindRelatedResult = (new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class))).findRelated(1L);

    // Assert
    verify(appDao).findRelatedByApplicationId(eq(1L));
    verify(application29).id();
    verify(application28, atLeast(1)).assetCode();
    verify(application27, atLeast(1)).assetCode();
    verify(application26, atLeast(1)).assetCode();
    verify(application25, atLeast(1)).assetCode();
    verify(application24, atLeast(1)).assetCode();
    verify(application23, atLeast(1)).assetCode();
    verify(application22, atLeast(1)).assetCode();
    verify(application21, atLeast(1)).assetCode();
    verify(application20, atLeast(1)).assetCode();
    verify(application19, atLeast(1)).assetCode();
    verify(application18, atLeast(1)).assetCode();
    verify(application17, atLeast(1)).assetCode();
    verify(application16, atLeast(1)).assetCode();
    verify(application15, atLeast(1)).assetCode();
    verify(application14, atLeast(1)).assetCode();
    verify(application13, atLeast(1)).assetCode();
    verify(application12, atLeast(1)).assetCode();
    verify(application11, atLeast(1)).assetCode();
    verify(application10, atLeast(1)).assetCode();
    verify(application9, atLeast(1)).assetCode();
    verify(application8, atLeast(1)).assetCode();
    verify(application7, atLeast(1)).assetCode();
    verify(application6, atLeast(1)).assetCode();
    verify(application5, atLeast(1)).assetCode();
    verify(application4, atLeast(1)).assetCode();
    verify(application3, atLeast(1)).assetCode();
    verify(application2, atLeast(1)).assetCode();
    verify(application, atLeast(1)).assetCode();
    verify(application29, atLeast(1)).assetCode();
    verify(application28, atLeast(1)).parentAssetCode();
    verify(application27, atLeast(1)).parentAssetCode();
    verify(application26, atLeast(1)).parentAssetCode();
    verify(application25, atLeast(1)).parentAssetCode();
    verify(application24, atLeast(1)).parentAssetCode();
    verify(application23, atLeast(1)).parentAssetCode();
    verify(application22, atLeast(1)).parentAssetCode();
    verify(application21, atLeast(1)).parentAssetCode();
    verify(application20, atLeast(1)).parentAssetCode();
    verify(application19, atLeast(1)).parentAssetCode();
    verify(application18, atLeast(1)).parentAssetCode();
    verify(application17, atLeast(1)).parentAssetCode();
    verify(application16, atLeast(1)).parentAssetCode();
    verify(application15, atLeast(1)).parentAssetCode();
    verify(application14, atLeast(1)).parentAssetCode();
    verify(application13, atLeast(1)).parentAssetCode();
    verify(application12, atLeast(1)).parentAssetCode();
    verify(application11, atLeast(1)).parentAssetCode();
    verify(application10, atLeast(1)).parentAssetCode();
    verify(application9, atLeast(1)).parentAssetCode();
    verify(application8, atLeast(1)).parentAssetCode();
    verify(application7, atLeast(1)).parentAssetCode();
    verify(application6, atLeast(1)).parentAssetCode();
    verify(application5, atLeast(1)).parentAssetCode();
    verify(application4, atLeast(1)).parentAssetCode();
    verify(application3, atLeast(1)).parentAssetCode();
    verify(application2, atLeast(1)).parentAssetCode();
    verify(application, atLeast(1)).parentAssetCode();
    verify(application29, atLeast(1)).parentAssetCode();
    assertEquals(2, actualFindRelatedResult.size());
    assertEquals(1, actualFindRelatedResult.get(AssetCodeRelationshipKind.CHILD).size());
    assertEquals(27, actualFindRelatedResult.get(AssetCodeRelationshipKind.SHARING).size());
  }

  /**
   * Method under test:
   * {@link ApplicationService#findByAssetCode(ExternalIdValue)}
   */
  @Test
  void testFindByAssetCode() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    ArrayList<Application> applicationList = new ArrayList<>();
    when(appDao.findByAssetCode(Mockito.<ExternalIdValue>any())).thenReturn(applicationList);
    TagDao tagDao = mock(TagDao.class);
    ApplicationService applicationService = new ApplicationService(appDao,
        new TagService(tagDao,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))),
        mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    // Act
    List<Application> actualFindByAssetCodeResult = applicationService.findByAssetCode(ExternalIdValue.of("42"));

    // Assert
    verify(appDao).findByAssetCode(isA(ExternalIdValue.class));
    assertTrue(actualFindByAssetCodeResult.isEmpty());
    assertSame(applicationList, actualFindByAssetCodeResult);
  }
}
