package org.finos.waltz.service.scenario;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import org.finos.waltz.data.rating_scheme.RatingSchemeDAO;
import org.finos.waltz.data.scenario.ScenarioAxisItemDao;
import org.finos.waltz.data.scenario.ScenarioDao;
import org.finos.waltz.data.scenario.ScenarioRatingItemDao;
import org.finos.waltz.data.tag.TagDao;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.ImmutableApplication.Builder;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.ImmutableRatingScheme;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.model.scenario.ChangeScenarioCommand;
import org.finos.waltz.model.scenario.ImmutableChangeScenarioCommand;
import org.finos.waltz.model.scenario.ImmutableScenario;
import org.finos.waltz.model.scenario.ScenarioRatingItem;
import org.finos.waltz.model.scenario.ScenarioType;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.tag.TagService;
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
class ScenarioRatingItemServiceDiffblueTest {
  @Mock private ApplicationService applicationService;

  @Mock private ChangeLogService changeLogService;

  @Mock private RatingSchemeService ratingSchemeService;

  @Mock private ScenarioRatingItemDao scenarioRatingItemDao;

  @InjectMocks private ScenarioRatingItemService scenarioRatingItemService;

  @Mock private ScenarioService scenarioService;

  /**
   * Test {@link ScenarioRatingItemService#findForScenarioId(long)}.
   *
   * <p>Method under test: {@link ScenarioRatingItemService#findForScenarioId(long)}
   */
  @Test
  @DisplayName("Test findForScenarioId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ScenarioRatingItemService.findForScenarioId(long)"})
  void testFindForScenarioId() {
    // Arrange
    ArrayList<ScenarioRatingItem> scenarioRatingItemList = new ArrayList<>();
    when(scenarioRatingItemDao.findForScenarioId(anyLong())).thenReturn(scenarioRatingItemList);

    // Act
    Collection<ScenarioRatingItem> actualFindForScenarioIdResult =
        scenarioRatingItemService.findForScenarioId(1L);

    // Assert
    verify(scenarioRatingItemDao).findForScenarioId(1L);
    assertTrue(actualFindForScenarioIdResult instanceof List);
    assertTrue(actualFindForScenarioIdResult.isEmpty());
    assertSame(scenarioRatingItemList, actualFindForScenarioIdResult);
  }

  /**
   * Test {@link ScenarioRatingItemService#remove(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ApplicationDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemService#remove(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test remove(ChangeScenarioCommand, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemService.remove(ChangeScenarioCommand, String)"})
  void testRemove_givenChangeLogDaoWriteReturn19088743_thenCallsGetById() {
    // Arrange
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
    when(scenarioRatingItemDao.remove(Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any()))
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

    ApplicationDao appDao = mock(ApplicationDao.class);

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
    when(appDao.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());
    TagDao tagDao = mock(TagDao.class);
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

    TagService tagService = new TagService(tagDao, changeLogService2);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.getById(anyLong()))
        .thenReturn(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(LocalDate.of(1970, 1, 1))
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    ScenarioRatingItemDao scenarioRatingItemDao2 = mock(ScenarioRatingItemDao.class);
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

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao, scenarioAxisItemDao, scenarioRatingItemDao2, changeLogService3);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));

    ScenarioRatingItemService scenarioRatingItemService =
        new ScenarioRatingItemService(
            scenarioRatingItemDao,
            changeLogService,
            applicationService,
            ratingSchemeService,
            scenarioService);

    // Act
    boolean actualRemoveResult =
        scenarioRatingItemService.remove(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(appDao).getById(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).getById(1L);
    verify(scenarioRatingItemDao).remove(isA(ChangeScenarioCommand.class), eq("42"));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link ScenarioRatingItemService#remove(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ApplicationService#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemService#remove(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test remove(ChangeScenarioCommand, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemService.remove(ChangeScenarioCommand, String)"})
  void testRemove_givenChangeLogServiceWriteReturn19088743_thenCallsGetById() {
    // Arrange
    when(scenarioRatingItemDao.remove(Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

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
    when(applicationService.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());
    when(scenarioService.getById(anyLong()))
        .thenReturn(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(LocalDate.of(1970, 1, 1))
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());

    // Act
    boolean actualRemoveResult =
        scenarioRatingItemService.remove(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(scenarioRatingItemDao).remove(isA(ChangeScenarioCommand.class), eq("42"));
    verify(applicationService).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(scenarioService).getById(1L);
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link ScenarioRatingItemService#remove(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ScenarioRatingItemDao} {@link
   *       ScenarioRatingItemDao#remove(ChangeScenarioCommand, String)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemService#remove(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test remove(ChangeScenarioCommand, String); given ScenarioRatingItemDao remove(ChangeScenarioCommand, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemService.remove(ChangeScenarioCommand, String)"})
  void testRemove_givenScenarioRatingItemDaoRemoveReturnFalse_thenReturnFalse() {
    // Arrange
    when(scenarioRatingItemDao.remove(Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act
    boolean actualRemoveResult =
        scenarioRatingItemService.remove(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(scenarioRatingItemDao).remove(isA(ChangeScenarioCommand.class), eq("42"));
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link ScenarioRatingItemService#add(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ApplicationDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemService#add(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test add(ChangeScenarioCommand, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemService.add(ChangeScenarioCommand, String)"})
  void testAdd_givenChangeLogDaoWriteReturn19088743_thenCallsGetById() {
    // Arrange
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
    when(scenarioRatingItemDao.add(Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any()))
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

    ApplicationDao appDao = mock(ApplicationDao.class);

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
    when(appDao.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());
    TagDao tagDao = mock(TagDao.class);
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

    TagService tagService = new TagService(tagDao, changeLogService2);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.getById(anyLong()))
        .thenReturn(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(LocalDate.of(1970, 1, 1))
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    ScenarioRatingItemDao scenarioRatingItemDao2 = mock(ScenarioRatingItemDao.class);
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

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao, scenarioAxisItemDao, scenarioRatingItemDao2, changeLogService3);
    RatingSchemeService ratingSchemeService = new RatingSchemeService(mock(RatingSchemeDAO.class));

    ScenarioRatingItemService scenarioRatingItemService =
        new ScenarioRatingItemService(
            scenarioRatingItemDao,
            changeLogService,
            applicationService,
            ratingSchemeService,
            scenarioService);

    // Act
    boolean actualAddResult =
        scenarioRatingItemService.add(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(appDao).getById(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).getById(1L);
    verify(scenarioRatingItemDao).add(isA(ChangeScenarioCommand.class), eq("42"));
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link ScenarioRatingItemService#add(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ApplicationService#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemService#add(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test add(ChangeScenarioCommand, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemService.add(ChangeScenarioCommand, String)"})
  void testAdd_givenChangeLogServiceWriteReturn19088743_thenCallsGetById() {
    // Arrange
    when(scenarioRatingItemDao.add(Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

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
    when(applicationService.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());
    when(scenarioService.getById(anyLong()))
        .thenReturn(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(LocalDate.of(1970, 1, 1))
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());

    // Act
    boolean actualAddResult =
        scenarioRatingItemService.add(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(scenarioRatingItemDao).add(isA(ChangeScenarioCommand.class), eq("42"));
    verify(applicationService).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(scenarioService).getById(1L);
    assertTrue(actualAddResult);
  }

  /**
   * Test {@link ScenarioRatingItemService#add(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ScenarioRatingItemDao} {@link
   *       ScenarioRatingItemDao#add(ChangeScenarioCommand, String)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemService#add(ChangeScenarioCommand, String)}
   */
  @Test
  @DisplayName(
      "Test add(ChangeScenarioCommand, String); given ScenarioRatingItemDao add(ChangeScenarioCommand, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScenarioRatingItemService.add(ChangeScenarioCommand, String)"})
  void testAdd_givenScenarioRatingItemDaoAddReturnFalse_thenReturnFalse() {
    // Arrange
    when(scenarioRatingItemDao.add(Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act
    boolean actualAddResult =
        scenarioRatingItemService.add(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(scenarioRatingItemDao).add(isA(ChangeScenarioCommand.class), eq("42"));
    assertFalse(actualAddResult);
  }

  /**
   * Test {@link ScenarioRatingItemService#updateRating(ChangeScenarioCommand, String)}.
   *
   * <p>Method under test: {@link ScenarioRatingItemService#updateRating(ChangeScenarioCommand,
   * String)}
   */
  @Test
  @DisplayName("Test updateRating(ChangeScenarioCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScenarioRatingItemService.updateRating(ChangeScenarioCommand, String)"
  })
  void testUpdateRating() {
    // Arrange
    when(scenarioRatingItemDao.updateRating(
            Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

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
    when(applicationService.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    builderResult.addRatings(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    ImmutableRatingScheme.Builder nameResult =
        builderResult
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    when(ratingSchemeService.getById(anyLong()))
        .thenReturn(nameResult.addAllRatings(new ArrayList<>()).build());
    when(scenarioService.getById(anyLong()))
        .thenReturn(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(LocalDate.of(1970, 1, 1))
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());

    // Act
    boolean actualUpdateRatingResult =
        scenarioRatingItemService.updateRating(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(scenarioRatingItemDao).updateRating(isA(ChangeScenarioCommand.class), eq("42"));
    verify(applicationService).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(ratingSchemeService).getById(1L);
    verify(scenarioService).getById(1L);
    assertTrue(actualUpdateRatingResult);
  }

  /**
   * Test {@link ScenarioRatingItemService#updateRating(ChangeScenarioCommand, String)}.
   *
   * <p>Method under test: {@link ScenarioRatingItemService#updateRating(ChangeScenarioCommand,
   * String)}
   */
  @Test
  @DisplayName("Test updateRating(ChangeScenarioCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScenarioRatingItemService.updateRating(ChangeScenarioCommand, String)"
  })
  void testUpdateRating2() {
    // Arrange
    when(scenarioRatingItemDao.updateRating(
            Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

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
    when(applicationService.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    builderResult.addRatings(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    builderResult.addRatings(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    ImmutableRatingScheme.Builder nameResult =
        builderResult
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    when(ratingSchemeService.getById(anyLong()))
        .thenReturn(nameResult.addAllRatings(new ArrayList<>()).build());
    when(scenarioService.getById(anyLong()))
        .thenReturn(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(LocalDate.of(1970, 1, 1))
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());

    // Act
    boolean actualUpdateRatingResult =
        scenarioRatingItemService.updateRating(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(scenarioRatingItemDao).updateRating(isA(ChangeScenarioCommand.class), eq("42"));
    verify(applicationService).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(ratingSchemeService).getById(1L);
    verify(scenarioService).getById(1L);
    assertTrue(actualUpdateRatingResult);
  }

  /**
   * Test {@link ScenarioRatingItemService#updateRating(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ApplicationDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemService#updateRating(ChangeScenarioCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateRating(ChangeScenarioCommand, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScenarioRatingItemService.updateRating(ChangeScenarioCommand, String)"
  })
  void testUpdateRating_givenChangeLogDaoWriteReturn19088743_thenCallsGetById() {
    // Arrange
    ScenarioRatingItemDao scenarioRatingItemDao = mock(ScenarioRatingItemDao.class);
    when(scenarioRatingItemDao.updateRating(
            Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any()))
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

    ApplicationDao appDao = mock(ApplicationDao.class);

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
    when(appDao.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());
    TagDao tagDao = mock(TagDao.class);
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

    TagService tagService = new TagService(tagDao, changeLogService2);

    ApplicationService applicationService =
        new ApplicationService(
            appDao, tagService, mock(EntityAliasDao.class), mock(ApplicationSearchDao.class));

    RatingSchemeDAO ratingSchemeDAO = mock(RatingSchemeDAO.class);

    ImmutableRatingScheme.Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    when(ratingSchemeDAO.getById(anyLong()))
        .thenReturn(nameResult.addAllRatings(new ArrayList<>()).build());
    RatingSchemeService ratingSchemeService = new RatingSchemeService(ratingSchemeDAO);

    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    when(scenarioDao.getById(anyLong()))
        .thenReturn(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(LocalDate.of(1970, 1, 1))
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    ScenarioRatingItemDao scenarioRatingItemDao2 = mock(ScenarioRatingItemDao.class);
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

    ScenarioService scenarioService =
        new ScenarioService(
            scenarioDao, scenarioAxisItemDao, scenarioRatingItemDao2, changeLogService3);

    ScenarioRatingItemService scenarioRatingItemService =
        new ScenarioRatingItemService(
            scenarioRatingItemDao,
            changeLogService,
            applicationService,
            ratingSchemeService,
            scenarioService);

    // Act
    boolean actualUpdateRatingResult =
        scenarioRatingItemService.updateRating(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(appDao).getById(1L);
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(ratingSchemeDAO).getById(1L);
    verify(scenarioDao).getById(1L);
    verify(scenarioRatingItemDao).updateRating(isA(ChangeScenarioCommand.class), eq("42"));
    assertTrue(actualUpdateRatingResult);
  }

  /**
   * Test {@link ScenarioRatingItemService#updateRating(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ApplicationService#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemService#updateRating(ChangeScenarioCommand,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateRating(ChangeScenarioCommand, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScenarioRatingItemService.updateRating(ChangeScenarioCommand, String)"
  })
  void testUpdateRating_givenChangeLogServiceWriteReturn19088743_thenCallsGetById() {
    // Arrange
    when(scenarioRatingItemDao.updateRating(
            Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

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
    when(applicationService.getById(anyLong()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    ImmutableRatingScheme.Builder nameResult =
        ImmutableRatingScheme.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name");
    when(ratingSchemeService.getById(anyLong()))
        .thenReturn(nameResult.addAllRatings(new ArrayList<>()).build());
    when(scenarioService.getById(anyLong()))
        .thenReturn(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(LocalDate.of(1970, 1, 1))
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());

    // Act
    boolean actualUpdateRatingResult =
        scenarioRatingItemService.updateRating(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(scenarioRatingItemDao).updateRating(isA(ChangeScenarioCommand.class), eq("42"));
    verify(applicationService).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(ratingSchemeService).getById(1L);
    verify(scenarioService).getById(1L);
    assertTrue(actualUpdateRatingResult);
  }

  /**
   * Test {@link ScenarioRatingItemService#updateRating(ChangeScenarioCommand, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioRatingItemService#updateRating(ChangeScenarioCommand,
   * String)}
   */
  @Test
  @DisplayName("Test updateRating(ChangeScenarioCommand, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScenarioRatingItemService.updateRating(ChangeScenarioCommand, String)"
  })
  void testUpdateRating_thenReturnFalse() {
    // Arrange
    when(scenarioRatingItemDao.updateRating(
            Mockito.<ChangeScenarioCommand>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act
    boolean actualUpdateRatingResult =
        scenarioRatingItemService.updateRating(
            ImmutableChangeScenarioCommand.builder()
                .appId(1L)
                .columnId(1L)
                .comment("Comment")
                .previousRating("Previous Rating")
                .rating("Rating")
                .ratingSchemeId(1L)
                .rowId(1L)
                .scenarioId(1L)
                .build(),
            "42");

    // Assert
    verify(scenarioRatingItemDao).updateRating(isA(ChangeScenarioCommand.class), eq("42"));
    assertFalse(actualUpdateRatingResult);
  }
}
