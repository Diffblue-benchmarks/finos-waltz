package org.finos.waltz.service.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.aggregate_overlay_diagram.AggregateOverlayDiagramCalloutDao;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramCallout;
import org.finos.waltz.model.aggregate_overlay_diagram.DiagramCalloutCreateCommand;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AggregateOverlayDiagramCalloutServiceDiffblueTest {
  /**
   * Method under test:
   * {@link AggregateOverlayDiagramCalloutService#findByDiagramInstanceId(Long)}
   */
  @Test
  void testFindByDiagramInstanceId() {
    // Arrange
    AggregateOverlayDiagramCalloutDao aggregateOverlayDiagramCalloutDao = mock(AggregateOverlayDiagramCalloutDao.class);
    HashSet<AggregateOverlayDiagramCallout> aggregateOverlayDiagramCalloutSet = new HashSet<>();
    when(aggregateOverlayDiagramCalloutDao.findByDiagramInstanceId(Mockito.<Long>any()))
        .thenReturn(aggregateOverlayDiagramCalloutSet);

    // Act
    Set<AggregateOverlayDiagramCallout> actualFindByDiagramInstanceIdResult = (new AggregateOverlayDiagramCalloutService(
        aggregateOverlayDiagramCalloutDao)).findByDiagramInstanceId(1L);

    // Assert
    verify(aggregateOverlayDiagramCalloutDao).findByDiagramInstanceId(eq(1L));
    assertTrue(actualFindByDiagramInstanceIdResult.isEmpty());
    assertSame(aggregateOverlayDiagramCalloutSet, actualFindByDiagramInstanceIdResult);
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramCalloutService#create(DiagramCalloutCreateCommand)}
   */
  @Test
  void testCreate() {
    // Arrange
    AggregateOverlayDiagramCalloutDao aggregateOverlayDiagramCalloutDao = mock(AggregateOverlayDiagramCalloutDao.class);
    when(aggregateOverlayDiagramCalloutDao.create(Mockito.<DiagramCalloutCreateCommand>any())).thenReturn(1);

    // Act
    Integer actualCreateResult = (new AggregateOverlayDiagramCalloutService(aggregateOverlayDiagramCalloutDao))
        .create(null);

    // Assert
    verify(aggregateOverlayDiagramCalloutDao).create(isNull());
    assertEquals(1, actualCreateResult.intValue());
  }

  /**
   * Method under test:
   * {@link AggregateOverlayDiagramCalloutService#update(AggregateOverlayDiagramCallout)}
   */
  @Test
  void testUpdate() {
    // Arrange
    AggregateOverlayDiagramCalloutDao aggregateOverlayDiagramCalloutDao = mock(AggregateOverlayDiagramCalloutDao.class);
    when(aggregateOverlayDiagramCalloutDao.update(Mockito.<AggregateOverlayDiagramCallout>any())).thenReturn(1);

    // Act
    Integer actualUpdateResult = (new AggregateOverlayDiagramCalloutService(aggregateOverlayDiagramCalloutDao))
        .update(null);

    // Assert
    verify(aggregateOverlayDiagramCalloutDao).update(isNull());
    assertEquals(1, actualUpdateResult.intValue());
  }

  /**
   * Method under test: {@link AggregateOverlayDiagramCalloutService#delete(long)}
   */
  @Test
  void testDelete() {
    // Arrange
    AggregateOverlayDiagramCalloutDao aggregateOverlayDiagramCalloutDao = mock(AggregateOverlayDiagramCalloutDao.class);
    when(aggregateOverlayDiagramCalloutDao.delete(anyLong())).thenReturn(1);

    // Act
    Integer actualDeleteResult = (new AggregateOverlayDiagramCalloutService(aggregateOverlayDiagramCalloutDao))
        .delete(1L);

    // Assert
    verify(aggregateOverlayDiagramCalloutDao).delete(eq(1L));
    assertEquals(1, actualDeleteResult.intValue());
  }
}
