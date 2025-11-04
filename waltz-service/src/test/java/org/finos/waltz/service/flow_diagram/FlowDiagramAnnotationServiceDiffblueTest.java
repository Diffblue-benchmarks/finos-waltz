package org.finos.waltz.service.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.flow_diagram.FlowDiagramAnnotationDao;
import org.finos.waltz.model.flow_diagram.FlowDiagramAnnotation;
import org.junit.jupiter.api.Test;

class FlowDiagramAnnotationServiceDiffblueTest {
  /**
   * Method under test: {@link FlowDiagramAnnotationService#findByDiagramId(long)}
   */
  @Test
  void testFindByDiagramId() {
    // Arrange
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    ArrayList<FlowDiagramAnnotation> flowDiagramAnnotationList = new ArrayList<>();
    when(flowDiagramAnnotationDao.findByDiagramId(anyLong())).thenReturn(flowDiagramAnnotationList);

    // Act
    List<FlowDiagramAnnotation> actualFindByDiagramIdResult = (new FlowDiagramAnnotationService(
        flowDiagramAnnotationDao)).findByDiagramId(1L);

    // Assert
    verify(flowDiagramAnnotationDao).findByDiagramId(eq(1L));
    assertTrue(actualFindByDiagramIdResult.isEmpty());
    assertSame(flowDiagramAnnotationList, actualFindByDiagramIdResult);
  }
}
