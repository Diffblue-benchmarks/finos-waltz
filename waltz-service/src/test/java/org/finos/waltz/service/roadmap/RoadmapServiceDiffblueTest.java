package org.finos.waltz.service.roadmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.entity_relationship.EntityRelationshipDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.roadmap.RoadmapDao;
import org.finos.waltz.data.roadmap.RoadmapSearchDao;
import org.finos.waltz.data.scenario.ScenarioDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_relationship.EntityRelationship;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.roadmap.ImmutableRoadmap;
import org.finos.waltz.model.roadmap.ImmutableRoadmapCreateCommand;
import org.finos.waltz.model.roadmap.ImmutableRoadmapCreateCommand.Builder;
import org.finos.waltz.model.roadmap.Roadmap;
import org.finos.waltz.model.roadmap.RoadmapAndScenarioOverview;
import org.finos.waltz.model.roadmap.RoadmapCreateCommand;
import org.finos.waltz.model.scenario.ImmutableScenario;
import org.finos.waltz.model.scenario.Scenario;
import org.finos.waltz.model.scenario.ScenarioType;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
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
class RoadmapServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private EntityRelationshipDao entityRelationshipDao;

  @Mock private RoadmapDao roadmapDao;

  @Mock private RoadmapSearchDao roadmapSearchDao;

  @InjectMocks private RoadmapService roadmapService;

  @Mock private ScenarioDao scenarioDao;

  /**
   * Test {@link RoadmapService#getById(long)}.
   *
   * <p>Method under test: {@link RoadmapService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Roadmap RoadmapService.getById(long)"})
  void testGetById() {
    // Arrange
    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);
    when(roadmapDao.getById(anyLong()))
        .thenReturn(
            ratingSchemeIdResult
                .rowType(
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
    Roadmap actualById = roadmapService.getById(1L);

    // Assert
    verify(roadmapDao).getById(1L);
    EntityReference columnTypeResult = actualById.columnType();
    assertTrue(columnTypeResult instanceof ImmutableEntityReference);
    EntityReference rowTypeResult = actualById.rowType();
    assertTrue(rowTypeResult instanceof ImmutableEntityReference);
    assertTrue(actualById instanceof ImmutableRoadmap);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", columnTypeResult.description());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1L, columnTypeResult.id());
    assertEquals(1L, actualById.ratingSchemeId());
    assertEquals(EntityKind.ALL, columnTypeResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualById.entityLifecycleStatus());
    assertEquals(EntityLifecycleStatus.ACTIVE, columnTypeResult.entityLifecycleStatus());
    assertEquals(columnTypeResult, rowTypeResult);
    assertSame(ofResult, actualById.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link RoadmapService#createRoadmap(RoadmapCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#createRoadmap(RoadmapCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test createRoadmap(RoadmapCreateCommand, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long RoadmapService.createRoadmap(RoadmapCreateCommand, String)"})
  void testCreateRoadmap_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.createRoadmap(
            Mockito.<String>any(),
            anyLong(),
            Mockito.<EntityReference>any(),
            Mockito.<EntityReference>any(),
            Mockito.<String>any()))
        .thenReturn(1L);

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

    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.create(Mockito.<EntityRelationship>any())).thenReturn(true);

    RoadmapService roadmapService =
        new RoadmapService(
            roadmapDao,
            mock(RoadmapSearchDao.class),
            mock(ScenarioDao.class),
            changeLogService,
            entityRelationshipDao);

    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);

    // Act
    Long actualCreateRoadmapResult =
        roadmapService.createRoadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build(),
            "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityRelationshipDao).create(isA(EntityRelationship.class));
    verify(roadmapDao)
        .createRoadmap(
            eq("Name"), eq(1L), isA(EntityReference.class), isA(EntityReference.class), eq("42"));
    assertEquals(1L, actualCreateRoadmapResult.longValue());
  }

  /**
   * Test {@link RoadmapService#createRoadmap(RoadmapCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#createRoadmap(RoadmapCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test createRoadmap(RoadmapCreateCommand, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long RoadmapService.createRoadmap(RoadmapCreateCommand, String)"})
  void testCreateRoadmap_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    when(roadmapDao.createRoadmap(
            Mockito.<String>any(),
            anyLong(),
            Mockito.<EntityReference>any(),
            Mockito.<EntityReference>any(),
            Mockito.<String>any()))
        .thenReturn(1L);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(entityRelationshipDao.create(Mockito.<EntityRelationship>any())).thenReturn(true);

    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);

    // Act
    Long actualCreateRoadmapResult =
        roadmapService.createRoadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build(),
            "42");

    // Assert
    verify(entityRelationshipDao).create(isA(EntityRelationship.class));
    verify(roadmapDao)
        .createRoadmap(
            eq("Name"), eq(1L), isA(EntityReference.class), isA(EntityReference.class), eq("42"));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualCreateRoadmapResult.longValue());
  }

  /**
   * Test {@link RoadmapService#createRoadmap(RoadmapCreateCommand, String)}.
   *
   * <ul>
   *   <li>Then return longValue is minus three.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#createRoadmap(RoadmapCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test createRoadmap(RoadmapCreateCommand, String); then return longValue is minus three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long RoadmapService.createRoadmap(RoadmapCreateCommand, String)"})
  void testCreateRoadmap_thenReturnLongValueIsMinusThree() {
    // Arrange
    when(roadmapDao.createRoadmap(
            Mockito.<String>any(),
            anyLong(),
            Mockito.<EntityReference>any(),
            Mockito.<EntityReference>any(),
            Mockito.<String>any()))
        .thenReturn(-3L);
    when(entityRelationshipDao.create(Mockito.<EntityRelationship>any())).thenReturn(true);

    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);

    // Act
    Long actualCreateRoadmapResult =
        roadmapService.createRoadmap(
            ratingSchemeIdResult
                .rowType(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build(),
            "42");

    // Assert
    verify(entityRelationshipDao).create(isA(EntityRelationship.class));
    verify(roadmapDao)
        .createRoadmap(
            eq("Name"), eq(1L), isA(EntityReference.class), isA(EntityReference.class), eq("42"));
    assertEquals(-3L, actualCreateRoadmapResult.longValue());
  }

  /**
   * Test {@link RoadmapService#findRoadmapsBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#findRoadmapsBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findRoadmapsBySelector(IdSelectionOptions); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection RoadmapService.findRoadmapsBySelector(IdSelectionOptions)"})
  void testFindRoadmapsBySelector_thenReturnList() {
    // Arrange
    ArrayList<Roadmap> roadmapList = new ArrayList<>();
    when(roadmapDao.findRoadmapsBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(roadmapList);

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
    Collection<Roadmap> actualFindRoadmapsBySelectorResult =
        roadmapService.findRoadmapsBySelector(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(roadmapDao).findRoadmapsBySelector(isA(Select.class));
    assertTrue(actualFindRoadmapsBySelectorResult instanceof List);
    assertTrue(actualFindRoadmapsBySelectorResult.isEmpty());
    assertSame(roadmapList, actualFindRoadmapsBySelectorResult);
  }

  /**
   * Test {@link RoadmapService#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RoadmapService.updateDescription(long, String, String)"})
  void testUpdateDescription_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
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

    RoadmapService roadmapService =
        new RoadmapService(
            roadmapDao,
            mock(RoadmapSearchDao.class),
            mock(ScenarioDao.class),
            changeLogService,
            mock(EntityRelationshipDao.class));

    // Act
    Boolean actualUpdateDescriptionResult =
        roadmapService.updateDescription(1L, "New Description", "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(roadmapDao).updateDescription(1L, "New Description", "42");
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link RoadmapService#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RoadmapService.updateDescription(long, String, String)"})
  void testUpdateDescription_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    when(roadmapDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateDescriptionResult =
        roadmapService.updateDescription(1L, "New Description", "42");

    // Assert
    verify(roadmapDao).updateDescription(1L, "New Description", "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link RoadmapService#updateDescription(long, String, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#updateDescription(long, String, String)}
   */
  @Test
  @DisplayName("Test updateDescription(long, String, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RoadmapService.updateDescription(long, String, String)"})
  void testUpdateDescription_thenReturnFalse() {
    // Arrange
    when(roadmapDao.updateDescription(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act
    Boolean actualUpdateDescriptionResult =
        roadmapService.updateDescription(1L, "New Description", "42");

    // Assert
    verify(roadmapDao).updateDescription(1L, "New Description", "42");
    assertFalse(actualUpdateDescriptionResult);
  }

  /**
   * Test {@link RoadmapService#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RoadmapService.updateName(long, String, String)"})
  void testUpdateName_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
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

    RoadmapService roadmapService =
        new RoadmapService(
            roadmapDao,
            mock(RoadmapSearchDao.class),
            mock(ScenarioDao.class),
            changeLogService,
            mock(EntityRelationshipDao.class));

    // Act
    Boolean actualUpdateNameResult = roadmapService.updateName(1L, "New Name", "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(roadmapDao).updateName(1L, "New Name", "42");
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Test {@link RoadmapService#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RoadmapService.updateName(long, String, String)"})
  void testUpdateName_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    when(roadmapDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateNameResult = roadmapService.updateName(1L, "New Name", "42");

    // Assert
    verify(roadmapDao).updateName(1L, "New Name", "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateNameResult);
  }

  /**
   * Test {@link RoadmapService#updateName(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link RoadmapDao} {@link RoadmapDao#updateName(long, String, String)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#updateName(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test updateName(long, String, String); given RoadmapDao updateName(long, String, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean RoadmapService.updateName(long, String, String)"})
  void testUpdateName_givenRoadmapDaoUpdateNameReturnFalse_thenReturnFalse() {
    // Arrange
    when(roadmapDao.updateName(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act
    Boolean actualUpdateNameResult = roadmapService.updateName(1L, "New Name", "42");

    // Assert
    verify(roadmapDao).updateName(1L, "New Name", "42");
    assertFalse(actualUpdateNameResult);
  }

  /**
   * Test {@link RoadmapService#updateLifecycleStatus(long, EntityLifecycleStatus, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#updateLifecycleStatus(long, EntityLifecycleStatus,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateLifecycleStatus(long, EntityLifecycleStatus, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean RoadmapService.updateLifecycleStatus(long, EntityLifecycleStatus, String)"
  })
  void testUpdateLifecycleStatus_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    RoadmapDao roadmapDao = mock(RoadmapDao.class);
    when(roadmapDao.updateLifecycleStatus(
            anyLong(), Mockito.<EntityLifecycleStatus>any(), Mockito.<String>any()))
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

    RoadmapService roadmapService =
        new RoadmapService(
            roadmapDao,
            mock(RoadmapSearchDao.class),
            mock(ScenarioDao.class),
            changeLogService,
            mock(EntityRelationshipDao.class));

    // Act
    Boolean actualUpdateLifecycleStatusResult =
        roadmapService.updateLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(roadmapDao).updateLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");
    assertTrue(actualUpdateLifecycleStatusResult);
  }

  /**
   * Test {@link RoadmapService#updateLifecycleStatus(long, EntityLifecycleStatus, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#updateLifecycleStatus(long, EntityLifecycleStatus,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateLifecycleStatus(long, EntityLifecycleStatus, String); then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean RoadmapService.updateLifecycleStatus(long, EntityLifecycleStatus, String)"
  })
  void testUpdateLifecycleStatus_thenCallsWrite() {
    // Arrange
    when(roadmapDao.updateLifecycleStatus(
            anyLong(), Mockito.<EntityLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualUpdateLifecycleStatusResult =
        roadmapService.updateLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(roadmapDao).updateLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateLifecycleStatusResult);
  }

  /**
   * Test {@link RoadmapService#updateLifecycleStatus(long, EntityLifecycleStatus, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#updateLifecycleStatus(long, EntityLifecycleStatus,
   * String)}
   */
  @Test
  @DisplayName(
      "Test updateLifecycleStatus(long, EntityLifecycleStatus, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean RoadmapService.updateLifecycleStatus(long, EntityLifecycleStatus, String)"
  })
  void testUpdateLifecycleStatus_thenReturnFalse() {
    // Arrange
    when(roadmapDao.updateLifecycleStatus(
            anyLong(), Mockito.<EntityLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act
    Boolean actualUpdateLifecycleStatusResult =
        roadmapService.updateLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");

    // Assert
    verify(roadmapDao).updateLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE, "42");
    assertFalse(actualUpdateLifecycleStatusResult);
  }

  /**
   * Test {@link RoadmapService#addScenario(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#addScenario(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test addScenario(long, String, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Scenario RoadmapService.addScenario(long, String, String)"})
  void testAddScenario_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ScenarioDao scenarioDao = mock(ScenarioDao.class);
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(scenarioDao.add(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(effectiveDate)
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
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

    RoadmapService roadmapService =
        new RoadmapService(
            mock(RoadmapDao.class),
            mock(RoadmapSearchDao.class),
            scenarioDao,
            changeLogService,
            mock(EntityRelationshipDao.class));

    // Act
    Scenario actualAddScenarioResult = roadmapService.addScenario(1L, "Name", "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioDao).add(1L, "Name", "42");
    assertTrue(actualAddScenarioResult instanceof ImmutableScenario);
    LocalDate effectiveDateResult = actualAddScenarioResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualAddScenarioResult.lastUpdatedBy());
    assertEquals("Name", actualAddScenarioResult.name());
    assertEquals(
        "The characteristics of someone or something", actualAddScenarioResult.description());
    assertEquals(0, actualAddScenarioResult.position());
    assertEquals(1L, actualAddScenarioResult.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualAddScenarioResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualAddScenarioResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualAddScenarioResult.scenarioType());
    assertSame(ofResult, actualAddScenarioResult.lastUpdatedAt().toLocalDate());
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link RoadmapService#addScenario(long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link RoadmapDao}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#addScenario(long, String, String)}
   */
  @Test
  @DisplayName(
      "Test addScenario(long, String, String); given RoadmapDao; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Scenario RoadmapService.addScenario(long, String, String)"})
  void testAddScenario_givenRoadmapDao_thenCallsWrite() {
    // Arrange
    LocalDate effectiveDate = LocalDate.of(1970, 1, 1);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(scenarioDao.add(anyLong(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(
            ImmutableScenario.builder()
                .description("The characteristics of someone or something")
                .effectiveDate(effectiveDate)
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .id(1L)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .releaseStatus(ReleaseLifecycleStatus.DRAFT)
                .roadmapId(1L)
                .scenarioType(ScenarioType.TARGET)
                .build());
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Scenario actualAddScenarioResult = roadmapService.addScenario(1L, "Name", "42");

    // Assert
    verify(scenarioDao).add(1L, "Name", "42");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualAddScenarioResult instanceof ImmutableScenario);
    LocalDate effectiveDateResult = actualAddScenarioResult.effectiveDate();
    assertEquals("1970-01-01", effectiveDateResult.toString());
    assertEquals("2020-03-01", actualAddScenarioResult.lastUpdatedBy());
    assertEquals("Name", actualAddScenarioResult.name());
    assertEquals(
        "The characteristics of someone or something", actualAddScenarioResult.description());
    assertEquals(0, actualAddScenarioResult.position());
    assertEquals(1L, actualAddScenarioResult.roadmapId());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualAddScenarioResult.entityLifecycleStatus());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualAddScenarioResult.releaseStatus());
    assertEquals(ScenarioType.TARGET, actualAddScenarioResult.scenarioType());
    assertSame(ofResult, actualAddScenarioResult.lastUpdatedAt().toLocalDate());
    assertSame(effectiveDate, effectiveDateResult);
  }

  /**
   * Test {@link RoadmapService#findAllRoadmapsAndScenarios()}.
   *
   * <p>Method under test: {@link RoadmapService#findAllRoadmapsAndScenarios()}
   */
  @Test
  @DisplayName("Test findAllRoadmapsAndScenarios()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection RoadmapService.findAllRoadmapsAndScenarios()"})
  void testFindAllRoadmapsAndScenarios() {
    // Arrange
    ArrayList<RoadmapAndScenarioOverview> roadmapAndScenarioOverviewList = new ArrayList<>();
    when(roadmapDao.findAllRoadmapsAndScenarios()).thenReturn(roadmapAndScenarioOverviewList);

    // Act
    Collection<RoadmapAndScenarioOverview> actualFindAllRoadmapsAndScenariosResult =
        roadmapService.findAllRoadmapsAndScenarios();

    // Assert
    verify(roadmapDao).findAllRoadmapsAndScenarios();
    assertTrue(actualFindAllRoadmapsAndScenariosResult instanceof List);
    assertTrue(actualFindAllRoadmapsAndScenariosResult.isEmpty());
    assertSame(roadmapAndScenarioOverviewList, actualFindAllRoadmapsAndScenariosResult);
  }

  /**
   * Test {@link RoadmapService#findRoadmapsAndScenariosByRatedEntity(EntityReference)}.
   *
   * <p>Method under test: {@link
   * RoadmapService#findRoadmapsAndScenariosByRatedEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findRoadmapsAndScenariosByRatedEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection RoadmapService.findRoadmapsAndScenariosByRatedEntity(EntityReference)"
  })
  void testFindRoadmapsAndScenariosByRatedEntity() {
    // Arrange
    ArrayList<RoadmapAndScenarioOverview> roadmapAndScenarioOverviewList = new ArrayList<>();
    when(roadmapDao.findRoadmapsAndScenariosByRatedEntity(Mockito.<EntityReference>any()))
        .thenReturn(roadmapAndScenarioOverviewList);

    // Act
    Collection<RoadmapAndScenarioOverview> actualFindRoadmapsAndScenariosByRatedEntityResult =
        roadmapService.findRoadmapsAndScenariosByRatedEntity(null);

    // Assert
    verify(roadmapDao).findRoadmapsAndScenariosByRatedEntity(isNull());
    assertTrue(actualFindRoadmapsAndScenariosByRatedEntityResult instanceof List);
    assertTrue(actualFindRoadmapsAndScenariosByRatedEntityResult.isEmpty());
    assertSame(roadmapAndScenarioOverviewList, actualFindRoadmapsAndScenariosByRatedEntityResult);
  }

  /**
   * Test {@link RoadmapService#findRoadmapsAndScenariosByFormalRelationship(EntityReference)}.
   *
   * <p>Method under test: {@link
   * RoadmapService#findRoadmapsAndScenariosByFormalRelationship(EntityReference)}
   */
  @Test
  @DisplayName("Test findRoadmapsAndScenariosByFormalRelationship(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection RoadmapService.findRoadmapsAndScenariosByFormalRelationship(EntityReference)"
  })
  void testFindRoadmapsAndScenariosByFormalRelationship() {
    // Arrange
    ArrayList<RoadmapAndScenarioOverview> roadmapAndScenarioOverviewList = new ArrayList<>();
    when(roadmapDao.findRoadmapsAndScenariosByFormalRelationship(Mockito.<EntityReference>any()))
        .thenReturn(roadmapAndScenarioOverviewList);

    // Act
    Collection<RoadmapAndScenarioOverview>
        actualFindRoadmapsAndScenariosByFormalRelationshipResult =
            roadmapService.findRoadmapsAndScenariosByFormalRelationship(null);

    // Assert
    verify(roadmapDao).findRoadmapsAndScenariosByFormalRelationship(isNull());
    assertTrue(actualFindRoadmapsAndScenariosByFormalRelationshipResult instanceof List);
    assertTrue(actualFindRoadmapsAndScenariosByFormalRelationshipResult.isEmpty());
    assertSame(
        roadmapAndScenarioOverviewList, actualFindRoadmapsAndScenariosByFormalRelationshipResult);
  }

  /**
   * Test {@link RoadmapService#search(EntitySearchOptions)} with {@code options}.
   *
   * <p>Method under test: {@link RoadmapService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions) with 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RoadmapService.search(EntitySearchOptions)"})
  void testSearchWithOptions() {
    // Arrange
    when(roadmapSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(new ArrayList<>());

    // Act
    List<Roadmap> actualSearchResult = roadmapService.search((EntitySearchOptions) null);

    // Assert
    verify(roadmapSearchDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link RoadmapService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#search(String)}
   */
  @Test
  @DisplayName("Test search(String) with 'query'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RoadmapService.search(String)"})
  void testSearchWithQuery_thenReturnEmpty() {
    // Arrange
    when(roadmapSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityReference> actualSearchResult = roadmapService.search("Query");

    // Assert
    verify(roadmapSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link RoadmapService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#search(String)}
   */
  @Test
  @DisplayName("Test search(String) with 'query'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RoadmapService.search(String)"})
  void testSearchWithQuery_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Roadmap> roadmapList = new ArrayList<>();

    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);
    roadmapList.add(
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(roadmapSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(roadmapList);

    // Act
    List<EntityReference> actualSearchResult = roadmapService.search("Query");

    // Assert
    verify(roadmapSearchDao).search(isA(EntitySearchOptions.class));
    assertEquals(1, actualSearchResult.size());
    EntityReference getResult = actualSearchResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ROADMAP, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
  }

  /**
   * Test {@link RoadmapService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapService#search(String)}
   */
  @Test
  @DisplayName("Test search(String) with 'query'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RoadmapService.search(String)"})
  void testSearchWithQuery_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Roadmap> roadmapList = new ArrayList<>();

    ImmutableRoadmap.Builder builderResult = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult =
        builderResult
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);
    roadmapList.add(
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    ImmutableRoadmap.Builder builderResult2 = ImmutableRoadmap.builder();

    ImmutableRoadmap.Builder ratingSchemeIdResult2 =
        builderResult2
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);
    roadmapList.add(
        ratingSchemeIdResult2
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(roadmapSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(roadmapList);

    // Act
    List<EntityReference> actualSearchResult = roadmapService.search("Query");

    // Assert
    verify(roadmapSearchDao).search(isA(EntitySearchOptions.class));
    assertEquals(2, actualSearchResult.size());
    EntityReference getResult = actualSearchResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityReference);
    EntityReference getResult2 = actualSearchResult.get(1);
    assertTrue(getResult2 instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ROADMAP, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertEquals(getResult, getResult2);
  }
}
