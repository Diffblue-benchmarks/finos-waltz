package org.finos.waltz.service.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.flow_diagram.FlowDiagramAnnotationDao;
import org.finos.waltz.model.flow_diagram.FlowDiagramAnnotation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlowDiagramAnnotationServiceDiffblueTest {
  /**
   * Test {@link FlowDiagramAnnotationService#findByDiagramId(long)}.
   *
   * <p>Method under test: {@link FlowDiagramAnnotationService#findByDiagramId(long)}
   */
  @Test
  @DisplayName("Test findByDiagramId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowDiagramAnnotationService.findByDiagramId(long)"})
  void testFindByDiagramId() {
    // Arrange
    FlowDiagramAnnotationDao flowDiagramAnnotationDao = mock(FlowDiagramAnnotationDao.class);
    when(flowDiagramAnnotationDao.findByDiagramId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    List<FlowDiagramAnnotation> actualFindByDiagramIdResult =
        new FlowDiagramAnnotationService(flowDiagramAnnotationDao).findByDiagramId(1L);

    // Assert
    verify(flowDiagramAnnotationDao).findByDiagramId(1L);
    assertTrue(actualFindByDiagramIdResult.isEmpty());
  }
}
