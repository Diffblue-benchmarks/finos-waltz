package org.finos.waltz.service.entity_svg_diagram;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.entity_svg_diagram.EntitySvgDiagramDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.entity_svg_diagram.EntitySvgDiagram;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntitySvgDiagramServiceDiffblueTest {
  /**
   * Method under test:
   * {@link EntitySvgDiagramService#findForEntityReference(EntityReference)}
   */
  @Test
  void testFindForEntityReference() {
    // Arrange
    EntitySvgDiagramDao entitySvgDiagramDao = mock(EntitySvgDiagramDao.class);
    ArrayList<EntitySvgDiagram> entitySvgDiagramList = new ArrayList<>();
    when(entitySvgDiagramDao.findForEntityReference(Mockito.<EntityReference>any())).thenReturn(entitySvgDiagramList);

    // Act
    List<EntitySvgDiagram> actualFindForEntityReferenceResult = (new EntitySvgDiagramService(entitySvgDiagramDao))
        .findForEntityReference(mock(EntityReference.class));

    // Assert
    verify(entitySvgDiagramDao).findForEntityReference(isA(EntityReference.class));
    assertTrue(actualFindForEntityReferenceResult.isEmpty());
    assertSame(entitySvgDiagramList, actualFindForEntityReferenceResult);
  }
}
