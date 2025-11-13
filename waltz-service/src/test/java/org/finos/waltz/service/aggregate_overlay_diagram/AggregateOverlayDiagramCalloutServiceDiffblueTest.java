package org.finos.waltz.service.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.aggregate_overlay_diagram.AggregateOverlayDiagramCalloutDao;
import org.finos.waltz.model.aggregate_overlay_diagram.AggregateOverlayDiagramCallout;
import org.finos.waltz.model.aggregate_overlay_diagram.DiagramCalloutCreateCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AggregateOverlayDiagramCalloutServiceDiffblueTest {
  /**
   * Test {@link AggregateOverlayDiagramCalloutService#findByDiagramInstanceId(Long)}.
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramCalloutService#findByDiagramInstanceId(Long)}
   */
  @Test
  @DisplayName("Test findByDiagramInstanceId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregateOverlayDiagramCalloutService.findByDiagramInstanceId(Long)"})
  void testFindByDiagramInstanceId() {
    // Arrange
    AggregateOverlayDiagramCalloutDao aggregateOverlayDiagramCalloutDao =
        mock(AggregateOverlayDiagramCalloutDao.class);
    when(aggregateOverlayDiagramCalloutDao.findByDiagramInstanceId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<AggregateOverlayDiagramCallout> actualFindByDiagramInstanceIdResult =
        new AggregateOverlayDiagramCalloutService(aggregateOverlayDiagramCalloutDao)
            .findByDiagramInstanceId(1L);

    // Assert
    verify(aggregateOverlayDiagramCalloutDao).findByDiagramInstanceId(1L);
    assertTrue(actualFindByDiagramInstanceIdResult.isEmpty());
  }

  /**
   * Test {@link AggregateOverlayDiagramCalloutService#create(DiagramCalloutCreateCommand)}.
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramCalloutService#create(DiagramCalloutCreateCommand)}
   */
  @Test
  @DisplayName("Test create(DiagramCalloutCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer AggregateOverlayDiagramCalloutService.create(DiagramCalloutCreateCommand)"
  })
  void testCreate() {
    // Arrange
    AggregateOverlayDiagramCalloutDao aggregateOverlayDiagramCalloutDao =
        mock(AggregateOverlayDiagramCalloutDao.class);
    when(aggregateOverlayDiagramCalloutDao.create(Mockito.<DiagramCalloutCreateCommand>any()))
        .thenReturn(1);

    // Act
    Integer actualCreateResult =
        new AggregateOverlayDiagramCalloutService(aggregateOverlayDiagramCalloutDao).create(null);

    // Assert
    verify(aggregateOverlayDiagramCalloutDao).create(isNull());
    assertEquals(1, actualCreateResult.intValue());
  }

  /**
   * Test {@link AggregateOverlayDiagramCalloutService#update(AggregateOverlayDiagramCallout)}.
   *
   * <p>Method under test: {@link
   * AggregateOverlayDiagramCalloutService#update(AggregateOverlayDiagramCallout)}
   */
  @Test
  @DisplayName("Test update(AggregateOverlayDiagramCallout)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer AggregateOverlayDiagramCalloutService.update(AggregateOverlayDiagramCallout)"
  })
  void testUpdate() {
    // Arrange
    AggregateOverlayDiagramCalloutDao aggregateOverlayDiagramCalloutDao =
        mock(AggregateOverlayDiagramCalloutDao.class);
    when(aggregateOverlayDiagramCalloutDao.update(Mockito.<AggregateOverlayDiagramCallout>any()))
        .thenReturn(1);

    // Act
    Integer actualUpdateResult =
        new AggregateOverlayDiagramCalloutService(aggregateOverlayDiagramCalloutDao).update(null);

    // Assert
    verify(aggregateOverlayDiagramCalloutDao).update(isNull());
    assertEquals(1, actualUpdateResult.intValue());
  }

  /**
   * Test {@link AggregateOverlayDiagramCalloutService#delete(long)}.
   *
   * <p>Method under test: {@link AggregateOverlayDiagramCalloutService#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer AggregateOverlayDiagramCalloutService.delete(long)"})
  void testDelete() {
    // Arrange
    AggregateOverlayDiagramCalloutDao aggregateOverlayDiagramCalloutDao =
        mock(AggregateOverlayDiagramCalloutDao.class);
    when(aggregateOverlayDiagramCalloutDao.delete(anyLong())).thenReturn(1);

    // Act
    Integer actualDeleteResult =
        new AggregateOverlayDiagramCalloutService(aggregateOverlayDiagramCalloutDao).delete(1L);

    // Assert
    verify(aggregateOverlayDiagramCalloutDao).delete(1L);
    assertEquals(1, actualDeleteResult.intValue());
  }
}
