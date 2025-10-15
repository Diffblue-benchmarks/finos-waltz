package org.finos.waltz.service.process_diagram;

import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProcessDiagramEntityServiceDiffblueTest {
  @Mock private ProcessDiagramEntityDao processDiagramEntityDao;

  @InjectMocks private ProcessDiagramEntityService processDiagramEntityService;

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
    when(processDiagramEntityDao.findApplicationAlignmentsByDiagramId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<ProcessDiagramEntityApplicationAlignment> actualFindApplicationAlignmentsByDiagramIdResult =
        processDiagramEntityService.findApplicationAlignmentsByDiagramId(1L);

    // Assert
    verify(processDiagramEntityDao).findApplicationAlignmentsByDiagramId(1L);
    assertTrue(actualFindApplicationAlignmentsByDiagramIdResult.isEmpty());
  }
}
