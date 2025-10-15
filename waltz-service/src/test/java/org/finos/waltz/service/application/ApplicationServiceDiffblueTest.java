package org.finos.waltz.service.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
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
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.application.AppRegistrationRequest;
import org.finos.waltz.model.application.AppRegistrationResponse;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.AssetCodeRelationshipKind;
import org.finos.waltz.model.application.ImmutableAppRegistrationRequest;
import org.finos.waltz.model.application.ImmutableAppRegistrationResponse;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.ImmutableApplication.Builder;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.model.tag.ImmutableTag;
import org.finos.waltz.model.tally.Tally;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.tag.TagService;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ApplicationServiceDiffblueTest {
  @Mock private ApplicationDao applicationDao;

  @Mock private ApplicationSearchDao applicationSearchDao;

  @InjectMocks private ApplicationService applicationService;

  @Mock private EntityAliasDao entityAliasDao;

  @Mock private TagService tagService;

  /**
   * Test {@link ApplicationService#getById(long)}.
   *
   * <p>Method under test: {@link ApplicationService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Application ApplicationService.getById(long)"})
  void testGetById() {
    // Arrange
    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    when(applicationDao.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Act
    Application actualById = applicationService.getById(1L);

    // Assert
    verify(applicationDao).getById(1L);
    assertTrue(actualById instanceof ImmutableApplication);
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1L, actualById.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualById.businessCriticality());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualById.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualById.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualById.lifecyclePhase());
    assertEquals(RagRating.R, actualById.overallRating());
    assertFalse(actualById.isRemoved());
  }

  /**
   * Test {@link ApplicationService#findAll()}.
   *
   * <p>Method under test: {@link ApplicationService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findAll()"})
  void testFindAll() {
    // Arrange
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<Application> actualFindAllResult = applicationService.findAll();

    // Assert
    verify(applicationDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#countByOrganisationalUnit()}.
   *
   * <p>Method under test: {@link ApplicationService#countByOrganisationalUnit()}
   */
  @Test
  @DisplayName("Test countByOrganisationalUnit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.countByOrganisationalUnit()"})
  void testCountByOrganisationalUnit() {
    // Arrange
    when(applicationDao.countByOrganisationalUnit()).thenReturn(new ArrayList<>());

    // Act
    List<Tally<Long>> actualCountByOrganisationalUnitResult =
        applicationService.countByOrganisationalUnit();

    // Assert
    verify(applicationDao).countByOrganisationalUnit();
    assertTrue(actualCountByOrganisationalUnitResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#search(EntitySearchOptions)} with {@code options}.
   *
   * <p>Method under test: {@link ApplicationService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions) with 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.search(EntitySearchOptions)"})
  void testSearchWithOptions() {
    // Arrange
    when(applicationSearchDao.search(Mockito.<EntitySearchOptions>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Application> actualSearchResult = applicationService.search((EntitySearchOptions) null);

    // Assert
    verify(applicationSearchDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Given {@link ApplicationSearchDao}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#search(String)}
   */
  @Test
  @DisplayName("Test search(String) with 'query'; given ApplicationSearchDao; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.search(String)"})
  void testSearchWithQuery_givenApplicationSearchDao_whenEmptyString() {
    // Arrange, Act and Assert
    assertTrue(applicationService.search("").isEmpty());
  }

  /**
   * Test {@link ApplicationService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationSearchDao#search(EntitySearchOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#search(String)}
   */
  @Test
  @DisplayName("Test search(String) with 'query'; then calls search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.search(String)"})
  void testSearchWithQuery_thenCallsSearch() {
    // Arrange
    when(applicationSearchDao.search(Mockito.<EntitySearchOptions>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Application> actualSearchResult = applicationService.search("Query");

    // Assert
    verify(applicationSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findByIds(Collection)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection); given one; when ArrayList() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findByIds(Collection)"})
  void testFindByIds_givenOne_whenArrayListAddOne() {
    // Arrange
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    List<Application> actualFindByIdsResult = applicationService.findByIds(ids);

    // Assert
    verify(applicationDao).findByIds(isA(Collection.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findByIds(Collection)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection); given zero; when ArrayList() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findByIds(Collection)"})
  void testFindByIds_givenZero_whenArrayListAddZero() {
    // Arrange
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    List<Application> actualFindByIdsResult = applicationService.findByIds(ids);

    // Assert
    verify(applicationDao).findByIds(isA(Collection.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findByIds(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findByIds(Collection)"})
  void testFindByIds_whenArrayList() {
    // Arrange
    when(applicationDao.findByIds(Mockito.<Collection<Long>>any())).thenReturn(new ArrayList<>());

    // Act
    List<Application> actualFindByIdsResult = applicationService.findByIds(new ArrayList<>());

    // Assert
    verify(applicationDao).findByIds(isA(Collection.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByAppIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findByAppIdSelector(IdSelectionOptions)"})
  void testFindByAppIdSelector() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
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
    List<Application> actualFindByAppIdSelectorResult =
        applicationService.findByAppIdSelector(options);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByAppIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findByAppIdSelector(IdSelectionOptions)"})
  void testFindByAppIdSelector2() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    List<Application> actualFindByAppIdSelectorResult =
        applicationService.findByAppIdSelector(options);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByAppIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findByAppIdSelector(IdSelectionOptions)"})
  void testFindByAppIdSelector3() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .build());

    // Act
    List<Application> actualFindByAppIdSelectorResult =
        applicationService.findByAppIdSelector(options);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(options, atLeast(1)).entityReference();
    verify(options).scope();
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByAppIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findByAppIdSelector(IdSelectionOptions)"})
  void testFindByAppIdSelector4() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    List<Application> actualFindByAppIdSelectorResult =
        applicationService.findByAppIdSelector(options);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByAppIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findByAppIdSelector(IdSelectionOptions)"})
  void testFindByAppIdSelector5() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

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
    List<Application> actualFindByAppIdSelectorResult =
        applicationService.findByAppIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByAppIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findByAppIdSelector(IdSelectionOptions)"})
  void testFindByAppIdSelector6() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<Application> actualFindByAppIdSelectorResult =
        applicationService.findByAppIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByAppIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findByAppIdSelector(IdSelectionOptions)"})
  void testFindByAppIdSelector7() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    TagDao tagDao = mock(TagDao.class);
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

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<Application> actualFindByAppIdSelectorResult =
        applicationService.findByAppIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(appDao).findByAppIdSelector(isA(Select.class));
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByAppIdSelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findByAppIdSelector(IdSelectionOptions)"})
  void testFindByAppIdSelector8() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);
    when(appDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    TagDao tagDao = mock(TagDao.class);
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

    TagService tagService = new TagService(tagDao, changeLogService);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<Application> actualFindByAppIdSelectorResult =
        applicationService.findByAppIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(appDao).findByAppIdSelector(isA(Select.class));
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByAppIdSelector(IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findByAppIdSelector(IdSelectionOptions)"})
  void testFindByAppIdSelector_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(immutableSelectionFilters);
    when(options.entityReference())
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
    List<Application> actualFindByAppIdSelectorResult =
        applicationService.findByAppIdSelector(options);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options, atLeast(1)).filters();
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByAppIdSelector(IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findByAppIdSelector(IdSelectionOptions)"})
  void testFindByAppIdSelector_givenHashSetAddActive() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
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
    List<Application> actualFindByAppIdSelectorResult =
        applicationService.findByAppIdSelector(options);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByAppIdSelector(IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findByAppIdSelector(IdSelectionOptions)"})
  void testFindByAppIdSelector_givenHashSetAddPending() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(options.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(options.entityReference())
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
    List<Application> actualFindByAppIdSelectorResult =
        applicationService.findByAppIdSelector(options);

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    verify(options).entityLifecycleStatuses();
    verify(options).entityReference();
    verify(options).filters();
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   *   <li>When builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#findByAppIdSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByAppIdSelector(IdSelectionOptions); given 'IN_HOUSE'; when builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findByAppIdSelector(IdSelectionOptions)"})
  void testFindByAppIdSelector_givenInHouse_whenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    when(applicationDao.findByAppIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult.build();

    ImmutableIdSelectionOptions.Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<Application> actualFindByAppIdSelectorResult =
        applicationService.findByAppIdSelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).findByAppIdSelector(isA(Select.class));
    assertTrue(actualFindByAppIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#registerApp(AppRegistrationRequest, String)}.
   *
   * <p>Method under test: {@link ApplicationService#registerApp(AppRegistrationRequest, String)}
   */
  @Test
  @DisplayName("Test registerApp(AppRegistrationRequest, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AppRegistrationResponse ApplicationService.registerApp(AppRegistrationRequest, String)"
  })
  void testRegisterApp() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);

    ImmutableAppRegistrationResponse.Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    when(appDao.registerApp(Mockito.<AppRegistrationRequest>any()))
        .thenReturn(
            messageResult
                .originalRequest(
                    ImmutableAppRegistrationRequest.builder()
                        .applicationKind(ApplicationKind.IN_HOUSE)
                        .assetCode("Asset Code")
                        .businessCriticality(Criticality.LOW)
                        .description("The characteristics of someone or something")
                        .lifecyclePhase(LifecyclePhase.PRODUCTION)
                        .name("Name")
                        .organisationalUnitId(1L)
                        .overallRating(RagRating.R)
                        .parentAssetCode("Parent Asset Code")
                        .provenance("Provenance")
                        .build())
                .build());

    TagDao tagDao = mock(TagDao.class);
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any()))
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

    TagService tagService = new TagService(tagDao, changeLogService);

    EntityAliasDao entityAliasDao = mock(EntityAliasDao.class);
    when(entityAliasDao.updateAliases(
            Mockito.<EntityReference>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, entityAliasDao, mock(ApplicationSearchDao.class));
    ImmutableAppRegistrationRequest request =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    AppRegistrationResponse actualRegisterAppResult =
        applicationService.registerApp(request, "janedoe");

    // Assert
    verify(appDao).registerApp(isA(AppRegistrationRequest.class));
    verify(entityAliasDao).updateAliases(isA(EntityReference.class), isA(Collection.class));
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isA(EntityReference.class));
    AppRegistrationRequest originalRequestResult = actualRegisterAppResult.originalRequest();
    assertTrue(originalRequestResult instanceof ImmutableAppRegistrationRequest);
    assertTrue(actualRegisterAppResult instanceof ImmutableAppRegistrationResponse);
    assertTrue(actualRegisterAppResult.registered());
    assertEquals(request, originalRequestResult);
  }

  /**
   * Test {@link ApplicationService#registerApp(AppRegistrationRequest, String)}.
   *
   * <ul>
   *   <li>Given {@link TagService} {@link TagService#updateTags(EntityReference, Collection,
   *       String)} return {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link TagService#updateTags(EntityReference, Collection, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#registerApp(AppRegistrationRequest, String)}
   */
  @Test
  @DisplayName(
      "Test registerApp(AppRegistrationRequest, String); given TagService updateTags(EntityReference, Collection, String) return ArrayList(); then calls updateTags(EntityReference, Collection, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AppRegistrationResponse ApplicationService.registerApp(AppRegistrationRequest, String)"
  })
  void testRegisterApp_givenTagServiceUpdateTagsReturnArrayList_thenCallsUpdateTags() {
    // Arrange
    ImmutableAppRegistrationResponse.Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    when(applicationDao.registerApp(Mockito.<AppRegistrationRequest>any()))
        .thenReturn(
            messageResult
                .originalRequest(
                    ImmutableAppRegistrationRequest.builder()
                        .applicationKind(ApplicationKind.IN_HOUSE)
                        .assetCode("Asset Code")
                        .businessCriticality(Criticality.LOW)
                        .description("The characteristics of someone or something")
                        .lifecyclePhase(LifecyclePhase.PRODUCTION)
                        .name("Name")
                        .organisationalUnitId(1L)
                        .overallRating(RagRating.R)
                        .parentAssetCode("Parent Asset Code")
                        .provenance("Provenance")
                        .build())
                .build());
    when(tagService.updateTags(
            Mockito.<EntityReference>any(),
            Mockito.<Collection<String>>any(),
            Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(entityAliasDao.updateAliases(
            Mockito.<EntityReference>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    ImmutableAppRegistrationRequest request =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    AppRegistrationResponse actualRegisterAppResult =
        applicationService.registerApp(request, "janedoe");

    // Assert
    verify(applicationDao).registerApp(isA(AppRegistrationRequest.class));
    verify(entityAliasDao).updateAliases(isA(EntityReference.class), isA(Collection.class));
    verify(tagService).updateTags(isA(EntityReference.class), isA(Collection.class), eq("janedoe"));
    AppRegistrationRequest originalRequestResult = actualRegisterAppResult.originalRequest();
    assertTrue(originalRequestResult instanceof ImmutableAppRegistrationRequest);
    assertTrue(actualRegisterAppResult instanceof ImmutableAppRegistrationResponse);
    assertTrue(actualRegisterAppResult.registered());
    assertEquals(request, originalRequestResult);
  }

  /**
   * Test {@link ApplicationService#registerApp(AppRegistrationRequest, String)}.
   *
   * <ul>
   *   <li>Then calls {@link TagDao#removeTagUsage(EntityReference, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#registerApp(AppRegistrationRequest, String)}
   */
  @Test
  @DisplayName(
      "Test registerApp(AppRegistrationRequest, String); then calls removeTagUsage(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AppRegistrationResponse ApplicationService.registerApp(AppRegistrationRequest, String)"
  })
  void testRegisterApp_thenCallsRemoveTagUsage() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);

    ImmutableAppRegistrationResponse.Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    when(appDao.registerApp(Mockito.<AppRegistrationRequest>any()))
        .thenReturn(
            messageResult
                .originalRequest(
                    ImmutableAppRegistrationRequest.builder()
                        .applicationKind(ApplicationKind.IN_HOUSE)
                        .assetCode("Asset Code")
                        .businessCriticality(Criticality.LOW)
                        .description("The characteristics of someone or something")
                        .lifecyclePhase(LifecyclePhase.PRODUCTION)
                        .name("Name")
                        .organisationalUnitId(1L)
                        .overallRating(RagRating.R)
                        .parentAssetCode("Parent Asset Code")
                        .provenance("Provenance")
                        .build())
                .build());

    ArrayList<org.finos.waltz.model.tag.Tag> tagList = new ArrayList<>();
    tagList.add(ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());

    TagDao tagDao = mock(TagDao.class);
    doNothing().when(tagDao).removeTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);
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

    TagService tagService = new TagService(tagDao, changeLogService);

    EntityAliasDao entityAliasDao = mock(EntityAliasDao.class);
    when(entityAliasDao.updateAliases(
            Mockito.<EntityReference>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, entityAliasDao, mock(ApplicationSearchDao.class));
    ImmutableAppRegistrationRequest request =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    AppRegistrationResponse actualRegisterAppResult =
        applicationService.registerApp(request, "janedoe");

    // Assert
    verify(appDao).registerApp(isA(AppRegistrationRequest.class));
    verify(entityAliasDao).updateAliases(isA(EntityReference.class), isA(Collection.class));
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isA(EntityReference.class));
    verify(tagDao).removeTagUsage(isA(EntityReference.class), eq("Name"));
    AppRegistrationRequest originalRequestResult = actualRegisterAppResult.originalRequest();
    assertTrue(originalRequestResult instanceof ImmutableAppRegistrationRequest);
    assertTrue(actualRegisterAppResult instanceof ImmutableAppRegistrationResponse);
    assertTrue(actualRegisterAppResult.registered());
    assertEquals(request, originalRequestResult);
  }

  /**
   * Test {@link ApplicationService#registerApp(AppRegistrationRequest, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#writeChangeLogEntries(EntityReference, String, String,
   *       Operation)}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#registerApp(AppRegistrationRequest, String)}
   */
  @Test
  @DisplayName(
      "Test registerApp(AppRegistrationRequest, String); then calls writeChangeLogEntries(EntityReference, String, String, Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AppRegistrationResponse ApplicationService.registerApp(AppRegistrationRequest, String)"
  })
  void testRegisterApp_thenCallsWriteChangeLogEntries() {
    // Arrange
    ApplicationDao appDao = mock(ApplicationDao.class);

    ImmutableAppRegistrationResponse.Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    when(appDao.registerApp(Mockito.<AppRegistrationRequest>any()))
        .thenReturn(
            messageResult
                .originalRequest(
                    ImmutableAppRegistrationRequest.builder()
                        .applicationKind(ApplicationKind.IN_HOUSE)
                        .assetCode("Asset Code")
                        .businessCriticality(Criticality.LOW)
                        .description("The characteristics of someone or something")
                        .lifecyclePhase(LifecyclePhase.PRODUCTION)
                        .name("Name")
                        .organisationalUnitId(1L)
                        .overallRating(RagRating.R)
                        .parentAssetCode("Parent Asset Code")
                        .provenance("Provenance")
                        .build())
                .build());

    ArrayList<org.finos.waltz.model.tag.Tag> tagList = new ArrayList<>();
    tagList.add(ImmutableTag.builder().id(1L).name("Name").targetKind(EntityKind.ALL).build());

    TagDao tagDao = mock(TagDao.class);
    doNothing().when(tagDao).removeTagUsage(Mockito.<EntityReference>any(), Mockito.<String>any());
    when(tagDao.findTagsForEntityReference(Mockito.<EntityReference>any())).thenReturn(tagList);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    TagService tagService = new TagService(tagDao, changeLogService);

    EntityAliasDao entityAliasDao = mock(EntityAliasDao.class);
    when(entityAliasDao.updateAliases(
            Mockito.<EntityReference>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, entityAliasDao, mock(ApplicationSearchDao.class));
    ImmutableAppRegistrationRequest request =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    AppRegistrationResponse actualRegisterAppResult =
        applicationService.registerApp(request, "janedoe");

    // Assert
    verify(appDao).registerApp(isA(AppRegistrationRequest.class));
    verify(entityAliasDao).updateAliases(isA(EntityReference.class), isA(Collection.class));
    verify(tagDao, atLeast(1)).findTagsForEntityReference(isA(EntityReference.class));
    verify(tagDao).removeTagUsage(isA(EntityReference.class), eq("Name"));
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class),
            eq("janedoe"),
            eq("Removed tags: [Name]. "),
            eq(Operation.UPDATE));
    AppRegistrationRequest originalRequestResult = actualRegisterAppResult.originalRequest();
    assertTrue(originalRequestResult instanceof ImmutableAppRegistrationRequest);
    assertTrue(actualRegisterAppResult instanceof ImmutableAppRegistrationResponse);
    assertTrue(actualRegisterAppResult.registered());
    assertEquals(request, originalRequestResult);
  }

  /**
   * Test {@link ApplicationService#update(Application)}.
   *
   * <p>Method under test: {@link ApplicationService#update(Application)}
   */
  @Test
  @DisplayName("Test update(Application)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ApplicationService.update(Application)"})
  void testUpdate() {
    // Arrange
    when(applicationDao.update(Mockito.<Application>any())).thenReturn(1);

    // Act
    Integer actualUpdateResult = applicationService.update(null);

    // Assert
    verify(applicationDao).update(isNull());
    assertEquals(1, actualUpdateResult.intValue());
  }

  /**
   * Test {@link ApplicationService#findRelated(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#findRelated(long)}
   */
  @Test
  @DisplayName("Test findRelated(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ApplicationService.findRelated(long)"})
  void testFindRelated_thenReturnEmpty() {
    // Arrange
    ArrayList<Application> applicationList = new ArrayList<>();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findRelatedByApplicationId(anyLong())).thenReturn(applicationList);

    // Act
    Map<AssetCodeRelationshipKind, List<Application>> actualFindRelatedResult =
        applicationService.findRelated(1L);

    // Assert
    verify(applicationDao).findRelatedByApplicationId(1L);
    assertTrue(actualFindRelatedResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findRelated(long)}.
   *
   * <ul>
   *   <li>Then return {@code NONE} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#findRelated(long)}
   */
  @Test
  @DisplayName("Test findRelated(long); then return 'NONE' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ApplicationService.findRelated(long)"})
  void testFindRelated_thenReturnNoneSizeIsOne() {
    // Arrange
    ArrayList<Application> applicationList = new ArrayList<>();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.empty();

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("Value"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findRelatedByApplicationId(anyLong())).thenReturn(applicationList);

    // Act
    Map<AssetCodeRelationshipKind, List<Application>> actualFindRelatedResult =
        applicationService.findRelated(1L);

    // Assert
    verify(applicationDao).findRelatedByApplicationId(1L);
    assertEquals(1, actualFindRelatedResult.size());
    List<Application> getResult = actualFindRelatedResult.get(AssetCodeRelationshipKind.NONE);
    assertEquals(1, getResult.size());
    Application getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof ImmutableApplication);
    assertEquals("Name", getResult2.name());
    assertEquals("Provenance", getResult2.provenance());
    assertEquals("The characteristics of someone or something", getResult2.description());
    assertEquals(1L, getResult2.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, getResult2.businessCriticality());
    assertEquals(EntityKind.ALL, getResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult2.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, getResult2.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, getResult2.lifecyclePhase());
    assertEquals(RagRating.R, getResult2.overallRating());
    assertFalse(getResult2.isRemoved());
  }

  /**
   * Test {@link ApplicationService#findRelated(long)}.
   *
   * <ul>
   *   <li>Then return {@code PARENT} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#findRelated(long)}
   */
  @Test
  @DisplayName("Test findRelated(long); then return 'PARENT' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ApplicationService.findRelated(long)"})
  void testFindRelated_thenReturnParentSizeIsOne() {
    // Arrange
    ArrayList<Application> applicationList = new ArrayList<>();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.empty();

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findRelatedByApplicationId(anyLong())).thenReturn(applicationList);

    // Act
    Map<AssetCodeRelationshipKind, List<Application>> actualFindRelatedResult =
        applicationService.findRelated(1L);

    // Assert
    verify(applicationDao).findRelatedByApplicationId(1L);
    assertEquals(1, actualFindRelatedResult.size());
    List<Application> getResult = actualFindRelatedResult.get(AssetCodeRelationshipKind.PARENT);
    assertEquals(1, getResult.size());
    Application getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof ImmutableApplication);
    assertEquals("Name", getResult2.name());
    assertEquals("Provenance", getResult2.provenance());
    assertEquals("The characteristics of someone or something", getResult2.description());
    assertEquals(1L, getResult2.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, getResult2.businessCriticality());
    assertEquals(EntityKind.ALL, getResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult2.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, getResult2.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, getResult2.lifecyclePhase());
    assertEquals(RagRating.R, getResult2.overallRating());
    assertFalse(getResult2.isRemoved());
  }

  /**
   * Test {@link ApplicationService#findRelated(long)}.
   *
   * <ul>
   *   <li>Then return {@code SHARING} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#findRelated(long)}
   */
  @Test
  @DisplayName("Test findRelated(long); then return 'SHARING' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ApplicationService.findRelated(long)"})
  void testFindRelated_thenReturnSharingSizeIsOne() {
    // Arrange
    ArrayList<Application> applicationList = new ArrayList<>();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findRelatedByApplicationId(anyLong())).thenReturn(applicationList);

    // Act
    Map<AssetCodeRelationshipKind, List<Application>> actualFindRelatedResult =
        applicationService.findRelated(1L);

    // Assert
    verify(applicationDao).findRelatedByApplicationId(1L);
    assertEquals(1, actualFindRelatedResult.size());
    List<Application> getResult = actualFindRelatedResult.get(AssetCodeRelationshipKind.SHARING);
    assertEquals(1, getResult.size());
    Application getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof ImmutableApplication);
    assertEquals("Name", getResult2.name());
    assertEquals("Provenance", getResult2.provenance());
    assertEquals("The characteristics of someone or something", getResult2.description());
    assertEquals(1L, getResult2.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, getResult2.businessCriticality());
    assertEquals(EntityKind.ALL, getResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult2.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, getResult2.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, getResult2.lifecyclePhase());
    assertEquals(RagRating.R, getResult2.overallRating());
    assertFalse(getResult2.isRemoved());
  }

  /**
   * Test {@link ApplicationService#findRelated(long)}.
   *
   * <ul>
   *   <li>Then return {@code SIBLING} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#findRelated(long)}
   */
  @Test
  @DisplayName("Test findRelated(long); then return 'SIBLING' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ApplicationService.findRelated(long)"})
  void testFindRelated_thenReturnSiblingSizeIsOne() {
    // Arrange
    ArrayList<Application> applicationList = new ArrayList<>();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.empty();

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("Value"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findRelatedByApplicationId(anyLong())).thenReturn(applicationList);

    // Act
    Map<AssetCodeRelationshipKind, List<Application>> actualFindRelatedResult =
        applicationService.findRelated(1L);

    // Assert
    verify(applicationDao).findRelatedByApplicationId(1L);
    assertEquals(1, actualFindRelatedResult.size());
    List<Application> getResult = actualFindRelatedResult.get(AssetCodeRelationshipKind.SIBLING);
    assertEquals(1, getResult.size());
    Application getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof ImmutableApplication);
    assertEquals("Name", getResult2.name());
    assertEquals("Provenance", getResult2.provenance());
    assertEquals("The characteristics of someone or something", getResult2.description());
    assertEquals(1L, getResult2.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, getResult2.businessCriticality());
    assertEquals(EntityKind.ALL, getResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult2.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, getResult2.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, getResult2.lifecyclePhase());
    assertEquals(RagRating.R, getResult2.overallRating());
    assertFalse(getResult2.isRemoved());
  }

  /**
   * Test {@link ApplicationService#findRelated(long)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#findRelated(long)}
   */
  @Test
  @DisplayName("Test findRelated(long); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ApplicationService.findRelated(long)"})
  void testFindRelated_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Application> applicationList = new ArrayList<>();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.empty();

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    Builder applicationKindResult3 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode3 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult3 =
        applicationKindResult3
            .assetCode(assetCode3)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode3 = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult3
            .parentAssetCode(parentAssetCode3)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findRelatedByApplicationId(anyLong())).thenReturn(applicationList);

    // Act
    Map<AssetCodeRelationshipKind, List<Application>> actualFindRelatedResult =
        applicationService.findRelated(1L);

    // Assert
    verify(applicationDao).findRelatedByApplicationId(1L);
    assertEquals(2, actualFindRelatedResult.size());
    List<Application> getResult = actualFindRelatedResult.get(AssetCodeRelationshipKind.CHILD);
    assertEquals(1, getResult.size());
    Application getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof ImmutableApplication);
    assertEquals("Name", getResult2.name());
    assertEquals("Provenance", getResult2.provenance());
    assertEquals("The characteristics of someone or something", getResult2.description());
    assertEquals(1L, getResult2.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, getResult2.businessCriticality());
    assertEquals(EntityKind.ALL, getResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult2.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, getResult2.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, getResult2.lifecyclePhase());
    assertEquals(RagRating.R, getResult2.overallRating());
    assertFalse(getResult2.externalId().isPresent());
    assertFalse(getResult2.isRemoved());
    assertTrue(actualFindRelatedResult.containsKey(AssetCodeRelationshipKind.SHARING));
  }

  /**
   * Test {@link ApplicationService#findRelated(long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#findRelated(long)}
   */
  @Test
  @DisplayName("Test findRelated(long); when one; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ApplicationService.findRelated(long)"})
  void testFindRelated_whenOne_thenReturnEmpty() {
    // Arrange
    when(applicationDao.findRelatedByApplicationId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    Map<AssetCodeRelationshipKind, List<Application>> actualFindRelatedResult =
        applicationService.findRelated(1L);

    // Assert
    verify(applicationDao).findRelatedByApplicationId(1L);
    assertTrue(actualFindRelatedResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findRelated(long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#findRelated(long)}
   */
  @Test
  @DisplayName("Test findRelated(long); when two; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ApplicationService.findRelated(long)"})
  void testFindRelated_whenTwo_thenReturnEmpty() {
    // Arrange
    ArrayList<Application> applicationList = new ArrayList<>();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findRelatedByApplicationId(anyLong())).thenReturn(applicationList);

    // Act
    Map<AssetCodeRelationshipKind, List<Application>> actualFindRelatedResult =
        applicationService.findRelated(2L);

    // Assert
    verify(applicationDao).findRelatedByApplicationId(2L);
    assertTrue(actualFindRelatedResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findRelated(long)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationService#findRelated(long)}
   */
  @Test
  @DisplayName("Test findRelated(long); when two; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ApplicationService.findRelated(long)"})
  void testFindRelated_whenTwo_thenReturnEmpty2() {
    // Arrange
    ArrayList<Application> applicationList = new ArrayList<>();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());

    Builder applicationKindResult2 =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode2 = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult2 =
        applicationKindResult2
            .assetCode(assetCode2)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode2 = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult2
            .parentAssetCode(parentAssetCode2)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findRelatedByApplicationId(anyLong())).thenReturn(applicationList);

    // Act
    Map<AssetCodeRelationshipKind, List<Application>> actualFindRelatedResult =
        applicationService.findRelated(2L);

    // Assert
    verify(applicationDao).findRelatedByApplicationId(2L);
    assertTrue(actualFindRelatedResult.isEmpty());
  }

  /**
   * Test {@link ApplicationService#findByAssetCode(ExternalIdValue)}.
   *
   * <p>Method under test: {@link ApplicationService#findByAssetCode(ExternalIdValue)}
   */
  @Test
  @DisplayName("Test findByAssetCode(ExternalIdValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationService.findByAssetCode(ExternalIdValue)"})
  void testFindByAssetCode() {
    // Arrange
    when(applicationDao.findByAssetCode(Mockito.<ExternalIdValue>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Application> actualFindByAssetCodeResult =
        applicationService.findByAssetCode(ExternalIdValue.of("42"));

    // Assert
    verify(applicationDao).findByAssetCode(isA(ExternalIdValue.class));
    assertTrue(actualFindByAssetCodeResult.isEmpty());
  }
}
