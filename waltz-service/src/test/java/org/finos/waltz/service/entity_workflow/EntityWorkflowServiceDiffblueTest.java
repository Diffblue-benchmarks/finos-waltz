package org.finos.waltz.service.entity_workflow;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.entity_workflow.EntityWorkflowDefinitionDao;
import org.finos.waltz.data.entity_workflow.EntityWorkflowStateDao;
import org.finos.waltz.data.entity_workflow.EntityWorkflowTransitionDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.entity_workflow.EntityWorkflowDefinition;
import org.finos.waltz.model.entity_workflow.EntityWorkflowState;
import org.finos.waltz.model.entity_workflow.EntityWorkflowTransition;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityWorkflowServiceDiffblueTest {
  /**
   * Method under test: {@link EntityWorkflowService#findAllDefinitions()}
   */
  @Test
  void testFindAllDefinitions() {
    // Arrange
    EntityWorkflowDefinitionDao entityWorkflowDefinitionDao = mock(EntityWorkflowDefinitionDao.class);
    ArrayList<EntityWorkflowDefinition> entityWorkflowDefinitionList = new ArrayList<>();
    when(entityWorkflowDefinitionDao.findAll()).thenReturn(entityWorkflowDefinitionList);

    // Act
    List<EntityWorkflowDefinition> actualFindAllDefinitionsResult = (new EntityWorkflowService(
        entityWorkflowDefinitionDao, mock(EntityWorkflowStateDao.class), mock(EntityWorkflowTransitionDao.class)))
            .findAllDefinitions();

    // Assert
    verify(entityWorkflowDefinitionDao).findAll();
    assertTrue(actualFindAllDefinitionsResult.isEmpty());
    assertSame(entityWorkflowDefinitionList, actualFindAllDefinitionsResult);
  }

  /**
   * Method under test:
   * {@link EntityWorkflowService#getStateForEntityReferenceAndWorkflowId(long, EntityReference)}
   */
  @Test
  void testGetStateForEntityReferenceAndWorkflowId() {
    // Arrange
    EntityWorkflowStateDao entityWorkflowStateDao = mock(EntityWorkflowStateDao.class);
    when(entityWorkflowStateDao.getByEntityReferenceAndWorkflowId(anyLong(), Mockito.<EntityReference>any()))
        .thenReturn(null);

    // Act
    EntityWorkflowState actualStateForEntityReferenceAndWorkflowId = (new EntityWorkflowService(
        mock(EntityWorkflowDefinitionDao.class), entityWorkflowStateDao, mock(EntityWorkflowTransitionDao.class)))
            .getStateForEntityReferenceAndWorkflowId(1L, mock(EntityReference.class));

    // Assert
    verify(entityWorkflowStateDao).getByEntityReferenceAndWorkflowId(eq(1L), isA(EntityReference.class));
    assertNull(actualStateForEntityReferenceAndWorkflowId);
  }

  /**
   * Method under test:
   * {@link EntityWorkflowService#findTransitionsForEntityReferenceAndWorkflowId(long, EntityReference)}
   */
  @Test
  void testFindTransitionsForEntityReferenceAndWorkflowId() {
    // Arrange
    EntityWorkflowTransitionDao entityWorkflowTransitionDao = mock(EntityWorkflowTransitionDao.class);
    ArrayList<EntityWorkflowTransition> entityWorkflowTransitionList = new ArrayList<>();
    when(entityWorkflowTransitionDao.findForEntityReferenceAndWorkflowId(anyLong(), Mockito.<EntityReference>any()))
        .thenReturn(entityWorkflowTransitionList);

    // Act
    List<EntityWorkflowTransition> actualFindTransitionsForEntityReferenceAndWorkflowIdResult = (new EntityWorkflowService(
        mock(EntityWorkflowDefinitionDao.class), mock(EntityWorkflowStateDao.class), entityWorkflowTransitionDao))
            .findTransitionsForEntityReferenceAndWorkflowId(1L, mock(EntityReference.class));

    // Assert
    verify(entityWorkflowTransitionDao).findForEntityReferenceAndWorkflowId(eq(1L), isA(EntityReference.class));
    assertTrue(actualFindTransitionsForEntityReferenceAndWorkflowIdResult.isEmpty());
    assertSame(entityWorkflowTransitionList, actualFindTransitionsForEntityReferenceAndWorkflowIdResult);
  }
}
