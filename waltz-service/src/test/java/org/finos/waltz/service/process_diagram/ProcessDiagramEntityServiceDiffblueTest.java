package org.finos.waltz.service.process_diagram;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.process_diagram_entity.ProcessDiagramEntityDao;
import org.finos.waltz.model.process_diagram.ProcessDiagramEntityApplicationAlignment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProcessDiagramEntityServiceDiffblueTest {
  /**
   * Test {@link ProcessDiagramEntityService#findApplicationAlignmentsByDiagramId(Long)}.
   *
   * <p>Method under test: {@link
   * ProcessDiagramEntityService#findApplicationAlignmentsByDiagramId(Long)}
   */
  @Test
  @DisplayName("Test findApplicationAlignmentsByDiagramId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ProcessDiagramEntityService.findApplicationAlignmentsByDiagramId(Long)"})
  void testFindApplicationAlignmentsByDiagramId() {
    // Arrange
    ProcessDiagramEntityDao dao = mock(ProcessDiagramEntityDao.class);
    when(dao.findApplicationAlignmentsByDiagramId(Mockito.<Long>any())).thenReturn(new HashSet<>());

    // Act
    Set<ProcessDiagramEntityApplicationAlignment> actualFindApplicationAlignmentsByDiagramIdResult =
        new ProcessDiagramEntityService(dao).findApplicationAlignmentsByDiagramId(1L);

    // Assert
    verify(dao).findApplicationAlignmentsByDiagramId(1L);
    assertTrue(actualFindApplicationAlignmentsByDiagramIdResult.isEmpty());
  }
}
