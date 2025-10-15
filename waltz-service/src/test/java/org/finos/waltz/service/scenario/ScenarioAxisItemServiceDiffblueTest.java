package org.finos.waltz.service.scenario;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.scenario.ScenarioAxisItemDao;
import org.finos.waltz.model.AxisOrientation;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.scenario.ScenarioAxisItem;
import org.finos.waltz.service.changelog.ChangeLogService;
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
class ScenarioAxisItemServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private ScenarioAxisItemDao scenarioAxisItemDao;

  @InjectMocks private ScenarioAxisItemService scenarioAxisItemService;

  /**
   * Test {@link ScenarioAxisItemService#findForScenarioId(long)}.
   *
   * <p>Method under test: {@link ScenarioAxisItemService#findForScenarioId(long)}
   */
  @Test
  @DisplayName("Test findForScenarioId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ScenarioAxisItemService.findForScenarioId(long)"})
  void testFindForScenarioId() {
    // Arrange
    ArrayList<ScenarioAxisItem> scenarioAxisItemList = new ArrayList<>();
    when(scenarioAxisItemDao.findForScenarioId(anyLong())).thenReturn(scenarioAxisItemList);

    // Act
    Collection<ScenarioAxisItem> actualFindForScenarioIdResult =
        scenarioAxisItemService.findForScenarioId(1L);

    // Assert
    verify(scenarioAxisItemDao).findForScenarioId(1L);
    assertTrue(actualFindForScenarioIdResult instanceof List);
    assertTrue(actualFindForScenarioIdResult.isEmpty());
    assertSame(scenarioAxisItemList, actualFindForScenarioIdResult);
  }

  /**
   * Test {@link ScenarioAxisItemService#loadAxis(long, AxisOrientation)}.
   *
   * <p>Method under test: {@link ScenarioAxisItemService#loadAxis(long, AxisOrientation)}
   */
  @Test
  @DisplayName("Test loadAxis(long, AxisOrientation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ScenarioAxisItemService.loadAxis(long, AxisOrientation)"})
  void testLoadAxis() {
    // Arrange
    ArrayList<ScenarioAxisItem> scenarioAxisItemList = new ArrayList<>();
    when(scenarioAxisItemDao.findForScenarioAndOrientation(
            anyLong(), Mockito.<AxisOrientation>any()))
        .thenReturn(scenarioAxisItemList);

    // Act
    Collection<ScenarioAxisItem> actualLoadAxisResult =
        scenarioAxisItemService.loadAxis(1L, AxisOrientation.ROW);

    // Assert
    verify(scenarioAxisItemDao).findForScenarioAndOrientation(1L, AxisOrientation.ROW);
    assertTrue(actualLoadAxisResult instanceof List);
    assertTrue(actualLoadAxisResult.isEmpty());
    assertSame(scenarioAxisItemList, actualLoadAxisResult);
  }

  /**
   * Test {@link ScenarioAxisItemService#addAxisItem(long, AxisOrientation, EntityReference,
   * Integer, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemService#addAxisItem(long, AxisOrientation,
   * EntityReference, Integer, String)}
   */
  @Test
  @DisplayName(
      "Test addAxisItem(long, AxisOrientation, EntityReference, Integer, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ScenarioAxisItemService.addAxisItem(long, AxisOrientation, EntityReference, Integer, String)"
  })
  void testAddAxisItem_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.add(
            anyLong(),
            Mockito.<AxisOrientation>any(),
            Mockito.<EntityReference>any(),
            Mockito.<Integer>any()))
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

    ScenarioAxisItemService scenarioAxisItemService =
        new ScenarioAxisItemService(scenarioAxisItemDao, changeLogService);

    // Act
    Boolean actualAddAxisItemResult =
        scenarioAxisItemService.addAxisItem(
            1L,
            AxisOrientation.ROW,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1,
            "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioAxisItemDao)
        .add(eq(1L), eq(AxisOrientation.ROW), isA(EntityReference.class), eq(1));
    assertTrue(actualAddAxisItemResult);
  }

  /**
   * Test {@link ScenarioAxisItemService#addAxisItem(long, AxisOrientation, EntityReference,
   * Integer, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemService#addAxisItem(long, AxisOrientation,
   * EntityReference, Integer, String)}
   */
  @Test
  @DisplayName(
      "Test addAxisItem(long, AxisOrientation, EntityReference, Integer, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ScenarioAxisItemService.addAxisItem(long, AxisOrientation, EntityReference, Integer, String)"
  })
  void testAddAxisItem_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    when(scenarioAxisItemDao.add(
            anyLong(),
            Mockito.<AxisOrientation>any(),
            Mockito.<EntityReference>any(),
            Mockito.<Integer>any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualAddAxisItemResult =
        scenarioAxisItemService.addAxisItem(
            1L,
            AxisOrientation.ROW,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1,
            "42");

    // Assert
    verify(scenarioAxisItemDao)
        .add(eq(1L), eq(AxisOrientation.ROW), isA(EntityReference.class), eq(1));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualAddAxisItemResult);
  }

  /**
   * Test {@link ScenarioAxisItemService#addAxisItem(long, AxisOrientation, EntityReference,
   * Integer, String)}.
   *
   * <ul>
   *   <li>Given {@link ScenarioAxisItemDao} {@link ScenarioAxisItemDao#add(long, AxisOrientation,
   *       EntityReference, Integer)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemService#addAxisItem(long, AxisOrientation,
   * EntityReference, Integer, String)}
   */
  @Test
  @DisplayName(
      "Test addAxisItem(long, AxisOrientation, EntityReference, Integer, String); given ScenarioAxisItemDao add(long, AxisOrientation, EntityReference, Integer) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ScenarioAxisItemService.addAxisItem(long, AxisOrientation, EntityReference, Integer, String)"
  })
  void testAddAxisItem_givenScenarioAxisItemDaoAddReturnFalse_thenReturnFalse() {
    // Arrange
    when(scenarioAxisItemDao.add(
            anyLong(),
            Mockito.<AxisOrientation>any(),
            Mockito.<EntityReference>any(),
            Mockito.<Integer>any()))
        .thenReturn(false);

    // Act
    Boolean actualAddAxisItemResult =
        scenarioAxisItemService.addAxisItem(
            1L,
            AxisOrientation.ROW,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1,
            "42");

    // Assert
    verify(scenarioAxisItemDao)
        .add(eq(1L), eq(AxisOrientation.ROW), isA(EntityReference.class), eq(1));
    assertFalse(actualAddAxisItemResult);
  }

  /**
   * Test {@link ScenarioAxisItemService#removeAxisItem(long, AxisOrientation, EntityReference,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemService#removeAxisItem(long, AxisOrientation,
   * EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test removeAxisItem(long, AxisOrientation, EntityReference, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ScenarioAxisItemService.removeAxisItem(long, AxisOrientation, EntityReference, String)"
  })
  void testRemoveAxisItem_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.remove(
            anyLong(), Mockito.<AxisOrientation>any(), Mockito.<EntityReference>any()))
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

    ScenarioAxisItemService scenarioAxisItemService =
        new ScenarioAxisItemService(scenarioAxisItemDao, changeLogService);

    // Act
    Boolean actualRemoveAxisItemResult =
        scenarioAxisItemService.removeAxisItem(
            1L,
            AxisOrientation.ROW,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioAxisItemDao).remove(eq(1L), eq(AxisOrientation.ROW), isA(EntityReference.class));
    assertTrue(actualRemoveAxisItemResult);
  }

  /**
   * Test {@link ScenarioAxisItemService#removeAxisItem(long, AxisOrientation, EntityReference,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemService#removeAxisItem(long, AxisOrientation,
   * EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test removeAxisItem(long, AxisOrientation, EntityReference, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ScenarioAxisItemService.removeAxisItem(long, AxisOrientation, EntityReference, String)"
  })
  void testRemoveAxisItem_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    when(scenarioAxisItemDao.remove(
            anyLong(), Mockito.<AxisOrientation>any(), Mockito.<EntityReference>any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualRemoveAxisItemResult =
        scenarioAxisItemService.removeAxisItem(
            1L,
            AxisOrientation.ROW,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "42");

    // Assert
    verify(scenarioAxisItemDao).remove(eq(1L), eq(AxisOrientation.ROW), isA(EntityReference.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveAxisItemResult);
  }

  /**
   * Test {@link ScenarioAxisItemService#removeAxisItem(long, AxisOrientation, EntityReference,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link ScenarioAxisItemDao} {@link ScenarioAxisItemDao#remove(long,
   *       AxisOrientation, EntityReference)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemService#removeAxisItem(long, AxisOrientation,
   * EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test removeAxisItem(long, AxisOrientation, EntityReference, String); given ScenarioAxisItemDao remove(long, AxisOrientation, EntityReference) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ScenarioAxisItemService.removeAxisItem(long, AxisOrientation, EntityReference, String)"
  })
  void testRemoveAxisItem_givenScenarioAxisItemDaoRemoveReturnFalse_thenReturnFalse() {
    // Arrange
    when(scenarioAxisItemDao.remove(
            anyLong(), Mockito.<AxisOrientation>any(), Mockito.<EntityReference>any()))
        .thenReturn(false);

    // Act
    Boolean actualRemoveAxisItemResult =
        scenarioAxisItemService.removeAxisItem(
            1L,
            AxisOrientation.ROW,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "42");

    // Assert
    verify(scenarioAxisItemDao).remove(eq(1L), eq(AxisOrientation.ROW), isA(EntityReference.class));
    assertFalse(actualRemoveAxisItemResult);
  }

  /**
   * Test {@link ScenarioAxisItemService#reorderAxis(long, AxisOrientation, List, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemService#reorderAxis(long, AxisOrientation, List,
   * String)}
   */
  @Test
  @DisplayName(
      "Test reorderAxis(long, AxisOrientation, List, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int[] ScenarioAxisItemService.reorderAxis(long, AxisOrientation, List, String)"
  })
  void testReorderAxis_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.reorder(
            anyLong(), Mockito.<AxisOrientation>any(), Mockito.<List<Long>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

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

    ScenarioAxisItemService scenarioAxisItemService =
        new ScenarioAxisItemService(scenarioAxisItemDao, changeLogService);

    // Act
    int[] actualReorderAxisResult =
        scenarioAxisItemService.reorderAxis(1L, AxisOrientation.ROW, new ArrayList<>(), "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioAxisItemDao).reorder(eq(1L), eq(AxisOrientation.ROW), isA(List.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualReorderAxisResult);
  }

  /**
   * Test {@link ScenarioAxisItemService#reorderAxis(long, AxisOrientation, List, String)}.
   *
   * <ul>
   *   <li>Given fifteen.
   *   <li>When {@link ArrayList#ArrayList()} add fifteen.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemService#reorderAxis(long, AxisOrientation, List,
   * String)}
   */
  @Test
  @DisplayName(
      "Test reorderAxis(long, AxisOrientation, List, String); given fifteen; when ArrayList() add fifteen; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int[] ScenarioAxisItemService.reorderAxis(long, AxisOrientation, List, String)"
  })
  void testReorderAxis_givenFifteen_whenArrayListAddFifteen_thenCallsWrite() {
    // Arrange
    when(scenarioAxisItemDao.reorder(
            anyLong(), Mockito.<AxisOrientation>any(), Mockito.<List<Long>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ArrayList<Long> orderedIds = new ArrayList<>();
    orderedIds.add(15L);
    orderedIds.add(1L);

    // Act
    int[] actualReorderAxisResult =
        scenarioAxisItemService.reorderAxis(1L, AxisOrientation.ROW, orderedIds, "42");

    // Assert
    verify(scenarioAxisItemDao).reorder(eq(1L), eq(AxisOrientation.ROW), isA(List.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualReorderAxisResult);
  }

  /**
   * Test {@link ScenarioAxisItemService#reorderAxis(long, AxisOrientation, List, String)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemService#reorderAxis(long, AxisOrientation, List,
   * String)}
   */
  @Test
  @DisplayName(
      "Test reorderAxis(long, AxisOrientation, List, String); given one; when ArrayList() add one; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int[] ScenarioAxisItemService.reorderAxis(long, AxisOrientation, List, String)"
  })
  void testReorderAxis_givenOne_whenArrayListAddOne_thenCallsWrite() {
    // Arrange
    when(scenarioAxisItemDao.reorder(
            anyLong(), Mockito.<AxisOrientation>any(), Mockito.<List<Long>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ArrayList<Long> orderedIds = new ArrayList<>();
    orderedIds.add(1L);

    // Act
    int[] actualReorderAxisResult =
        scenarioAxisItemService.reorderAxis(1L, AxisOrientation.ROW, orderedIds, "42");

    // Assert
    verify(scenarioAxisItemDao).reorder(eq(1L), eq(AxisOrientation.ROW), isA(List.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualReorderAxisResult);
  }

  /**
   * Test {@link ScenarioAxisItemService#reorderAxis(long, AxisOrientation, List, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ScenarioAxisItemService#reorderAxis(long, AxisOrientation, List,
   * String)}
   */
  @Test
  @DisplayName(
      "Test reorderAxis(long, AxisOrientation, List, String); when ArrayList(); then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int[] ScenarioAxisItemService.reorderAxis(long, AxisOrientation, List, String)"
  })
  void testReorderAxis_whenArrayList_thenCallsWrite() {
    // Arrange
    when(scenarioAxisItemDao.reorder(
            anyLong(), Mockito.<AxisOrientation>any(), Mockito.<List<Long>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    int[] actualReorderAxisResult =
        scenarioAxisItemService.reorderAxis(1L, AxisOrientation.ROW, new ArrayList<>(), "42");

    // Assert
    verify(scenarioAxisItemDao).reorder(eq(1L), eq(AxisOrientation.ROW), isA(List.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualReorderAxisResult);
  }
}
