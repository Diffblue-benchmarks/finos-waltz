package org.finos.waltz.service.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.aggregate_overlay_diagram.AggregateOverlayDiagramInstanceDao;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramInstance;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramInstanceCreateCommand;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AggregateOverlayDiagramInstanceServiceDiffblueTest {
  /**
   * Method under test: {@link AggregateOverlayDiagramInstanceService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    AggregateOverlayDiagramInstanceDao aggregateOverlayDiagramInstanceDao = mock(
        AggregateOverlayDiagramInstanceDao.class);
    HashSet<AggregateOverlayDiagramInstance> aggregateOverlayDiagramInstanceSet = new HashSet<>();
    when(aggregateOverlayDiagramInstanceDao.findAll()).thenReturn(aggregateOverlayDiagramInstanceSet);

    // Act
    Set<AggregateOverlayDiagramInstance> actualFindAllResult = (new AggregateOverlayDiagramInstanceService(
        aggregateOverlayDiagramInstanceDao)).findAll();

    // Assert
    verify(aggregateOverlayDiagramInstanceDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(aggregateOverlayDiagramInstanceSet, actualFindAllResult);
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramInstanceService#findByDiagramId(Long)}
   */
  @Test
  void testFindByDiagramId() {
    // Arrange
    AggregateOverlayDiagramInstanceDao aggregateOverlayDiagramInstanceDao = mock(
        AggregateOverlayDiagramInstanceDao.class);
    HashSet<AggregateOverlayDiagramInstance> aggregateOverlayDiagramInstanceSet = new HashSet<>();
    when(aggregateOverlayDiagramInstanceDao.findByDiagramId(Mockito.<Long>any()))
        .thenReturn(aggregateOverlayDiagramInstanceSet);

    // Act
    Set<AggregateOverlayDiagramInstance> actualFindByDiagramIdResult = (new AggregateOverlayDiagramInstanceService(
        aggregateOverlayDiagramInstanceDao)).findByDiagramId(1L);

    // Assert
    verify(aggregateOverlayDiagramInstanceDao).findByDiagramId(eq(1L));
    assertTrue(actualFindByDiagramIdResult.isEmpty());
    assertSame(aggregateOverlayDiagramInstanceSet, actualFindByDiagramIdResult);
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramInstanceService#getById(Long)}
   */
  @Test
  void testGetById() {
    // Arrange
    AggregateOverlayDiagramInstanceDao aggregateOverlayDiagramInstanceDao = mock(
        AggregateOverlayDiagramInstanceDao.class);
    when(aggregateOverlayDiagramInstanceDao.getById(Mockito.<Long>any())).thenReturn(null);

    // Act
    AggregateOverlayDiagramInstance actualById = (new AggregateOverlayDiagramInstanceService(
        aggregateOverlayDiagramInstanceDao)).getById(1L);

    // Assert
    verify(aggregateOverlayDiagramInstanceDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramInstanceService#createInstance(OverlayDiagramInstanceCreateCommand, String)}
   */
  @Test
  void testCreateInstance() {
    // Arrange
    AggregateOverlayDiagramInstanceDao aggregateOverlayDiagramInstanceDao = mock(
        AggregateOverlayDiagramInstanceDao.class);
    when(aggregateOverlayDiagramInstanceDao.createInstance(Mockito.<OverlayDiagramInstanceCreateCommand>any(),
        Mockito.<String>any())).thenReturn(1);

    // Act
    int actualCreateInstanceResult = (new AggregateOverlayDiagramInstanceService(aggregateOverlayDiagramInstanceDao))
        .createInstance(null, "janedoe");

    // Assert
    verify(aggregateOverlayDiagramInstanceDao).createInstance(isNull(), eq("janedoe"));
    assertEquals(1, actualCreateInstanceResult);
  }
}
