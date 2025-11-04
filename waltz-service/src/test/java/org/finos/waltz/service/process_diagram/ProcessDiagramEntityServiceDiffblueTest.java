package org.finos.waltz.service.process_diagram;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.process_diagram_entity.ProcessDiagramEntityDao;
import org.finos.waltz.model.process_diagram.ProcessDiagramEntityApplicationAlignment;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProcessDiagramEntityServiceDiffblueTest {
  /**
   * Method under test:
   * {@link ProcessDiagramEntityService#findApplicationAlignmentsByDiagramId(Long)}
   */
  @Test
  void testFindApplicationAlignmentsByDiagramId() {
    // Arrange
    ProcessDiagramEntityDao dao = mock(ProcessDiagramEntityDao.class);
    HashSet<ProcessDiagramEntityApplicationAlignment> processDiagramEntityApplicationAlignmentSet = new HashSet<>();
    when(dao.findApplicationAlignmentsByDiagramId(Mockito.<Long>any()))
        .thenReturn(processDiagramEntityApplicationAlignmentSet);

    // Act
    Set<ProcessDiagramEntityApplicationAlignment> actualFindApplicationAlignmentsByDiagramIdResult = (new ProcessDiagramEntityService(
        dao)).findApplicationAlignmentsByDiagramId(1L);

    // Assert
    verify(dao).findApplicationAlignmentsByDiagramId(eq(1L));
    assertTrue(actualFindApplicationAlignmentsByDiagramIdResult.isEmpty());
    assertSame(processDiagramEntityApplicationAlignmentSet, actualFindApplicationAlignmentsByDiagramIdResult);
  }
}
