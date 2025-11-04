package org.finos.waltz.service.scenario;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.scenario.ScenarioAxisItem;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ScenarioAxisItemServiceDiffblueTest {
  /**
   * Method under test: {@link ScenarioAxisItemService#findForScenarioId(long)}
   */
  @Test
  void testFindForScenarioId() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    ArrayList<ScenarioAxisItem> scenarioAxisItemList = new ArrayList<>();
    when(scenarioAxisItemDao.findForScenarioId(anyLong())).thenReturn(scenarioAxisItemList);

    // Act
    Collection<ScenarioAxisItem> actualFindForScenarioIdResult = (new ScenarioAxisItemService(scenarioAxisItemDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findForScenarioId(1L);

    // Assert
    verify(scenarioAxisItemDao).findForScenarioId(eq(1L));
    assertTrue(actualFindForScenarioIdResult instanceof List);
    assertTrue(actualFindForScenarioIdResult.isEmpty());
    assertSame(scenarioAxisItemList, actualFindForScenarioIdResult);
  }

  /**
   * Method under test:
   * {@link ScenarioAxisItemService#loadAxis(long, AxisOrientation)}
   */
  @Test
  void testLoadAxis() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    ArrayList<ScenarioAxisItem> scenarioAxisItemList = new ArrayList<>();
    when(scenarioAxisItemDao.findForScenarioAndOrientation(anyLong(), Mockito.<AxisOrientation>any()))
        .thenReturn(scenarioAxisItemList);

    // Act
    Collection<ScenarioAxisItem> actualLoadAxisResult = (new ScenarioAxisItemService(scenarioAxisItemDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).loadAxis(1L,
                AxisOrientation.ROW);

    // Assert
    verify(scenarioAxisItemDao).findForScenarioAndOrientation(eq(1L), eq(AxisOrientation.ROW));
    assertTrue(actualLoadAxisResult instanceof List);
    assertTrue(actualLoadAxisResult.isEmpty());
    assertSame(scenarioAxisItemList, actualLoadAxisResult);
  }

  /**
   * Method under test:
   * {@link ScenarioAxisItemService#addAxisItem(long, AxisOrientation, EntityReference, Integer, String)}
   */
  @Test
  void testAddAxisItem() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.add(anyLong(), Mockito.<AxisOrientation>any(), Mockito.<EntityReference>any(),
        Mockito.<Integer>any())).thenReturn(false);

    // Act
    Boolean actualAddAxisItemResult = (new ScenarioAxisItemService(scenarioAxisItemDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .addAxisItem(1L, AxisOrientation.ROW, null, 1, "42");

    // Assert
    verify(scenarioAxisItemDao).add(eq(1L), eq(AxisOrientation.ROW), isNull(), eq(1));
    assertFalse(actualAddAxisItemResult);
  }

  /**
   * Method under test:
   * {@link ScenarioAxisItemService#addAxisItem(long, AxisOrientation, EntityReference, Integer, String)}
   */
  @Test
  void testAddAxisItem2() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.add(anyLong(), Mockito.<AxisOrientation>any(), Mockito.<EntityReference>any(),
        Mockito.<Integer>any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualAddAxisItemResult = (new ScenarioAxisItemService(scenarioAxisItemDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .addAxisItem(1L, AxisOrientation.ROW, mock(EntityReference.class), 1, "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioAxisItemDao).add(eq(1L), eq(AxisOrientation.ROW), isA(EntityReference.class), eq(1));
    assertTrue(actualAddAxisItemResult);
  }

  /**
   * Method under test:
   * {@link ScenarioAxisItemService#addAxisItem(long, AxisOrientation, EntityReference, Integer, String)}
   */
  @Test
  void testAddAxisItem3() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.add(anyLong(), Mockito.<AxisOrientation>any(), Mockito.<EntityReference>any(),
        Mockito.<Integer>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualAddAxisItemResult = (new ScenarioAxisItemService(scenarioAxisItemDao, changeLogService))
        .addAxisItem(1L, AxisOrientation.ROW, mock(EntityReference.class), 1, "42");

    // Assert
    verify(scenarioAxisItemDao).add(eq(1L), eq(AxisOrientation.ROW), isA(EntityReference.class), eq(1));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualAddAxisItemResult);
  }

  /**
   * Method under test:
   * {@link ScenarioAxisItemService#removeAxisItem(long, AxisOrientation, EntityReference, String)}
   */
  @Test
  void testRemoveAxisItem() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.remove(anyLong(), Mockito.<AxisOrientation>any(), Mockito.<EntityReference>any()))
        .thenReturn(false);

    // Act
    Boolean actualRemoveAxisItemResult = (new ScenarioAxisItemService(scenarioAxisItemDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .removeAxisItem(1L, AxisOrientation.ROW, null, "42");

    // Assert
    verify(scenarioAxisItemDao).remove(eq(1L), eq(AxisOrientation.ROW), isNull());
    assertFalse(actualRemoveAxisItemResult);
  }

  /**
   * Method under test:
   * {@link ScenarioAxisItemService#removeAxisItem(long, AxisOrientation, EntityReference, String)}
   */
  @Test
  void testRemoveAxisItem2() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.remove(anyLong(), Mockito.<AxisOrientation>any(), Mockito.<EntityReference>any()))
        .thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualRemoveAxisItemResult = (new ScenarioAxisItemService(scenarioAxisItemDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .removeAxisItem(1L, AxisOrientation.ROW, mock(EntityReference.class), "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioAxisItemDao).remove(eq(1L), eq(AxisOrientation.ROW), isA(EntityReference.class));
    assertTrue(actualRemoveAxisItemResult);
  }

  /**
   * Method under test:
   * {@link ScenarioAxisItemService#removeAxisItem(long, AxisOrientation, EntityReference, String)}
   */
  @Test
  void testRemoveAxisItem3() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.remove(anyLong(), Mockito.<AxisOrientation>any(), Mockito.<EntityReference>any()))
        .thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    Boolean actualRemoveAxisItemResult = (new ScenarioAxisItemService(scenarioAxisItemDao, changeLogService))
        .removeAxisItem(1L, AxisOrientation.ROW, mock(EntityReference.class), "42");

    // Assert
    verify(scenarioAxisItemDao).remove(eq(1L), eq(AxisOrientation.ROW), isA(EntityReference.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveAxisItemResult);
  }

  /**
   * Method under test:
   * {@link ScenarioAxisItemService#reorderAxis(long, AxisOrientation, List, String)}
   */
  @Test
  void testReorderAxis() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.reorder(anyLong(), Mockito.<AxisOrientation>any(), Mockito.<List<Long>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ScenarioAxisItemService scenarioAxisItemService = new ScenarioAxisItemService(scenarioAxisItemDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    // Act
    int[] actualReorderAxisResult = scenarioAxisItemService.reorderAxis(1L, AxisOrientation.ROW, new ArrayList<>(),
        "42");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(scenarioAxisItemDao).reorder(eq(1L), eq(AxisOrientation.ROW), isA(List.class));
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualReorderAxisResult);
  }

  /**
   * Method under test:
   * {@link ScenarioAxisItemService#reorderAxis(long, AxisOrientation, List, String)}
   */
  @Test
  void testReorderAxis2() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.reorder(anyLong(), Mockito.<AxisOrientation>any(), Mockito.<List<Long>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ScenarioAxisItemService scenarioAxisItemService = new ScenarioAxisItemService(scenarioAxisItemDao,
        changeLogService);

    // Act
    int[] actualReorderAxisResult = scenarioAxisItemService.reorderAxis(1L, AxisOrientation.ROW, new ArrayList<>(),
        "42");

    // Assert
    verify(scenarioAxisItemDao).reorder(eq(1L), eq(AxisOrientation.ROW), isA(List.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualReorderAxisResult);
  }

  /**
   * Method under test:
   * {@link ScenarioAxisItemService#reorderAxis(long, AxisOrientation, List, String)}
   */
  @Test
  void testReorderAxis3() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.reorder(anyLong(), Mockito.<AxisOrientation>any(), Mockito.<List<Long>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ScenarioAxisItemService scenarioAxisItemService = new ScenarioAxisItemService(scenarioAxisItemDao,
        changeLogService);

    ArrayList<Long> orderedIds = new ArrayList<>();
    orderedIds.add(3L);

    // Act
    int[] actualReorderAxisResult = scenarioAxisItemService.reorderAxis(1L, AxisOrientation.ROW, orderedIds, "42");

    // Assert
    verify(scenarioAxisItemDao).reorder(eq(1L), eq(AxisOrientation.ROW), isA(List.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualReorderAxisResult);
  }

  /**
   * Method under test:
   * {@link ScenarioAxisItemService#reorderAxis(long, AxisOrientation, List, String)}
   */
  @Test
  void testReorderAxis4() {
    // Arrange
    ScenarioAxisItemDao scenarioAxisItemDao = mock(ScenarioAxisItemDao.class);
    when(scenarioAxisItemDao.reorder(anyLong(), Mockito.<AxisOrientation>any(), Mockito.<List<Long>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ScenarioAxisItemService scenarioAxisItemService = new ScenarioAxisItemService(scenarioAxisItemDao,
        changeLogService);

    ArrayList<Long> orderedIds = new ArrayList<>();
    orderedIds.add(1L);
    orderedIds.add(3L);

    // Act
    int[] actualReorderAxisResult = scenarioAxisItemService.reorderAxis(1L, AxisOrientation.ROW, orderedIds, "42");

    // Assert
    verify(scenarioAxisItemDao).reorder(eq(1L), eq(AxisOrientation.ROW), isA(List.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualReorderAxisResult);
  }
}
